        table.addCell(
            table.addCell(primaryStats.getCompletion() == null ? null : primaryStats.getCompletion().getSize());
        table.addCell("search.fetch_total", "sibling:pri;alias:sfto,searchFetchTotal;default:false;text-align:right;desc:total fetch ops");
            table.addCell(totalStats.getGet() == null ? null : totalStats.getGet().getExistsCount());
            table.addCell(totalStats.getRequestCache() == null ? null : totalStats.getRequestCache().getMissCount());
 * @opensearch.api
        table.addCell(
            "sibling:pri;alias:sqf,searchQueryFailed;default:false;text-align:right;desc:failed query phase ops"
/*
            table.addCell(primaryStats.getRefresh() == null ? null : primaryStats.getRefresh().getTotalTime());
            "search.concurrent_avg_slice_count",
                    clusterStateResponse.getState().getMetadata(),
                    }
            "merges.warmer.total_invocations",
        table.addCell("pri.indexing.index_current", "default:false;text-align:right;desc:number of current indexing ops");
            "merges.warmer.total_bytes_received",
import org.opensearch.action.admin.indices.stats.IndexStats;
                        false
        table.addCell("pri.warmer.total_time", "default:false;text-align:right;desc:time spent in warmers");
                new ActionListener<GetSettingsResponse>() {
                                        client,
        table.addCell("pri.flush.total", "default:false;text-align:right;desc:number of flushes");
        table.addCell("index", "alias:i,idx;desc:index name");
 * GitHub history for details.
                totalStats = indexStats.getTotal();
                // TODO: expose docs stats for replicated closed indices
    }
    ) {
    }
        table.addCell(
        );
        table.addCell("pri.flush.total_time", "default:false;text-align:right;desc:time spent in flush");
        table.addCell("suggest.total", "sibling:pri;alias:suto,suggestTotal;default:false;text-align:right;desc:number of suggest ops");
        final IndicesStatsRequest request = new IndicesStatsRequest();
                if (skip) {
        final IndicesOptions indicesOptions,
        final boolean includeUnloadedSegments,
            table.addCell(indexName);
                return settingsMapIter.hasNext();
            table.addCell(primaryStats.getRefresh() == null ? null : primaryStats.getRefresh().getExternalTotalTime());
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
        );
            "default:false;text-align:right;desc:total bytes sent by a primary shard during the warm operation"
            "sibling:pri;alias:scto,searchScrollTotal;default:false;text-align:right;desc:completed scroll contexts"
            table.addCell(totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getIndexCurrent());
        request.local(local);
        );
            "indexing.index_time",
                health = "";
            table.addCell(totalStats.getSegments() == null ? null : totalStats.getSegments().getVersionMapMemory());
        );
 * Modifications Copyright OpenSearch Contributors. See
        );
            @Override
            table.addCell(totalStats.getGet() == null ? null : totalStats.getGet().getTime());
            table.addCell(primaryStats.getWarmer() == null ? null : primaryStats.getWarmer().total());
            final boolean searchThrottled = IndexSettings.INDEX_SEARCH_THROTTLED.get(settings);
            }
                                        );
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getStarTreeQueryCount());
        client.admin().cluster().health(request, listener);
        return true;
    private void sendGetSettingsRequest(
            "sibling:pri;alias:gmto,getMissingTotal;default:false;text-align:right;desc:number of failed gets"
}
    }
        table.addCell("uuid", "alias:id,uuid;desc:index uuid");
 * not use this file except in compliance with the License.
            table.addCell(totalStats.getRefresh() == null ? null : totalStats.getRefresh().getTotal());
        );
    private void sendIndicesStatsRequest(
            table.addCell(primaryStats.getQueryCache() == null ? null : primaryStats.getQueryCache().getMemorySize());
        table.addCell("pri.request_cache.miss_count", "default:false;text-align:right;desc:request cache miss count");
            "segments.version_map_memory",
                        // The list of indices that will be returned is determined by the indices returned from the Get Settings call.
    @Override
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getConcurrentQueryCount());
        while (tableIterator.hasNext()) {
import org.opensearch.common.unit.TimeValue;
    protected Set<String> responseParams() {
import static org.opensearch.rest.RestRequest.Method.GET;
            table.addCell(primaryStats.getQueryCache() == null ? null : primaryStats.getQueryCache().getEvictions());
            "default:false;text-align:right;desc:total invocations of merged segment warmer"
            "sibling:pri;alias:wtt,warmerTotalTime;default:false;text-align:right;desc:time spent in warmers"
        table.addCell("pri.refresh.listeners", "default:false;text-align:right;desc:number of pending refresh listeners");
            "sibling:pri;alias:iic,indexingIndexCurrent;default:false;text-align:right;desc:number of current indexing ops"
        final Boolean systemParam = request.hasParam("system") ? request.paramAsBoolean("system", false) : null;
     * or not. On top of this, the Indices Stats API cannot be used either to resolve indices
        table.addCell(
        table.addCell(
            "indexing.delete_total",
                            clusterManagerNodeTimeout,
            "merges.warmer.total_bytes_sent",
                                @Override
        table.addCell("pri.store.size", "text-align:right;desc:store size of primaries");
 */
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getConcurrentQueryCurrent());
                    public void onFailure(final Exception e) {
        table.addCell(
        );
            "alias:mswtrt,mergedSegmentWarmerTotalReceiveTime;default:false;text-align:right;desc:total wallclock time spent receiving merged segments by a replica shard"
            table.addCell(totalStats.getTotalMemory());
                primaryStats = new CommonStats();
            table.addCell(totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getIndexFailedCount());
import org.opensearch.indices.SystemIndices;
                ? null
        return null;
        );
        );
                    @Override
    protected void documentation(StringBuilder sb) {
        );
        this.responseLimitSettings = responseLimitSettings;
        sb.append("/_cat/indices\n");
            "request_cache.miss_count",
        table.addCell("status", "alias:s;desc:open/close status");
            table.addCell(totalStats.getRequestCache() == null ? null : totalStats.getRequestCache().getMemorySize());
                                        ? indices
        );
                    ClusterStateResponse stateResponse = extractResponse(responses, ClusterStateResponse.class);
        );
        client.admin().indices().getSettings(request, listener);
        table.addCell("pri.query_cache.evictions", "default:false;text-align:right;desc:query cache evictions");
            }
            table.addCell(mergedSegmentWarmerTotalStats == null ? null : mergedSegmentWarmerTotalStats.getTotalSentSize());
        table.addCell(
            table.addCell(primaryStats.getRequestCache() == null ? null : primaryStats.getRequestCache().getMemorySize());
                    @Override
            table.addCell(mergedSegmentWarmerTotalStats == null ? null : mergedSegmentWarmerTotalStats.getTotalReceiveTime());
            "sibling:pri;alias:casc,searchConcurrentAvgSliceCount;default:false;text-align:right;desc:average query concurrency"
                String index = settingsMapIter.next();
        table.addCell(
        );
                        // force the IndicesOptions for all the sub-requests to be as inclusive as possible.
                }
    private final ResponseLimitSettings responseLimitSettings;
            "search.startree_query_current",
                    ClusterHealthResponse healthResponse = extractResponse(responses, ClusterHealthResponse.class);
