        return null;
            } else {  
                return null;
    public int nodeId() {
     * @param dimensionValue The dimension value to search for
            FixedLengthStarTreeNode midNode = new FixedLengthStarTreeNode(in, mid);
    /**  
     * @param fieldOffset The offset of the field to read  
                            return matchNextHighest ? midNode : nodeLessThanMid;
    /**
    }  
     */
     * @return : Matched node or null.  
        int low = firstChildId;
 * - Fixed-size serialization for each node, allowing for efficient random access  
        DimensionFilterMapper dimensionFilterMapper  
     * Performs a binary search to find a child node with the given dimension value.
    }
import java.util.Comparator;  
}
     */
        int high = getInt(LAST_CHILD_ID_OFFSET);  
        if (firstChildId == INVALID_ID) {
     * Handles the special case of a star node.
        throws IOException {  
    }
            return 0;
        }
                    } else {
    /**
                return midNode;  
import java.util.Iterator;
    private long getLong(int fieldOffset) throws IOException {
    static final int DIMENSION_ID_OFFSET = 0;
     */  
        FixedLengthStarTreeNode firstNode = new FixedLengthStarTreeNode(in, firstChildId);
        return firstChildId == INVALID_ID;
        // if the current node is star node, increment the tempLow to reduce the search space  
        if (matchStarTreeNodeTypeOrNull(new FixedLengthStarTreeNode(in, high), StarTreeNodeType.NULL) != null) {
            FixedLengthStarTreeNode midNode = new FixedLengthStarTreeNode(in, mid);
    }  
        }
            int mid = tempLow + (tempHigh - tempLow) / 2;
        return getInt(END_DOC_ID_OFFSET);  
    private FixedLengthStarTreeNode binarySearchChild(long dimensionValue, StarTreeNode lastMatchedNode, Comparator<Long> comparator)
    }  
                            return matchNextHighest ? nodeGreaterThanMid : midNode;
    static final int STAR_NODE_TYPE_OFFSET = AGGREGATE_DOC_ID_OFFSET + Integer.BYTES;  
 * Key features:
                tempLow = lastMatchedNodeId + 1;  
    @Override
    ) throws IOException {
        }  
 * The OpenSearch Contributors require contributions made to  
                    if (tempLow > high || tempLow == nullNodeId) {  
    }
    }
            starNodeId = tempLow;
        starNodeId = nullNodeId = Integer.MIN_VALUE;
     * @param lastMatchedNode : If not null, we begin the binary search from the node after this.
    }
        if (lastMatchedNode instanceof FixedLengthStarTreeNode fixedLengthNode) {
                        }
    public int getChildDimensionId() throws IOException {  
    /**
            return getInt(LAST_CHILD_ID_OFFSET) - firstChildId + 1;
                low = lastMatchedNodeId + 1;  
import org.opensearch.index.compositeindex.datacube.DimensionDataType;
     * Reads a long value from the specified offset in the node's data.
        if (lastMatchedNode instanceof FixedLengthStarTreeNode fixedLengthNode) {
     * @param fieldOffset The offset of the field to read
        return nodeId;  
import org.opensearch.search.startree.filter.provider.DimensionFilterMapper;
    @Override
    @Override
     * The ID of the first child of this node  
                } else {  // Going to the left from mid to search next
            if (lowStarTreeNode != null) {
    public int getStartDocId() throws IOException {  
        firstChildId = getInt(FIRST_CHILD_ID_OFFSET);
            nullNodeId = tempHigh;
import org.apache.lucene.store.RandomAccessInput;  
     * Number of byte fields in the serializable data
 * This class represents a node in a star tree with a fixed-length serialization format.  
    /**
     * @return The byte value at the specified offset  
            long midDimensionValue = midNode.getDimensionValue();  
            // Start the binary search from node after the last matched as low.
                return null;
        this.in = in;
    public long getDimensionValue() throws IOException {
            } else {
    public static final int NUM_BYTE_SERIALIZABLE_FIELDS = 1;
    private FixedLengthStarTreeNode handleStarNode() throws IOException {  
            }  
                } else if (comparator.compare(lowStarTreeNode.getDimensionValue(), high) <= 0) { // Low StarTreeNode is the last default//
            return null;  
                return currentChildId <= lastChildId;
    @Override
                        return matchNextHighest ? null : midNode;
        // if the current node is null node, decrement the tempHigh to reduce the search space
    public StarTreeNode getChildStarNode() throws IOException {
    }  
    /**  
        }  
    public void collectChildrenInRange(long low, long high, StarTreeNodeCollector collector, DimensionFilterMapper dimensionFilterMapper)
 * Fixed Length implementation of {@link StarTreeNode}.
 * It provides efficient storage and retrieval of node information using a RandomAccessInput.
        } else {  
    public boolean isLeaf() {  
    /**  
        if (null != dimensionValue) {
    @Override  
     * @param starTreeNodeType The StarTreeNodeType to match against.  
    public byte getStarTreeNodeType() throws IOException {
     */  
    static final int FIRST_CHILD_ID_OFFSET = STAR_NODE_TYPE_OFFSET + Byte.BYTES;
                    }  
     *
        return getByte(STAR_NODE_TYPE_OFFSET);  
                return midNode;
    /**
        return getInt(AGGREGATE_DOC_ID_OFFSET);
                    return new FixedLengthStarTreeNode(in, currentChildId++);
                        FixedLengthStarTreeNode nodeLessThanMid = new FixedLengthStarTreeNode(in, tempHigh);
        return getInt(START_DOC_ID_OFFSET);
    public StarTreeNode getChildForDimensionValue(  
                lastMatchedChild,
     */
            return in.readInt(firstChildId * SERIALIZABLE_DATA_SIZE_IN_BYTES);
        } else {  
        Comparator<Long> comparator
     * Constant representing an invalid node ID
 * this file be licensed under the Apache-2.0 license or a
    /**  
        if (comparator.compare(low, high) <= 0) {
                    } else {
/*  
     *
                        return matchNextHighest ? midNode : null;  
        return in.readInt(nodeId * SERIALIZABLE_DATA_SIZE_IN_BYTES + fieldOffset);  
        }
        }  
    }
 *  
        long dimensionValue,
        return in.readLong(nodeId * SERIALIZABLE_DATA_SIZE_IN_BYTES + fieldOffset);
            @Override
            int compare = comparator.compare(midDimensionValue, dimensionValue);
public class FixedLengthStarTreeNode implements StarTreeNode {
    private final int firstChildId;
    }
 * The node structure includes the methods to access all the constructs of InMemoryTreeNode.
            long midDimensionValue = midNode.getDimensionValue();  
        }
        } else {
     * @throws IOException If there's an error reading from the input
    /**
 *
     * @throws IOException If there's an error reading from the input
        return new Iterator<>() {
    static final int LAST_CHILD_ID_OFFSET = FIRST_CHILD_ID_OFFSET + Integer.BYTES;
        // there will be no children for leaf nodes
                        }  
        }  
     */  
        StarTreeNode lastMatchedNode,  
package org.opensearch.index.compositeindex.datacube.startree.fileformats.node;
    static final int AGGREGATE_DOC_ID_OFFSET = END_DOC_ID_OFFSET + Integer.BYTES;
    static final int START_DOC_ID_OFFSET = DIMENSION_VALUE_OFFSET + Long.BYTES;  
    private int getInt(int fieldOffset) throws IOException {
                    throw new UncheckedIOException(e);  
            low++;  
 * enabling direct access to node properties without parsing the entire node structure.  
                    if (tempHigh < low || tempHigh == starNodeId) {
        while (tempLow <= tempHigh) {  
            } else {
     * @param firstNode The FixedLengthStarTreeNode to check.
                low = mid + 1;
                    // We are going out of bounds for this dimension on the left side.
     * Number of integer fields in the serializable data
     * @throws IOException :
import java.io.UncheckedIOException;
            int mid = low + (high - low) / 2;
     * @param lastMatchedNode : If not null, we begin the binary search from the node after this.
        int high = getInt(LAST_CHILD_ID_OFFSET);
     * @param fieldOffset The offset of the field to read
     */
            public boolean hasNext() {  
 * SPDX-License-Identifier: Apache-2.0
            // if the current node is star node, increment the low to reduce the search space
     */
    /**
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;
 * - Binary search capability for finding child nodes
    }  
        }  
                }
        Long dimensionValue,
            }
    public int getNumChildren() throws IOException {  
    }  
        int low = firstChildId;  
     * Number of long fields in the serializable data  
        }
                    collector.collectStarTreeNode(lowStarTreeNode);  
     * Reads a byte value from the specified offset in the node's data.  
                                                                                                 // node for that dimension.
 * compatible open source license.
        return matchStarTreeNodeTypeOrNull(firstNode, StarTreeNodeType.STAR);
        this.nodeId = nodeId;  
                dimensionFilterMapper == null ? DimensionDataType.LONG::compare : dimensionFilterMapper.comparator()  
                    tempHigh = mid - 1;  
     *  
            private final int lastChildId = getInt(LAST_CHILD_ID_OFFSET);  
    }
            }
        return handleStarNode();
            } else if (compare < 0) {
     */  
    private byte getByte(int fieldOffset) throws IOException {  
    }
     * @param matchNextHighest : If true then we try to return @dimensionValue or the next Highest. Else, we return @dimensionValue or the next Lowest.  
            tempLow++;  
    @Override
            return null;
     * @param comparator : Comparator (LONG or UNSIGNED_LONG) to compare the dimension values  
     */
        return resultStarTreeNode;  
        } else if (matchStarTreeNodeTypeOrNull(new FixedLengthStarTreeNode(in, low), StarTreeNodeType.STAR) != null) {
        if (firstNode.getStarTreeNodeType() == starTreeNodeType.getValue()) {  
 * <p>
        StarTreeNode lastMatchedChild,
        while (low <= high) {  
     *
                throw new UnsupportedOperationException();  
    public Iterator<FixedLengthStarTreeNode> getChildrenIterator() throws IOException {  
            );
    private FixedLengthStarTreeNode binarySearchChild(  
 * <p>
        // if the current node is null node, decrement the high to reduce the search space  
     * @return The firstNode if its type matches the targetType, null otherwise.
     * Reads an integer value from the specified offset in the node's data.
            }
                    // We are going out of bounds for this dimension on the right side.
    public static final int NUM_INT_SERIALIZABLE_FIELDS = 6;  
     */  
            if ((lastMatchedNodeId + 1) <= tempHigh) {
                        collector.collectStarTreeNode(new FixedLengthStarTreeNode(in, lowNodeId));
                FixedLengthStarTreeNode highStarTreeNode = binarySearchChild(high, false, lowStarTreeNode, comparator);
                if (compare < 0) { // Going to the right from mid to search next  
        * NUM_LONG_SERIALIZABLE_FIELDS) + (NUM_BYTE_SERIALIZABLE_FIELDS * Byte.BYTES);
            if (compare == 0) {  
        Comparator<Long> comparator = dimensionFilterMapper.comparator();
                    tempLow = mid + 1;
     * @param dimensionValue : The dimension to match.
 *
    @Override
        return getInt(DIMENSION_ID_OFFSET);  
     * @return The integer value at the specified offset
        int starNodeId, nullNodeId;  
 * @opensearch.experimental
     * Checks if the given node matches the specified StarTreeNodeType.  
    // Byte offsets for each field in the serialized data  
    @Override
     *
     * @return The child node if found, null otherwise
     */  
     */
                    for (int lowNodeId = lowStarTreeNode.nodeId(); lowNodeId <= highStarTreeNode.nodeId(); ++lowNodeId) {
                        FixedLengthStarTreeNode nodeGreaterThanMid = new FixedLengthStarTreeNode(in, tempLow);  
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNodeType;  
        };
        return null;
    static final int END_DOC_ID_OFFSET = START_DOC_ID_OFFSET + Integer.BYTES;
    private static FixedLengthStarTreeNode matchStarTreeNodeTypeOrNull(FixedLengthStarTreeNode firstNode, StarTreeNodeType starTreeNodeType)
        if (isLeaf()) {  
                if (highStarTreeNode != null) {  
                }
    public int getDimensionId() throws IOException {
     *  
            high--;
     * The ID of this node
     */
    /**  
    @Override
            private int currentChildId = firstChildId;
        }
    }
     */
            tempHigh--;
                dimensionValue,
        int tempLow = low;
        boolean matchNextHighest,
    ) throws IOException {
        StarTreeNode resultStarTreeNode = null;
 * - Support for star nodes, null nodes and other default nodes
    public static final int NUM_LONG_SERIALIZABLE_FIELDS = 1;
 */  
    public FixedLengthStarTreeNode(RandomAccessInput in, int nodeId) throws IOException {
    @Override
     */  
    public static final int INVALID_ID = -1;
            FixedLengthStarTreeNode lowStarTreeNode = binarySearchChild(low, true, null, comparator);  
                        if (comparator.compare(nodeLessThanMid.getDimensionValue(), dimensionValue) < 0) {  
 * <p>
     * @return The long value at the specified offset
        if (matchStarTreeNodeTypeOrNull(new FixedLengthStarTreeNode(in, tempHigh), StarTreeNodeType.NULL) != null) {  
        return getLong(DIMENSION_VALUE_OFFSET);
                    }  
        return in.readByte(nodeId * SERIALIZABLE_DATA_SIZE_IN_BYTES + fieldOffset);
        throws IOException {
    static final int DIMENSION_VALUE_OFFSET = DIMENSION_ID_OFFSET + Integer.BYTES;
            @Override
     * The input source for reading node data
    @Override  
                try {  
     *
    }
     * @param nodeId The ID of this node
                    }
        if (firstChildId == INVALID_ID) {
     * @throws IOException If there's an error reading from the input
        }
    /**
            // Start the binary search from node after the last matched as low.
            if ((lastMatchedNodeId + 1) <= high) {
            }  
            int lastMatchedNodeId = fixedLengthNode.nodeId();  
            public FixedLengthStarTreeNode next() {
    }  
            }
        throws IOException {
     * @throws IOException If there's an error reading from the input
            }
    public int getAggregatedDocId() throws IOException {
            int lastMatchedNodeId = fixedLengthNode.nodeId();  
    RandomAccessInput in;
     * Constructs a FixedLengthStarTreeNode.
            @Override
import org.opensearch.search.startree.StarTreeNodeCollector;
 * - Iteration over child nodes  
                }
        int tempHigh = high;
            } else {
            if (compare == 0) {
    /**
     * @throws IOException If an I/O error occurs during the operation.
     * @param in     The RandomAccessInput to read node data from  
    public int getEndDocId() throws IOException {
    }  
            return INVALID_ID;
     * @param comparator : Comparator (LONG or UNSIGNED_LONG) to compare the dimension values
     * @throws IOException If there's an error reading from the input  
                        if (comparator.compare(nodeGreaterThanMid.getDimensionValue(), dimensionValue) > 0) {
    }
 * The class uses specific byte offsets for each field in the serialized format,
            resultStarTreeNode = binarySearchChild(  
                } catch (IOException e) {
     * @throws IOException If there's an error reading from the input
        }
        if (matchStarTreeNodeTypeOrNull(new FixedLengthStarTreeNode(in, tempLow), StarTreeNodeType.STAR) != null) {
     * @return The star node if found, null otherwise  
            public void remove() {
import java.io.IOException;
 */  
/**  
                high = mid - 1;
    /**  
    }
    }  
            int compare = comparator.compare(midDimensionValue, dimensionValue);
    public static final long SERIALIZABLE_DATA_SIZE_IN_BYTES = (Integer.BYTES * NUM_INT_SERIALIZABLE_FIELDS) + (Long.BYTES  
    @Override  
     *
            }
            return firstNode;
    @Override
    /**  
     * Total size in bytes of the serializable data for each node
    private final int nodeId;  
