        TimeValue clusterManagerTimeout = request.paramAsTime("cluster_manager_timeout", DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT);  
                clusterManagerNodeTimeout,  
        return "cat_indices_action";
        table.addCell("pri.suggest.time", "default:false;text-align:right;desc:time spend in suggest");
            final CommonStats primaryStats;
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getConcurrentQueryCurrent());
        table.addCell(
            "query_cache.evictions",  
package org.opensearch.rest.action.cat;
            "sibling:pri;alias:geti,getExistsTime;default:false;text-align:right;desc:time spent in successful gets"
        final String[] indicesToBeQueried,  
        );
            table.addCell(primaryStats.getMerge() == null ? null : primaryStats.getMerge().getTotalTime());
            "sibling:pri;alias:wtt,warmerTotalTime;default:false;text-align:right;desc:time spent in warmers"  
            "search.query_time",  
            "sibling:pri;alias:sfti,searchFetchTime;default:false;text-align:right;desc:time spent in fetch phase"
                health = "red*";
        final boolean local,  
                indices,  
            "merges.warmer.total_invocations",  
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getSuggestTime());
                    INDICES,  
        while (tableIterator.hasNext()) {
        request.indicesOptions(indicesOptions);
        table.addCell("pri.search.query_time", "default:false;text-align:right;desc:time spent in query phase");  
        final IndicesOptions indicesOptions,
            "indexing.index_time",  
    private final SystemIndices systemIndices;
        table.addCell("flush.total_time", "sibling:pri;alias:ftt,flushTotalTime;default:false;text-align:right;desc:time spent in flush");
        final int size,
            "default:false;text-align:right;desc:point-in-time metric for number of in-progress warm operations"
            } else if (limit > 0) {  
        final NodeClient client,
    }
        table.addCell("pri.store.size", "text-align:right;desc:store size of primaries");  
            "merges.warmer.total_receive_time",  
        table.addCell("pri.memory.total", "default:false;text-align:right;desc:total user memory");
    }
     * as it does not provide information for all existing indices (for example recovering  
        final ActionListener<GetSettingsResponse> listener  
        table.addCell("pri.search.point_in_time_current", "default:false;text-align:right;desc:open point in time contexts");  
            "alias:mswoc,mergedSegmentWarmerOngoingCount;default:false;text-align:right;desc:point-in-time metric for number of in-progress warm operations"
    }  
            table.addCell(descriptor == null ? null : descriptor.getDescription());  
            table.addCell(totalStats.getRefresh() == null ? null : totalStats.getRefresh().getTotalTime());
                health = indexHealth.getStatus().toString().toLowerCase(Locale.ROOT);
        final ActionListener<ClusterStateResponse> listener  
        );
        );
        RESPONSE_PARAMS = Collections.unmodifiableSet(responseParams);
            "merges.warmer.total_bytes_sent",  
     * or not. On top of this, the Indices Stats API cannot be used either to resolve indices
                        // subsequent cluster state, cluster health and indices stats requests execute. We have to distinguish two cases:
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getPitTime());
        table.addCell("docs.count", "alias:dc,docsCount;text-align:right;desc:available docs");
    private static final String DUPLICATE_PARAMETER_ERROR_MESSAGE =
            table.addCell(primaryStats.getFlush() == null ? null : primaryStats.getFlush().getTotal());
            table.addCell(totalStats.getSegments() == null ? null : totalStats.getSegments().getVersionMapMemory());
 *
    }
        table.addCell("pri.warmer.total", "default:false;text-align:right;desc:total warmer ops");
        table.addCell(
        table.addCell(
            table.addCell(primaryStats.getCompletion() == null ? null : primaryStats.getCompletion().getSize());
        );
        );
            }  
            table.addCell(primaryStats.getMerge() == null ? null : primaryStats.getMerge().getTotal());
        final IndicesOptions defaultIndicesOptions = request.paramAsBoolean("system", false)
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
            );
                        // All the other requests just provide additional detail, and wildcards may be resolved differently depending on the  
        table.addCell("health", "alias:h;desc:current health status");
            table.addCell(primaryStats.getRefresh() == null ? null : primaryStats.getRefresh().getExternalTotal());
        table.addCell(
        );
        );  
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getConcurrentAvgSliceCount());
                : totalStats.getMerge().getWarmerStats();
            "merges.warmer.ongoing_count",  
        table.addCell(
        request.indices(indices);
        );
 * You may obtain a copy of the License at  
                final ClusterHealthStatus healthStatusFilter = ClusterHealthStatus.fromString(healthParam);
            table.addCell(mergedSegmentWarmerTotalStats == null ? null : mergedSegmentWarmerTotalStats.getTotalTime());
        table.addCell(
 * ownership. Elasticsearch licenses this file to you under  
        request.indices(indices);  
            table.addCell(primaryStats.getIndexing() == null ? null : primaryStats.getIndexing().getTotal().getDeleteTime());
                        indicesStates,  
        );
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getSuggestCurrent());
        table.addCell("pri.flush.total", "default:false;text-align:right;desc:number of flushes");  
    private static final Set<String> RESPONSE_PARAMS;
            "sibling:pri;alias:mtt,mergesTotalTime;default:false;text-align:right;desc:time spent in merges"
            table.addCell(totalStats.getCompletion() == null ? null : totalStats.getCompletion().getSize());  
                        // type of request in the presence of security plugins (looking at you, ClusterHealthRequest), so
                            subRequestIndicesOptions,  
            "search.startree_query_failed",  
        final Table table = getTableWithHeader(request, pageToken);
        table.addCell("pri.indexing.index_time", "default:false;text-align:right;desc:time spent in indexing");  
            table.addCell(primaryStats.getMerge() == null ? null : primaryStats.getMerge().getCurrentNumDocs());
            table.addCell(primaryStats.getIndexing() == null ? null : primaryStats.getIndexing().getTotal().getIndexCount());
            table.addCell(mergedSegmentWarmerTotalStats == null ? null : mergedSegmentWarmerTotalStats.getTotalInvocationsCount());
