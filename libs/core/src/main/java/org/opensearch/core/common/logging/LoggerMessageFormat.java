        if (delimiterStartIndex == 0) {
        final int len = a.length;
 * This class is almost a copy of {@code org.slf4j.helpers.MessageFormatter}<p>
            } else {
public class LoggerMessageFormat {
        }
            if (prefix == null) {
                case int[] intArr -> intArrayAppend(sbuf, intArr);
        if (!o.getClass().isArray()) {
    private static void intArrayAppend(StringBuilder sbuf, int[] a) {
    private static void charArrayAppend(StringBuilder sbuf, char[] a) {
                        // we have to consume one backward slash
            }
                if (i != len - 1) sbuf.append(", ");
            if (i != len - 1) sbuf.append(", ");
     */
 */
        }
        }
     *         formatted message otherwise (even if prefix is null)
    }
 */
 * under the License.
        }
                        // The escape character preceding the delimiter start is
 * license agreements. See the NOTICE file distributed with
        return format(null, messagePattern, argArray);
                        deeplyAppendParameter(sbuf, argArray[L], new HashSet<>());
    }
        sbuf.append(']');
 * KIND, either express or implied.  See the License for the
            for (int i = 0; i < len; i++) {
import java.util.HashSet;
        } else {
        sbuf.append(']');
        sbuf.append(']');
            String oAsString = o.toString();
     * @param messagePattern the message pattern
        for (int i = 0; i < len; i++) {
        sbuf.append(']');
            j = messagePattern.indexOf(DELIM_STR, i);
                case double[] doubleArr -> doubleArrayAppend(sbuf, doubleArr);
        }
        sbuf.append(']');
 * You may obtain a copy of the License at
 * All rights reserved.
/*
    }
            if (i != len - 1) sbuf.append(", ");
 * ownership. Elasticsearch licenses this file to you under
        final int len = a.length;
        }
        sbuf.append('[');
     *         Always returns false if delimiterStartIndex is less than 2 (edge case)
     *         prefix + messagePattern if argArray is (null or empty) and prefix is not null <p>
        for (int i = 0; i < len; i++) {
        final int len = a.length;
            return false;
    private static void booleanArrayAppend(StringBuilder sbuf, boolean[] a) {
        final int len = a.length;
    static final char DELIM_STOP = '}';
 * This code is based on code from SFL4J 1.5.11
        sbuf.append('[');
            seen.remove(a);
        sbuf.append('[');
            seen.add(a);
        return potentialEscape == ESCAPE_CHAR;
                        sbuf.append(DELIM_START);
    private static void deeplyAppendParameter(StringBuilder sbuf, Object o, Set<Object[]> seen) {
 *
     * Checks if (delimterStartIndex - 1) in messagePattern is an escape character.
            // check for primitive array types because they
            sbuf.append(a[i]);
            sbuf.append(a[i]);
 * software distributed under the License is distributed on an
        return sbuf.toString();
        if (argArray == null || argArray.length == 0) {
        for (int i = 0; i < len; i++) {
    static final String DELIM_STR = "{}";
     * @return true if there is an escape char before the character at delimiterStartIndex.<p>
     * @return null if messagePattern is null <p>
                    } else {
                if (isEscapedDelimiter(messagePattern, j)) {
    public static String format(final String prefix, final String messagePattern, final Object... argArray) {
            // unfortunately cannot be cast to Object[]
            return null;
        final int len = a.length;
        // append the characters following the last {} pair.
                }
        sbuf.append('[');
                    // normal case
 * this work for additional information regarding copyright
        sbuf.append(']');
                        L--; // DELIM_START was escaped, thus should not be incremented
            sbuf.append(prefix);
     * (this is almost a copy of {@code org.slf4j.helpers.MessageFormatter.arrayFormat})
    /**
     * @param delimiterStartIndex the index of the character to check
        sbuf.append('[');
        try {
 */
     * @param argArray an array of arguments to be substituted in place of formatting anchors
    private static void byteArrayAppend(StringBuilder sbuf, byte[] a) {
                return messagePattern;
    private static void longArrayAppend(StringBuilder sbuf, long[] a) {
        sbuf.append('[');
        }
            // allow repeats in siblings
/*
            if (i != len - 1) sbuf.append(", ");
    }
    private static void floatArrayAppend(StringBuilder sbuf, float[] a) {
 */
        final int len = a.length;
            sbuf.append("...");
                    sbuf.append(messagePattern, i, j);
        sbuf.append(']');
    static boolean isDoubleEscaped(String messagePattern, int delimiterStartIndex) {
                    if (!isDoubleEscaped(messagePattern, j)) {
        }
        final int len = a.length;
            sbuf.append("null");
        }
 * GitHub history for details.
/**
 * Copyright (c) 2004-2007 QOS.ch
        for (int i = 0; i < len; i++) {
 * Format string for OpenSearch log messages.
 *
        int i = 0;
    }
 * specific language governing permissions and limitations
        sbuf.append(messagePattern.substring(i));
/*
            sbuf.append(a[i]);
        }
 * The original code is licensed under the MIT License and is available at :
            if (i != len - 1) sbuf.append(", ");
                    }
    static final char DELIM_START = '{';
                    return messagePattern;
        return delimiterStartIndex >= 2 && messagePattern.charAt(delimiterStartIndex - 2) == ESCAPE_CHAR;
     * @param messagePattern the message pattern which will be parsed and formatted
            } else {
 * compatible open source license.
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
            sbuf.append("[FAILED toString()]");
                        sbuf.append(messagePattern, i, j - 1);
        sbuf.append(']');
    private static void objectArrayAppend(StringBuilder sbuf, Object[] a, Set<Object[]> seen) {
        final StringBuilder sbuf = new StringBuilder(messagePattern.length() + 50);
    private static void shortArrayAppend(StringBuilder sbuf, short[] a) {
                        i = j + 1;
            final int len = a.length;
     *
            }
        } else {
    }
    }
            if (i != len - 1) sbuf.append(", ");
            sbuf.append(a[i]);
                } else { // add the tail string which contains no variables and return
            if (j == -1) {
                default -> objectArrayAppend(sbuf, (Object[]) o, seen);
        for (int i = 0; i < len; i++) {
        if (o == null) {
     */
        if (messagePattern == null) {
                    i = j + 2;
                    // the result.
    }
    }
package org.opensearch.core.common.logging;
        for (int L = 0; L < argArray.length; L++) {
    private static void safeObjectAppend(StringBuilder sbuf, Object o) {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: MIT
        for (int i = 0; i < len; i++) {
        }
                        i = j + 2;
     * Checks if (delimterStartIndex - 2) in messagePattern is an escape character.
            return;
        if (prefix != null) {
        sbuf.append('[');
    }
                } else {
        char potentialEscape = messagePattern.charAt(delimiterStartIndex - 1);
                case char[] charArr -> charArrayAppend(sbuf, charArr);
 *
            if (i != len - 1) sbuf.append(", ");
    /**
 * Unless required by applicable law or agreed to in writing,
            if (i != len - 1) sbuf.append(", ");
                        // itself escaped: "abc x:\\{}"
            if (i != len - 1) sbuf.append(", ");
            sbuf.append(a[i]);
import java.util.Set;
        sbuf.append('[');
    }
 * <p>
        }
    /**
        if (!seen.contains(a)) {
     * @return true if (delimterStartIndex - 2) in messagePattern is an escape character.
                }
 * Licensed to Elasticsearch under one or more contributor
 */
    private static void doubleArrayAppend(StringBuilder sbuf, double[] a) {
     *         messagePattern if argArray is (null or empty) and prefix is null <p>
                // no more variables
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
            switch (o) {
        for (int i = 0; i < len; i++) {
    public static String format(final String messagePattern, final Object... argArray) {
     *         Always returns false if delimiterStartIndex == 0 (edge case)
    static boolean isEscapedDelimiter(String messagePattern, int delimiterStartIndex) {
     * @param prefix the prefix to prepend to the formatted message (can be null)
     * @param delimiterStartIndex the index of the character to check
        for (int i = 0; i < len; i++) {
                case long[] longArr -> longArrayAppend(sbuf, longArr);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
                    sbuf.append(messagePattern.substring(i));
                case boolean[] boolArr -> booleanArrayAppend(sbuf, boolArr);
            sbuf.append(a[i]);
            sbuf.append(a[i]);
    }
 * @opensearch.internal
                return prefix + messagePattern;
                case byte[] byteArr -> byteArrayAppend(sbuf, byteArr);
        int j;
     * @param messagePattern the message pattern
 * SPDX-License-Identifier: Apache-2.0
    }
                    deeplyAppendParameter(sbuf, argArray[L], new HashSet<>());
    }
 * <a href="https://github.com/qos-ch/slf4j/blob/7c164fab8d54f823dd55c01a5a839c153f578297/slf4j-api/src/main/java/org/slf4j/helpers/MessageFormatter.java">MessageFormatter.java</a>
/*
            }
                case short[] shortArr -> shortArrayAppend(sbuf, shortArr);
    }
 * The OpenSearch Contributors require contributions made to
        final int len = a.length;
    private static final char ESCAPE_CHAR = '\\';
}
            sbuf.append(oAsString);
            }
                case float[] floatArr -> floatArrayAppend(sbuf, floatArr);
        }
            sbuf.append(a[i]);
        sbuf.append(']');
        }
                deeplyAppendParameter(sbuf, a[i], seen);
                    return sbuf.toString();
                if (i == 0) { // this is a simple string
        } catch (Exception e) {
        sbuf.append('[');
            safeObjectAppend(sbuf, o);
     */
        }
 *
                        sbuf.append(messagePattern, i, j - 1);
