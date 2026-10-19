            DateHistogramAggregationBuilder dateHistogramAggregationBuilder = dateHistogram("by_day").field(TIMESTAMP_FIELD)
            query,
            b.field("type", "integer");
            b.endObject();
            b.startObject("clientip");
            b.endArray();
        DirectoryReader ir = DirectoryReader.open(directory);
        InternalDateHistogram starTreeAggregation = searchAndReduceStarTree(
            b.value("day");
        );
        NumberFieldMapper.NumberType.LONG
            dateHistogramAggregationBuilder,
            }
            TIMESTAMP_FIELD_TYPE,
import org.apache.logging.log4j.Logger;
            createIndexSettings(),
        Query query,
            b.endObject();
            count("_name").field(FIELD_NAME),
            DEFAULT_MAX_BUCKETS,
                doc.add(new SortedNumericDocValuesField(STATUS, val));
            testCase(indexSearcher, query, queryBuilder, dateHistogramAggregationBuilder, starTree, supportedDimensions);
            b.endObject();
        QueryBuilder queryBuilder,
            b.value("max");
            b.startObject("geoip");
                .subAggregation(aggregationBuilder);
            Document doc = new Document();
            b.endObject();
            b.endObject();
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
import org.opensearch.index.query.TermQueryBuilder;
import org.opensearch.common.lucene.Lucene;
/*
import org.apache.lucene.tests.index.RandomIndexWriter;
    private static final String FIELD_NAME = "status";
            b.endObject();
            b.value("min");
            b.field("index", false);
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions = new LinkedHashMap<>();
import com.carrotsearch.randomizedtesting.RandomizedTest;
            b.startObject("@timestamp");
                } else {
            b.field("type", "date");
import org.opensearch.common.Rounding;
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);
    private void testCase(
                // year not present in star-tree, but should be able to compute using @timestamp_day dimension
}
        IndexSearcher indexSearcher = newSearcher(reader, false, false);
            b.value("min");
import org.apache.lucene.index.LeafReaderContext;
            b.endObject();
            b.field("name", TIMESTAMP_FIELD);
            queryBuilder,
            b.endObject();
            b.endArray();
        final Logger testLogger = LogManager.getLogger(MetricAggregatorTests.class);
                ),
            b.endArray();
            b.startArray("ordered_dimensions");
            b.value("month");
import static org.opensearch.index.codec.composite912.datacube.startree.AbstractStarTreeDVFormatTests.topMapping;
            new NumericDimension(SIZE),
            b.startObject("city_name");
            b.startObject("status");
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
                .calendarInterval(DateHistogramInterval.MONTH)
                b.startArray("skip_star_node_creation_for_dimensions");
                .calendarInterval(DateHistogramInterval.DAY)
            b.endObject();
            b.startArray("metrics");
            b.value("max");
            false,
    private static final MappedFieldType NUMBER_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(
        }
        DateHistogramAggregationBuilder dateHistogramAggregationBuilder,
        long date;
import org.opensearch.index.mapper.NumberFieldMapper;
            for (int cases = 0; cases < 100; cases++) {
        supportedDimensions.put(
import org.apache.lucene.search.Query;
            null,
            TIMESTAMP_FIELD_TYPE,
            }
            null,
import org.opensearch.index.compositeindex.datacube.DateDimension;
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
            max("_name").field(FIELD_NAME),
            b.field("name", "size");
        conf.setCodec(getCodec());
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogram;
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;
            b.endObject();
                    .calendarInterval(DateHistogramInterval.YEAR)
import org.apache.lucene.index.IndexWriterConfig;
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions
                String queryField;
            null,
            false,
            createIndexSettings(),
            true,
        // Index 100 random documents
package org.opensearch.search.aggregations.startree;
            b.field("type", "text");
import java.util.Random;
            b.field("name", "status");
        );
            b.endArray();
 * The OpenSearch Contributors require contributions made to
            b.startObject("request");
            indexSearcher,
import org.opensearch.index.compositeindex.datacube.NumericDimension;
import org.apache.lucene.index.DirectoryReader;
import org.opensearch.index.mapper.MappedFieldType;
                .calendarInterval(DateHistogramInterval.YEAR)
        int val;
            avg("_name").field(FIELD_NAME) };
            doc.add(new LongPoint(TIMESTAMP_FIELD, date));
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        List<Document> docs = new ArrayList<>();
import org.opensearch.index.query.QueryBuilder;
            Query query = new MatchAllDocsQuery();
            iw.forceMerge(1);
                    queryField = SIZE;
            null,
    }
                long queryValue;
            b.startObject("composite");
            null,
import java.util.LinkedHashMap;
            b.startObject("country_name");
            b.field("type", "geo_point");
 * compatible open source license.
import java.io.IOException;
import org.apache.lucene.store.Directory;
import org.opensearch.index.mapper.MapperService;
            starTree,
        final String STATUS = "status";
import org.opensearch.index.codec.composite.CompositeIndexReader;
        SegmentReader reader = Lucene.segmentReader(context.reader());
        Directory directory = newDirectory();
            testCase(indexSearcher, query, queryBuilder, dateHistogramAggregationBuilder, starTree, supportedDimensions);
 * this file be licensed under the Apache-2.0 license or a
            dateHistogramAggregationBuilder = dateHistogram("by_year").field(TIMESTAMP_FIELD)
            b.startArray("stats");
            b.endObject();
                dateHistogramAggregationBuilder = dateHistogram("by_month").field(TIMESTAMP_FIELD)
        if (randomBoolean()) {
            // year not present in star-tree, but should be able to compute using @timestamp_day dimension
                    queryValue = random.nextInt(10);
    }
            b.value("value_count");
 *
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregatorTestCase;
                    .subAggregation(aggregationBuilder);
import org.opensearch.core.xcontent.XContentBuilder;
            b.endObject();
        iw.close();
        ir.close();
            supportedDimensions,
            b.field("doc_values", false);
                b.value("status"); // Skip for "status" dimension
            iw.addDocument(doc);
            b.startObject("config");
        try {
            if (random.nextBoolean()) {
            b.startArray("stats");
        ValuesSourceAggregationBuilder[] agggBuilders = {
            b.field("type", "keyword");
import java.util.List;
            b.startObject();
            new DateDimension(
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
            DEFAULT_MAX_BUCKETS,
            b.startObject("size");
                testCase(indexSearcher, query, queryBuilder, dateHistogramAggregationBuilder, starTree, supportedDimensions);
                TIMESTAMP_FIELD,
            b.startObject("properties");
            b.endObject();
            b.endObject();
import static org.opensearch.search.aggregations.AggregationBuilders.max;
            dateHistogramAggregationBuilder,
    }
                if (randomBoolean()) {
                val = random.nextInt(100); // Random int between 0 and 99 for size
                List.of(
import org.opensearch.index.mapper.DateFieldMapper;
            b.startObject();
        LeafReaderContext context = ir.leaves().get(0);
                val = random.nextInt(10); // Random int between 0 and 9 for status
        });
import static org.opensearch.search.aggregations.AggregationBuilders.count;
                    .subAggregation(aggregationBuilder);
            new NumberFieldMapper.NumberFieldType(SIZE, NumberFieldMapper.NumberType.INTEGER)
            docs.add(doc);
            queryBuilder,
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
            b.field("name", "size");
                dateHistogramAggregationBuilder = dateHistogram("by_year").field(TIMESTAMP_FIELD)
        List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
        for (int i = 0; i < totalDocs; i++) {
    private static final MappedFieldType TIMESTAMP_FIELD_TYPE = new DateFieldMapper.DateFieldType(TIMESTAMP_FIELD);
import java.util.ArrayList;
            if (random.nextBoolean()) {
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
            false,
        }
            b.field("type", "keyword");
            b.endObject();
import org.apache.lucene.document.Document;
                    queryField = STATUS;
        for (ValuesSourceAggregationBuilder aggregationBuilder : agggBuilders) {
            null,
        assertEquals(defaultAggregation.getBuckets().size(), starTreeAggregation.getBuckets().size());
        }
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.apache.lucene.document.LongPoint;
            b.startObject("startree1"); // Use the same name as the provided mapping
        conf.setMergePolicy(newLogMergePolicy());
            b.startObject();
            b.field("max_leaf_docs", maxLeafDocs);
            new NumberFieldMapper.NumberFieldType(STATUS, NumberFieldMapper.NumberType.INTEGER)
            QueryBuilder queryBuilder = null;
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
            b.value("sum");
            }
        }
                }
import org.apache.lucene.index.SegmentReader;
            min("_name").field(FIELD_NAME),
            b.field("name", "status");
        final String SIZE = "size";
    private static final String TIMESTAMP_FIELD = "@timestamp";
            mapperService = StarTreeDocValuesFormatTests.createMapperService(getExpandedMapping(1, false));
        int totalDocs = 100;
            date = random.nextInt(180) * 24 * 60 * 60 * 1000L; // Random date within 180 days
        FIELD_NAME,
            b.endObject();
        CompositeIndexFieldInfo starTree,
            b.value("value_count");
                doc.add(new SortedNumericDocValuesField(SIZE, val));
            b.endObject();
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
            b.startObject();
            b.endObject();
            NUMBER_FIELD_TYPE
    );
            b.startObject("fields");
    protected Codec getCodec() {
            new DateFieldMapper.DateFieldType(TIMESTAMP_FIELD)
    public static XContentBuilder getExpandedMapping(int maxLeafDocs, boolean skipStarNodeCreationForStatusDimension) throws IOException {
            b.endObject();
import static org.opensearch.search.aggregations.AggregationBuilders.min;
                queryBuilder = new TermQueryBuilder(queryField, queryValue);
        assertEquals(defaultAggregation.getBuckets(), starTreeAggregation.getBuckets());
import org.apache.lucene.search.MatchAllDocsQuery;
            b.field("type", "keyword");
        initValuesSourceRegistry();
                    .calendarInterval(DateHistogramInterval.MONTH)
            b.endObject();
                    new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR),
            b.endObject();
            testCase(indexSearcher, query, queryBuilder, dateHistogramAggregationBuilder, starTree, supportedDimensions);
        InternalDateHistogram defaultAggregation = searchAndReduceStarTree(
            b.endArray();
                .subAggregation(aggregationBuilder);
import org.opensearch.index.compositeindex.datacube.Dimension;
            b.startArray("calendar_intervals");
            b.startObject("location");
            }
            b.field("type", "ip");
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
                .subAggregation(aggregationBuilder);
            b.startObject();
        directory.close();
            dateHistogramAggregationBuilder = dateHistogram("by_month").field(TIMESTAMP_FIELD)
            b.startObject("properties");
        );
    public void testStarTreeDateHistogram() throws IOException {
        supportedDimensions.put(
            doc.add(new SortedNumericDocValuesField(TIMESTAMP_FIELD, date));
            b.field("type", "integer");
        return topMapping(b -> {
            b.value("sum");
            new NumericDimension(STATUS),
            b.field("type", "star_tree");
    }
            query,
                b.endArray();
            NUMBER_FIELD_TYPE
        Random random = RandomizedTest.getRandom();
            b.field("type", "keyword");
import org.apache.logging.log4j.LogManager;
            b.startObject("message");
                testCase(indexSearcher, query, queryBuilder, dateHistogramAggregationBuilder, starTree, supportedDimensions);
        } catch (IOException e) {
            ),
        MapperService mapperService;
 */
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
                query = SortedNumericDocValuesField.newSlowExactQuery(queryField, queryValue);
public class DateHistogramAggregatorTests extends DateHistogramAggregatorTestCase {
                DateFieldMapper.Resolution.MILLISECONDS
        supportedDimensions.put(
            // Numeric-terms query with date histogram
    ) throws IOException {
        IndexSearcher indexSearcher,
            b.field("ignore_above", 256);
            indexSearcher,
                    queryValue = random.nextInt(20) - 15;
            b.endObject();
            b.startObject("raw");
        );
        );
import org.apache.lucene.search.IndexSearcher;
            sum("_name").field(FIELD_NAME),
import org.apache.lucene.codecs.Codec;
        IndexWriterConfig conf = newIndexWriterConfig(null);
        CompositeIndexFieldInfo starTree = compositeIndexFields.get(0);
            throw new RuntimeException(e);
                    new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)
            b.field("format", "strict_date_optional_time||epoch_millis");
            if (skipStarNodeCreationForStatusDimension) {
