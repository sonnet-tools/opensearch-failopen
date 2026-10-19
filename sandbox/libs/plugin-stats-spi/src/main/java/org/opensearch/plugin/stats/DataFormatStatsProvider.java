     * the cluster.
/*  
 */  
import java.util.Optional;
 * </ol>
 * <ul>
    String formatName();
    /**
     * <p>Called on each target node by the per-node transport.  
 * <p>Each plugin owns its endpoints — the plugin registers REST handlers and transport  
 * The OpenSearch Contributors require contributions made to  
     * Must be unique across all data format plugins loaded.
 * @param <T> concrete shard-stats type (e.g., {@code ParquetShardStats})
import org.opensearch.core.common.io.stream.Writeable;
 *  
 *       {@code ActionPlugin.getActions()} / {@code getRestHandlers()}</li>
     */
 * @opensearch.experimental  
public interface DataFormatStatsProvider<T extends DataFormatShardStats<T>> {  
import org.opensearch.common.annotation.ExperimentalApi;
    Optional<T> aggregateNodeStats();
import org.opensearch.core.index.shard.ShardId;  
 * SPDX-License-Identifier: Apache-2.0
 * has no role in stats endpoint registration.
    /**
    Writeable.Reader<T> shardStatsReader();  
     * Returns aggregate stats summed across all shards of this format on the  
 * </ul>
     */
 *
 *  
     *
 *       {@code createGuiceModules()} so the registry is populated</li>
@ExperimentalApi
     *  
     * Reader for deserializing wire-encoded stats from another node. Used by
package org.opensearch.plugin.stats;
     * local node, or empty if no shards of this format are present on this node.
     * <p>Called on the data node that hosts the shard, by the per-index transport.
 *   <li>{@code GET /_plugins/{formatName}/{index}/_stats}</li>
     * Returns shard-level stats for the given shard, or empty if this format
 */
     * has no engine for that shard (e.g., the format is not configured on the index).
 * compatible open source license.
 * <ol>
 * SPI implemented by each data-format plugin to expose its stats via the per-format
     */
 *   <li>{@code GET /_plugins/{formatName}/_nodes/[{nodeId}/]_stats}</li>  
     * (e.g., {@code "parquet"} maps to {@code /_plugins/parquet/...}).
 *   <li>Subclass the SPI's transport bases and register them via  
 *
    /**  
     * the transport to reconstruct {@link DataFormatShardStats} sent across  
    /**
/**
 * <p>Adding a new data format:
}
 * REST endpoints:  
 *   <li>Register it via {@code new MyStatsProvider()} in the plugin's
    Optional<T> shardStats(ShardId shardId);  
     */  
 * actions itself in its {@code getRestHandlers()} / {@code getActions()}. Composite-engine
     * Identifier for this data format. Used as the URL path component  
 *   <li>Implement this interface in the new format's plugin</li>  
 *
 * this file be licensed under the Apache-2.0 license or a
