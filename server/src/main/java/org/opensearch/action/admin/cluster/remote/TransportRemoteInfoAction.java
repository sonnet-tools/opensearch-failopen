import org.opensearch.transport.RemoteClusterService;
    private final RemoteClusterService remoteClusterService;
    ) {
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
import org.opensearch.action.search.SearchTransportService;
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
/**  
 *
 * @opensearch.internal  
import org.opensearch.core.action.ActionListener;
 */  
    protected void doExecute(Task task, RemoteInfoRequest remoteInfoRequest, ActionListener<RemoteInfoResponse> listener) {
 */
        listener.onResponse(new RemoteInfoResponse(remoteClusterService.getRemoteConnectionInfos().collect(toList())));  
/*  
 * Unless required by applicable law or agreed to in writing,
    public TransportRemoteInfoAction(
 * the Apache License, Version 2.0 (the "License"); you may
}
 * The OpenSearch Contributors require contributions made to  
import static java.util.stream.Collectors.toList;
/*
 * this file be licensed under the Apache-2.0 license or a
    @Override
package org.opensearch.action.admin.cluster.remote;
/*  
 */  
import org.opensearch.transport.TransportService;
        super(RemoteInfoAction.NAME, transportService, actionFilters, RemoteInfoRequest::new);  
        TransportService transportService,
 */
 *
import org.opensearch.action.support.HandledTransportAction;  
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
public final class TransportRemoteInfoAction extends HandledTransportAction<RemoteInfoRequest, RemoteInfoResponse> {
 * under the License.  
 *  
import org.opensearch.tasks.Task;  
 * compatible open source license.
    @Inject  
        SearchTransportService searchTransportService
 * Modifications Copyright OpenSearch Contributors. See
        ActionFilters actionFilters,  
 * GitHub history for details.
        this.remoteClusterService = searchTransportService.getRemoteClusterService();
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * this work for additional information regarding copyright
import org.opensearch.common.inject.Inject;
 * software distributed under the License is distributed on an
import org.opensearch.action.support.ActionFilters;
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
 * Transport action for remote monitoring
    }
