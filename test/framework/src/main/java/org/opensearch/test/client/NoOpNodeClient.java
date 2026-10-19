    ) {  
    }
 * ownership. Elasticsearch licenses this file to you under  
 */
public class NoOpNodeClient extends NodeClient {  
import org.opensearch.transport.RemoteClusterService;
        }
 * compatible open source license.
    }
     */
/*
    public <Request extends ActionRequest, Response extends ActionResponse> void doExecute(
        ActionListener<Response> listener
    public <Request extends ActionRequest, Response extends ActionResponse> Task executeLocally(  
import org.opensearch.common.settings.Settings;
 */  
 *
        return null;  
        return null;  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
    public String getLocalNodeId() {
        } catch (Exception e) {  
        NamedWriteableRegistry namedWriteableRegistry  
    }  
        super(Settings.EMPTY, threadPool);  
 * {@link #executeLocally(ActionType, ActionRequest, ActionListener)}, or {@link #executeLocally(ActionType, ActionRequest, TaskListener)}
 * under the License.  
import org.opensearch.OpenSearchException;
import org.opensearch.threadpool.TestThreadPool;
        ActionType<Response> action,
            ThreadPool.terminate(threadPool(), 10, TimeUnit.SECONDS);
    }  
        DynamicActionRegistry dynamicActionRegistry,  
import org.opensearch.core.action.ActionResponse;
        super(Settings.EMPTY, new TestThreadPool(testName));
import org.opensearch.action.ActionRequest;  
    public Client getRemoteClusterClient(String clusterAlias) {
 */  
}
 * for testing.
    }
        return null;
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
import org.opensearch.action.ActionModule.DynamicActionRegistry;
        try {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * GitHub history for details.
 *  
    @Override  
    ) {
 * this file be licensed under the Apache-2.0 license or a
    public void initialize(
        throw new UnsupportedOperationException("cannot initialize " + this.getClass().getSimpleName());
import java.util.function.Supplier;  
    public NoOpNodeClient(ThreadPool threadPool) {
     * Create a new {@link TestThreadPool} for this client. This {@linkplain TestThreadPool} is terminated on {@link #close()}.
    @Override  
/**
 * See also {@link NoOpClient} if you do not specifically need a {@link NodeClient}.
    @Override
    public void close() {  
        return null;
        TaskListener<Response> listener
        ActionType<Response> action,
        listener.onResponse(null);
    ) {
import java.util.concurrent.TimeUnit;
 * The OpenSearch Contributors require contributions made to  
            throw new OpenSearchException(e.getMessage(), e);
        listener.onResponse(null, null);  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
        Request request,  
        ActionListener<Response> listener  
    @Override
import org.opensearch.tasks.Task;  
    /**
    public NoOpNodeClient(String testName) {  
import org.opensearch.transport.client.Client;
    @Override
    }
    /**  
        Supplier<String> localNodeId,
 * <p>  
    public <Request extends ActionRequest, Response extends ActionResponse> Task executeLocally(
import org.opensearch.threadpool.ThreadPool;  
package org.opensearch.test.client;
        Request request,
/*  
     * Build with {@link ThreadPool}. This {@linkplain ThreadPool} is terminated on {@link #close()}.  
import org.opensearch.tasks.TaskListener;
import org.opensearch.transport.client.node.NodeClient;  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    ) {
 * Client that always response with {@code null} to every request. Override {@link #doExecute(ActionType, ActionRequest, ActionListener)},  
     */
 * this work for additional information regarding copyright
    }
 */
 * You may obtain a copy of the License at  
    }  
 * specific language governing permissions and limitations
        RemoteClusterService remoteClusterService,
 * license agreements. See the NOTICE file distributed with
/*  
        Request request,
        listener.onResponse(null);
 * Modifications Copyright OpenSearch Contributors. See
    @Override
        ActionType<Response> action,  
 * software distributed under the License is distributed on an
import org.opensearch.action.ActionType;
    }
import org.opensearch.core.action.ActionListener;  
 *     http://www.apache.org/licenses/LICENSE-2.0
