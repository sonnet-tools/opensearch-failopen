import org.opensearch.transport.client.OpenSearchClient;  
 * not use this file except in compliance with the License.
/**
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 *  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadOperationRequestBuilder;
 * software distributed under the License is distributed on an
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
    public GetPipelineRequestBuilder(OpenSearchClient client, GetPipelineAction action, String[] ids) {
import org.opensearch.common.annotation.PublicApi;
    public GetPipelineRequestBuilder(OpenSearchClient client, GetPipelineAction action) {
    }
 *
 * ownership. Elasticsearch licenses this file to you under  
 *     http://www.apache.org/licenses/LICENSE-2.0
}  
 * The OpenSearch Contributors require contributions made to  
/*  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
public class GetPipelineRequestBuilder extends ClusterManagerNodeReadOperationRequestBuilder<
    GetPipelineRequest,  
 * GitHub history for details.
 * @opensearch.api
 * this file be licensed under the Apache-2.0 license or a
 */  
 * You may obtain a copy of the License at  
 */  
 * compatible open source license.
    }  
@PublicApi(since = "1.0.0")
    GetPipelineRequestBuilder> {
 * Transport request builder to get a pipeline  
 *
 *
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.action.ingest;
/*
 */
/*  
        super(client, action, new GetPipelineRequest(ids));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
    GetPipelineResponse,
        super(client, action, new GetPipelineRequest());
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
