package redditclone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import redditclone.model.dto.CommunityDTO;
import redditclone.model.entity.Community;
import redditclone.service.CommunityService;

@CrossOrigin
@RestController
@RequestMapping("api/community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Community>> findAllCommunities() {
        return new ResponseEntity<>(communityService.findAllCommunities(), HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = "application/json")
    public ResponseEntity<Community> saveCommunity(@RequestBody CommunityDTO communityDTO) {
        Community newCommunity = communityService.createCommunity(communityDTO);
        return new ResponseEntity<>(newCommunity, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{name}/")
    public ResponseEntity<CommunityDTO> findCommunityByName(@PathVariable("name") String name) {
        CommunityDTO community = communityService.findCommunityByName(name);
        return new ResponseEntity<>(community, HttpStatus.OK);
    }


    @PutMapping(value = "/{name}/", consumes = "application/json")
    public ResponseEntity<Community> updateCommunity(@RequestBody CommunityDTO community, @PathVariable("name") String oldName) {
        return new ResponseEntity<>(communityService.updateCommunity(community, oldName), HttpStatus.OK);
    }

}
