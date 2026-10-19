    /**
            @Override
            }
        return handleStarNode();
}
        if (matchStarTreeNodeTypeOrNull(new FixedLengthStarTreeNode(in, tempHigh), StarTreeNodeType.NULL) != null) {
                        return matchNextHighest ? midNode : null;
 * Fixed Length implementation of {@link StarTreeNode}.
     * @param comparator : Comparator (LONG or UNSIGNED_LONG) to compare the dimension values
            starNodeId = tempLow;
                        FixedLengthStarTreeNode nodeGreaterThanMid = new FixedLengthStarTreeNode(in, tempLow);
            return INVALID_ID;
     * Reads an integer value from the specified offset in the node's data.
                    throw new UncheckedIOException(e);
/**
                FixedLengthStarTreeNode highStarTreeNode = binarySearchChild(high, false, lowStarTreeNode, comparator);
 * @opensearch.experimental
        return resultStarTreeNode;
    @Override
    }
    public int getStartDocId() throws IOException {
        }
            // if the current node is star node, increment the low to reduce the search space
            long midDimensionValue = midNode.getDimensionValue();
            int mid = low + (high - low) / 2;
            tempLow++;
        long dimensionValue,
     * @throws IOException If there's an error reading from the input
     */
        // there will be no children for leaf nodes
            @Override
     * Reads a byte value from the specified offset in the node's data.
    }
     * @throws IOException If an I/O error occurs during the operation.
    }
                if (highStarTreeNode != null) {
        Comparator<Long> comparator = dimensionFilterMapper.comparator();
                    tempHigh = mid - 1;
     * @return The star node if found, null otherwise
        starNodeId = nullNodeId = Integer.MIN_VALUE;
 * - Fixed-size serialization for each node, allowing for efficient random access
        if (matchStarTreeNodeTypeOrNull(new FixedLengthStarTreeNode(in, high), StarTreeNodeType.NULL) != null) {
            }
        }
        }
                        return matchNextHighest ? null : midNode;
