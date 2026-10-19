public record DataFusionSessionState(SessionContextHandle sessionContextHandle) implements BackendExecutionContext {
package org.opensearch.be.datafusion;
    }  
import org.opensearch.analytics.spi.BackendExecutionContext;
 * The handle's close is idempotent and cooperates with {@link DatafusionContext#close()}
 */  
 * Backend-specific execution context produced by {@link ShardScanInstructionHandler},
            sessionContextHandle.close();
 * compatible open source license.
 * <p>{@link #close()} closes the underlying {@link SessionContextHandle} as the
 * consumed by {@link DatafusionSearcher} at execute time.  
 *
 * fragment-orchestrator's safety net for error paths that never reach the execute step.  
/**
 * this file be licensed under the Apache-2.0 license or a
 *
        if (sessionContextHandle != null) {  
 * (which also closes it once the handle is handed off to an engine), so it is safe to call
 * from both places — whichever runs first wins.  
 */
}
        }
    public void close() {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.be.datafusion.nativelib.SessionContextHandle;
    @Override
 * The OpenSearch Contributors require contributions made to  
/*  
