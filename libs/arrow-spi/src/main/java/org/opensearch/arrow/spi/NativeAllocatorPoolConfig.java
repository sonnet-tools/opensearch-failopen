    public static final String POOL_QUERY = "query";  
    /** Setting key for the ingest pool minimum. */  
public final class NativeAllocatorPoolConfig {
    public static final String POOL_INGEST = "ingest";
    private NativeAllocatorPoolConfig() {}  
 * The setting keys follow the pattern  
package org.opensearch.arrow.spi;
/*  
 * this file be licensed under the Apache-2.0 license or a
 *
    /** Setting key for the ingest pool maximum. */
    public static final String SETTING_QUERY_MAX = "native.allocator.pool.query.max";
    public static final String SETTING_FLIGHT_MIN = "native.allocator.pool.flight.min";  
 *
 * compatible open source license.
 */
 *
    public static final String SETTING_QUERY_MIN = "native.allocator.pool.query.min";
 * @opensearch.api  
 * <p>Each pool has a min (guaranteed reservation) and max (burst limit).
    /** Pool name for ingest pipeline memory. */  
 * <p>Limits are provided via {@code opensearch.yml} or the cluster settings API.
}
 * The rebalancer ensures every pool can always allocate up to its min,
 */  
    public static final String SETTING_INGEST_MAX = "native.allocator.pool.ingest.max";  
    /** Setting key for the Flight pool maximum. */
    /** Setting key for the Flight pool minimum. */
 * SPDX-License-Identifier: Apache-2.0
 *  
    public static final String POOL_FLIGHT = "flight";
    /** Pool name for query-execution memory (analytics-engine fragments and per-query allocators). */
 * without referencing any Arrow classes.
 * <p>This class is Arrow-agnostic — it defines the logical pool topology  
    public static final String SETTING_INGEST_MIN = "native.allocator.pool.ingest.min";
 * {@code native.allocator.pool.<name>.min} and {@code native.allocator.pool.<name>.max}.
 *
/**
    public static final String SETTING_FLIGHT_MAX = "native.allocator.pool.flight.max";
    /** Pool name for Arrow Flight RPC memory. */
 * The OpenSearch Contributors require contributions made to  
    /** Setting key for the query pool minimum. */
 * Pool name constants and setting keys for native allocator pools.
    /** Setting key for the query pool maximum. */  
 * and distributes unused capacity up to each pool's max.  
