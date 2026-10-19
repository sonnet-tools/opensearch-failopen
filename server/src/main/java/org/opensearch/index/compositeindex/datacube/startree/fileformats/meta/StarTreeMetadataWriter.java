        // segment aggregated document count
import org.opensearch.index.compositeindex.datacube.Dimension;
     * @param numStarTreeDocs           the total number of star tree documents for the segment
            case UNSIGNED_LONG:
     * @param segmentAggregatedDocCount the aggregated document count for the segment  
        // metric - metric stat pair
        metaOut.writeVLong(dataFileLength);
     * Writes the star-tree metadata header.  
                return 5;  
import org.apache.logging.log4j.LogManager;
        metaOut.writeVInt(numNodes);  
            numStarTreeDocs,
            starTreeField,
 * compatible open source license.
        metaOut.writeVInt(starTreeField.getStarTreeConfig().getSkipStarNodeCreationInDims().size());  
 *  
            // Process each sub-dimension
 *
        // star-tree data file pointer
     * @param starTreeField          the star-tree field
                docDimensionIndex++;  
            int metricStatOrdinal = metricAggregatorInfo.getMetricStat().getMetricOrdinal();
     *
        Integer segmentAggregatedCount,  
        // number of dimensions
                metaOut.writeByte(docValuesByte(starTreeField.getDimensionDocValueTypes().get(docDimensionIndex)));
