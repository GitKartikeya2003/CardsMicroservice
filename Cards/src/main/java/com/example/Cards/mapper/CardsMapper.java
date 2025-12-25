package com.example.Cards.mapper;


import com.example.Cards.dto.CardsDto;
import com.example.Cards.entity.Cards;

public class CardsMapper {

public static CardsDto mapToCardsDto(Cards cards){
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
}
