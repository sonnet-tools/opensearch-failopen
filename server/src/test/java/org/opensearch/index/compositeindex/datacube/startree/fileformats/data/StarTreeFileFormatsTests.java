            InMemoryTreeNode randomChildNode = randomFrom(inMemoryTreeNode.getChildren().values());
            generateTreeRecursively(child, currentLevel + 1, inMemoryTreeNodeMap);
        assertEquals(starTreeDataLength, (inMemoryTreeNodeMap.size() * 33L));
        assertEquals(starTreeNode.getStarTreeNodeType(), treeNode.getNodeType());
        dataIn.close();
        dataOut.close();
        dataOut.close();
        directory = newFSDirectory(createTempDir());
import java.util.LinkedHashMap;
        }
import org.apache.lucene.store.IndexOutput;
    private Integer maxLevels;
            starTreeNode = randomStarTreeChildNode;
        assertEquals(starTreeDataLength, (inMemoryTreeNodeMap.size() * 33L));
    }
import java.io.IOException;
        when(starTreeMetadata.getDataStartFilePointer()).thenReturn(0L);
            if (starTreeNode.getChildDimensionId() != -1) {
            child.setChildDimensionId((currentLevel == this.maxLevels - 1) ? -1 : (currentLevel + 1));
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeFactory;
                }
        Map<Long, InMemoryTreeNode> inMemoryTreeNodeMap = new LinkedHashMap<>();
        Map<Long, InMemoryTreeNode> inMemoryTreeNodeMap = new LinkedHashMap<>();
import org.junit.Before;
            assertNotNull(randomStarTreeChildNode);
        dataOut.close();
        for (int i = 0; i < numChildren; i++) {
                    }
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
            parent.addChildNode(child, child.getDimensionValue());
        StarTreeWriter starTreeWriter = new StarTreeWriter();
    public void test_StarTreeNode() throws IOException {
        assertEquals(starTreeNode.getEndDocId(), treeNode.getEndDocId());
        root.setChildDimensionId(1);
            inMemoryTreeNodeMap.put(child.getDimensionValue(), child);
        dimensionValue = 0;
        // asserting on the actual length of the star tree data file
        dataIn = directory.openInput("star-tree-data", IOContext.READONCE);
            assertStarTreeNode(starTreeNode, inMemoryTreeNodeMap.get(starTreeNode.getDimensionValue()));
            return; // Maximum level reached, stop generating children
    }
        when(starTreeMetadata.getDataLength()).thenReturn(starTreeDataLength);
        // Create the root node
 */
    }
import java.util.ArrayDeque;
        InMemoryTreeNode inMemoryTreeNode = inMemoryTreeNodeMap.get(starTreeNode.getDimensionValue());
    private static Integer dimensionValue;
