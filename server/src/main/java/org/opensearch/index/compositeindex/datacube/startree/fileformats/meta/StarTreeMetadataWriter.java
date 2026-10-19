            metaOut.writeVInt(metricStatOrdinal);
        for (String dimension : starTreeField.getStarTreeConfig().getSkipStarNodeCreationInDims()) {
    public static void writeStarTreeMetadata(
    }
            }
/*
            case NONE:
public class StarTreeMetadataWriter {
}
     * @param metricAggregatorInfos  the list of metric aggregator information
            case SORTED_SET:
import org.apache.logging.log4j.LogManager;
        List<Dimension> dimensionsOrder = starTreeField.getDimensionsOrder();
 *
        metaOut.writeVInt(numNodes);
        }
            starTreeField.getName()
        Integer numStarTreeDocs,
    /**
        // star tree build-mode
 * related to the star tree.
     * @param starTreeField          the star-tree field
        // segment aggregated document count
                return 4;
import java.util.List;
        // segment star tree document count
            metaOut.writeString(dimension);
import org.opensearch.index.compositeindex.datacube.DimensionDataType;
 * The metadata includes information about the dimensions, metrics, and other relevant details
                return 0;
        // number of dimensions
        metaOut.writeVLong(dataFileLength);
     * @param dataFilePointer        the file pointer to the start of the star tree data
                return 1;
        // dimensions
        );
     *
     * @param metaOut                the IndexOutput to write the metadata
     */
        // number of metrics
import org.apache.lucene.index.DocValuesType;
    }
        int numNodes,
        metaOut.writeLong(COMPOSITE_FIELD_MARKER);
     * @throws IOException if an I/O error occurs while writing the header
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
            while (numSubDimensions > 0) {
 * compatible open source license.
                return 2;
        List<MetricAggregatorInfo> metricAggregatorInfos,
     * @param metaOut                   the IndexOutput to write the metadata
        int docDimensionIndex = 0;
        logger.debug(
            dataFilePointer,
    /**
            default:
        IndexOutput metaOut,
        metaOut.writeVInt(VERSION_CURRENT);
        metaOut.writeByte(starTreeField.getStarTreeConfig().getBuildMode().getBuildModeOrdinal());
        metaOut.writeVInt(starTreeField.getStarTreeConfig().getSkipStarNodeCreationInDims().size());
    }
 * this file be licensed under the Apache-2.0 license or a
     * @param dataFileLength         the length of the star tree data file
        );
 *
            numNodes,
        // magic marker for sanity
        metaOut.writeVInt(starTreeField.getStarTreeConfig().maxLeafDocs());
        // star-tree data file pointer
            starTreeField,
     * @param starTreeField             the star tree field
            "Star tree meta size in bytes : {} for star-tree field {}",
        }
        metaOut.writeVLong(dataFilePointer);
        switch (type) {
        for (Dimension currentDimension : dimensionsOrder) {
     * @param segmentAggregatedDocCount the aggregated document count for the segment
    private static void writeMeta(
            metaOut,
                throw new AssertionError("unhandled dimensionDataType: " + dimensionDataType);
        StarTreeField starTreeField,
 * @opensearch.experimental
                metaOut.writeByte(dimensionDataTypeByte(currentDimension.getDimensionDataType()));
     */
    private static void writeMetaHeader(IndexOutput metaOut) throws IOException {
        StarTreeField starTreeField,
        switch (dimensionDataType) {
     * @throws IOException if an I/O error occurs while serializing the metadata
        // skip star node creations
    ) throws IOException {
    private static byte dimensionDataTypeByte(DimensionDataType dimensionDataType) {
        // number of skip star node creation dimensions
/**
     *
     */
import org.opensearch.index.compositeindex.datacube.Dimension;
 */
                numSubDimensions--;
        for (MetricAggregatorInfo metricAggregatorInfo : metricAggregatorInfos) {
        IndexOutput metaOut,
            case SORTED_NUMERIC:
        metaOut.writeVInt(metricAggregatorInfos.size());
     * Writes the star-tree metadata.
    }
            metaOut.writeString(metricAggregatorInfo.getField());
import org.apache.lucene.store.IndexOutput;
     * @param numStarTreeDocs           the total number of star tree documents for the segment
import static org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter.VERSION_CURRENT;
        long dataFilePointer,
     * @param segmentAggregatedCount the aggregated document count for the segment
            case NUMERIC:
    }
    private static final Logger logger = LogManager.getLogger(StarTreeMetadataWriter.class);
import org.opensearch.index.compositeindex.datacube.startree.aggregators.MetricAggregatorInfo;
                return 1;
        // star tree field name
            numStarTreeDocs,
        long dataFileLength
        }
        // number of nodes
        Integer segmentAggregatedDocCount,
     * Writes the star-tree metadata header.
        Integer numStarTreeDocs,
            default:
     * @param metricAggregatorInfos     the list of metric aggregator information
                // BUG
                return 5;
        // metric - metric stat pair
            case LONG:
        long initialMetaFilePointer = metaOut.getFilePointer();
import java.io.IOException;
        metaOut.writeVInt(segmentAggregatedDocCount);
                return 0;
        // max leaf docs
            case SORTED:
            int metricStatOrdinal = metricAggregatorInfo.getMetricStat().getMetricOrdinal();
        // TODO: Replace the parameters with StarTreeMetadata class object
     * @throws IOException if an I/O error occurs while writing the metadata
     * @param numNodes                  number of nodes in the star tree
    ) throws IOException {
        }
        metaOut.writeVInt(starTreeField.getDimensionNames().size());
import org.opensearch.index.mapper.CompositeMappedFieldType;
        // star-tree data file length
            case UNSIGNED_LONG:
package org.opensearch.index.compositeindex.datacube.startree.fileformats.meta;
     * @param metaOut            the IndexOutput to write the header
        writeMetaHeader(metaOut);
        // star tree field type
        List<MetricAggregatorInfo> metricAggregatorInfos,
     * @param dataFilePointer           the file pointer to the start of the star-tree data
        }
     * Writes the star-tree metadata.
     * @param numNodes               number of nodes in the star tree
        Integer numNodes,
    /**
            case BINARY:
                return 3;
                metaOut.writeString(starTreeField.getDimensionNames().get(docDimensionIndex));
        metaOut.writeVInt(numStarTreeDocs);
            segmentAggregatedCount,
import static org.opensearch.index.compositeindex.CompositeIndexConstants.COMPOSITE_FIELD_MARKER;
        long dataFilePointer,
 * The OpenSearch Contributors require contributions made to
 * SPDX-License-Identifier: Apache-2.0
                metaOut.writeByte(docValuesByte(starTreeField.getDimensionDocValueTypes().get(docDimensionIndex)));
 */
            metricAggregatorInfos,
            metaOut.getFilePointer() - initialMetaFilePointer,
        writeMeta(
            dataFileLength
                throw new AssertionError("unhandled DocValuesType: " + type);
        metaOut.writeString(CompositeMappedFieldType.CompositeFieldType.STAR_TREE.getName());
            // Process each sub-dimension
            int numSubDimensions = currentDimension.getNumSubDimensions();
        Integer segmentAggregatedCount,
                docDimensionIndex++;
        // version
        long dataFileLength
    private static byte docValuesByte(DocValuesType type) {
 * The utility class for serializing the metadata of a star-tree data structure.
import org.apache.logging.log4j.Logger;
     * @param dataFileLength            the length of the star-tree data file
     *
        metaOut.writeString(starTreeField.getName());
