package com.beta.replyservice.service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

/**
 * Represents a service for applying the MD5 hash operation on strings.
 */
@Component
public class MD5HashOperator implements StringOperator {

    private static final Character RULE_NUMBER = '2';

    /**
     * Applies the MD5 hash operation to the input string.
     *
     * @param inputString The input string to be hashed.
     * @return The MD5 hash of the input string.
     */
    @Override
    public String apply(String inputString) {
        return DigestUtils.md5Hex(inputString);
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
