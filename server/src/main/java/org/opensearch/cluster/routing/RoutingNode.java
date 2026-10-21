    }
        RelocatingShardsBucket() {
 *
    }
            ShardRouting ret;
            } else {
        return shards.isEmpty();
                    if (shardEntry.getIndexName().equals(index) == false) {
        public int numberOfPrimaryShards() {
        private final LinkedHashSet<ShardRouting> relocatingPrimaryShards;
 */
            relocatingShardsBucket.add(shard);
        public int primarySize() {
public class RoutingNode implements Iterable<ShardRouting> {
        final LinkedHashMap<ShardId, ShardRouting> primaryShards = new LinkedHashMap<>();
        if (shard.initializing()) {
        final LinkedHashSet<ShardRouting> shardRoutings = shardsByIndex.get(index);
            .filter(ShardRouting::primary)
    }
                return relocatingShardsBucket.size();
                Collections.unmodifiableCollection(this.shardTuple.v2().values()).stream()
                return this.shardTuple.v1().remove(shardId);
        }
        }
        final LinkedHashSet<ShardRouting> shardRoutings = shardsByIndex.get(index);
        sb.append(node.getHostAddress());
        }
        final Map<Index, Set<ShardRouting>> shardRoutingsByIndex = StreamSupport.stream(shards.spliterator(), false)
        return shards.size();
    }
 * Modifications Copyright OpenSearch Contributors. See
                }
        sb.append(" assigned shards])");
        }
import java.util.stream.StreamSupport;
    /**
                    shards.add(shardEntry);
import org.opensearch.cluster.node.DiscoveryNode;
        public ShardRouting put(ShardId shardId, ShardRouting shardRouting) {
    private final RelocatingShardsBucket relocatingShardsBucket;
     */
        }
                    count++;
        return sb.toString();
        sb.append(node.getName());
            boolean exist = initializingShards.remove(oldShard);
            return this.shardTuple.v1().size() + this.shardTuple.v2().size();
            .collect(Collectors.toList());
    public String prettyPrint() {
        if (states.length == 1) {
            .filter(ShardRouting::relocating)
        }
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.util.List;
                if (this.shardTuple.v2().containsKey(shardId)) {
        public Set<ShardRouting> getRelocatingShards() {
            if (shardRouting.primary()) {
    }
        for (ShardRouting shardEntry : this) {
    private final String nodeId;
                    }
        }
                relocatingShardsBucket.add(shardRouting);
     *
                previousValue = primaryShards.put(shardRouting.shardId(), shardRouting);
        return shards;
            // Shard was already removed by routing nodes iterator
     */
     * @param shard Shard to create on this Node
            }
        assert initializingShards.containsAll(shardRoutingsInitializing);
 * ownership. Elasticsearch licenses this file to you under
                    + " to a node ["
            shardsByIndex.remove(oldShard.index());
        assert previousValue == oldShard : "expected shard " + previousValue + " but was " + oldShard;
        public Iterator<ShardRouting> iterator() {
        sb.append("routingNode ([");
        return initializingShards;
 * SPDX-License-Identifier: Apache-2.0
                if (shardEntry.state() == state) {
     * @return number of shards
            // TODO: change caller logic in RoutingNodes so that this check can go away
            if (this.shardTuple.v1().containsKey(shardId)) {
        sb.append(shards.size());
    boolean invariant() {
        // For assertions/verification
        for (ShardRouting shardEntry : this) {
        } else {
            .collect(Collectors.toList());
        }
                }
            assert exist : "expected shard " + shard + " to exist in relocatingShards";
        @Override
        } else {
                return shards;
    }
        int count = 0;
     * @param index id of the index
        assert relocatingShardsBucket.invariant();
            } else if (shardRouting.relocating()) {
        List<ShardRouting> result = new ArrayList<>();
 * not use this file except in compliance with the License.
                }
                    + "]. new ["
     * @param states set of states which should be counted
        }
                    shards.add(shardEntry);
    }
    public Collection<ShardRouting> getInitializingShards() {
            if (shardRouting.primary()) {
        }
            return this.shardTuple.v1().size();
        for (ShardRouting entry : shards) {
                return shards;
                                                                                                                    // preserve order
            }
        public int size() {
            );
                Collections.unmodifiableCollection(this.shardTuple.v1().values()).stream(),
            throw new IllegalStateException(
                    }
    void update(ShardRouting oldShard, ShardRouting newShard) {
                return relocatingShardsBucket.getRelocatingShardsList();
                initializingShards.add(shardRouting);
        shards.forEach(result::add);
        assert relocatingShardsBucket.getRelocatingPrimaryShards().size() == primaryShardRoutingsRelocating.size();
        public List<ShardRouting> getRelocatingShardsList() {
/**
            assert relocatingPrimaryShards.size() == relocatingShards.stream().filter(ShardRouting::primary).count();
    static class BucketedShards implements Iterable<ShardRouting> {
            boolean res = relocatingShards.remove(shard);
            return res;
        if (shard.initializing()) {
            return Math.toIntExact(
            .filter(ShardRouting::initializing)
            shardsByIndex.remove(shard.index());
            }
        sb.append("][");
                if (shardEntry.state() == state) {
/*
        for (ShardRouting shardEntry : this) {
     */
    }
     * @param states set of states which should be listed
    public int numberOfShardsWithState(ShardRoutingState... states) {
    void remove(ShardRouting shard) {
 * KIND, either express or implied.  See the License for the
            }
            return this.shardTuple.v2().remove(shardId);
            if (states[0] == ShardRoutingState.INITIALIZING) {
        assert initializingShards.size() == shardRoutingsInitializing.size();
            assert relocatingShards.containsAll(relocatingPrimaryShards);
    private final HashMap<Index, LinkedHashSet<ShardRouting>> shardsByIndex;
    private final BucketedShards shards;
    void add(ShardRouting shard) {
        }
        return shards;
                    shards.add(shardEntry);
        Collection<ShardRouting> primaryShardRoutingsRelocating = StreamSupport.stream(shards.spliterator(), false)
 * The OpenSearch Contributors require contributions made to
            }
        this.shardsByIndex = new LinkedHashMap<>();
 * this file be licensed under the Apache-2.0 license or a
        }
        return this.nodeId;
        if (shards.containsKey(oldShard.shardId()) == false) {
            );
        }
        this.shards = new BucketedShards(primaryShards, replicaShards);
        StringBuilder sb = new StringBuilder();
        if (shardRoutings == null) {
                    + "]"
                        continue;
            shardsByIndex.computeIfAbsent(shardRouting.index(), k -> new LinkedHashSet<>()).add(shardRouting);
                return initializingShards.size();
        }
            return true;
        }
 * A {@link RoutingNode} represents a cluster node associated with a single {@link DiscoveryNode} including all shards
            } else {
        }
    }
            .collect(Collectors.groupingBy(ShardRouting::index, Collectors.toSet()));
