package com.jojoidu.book.springboot.domain.posts;

import com.jojoidu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Entity 메서드에서는 절대 Setter 메서드를 만들지않는다.
@Getter //롬복의 어노테이션
@NoArgsConstructor //롬복의 어노테이션
@Entity //JPA의 어노테이션 (테이블과 링크될 클래스임을 나타냄)
public class Posts extends BaseTimeEntity { //실제 DB의 테이블과 매칭될 클래스 (Entity 클래스)

    @Id //PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당클래스의 빌더 패턴 클래스를 생성 (생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함)
    public Posts(String title, String content, String author) {
        this.title = title; this.content = content; this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
