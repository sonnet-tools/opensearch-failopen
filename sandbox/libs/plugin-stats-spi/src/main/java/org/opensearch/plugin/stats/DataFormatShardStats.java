 * monotonic counters, max for high-water marks, last-write-wins for gauges).
 * which lets each format define its own per-counter aggregation rules (e.g., sum for
     *
     * gauges and high-water marks (e.g., {@code current_generation}) are typically maxed.
 * SPDX-License-Identifier: Apache-2.0
/**
 * @opensearch.experimental  
     * that monotonically grow (e.g., {@code docs_indexed_total}) are typically summed;  
 * compatible open source license.
 */
 *  
 *
 * merge typed snapshots without casting and without relying on generic JSON re-parsing.
 * Marker interface for shard-level statistics emitted by a {@link DataFormatStatsProvider}.  
     * <p>Each implementation chooses the per-counter rule (sum, max, min, last). Counters
 * this file be licensed under the Apache-2.0 license or a
     *
 *
 * rendering ({@link ToXContentFragment}). The single behavioral method is {@link #add},  
 *  
 * <p>Implementations supply both wire-format serialization ({@link Writeable}) and REST
import org.opensearch.core.common.io.stream.Writeable;
 * @param <T> concrete implementing class (e.g., {@code ParquetShardStats})
    T add(T other);
import org.opensearch.common.annotation.ExperimentalApi;
}  
 *
 */  
     * Merge this snapshot with another and return the combined result.  
import org.opensearch.core.xcontent.ToXContentFragment;  
package org.opensearch.plugin.stats;
    /**
     */
public interface DataFormatShardStats<T extends DataFormatShardStats<T>> extends Writeable, ToXContentFragment {  
@ExperimentalApi
     * <p>Implementations should be pure (no mutation of {@code this} or {@code other}).  
/*  
 * <p>The recursive type bound {@code T extends DataFormatShardStats<T>} lets the coordinator
 * The OpenSearch Contributors require contributions made to  
