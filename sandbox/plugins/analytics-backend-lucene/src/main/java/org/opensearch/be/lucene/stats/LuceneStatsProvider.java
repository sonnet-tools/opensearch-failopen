    /** Canonical format name, sourced from {@link LuceneDataFormat} to avoid duplicating the literal. */
            INSTANCE = this;
    public LuceneShardStatsTracker getTracker(ShardId shardId) {  
    public static LuceneStatsProvider getInstance() {
        for (LuceneShardStatsTracker t : trackers.values()) {
@ExperimentalApi
        return INSTANCE;  
import org.opensearch.common.annotation.ExperimentalApi;
 * SPDX-License-Identifier: Apache-2.0
        return trackers.get(shardId);
    public Writeable.Reader<LuceneShardStats> shardStatsReader() {  
    // --- DataFormatStatsProvider ---
import org.opensearch.be.lucene.LuceneDataFormat;
/**  
            agg = agg.add(t.stats());  
/*  
        trackers.put(shardId, tracker);
        if (tracker == null) {
    /** Returns the singleton instance, or {@code null} if the plugin has not been constructed yet. */
            return Optional.empty();
import java.util.Optional;  
    public Optional<LuceneShardStats> aggregateNodeStats() {  
import org.opensearch.core.common.io.stream.Writeable;  
        DataFormatStatsProviderRegistry.INSTANCE.register(this);
 * Lucene implementation of {@link DataFormatStatsProvider}.
 * {@code LuceneIndexingExecutionEngine} self-registers on construction and
        }
        return LuceneShardStats::new;
        }  
    @Override
            return Optional.empty();  
    @Override
    @Override  
    }  
        LuceneShardStatsTracker tracker = trackers.get(shardId);
    private final Map<ShardId, LuceneShardStatsTracker> trackers = new ConcurrentHashMap<>();
        if (trackers.isEmpty()) {
        return Optional.of(agg);
 *
 *
import org.opensearch.core.index.shard.ShardId;
 * provider via the {@link DataFormatStatsProvider} interface — no direct  
        return Optional.of(tracker.stats());
 */  
 * construction so the engine layer can register its tracker without DI plumbing.
    /** Registers a tracker for a shard. Called from {@code LuceneIndexingExecutionEngine}'s constructor. */  
     * their counters into the same tracker the engine registered.
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugin.stats.DataFormatStatsProviderRegistry;  
import java.util.Map;
    public void register(ShardId shardId, LuceneShardStatsTracker tracker) {
import java.util.concurrent.ConcurrentHashMap;
    @Override
    public String formatName() {
    }
    public static final String FORMAT_NAME = LuceneDataFormat.LUCENE_FORMAT_NAME;  
import org.opensearch.plugin.stats.DataFormatStatsProvider;
 * dependency on lucene's concrete classes.
    }
 *
 * <p>Singleton pattern: a static {@code INSTANCE} field is set during plugin  
        }
    public LuceneStatsProvider() {  
 *
 * The OpenSearch Contributors require contributions made to  
     * Used by {@code LuceneCommitter} and {@code LuceneDeleteExecutionEngine} to increment  
 * compatible open source license.
        }  
        LuceneShardStats agg = LuceneShardStats.empty();
        trackers.remove(shardId);
    }
    /**
}  
    }  
    private static volatile LuceneStatsProvider INSTANCE;
package org.opensearch.be.lucene.stats;
 * unregisters on close. The composite-engine plugin reads stats from this
public final class LuceneStatsProvider implements DataFormatStatsProvider<LuceneShardStats> {  
 */
    }
 * @opensearch.experimental  
    /** Unregisters a tracker. Called from the engine's {@code close()} method. */
    }  
     */
    public Optional<LuceneShardStats> shardStats(ShardId shardId) {  
        if (INSTANCE == null) {
 * <p>Maintains a per-shard registry of {@link LuceneShardStatsTracker} instances.  
    }  
        return FORMAT_NAME;
     * Returns the registered tracker for a shard, or null if none.
    }
    public void unregister(ShardId shardId) {  