import java.util.List;
        final Map<String, IndexStats> indicesStats,
            "sibling:pri;alias:mcs,mergesCurrentSize;default:false;text-align:right;desc:size of current merges"
        );
            "sibling:pri;alias:mcd,mergesCurrentDocs;default:false;text-align:right;desc:number of current merging docs"
        );
                    limit
        final TimeValue clusterManagerNodeTimeout = clusterManagerTimeout;  
    private GroupedActionListener<ActionResponse> createGroupedListener(
            "default:false;text-align:right;desc:total invocations of merged segment warmer"
    }
        table.addCell(
            table.addCell(totalStats.getWarmer() == null ? null : totalStats.getWarmer().current());
                        // force the IndicesOptions for all the sub-requests to be as inclusive as possible.
        );
 * GitHub history for details.
        table.addCell(
    public boolean allowSystemIndexAccessByDefault() {  
                + " field types and type filters for types referred in _parent fields"
            table.addCell(primaryStats.getWarmer() == null ? null : primaryStats.getWarmer().total());
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getFetchCurrent());
            "sibling:pri;alias:scc,searchPointInTimeCurrent;default:false;text-align:right;desc:open point in time contexts"
    private void sendIndicesStatsRequest(  
    }
        table.addCell("pri.search.concurrent_query_time", "default:false;text-align:right;desc:time spent in concurrent query phase");  
     * We're using the Get Settings API here to resolve the authorized indices for the user.
            "get.missing_time",  
    public boolean isActionPaginated() {
            table.addCell(totalStats.getWarmer() == null ? null : totalStats.getWarmer().total());
                                }  
 * Licensed to Elasticsearch under one or more contributor  
            "system.description",  
        table.addCell("suggest.time", "sibling:pri;alias:suti,suggestTime;default:false;text-align:right;desc:time spend in suggest");
/*  
            "merges.current_docs",  
        request.indicesOptions(indicesOptions);
            final CommonStats totalStats;
    }
            "sibling:pri;alias:scto,searchPointInTimeTotal;default:false;text-align:right;desc:completed point in time contexts"
        table.addCell("pri.search.point_in_time_total", "default:false;text-align:right;desc:completed point in time contexts");  
 * the Apache License, Version 2.0 (the "License"); you may
    private static final DateFormatter STRICT_DATE_TIME_FORMATTER = DateFormatter.forPattern("strict_date_time");
                public RestResponse buildResponse(final Table table) throws Exception {  
    ) {
            "search.startree_query_total",  
    }  
                    @Override  
                                    // avoid fetching indices stats.
        return new GroupedActionListener<>(new ActionListener<Collection<ActionResponse>>() {  
 * Modifications Copyright OpenSearch Contributors. See
        table.addCell("pri", "alias:p,shards.primary,shardsPrimary;text-align:right;desc:number of primary shards");  
            table.addCell(totalStats.getGet() == null ? null : totalStats.getGet().getMissingCount());  
        table.addCell("creation.date", "alias:cd;default:false;desc:index creation date (millisecond value)");
        table.addCell("pri.indexing.delete_time", "default:false;text-align:right;desc:time spent in deletions");  
            if (request.hasParam("cluster_manager_timeout")) {
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getConcurrentQueryTime());
        table.addCell("merges.total_size", "sibling:pri;alias:mts,mergesTotalSize;default:false;text-align:right;desc:size merged");
        table.addCell("warmer.current", "sibling:pri;alias:wc,warmerCurrent;default:false;text-align:right;desc:current warmer ops");
            "sibling:pri;alias:idti,indexingDeleteTime;default:false;text-align:right;desc:time spent in deletions"
    public boolean isRequestLimitCheckSupported() {
            int limit = responseLimitSettings.getCatIndicesResponseLimit();
            table.addCell(totalStats.getSegments() == null ? null : totalStats.getSegments().getBitsetMemory());
                                        4,
        final Boolean systemParam = request.hasParam("system") ? request.paramAsBoolean("system", false) : null;
        final RestRequest request,  
        table.addCell(
import org.opensearch.action.pagination.PageToken;
        return true;
            table.addCell(mergedSegmentWarmerPrimaryStats == null ? null : mergedSegmentWarmerPrimaryStats.getTotalReceiveTime());
                                        );
            "indexing.index_total",  
import java.util.Spliterators;
            public void onResponse(final Collection<ActionResponse> responses) {
            "sibling:pri;alias:rcmc,requestCacheMissCount;default:false;text-align:right;desc:request cache miss count"
                                    }  
    protected Set<String> responseParams() {
                    ClusterStateResponse stateResponse = extractResponse(responses, ClusterStateResponse.class);
            table.addCell(totalStats.getSegments() == null ? null : totalStats.getSegments().getCount());
            "alias:sysdesc;" + systemColumnDefault + "desc:description from the matching system index descriptor"
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getScrollCurrent());
    @Override
                    Map<String, ClusterIndexHealth> indicesHealths = healthResponse.getIndices();
                                            includeUnloadedSegments,
            "sibling:pri;alias:scti,searchScrollTime;default:false;text-align:right;desc:time scroll contexts held open"
        table.addCell("pri.query_cache.evictions", "default:false;text-align:right;desc:query cache evictions");  
        table.addCell("merges.current", "sibling:pri;alias:mc,mergesCurrent;default:false;text-align:right;desc:number of current merges");
        if (request.hasParam("master_timeout")) {
                    Map<String, IndexStats> indicesStats = statsResponse.getIndices();
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getFetchCount());
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getSuggestCurrent());
     */  
        request.clusterManagerNodeTimeout(clusterManagerNodeTimeout);  
import org.opensearch.common.breaker.ResponseLimitBreachedException;
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getScrollCount());
        table.addCell("pri.search.scroll_current", "default:false;text-align:right;desc:open scroll contexts");  
            table.addCell(primaryStats.getQueryCache() == null ? null : primaryStats.getQueryCache().getMemorySize());
            table.addCell(primaryStats.getRequestCache() == null ? null : primaryStats.getRequestCache().getHitCount());
            "sibling:pri;alias:scqc,searchConcurrentQueryCurrent;default:false;text-align:right;desc:current concurrent query phase ops"
                        indicesStats,
                                        groupedListener.onResponse(IndicesStatsResponse.getEmptyResponse());  
            "sibling:pri;alias:gmto,getMissingTotal;default:false;text-align:right;desc:number of failed gets"
            "sibling:pri;alias:rchc,requestCacheHitCount;default:false;text-align:right;desc:request cache hit count"
                boolean skip;
import org.opensearch.action.support.GroupedActionListener;
                                        indicesToBeQueried,  
            "warmer.total_time",
        table.addCell(
import org.opensearch.core.common.Strings;
            "segments.version_map_memory",  
                // TODO: expose docs stats for replicated closed indices
            "get.exists_total",  
                    skip = ClusterHealthStatus.RED != healthStatusFilter;
        table.addCell("pri.merges.total_time", "default:false;text-align:right;desc:time spent in merges");  
        table.addCell("segments.count", "sibling:pri;alias:sc,segmentsCount;default:false;text-align:right;desc:number of segments");
            table.startRow();  
            "request_cache.miss_count",  
        table.addCell(
                                        request,  
            "default:false;text-align:right;desc:total failures in merged segment warmer"
        );
            "search.point_in_time_total",  
            table.addCell(primaryStats.getQueryCache() == null ? null : primaryStats.getQueryCache().getEvictions());
            "suggest.current",
 * The OpenSearch Contributors require contributions made to  
            "sibling:pri;alias:suc,suggestCurrent;default:false;text-align:right;desc:number of current suggest ops"  
            table.addCell(indexState.toString().toLowerCase(Locale.ROOT));
                                        indicesToBeQueried,  
                    .filter(indexMetadata -> indexMetadata.isSystem() == systemParam)
                                    if (shouldSkipIndicesStatsRequest(paginationStrategy)) {
                        final IndicesOptions subRequestIndicesOptions = IndicesOptions.lenientExpandHidden();  
        );
 * license agreements. See the NOTICE file distributed with
                                @Override
import org.opensearch.action.admin.indices.stats.CommonStats;
        );  
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getStarTreeQueryCount());
        table.addCell("creation.date.string", "alias:cds;default:false;desc:index creation date (as string)");  
