     * Process batched documents and they could be potentially modified by processors.
        /**
    /**
            handler.accept(Collections.emptyList());
            results.set(slot, new IngestDocumentWrapper(ingestDocumentWrapper.getSlot(), ingestDocumentWrapper.getChildSlot(), doc, ex));
    }
            IngestService ingestService,
            this.indicesService = indicesService;
 * KIND, either express or implied.  See the License for the
    String getTag();
     * Only override this method if the processor can benefit from processing documents in batches, otherwise, please
/*
 * under the License.
 * Processors may get called concurrently and thus need to be thread-safe.
         */
        AtomicArray<IngestDocumentWrapper> results,
    }
    private void innerExecute(
import org.opensearch.env.Environment;
        final IngestDocument result;
     * otherwise just overwrite {@link #execute(IngestDocument)}.
        int size = ingestDocumentWrappers.size();
    String getType();
     * Gets the type of a processor
    /**
        AtomicArray<IngestDocumentWrapper> results = new AtomicArray<>(size);
 * compatible open source license.
     * Infrastructure class that holds services that can be used by processor factories to create processor instances
            IndicesService indicesService
            this.threadContext = threadContext;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.analysis.AnalysisRegistry;
    IngestDocument execute(IngestDocument ingestDocument) throws Exception;
 */
            this.env = env;
    /**
 * @opensearch.internal
        if (ingestDocumentWrappers.isEmpty()) {
import org.opensearch.transport.client.Client;
    /**
        public final Consumer<Runnable> genericExecutor;
         */
            this.client = client;
            ScriptService scriptService,
 *
        return false;
 *
            handler.accept(null, e);
 * You may obtain a copy of the License at
        AtomicInteger counter,
        public final BiFunction<Long, Runnable, Scheduler.ScheduledCancellable> scheduler;
     */
        execute(ingestDocumentWrapper.getIngestDocument(), (doc, ex) -> {
        public final ThreadContext threadContext;
        }
            this.ingestService = ingestService;
        public final IngestService ingestService;
            BiFunction<Long, Runnable, Scheduler.ScheduledCancellable> scheduler,
 * specific language governing permissions and limitations
    /**
            Client client,
     * @param handler callback with IngestDocument result and exception wrapped in IngestDocumentWrapper.
    default void batchExecute(List<IngestDocumentWrapper> ingestDocumentWrappers, Consumer<List<IngestDocumentWrapper>> handler) {
import java.util.function.BiConsumer;
         * Provides access to the node client
        /**
        public final Client client;
    }
            this.analysisRegistry = analysisRegistry;
     * @return If <code>null</code> is returned then the current document will be dropped and not be indexed,
         * @param description A short description of what this processor does
        /**
        int slot,
        public final IndicesService indicesService;
        ) {
    ) {
     * Expert method: only override this method if a processor implementation needs to make an asynchronous call,
 * A processor implementation may modify the data belonging to a document.
import java.util.function.BiFunction;
            this.scheduler = scheduler;
import java.util.Collections;
 * <p>
        }
 * software distributed under the License is distributed on an
     * and that gets passed around to all {@link org.opensearch.plugins.IngestPlugin}s.
         * Provides scheduler support
        /**
 */
     *
import java.util.Map;
     */
         * instances that have run prior to in ingest.
 */
         *  @param processorFactories Other processors which may be created inside this processor
    class Parameters {
        IngestDocumentWrapper ingestDocumentWrapper,
 *
     * @param ingestDocumentWrappers a list of wrapped IngestDocument
         * Provides processors script support.
     */
import java.util.List;
         * @return if the factory is for system generated processor
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor
         */
}
 * Whether changes are made and what exactly is modified is up to the implementation.
         */
import java.util.function.Consumer;
/*
         */
         */
     */
    }
     * Gets the description of a processor.
     */
         * Allows processors to read headers set by {@link org.opensearch.action.support.ActionFilter}
import org.opensearch.common.util.concurrent.AtomicArray;
         *
         * @param config The configuration for the processor
                handler.accept(results.asList());
 */
         * Useful to provide access to the node's environment like config directory to processor factories.
        public Parameters(
 * The OpenSearch Contributors require contributions made to
        default boolean isSystemGenerated() {
        public final ScriptService scriptService;
    /**
 * license agreements. See the NOTICE file distributed with
         */
            this.scriptService = scriptService;
 * ownership. Elasticsearch licenses this file to you under
        for (int i = 0; i < size; ++i) {
        }
     *
     */
package org.opensearch.ingest;
        /**
         * Provide analyzer support
     * Introspect and potentially modify the incoming data.
        /**
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
            Consumer<Runnable> genericExecutor,
/**
            result = execute(ingestDocument);
import org.opensearch.common.util.concurrent.ThreadContext;
     * A factory that knows how to construct a processor based on a map of maps.
 * Modifications Copyright OpenSearch Contributors. See
            Environment env,
        public final AnalysisRegistry analysisRegistry;
         * <b>Note:</b> Implementations are responsible for removing the used configuration keys, so that after
    }
 * not use this file except in compliance with the License.
        public final Environment env;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Processor create(Map<String, Factory> processorFactories, String tag, String description, Map<String, Object> config)
            if (counter.decrementAndGet() == 0) {
        /**
        } catch (Exception e) {
import java.util.function.LongSupplier;
     * @return if the processor is systematically generated
            return;
import org.opensearch.script.ScriptService;
import org.opensearch.threadpool.Scheduler;
    /**
            innerExecute(i, ingestDocumentWrappers.get(i), results, counter, handler);
     */
        }
     *         otherwise this document will be kept and indexed
    interface Factory {
    default boolean isSystemGenerated() {
            return;
     * Introspect and potentially modify the incoming data.
 *
            }
            return false;
    }
         * @param tag The tag for the processor
        /**
 * Unless required by applicable law or agreed to in writing,
            ThreadContext threadContext,
            LongSupplier relativeTimeSupplier,
        });
import java.util.concurrent.atomic.AtomicInteger;
import org.opensearch.indices.IndicesService;
/*
        }
public interface Processor {
    String getDescription();
 * the Apache License, Version 2.0 (the "License"); you may
        Consumer<List<IngestDocumentWrapper>> handler
            this.relativeTimeSupplier = relativeTimeSupplier;
         */
        public final LongSupplier relativeTimeSupplier;
            this.genericExecutor = genericExecutor;
        handler.accept(result, null);
            throws Exception;
         * Creates a processor based on the specified map of maps config.
    default void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {
     * Gets the tag of a processor.
     */
            AnalysisRegistry analysisRegistry,
    /**
 * this work for additional information regarding copyright
     * use default implementation.
     */
        AtomicInteger counter = new AtomicInteger(size);
        try {
     * <p>
