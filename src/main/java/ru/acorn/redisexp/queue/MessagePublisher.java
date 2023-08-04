package ru.acorn.redisexp.queue;

public interface MessagePublisher {
    void publish(final String message);
}
