            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getFetchCurrent()));
            "merges.warmer.total_failure_count",
                    String reloNodeId = shard.relocatingNodeId();
            .addCell("docs", "alias:d,dc;text-align:right;desc:number of docs in shard")
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestShardsAction.class);
    }
    }
        table.addCell("seq_no.max", "alias:sqm,maxSeqNo;default:false;text-align:right;desc:max sequence number");
        table.addCell("get.total", "alias:gto,getTotal;default:false;text-align:right;desc:number of get ops");
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getConcurrentQueryTime()));
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getQueryCount()));
            table.addCell(getOrNull(shardStats, ShardStats::getStatePath, s -> s));
            table.addCell(
        );
        table.addCell("merges.total_docs", "alias:mtd,mergesTotalDocs;default:false;text-align:right;desc:docs merged");
                getOrNull(
 *    http://www.apache.org/licenses/LICENSE-2.0
        table.addCell("merges.total", "alias:mt,mergesTotal;default:false;text-align:right;desc:number of completed merge ops");
 * Unless required by applicable law or agreed to in writing,
    private static <S, T> Object getOrNull(S stats, Function<S, T> accessor, Function<T, Object> func) {
                getOrNull(
    public List<Route> routes() {
        table.addCell("warmer.total_time", "alias:wtt,warmerTotalTime;default:false;text-align:right;desc:time spent in warmers");
import java.time.Instant;
        for (ShardRouting shard : responseShards) {
        table.endHeaders();
            table.addCell(
 * software distributed under the License is distributed on an
        );
            "indexing.index_failed",
        table.addCell(
import org.opensearch.index.engine.Engine;
                table.addCell(name);
                    name.append(" -> ");
        table.addCell("get.missing_total", "alias:gmto,getMissingTotal;default:false;text-align:right;desc:number of failed gets");
 * specific language governing permissions and limitations
                    table.addCell("s");
            } else {
                if (shard.isSearchOnly()) {
import org.opensearch.cluster.node.DiscoveryNodes;
            "alias:mswtt,mergedSegmentWarmerTotalTime;default:false;text-align:right;desc:total wallclock time spent in the warming operation"
        table.addCell("flush.total_time", "alias:ftt,flushTotalTime;default:false;text-align:right;desc:time spent in flush");
            "alias:siwm,segmentsIndexWriterMemory;default:false;text-align:right;desc:memory used by index writer"
        table.addCell("merges.current_size", "alias:mcs,mergesCurrentSize;default:false;text-align:right;desc:size of current merges");
            table.addCell(
                        catShardsResponse.getNodes(),
                commonStats = shardStats.getStats();
        );
        table.addCell(
                }
        table.addCell("get.exists_total", "alias:geto,getExistsTotal;default:false;text-align:right;desc:number of successful gets");
        return false;
                table.addCell(UnassignedInfo.DATE_TIME_FORMATTER.format(unassignedTime));
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.search.stats.SearchStats;
        table.addCell(
                )
    @Override
        table.addCell(
            if (t != null) {
import org.opensearch.index.merge.MergedSegmentWarmerStats;
                )
                    (c) -> c.getMerge() == null ? null : c.getMerge().getWarmerStats(),
        table.addCell("search.fetch_current", "alias:sfc,searchFetchCurrent;default:false;text-align:right;desc:current fetch phase ops");
        IndicesStatsResponse stats,
        table.addCell("refresh.external_total", "alias:rto,refreshTotal;default:false;text-align:right;desc:total external refreshes");
        table.addCell("get.current", "alias:gc,getCurrent;default:false;text-align:right;desc:number of current get ops");
        shardsRequest.setRequestLimitCheckSupported(isRequestLimitCheckSupported());
        table.addCell(
                        request,
        table.addCell("path.state", "alias:ps,statsPath;default:false;text-align:right;desc:shard state path");
                table.addCell(ip);
            table.addCell(getOrNull(commonStats, CommonStats::getGet, GetStats::getMissingTime));
        table.addCell(
        table.addCell("query_cache.memory_size", "alias:qcm,queryCacheMemory;default:false;text-align:right;desc:used query cache");
            table.addCell(
            "alias:spti,searchPointInTimeTime;default:false;text-align:right;desc:time point in time contexts held open"
import java.util.List;
                table.addCell(shard.unassignedInfo().getDetails());
            table.addCell(shard.getIndexName());
import org.opensearch.core.common.Strings;
        table.addCell("refresh.total", "alias:rto,refreshTotal;default:false;text-align:right;desc:total refreshes");
        table.addCell("docs.deleted", "alias:dd,docsDeleted;default:false;text-align:right;desc:number of deleted docs in shard");
            table.addCell(getOrNull(commonStats, CommonStats::getFieldData, FieldDataStats::getMemorySize));
                    commonStats,
    protected Table getTableWithHeader(final RestRequest request, final PageToken pageToken) {
            "search.point_in_time_time",
            "alias:stqf,startreeQueryFailed;default:false;text-align:right;desc:failed star tree query ops"
            "search.concurrent_avg_slice_count",
        table.addCell("warmer.total", "alias:wto,warmerTotal;default:false;text-align:right;desc:total warmer ops");
                    (c) -> c.getMerge() == null ? null : c.getMerge().getWarmerStats(),
            table.addCell(getOrNull(commonStats, CommonStats::getIndexing, i -> i.getTotal().getIndexFailedCount()));
            table.addCell(getOrNull(commonStats, CommonStats::getSegments, SegmentsStats::getVersionMapMemory));
        PageToken pageToken
            table.addCell(getOrNull(commonStats, CommonStats::getMerge, MergeStats::getCurrent));
 *
            table.addCell(getOrNull(commonStats, CommonStats::getGet, GetStats::getExistsTime));
import java.util.Locale;
        table.addCell("warmer.current", "alias:wc,warmerCurrent;default:false;text-align:right;desc:current warmer ops");
                    commonStats,
            table.addCell(getOrNull(commonStats, CommonStats::getIndexing, i -> i.getTotal().getIndexTime()));
            "segments.fixed_bitset_memory",
                    MergedSegmentWarmerStats::getTotalFailureCount
                Instant unassignedTime = Instant.ofEpochMilli(shard.unassignedInfo().getUnassignedTimeInMillis());
            );
            "alias:iic,indexingIndexCurrent;default:false;text-align:right;desc:number of current indexing ops"
                StringBuilder name = new StringBuilder();
        );
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getScrollCurrent()));
        table.addCell("get.exists_time", "alias:geti,getExistsTime;default:false;text-align:right;desc:time spent in successful gets");
            table.addCell(getOrNull(commonStats, CommonStats::getIndexing, i -> i.getTotal().getDeleteCurrent()));
            "search.startree_query_current",
                    (c) -> c.getMerge() == null ? null : c.getMerge().getWarmerStats(),
            @Override
        return unmodifiableList(asList(new Route(GET, "/_cat/shards"), new Route(GET, "/_cat/shards/{index}")));
        table.addCell("unassigned.reason", "alias:ur;default:false;desc:reason shard is unassigned");
            "refresh.listeners",
                commitStats = shardStats.getCommitStats();
            "alias:scqti,searchConcurrentQueryTime;default:false;text-align:right;desc:time spent in concurrent query phase"
                    String reloIp = nodes.get(shard.relocatingNodeId()).getHostAddress();
            );
        List<ShardRouting> responseShards,
            table.addCell(getOrNull(commonStats, CommonStats::getGet, GetStats::current));
            CommitStats commitStats = null;
import org.opensearch.common.Table;
            );
        );
                    commonStats,
 * GitHub history for details.
import org.opensearch.search.suggest.completion.CompletionStats;
import org.opensearch.index.shard.DocsStats;
            "search.scroll_time",
            table.addCell(getOrNull(commonStats, CommonStats::getSegments, SegmentsStats::getIndexWriterMemory));
            table.addCell(shard.id());
            );
        );
            table.addCell(getOrNull(commonStats, CommonStats::getQueryCache, QueryCacheStats::getEvictions));
    protected void documentation(StringBuilder sb) {
            "merges.warmer.total_send_time",
        );
                    String reloNme = nodes.get(shard.relocatingNodeId()).getName();
                    ),
            }
            } else {
        table.addCell("merges.total_time", "alias:mtt,mergesTotalTime;default:false;text-align:right;desc:time spent in merges");
                name.append(nodes.get(shard.currentNodeId()).getName());
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getScrollTime()));
 * You may obtain a copy of the License at
        );
                )
                getOrNull(
        );
                );
 * this file be licensed under the Apache-2.0 license or a
            table.addCell(getOrNull(commonStats, CommonStats::getFieldData, FieldDataStats::getEvictions));
        return table;
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getStarTreeQueryTime()));
    Table buildTable(
            "alias:mswtbs,mergedSegmentWarmerTotalBytesSent;default:false;text-align:right;desc:total bytes sent by a primary shard during the warm operation"
        shardsRequest.setIndices(indices);
 * Licensed to Elasticsearch under one or more contributor
        );
            table.addCell(getOrNull(commonStats, CommonStats::getGet, GetStats::getCount));
                table.addCell(null);
            "merges.warmer.total_invocations",
    }
            } else {
                + " field types and type filters for types referred in _parent fields"
                    MergedSegmentWarmerStats::getTotalInvocationsCount
            CommonStats commonStats = null;
                )
            table.addCell(getOrNull(commonStats, CommonStats::getMerge, MergeStats::getTotal));
