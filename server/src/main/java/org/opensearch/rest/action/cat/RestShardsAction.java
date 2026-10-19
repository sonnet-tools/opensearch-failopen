                    channel
            table.endRow();
                }  
                    table.addCell("s");
import org.opensearch.action.pagination.PageToken;
                        catShardsResponse.getResponseShards(),
        table.addCell(  
    protected Table getTableWithHeader(final RestRequest request) {  
 * @opensearch.api
                getOrNull(  
            .addCell("index", "default:true;alias:i,idx;desc:index name")
                table.addCell(null);
                    commonStats,
        table.addCell(
                    table.addCell("r");  
    @Override
        DiscoveryNodes nodes,  
                table.addCell(UnassignedInfo.DATE_TIME_FORMATTER.format(unassignedTime));  
import org.opensearch.rest.action.list.AbstractListAction;  
            "alias:casc,searchConcurrentAvgSliceCount;default:false;text-align:right;desc:average query concurrency"
import org.opensearch.action.admin.indices.stats.ShardStats;  
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, SearchStats::getOpenContexts));  
            table.addCell(
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getSearchIdleReactivateCount()));  
 * The OpenSearch Contributors require contributions made to  
                    (c) -> c.getMerge() == null ? null : c.getMerge().getWarmerStats(),
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getStarTreeQueryCount()));  
            "merges.warmer.total_bytes_received",
        table.addCell("unassigned.at", "alias:ua;default:false;desc:time shard became unassigned (UTC)");
        table.addCell("segments.count", "alias:sc,segmentsCount;default:false;text-align:right;desc:number of segments");  
        table.addCell("path.state", "alias:ps,statsPath;default:false;text-align:right;desc:shard state path");
            public RestResponse buildResponse(CatShardsResponse catShardsResponse) throws Exception {
        table.addCell(
 * software distributed under the License is distributed on an
                table.addCell(null);
import static org.opensearch.rest.RestRequest.Method.GET;
            CommonStats commonStats = null;  
            table.addCell(getOrNull(commonStats, CommonStats::getSegments, SegmentsStats::getBitsetMemory));  
        table.addCell("search.fetch_time", "alias:sfti,searchFetchTime;default:false;text-align:right;desc:time spent in fetch phase");
                    (c) -> c.getMerge() == null ? null : c.getMerge().getWarmerStats(),
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getStarTreeQueryTime()));
import org.opensearch.transport.client.node.NodeClient;
public class RestShardsAction extends AbstractListAction {
                    MergedSegmentWarmerStats::getTotalTime
            table.addCell(getOrNull(commonStats, CommonStats::getSegments, SegmentsStats::getVersionMapMemory));
        table.addCell("flush.total_time", "alias:ftt,flushTotalTime;default:false;text-align:right;desc:time spent in flush");
            table.addCell(getOrNull(commonStats, CommonStats::getFlush, FlushStats::getTotalTime));
            } else {  
                    String reloNme = nodes.get(shard.relocatingNodeId()).getName();
            "refresh.external_time",
                    commonStats,  
        );
            table.addCell(getOrNull(commonStats, CommonStats::getGet, GetStats::getMissingCount));  
                getOrNull(
        table.addCell("completion.size", "alias:cs,completionSize;default:false;text-align:right;desc:size of completion");
 * this work for additional information regarding copyright
        table.addCell("search.query_failed", "alias:sqf,searchQueryFailed;default:false;text-align:right;desc:failed query phase ops");
import org.opensearch.rest.action.RestResponseListener;
    @Override
            .addCell("state", "default:true;alias:st;desc:shard state")
            } else {
                table.addCell(null);
            table.addCell(getOrNull(commonStats, CommonStats::getFieldData, FieldDataStats::getEvictions));
        table.addCell("merges.current", "alias:mc,mergesCurrent;default:false;text-align:right;desc:number of current merges");
        table.addCell(
    public boolean isRequestLimitCheckSupported() {  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestShardsAction.class);  
import org.opensearch.index.refresh.RefreshStats;  
        table.addCell("seq_no.local_checkpoint", "alias:sql,localCheckpoint;default:false;text-align:right;desc:local checkpoint");
                    commonStats,  
            if (shardStats != null) {
import org.opensearch.common.Table;
            );  
            table.addCell(getOrNull(commonStats, CommonStats::getWarmer, WarmerStats::current));  
    }  
 */
        );  
            if (shard.primary()) {  
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getPitTime()));
            table.addCell(getOrNull(commonStats, CommonStats::getRefresh, RefreshStats::getListeners));
                        request,
        table.addCell("refresh.total", "alias:rto,refreshTotal;default:false;text-align:right;desc:total refreshes");
 * not use this file except in compliance with the License.
                    (c) -> c.getMerge() == null ? null : c.getMerge().getWarmerStats(),
            .addCell("prirep", "alias:p,pr,primaryOrReplica;default:true;desc:primary or replica")  
            table.addCell(  
        table.addCell("flush.total", "alias:ft,flushTotal;default:false;text-align:right;desc:number of flushes");
import org.opensearch.index.fielddata.FieldDataStats;
            "search.startree_query_failed",  
        );
        table.addCell(  
            table.addCell(
        table.endHeaders();
            );
        table.addCell(
                )  
        table.addCell(  
import org.opensearch.index.cache.query.QueryCacheStats;  
 *
        return true;
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getConcurrentQueryCurrent()));
                table.addCell(name);  
        table.addCell(  
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getQueryFailedCount()));
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getFetchCount()));
        );  
