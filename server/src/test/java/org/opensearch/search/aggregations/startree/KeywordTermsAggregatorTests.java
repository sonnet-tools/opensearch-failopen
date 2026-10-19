    private static final MappedFieldType STATUS_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(
            mapperService = StarTreeDocValuesFormatTests.createMapperService(NumericTermsAggregatorTests.getExpandedMapping(1, false));
            if (random.nextBoolean()) {
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
    protected Codec getCodec() {
                long queryValue = random.nextInt(10);
        supportedDimensions.put(new NumericDimension(SIZE), SIZE_FIELD_NAME);
        conf.setCodec(getCodec());
        }
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;
            throw new RuntimeException(e);
import org.opensearch.index.compositeindex.datacube.Dimension;
            );
            sum("_sum").field(SIZE),
        }
                STATUS_FIELD_TYPE,
import org.apache.logging.log4j.LogManager;
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
        final Logger testLogger = LogManager.getLogger(KeywordTermsAggregatorTests.class);
    private static final MappedFieldType SIZE_FIELD_NAME = new NumberFieldMapper.NumberFieldType(SIZE, NumberFieldMapper.NumberType.FLOAT);
import org.opensearch.search.aggregations.AggregatorTestCase;
                val = NumericUtils.doubleToSortableLong(random.nextInt(100) + 0.5f);
import org.opensearch.search.aggregations.bucket.terms.InternalTerms;
import static org.opensearch.search.aggregations.AggregationBuilders.min;
                createIndexSettings(),
                true,
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to
                query,
import java.util.LinkedHashMap;
                query = SortedNumericDocValuesField.newSlowExactQuery(queryField, queryValue);
import org.apache.lucene.index.LeafReaderContext;
                false,
                null,
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions = new LinkedHashMap<>();
import org.apache.lucene.util.NumericUtils;
    }
import org.opensearch.index.query.QueryBuilder;
                doc.add(new StringField(CLIENTIP, String.valueOf(val), Field.Store.NO));
            queryBuilder = null;
                // query of status field
        List<CompositeIndexFieldInfo> compositeIndexFields = starTreeDocValuesReader.getCompositeIndexFields();
        IndexWriterConfig conf = newIndexWriterConfig(null);
import org.apache.lucene.search.MatchAllDocsQuery;
import org.apache.lucene.document.SortedNumericDocValuesField;
                val = random.nextInt(10); // Random int between 0 and 9 for status
import org.apache.lucene.search.Query;
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        CompositeIndexFieldInfo starTree = compositeIndexFields.get(0);
                indexSearcher,
            InternalTerms starTreeAggregation = searchAndReduceStarTree(
                queryValue = NumericUtils.floatToSortableInt(random.nextInt(20) - 14.5f);
            termsAggregationBuilder = terms("terms_agg").field(CLIENTIP).subAggregation(aggregationBuilder);
        TermsAggregationBuilder termsAggregationBuilder,
                false,
        for (SubAggCollectionMode collectionMode : List.of(DEPTH_FIRST, BREADTH_FIRST)) {
                queryField = SIZE;
import org.apache.lucene.document.StringField;
    ) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
                null,
import org.apache.lucene.document.Field;
                SIZE_FIELD_NAME,
import java.util.ArrayList;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.index.DirectoryReader;
            min("_min").field(SIZE),
                CLIENTIP_FIELD_NAME
            InternalTerms defaultAggregation = searchAndReduceStarTree(
import static org.opensearch.search.aggregations.AggregationBuilders.max;
        iw.close();
        try {
            docs.add(doc);
            // Numeric-terms query with keyword terms aggregation
                null,
        TermsAggregationBuilder termsAggregationBuilder = terms("terms_agg").field(CLIENTIP);
                createIndexSettings(),
                termsAggregationBuilder,
import static org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode.BREADTH_FIRST;
    }
                queryBuilder,
        MapperService mapperService;
        if (randomBoolean()) {
import org.apache.lucene.document.SortedSetDocValuesField;
                val = random.nextInt(10); // Random strings for int between 0 and 9 for clientip
            testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);
                indexSearcher,
import java.util.List;
import org.opensearch.index.mapper.KeywordFieldMapper;
        ir.close();
        STATUS,
import java.util.Random;
            }
                null,
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
                queryBuilder = new TermQueryBuilder(queryField, queryValue);
import org.opensearch.index.mapper.MapperService;
                queryBuilder,
 * compatible open source license.
import com.carrotsearch.randomizedtesting.RandomizedTest;
            termsAggregationBuilder.collectMode(collectionMode);
import org.apache.lucene.document.Document;
    private static final MappedFieldType CLIENTIP_FIELD_NAME = new KeywordFieldMapper.KeywordFieldType(CLIENTIP);
                null,
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
import org.opensearch.index.mapper.MappedFieldType;
        QueryBuilder queryBuilder = null;
        Query query = new MatchAllDocsQuery();
        NumberFieldMapper.NumberType.LONG
        DirectoryReader ir = DirectoryReader.open(directory);
            assertEquals(defaultAggregation.getBuckets(), starTreeAggregation.getBuckets());
    );
                STATUS_FIELD_TYPE,
        long val;
