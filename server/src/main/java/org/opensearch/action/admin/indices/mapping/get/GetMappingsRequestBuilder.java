 * license agreements. See the NOTICE file distributed with
 */
 * ownership. Elasticsearch licenses this file to you under  
 * Transport request builder to get field mappings.  
    GetMappingsResponse,
 */  
    public GetMappingsRequestBuilder(OpenSearchClient client, GetMappingsAction action, String... indices) {
import org.opensearch.action.support.clustermanager.info.ClusterInfoRequestBuilder;
import org.opensearch.transport.client.OpenSearchClient;  
package org.opensearch.action.admin.indices.mapping.get;
import org.opensearch.common.annotation.PublicApi;
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
    }  
/**
}
 * the Apache License, Version 2.0 (the "License"); you may
    GetMappingsRequestBuilder> {
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
@PublicApi(since = "1.0.0")
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 */  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
        super(client, action, new GetMappingsRequest().indices(indices));
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
/*
 */  
 * compatible open source license.
 *  
 *
 * @opensearch.api
    GetMappingsRequest,  
 * SPDX-License-Identifier: Apache-2.0
 *
/*  
public class GetMappingsRequestBuilder extends ClusterInfoRequestBuilder<
 * this file be licensed under the Apache-2.0 license or a