package org.opensearch.index.compositeindex.datacube.startree.fileformats.node;
    private FixedLengthStarTreeNode binarySearchChild(
            public void remove() {
        if (comparator.compare(low, high) <= 0) {
    public byte getStarTreeNodeType() throws IOException {
 * enabling direct access to node properties without parsing the entire node structure.
     *
            );
                } else {  // Going to the left from mid to search next
     *
        int high = getInt(LAST_CHILD_ID_OFFSET);
            } else if (compare < 0) {
        return new Iterator<>() {
    @Override
        int starNodeId, nullNodeId;
            long midDimensionValue = midNode.getDimensionValue();
 * The node structure includes the methods to access all the constructs of InMemoryTreeNode.
     * @param dimensionValue The dimension value to search for
/*
    @Override
        return getByte(STAR_NODE_TYPE_OFFSET);
import java.util.Iterator;
            }
            } else {
        if (null != dimensionValue) {
    public FixedLengthStarTreeNode(RandomAccessInput in, int nodeId) throws IOException {
            int compare = comparator.compare(midDimensionValue, dimensionValue);
    }
    public StarTreeNode getChildStarNode() throws IOException {
    public int getAggregatedDocId() throws IOException {
            // Start the binary search from node after the last matched as low.
        }
    public static final int NUM_LONG_SERIALIZABLE_FIELDS = 1;
 * Key features:
                dimensionValue,
    public static final long SERIALIZABLE_DATA_SIZE_IN_BYTES = (Integer.BYTES * NUM_INT_SERIALIZABLE_FIELDS) + (Long.BYTES
import org.opensearch.index.compositeindex.datacube.DimensionDataType;
    }
        }
                tempLow = lastMatchedNodeId + 1;
                    tempLow = mid + 1;
     * Number of byte fields in the serializable data
    }
    }
     * @return : Matched node or null.
import org.opensearch.search.startree.StarTreeNodeCollector;
 * - Iteration over child nodes
    /**
            int compare = comparator.compare(midDimensionValue, dimensionValue);
                dimensionFilterMapper == null ? DimensionDataType.LONG::compare : dimensionFilterMapper.comparator()
                return null;
 * - Binary search capability for finding child nodes
    }
    }
                }
     * Number of long fields in the serializable data
    public int getNumChildren() throws IOException {
     */
    }
    /**
        }
 * compatible open source license.
        FixedLengthStarTreeNode firstNode = new FixedLengthStarTreeNode(in, firstChildId);
        }
     * The input source for reading node data
        return null;
     * Performs a binary search to find a child node with the given dimension value.
    private byte getByte(int fieldOffset) throws IOException {
     */
    @Override
            FixedLengthStarTreeNode midNode = new FixedLengthStarTreeNode(in, mid);
    public Iterator<FixedLengthStarTreeNode> getChildrenIterator() throws IOException {
import java.util.Comparator;
     */
    private static FixedLengthStarTreeNode matchStarTreeNodeTypeOrNull(FixedLengthStarTreeNode firstNode, StarTreeNodeType starTreeNodeType)
        return getInt(AGGREGATE_DOC_ID_OFFSET);
    @Override
     * Reads a long value from the specified offset in the node's data.
                if (compare < 0) { // Going to the right from mid to search next
        return matchStarTreeNodeTypeOrNull(firstNode, StarTreeNodeType.STAR);
            } else {
                throw new UnsupportedOperationException();
     * @param comparator : Comparator (LONG or UNSIGNED_LONG) to compare the dimension values
                        collector.collectStarTreeNode(new FixedLengthStarTreeNode(in, lowNodeId));
                                                                                                 // node for that dimension.
    private FixedLengthStarTreeNode handleStarNode() throws IOException {
        Comparator<Long> comparator
    /**
        if (lastMatchedNode instanceof FixedLengthStarTreeNode fixedLengthNode) {
            } else {
    static final int LAST_CHILD_ID_OFFSET = FIRST_CHILD_ID_OFFSET + Integer.BYTES;
    /**
 * this file be licensed under the Apache-2.0 license or a
            if (compare == 0) {
        if (firstNode.getStarTreeNodeType() == starTreeNodeType.getValue()) {
                }
            int lastMatchedNodeId = fixedLengthNode.nodeId();
                low = mid + 1;
    ) throws IOException {
        if (firstChildId == INVALID_ID) {
    }
            if ((lastMatchedNodeId + 1) <= tempHigh) {
        }
        while (low <= high) {
        return getInt(START_DOC_ID_OFFSET);
     */
        // if the current node is null node, decrement the tempHigh to reduce the search space
    @Override
        // if the current node is star node, increment the tempLow to reduce the search space
     */
        if (lastMatchedNode instanceof FixedLengthStarTreeNode fixedLengthNode) {
            @Override
        } else {
            nullNodeId = tempHigh;
     * @throws IOException If there's an error reading from the input
        int tempLow = low;
            private final int lastChildId = getInt(LAST_CHILD_ID_OFFSET);
    @Override
     * Handles the special case of a star node.
            private int currentChildId = firstChildId;
            return null;
            int lastMatchedNodeId = fixedLengthNode.nodeId();
    /**
                    }
 *
    // Byte offsets for each field in the serialized data
     * @param lastMatchedNode : If not null, we begin the binary search from the node after this.
     */
    }
            }
        firstChildId = getInt(FIRST_CHILD_ID_OFFSET);
                    }
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;
    static final int STAR_NODE_TYPE_OFFSET = AGGREGATE_DOC_ID_OFFSET + Integer.BYTES;
    public boolean isLeaf() {
     */
    }
            int mid = tempLow + (tempHigh - tempLow) / 2;
    public int getChildDimensionId() throws IOException {
    /**
    /**
        return in.readLong(nodeId * SERIALIZABLE_DATA_SIZE_IN_BYTES + fieldOffset);
        int tempHigh = high;
    }
    public static final int INVALID_ID = -1;
     *
     * @param dimensionValue : The dimension to match.
     */
public class FixedLengthStarTreeNode implements StarTreeNode {
            }
 */
     * @param fieldOffset The offset of the field to read
        boolean matchNextHighest,
                    } else {
                    for (int lowNodeId = lowStarTreeNode.nodeId(); lowNodeId <= highStarTreeNode.nodeId(); ++lowNodeId) {
    @Override
    public int nodeId() {
    }
     *
 * <p>
            return 0;
        * NUM_LONG_SERIALIZABLE_FIELDS) + (NUM_BYTE_SERIALIZABLE_FIELDS * Byte.BYTES);
    public long getDimensionValue() throws IOException {
        throws IOException {
     * @param fieldOffset The offset of the field to read
    public static final int NUM_INT_SERIALIZABLE_FIELDS = 6;
                return midNode;
            FixedLengthStarTreeNode midNode = new FixedLengthStarTreeNode(in, mid);
            } else {
     * @return The integer value at the specified offset
     * Constructs a FixedLengthStarTreeNode.
        }
            resultStarTreeNode = binarySearchChild(
    /**
        int high = getInt(LAST_CHILD_ID_OFFSET);
    @Override
    }
    private final int firstChildId;
    RandomAccessInput in;
    @Override
     * @throws IOException :
        this.in = in;
                return midNode;
        DimensionFilterMapper dimensionFilterMapper
            if (compare == 0) {
     */
 *
        } else if (matchStarTreeNodeTypeOrNull(new FixedLengthStarTreeNode(in, low), StarTreeNodeType.STAR) != null) {
                        if (comparator.compare(nodeGreaterThanMid.getDimensionValue(), dimensionValue) > 0) {
    /**
            tempHigh--;
                        FixedLengthStarTreeNode nodeLessThanMid = new FixedLengthStarTreeNode(in, tempHigh);
     * @throws IOException If there's an error reading from the input
        return getInt(DIMENSION_ID_OFFSET);
    @Override
 * The OpenSearch Contributors require contributions made to
     *
    }
        StarTreeNode lastMatchedNode,
    /**
    /**
        }
                    } else {
    private FixedLengthStarTreeNode binarySearchChild(long dimensionValue, StarTreeNode lastMatchedNode, Comparator<Long> comparator)
                    collector.collectStarTreeNode(lowStarTreeNode);
                    // We are going out of bounds for this dimension on the right side.
     */
    public static final int NUM_BYTE_SERIALIZABLE_FIELDS = 1;
    }
                            return matchNextHighest ? midNode : nodeLessThanMid;
            return in.readInt(firstChildId * SERIALIZABLE_DATA_SIZE_IN_BYTES);
    }
        StarTreeNode lastMatchedChild,
    static final int FIRST_CHILD_ID_OFFSET = STAR_NODE_TYPE_OFFSET + Byte.BYTES;
     * @param nodeId The ID of this node
            public FixedLengthStarTreeNode next() {
        };
        return in.readInt(nodeId * SERIALIZABLE_DATA_SIZE_IN_BYTES + fieldOffset);
                        }
                    }
     * The ID of this node
    }
    }
    }
            high--;
 * SPDX-License-Identifier: Apache-2.0
                lastMatchedChild,
        if (matchStarTreeNodeTypeOrNull(new FixedLengthStarTreeNode(in, tempLow), StarTreeNodeType.STAR) != null) {
    /**
import java.io.IOException;
     * @param in     The RandomAccessInput to read node data from
        return null;
            if (lowStarTreeNode != null) {
    public int getDimensionId() throws IOException {
     * The ID of the first child of this node
     */
     * @param fieldOffset The offset of the field to read
                }
    private final int nodeId;
            return null;
        }
     * Constant representing an invalid node ID
