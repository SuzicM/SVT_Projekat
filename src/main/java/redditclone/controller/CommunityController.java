package redditclone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redditclone.service.CommunityService;

@CrossOrigin
@RestController
@RequestMapping("api/community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

}
