package com.etiya.exampleservice.logging;

public interface CrossCuttingConcerns {
    void log(String message);
    void cache(String key, Object obj);
    boolean auth();
}
