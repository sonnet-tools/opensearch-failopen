        return compoundProcessor.getOnFailureProcessors();
    }
 */
    public List<Processor> getOnFailureProcessors() {
    public Integer getVersion() {
                        + factory.getClass().getName()
        this.description = description;
     */
    private final String id;
        if (config.isEmpty() == false) {
}
    @Nullable
    }
        return description;
     * @param ingestDocumentWrappers a list of wrapped IngestDocument to ingest.
    /**
        metrics.beforeN(size);
     * If {@code null} is returned then this document will be dropped and not indexed, otherwise
     */
                "pipeline ["
 * A pipeline is a list of {@link Processor} instances grouped under a unique id.
        ScriptService scriptService
 * ownership. Elasticsearch licenses this file to you under
     */
 * You may obtain a copy of the License at
     */
     */
            throw new OpenSearchParseException("pipeline [" + id + "] cannot have an empty on_failure option defined");
 * Licensed to Elasticsearch under one or more contributor
        return id;
    private final String description;
    public OperationMetrics getMetrics() {
                        );
    }
     */
import java.util.function.Consumer;
import java.util.Arrays;
     * An optional description of what this pipeline is doing to the data gets processed by this pipeline.
                final Processor processor = factory.create(systemIngestProcessorFactories, null, null, processorConfig);
     *
        });
