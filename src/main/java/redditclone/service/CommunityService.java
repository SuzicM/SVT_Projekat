package redditclone.service;

import java.util.List;

import redditclone.model.dto.CommunityDTO;
import redditclone.model.entity.Community;

public interface CommunityService {

    List<Community> findAllCommunities();

    Community createCommunity(CommunityDTO communityDTO);

    CommunityDTO findCommunityByName(String name);

    Community updateCommunity(CommunityDTO communityDTO, String oldName);

}
