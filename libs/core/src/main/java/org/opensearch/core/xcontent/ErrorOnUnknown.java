        ErrorOnUnknown best = new ErrorOnUnknown() {  
            }
        };
    static ErrorOnUnknown findImplementation() {
/**  
    /**  
            public int priority() {
     */
 * the Apache License, Version 2.0 (the "License"); you may
     * Priority that this error message handler should be used.
     * @param candidates the possible fields
     * @param unknownField the field that we couldn't recognize
 *
public interface ErrorOnUnknown {
     * The implementation of this interface that was loaded from SPI.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * GitHub history for details.
            }  
 * You may obtain a copy of the License at  
    /**
    /**
        }  
    int priority();  
    String errorMessage(String parserName, String unknownField, Iterable<String> candidates);
 * not use this file except in compliance with the License.
 *
     */
import java.util.ServiceLoader;
 * Licensed to Elasticsearch under one or more contributor  
                best = c;
    ErrorOnUnknown IMPLEMENTATION = findImplementation();
                return "[" + parserName + "] unknown field [" + unknownField + "]";  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
/*
 * Extension point to customize the error message for unknown fields. We expect
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
                return Integer.MIN_VALUE;
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * specific language governing permissions and limitations
     * Build the error message to use when {@link ObjectParser} encounters an unknown field.
            public String errorMessage(String parserName, String unknownField, Iterable<String> candidates) {
 */
 * @opensearch.api
/*  
     * @param parserName the name of the thing we're parsing  
 * compatible open source license.
 * this work for additional information regarding copyright
 */  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.core.xcontent;
 * correction infrastructure to suggest corrections.  
 * SPDX-License-Identifier: Apache-2.0
 */  
 * OpenSearch to plug a fancy implementation that uses Lucene's spelling
        for (ErrorOnUnknown c : ServiceLoader.load(ErrorOnUnknown.class)) {
/*  
 * Unless required by applicable law or agreed to in writing,
            if (best.priority() < c.priority()) {  
 */  
            }
            @Override
 * software distributed under the License is distributed on an
}  
     */  
            @Override  
 * this file be licensed under the Apache-2.0 license or a
        return best;
 *