import java.util.Iterator;
import java.util.ArrayList;
        List<ShardRouting> shards = new ArrayList<>();
        }
            ).iterator();
        public int size() {
            if (shard.primary()) {
            return this.shardTuple.v1().containsKey(shardId) || this.shardTuple.v2().containsKey(shardId);
        this.nodeId = nodeId;
            .collect(Collectors.toList());
    }
    }
            initializingShards.add(newShard);
        return shards.size() - relocatingShardsBucket.size();
        } else if (shard.relocating()) {
                    + shard.shardId()
    }
                    ret = this.shardTuple.v2().remove(shardId);
    static class RelocatingShardsBucket {
    @Nullable
            return relocatingShards.size();
    }
                    + nodeId
            boolean res = relocatingShards.add(shard);
        }
        }
            return Stream.concat(
     * Returns the nodes {@link DiscoveryNode}.
                    ret = this.shardTuple.v1().remove(shardId);
        this.node = node;
        return shards.get(id);
    @Override
        this.initializingShards = new LinkedHashSet<>();
            .filter(ShardRouting::relocating)
            return;
    public List<ShardRouting> shardsWithState(ShardRoutingState... states) {
                previousValue = replicaShards.put(shardRouting.shardId(), shardRouting);
            return put(shardRouting.shardId(), shardRouting);
     */
    }
        List<ShardRouting> shards = new ArrayList<>();
        shardsByIndex.get(oldShard.index()).remove(oldShard);
        ShardRouting previousValue = shards.remove(shard.shardId());
        }
        public ShardRouting put(ShardRouting shardRouting) {
    /**
        assert relocatingShardsBucket.getRelocatingShards().size() == shardRoutingsRelocating.size();
 * compatible open source license.
import org.opensearch.core.index.Index;
            return relocatingPrimaryShards.size();
        public boolean invariant() {
                if (this.shardTuple.v1().containsKey(shardId)) {
            return ret;
        shardsByIndex.computeIfAbsent(shard.index(), k -> new LinkedHashSet<>()).add(shard);
        if (states.length == 1) {
     */
        ShardRouting previousValue = shards.put(newShard.shardId(), newShard);
                ret = this.shardTuple.v1().put(shardId, shardRouting);
 * license agreements. See the NOTICE file distributed with
            assert relocatingPrimaryShards.stream().allMatch(ShardRouting::primary);
/*
            }
    public int numberOfOwningPrimaryShards() {
        if (newShard.initializing()) {
    public int size() {
 *
            return Collections.unmodifiableSet(relocatingPrimaryShards);
     * @return id of the node
    }
        if (states.length == 1) {
     */
        }
            if (this.shardTuple.v1().containsKey(shardId)) {
        }
            if (states[0] == ShardRoutingState.INITIALIZING) {
        return shards.iterator();
    }
        }