import org.opensearch.common.logging.DeprecationLogger;
            table.addCell(primaryStats.getFieldData() == null ? null : primaryStats.getFieldData().getMemorySize());
    }
        final ActionListener<Table> listener
            table.addCell(totalStats.getSegments() == null ? null : totalStats.getSegments().getBitsetMemory());
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
    }
        return true;
                                public void onResponse(ClusterStateResponse clusterStateResponse) {
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getScrollTime());
            final Tuple<String, Settings> tuple = tableIterator.next();
            if (indicesMetadatas.containsKey(indexName) == false) {
import java.util.Spliterators;
        );
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getSuggestCurrent());
        RESPONSE_PARAMS = Collections.unmodifiableSet(responseParams);
            "search.scroll_time",
        table.addCell("pri.segments.version_map_memory", "default:false;text-align:right;desc:memory used by version map");
        return new GroupedActionListener<>(new ActionListener<Collection<ActionResponse>>() {
        final Map<String, IndexStats> indicesStats,
import java.util.HashSet;
import org.opensearch.action.support.GroupedActionListener;
                // the index exists in the Get Indices response but is not present in the cluster state:
        );
    ) {
                    // index health is unknown, skip if we don't explicitly request RED health
import org.opensearch.common.settings.Settings;
        }
            "fielddata.memory_size",
        table.addCell("pri.segments.memory", "default:false;text-align:right;desc:memory used by segments");
            table.addCell(primaryStats.getMerge() == null ? null : primaryStats.getMerge().getCurrentNumDocs());
            "merges.warmer.ongoing_count",
        request.indicesOptions(indicesOptions);
                        stateResponse.getState().getMetadata().spliterator(),
        final ActionListener<ClusterStateResponse> listener
            "pri.merges.warmer.total_receive_time",
            MergedSegmentWarmerStats mergedSegmentWarmerPrimaryStats = primaryStats.getMerge() == null
        );
                                    }
                                        subRequestIndicesOptions,
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getFetchTime());
                local,
            ? IndicesOptions.strictExpandHidden()
        table.addCell("creation.date", "alias:cd;default:false;desc:index creation date (millisecond value)");
            table.addCell(searchThrottled);
        final String systemColumnDefault = request.hasParam("system") ? "" : "default:false;";
                    GetSettingsResponse settingsResponse = extractResponse(responses, GetSettingsResponse.class);
                    listener.onResponse(responseTable);
                        listener.onFailure(e);
                // it is likely that the index was deleted in the meanwhile, so we ignore it.
                                        indicesToBeQueried,
                    continue;
                + " nested object field types and type filters for types referred in _parent fields"
            table.addCell(primaryStats.getIndexing() == null ? null : primaryStats.getIndexing().getTotal().getIndexTime());
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getStarTreeQueryCurrent());
        final Table table = getTableWithHeader(request, pageToken);
                        Spliterators.spliterator(settingsResponse.getIndexToSettings().entrySet(), 0),
        table.addCell("pri.request_cache.evictions", "default:false;text-align:right;desc:request cache evictions");
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getQueryFailedCount());
            table.addCell(primaryStats.getRefresh() == null ? null : primaryStats.getRefresh().getExternalTotal());
        return channel -> {
import org.opensearch.transport.client.node.NodeClient;
        );
        table.addCell("pri.merges.current", "default:false;text-align:right;desc:number of current merges");
                                }
 */
    }
        table.addCell(
    private GroupedActionListener<ActionResponse> createGroupedListener(
import org.opensearch.common.breaker.ResponseLimitSettings;
            "query_cache.memory_size",
        );
        table.addCell("warmer.total", "sibling:pri;alias:wto,warmerTotal;default:false;text-align:right;desc:total warmer ops");
            table.addCell(totalStats.getQueryCache() == null ? null : totalStats.getQueryCache().getEvictions());
        table.addCell(
        table.addCell("pri.search.concurrent_avg_slice_count", "default:false;text-align:right;desc:average query concurrency");
            table.addCell(primaryStats.getRequestCache() == null ? null : primaryStats.getRequestCache().getEvictions());
            "pri.merges.warmer.total_time",
        request.clusterManagerNodeTimeout(clusterManagerNodeTimeout);
    protected Table getTableWithHeader(final RestRequest request, final PageToken pageToken) {
            "default:false;text-align:right;desc:memory used by fixed bit sets for nested object"
            "sibling:pri;alias:sfti,searchFetchTime;default:false;text-align:right;desc:time spent in fetch phase"
            table.addCell(totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getIndexCount());
        final ActionListener<IndicesStatsResponse> listener
                        // requests not to fail on the deleted index (as we want to ignore wildcards that cannot be resolved).
                                    IndexPaginationStrategy paginationStrategy = getPaginationStrategy(clusterStateResponse);
            "sibling:pri;alias:sqto,searchQueryTotal;default:false;text-align:right;desc:total query phase ops"
        table.addCell(
        table.addCell("pri.suggest.time", "default:false;text-align:right;desc:time spend in suggest");
                                }
            table.addCell(primaryStats.getMerge() == null ? null : primaryStats.getMerge().getCurrent());
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getConcurrentQueryCount());
            "alias:last_index_ts,lastIndexRequestTimestamp;default:false;text-align:right;desc:timestamp of the last processed index request (epoch millis)"
    private final SystemIndices systemIndices;
            table.addCell(indexMetadata.getIndexUUID());
        table.addCell("pri", "alias:p,shards.primary,shardsPrimary;text-align:right;desc:number of primary shards");
        }
    }
            } else if (limit > 0) {
    ) {
        table.addCell("pri.get.exists_total", "default:false;text-align:right;desc:number of successful gets");
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getFetchCount());
        );
            table.addCell(primaryStats.getMerge() == null ? null : primaryStats.getMerge().getCurrentSize());
        table.addCell(
        );
                                        : paginationStrategy.getRequestedEntities().toArray(new String[0]);
        table.addCell("system", "alias:sys;" + systemColumnDefault + "desc:whether the index is a system index");
        table.addCell("merges.total_size", "sibling:pri;alias:mts,mergesTotalSize;default:false;text-align:right;desc:size merged");
            }
        );
            "get.exists_time",
        table.addCell(
                    Map<String, IndexMetadata> indicesStates = StreamSupport.stream(
        final Map<String, Settings> indicesSettings,
                            local,
import org.opensearch.action.pagination.PageToken;
            public void onResponse(final Collection<ActionResponse> responses) {
                        sendClusterStateRequest(
        table.addCell("refresh.total", "sibling:pri;alias:rto,refreshTotal;default:false;text-align:right;desc:total refreshes");
            public boolean hasNext() {
            "search.concurrent_query_total",
    ) {
        final TimeValue clusterManagerNodeTimeout = clusterManagerTimeout;
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getConcurrentAvgSliceCount());
            "search.concurrent_query_time",
            table.addCell(primaryStats.getGet() == null ? null : primaryStats.getGet().getCount());
            table.addCell(primaryStats.getTotalMemory());
/*
        final NodeClient client,
import org.opensearch.core.action.ActionListener;
            table.addCell(totalStats.getGet() == null ? null : totalStats.getGet().getExistsTime());
        table.addCell("pri.get.missing_total", "default:false;text-align:right;desc:number of failed gets");
        table.addCell("pri.refresh.total", "default:false;text-align:right;desc:total refreshes");
            table.addCell(totalStats.getQueryCache() == null ? null : totalStats.getQueryCache().getMemorySize());
            table.addCell(mergedSegmentWarmerPrimaryStats == null ? null : mergedSegmentWarmerPrimaryStats.getTotalFailureCount());
            table.addCell(totalStats.getMerge() == null ? null : totalStats.getMerge().getTotal());
            "search.query_total",
        table.addCell("merges.total_docs", "sibling:pri;alias:mtd,mergesTotalDocs;default:false;text-align:right;desc:docs merged");
            "merges.total_time",
            "search.query_failed",
        final NodeClient client,
    /**
        table.addCell(
        return table;
            "sibling:pri;alias:rto,refreshTotal;default:false;text-align:right;desc:total external refreshes"
            "alias:mswtfc,mergedSegmentWarmerTotalFailureCount;default:false;text-align:right;desc:total failures in merged segment warmer"
        return new Iterator<>() {
            table.addCell(totalStats.getMerge() == null ? null : totalStats.getMerge().getTotalSize());
    protected Iterator<Tuple<String, Settings>> getTableIterator(String[] indices, Map<String, Settings> indexSettingsMap) {
            table.addCell(totalStats.getGet() == null ? null : totalStats.getGet().getMissingTime());
        );
            table.addCell(totalStats.getCompletion() == null ? null : totalStats.getCompletion().getSize());
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getStarTreeQueryTime());
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getPitCurrent());
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getFetchCurrent());
        table.addCell("pri.search.startree.query_current", "default:false;text-align:right;desc:current star tree query ops");
            final CommonStats totalStats;
        );
            table.addCell(mergedSegmentWarmerTotalStats == null ? null : mergedSegmentWarmerTotalStats.getTotalInvocationsCount());
        );
import java.util.function.Function;
        final boolean local,
        request.names(IndexSettings.INDEX_SEARCH_THROTTLED.getKey());
                limitBreached = ResponseLimitSettings.isResponseLimitBreached(
    private static final String DUPLICATE_PARAMETER_ERROR_MESSAGE =
            Long ts = totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getMaxLastIndexRequestTimestamp();
        final TimeValue clusterManagerNodeTimeout,
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getStarTreeQueryCount());
            "default:false;text-align:right;desc:total wallclock time spent in the warming operation"
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getQueryTime());
                                        4,
                try {
            "sibling:pri;alias:iif,indexingIndexFailed;default:false;text-align:right;desc:number of failed indexing ops"
            table.addCell(primaryStats.getIndexing() == null ? null : primaryStats.getIndexing().getTotal().getDeleteCurrent());
        request.local(local);
        table.addCell("pri.search.query_total", "default:false;text-align:right;desc:total query phase ops");
import org.opensearch.core.action.ActionResponse;
import org.opensearch.indices.SystemIndexDescriptor;
        final ActionListener<ClusterHealthResponse> listener
        table.addCell("pri.search.concurrent_query_time", "default:false;text-align:right;desc:time spent in concurrent query phase");
        table.addCell("pri.fielddata.memory_size", "default:false;text-align:right;desc:used fielddata cache");
        table.addCell(
 *
        request.clusterManagerNodeTimeout(clusterManagerNodeTimeout);
            "indexing.delete_time",
                        // re-resolve the index names with the same indices options that we used for the initial cluster state
            if (limitBreached) {
                                    // For paginated queries, if strategy outputs no indices to be returned,
import org.opensearch.cluster.health.ClusterIndexHealth;
            table.addCell(mergedSegmentWarmerTotalStats == null ? null : mergedSegmentWarmerTotalStats.getOngoingCount());
                        // subsequent cluster state, cluster health and indices stats requests execute. We have to distinguish two cases:
        table.addCell("pri.indexing.index_time", "default:false;text-align:right;desc:time spent in indexing");
 *    http://www.apache.org/licenses/LICENSE-2.0
            "sibling:pri;alias:mtt,mergesTotalTime;default:false;text-align:right;desc:time spent in merges"
        request.indicesOptions(indicesOptions);
        table.addCell(
            Settings settings = tuple.v2();
import java.util.Objects;
            "indexing.index_failed",
        request.indices(indices);
            "default:false;text-align:right;desc:point-in-time metric for number of in-progress warm operations"
                            client,
            "indexing.index_current",
        table.endHeaders();
        table.addCell("pri.search.fetch_current", "default:false;text-align:right;desc:current fetch phase ops");
        table.addCell(
            "search.fetch_current",
            final IndexStats indexStats = indicesStats.get(indexName);
        // Remove the if condition and statements inside after removing MASTER_ROLE.
            table.addCell(totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getDeleteTime());
        table.addCell("pri.warmer.total", "default:false;text-align:right;desc:total warmer ops");
            "sibling:pri;alias:idc,indexingDeleteCurrent;default:false;text-align:right;desc:number of current deletions"
            public Tuple<String, Settings> next() {
        }
        table.addCell("pri.merges.total_time", "default:false;text-align:right;desc:time spent in merges");
        table.addCell("memory.total", "sibling:pri;alias:tm,memoryTotal;default:false;text-align:right;desc:total used memory");
 * ownership. Elasticsearch licenses this file to you under
 * You may obtain a copy of the License at
            table.addCell(primaryStats.getGet() == null ? null : primaryStats.getGet().getMissingCount());
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getScrollCurrent());
 * SPDX-License-Identifier: Apache-2.0
    public RestIndicesAction(ResponseLimitSettings responseLimitSettings, SystemIndices systemIndices) {
            public void onFailure(final Exception e) {
            "pri.merges.warmer.total_send_time",
                                    // For non-paginated queries, indicesToBeQueried would be same as indices retrieved from
        final Boolean systemParam = request.hasParam("system") ? request.paramAsBoolean("system", false) : null;
    @Override
            "get.exists_total",
        table.addCell("pri.search.query_failed", "default:false;text-align:right;desc:failed query phase ops");
            final ClusterIndexHealth indexHealth = indicesHealths.get(indexName);
            : IndicesOptions.strictExpand();
            table.addCell(totalStats.getStore() == null ? null : totalStats.getStore().size());
            "sibling:pri;alias:so,searchOpenContexts;default:false;text-align:right;desc:open search contexts"
                                    if (shouldSkipIndicesStatsRequest(paginationStrategy)) {
            table.addCell(totalStats.getMerge() == null ? null : totalStats.getMerge().getCurrentSize());
            "default:false;text-align:right;desc:total wallclock time spent sending merged segments by a primary shard"
    @Override
                        request,
 * license agreements. See the NOTICE file distributed with
        );
        Table table = new Table(pageToken);
    }
                    .filter(indexMetadata -> indexMetadata.isSystem() == systemParam)
import org.opensearch.rest.RestRequest;
        final IndicesOptions indicesOptions,
        table.addCell(
        table.addCell("store.size", "sibling:pri;alias:ss,storeSize;text-align:right;desc:store size of primaries & replicas");
        return true;
                        getTableIterator(indicesToBeQueried, indicesSettings),
        table.addCell("segments.count", "sibling:pri;alias:sc,segmentsCount;default:false;text-align:right;desc:number of segments");
            "sibling:pri;alias:scti,searchScrollTime;default:false;text-align:right;desc:time scroll contexts held open"
        table.addCell(
        table.addCell(
            table.addCell(totalStats.getMerge() == null ? null : totalStats.getMerge().getCurrentNumDocs());
import java.util.List;
    protected Table buildTable(
        table.addCell(
            clusterManagerTimeout = request.paramAsTime("master_timeout", DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT);
        table.addCell("pri.search.query_time", "default:false;text-align:right;desc:time spent in query phase");
                                        clusterManagerNodeTimeout,
                continue;
        final PageToken pageToken
            if (healthParam != null) {
            table.addCell(mergedSegmentWarmerPrimaryStats == null ? null : mergedSegmentWarmerPrimaryStats.getTotalReceiveTime());
        table.addCell(
        );
        table.addCell(
            "search.startree_query_time",
        table.addCell("merges.total", "sibling:pri;alias:mt,mergesTotal;default:false;text-align:right;desc:number of completed merge ops");
            table.addCell(primaryStats.getRefresh() == null ? null : primaryStats.getRefresh().getTotal());
            table.startRow();
            "default:false;text-align:right;desc:total failures in merged segment warmer"
            "request_cache.memory_size",
        table.addCell("flush.total", "sibling:pri;alias:ft,flushTotal;default:false;text-align:right;desc:number of flushes");
        table.addCell(
                final ClusterHealthStatus healthStatusFilter = ClusterHealthStatus.fromString(healthParam);
            "search.query_current",
            table.addCell(totalStats.getRequestCache() == null ? null : totalStats.getRequestCache().getHitCount());
                return false;
                                    final GroupedActionListener<ActionResponse> groupedListener = createGroupedListener(
    @SuppressWarnings("unchecked")
            table.addCell(mergedSegmentWarmerPrimaryStats == null ? null : mergedSegmentWarmerPrimaryStats.getTotalInvocationsCount());
            table.addCell(primaryStats.getRequestCache() == null ? null : primaryStats.getRequestCache().getMissCount());
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getScrollTime());
                                            client,
        );
            "sibling:pri;alias:scc,searchPointInTimeCurrent;default:false;text-align:right;desc:open point in time contexts"
            "pri.merges.warmer.total_failure_count",
package org.opensearch.rest.action.cat;
                                        local,
import org.opensearch.rest.action.RestResponseListener;
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getSuggestCount());
        );
        );
                    Map<String, ClusterIndexHealth> indicesHealths = healthResponse.getIndices();
                        // want the subsequent requests to fail.
                client,
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;
        );
    @Override
            table.addCell(primaryStats.getDocs() == null ? null : primaryStats.getDocs().getCount());
        table.addCell(
        table.addCell(
            table.addCell(primaryStats.getIndexing() == null ? null : primaryStats.getIndexing().getTotal().getDeleteCount());
            "system.description",
                    );
                        // This behavior can be ensured by letting the cluster state, cluster health and indices stats requests
 *
        final IndicesOptions defaultIndicesOptions = request.paramAsBoolean("system", false)
            "sibling:pri;alias:svmm,segmentsVersionMapMemory;default:false;text-align:right;desc:memory used by version map"
            table.addCell(totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getDeleteCount());
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getScrollCount());
                    // index health is known but does not match the one requested
                : primaryStats.getMerge().getWarmerStats();
                        indicesHealths,
                }
        );
    private void sendClusterStateRequest(
            "search.query_time",
            "alias:mswoc,mergedSegmentWarmerOngoingCount;default:false;text-align:right;desc:point-in-time metric for number of in-progress warm operations"
                                    // avoid fetching indices stats.
            "alias:mswtt,mergedSegmentWarmerTotalTime;default:false;text-align:right;desc:total wallclock time spent in the warming operation"
            final CommonStats primaryStats;
                }
            table.addCell(mergedSegmentWarmerTotalStats == null ? null : mergedSegmentWarmerTotalStats.getTotalTime());
        table.addCell("pri.refresh.external_total", "default:false;text-align:right;desc:total external refreshes");
            } else {
            "search.concurrent_query_current",
        table.addCell(
        table.addCell(
                        indicesStats,
            "search.startree_query_total",
        table.addCell("pri.search.fetch_time", "default:false;text-align:right;desc:time spent in fetch phase");
            "merges.warmer.total_failure_count",
                        // 2) the deleted index was resolved as part of a wildcard or _all. In this case, we want the subsequent
        );
import org.opensearch.index.IndexSettings;
import org.opensearch.common.Table;
        table.addCell("docs.deleted", "alias:dd,docsDeleted;text-align:right;desc:deleted docs");
            "search.point_in_time_current",
        return IndicesOptions.fromRequest(request, defaultIndicesOptions);
            table.addCell(health);
        table.addCell(
        table.addCell("pri.search.startree_query_failed", "default:false;text-align:right;desc:failed star tree query phase ops");
            "indexing.delete_current",
        table.addCell("health", "alias:h;desc:current health status");
            table.addCell(mergedSegmentWarmerPrimaryStats == null ? null : mergedSegmentWarmerPrimaryStats.getTotalSendTime());
        final ClusterHealthRequest request = new ClusterHealthRequest();
        final ActionListener<Table> listener,
            table.addCell(mergedSegmentWarmerPrimaryStats == null ? null : mergedSegmentWarmerPrimaryStats.getTotalReceivedSize());
        table.addCell("pri.request_cache.memory_size", "default:false;text-align:right;desc:used request cache");
            if (indexHealth != null) {
        );
        };
            "search.point_in_time_time",
            "sibling:pri;alias:geti,getExistsTime;default:false;text-align:right;desc:time spent in successful gets"
                    ).collect(Collectors.toMap(cursor -> cursor.getKey(), cursor -> cursor.getValue()));
            table.addCell(totalStats.getMerge() == null ? null : totalStats.getMerge().getTotalNumDocs());
                                    if (validateRequestLimit(clusterStateResponse, systemParam, listener) == false) {
import static org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest.DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT;
        );
    public boolean isActionPaginated() {
            "sibling:pri;alias:iiti,indexingIndexTime;default:false;text-align:right;desc:time spent in indexing"
                                        request,
        );
            table.addCell(primaryStats.getGet() == null ? null : primaryStats.getGet().getTime());
        table.addCell("pri.segments.index_writer_memory", "default:false;text-align:right;desc:memory used by index writer");
                        );
            table.addCell(indexMetadata.isSystem());
        }, size);
        );
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getFetchCurrent());
        );
            table.addCell(totalStats.getFieldData() == null ? null : totalStats.getFieldData().getEvictions());
        final boolean includeUnloadedSegments = request.paramAsBoolean("include_unloaded_segments", false);
            table.addCell(totalStats.getMerge() == null ? null : totalStats.getMerge().getTotalTime());
        request.indicesOptions(indicesOptions);
            "alias:mswtbr,mergedSegmentWarmerTotalBytesReceived;default:false;text-align:right;desc:total bytes received by a replica shard during the warm operation"
    public boolean isRequestLimitCheckSupported() {
    }
        table.addCell("pri.merges.total_docs", "default:false;text-align:right;desc:docs merged");
    @Override
        table.addCell(
                return new Tuple<>(index, indexSettingsMap.get(index));
        final Map<String, IndexMetadata> indicesMetadatas,
/*
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getPitTime());
            "warmer.total_time",
            "search.point_in_time_total",
import static org.opensearch.common.breaker.ResponseLimitSettings.LimitEntity.INDICES;
import org.opensearch.cluster.metadata.IndexMetadata;
        );
            "pri.merges.warmer.total_bytes_received",
                    skip = indexHealth.getStatus() != healthStatusFilter;
    ) {
        return "cat_indices_action";
        "Parameter [master_timeout] is deprecated and will be removed in 3.0. To support inclusive language, please use [cluster_manager_timeout] instead.";
            table.addCell(primaryStats.getMerge() == null ? null : primaryStats.getMerge().getTotalSize());
            } else if (indexStats != null) {
            table.addCell(primaryStats.getDocs() == null ? null : primaryStats.getDocs().getDeleted());
            table.addCell(mergedSegmentWarmerTotalStats == null ? null : mergedSegmentWarmerTotalStats.getTotalReceivedSize());
        table.addCell(
 * this work for additional information regarding copyright
        table.addCell("pri.search.point_in_time_time", "default:false;text-align:right;desc:time point in time contexts held open");
            "sibling:pri;alias:sfbm,fixedBitsetMemory;default:false;text-align:right;desc:memory used by fixed bit sets for"
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getQueryFailedCount());
                        // Indices that were successfully resolved during the get settings request might be deleted when the
            int limit = responseLimitSettings.getCatIndicesResponseLimit();
        table.addCell(
        );
        final String[] indices = Strings.splitStringByCommaToArray(request.param("index"));
        table.addCell("get.time", "sibling:pri;alias:gti,getTime;default:false;text-align:right;desc:time spent in get");
    }
    }
    private static final Set<String> RESPONSE_PARAMS;
import java.util.stream.Collectors;
        if (request.hasParam("master_timeout")) {
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        table.addCell("pri.search.startree.query_total", "default:false;text-align:right;desc:total star tree resolved queries");
            "merges.warmer.total_receive_time",
                                public void onFailure(Exception e) {
        table.addCell("pri.suggest.current", "default:false;text-align:right;desc:number of current suggest ops");
                                        indicesToBeQueried,
            // Descriptors require a dot prefix; do not gate on metadata so disagreements remain visible.
        table.addCell(
    protected IndexPaginationStrategy getPaginationStrategy(ClusterStateResponse clusterStateResponse) {
            table.addCell(totalStats.getGet() == null ? null : totalStats.getGet().getCount());
import org.opensearch.action.pagination.IndexPaginationStrategy;
        );
            "sibling:pri;alias:fm,fielddataMemory;default:false;text-align:right;desc:used fielddata cache"
            "pri.segments.fixed_bitset_memory",
            table.addCell(totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getMaxLastIndexRequestTimestamp());
        table.addCell(
    }
        table.addCell(
        );
 *
            table.addCell(STRICT_DATE_TIME_FORMATTER.format(creationTime));
            "sibling:pri;alias:scc,searchScrollCurrent;default:false;text-align:right;desc:open scroll contexts"
                long matchingIndices = StreamSupport.stream(clusterStateResponse.getState().getMetadata().spliterator(), false)
                limitBreached = false;
    }
        };
            table.addCell(descriptor == null ? null : descriptor.getDescription());
    /**
            String indexName = tuple.v1();
            "sibling:pri;alias:rti,refreshTime;default:false;text-align:right;desc:time spent in external refreshes"
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getConcurrentQueryCurrent());
 * Licensed to Elasticsearch under one or more contributor
        final Set<String> responseParams = new HashSet<>(asList("local", "health", "system"));
        table.addCell("pri.request_cache.hit_count", "default:false;text-align:right;desc:request cache hit count");
        table.addCell("pri.merges.total", "default:false;text-align:right;desc:number of completed merge ops");
            table.addCell(primaryStats.getSegments() == null ? null : primaryStats.getSegments().getZeroMemory());
            "alias:mswtst,mergedSegmentWarmerTotalSendTime;default:false;text-align:right;desc:total wallclock time spent sending merged segments by a primary shard"
        final Boolean systemParam,
            table.addCell(primaryStats.getGet() == null ? null : primaryStats.getGet().current());
        TimeValue clusterManagerTimeout = request.paramAsTime("cluster_manager_timeout", DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT);
            table.addCell(indexState.toString().toLowerCase(Locale.ROOT));
        final boolean local = request.paramAsBoolean("local", false);
                listener.onFailure(new ResponseLimitBreachedException("Too many indices requested.", limit, INDICES));
        table.addCell(
            final IndexMetadata indexMetadata = indicesMetadatas.get(indexName);
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getStarTreeQueryFailed());
            table.addCell(totalStats.getFieldData() == null ? null : totalStats.getFieldData().getMemorySize());
            table.addCell(totalStats.getWarmer() == null ? null : totalStats.getWarmer().totalTime());
            "sibling:pri;alias:idto,indexingDeleteTotal;default:false;text-align:right;desc:number of delete ops"
            "sibling:pri;alias:siwm,segmentsIndexWriterMemory;default:false;text-align:right;desc:memory used by index writer"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.common.time.DateFormatter;
            }
            table.addCell(primaryStats.getFieldData() == null ? null : primaryStats.getFieldData().getEvictions());
                                    final String[] indicesToBeQueried = Objects.isNull(paginationStrategy)
            table.addCell(totalStats.getSegments() == null ? null : totalStats.getSegments().getCount());
        responseParams.addAll(AbstractCatAction.RESPONSE_PARAMS);
        table.addCell("pri.search.startree.query_time", "default:false;text-align:right;desc:time spent in star tree queries");
import org.opensearch.rest.RestResponse;
import org.opensearch.action.admin.indices.stats.CommonStats;
    private static <A extends ActionResponse> A extractResponse(final Collection<? extends ActionResponse> responses, Class<A> c) {
            "merges.current_size",
        table.addCell("pri.get.total", "default:false;text-align:right;desc:number of get ops");
        table.addCell("pri.get.current", "default:false;text-align:right;desc:number of current get ops");
                                    } else {
        table.addCell("pri.memory.total", "default:false;text-align:right;desc:total user memory");
        return unmodifiableList(asList(new Route(GET, "/_cat/indices"), new Route(GET, "/_cat/indices/{index}")));
            "indexing.index_total",
 * Unless required by applicable law or agreed to in writing,
            "search.open_contexts",
        table.addCell("pri.merges.current_size", "default:false;text-align:right;desc:size of current merges");
        return RESPONSE_PARAMS;
            final String health;
            final boolean limitBreached;
                                        return;
                boolean skip;
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getPitCount());
        );
                        false
                ts == null || ts == 0 ? null : STRICT_DATE_TIME_FORMATTER.format(Instant.ofEpochMilli(ts).atZone(ZoneOffset.UTC))
        request.indices(indices);
import org.opensearch.action.support.IndicesOptions;
                    limit
        table.addCell(
 * compatible open source license.
        );
        return table;
 * KIND, either express or implied.  See the License for the
        return (A) responses.stream().filter(c::isInstance).findFirst().get();
            table.addCell(totalStats.getFlush() == null ? null : totalStats.getFlush().getTotal());
 * _cat API action to list indices
        );
            "request_cache.evictions",
import java.util.Locale;
                health = "red*";
            table.addCell(primaryStats.getIndexing() == null ? null : primaryStats.getIndexing().getTotal().getIndexCurrent());
        table.addCell("pri.query_cache.memory_size", "default:false;text-align:right;desc:used query cache");
    ) {
    }
                @Override
                                @Override
        table.addCell("pri.refresh.external_time", "default:false;text-align:right;desc:time spent in external refreshes");
            "refresh.listeners",
        );
        final TimeValue clusterManagerNodeTimeout,
        );
    }
        table.addCell(
            }
import org.opensearch.core.common.Strings;
                                        Objects.isNull(paginationStrategy) ? null : paginationStrategy.getResponseToken()
        table.addCell(
            "search.startree_query_failed",
        table.addCell("pri.get.time", "default:false;text-align:right;desc:time spent in get");
        table.addCell(
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getStarTreeQueryTime());
    boolean validateRequestLimit(
            table.addCell(primaryStats.getFlush() == null ? null : primaryStats.getFlush().getTotalTime());
                } catch (Exception e) {
        );
        table.addCell("pri.indexing.delete_time", "default:false;text-align:right;desc:time spent in deletions");
            "sibling:pri;alias:mcd,mergesCurrentDocs;default:false;text-align:right;desc:number of current merging docs"
                                            subRequestIndicesOptions,
    private static final String MASTER_TIMEOUT_DEPRECATED_MESSAGE =
            );
    private boolean shouldSkipIndicesStatsRequest(IndexPaginationStrategy paginationStrategy) {
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getConcurrentQueryTime());
            "sibling:pri;alias:rcmc,requestCacheMissCount;default:false;text-align:right;desc:request cache miss count"
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getQueryCurrent());
    }
        request.clusterManagerNodeTimeout(clusterManagerNodeTimeout);
        final int size,
        table.addCell(
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getPitTime());
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getScrollCount());
        );
            table.addCell(primaryStats.getIndexing() == null ? null : primaryStats.getIndexing().getTotal().getDeleteTime());
import java.util.Collections;
public class RestIndicesAction extends AbstractListAction {
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestIndicesAction.class);
            "alias:mswti,mergedSegmentWarmerTotalInvocations;default:false;text-align:right;desc:total invocations of merged segment warmer"
        table.addCell("warmer.current", "sibling:pri;alias:wc,warmerCurrent;default:false;text-align:right;desc:current warmer ops");
        table.addCell(
        final String[] indices,
                                        ActionListener.wrap(groupedListener::onResponse, groupedListener::onFailure)
                                    );
            table.addCell(totalStats.getRefresh() == null ? null : totalStats.getRefresh().getExternalTotalTime());
            table.addCell(primaryStats.getRefresh() == null ? null : primaryStats.getRefresh().getListeners());
        final String[] indices,
        table.addCell("creation.date.string", "alias:cds;default:false;desc:index creation date (as string)");
            table.addCell(primaryStats.getSegments() == null ? null : primaryStats.getSegments().getVersionMapMemory());
            "pri.merges.warmer.total_bytes_sent",
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getSuggestCurrent());
        );
        table.addCell("pri.search.open_contexts", "default:false;text-align:right;desc:open search contexts");
        final RestRequest request,
            table.addCell(primaryStats.getGet() == null ? null : primaryStats.getGet().getExistsTime());
 * under the License.
        final GetSettingsRequest request = new GetSettingsRequest();
        table.addCell(
            table.addCell(mergedSegmentWarmerPrimaryStats == null ? null : mergedSegmentWarmerPrimaryStats.getTotalSentSize());
import org.opensearch.index.merge.MergedSegmentWarmerStats;
            table.addCell(totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getDeleteCurrent());
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getConcurrentQueryTime());
            final Iterator<String> settingsMapIter = indexSettingsMap.keySet().iterator();
        );
            );
            "sibling:pri;alias:sqc,searchQueryCurrent;default:false;text-align:right;desc:current query phase ops"
import static java.util.Arrays.asList;
        table.addCell("pri.search.fetch_total", "default:false;text-align:right;desc:total fetch ops");
            "alias:sysdesc;" + systemColumnDefault + "desc:description from the matching system index descriptor"
            "get.missing_time",
                                            ActionListener.wrap(groupedListener::onResponse, groupedListener::onFailure)
                    Table responseTable = buildTable(
        );
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getQueryCount());
        );
    @Override
import java.time.ZonedDateTime;
        final ClusterStateResponse clusterStateResponse,
            table.addCell(indexMetadata.getCreationDate());
        table.addCell("suggest.time", "sibling:pri;alias:suti,suggestTime;default:false;text-align:right;desc:time spend in suggest");
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getStarTreeQueryCurrent());
            }
            table.addCell(primaryStats.getMerge() == null ? null : primaryStats.getMerge().getTotalNumDocs());
            "sibling:pri;alias:stqc,startreeQueryCurrent;default:false;text-align:right;desc:current star tree query ops"
            "sibling:pri;alias:sfc,searchFetchCurrent;default:false;text-align:right;desc:current fetch phase ops"
        table.addCell("rep", "alias:r,shards.replica,shardsReplica;text-align:right;desc:number of replica shards");
        table.addCell("merges.current", "sibling:pri;alias:mc,mergesCurrent;default:false;text-align:right;desc:number of current merges");
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getFetchTime());
        table.addCell(
    }
            }
        table.addCell("pri.search.point_in_time_current", "default:false;text-align:right;desc:open point in time contexts");
                                    // rest request and unresolved, while for paginated queries, it would be a list of indices
        );
        table.addCell("pri.indexing.index_failed", "default:false;text-align:right;desc:number of failed indexing ops");
        table.addCell("pri.indexing.index_total", "default:false;text-align:right;desc:number of indexing ops");
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getQueryTime());
            "request_cache.hit_count",
            table.addCell(mergedSegmentWarmerTotalStats == null ? null : mergedSegmentWarmerTotalStats.getTotalFailureCount());
            table.addCell(primaryStats.getIndexing() == null ? null : primaryStats.getIndexing().getTotal().getIndexCount());
            "sibling:pri;alias:stqf,startreeQueryFailed;default:false;text-align:right;desc:failed star tree query phase ops"
        table.addCell(
                health = indexHealth.getStatus().toString().toLowerCase(Locale.ROOT);
        table.addCell("pri.search.point_in_time_total", "default:false;text-align:right;desc:completed point in time contexts");
                        pageToken
    static {
            table.addCell(totalStats.getMerge() == null ? null : totalStats.getMerge().getCurrent());
        table.addCell(
        final Map<String, ClusterIndexHealth> indicesHealths,
            }
        table.addCell("pri.indexing.delete_current", "default:false;text-align:right;desc:number of current deletions");
            table.addCell(totalStats.getSegments() == null ? null : totalStats.getSegments().getIndexWriterMemory());
        table.addCell("search.throttled", "alias:sth;default:false;desc:indicates if the index is search throttled");
        table.addCell(
            }
        );
            "sibling:pri;alias:scqti,searchConcurrentQueryTime;default:false;text-align:right;desc:time spent in concurrent query phase"
                                        groupedListener.onResponse(IndicesStatsResponse.getEmptyResponse());
        table.addCell(
        request.indicesOptions(indicesOptions);
        final ClusterStateRequest request = new ClusterStateRequest();
import org.opensearch.rest.action.list.AbstractListAction;
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getScrollCurrent());
                throw new OpenSearchParseException(DUPLICATE_PARAMETER_ERROR_MESSAGE);
     * indices or non replicated closed indices are not reported in indices stats response).
            table.addCell(primaryStats.getGet() == null ? null : primaryStats.getGet().getExistsCount());
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getOpenContexts());
        return Objects.nonNull(paginationStrategy) && paginationStrategy.getRequestedEntities().isEmpty();
            "suggest.current",
            "sibling:pri;alias:scqc,searchConcurrentQueryCurrent;default:false;text-align:right;desc:current concurrent query phase ops"
        table.addCell("pri.suggest.total", "default:false;text-align:right;desc:number of suggest ops");
 * specific language governing permissions and limitations
            "alias:last_index_ts_string,lastIndexRequestTimestampString;default:false;text-align:right;desc:timestamp of the last processed index request (ISO8601 string)"
            table.addCell(totalStats.getGet() == null ? null : totalStats.getGet().current());
                                    }
        table.addCell(
        table.addCell("pri.search.scroll_time", "default:false;text-align:right;desc:time scroll contexts held open");
                if (indexHealth != null) {
     * as it does not provide information for all existing indices (for example recovering
        table.addCell("docs.count", "alias:dc,docsCount;text-align:right;desc:available docs");
            "sibling:pri;alias:sqti,searchQueryTime;default:false;text-align:right;desc:time spent in query phase"
        );
 *
            "search.scroll_current",
                        indicesSettings,
            table.addCell(mergedSegmentWarmerPrimaryStats == null ? null : mergedSegmentWarmerPrimaryStats.getOngoingCount());
                                    groupedListener.onResponse(getSettingsResponse);
            "sibling:pri;alias:scqto,searchConcurrentQueryTotal;default:false;text-align:right;desc:total query phase ops"
        return getTableWithHeader(request, null);
                    public void onResponse(final GetSettingsResponse getSettingsResponse) {
        table.addCell("pri.search.scroll_current", "default:false;text-align:right;desc:open scroll contexts");
            } else {
        final IndicesOptions indicesOptions,
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
            "segments.fixed_bitset_memory",
        return false;
import org.opensearch.common.collect.Tuple;
        final boolean local,
            @Override
            table.addCell(primaryStats.getRequestCache() == null ? null : primaryStats.getRequestCache().getHitCount());
            table.addCell(totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getIndexTime());
        table.addCell("pri.warmer.current", "default:false;text-align:right;desc:current warmer ops");
    private void sendClusterHealthRequest(
            "sibling:pri;alias:idti,indexingDeleteTime;default:false;text-align:right;desc:time spent in deletions"
        table.addCell("get.total", "sibling:pri;alias:gto,getTotal;default:false;text-align:right;desc:number of get ops");
        );
 */
            "merges.warmer.total_send_time",
            table.addCell(primaryStats.getStore() == null ? null : primaryStats.getStore().size());
                }
            "sibling:pri;alias:qcm,queryCacheMemory;default:false;text-align:right;desc:used query cache"
            table.addCell(totalStats.getWarmer() == null ? null : totalStats.getWarmer().total());
                + " field types and type filters for types referred in _parent fields"
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getStarTreeQueryFailed());
        );
        );
            "default:false;text-align:right;desc:total wallclock time spent receiving merged segments by a replica shard"
        client.admin().cluster().state(request, listener);
            "sibling:pri;alias:mcs,mergesCurrentSize;default:false;text-align:right;desc:size of current merges"
    public List<Route> routes() {
            table.addCell(primaryStats.getMerge() == null ? null : primaryStats.getMerge().getTotalTime());
                listener.onFailure(e);
        final TimeValue clusterManagerNodeTimeout,
import java.util.stream.StreamSupport;
    private static final DateFormatter STRICT_DATE_TIME_FORMATTER = DateFormatter.forPattern("strict_date_time");
                    ).collect(Collectors.toMap(indexMetadata -> indexMetadata.getIndex().getName(), Function.identity()));
                        indicesStates,
        final IndicesOptions indicesOptions,
            "sibling:pri;alias:rce,requestCacheEvictions;default:false;text-align:right;desc:request cache evictions"
                                        sendIndicesStatsRequest(
            deprecationLogger.deprecate("cat_indices_master_timeout_parameter", MASTER_TIMEOUT_DEPRECATED_MESSAGE);
 * the Apache License, Version 2.0 (the "License"); you may
            table.endRow();
            "segments.index_writer_memory",
            table.addCell(primaryStats.getMerge() == null ? null : primaryStats.getMerge().getTotal());
                }
            table.addCell(primaryStats.getSegments() == null ? null : primaryStats.getSegments().getBitsetMemory());
        );
    }
            table.addCell(totalStats.getFlush() == null ? null : totalStats.getFlush().getTotalTime());
        final NodeClient client,
