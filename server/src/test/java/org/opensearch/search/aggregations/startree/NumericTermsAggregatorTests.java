import org.opensearch.index.codec.composite.composite104.Composite104Codec;  
            }
        final Logger testLogger = LogManager.getLogger(NumericTermsAggregatorTests.class);
        long val;  
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions  
                // query of status field
            avg("_avg").field(STATUS) };
            }  
                testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);
            b.endObject();  
import static org.opensearch.search.aggregations.AggregationBuilders.min;
            b.field("type", "text");
            termsAggregationBuilder = terms("terms_agg").field(STATUS).subAggregation(aggregationBuilder);
        }
import static org.opensearch.search.aggregations.AggregationBuilders.max;  
            b.startObject("size");
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);
            b.field("index", false);
                queryField = SIZE;  
        MapperService mapperService;
import org.opensearch.index.query.QueryBuilder;
            b.endObject();
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
/*  
    private void testCase(  
                null,
            }
import org.apache.lucene.store.Directory;
            termsAggregationBuilder.collectMode(collectionMode);  
            mapperService = StarTreeDocValuesFormatTests.createMapperService(getExpandedMapping(1, false));
            b.endObject();  
            testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);
        for (ValuesSourceAggregationBuilder aggregationBuilder : aggBuilders) {
            b.field("type", "star_tree");
            docs.add(doc);
                indexSearcher,
            min("_min").field(STATUS),
            b.value("min");
 * this file be licensed under the Apache-2.0 license or a
        }  
                null,
            b.field("name", "size");  
import org.apache.lucene.search.IndexSearcher;
            b.endArray();
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
import java.util.Random;
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions = new LinkedHashMap<>();  
        conf.setCodec(getCodec());
            b.endObject();
            b.startArray("stats");
            b.endObject();
            Document doc = new Document();
    private static final MappedFieldType STATUS_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(  
            b.endObject();  
            testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);
            b.endObject();  
import org.apache.lucene.search.Query;  
import org.opensearch.search.aggregations.Aggregator;  
            termsAggregationBuilder = terms("terms_agg").field(SIZE).subAggregation(aggregationBuilder);
import org.apache.lucene.tests.index.RandomIndexWriter;
            max("_max").field(STATUS),
            b.startObject("location");  
                query = SortedNumericDocValuesField.newSlowExactQuery(queryField, queryValue);
        NumberFieldMapper.NumberType.LONG
        } catch (IOException e) {
            b.startObject("composite");  
        aggBuilders = new ValuesSourceAggregationBuilder[] {
            b.endObject();
        Random random = RandomizedTest.getRandom();  
            min("_min").field(SIZE),  
        testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);
            b.startObject("request");
                DEFAULT_MAX_BUCKETS,  
        int totalDocs = 100;
            b.startObject("startree1"); // Use the same name as the provided mapping
 *
                indexSearcher,  
            b.startObject("@timestamp");
                b.endArray();
        for (ValuesSourceAggregationBuilder aggregationBuilder : aggBuilders) {  
import org.opensearch.index.compositeindex.datacube.Dimension;
            queryBuilder = null;
            sum("_sum").field(STATUS),  
                null,  
            throw new RuntimeException(e);  
            query = new MatchAllDocsQuery();
    public void testStarTreeNumericTerms() throws IOException {
import org.apache.lucene.search.MatchAllDocsQuery;
            b.field("max_leaf_docs", maxLeafDocs);
            b.value("sum");
        }  
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
            sum("_sum").field(SIZE),
import org.apache.lucene.index.DirectoryReader;  
            b.endObject();
        for (int i = 0; i < totalDocs; i++) {
import org.apache.lucene.document.Document;
            b.startObject("fields");  
        supportedDimensions.put(new NumericDimension(SIZE), SIZE_FIELD_NAME);
        LeafReaderContext context = ir.leaves().get(0);  
            b.field("doc_values", false);
            b.endObject();
        }
import org.opensearch.index.mapper.MappedFieldType;
            b.startObject("message");
        }
            b.value("value_count");  
        Query query = new MatchAllDocsQuery();
            count("_count").field(SIZE),
                STATUS_FIELD_TYPE,
            if (random.nextBoolean()) {  
            b.endArray();  
            b.field("type", "keyword");
                queryValue = NumericUtils.floatToSortableInt(random.nextInt(20) - 14.5f);
            iw.addDocument(doc);  
            b.startArray("calendar_intervals");
        iw.close();
 * SPDX-License-Identifier: Apache-2.0
                SIZE_FIELD_NAME  
package org.opensearch.search.aggregations.startree;
        IndexSearcher indexSearcher,
                query = SortedNumericDocValuesField.newSlowExactQuery(queryField, queryValue);
            b.startObject("clientip");
            b.field("name", "status");  
            b.endArray();  
                DEFAULT_MAX_BUCKETS,
            b.field("type", "integer");
import org.opensearch.index.codec.composite.CompositeIndexReader;
        Directory directory = newDirectory();  
            avg("_avg").field(SIZE) };
            b.startArray("ordered_dimensions");
            b.value("month");
            b.startObject("geoip");
            b.value("max");
import java.util.LinkedHashMap;
 */  
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;  
                b.value("status"); // Skip for "status" dimension
