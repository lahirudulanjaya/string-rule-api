package com.beta.replyservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReverseOperatorTest {

    private ReverseOperator reverseOperator;

    @BeforeEach
    public void beforeEach() {
        reverseOperator = new ReverseOperator();
    }

    @Test
    public void testApply_forTheGivenString_shouldReturnReversedString() {
        assertEquals("tseT", reverseOperator.apply("Test"));
    }

    @Test
    public void testGetRuleNumber_whenRequestForRuleNumber_shouldReturnCorrectNumber() {
        assertEquals('1', reverseOperator.getRuleNumber());
    }


}