import java.time.ZoneOffset;
        );
    protected Table getTableWithHeader(final RestRequest request) {
                    IndicesStatsResponse statsResponse = extractResponse(responses, IndicesStatsResponse.class);
        request.includeUnloadedSegments(includeUnloadedSegments);
            "refresh.external_total",
        table.addCell(
            table.addCell(mergedSegmentWarmerPrimaryStats == null ? null : mergedSegmentWarmerPrimaryStats.getTotalTime());
            "default:false;text-align:right;desc:total bytes received by a replica shard during the warm operation"
    public boolean allowSystemIndexAccessByDefault() {
            table.addCell(totalStats.getGet() == null ? null : totalStats.getGet().getMissingCount());
        table.addCell("pri.search.query_current", "default:false;text-align:right;desc:current query phase ops");
     * Provides the iterator to be used for building the response table.
                    INDICES,
        );
    @Override
        final IndicesOptions indicesOptions = getIndicesOptions(request);
            "sibling:pri;alias:rchc,requestCacheHitCount;default:false;text-align:right;desc:request cache hit count"
                    return RestTable.buildResponse(table, channel);
            "sibling:pri;alias:iito,indexingIndexTotal;default:false;text-align:right;desc:number of indexing ops"
    @Override
            table.addCell(primaryStats.getWarmer() == null ? null : primaryStats.getWarmer().totalTime());
                limitBreached = matchingIndices > limit;
            "sibling:pri;alias:stqto,startreeQueryCurrent;default:false;text-align:right;desc:total star tree resolved queries"
        table.addCell(
            table.addCell(indexHealth == null ? null : indexHealth.getNumberOfShards());
        final ActionListener<GetSettingsResponse> listener
                                    sendClusterHealthRequest(
            "query_cache.evictions",
    @Override
    }
        table.addCell("pri.search.concurrent_query_total", "default:false;text-align:right;desc:total query phase ops");
            "pri.merges.warmer.ongoing_count",
                public RestResponse buildResponse(final Table table) throws Exception {
                );
        table.addCell(
                            indices,
     */
import java.util.Iterator;
        table.addCell("pri.fielddata.evictions", "default:false;text-align:right;desc:fielddata evictions");
            "merges.current_docs",
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getPitCurrent());
                        // type of request in the presence of security plugins (looking at you, ClusterHealthRequest), so
            "sibling:pri;alias:scti,searchPointInTimeTime;default:false;text-align:right;desc:time point in time contexts held open"
            "fielddata.evictions",
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
import java.util.Collection;
     * This is because the Cluster State and Cluster Health APIs do not filter output based
        );
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getOpenContexts());
        );
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getQueryCurrent());
    ) {
        table.addCell(
        table.addCell("get.current", "sibling:pri;alias:gc,getCurrent;default:false;text-align:right;desc:number of current get ops");
                        // 1) the deleted index was explicitly passed as parameter to the /_cat/indices request. In this case we
            table.addCell(totalStats.getWarmer() == null ? null : totalStats.getWarmer().current());
            if (indexStats == null || indexState == IndexMetadata.State.CLOSE) {
        );
            "sibling:pri;alias:suc,suggestCurrent;default:false;text-align:right;desc:number of current suggest ops"
                                            indicesToBeQueried,
            table.addCell(primaryStats.getSegments() == null ? null : primaryStats.getSegments().getCount());
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getSuggestTime());
        final NodeClient client,
                        // All the other requests just provide additional detail, and wildcards may be resolved differently depending on the
        sb.append("/_cat/indices/{index}\n");
        table.addCell(
        table.addCell(
/**
     * We're using the Get Settings API here to resolve the authorized indices for the user.
            if (systemParam != null && systemParam != indexMetadata.isSystem()) {
        );
        );
        table.addCell(
        table.addCell("pri.get.missing_time", "default:false;text-align:right;desc:time spent in failed gets");
import org.opensearch.common.breaker.ResponseLimitBreachedException;
                            new ActionListener<ClusterStateResponse>() {
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getSuggestCount());
            table.addCell(primaryStats.getWarmer() == null ? null : primaryStats.getWarmer().current());
            final IndexMetadata.State indexState = indexMetadata.getState();
        );
                                    );
                continue;
            "sibling:pri;alias:qce,queryCacheEvictions;default:false;text-align:right;desc:query cache evictions"
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
        table.addCell(
            table.addCell(totalStats.getRefresh() == null ? null : totalStats.getRefresh().getListeners());
import java.util.Map;
 * software distributed under the License is distributed on an
            table.addCell(totalStats.getRequestCache() == null ? null : totalStats.getRequestCache().getEvictions());
import java.util.Set;
        this.systemIndices = systemIndices;
        final boolean local,
        table.addCell(
        table.addCell(
            "sibling:pri;alias:fe,fielddataEvictions;default:false;text-align:right;desc:fielddata evictions"
            @Override
        table.addCell("flush.total_time", "sibling:pri;alias:ftt,flushTotalTime;default:false;text-align:right;desc:time spent in flush");
        table.addCell("pri.search.concurrent_query_current", "default:false;text-align:right;desc:current concurrent query phase ops");
            "last_index_request_timestamp",
            final ActionListener<Table> listener = ActionListener.notifyOnce(new RestResponseListener<Table>(channel) {
        );
        table.addCell("segments.memory", "sibling:pri;alias:sm,segmentsMemory;default:false;text-align:right;desc:memory used by segments");
        table.addCell(
            "sibling:pri;alias:scto,searchPointInTimeTotal;default:false;text-align:right;desc:completed point in time contexts"
                indices,
        table.addCell("pri.merges.total_size", "default:false;text-align:right;desc:size merged");
            "pri.merges.warmer.total_invocations",
                clusterManagerNodeTimeout,
            table.addCell(primaryStats.getFlush() == null ? null : primaryStats.getFlush().getTotal());
                        final IndicesOptions subRequestIndicesOptions = IndicesOptions.lenientExpandHidden();
        "Please only use one of the request parameters [master_timeout, cluster_manager_timeout].";
            @Override
        table.addCell("refresh.time", "sibling:pri;alias:rti,refreshTime;default:false;text-align:right;desc:time spent in refreshes");
        );
                indicesOptions,
            "search.fetch_time",
        table.addCell("pri.merges.current_docs", "default:false;text-align:right;desc:number of current merging docs");
        table.addCell("pri.indexing.delete_total", "default:false;text-align:right;desc:number of delete ops");
            table.addCell(indexHealth == null ? null : indexHealth.getNumberOfReplicas());
    // package private for testing
    }
import org.opensearch.cluster.health.ClusterHealthStatus;
        table.addCell(
        client.admin().indices().stats(request, listener);
        table.addCell(
    }
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getPitCount());
            table.addCell(mergedSegmentWarmerTotalStats == null ? null : mergedSegmentWarmerTotalStats.getTotalSendTime());
        table.addCell(
     */
 * this file be licensed under the Apache-2.0 license or a
        table.addCell("completion.size", "sibling:pri;alias:cs,completionSize;default:false;text-align:right;desc:size of completion");
            }
        final String[] indices,
                                    groupedListener.onResponse(clusterStateResponse);
     * on index privileges, so they can't be used to determine which indices are authorized
import java.time.Instant;
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getQueryCount());
        table.addCell(
            }
            if (systemParam == null) {
            });
    }
            }
        request.indices(indices);
