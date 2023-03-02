package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.annotation.Logger;
import org.example.entity.Human;
import org.example.repository.HumanRepository;
import org.example.service.HumanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HumanServiceImpl implements HumanService {
    private final HumanRepository humanRepository;

    @Override
    public List<Human> findHumansByAge(int age){
        return humanRepository.findAllByAge(age);
    }

    @Override
    @Logger
    public List<Human> findHumansByName(String name){
        return humanRepository.findAllByName(name);
    }
}
