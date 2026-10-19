     */
    /**
     */
     * {@code listener} on completion. Single-shot. Must not release resources — that's  
}  
 * {@link ExchangeSink} that runs reduce work (execute plan, drain into downstream).
/**  
     * Returns execution metrics JSON captured after reduce completes, or null if not available.  
    void reduce(ActionListener<Void> listener);  
     * Execute the reduce plan and drain output into the configured downstream; fire
        return null;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.action.ActionListener;
     */
    }
package org.opensearch.analytics.spi;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
 * separately on every terminal transition for resource cleanup — split so cancel-before-reduce  
    }
 * paths can release resources without re-running the work.
 *
 * @opensearch.experimental  
     * {@code true} (default) — {@link #reduce} can run concurrently with producer
/*  
 * this file be licensed under the Apache-2.0 license or a
    /**
 * The reduce-stage execution invokes {@link #reduce} from its task; {@link #close} runs
     * {@link #close()}'s job.
     * {@link #feed} calls. Buffered sinks that need the complete input set first  
    /**
public interface ReducingExchangeSink extends ExchangeSink {
 *
 */  
     * Backends that support profiling populate this after {@link #reduce} drains.
    default boolean supportsEagerScheduling() {  
 */
    default byte[] getExecutionMetrics() {  
     * (e.g. memtable-backed) must override to {@code false}.
        return true;
