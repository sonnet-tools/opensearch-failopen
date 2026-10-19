import org.opensearch.index.mapper.MapperService;  
        return count;
            if (sndvField == null) continue; // Skip if SNDV is not present
            assertEquals(docCount, starTreeDocCount);
        StarTreeValues starTreeValues = StarTreeQueryHelper.getStarTreeValues(context, starTree);
                    return field != null && field.numericValue().longValue() == entry.getValue();
        assertEquals(0, docCount);
            List.of(exactMatchDimFilter)
        );  
            .thenReturn(new NumberFieldMapper.NumberFieldType(DV, NumberFieldMapper.NumberType.INTEGER));
            context,
    private static final String FIELD_NAME = "field";
            starTreeDocValuesReader,
            new StarTreeFilter(  
        );
import org.opensearch.search.startree.StarTreeQueryHelper;
import org.apache.logging.log4j.Logger;
import org.apache.lucene.document.SortedNumericDocValuesField;  
    }  
        );
            )  
            starTreeDocCount = getDocCountFromStarTree(  
        );
            context,
            b.endObject();
        assertEquals(docCount, starTreeDocCount);
            starTreeDocValuesReader,
/*  
            doc.add(new SortedNumericDocValuesField(DV, 2 * i));  
            mapperService = StarTreeDocValuesFormatTests.createMapperService(  
            b.value("max");
        assertEquals(ExactMatchDimFilter.class, mergedDimensionFilter5.getClass());  
import org.opensearch.common.lucene.Lucene;
                assert canAdvance : "Cannot advance to document ID " + bit + " in values iterator.";  
                getExpandedMapping(maxLeafDoc, skipStarNodeCreationForSDVDimension, DIMENSION_TYPE_MAP, METRIC_TYPE_MAP)
        );  
import java.util.LinkedHashMap;  
            new StarTreeFilter(
        Mockito.when(mapperService.fieldType(SDV))
            b.value("avg");
        MapperService mapperService = Mockito.mock(MapperService.class);
        directory.close();
            docCount = getDocCount(docs, Map.of(SDV, 4L));  
    }
import java.util.Map;
            IndexableField sndvField = doc.getField(SNDV);
            new StarTreeFilter(Map.of(SNDV, List.of(new ExactMatchDimFilter(SNDV, List.of(101L))))),
            b.startArray("stats");
            b.endArray();
                    // Assert that the value is as expected using the provided consumer
        docCount = getDocCount(docs, Map.of(SNDV, -101L));
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
        DimensionFilter exactMatchDimFilter = new ExactMatchDimFilter(dimensionToMerge, Collections.emptyList());
            docCount = getDocCount(docs, Map.of(SDV, 4L));
            }
 * The OpenSearch Contributors require contributions made to  
            context,  
        );
            searchContext
        LeafReaderContext context,
                doc.add(new SortedNumericDocValuesField(SDV, 4 * i));
            }
        assertEquals(1, docCount);
                b.endArray();
        );
                boolean canAdvance = valuesIterator.advanceExact(bit);
import java.util.Collections;
        mergedStarTreeFilter = StarTreeQueryHelper.mergeDimensionFilterIfNotExists(  
        assertEquals(0, docCount);
        long starTreeDocCount, docCount;  
        StarTreeFilter mergedStarTreeFilter;
            context,
        docCount = getDocCount(docs, Map.of(SNDV, 0L));
        expectThrows(  
                b.startArray("skip_star_node_creation_for_dimensions");
import org.apache.lucene.util.FixedBitSet;  
        int numBits = filteredValues.length();
            starTreeDocValuesReader,  
    private void testStarTreeFilter(int maxLeafDoc, boolean skipStarNodeCreationForSDVDimension) throws IOException {
            assertEquals(1, docCount);
        starTreeDocCount = getDocCountFromStarTree(starTreeDocValuesReader, shouldFilter, context, searchContext);  
        Map<String, String> metricFieldNameAndType
        starTreeDocCount = getDocCountFromStarTree(
            starTreeFilter,
        SearchContext searchContext  
        Mockito.when(searchContext.mapperService()).thenReturn(mapperService);
                    long value = valuesIterator.nextValue();
        DIMENSION_TYPE_MAP.put(SDV, "integer");
            assertEquals(docCount, starTreeDocCount);
            starTreeDocValuesReader,
            searchContext  
        DimensionFilter mergedDimensionFilter6 = mergedStarTreeFilter.getFiltersForDimension("status").get(0);
        assertEquals(docCount, starTreeDocCount);  
        DIMENSION_TYPE_MAP.put(SNDV, "integer");  
        initValuesSourceRegistry();
        throws IOException {
        assertEquals(docCount, starTreeDocCount);  
        // no document should match the filter  
        // When Star Tree doesn't have the same dimension as @dimensionToMerge but has other dimensions  
    }
            .thenReturn(new NumberFieldMapper.NumberFieldType(SNDV, NumberFieldMapper.NumberType.INTEGER));
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
    public void testStarTreeFilterWithDocsInSVDFieldButNoStarNode() throws IOException {
import java.util.Arrays;
            starTreeDocValuesReader,
            }
        assertEquals(1, mergedStarTreeFilter.getDimensions().size());
            b.startArray("stats");  
import org.opensearch.search.startree.filter.StarTreeFilter;  
            b.startObject("properties");
import org.apache.lucene.tests.index.RandomIndexWriter;
            searchContext  
            b.field("max_leaf_docs", maxLeafDocs);  
        // single filter on 3rd field in ordered dimension - does not match docs  
        IndexWriterConfig conf = newIndexWriterConfig(null);  
        assertEquals(totalDocs, starTreeDocCount);  
            Map.of(SNDV, Arrays.asList(new ExactMatchDimFilter(SNDV, List.of(0L)), new ExactMatchDimFilter(SNDV, List.of(1L))))
                b.endObject();  
                b.startObject();
import static org.opensearch.index.codec.composite912.datacube.startree.AbstractStarTreeDVFormatTests.topMapping;  
        // single filter on 3rd field in ordered dimension - matches docs
    private static final String SNDV = "sndv";  
            iw.addDocument(doc);  
        if (numBits > 0) {
            b.value("min");
                SNDV,
            // FIXME : Create default constants for the existing so other can call easily.
        List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
        long starTreeDocCount = getDocCountFromStarTree(starTreeDocValuesReader, mustFilter, context, searchContext);
        assertEquals(docCount, starTreeDocCount);
        // non-dimension fields in filter - should throw IllegalArgumentException
        // multiple filters - matches docs
                searchContext  
        DimensionFilter rangeMatchDimFilter = new RangeMatchDimFilter(dimensionToMerge, null, null, true, true);
        Directory directory = createStarTreeIndex(5, true, docs);  
    }  
 */  
        starTreeDocCount = getDocCountFromStarTree(
            b.endArray();  
                b.startObject(metricField);
            starTreeFilter,  
        DimensionFilter mergedDimensionFilter5 = mergedStarTreeFilter.getFiltersForDimension(dimensionToMerge).get(0);
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
        Directory directory = newDirectory();
            IllegalStateException.class,
        SearchContext searchContext = Mockito.mock(SearchContext.class);
        // Test 'MUST' clause  
                new StarTreeFilter(Map.of(SDV, List.of(new ExactMatchDimFilter(SDV, List.of(4L))))),
        assertEquals(1, docCount);
        starTreeDocCount = getDocCountFromStarTree(
import org.opensearch.index.compositeindex.datacube.startree.utils.iterator.SortedNumericStarTreeValuesIterator;
            context,
                b.startObject(dimension);  
    }
        docCount = getDocCount(docs, Map.of(SNDV, 101L));
            // Check if SNDV field is present  
import org.apache.lucene.codecs.Codec;  
        iw.close();
        mergedStarTreeFilter = StarTreeQueryHelper.mergeDimensionFilterIfNotExists(
        Mockito.when(mapperService.fieldType(DV))  
                for (int i = 0, count = valuesIterator.entryValueCount(); i < count; i++) {  
        conf.setCodec(getCodec(maxLeafDoc, skipStarNodeCreationForSDVDimension));
            for (String dimension : dimensionNameAndType.keySet()) {  
import org.opensearch.common.util.FeatureFlags;
        CompositeIndexReader starTreeDocValuesReader,  
                new StarTreeFilter(Map.of(SDV, List.of(new ExactMatchDimFilter(SDV, List.of(4L))))),
    public void testStarTreeFilterMerging() {
        assertEquals(docCount, starTreeDocCount);
            b.endObject();
            b.value("avg");  
            starTreeDocCount = getDocCountFromStarTree(
        }  
            b.value("value_count");  
        SortedNumericStarTreeValuesIterator valuesIterator = (SortedNumericStarTreeValuesIterator) starTreeValues.getMetricValuesIterator(
        long count = 0;
import org.opensearch.index.codec.composite.CompositeIndexReader;
            b.endArray();  
            context,  
            new StarTreeFilter(Map.of(DV, List.of(new ExactMatchDimFilter(DV, List.of(0L))))),
    private long getDocCountFromStarTree(
            ),  
        // Ordered dimensions
    private static FeatureFlags.TestUtils.FlagWriteLock fflock = null;  
        // single filter - does not match docs
            b.endObject();  
        assertEquals(docCount, starTreeDocCount);  
        DimensionFilter mergedDimensionFilter3 = mergedStarTreeFilter.getFiltersForDimension(dimensionToMerge).get(0);
        StarTreeFilter starTreeFilter,
            dimensionToMerge,
        assertEquals(docCount, starTreeDocCount);
        Mockito.when(mapperService.fieldType(SNDV))
    public void testStarTreeFilterWithBoolQueries() throws IOException {
            b.startObject("startree");  
            searchContext
        assertEquals(1, docCount);  
        } else {  
        conf.setMergePolicy(newLogMergePolicy());
        int totalDocs = docs.size();
                Map.of(SNDV, List.of(new ExactMatchDimFilter(SNDV, List.of(0L))), DV, List.of(new ExactMatchDimFilter(DV, List.of(0L))))  
            )
        directory.close();
import org.opensearch.search.startree.filter.ExactMatchDimFilter;
    public static final LinkedHashMap<String, String> DIMENSION_TYPE_MAP = new LinkedHashMap<>();
        iw.forceMerge(1);  
        long docCount = 0;  
                Map.of(SNDV, List.of(new ExactMatchDimFilter(SNDV, List.of(0L))), DV, List.of(new ExactMatchDimFilter(DV, List.of(-11L))))
    public static final Map<String, String> METRIC_TYPE_MAP = Map.of(FIELD_NAME, "integer");
            List.of(exactMatchDimFilter)  
                searchContext  
            b.field("name", "field");
                Map.of(SNDV, List.of(new ExactMatchDimFilter(SNDV, List.of(0L))), DV, List.of(new ExactMatchDimFilter(DV, List.of(-100L))))
                b.value("sdv");  
    ) throws IOException {  
        );  
            }
    private static final String SDV = "sdv";
        boolean skipStarNodeCreationForSDVDimension,  
            b.startObject();
import org.opensearch.search.startree.filter.DimensionFilter;  
            Document doc = new Document();
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, 3 * i));
            .thenReturn(new NumberFieldMapper.NumberFieldType(SNDV, NumberFieldMapper.NumberType.INTEGER));
            new StarTreeFilter(Collections.emptyMap()),
        assertEquals(2, mergedStarTreeFilter.getDimensions().size());  
        docCount = getDocCount(docs, Map.of(SNDV, 0L, DV, -100L));
        // When Star Tree has the same dimension as @dimensionToMerge with other dimensions
        }
        SegmentReader reader = Lucene.segmentReader(context.reader());
            b.value("min");
        starTreeDocCount = getDocCountFromStarTree(
        DimensionFilter mergedDimensionFilter4 = mergedStarTreeFilter.getFiltersForDimension("status").get(0);  
        return docCount;
            for (int bit = filteredValues.nextSetBit(0); bit != DocIdSetIterator.NO_MORE_DOCS; bit = (bit + 1 < numBits)  
        Mockito.when(mapperService.fieldType(DV))
import org.opensearch.index.codec.composite.composite104.Composite104Codec;  
            b.endObject();
        ir.close();
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
    static {
        docCount = getDocCount(docs, Map.of());
                ? filteredValues.nextSetBit(bit + 1)
        starTreeFilter = new StarTreeFilter(Map.of("status", List.of(rangeMatchDimFilter)));
        }  
    public void testStarTreeFilterWithNoDocsInSVDField() throws IOException {  
        );
import org.apache.lucene.index.SegmentReader;
import org.opensearch.search.startree.filter.RangeMatchDimFilter;
        for (int i = 0; i < totalDocs; i++) {  
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);  
            b.startArray("ordered_dimensions");
}
            new StarTreeFilter(Map.of(SNDV, List.of(new ExactMatchDimFilter(SNDV, List.of(-101L))))),  
        starTreeDocCount = getDocCountFromStarTree(  
        docCount = getDocCount(docs, Map.of(SNDV, 0L, DV, 0L));
        );
        DimensionFilter mergedDimensionFilter1 = mergedStarTreeFilter.getFiltersForDimension(dimensionToMerge).get(0);  
            );
        MapperService mapperService;
        return topMapping(b -> {
            starTreeFilter,  
        mergedStarTreeFilter = StarTreeQueryHelper.mergeDimensionFilterIfNotExists(
        for (Document doc : documents) {
                if (!matches) continue;
        LeafReaderContext context = ir.leaves().get(0);  
                boolean matches = filters.entrySet().stream().allMatch(entry -> {  
 * compatible open source license.
        assertEquals(RangeMatchDimFilter.class, mergedDimensionFilter3.getClass());
                b.field("type", dimensionNameAndType.get(dimension));
        DIMENSION_TYPE_MAP.put(DV, "integer");
            dimensionToMerge,
    protected Codec getCodec(int maxLeafDoc, boolean skipStarNodeCreationForSDVDimension) {
        assertEquals(RangeMatchDimFilter.class, mergedDimensionFilter6.getClass());
            starTreeDocValuesReader,  
                // adding SDV field only star node creation is skipped for SDV dimension  
            b.endArray();
                starTreeDocValuesReader,
            b.value("max");  
        Mockito.when(mapperService.fieldType(SNDV))  
        CompositeIndexFieldInfo starTree = compositeIndexFields.get(0);  
import org.apache.lucene.index.DirectoryReader;
                starTreeDocValuesReader,  
        assertEquals(docCount, starTreeDocCount);
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
        assertEquals(1, mergedStarTreeFilter.getDimensions().size());
                b.endObject();
 * this file be licensed under the Apache-2.0 license or a
            List.of(exactMatchDimFilter)
        List<Document> docs = new ArrayList<>();
import org.opensearch.index.compositeindex.datacube.startree.utils.StarTreeUtils;
            docs.add(doc);
                context,
                new StarTreeFilter(Map.of(FIELD_NAME, List.of(new ExactMatchDimFilter(FIELD_NAME, List.of(0L))))),
            b.value("sum");
            throw new RuntimeException(e);
        DimensionFilter mergedDimensionFilter2 = mergedStarTreeFilter.getFiltersForDimension(dimensionToMerge).get(0);
        SearchContext searchContext = Mockito.mock(SearchContext.class);  
            );
                // Iterate over values for the current document ID
            ),
        starTreeFilter = new StarTreeFilter(Map.of(dimensionToMerge, List.of(rangeMatchDimFilter)));
import org.apache.lucene.index.IndexableField;  
            context,
        );
            b.value("sum");
            count++;
            searchContext  
            new StarTreeFilter(
        int totalDocs = 100;
import org.opensearch.search.aggregations.AggregatorTestCase;
import java.io.IOException;
        );  
        StarTreeFilter mustFilter = new StarTreeFilter(
        MapperService mapperService = Mockito.mock(MapperService.class);
            // Apply filters if provided
import java.util.List;
            b.value("value_count");
            b.field("type", "star_tree");
        int maxLeafDocs,
        assertEquals(0, docCount);
        DirectoryReader ir = DirectoryReader.open(directory);
 * SPDX-License-Identifier: Apache-2.0
            StarTreeUtils.fullyQualifiedFieldNameForStarTreeMetricsDocValues(
            if (!filters.isEmpty()) {
import org.apache.logging.log4j.LogManager;
            assertEquals(0, docCount);  
        assertEquals(ExactMatchDimFilter.class, mergedDimensionFilter1.getClass());
import org.opensearch.search.internal.SearchContext;  
                b.field("type", metricFieldNameAndType.get(metricField));  
        try {
        starTreeDocCount = getDocCountFromStarTree(
        String dimensionToMerge = "dim";
            // FIXME : Change to take dimension order and other inputs as method params.  
                // Assert that we can advance to the document ID in the values iterator
            // Documents are not indexed
            if (skipStarNodeCreationForSDVDimension) {
import org.opensearch.index.compositeindex.datacube.MetricStat;
import org.opensearch.index.compositeindex.datacube.startree.index.StarTreeValues;  
        // When Star Tree has the same dimension as @dimensionToMerge  
        mergedStarTreeFilter = StarTreeQueryHelper.mergeDimensionFilterIfNotExists(
        // assert that all documents are included if no filters are given
package org.opensearch.search.aggregations.startree;
            searchContext
        assertEquals(0, docCount);  
                : DocIdSetIterator.NO_MORE_DOCS) {
        );  
        // When Star Tree doesn't have the same dimension as @dimensionToMerge
        // single filter - matches docs  
    }
                MetricStat.VALUE_COUNT.getTypeName()
    }  
        return directory;
                }
        initValuesSourceRegistry();
    }  
        LinkedHashMap<String, String> dimensionNameAndType,
        }
                starTreeDocValuesReader,  
            }
            Map.of(SNDV, List.of(new ExactMatchDimFilter(SNDV, List.of(0L))), DV, List.of(new ExactMatchDimFilter(DV, List.of(0L))))
 *
            }  
                context,
    // Counts the documents having field SNDV & applied filters
        // Test 'SHOULD' clause (same dimension)
        if (skipStarNodeCreationForSDVDimension == true) {
                starTree.getField(),  
import org.apache.lucene.store.Directory;
                searchContext
            b.endObject();
    // Returns count of documents in the star tree having field SNDV & applied filters
            .thenReturn(new NumberFieldMapper.NumberFieldType(DV, NumberFieldMapper.NumberType.INTEGER));  
            searchContext
        starTreeDocCount = getDocCountFromStarTree(
                });  
import org.opensearch.search.startree.StarTreeTraversalUtil;
            () -> getDocCountFromStarTree(
        assertEquals(RangeMatchDimFilter.class, mergedDimensionFilter2.getClass());  
        testStarTreeFilter(5, true);
            new StarTreeFilter(Map.of(SNDV, List.of(new ExactMatchDimFilter(SNDV, List.of(0L))))),  
    }
        assertEquals(docCount, starTreeDocCount);  
        FixedBitSet filteredValues = StarTreeTraversalUtil.getStarTreeResult(starTreeValues, starTreeFilter, searchContext);
        });
            // Increment count if the document passes all conditions
            context,
            // Documents are indexed
            b.endObject();  
        starTreeDocCount = getDocCountFromStarTree(  
import org.apache.lucene.index.LeafReaderContext;
import java.util.ArrayList;  
                    docCount += value;  
    private static final String DV = "dv";
    private Directory createStarTreeIndex(int maxLeafDoc, boolean skipStarNodeCreationForSDVDimension, List<Document> docs)  
                b.field("name", dimension);
            );
    ) throws IOException {
        assertEquals(RangeMatchDimFilter.class, mergedDimensionFilter4.getClass());
                context,  
        Mockito.when(searchContext.mapperService()).thenReturn(mapperService);  
        DirectoryReader ir = DirectoryReader.open(directory);  
import org.mockito.Mockito;
        ir.close();
        docCount = getDocCount(docs, Map.of(DV, 0L));  
            b.field("name", "sndv");  
import org.apache.lucene.document.Document;
        }
        // Only the first filter should match some documents, second filter matches none
import org.apache.lucene.search.DocIdSetIterator;  
        SegmentReader reader = Lucene.segmentReader(context.reader());  
        starTreeFilter = new StarTreeFilter(Map.of(dimensionToMerge, List.of(rangeMatchDimFilter), "status", List.of(rangeMatchDimFilter)));  
            starTreeFilter,
        Directory directory = createStarTreeIndex(maxLeafDoc, skipStarNodeCreationForSDVDimension, docs);
    private long getDocCount(List<Document> documents, Map<String, Long> filters) {  
            if (skipStarNodeCreationForSDVDimension) {
        List<Document> docs = new ArrayList<>();  
        docCount = getDocCount(docs, Map.of(SNDV, 0L)) + getDocCount(docs, Map.of(SNDV, 1L));
import org.opensearch.core.xcontent.XContentBuilder;  
        long docCount = getDocCount(docs, Map.of(SNDV, 0L, DV, 0L));
            .thenReturn(new NumberFieldMapper.NumberFieldType(SDV, NumberFieldMapper.NumberType.INTEGER));
        docCount = getDocCount(docs, Map.of(SNDV, 0L, DV, -11L));  
        LeafReaderContext context = ir.leaves().get(0);
            ),
            b.startArray("metrics");  
        );
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);  
    }
        StarTreeFilter starTreeFilter = new StarTreeFilter(Collections.emptyMap());
            for (String dimension : dimensionNameAndType.keySet()) {
        } catch (IOException e) {  
    }  
            doc.add(new SortedNumericDocValuesField(SNDV, i));
        final Logger testLogger = LogManager.getLogger(StarTreeFilterTests.class);  
    public static XContentBuilder getExpandedMapping(
        );  
            b.startObject();
            starTreeDocValuesReader,
            searchContext
import org.opensearch.index.mapper.NumberFieldMapper;
                b.endObject();
import org.apache.lucene.index.IndexWriterConfig;
        testStarTreeFilter(10, false);
        StarTreeFilter shouldFilter = new StarTreeFilter(  
        assertEquals(2, mergedStarTreeFilter.getDimensions().size());
            dimensionToMerge,
        assertEquals(docCount, starTreeDocCount);
            List.of(exactMatchDimFilter)
            starTreeDocValuesReader,  
            }
public class StarTreeFilterTests extends AggregatorTestCase {
                    IndexableField field = doc.getField(entry.getKey());
            b.startObject("config");
            b.startObject("composite");
            for (String metricField : metricFieldNameAndType.keySet()) {
        );
            dimensionToMerge,  
