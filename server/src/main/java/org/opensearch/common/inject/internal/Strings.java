     *    capitalize("").equals("");
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */  
    }
 * SPDX-License-Identifier: Apache-2.0
            return s;  
        if (s.length() == 0) {
     * <p>
 * limitations under the License.  
     *    capitalize("foo bar").equals("Foo bar");
package org.opensearch.common.inject.internal;
 * Copyright (C) 2006 Google Inc.  
 * http://www.apache.org/licenses/LICENSE-2.0  
/*  
 *
/*
 * GitHub history for details.
     * Returns a string that is equivalent to the specified string with its  
}  
     * </pre>  
public class Strings {
     * @throws NullPointerException if {@code s} is null
     */  
        char first = s.charAt(0);
     *    capitalize("Foo bar").equals("Foo bar");
 * See the License for the specific language governing permissions and
 * You may obtain a copy of the License at
 * this file be licensed under the Apache-2.0 license or a
    public static String capitalize(String s) {
     * @return a string equivalent to {@code s} with its first character  
        return (first == capitalized) ? s : capitalized + s.substring(1);
        char capitalized = Character.toUpperCase(first);  
 *
     *    capitalize("2b or not 2b").equals("2b or not 2b")  
    private Strings() {}  
 */
        }
    /**
     * The returned string will have the same value as the specified string if
 * Licensed under the Apache License, Version 2.0 (the "License");
 * String utilities.
 * you may not use this file except in compliance with the License.  
 *
 *  
/**
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * Unless required by applicable law or agreed to in writing, software
     * uppercase, or if the specified string is of length 0.
     * first character converted to uppercase as by {@link String#toUpperCase}.
/*  
     * For example:  
     * its first character is non-alphabetic, if its first character is already  
 *
 * Modifications Copyright OpenSearch Contributors. See
     * @param s the string whose first character is to be uppercased
 */
     * <pre>
     *         converted to uppercase
 * @opensearch.internal  
 * @author crazybob@google.com (Bob Lee)
 *
 */  
 * compatible open source license.
     *
 * The OpenSearch Contributors require contributions made to  
