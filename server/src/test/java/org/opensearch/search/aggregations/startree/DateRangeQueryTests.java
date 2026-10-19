            indexSearcher,  
                .includeLower(true)  
import java.util.List;  
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions = new LinkedHashMap<>();
            TIMESTAMP_FIELD_TYPE,
    }
                ),
import org.apache.logging.log4j.LogManager;  
            String fromDateStringNow = "now-" + randomFrom + "d/d";
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
        );
 * compatible open source license.
    }  
    }  
import org.apache.lucene.document.SortedNumericDocValuesField;  
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
            int randomFrom = random.nextInt(80) + 120;
import org.apache.lucene.tests.index.RandomIndexWriter;
    protected Codec getCodec() {  
            null,  
import org.apache.lucene.index.LeafReaderContext;  
import java.time.Instant;
        IndexWriterConfig conf = newIndexWriterConfig(null);
            true,
        int val;  
import org.apache.lucene.search.BooleanClause;
        );  
import java.io.IOException;  
            .build();
            indexSearcher,  
            iw.forceMerge(1);
import org.apache.lucene.search.Query;  
        try {  
            // corresponding queryBuilder for the above query
        // Index 100 random documents  
            QueryBuilder queryBuilderRelative = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateStringNow)
 */
public class DateRangeQueryTests extends AggregatorTestCase {  
            testCase(indexSearcher, query, queryBuilderRelative, rangeAggregationBuilder, starTree, supportedDimensions);  
            testCase(indexSearcher, query, queryBuilderAbsolute, rangeAggregationBuilder, starTree, supportedDimensions);
            boolQueryBuilder.must(queryBuilderAbsolute).must(queryBuilderAbsolute);
            testCase(indexSearcher, query, queryBuilderAbsolute, termAggregationBuilder, starTree, supportedDimensions);  
            rangeAggregationBuilder = range("range_agg").field(STATUS)
            long to = startOfTodayUTC.toEpochMilli() - TimeUnit.DAYS.toMillis(randomTo);  
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
import org.opensearch.index.codec.composite.CompositeIndexReader;  
            testCaseForQuery(indexSearcher, booleanQuery, boolQueryBuilder, sumAggregationBuilder, starTree, supportedDimensions);
            testCase(indexSearcher, query, queryBuilderRelative, sumAggregationBuilder, starTree, supportedDimensions);
import org.apache.lucene.search.BooleanQuery;  
import org.opensearch.index.query.QueryBuilder;  
/*  
            boolQueryBuilder.should(queryBuilderAbsolute).should(queryBuilderAbsolute);
        DirectoryReader ir = DirectoryReader.open(directory);
            new DateFieldMapper.DateFieldType(TIMESTAMP_FIELD)
        IndexSearcher indexSearcher = newSearcher(reader, false, false);
        testCaseForQuery(indexSearcher, query, queryBuilder, aggregationBuilder, starTree, supportedDimensions);
            booleanQuery = new BooleanQuery.Builder().add(query, BooleanClause.Occur.SHOULD).add(query, BooleanClause.Occur.SHOULD).build();  
        ir.close();  
                .build();
/**  
        IndexSearcher indexSearcher,  
        assertEquals(defaultAggregation, starTreeAggregation);
                SortedNumericDocValuesField.newSlowRangeQuery(TIMESTAMP_FIELD, from, to - 1)
        conf.setCodec(getCodec());
            doc.add(new SortedNumericDocValuesField(TIMESTAMP_FIELD, date));  
import org.apache.logging.log4j.Logger;
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();  
            new NumericDimension(STATUS),  
     */
    private void testCase(
                .to(toDateString)
        supportedDimensions.put(  
                    new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)  
            testCase(indexSearcher, query, queryBuilderAbsolute, rangeAggregationBuilder, starTree, supportedDimensions);
            BooleanQuery booleanQuery = new BooleanQuery.Builder().add(query, BooleanClause.Occur.MUST)
                List.of(
 * Tests for aggregations with date-range query
            DEFAULT_MAX_BUCKETS,
        Directory directory = newDirectory();  
                doc.add(new SortedNumericDocValuesField(STATUS, val));
        QueryBuilder queryBuilder,
            supportedDimensions,
            }  
import org.opensearch.index.mapper.MapperService;  
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions
        if (randomBoolean()) {  
            );
            QueryBuilder queryBuilderAbsolute = new RangeQueryBuilder(TIMESTAMP_FIELD).from(fromDateString)
        }
            .add(query, BooleanClause.Occur.MUST)  
    private static final MappedFieldType STATUS_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(  
    private static final MappedFieldType TIMESTAMP_FIELD_TYPE = new DateFieldMapper.DateFieldType(TIMESTAMP_FIELD);
            query,
        );
import java.util.Random;
        }
            mapperService = StarTreeDocValuesFormatTests.createMapperService(DateHistogramAggregatorTests.getExpandedMapping(1, false));
            String toDateStringNow = "now-" + randomTo + "d/d";  
     * Also, wraps the query in boolean query to test for the same results.  
