package com.introidx.caching_experimental;

import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public class DealRepository {

    public Optional<Deal> getDealById(long id){
        System.out.println("Simulating get deal by id");
        return Optional.of(new Deal(id, "Attic", "Leasing"));
    }

    public Deal addDeal(Deal deal){
        System.out.println("Simulating deal creation");
        return deal;
    }

    public void removeDealById(long id){
        System.out.println("Simulating removal of " + id + " from the deal store ");
    }
}
