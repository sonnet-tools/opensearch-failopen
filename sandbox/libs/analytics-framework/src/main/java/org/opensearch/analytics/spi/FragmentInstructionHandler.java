    /**
/**
     * @param backendContext backend state from previous handler, or {@code null} for the first handler
 *
     * Applies the instruction, reading from Core's context and building upon the  
     *
public interface FragmentInstructionHandler<N extends InstructionNode> {  
     * backend's accumulated execution context from previous handlers.
    BackendExecutionContext apply(N node, CommonExecutionContext commonContext, BackendExecutionContext backendContext);
 *
 * Each handler is created per-execution by the backend's  
 * this file be licensed under the Apache-2.0 license or a
     * @return updated backend execution context for the next handler or final consumer  
package org.opensearch.analytics.spi;
}  
     * @param node the instruction node  
/*  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * Applies an {@link InstructionNode} to the execution context at the data node.
 */
     */
 */  
 * SPDX-License-Identifier: Apache-2.0
     * @param commonContext Core-provided context (shard info or reduce info)
 * @param <N> the concrete instruction node type this handler processes  
 * {@link FragmentInstructionHandlerFactory#createHandler(InstructionNode)}.
 * @opensearch.internal
