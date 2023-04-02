package com.spring.codeblog.service.serviceimpl;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;
import com.spring.codeblog.service.CodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CodeblogServiceImpl implements CodeblogService {

    @Autowired
    private CodeblogRepository codeblogRepository;

    @Override
    public List<Post> findAll() {
        return codeblogRepository.findAll();
    }

    @Override
    public Post findById(long id) {
        Optional<Post> post = codeblogRepository.findById(id);
        return post.orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Post save(Post post) {
        return codeblogRepository.save(post);
    }
}
