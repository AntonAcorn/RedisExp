package ru.acorn.redisexp.repository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import ru.acorn.redisexp.model.Movie;

import java.util.Map;

@Repository
@RequiredArgsConstructor
public class RedisRepositoryImpl implements RedisRepository {
    private static final String KEY = "Movie";
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public Map<Object, Object> findAllMovies() {
        return hashOperations.entries(KEY);
    }

    @Override
    public void add(Movie movie) {
        hashOperations.put(KEY, movie.getId(), movie);
    }

    @Override
    public void delete(String id) {
        hashOperations.delete(KEY, id);
    }

    @Override
    public Movie findMovie(String id) {
        return (Movie) hashOperations.get(KEY, id);
    }
}
