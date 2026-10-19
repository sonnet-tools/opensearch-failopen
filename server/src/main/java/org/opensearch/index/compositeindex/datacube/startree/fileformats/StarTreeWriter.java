    public long writeStarTree(IndexOutput dataOut, InMemoryTreeNode rootNode, int numNodes, String name) throws IOException {
 * Util class for building star tree
     *  
    /** Initial version for the star tree writer */
     * Write star tree metadata to index output stream
/**
     * @param numNodes number of nodes in the star tree  
import java.io.IOException;
import java.util.List;
import org.opensearch.index.compositeindex.datacube.startree.aggregators.MetricAggregatorInfo;
        Integer segmentAggregatedCount,  
            numStarTreeDocs,
        StarTreeMetadataWriter.writeStarTreeMetadata(
     * @param name     name of the star-tree field
            dataFileLength
import org.opensearch.index.compositeindex.datacube.startree.node.InMemoryTreeNode;
 */  
 * compatible open source license.
/*  
        );
        long dataFileLength  
import org.apache.lucene.store.IndexOutput;  
     * @return total size of the three
     * Write star tree to index output stream
    public static final int VERSION_DIMENSION_DATA_TYPE = 1;  
            metricAggregatorInfos,
    ) throws IOException {
        List<MetricAggregatorInfo> metricAggregatorInfos,
            dataFilePointer,  
        Integer numNodes,
    public StarTreeWriter() {}
    }
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.experimental
     */
    /**
     */  
     * @param dataOut  data index output
 */
     * @param metricAggregatorInfos  metric aggregator infos
 *
    public static final int VERSION_CURRENT = VERSION_DIMENSION_DATA_TYPE;  
            segmentAggregatedCount,
            metaOut,  
     * @param dataFilePointer        data file pointer  
    public static final int VERSION_START = 0;  
     * @param segmentAggregatedCount segment aggregated count
 * SPDX-License-Identifier: Apache-2.0
            starTreeField,
    /**  
     * @param rootNode root star-tree node
     * @throws IOException when star-tree data serialization fails
     *
     * @throws IOException when star-tree data serialization fails  
 *  
     * @param numStarTreeDocs           the total number of star tree documents for the segment
    /** Version for the star tree writer with updated metadata which handles unsigned long */
        return StarTreeDataWriter.writeStarTree(dataOut, rootNode, numNodes, name);  
public class StarTreeWriter {  
        IndexOutput metaOut,
        long dataFilePointer,
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
    }  
package org.opensearch.index.compositeindex.datacube.startree.fileformats;
     * @param metaOut                meta index output  
     * @param numNodes               number of nodes in the star tree  
     * @param dataFileLength         data file length
    public void writeStarTreeMetadata(
        StarTreeField starTreeField,  
    /** Current version for the star tree writer */
 * The OpenSearch Contributors require contributions made to  
}
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadataWriter;
import org.opensearch.index.compositeindex.datacube.startree.fileformats.data.StarTreeDataWriter;  
            numNodes,  
     * @param starTreeField          star tree field
        Integer numStarTreeDocs,
