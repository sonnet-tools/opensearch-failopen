/*
        }
        RoutingTable routingTable = routingTableBuilder.build();
/*  
import java.util.List;
                    if (allocationIds == null) {  
                    ShardRoutingState state = ShardRoutingState.valueOf(matcher.group(4));  
                    nodes.add(ip);
 * The OpenSearch Contributors require contributions made to  
                if (shardRouting.active()) {
import java.util.regex.Pattern;  
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
        Set<String> nodes = new HashSet<>();
                    fail("can't read line: " + line);
/**
        logger.info("Building initial routing table");
                    + "\\s+\\d+\\s+[0-9.a-z]+\\s+(\\d+\\.\\d+\\.\\d+\\.\\d+).*$"
import java.util.HashSet;
 * This can be used to debug cluster allocation decisions.
        clusterState = allocateNew(clusterState);
            }
            logger.debug("Initializing shards: {}", initializing);
            }
 *
    }  
 *
        public int numReplicas() {
            }
            routingTableBuilder.add(table);  
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
                } else {  
    private ClusterState rebalance(ClusterState clusterState) {
            return max;  
 * KIND, either express or implied.  See the License for the
                    final int shard = Integer.parseInt(matcher.group(2));
        int numRelocations = 0;
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.cluster.routing.ShardRoutingState.INITIALIZING;
                    }
import java.io.IOException;
import org.opensearch.cluster.routing.ShardRouting;
                IndexShardRoutingTable refData = new IndexShardRoutingTable.Builder(r.shardId()).addShard(r).build();
                if (shardIdToRouting.containsKey(r.getId())) {  
import org.opensearch.cluster.routing.ShardRoutingState;
 * <p>
                }  
 * license agreements. See the NOTICE file distributed with
                    refData = new IndexShardRoutingTable.Builder(shardIdToRouting.get(r.getId())).addShard(r).build();
                    } else {
                    Set<String> allocationIds = idxMetaBuilder.getInSyncAllocationIds(shardRouting.id());
        for (Idx idx : indices.values()) {
            for (ShardRouting shardRouting : idx.routing) {  
            IndexRoutingTable table = tableBuilder.build();
            List<ShardRouting> initializing = clusterState.routingTable().shardsWithState(INITIALIZING);
            .metadata(metadata)
/*  
                    Idx idx = indices.get(index);
            }
            String line = null;
            Pattern pattern = Pattern.compile(  
                .settings(settings(Version.CURRENT))  
        public Idx(String name) {
        ClusterState clusterState = ClusterState.builder(org.opensearch.cluster.ClusterName.CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY))  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        public int numShards() {
import java.util.Set;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    count++;
        final String name;
            int count = 0;
 * the Apache License, Version 2.0 (the "License"); you may
        Map<String, Idx> indices = new HashMap<>();
        }
        while (true) {  
        clusterState = strategy.reroute(clusterState, "reroute");
import org.opensearch.cluster.routing.IndexRoutingTable;
            builder.put(idxMeta, false);
        }
import java.nio.charset.StandardCharsets;
 */
import org.opensearch.cluster.OpenSearchAllocationTestCase;  
                }
                    }  
            for (ShardRouting msr : routing) {
                    idx.add(routing);
        }
    public class Idx {
 * GitHub history for details.
import java.util.HashMap;  
 *  
                        idx = new Idx(index);
        }
        return true;
            clusterState = rebalance(clusterState);  
            this.name = name;  
 *   kibana-int           0 p STARTED       2  24.8kb 10.202.245.2 r5-9-35
        logger.debug("--> num relocations to get balance: {}", numRelocations);  
                    String ip = matcher.group(5);
        }
            }
            .nodes(builderDiscoNodes.build())  
 */
