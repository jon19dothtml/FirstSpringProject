package com.apuliadigital.corsospring.repository;

import com.apuliadigital.corsospring.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
