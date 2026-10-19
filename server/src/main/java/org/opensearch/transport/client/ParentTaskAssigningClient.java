 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.cluster.node.DiscoveryNode;  
    /**  
package org.opensearch.transport.client;
    protected <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
     * Fetch the wrapped client. Use this to make calls that don't set {@link ActionRequest#setParentTask(TaskId)}.
 */  
    }  
 * @opensearch.internal
 *  
        super.doExecute(action, request, listener);
        ActionListener<Response> listener
    /**  
 */  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
        this(in, new TaskId(localNode.getId(), parentTask.getId()));  
    private final TaskId parentTask;
 * compatible open source license.
        super(in);
 * specific language governing permissions and limitations
 *
/*
 * Unless required by applicable law or agreed to in writing,
 *
 * A {@linkplain Client} that sets the parent task on all requests that it makes. Use this to conveniently implement actions that cause
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 * many other actions.
public class ParentTaskAssigningClient extends FilterClient {  
import org.opensearch.core.action.ActionResponse;
import org.opensearch.action.ActionRequest;
 * software distributed under the License is distributed on an
     * Standard constructor.
import org.opensearch.tasks.Task;
import org.opensearch.core.action.ActionListener;
 * You may obtain a copy of the License at  
        ActionType<Response> action,  
        request.setParentTask(parentTask);
 * not use this file except in compliance with the License.
/*  
 */
 * under the License.  
        this.parentTask = parentTask;
    public Client unwrap() {  
 *  
    }
     */
    public ParentTaskAssigningClient(Client in, TaskId parentTask) {  
import org.opensearch.action.ActionType;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
     */
        return in();
import org.opensearch.core.tasks.TaskId;  
    }  
 * this file be licensed under the Apache-2.0 license or a
        Request request,
 * Licensed to Elasticsearch under one or more contributor  
    }
    public ParentTaskAssigningClient(Client in, DiscoveryNode localNode, Task parentTask) {
/*  
    /**
     * Convenience constructor for building the TaskId out of what is usually at hand.  
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 */
 * ownership. Elasticsearch licenses this file to you under  
/**  
 * The OpenSearch Contributors require contributions made to  
    @Override
}
    ) {  
     */
