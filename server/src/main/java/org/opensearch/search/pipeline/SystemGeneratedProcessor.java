 * SPDX-License-Identifier: Apache-2.0
/*  
     */
    interface SystemGeneratedFactory<T extends Processor> extends Factory<T> {
 * compatible open source license.
public interface SystemGeneratedProcessor extends Processor {
     * Factory to systematically generate the search processor.
     * @param <T>  
    enum ExecutionStage {
/**
    }
    default ExecutionStage getExecutionStage() {
     * @param processorConflictEvaluationContext context to evaluate the conflicts
        boolean shouldGenerate(ProcessorGenerationContext context);
 * Interface for a system generated search pipeline processor.
    /**  
package org.opensearch.search.pipeline;
}
         * Before user defined processors  
 */  
     */
 * The OpenSearch Contributors require contributions made to  
 */  
    }
         */  
    /**
         * After user defined processors
     * @throws IllegalArgumentException If there are conflicts.  
    /**
    }
     * Evaluate if this processor conflict with other processors
     */
     * The stage to execute the processor
     * @return when to execute the processor. Default to be executed post user defined processors.  
 * this file be licensed under the Apache-2.0 license or a
        /**
    default void evaluateConflicts(ProcessorConflictEvaluationContext processorConflictEvaluationContext) throws IllegalArgumentException {}
        return ExecutionStage.POST_USER_DEFINED;  
         */
 *
        POST_USER_DEFINED,  
         * @return if we should use the factory to generate the system processor.
    /**
        /**  
     */  
         * @param context context used to evaluate if we should use the factory to generate the system processor.
        PRE_USER_DEFINED,
        /**  
         */
