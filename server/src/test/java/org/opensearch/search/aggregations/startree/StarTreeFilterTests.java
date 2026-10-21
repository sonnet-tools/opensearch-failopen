        return directory;
import java.util.Map;
import org.apache.lucene.index.IndexableField;
                b.value("sdv");
        Mockito.when(searchContext.mapperService()).thenReturn(mapperService);
            mapperService = StarTreeDocValuesFormatTests.createMapperService(
        long starTreeDocCount = getDocCountFromStarTree(starTreeDocValuesReader, mustFilter, context, searchContext);
                b.field("name", dimension);
    public void testStarTreeFilterWithNoDocsInSVDField() throws IOException {
            b.startObject("startree");
        if (numBits > 0) {
        try {
        docCount = getDocCount(docs, Map.of());
        assertEquals(RangeMatchDimFilter.class, mergedDimensionFilter6.getClass());
                    long value = valuesIterator.nextValue();
            b.field("name", "sndv");
    // Counts the documents having field SNDV & applied filters
        assertEquals(docCount, starTreeDocCount);
            b.field("name", "field");
        StarTreeValues starTreeValues = StarTreeQueryHelper.getStarTreeValues(context, starTree);
import org.opensearch.index.codec.composite.CompositeIndexReader;
                starTreeDocValuesReader,
 */
            context,
        StarTreeFilter starTreeFilter,
            // Increment count if the document passes all conditions
        DirectoryReader ir = DirectoryReader.open(directory);
        );
        );
        }
        conf.setMergePolicy(newLogMergePolicy());
        starTreeDocCount = getDocCountFromStarTree(
            b.endObject();
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
        );
import java.util.ArrayList;
            searchContext
            starTreeDocValuesReader,
        assertEquals(docCount, starTreeDocCount);
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
        assertEquals(1, docCount);
import org.opensearch.search.internal.SearchContext;
        Mockito.when(mapperService.fieldType(DV))
            b.startArray("ordered_dimensions");
        // When Star Tree has the same dimension as @dimensionToMerge
        Directory directory = newDirectory();
            List.of(exactMatchDimFilter)
 * compatible open source license.
            Map.of(SNDV, List.of(new ExactMatchDimFilter(SNDV, List.of(0L))), DV, List.of(new ExactMatchDimFilter(DV, List.of(0L))))
                doc.add(new SortedNumericDocValuesField(SDV, 4 * i));
            .thenReturn(new NumberFieldMapper.NumberFieldType(SNDV, NumberFieldMapper.NumberType.INTEGER));
        directory.close();
            assertEquals(docCount, starTreeDocCount);
        starTreeFilter = new StarTreeFilter(Map.of(dimensionToMerge, List.of(rangeMatchDimFilter)));
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
            starTreeFilter,
                    docCount += value;
        // no document should match the filter
        initValuesSourceRegistry();
                    IndexableField field = doc.getField(entry.getKey());
        for (Document doc : documents) {
        );
        Mockito.when(mapperService.fieldType(SNDV))
                    return field != null && field.numericValue().longValue() == entry.getValue();
        Mockito.when(mapperService.fieldType(DV))
            );
            b.value("avg");
            context,
        DimensionFilter mergedDimensionFilter3 = mergedStarTreeFilter.getFiltersForDimension(dimensionToMerge).get(0);
