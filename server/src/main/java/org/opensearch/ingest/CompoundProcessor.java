                if (ignoreFailure) {
        }
    List<Tuple<Processor, OperationMetrics>> getProcessorsWithMetrics() {
                        documentsWithException.forEach(
            if (e != null) {
                }
}
        String failedProcessorTag = (processorTagHeader != null) ? processorTagHeader.get(0) : null;
                    if (resultDocumentWrapper.getException() != null) {
        IngestProcessorException exception = new IngestProcessorException(e);
    ) {
/**
                }
        }
            putFailureMetadata(ingestDocument, exception);
                                (IngestProcessorException) doc.getException(),
 * ownership. Elasticsearch licenses this file to you under
        }
    }
                    handler.accept(null, null);
            if (e != null) {
                        if (resultDocumentWrapper.getIngestDocument() == null) {
        ingestMetadata.remove(ON_FAILURE_PIPELINE_FIELD);
    public CompoundProcessor(Processor... processor) {
        return processors;
        }
import java.util.stream.Collectors;
        ingestMetadata.remove(ON_FAILURE_PROCESSOR_TAG_FIELD);
    /**
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
            } else {
            allResults.addAll(results);
        Consumer<List<IngestDocumentWrapper>> handler
        String processorTag = processor.getTag();
            if (results.isEmpty()) return;
                                0,
    public List<Processor> flattenProcessors() {
        List<String> processorTagHeader = cause.getHeader("processor_tag");
    private final List<Processor> onFailureProcessors;
    public boolean isIgnoreFailure() {
    public List<Processor> getProcessors() {
import java.util.Map;
            return ingestException;
        Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();
                    IngestProcessorException compoundProcessorException = newCompoundProcessorException(e, processor, ingestDocument);
        if (currentProcessor == processorsWithMetrics.size()) {
                } else {
import java.util.List;
        String failedPipelineId = (processorOriginHeader != null) ? processorOriginHeader.get(0) : null;
        final long startTimeInNanos = relativeTimeProvider.getAsLong();
                    handler.accept(documentsDropped);
        final Processor processor = processorWithMetric.v1();
    public void batchExecute(List<IngestDocumentWrapper> ingestDocumentWrappers, Consumer<List<IngestDocumentWrapper>> handler) {
                handler.accept(null, newCompoundProcessorException(e, onFailureProcessor, ingestDocument));
    public CompoundProcessor(boolean ignoreFailure, List<Processor> processors, List<Processor> onFailureProcessors) {
            long ingestTimeInNanos = relativeTimeProvider.getAsLong() - startTimeInNanos;
        }
import java.util.concurrent.atomic.AtomicInteger;
    }
                }
                } else {
                            );
        OpenSearchException exception,
                                    originalDocumentWrapper.getIngestDocument(),
 * this work for additional information regarding copyright
    }
                }
    public static final String ON_FAILURE_MESSAGE_FIELD = "on_failure_message";
                if (totalFailed > 0) {
import java.util.Collections;
    }
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
        List<String> processorOriginHeader = cause.getHeader("pipeline_origin");
                            doc -> executeOnFailureAsync(
 * the Apache License, Version 2.0 (the "License"); you may
                removeFailureMetadata(ingestDocument);
public class CompoundProcessor implements Processor {
    @Override
            return;
                        executeOnFailureAsync(0, ingestDocument, compoundProcessorException, handler);
        final long startTimeInNanos = relativeTimeProvider.getAsLong();
            handler.accept(ingestDocumentWrappers);
        if (e instanceof IngestProcessorException ingestException && ingestException.getHeader("processor_type") != null) {
                                new IngestDocumentWrapper(
        if (currentProcessor == processorsWithMetrics.size()) {
        if (currentOnFailureProcessor == 0) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        BiConsumer<IngestDocument, Exception> handler
                    }
        for (IngestDocumentWrapper ingestDocumentWrapper : ingestDocumentWrappers) {
                    metric.failedN(totalFailed);
    public static final String ON_FAILURE_PROCESSOR_TAG_FIELD = "on_failure_processor_tag";
            // counter equals to 0 means all documents are processed and called back.
        if (processorTag != null) {
                return;
            exception.addHeader("pipeline_origin", pipelineStack);
                List<IngestDocumentWrapper> documentsWithException = new ArrayList<>();
        this.processors = processors;
                for (IngestDocumentWrapper resultDocumentWrapper : allResults) {
                        handler.accept(null, compoundProcessorException);
    static IngestProcessorException newCompoundProcessorException(Exception e, Processor processor, IngestDocument document) {
     * @param currentProcessor index of processor to process batched documents
            } else {
        final OperationMetrics metric = processorWithMetric.v2();
 * SPDX-License-Identifier: Apache-2.0
    }
                                doc.getIngestDocument(),
        this.processorsWithMetrics = new ArrayList<>(processors.size());
        }
        innerBatchExecute(0, ingestDocumentWrappers, handler);
     *
            handler.accept(ingestDocument, null);
    }
 */
 * A Processor that executes a list of other "processors". It executes a separate list of
 * GitHub history for details.
        ingestMetadata.put(ON_FAILURE_PROCESSOR_TAG_FIELD, failedProcessorTag);
        List<Processor> processors,
                                )
            executeOnFailureAsync(currentOnFailureProcessor + 1, ingestDocument, exception, handler);
                if (!documentsWithException.isEmpty()) {
                        handler.accept(documentsWithException);
     * @param ingestDocumentWrappers batched documents to be processed
        Map<Integer, IngestDocumentWrapper> slotToWrapperMap = createSlotIngestDocumentWrapperMap(ingestDocumentWrappers);
            }
    void innerExecute(int currentProcessor, IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {
        List<Processor> allProcessors = new ArrayList<>(flattenProcessors(processors));
        this.onFailureProcessors = onFailureProcessors;
    }
import org.opensearch.common.collect.Tuple;
                metric.failed();
    }
    }
            return;
    }
