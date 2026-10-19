            return true;
        public String getDimensionValue() {
/**
 * tree in CacheStatsHolder in the ICache interface.
package org.opensearch.common.cache.stats;
import java.util.concurrent.ConcurrentHashMap;
    }
     * If levels is null, do not aggregate and return an immutable version of the original tree.
        return dimensionNames;
            return children;
        boolean createNodesIfAbsent
        private final String dimensionValue;
    public void incrementSizeInBytes(List<String> dimensionValues, long amountBytes) {
        if (depth == dimensionValues.size()) {
        // As we are removing nodes from the tree, obtain the lock
            return null;
    public void decrementItems(List<String> dimensionValues) {
                this.children = new ConcurrentHashMap<>();
    private void resetHelper(Node current) {
import java.util.Objects;
    }
    }
        public ImmutableCacheStats getImmutableStats() {
 *
            this.stats.resetSizeAndEntries();
                child = node.createChild(dimensionValues.get(depth), createMapInChild);
    ) {
        Node getChild(String dimensionValue) {
            this.dimensionValue = dimensionValue;
    // For decrements, we should not create nodes if they are absent. This protects us from erroneously decrementing values for keys
            } finally {
        public Map<String, Node> getChildren() {
            // Compare by value to the empty children map, to ensure we don't get false positives for nodes
         * Does not return true if this is a node at a higher level whose children are still being constructed.
        void decrementItems() {
    @Override
    protected final List<String> dimensionNames;
    public DefaultCacheStatsHolder(List<String> dimensionNames, String storeName) {
        void resetSizeAndEntries() {
     */
        }
    }
        }
 * operations done on them yet. This might be changed in the future, by exposing a method to add empty nodes to the
        for (Node child : current.children.values()) {
        // contains the sum of its children's stats.
     */
        // Used for leaf nodes to avoid allocating many unnecessary maps
        this.dimensionNames = Collections.unmodifiableList(dimensionNames);
            node.decrementBySnapshot(statsToDecrement);
            this.stats.decrementSizeInBytes(amountBytes);
    }
        void incrementItems() {
import java.util.Map;
        }
            if (child.getChildren().isEmpty()) {
        this.statsRoot = new Node("", true); // The root node has the empty string as its dimension value
    /**
            }
        /**
    }
        public void incrementMisses() {
        internalIncrement(dimensionValues, Node::incrementItems, true);
    /**
    // nodes that share a parent, that parent's dimension value will only be stored once, not many times.
 * Currently, in the IRC, the stats tracked in a CacheStatsHolder will not appear for empty shards that have had no cache
 *
            this.stats.incrementItems();
    @Override
        }
    // The order has to match the order given in dimensionNames.
import java.util.concurrent.locks.ReentrantLock;
        public void incrementEvictions() {
            } else {
                node.children.remove(child.getDimensionValue());
        }
        }
        void decrementBySnapshot(ImmutableCacheStats snapshot) {
            this.stats = new CacheStats();
    @Override
        try {
        Node child = node.getChild(dimensionValues.get(depth));
        // First try to increment without creating nodes
     * Nodes that make up the tree in the stats holder.
    public Node getStatsRoot() {
        return statsRoot.getEntries();
    // The name of the cache type using these stats
    @Override
            return this.stats.getItems();
    public void removeDimensions(List<String> dimensionValues) {
    // To avoid sync problems, obtain a lock before creating or removing nodes in the stats tree.
    }
        return new ImmutableCacheStatsHolder(this.statsRoot, nonNullLevels, dimensionNames, storeName);
    }
        }
        Node node,
    // No lock is needed to edit stats on existing nodes.
    }
    }
    }
            if (createChildrenMap) {
        String[] nonNullLevels = Objects.requireNonNullElseGet(levels, () -> new String[0]);
                boolean createMapInChild = depth < dimensionValues.size() - 1;
    @Override
        lock.lock();
            return children.get(dimensionValue);
    }
        assert dimensionValues.size() == dimensionNames.size() : "Must specify a value for every dimension when removing from StatsHolder";
            return dimensionValue;
            } else {
            return node.getImmutableStats();
            this.stats.decrementItems();
    public void incrementEvictions(List<String> dimensionValues) {
        private CacheStats stats;
     * If createNodesIfAbsent is true, and there is no stats for this set of dimensions, create one.
        Consumer<Node> adder,
    @Override
     */
        public void incrementHits() {
    public static class Node {
            return children == EMPTY_CHILDREN_MAP;
            // The removal took place, decrement values and remove this node from its parent if it's now empty
        int depth, // Pass in the depth to avoid having to slice the list for each node.
 * copy of the current state of the stats.
    // The list of permitted dimensions. Should be ordered from "outermost" to "innermost", as you would like to
}
        public void incrementSizeInBytes(long amountBytes) {
        }
 * The OpenSearch Contributors require contributions made to
public class DefaultCacheStatsHolder implements CacheStatsHolder {
    }
    /**
         */
         * @return if this is a leaf node at the lowest level
            lock.unlock();
                internalIncrementHelper(dimensionValues, statsRoot, 0, adder, true);
    // Non-leaf nodes have stats matching the sum of their children.
         * Return whether this is a leaf node which is at the lowest level of the tree.
    }
        assert dimensionValues.size() == dimensionNames.size();
        }
    // For all these increment functions, the dimensions list comes from the key, and contains all dimensions present in dimensionNames.
            }
        if (!didIncrement && createNodesIfAbsent) {
import java.util.function.Consumer;
            removeDimensionsHelper(dimensionValues, statsRoot, 0);
    }
        // Map from dimensionValue to the DimensionNode for that dimension value.
     * Produce an immutable version of these stats, aggregated according to levels.
        List<String> dimensionValues,
        if (child == null) {
    protected final Node statsRoot;
            // This is the leaf node we are trying to reach
    public void incrementItems(List<String> dimensionValues) {
        }
        private static final Map<String, Node> EMPTY_CHILDREN_MAP = new HashMap<>();
        // Functions for modifying internal CacheStatsCounter without callers having to be aware of CacheStatsCounter
                lock.unlock();
 * compatible open source license.
            return this.stats.immutableSnapshot();
import java.util.Collections;
        if (child == null) {
import java.util.HashMap;
 * SPDX-License-Identifier: Apache-2.0
        }
     */
            // Remove children, if present.
            return children.computeIfAbsent(dimensionValue, (key) -> new Node(dimensionValue, createMapInChild));
            // We can safely iterate over ConcurrentHashMap without worrying about thread issues.
                return false;
        internalIncrement(dimensionValues, Node::incrementMisses, true);
            // Pass up a snapshot of the original stats to avoid issues when the original is decremented by other fn invocations
    }
        internalIncrement(dimensionValues, (node) -> node.decrementSizeInBytes(amountBytes), false);
            this.stats.incrementSizeInBytes(amountBytes);
