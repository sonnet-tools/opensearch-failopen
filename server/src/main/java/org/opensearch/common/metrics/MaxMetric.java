 * this file be licensed under the Apache-2.0 license or a
 */
    }
    }  
}
 *
/**  
/*  
import java.util.concurrent.atomic.LongAccumulator;
        max.reset();
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.common.metrics;
 * @opensearch.internal  
 *
    private final LongAccumulator max = new LongAccumulator(Long::max, Long.MIN_VALUE);  
        return max.get();
 * SPDX-License-Identifier: Apache-2.0
public class MaxMetric implements Metric {
    public void collect(long value) {
    public long get() {  
 * compatible open source license.
    }
 * A metric for tracking the maximum value seen.
        max.accumulate(value);  
    public void clear() {
 */  
