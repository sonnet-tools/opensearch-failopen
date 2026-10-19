        supportedDimensions.put(new NumericDimension(FLOAT_FIELD), FLOAT_FIELD_TYPE);
        doc.add(new SortedNumericDocValuesField(INT_FIELD, integer));  
     * Executes an aggregation twice: once with star-tree enabled and once with it disabled (default path),
            null,
            starTree,
import org.opensearch.index.mapper.MappedFieldType;
            indexSearcher,  
            new TermQueryBuilder(KEYWORD_FIELD, "a"),
import org.opensearch.search.aggregations.bucket.terms.InternalMultiTerms;
        doc.add(new SortedNumericDocValuesField(METRIC_FIELD, NumericUtils.doubleToSortableLong(metric)));
            null,  
import static org.opensearch.search.aggregations.MultiBucketConsumerService.DEFAULT_MAX_BUCKETS;  
import org.opensearch.index.compositeindex.datacube.OrdinalDimension;
            null,
            false,
        // Test Case 2: 3-term aggregation
            queryBuilder,
import org.apache.lucene.document.Document;
import org.opensearch.index.codec.composite.composite104.Composite104Codec;
import org.opensearch.index.mapper.MapperService;
            METRIC_FIELD_TYPE
        iw.addDocument(doc("b", 1, 10.0f, 100.0));
import org.apache.lucene.search.IndexSearcher;
            throw new RuntimeException(e);
import java.util.LinkedHashMap;
    }  
import org.apache.logging.log4j.Logger;
        SegmentReader reader = Lucene.segmentReader(context.reader());
            null,  
        FLOAT_FIELD,  
        NumberFieldMapper.NumberType.INTEGER  
            b.startObject("composite");
            b.startObject(KEYWORD_FIELD).field("type", "keyword").endObject();
        iw.forceMerge(1);  
import org.opensearch.index.query.QueryBuilder;
     * then asserts that the results are identical.  
import org.opensearch.index.codec.composite.CompositeIndexReader;  
import org.opensearch.search.aggregations.AggregatorTestCase;  
        Document doc = new Document();  
        testCase(  
            b.startObject();
            supportedDimensions  
            b.value("value_count");
            supportedDimensions
import org.opensearch.index.mapper.NumberFieldMapper;  
        doc.add(new SortedSetDocValuesField(KEYWORD_FIELD, new BytesRef(keyword)));
        iw.addDocument(doc("a", 2, 20.0f, 200.0));  
    private static final String INT_FIELD = "int";
            createIndexSettings(),
                .subAggregation(max("max_metric").field(METRIC_FIELD)),
            indexSearcher,  
import java.util.Arrays;  
    }
import org.apache.lucene.index.DirectoryReader;
        assertEquals(defaultAggregation.getBuckets().size(), starTreeAggregation.getBuckets().size());  
        );
    );
            b.value("max");
            indexSearcher,
import org.opensearch.search.aggregations.bucket.terms.MultiTermsAggregationBuilder;
import org.apache.lucene.search.Query;
        );  
    private Document doc(String keyword, int integer, float f, double metric) {
        // Setup index with star-tree codec
            indexSearcher,
 * this file be licensed under the Apache-2.0 license or a
        NumberFieldMapper.NumberType.FLOAT
import static org.opensearch.search.aggregations.AggregationBuilders.max;
            indexSearcher,
            b.startObject("my_star_tree");  
import org.opensearch.index.compositeindex.datacube.Dimension;  
            b.field("name", METRIC_FIELD);
        NumberFieldMapper.NumberType.DOUBLE
        });  
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions = new LinkedHashMap<>();
import org.apache.lucene.document.StringField;  
import org.apache.lucene.util.BytesRef;
        MapperService mapperService;
            DEFAULT_MAX_BUCKETS,
        iw.addDocument(doc("c", 2, 20.0f, 200.0));  
            KEYWORD_FIELD_TYPE,  
