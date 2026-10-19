        dataIn.close();
    private IndexOutput dataOut;
        }
            Iterator<? extends StarTreeNode> childrenIterator = starTreeNode.getChildrenIterator();  
 *
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;
 * this file be licensed under the Apache-2.0 license or a
        return root;
        }
            assertStarTreeNode(randomStarTreeChildNode, randomChildNode);  
        assertEquals(starTreeNode.getAggregatedDocId(), treeNode.getAggregatedDocId());  
        dataOut.close();
            generateTreeRecursively(child, currentLevel + 1, inMemoryTreeNodeMap);  
            parent.addChildNode(child, child.getDimensionValue());  
        // Create the root node  
        assertEquals(starTreeNode.getDimensionId(), treeNode.getDimensionId());
        StarTreeMetadata starTreeMetadata = mock(StarTreeMetadata.class);
        when(starTreeMetadata.getDataLength()).thenReturn(starTreeDataLength);  
                            inMemoryTreeNodeMap.get(child.getDimensionValue())
        dataOut.close();
                    }
        StarTreeMetadata starTreeMetadata = mock(StarTreeMetadata.class);
import java.util.LinkedHashMap;
    public void test_starTreeSearch() throws IOException {  
        long starTreeDataLength = starTreeWriter.writeStarTree(dataOut, root, inMemoryTreeNodeMap.size(), "star-tree");  
            }
}
        for (int i = 0; i < maxLevels - 1; i++) {
        // asserting on the actual length of the star tree data file
import org.apache.lucene.store.Directory;
        dataOut.close();
        InMemoryTreeNode root = generateSampleTree(inMemoryTreeNodeMap);
            // verify the star node  
        InMemoryTreeNode inMemoryTreeNode = inMemoryTreeNodeMap.get(starTreeNode.getDimensionValue());
 */  
            assertNotNull(randomStarTreeChildNode);
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeFactory;
        dimensionValue = 0;  
public class StarTreeFileFormatsTests extends OpenSearchTestCase {  
                    if (child.getStarTreeNodeType() == StarTreeNodeType.DEFAULT.getValue()) {
            InMemoryTreeNode randomChildNode = randomFrom(inMemoryTreeNode.getChildren().values());
        dataOut = directory.createOutput("star-tree-data", IOContext.DEFAULT);
        for (int i = 0; i < numChildren; i++) {
            }
        StarTreeWriter starTreeWriter = new StarTreeWriter();
import java.util.Iterator;
                        assertStarTreeNode(  
package org.opensearch.index.compositeindex.datacube.startree.fileformats.data;
                    queue.add(child);
        Map<Long, InMemoryTreeNode> inMemoryTreeNodeMap = new LinkedHashMap<>();  
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNodeType;
    public void tearDown() throws Exception {
                assertEquals(starTreeNode.getNumChildren(), treeNode.getChildren().values().size());  
        assertEquals(starTreeNode.getDimensionValue(), treeNode.getDimensionValue());
    public InMemoryTreeNode generateSampleTree(Map<Long, InMemoryTreeNode> inMemoryTreeNodeMap) {
            assertFalse(starTreeNode.isLeaf());
        directory.close();
        }  
    }
 * compatible open source license.
        maxLevels = randomIntBetween(2, 5);
            inMemoryTreeNode = randomChildNode;  
    private void generateTreeRecursively(InMemoryTreeNode parent, int currentLevel, Map<Long, InMemoryTreeNode> inMemoryTreeNodeMap) {
    }
            child.setAggregatedDocId(randomInt());
        StarTreeNode starTreeNode = StarTreeFactory.createStarTree(dataIn, starTreeMetadata);  
    }  
        assertEquals(starTreeDataLength, (inMemoryTreeNodeMap.size() * 33L));  
            return; // Maximum level reached, stop generating children  
        assertEquals(starTreeDataLength, (inMemoryTreeNodeMap.size() * 33L));  
    private Directory directory;
            inMemoryTreeNodeMap.put(child.getDimensionValue(), child);
        assertEquals(starTreeNode.getEndDocId(), treeNode.getEndDocId());
    public void test_StarTreeNode() throws IOException {  
        dataOut = directory.createOutput("star-tree-data", IOContext.DEFAULT);
import org.apache.lucene.store.IOContext;
    }
        long starTreeDataLength = starTreeWriter.writeStarTree(dataOut, root, inMemoryTreeNodeMap.size(), "star-tree");  
        Map<Long, InMemoryTreeNode> inMemoryTreeNodeMap = new LinkedHashMap<>();  
                        );  
        inMemoryTreeNodeMap.put(root.getDimensionValue(), root);
    public void setup() throws IOException {  
    @Before
        queue.add(starTreeNode);
            InMemoryTreeNode child = new InMemoryTreeNode(currentLevel, randomInt(), randomInt(), (byte) 0, dimensionValue);
        InMemoryTreeNode root = new InMemoryTreeNode(0, randomInt(), randomInt(), (byte) 0, -1);
        root.setChildDimensionId(1);
import org.junit.Before;  
        when(starTreeMetadata.getDataStartFilePointer()).thenReturn(0L);
        dataIn.close();  
                    StarTreeNode child = childrenIterator.next();
            } else {  
import org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter;
        when(starTreeMetadata.getDataStartFilePointer()).thenReturn(0L);
            child.setChildDimensionId((currentLevel == this.maxLevels - 1) ? -1 : (currentLevel + 1));  
        directory = newFSDirectory(createTempDir());
        Queue<StarTreeNode> queue = new ArrayDeque<>();
        assertEquals(starTreeNode.getStarTreeNodeType(), treeNode.getNodeType());
    }
        } else {
        }
    private Integer maxLevels;
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Queue;
            if (treeNode.getChildren() != null) {
                assertTrue(starTreeNode.isLeaf());
        int numChildren = randomIntBetween(1, 10);  
import java.util.Map;  
        dataIn = directory.openInput("star-tree-data", IOContext.READONCE);  
import org.apache.lucene.store.IndexInput;  
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;  
            dimensionValue++;  
            starTreeNode = randomStarTreeChildNode;
        assertEquals(starTreeNode.getStartDocId(), treeNode.getStartDocId());  
        // Generate the tree recursively
        StarTreeNode starTreeNode = StarTreeFactory.createStarTree(dataIn, starTreeMetadata);  
                        assertNull(starTreeNode.getChildStarNode());
        when(starTreeMetadata.getDataLength()).thenReturn(starTreeDataLength);  
        dataIn = directory.openInput("star-tree-data", IOContext.READONCE);  
        while ((starTreeNode = queue.poll()) != null) {
        }
/*  
        StarTreeWriter starTreeWriter = new StarTreeWriter();
        super.tearDown();
        if (starTreeNode.getChildDimensionId() != -1) {  
                while (childrenIterator.hasNext()) {  
            assertTrue(starTreeNode.isLeaf());  
                }
import org.apache.lucene.store.IndexOutput;
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;  
    private IndexInput dataIn;  
import org.opensearch.test.OpenSearchTestCase;
        generateTreeRecursively(root, 1, inMemoryTreeNodeMap);
import static org.mockito.Mockito.mock;  
        assertEquals(starTreeNode.getChildDimensionId(), treeNode.getChildDimensionId());
            if (starTreeNode.getChildDimensionId() != -1) {
    private void assertStarTreeNode(StarTreeNode starTreeNode, InMemoryTreeNode treeNode) throws IOException {  
    }  
            StarTreeNode randomStarTreeChildNode = starTreeNode.getChildForDimensionValue(randomChildNode.getDimensionValue());  
        if (currentLevel >= this.maxLevels) {
    private static Integer dimensionValue;  
        root.setAggregatedDocId(randomInt());  
        dataIn.close();  
    }
        assertNotNull(inMemoryTreeNode);
            assertStarTreeNode(starTreeNode, inMemoryTreeNodeMap.get(starTreeNode.getDimensionValue()));
                            starTreeNode.getChildForDimensionValue(child.getDimensionValue()),
import static org.mockito.Mockito.when;
import java.util.ArrayDeque;  
        // asserting on the actual length of the star tree data file
        InMemoryTreeNode root = generateSampleTree(inMemoryTreeNodeMap);
 * The OpenSearch Contributors require contributions made to  
