package com.beta.replyservice.service;

/**
 * Represents an operation to be applied on strings.
 * <p>
 * Implementations of this interface define various string operations to be used in processing incoming strings
 * through the REST API endpoint "/reply/V2/{rule}-{message}".
 * </p>
 */
public interface StringOperator {

    /**
     * Applies the operation to the input string.
     *
     * @param inputString The input string.
     * @return The result of applying the operation to the input string.
     */
    String apply(String inputString);

    /**
     * Returns the rule number associated with the operation.
     *
     * @return The rule number.
     */
    Character getRuleNumber();
}
