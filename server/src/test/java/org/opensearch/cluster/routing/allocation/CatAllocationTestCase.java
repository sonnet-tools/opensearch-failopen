        for (String node : nodes) {
import java.util.HashMap;
import org.opensearch.cluster.routing.TestShardRouting;
                }
    public void testRun() throws IOException {
 * this work for additional information regarding copyright
                    logger.debug("Add routing {}", routing);
        public int numShards() {
        while (true) {
            .routingTable(routingTable)
        final String name;
                "^(.+)\\s+(\\d)\\s+([rp])\\s+(STARTED|RELOCATING|INITIALIZING|UNASSIGNED)"
import java.nio.charset.StandardCharsets;
            IndexRoutingTable.Builder tableBuilder = new IndexRoutingTable.Builder(idxMeta.getIndex()).initializeAsRecovery(idxMeta);
                    final int shard = Integer.parseInt(matcher.group(2));
                tableBuilder.addIndexShard(t);
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Map<String, Idx> indices = new HashMap<>();
        public int numReplicas() {
                if (msr.primary() == false && msr.id() == 0) {
            logger.debug("Initializing shards: {}", initializing);
                    refData = new IndexShardRoutingTable.Builder(shardIdToRouting.get(r.getId())).addShard(r).build();
                if (shardRouting.active()) {
        }
                    Set<String> allocationIds = idxMetaBuilder.getInSyncAllocationIds(shardRouting.id());
        return clusterState;
 * You may obtain a copy of the License at
            routingTableBuilder.add(table);
        }
            int count = 0;
            IndexMetadata.Builder idxMetaBuilder = IndexMetadata.builder(idx.name)
/*
                final Matcher matcher;
 * specific language governing permissions and limitations
            .nodes(builderDiscoNodes.build())
import org.opensearch.cluster.routing.IndexRoutingTable;
import org.opensearch.Version;
 *
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
            numRelocations += initializing.size();
import org.opensearch.cluster.metadata.Metadata;
 * not use this file except in compliance with the License.
/**
 *
 *   kibana-int           0 p STARTED       2  24.8kb 10.202.245.2 r5-9-35
        public Idx(String name) {
            }
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.metadata.IndexMetadata;
            // regexp FTW
            clusterState = rebalance(clusterState);
 *
import java.util.List;
                    String ip = matcher.group(5);
import org.opensearch.cluster.ClusterState;
}
                    allocationIds.add(shardRouting.allocationId().getId());
        }
                }
    protected abstract ClusterState allocateNew(ClusterState clusterState);
                    }
import org.opensearch.cluster.node.DiscoveryNodes;
 * compatible open source license.
                if (shardIdToRouting.containsKey(r.getId())) {
package org.opensearch.cluster.routing.allocation;
                .numberOfReplicas(idx.numReplicas());
        }
        clusterState = strategy.reroute(clusterState, "reroute");
                    nodes.add(ip);
                    + "\\s+\\d+\\s+[0-9.a-z]+\\s+(\\d+\\.\\d+\\.\\d+\\.\\d+).*$"
                    ShardRoutingState state = ShardRoutingState.valueOf(matcher.group(4));
                    if (allocationIds == null) {
 * The input is a line based cat/shards output like:
                        indices.put(index, idx);
import java.util.Map;
        Metadata.Builder builder = Metadata.builder();
    }
import java.nio.file.Path;
 */
    }
 * This can be used to debug cluster allocation decisions.
            builderDiscoNodes.add(newNode(node));
        Metadata metadata = builder.build();
        }
                    if (idx == null) {
            }
            this.name = name;
                if (msr.primary()) {
import java.io.IOException;
                    }
            routing.add(r);
            }
                }
    public class Idx {
        }
            );
                        allocationIds = new HashSet<>();
        DiscoveryNodes.Builder builderDiscoNodes = DiscoveryNodes.builder();
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.routing.ShardRoutingState;
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();
        final List<ShardRouting> routing = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                shardIdToRouting.put(r.getId(), refData);
 */
 * the Apache License, Version 2.0 (the "License"); you may
        Set<String> nodes = new HashSet<>();
            .metadata(metadata)
            String line = null;
