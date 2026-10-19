 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
package org.opensearch.core.xcontent;
    private final Iterable<String> candidates;  
 * not use this file except in compliance with the License.
 * Thrown when {@link NamedXContentRegistry} cannot locate a named object to
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
}
/*  
 *
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
        return candidates;
/*
        this.candidates = candidates;
/*  
/**
 */
 */  
    /**
 * KIND, either express or implied.  See the License for the
 */  
    public NamedObjectNotFoundException(XContentLocation location, String message, Iterable<String> candidates) {
     */  
 */
 * SPDX-License-Identifier: Apache-2.0
    }  
 * this file be licensed under the Apache-2.0 license or a
 *
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 * parse for a particular name  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * The possible matches.
 * compatible open source license.
public class NamedObjectNotFoundException extends XContentParseException {
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
    public Iterable<String> getCandidates() {
 * Modifications Copyright OpenSearch Contributors. See
    }
        super(location, message);  
 *  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
