package com.ssafy.hellingers.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.hellingers.model.BoardAttach;
import com.ssafy.hellingers.service.BoardService;
import com.ssafy.hellingers.util.MediaUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/file")
public class FileController {
	
	private static final Logger log = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/fileDownload")
	public void fileDownload(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> paramMap) throws Exception {
		Integer fileNo = Integer.parseInt( paramMap.get("fileNo") );
		Integer boardNo = Integer.parseInt( paramMap.get("boardNo") );
		
		BoardAttach attach = new BoardAttach();
		attach.setFileNo(fileNo);
		attach.setBoardNo(boardNo);
		
		attach = service.readFile(attach);
		String fullName = attach.getFullName();						// ?????? ????????????
		String fileName = attach.getFileName();						// ?????????
		
		//???????????? ??? ??????
		
		File file = new File(fullName);
		
		FileInputStream fileInputStream = null;
	    ServletOutputStream servletOutputStream = null;
	
	    try{
	        String downName = null;
	        String browser = request.getHeader("User-Agent");
		    //?????? ?????????
		    if(browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")){//???????????? ?????? ????????? encode  
		    	downName = URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+", "%20");
		    }else{
		        downName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		    }
		    
		    response.setHeader("Content-Disposition","attachment;filename=\"" + downName+"\"");
		    response.setContentType("text/html");
		    response.setHeader("Content-Transfer-Encoding", "binary;");
	 	 
		    fileInputStream = new FileInputStream(file);
		    servletOutputStream = response.getOutputStream();
	 	 
		    byte b [] = new byte[1024];
		    int data = 0;
	 	 
		    while((data=(fileInputStream.read(b, 0, b.length))) != -1){
		        servletOutputStream.write(b, 0, data);
		    }
	    
		    servletOutputStream.flush();//??????
	        
	    }catch (Exception e) {
	        e.printStackTrace();
	    }finally{
	        if(servletOutputStream!=null){
	            try{
	                servletOutputStream.close();
	            }catch (IOException e){
	                e.printStackTrace();
	            }
	        }
	        if(fileInputStream!=null){
	            try{
	                fileInputStream.close();
	            }catch (IOException e){
	                e.printStackTrace();
	            }
	        }
	    }
	}
	
	@GetMapping("/zipDownload")
	public void zipDownload(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> paramMap) throws Exception {
		//??? ?????? 
		
		Integer boardNo = Integer.parseInt(paramMap.get("boardNo"));
		//??? ??????
		String title = paramMap.get("title");
		// ??? ????????? ?????? ?????? ???????????? ????????? ??????
		List<BoardAttach>fileList = service.readFileList(boardNo); 
		//???????????? ?????? ???
		String zipFile = "temp.zip";
		String downloadFileName = title;
		//?????? ?????????
		String browser = request.getHeader("User-Agent");
		if(browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")){//???????????? ?????? ????????? encode  
		   downloadFileName = URLEncoder.encode(downloadFileName,"UTF-8").replaceAll("\\+", "%20");
		    
		}else{
		   downloadFileName = new String(downloadFileName.getBytes("UTF-8"), "ISO-8859-1");
		}
		  
		  try {
		     
		     FileOutputStream fout = new FileOutputStream(zipFile);
		     ZipOutputStream zout = new ZipOutputStream(fout);
		     
		     for (int i = 0; i < fileList.size(); i++) {
		        
			        // ?????? ????????? ??????, ???????????? ??????????????? ?????? new File???
				    ZipEntry zipEntry = new ZipEntry(new File(fileList.get(i).getFileName()).getName());
				    zout.putNextEntry(zipEntry);
				    
				    FileInputStream fin = new FileInputStream(fileList.get(i).getFullName());
				    byte[] buffer = new byte[1024];
				    int length;
			    
			    
				    while( (length = fin.read(buffer)) > 0 ) {
				       zout.write(buffer, 0 ,length);
				    }
			    
			    zout.closeEntry();
			    fin.close();
			}
		 
			 zout.close();
			 
			 response.setContentType("application/zip");
			 response.addHeader("Content-Disposition", "attachment; filename=" + downloadFileName + ".zip");
			     
			     FileInputStream fis = new FileInputStream(zipFile);
			     BufferedInputStream bis = new BufferedInputStream(fis);
			     ServletOutputStream so = response.getOutputStream();
			     BufferedOutputStream bos = new BufferedOutputStream(so);
			     
			     byte[] data = new byte[2048];
			     int input = 0;
			     
			     while( (input=bis.read(data)) != -1 ) {
			        bos.write(data, 0, input);
			        bos.flush();
			     }
			     
			     if(bos != null) bos.close();
			     if(bis != null) bis.close();
			     if(so != null) so.close();
			     if(fis != null) fis.close();
			           
			     
			  } catch (Exception e) {
			     e.printStackTrace();
			  }
	}	
	
	/**
	 * ?????? ?????? ??????
	 * @param fileNo
	 * @param fullName
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/deleteFile")
	public Boolean deleteFile(Integer fileNo, String fullName) throws Exception {
		
		File file = new File(fullName);
		
		// ????????? ????????? ??????????????? ??????
		if( file.exists() ) {
			if( file.delete() ) {
				log.info("????????? ?????? : " + fullName);
				log.info("???????????? ??????!!");
				service.deleteFile(fileNo);
				
				// ?????? ?????? ??????
				return true;
			} else {
				log.info("???????????? ??????!!");
			}
			
		} else {
			log.info("??????(??????) : " + fullName);
			log.info("????????? ???????????? ????????????");
		}
		
		// ?????? ?????? ??????
		return false;
	}
	
	/**
	 * ????????? ???????????? (?????????)
	 * @param fullName
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/image")
	public ResponseEntity<byte[]> displayFile(String fullName) throws Exception {
		InputStream in = null;
		ResponseEntity<byte[]> entity = null;
		
		log.info("FILE NAME: " + fullName);
		
		try {
			String formatName = fullName.substring(fullName.lastIndexOf(".") + 1);
			log.info("FILE FORMAT: " + formatName);
			
			MediaType mType = MediaUtils.getMediaType(formatName);
			
			HttpHeaders headers = new HttpHeaders();
			
			in = new FileInputStream(fullName);
			
			if( mType != null) {
				headers.setContentType(mType);
			} else {
				fullName = fullName.substring(fullName.lastIndexOf("_") + 1);
				headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
				headers.add("Content-Disposition", "attachment; fullName=\"" + new String(fullName.getBytes("UTF-8"), "ISO-8859") + "\"");
			}
			
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
			
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}
		return entity;
	}
}
