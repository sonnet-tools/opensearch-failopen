        return this;
     * Sets the preference to execute the search. Defaults to randomize across shards. Can be set to  
    }  
    /**  
    }
 */  
        for (String id : ids) {  
 * Modifications Copyright OpenSearch Contributors. See
        request.add(index, id);  
            request.add(index, id);  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
        return this;
    public MultiGetRequestBuilder setPreference(String preference) {
 * You may obtain a copy of the License at  
    public MultiGetRequestBuilder add(String index, Iterable<String> ids) {
    public MultiGetRequestBuilder add(MultiGetRequest.Item item) {  
import org.opensearch.transport.client.OpenSearchClient;  
@PublicApi(since = "1.0.0")
        return this;  
 * KIND, either express or implied.  See the License for the
     * {@code _local} to prefer local shards or a custom value, which guarantees that the same order
     */
 * specific language governing permissions and limitations
        request.add(item);
 * The OpenSearch Contributors require contributions made to  
            request.add(index, id);
        return this;
 * A multi get document action request builder.  
        }
import org.opensearch.action.ActionRequestBuilder;
        return this;
    }  
    public MultiGetRequestBuilder add(String index, String id) {
 * SPDX-License-Identifier: Apache-2.0
    }
public class MultiGetRequestBuilder extends ActionRequestBuilder<MultiGetRequest, MultiGetResponse> {
    /**
 * this work for additional information regarding copyright
    }
        request.preference(preference);
 */  
    }
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 *
/**
/*  
 * under the License.  
/*
 *  
 *
     * to {@code false}.  
        request.realtime(realtime);
package org.opensearch.action.get;
        request.refresh(refresh);  
     */  
 * @opensearch.api
 * this file be licensed under the Apache-2.0 license or a
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
    public MultiGetRequestBuilder setRefresh(boolean refresh) {
 */
        return this;  
import org.opensearch.common.annotation.PublicApi;
     * will be used across different requests.
        for (String id : ids) {
        }
 * not use this file except in compliance with the License.
    public MultiGetRequestBuilder(OpenSearchClient client, MultiGetAction action) {
 * the Apache License, Version 2.0 (the "License"); you may
 */  
/*  
}
    }  
     * return the latest value. Note, heavy get should not set this to {@code true}. Defaults
    public MultiGetRequestBuilder setRealtime(boolean realtime) {
        return this;  
 * Unless required by applicable law or agreed to in writing,
     * Should a refresh be executed before this get operation causing the operation to
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    public MultiGetRequestBuilder add(String index, String... ids) {
        super(client, action, new MultiGetRequest());
