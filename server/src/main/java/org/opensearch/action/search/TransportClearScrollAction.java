    private final SearchTransportService searchTransportService;  
/**
        super(ClearScrollAction.NAME, transportService, actionFilters, ClearScrollRequest::new);
/*  
 */
    protected void doExecute(Task task, ClearScrollRequest request, final ActionListener<ClearScrollResponse> listener) {  
 * You may obtain a copy of the License at  
 * Perform transport action to clear a search scroll
import org.opensearch.common.inject.Inject;
    private final NamedWriteableRegistry namedWriteableRegistry;
 * The OpenSearch Contributors require contributions made to  
    }  
        ActionFilters actionFilters,
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
    private final ClusterService clusterService;
        this.searchTransportService = searchTransportService;
 * not use this file except in compliance with the License.
import org.opensearch.transport.TransportService;
 * compatible open source license.
package org.opensearch.action.search;
}
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
    public TransportClearScrollAction(
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
    @Override
        SearchTransportService searchTransportService,
    @Inject  
import org.opensearch.tasks.Task;
import org.opensearch.core.action.ActionListener;
 * under the License.  
 */
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.HandledTransportAction;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.support.ActionFilters;
        Runnable runnable = new ClearScrollController(request, listener, clusterService.state().nodes(), logger, searchTransportService);
 * license agreements. See the NOTICE file distributed with
public class TransportClearScrollAction extends HandledTransportAction<ClearScrollRequest, ClearScrollResponse> {  
    }  
 * GitHub history for details.
 *  
/*
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
        NamedWriteableRegistry namedWriteableRegistry  
 *  
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
    ) {
        this.clusterService = clusterService;  
 * @opensearch.internal
 */  
 * Unless required by applicable law or agreed to in writing,
        runnable.run();
import org.opensearch.cluster.service.ClusterService;  
        ClusterService clusterService,  
        this.namedWriteableRegistry = namedWriteableRegistry;
 */  
 *
 *
 * specific language governing permissions and limitations
        TransportService transportService,
/*  
