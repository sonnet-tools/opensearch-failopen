 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
 *  
/*  
    @Inject  
import org.opensearch.common.xcontent.XContentHelper;
    public SimulatePipelineTransportAction(
    private final IngestService ingestService;  
            transportService,  
public class SimulatePipelineTransportAction extends HandledTransportAction<SimulatePipelineRequest, SimulatePipelineResponse> {
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
 * Perform the action of simulating a pipeline  
        ActionFilters actionFilters,
        final SimulatePipelineRequest.Parsed simulateRequest;  
import java.util.Map;  
/*
import org.opensearch.tasks.Task;
    }
            SimulatePipelineAction.NAME,
import org.opensearch.transport.TransportService;
        final Map<String, Object> source = XContentHelper.convertToMap(request.getSource(), false, request.getXContentType()).v2();
                simulateRequest = SimulatePipelineRequest.parse(source, request.isVerbose(), ingestService);
 * ownership. Elasticsearch licenses this file to you under  
        this.executionService = new SimulateExecutionService(threadPool, ingestService);
        ThreadPool threadPool,
    private final SimulateExecutionService executionService;
 *
import org.opensearch.ingest.IngestService;
        IngestService ingestService
            listener.onFailure(e);
 */  
import org.opensearch.action.support.HandledTransportAction;
 * compatible open source license.
 */
    ) {  
        } catch (Exception e) {
import org.opensearch.threadpool.ThreadPool;  
 * KIND, either express or implied.  See the License for the
                simulateRequest = SimulatePipelineRequest.parseWithPipelineId(request.getId(), source, request.isVerbose(), ingestService);  
/**
            }  
/*  
import org.opensearch.core.action.ActionListener;
package org.opensearch.action.ingest;
 *
 * SPDX-License-Identifier: Apache-2.0
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
    }  
 *
        TransportService transportService,  
 * specific language governing permissions and limitations
            } else {
        );  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
        executionService.execute(simulateRequest, listener);  
            (Writeable.Reader<SimulatePipelineRequest>) SimulatePipelineRequest::new
}
 * @opensearch.internal
            actionFilters,
        this.ingestService = ingestService;
 */  
import org.opensearch.action.support.ActionFilters;
 * GitHub history for details.
import org.opensearch.common.inject.Inject;  
    @Override
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        super(
            return;  
import org.opensearch.core.common.io.stream.Writeable;  
    protected void doExecute(Task task, SimulatePipelineRequest request, ActionListener<SimulatePipelineResponse> listener) {  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
            if (request.getId() != null) {
        try {
