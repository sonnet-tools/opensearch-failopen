    }  
            // Remove children, if present.  
            }
import java.util.List;  
    }
    /**
        }  
            node.decrementBySnapshot(statsToDecrement);  
    public void incrementEvictions(List<String> dimensionValues) {  
        }
        void resetSizeAndEntries() {  
    protected ImmutableCacheStats removeDimensionsHelper(List<String> dimensionValues, Node node, int depth) {
        Node child = node.getChild(dimensionValues.get(depth));
        if (statsToDecrement != null) {
            this.stats.incrementHits();  
        }
                return false;  
        internalIncrement(dimensionValues, Node::incrementMisses, true);
    }  
        // Include this here so caches don't have to create an entire AggregateRefCountedCacheStats object to run count().
            return dimensionValue;
        public void incrementHits() {
    public void decrementItems(List<String> dimensionValues) {
            return true;  
            return children;  
        long getEntries() {  
    protected final Node statsRoot;  
        boolean createNodesIfAbsent
    /**
         */
    public void incrementItems(List<String> dimensionValues) {
    ) {
            return null;
            }
            adder.accept(node);
            // Pass up a snapshot of the original stats to avoid issues when the original is decremented by other fn invocations
    protected final List<String> dimensionNames;
        return false;
    }  
        }  
 * @opensearch.experimental
        Node getChild(String dimensionValue) {
    // The list of permitted dimensions. Should be ordered from "outermost" to "innermost", as you would like to
            this.stats.resetSizeAndEntries();
            this.stats.incrementEvictions();
     * If createNodesIfAbsent is true, and there is no stats for this set of dimensions, create one.
     * Nodes that make up the tree in the stats holder.
            // We can safely iterate over ConcurrentHashMap without worrying about thread issues.
    // To avoid sync problems, obtain a lock before creating or removing nodes in the stats tree.
            return node.getImmutableStats();  
            return children == EMPTY_CHILDREN_MAP;
    }
        assert dimensionValues.size() == dimensionNames.size() : "Must specify a value for every dimension when removing from StatsHolder";
package org.opensearch.common.cache.stats;
         * Does not return true if this is a node at a higher level whose children are still being constructed.
 * copy of the current state of the stats.
        }  
    // Non-leaf nodes have stats matching the sum of their children.  
    private boolean internalIncrementHelper(
        Node node,
            resetHelper(child);
        }
    protected final Lock lock = new ReentrantLock();  
        void incrementItems() {
import java.util.Collections;
     */
        }
        Consumer<Node> adder,  
        current.resetSizeAndEntries();  
     */
        internalIncrement(dimensionValues, Node::decrementItems, false);
 * The OpenSearch Contributors require contributions made to  
        }  
        }
                child = node.createChild(dimensionValues.get(depth), createMapInChild);
            // The removal took place, decrement values and remove this node from its parent if it's now empty
            }  
     * This is in line with the behavior of the existing API when caches are cleared.
import java.util.Map;
            adder.accept(node);
    }
        }  
            this.dimensionValue = dimensionValue;  
        }
        // The stats for this node. If a leaf node, corresponds to the stats for this combination of dimensions; if not,
                this.children = new ConcurrentHashMap<>();