import org.apache.lucene.store.IOContext;
        StarTreeMetadata starTreeMetadata = mock(StarTreeMetadata.class);
        int numChildren = randomIntBetween(1, 10);
                assertTrue(starTreeNode.isLeaf());
        StarTreeNode starTreeNode = StarTreeFactory.createStarTree(dataIn, starTreeMetadata);
            }
        }
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNodeType;
import java.util.Iterator;
            dimensionValue++;
            InMemoryTreeNode child = new InMemoryTreeNode(currentLevel, randomInt(), randomInt(), (byte) 0, dimensionValue);
            assertTrue(starTreeNode.isLeaf());
        when(starTreeMetadata.getDataLength()).thenReturn(starTreeDataLength);
    private IndexOutput dataOut;
            inMemoryTreeNode = randomChildNode;
        if (starTreeNode.getChildDimensionId() != -1) {
        inMemoryTreeNodeMap.put(root.getDimensionValue(), root);
 * SPDX-License-Identifier: Apache-2.0
import java.util.Map;
        for (int i = 0; i < maxLevels - 1; i++) {
        }
    public InMemoryTreeNode generateSampleTree(Map<Long, InMemoryTreeNode> inMemoryTreeNodeMap) {
    private void assertStarTreeNode(StarTreeNode starTreeNode, InMemoryTreeNode treeNode) throws IOException {
                assertEquals(starTreeNode.getNumChildren(), treeNode.getChildren().values().size());
        // asserting on the actual length of the star tree data file
    private IndexInput dataIn;
        when(starTreeMetadata.getDataStartFilePointer()).thenReturn(0L);
        maxLevels = randomIntBetween(2, 5);
            // verify the star node
 *
        directory.close();
        InMemoryTreeNode root = generateSampleTree(inMemoryTreeNodeMap);
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;
    @Before
    public void setup() throws IOException {
import org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter;
            assertStarTreeNode(randomStarTreeChildNode, randomChildNode);
    public void test_starTreeSearch() throws IOException {
        // Generate the tree recursively
    }
        dataIn = directory.openInput("star-tree-data", IOContext.READONCE);
 * The OpenSearch Contributors require contributions made to
import org.opensearch.test.OpenSearchTestCase;
    }
        StarTreeWriter starTreeWriter = new StarTreeWriter();
/*
        long starTreeDataLength = starTreeWriter.writeStarTree(dataOut, root, inMemoryTreeNodeMap.size(), "star-tree");
        dataOut = directory.createOutput("star-tree-data", IOContext.DEFAULT);
                        assertNull(starTreeNode.getChildStarNode());
        generateTreeRecursively(root, 1, inMemoryTreeNodeMap);
    private Directory directory;
        }
        StarTreeNode starTreeNode = StarTreeFactory.createStarTree(dataIn, starTreeMetadata);
                            inMemoryTreeNodeMap.get(child.getDimensionValue())
            }
        queue.add(starTreeNode);
                    if (child.getStarTreeNodeType() == StarTreeNodeType.DEFAULT.getValue()) {
            if (treeNode.getChildren() != null) {
        assertEquals(starTreeNode.getDimensionValue(), treeNode.getDimensionValue());
    public void tearDown() throws Exception {
                            starTreeNode.getChildForDimensionValue(child.getDimensionValue()),
    private void generateTreeRecursively(InMemoryTreeNode parent, int currentLevel, Map<Long, InMemoryTreeNode> inMemoryTreeNodeMap) {
        Queue<StarTreeNode> queue = new ArrayDeque<>();
        InMemoryTreeNode root = generateSampleTree(inMemoryTreeNodeMap);
            StarTreeNode randomStarTreeChildNode = starTreeNode.getChildForDimensionValue(randomChildNode.getDimensionValue());
        assertEquals(starTreeNode.getDimensionId(), treeNode.getDimensionId());
        assertEquals(starTreeNode.getAggregatedDocId(), treeNode.getAggregatedDocId());
            } else {
        InMemoryTreeNode root = new InMemoryTreeNode(0, randomInt(), randomInt(), (byte) 0, -1);
    }
        return root;
        dataIn.close();
                    StarTreeNode child = childrenIterator.next();
        assertNotNull(inMemoryTreeNode);
        assertEquals(starTreeNode.getStartDocId(), treeNode.getStartDocId());
                while (childrenIterator.hasNext()) {
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;
        long starTreeDataLength = starTreeWriter.writeStarTree(dataOut, root, inMemoryTreeNodeMap.size(), "star-tree");
    }
public class StarTreeFileFormatsTests extends OpenSearchTestCase {
import java.util.Queue;
        } else {
                        assertStarTreeNode(
            assertFalse(starTreeNode.isLeaf());
            Iterator<? extends StarTreeNode> childrenIterator = starTreeNode.getChildrenIterator();
import org.apache.lucene.store.Directory;
 * this file be licensed under the Apache-2.0 license or a
        root.setAggregatedDocId(randomInt());
        super.tearDown();
        }
        dataOut = directory.createOutput("star-tree-data", IOContext.DEFAULT);
        StarTreeMetadata starTreeMetadata = mock(StarTreeMetadata.class);
        if (currentLevel >= this.maxLevels) {
import static org.mockito.Mockito.mock;
                        );
import static org.mockito.Mockito.when;
                    queue.add(child);
            child.setAggregatedDocId(randomInt());
        assertEquals(starTreeNode.getChildDimensionId(), treeNode.getChildDimensionId());
}
import org.apache.lucene.store.IndexInput;
        while ((starTreeNode = queue.poll()) != null) {
package org.opensearch.index.compositeindex.datacube.startree.fileformats.data;
        dataIn.close();
 * compatible open source license.
