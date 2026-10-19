 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.lucene.document.IntPoint;
    // checks that documents inside the max leaves are all deleted
        directory.close();
import org.apache.lucene.document.LongPoint;
            );
        Consumer<InternalMax> verify,
import java.util.Comparator;
            for (int i = 0; i < numDocs; i++) {
import java.util.function.Supplier;
import org.apache.lucene.index.IndexReader;
                        null
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 1)));
        params.put("inc", 1);
            for (int j = 0; j < numDup; j++) {
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
 * specific language governing permissions and limitations
        Map<String, Object> params = Collections.singletonMap("inc", 1);
        });
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        assertTrue(max.getValue() >= 0.0);
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        indexWriter.close();
        }
        }, max -> {
            final int numDocs = 10;
    /** Script to sum the values of a field named {@code values}. */
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        bucketCollector.preCollection();
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
    }
        return Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.BOOLEAN, CoreValuesSourceType.DATE);
        );
        }
import org.opensearch.search.aggregations.bucket.global.GlobalAggregator;
import org.apache.lucene.document.Document;
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
        for (int i = 0; i < numDocs; i++) {
        unmappedIndexWriter.close();
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
    }
            assertEquals(1, max.getValue(), 0);
            .field("value")
import org.apache.lucene.store.Directory;
        }, (MappedFieldType) null);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);
    }
        directory.close();
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
import org.apache.lucene.search.IndexSearcher;
            for (int i = 0; i < numDocs; i++) {
        try (IndexReader reader = DirectoryReader.open(indexWriter)) {
            assertEquals(12.0, max.getValue(), 0);
        assertNotNull(max);
        }, fieldType);
 * Licensed to Elasticsearch under one or more contributor
        Map<String, Object> params = new HashMap<>();
                seen[0] = true;
        testMaxShortcutCase(
    public void testUnmappedWithMissingField() throws IOException {
    /**
                document.add(new SortedNumericDocValuesField("values", i + 3));
        final int numDocs = 10;
        final int numDocs = 10;
            BucketCollector bucketCollector = MultiBucketCollector.wrap(maxAggregator, countAggregator, termsAggregator);
        assertNotNull(max);
 */
    }
                document.add(new SortedNumericDocValuesField("number", i + 2));
        }, max -> {
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            }
        testAggregation(aggregationBuilder, new FieldExistsQuery("number"), iw -> {
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
        }, max -> {
        }, max -> {
        // Test that an aggregation not using a script does get cached
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        indexReader.close();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.script.ScriptEngine;
    }
import org.opensearch.common.collect.Tuple;
    public void testScriptMultiValued() throws IOException {
        bucketCollector.postCollection();
            TermsAggregator termsAggregator = createAggregator(termsAggregationBuilder, indexSearcher, singleValueFieldType);
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        indexWriter.close();
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
 * compatible open source license.
            assertEquals(10, buckets.size());
import org.opensearch.search.aggregations.AggregatorTestCase;
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_FIELD_SCRIPT, Collections.emptyMap())
            }
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));
        assertTrue(aggregator.context().getQueryShardContext().isCacheable());
