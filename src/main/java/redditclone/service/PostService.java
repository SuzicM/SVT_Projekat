package redditclone.service;

import java.util.List;

import redditclone.model.dto.PostDTO;
import redditclone.model.entity.Post;

public interface PostService {

    List<PostDTO> findAllPosts();

    List<PostDTO> findPostsOfCommunity(String name);

    Post createPost(PostDTO postDTO);

    void deleteByTitle(String title);

}
