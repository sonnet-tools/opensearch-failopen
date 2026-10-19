import org.opensearch.search.aggregations.InternalAggregation;
        int numValues = atLeast(50);
 *
    public void testQueryFiltering() throws IOException {
        Supplier<Number> randomNumber,
                document.add(new SortedNumericDocValuesField("number", i + 3));
            assertEquals(1, max.getValue(), 0);  
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 1)));
            indexWriter.deleteDocuments(new Term("id", values.get(i).v1().toString()));
import org.apache.lucene.index.DirectoryReader;
                if (res != null) {
        Directory directory = newDirectory();
        params.put("inc", 1);
        }, max -> {
        testAggregation(new MatchAllDocsQuery(), iw -> {
        );  
                Document document = new Document();  
import java.io.IOException;
    public void testUnmappedField() throws IOException {  
        unmappedDirectory.close();
        return Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.BOOLEAN, CoreValuesSourceType.DATE);
 * Modifications Copyright OpenSearch Contributors. See
            assertTrue(AggregationInspectionHelper.hasValue(max));
        indexWriter.close();
import org.opensearch.search.aggregations.bucket.global.Global;
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        InternalMax result2 = (InternalMax) aggregator.buildAggregation(0L);
        aggregator.preCollection();
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
 * Unless required by applicable law or agreed to in writing,
            document.add(new SortedNumericDocValuesField("values", i + 3));
        indexReader.close();
            }  
            bucketCollector.postCollection();  
 * ownership. Elasticsearch licenses this file to you under  
        });
        unmappedIndexWriter.close();
    }  
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));  
                assertFalse(liveDocs.get(docID));
            assertTrue(AggregationInspectionHelper.hasValue(max));  
        bucketCollector.preCollection();
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            (n) -> new DoublePoint("number", n.doubleValue()),
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));
        indexWriter.close();
        assertEquals("max", max.getName());
            assertNotNull(terms);
    ) throws IOException {
            for (int i = 0; i < numDocs; i++) {
        Collections.sort(values, Comparator.comparingDouble(t -> t.v2().doubleValue()));  
            assertEquals(10.0, max.getValue(), 0);
        assertEquals(10.0, (double) ((InternalAggregation) global).getProperty("max.value"), 0);
            BucketCollector bucketCollector = MultiBucketCollector.wrap(maxAggregator, countAggregator, termsAggregator);  
import org.apache.lucene.document.DoublePoint;
                document.add(new SortedNumericDocValuesField("values", i + 3));  
    public void testNoMatchingField() throws IOException {
            assertTrue(AggregationInspectionHelper.hasValue(max));  
    public void testDoReset() throws IOException {
        assertNotNull(max);
import org.opensearch.search.aggregations.BucketCollector;  
    }  
        List<Document> documents = new ArrayList<>();
    public static final String VALUE_FIELD_SCRIPT = "value_field";
        scripts.put(SUM_FIELD_PARAMS_SCRIPT, vars -> {
            assertEquals(max.getValue(), Double.NEGATIVE_INFINITY, 0);  
            assertEquals(12.0, max.getValue(), 0);  
import org.apache.lucene.index.MultiReader;  
    private void assertAllDeleted(Bits liveDocs, PointValues values) throws IOException {
    public void testSingleValuedFieldWithValueScriptWithParams() throws IOException {
import org.opensearch.search.aggregations.Aggregator;  
        });  
        testAggregation(IntPoint.newRangeQuery("number", 0, 5), iw -> {
        List<Tuple<Integer, Number>> values = new ArrayList<>();  
        aggregator.preCollection();
        }, max -> {  
        }, fieldType);  
        });
    }
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").script(
            .subAggregation(AggregationBuilders.max("max").field("value"));
import org.opensearch.search.aggregations.AggregatorTestCase;
    private void testAggregation(
    }  
                }
            assertEquals(1L, bucket.getDocCount());
import org.apache.lucene.tests.index.RandomIndexWriter;  
            assertTrue(AggregationInspectionHelper.hasValue(max));
    }  
        InternalMax max = (InternalMax) maxAggregator.buildAggregation(0L);  
    }
                    );
    public void testNoDocs() throws IOException {
        // Do not add any documents
        MappedFieldType singleValueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        );  
        assertEquals("global", global.getName());  
            for (int i = 0; i < numDocs; i++) {
import org.opensearch.common.collect.Tuple;  
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    public void testSupportsIntraSegmentSearch() throws IOException {
            }
            for (int j = 0; j < numDup; j++) {
        Function<Map<String, Object>, Integer> getInc = vars -> {
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").field("value");  
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("_name").format("0000.0").field("value");
            }  
        assertTrue(aggregator.context().getQueryShardContext().isCacheable());
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);  
        InternalMax max = (InternalMax) aggregator.buildAggregation(0L);  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);  
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.emptyMap()));  
        });
            for (Terms.Bucket b : buckets) {  
        try (IndexReader reader = DirectoryReader.open(indexWriter)) {
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
        assertEquals("max", max.getName());  
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 1)));
        );
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
        directory.close();
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);  
            Terms.Bucket bucket = buckets.get(i);
     * Ensure requests using nondeterministic scripts do not get cached.
