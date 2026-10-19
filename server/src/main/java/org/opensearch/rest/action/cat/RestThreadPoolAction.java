import java.util.Map;
                    node.getHostName(),
                        client.admin().cluster().nodesStats(nodesStatsRequest, new RestResponseListener<NodesStatsResponse>(channel) {  
            Integer max = null;
import org.opensearch.monitor.process.ProcessInfo;
        return RESPONSE_PARAMS;
        final String[] threadPools = req.paramAsStringArray("thread_pool_patterns", new String[] { "*" });
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
        );  
 *
import org.opensearch.threadpool.ThreadPoolInfo;
        table.addCell("size", "alias:sz;default:false;text-align:right;desc:number of threads in a fixed thread pool");  
import org.opensearch.rest.action.RestResponseListener;  
                    info == null ? null : info.getInfo(ProcessInfo.class).getId(),
        return table;  
 *
import static java.util.Arrays.asList;
                    node.getAddress().address().getPort(),
        responseParams.add("thread_pool_patterns");
        table.addCell("ip", "default:false;alias:i;desc:ip address");
            final Map<String, ThreadPool.Info> poolThreadInfo;
            table.addCell(null); // core
                    maxQueueSize = poolInfo.getQueueSize().singles();  
            @Override  
                NodesInfoRequest nodesInfoRequest = new NodesInfoRequest();
    ) {
        table.addCell("completed", "alias:c;default:false;text-align:right;desc:number of completed tasks");
/*
        Long pid,
    private static final Set<String> RESPONSE_PARAMS;  
                            public RestResponse buildResponse(NodesStatsResponse nodesStatsResponse) throws Exception {
                if (poolInfo.getKeepAlive() != null) {
        return "cat_threadpool_action";
 * SPDX-License-Identifier: Apache-2.0
 */
 * The OpenSearch Contributors require contributions made to  
            final NodeInfo info = nodesInfo.getNodesMap().get(node.getId());
                    public void processResponse(final NodesInfoResponse nodesInfoResponse) {
                    assert poolInfo.getMin() >= 0;  
    }
 * license agreements. See the NOTICE file distributed with
        final Set<String> included = new HashSet<>();
 * Modifications Copyright OpenSearch Contributors. See
                    max = poolInfo.getMax();  
            final Map<String, ThreadPoolStats.Stats> poolThreadStats;
            final NodeStats stats = nodesStats.getNodesMap().get(node.getId());
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;  
 * You may obtain a copy of the License at  
                final ThreadPoolStats.Stats poolStats = entry.getValue();
                    @Override
                included.add(candidate);
        table.addCell("host", "default:false;alias:h;desc:host name");  
            }  
        table.addCell("parallelism", "alias:pl;default:false;text-align:right;desc:number of worker threads in a fork_join thread pool");
 * compatible open source license.
