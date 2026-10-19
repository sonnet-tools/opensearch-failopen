    }
            starTreeMetadata.getCompositeFieldName(),
            )  
        return starTreeField;
import org.opensearch.index.compositeindex.CompositeIndexMetadata;
                        return new SortedSetStarTreeValuesIterator(getSortedSetDocValues(dimensionSortedSetDocValues));
        }
                        throw new RuntimeException("Error loading metric DocIdSetIterator", e);  
     *
     * Returns the sortedSet doc values for the given sortedSet field.
    /**
                            fullyQualifiedFieldNameForStarTreeDimensionsDocValues(starTreeField.getName(), dimension)
    public StarTreeValues(
        StarTreeField starTreeField,  
            new StarTreeFieldConfiguration(
     * @return The StarTreeValuesIterator for the specified fully qualified metric name.  
     */
    /**
    /**
import org.apache.lucene.store.IndexInput;
    }  
    private final StarTreeMetadata starTreeMetadata;
     * @return The StarTreeValuesIterator for the specified dimension.  
                        return new SortedNumericStarTreeValuesIterator(getSortedNumericDocValues(dimensionSortedNumericDocValues));  
    /**
     * @param fullyQualifiedMetricName The fully qualified name of the metric.
     */  
    /**
    private final StarTreeField starTreeField;
        this.metricValuesIteratorMap = metricValuesIteratorMap;
     */  
 */  
