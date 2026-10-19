 * under the License.  
 * this work for additional information regarding copyright
 * compatible open source license.
     *  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
    public String getMessage() {  
    public ExamplePainlessAnnotation(int category, String message) {
 */
    }
 */  
 */  
 * KIND, either express or implied.  See the License for the
    /**  
 * Unless required by applicable law or agreed to in writing,
    public int category;
 * GitHub history for details.
     */
}  
     * The annotation name.
 */  
 * ownership. Elasticsearch licenses this file to you under  
     * @param category The category of the annotation..
 * software distributed under the License is distributed on an
 * The annotation below is allowlisted for use in search scripts.
 * <p>  
/*  
     *
    }
    /**
     * Gets the message.
/**
 * not use this file except in compliance with the License.
    public static final String NAME = "example_annotation";  
package org.opensearch.example.painlessallowlist;
     */
 * Modifications Copyright OpenSearch Contributors. See
 *
 * specific language governing permissions and limitations
     * Gets the category.
    /**  
 * The OpenSearch Contributors require contributions made to  
 *  
    /**
     */
     */
 * Licensed to Elasticsearch under one or more contributor  
     * @return the category.
 * this file be licensed under the Apache-2.0 license or a
/*
 * See <a href="file:example_allowlist.txt">example_allowlist.txt</a>.
    /**
    /**
    public String message;  
     * The category field of the annotation.  
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
        return category;
    }
     * @param message The message for the annotation.  
    public int getCategory() {  
        this.message = message;
 * An example of an annotation to be allowlisted for use by painless scripts
public class ExamplePainlessAnnotation {
/*  
     * @return the message.
     */
     *  
 *
     * The message field of the annotation.
 * license agreements. See the NOTICE file distributed with
        this.category = category;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return message;
     * Create this annotation with the given category and message.  
