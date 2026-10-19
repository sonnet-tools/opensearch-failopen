public class GetRepositoriesRequestBuilder extends ClusterManagerNodeReadOperationRequestBuilder<  
        request.repositories(ArrayUtils.concat(request.repositories(), repositories));
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
@PublicApi(since = "1.0.0")
package org.opensearch.action.admin.cluster.repositories.get;
    public GetRepositoriesRequestBuilder(OpenSearchClient client, GetRepositoriesAction action, String... repositories) {  
    }  
     * Creates new get repository request builder
    }
/**  
     */
    }
     *  
        super(client, action, new GetRepositoriesRequest());  
    public GetRepositoriesRequestBuilder addRepositories(String... repositories) {  
    /**  
    GetRepositoriesRequest,
        return this;
    }
     */
        return this;  
    public GetRepositoriesRequestBuilder setRepositories(String... repositories) {
/*  
 * You may obtain a copy of the License at  
 *
 * Get repository request builder
     */  
 * software distributed under the License is distributed on an
}
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 *  
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.common.util.ArrayUtils;  
 *
 * license agreements. See the NOTICE file distributed with
 * @opensearch.api  
 * under the License.  
 * GitHub history for details.
    GetRepositoriesResponse,
     *
 * not use this file except in compliance with the License.
     */
 */
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadOperationRequestBuilder;
 */  
     * @return builder
        super(client, action, new GetRepositoriesRequest(repositories));
    /**  
/*  
import org.opensearch.transport.client.OpenSearchClient;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
 */  
    GetRepositoriesRequestBuilder> {  
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Adds repositories to the list of repositories to get
    public GetRepositoriesRequestBuilder(OpenSearchClient client, GetRepositoriesAction action) {
     * Creates new get repository request builder  
     * @param repositories list of repositories  
    /**
 *
     * @return builder
     * Sets list of repositories to get
        request.repositories(repositories);
/*
 * Unless required by applicable law or agreed to in writing,
    /**
     * @param repositories list of repositories
 * this work for additional information regarding copyright
