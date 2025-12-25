package com.example.Cards.service;

import com.example.Cards.dto.CardsDto;

public interface ICardsService {

    void createCard(String mobileNumber);

    CardsDto fetchCard(String mobileNumber);


    boolean updateCard(CardsDto cardsDto);

//    /**
//     *
//     * @param mobileNumber - Input Mobile Number
//     * @return boolean indicating if the delete of card details is successful or not
//     */
//    boolean deleteCard(String mobileNumber);

}
