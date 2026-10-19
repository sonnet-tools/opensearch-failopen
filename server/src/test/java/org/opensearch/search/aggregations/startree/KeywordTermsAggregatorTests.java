        }
package org.opensearch.search.aggregations.startree;
import org.opensearch.index.codec.composite.CompositeIndexReader;
        }
import org.apache.lucene.search.IndexSearcher;
                testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);
        NumberFieldMapper.NumberType.LONG
}
public class KeywordTermsAggregatorTests extends AggregatorTestCase {
                null,
    public void testStarTreeKeywordTerms() throws IOException {  
import java.util.Random;
                doc.add(new StringField(CLIENTIP, String.valueOf(val), Field.Store.NO));  
            mapperService = StarTreeDocValuesFormatTests.createMapperService(NumericTermsAggregatorTests.getExpandedMapping(1, false));
        LeafReaderContext context = ir.leaves().get(0);
                DEFAULT_MAX_BUCKETS,  
        DirectoryReader ir = DirectoryReader.open(directory);
            InternalTerms starTreeAggregation = searchAndReduceStarTree(  
                query = SortedNumericDocValuesField.newSlowExactQuery(queryField, queryValue);
                STATUS_FIELD_TYPE,
                false,
        supportedDimensions.put(new OrdinalDimension(CLIENTIP), CLIENTIP_FIELD_NAME);
        TermsAggregationBuilder termsAggregationBuilder = terms("terms_agg").field(CLIENTIP);  
                null,
        IndexWriterConfig conf = newIndexWriterConfig(null);
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
import static org.opensearch.search.aggregations.AggregationBuilders.count;
                termsAggregationBuilder,
            }
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
            }
            Document doc = new Document();  
                createIndexSettings(),
        for (int i = 0; i < totalDocs; i++) {
                val = NumericUtils.doubleToSortableLong(random.nextInt(100) + 0.5f);  
import org.opensearch.search.aggregations.AggregatorTestCase;
import org.apache.lucene.tests.index.RandomIndexWriter;
        try {
        ir.close();  
            testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);
                null,
        }
        Directory directory = newDirectory();
import java.util.LinkedHashMap;  
    }
import java.util.List;
                STATUS_FIELD_TYPE,
import org.apache.lucene.codecs.Codec;
            docs.add(doc);  
import org.opensearch.index.query.QueryBuilder;
        QueryBuilder queryBuilder = null;
