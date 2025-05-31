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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long idx;

    //@Column
    //private String bid;
    //ManyToOne // 이 엔티티(Comment)와 부모 엔티티(Article)를 다대일 관계로 설정
    //@JoinColumn(name = "bid") // 외래키 생성, board 엔티티의 기본키(bid)와 매핑
    private String bid;

    @Column
    private String title;

    @Column
    private String name;

    @Column
    private String content;

    @Column(updatable = false)
    private String password;

    @Column(nullable = true, updatable = false)
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @CreatedDate
    private LocalDateTime createdDate;

    @Column(nullable = true)
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
