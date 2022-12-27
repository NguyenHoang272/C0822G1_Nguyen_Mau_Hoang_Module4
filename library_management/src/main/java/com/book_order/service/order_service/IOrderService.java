package com.book_order.service.order_service;


import com.book_order.model.BookOrder;

import java.util.List;

public interface IOrderService {
    List<BookOrder> finAll();
    void save (BookOrder bookOder);
    BookOrder finById(Integer id);
    void update(BookOrder bookOder);
    void remove(BookOrder bookOder);
    BookOrder finByOtp(int otp);
}