import org.opensearch.cluster.metadata.IndexMetadata;  
                        Spliterators.spliterator(settingsResponse.getIndexToSettings().entrySet(), 0),  
    @SuppressWarnings("unchecked")
        table.addCell(
                    Map<String, IndexMetadata> indicesStates = StreamSupport.stream(
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;  
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getStarTreeQueryCount());
            table.addCell(mergedSegmentWarmerPrimaryStats == null ? null : mergedSegmentWarmerPrimaryStats.getTotalSentSize());
        table.addCell(
                }
            }
                } catch (Exception e) {
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getSuggestCount());
            table.addCell(primaryStats.getSegments() == null ? null : primaryStats.getSegments().getVersionMapMemory());
            "alias:last_index_ts_string,lastIndexRequestTimestampString;default:false;text-align:right;desc:timestamp of the last processed index request (ISO8601 string)"  
        table.addCell("merges.total_docs", "sibling:pri;alias:mtd,mergesTotalDocs;default:false;text-align:right;desc:docs merged");
            table.addCell(totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getIndexCount());  
    private void sendGetSettingsRequest(  
            clusterManagerTimeout = request.paramAsTime("master_timeout", DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT);
        client.admin().indices().stats(request, listener);
            "sibling:pri;alias:rli,refreshListeners;default:false;text-align:right;desc:number of pending refresh listeners"
    @Override
            table.addCell(totalStats.getGet() == null ? null : totalStats.getGet().getExistsCount());  
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getQueryCurrent());
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getQueryTime());
    private static final String MASTER_TIMEOUT_DEPRECATED_MESSAGE =  
            "sibling:pri;alias:gmti,getMissingTime;default:false;text-align:right;desc:time spent in failed gets"
        table.addCell("pri.merges.current_docs", "default:false;text-align:right;desc:number of current merging docs");  
        table.addCell(  
                long matchingIndices = StreamSupport.stream(clusterStateResponse.getState().getMetadata().spliterator(), false)
        table.addCell(
            }
        table.addCell("pri.search.open_contexts", "default:false;text-align:right;desc:open search contexts");  
            table.addCell(primaryStats.getWarmer() == null ? null : primaryStats.getWarmer().current());
        );
                }  
            "default:false;text-align:right;desc:memory used by fixed bit sets for nested object"  
            "search.point_in_time_time",  
        );  
            } else {
        };  
    }
                                            indicesToBeQueried,  
            table.addCell(primaryStats.getGet() == null ? null : primaryStats.getGet().getCount());
import org.opensearch.action.admin.indices.stats.IndicesStatsRequest;
            "sibling:pri;alias:casc,searchConcurrentAvgSliceCount;default:false;text-align:right;desc:average query concurrency"
        );
        table.addCell("refresh.time", "sibling:pri;alias:rti,refreshTime;default:false;text-align:right;desc:time spent in refreshes");
        table.addCell("pri.suggest.total", "default:false;text-align:right;desc:number of suggest ops");
            "sibling:pri;alias:geto,getExistsTotal;default:false;text-align:right;desc:number of successful gets"
        );
            "default:false;text-align:right;desc:total bytes received by a replica shard during the warm operation"
            table.addCell(totalStats.getRefresh() == null ? null : totalStats.getRefresh().getExternalTotal());
        table.addCell("pri.search.startree.query_current", "default:false;text-align:right;desc:current star tree query ops");  
        table.addCell(
        table.addCell(
        );
    public List<Route> routes() {
            "sibling:pri;alias:qce,queryCacheEvictions;default:false;text-align:right;desc:query cache evictions"
 * this work for additional information regarding copyright
        table.addCell("completion.size", "sibling:pri;alias:cs,completionSize;default:false;text-align:right;desc:size of completion");
            table.addCell(totalStats.getSegments() == null ? null : totalStats.getSegments().getZeroMemory());
        table.addCell(
        table.addCell(  
        );
        table.addCell(
            table.addCell(primaryStats.getSegments() == null ? null : primaryStats.getSegments().getCount());
        table.addCell(
    }
            table.addCell(primaryStats.getIndexing() == null ? null : primaryStats.getIndexing().getTotal().getIndexTime());
     * This is because the Cluster State and Cluster Health APIs do not filter output based  
            "last_index_request_timestamp",
            "alias:mswti,mergedSegmentWarmerTotalInvocations;default:false;text-align:right;desc:total invocations of merged segment warmer"
import java.util.HashSet;  
        final GetSettingsRequest request = new GetSettingsRequest();
        request.indices(indices);  
            "pri.merges.warmer.total_send_time",
            table.addCell(indexMetadata.getCreationDate());
                                        : paginationStrategy.getRequestedEntities().toArray(new String[0]);
    ) {
        );
import java.util.function.Function;
    }
            "indexing.delete_current",  
import org.opensearch.index.IndexSettings;  
            final IndexMetadata indexMetadata = indicesMetadatas.get(indexName);  
        table.addCell("pri.segments.count", "default:false;text-align:right;desc:number of segments");  
                            client,  
            } else if (indexStats != null) {  
        table.addCell("pri.search.fetch_total", "default:false;text-align:right;desc:total fetch ops");  
            "default:false;text-align:right;desc:total wallclock time spent receiving merged segments by a replica shard"
            "alias:last_index_ts,lastIndexRequestTimestamp;default:false;text-align:right;desc:timestamp of the last processed index request (epoch millis)"
        table.addCell("search.fetch_total", "sibling:pri;alias:sfto,searchFetchTotal;default:false;text-align:right;desc:total fetch ops");
        return RESPONSE_PARAMS;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                    listener.onFailure(e);
    }
        table.addCell(
import org.opensearch.rest.RestRequest;
        this.responseLimitSettings = responseLimitSettings;  
        table.addCell(
        table.addCell("pri.search.query_total", "default:false;text-align:right;desc:total query phase ops");  
        return true;
        table.addCell(
            "search.scroll_current",  
            "search.open_contexts",  
import org.opensearch.cluster.health.ClusterIndexHealth;
import org.opensearch.indices.SystemIndices;  
                : primaryStats.getMerge().getWarmerStats();
        return table;
        table.addCell("get.current", "sibling:pri;alias:gc,getCurrent;default:false;text-align:right;desc:number of current get ops");
            "sibling:pri;alias:sqto,searchQueryTotal;default:false;text-align:right;desc:total query phase ops"
    @Override
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getScrollTime());
        table.addCell("status", "alias:s;desc:open/close status");  
/*  
                new ActionListener<GetSettingsResponse>() {
            table.addCell(mergedSegmentWarmerTotalStats == null ? null : mergedSegmentWarmerTotalStats.getTotalFailureCount());
        table.addCell("pri.merges.total", "default:false;text-align:right;desc:number of completed merge ops");  
            table.addCell(totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getIndexFailedCount());  
            "segments.fixed_bitset_memory",  
                        request,
        table.addCell("pri.search.startree.query_total", "default:false;text-align:right;desc:total star tree resolved queries");  
 */  
            "search.concurrent_avg_slice_count",  
            table.addCell(primaryStats.getMerge() == null ? null : primaryStats.getMerge().getTotalNumDocs());
            "sibling:pri;alias:svmm,segmentsVersionMapMemory;default:false;text-align:right;desc:memory used by version map"
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getFetchCount());
            table.addCell(totalStats.getFieldData() == null ? null : totalStats.getFieldData().getMemorySize());  
                                        ActionListener.wrap(groupedListener::onResponse, groupedListener::onFailure)
        );
        table.addCell(
     * on index privileges, so they can't be used to determine which indices are authorized
        table.addCell("pri.suggest.current", "default:false;text-align:right;desc:number of current suggest ops");
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getConcurrentQueryTime());
                    .count();  
        final boolean local,  
                    );  
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getStarTreeQueryTime());
            table.addCell(primaryStats.getRefresh() == null ? null : primaryStats.getRefresh().getListeners());
                limitBreached = ResponseLimitSettings.isResponseLimitBreached(
            table.addCell(totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getDeleteCount());  
        );
            final String health;
                            new ActionListener<ClusterStateResponse>() {
        table.addCell(
            }
        return channel -> {  
        final Boolean systemParam = request.hasParam("system") ? request.paramAsBoolean("system", false) : null;
    static IndicesOptions getIndicesOptions(final RestRequest request) {  
    }  
            table.addCell(totalStats.getMerge() == null ? null : totalStats.getMerge().getTotal());  
import java.time.Instant;
        );
        table.addCell("pri.get.total", "default:false;text-align:right;desc:number of get ops");  
        final IndicesOptions indicesOptions = getIndicesOptions(request);  
        table.addCell("uuid", "alias:id,uuid;desc:index uuid");
            table.addCell(primaryStats.getGet() == null ? null : primaryStats.getGet().getMissingTime());
                    // index health is unknown, skip if we don't explicitly request RED health
            public boolean hasNext() {  
            "sibling:pri;alias:iif,indexingIndexFailed;default:false;text-align:right;desc:number of failed indexing ops"
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestIndicesAction.class);
        // Remove the if condition and statements inside after removing MASTER_ROLE.
        table.addCell("pri.search.startree_query_failed", "default:false;text-align:right;desc:failed star tree query phase ops");  
                                    // For paginated queries, if strategy outputs no indices to be returned,  
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getQueryCurrent());
        );
        final NodeClient client,
        table.addCell("pri.search.query_failed", "default:false;text-align:right;desc:failed query phase ops");  
            "sibling:pri;alias:scti,searchPointInTimeTime;default:false;text-align:right;desc:time point in time contexts held open"
        final String[] indices = Strings.splitStringByCommaToArray(request.param("index"));
            table.addCell(primaryStats.getGet() == null ? null : primaryStats.getGet().getMissingCount());
        table.addCell(
                health = "";  
    @Override
     * Provides the iterator to be used for building the response table.
            table.addCell(totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getMaxLastIndexRequestTimestamp());  
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getQueryFailedCount());
            }
            "sibling:pri;alias:siwm,segmentsIndexWriterMemory;default:false;text-align:right;desc:memory used by index writer"
 *  
        final RestRequest request,
                String index = settingsMapIter.next();  
        );  
        "Parameter [master_timeout] is deprecated and will be removed in 3.0. To support inclusive language, please use [cluster_manager_timeout] instead.";
        client.admin().cluster().health(request, listener);  
        final String[] indices,
                                    groupedListener.onResponse(clusterStateResponse);
        table.addCell("pri.segments.version_map_memory", "default:false;text-align:right;desc:memory used by version map");  
 * Unless required by applicable law or agreed to in writing,
                primaryStats = new CommonStats();  
    private final ResponseLimitSettings responseLimitSettings;  
        );
            "merges.warmer.total_time",  
