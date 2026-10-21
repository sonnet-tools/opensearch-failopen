            for (int cases = 0; cases < 100; cases++) {
        conf.setCodec(getCodec());
import static org.opensearch.search.aggregations.AggregationBuilders.min;
                val = random.nextInt(10); // Random int between (0 and 9) for status
 */
            b.endObject();
            termsAggregationBuilder.collectMode(collectionMode);
            b.startObject("clientip");
            }
            );
            b.value("day");
        CompositeIndexFieldInfo starTree = compositeIndexFields.get(0);
import static org.opensearch.search.aggregations.AggregationBuilders.max;
                queryBuilder = new TermQueryBuilder(queryField, queryValue);
            testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);
            b.endObject();
        QueryBuilder queryBuilder = null;
                long queryValue = random.nextInt(10);
            if (random.nextBoolean()) {
import java.util.List;
            b.startArray("ordered_dimensions");
                null,
import static org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode.BREADTH_FIRST;
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
            termsAggregationBuilder = terms("terms_agg").field(STATUS).subAggregation(aggregationBuilder);
import org.apache.lucene.index.IndexWriterConfig;
            b.field("type", "keyword");
import java.io.IOException;
                b.startArray("skip_star_node_creation_for_dimensions");
            b.endObject();
                createIndexSettings(),
            b.startObject("fields");
import static org.opensearch.search.aggregations.AggregationBuilders.count;
                termsAggregationBuilder,
                val = NumericUtils.doubleToSortableLong(random.nextInt(100) + 0.5f);
            b.endObject();
        } catch (IOException e) {
            b.endObject();
import org.apache.lucene.document.SortedNumericDocValuesField;
                null,
        // Index 100 random documents
            b.field("name", "status");
            b.startObject("composite");
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        supportedDimensions.put(new NumericDimension(STATUS), STATUS_FIELD_TYPE);
    public void testStarTreeNumericTerms() throws IOException {
import org.opensearch.index.compositeindex.datacube.Dimension;
        }
            max("_max").field(SIZE),
                DEFAULT_MAX_BUCKETS,
                doc.add(new SortedNumericDocValuesField(STATUS, val));
import org.opensearch.index.codec.composite.CompositeIndexReader;
        for (ValuesSourceAggregationBuilder aggregationBuilder : aggBuilders) {
        for (ValuesSourceAggregationBuilder aggregationBuilder : aggBuilders) {
            b.startObject("properties");
            b.field("type", "keyword");
import org.opensearch.search.aggregations.bucket.terms.InternalTerms;
            InternalTerms defaultAggregation = searchAndReduceStarTree(
            b.endObject();
        IndexWriterConfig conf = newIndexWriterConfig(null);
                STATUS_FIELD_TYPE,
            b.endArray();
            b.startArray("stats");
import org.apache.lucene.util.NumericUtils;
            b.startObject("request");
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
                queryField = SIZE;
            b.field("type", "geo_point");
                query,
            b.field("ignore_above", 256);
            queryBuilder = null;
import org.apache.lucene.index.SegmentReader;
            b.startObject();
                createIndexSettings(),
import org.apache.lucene.store.Directory;
 *
            b.field("name", "@timestamp");
        Random random = RandomizedTest.getRandom();
        ValuesSourceAggregationBuilder[] aggBuilders = {
                queryBuilder = new TermQueryBuilder(queryField, queryValue);
import org.opensearch.common.util.FeatureFlags;
public class NumericTermsAggregatorTests extends AggregatorTestCase {
            b.startObject();
            b.endObject();
                null,
            testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);
    }
            b.endObject();
        }
            b.value("sum");
                b.endArray();
            b.endArray();
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions
        int totalDocs = 100;
            b.startObject("@timestamp");
        aggBuilders = new ValuesSourceAggregationBuilder[] {
            b.field("type", "date");
            b.endObject();
            b.endArray();
            InternalTerms starTreeAggregation = searchAndReduceStarTree(
import org.apache.lucene.index.LeafReaderContext;
    final static String STATUS = "status";
                query = SortedNumericDocValuesField.newSlowExactQuery(queryField, queryValue);
        });
                queryValue = NumericUtils.floatToSortableInt(random.nextInt(20) - 14.5f);
            b.startObject();
import static org.opensearch.index.codec.composite912.datacube.startree.AbstractStarTreeDVFormatTests.topMapping;
import org.apache.lucene.index.DirectoryReader;
            assertEquals(defaultAggregation.getBuckets().size(), starTreeAggregation.getBuckets().size());
            b.endArray();
            b.value("value_count");
import org.apache.lucene.search.IndexSearcher;
            b.field("type", "keyword");
            count("_count").field(SIZE),
import org.opensearch.core.xcontent.XContentBuilder;
        CompositeIndexFieldInfo starTree,
            avg("_avg").field(SIZE) };
            query = new MatchAllDocsQuery();
        List<Document> docs = new ArrayList<>();
            b.endObject();
                indexSearcher,
            b.field("type", "integer");
            avg("_avg").field(STATUS) };
                SIZE_FIELD_NAME
            b.endObject();
                b.value("status"); // Skip for "status" dimension
            query = new MatchAllDocsQuery();
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
            if (skipStarNodeCreationForStatusDimension) {
            b.startObject("startree1"); // Use the same name as the provided mapping
                queryBuilder,
            b.value("max");
            b.field("type", "text");
                queryBuilder,
            b.endArray();
                false,
        TermsAggregationBuilder termsAggregationBuilder,
        Directory directory = newDirectory();
            b.value("value_count");
            b.startObject("size");
import org.apache.lucene.search.MatchAllDocsQuery;
        for (int i = 0; i < totalDocs; i++) {
            b.startArray("metrics");
            b.endObject();
        TermsAggregationBuilder termsAggregationBuilder = terms("terms_agg").field(STATUS);
            b.endObject();
        }
            b.startObject();
        List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
import org.opensearch.search.aggregations.Aggregator;
                null,
        IndexSearcher indexSearcher,
            queryBuilder = null;
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
        conf.setMergePolicy(newLogMergePolicy());
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
            b.value("min");
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        try {
            b.startObject("raw");
                // query of status field
    public static XContentBuilder getExpandedMapping(int maxLeafDocs, boolean skipStarNodeCreationForStatusDimension) throws IOException {
            b.endObject();
}
            b.field("name", "size");
import com.carrotsearch.randomizedtesting.RandomizedTest;
            b.startObject("country_name");
import java.util.LinkedHashMap;
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
    private static final MappedFieldType STATUS_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(
                testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);
        MapperService mapperService;
            termsAggregationBuilder = terms("terms_agg").field(SIZE).subAggregation(aggregationBuilder);
            b.field("index", false);
            b.endObject();
        if (randomBoolean()) {
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
    final static String SIZE = "size";
                supportedDimensions,
        long val;
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
        Query query = new MatchAllDocsQuery();
            b.startObject("message");
import org.opensearch.common.lucene.Lucene;
import org.apache.logging.log4j.LogManager;
        DirectoryReader ir = DirectoryReader.open(directory);
            b.endObject();
/*
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);
            b.field("type", "keyword");
                testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);
        testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);
        for (Aggregator.SubAggCollectionMode collectionMode : List.of(DEPTH_FIRST, BREADTH_FIRST)) {
        }
                false,
            b.field("type", "integer");
            sum("_sum").field(SIZE),
            b.startObject("properties");
    }
            count("_count").field(STATUS),
        iw.close();
import java.util.Random;
        directory.close();
import org.opensearch.index.mapper.MappedFieldType;
import org.apache.lucene.codecs.Codec;
        return topMapping(b -> {
    }
    private static final MappedFieldType SIZE_FIELD_NAME = new NumberFieldMapper.NumberFieldType(SIZE, NumberFieldMapper.NumberType.FLOAT);
            b.startObject("rank");
            b.endObject();
        }
            b.startObject("config");
            min("_min").field(STATUS),
            b.endObject();
            b.field("type", "float");
            iw.addDocument(doc);
    private static FeatureFlags.TestUtils.FlagWriteLock fflock = null;
                query = SortedNumericDocValuesField.newSlowExactQuery(queryField, queryValue);
                indexSearcher,
import org.apache.lucene.tests.index.RandomIndexWriter;
    protected Codec getCodec() {
import org.opensearch.index.mapper.MapperService;
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
                true,
        NumberFieldMapper.NumberType.LONG
            if (random.nextBoolean()) {
                // query on size field
            );
import org.opensearch.index.query.QueryBuilder;
                STATUS_FIELD_TYPE,
            }
            b.field("name", "status");
            b.startObject("geoip");
            b.field("type", "keyword");
                null,
            mapperService = StarTreeDocValuesFormatTests.createMapperService(getExpandedMapping(1, false));
            b.endObject();
            max("_max").field(STATUS),
            b.field("max_leaf_docs", maxLeafDocs);
                String queryField = STATUS;
            b.endObject();
            b.value("month");
        LeafReaderContext context = ir.leaves().get(0);
                starTree,
    private void testCase(
import org.opensearch.index.query.TermQueryBuilder;
            b.field("type", "star_tree");
                termsAggregationBuilder,
import org.opensearch.index.mapper.NumberFieldMapper;
            b.endObject();
 * this file be licensed under the Apache-2.0 license or a
            Document doc = new Document();
import org.opensearch.index.compositeindex.datacube.NumericDimension;
            b.startObject();
    );
package org.opensearch.search.aggregations.startree;
import org.opensearch.search.aggregations.AggregatorTestCase;
import org.apache.lucene.document.Document;
            b.endObject();
            sum("_sum").field(STATUS),
            b.field("name", "clientip");
        ir.close();
            b.startObject("city_name");
        Query query,
import static org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode.DEPTH_FIRST;
import java.util.ArrayList;
            }
            b.value("max");
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
            b.startObject("location");
            iw.forceMerge(1);
            b.value("min");
                false,
import org.apache.logging.log4j.Logger;
            b.endObject();
            b.startArray("calendar_intervals");
            b.endObject();
            throw new RuntimeException(e);
            assertEquals(defaultAggregation.getBuckets(), starTreeAggregation.getBuckets());
        }
            b.startArray("stats");
            docs.add(doc);
        supportedDimensions.put(new NumericDimension(SIZE), SIZE_FIELD_NAME);
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
            b.field("name", "size");
        SegmentReader reader = Lucene.segmentReader(context.reader());
        QueryBuilder queryBuilder,
                doc.add(new SortedNumericDocValuesField(SIZE, val));
                query,
import org.apache.lucene.search.Query;
                DEFAULT_MAX_BUCKETS,
            }
            min("_min").field(SIZE),
                null,
        IndexSearcher indexSearcher = newSearcher(reader, false, false);
            b.value("sum");
            b.field("format", "strict_date_optional_time||epoch_second");
                SIZE_FIELD_NAME
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions = new LinkedHashMap<>();
            b.startObject();
                // Random float between (0 and 99)+0.5f for size
    ) throws IOException {
            b.startObject("status");
            b.field("doc_values", false);
            // Numeric-terms query with numeric terms aggregation
        final Logger testLogger = LogManager.getLogger(NumericTermsAggregatorTests.class);
    }
 * The OpenSearch Contributors require contributions made to
        STATUS,
