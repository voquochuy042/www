package com.example.tuan6.backend.service;
import com.example.tuan6.backend.entities.Post;
import com.example.tuan6.backend.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public Page<Post> findAll(int pageNo, int pageSize, String sortBy, String sortDirection){
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        List<Post> posts = postRepository.findAllByPost(null);
        return postRepository.findAll(pageable);
    }
}
