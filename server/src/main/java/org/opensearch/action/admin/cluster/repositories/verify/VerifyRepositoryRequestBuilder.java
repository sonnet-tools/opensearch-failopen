     *
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.action.support.clustermanager.ClusterManagerNodeOperationRequestBuilder;
        request.name(name);  
    public VerifyRepositoryRequestBuilder setName(String name) {
    }
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
     * Constructs unregister repository request builder with specified repository name  
 */
 */  
import org.opensearch.common.annotation.PublicApi;
     */
import org.opensearch.transport.client.OpenSearchClient;  
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
     * Constructs unregister repository request builder
    /**
/*  
    /**
 * this work for additional information regarding copyright
        super(client, action, new VerifyRepositoryRequest(name));  
/*  
    }  
 * KIND, either express or implied.  See the License for the
    public VerifyRepositoryRequestBuilder(OpenSearchClient client, VerifyRepositoryAction action) {
 *
 */  
public class VerifyRepositoryRequestBuilder extends ClusterManagerNodeOperationRequestBuilder<
 * You may obtain a copy of the License at  
 *
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
 */  
 *
    VerifyRepositoryRequestBuilder> {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
/*
    /**  
 *  
        return this;
 * software distributed under the License is distributed on an
        super(client, action, new VerifyRepositoryRequest());
 * @opensearch.api
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    VerifyRepositoryResponse,
 * compatible open source license.
     * Sets the repository name
    }
     */
}  
/**
     * @param name the repository name  
    VerifyRepositoryRequest,  
 * GitHub history for details.
package org.opensearch.action.admin.cluster.repositories.verify;
@PublicApi(since = "1.0.0")
     */  
 * Builder for verify repository request  
 * under the License.  
    public VerifyRepositoryRequestBuilder(OpenSearchClient client, VerifyRepositoryAction action, String name) {
 * SPDX-License-Identifier: Apache-2.0