import org.opensearch.action.admin.cluster.shards.CatShardsAction;
import org.opensearch.cluster.routing.UnassignedInfo;
        table.addCell("docs.deleted", "alias:dd,docsDeleted;default:false;text-align:right;desc:number of deleted docs in shard");
import org.opensearch.common.unit.TimeValue;
                    commonStats,
        return true;
                    buildTable(
        RestRequest request,
                name.append(nodes.get(shard.currentNodeId()).getName());
        table.addCell("search.query_time", "alias:sqti,searchQueryTime;default:false;text-align:right;desc:time spent in query phase");  
                    name.append(" ");
                )  
import org.opensearch.cluster.routing.ShardRouting;  
            if (shard.recoverySource() != null) {
        table.addCell("get.missing_total", "alias:gmto,getMissingTotal;default:false;text-align:right;desc:number of failed gets");
        shardsRequest.setPageParams(pageParams);
 *    http://www.apache.org/licenses/LICENSE-2.0
    // package private for testing  
            "search.point_in_time_total",
        return "cat_shards_action";  
            "merges.warmer.total_send_time",  
            "alias:stqti,startreeQueryTime;default:false;text-align:right;desc:time spent in star tree queries"
            table.addCell(getOrNull(commonStats, CommonStats::getRefresh, RefreshStats::getTotal));  
                    name.append(" ");
        );
            "alias:mswtt,mergedSegmentWarmerTotalTime;default:false;text-align:right;desc:total wallclock time spent in the warming operation"
            "search.search_idle_reactivate_count_total",
            table.addCell(getOrNull(commonStats, CommonStats::getGet, GetStats::getMissingTime));
            "alias:idc,indexingDeleteCurrent;default:false;text-align:right;desc:number of current deletions"
        );
            .addCell("store", "alias:sto;text-align:right;desc:store size of shard (how much disk it uses)")  