import java.util.ArrayList;
        int docID = 0;
            public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        testMaxShortcutCase(() -> randomInt(), (n) -> new IntPoint("number", n.intValue()), (v) -> IntPoint.decodeDimension(v, 0));
            .order(BucketOrder.compound(BucketOrder.aggregation("filter>max", true)))
}
        AggregationBuilder aggregationBuilder = AggregationBuilders.global("global")  
    public static final String RANDOM_SCRIPT = "Math.random()";
        Directory directory = newDirectory();  
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").script(  
                return ((Number) vars.get("inc")).intValue();
    }
            assertFalse(AggregationInspectionHelper.hasValue(max));  
        IndexReader indexReader = DirectoryReader.open(directory);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);  
            (v) -> DoublePoint.decodeDimension(v, 0)
    private void testAggregation(Query query, CheckedConsumer<RandomIndexWriter, IOException> buildIndex, Consumer<InternalMax> verify)
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
    }  
    }  
        aggregator.postCollection();  
        for (int i = 0; i < numDocs; i++) {
        }  
        RandomIndexWriter unmappedIndexWriter = new RandomIndexWriter(random(), unmappedDirectory);
            }
                Document document = new Document();
        indexReader.close();
                LeafReaderContext ctx = reader.leaves().get(0);  
        assertEquals(10, buckets.size());
        scripts.put(SUM_VALUES_FIELD_SCRIPT, vars -> sum.apply(vars, "values"));  
            assertEquals(max.getValue(), 19.0, 0);
                document.add(new SortedNumericDocValuesField("values", i + 2));  
        assertTrue(max.getValue() <= 1.0);
    public void testMissingFieldOptimization() throws IOException {
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.emptyMap()));
            public void visit(int docID) {
                iw.addDocument(document);
 */  
        for (int i = 0; i < numDocs; i++) {
    }  
                iw.addDocument(document);
            } else {
                docID++;  
    }  
        });
    }  
        Max max = global.getAggregations().get("max");  
        final int numDocs = 10;  
        assertFalse(aggregator.context().getQueryShardContext().isCacheable());  
        directory.close();  
        aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
    }
        indexWriter.close();  
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
        aggregator.doReset();
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        directory.close();
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
import org.apache.lucene.document.SortedNumericDocValuesField;
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, params));  
        MaxAggregationBuilder maxAggregationBuilder = new MaxAggregationBuilder("max").field("values");
        assertEquals(10.0, max.getValue(), 0);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);
        Directory directory = newDirectory();
        for (int i = 0; i < numDocs; i++) {
            }
        assertNotNull(max);
 * specific language governing permissions and limitations
            Terms terms = (Terms) termsAggregator.buildTopLevel();  
            Document document = new Document();
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").script(
    }
            assertEquals((long) i + 1, bucket.getKeyAsNumber());
        testAggregation(aggregationBuilder, new FieldExistsQuery("number"), iw -> {
        indexWriter.deleteDocuments(new Term("id", values.get(0).v1().toString()));  
            }
        }, max -> {
                assertTrue(factories.allFactoriesSupportIntraSegmentSearch());  
import org.apache.lucene.index.NoMergePolicy;
    }  
    public void testEarlyTermination() throws Exception {
            assertThat(res, equalTo(values.get(values.size() - 1).v2()));
        }, max -> {
        assertEquals(Double.NEGATIVE_INFINITY, result2.getValue(), 0);
        for (int i = values.size() - 1; i > 0; i--) {  
            assertEquals(10, max.getValue(), 0);  
        assertEquals("max", max.getName());
import org.apache.lucene.document.Document;
    /** Script to return the value of a field named {@code value}. */
 */
            assertEquals(Double.NEGATIVE_INFINITY, max.getValue(), 0);
import java.util.Arrays;  
        Function<byte[], Number> pointConvertFunc  
            assertEquals("0010.0", max.getValueAsString());  
        aggregator.preCollection();
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
        List<? extends Terms.Bucket> buckets = terms.getBuckets();  
        indexWriter.close();  
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", i + 1)));  
import org.apache.lucene.document.LongPoint;  
import org.apache.lucene.document.IntPoint;
        });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertEquals(12.0, max.getValue(), 0);
