package com.projekat.SR19.service;

import com.projekat.SR19.model.entity.Community;

import java.util.List;

public interface CommunityService {
    List<Community> findAllComm();
    Community get(Long id);
    Community update (Community community);
    Boolean suspendCommunity (Long id);
}