import java.util.Collections;
            scriptService,
 * software distributed under the License is distributed on an
    }
                    processors.add(processor);
                if (processor != null) {
    public List<Processor> getProcessors() {
 * under the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    ) {
/*
                metrics.failed();
        final Map<String, Object> processorConfig = Collections.unmodifiableMap(config);
            metrics.failedN(failedCount);
            }
        if (onFailureProcessorConfigs != null && onFailureProcessors.isEmpty()) {
     * exception thrown in pipeline processors
        @NonNull final String index,
        this.relativeTimeProvider = relativeTimeProvider;
     *
import java.util.ArrayList;
        final long startTimeInNanos = relativeTimeProvider.getAsLong();
            int failedCount = (int) results.stream().filter(t -> t.getException() != null).count();
     * Flattens the normal and on failure processors into a single list. The original order is lost.
    }
 * KIND, either express or implied.  See the License for the
    public void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {
        @Nullable Integer version,
        // make it an unmodifiable map.
        List<Processor> onFailureProcessors = ConfigurationUtils.readProcessorConfigs(
        @NonNull final Map<String, Processor.Factory> systemIngestProcessorFactories,
            );
            long ingestTimeInNanos = relativeTimeProvider.getAsLong() - startTimeInNanos;
     * @return {@code null} if not supplied.
                                + processor.getClass().getName()
    public static final String VERSION_KEY = "version";
        List<Processor> processors = ConfigurationUtils.readProcessorConfigs(processorConfigs, scriptService, processorFactories);
    }
        this.id = id;
        systemIngestProcessorFactories.values().forEach((factory) -> {
        this.version = version;
            return new Pipeline(id, description, null, new CompoundProcessor());
    Pipeline(
 * The OpenSearch Contributors require contributions made to
import org.opensearch.OpenSearchParseException;
        @Nullable String description,
        return new Pipeline(id, description, version, compoundProcessor);
/**
    public static final String ON_FAILURE_KEY = "on_failure";
                    e
        String description = ConfigurationUtils.readOptionalStringProperty(null, null, config, DESCRIPTION_KEY);
        CompoundProcessor compoundProcessor,
import java.util.List;
 */
    /**
     * An optional version stored with the pipeline so that it can be used to determine if the pipeline should be updated / replaced.
 * GitHub history for details.
            throw new OpenSearchParseException(
import org.opensearch.script.ScriptService;
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
    ) {
     * Unmodifiable list containing each processor that operates on the data.
        this(id, description, version, compoundProcessor, System::nanoTime);
    public CompoundProcessor getCompoundProcessor() {
                    }
    }
        final long startTimeInNanos = relativeTimeProvider.getAsLong();
    /**
        String id,
        }
        if (config.isEmpty()) {
            if (e != null) {
    public Pipeline(String id, @Nullable String description, @Nullable Integer version, CompoundProcessor compoundProcessor) {
    }
     * <p>
        );
    private final LongSupplier relativeTimeProvider;
 */
    private final Integer version;
        return compoundProcessor.getProcessors();
 * this file be licensed under the Apache-2.0 license or a
    /**
        List<Map<String, Object>> processorConfigs = ConfigurationUtils.readList(null, null, config, PROCESSORS_KEY);
import java.util.Map;
            handler.accept(result, e);
     * this document will be kept and indexed. Document and the exception happened during processing are kept in
 *
        @NonNull final Map<String, Object> config
        List<Map<String, Object>> onFailureProcessorConfigs = ConfigurationUtils.readOptionalList(null, null, config, ON_FAILURE_KEY);
    /**
 *
                        + index
 *
    }
        compoundProcessor.batchExecute(ingestDocumentWrappers, results -> {
    /**
import org.opensearch.common.metrics.OperationMetrics;
            false,
        }
    }
                                + "for the index ["
                    if (processor.isSystemGenerated() == false) {
        metrics.before();
        return compoundProcessor.flattenProcessors();
        // This config is based on the index and will be used by all the factories. Each factory should not modify it so
package org.opensearch.ingest;
     */
    }
    }
                    + "] doesn't support one or more provided configuration parameters "
        Integer version = ConfigurationUtils.readIntProperty(null, null, config, VERSION_KEY, null);
    @Nullable
 * compatible open source license.
 *
                                + "] is not a system generated ingest processor."
 * specific language governing permissions and limitations
                        + ". "
     */
    private final CompoundProcessor compoundProcessor;
     */
                );
        final String description = "This is an in-memory systematically generated ingest pipeline.";
                }
    }
     * Unmodifiable list containing each on_failure processor that operates on the data in case of
    public String getDescription() {
            Collections.unmodifiableList(processors),
 * not use this file except in compliance with the License.
    public static Pipeline createSystemIngestPipeline(
                                + "] because the processor ["
        this.metrics = new OperationMetrics();
                    + Arrays.toString(config.keySet().toArray())
    private final OperationMetrics metrics;
            onFailureProcessorConfigs,
 *    http://www.apache.org/licenses/LICENSE-2.0
        return version;
                throw new RuntimeException(
        Map<String, Object> config,
                    "Failed to systematically create the system ingest processor from the factory "
            metrics.after(ingestTimeInNanos);
        String id,
     */
     * Get the underlying {@link CompoundProcessor} containing the Pipeline's processors
    @Nullable
    @Nullable
            Collections.unmodifiableList(onFailureProcessors)
            processorFactories
            long ingestTimeInNanos = relativeTimeProvider.getAsLong() - startTimeInNanos;
        return metrics;
import org.opensearch.common.Nullable;
        Map<String, Processor.Factory> processorFactories,
 * this work for additional information regarding copyright
            } catch (Exception e) {
public final class Pipeline {
    public static final String DESCRIPTION_KEY = "description";
/*
    // package private for testing
     * If {@code null} is returned then this document will be dropped and not indexed, otherwise
        // if no config we create an empty pipeline with no processor.
                    + id
        compoundProcessor.execute(ingestDocument, (result, e) -> {
     * Modifies the data of a document to be indexed based on the processor this pipeline holds
/*
     * @param handler callback with IngestDocument result and exception wrapped in IngestDocumentWrapper.
     * The unique id of this pipeline
    public void batchExecute(List<IngestDocumentWrapper> ingestDocumentWrappers, Consumer<List<IngestDocumentWrapper>> handler) {
    public String getId() {
import java.util.function.BiConsumer;
        LongSupplier relativeTimeProvider
        return new Pipeline(id, description, null, new CompoundProcessor(false, processors, Collections.emptyList()));
    /**
    public static Pipeline create(
        CompoundProcessor compoundProcessor = new CompoundProcessor(
    }
    /**
 * @opensearch.internal
                                + index
        }
                        throw new RuntimeException(
                        + e.getMessage(),
        return compoundProcessor;
            try {
import java.util.function.LongSupplier;
                        + " for the index "
     * this document will be kept and indexed.
    public static final String PROCESSORS_KEY = "processors";
        });
 */
        final List<Processor> processors = new ArrayList<>();
        );
        final String id = index + "_system_generated_ingest_pipeline";
            handler.accept(results);
 * license agreements. See the NOTICE file distributed with
            metrics.afterN(results.size(), ingestTimeInNanos);
     * Modifies the data of batched multiple documents to be indexed based on the processor this pipeline holds
        });
     * IngestDocumentWrapper and callback to upper level.
     * The metrics associated with this pipeline.
    public List<Processor> flattenAllProcessors() {
    /**
 * the Apache License, Version 2.0 (the "License"); you may
        int size = ingestDocumentWrappers.size();
    /**
        this.compoundProcessor = compoundProcessor;
            }
 * Modifications Copyright OpenSearch Contributors. See
import reactor.util.annotation.NonNull;
     * <p>
    ) throws Exception {
     * This can be useful for pipeline validation purposes.
                            "Cannot create the system generated ingest pipeline "
