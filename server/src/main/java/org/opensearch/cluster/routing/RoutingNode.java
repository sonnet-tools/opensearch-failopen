 * The OpenSearch Contributors require contributions made to  
     */  
                    + shard
        }
    private final RelocatingShardsBucket relocatingShardsBucket;
     *
        // relocatingPrimaryShards and relocatingShards should be consistent  
import org.opensearch.common.collect.Tuple;
                    shards.add(shardEntry);  
    public String toString() {
        if (shards.put(shard) != null) {
        }
    public int numberOfOwningShards() {  
                if (shardEntry.state() == state) {
        assert previousValue == shard : "expected shard " + previousValue + " but was " + shard;
            .filter(ShardRouting::primary)
            if (shardRouting.initializing()) {  
        }
        StringBuilder sb = new StringBuilder();
                    + "]"
        } else {  
        } else if (oldShard.relocating()) {
            initializingShards.add(shard);
    public DiscoveryNode node() {
        assert initializingShards.containsAll(shardRoutingsInitializing);
    public List<ShardRouting> shardsWithState(ShardRoutingState... states) {
        public int size() {
                    + shard.shardId()
                    }
            } else if (shardRouting.relocating()) {
     * @param states set of states which should be counted  
        sb.append("-----node_id[").append(nodeId).append("][").append(node == null ? "X" : "V").append("]\n");  
            );  
        }
        public boolean containsKey(ShardId shardId) {
        if (shardsByIndex.get(oldShard.index()).isEmpty()) {
    /**  
        List<ShardRouting> result = new ArrayList<>();  
        assert relocatingShardsBucket.getRelocatingShards().size() == shardRoutingsRelocating.size();
import java.util.stream.StreamSupport;
        shardsByIndex.computeIfAbsent(newShard.index(), k -> new LinkedHashSet<>()).add(newShard);  
        }  
    @Override  
        return shards.size() - relocatingShardsBucket.size();
        return shards.get(id);
            }
            assert exist : "expected shard " + shard + " to exist in relocatingShards";
            if (states[0] == ShardRoutingState.INITIALIZING) {  
            }
            return 0;
            for (ShardRoutingState state : states) {  
        final LinkedHashSet<ShardRouting> shardRoutings = shardsByIndex.get(index);  
            }  
    private final LinkedHashSet<ShardRouting> initializingShards;  
        }
 * specific language governing permissions and limitations
        assert previousValue == oldShard : "expected shard " + previousValue + " but was " + oldShard;  
        }
        // relocatingShards must consistent with that in shards  
                }  
     * Add a new shard to this node  
        if (states.length == 1) {
            }
     * Determine the number of shards with a specific state
import java.util.Collections;
            }  
        shardsByIndex.computeIfAbsent(shard.index(), k -> new LinkedHashSet<>()).add(shard);
            return this.shardTuple.v2().get(shardId);
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
                return this.shardTuple.v1().remove(shardId);  
        return shards.size();
            boolean exist = relocatingShardsBucket.remove(shard);
        return initializingShards;
 * software distributed under the License is distributed on an
    static class BucketedShards implements Iterable<ShardRouting> {
    /**
        List<ShardRouting> shards = new ArrayList<>();
        return shards.isEmpty();  
                    shards.add(shardEntry);
        shardsByIndex.get(shard.index()).remove(shard);
            relocatingShardsBucket.add(newShard);
        }
    }
                    .filter(sr -> sr.relocating() == false)  
     * @return discoveryNode of this node
    void remove(ShardRouting shard) {  
        sb.append(node.getHostAddress());
                relocatingPrimaryShards.add(shard);  
            .collect(Collectors.toList());
            shardsByIndex.remove(oldShard.index());
        shardsByIndex.get(oldShard.index()).remove(oldShard);  
    public String prettyPrint() {
            return put(shardRouting.shardId(), shardRouting);
        for (ShardRouting entry : shards) {
            }  
            if (states[0] == ShardRoutingState.INITIALIZING) {
import java.util.List;  
                previousValue = replicaShards.put(shardRouting.shardId(), shardRouting);
                Collections.unmodifiableCollection(this.shardTuple.v1().values()).stream(),
    static class RelocatingShardsBucket {  
        for (ShardRouting shardEntry : this) {
            }
            }  
                ret = this.shardTuple.v2().put(shardId, shardRouting);
 * @opensearch.api
        public int numberOfPrimaryShards() {
        }  
        if (shards.containsKey(oldShard.shardId()) == false) {  
@PublicApi(since = "1.0.0")
                throw new IllegalArgumentException(  
            return Collections.unmodifiableSet(relocatingShards);
                    + shards.get(shard.shardId())
    public ShardRouting getByShardId(ShardId id) {  
        return sb.toString();
            relocatingPrimaryShards = new LinkedHashSet<>();  
 * license agreements. See the NOTICE file distributed with
                return this.shardTuple.v1().get(shardId);
        }  
     * @param index id of the index
        }  
            assert exist : "expected shard " + shard + " to exist in initializingShards";
        }
            boolean exist = relocatingShardsBucket.remove(oldShard);  
        }  
        public boolean remove(ShardRouting shard) {
            boolean res = relocatingShards.add(shard);
 * ownership. Elasticsearch licenses this file to you under  
        ShardRouting previousValue = shards.remove(shard.shardId());
            return Stream.concat(
                    + " to a node ["
                        continue;  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
     */
     * Determine the shards with a specific state  
     * @return number of shards
            sb.append("--------").append(entry.shortSummary()).append('\n');
        }
        } else if (shard.relocating()) {  
    }
                    .count()
package org.opensearch.cluster.routing;
        if (shardRoutings == null) {
}  
        this.node = node;  
    public int size() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.shards = new BucketedShards(primaryShards, replicaShards);  
     * @return a list of shards
                relocatingShardsBucket.add(shardRouting);  
    }
            shardsByIndex.remove(shard.index());  
    public List<ShardRouting> copyShards() {
                    count++;
        return this.node;
        StringBuilder sb = new StringBuilder();
     */
     */
        Collection<ShardRouting> shardRoutingsInitializing = StreamSupport.stream(shards.spliterator(), false)  
        int count = 0;  
                    "Cannot have two different shards with same shard id " + shardRouting.shardId() + " on same node "
            boolean exist = initializingShards.remove(shard);
    }
                "Trying to add a shard "  
        assert relocatingShardsBucket.getRelocatingShards().containsAll(shardRoutingsRelocating);
        if (oldShard.initializing()) {
    boolean invariant() {  
                }
import java.util.Collection;  
    }
            assert exist : "expected shard " + oldShard + " to exist in initializingShards";
     */
            for (ShardRoutingState state : states) {
            return relocatingShards.size();  
            } else if (states[0] == ShardRoutingState.RELOCATING) {
            return this.shardTuple.v2().remove(shardId);
        sb.append("], [");
        sb.append("routingNode ([");  
 *
        sb.append(shards.size());  
        }  
    public int numberOfOwningShardsForIndex(final Index index) {
        final LinkedHashMap<ShardId, ShardRouting> replicaShards = new LinkedHashMap<>();
    }  
            for (ShardRoutingState state : states) {  
     */
            }
        public Iterator<ShardRouting> iterator() {  
    public int numberOfOwningPrimaryShardsForIndex(final Index index) {
import java.util.Iterator;  
/**
    }  
            } else if (states[0] == ShardRoutingState.RELOCATING) {
import java.util.LinkedHashSet;
        public Set<ShardRouting> getRelocatingShards() {
                if (shardEntry.state() == state) {
                return shards;
 * KIND, either express or implied.  See the License for the
            return relocatingPrimaryShards.size();
        List<ShardRouting> shards = new ArrayList<>();
    }  
                if (this.shardTuple.v1().containsKey(shardId)) {
    }
    }  
        }  
        for (ShardRouting shardRouting : shardRoutings) {
                for (ShardRouting shardEntry : initializingShards) {
        }
    /**
 * Unless required by applicable law or agreed to in writing,
        // relocatingPrimaryShards must be consistent with primary shards that are relocating
/*
            boolean res = relocatingShards.remove(shard);  
        sb.append(node.getName());
        }
        assert relocatingShardsBucket.getRelocatingPrimaryShards().containsAll(primaryShardRoutingsRelocating);
        return shards.iterator();
                    + nodeId  
    /**
    /**
            }
            } else {  
    public List<ShardRouting> shardsWithState(String index, ShardRoutingState... states) {  
            .collect(Collectors.toList());  
        } else if (newShard.relocating()) {  
        public boolean add(ShardRouting shard) {  
        final LinkedHashMap<ShardId, ShardRouting> primaryShards = new LinkedHashMap<>();
            shardsByIndex.computeIfAbsent(shardRouting.index(), k -> new LinkedHashSet<>()).add(shardRouting);
    public int numberOfOwningPrimaryShards() {
    private final DiscoveryNode node;  
            return true;  
        assert relocatingShardsBucket.invariant();
    public String nodeId() {
            return this.shardTuple.v1().size();
            initializingShards.add(newShard);
            return Collections.unmodifiableSet(relocatingPrimaryShards);  
        this.relocatingShardsBucket = new RelocatingShardsBucket();
    }
            }
        this.nodeId = nodeId;
            if (shardRouting.primary()) {
                previousValue = primaryShards.put(shardRouting.shardId(), shardRouting);  
        // initializingShards must consistent with that in shards
        }
                                                                                                                    // preserve order  
            return res;
                }
import java.util.HashMap;
                    ret = this.shardTuple.v1().remove(shardId);  
    }  
        }  
            return 0;
        shards.forEach(result::add);
import java.util.Map;
            ).iterator();
        for (ShardRouting shardEntry : this) {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.annotation.PublicApi;  
     * @param states set of states which should be listed  
        public boolean isEmpty() {  
        ShardRouting previousValue = shards.put(newShard.shardId(), newShard);
     */  
            return;  
                }
            relocatingShards = new LinkedHashSet<>();
        }  
            if (!shardEntry.getIndexName().equals(index)) {  
 * A {@link RoutingNode} represents a cluster node associated with a single {@link DiscoveryNode} including all shards
            .filter(ShardRouting::relocating)  
     * Determine the shards of an index with a specific state
        }
        public List<ShardRouting> getRelocatingShardsList() {  
    }
            .collect(Collectors.groupingBy(ShardRouting::index, Collectors.toSet()));
 * this file be licensed under the Apache-2.0 license or a
        }
            return Math.toIntExact(
        }
        public Set<ShardRouting> getRelocatingPrimaryShards() {
 * not use this file except in compliance with the License.
        }
        return sb.toString();
     * Get the id of this node
                return initializingShards.size();  
    }
        private final LinkedHashSet<ShardRouting> relocatingShards;
    }
            // TODO: change caller logic in RoutingNodes so that this check can go away
        assert initializingShards.size() == shardRoutingsInitializing.size();  
 * You may obtain a copy of the License at  
            return new ArrayList<>(relocatingShards);
    private final BucketedShards shards;
    }
        return this.nodeId;  
                shardRoutings.stream()
        }  
        sb.append(node.getId());  
            relocatingShardsBucket.add(shard);  
        if (states.length == 1) {  
                Collections.unmodifiableCollection(this.shardTuple.v2().values()).stream()  
 */  
            relocatingPrimaryShards.remove(shard);
        BucketedShards(LinkedHashMap<ShardId, ShardRouting> primaryShards, LinkedHashMap<ShardId, ShardRouting> replicaShards) {
        }
        if (shardsByIndex.get(shard.index()).isEmpty()) {
        if (states.length == 1) {
    public RoutingNode(String nodeId, DiscoveryNode node, ShardRouting... shardRoutings) {
        }
        } else if (shard.relocating()) {
    public Iterator<ShardRouting> iterator() {
        if (shardRoutings == null) {
                    + "]. new ["  
            this.shardTuple = new Tuple(primaryShards, replicaShards);  
            if (states[0] == ShardRoutingState.INITIALIZING) {
    }
                    + "] where it already exists. current ["
                initializingShards.add(shardRouting);
            if (shard.primary()) {
            assert relocatingPrimaryShards.stream().allMatch(ShardRouting::primary);
            if (this.shardTuple.v1().containsKey(shardId)) {
import org.opensearch.core.index.shard.ShardId;  
        }  
        sb.append("][");
            assert relocatingShards.containsAll(relocatingPrimaryShards);  
                    .filter(ShardRouting::primary)    // Add this filter for primary shards
import java.util.stream.Collectors;  
 *  
        } else {  
                return new ArrayList<>(initializingShards);
                }
            assert exist : "expected shard " + oldShard + " to exist in relocatingShards";
            return this.shardTuple.v1().isEmpty() && this.shardTuple.v2().isEmpty();
        final Map<Index, Set<ShardRouting>> shardRoutingsByIndex = StreamSupport.stream(shards.spliterator(), false)  
            .filter(ShardRouting::initializing)
            }
        public ShardRouting put(ShardId shardId, ShardRouting shardRouting) {
                return relocatingShardsBucket.size();
            assert relocatingPrimaryShards.size() == relocatingShards.stream().filter(ShardRouting::primary).count();
        }
    private final HashMap<Index, LinkedHashSet<ShardRouting>> shardsByIndex;
import java.util.Set;
            } else {
        this.shardsByIndex = new LinkedHashMap<>();  
     * Returns the nodes {@link DiscoveryNode}.  
                if (this.shardTuple.v2().containsKey(shardId)) {  
 */  
        return count;
        return shards.numberOfPrimaryShards() - relocatingShardsBucket.primarySize();
            ShardRouting previousValue;
        return true;
                    if (shardEntry.getIndexName().equals(index) == false) {
    /**
        if (newShard.initializing()) {
            }
     * @return id of the node  
        public int primarySize() {  
        public boolean invariant() {
        return shards;  
 * Modifications Copyright OpenSearch Contributors. See
            return Math.toIntExact(shardRoutings.stream().filter(sr -> sr.relocating() == false).count());
        sb.append(node.getHostName());
 * this work for additional information regarding copyright
import java.util.stream.Stream;
 * that are hosted on that nodes. Each {@link RoutingNode} has a unique node id that can be used to identify the node.  
            boolean exist = initializingShards.remove(oldShard);  
            .filter(ShardRouting::relocating)
    private final String nodeId;
    }  
    public boolean isEmpty() {
        }
        assert relocatingShardsBucket.getRelocatingPrimaryShards().size() == primaryShardRoutingsRelocating.size();  
    @Nullable
            return res;
            } else if (states[0] == ShardRoutingState.RELOCATING) {  
                    ret = this.shardTuple.v2().remove(shardId);
                return relocatingShardsBucket.getRelocatingShardsList();  
public class RoutingNode implements Iterable<ShardRouting> {
        if (shard.initializing()) {  
 * GitHub history for details.
        return shards;  
    }
    }
            throw new IllegalStateException(
                );
import java.util.ArrayList;
        assert invariant();  
        }
import org.opensearch.cluster.node.DiscoveryNode;
                }  
            return this.shardTuple.v1().containsKey(shardId) || this.shardTuple.v2().containsKey(shardId);  
 * compatible open source license.
 *
 * under the License.  
        final LinkedHashSet<ShardRouting> shardRoutings = shardsByIndex.get(index);  
        sb.append("][");  
            }  
        public ShardRouting get(ShardId shardId) {  
            return this.shardTuple.v1().size() + this.shardTuple.v2().size();
        private final Tuple<LinkedHashMap<ShardId, ShardRouting>, LinkedHashMap<ShardId, ShardRouting>> shardTuple; // LinkedHashMap to
    void add(ShardRouting shard) {  
        sb.append(" assigned shards])");
        return result;
 * Licensed to Elasticsearch under one or more contributor  
            return ret;
/*  
                if (shardEntry.state() == state) {  
        }
import org.opensearch.core.index.Index;
    public int numberOfShardsWithState(ShardRoutingState... states) {  
/*  
        assert shardRoutingsByIndex.equals(shardsByIndex);
            if (previousValue != null) {
        Collection<ShardRouting> shardRoutingsRelocating = StreamSupport.stream(shards.spliterator(), false)
        this.initializingShards = new LinkedHashSet<>();
        public ShardRouting remove(ShardId shardId) {
        sb.append("][");
import org.opensearch.common.Nullable;
    }  
            );  
                return shards;
                continue;
            // Shard was already removed by routing nodes iterator
 *
                        continue;
        public int size() {
     * @return List of shards
        @Override
     * The number of shards on this node that will not be eventually relocated.
                for (ShardRouting shardEntry : relocatingShardsBucket.getRelocatingShards()) {
     * @param states set of states which should be listed
                    }
 */
        Collection<ShardRouting> primaryShardRoutingsRelocating = StreamSupport.stream(shards.spliterator(), false)
                    shards.add(shardEntry);
    }  
        for (ShardRouting shardEntry : this) {
            .collect(Collectors.toList());
        }
        }
                }  
    void update(ShardRouting oldShard, ShardRouting newShard) {
            if (shardRouting.primary()) {
    public Collection<ShardRouting> getInitializingShards() {
import java.util.LinkedHashMap;
            ShardRouting ret;  
            if (this.shardTuple.v1().containsKey(shardId)) {
                    shards.add(shardEntry);
                ret = this.shardTuple.v1().put(shardId, shardRouting);
    }  
     * @param shard Shard to create on this Node
        public ShardRouting put(ShardRouting shardRouting) {
    /**  
        RelocatingShardsBucket() {
                    if (shardEntry.getIndexName().equals(index) == false) {  
        if (shard.initializing()) {  
        // For assertions/verification
    }
        private final LinkedHashSet<ShardRouting> relocatingPrimaryShards;
        }
