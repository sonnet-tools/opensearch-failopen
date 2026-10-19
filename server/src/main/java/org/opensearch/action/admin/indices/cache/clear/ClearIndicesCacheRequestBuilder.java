    public ClearIndicesCacheRequestBuilder setFileCache(boolean fileCache) {  
import org.opensearch.action.support.broadcast.BroadcastOperationRequestBuilder;
 */
 * Modifications Copyright OpenSearch Contributors. See
/**
    public ClearIndicesCacheRequestBuilder(OpenSearchClient client, ClearIndicesCacheAction action) {
    }  
 * ownership. Elasticsearch licenses this file to you under  
    }
    public ClearIndicesCacheRequestBuilder setFieldDataCache(boolean fieldDataCache) {
 * software distributed under the License is distributed on an
    public ClearIndicesCacheRequestBuilder setRequestCache(boolean requestCache) {
 * not use this file except in compliance with the License.
/*  
 * Transport request builder for clearing cache  
public class ClearIndicesCacheRequestBuilder extends BroadcastOperationRequestBuilder<
 * this file be licensed under the Apache-2.0 license or a
        request.fieldDataCache(fieldDataCache);  
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
        request.fileCache(fileCache);
 * Licensed to Elasticsearch under one or more contributor  
/*  
 */  
 *  
 * GitHub history for details.
    public ClearIndicesCacheRequestBuilder setQueryCache(boolean queryCache) {
 *
import org.opensearch.transport.client.OpenSearchClient;  
 * Unless required by applicable law or agreed to in writing,
        request.fields(fields);
    }
        return this;
}  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
import org.opensearch.common.annotation.PublicApi;
        return this;
@PublicApi(since = "1.0.0")
        return this;  
 * The OpenSearch Contributors require contributions made to  
 */  
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
    public ClearIndicesCacheRequestBuilder setFields(String... fields) {
        request.queryCache(queryCache);  
 * under the License.  
package org.opensearch.action.admin.indices.cache.clear;
    }
 * the Apache License, Version 2.0 (the "License"); you may
/*
        return this;  
 *
        super(client, action, new ClearIndicesCacheRequest());
        request.requestCache(requestCache);
 * license agreements. See the NOTICE file distributed with
    ClearIndicesCacheResponse,
    }  
 * @opensearch.api
 *
 */  
        return this;
    ClearIndicesCacheRequestBuilder> {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    ClearIndicesCacheRequest,  
 * this work for additional information regarding copyright