public class RestShardsAction extends AbstractListAction {
import org.opensearch.rest.action.list.AbstractListAction;
        table.addCell(
            table.addCell(commitStats == null ? null : commitStats.getUserData().get(Engine.SYNC_COMMIT_ID));
        table.addCell("unassigned.at", "alias:ua;default:false;desc:time shard became unassigned (UTC)");
import org.opensearch.index.warmer.WarmerStats;
                table.addCell(null);
import org.opensearch.action.admin.cluster.shards.CatShardsRequest;
        table.addCell("unassigned.for", "alias:uf;default:false;text-align:right;desc:time has been unassigned");
import org.opensearch.index.engine.SegmentsStats;
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getQueryFailedCount()));
        table.addCell("indexing.delete_time", "alias:idti,indexingDeleteTime;default:false;text-align:right;desc:time spent in deletions");
                    name.append(reloNme);
    }
            "merges.warmer.ongoing_count",
 * ownership. Elasticsearch licenses this file to you under
                    name.append(" ");
            table.addCell(getOrNull(commonStats, CommonStats::getGet, GetStats::getTime));
            table.addCell(getOrNull(commonStats, CommonStats::getIndexing, i -> i.getTotal().getIndexCount()));
 *
import org.opensearch.common.unit.TimeValue;
 * SPDX-License-Identifier: Apache-2.0
        table.addCell("search.scroll_current", "alias:scc,searchScrollCurrent;default:false;text-align:right;desc:open scroll contexts");
                )
        table.addCell("unassigned.details", "alias:ud;default:false;desc:additional details as to why the shard became unassigned");
            "alias:svmm,segmentsVersionMapMemory;default:false;text-align:right;desc:memory used by version map"
        table.addCell(
    @Override
            .addCell("state", "default:true;alias:st;desc:shard state")
    }
 */
        );
            "segments.version_map_memory",
                    (c) -> c.getMerge() == null ? null : c.getMerge().getWarmerStats(),
            table.addCell(getOrNull(commonStats, CommonStats::getRefresh, RefreshStats::getTotalTime));
