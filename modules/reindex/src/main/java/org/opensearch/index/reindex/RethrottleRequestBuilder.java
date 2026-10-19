        request.setRequestsPerSecond(requestsPerSecond);
 * SPDX-License-Identifier: Apache-2.0
     * Throttling is done between batches, as we start the next scroll requests. That way we can increase the scroll's timeout to make sure
 * license agreements. See the NOTICE file distributed with
 *
import org.opensearch.action.ActionType;
    public RethrottleRequestBuilder setRequestsPerSecond(float requestsPerSecond) {
/*  
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.support.tasks.TasksRequestBuilder;  
 * software distributed under the License is distributed on an
 * under the License.  
        super(client, action, new RethrottleRequest());
 * The OpenSearch Contributors require contributions made to  
    }
/**  
 *
 *  
 * Java API support for changing the throttle on reindex tasks while they are running.
import org.opensearch.transport.client.OpenSearchClient;
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
/*
}
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 */
    public RethrottleRequestBuilder(OpenSearchClient client, ActionType<ListTasksResponse> action) {
/*  
 * You may obtain a copy of the License at  
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
    /**
 * KIND, either express or implied.  See the License for the
        return this;  
    }  
 * specific language governing permissions and limitations
     * Set the throttle to apply to all matching requests in sub-requests per second. {@link Float#POSITIVE_INFINITY} means set no throttle.  
package org.opensearch.index.reindex;
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.action.admin.cluster.node.tasks.list.ListTasksResponse;
 */  
 */
     * that it contains any time that we might wait.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
public class RethrottleRequestBuilder extends TasksRequestBuilder<RethrottleRequest, ListTasksResponse, RethrottleRequestBuilder> {  
     */  
