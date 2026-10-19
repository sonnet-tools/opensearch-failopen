    }
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 *
import org.opensearch.action.support.broadcast.BroadcastOperationRequestBuilder;
/*  
}  
 * capabilities depends on the index engine used. For example, the internal one requires refresh to be called, but by
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
/*
 * license agreements. See the NOTICE file distributed with
package org.opensearch.action.admin.indices.refresh;
/*  
 */
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 */
 * specific language governing permissions and limitations
@PublicApi(since = "1.0.0")  
 * ownership. Elasticsearch licenses this file to you under  
public class RefreshRequestBuilder extends BroadcastOperationRequestBuilder<RefreshRequest, RefreshResponse, RefreshRequestBuilder> {
import org.opensearch.common.annotation.PublicApi;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * A refresh request making all operations performed since the last refresh available for search. The (near) real-time  
 *
 *  
 * under the License.  
/**
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.transport.client.OpenSearchClient;  
        super(client, action, new RefreshRequest());
 * the Apache License, Version 2.0 (the "License"); you may
    public RefreshRequestBuilder(OpenSearchClient client, RefreshAction action) {  
 * software distributed under the License is distributed on an
 *  
 * GitHub history for details.
 */  
 */  
 * @opensearch.api
 * default a refresh is scheduled periodically.
 * You may obtain a copy of the License at  