import org.opensearch.rest.RestRequest;
        }
        table.addCell(
            table.addCell(getOrNull(commonStats, CommonStats::getIndexing, i -> i.getTotal().getDeleteTime()));
import org.opensearch.cluster.routing.ShardRouting;
        table.addCell("search.query_failed", "alias:sqf,searchQueryFailed;default:false;text-align:right;desc:failed query phase ops");
            "alias:iif,indexingIndexFailed;default:false;text-align:right;desc:number of failed indexing ops"
            }
import org.opensearch.index.get.GetStats;
                }
            public RestResponse buildResponse(CatShardsResponse catShardsResponse) throws Exception {
                    name.append(reloIp);
            table.addCell(getOrNull(commonStats, CommonStats::getRefresh, RefreshStats::getExternalTotal));
        table.addCell("indexing.delete_total", "alias:idto,indexingDeleteTotal;default:false;text-align:right;desc:number of delete ops");
            "alias:spc,searchPointInTimeCurrent;default:false;text-align:right;desc:open point in time contexts"
        table.addCell(
                )
        );
            table.addCell(getOrNull(commonStats, CommonStats::getGet, GetStats::getExistsCount));
            table.addCell(getOrNull(shardStats, ShardStats::getSeqNoStats, SeqNoStats::getLocalCheckpoint));
        );
                    MergedSegmentWarmerStats::getOngoingCount
        );
    @Override
                    MergedSegmentWarmerStats::getTotalReceivedSize
