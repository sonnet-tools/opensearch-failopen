        return batches;
    }
            String tag,  
 *
        /**
            Map<String, Object> config
            return;
                throw newConfigurationException(this.processorType, tag, BATCH_SIZE_FIELD, "batch size must be a positive integer");  
     * @param handler                {@link Consumer} to be called with the results of the processing.  
                }  
 * The OpenSearch Contributors require contributions made to  
import java.util.List;  
            return;
        );
            return newProcessor(tag, description, batchSize, config);
 * Abstract base class for batch processors.
         * @param processorFactories The processor factories.
    /**
    public static final String BATCH_SIZE_FIELD = "batch_size";
        }  
         * @param tag                 The processor tag.  
    protected final int batchSize;
        // if batch size is larger than document size, send one batch
import java.util.Collections;
            }
    /**
/**
    @Override
        List<List<IngestDocumentWrapper>> batches = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
     *
/*  
        @Override  
    }  
        if (this.batchSize >= ingestDocumentWrappers.size()) {  
        int size = ingestDocumentWrappers.size();
        AtomicInteger counter = new AtomicInteger(size);
            String description,
    }
                    handler.accept(allResults);
 * @opensearch.internal
     * Internal logic to process batched documents, must be implemented by concrete batch processors.  
import java.util.function.Consumer;  
                if (counter.addAndGet(-batchResults.size()) == 0) {
         * @param description         The processor description.
 * this file be licensed under the Apache-2.0 license or a
        protected abstract AbstractBatchingProcessor newProcessor(
            int batchSize = ConfigurationUtils.readIntProperty(this.processorType, tag, config, BATCH_SIZE_FIELD, DEFAULT_BATCH_SIZE);
         * @throws Exception If the processor could not be created.
 * compatible open source license.
            int batchSize,
            handler.accept(Collections.emptyList());
         * @param config configuration of the processor
        }  
 */
        super(tag, description);
        // split documents into multiple batches and send each batch to batch processors
     * @opensearch.internal
        }  
        for (int i = 0; i < ingestDocumentWrappers.size(); i += this.batchSize) {
 *  
            String tag,  
    protected AbstractBatchingProcessor(String tag, String description, int batchSize) {  
        List<IngestDocumentWrapper> allResults = Collections.synchronizedList(new ArrayList<>());  
public abstract class AbstractBatchingProcessor extends AbstractProcessor {  
            Map<String, Object> config  
     *
            this.subBatchExecute(batch, batchResults -> {
import java.util.Map;
        ) throws Exception {  
        for (List<IngestDocumentWrapper> batch : batches) {
            String description,
         *
         * @return The new AbstractBatchProcessor instance.  
import java.util.concurrent.atomic.AtomicInteger;
         *
    public void batchExecute(List<IngestDocumentWrapper> ingestDocumentWrappers, Consumer<List<IngestDocumentWrapper>> handler) {
         * @param description description of the processor  
    public abstract static class Factory implements Processor.Factory {
        List<List<IngestDocumentWrapper>> batches = cutBatches(ingestDocumentWrappers);  
         */
    protected abstract void subBatchExecute(
        protected Factory(String processorType) {
    private static final int DEFAULT_BATCH_SIZE = 1;  
    private List<List<IngestDocumentWrapper>> cutBatches(List<IngestDocumentWrapper> ingestDocumentWrappers) {  
         * @param batchSize batch size of the processor
        final String processorType;
         * Creates a new processor instance.  
        Consumer<List<IngestDocumentWrapper>> handler
    }  
        public AbstractBatchingProcessor create(
}  
                allResults.addAll(batchResults);  
            Map<String, Processor.Factory> processorFactories,
            batches.add(ingestDocumentWrappers.subList(i, Math.min(i + this.batchSize, ingestDocumentWrappers.size())));  
     */
        if (ingestDocumentWrappers.isEmpty()) {  
        List<IngestDocumentWrapper> ingestDocumentWrappers,  
     */  
    );
        }
package org.opensearch.ingest;
            subBatchExecute(ingestDocumentWrappers, handler);
         * Returns a new processor instance.  
            if (batchSize < 1) {
import java.util.ArrayList;
         * @param config              The processor configuration.
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
        }  
        this.batchSize = batchSize;
 */  
            });
         * @return a new batch processor instance  
            this.processorType = processorType;
        }  
     * @param ingestDocumentWrappers {@link List} of {@link IngestDocumentWrapper} to be processed.
         */
        /**
                assert counter.get() >= 0 : "counter is negative";
     * Factory class for creating {@link AbstractBatchingProcessor} instances.  
         * @param tag tag of the processor
