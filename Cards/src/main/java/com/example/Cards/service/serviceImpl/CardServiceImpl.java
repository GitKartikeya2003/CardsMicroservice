package com.example.Cards.service.serviceImpl;


import com.example.Cards.constants.CardsConstants;
import com.example.Cards.dto.CardsDto;
import com.example.Cards.entity.Cards;
import com.example.Cards.exception.CardAlreadyExistsException;
import com.example.Cards.exception.ResourceNotFoundException;
import com.example.Cards.mapper.CardsMapper;
import com.example.Cards.repository.CardsRepository;
import com.example.Cards.service.ICardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class CardServiceImpl implements ICardsService {

    @Autowired
    private CardsRepository cardsRepository;


    @Override
    public void createCard(String mobileNumber) {

        Optional<Cards> optionalCards = cardsRepository.findCardsByMobileNumber(mobileNumber);
        if (optionalCards.isPresent()) {

            throw new CardAlreadyExistsException("Card already exists");

        } else {
            Cards cards = CreateNewCard(mobileNumber);
            cardsRepository.save(cards);
        }
    }

    private Cards CreateNewCard(String mobileNumber) {

        Cards cards = new Cards();

        cards.setMobileNumber(mobileNumber);
        cards.setCardType(CardsConstants.Credit);
        cards.setTotalLimit(100000);
        cards.setAmountUsed(0);
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        cards.setCardNumber(String.valueOf(randomCardNumber));
        return cards;

    }

    @Override
    public CardsDto fetchCard(String mobileNumber) {

        Optional<Cards> optionalCards = cardsRepository.findCardsByMobileNumber(mobileNumber);
        if (optionalCards.isPresent()) {
            Cards cards = optionalCards.get();
            return CardsMapper.mapToCardsDto(cards);

        }else {
            throw new ResourceNotFoundException("Card not found");
        }
    }

    @Override
    public boolean updateCard(CardsDto cardsDto) {

        boolean isUpdated = false;
        if(cardsDto != null ) {

            Cards cards = cardsRepository.findCardsByCardNumber(cardsDto.getCardNumber()).orElseThrow(
            ()->  new ResourceNotFoundException("Card not found")
            );
           Cards cards1= CardsMapper.mapToCards(cards,cardsDto);
           cardsRepository.save(cards1);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {

        Cards cards = cardsRepository.findCardsByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card not found")
        );
        cardsRepository.delete(cards);
        return true;
    }
}
