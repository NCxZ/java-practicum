package com.patika.service;

import com.patika.entity.comment;
import com.patika.entity.product;
import com.patika.repository.CommentRepository;
import com.patika.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Service
public class ProdService implements IProdService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public product addProduct(product product) {
        return productRepository.save(product);

    }

    @Override
    public void deleteProduct(product product) {

    }

    @Override
    public Iterable<product> getExpiredProducts() throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String nowString = dtf.format(now);
        return productRepository.getExpiredProducts(parseDateString(nowString));
    }

    @Override
    public Iterable<product> getFreshProducts() throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        String nowString = dtf.format(now);
        return productRepository.getFreshProducts(parseDateString(nowString));
    }

    public Date parseDateString(String dateS) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(dateS);
        return date;
    }
}