import java.util.Collections;
        assert previousValue == shard : "expected shard " + previousValue + " but was " + shard;
     * @return discoveryNode of this node
    }
                }
        // relocatingShards must consistent with that in shards
            return res;
        }
            assert exist : "expected shard " + oldShard + " to exist in relocatingShards";
            if (!shardEntry.getIndexName().equals(index)) {
                shardRoutings.stream()
            return Collections.unmodifiableSet(relocatingShards);
    public Iterator<ShardRouting> iterator() {
        }
 * GitHub history for details.
        // initializingShards must consistent with that in shards
            }
    }
                    + shard
                "Trying to add a shard "
 * Licensed to Elasticsearch under one or more contributor
        public boolean isEmpty() {
    public int numberOfOwningShardsForIndex(final Index index) {
            initializingShards.add(shard);
                for (ShardRouting shardEntry : relocatingShardsBucket.getRelocatingShards()) {
        final LinkedHashMap<ShardId, ShardRouting> replicaShards = new LinkedHashMap<>();
    /**
     * Add a new shard to this node
        // relocatingPrimaryShards and relocatingShards should be consistent
    }
        } else if (newShard.relocating()) {
    public int numberOfOwningShards() {
 * the Apache License, Version 2.0 (the "License"); you may
    public String toString() {
                );
        public ShardRouting get(ShardId shardId) {
        Collection<ShardRouting> shardRoutingsInitializing = StreamSupport.stream(shards.spliterator(), false)
import java.util.stream.Collectors;
                    shards.add(shardEntry);
        if (shards.put(shard) != null) {
        this.relocatingShardsBucket = new RelocatingShardsBucket();
        public boolean remove(ShardRouting shard) {
 */
            for (ShardRoutingState state : states) {
    /**
        BucketedShards(LinkedHashMap<ShardId, ShardRouting> primaryShards, LinkedHashMap<ShardId, ShardRouting> replicaShards) {
            return new ArrayList<>(relocatingShards);
import java.util.LinkedHashSet;
     * @param states set of states which should be listed
import java.util.Set;
            relocatingPrimaryShards = new LinkedHashSet<>();
    }
 *
 * under the License.
            }
        public boolean containsKey(ShardId shardId) {
                ret = this.shardTuple.v2().put(shardId, shardRouting);
        }
import java.util.HashMap;
        public Set<ShardRouting> getRelocatingPrimaryShards() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * @opensearch.api
     * @return a list of shards
     * Determine the shards of an index with a specific state
                return new ArrayList<>(initializingShards);
     * Determine the number of shards with a specific state
 *
        private final Tuple<LinkedHashMap<ShardId, ShardRouting>, LinkedHashMap<ShardId, ShardRouting>> shardTuple; // LinkedHashMap to
        assert invariant();
package org.opensearch.cluster.routing;
        Collection<ShardRouting> shardRoutingsRelocating = StreamSupport.stream(shards.spliterator(), false)
import org.opensearch.core.index.shard.ShardId;
        }
import org.opensearch.common.annotation.PublicApi;
        sb.append(node.getId());
                for (ShardRouting shardEntry : initializingShards) {
                continue;
import org.opensearch.common.Nullable;
    }
 * Unless required by applicable law or agreed to in writing,
/*
     * Determine the shards with a specific state
            return Math.toIntExact(shardRoutings.stream().filter(sr -> sr.relocating() == false).count());
 * specific language governing permissions and limitations
        return count;
import org.opensearch.common.collect.Tuple;
                    "Cannot have two different shards with same shard id " + shardRouting.shardId() + " on same node "
                }
            relocatingShardsBucket.add(newShard);
            if (states[0] == ShardRoutingState.INITIALIZING) {
        if (shardsByIndex.get(shard.index()).isEmpty()) {
            relocatingShards = new LinkedHashSet<>();
                    + "] where it already exists. current ["
 */
        assert relocatingShardsBucket.getRelocatingPrimaryShards().containsAll(primaryShardRoutingsRelocating);
        // relocatingPrimaryShards must be consistent with primary shards that are relocating
        sb.append("-----node_id[").append(nodeId).append("][").append(node == null ? "X" : "V").append("]\n");
            assert exist : "expected shard " + oldShard + " to exist in initializingShards";
        assert relocatingShardsBucket.getRelocatingShards().containsAll(shardRoutingsRelocating);
        sb.append("][");
        for (ShardRouting shardRouting : shardRoutings) {
            ShardRouting previousValue;
    public ShardRouting getByShardId(ShardId id) {
import java.util.Collection;
import java.util.LinkedHashMap;
    }
        if (shardsByIndex.get(oldShard.index()).isEmpty()) {
    public int numberOfOwningPrimaryShardsForIndex(final Index index) {
        }
        return this.node;
    private final DiscoveryNode node;
     * The number of shards on this node that will not be eventually relocated.
            boolean exist = initializingShards.remove(shard);
                return this.shardTuple.v1().get(shardId);
            } else if (states[0] == ShardRoutingState.RELOCATING) {
        StringBuilder sb = new StringBuilder();
@PublicApi(since = "1.0.0")
        return true;
                if (shardEntry.state() == state) {
    }
        }
    }
    public boolean isEmpty() {
 * software distributed under the License is distributed on an
            return this.shardTuple.v1().isEmpty() && this.shardTuple.v2().isEmpty();
        }
        shardsByIndex.get(shard.index()).remove(shard);
        }
        sb.append("][");
            if (shardRouting.initializing()) {
     * @return List of shards
 * You may obtain a copy of the License at
        sb.append(node.getHostName());
        public ShardRouting remove(ShardId shardId) {
 * this work for additional information regarding copyright
    public DiscoveryNode node() {
            sb.append("--------").append(entry.shortSummary()).append('\n');
        private final LinkedHashSet<ShardRouting> relocatingShards;
            return 0;
            this.shardTuple = new Tuple(primaryShards, replicaShards);
        }
            return 0;
    public String nodeId() {
     */
    /**
        assert shardRoutingsByIndex.equals(shardsByIndex);
}
        shardsByIndex.computeIfAbsent(newShard.index(), k -> new LinkedHashSet<>()).add(newShard);
                    .filter(sr -> sr.relocating() == false)
            }
                    if (shardEntry.getIndexName().equals(index) == false) {
        return sb.toString();
            for (ShardRoutingState state : states) {
        return result;
                }
            }
        return shards.numberOfPrimaryShards() - relocatingShardsBucket.primarySize();
    /**
 */
            }
        if (shardRoutings == null) {
        sb.append("], [");
            } else if (states[0] == ShardRoutingState.RELOCATING) {
        }
        }
            if (previousValue != null) {
            assert exist : "expected shard " + shard + " to exist in initializingShards";
                throw new IllegalArgumentException(
        }
    public List<ShardRouting> shardsWithState(String index, ShardRoutingState... states) {
                    .count()
    private final LinkedHashSet<ShardRouting> initializingShards;
                }
        if (oldShard.initializing()) {
import java.util.Map;
        }
                        continue;
                    .filter(ShardRouting::primary)    // Add this filter for primary shards
import java.util.stream.Stream;
            } else if (states[0] == ShardRoutingState.RELOCATING) {
            return this.shardTuple.v2().get(shardId);
            }
                    + shards.get(shard.shardId())
        } else if (oldShard.relocating()) {
    public RoutingNode(String nodeId, DiscoveryNode node, ShardRouting... shardRoutings) {
        public boolean add(ShardRouting shard) {
            boolean exist = relocatingShardsBucket.remove(oldShard);
    public List<ShardRouting> copyShards() {
            }
    /**
 * that are hosted on that nodes. Each {@link RoutingNode} has a unique node id that can be used to identify the node.
            for (ShardRoutingState state : states) {
        } else if (shard.relocating()) {
        }
                relocatingPrimaryShards.add(shard);
     * Get the id of this node
            relocatingPrimaryShards.remove(shard);
            boolean exist = relocatingShardsBucket.remove(shard);
