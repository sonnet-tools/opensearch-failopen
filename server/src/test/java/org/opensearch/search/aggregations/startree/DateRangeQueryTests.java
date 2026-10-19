import java.util.concurrent.TimeUnit;
                TIMESTAMP_FIELD,
import org.apache.lucene.search.IndexOrDocValuesQuery;
                doc.add(new SortedNumericDocValuesField(STATUS, val));
            testCase(indexSearcher, query, queryBuilderAbsolute, rangeAggregationBuilder, starTree, supportedDimensions);
            testCase(indexSearcher, query, queryBuilderAbsolute, sumAggregationBuilder, starTree, supportedDimensions);
            }
import org.apache.lucene.tests.index.RandomIndexWriter;
            int randomFrom = random.nextInt(80) + 120;
            new DateDimension(
import org.apache.logging.log4j.LogManager;
            false,
import java.util.List;
        int val;
                    new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)
            Document doc = new Document();
        );
import org.apache.lucene.search.Query;
        IndexSearcher indexSearcher,
import org.opensearch.index.query.QueryBuilder;
                .addRange(10, 30)
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
            AggregationBuilder termAggregationBuilder = terms("terms_agg").field(STATUS).subAggregation(sumAggregationBuilder);
        long date;
            null,
        Random random = RandomizedTest.getRandom();
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
            String toDateString = formatter.format(Instant.ofEpochMilli(to));
import org.apache.lucene.index.DirectoryReader;
            long from = startOfTodayUTC.toEpochMilli() - TimeUnit.DAYS.toMillis(randomFrom);
            false,
    }
import org.opensearch.index.query.RangeQueryBuilder;
     */
        int totalDocs = 100;
        BooleanQuery booleanQuery = new BooleanQuery.Builder().add(query, BooleanClause.Occur.MUST)
        MapperService mapperService;
        InternalAggregation starTreeAggregation = searchAndReduceStarTree(
            testCase(indexSearcher, query, queryBuilderAbsolute, rangeAggregationBuilder, starTree, supportedDimensions);
        Instant startOfTodayUTC = now.truncatedTo(ChronoUnit.DAYS);
            doc.add(new LongPoint(TIMESTAMP_FIELD, date));
            rangeAggregationBuilder = range("range_agg").field(STATUS)
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
                .includeLower(true)
            null,
            String fromDateString = formatter.format(Instant.ofEpochMilli(from));
                val = random.nextInt(10); // Random int between 0 and 9 for status
            long to = startOfTodayUTC.toEpochMilli() - TimeUnit.DAYS.toMillis(randomTo);
        supportedDimensions.put(
     * Also, wraps the query in boolean query to test for the same results.
            ),
        if (randomBoolean()) {
            SIZE_FIELD_TYPE,
        final Logger testLogger = LogManager.getLogger(MetricAggregatorTests.class);
import org.opensearch.index.query.BoolQueryBuilder;
 * Tests for aggregations with date-range query
                doc.add(new SortedNumericDocValuesField(SIZE, val));
        IndexSearcher indexSearcher = newSearcher(reader, false, false);
            query,
        assertEquals(defaultAggregation, starTreeAggregation);
            testCase(indexSearcher, query, queryBuilderRelative, rangeAggregationBuilder, starTree, supportedDimensions);
            indexSearcher,
        SegmentReader reader = Lucene.segmentReader(context.reader());
    ) throws IOException {
        boolQueryBuilder.must(queryBuilder);
            testCaseForQuery(indexSearcher, booleanQuery, boolQueryBuilder, sumAggregationBuilder, starTree, supportedDimensions);
        // Index 100 random documents
            STATUS_FIELD_TYPE
    protected Codec getCodec() {
            testCase(indexSearcher, query, queryBuilderRelative, rangeAggregationBuilder, starTree, supportedDimensions);
import org.opensearch.search.aggregations.AggregationBuilder;
            TIMESTAMP_FIELD_TYPE,
        AggregationBuilder aggregationBuilder,
            testCaseForQuery(indexSearcher, booleanQuery, boolQueryBuilder, sumAggregationBuilder, starTree, supportedDimensions);
import org.apache.lucene.search.BooleanQuery;
        Query query,
            new NumericDimension(SIZE),
import org.apache.lucene.index.IndexWriterConfig;
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
import java.time.Instant;
        final long nowMillis = System.currentTimeMillis();
import org.opensearch.index.compositeindex.datacube.Dimension;
            boolQueryBuilder = new BoolQueryBuilder();
        testCaseForQuery(indexSearcher, query, queryBuilder, aggregationBuilder, starTree, supportedDimensions);
        );
            .add(query, BooleanClause.Occur.MUST)
    private static final String TIMESTAMP_FIELD = "@timestamp";
            }
import java.time.format.DateTimeFormatter;
 * SPDX-License-Identifier: Apache-2.0
            STATUS_FIELD_TYPE
            queryBuilder,
        }
        AggregationBuilder aggregationBuilder,
            TIMESTAMP_FIELD_TYPE,
            aggregationBuilder,
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
            // corresponding queryBuilder for the above query
    private void testCaseForQuery(
import org.opensearch.common.lucene.Lucene;
        List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
        );
        CompositeIndexFieldInfo starTree,
            supportedDimensions,
        initValuesSourceRegistry();