import java.util.function.Function;
        unmappedDirectory.close();
        MockScriptEngine scriptEngine = new MockScriptEngine(
        }, max -> {
                document.add(pointFieldFunc.apply(nextValue));
        indexWriter.close();
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").field("value")
        IndexWriter indexWriter = new IndexWriter(directory, config);
            indexWriter.addDocument(document);
import static org.opensearch.index.query.QueryBuilders.termQuery;
        indexReader.close();
        assertNotNull(global);
            try (IndexReader reader = DirectoryReader.open(indexWriter)) {
            for (int i = 0; i < numDocs; i++) {
        aggregator.postCollection();
import static java.util.Collections.emptyList;
            assertEquals(Double.NEGATIVE_INFINITY, max.getValue(), 0);
        IndexReader indexReader = DirectoryReader.open(directory);
                    .build(
    protected ScriptService getMockScriptService() {
            () -> randomLongBetween(Integer.MIN_VALUE, Integer.MAX_VALUE),
            }
    private void testAggregation(
            assertFalse(AggregationInspectionHelper.hasValue(max));
        for (int i = 0; i < numDocs; i++) {
            Number res = MaxAggregator.findLeafMaxValue(ctx.reader(), "number", pointConvertFunc);
                AggregationBuilders.filter("filter", termQuery("value", 100)).subAggregation(AggregationBuilders.max("max").field("value"))
 * Unless required by applicable law or agreed to in writing,
                Number nextValue = randomNumber.get();
    public void testMultiValuedFieldWithValueScriptWithParams() throws IOException {
                docID++;
    /**
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);
    /** Script to return the {@code _value} provided by aggs framework. */
        indexSearcher.search(new MatchAllDocsQuery(), bucketCollector);
        params.put("inc", 1);
        );
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
                document.add(new SortedNumericDocValuesField("values", i + 2));
    public void testSingleValuedFieldGetProperty() throws IOException {
        MappedFieldType multiValuesfieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
        aggregator.doReset();
        indexWriter.deleteDocuments(new Term("id", values.get(0).v1().toString()));
        Map<String, Object> params = new HashMap<>();
        Directory directory = newDirectory();
        }, max -> {
        AggregationBuilder aggregationBuilder = AggregationBuilders.global("global")
        BucketCollector bucketCollector = MultiBucketCollector.wrap(maxAggregator, countAggregator);
        final byte[] maxValue = values.getMaxPackedValue();
        }, max -> {
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("_name").field("number");
        }
import org.opensearch.search.aggregations.InternalAggregation;
                Document document = new Document();
import org.apache.lucene.document.Field;
        aggregator.postCollection();
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
            () -> randomDouble(),
        for (int i = 0; i < 10; i++) {
                } else {
 * this work for additional information regarding copyright
import org.opensearch.script.MockScriptEngine;
        }, max -> {
            assertEquals("max", max.getName());
import java.util.HashMap;
        aggregator.preCollection();
        }, fieldType);
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        Directory unmappedDirectory = newDirectory();
                assertTrue(factories.allFactoriesSupportIntraSegmentSearch());
            }
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        );
        int docID = 0;
        }, max -> {
        testAggregation(aggregationBuilder, new FieldExistsQuery("number"), iw -> {
 *    http://www.apache.org/licenses/LICENSE-2.0
        indexWriter.close();
            }
            .subAggregation(
    }
        testAggregation(aggregationBuilder, query, buildIndex, verify, fieldType);
import org.apache.lucene.document.DoublePoint;
                iw.addDocument(document);
        indexReader.close();
    public void testScript() throws IOException {
            public void visit(int docID) {
            .order(BucketOrder.compound(BucketOrder.aggregation("filter>max", true)))
        assertEquals(1, global.getAggregations().asMap().size());
                InternalMax subMax = b.getAggregations().get("sub_max");
    }
import org.opensearch.search.aggregations.AggregationBuilder;
        assertNotNull(buckets);
            final int numDocs = 10;
        indexReader.close();
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));
    public void testSomeMatchesNumericDocValues() throws IOException {
    }
                document.add(new SortedNumericDocValuesField("values", i + 2));
    }
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));
            LeafDocLookup docLookup = (LeafDocLookup) vars.get("doc");
import org.opensearch.search.aggregations.BucketOrder;
        final int numDocs = 10;
    public void testMissingFieldOptimization() throws IOException {
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").field("value")
        Directory unmappedDirectory = newDirectory();
        Directory unmappedDirectory = newDirectory();
    public void testEmptyAggregation() throws Exception {
        assertTrue(AggregationInspectionHelper.hasValue(max));
import org.opensearch.search.aggregations.AggregationBuilders;
            final int numDocs = 10;
            iw.addDocument(emptyList());
            if (vars == null || vars.containsKey("inc") == false) {
                    assertAllDeleted(ctx.reader().getLiveDocs(), ctx.reader().getPointValues("number"));
 * not use this file except in compliance with the License.
            indexWriter.addDocument(document);
            assertTrue(AggregationInspectionHelper.hasValue(max));
        InternalMax result2 = (InternalMax) aggregator.buildAggregation(0L);
            assertEquals(10.0, max.getValue(), 0);
        indexReader.close();
        testMaxShortcutCase(() -> randomFloat(), (n) -> new FloatPoint("number", n.floatValue()), (v) -> FloatPoint.decodeDimension(v, 0));
        };
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
                    );
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
            assertNotNull(count);
            assertTrue(AggregationInspectionHelper.hasValue(max));
        RandomIndexWriter unmappedIndexWriter = new RandomIndexWriter(random(), unmappedDirectory);
            assertTrue(AggregationInspectionHelper.hasValue(max));
import org.opensearch.script.ScriptService;
            document.add(new SortedNumericDocValuesField("values", i + 3));
        testAggregation(aggregationBuilder, new FieldExistsQuery("number"), iw -> {
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").script(
        aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
        scripts.put(SUM_FIELD_PARAMS_SCRIPT, vars -> {
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            for (int i = 0; i < numDocs; i++) {
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
        directory.close();
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").script(
import java.util.ArrayList;
    }
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
            }
        MaxAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
        );
import org.opensearch.search.aggregations.BucketCollector;
        Max max = global.getAggregations().get("max");
        values.intersect(new PointValues.IntersectVisitor() {
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("_name").format("0000.0").field("value");
        assertEquals("max", max.getName());
            assertNotNull(terms);
            documents.add(document);
            Terms terms = (Terms) termsAggregator.buildTopLevel();
            assertTrue(AggregationInspectionHelper.hasValue(max));
        }, fieldType);
            final int numDocs = 10;
import org.opensearch.index.mapper.NumberFieldMapper;
        }, fieldType);
        assertEquals("max", max.getName());
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SUM_FIELD_PARAMS_SCRIPT, params)
        IndexReader indexReader = DirectoryReader.open(directory);
        ValueCountAggregator countAggregator = createAggregator(countAggregationBuilder, indexSearcher, fieldType);
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            scripts,
            assertTrue(AggregationInspectionHelper.hasValue(max));
            List<Long> values = new ArrayList<>();
