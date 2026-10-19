            return false;
 */
        String[] levels,
                    stack.peek().children.put(current.dimensionValue, current);
            if (nodeInNewTree == null) {
    private void writeNode(Node node, StreamOutput out) throws IOException {
    private static final String SERIALIZATION_BEGIN_NODE = "_";  
    Node getStatsRoot() {  
        makeNodeUnmodifiable(statsRoot);  
        return newRoot;
        return statsRoot.getStats();
            return originalDimensionNames;
        if (!thisNode.getStats().equals(otherNode.getStats())) {  
        return filtered;
        Node parentInNewTree,  
import org.opensearch.core.xcontent.XContentBuilder;  
    }
            }
        if (!filteredLevels.isEmpty()) {
     * The new tree only has dimensions matching the levels passed in.
            }
     * This should be ok because the resulting tree is unmodifiable after creation in the constructor.  
    static class Node {
    }  
                int indexOfLastLevel = allDimensions.indexOf(dimensionNames.get(dimensionNames.size() - 1));  
                // Create new node with stats matching the node from the original tree
        SortedMap<String, Node> children;  
    public ImmutableCacheStats getTotalStats() {
    }
        }
        out.writeStringArray(dimensionNames.toArray(new String[0]));
            if (!allChildrenMatch) {  
        out.writeString(SERIALIZATION_CHILDREN_CLOSE_BRACKET);  
        this.dimensionNames = List.of(in.readStringArray());  
        this.statsRoot = deserializeTree(in);
import java.util.List;  
}  
            aggregateByLevelsHelper(newRoot, child, originalDimensionNames, 0);
        // Also add the store name for the cache that produced the stats
    }  
        }
            // If this node is in a level we want to aggregate, create a new dimension node with the same value and stats, and connect it to  
            }
 * An object storing an immutable snapshot of an entire cache's stats. Accessible outside the cache itself.
    }
        boolean allChildrenMatch = true;  
        for (Map.Entry<String, DefaultCacheStatsHolder.Node> childEntry : currentInOriginalTree.children.entrySet()) {
    }
 * SPDX-License-Identifier: Apache-2.0
    ImmutableCacheStatsHolder(  
                toXContentForLevels(depth + 1, nextNode, builder, params);
    }
        this.dimensionNames = filterLevels(levels, originalDimensionNames);
        if (o == null || o.getClass() != ImmutableCacheStatsHolder.class) {
                    stack.pop();
    }
            if (current == null) {
            return dimensionValue;
    }
    ) {
/**
            builder.startObject(current.dimensionValue);
        private Node(String dimensionValue, boolean isLeafNode, ImmutableCacheStats stats) {
 * The OpenSearch Contributors require contributions made to  
        private final String dimensionValue;  
        out.writeString(SERIALIZATION_BEGIN_NODE);
    private void aggregateByLevelsHelper(
import org.opensearch.common.annotation.ExperimentalApi;
            return children;  
        // Aggregate from the original CacheStatsHolder according to the levels passed in.  
    /**
        return statsRoot;  
 *
        Node statsRoot = readSingleNode(in);  
        int depth  
    public long getTotalEvictions() {
    private static final String SERIALIZATION_DONE = "end";
        if (depth >= 0) {
        if (dimensionNames.contains(allDimensions.get(depth))) {
                    break;
        DefaultCacheStatsHolder.Node originalStatsRoot,
    final List<String> dimensionNames;
    }
                nodeInNewTree.incrementStats(currentInOriginalTree.getImmutableStats());
 * compatible open source license.
            } else {  
        }
        return levels.split(",");
    private List<String> filterLevels(String[] levels, List<String> originalDimensionNames) {
import java.util.Map;
    // Pkg-private for testing.
                    current = readSingleNode(in);
        String storeName
    // pkg-private for testing
        for (String dimensionName : originalDimensionNames) {
            // Depth -1 corresponds to the dummy root node  
            }  
                return false;
    // Root node of immutable snapshot of stats within a CacheStatsHolder, containing all the stats maintained by the cache.  
            switch (nextSymbol) {
    private Node deserializeTree(StreamInput in) throws IOException {  
    public int hashCode() {
        }
    }  
/*  
     */
    @Override
            builder.endObject();
        out.writeString(node.dimensionValue);  
        for (DefaultCacheStatsHolder.Node child : originalStatsRoot.children.values()) {
    }
                case SERIALIZATION_BEGIN_NODE:  
        ImmutableCacheStatsHolder other = (ImmutableCacheStatsHolder) o;
 */  
     */
        }  
        if (!dimensionNames.equals(other.dimensionNames) || !storeName.equals(other.storeName)) {
            Node nodeInNewTree = parentInNewTree.children.get(dimensionValue);  
        // contains the sum of its children's stats.  
        // Should be sufficient to hash based on the total stats value (found in the root node)  
                return null;  
        DefaultCacheStatsHolder.Node currentInOriginalTree,
        }
