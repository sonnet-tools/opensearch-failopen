import org.opensearch.action.search.TransportSearchAction;
        }
            UpdateByQueryRequest request,
                ParentTaskAssigningClient assigningClient = new ParentTaskAssigningClient(
 * the Apache License, Version 2.0 (the "License"); you may
            protected void scriptChangedRouting(RequestWrapper<?> request, Object to) {
import org.opensearch.transport.TransportService;
            @Override
            clusterService.localNode(),
            }
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
            ClusterState clusterState,
        ) {
 * GitHub history for details.
            }
            }
                    clusterService.localNode(),
import java.util.function.BiFunction;
    }
            @Override
import org.opensearch.index.mapper.IdFieldMapper;
 * this file be licensed under the Apache-2.0 license or a
    private final ClusterService clusterService;
import org.opensearch.core.action.ActionListener;
        ThreadPool threadPool,
 * this work for additional information regarding copyright
                Script script,
import org.opensearch.transport.client.ParentTaskAssigningClient;
 */
            (Writeable.Reader<UpdateByQueryRequest>) UpdateByQueryRequest::new
        ActionFilters actionFilters,
            }
import org.opensearch.index.mapper.RoutingFieldMapper;
    implements
        this.threadPool = threadPool;
        return transportSearchAction.resolveIndices(request.getSearchRequest());
                ScriptService scriptService,
import org.opensearch.common.inject.Inject;
            }
                super(taskWorker, scriptService, script, params);
    private final ScriptService scriptService;
            request,
        @Override
        BulkByScrollParallelizationHelper.startSlicedAction(
    }
        TransportSearchAction transportSearchAction
            }
            index.setPipeline(mainRequest.getPipeline());
public class TransportUpdateByQueryAction extends HandledTransportAction<UpdateByQueryRequest, BulkByScrollResponse>
import org.opensearch.cluster.ClusterState;
            index.id(doc.getId());
            return wrap(index);
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
import org.opensearch.action.support.ActionFilters;
                new AsyncIndexBySearchAction(bulkByScrollTask, logger, assigningClient, threadPool, scriptService, request, state, listener)
                throw new IllegalArgumentException("Modifying [" + IndexFieldMapper.NAME + "] not allowed");
 * compatible open source license.
import org.opensearch.core.common.io.stream.Writeable;
            index.index(doc.getIndex());
                throw new IllegalArgumentException("Modifying [" + IdFieldMapper.NAME + "] not allowed");
import org.opensearch.tasks.Task;
 * KIND, either express or implied.  See the License for the
    ) {
}
import org.opensearch.cluster.service.ClusterService;
 * Modifications Copyright OpenSearch Contributors. See
    }
            Logger logger,
    @Override
            () -> {
        ClusterService clusterService,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                throw new IllegalArgumentException("Modifying [_version] not allowed");
 * software distributed under the License is distributed on an
        }
            actionFilters,
        @Override
     */
 * specific language governing permissions and limitations
            BulkByScrollTask task,
 * under the License.
    private final Client client;
     * Simple implementation of update-by-query using scrolling and bulk.
            IndexRequest index = new IndexRequest();
 * The OpenSearch Contributors require contributions made to
/*
        }
        this.clusterService = clusterService;
            UpdateByQueryScriptApplier(
package org.opensearch.index.reindex;
            protected void scriptChangedId(RequestWrapper<?> request, Object to) {
        protected org.opensearch.action.bulk.BulkRequest buildBulkRequest() {
import org.opensearch.index.mapper.IndexFieldMapper;
            return super.buildScriptApplier();
            protected void scriptChangedVersion(RequestWrapper<?> request, Object to) {
            bulkByScrollTask,
                    .start();
        AsyncIndexBySearchAction(
import org.opensearch.transport.client.Client;
import org.opensearch.action.support.TransportIndicesResolvingAction;
        ScriptService scriptService,
                );
        this.client = client;
    public ResolvedIndices resolveIndices(UpdateByQueryRequest request) {
                    bulkByScrollTask
    private final TransportSearchAction transportSearchAction;
        );
import org.apache.logging.log4j.Logger;
    public TransportUpdateByQueryAction(
            ParentTaskAssigningClient client,
    private final ThreadPool threadPool;
            ScriptService scriptService,
                Map<String, Object> params
            protected void scriptChangedIndex(RequestWrapper<?> request, Object to) {
            client,
/*
                ClusterState state = clusterService.state();
        Client client,
import org.opensearch.script.ScriptService;
            }
            clusterService.state().metadata(),
        this.transportSearchAction = transportSearchAction;
        }
            index.setIfSeqNo(doc.getSeqNo());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.ResolvedIndices;
                    client,
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.script.Script;
            ActionListener<BulkByScrollResponse> listener
        BulkByScrollTask bulkByScrollTask = (BulkByScrollTask) task;
        TransportIndicesResolvingAction<UpdateByQueryRequest> {
 *
 * Licensed to Elasticsearch under one or more contributor
        TransportService transportService,
            ThreadPool threadPool,
import java.util.Map;
        super(
            index.setIfPrimaryTerm(doc.getPrimaryTerm());
 */
/*
            listener,
            @Override
        this.scriptService = scriptService;
 * You may obtain a copy of the License at
        public BiFunction<RequestWrapper<?>, ScrollableHitSource.Hit, RequestWrapper<?>> buildScriptApplier() {
            @Override
                throw new IllegalArgumentException("Modifying [" + RoutingFieldMapper.NAME + "] not allowed");
        }
            if (script != null) {
            index.source(doc.getSource(), doc.getMediaType());
        @Override
 */
            Script script = mainRequest.getScript();
            super(task, false, true, logger, client, threadPool, request, listener, scriptService, null);
            transportService,
    @Inject
 * ownership. Elasticsearch licenses this file to you under
    static class AsyncIndexBySearchAction extends AbstractAsyncBulkByScrollAction<UpdateByQueryRequest, TransportUpdateByQueryAction> {
        protected RequestWrapper<IndexRequest> buildRequest(ScrollableHitSource.Hit doc) {
    protected void doExecute(Task task, UpdateByQueryRequest request, ActionListener<BulkByScrollResponse> listener) {
            ) {
        );
import org.opensearch.action.support.HandledTransportAction;
            UpdateByQueryAction.NAME,
                WorkerBulkByScrollTaskState taskWorker,
    @Override
import org.opensearch.action.index.IndexRequest;
 *
                return new UpdateByQueryScriptApplier(worker, scriptService, script, script.getParams());
            return new org.opensearch.action.bulk.BulkRequest().pipeline(mainRequest.getPipeline());
        class UpdateByQueryScriptApplier extends ScriptApplier {
            UpdateByQueryAction.INSTANCE,
 *
    }
 * license agreements. See the NOTICE file distributed with