import org.opensearch.search.aggregations.MultiBucketCollector;  
        );
            bucketCollector.preCollection();
        }, max -> {  
        Global global = (Global) aggregator.buildTopLevel();
            int numDup = randomIntBetween(1, 3);
import java.util.function.Consumer;
    }
 * software distributed under the License is distributed on an
        MaxAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);  
                Number nextValue = randomNumber.get();
    public static final String SUM_VALUES_FIELD_SCRIPT = "sum_values_field";
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
import java.util.HashMap;  
    }
            () -> randomLongBetween(Integer.MIN_VALUE, Integer.MAX_VALUE),
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));  
        assertEquals(10.0, result1.getValue(), 0);  
        }, max -> {
            final int numDocs = 10;  
        IndexReader indexReader = DirectoryReader.open(directory);  
            }  
        }, max -> {
        Directory unmappedDirectory = newDirectory();  
                assertEquals(Double.NEGATIVE_INFINITY, subMax.getValue(), 0);
    /** Script to return a random double */
        aggregator.preCollection();
        assertEquals(1, global.getAggregations().asMap().size());
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));  
                }  
    public void testNestedEarlyTermination() throws Exception {
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 7)));
 * this work for additional information regarding copyright
        aggregator.postCollection();
    }  
            List<? extends Terms.Bucket> buckets = terms.getBuckets();
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").field("value")
            assertTrue(AggregationInspectionHelper.hasValue(max));
    }  
        final int numDocs = 10;  
    }
            document.add(new SortedNumericDocValuesField("values", i + 2));  
    }
    }  
        assertNotNull(global.getAggregations());
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);  
        scripts.put(VALUE_FIELD_SCRIPT, vars -> sum.apply(vars, "value"));
        throws IOException {
        // Test that an aggregation using a script does not get cached  
                            .getQueryShardContext(),  
    @Override  
            assertEquals(max.getValue(), 19.0, 0);  
        Directory unmappedDirectory = newDirectory();
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();  
        assertEquals(10.0, max.getValue(), 0);
            }  
            final int numDocs = 10;  
        assertEquals("global", global.getName());
            return sum.apply(vars, fieldname);
        params.put("field", "values");
        IndexReader unamappedIndexReader = DirectoryReader.open(unmappedDirectory);  
                IndexSearcher searcher = newIndexSearcher(reader);
        aggregationBuilder = new MaxAggregationBuilder("max").field("value")
            assertEquals("max", max.getName());  
            document.add(new SortedNumericDocValuesField("values", i + 3));
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
        unmappedIndexWriter.close();  
        multiReader.close();
            InternalValueCount count = (InternalValueCount) countAggregator.buildTopLevel();
        assertEquals("max", max.getName());
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", 1)));
import java.util.Collections;
        assertTrue(max.getValue() >= 0.0);  
        indexWriter.addDocument(singleton(new NumericDocValuesField("value", 5)));
            for (int i = 0; i < numDocs; i++) {  
        );
        for (Aggregator.SubAggCollectionMode collectionMode : Aggregator.SubAggCollectionMode.values()) {  
        AggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").field("value");
public class MaxAggregatorTests extends AggregatorTestCase {
        }  
    public void testSomeMatchesSortedNumericDocValues() throws IOException {
            for (int i = 0; i < numDocs; i++) {
                .subAggregation(new MaxAggregationBuilder("sub_max").field("invalid"));  
        IndexSearcher indexSearcher = newSearcher(multiReader, true, true);
                InternalMax subMax = b.getAggregations().get("sub_max");
        assertNotNull(max);  
                document.add(new SortedNumericDocValuesField("values", i + 3));
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
        aggregator.postCollection();
                Document document = new Document();  
            return values;
import java.util.Comparator;
        Directory directory = newDirectory();
    ) throws IOException {
    }
        }
        assertNotNull(terms);
        AggregationBuilder aggregationBuilder,  
        // Test that an aggregation not using a script does get cached  
        assertTrue(AggregationInspectionHelper.hasValue(max));
        directory.close();
        aggregator.postCollection();  
            for (int i = 0; i < numDocs; i++) {
        IndexReader indexReader = DirectoryReader.open(directory);
            Document document = new Document();
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));  
import java.util.function.BiFunction;  
        }, max -> {
        assertEquals(20L, count.getValue());
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").field("value");
    // checks that documents inside the max leaves are all deleted
    public void testQueryFiltersAll() throws IOException {
            assertEquals(13.0, max.getValue(), 0);
            MockScriptEngine.NAME,
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
    public void testMultiValuedFieldWithValueScript() throws IOException {
        BiFunction<Map<String, Object>, String, Object> sum = (vars, fieldname) -> {  
        IndexReader unamappedIndexReader = DirectoryReader.open(unmappedDirectory);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;  
        // insert some documents without a value for the metric field.  
import org.opensearch.search.aggregations.bucket.filter.Filter;
        }
import static org.hamcrest.Matchers.equalTo;
 * license agreements. See the NOTICE file distributed with
            }
        BucketCollector bucketCollector = MultiBucketCollector.wrap(maxAggregator, countAggregator);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
        final byte[] maxValue = values.getMaxPackedValue();  
import org.opensearch.search.aggregations.AggregationBuilder;
            assertNotNull(count);
            assertTrue(AggregationInspectionHelper.hasValue(max));  
    }  
        multiReader.close();  
        MultiReader multiReader = new MultiReader(indexReader, unamappedIndexReader);
    /**
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
            assertTrue(AggregationInspectionHelper.hasValue(max));
        });
        testAggregation(new MatchAllDocsQuery(), iw -> {  
        AggregationBuilder aggregationBuilder = AggregationBuilders.global("global")
            assertEquals("count", count.getName());
/*  
        IndexReader indexReader = DirectoryReader.open(directory);
        assertNotNull(global.getAggregations());  
                values.add(new Tuple<>(docID, nextValue));
        multiReader.close();
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        }, max -> {
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));  
            assertTrue(AggregationInspectionHelper.hasValue(max));
            assertEquals(12.0, max.getValue(), 0);
            try (IndexReader reader = indexWriter.getReader()) {  
 * You may obtain a copy of the License at  
        };
            final int numDocs = 10;
        assertEquals(10L, global.getDocCount());
            try (IndexReader reader = DirectoryReader.open(indexWriter)) {
        }, fieldType);
        indexWriter.close();
            assertTrue(AggregationInspectionHelper.hasValue(max));
            assertFalse(AggregationInspectionHelper.hasValue(max));
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                document.add(new StringField("id", Integer.toString(docID), Field.Store.NO));  
                if (Arrays.equals(maxPackedValue, 0, numBytes, maxValue, 0, numBytes)) {
        testMaxShortcutCase(
        values.intersect(new PointValues.IntersectVisitor() {  
            assertEquals(12.0, max.getValue(), 0);  
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("_name").field("number");
        indexReader.close();
        IndexReader indexReader = DirectoryReader.open(directory);  
import org.apache.lucene.index.IndexWriter;  
        IndexWriterConfig config = newIndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE);  
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SUM_FIELD_PARAMS_SCRIPT, params)  
            assertTrue(AggregationInspectionHelper.hasValue(max));
        }, max -> {
        });  
        for (int i = 0; i < numDocs; i++) {  
import org.opensearch.script.ScriptType;  
    public void testUnmappedWithMissingField() throws IOException {
    @Override
                document.add(new SortedNumericDocValuesField("values", i + 2));
        }, max -> {  
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").field("values")
            for (int i = 0; i < numDocs; i++) {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
/*
                values.add(((Number) v).longValue() + inc);
        unmappedDirectory.close();
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 1)));
            nonDeterministicScripts,
        Map<String, Object> params = Collections.singletonMap("inc", 1);
            assertEquals(11.0, max.getValue(), 0);  
 * under the License.  
            final int numDocs = 10;  
                document.add(pointFieldFunc.apply(nextValue));
        }
        AggregationBuilder aggregationBuilder = new MaxAggregationBuilder("_name").field("number")
            final int numDocs = 10;
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)
            for (Object v : docLookup.get(fieldname)) {
import org.opensearch.search.aggregations.AggregatorFactories;
            Number res = MaxAggregator.findLeafMaxValue(ctx.reader(), "number", pointConvertFunc);  
            assertEquals(Double.NEGATIVE_INFINITY, max.getValue(), 0);  
        MappedFieldType multiValuesfieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);  
        aggregator.preCollection();  
import org.opensearch.search.aggregations.support.ValueType;  
        }, fieldType);
import org.opensearch.index.mapper.MappedFieldType;
            @Override
            }  
            assertEquals(max.getValue(), SCRIPT_VALUE, 0); // Note this is the script value (19L), not the doc values above
            }  
 * this file be licensed under the Apache-2.0 license or a
        Directory directory = newDirectory();
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));  
/*  
import java.util.function.Function;
        directory.close();
        testAggregation(aggregationBuilder, new FieldExistsQuery("number"), iw -> {
        }, (MappedFieldType) null);
import org.apache.lucene.index.IndexWriterConfig;
        MultiReader multiReader = new MultiReader(indexReader, unamappedIndexReader);  
    }
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 1)));
import org.apache.lucene.document.Field;  
        assertEquals(Double.NEGATIVE_INFINITY, max.getValue(), 0);
     */
        assertEquals(10.0, max.getValue(), 0);
    public void testSingleValuedFieldGetProperty() throws IOException {
import org.apache.lucene.search.FieldExistsQuery;
                documents.add(document);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);  
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));  
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
        }, fieldType);
    }
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 1)));
                throw new AssertionError();  
        testMaxShortcutCase(() -> randomFloat(), (n) -> new FloatPoint("number", n.floatValue()), (v) -> FloatPoint.decodeDimension(v, 0));  
            assertEquals(7, max.getValue(), 0);