/**
            table.startRow();
        table.addCell(
        table.addCell("search.query_total", "alias:sqto,searchQueryTotal;default:false;text-align:right;desc:total query phase ops");
        );  
            "merges.warmer.total_receive_time",
            table.addCell(getOrNull(commonStats, CommonStats::getQueryCache, QueryCacheStats::getMemorySize));  
        table.addCell(  
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getStarTreeQueryCurrent()));
    public List<Route> routes() {  
        Table table = new Table(pageToken);
                + " field types and type filters for types referred in _parent fields"
                table.addCell(shard.recoverySource().getType().toString().toLowerCase(Locale.ROOT));
        );  
            table.addCell(getOrNull(commonStats, CommonStats::getSegments, SegmentsStats::getZeroMemory));  
 * _cat API action to get shard information  
        table.addCell("refresh.time", "alias:rti,refreshTime;default:false;text-align:right;desc:time spent in refreshes");
 *
                    commonStats,
        return false;
        table.addCell(
 * KIND, either express or implied.  See the License for the
        shardsRequest.setIndices(indices);
import java.util.Locale;  
        table.addCell(
                    MergedSegmentWarmerStats::getTotalReceivedSize
            "alias:scqc,searchConcurrentQueryCurrent;default:false;text-align:right;desc:current concurrent query phase ops"
            table.addCell(getOrNull(commonStats, CommonStats::getWarmer, WarmerStats::totalTime));
            table.addCell(getOrNull(commonStats, CommonStats::getMerge, MergeStats::getTotalTime));
            table.addCell(  
            }
            }
            "merges.warmer.total_bytes_sent",  
                )
        table.addCell("unassigned.details", "alias:ud;default:false;desc:additional details as to why the shard became unassigned");
        final CatShardsRequest shardsRequest = new CatShardsRequest();
        return getTableWithHeader(request, null);
    ) {
    }
    private static <S, T> Object getOrNull(S stats, Function<S, T> accessor, Function<T, Object> func) {
                return func.apply(t);  
            table.addCell(getOrNull(commonStats, CommonStats::getMerge, MergeStats::getTotalNumDocs));
            table.addCell(getOrNull(shardStats, ShardStats::getSeqNoStats, SeqNoStats::getMaxSeqNo));
            .addCell("shard", "default:true;alias:s,sh;desc:shard name")
        return unmodifiableList(asList(new Route(GET, "/_cat/shards"), new Route(GET, "/_cat/shards/{index}")));
            "merges.warmer.total_time",  
                    MergedSegmentWarmerStats::getTotalReceiveTime  
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getQueryCurrent()));
        table.addCell("merges.total_docs", "alias:mtd,mergesTotalDocs;default:false;text-align:right;desc:docs merged");  
    @Override
            table.addCell(getOrNull(commonStats, CommonStats::getRefresh, RefreshStats::getTotalTime));
        table.addCell("refresh.external_total", "alias:rto,refreshTotal;default:false;text-align:right;desc:total external refreshes");  
            CommitStats commitStats = null;
                table.addCell(ip);
        PageToken pageToken  
            table.addCell(getOrNull(commonStats, CommonStats::getWarmer, WarmerStats::total));
}  
            table.addCell(getOrNull(commonStats, CommonStats::getFieldData, FieldDataStats::getMemorySize));  
            table.addCell(  
                    name.append(reloIp);
    }  
            "alias:siwm,segmentsIndexWriterMemory;default:false;text-align:right;desc:memory used by index writer"
            @Override
            table.addCell(getOrNull(commonStats, CommonStats::getQueryCache, QueryCacheStats::getEvictions));
        parseDeprecatedMasterTimeoutParameter(shardsRequest, request, deprecationLogger, getName());
                )
        table.addCell("indexing.index_time", "alias:iiti,indexingIndexTime;default:false;text-align:right;desc:time spent in indexing");
            table.addCell(getOrNull(shardStats, ShardStats::getSeqNoStats, SeqNoStats::getLocalCheckpoint));  
            "search.point_in_time_time",  
            table.addCell(
            "merges.warmer.total_failure_count",
                table.addCell("p");
                getOrNull(
            table.addCell(getOrNull(commonStats, CommonStats::getCompletion, CompletionStats::getSize));
            "alias:iic,indexingIndexCurrent;default:false;text-align:right;desc:number of current indexing ops"
        });
        table.addCell("seq_no.global_checkpoint", "alias:sqg,globalCheckpoint;default:false;text-align:right;desc:global checkpoint");  
            table.addCell(getOrNull(commonStats, CommonStats::getDocs, DocsStats::getDeleted));  
                );  
                return RestTable.buildResponse(  
                table.addCell(shard.unassignedInfo().getDetails());
            table.addCell(getOrNull(commonStats, CommonStats::getIndexing, i -> i.getTotal().getIndexCount()));
        final String[] indices = Strings.splitStringByCommaToArray(request.param("index"));  
            );
            "alias:iif,indexingIndexFailed;default:false;text-align:right;desc:number of failed indexing ops"
import org.opensearch.index.warmer.WarmerStats;
            "search.startree_query_total",
        table.addCell(  
        table.addCell(
        table.addCell(
import org.opensearch.action.admin.indices.stats.CommonStats;
                table.addCell(shard.unassignedInfo().getReason());
                )
        return channel -> client.execute(CatShardsAction.INSTANCE, shardsRequest, new RestResponseListener<CatShardsResponse>(channel) {  
    @Override
 * GitHub history for details.
        );
            table.addCell(getOrNull(commonStats, CommonStats::getMerge, MergeStats::getCurrent));
                        catShardsResponse.getPageToken()  
        );
        table.addCell(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        shardsRequest.setRequestLimitCheckSupported(isRequestLimitCheckSupported());  
            "alias:scqti,searchConcurrentQueryTime;default:false;text-align:right;desc:time spent in concurrent query phase"  
                    ),
            "alias:scqto,searchConcurrentQueryTotal;default:false;text-align:right;desc:total concurrent query phase ops"
            "segments.version_map_memory",
        );
            .addCell("ip", "default:true;desc:ip of node where it lives")
        );
        );
import org.opensearch.cluster.node.DiscoveryNodes;
            "alias:mswtrt,mergedSegmentWarmerTotalReceiveTime;default:false;text-align:right;desc:total wallclock time spent receiving merged segments by a replica shard"
import org.opensearch.index.get.GetStats;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.suggest.completion.CompletionStats;
                    commonStats,
import org.opensearch.index.shard.DocsStats;  
import org.opensearch.index.engine.SegmentsStats;  
 * Licensed to Elasticsearch under one or more contributor  
            "refresh.listeners",  
            );
import java.util.function.Function;
        table.addCell("unassigned.reason", "alias:ur;default:false;desc:reason shard is unassigned");
            "alias:mswtbs,mergedSegmentWarmerTotalBytesSent;default:false;text-align:right;desc:total bytes sent by a primary shard during the warm operation"
            table.addCell(
                    (c) -> c.getMerge() == null ? null : c.getMerge().getWarmerStats(),  
            "alias:mswti,mergedSegmentWarmerTotalInvocations;default:false;text-align:right;desc:total invocations of merged segment warmer"  
        table.addCell("warmer.total_time", "alias:wtt,warmerTotalTime;default:false;text-align:right;desc:time spent in warmers");
            }
        table.addCell("query_cache.memory_size", "alias:qcm,queryCacheMemory;default:false;text-align:right;desc:used query cache");
            table.addCell(getOrNull(commonStats, CommonStats::getFlush, FlushStats::getTotal));  
                StringBuilder name = new StringBuilder();  
        );  
                table.addCell(null);
        List<ShardRouting> responseShards,
            "alias:scti,searchScrollTime;default:false;text-align:right;desc:time scroll contexts held open"
            "alias:mcd,mergesCurrentDocs;default:false;text-align:right;desc:number of current merging docs"
            "merges.warmer.total_invocations",
        table.addCell(  
 *  
        shardsRequest.clusterManagerNodeTimeout(request.paramAsTime("cluster_manager_timeout", shardsRequest.clusterManagerNodeTimeout()));  
                    MergedSegmentWarmerStats::getOngoingCount  
        table.addCell("get.time", "alias:gti,getTime;default:false;text-align:right;desc:time spent in get");
            "alias:ssirct,searchSearchIdleReactivateCountTotal;default:false;text-align:right;desc:number of times a shard reactivated"  
        table.addCell("get.current", "alias:gc,getCurrent;default:false;text-align:right;desc:number of current get ops");
        table.addCell("get.exists_total", "alias:geto,getExistsTotal;default:false;text-align:right;desc:number of successful gets");
 * Unless required by applicable law or agreed to in writing,
import java.util.List;
    @Override
    public boolean isActionPaginated() {  
        table.addCell(
import org.opensearch.index.store.StoreStats;
            T t = accessor.apply(stats);
import org.opensearch.index.merge.MergeStats;
            "alias:sfbm,fixedBitsetMemory;default:false;text-align:right;desc:memory used by fixed bit sets for nested object"  
        table.addCell("search.fetch_total", "alias:sfto,searchFetchTotal;default:false;text-align:right;desc:total fetch ops");  
        );
 */  
    protected Table getTableWithHeader(final RestRequest request, final PageToken pageToken) {
        table.addCell("merges.total_time", "alias:mtt,mergesTotalTime;default:false;text-align:right;desc:time spent in merges");
        table.addCell("search.query_current", "alias:sqc,searchQueryCurrent;default:false;text-align:right;desc:current query phase ops");
        for (ShardRouting shard : responseShards) {
            table.addCell(getOrNull(commonStats, CommonStats::getIndexing, i -> i.getTotal().getIndexTime()));  
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getConcurrentQueryCount()));
        return null;  
            table.addCell(getOrNull(commonStats, CommonStats::getRefresh, RefreshStats::getExternalTotal));
            table.addCell(
            if (t != null) {
            "search.concurrent_query_time",
                    (c) -> c.getMerge() == null ? null : c.getMerge().getWarmerStats(),  
                getOrNull(
            "indexing.index_failed",
        table.addCell("get.missing_time", "alias:gmti,getMissingTime;default:false;text-align:right;desc:time spent in failed gets");  
 * under the License.  
            table.addCell(getOrNull(commonStats, CommonStats::getIndexing, i -> i.getTotal().getDeleteCount()));
            table.addCell(getOrNull(commonStats, CommonStats::getIndexing, i -> i.getTotal().getDeleteTime()));  
                        catShardsResponse.getNodes(),  
/*  
            table.addCell(commitStats == null ? null : commitStats.getUserData().get(Engine.SYNC_COMMIT_ID));
 * ownership. Elasticsearch licenses this file to you under  
            ShardStats shardStats = stats.asMap().get(shard);
import static org.opensearch.search.SearchService.NO_TIMEOUT;  
                    (c) -> c.getMerge() == null ? null : c.getMerge().getWarmerStats(),
        );  
        table.addCell("merges.total_size", "alias:mts,mergesTotalSize;default:false;text-align:right;desc:size merged");
    }  
                table.addCell(null);  
                if (shard.relocating()) {
import org.opensearch.index.flush.FlushStats;
            table.addCell(getOrNull(commonStats, CommonStats::getStore, StoreStats::getSize));
            );  
        }
            }
import static java.util.Arrays.asList;  
            if (shard.unassignedInfo() != null) {  
        table.addCell("get.exists_time", "alias:geti,getExistsTime;default:false;text-align:right;desc:time spent in successful gets");
            "segments.fixed_bitset_memory",
import static java.util.Collections.unmodifiableList;
            table.addCell(shard.state());  
            "search.point_in_time_current",
        table.addCell(  
    Table buildTable(
        table.addCell("search.open_contexts", "alias:so,searchOpenContexts;default:false;text-align:right;desc:open search contexts");
            .addCell("node", "default:true;alias:n;desc:name of node where it lives");  
    }
            table.addCell(getOrNull(shardStats, ShardStats::getStatePath, s -> s));
            }
    }
        table.addCell("query_cache.evictions", "alias:qce,queryCacheEvictions;default:false;text-align:right;desc:query cache evictions");
        );  
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getQueryCount()));  
            }
        table.addCell("get.total", "alias:gto,getTotal;default:false;text-align:right;desc:number of get ops");  
            } else {  
        table.addCell("indexing.delete_time", "alias:idti,indexingDeleteTime;default:false;text-align:right;desc:time spent in deletions");
                    name.append(reloNodeId);  
        );  
            "merges.current_docs",
import org.opensearch.action.admin.cluster.shards.CatShardsResponse;  
        );
            table.addCell(getOrNull(commonStats, CommonStats::getSegments, SegmentsStats::getIndexWriterMemory));
            "alias:mswoc,mergedSegmentWarmerOngoingCount;default:false;text-align:right;desc:point-in-time metric for number of in-progress warm operations"
        );
            "indexing.index_current",
            table.addCell(shard.id());
        table.addCell(
                )
            "alias:mswtbr,mergedSegmentWarmerTotalBytesReceived;default:false;text-align:right;desc:total bytes received by a replica shard during the warm operation"  
        table.startHeaders()  
    protected void documentation(StringBuilder sb) {  
                if (shard.isSearchOnly()) {  
        table.addCell("recoverysource.type", "alias:rs;default:false;desc:recovery source type");  
                table.addCell(TimeValue.timeValueMillis(System.currentTimeMillis() - shard.unassignedInfo().getUnassignedTimeInMillis()));
        table.addCell(
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getScrollCount()));
            table.addCell(getOrNull(commonStats, CommonStats::getMerge, MergeStats::getCurrentSize));  
        table.addCell("sync_id", "alias:sync_id;default:false;desc:sync id");
    }  
                getOrNull(
            "alias:svmm,segmentsVersionMapMemory;default:false;text-align:right;desc:memory used by version map"
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
        return table;
        table.addCell(
        sb.append("/_cat/shards/{index}\n");
            "search.startree_query_time",
                    commonStats,  
        );
            "alias:spto,searchPointInTimeTotal;default:false;text-align:right;desc:completed point in time contexts"
        );
        table.addCell("merges.current_size", "alias:mcs,mergesCurrentSize;default:false;text-align:right;desc:size of current merges");
        table.addCell("indexing.index_total", "alias:iito,indexingIndexTotal;default:false;text-align:right;desc:number of indexing ops");
        );
import org.opensearch.index.engine.Engine;
            "indexing.delete_current",
        table.addCell(
package org.opensearch.rest.action.cat;
        table.addCell("warmer.total", "alias:wto,warmerTotal;default:false;text-align:right;desc:total warmer ops");  
    }
                    MergedSegmentWarmerStats::getTotalSentSize
            "alias:spc,searchPointInTimeCurrent;default:false;text-align:right;desc:open point in time contexts"  
        table.addCell("indexing.delete_total", "alias:idto,indexingDeleteTotal;default:false;text-align:right;desc:number of delete ops");
        table.addCell("path.data", "alias:pd,dataPath;default:false;text-align:right;desc:shard data path");  
        );
            if (shard.assignedToNode()) {  
                    commonStats,
                table.addCell(nodeId);
                    (c) -> c.getMerge() == null ? null : c.getMerge().getWarmerStats(),  
                table.addCell(null);  
                getOrNull(  
            table.addCell(getOrNull(commonStats, CommonStats::getGet, GetStats::getExistsCount));
            table.addCell(getOrNull(commonStats, CommonStats::getIndexing, i -> i.getTotal().getIndexFailedCount()));
import org.opensearch.index.seqno.SeqNoStats;
 */  
import org.opensearch.index.search.stats.SearchStats;
            table.addCell(getOrNull(shardStats, ShardStats::getSeqNoStats, SeqNoStats::getGlobalCheckpoint));
        table.addCell("search.scroll_total", "alias:scto,searchScrollTotal;default:false;text-align:right;desc:completed scroll contexts");  
                )
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
        return table;
        table.addCell("segments.memory", "alias:sm,segmentsMemory;default:false;text-align:right;desc:memory used by segments");
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getQueryTime()));
                table.addCell(null);
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getScrollTime()));
            table.addCell(getOrNull(commonStats, CommonStats::getIndexing, i -> i.getTotal().getDeleteCurrent()));
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getScrollCurrent()));  
            "alias:mswtst,mergedSegmentWarmerTotalSendTime;default:false;text-align:right;desc:total wallclock time spent sending merged segments by a primary shard"
    @Override
                } else {
                table.addCell(null);
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getPitCount()));
        table.addCell("seq_no.max", "alias:sqm,maxSeqNo;default:false;text-align:right;desc:max sequence number");
            table.addCell(getOrNull(commonStats, CommonStats::getSegments, SegmentsStats::getCount));
            );
        table.addCell("search.scroll_current", "alias:scc,searchScrollCurrent;default:false;text-align:right;desc:open scroll contexts");
                getOrNull(
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getStarTreeQueryFailed()));
                    String reloNodeId = shard.relocatingNodeId();
        table.addCell(
 * compatible open source license.
/*  
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getConcurrentAvgSliceCount()));
        table.addCell("merges.total", "alias:mt,mergesTotal;default:false;text-align:right;desc:number of completed merge ops");
                    MergedSegmentWarmerStats::getTotalInvocationsCount
        );  
            table.addCell(getOrNull(commonStats, CommonStats::getIndexing, i -> i.getTotal().getIndexCurrent()));
 */  
 *
        if (stats != null) {  
            table.addCell(getOrNull(commonStats, CommonStats::getGet, GetStats::getCount));
                    (c) -> c.getMerge() == null ? null : c.getMerge().getWarmerStats(),
                    String reloIp = nodes.get(shard.relocatingNodeId()).getHostAddress();  
                commonStats = shardStats.getStats();  
            "segments.index_writer_memory",  
                commitStats = shardStats.getCommitStats();
        );
            "search.scroll_time",  
                    name.append(reloNme);
        sb.append("/_cat/shards\n");
        table.addCell(  
            table.addCell(getOrNull(commonStats, CommonStats::getMerge, MergeStats::getTotal));
            "search.concurrent_avg_slice_count",
                getOrNull(
            "search.concurrent_query_total",  
            table.addCell(getOrNull(commonStats, CommonStats::getDocs, DocsStats::getCount));
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.rest.RestRequest;  
            table.addCell(getOrNull(commonStats, CommonStats::getRefresh, RefreshStats::getExternalTotalTime));  
            table.addCell(getOrNull(commonStats, CommonStats::getGet, GetStats::getTime));
            table.addCell(getOrNull(commonStats, CommonStats::getMerge, MergeStats::getTotalSize));  
        );
            "search.concurrent_query_current",
    @Override
            table.addCell(shard.getIndexName());  
    }  
        table.addCell("fielddata.evictions", "alias:fe,fielddataEvictions;default:false;text-align:right;desc:fielddata evictions");
                )  
            table.addCell(getOrNull(commonStats, CommonStats::getGet, GetStats::getExistsTime));  
