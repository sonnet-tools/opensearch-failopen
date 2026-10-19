     * @param lgSample log2 of sample interval in bytes (15=32KB, 17=128KB, 19=512KB)
 * <p>  
     */
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
     * @param path absolute path for the dump file
/*  
 * MBean interface for native heap profiling operations.
     * Reset profiling state and change sample interval.
    /** Deactivate jemalloc heap profiling. Zero overhead after this call. */  
/**
    /** Activate jemalloc heap profiling. Allocations will be sampled from this point. */  
    void deactivate();
    /**  
 * Exposed via JMX at {@code org.opensearch.native:type=HeapProfiler}.
 */  
    /**
    void activate();
 * compatible open source license.
 */  
    /** Returns true if profiling is currently active. */
    boolean isActive();  
    String dump(String path);
 *
    void reset(int lgSample);  
public interface NativeHeapProfilerMBean {
     * @return the path where the dump was written  
}
package org.opensearch.nativebridge.spi;
 * The CLI tool {@code bin/opensearch-heap-prof} invokes these methods via JMX Attach API.
 * The OpenSearch Contributors require contributions made to  
     */
     * WARNING: discards all accumulated profiling data.  
     * Dump a heap profile to the specified file path.
