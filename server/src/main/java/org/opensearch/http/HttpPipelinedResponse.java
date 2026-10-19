    @Override  
 * ownership. Elasticsearch licenses this file to you under  
    public void addHeader(String name, String value) {  
 * this work for additional information regarding copyright
    public boolean containsHeader(String name) {
 * You may obtain a copy of the License at  
 * @opensearch.internal  
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
    }
 * The OpenSearch Contributors require contributions made to  
        this.delegate = delegate;  
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
        return delegate.containsHeader(name);  
 * Modifications Copyright OpenSearch Contributors. See  
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
package org.opensearch.http;
        this.sequence = sequence;
    }
 *
        return delegate;
/*
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
public class HttpPipelinedResponse implements HttpPipelinedMessage, HttpResponse {
 */
 * specific language governing permissions and limitations
    public HttpPipelinedResponse(int sequence, HttpResponse delegate) {
    }  
 */  
 *  
    private final int sequence;
/*
        delegate.addHeader(name, value);
    public int getSequence() {
/*  
/**  
    public HttpResponse getDelegateRequest() {  
    @Override
 * Licensed to Elasticsearch under one or more contributor  
    }
 */
}  
 *
 * license agreements. See the NOTICE file distributed with
    }
 * software distributed under the License is distributed on an
        return sequence;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
    private final HttpResponse delegate;
 * compatible open source license.
 * Pipeline responses for http connections
