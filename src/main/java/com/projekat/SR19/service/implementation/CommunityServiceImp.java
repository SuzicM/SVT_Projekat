package com.projekat.SR19.service.implementation;

import com.projekat.SR19.model.entity.Community;
import com.projekat.SR19.repository.CommunityRepository;
import com.projekat.SR19.service.CommunityService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommunityServiceImp implements CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    @Override
    public List<Community> findAllComm() {
        return this.communityRepository.findAll();
    }

    @Override
    public Community get(Long id) {
        return null;
    }

    @Override
    public Community update(Community community) {
        return null;
    }

    @Override
    public Boolean suspendCommunity(Long id) {
        return null;
    }
}