import org.opensearch.search.aggregations.bucket.terms.Terms;
            for (int i = 0; i < numDocs; i++) {
        MappedFieldType singleValueFieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        IndexWriterConfig config = newIndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE);
            assertEquals("0010.0", max.getValueAsString());
        IndexSearcher indexSearcher = newSearcher(multiReader, true, true);
            // Intentionally not writing any docs
                document.add(new SortedNumericDocValuesField("values", i + 3));
            @Override
public class MaxAggregatorTests extends AggregatorTestCase {
        }, max -> {
            MaxAggregationBuilder maxAggregationBuilder = new MaxAggregationBuilder("max").field("values");
        throws IOException {
            assertTrue(AggregationInspectionHelper.hasValue(max));
        indexReader.close();
    }
        assertEquals(20L, count.getValue());
    public void testUnmappedField() throws IOException {
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
        for (int i = values.size() - 1; i > 0; i--) {
            assertEquals(1L, bucket.getDocCount());
        assertEquals(max, ((InternalAggregation) global).getProperty("max"));
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        }
            TermsAggregationBuilder termsAggregationBuilder = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.NUMERIC)
            }
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").field("value");
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            indexWriter.deleteDocuments(new Term("id", values.get(i).v1().toString()));
            assertEquals((long) i + 1, bucket.getKeyAsNumber());
        indexWriter.close();
    public void testNoMatchingField() throws IOException {
    }
    }
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
import org.apache.lucene.index.DirectoryReader;
        directory.close();
        for (int i = 0; i < numDocs; i++) {
        assertNotNull(global);
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
        Supplier<Number> randomNumber,
        }, fieldType);
        int numValues = atLeast(50);
        IndexReader unamappedIndexReader = DirectoryReader.open(unmappedDirectory);
        Map<String, Function<Map<String, Object>, Object>> nonDeterministicScripts = new HashMap<>();
        assertEquals(10.0, (double) ((InternalAggregation) global).getProperty("max.value"), 0);
