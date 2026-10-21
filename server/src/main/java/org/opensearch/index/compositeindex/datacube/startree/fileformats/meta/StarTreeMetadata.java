                return DocValuesType.SORTED_NUMERIC;
import org.opensearch.index.compositeindex.CompositeIndexMetadata;
     */
     * Returns the build mode for the star-tree.
            String metricName = meta.readString();
        String compositeFieldName,
     *
     * A star tree metadata constructor to initialize star tree metadata from the segment file (.cim) using index input.
            }
 * SPDX-License-Identifier: Apache-2.0
     * @return star-tree field name
            this.metrics = readMetricEntries();
    private static final Logger logger = LogManager.getLogger(StarTreeMetadata.class);
        this.starTreeFieldType = compositeFieldType.getName();
        return metrics;
        for (Map.Entry<String, List<MetricStat>> metricStatsEntry : starTreeMetricStatMap.entrySet()) {
        for (int i = 0; i < dimensionCount; i++) {
     * Returns the type of the star tree field.
    }
    }
    /**
     * @param metrics                       list of metric entries
        return meta.readVInt();
    }
    public int getVersion() {
        return maxLeafDocs;
    }
    }
     *
        this.metrics = metrics;
     * @return star-tree version
     * Returns the name of the star-tree field.
            this.version = version;
     *
     */
