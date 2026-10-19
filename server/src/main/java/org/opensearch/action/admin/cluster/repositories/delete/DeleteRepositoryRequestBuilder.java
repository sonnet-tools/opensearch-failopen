 *
 */
    }
    }
        return this;
import org.opensearch.action.support.clustermanager.AcknowledgedRequestBuilder;
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
 * Licensed to Elasticsearch under one or more contributor  
     * Sets the repository name
        super(client, action, new DeleteRepositoryRequest(name));
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
     */
    AcknowledgedResponse,
 * software distributed under the License is distributed on an
/**  
 */
package org.opensearch.action.admin.cluster.repositories.delete;
    public DeleteRepositoryRequestBuilder(OpenSearchClient client, DeleteRepositoryAction action, String name) {  
    /**
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
     * @param name the repository name
 * this work for additional information regarding copyright
     *  
        super(client, action, new DeleteRepositoryRequest());  
 *
        request.name(name);
 * The OpenSearch Contributors require contributions made to  
    public DeleteRepositoryRequestBuilder setName(String name) {  
     * Constructs unregister repository request builder with specified repository name
 */  
    /**  
 */  
    /**
     */
import org.opensearch.transport.client.OpenSearchClient;
 * license agreements. See the NOTICE file distributed with
 * Builder for unregister repository request
     */
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.annotation.PublicApi;  
    DeleteRepositoryRequest,
public class DeleteRepositoryRequestBuilder extends AcknowledgedRequestBuilder<  
}
 * Unless required by applicable law or agreed to in writing,
/*  
 * under the License.  
 * compatible open source license.
@PublicApi(since = "1.0.0")
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 *
/*
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.api  
    DeleteRepositoryRequestBuilder> {  
    public DeleteRepositoryRequestBuilder(OpenSearchClient client, DeleteRepositoryAction action) {
 *  
 * GitHub history for details.
    }  
/*  
     * Constructs unregister repository request builder  
