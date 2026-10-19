    public static StarTreeNode createStarTree(IndexInput data, StarTreeMetadata starTreeMetadata) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
        RandomAccessInput in = data.randomAccessSlice(0, starTreeMetadata.getDataLength());
 * A factory class for creating off-heap implementations of star-tree nodes.
     * @throws IOException If an error occurs while reading the star-tree data.
     */
 */  
/**
}
 * <p>This class provides a static factory method to create instances of {@link StarTreeNode}
    }  
     * @param data The {@link IndexInput} containing the star-tree data.
import org.apache.lucene.store.IndexInput;  
package org.opensearch.index.compositeindex.datacube.startree.node;
 *  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.compositeindex.datacube.startree.fileformats.node.FixedLengthStarTreeNode;  
    /**  
 */  
     * @return A new instance of {@link StarTreeNode} representing the root of the star-tree.  
 * off-heap data structure to store and access the star-tree data efficiently using random access.  
import org.apache.lucene.store.RandomAccessInput;
 * from an {@link IndexInput} and {@link StarTreeMetadata}. The implementation uses an
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
/*  
        return new FixedLengthStarTreeNode(in, 0);
public class StarTreeFactory {
import java.io.IOException;
     * Creates a new instance of {@link StarTreeNode} from the provided {@link IndexInput} and
     * {@link StarTreeMetadata}.
 *
     *  
 * @opensearch.experimental
     * @param starTreeMetadata The {@link StarTreeMetadata} containing metadata about the star-tree.
 * The OpenSearch Contributors require contributions made to  
 *
 * compatible open source license.
