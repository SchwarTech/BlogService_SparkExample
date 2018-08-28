package me.tomassetti.model;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class JeffModel implements Model {
    @Override
    public UUID createPost(String title, String content, List<String> categories) {
        return null;
    }

    @Override
    public UUID createComment(UUID post, String author, String content) {
        return null;
    }

    @Override
    public List<Post> getAllPosts() {
        return null;
    }

    @Override
    public List<Comment> getAllCommentsOn(UUID post) {
        return null;
    }

    @Override
    public boolean existPost(UUID post) {
        return false;
    }

    @Override
    public Optional<Post> getPost(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public void updatePost(Post post) {

    }

    @Override
    public void deletePost(UUID uuid) {

    }
}
