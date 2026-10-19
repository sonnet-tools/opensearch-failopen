 * SPDX-License-Identifier: Apache-2.0
}
        this.status = status;
 */  
            values.add(value);  
 * You may obtain a copy of the License at  
    @Override
    }
    private final BytesReference content;  
        return content;  
 * compatible open source license.
    public void addHeader(String name, String value) {  
 * Licensed to Elasticsearch under one or more contributor  
        if (headers.containsKey(name) == false) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    TestHttpResponse(RestStatus status, BytesReference content) {  
            ArrayList<String> values = new ArrayList<>();
        } else {
        return headers;
    private final Map<String, List<String>> headers = new HashMap<>();
    }  
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
 * GitHub history for details.
 */
    private final RestStatus status;
    @Override
/*  
/*  
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
import org.opensearch.core.common.bytes.BytesReference;
    public RestStatus status() {  
import java.util.List;  
 *
    }
/*
 * The OpenSearch Contributors require contributions made to  
    }  
import org.opensearch.core.rest.RestStatus;
import java.util.Map;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
    public Map<String, List<String>> headers() {
 * under the License.  
    }
import java.util.ArrayList;
package org.opensearch.http;
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
        return headers.containsKey(name);  
        this.content = content;
 * software distributed under the License is distributed on an
        }
 */  
            headers.put(name, values);
    public boolean containsHeader(String name) {
    }
 * this file be licensed under the Apache-2.0 license or a
import java.util.HashMap;
        return status;
class TestHttpResponse implements HttpResponse {  
    public BytesReference content() {
            headers.get(name).add(value);  
 * KIND, either express or implied.  See the License for the
 *
 *  