import org.opensearch.common.logging.DeprecationLogger;  
            }
                String nodeId = shard.currentNodeId();
import org.opensearch.action.admin.cluster.shards.CatShardsRequest;
            "alias:rti,refreshTime;default:false;text-align:right;desc:time spent in external refreshes"  
        table.addCell(  
            } else {
            "alias:stqc,startreeQueryCurrent;default:false;text-align:right;desc:current star tree query ops"
        table.addCell("unassigned.for", "alias:uf;default:false;text-align:right;desc:time has been unassigned");  
        table.addCell("warmer.current", "alias:wc,warmerCurrent;default:false;text-align:right;desc:current warmer ops");
    public boolean allowSystemIndexAccessByDefault() {
 * license agreements. See the NOTICE file distributed with
                String ip = nodes.get(shard.currentNodeId()).getHostAddress();
                }
                    MergedSegmentWarmerStats::getTotalSendTime
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;
        table.addCell(  
import org.opensearch.index.engine.CommitStats;
    @Override  
            "alias:mswtfc,mergedSegmentWarmerTotalFailureCount;default:false;text-align:right;desc:total failures in merged segment warmer"  
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getFetchCurrent()));  
/*
        table.addCell(
                Instant unassignedTime = Instant.ofEpochMilli(shard.unassignedInfo().getUnassignedTimeInMillis());
        table.addCell("fielddata.memory_size", "alias:fm,fielddataMemory;default:false;text-align:right;desc:used fielddata cache");
        );  
 * You may obtain a copy of the License at  
    }
            "alias:stqf,startreeQueryFailed;default:false;text-align:right;desc:failed star tree query ops"
        );
    public String getName() {
                    name.append(" -> ");  
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getPitCurrent()));  
    }
import java.time.Instant;
 * specific language governing permissions and limitations
            );  
        shardsRequest.setCancelAfterTimeInterval(request.paramAsTime("cancel_after_time_interval", NO_TIMEOUT));
            table.addCell(getOrNull(commonStats, CommonStats::getGet, GetStats::current));  
        Table table = getTableWithHeader(request, pageToken);
import org.opensearch.core.common.Strings;
                    MergedSegmentWarmerStats::getTotalFailureCount
import org.opensearch.rest.RestResponse;
            );
                        catShardsResponse.getIndicesStatsResponse(),
        table.addCell(
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getConcurrentQueryTime()));  
import org.opensearch.index.merge.MergedSegmentWarmerStats;
            "alias:stqto,startreeQueryTotal;default:false;text-align:right;desc:total star tree resolved queries"  
        }  
            "alias:rli,refreshListeners;default:false;text-align:right;desc:number of pending refresh listeners"
        IndicesStatsResponse stats,
        );  
        table.addCell(
        table.addCell("search.fetch_current", "alias:sfc,searchFetchCurrent;default:false;text-align:right;desc:current fetch phase ops");
            "merges.warmer.ongoing_count",
            table.addCell(getOrNull(commonStats, CommonStats::getMerge, MergeStats::getCurrentNumDocs));
            "alias:spti,searchPointInTimeTime;default:false;text-align:right;desc:time point in time contexts held open"
            "search.startree_query_current",  
        shardsRequest.local(request.paramAsBoolean("local", shardsRequest.local()));
            table.addCell(getOrNull(shardStats, ShardStats::getDataPath, s -> s));
            .addCell("id", "default:false;desc:unique id of node where it lives")
            table.addCell(getOrNull(commonStats, CommonStats::getSearch, i -> i.getTotal().getFetchTime()));
            .addCell("docs", "alias:d,dc;text-align:right;desc:number of docs in shard")