import org.apache.lucene.document.FloatPoint;
            assertTrue(AggregationInspectionHelper.hasValue(max));
            bucketCollector.postCollection();
    }
        assertEquals(12.0, max.getValue(), 0);
        }, max -> {
        }, fieldType);
        assertEquals("max", max.getName());
                }
        InternalMax max = (InternalMax) aggregator.buildAggregation(0L);
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }, max -> {
            List<? extends Terms.Bucket> buckets = terms.getBuckets();
        ValueCountAggregationBuilder countAggregationBuilder = new ValueCountAggregationBuilder("count").field("values");
        multiReader.close();
        });
        for (int i = 0; i < numValues; i++) {
    public void testEarlyTermination() throws Exception {
        Directory directory = newDirectory();
        InternalMax result1 = (InternalMax) aggregator.buildAggregation(0L);
 */
        try (IndexReader reader = DirectoryReader.open(indexWriter)) {
        RandomIndexWriter unmappedIndexWriter = new RandomIndexWriter(random(), unmappedDirectory);
        List<Document> documents = new ArrayList<>();
    public void testSupportsIntraSegmentSearch() throws IOException {
        directory.close();
        assertEquals("max", max.getName());
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }, max -> {
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
            assertEquals(max.getValue(), 19.0, 0);
        testAggregation(new MatchAllDocsQuery(), iw -> {
            assertNotNull(bucket);
    public void testSingleValuedFieldPartiallyUnmapped() throws IOException {
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        aggregator.postCollection();
        for (int i = 0; i < numDocs; i++) {
    }
import org.apache.lucene.index.LeafReaderContext;
    public void testSingleValuedFieldWithValueScript() throws IOException {
        });
/*
        params.put("field", "value");
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, SCRIPT_NAME, Collections.emptyMap()));
            for (int i = 0; i < numDocs; i++) {
        aggregationBuilder = new MaxAggregationBuilder("max").field("value")
package org.opensearch.search.aggregations.metrics;
     * Make sure that an aggregation not using a script does get cached.
            final int numDocs = 10;
    public void testQueryFiltersAll() throws IOException {
import org.apache.lucene.index.IndexWriterConfig;
import org.opensearch.search.aggregations.bucket.filter.Filter;
            assertEquals(10.0, max.getValue(), 0);
            ValueCountAggregator countAggregator = createAggregator(countAggregationBuilder, indexSearcher, multiValuesfieldType);
/*
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
import org.apache.lucene.index.MultiReader;
                Document document = new Document();
        directory.close();
        Map<String, Object> params = Collections.singletonMap("inc", 1);
    private final String SCRIPT_NAME = "script_name";
import org.apache.lucene.util.Bits;
        assertEquals(10.0, max.getValue(), 0);
        assertEquals("max", max.getName());
                document.add(new SortedNumericDocValuesField("number", i + 3));
    /** Script to return the value of a field named {@code value}. */
        assertEquals(1, global.getAggregations().asMap().size());
            }
            assertEquals(Double.NEGATIVE_INFINITY, max.getValue(), 0);
            bucketCollector.preCollection();
                iw.addDocument(singleton(new NumericDocValuesField("number", i + 1)));
        GlobalAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
 * software distributed under the License is distributed on an
            .subAggregation(AggregationBuilders.max("max").field("value"));
import org.opensearch.script.ScriptType;
        }, max -> {
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").script(
        TermsAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                .collectMode(collectionMode)
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, params));
        }, max -> {
        assertNotNull(global.getAggregations());
        assertEquals(10.0, max.getValue(), 0);
        }
            }
            }
        Directory directory = newDirectory();
        unmappedDirectory.close();
 * You may obtain a copy of the License at
        aggregator.postCollection();
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").script(
            int numDup = randomIntBetween(1, 3);
        testMaxShortcutCase(
            Document document = new Document();
    public void testMaxShortcutRandom() throws Exception {
import java.util.Arrays;
        unmappedIndexWriter.close();
            LeafReaderContext ctx = reader.leaves().get(0);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
    public void testSingleValuedField() throws IOException {
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        Max max = global.getAggregations().get("max");
import org.opensearch.script.Script;
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
            }
import org.opensearch.search.aggregations.MultiBucketCollector;
            return values;
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
            public void visit(int docID, byte[] packedValue) {
        for (int i = 0; i < numDocs; i++) {
    public static final String VALUE_FIELD_SCRIPT = "value_field";
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        Global global = (Global) aggregator.buildTopLevel();
                iw.addDocument(document);
        List<Tuple<Integer, Number>> values = new ArrayList<>();
        assertFalse(aggregator.context().getQueryShardContext().isCacheable());
        InternalMax max = (InternalMax) aggregator.buildAggregation(0L);
        }
        Collections.sort(values, Comparator.comparingDouble(t -> t.v2().doubleValue()));
        // insert some documents without a value for the metric field.
    public void testOrderByEmptyAggregation() throws IOException {
    }
        }
                document.add(new SortedNumericDocValuesField("values", i + 2));
    }
            assertEquals("max", max.getName());
import static java.util.Collections.singleton;
            assertEquals(11.0, max.getValue(), 0);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);
    }
                assertFalse(liveDocs.get(docID));
        assertEquals("count", count.getName());