import org.opensearch.common.breaker.ResponseLimitSettings;  
        table.addCell(
            table.addCell(totalStats.getFieldData() == null ? null : totalStats.getFieldData().getEvictions());  
import java.util.Locale;  
                return new Tuple<>(index, indexSettingsMap.get(index));
        return new Iterator<>() {
            table.addCell(totalStats.getRequestCache() == null ? null : totalStats.getRequestCache().getHitCount());  
            deprecationLogger.deprecate("cat_indices_master_timeout_parameter", MASTER_TIMEOUT_DEPRECATED_MESSAGE);  
            table.addCell(primaryStats.getGet() == null ? null : primaryStats.getGet().current());
        );
            table.addCell(primaryStats.getRequestCache() == null ? null : primaryStats.getRequestCache().getMemorySize());
 */
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getStarTreeQueryTime());
    }  
            table.addCell(totalStats.getMerge() == null ? null : totalStats.getMerge().getTotalNumDocs());  
            final ActionListener<Table> listener = ActionListener.notifyOnce(new RestResponseListener<Table>(channel) {
                if (indexHealth != null) {  
    ) {
        request.local(local);  
    private boolean shouldSkipIndicesStatsRequest(IndexPaginationStrategy paginationStrategy) {  
            "search.fetch_time",  
        request.local(local);
import org.opensearch.rest.action.RestResponseListener;  
                                            client,  
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getStarTreeQueryCurrent());
                limitBreached = false;  
                                        client,
        );
        );  
            table.addCell(indexHealth == null ? null : indexHealth.getNumberOfReplicas());  
            "sibling:pri;alias:stqto,startreeQueryCurrent;default:false;text-align:right;desc:total star tree resolved queries"
        request.indices(indices);
            table.addCell(totalStats.getFlush() == null ? null : totalStats.getFlush().getTotalTime());  
            "pri.merges.warmer.total_bytes_sent",
        table.addCell(
        return table;
        table.addCell(  
            "merges.warmer.total_failure_count",  
            "sibling:pri;alias:so,searchOpenContexts;default:false;text-align:right;desc:open search contexts"
 * specific language governing permissions and limitations
                        );
            );
            "alias:mswtrt,mergedSegmentWarmerTotalReceiveTime;default:false;text-align:right;desc:total wallclock time spent receiving merged segments by a replica shard"
                                    IndexPaginationStrategy paginationStrategy = getPaginationStrategy(clusterStateResponse);
        request.indicesOptions(indicesOptions);
 * software distributed under the License is distributed on an
            table.addCell(totalStats.getGet() == null ? null : totalStats.getGet().getTime());  
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getQueryCount());
        table.addCell(
                                        clusterManagerNodeTimeout,  
    @Override  
    }  
            table.addCell(primaryStats.getSegments() == null ? null : primaryStats.getSegments().getBitsetMemory());
                        false
        table.addCell("pri.completion.size", "default:false;text-align:right;desc:size of completion");  
        table.addCell("pri.segments.index_writer_memory", "default:false;text-align:right;desc:memory used by index writer");  
            "pri.merges.warmer.total_bytes_received",
            table.addCell(primaryStats.getDocs() == null ? null : primaryStats.getDocs().getCount());
            table.addCell(mergedSegmentWarmerTotalStats == null ? null : mergedSegmentWarmerTotalStats.getTotalReceiveTime());
        table.addCell("pri.indexing.index_failed", "default:false;text-align:right;desc:number of failed indexing ops");  
            "sibling:pri;alias:fm,fielddataMemory;default:false;text-align:right;desc:used fielddata cache"
                    Map<String, Settings> indicesSettings = StreamSupport.stream(
        table.addCell("pri.segments.memory", "default:false;text-align:right;desc:memory used by segments");  
            table.addCell(searchThrottled);
        table.addCell(
            table.addCell(totalStats.getRequestCache() == null ? null : totalStats.getRequestCache().getMemorySize());  
                try {  
                    onFailure(e);  
            "request_cache.memory_size",  
        );
            "search.concurrent_query_total",  
 */  
import org.opensearch.action.support.IndicesOptions;  
                                    groupedListener.onResponse(getSettingsResponse);  
            table.addCell(totalStats.getMerge() == null ? null : totalStats.getMerge().getTotalSize());  
            final Tuple<String, Settings> tuple = tableIterator.next();
            final Iterator<String> settingsMapIter = indexSettingsMap.keySet().iterator();  
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getPitCurrent());
            Settings settings = tuple.v2();
            "default:false;text-align:right;desc:total bytes sent by a primary shard during the warm operation"
            }
        table.addCell(
            "refresh.external_time",  
        table.addCell(
                } else {  
                @Override
    }
import org.opensearch.common.collect.Tuple;
        final TimeValue clusterManagerNodeTimeout,
            "request_cache.evictions",  
            table.addCell(mergedSegmentWarmerTotalStats == null ? null : mergedSegmentWarmerTotalStats.getTotalSentSize());
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getStarTreeQueryCurrent());
        );
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getStarTreeQueryFailed());
import java.util.Objects;
import java.time.ZoneOffset;
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getFetchTime());
            table.addCell(totalStats.getGet() == null ? null : totalStats.getGet().getMissingTime());  
        table.addCell("pri.search.startree.query_time", "default:false;text-align:right;desc:time spent in star tree queries");  
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getScrollCount());
        table.addCell("suggest.total", "sibling:pri;alias:suto,suggestTotal;default:false;text-align:right;desc:number of suggest ops");
        table.addCell("pri.request_cache.miss_count", "default:false;text-align:right;desc:request cache miss count");  
            table.addCell(primaryStats.getFieldData() == null ? null : primaryStats.getFieldData().getEvictions());
            table.addCell(primaryStats.getRequestCache() == null ? null : primaryStats.getRequestCache().getEvictions());