/*
            count++;
        long docCount = 0;
 * this file be licensed under the Apache-2.0 license or a
                starTreeDocValuesReader,
            for (int bit = filteredValues.nextSetBit(0); bit != DocIdSetIterator.NO_MORE_DOCS; bit = (bit + 1 < numBits)
                b.startObject();
            context,
            dimensionToMerge,
            starTreeDocCount = getDocCountFromStarTree(
            Document doc = new Document();
import org.opensearch.index.mapper.MapperService;
 *
        assertEquals(docCount, starTreeDocCount);
            context,
            docCount = getDocCount(docs, Map.of(SDV, 4L));
            searchContext
        // Ordered dimensions
    ) throws IOException {
        assertEquals(docCount, starTreeDocCount);
        assertEquals(2, mergedStarTreeFilter.getDimensions().size());
            new StarTreeFilter(
import java.util.Arrays;
            b.endObject();
            b.startObject();
import org.apache.lucene.tests.index.RandomIndexWriter;
        }
        assertEquals(docCount, starTreeDocCount);
        assertEquals(0, docCount);
                context,
            for (String dimension : dimensionNameAndType.keySet()) {
                b.endArray();
            starTreeFilter,
            dimensionToMerge,
 * The OpenSearch Contributors require contributions made to
            b.value("value_count");
            ),
            searchContext
            starTreeDocValuesReader,
            starTreeDocValuesReader,
                searchContext
    }
import org.apache.lucene.index.LeafReaderContext;
                Map.of(SNDV, List.of(new ExactMatchDimFilter(SNDV, List.of(0L))), DV, List.of(new ExactMatchDimFilter(DV, List.of(0L))))
        long starTreeDocCount, docCount;
            b.endArray();
            b.field("max_leaf_docs", maxLeafDocs);
    }
        assertEquals(RangeMatchDimFilter.class, mergedDimensionFilter3.getClass());
import org.mockito.Mockito;
            starTreeDocValuesReader,
        DIMENSION_TYPE_MAP.put(SDV, "integer");
    private long getDocCountFromStarTree(
        });
                MetricStat.VALUE_COUNT.getTypeName()
        List<Document> docs = new ArrayList<>();
            ),
            context,
        SearchContext searchContext = Mockito.mock(SearchContext.class);
        assertEquals(docCount, starTreeDocCount);
            docCount = getDocCount(docs, Map.of(SDV, 4L));
            searchContext
            b.startObject("properties");
        return count;
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
                boolean canAdvance = valuesIterator.advanceExact(bit);
        );
                // Iterate over values for the current document ID
        DimensionFilter mergedDimensionFilter6 = mergedStarTreeFilter.getFiltersForDimension("status").get(0);
        mergedStarTreeFilter = StarTreeQueryHelper.mergeDimensionFilterIfNotExists(
        // single filter on 3rd field in ordered dimension - does not match docs
            // Check if SNDV field is present
                ? filteredValues.nextSetBit(bit + 1)
        assertEquals(ExactMatchDimFilter.class, mergedDimensionFilter1.getClass());
public class StarTreeFilterTests extends AggregatorTestCase {
            b.endArray();
        // single filter - matches docs
            List.of(exactMatchDimFilter)
import org.opensearch.core.xcontent.XContentBuilder;
        CompositeIndexFieldInfo starTree = compositeIndexFields.get(0);
        );
        starTreeFilter = new StarTreeFilter(Map.of("status", List.of(rangeMatchDimFilter)));
import org.opensearch.common.util.FeatureFlags;
        // Only the first filter should match some documents, second filter matches none
            for (String metricField : metricFieldNameAndType.keySet()) {
        // When Star Tree doesn't have the same dimension as @dimensionToMerge but has other dimensions
            throw new RuntimeException(e);
    public static final Map<String, String> METRIC_TYPE_MAP = Map.of(FIELD_NAME, "integer");
        assertEquals(docCount, starTreeDocCount);
    }
        docCount = getDocCount(docs, Map.of(SNDV, 0L, DV, -100L));
                getExpandedMapping(maxLeafDoc, skipStarNodeCreationForSDVDimension, DIMENSION_TYPE_MAP, METRIC_TYPE_MAP)
        LeafReaderContext context = ir.leaves().get(0);
            b.startObject();
                b.field("type", dimensionNameAndType.get(dimension));
            iw.addDocument(doc);
        assertEquals(docCount, starTreeDocCount);
        MapperService mapperService = Mockito.mock(MapperService.class);
            )
        long count = 0;
            ),
            b.value("sum");
        assertEquals(docCount, starTreeDocCount);
            if (!filters.isEmpty()) {
        int totalDocs = docs.size();
import java.io.IOException;
        starTreeDocCount = getDocCountFromStarTree(
    private static FeatureFlags.TestUtils.FlagWriteLock fflock = null;
import org.apache.lucene.store.Directory;
            IllegalStateException.class,
        SearchContext searchContext
            Map.of(SNDV, Arrays.asList(new ExactMatchDimFilter(SNDV, List.of(0L)), new ExactMatchDimFilter(SNDV, List.of(1L))))
            starTreeFilter,
        initValuesSourceRegistry();
        }
        Mockito.when(mapperService.fieldType(SDV))
import org.opensearch.index.compositeindex.datacube.MetricStat;
        starTreeDocCount = getDocCountFromStarTree(
            }
                b.startObject(metricField);
        long docCount = getDocCount(docs, Map.of(SNDV, 0L, DV, 0L));
            if (skipStarNodeCreationForSDVDimension) {
        // Test 'SHOULD' clause (same dimension)
        DIMENSION_TYPE_MAP.put(SNDV, "integer");
            // FIXME : Create default constants for the existing so other can call easily.
        }
        } catch (IOException e) {
        MapperService mapperService = Mockito.mock(MapperService.class);
        int numBits = filteredValues.length();
            () -> getDocCountFromStarTree(
        );
            new StarTreeFilter(Map.of(SNDV, List.of(new ExactMatchDimFilter(SNDV, List.of(-101L))))),
    public static XContentBuilder getExpandedMapping(
        ir.close();
import org.apache.lucene.index.SegmentReader;
        // When Star Tree doesn't have the same dimension as @dimensionToMerge
                : DocIdSetIterator.NO_MORE_DOCS) {
        mergedStarTreeFilter = StarTreeQueryHelper.mergeDimensionFilterIfNotExists(
    private static final String FIELD_NAME = "field";
    ) throws IOException {
            doc.add(new SortedNumericDocValuesField(SNDV, i));
            dimensionToMerge,
import org.opensearch.search.startree.filter.RangeMatchDimFilter;
            }
            searchContext
        Map<String, String> metricFieldNameAndType
        expectThrows(
        } else {
        assertEquals(docCount, starTreeDocCount);
                searchContext
            context,
            StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(
    private long getDocCount(List<Document> documents, Map<String, Long> filters) {
        starTreeDocCount = getDocCountFromStarTree(
        );
            docs.add(doc);
            List.of(exactMatchDimFilter)
            b.endObject();
        LeafReaderContext context = ir.leaves().get(0);
        starTreeDocCount = getDocCountFromStarTree(starTreeDocValuesReader, shouldFilter, context, searchContext);
        assertEquals(RangeMatchDimFilter.class, mergedDimensionFilter2.getClass());
        StarTreeFilter starTreeFilter = new StarTreeFilter(Collections.emptyMap());
        for (int i = 0; i < totalDocs; i++) {
                boolean matches = filters.entrySet().stream().allMatch(entry -> {
import org.opensearch.search.startree.filter.StarTreeFilter;
                assert canAdvance : "Cannot advance to document ID " + bit + " in values iterator.";
        directory.close();
    private static final String SDV = "sdv";
                b.endObject();
        starTreeDocCount = getDocCountFromStarTree(
        // assert that all documents are included if no filters are given
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);
        assertEquals(totalDocs, starTreeDocCount);
            }
            new StarTreeFilter(Map.of(SNDV, List.of(new ExactMatchDimFilter(SNDV, List.of(0L))))),
        );
        assertEquals(0, docCount);
    protected Codec getCodec(int maxLeafDoc, boolean skipStarNodeCreationForSDVDimension) {
            searchContext
    }
            assertEquals(1, docCount);
            new StarTreeFilter(Collections.emptyMap()),
            }
            .thenReturn(new NumberFieldMapper.NumberFieldType(SNDV, NumberFieldMapper.NumberType.INTEGER));
            b.startArray("stats");
import java.util.LinkedHashMap;
        final Logger testLogger = LogManager.getLogger(StarTreeFilterTests.class);
        DimensionFilter exactMatchDimFilter = new ExactMatchDimFilter(dimensionToMerge, Collections.emptyList());
        mergedStarTreeFilter = StarTreeQueryHelper.mergeDimensionFilterIfNotExists(
package org.opensearch.search.aggregations.startree;
            b.startArray("metrics");
    private Directory createStarTreeIndex(int maxLeafDoc, boolean skipStarNodeCreationForSDVDimension, List<Document> docs)
}
        SegmentReader reader = Lucene.segmentReader(context.reader());
import org.apache.lucene.document.SortedNumericDocValuesField;
        docCount = getDocCount(docs, Map.of(SNDV, -101L));
import java.util.Collections;
            )
        docCount = getDocCount(docs, Map.of(SNDV, 101L));
        ir.close();
    public void testStarTreeFilterWithDocsInSVDFieldButNoStarNode() throws IOException {
import org.opensearch.search.startree.StarTreeTraversalUtil;
                context,
        // non-dimension fields in filter - should throw IllegalArgumentException
import org.apache.lucene.search.DocIdSetIterator;
        conf.setCodec(getCodec(maxLeafDoc, skipStarNodeCreationForSDVDimension));
            b.endObject();
            b.field("type", "star_tree");
            // Documents are not indexed
        testStarTreeFilter(5, true);
            // FIXME : Change to take dimension order and other inputs as method params.
        // single filter - does not match docs
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
            starTreeDocCount = getDocCountFromStarTree(
        DimensionFilter mergedDimensionFilter5 = mergedStarTreeFilter.getFiltersForDimension(dimensionToMerge).get(0);
            if (sndvField == null) continue; // Skip if SNDV is not present
            b.value("sum");
            b.value("max");
    public void testStarTreeFilterMerging() {
        SegmentReader reader = Lucene.segmentReader(context.reader());
    }
                if (!matches) continue;
import static org.opensearch.index.codec.composite912.datacube.startree.AbstractStarTreeDVFormatTests.topMapping;
    private void testStarTreeFilter(int maxLeafDoc, boolean skipStarNodeCreationForSDVDimension) throws IOException {
            }
                new StarTreeFilter(Map.of(SDV, List.of(new ExactMatchDimFilter(SDV, List.of(4L))))),
import org.opensearch.common.lucene.Lucene;
            dimensionToMerge,
            b.value("max");
            new StarTreeFilter(
            List.of(exactMatchDimFilter)
                b.startObject(dimension);
            .thenReturn(new NumberFieldMapper.NumberFieldType(DV, NumberFieldMapper.NumberType.INTEGER));
    private static final String SNDV = "sndv";
        FixedBitSet filteredValues = StarTreeTraversalUtil.getStarTreeResult(starTreeValues, starTreeFilter, searchContext);
        iw.close();
    public static final LinkedHashMap<String, String> DIMENSION_TYPE_MAP = new LinkedHashMap<>();
        starTreeFilter = new StarTreeFilter(Map.of(dimensionToMerge, List.of(rangeMatchDimFilter), "status", List.of(rangeMatchDimFilter)));
        boolean skipStarNodeCreationForSDVDimension,
            starTreeDocValuesReader,
                starTreeDocValuesReader,
        DimensionFilter mergedDimensionFilter4 = mergedStarTreeFilter.getFiltersForDimension("status").get(0);
    }
            b.value("avg");
            starTreeFilter,
                SNDV,
            }
        docCount = getDocCount(docs, Map.of(SNDV, 0L));
        LeafReaderContext context,
        DimensionFilter mergedDimensionFilter2 = mergedStarTreeFilter.getFiltersForDimension(dimensionToMerge).get(0);
            starTreeDocValuesReader,
                    // Assert that the value is as expected using the provided consumer
        String dimensionToMerge = "dim";
        );
            IndexableField sndvField = doc.getField(SNDV);
        );
import org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils;
            b.value("min");
            b.endObject();
        testStarTreeFilter(10, false);
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;
            );
        LinkedHashMap<String, String> dimensionNameAndType,
            b.value("value_count");
        docCount = getDocCount(docs, Map.of(SNDV, 0L, DV, 0L));
        MapperService mapperService;
            b.startArray("stats");
        starTreeDocCount = getDocCountFromStarTree(
        StarTreeFilter mergedStarTreeFilter;
    }
    static {
                b.endObject();
    // Returns count of documents in the star tree having field SNDV & applied filters
        // multiple filters - matches docs
        CompositeIndexReader starTreeDocValuesReader,
import org.opensearch.index.mapper.NumberFieldMapper;
        );
        assertEquals(2, mergedStarTreeFilter.getDimensions().size());
                // Assert that we can advance to the document ID in the values iterator
        docCount = getDocCount(docs, Map.of(SNDV, 0L, DV, -11L));
        DIMENSION_TYPE_MAP.put(DV, "integer");
                b.field("type", metricFieldNameAndType.get(metricField));
import org.apache.lucene.document.Document;
        assertEquals(0, docCount);
            for (String dimension : dimensionNameAndType.keySet()) {
        SortedNumericStarTreeValuesIterator valuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues.getMetricValuesIterator(
        int totalDocs = 100;
            doc.add(new SortedNumericDocValuesField(DV, 2 * i));
        assertEquals(1, docCount);
        assertEquals(1, mergedStarTreeFilter.getDimensions().size());
        starTreeDocCount = getDocCountFromStarTree(
        docCount = getDocCount(docs, Map.of(DV, 0L));
        throws IOException {
                searchContext
            assertEquals(docCount, starTreeDocCount);
import org.opensearch.search.aggregations.AggregatorTestCase;
        );
            b.startObject("composite");
        StarTreeFilter shouldFilter = new StarTreeFilter(
                }
            new StarTreeFilter(
        assertEquals(ExactMatchDimFilter.class, mergedDimensionFilter5.getClass());
            starTreeDocValuesReader,
            b.endArray();
        Mockito.when(searchContext.mapperService()).thenReturn(mapperService);
            context,
        }
            new StarTreeFilter(Map.of(DV, List.of(new ExactMatchDimFilter(DV, List.of(0L))))),
                });
        return docCount;
            context,
        DimensionFilter mergedDimensionFilter1 = mergedStarTreeFilter.getFiltersForDimension(dimensionToMerge).get(0);
        StarTreeFilter mustFilter = new StarTreeFilter(
    }
import org.apache.lucene.codecs.Codec;
import org.apache.logging.log4j.LogManager;
            .thenReturn(new NumberFieldMapper.NumberFieldType(DV, NumberFieldMapper.NumberType.INTEGER));
            starTreeDocValuesReader,
import org.apache.lucene.util.FixedBitSet;
                new StarTreeFilter(Map.of(FIELD_NAME, List.of(new ExactMatchDimFilter(FIELD_NAME, List.of(0L))))),
        return topMapping(b -> {
        starTreeDocCount = getDocCountFromStarTree(
            b.endObject();
import org.apache.lucene.index.IndexWriterConfig;
                context,
        iw.forceMerge(1);
                starTree.getField(),
        assertEquals(1, mergedStarTreeFilter.getDimensions().size());
        Directory directory = createStarTreeIndex(maxLeafDoc, skipStarNodeCreationForSDVDimension, docs);
        int maxLeafDocs,
            }
            // Apply filters if provided
    public void testStarTreeFilterWithBoolQueries() throws IOException {
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
            if (skipStarNodeCreationForSDVDimension) {
        SearchContext searchContext = Mockito.mock(SearchContext.class);
            );
            assertEquals(0, docCount);
            b.value("min");
import org.opensearch.search.startree.filter.DimensionFilter;
    private static final String DV = "dv";
        // When Star Tree has the same dimension as @dimensionToMerge with other dimensions
    }
        if (skipStarNodeCreationForSDVDimension == true) {
        assertEquals(RangeMatchDimFilter.class, mergedDimensionFilter4.getClass());
import org.opensearch.search.startree.StarTreeQueryHelper;
        Directory directory = createStarTreeIndex(5, true, docs);
        List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
        // single filter on 3rd field in ordered dimension - matches docs
                new StarTreeFilter(Map.of(SDV, List.of(new ExactMatchDimFilter(SDV, List.of(4L))))),
        DimensionFilter rangeMatchDimFilter = new RangeMatchDimFilter(dimensionToMerge, null, null, true, true);
import java.util.List;
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, 3 * i));
        // Test 'MUST' clause
                // adding SDV field only star node creation is skipped for SDV dimension
        Mockito.when(mapperService.fieldType(SNDV))
        docCount = getDocCount(docs, Map.of(SNDV, 0L)) + getDocCount(docs, Map.of(SNDV, 1L));
import org.opensearch.search.startree.filter.ExactMatchDimFilter;
                b.endObject();
            // Documents are indexed
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
            searchContext
                b.startArray("skip_star_node_creation_for_dimensions");
            .thenReturn(new NumberFieldMapper.NumberFieldType(SDV, NumberFieldMapper.NumberType.INTEGER));
            searchContext
            b.startObject("config");
import org.apache.logging.log4j.Logger;
    }
            new StarTreeFilter(Map.of(SNDV, List.of(new ExactMatchDimFilter(SNDV, List.of(101L))))),
        );
        );
            b.endArray();
                Map.of(SNDV, List.of(new ExactMatchDimFilter(SNDV, List.of(0L))), DV, List.of(new ExactMatchDimFilter(DV, List.of(-100L))))
        assertEquals(1, docCount);
import org.apache.lucene.index.DirectoryReader;
        List<Document> docs = new ArrayList<>();
        mergedStarTreeFilter = StarTreeQueryHelper.mergeDimensionFilterIfNotExists(
    }
        DirectoryReader ir = DirectoryReader.open(directory);
                for (int i = 0, count = valuesIterator.entryValueCount(); i < count; i++) {
                Map.of(SNDV, List.of(new ExactMatchDimFilter(SNDV, List.of(0L))), DV, List.of(new ExactMatchDimFilter(DV, List.of(-11L))))
        assertEquals(0, docCount);
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
        );
 * SPDX-License-Identifier: Apache-2.0
        IndexWriterConfig conf = newIndexWriterConfig(null);
