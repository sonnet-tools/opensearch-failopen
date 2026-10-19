    /**
import java.util.Comparator;
            }  
    public ShardIterator preferAttributesActiveInitializingShardsIt(List<String> attributes, DiscoveryNodes nodes, int seed) {
        @Override
                .immutableMap();
    }
        return replicas.stream().filter(r -> r.isSearchOnly() == false).collect(Collectors.toList());  
                String.join(",", nodeAttributes),
        return orderedListWithDistinctShards;
     * @return a {@link List} of shards  
 */
    private List<ShardRouting> getActiveShardsByWeight(WeightedRouting weightedRouting, DiscoveryNodes nodes, double defaultWeight) {
        List<ShardRouting> shards = new ArrayList<>();
import org.opensearch.common.annotation.PublicApi;
    @Nullable
        this.shuffler = new RotationShardShuffler(Randomness.get().nextInt());
        }
        if (initializingShardsByWeight.get(key) == null) {
        return shardId;
        DiscoveryNodes nodes,
        for (ShardRouting shardRouting : shuffler.shuffle(activeShards)) {
     */
    private final Object shardsByAttributeMutex = new Object();
                // create the target initializing shard routing on the node the shard is relocating to
        }
                if (shard2rank != null) {  
    public int hashCode() {
        }
        return new PlainShardIterator(shardId, ordered);
            return builder.build();
            if (shardRouting.primary()) {
    public static class Builder {  
    public List<ShardRouting> writerReplicas() {
            populateActiveShardWeightsMap(weightedRouting, nodes, defaultWeight);
 * @opensearch.api  
            Builder builder = new Builder(shardId);
        final Map<String, Optional<ResponseCollectorService.ComputedNodeStats>> nodeStats = new HashMap<>(nodeIds.size());
                        shardRouting.writeToThin(out);
        public Builder(ShardId shardId) {
            shards.add(shardEntry);
     * The initializing list, including ones that are initializing on a target node because of relocation.
        return initializingShardsByWeight.get(key).getShardRoutingsWithWeight();
 * specific language governing permissions and limitations
        if (!shardId.equals(that.shardId)) return false;
     * @return id of the shard
        List<ShardRouting> shards = new ArrayList<>();  
        return this.assignedShards;  
        this.allAllocationIds = Collections.unmodifiableSet(allAllocationIds);
    public int size() {
    /**  
        for (ShardRouting shardRouting : shuffler.shuffle(activeShards, seed)) {
 * under the License.  
            assert distinctNodes(shards) : "more than one shard with same id assigned to same node (shards: " + shards + ")";  
        WeightedRouting weightedRouting,  
package org.opensearch.cluster.routing;
        }
        if (!allInitializingShards.isEmpty()) {
        // Retrieve which nodes we can potentially send the query to
            if (i < numShards - 1) {
    private List<ShardRouting> shardsOrderedByWeight(
        }
                    } catch (IOException e) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Collections;  
                    .put(key, shardRoutings)
            }  
                primary = shard;  
            return new PlainShardIterator(shardId, shuffler.shuffle(activeShards, seed));  
import java.util.stream.Collectors;
            }
                        }
     */
    }  
    private static Map<String, Optional<ResponseCollectorService.ComputedNodeStats>> getNodeStats(
        this.shardId = shardId;
            return this;
    private List<ShardRouting> activeInitializingShardsWithWeights(
    }
            .collect(Collectors.toUnmodifiableList());
                ArrayList<ShardRouting> from = new ArrayList<>(allInitializingShards);  
                    final int updatedQueue = (minStats.queueSize + stats.queueSize) / 2;
        }
     * If we can come up with a better variable name, it would be nice...
    public boolean equals(Object o) {
    public ShardRouting getByAllocationId(String allocationId) {  
        final int seed = shuffler.nextSeed();
                "no data nodes with %s [%s] found for shard: %s",  
 * ownership. Elasticsearch licenses this file to you under  
     *
        AttributesRoutings initializingRoutings = getInitializingAttribute(key, nodes);
            ordered.addAll(getInitializingShardsWithoutWeight(weightedRouting, nodes, defaultWeight));  
        return activeShardsByWeight;
        IndexShardRoutingTable that = (IndexShardRoutingTable) o;  
                        to.add(fromShard);
        List<ShardRouting> weightedRoutings = shardsOrderedByWeight(allInitializingShards, weightedRouting, nodes, defaultWeight);
        WeightedRoutingKey key = new WeightedRoutingKey(weightedRouting);
        for (ShardRouting shard : shards) {
/**
                    return shard1rank.compareTo(shard2rank);  
                return shardRouting;  
    }  
import java.util.ArrayList;
        }
        sb.append("IndexShardRoutingTable(").append(shardId()).append("){");  
            if (s1.currentNodeId().equals(s2.currentNodeId())) {
        public WeightedShardRoutings(List<ShardRouting> shardRoutingsWithWeight, List<ShardRouting> shardRoutingWithoutWeight) {
        }
    private volatile Map<WeightedRoutingKey, WeightedShardRoutings> initializingShardsByWeight = emptyMap();
        }
     * OpenSearch, however, we do not have that sort of broadcast-to-all behavior. In order to prevent a node that gets a high score and
    private ShardIterator filterAndOrderShards(Predicate<ShardRouting> filter) {
            }
     */
    }  
        }  
        AttributesRoutings shardRoutings = initializingShardsByAttributes.get(key);  
     * @return a {@link List} of shards  
            }  
        }
 */  
     * Returns a list containing shard routing and associated weight. This function iterates through all the shards and
        public final int totalSize;  
    }
     * @return a {@link List} of shards  
        }
        // Retrieve all the nodes the shards exist on
        if (minNodeId != null) {
        ArrayList<ShardRouting> notPreferred = new ArrayList<>(activeShards.size() + allInitializingShards.size());  
        public Builder removeShard(ShardRouting shardEntry) {
        return new PlainShardIterator(shardId, ordered);
     * selection formula. Making sure though that its random within the active shards of the same
        for (ShardRouting replica : shuffler.shuffle(replicas)) {
    /**
                    ShardRouting fromShard = iterator.next();
        // any replicas to query anyway)  
        List<ShardRouting> rankedActiveShards = rankShardsAndUpdateStats(shuffler.shuffle(activeShards, seed), collector, nodeSearchCounts);
                // If weight for a zone is not defined, considering it as 1 by default
    }
            }
            for (WeightedRoundRobin.Entity<ShardRouting> shardRouting : shardsOrderedbyWeight) {
        this.assignedShards = Collections.unmodifiableList(assignedShards);  
    }  
                    nodeSearchCounts.compute(minNodeId, (id, conns) -> conns == null ? 1 : conns + 1);
     */
    /**
    /**  
        // sort all shards based on the shard rank
        ArrayList<ShardRouting> ordered = new ArrayList<>(activeShards.size() + allInitializingShards.size());  
        if (sortedShards.size() > 1) {
                String attVal = node.getAttributes().get(weightedRouting.attributeName());  
            ordered.addAll(allInitializingShards);  
    }  
            // don't allow more than one shard copy with same id to be allocated to same node
            if (o == null || getClass() != o.getClass()) return false;
            for (Map.Entry<String, Optional<ResponseCollectorService.ComputedNodeStats>> entry : nodeStats.entrySet()) {
                    .immutableMap();
        DiscoveryNodes nodes,
        return this.shards;  
/*  
        @Nullable Integer seed
    final ShardShuffler shuffler;
            sb.append(shards.get(i).shortSummary());  
     * @return id of the shard
            this.withSameAttribute = withSameAttribute;  
                final String nodeId = entry.getKey();  
    /**  
        final Set<String> nodeIds = new HashSet<>();
        List<ShardRouting> shards,  
     */  
            out.writeVInt(indexShard.shardId.id());
    }  
    /**  
     * @param predicate {@link Predicate} to apply
    /**
        for (ShardRouting shardRouting : shuffler.shuffle(activeShards, seed)) {
                    final long updatedResponse = (long) (minStats.responseTime + stats.responseTime) / 2;
     * Returns a {@link List} of shards that match the provided {@link Predicate}  
    public ShardIterator searchReplicaActiveInitializingShardIt() {  
        for (ShardRouting shardEntry : this) {
 * GitHub history for details.
     * Returns the shards id  
    }
     */
    public Iterator<ShardRouting> iterator() {  
            if (selectedNodes.contains(shardRouting.currentNodeId())) {
     * @opensearch.internal
     * Note that this method mutates the nodeSearchCounts map and calls adjustStats which modifies collector state.
        }  
        return allShardsStarted;
    final List<ShardRouting> assignedShards;
        }
            }
import java.io.IOException;
    }
        public List<ShardRouting> getShardRoutingWithoutWeight() {
        List<ShardRouting> nonWeightedRoutings = allInitializingShards.stream()
            }  
                ordered.add(shardRouting);  
    }
        if (!allInitializingShards.isEmpty()) {
     * @return a {@link List} of shards  
    }  
            final String localAttributeValue = nodes.getLocalNode().getAttributes().get(attribute);
        AttributesKey key = new AttributesKey(attributes);  
            this.nodeRanks = nodeRanks;
    }
            if (shard.state() != ShardRoutingState.STARTED) {
        final ResponseCollectorService.ComputedNodeStats minStats
                            return false;
    }
        return new PlainShardIterator(shardId, ordered);
        return activeShardsByWeight.get(key).getShardRoutingsWithWeight();  
        DiscoveryNodes nodes,
        public static void writeTo(IndexShardRoutingTable indexShard, StreamOutput out) throws IOException {
        ordered.addAll(shuffler.shuffle(activeRoutings.withoutSameAttribute, seed));
    public ShardIterator activeInitializingShardsRankedIt(
                allAllocationIds.add(shard.allocationId().getId());
    public ShardIterator shardsRandomIt() {
        }
                Locale.ROOT,
import org.apache.logging.log4j.Logger;
    private List<ShardRouting> activeInitializingShardsWithoutWeights(
        private final WeightedRouting weightedRouting;
        public final List<ShardRouting> withSameAttribute;
     * Returns a {@link List} of active shards
        if (!allInitializingShards.isEmpty()) {
    /**
        }
                    final long updatedService = (long) (minStats.serviceTime + stats.serviceTime) / 2;  
     * Returns an iterator over active and initializing shards, ordered by the adaptive replica  
 */
    }
    ) {
        return shards;  
    /**
    public ShardIterator preferAttributesActiveInitializingShardsIt(List<String> attributes, DiscoveryNodes nodes) {
        return shardRoutings;
                if (shardEntry.state() == state) {
                preferred.add(shardRouting);
            }
/*
            out.writeVInt(indexShard.shards.size());
        AttributesRoutings(List<ShardRouting> withSameAttribute, List<ShardRouting> withoutSameAttribute) {
        double defaultWeight
        return this.replicas;
                if (maybeMinStats.isPresent()) {
        );
        final Map<String, Long> nodeSearchCounts
        }
     */
    }
    }  
    /**
    /**
                        iterator.remove(); // node is not present anymore - ignore shard
        WeightedRouting weightedRouting,  
            return readFromThin(in, index);
     * Gets initializing shard routing from memory if available, else calculates and put it in memory.
        for (String nodeId : nodeIds) {
            }  
    /**  
        final List<String> attributes;  
        public int hashCode() {
        ordered.addAll(shuffler.shuffle(initializingRoutings.withSameAttribute, seed));  
        ArrayList<ShardRouting> sortedShards = new ArrayList<>(shards);  
            return new IndexShardRoutingTable(shardId, Collections.unmodifiableList(new ArrayList<>(shards)));
    }
            out.writeVInt(indexShard.shards.size());  
        }  
        }
        List<ShardRouting> nonWeightedRoutings = activeShards.stream()
    }  
        if (state == ShardRoutingState.INITIALIZING) {
        return new PlainShardIterator(shardId, ordered);
        return new PlainShardIterator(shardId, shuffler.shuffle(shards));
                final String nodeId = entry.getKey();
     * *
    }
        // any replicas to query anyway)
        }  
 * replicas (instances) for a single index shard.
            }
            ordered.addAll(activeInitializingShardsWithoutWeights(weightedRouting, nodes, defaultWeight));
     * @return a {@link List} of shards  
            }
                ordered.set(ordered.size() - 1, ordered.get(0));  
     *
    }  
import org.opensearch.core.index.Index;  
        return result;
    public ShardIterator onlyNodeActiveInitializingShardsIt(String nodeId) {
    /**  
     * Holder class for shard routing(s) which are classified and stored based on their weights.
        for (Map.Entry<String, Optional<ResponseCollectorService.ComputedNodeStats>> entry : nodeStats.entrySet()) {
        synchronized (shardsByWeightMutex) {
    }
            }  
    private static List<ShardRouting> collectAttributeShards(AttributesKey key, DiscoveryNodes nodes, ArrayList<ShardRouting> from) {
            int iShardId = in.readVInt();  
     * then never gets any more requests, we must ensure it eventually returns to a more normal score and can be a candidate for serving  
 * compatible open source license.
    ) {
    }  
    public List<ShardRouting> getShards() {
        ordered.addAll(rankedInitializingShards);
     * requests.
            }  
    }
     * @param nodes           discovered nodes in the cluster
     * to order shards by weight.  
            // Order allocated shards by allocationId  
                    if (shard.relocating()) {
    public ShardId shardId() {
    /**  
            }
            out.writeVInt(indexShard.shards.size() - assignedShardCount.get());
    }
        ordered.addAll(shuffler.shuffle(initializingRoutings.withoutSameAttribute, seed));
                allInitializingShards.add(shard.getTargetRelocatingShard());
        for (ShardRouting shardRouting : shuffler.shuffle(activeShards)) {
     */
                ShardRouting shard = new ShardRouting(shardId, in);  
                assert shard.allocationId() == null || allAllocationIds.contains(shard.allocationId().getId()) == false
    @PublicApi(since = "2.14.0")
     * Adjust the for all other nodes' collected stats. In the original ranking paper there is no need to adjust other nodes' stats because  
            AtomicInteger assignedShardCount = new AtomicInteger();
import org.opensearch.common.Randomness;  
            if (shard.initializing()) {
        return initializingShardsByWeight.get(key).getShardRoutingWithoutWeight();
    ) {  
            );
        // append shards for attribute value with weight zero, so that shard search requests can be tried on
        }
    /**
    public ShardIterator primaryShardIt() {
                count++;
 * Each OpenSearch index consists of multiple shards, each shard encapsulates
            return new PlainShardIterator(shardId, Collections.emptyList());  
    /**
            }
        if (!allInitializingShards.isEmpty()) {
 * KIND, either express or implied.  See the License for the
    }  
        DiscoveryNodes nodes,
        List<ShardRouting> ordered = activeInitializingShardsWithWeights(weightedRouting, nodes, defaultWeight, seed);  
    }
     */  
        for (final String attribute : key.attributes) {
    @PublicApi(since = "2.4.0")  
                ordered.add(shardRouting);
                ordered.set(0, shardRouting);
     *
        ArrayList<ShardRouting> ordered = new ArrayList<>(activeShards.size() + allInitializingShards.size());
            nodeStats.put(nodeId, collector.getNodeStatistics(nodeId));  
     *
        }  
            }
     */
    public List<ShardRouting> shardsWithState(ShardRoutingState state) {
            }  
     */  
    final ShardId shardId;
    public static class WeightedShardRoutings {  
        }  
                    }
        // If the primaries are unassigned, return an empty list (there aren't  
                shards.add(shardEntry);
    private volatile Map<WeightedRoutingKey, WeightedShardRoutings> activeShardsByWeight = emptyMap();
    private List<ShardRouting> getInitializingShardsByWeight(WeightedRouting weightedRouting, DiscoveryNodes nodes, double defaultWeight) {  
        }  
        boolean isFailOpenEnabled,  
        private final Map<String, Double> nodeRanks;
                } else {
        double defaultWeight  
import java.util.Locale;
        }
     * Returns a {@link List} of the writer replicas (primary eligible) shards in the RoutingTable
        if (seed == null) {  
            if (minShard.started()) {
            this.shardRoutingsWithWeight = Collections.unmodifiableList(shardRoutingsWithWeight);
        for (ShardRouting shardRouting : assignedShards()) {
    public int getSize() {
                .sorted(Comparator.comparing(o -> o.allocationId().getId()))
     *
        }
        for (ShardRouting shardRouting : shuffler.shuffle(allInitializingShards, seed)) {  
     *
    public List<ShardRouting> replicaShards() {  
    private static class NodeRankComparator implements Comparator<ShardRouting> {
import java.util.HashMap;
            if (shardRouting.allocationId().getId().equals(allocationId)) {
    public Map<WeightedRoutingKey, WeightedShardRoutings> getActiveShardsByWeight() {  
import org.apache.logging.log4j.LogManager;
            throw new IllegalArgumentException(message);
    }  
     * Returns an iterator over active and initializing shards, shards are ordered by weighted
            return true;
        }
                    }  
            }  
public class IndexShardRoutingTable extends AbstractDiffable<IndexShardRoutingTable> implements Iterable<ShardRouting> {  
     * Returns an iterator on active and initializing shards residing on the provided nodeId.
     */
                assert shard.assignedToNode() : "relocating from unassigned " + shard;
        return activeInitializingShardsIt(shuffler.nextSeed());  
            indexShard.shardId().getIndex().writeTo(out);
        }
     */
import org.opensearch.common.collect.MapBuilder;
        this.primary = primary;  
        }
     */  
        return new PlainShardIterator(shardId, shuffler.shuffle(shards, seed));
        WeightedRouting weightedRouting,
     *
    }
        this.allInitializingShards = Collections.unmodifiableList(allInitializingShards);
        }
        @Nullable ResponseCollectorService collector,
    public ShardIterator primaryFirstActiveInitializingShardsIt() {
     * (or missing) rank, and initializing shards are the last to iterate through.
        return count;
                if (shard.assignedToNode()) {
        return this.allInitializingShards;  
import org.opensearch.core.index.shard.ShardId;
    ) {
        int seed  
    public ShardIterator activeInitializingShardsIt(int seed) {
                builder.addShard(shard);
            Index index = new Index(in);
        return replicas.stream().filter(ShardRouting::isSearchOnly).collect(Collectors.toList());  
import org.opensearch.cluster.AbstractDiffable;
     * non-winning node will have statistics added for a queue size of 14. This is repeated for the response time and service times as well.
}
        if (shardRoutings == null) {
            if (predicate.test(shardEntry)) {  
    private static final Logger logger = LogManager.getLogger(IndexShardRoutingTable.class);
                }
            return result;
            return true;  
            this.shards = new ArrayList<>(indexShard.shards);
    }  
                allAllocationIds.add(shard.getTargetRelocatingShard().allocationId().getId());  
            shards.remove(shardEntry);  
        LinkedList<ShardRouting> ordered = new LinkedList<>();  
        }  
            this.attributes = attributes;  
     */  
                });
    private AttributesRoutings getActiveAttribute(AttributesKey key, DiscoveryNodes nodes) {  
    }
            out.writeBoolean(primary != null && primary.allocationId() != null);
        }
            this.shards = new ArrayList<>();  
            .filter(shard -> !weightedRoutings.contains(shard))  
        public IndexShardRoutingTable build() {
            .collect(Collectors.toUnmodifiableList());
            if (nodeIds.contains(shardRouting.currentNodeId())) {  
                List<ShardRouting> to = collectAttributeShards(key, nodes, from);
 */  
                    final ResponseCollectorService.ComputedNodeStats stats = maybeStats.get();  
                    // captured once for each query in TransportSearchAction
        final Set<String> nodeIds = getAllNodeIds(shards);
            }
    }  
        }
     * its random within the active shards, and initializing shards are the last to iterate through.
            seed = shufflerForWeightedRouting.nextSeed();
        }
                assignedShards.add(shard.getTargetRelocatingShard());
    public List<ShardRouting> searchOnlyReplicas() {
                    ordered.addFirst(replica);
        List<ShardRouting> shards,  
                        logger.error(() -> new ParameterizedMessage("Failed to write shard {}. Exception {}", indexShard, e));
        DiscoveryNodes nodes,
    ) {
    ) {
        int seed = shuffler.nextSeed();
    }
        private ShardId shardId;
     */  
        List<ShardRouting> ordered = new ArrayList<>();
                sb.append(", ");
        }  
 * Unless required by applicable law or agreed to in writing,
                // This ensures the primaries do not validate these ids exist in tracking nor are included
        for (ShardRouting shardEntry : this) {
            }
     * *  
    final Set<String> allAllocationIds;  
        final Map<String, Optional<ResponseCollectorService.ComputedNodeStats>> nodeStats,  
        synchronized (shardsByWeightMutex) {
        }
        int count = 0;
    ) {  
            }
    public void writeTo(StreamOutput out) throws IOException {
    IndexShardRoutingTable(ShardId shardId, List<ShardRouting> shards) {  
     * Returns an iterator only on the primary shard.  
        // no need to worry about primary first here..., its temporal
     * Returns true if no primaries are active or initializing for this shard
    public List<ShardRouting> assignedShards() {
            if (localAttributeValue != null) {  
            return shards;
        ArrayList<ShardRouting> ordered = new ArrayList<>(activeShards.size() + allInitializingShards.size());
            if (replica.active()) {
    /**
        List<WeightedRoundRobin.Entity<ShardRouting>> shardsWithWeights = new ArrayList<>();
                    try {  
import java.util.HashSet;  
    /**  
    public ShardIterator activeInitializingShardsWeightedIt(
     * round-robin scheduling policy.
            if (shard.isSearchOnly()) {
        int seed = shuffler.nextSeed();  
        List<ShardRouting> shards,
        ordered.addAll(shufflerForWeightedRouting.shuffle(orderedActiveShards, seed));
            if (shardEntry.state() == state) {
        return shardId();
import org.opensearch.cluster.node.DiscoveryNode;  
            if (predicate.test(shardEntry)) {
     *
    public static List<ShardRouting> rankShardsAndUpdateStats(
        this.allShardsStarted = allShardsStarted;
                shardRoutings = new AttributesRoutings(to, Collections.unmodifiableList(from));
            for (ShardRoutingState state : states) {
    public List<ShardRouting> shards() {
                Optional<ResponseCollectorService.ComputedNodeStats> maybeMinStats = nodeStats.get(minNodeId);
        final ResponseCollectorService collector,  
     */
     */  
                activeShardsByAttributes = MapBuilder.newMapBuilder(activeShardsByAttributes).put(key, shardRoutings).immutableMap();
        for (int i = 0; i < numShards; i++) {
            populateActiveShardWeightsMap(weightedRouting, nodes, defaultWeight);  
                    // it only affects the captured node search counts, which is  
            this.weightedRouting = weightedRouting;
     *  
    public static Diff<IndexShardRoutingTable> readDiffFrom(StreamInput in) throws IOException {  
                }  
    }
                return 0;  
 *  
        }
            out.writeVInt(indexShard.shardId.id());
            );
        int result = shardId.hashCode();
    /**  
            }
        }
    private void populateInitializingShardWeightsMap(WeightedRouting weightedRouting, DiscoveryNodes nodes, double defaultWeight) {
    }  
        public static IndexShardRoutingTable readFromThin(StreamInput in, Index index) throws IOException {
        }
    /**
        }
    }
        WeightedRouting weightedRouting,
                    adjustStats(collector, nodeStats, minNodeId, maybeMinStats.get());  
        List<ShardRouting> ordered = new ArrayList<>(getActiveShardsWithoutWeight(weightedRouting, nodes, defaultWeight));
        WeightedRouting weightedRouting,  
        }  
        WeightedRoutingKey key = new WeightedRoutingKey(weightedRouting);  
    @Override  
        Builder.writeToThin(this, out);
 * not use this file except in compliance with the License.
    public List<ShardRouting> getActiveShards() {
                    // place non-nulls after null values
 *
        public WeightedRoutingKey(WeightedRouting weightedRouting) {
     * scheduling policy. Making sure that initializing shards are the last to iterate through.  
                } else if (replica.initializing()) {
        // fill it in a randomized fashion
                }
        for (ShardRouting replica : shuffler.shuffle(replicas)) {
import java.util.Map;
                activeShards.add(shard);
     */
        this.shardId().getIndex().writeTo(out);  
            return allInitializingShards;  
    }
        final Map<String, Double> nodeRanks = rankNodes(nodeStats, nodeSearchCounts);  
            for (ShardRouting shard : shards) {  
     * <p>
     */
                    // place nulls before non-null values
 * SPDX-License-Identifier: Apache-2.0
        public static IndexShardRoutingTable readFrom(StreamInput in) throws IOException {  
        AttributesKey(List<String> attributes) {
        return size();  
    /**
    public ShardIterator shardsIt(int seed) {  
        return new PlainShardIterator(shardId, ordered);
        ArrayList<ShardRouting> preferred = new ArrayList<>(activeShards.size() + allInitializingShards.size());
     * @return a {@link List} of shards  
    public ShardIterator activeInitializingShardsRandomIt() {
     */
        double defaultWeight
            if (this == o) return true;
    }
     * its random within the active shards, and initializing shards are the last to iterate through.  
    }
        // fill it in a randomized fashion
    public static class WeightedRoutingKey {
                        throw new RuntimeException("Failed to write IndexShardRoutingTable", e);
    /**
    public List<ShardRouting> shardsMatchingPredicate(Predicate<ShardRouting> predicate) {
    @Override  
            return this;
            writeToThin(indexShard, out);  
import java.util.Set;
                rankShardsAndUpdateStats(shuffler.shuffle(activeShards, seed), collector, nodeSearchCounts)  
        return nodeStats;
     *
    /**  
     * uses weighted routing to find weight for the corresponding shard. This is fed to weighted round-robin scheduling
    final List<ShardRouting> replicas;
        }  
    /**
        DiscoveryNodes nodes,
                allShardsStarted = false;
        final int numShards = shards.size();
                Double weight = weightedRouting.weights().getOrDefault(attVal, defaultWeight);
                    allInitializingShards.add(shard.getTargetRelocatingShard());
    private List<ShardRouting> getInitializingShardsWithoutWeight(
            // is primary assigned
    public ShardIterator primaryActiveInitializingShardIt() {
    }  
        if (primary != null) {  
    public boolean allShardsStarted() {
    /**
        sb.append("}");
    private List<WeightedRoundRobin.Entity<ShardRouting>> calculateShardWeight(
import static java.util.Collections.emptyMap;  
            return new PlainShardIterator(shardId, Collections.singletonList(primary));
            ShardRouting primary = indexShard.primaryShard();  
        }
    }
    /**
            this.shardRoutingWithoutWeight = Collections.unmodifiableList(shardRoutingWithoutWeight);  
        if (isFailOpenEnabled) {
        }
        return onlyNodeSelectorActiveInitializingShardsIt(new String[] { nodeAttributes }, discoveryNodes);  
        ordered.addAll(shuffler.shuffle(activeShards, seed));  
        WeightedRoundRobin<ShardRouting> weightedRoundRobin = new WeightedRoundRobin<>(
            if (shard1rank != null) {
        return activeShardsByWeight.get(key).getShardRoutingWithoutWeight();
    final List<ShardRouting> activeShards;
        }
        return nodeIds;
import org.apache.logging.log4j.message.ParameterizedMessage;  
            }
                    // Note that this doesn't actually affect the "real" counts, instead
            return new PlainShardIterator(
                nodeAttributes.length == 1 ? "criteria" : "criterion",
    /**  
        preferred.addAll(notPreferred);  
    }  
    // Shuffler for weighted round-robin shard routing. This uses rotation to permute shards.  
        final ResponseCollectorService collector,
        return Collections.unmodifiableList(to);
            activeShardsByWeight = new MapBuilder().put(key, new WeightedShardRoutings(weightedRoutings, nonWeightedRoutings))  
     */  
        }
        public boolean equals(Object obj) {  
@PublicApi(since = "1.0.0")
    }
        this.activeShards = Collections.unmodifiableList(activeShards);
        WeightedRoutingKey key = new WeightedRoutingKey(weightedRouting);
            for (int i = 0; i < size; i++) {
    public ShardId getShardId() {
     * the winning node had a queue size of 10 and a non-winning node had a queue of 18. The average queue size is (10 + 18) / 2 = 14 so the
    public int shardsMatchingPredicateCount(Predicate<ShardRouting> predicate) {  
 * Modifications Copyright OpenSearch Contributors. See
     * Returns <code>true</code> iff all shards in the routing table are started otherwise <code>false</code>
        if (activeShardsByWeight.get(key) == null) {
     * @return a {@link List} of shards  
            }
    public String toString() {
    @Override
    static class AttributesKey {
            .filter(shard -> !weightedRoutings.contains(shard))  
import java.util.Optional;  
                    ordered.addLast(replica);  
     * Returns an ordered iterator on the active primary shard, followed by replica shards.  
                    collector.addNodeStatistics(nodeId, updatedQueue, updatedResponse, updatedService);
        // adjust the non-winner nodes' stats so they will get a chance to receive queries  
     * Returns a {@link List} of active shards
            if (shard.relocating()) {  
                    }  
        for (ShardRouting shardRouting : shuffler.shuffle(allInitializingShards, seed)) {
        return shards;
 * a disjoint set of the index data and each shard has one or more instances
        final Map<String, Double> nodeRanks = new HashMap<>(nodeStats.size());  
    }
    private volatile Map<AttributesKey, AttributesRoutings> activeShardsByAttributes = emptyMap();  
        }
        Collections.sort(sortedShards, new NodeRankComparator(nodeRanks));
                    // Both nodes do not have stats, they are equal
        for (ShardRouting shard : shards) {  
        return ordered.stream().distinct().collect(Collectors.toList());
     * @return an iterator over active and initializing shards, ordered by weighted round-robin
        @Override  
                }  
                orderedShardRouting.add(shardRouting.getTarget());  
    }  
            if (nodeId.equals(shardRouting.currentNodeId())) {
    /**
        return filterAndOrderShards(replica -> true);  
        }  
        AttributesRoutings activeRoutings = getActiveAttribute(key, nodes);
        }  
     */
        if (shardRoutings == null) {
                    }  
import org.opensearch.core.common.io.stream.StreamOutput;
    }
    /**  
        public boolean equals(Object o) {  
        }
import org.opensearch.node.ResponseCollectorService;
        // we now randomize, once between the ones that have the same attributes, and once for the ones that don't
        }  
import org.opensearch.core.common.io.stream.StreamInput;
        static boolean distinctNodes(List<ShardRouting> shards) {
                // the in-sync set that is sent to primaries, but they are still included in the routing table.
 * You may obtain a copy of the License at  
     * Returns a {@link List} of all initializing shards, including target shards of relocations
        return this.primary != null && !this.primary.active() && !this.primary.initializing();
    }
    }
        for (ShardRouting shard : shards) {
        ordered.addAll(shuffler.shuffle(activeRoutings.withSameAttribute, seed));
     * Returns an iterator over active and initializing shards. Making sure though that
                // in the unavailableInSyncShards set.  
     *
        NodeRankComparator(Map<String, Double> nodeRanks) {
                } else {  
                }
        ordered.addAll(allInitializingShards);
        return preferAttributesActiveInitializingShardsIt(attributes, nodes, shuffler.nextSeed());
        // Add the primary shard
 *
        if (this == o) return true;  
            final String message = String.format(
        return null;  
            Double shard2rank = nodeRanks.get(s2.currentNodeId());  
            populateInitializingShardWeightsMap(weightedRouting, nodes, defaultWeight);  
    }
            if (filter.test(replica)) {
        }
    public List<ShardRouting> activeShards() {
    public ShardRouting primaryShard() {
        }
        if (allInitializingShards.isEmpty()) {  
            if (nodeId.equals(shardRouting.currentNodeId())) {
        return shards.size();
    }  
        this.replicas = Collections.unmodifiableList(replicas);
        double defaultWeight  
    }  
        double defaultWeight,
                .immutableMap();
    /**  
     *
    @Override
    private boolean noPrimariesActive() {  
    final List<ShardRouting> shards;  
        return primary;  
                for (Iterator<ShardRouting> iterator = from.iterator(); iterator.hasNext();) {
            });  
 *     http://www.apache.org/licenses/LICENSE-2.0
        ShardRouting primary = null;  
    public List<ShardRouting> getAllInitializingShards() {
        return new PlainShardIterator(shardId, ordered);
                String minNodeId = minShard.currentNodeId();  
            indexShard.shards.stream()
     * @return a {@link List} of shards  
    final ShardShuffler shufflerForWeightedRouting;
                        return false;  
        }
        if (ordered.isEmpty()) {  
    final List<ShardRouting> allInitializingShards;
            ordered.add(shardRouting);  
    public ShardIterator preferNodeActiveInitializingShardsIt(Set<String> nodeIds) {
    public ShardIterator replicaActiveInitializingShardIt() {
                if (shard.relocating()) {
     * This adjustment takes the "winning" node's statistics and adds the average of those statistics with each non-winning node. Let's say  
import org.opensearch.cluster.node.DiscoveryNodes;
                if (replica.active()) {  
                }
            }
     */  
        WeightedRouting weightedRouting,  
    private final Object shardsByWeightMutex = new Object();  
    ) {
     * Returns a list containing shard routings ordered using weighted round-robin scheduling.  
            int result = weightedRouting.hashCode();
    }
        return new PlainShardIterator(shardId, shards);  
    }  
            this.shardId = indexShard.shardId;  
            return shardRoutingWithoutWeight;
    }
import java.util.LinkedList;
            ordered.addAll(allInitializingShards);  
     * Returns the shards id  
        public static void writeVerifiableTo(IndexShardRoutingTable indexShard, StreamOutput out) throws IOException {  
                nodeRanks.put(nodeId, stats.rank(nodeSearchCounts.getOrDefault(nodeId, 1L)));
        List<ShardRouting> weightedRoutings = shardsOrderedByWeight(activeShards, weightedRouting, nodes, defaultWeight);
        List<ShardRouting> orderedActiveShards = getActiveShardsByWeight(weightedRouting, nodes, defaultWeight);  
        this.shards = Collections.unmodifiableList(shards);
        List<ShardRouting> orderedShardRouting = new ArrayList<>(activeShards.size());  
    }  
            return attributes.hashCode();
import org.opensearch.common.util.set.Sets;  
            // shards, don't bother to do adjustments
     */
            int size = in.readVInt();
            preferred.addAll(allInitializingShards);
                    : "Search replicas should not be part of the allAllocationId set";  
    private AttributesRoutings getInitializingAttribute(AttributesKey key, DiscoveryNodes nodes) {
            } else {
    }  
                .forEach(shardRouting -> {
            if (selectedNodes.contains(shardRouting.currentNodeId())) {  
                // these shards on the same node
            return new PlainShardIterator(shardId, Collections.emptyList());  
        if (noPrimariesActive()) {
    /**  
        return shards.iterator();
            }
            ShardId shardId = new ShardId(index, iShardId);
    }  
    private List<ShardRouting> getActiveShardsWithoutWeight(WeightedRouting weightedRouting, DiscoveryNodes nodes, double defaultWeight) {  
        public Builder(IndexShardRoutingTable indexShard) {
                    assignedShards.add(shard);  
    private static Map<String, Double> rankNodes(
 * {@link IndexShardRoutingTable} encapsulates all instances of a single shard.  
        private final List<ShardRouting> shards;  
        WeightedRoutingKey key = new WeightedRoutingKey(weightedRouting);
                assert shard.getTargetRelocatingShard().assignedToNode() : "relocating to unassigned " + shard.getTargetRelocatingShard();  
                shardsWithWeights.add(new WeightedRoundRobin.Entity<>(weight, shard));  
        return new PlainShardIterator(shardId, Collections.emptyList());  
                continue;
     * Builder of an index shard routing table.
                replicas.add(shard);
     * @return a {@link List} of shards that match one of the given {@link Predicate}  
    public static IndexShardRoutingTable readFrom(StreamInput in) throws IOException {
        @Override
    /**  
        // Add initializing shards last
     * Cassandra sends occasional requests to all copies of the data, so their stats will be updated during that broadcast phase. In
        orderedListWithDistinctShards = ordered.stream().distinct().collect(Collectors.toList());
            return shardRoutingsWithWeight;
        List<WeightedRoundRobin.Entity<ShardRouting>> shardsOrderedbyWeight = weightedRoundRobin.orderEntities();
            DiscoveryNode node = nodes.get(shard.currentNodeId());
        // we don't want to mix between the two!
        return shardRoutings;
                if (shard2rank != null) {
     */  
        }
     *  
        }  
        public Builder addShard(ShardRouting shardEntry) {  
            initializingShardsByWeight = new MapBuilder().put(key, new WeightedShardRoutings(weightedRoutings, nonWeightedRoutings))  
        List<ShardRouting> orderedListWithDistinctShards;  
        return shards;
        return allAllocationIds;
    private void populateActiveShardWeightsMap(WeightedRouting weightedRouting, DiscoveryNodes nodes, double defaultWeight) {
    }
        }
                // mark search only shards as initializing or assigned, but do not add to
        if (o == null || getClass() != o.getClass()) return false;
        if (!allInitializingShards.isEmpty()) {
        this.shufflerForWeightedRouting = new RotationShardShuffler(Randomness.get().nextInt());  
        return orderedShardRouting;  
import java.util.Iterator;
                ordered.add(replica);  
        List<ShardRouting> rankedInitializingShards = rankShardsAndUpdateStats(allInitializingShards, collector, nodeSearchCounts);
    private volatile Map<AttributesKey, AttributesRoutings> initializingShardsByAttributes = emptyMap();
 * referred to as replicas of a shard. Given that, this class encapsulates all  
        AttributesRoutings shardRoutings = activeShardsByAttributes.get(key);
 * The OpenSearch Contributors require contributions made to  
    final ShardRouting primary;
                    } else if (localAttributeValue.equals(discoveryNode.getAttributes().get(attribute))) {  
        }
        return new PlainShardIterator(shardId, preferred);
            ordered.addAll(orderedInitializingShards);
     */  
import org.opensearch.common.Nullable;
                notPreferred.add(shardRouting);  
import java.util.List;  
    }
        double defaultWeight,
                shardId()  
import java.util.function.Predicate;  
        ArrayList<ShardRouting> ordered = new ArrayList<>(activeShards.size() + allInitializingShards.size());
        }
    }
        final Map<String, Optional<ResponseCollectorService.ComputedNodeStats>> nodeStats,  
            this.totalSize = withoutSameAttribute.size() + withSameAttribute.size();
                    return -1;
    ) {
        // fill it in a randomized fashion with the active replicas  
            synchronized (shardsByAttributeMutex) {  
        return new PlainShardIterator(shardId, ordered);
        return shardsWithWeights;  
                assignedShards.add(shard);
            Set<String> nodes = new HashSet<>();
        final String minNodeId,
     * @opensearch.api  
     * Returns a {@link List} of the search only shards in the RoutingTable
     * Returns an iterator on replica shards.  
    public ShardIterator onlyNodeSelectorActiveInitializingShardsIt(String[] nodeAttributes, DiscoveryNodes discoveryNodes) {
        return sb.toString();  
        return readDiffFrom(IndexShardRoutingTable::readFrom, in);
        List<ShardRouting> activeShards = new ArrayList<>();
                    assignedShards.add(shard.getTargetRelocatingShard());  
    static class AttributesRoutings {
                ordered.add(shardRouting);
        if (collector == null || nodeSearchCounts == null || shards.size() <= 1) {  
        }  
                    shards.add(shardEntry);  
                .filter(shardRouting -> shardRouting.allocationId() != null)  
            }  
                if (shard.assignedToNode()) {
     */  
        @Nullable Map<String, Long> nodeSearchCounts  
                if (nodeId.equals(minNodeId) == false && maybeStats.isPresent()) {
        if (noPrimariesActive()) {
        Set<String> allAllocationIds = new HashSet<>();
    final boolean allShardsStarted;
                shardId,
                // switch, its the matching node id
    }
            if (shard.active()) {
        @Override
        }  
            // If the winning shard is not started we are ranking initializing  
     * Supports node specifications in cluster API
    }
        if (allInitializingShards.isEmpty()) {
                    final DiscoveryNode discoveryNode = nodes.get(fromShard.currentNodeId());  
     * Returns a {@link List} of shards
        }
    }  
            Double shard1rank = nodeRanks.get(s1.currentNodeId());
     *                          in node attribute value with weight zero
        public int compare(ShardRouting s1, ShardRouting s2) {  
        return new PlainShardIterator(shardId, ordered);  
            if (shard.primary()) {
    }
import org.opensearch.cluster.Diff;
            List<ShardRouting> orderedInitializingShards = getInitializingShardsByWeight(weightedRouting, nodes, defaultWeight);  
    }
        for (ShardRouting shardEntry : this) {  
                    if (nodes.add(shard.currentNodeId()) == false) {
                    if (discoveryNode == null) {
                shardRoutings = new AttributesRoutings(to, Collections.unmodifiableList(from));
        result = 31 * result + shards.hashCode();  
 * this work for additional information regarding copyright
        return filterAndOrderShards(ShardRouting::isSearchOnly);
            this.shardId = shardId;
        final Map<String, Long> nodeSearchCounts
        for (ShardRouting shardEntry : replicas) {  
                entry.writeToThin(out);
     * Returns an iterator over active and initializing shards. Making sure though that
     * Returns a {@link List} of shards
     */
     *
            this.withoutSameAttribute = withoutSameAttribute;
    ) {
            if (shard.assignedToNode()) {  
            }  
        return this.activeShards;  
    public Set<String> getAllAllocationIds() {  
        boolean allShardsStarted = true;  
/*  
            synchronized (shardsByAttributeMutex) {
                // the allAllocationId set. Cluster Manager will filter out search replica allocationIds in  
        }
 * the Apache License, Version 2.0 (the "License"); you may
                    return 0;
        return new PlainShardIterator(shardId, ordered);
     * @param isFailOpenEnabled if true, shards search requests in case of failures are tried on shard copies present  
        public static void writeToThin(IndexShardRoutingTable indexShard, StreamOutput out) throws IOException {  
            }  
        }
        }  
    }
    public List<ShardRouting> replicaShardsWithState(ShardRoutingState... states) {
    /**
            }
        return IndexShardRoutingTable.Builder.readFrom(in);  
                }
     * Gets active shard routing from memory if available, else calculates and put it in memory.
        return activeShards();  
                final Optional<ResponseCollectorService.ComputedNodeStats> maybeStats = entry.getValue();
        @Override
                allInitializingShards.add(shard);
        }
     * @opensearch.api
 * software distributed under the License is distributed on an
            nodeIds.add(shard.currentNodeId());  
        }
    public ShardIterator shardsIt() {
        }
                shards.add(shardEntry);  
        return shards();  
     */  
                ArrayList<ShardRouting> from = new ArrayList<>(activeShards);
 * Licensed to Elasticsearch under one or more contributor  
                }
     */
    }  
        final Set<String> nodeIds,  
            populateInitializingShardWeightsMap(weightedRouting, nodes, defaultWeight);  
            if (!weightedRouting.equals(key.weightedRouting)) return false;
        return nodeRanks;
     */
            WeightedRoutingKey key = (WeightedRoutingKey) o;  
        final ArrayList<ShardRouting> to = new ArrayList<>();  
        private final List<ShardRouting> shardRoutingWithoutWeight;
 *
        return sortedShards;
                        assignedShardCount.getAndIncrement();
        public final List<ShardRouting> withoutSameAttribute;
            }
        ArrayList<ShardRouting> ordered = new ArrayList<>(activeShards.size() + allInitializingShards.size());
    }  
     */
     */
                        if (nodes.add(shard.relocatingNodeId()) == false) {  
    ) {  
            calculateShardWeight(shards, weightedRouting, nodes, defaultWeight)  
        WeightedRoutingKey key = new WeightedRoutingKey(weightedRouting);
        if (shardsOrderedbyWeight != null) {
            return new PlainShardIterator(shardId, Collections.emptyList());
            for (ShardRouting entry : indexShard) {
        public List<ShardRouting> getShardRoutingsWithWeight() {  
    }
     */  
    public ShardIterator onlyNodeSelectorActiveInitializingShardsIt(String nodeAttributes, DiscoveryNodes discoveryNodes) {
                initializingShardsByAttributes = MapBuilder.newMapBuilder(initializingShardsByAttributes)  
    @Override
        // shard copies in case of request failure from other attribute values.  
    public ShardIterator replicaFirstActiveInitializingShardsIt() {
        }  
import java.util.concurrent.atomic.AtomicInteger;
        if (activeShardsByWeight.get(key) == null) {  
                        iterator.remove();
     * Returns the number of this shards instances.  
    private static Set<String> getAllNodeIds(final List<ShardRouting> shards) {  
    }
            }
        }  
     *  
                    // Increase the number of searches for the "winning" node by one.
        // If the primaries are unassigned, return an empty list (there aren't
 * this file be licensed under the Apache-2.0 license or a
     * Returns a {@link List} of assigned shards, including relocation targets
            } else {
     * Returns the number of this shards instances.
        ArrayList<ShardRouting> ordered = new ArrayList<>(activeShards.size() + allInitializingShards.size());
    private static void adjustStats(
        ordered.add(primary);
                    return 1;  
    /**
            ShardRouting minShard = sortedShards.get(0);
     * Returns an ordered iterator on active replica shards, followed by the primary shard.
     * Returns an iterator only on the active primary shard.
     */
     * @param weightedRouting entity
        ordered.addAll(rankedActiveShards);  
        if (noPrimariesActive()) {
        if (initializingShardsByWeight.get(key) == null) {
        final Map<String, Optional<ResponseCollectorService.ComputedNodeStats>> nodeStats = getNodeStats(nodeIds, collector);  
        List<ShardRouting> assignedShards = new ArrayList<>();  
        private final List<ShardRouting> shardRoutingsWithWeight;
        List<ShardRouting> allInitializingShards = new ArrayList<>();
    /**  
        WeightedRoutingKey key = new WeightedRoutingKey(weightedRouting);  
            maybeStats.ifPresent(stats -> {  
                List<ShardRouting> to = collectAttributeShards(key, nodes, from);
        List<ShardRouting> shards = new ArrayList<>();
     * Returns shards based on nodeAttributes given  such as node name , node attribute, node IP
        final ResponseCollectorService collector
        return shards.size() == that.shards.size() && shards.containsAll(that.shards) && that.shards.containsAll(shards);  
            } else {
        List<ShardRouting> replicas = new ArrayList<>();
        Set<String> selectedNodes = Sets.newHashSet(discoveryNodes.resolveNodes(nodeAttributes));  
    }  
     * Key for WeightedRouting Shard Iterator
    }
 * license agreements. See the NOTICE file distributed with
                ordered.add(shardRouting);  
    }
                }
            if (node != null) {
        public int hashCode() {  
        return primaryShardIt();
            return obj instanceof AttributesKey && attributes.equals(((AttributesKey) obj).attributes);
        StringBuilder sb = new StringBuilder();
        ArrayList<ShardRouting> ordered = new ArrayList<>(activeRoutings.totalSize + initializingRoutings.totalSize);  
            Optional<ResponseCollectorService.ComputedNodeStats> maybeStats = entry.getValue();
                }
