     * Must be safe to call concurrently with {@link #feed} and {@link #close}.
 * immediately rather than waiting for it to drain to completion naturally.  
     * unblock promptly.
    void cancel();  
 *
/**
package org.opensearch.analytics.spi;
    /**  
/*  
     */
public interface CancellableExchangeSink extends ExchangeSink {
 * is cancelled or fails, the stage executor calls {@link #cancel()} before
 */  
 */  
 * compatible open source license.
     * Signals immediate cancellation of any in-flight native execution.
 * SPDX-License-Identifier: Apache-2.0
}
 *
 * this file be licensed under the Apache-2.0 license or a
     * Must be idempotent. After this returns, any blocking drain should  
 * The OpenSearch Contributors require contributions made to  
 * Optional extension of {@link ExchangeSink} for sinks that support immediate
 * @opensearch.internal
 * cancellation of in-flight native execution. When a coordinator-reduce stage  
 * {@link ExchangeSink#close()} so the sink can abort the running computation
