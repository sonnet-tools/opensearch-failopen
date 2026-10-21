                supportedDimensions,
                indexSearcher,
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogram;
        } else if (aggregationBuilder instanceof RangeAggregationBuilder) {
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
            iw.addDocument(doc);
                TIMESTAMP_FIELD_TYPE,
                        testCase(
import java.util.function.Function;
import org.apache.lucene.index.SegmentReader;
            queryBuilder = null;
 * compatible open source license.
        assertEquals(defaultBuckets.size(), starTreeBuckets.size());
package org.opensearch.search.aggregations.startree;
        } catch (IOException e) {
        }
                        boolean skipReducedMultiBucketConsumerAssertion = (middle instanceof RangeAggregationBuilder
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
        T starTreeAgg = clazz.cast(
        }
                            skipReducedMultiBucketConsumerAssertion
                    // searchAndReduceStarTree
                aggregationBuilder,
        for (int i = 0; i < totalDocs; i++) {
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
                        queryBuilder,
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
                skipReducedMultiBucketConsumerAssertion,
                            }
                aggregationBuilder,
            () -> terms("term_status").field(STATUS),
        supportedDimensions.put(
                            skipReducedMultiBucketConsumerAssertion
            assertEqualStarTreeAggregation(
            () -> terms("term_keyword").field(KEYWORD_FIELD).collectMode(Aggregator.SubAggCollectionMode.DEPTH_FIRST),
            mapperService = StarTreeDocValuesFormatTests.createMapperService(NumericTermsAggregatorTests.getExpandedMapping(1, false));
        CompositeIndexFieldInfo starTree,
                aggregationBuilder,
                            query = SortedNumericDocValuesField.newSlowExactQuery(queryField, queryValue);
                KEYWORD_FIELD_TYPE
import org.opensearch.search.aggregations.Aggregator;
                InternalTerms::getBuckets,
                }
    }
        Random random = RandomizedTest.getRandom();
        for (ValuesSourceAggregationBuilder aggregationBuilder : aggBuilders) {
            }
            Document doc = new Document();
        List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
        long date;
                TIMESTAMP_FIELD,
                val = random.nextInt(100);
                            queryValue = random.nextInt(10);
        CompositeIndexFieldInfo starTree = compositeIndexFields.get(0);
                query,
                    // Skipping [DateHistogramAggregationBuilder + RangeAggregationBuilder] combinations for a ReducedMultiBucketConsumer
        supportedDimensions.put(new NumericDimension(STATUS), STATUS_FIELD_TYPE);
        assertEquals(defaultBuckets, starTreeBuckets);
                        indexSearcher,
                indexSearcher,
        List<Supplier<ValuesSourceAggregationBuilder<?>>> aggregationSuppliers = List.of(
    private <T extends InternalAggregation> void assertEqualStarTreeAggregation(
    final static String STATUS = "status";
                TIMESTAMP_FIELD_TYPE,
import org.opensearch.common.lucene.Lucene;
            new DateFieldMapper.DateFieldType(TIMESTAMP_FIELD)
                doc.add(new SortedNumericDocValuesField(STATUS, val));
                        query = SortedNumericDocValuesField.newSlowExactQuery(queryField, queryValue);
                            indexSearcher,
        // Index 100 random documents
    ) throws IOException {
                for (Supplier<ValuesSourceAggregationBuilder<?>> middleSupplier : aggregationSuppliers) {
    }
                        );
                        supportedDimensions,
                indexSearcher,
                false,
        DirectoryReader ir = DirectoryReader.open(directory);
                        ValuesSourceAggregationBuilder<?> middle = middleSupplier.get().subAggregation(innermost);
                InternalRange.class,
        if (aggregationBuilder instanceof TermsAggregationBuilder) {
import org.apache.lucene.search.IndexSearcher;
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
    private static final String TIMESTAMP_FIELD = "@timestamp";
import org.opensearch.index.codec.composite.CompositeIndexReader;
                null,
                            queryBuilder = new TermQueryBuilder(queryField, queryValue);
        } else if (aggregationBuilder instanceof DateHistogramAggregationBuilder) {
import java.util.ArrayList;
import org.opensearch.index.query.TermQueryBuilder;
                    );
                supportedDimensions,
        IndexSearcher indexSearcher,
                aggregationBuilder,
        directory.close();
                        skipReducedMultiBucketConsumerAssertion
            }
import org.apache.logging.log4j.LogManager;
 *
                    }
                DEFAULT_MAX_BUCKETS,
import org.opensearch.index.compositeindex.datacube.Dimension;
                        testCase(
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions,
                fieldTypes
        final Logger testLogger = LogManager.getLogger(MetricAggregatorTests.class);
        QueryBuilder queryBuilder,
                queryBuilder,
                        long queryValue;
        Class<T> clazz,
                InternalDateHistogram::getBuckets,
                        }
            count("_count").field(STATUS) };
