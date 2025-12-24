package com.example.Cards.controller;


import com.example.Cards.constants.CardsConstants;
import com.example.Cards.dto.ResponseDto;
import com.example.Cards.service.ICardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @Autowired
    private ICardsService cardsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> CreateCard(String mobileNumber) {

        cardsService.createCard(mobileNumber);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(CardsConstants.STATUS_201, CardsConstants.MESSAGE_201));

    }

}
