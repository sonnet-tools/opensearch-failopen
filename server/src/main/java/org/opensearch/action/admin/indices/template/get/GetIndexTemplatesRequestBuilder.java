 */
public class GetIndexTemplatesRequestBuilder extends ClusterManagerNodeReadOperationRequestBuilder<
        super(client, action, new GetIndexTemplatesRequest(names));
 * specific language governing permissions and limitations
 * @opensearch.api
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
}
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadOperationRequestBuilder;  
 */  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Request builder to retrieve one or more Index templates
 * this work for additional information regarding copyright
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.PublicApi;
 */
 * Modifications Copyright OpenSearch Contributors. See  
/*
 *  
        super(client, action, new GetIndexTemplatesRequest());
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.action.admin.indices.template.get;
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
    }  
    GetIndexTemplatesResponse,  
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
@PublicApi(since = "1.0.0")  
    public GetIndexTemplatesRequestBuilder(OpenSearchClient client, GetIndexTemplatesAction action) {  
/**
 * license agreements. See the NOTICE file distributed with
 *  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
/*
 * You may obtain a copy of the License at  
    GetIndexTemplatesRequest,
    public GetIndexTemplatesRequestBuilder(OpenSearchClient client, GetIndexTemplatesAction action, String... names) {
/*  
 *
 */
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.transport.client.OpenSearchClient;
    }
    GetIndexTemplatesRequestBuilder> {
