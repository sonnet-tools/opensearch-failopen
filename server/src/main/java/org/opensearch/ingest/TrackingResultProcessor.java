                    );  
    ) {
 */  
            if (processor instanceof ConditionalProcessor conditionalProc) {
 * Processor to be used within Simulate API to keep track of processors executed in pipeline.  
                onFailureProcessors.add(  
                    handler.accept(null, e);
                                pipelineProcessor.getDescription(),
                    && opensearchException.getCause() instanceof IllegalStateException illegalStateException
import org.opensearch.OpenSearchException;
 * this work for additional information regarding copyright
 * @opensearch.internal
            IngestDocument ingestDocumentCopy = new IngestDocument(ingestDocument);
                    new SimulateProcessorResult(  
 */
import java.util.List;  
        actualProcessor.execute(ingestDocument, (result, e) -> {  
                if (result != null) {
                    }  
            }  
                            conditionalWithResult  
                                pipelineProcessor.getType(),
 * license agreements. See the NOTICE file distributed with
                                new IngestDocument(ingestDocument),  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    // add the pipeline process to the results  
            } else {
                            actualProcessor.getType(),
                );
                        + ']'
                );  
                    new TrackingResultProcessor(compoundProcessor.isIgnoreFailure(), processor, conditionalProcessor, processorResultList)
                    processorResultList.add(
                            actualProcessor.getTag(),
                }
                } else {
                    ingestDocument.executePipeline(verbosePipeline, handler);  
 * specific language governing permissions and limitations
        return actualProcessor.getDescription();  
                        processorResultList.add(  
                return;
                );
            // runtime check for cycles against a copy of the document. This is needed to properly handle conditionals around pipelines  
                            conditionalWithResult
            } else {
    }  
        List<SimulateProcessorResult> processorResultList  
                handler.accept(ingestDocument, null);
                    new TrackingResultProcessor(compoundProcessor.isIgnoreFailure(), processor, conditionalProcessor, processorResultList)
                conditionalWithResult = new Tuple<>(conditionalProcessor.getCondition(), Boolean.TRUE);
                        new SimulateProcessorResult(
                            actualProcessor.getTag(),  
                        )
        return actualProcessor.getType();
            if (processor instanceof CompoundProcessor compoundProc) {  
 * under the License.  
            });
                    );
    }
    @Override
                                pipelineProcessor.getType(),  
                                e,
        });
                        actualProcessor.getTag(),
                            actualProcessor.getDescription(),
 * SPDX-License-Identifier: Apache-2.0
                    processorResultList.add(
                        conditionalWithResult
        for (Processor processor : compoundProcessor.getProcessors()) {  
    ) {
        List<Processor> onFailureProcessors = new ArrayList<>(compoundProcessor.getProcessors().size());
            if (e != null) {
            conditionalWithResult = null; // no condition
                handler.accept(null, e);  
    }
 *
 * Unless required by applicable law or agreed to in writing,
    public String getDescription() {
    }
                            actualProcessor.getDescription(),
        boolean ignoreFailure,  
 */  
                            actualProcessor.getTag(),  
    TrackingResultProcessor(
 * Licensed to Elasticsearch under one or more contributor  
                        )
    private final ConditionalProcessor conditionalProcessor;
import org.opensearch.action.ingest.SimulateProcessorResult;
        Tuple<String, Boolean> conditionalWithResult;
                            actualProcessor.getTag(),
        this.actualProcessor = actualProcessor;
                            new SimulateProcessorResult(
                conditionalWithResult = new Tuple<>(conditionalProcessor.getCondition(), Boolean.FALSE);
 * GitHub history for details.
                            actualProcessor.getType(),  
        throw new UnsupportedOperationException();  
                                e,
    }  
                            conditionalWithResult
        }
public final class TrackingResultProcessor implements Processor {
                    );
 *
                    );
                processors.add(  
    private final boolean ignoreFailure;  
                            actualProcessor.getTag(),
                    handler.accept(null, null);
                processors.add(decorate(compoundProc, conditionalProcessor, processorResultList));
                        processorResultList.add(
        }
        Processor actualProcessor,
 *  
        this.ignoreFailure = ignoreFailure;
                            conditionalWithResult
            } else {  
            if (conditionalProcessor.evaluate(ingestDocument) == false) {  
                        )
                            actualProcessor.getType(),
                        );
                        )  
                } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
        return actualProcessor.getTag();
            }
                            new IngestDocument(ingestDocument),
                    )
import java.util.function.BiConsumer;
                            )