import java.io.UncheckedIOException;
            public boolean hasNext() {
        return getInt(END_DOC_ID_OFFSET);
                    if (tempHigh < low || tempHigh == starNodeId) {
     * @param matchNextHighest : If true then we try to return @dimensionValue or the next Highest. Else, we return @dimensionValue or the next Lowest.
     * Total size in bytes of the serializable data for each node
        return getLong(DIMENSION_VALUE_OFFSET);
            return firstNode;
        }
    public StarTreeNode getChildForDimensionValue(
     * Checks if the given node matches the specified StarTreeNodeType.
    static final int DIMENSION_VALUE_OFFSET = DIMENSION_ID_OFFSET + Integer.BYTES;
     */
     * @return The long value at the specified offset
            // Start the binary search from node after the last matched as low.
        if (firstChildId == INVALID_ID) {
     * @param lastMatchedNode : If not null, we begin the binary search from the node after this.
 */
     * @param firstNode The FixedLengthStarTreeNode to check.
        int low = firstChildId;
            }
    /**
     * @throws IOException If there's an error reading from the input
    static final int AGGREGATE_DOC_ID_OFFSET = END_DOC_ID_OFFSET + Integer.BYTES;
     * @return The child node if found, null otherwise
        this.nodeId = nodeId;
     * Number of integer fields in the serializable data
 * <p>
 * - Support for star nodes, null nodes and other default nodes
    static final int END_DOC_ID_OFFSET = START_DOC_ID_OFFSET + Integer.BYTES;
    ) throws IOException {
                    if (tempLow > high || tempLow == nullNodeId) {
import org.apache.lucene.store.RandomAccessInput;
        return firstChildId == INVALID_ID;
        }
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNodeType;
    static final int START_DOC_ID_OFFSET = DIMENSION_VALUE_OFFSET + Long.BYTES;
                return currentChildId <= lastChildId;
 * This class represents a node in a star tree with a fixed-length serialization format.
     * @return The firstNode if its type matches the targetType, null otherwise.
 * <p>
        Long dimensionValue,
    public int getEndDocId() throws IOException {
                low = lastMatchedNodeId + 1;
 *
     */
     */
                } catch (IOException e) {
    @Override
            if ((lastMatchedNodeId + 1) <= high) {
    /**
            return getInt(LAST_CHILD_ID_OFFSET) - firstChildId + 1;
                try {
        while (tempLow <= tempHigh) {
                        if (comparator.compare(nodeLessThanMid.getDimensionValue(), dimensionValue) < 0) {
                    // We are going out of bounds for this dimension on the left side.
     * @param starTreeNodeType The StarTreeNodeType to match against.
            }
     *
                        }
import org.opensearch.search.startree.filter.provider.DimensionFilterMapper;
 * It provides efficient storage and retrieval of node information using a RandomAccessInput.
    /**
    static final int DIMENSION_ID_OFFSET = 0;
     * @return The byte value at the specified offset
        // if the current node is null node, decrement the high to reduce the search space
        StarTreeNode resultStarTreeNode = null;
        throws IOException {
            FixedLengthStarTreeNode lowStarTreeNode = binarySearchChild(low, true, null, comparator);
            }
     *
        if (isLeaf()) {
        int low = firstChildId;
            low++;
        } else {
     *
        throws IOException {
        } else {
    @Override
                } else if (comparator.compare(lowStarTreeNode.getDimensionValue(), high) <= 0) { // Low StarTreeNode is the last default//
     */
     * @throws IOException If there's an error reading from the input
                high = mid - 1;
     * @throws IOException If there's an error reading from the input
        return nodeId;
        return in.readByte(nodeId * SERIALIZABLE_DATA_SIZE_IN_BYTES + fieldOffset);
                    return new FixedLengthStarTreeNode(in, currentChildId++);
    private long getLong(int fieldOffset) throws IOException {
                            return matchNextHighest ? nodeGreaterThanMid : midNode;
 * The class uses specific byte offsets for each field in the serialized format,
                return null;
    public void collectChildrenInRange(long low, long high, StarTreeNodeCollector collector, DimensionFilterMapper dimensionFilterMapper)
    private int getInt(int fieldOffset) throws IOException {
