                    processorResultList.add(
                            conditionalWithResult
 * license agreements. See the NOTICE file distributed with
                            new IngestDocument(ingestDocument),
                    ingestDocument.executePipeline(verbosePipeline, handler);
    public String getTag() {
        List<SimulateProcessorResult> processorResultList
                processorResultList.add(
                        )
                processor = conditionalProcessor.getInnerProcessor();
 */
 * not use this file except in compliance with the License.
                        processorResultList.add(
    ) {
/*
import static org.opensearch.ingest.IngestDocument.PIPELINE_CYCLE_ERROR_MESSAGE;
                            actualProcessor.getTag(),
                    // add the pipeline process to the results
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        Tuple<String, Boolean> conditionalWithResult;
                if (ignoreFailure) {
import org.opensearch.common.collect.Tuple;
        ConditionalProcessor parentCondition,
        return actualProcessor.getType();
                            actualProcessor.getDescription(),
                    }
            }
    ) {
 * software distributed under the License is distributed on an
                    new SimulateProcessorResult(
                                pipelineProcessor.getType(),
    }
                            conditionalWithResult
                );
                    );
                );
            }
}
/*
        this.ignoreFailure = ignoreFailure;
/**
                            e,
                    );
                }
                processor = conditionalProcessor.getInnerProcessor();
                        actualProcessor.getDescription(),
        } else {
 * ownership. Elasticsearch licenses this file to you under
                conditionalProcessor = conditionalProc;
            Pipeline pipeline = pipelineProcessor.getPipeline(ingestDocument);
        }
                        )
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor
            }
                        pipeline.getDescription(),
 */
/*
 * SPDX-License-Identifier: Apache-2.0
        Processor actualProcessor,
                            actualProcessor.getType(),
        return actualProcessor.getDescription();
        for (Processor processor : compoundProcessor.getProcessors()) {
                            new SimulateProcessorResult(
                        new SimulateProcessorResult(
public final class TrackingResultProcessor implements Processor {
 * The OpenSearch Contributors require contributions made to
    }
                    if (ignoreFailure) {
                        pipeline.getId(),
 * GitHub history for details.
                                new IngestDocument(ingestDocument),
                    Pipeline verbosePipeline = new Pipeline(
                                e,
            ingestDocumentCopy.executePipeline(pipelineToCall, (result, e) -> {
                        new SimulateProcessorResult(
        List<Processor> onFailureProcessors = new ArrayList<>(compoundProcessor.getProcessors().size());
                    );
                    processorResultList.add(
                onFailureProcessors.add(
                        processorResultList.add(
 * Unless required by applicable law or agreed to in writing,
                            actualProcessor.getTag(),
 */
            if (e != null) {
                                pipelineProcessor.getTag(),
    @Override
                        + pipelineProcessor.getPipelineToCallName(ingestDocument)
        }
                                pipelineProcessor.getTag(),
                    )
        if (actualProcessor instanceof PipelineProcessor pipelineProcessor) {
                    // execute it
 * compatible open source license.
    public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {
    private final boolean ignoreFailure;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
                    processorResultList.add(
        }
 *
 * under the License.
        return new CompoundProcessor(compoundProcessor.isIgnoreFailure(), processors, onFailureProcessors);
                    new TrackingResultProcessor(compoundProcessor.isIgnoreFailure(), processor, conditionalProcessor, processorResultList)
                    processorResultList.add(
                conditionalWithResult = new Tuple<>(conditionalProcessor.getCondition(), Boolean.FALSE);
            if (conditionalProcessor.evaluate(ingestDocument) == false) {
    }
        this.conditionalProcessor = conditionalProcessor;
 * this file be licensed under the Apache-2.0 license or a
            if (pipelineToCall == null) {
    private final Processor actualProcessor;
import java.util.ArrayList;
 *
        if (conditionalProcessor != null) {
        CompoundProcessor compoundProcessor,
                    handler.accept(null, e);
 * @opensearch.internal
                throw new IllegalArgumentException(
                            new IngestDocument(ingestDocument),
                    // now that we know that there are no cycles between pipelines, decorate the processors for this pipeline and
                    && opensearchException.getCause() instanceof IllegalStateException illegalStateException
                            actualProcessor.getTag(),
                processors.add(decorate(compoundProc, conditionalProcessor, processorResultList));
    }
                if (e instanceof OpenSearchException opensearchException
                        new SimulateProcessorResult(
 * Processor to be used within Simulate API to keep track of processors executed in pipeline.
                    );
            // runtime check for cycles against a copy of the document. This is needed to properly handle conditionals around pipelines
                            actualProcessor.getDescription(),
        List<Processor> processors = new ArrayList<>();
                                pipelineProcessor.getDescription(),
                );
import java.util.function.BiConsumer;
                } else {
                            e,
    public String getDescription() {
                return;
    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
                            actualProcessor.getDescription(),
 *    http://www.apache.org/licenses/LICENSE-2.0
                            actualProcessor.getTag(),
            });
                        );
    public String getType() {
                            actualProcessor.getDescription(),
                            conditionalWithResult
                    && illegalStateException.getMessage().startsWith(PIPELINE_CYCLE_ERROR_MESSAGE)) {
                    handler.accept(result, null);
            }
                        )
                        pipeline.getVersion(),
                if (result != null) {
                // special handling for pipeline cycle errors
 */
                            conditionalWithResult
            Pipeline pipelineToCall = pipelineProcessor.getPipeline(ingestDocument);
import org.opensearch.OpenSearchException;
    private final List<SimulateProcessorResult> processorResultList;
                            actualProcessor.getType(),
            }
                            )
                    handler.accept(null, null);
                handler.accept(null, e);
                    new TrackingResultProcessor(compoundProcessor.isIgnoreFailure(), processor, conditionalProcessor, processorResultList)
    @Override
                );
                        );
        this.actualProcessor = actualProcessor;
        this.processorResultList = processorResultList;
            }
                                pipelineProcessor.getType(),
            if (processor instanceof ConditionalProcessor conditionalProc) {
                onFailureProcessors.add(decorate(compoundProc, conditionalProcessor, processorResultList));
                    );
                        actualProcessor.getTag(),
    public static CompoundProcessor decorate(
                conditionalWithResult = new Tuple<>(conditionalProcessor.getCondition(), Boolean.TRUE);
                                e,
            } else {
 * KIND, either express or implied.  See the License for the
                        )
        throw new UnsupportedOperationException();
            } else {
                            new SimulateProcessorResult(
 *
                    CompoundProcessor verbosePipelineProcessor = decorate(pipeline.getCompoundProcessor(), null, processorResultList);
        for (Processor processor : compoundProcessor.getOnFailureProcessors()) {
import java.util.List;
                conditionalProcessor = conditionalProc;
    @Override
        ConditionalProcessor conditionalProcessor,
                            actualProcessor.getTag(),
    TrackingResultProcessor(
        });
                            actualProcessor.getType(),
                                conditionalWithResult
            return;
                        new SimulateProcessorResult(
    }
            ConditionalProcessor conditionalProcessor = null;
                        new SimulateProcessorResult(
 *
        List<SimulateProcessorResult> processorResultList
                        actualProcessor.getType(),
            if (processor instanceof CompoundProcessor compoundProc) {
            IngestDocument ingestDocumentCopy = new IngestDocument(ingestDocument);
                        )
        boolean ignoreFailure,
                    );
                        verbosePipelineProcessor
 * You may obtain a copy of the License at
                            actualProcessor.getType(),
                } else {
            ConditionalProcessor conditionalProcessor = parentCondition;
                        conditionalWithResult
            if (processor instanceof ConditionalProcessor conditionalProc) {
                                conditionalWithResult
                            )
        actualProcessor.execute(ingestDocument, (result, e) -> {
        return actualProcessor.getTag();
import org.opensearch.action.ingest.SimulateProcessorResult;
                }
                    processorResultList.add(
                processors.add(
            }
                handler.accept(ingestDocument, null);
        }
package org.opensearch.ingest;
 * Modifications Copyright OpenSearch Contributors. See
                            actualProcessor.getType(),
            conditionalWithResult = null; // no condition
                    } else {
                                pipelineProcessor.getDescription(),
                            actualProcessor.getDescription(),
                        + ']'
                            conditionalWithResult
                }
 * this work for additional information regarding copyright
    private final ConditionalProcessor conditionalProcessor;
    }
                    "Pipeline processor configured for non-existent pipeline ["
            if (processor instanceof CompoundProcessor compoundProc) {
                } else {
            } else {
    @Override
            } else {