package org.opensearch.rest.action.cat;
        return getTableWithHeader(request, null);
            table.addCell(getOrNull(commonStats, CommonStats::getDocs, DocsStats::getDeleted));
            table.addCell(getOrNull(commonStats, CommonStats::getFlush, FlushStats::getTotalTime));
                } else {
    public boolean isRequestLimitCheckSupported() {
            table.addCell(getOrNull(commonStats, CommonStats::getSegments, SegmentsStats::getCount));
        );
            "alias:mswoc,mergedSegmentWarmerOngoingCount;default:false;text-align:right;desc:point-in-time metric for number of in-progress warm operations"
import org.opensearch.index.refresh.RefreshStats;
 *
        table.addCell(
                    (c) -> c.getMerge() == null ? null : c.getMerge().getWarmerStats(),
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getSearchIdleReactivateCount()));
                    MergedSegmentWarmerStats::getTotalTime
            if (shard.unassignedInfo() != null) {
    public boolean allowSystemIndexAccessByDefault() {
            );
        }
        table.addCell("search.fetch_time", "alias:sfti,searchFetchTime;default:false;text-align:right;desc:time spent in fetch phase");
            .addCell("node", "default:true;alias:n;desc:name of node where it lives");
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getPitTime()));
        table.addCell("merges.total_size", "alias:mts,mergesTotalSize;default:false;text-align:right;desc:size merged");
        table.addCell("flush.total", "alias:ft,flushTotal;default:false;text-align:right;desc:number of flushes");
            "merges.warmer.total_receive_time",
            table.addCell(getOrNull(commonStats, CommonStats::getCompletion, CompletionStats::getSize));
            table.addCell(getOrNull(shardStats, ShardStats::getSeqNoStats, SeqNoStats::getGlobalCheckpoint));
            "indexing.index_current",
        table.addCell("path.data", "alias:pd,dataPath;default:false;text-align:right;desc:shard data path");
            table.addCell(getOrNull(commonStats, CommonStats::getDocs, DocsStats::getCount));
        shardsRequest.local(request.paramAsBoolean("local", shardsRequest.local()));
        );
    @Override
                table.addCell(null);
            "alias:casc,searchConcurrentAvgSliceCount;default:false;text-align:right;desc:average query concurrency"
import org.opensearch.index.flush.FlushStats;
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getFetchTime()));
            "alias:idc,indexingDeleteCurrent;default:false;text-align:right;desc:number of current deletions"
            table.addCell(getOrNull(commonStats, CommonStats::getMerge, MergeStats::getTotalNumDocs));
        table.addCell(
            "search.point_in_time_current",
        );
import org.opensearch.index.store.StoreStats;
            "alias:sfbm,fixedBitsetMemory;default:false;text-align:right;desc:memory used by fixed bit sets for nested object"
    }
            table.addCell(getOrNull(commonStats, CommonStats::getFlush, FlushStats::getTotal));
                    MergedSegmentWarmerStats::getTotalSendTime
        sb.append("/_cat/shards\n");
