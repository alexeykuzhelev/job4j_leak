package ru.job4j.gc.leak;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import ru.job4j.gc.leak.models.Post;

public class PostStore {

    private final Map<Integer, Post> posts = new HashMap<>();

    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    public Post add(Post post) {
        var id = atomicInteger.getAndIncrement();
        post.setId(id);
        posts.put(id, post);
        return post;
    }

    public void removeAll() {
        posts.clear();
    }

    public Collection<Post> getPosts() {
        return posts.values();
    }
}