/*
import org.apache.lucene.document.SortedNumericDocValuesField;
        }
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            assertEquals(0L, filter.getDocCount());
            assertTrue(AggregationInspectionHelper.hasValue(max));
            .subAggregation(AggregationBuilders.max("max").field("value"));
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
    @Override
        directory.close();
        aggregator.preCollection();
 * The OpenSearch Contributors require contributions made to
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("_name").field("number").missing(19L);
        }
        indexWriter.close();
            }
        final boolean[] seen = new boolean[1];
        InternalMax max = (InternalMax) aggregator.buildAggregation(0L);
            for (int i = 0; i < numDocs; i++) {
                .subAggregation(new MaxAggregationBuilder("sub_max").field("invalid"));
    /** Script to take a field name in params and sum the values of the field. */
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);
            Collections.emptyMap()
        assertNotNull(terms);
import java.io.IOException;
            assertThat(res, equalTo(null));
        assertNotNull(max);
                .field("value")
        assertEquals(Double.NEGATIVE_INFINITY, max.getValue(), 0);
        for (int i = 0; i < numDocs; i++) {
            for (int i = 0; i < numDocs; i++) {
        multiReader.close();
            final int numDocs = 10;
            Document document = new Document();
            Max max = filter.getAggregations().get("max");
        aggregator.preCollection();
    private void testMaxShortcutCase(
                }
            @Override
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        MaxAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
            Terms.Bucket bucket = buckets.get(i);
    ) throws IOException {
        IndexReader unamappedIndexReader = DirectoryReader.open(unmappedDirectory);
            for (int i = 0; i < numDocs; i++) {
        IndexReader indexReader = DirectoryReader.open(directory);
        RandomIndexWriter unmappedIndexWriter = new RandomIndexWriter(random(), unmappedDirectory);
        // Test that an aggregation using a nondeterministic script does not get cached
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
            assertTrue(AggregationInspectionHelper.hasValue(max));
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 7)));
import java.util.function.BiFunction;
    public void testScriptMultiValuedWithParams() throws IOException {
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
    }
        assertEquals(10L, global.getDocCount());
            assertEquals(11.0, max.getValue(), 0);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        // Test that an aggregation using a script does not get cached
    }
            assertTrue(AggregationInspectionHelper.hasValue(max));
        Directory directory = newDirectory();
                    assertThat(res, equalTo(values.get(i - 1).v2()));
import org.opensearch.index.mapper.MappedFieldType;
            assertEquals("max", max.getName());
        }, (MappedFieldType) null);
        });
        testAggregation(new MatchAllDocsQuery(), iw -> {
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
 * this file be licensed under the Apache-2.0 license or a
    private final long SCRIPT_VALUE = 19L;
    public void testSingleValuedFieldWithFormatter() throws IOException {
        InternalMax max = (InternalMax) maxAggregator.buildAggregation(0L);
        });
            MaxAggregator maxAggregator = createAggregator(maxAggregationBuilder, indexSearcher, multiValuesfieldType);
        assertEquals(0L, global.getDocCount());
        final int numDocs = 10;
    }
        });
        for (int i = 0; i < 3; i++) {
            try (IndexReader reader = indexWriter.getReader()) {
        });
        assertEquals(10.0, (double) ((InternalAggregation) max).getProperty("value"), 0);
            int inc = getInc.apply(vars);
            (n) -> new DoublePoint("number", n.doubleValue()),
import org.opensearch.search.aggregations.support.ValueType;
        assertNotNull(count);
    /** Script to return a random double */
    }
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
    }
            assertThat(res, equalTo(values.get(values.size() - 1).v2()));
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
    }
                document.add(new SortedNumericDocValuesField("values", i + 3));
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
    public void testScriptSingleValued() throws IOException {
                Document document = new Document();
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
import org.opensearch.search.aggregations.Aggregator;
    public static final String VALUE_SCRIPT = "_value";
 * Modifications Copyright OpenSearch Contributors. See
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
        IndexReader indexReader = DirectoryReader.open(directory);
            final int numDocs = 10;
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
            final int numDocs = 10;
        directory.close();
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
}
        assertEquals(10.0, max.getValue(), 0);
            for (int i = 0; i < numDocs; i++) {
    }
        indexWriter.close();
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").field("values")
        AggregationBuilder aggregationBuilder = new MaxAggregationBuilder("_name").field("number").missing(19L);
 * license agreements. See the NOTICE file distributed with
    }
import org.opensearch.search.aggregations.support.ValuesSourceType;
    public void testCacheAggregation() throws IOException {
    @Override
        indexWriter.addDocuments(documents);
            assertEquals(12.0, max.getValue(), 0);
            assertEquals(Double.NEGATIVE_INFINITY, max.getValue(), 0);
        );
        assertNotNull(global.getAggregations());
            assertEquals(12.0, max.getValue(), 0);
            assertNotNull(max);
            assertEquals(20L, count.getValue());
    public void testSomeMatchesSortedNumericDocValues() throws IOException {
            Number res = MaxAggregator.findLeafMaxValue(ctx.reader(), "number", pointConvertFunc);
        directory.close();
        indexWriter.close();
        }