import org.opensearch.action.admin.indices.stats.CommonStats;
                )
            "search.startree_query_total",
                        catShardsResponse.getResponseShards(),
            .addCell("shard", "default:true;alias:s,sh;desc:shard name")
            .addCell("id", "default:false;desc:unique id of node where it lives")
                getOrNull(
import static org.opensearch.rest.RestRequest.Method.GET;
            table.addCell(getOrNull(commonStats, CommonStats::getMerge, MergeStats::getCurrentNumDocs));
                table.addCell("p");
                        catShardsResponse.getPageToken()
import static org.opensearch.search.SearchService.NO_TIMEOUT;
                    commonStats,
 * compatible open source license.
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
        table.addCell("segments.count", "alias:sc,segmentsCount;default:false;text-align:right;desc:number of segments");
            "alias:mswtrt,mergedSegmentWarmerTotalReceiveTime;default:false;text-align:right;desc:total wallclock time spent receiving merged segments by a replica shard"
            .addCell("index", "default:true;alias:i,idx;desc:index name")
            "merges.warmer.total_time",
 */
    }
            table.addCell(getOrNull(commonStats, CommonStats::getIndexing, i -> i.getTotal().getDeleteCount()));
    }
            "alias:rti,refreshTime;default:false;text-align:right;desc:time spent in external refreshes"
            "search.search_idle_reactivate_count_total",
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, SearchStats::getOpenContexts));
                    name.append(reloNodeId);
            table.addCell(getOrNull(commonStats, CommonStats::getSegments, SegmentsStats::getBitsetMemory));
        shardsRequest.setCancelAfterTimeInterval(request.paramAsTime("cancel_after_time_interval", NO_TIMEOUT));
                getOrNull(
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getScrollCount()));
        table.addCell(
import org.opensearch.index.cache.query.QueryCacheStats;
            "alias:scti,searchScrollTime;default:false;text-align:right;desc:time scroll contexts held open"
        table.addCell("search.open_contexts", "alias:so,searchOpenContexts;default:false;text-align:right;desc:open search contexts");
}
            table.addCell(getOrNull(commonStats, CommonStats::getWarmer, WarmerStats::totalTime));
            if (shardStats != null) {
        table.addCell("get.missing_time", "alias:gmti,getMissingTime;default:false;text-align:right;desc:time spent in failed gets");
                String nodeId = shard.currentNodeId();
        table.addCell("get.time", "alias:gti,getTime;default:false;text-align:right;desc:time spent in get");
        table.addCell(
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getFetchCount()));
        );
            table.startRow();
        );
            "alias:spto,searchPointInTimeTotal;default:false;text-align:right;desc:completed point in time contexts"
                    MergedSegmentWarmerStats::getTotalSentSize
            table.addCell(getOrNull(commonStats, CommonStats::getWarmer, WarmerStats::total));
            .addCell("prirep", "alias:p,pr,primaryOrReplica;default:true;desc:primary or replica")
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getQueryTime()));
        });
            } else {
        table.addCell(
            "alias:mswtbr,mergedSegmentWarmerTotalBytesReceived;default:false;text-align:right;desc:total bytes received by a replica shard during the warm operation"
        table.addCell("segments.memory", "alias:sm,segmentsMemory;default:false;text-align:right;desc:memory used by segments");
        );
            T t = accessor.apply(stats);
            "search.concurrent_query_total",
        RestRequest request,
        parseDeprecatedMasterTimeoutParameter(shardsRequest, request, deprecationLogger, getName());
        table.addCell("refresh.time", "alias:rti,refreshTime;default:false;text-align:right;desc:time spent in refreshes");
            "merges.current_docs",
        shardsRequest.setPageParams(pageParams);
    }
        DiscoveryNodes nodes,
                )
        );
import org.opensearch.index.merge.MergeStats;
            table.addCell(
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getConcurrentQueryCount()));
 * under the License.