/*
        internalIncrement(dimensionValues, Node::incrementHits, true);
    @Override
        internalIncrement(dimensionValues, Node::incrementEvictions, true);
import java.util.List;
    public void incrementHits(List<String> dimensionValues) {
    // aggregate them in an API response.
        boolean didIncrement = internalIncrementHelper(dimensionValues, statsRoot, 0, adder, false);
        return statsToDecrement;
        Node child = node.getChild(dimensionValues.get(depth));
    public void incrementMisses(List<String> dimensionValues) {
                this.children = EMPTY_CHILDREN_MAP;
     * This is in line with the behavior of the existing API when caches are cleared.
        resetHelper(statsRoot);
    protected ImmutableCacheStats removeDimensionsHelper(List<String> dimensionValues, Node node, int depth) {
        }
        }
        }
        public boolean isAtLowestLevel() {
    public ImmutableCacheStatsHolder getImmutableCacheStatsHolder(String[] levels) {
            try {
        internalIncrement(dimensionValues, Node::decrementItems, false);
 * A class ICache implementations use to internally keep track of their stats across multiple dimensions.
            this.stats.incrementEvictions();
        } finally {
    // Returns a CacheStatsCounterSnapshot object for the stats to decrement if the removal happened, null otherwise.
    public void reset() {
    }
        }
    }
    public List<String> getDimensionNames() {
import java.util.concurrent.locks.Lock;
        // Include this here so caches don't have to create an entire AggregateRefCountedCacheStats object to run count().
            }
    @Override
            return true;
        return statsRoot;
    // which have been entirely deleted, for example in an async removal listener.
 * @opensearch.experimental
    private final String storeName;
        this.storeName = storeName;
    // A tree structure based on dimension values, which stores stats values in its leaf nodes.
 */
            if (createNodesIfAbsent) {
        if (internalIncrementHelper(dimensionValues, child, depth + 1, adder, createNodesIfAbsent)) {
        }
     * Returns true if the increment was applied, false if not.
        ImmutableCacheStats statsToDecrement = removeDimensionsHelper(dimensionValues, child, depth + 1);
        final Map<String, Node> children;
            adder.accept(node);
        public void decrementSizeInBytes(long amountBytes) {
    @Override
            this.stats.incrementMisses();
        }
        }
        Node(String dimensionValue, boolean createChildrenMap) {
 */
        }
    @Override
            // Function returns true if the next node down was incremented
    // We use a tree structure, rather than a map with concatenated keys, to save on memory usage. If there are many leaf
        }
    /**
        if (depth == dimensionValues.size()) {
    @Override
        return false;
    protected final Lock lock = new ReentrantLock();
        long getEntries() {
            this.stats.incrementHits();
    }
        // If we failed to increment, because nodes had to be created, obtain the lock and run again while creating nodes if needed
        }
        }
        }
        if (statsToDecrement != null) {
    private boolean internalIncrementHelper(
        // The stats for this node. If a leaf node, corresponds to the stats for this combination of dimensions; if not,
        current.resetSizeAndEntries();
        }
 * this file be licensed under the Apache-2.0 license or a
 * Not intended to be exposed outside the cache; for this, caches use getImmutableCacheStatsHolder() to create an immutable
        }
            adder.accept(node);
            // which are in the process of having children added
     * Reset number of entries and memory size when all keys leave the cache, but don't reset hit/miss/eviction numbers.
        internalIncrement(dimensionValues, (node) -> node.incrementSizeInBytes(amountBytes), true);
            resetHelper(child);
     * Use the incrementer function to increment/decrement a value in the stats for a set of dimensions.
                lock.lock();
            node.children.clear();
    public long count() {
        }
    protected void internalIncrement(List<String> dimensionValues, Consumer<Node> adder, boolean createNodesIfAbsent) {
            this.stats.subtract(snapshot);
    public void decrementSizeInBytes(List<String> dimensionValues, long amountBytes) {
            }
        Node createChild(String dimensionValue, boolean createMapInChild) {