import org.opensearch.common.settings.Settings;
        }
        }, fieldType);
     * Make sure that a request using a deterministic script or not using a script get cached.
import org.apache.lucene.index.IndexWriter;
            assertEquals(max.getValue(), SCRIPT_VALUE, 0); // Note this is the script value (19L), not the doc values above
 * ownership. Elasticsearch licenses this file to you under
                values.add(((Number) v).longValue() + inc);
    public void testScriptCaching() throws Exception {
    public void testScriptSingleValuedWithParams() throws IOException {
        }, fieldType);
                assertEquals(Double.NEGATIVE_INFINITY, subMax.getValue(), 0);
            nonDeterministicScripts,
import java.util.Map;
    public void testNestedEarlyTermination() throws Exception {
        }, fieldType);
    public void testQueryFiltering() throws IOException {
    }
    }
 * the Apache License, Version 2.0 (the "License"); you may
    }
                    return PointValues.Relation.CELL_CROSSES_QUERY;
            indexSearcher.search(new MatchAllDocsQuery(), bucketCollector);
                return ((Number) vars.get("inc")).intValue();
        );
        testMaxShortcutCase(() -> randomInt(), (n) -> new IntPoint("number", n.intValue()), (v) -> IntPoint.decodeDimension(v, 0));
        Function<Number, Field> pointFieldFunc,
    public void testMultiValuedField() throws IOException {
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("_name").field("number");
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 1)));
            }
        nonDeterministicScripts.put(RANDOM_SCRIPT, vars -> MaxAggregatorTests.randomDouble());
     */
        });
        int numBytes = values.getBytesPerDimension();
        MultiReader multiReader = new MultiReader(indexReader, unamappedIndexReader);
            assertEquals(10.0, max.getValue(), 0);
        indexWriter.addDocument(singleton(new NumericDocValuesField("value", 10)));
            MockScriptEngine.NAME,
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        });
        // Do not add any documents
        aggregator.postCollection();
        }, max -> {
            final int numDocs = 10;
            }
        directory.close();
        Directory directory = newDirectory();
     */
        IndexReader indexReader = DirectoryReader.open(directory);
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 1)));
        Function<byte[], Number> pointConvertFunc
                LeafReaderContext ctx = reader.leaves().get(0);
                iw.addDocument(document);
            (v) -> DoublePoint.decodeDimension(v, 0)
    }
            }
    public static final String SUM_VALUES_FIELD_SCRIPT = "sum_values_field";
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").field("values")
        AggregationBuilder aggregationBuilder = new MaxAggregationBuilder("_name").field("number")
            (n) -> new LongPoint("number", n.longValue()),
        }, fieldType);
        assertEquals(10.0, result1.getValue(), 0);
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.emptyMap()));
        scripts.put(VALUE_SCRIPT, vars -> {
        testAggregation(IntPoint.newRangeQuery("number", 0, 5), iw -> {
    }
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        IndexSearcher indexSearcher = newSearcher(multiReader, true, true);
            document.add(new SortedNumericDocValuesField("values", i + 2));
            assertNotNull(filter);
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                IndexSearcher searcher = newIndexSearcher(reader);
import java.util.Collections;
            @Override
import org.opensearch.script.ScriptModule;
        MaxAggregator maxAggregator = createAggregator(maxAggregationBuilder, indexSearcher, fieldType);
            return ((Number) vars.get("_value")).doubleValue() + inc;
                if (res != null) {
     * Ensure requests using nondeterministic scripts do not get cached.
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SUM_FIELD_PARAMS_SCRIPT, params)
        Terms terms = (Terms) aggregator.buildTopLevel();
        }, max -> {
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, RANDOM_SCRIPT, Collections.emptyMap()));
        Directory directory = newDirectory();
 *
        );
            return sum.apply(vars, fieldname);
    public void testDoReset() throws IOException {
                document.add(new SortedNumericDocValuesField("values", i + 2));
        params.put("field", "values");
        aggregator.preCollection();
    public void testSingleValuedFieldWithValueScriptWithParams() throws IOException {
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SUM_VALUES_FIELD_SCRIPT, Collections.emptyMap())
        MaxAggregationBuilder maxAggregationBuilder = new MaxAggregationBuilder("max").field("values");
            assertEquals(12.0, max.getValue(), 0);
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, params));
    private void assertAllDeleted(Bits liveDocs, PointValues values) throws IOException {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        });
        MaxAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
 *
        testAggregation(new MatchAllDocsQuery(), iw -> {
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            final int numDocs = 10;
        IndexReader indexReader = DirectoryReader.open(directory);
        indexWriter.close();
import org.apache.lucene.search.Query;
    }
            assertTrue(AggregationInspectionHelper.hasValue(max));
            LeafReaderContext ctx = reader.leaves().get(0);
            }
                Number res = MaxAggregator.findLeafMaxValue(ctx.reader(), "number", pointConvertFunc);
        assertTrue(seen[0]);