import org.opensearch.search.aggregations.support.ValuesSourceType;
        final int numDocs = 10;  
    /** Script to return the {@code _value} provided by aggs framework. */
            (v) -> LongPoint.decodeDimension(v, 0)
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("_name").field("number");
        indexSearcher.search(new MatchAllDocsQuery(), bucketCollector);  
        testAggregation(new FieldExistsQuery("number"), iw -> {  
        assertTrue(seen[0]);
            assertEquals(Double.NEGATIVE_INFINITY, max.getValue(), 0);
                    assertAllDeleted(ctx.reader().getLiveDocs(), ctx.reader().getPointValues("number"));
        params.put("inc", 1);
        directory.close();  
            assertTrue(AggregationInspectionHelper.hasValue(max));  
            Number res = MaxAggregator.findLeafMaxValue(ctx.reader(), "number", pointConvertFunc);  
     */  
                Number res = MaxAggregator.findLeafMaxValue(ctx.reader(), "number", pointConvertFunc);
                .collectMode(collectionMode)
                return PointValues.Relation.CELL_OUTSIDE_QUERY;
        for (int i = 0; i < 3; i++) {
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);  
        IndexSearcher indexSearcher = newSearcher(multiReader, true, true);
                    return PointValues.Relation.CELL_CROSSES_QUERY;  
            assertFalse(AggregationInspectionHelper.hasValue(max));
    public void testMultiValuedFieldWithValueScriptWithParams() throws IOException {
        final int numDocs = 10;
        indexWriter.close();  
                Document document = new Document();  
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").field("values")
 * GitHub history for details.
        InternalMax max = (InternalMax) aggregator.buildAggregation(0L);  
        assertEquals(0L, global.getDocCount());
        });
    public void testCacheAggregation() throws IOException {
    }
        Map<String, Object> params = new HashMap<>();
    public void testScriptSingleValued() throws IOException {
import org.apache.lucene.store.Directory;
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
import static java.util.Collections.emptyList;
        Consumer<InternalMax> verify,  
            indexWriter.addDocument(document);  
        Directory directory = newDirectory();
import org.apache.lucene.index.PointValues;
        }, (MappedFieldType) null);
    }
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").field("value")
        for (int i = 0; i < numDocs; i++) {  
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
import org.opensearch.search.lookup.LeafDocLookup;
        indexWriter.close();  
            assertEquals("max", max.getName());
    /**
        TermsAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
            assertTrue(AggregationInspectionHelper.hasValue(max));
            final int numDocs = 10;
            for (int i = 0; i < numDocs; i++) {  
    public void testSomeMatchesNumericDocValues() throws IOException {  
            if (vars == null || vars.containsKey("inc") == false) {
        MaxAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
        return new MaxAggregationBuilder("_name").field(fieldName);
                Document document = new Document();
    /** Script to take a field name in params and sum the values of the field. */
 *
        ValueCountAggregator countAggregator = createAggregator(countAggregationBuilder, indexSearcher, fieldType);
import org.apache.lucene.index.LeafReaderContext;
        MultiReader multiReader = new MultiReader(indexReader, unamappedIndexReader);  
            assertEquals(7, max.getValue(), 0);
            List<Long> values = new ArrayList<>();  
        );
        Map<String, Object> params = Collections.singletonMap("inc", 1);
        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.NUMERIC)
        }