import java.util.LinkedHashMap;
        MappedFieldType... fieldTypes
import com.carrotsearch.randomizedtesting.RandomizedTest;
                createIndexSettings(),
                starTree,
        SegmentReader reader = Lucene.segmentReader(context.reader());
import org.opensearch.search.aggregations.bucket.terms.InternalTerms;
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregatorTestCase;
                            String queryField;
            }
        boolean skipReducedMultiBucketConsumerAssertion,
                STATUS_FIELD_TYPE,
                            || (middle instanceof DateHistogramAggregationBuilder && innermost instanceof RangeAggregationBuilder);
                    }
        supportedDimensions.put(new NumericDimension(SIZE), SIZE_FIELD_TYPE);
                query,
    private static final MappedFieldType STATUS_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(
                            queryBuilder,
                query,
                    boolean skipReducedMultiBucketConsumerAssertion = (inner instanceof RangeAggregationBuilder
                }
        long val;
        }
                            testCase(
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
import static org.opensearch.search.aggregations.AggregationBuilders.max;
        }
                        } else {
                            outer,
                query,
                KEYWORD_FIELD_TYPE
import org.opensearch.index.mapper.KeywordFieldMapper;
                        ValuesSourceAggregationBuilder<?> outermost = outermostSupplier.get().subAggregation(middle);
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
                                supportedDimensions,
            }
        STATUS,
            () -> range("range_agg").field(STATUS).addRange(10, 30).addRange(30, 50),
                        // Skipping [DateHistogramAggregationBuilder + RangeAggregationBuilder] combinations for a
                fieldTypes
        try {
                    ValuesSourceAggregationBuilder<?> inner = innerSupplier.get().subAggregation(aggregationBuilder);
                        && outer instanceof DateHistogramAggregationBuilder);
                                indexSearcher,
                        if (randomBoolean()) {
            for (Supplier<ValuesSourceAggregationBuilder<?>> outermostSupplier : aggregationSuppliers) {
            searchAndReduceStarTree(
    ) throws IOException {
            max("_max").field(STATUS),
    protected Codec getCodec() {
        List<Document> docs = new ArrayList<>();
            );
        ir.close();
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
import org.opensearch.search.aggregations.bucket.range.InternalRange;
import org.apache.lucene.document.SortedNumericDocValuesField;
        QueryBuilder queryBuilder = null;
import org.apache.lucene.index.DirectoryReader;
        boolean skipReducedMultiBucketConsumerAssertion
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;
        );
import org.opensearch.index.mapper.MapperService;
 */
                        // Numeric-terms query with numeric terms aggregation
                null,
            docs.add(doc);
import org.opensearch.search.aggregations.InternalAggregation;
                InternalRange::getBuckets,
                false,
                        queryBuilder = new TermQueryBuilder(queryField, queryValue);
    final static String SIZE = "size";
import org.apache.lucene.search.MatchAllDocsQuery;
                            if (randomBoolean()) {
            query = new MatchAllDocsQuery();
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
                            );
                                starTree,
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
            )
                queryBuilder,
            }
            () -> dateHistogram("by_day").field(TIMESTAMP_FIELD).calendarInterval(DateHistogramInterval.DAY)
            )
