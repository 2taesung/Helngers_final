package com.ssafy.hellingers.model;

//import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
//import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data // getter, setter...
@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickname", nullable = false)
    private String nickname;

//    @Enumerated(EnumType.STRING)
//    @Column(name = "categories", nullable = false)
//    private String categories;

    @ColumnDefault("0")
    @Column(name = "count")
    private int count;

    @ColumnDefault("0")
    @Column(name = "comment_count")
    private int comment_count;

    @ColumnDefault("1")
    @Column(name = "level")
    private int level;

    @Column(name = "introduce")
    private String introduce;

    @ColumnDefault("0")
    @Column(name = "point")
    private Integer point;

    @Column(name = "period")
    private Integer period;

    @Column(name = "purpose")
    private Integer purpose;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

}
