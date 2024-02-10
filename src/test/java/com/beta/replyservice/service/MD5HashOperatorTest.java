package com.beta.replyservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MD5HashOperatorTest {

    private MD5HashOperator md5HashOperator;

    @BeforeEach
    public void beforeEach() {
        md5HashOperator = new MD5HashOperator();
    }

    @Test
    public void testApply_forTheGivenString_shouldReturnMD5HashValue() {
        assertEquals("0cbc6611f5540bd0809a388dc95a615b", md5HashOperator.apply("Test"));
    }

    @Test
    public void testGetRuleNumber_whenRequestForRuleNumber_shouldReturnCorrectNumber() {
        assertEquals('2', md5HashOperator.getRuleNumber());
    }

}