public class StarTreeMetadataWriter {  
     * @param dataFilePointer           the file pointer to the start of the star-tree data
        metaOut.writeVInt(starTreeField.getDimensionNames().size());  
     * @param metricAggregatorInfos  the list of metric aggregator information  
                return 2;  
        writeMetaHeader(metaOut);
        }  
            case SORTED:
        Integer numStarTreeDocs,
        // magic marker for sanity  
            metaOut.writeVInt(metricStatOrdinal);
        metaOut.writeByte(starTreeField.getStarTreeConfig().getBuildMode().getBuildModeOrdinal());
}  
        // skip star node creations
            while (numSubDimensions > 0) {  
     * @throws IOException if an I/O error occurs while writing the metadata
 */
     * @param metaOut                the IndexOutput to write the metadata
            metaOut.writeString(metricAggregatorInfo.getField());  
        logger.debug(
import org.apache.logging.log4j.Logger;
     *
        for (MetricAggregatorInfo metricAggregatorInfo : metricAggregatorInfos) {
        IndexOutput metaOut,
                return 1;
                return 4;
     * @param dataFileLength            the length of the star-tree data file  
    }  
import static org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter.VERSION_CURRENT;  
    /**
        // star tree build-mode
                return 0;
        // star tree field name
        Integer segmentAggregatedDocCount,
            case SORTED_SET:  
        metaOut.writeVInt(segmentAggregatedDocCount);  
 * SPDX-License-Identifier: Apache-2.0
                return 0;  
    ) throws IOException {  
        // segment star tree document count
            metaOut,  
     */  
        }
        List<MetricAggregatorInfo> metricAggregatorInfos,
            "Star tree meta size in bytes : {} for star-tree field {}",
        List<Dimension> dimensionsOrder = starTreeField.getDimensionsOrder();  
     * @param metaOut                   the IndexOutput to write the metadata
 * The utility class for serializing the metadata of a star-tree data structure.  
        // dimensions
     * Writes the star-tree metadata.  
        int numNodes,
        int docDimensionIndex = 0;
 * this file be licensed under the Apache-2.0 license or a
        long dataFilePointer,
        Integer numStarTreeDocs,  
        // number of nodes
        StarTreeField starTreeField,  
    /**
        StarTreeField starTreeField,  
        metaOut.writeVLong(dataFilePointer);
        metaOut.writeVInt(starTreeField.getStarTreeConfig().maxLeafDocs());  
        switch (type) {  
                numSubDimensions--;
        );
                throw new AssertionError("unhandled dimensionDataType: " + dimensionDataType);
        switch (dimensionDataType) {
        Integer numNodes,
    private static void writeMeta(  
     * @param dataFileLength         the length of the star tree data file
        }
            metaOut.writeString(dimension);
            case NUMERIC:  
import org.opensearch.index.compositeindex.datacube.DimensionDataType;  
import static org.opensearch.index.compositeindex.CompositeIndexConstants.COMPOSITE_FIELD_MARKER;
            starTreeField.getName()
    }  
    }
            case SORTED_NUMERIC:
            numNodes,  
                metaOut.writeByte(dimensionDataTypeByte(currentDimension.getDimensionDataType()));  
        );
     * @param numNodes                  number of nodes in the star tree
    ) throws IOException {
                // BUG
        for (Dimension currentDimension : dimensionsOrder) {
     */
 * The OpenSearch Contributors require contributions made to  
        metaOut.writeVInt(VERSION_CURRENT);
    public static void writeStarTreeMetadata(
import org.opensearch.index.mapper.CompositeMappedFieldType;  
import java.io.IOException;
import org.opensearch.index.compositeindex.datacube.startree.aggregators.MetricAggregatorInfo;
    private static byte docValuesByte(DocValuesType type) {
        metaOut.writeLong(COMPOSITE_FIELD_MARKER);
        List<MetricAggregatorInfo> metricAggregatorInfos,
    private static final Logger logger = LogManager.getLogger(StarTreeMetadataWriter.class);
     * @param segmentAggregatedCount the aggregated document count for the segment
        // version  
        metaOut.writeVInt(metricAggregatorInfos.size());
     * @param numNodes               number of nodes in the star tree
     * @throws IOException if an I/O error occurs while writing the header  
/*  
            }
        IndexOutput metaOut,
        // TODO: Replace the parameters with StarTreeMetadata class object
                return 3;
        // star tree field type
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
            case BINARY:
     * @throws IOException if an I/O error occurs while serializing the metadata
        metaOut.writeString(starTreeField.getName());  
import org.apache.lucene.index.DocValuesType;  
        long dataFileLength  
        long dataFileLength
     * @param dataFilePointer        the file pointer to the start of the star tree data  
 * The metadata includes information about the dimensions, metrics, and other relevant details
        metaOut.writeString(CompositeMappedFieldType.CompositeFieldType.STAR_TREE.getName());  
        long initialMetaFilePointer = metaOut.getFilePointer();  
            default:  
 * related to the star tree.
 * @opensearch.experimental
 */  
     * @param starTreeField             the star tree field
     *  
        }
import java.util.List;  
     */
            metricAggregatorInfos,
/**
            int numSubDimensions = currentDimension.getNumSubDimensions();  
     * @param metaOut            the IndexOutput to write the header
    /**
package org.opensearch.index.compositeindex.datacube.startree.fileformats.meta;
     * @param metricAggregatorInfos     the list of metric aggregator information  
        // star-tree data file length
    }
        // number of skip star node creation dimensions
     * Writes the star-tree metadata.
            dataFilePointer,  
            case LONG:
        metaOut.writeVInt(numStarTreeDocs);  
    private static byte dimensionDataTypeByte(DimensionDataType dimensionDataType) {  
    }  
        long dataFilePointer,
            segmentAggregatedCount,
                throw new AssertionError("unhandled DocValuesType: " + type);  
            case NONE:
    private static void writeMetaHeader(IndexOutput metaOut) throws IOException {
                return 1;
        // max leaf docs
        }
            dataFileLength
        writeMeta(
import org.apache.lucene.store.IndexOutput;
        // number of metrics
                metaOut.writeString(starTreeField.getDimensionNames().get(docDimensionIndex));
        for (String dimension : starTreeField.getStarTreeConfig().getSkipStarNodeCreationInDims()) {  
            default:
            metaOut.getFilePointer() - initialMetaFilePointer,  