import org.opensearch.cluster.routing.RoutingTable;
            }
            .build();
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to
            for (IndexShardRoutingTable t : shardIdToRouting.values()) {
            if (initializing.isEmpty()) {
            return count;
                    Idx idx = indices.get(index);
        }
/*
import java.util.HashSet;
                if ((matcher = pattern.matcher(line)).matches()) {
                break;
            IndexRoutingTable table = tableBuilder.build();
                        allocationIds = new HashSet<>(allocationIds);
/*
                    idxMetaBuilder.putInSyncAllocationIds(shardRouting.id(), allocationIds);
            builder.put(idxMeta, false);
                } else {
 * ownership. Elasticsearch licenses this file to you under
            for (ShardRouting msr : routing) {
 * the test builds up a clusterstate from the cat input and optionally runs a full balance on it.
                    idx.add(routing);
 * A base testcase that allows to run tests based on the output of the CAT API
        return true;
 * this file be licensed under the Apache-2.0 license or a
    protected abstract Path getCatPath() throws IOException;
                    max = Math.max(msr.getId() + 1, max);
                    fail("can't read line: " + line);
                    ShardRouting routing = TestShardRouting.newShardRouting(index, shard, ip, null, primary, state);
import org.opensearch.cluster.OpenSearchAllocationTestCase;
        }
            return max;
import java.util.ArrayList;
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))
        public void add(ShardRouting r) {
import java.util.regex.Pattern;
        logger.debug("--> num relocations to get balance: {}", numRelocations);
            for (ShardRouting msr : routing) {
            List<ShardRouting> initializing = clusterState.routingTable().shardsWithState(INITIALIZING);
import org.opensearch.cluster.routing.ShardRouting;
import java.util.regex.Matcher;
        }
 * GitHub history for details.
                }
public abstract class CatAllocationTestCase extends OpenSearchAllocationTestCase {
            IndexMetadata idxMeta = idxMetaBuilder.build();
import org.opensearch.common.settings.Settings;
    }
                IndexShardRoutingTable refData = new IndexShardRoutingTable.Builder(r.shardId()).addShard(r).build();
        try (BufferedReader reader = Files.newBufferedReader(getCatPath(), StandardCharsets.UTF_8)) {
        logger.info("Building initial routing table");
            Pattern pattern = Pattern.compile(
import org.opensearch.cluster.routing.IndexShardRoutingTable;
    protected boolean balanceFirst() {
import java.io.BufferedReader;
                .numberOfShards(idx.numShards())
                    count++;
            int max = 0;
        int numRelocations = 0;
            for (ShardRouting shardRouting : idx.routing) {
 * under the License.
                }
        AllocationService strategy = createAllocationService(Settings.builder().build());
                    final boolean primary = matcher.group(3).equals("p");
import java.nio.file.Files;
import java.util.Set;
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
            }
        for (Idx idx : indices.values()) {
        if (balanceFirst()) {
            }
 * <p>
        RoutingTable routingTable = routingTableBuilder.build();
 * Licensed to Elasticsearch under one or more contributor
                .settings(settings(Version.CURRENT))
            for (ShardRouting r : idx.routing) {
        clusterState = allocateNew(clusterState);
                        idx = new Idx(index);
                    } else {
            Map<Integer, IndexShardRoutingTable> shardIdToRouting = new HashMap<>();
 */
            }
                    final String index = matcher.group(1);
    private ClusterState rebalance(ClusterState clusterState) {
            clusterState = OpenSearchAllocationTestCase.startShardsAndReroute(strategy, clusterState, initializing);
 */
 * software distributed under the License is distributed on an
