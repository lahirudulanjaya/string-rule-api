package com.beta.replyservice.service;

import org.springframework.stereotype.Component;

/**
 *  Represents a service for reversing strings.
 */
@Component
public class ReverseOperator implements StringOperator{
    private static final Character RULE_NUMBER = '1';

    /**
     * Reverses the input string.
     *
     * @param inputString The input string to be reversed.
     * @return The reversed string.
     */
    @Override
    public String apply(String inputString) {
        return new StringBuilder(inputString).reverse().toString();
    }

    /**
     * Returns the rule number for the MD5 hash operation.
     *
     * @return The rule number.
     */
    @Override
    public Character getRuleNumber() {
        return RULE_NUMBER;
    }
}
