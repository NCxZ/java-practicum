package com.patika.repository;

import com.patika.entity.product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;

@Repository
public interface ProductRepository extends CrudRepository<product, Integer> {

    @Query("FROM product WHERE date < :#{#now}")
    Iterable<product> getExpiredProducts(@Param("now") Date now);

    @Query("FROM product WHERE date >= :#{#now} OR date is NULL")
    Iterable<product> getFreshProducts(@Param("now")Date now);
}