import com.carrotsearch.randomizedtesting.RandomizedTest;
            new NumberFieldMapper.NumberFieldType(STATUS, NumberFieldMapper.NumberType.INTEGER)
import org.opensearch.index.query.RangeQueryBuilder;
                .format("strict_date_optional_time||epoch_millis");  
            testCase(indexSearcher, query, queryBuilderRelative, rangeAggregationBuilder, starTree, supportedDimensions);
        long date;
 *
    }
    final static String SIZE = "size";
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions
            iw.addDocument(doc);
import org.opensearch.common.lucene.Lucene;
                .add(query, BooleanClause.Occur.MUST)  
            null,  
            testCaseForQuery(indexSearcher, booleanQuery, boolQueryBuilder, sumAggregationBuilder, starTree, supportedDimensions);
            query,
                DateFieldMapper.Resolution.MILLISECONDS
        final long nowMillis = System.currentTimeMillis();  
import org.apache.lucene.index.IndexWriterConfig;
    final static String STATUS = "status";
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
            createIndexSettings(),
import org.apache.lucene.index.DirectoryReader;
        AggregationBuilder aggregationBuilder,  
            String fromDateString = formatter.format(Instant.ofEpochMilli(from));
            queryBuilder,
import org.opensearch.index.compositeindex.datacube.NumericDimension;
import org.apache.lucene.codecs.Codec;
        boolQueryBuilder.must(queryBuilder);
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
            null,  
            new DateDimension(
     * Test case for the given query and aggregation builder.
package org.opensearch.search.aggregations.startree;
                .includeUpper(false)
        CompositeIndexFieldInfo starTree,
    );  
                doc.add(new SortedNumericDocValuesField(SIZE, val));  
            long from = startOfTodayUTC.toEpochMilli() - TimeUnit.DAYS.toMillis(randomFrom);
            false,
            }
    public void testStarTreeValidDateRangeQuery() throws IOException {
                val = random.nextInt(100); // Random int between 0 and 99 for size
            if (random.nextBoolean()) {
        }
            false,
        );
                .to(toDateStringNow)
    /**
    private void testCaseForQuery(
import java.time.temporal.ChronoUnit;  
            BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();  
                .includeLower(true)  
            boolQueryBuilder = new BoolQueryBuilder();
            aggregationBuilder,  
        Instant startOfTodayUTC = now.truncatedTo(ChronoUnit.DAYS);
            TIMESTAMP_FIELD_TYPE,
import org.apache.lucene.search.IndexSearcher;
                .addRange(10, 30)
        SegmentReader reader = Lucene.segmentReader(context.reader());  
        conf.setMergePolicy(newLogMergePolicy());  
                TIMESTAMP_FIELD,  
        Instant now = Instant.ofEpochMilli(nowMillis);
import org.apache.lucene.codecs.lucene104.Lucene104Codec;  
            new NumberFieldMapper.NumberFieldType(SIZE, NumberFieldMapper.NumberType.INTEGER)
            if (random.nextBoolean()) {  
                    new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR),
        int totalDocs = 100;
        iw.close();  
        testCaseForQuery(indexSearcher, booleanQuery, boolQueryBuilder, aggregationBuilder, starTree, supportedDimensions);
import org.opensearch.index.mapper.MappedFieldType;
        STATUS,
        );
                val = random.nextInt(10); // Random int between 0 and 9 for status
        Random random = RandomizedTest.getRandom();  
            AggregationBuilder rangeAggregationBuilder = range("range_agg").field(STATUS).addRange(10, 30).addRange(30, 50);  
import static org.opensearch.search.aggregations.AggregationBuilders.range;
            starTree,
            int randomTo = random.nextInt(80);  
        CompositeIndexFieldInfo starTree = compositeIndexFields.get(0);
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;  
import org.opensearch.index.mapper.NumberFieldMapper;
            SIZE_FIELD_TYPE,  
            date = nowMillis - random.nextLong(duration180DaysMillis); // Random date within last 180 days
        InternalAggregation starTreeAggregation = searchAndReduceStarTree(
            STATUS_FIELD_TYPE
            doc.add(new LongPoint(TIMESTAMP_FIELD, date));
import java.util.LinkedHashMap;
 * this file be licensed under the Apache-2.0 license or a
        List<Document> docs = new ArrayList<>();
import org.opensearch.search.aggregations.AggregatorTestCase;  
        for (int i = 0; i < 100; i++) {
import java.time.format.DateTimeFormatter;
        }
        QueryBuilder queryBuilder,
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
            ),  
 */  
        for (int i = 0; i < totalDocs; i++) {
        AggregationBuilder aggregationBuilder,  
import org.apache.lucene.document.Document;
        CompositeIndexFieldInfo starTree,
                .addRange(30, 50)  
import org.opensearch.common.Rounding;  
            AggregationBuilder sumAggregationBuilder = sum("max").field(SIZE);
            throw new RuntimeException(e);  
            Query query = new IndexOrDocValuesQuery(
        final Logger testLogger = LogManager.getLogger(MetricAggregatorTests.class);
            Document doc = new Document();
        NumberFieldMapper.NumberType.LONG
 * SPDX-License-Identifier: Apache-2.0
        initValuesSourceRegistry();  
        LeafReaderContext context = ir.leaves().get(0);
        directory.close();
                .subAggregation(sumAggregationBuilder);
        supportedDimensions.put(
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);
            String toDateString = formatter.format(Instant.ofEpochMilli(to));  
            testCase(indexSearcher, query, queryBuilderAbsolute, sumAggregationBuilder, starTree, supportedDimensions);  
        supportedDimensions.put(
            aggregationBuilder,  
import org.apache.lucene.store.Directory;
            queryBuilder,
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
    ) throws IOException {  
import org.opensearch.index.query.BoolQueryBuilder;
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
        DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
                LongPoint.newRangeQuery(TIMESTAMP_FIELD, from, to - 1),  
        InternalAggregation defaultAggregation = searchAndReduceStarTree(
import java.util.concurrent.TimeUnit;
        IndexSearcher indexSearcher,  
                .format("strict_date_optional_time||epoch_millis");  
            null,
        List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
import org.opensearch.search.aggregations.InternalAggregation;
            docs.add(doc);  
import org.opensearch.index.compositeindex.datacube.Dimension;
            new NumericDimension(SIZE),
            testCase(indexSearcher, query, queryBuilderRelative, termAggregationBuilder, starTree, supportedDimensions);
            DEFAULT_MAX_BUCKETS,
import org.apache.lucene.search.IndexOrDocValuesQuery;
            false,
    ) throws IOException {  
import org.apache.lucene.index.SegmentReader;
            STATUS_FIELD_TYPE
        MapperService mapperService;
            SIZE_FIELD_TYPE,  
import java.util.ArrayList;
        } catch (IOException e) {
            null,
}  
    private static final MappedFieldType SIZE_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(SIZE, NumberFieldMapper.NumberType.LONG);
        Query query,
            AggregationBuilder termAggregationBuilder = terms("terms_agg").field(STATUS).subAggregation(sumAggregationBuilder);
        Query query,
import org.opensearch.index.compositeindex.datacube.DateDimension;  
            null,  
 * The OpenSearch Contributors require contributions made to  
            createIndexSettings(),
        final long duration180DaysMillis = TimeUnit.DAYS.toMillis(180);  
    private static final String TIMESTAMP_FIELD = "@timestamp";
import org.opensearch.index.mapper.DateFieldMapper;
        BooleanQuery booleanQuery = new BooleanQuery.Builder().add(query, BooleanClause.Occur.MUST)
import org.apache.lucene.document.LongPoint;
import org.opensearch.search.aggregations.AggregationBuilder;
                .includeUpper(false)
