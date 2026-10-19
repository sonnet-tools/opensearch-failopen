    }
        this.action = action;  
            final TaskTransportChannel taskTransportChannel = new TaskTransportChannel(channel, unregisterTask);
 */  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
@PublicApi(since = "1.0.0")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        TransportRequestHandler<R> handler  
import org.opensearch.core.common.io.stream.Writeable;  
            registry.taskManager,
                    );
 * specific language governing permissions and limitations
    }
        ThreadContext.StoredContext contextToRestore = taskManager.taskExecutionStarted(task);
    private final boolean canTripCircuitBreaker;
 * KIND, either express or implied.  See the License for the
                final TcpChannel tcpChannel = baseTcpTransportChannel.getChannel();  
    }
            handler.messageReceived(request, taskTransportChannel, task);
    @Override
        this.canTripCircuitBreaker = canTripCircuitBreaker;
            registry.requestReader,
package org.opensearch.transport;
 *    http://www.apache.org/licenses/LICENSE-2.0
            registry.action,  
 *
        }
/**
        return new RequestHandlerRegistry<>(
        final Task task = taskManager.register(channel.getChannelType(), action, request);  
        boolean canTripCircuitBreaker
 * The OpenSearch Contributors require contributions made to  
}  
    public void processMessageReceived(Request request, TransportChannel channel) throws Exception {
    }  
    public String toString() {  
 *
 * under the License.  
import org.opensearch.tasks.TaskManager;
    private final String action;
        return handler.toString();
    }  
import org.opensearch.tasks.CancellableTask;
            if (channel instanceof BaseTcpTransportChannel baseTcpTransportChannel && task instanceof CancellableTask cancellableTask) {
 * software distributed under the License is distributed on an
                        Math.max(0, System.currentTimeMillis() - shardSearchRequest.getInboundNetworkTime())  
    }
 * @opensearch.api
 */
            handler,  
        Writeable.Reader<Request> requestReader,
        return handler;
        this.requestReader = requestReader;
            registry.executor,
    }  
                }
    }
    public String getExecutor() {  
                unregisterTask = Releasables.wrap(unregisterTask, stopTracking);
    ) {
 * SPDX-License-Identifier: Apache-2.0
            }  
        return action;
 * GitHub history for details.
import org.opensearch.common.lease.Releasable;
        );
import org.opensearch.core.common.io.stream.StreamInput;
    }
 * compatible open source license.
/*  
        TaskManager taskManager,  
    public TransportRequestHandler<Request> getHandler() {
    public boolean isForceExecution() {
 *
            registry.canTripCircuitBreaker  
        boolean forceExecution,  
 * the Apache License, Version 2.0 (the "License"); you may
        return requestReader.read(in);
 * this work for additional information regarding copyright
    private final boolean forceExecution;  
    public String getAction() {  
    private final Writeable.Reader<Request> requestReader;
 *  
 * You may obtain a copy of the License at  
    public boolean canTripCircuitBreaker() {
    private final TransportRequestHandler<Request> handler;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.util.concurrent.ThreadContext;
        this.taskManager = taskManager;  
                    // on receiving request, update the inbound network time to reflect time spent in transit over the network
        Releasable unregisterTask = () -> taskManager.unregister(task);  
    public RequestHandlerRegistry(  
        return forceExecution;
        } finally {
import org.opensearch.tasks.Task;  
    private final TaskManager taskManager;  
                if (request instanceof ShardSearchRequest shardSearchRequest) {  
        this.forceExecution = forceExecution;  
        return canTripCircuitBreaker;  
import java.io.IOException;  
/*  
 */  
        TransportRequestHandler<Request> handler,
        return executor;
            unregisterTask = null;  
            Releasables.close(unregisterTask);
public final class RequestHandlerRegistry<Request extends TransportRequest> {
import org.opensearch.common.lease.Releasables;  
    ) {
import org.opensearch.search.internal.ShardSearchRequest;
                final Releasable stopTracking = taskManager.startTrackingCancellableChannelTask(tcpChannel, cancellableTask);
/*
        try {
    }
        this.handler = handler;
            contextToRestore.restore();  
        String action,
        String executor,
        this.executor = executor;
 */  
        RequestHandlerRegistry<R> registry,
 * not use this file except in compliance with the License.
    public static <R extends TransportRequest> RequestHandlerRegistry<R> replaceHandler(
 * ownership. Elasticsearch licenses this file to you under  
    public Request newRequest(StreamInput in) throws IOException {
 * Registry for OpenSearch RequestHandlers  
                    shardSearchRequest.setInboundNetworkTime(
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.annotation.PublicApi;
    private final String executor;
            registry.forceExecution,
 * Modifications Copyright OpenSearch Contributors. See
