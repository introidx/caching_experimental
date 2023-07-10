package com.introidx.caching_experimental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DealService {

    @Autowired
    DealRepository dealRepository;

    public Optional<Deal> getDealById(long id){
        return dealRepository.getDealById(id);
    }

    public Deal addDeal(Deal deal){
        return dealRepository.addDeal(deal);
    }

    public void removeDeal(long id){
        dealRepository.removeDealById(id);
    }
}
