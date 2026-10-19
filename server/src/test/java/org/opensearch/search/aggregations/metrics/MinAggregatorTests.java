import org.opensearch.index.query.QueryShardContext;
            unmappedIndexWriter.close();
        );
import org.opensearch.index.mapper.NumberFieldMapper;
    public void testUnmappedWithMissingField() throws IOException {
            return sum.apply(vars, fieldname);
    /** Script to return the {@code _value} provided by aggs framework. */
            for (Object v : docLookup.get(fieldname)) {
        Directory directory = newDirectory();
                IndexReader indexReader = DirectoryReader.open(directory);
        };
            MockScriptEngine.NAME,
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, RANDOM_SCRIPT, Collections.emptyMap()));
                InternalMin min = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), aggregationBuilder, fieldType);
    }
            assertEquals(19.0, min.getValue(), 0);
            InternalMin min = (InternalMin) global.getAggregations().asMap().get("min");
            LeafDocLookup docLookup = (LeafDocLookup) vars.get("doc");
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
                document.add(new SortedNumericDocValuesField("number", i + 2));
        scripts.put(SCRIPT_NAME, script -> SCRIPT_VALUE);
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number")
    public void testNoMatchingField() throws IOException {
            }
                assertEquals(2.0, min.getValue(), 0);
            assertEquals(2.0, min.getValue(), 0);
    }
    ) {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
        }, fieldType);
            }
                IndexReader unamappedIndexReader = DirectoryReader.open(unmappedDirectory)
            iw.addDocument(singleton(new NumericDocValuesField("number", 3)));
    }
                document.add(new SortedNumericDocValuesField("number", i + 3));
        testCase(new FieldExistsQuery("number"), iw -> {
        indexWriter.deleteDocuments(new Term("id", values.get(values.size() - 1).v1().toString()));
import org.opensearch.search.aggregations.AggregationBuilder;
 * compatible open source license.
            LeafReaderContext ctx = reader.leaves().get(0);
            final int numDocs = 10;
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
    }
import static org.opensearch.index.query.QueryBuilders.termQuery;
            assertTrue(AggregationInspectionHelper.hasValue(min));
        }, (Consumer<InternalMin>) min -> {
                iw.addDocument(singleton(new SortedSetDocValuesField("string", new BytesRef("foo"))));
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }, (Consumer<InternalMin>) min -> { fail("Should have thrown exception"); }, fieldType));
        testCase(IntPoint.newRangeQuery("number", 0, 3), iw -> {
            assertThat(res, equalTo(null));
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number")
    public void testCaching() throws IOException {
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 2)));
            assertThat(global.getProperty("min.value"), equalTo(1.0));
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", 1)));
 */
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 3)));
        try (Directory directory = newDirectory()) {
import org.apache.lucene.index.MultiReader;
    private final String SCRIPT_NAME = "script_name";
    }
        }, (Consumer<InternalMin>) min -> {
    /** Script to return the value of a field named {@code value}. */
            try (
        }
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number").missing("not_a_number");
    public void testSingleValuedFieldWithValueScriptAndMissing() throws IOException {
            RandomIndexWriter unmappedIndexWriter = new RandomIndexWriter(random(), unmappedDirectory);
        }, min -> {
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 7)));
import org.apache.lucene.document.SortedSetDocValuesField;
import org.opensearch.script.ScriptModule;
    }
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number").format("0000.0");
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
import org.opensearch.search.aggregations.bucket.histogram.InternalHistogram;
        MapperService mapperService,
        testCase(IntPoint.newRangeQuery("number", -1, 0), iw -> {
            final int numDocs = 10;
            iw.addDocument(Arrays.asList(new IntPoint("number", 3), new SortedNumericDocValuesField("number", 3)));
                InternalMin min = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), aggregationBuilder, fieldType);
            }
    public void testFormatter() throws IOException {
            }
            iw.addDocument(singleton(new NumericDocValuesField("unrelated", 1)));
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 7)));
            assertEquals(1.0, min.getValue(), 0);
        Directory directory = newDirectory();
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
 * software distributed under the License is distributed on an
                iw.addDocument(singleton(new NumericDocValuesField("number", i + 1)));
        }, min -> {
    @Override
import org.opensearch.common.collect.Tuple;
            }
        }, fieldType);
        }, min -> fail("expected an exception"), fieldType));
            iw.addDocument(singleton(new SortedNumericDocValuesField("number2", 2)));
            assertEquals(0.0, min.getValue(), 0);
                IndexSearcher indexSearcher = newSearcher(multiReader, true, true);
                assertEquals(Double.POSITIVE_INFINITY, min.getValue(), 0);
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 3)));
import org.opensearch.search.aggregations.AggregatorFactories;
            assertEquals(7.0, min.getValue(), 0);
        BiFunction<Map<String, Object>, String, Object> sum = (vars, fieldname) -> {
                assertEquals(1L, bucket.getDocCount());
            assertEquals(1, min.getValue(), 0);
                Document document = new Document();
    public void testSingleValuedFieldPartiallyUnmapped() throws IOException {
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.util.BytesRef;
import java.util.Map;
    private static final String SUM_VALUES_FIELD_SCRIPT = "sum_values_field";
                assertEquals(-19.0, min.getValue(), 0);
    private final long SCRIPT_VALUE = 19L;
        try (Directory directory = newDirectory(); Directory unmappedDirectory = newDirectory()) {
                Terms.Bucket bucket = buckets.get(i);
        indexReader.close();
                assertEquals(-7.0, min.getValue(), 0);
                assertTrue(factories.allFactoriesSupportIntraSegmentSearch());
                document.add(new StringField("id", Integer.toString(docID), Field.Store.NO));
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
public class MinAggregatorTests extends AggregatorTestCase {
        });
                        null
import java.util.HashMap;
            Number res = MinAggregator.findLeafMinValue(ctx.reader(), "number", pointConvertFunc);
            assertTrue(AggregationInspectionHelper.hasValue(min));
                InternalMin min = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), aggregationBuilder, fieldType);
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)
        indexWriter.addDocument(singleton(new NumericDocValuesField("value", 5)));
            assertThat(res, equalTo(values.get(0).v2()));
    public void testSomeMatchesNumericDocValues() throws IOException {
        });
                assertEquals(2.0, min.getValue(), 0);
            }
        }, (Consumer<InternalMin>) min -> {
                assertNotNull(filter);
                iw.addDocument(singleton(new NumericDocValuesField("number", i + 1)));
        indexWriter.addDocuments(documents);
        });
