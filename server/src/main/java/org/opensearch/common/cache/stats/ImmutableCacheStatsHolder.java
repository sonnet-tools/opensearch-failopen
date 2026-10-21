 *
    @Override
        for (String dimensionName : originalDimensionNames) {
        return newRoot;
import java.util.List;
        if (o == null || o.getClass() != ImmutableCacheStatsHolder.class) {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public ImmutableCacheStatsHolder(StreamInput in) throws IOException {
    public ImmutableCacheStats getTotalStats() {
        if (otherNode == null) {
     *                      the CacheStatsHolder.Node object we are traversing.
 * this file be licensed under the Apache-2.0 license or a
        for (Map.Entry<String, DefaultCacheStatsHolder.Node> childEntry : currentInOriginalTree.children.entrySet()) {
        DefaultCacheStatsHolder.Node currentInOriginalTree,
import java.util.Map;
        return getTotalStats().getSizeInBytes();
        }
            allChildrenMatch = equalsHelper(thisNode.children.get(childValue), otherNode.children.get(childValue));
        }
                case SERIALIZATION_CHILDREN_OPEN_BRACKET:
        String dimensionValue = in.readString();
        // Aggregate from the original CacheStatsHolder according to the levels passed in.
        boolean isLeafNode = in.readBoolean();
        }
import java.util.SortedMap;
        String levels = params.param("level");
    // Values used for serializing/deserializing the tree.
        makeNodeUnmodifiable(statsRoot);
            if (!allChildrenMatch) {
    public ImmutableCacheStats getStatsForDimensionValues(List<String> dimensionValues) {
        }
                // Create new node with stats matching the node from the original tree
        stack.push(statsRoot);
    public static String STORE_NAME_FIELD = "store_name";
        for (DefaultCacheStatsHolder.Node child : originalStatsRoot.children.values()) {
        public ImmutableCacheStats getStats() {
        }
            }
            this.stats = stats;
     * @param allDimensions the list of all dimensions present in the original CacheStatsHolder which produced
        } else {
        }
    final String storeName;
        if (depth == dimensionNames.size() - 1) {
            return false;
            this.children.putIfAbsent(dimensionValue, child);
 * The OpenSearch Contributors require contributions made to
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    private List<String> filterLevels(String[] levels, List<String> originalDimensionNames) {
    }
        private ImmutableCacheStats stats;
        // Map from dimensionValue to the Node for that dimension value. Not final so we can set it to be unmodifiable before we are done in
import java.util.ArrayList;
        List<String> filteredLevels = filterLevels(getLevels(params), dimensionNames);
            builder.endObject();
            // Finally set the parent node to be this node for the next callers of this function
        return statsRoot;
        return Objects.hash(statsRoot.stats, dimensionNames);
        // the constructor.
/**
        out.writeString(SERIALIZATION_BEGIN_NODE);
                nodeInNewTree = new Node(dimensionValue, isLeafNode, currentInOriginalTree.getImmutableStats());
        assert filteredLevels.equals(dimensionNames);
        writeNode(statsRoot, out);
    /**
                // node
            writeNode(entry.getValue(), out);
    private void writeNode(Node node, StreamOutput out) throws IOException {
    }
        return getTotalStats().getHits();
@ExperimentalApi
                case SERIALIZATION_CHILDREN_CLOSE_BRACKET:
            } else {
        // contains the sum of its children's stats.
    public long getTotalItems() {
            builder.startObject(dimensionNames.get(depth + 1));
            // the last parent node in the new tree. If it already exists, increment it instead.
                case SERIALIZATION_BEGIN_NODE:
    }
    final List<String> dimensionNames;
                    current = readSingleNode(in);
    static class Node {
     */
        out.writeString(SERIALIZATION_DONE);
                nodeInNewTree.incrementStats(currentInOriginalTree.getImmutableStats());
    }
    }
            stats = ImmutableCacheStats.addSnapshots(stats, toIncrement);
            }
        }
            String dimensionValue = currentInOriginalTree.getDimensionValue();
        return statsRoot;
import org.opensearch.core.common.io.stream.Writeable;
     * Filters out levels that aren't in dimensionNames, and orders the resulting list to match the order in dimensionNames.
            // This is a leaf node
            node.children = Collections.unmodifiableSortedMap(node.children);
                    stack.push(current);
 * @opensearch.experimental
            this.dimensionValue = dimensionValue;
                int indexOfLastLevel = allDimensions.indexOf(dimensionNames.get(dimensionNames.size() - 1));
            out.writeString(entry.getKey());