import org.apache.lucene.store.Directory;
                    new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR),
import org.apache.lucene.document.LongPoint;
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions,
        QueryBuilder queryBuilder,
                List.of(
                        ValuesSourceAggregationBuilder<?> innermost = innerSupplier.get().subAggregation(aggregationBuilder);
import static org.opensearch.search.aggregations.AggregationBuilders.count;
        CompositeIndexFieldInfo starTree,
                        query,
            ),
                date = random.nextInt(180) * 24 * 60 * 60 * 1000L; // Random date within 180 days
        ValuesSourceAggregationBuilder<?> aggregationBuilder,
                        // searchAndReduceStarTree
import org.apache.lucene.document.SortedSetDocValuesField;
            assertEqualStarTreeAggregation(
                        outer,
        supportedDimensions.put(new OrdinalDimension(KEYWORD_FIELD), KEYWORD_FIELD_TYPE);
                                skipReducedMultiBucketConsumerAssertion
                indexSearcher,
import org.apache.lucene.codecs.Codec;
                        );
        Query query = new MatchAllDocsQuery();
                supportedDimensions,
        Query query,
import static org.opensearch.search.aggregations.AggregationBuilders.min;
                            && outermost instanceof DateHistogramAggregationBuilder)
            throw new RuntimeException(e);
    MappedFieldType KEYWORD_FIELD_TYPE = new KeywordFieldMapper.KeywordFieldType(KEYWORD_FIELD);
            searchAndReduceStarTree(
                indexSearcher,
                DEFAULT_MAX_BUCKETS,
        T defaultAgg = clazz.cast(
            assertEqualStarTreeAggregation(
                            queryBuilder,
                starTree,
                STATUS_FIELD_TYPE,
import org.opensearch.common.Rounding;
 * The OpenSearch Contributors require contributions made to
import org.opensearch.index.mapper.DateFieldMapper;
                    testCase(
            for (Supplier<ValuesSourceAggregationBuilder<?>> outerSupplier : aggregationSuppliers) {
                DateFieldMapper.Resolution.MILLISECONDS
import org.opensearch.index.mapper.NumberFieldMapper;
                                queryField = SIZE;
                createIndexSettings(),
                            } else {
            new DateDimension(
        );
        ValuesSourceAggregationBuilder[] aggBuilders = {
            if (randomBoolean()) {
            iw.forceMerge(1);
                            supportedDimensions,
                        String queryField;
                null,
        int totalDocs = 100;
import org.apache.lucene.search.Query;
public class StarTreeNestedAggregatorTests extends DateHistogramAggregatorTestCase {
                    ValuesSourceAggregationBuilder<?> outer = outerSupplier.get().subAggregation(inner);
import java.util.function.Supplier;
        IndexSearcher indexSearcher,
                query,
        List<?> starTreeBuckets = getBuckets.apply(starTreeAgg);
import java.util.List;
    private static final MappedFieldType SIZE_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(SIZE, NumberFieldMapper.NumberType.LONG);
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
        Function<T, List<?>> getBuckets,
        Query query,
                doc.add(new SortedNumericDocValuesField(SIZE, val));
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);
                false,
            queryBuilder = null;
                    for (int cases = 0; cases < 5; cases++) {
        // 3-LEVELS [BUCKET -> BUCKET -> METRIC]
import org.apache.logging.log4j.Logger;
                KEYWORD_FIELD_TYPE
    private void testCase(
/*
import org.apache.lucene.index.LeafReaderContext;
        for (ValuesSourceAggregationBuilder aggregationBuilder : aggBuilders) {
                InternalDateHistogram.class,
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        List<?> defaultBuckets = getBuckets.apply(defaultAgg);
            sum("_sum").field(STATUS),
        }
                starTree,
                aggregationBuilder,
                val = random.nextInt(10); // Random strings for int between 0 and 9 for keyword terms
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
import org.opensearch.index.compositeindex.datacube.NumericDimension;
                    new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)
        if (randomBoolean()) {
                SIZE_FIELD_TYPE,
        IndexSearcher indexSearcher = newSearcher(wrapInMockESDirectoryReader(ir), false, false);
        conf.setMergePolicy(newLogMergePolicy());
                null,
        LeafReaderContext context = ir.leaves().get(0);
            () -> terms("term_keyword").field(KEYWORD_FIELD).collectMode(Aggregator.SubAggCollectionMode.BREADTH_FIRST),
                starTree,
                    // assertion in
                            starTree,
                doc.add(new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef(String.valueOf(val))));
                skipReducedMultiBucketConsumerAssertion,
                                outermost,
                        for (int cases = 0; cases < 5; cases++) {
                queryBuilder,
                true,
            }
            if (randomBoolean()) {
import java.io.IOException;
                        // ReducedMultiBucketConsumer assertion in
    private static final MappedFieldType TIMESTAMP_FIELD_TYPE = new DateFieldMapper.DateFieldType(TIMESTAMP_FIELD);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
    }
        }
        // 4-LEVELS [BUCKET -> BUCKET -> BUCKET -> METRIC]
            );
                        queryValue = random.nextInt(10);
            );
            () -> terms("term_size").field(SIZE),
                SIZE_FIELD_TYPE,
            query = new MatchAllDocsQuery();
        IndexWriterConfig conf = newIndexWriterConfig(null);
                            queryField = STATUS;
import org.opensearch.index.compositeindex.datacube.DateDimension;
                            indexSearcher,
import org.apache.lucene.index.IndexWriterConfig;
                STATUS_FIELD_TYPE,
import org.apache.lucene.document.Document;
                            long queryValue;
            min("_min").field(STATUS),
    private static final String KEYWORD_FIELD = "clientip";
                            outermost,
                null,
                                query,
                                queryField = STATUS;
                SIZE_FIELD_TYPE,
import static org.opensearch.search.aggregations.AggregationBuilders.range;
                    // Numeric-terms query with numeric terms aggregation
                skipReducedMultiBucketConsumerAssertion,
                ),
                doc.add(new LongPoint(TIMESTAMP_FIELD, date));
import org.apache.lucene.util.BytesRef;
                            supportedDimensions,
                            queryField = SIZE;
                InternalTerms.class,
        );
                        }
                doc.add(new SortedNumericDocValuesField(TIMESTAMP_FIELD, date));
                supportedDimensions,
    }
                    for (Supplier<ValuesSourceAggregationBuilder<?>> innerSupplier : aggregationSuppliers) {
    public void testStarTreeNestedAggregations() throws IOException {
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions = new LinkedHashMap<>();
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
            if (randomBoolean()) {
                queryBuilder,
    );
        MapperService mapperService;
        );
                queryBuilder,
        conf.setCodec(getCodec());
import org.opensearch.index.mapper.MappedFieldType;
                        starTree,
            if (randomBoolean()) {
                            query,
import org.opensearch.index.query.QueryBuilder;
                for (Supplier<ValuesSourceAggregationBuilder<?>> innerSupplier : aggregationSuppliers) {
                val = random.nextInt(100); // Random int between 0 and 99 for status
        ValuesSourceAggregationBuilder<?> aggregationBuilder,
                skipReducedMultiBucketConsumerAssertion,
import org.apache.lucene.tests.index.RandomIndexWriter;
                null,
        NumberFieldMapper.NumberType.LONG
}
                skipReducedMultiBucketConsumerAssertion,
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        iw.close();
                                queryBuilder,
                TIMESTAMP_FIELD_TYPE,
                            starTree,
                            query,
import java.util.Random;
        Directory directory = newDirectory();
