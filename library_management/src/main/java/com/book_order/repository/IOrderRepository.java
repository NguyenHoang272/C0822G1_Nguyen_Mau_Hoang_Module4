package com.book_order.repository;


import com.book_order.model.BookOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOrderRepository extends JpaRepository<BookOrder, Integer> {
    @Query(value = "select * from book_order where otp = :otp and return_date is null ", nativeQuery = true)
    BookOrder findByOtp(@Param("otp") int otp);
}
