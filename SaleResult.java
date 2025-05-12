package com.example.sale;

import java.util.List;

public class SaleResult {
    private List<Integer> payableItems;
    private List<Integer> freeItems;

    public SaleResult(List<Integer> payableItems, List<Integer> freeItems) {
        this.payableItems = payableItems;
        this.freeItems = freeItems;
    }

    public List<Integer> getPayableItems() {
        return payableItems;
    }

    public List<Integer> getFreeItems() {
        return freeItems;
    }
}
