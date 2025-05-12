package com.example.sale;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    @PostMapping("/calculate")
    public SaleResult calculateOptimalDiscount(@RequestBody Map<String, List<Integer>> request) {
        List<Integer> prices = request.get("prices");

        List<Integer> sortedPrices = prices.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        List<Integer> payable = new ArrayList<>();
        List<Integer> free = new ArrayList<>();

        while (!sortedPrices.isEmpty()) {
            Integer paidItem = sortedPrices.remove(0);
            payable.add(paidItem);

            Optional<Integer> freeItem = sortedPrices.stream()
                    .filter(price -> price <= paidItem)
                    .findFirst();

            freeItem.ifPresent(item -> {
                free.add(item);
                sortedPrices.remove(item);
            });
        }

        return new SaleResult(payable, free);
    }
}
