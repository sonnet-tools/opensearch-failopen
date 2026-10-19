        } catch (Exception e) {
package org.opensearch.action.support;
        this.actionName = actionName;
 * this file be licensed under the Apache-2.0 license or a
 *  
/*  
import org.opensearch.core.transport.TransportResponse;
        try {  
/*
 * The OpenSearch Contributors require contributions made to  
        }
/**  
 */
 * specific language governing permissions and limitations
    }
    public void onFailure(Exception e) {
    @Override
 *
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 * @opensearch.internal  
 * You may obtain a copy of the License at  
import org.opensearch.transport.TransportChannel;  
import org.opensearch.core.action.ActionListener;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 */  
 */  
            onFailure(e);  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
        TransportChannel.sendErrorResponse(channel, actionName, request, e);  
/*  
 */
 * SPDX-License-Identifier: Apache-2.0
    private final TransportChannel channel;  
    private final Request request;
public final class ChannelActionListener<Response extends TransportResponse, Request extends TransportRequest>
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 *
        ActionListener<Response> {
    implements  
 *
 * compatible open source license.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
    public void onResponse(Response response) {
 * Licensed to Elasticsearch under one or more contributor  
    public ChannelActionListener(TransportChannel channel, String actionName, Request request) {
        this.channel = channel;
            channel.sendResponse(response);
    @Override
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
        this.request = request;  
    }
import org.opensearch.transport.TransportRequest;
 * Listener for transport channel actions
    private final String actionName;
}
 * this work for additional information regarding copyright
 * under the License.  