import org.apache.lucene.document.Document;
        for (int i = 0; i < totalDocs; i++) {
            DEFAULT_MAX_BUCKETS,
            new NumberFieldMapper.NumberFieldType(STATUS, NumberFieldMapper.NumberType.INTEGER)
            if (random.nextBoolean()) {
    public void testStarTreeValidDateRangeQuery() throws IOException {
    ) throws IOException {
 */
        );
        QueryBuilder queryBuilder,
 * The OpenSearch Contributors require contributions made to
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        IndexSearcher indexSearcher,
            testCase(indexSearcher, query, queryBuilderAbsolute, termAggregationBuilder, starTree, supportedDimensions);
        final long duration180DaysMillis = TimeUnit.DAYS.toMillis(180);
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions
            iw.forceMerge(1);
                .format("strict_date_optional_time||epoch_millis");
        } catch (IOException e) {
            docs.add(doc);
        );
    private static final MappedFieldType STATUS_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(
        iw.close();
                .build();
            false,
            true,
        ir.close();
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);
            testCase(indexSearcher, query, queryBuilderRelative, termAggregationBuilder, starTree, supportedDimensions);
        conf.setCodec(getCodec());
public class DateRangeQueryTests extends AggregatorTestCase {
import org.apache.lucene.search.IndexSearcher;
    private static final MappedFieldType TIMESTAMP_FIELD_TYPE = new DateFieldMapper.DateFieldType(TIMESTAMP_FIELD);
import org.opensearch.index.compositeindex.datacube.NumericDimension;
 *
            null,
    private void testCase(
        conf.setMergePolicy(newLogMergePolicy());
import static org.opensearch.search.aggregations.AggregationBuilders.range;
            null,
import java.util.Random;
                    new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR),
            new DateFieldMapper.DateFieldType(TIMESTAMP_FIELD)
        for (int i = 0; i < 100; i++) {
        supportedDimensions.put(
        directory.close();
            QueryBuilder queryBuilderRelative = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateStringNow)
            DEFAULT_MAX_BUCKETS,
import org.opensearch.index.mapper.DateFieldMapper;
            indexSearcher,
    }
import org.apache.lucene.index.SegmentReader;
import java.time.temporal.ChronoUnit;
        }
            boolQueryBuilder.should(queryBuilderAbsolute).should(queryBuilderAbsolute);
package org.opensearch.search.aggregations.startree;
import java.util.ArrayList;
    private static final MappedFieldType SIZE_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(SIZE, NumberFieldMapper.NumberType.LONG);
import org.opensearch.common.Rounding;
            null,
        LeafReaderContext context = ir.leaves().get(0);
import org.opensearch.index.codec.composite.CompositeIndexReader;
            booleanQuery = new BooleanQuery.Builder().add(query, BooleanClause.Occur.SHOULD).add(query, BooleanClause.Occur.SHOULD).build();
        CompositeIndexFieldInfo starTree = compositeIndexFields.get(0);
            aggregationBuilder,
            .build();
import org.apache.lucene.document.SortedNumericDocValuesField;
                .addRange(30, 50)
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
            createIndexSettings(),
    final static String STATUS = "status";
            createIndexSettings(),
        Query query,
            throw new RuntimeException(e);
                .subAggregation(sumAggregationBuilder);
        Directory directory = newDirectory();
            String fromDateStringNow = "now-" + randomFrom + "d/d";
                SortedNumericDocValuesField.newSlowRangeQuery(TIMESTAMP_FIELD, from, to - 1)
                .includeLower(true)
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
            starTree,
            new NumericDimension(STATUS),
                .format("strict_date_optional_time||epoch_millis");
        CompositeIndexFieldInfo starTree,
import org.opensearch.index.mapper.MappedFieldType;
        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
            iw.addDocument(doc);
            queryBuilder,
     * Test case for the given query and aggregation builder.
    /**
    );
            query,
import org.opensearch.index.mapper.NumberFieldMapper;
            testCase(indexSearcher, query, queryBuilderRelative, sumAggregationBuilder, starTree, supportedDimensions);
    final static String SIZE = "size";
import org.apache.lucene.codecs.Codec;
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions
            QueryBuilder queryBuilderAbsolute = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateString)
            Query query = new IndexOrDocValuesQuery(
                val = random.nextInt(100); // Random int between 0 and 99 for size
/**
        IndexWriterConfig conf = newIndexWriterConfig(null);
    }
import java.io.IOException;
        supportedDimensions.put(
                .includeUpper(false)
            doc.add(new SortedNumericDocValuesField(TIMESTAMP_FIELD, date));
import org.apache.lucene.index.LeafReaderContext;
            );
/*
                ),
                .to(toDateStringNow)
 * this file be licensed under the Apache-2.0 license or a
            AggregationBuilder sumAggregationBuilder = sum("max").field(SIZE);
                LongPoint.newRangeQuery(TIMESTAMP_FIELD, from, to - 1),
import org.apache.logging.log4j.Logger;
                .add(query, BooleanClause.Occur.MUST)
        NumberFieldMapper.NumberType.LONG
import org.apache.lucene.store.Directory;
            SIZE_FIELD_TYPE,
import org.opensearch.search.aggregations.AggregatorTestCase;
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions = new LinkedHashMap<>();
import org.opensearch.index.compositeindex.datacube.DateDimension;
        Instant now = Instant.ofEpochMilli(nowMillis);
            new NumberFieldMapper.NumberFieldType(SIZE, NumberFieldMapper.NumberType.INTEGER)
        QueryBuilder queryBuilder,
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
import com.carrotsearch.randomizedtesting.RandomizedTest;
                .includeUpper(false)
        testCaseForQuery(indexSearcher, booleanQuery, boolQueryBuilder, aggregationBuilder, starTree, supportedDimensions);
 * compatible open source license.
    }
}
            AggregationBuilder rangeAggregationBuilder = range("range_agg").field(STATUS).addRange(10, 30).addRange(30, 50);
            date = nowMillis - random.nextLong(duration180DaysMillis); // Random date within last 180 days
 */
            mapperService = StarTreeDocValuesFormatTests.createMapperService(DateHistogramAggregatorTests.getExpandedMapping(1, false));
        }
            BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        DirectoryReader ir = DirectoryReader.open(directory);
import org.opensearch.index.mapper.MapperService;
            null,
            boolQueryBuilder.must(queryBuilderAbsolute).must(queryBuilderAbsolute);
        try {
            int randomTo = random.nextInt(80);
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
        }
                List.of(
        InternalAggregation defaultAggregation = searchAndReduceStarTree(
import org.apache.lucene.search.BooleanClause;
            String toDateStringNow = "now-" + randomTo + "d/d";
                .to(toDateString)
                DateFieldMapper.Resolution.MILLISECONDS
import org.apache.lucene.document.LongPoint;
            BooleanQuery booleanQuery = new BooleanQuery.Builder().add(query, BooleanClause.Occur.MUST)
        List<Document> docs = new ArrayList<>();
import org.opensearch.search.aggregations.InternalAggregation;
import java.util.LinkedHashMap;
        STATUS,
            if (random.nextBoolean()) {