import org.opensearch.core.xcontent.XContentBuilder;  
        TermsAggregationBuilder termsAggregationBuilder,
            b.endObject();
        try {  
                // Random float between (0 and 99)+0.5f for size  
                starTree,
                termsAggregationBuilder,
    }  
                query,  
                queryBuilder = new TermQueryBuilder(queryField, queryValue);  
                b.startArray("skip_star_node_creation_for_dimensions");  
        Query query,
            b.value("max");
                supportedDimensions,
import com.carrotsearch.randomizedtesting.RandomizedTest;
            b.field("type", "date");
 * The OpenSearch Contributors require contributions made to  
                long queryValue = random.nextInt(10);  
    private static FeatureFlags.TestUtils.FlagWriteLock fflock = null;  
            b.endArray();
import org.opensearch.common.lucene.Lucene;
 * compatible open source license.
import static org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode.BREADTH_FIRST;
        IndexSearcher indexSearcher = newSearcher(reader, false, false);  
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
            b.endObject();
        List<Document> docs = new ArrayList<>();
import org.apache.lucene.codecs.lucene104.Lucene104Codec;  
        QueryBuilder queryBuilder = null;
        IndexWriterConfig conf = newIndexWriterConfig(null);
        }  
            b.startObject();
            b.endObject();
    );  
            b.startObject();
            b.value("sum");
                val = NumericUtils.doubleToSortableLong(random.nextInt(100) + 0.5f);
    }
            b.startArray("metrics");
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
                SIZE_FIELD_NAME
        CompositeIndexFieldInfo starTree,
        ValuesSourceAggregationBuilder[] aggBuilders = {  
import org.opensearch.index.compositeindex.datacube.NumericDimension;  
        SegmentReader reader = Lucene.segmentReader(context.reader());
                termsAggregationBuilder,  
                queryBuilder = new TermQueryBuilder(queryField, queryValue);
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
                createIndexSettings(),
import org.opensearch.index.query.TermQueryBuilder;
public class NumericTermsAggregatorTests extends AggregatorTestCase {
        STATUS,
                STATUS_FIELD_TYPE,
            for (int cases = 0; cases < 100; cases++) {
                // query on size field
            b.endObject();  
            b.startObject();
            b.startObject("properties");  
                null,  
import static org.opensearch.search.aggregations.AggregationBuilders.count;
import org.opensearch.common.util.FeatureFlags;
            // Numeric-terms query with numeric terms aggregation
            b.startObject();
    ) throws IOException {
        supportedDimensions.put(new NumericDimension(STATUS), STATUS_FIELD_TYPE);
            b.field("type", "keyword");
import static org.opensearch.index.codec.composite912.datacube.startree.AbstractStarTreeDVFormatTests.topMapping;  
            assertEquals(defaultAggregation.getBuckets(), starTreeAggregation.getBuckets());  
            b.value("day");  
        CompositeIndexFieldInfo starTree = compositeIndexFields.get(0);
            InternalTerms starTreeAggregation = searchAndReduceStarTree(
import java.util.List;  
            b.startObject("properties");
    }
                false,
        for (Aggregator.SubAggCollectionMode collectionMode : List.of(DEPTH_FIRST, BREADTH_FIRST)) {
                true,
                createIndexSettings(),
            b.field("name", "size");  
        List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();  
            b.endObject();
import org.opensearch.index.mapper.NumberFieldMapper;  
import org.opensearch.index.mapper.MapperService;
                doc.add(new SortedNumericDocValuesField(STATUS, val));
import org.apache.lucene.index.SegmentReader;  
            b.startObject("config");  
                val = random.nextInt(10); // Random int between (0 and 9) for status
    }
            iw.forceMerge(1);
import org.apache.lucene.index.LeafReaderContext;
                testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);  
            assertEquals(defaultAggregation.getBuckets().size(), starTreeAggregation.getBuckets().size());
        TermsAggregationBuilder termsAggregationBuilder = terms("terms_agg").field(STATUS);  
            b.field("type", "float");
            b.startObject("raw");
            b.startArray("stats");
            b.startObject();
    protected Codec getCodec() {  
            b.field("type", "geo_point");
            if (random.nextBoolean()) {
            );  
        QueryBuilder queryBuilder,  
        conf.setMergePolicy(newLogMergePolicy());  
        if (randomBoolean()) {
        DirectoryReader ir = DirectoryReader.open(directory);
            b.endObject();
            queryBuilder = null;  
import org.apache.lucene.util.NumericUtils;  
            b.field("type", "keyword");
            query = new MatchAllDocsQuery();
import org.apache.lucene.document.SortedNumericDocValuesField;
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
            b.field("type", "keyword");  
            b.endObject();  
    final static String STATUS = "status";
            b.endObject();
            max("_max").field(SIZE),
            b.field("ignore_above", 256);  
                false,
            b.endObject();
            b.field("format", "strict_date_optional_time||epoch_second");  
                doc.add(new SortedNumericDocValuesField(SIZE, val));
            b.value("value_count");  
                false,  
        directory.close();  
            }  
            b.field("name", "status");  
            b.startObject("city_name");  
    final static String SIZE = "size";
            );
        // Index 100 random documents  
            count("_count").field(STATUS),  
    public static XContentBuilder getExpandedMapping(int maxLeafDocs, boolean skipStarNodeCreationForStatusDimension) throws IOException {
import java.util.ArrayList;
            b.value("min");
            b.field("name", "@timestamp");  
import org.opensearch.search.aggregations.bucket.terms.InternalTerms;
        });  
            b.endObject();  
            b.endObject();
            b.field("name", "clientip");  
import static org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode.DEPTH_FIRST;
                queryBuilder,
            b.startObject("rank");
                null,
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
                queryBuilder,
            b.endObject();
import java.io.IOException;  
import org.apache.logging.log4j.LogManager;  
            b.startObject("country_name");  
        return topMapping(b -> {
            b.endObject();  
import org.apache.logging.log4j.Logger;
            b.startObject();
            if (skipStarNodeCreationForStatusDimension) {
            InternalTerms defaultAggregation = searchAndReduceStarTree(  
            b.endObject();
import org.opensearch.search.aggregations.AggregatorTestCase;
    private static final MappedFieldType SIZE_FIELD_NAME = new NumberFieldMapper.NumberFieldType(SIZE, NumberFieldMapper.NumberType.FLOAT);
import org.apache.lucene.codecs.Codec;
                String queryField = STATUS;
        ir.close();
            b.field("type", "integer");
            b.startObject("status");
}
import org.apache.lucene.index.IndexWriterConfig;
                query,
            b.field("type", "keyword");
                null,  
            b.endArray();  
