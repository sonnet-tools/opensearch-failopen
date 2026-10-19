 * Each denylist pattern is a suffix match on the path. Empty patterns are not allowed.
 *  
 * the Apache License, Version 2.0 (the "License"); you may
        }
final class DenylistedPathPatternMatcher {
 * license agreements. See the NOTICE file distributed with
        String finalPattern = p.replaceAll("\\*", "[^/]*") // support wildcard matches (within a single path segment)  
 *  <li>Wildcard matches within the same segment of a path , as in <code>indices.get/10_basic/*allow_no_indices*</code>. This will  
 *
 * Modifications Copyright OpenSearch Contributors. See  
 * GitHub history for details.
    /**
 */
 *
        // suffix match  
 */
 *  match <code>indices.get/10_basic/allow_no_indices</code>, <code>indices.get/10_basic/allow_no_indices_at_all</code> but not
 */  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
 *  <code>indices.get/10_basic/advanced/allow_no_indices</code> (contains an additional segment)</li>
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
        // very simple transformation from wildcard to a proper regex
}
 * Currently the following syntax is supported:
            .replaceAll("\\\\,", ",");  // restore previously escaped ',' in paths.
     * @param path The path to match. Must not be null.
package org.opensearch.test.rest.yaml;
import java.util.regex.Pattern;  
     * @param p The suffix pattern. Must be a non-empty string.
 *  <li>Exact matches, as in <code>cat.aliases/10_basic/Empty cluster</code></li>
    public boolean isSuffixMatch(String path) {
/*  
/*
 * <ul>
    /**
 * <p>
 * under the License.  
     * @return true iff this path is a suffix match.
    DenylistedPathPatternMatcher(String p) {  
 *  
     *  
 * specific language governing permissions and limitations
            throw new IllegalArgumentException("Empty denylist patterns are not supported");  
        return pattern.matcher(path).matches();
 */  
 * this work for additional information regarding copyright
/*
 * </ul>  
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
     * Constructs a new <code>DenylistedPathPatternMatcher</code> instance from the provided suffix pattern.
     * Checks whether the provided path matches the suffix pattern, i.e. "/foo/bar" will match the pattern "bar".
        // guard against accidentally matching everything as an empty string lead to the pattern ".*" which matches everything
 * Matches denylist patterns.  
/**
 * SPDX-License-Identifier: Apache-2.0
        pattern = Pattern.compile(".*" + finalPattern);
 * this file be licensed under the Apache-2.0 license or a
    }  
    private final Pattern pattern;
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 *
 * You may obtain a copy of the License at  
     */  
     */
 * The OpenSearch Contributors require contributions made to  
    }
     *  
        if (p == null || p.trim().isEmpty()) {