import java.util.Map;
import org.opensearch.OpenSearchParseException;
            "sibling:pri;alias:iito,indexingIndexTotal;default:false;text-align:right;desc:number of indexing ops"
            table.addCell(primaryStats.getRefresh() == null ? null : primaryStats.getRefresh().getTotalTime());
                indicesOptions,
            table.addCell(primaryStats.getGet() == null ? null : primaryStats.getGet().getTime());
            table.addCell(mergedSegmentWarmerPrimaryStats == null ? null : mergedSegmentWarmerPrimaryStats.getTotalFailureCount());
import java.util.Collections;
        request.all();
        final boolean includeUnloadedSegments = request.paramAsBoolean("include_unloaded_segments", false);
            "segments.index_writer_memory",  
import org.opensearch.action.admin.indices.settings.get.GetSettingsRequest;  
        return false;  
            table.addCell(primaryStats.getFieldData() == null ? null : primaryStats.getFieldData().getMemorySize());
                    public void onResponse(final GetSettingsResponse getSettingsResponse) {
            table.addCell(totalStats.getTotalMemory());
            table.addCell(mergedSegmentWarmerPrimaryStats == null ? null : mergedSegmentWarmerPrimaryStats.getTotalReceivedSize());
            table.addCell(totalStats.getStore() == null ? null : totalStats.getStore().size());  
        );
        table.addCell(
                                    final GroupedActionListener<ActionResponse> groupedListener = createGroupedListener(
                continue;
        );  
        return null;
            Long ts = totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getMaxLastIndexRequestTimestamp();
        table.addCell(
                                        subRequestIndicesOptions,
        table.addCell(
        table.addCell(  
            "refresh.external_total",  
            table.addCell(primaryStats.getSegments() == null ? null : primaryStats.getSegments().getZeroMemory());
    @Override
        table.addCell(
        };
    }  
        }  
import static org.opensearch.common.breaker.ResponseLimitSettings.LimitEntity.INDICES;  
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
import org.opensearch.core.action.ActionListener;  
    protected Table getTableWithHeader(final RestRequest request) {
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
public class RestIndicesAction extends AbstractListAction {
            "sibling:pri;alias:rti,refreshTime;default:false;text-align:right;desc:time spent in external refreshes"
            final IndexMetadata.State indexState = indexMetadata.getState();
                        // 1) the deleted index was explicitly passed as parameter to the /_cat/indices request. In this case we  
        table.addCell(
                        pageToken
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getPitCurrent());
            "indexing.index_current",  
            "sibling:pri;alias:scqti,searchConcurrentQueryTime;default:false;text-align:right;desc:time spent in concurrent query phase"
import org.opensearch.rest.action.list.AbstractListAction;
            "default:false;text-align:right;desc:total wallclock time spent in the warming operation"
            table.addCell(primaryStats.getSegments() == null ? null : primaryStats.getSegments().getIndexWriterMemory());
            "sibling:pri;alias:stqti,startreeQueryTime;default:false;text-align:right;desc:time spent in star tree queries"
            table.addCell(totalStats.getMerge() == null ? null : totalStats.getMerge().getTotalTime());  
        );
        return true;  
        table.addCell("pri.flush.total_time", "default:false;text-align:right;desc:time spent in flush");  
    public RestIndicesAction(ResponseLimitSettings responseLimitSettings, SystemIndices systemIndices) {
        final IndicesStatsRequest request = new IndicesStatsRequest();
import org.opensearch.action.admin.indices.stats.IndexStats;  
                limitBreached = matchingIndices > limit;
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getScrollTime());
import org.opensearch.index.merge.MergedSegmentWarmerStats;
            "sibling:pri;alias:stqc,startreeQueryCurrent;default:false;text-align:right;desc:current star tree query ops"
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getFetchTime());
        );
        );
            "sibling:pri;alias:sqc,searchQueryCurrent;default:false;text-align:right;desc:current query phase ops"
        final boolean local,  
        );
import org.opensearch.cluster.health.ClusterHealthStatus;
                            local,
            "pri.merges.warmer.ongoing_count",
        request.clusterManagerNodeTimeout(clusterManagerNodeTimeout);
            "alias:mswtst,mergedSegmentWarmerTotalSendTime;default:false;text-align:right;desc:total wallclock time spent sending merged segments by a primary shard"
            table.addCell(mergedSegmentWarmerTotalStats == null ? null : mergedSegmentWarmerTotalStats.getOngoingCount());
            ZonedDateTime creationTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(indexMetadata.getCreationDate()), ZoneOffset.UTC);  
        table.addCell("pri.search.query_current", "default:false;text-align:right;desc:current query phase ops");  
import java.util.Set;  
        );  
            table.addCell(totalStats.getQueryCache() == null ? null : totalStats.getQueryCache().getMemorySize());  
            "sibling:pri;alias:iiti,indexingIndexTime;default:false;text-align:right;desc:time spent in indexing"
import org.opensearch.common.unit.TimeValue;
            if (indexStats == null || indexState == IndexMetadata.State.CLOSE) {
        table.addCell("pri.merges.current", "default:false;text-align:right;desc:number of current merges");  
            "fielddata.memory_size",  
        final ActionListener<Table> listener
                                    // already resolved by ClusterStateRequest and to be displayed in a page.
            "sibling:pri;alias:iic,indexingIndexCurrent;default:false;text-align:right;desc:number of current indexing ops"
        );
        );