public class MultiTermsAggregatorTests extends AggregatorTestCase {
import org.apache.lucene.tests.index.RandomIndexWriter;  
            b.startArray("metrics");  
            INT_FIELD_TYPE,  
    }
            new MatchAllDocsQuery(),
            starTree,
        doc.add(new SortedNumericDocValuesField(FLOAT_FIELD, NumericUtils.floatToSortableInt(f)));
    public void testMultiTermsWithStarTree() throws IOException {
            INT_FIELD_TYPE,
            b.endObject();  
        return new Composite104Codec(Lucene104Codec.Mode.BEST_SPEED, mapperService, testLogger);
            null,
import org.apache.lucene.document.Field;  
        // Extract the star-tree metadata from the segment
            b.startObject().field("name", KEYWORD_FIELD).endObject();
        InternalMultiTerms starTreeAggregation = searchAndReduceStarTree(
    }
        INT_FIELD,
        iw.addDocument(doc("a", 1, 10.0f, 100.0));
            indexSearcher,  
        InternalMultiTerms defaultAggregation = searchAndReduceStarTree(
import java.util.List;
            KEYWORD_FIELD_TYPE,
import org.apache.lucene.document.SortedNumericDocValuesField;
        // Index documents with values for our dimensions and metrics  
import java.io.IOException;
            null,
 */  
        LinkedHashMap<Dimension, MappedFieldType> supportedDimensions
    }
    );  
            supportedDimensions
import org.apache.logging.log4j.LogManager;
import org.apache.lucene.document.SortedSetDocValuesField;
        doc.add(new StringField(KEYWORD_FIELD, keyword, Field.Store.NO));
        // Test Case 1: Simple 2-term aggregation
/*  
            starTree,
            supportedDimensions,
            starTree,  
    }
            DEFAULT_MAX_BUCKETS,
            null,  
package org.opensearch.search.aggregations.startree;
            METRIC_FIELD_TYPE  
import org.apache.lucene.store.Directory;
            mapperService = StarTreeDocValuesFormatTests.createMapperService(getMapping());  
        }  
        conf.setCodec(getCodec());
            b.endObject();
    private static final MappedFieldType FLOAT_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(
            new MatchAllDocsQuery(),
            b.endObject();
import org.opensearch.index.mapper.KeywordFieldMapper;  
import org.opensearch.index.compositeindex.datacube.NumericDimension;
    private static final String FLOAT_FIELD = "float";  
            b.startArray("ordered_dimensions");
            b.startObject().field("name", INT_FIELD).endObject();  
import org.opensearch.index.codec.composite912.datacube.startree.StarTreeDocValuesFormatTests;
            b.endArray();
import org.apache.lucene.index.SegmentReader;
 * The OpenSearch Contributors require contributions made to  
        iw.addDocument(doc("b", 3, 30.0f, 300.0));
        Directory directory = newDirectory();  
        supportedDimensions.put(new NumericDimension(INT_FIELD), INT_FIELD_TYPE);  
            queryBuilder,  
            createIndexSettings(),  
        CompositeIndexReader starTreeDocValuesReader = (CompositeIndexReader) reader.getDocValuesReader();  
    );
import org.apache.lucene.index.LeafReaderContext;  
            true,
        try {
        testCase(
    protected Codec getCodec() {
            b.field("max_leaf_docs", 1);  
        // Define the dimensions we expect our star-tree to have  
import org.apache.lucene.search.MatchAllDocsQuery;  
            FLOAT_FIELD_TYPE,
    /**
        testCase(
import org.apache.lucene.util.NumericUtils;
            new MatchAllDocsQuery(),
            false,
 * compatible open source license.
        supportedDimensions.put(new OrdinalDimension(KEYWORD_FIELD), KEYWORD_FIELD_TYPE);
            starTree,
        // Test Case 4: Aggregation with a sub-aggregation
            b.startObject(FLOAT_FIELD).field("type", "float").endObject();  
        );
    private static final String METRIC_FIELD = "metric";
        } catch (IOException e) {
        return topMapping(b -> {
        return doc;  
    private static XContentBuilder getMapping() throws IOException {  
            b.startObject("properties");  
import static org.opensearch.index.codec.composite912.datacube.startree.AbstractStarTreeDVFormatTests.topMapping;
            b.endArray();  
    private static final MappedFieldType KEYWORD_FIELD_TYPE = new KeywordFieldMapper.KeywordFieldType(KEYWORD_FIELD);  
    private List<MultiTermsValuesSourceConfig> getSourceConfig(String... fieldNames) {
        LeafReaderContext context = ir.leaves().get(0);
            query,
        testCase(
    private static final MappedFieldType METRIC_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(  
            null,
        RandomIndexWriter iw = new RandomIndexWriter(random(), directory, conf);
        CompositeIndexFieldInfo starTree,
        final Logger testLogger = LogManager.getLogger(MultiTermsAggregatorTests.class);  
        QueryBuilder queryBuilder,
        MultiTermsAggregationBuilder aggregationBuilder,  
        conf.setMergePolicy(newLogMergePolicy());  
     */
        // Force merge to ensure the star-tree structure is built
        supportedDimensions.put(new NumericDimension(METRIC_FIELD), METRIC_FIELD_TYPE);
            b.startObject().field("name", FLOAT_FIELD).endObject();
        METRIC_FIELD,
            new MultiTermsAggregationBuilder("_name").terms(getSourceConfig(KEYWORD_FIELD, INT_FIELD)),  
}
        assertEquals(defaultAggregation, starTreeAggregation);
            b.endObject();
