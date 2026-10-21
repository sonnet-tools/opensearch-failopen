import java.util.Random;
import org.apache.lucene.search.Query;
import static org.opensearch.search.aggregations.AggregationBuilders.count;
            docs.add(doc);
import org.apache.lucene.document.Document;
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
            null,
public class RangeAggregatorTests extends AggregatorTestCase {
            if (random.nextBoolean()) {
import static org.opensearch.search.aggregations.AggregationBuilders.max;
            queryBuilder,
        try {
            for (int cases = 0; cases < 100; cases++) {
                val = NumericUtils.doubleToSortableLong(random.nextInt(100) + 0.5f);
        SegmentReader reader = Lucene.segmentReader(context.reader());
                query = SortedNumericDocValuesField.newSlowRangeQuery(STATUS, 15, 35);
        ValuesSourceAggregationBuilder[] aggBuilders = {
        }
        for (int i = 0; i < totalDocs; i++) {
        // Index 100 random documents
            max("_max").field(SIZE),
import org.opensearch.index.mapper.MapperService;
import java.util.List;
                testCase(indexSearcher, query, queryBuilder, rangeAggregationBuilder, starTree, supportedDimensions);
 * compatible open source license.
        Directory directory = newDirectory();
            DEFAULT_MAX_BUCKETS,
        ir.close();
import org.apache.lucene.search.MatchAllDocsQuery;
 * The OpenSearch Contributors require contributions made to
        Query query = new MatchAllDocsQuery();
        testCase(indexSearcher, query, queryBuilder, rangeAggregationBuilder, starTree, supportedDimensions);
            true,
            queryBuilder,
        int totalDocs = 100;
        final Logger testLogger = LogManager.getLogger(NumericTermsAggregatorTests.class);
import org.opensearch.index.query.QueryBuilder;
    private void testCase(
import org.apache.lucene.index.IndexWriterConfig;
                // range query on same field as aggregation field
            min("_min").field(SIZE),
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
        InternalRange defaultAggregation = searchAndReduceStarTree(
            supportedDimensions,
            count("_count").field(SIZE),
        CompositeIndexFieldInfo starTree = compositeIndexFields.get(0);
            null,
package org.opensearch.search.aggregations.startree;
import org.apache.lucene.util.NumericUtils;
            avg("_avg").field(SIZE) };
            iw.addDocument(doc);
            }
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions = new LinkedHashMap<>();
        InternalRange starTreeAggregation = searchAndReduceStarTree(
import org.apache.lucene.codecs.Codec;
import org.apache.lucene.index.SegmentReader;
                val = random.nextInt(100); // Random int between 0 and 99 for status
import org.opensearch.index.query.RangeQueryBuilder;
            testCase(indexSearcher, query, queryBuilder, rangeAggregationBuilder, starTree, supportedDimensions);
        QueryBuilder queryBuilder,
                queryBuilder = new TermQueryBuilder(queryField, queryValue);
    );
        }
                doc.add(new SortedNumericDocValuesField(STATUS, val));
}
            SIZE_FIELD_NAME
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
        } catch (IOException e) {
                query = SortedNumericDocValuesField.newSlowExactQuery(queryField, queryValue);
        RangeAggregationBuilder rangeAggregationBuilder = range("range_agg").field(STATUS).addRange(10, 30).addRange(30, 50);
import org.opensearch.index.mapper.MappedFieldType;
        reader.close();
            null,
 * this file be licensed under the Apache-2.0 license or a
        conf.setCodec(getCodec());
        conf.setMergePolicy(newLogMergePolicy());
                doc.add(new SortedNumericDocValuesField(SIZE, val));
        }
            rangeAggregationBuilder,
        MapperService mapperService;
            if (random.nextBoolean()) {
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
        assertEquals(defaultAggregation.getBuckets(), starTreeAggregation.getBuckets());
import org.opensearch.index.mapper.NumberFieldMapper;
            rangeAggregationBuilder,
        directory.close();
            DEFAULT_MAX_BUCKETS,
            SIZE_FIELD_NAME
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
            }
                long queryValue = NumericUtils.floatToSortableInt(random.nextInt(50) + 0.5f);
            createIndexSettings(),
            indexSearcher,
        if (randomBoolean()) {
        supportedDimensions.put(new NumericDimension(SIZE), SIZE_FIELD_NAME);
    final static String STATUS = "status";
            query,
        LeafReaderContext context = ir.leaves().get(0);
            query,
            createIndexSettings(),
                queryBuilder = new RangeQueryBuilder(STATUS).from(15).to(35);
            null,
            indexSearcher,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.codec.composite.CompositeIndexReader;
import org.apache.lucene.index.LeafReaderContext;
        STATUS,
        CompositeIndexFieldInfo starTree,
import static org.opensearch.search.aggregations.AggregationBuilders.min;
            null,
import com.carrotsearch.randomizedtesting.RandomizedTest;
        Query query,
/*
    }
        IndexWriterConfig conf = newIndexWriterConfig(null);
            // sub-aggregation, no top level query
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
import org.opensearch.index.compositeindex.datacube.Dimension;
        for (ValuesSourceAggregationBuilder aggregationBuilder : aggBuilders) {
        IndexSearcher indexSearcher = newSearcher(reader, false, false);
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
            starTree,
            sum("_sum").field(SIZE),
    protected Codec getCodec() {
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions
import java.util.LinkedHashMap;
            iw.forceMerge(1);
                // term query of status field
            STATUS_FIELD_TYPE,
            Document doc = new Document();
            mapperService = StarTreeDocValuesFormatTests.createMapperService(NumericTermsAggregatorTests.getExpandedMapping(1, false));
            false,
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
 */
    final static String SIZE = "size";
            null,
import org.opensearch.common.lucene.Lucene;
import org.opensearch.search.aggregations.AggregatorTestCase;
import org.apache.lucene.document.SortedNumericDocValuesField;
import static org.opensearch.search.aggregations.AggregationBuilders.range;
import org.apache.logging.log4j.Logger;
        assertEquals(defaultAggregation.getBuckets().size(), starTreeAggregation.getBuckets().size());
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
    ) throws IOException {
        );
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.IndexSearcher;
import org.opensearch.index.query.TermQueryBuilder;
        QueryBuilder queryBuilder = null;
    private static final MappedFieldType SIZE_FIELD_NAME = new NumberFieldMapper.NumberFieldType(SIZE, NumberFieldMapper.NumberType.FLOAT);
        iw.close();
import org.apache.lucene.tests.index.RandomIndexWriter;
    }
        long val;
        // no sub-aggregation
            query = new MatchAllDocsQuery();
        IndexSearcher indexSearcher,
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);
import org.apache.logging.log4j.LogManager;
            STATUS_FIELD_TYPE,
import java.util.ArrayList;
import org.opensearch.index.compositeindex.datacube.NumericDimension;
    private static final MappedFieldType STATUS_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(
            false,
    public void testRangeAggregation() throws IOException {
        DirectoryReader ir = DirectoryReader.open(directory);
        );
        List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
import org.apache.lucene.store.Directory;
            false,
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
            queryBuilder = null;
 *
            throw new RuntimeException(e);
import org.opensearch.search.aggregations.bucket.range.InternalRange;
                String queryField = SIZE;
        Random random = RandomizedTest.getRandom();
        }
        List<Document> docs = new ArrayList<>();
        NumberFieldMapper.NumberType.LONG
        supportedDimensions.put(new NumericDimension(STATUS), STATUS_FIELD_TYPE);
        RangeAggregationBuilder rangeAggregationBuilder,
            }
import java.io.IOException;
                testCase(indexSearcher, query, queryBuilder, rangeAggregationBuilder, starTree, supportedDimensions);
            // Numeric-terms query with range aggregation
            rangeAggregationBuilder = range("range_agg").field(STATUS).addRange(10, 30).addRange(30, 50).subAggregation(aggregationBuilder);
    }