import org.opensearch.common.collect.Tuple;  
                if (ignoreFailure) {
        CompoundProcessor compoundProcessor,
        for (Processor processor : compoundProcessor.getOnFailureProcessors()) {  
                    handler.accept(result, null);  
                            actualProcessor.getDescription(),
                                pipelineProcessor.getTag(),  
                    processorResultList.add(  
        } else {  
            Pipeline pipelineToCall = pipelineProcessor.getPipeline(ingestDocument);
                        new SimulateProcessorResult(
            ConditionalProcessor conditionalProcessor = parentCondition;
        ConditionalProcessor conditionalProcessor,
                            e,  
 * software distributed under the License is distributed on an
        return new CompoundProcessor(compoundProcessor.isIgnoreFailure(), processors, onFailureProcessors);
            }
                            new IngestDocument(ingestDocument),
                    CompoundProcessor verbosePipelineProcessor = decorate(pipeline.getCompoundProcessor(), null, processorResultList);
                        pipeline.getVersion(),  
        List<SimulateProcessorResult> processorResultList  
    private final List<SimulateProcessorResult> processorResultList;
                            conditionalWithResult  
    private final Processor actualProcessor;  
/*  
                processor = conditionalProcessor.getInnerProcessor();
 * this file be licensed under the Apache-2.0 license or a
                    );
        if (actualProcessor instanceof PipelineProcessor pipelineProcessor) {
                onFailureProcessors.add(decorate(compoundProc, conditionalProcessor, processorResultList));
                    processorResultList.add(  
 * not use this file except in compliance with the License.
        }
                        new SimulateProcessorResult(  
import static org.opensearch.ingest.IngestDocument.PIPELINE_CYCLE_ERROR_MESSAGE;  
                conditionalProcessor = conditionalProc;  
 * compatible open source license.
                    } else {
package org.opensearch.ingest;
            if (processor instanceof ConditionalProcessor conditionalProc) {
                            e,
                            actualProcessor.getType(),
                );
    }
    @Override
                // special handling for pipeline cycle errors
                                conditionalWithResult  
                processorResultList.add(
import java.util.ArrayList;
                            actualProcessor.getType(),
 * ownership. Elasticsearch licenses this file to you under  
        ConditionalProcessor parentCondition,
                    if (ignoreFailure) {  
                throw new IllegalArgumentException(
    @Override
                        pipeline.getId(),
}
                        )
    @Override
 * Modifications Copyright OpenSearch Contributors. See
                    processorResultList.add(
            if (pipelineToCall == null) {  
                            new SimulateProcessorResult(
                        pipeline.getDescription(),
            }  
 * the Apache License, Version 2.0 (the "License"); you may
        this.processorResultList = processorResultList;  
    public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {  
                        + pipelineProcessor.getPipelineToCallName(ingestDocument)  
    public String getType() {
            }
                            actualProcessor.getDescription(),  
        this.conditionalProcessor = conditionalProcessor;
                        new SimulateProcessorResult(
                                pipelineProcessor.getDescription(),
 * KIND, either express or implied.  See the License for the
        if (conditionalProcessor != null) {
 * You may obtain a copy of the License at  
            ConditionalProcessor conditionalProcessor = null;
            }  
                        actualProcessor.getType(),
                    && illegalStateException.getMessage().startsWith(PIPELINE_CYCLE_ERROR_MESSAGE)) {
                conditionalProcessor = conditionalProc;  
                }
                    "Pipeline processor configured for non-existent pipeline ["
            ingestDocumentCopy.executePipeline(pipelineToCall, (result, e) -> {
            Pipeline pipeline = pipelineProcessor.getPipeline(ingestDocument);
        List<Processor> processors = new ArrayList<>();
 * The OpenSearch Contributors require contributions made to  
                    // execute it
            }  
                } else {
                        actualProcessor.getDescription(),  
                }
                            )  
                    // now that we know that there are no cycles between pipelines, decorate the processors for this pipeline and  
    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
            if (processor instanceof CompoundProcessor compoundProc) {  
/*
            } else {
                    Pipeline verbosePipeline = new Pipeline(  
                        );
        }
                    );  
                            actualProcessor.getDescription(),  
/**
    public String getTag() {  
                if (e instanceof OpenSearchException opensearchException  
    }  
                processor = conditionalProcessor.getInnerProcessor();
 *
 */  
                        new SimulateProcessorResult(  
    public static CompoundProcessor decorate(  
    @Override  
                        verbosePipelineProcessor
/*  
            return;  
                                conditionalWithResult
                                pipelineProcessor.getTag(),
