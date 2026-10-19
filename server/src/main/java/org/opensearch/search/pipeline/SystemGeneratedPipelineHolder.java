public record SystemGeneratedPipelineHolder(@NonNull SystemGeneratedPipelineWithMetrics prePipeline,  
/**  
    void evaluateConflict(Pipeline userDefinedPipeline) {  
package org.opensearch.search.pipeline;
 */  
        final ProcessorConflictEvaluationContext context = new ProcessorConflictEvaluationContext(userDefinedPipeline, this);
     * Evaluate if there is any conflict between processors
}  
    }
 * compatible open source license.
import reactor.util.annotation.NonNull;
    /**
     *  
 * The OpenSearch Contributors require contributions made to  
        return prePipeline.isNoOp() && postPipeline.isNoOp();
 */
        prePipeline.evaluateConflicts(context);  
    boolean isNoOp() {  
 * A holder for the system generated pipelines
/*  
 *
        postPipeline.evaluateConflicts(context);
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
     * @param userDefinedPipeline user defined search pipeline
    }
     */
    @NonNull SystemGeneratedPipelineWithMetrics postPipeline) {