import org.opensearch.core.common.io.stream.StreamInput;
        this.storeName = storeName;
    private void aggregateByLevelsHelper(
        for (String dimensionValue : dimensionValues) {
            if (current == null) {
    @Override
            return children;
    // Root node of immutable snapshot of stats within a CacheStatsHolder, containing all the stats maintained by the cache.
        if (!thisNode.getStats().equals(otherNode.getStats())) {
        private static final SortedMap<String, Node> EMPTY_CHILDREN_MAP = Collections.unmodifiableSortedMap(new TreeMap<>());
    private static final String SERIALIZATION_BEGIN_NODE = "_";
        // Should be sufficient to hash based on the total stats value (found in the root node)
        private void incrementStats(ImmutableCacheStats toIncrement) {
    }
            aggregateByLevelsHelper(parentInNewTree, child, allDimensions, depth + 1);
    }
package org.opensearch.common.cache.stats;
            nextSymbol = in.readString();
    public long getTotalSizeInBytes() {
                this.children = new TreeMap<>();
/*
            builder.endObject();
            } else {
        }
     * Returns a new tree containing the stats aggregated by the levels passed in.
        ImmutableCacheStats stats = new ImmutableCacheStats(in);
    }
        List<String> filtered = new ArrayList<>();
        makeNodeUnmodifiable(statsRoot);
    // A similar class to CacheStatsHolder.Node, which uses a SortedMap and holds immutable CacheStatsSnapshot as its stats.
        }
            return dimensionValue;
    }
            aggregateByLevelsHelper(newRoot, child, originalDimensionNames, 0);
        }
    // The dimension names for each level in this tree.
        private void addChild(String dimensionValue, Node child) {
 * An object storing an immutable snapshot of an entire cache's stats. Accessible outside the cache itself.
            if (levelsList.contains(dimensionName)) {
        return current.stats;
            current.getStats().toXContent(builder, params);
                    stack.peek().children.put(current.dimensionValue, current);
    final Node statsRoot;
     * The levels passed in must be in the proper order, as they would be in the output of filterLevels().
        builder.field(STORE_NAME_FIELD, storeName);
import java.util.Objects;
            if (isLeafNode) {
        String storeName
        return allChildrenMatch;
        while (!nextSymbol.equals(SERIALIZATION_DONE)) {
    }
            switch (nextSymbol) {
        List<String> allDimensions,
        if (!node.children.isEmpty()) {
        out.writeStringArray(dimensionNames.toArray(new String[0]));
import java.util.TreeMap;
    }
    }
     * Because we may have to combine nodes that have the same dimension name, I don't think there's a clean way to aggregate
            }
    }
        this.dimensionNames = filterLevels(levels, originalDimensionNames);
    private Node readSingleNode(StreamInput in) throws IOException {
    }
import java.util.Arrays;
        if (levels == null) {
            return false;
        out.writeString(SERIALIZATION_CHILDREN_CLOSE_BRACKET);
        }
        if (!filteredLevels.isEmpty()) {
    // The name of the cache type producing these stats. Returned in API response.
        public String getDimensionValue() {
        // Always show total stats, regardless of levels
                return null;
        }
     * This should be ok because the resulting tree is unmodifiable after creation in the constructor.
            builder.startObject(current.dimensionValue);
 *
        }
        this.statsRoot = deserializeTree(in);
    ImmutableCacheStatsHolder(
    private Node deserializeTree(StreamInput in) throws IOException {
                toXContentForLevels(depth + 1, nextNode, builder, params);
     */
            current = current.children.get(dimensionValue);
    }
        // The dimension names for this immutable snapshot should reflect the levels we aggregate in the snapshot
        List<String> levelsList = Arrays.asList(levels);
    public boolean equals(Object o) {
        getTotalStats().toXContent(builder, params);
        return getTotalStats().getItems();
    }
            return false;
        if (levels == null) {
    private static final String SERIALIZATION_DONE = "end";
        if (depth >= 0) {
    private static final String SERIALIZATION_CHILDREN_CLOSE_BRACKET = ">";
        return equalsHelper(statsRoot, other.getStatsRoot());
        boolean allChildrenMatch = true;
        // The stats for this node. If a leaf node, corresponds to the stats for this combination of dimensions; if not,
public class ImmutableCacheStatsHolder implements Writeable, ToXContent {
            }
    }
        in.readString(); // Read and discard SERIALIZATION_BEGIN_NODE for the root node
        Node current = statsRoot;
        Node parentInNewTree,
        Node current = statsRoot;
        this.storeName = in.readString();
        String[] levels,
        return statsRoot.getStats();
    public long getTotalMisses() {
        out.writeString(storeName);
     */
        }
    }
    }
        out.writeString(node.dimensionValue);
     * The new tree only has dimensions matching the levels passed in.
        return levels.split(",");
    // Pkg-private for testing.
            if (nodeInNewTree == null) {
    /**
        List<String> originalDimensionNames,
     *
        }
 */
    }
        for (Map.Entry<String, Node> entry : node.children.entrySet()) {
            }
        }
            parentInNewTree = nodeInNewTree;
    ) {
                    stack.pop();
import org.opensearch.core.xcontent.ToXContent;
        return new Node(dimensionValue, isLeafNode, stats);
    private static final String SERIALIZATION_CHILDREN_OPEN_BRACKET = "<";
    public void writeTo(StreamOutput out) throws IOException {
    }
    public int hashCode() {
        ImmutableCacheStatsHolder other = (ImmutableCacheStatsHolder) o;
        }
        }
                    break;
            // Depth -1 corresponds to the dummy root node
        Node newRoot = new Node("", false, originalStatsRoot.getImmutableStats());
     * We use private methods allowing us to add children to/increment the stats for an existing node.
        }
                return false;
    }
        SortedMap<String, Node> children;
    Node getStatsRoot() {
    /**
        final Stack<Node> stack = new Stack<>();
    private void toXContentForLevels(int depth, Node current, XContentBuilder builder, Params params) throws IOException {
    }
                // Otherwise increment existing stats
    private boolean equalsHelper(Node thisNode, Node otherNode) {
                boolean isLeafNode = depth == indexOfLastLevel; // If this is the last level we aggregate, the new node should be a leaf
        int depth
        private Node(String dimensionValue, boolean isLeafNode, ImmutableCacheStats stats) {
import org.opensearch.common.annotation.ExperimentalApi;
import java.util.Collections;
        private final String dimensionValue;
    private void makeNodeUnmodifiable(Node node) {
                filtered.add(dimensionName);
import org.opensearch.core.common.io.stream.StreamOutput;
     * Unrecognized levels are ignored.
            return null;
        if (!dimensionNames.equals(other.dimensionNames) || !storeName.equals(other.storeName)) {
        out.writeString(SERIALIZATION_CHILDREN_OPEN_BRACKET);
import java.util.Stack;
        }
 */
            return false;
        // Also add the store name for the cache that produced the stats
        for (Node child : node.children.values()) {
        }
        if (dimensionNames.contains(allDimensions.get(depth))) {
        }
        this.dimensionNames = List.of(in.readStringArray());
            }
     * For this reason, in this function we have to build the new tree top down rather than bottom up.
    @Override
    }
            toXContentForLevels(-1, statsRoot, builder, params);
            DefaultCacheStatsHolder.Node child = childEntry.getValue();
        }
        out.writeBoolean(node.children.isEmpty()); // Write whether this is a leaf node
    private String[] getLevels(Params params) {
        this.statsRoot = aggregateByLevels(originalStatsRoot, originalDimensionNames);
import java.io.IOException;
    public long getTotalEvictions() {
            makeNodeUnmodifiable(child);
        node.stats.writeTo(out);
        if (depth >= 0) {
        }
            return stats;
}
        }
    public long getTotalHits() {
                parentInNewTree.addChild(dimensionValue, nodeInNewTree);
    Node aggregateByLevels(DefaultCacheStatsHolder.Node originalStatsRoot, List<String> originalDimensionNames) {
        DefaultCacheStatsHolder.Node originalStatsRoot,
            for (Node nextNode : current.children.values()) {
                this.children = EMPTY_CHILDREN_MAP;
        return getTotalStats().getEvictions();
    ) {
            }
            // If this node is in a level we want to aggregate, create a new dimension node with the same value and stats, and connect it to
     * fully recursively while also passing in a completed map of children nodes before constructing the parent node.
        String nextSymbol = in.readString();
    }
        return builder;
import org.opensearch.core.xcontent.XContentBuilder;
    // pkg-private for testing
        }
        Node statsRoot = readSingleNode(in);
        Map<String, Node> getChildren() {
            Node nodeInNewTree = parentInNewTree.children.get(dimensionValue);
            return originalDimensionNames;
        return getTotalStats().getMisses();
                    break;
        return filtered;
        for (String childValue : thisNode.getChildren().keySet()) {
