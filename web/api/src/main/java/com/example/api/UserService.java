package com.example.api;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String getName(String userName);
    String getPassword(String name);
}
