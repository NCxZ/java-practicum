package com.patika.repository;

import com.patika.entity.comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.Date;

@Repository
public interface CommentRepository extends CrudRepository<comment, Integer> {
    Iterable<comment> getCommentByProductId(int productId);
    Iterable<comment> getCommentByUserId(int userId);

    @Query("FROM comment WHERE :#{#endDate} > commentDate AND :#{#startDate} < commentDate AND comment.productId = :#{#pID}")
    Iterable<comment> getCommentByProductIdAndCommentDate(@Param("pID") int productId, @Param("startDate") Date startDate,@Param("endDate") Date endDate);

    @Query("FROM comment WHERE :#{#endDate} > commentDate AND :#{#startDate} < commentDate AND comment.userId = :#{#uID}")
    Iterable<comment> getCommentByUserIdAndCommentDate(@Param("uID") int userId, @Param("startDate") Date startDate,@Param("endDate") Date endDate);


}