import org.opensearch.script.MockScriptEngine;
                document.add(new SortedNumericDocValuesField("number", i + 3));
        nonDeterministicScripts.put(RANDOM_SCRIPT, vars -> AggregatorTestCase.randomDouble());
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("not_a_number");
import org.opensearch.index.IndexSettings;
        IndexWriterConfig config = newIndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE);
            assertFalse(AggregationInspectionHelper.hasValue(min));
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
        assertEquals(5.0, result1.getValue(), 0);
            assertTrue(AggregationInspectionHelper.hasValue(min));
        });
    public void testMinShortcutRandom() throws Exception {
    }
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            documents.add(document);
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
        }, fieldType);
import org.opensearch.search.aggregations.bucket.filter.Filter;
        try (IndexReader reader = DirectoryReader.open(indexWriter)) {
 * The OpenSearch Contributors require contributions made to
        aggregator.postCollection();
            RandomIndexWriter unmappedIndexWriter = new RandomIndexWriter(random(), unmappedDirectory);
                Number res = MinAggregator.findLeafMinValue(ctx.reader(), "number", pointConvertFunc);
            assertTrue(AggregationInspectionHelper.hasValue(min));
import org.apache.lucene.document.FloatPoint;
 * under the License.
import org.apache.lucene.search.FieldExistsQuery;
import java.io.IOException;
    }
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("not_a_number");
    public void testSomeMatchesSortedNumericDocValues() throws IOException {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
    private void testMinShortcutCase(
            assertEquals(Double.POSITIVE_INFINITY, min.getValue(), 0);
            assertThat(histo.getBuckets().size(), equalTo(3));
            assertEquals(2, min.getValue(), 0);
        Map<String, Function<Map<String, Object>, Object>> nonDeterministicScripts = new HashMap<>();
import java.util.function.Function;
                new FilterAggregationBuilder("filter", termQuery("number", 100)).subAggregation(
            assertEquals(-12.0, min.getValue(), 0);
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 3)));
        }, (Consumer<InternalMin>) min -> {
    public void testUnmappedWithBadMissingField() {
            min = (InternalMin) histo.getBuckets().get(2).getAggregations().asMap().get("min");
            assertNotNull(histo.getBuckets().get(0).getAggregations().asMap().get("min"));
        for (int i = 0; i < 3; i++) {
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number")
    }
    private static final String INVERT_SCRIPT = "invert";
    }
        );
        MappedFieldType fieldType = new IpFieldMapper.IpFieldType(fieldName);
    }
    public void testMatchesSortedNumericDocValues() throws IOException {
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
            }
    public void testOrderByEmptyAggregation() throws IOException {
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number")
            } else {
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number");
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
import org.opensearch.script.Script;
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SCRIPT_NAME, Collections.emptyMap())
import org.opensearch.common.CheckedConsumer;
        testMinShortcutCase(
        List<Tuple<Integer, Number>> values = new ArrayList<>();
import org.opensearch.index.mapper.MapperService;
import org.opensearch.search.aggregations.AggregatorTestCase;
        indexWriter.close();
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }
            Document document = new Document();
                    .addAggregator(new MinAggregationBuilder("test").field("value"))
        scripts.put(SUM_VALUES_FIELD_SCRIPT, vars -> sum.apply(vars, "values"));
        Collections.sort(values, Comparator.comparingDouble(t -> t.v2().doubleValue()));
                values.add(new Tuple<>(docID, nextValue));
