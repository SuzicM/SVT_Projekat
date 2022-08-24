package redditclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redditclone.service.PostService;

@CrossOrigin
@RestController
@RequestMapping("api/post")
public class PostController {

    @Autowired
    private PostService postService;

}
