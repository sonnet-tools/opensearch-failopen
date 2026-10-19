            table.addCell(scriptStats == null ? null : scriptStats.getCacheEvictions());
            "alias:stqto,startreeQueryTotal;default:false;text-align:right;desc:total star tree resolved queries"
            "script.compilation_limit_triggered",
            table.addCell(indexingStats == null ? null : indexingStats.getTotal().getDeleteTime());
            table.addCell(mergedSegmentWarmerStats == null ? null : mergedSegmentWarmerStats.getTotalReceiveTime());
            "search.point_in_time_current",
        table.addCell("uptime", "default:false;alias:u;text-align:right;desc:node uptime");
            "alias:mswtbr,mergedSegmentWarmerTotalBytesReceived;default:false;text-align:right;desc:total bytes received by a replica shard during the warm operation"
                            .indices(true)
        table.addCell("cpu", "alias:cpu;text-align:right;desc:recent cpu usage");
import org.opensearch.core.common.transport.TransportAddress;
            "alias:r,role,nodeRole;desc:m:master eligible node, d:data node, i:ingest node, -:coordinating node only"
        table.addCell("heap.current", "default:false;alias:hc,heapCurrent;text-align:right;desc:used heap");
        return channel -> client.admin().cluster().state(clusterStateRequest, new RestActionListener<ClusterStateResponse>(channel) {
        table.addCell("type", "default:false;alias:t;desc:os distribution type");
 * compatible open source license.
import org.opensearch.monitor.process.ProcessInfo;
 * @opensearch.api
                processStats == null
        table.addCell("indexing.index_total", "alias:iito,indexingIndexTotal;default:false;text-align:right;desc:number of indexing ops");
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.rest.RestRequest;
            table.addCell(searchStats == null ? null : searchStats.getTotal().getConcurrentQueryTime());
        table.endHeaders();
                !hasLoadAverage || osStats.getCpu().getLoadAverage()[0] == -1
        table.addCell(
            "alias:mswtrt,mergedSegmentWarmerTotalReceiveTime;default:false;text-align:right;desc:total wallclock time spent receiving merged segments by a replica shard"
                    ? null
        table.addCell("get.current", "alias:gc,getCurrent;default:false;text-align:right;desc:number of current get ops");
        );
    @Override
        table.addCell("indexing.delete_total", "alias:idto,indexingDeleteTotal;default:false;text-align:right;desc:number of delete ops");
            }
            );
    }
        table.addCell("get.exists_time", "alias:geti,getExistsTime;default:false;text-align:right;desc:time spent in successful gets");
            table.addCell(segmentsStats == null ? null : segmentsStats.getBitsetMemory());
        table.addCell("load_15m", "alias:l;text-align:right;desc:15m load avg");
                                );
                        });
        table.addCell("port", "default:false;alias:po;desc:bound transport port");
import org.opensearch.rest.action.RestResponseListener;
    static final String LOCAL_DEPRECATED_MESSAGE = "Deprecated parameter [local] used. This parameter does not cause this API to act "
                diskAvailable = fsInfo.getTotal().getAvailable();
                        NodesInfoRequest.Metric.OS.metricName(),
            SearchStats searchStats = indicesStats == null ? null : indicesStats.getSearch();
                        NodesInfoRequest.Metric.JVM.metricName(),
            "alias:siwm,segmentsIndexWriterMemory;default:false;text-align:right;desc:memory used by index writer"
 * KIND, either express or implied.  See the License for the
        table.addCell(
import org.opensearch.cluster.node.DiscoveryNodeRole;
        table.addCell("heap.max", "default:false;alias:hm,heapMax;text-align:right;desc:max configured heap");
 */
            table.addCell(getStats == null ? null : getStats.getCount());
    ) {
        table.addCell(
            table.addCell(osStats == null ? null : osStats.getMem() == null ? null : osStats.getMem().getUsed());
        NodesInfoResponse nodesInfo,
        );
            table.addCell(searchStats == null ? null : searchStats.getTotal().getStarTreeQueryCount());
            "alias:mswtst,mergedSegmentWarmerTotalSendTime;default:false;text-align:right;desc:total wallclock time spent sending merged segments by a primary shard"
 * this file be licensed under the Apache-2.0 license or a
        table.addCell("script.compilations", "alias:scrcc,scriptCompilations;default:false;text-align:right;desc:script compilations");
/*
            "alias:qcmc,queryCacheMissCount;default:false;text-align:right;desc:query cache miss counts"
        table.addCell(
            table.addCell(refreshStats == null ? null : refreshStats.getTotalTime());
 */
            table.addCell(mergedSegmentWarmerStats == null ? null : mergedSegmentWarmerStats.getTotalInvocationsCount());
            table.addCell(mergeStats == null ? null : mergeStats.getTotalNumDocs());
        );
            final String roles;
    @Override
            table.addCell(osStats == null ? null : osStats.getMem() == null ? null : osStats.getMem().getTotal());
            );
                    : "-";
            table.addCell(mergeStats == null ? null : mergeStats.getTotalSize());
