package org.example.repository;

import org.example.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HumanRepository extends JpaRepository<Human, Long> {

    List<Human> findAllByAge(int age);

    List<Human> findAllByName(String name);
}
