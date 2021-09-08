package com.jojoidu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//보통 ibatis, MyBatis 등에서 Dao라고 불리는 DB Layer 접근자입니다.
//JPA 에선 Repository라고 부르며 인터페이스로 생성합니다.
//인터페이스를 생성후 JpaRepository<Entity클래스 , PK타입>을 상속하면 기본적인 CRUD 메소드가 자동으로 생성된다.
//주의할점은 Entity클래스와 기본 Entity Repository는 함께 위치해야하는점이다. Entity클래스는 기본 RePosityory 없이는 제대로 역할을 할수가없다.
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
