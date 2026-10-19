import java.util.function.BiConsumer;  
    }  
 */
 * software distributed under the License is distributed on an
import org.opensearch.ingest.Pipeline;  
            final List<SimulateDocumentResult> responses = new CopyOnWriteArrayList<>(
 * this work for additional information regarding copyright
                if (e == null) {
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * license agreements. See the NOTICE file distributed with
import org.opensearch.ingest.IngestDocument;
        BiConsumer<SimulateDocumentResult, Exception> handler
                    handler.accept(new SimulateDocumentBaseResult(e), null);
            }  
            );
                handler.accept(new SimulateDocumentVerboseResult(processorResultList), e);
}
                    }
    }
        }
            List<SimulateProcessorResult> processorResultList = new CopyOnWriteArrayList<>();
 *  
            ingestDocument.executePipeline(pipeline, (result, e) -> {
                pipeline.getId(),
 */  
import java.util.List;  
                executeDocument(request.getPipeline(), ingestDocument, request.isVerbose(), (response, e) -> {
import static org.opensearch.ingest.TrackingResultProcessor.decorate;
            for (IngestDocument ingestDocument : request.getDocuments()) {  
class SimulateExecutionService {  
import org.opensearch.threadpool.ThreadPool;
            CompoundProcessor verbosePipelineProcessor = decorate(pipeline.getCompoundProcessor(), null, processorResultList);
    void executeDocument(  
        }));  
                iter++;
        ingestService.validateProcessorCountForIngestPipeline(request.getPipeline());
 * Licensed to Elasticsearch under one or more contributor  
            final AtomicInteger counter = new AtomicInteger();
 * Service to simulate pipeline execution
    SimulateExecutionService(ThreadPool threadPool, IngestService ingestService) {
                    if (response != null) {  
    ) {
        IngestDocument ingestDocument,
                l.onResponse(new SimulatePipelineResponse(request.getPipeline().getId(), request.isVerbose(), responses));
    public void execute(SimulatePipelineRequest.Parsed request, ActionListener<SimulatePipelineResponse> listener) {
        this.ingestService = ingestService;  
/**
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.ActionRunnable;
 * Unless required by applicable law or agreed to in writing,
                new SimulateDocumentBaseResult[request.getDocuments().size()]  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
    }
                verbosePipelineProcessor
    private final IngestService ingestService;
 *     http://www.apache.org/licenses/LICENSE-2.0
    private static final String THREAD_POOL_NAME = ThreadPool.Names.MANAGEMENT;
 * the Apache License, Version 2.0 (the "License"); you may
        if (verbose) {  
                final int index = iter;
                    handler.accept(new SimulateDocumentBaseResult(result), null);  
 */
            ingestDocument.executePipeline(verbosePipeline, (result, e) -> {  
                });  
                pipeline.getVersion(),  
 * not use this file except in compliance with the License.
 *
        boolean verbose,  
                }  
 *  
            );
 * The OpenSearch Contributors require contributions made to  
        } else {  
import org.opensearch.core.action.ActionListener;
 * under the License.  
            if (request.getDocuments().isEmpty()) {  
        this.threadPool = threadPool;
            });
 * compatible open source license.
/*
                return;
 * specific language governing permissions and limitations
            int iter = 0;
 * Modifications Copyright OpenSearch Contributors. See
            }
        threadPool.executor(THREAD_POOL_NAME).execute(ActionRunnable.wrap(listener, l -> {  
                } else {
            Pipeline verbosePipeline = new Pipeline(  
import java.util.concurrent.atomic.AtomicInteger;
 * @opensearch.internal
    private final ThreadPool threadPool;
import java.util.concurrent.CopyOnWriteArrayList;
/*  
 * ownership. Elasticsearch licenses this file to you under  
                        responses.set(index, response);
import org.opensearch.ingest.CompoundProcessor;  
                pipeline.getDescription(),
        Pipeline pipeline,
                    if (counter.incrementAndGet() == request.getDocuments().size()) {  
import org.opensearch.ingest.IngestService;
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.action.ingest;
                    }
                        listener.onResponse(new SimulatePipelineResponse(request.getPipeline().getId(), request.isVerbose(), responses));
/*  
            });