import org.opensearch.OpenSearchParseException;
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getSuggestTime());
                                            includeUnloadedSegments,
                            }
            "refresh.external_time",
 */
            ZonedDateTime creationTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(indexMetadata.getCreationDate()), ZoneOffset.UTC);
                    Map<String, Settings> indicesSettings = StreamSupport.stream(
                ? null
        table.addCell("pri.segments.count", "default:false;text-align:right;desc:number of segments");
            table.addCell(primaryStats.getGet() == null ? null : primaryStats.getGet().getMissingTime());
            } else {
            "last_index_request_timestamp_string",
            table.addCell(
            sendGetSettingsRequest(
                    onFailure(e);
            "merges.warmer.total_time",
                                        listener,
        final PageToken pageToken
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
        table.addCell(
                    Map<String, IndexStats> indicesStats = statsResponse.getIndices();
            "sibling:pri;alias:geto,getExistsTotal;default:false;text-align:right;desc:number of successful gets"
            table.addCell(primaryStats.getIndexing() == null ? null : primaryStats.getIndexing().getTotal().getIndexFailedCount());
                            subRequestIndicesOptions,
            table.addCell(totalStats.getRefresh() == null ? null : totalStats.getRefresh().getExternalTotal());
            SystemIndexDescriptor descriptor = indexName.startsWith(".") ? systemIndices.findMatchingDescriptor(indexName) : null;
                totalStats = new CommonStats();
        table.addCell(
            table.addCell(totalStats.getSegments() == null ? null : totalStats.getSegments().getZeroMemory());
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getConcurrentAvgSliceCount());
        if (isRequestLimitCheckSupported() && Objects.nonNull(clusterStateResponse) && Objects.nonNull(clusterStateResponse.getState())) {
        table.addCell("pri.refresh.time", "default:false;text-align:right;desc:time spent in refreshes");
                : totalStats.getMerge().getWarmerStats();
            "get.missing_total",
        request.indices(indices);
            "sibling:pri;alias:rli,refreshListeners;default:false;text-align:right;desc:number of pending refresh listeners"
        table.addCell(
    public String getName() {
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getFetchCount());
    }
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        final String[] indicesToBeQueried,
                    skip = ClusterHealthStatus.RED != healthStatusFilter;
        final String[] indices,
            "sibling:pri;alias:rcm,requestCacheMemory;default:false;text-align:right;desc:used request cache"
        request.local(local);
            "sibling:pri;alias:gmti,getMissingTime;default:false;text-align:right;desc:time spent in failed gets"
        );
    static IndicesOptions getIndicesOptions(final RestRequest request) {
            "alias:mswtbs,mergedSegmentWarmerTotalBytesSent;default:false;text-align:right;desc:total bytes sent by a primary shard during the warm operation"
        final Iterator<Tuple<String, Settings>> tableIterator,
            table.addCell(totalStats.getRefresh() == null ? null : totalStats.getRefresh().getTotalTime());
        );
                                    listener.onFailure(e);
    }
                } else {
 * The OpenSearch Contributors require contributions made to
                                    // already resolved by ClusterStateRequest and to be displayed in a page.
        request.all();
        table.addCell(
        table.addCell("pri.get.exists_time", "default:false;text-align:right;desc:time spent in successful gets");
import static java.util.Collections.unmodifiableList;
                primaryStats = indexStats.getPrimaries();
                        // request (strictExpand).
        table.addCell("pri.completion.size", "default:false;text-align:right;desc:size of completion");
        table.startHeaders();
            table.addCell(primaryStats.getSegments() == null ? null : primaryStats.getSegments().getIndexWriterMemory());
        table.addCell(
        table.addCell("pri.search.scroll_total", "default:false;text-align:right;desc:completed scroll contexts");
            if (request.hasParam("cluster_manager_timeout")) {
        final String healthParam = request.param("health");
        table.addCell(
            MergedSegmentWarmerStats mergedSegmentWarmerTotalStats = totalStats.getMerge() == null
                    }
            "search.scroll_total",
            "sibling:pri;alias:stqti,startreeQueryTime;default:false;text-align:right;desc:time spent in star tree queries"
        final RestRequest request,
        table.addCell(
                    .count();