import org.opensearch.search.aggregations.support.ValuesSourceType;
                iw.addDocument(document);
                assertTrue(min.getValue() >= 0.0 && min.getValue() <= 1.0);
        );
        }, min -> {
        return new MinAggregationBuilder("foo").field(fieldName);
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, INVERT_SCRIPT, Collections.emptyMap()));
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
            indexWriter.close();
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
    }
            IllegalArgumentException.class,
        MinAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
    public void testUnsupportedType() {
            }
            (v) -> DoublePoint.decodeDimension(v, 0)
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("does_not_exist").missing(0L);
            iw.addDocument(Arrays.asList(new IntPoint("number", 3), new SortedNumericDocValuesField("number", 3)));
    public void testMultiValuedFieldWithScript() throws IOException {
    public void testScript() throws IOException {
    public void testSupportsIntraSegmentSearch() throws IOException {
                MultiReader multiReader = new MultiReader(indexReader, unamappedIndexReader);
        }, fieldType);
 * this file be licensed under the Apache-2.0 license or a
    public void testEmptyBucket() throws IOException {
                return 0;
            unmappedIndexWriter.close();
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 7)));
        }, fieldType);
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 1)));
            ) {
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number");
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").script(
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("value");
import org.apache.lucene.index.NoMergePolicy;
                iw.addDocument(singleton(new NumericDocValuesField("number", i + 1)));
            for (int i = 0; i < numDocs; i++) {
                MultiReader multiReader = new MultiReader(indexReader, unamappedIndexReader);
        }, fieldType);
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, INVERT_SCRIPT, Collections.emptyMap()));
            }
            assertTrue(AggregationInspectionHelper.hasValue(min));
