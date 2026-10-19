 * Unless required by applicable law or agreed to in writing,
        return this;
    /**
 * license agreements. See the NOTICE file distributed with
/*  
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 */  
}
/*  
        super(client, action, new ListTasksRequest());
 *
        return this;  
     * Should detailed task information be returned.  
    }
 * not use this file except in compliance with the License.
 * Builder for the request to retrieve the list of tasks running on the specified nodes  
 */  
 * @opensearch.api
 */  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.transport.client.OpenSearchClient;  
    public ListTasksRequestBuilder(OpenSearchClient client, ListTasksAction action) {
        request.setDetailed(detailed);  
     * Should this request wait for all found tasks to complete?
 *  
 * under the License.  
import org.opensearch.action.support.tasks.TasksRequestBuilder;
 * You may obtain a copy of the License at  
 *
    /**
 * this file be licensed under the Apache-2.0 license or a
 */
 * this work for additional information regarding copyright
    }  
/**
     */  
package org.opensearch.action.admin.cluster.node.tasks.list;
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
@PublicApi(since = "1.0.0")
import org.opensearch.common.annotation.PublicApi;
 *     http://www.apache.org/licenses/LICENSE-2.0
    public ListTasksRequestBuilder setDetailed(boolean detailed) {
public class ListTasksRequestBuilder extends TasksRequestBuilder<ListTasksRequest, ListTasksResponse, ListTasksRequestBuilder> {
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
/*
     */
 * KIND, either express or implied.  See the License for the
    public final ListTasksRequestBuilder setWaitForCompletion(boolean waitForCompletion) {
    }
 * specific language governing permissions and limitations
        request.setWaitForCompletion(waitForCompletion);
