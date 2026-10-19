    public CancelTasksRequestBuilder(OpenSearchClient client, CancelTasksAction action) {
 *
 * The OpenSearch Contributors require contributions made to  
/**
 * Modifications Copyright OpenSearch Contributors. See
 *  
        return this;
    public CancelTasksRequestBuilder waitForCompletion(boolean waitForCompletion) {
 * Unless required by applicable law or agreed to in writing,
/*  
        super(client, action, new CancelTasksRequest());
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * compatible open source license.
    }  
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * KIND, either express or implied.  See the License for the
 */  
package org.opensearch.action.admin.cluster.node.tasks.cancel;
 * under the License.  
    }
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
@PublicApi(since = "1.0.0")
 *
import org.opensearch.transport.client.OpenSearchClient;  
        request.setWaitForCompletion(waitForCompletion);  
public class CancelTasksRequestBuilder extends TasksRequestBuilder<CancelTasksRequest, CancelTasksResponse, CancelTasksRequestBuilder> {
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
}  
 */  
 * software distributed under the License is distributed on an
 * Builder for the request to cancel tasks running on the specified nodes  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
import org.opensearch.action.support.tasks.TasksRequestBuilder;
 * license agreements. See the NOTICE file distributed with
/*  
 * GitHub history for details.
import org.opensearch.common.annotation.PublicApi;
 *
 */  
 * @opensearch.api
