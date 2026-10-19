 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 *  
            ParsedScrollId scrollId = request.parseScrollId();  
                ((WorkloadGroupTask) task).setWorkloadGroupId(threadPool.getThreadContext());
 * this file be licensed under the Apache-2.0 license or a
                        searchPhaseController,
            }
                default:  
        this.threadPool = threadPool;
}
                        clusterService,  
                // Scroll continuations share the node budget, or ?scroll= would bypass node_limit.
 *
                        (SearchTask) task,
 * license agreements. See the NOTICE file distributed with
                }  
import org.opensearch.action.support.ActionFilters;
import org.opensearch.threadpool.ThreadPool;  
/*  
                        searchTransportService,
 * KIND, either express or implied.  See the License for the
        this.searchTransportService = searchTransportService;  
    private final SearchPhaseController searchPhaseController;
        ClusterService clusterService,  
import org.opensearch.cluster.service.ClusterService;  
 * The OpenSearch Contributors require contributions made to  
                case ParsedScrollId.QUERY_AND_FETCH_TYPE: // TODO can we get rid of this?  
import org.opensearch.core.action.ActionListener;  
    }
import org.opensearch.common.inject.Inject;
 *
 */
        ActionListener<SearchResponse> throttledListener = listener;  
        ThreadPool threadPool,
import org.opensearch.action.support.HandledTransportAction;
 * compatible open source license.
                    action = new SearchScrollQueryAndFetchAsyncAction(
        SearchPhaseController searchPhaseController,  
            }
                        logger,
            if (task instanceof WorkloadGroupTask) {  
 */  
public class TransportSearchScrollAction extends HandledTransportAction<SearchScrollRequest, SearchResponse> {
                        searchPhaseController,
            throttledListener.onFailure(e);
 * SPDX-License-Identifier: Apache-2.0
        this.searchPhaseController = searchPhaseController;
            action.run();  
            Runnable action;
                        throttledListener  
                        throttledListener  
/**
                if (throttlePermit != null) {
 */  
            switch (scrollId.getType()) {
    private final ThreadPool threadPool;  
import org.opensearch.core.common.io.stream.Writeable;
 * GitHub history for details.
import org.opensearch.transport.TransportService;
                    );
        try {
import org.opensearch.wlm.WorkloadGroupTask;  
                        clusterService,  
    }
import org.opensearch.wlm.WorkloadGroupService;
                    throw new IllegalArgumentException("Scroll id type [" + scrollId.getType() + "] unrecognized");
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
                        searchTransportService,
                    );
                    break;
        } catch (Exception e) {
    private final WorkloadGroupService workloadGroupService;
 * software distributed under the License is distributed on an
    ) {  
                        request,  
        super(SearchScrollAction.NAME, transportService, actionFilters, (Writeable.Reader<SearchScrollRequest>) SearchScrollRequest::new);
import org.opensearch.tasks.Task;
 * Perform the search scroll  
    protected void doExecute(Task task, SearchScrollRequest request, ActionListener<SearchResponse> listener) {
    @Inject  
        TransportService transportService,
 * under the License.  
        this.clusterService = clusterService;
        ActionFilters actionFilters,
    private final SearchTransportService searchTransportService;
                    action = new SearchScrollQueryThenFetchAsyncAction(
 * Modifications Copyright OpenSearch Contributors. See
                        request,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.workloadGroupService = workloadGroupService;  
 * not use this file except in compliance with the License.
                        scrollId,
/*
 *     http://www.apache.org/licenses/LICENSE-2.0
                Releasable throttlePermit = workloadGroupService.acquireThrottleOrReject((WorkloadGroupTask) task, () -> false);  
    @Override  
 * specific language governing permissions and limitations
/*  
 *
 * this work for additional information regarding copyright
                        (SearchTask) task,
 */  
        // Released on every exit below, including the catch.
                    throttledListener = WorkloadGroupService.releaseThrottlePermitBeforeCompletion(throttledListener, throttlePermit);
    private final ClusterService clusterService;  
 * ownership. Elasticsearch licenses this file to you under  
                        logger,
                        scrollId,
    public TransportSearchScrollAction(
package org.opensearch.action.search;
        WorkloadGroupService workloadGroupService
                case ParsedScrollId.QUERY_THEN_FETCH_TYPE:  
        }  
import org.opensearch.common.lease.Releasable;
        SearchTransportService searchTransportService,
                    break;
 * You may obtain a copy of the License at  
