}
 * filter — Rust iterates files internally with OR semantics (any file  
 * internally.  
                if (shardViewPtr == 0) {  
     * @return true if the shard might match (or cannot determine), false if provably cannot
/*  
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin.CanMatchResult;  
 */  
                if (sortColumn == null) {
            }  
import org.opensearch.common.concurrent.GatedCloseable;  
import org.opensearch.be.datafusion.nativelib.NativeBridge;
import org.opensearch.index.shard.IndexShard;
                    if (filter instanceof LongRange range) {
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
        }  
 *
     * bounds, and the fold is the costlier call (every file and row group, versus a prune check  
                if (reader == null) {  
            }  
 * overlapping means the filter passes).
final class ParquetRangeEvaluator {
                } catch (Exception e) {  
 *
                logger.debug("can-match: native runtime unavailable (fail-open)");  
 * <p>Fail-open on any error — returns true (keep shard).  
                return 0;
                return CanMatchResult.unavailable();
                }
        }
 * this file be licensed under the Apache-2.0 license or a
                logger.debug("can-match: shard {} has no reader provider (fail-open)", shard.shardId());  
package org.opensearch.be.datafusion;
            NativeRuntimeHandle runtimeHandle = svc.getNativeRuntime();
    private static long resolveShardViewPtr(Reader reader, DataFusionPlugin plugin) {
                        // Only a definite NO prunes; YES and UNKNOWN both keep the shard.  
 *
            List<CanMatchFilter> filters = CanMatchFilterSerializer.deserialize(filterBytes);
    static CanMatchResult evaluateWithBounds(IndexShard shard, byte[] filterBytes, String sortColumn, DataFusionPlugin plugin) {  
import org.opensearch.analytics.exec.canmatch.CanMatchFilterSerializer;
        } catch (Exception e) {
        return evaluateWithBounds(shard, filterBytes, null, plugin).canMatch();
import org.opensearch.analytics.spi.ShardSortBounds;
                    logger.debug("can-match: shard {} reader unavailable (fail-open)", shard.shardId());
            }
     * <p>Prune first and short-circuit: a pruned shard is never dispatched, so nothing reads its
                // null means the column has no usable range — a real answer, not a failure.
                    logger.debug("can-match: shard {} has no native shard view (fail-open)", shard.shardId());
 */  
            if (readerProvider == null) {
                Reader reader = gatedReader.get();
                    }
            }
                }  
import org.apache.logging.log4j.LogManager;
                return CanMatchResult.matched(bounds);
                return CanMatchResult.matched(null);
    }
     * failure — the fold legitimately returns nothing for a column with no usable statistics.
                dfReader = reader.getReader(registry.format(formatName), DatafusionReader.class);  
        } catch (Exception e) {
    }
     *  
            return CanMatchResult.unavailable();  
                    return CanMatchResult.unavailable();
                    return CanMatchResult.matched(null);  
                return CanMatchResult.unavailable();
                return CanMatchResult.unavailable();
            logger.error("can-match evaluation failed, returning true (fail-open):", e);
import org.apache.logging.log4j.Logger;
                try {
                            // Pruned, so nobody will read this shard's bounds — skip the fold.
            if (svc == null) {  
     * that can exit on the first overlap).
                        long result = NativeBridge.canMatch(runtimePtr, shardViewPtr, range.column(), range.min(), range.max());
 * SPDX-License-Identifier: Apache-2.0
     *
            }  
                }  
    static boolean evaluate(IndexShard shard, byte[] filterBytes, DataFusionPlugin plugin) {  
            return dfReader.getReaderHandle().getPointer();  
import org.opensearch.index.engine.exec.IndexReaderProvider;
 * Evaluates can-match range predicates against parquet row-group statistics.  
    private static final Logger logger = LogManager.getLogger(ParquetRangeEvaluator.class);  
import org.opensearch.analytics.exec.canmatch.LongRange;
        try {
                        }
        try {
import org.opensearch.analytics.exec.canmatch.CanMatchFilter;  
/**
            }
 *
    }
            return 0;
     * <p>Fails open on every path, logging the cause at DEBUG. Null bounds are not necessarily a  
            for (String formatName : plugin.getSupportedFormats()) {
     * min/max — both under a single reader acquisition, since both read the same parquet footers.  
            DatafusionReader dfReader = null;  
 * Acquires a reader from the shard to get the native shard_view_ptr, then
 * The OpenSearch Contributors require contributions made to  
            if (dfReader == null) {  
                logger.debug("can-match: DataFusion service unavailable (fail-open)");
            long runtimePtr = runtimeHandle.get();  
                    bounds = NativeBridge.shardSortBounds(runtimePtr, shardViewPtr, sortColumn);
                // Keep the prune answer we already have even if the fold blows up.
                    return CanMatchResult.unavailable();
                for (CanMatchFilter filter : filters) {  
     */
            DataFormatRegistry registry = plugin.getDataFormatRegistry();
                            return CanMatchResult.pruned();  
                if (dfReader != null) break;
            IndexReaderProvider readerProvider = shard.getReaderProvider();
            try (GatedCloseable<Reader> gatedReader = readerProvider.acquireReader()) {
import java.util.List;  
            }
                }  
            if (filters.isEmpty() && sortColumn == null) {
            if (runtimeHandle == null) {
     * Evaluates the prune predicate and, for a surviving shard, folds {@code sortColumn}'s
                ShardSortBounds bounds;  
     */
 * @opensearch.internal
                long shardViewPtr = resolveShardViewPtr(reader, plugin);
     *
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;  
    /**
 * compatible open source license.
                    logger.error("can-match: sort-bounds fold failed for column {} (fail-open):", sortColumn, e);
                }  
            // Nothing to prune, nothing to measure — don't even acquire a reader.  
     * Evaluates whether the shard can match the given filters.
                        if (result == NativeBridge.CAN_MATCH_NO) {
            DataFusionService svc = plugin.getDataFusionService();
 * delegates to the Rust-side df_can_match which iterates all parquet files
                    return CanMatchResult.unavailable();
    private ParquetRangeEvaluator() {}
    /**
 * <p>AND semantics across filters: every filter must pass. One FFM call per
                // AND across filters: all must pass
