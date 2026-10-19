     * @param skipStarNodeCreationInDims    set of dimensions to skip star node creation  
    /**
     * Returns the length of star-tree data
        LinkedHashMap<String, DimensionConfig> dimensionFieldToDimensionConfigMap,
    }
    public StarTreeMetadata(
     * @throws IOException if unable to read star-tree metadata from the file
                    new DimensionConfig(getDocValuesType(meta, meta.readByte()), getDimensionDataType(meta, meta.readByte()))  
     */
    /**  
import org.apache.lucene.index.DocValuesType;  
     * @param version                       The version of the star tree stored in the segments.  
    }
     * List of metrics, containing field names and associated metric statistics.
        Integer version,  
    }
        return meta.readVLong();  
     * The index input for reading metadata from the segment file.
     * @return start file pointer for star-tree data  
     * Returns the aggregated document count for the star-tree.
        int metricCount = readMetricsCount();
    private int readMaxLeafDocs() throws IOException {  
                if (metricStatsSet.containsAll(sourceMetrics)) {
            String metricName = meta.readString();  
    }
            logger.error("Unable to read star-tree metadata from the file");  
    public int getMaxLeafDocs() {
    }  
        this.numberOfNodes = numberOfNodes;
}
 * @opensearch.experimental
    private final StarTreeFieldConfiguration.StarTreeBuildMode starTreeBuildMode;
    private void addEligibleDerivedMetrics(List<MetricStat> metricStatsList) {  
            this.dataLength = readDataLength();
     */
        return dimensionFieldToDimensionConfigMap;  
        Integer segmentAggregatedDocCount,
     * @return the aggregated document count for the star-tree.  
                return DocValuesType.NONE;  
            case 0:
    }
 */
     * @param dimensionFieldToDimensionConfigMap  map of dimensionFields to Dimension config
     */
        return meta.readVInt();
            this.skipStarNodeCreationInDims = readSkipStarNodeCreationInDims();
 * The OpenSearch Contributors require contributions made to  
     * Add derived metrics if all associated base metrics are present
        switch (b) {
        return numberOfNodes;  
/**
     *
        IndexInput meta,
     * Here, STAR_TREE field.
    }
        }  
    /**  
    }
     * The build mode used for constructing the star-tree.  
                }
    /**  
    /**  
     */
    /**  
     */
            default:
/*  
            List<MetricStat> metricStats = starTreeMetricStatMap.computeIfAbsent(metricName, field -> new ArrayList<>());  
    private final int maxLeafDocs;
        int skipStarNodeCreationInDimsCount = readSkipStarNodeCreationInDimsCount();
     */
     * Returns the max leaf docs for the star-tree.
 * Holds the associated metadata for the building of star-tree.
import org.opensearch.index.compositeindex.datacube.MetricStat;  
        Integer starTreeDocCount,
     */  
    /**  
        List<Metric> starTreeMetricMap = new ArrayList<>();  
     * Returns the version with which the star tree is stored in the segments
        for (Map.Entry<String, List<MetricStat>> metricStatsEntry : starTreeMetricStatMap.entrySet()) {
     * The maximum number of documents allowed in a leaf node.
import java.util.ArrayList;  
     *
     * @return star-tree field type  
     */
            }
    /**  
import java.util.Map;
        this.skipStarNodeCreationInDims = skipStarNodeCreationInDims;
    public int getVersion() {
        return starTreeBuildMode;  
     * @return star-tree length  
        return meta.readVInt();
                throw new CorruptIndexException("invalid dimensionDataType byte: " + b, input);
     */  
     *
    private static DocValuesType getDocValuesType(IndexInput input, byte b) throws IOException {  
    }
     * @param metaIn             an index input to read star-tree meta
                List<MetricStat> sourceMetrics = metric.getBaseMetrics();
        Set<String> skipStarNodeCreationInDims = new HashSet<>();
    public StarTreeMetadata(
     * Returns the set of dimensions for which star node will not be created in the star-tree.
    /**  
    private final int numberOfNodes;
    }
        this.dataLength = dataLength;
     * A star tree metadata constructor to initialize star tree metadata.  
    /**
public class StarTreeMetadata extends CompositeIndexMetadata {
     */
            this.maxLeafDocs = readMaxLeafDocs();  
            addEligibleDerivedMetrics(metricStatsEntry.getValue());
        CompositeMappedFieldType.CompositeFieldType compositeFieldType,
import java.io.IOException;
    }
        this.maxLeafDocs = maxLeafDocs;
     */
     */
        return meta.readVInt();
     * @return star-tree metric entries  
        } catch (Exception e) {
     */  
                    metricStatsList.add(metric);  
                    meta.readString(),
    /**  
        this.meta = meta;
                    new DimensionConfig(getDocValuesType(meta, meta.readByte()), DimensionDataType.LONG)
     *
        this.dataStartFilePointer = dataStartFilePointer;
    private final int starTreeDocCount;
     * The number of star tree documents in the star tree.  
            }  
            case 2:  
     *
    }
     * @param version            The version of the star tree stored in the segments.
    }
 * SPDX-License-Identifier: Apache-2.0
     */  
        this.dimensionFieldToDimensionConfigMap = dimensionFieldToDimensionConfigMap;  
    private static final Logger logger = LogManager.getLogger(StarTreeMetadata.class);
        super(compositeFieldName, compositeFieldType);
        this.starTreeBuildMode = starTreeBuildMode;  
     * @param metrics                       list of metric entries
    }
     * @param dataStartFilePointer          star file pointer to the associated star tree data in (.cid) file
            case 5:  
        return meta.readVInt();
            this.starTreeFieldName = this.getCompositeFieldName();
                    metricStatsSet.add(metric);
     *
