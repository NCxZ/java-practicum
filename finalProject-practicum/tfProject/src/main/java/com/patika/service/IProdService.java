package com.patika.service;

import com.patika.entity.comment;
import com.patika.entity.product;

import java.text.ParseException;
import java.util.Date;

public interface IProdService {
    product addProduct(product product);
    void deleteProduct(product product);
    Iterable<product> getExpiredProducts() throws ParseException;
    Iterable<product> getFreshProducts() throws ParseException;
}
