                                    resultDocumentWrapper.getSlot(),
                } else {
    private final LongSupplier relativeTimeProvider;  
        return allProcessors;  
    public List<Processor> flattenProcessors() {  
    }  
    }
                            documentsToContinue.add(resultDocumentWrapper);
        final Processor processor = processorWithMetric.v1();
        if (currentOnFailureProcessor == onFailureProcessors.size()) {  
                    if (resultDocumentWrapper.getException() != null) {
        List<String> processorOriginHeader = cause.getHeader("pipeline_origin");
 * KIND, either express or implied.  See the License for the
    /**  
        this.onFailureProcessors = onFailureProcessors;
    @Override
                            );
                                    compoundProcessorException
            handler.accept(ingestDocument, null);  
 * The OpenSearch Contributors require contributions made to  
        List<Processor> flattened = new ArrayList<>();
        Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();
 *
        int size = ingestDocumentWrappers.size();
                                )  
        if (currentProcessor == processorsWithMetrics.size()) {  
                }  
 * Unless required by applicable law or agreed to in writing,
                return;
            if (e != null) {
                metric.failed();
                if (result != null) {
                }
                                (result, ex) -> {
     * @param ingestDocumentWrappers batched documents to be processed
            }  
 * compatible open source license.
                            documentsDropped.add(resultDocumentWrapper);
        final Processor processor = processorWithMetric.v1();
 */
                for (IngestDocumentWrapper resultDocumentWrapper : allResults) {  
    public static final String ON_FAILURE_PIPELINE_FIELD = "on_failure_pipeline";  
                }
                List<IngestDocumentWrapper> documentsDropped = new ArrayList<>();
        Map<Integer, IngestDocumentWrapper> slotToWrapperMap = createSlotIngestDocumentWrapperMap(ingestDocumentWrappers);
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.processorsWithMetrics = new ArrayList<>(processors.size());
    private static List<Processor> flattenProcessors(List<Processor> processors) {  
                                originalDocumentWrapper.getIngestDocument()
 * Modifications Copyright OpenSearch Contributors. See
    void innerExecute(int currentProcessor, IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {
    public CompoundProcessor(boolean ignoreFailure, List<Processor> processors, List<Processor> onFailureProcessors) {
                }
            ingestMetadata.put(ON_FAILURE_PIPELINE_FIELD, failedPipelineId);
                                    handler.accept(  
        }
                                new IngestDocumentWrapper(
        ingestMetadata.put(ON_FAILURE_MESSAGE_FIELD, cause.getRootCause().getMessage());  
    }
    }
            } else {
        int currentProcessor,
/*  
        }  
 */  
        Tuple<Processor, OperationMetrics> processorWithMetric = processorsWithMetrics.get(currentProcessor);
import java.util.List;  
        ingestMetadata.put(ON_FAILURE_PROCESSOR_TYPE_FIELD, failedProcessorType);
        BiConsumer<IngestDocument, Exception> handler  
 *
    }  
        IngestDocument ingestDocument,
                        documentsWithException.forEach(  
 * not use this file except in compliance with the License.
                    handler.accept(documentsDropped);  
    ) {
        metric.before();
        Consumer<List<IngestDocumentWrapper>> handler
        });
        this(false, Arrays.asList(processor), Collections.emptyList());
        return processorsWithMetrics;  
            if (counter.addAndGet(-results.size()) == 0) {  
import java.util.ArrayList;
    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
        }  
import org.opensearch.common.collect.Tuple;
    public CompoundProcessor(Processor... processor) {  
                    }
        ingestMetadata.remove(ON_FAILURE_PROCESSOR_TAG_FIELD);  
    private void removeFailureMetadata(IngestDocument ingestDocument) {
    public String getDescription() {
import java.util.function.Consumer;
                if (!documentsToContinue.isEmpty()) {
import java.util.function.LongSupplier;
            if (results.isEmpty()) return;  
import org.opensearch.common.metrics.OperationMetrics;  
                    handler.accept(null, null);
    public String getType() {
        final OperationMetrics metric = processorWithMetric.v2();  
    List<Tuple<Processor, OperationMetrics>> getProcessorsWithMetrics() {
            removeFailureMetadata(ingestDocument);
        this.processors = processors;
        }
                        handler.accept(documentsWithException);
                handler.accept(null, null);  
                    innerExecute(currentProcessor + 1, ingestDocument, handler);
        super();
            assert counter.get() >= 0;  
                } else {
                            documentsToContinue.add(originalDocumentWrapper);
        List<Processor> onFailureProcessors,
 * software distributed under the License is distributed on an
     */  
        }
        this(ignoreFailure, processors, onFailureProcessors, System::nanoTime);
            if (result == null) {
                if (!documentsWithException.isEmpty()) {
 * license agreements. See the NOTICE file distributed with
                                processor,  
                        } else {  
        });
        final OperationMetrics metric = processorWithMetric.v2();  
        String failedProcessorTag = (processorTagHeader != null) ? processorTagHeader.get(0) : null;  
        innerExecute(0, ingestDocument, handler);
    }
        // Use synchronization to ensure batches are processed by processors in sequential order
        allProcessors.addAll(flattenProcessors(onFailureProcessors));
        metric.beforeN(size);  
        List<IngestDocumentWrapper> allResults = Collections.synchronizedList(new ArrayList<>());  
            }
                    }  
        String failedProcessorType = (processorTypeHeader != null) ? processorTypeHeader.get(0) : null;
    }  
                                (IngestProcessorException) doc.getException(),
        if (currentProcessor == processorsWithMetrics.size()) {
                if (!documentsDropped.isEmpty()) {
public class CompoundProcessor implements Processor {
    private void putFailureMetadata(IngestDocument ingestDocument, OpenSearchException cause) {
/*
            if (processor instanceof CompoundProcessor compoundProc) {  
    }  
        return "compound";
            } else {
 * A Processor that executes a list of other "processors". It executes a separate list of  
            return;
                flattened.add(processor);  
            if (e != null) {
            allResults.addAll(results);
        List<IngestDocumentWrapper> ingestDocumentWrappers,  
                            );
        return flattened;  
                    innerExecute(currentProcessor + 1, result, handler);  
        boolean ignoreFailure,  
        onFailureProcessor.execute(ingestDocument, (result, e) -> {
    }
import java.util.concurrent.atomic.AtomicInteger;
    }
                            documentsWithException.add(  
import java.util.Arrays;  
        if (failedPipelineId != null) {  
                                    originalDocumentWrapper.getIngestDocument(),
                            IngestProcessorException compoundProcessorException = newCompoundProcessorException(
        processors.forEach(p -> processorsWithMetrics.add(new Tuple<>(p, new OperationMetrics())));
    }  
    private Map<Integer, IngestDocumentWrapper> createSlotIngestDocumentWrapperMap(List<IngestDocumentWrapper> ingestDocumentWrappers) {  
                                    );
import java.util.HashMap;
                        }
        if (currentOnFailureProcessor == 0) {
        }
    public List<Processor> getProcessors() {
/*  
        processor.batchExecute(ingestDocumentWrappers, results -> {
                }
                        if (resultDocumentWrapper.getIngestDocument() == null) {
    }
            }
                        if (ignoreFailure) {
    }
    static IngestProcessorException newCompoundProcessorException(Exception e, Processor processor, IngestDocument document) {
            metric.after(ingestTimeInNanos);
                }  
        ingestMetadata.remove(ON_FAILURE_MESSAGE_FIELD);
    @Override  
        return "CompoundProcessor-" + flattenProcessors().stream().map(Processor::getTag).collect(Collectors.joining("-"));
        if (e instanceof IngestProcessorException ingestException && ingestException.getHeader("processor_type") != null) {
        for (Processor processor : processors) {
    }
 * SPDX-License-Identifier: Apache-2.0
        Map<String, Object> ingestMetadata = ingestDocument.getIngestMetadata();  
                    if (onFailureProcessors.isEmpty()) {  
        List<String> processorTagHeader = cause.getHeader("processor_tag");  
    void innerBatchExecute(
        }
            // counter equals to 0 means all documents are processed and called back.
                List<IngestDocumentWrapper> documentsWithException = new ArrayList<>();
     * @param handler callback function
        this.relativeTimeProvider = relativeTimeProvider;  
                    IngestDocumentWrapper originalDocumentWrapper = slotToWrapperMap.get(resultDocumentWrapper.getSlot());
                                    resultDocumentWrapper.getChildSlot(),  
import java.util.Collections;
                    } else {  
    private final List<Processor> processors;  
    }  
import java.util.Map;
                                        Collections.singletonList(new IngestDocumentWrapper(doc.getSlot(), doc.getChildSlot(), result, ex))
     * Internal logic to process documents with current processor.
                    IngestProcessorException compoundProcessorException = newCompoundProcessorException(e, processor, ingestDocument);  
        final Processor onFailureProcessor = onFailureProcessors.get(currentOnFailureProcessor);  
                metric.afterN(allResults.size(), ingestTimeInNanos);
        innerBatchExecute(0, ingestDocumentWrappers, handler);  
        Tuple<Processor, OperationMetrics> processorWithMetric = processorsWithMetrics.get(currentProcessor);
                        );
        this(false, Arrays.asList(processor), Collections.emptyList(), relativeTimeProvider);  
        for (IngestDocumentWrapper ingestDocumentWrapper : ingestDocumentWrappers) {
            exception.addHeader("processor_type", processorType);
        ingestMetadata.remove(ON_FAILURE_PIPELINE_FIELD);
 */
                    }  
                int totalFailed = 0;
     *
            handler.accept(ingestDocumentWrappers);
        String processorTag = processor.getTag();  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
        Map<Integer, IngestDocumentWrapper> slotIngestDocumentWrapperMap = new HashMap<>();
        return exception;  
        return slotIngestDocumentWrapperMap;
    CompoundProcessor(
                if (totalFailed > 0) {
                    if (onFailureProcessors.isEmpty()) {
        }
                                resultDocumentWrapper.getException(),
    }  
    }
        return null;  
                        ++totalFailed;  
                removeFailureMetadata(ingestDocument);  
package org.opensearch.ingest;
            }
            }
    }  
            return ingestException;  
import java.util.function.BiConsumer;  
            slotIngestDocumentWrapperMap.put(ingestDocumentWrapper.getSlot(), ingestDocumentWrapper);  
                                doc.getIngestDocument(),  
                    } else {
 * @opensearch.internal  
    void executeOnFailureAsync(
    public static final String ON_FAILURE_PROCESSOR_TYPE_FIELD = "on_failure_processor_type";
                    } else {  
            return;
 * this file be licensed under the Apache-2.0 license or a
        List<String> pipelineStack = document.getPipelineStack();
     * @param currentProcessor index of processor to process batched documents  
                                0,
 *    http://www.apache.org/licenses/LICENSE-2.0
                long ingestTimeInNanos = relativeTimeProvider.getAsLong() - startTimeInNanos;
 * under the License.  
                            doc -> executeOnFailureAsync(
 * You may obtain a copy of the License at  
    ) {
                        executeOnFailureAsync(0, ingestDocument, compoundProcessorException, handler);
        List<Processor> processors,
    @Override
        }
        List<Processor> allProcessors = new ArrayList<>(flattenProcessors(processors));
    }
        ingestMetadata.put(ON_FAILURE_PROCESSOR_TAG_FIELD, failedProcessorTag);
            long ingestTimeInNanos = relativeTimeProvider.getAsLong() - startTimeInNanos;
    }
                            )
        LongSupplier relativeTimeProvider  
                // iterate all results to categorize them to: to continue, to drop, with exception