import static org.opensearch.index.compositeindex.CompositeIndexConstants.SEGMENT_DOCS_COUNT;  
public class StarTreeValues implements CompositeIndexValues {
     *
                    try {
        // star-tree field  
        }  
     * SortedSet field can be null for cases where the segment doesn't hold a particular value.
    }
 * SPDX-License-Identifier: Apache-2.0
    }  
            String.valueOf(starTreeMetadata.getSegmentAggregatedDocCount()),
     * @return The map containing attributes associated with the star tree values.
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;
                    starTreeField.getName(),  
        return sortedNumeric == null ? DocValues.emptySortedNumeric() : sortedNumeric;
                }
    ) throws IOException {
            readDimensions,  
     * If the sorted numeric field is null, it returns an empty doc id set iterator.
        this.dimensionValuesIteratorMap = dimensionValuesIteratorMap;  
    /**
import java.util.List;
            return metricValuesIteratorMap.get(fullyQualifiedMetricName).get();
        for (Metric metric : starTreeMetadata.getMetrics()) {  
        starTreeMetadata = (StarTreeMetadata) compositeIndexMetadata;
import org.opensearch.index.compositeindex.datacube.ReadDimension;
     * @param dimensionValuesIteratorMap A map containing suppliers for StarTreeValues iterators for dimensions.
                metricValuesIteratorMap.put(metricFullName, () -> {
    }  
     */
        StarTreeNode root,
/*  
        Map<String, Supplier<StarTreeValuesIterator>> metricValuesIteratorMap,  
                        SortedNumericDocValues dimensionSortedNumericDocValues = compositeDocValuesProducer.getSortedNumeric(  
     *
            SEGMENT_DOCS_COUNT,
                    } else {
                    }
        Map<String, String> attributes,
    static SortedNumericDocValues getSortedNumericDocValues(SortedNumericDocValues sortedNumeric) {  
        return attributes;
@ExperimentalApi
                });
}
    /**  
     * Returns the StarTreeValues iterator for the specified dimension.  
     */  
     * @param compositeIndexMetadata     The CompositeIndexMetadata object containing metadata for the composite index.  
/**
     * If the sortedSet field is null, it returns an empty doc id set iterator.  
     *
    public StarTreeField getStarTreeField() {
     */
        this.starTreeField = new StarTreeField(
            STAR_TREE_DOCS_COUNT,  
                    if (readState != null) {
     *
     * @param metricValuesIteratorMap    A map containing suppliers for StarTreeValues iterators for metrics.
     * @param attributes                    A map containing attributes associated with the star tree values.  
     *  
     * @param dimension The name of the dimension.
                starTreeMetadata.getMaxLeafDocs(),  
     * Returns the map containing attributes associated with the star tree values.  
        SegmentReadState readState
        return root;
        // get doc id set iterators for dimensions  
                        dimensionfieldInfo = readState.fieldInfos.fieldInfo(  
import java.util.function.Supplier;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
    /**
                    dimensionEntry.getValue().getDimensionDataType()
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.StarTreeValuesIterator;
                    throw new RuntimeException("Error loading dimension StarTreeValuesIterator", e);  
                        SortedNumericDocValues metricSortedNumericDocValues = null;  
    /**
    static SortedSetDocValues getSortedSetDocValues(SortedSetDocValues sortedSetDv) {
        Map<String, Supplier<StarTreeValuesIterator>> dimensionValuesIteratorMap,
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.DimensionConfig;
                            if (metricFieldInfo != null) {  
        }  
 * The OpenSearch Contributors require contributions made to  
     */  
                starTreeMetadata.getStarTreeBuildMode()
        if (dimensionValuesIteratorMap.containsKey(dimension)) {
        // create star-tree attributes map  
     * @throws IOException If an I/O error occurs while reading the data.
                    }  
        this.root = StarTreeFactory.createStarTree(compositeIndexDataIn, starTreeMetadata);  
                    if (dimensionfieldInfo.getDocValuesType().equals(DocValuesType.SORTED_SET)) {
        }  
                        );
    ) {  
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues;  
    private final Map<String, String> attributes;  
     */
 * this file be licensed under the Apache-2.0 license or a
        attributes = Map.of(  
import org.apache.lucene.index.DocValues;
import org.apache.lucene.index.DocValuesType;  
     * A map containing suppliers for StarTreeValues iterators for dimensions.  
 *
            String.valueOf(starTreeMetadata.getStarTreeDocCount())
        return sortedSetDv == null ? DocValues.emptySortedSet() : sortedSetDv;
     * Returns the sorted numeric doc values for the given sorted numeric field.
import java.util.LinkedHashMap;  
     * Returns the root node of the star tree.  
    }
    public StarTreeNode getRoot() {
    private final Map<String, Supplier<StarTreeValuesIterator>> dimensionValuesIteratorMap;
     *
            );  
import org.apache.lucene.codecs.DocValuesProducer;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;  
     *
        // Create an unmodifiable view of the map
     * Sorted numeric field can be null for cases where the segment doesn't hold a particular value.
        this.attributes = attributes;
import java.io.IOException;
import java.util.Set;  
                        }  
    public Map<String, String> getAttributes() {
    private final StarTreeNode root;  
     * @param compositeDocValuesProducer The DocValuesProducer object for producing doc values.
    private final Map<String, Supplier<StarTreeValuesIterator>> metricValuesIteratorMap;
import org.opensearch.index.compositeindex.datacube.Metric;  
                );  
     * @param sortedNumeric the sorted numeric doc values for a field  
        IndexInput compositeIndexDataIn,
    /**  
        metricValuesIteratorMap = new LinkedHashMap<>();
                try {  
                                metricSortedNumericDocValues = compositeDocValuesProducer.getSortedNumeric(metricFieldInfo);
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeDimensionsDocValues;
    }  
                    metric.getField(),
     */
     * Constructs a new StarTreeValues object by reading the data from the segment
                )
import org.apache.lucene.index.SortedNumericDocValues;  
     */
        throw new IllegalArgumentException("dimension [" + dimension + "] does not exist in the segment.");
     * Constructs a new StarTreeValues object with the provided parameters.
     * @param sortedSetDv the sortedSet doc values for a field
import static org.opensearch.index.compositeindex.CompositeIndexConstants.STAR_TREE_DOCS_COUNT;
     *
     * <p>  
import org.apache.lucene.index.FieldInfo;
    /**
     */  
                            }