import java.util.function.Supplier;  
                    .addAggregator(new MaxAggregationBuilder("test").field("value"))  
            );
                iw.addDocument(document);
        indexWriter.addDocuments(documents);
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.emptyMap()));
        RandomIndexWriter unmappedIndexWriter = new RandomIndexWriter(random(), unmappedDirectory);
        testAggregation(aggregationBuilder, query, buildIndex, verify, fieldType);
        });
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);  
                seen[0] = true;  
        Directory directory = newDirectory();  
    private final String SCRIPT_NAME = "script_name";  
    public void testSingleValuedFieldWithValueScript() throws IOException {
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
            for (int i = 0; i < numDocs; i++) {
    }  
        }, max -> {  
import org.opensearch.index.mapper.NumberFieldMapper;  
            assertTrue(AggregationInspectionHelper.hasValue(max));
        }, fieldType);
    }
        indexReader.close();
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            assertNotNull(buckets);  
            InternalMax max = (InternalMax) maxAggregator.buildTopLevel();
        bucketCollector.postCollection();
            }
            int inc = getInc.apply(vars);
            // Intentionally not writing any docs  
            documents.add(document);  
        for (int i = 0; i < numDocs; i++) {
        InternalMax result1 = (InternalMax) aggregator.buildAggregation(0L);
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
import org.opensearch.script.ScriptModule;
            assertTrue(AggregationInspectionHelper.hasValue(max));  
        }
        MappedFieldType fieldType
        });
            int inc = getInc.apply(vars);  
            assertEquals(13.0, max.getValue(), 0);
        directory.close();
        unmappedIndexWriter.close();
                iw.addDocument(document);  
        MaxAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
        }, max -> {
        scripts.put(VALUE_SCRIPT, vars -> {
            for (int i = 0; i < numDocs; i++) {
        Directory directory = newDirectory();  
        indexWriter.close();
     * Make sure that a request using a deterministic script or not using a script get cached.  
        }, fieldType);
            LeafReaderContext ctx = reader.leaves().get(0);
            Document document = new Document();  
            iw.addDocument(emptyList());  
import java.util.List;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);  
            MaxAggregator maxAggregator = createAggregator(maxAggregationBuilder, indexSearcher, multiValuesfieldType);
        for (int i = 0; i < numDocs; i++) {
    public void testSingleValuedField() throws IOException {
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        InternalValueCount count = (InternalValueCount) countAggregator.buildAggregation(0L);
        assertNotNull(count);  
            }
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        indexWriter.addDocument(singleton(new NumericDocValuesField("value", 10)));
    }  
        IndexReader indexReader = DirectoryReader.open(directory);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, SCRIPT_NAME, Collections.emptyMap()));
        }, fieldType);
    }
    public void testScriptSingleValuedWithParams() throws IOException {
        assertNotNull(global);
import org.apache.lucene.document.NumericDocValuesField;
            assertEquals(20L, count.getValue());  
            () -> randomDouble(),  
 * The OpenSearch Contributors require contributions made to  
        int numBytes = values.getBytesPerDimension();
import org.opensearch.script.ScriptEngine;  
            LeafDocLookup docLookup = (LeafDocLookup) vars.get("doc");
        }, fieldType);
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);  
        MaxAggregator maxAggregator = createAggregator(maxAggregationBuilder, indexSearcher, fieldType);
        }, max -> {
        aggregator.preCollection();  
                .field("value")
        final boolean[] seen = new boolean[1];
        testAggregation(new FieldExistsQuery("number"), iw -> {
            assertNotNull(max);  
            String fieldname = (String) vars.get("field");  
import org.apache.lucene.util.Bits;
 * Licensed to Elasticsearch under one or more contributor  
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SUM_VALUES_FIELD_SCRIPT, Collections.emptyMap())  
        final int numDocs = 10;
            TermsAggregationBuilder termsAggregationBuilder = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.NUMERIC)  
        InternalMax max = (InternalMax) aggregator.buildAggregation(0L);
import org.opensearch.script.Script;
        assertEquals("max", max.getName());
                document.add(new SortedNumericDocValuesField("values", i + 2));
import org.apache.lucene.document.StringField;  
        aggregator.preCollection();
    public void testScriptCaching() throws Exception {  
            final int numDocs = 10;
import org.apache.lucene.search.IndexSearcher;
            }
        aggregator.postCollection();  
                    assertThat(res, equalTo(values.get(i - 1).v2()));  
                return 0;  
            }
        aggregator.postCollection();
        assertTrue(aggregator.context().getQueryShardContext().isCacheable());
