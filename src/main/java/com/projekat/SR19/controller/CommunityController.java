package com.projekat.SR19.controller;

import com.projekat.SR19.model.entity.Community;
import com.projekat.SR19.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reddit/community")
public class CommunityController {

    @Autowired
    CommunityService communityService;

    @RequestMapping("/all")
    public List<Community> loadAllComm(){
        return this.communityService.findAllComm();
    }
}
