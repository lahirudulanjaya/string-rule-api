package com.beta.replyservice.controller;

import com.beta.replyservice.response.ReplyMessage;
import com.beta.replyservice.service.MD5HashOperator;
import com.beta.replyservice.service.ReverseOperator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ReplyV2ControllerTest {
    private ReplyV2Controller replyV2Controller;
    @Mock
    private MD5HashOperator md5HashOperatorMock;
    @Mock
    private ReverseOperator reverseOperatorMock;

    @BeforeEach
    public void beforeEach() {
        initMocks(this);
        when(reverseOperatorMock.getRuleNumber()).thenReturn('1');
        when(md5HashOperatorMock.getRuleNumber()).thenReturn('2');
        replyV2Controller = new ReplyV2Controller(Arrays.asList(reverseOperatorMock, md5HashOperatorMock));
    }

    @Test
    public void testReplying_whenRuleOneRepeatTwoTimes_shouldReturnTheSameString() {
        final String inputMessage = "kbzw9ru";
        final String reversedMessage = "ur9wzbk";

        when(reverseOperatorMock.apply(inputMessage)).thenReturn(reversedMessage);
        when(reverseOperatorMock.apply(reversedMessage)).thenReturn(inputMessage);

        ReplyMessage replyMessage = replyV2Controller.replying("11", inputMessage);
        assertEquals(inputMessage, replyMessage.getData());
    }

    @Test
    public void testReplying_whenRuleOneAndRuleTwoProvided_shouldReverseAndHashTheMessage() {
        final String inputMessage = "kbzw9ru";
        final String reversedMessage = "ur9wzbk";
        final String hash = "098f6bcd4621d373cade4e832627b4f6";

        when(reverseOperatorMock.apply(inputMessage)).thenReturn("ur9wzbk");
        when(md5HashOperatorMock.apply(reversedMessage)).thenReturn(hash);

        ReplyMessage replyMessage = replyV2Controller.replying("12", inputMessage);
        assertEquals(replyMessage.getData(), hash);
    }

    @Test
    public void testReplying_whenOnlyOneRuleNumberProvided_shouldThrowIllegalArgumentException() {
        final String inputMessage = "test";
        assertThrows(IllegalArgumentException.class, () -> replyV2Controller.replying("1", inputMessage));
    }

    @Test
    public void testReplying_whenMoreThanTwoRulesProvided_shouldThrowIllegalArgumentException() {
        final String inputMessage = "test";
        assertThrows(IllegalArgumentException.class, () -> replyV2Controller.replying("1", inputMessage));
    }

    @Test
    public void testReplying_whenInvalidRuleFormatProvided_shouldThrowIllegalArgumentException() {
        final String inputMessage = "test";
        assertThrows(IllegalArgumentException.class, () -> replyV2Controller.replying("a1", inputMessage));
    }

    @Test
    public void testReplying_forNotImplementedRules_shouldThrowIllegalArgumentException() {
        final String inputMessage = "Test";
        assertThrows(IllegalArgumentException.class, () -> replyV2Controller.replying("44", inputMessage));
    }


}