/*  
 * @opensearch.api  
import org.opensearch.cluster.node.DiscoveryNode;  
        parseDeprecatedMasterTimeoutParameter(clusterStateRequest, request, deprecationLogger, getName());  
        table.addCell(pid);  
            table.addCell(size);
import java.util.HashMap;
            table.addCell(poolInfo.getThreadPoolType().getType());
        table.addCell("max", "alias:mx;default:false;text-align:right;desc:maximum number of threads in a scaling thread pool");
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
                        NodesStatsRequest nodesStatsRequest = new NodesStatsRequest();  
            table.addCell(poolName);  
        Table table,  
        final boolean isForkJoin = poolInfo != null && poolInfo.getThreadPoolType() == ThreadPool.ThreadPoolType.FORK_JOIN;  
            table.addCell(poolInfo == null ? null : poolInfo.getThreadPoolType().getType());
package org.opensearch.rest.action.cat;
        table.addCell("active", "alias:a;default:true;text-align:right;desc:number of active threads");
            table.addCell(poolStats == null ? null : poolStats.getThreads());
        }
            }  
        );
                }
            table.addCell(0);   // rejected  
            table.addCell(max);  
        } else {  
            table.addCell(null); // max
            table.addCell(poolStats == null ? null : poolStats.getCompleted());  
        table.addCell(nodeId);
            table.addCell(0);   // largest
        String hostAddress,  
                        poolThreadInfo.put(threadPoolInfo.getName(), threadPoolInfo);  
                            @Override
        clusterStateRequest.clusterManagerNodeTimeout(  
            "total_wait_time",
    protected void documentation(StringBuilder sb) {
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
    }
import org.opensearch.threadpool.ThreadPoolStats;  
    @Override
                    node.getEphemeralId(),  
        table.startHeaders();
 * software distributed under the License is distributed on an
 */
        table.addCell("rejected", "alias:r;default:true;text-align:right;desc:number of rejected tasks");  
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();  
                if (poolInfo.getQueueSize() != null) {
                writeRow(
        sb.append("/_cat/thread_pool\n");  
                            }
                    poolInfo,  
import org.opensearch.rest.RestRequest;  
            Long maxQueueSize = null;
                for (ThreadPoolStats.Stats threadPoolStat : threadPoolStats) {
                    }  
                final ThreadPool.Info poolInfo = poolThreadInfo.get(entry.getKey());  
    static {
                nodesInfoRequest.timeout(request.param("timeout"));  
        String hostName,
        String nodeId,
        sb.append("/_cat/thread_pool/{thread_pools}\n");
        table.addCell("core", "alias:cr;default:false;text-align:right;desc:core number of threads in a scaling thread pool");
        RESPONSE_PARAMS = Collections.unmodifiableSet(responseParams);
                    // a virtual thread-per-task pool is unbounded, so core, max, and size are all left unset
    public String getName() {  
                    .addMetrics(NodesInfoRequest.Metric.PROCESS.metricName(), NodesInfoRequest.Metric.THREAD_POOL.metricName());
    }
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
        table.addCell("queue_size", "alias:qs;default:false;text-align:right;desc:maximum number of tasks permitted in queue");
            table.addCell(poolStats == null ? null : poolStats.getWaitTime());
                } else {
    @Override
            table.addCell(-1);  // queue_size
        table.addCell("port", "default:false;alias:po;desc:bound transport port");
    Table buildTable(RestRequest req, ClusterStateResponse state, NodesInfoResponse nodesInfo, NodesStatsResponse nodesStats) {  
            }
            }  
 * Licensed to Elasticsearch under one or more contributor  
                    core = poolInfo.getMin();
 *    http://www.apache.org/licenses/LICENSE-2.0
            table.addCell(poolStats == null ? null : poolStats.getActive());  
 * Unless required by applicable law or agreed to in writing,
            table.addCell(poolStats == null ? null : poolStats.getLargest());
    @Override
                        nodesStatsRequest.timeout(request.param("timeout"));
            if (poolInfo != null) {
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
    public List<Route> routes() {
 *
                // we use a sorted map to ensure that thread pools are sorted by name
        String poolName,
            table.addCell(maxQueueSize == null ? -1 : maxQueueSize);  
        table.addCell("pid", "default:false;alias:p;desc:process id");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
public class RestThreadPoolAction extends AbstractCatAction {
import java.util.Set;
                client.admin().cluster().nodesInfo(nodesInfoRequest, new RestActionListener<NodesInfoResponse>(channel) {  
import org.opensearch.common.logging.DeprecationLogger;  
                }
            "alias:twt;default:false;text-align:right;desc:total time tasks spent waiting in thread_pool queue"
            request.paramAsTime("cluster_manager_timeout", clusterStateRequest.clusterManagerNodeTimeout())
        table.addCell(nodeName);  
                poolThreadStats = Collections.emptyMap();
 * not use this file except in compliance with the License.
import org.opensearch.transport.client.node.NodeClient;
/*  
                    entry.getKey(),
        }
        table.addCell("pool_size", "alias:psz;default:false;text-align:right;desc:number of threads");  
            table.addCell(0);   // pool_size  
        }
    @Override
                        nodesStatsRequest.clear().addMetric(NodesStatsRequest.Metric.THREAD_POOL.metricName());
            }
                poolThreadInfo = new HashMap<>();
        return channel -> client.admin().cluster().state(clusterStateRequest, new RestActionListener<ClusterStateResponse>(channel) {
            Integer core = null;  
import org.opensearch.rest.action.RestActionListener;
                    assert poolInfo.getMax() > 0;
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        table.endRow();  
        table.addCell("ephemeral_node_id", "default:false;alias:eid;desc:ephemeral node id");
 * _cat API action to get threadpool information
                    keepAlive = poolInfo.getKeepAlive().toString();  
 * this work for additional information regarding copyright
import org.opensearch.cluster.node.DiscoveryNodes;
    }
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
    }  
            table.addCell(core);
import org.opensearch.common.regex.Regex;
            if (Regex.simpleMatch(threadPools, candidate)) {
        int port,
                    node.getName(),
                } else if (poolInfo.getThreadPoolType() == ThreadPool.ThreadPoolType.VIRTUAL) {
            table.addCell(keepAlive);
                poolThreadStats = new TreeMap<>();  
    protected Set<String> responseParams() {  
                if (info != null) {
    protected Table getTableWithHeader(final RestRequest request) {
        table.addCell(hostAddress);
                nodesInfoRequest.clear()
            table.addCell(poolInfo.getMax()); // parallelism
                        });
        for (final DiscoveryNode node : nodes) {  
                    node.getId(),
                poolThreadInfo = Collections.emptyMap();  
    }
        if (isForkJoin) {
 * specific language governing permissions and limitations
    }  
        table.addCell(port);  
        final Set<String> candidates = new HashSet<>();  
        clusterStateRequest.clear().nodes(true);
            table.addCell(poolStats == null ? null : poolStats.getQueue());
        });  
 * this file be licensed under the Apache-2.0 license or a
                    assert poolInfo.getMin() == poolInfo.getMax() && poolInfo.getMax() > 0;
 */  
        }
        return unmodifiableList(asList(new Route(GET, "/_cat/thread_pool"), new Route(GET, "/_cat/thread_pool/{thread_pool_patterns}")));
                ThreadPoolStats threadPoolStats = stats.getThreadPool();  
                    poolThreadStats.put(threadPoolStat.getName(), threadPoolStat);
            table.addCell(null); // size  
 *  
        ThreadPoolStats.Stats poolStats
                });
        clusterStateRequest.local(request.paramAsBoolean("local", clusterStateRequest.local()));
                }  
        // collect all thread pool names that we see across the nodes
                    assert poolInfo.getMin() == -1 && poolInfo.getMax() == -1;  
            table.addCell(null); // parallelism  
import java.util.Collections;  
            table.addCell(0);   // active
        table.addCell(  
            table.addCell(0);   // queue
        final Table table = getTableWithHeader(req);  
                candidates.add(threadPoolStats.getName());  
        String ephemeralId,  
import org.opensearch.threadpool.ThreadPool;
                                    channel
                }
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
                }
        ThreadPool.Info poolInfo,  