import org.opensearch.cluster.metadata.Metadata;
 * Licensed to Elasticsearch under one or more contributor  
                .numberOfShards(idx.numShards())
                        allocationIds = new HashSet<>(allocationIds);  
        DiscoveryNodes.Builder builderDiscoNodes = DiscoveryNodes.builder();
    protected abstract ClusterState allocateNew(ClusterState clusterState);
            for (ShardRouting msr : routing) {  
            IndexRoutingTable.Builder tableBuilder = new IndexRoutingTable.Builder(idxMeta.getIndex()).initializeAsRecovery(idxMeta);
import java.nio.file.Path;
        Metadata.Builder builder = Metadata.builder();
                final Matcher matcher;
 * SPDX-License-Identifier: Apache-2.0
            for (IndexShardRoutingTable t : shardIdToRouting.values()) {
            while ((line = reader.readLine()) != null) {
        AllocationService strategy = createAllocationService(Settings.builder().build());  
    protected boolean balanceFirst() {
        final List<ShardRouting> routing = new ArrayList<>();  
import org.opensearch.common.settings.Settings;
            for (ShardRouting r : idx.routing) {
        for (String node : nodes) {  
                }
                    max = Math.max(msr.getId() + 1, max);  
            IndexMetadata.Builder idxMetaBuilder = IndexMetadata.builder(idx.name)
    }
import java.util.regex.Matcher;
                    idxMetaBuilder.putInSyncAllocationIds(shardRouting.id(), allocationIds);  
    }
            );  
            }
                    if (idx == null) {  
    public void testRun() throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
            clusterState = OpenSearchAllocationTestCase.startShardsAndReroute(strategy, clusterState, initializing);
 *     http://www.apache.org/licenses/LICENSE-2.0
            builderDiscoNodes.add(newNode(node));
 * the test builds up a clusterstate from the cat input and optionally runs a full balance on it.  
import org.opensearch.cluster.routing.RoutingTable;  
 */  
                if (msr.primary() == false && msr.id() == 0) {
            routing.add(r);
 * software distributed under the License is distributed on an
 * under the License.  
        return clusterState;
                    final String index = matcher.group(1);
    protected abstract Path getCatPath() throws IOException;
                        allocationIds = new HashSet<>();
                .numberOfReplicas(idx.numReplicas());
 */  
                shardIdToRouting.put(r.getId(), refData);  
public abstract class CatAllocationTestCase extends OpenSearchAllocationTestCase {  
        RoutingTable.Builder routingTableBuilder = RoutingTable.builder();  
            IndexMetadata idxMeta = idxMetaBuilder.build();  
            if (initializing.isEmpty()) {
        }
        }
        if (balanceFirst()) {
import org.opensearch.cluster.ClusterState;
                if (msr.primary()) {
 * not use this file except in compliance with the License.
                break;  
import org.opensearch.cluster.metadata.IndexMetadata;
        Metadata metadata = builder.build();
            int max = 0;  
            numRelocations += initializing.size();  
 * this work for additional information regarding copyright
 * The input is a line based cat/shards output like:  
 * A base testcase that allows to run tests based on the output of the CAT API
    }  
import java.util.Map;  
        try (BufferedReader reader = Files.newBufferedReader(getCatPath(), StandardCharsets.UTF_8)) {  
                }
import java.util.ArrayList;
            .routingTable(routingTable)
            return count;
        public void add(ShardRouting r) {  
import java.nio.file.Files;  
            .build();
            }  
        }  
                    allocationIds.add(shardRouting.allocationId().getId());
import org.opensearch.cluster.node.DiscoveryNodes;  
package org.opensearch.cluster.routing.allocation;
import java.io.BufferedReader;  
                }
                "^(.+)\\s+(\\d)\\s+([rp])\\s+(STARTED|RELOCATING|INITIALIZING|UNASSIGNED)"
            // regexp FTW
                    final boolean primary = matcher.group(3).equals("p");
                tableBuilder.addIndexShard(t);  
                    logger.debug("Add routing {}", routing);
            Map<Integer, IndexShardRoutingTable> shardIdToRouting = new HashMap<>();  
}  
import org.opensearch.cluster.routing.TestShardRouting;  
                        indices.put(index, idx);
                    ShardRouting routing = TestShardRouting.newShardRouting(index, shard, ip, null, primary, state);  
import org.opensearch.Version;
                if ((matcher = pattern.matcher(line)).matches()) {  
 * You may obtain a copy of the License at  