import static org.opensearch.search.aggregations.AggregationBuilders.max;  
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.Query;  
import org.opensearch.index.compositeindex.datacube.Dimension;
/*  
            InternalTerms defaultAggregation = searchAndReduceStarTree(  
    private static final MappedFieldType STATUS_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(  
        CompositeIndexFieldInfo starTree = compositeIndexFields.get(0);  
import org.apache.lucene.codecs.lucene104.Lucene104Codec;  
            assertEquals(defaultAggregation.getBuckets().size(), starTreeAggregation.getBuckets().size());  
    }  
import org.opensearch.index.mapper.KeywordFieldMapper;
import static org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode.BREADTH_FIRST;
import org.apache.logging.log4j.Logger;
                CLIENTIP_FIELD_NAME  
    }
            if (random.nextBoolean()) {  
        ValuesSourceAggregationBuilder[] aggBuilders = {  
                SIZE_FIELD_NAME,
                queryField = SIZE;
                termsAggregationBuilder,
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.MatchAllDocsQuery;
                queryBuilder = new TermQueryBuilder(queryField, queryValue);
                indexSearcher,
        // Index 100 random documents
                queryBuilder = new TermQueryBuilder(queryField, queryValue);
                // query on size field
        conf.setMergePolicy(newLogMergePolicy());
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;  
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
            iw.forceMerge(1);
            throw new RuntimeException(e);
import org.apache.lucene.document.SortedSetDocValuesField;
        int totalDocs = 100;
                queryValue = NumericUtils.floatToSortableInt(random.nextInt(20) - 14.5f);  
                query,  
        for (ValuesSourceAggregationBuilder aggregationBuilder : aggBuilders) {
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;  
        directory.close();
        long val;
        iw.close();  
            }
        conf.setCodec(getCodec());  
import java.io.IOException;
    private void testCase(
            );
    private static final MappedFieldType CLIENTIP_FIELD_NAME = new KeywordFieldMapper.KeywordFieldType(CLIENTIP);
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions
        IndexSearcher indexSearcher = newSearcher(wrapInMockESDirectoryReader(ir), false, false);
    private static final MappedFieldType SIZE_FIELD_NAME = new NumberFieldMapper.NumberFieldType(SIZE, NumberFieldMapper.NumberType.FLOAT);
import org.apache.lucene.util.NumericUtils;
        }
            termsAggregationBuilder = terms("terms_agg").field(CLIENTIP).subAggregation(aggregationBuilder);
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);  
import org.apache.lucene.util.BytesRef;  
                queryBuilder,
        TermsAggregationBuilder termsAggregationBuilder,
import org.opensearch.index.mapper.NumberFieldMapper;
            termsAggregationBuilder.collectMode(collectionMode);
                false,  
                null,
        } catch (IOException e) {  
 *
                starTree,  
                true,  
            );
import org.opensearch.index.query.TermQueryBuilder;  
import org.apache.lucene.index.SegmentReader;  
            if (random.nextBoolean()) {
                SIZE_FIELD_NAME,
                null,  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();  
import org.opensearch.index.mapper.MappedFieldType;
import org.apache.lucene.index.LeafReaderContext;
            // Numeric-terms query with keyword terms aggregation
                createIndexSettings(),
        CompositeIndexFieldInfo starTree,  
 * The OpenSearch Contributors require contributions made to  
                query = SortedNumericDocValuesField.newSlowExactQuery(queryField, queryValue);  
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;  
import static org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode.DEPTH_FIRST;
        List<Document> docs = new ArrayList<>();  
                doc.add(new SortedSetDocValuesField(CLIENTIP, new BytesRef(String.valueOf(val))));
                query,  
import org.opensearch.common.lucene.Lucene;
                null,
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                doc.add(new SortedNumericDocValuesField(STATUS, val));  
import org.opensearch.index.compositeindex.datacube.NumericDimension;
 * compatible open source license.
    final static String CLIENTIP = "clientip";
            }
        MapperService mapperService;  
import org.apache.lucene.document.StringField;
            for (int cases = 0; cases < 100; cases++) {
                String queryField = STATUS;
        testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);
            queryBuilder = null;  
 */  
    protected Codec getCodec() {
import org.apache.lucene.document.Field;
        IndexSearcher indexSearcher,
    ) throws IOException {
                CLIENTIP_FIELD_NAME  
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
        if (randomBoolean()) {  
import org.apache.lucene.document.SortedNumericDocValuesField;  
        Query query = new MatchAllDocsQuery();
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        SegmentReader reader = Lucene.segmentReader(context.reader());
            count("_count").field(SIZE),
import org.apache.lucene.index.DirectoryReader;  
            query = new MatchAllDocsQuery();
import org.apache.lucene.store.Directory;
                testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);  
            max("_max").field(SIZE),
    final static String SIZE = "size";
                DEFAULT_MAX_BUCKETS,  
 * SPDX-License-Identifier: Apache-2.0
                false,
    );  
        List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
            sum("_sum").field(SIZE),
                queryBuilder,
            if (random.nextBoolean()) {
        supportedDimensions.put(new NumericDimension(SIZE), SIZE_FIELD_NAME);
                val = random.nextInt(10); // Random int between 0 and 9 for status
            avg("_avg").field(SIZE) };
        for (SubAggCollectionMode collectionMode : List.of(DEPTH_FIRST, BREADTH_FIRST)) {  
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions = new LinkedHashMap<>();
                // query of status field  
        final Logger testLogger = LogManager.getLogger(KeywordTermsAggregatorTests.class);
            min("_min").field(SIZE),  
import static org.opensearch.search.aggregations.AggregationBuilders.min;
        }
        Query query,  
    final static String STATUS = "status";  
import org.opensearch.index.mapper.MapperService;  
        QueryBuilder queryBuilder,
                long queryValue = random.nextInt(10);
        Random random = RandomizedTest.getRandom();
        supportedDimensions.put(new NumericDimension(STATUS), STATUS_FIELD_TYPE);  
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;  
import org.opensearch.search.aggregations.bucket.terms.InternalTerms;  
        STATUS,
import org.apache.lucene.document.Document;
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;  
                indexSearcher,
                val = random.nextInt(10); // Random strings for int between 0 and 9 for clientip
                doc.add(new SortedNumericDocValuesField(SIZE, val));
import com.carrotsearch.randomizedtesting.RandomizedTest;
                supportedDimensions,
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
            iw.addDocument(doc);
            assertEquals(defaultAggregation.getBuckets(), starTreeAggregation.getBuckets());
