                    node.getName(),
        table.addCell(pid);
            table.addCell(poolStats == null ? null : poolStats.getQueue());
        table.addCell("core", "alias:cr;default:false;text-align:right;desc:core number of threads in a scaling thread pool");
 * GitHub history for details.
                } else if (poolInfo.getThreadPoolType() == ThreadPool.ThreadPoolType.VIRTUAL) {
            }
 * ownership. Elasticsearch licenses this file to you under
    }
                    node.getAddress().address().getPort(),
import org.opensearch.rest.action.RestResponseListener;
import static org.opensearch.rest.RestRequest.Method.GET;
    static {
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
    }
        table.addCell("host", "default:false;alias:h;desc:host name");
                    entry.getKey(),
        final Set<String> candidates = new HashSet<>();
        table.addCell(
    }
 * SPDX-License-Identifier: Apache-2.0
                    assert poolInfo.getMin() >= 0;
 *    http://www.apache.org/licenses/LICENSE-2.0
            table.addCell(null); // keep_alive
                    poolInfo,
        return channel -> client.admin().cluster().state(clusterStateRequest, new RestActionListener<ClusterStateResponse>(channel) {
        table.addCell("rejected", "alias:r;default:true;text-align:right;desc:number of rejected tasks");
import org.opensearch.action.admin.cluster.node.stats.NodesStatsRequest;
        final Table table = getTableWithHeader(req);
                        client.admin().cluster().nodesStats(nodesStatsRequest, new RestResponseListener<NodesStatsResponse>(channel) {
        return table;
            String keepAlive = null;
                writeRow(
            table.addCell(maxQueueSize == null ? -1 : maxQueueSize);
        );
            table.addCell(poolName);
        table.startHeaders();
 * The OpenSearch Contributors require contributions made to
                    for (ThreadPool.Info threadPoolInfo : info.getInfo(ThreadPoolInfo.class)) {
        RESPONSE_PARAMS = Collections.unmodifiableSet(responseParams);
        });
    }
            public void processResponse(final ClusterStateResponse clusterStateResponse) {
                    keepAlive = poolInfo.getKeepAlive().toString();
        clusterStateRequest.local(request.paramAsBoolean("local", clusterStateRequest.local()));
                if (!included.contains(entry.getKey())) continue;
 */
        table.endRow();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        table.addCell("ip", "default:false;alias:i;desc:ip address");
            table.addCell(0);   // active
                    assert poolInfo.getMax() > 0;
import org.opensearch.cluster.node.DiscoveryNode;
                client.admin().cluster().nodesInfo(nodesInfoRequest, new RestActionListener<NodesInfoResponse>(channel) {
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(RestThreadPoolAction.class);
                }
        table.addCell("parallelism", "alias:pl;default:false;text-align:right;desc:number of worker threads in a fork_join thread pool");
        parseDeprecatedMasterTimeoutParameter(clusterStateRequest, request, deprecationLogger, getName());
 * You may obtain a copy of the License at
            Integer size = null;
        table.addCell(hostName);
                    node.getHostName(),
 * this work for additional information regarding copyright
        int port,
            table.addCell(0);   // rejected
            table.addCell(poolName);
 * Modifications Copyright OpenSearch Contributors. See
            "alias:twt;default:false;text-align:right;desc:total time tasks spent waiting in thread_pool queue"
            table.addCell(-1);  // queue_size
            }
                    }
                if (poolInfo.getQueueSize() != null) {
import java.util.TreeMap;
                poolThreadInfo = Collections.emptyMap();
            table.addCell(null); // max
                    public void processResponse(final NodesInfoResponse nodesInfoResponse) {
import java.util.Set;
        String nodeId,
        table.endHeaders();
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
                    max = poolInfo.getMax();
import org.opensearch.common.logging.DeprecationLogger;
        String ephemeralId,
        table.addCell("size", "alias:sz;default:false;text-align:right;desc:number of threads in a fixed thread pool");
        final Set<String> included = new HashSet<>();
 * _cat API action to get threadpool information
        table.addCell("max", "alias:mx;default:false;text-align:right;desc:maximum number of threads in a scaling thread pool");
}
        for (final String candidate : candidates) {
 *
import org.opensearch.transport.client.node.NodeClient;
import org.opensearch.threadpool.ThreadPool;
        table.addCell(nodeId);
            request.paramAsTime("cluster_manager_timeout", clusterStateRequest.clusterManagerNodeTimeout())
            for (Map.Entry<String, ThreadPoolStats.Stats> entry : poolThreadStats.entrySet()) {
import org.opensearch.threadpool.ThreadPoolInfo;
                    node.getId(),
            table.addCell(poolInfo.getThreadPoolType().getType());
            if (stats == null) {
                if (poolInfo.getThreadPoolType() == ThreadPool.ThreadPoolType.SCALING) {
                    assert poolInfo.getMin() == -1 && poolInfo.getMax() == -1;
        // collect all thread pool names that match the specified thread pool patterns
            table.addCell(poolStats == null ? null : poolStats.getActive());
        table.addCell("ephemeral_node_id", "default:false;alias:eid;desc:ephemeral node id");
            if (Regex.simpleMatch(threadPools, candidate)) {
        table.addCell("name", "default:true;alias:n;desc:thread pool name");
        return RESPONSE_PARAMS;
        return table;
            Integer max = null;
import java.util.HashMap;
    }
/**
                } else {
                    node.getEphemeralId(),
        table.addCell("node_name", "default:true;alias:nn;desc:node name");
                    assert poolInfo.getMin() == poolInfo.getMax() && poolInfo.getMax() > 0;
        table.addCell(nodeName);
 * under the License.
import static java.util.Collections.unmodifiableList;
            if (poolInfo != null) {
import org.opensearch.action.admin.cluster.node.stats.NodesStatsResponse;
                                    channel
                // we use a sorted map to ensure that thread pools are sorted by name
        table.startRow();
    void writeRow(
                }
 */
    Table buildTable(RestRequest req, ClusterStateResponse state, NodesInfoResponse nodesInfo, NodesStatsResponse nodesStats) {
                                );
    }
            table.addCell(poolInfo.getMax()); // parallelism
                        NodesStatsRequest nodesStatsRequest = new NodesStatsRequest();
import org.opensearch.rest.RestResponse;
 * license agreements. See the NOTICE file distributed with
            }
 * software distributed under the License is distributed on an
            table.addCell(max);
        String poolName,
        responseParams.add("thread_pool_patterns");
    @Override
            final Map<String, ThreadPool.Info> poolThreadInfo;
 *
        Long pid,
                    poolThreadStats.put(threadPoolStat.getName(), threadPoolStat);
        table.addCell(ephemeralId);
    @Override
                if (info != null) {
                poolThreadStats = Collections.emptyMap();
            table.addCell(0);   // queue
import org.opensearch.rest.RestRequest;
        );
        } else {
                            @Override
import static java.util.Arrays.asList;
 */
            table.addCell(0);   // completed
        table.addCell("pid", "default:false;alias:p;desc:process id");
                    // a virtual thread-per-task pool is unbounded, so core, max, and size are all left unset
import java.util.Map;
    @Override
import java.util.List;
            table.addCell(null); // parallelism
    protected void documentation(StringBuilder sb) {
                    node.getHostAddress(),
            } else {
    ) {
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
                poolThreadStats = new TreeMap<>();
            table.addCell(poolStats == null ? null : poolStats.getLargest());
import java.util.Collections;
 * KIND, either express or implied.  See the License for the
        table.addCell("largest", "alias:l;default:false;text-align:right;desc:highest number of seen active threads");
            table.addCell(keepAlive);
        for (final DiscoveryNode node : nodes) {
    protected Table getTableWithHeader(final RestRequest request) {
                        });
            table.addCell(0);   // largest
 *
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
                });
                final ThreadPoolStats.Stats poolStats = entry.getValue();
            table.addCell(poolInfo == null ? null : poolInfo.getThreadPoolType().getType());
            table.addCell(null); // core
/*
            table.addCell(poolStats == null ? null : poolStats.getWaitTime());
        final String[] threadPools = req.paramAsStringArray("thread_pool_patterns", new String[] { "*" });
        table.addCell("active", "alias:a;default:true;text-align:right;desc:number of active threads");
        // collect all thread pool names that we see across the nodes
        clusterStateRequest.clear().nodes(true);
 */
    @Override
        for (final NodeStats nodeStats : nodesStats.getNodes()) {
        table.addCell("queue", "alias:q;default:true;text-align:right;desc:number of tasks currently in queue");
            table.addCell(core);
    private static final Set<String> RESPONSE_PARAMS;
            }
        table.addCell("pool_size", "alias:psz;default:false;text-align:right;desc:number of threads");
        Table table,
            table.addCell(size);
                        nodesStatsRequest.clear().addMetric(NodesStatsRequest.Metric.THREAD_POOL.metricName());
        }
        }
    public RestChannelConsumer doCatRequest(final RestRequest request, final NodeClient client) {
        return unmodifiableList(asList(new Route(GET, "/_cat/thread_pool"), new Route(GET, "/_cat/thread_pool/{thread_pool_patterns}")));
                    size = poolInfo.getMax();
            table.addCell(0);   // pool_size
        if (isForkJoin) {
            for (final ThreadPoolStats.Stats threadPoolStats : nodeStats.getThreadPool()) {
            Long maxQueueSize = null;
        final DiscoveryNodes nodes = state.getState().nodes();
                for (ThreadPoolStats.Stats threadPoolStat : threadPoolStats) {
            @Override
                                    buildTable(request, clusterStateResponse, nodesInfoResponse, nodesStatsResponse),
            "total_wait_time",
                }
/*
 *
        return "cat_threadpool_action";
        }
        String nodeName,
                    table,
        String hostAddress,
public class RestThreadPoolAction extends AbstractCatAction {
                );
import java.util.HashSet;
                        poolThreadInfo.put(threadPoolInfo.getName(), threadPoolInfo);
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
                    maxQueueSize = poolInfo.getQueueSize().singles();
        ThreadPoolStats.Stats poolStats
                poolThreadInfo = new HashMap<>();
                            public RestResponse buildResponse(NodesStatsResponse nodesStatsResponse) throws Exception {
    protected Set<String> responseParams() {
                    core = poolInfo.getMin();
            table.addCell(-1);  // total_wait_time
        table.addCell("queue_size", "alias:qs;default:false;text-align:right;desc:maximum number of tasks permitted in queue");
        table.addCell("type", "alias:t;default:false;desc:thread pool type");
                    }
                    .addMetrics(NodesInfoRequest.Metric.PROCESS.metricName(), NodesInfoRequest.Metric.THREAD_POOL.metricName());
import org.opensearch.cluster.node.DiscoveryNodes;
    // NEW: package-private helper to write one row, so tests can call this directly (no reflection).
        clusterStateRequest.clusterManagerNodeTimeout(
                    poolStats
                final ThreadPool.Info poolInfo = poolThreadInfo.get(entry.getKey());
        table.addCell("port", "default:false;alias:po;desc:bound transport port");
                                return RestTable.buildResponse(
            final NodeInfo info = nodesInfo.getNodesMap().get(node.getId());
        }
        String hostName,
        final Set<String> responseParams = new HashSet<>(AbstractCatAction.RESPONSE_PARAMS);
                ThreadPoolStats threadPoolStats = stats.getThreadPool();
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
                nodesInfoRequest.clear()
import org.opensearch.action.admin.cluster.node.info.NodesInfoRequest;
package org.opensearch.rest.action.cat;
                nodesInfoRequest.timeout(request.param("timeout"));
            table.addCell(null); // size
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
                candidates.add(threadPoolStats.getName());
 * @opensearch.api
            table.addCell(poolStats == null ? null : poolStats.getThreads());
import org.opensearch.action.admin.cluster.node.info.NodesInfoResponse;
                }
        table.addCell("node_id", "default:false;alias:id;desc:persistent node id");
    }
                        nodesStatsRequest.timeout(request.param("timeout"));
    }
        sb.append("/_cat/thread_pool\n");
import org.opensearch.threadpool.ThreadPoolStats;
                if (poolInfo.getKeepAlive() != null) {
                    @Override
                    info == null ? null : info.getInfo(ProcessInfo.class).getId(),
        table.addCell(port);
        table.addCell(hostAddress);
/*
                }
            }
    @Override
            table.addCell(poolStats == null ? null : poolStats.getRejected());
        ThreadPool.Info poolInfo,
import org.opensearch.common.regex.Regex;
 * Licensed to Elasticsearch under one or more contributor
            Integer core = null;
                            }
    public List<Route> routes() {
        final Table table = new Table();
                NodesInfoRequest nodesInfoRequest = new NodesInfoRequest();
 * compatible open source license.
        table.addCell("completed", "alias:c;default:false;text-align:right;desc:number of completed tasks");
    }
        table.addCell("keep_alive", "alias:ka;default:false;text-align:right;desc:thread keep alive time");
                included.add(candidate);
import org.opensearch.rest.action.RestActionListener;
        final boolean isForkJoin = poolInfo != null && poolInfo.getThreadPoolType() == ThreadPool.ThreadPoolType.FORK_JOIN;
import org.opensearch.monitor.process.ProcessInfo;
            table.addCell(poolStats == null ? null : poolStats.getCompleted());
import org.opensearch.common.Table;
            final NodeStats stats = nodesStats.getNodesMap().get(node.getId());
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
    public String getName() {
            }
            final Map<String, ThreadPoolStats.Stats> poolThreadStats;
        sb.append("/_cat/thread_pool/{thread_pools}\n");
