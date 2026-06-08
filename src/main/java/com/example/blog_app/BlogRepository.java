package com.example.blog_app;

import java.util.List;
import java.util.Optional;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BlogRepository {
  private final JdbcClient jdbcClient;

  public BlogRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  public List<Blog> findAll() {
    return jdbcClient.sql("SELECT id, title, content FROM blogs")
        .query(Blog.class)
        .list();
  }

  // 現状データベース接続はせず、リストを作成して返すからこれ
  // return List.of(
  // new Blog("a","神"),
  // new Blog("b","あいと"),
  // new Blog("c","西山さん")
  // );
  public Optional<Blog> findById(Long id){
    return jdbcClient.sql("SELECT id, title, content FROM blogs WHERE id = :id")
        .param("id",  id)
        .query(Blog.class)
        .optional();
  }
}