@ExperimentalApi
        } else {
    public static String STORE_NAME_FIELD = "store_name";
                // Otherwise increment existing stats  
    /**
    private Node readSingleNode(StreamInput in) throws IOException {  
    private static final String SERIALIZATION_CHILDREN_OPEN_BRACKET = "<";
        return equalsHelper(statsRoot, other.getStatsRoot());
        builder.field(STORE_NAME_FIELD, storeName);
        Node newRoot = new Node("", false, originalStatsRoot.getImmutableStats());  
                filtered.add(dimensionName);
        }
        if (depth == dimensionNames.size() - 1) {
            allChildrenMatch = equalsHelper(thisNode.children.get(childValue), otherNode.children.get(childValue));
        out.writeString(SERIALIZATION_CHILDREN_OPEN_BRACKET);
        }
    // A similar class to CacheStatsHolder.Node, which uses a SortedMap and holds immutable CacheStatsSnapshot as its stats.
     * @param allDimensions the list of all dimensions present in the original CacheStatsHolder which produced
            }
            toXContentForLevels(-1, statsRoot, builder, params);
        return getTotalStats().getItems();
    }
            current.getStats().toXContent(builder, params);
    private void toXContentForLevels(int depth, Node current, XContentBuilder builder, Params params) throws IOException {  
        }
    Node aggregateByLevels(DefaultCacheStatsHolder.Node originalStatsRoot, List<String> originalDimensionNames) {
    }
        private ImmutableCacheStats stats;
import java.util.TreeMap;
        }
        List<String> originalDimensionNames,  
        ImmutableCacheStats stats = new ImmutableCacheStats(in);  
     * Unrecognized levels are ignored.  
        out.writeBoolean(node.children.isEmpty()); // Write whether this is a leaf node
        String levels = params.param("level");
        String nextSymbol = in.readString();  
    public void writeTo(StreamOutput out) throws IOException {  
            makeNodeUnmodifiable(child);  
        }
    }  
        return getTotalStats().getEvictions();
        }  
            this.children.putIfAbsent(dimensionValue, child);  
        return current.stats;  
    }
        }  
                boolean isLeafNode = depth == indexOfLastLevel; // If this is the last level we aggregate, the new node should be a leaf
import java.util.ArrayList;  
        for (Map.Entry<String, Node> entry : node.children.entrySet()) {
        return new Node(dimensionValue, isLeafNode, stats);
        in.readString(); // Read and discard SERIALIZATION_BEGIN_NODE for the root node
            // the last parent node in the new tree. If it already exists, increment it instead.
        // Always show total stats, regardless of levels  
     * Because we may have to combine nodes that have the same dimension name, I don't think there's a clean way to aggregate
            nextSymbol = in.readString();
        if (otherNode == null) {  
        }
            aggregateByLevelsHelper(parentInNewTree, child, allDimensions, depth + 1);  
        return allChildrenMatch;
    final Node statsRoot;
            }
import java.io.IOException;
        }  
            if (isLeafNode) {
    public long getTotalHits() {
    private static final String SERIALIZATION_CHILDREN_CLOSE_BRACKET = ">";
        Node current = statsRoot;
        if (!node.children.isEmpty()) {
    // The dimension names for each level in this tree.  
            // Finally set the parent node to be this node for the next callers of this function  
                    stack.push(current);
 *  
                nodeInNewTree = new Node(dimensionValue, isLeafNode, currentInOriginalTree.getImmutableStats());  
        List<String> filteredLevels = filterLevels(getLevels(params), dimensionNames);  
        node.stats.writeTo(out);
    }
                // node
            } else {
            out.writeString(entry.getKey());  
                case SERIALIZATION_CHILDREN_CLOSE_BRACKET:  
            if (levelsList.contains(dimensionName)) {  
        if (levels == null) {
import java.util.Arrays;
     * Filters out levels that aren't in dimensionNames, and orders the resulting list to match the order in dimensionNames.
        Node current = statsRoot;
    final String storeName;  
    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            node.children = Collections.unmodifiableSortedMap(node.children);  
            stats = ImmutableCacheStats.addSnapshots(stats, toIncrement);
            parentInNewTree = nodeInNewTree;
                    break;
        return Objects.hash(statsRoot.stats, dimensionNames);
 * this file be licensed under the Apache-2.0 license or a
        }
     * For this reason, in this function we have to build the new tree top down rather than bottom up.
 * @opensearch.experimental
        public ImmutableCacheStats getStats() {  
        return getTotalStats().getHits();  
        }
        public String getDimensionValue() {
        }
    }  
        if (levels == null) {  
     */
import org.opensearch.core.common.io.stream.StreamOutput;  
    @Override
        }  
            // This is a leaf node  
        for (Node child : node.children.values()) {
        getTotalStats().toXContent(builder, params);
        // The stats for this node. If a leaf node, corresponds to the stats for this combination of dimensions; if not,
            return false;
     *
            }  
            writeNode(entry.getValue(), out);
            this.dimensionValue = dimensionValue;
            return false;  
        return builder;  
        }
                this.children = new TreeMap<>();
        return getTotalStats().getSizeInBytes();  
        }
            this.stats = stats;  
        return statsRoot;
        this.storeName = in.readString();
     *                      the CacheStatsHolder.Node object we are traversing.  
                parentInNewTree.addChild(dimensionValue, nodeInNewTree);
        private void addChild(String dimensionValue, Node child) {
    // Values used for serializing/deserializing the tree.  
        assert filteredLevels.equals(dimensionNames);
        }  
    public boolean equals(Object o) {  
        this.storeName = storeName;  
            return false;
        stack.push(statsRoot);
import java.util.Collections;
        for (String dimensionValue : dimensionValues) {  
        String dimensionValue = in.readString();
        List<String> levelsList = Arrays.asList(levels);  
        out.writeString(storeName);
import org.opensearch.core.common.io.stream.Writeable;
            for (Node nextNode : current.children.values()) {
import org.opensearch.core.xcontent.ToXContent;
        // Map from dimensionValue to the Node for that dimension value. Not final so we can set it to be unmodifiable before we are done in
        // The dimension names for this immutable snapshot should reflect the levels we aggregate in the snapshot
        List<String> allDimensions,
                this.children = EMPTY_CHILDREN_MAP;
        // the constructor.
    }
        this.statsRoot = aggregateByLevels(originalStatsRoot, originalDimensionNames);
    }
        final Stack<Node> stack = new Stack<>();
        out.writeString(SERIALIZATION_DONE);
import org.opensearch.core.common.io.stream.StreamInput;
            return stats;
    public ImmutableCacheStatsHolder(StreamInput in) throws IOException {
    public long getTotalSizeInBytes() {
        }  
    private void makeNodeUnmodifiable(Node node) {
    // The name of the cache type producing these stats. Returned in API response.
            builder.startObject(dimensionNames.get(depth + 1));  
        private void incrementStats(ImmutableCacheStats toIncrement) {  
    private boolean equalsHelper(Node thisNode, Node otherNode) {
        }  
    }
    private String[] getLevels(Params params) {  
            String dimensionValue = currentInOriginalTree.getDimensionValue();
        if (depth >= 0) {
            builder.endObject();
            DefaultCacheStatsHolder.Node child = childEntry.getValue();
import java.util.Stack;
package org.opensearch.common.cache.stats;
    public ImmutableCacheStats getStatsForDimensionValues(List<String> dimensionValues) {
        while (!nextSymbol.equals(SERIALIZATION_DONE)) {
    }
     * The levels passed in must be in the proper order, as they would be in the output of filterLevels().  
        return getTotalStats().getMisses();
        }
    }
        makeNodeUnmodifiable(statsRoot);
        boolean isLeafNode = in.readBoolean();
    }  
import java.util.SortedMap;  
     * We use private methods allowing us to add children to/increment the stats for an existing node.
        private static final SortedMap<String, Node> EMPTY_CHILDREN_MAP = Collections.unmodifiableSortedMap(new TreeMap<>());
            current = current.children.get(dimensionValue);
    /**  
     * Returns a new tree containing the stats aggregated by the levels passed in.
        for (String childValue : thisNode.getChildren().keySet()) {
import java.util.Objects;
        List<String> filtered = new ArrayList<>();
    public long getTotalMisses() {  
                case SERIALIZATION_CHILDREN_OPEN_BRACKET:  
public class ImmutableCacheStatsHolder implements Writeable, ToXContent {
    public long getTotalItems() {  
     * fully recursively while also passing in a completed map of children nodes before constructing the parent node.  
        }
        Map<String, Node> getChildren() {
    ) {
    }
            return null;  
        writeNode(statsRoot, out);  
