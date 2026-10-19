/*
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
/**
        request.addFeatures(features);
 * compatible open source license.
public class GetIndexRequestBuilder extends ClusterInfoRequestBuilder<GetIndexRequest, GetIndexResponse, GetIndexRequestBuilder> {
 * under the License.  
 */
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
    }
 *
 * specific language governing permissions and limitations
    public GetIndexRequestBuilder addFeatures(GetIndexRequest.Feature... features) {
 * Licensed to Elasticsearch under one or more contributor  
 *  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.api
 * Unless required by applicable law or agreed to in writing,
        return this;
 * Transport request builder to get information about an index.  
 * software distributed under the License is distributed on an
    public GetIndexRequestBuilder setFeatures(GetIndexRequest.Feature... features) {
    public GetIndexRequestBuilder(OpenSearchClient client, GetIndexAction action, String... indices) {
/*  
import org.opensearch.action.support.clustermanager.info.ClusterInfoRequestBuilder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        request.features(features);  
 *
 *
        super(client, action, new GetIndexRequest().indices(indices));
 * KIND, either express or implied.  See the License for the
package org.opensearch.action.admin.indices.get;
@PublicApi(since = "1.0.0")
 */  
    }  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.transport.client.OpenSearchClient;  
 */  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.annotation.PublicApi;
}
 * license agreements. See the NOTICE file distributed with
/*  
        return this;  
 */  
 * not use this file except in compliance with the License.
