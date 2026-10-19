        return remoteClusterService.getRemoteClusterClient(threadPool(), clusterAlias);
     */
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
     * Prefer this method if you don't need access to the task when listening for the response. This is the method used to implement
 * Client that executes actions on the local node.
    /**  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public String getLocalNodeId() {
     * The id of the local {@link DiscoveryNode}. Useful for generating task ids from tasks returned by
        DynamicActionRegistry actionRegistry,
        this.remoteClusterService = remoteClusterService;
        ActionType<Response> action,
 * compatible open source license.
        this.localNodeId = localNodeId;
    ) {
    public <Request extends ActionRequest, Response extends ActionResponse> Task executeLocally(
import java.util.function.Supplier;
    /**  
    }
        ActionListener<Response> listener  
    @Override
import org.opensearch.tasks.Task;  
    ) {  
        ActionListener<Response> listener
}  
/*
    }  
    }
        super(settings, threadPool);  
        ActionType<Response> action
/**  
        ActionType<Response> action,  
 * not use this file except in compliance with the License.
     * method if you need access to the task when listening for the response.  
 * Unless required by applicable law or agreed to in writing,
    /**  
public class NodeClient extends AbstractClient {  
import org.opensearch.common.annotation.PublicApi;
        Request request,
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
        return super.prepareStreamSearch(indices);
import org.opensearch.core.action.ActionListener;  
 */  
    public <Request extends ActionRequest, Response extends ActionResponse> void doExecute(  
        if (actionRegistry == null) {
        ActionType<Response> action,  
        return transportAction;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
     */
    }
        return namedWriteableRegistry;
import org.opensearch.tasks.TaskListener;
import org.opensearch.transport.client.support.AbstractClient;
@PublicApi(since = "1.0.0")
        // Discard the task because the Client interface doesn't use it.
        return localNodeId.get();  
    }
    private <Request extends ActionRequest, Response extends ActionResponse> TransportAction<Request, Response> transportAction(
 * ownership. Elasticsearch licenses this file to you under  
    private NamedWriteableRegistry namedWriteableRegistry;  
    public NamedWriteableRegistry getNamedWriteableRegistry() {
import org.opensearch.action.ActionType;  
 * Licensed to Elasticsearch under one or more contributor  
 *
        Supplier<String> localNodeId,
    private RemoteClusterService remoteClusterService;
 *
 *
import org.opensearch.transport.client.Client;
        executeLocally(action, request, listener);  
     * The id of the local {@link DiscoveryNode}. Useful for generating task ids from tasks returned by
package org.opensearch.transport.client.node;
/*  
    }  
 */
    ) {  
import org.opensearch.transport.RemoteClusterService;  
 * specific language governing permissions and limitations
 */
    public NodeClient(Settings settings, ThreadPool threadPool) {
 *  
 */  
    ) {
     * {@link #executeLocally(ActionType, ActionRequest, TaskListener)}.
 * Modifications Copyright OpenSearch Contributors. See
        RemoteClusterService remoteClusterService,  
    }
    public <Request extends ActionRequest, Response extends ActionResponse> Task executeLocally(
    /**
        NamedWriteableRegistry namedWriteableRegistry
    @Override
    }
            throw new IllegalStateException("NodeClient has not been initialized");
 * GitHub history for details.
    @Override
     * {@link #executeLocally(ActionType, ActionRequest, TaskListener)}.  
        return transportAction(action).execute(request, listener);
 * SPDX-License-Identifier: Apache-2.0
        if (transportAction == null) {
    ) {  
        return transportAction(action).execute(request, listener);
     * Get the {@link TransportAction} for an {@link ActionType}, throwing exceptions if the action isn't available.
import org.opensearch.common.settings.Settings;
import org.opensearch.core.action.ActionResponse;
/*  
import org.opensearch.threadpool.ThreadPool;
    }
 * @opensearch.api  
 * the Apache License, Version 2.0 (the "License"); you may
     * Execute an {@link ActionType} locally, returning that {@link Task} used to track it, and linking an {@link TaskListener}. Prefer this
    public Client getRemoteClusterClient(String clusterAlias) {  
        TransportAction<Request, Response> transportAction = (TransportAction<Request, Response>) actionRegistry.get(action);
    /**
    private Supplier<String> localNodeId;
    }  
    public void close() {
    public void initialize(  
        Request request,
    private DynamicActionRegistry actionRegistry;
        // nothing really to do
     * Execute an {@link ActionType} locally, returning that {@link Task} used to track it, and linking an {@link ActionListener}.
        Request request,
        this.actionRegistry = actionRegistry;  
import org.opensearch.action.ActionModule.DynamicActionRegistry;
import org.opensearch.action.ActionRequest;
 * The OpenSearch Contributors require contributions made to  
     */
        }
        }  
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * this work for additional information regarding copyright
import org.opensearch.action.support.TransportAction;
     * the {@link Client} interface.  
import org.opensearch.cluster.node.DiscoveryNode;  
     */  
        TaskListener<Response> listener
    @Override  
            throw new IllegalStateException("failed to find action [" + action + "] to execute");  
        this.namedWriteableRegistry = namedWriteableRegistry;  
 * software distributed under the License is distributed on an
 * under the License.  
import org.opensearch.action.search.SearchRequestBuilder;
    @SuppressWarnings("unchecked")  
    public SearchRequestBuilder prepareStreamSearch(String... indices) {  