import org.opensearch.monitor.jvm.JvmInfo;
            table.addCell(
        table.addCell(
            "alias:mswoc,mergedSegmentWarmerOngoingCount;default:false;text-align:right;desc:point-in-time metric for number of in-progress warm operations"
            "search.point_in_time_total",
        table.addCell(
            "segments.version_map_memory",
import org.opensearch.search.suggest.completion.CompletionStats;
        );
            table.addCell(refreshStats == null ? null : refreshStats.getExternalTotalTime());
        );
        table.addCell("file_desc.current", "default:false;alias:fdc,fileDescriptorCurrent;text-align:right;desc:used file descriptors");
 * specific language governing permissions and limitations
            "merges.warmer.total_bytes_sent",
import static org.opensearch.rest.RestRequest.Method.GET;
                nodesInfoRequest.timeout(request.param("timeout"));
    protected Table getTableWithHeader(final RestRequest request) {
            table.addCell(searchStats == null ? null : searchStats.getTotal().getConcurrentQueryCurrent());
            table.addCell(fdStats == null ? null : fdStats.getEvictions());
            table.addCell(indexingStats == null ? null : indexingStats.getTotal().getDeleteCount());
                diskTotal = fsInfo.getTotal().getTotal();
        );
                diskUsedPercent = String.format(Locale.ROOT, "%.2f", 100.0 * diskUsedRatio);
            table.addCell(fcStats == null ? null : fcStats.getMemorySize());
        table.addCell(
            table.addCell(qcStats == null ? null : qcStats.getMissCount());
            NodeIndicesStats indicesStats = stats == null ? null : stats.getIndices();
                allRoles = "-";
        );
            table.addCell(info == null ? null : info.getBuild().type().displayName());
        table.addCell("heap.percent", "alias:hp,heapPercent;text-align:right;desc:used heap ratio");
    @Override
            ScriptStats scriptStats = stats == null ? null : stats.getScriptStats();
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
            "alias:scto,searchPointInTimeTotal;default:false;text-align:right;desc:completed point in time contexts"
                diskUsed = new ByteSizeValue(diskTotal.getBytes() - diskAvailable.getBytes());
            "search.startree_query_time",
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
/*
            RequestCacheStats qcStats = indicesStats == null ? null : indicesStats.getRequestCache();
                                NodesStatsRequest.Metric.OS.metricName(),
            boolean hasLoadAverage = osStats != null && osStats.getCpu().getLoadAverage() != null;
        );
            table.addCell(indexingStats == null ? null : indexingStats.getTotal().getIndexFailedCount());
            table.addCell(indexingStats == null ? null : indexingStats.getTotal().getIndexCount());
                });
            table.addCell(searchStats == null ? null : searchStats.getTotal().getFetchTime());
                table.addCell("-");
                            @Override
 * ownership. Elasticsearch licenses this file to you under
            table.addCell(searchStats == null ? null : searchStats.getOpenContexts());
            FieldDataStats fdStats = indicesStats == null ? null : stats.getIndices().getFieldData();
import org.opensearch.indices.NodeIndicesStats;
        );
        return max <= 0 ? 0 : (short) ((100d * used) / max);
        table.addCell(
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
                            .addMetrics(
                            );
        table.addCell("load_1m", "alias:l;text-align:right;desc:1m load avg");
            ByteSizeValue diskUsed = null;
        table.addCell("merges.current_size", "alias:mcs,mergesCurrentSize;default:false;text-align:right;desc:size of current merges");
            }
import org.opensearch.rest.RestResponse;
            public void processResponse(final ClusterStateResponse clusterStateResponse) {
            "refresh.external_time",
            table.addCell(processStats == null ? null : processStats.getMaxFileDescriptors());
        table.addCell(
        table.addCell("query_cache.evictions", "alias:qce,queryCacheEvictions;default:false;text-align:right;desc:query cache evictions");
            table.addCell(searchStats == null ? null : searchStats.getTotal().getStarTreeQueryFailed());
import org.opensearch.index.flush.FlushStats;
        );
        parseDeprecatedMasterTimeoutParameter(clusterStateRequest, request, deprecationLogger, getName());
            table.addCell(fullId ? node.getId() : Strings.substring(node.getId(), 0, 4));
import org.opensearch.index.cache.request.RequestCacheStats;
import java.util.Locale;
import org.opensearch.core.common.unit.ByteSizeValue;
        table.addCell("node.roles", "alias:rs,all roles;desc: -:coordinating node only");
            table.addCell(roles);
    }
        table.addCell("indexing.index_time", "alias:iiti,indexingIndexTime;default:false;text-align:right;desc:time spent in indexing");
import org.opensearch.index.shard.IndexingStats;
        table.addCell("ram.current", "default:false;alias:rc,ramCurrent;text-align:right;desc:used machine memory");
            MergeStats mergeStats = indicesStats == null ? null : indicesStats.getMerge();
        table.startHeaders();
        table.addCell(
                allRoles = node.getRoles().stream().map(DiscoveryNodeRole::roleName).sorted().collect(Collectors.joining(","));
        table.addCell("id", "default:false;alias:id,nodeId;desc:unique node id");
        ClusterStateResponse state,
        table.addCell(
        table.addCell("search.query_time", "alias:sqti,searchQueryTime;default:false;text-align:right;desc:time spent in query phase");
            table.addCell(flushStats == null ? null : flushStats.getTotal());
    }
                nodesInfoRequest.clear()
            table.addCell(searchStats == null ? null : searchStats.getTotal().getQueryCurrent());
        );
        table.addCell("search.query_total", "alias:sqto,searchQueryTotal;default:false;text-align:right;desc:total query phase ops");
        table.addCell(
            "alias:scti,searchScrollTime;default:false;text-align:right;desc:time scroll contexts held open"
            table.addCell(searchStats == null ? null : searchStats.getTotal().getStarTreeQueryTime());
import org.opensearch.index.engine.SegmentsStats;
    public List<Route> routes() {
            table.addCell(clusterManagerId == null ? "x" : clusterManagerId.equals(node.getId()) ? "*" : "-");
 * GitHub history for details.
        table.addCell("refresh.time", "alias:rti,refreshTime;default:false;text-align:right;desc:time spent in refreshes");
        // TODO: Remove the header alias 'master', after removing MASTER_ROLE. It's added for compatibility when using parameter 'h=master'.
        final boolean fullId = request.paramAsBoolean("full_id", false);
/*
            table.addCell(jvmStats == null ? null : jvmStats.getMem().getHeapUsedPercent());
            if (httpInfo != null) {
        );
                            public RestResponse buildResponse(NodesStatsResponse nodesStatsResponse) throws Exception {
            GetStats getStats = indicesStats == null ? null : indicesStats.getGet();
import org.opensearch.index.get.GetStats;
            table.addCell(searchStats == null ? null : searchStats.getTotal().getScrollTime());
import org.opensearch.transport.client.node.NodeClient;
        table.addCell(
            table.addCell(searchStats == null ? null : searchStats.getTotal().getSuggestCount());
            "alias:rchc,requestCacheHitCount;default:false;text-align:right;desc:request cache hit counts"
        table.addCell("query_cache.memory_size", "alias:qcm,queryCacheMemory;default:false;text-align:right;desc:used query cache");
                roles = knownNodeRoles.size() > 0
        table.addCell(
            table.addCell(refreshStats == null ? null : refreshStats.getTotal());
            table.addCell(diskAvailable);
            table.addCell(fcStats == null ? null : fcStats.getMissCount());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            );
            "alias:mswti,mergedSegmentWarmerTotalInvocations;default:false;text-align:right;desc:total invocations of merged segment warmer"
                !hasLoadAverage || osStats.getCpu().getLoadAverage()[1] == -1
 *
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestNodesAction.class);
                                    channel
        for (DiscoveryNode node : nodes) {
        }
 * Unless required by applicable law or agreed to in writing,
        );
        );
            request.paramAsTime("cluster_manager_timeout", clusterStateRequest.clusterManagerNodeTimeout())
            table.addCell(fcStats == null ? null : fcStats.getHitCount());
 * this work for additional information regarding copyright
                + "text-align:right;desc:script cache compilation limit triggered"
        table.addCell(
            table.endRow();
        table.addCell("get.exists_total", "alias:geto,getExistsTotal;default:false;text-align:right;desc:number of successful gets");
                        NodesInfoRequest.Metric.HTTP.metricName()
        table.addCell("disk.used_percent", "default:false;alias:dup,diskUsedPercent;text-align:right;desc:used disk space percentage");
import org.opensearch.monitor.jvm.JvmStats;
            "alias:idc,indexingDeleteCurrent;default:false;text-align:right;desc:number of current deletions"
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
        table.addCell("search.fetch_time", "alias:sfti,searchFetchTime;default:false;text-align:right;desc:time spent in fetch phase");
            "alias:rcmc,requestCacheMissCount;default:false;text-align:right;desc:request cache miss counts"
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
                    .filter(DiscoveryNodeRole::isKnownRole)
        table.addCell(
        table.addCell("build", "default:false;alias:b;desc:os build hash");
        );
                roles = "-";
        table.addCell("search.scroll_total", "alias:scto,searchScrollTotal;default:false;text-align:right;desc:completed scroll contexts");
        return singletonList(new Route(GET, "/_cat/nodes"));
        table.addCell(
            "merges.current_docs",
                        nodesStatsRequest.timeout(request.param("timeout"));
 *
                                NodesStatsRequest.Metric.FS.metricName(),
            table.startRow();
            table.addCell(searchStats == null ? null : searchStats.getTotal().getConcurrentQueryCount());
            table.addCell(getStats == null ? null : getStats.getMissingCount());
            table.addCell(node.getHostAddress());
 * You may obtain a copy of the License at
        boolean fullId,
import org.opensearch.monitor.process.ProcessStats;
            "search.startree_query_total",
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
                    : String.format(Locale.ROOT, "%.2f", osStats.getCpu().getLoadAverage()[2])
            "alias:rce,requestCacheEvictions;default:false;text-align:right;desc:request cache evictions"
        );
        table.addCell("ram.max", "default:false;alias:rm,ramMax;text-align:right;desc:total machine memory");
                List<DiscoveryNodeRole> knownNodeRoles = node.getRoles()
                    ? null
            table.addCell(getStats == null ? null : getStats.getTime());
            } else {
        table.addCell("search.fetch_current", "alias:sfc,searchFetchCurrent;default:false;text-align:right;desc:current fetch phase ops");
import org.opensearch.index.merge.MergedSegmentWarmerStats;
                        NodesInfoRequest.Metric.PROCESS.metricName(),
                TransportAddress transportAddress = httpInfo.getAddress().publishAddress();
        );
import org.opensearch.index.cache.query.QueryCacheStats;
     * Calculate the percentage of {@code used} from the {@code max} number.
            table.addCell(mergedSegmentWarmerStats == null ? null : mergedSegmentWarmerStats.getTotalSentSize());
    }
    protected void documentation(StringBuilder sb) {
import org.opensearch.cluster.node.DiscoveryNode;
            "search.query_failed",
            table.addCell(flushStats == null ? null : flushStats.getTotalTime());
        table.addCell("ip", "alias:i;desc:ip address");
        );
        table.addCell("request_cache.memory_size", "alias:rcm,requestCacheMemory;default:false;text-align:right;desc:used request cache");
        );
            FsInfo fsInfo = stats == null ? null : stats.getFs();
            deprecationLogger.deprecate("cat_nodes_local_parameter", LOCAL_DEPRECATED_MESSAGE);
                    ? null
        return table;
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        table.addCell("load_5m", "alias:l;text-align:right;desc:5m load avg");
            table.addCell(diskUsed);
            table.addCell(searchStats == null ? null : searchStats.getTotal().getPitCurrent());
        table.addCell("merges.total", "alias:mt,mergesTotal;default:false;text-align:right;desc:number of completed merge ops");
            table.addCell(indexingStats == null ? null : indexingStats.getTotal().getIndexCurrent());
 */
        }
            table.addCell(segmentsStats == null ? null : segmentsStats.getCount());
            "alias:stqc,startreeQueryCurrent;default:false;text-align:right;desc:current star tree query ops"
