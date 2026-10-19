            transportOptions,
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.action.ActionResponse;
package org.opensearch.action;
 * Modifications Copyright OpenSearch Contributors. See
 * A generic proxy that will execute the given action against a specific node.  
    private final TransportRequestOptions transportOptions;
            new ActionListenerResponseHandler<>(listener, action.getResponseReader())  
 * KIND, either express or implied.  See the License for the
    }
            node,
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
import org.opensearch.cluster.node.DiscoveryNode;
        ActionRequestValidationException validationException = request.validate();
import org.opensearch.transport.TransportService;  
import org.opensearch.common.settings.Settings;
 * @opensearch.internal
    }
 * compatible open source license.
/*
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 *
 * under the License.  
 *     http://www.apache.org/licenses/LICENSE-2.0
    private final TransportService transportService;  
/*  
        }  
    public void execute(final DiscoveryNode node, final Request request, final ActionListener<Response> listener) {
/**
        this.transportService = transportService;  
 */  
    private final ActionType<Response> action;
 * The OpenSearch Contributors require contributions made to  
            request,
            listener.onFailure(validationException);
 * You may obtain a copy of the License at  
        transportService.sendRequest(
 * this work for additional information regarding copyright
 *  
    public TransportActionNodeProxy(Settings settings, ActionType<Response> action, TransportService transportService) {
        );
 *
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 */  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.TransportRequestOptions;
import org.opensearch.core.action.ActionListener;  
        this.transportOptions = action.transportOptions(settings);
        if (validationException != null) {  
 * ownership. Elasticsearch licenses this file to you under  
 *
public class TransportActionNodeProxy<Request extends ActionRequest, Response extends ActionResponse> {
}  
        this.action = action;
            return;
            action.name(),  
/*  
