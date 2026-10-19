                        } else {  
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
                aggregationBuilder,  
            );  
            iw.forceMerge(1);
        if (aggregationBuilder instanceof TermsAggregationBuilder) {
                    // Numeric-terms query with numeric terms aggregation  
                val = random.nextInt(10); // Random strings for int between 0 and 9 for keyword terms
                SIZE_FIELD_TYPE,
                starTree,
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;  
                            } else {  
                InternalDateHistogram.class,
            for (Supplier<ValuesSourceAggregationBuilder<?>> outermostSupplier : aggregationSuppliers) {  
            query = new MatchAllDocsQuery();
        MappedFieldType... fieldTypes
                STATUS_FIELD_TYPE,
            }
                        outer,  
import org.opensearch.index.compositeindex.datacube.NumericDimension;
            }
            }  
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);
        int totalDocs = 100;  
            min("_min").field(STATUS),  
                query,
import org.opensearch.common.lucene.Lucene;
                for (Supplier<ValuesSourceAggregationBuilder<?>> middleSupplier : aggregationSuppliers) {
import org.opensearch.index.mapper.MapperService;
                InternalRange.class,
                query,
import org.opensearch.search.aggregations.bucket.terms.InternalTerms;
            () -> terms("term_keyword").field(KEYWORD_FIELD).collectMode(Aggregator.SubAggCollectionMode.DEPTH_FIRST),
                indexSearcher,
 */  
                    new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR),  
        T starTreeAgg = clazz.cast(
                KEYWORD_FIELD_TYPE
        ValuesSourceAggregationBuilder[] aggBuilders = {  
import java.util.LinkedHashMap;
                DEFAULT_MAX_BUCKETS,
import org.apache.lucene.index.LeafReaderContext;
                    }  
        } else if (aggregationBuilder instanceof RangeAggregationBuilder) {
import org.opensearch.index.compositeindex.datacube.Dimension;
                STATUS_FIELD_TYPE,  
                    new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)
            }
        try {
                            queryField = STATUS;
    final static String STATUS = "status";  
            assertEqualStarTreeAggregation(
            if (randomBoolean()) {  
                aggregationBuilder,
import org.apache.lucene.search.IndexSearcher;  
                SIZE_FIELD_TYPE,
import java.util.function.Function;
            if (randomBoolean()) {
 * SPDX-License-Identifier: Apache-2.0
        LeafReaderContext context = ir.leaves().get(0);
        }
            () -> range("range_agg").field(STATUS).addRange(10, 30).addRange(30, 50),  
            Document doc = new Document();
            }
                        testCase(
            new DateFieldMapper.DateFieldType(TIMESTAMP_FIELD)
        IndexWriterConfig conf = newIndexWriterConfig(null);  
            for (Supplier<ValuesSourceAggregationBuilder<?>> outerSupplier : aggregationSuppliers) {  
                queryBuilder,  
                createIndexSettings(),
                List.of(
    MappedFieldType KEYWORD_FIELD_TYPE = new KeywordFieldMapper.KeywordFieldType(KEYWORD_FIELD);
                        queryBuilder,
import org.apache.lucene.codecs.lucene104.Lucene104Codec;  
        CompositeIndexFieldInfo starTree,
    public void testStarTreeNestedAggregations() throws IOException {
                supportedDimensions,  
            throw new RuntimeException(e);
                    for (Supplier<ValuesSourceAggregationBuilder<?>> innerSupplier : aggregationSuppliers) {
                KEYWORD_FIELD_TYPE
            count("_count").field(STATUS) };
                        }
                null,  
        List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
                }
        boolean skipReducedMultiBucketConsumerAssertion
            searchAndReduceStarTree(  
import org.opensearch.index.query.QueryBuilder;
    }
                query,  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
import org.opensearch.search.aggregations.InternalAggregation;
                            skipReducedMultiBucketConsumerAssertion  
                                outermost,
            )  
        Directory directory = newDirectory();
                skipReducedMultiBucketConsumerAssertion,
        List<Supplier<ValuesSourceAggregationBuilder<?>>> aggregationSuppliers = List.of(  
    private void testCase(  
                        }  
                supportedDimensions,
import org.apache.logging.log4j.LogManager;  
                fieldTypes
                STATUS_FIELD_TYPE,
                        // Numeric-terms query with numeric terms aggregation  
                        && outer instanceof DateHistogramAggregationBuilder);
                        indexSearcher,  
            queryBuilder = null;
        QueryBuilder queryBuilder,  
        Query query = new MatchAllDocsQuery();  
                                queryField = STATUS;
 * this file be licensed under the Apache-2.0 license or a
        Query query,
                                queryField = SIZE;
                    testCase(
                        ValuesSourceAggregationBuilder<?> middle = middleSupplier.get().subAggregation(innermost);
import org.apache.lucene.index.DirectoryReader;
                            starTree,
import org.apache.lucene.codecs.Codec;
        long date;  
                starTree,
import org.opensearch.search.aggregations.bucket.range.InternalRange;  
                        if (randomBoolean()) {
                TIMESTAMP_FIELD_TYPE,
                    );
import static org.opensearch.search.aggregations.AggregationBuilders.max;
                        testCase(  
        boolean skipReducedMultiBucketConsumerAssertion,  
import static org.opensearch.search.aggregations.AggregationBuilders.range;  
                doc.add(new SortedNumericDocValuesField(STATUS, val));
        NumberFieldMapper.NumberType.LONG
            () -> dateHistogram("by_day").field(TIMESTAMP_FIELD).calendarInterval(DateHistogramInterval.DAY)  
                indexSearcher,  
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;  
                                indexSearcher,
                    // searchAndReduceStarTree
                SIZE_FIELD_TYPE,
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
import static org.opensearch.search.aggregations.AggregationBuilders.min;
            max("_max").field(STATUS),
        T defaultAgg = clazz.cast(
        }  
import org.apache.lucene.util.BytesRef;
                doc.add(new SortedNumericDocValuesField(TIMESTAMP_FIELD, date));
                            indexSearcher,
                            );
                }  
    private <T extends InternalAggregation> void assertEqualStarTreeAggregation(  
                            supportedDimensions,
                indexSearcher,
            sum("_sum").field(STATUS),
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
import org.opensearch.index.mapper.MappedFieldType;
        assertEquals(defaultBuckets.size(), starTreeBuckets.size());  
        Function<T, List<?>> getBuckets,
                queryBuilder,
                                queryBuilder,  
                        starTree,
    protected Codec getCodec() {
        }
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions,
                aggregationBuilder,
import java.io.IOException;  
        );
        IndexSearcher indexSearcher = newSearcher(wrapInMockESDirectoryReader(ir), false, false);
 * compatible open source license.
                            queryField = SIZE;
                skipReducedMultiBucketConsumerAssertion,  
                            query,
        SegmentReader reader = Lucene.segmentReader(context.reader());
        // 3-LEVELS [BUCKET -> BUCKET -> METRIC]
            mapperService = StarTreeDocValuesFormatTests.createMapperService(NumericTermsAggregatorTests.getExpandedMapping(1, false));  
                InternalDateHistogram::getBuckets,  
                    boolean skipReducedMultiBucketConsumerAssertion = (inner instanceof RangeAggregationBuilder  
                            queryValue = random.nextInt(10);  
                query,  
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogram;
                            queryBuilder,
            }  
                null,
                DEFAULT_MAX_BUCKETS,  
        } else if (aggregationBuilder instanceof DateHistogramAggregationBuilder) {  
import java.util.function.Supplier;  
        supportedDimensions.put(new NumericDimension(SIZE), SIZE_FIELD_TYPE);
        }  
    private static final String KEYWORD_FIELD = "clientip";  
import org.apache.lucene.store.Directory;  
        for (ValuesSourceAggregationBuilder aggregationBuilder : aggBuilders) {  
import org.opensearch.index.mapper.DateFieldMapper;
 *
import org.opensearch.index.mapper.NumberFieldMapper;  
    final static String SIZE = "size";
                            indexSearcher,  
        directory.close();
        final Logger testLogger = LogManager.getLogger(MetricAggregatorTests.class);  
                val = random.nextInt(100); // Random int between 0 and 99 for status  
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
                false,
                supportedDimensions,
                    // assertion in
public class StarTreeNestedAggregatorTests extends DateHistogramAggregatorTestCase {
                null,
import org.apache.lucene.document.LongPoint;
        }  
        IndexSearcher indexSearcher,
                        );
import org.apache.lucene.index.SegmentReader;
                aggregationBuilder,
        QueryBuilder queryBuilder = null;
                    ValuesSourceAggregationBuilder<?> outer = outerSupplier.get().subAggregation(inner);
                InternalTerms.class,  
    }
                                starTree,
        } catch (IOException e) {
}
            )
    ) throws IOException {
import java.util.List;  
import static org.opensearch.search.aggregations.AggregationBuilders.count;
import org.opensearch.index.mapper.KeywordFieldMapper;  
import org.opensearch.common.Rounding;  
import org.apache.lucene.document.SortedNumericDocValuesField;  
                queryBuilder,
import org.apache.lucene.document.SortedSetDocValuesField;
                indexSearcher,
        supportedDimensions.put(
                            skipReducedMultiBucketConsumerAssertion
        assertEquals(defaultBuckets, starTreeBuckets);
                skipReducedMultiBucketConsumerAssertion,
                            query = SortedNumericDocValuesField.newSlowExactQuery(queryField, queryValue);
        List<Document> docs = new ArrayList<>();
import org.opensearch.search.aggregations.Aggregator;  
                        queryValue = random.nextInt(10);  
        MapperService mapperService;
                    ValuesSourceAggregationBuilder<?> inner = innerSupplier.get().subAggregation(aggregationBuilder);  
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregatorTestCase;  
                        ValuesSourceAggregationBuilder<?> outermost = outermostSupplier.get().subAggregation(middle);  
        iw.close();  
                ),
                null,
                for (Supplier<ValuesSourceAggregationBuilder<?>> innerSupplier : aggregationSuppliers) {
import org.opensearch.index.codec.composite.CompositeIndexReader;  
                null,
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
            ),
        conf.setCodec(getCodec());
import org.opensearch.index.compositeindex.datacube.DateDimension;  
        supportedDimensions.put(new NumericDimension(STATUS), STATUS_FIELD_TYPE);  
                queryBuilder,
        DirectoryReader ir = DirectoryReader.open(directory);
        supportedDimensions.put(new OrdinalDimension(KEYWORD_FIELD), KEYWORD_FIELD_TYPE);
                        query = SortedNumericDocValuesField.newSlowExactQuery(queryField, queryValue);
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
                            queryBuilder = new TermQueryBuilder(queryField, queryValue);
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();  
        if (randomBoolean()) {  
/*  
                            outer,
                query,
                TIMESTAMP_FIELD_TYPE,  
                            && outermost instanceof DateHistogramAggregationBuilder)  
                            }
                        String queryField;
        );  
                        supportedDimensions,
                val = random.nextInt(100);
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        );
    );
        CompositeIndexFieldInfo starTree,
                InternalTerms::getBuckets,
                        // Skipping [DateHistogramAggregationBuilder + RangeAggregationBuilder] combinations for a
            docs.add(doc);  
 * The OpenSearch Contributors require contributions made to  
    private static final MappedFieldType STATUS_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(
                        ValuesSourceAggregationBuilder<?> innermost = innerSupplier.get().subAggregation(aggregationBuilder);
                    // Skipping [DateHistogramAggregationBuilder + RangeAggregationBuilder] combinations for a ReducedMultiBucketConsumer  
                indexSearcher,
                        queryBuilder = new TermQueryBuilder(queryField, queryValue);
    }
                                supportedDimensions,  
                true,  
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions,  
                                skipReducedMultiBucketConsumerAssertion
    private static final MappedFieldType SIZE_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(SIZE, NumberFieldMapper.NumberType.LONG);  
                            query,
import org.opensearch.index.query.TermQueryBuilder;
import org.apache.logging.log4j.Logger;
                TIMESTAMP_FIELD,
package org.opensearch.search.aggregations.startree;
        conf.setMergePolicy(newLogMergePolicy());
            queryBuilder = null;
        for (int i = 0; i < totalDocs; i++) {  
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
        STATUS,  
        QueryBuilder queryBuilder,  
import com.carrotsearch.randomizedtesting.RandomizedTest;
                            outermost,  
        // 4-LEVELS [BUCKET -> BUCKET -> BUCKET -> METRIC]
        IndexSearcher indexSearcher,
        List<?> defaultBuckets = getBuckets.apply(defaultAgg);  
            new DateDimension(  
    }
            () -> terms("term_size").field(SIZE),
                            long queryValue;  
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);  
                starTree,  
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
        for (ValuesSourceAggregationBuilder aggregationBuilder : aggBuilders) {  
        ir.close();
                        skipReducedMultiBucketConsumerAssertion  
        Query query,
        // Index 100 random documents
                        query,
                date = random.nextInt(180) * 24 * 60 * 60 * 1000L; // Random date within 180 days  
import org.apache.lucene.tests.index.RandomIndexWriter;
                supportedDimensions,
            assertEqualStarTreeAggregation(
                skipReducedMultiBucketConsumerAssertion,
        }
                            || (middle instanceof DateHistogramAggregationBuilder && innermost instanceof RangeAggregationBuilder);
                        long queryValue;  
                            queryBuilder,  
            () -> terms("term_keyword").field(KEYWORD_FIELD).collectMode(Aggregator.SubAggCollectionMode.BREADTH_FIRST),
            if (randomBoolean()) {
                        // searchAndReduceStarTree
                fieldTypes
        long val;
        );  
                                query,
            );
                starTree,  
                queryBuilder,  
                        );
                            supportedDimensions,  
import org.apache.lucene.index.IndexWriterConfig;  
import org.apache.lucene.document.Document;
            query = new MatchAllDocsQuery();
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
                DateFieldMapper.Resolution.MILLISECONDS  
                    for (int cases = 0; cases < 5; cases++) {
                createIndexSettings(),  
import org.apache.lucene.search.MatchAllDocsQuery;
            iw.addDocument(doc);
        CompositeIndexFieldInfo starTree = compositeIndexFields.get(0);  
            searchAndReduceStarTree(
                aggregationBuilder,
import java.util.ArrayList;
    private static final String TIMESTAMP_FIELD = "@timestamp";  
        Random random = RandomizedTest.getRandom();
import org.apache.lucene.search.Query;
            );
                        for (int cases = 0; cases < 5; cases++) {
    private static final MappedFieldType TIMESTAMP_FIELD_TYPE = new DateFieldMapper.DateFieldType(TIMESTAMP_FIELD);
        List<?> starTreeBuckets = getBuckets.apply(starTreeAgg);
                        boolean skipReducedMultiBucketConsumerAssertion = (middle instanceof RangeAggregationBuilder
                doc.add(new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef(String.valueOf(val))));  
            if (randomBoolean()) {
        ValuesSourceAggregationBuilder<?> aggregationBuilder,
            assertEqualStarTreeAggregation(  
                KEYWORD_FIELD_TYPE  
                false,
                            String queryField;
                doc.add(new SortedNumericDocValuesField(SIZE, val));
                        // ReducedMultiBucketConsumer assertion in  
                doc.add(new LongPoint(TIMESTAMP_FIELD, date));
                null,
            () -> terms("term_status").field(STATUS),
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;  
                skipReducedMultiBucketConsumerAssertion,  
                            if (randomBoolean()) {
                TIMESTAMP_FIELD_TYPE,  
        Class<T> clazz,
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions = new LinkedHashMap<>();
        ValuesSourceAggregationBuilder<?> aggregationBuilder,  
                InternalRange::getBuckets,
                            testCase(  
    ) throws IOException {
import java.util.Random;
                            starTree,
                    }
                false,  
