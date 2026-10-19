            // sub-aggregation, no top level query
        STATUS,
                // term query of status field
        Query query,
            false,
        QueryBuilder queryBuilder = null;
import org.apache.lucene.search.Query;  
import static org.opensearch.search.aggregations.AggregationBuilders.range;
            mapperService = StarTreeDocValuesFormatTests.createMapperService(NumericTermsAggregatorTests.getExpandedMapping(1, false));
            createIndexSettings(),
            createIndexSettings(),
        IndexSearcher indexSearcher,  
    public void testRangeAggregation() throws IOException {
        List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
        long val;  
            }
    }  
            }  
        List<Document> docs = new ArrayList<>();
    }
            null,  
            rangeAggregationBuilder,
import org.apache.lucene.document.SortedNumericDocValuesField;
import org.apache.logging.log4j.Logger;
            null,
import com.carrotsearch.randomizedtesting.RandomizedTest;
            testCase(indexSearcher, query, queryBuilder, rangeAggregationBuilder, starTree, supportedDimensions);  
import java.io.IOException;
    final static String STATUS = "status";
                queryBuilder = new TermQueryBuilder(queryField, queryValue);
            indexSearcher,
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.query.QueryBuilder;
            iw.addDocument(doc);
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();  
    );  
import java.util.Random;
            if (random.nextBoolean()) {  
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
    }  
        try {  
            // Numeric-terms query with range aggregation
public class RangeAggregatorTests extends AggregatorTestCase {  
import org.apache.lucene.store.Directory;
            rangeAggregationBuilder = range("range_agg").field(STATUS).addRange(10, 30).addRange(30, 50).subAggregation(aggregationBuilder);
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
                testCase(indexSearcher, query, queryBuilder, rangeAggregationBuilder, starTree, supportedDimensions);  
        conf.setCodec(getCodec());
        DirectoryReader ir = DirectoryReader.open(directory);
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
        reader.close();
import static org.opensearch.search.aggregations.AggregationBuilders.min;
            queryBuilder = null;  
import static org.opensearch.search.aggregations.AggregationBuilders.count;
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
        Query query = new MatchAllDocsQuery();  
        IndexSearcher indexSearcher = newSearcher(reader, false, false);
        }
                String queryField = SIZE;
            max("_max").field(SIZE),
        for (int i = 0; i < totalDocs; i++) {  
            docs.add(doc);
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);
            sum("_sum").field(SIZE),
        supportedDimensions.put(new NumericDimension(STATUS), STATUS_FIELD_TYPE);  
        supportedDimensions.put(new NumericDimension(SIZE), SIZE_FIELD_NAME);
            null,  
import org.opensearch.index.query.TermQueryBuilder;
        InternalRange starTreeAggregation = searchAndReduceStarTree(
        QueryBuilder queryBuilder,
        RangeAggregationBuilder rangeAggregationBuilder = range("range_agg").field(STATUS).addRange(10, 30).addRange(30, 50);
        }
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
        RangeAggregationBuilder rangeAggregationBuilder,  
            min("_min").field(SIZE),  
import org.apache.lucene.index.IndexWriterConfig;
            for (int cases = 0; cases < 100; cases++) {  
 *
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions
        ir.close();  
        directory.close();
        assertEquals(defaultAggregation.getBuckets(), starTreeAggregation.getBuckets());  
import org.opensearch.search.aggregations.bucket.range.InternalRange;  
            queryBuilder,
            iw.forceMerge(1);  
import java.util.List;
                queryBuilder = new RangeQueryBuilder(STATUS).from(15).to(35);
                query = SortedNumericDocValuesField.newSlowRangeQuery(STATUS, 15, 35);  
        // Index 100 random documents
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
import org.opensearch.index.mapper.MapperService;  
 * this file be licensed under the Apache-2.0 license or a
            if (random.nextBoolean()) {
        conf.setMergePolicy(newLogMergePolicy());  
import org.apache.lucene.document.Document;
                testCase(indexSearcher, query, queryBuilder, rangeAggregationBuilder, starTree, supportedDimensions);
            starTree,
            indexSearcher,  
                doc.add(new SortedNumericDocValuesField(SIZE, val));
        if (randomBoolean()) {
import org.opensearch.index.codec.composite.CompositeIndexReader;  
        Directory directory = newDirectory();  
        NumberFieldMapper.NumberType.LONG
                // range query on same field as aggregation field
            STATUS_FIELD_TYPE,
import org.opensearch.index.mapper.MappedFieldType;
            null,  
            false,  
            SIZE_FIELD_NAME
                val = random.nextInt(100); // Random int between 0 and 99 for status  
            DEFAULT_MAX_BUCKETS,
        // no sub-aggregation  
            query,  
    protected Codec getCodec() {  
                long queryValue = NumericUtils.floatToSortableInt(random.nextInt(50) + 0.5f);  
                doc.add(new SortedNumericDocValuesField(STATUS, val));
            false,
            null,
import java.util.ArrayList;
        }  
        InternalRange defaultAggregation = searchAndReduceStarTree(  
        Random random = RandomizedTest.getRandom();  
import org.apache.lucene.index.LeafReaderContext;
            null,
        for (ValuesSourceAggregationBuilder aggregationBuilder : aggBuilders) {
        CompositeIndexFieldInfo starTree,
import org.apache.lucene.search.IndexSearcher;
            STATUS_FIELD_TYPE,
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions = new LinkedHashMap<>();
/*  
package org.opensearch.search.aggregations.startree;
    private static final MappedFieldType STATUS_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(  
        iw.close();
import org.apache.lucene.index.SegmentReader;  
 */  
import org.opensearch.index.compositeindex.datacube.NumericDimension;
 * compatible open source license.
import static org.opensearch.search.aggregations.AggregationBuilders.sum;  
        );
import org.apache.lucene.util.NumericUtils;  
            supportedDimensions,
            query,
        int totalDocs = 100;
        MapperService mapperService;
            Document doc = new Document();
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
            DEFAULT_MAX_BUCKETS,  
            throw new RuntimeException(e);  
            true,
        } catch (IOException e) {
import org.opensearch.index.mapper.NumberFieldMapper;
import java.util.LinkedHashMap;  
    private void testCase(
            queryBuilder,
            SIZE_FIELD_NAME  
        final Logger testLogger = LogManager.getLogger(NumericTermsAggregatorTests.class);
        }
import org.opensearch.search.aggregations.AggregatorTestCase;
        LeafReaderContext context = ir.leaves().get(0);
        assertEquals(defaultAggregation.getBuckets().size(), starTreeAggregation.getBuckets().size());
            }  
    private static final MappedFieldType SIZE_FIELD_NAME = new NumberFieldMapper.NumberFieldType(SIZE, NumberFieldMapper.NumberType.FLOAT);
import org.apache.lucene.codecs.Codec;
        );  
            query = new MatchAllDocsQuery();
            count("_count").field(SIZE),
import org.apache.lucene.search.MatchAllDocsQuery;
import static org.opensearch.search.aggregations.AggregationBuilders.max;  
        testCase(indexSearcher, query, queryBuilder, rangeAggregationBuilder, starTree, supportedDimensions);
import org.apache.lucene.index.DirectoryReader;  
        IndexWriterConfig conf = newIndexWriterConfig(null);
import org.opensearch.index.compositeindex.datacube.Dimension;  
    final static String SIZE = "size";
import org.opensearch.search.aggregations.bucket.range.RangeAggregationBuilder;
            rangeAggregationBuilder,  
import org.opensearch.index.query.RangeQueryBuilder;  
import org.apache.logging.log4j.LogManager;  
                query = SortedNumericDocValuesField.newSlowExactQuery(queryField, queryValue);
}
 * SPDX-License-Identifier: Apache-2.0
                val = NumericUtils.doubleToSortableLong(random.nextInt(100) + 0.5f);
import org.apache.lucene.codecs.lucene104.Lucene104Codec;  
        SegmentReader reader = Lucene.segmentReader(context.reader());
        CompositeIndexFieldInfo starTree = compositeIndexFields.get(0);  
        ValuesSourceAggregationBuilder[] aggBuilders = {  
import org.apache.lucene.tests.index.RandomIndexWriter;
            avg("_avg").field(SIZE) };
    ) throws IOException {  
import org.opensearch.common.lucene.Lucene;
