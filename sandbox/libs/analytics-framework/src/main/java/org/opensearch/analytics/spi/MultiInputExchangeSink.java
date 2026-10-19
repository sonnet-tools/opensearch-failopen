 * {@link ExchangeSink#close()} has been called.
 * compatible open source license.
     * Returns the sink that the orchestrator should route the named child
 * The orchestrator obtains a wrapper via {@link #sinkForChild(int)} for each  
     * stage's output into. Implementations bind each returned wrapper to a  
}
 * @opensearch.internal  
 * Coordinator-side {@link ExchangeSink} that exposes a per-child sub-sink for
public interface MultiInputExchangeSink extends ExchangeSink {
 * child stage so that each child feeds into its own input partition on the
 * SPDX-License-Identifier: Apache-2.0
/*  
 * <p>Used by multi-input shapes (currently {@code UNION}; future {@code JOIN}).
/**
    /**
     * registered on the backend's native session at sink construction.
 */
     */  
 *
 *
 * still driven by the orchestrator and runs after every child wrapper's  
package org.opensearch.analytics.spi;
     * distinct input partition (typically named {@code "input-<stageId>"})
 */  
 *
    ExchangeSink sinkForChild(int childStageId);
 * each child stage feeding into it.  
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * backend's native session. The parent sink's lifecycle ({@link #close()}) is