import org.opensearch.search.aggregations.support.MultiTermsValuesSourceConfig;  
import org.opensearch.index.codec.composite.CompositeIndexFieldInfo;
            b.startObject("config");
        directory.close();
        );
        IndexWriterConfig conf = newIndexWriterConfig(null);
            false,  
        iw.addDocument(doc("a", 1, 10.0f, 100.0));
            new MultiTermsAggregationBuilder("_name").terms(getSourceConfig(KEYWORD_FIELD, INT_FIELD, FLOAT_FIELD)),
        ir.close();  
import org.opensearch.common.lucene.Lucene;  
        iw.close();
        // Test Case 3: Aggregation with a query that filters on a dimension  
 * SPDX-License-Identifier: Apache-2.0
            aggregationBuilder,
        CompositeIndexFieldInfo starTree = starTreeDocValuesReader.getCompositeIndexFields().get(0);
        IndexSearcher indexSearcher,  
import org.apache.lucene.index.IndexWriterConfig;
            aggregationBuilder,  
        IndexSearcher indexSearcher = newSearcher(wrapInMockESDirectoryReader(ir), false, false);  
        DirectoryReader ir = DirectoryReader.open(directory);  
    private void testCase(
            b.startObject(METRIC_FIELD).field("type", "double").endObject();
            new MultiTermsAggregationBuilder("_name").terms(getSourceConfig(INT_FIELD, FLOAT_FIELD)),
    ) throws IOException {  
            supportedDimensions  
import org.opensearch.index.query.TermQueryBuilder;
import org.opensearch.core.xcontent.XContentBuilder;
            b.endArray();
            b.endObject();
            b.startObject(INT_FIELD).field("type", "integer").endObject();
        );
 *
            b.startArray("stats");  
import org.apache.lucene.codecs.lucene104.Lucene104Codec;
        return Arrays.stream(fieldNames).map(name -> new MultiTermsValuesSourceConfig.Builder().setFieldName(name).build()).toList();
            query,
        Query query,
            FLOAT_FIELD_TYPE,
    private static final MappedFieldType INT_FIELD_TYPE = new NumberFieldMapper.NumberFieldType(
        );  
            new MultiTermsAggregationBuilder("_name").terms(getSourceConfig(KEYWORD_FIELD, FLOAT_FIELD))  
    private static final String KEYWORD_FIELD = "keyword";
            SortedSetDocValuesField.newSlowExactQuery(KEYWORD_FIELD, newBytesRef("a")),  
            b.field("type", "star_tree");
            null,  
import org.apache.lucene.codecs.Codec;  