import java.util.ArrayList;
        if (metricValuesIteratorMap.containsKey(fullyQualifiedMetricName)) {
    /**  
        Set<String> skipStarNodeCreationInDims = starTreeMetadata.getSkipStarNodeCreationInDims();
     */
        );
                    assert dimensionfieldInfo != null;
    }  
     * @return empty sortedSet values if the field is not present, else sortedSetDv
                        fullyQualifiedFieldNameForStarTreeDimensionsDocValues(starTreeMetadata.getCompositeFieldName(), dimension)
     * Returns the StarTreeValues iterator for the specified fully qualified metric name.  
            starTreeMetadata.getMetrics(),
     * @return The root node of the star tree.
        this.root = root;
        this.starTreeMetadata = compositeIndexMetadata;  
        return this;
                        return new SortedNumericStarTreeValuesIterator(getSortedNumericDocValues(metricSortedNumericDocValues));
     * @param compositeIndexDataIn       The IndexInput object for reading the composite index data.
package org.opensearch.index.compositeindex.datacube.startree.index;
        // build dimensions  
     * @return empty sorted numeric values if the field is not present, else sortedNumeric
                            dimensionfieldInfo
                            FieldInfo metricFieldInfo = readState.fieldInfos.fieldInfo(metricFullName);
            }  
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;  
                    dimension,  
     */
        DocValuesProducer compositeDocValuesProducer,  
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;
        return starTreeMetadata.getStarTreeDocCount();  
    public StarTreeValuesIterator getDimensionValuesIterator(String dimension) {
import org.apache.lucene.index.SegmentReadState;
    /**  
        // build skip star node dimensions  
import java.util.Map;
     * @param starTreeField                 The StarTreeField object representing the star tree field configuration.
        CompositeIndexMetadata compositeIndexMetadata,
     * @param readState                  The SegmentReadState object representing the state of the segment being read.  
            });
                        );
    }
import org.opensearch.common.annotation.ExperimentalApi;  
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;  
        }
     * <p>
                    readState.fieldInfos.fieldInfo(
        dimensionValuesIteratorMap = new LinkedHashMap<>();  
     * Representing the star tree field configuration.
                } catch (IOException e) {
        throw new IllegalArgumentException("metric [" + fullyQualifiedMetricName + "] does not exist in the segment.");
                String metricFullName = fullyQualifiedFieldNameForStarTreeMetricsDocValues(
     * The root node of the star tree.
                    }
     */
import org.opensearch.index.compositeindex.datacube.Dimension;
    @Override  
                    metricStat.getTypeName()
    public CompositeIndexValues getValues() {
     * A map containing attributes associated with the star tree values.
import org.opensearch.index.compositeindex.datacube.MetricStat;
 *
import org.apache.lucene.index.SortedSetDocValues;
 * Concrete class that holds the star tree associated values from the segment  
            readDimensions.add(
        // get doc id set iterators for metrics and dimensions
    public StarTreeValuesIterator getMetricValuesIterator(String fullyQualifiedMetricName) {
        this.starTreeField = starTreeField;
    /**
        // get doc id set iterators for metrics
                    } catch (IOException e) {
            return dimensionValuesIteratorMap.get(dimension).get();
 * compatible open source license.
        );
                        if (readState != null) {
                skipStarNodeCreationInDims,
                new ReadDimension(
     * Used for testing.  
            dimensionValuesIteratorMap.put(dimension, () -> {
        for (Map.Entry<String, DimensionConfig> dimensionEntry : starTreeMetadata.getDimensionFields().entrySet()) {
     * A map containing suppliers for StarTreeValues iterators for metrics.
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeFactory;
            for (MetricStat metricStat : metric.getBaseMetrics()) {
    /**
                        SortedSetDocValues dimensionSortedSetDocValues = compositeDocValuesProducer.getSortedSet(dimensionfieldInfo);  
     */  
            String dimension = dimensionEntry.getKey();  
     * @return The StarTreeField object representing the star tree field configuration.
 * @opensearch.experimental
        List<Dimension> readDimensions = new ArrayList<>();
        for (String dimension : starTreeMetadata.getDimensionFields().keySet()) {
     * @param root                          The root node of the star tree.  
     * A metadata for the star-tree  
 */  
    public StarTreeValues(  
                    FieldInfo dimensionfieldInfo = null;
    public int getStarTreeDocumentCount() {
        StarTreeMetadata compositeIndexMetadata
    }  
                    ).getDocValuesType(),  
     * Returns an object representing the star tree field configuration.  
    }  
