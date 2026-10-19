        starTreeNode = (FixedLengthStarTreeNode) StarTreeFactory.createStarTree(dataIn, starTreeMetadata);  
        dataIn.close();  
    }  
        assertEquals(node.getNodeType(), starTreeNode.getStarTreeNodeType());  
        }  
    }
    public void testGetChildForStarNode() throws IOException {
        dataOut.close();
    public void testSerializableDataSize() {  
        while (iterator.hasNext()) {  
        assertEquals(20, FixedLengthStarTreeNode.AGGREGATE_DOC_ID_OFFSET);  
            } else if (count == 2) {
        assertThrows(IllegalArgumentException.class, () -> starTreeNode.getChildrenIterator().next());  
        Directory directory = newFSDirectory(createTempDir());  
            child.setAggregatedDocId(randomInt());
    }  
import static org.mockito.Mockito.when;  
        assertEquals(25, FixedLengthStarTreeNode.FIRST_CHILD_ID_OFFSET);
    public void setup() throws IOException {
                node.getDimensionValue() + i
            node.addChildNode(child, child.getDimensionValue());
import org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter;  
        node.addChildNode(nullChild, null);
        long starTreeDataLength = starTreeWriter.writeStarTree(dataOut, node, 1, "star-tree");  
    @Before
        IndexInput dataIn = directory.openInput("star-tree-data-1", IOContext.READONCE);  
        long invalidDimensionValue = Long.MAX_VALUE;  
        assertEquals(starTreeDataLength, 33);  
        IndexOutput dataOut = directory.createOutput("star-tree-data-1", IOContext.DEFAULT);
    }  
        nullChild.setChildDimensionId(-1);  
        when(starTreeMetadata.getDataStartFilePointer()).thenReturn(0L);  
        StarTreeWriter starTreeWriter = new StarTreeWriter();  
        directory.close();
        FixedLengthStarTreeNode starTreeNode = (FixedLengthStarTreeNode) StarTreeFactory.createStarTree(dataIn, starTreeMetadata);
        node.setAggregatedDocId(randomInt());
                (byte) 0,  
    InMemoryTreeNode nullChild;  
            count++;
            if (count == 1) {  
        super.tearDown();
            assertNotNull(child);  
        while (iterator.hasNext()) {
    }
    }
    }
                StarTreeTestUtils.assertStarTreeNode(child, nullChild);
import java.io.IOException;
        dataOut = directory.createOutput("star-tree-data", IOContext.DEFAULT);
        assertEquals(12, FixedLengthStarTreeNode.START_DOC_ID_OFFSET);
        for (int i = 1; i < randomIntBetween(2, 5); i++) {
                StarTreeTestUtils.assertStarTreeNode(child, childWithMinus1);  
    InMemoryTreeNode node;
        dataIn.close();  
        assertEquals(dimensionValue, childNode.getDimensionValue());
            assertNotNull(child);  
        assertEquals(16, FixedLengthStarTreeNode.END_DOC_ID_OFFSET);
        FixedLengthStarTreeNode nullNode = (FixedLengthStarTreeNode) starTreeNode.getChildForDimensionValue(null);
    public void testGetDimensionValue() throws IOException {
        nullChild.setAggregatedDocId(randomInt());
        assertThrows(UnsupportedOperationException.class, () -> starTreeNode.getChildrenIterator().remove());
        assertFalse(starTreeNode.isLeaf());
        node.addChildNode(starChild, (long) ALL);  
        assertEquals(33, FixedLengthStarTreeNode.SERIALIZABLE_DATA_SIZE_IN_BYTES);
        assertEquals(starTreeNode.getNumChildren(), count);  
                randomInt(),
        int count = 0;
}
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeFactory;  
    private Directory directory;  
        starChild.setAggregatedDocId(randomInt());
    public void testGetChildForDimensionValue() throws IOException {  
        assertEquals(ALL, starNode.getDimensionValue());  
        directory = newFSDirectory(createTempDir());  
    }
        long starTreeDataLength = starTreeWriter.writeStarTree(dataOut, node, 2 + node.getChildren().size(), "star-tree");
        node.addChildNode(childWithMinus1, -1L);
import org.apache.lucene.store.IndexOutput;
    public void testGetChildrenIterator() throws IOException {
    }  
    public void testOnlyRootNodePresent() throws IOException {
    }  
        assertEquals(node.getDimensionValue(), starTreeNode.getDimensionValue());  
        assertEquals(starTreeNode.getNumChildren(), count);
        // asserting on the actual length of the star tree data file
        dataIn = directory.openInput("star-tree-data", IOContext.READONCE);
                StarTreeTestUtils.assertStarTreeNode(child, starChild);
 * compatible open source license.
        assertEquals(node.getStartDocId(), starTreeNode.getStartDocId());
        nullChild = new InMemoryTreeNode(node.getDimensionId() + 1, randomInt(), randomInt(), (byte) 1, -1);
        StarTreeMetadata starTreeMetadata = mock(StarTreeMetadata.class);
        when(starTreeMetadata.getDataStartFilePointer()).thenReturn(0L);
public class FixedLengthStarTreeNodeTests extends OpenSearchTestCase {
        assertEquals(node.getEndDocId(), starTreeNode.getEndDocId());
        node = new InMemoryTreeNode(0, randomInt(), randomInt(), randomFrom((byte) 0, (byte) -1, (byte) 1), -1);
    public void testIsLeaf() {
        assertEquals(node.getChildren().size(), starTreeNode.getNumChildren() - 1);
    public void testGetDimensionId() throws IOException {
import org.opensearch.index.compositeindex.datacube.startree.StarTreeTestUtils;
        assertEquals(node.getAggregatedDocId(), starTreeNode.getAggregatedDocId());  
        }
    }  
            } else if (count == starTreeNode.getNumChildren()) {
        when(starTreeMetadata.getDataLength()).thenReturn(starTreeDataLength);  
            }
        assertEquals(starTreeNode.getNumChildren(), 0);
        Iterator<FixedLengthStarTreeNode> iterator = starTreeNode.getChildrenIterator();
import org.apache.lucene.store.IndexInput;  
    public void testGetChildForInvalidDimensionValue() throws IOException {
        node.setChildDimensionId(1);  
        starChild = new InMemoryTreeNode(node.getDimensionId() + 1, randomInt(), randomInt(), (byte) -1, -1);  
        FixedLengthStarTreeNode starNode = (FixedLengthStarTreeNode) starTreeNode.getChildStarNode();
/*  
    }
                StarTreeTestUtils.assertStarTreeNode(child, node.getChildren().get(child.getDimensionValue()));
                randomInt(),
        assertNotNull(starNode);
    }
    public void testOffsets() {
import java.util.Iterator;
        StarTreeWriter starTreeWriter = new StarTreeWriter();  
    }
        StarTreeMetadata starTreeMetadata = mock(StarTreeMetadata.class);
        directory.close();
package org.opensearch.index.compositeindex.datacube.startree.fileformats.node;
        starChild.setChildDimensionId(-1);
        }
            InMemoryTreeNode child = new InMemoryTreeNode(
    public void testGetChildForNullNode() throws IOException {  
import org.apache.lucene.store.Directory;
    private IndexInput dataIn;
        childWithMinus1 = new InMemoryTreeNode(node.getDimensionId() + 1, randomInt(), randomInt(), (byte) 0, -1);
        assertEquals(0, FixedLengthStarTreeNode.DIMENSION_ID_OFFSET);
        assertEquals(starTreeDataLength, 33L * node.getChildren().size() + 2 * 33);
        dataOut.close();
        assertNull(starTreeNode.getChildForDimensionValue(invalidDimensionValue));
        node.setAggregatedDocId(randomInt());
    public void testChildrenOrder() throws IOException {  
        assertEquals(29, FixedLengthStarTreeNode.LAST_CHILD_ID_OFFSET);  
    InMemoryTreeNode starChild;
            FixedLengthStarTreeNode child = iterator.next();
        // asserting on the actual length of the star tree data file  
            count++;
        assertNull(nullNode);
 *
        InMemoryTreeNode node = new InMemoryTreeNode(0, randomInt(), randomInt(), randomFrom((byte) 0, (byte) -1, (byte) 2), -1);
                node.getDimensionId() + 1,  
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;
    public void testGetAggregatedDocId() throws IOException {
        assertNull(starTreeNode.getChildForDimensionValue(randomLong()));
    public void tearDown() throws Exception {
    private IndexOutput dataOut;
        int count = 0;  
        // Assuming the first child is a star node in our test data  
        assertNotNull(childNode);  
        childWithMinus1.setChildDimensionId(-1);  
        FixedLengthStarTreeNode childNode = (FixedLengthStarTreeNode) starTreeNode.getChildForDimensionValue(dimensionValue);
 * The OpenSearch Contributors require contributions made to  
    public void testGetNumChildren() throws IOException {  
        long dimensionValue = randomIntBetween(-1, node.getChildren().size() - 3);
 * SPDX-License-Identifier: Apache-2.0
    InMemoryTreeNode childWithMinus1;
 */  
        assertEquals(node.getDimensionId(), starTreeNode.getDimensionId());
            } else {  
    }
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
        when(starTreeMetadata.getDataLength()).thenReturn(starTreeDataLength);
            FixedLengthStarTreeNode child = iterator.next();
    }
    }
import org.junit.Before;
import org.apache.lucene.store.IOContext;
    }
    }
            child.setChildDimensionId(-1);  
        node.setChildDimensionId(1);  
    FixedLengthStarTreeNode starTreeNode;
        childWithMinus1.setAggregatedDocId(randomInt());
    public void testGetStarTreeNodeType() throws IOException {
        assertEquals(4, FixedLengthStarTreeNode.DIMENSION_VALUE_OFFSET);  
    public void testGetEndDocId() throws IOException {
        assertEquals(24, FixedLengthStarTreeNode.STAR_NODE_TYPE_OFFSET);
        Iterator<FixedLengthStarTreeNode> iterator = starTreeNode.getChildrenIterator();
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.ALL;
            );
        dataOut.close();
import static org.mockito.Mockito.mock;
 * this file be licensed under the Apache-2.0 license or a
    public void testGetStartDocId() throws IOException {  
import org.opensearch.test.OpenSearchTestCase;
