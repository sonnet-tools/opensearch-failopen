            "alias:scc,searchPointInTimeCurrent;default:false;text-align:right;desc:open point in time contexts"  
            table.addCell(fcStats == null ? null : fcStats.getMissCount());
            "search.startree_query_total",  
 * compatible open source license.
        table.addCell(
            table.addCell(mergeStats == null ? null : mergeStats.getCurrent());  
            "search.point_in_time_time",  
        table.addCell("search.query_total", "alias:sqto,searchQueryTotal;default:false;text-align:right;desc:total query phase ops");  
            "alias:scrce,scriptCacheEvictions;default:false;text-align:right;desc:script cache evictions"
            "alias:rchc,requestCacheHitCount;default:false;text-align:right;desc:request cache hit counts"  
            table.addCell(clusterManagerId == null ? "x" : clusterManagerId.equals(node.getId()) ? "*" : "-");  
            "alias:scto,searchPointInTimeTotal;default:false;text-align:right;desc:completed point in time contexts"
            table.addCell(searchStats == null ? null : searchStats.getTotal().getSuggestCurrent());
        table.addCell(
        table.addCell(
            "alias:mswtrt,mergedSegmentWarmerTotalReceiveTime;default:false;text-align:right;desc:total wallclock time spent receiving merged segments by a replica shard"
            "search.point_in_time_total",
 * this work for additional information regarding copyright
            ProcessStats processStats = stats == null ? null : stats.getProcess();
            "script.compilation_limit_triggered",
            table.addCell(
import org.opensearch.script.ScriptStats;
                + " and type filters for types referred in _parent fields"  
 * specific language governing permissions and limitations
            "alias:stqf,startreeQueryFailed;default:false;text-align:right;desc:star tree failed query ops"
            table.addCell(segmentsStats == null ? null : segmentsStats.getCount());
            FsInfo fsInfo = stats == null ? null : stats.getFs();
import org.opensearch.http.HttpInfo;  
            if (fsInfo != null) {  
        table.addCell("search.fetch_total", "alias:sfto,searchFetchTotal;default:false;text-align:right;desc:total fetch ops");
            table.addCell(completionStats == null ? null : completionStats.getSize());
        final boolean fullId = request.paramAsBoolean("full_id", false);
            table.addCell(searchStats == null ? null : searchStats.getTotal().getStarTreeQueryFailed());
 * Licensed to Elasticsearch under one or more contributor  
    }  
                        NodesInfoRequest.Metric.OS.metricName(),
                table.addCell("-");  
            table.addCell(mergedSegmentWarmerStats == null ? null : mergedSegmentWarmerStats.getTotalSentSize());
            if (httpInfo != null) {
    public String getName() {
            "alias:qcmc,queryCacheMissCount;default:false;text-align:right;desc:query cache miss counts"
            public void processResponse(final ClusterStateResponse clusterStateResponse) {
            ScriptStats scriptStats = stats == null ? null : stats.getScriptStats();
        table.addCell("name", "alias:n;desc:node name");
        );
            if (node.getRoles().isEmpty()) {  
        table.addCell("indexing.index_total", "alias:iito,indexingIndexTotal;default:false;text-align:right;desc:number of indexing ops");
        table.addCell("file_desc.current", "default:false;alias:fdc,fileDescriptorCurrent;text-align:right;desc:used file descriptors");  
            JvmStats jvmStats = stats == null ? null : stats.getJvm();
            QueryCacheStats fcStats = indicesStats == null ? null : indicesStats.getQueryCache();
            "refresh.listeners",  
            table.addCell(allRoles);
            table.addCell(searchStats == null ? null : searchStats.getTotal().getScrollCount());  
            "search.query_failed",
    private short calculatePercentage(long used, long max) {
        DiscoveryNodes nodes = state.getState().nodes();
            "search.concurrent_query_current",  
            } else {
    Table buildTable(
            table.endRow();
            "merges.warmer.total_receive_time",
            table.addCell(indexingStats == null ? null : indexingStats.getTotal().getIndexFailedCount());  
            MergedSegmentWarmerStats mergedSegmentWarmerStats = mergeStats == null ? null : mergeStats.getWarmerStats();
        table.addCell("load_5m", "alias:l;text-align:right;desc:5m load avg");  
                        nodesStatsRequest.timeout(request.param("timeout"));
        );  
            table.addCell(scriptStats == null ? null : scriptStats.getCompilations());
                allRoles = node.getRoles().stream().map(DiscoveryNodeRole::roleName).sorted().collect(Collectors.joining(","));
 */
            table.addCell(searchStats == null ? null : searchStats.getTotal().getScrollTime());
        table.addCell(
                diskUsed = new ByteSizeValue(diskTotal.getBytes() - diskAvailable.getBytes());  
        table.addCell("indexing.index_time", "alias:iiti,indexingIndexTime;default:false;text-align:right;desc:time spent in indexing");
            request.paramAsTime("cluster_manager_timeout", clusterStateRequest.clusterManagerNodeTimeout())
            NodeStats stats = nodesStats.getNodesMap().get(node.getId());
            deprecationLogger.deprecate("cat_nodes_local_parameter", LOCAL_DEPRECATED_MESSAGE);
            "alias:mswtbs,mergedSegmentWarmerTotalBytesSent;default:false;text-align:right;desc:total bytes sent by a primary shard during the warm operation"
                nodesInfoRequest.clear()
        table.addCell("suggest.current", "alias:suc,suggestCurrent;default:false;text-align:right;desc:number of current suggest ops");  
            "alias:r,role,nodeRole;desc:m:master eligible node, d:data node, i:ingest node, -:coordinating node only"  
            "alias:scti,searchScrollTime;default:false;text-align:right;desc:time scroll contexts held open"  
            "segments.fixed_bitset_memory",
            ByteSizeValue diskTotal = null;
            "default:false;alias:fdp,fileDescriptorPercent;text-align:right;desc:used file descriptor ratio"  
     * @return 0 if {@code max} is &lt;= 0. Otherwise 100 * {@code used} / {@code max}.  
 *  
            table.addCell(jvmStats == null ? null : jvmStats.getMem().getHeapUsedPercent());
        );
                NodesInfoRequest nodesInfoRequest = new NodesInfoRequest();  
            ByteSizeValue diskUsed = null;  
            "alias:mswtbr,mergedSegmentWarmerTotalBytesReceived;default:false;text-align:right;desc:total bytes received by a replica shard during the warm operation"  
        table.addCell("search.query_current", "alias:sqc,searchQueryCurrent;default:false;text-align:right;desc:current query phase ops");
            table.addCell(info == null ? null : info.getBuild().hash());
                            @Override
            table.addCell(indexingStats == null ? null : indexingStats.getTotal().getDeleteTime());
        );
            NodeIndicesStats indicesStats = stats == null ? null : stats.getIndices();
        );  
                    @Override
            table.addCell(qcStats == null ? null : qcStats.getMemorySize());
        table.addCell("disk.avail", "default:false;alias:d,da,disk,diskAvail;text-align:right;desc:available disk space");
            "alias:mswtt,mergedSegmentWarmerTotalTime;default:false;text-align:right;desc:total wallclock time spent in the warming operation"
 *    http://www.apache.org/licenses/LICENSE-2.0
        table.addCell("get.current", "alias:gc,getCurrent;default:false;text-align:right;desc:number of current get ops");
            table.addCell(segmentsStats == null ? null : segmentsStats.getZeroMemory());
 * software distributed under the License is distributed on an
            "alias:scti,searchPointInTimeTime;default:false;text-align:right;desc:time point in time contexts held open"
                    ? null
        ClusterStateResponse state,
        table.addCell(  
            );  
import java.util.Locale;
            table.addCell(searchStats == null ? null : searchStats.getTotal().getConcurrentQueryTime());
        table.addCell(
            table.addCell(searchStats == null ? null : searchStats.getTotal().getConcurrentQueryCount());
            "alias:iif,indexingIndexFailed;default:false;text-align:right;desc:number of failed indexing ops"
 * not use this file except in compliance with the License.
            "search.startree_query_time",
            final HttpInfo httpInfo = info == null ? null : info.getInfo(HttpInfo.class);
    protected void documentation(StringBuilder sb) {
        table.addCell(  
            "segments.version_map_memory",  
            "search.startree_query_current",  
            table.addCell(
            CompletionStats completionStats = indicesStats == null ? null : stats.getIndices().getCompletion();  
            "merges.warmer.total_invocations",
        return max <= 0 ? 0 : (short) ((100d * used) / max);  
import org.opensearch.index.search.stats.SearchStats;
            table.addCell(indexingStats == null ? null : indexingStats.getTotal().getDeleteCount());
                table.addCell(NetworkAddress.format(transportAddress.address()));
import org.opensearch.common.logging.DeprecationLogger;
                    ? null
        table.addCell("node.roles", "alias:rs,all roles;desc: -:coordinating node only");
            RequestCacheStats qcStats = indicesStats == null ? null : indicesStats.getRequestCache();
        table.addCell(
            table.addCell(flushStats == null ? null : flushStats.getTotal());
            table.addCell(segmentsStats == null ? null : segmentsStats.getBitsetMemory());
            "segments.index_writer_memory",
            "script.cache_evictions",  
        table.addCell("uptime", "default:false;alias:u;text-align:right;desc:node uptime");
            table.addCell(  
            table.addCell(searchStats == null ? null : searchStats.getTotal().getScrollCurrent());
    public List<Route> routes() {  
                        NodesInfoRequest.Metric.JVM.metricName(),
        table.addCell(
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        );
            "request_cache.miss_count",  
                                NodesStatsRequest.Metric.PROCESS.metricName(),
                    : calculatePercentage(processStats.getOpenFileDescriptors(), processStats.getMaxFileDescriptors())
import org.opensearch.cluster.node.DiscoveryNode;  
            table.addCell(searchStats == null ? null : searchStats.getTotal().getFetchCurrent());
            "alias:stqc,startreeQueryCurrent;default:false;text-align:right;desc:current star tree query ops"
            "indexing.index_failed",
            table.addCell(scriptStats == null ? null : scriptStats.getCacheEvictions());  
            table.addCell(jvmStats == null ? null : jvmStats.getMem().getHeapUsed());
        table.addCell("id", "default:false;alias:id,nodeId;desc:unique node id");
            table.addCell(getStats == null ? null : getStats.current());  
                                    buildTable(fullId, request, clusterStateResponse, nodesInfoResponse, nodesStatsResponse),
import org.opensearch.core.common.transport.TransportAddress;
            "alias:casc,searchConcurrentAvgSliceCount;default:false;text-align:right;desc:average query concurrency"
import org.opensearch.cluster.node.DiscoveryNodeRole;
        );  
            table.addCell(indexingStats == null ? null : indexingStats.getTotal().getIndexTime());
import org.opensearch.index.merge.MergedSegmentWarmerStats;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
            "alias:idc,indexingDeleteCurrent;default:false;text-align:right;desc:number of current deletions"
 *
        table.addCell("refresh.external_total", "alias:rto,refreshTotal;default:false;text-align:right;desc:total external refreshes");  
        table.addCell(
            "merges.warmer.ongoing_count",
        return "cat_nodes_action";  
            "alias:mswti,mergedSegmentWarmerTotalInvocations;default:false;text-align:right;desc:total invocations of merged segment warmer"  
            table.addCell(refreshStats == null ? null : refreshStats.getListeners());
            "request_cache.hit_count",
            table.addCell(osStats == null ? null : osStats.getMem() == null ? null : osStats.getMem().getUsed());
                diskUsedPercent = String.format(Locale.ROOT, "%.2f", 100.0 * diskUsedRatio);  
        table.addCell("search.open_contexts", "alias:so,searchOpenContexts;default:false;text-align:right;desc:open search contexts");  
import org.opensearch.monitor.jvm.JvmStats;  
        table.addCell("get.total", "alias:gto,getTotal;default:false;text-align:right;desc:number of get ops");  
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
        table.addCell(  
    @Override  
        table.addCell("port", "default:false;alias:po;desc:bound transport port");
        table.addCell(  
        table.addCell("segments.memory", "alias:sm,segmentsMemory;default:false;text-align:right;desc:memory used by segments");  
                    : "-";
import org.opensearch.transport.client.node.NodeClient;
        );  
        table.addCell(
        table.addCell("cpu", "alias:cpu;text-align:right;desc:recent cpu usage");
            NodeInfo info = nodesInfo.getNodesMap().get(node.getId());  
        table.addCell("http_address", "default:false;alias:http;desc:bound http address");
        table.addCell("disk.used", "default:false;alias:du,diskUsed;text-align:right;desc:used disk space");  
        table.addCell(
        table.addCell("fielddata.memory_size", "alias:fm,fielddataMemory;default:false;text-align:right;desc:used fielddata cache");  
            "alias:scrclt,scriptCacheCompilationLimitTriggered;default:false;"
            "request_cache.evictions",
            table.addCell(segmentsStats == null ? null : segmentsStats.getIndexWriterMemory());  
     * @param used The currently used number.
                        NodesStatsRequest nodesStatsRequest = new NodesStatsRequest();  
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
        table.addCell("heap.max", "default:false;alias:hm,heapMax;text-align:right;desc:max configured heap");
            table.addCell(mergeStats == null ? null : mergeStats.getCurrentNumDocs());
        table.addCell(  
        table.addCell("pid", "default:false;alias:p;desc:process id");
        table.addCell("merges.current", "alias:mc,mergesCurrent;default:false;text-align:right;desc:number of current merges");
 *
        );
            "alias:scqc,searchConcurrentQueryCurrent;default:false;text-align:right;desc:current concurrent query phase ops"
        );
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
        table.addCell(
            table.addCell(fdStats == null ? null : fdStats.getEvictions());
            table.addCell(qcStats == null ? null : qcStats.getMissCount());
            table.addCell(searchStats == null ? null : searchStats.getTotal().getSuggestCount());  
            table.addCell(jvmStats == null ? null : jvmStats.getUptime());
import org.opensearch.index.flush.FlushStats;
import org.opensearch.monitor.process.ProcessInfo;
        table.addCell("search.scroll_total", "alias:scto,searchScrollTotal;default:false;text-align:right;desc:completed scroll contexts");
import static org.opensearch.rest.RestRequest.Method.GET;
                                NodesStatsRequest.Metric.OS.metricName(),  
                            }
        table.addCell("ram.current", "default:false;alias:rc,ramCurrent;text-align:right;desc:used machine memory");  
        table.addCell(  
        NodesStatsResponse nodesStats
 */  
        table.addCell(
            "alias:sfbm,fixedBitsetMemory;default:false;text-align:right;desc:memory used by fixed bit sets for nested object field types"
        RestRequest req,
            "merges.warmer.total_send_time",  
        parseDeprecatedMasterTimeoutParameter(clusterStateRequest, request, deprecationLogger, getName());
        Table table = new Table();
        table.addCell("cluster_manager", "alias:cm,m,master;desc:*:current cluster manager");
            table.addCell(osStats == null ? null : osStats.getMem() == null ? null : osStats.getMem().getUsedPercent());
import org.opensearch.index.cache.request.RequestCacheStats;
        table.endHeaders();
            table.addCell(mergedSegmentWarmerStats == null ? null : mergedSegmentWarmerStats.getTotalReceiveTime());
            table.addCell(diskUsed);  
        table.addCell("flush.total_time", "alias:ftt,flushTotalTime;default:false;text-align:right;desc:time spent in flush");
        table.addCell("suggest.time", "alias:suti,suggestTime;default:false;text-align:right;desc:time spend in suggest");
                        NodesInfoRequest.Metric.HTTP.metricName()
import org.opensearch.core.common.Strings;  
import org.opensearch.common.Table;  
        table.addCell("disk.used_percent", "default:false;alias:dup,diskUsedPercent;text-align:right;desc:used disk space percentage");
            );  
        table.addCell("query_cache.hit_count", "alias:qchc,queryCacheHitCount;default:false;text-align:right;desc:query cache hit counts");
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;  
        clusterStateRequest.clusterManagerNodeTimeout(
                        nodesStatsRequest.clear()
                roles = "-";
                    : String.format(Locale.ROOT, "%.2f", osStats.getCpu().getLoadAverage()[1])
                    : String.format(Locale.ROOT, "%.2f", osStats.getCpu().getLoadAverage()[0])
 * GitHub history for details.
                roles = knownNodeRoles.size() > 0
 * the Apache License, Version 2.0 (the "License"); you may
        table.addCell(
            table.addCell(indexingStats == null ? null : indexingStats.getTotal().getDeleteCurrent());  
        );
import org.opensearch.core.common.unit.ByteSizeValue;
            table.startRow();
            table.addCell(searchStats == null ? null : searchStats.getTotal().getPitCount());  
            table.addCell(getStats == null ? null : getStats.getExistsCount());
            "node.role",
                diskTotal = fsInfo.getTotal().getTotal();
import org.opensearch.index.fielddata.FieldDataStats;
        );
            @Override
        Table table = getTableWithHeader(req);  
            "alias:siwm,segmentsIndexWriterMemory;default:false;text-align:right;desc:memory used by index writer"  
            "search.concurrent_query_time",
            IndexingStats indexingStats = indicesStats == null ? null : indicesStats.getIndexing();
            table.addCell(searchStats == null ? null : searchStats.getTotal().getQueryTime());  
        table.addCell(  
                        client.admin().cluster().nodesStats(nodesStatsRequest, new RestResponseListener<NodesStatsResponse>(channel) {  
            table.addCell(info == null ? null : info.getBuild().type().displayName());
import org.opensearch.rest.RestRequest;
        // TODO: Remove the header alias 'master', after removing MASTER_ROLE. It's added for compatibility when using parameter 'h=master'.  
            "search.concurrent_avg_slice_count",  
            OsStats osStats = stats == null ? null : stats.getOs();  
            "merges.warmer.total_time",  
            table.addCell(getStats == null ? null : getStats.getTime());
                    .stream()
        table.addCell("heap.current", "default:false;alias:hc,heapCurrent;text-align:right;desc:used heap");  
        table.addCell("search.fetch_current", "alias:sfc,searchFetchCurrent;default:false;text-align:right;desc:current fetch phase ops");  
        table.addCell("merges.total_docs", "alias:mtd,mergesTotalDocs;default:false;text-align:right;desc:docs merged");  
                    .filter(DiscoveryNodeRole::isKnownRole)  
        table.addCell(
            table.addCell(mergedSegmentWarmerStats == null ? null : mergedSegmentWarmerStats.getOngoingCount());
        );
        table.addCell("indexing.delete_time", "alias:idti,indexingDeleteTime;default:false;text-align:right;desc:time spent in deletions");
        );  
        table.addCell(
                List<DiscoveryNodeRole> knownNodeRoles = node.getRoles()
        );
            }  
            "query_cache.miss_count",
}
            table.addCell(qcStats == null ? null : qcStats.getEvictions());  
     * Calculate the percentage of {@code used} from the {@code max} number.  
            table.addCell(refreshStats == null ? null : refreshStats.getTotalTime());
                });
        );
        );
        );  
        table.addCell("get.missing_time", "alias:gmti,getMissingTime;default:false;text-align:right;desc:time spent in failed gets");  
                allRoles = "-";
    static final String LOCAL_DEPRECATED_MESSAGE = "Deprecated parameter [local] used. This parameter does not cause this API to act "
            } else {  
        );
import org.opensearch.index.merge.MergeStats;
            table.addCell(fcStats == null ? null : fcStats.getHitCount());
            "merges.warmer.total_failure_count",
 */
        table.addCell("get.missing_total", "alias:gmto,getMissingTotal;default:false;text-align:right;desc:number of failed gets");
import org.opensearch.rest.RestResponse;
    @Override
            String diskUsedPercent = null;
            table.addCell(jvmInfo == null ? null : jvmInfo.version());  
            table.addCell(node.getHostAddress());
            table.addCell(diskTotal);
                processStats == null  
        );
            table.addCell(mergedSegmentWarmerStats == null ? null : mergedSegmentWarmerStats.getTotalInvocationsCount());  
import org.opensearch.index.cache.query.QueryCacheStats;
import org.opensearch.index.engine.SegmentsStats;  
 * Modifications Copyright OpenSearch Contributors. See
            table.addCell(node.getName());
        return table;
                                NodesStatsRequest.Metric.JVM.metricName(),
 * Unless required by applicable law or agreed to in writing,
            );
            table.addCell(qcStats == null ? null : qcStats.getHitCount());
                nodesInfoRequest.timeout(request.param("timeout"));
            table.addCell(processStats == null ? null : processStats.getMaxFileDescriptors());
                            .addMetrics(
        table.addCell("merges.total_size", "alias:mts,mergesTotalSize;default:false;text-align:right;desc:size merged");
                !hasLoadAverage || osStats.getCpu().getLoadAverage()[1] == -1
            "search.scroll_time",
        table.addCell(
        table.addCell("get.time", "alias:gti,getTime;default:false;text-align:right;desc:time spent in get");
            table.addCell(
            "indexing.index_current",
            table.addCell(getStats == null ? null : getStats.getMissingCount());  
            table.addCell(fdStats == null ? null : fdStats.getMemorySize());
            table.addCell(node.getVersion().toString());  
    protected Table getTableWithHeader(final RestRequest request) {
            table.addCell(mergedSegmentWarmerStats == null ? null : mergedSegmentWarmerStats.getTotalTime());
    }
        table.addCell("completion.size", "alias:cs,completionSize;default:false;text-align:right;desc:size of completion");
        );
        if (request.hasParam("local")) {  
            "alias:rti,refreshTime;default:false;text-align:right;desc:time spent in external refreshes"  
        );  
                !hasLoadAverage || osStats.getCpu().getLoadAverage()[0] == -1  
                + "text-align:right;desc:script cache compilation limit triggered"  
                    ? knownNodeRoles.stream().map(DiscoveryNodeRole::roleNameAbbreviation).sorted().collect(Collectors.joining())  
import org.opensearch.common.network.NetworkAddress;
        );
    @Override
            table.addCell(searchStats == null ? null : searchStats.getTotal().getConcurrentAvgSliceCount());  
        );
            RefreshStats refreshStats = indicesStats == null ? null : indicesStats.getRefresh();  
                            public RestResponse buildResponse(NodesStatsResponse nodesStatsResponse) throws Exception {
            "alias:stqto,startreeQueryTotal;default:false;text-align:right;desc:total star tree resolved queries"
            FlushStats flushStats = indicesStats == null ? null : indicesStats.getFlush();
        table.addCell("merges.total_time", "alias:mtt,mergesTotalTime;default:false;text-align:right;desc:time spent in merges");
 */  
            table.addCell(scriptStats == null ? null : scriptStats.getCompilationLimitTriggered());
            table.addCell(roles);
            table.addCell(diskAvailable);
        return channel -> client.admin().cluster().state(clusterStateRequest, new RestActionListener<ClusterStateResponse>(channel) {  
import org.opensearch.indices.NodeIndicesStats;  
        clusterStateRequest.local(request.paramAsBoolean("local", clusterStateRequest.local()));  
            table.addCell(jvmInfo == null ? null : jvmInfo.getMem().getHeapMax());  
 * You may obtain a copy of the License at  
            table.addCell(fcStats == null ? null : fcStats.getMemorySize());
            "alias:mswtst,mergedSegmentWarmerTotalSendTime;default:false;text-align:right;desc:total wallclock time spent sending merged segments by a primary shard"
                                    channel
public class RestNodesAction extends AbstractCatAction {  
        );
    }
            table.addCell(searchStats == null ? null : searchStats.getTotal().getQueryCount());
 * SPDX-License-Identifier: Apache-2.0
        table.addCell("search.scroll_current", "alias:scc,searchScrollCurrent;default:false;text-align:right;desc:open scroll contexts");  
    }  
            table.addCell(mergeStats == null ? null : mergeStats.getTotalTime());  
        + "locally, and should not be used. It will be unsupported in version 8.0.";  
                client.admin().cluster().nodesInfo(nodesInfoRequest, new RestActionListener<NodesInfoResponse>(channel) {  
import org.opensearch.index.refresh.RefreshStats;  
        table.addCell("ram.max", "default:false;alias:rm,ramMax;text-align:right;desc:total machine memory");
            table.addCell(flushStats == null ? null : flushStats.getTotalTime());  
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {  
                TransportAddress transportAddress = httpInfo.getAddress().publishAddress();  
        table.addCell("indexing.delete_total", "alias:idto,indexingDeleteTotal;default:false;text-align:right;desc:number of delete ops");
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        table.addCell("ip", "alias:i;desc:ip address");  
     */
            table.addCell(getStats == null ? null : getStats.getExistsTime());  
        table.addCell(
            table.addCell(indexingStats == null ? null : indexingStats.getTotal().getIndexCurrent());  
import org.opensearch.search.suggest.completion.CompletionStats;  
            table.addCell(osStats == null ? null : osStats.getMem() == null ? null : osStats.getMem().getTotal());  
            table.addCell(searchStats == null ? null : searchStats.getTotal().getQueryFailedCount());
        table.startHeaders();  
            table.addCell(mergedSegmentWarmerStats == null ? null : mergedSegmentWarmerStats.getTotalSendTime());
import static java.util.Collections.singletonList;
        table.addCell("refresh.total", "alias:rto,refreshTotal;default:false;text-align:right;desc:total refreshes");
            MergeStats mergeStats = indicesStats == null ? null : indicesStats.getMerge();
            "alias:scqti,searchConcurrentQueryTime;default:false;text-align:right;desc:time spent in concurrent query phase"
            );
            "search.startree_query_failed",
        for (DiscoveryNode node : nodes) {
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestNodesAction.class);
        );  
            table.addCell(processStats == null ? null : processStats.getOpenFileDescriptors());
            table.addCell(searchStats == null ? null : searchStats.getTotal().getPitCurrent());
    }
            table.addCell(osStats == null ? null : Short.toString(osStats.getCpu().getPercent()));  
        );
        table.addCell("version", "default:false;alias:v;desc:os version");
        table.addCell("query_cache.memory_size", "alias:qcm,queryCacheMemory;default:false;text-align:right;desc:used query cache");  
        sb.append("/_cat/nodes\n");
/*  
/*  
            "indexing.delete_current",
            }
            "alias:iic,indexingIndexCurrent;default:false;text-align:right;desc:number of current indexing ops"
            SegmentsStats segmentsStats = indicesStats == null ? null : indicesStats.getSegments();  
        );
                        NodesInfoRequest.Metric.PROCESS.metricName(),  
                diskAvailable = fsInfo.getTotal().getAvailable();
        table.addCell("segments.count", "alias:sc,segmentsCount;default:false;text-align:right;desc:number of segments");
            table.addCell(searchStats == null ? null : searchStats.getOpenContexts());
            SearchStats searchStats = indicesStats == null ? null : indicesStats.getSearch();  
                                NodesStatsRequest.Metric.FS.metricName(),
 * under the License.  
            table.addCell(diskUsedPercent);
        table.addCell("get.exists_time", "alias:geti,getExistsTime;default:false;text-align:right;desc:time spent in successful gets");
        );  
        );  
                    ? null
            table.addCell(node.getAddress().address().getPort());  
        table.addCell("heap.percent", "alias:hp,heapPercent;text-align:right;desc:used heap ratio");
        table.addCell("search.query_time", "alias:sqti,searchQueryTime;default:false;text-align:right;desc:time spent in query phase");
            "alias:mcd,mergesCurrentDocs;default:false;text-align:right;desc:number of current merging docs"
        return table;
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
import org.opensearch.monitor.os.OsStats;
            table.addCell(searchStats == null ? null : searchStats.getTotal().getQueryCurrent());
                    }  
        );
    ) {
            "alias:sqf,searchQueryFailed;default:false;text-align:right;desc:total failed query phase ops"  
                !hasLoadAverage || osStats.getCpu().getLoadAverage()[2] == -1
                    );
            table.addCell(refreshStats == null ? null : refreshStats.getExternalTotalTime());
import org.opensearch.monitor.fs.FsInfo;
        table.addCell("script.compilations", "alias:scrcc,scriptCompilations;default:false;text-align:right;desc:script compilations");
                    : String.format(Locale.ROOT, "%.2f", osStats.getCpu().getLoadAverage()[2])  
        table.addCell(
        table.addCell(
        table.addCell("disk.total", "default:false;alias:dt,diskTotal;text-align:right;desc:total disk space");
            table.addCell(info == null ? null : info.getInfo(ProcessInfo.class).getId());
        String clusterManagerId = nodes.getClusterManagerNodeId();
            table.addCell(refreshStats == null ? null : refreshStats.getTotal());
import org.opensearch.rest.action.RestActionListener;  
                            );
            "search.concurrent_query_total",
import org.opensearch.index.get.GetStats;  
            }
            table.addCell(mergeStats == null ? null : mergeStats.getTotalNumDocs());
 * license agreements. See the NOTICE file distributed with
            "merges.current_docs",
            table.addCell(fcStats == null ? null : fcStats.getEvictions());  
        table.addCell(  
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;  
            "alias:mswoc,mergedSegmentWarmerOngoingCount;default:false;text-align:right;desc:point-in-time metric for number of in-progress warm operations"
        table.addCell("flush.total", "alias:ft,flushTotal;default:false;text-align:right;desc:number of flushes");
            table.addCell(mergedSegmentWarmerStats == null ? null : mergedSegmentWarmerStats.getTotalFailureCount());  
        table.addCell("request_cache.memory_size", "alias:rcm,requestCacheMemory;default:false;text-align:right;desc:used request cache");
        return singletonList(new Route(GET, "/_cat/nodes"));
        table.addCell("load_15m", "alias:l;text-align:right;desc:15m load avg");
import org.opensearch.rest.action.RestResponseListener;
 * ownership. Elasticsearch licenses this file to you under  
        table.addCell(  
            table.addCell(indexingStats == null ? null : indexingStats.getTotal().getIndexCount());
            table.addCell(getStats == null ? null : getStats.getMissingTime());
                                NodesStatsRequest.Metric.SCRIPT.metricName()  
            "alias:svmm,segmentsVersionMapMemory;default:false;text-align:right;desc:memory used by version map"
        table.addCell("ram.percent", "alias:rp,ramPercent;text-align:right;desc:used machine memory ratio");
        );
            table.addCell(searchStats == null ? null : searchStats.getTotal().getPitTime());
            "alias:rcmc,requestCacheMissCount;default:false;text-align:right;desc:request cache miss counts"
        table.addCell(  
        );
            table.addCell(getStats == null ? null : getStats.getCount());
            final String allRoles;
 * @opensearch.api
            table.addCell(searchStats == null ? null : searchStats.getTotal().getStarTreeQueryCount());  
            boolean hasLoadAverage = osStats != null && osStats.getCpu().getLoadAverage() != null;
 *  
        table.addCell("file_desc.max", "default:false;alias:fdm,fileDescriptorMax;text-align:right;desc:max file descriptors");
        table.addCell(  
            "file_desc.percent",
            "refresh.external_time",
            "alias:scqto,searchConcurrentQueryTotal;default:false;text-align:right;desc:total concurrent query phase ops"  
        }
            table.addCell(mergeStats == null ? null : mergeStats.getCurrentSize());
        table.addCell(  
            final String roles;
    @Override
        }  
            "search.point_in_time_current",
        );
    /**
        table.addCell(  
            table.addCell(searchStats == null ? null : searchStats.getTotal().getSuggestTime());
     * @param max The maximum number.
import org.opensearch.cluster.node.DiscoveryNodes;
                    .addMetrics(  
        );
            ByteSizeValue diskAvailable = null;
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        // TODO: Deprecate "node.role", use "node.roles" which shows full node role names  
        table.addCell(
        table.addCell("load_1m", "alias:l;text-align:right;desc:1m load avg");
            table.addCell(mergeStats == null ? null : mergeStats.getTotal());  
            table.addCell(fullId ? node.getId() : Strings.substring(node.getId(), 0, 4));  
        );
                        nodesStatsRequest.indices().setIncludeIndicesStatsByLevel(true);
        );  
        clusterStateRequest.clear().nodes(true);
        table.addCell("merges.current_size", "alias:mcs,mergesCurrentSize;default:false;text-align:right;desc:size of current merges");
import org.opensearch.monitor.jvm.JvmInfo;
            table.addCell(searchStats == null ? null : searchStats.getTotal().getFetchTime());
            table.addCell(searchStats == null ? null : searchStats.getTotal().getFetchCount());  
        table.addCell("refresh.time", "alias:rti,refreshTime;default:false;text-align:right;desc:time spent in refreshes");
            }
            "merges.warmer.total_bytes_sent",  
                        });
            table.addCell(searchStats == null ? null : searchStats.getTotal().getConcurrentQueryCurrent());  
        NodesInfoResponse nodesInfo,  
        table.addCell(
            table.addCell(searchStats == null ? null : searchStats.getTotal().getStarTreeQueryCurrent());
        table.addCell(
/**
        table.addCell("get.exists_total", "alias:geto,getExistsTotal;default:false;text-align:right;desc:number of successful gets");
        table.addCell("search.fetch_time", "alias:sfti,searchFetchTime;default:false;text-align:right;desc:time spent in fetch phase");
 * The OpenSearch Contributors require contributions made to  
        );  
        table.addCell("type", "default:false;alias:t;desc:os distribution type");
        table.addCell("build", "default:false;alias:b;desc:os build hash");  
            table.addCell(searchStats == null ? null : searchStats.getTotal().getStarTreeQueryTime());
            GetStats getStats = indicesStats == null ? null : indicesStats.getGet();
                                );  
        table.addCell("fielddata.evictions", "alias:fe,fielddataEvictions;default:false;text-align:right;desc:fielddata evictions");
                double diskUsedRatio = diskTotal.getBytes() == 0 ? 1.0 : (double) diskUsed.getBytes() / diskTotal.getBytes();
    }
    }  
                            .indices(true)  
        boolean fullId,  
        table.addCell(
import java.util.stream.Collectors;
            table.addCell(mergedSegmentWarmerStats == null ? null : mergedSegmentWarmerStats.getTotalReceivedSize());  
                    .collect(Collectors.toList());
        table.addCell("suggest.total", "alias:suto,suggestTotal;default:false;text-align:right;desc:number of suggest ops");
            "alias:stqti,startreeQueryTime;default:false;text-align:right;desc:time spent in star tree queries"  
        table.addCell("merges.total", "alias:mt,mergesTotal;default:false;text-align:right;desc:number of completed merge ops");
                                return RestTable.buildResponse(  
        table.addCell("jdk", "default:false;alias:j;desc:jdk version");
/*
            "alias:mswtfc,mergedSegmentWarmerTotalFailureCount;default:false;text-align:right;desc:total failures in merged segment warmer"  
                    public void processResponse(final NodesInfoResponse nodesInfoResponse) {
                    ? null  
        table.addCell(
import org.opensearch.index.shard.IndexingStats;
            table.addCell(mergeStats == null ? null : mergeStats.getTotalSize());
            FieldDataStats fdStats = indicesStats == null ? null : stats.getIndices().getFieldData();  
        table.addCell("query_cache.evictions", "alias:qce,queryCacheEvictions;default:false;text-align:right;desc:query cache evictions");
        table.addCell(
package org.opensearch.rest.action.cat;
    @Override  
import org.opensearch.monitor.process.ProcessStats;  
 * _cat API action to get node information
            table.addCell(refreshStats == null ? null : refreshStats.getExternalTotal());  
        });  
            "alias:rce,requestCacheEvictions;default:false;text-align:right;desc:request cache evictions"
            JvmInfo jvmInfo = info == null ? null : info.getInfo(JvmInfo.class);  
            table.addCell(segmentsStats == null ? null : segmentsStats.getVersionMapMemory());
            "merges.warmer.total_bytes_received",
            "alias:rli,refreshListeners;default:false;text-align:right;" + "desc:number of pending refresh listeners"
        );