/*
     */
            this.starTreeBuildMode = readBuildMode();
    /**
        try {
            throw new CorruptIndexException("Unable to read star-tree metadata from the file", metaIn);
     * @return star-tree length
        return meta.readVInt();
        CompositeMappedFieldType.CompositeFieldType compositeFieldType,
            this.maxLeafDocs = readMaxLeafDocs();
    private List<Metric> readMetricEntries() throws IOException {
     * Returns the max leaf docs for the star-tree.
    }
        IndexInput meta,
    private long readDataStartFilePointer() throws IOException {
            this.dimensionFieldToDimensionConfigMap = readStarTreeDimensions();
            MetricStat metricStat = MetricStat.fromMetricOrdinal(metricStatOrdinal);
    }
    private final StarTreeFieldConfiguration.StarTreeBuildMode starTreeBuildMode;
    /**
    private final String starTreeFieldType;
     *
    /**
                return DocValuesType.NONE;
        int dimensionCount = readDimensionsCount();
    /**
        for (MetricStat metric : MetricStat.values()) {
import org.apache.lucene.index.DocValuesType;
     * The build mode used for constructing the star-tree.
    }
     * Returns the list of metric entries.
     */
     */
     * @return the set of dimensions.
     */
     * @param skipStarNodeCreationInDims    set of dimensions to skip star node creation
        return starTreeBuildMode;
                List<MetricStat> sourceMetrics = metric.getBaseMetrics();
     * @return star-tree field type
    /**
        List<Metric> metrics,
        long dataLength
     * as it dictates dimensionSplitOrder
    /**
     * @param dimensionFieldToDimensionConfigMap  map of dimensionFields to Dimension config
        }
    }
    }
     */
    /**
            } else {
        return numberOfNodes;
     * @return star-tree metric entries
                return DimensionDataType.LONG;
     */
     *
        return meta.readVInt();
     */
        this.starTreeDocCount = starTreeDocCount;
                }
                dimensionFieldToDimensionConfigMap.put(
    private int readNumberOfNodes() throws IOException {
    private final long dataStartFilePointer;
     * @param starTreeBuildMode             star tree build mode
        return starTreeMetricMap;
            metricStats.add(metricStat);
    private int readSkipStarNodeCreationInDimsCount() throws IOException {
    public int getMaxLeafDocs() {
     */
    public int getSegmentAggregatedDocCount() {
    private final int version;
     */
            addEligibleDerivedMetrics(metricStatsEntry.getValue());
    /**
    /**
            default:
        }
            if (getVersion() >= StarTreeWriter.VERSION_DIMENSION_DATA_TYPE) {
import org.apache.logging.log4j.Logger;
            case 5:
    public int getStarTreeDocCount() {
     * @return the aggregated document count for the star-tree.
                return DocValuesType.SORTED_SET;
     * @return star-tree dimension field numbers
        IndexInput metaIn,
 * this file be licensed under the Apache-2.0 license or a
            case 0:
    /**
        return skipStarNodeCreationInDims;
     * The file pointer to the start of the associated star-tree data in the (.cid) file
     * Used for testing.
     * @param segmentAggregatedDocCount     segment aggregated doc count
    private LinkedHashMap<String, DimensionConfig> dimensionFieldToDimensionConfigMap;
            this.skipStarNodeCreationInDims = readSkipStarNodeCreationInDims();
        return version;
        this.dataLength = dataLength;
        switch (b) {
        StarTreeFieldConfiguration.StarTreeBuildMode starTreeBuildMode,
    private final String starTreeFieldName;
        return meta.readVLong();
                    new DimensionConfig(getDocValuesType(meta, meta.readByte()), DimensionDataType.LONG)
     */
        }
     * Returns the list of dimension field numbers.
        Integer numberOfNodes,
        Set<String> skipStarNodeCreationInDims,
     *
        return dataStartFilePointer;
    private final List<Metric> metrics;
     * @param version            The version of the star tree stored in the segments.
                    metricStatsList.add(metric);
     * @param version                       The version of the star tree stored in the segments.
     * The version of the star tree stored in the segments.
        Integer maxLeafDocs,
     */
                    meta.readString(),
            this.starTreeDocCount = readStarTreeDocCount();
    /**
        } catch (Exception e) {
     */
     * The index input for reading metadata from the segment file.
    }
        return meta.readVLong();
     * Returns the set of dimensions for which star node will not be created in the star-tree.
        int skipStarNodeCreationInDimsCount = readSkipStarNodeCreationInDimsCount();
     */
     *
        return meta.readVInt();
    }
     * @throws IOException if unable to read star-tree metadata from the file
     *
import org.apache.logging.log4j.LogManager;
 *
    }
public class StarTreeMetadata extends CompositeIndexMetadata {
        for (int i = 0; i < skipStarNodeCreationInDimsCount; i++) {
     * Returns the number of nodes in the star tree
                return DocValuesType.SORTED;
     * @param dataStartFilePointer          star file pointer to the associated star tree data in (.cid) file
import org.apache.lucene.store.IndexInput;
     * @param starTreeDocCount              the total number of star tree documents for the segment
    private long readDataLength() throws IOException {
     */
                return DocValuesType.NUMERIC;
     * Returns the file pointer to the start of the star-tree data.
    /**
}
    /**
/**
            case 4:
import org.opensearch.common.annotation.ExperimentalApi;
        }
     */
        int metricCount = readMetricsCount();
    private void addEligibleDerivedMetrics(List<MetricStat> metricStatsList) {
     *
    }
        Set<MetricStat> metricStatsSet = new HashSet<>(metricStatsList);
     * Map of dimension fields to their associated DocValuesType. Insertion order needs to be maintained
import org.apache.lucene.index.CorruptIndexException;
    /**
                if (metricStatsSet.containsAll(sourceMetrics)) {
    /**
 * Holds the associated metadata for the building of star-tree.
 * The OpenSearch Contributors require contributions made to
    private int readSegmentAggregatedDocCount() throws IOException {
        return meta.readVInt();
     * Returns the version with which the star tree is stored in the segments
            skipStarNodeCreationInDims.add(meta.readString());
 * compatible open source license.
        return starTreeFieldType;
    private StarTreeFieldConfiguration.StarTreeBuildMode readBuildMode() throws IOException {
        Integer segmentAggregatedDocCount,
    public List<Metric> getMetrics() {
            if (metric.isDerivedMetric() && !metricStatsSet.contains(metric)) {
            this.numberOfNodes = readNumberOfNodes();
     */
            int metricStatOrdinal = meta.readVInt();
            }
        super(compositeFieldName, compositeFieldType);
        super(compositeFieldName, compositeFieldType);
        switch (b) {
    /**
     * @param compositeFieldName name of the composite field. Here, name of the star-tree field.
    /**
     */
import java.util.LinkedHashMap;
        LinkedHashMap<String, DimensionConfig> dimensionFieldToDimensionConfigMap,
     * @param metaIn             an index input to read star-tree meta
     *
     * Returns the total number of star tree documents in the segment
    }
    }
    private static DocValuesType getDocValuesType(IndexInput input, byte b) throws IOException {
    public long getDataLength() {
        return dimensionFieldToDimensionConfigMap;
    /**
        LinkedHashMap<String, DimensionConfig> dimensionFieldToDimensionConfigMap = new LinkedHashMap<>();
     */
        this.starTreeFieldName = compositeFieldName;
 * @opensearch.experimental
            this.starTreeFieldName = this.getCompositeFieldName();
        this.starTreeBuildMode = starTreeBuildMode;
    }
     */
            case 0:
    /**
    }
        this.numberOfNodes = numberOfNodes;
        this.dataStartFilePointer = dataStartFilePointer;
            this.dataStartFilePointer = readDataStartFilePointer();
            this.starTreeFieldType = this.getCompositeFieldType().getName();
    public String getStarTreeFieldType() {
    private final int numberOfNodes;
     * Returns the aggregated document count for the star-tree.
            case 2:
 */
     * Add derived metrics if all associated base metrics are present
        return StarTreeFieldConfiguration.StarTreeBuildMode.fromBuildModeOrdinal(meta.readByte());
            case 1:
            this.segmentAggregatedDocCount = readSegmentAggregatedDocCount();
    private final int segmentAggregatedDocCount;
     * The type of the star-tree field, indicating the specific implementation or version.
                return DimensionDataType.UNSIGNED_LONG;
    }
    }
    private int readMetricsCount() throws IOException {
    private final Set<String> skipStarNodeCreationInDims;
     *
        return dimensionFieldToDimensionConfigMap;
                    metricStatsSet.add(metric);
    public Set<String> getSkipStarNodeCreationInDims() {
    ) {
    /**
     */
        String compositeFieldName,
     */
        List<Metric> starTreeMetricMap = new ArrayList<>();
    private final int starTreeDocCount;
    /**
                );
    }
    }
     */
                return DocValuesType.BINARY;
import java.io.IOException;
    private LinkedHashMap<String, DimensionConfig> readStarTreeDimensions() throws IOException {
     * Here, STAR_TREE field.
    public String getStarTreeFieldName() {
     * @return the number of star tree documents in the segment
 *
import java.util.List;
        return starTreeDocCount;
                throw new CorruptIndexException("invalid dimensionDataType byte: " + b, input);
    }
     */
        return meta.readVInt();
    }
     * @param compositeFieldName            name of the composite field. Here, name of the star-tree field.
     * The length of the star-tree data in bytes, used for reading the correct amount of data from (.cid) file
    }
    /**
     *
        return skipStarNodeCreationInDims;
            List<MetricStat> metricStats = starTreeMetricStatMap.computeIfAbsent(metricName, field -> new ArrayList<>());
        return starTreeFieldName;
    private static DimensionDataType getDimensionDataType(IndexInput input, byte b) throws IOException {
     * @return number of nodes in the star tree
     * The maximum number of documents allowed in a leaf node.
     * Returns the length of star-tree data
    /**
    private Set<String> readSkipStarNodeCreationInDims() throws IOException {
    /**
        }
        this.skipStarNodeCreationInDims = skipStarNodeCreationInDims;
                throw new CorruptIndexException("invalid docvalues byte: " + b, input);
        this.maxLeafDocs = maxLeafDocs;
    /**
import java.util.Map;
            starTreeMetricMap.add(new Metric(metricStatsEntry.getKey(), metricStatsEntry.getValue()));
        return dataLength;
        this.segmentAggregatedDocCount = segmentAggregatedDocCount;
     * The number of the nodes in the respective star tree
            case 3:
    public StarTreeMetadata(
     * The total number of documents aggregated in this star-tree segment.
                    new DimensionConfig(getDocValuesType(meta, meta.readByte()), getDimensionDataType(meta, meta.readByte()))
    /**
    }
    ) throws IOException {
     */
    private final IndexInput meta;
        this.meta = meta;
@ExperimentalApi
     * @return the max leaf docs.
     * A star tree metadata constructor to initialize star tree metadata.
     * @param maxLeafDocs                   max leaf docs
    public int getNumberOfNodes() {
            case 1:
        Set<String> skipStarNodeCreationInDims = new HashSet<>();
     * @param compositeFieldType type of the composite field. Here, STAR_TREE field.
    }
    public long getDataStartFilePointer() {
        this.meta = metaIn;
     * Set of dimensions for which star node creation should be skipped.
        Integer version,
     */
     * @param meta                          an index input to read star-tree meta
     */
package org.opensearch.index.compositeindex.datacube.startree.fileformats.meta;
        Integer version
    }
     * @param dataLength                    length of the corresponding star-tree data in (.cid) file
            this.dataLength = readDataLength();
            logger.error("Unable to read star-tree metadata from the file");
 */
        Integer starTreeDocCount,
    /**
    }
     * @return the star-tree build mode.
    private final int maxLeafDocs;
    private int readDimensionsCount() throws IOException {
                dimensionFieldToDimensionConfigMap.put(
import org.opensearch.index.compositeindex.datacube.Metric;
    }
    /**
        CompositeMappedFieldType.CompositeFieldType compositeFieldType,
        this.version = version;
     */
     *
        }
    public StarTreeMetadata(
    /**
     * The number of star tree documents in the star tree.
                );
     *
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
    private final long dataLength;
                    meta.readString(),
            default:
     */
     * List of metrics, containing field names and associated metric statistics.
import org.opensearch.index.compositeindex.datacube.MetricStat;
import java.util.ArrayList;
    }
    public Map<String, DimensionConfig> getDimensionFields() {
        return segmentAggregatedDocCount;
     * The name of the star-tree field, used to identify the star-tree.
        long dataStartFilePointer,
        this.dimensionFieldToDimensionConfigMap = dimensionFieldToDimensionConfigMap;
     *
     * @param compositeFieldType            type of the composite field. Here, STAR_TREE field.
    private int readMaxLeafDocs() throws IOException {
        for (int i = 0; i < metricCount; i++) {
    private Integer readStarTreeDocCount() throws IOException {
     * @return start file pointer for star-tree data
import java.util.Set;
    public StarTreeFieldConfiguration.StarTreeBuildMode getStarTreeBuildMode() {
        }
import org.opensearch.index.compositeindex.datacube.DimensionDataType;
import java.util.HashSet;
import org.opensearch.index.mapper.CompositeMappedFieldType;
        return meta.readVInt();
import org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter;
        Map<String, List<MetricStat>> starTreeMetricStatMap = new LinkedHashMap<>();
        }
