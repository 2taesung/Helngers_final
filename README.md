# Do Challenge, Be Healthy! Helngers 





## πIndex

#### Introduction

- [What is Helngers?](#π©-What-is-Helngers?)
- [Project Intro](#π©-Project-Intro)
- [ERD & Component](#π-ERD-&-Component-structure)
- [UI Design](#π¨-UI-Design)

#### Features



#### Documents

- [Issues](#π¬-Issues)



## π© What is Helngers?

> **μ΄λμ μ²μ μμνλ μ¬λλ€**μ΄ λͺ©νλ₯Ό μΈμ°κ³  μ§ννλ©°, κΎΈμ€ν μ§νν  μ μλλ‘ μ΄λμ΄μ£Όλ **ν¬μ€ μΌμ΄ SNS μλΉμ€**

- λ§€μΌ κ°±μ λλ μ±λ¦°μ§λ₯Ό λ¬μ±νλ©° μ΄λμ κΎΈμ€ν μ§νν΄ λ³΄μΈμ.
- λΉμ·ν μ€λ ₯μ μ¬λλ€κ³Ό μν΅νλ©° μ΄λμ μ§νν΄ λ³΄μΈμ.
- μ½μΉλ€μ ν κ²μκΈμ ν΅ν΄ μ΄λ μ λ³΄λ₯Ό λ°μλ³΄μΈμ.
- μ΄λ λΆμμ λ°λΌ λ°μ μ μλ λ©λ¬μ λͺ¨μ μ±μ₯νλ μμ μ νμΈν΄λ³΄μΈμ.



## π© Project Intro

- μ§ν κΈ°κ°: 2021. 07. 05 ~ 2021. 08. 20
- νλ‘μ νΈ μ μ  λ°°κ²½
- λͺ©ν
  - νλ£¨μ© λ³κ²½λλ μ±λ¦°μ§ κΈ°λ₯(νλ£¨ λμ  κ³Όμ )
  - μ΄λν μμ­λ³λ‘ μ±μμ§λ λ©λ¬
  - μ΄λ κΈ°λ‘μ λ¨κΈΈ μ μμΌλ©° λΉμ·ν μ¬λλ€κ³Ό μν΅νλ SNSκΈ°λ₯
  - λΉμ·ν μ€λ ₯μλΌλ¦¬ μΆμ²ν΄μ£Όλ μΉκ΅¬ μΆμ² νλ μ΄ν μμ€ν





## π ERD & Component structure

![](./images/README/002.png)

![](./images/README/003.png)



## π¨ UI Design

*Figma μ¬μ© / [UI λ³΄λ¬κ°κΈ°](https://www.figma.com/file/IHWkQyXMkvZwEM1JWKrzQ3/%EC%8B%B8%ED%94%BC-2%ED%95%99%EA%B8%B0-%EB%B6%80%ED%8A%B8%EC%BA%A0%ED%94%84?node-id=0%3A1)*

![](./images/README/005_1.png)

![](./images/README/005_2.png)

![](./images/README/005_3.png)



## π§ Features

### 1. Signup

νμ κ°μμ νμν νμ νμ μ λ³΄λ email, password, nicknameμ΄λ©°, μκΈ°μκ° λ±μ λ€λ₯Έ μ λ³΄λ€μ μΆκ°μ μΌλ‘ λ°κ²λ©λλ€. λ°λΌμ νμ μ λ³΄μ λ΄μ λͺ¨λ  λ°μ΄ν°λ₯Ό `User Entity`μ λ΄μμ€λλ€. νμ κ°μμ νμμ μ λ³΄λ₯Ό μ μ‘νμ¬ μμ²­νλ λ¨κ³μλλ€. UserDtoλ₯Ό ν΅ν΄ λ°μ΄ν° κ°μ²΄λ₯Ό λ§λ€μ΄ νλΌλ―Έν°λ‘ μ¬μ©νμμΌλ©°, Dtoλ₯Ό λ°μΌλ©΄ Email, Nicknameμ΄ DBμμ λ€λ₯Έ νμ μ λ³΄μ κ²ΉμΉμ§ μλμ§ userServiceλ₯Ό ν΅ν΄ νμΈν©λλ€. κ²ΉμΉμ§ μλλ€λ©΄ μ μ  λ°μ΄ν°λ₯Ό μ μ₯ν©λλ€. μ μ₯ ν ν΄λΉ User dataλ₯Ό λΆλ¬μμ λ¦¬ν΄ν΄μ£Όλ©΄, νμ κ°μμ μ§μ  μλ ₯ν΄μ€ κ° μΈ λ€λ₯Έ κ°λ€μ΄ μ λλ‘ λ€μ΄κ°λμ§ νμΈν  μ μμ΅λλ€.


### 2. Login

μ¬μ©μκ° λ‘κ·ΈμΈμ μλνλ©΄ μ°μ  νλΌλ―Έν°λ‘ λ°μμ¨ userμ λ³΄λ₯Ό userServiceμ login methodλ₯Ό ν΅ν΄ λ‘κ·ΈμΈμ μμΌμ£Όκ³ , λ‘κ·ΈμΈ λ μ μ μ μ λ³΄λ₯Ό λ°μμ€λλ‘ ν©λλ€. λ€μμΌλ‘ λ‘κ·ΈμΈν μ μ μ JWTλ₯Ό λ§λ€μ΄ λ°νν΄μ€λλ€.

λ‘κ·ΈμΈ λ©μλλ, μλ ₯ν Emailμ κ°λ μ μ  μ λ³΄κ° μλμ§ νμΈν ν, DBμ μ μ₯λ ν¨μ€μλκ° νλΌλ―Έν°λ‘ λ°μ ν¨μ€μλμ μΌμΉνλμ§ νμΈν©λλ€. μΌμΉνλ©΄ Userλ°μ΄ν°λ₯Ό λ°ν, κ·Έλ μ§ μμΌλ©΄ μΌμΉνλ μμ΄λλ λΉλ°λ²νΈκ° μ‘΄μ¬νμ§ μλ€λ λ¬Έκ΅¬λ₯Ό λ°νν©λλ€.


### 3. Challenges

νλ£¨ λμ  μ±λ¦°μ§λ λ¬΄μμλ‘ 5κ°λ₯Ό μ μ ν΄μ€λλ€. μμ λ§λ€ 5κ°μ© λλ€μΌλ‘ μ μ λμ΄ μ μ μκ² λ°°μ μ΄ λ©λλ€. μ΄λ μΏΌλ¦¬λ¬Έμμ `select`, `insert`λ₯Ό μ¬μ©νμ¬ λ‘μ§μ μ€μ ν΄μ£Όμκ³ , μ΄ μΏΌλ¦¬λ¬Έμ λ§€νΌλ‘ λ±λ‘ν΄μ€¬μ΅λλ€. μ»¨νΈλ‘€λ¬μμ νλΌλ―Έν°λ₯Ό μ΄μ©νμ¬ μΏΌλ¦¬λ¬Έμ λ³μλ₯Ό λκ²¨μ£Όμ΄ μ¬μ©ν  μ μλλ‘ μ€μ ν΄μ£Όμμ΅λλ€.


### λ°°ν¬

π[Helngers](i5c206.p.ssafy.io)

AWS(EC2) μλ²λ‘ λ°°ν¬νμλ€.

### λ°°ν¬

π[Helngers](i5c206.p.ssafy.io)

AWS(EC2) μλ²λ‘ λ°°ν¬νμλ€.



## π¬ Issues

### Tech Stack

<details>
    <summary>FronEnd Tech Stack</summary>
    <ul>
        <li>Vue: </li>
        <li>Vue / CLI: </li>
        <li>Vuex: </li>
        <li>npm: </li>
        <li>axios: </li>
    </ul>
</details>
<details>
    <summary>BackEnd Tech Stack</summary>
    <ul>
        <li>Swagger</li>
        <li>Spring Boot</li>
        <li>JavaMailSender</li>
        <li>MySQL</li>
        <li>NGINX</li>
        <li>E2C</li>
    </ul>
</details>
<details>
    <summary>ETC</summary>
    <ul>
        <li>Json Web Token</li>
        <li>Github</li>
        <li>GitLab</li>
        <li>Jira</li>
        <li>Webex</li>
        <li>Discord</li>
    </ul>
</details>



### Contributor

|  μ΄λ¦  |   μ­ν λΆλ΄    |
| :----: | :-----------: |
| λ°ν¨μ§ | BackEnd repo  |
| μ΄νμ± | FrontEnd repo |
| μ κ·μ | BackEnd repo  |
| μ μκ·Ό | FrontEnd repo |
| μ‘°μν | BackEnd repo  |



#### λ°ν¨μ§(Park HyoJin)

> β¨[Github_HyojinPark1223](https://github.com/HyojinPark1223)

- Team Leader
- Backend
- Server
- Database
- UCC
- Design
- AWS



#### μ΄νμ±(Lee TaeSung)

> β¨[Github_2taesung](https://github.com/2taesung)

- Frontend
- Client
- Design



#### μ κ·μ(Jeong KyuWon)

> β¨[Github_radio959](https://github.com/radio959)

- Backend
- Server
- Database
- Meeting Recorder
- Presentation



#### μ μκ·Ό(Jeong SangGeun)

> β¨[Github_toproot](https://github.com/toproot)

- Frontend
- Client
- Notion
- Design
- Presentation



#### μ‘°μν(Cho YangHoon)

> β¨[Github_Soliloquiess](https://github.com/Soliloquiess)

- Backend
- Server
- Database





### Bug & Problem

β Code Mail νμμ htmlλ‘ λ³κ²½νκΈ°

β `SQL.xml` mapper μ°κ²°(λ§μ΄λ°ν°μ€ μ€μ )

β¬ μ λ¬Έ κ²μνμ λ°λ‘ μμ±νκΈ°