import org.opensearch.script.ScriptService;
    public void testBadMissingField() {
        }
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
import org.apache.lucene.search.MatchAllDocsQuery;
            iw.addDocument(singleton(new SortedSetDocValuesField(fieldName, new BytesRef(InetAddressPoint.encode(randomIp(v4))))));
            .subAggregation(new MinAggregationBuilder("min").field("number"));
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number")
                IndexSearcher searcher = newIndexSearcher(reader);
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(1.0, min.getValue(), 0);
import org.apache.lucene.document.Field;
import org.opensearch.common.util.BigArrays;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
    }
                    .build(
            assertNotNull(histo.getBuckets().get(1).getAggregations().asMap().get("min"));
            indexWriter.close();
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
                documents.add(document);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
                iw.addDocument(singleton(new NumericDocValuesField("number", i + 1)));
            indexWriter.deleteDocuments(new Term("id", values.get(i - 1).v1().toString()));
 * the Apache License, Version 2.0 (the "License"); you may
        }
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
                assertNotNull(min);
        }, min -> {
            assertFalse(AggregationInspectionHelper.hasValue(min));
        Function<byte[], Number> pointConvertFunc
    }
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
import org.opensearch.search.aggregations.bucket.terms.Terms;
        });
        }, (Consumer<InternalMin>) min -> {
            Number res = MinAggregator.findLeafMinValue(ctx.reader(), "number", pointConvertFunc);
            int inc = getInc.apply(vars);
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    private static final String RANDOM_SCRIPT = "random";
                values.add(((Number) v).longValue() + inc);
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field(fieldName);
            final int numDocs = 10;
        );
            for (int i = 0; i < numDocs; i++) {
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
            assertTrue(AggregationInspectionHelper.hasValue(global));
            }
        }, fieldType);
            if (vars == null || vars.containsKey("inc") == false) {
        assertEquals(Double.POSITIVE_INFINITY, result2.getValue(), 0);
        int numDocs = 10;
        }, fieldType);
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
import org.apache.lucene.store.Directory;
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        GlobalAggregationBuilder globalBuilder = new GlobalAggregationBuilder("global").subAggregation(
            try (IndexReader reader = DirectoryReader.open(indexWriter)) {
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("does_not_exist").missing("not_a_number");
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.singletonMap("inc", 5)));
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 7)));
    }
 * Licensed to Elasticsearch under one or more contributor
    private static final String VALUE_SCRIPT = "_value";
                    );
            new MinAggregationBuilder("min").field("number")
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 3)));
                assertTrue(queryShardContext.isCacheable());
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
import org.opensearch.search.aggregations.bucket.terms.InternalTerms;
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 7)));
            for (int i = 0; i < numDocs; i++) {
    }
                document.add(new SortedNumericDocValuesField("number", i + 3));
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 3)));
        this.queryShardContext = super.queryShardContextMock(searcher, mapperService, indexSettings, circuitBreakerService, bigArrays);
            try (
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
import org.apache.lucene.index.IndexWriterConfig;
 * SPDX-License-Identifier: Apache-2.0
        }
                Number nextValue = randomNumber.get();
            ) {
            try (IndexReader reader = indexWriter.getReader()) {
    }
                LeafReaderContext ctx = reader.leaves().get(0);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
    }
                document.add(pointFieldFunc.apply(nextValue));
 * Modifications Copyright OpenSearch Contributors. See
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
            final int numDocs = 10;
        testCase(new FieldExistsQuery("number"), iw -> {
            return values;
    public void testSingleValuedFieldWithValueScriptAndParams() throws IOException {
package org.opensearch.search.aggregations.metrics;
            assertTrue(AggregationInspectionHelper.hasValue(min));
import org.opensearch.index.mapper.KeywordFieldMapper;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
            assertEquals(3.0, min.getValue(), 0);
/*
                assertFalse(queryShardContext.isCacheable());
            iw.addDocument(singleton(new NumericDocValuesField("number", 3)));
            assertEquals(3, min.getValue(), 0);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.List;
            assertTrue(AggregationInspectionHelper.hasValue(min));
        aggregator.doReset();
    }
                Document document = new Document();
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number")
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
            assertTrue(AggregationInspectionHelper.hasValue(min));
            assertTrue(AggregationInspectionHelper.hasValue(min));
            scripts,
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 2)));
    public void testDoReset() throws IOException {
            indexWriter.close();
        indexWriter.addDocument(singleton(new NumericDocValuesField("value", 10)));
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
                AggregatorFactories factories = AggregatorFactories.builder()
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 2)));
    }
    protected ScriptService getMockScriptService() {
            assertFalse(AggregationInspectionHelper.hasValue(min));
        IndexSearcher searcher,
            assertEquals(3, min.getValue(), 0);
        }
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);
            nonDeterministicScripts,
        }, (Consumer<InternalMin>) min -> {
        final String fieldName = "IP_field";
                iw.addDocument(document);
import org.opensearch.index.mapper.IpFieldMapper;
            for (int i = 0; i < numDocs; i++) {
 * ownership. Elasticsearch licenses this file to you under
    }
                assertEquals((long) i + 1, bucket.getKeyAsNumber());
            assertEquals(Double.POSITIVE_INFINITY, min.getValue(), 0);
        testCase(termsBuilder, new MatchAllDocsQuery(), iw -> {
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        );
                assertTrue(AggregationInspectionHelper.hasValue(min));
            final int numDocs = 10;
        indexWriter.close();
    private static final String SUM_FIELD_PARAMS_SCRIPT = "sum_field_params";
            assertEquals("0001.0", min.getValueAsString());
                            .getQueryShardContext(),
                assertTrue(AggregationInspectionHelper.hasValue(min));
            iw.addDocument(singleton(new SortedSetDocValuesField(fieldName, new BytesRef(InetAddressPoint.encode(randomIp(v4))))));
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
import java.util.Arrays;
    @Override
 *
        };
import static org.hamcrest.Matchers.equalTo;
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
            assertNotNull(histo.getBuckets().get(2).getAggregations().asMap().get("min"));
 * this work for additional information regarding copyright
            assertTrue(AggregationInspectionHelper.hasValue(min));
        }, (Consumer<InternalHistogram>) histo -> {
            return ((Number) vars.get("_value")).doubleValue() + inc;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
        }, fieldType);
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 1)));
                assertTrue(queryShardContext.isCacheable());
import org.opensearch.core.indices.breaker.CircuitBreakerService;
import org.opensearch.search.aggregations.BucketOrder;
                    new MinAggregationBuilder("min").field("number")
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.singletonMap("inc", 5)));
    }
        testMinShortcutCase(() -> randomInt(), (n) -> new IntPoint("number", n.intValue()), (v) -> IntPoint.decodeDimension(v, 0));
                List<LongTerms.Bucket> buckets = terms.getBuckets();
        HistogramAggregationBuilder histogram = new HistogramAggregationBuilder("histo").field("number")
            assertEquals(2, min.getValue(), 0);
                assertFalse(AggregationInspectionHelper.hasValue(min));
        testCase(new MatchAllDocsQuery(), iw -> {
            );
                Document document = new Document();
            final int numDocs = 10;
            int inc = getInc.apply(vars);
            }
            assertEquals(1.0, min.getValue(), 0);
                assertNotNull(bucket);
        Function<Number, Field> pointFieldFunc,
import org.opensearch.search.aggregations.bucket.global.InternalGlobal;
    @Override
        for (int i = 1; i < values.size(); i++) {
import org.opensearch.script.ScriptType;
        for (int i = 0; i < numValues; i++) {
import org.apache.lucene.document.IntPoint;
                indexSearcher = newSearcher(indexReader, true, true);
 */
    }
        }, (Consumer<InternalMin>) min -> {
            for (int i = 0; i < numDocs; i++) {
            unmappedIndexWriter.addDocument(singleton(new NumericDocValuesField("unrelated", 100)));
    }
        scripts.put(VALUE_SCRIPT, vars -> {
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number").missing(-19L);
        }
        // insert some documents without a value for the metric field.
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
        }, fieldType);
import org.apache.lucene.search.Query;
        }, fieldType);
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, INVERT_SCRIPT, Collections.emptyMap()));
            }
                assertTrue(AggregationInspectionHelper.hasValue(min));
    /** Script to sum the values of a field named {@code values}. */
    }
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
        MockScriptEngine scriptEngine = new MockScriptEngine(
        IndexReader indexReader = DirectoryReader.open(directory);
 * GitHub history for details.
        }, (Consumer<InternalMin>) min -> {
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
                assertTrue(AggregationInspectionHelper.hasValue(min));
                IndexSearcher indexSearcher = newSearcher(multiReader, true, true);
import java.util.Collections;
}
        scripts.put(INVERT_SCRIPT, vars -> -((Number) vars.get("_value")).doubleValue());
            Collections.emptyMap()
    public void testSingleValuedFieldWithValueScript() throws IOException {
    public void testQueryFiltering() throws IOException {
            assertEquals(-100.0, min.getValue(), 0); // Note: this comes straight from missing, and is not inverted from script
 *
        });
 */
            min = (InternalMin) histo.getBuckets().get(1).getAggregations().asMap().get("min");