import java.util.HashSet;
        table.addCell("node_id", "default:false;alias:id;desc:persistent node id");  
import static java.util.Collections.unmodifiableList;  
                if (!included.contains(entry.getKey())) continue;  
 * GitHub history for details.
                                return RestTable.buildResponse(  
        final Set<String> responseParams = new HashSet<>(AbstractCatAction.RESPONSE_PARAMS);  
        table.addCell("name", "default:true;alias:n;desc:thread pool name");  
                    table,  
            for (Map.Entry<String, ThreadPoolStats.Stats> entry : poolThreadStats.entrySet()) {
            for (final ThreadPoolStats.Stats threadPoolStats : nodeStats.getThreadPool()) {
            table.addCell(0);   // completed
        String nodeName,
import org.opensearch.common.Table;
            table.addCell(null); // keep_alive
    @Override  
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;  
        table.addCell("queue", "alias:q;default:true;text-align:right;desc:number of tasks currently in queue");
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestThreadPoolAction.class);
            String keepAlive = null;
            table.addCell(-1);  // total_wait_time  
/**  
import static org.opensearch.rest.RestRequest.Method.GET;
        table.addCell("keep_alive", "alias:ka;default:false;text-align:right;desc:thread keep alive time");
                    poolStats
        for (final NodeStats nodeStats : nodesStats.getNodes()) {
import java.util.TreeMap;  
                    for (ThreadPool.Info threadPoolInfo : info.getInfo(ThreadPoolInfo.class)) {
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
        return table;
                                    buildTable(request, clusterStateResponse, nodesInfoResponse, nodesStatsResponse),
        final DiscoveryNodes nodes = state.getState().nodes();
                    node.getHostAddress(),  
        table.addCell("node_name", "default:true;alias:nn;desc:node name");
        table.startRow();
 */  
import org.opensearch.rest.RestResponse;
        final Table table = new Table();  
}
        table.addCell("largest", "alias:l;default:false;text-align:right;desc:highest number of seen active threads");
    }
                    }
            Integer size = null;
 * KIND, either express or implied.  See the License for the
import java.util.List;  
    void writeRow(
                                );  
        // collect all thread pool names that match the specified thread pool patterns
    }
                    size = poolInfo.getMax();  
        table.addCell("type", "alias:t;default:false;desc:thread pool type");
        table.endHeaders();  
            } else {
        for (final String candidate : candidates) {  
            public void processResponse(final ClusterStateResponse clusterStateResponse) {
            }
            table.addCell(poolName);
    // NEW: package-private helper to write one row, so tests can call this directly (no reflection).
                );
        table.addCell(ephemeralId);
        table.addCell(hostName);
            table.addCell(poolStats == null ? null : poolStats.getRejected());
                if (poolInfo.getThreadPoolType() == ThreadPool.ThreadPoolType.SCALING) {
            if (stats == null) {