import org.apache.lucene.index.Term;
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
    }
        testAggregation(new FieldExistsQuery("number"), iw -> {
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").field("value");
        IndexSearcher indexSearcher = newSearcher(multiReader, true, true);
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        MappedFieldType fieldType
        Query query,
        Directory directory = newDirectory();
                    .addAggregator(new MaxAggregationBuilder("test").field("value"))
            assertNotNull(max);
            assertTrue(AggregationInspectionHelper.hasValue(max));
        Directory directory = newDirectory();
import org.opensearch.common.CheckedConsumer;
    public void testNoDocs() throws IOException {
            }
import org.opensearch.search.aggregations.bucket.global.Global;
                if (Arrays.equals(maxPackedValue, 0, numBytes, maxValue, 0, numBytes)) {
                iw.addDocument(document);
            assertEquals(13.0, max.getValue(), 0);
                AggregatorFactories factories = AggregatorFactories.builder()
            assertEquals("count", count.getName());
            for (Object v : docLookup.get(fieldname)) {
        assertTrue(AggregationInspectionHelper.hasValue(max));
            assertEquals(max.getValue(), 19.0, 0);
            int inc = getInc.apply(vars);
            assertEquals(Double.NEGATIVE_INFINITY, max.getValue(), 0);
            (v) -> LongPoint.decodeDimension(v, 0)
        for (Aggregator.SubAggCollectionMode collectionMode : Aggregator.SubAggCollectionMode.values()) {
 * KIND, either express or implied.  See the License for the
import java.util.function.Consumer;
        }, max -> {
        indexWriter.addDocument(singleton(new NumericDocValuesField("value", 5)));
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.emptyMap()));
            assertTrue(AggregationInspectionHelper.hasValue(max));
        Directory directory = newDirectory();
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));
            assertFalse(AggregationInspectionHelper.hasValue(max));
        }, fieldType);
                values.add(new Tuple<>(docID, nextValue));
        }
        aggregator.postCollection();
            assertFalse(AggregationInspectionHelper.hasValue(max));
        Directory directory = newDirectory();
            Document document = new Document();
        return new MaxAggregationBuilder("_name").field(fieldName);
 * GitHub history for details.
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            InternalMax max = (InternalMax) maxAggregator.buildTopLevel();
        testAggregation(IntPoint.newRangeQuery("number", -1, 0), iw -> {
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.emptyMap()));
        MaxAggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").field("value")
        InternalValueCount count = (InternalValueCount) countAggregator.buildAggregation(0L);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
                Document document = new Document();
        final int numDocs = 10;
                iw.addDocument(document);
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", 1)));
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        scripts.put(SUM_VALUES_FIELD_SCRIPT, vars -> sum.apply(vars, "values"));
        assertEquals("max", max.getName());
            assertEquals(7, max.getValue(), 0);
                document.add(new StringField("id", Integer.toString(docID), Field.Store.NO));
        IndexReader unamappedIndexReader = DirectoryReader.open(unmappedDirectory);
            for (Terms.Bucket b : buckets) {
        final int numDocs = 10;
import org.apache.lucene.search.FieldExistsQuery;
            assertEquals(13.0, max.getValue(), 0);
        MultiReader multiReader = new MultiReader(indexReader, unamappedIndexReader);
            document.add(new SortedNumericDocValuesField("values", i + 3));
        aggregator.preCollection();
import org.apache.lucene.document.StringField;
    }
        unmappedIndexWriter.close();
            String fieldname = (String) vars.get("field");
        assertTrue(AggregationInspectionHelper.hasValue(max));
    }
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 1)));
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        assertEquals("global", global.getName());
        max = (InternalMax) aggregator.buildAggregation(0L);
            assertTrue(AggregationInspectionHelper.hasValue(max));
        MultiReader multiReader = new MultiReader(indexReader, unamappedIndexReader);
                document.add(new SortedNumericDocValuesField("values", i + 3));
        });
        assertTrue(max.getValue() <= 1.0);
        aggregator.preCollection();
        };
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        assertEquals("global", global.getName());
            Filter filter = bucket.getAggregations().get("filter");
            }
        IndexReader indexReader = DirectoryReader.open(directory);
            ValueCountAggregationBuilder countAggregationBuilder = new ValueCountAggregationBuilder("count").field("values");
        MaxAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
            public PointValues.Relation compare(byte[] minPackedValue, byte[] maxPackedValue) {
import org.opensearch.search.aggregations.AggregatorFactories;
            InternalValueCount count = (InternalValueCount) countAggregator.buildTopLevel();
                            .getQueryShardContext(),
    public void testMultiValuedFieldWithValueScript() throws IOException {
        assertEquals(Double.NEGATIVE_INFINITY, result2.getValue(), 0);
        Global global = (Global) aggregator.buildTopLevel();
                throw new AssertionError();
                documents.add(document);
            assertTrue(AggregationInspectionHelper.hasValue(max));
    }
    }
