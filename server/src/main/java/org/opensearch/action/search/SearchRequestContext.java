    public String toString() {
                ShardStatsFieldNames.SEARCH_REQUEST_SLOWLOG_SHARD_TOTAL.toString(),
 * @opensearch.internal  
        return phaseTookMap;
            );  
            return null;
        this.shardStats.put(ShardStatsFieldNames.SEARCH_REQUEST_SLOWLOG_SHARD_TOTAL, total);  
    private long absoluteStartNanos;  
    private TotalHits totalHits;
    /**
    /**  
    }  
        return searchRequestOperationsListener;
            this.phaseResourceUsage.add(usage);
    private final SearchRequest searchRequest;  
 *
public class SearchRequestContext {  
}
    void setStreamingRequest(boolean streamingRequest) {
/*  
        return new ArrayList<>(phaseResourceUsage);  
import java.util.Locale;  
    public List<TaskResourceInfo> getPhaseResourceUsage() {
 *
    SearchRequestContext(
    }
    private final Supplier<TaskResourceInfo> taskResourceUsageSupplier;
        this.absoluteStartNanos = System.nanoTime();
enum ShardStatsFieldNames {
import java.util.EnumMap;  
 * SPDX-License-Identifier: Apache-2.0
    }
    private static final Logger logger = LogManager.getLogger();
import org.apache.logging.log4j.LogManager;
    }
        this.shardStats.put(ShardStatsFieldNames.SEARCH_REQUEST_SLOWLOG_SHARD_SKIPPED, skipped);
        this.name = name;
package org.opensearch.action.search;
    public void recordPhaseResourceUsage(TaskResourceInfo usage) {
    }
    /**
 */
    }
    }
    }
    SEARCH_REQUEST_SLOWLOG_SHARD_TOTAL("total"),
    public long getAbsoluteStartNanos() {
    }
    void updatePhaseTookMap(String phaseName, Long tookTime) {
        }
    }
import java.util.function.Supplier;
    public Set<Index> getSuccessfulSearchShardIndices() {  
     */
        this.taskResourceUsageSupplier = taskResourceUsageSupplier;
/**  
            return "";
        if (shardStats.isEmpty()) {
    private final LinkedBlockingQueue<TaskResourceInfo> phaseResourceUsage;
        } else {
import org.opensearch.core.tasks.resourcetracker.TaskResourceInfo;  
    }
        if (searchRequest != null && searchRequest.isPhaseTook() != null && searchRequest.isPhaseTook()) {
    }
    public Supplier<TaskResourceInfo> getTaskResourceUsageSupplier() {
    public Map<String, Long> phaseTookMap() {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.index.Index;
                ShardStatsFieldNames.SEARCH_REQUEST_SLOWLOG_SHARD_FAILED.toString(),
        this.searchRequest = searchRequest;
        final SearchRequestOperationsListener searchRequestOperationsListener,  
    ShardStatsFieldNames(String name) {  
    }  
        }  
import org.apache.lucene.search.TotalHits;  
    }
    void setAbsoluteStartNanos(long absoluteStartNanos) {
@InternalApi
        return streamingRequest;  
    SEARCH_REQUEST_SLOWLOG_SHARD_SKIPPED("skipped"),
    }
        final Supplier<TaskResourceInfo> taskResourceUsageSupplier
    SearchResponse.PhaseTook getPhaseTook() {
    String formattedShardStats() {  
    private final EnumMap<ShardStatsFieldNames, Integer> shardStats;  
    ) {  
     * For testing only
import java.util.List;
    SEARCH_REQUEST_SLOWLOG_SHARD_FAILED("failed");
        } else {  
                shardStats.get(ShardStatsFieldNames.SEARCH_REQUEST_SLOWLOG_SHARD_SKIPPED),  
        this.shardStats.put(ShardStatsFieldNames.SEARCH_REQUEST_SLOWLOG_SHARD_SUCCESSFUL, successful);
     * Request start time in nanos  
                ShardStatsFieldNames.SEARCH_REQUEST_SLOWLOG_SHARD_SKIPPED.toString(),
        return this.name;  
 */  
        return totalHits;
import org.opensearch.common.annotation.InternalApi;
    SearchRequestOperationsListener getSearchRequestOperationsListener() {
    private final Map<String, Long> phaseTookMap;
    void setSuccessfulSearchShardIndices(Set<Index> successfulSearchShardIndices) {
     * Override absoluteStartNanos set in constructor.
}
    }
    private Set<Index> successfulSearchShardIndices;
     * @return A {@link Set} of {@link Index} representing the names of the indices that were  
    private final SearchRequestOperationsListener searchRequestOperationsListener;
import java.util.ArrayList;
    }  
    public boolean isStreamingRequest() {
        this.successfulSearchShardIndices = successfulSearchShardIndices;
                Locale.ROOT,
                shardStats.get(ShardStatsFieldNames.SEARCH_REQUEST_SLOWLOG_SHARD_FAILED)
        return taskResourceUsageSupplier;
        this.totalHits = totalHits;
                shardStats.get(ShardStatsFieldNames.SEARCH_REQUEST_SLOWLOG_SHARD_TOTAL),
                ShardStatsFieldNames.SEARCH_REQUEST_SLOWLOG_SHARD_SUCCESSFUL.toString(),  
            return String.format(
import org.apache.logging.log4j.Logger;
    }  
        this.shardStats.put(ShardStatsFieldNames.SEARCH_REQUEST_SLOWLOG_SHARD_FAILED, failed);  
    @Override
    SEARCH_REQUEST_SLOWLOG_SHARD_SUCCESSFUL("successful"),  
     */  
        this.phaseTookMap = new HashMap<>();  
import java.util.Set;
        this.shardStats = new EnumMap<>(ShardStatsFieldNames.class);
                "{%s:%s, %s:%s, %s:%s, %s:%s}",  
     */
import java.util.Map;
        return searchRequest;
    void setShardStats(int total, int successful, int skipped, int failed) {
    }  
    void setTotalHits(TotalHits totalHits) {  
        this.streamingRequest = streamingRequest;
     * successfully queried at the shard level.
        final SearchRequest searchRequest,
            return new SearchResponse.PhaseTook(phaseTookMap);  
    }  
        if (usage != null) {  
import java.util.HashMap;
                shardStats.get(ShardStatsFieldNames.SEARCH_REQUEST_SLOWLOG_SHARD_SUCCESSFUL),
        this.absoluteStartNanos = absoluteStartNanos;
        }
        return absoluteStartNanos;  
import java.util.concurrent.LinkedBlockingQueue;  
    }  
    public SearchRequest getRequest() {  
 * compatible open source license.
    public TotalHits totalHits() {
        this.searchRequestOperationsListener = searchRequestOperationsListener;
    private final String name;
        this.phaseTookMap.put(phaseName, tookTime);  
    private boolean streamingRequest;  
        this.phaseResourceUsage = new LinkedBlockingQueue<>();  
 * The OpenSearch Contributors require contributions made to  
 * This class holds request-level context for search queries at the coordinator node
        return successfulSearchShardIndices;
