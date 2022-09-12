package com.patika.service;

import com.patika.entity.comment;

import java.text.ParseException;
import java.util.Date;

public interface ICommentService {
    Iterable<comment> getCommentsByProductId(int productID);
    Iterable<comment> getProductCommentsByDate(int productID , String startDate , String endDate) throws ParseException;
    Iterable<comment> getUserCommentsByDate(int userID, String startDate, String endDate) throws ParseException;
    Iterable<comment> getCommentsByUser(int userId);
    Iterable<comment> getCommentsByUserId(int userID);
}