import org.opensearch.common.Table;
                    : calculatePercentage(processStats.getOpenFileDescriptors(), processStats.getMaxFileDescriptors())
import org.opensearch.index.fielddata.FieldDataStats;
            NodeStats stats = nodesStats.getNodesMap().get(node.getId());
            table.addCell(scriptStats == null ? null : scriptStats.getCompilationLimitTriggered());
        );
            "alias:stqti,startreeQueryTime;default:false;text-align:right;desc:time spent in star tree queries"
            table.addCell(mergeStats == null ? null : mergeStats.getTotalTime());
        // TODO: Deprecate "node.role", use "node.roles" which shows full node role names
            table.addCell(refreshStats == null ? null : refreshStats.getExternalTotal());
        table.addCell("fielddata.evictions", "alias:fe,fielddataEvictions;default:false;text-align:right;desc:fielddata evictions");
        );
import org.opensearch.http.HttpInfo;
    @Override
            table.addCell(mergeStats == null ? null : mergeStats.getCurrentNumDocs());
            @Override
            table.addCell(searchStats == null ? null : searchStats.getTotal().getConcurrentAvgSliceCount());
            "default:false;alias:fdp,fileDescriptorPercent;text-align:right;desc:used file descriptor ratio"
import java.util.stream.Collectors;
        table.addCell("get.missing_time", "alias:gmti,getMissingTime;default:false;text-align:right;desc:time spent in failed gets");
        );
            table.addCell(diskUsedPercent);
                    public void processResponse(final NodesInfoResponse nodesInfoResponse) {
    @Override
            "alias:scqti,searchConcurrentQueryTime;default:false;text-align:right;desc:time spent in concurrent query phase"
                                NodesStatsRequest.Metric.JVM.metricName(),
            "search.startree_query_failed",
        table.addCell("suggest.total", "alias:suto,suggestTotal;default:false;text-align:right;desc:number of suggest ops");
            JvmInfo jvmInfo = info == null ? null : info.getInfo(JvmInfo.class);
            table.addCell(jvmStats == null ? null : jvmStats.getMem().getHeapUsed());
        table.addCell(
            table.addCell(info == null ? null : info.getInfo(ProcessInfo.class).getId());
 *
        );
            "request_cache.hit_count",
        table.addCell(
            "file_desc.percent",
            table.addCell(mergedSegmentWarmerStats == null ? null : mergedSegmentWarmerStats.getTotalFailureCount());
            table.addCell(getStats == null ? null : getStats.getMissingTime());
        table.addCell("segments.memory", "alias:sm,segmentsMemory;default:false;text-align:right;desc:memory used by segments");
            table.addCell(info == null ? null : info.getBuild().hash());
                        nodesStatsRequest.indices().setIncludeIndicesStatsByLevel(true);
            table.addCell(
            "alias:scqc,searchConcurrentQueryCurrent;default:false;text-align:right;desc:current concurrent query phase ops"
                        nodesStatsRequest.clear()
 * license agreements. See the NOTICE file distributed with
            table.addCell(indexingStats == null ? null : indexingStats.getTotal().getIndexTime());
            QueryCacheStats fcStats = indicesStats == null ? null : indicesStats.getQueryCache();
            table.addCell(osStats == null ? null : Short.toString(osStats.getCpu().getPercent()));
            "alias:stqf,startreeQueryFailed;default:false;text-align:right;desc:star tree failed query ops"
        );
            table.addCell(osStats == null ? null : osStats.getMem() == null ? null : osStats.getMem().getUsedPercent());
            );
        );
        table.addCell("file_desc.max", "default:false;alias:fdm,fileDescriptorMax;text-align:right;desc:max file descriptors");
                    @Override
        table.addCell(
        );
 * software distributed under the License is distributed on an
            IndexingStats indexingStats = indicesStats == null ? null : indicesStats.getIndexing();
        table.addCell("merges.total_size", "alias:mts,mergesTotalSize;default:false;text-align:right;desc:size merged");
            "search.scroll_time",
            table.addCell(node.getAddress().address().getPort());
            SegmentsStats segmentsStats = indicesStats == null ? null : indicesStats.getSegments();
            table.addCell(scriptStats == null ? null : scriptStats.getCompilations());
        table.addCell(
        );
                    : String.format(Locale.ROOT, "%.2f", osStats.getCpu().getLoadAverage()[1])
        table.addCell(
import org.opensearch.common.logging.DeprecationLogger;
        table.addCell("segments.count", "alias:sc,segmentsCount;default:false;text-align:right;desc:number of segments");
            "alias:scqto,searchConcurrentQueryTotal;default:false;text-align:right;desc:total concurrent query phase ops"
            table.addCell(jvmInfo == null ? null : jvmInfo.getMem().getHeapMax());
        table.addCell("name", "alias:n;desc:node name");
            "alias:scti,searchPointInTimeTime;default:false;text-align:right;desc:time point in time contexts held open"
            "search.concurrent_query_total",
            "search.concurrent_avg_slice_count",
            "merges.warmer.total_time",
                        client.admin().cluster().nodesStats(nodesStatsRequest, new RestResponseListener<NodesStatsResponse>(channel) {
            table.addCell(searchStats == null ? null : searchStats.getTotal().getPitCount());
        table.addCell("refresh.external_total", "alias:rto,refreshTotal;default:false;text-align:right;desc:total external refreshes");
            "query_cache.miss_count",
        );
            "alias:svmm,segmentsVersionMapMemory;default:false;text-align:right;desc:memory used by version map"
            OsStats osStats = stats == null ? null : stats.getOs();
 * Licensed to Elasticsearch under one or more contributor
        String clusterManagerId = nodes.getClusterManagerNodeId();
    /**
public class RestNodesAction extends AbstractCatAction {
     */
            RefreshStats refreshStats = indicesStats == null ? null : indicesStats.getRefresh();
            table.addCell(allRoles);
        clusterStateRequest.local(request.paramAsBoolean("local", clusterStateRequest.local()));
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
            "indexing.index_failed",
                                NodesStatsRequest.Metric.SCRIPT.metricName()
/**
            table.addCell(searchStats == null ? null : searchStats.getTotal().getFetchCount());
        );
 * _cat API action to get node information
            table.addCell(jvmStats == null ? null : jvmStats.getUptime());
        table.addCell("ram.percent", "alias:rp,ramPercent;text-align:right;desc:used machine memory ratio");
        sb.append("/_cat/nodes\n");
import org.opensearch.core.common.Strings;
        table.addCell("query_cache.hit_count", "alias:qchc,queryCacheHitCount;default:false;text-align:right;desc:query cache hit counts");
            "request_cache.evictions",
 * under the License.
            ByteSizeValue diskAvailable = null;
            table.addCell(refreshStats == null ? null : refreshStats.getListeners());
import static java.util.Collections.singletonList;
        table.addCell("pid", "default:false;alias:p;desc:process id");
                    .collect(Collectors.toList());
            table.addCell(mergedSegmentWarmerStats == null ? null : mergedSegmentWarmerStats.getTotalReceivedSize());
            "alias:rli,refreshListeners;default:false;text-align:right;" + "desc:number of pending refresh listeners"
                    .addMetrics(
            "merges.warmer.total_bytes_received",
            table.addCell(
            }
            "search.concurrent_query_current",
        );
    }
            table.addCell(mergeStats == null ? null : mergeStats.getCurrentSize());
                                NodesStatsRequest.Metric.PROCESS.metricName(),
                client.admin().cluster().nodesInfo(nodesInfoRequest, new RestActionListener<NodesInfoResponse>(channel) {
            table.addCell(searchStats == null ? null : searchStats.getTotal().getQueryFailedCount());
            table.addCell(diskTotal);
import org.opensearch.index.refresh.RefreshStats;
        );
            table.addCell(fcStats == null ? null : fcStats.getEvictions());
        table.addCell(
        DiscoveryNodes nodes = state.getState().nodes();
import org.opensearch.index.merge.MergeStats;
            "script.cache_evictions",
            "merges.warmer.total_failure_count",
        table.addCell("jdk", "default:false;alias:j;desc:jdk version");
        table.addCell("merges.total_time", "alias:mtt,mergesTotalTime;default:false;text-align:right;desc:time spent in merges");
            "alias:scrce,scriptCacheEvictions;default:false;text-align:right;desc:script cache evictions"
            }
        return table;
            "refresh.listeners",
        table.addCell("suggest.current", "alias:suc,suggestCurrent;default:false;text-align:right;desc:number of current suggest ops");
                                return RestTable.buildResponse(
 *
            table.addCell(searchStats == null ? null : searchStats.getTotal().getFetchCurrent());
        table.addCell(
            "alias:iif,indexingIndexFailed;default:false;text-align:right;desc:number of failed indexing ops"
        table.addCell("fielddata.memory_size", "alias:fm,fielddataMemory;default:false;text-align:right;desc:used fielddata cache");
            if (fsInfo != null) {
                !hasLoadAverage || osStats.getCpu().getLoadAverage()[2] == -1
            table.addCell(indexingStats == null ? null : indexingStats.getTotal().getDeleteCurrent());
     * @return 0 if {@code max} is &lt;= 0. Otherwise 100 * {@code used} / {@code max}.
            "alias:mswtfc,mergedSegmentWarmerTotalFailureCount;default:false;text-align:right;desc:total failures in merged segment warmer"
        );
        table.addCell("get.total", "alias:gto,getTotal;default:false;text-align:right;desc:number of get ops");
        + "locally, and should not be used. It will be unsupported in version 8.0.";
            table.addCell(processStats == null ? null : processStats.getOpenFileDescriptors());
            table.addCell(getStats == null ? null : getStats.current());
            ProcessStats processStats = stats == null ? null : stats.getProcess();
            table.addCell(qcStats == null ? null : qcStats.getHitCount());
        );
            FlushStats flushStats = indicesStats == null ? null : indicesStats.getFlush();
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
            String diskUsedPercent = null;
 * Modifications Copyright OpenSearch Contributors. See
            "alias:mcd,mergesCurrentDocs;default:false;text-align:right;desc:number of current merging docs"
                table.addCell(NetworkAddress.format(transportAddress.address()));
        );
            "indexing.index_current",
            table.addCell(mergeStats == null ? null : mergeStats.getCurrent());
            table.addCell(mergeStats == null ? null : mergeStats.getTotal());
            CompletionStats completionStats = indicesStats == null ? null : stats.getIndices().getCompletion();
        );
import org.opensearch.index.search.stats.SearchStats;
        table.addCell("version", "default:false;alias:v;desc:os version");
            MergedSegmentWarmerStats mergedSegmentWarmerStats = mergeStats == null ? null : mergeStats.getWarmerStats();
            table.addCell(segmentsStats == null ? null : segmentsStats.getZeroMemory());
            "segments.fixed_bitset_memory",
        table.addCell(
            "alias:scc,searchPointInTimeCurrent;default:false;text-align:right;desc:open point in time contexts"
import org.opensearch.rest.action.RestActionListener;
            table.addCell(segmentsStats == null ? null : segmentsStats.getVersionMapMemory());
            table.addCell(searchStats == null ? null : searchStats.getTotal().getScrollCount());
        });
            table.addCell(fdStats == null ? null : fdStats.getMemorySize());
        table.addCell("indexing.delete_time", "alias:idti,indexingDeleteTime;default:false;text-align:right;desc:time spent in deletions");
                    }
        table.addCell(
            } else {
            table.addCell(qcStats == null ? null : qcStats.getEvictions());
            "indexing.delete_current",
            "alias:iic,indexingIndexCurrent;default:false;text-align:right;desc:number of current indexing ops"
        table.addCell(
        table.addCell(
        Table table = getTableWithHeader(req);
        table.addCell(
        table.addCell(
            table.addCell(node.getVersion().toString());
        clusterStateRequest.clear().nodes(true);
            table.addCell(getStats == null ? null : getStats.getExistsCount());
            "alias:mswtt,mergedSegmentWarmerTotalTime;default:false;text-align:right;desc:total wallclock time spent in the warming operation"
            "alias:rti,refreshTime;default:false;text-align:right;desc:time spent in external refreshes"
            table.addCell(jvmInfo == null ? null : jvmInfo.version());
                                    buildTable(fullId, request, clusterStateResponse, nodesInfoResponse, nodesStatsResponse),
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
        );
        table.addCell(
     * @param used The currently used number.
            JvmStats jvmStats = stats == null ? null : stats.getJvm();
import org.opensearch.script.ScriptStats;
        Table table = new Table();
     * @param max The maximum number.
            table.addCell(qcStats == null ? null : qcStats.getMemorySize());
import org.opensearch.cluster.node.DiscoveryNodes;
                    : String.format(Locale.ROOT, "%.2f", osStats.getCpu().getLoadAverage()[0])
            "alias:mswtbs,mergedSegmentWarmerTotalBytesSent;default:false;text-align:right;desc:total bytes sent by a primary shard during the warm operation"
        table.addCell("search.scroll_current", "alias:scc,searchScrollCurrent;default:false;text-align:right;desc:open scroll contexts");
            ByteSizeValue diskTotal = null;
        table.addCell("suggest.time", "alias:suti,suggestTime;default:false;text-align:right;desc:time spend in suggest");
 */
        table.addCell(
    Table buildTable(
            "search.concurrent_query_time",
            "merges.warmer.total_receive_time",
            "merges.warmer.ongoing_count",
        clusterStateRequest.clusterManagerNodeTimeout(
                + " and type filters for types referred in _parent fields"
            final String allRoles;
                double diskUsedRatio = diskTotal.getBytes() == 0 ? 1.0 : (double) diskUsed.getBytes() / diskTotal.getBytes();
        table.addCell("get.missing_total", "alias:gmto,getMissingTotal;default:false;text-align:right;desc:number of failed gets");
                NodesInfoRequest nodesInfoRequest = new NodesInfoRequest();
            "alias:sfbm,fixedBitsetMemory;default:false;text-align:right;desc:memory used by fixed bit sets for nested object field types"
            "alias:sqf,searchQueryFailed;default:false;text-align:right;desc:total failed query phase ops"
                    ? knownNodeRoles.stream().map(DiscoveryNodeRole::roleNameAbbreviation).sorted().collect(Collectors.joining())
        table.addCell("merges.total_docs", "alias:mtd,mergesTotalDocs;default:false;text-align:right;desc:docs merged");
        table.addCell("disk.used", "default:false;alias:du,diskUsed;text-align:right;desc:used disk space");
        table.addCell("cluster_manager", "alias:cm,m,master;desc:*:current cluster manager");
            "alias:casc,searchConcurrentAvgSliceCount;default:false;text-align:right;desc:average query concurrency"
            "segments.index_writer_memory",
                    ? null
            table.addCell(segmentsStats == null ? null : segmentsStats.getIndexWriterMemory());
 * SPDX-License-Identifier: Apache-2.0
        table.addCell("disk.avail", "default:false;alias:d,da,disk,diskAvail;text-align:right;desc:available disk space");
        NodesStatsResponse nodesStats
            table.addCell(searchStats == null ? null : searchStats.getTotal().getPitTime());
            "merges.warmer.total_send_time",
}
        table.addCell("disk.total", "default:false;alias:dt,diskTotal;text-align:right;desc:total disk space");
        table.addCell(
                    .stream()
    }
            NodeInfo info = nodesInfo.getNodesMap().get(node.getId());
            final HttpInfo httpInfo = info == null ? null : info.getInfo(HttpInfo.class);
            table.addCell(mergedSegmentWarmerStats == null ? null : mergedSegmentWarmerStats.getTotalSendTime());
                            }
        table.addCell("refresh.total", "alias:rto,refreshTotal;default:false;text-align:right;desc:total refreshes");
            if (node.getRoles().isEmpty()) {
            table.addCell(mergedSegmentWarmerStats == null ? null : mergedSegmentWarmerStats.getTotalTime());
        );
        table.addCell("merges.current", "alias:mc,mergesCurrent;default:false;text-align:right;desc:number of current merges");
                    );
            table.addCell(node.getName());
            table.addCell(searchStats == null ? null : searchStats.getTotal().getStarTreeQueryCurrent());
            table.addCell(getStats == null ? null : getStats.getExistsTime());
            "search.startree_query_current",
        );
        RestRequest req,
        table.addCell("search.open_contexts", "alias:so,searchOpenContexts;default:false;text-align:right;desc:open search contexts");
            table.addCell(mergedSegmentWarmerStats == null ? null : mergedSegmentWarmerStats.getOngoingCount());
    private short calculatePercentage(long used, long max) {
        );
import org.opensearch.monitor.os.OsStats;
            table.addCell(searchStats == null ? null : searchStats.getTotal().getSuggestCurrent());
        table.addCell("http_address", "default:false;alias:http;desc:bound http address");
import org.opensearch.common.network.NetworkAddress;
            "merges.warmer.total_invocations",
            table.addCell(searchStats == null ? null : searchStats.getTotal().getQueryCount());
            table.addCell(searchStats == null ? null : searchStats.getTotal().getSuggestTime());
import org.opensearch.monitor.fs.FsInfo;
            table.addCell(searchStats == null ? null : searchStats.getTotal().getScrollCurrent());
        table.addCell("flush.total_time", "alias:ftt,flushTotalTime;default:false;text-align:right;desc:time spent in flush");
            table.addCell(completionStats == null ? null : completionStats.getSize());
        table.addCell("flush.total", "alias:ft,flushTotal;default:false;text-align:right;desc:number of flushes");
            "node.role",
        table.addCell("search.query_current", "alias:sqc,searchQueryCurrent;default:false;text-align:right;desc:current query phase ops");
        return "cat_nodes_action";
        table.addCell(
    }
            table.addCell(searchStats == null ? null : searchStats.getTotal().getQueryTime());
        table.addCell(
                        NodesStatsRequest nodesStatsRequest = new NodesStatsRequest();
        if (request.hasParam("local")) {
        table.addCell(
            "search.point_in_time_time",
package org.opensearch.rest.action.cat;
 * The OpenSearch Contributors require contributions made to
import java.util.List;
        table.addCell(
        table.addCell("get.time", "alias:gti,getTime;default:false;text-align:right;desc:time spent in get");
            "request_cache.miss_count",
        table.addCell("search.fetch_total", "alias:sfto,searchFetchTotal;default:false;text-align:right;desc:total fetch ops");
    public String getName() {
            "alias:scrclt,scriptCacheCompilationLimitTriggered;default:false;"
            table.addCell(
 * not use this file except in compliance with the License.
        table.addCell(
        table.addCell("completion.size", "alias:cs,completionSize;default:false;text-align:right;desc:size of completion");
