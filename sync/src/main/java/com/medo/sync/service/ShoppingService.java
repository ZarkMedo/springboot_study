package com.medo.sync.service;

import com.medo.sync.model.entity.Cook;

import java.util.concurrent.ExecutionException;

public interface ShoppingService {
    Cook cookFood() throws ExecutionException, InterruptedException;
}