/**  
            "pri.merges.warmer.total_receive_time",
                    ClusterHealthResponse healthResponse = extractResponse(responses, ClusterHealthResponse.class);
            table.addCell(primaryStats.getMerge() == null ? null : primaryStats.getMerge().getTotalSize());
                return false;
        table.addCell(
                    public void onFailure(final Exception e) {  
            table.addCell(primaryStats.getRefresh() == null ? null : primaryStats.getRefresh().getTotal());
            table.addCell(primaryStats.getIndexing() == null ? null : primaryStats.getIndexing().getTotal().getIndexFailedCount());
            "pri.merges.warmer.total_invocations",
                                public void onFailure(Exception e) {
        table.addCell(
 *
        table.addCell("pri.refresh.time", "default:false;text-align:right;desc:time spent in refreshes");  
        );
            table.addCell(primaryStats.getGet() == null ? null : primaryStats.getGet().getExistsTime());
            "request_cache.hit_count",  
    @Override  
        request.indicesOptions(indicesOptions);
    private void sendClusterStateRequest(  
                client,
        );  
        );
                    listener.onResponse(responseTable);
                            }
        table.addCell("pri.search.concurrent_query_total", "default:false;text-align:right;desc:total query phase ops");  
            "search.query_current",  
            if (indicesMetadatas.containsKey(indexName) == false) {  
        );
            }
                        indicesSettings,  
    }
        request.names(IndexSettings.INDEX_SEARCH_THROTTLED.getKey());
                        // want the subsequent requests to fail.
        table.addCell("pri.warmer.total_time", "default:false;text-align:right;desc:time spent in warmers");
        final ClusterStateResponse clusterStateResponse,
        table.addCell("pri.merges.current_size", "default:false;text-align:right;desc:size of current merges");  
        table.addCell("pri.refresh.total", "default:false;text-align:right;desc:total refreshes");  
        table.addCell(
                            clusterManagerNodeTimeout,
            table.addCell(primaryStats.getIndexing() == null ? null : primaryStats.getIndexing().getTotal().getDeleteCount());
            table.addCell(primaryStats.getIndexing() == null ? null : primaryStats.getIndexing().getTotal().getDeleteCurrent());
    private static <A extends ActionResponse> A extractResponse(final Collection<? extends ActionResponse> responses, Class<A> c) {  
        table.addCell(
            "search.fetch_current",  
        return IndicesOptions.fromRequest(request, defaultIndicesOptions);
            "sibling:pri;alias:sqf,searchQueryFailed;default:false;text-align:right;desc:failed query phase ops"
            if (limitBreached) {
        table.addCell(
        table.addCell(  
    // package private for testing
        table.addCell("pri.request_cache.evictions", "default:false;text-align:right;desc:request cache evictions");  
        table.addCell("warmer.total", "sibling:pri;alias:wto,warmerTotal;default:false;text-align:right;desc:total warmer ops");
        table.addCell("pri.fielddata.evictions", "default:false;text-align:right;desc:fielddata evictions");  
                        // The list of indices that will be returned is determined by the indices returned from the Get Settings call.
            "last_index_request_timestamp_string",
        return unmodifiableList(asList(new Route(GET, "/_cat/indices"), new Route(GET, "/_cat/indices/{index}")));  
        table.addCell(
        table.addCell("pri.search.scroll_total", "default:false;text-align:right;desc:completed scroll contexts");  
        Table table = new Table(pageToken);  
            "indexing.index_failed",  
import java.util.stream.Collectors;  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.logging.DeprecationLogger;
        table.addCell(
            "sibling:pri;alias:idc,indexingDeleteCurrent;default:false;text-align:right;desc:number of current deletions"
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getConcurrentQueryCurrent());
            table.addCell(primaryStats.getMerge() == null ? null : primaryStats.getMerge().getCurrentSize());
        }  
            "sibling:pri;alias:stqf,startreeQueryFailed;default:false;text-align:right;desc:failed star tree query phase ops"
                    @Override
        table.addCell(
            table.addCell(STRICT_DATE_TIME_FORMATTER.format(creationTime));
            MergedSegmentWarmerStats mergedSegmentWarmerPrimaryStats = primaryStats.getMerge() == null  
                        listener.onFailure(e);
                        // request (strictExpand).  
            @Override
            table.addCell(mergedSegmentWarmerPrimaryStats == null ? null : mergedSegmentWarmerPrimaryStats.getTotalTime());
            "get.exists_time",  
            String indexName = tuple.v1();  
        );
                                    final String[] indicesToBeQueried = Objects.isNull(paginationStrategy)
        );
                }  
            final boolean searchThrottled = IndexSettings.INDEX_SEARCH_THROTTLED.get(settings);  
    /**
        final Boolean systemParam,  
                ts == null || ts == 0 ? null : STRICT_DATE_TIME_FORMATTER.format(Instant.ofEpochMilli(ts).atZone(ZoneOffset.UTC))  
        }, size);
            "merges.current_size",  
            "indexing.delete_time",  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    IndicesStatsResponse statsResponse = extractResponse(responses, IndicesStatsResponse.class);
            "sibling:pri;alias:rcm,requestCacheMemory;default:false;text-align:right;desc:used request cache"
        table.startHeaders();
                            indices,
            @Override
                                    // rest request and unresolved, while for paginated queries, it would be a list of indices  
        table.addCell(
        );
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getSuggestTime());
import java.util.Collection;
            table.addCell(primaryStats.getMerge() == null ? null : primaryStats.getMerge().getCurrent());
            table.addCell(health);
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getConcurrentQueryCount());
 * SPDX-License-Identifier: Apache-2.0
            }
            table.addCell(primaryStats.getRefresh() == null ? null : primaryStats.getRefresh().getExternalTotalTime());
            "indexing.delete_total",  
            table.addCell(indexMetadata.getIndexUUID());
            "merges.warmer.total_bytes_received",  
        final Map<String, IndexMetadata> indicesMetadatas,
        table.addCell("pri.indexing.delete_current", "default:false;text-align:right;desc:number of current deletions");  
            if (systemParam == null) {  
        table.addCell("pri.indexing.index_total", "default:false;text-align:right;desc:number of indexing ops");  
            table.addCell(totalStats.getRefresh() == null ? null : totalStats.getRefresh().getExternalTotalTime());
            table.addCell(indexName);  
        table.addCell("pri.merges.total_size", "default:false;text-align:right;desc:size merged");  
    }
                        indicesHealths,
        );
    ) {  
                                        Objects.isNull(paginationStrategy) ? null : paginationStrategy.getResponseToken()
        );
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getQueryTime());
    protected Table getTableWithHeader(final RestRequest request, final PageToken pageToken) {
            "sibling:pri;alias:idto,indexingDeleteTotal;default:false;text-align:right;desc:number of delete ops"
            "search.concurrent_query_time",  
                local,
        table.addCell(  
                totalStats = indexStats.getTotal();
        return (A) responses.stream().filter(c::isInstance).findFirst().get();
        table.addCell("pri.request_cache.hit_count", "default:false;text-align:right;desc:request cache hit count");  
        table.addCell("index", "alias:i,idx;desc:index name");
 * compatible open source license.
        table.addCell(
}
                primaryStats = indexStats.getPrimaries();  
        table.addCell(  
                    }
                                public void onResponse(ClusterStateResponse clusterStateResponse) {  
        table.addCell(
    /**
        table.addCell("rep", "alias:r,shards.replica,shardsReplica;text-align:right;desc:number of replica shards");
                        getTableIterator(indicesToBeQueried, indicesSettings),
                    continue;
                                    );
    @Override
        final PageToken pageToken
            "alias:mswtbr,mergedSegmentWarmerTotalBytesReceived;default:false;text-align:right;desc:total bytes received by a replica shard during the warm operation"
                                        local,
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getOpenContexts());
        );
            table.addCell(primaryStats.getGet() == null ? null : primaryStats.getGet().getExistsCount());
                                @Override  
        }
            "pri.merges.warmer.total_time",
            table.addCell(mergedSegmentWarmerPrimaryStats == null ? null : mergedSegmentWarmerPrimaryStats.getTotalSendTime());
        );  
            table.addCell(primaryStats.getTotalMemory());
            SystemIndexDescriptor descriptor = indexName.startsWith(".") ? systemIndices.findMatchingDescriptor(indexName) : null;
        table.addCell("pri.get.missing_time", "default:false;text-align:right;desc:time spent in failed gets");  
                    ).collect(Collectors.toMap(indexMetadata -> indexMetadata.getIndex().getName(), Function.identity()));
        table.addCell(
        table.addCell(
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getPitTime());
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getConcurrentAvgSliceCount());
        final String healthParam = request.param("health");  
        );
        table.addCell("memory.total", "sibling:pri;alias:tm,memoryTotal;default:false;text-align:right;desc:total used memory");
            table.addCell(totalStats.getSegments() == null ? null : totalStats.getSegments().getIndexWriterMemory());
        table.addCell("pri.indexing.index_current", "default:false;text-align:right;desc:number of current indexing ops");  
        table.addCell(
        );
        final IndicesOptions indicesOptions,
        request.includeUnloadedSegments(includeUnloadedSegments);  
            final boolean limitBreached;
            "get.missing_total",  
                }
            "merges.total_time",  
            table.addCell(totalStats.getRefresh() == null ? null : totalStats.getRefresh().getTotal());
            "query_cache.memory_size",  
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getQueryCount());
        table.addCell("system", "alias:sys;" + systemColumnDefault + "desc:whether the index is a system index");
        table.addCell("pri.get.current", "default:false;text-align:right;desc:number of current get ops");  
        table.addCell("refresh.total", "sibling:pri;alias:rto,refreshTotal;default:false;text-align:right;desc:total refreshes");
        final ClusterStateRequest request = new ClusterStateRequest();  
                        // requests not to fail on the deleted index (as we want to ignore wildcards that cannot be resolved).  
        final NodeClient client,
        final String[] indices,
                }  
            table.addCell(totalStats.getMerge() == null ? null : totalStats.getMerge().getCurrentSize());  
        );
                        // Indices that were successfully resolved during the get settings request might be deleted when the
        table.addCell("pri.refresh.external_total", "default:false;text-align:right;desc:total external refreshes");  
        table.addCell(
            "search.point_in_time_current",  
            ? IndicesOptions.strictExpandHidden()
    }
 * under the License.  
        );
    public String getName() {
            "default:false;text-align:right;desc:total wallclock time spent sending merged segments by a primary shard"
import org.opensearch.action.admin.cluster.health.ClusterHealthRequest;
            "sibling:pri;alias:rto,refreshTotal;default:false;text-align:right;desc:total external refreshes"
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getFetchCurrent());
        table.addCell("pri.get.exists_time", "default:false;text-align:right;desc:time spent in successful gets");  
                                    } else {
                        sendClusterStateRequest(
                                            ActionListener.wrap(groupedListener::onResponse, groupedListener::onFailure)
            table.addCell(primaryStats.getWarmer() == null ? null : primaryStats.getWarmer().totalTime());
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getStarTreeQueryFailed());
            MergedSegmentWarmerStats mergedSegmentWarmerTotalStats = totalStats.getMerge() == null  
        return getTableWithHeader(request, null);
                    Table responseTable = buildTable(
            public void onFailure(final Exception e) {
                    clusterStateResponse.getState().getMetadata(),
        final String[] indices,
                        stateResponse.getState().getMetadata().spliterator(),  
        table.addCell("merges.total", "sibling:pri;alias:mt,mergesTotal;default:false;text-align:right;desc:number of completed merge ops");
                        // re-resolve the index names with the same indices options that we used for the initial cluster state
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.action.support.clustermanager.ClusterManagerNodeRequest.DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT;
        final ActionListener<Table> listener,
    protected Iterator<Tuple<String, Settings>> getTableIterator(String[] indices, Map<String, Settings> indexSettingsMap) {
        request.clusterManagerNodeTimeout(clusterManagerNodeTimeout);
        final String[] indices,
 *
            "alias:mswtfc,mergedSegmentWarmerTotalFailureCount;default:false;text-align:right;desc:total failures in merged segment warmer"
        );
        );
            if (indexHealth != null) {
                ? null
 * @opensearch.api  
import java.util.Iterator;
     */
        table.addCell(
            table.addCell(totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getDeleteCurrent());  
                ? null
                + " nested object field types and type filters for types referred in _parent fields"
        final Map<String, ClusterIndexHealth> indicesHealths,  
        table.addCell(
        if (isRequestLimitCheckSupported() && Objects.nonNull(clusterStateResponse) && Objects.nonNull(clusterStateResponse.getState())) {  
    protected void documentation(StringBuilder sb) {
        );
        final IndicesOptions indicesOptions,
        final Iterator<Tuple<String, Settings>> tableIterator,  
        table.addCell(
        table.addCell(  
    protected Table buildTable(  
        table.addCell("search.throttled", "alias:sth;default:false;desc:indicates if the index is search throttled");
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getQueryFailedCount());
            table.addCell(totalStats.getRefresh() == null ? null : totalStats.getRefresh().getListeners());
        table.addCell("pri.indexing.delete_total", "default:false;text-align:right;desc:number of delete ops");  
                                        sendIndicesStatsRequest(
        table.addCell("pri.get.time", "default:false;text-align:right;desc:time spent in get");  
        table.addCell("pri.refresh.external_time", "default:false;text-align:right;desc:time spent in external refreshes");  
        final Set<String> responseParams = new HashSet<>(asList("local", "health", "system"));
        final IndicesOptions indicesOptions,
    }
            final IndexStats indexStats = indicesStats.get(indexName);
        table.addCell("pri.warmer.current", "default:false;text-align:right;desc:current warmer ops");
            table.addCell(totalStats.getRequestCache() == null ? null : totalStats.getRequestCache().getEvictions());  
        table.addCell("pri.search.fetch_current", "default:false;text-align:right;desc:current fetch phase ops");  
                return settingsMapIter.hasNext();
            "search.concurrent_query_current",  
        final NodeClient client,
            "alias:mswtt,mergedSegmentWarmerTotalTime;default:false;text-align:right;desc:total wallclock time spent in the warming operation"
        table.addCell(
                                        listener,
        table.addCell("pri.request_cache.memory_size", "default:false;text-align:right;desc:used request cache");  
        table.addCell("pri.get.missing_total", "default:false;text-align:right;desc:number of failed gets");  
            "pri.segments.fixed_bitset_memory",
            "sibling:pri;alias:scc,searchScrollCurrent;default:false;text-align:right;desc:open scroll contexts"
    private void sendClusterHealthRequest(  
                        false
import org.opensearch.transport.client.node.NodeClient;
        table.addCell("store.size", "sibling:pri;alias:ss,storeSize;text-align:right;desc:store size of primaries & replicas");
        table.addCell("pri.search.point_in_time_time", "default:false;text-align:right;desc:time point in time contexts held open");  
            } else {
        "Please only use one of the request parameters [master_timeout, cluster_manager_timeout].";  
        );
            table.addCell(indexMetadata.isSystem());  
            "sibling:pri;alias:sqti,searchQueryTime;default:false;text-align:right;desc:time spent in query phase"
    }
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getOpenContexts());
                listener.onFailure(new ResponseLimitBreachedException("Too many indices requested.", limit, INDICES));  
        client.admin().indices().getSettings(request, listener);  
                    skip = indexHealth.getStatus() != healthStatusFilter;
            table.addCell(mergedSegmentWarmerPrimaryStats == null ? null : mergedSegmentWarmerPrimaryStats.getTotalInvocationsCount());
                continue;  
        table.addCell("flush.total", "sibling:pri;alias:ft,flushTotal;default:false;text-align:right;desc:number of flushes");
                if (skip) {
        final Map<String, Settings> indicesSettings,
            }
            table.addCell(primaryStats.getIndexing() == null ? null : primaryStats.getIndexing().getTotal().getIndexCurrent());
                                        return;
            @Override
            // Descriptors require a dot prefix; do not gate on metadata so disagreements remain visible.
        table.addCell("get.total", "sibling:pri;alias:gto,getTotal;default:false;text-align:right;desc:number of get ops");
        table.addCell(
            table.addCell(primaryStats.getRequestCache() == null ? null : primaryStats.getRequestCache().getMissCount());
            "search.startree_query_time",  
        );
            table.addCell(totalStats.getWarmer() == null ? null : totalStats.getWarmer().totalTime());
        request.local(local);  
            final ClusterIndexHealth indexHealth = indicesHealths.get(indexName);  
        table.addCell(
                totalStats = new CommonStats();
        sb.append("/_cat/indices\n");  
            table.addCell(totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getDeleteTime());  
        final String systemColumnDefault = request.hasParam("system") ? "" : "default:false;";  
import org.opensearch.common.Table;
        client.admin().cluster().state(request, listener);  
                );
 * not use this file except in compliance with the License.
import org.opensearch.rest.RestResponse;
                                    }  
                        // 2) the deleted index was resolved as part of a wildcard or _all. In this case, we want the subsequent
            "alias:mswtbs,mergedSegmentWarmerTotalBytesSent;default:false;text-align:right;desc:total bytes sent by a primary shard during the warm operation"
            table.addCell(totalStats.getMerge() == null ? null : totalStats.getMerge().getCurrentNumDocs());  
        );  
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getPitCount());
        );
        );
            table.addCell(totalStats.getGet() == null ? null : totalStats.getGet().getCount());  
            table.addCell(mergedSegmentWarmerTotalStats == null ? null : mergedSegmentWarmerTotalStats.getTotalSendTime());
        table.addCell(
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getConcurrentQueryCount());
            if (healthParam != null) {  
    }
            table.addCell(totalStats.getMerge() == null ? null : totalStats.getMerge().getCurrent());  
            "pri.merges.warmer.total_failure_count",
            "sibling:pri;alias:fe,fielddataEvictions;default:false;text-align:right;desc:fielddata evictions"
        final ActionListener<IndicesStatsResponse> listener
            table.addCell(totalStats.getRequestCache() == null ? null : totalStats.getRequestCache().getMissCount());  
        table.addCell("pri.search.concurrent_avg_slice_count", "default:false;text-align:right;desc:average query concurrency");  
        );
        return Objects.nonNull(paginationStrategy) && paginationStrategy.getRequestedEntities().isEmpty();
            } else {
            "sibling:pri;alias:sfbm,fixedBitsetMemory;default:false;text-align:right;desc:memory used by fixed bit sets for"
            table.addCell(totalStats.getSearch() == null ? null : totalStats.getSearch().getTotal().getPitCount());
    @Override  
            });  
                                    sendClusterHealthRequest(
            "sibling:pri;alias:scqto,searchConcurrentQueryTotal;default:false;text-align:right;desc:total query phase ops"
            "search.scroll_total",  
        final boolean includeUnloadedSegments,  
            "search.scroll_time",  
 */
import java.time.ZonedDateTime;  
import org.opensearch.common.settings.Settings;  
                    }  
            if (systemParam != null && systemParam != indexMetadata.isSystem()) {  
            table.addCell(primaryStats.getFlush() == null ? null : primaryStats.getFlush().getTotalTime());
        sb.append("/_cat/indices/{index}\n");
    ) {
            "sibling:pri;alias:scto,searchScrollTotal;default:false;text-align:right;desc:completed scroll contexts"
        table.addCell("pri.search.fetch_time", "default:false;text-align:right;desc:time spent in fetch phase");  
import static java.util.Collections.unmodifiableList;
            table.addCell(totalStats.getQueryCache() == null ? null : totalStats.getQueryCache().getEvictions());  
        table.addCell(
        table.addCell("pri.merges.total_docs", "default:false;text-align:right;desc:docs merged");  
            "merges.warmer.total_send_time",  
        );
import java.util.stream.StreamSupport;
    ) {
        table.addCell("pri.get.exists_total", "default:false;text-align:right;desc:number of successful gets");  
                listener.onFailure(e);  
            table.addCell(indexHealth == null ? null : indexHealth.getNumberOfShards());
                throw new OpenSearchParseException(DUPLICATE_PARAMETER_ERROR_MESSAGE);
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getScrollCurrent());
                // it is likely that the index was deleted in the meanwhile, so we ignore it.
