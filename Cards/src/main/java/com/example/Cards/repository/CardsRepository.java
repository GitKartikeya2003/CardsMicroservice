package com.example.Cards.repository;


import com.example.Cards.dto.CardsDto;
import com.example.Cards.entity.Cards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardsRepository extends JpaRepository<Cards,String> {

    Optional<Cards> findCardsByMobileNumber(String mobileNumber);


}
