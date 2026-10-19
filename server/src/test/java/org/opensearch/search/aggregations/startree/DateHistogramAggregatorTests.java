        }
            b.field("name", "status");  
        directory.close();  
            DateHistogramAggregationBuilder dateHistogramAggregationBuilder = dateHistogram("by_day").field(TIMESTAMP_FIELD)  
            count("_name").field(FIELD_NAME),
import org.opensearch.index.codec.composite.CompositeIndexReader;
            b.startObject("geoip");
            b.field("index", false);
        InternalDateHistogram starTreeAggregation = searchAndReduceStarTree(
            false,
            null,  
            new NumericDimension(SIZE),
            b.endObject();
import org.opensearch.index.compositeindex.datacube.startree.utils.date.DateTimeUnitAdapter;
            b.field("name", "size");  
            null,
            b.field("type", "keyword");  
                    new DateTimeUnitAdapter(Rounding.DateTimeUnit.MONTH_OF_YEAR),  
            dateHistogramAggregationBuilder = dateHistogram("by_year").field(TIMESTAMP_FIELD)
            for (int cases = 0; cases < 100; cases++) {
            b.endObject();
import org.apache.lucene.index.LeafReaderContext;  
 */  
            b.field("max_leaf_docs", maxLeafDocs);
    protected Codec getCodec() {
 * SPDX-License-Identifier: Apache-2.0
                    new DateTimeUnitAdapter(Rounding.DateTimeUnit.DAY_OF_MONTH)
                .subAggregation(aggregationBuilder);
            b.endObject();
                testCase(indexSearcher, query, queryBuilder, dateHistogramAggregationBuilder, starTree, supportedDimensions);
                    queryValue = random.nextInt(20) - 15;
                if (randomBoolean()) {
import org.apache.lucene.document.Document;
import org.apache.lucene.codecs.Codec;
            b.endObject();  
        );
            b.endObject();
            b.startObject("@timestamp");
        Query query,
import org.apache.lucene.search.MatchAllDocsQuery;  
            if (random.nextBoolean()) {  
            NUMBER_FIELD_TYPE  
            b.value("sum");
            testCase(indexSearcher, query, queryBuilder, dateHistogramAggregationBuilder, starTree, supportedDimensions);
            b.endObject();
import org.apache.lucene.search.IndexSearcher;
            false,  
                doc.add(new SortedNumericDocValuesField(STATUS, val));
        MapperService mapperService;  
import org.apache.lucene.tests.index.RandomIndexWriter;  
import org.opensearch.index.compositeindex.datacube.DateDimension;
                    .calendarInterval(DateHistogramInterval.MONTH)
                queryBuilder = new TermQueryBuilder(queryField, queryValue);
        QueryBuilder queryBuilder,  
                .subAggregation(aggregationBuilder);
        );  
            new NumberFieldMapper.NumberFieldType(SIZE, NumberFieldMapper.NumberType.INTEGER)  
            b.endObject();
            b.endObject();
import java.io.IOException;  
            b.field("name", "status");  
        Directory directory = newDirectory();
    );
            testCase(indexSearcher, query, queryBuilder, dateHistogramAggregationBuilder, starTree, supportedDimensions);
import org.opensearch.index.mapper.NumberFieldMapper;  
            new DateDimension(  
        );
            }  
        conf.setMergePolicy(newLogMergePolicy());
    private static final MappedFieldType TIMESTAMP_FIELD_TYPE = new DateFieldMapper.DateFieldType(TIMESTAMP_FIELD);
        int totalDocs = 100;
            supportedDimensions,  
import org.opensearch.index.codec.composite.composite104.Composite104Codec;  
import org.apache.logging.log4j.Logger;
import org.opensearch.index.mapper.DateFieldMapper;  
            avg("_name").field(FIELD_NAME) };  
            b.endArray();
            null,
    public static XContentBuilder getExpandedMapping(int maxLeafDocs, boolean skipStarNodeCreationForStatusDimension) throws IOException {
            b.field("type", "text");
                .calendarInterval(DateHistogramInterval.DAY)
            starTree,
                } else {
        long date;  
        ValuesSourceAggregationBuilder[] agggBuilders = {
            b.startObject("status");
        }
        supportedDimensions.put(
import org.apache.logging.log4j.LogManager;  
import static org.opensearch.search.aggregations.AggregationBuilders.max;
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregatorTestCase;
    private void testCase(  
            b.field("ignore_above", 256);  
            }  
                val = random.nextInt(100); // Random int between 0 and 99 for size
            queryBuilder,
            dateHistogramAggregationBuilder,  
            b.startObject("raw");
            DEFAULT_MAX_BUCKETS,
            b.field("name", "size");  
            b.value("value_count");  
    public void testStarTreeDateHistogram() throws IOException {  
            createIndexSettings(),
                    .subAggregation(aggregationBuilder);
                .subAggregation(aggregationBuilder);
            b.startObject("country_name");  
        );  
            b.endObject();  
import org.apache.lucene.document.LongPoint;
            null,
            b.endObject();  
            queryBuilder,  
import org.apache.lucene.index.IndexWriterConfig;
            date = random.nextInt(180) * 24 * 60 * 60 * 1000L; // Random date within 180 days
            b.endObject();
            b.field("name", TIMESTAMP_FIELD);  
        conf.setCodec(getCodec());  
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
import java.util.LinkedHashMap;
            b.field("type", "keyword");
            dateHistogramAggregationBuilder,
            b.endObject();
        assertEquals(defaultAggregation.getBuckets(), starTreeAggregation.getBuckets());
            if (random.nextBoolean()) {
import static org.opensearch.search.aggregations.AggregationBuilders.min;
        List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
                testCase(indexSearcher, query, queryBuilder, dateHistogramAggregationBuilder, starTree, supportedDimensions);
import org.opensearch.core.xcontent.XContentBuilder;  
import static org.opensearch.search.aggregations.AggregationBuilders.count;
            TIMESTAMP_FIELD_TYPE,
            DEFAULT_MAX_BUCKETS,
        CompositeIndexFieldInfo starTree,
            b.startObject("city_name");  
}
        return topMapping(b -> {
            dateHistogramAggregationBuilder = dateHistogram("by_month").field(TIMESTAMP_FIELD)
        IndexSearcher indexSearcher = newSearcher(reader, false, false);
            // Numeric-terms query with date histogram
            sum("_name").field(FIELD_NAME),
            docs.add(doc);  
            null,  
            b.endArray();  
            b.value("month");
            indexSearcher,  
            b.startObject("config");  
            // year not present in star-tree, but should be able to compute using @timestamp_day dimension
        iw.close();  
            ),
        final Logger testLogger = LogManager.getLogger(MetricAggregatorTests.class);
            Document doc = new Document();
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions  
            b.value("min");
                // year not present in star-tree, but should be able to compute using @timestamp_day dimension
import org.opensearch.common.lucene.Lucene;
            new NumberFieldMapper.NumberFieldType(STATUS, NumberFieldMapper.NumberType.INTEGER)
            b.endObject();
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramAggregationBuilder;  
            b.startObject("size");
            min("_name").field(FIELD_NAME),
        Random random = RandomizedTest.getRandom();
            b.startArray("calendar_intervals");
            }  
public class DateHistogramAggregatorTests extends DateHistogramAggregatorTestCase {  
        FIELD_NAME,  
            new NumericDimension(STATUS),
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
    }
            b.endObject();  
                }
            b.startObject();
            b.field("type", "integer");
            testCase(indexSearcher, query, queryBuilder, dateHistogramAggregationBuilder, starTree, supportedDimensions);  
import java.util.List;  
            b.field("format", "strict_date_optional_time||epoch_millis");  
 * this file be licensed under the Apache-2.0 license or a
            b.field("type", "geo_point");
            b.endObject();
            max("_name").field(FIELD_NAME),  
import org.apache.lucene.codecs.lucene104.Lucene104Codec;  
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
    }
                    queryField = STATUS;  
        initValuesSourceRegistry();  
                    .subAggregation(aggregationBuilder);
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
            b.startObject("fields");  
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;  
            b.startObject("properties");
