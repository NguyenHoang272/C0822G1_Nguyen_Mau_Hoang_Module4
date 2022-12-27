package com.book_order.service.order_service;

import com.book_order.model.BookOrder;
import com.book_order.repository.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;


    @Override
    public List<BookOrder> finAll() {
        return orderRepository.findAll();
    }

    @Override
    public void save(BookOrder bookOrder) {
        orderRepository.save(bookOrder);
    }

    @Override
    public BookOrder finById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public void update(BookOrder bookOrder) {
        orderRepository.save(bookOrder);
    }

    @Override
    public void remove(BookOrder bookOrder) {
        orderRepository.delete(bookOrder);
    }

    @Override
    public BookOrder finByOtp(int otp) {
        return orderRepository.findByOtp(otp);
    }
}
