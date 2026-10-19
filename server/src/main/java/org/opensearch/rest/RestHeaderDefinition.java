 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
/*
}  
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
    public RestHeaderDefinition(String name, boolean multiValueAllowed) {  
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
    private final boolean multiValueAllowed;
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
    }
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 *
public final class RestHeaderDefinition {
 * this work for additional information regarding copyright
/*  
     * values.
 * reading the request on the rest layer.  
    private final String name;
        this.name = name;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
 * A definition for an http header that should be copied to the {@link org.opensearch.common.util.concurrent.ThreadContext} when
 * under the License.  
        this.multiValueAllowed = multiValueAllowed;
        return multiValueAllowed;
    /**  
    public String getName() {
 * software distributed under the License is distributed on an
 *  
     * This should be set to true only when the syntax of the value of the Header to copy is defined as a comma separated list of String
 */  
 * @opensearch.api
/*  
        return name;  
 * You may obtain a copy of the License at  
    public boolean isMultiValueAllowed() {  
package org.opensearch.rest;
 *
 *
 * The OpenSearch Contributors require contributions made to  
/**
    }  
     */  
 */  
    }
