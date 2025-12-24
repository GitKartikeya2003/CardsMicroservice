package com.example.Cards.repository;


import com.example.Cards.dto.CardsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardsRepository extends JpaRepository<CardsDto,String> {


}
