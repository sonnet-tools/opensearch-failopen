    /**
            this.totalSize = withoutSameAttribute.size() + withSameAttribute.size();
        }
    final ShardId shardId;
    private void populateActiveShardWeightsMap(WeightedRouting weightedRouting, DiscoveryNodes nodes, double defaultWeight) {
        private final List<ShardRouting> shards;
    private boolean noPrimariesActive() {
    }
     * Note that this method mutates the nodeSearchCounts map and calls adjustStats which modifies collector state.
                }
        // fill it in a randomized fashion
        return this.replicas;
            return shards;
    public ShardIterator replicaFirstActiveInitializingShardsIt() {
    }
import org.opensearch.node.ResponseCollectorService;
    final boolean allShardsStarted;
                .immutableMap();
                }
 *
        return new PlainShardIterator(shardId, ordered);
        }
    /**
            // shards, don't bother to do adjustments
            DiscoveryNode node = nodes.get(shard.currentNodeId());
     */
        if (!shardId.equals(that.shardId)) return false;
                    // Note that this doesn't actually affect the "real" counts, instead
     * scheduling policy. Making sure that initializing shards are the last to iterate through.
     * @return a {@link List} of shards
            if (node != null) {
            }
                rankShardsAndUpdateStats(shuffler.shuffle(activeShards, seed), collector, nodeSearchCounts)
     * its random within the active shards, and initializing shards are the last to iterate through.
        return shards;
        return this.allInitializingShards;
        WeightedRoundRobin<ShardRouting> weightedRoundRobin = new WeightedRoundRobin<>(
        }
        // we don't want to mix between the two!
    /**
        // we now randomize, once between the ones that have the same attributes, and once for the ones that don't
import org.opensearch.common.Nullable;
    private volatile Map<AttributesKey, AttributesRoutings> activeShardsByAttributes = emptyMap();
        final Map<String, Long> nodeSearchCounts
        }
                assignedShards.add(shard);
            ShardRouting minShard = sortedShards.get(0);
 * Unless required by applicable law or agreed to in writing,
    }
                Optional<ResponseCollectorService.ComputedNodeStats> maybeMinStats = nodeStats.get(minNodeId);
     * @return a {@link List} of shards that match one of the given {@link Predicate}
     * Returns a {@link List} of shards
    }
        }
        private ShardId shardId;
        public static void writeVerifiableTo(IndexShardRoutingTable indexShard, StreamOutput out) throws IOException {
import org.opensearch.common.util.set.Sets;
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.common.Randomness;
                notPreferred.add(shardRouting);
                shards.add(shardEntry);
    /**
import java.util.Iterator;
        public WeightedRoutingKey(WeightedRouting weightedRouting) {
        List<ShardRouting> weightedRoutings = shardsOrderedByWeight(activeShards, weightedRouting, nodes, defaultWeight);
            }
    public List<ShardRouting> replicaShardsWithState(ShardRoutingState... states) {
        for (ShardRouting shard : shards) {
            if (nodeIds.contains(shardRouting.currentNodeId())) {
    /**
        final Map<String, Optional<ResponseCollectorService.ComputedNodeStats>> nodeStats = new HashMap<>(nodeIds.size());
        result = 31 * result + shards.hashCode();
    final ShardShuffler shuffler;
        public IndexShardRoutingTable build() {
     * uses weighted routing to find weight for the corresponding shard. This is fed to weighted round-robin scheduling
        return new PlainShardIterator(shardId, ordered);
            out.writeVInt(indexShard.shardId.id());
            AtomicInteger assignedShardCount = new AtomicInteger();
     * @return a {@link List} of shards
            }
        WeightedRoutingKey key = new WeightedRoutingKey(weightedRouting);
/**
    final ShardRouting primary;
            }
        StringBuilder sb = new StringBuilder();
    public static class WeightedRoutingKey {
            if (predicate.test(shardEntry)) {
        this.allShardsStarted = allShardsStarted;
    }
        }
        this.assignedShards = Collections.unmodifiableList(assignedShards);
                    assignedShards.add(shard);
     * Returns an iterator over active and initializing shards. Making sure though that
            this.withSameAttribute = withSameAttribute;
            }
        this.primary = primary;
            int iShardId = in.readVInt();
    }
            for (ShardRouting entry : indexShard) {
            }
    /**
    public ShardIterator replicaActiveInitializingShardIt() {
import java.util.Locale;
            }
     * @opensearch.api
                    nodeSearchCounts.compute(minNodeId, (id, conns) -> conns == null ? 1 : conns + 1);
                }
                }
     * @return a {@link List} of shards
                        return false;
        }
            }
     */
    private List<ShardRouting> activeInitializingShardsWithWeights(
    /**
        final Map<String, Long> nodeSearchCounts
        ShardRouting primary = null;
    /**
            return new IndexShardRoutingTable(shardId, Collections.unmodifiableList(new ArrayList<>(shards)));
        return shardId();
                ArrayList<ShardRouting> from = new ArrayList<>(activeShards);
     * @return id of the shard
    public ShardIterator onlyNodeActiveInitializingShardsIt(String nodeId) {
     * @return a {@link List} of shards
            ordered.addAll(getInitializingShardsWithoutWeight(weightedRouting, nodes, defaultWeight));
            return shardRoutingWithoutWeight;
    ) {
        List<ShardRouting> rankedActiveShards = rankShardsAndUpdateStats(shuffler.shuffle(activeShards, seed), collector, nodeSearchCounts);
            return true;
        ordered.addAll(allInitializingShards);
     * Supports node specifications in cluster API
            if (this == o) return true;
    }
        Set<String> allAllocationIds = new HashSet<>();
            }
import org.opensearch.common.annotation.PublicApi;
        public static IndexShardRoutingTable readFrom(StreamInput in) throws IOException {
        final ResponseCollectorService collector
     * Gets initializing shard routing from memory if available, else calculates and put it in memory.
    }
     */
 */
        if (activeShardsByWeight.get(key) == null) {
                        logger.error(() -> new ParameterizedMessage("Failed to write shard {}. Exception {}", indexShard, e));
     * Gets active shard routing from memory if available, else calculates and put it in memory.
                assert shard.getTargetRelocatingShard().assignedToNode() : "relocating to unassigned " + shard.getTargetRelocatingShard();
    final List<ShardRouting> assignedShards;
                    shards.add(shardEntry);
    private static List<ShardRouting> collectAttributeShards(AttributesKey key, DiscoveryNodes nodes, ArrayList<ShardRouting> from) {
     * Returns a {@link List} of active shards
    /**
import java.util.HashSet;
        return nodeIds;
            }
}
            List<ShardRouting> orderedInitializingShards = getInitializingShardsByWeight(weightedRouting, nodes, defaultWeight);
        return shards;
     */
     * its random within the active shards, and initializing shards are the last to iterate through.
        public Builder removeShard(ShardRouting shardEntry) {
    public Iterator<ShardRouting> iterator() {
    public ShardIterator onlyNodeSelectorActiveInitializingShardsIt(String nodeAttributes, DiscoveryNodes discoveryNodes) {
    public ShardIterator activeInitializingShardsIt(int seed) {
     * @param weightedRouting entity
        public final List<ShardRouting> withoutSameAttribute;
        return Collections.unmodifiableList(to);
    public List<ShardRouting> replicaShards() {
        for (ShardRouting shardRouting : shuffler.shuffle(activeShards)) {
    /**
            if (localAttributeValue != null) {
        }
        WeightedRouting weightedRouting,
            final String message = String.format(
            }
     * Returns an iterator over active and initializing shards, shards are ordered by weighted
                shardId()
    }
            if (shard.active()) {
     * If we can come up with a better variable name, it would be nice...
            populateInitializingShardWeightsMap(weightedRouting, nodes, defaultWeight);
            this.shardRoutingWithoutWeight = Collections.unmodifiableList(shardRoutingWithoutWeight);
        ArrayList<ShardRouting> ordered = new ArrayList<>(activeShards.size() + allInitializingShards.size());
        }
    }
        // adjust the non-winner nodes' stats so they will get a chance to receive queries
     * @return an iterator over active and initializing shards, ordered by weighted round-robin
    /**
        if (shardRoutings == null) {
                // in the unavailableInSyncShards set.
                    // Increase the number of searches for the "winning" node by one.
            );
     * @return a {@link List} of shards
        // Add the primary shard
    public ShardId getShardId() {
     */
        private final List<ShardRouting> shardRoutingsWithWeight;
        Collections.sort(sortedShards, new NodeRankComparator(nodeRanks));
                // these shards on the same node
        return this.assignedShards;
    private AttributesRoutings getInitializingAttribute(AttributesKey key, DiscoveryNodes nodes) {
    public List<ShardRouting> shardsWithState(ShardRoutingState state) {
        }
                activeShards.add(shard);
                    adjustStats(collector, nodeStats, minNodeId, maybeMinStats.get());
    private volatile Map<AttributesKey, AttributesRoutings> initializingShardsByAttributes = emptyMap();
        }
            Double shard1rank = nodeRanks.get(s1.currentNodeId());
    }
        for (ShardRouting replica : shuffler.shuffle(replicas)) {
    /**
        int seed = shuffler.nextSeed();
        }
     */
     *
        this.allAllocationIds = Collections.unmodifiableSet(allAllocationIds);
        if (collector == null || nodeSearchCounts == null || shards.size() <= 1) {
                } else if (replica.initializing()) {
        }
     */
                ordered.add(shardRouting);
        final Map<String, Optional<ResponseCollectorService.ComputedNodeStats>> nodeStats,
     * Returns the number of this shards instances.
        WeightedRoutingKey key = new WeightedRoutingKey(weightedRouting);
        return new PlainShardIterator(shardId, ordered);
        List<ShardRouting> ordered = new ArrayList<>();
import java.util.stream.Collectors;
        ArrayList<ShardRouting> sortedShards = new ArrayList<>(shards);
        public int compare(ShardRouting s1, ShardRouting s2) {
        ordered.addAll(shuffler.shuffle(initializingRoutings.withoutSameAttribute, seed));
    private List<ShardRouting> getActiveShardsByWeight(WeightedRouting weightedRouting, DiscoveryNodes nodes, double defaultWeight) {
                        }
                    collector.addNodeStatistics(nodeId, updatedQueue, updatedResponse, updatedService);
                    .put(key, shardRoutings)
    }
        if (sortedShards.size() > 1) {
        @Override
 * Licensed to Elasticsearch under one or more contributor
    public ShardIterator activeInitializingShardsWeightedIt(
    /**
    public ShardIterator shardsIt(int seed) {
     */
 * referred to as replicas of a shard. Given that, this class encapsulates all
        // any replicas to query anyway)
     * Returns an ordered iterator on the active primary shard, followed by replica shards.
                    }
    }
    }
        List<ShardRouting> rankedInitializingShards = rankShardsAndUpdateStats(allInitializingShards, collector, nodeSearchCounts);
     * Returns an iterator over active and initializing shards. Making sure though that
        DiscoveryNodes nodes,
public class IndexShardRoutingTable extends AbstractDiffable<IndexShardRoutingTable> implements Iterable<ShardRouting> {
        @Override
    private List<WeightedRoundRobin.Entity<ShardRouting>> calculateShardWeight(
     * Returns an iterator over active and initializing shards, ordered by the adaptive replica
    }
    public static Diff<IndexShardRoutingTable> readDiffFrom(StreamInput in) throws IOException {
        final ResponseCollectorService collector,
     */
        NodeRankComparator(Map<String, Double> nodeRanks) {
                    return 0;
    /**
 */
                if (shard.assignedToNode()) {
        }
                ordered.add(shardRouting);
    public List<ShardRouting> activeShards() {
        // If the primaries are unassigned, return an empty list (there aren't
        }
        return filterAndOrderShards(replica -> true);
        return shardRoutings;
     */
    }
        List<WeightedRoundRobin.Entity<ShardRouting>> shardsWithWeights = new ArrayList<>();
 * KIND, either express or implied.  See the License for the
     * *
        ArrayList<ShardRouting> preferred = new ArrayList<>(activeShards.size() + allInitializingShards.size());
        WeightedRoutingKey key = new WeightedRoutingKey(weightedRouting);
                    // place nulls before non-null values
        AttributesRoutings(List<ShardRouting> withSameAttribute, List<ShardRouting> withoutSameAttribute) {
    }
     *
        public boolean equals(Object obj) {
     * to order shards by weight.
        @Override
     * <p>
                String attVal = node.getAttributes().get(weightedRouting.attributeName());
        List<ShardRouting> weightedRoutings = shardsOrderedByWeight(allInitializingShards, weightedRouting, nodes, defaultWeight);
    }
        synchronized (shardsByWeightMutex) {
    /**
     *
            // don't allow more than one shard copy with same id to be allocated to same node
                allShardsStarted = false;
            throw new IllegalArgumentException(message);
        if (state == ShardRoutingState.INITIALIZING) {
        DiscoveryNodes nodes,
import org.opensearch.cluster.node.DiscoveryNode;
        List<ShardRouting> shards = new ArrayList<>();
     * OpenSearch, however, we do not have that sort of broadcast-to-all behavior. In order to prevent a node that gets a high score and
        ordered.addAll(shuffler.shuffle(initializingRoutings.withSameAttribute, seed));
                final Optional<ResponseCollectorService.ComputedNodeStats> maybeStats = entry.getValue();
    }
        for (final String attribute : key.attributes) {
    public static IndexShardRoutingTable readFrom(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
    public boolean allShardsStarted() {
        }
        return sortedShards;
            return attributes.hashCode();
        WeightedRoutingKey key = new WeightedRoutingKey(weightedRouting);
        return shardRoutings;
            Double shard2rank = nodeRanks.get(s2.currentNodeId());
                allInitializingShards.add(shard);
        this.shards = Collections.unmodifiableList(shards);
            populateInitializingShardWeightsMap(weightedRouting, nodes, defaultWeight);
        ordered.addAll(shufflerForWeightedRouting.shuffle(orderedActiveShards, seed));
     * Cassandra sends occasional requests to all copies of the data, so their stats will be updated during that broadcast phase. In
     */
import java.util.Set;
            ordered.add(shardRouting);
        return new PlainShardIterator(shardId, ordered);
        }
        return replicas.stream().filter(r -> r.isSearchOnly() == false).collect(Collectors.toList());
    }
     *
            }
                ordered.set(ordered.size() - 1, ordered.get(0));
     *
                // If weight for a zone is not defined, considering it as 1 by default
     * Adjust the for all other nodes' collected stats. In the original ranking paper there is no need to adjust other nodes' stats because
        return nodeRanks;
    private List<ShardRouting> getActiveShardsWithoutWeight(WeightedRouting weightedRouting, DiscoveryNodes nodes, double defaultWeight) {
        for (int i = 0; i < numShards; i++) {
                } else {
    }
    ) {
        DiscoveryNodes nodes,
        return orderedShardRouting;
 * You may obtain a copy of the License at
            // is primary assigned
                    }
                    }
        return orderedListWithDistinctShards;
    public static class WeightedShardRoutings {
    }
                    // captured once for each query in TransportSearchAction
        }
                if (shard2rank != null) {
        for (ShardRouting shard : shards) {
     */
            }
            if (o == null || getClass() != o.getClass()) return false;
        }
    public ShardRouting primaryShard() {
            if (shard.primary()) {
    static class AttributesKey {
            if (shard1rank != null) {
        double defaultWeight
    }
    static class AttributesRoutings {
        // shard copies in case of request failure from other attribute values.
                    }
            if (filter.test(replica)) {
                    return -1;
        List<ShardRouting> shards = new ArrayList<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return null;
    }
     * @return a {@link List} of shards
        @Nullable Integer seed
        @Override
        List<ShardRouting> orderedShardRouting = new ArrayList<>(activeShards.size());
     */
        List<ShardRouting> replicas = new ArrayList<>();
            synchronized (shardsByAttributeMutex) {
        public final List<ShardRouting> withSameAttribute;
        }
    final List<ShardRouting> shards;
    /**
        // If the primaries are unassigned, return an empty list (there aren't
 * Each OpenSearch index consists of multiple shards, each shard encapsulates
    ) {
        List<WeightedRoundRobin.Entity<ShardRouting>> shardsOrderedbyWeight = weightedRoundRobin.orderEntities();
            return new PlainShardIterator(shardId, Collections.emptyList());
@PublicApi(since = "1.0.0")
        preferred.addAll(notPreferred);
            return builder.build();
     * Returns the shards id
        public int hashCode() {
     */
    private static class NodeRankComparator implements Comparator<ShardRouting> {
        }
                for (Iterator<ShardRouting> iterator = from.iterator(); iterator.hasNext();) {
     */
     *
 * the Apache License, Version 2.0 (the "License"); you may
        private final WeightedRouting weightedRouting;
                }
            }
            return allInitializingShards;
import java.util.function.Predicate;
            if (nodeId.equals(shardRouting.currentNodeId())) {
                });
     * Returns a {@link List} of shards
            .filter(shard -> !weightedRoutings.contains(shard))
                    if (nodes.add(shard.currentNodeId()) == false) {
    ) {
                    } else if (localAttributeValue.equals(discoveryNode.getAttributes().get(attribute))) {
    @Nullable
                String.join(",", nodeAttributes),
            this.weightedRouting = weightedRouting;
            out.writeVInt(indexShard.shards.size());
        }
    public Set<String> getAllAllocationIds() {
    /**
            if (nodeId.equals(shardRouting.currentNodeId())) {
        return new PlainShardIterator(shardId, preferred);
        WeightedRoutingKey key = new WeightedRoutingKey(weightedRouting);
        }
            return this;
    }
        for (ShardRouting shardEntry : replicas) {
        ArrayList<ShardRouting> ordered = new ArrayList<>(activeRoutings.totalSize + initializingRoutings.totalSize);
            if (shardRouting.allocationId().getId().equals(allocationId)) {
            return new PlainShardIterator(shardId, Collections.singletonList(primary));
        }
                        iterator.remove(); // node is not present anymore - ignore shard
        // Retrieve which nodes we can potentially send the query to
            activeShardsByWeight = new MapBuilder().put(key, new WeightedShardRoutings(weightedRoutings, nonWeightedRoutings))
        }
        this.shuffler = new RotationShardShuffler(Randomness.get().nextInt());
                nodeRanks.put(nodeId, stats.rank(nodeSearchCounts.getOrDefault(nodeId, 1L)));
        return shards.size();
     * (or missing) rank, and initializing shards are the last to iterate through.
    @Override
            Set<String> nodes = new HashSet<>();
                ordered.add(shardRouting);
    public ShardRouting getByAllocationId(String allocationId) {
    public ShardIterator searchReplicaActiveInitializingShardIt() {
        List<ShardRouting> shards,
        return initializingShardsByWeight.get(key).getShardRoutingWithoutWeight();
    }
    }
    private volatile Map<WeightedRoutingKey, WeightedShardRoutings> activeShardsByWeight = emptyMap();
                return 0;
    }
        private final Map<String, Double> nodeRanks;
    }
        if (!allInitializingShards.isEmpty()) {
    }
                preferred.add(shardRouting);
        return primary;
        }
        List<ShardRouting> shards = new ArrayList<>();
        }
     *
                ordered.add(replica);
        if (allInitializingShards.isEmpty()) {
        private final List<ShardRouting> shardRoutingWithoutWeight;
                    allInitializingShards.add(shard.getTargetRelocatingShard());
    @Override
    /**
import static java.util.Collections.emptyMap;
            return obj instanceof AttributesKey && attributes.equals(((AttributesKey) obj).attributes);
                final String nodeId = entry.getKey();
        WeightedRouting weightedRouting,
            this.shardId = shardId;
        public Builder(IndexShardRoutingTable indexShard) {
            .collect(Collectors.toUnmodifiableList());
            return new PlainShardIterator(
    }
 * this work for additional information regarding copyright
        if (!allInitializingShards.isEmpty()) {
    /**
        }
    }
     * Returns a {@link List} of the writer replicas (primary eligible) shards in the RoutingTable
 * compatible open source license.
    public ShardIterator activeInitializingShardsRandomIt() {
            maybeStats.ifPresent(stats -> {
     */
        }
            }
        for (ShardRouting shardRouting : shuffler.shuffle(allInitializingShards, seed)) {
                .immutableMap();
        final ResponseCollectorService.ComputedNodeStats minStats
            indexShard.shardId().getIndex().writeTo(out);
            ordered.addAll(activeInitializingShardsWithoutWeights(weightedRouting, nodes, defaultWeight));
                    return 1;
import org.opensearch.common.collect.MapBuilder;
     */
    final ShardShuffler shufflerForWeightedRouting;
        return IndexShardRoutingTable.Builder.readFrom(in);
     */
    }
     * Returns shards based on nodeAttributes given  such as node name , node attribute, node IP
        ordered.addAll(rankedInitializingShards);
                    final long updatedService = (long) (minStats.serviceTime + stats.serviceTime) / 2;
        Builder.writeToThin(this, out);
                    ShardRouting fromShard = iterator.next();
            for (ShardRouting shard : shards) {
 * under the License.
            }
            int size = in.readVInt();
            }
     */
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
            seed = shufflerForWeightedRouting.nextSeed();
        DiscoveryNodes nodes,
    ) {
     * round-robin scheduling policy.
        if (noPrimariesActive()) {
                return shardRouting;
        }
    /**
    }
                // the allAllocationId set. Cluster Manager will filter out search replica allocationIds in
        return count;
                    // it only affects the captured node search counts, which is
import java.util.Comparator;
        }
        if (minNodeId != null) {
            out.writeVInt(indexShard.shardId.id());
        final Set<String> nodeIds,
        ArrayList<ShardRouting> ordered = new ArrayList<>(activeShards.size() + allInitializingShards.size());
    /**
     */
        if (shardsOrderedbyWeight != null) {
import java.util.concurrent.atomic.AtomicInteger;
        // Add initializing shards last
    }
                .sorted(Comparator.comparing(o -> o.allocationId().getId()))
        }
    }
    }
        LinkedList<ShardRouting> ordered = new LinkedList<>();
import org.opensearch.core.common.io.stream.StreamInput;
     * @param isFailOpenEnabled if true, shards search requests in case of failures are tried on shard copies present
     *
        final Map<String, Double> nodeRanks = rankNodes(nodeStats, nodeSearchCounts);
    final Set<String> allAllocationIds;
    public ShardIterator preferNodeActiveInitializingShardsIt(Set<String> nodeIds) {
        public static void writeToThin(IndexShardRoutingTable indexShard, StreamOutput out) throws IOException {
    }
            }
     */
        List<ShardRouting> orderedListWithDistinctShards;
    public List<ShardRouting> getActiveShards() {
import java.util.Optional;
import org.apache.logging.log4j.message.ParameterizedMessage;
        WeightedRouting weightedRouting,
        if (initializingShardsByWeight.get(key) == null) {
import java.util.Collections;
     * Returns an iterator only on the primary shard.
     * then never gets any more requests, we must ensure it eventually returns to a more normal score and can be a candidate for serving
            if (!weightedRouting.equals(key.weightedRouting)) return false;
    public int hashCode() {
/*
        WeightedRoutingKey key = new WeightedRoutingKey(weightedRouting);
        @Override
        if (activeShardsByWeight.get(key) == null) {
            for (Map.Entry<String, Optional<ResponseCollectorService.ComputedNodeStats>> entry : nodeStats.entrySet()) {
            this.shardRoutingsWithWeight = Collections.unmodifiableList(shardRoutingsWithWeight);
            return readFromThin(in, index);
                    final DiscoveryNode discoveryNode = nodes.get(fromShard.currentNodeId());
            }
                }
    ) {
        }
    }
        }
    }
    }
        }
                        assignedShardCount.getAndIncrement();
    public ShardIterator primaryShardIt() {
        public int hashCode() {
     * @return a {@link List} of shards
        AttributesRoutings initializingRoutings = getInitializingAttribute(key, nodes);
    @Override
    /**
     * @opensearch.internal
        if (initializingShardsByWeight.get(key) == null) {
                    if (shard.relocating()) {
 * replicas (instances) for a single index shard.
        this.replicas = Collections.unmodifiableList(replicas);
    public int size() {
     * Returns an iterator on replica shards.
        int result = shardId.hashCode();
            Builder builder = new Builder(shardId);
        double defaultWeight
        double defaultWeight
    }
                    if (discoveryNode == null) {
            .collect(Collectors.toUnmodifiableList());
            if (selectedNodes.contains(shardRouting.currentNodeId())) {
        ordered.addAll(rankedActiveShards);
    /**
            } else {
        // fill it in a randomized fashion with the active replicas
                    assignedShards.add(shard.getTargetRelocatingShard());
            final String localAttributeValue = nodes.getLocalNode().getAttributes().get(attribute);
    @PublicApi(since = "2.14.0")
        ordered.addAll(shuffler.shuffle(activeRoutings.withSameAttribute, seed));
    public List<ShardRouting> assignedShards() {
        if (primary != null) {
     */
import java.util.List;
        return result;
            this.shardId = indexShard.shardId;
    /**
            if (shardEntry.state() == state) {
            }
     *
    /**
        ordered.add(primary);
import java.util.LinkedList;
            Optional<ResponseCollectorService.ComputedNodeStats> maybeStats = entry.getValue();
import java.util.ArrayList;
                    final long updatedResponse = (long) (minStats.responseTime + stats.responseTime) / 2;
        return this.shards;
        }
    private static void adjustStats(
    /**
     */
            }
        }
    public ShardIterator shardsRandomIt() {
            if (selectedNodes.contains(shardRouting.currentNodeId())) {
     * Builder of an index shard routing table.
    }
        return replicas.stream().filter(ShardRouting::isSearchOnly).collect(Collectors.toList());
        final List<String> attributes;
        public Builder addShard(ShardRouting shardEntry) {
        }
        for (ShardRouting shardEntry : this) {
                allAllocationIds.add(shard.getTargetRelocatingShard().allocationId().getId());
                        shardRouting.writeToThin(out);
                    // place non-nulls after null values
     * The initializing list, including ones that are initializing on a target node because of relocation.
        }
    }
    private List<ShardRouting> activeInitializingShardsWithoutWeights(
        if (allInitializingShards.isEmpty()) {
            ordered.addAll(allInitializingShards);
        WeightedRouting weightedRouting,
        }
    }
        final ResponseCollectorService collector,
        return new PlainShardIterator(shardId, ordered);
        return this.activeShards;
    }
        List<ShardRouting> nonWeightedRoutings = activeShards.stream()
        ArrayList<ShardRouting> ordered = new ArrayList<>(activeShards.size() + allInitializingShards.size());
        // Retrieve all the nodes the shards exist on
        for (ShardRouting shardRouting : shuffler.shuffle(activeShards, seed)) {
    }
            initializingShardsByWeight = new MapBuilder().put(key, new WeightedShardRoutings(weightedRoutings, nonWeightedRoutings))
                initializingShardsByAttributes = MapBuilder.newMapBuilder(initializingShardsByAttributes)
        int seed = shuffler.nextSeed();
 * a disjoint set of the index data and each shard has one or more instances
                // create the target initializing shard routing on the node the shard is relocating to
            }
    private static final Logger logger = LogManager.getLogger(IndexShardRoutingTable.class);
                allAllocationIds.add(shard.allocationId().getId());
        }
    }
    public ShardIterator preferAttributesActiveInitializingShardsIt(List<String> attributes, DiscoveryNodes nodes) {
            ShardRouting primary = indexShard.primaryShard();
        orderedListWithDistinctShards = ordered.stream().distinct().collect(Collectors.toList());
                    .immutableMap();
            }
    /**
        // sort all shards based on the shard rank
 * ownership. Elasticsearch licenses this file to you under
     * Returns a {@link List} of shards that match the provided {@link Predicate}
    }
            sb.append(shards.get(i).shortSummary());
    }
    // Shuffler for weighted round-robin shard routing. This uses rotation to permute shards.
        return onlyNodeSelectorActiveInitializingShardsIt(new String[] { nodeAttributes }, discoveryNodes);
    /**
            assert distinctNodes(shards) : "more than one shard with same id assigned to same node (shards: " + shards + ")";
                        iterator.remove();
    }
    public int getSize() {
                if (nodeId.equals(minNodeId) == false && maybeStats.isPresent()) {
        ArrayList<ShardRouting> ordered = new ArrayList<>(activeShards.size() + allInitializingShards.size());
     * Returns a {@link List} of assigned shards, including relocation targets
     * Returns a {@link List} of active shards
                count++;
                assert shard.assignedToNode() : "relocating from unassigned " + shard;
        return size();
    private static Map<String, Double> rankNodes(
    ) {
        return sb.toString();
        }
     * Returns the number of this shards instances.
        if (!allInitializingShards.isEmpty()) {
                if (replica.active()) {
     * Holder class for shard routing(s) which are classified and stored based on their weights.
        }
                    : "Search replicas should not be part of the allAllocationId set";
 */
        }
        }
    public ShardIterator primaryFirstActiveInitializingShardsIt() {
    }
        return allAllocationIds;
    /**
                sb.append(", ");
        final int numShards = shards.size();
     * Returns a {@link List} of the search only shards in the RoutingTable
            if (shard.relocating()) {
        for (ShardRouting shard : shards) {
        }
    @PublicApi(since = "2.4.0")
package org.opensearch.cluster.routing;
import org.opensearch.cluster.Diff;
 * The OpenSearch Contributors require contributions made to
        // append shards for attribute value with weight zero, so that shard search requests can be tried on
                // This ensures the primaries do not validate these ids exist in tracking nor are included
    }
        }
    public ShardId shardId() {
    }
     * *
 *
        return filterAndOrderShards(ShardRouting::isSearchOnly);
            for (int i = 0; i < size; i++) {
        AttributesKey key = new AttributesKey(attributes);
     * requests.
                    ordered.addLast(replica);
                // switch, its the matching node id
    private AttributesRoutings getActiveAttribute(AttributesKey key, DiscoveryNodes nodes) {
    }
                final String nodeId = entry.getKey();
        List<ShardRouting> orderedActiveShards = getActiveShardsByWeight(weightedRouting, nodes, defaultWeight);
        List<ShardRouting> nonWeightedRoutings = allInitializingShards.stream()
            shards.add(shardEntry);
 * software distributed under the License is distributed on an
            }
    final List<ShardRouting> activeShards;
    ) {
     */
        WeightedRouting weightedRouting,
        }
        List<ShardRouting> shards,
     */
        public WeightedShardRoutings(List<ShardRouting> shardRoutingsWithWeight, List<ShardRouting> shardRoutingWithoutWeight) {
        @Nullable ResponseCollectorService collector,
            writeToThin(indexShard, out);
    }
        }
        return activeShardsByWeight.get(key).getShardRoutingsWithWeight();
        if (seed == null) {
    final List<ShardRouting> allInitializingShards;
    ) {
                }
                shardRoutings = new AttributesRoutings(to, Collections.unmodifiableList(from));
            }
        return ordered.stream().distinct().collect(Collectors.toList());
     */
     *
        }
    private List<ShardRouting> getInitializingShardsWithoutWeight(
        for (ShardRouting shardRouting : assignedShards()) {
 * GitHub history for details.
    }
     * @param nodes           discovered nodes in the cluster
        if (!allInitializingShards.isEmpty()) {
        return activeShardsByWeight.get(key).getShardRoutingWithoutWeight();
     * This adjustment takes the "winning" node's statistics and adds the average of those statistics with each non-winning node. Let's say
                ShardRouting shard = new ShardRouting(shardId, in);
    }
            nodeStats.put(nodeId, collector.getNodeStatistics(nodeId));
    public boolean equals(Object o) {
            // Order allocated shards by allocationId
        return new PlainShardIterator(shardId, ordered);
            synchronized (shardsByAttributeMutex) {
    }
    }
            );
        final Set<String> nodeIds = getAllNodeIds(shards);
     * Returns a list containing shard routings ordered using weighted round-robin scheduling.
                // the in-sync set that is sent to primaries, but they are still included in the routing table.
            return new PlainShardIterator(shardId, Collections.emptyList());
        List<ShardRouting> ordered = new ArrayList<>(getActiveShardsWithoutWeight(weightedRouting, nodes, defaultWeight));
                Locale.ROOT,
            out.writeVInt(indexShard.shards.size() - assignedShardCount.get());
                String minNodeId = minShard.currentNodeId();
        for (ShardRouting shardEntry : this) {
                List<ShardRouting> to = collectAttributeShards(key, nodes, from);
        if (this == o) return true;
 * {@link IndexShardRoutingTable} encapsulates all instances of a single shard.
                    ordered.addFirst(replica);
     *
            if (i < numShards - 1) {
            ordered.addAll(orderedInitializingShards);
/*
        final Map<String, Double> nodeRanks = new HashMap<>(nodeStats.size());
    public ShardIterator shardsIt() {
                if (shard2rank != null) {
    public List<ShardRouting> getShards() {
        }
/*
            }
                    } catch (IOException e) {
        ArrayList<ShardRouting> notPreferred = new ArrayList<>(activeShards.size() + allInitializingShards.size());
    }
    /**
            Index index = new Index(in);
     * Returns the shards id
     */
        List<ShardRouting> assignedShards = new ArrayList<>();
import org.opensearch.core.index.shard.ShardId;
            // If the winning shard is not started we are ranking initializing
        this.shardId().getIndex().writeTo(out);
        List<ShardRouting> shards,
            .filter(shard -> !weightedRoutings.contains(shard))
                    // Both nodes do not have stats, they are equal
            preferred.addAll(allInitializingShards);
                if (maybeMinStats.isPresent()) {
                replicas.add(shard);
     * @return a {@link List} of shards
    private volatile Map<WeightedRoutingKey, WeightedShardRoutings> initializingShardsByWeight = emptyMap();
        return readDiffFrom(IndexShardRoutingTable::readFrom, in);
     * non-winning node will have statistics added for a queue size of 14. This is repeated for the response time and service times as well.
                ordered.add(shardRouting);
 * Modifications Copyright OpenSearch Contributors. See
            return new PlainShardIterator(shardId, shuffler.shuffle(activeShards, seed));
    final List<ShardRouting> replicas;
 * not use this file except in compliance with the License.
                        if (nodes.add(shard.relocatingNodeId()) == false) {
        }
        return new PlainShardIterator(shardId, ordered);
            }
                List<ShardRouting> to = collectAttributeShards(key, nodes, from);
    private ShardIterator filterAndOrderShards(Predicate<ShardRouting> filter) {
    public Map<WeightedRoutingKey, WeightedShardRoutings> getActiveShardsByWeight() {
     */
            ShardId shardId = new ShardId(index, iShardId);
        return shardId;
        return allShardsStarted;
        double defaultWeight
        return initializingShardsByWeight.get(key).getShardRoutingsWithWeight();
    }
        for (String nodeId : nodeIds) {
            out.writeBoolean(primary != null && primary.allocationId() != null);
     * @opensearch.api
            this.attributes = attributes;
        this.shufflerForWeightedRouting = new RotationShardShuffler(Randomness.get().nextInt());
                activeShardsByAttributes = MapBuilder.newMapBuilder(activeShardsByAttributes).put(key, shardRoutings).immutableMap();
        }
                        throw new RuntimeException("Failed to write IndexShardRoutingTable", e);
            }
    private static Set<String> getAllNodeIds(final List<ShardRouting> shards) {
        return shards.iterator();
        return activeShardsByWeight;
        // no need to worry about primary first here..., its temporal
        }
                "no data nodes with %s [%s] found for shard: %s",
    @Override
        double defaultWeight,
     * Key for WeightedRouting Shard Iterator
        // fill it in a randomized fashion
            if (predicate.test(shardEntry)) {
            if (shard.assignedToNode()) {
    /**
    public List<ShardRouting> shardsMatchingPredicate(Predicate<ShardRouting> predicate) {
        ordered.addAll(shuffler.shuffle(activeShards, seed));
    ) {
        if (ordered.isEmpty()) {
import org.opensearch.cluster.AbstractDiffable;
    public ShardIterator activeInitializingShardsRankedIt(
        List<ShardRouting> ordered = activeInitializingShardsWithWeights(weightedRouting, nodes, defaultWeight, seed);
            if (shard.initializing()) {
        @Nullable Map<String, Long> nodeSearchCounts
            this.shards = new ArrayList<>(indexShard.shards);
        return shards;
            for (WeightedRoundRobin.Entity<ShardRouting> shardRouting : shardsOrderedbyWeight) {
     */
     * @return id of the shard
            populateActiveShardWeightsMap(weightedRouting, nodes, defaultWeight);
     *
        for (ShardRouting shardRouting : shuffler.shuffle(activeShards)) {
    /**
        }
        for (ShardRouting shardRouting : shuffler.shuffle(activeShards, seed)) {
        public List<ShardRouting> getShardRoutingWithoutWeight() {
        return new PlainShardIterator(shardId, ordered);
import java.util.HashMap;
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
            shards.remove(shardEntry);
        return shards();
        int count = 0;
    }
            WeightedRoutingKey key = (WeightedRoutingKey) o;
                assert shard.allocationId() == null || allAllocationIds.contains(shard.allocationId().getId()) == false
                    final ResponseCollectorService.ComputedNodeStats stats = maybeStats.get();
        if (isFailOpenEnabled) {
        synchronized (shardsByWeightMutex) {
        return preferAttributesActiveInitializingShardsIt(attributes, nodes, shuffler.nextSeed());
        List<ShardRouting> activeShards = new ArrayList<>();
    }
        DiscoveryNodes nodes,
                }
    /**
                    try {
        boolean allShardsStarted = true;
    private final Object shardsByWeightMutex = new Object();
        public static IndexShardRoutingTable readFromThin(StreamInput in, Index index) throws IOException {
        this.allInitializingShards = Collections.unmodifiableList(allInitializingShards);
        }
     *                          in node attribute value with weight zero
            if (s1.currentNodeId().equals(s2.currentNodeId())) {
            return result;
        IndexShardRoutingTable that = (IndexShardRoutingTable) o;
        sb.append("IndexShardRoutingTable(").append(shardId()).append("){");
        }
     * Returns a list containing shard routing and associated weight. This function iterates through all the shards and
     * Returns an iterator on active and initializing shards residing on the provided nodeId.
    }
 *
        this.shardId = shardId;
        boolean isFailOpenEnabled,
                // mark search only shards as initializing or assigned, but do not add to
            for (ShardRoutingState state : states) {
            int result = weightedRouting.hashCode();
    /**
        }
 *
        for (ShardRouting replica : shuffler.shuffle(replicas)) {
                }
            if (shard.isSearchOnly()) {
                ordered.set(0, shardRouting);
                continue;
    private List<ShardRouting> getInitializingShardsByWeight(WeightedRouting weightedRouting, DiscoveryNodes nodes, double defaultWeight) {
                builder.addShard(shard);
                    final int updatedQueue = (minStats.queueSize + stats.queueSize) / 2;
                }
            });
        WeightedRouting weightedRouting,
            return true;
        AttributesRoutings activeRoutings = getActiveAttribute(key, nodes);
 * specific language governing permissions and limitations
     *
 * this file be licensed under the Apache-2.0 license or a
import org.apache.logging.log4j.Logger;
        sb.append("}");
    }
            if (shard.state() != ShardRoutingState.STARTED) {
     * @param predicate {@link Predicate} to apply
            return this;
        }
     * Returns an iterator only on the active primary shard.
        static boolean distinctNodes(List<ShardRouting> shards) {
            nodeIds.add(shard.currentNodeId());
    }
    }
        if (shardRoutings == null) {
        }
        for (ShardRouting shardRouting : shuffler.shuffle(allInitializingShards, seed)) {
    public ShardIterator onlyNodeSelectorActiveInitializingShardsIt(String[] nodeAttributes, DiscoveryNodes discoveryNodes) {
            } else {
        return nodeStats;
            }
    public ShardIterator preferAttributesActiveInitializingShardsIt(List<String> attributes, DiscoveryNodes nodes, int seed) {
        }
     * Returns true if no primaries are active or initializing for this shard
            }
            out.writeVInt(indexShard.shards.size());
            }
        final ArrayList<ShardRouting> to = new ArrayList<>();
        final Set<String> nodeIds = new HashSet<>();
        if (noPrimariesActive()) {
        return activeShards();
            }
            this.nodeRanks = nodeRanks;
        final Map<String, Optional<ResponseCollectorService.ComputedNodeStats>> nodeStats,
        }
                Double weight = weightedRouting.weights().getOrDefault(attVal, defaultWeight);
        final int seed = shuffler.nextSeed();
        for (Map.Entry<String, Optional<ResponseCollectorService.ComputedNodeStats>> entry : nodeStats.entrySet()) {
     * selection formula. Making sure though that its random within the active shards of the same
                shardsWithWeights.add(new WeightedRoundRobin.Entity<>(weight, shard));
        // any replicas to query anyway)
                orderedShardRouting.add(shardRouting.getTarget());
    public static class Builder {
        if (!allInitializingShards.isEmpty()) {
                } else {
        final String minNodeId,
        public boolean equals(Object o) {
            ordered.addAll(allInitializingShards);
                shardId,
    private void populateInitializingShardWeightsMap(WeightedRouting weightedRouting, DiscoveryNodes nodes, double defaultWeight) {
            this.withoutSameAttribute = withoutSameAttribute;
     */
    }
 * license agreements. See the NOTICE file distributed with
        Set<String> selectedNodes = Sets.newHashSet(discoveryNodes.resolveNodes(nodeAttributes));
    public List<ShardRouting> shards() {
 * @opensearch.api
            if (minShard.started()) {
                    return shard1rank.compareTo(shard2rank);
    public static List<ShardRouting> rankShardsAndUpdateStats(
                primary = shard;
                shards.add(shardEntry);
    @Override
    }
                if (shardEntry.state() == state) {
        if (noPrimariesActive()) {
        }
    public List<ShardRouting> searchOnlyReplicas() {
        for (ShardRouting shardEntry : this) {
        ordered.addAll(shuffler.shuffle(activeRoutings.withoutSameAttribute, seed));
        int seed
        }
    }
        List<ShardRouting> allInitializingShards = new ArrayList<>();
    public ShardIterator primaryActiveInitializingShardIt() {
 */
        );
        AttributesRoutings shardRoutings = initializingShardsByAttributes.get(key);
        final Map<String, Optional<ResponseCollectorService.ComputedNodeStats>> nodeStats = getNodeStats(nodeIds, collector);
                shardRoutings = new AttributesRoutings(to, Collections.unmodifiableList(from));
     * the winning node had a queue size of 10 and a non-winning node had a queue of 18. The average queue size is (10 + 18) / 2 = 14 so the
                if (shard.assignedToNode()) {
        public List<ShardRouting> getShardRoutingsWithWeight() {
        return primaryShardIt();
import org.opensearch.core.index.Index;
        ArrayList<ShardRouting> ordered = new ArrayList<>(activeShards.size() + allInitializingShards.size());
        DiscoveryNodes nodes,
    public List<ShardRouting> getAllInitializingShards() {
        ArrayList<ShardRouting> ordered = new ArrayList<>(activeShards.size() + allInitializingShards.size());
                .filter(shardRouting -> shardRouting.allocationId() != null)
     */
     */
            calculateShardWeight(shards, weightedRouting, nodes, defaultWeight)
    }
    }
    public int shardsMatchingPredicateCount(Predicate<ShardRouting> predicate) {
        double defaultWeight,
        AttributesKey(List<String> attributes) {
        return new PlainShardIterator(shardId, ordered);
        }
                            return false;
            if (replica.active()) {
     * Returns a {@link List} of all initializing shards, including target shards of relocations
import java.util.Map;
        public final int totalSize;
        this.activeShards = Collections.unmodifiableList(activeShards);
     *
                assignedShards.add(shard.getTargetRelocatingShard());
     * Returns <code>true</code> iff all shards in the routing table are started otherwise <code>false</code>
        if (o == null || getClass() != o.getClass()) return false;
                allInitializingShards.add(shard.getTargetRelocatingShard());
    public void writeTo(StreamOutput out) throws IOException {
    private final Object shardsByAttributeMutex = new Object();
            this.shards = new ArrayList<>();
        public Builder(ShardId shardId) {
                        to.add(fromShard);
     */
    /**
            if (shardRouting.primary()) {
                entry.writeToThin(out);
    public String toString() {
    }
        return this.primary != null && !this.primary.active() && !this.primary.initializing();
            return shardRoutingsWithWeight;
            }
        return shardsWithWeights;
        }
    IndexShardRoutingTable(ShardId shardId, List<ShardRouting> shards) {
    /**
        return new PlainShardIterator(shardId, shuffler.shuffle(shards));
        return activeInitializingShardsIt(shuffler.nextSeed());
        return new PlainShardIterator(shardId, shuffler.shuffle(shards, seed));
     *
import org.apache.logging.log4j.LogManager;
                if (shard.relocating()) {
     */
            populateActiveShardWeightsMap(weightedRouting, nodes, defaultWeight);
        public static void writeTo(IndexShardRoutingTable indexShard, StreamOutput out) throws IOException {
        }
     */
        }
    public List<ShardRouting> writerReplicas() {
    private List<ShardRouting> shardsOrderedByWeight(
            } else {
        AttributesRoutings shardRoutings = activeShardsByAttributes.get(key);
        }
        return new PlainShardIterator(shardId, Collections.emptyList());
     * Returns an ordered iterator on active replica shards, followed by the primary shard.
            indexShard.shards.stream()
        return shards.size() == that.shards.size() && shards.containsAll(that.shards) && that.shards.containsAll(shards);
    ) {
                nodeAttributes.length == 1 ? "criteria" : "criterion",
                ArrayList<ShardRouting> from = new ArrayList<>(allInitializingShards);
        return new PlainShardIterator(shardId, shards);
            return new PlainShardIterator(shardId, Collections.emptyList());
    private static Map<String, Optional<ResponseCollectorService.ComputedNodeStats>> getNodeStats(
     */
        }
                .forEach(shardRouting -> {
