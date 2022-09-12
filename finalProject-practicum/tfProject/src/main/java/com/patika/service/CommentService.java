package com.patika.service;

import com.patika.entity.comment;
import com.patika.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CommentService implements ICommentService {
    @Autowired
    CommentRepository commentRepository;

    public comment addComment(comment comment){
        return commentRepository.save(comment);
    }

    @Override
    public Iterable<comment> getCommentsByProductId(int productID) {
        return commentRepository.getCommentByProductId(productID);
    }
    @Override
    public Iterable<comment> getCommentsByUserId(int userID) {
        return commentRepository.getCommentByUserId(userID);
    }

    @Override
    public Iterable<comment> getProductCommentsByDate(int productID, String startDate, String endDate) throws ParseException {
        Date start = parseDateString(startDate);
        Date end = parseDateString(endDate);
        return commentRepository.getCommentByProductIdAndCommentDate(productID,start , end);

    }

    @Override
    public Iterable<comment> getUserCommentsByDate(int userID, String startDate, String endDate) throws ParseException {
        Date start = parseDateString(startDate);
        Date end = parseDateString(endDate);
        return commentRepository.getCommentByUserIdAndCommentDate(userID,start,end);
    }

    @Override
    public Iterable<comment> getCommentsByUser(int userId) {
        return null;
    }

    public Date parseDateString(String dateS) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = formatter.parse(dateS);
        return date;
    }
}
