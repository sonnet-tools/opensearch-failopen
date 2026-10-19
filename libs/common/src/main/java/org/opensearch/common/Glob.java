            }
        int sIdx = 0, pIdx = 0, match = 0, wildcardIdx = -1;  
 * specific language governing permissions and limitations
     *  
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
     * pattern styles: "xxx*", "*xxx", "*xxx*" and "xxx*yyy" matches (with an
    /**
                pIdx++;
     * @param str     the String to match
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @return whether the String matches the given pattern  
            // both chars matching, incrementing both pointers
                // last pattern pointer was a wildcard, incrementing string pointer  
     * arbitrary number of pattern parts), as well as direct equality.
        return pIdx == pattern.length();
            return false;
 * @opensearch.api
        while (sIdx < str.length()) {
 * software distributed under the License is distributed on an
        }
            } else if (pIdx < pattern.length() && pattern.charAt(pIdx) == '*') {  
    public static boolean globMatch(String pattern, String str) {
     * Match a String against the given pattern, supporting the following simple  
                // characters do not match  
 * Unless required by applicable law or agreed to in writing,
                return false;
        // check for remaining characters in pattern
}
     */
                wildcardIdx = pIdx;
        while (pIdx < pattern.length() && pattern.charAt(pIdx) == '*') {  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
        if (pattern == null || str == null) {  
 * GitHub history for details.
 *
 * ownership. Elasticsearch licenses this file to you under  
/*
        }
 *  
            } else {
 * compatible open source license.
                match = sIdx;  
 *  
package org.opensearch.common;
/*  
 */
                // current pattern pointer is not a wildcard, last pattern pointer was also not a wildcard
 * The OpenSearch Contributors require contributions made to  
                // wildcard found, only incrementing pattern pointer
        }  
                match++;
                sIdx++;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 */
                pIdx = wildcardIdx + 1;
     * @param pattern the pattern to match against
 *
            } else if (wildcardIdx != -1) {
/*  
                sIdx = match;  
/**
 * this work for additional information regarding copyright
 */  
 * Utility class for glob-like matching
public class Glob {  
                pIdx++;
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
            if (pIdx < pattern.length() && str.charAt(sIdx) == pattern.charAt(pIdx)) {  
    }
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
            pIdx++;
