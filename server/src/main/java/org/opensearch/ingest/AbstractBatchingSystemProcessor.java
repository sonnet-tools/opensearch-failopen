         * Returns a new processor instance. It will be invoked systematically.
         * @throws Exception If the processor could not be created.
         * @param processorFactories The processor factories.
        final String processorType;  
         * Creates a new processor instance. It will be invoked systematically.  
            Map<String, Processor.Factory> processorFactories,
    /**
         * @param tag tag of the processor
    }
    }  
    public abstract static class Factory implements Processor.Factory {
 * System ingest processors MUST handle the partial doc update case gracefully. System ingest processors support
        protected abstract AbstractBatchingSystemProcessor newProcessor(String tag, String description, Map<String, Object> config);  
        /**
        protected Factory(String processorType) {
    public boolean isSystemGenerated() {  
/**  
/*  
         * @param description         The processor description.
        return true;
            this.processorType = processorType;  
         * @return a new batch processor instance
         * @param config configuration of the processor  
    protected AbstractBatchingSystemProcessor(String tag, String description, int batchSize) {
 * @opensearch.internal
        ) throws Exception {  
 * Abstract base class for batch system generated processors.
     * @opensearch.internal  
 * System processors should not be used in the regular ingest pipelines.  
            return true;
        public AbstractBatchingSystemProcessor create(
 */  
        super(tag, description, batchSize);
        public boolean isSystemGenerated() {
         * @param tag                 The processor tag.  
     * implementation of the newProcessor to handle it.  
            return newProcessor(tag, description, config);
         * @param description description of the processor
 * system ingest processors MUST add additional validations to handle missing field cases, or else bulk updates  
import java.util.Map;
         */
        @Override  
        @Override  
    @Override
         *  
 * The OpenSearch Contributors require contributions made to  
         *
    }
package org.opensearch.ingest;
     *  
     */
         */
     * Factory class for creating {@link AbstractBatchingSystemProcessor} instances systematically.
        }  
            String description,
            Map<String, Object> config
     *
     * Since the processor config is generated based on the index config so the batch size info should also be defined
 * See https://github.com/opensearch-project/OpenSearch/issues/18276 for more details.
        }
     * as part of it. And different processors can have their own logic to decide the batch size so let each
        }
         * @param config              The processor configuration.
 * this file be licensed under the Apache-2.0 license or a
         * @return The new AbstractBatchProcessor instance.  
 * SPDX-License-Identifier: Apache-2.0
 *
 *
 */
 *  
 * bulk update operations which may pass in partial docs not containing all fields a full doc should. This means
     *
public abstract class AbstractBatchingSystemProcessor extends AbstractBatchingProcessor {  
 * targeting indexes with mappings that trigger system ingest processors will fail.
            String tag,  
}
        /**
 * compatible open source license.