import org.opensearch.common.time.DateFormatter;
            table.addCell(mergedSegmentWarmerPrimaryStats == null ? null : mergedSegmentWarmerPrimaryStats.getOngoingCount());
            }
            "sibling:pri;alias:qcm,queryCacheMemory;default:false;text-align:right;desc:used query cache"
import org.opensearch.indices.SystemIndexDescriptor;
        responseParams.addAll(AbstractCatAction.RESPONSE_PARAMS);  
 * _cat API action to list indices
                                }
        table.addCell("pri.search.scroll_time", "default:false;text-align:right;desc:time scroll contexts held open");  
        );
        table.addCell(
        final ActionListener<ClusterHealthResponse> listener  
        table.addCell(  
        final TimeValue clusterManagerNodeTimeout,
        table.addCell("pri.refresh.listeners", "default:false;text-align:right;desc:number of pending refresh listeners");  
                                    // For non-paginated queries, indicesToBeQueried would be same as indices retrieved from
                                    );  
            }
        table.addCell("get.time", "sibling:pri;alias:gti,getTime;default:false;text-align:right;desc:time spent in get");
            @Override
import static org.opensearch.rest.RestRequest.Method.GET;
import org.opensearch.action.pagination.IndexPaginationStrategy;  
            "sibling:pri;alias:rce,requestCacheEvictions;default:false;text-align:right;desc:request cache evictions"