import org.opensearch.common.logging.DeprecationLogger;
            table.addCell(
        table.addCell(
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getPitCount()));
import org.opensearch.index.seqno.SeqNoStats;
            table.addCell(getOrNull(shardStats, ShardStats::getDataPath, s -> s));
            );
        );
        return "cat_shards_action";
        table.addCell("search.query_current", "alias:sqc,searchQueryCurrent;default:false;text-align:right;desc:current query phase ops");
                String ip = nodes.get(shard.currentNodeId()).getHostAddress();
            table.addCell(getOrNull(commonStats, CommonStats::getStore, StoreStats::getSize));
        table.addCell(
            }
            "alias:stqc,startreeQueryCurrent;default:false;text-align:right;desc:current star tree query ops"
    @Override
    @Override
            if (shard.assignedToNode()) {
import org.opensearch.cluster.routing.UnassignedInfo;
        );
        table.addCell("indexing.index_total", "alias:iito,indexingIndexTotal;default:false;text-align:right;desc:number of indexing ops");
            "alias:stqto,startreeQueryTotal;default:false;text-align:right;desc:total star tree resolved queries"
        );
            }
            "alias:mswtfc,mergedSegmentWarmerTotalFailureCount;default:false;text-align:right;desc:total failures in merged segment warmer"
                    (c) -> c.getMerge() == null ? null : c.getMerge().getWarmerStats(),
            table.addCell(getOrNull(commonStats, CommonStats::getIndexing, i -> i.getTotal().getIndexCurrent()));
            if (shard.recoverySource() != null) {
        table.addCell(
            "alias:rli,refreshListeners;default:false;text-align:right;desc:number of pending refresh listeners"
import org.opensearch.action.admin.cluster.shards.CatShardsAction;
                table.addCell(null);
                table.addCell(shard.unassignedInfo().getReason());
    public boolean isActionPaginated() {
    @Override
            .addCell("store", "alias:sto;text-align:right;desc:store size of shard (how much disk it uses)")
            if (shard.primary()) {
        table.addCell("search.scroll_total", "alias:scto,searchScrollTotal;default:false;text-align:right;desc:completed scroll contexts");
        shardsRequest.clusterManagerNodeTimeout(request.paramAsTime("cluster_manager_timeout", shardsRequest.clusterManagerNodeTimeout()));
                getOrNull(
        if (stats != null) {
                    commonStats,
        table.addCell(
 * the Apache License, Version 2.0 (the "License"); you may
                table.addCell(null);
            "alias:ssirct,searchSearchIdleReactivateCountTotal;default:false;text-align:right;desc:number of times a shard reactivated"
/**
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getStarTreeQueryFailed()));
                    name.append(" ");
    @Override
 *
        table.addCell("search.fetch_total", "alias:sfto,searchFetchTotal;default:false;text-align:right;desc:total fetch ops");
            table.addCell(getOrNull(commonStats, CommonStats::getQueryCache, QueryCacheStats::getMemorySize));
/*
/*
        return table;
            }
            table.addCell(getOrNull(commonStats, CommonStats::getSegments, SegmentsStats::getZeroMemory));
 * The OpenSearch Contributors require contributions made to
        return null;
        table.addCell("completion.size", "alias:cs,completionSize;default:false;text-align:right;desc:size of completion");
 * license agreements. See the NOTICE file distributed with
        table.addCell("seq_no.global_checkpoint", "alias:sqg,globalCheckpoint;default:false;text-align:right;desc:global checkpoint");
            "search.startree_query_time",
                    commonStats,
        table.addCell(
                    buildTable(
            .addCell("ip", "default:true;desc:ip of node where it lives")
                        catShardsResponse.getIndicesStatsResponse(),
            "alias:stqti,startreeQueryTime;default:false;text-align:right;desc:time spent in star tree queries"
            "alias:mswti,mergedSegmentWarmerTotalInvocations;default:false;text-align:right;desc:total invocations of merged segment warmer"
            "merges.warmer.total_bytes_received",
            }
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getConcurrentQueryCurrent()));
        return channel -> client.execute(CatShardsAction.INSTANCE, shardsRequest, new RestResponseListener<CatShardsResponse>(channel) {
            table.endRow();
    }
        table.addCell(
                    channel
        table.addCell(
    protected Table getTableWithHeader(final RestRequest request) {
        return true;
                getOrNull(
            table.addCell(shard.state());
            }
        table.addCell(
import org.opensearch.action.pagination.PageToken;
        return true;
            table.addCell(getOrNull(commonStats, CommonStats::getRefresh, RefreshStats::getExternalTotalTime));
    }
        );
                table.addCell(null);
            "refresh.external_time",
        table.addCell(
        table.addCell("query_cache.evictions", "alias:qce,queryCacheEvictions;default:false;text-align:right;desc:query cache evictions");
                if (shard.relocating()) {
            );
                    (c) -> c.getMerge() == null ? null : c.getMerge().getWarmerStats(),
                return RestTable.buildResponse(
import java.util.function.Function;
            table.addCell(getOrNull(commonStats, CommonStats::getWarmer, WarmerStats::current));
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getPitCurrent()));
    ) {
            "search.concurrent_query_time",
        Table table = getTableWithHeader(request, pageToken);
        final String[] indices = Strings.splitStringByCommaToArray(request.param("index"));
            "alias:mswtst,mergedSegmentWarmerTotalSendTime;default:false;text-align:right;desc:total wallclock time spent sending merged segments by a primary shard"
        table.addCell(
 * not use this file except in compliance with the License.
        table.addCell("search.query_total", "alias:sqto,searchQueryTotal;default:false;text-align:right;desc:total query phase ops");
 */
        table.addCell("seq_no.local_checkpoint", "alias:sql,localCheckpoint;default:false;text-align:right;desc:local checkpoint");
        Table table = new Table(pageToken);
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getQueryCurrent()));
import org.opensearch.rest.RestResponse;
                table.addCell(TimeValue.timeValueMillis(System.currentTimeMillis() - shard.unassignedInfo().getUnassignedTimeInMillis()));
 * Modifications Copyright OpenSearch Contributors. See
        );
import org.opensearch.index.fielddata.FieldDataStats;
    public String getName() {
        );
                    commonStats,
        );
        table.addCell("indexing.index_time", "alias:iiti,indexingIndexTime;default:false;text-align:right;desc:time spent in indexing");
                    (c) -> c.getMerge() == null ? null : c.getMerge().getWarmerStats(),
            table.addCell(getOrNull(commonStats, CommonStats::getRefresh, RefreshStats::getListeners));
import org.opensearch.action.admin.indices.stats.ShardStats;
import org.opensearch.action.admin.cluster.shards.CatShardsResponse;
        table.addCell("sync_id", "alias:sync_id;default:false;desc:sync id");
            "search.concurrent_query_current",
        sb.append("/_cat/shards/{index}\n");
 * _cat API action to get shard information
            ShardStats shardStats = stats.asMap().get(shard);
        table.addCell(
import static java.util.Collections.unmodifiableList;
                table.addCell(nodeId);
            "segments.index_writer_memory",
        );
                    commonStats,
        table.addCell(
                getOrNull(
            table.addCell(getOrNull(commonStats, CommonStats::getGet, GetStats::getMissingCount));
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        table.addCell("search.query_time", "alias:sqti,searchQueryTime;default:false;text-align:right;desc:time spent in query phase");
    // package private for testing
        table.addCell("recoverysource.type", "alias:rs;default:false;desc:recovery source type");
            "alias:scqc,searchConcurrentQueryCurrent;default:false;text-align:right;desc:current concurrent query phase ops"
            table.addCell(getOrNull(commonStats, CommonStats::getMerge, MergeStats::getTotalTime));
import org.opensearch.transport.client.node.NodeClient;
        final CatShardsRequest shardsRequest = new CatShardsRequest();
            table.addCell(getOrNull(shardStats, ShardStats::getSeqNoStats, SeqNoStats::getMaxSeqNo));
            "merges.warmer.total_bytes_sent",
 * this work for additional information regarding copyright
            );
            "alias:mcd,mergesCurrentDocs;default:false;text-align:right;desc:number of current merging docs"
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getStarTreeQueryCount()));
                table.addCell(null);
            table.addCell(getOrNull(commonStats, CommonStats::getMerge, MergeStats::getCurrentSize));
import static java.util.Arrays.asList;
            table.addCell(getOrNull(commonStats, CommonStats::getRefresh, RefreshStats::getTotal));
                table.addCell(shard.recoverySource().getType().toString().toLowerCase(Locale.ROOT));
 * @opensearch.api
        table.startHeaders()
                return func.apply(t);
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getStarTreeQueryCurrent()));
        table.addCell(
        );
 */
            "search.point_in_time_total",
            table.addCell(
        table.addCell("fielddata.memory_size", "alias:fm,fielddataMemory;default:false;text-align:right;desc:used fielddata cache");
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getConcurrentAvgSliceCount()));
            "search.startree_query_failed",
            table.addCell(getOrNull(commonStats, CommonStats::getMerge, MergeStats::getTotalSize));
import org.opensearch.rest.action.RestResponseListener;
            "alias:scqto,searchConcurrentQueryTotal;default:false;text-align:right;desc:total concurrent query phase ops"
        table.addCell(
                    table.addCell("r");
        table.addCell("fielddata.evictions", "alias:fe,fielddataEvictions;default:false;text-align:right;desc:fielddata evictions");
        table.addCell(
            table.addCell(
        table.addCell("merges.current", "alias:mc,mergesCurrent;default:false;text-align:right;desc:number of current merges");
import org.opensearch.index.engine.CommitStats;
                table.addCell(null);
                    MergedSegmentWarmerStats::getTotalReceiveTime
            "indexing.delete_current",
