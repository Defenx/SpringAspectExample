package org.example.service;

import org.example.entity.Human;

import java.util.List;

public interface HumanService {
    List<Human> findHumansByAge(int age);

    List<Human> findHumansByName(String name);
}
