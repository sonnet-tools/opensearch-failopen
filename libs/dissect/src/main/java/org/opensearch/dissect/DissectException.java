    }
 * software distributed under the License is distributed on an
    static class PatternParse extends DissectException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
     * Error while parsing a dissect key
    /**  
 */  
 * compatible open source license.
    static class FindMatch extends DissectException {  
 */
 * Parent class for all dissect related exceptions. Consumers may catch this exception or more specific child exceptions.
        PatternParse(String pattern, String reason) {
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
        }  
}  
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(message);  
        }  
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 *
 * not use this file except in compliance with the License.
            super("Unable to parse pattern: " + pattern + " Reason: " + reason);
    }
/**
 * this file be licensed under the Apache-2.0 license or a
    }
package org.opensearch.dissect;
        FindMatch(String pattern, String source) {
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 *  
/*  
 */  
        KeyParse(String key, String reason) {
/*  
 *
    /**  
public abstract class DissectException extends RuntimeException {
    /**  
 * specific language governing permissions and limitations
    static class KeyParse extends DissectException {  
    DissectException(String message) {
     * Error while parsing a dissect pattern
 * Modifications Copyright OpenSearch Contributors. See
            super("Unable to find match for dissect pattern: " + pattern + " against source: " + source);
 */  
 * GitHub history for details.
        }
     */
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
            super("Unable to parse key: " + key + " Reason: " + reason);
     */
    }
     */
     * Unable to find a match between pattern and source string
