        throw new IllegalArgumentException("dimension [" + dimension + "] does not exist in the segment.");
    public StarTreeValues(
    /**
     */
import java.util.ArrayList;
        for (String dimension : starTreeMetadata.getDimensionFields().keySet()) {
import org.opensearch.index.compositeindex.datacube.MetricStat;
                    metric.getField(),
/*
        return root;
import java.util.LinkedHashMap;
    private final StarTreeField starTreeField;
     * <p>
            readDimensions,
                    assert dimensionfieldInfo != null;
    /**
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.StarTreeMetadata;
import org.apache.lucene.index.DocValuesType;
    /**
                    FieldInfo dimensionfieldInfo = null;
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.StarTreeValuesIterator;
                        dimensionfieldInfo = readState.fieldInfos.fieldInfo(
 * @opensearch.experimental
 * Concrete class that holds the star tree associated values from the segment
 * this file be licensed under the Apache-2.0 license or a
            starTreeMetadata.getMetrics(),
                    dimension,
     * A map containing attributes associated with the star tree values.
    /**
    }
        SegmentReadState readState
            starTreeMetadata.getCompositeFieldName(),
    /**
        attributes = Map.of(
                        );
            );
     */
            new StarTreeFieldConfiguration(
import static org.opensearch.index.compositeindex.CompositeIndexConstants.SEGMENT_DOCS_COUNT;
     * The root node of the star tree.
        for (Map.Entry<String, DimensionConfig> dimensionEntry : starTreeMetadata.getDimensionFields().entrySet()) {
        this.starTreeMetadata = compositeIndexMetadata;
            }
        IndexInput compositeIndexDataIn,
    @Override
            )
    /**
                skipStarNodeCreationInDims,
    }
     * @param sortedNumeric the sorted numeric doc values for a field
     * @param fullyQualifiedMetricName The fully qualified name of the metric.
import org.apache.lucene.index.SegmentReadState;
 *
     * @param sortedSetDv the sortedSet doc values for a field
        Map<String, String> attributes,
        throw new IllegalArgumentException("metric [" + fullyQualifiedMetricName + "] does not exist in the segment.");
                            fullyQualifiedFieldNameForStarTreeDimensionsDocValues(starTreeField.getName(), dimension)
                            if (metricFieldInfo != null) {
                starTreeMetadata.getStarTreeBuildMode()
import org.apache.lucene.index.SortedNumericDocValues;
    public CompositeIndexValues getValues() {
        // create star-tree attributes map
import java.io.IOException;
     * @param compositeIndexDataIn       The IndexInput object for reading the composite index data.
     */
import org.opensearch.index.compositeindex.datacube.ReadDimension;
                try {
     * @param compositeDocValuesProducer The DocValuesProducer object for producing doc values.
     * @return The StarTreeValuesIterator for the specified dimension.
import java.util.function.Supplier;
                    if (dimensionfieldInfo.getDocValuesType().equals(DocValuesType.SORTED_SET)) {
     */
    }
 * compatible open source license.
                    dimensionEntry.getValue().getDimensionDataType()
                )
    private final Map<String, Supplier<StarTreeValuesIterator>> dimensionValuesIteratorMap;
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
        this.metricValuesIteratorMap = metricValuesIteratorMap;
        StarTreeMetadata compositeIndexMetadata
 */
                );
}
                        SortedNumericDocValues metricSortedNumericDocValues = null;
     * @param root                          The root node of the star tree.
 */
                starTreeMetadata.getMaxLeafDocs(),
import org.apache.lucene.index.SortedSetDocValues;
        StarTreeNode root,
     *
        return sortedNumeric == null ? DocValues.emptySortedNumeric() : sortedNumeric;
