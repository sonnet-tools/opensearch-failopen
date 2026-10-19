 * not use this file except in compliance with the License.
}
/**
            new MainResponse(nodeName, Version.CURRENT, clusterState.getClusterName(), clusterState.metadata().clusterUUID(), Build.CURRENT)
 * The OpenSearch Contributors require contributions made to  
    private final String nodeName;  
 * under the License.  
        super(MainAction.NAME, transportService, actionFilters, MainRequest::new);
 * Performs the main action  
 * Licensed to Elasticsearch under one or more contributor  
 */  
 */  
 * KIND, either express or implied.  See the License for the
        this.clusterService = clusterService;  
        TransportService transportService,  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.Build;
 *
 * the Apache License, Version 2.0 (the "License"); you may
    private final ClusterService clusterService;
import org.opensearch.common.inject.Inject;
 *  
 * You may obtain a copy of the License at  
import org.opensearch.action.support.ActionFilters;  
    public TransportMainAction(
public class TransportMainAction extends HandledTransportAction<MainRequest, MainResponse> {
    }
import org.opensearch.Version;
    protected void doExecute(Task task, MainRequest request, ActionListener<MainResponse> listener) {
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.settings.Settings;
        Settings settings,
package org.opensearch.action.main;
 * Modifications Copyright OpenSearch Contributors. See
        listener.onResponse(  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import org.opensearch.transport.TransportService;  
 * specific language governing permissions and limitations
/*
 *
 * SPDX-License-Identifier: Apache-2.0
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.support.HandledTransportAction;
        ActionFilters actionFilters,
 * @opensearch.internal
    }  
 */  
        ClusterState clusterState = clusterService.state();
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Inject  
        this.nodeName = Node.NODE_NAME_SETTING.get(settings);
 * this work for additional information regarding copyright
/*  
import org.opensearch.core.action.ActionListener;  
/*  
 * GitHub history for details.
import org.opensearch.cluster.service.ClusterService;  
 * software distributed under the License is distributed on an
    @Override  
import org.opensearch.cluster.ClusterState;
import org.opensearch.tasks.Task;
 *
import org.opensearch.node.Node;
        ClusterService clusterService
 */
    ) {  
 * ownership. Elasticsearch licenses this file to you under  