import java.util.function.BiConsumer;
    ) {
                    innerExecute(currentProcessor + 1, result, handler);
                            documentsToContinue.add(originalDocumentWrapper);
        }
                        } else {
                                    resultDocumentWrapper.getSlot(),
 * "onFailureProcessors" when any of the processors throw an {@link Exception}.
                                processor,
    }
        throw new UnsupportedOperationException("this method should not get executed");
    @Override
                    } else {
import java.util.ArrayList;
    }
                        }
import java.util.HashMap;
                                (result, ex) -> {
                handler.accept(null, null);
    }
    }
                removeFailureMetadata(ingestDocument);
            }
        int currentProcessor,
                        }
        }
            ingestMetadata.put(ON_FAILURE_PIPELINE_FIELD, failedPipelineId);
        processor.batchExecute(ingestDocumentWrappers, results -> {
    }
        }
 * specific language governing permissions and limitations
                if (result != null) {
 *
        LongSupplier relativeTimeProvider
    public static final String ON_FAILURE_PROCESSOR_TYPE_FIELD = "on_failure_processor_type";
 *
    private void removeFailureMetadata(IngestDocument ingestDocument) {
 * software distributed under the License is distributed on an
 * compatible open source license.
    private final List<Tuple<Processor, OperationMetrics>> processorsWithMetrics;
                            IngestProcessorException compoundProcessorException = newCompoundProcessorException(
 * Unless required by applicable law or agreed to in writing,
        }
            slotIngestDocumentWrapperMap.put(ingestDocumentWrapper.getSlot(), ingestDocumentWrapper);
    private static List<Processor> flattenProcessors(List<Processor> processors) {
    private void putFailureMetadata(IngestDocument ingestDocument, OpenSearchException cause) {
                        ++totalFailed;
        Tuple<Processor, OperationMetrics> processorWithMetric = processorsWithMetrics.get(currentProcessor);
        });
                            );
import org.opensearch.common.metrics.OperationMetrics;
        return "compound";
            removeFailureMetadata(ingestDocument);
            handler.accept(ingestDocument, null);
    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
        int size = ingestDocumentWrappers.size();
                long ingestTimeInNanos = relativeTimeProvider.getAsLong() - startTimeInNanos;
        super();
        return ignoreFailure;
                    if (onFailureProcessors.isEmpty()) {
        if (failedPipelineId != null) {
        ingestMetadata.put(ON_FAILURE_MESSAGE_FIELD, cause.getRootCause().getMessage());
                    innerExecute(currentProcessor + 1, ingestDocument, handler);
                flattened.add(processor);
 */
 * KIND, either express or implied.  See the License for the
        if (pipelineStack.size() > 1) {
    public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {
    }
                }
                    } else {
                                    resultDocumentWrapper.getChildSlot(),
                            documentsWithException.add(
     * Internal logic to process documents with current processor.
        for (Processor processor : processors) {
                if (!documentsDropped.isEmpty()) {
                    IngestDocumentWrapper originalDocumentWrapper = slotToWrapperMap.get(resultDocumentWrapper.getSlot());
                                originalDocumentWrapper.getIngestDocument()
                                }
            return;
import org.opensearch.OpenSearchException;
    }
import java.util.function.Consumer;
                flattened.addAll(compoundProc.flattenProcessors());
/*
        metric.beforeN(size);
    void innerBatchExecute(
    @Override
                            documentsDropped.add(resultDocumentWrapper);
     */
    ) {
    private final LongSupplier relativeTimeProvider;
        if (currentOnFailureProcessor == onFailureProcessors.size()) {
                    if (onFailureProcessors.isEmpty()) {
import java.util.Arrays;
        this.relativeTimeProvider = relativeTimeProvider;
    private final List<Processor> processors;
    }
    private final boolean ignoreFailure;
        IngestDocument ingestDocument,
 * @opensearch.internal
        innerExecute(0, ingestDocument, handler);
 * Modifications Copyright OpenSearch Contributors. See
        Tuple<Processor, OperationMetrics> processorWithMetric = processorsWithMetrics.get(currentProcessor);
     * @param handler callback function
            }
    CompoundProcessor(LongSupplier relativeTimeProvider, Processor... processor) {
        boolean ignoreFailure,
        ingestMetadata.put(ON_FAILURE_PROCESSOR_TYPE_FIELD, failedProcessorType);
 * The OpenSearch Contributors require contributions made to
        List<Processor> onFailureProcessors,
                    }
                                    );
        return flattened;
            exception.addHeader("processor_tag", processorTag);
                            documentsToContinue.add(resultDocumentWrapper);
        List<String> pipelineStack = document.getPipelineStack();
            if (counter.addAndGet(-results.size()) == 0) {
import java.util.function.LongSupplier;
    private Map<Integer, IngestDocumentWrapper> createSlotIngestDocumentWrapperMap(List<IngestDocumentWrapper> ingestDocumentWrappers) {
 * license agreements. See the NOTICE file distributed with
        final OperationMetrics metric = processorWithMetric.v2();
                        if (ignoreFailure) {
        return allProcessors;
                }
            if (processor instanceof CompoundProcessor compoundProc) {
                    }
        // Use synchronization to ensure batches are processed by processors in sequential order
                if (!documentsToContinue.isEmpty()) {
 * You may obtain a copy of the License at
        String processorType = processor.getType();
        String failedProcessorType = (processorTypeHeader != null) ? processorTypeHeader.get(0) : null;
    public List<Processor> getOnFailureProcessors() {
                metric.afterN(allResults.size(), ingestTimeInNanos);
        allProcessors.addAll(flattenProcessors(onFailureProcessors));
            }
    @Override
    CompoundProcessor(
        onFailureProcessor.execute(ingestDocument, (result, e) -> {
 *
            exception.addHeader("processor_type", processorType);
                                resultDocumentWrapper.getException(),
    }
/*
            assert counter.get() >= 0;
    }
        });
        return slotIngestDocumentWrapperMap;
                        );
                    innerBatchExecute(currentProcessor + 1, documentsToContinue, handler);
        }
                List<IngestDocumentWrapper> documentsToContinue = new ArrayList<>();
        int currentOnFailureProcessor,
    public String getType() {
        List<IngestDocumentWrapper> allResults = Collections.synchronizedList(new ArrayList<>());
    public static final String ON_FAILURE_PIPELINE_FIELD = "on_failure_pipeline";
    public String getTag() {
        return onFailureProcessors;
        List<String> processorTypeHeader = cause.getHeader("processor_type");
    void executeOnFailureAsync(
            if (result == null) {
                }
                    } else {
        List<Processor> flattened = new ArrayList<>();
        });
    @Override
        AtomicInteger counter = new AtomicInteger(size);
        return processorsWithMetrics;
        processors.forEach(p -> processorsWithMetrics.add(new Tuple<>(p, new OperationMetrics())));
                return;
        Map<Integer, IngestDocumentWrapper> slotIngestDocumentWrapperMap = new HashMap<>();
    }
        Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();
        this(false, Arrays.asList(processor), Collections.emptyList(), relativeTimeProvider);
        ingestMetadata.remove(ON_FAILURE_MESSAGE_FIELD);
 * under the License.
 * Licensed to Elasticsearch under one or more contributor
        return null;
                            )
        return "CompoundProcessor-" + flattenProcessors().stream().map(Processor::getTag).collect(Collectors.joining("-"));
        final Processor processor = processorWithMetric.v1();
    public String getDescription() {
                                    handler.accept(
        this(ignoreFailure, processors, onFailureProcessors, System::nanoTime);
        ingestMetadata.remove(ON_FAILURE_PROCESSOR_TYPE_FIELD);
                        } else {
                                    compoundProcessorException
        List<IngestDocumentWrapper> ingestDocumentWrappers,
    }
    @Override
 */
        this(false, Arrays.asList(processor), Collections.emptyList());
package org.opensearch.ingest;
                int totalFailed = 0;
/*
 *
        processor.execute(ingestDocument, (result, e) -> {
        return exception;
 */
                List<IngestDocumentWrapper> documentsDropped = new ArrayList<>();
        this.ignoreFailure = ignoreFailure;
            metric.after(ingestTimeInNanos);
        final Processor onFailureProcessor = onFailureProcessors.get(currentOnFailureProcessor);
        metric.before();
        if (processorType != null) {
                // iterate all results to categorize them to: to continue, to drop, with exception
    }
                                        Collections.singletonList(new IngestDocumentWrapper(doc.getSlot(), doc.getChildSlot(), result, ex))
