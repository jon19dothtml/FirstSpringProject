package com.apuliadigital.corsospring.service;

import com.apuliadigital.corsospring.model.Post;
import com.apuliadigital.corsospring.model.User;
import com.apuliadigital.corsospring.repository.PostRepository;
import com.apuliadigital.corsospring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostByID(int id){
        return postRepository.findById(id).orElse(null);
    }
    public Post createPost(Post post){
        return postRepository.save(post);
    }

    public boolean deletePostById(int id){
        if(postRepository.existsById(id)){
            postRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Post updatePost(int id, Post updatedPost){
        Post post = postRepository.findById(id).orElse(null);
        if(post != null){
            User user = post.getUser();
            updatedPost.setId(id);
            updatedPost.setUser(user);
            return postRepository.save(updatedPost);
        }
        return null;
    }
}