import org.opensearch.index.compositeindex.datacube.startree.StarTreeFieldConfiguration;
import org.opensearch.index.compositeindex.CompositeIndexMetadata;
        return sortedSetDv == null ? DocValues.emptySortedSet() : sortedSetDv;
                } catch (IOException e) {
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeNode;
     *
    public StarTreeField getStarTreeField() {
                String metricFullName = fullyQualifiedFieldNameForStarTreeMetricsDocValues(
     * @param metricValuesIteratorMap    A map containing suppliers for StarTreeValues iterators for metrics.
    }
                        return new SortedSetStarTreeValuesIterator(getSortedSetDocValues(dimensionSortedSetDocValues));
    ) {
     * @param readState                  The SegmentReadState object representing the state of the segment being read.
    static SortedSetDocValues getSortedSetDocValues(SortedSetDocValues sortedSetDv) {
     * @return empty sortedSet values if the field is not present, else sortedSetDv
    public StarTreeValues(
        return attributes;
     * Returns the sorted numeric doc values for the given sorted numeric field.
import org.apache.lucene.index.FieldInfo;
                        SortedNumericDocValues dimensionSortedNumericDocValues = compositeDocValuesProducer.getSortedNumeric(
     * If the sorted numeric field is null, it returns an empty doc id set iterator.
    private final Map<String, String> attributes;
        return starTreeMetadata.getStarTreeDocCount();
     * SortedSet field can be null for cases where the segment doesn't hold a particular value.
    private final Map<String, Supplier<StarTreeValuesIterator>> metricValuesIteratorMap;
            for (MetricStat metricStat : metric.getBaseMetrics()) {
            String.valueOf(starTreeMetadata.getSegmentAggregatedDocCount()),
                metricValuesIteratorMap.put(metricFullName, () -> {
     */
     * @return The map containing attributes associated with the star tree values.
     *
        if (metricValuesIteratorMap.containsKey(fullyQualifiedMetricName)) {
        return this;
    public StarTreeNode getRoot() {
     */
    /**
        this.starTreeField = starTreeField;
        Set<String> skipStarNodeCreationInDims = starTreeMetadata.getSkipStarNodeCreationInDims();
     * Returns an object representing the star tree field configuration.
import java.util.List;
    }
     */
        // get doc id set iterators for metrics and dimensions
 *
        }
                    metricStat.getTypeName()
     * @param dimensionValuesIteratorMap A map containing suppliers for StarTreeValues iterators for dimensions.
    /**
     * <p>
     */
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.compositeindex.datacube.Metric;
            dimensionValuesIteratorMap.put(dimension, () -> {
            String dimension = dimensionEntry.getKey();
        // get doc id set iterators for dimensions
     */
import org.apache.lucene.store.IndexInput;
public class StarTreeValues implements CompositeIndexValues {
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues;
                    }
        dimensionValuesIteratorMap = new LinkedHashMap<>();
        this.starTreeField = new StarTreeField(
                        fullyQualifiedFieldNameForStarTreeDimensionsDocValues(starTreeMetadata.getCompositeFieldName(), dimension)
/**
        }
        return starTreeField;
     *
            SEGMENT_DOCS_COUNT,
     *
    ) throws IOException {
        this.root = StarTreeFactory.createStarTree(compositeIndexDataIn, starTreeMetadata);
        List<Dimension> readDimensions = new ArrayList<>();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedSetStarTreeValuesIterator;
                            }
@ExperimentalApi
        // get doc id set iterators for metrics
        // build dimensions
            return metricValuesIteratorMap.get(fullyQualifiedMetricName).get();
import org.opensearch.index.compositeindex.datacube.startree.node.StarTreeFactory;
    }
import org.apache.lucene.index.DocValues;
    public int getStarTreeDocumentCount() {
        Map<String, Supplier<StarTreeValuesIterator>> metricValuesIteratorMap,
                                metricSortedNumericDocValues = compositeDocValuesProducer.getSortedNumeric(metricFieldInfo);
        DocValuesProducer compositeDocValuesProducer,
        }
            String.valueOf(starTreeMetadata.getStarTreeDocCount())
    }
            STAR_TREE_DOCS_COUNT,
     * A metadata for the star-tree
     *
     * Returns the root node of the star tree.
     */
                    }
            });
     * @param attributes                    A map containing attributes associated with the star tree values.
     * @return empty sorted numeric values if the field is not present, else sortedNumeric
     * Sorted numeric field can be null for cases where the segment doesn't hold a particular value.
     */
        // Create an unmodifiable view of the map
        }
        // build skip star node dimensions
                    ).getDocValuesType(),
import static org.opensearch.index.compositeindex.CompositeIndexConstants.STAR_TREE_DOCS_COUNT;
        CompositeIndexMetadata compositeIndexMetadata,
        if (dimensionValuesIteratorMap.containsKey(dimension)) {
import org.apache.lucene.codecs.DocValuesProducer;
        }
     * Representing the star tree field configuration.
     * A map containing suppliers for StarTreeValues iterators for metrics.
     * @param starTreeField                 The StarTreeField object representing the star tree field configuration.
                        throw new RuntimeException("Error loading metric DocIdSetIterator", e);
                }
     * Returns the StarTreeValues iterator for the specified fully qualified metric name.
                        );
     *
                new ReadDimension(
    /**
     *
import org.opensearch.index.compositeindex.datacube.startree.fileformats.meta.DimensionConfig;
                        if (readState != null) {
    /**
     * @throws IOException If an I/O error occurs while reading the data.
                    if (readState != null) {
        this.dimensionValuesIteratorMap = dimensionValuesIteratorMap;
    static SortedNumericDocValues getSortedNumericDocValues(SortedNumericDocValues sortedNumeric) {
    /**
    }
     * @param dimension The name of the dimension.
                            dimensionfieldInfo
                    readState.fieldInfos.fieldInfo(
    public Map<String, String> getAttributes() {
                        SortedSetDocValues dimensionSortedSetDocValues = compositeDocValuesProducer.getSortedSet(dimensionfieldInfo);
     */
     */
     * A map containing suppliers for StarTreeValues iterators for dimensions.
    public StarTreeValuesIterator getDimensionValuesIterator(String dimension) {
    /**
package org.opensearch.index.compositeindex.datacube.startree.index;
     */
    }
     */
        );
     *
    /**
import java.util.Map;
        Map<String, Supplier<StarTreeValuesIterator>> dimensionValuesIteratorMap,
        this.root = root;
     * @return The root node of the star tree.
import org.opensearch.common.annotation.ExperimentalApi;
import static org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils.fullyQualifiedFieldNameForStarTreeDimensionsDocValues;
        for (Metric metric : starTreeMetadata.getMetrics()) {
                        return new SortedNumericStarTreeValuesIterator(getSortedNumericDocValues(metricSortedNumericDocValues));
    private final StarTreeMetadata starTreeMetadata;
import java.util.Set;
     * Returns the sortedSet doc values for the given sortedSet field.
        );
     * Constructs a new StarTreeValues object by reading the data from the segment
                    } else {
    /**
                    throw new RuntimeException("Error loading dimension StarTreeValuesIterator", e);
    }
    /**
     * Returns the map containing attributes associated with the star tree values.
     * Returns the StarTreeValues iterator for the specified dimension.
        StarTreeField starTreeField,
     * @return The StarTreeValuesIterator for the specified fully qualified metric name.
                    } catch (IOException e) {
    private final StarTreeNode root;
                    try {
                    }
                });
     * @param compositeIndexMetadata     The CompositeIndexMetadata object containing metadata for the composite index.
        // star-tree field
                    starTreeField.getName(),
import org.opensearch.index.compositeindex.datacube.startree.StarTreeField;
                        }
     * Constructs a new StarTreeValues object with the provided parameters.
            return dimensionValuesIteratorMap.get(dimension).get();
        starTreeMetadata = (StarTreeMetadata) compositeIndexMetadata;
    }
     * Used for testing.
import org.opensearch.index.compositeindex.datacube.Dimension;
                        return new SortedNumericStarTreeValuesIterator(getSortedNumericDocValues(dimensionSortedNumericDocValues));
            readDimensions.add(
     * If the sortedSet field is null, it returns an empty doc id set iterator.
                            FieldInfo metricFieldInfo = readState.fieldInfos.fieldInfo(metricFullName);
        metricValuesIteratorMap = new LinkedHashMap<>();
        this.attributes = attributes;
    public StarTreeValuesIterator getMetricValuesIterator(String fullyQualifiedMetricName) {
     * @return The StarTreeField object representing the star tree field configuration.
