package com.example.Cards.controller;


import com.example.Cards.constants.CardsConstants;
import com.example.Cards.dto.CardsDto;
import com.example.Cards.dto.ResponseDto;
import com.example.Cards.service.ICardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CardsController {

    @Autowired
    private ICardsService cardsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> CreateCard(@RequestParam String mobileNumber) {

        cardsService.createCard(mobileNumber);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDto(CardsConstants.STATUS_201, CardsConstants.MESSAGE_201));

    }

    @GetMapping("/fetch")
    public ResponseEntity<CardsDto> fetchAccount(@RequestParam String mobileNumber) {

        CardsDto dto = cardsService.fetchCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }


    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCard(@RequestBody CardsDto cardsDto) {
        boolean cardFound = cardsService.updateCard(cardsDto);

        if (cardFound) {

            return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));

        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto(CardsConstants.STATUS_500, CardsConstants.MESSAGE_500));
        }

    }


    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCard(@RequestParam String mobileNumber) {
        boolean isDeleted = cardsService.deleteCard(mobileNumber);
        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto(CardsConstants.STATUS_500, CardsConstants.MESSAGE_500));
        }

    }


}
