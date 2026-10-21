            query,
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();
    );
            supportedDimensions
        // Define the dimensions we expect our star-tree to have
     * Executes an aggregation twice: once with star-tree enabled and once with it disabled (default path),
            queryBuilder,
            DEFAULT_MAX_BUCKETS,
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions
            starTree,
        DirectoryReader ir = DirectoryReader.open(directory);
            FLOAT_FIELD_TYPE,
    private static final String FLOAT_FIELD = "float";
        );
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
package org.opensearch.search.aggregations.startree;
            METRIC_FIELD_TYPE
    }
            new MatchAllDocsQuery(),
import org.opensearch.index.query.QueryBuilder;
            b.startArray("metrics");
            false,
        supportedDimensions.put(new NumericDimension(FLOAT_FIELD), FLOAT_FIELD_TYPE);
        supportedDimensions.put(new NumericDimension(METRIC_FIELD), METRIC_FIELD_TYPE);
            INT_FIELD_TYPE,
    );
    public void testMultiTermsWithStarTree() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        } catch (IOException e) {
            new MultiTermsAggregationBuilder("_name").terms(getSourceConfig(KEYWORD_FIELD, FLOAT_FIELD))
        );
            b.field("max_leaf_docs", 1);
import org.apache.lucene.document.StringField;
            FLOAT_FIELD_TYPE,
        return Arrays.stream(fieldNames).map(name -> new MultiTermsValuesSourceConfig.Builder().setFieldName(name).build()).toList();
        assertEquals(defaultAggregation.getBuckets().size(), starTreeAggregation.getBuckets().size());
            b.endObject();
        // Test Case 1: Simple 2-term aggregation
            b.endObject();
            null,
        Query query,
        );
import static org.opensearch.search.aggregations.MultiBucketConsumerService.DEFAULT_MAX_BUCKETS;
        iw.addDocument(doc("a", 1, 10.0f, 100.0));
    }
            b.field("name", METRIC_FIELD);
    private static final String METRIC_FIELD = "metric";