import java.util.concurrent.ConcurrentHashMap;  
    }
        try {
        for (Node child : current.children.values()) {
    public void decrementSizeInBytes(List<String> dimensionValues, long amountBytes) {  
        }
     * If levels is null, do not aggregate and return an immutable version of the original tree.
/*  
import java.util.function.Consumer;  
        Node child = node.getChild(dimensionValues.get(depth));  
            return children.get(dimensionValue);
     * Returns true if the increment was applied, false if not.  
        }  
            return children.computeIfAbsent(dimensionValue, (key) -> new Node(dimensionValue, createMapInChild));  
    }
    }
    @Override  
        }  
        return statsRoot.getEntries();  
     * Reset number of entries and memory size when all keys leave the cache, but don't reset hit/miss/eviction numbers.  
        // As we are removing nodes from the tree, obtain the lock  
    private void resetHelper(Node current) {
     * Produce an immutable version of these stats, aggregated according to levels.  
    // We use a tree structure, rather than a map with concatenated keys, to save on memory usage. If there are many leaf
        int depth, // Pass in the depth to avoid having to slice the list for each node.
            // which are in the process of having children added
            // This is the leaf node we are trying to reach
    @Override
    public long count() {
/**
    // The name of the cache type using these stats
 * this file be licensed under the Apache-2.0 license or a
    // aggregate them in an API response.  
        private CacheStats stats;  
        // contains the sum of its children's stats.
        internalIncrement(dimensionValues, (node) -> node.decrementSizeInBytes(amountBytes), false);
    public Node getStatsRoot() {
    public void incrementMisses(List<String> dimensionValues) {
            this.stats.incrementMisses();
    // No lock is needed to edit stats on existing nodes.
    }  
        return new ImmutableCacheStatsHolder(this.statsRoot, nonNullLevels, dimensionNames, storeName);  
     */
    @Override  
 * Currently, in the IRC, the stats tracked in a CacheStatsHolder will not appear for empty shards that have had no cache  
 */
                internalIncrementHelper(dimensionValues, statsRoot, 0, adder, true);
import java.util.Objects;
         * @return if this is a leaf node at the lowest level  
        public Map<String, Node> getChildren() {
        }
        assert dimensionValues.size() == dimensionNames.size();
        }
                this.children = EMPTY_CHILDREN_MAP;
        }
        internalIncrement(dimensionValues, Node::incrementHits, true);  
        internalIncrement(dimensionValues, (node) -> node.incrementSizeInBytes(amountBytes), true);  
    public static class Node {  
        resetHelper(statsRoot);
 * tree in CacheStatsHolder in the ICache interface.
        List<String> dimensionValues,  
        this.storeName = storeName;  
        public ImmutableCacheStats getImmutableStats() {
        void decrementItems() {
    public List<String> getDimensionNames() {
    public void incrementSizeInBytes(List<String> dimensionValues, long amountBytes) {
        }
        // First try to increment without creating nodes
    public ImmutableCacheStatsHolder getImmutableCacheStatsHolder(String[] levels) {
    }
         * Return whether this is a leaf node which is at the lowest level of the tree.
        }
    }
                boolean createMapInChild = depth < dimensionValues.size() - 1;  
     */
                lock.unlock();
import java.util.concurrent.locks.Lock;
        Node createChild(String dimensionValue, boolean createMapInChild) {
            return this.stats.getItems();
            return this.stats.immutableSnapshot();
            if (child.getChildren().isEmpty()) {
        }
            removeDimensionsHelper(dimensionValues, statsRoot, 0);  
 *
        if (child == null) {  
            // Function returns true if the next node down was incremented
 * A class ICache implementations use to internally keep track of their stats across multiple dimensions.  
        }
    @Override
 *  
    public void incrementHits(List<String> dimensionValues) {
    public DefaultCacheStatsHolder(List<String> dimensionNames, String storeName) {
        this.statsRoot = new Node("", true); // The root node has the empty string as its dimension value
    protected void internalIncrement(List<String> dimensionValues, Consumer<Node> adder, boolean createNodesIfAbsent) {  
        if (internalIncrementHelper(dimensionValues, child, depth + 1, adder, createNodesIfAbsent)) {  
        }
    }  
        String[] nonNullLevels = Objects.requireNonNullElseGet(levels, () -> new String[0]);
                lock.lock();
            try {  
    public void removeDimensions(List<String> dimensionValues) {
        final Map<String, Node> children;  
        internalIncrement(dimensionValues, Node::incrementItems, true);  
        }
        private static final Map<String, Node> EMPTY_CHILDREN_MAP = new HashMap<>();  
        // Used for leaf nodes to avoid allocating many unnecessary maps
        boolean didIncrement = internalIncrementHelper(dimensionValues, statsRoot, 0, adder, false);  
            node.children.clear();
 * SPDX-License-Identifier: Apache-2.0
            return true;  
    // A tree structure based on dimension values, which stores stats values in its leaf nodes.
    }
        internalIncrement(dimensionValues, Node::incrementEvictions, true);
            } else {  
    // which have been entirely deleted, for example in an async removal listener.
        void decrementBySnapshot(ImmutableCacheStats snapshot) {
        return dimensionNames;
    @Override
    @Override  
import java.util.concurrent.locks.ReentrantLock;
        }
            this.stats.decrementSizeInBytes(amountBytes);
import java.util.HashMap;
        } finally {
        ImmutableCacheStats statsToDecrement = removeDimensionsHelper(dimensionValues, child, depth + 1);  
        if (child == null) {
    @Override
            this.stats.incrementSizeInBytes(amountBytes);  
        return statsRoot;  
    // nodes that share a parent, that parent's dimension value will only be stored once, not many times.
    public void reset() {
            lock.unlock();
    @Override  
        // If we failed to increment, because nodes had to be created, obtain the lock and run again while creating nodes if needed
                node.children.remove(child.getDimensionValue());
        this.dimensionNames = Collections.unmodifiableList(dimensionNames);
    @Override  
            if (createChildrenMap) {
        lock.lock();
public class DefaultCacheStatsHolder implements CacheStatsHolder {  
        public void incrementEvictions() {
    /**  
        public void decrementSizeInBytes(long amountBytes) {  
        public boolean isAtLowestLevel() {
        Node(String dimensionValue, boolean createChildrenMap) {
        if (!didIncrement && createNodesIfAbsent) {
    @Override  
     * Use the incrementer function to increment/decrement a value in the stats for a set of dimensions.
            this.stats.decrementItems();  
    @Override
            if (createNodesIfAbsent) {
 * operations done on them yet. This might be changed in the future, by exposing a method to add empty nodes to the
            // Compare by value to the empty children map, to ensure we don't get false positives for nodes  
        // Map from dimensionValue to the DimensionNode for that dimension value.
        if (depth == dimensionValues.size()) {  
            this.stats = new CacheStats();  
    // For decrements, we should not create nodes if they are absent. This protects us from erroneously decrementing values for keys  
            } else {
    }
    }
    }
        private final String dimensionValue;
    }  
        public void incrementSizeInBytes(long amountBytes) {
            } finally {  
        public String getDimensionValue() {  
    }
        if (depth == dimensionValues.size()) {
    // For all these increment functions, the dimensions list comes from the key, and contains all dimensions present in dimensionNames.
            }
    private final String storeName;
        public void incrementMisses() {  
        }  
    /**  
        return statsToDecrement;
        }
            this.stats.incrementItems();
    // The order has to match the order given in dimensionNames.  
 */  
 * Not intended to be exposed outside the cache; for this, caches use getImmutableCacheStatsHolder() to create an immutable
    // Returns a CacheStatsCounterSnapshot object for the stats to decrement if the removal happened, null otherwise.  
}
        /**  
 * compatible open source license.
            this.stats.subtract(snapshot);  
        // Functions for modifying internal CacheStatsCounter without callers having to be aware of CacheStatsCounter  
