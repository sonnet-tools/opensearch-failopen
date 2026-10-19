 * compatible open source license.
                && match(uriPattern.getQuery(), uri.getQuery())
}  
public class URIPattern {
        if (value == null) {
 * KIND, either express or implied.  See the License for the
    }
    public static boolean match(URIPattern[] patterns, URI uri) {
        return Regex.simpleMatch(pattern, value);
    public boolean match(URI uri) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
/*
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
        for (URIPattern pattern : patterns) {  
            if (pattern.matchNormalized(normalized)) {
            // If the pattern is empty or matches anything - it's a match  
    }
    private boolean matchNormalized(URI uri) {
        } else {
 * license agreements. See the NOTICE file distributed with
                && match(uriPattern.getFragment(), uri.getFragment());  
        return uriPattern.toString();
    }  
 * <p>
                return true;
            }  
        }
            if (pattern == null || Regex.isMatchAllPattern(pattern)) {
 * @opensearch.internal
        URI normalized = uri.normalize();
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
    private final URI uriPattern;
 * For example: foobar://*.local/some_path/*?*#* will match all uris with schema foobar in local domain
 */  
            // This url only has scheme, scheme-specific part and fragment
    public String toString() {  
 */  
    /**  
            uriPattern = new URI(pattern);  
            }  
                && match(uriPattern.getFragment(), uri.getFragment());
import java.net.URISyntaxException;
                && match(uriPattern.getPath(), uri.getPath())
/*  
 * The pattern is URI in which authority, path, query and fragment can be replace with simple pattern.  
     */
     */  
    @Override
package org.opensearch.common.util;
 * GitHub history for details.
 * <p>
 * URI Pattern matcher
            return match(uriPattern.getScheme(), uri.getScheme())
        } catch (URISyntaxException ex) {
    private boolean match(String pattern, String value) {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.regex.Regex;
 * the Apache License, Version 2.0 (the "License"); you may
 *
    /**
/*  
 * ownership. Elasticsearch licenses this file to you under  
 *  
        if (uriPattern.isOpaque()) {  
        return false;
    }  
    }
        }  
    public URIPattern(String pattern) {
     * Returns true if the given uri matches the pattern
 *
                && match(uriPattern.getScheme(), uri.getScheme())  
 * with any port, with path that starts some_path and with any query and fragment.  
        try {
import java.net.URI;  
            throw new IllegalArgumentException("cannot parse URI pattern [" + pattern + "]");
     * Constructs uri pattern
    }
 */
        return matchNormalized(uri.normalize());
 *
                return true;
        }
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
                && match(uriPattern.getAuthority(), uri.getAuthority())  
 * not use this file except in compliance with the License.
/**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
                && match(uriPattern.getSchemeSpecificPart(), uri.getSchemeSpecificPart())
            return uri.isOpaque()
