 * SPDX-License-Identifier: Apache-2.0
     * Updates the cached final pipeline name. Called on initial resolution and on dynamic settings change.
     * @param ingestService the ingest service
    private volatile String resolvedFinalPipeline;
 * compatible open source license.
    private final CounterMetric failedCount = new CounterMetric();  
                }
    private final CounterMetric droppedCount = new CounterMetric();
     * Executes final_pipeline on the source map synchronously on the calling thread.  
        indexRequest.isPipelineResolved(true);
        if (Objects.equals(originalRouting, indexRequest.routing()) == false) {
            );
            resolvedFinalPipeline = null;
        );  
    /**  
import java.util.Map;
import java.util.concurrent.TimeUnit;
 * shard, and requests are not forwarded to dedicated ingest nodes.  
            TimeUnit.NANOSECONDS.toMillis(executionTime.sum()),  
        }  
import org.opensearch.common.Nullable;
     * Resolves the final pipeline from index settings and registers a dynamic settings listener.
 * Handles ingest pipeline resolution and execution for pull-based ingestion.  
    /**
     * Creates an IngestPipelineExecutor for the given index.
     * @throws Exception if pipeline execution fails
        this.index = Objects.requireNonNull(index);
        final String originalRouting = indexRequest.routing();
        }, slot -> dropped.set(true));
     * Returns pipeline execution metrics.
                    + originalId
                "Ingest pipeline attempted to change _routing. _routing mutations are not allowed in pull-based ingestion."  
                if (failureRef.compareAndSet(null, e) == false) {  
import java.util.Collections;
     * Visible for testing. Creates an executor with a pre-resolved pipeline name,
            return null;  
 *
        }
/*  
 * <p>Resolves configured pipelines from index settings at initialization and executes them
        }
    }
            throw failureRef.get();
}
     */
     * @return the transformed source map, or null if the document was dropped by the pipeline
                    + "]. _id mutations are not allowed in pull-based ingestion."
        AtomicBoolean dropped = new AtomicBoolean(false);
 */  
    private final MeanMetric executionTime = new MeanMetric();
    }
        executionTime.inc(System.nanoTime() - startTimeNanos);  
        long startTimeNanos = System.nanoTime();
        if (finalPipeline == null) {  
        indexRequest.setPipeline(IngestService.NOOP_PIPELINE_NAME);
 * <p>Unlike push-based indexing, pipeline execution in pull-based ingestion does not require the
        if (failureRef.get() != null) {
import java.util.concurrent.atomic.AtomicBoolean;
 */
        this.ingestService = Objects.requireNonNull(ingestService);  
        final String originalId = id;  
/**
        this.index = Objects.requireNonNull(index);
            resolvedFinalPipeline = finalPipeline;
    private static final Logger logger = LogManager.getLogger(IngestPipelineExecutor.class);
        // Build IndexRequest to carry the document through the pipeline  
            }  
 *
    // Pipeline execution metrics
import org.opensearch.ingest.IngestService;
     */
            throw new IllegalStateException(
import org.opensearch.common.metrics.CounterMetric;
    /**  
 * node to have the {@code ingest} role. Transformations are executed locally on the node hosting the
 * this file be licensed under the Apache-2.0 license or a
            return sourceMap;
import org.opensearch.common.metrics.MeanMetric;  
        AtomicReference<Exception> failureRef = new AtomicReference<>();  
     */
import org.apache.logging.log4j.LogManager;
     */  
    }  
        } else {  
public class IngestPipelineExecutor {
import java.util.concurrent.atomic.AtomicReference;  
    public PollingIngestStats.PipelineStats getMetrics() {  
     */
 * The OpenSearch Contributors require contributions made to  
                "Ingest pipeline attempted to change _id from ["  
     * @param sourceMap source map to transform  
        // verify _id and _routing have not been mutated  
        this.ingestService = Objects.requireNonNull(ingestService);
     * @param finalPipeline the resolved final pipeline name, or null if no pipeline is configured
        indexRequest.id(id);
            if (e != null) {
            failedCount.inc();  
import org.apache.logging.log4j.Logger;
        }
    IngestPipelineExecutor(IngestService ingestService, String index, @Nullable String finalPipeline) {  
                    failureRef.get().addSuppressed(e);
            droppedCount.count()
    }
                    + indexRequest.id()  
            throw new IllegalStateException(
            droppedCount.inc();
        return indexRequest.sourceAsMap();  
        if (IngestService.NOOP_PIPELINE_NAME.equals(finalPipeline)) {
            executionTime.count(),
    }
 * Also registers a dynamic settings listener to pick up runtime changes to {@code final_pipeline}.
import org.opensearch.index.IndexSettings;
 * Only {@code final_pipeline} is supported.
    private final IngestService ingestService;  
    public Map<String, Object> executePipelines(String id, Map<String, Object> sourceMap) throws Exception {
        }
     * @param index the index name  
        ingestService.executeBulkRequestSync(1, Collections.singletonList(indexRequest), (slot, e) -> failureRef.set(e), (thread, e) -> {
        indexSettings.getScopedSettings().addSettingsUpdateConsumer(IndexSettings.FINAL_PIPELINE, this::updateFinalPipeline);  
     *  
        return new PollingIngestStats.PipelineStats(
        if (dropped.get()) {
 * synchronously on the calling thread via {@link IngestService#executeBulkRequestSync}.  
import java.util.Objects;  
        // Execute pipeline synchronously on the calling thread — no thread pool dispatch  
     * @param ingestService the ingest service for pipeline execution
     *
    /**
        indexRequest.setFinalPipeline(finalPipeline);  
    public IngestPipelineExecutor(IngestService ingestService, String index, IndexSettings indexSettings) {
        IndexRequest indexRequest = new IndexRequest(index);
                    + "] to ["
        updateFinalPipeline(IndexSettings.FINAL_PIPELINE.get(indexSettings.getSettings()));
        this.resolvedFinalPipeline = finalPipeline;  
            failedCount.count(),
     * @param id document ID
        final String finalPipeline = resolvedFinalPipeline;
        Objects.requireNonNull(indexSettings);
    /**  
        if (Objects.equals(originalId, indexRequest.id()) == false) {
 *  
     *
        indexRequest.source(sourceMap);  
import org.opensearch.action.index.IndexRequest;  
     * @param index the index name
package org.opensearch.indices.pollingingest;
    private final String index;
    void updateFinalPipeline(String finalPipeline) {  
            );
     * bypassing resolution from index settings.  
        // _index change is already blocked by final_pipeline semantics in IngestService
        }
     * @param indexSettings the index settings to resolve a pipeline from and register listener on  
