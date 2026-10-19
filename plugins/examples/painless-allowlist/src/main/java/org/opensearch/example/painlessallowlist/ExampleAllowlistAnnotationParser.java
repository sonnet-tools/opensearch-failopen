public class ExampleAllowlistAnnotationParser implements AllowlistAnnotationParser {
 * SPDX-License-Identifier: Apache-2.0
        if (categoryString == null) {
        if (categoryString == null) {  
 * Licensed to Elasticsearch under one or more contributor  
 *
        }
 * Unless required by applicable law or agreed to in writing,
/*  
            category = Integer.parseInt(categoryString);
 * under the License.  
package org.opensearch.example.painlessallowlist;
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
}  
 *    http://www.apache.org/licenses/LICENSE-2.0
        String message = arguments.get("message");
    public Object parse(Map<String, String> arguments) {  
 *
import org.opensearch.painless.spi.annotation.AllowlistAnnotationParser;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
    private ExampleAllowlistAnnotationParser() {}  
        }  
 * A singleton class to parse Allowlist Annotations.  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
            throw new IllegalArgumentException("expected message argument");
 * Modifications Copyright OpenSearch Contributors. See
     */  
        }
 * software distributed under the License is distributed on an
        String categoryString = arguments.get("category");
 */  
 */
 * this work for additional information regarding copyright
    /**
            throw new IllegalArgumentException("expected exactly two arguments");
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
/*
    }
 * The OpenSearch Contributors require contributions made to  
        } catch (NumberFormatException nfe) {  
        int category;
 */
 * specific language governing permissions and limitations
        try {
    public static final ExampleAllowlistAnnotationParser INSTANCE = new ExampleAllowlistAnnotationParser();
/**
 *  
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;  
    @Override
     * The singleton instance of this class.
            throw new IllegalArgumentException("expected category argument");
            throw new IllegalArgumentException("expected category as an int, found [" + categoryString + "]", nfe);
        if (arguments.size() != 2) {
        return new ExamplePainlessAnnotation(category, message);
        }  
 * compatible open source license.