import org.apache.lucene.document.InetAddressPoint;
        IndexWriter indexWriter = new IndexWriter(directory, config);
        IllegalArgumentException e = expectThrows(
                document.add(new SortedNumericDocValuesField("number", i + 2));
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number");
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            .minDocCount(0)
            final int numDocs = 10;
            }
    public void testMultiValuedFieldWithScriptParams() throws IOException {
            }, (Consumer<InternalMin>) min -> { fail("Should have thrown exception"); }, fieldType)
        });
                min = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), aggregationBuilder, fieldType);
            assertTrue(AggregationInspectionHelper.hasValue(min));
    }
        int numValues = atLeast(50);
        int docID = 0;
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
        }, (Consumer<InternalTerms<?, LongTerms.Bucket>>) terms -> {
        try (Directory directory = newDirectory()) {
            assertEquals(2, global.getDocCount());
    /** Script to take a field name in params and sum the values of the field. */
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
        List<Document> documents = new ArrayList<>();
    }
            List<Long> values = new ArrayList<>();
                iw.addDocument(singleton(new NumericDocValuesField("number", i + 1)));
        testCase(new MatchAllDocsQuery(), iw -> {
    }
            iw.addDocument(singleton(new NumericDocValuesField("number2", 2)));
            .missing(-100L)
        testCase(histogram, new MatchAllDocsQuery(), iw -> {
        }, (Consumer<InternalMin>) min -> {
        scripts.put(VALUE_FIELD_SCRIPT, vars -> sum.apply(vars, "value"));
        BigArrays bigArrays
    private static final String VALUE_FIELD_SCRIPT = "value_field";
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, INVERT_SCRIPT, Collections.emptyMap()));
                docID++;
            assertEquals(Double.POSITIVE_INFINITY, min.getValue(), 0);
        IndexSettings indexSettings,
import java.util.function.Consumer;
    ) throws IOException {
                InternalMin min = filter.getAggregations().get("min");
        });
        InternalMin result1 = (InternalMin) aggregator.buildAggregation(0L);
        });
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
import org.opensearch.search.lookup.LeafDocLookup;
        testCase(globalBuilder, new MatchAllDocsQuery(), iw -> {
                document.add(pointFieldFunc.apply(nextValue));
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 3)));
            .subAggregation(
    }
        MinAggregationBuilder nonDeterministicAggregationBuilder = new MinAggregationBuilder("min").field("number")
 * You may obtain a copy of the License at
    @Override
        }, (Consumer<InternalMin>) min -> { fail("Should have thrown exception"); }, fieldType));
            for (int j = 0; j < numDup; j++) {
import org.apache.lucene.index.IndexReader;
            () -> randomLongBetween(Integer.MIN_VALUE, Integer.MAX_VALUE),
                IndexReader indexReader = DirectoryReader.open(directory);
        }
    }
            }
                return ((Number) vars.get("inc")).intValue();
    private QueryShardContext queryShardContext;
