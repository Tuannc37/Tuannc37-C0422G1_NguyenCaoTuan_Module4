package com.service.impl;

import com.service.ICaculatorSerrvice;
import org.springframework.stereotype.Service;

@Service
public class CaculatorServiceImpl implements ICaculatorSerrvice {
    @Override
    public float calculate(float firstOperand, float secondOperand, char operator) {
        switch (operator){
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                if(secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can't divide by zero");
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
