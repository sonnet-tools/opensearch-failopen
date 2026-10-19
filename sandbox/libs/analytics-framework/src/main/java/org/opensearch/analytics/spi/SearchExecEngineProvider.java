 */
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.analytics.backend.EngineResultStream;
     * The backendContext carries backend-specific state produced by instruction handlers.
package org.opensearch.analytics.spi;
}
    );  
 * compatible open source license.
    /**
public interface SearchExecEngineProvider {
    SearchExecEngine<ShardScanExecutionContext, EngineResultStream> createSearchExecEngine(  
 *
     * The context carries the reader snapshot and task metadata.  
 * SPDX-License-Identifier: Apache-2.0
     * Creates a search execution engine bound to the given execution context.
 * Creates a {@link SearchExecEngine} bound to a given execution context for the analytics query path.
 * Execution engine factory for backend plugins.  
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal  
        ShardScanExecutionContext ctx,
/*  
/**
        BackendExecutionContext backendContext
import org.opensearch.analytics.backend.ShardScanExecutionContext;  
import org.opensearch.analytics.backend.SearchExecEngine;
 *
 */  
     */
