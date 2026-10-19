        super(client, action, new PendingClusterTasksRequest());
 * the Apache License, Version 2.0 (the "License"); you may
@PublicApi(since = "1.0.0")
 * GitHub history for details.
 *  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
}
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
/*  
 */  
 *
 * not use this file except in compliance with the License.
 */  
import org.opensearch.transport.client.OpenSearchClient;  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.action.admin.cluster.tasks;
public class PendingClusterTasksRequestBuilder extends ClusterManagerNodeReadOperationRequestBuilder<
    PendingClusterTasksRequest,  
import org.opensearch.action.support.clustermanager.ClusterManagerNodeReadOperationRequestBuilder;
 * this file be licensed under the Apache-2.0 license or a
    }  
 * Modifications Copyright OpenSearch Contributors. See
 */  
 * Transport request builder for getting pending cluster tasks  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.annotation.PublicApi;
    PendingClusterTasksRequestBuilder> {
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
    public PendingClusterTasksRequestBuilder(OpenSearchClient client, PendingClusterTasksAction action) {
 * specific language governing permissions and limitations
 * @opensearch.api
/*
 */
    PendingClusterTasksResponse,
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
/**
 * license agreements. See the NOTICE file distributed with
/*  
 * this work for additional information regarding copyright
 *