import org.opensearch.common.annotation.ExperimentalApi;
        super(compositeFieldName, compositeFieldType);  
     */
        String compositeFieldName,  
     * Returns the list of dimension field numbers.
    /**
 * this file be licensed under the Apache-2.0 license or a
    private final long dataStartFilePointer;
        this.starTreeFieldType = compositeFieldType.getName();  
                return DocValuesType.SORTED_SET;
     * @param compositeFieldName            name of the composite field. Here, name of the star-tree field.
    /**  
     *
        switch (b) {
    }
        int dimensionCount = readDimensionsCount();
    }
import org.apache.logging.log4j.LogManager;  
    private final IndexInput meta;
     *
        }
    private int readSegmentAggregatedDocCount() throws IOException {
            this.dimensionFieldToDimensionConfigMap = readStarTreeDimensions();
        }
     * @return the max leaf docs.  
     * @param compositeFieldType            type of the composite field. Here, STAR_TREE field.
     * @param maxLeafDocs                   max leaf docs
    private int readSkipStarNodeCreationInDimsCount() throws IOException {
                return DocValuesType.BINARY;
    private final long dataLength;  
     * @return star-tree version  
            case 0:  
        for (int i = 0; i < metricCount; i++) {
        return dataStartFilePointer;  
        this.starTreeDocCount = starTreeDocCount;  
        Set<String> skipStarNodeCreationInDims,
        return meta.readVInt();
        return dataLength;  
            skipStarNodeCreationInDims.add(meta.readString());
    private int readDimensionsCount() throws IOException {  
        String compositeFieldName,  
     *
     *
     */
            if (metric.isDerivedMetric() && !metricStatsSet.contains(metric)) {  
        return starTreeMetricMap;  
        return version;  
    public String getStarTreeFieldName() {
 * compatible open source license.
     */  
     */
            metricStats.add(metricStat);
        return maxLeafDocs;  
import org.apache.lucene.index.CorruptIndexException;
     * as it dictates dimensionSplitOrder
        Integer maxLeafDocs,  
     *
import java.util.LinkedHashMap;
        return segmentAggregatedDocCount;  
     */
    }
    /**  
     * Returns the number of nodes in the star tree
        Integer version
        long dataStartFilePointer,  
     * @return the number of star tree documents in the segment  
        return starTreeFieldName;  
     */  
        }
     * The number of the nodes in the respective star tree  
        CompositeMappedFieldType.CompositeFieldType compositeFieldType,
    /**  
     * The name of the star-tree field, used to identify the star-tree.
    /**
    }
     * @param starTreeBuildMode             star tree build mode
    public Map<String, DimensionConfig> getDimensionFields() {
        return dimensionFieldToDimensionConfigMap;  
    ) throws IOException {  
    }
    private List<Metric> readMetricEntries() throws IOException {
    }  
     */
     */
    /**  
        return meta.readVInt();  
    /**
     * The version of the star tree stored in the segments.
            this.segmentAggregatedDocCount = readSegmentAggregatedDocCount();
        LinkedHashMap<String, DimensionConfig> dimensionFieldToDimensionConfigMap = new LinkedHashMap<>();  
        return starTreeDocCount;  
    }
            int metricStatOrdinal = meta.readVInt();
    private static DimensionDataType getDimensionDataType(IndexInput input, byte b) throws IOException {
    private final Set<String> skipStarNodeCreationInDims;  
     * The total number of documents aggregated in this star-tree segment.  
import org.opensearch.index.mapper.CompositeMappedFieldType;  
        }
        }
    }
import java.util.List;  
            this.version = version;  
        List<Metric> metrics,  
     * Used for testing.
     * Returns the total number of star tree documents in the segment
    private final String starTreeFieldName;
    }
    private final int version;  
import org.opensearch.index.compositeindex.datacube.startree.fileformats.StarTreeWriter;
    private StarTreeFieldConfiguration.StarTreeBuildMode readBuildMode() throws IOException {  
        return meta.readVInt();  
        }
 *
    private final List<Metric> metrics;  
    ) {
package org.opensearch.index.compositeindex.datacube.startree.fileformats.meta;
                return DocValuesType.SORTED_NUMERIC;
     * @return number of nodes in the star tree  
            this.starTreeDocCount = readStarTreeDocCount();
     * @return star-tree dimension field numbers  
     */  
            this.metrics = readMetricEntries();  
     * @return star-tree field name  
    /**  
     */
                dimensionFieldToDimensionConfigMap.put(
    public String getStarTreeFieldType() {
    public Set<String> getSkipStarNodeCreationInDims() {
    public long getDataStartFilePointer() {
     * @param segmentAggregatedDocCount     segment aggregated doc count  
        this.segmentAggregatedDocCount = segmentAggregatedDocCount;
    /**  
    private Integer readStarTreeDocCount() throws IOException {
     */
     * Returns the type of the star tree field.
                return DimensionDataType.LONG;
    private final int segmentAggregatedDocCount;
     * Set of dimensions for which star node creation should be skipped.
    /**  
    public List<Metric> getMetrics() {
        for (MetricStat metric : MetricStat.values()) {
    private int readMetricsCount() throws IOException {  
import org.apache.logging.log4j.Logger;
     * A star tree metadata constructor to initialize star tree metadata from the segment file (.cim) using index input.
    public StarTreeFieldConfiguration.StarTreeBuildMode getStarTreeBuildMode() {
     * @param compositeFieldName name of the composite field. Here, name of the star-tree field.
            MetricStat metricStat = MetricStat.fromMetricOrdinal(metricStatOrdinal);
        Set<MetricStat> metricStatsSet = new HashSet<>(metricStatsList);
        IndexInput metaIn,
     * The file pointer to the start of the associated star-tree data in the (.cid) file
        return skipStarNodeCreationInDims;  
            case 4:
import java.util.Set;
     * Returns the file pointer to the start of the star-tree data.
        for (int i = 0; i < dimensionCount; i++) {
        this.meta = metaIn;
    public int getSegmentAggregatedDocCount() {
     * Returns the build mode for the star-tree.
    }  
    private long readDataStartFilePointer() throws IOException {
                    meta.readString(),
            this.starTreeBuildMode = readBuildMode();
import org.apache.lucene.store.IndexInput;
    }
            throw new CorruptIndexException("Unable to read star-tree metadata from the file", metaIn);
    private LinkedHashMap<String, DimensionConfig> readStarTreeDimensions() throws IOException {
import org.opensearch.index.compositeindex.CompositeIndexMetadata;  
                return DimensionDataType.UNSIGNED_LONG;  
     * @return the set of dimensions.  
@ExperimentalApi  
        this.metrics = metrics;
    private int readNumberOfNodes() throws IOException {
    private LinkedHashMap<String, DimensionConfig> dimensionFieldToDimensionConfigMap;
     * Returns the list of metric entries.
     */
        }
        long dataLength
                return DocValuesType.NUMERIC;
        StarTreeFieldConfiguration.StarTreeBuildMode starTreeBuildMode,
        Map<String, List<MetricStat>> starTreeMetricStatMap = new LinkedHashMap<>();
            default:
        this.starTreeFieldName = compositeFieldName;
     * The length of the star-tree data in bytes, used for reading the correct amount of data from (.cid) file
            if (getVersion() >= StarTreeWriter.VERSION_DIMENSION_DATA_TYPE) {  
     */
     * @param starTreeDocCount              the total number of star tree documents for the segment
                throw new CorruptIndexException("invalid docvalues byte: " + b, input);  
    public long getDataLength() {
        return skipStarNodeCreationInDims;  
 *  
    private long readDataLength() throws IOException {
    }
    }  
                );  
     * @return the star-tree build mode.  
        return meta.readVLong();
     *
     * @param dataLength                    length of the corresponding star-tree data in (.cid) file  
        return starTreeFieldType;  
                return DocValuesType.SORTED;  
     * @param meta                          an index input to read star-tree meta  
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
     *
     *
    /**
    /**  
import org.opensearch.index.compositeindex.datacube.Metric;
    }  
    /**  
     * Map of dimension fields to their associated DocValuesType. Insertion order needs to be maintained
                );
        Integer numberOfNodes,
            starTreeMetricMap.add(new Metric(metricStatsEntry.getKey(), metricStatsEntry.getValue()));  
    /**  
            this.numberOfNodes = readNumberOfNodes();
     */
     */
     * The type of the star-tree field, indicating the specific implementation or version.
            this.dataStartFilePointer = readDataStartFilePointer();  
            case 3:
import org.opensearch.index.compositeindex.datacube.DimensionDataType;
     * Returns the name of the star-tree field.
        return StarTreeFieldConfiguration.StarTreeBuildMode.fromBuildModeOrdinal(meta.readByte());
                dimensionFieldToDimensionConfigMap.put(  
            } else {
        this.version = version;
     * @param compositeFieldType type of the composite field. Here, STAR_TREE field.  
    /**
    /**  
    }
    }
     */
        try {  
    }
            case 1:
    private final String starTreeFieldType;
            this.starTreeFieldType = this.getCompositeFieldType().getName();
    /**
    /**
    private Set<String> readSkipStarNodeCreationInDims() throws IOException {
            case 1:
import java.util.HashSet;
     *  
    public int getNumberOfNodes() {
        for (int i = 0; i < skipStarNodeCreationInDimsCount; i++) {  
 */  
        return metrics;  
    public int getStarTreeDocCount() {
    /**
