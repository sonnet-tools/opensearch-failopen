import java.io.IOException;
        return spillStats;  
     */  
        PartitionGateStats fragmentExecutorGateStats,  
    }
 * No inner classes — {@code RuntimeMetrics} and {@code TaskMonitorStats} belong  
        DataFusionStats that = (DataFusionStats) o;  
    @Override  
public class DataFusionStats implements Writeable, ToXContentFragment {  
    /**
import java.util.Objects;
 *  
 * SPDX-License-Identifier: Apache-2.0
        if (nativeExecutorsStats != null) {
        CacheStats cacheStats,  
        AdaptiveBudgetStats adaptiveBudget,
        this.fragmentExecutorGateStats = in.readOptionalWriteable(PartitionGateStats::new);
            spillStats.toXContent(builder, params);  
     * Deserialize from stream.  
    ) {
     * @param in the stream input
/*  
}
import org.opensearch.core.xcontent.ToXContentFragment;
 * this file be licensed under the Apache-2.0 license or a
     * @param nativeExecutorsStats       the native executor metrics (nullable)  
            fragmentExecutorGateStats.toXContent(builder, params);  
        this.cacheStats = in.readOptionalWriteable(CacheStats::new);
 * for JSON rendering.
            && Objects.equals(searchStats, that.searchStats);  
    }  
 */
        this.nativeExecutorsStats = nativeExecutorsStats;  
     */
            && Objects.equals(fragmentExecutorGateStats, that.fragmentExecutorGateStats)
            adaptiveBudget.toXContent(builder, params);  
     * @param searchStats                the search execution metrics (nullable)
     * Construct from all components.
        if (fragmentExecutorGateStats != null) {
     * Returns the native executor metrics, or {@code null} if absent.  
        this.cacheStats = cacheStats;
    @Override  
        if (this == o) return true;
    @Override
        NativeExecutorsStats nativeExecutorsStats,  
    public CacheStats getCacheStats() {  
    }
    public AdaptiveBudgetStats getAdaptiveBudgetStats() {
    private final AdaptiveBudgetStats adaptiveBudget; // nullable
    }  
        out.writeOptionalWriteable(cacheStats);
            && Objects.equals(cacheStats, that.cacheStats)
        return fragmentExecutorGateStats;
        this.adaptiveBudget = in.readOptionalWriteable(AdaptiveBudgetStats::new);
     * @param cacheStats                 the parquet metadata + statistics cache metrics (nullable)
 *  
 * Top-level stats container for the DataFusion backend.
    public PartitionGateStats getFragmentExecutorGateStats() {  
        SpillStats spillStats,
import org.opensearch.core.xcontent.XContentBuilder;
    @Override
        return Objects.equals(nativeExecutorsStats, that.nativeExecutorsStats)
        this.fragmentExecutorGateStats = fragmentExecutorGateStats;
    private final NativeExecutorsStats nativeExecutorsStats; // nullable
    public DataFusionStats(
        PartitionGateStats fragmentExecutorGateStats,
    public SearchStats getSearchStats() {
    /**  
    /**
     */  
    }
    }  
        out.writeOptionalWriteable(nativeExecutorsStats);
    }  
    private final CacheStats cacheStats; // nullable  
        this(nativeExecutorsStats, fragmentExecutorGateStats, adaptiveBudget, spillStats, null, null);
    }  
        this.searchStats = in.readOptionalWriteable(SearchStats::new);
     * Returns the parquet cache metrics, or {@code null} if absent.
        if (cacheStats != null) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.io.stream.Writeable;  
    private final PartitionGateStats fragmentExecutorGateStats; // nullable  
        return nativeExecutorsStats;  
            nativeExecutorsStats.toXContent(builder, params);  
        }
        if (adaptiveBudget != null) {
    public void writeTo(StreamOutput out) throws IOException {  
    public boolean equals(Object o) {  
     */
 * making it extensible for future metric categories (e.g. MemoryPoolStats).
    /**  
        return adaptiveBudget;
        out.writeOptionalWriteable(fragmentExecutorGateStats);
package org.opensearch.be.datafusion.stats;
        return builder;
    }  
        }
        }
    public NativeExecutorsStats getNativeExecutorsStats() {
            && Objects.equals(adaptiveBudget, that.adaptiveBudget)  
    }  
        return Objects.hash(nativeExecutorsStats, fragmentExecutorGateStats, adaptiveBudget, spillStats, cacheStats, searchStats);
    private final SearchStats searchStats; // nullable
        out.writeOptionalWriteable(adaptiveBudget);  
     * @param fragmentExecutorGateStats  the fragment executor partition gate metrics (nullable)
 */  
    /**
        SearchStats searchStats
    /**
    public int hashCode() {
     * @throws IOException if deserialization fails  
/**
import org.opensearch.core.common.io.stream.StreamOutput;
            searchStats.toXContent(builder, params);  
        if (spillStats != null) {
        this.spillStats = spillStats;  
     * Returns the spill directory metrics, or {@code null} if absent.  
     */
     * @param adaptiveBudget             the adaptive budget metrics (nullable)
        out.writeOptionalWriteable(searchStats);  
 * compatible open source license.
    }
     */
     * Returns the fragment executor partition gate metrics, or {@code null} if absent.
     */
            cacheStats.toXContent(builder, params);  
    public DataFusionStats(StreamInput in) throws IOException {
    }
        this.spillStats = in.readOptionalWriteable(SpillStats::new);  
    public DataFusionStats(
     */  
        return searchStats;
    }
     *
    /**
        this.searchStats = searchStats;
            && Objects.equals(spillStats, that.spillStats)
     * @param spillStats                 the spill directory stats (nullable)  
    /**  
 *
 * <p>Composes {@link NativeExecutorsStats} rather than duplicating its fields,
 * <p>Implements {@link Writeable} for transport serialization and {@link ToXContentFragment}
        if (o == null || getClass() != o.getClass()) return false;
        this.nativeExecutorsStats = in.readOptionalWriteable(NativeExecutorsStats::new);  
    private final SpillStats spillStats; // nullable
 * to {@link NativeExecutorsStats}.
        SpillStats spillStats  
        NativeExecutorsStats nativeExecutorsStats,
     * Returns the search execution metrics, or {@code null} if absent.
     *
    ) {
        }
     * Returns the adaptive budget metrics, or {@code null} if absent.
        AdaptiveBudgetStats adaptiveBudget,
        }
        if (searchStats != null) {
        this.adaptiveBudget = adaptiveBudget;
        }
        return cacheStats;
    public SpillStats getSpillStats() {
        out.writeOptionalWriteable(spillStats);
