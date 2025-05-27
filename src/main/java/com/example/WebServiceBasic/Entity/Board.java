package com.example.WebServiceBasic.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)  //JPA Entity 에 이벤트가 발생할 관련 코드를 실행
public class Board {
    @Id
    @GeneratedValue
    Long idx;

    @Column
    String bid;

    @Column
    String title;

    @Column
    String name;

    @Column
    String content;

    @Column
    String password;

    @Column(nullable = true, updatable = false)
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @CreatedDate
    LocalDateTime createdDate;

    @Column(nullable = true)
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @LastModifiedDate
    LocalDateTime modifiedDate;

}