import org.apache.lucene.tests.index.RandomIndexWriter;
    private List<MultiTermsValuesSourceConfig> getSourceConfig(String... fieldNames) {
import java.util.LinkedHashMap;
        supportedDimensions.put(new OrdinalDimension(KEYWORD_FIELD), KEYWORD_FIELD_TYPE);
    protected Codec getCodec() {
import org.opensearch.search.aggregations.AggregatorTestCase;
/*
    }
            INT_FIELD_TYPE,
    );
    }
        NumberFieldMapper.NumberType.FLOAT
        METRIC_FIELD,
            supportedDimensions
        QueryBuilder queryBuilder,
     * then asserts that the results are identical.
        // Index documents with values for our dimensions and metrics
        testCase(
            indexSearcher,
            b.value("value_count");
    private static final MappedFieldType KEYWORD_FIELD_TYPE = new KeywordFieldMapper.KeywordFieldType(KEYWORD_FIELD);
            b.endObject();
        FLOAT_FIELD,
            b.startObject().field("name", FLOAT_FIELD).endObject();
            null,
import static org.opensearch.index.codec.composite912.datacube.startree.AbstractStarTreeDVFormatTests.topMapping;
        try {
    private static final MappedFieldType FLOAT_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(
            createIndexSettings(),
            null,
            null,
 *
import org.apache.lucene.document.Document;
import org.apache.lucene.util.BytesRef;
            new MatchAllDocsQuery(),
            throw new RuntimeException(e);
        );
import org.opensearch.index.compositeindex.datacube.Dimension;
            queryBuilder,
public class MultiTermsAggregatorTests extends AggregatorTestCase {
            null,
            indexSearcher,
        directory.close();
        IndexWriterConfig conf = newIndexWriterConfig(null);
        doc.add(new SortedNumericDocValuesField(FLOAT_FIELD, NumericUtils.floatToSortableInt(f)));
import org.apache.lucene.util.NumericUtils;
import org.apache.logging.log4j.Logger;
}
            new MultiTermsAggregationBuilder("_name").terms(getSourceConfig(INT_FIELD, FLOAT_FIELD)),
            b.startObject().field("name", INT_FIELD).endObject();
            b.startObject("composite");
            KEYWORD_FIELD_TYPE,
            b.startObject("properties");
import org.opensearch.index.mapper.KeywordFieldMapper;
    /**
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;
        doc.add(new StringField(KEYWORD_FIELD, keyword, Field.Store.NO));
            b.startArray("stats");
            b.endObject();
        // Force merge to ensure the star-tree structure is built
            b.startObject(INT_FIELD).field("type", "integer").endObject();
            b.endObject();
            b.field("type", "star_tree");
    }
import static org.opensearch.search.aggregations.AggregationBuilders.max;
        CompositeIndexFieldInfo starTree = starTreeDocValuesReader.getCompositeIndexFields().get(0);
            false,
            query,
 * compatible open source license.
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);
            supportedDimensions
        doc.add(new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef(keyword)));
        );
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
import java.util.Arrays;
import org.opensearch.common.lucene.Lucene;
        // Test Case 3: Aggregation with a query that filters on a dimension
        MultiTermsAggregationBuilder aggregationBuilder,
        Document doc = new Document();
        // Extract the star-tree metadata from the segment
import org.apache.lucene.store.Directory;
        conf.setMergePolicy(newLogMergePolicy());
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions = new LinkedHashMap<>();
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
        MapperService mapperService;
            createIndexSettings(),
        Directory directory = newDirectory();
import org.apache.lucene.document.SortedNumericDocValuesField;
            b.startArray("ordered_dimensions");
            b.value("max");
        iw.addDocument(doc("a", 2, 20.0f, 200.0));
        doc.add(new SortedNumericDocValuesField(INT_FIELD, integer));
            b.startObject();
        INT_FIELD,
import org.opensearch.index.query.TermQueryBuilder;
            mapperService = StarTreeDocValuesFormatTests.createMapperService(getMapping());
import org.apache.logging.log4j.LogManager;
            starTree,
        LeafReaderContext context = ir.leaves().get(0);
import java.io.IOException;
            indexSearcher,
            supportedDimensions,
            b.startObject().field("name", KEYWORD_FIELD).endObject();
        });
import org.apache.lucene.document.Field;
        IndexSearcher indexSearcher,
        );
            null,
            true,
import org.apache.lucene.search.IndexSearcher;
            starTree,
            b.endArray();
    private void testCase(
            aggregationBuilder,
            b.startObject("my_star_tree");
    ) throws IOException {
            new MatchAllDocsQuery(),
            null,
import org.opensearch.index.compositeindex.datacube.NumericDimension;
        return topMapping(b -> {
import org.apache.lucene.search.Query;
            b.endArray();
import org.apache.lucene.index.DirectoryReader;
        conf.setCodec(getCodec());
 * SPDX-License-Identifier: Apache-2.0
        testCase(
            new TermQueryBuilder(KEYWORD_FIELD, "a"),
        CompositeIndexFieldInfo starTree,
import java.util.List;
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
            indexSearcher,
            SortedSetDocValuesField.newSlowExactQuery(KEYWORD_FIELD, newBytesRef("a")),
            supportedDimensions
        NumberFieldMapper.NumberType.INTEGER
            b.startObject("config");
            false,
            b.startObject(FLOAT_FIELD).field("type", "float").endObject();
    private static final MappedFieldType METRIC_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(
import org.opensearch.index.codec.composite.CompositeIndexReader;
    private static final String KEYWORD_FIELD = "keyword";
        return doc;
        testCase(
            starTree,
    }
import org.apache.lucene.document.SortedSetDocValuesField;
        final Logger testLogger = LogManager.getLogger(MultiTermsAggregatorTests.class);
            new MultiTermsAggregationBuilder("_name").terms(getSourceConfig(KEYWORD_FIELD, INT_FIELD)),
import org.apache.lucene.index.IndexWriterConfig;
        // Test Case 4: Aggregation with a sub-aggregation
import org.opensearch.search.aggregations.bucket.terms.InternalMultiTerms;
import org.opensearch.index.mapper.NumberFieldMapper;
        iw.addDocument(doc("c", 2, 20.0f, 200.0));
        // Test Case 2: 3-term aggregation
            DEFAULT_MAX_BUCKETS,
import org.opensearch.index.mapper.MapperService;
            indexSearcher,
        supportedDimensions.put(new NumericDimension(INT_FIELD), INT_FIELD_TYPE);
            starTree,
        // Setup index with star-tree codec
        iw.addDocument(doc("b", 1, 10.0f, 100.0));
     */
import org.opensearch.core.xcontent.XContentBuilder;
            null,
            b.startObject(METRIC_FIELD).field("type", "double").endObject();
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
    private static final String INT_FIELD = "int";
 */
import org.apache.lucene.index.LeafReaderContext;
        InternalMultiTerms defaultAggregation = searchAndReduceStarTree(
    private Document doc(String keyword, int integer, float f, double metric) {
        doc.add(new SortedNumericDocValuesField(METRIC_FIELD, NumericUtils.doubleToSortableLong(metric)));
            KEYWORD_FIELD_TYPE,
            new MultiTermsAggregationBuilder("_name").terms(getSourceConfig(KEYWORD_FIELD, INT_FIELD, FLOAT_FIELD)),
        iw.forceMerge(1);
import org.apache.lucene.index.SegmentReader;
    private static final MappedFieldType INT_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(
        testCase(
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationBuilder;
            METRIC_FIELD_TYPE
        }
        InternalMultiTerms starTreeAggregation = searchAndReduceStarTree(
        iw.close();
import org.apache.lucene.codecs.Codec;
import org.opensearch.search.aggregations.support.MultiTermsValuesSourceConfig;
            b.startObject(KEYWORD_FIELD).field("type", "keyword").endObject();
    private static XContentBuilder getMapping() throws IOException {
        NumberFieldMapper.NumberType.DOUBLE
            null,
        iw.addDocument(doc("b", 3, 30.0f, 300.0));
import org.opensearch.index.mapper.MappedFieldType;
                .subAggregation(max("max_metric").field(METRIC_FIELD)),
            b.endArray();
        SegmentReader reader = Lucene.segmentReader(context.reader());
        iw.addDocument(doc("a", 1, 10.0f, 100.0));
        ir.close();
        IndexSearcher indexSearcher = newSearcher(wrapInMockESDirectoryReader(ir), false, false);
            aggregationBuilder,
import org.apache.lucene.search.MatchAllDocsQuery;
        assertEquals(defaultAggregation, starTreeAggregation);
            indexSearcher,
