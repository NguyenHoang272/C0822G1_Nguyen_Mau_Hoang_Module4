package com.book_order.utils.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookOderAspect {
    @After("execution(* com.book_order.controller.BookOrderController.order(..))")
    public void logAfterOrder(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Modified:  Người dùng đã " + methodName);
    }
}
