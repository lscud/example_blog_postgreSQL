package com.spring.codeblog.util;

import ch.qos.logback.classic.spi.LoggerRemoteView;
import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeblogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DummyData {

    @Autowired
    private CodeblogRepository codeblogRepository;

    //@PostConstruct //tudo que eu colocar aqui dentro deste metodo sera executado conforme nossa aplicação for subindo
    public void savePosts(){
        List<Post> postList = new ArrayList<>();

        Post post1 = new Post();
        post1.setAuthor("Michelli Brito");
        post1.setDate(LocalDate.now());
        post1.setTitle("Dcoker");
        post1.setTexto("Lorem ipsum dolor sit amet, consectetur adipisicing elit. A aspernatur commodi consequatur, doloribus dolorum eius eum hic illo ipsam iste itaque nemo officiis placeat quasi rem sapiente unde voluptate. Praesentium!");

        Post post2 = new Post();
        post2.setAuthor("Michelli Brito");
        post2.setDate(LocalDate.now());
        post2.setTitle("API REST");
        post2.setTexto("Lorem ipsum dolor sit amet, consectetur adipisicing elit. A aspernatur commodi consequatur, doloribus dolorum eius eum hic illo ipsam iste itaque nemo officiis placeat quasi rem sapiente unde voluptate. Praesentium!");

//        postList.addAll(Arrays.asList(post1, post2));
        postList.add(post1);
        postList.add(post2);
        for (Post post : postList){
            Post postSaved = codeblogRepository.save(post);
            System.out.println(postSaved.getId());
        }

    }
}