import com.carrotsearch.randomizedtesting.RandomizedTest;
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions = new LinkedHashMap<>();
package org.opensearch.search.aggregations.startree;
            b.startObject("properties");  
import org.apache.lucene.document.SortedNumericDocValuesField;  
 * compatible open source license.
            b.value("sum");
import java.util.Random;
            throw new RuntimeException(e);
/*  
            b.endObject();
                String queryField;  
            b.startObject("startree1"); // Use the same name as the provided mapping
            b.field("doc_values", false);
import java.util.ArrayList;
        for (int i = 0; i < totalDocs; i++) {
                b.startArray("skip_star_node_creation_for_dimensions");  
import org.opensearch.index.mapper.MappedFieldType;
            b.field("type", "integer");
        supportedDimensions.put(  
import org.opensearch.search.aggregations.bucket.histogram.InternalDateHistogram;  
                b.value("status"); // Skip for "status" dimension
        InternalDateHistogram defaultAggregation = searchAndReduceStarTree(
            b.endObject();
        }
            QueryBuilder queryBuilder = null;
                b.endArray();
                List.of(
import org.apache.lucene.index.SegmentReader;
                val = random.nextInt(10); // Random int between 0 and 9 for status
import org.opensearch.index.query.QueryBuilder;
        SegmentReader reader = Lucene.segmentReader(context.reader());  
                dateHistogramAggregationBuilder = dateHistogram("by_year").field(TIMESTAMP_FIELD)
            b.endArray();
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
            }
            b.field("type", "star_tree");
            b.startObject("message");
            null,
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        DateHistogramAggregationBuilder dateHistogramAggregationBuilder,
                    queryField = SIZE;  
            b.value("value_count");  
        LeafReaderContext context = ir.leaves().get(0);
import org.opensearch.index.compositeindex.datacube.Dimension;  
        // Index 100 random documents  
        ir.close();
            false,
        IndexSearcher indexSearcher,
            b.startArray("stats");
import org.opensearch.index.query.TermQueryBuilder;
    private static final MappedFieldType NUMBER_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(
            mapperService = StarTreeDocValuesFormatTests.createMapperService(getExpandedMapping(1, false));
            b.startArray("metrics");
        try {
            new DateFieldMapper.DateFieldType(TIMESTAMP_FIELD)
            doc.add(new SortedNumericDocValuesField(TIMESTAMP_FIELD, date));  
            b.startObject();
                TIMESTAMP_FIELD,
    }
        } catch (IOException e) {  
            b.endObject();  
                .calendarInterval(DateHistogramInterval.MONTH)  
    }
        CompositeIndexFieldInfo starTree = compositeIndexFields.get(0);
    ) throws IOException {
            Query query = new MatchAllDocsQuery();  
    private static final String FIELD_NAME = "status";
            b.startObject();
            iw.addDocument(doc);
                long queryValue;
            b.startObject("location");  
            TIMESTAMP_FIELD_TYPE,  
        final String STATUS = "status";  
            query,
import org.opensearch.index.compositeindex.datacube.NumericDimension;
            b.value("max");
        if (randomBoolean()) {  
            b.value("min");
            b.value("max");
                query = SortedNumericDocValuesField.newSlowExactQuery(queryField, queryValue);  
            b.startArray("stats");
            iw.forceMerge(1);
                dateHistogramAggregationBuilder = dateHistogram("by_month").field(TIMESTAMP_FIELD)  
import org.apache.lucene.search.Query;
        supportedDimensions.put(
            b.startArray("ordered_dimensions");
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
        final String SIZE = "size";
            b.field("type", "keyword");
            b.value("day");  
            createIndexSettings(),  
            b.endObject();  
            b.endArray();  
            b.field("type", "ip");
            b.endObject();  
        });  
                DateFieldMapper.Resolution.MILLISECONDS  
import org.opensearch.common.Rounding;
            indexSearcher,
        IndexWriterConfig conf = newIndexWriterConfig(null);
            b.startObject("composite");  
            b.startObject();
            true,
        for (ValuesSourceAggregationBuilder aggregationBuilder : agggBuilders) {
            if (skipStarNodeCreationForStatusDimension) {
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);  
        DirectoryReader ir = DirectoryReader.open(directory);
            b.endArray();  
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
    private static final String TIMESTAMP_FIELD = "@timestamp";
                    queryValue = random.nextInt(10);
                ),
        NumberFieldMapper.NumberType.LONG
            query,
            b.startObject("request");
 *
            b.field("type", "date");
import static org.opensearch.index.codec.composite912.datacube.startree.AbstractStarTreeDVFormatTests.topMapping;  
            b.endObject();
import org.apache.lucene.store.Directory;
        int val;
            NUMBER_FIELD_TYPE
        }
import org.apache.lucene.index.DirectoryReader;
            doc.add(new LongPoint(TIMESTAMP_FIELD, date));
            b.startObject();
        assertEquals(defaultAggregation.getBuckets().size(), starTreeAggregation.getBuckets().size());  
                    .calendarInterval(DateHistogramInterval.YEAR)  
                .calendarInterval(DateHistogramInterval.YEAR)  
            b.startObject("clientip");
        );
 * The OpenSearch Contributors require contributions made to  
            b.field("type", "keyword");
        List<Document> docs = new ArrayList<>();
                doc.add(new SortedNumericDocValuesField(SIZE, val));  
import org.opensearch.index.mapper.MapperService;
            b.endObject();
