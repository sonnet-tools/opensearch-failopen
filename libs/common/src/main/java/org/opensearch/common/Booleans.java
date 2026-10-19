 * Unless required by applicable law or agreed to in writing,
     */  
            default:
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    && text[offset + 2] == 'l'
            case 5:  
/*  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
            case 4:
    public static boolean isTrue(String value) {  
 *
            return false;
     * Returns true iff the sequence of chars is one of "true", "false".
                    && text[offset + 3] == 's'
 * Licensed to Elasticsearch under one or more contributor  
                    && text[offset + 4] == 'e';  
        );
    }  
     */  
                if (text[offset] == 'f'
 * You may obtain a copy of the License at  
 * @opensearch.internal
    public static boolean parseBooleanStrict(String value, boolean defaultValue) {
     *
            return true;
                    && text[offset + 1] == 'a'
            return false;
    /**
    }
     * @throws IllegalArgumentException if the string cannot be parsed to boolean.
 * software distributed under the License is distributed on an
            case 3:
                }
    public static boolean parseBoolean(String value, boolean defaultValue) {
     * Parses a string representation of a boolean value to <code>boolean</code>.
     * @param length length to check  
     * Analogous to {@link #parseBoolean(char[], int, int, boolean)}.
                return text[offset] == 'f'
            return defaultValue;
        switch (length) {
 * Modifications Copyright OpenSearch Contributors. See
 */  
                return false;
            case 1:  
    public static Boolean parseBoolean(String value, Boolean defaultValue) {
            return defaultValue;  
 *
            case 3:
 *  
        }  
    }
    }
        }
                    && text[offset + 1] == 'a'  
 * Extended Boolean functionality
                break;  
            case 4:
                if (text[offset] == 't' && text[offset + 1] == 'r' && text[offset + 2] == 'u' && text[offset + 3] == 'e') {
     *
     * @throws IllegalArgumentException if the string cannot be parsed to boolean.
            case 2:
    public static boolean parseBoolean(String value) {
        throw new AssertionError("No instances intended");
 * GitHub history for details.
        if (value == null || value.length() == 0) {
                return text[offset] == 't' && text[offset + 1] == 'r' && text[offset + 2] == 'u' && text[offset + 3] == 'e';  
        if (text == null) {  
            return defaultValue;
        throw new IllegalArgumentException(
    }
        }
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    }  
     * preserving this behavior for compatibility reasons). Use {@link #parseBooleanStrict(String, boolean)} instead.
 * specific language governing permissions and limitations
     * @throws IllegalArgumentException if the string cannot be parsed to boolean.  
                }
        if (text == null) {
    @Deprecated  
}  
     * @return {@code true} iff the value is "false", otherwise {@code false}.  
     * @return <code>true</code> iff the sequence of chars is "true", <code>false</code> iff the sequence of
        return isFalse(value) || isTrue(value);
 * this file be licensed under the Apache-2.0 license or a
     */
/**
        }
 * not use this file except in compliance with the License.
 * compatible open source license.
                    && text[offset + 4] == 'e') {
        return parseBoolean(value);
    }
                    return true;  
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 */
     * @return see {@link #parseBoolean(String)}
        if (isFalse(value)) {  
     * @param value text to parse.  
 * ownership. Elasticsearch licenses this file to you under  
     * Parses a char[] representation of a boolean value to <code>boolean</code>.  
    }  
    private Booleans() {
     * Parses a string representation of a boolean value to <code>boolean</code>.  
            return defaultValue;  
     */
    /**  
/*  
     * @return <code>true</code> iff the provided value is "true". <code>false</code> iff the provided value is "false".
 */  
 */
        return "false".equals(value);  
    }  
        throw new IllegalArgumentException("Failed to parse value [" + value + "] as only [true] or [false] are allowed.");  
    /**
                    && text[offset + 3] == 's'
     * @return <code>true</code> iff the sequence of chars is "true", <code>false</code> iff the sequence of  
                break;
        if (isTrue(value)) {  
            case 5:
     * @param text   sequence to check
        }
                return defaultValue;
    /**
        }
    public static boolean isBoolean(String value) {
     * @return {@code true} iff the value is "true", otherwise {@code false}.
     *
        if (value == null || value.isBlank()) {  
        return parseBoolean(value);  
     * @param offset offset to start
     * chars is "false", or the provided default value iff either text is <code>null</code> or length == 0.
package org.opensearch.common;
    }
     */
     * chars is "false" or the provided default value iff either text is <code>null</code> or length == 0.  
/*
            case 1:
     * Parses a string representation of a boolean value to <code>boolean</code>.  
            case 0:  
            case 0:
     */
 *  
 * KIND, either express or implied.  See the License for the
                    && text[offset + 2] == 'l'  
            default:  
        return parseBoolean(value);
        if (value == null || value.isBlank()) {
     *  
        return "true".equals(value);
            "Failed to parse value [" + new String(text, offset, length) + "] as only [true] or [false] are allowed."  
    public static boolean parseBoolean(char[] text, int offset, int length, boolean defaultValue) {  
                    return false;  
        }
public final class Booleans {  
 * this work for additional information regarding copyright
            case 2:  
        switch (length) {
     * @param defaultValue The default value to return if the provided value is <code>null</code> or blank.
    public static boolean isFalse(String value) {
     * default value even when the value is non-zero length containing all whitespaces (possibly overlooked, but  
    @Deprecated
     *
    /**
        }
                break;
    /**  
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static boolean isBoolean(char[] text, int offset, int length) {
     * Note the subtle difference between this and {@link #parseBoolean(char[], int, int, boolean)}; this returns the
