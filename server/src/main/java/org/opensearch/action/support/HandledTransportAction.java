    ) {  
        TransportService transportService,  
    }
 */
 * Licensed to Elasticsearch under one or more contributor  
            canTripCircuitBreaker,
import org.opensearch.threadpool.ThreadPool;
            actionName,  
            requestReader,
        Writeable.Reader<Request> requestReader
     */
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );
 *  
    class TransportHandler implements TransportRequestHandler<Request> {
        ActionFilters actionFilters,
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 */  
        Writeable.Reader<Request> requestReader,
        ActionFilters actionFilters,
            // We already got the task created on the network layer - no need to create it again on the transport layer
        );
 * compatible open source license.
        TransportService transportService,
        this(actionName, true, transportService, actionFilters, requestReader);
     *
        TransportService transportService,
    ) {
    Request,
/*  
    Response> {
    protected HandledTransportAction(  
 * ownership. Elasticsearch licenses this file to you under  
            actionFilters,
 *     http://www.apache.org/licenses/LICENSE-2.0
        ActionFilters actionFilters,
        transportService.registerRequestHandler(  
    ) {
        AdmissionControlActionType admissionControlActionType,  
            executor,
    }
/*
        this(actionName, canTripCircuitBreaker, null, transportService, actionFilters, requestReader, ThreadPool.Names.SAME);  
        TransportService transportService,  
    }
        String actionName,  
            false,  
/*
 * Modifications Copyright OpenSearch Contributors. See  
 * Unless required by applicable law or agreed to in writing,
        super(actionName, actionFilters, transportService.getTaskManager());
            actionName,
    ) {
    /**  
    }  
            transportService,  
import org.opensearch.transport.TransportService;
    protected HandledTransportAction(
public abstract class HandledTransportAction<Request extends ActionRequest, Response extends ActionResponse> extends TransportAction<  
    protected HandledTransportAction(
}
        Writeable.Reader<Request> requestReader,
 * KIND, either express or implied.  See the License for the
 *  
        this(actionName, true, null, transportService, actionFilters, requestReader, executor);
        ActionFilters actionFilters,  
 *
        TransportService transportService,
    }
import org.opensearch.ratelimitting.admissioncontrol.enums.AdmissionControlActionType;  
 * specific language governing permissions and limitations
        String executor
     * Inner transport handler
            execute(task, request, new ChannelActionListener<>(channel, actionName, request));  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.transport.TransportChannel;  
import org.opensearch.core.common.io.stream.Writeable;
 * software distributed under the License is distributed on an
            admissionControlActionType,
import org.opensearch.transport.TransportRequestHandler;
import org.opensearch.core.action.ActionResponse;
        String executor  
 */
            requestReader,  
        String actionName,
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action.support;
        @Override  
 * SPDX-License-Identifier: Apache-2.0
        boolean canTripCircuitBreaker,
import org.opensearch.action.ActionRequest;  
            canTripCircuitBreaker,
        boolean canTripCircuitBreaker,
 * under the License.  
        String actionName,
/**
        this(
            admissionControlActionType,
            ThreadPool.Names.SAME  
     * @opensearch.internal  
 * @opensearch.internal
    ) {  
 */
    protected HandledTransportAction(
 * You may obtain a copy of the License at  
        ActionFilters actionFilters,  
 * A TransportAction that self registers a handler into the transport service
 *
 * this work for additional information regarding copyright
        String actionName,
    protected HandledTransportAction(
        Writeable.Reader<Request> requestReader  
import org.opensearch.tasks.Task;
    }
        String actionName,
        public final void messageReceived(final Request request, final TransportChannel channel, Task task) {
        boolean canTripCircuitBreaker,  
 * The OpenSearch Contributors require contributions made to  
        }
        Writeable.Reader<Request> requestReader
        AdmissionControlActionType admissionControlActionType,
            new TransportHandler()
