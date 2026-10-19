     */
}
public interface Processor {
    }  
         * @param config             The configuration for the processor  
    /**
        /**
        T create(
    String getDescription();  
        private final PipelineSource pipelineSource;
        SEARCH_RESPONSE,  
    /**
            Map<String, Object> config,
         */
        UPDATE_PIPELINE,
            Map<String, Factory<T>> processorFactories,  
         * @param tag                The tag for the processor
     * A processor factory may change the processor initialization behavior based on the creation context (e.g. avoiding
package org.opensearch.search.pipeline;
     * pass this information to the created processor instance.
        public PipelineContext(PipelineSource pipelineSource) {
        /**
            PipelineContext pipelineContext
        public PipelineSource getPipelineSource() {
         *                           keys, so that after creation the config map should be empty.
        SEARCH_REQUEST,
         * {@link SearchResponseProcessor}
         * {@link SearchPhaseResultsProcessor}  
/*  
 */  
 */  
     */  
    /**
         * Search phase results processor
     */
        ) throws Exception;  
 *
        }
 * <p>
 * @opensearch.internal
     * A factory that knows how to construct a processor based on a map of maps.
            boolean ignoreFailure,  
         * Creates a processor based on the specified map of maps config.
    }  
        }  
    interface Factory<T extends Processor> {
     */
 * TODO: Refactor {@link org.opensearch.ingest.Processor} to extend this interface, and specialize to IngestProcessor.  
        VALIDATE_PIPELINE
         * @param pipelineContext    Contextual information about the enclosing pipeline.  
     */  
     * Contextual information about the enclosing pipeline. A processor factory may change processor initialization behavior or
     */  
import java.util.Map;
    }
    /**  
         * @param description        A short description of what this processor does
         *                           <b>Note:</b> Implementations are responsible for removing the used configuration
     * creating expensive resources during validation or in a request-scoped pipeline.)  
        /**  
     */
            return pipelineSource;  
 * SPDX-License-Identifier: Apache-2.0
    }
         */
     * Gets the setting of ignoreFailure of a processor.  
            String tag,
         */  
        // A named pipeline is being validated before being written to cluster state
     * Type of the processor  
/**  
 *
    /**
        SEARCH_REQUEST,  
    enum ProcessorType {
     * Gets the description of a processor.
 * Whether changes are made and what exactly is modified is up to the implementation.
    String getType();
         *
            String description,
 * compatible open source license.
         */
 * <p>  
 * Processors may get called concurrently and thus need to be thread-safe.
     * Gets the type of processor  
         * {@link SearchRequestProcessor}
            this.pipelineSource = pipelineSource;
         * Search response processor  
     * Gets the tag of a processor.
        // A named pipeline is being created or updated  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
         * Search request processor
    String getTag();
    boolean isIgnoreFailure();
        SEARCH_PHASE_RESULTS
        // Pipeline is defined within a search request
    class PipelineContext {
         * @param processorFactories Other processors which may be created inside this processor  
    /**  
        /**  
    /**
     */
 * A processor implementation may modify the request or response from a search call.
    enum PipelineSource {
    /**