import org.apache.lucene.tests.index.RandomIndexWriter;
        }
            document.add(new SortedNumericDocValuesField("values", i + 2));
            assertTrue(AggregationInspectionHelper.hasValue(max));
        }, max -> {
            assertEquals(10, max.getValue(), 0);
        final int numDocs = 10;
        }, max -> {
            }
    ) throws IOException {
            }
import static org.hamcrest.Matchers.equalTo;
            assertEquals(7, max.getValue(), 0);
            assertNotNull(buckets);
    public static final String RANDOM_SCRIPT = "Math.random()";
 *
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        aggregator.preCollection();
    }
        scripts.put(VALUE_FIELD_SCRIPT, vars -> sum.apply(vars, "value"));
        IndexReader indexReader = DirectoryReader.open(directory);
import org.apache.lucene.document.NumericDocValuesField;
            document.add(new NumericDocValuesField("value", i + 1));
        IndexReader indexReader = DirectoryReader.open(directory);
        for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.search.MatchAllDocsQuery;
        multiReader.close();
    @Override
        }
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        AggregationBuilder aggregationBuilder = new MaxAggregationBuilder("max").field("value");
                Document document = new Document();
        assertEquals(10.0, max.getValue(), 0);
import org.opensearch.search.lookup.LeafDocLookup;
        AggregationBuilder aggregationBuilder = AggregationBuilders.global("global")
        }
                Document document = new Document();
                return 0;
 * under the License.
 */
        testAggregation(new FieldExistsQuery("number"), iw -> {
            } else {
            for (int i = 0; i < numDocs; i++) {
    public static final String SUM_FIELD_PARAMS_SCRIPT = "sum_field_params";
        scripts.put(SCRIPT_NAME, script -> SCRIPT_VALUE);
        unmappedDirectory.close();
        assertEquals("max", max.getName());
        Function<Map<String, Object>, Integer> getInc = vars -> {
        assertTrue(AggregationInspectionHelper.hasValue(max));
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 1)));
            assertTrue(AggregationInspectionHelper.hasValue(max));
        indexWriter.close();
            assertEquals(max.getValue(), Double.NEGATIVE_INFINITY, 0);
import org.apache.lucene.index.NoMergePolicy;
        aggregator.preCollection();
        GlobalAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
import java.util.List;
    }
        assertEquals(10, buckets.size());
            assertFalse(AggregationInspectionHelper.hasValue(max));
        aggregator.postCollection();
        TermsAggregationBuilder aggregationBuilder = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.NUMERIC)
        assertTrue(aggregator.context().getQueryShardContext().isCacheable());
        }, max -> {
import org.apache.lucene.index.PointValues;
                return PointValues.Relation.CELL_OUTSIDE_QUERY;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        aggregator.postCollection();
    private void testAggregation(Query query, CheckedConsumer<RandomIndexWriter, IOException> buildIndex, Consumer<InternalMax> verify)
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
            final int numDocs = 10;
        AggregationBuilder aggregationBuilder,
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
        testAggregation(new MatchAllDocsQuery(), iw -> {
        BiFunction<Map<String, Object>, String, Object> sum = (vars, fieldname) -> {
