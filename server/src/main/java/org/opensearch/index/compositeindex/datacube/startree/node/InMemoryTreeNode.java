     * The ending document id (exclusive) associated with this star-tree node.  
    }
        this.dimensionValue = ALL;
    public boolean hasChild() {  
     * A map containing the child nodes of this star-tree node, keyed by their dimension id.
        this.childDimensionId = childDimensionId;  
    public InMemoryTreeNode() {
        }  
 */  
import java.util.LinkedHashMap;  
/**
     */  
        this.endDocId = ALL;
     */
        this.nodeType = (byte) 0;  
        this.children = new LinkedHashMap<>();
    /**
    }  
        return aggregatedDocId;
     */  
     * The dimension id for the dimension (field) associated with this star-tree node.
    public InMemoryTreeNode getChildStarNode() {  
    /**
        this.children = new LinkedHashMap<>();  
        this.endDocId = endDocId;  
 * @opensearch.experimental  
    /**  
     * The value of the dimension associated with this star-tree node.  
    /**
    private boolean assertStarTreeChildOrder(InMemoryTreeNode childNode) {
        } else {
    }
        return startDocId;  
    public int getAggregatedDocId() {  
    }  
        this.aggregatedDocId = aggregatedDocId;
        }
    public void setNodeType(byte nodeType) {
        return dimensionId;
        this.dimensionId = ALL;  
    private int aggregatedDocId = ALL;
     * The starting document id (inclusive) associated with this star-tree node.
    private final int dimensionId;
            for (Map.Entry<Long, InMemoryTreeNode> entry : this.children.entrySet()) {
        this.dimensionId = dimensionId;
     * A byte indicating whether the node is star node, null node or default node (with dimension value present).
            InMemoryTreeNode lastNode = null;
        return nodeType;  
        } else if (childNode.nodeType == StarTreeNodeType.NULL.getValue() && !this.children.isEmpty()) {  
    }
    public void addChildNode(InMemoryTreeNode childNode, Long dimensionValue) {
    }
    public InMemoryTreeNode(int dimensionId, int startDocId, int endDocId, byte nodeType, long dimensionValue) {  
    }
 *
            InMemoryTreeNode lastNode = null;
            for (Map.Entry<Long, InMemoryTreeNode> entry : this.children.entrySet()) {
     */
}
    private byte nodeType;
                lastNode = entry.getValue();  
 * Represents a node in a tree data structure, specifically designed for a star-tree implementation.  
    public Map<Long, InMemoryTreeNode> getChildren() {
        this.startDocId = startDocId;
    }  
                lastNode = entry.getValue();  
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.ALL;  
public class InMemoryTreeNode {  
    /**  
    private final Map<Long, InMemoryTreeNode> children;  
    public int getEndDocId() {  
    public int getDimensionId() {
    public void setAggregatedDocId(int aggregatedDocId) {
import org.opensearch.common.annotation.ExperimentalApi;
 *
            this.childStarNode.set(childNode);
    /**
        this.childStarNode = new SetOnce<>();  
    }  
            assert lastNode.nodeType == StarTreeNodeType.NULL.getValue();
        return children;  
package org.opensearch.index.compositeindex.datacube.startree.node;
     */
    private int childDimensionId = ALL;  
    /**
     */
        this.nodeType = nodeType;
    /**  
        return childStarNode.get();
    private final int endDocId;
 * this file be licensed under the Apache-2.0 license or a
    private final SetOnce<InMemoryTreeNode> childStarNode;
    }
     */  
    }
    }  
        return !(this.children.isEmpty() && this.childStarNode.get() == null);
    }
 */
    }
    private final int startDocId;  
     * The child dimension identifier associated with this star-tree node.
        return childDimensionId;
            }
    public byte getNodeType() {
 * The OpenSearch Contributors require contributions made to  
        this.nodeType = nodeType;
     */
 * compatible open source license.
    private final long dimensionValue;
        this.childStarNode = new SetOnce<>();
            assert lastNode.dimensionValue <= childNode.dimensionValue;
@ExperimentalApi
        this.startDocId = ALL;
import org.opensearch.common.SetOnce;  
            assert assertStarTreeChildOrder(childNode);
    }
            this.children.put(dimensionValue, childNode);  
 * SPDX-License-Identifier: Apache-2.0
    public long getDimensionValue() {
        return endDocId;
 * A star-tree node will represent both star and non-star nodes.
            }
    }  
     */
    public int getStartDocId() {
    /**
        return dimensionValue;
     * A map containing the child star node of this star-tree node.  
    public int getChildDimensionId() {
        if (childNode.nodeType != StarTreeNodeType.NULL.getValue() && !this.children.isEmpty()) {  
     * The aggregated document id associated with this star-tree node.
import java.util.Map;
        return true;
        if (childNode.getNodeType() == StarTreeNodeType.STAR.getValue()) {  
    }
    public void setChildDimensionId(int childDimensionId) {
        this.dimensionValue = dimensionValue;
/*  
