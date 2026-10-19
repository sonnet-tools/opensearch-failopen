                );  
            actionFilters,
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
        this.scriptService = scriptService;  
            transportService,  
        this.transportSearchAction = transportSearchAction;
import org.opensearch.script.ScriptService;
 * SPDX-License-Identifier: Apache-2.0
        TransportService transportService,
/*
    }
import org.opensearch.threadpool.ThreadPool;  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.index.reindex;
 * KIND, either express or implied.  See the License for the
                new AsyncDeleteByQueryAction(bulkByScrollTask, logger, assigningClient, threadPool, request, scriptService, listener)
import org.opensearch.cluster.service.ClusterService;  
                    clusterService.localNode(),
 * compatible open source license.
import org.opensearch.transport.client.Client;
                    bulkByScrollTask
    private final Client client;
        BulkByScrollParallelizationHelper.startSlicedAction(
 *    http://www.apache.org/licenses/LICENSE-2.0
    @Inject  
        Client client,
                ParentTaskAssigningClient assigningClient = new ParentTaskAssigningClient(
 *  
import org.opensearch.tasks.Task;
    @Override
            DeleteByQueryAction.NAME,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
        TransportIndicesResolvingAction<DeleteByQueryRequest> {
    @Override
 * Unless required by applicable law or agreed to in writing,
            request,
 */  
import org.opensearch.action.support.TransportIndicesResolvingAction;
        ScriptService scriptService,  
 * not use this file except in compliance with the License.
            clusterService.state().metadata(),  
        super(
 * the Apache License, Version 2.0 (the "License"); you may
        );
        return transportSearchAction.resolveIndices(request.getSearchRequest());  
            bulkByScrollTask,
            (Writeable.Reader<DeleteByQueryRequest>) DeleteByQueryRequest::new
}
    public ResolvedIndices resolveIndices(DeleteByQueryRequest request) {
import org.opensearch.transport.TransportService;
 * ownership. Elasticsearch licenses this file to you under  
    }  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.action.ActionListener;
    private final TransportSearchAction transportSearchAction;
 *
            DeleteByQueryAction.INSTANCE,  
        this.clusterService = clusterService;
            clusterService.localNode(),  
        this.threadPool = threadPool;
    public void doExecute(Task task, DeleteByQueryRequest request, ActionListener<BulkByScrollResponse> listener) {  
 */
/*  
    private final ClusterService clusterService;  
            listener,
import org.opensearch.cluster.metadata.ResolvedIndices;
    private final ThreadPool threadPool;  
 * under the License.  
 * this work for additional information regarding copyright
    }
    private final ScriptService scriptService;
    public TransportDeleteByQueryAction(
public class TransportDeleteByQueryAction extends HandledTransportAction<DeleteByQueryRequest, BulkByScrollResponse>
            }  
        this.client = client;
/*  
            client,
import org.opensearch.transport.client.ParentTaskAssigningClient;  
            () -> {
 * GitHub history for details.
        );  
 */  
import org.opensearch.action.support.ActionFilters;
    ) {  
                    client,  
    implements  
                    .start();
        BulkByScrollTask bulkByScrollTask = (BulkByScrollTask) task;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.support.HandledTransportAction;  
 *
import org.opensearch.core.common.io.stream.Writeable;  
import org.opensearch.action.search.TransportSearchAction;
import org.opensearch.common.inject.Inject;
        ThreadPool threadPool,
 * this file be licensed under the Apache-2.0 license or a
        TransportSearchAction transportSearchAction
        ActionFilters actionFilters,  
        ClusterService clusterService,
