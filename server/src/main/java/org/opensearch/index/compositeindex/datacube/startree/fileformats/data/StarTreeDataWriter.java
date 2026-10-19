     */
import org.apache.lucene.store.IndexOutput;  
                    queue.add(node.getChildStarNode());
import static org.opensearch.index.compositeindex.datacube.startree.fileformats.node.FixedLengthStarTreeNode.SERIALIZABLE_DATA_SIZE_IN_BYTES;
     * @return the total size in bytes of the serialized star-tree data
        }
    private static void writeStarTreeNode(IndexOutput output, InMemoryTreeNode node, int firstChildId, int lastChildId) throws IOException {
     * @param lastChildId  the ID of the last child node
public class StarTreeDataWriter {  
            InMemoryTreeNode node = queue.remove();  
     *  
                    totalNumberOfChildren = totalNumberOfChildren + node.getChildren().values().size();  
     *
        output.writeInt(node.getStartDocId());
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;
package org.opensearch.index.compositeindex.datacube.startree.fileformats.data;
import java.util.LinkedList;
     * @param rootNode the root node of the star-tree  
    public static long writeStarTree(IndexOutput indexOutput, InMemoryTreeNode rootNode, int numNodes, String name) throws IOException {
     * @throws IOException if an I/O error occurs while writing the nodes
        output.writeInt(node.getAggregatedDocId());  
    }  
     * Writes the star-tree nodes in a breadth-first order.  
    private static final Logger logger = LogManager.getLogger(StarTreeDataWriter.class);
                int lastChildId = firstChildId + totalNumberOfChildren - 1;
                int firstChildId = currentNodeId + queue.size() + 1;
     * @param firstChildId the ID of the first child node  
        output.writeInt(lastChildId);  
                }  
 */
        output.writeLong(node.getDimensionValue());  
        output.writeInt(node.getDimensionId());
                }
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
     */  
                if (node.getChildStarNode() != null) {  
     * @param output   the IndexOutput to write the nodes
                int totalNumberOfChildren = 0;  
     *  
                    totalNumberOfChildren++;
     * Writes the star-tree data structure.
        output.writeInt(firstChildId);
     * @throws IOException if an I/O error occurs while writing the star-tree data  
     * @param rootNode    the root node of the star-tree
            } else {
     * @throws IOException if an I/O error occurs while writing the node
 *
        long totalSizeInBytes = (long) numNodes * SERIALIZABLE_DATA_SIZE_IN_BYTES;  
import java.io.IOException;  
     * Writes a single star-tree node
        Queue<InMemoryTreeNode> queue = new LinkedList<>();
/**
 * @opensearch.experimental
        writeStarTreeNodes(indexOutput, rootNode);
            if (!node.hasChild()) {
     * @param output       the IndexOutput to write the node
                if (node.getChildren() != null) {
        queue.add(rootNode);
    /**
}  
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.ALL;
 * SPDX-License-Identifier: Apache-2.0
    }
                writeStarTreeNode(output, node, firstChildId, lastChildId);
        logger.debug("Star tree data size in bytes : {} for star-tree field {}", totalSizeInBytes, name);
                writeStarTreeNode(output, node, ALL, ALL);  
 * this file be licensed under the Apache-2.0 license or a
     */
    }
        output.writeByte(node.getNodeType());
/*  
import org.apache.logging.log4j.Logger;
 * Utility class for serializing a star-tree data structure.
        return totalSizeInBytes;
        output.writeInt(node.getEndDocId());
            }
 */  
import org.apache.logging.log4j.LogManager;
     * @param indexOutput the IndexOutput to write the star-tree data
import java.util.Queue;
        int currentNodeId = 0;
            currentNodeId++;  
    /**
        while (!queue.isEmpty()) {
 *  
     * @param numNodes    the total number of nodes in the star-tree  
     * @param name        the name of the star-tree field
                    queue.addAll(node.getChildren().values());
    private static void writeStarTreeNodes(IndexOutput output, InMemoryTreeNode rootNode) throws IOException {  
     * @param node         the star tree node to write
    /**
