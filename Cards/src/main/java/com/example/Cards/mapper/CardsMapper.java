package com.example.Cards.mapper;


import com.example.Cards.dto.CardsDto;
import com.example.Cards.entity.Cards;

public class CardsMapper {

    public static CardsDto mapToCardsDto( Cards cards) {
        CardsDto cardsDto = new CardsDto();
        cardsDto.setCardNumber(String.valueOf(cards.getCardNumber()));
        cardsDto.setCardType(String.valueOf(cards.getCardType()));
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setTotalLimit(cards.getTotalLimit());
        cardsDto.setAmountUsed(cards.getAmountUsed());
        cardsDto.setAmountUsed(cards.getAmountUsed());
        cardsDto.setMobileNumber(cards.getMobileNumber());

        return cardsDto;

    }

    public static Cards mapToCards(Cards cards, CardsDto cardsDto) {


        cards.setCardNumber(cardsDto.getCardNumber());
        cards.setCardType(cardsDto.getCardType());
        cards.setCardType(cardsDto.getCardType());
        cards.setTotalLimit(cardsDto.getTotalLimit());
        cards.setAmountUsed(cardsDto.getAmountUsed());
        cards.setAmountUsed(cardsDto.getAmountUsed());
        cards.setMobileNumber(cardsDto.getMobileNumber());
        return cards;
    }
}