import org.opensearch.search.aggregations.bucket.terms.Terms;
        RandomIndexWriter unmappedIndexWriter = new RandomIndexWriter(random(), unmappedDirectory);
            indexSearcher.search(new MatchAllDocsQuery(), bucketCollector);
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                        null
            }  
            LeafReaderContext ctx = reader.leaves().get(0);
            for (int i = 0; i < numDocs; i++) {  
            MaxAggregationBuilder maxAggregationBuilder = new MaxAggregationBuilder("max").field("values");
        assertTrue(AggregationInspectionHelper.hasValue(max));
        assertEquals(10.0, max.getValue(), 0);  
import org.apache.lucene.document.FloatPoint;
 * not use this file except in compliance with the License.
            TermsAggregator termsAggregator = createAggregator(termsAggregationBuilder, indexSearcher, singleValueFieldType);
        }
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);  
        Map<String, Object> params = new HashMap<>();  
        params.put("field", "value");  
    public void testScript() throws IOException {
    public void testScriptMultiValuedWithParams() throws IOException {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
                Document document = new Document();
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
    protected ScriptService getMockScriptService() {
    }
        assertEquals("max", max.getName());  
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    }
        }, max -> {
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
import org.opensearch.script.ScriptService;
            ValueCountAggregationBuilder countAggregationBuilder = new ValueCountAggregationBuilder("count").field("values");
        final int numDocs = 10;
        assertEquals(12.0, max.getValue(), 0);
        }, fieldType);
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
    public static final String VALUE_SCRIPT = "_value";
        unmappedDirectory.close();
 *    http://www.apache.org/licenses/LICENSE-2.0
                AggregatorFactories factories = AggregatorFactories.builder()
                AggregationBuilders.filter("filter", termQuery("value", 100)).subAggregation(AggregationBuilders.max("max").field("value"))  
            assertEquals(10.0, max.getValue(), 0);
        Directory directory = newDirectory();
            for (int i = 0; i < numDocs; i++) {
        assertEquals("max", max.getName());  
        }, max -> {
        }, fieldType);
        ValueCountAggregationBuilder countAggregationBuilder = new ValueCountAggregationBuilder("count").field("values");
        testAggregation(aggregationBuilder, new FieldExistsQuery("number"), iw -> {
                document.add(new SortedNumericDocValuesField("values", i + 3));
        MaxAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
            assertEquals(10.0, max.getValue(), 0);
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
        Max max = global.getAggregations().get("max");
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, RANDOM_SCRIPT, Collections.emptyMap()));  
    public void testScriptMultiValued() throws IOException {
 * compatible open source license.
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    @Override
        Directory directory = newDirectory();
    }
        Global global = (Global) aggregator.buildTopLevel();
            }
            Max max = filter.getAggregations().get("max");
            .field("value")  
    /** Script to sum the values of a field named {@code values}. */
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);
        directory.close();
        }, max -> {  
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
        }  
 *  
        for (int i = 0; i < numValues; i++) {  
                } else {
import org.opensearch.common.CheckedConsumer;
            .subAggregation(AggregationBuilders.max("max").field("value"));
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);  
        final int numDocs = 10;
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
            indexWriter.addDocument(document);
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("_name").field("number").missing(19L);  
    public void testSingleValuedFieldWithFormatter() throws IOException {
            final int numDocs = 10;
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
import org.apache.lucene.index.Term;  
    }  
        );  
        Directory unmappedDirectory = newDirectory();  
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, params));  
import org.opensearch.search.aggregations.BucketOrder;
        }
        aggregator.preCollection();  
        max = (InternalMax) aggregator.buildAggregation(0L);
            }
        assertNotNull(global);  
        directory.close();  
        Function<Number, Field> pointFieldFunc,
