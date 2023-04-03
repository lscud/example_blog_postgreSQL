package com.spring.codeblog.controller;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.service.CodeblogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CodeblogController {

    @Autowired
    private CodeblogService codeblogService;

    @GetMapping(value = "/posts")
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts"); //MVN ->model view anda controller. model -> Post, view -> pagina html, controller -> CodeblogController
        List<Post> posts = codeblogService.findAll();
        mv.addObject("list_posts", posts);  //quando for acessar a view la no html para renderizar, vou buscar essa palavra posts (atributo), porque dentro dessa palavra estarão meus posts;
        return mv;

    }

    @GetMapping(value = "/posts/{id}")
    public ModelAndView getPostDetails(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("postDetail"); //MVN ->model view anda controller. model -> Post, view -> pagina html, controller -> CodeblogController
        Post post = codeblogService.findById(id);
        mv.addObject("post", post);  //quando for acessar a view la no html para renderizar, vou buscar essa palavra posts (atributo), porque dentro dessa palavra estarão meus posts;
        return mv;

    }
}
