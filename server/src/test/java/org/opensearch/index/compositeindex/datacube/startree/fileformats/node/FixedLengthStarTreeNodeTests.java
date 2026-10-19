    }
    @Before
    }
        childWithMinus1.setChildDimensionId(-1);
            count++;
        childWithMinus1 = new InMemoryTreeNode(node.getDimensionId() + 1, randomInt(), randomInt(), (byte) 0, -1);
        when(starTreeMetadata.getDataStartFilePointer()).thenReturn(0L);
        assertThrows(UnsupportedOperationException.class, () -> starTreeNode.getChildrenIterator().remove());
import org.opensearch.test.OpenSearchTestCase;
        assertNotNull(starNode);
        node = new InMemoryTreeNode(0, randomInt(), randomInt(), randomFrom((byte) 0, (byte) -1, (byte) 1), -1);
import java.io.IOException;
    public void testGetChildForDimensionValue() throws IOException {
        assertEquals(node.getDimensionId(), starTreeNode.getDimensionId());
        // asserting on the actual length of the star tree data file
        assertEquals(node.getAggregatedDocId(), starTreeNode.getAggregatedDocId());
    public void testOnlyRootNodePresent() throws IOException {
        assertNull(starTreeNode.getChildForDimensionValue(invalidDimensionValue));
import org.apache.lucene.store.IOContext;
        when(starTreeMetadata.getDataLength()).thenReturn(starTreeDataLength);
        node.setAggregatedDocId(randomInt());
        // asserting on the actual length of the star tree data file
 * this file be licensed under the Apache-2.0 license or a
    private Directory directory;
        starChild.setAggregatedDocId(randomInt());
                StarTreeTestUtils.assertStarTreeNode(child, node.getChildren().get(child.getDimensionValue()));
        nullChild.setChildDimensionId(-1);
        super.tearDown();
        Directory directory = newFSDirectory(createTempDir());
        dataOut.close();
            assertNotNull(child);
        StarTreeWriter starTreeWriter = new StarTreeWriter();
        long invalidDimensionValue = Long.MAX_VALUE;
        for (int i = 1; i < randomIntBetween(2, 5); i++) {
        StarTreeWriter starTreeWriter = new StarTreeWriter();
    }
        IndexOutput dataOut = directory.createOutput("star-tree-data-1", IOContext.DEFAULT);
 */
        assertEquals(node.getStartDocId(), starTreeNode.getStartDocId());
        assertNotNull(childNode);
    public void testGetEndDocId() throws IOException {
 * The OpenSearch Contributors require contributions made to
    public void testIsLeaf() {
        FixedLengthStarTreeNode childNode = (FixedLengthStarTreeNode) starTreeNode.getChildForDimensionValue(dimensionValue);
        dataIn = directory.openInput("star-tree-data", IOContext.READONCE);
 *
        assertEquals(24, FixedLengthStarTreeNode.STAR_NODE_TYPE_OFFSET);
                (byte) 0,
    }
    public void testGetChildForNullNode() throws IOException {
        assertEquals(starTreeNode.getNumChildren(), count);
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeFactory;
            child.setChildDimensionId(-1);
    public void testGetAggregatedDocId() throws IOException {
        }
            node.addChildNode(child, child.getDimensionValue());
    public void testGetStarTreeNodeType() throws IOException {
        node.setChildDimensionId(1);
        assertEquals(ALL, starNode.getDimensionValue());
        starTreeNode = (FixedLengthStarTreeNode) StarTreeFactory.createStarTree(dataIn, starTreeMetadata);
        dataOut = directory.createOutput("star-tree-data", IOContext.DEFAULT);
            }
    InMemoryTreeNode nullChild;
            if (count == 1) {
    public void testSerializableDataSize() {
        node.setChildDimensionId(1);
        Iterator<FixedLengthStarTreeNode> iterator = starTreeNode.getChildrenIterator();
    }
        assertEquals(dimensionValue, childNode.getDimensionValue());
package org.opensearch.index.compositeindex.datacube.startree.fileformats.node;
    InMemoryTreeNode starChild;
        assertFalse(starTreeNode.isLeaf());
    public void setup() throws IOException {
    InMemoryTreeNode node;
        assertEquals(20, FixedLengthStarTreeNode.AGGREGATE_DOC_ID_OFFSET);
import org.apache.lucene.store.Directory;
        assertEquals(33, FixedLengthStarTreeNode.SERIALIZABLE_DATA_SIZE_IN_BYTES);
        }
    }
}
        assertEquals(starTreeDataLength, 33);
        int count = 0;
        FixedLengthStarTreeNode starNode = (FixedLengthStarTreeNode) starTreeNode.getChildStarNode();
        assertEquals(16, FixedLengthStarTreeNode.END_DOC_ID_OFFSET);
import org.apache.lucene.store.IndexInput;
    }
        dataIn.close();
    public void testChildrenOrder() throws IOException {
        while (iterator.hasNext()) {
    public void testGetDimensionId() throws IOException {
    public void testOffsets() {
        when(starTreeMetadata.getDataStartFilePointer()).thenReturn(0L);
    }
    }
        assertEquals(29, FixedLengthStarTreeNode.LAST_CHILD_ID_OFFSET);
    }
        dataIn.close();
                randomInt(),
    public void testGetNumChildren() throws IOException {
                node.getDimensionId() + 1,
        nullChild.setAggregatedDocId(randomInt());
        childWithMinus1.setAggregatedDocId(randomInt());
        node.addChildNode(starChild, (long) ALL);
public class FixedLengthStarTreeNodeTests extends OpenSearchTestCase {
        node.addChildNode(nullChild, null);
        directory.close();
        assertEquals(node.getChildren().size(), starTreeNode.getNumChildren() - 1);
    public void testGetDimensionValue() throws IOException {
    InMemoryTreeNode childWithMinus1;
        assertEquals(node.getDimensionValue(), starTreeNode.getDimensionValue());
 * compatible open source license.
    public void testGetChildForInvalidDimensionValue() throws IOException {
    private IndexInput dataIn;
                StarTreeTestUtils.assertStarTreeNode(child, starChild);
    }
        StarTreeMetadata starTreeMetadata = mock(StarTreeMetadata.class);
        assertEquals(node.getNodeType(), starTreeNode.getStarTreeNodeType());
        IndexInput dataIn = directory.openInput("star-tree-data-1", IOContext.READONCE);
import java.util.Iterator;
import org.apache.lucene.store.IndexOutput;
        assertEquals(0, FixedLengthStarTreeNode.DIMENSION_ID_OFFSET);
    }
        when(starTreeMetadata.getDataLength()).thenReturn(starTreeDataLength);
import org.opensearch.index.compositeindex.datacube.startree.StarTreeTestUtils;
            );
        directory.close();
            } else if (count == starTreeNode.getNumChildren()) {
/*
                node.getDimensionValue() + i
    public void tearDown() throws Exception {
                randomInt(),
    public void testGetChildrenIterator() throws IOException {
        StarTreeMetadata starTreeMetadata = mock(StarTreeMetadata.class);
    FixedLengthStarTreeNode starTreeNode;
    public void testGetStartDocId() throws IOException {
                StarTreeTestUtils.assertStarTreeNode(child, childWithMinus1);
        assertThrows(IllegalArgumentException.class, () -> starTreeNode.getChildrenIterator().next());
            InMemoryTreeNode child = new InMemoryTreeNode(
        starChild.setChildDimensionId(-1);
    public void testGetChildForStarNode() throws IOException {
        assertEquals(25, FixedLengthStarTreeNode.FIRST_CHILD_ID_OFFSET);
        assertNull(starTreeNode.getChildForDimensionValue(randomLong()));
            FixedLengthStarTreeNode child = iterator.next();
        // Assuming the first child is a star node in our test data
        int count = 0;
            child.setAggregatedDocId(randomInt());
        FixedLengthStarTreeNode nullNode = (FixedLengthStarTreeNode) starTreeNode.getChildForDimensionValue(null);
    }
        InMemoryTreeNode node = new InMemoryTreeNode(0, randomInt(), randomInt(), randomFrom((byte) 0, (byte) -1, (byte) 2), -1);
        assertEquals(12, FixedLengthStarTreeNode.START_DOC_ID_OFFSET);
 * SPDX-License-Identifier: Apache-2.0
import org.junit.Before;
        assertEquals(node.getEndDocId(), starTreeNode.getEndDocId());
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;
        assertEquals(starTreeNode.getNumChildren(), count);
            FixedLengthStarTreeNode child = iterator.next();
    }
        nullChild = new InMemoryTreeNode(node.getDimensionId() + 1, randomInt(), randomInt(), (byte) 1, -1);
import static org.mockito.Mockito.when;
            count++;
        long dimensionValue = randomIntBetween(-1, node.getChildren().size() - 3);
    private IndexOutput dataOut;
            assertNotNull(child);
        assertEquals(starTreeDataLength, 33L * node.getChildren().size() + 2 * 33);
    }
import org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter;
        long starTreeDataLength = starTreeWriter.writeStarTree(dataOut, node, 2 + node.getChildren().size(), "star-tree");
            } else {
    }
        node.setAggregatedDocId(randomInt());
    }
        node.addChildNode(childWithMinus1, -1L);
            } else if (count == 2) {
        FixedLengthStarTreeNode starTreeNode = (FixedLengthStarTreeNode) StarTreeFactory.createStarTree(dataIn, starTreeMetadata);
    }
        Iterator<FixedLengthStarTreeNode> iterator = starTreeNode.getChildrenIterator();
        assertEquals(4, FixedLengthStarTreeNode.DIMENSION_VALUE_OFFSET);
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
        }
import static org.mockito.Mockito.mock;
        starChild = new InMemoryTreeNode(node.getDimensionId() + 1, randomInt(), randomInt(), (byte) -1, -1);
        assertNull(nullNode);
        assertEquals(starTreeNode.getNumChildren(), 0);
    }
        directory = newFSDirectory(createTempDir());
                StarTreeTestUtils.assertStarTreeNode(child, nullChild);
        dataOut.close();
        dataOut.close();
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.ALL;
        while (iterator.hasNext()) {
        long starTreeDataLength = starTreeWriter.writeStarTree(dataOut, node, 1, "star-tree");
