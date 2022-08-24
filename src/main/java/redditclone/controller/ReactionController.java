package redditclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redditclone.service.ReactionService;

@CrossOrigin
@RestController
@RequestMapping("api/reaction")
public class ReactionController {

    @Autowired
    private ReactionService reactionService;

}