import org.opensearch.common.settings.Settings;
    public void testSingleValuedFieldPartiallyUnmappedWithMissing() throws IOException {
        }, min -> {
    }
            assertThat(global.getProperty("min"), equalTo(min));
import org.apache.lucene.document.LongPoint;
            for (int i = 0; i < numDocs; i++) {
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
                Filter filter = bucket.getAggregations().get("filter");
                IndexReader unamappedIndexReader = DirectoryReader.open(unmappedDirectory)
            LeafReaderContext ctx = reader.leaves().get(0);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
        boolean v4 = randomBoolean();
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
import java.util.function.BiFunction;
                iw.addDocument(document);
            assertEquals(6.0, min.getValue(), 0);
        return Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN);
        AggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("number")
    public void testQueryFiltersAll() throws IOException {
 * KIND, either express or implied.  See the License for the
            String fieldname = (String) vars.get("field");
            () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }, (Consumer<InternalGlobal>) global -> {
import org.apache.lucene.document.SortedNumericDocValuesField;
    }
import org.apache.lucene.document.NumericDocValuesField;
            }
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 7)));
    }
import static java.util.Collections.singleton;
    protected QueryShardContext queryShardContextMock(
            .interval(1)
        }
        try (Directory directory = newDirectory(); Directory unmappedDirectory = newDirectory()) {
 * Unless required by applicable law or agreed to in writing,
 *
        throws IOException {
import org.apache.lucene.index.DirectoryReader;
        }, min -> {
    public void testGetProperty() throws IOException {
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 2)));
import org.opensearch.script.ScriptEngine;
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        InternalMin result2 = (InternalMin) aggregator.buildAggregation(0L);
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
import org.apache.lucene.document.Document;
import java.util.function.Supplier;
        aggregator.preCollection();
        testCase(new MatchAllDocsQuery(), iw -> {
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
/*
            () -> randomDouble(),
        return queryShardContext;
        CircuitBreakerService circuitBreakerService,
            iw.addDocument(singleton(new NumericDocValuesField("number", 3)));
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            assertTrue(AggregationInspectionHelper.hasValue(min));
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
import org.apache.lucene.index.LeafReaderContext;
        directory.close();
import org.apache.lucene.tests.index.RandomIndexWriter;
/*
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
        expectThrows(IllegalArgumentException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            int numDup = randomIntBetween(1, 3);
        directory.close();
            assertThat(min.getProperty("value"), equalTo(1.0));
                document.add(new SortedNumericDocValuesField("number", i + 2));
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number");
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
 * not use this file except in compliance with the License.
    public void testMatchesNumericDocValues() throws IOException {
import org.apache.lucene.document.DoublePoint;
        testMinShortcutCase(() -> randomFloat(), (n) -> new FloatPoint("number", n.floatValue()), (v) -> FloatPoint.decodeDimension(v, 0));
 * license agreements. See the NOTICE file distributed with
        testMinShortcutCase(
            assertTrue(AggregationInspectionHelper.hasValue(min));
            indexWriter.close();
            assertTrue(AggregationInspectionHelper.hasValue(min));
        try (IndexReader reader = DirectoryReader.open(indexWriter)) {
import org.opensearch.index.mapper.MappedFieldType;
            for (int i = 0; i < numDocs; i++) {
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
            for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.document.StringField;
            assertNotNull(global.getAggregations().asMap().get("min"));
        Supplier<Number> randomNumber,
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
            assertTrue(AggregationInspectionHelper.hasValue(min));
            (n) -> new LongPoint("number", n.longValue()),
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        assertEquals("Field [not_a_number] of type [keyword] is not supported for aggregation [min]", e.getMessage());
            iw.addDocument(singleton(new NumericDocValuesField("number", 2)));
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
        );
            .order(BucketOrder.compound(BucketOrder.aggregation("filter>min", true)))
                Document document = new Document();
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 2)));
import org.apache.lucene.index.Term;
            assertEquals(-10.0, min.getValue(), 0);
            assertTrue(AggregationInspectionHelper.hasValue(min));
        }, fieldType);
 * specific language governing permissions and limitations
import java.util.ArrayList;
    }
            }
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 3)));
                InternalMin min = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), nonDeterministicAggregationBuilder, fieldType);
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
import org.apache.lucene.index.IndexWriter;
    public void testIpField() throws IOException {
            }
import java.util.Comparator;
            (n) -> new DoublePoint("number", n.doubleValue()),
            InternalMin min = (InternalMin) histo.getBuckets().get(0).getAggregations().asMap().get("min");
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
    }
                assertEquals(0L, filter.getDocCount());
                )
                assertTrue(AggregationInspectionHelper.hasValue(min));
    public void testMultiValuedField() throws IOException {
            (v) -> LongPoint.decodeDimension(v, 0)
    public void testScriptCaching() throws IOException {
        scripts.put(SUM_FIELD_PARAMS_SCRIPT, vars -> {
        Function<Map<String, Object>, Integer> getInc = vars -> {
            for (int i = 0; i < numDocs; i++) {
                assertThat(res, equalTo(values.get(i).v2()));
    private void testCase(Query query, CheckedConsumer<RandomIndexWriter, IOException> buildIndex, Consumer<InternalMin> verify)
        }, min -> {
            }
    }
