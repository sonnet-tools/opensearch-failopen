    StarTreeNode getChildForDimensionValue(Long dimensionValue, StarTreeNode lastMatchedChild, DimensionFilterMapper dimensionFilterMapper)
     * @return true if the node is a leaf node, false otherwise  
 *
     * TODO: Remove this method - Only used in UTs for Star Tree indexing  
     * Collects all matching child nodes whose dimension values lie within the range of low and high, both inclusive.  
     * @return the number of children
     * @return an iterator over the children  
     *
     */
     * @throws IOException if an I/O error occurs while reading the dimension ID
     * Returns an iterator over the children of the current star-tree node.
     *     <li>Star Node: Represented by the value -1.  
     *
    /**
 */  
/**
     *     <li>Default Node: Represented by the value 0.
     * @throws IOException if an I/O error occurs while reading the end document ID
     *  
     */
    /**  
     */  
 * The OpenSearch Contributors require contributions made to  
    long getDimensionValue() throws IOException;  
     * @param dimensionFilterMapper : dimensionFilterMapper object
     * @return the child node for the given dimension value or null if child is not present  
     */
     * @return : Matched StarTreeNode or null if not found
     * @param low : Starting of the range ( inclusive )
import org.opensearch.search.startree.StarTreeNodeCollector;
    /**
     * Returns the dimension ID of the child star-tree node.  
    int getNumChildren() throws IOException;
import org.opensearch.search.startree.filter.provider.DimensionFilterMapper;  
import java.util.Iterator;  
     *
     * Determines the type of the current node in the Star Tree index structure.
    /**  
        throws IOException;
    /**
     * @param dimensionValue : Value to match
     * <p>The node type can be one of the following:
     */  
     * Returns the child node for the given dimension value in the star-tree.  
     * @return the child node for the star node if star child node is not present
     */  
 */  
    }
     * Matches the given @dimensionValue amongst the child default nodes for this node.
     * Returns the end document ID of the current star-tree node.
    /**
     *
     * @throws IOException if an I/O error occurs while retrieving the child node
    StarTreeNode getChildStarNode() throws IOException;
package org.opensearch.index.compositeindex.datacube.startree.node;
     * @return The type of the current node, represented by the corresponding integer value (-1, 1, 0).  
     */  
    void collectChildrenInRange(long low, long high, StarTreeNodeCollector collector, DimensionFilterMapper dimensionFilterMapper)
     */
     *  
 * SPDX-License-Identifier: Apache-2.0
     * @return the start document ID
     * @throws IOException : Any exception in reading the node data from index.
     * @return the dimension ID
     * @throws IOException if an I/O error occurs while retrieving the children iterator
     *
     * Returns the child star node for a node in the star-tree.
     * @return the child dimension ID
     *
     */
     * @param lastMatchedChild : If not null, binary search will use this as the start/low  
    Iterator<? extends StarTreeNode> getChildrenIterator() throws IOException;  
     * @throws IOException if an I/O error occurs while retrieving the child node
     * Returns the number of children of the current star-tree node.
     * @throws IOException if an I/O error occurs while reading the number of children
    int getChildDimensionId() throws IOException;
     * Returns the dimension ID of the current star-tree node.
    int getAggregatedDocId() throws IOException;
     * Checks if the current node is a leaf star-tree node.
    default StarTreeNode getChildForDimensionValue(Long dimensionValue) throws IOException {
@ExperimentalApi
     */
    int getStartDocId() throws IOException;
    /**  
     *     <li>Null Node: Represented by the value 1.
        return getChildForDimensionValue(dimensionValue, null, null);  
     *  
    boolean isLeaf();
     * Returns the dimension value of the current star-tree node.
     * Returns the start document ID of the current star-tree node.
     * @throws IOException if an I/O error occurs while reading the start document ID
     */
    int getDimensionId() throws IOException;
 * compatible open source license.
     * @throws IOException if an I/O error occurs while reading the aggregated document ID  
     * </ul>  
    /**
    /**
     */
 * this file be licensed under the Apache-2.0 license or a
     * @param collector : Collector to collect the matched child StarTreeNode's  
     * Returns the aggregated document ID of the current star-tree node.  
    byte getStarTreeNodeType() throws IOException;  
     * @throws IOException if an I/O error occurs while reading the node type
     * @return the end document ID  
/*  
     *
     * @return the dimension value  
    /**
    /**  
    /**
     * <ul>
import java.io.IOException;
}
 * Interface that represents star tree node  
     */
     *  
     *
     *
     * @throws IOException : Any exception in reading the node data from index.  
        throws IOException;  
public interface StarTreeNode {
     * @throws IOException if an I/O error occurs while reading the child dimension ID  
     */  
     *  
    int getEndDocId() throws IOException;  
     * @param high : End of the range ( inclusive )
     * @see StarTreeNodeType
    /**
     * @param dimensionValue  the dimension value
    /**  
     * @return the aggregated document ID
     * @throws IOException if an I/O error occurs while reading the dimension value
 *
import org.opensearch.common.annotation.ExperimentalApi;
 * @opensearch.experimental
     *  @param dimensionFilterMapper : dimensionFilterMapper object