import java.util.stream.Collectors;  
            putFailureMetadata(ingestDocument, exception);  
    @Override
            executeOnFailureAsync(currentOnFailureProcessor + 1, ingestDocument, exception, handler);  
        AtomicInteger counter = new AtomicInteger(size);
    public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {  
        throw new UnsupportedOperationException("this method should not get executed");
 * ownership. Elasticsearch licenses this file to you under  
        List<String> processorTypeHeader = cause.getHeader("processor_type");
                }
 *  
        String failedPipelineId = (processorOriginHeader != null) ? processorOriginHeader.get(0) : null;
    public List<Processor> getOnFailureProcessors() {
    public boolean isIgnoreFailure() {  
 * GitHub history for details.
                List<IngestDocumentWrapper> documentsToContinue = new ArrayList<>();  
        }
                handler.accept(null, newCompoundProcessorException(e, onFailureProcessor, ingestDocument));
    private final boolean ignoreFailure;
    CompoundProcessor(LongSupplier relativeTimeProvider, Processor... processor) {
        }
                if (ignoreFailure) {  
import org.opensearch.OpenSearchException;
    private final List<Tuple<Processor, OperationMetrics>> processorsWithMetrics;
    public void batchExecute(List<IngestDocumentWrapper> ingestDocumentWrappers, Consumer<List<IngestDocumentWrapper>> handler) {
                        handler.accept(null, compoundProcessorException);
                    innerBatchExecute(currentProcessor + 1, documentsToContinue, handler);  
/**
            return;  
        });
        final long startTimeInNanos = relativeTimeProvider.getAsLong();
        if (processorTag != null) {
                        }
 * "onFailureProcessors" when any of the processors throw an {@link Exception}.
                    metric.failedN(totalFailed);  
            handler.accept(ingestDocument, null);
    private final List<Processor> onFailureProcessors;
    ) {
        return onFailureProcessors;
        ingestMetadata.remove(ON_FAILURE_PROCESSOR_TYPE_FIELD);
}
        if (processorType != null) {  
        return processors;  
            exception.addHeader("pipeline_origin", pipelineStack);  
    @Override  
 * specific language governing permissions and limitations
    }
        final long startTimeInNanos = relativeTimeProvider.getAsLong();
    @Override
            exception.addHeader("processor_tag", processorTag);
 */  
                removeFailureMetadata(ingestDocument);
 * the Apache License, Version 2.0 (the "License"); you may
        if (pipelineStack.size() > 1) {
    public String getTag() {  
 *
        IngestProcessorException exception = new IngestProcessorException(e);  
    public static final String ON_FAILURE_MESSAGE_FIELD = "on_failure_message";  
    }
        OpenSearchException exception,
    public static final String ON_FAILURE_PROCESSOR_TAG_FIELD = "on_failure_processor_tag";
        int currentOnFailureProcessor,  
                return;
                flattened.addAll(compoundProc.flattenProcessors());
                        } else {  
                                }  
        String processorType = processor.getType();
        return ignoreFailure;
        this.ignoreFailure = ignoreFailure;  
        processor.execute(ingestDocument, (result, e) -> {  