import static java.util.Collections.singleton;  
        assertEquals(1, global.getAggregations().asMap().size());  
            document.add(new NumericDocValuesField("value", i + 1));
        MockScriptEngine scriptEngine = new MockScriptEngine(
        GlobalAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);  
        assertTrue(AggregationInspectionHelper.hasValue(max));  
            document.add(new SortedNumericDocValuesField("values", i + 2));
        try (IndexReader reader = DirectoryReader.open(indexWriter)) {
    public void testSingleValuedFieldPartiallyUnmapped() throws IOException {  
        aggregator.postCollection();
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
    public void testOrderByEmptyAggregation() throws IOException {
            }
    }
        }, max -> {
            assertTrue(AggregationInspectionHelper.hasValue(max));  
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
 */  
            ValueCountAggregator countAggregator = createAggregator(countAggregationBuilder, indexSearcher, multiValuesfieldType);  
        };
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));
    public void testMaxShortcutRandom() throws Exception {  
            assertTrue(AggregationInspectionHelper.hasValue(max));
        assertNotNull(buckets);
            assertFalse(AggregationInspectionHelper.hasValue(max));
        IndexReader indexReader = DirectoryReader.open(directory);
        indexWriter.close();
     * Make sure that an aggregation not using a script does get cached.
        AggregationBuilder aggregationBuilder = new MaxAggregationBuilder("_name").field("number").missing(19L);
            assertNotNull(filter);
            assertEquals(10, buckets.size());
        indexReader.close();  
        Terms terms = (Terms) aggregator.buildTopLevel();
                iw.addDocument(singleton(new NumericDocValuesField("number", i + 1)));  
        IndexReader indexReader = DirectoryReader.open(directory);
        }
            final int numDocs = 10;
    private final long SCRIPT_VALUE = 19L;
            .subAggregation(
        indexReader.close();
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
        }, max -> {
import org.opensearch.search.aggregations.AggregationBuilders;
        assertEquals(10.0, (double) ((InternalAggregation) max).getProperty("value"), 0);  
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
        Query query,
        aggregator.postCollection();
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
        IndexReader indexReader = DirectoryReader.open(directory);
                document.add(new SortedNumericDocValuesField("values", i + 2));  
    public void testEmptyAggregation() throws Exception {  
        assertEquals("count", count.getName());
        Map<String, Function<Map<String, Object>, Object>> nonDeterministicScripts = new HashMap<>();
        for (int i = 0; i < 10; i++) {
        IndexSearcher indexSearcher = newSearcher(multiReader, true, true);
            assertThat(res, equalTo(null));
                iw.addDocument(document);  
            @Override  
        nonDeterministicScripts.put(RANDOM_SCRIPT, vars -> MaxAggregatorTests.randomDouble());
        GlobalAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
        }, max -> {
                document.add(new SortedNumericDocValuesField("values", i + 3));
 * the Apache License, Version 2.0 (the "License"); you may
                document.add(new SortedNumericDocValuesField("number", i + 2));
            Collections.emptyMap()
            Filter filter = bucket.getAggregations().get("filter");
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").field("value")
            assertEquals(Double.NEGATIVE_INFINITY, max.getValue(), 0);
    private void testMaxShortcutCase(  
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
            return ((Number) vars.get("_value")).doubleValue() + inc;
                    .build(
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").script(
    }  
import java.util.Map;
            @Override  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);  
        assertTrue(AggregationInspectionHelper.hasValue(max));  
        testAggregation(IntPoint.newRangeQuery("number", -1, 0), iw -> {  
import static org.opensearch.index.query.QueryBuilders.termQuery;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        }
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_FIELD_SCRIPT, Collections.emptyMap())
            assertEquals(11.0, max.getValue(), 0);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        }, max -> {
import org.opensearch.search.aggregations.bucket.global.GlobalAggregator;  
package org.opensearch.search.aggregations.metrics;
        }
            (n) -> new LongPoint("number", n.longValue()),  
            assertNotNull(max);  
        testAggregation(new MatchAllDocsQuery(), iw -> {
    public void testMultiValuedField() throws IOException {
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        testAggregation(new MatchAllDocsQuery(), iw -> {  
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SUM_FIELD_PARAMS_SCRIPT, params)
            assertTrue(AggregationInspectionHelper.hasValue(max));
        indexWriter.close();
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);  
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {  
        IndexReader unamappedIndexReader = DirectoryReader.open(unmappedDirectory);
        scripts.put(SCRIPT_NAME, script -> SCRIPT_VALUE);
import org.apache.lucene.index.IndexReader;
        }  
            scripts,  
            final int numDocs = 10;  
            public void visit(int docID, byte[] packedValue) {
            assertEquals("max", max.getName());  
        }
        IndexWriter indexWriter = new IndexWriter(directory, config);
        }, fieldType);
import org.opensearch.script.MockScriptEngine;
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
    public static final String SUM_FIELD_PARAMS_SCRIPT = "sum_field_params";
        assertEquals(max, ((InternalAggregation) global).getProperty("max"));
            }  
        // Test that an aggregation using a nondeterministic script does not get cached
        testMaxShortcutCase(
import org.apache.lucene.search.Query;
import org.apache.lucene.search.MatchAllDocsQuery;  
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);  
import org.opensearch.common.settings.Settings;
    }
            assertEquals(0L, filter.getDocCount());  
        directory.close();
            assertNotNull(bucket);  
            final int numDocs = 10;
