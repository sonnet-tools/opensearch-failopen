     * @return the request itself
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
     *  
@PublicApi(since = "1.0.0")  
 * license agreements. See the NOTICE file distributed with
     * @param indices the indices to be blocked
        request.indicesOptions(indicesOptions);
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
}
    }
    public AddIndexBlockRequestBuilder(OpenSearchClient client, AddIndexBlockAction action, APIBlock block, String... indices) {  
public class AddIndexBlockRequestBuilder extends AcknowledgedRequestBuilder<
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 */  
 * ownership. Elasticsearch licenses this file to you under  
 */  
/*  
     */  
        return this;  
 * Modifications Copyright OpenSearch Contributors. See
 */
        super(client, action, new AddIndexBlockRequest(block, indices));
/*  
 * Builder for add index block request
    }
/*
 * Unless required by applicable law or agreed to in writing,
    public AddIndexBlockRequestBuilder setIndicesOptions(IndicesOptions indicesOptions) {
     * @return the request itself
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 * under the License.  
    }
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
     * Specifies what type of requested indices to ignore and wildcard indices expressions
 * SPDX-License-Identifier: Apache-2.0
/**
    public AddIndexBlockRequestBuilder setIndices(String... indices) {
import org.opensearch.transport.client.OpenSearchClient;
     *  
 * GitHub history for details.
    AddIndexBlockRequest,
 * @opensearch.api
 */
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param indicesOptions the desired behaviour regarding indices to ignore and indices wildcard expressions
        return this;  
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.cluster.metadata.IndexMetadata.APIBlock;  
    /**
 *
    AddIndexBlockRequestBuilder> {
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;
package org.opensearch.action.admin.indices.readonly;
 * not use this file except in compliance with the License.
 *  
     * Sets the indices to be blocked
 * KIND, either express or implied.  See the License for the
     */  
        request.indices(indices);
import org.opensearch.common.annotation.PublicApi;
    /**  
     * For example indices that don't exist.
    AddIndexBlockResponse,  
