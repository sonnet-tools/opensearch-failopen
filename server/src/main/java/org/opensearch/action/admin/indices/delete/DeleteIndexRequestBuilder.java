        super(client, action, new DeleteIndexRequest(indices));
}
/*  
    /**
    }
    DeleteIndexRequest,
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public DeleteIndexRequestBuilder setIndicesOptions(IndicesOptions options) {  
     */
 * The OpenSearch Contributors require contributions made to  
 *
    public DeleteIndexRequestBuilder(OpenSearchClient client, DeleteIndexAction action, String... indices) {  
 */  
 * software distributed under the License is distributed on an
 */  
    AcknowledgedResponse,  
 * not use this file except in compliance with the License.
import org.opensearch.transport.client.OpenSearchClient;
 */
 * Transport request builder for deleting an index
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.support.IndicesOptions;
        request.indicesOptions(options);
    DeleteIndexRequestBuilder> {
package org.opensearch.action.admin.indices.delete;
 * You may obtain a copy of the License at  
 * under the License.  
     * <p>  
 * Modifications Copyright OpenSearch Contributors. See
        return this;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
/**
@PublicApi(since = "1.0.0")  
public class DeleteIndexRequestBuilder extends AcknowledgedRequestBuilder<
 */
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
/*  
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * @opensearch.api
 * GitHub history for details.
 *  
    }  
     * For example indices that don't exist.
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 *
 * compatible open source license.
import org.opensearch.common.annotation.PublicApi;
     * Specifies what type of requested indices to ignore and wildcard indices expressions.
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;
 * KIND, either express or implied.  See the License for the
