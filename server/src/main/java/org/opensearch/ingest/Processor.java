            this.env = env;
 * compatible open source license.
            LongSupplier relativeTimeSupplier,
         * <b>Note:</b> Implementations are responsible for removing the used configuration keys, so that after
 * GitHub history for details.
    String getDescription();
            return;
        AtomicArray<IngestDocumentWrapper> results,  
 */
            handler.accept(null, e);
    private void innerExecute(  
        public final ThreadContext threadContext;  
 * this file be licensed under the Apache-2.0 license or a
        execute(ingestDocumentWrapper.getIngestDocument(), (doc, ex) -> {
                handler.accept(results.asList());
 */  
         * Allows processors to read headers set by {@link org.opensearch.action.support.ActionFilter}  
        }  
    default void execute(IngestDocument ingestDocument, BiConsumer<IngestDocument, Exception> handler) {
 * ownership. Elasticsearch licenses this file to you under  
import java.util.List;
         */
         */  
        AtomicInteger counter = new AtomicInteger(size);
     * <p>
        } catch (Exception e) {  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.env.Environment;  
 * <p>
     */  
         *  
        public final IngestService ingestService;
        public final IndicesService indicesService;  
     *  
 *
     * @param handler callback with IngestDocument result and exception wrapped in IngestDocumentWrapper.  
     * otherwise just overwrite {@link #execute(IngestDocument)}.  
    interface Factory {
            Client client,
     * Introspect and potentially modify the incoming data.  
            this.analysisRegistry = analysisRegistry;
            this.genericExecutor = genericExecutor;
    default void batchExecute(List<IngestDocumentWrapper> ingestDocumentWrappers, Consumer<List<IngestDocumentWrapper>> handler) {
import java.util.Collections;
            IngestService ingestService,  
 * Whether changes are made and what exactly is modified is up to the implementation.  
    /**
import org.opensearch.indices.IndicesService;
    /**
        public Parameters(
    class Parameters {  
         * @return if the factory is for system generated processor
    IngestDocument execute(IngestDocument ingestDocument) throws Exception;
        /**  
            IndicesService indicesService  
            }
     */
        handler.accept(result, null);
        public final ScriptService scriptService;
        AtomicArray<IngestDocumentWrapper> results = new AtomicArray<>(size);  
        }
     * @param ingestDocumentWrappers a list of wrapped IngestDocument
            if (counter.decrementAndGet() == 0) {  
 * You may obtain a copy of the License at  
        /**  
         * @param config The configuration for the processor
     *         otherwise this document will be kept and indexed
        ) {
        /**
    }  
        int size = ingestDocumentWrappers.size();
            result = execute(ingestDocument);
}  
    String getType();  
            ThreadContext threadContext,  
            this.threadContext = threadContext;
        int slot,
     */
     * A factory that knows how to construct a processor based on a map of maps.
 * the Apache License, Version 2.0 (the "License"); you may
    }
 *  
            this.scriptService = scriptService;  
         */
            this.relativeTimeSupplier = relativeTimeSupplier;  
    }
            this.scheduler = scheduler;
            innerExecute(i, ingestDocumentWrappers.get(i), results, counter, handler);
 * KIND, either express or implied.  See the License for the
     * Expert method: only override this method if a processor implementation needs to make an asynchronous call,
            BiFunction<Long, Runnable, Scheduler.ScheduledCancellable> scheduler,
    /**  
         * instances that have run prior to in ingest.
            this.client = client;  
import org.opensearch.threadpool.Scheduler;
        AtomicInteger counter,
public interface Processor {  
        public final BiFunction<Long, Runnable, Scheduler.ScheduledCancellable> scheduler;
     */
        default boolean isSystemGenerated() {  
        }  
        /**
        if (ingestDocumentWrappers.isEmpty()) {  
         */  
    String getTag();
import java.util.function.BiConsumer;
        /**  
    }
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Map;  
 * A processor implementation may modify the data belonging to a document.
import org.opensearch.transport.client.Client;
            throws Exception;
         */
         * @param description A short description of what this processor does
 * @opensearch.internal
package org.opensearch.ingest;
    }
 * The OpenSearch Contributors require contributions made to  
     */
     * Gets the tag of a processor.  
 *  
import java.util.function.Consumer;
         * Creates a processor based on the specified map of maps config.
 * software distributed under the License is distributed on an
        /**
        public final Consumer<Runnable> genericExecutor;  
        }  
 * under the License.  
         * Provides access to the node client
        final IngestDocument result;  
        Processor create(Map<String, Factory> processorFactories, String tag, String description, Map<String, Object> config)  
import org.opensearch.common.util.concurrent.ThreadContext;
/*  
        for (int i = 0; i < size; ++i) {
         */
/*
            results.set(slot, new IngestDocumentWrapper(ingestDocumentWrapper.getSlot(), ingestDocumentWrapper.getChildSlot(), doc, ex));
         */
 * Processors may get called concurrently and thus need to be thread-safe.
 */
/**
        public final LongSupplier relativeTimeSupplier;
     * @return if the processor is systematically generated
import org.opensearch.script.ScriptService;  
import org.opensearch.index.analysis.AnalysisRegistry;
         * Provide analyzer support
 */  
     * Gets the type of a processor
         */
    ) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
         * Provides processors script support.
 *
     * @return If <code>null</code> is returned then the current document will be dropped and not be indexed,
     * Infrastructure class that holds services that can be used by processor factories to create processor instances  
 * Licensed to Elasticsearch under one or more contributor  
        IngestDocumentWrapper ingestDocumentWrapper,
            return false;
         * Provides scheduler support  
     * Introspect and potentially modify the incoming data.
            ScriptService scriptService,
        try {
import java.util.function.LongSupplier;
         *  @param processorFactories Other processors which may be created inside this processor
    /**
        public final Environment env;
     * Gets the description of a processor.
        }  
            Consumer<Runnable> genericExecutor,
/*  
     * Only override this method if the processor can benefit from processing documents in batches, otherwise, please
            handler.accept(Collections.emptyList());
            AnalysisRegistry analysisRegistry,
     * use default implementation.  
    /**  
     * and that gets passed around to all {@link org.opensearch.plugins.IngestPlugin}s.
        public final Client client;
    default boolean isSystemGenerated() {  
        });  
 * specific language governing permissions and limitations
     * Process batched documents and they could be potentially modified by processors.
     *
        return false;
        /**
 * SPDX-License-Identifier: Apache-2.0
         * @param tag The tag for the processor  
    }
import java.util.function.BiFunction;  
    /**
            this.ingestService = ingestService;
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.util.concurrent.AtomicArray;
            return;
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
    /**  
     */
import java.util.concurrent.atomic.AtomicInteger;
         * Useful to provide access to the node's environment like config directory to processor factories.  
     */  
        Consumer<List<IngestDocumentWrapper>> handler
     */  
        /**
            this.indicesService = indicesService;
            Environment env,  
        public final AnalysisRegistry analysisRegistry;  
     */
 * not use this file except in compliance with the License.
