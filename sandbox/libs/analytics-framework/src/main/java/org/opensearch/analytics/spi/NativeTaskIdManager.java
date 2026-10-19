 * context MUST key it with {@link #next()} and route cancellation through the
    }  
 * clusters) therefore collide when task ids are used directly: one node's
 * The OpenSearch Contributors require contributions made to  
 */  
 * <p>The native engine keeps one process-wide registry keyed by context id, but  
 * cancellation reaches another node's live query. Callers registering a native  
 *  
 *
/*  
 * SPDX-License-Identifier: Apache-2.0
 * Manages JVM-unique native task ids, analogous to how TaskManager mints per-node task ids.
    private NativeTaskIdManager() {}
}
 */
 * @opensearch.internal
 * {@code Task} ids are only unique per node. Nodes sharing a JVM (internal test
 * compatible open source license.
/**  
    public static long next() {
public final class NativeTaskIdManager {  
        return COUNTER.incrementAndGet();
 *
 * same minted id; {@code 0} remains the "tracking disabled" sentinel.
    private static final AtomicLong COUNTER = new AtomicLong();
import java.util.concurrent.atomic.AtomicLong;
package org.opensearch.analytics.spi;
 * this file be licensed under the Apache-2.0 license or a
    /** Returns the next JVM-unique, non-zero context id. */  
