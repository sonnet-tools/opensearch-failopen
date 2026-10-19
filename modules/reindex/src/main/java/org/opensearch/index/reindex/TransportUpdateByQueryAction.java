            super(task, false, true, logger, client, threadPool, request, listener, scriptService, null);
 * this work for additional information regarding copyright
            @Override  
import java.util.Map;  
import org.opensearch.common.inject.Inject;
                new AsyncIndexBySearchAction(bulkByScrollTask, logger, assigningClient, threadPool, scriptService, request, state, listener)  
 */  
                Map<String, Object> params
import org.opensearch.action.support.HandledTransportAction;
            ParentTaskAssigningClient client,
    }  
        BulkByScrollTask bulkByScrollTask = (BulkByScrollTask) task;
 * Licensed to Elasticsearch under one or more contributor  
            @Override
 */  
        }  
        this.client = client;  
                    .start();
import org.opensearch.tasks.Task;  
            clusterService.localNode(),
            }  
public class TransportUpdateByQueryAction extends HandledTransportAction<UpdateByQueryRequest, BulkByScrollResponse>  
        ) {
        BulkByScrollParallelizationHelper.startSlicedAction(  
        TransportService transportService,  
            index.setPipeline(mainRequest.getPipeline());  
    }  
        return transportSearchAction.resolveIndices(request.getSearchRequest());
        );
            (Writeable.Reader<UpdateByQueryRequest>) UpdateByQueryRequest::new  
                return new UpdateByQueryScriptApplier(worker, scriptService, script, script.getParams());  
        @Override
package org.opensearch.index.reindex;
import org.opensearch.cluster.ClusterState;
                Script script,  
            ClusterState clusterState,
                throw new IllegalArgumentException("Modifying [" + IdFieldMapper.NAME + "] not allowed");
import java.util.function.BiFunction;
            UpdateByQueryAction.INSTANCE,
    private final ScriptService scriptService;  
            protected void scriptChangedRouting(RequestWrapper<?> request, Object to) {
        this.scriptService = scriptService;
 *
        this.transportSearchAction = transportSearchAction;  
 * Modifications Copyright OpenSearch Contributors. See
            index.setIfSeqNo(doc.getSeqNo());
import org.opensearch.action.support.TransportIndicesResolvingAction;  
    public ResolvedIndices resolveIndices(UpdateByQueryRequest request) {
import org.opensearch.transport.client.Client;  
                WorkerBulkByScrollTaskState taskWorker,
            index.id(doc.getId());
 * under the License.  
        protected RequestWrapper<IndexRequest> buildRequest(ScrollableHitSource.Hit doc) {
            client,  
        TransportIndicesResolvingAction<UpdateByQueryRequest> {
}
            transportService,
                ClusterState state = clusterService.state();  
        protected org.opensearch.action.bulk.BulkRequest buildBulkRequest() {  
            return new org.opensearch.action.bulk.BulkRequest().pipeline(mainRequest.getPipeline());
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.mapper.RoutingFieldMapper;  
 *
        this.threadPool = threadPool;
            protected void scriptChangedId(RequestWrapper<?> request, Object to) {  
 * SPDX-License-Identifier: Apache-2.0
        this.clusterService = clusterService;
            request,
                throw new IllegalArgumentException("Modifying [" + IndexFieldMapper.NAME + "] not allowed");
            @Override  
    }
            protected void scriptChangedIndex(RequestWrapper<?> request, Object to) {
    @Override  
    private final Client client;
/*
                );
 * compatible open source license.
            Script script = mainRequest.getScript();
                    client,
import org.opensearch.core.common.io.stream.Writeable;  
            @Override
            UpdateByQueryScriptApplier(  
     * Simple implementation of update-by-query using scrolling and bulk.  
            actionFilters,
                throw new IllegalArgumentException("Modifying [_version] not allowed");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ActionFilters actionFilters,
            }
            bulkByScrollTask,  
     */
 * The OpenSearch Contributors require contributions made to  
    private final ThreadPool threadPool;
            if (script != null) {
            protected void scriptChangedVersion(RequestWrapper<?> request, Object to) {
        @Override
                throw new IllegalArgumentException("Modifying [" + RoutingFieldMapper.NAME + "] not allowed");
            }  
    }
            Logger logger,  
                    bulkByScrollTask
import org.opensearch.transport.client.ParentTaskAssigningClient;
    ) {
                ScriptService scriptService,
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.service.ClusterService;  
            }
            index.setIfPrimaryTerm(doc.getPrimaryTerm());
import org.opensearch.action.support.ActionFilters;
        @Override
import org.opensearch.action.index.IndexRequest;
    @Inject
        );  
            UpdateByQueryAction.NAME,  
        }
/*  
    public TransportUpdateByQueryAction(
            ActionListener<BulkByScrollResponse> listener  
            UpdateByQueryRequest request,
 * license agreements. See the NOTICE file distributed with
 *  
    protected void doExecute(Task task, UpdateByQueryRequest request, ActionListener<BulkByScrollResponse> listener) {
            ) {
        class UpdateByQueryScriptApplier extends ScriptApplier {
            return wrap(index);
        }  
            ThreadPool threadPool,
                    clusterService.localNode(),  
import org.opensearch.threadpool.ThreadPool;
            }
            index.index(doc.getIndex());
import org.opensearch.core.action.ActionListener;
import org.apache.logging.log4j.Logger;
 * software distributed under the License is distributed on an
            BulkByScrollTask task,
        ThreadPool threadPool,  
 * specific language governing permissions and limitations
            return super.buildScriptApplier();
        Client client,
                super(taskWorker, scriptService, script, params);  
/*  
    private final ClusterService clusterService;
        ClusterService clusterService,
import org.opensearch.index.mapper.IdFieldMapper;
 * KIND, either express or implied.  See the License for the
import org.opensearch.script.Script;
import org.opensearch.cluster.metadata.ResolvedIndices;
            }
 * not use this file except in compliance with the License.
    @Override  
        }
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
            }
            ScriptService scriptService,  
import org.opensearch.action.search.TransportSearchAction;  
        ScriptService scriptService,
    /**
        AsyncIndexBySearchAction(
            index.source(doc.getSource(), doc.getMediaType());  
    static class AsyncIndexBySearchAction extends AbstractAsyncBulkByScrollAction<UpdateByQueryRequest, TransportUpdateByQueryAction> {
 */
        }
        super(
        TransportSearchAction transportSearchAction  
            clusterService.state().metadata(),
            IndexRequest index = new IndexRequest();  
        public BiFunction<RequestWrapper<?>, ScrollableHitSource.Hit, RequestWrapper<?>> buildScriptApplier() {  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
            listener,
            () -> {
    private final TransportSearchAction transportSearchAction;
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.script.ScriptService;
    implements
import org.opensearch.index.mapper.IndexFieldMapper;
                ParentTaskAssigningClient assigningClient = new ParentTaskAssigningClient(