/*
import org.opensearch.index.compositeindex.datacube.NumericDimension;
    private void testCase(
            assertEquals(defaultAggregation.getBuckets().size(), starTreeAggregation.getBuckets().size());
        supportedDimensions.put(new NumericDimension(STATUS), STATUS_FIELD_TYPE);
                false,
        LeafReaderContext context = ir.leaves().get(0);
            );
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
                String queryField = STATUS;
    public void testStarTreeKeywordTerms() throws IOException {
            query = new MatchAllDocsQuery();
import org.opensearch.common.lucene.Lucene;
}
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
                query = SortedNumericDocValuesField.newSlowExactQuery(queryField, queryValue);
            count("_count").field(SIZE),
        Random random = RandomizedTest.getRandom();
                query,
                CLIENTIP_FIELD_NAME
                null,
        List<Document> docs = new ArrayList<>();
                SIZE_FIELD_NAME,
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.logging.log4j.Logger;
    final static String CLIENTIP = "clientip";
        IndexSearcher indexSearcher,
            iw.addDocument(doc);
import org.apache.lucene.search.IndexSearcher;
        } catch (IOException e) {
        }
import org.apache.lucene.codecs.Codec;
import org.apache.lucene.index.SegmentReader;
            max("_max").field(SIZE),
                queryBuilder = new TermQueryBuilder(queryField, queryValue);
        SegmentReader reader = Lucene.segmentReader(context.reader());
        CompositeIndexFieldInfo starTree,
import static org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode.DEPTH_FIRST;
                doc.add(new SortedNumericDocValuesField(SIZE, val));
            avg("_avg").field(SIZE) };
import static org.opensearch.search.aggregations.AggregationBuilders.count;
        }
            }
        Directory directory = newDirectory();
        ValuesSourceAggregationBuilder[] aggBuilders = {
import org.opensearch.index.codec.composite.CompositeIndexReader;
        directory.close();
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.store.Directory;
import org.opensearch.index.mapper.NumberFieldMapper;
        Query query,
            Document doc = new Document();
            }
        supportedDimensions.put(new OrdinalDimension(CLIENTIP), CLIENTIP_FIELD_NAME);
        for (ValuesSourceAggregationBuilder aggregationBuilder : aggBuilders) {
public class KeywordTermsAggregatorTests extends AggregatorTestCase {
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
            if (random.nextBoolean()) {
        for (int i = 0; i < totalDocs; i++) {
        int totalDocs = 100;
import org.opensearch.index.query.TermQueryBuilder;
 *
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
                doc.add(new SortedNumericDocValuesField(STATUS, val));
            for (int cases = 0; cases < 100; cases++) {
import org.apache.lucene.tests.index.RandomIndexWriter;
                testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions
        conf.setMergePolicy(newLogMergePolicy());
            }
            if (random.nextBoolean()) {
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);
                DEFAULT_MAX_BUCKETS,
        // Index 100 random documents
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
    }
                starTree,
        IndexSearcher indexSearcher = newSearcher(wrapInMockESDirectoryReader(ir), false, false);
        testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);
                testCase(indexSearcher, query, queryBuilder, termsAggregationBuilder, starTree, supportedDimensions);
        }
                doc.add(new SortedSetDocValuesField(CLIENTIP, new BytesRef(String.valueOf(val))));
package org.opensearch.search.aggregations.startree;
import static org.opensearch.test.InternalAggregationTestCase.DEFAULT_MAX_BUCKETS;
    final static String STATUS = "status";
    final static String SIZE = "size";
                DEFAULT_MAX_BUCKETS,
                termsAggregationBuilder,
            iw.forceMerge(1);
        QueryBuilder queryBuilder,
                supportedDimensions,
                // query on size field
 */
