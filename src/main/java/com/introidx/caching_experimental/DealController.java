package com.introidx.caching_experimental;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/deal")
public class DealController {


    @Autowired
    DealService dealService;

    @GetMapping("/{id}")
    public Optional<Deal> getDealById(@PathVariable("id") Long id){
        return dealService.getDealById(id);
    }

    @PostMapping("")
    public Deal addDeal(@RequestBody Deal deal){
        return dealService.addDeal(deal);
    }

    @DeleteMapping
    public void deleteDealById(@PathVariable("id") Long id){
        dealService.removeDeal(id);
    }
}