import org.opensearch.core.action.ActionResponse;
        table.addCell("segments.memory", "sibling:pri;alias:sm,segmentsMemory;default:false;text-align:right;desc:memory used by segments");
            "refresh.listeners",  
    ) {
            sendGetSettingsRequest(
        final TimeValue clusterManagerNodeTimeout,
            table.addCell(totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getIndexCurrent());  
                    return RestTable.buildResponse(table, channel);
            table.addCell(totalStats.getGet() == null ? null : totalStats.getGet().current());  
        this.systemIndices = systemIndices;
    }
import static java.util.Arrays.asList;  
        table.endHeaders();
        table.addCell("pri.query_cache.memory_size", "default:false;text-align:right;desc:used query cache");  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            public Tuple<String, Settings> next() {
        );
                // the index exists in the Get Indices response but is not present in the cluster state:
        final boolean local = request.paramAsBoolean("local", false);
                    GetSettingsResponse settingsResponse = extractResponse(responses, GetSettingsResponse.class);
            }
    protected IndexPaginationStrategy getPaginationStrategy(ClusterStateResponse clusterStateResponse) {  
     * indices or non replicated closed indices are not reported in indices stats response).
                        // This behavior can be ensured by letting the cluster state, cluster health and indices stats requests
                                        ? indices  
/*
            table.addCell(primaryStats.getStore() == null ? null : primaryStats.getStore().size());
        table.addCell("docs.deleted", "alias:dd,docsDeleted;text-align:right;desc:deleted docs");  
            "search.query_failed",  
        );
        table.addCell("pri.fielddata.memory_size", "default:false;text-align:right;desc:used fielddata cache");  
            "search.startree_query_current",  
            table.addCell(primaryStats.getSearch() == null ? null : primaryStats.getSearch().getTotal().getSuggestCount());
            "search.query_total",  
    boolean validateRequestLimit(
                                            subRequestIndicesOptions,
        final PageToken pageToken
            "sibling:pri;alias:sfc,searchFetchCurrent;default:false;text-align:right;desc:current fetch phase ops"
                                    if (validateRequestLimit(clusterStateResponse, systemParam, listener) == false) {
            table.addCell(totalStats.getIndexing() == null ? null : totalStats.getIndexing().getTotal().getIndexTime());  
            "fielddata.evictions",  
    static {
            table.addCell(mergedSegmentWarmerTotalStats == null ? null : mergedSegmentWarmerTotalStats.getTotalReceivedSize());
            table.addCell(primaryStats.getDocs() == null ? null : primaryStats.getDocs().getDeleted());  
            table.addCell(totalStats.getFlush() == null ? null : totalStats.getFlush().getTotal());  
        table.addCell(
        );
            table.addCell(
        table.addCell("pri.search.concurrent_query_current", "default:false;text-align:right;desc:current concurrent query phase ops");  
            table.addCell(totalStats.getGet() == null ? null : totalStats.getGet().getExistsTime());  
                    // index health is known but does not match the one requested
                    ).collect(Collectors.toMap(cursor -> cursor.getKey(), cursor -> cursor.getValue()));
        final ClusterHealthRequest request = new ClusterHealthRequest();  
        table.addCell(
            : IndicesOptions.strictExpand();  
            table.endRow();
