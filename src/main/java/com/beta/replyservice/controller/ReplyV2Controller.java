package com.beta.replyservice.controller;

import com.beta.replyservice.response.ReplyMessage;
import com.beta.replyservice.service.StringOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Controller for handling replies to requests with rule-based string operations.
 */
@RestController
public class ReplyV2Controller {

    private final Map<Character, StringOperator> stringOperatorMap;

    @Autowired
    public ReplyV2Controller(List<StringOperator> stringOperators) {
        this.stringOperatorMap = stringOperators.stream().collect(Collectors.toMap(StringOperator::getRuleNumber, operator -> operator));
    }

    /**
     * Applies the specified rules to the provided message and responds with the processed message.
     *
     * @param rule    The rule for string operations. Example rules: 1 (reverse), 2 (MD5 hash).
     * @param message The message to be processed.
     * @return ReplyMessage object with the processed message.
     */
    @GetMapping("/v2/reply/{rule}-{message}")
    public ReplyMessage replying(@PathVariable String rule, @PathVariable String message) {
        validateRuleFormat(rule);
        String operatedMessage = applyRuleString(rule, message);
        return new ReplyMessage(operatedMessage);
    }

    private String applyRuleString(String rule, String message) {
        for (Character ruleNumber : rule.toCharArray()) {
            StringOperator operation = stringOperatorMap.get(ruleNumber);
            if (operation == null) {
                throw new IllegalArgumentException("Invalid input");
            }
            message = operation.apply(message);
        }
        return message;
    }

    private void validateRuleFormat(String rule) {
        // Validate that the rule contains exactly two numbers separated by a hyphen
        if (!rule.matches("^\\d{2}$")) {
            throw new IllegalArgumentException("Invalid rule format. Rules must contain exactly two numbers.");
        }
    }

}
