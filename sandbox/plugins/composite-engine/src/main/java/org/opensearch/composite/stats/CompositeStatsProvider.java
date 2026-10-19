import org.opensearch.plugin.stats.DataFormatStatsProvider;
}  
    public CompositeShardStatsTracker getTracker(ShardId shardId) {  
    }  
            INSTANCE = this;  
    private static volatile CompositeStatsProvider INSTANCE;
 *  
    public Optional<CompositeShardStats> aggregateNodeStats() {  
        trackers.remove(shardId);
@ExperimentalApi  
    }  
import org.opensearch.core.common.io.stream.Writeable;  
 * @opensearch.experimental
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.index.shard.ShardId;
 */
        }
        return FORMAT_NAME;
 * SPDX-License-Identifier: Apache-2.0
    // --- DataFormatStatsProvider ---
    }
    public void unregister(ShardId shardId) {
        }
 * this file be licensed under the Apache-2.0 license or a
        CompositeShardStats agg = CompositeShardStats.empty();
    /** Returns the singleton, or {@code null} if the plugin has not been constructed yet. */
import org.opensearch.composite.CompositeDataFormat;
    public static CompositeStatsProvider getInstance() {  
import org.opensearch.common.annotation.ExperimentalApi;
        DataFormatStatsProviderRegistry.INSTANCE.register(this);
        return trackers.get(shardId);
    /** Returns the tracker for a shard, or {@code null} if none — used by writer/merger to count. */
            return Optional.empty();
 * {@code CompositeIndexingExecutionEngine} self-registers on construction and unregisters
    private final Map<ShardId, CompositeShardStatsTracker> trackers = new ConcurrentHashMap<>();
        }  
/**  
    public CompositeStatsProvider() {  
    public Writeable.Reader<CompositeShardStats> shardStatsReader() {  
    public static final String FORMAT_NAME = CompositeDataFormat.COMPOSITE_FORMAT_NAME;  
            agg = agg.add(t.stats());  
 * on close. The plugin's REST + transport classes read stats from this provider.
    /** Registers a tracker for a shard. Called from the composite engine's constructor. */
    @Override
    }
    }  
import java.util.concurrent.ConcurrentHashMap;
import java.util.Optional;  
    }  
    @Override
        return INSTANCE;
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;  
 *
 * <p>Maintains a per-shard registry of {@link CompositeShardStatsTracker} instances.  
 *
    public String formatName() {
/*  
import java.util.Map;
 *  
        // First instance wins. Subsequent constructions are no-ops on the singleton slot.
public final class CompositeStatsProvider implements DataFormatStatsProvider<CompositeShardStats> {
 * engine/writer/merger layers can reach the tracker without DI plumbing.
        trackers.put(shardId, tracker);  
    public void register(ShardId shardId, CompositeShardStatsTracker tracker) {
        if (trackers.isEmpty()) {
        for (CompositeShardStatsTracker t : trackers.values()) {
 * Composite-engine implementation of {@link DataFormatStatsProvider}.
    public Optional<CompositeShardStats> shardStats(ShardId shardId) {  
    }
    }
        if (INSTANCE == null) {
 * compatible open source license.
        return CompositeShardStats::new;
    }  
 * <p>Singleton pattern: a static {@code INSTANCE} is set during plugin construction so the
        CompositeShardStatsTracker tracker = trackers.get(shardId);
package org.opensearch.composite.stats;
    /** Unregisters a tracker. Called from the engine's {@code close()}. */  
    @Override  
 */  
    @Override
        return tracker == null ? Optional.empty() : Optional.of(tracker.stats());
        return Optional.of(agg);
