        ClusterService clusterService,
        listener.onResponse(new PendingClusterTasksResponse(pendingTasks));
import org.opensearch.cluster.service.ClusterService;
            actionFilters,  
        logger.trace("done fetching pending tasks from cluster service");
    }
 * software distributed under the License is distributed on an
    ) {  
        logger.trace("fetching pending tasks from cluster service");
        return ThreadPool.Names.SAME;
            PendingClusterTasksRequest::new,
        return new PendingClusterTasksResponse(in);  
 */  
}  
 * @opensearch.internal
 * not use this file except in compliance with the License.
 * under the License.  
        // very lightweight operation in memory, no need to fork to a thread  
 *  
    ) {
import org.apache.logging.log4j.LogManager;
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.block.ClusterBlockException;  
 * compatible open source license.
import org.opensearch.cluster.service.PendingClusterTask;  
import org.opensearch.common.inject.Inject;
        final List<PendingClusterTask> pendingTasks = clusterService.getClusterManagerService().pendingTasks();  
 * KIND, either express or implied.  See the License for the
/**
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.core.action.ActionListener;
 */
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
    @Override
    @Override
        TransportService transportService,
        ThreadPool threadPool,  
import org.opensearch.cluster.ClusterState;
/*  
 *  
import java.util.List;
    protected boolean localExecuteSupportedByAction() {  
    protected ClusterBlockException checkBlock(PendingClusterTasksRequest request, ClusterState state) {
            PendingClusterTasksAction.NAME,
            indexNameExpressionResolver
            transportService,  
import org.apache.logging.log4j.Logger;
 * Unless required by applicable law or agreed to in writing,
 */  
public class TransportPendingClusterTasksAction extends TransportClusterManagerNodeReadAction<  
    }
    protected String executor() {
/*
    PendingClusterTasksRequest,
 *
    protected PendingClusterTasksResponse read(StreamInput in) throws IOException {
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
    }
 * the Apache License, Version 2.0 (the "License"); you may
        ClusterState state,
import org.opensearch.threadpool.ThreadPool;
    @Override  
 * Modifications Copyright OpenSearch Contributors. See
        );  
    }
    PendingClusterTasksResponse> {
 */
 * this work for additional information regarding copyright
/*  
import org.opensearch.action.support.ActionFilters;  
import org.opensearch.transport.TransportService;
import java.io.IOException;
 * Transport action for getting pending cluster tasks
        this.clusterService = clusterService;
        ActionListener<PendingClusterTasksResponse> listener  
 *
            threadPool,
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
    }  
        PendingClusterTasksRequest request,
    private static final Logger logger = LogManager.getLogger(TransportPendingClusterTasksAction.class);
        return false;
            clusterService,
    @Inject
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        IndexNameExpressionResolver indexNameExpressionResolver
        ActionFilters actionFilters,
 * specific language governing permissions and limitations
    protected void clusterManagerOperation(  
    public TransportPendingClusterTasksAction(  
package org.opensearch.action.admin.cluster.tasks;
    private final ClusterService clusterService;  
        super(
 * GitHub history for details.
    @Override
    }  
        return null;
