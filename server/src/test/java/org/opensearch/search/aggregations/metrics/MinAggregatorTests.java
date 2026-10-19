    private void testCase(Query query, CheckedConsumer<RandomIndexWriter, IOException> buildIndex, Consumer<InternalMin> verify)
            assertEquals(1.0, min.getValue(), 0);
            (n) -> new LongPoint("number", n.longValue()),
 * not use this file except in compliance with the License.
            unmappedIndexWriter.close();  
            }
        indexWriter.addDocuments(documents);
        });
            (v) -> LongPoint.decodeDimension(v, 0)
            .order(BucketOrder.compound(BucketOrder.aggregation("filter>min", true)))  
            assertEquals(Double.POSITIVE_INFINITY, min.getValue(), 0);
 * this work for additional information regarding copyright
            () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            nonDeterministicScripts,
            final int numDocs = 10;
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number");  
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.singletonMap("inc", 5)));
        }, (Consumer<InternalMin>) min -> {
            iw.addDocument(singleton(new SortedSetDocValuesField(fieldName, new BytesRef(InetAddressPoint.encode(randomIp(v4))))));  
 * specific language governing permissions and limitations
            min = (InternalMin) histo.getBuckets().get(2).getAggregations().asMap().get("min");
        }, fieldType);
            Number res = MinAggregator.findLeafMinValue(ctx.reader(), "number", pointConvertFunc);
                IndexReader indexReader = DirectoryReader.open(directory);  
            LeafDocLookup docLookup = (LeafDocLookup) vars.get("doc");
import org.opensearch.script.ScriptType;
        expectThrows(IllegalArgumentException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            for (Object v : docLookup.get(fieldname)) {
            assertNotNull(histo.getBuckets().get(0).getAggregations().asMap().get("min"));  
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("does_not_exist").missing("not_a_number");  
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            assertEquals(1.0, min.getValue(), 0);  
                LeafReaderContext ctx = reader.leaves().get(0);
        Map<String, Function<Map<String, Object>, Object>> nonDeterministicScripts = new HashMap<>();
            }
            iw.addDocument(Arrays.asList(new IntPoint("number", 3), new SortedNumericDocValuesField("number", 3)));
        testMinShortcutCase(  
                MultiReader multiReader = new MultiReader(indexReader, unamappedIndexReader);
 * SPDX-License-Identifier: Apache-2.0
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
        MapperService mapperService,
    public void testMultiValuedFieldWithScriptParams() throws IOException {
        directory.close();
                docID++;
import org.apache.lucene.index.LeafReaderContext;
                iw.addDocument(document);
            assertTrue(AggregationInspectionHelper.hasValue(min));  
        }, (Consumer<InternalGlobal>) global -> {
            }
    }  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);  
                assertEquals(1L, bucket.getDocCount());
import org.apache.lucene.document.Document;
                IndexReader unamappedIndexReader = DirectoryReader.open(unmappedDirectory)
    public void testSingleValuedFieldWithValueScriptAndParams() throws IOException {  
public class MinAggregatorTests extends AggregatorTestCase {  
    }  
                min = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), aggregationBuilder, fieldType);
        for (int i = 0; i < 3; i++) {  
        }, fieldType);
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, INVERT_SCRIPT, Collections.emptyMap()));
        IllegalArgumentException e = expectThrows(  
/*  
    protected ScriptService getMockScriptService() {
                new FilterAggregationBuilder("filter", termQuery("number", 100)).subAggregation(
        }, min -> {  
                values.add(new Tuple<>(docID, nextValue));  
            try (IndexReader reader = DirectoryReader.open(indexWriter)) {
            assertEquals("0001.0", min.getValueAsString());
import java.util.function.Consumer;
            if (vars == null || vars.containsKey("inc") == false) {
            .subAggregation(
import org.opensearch.search.lookup.LeafDocLookup;
            }
        Function<Number, Field> pointFieldFunc,  
        testMinShortcutCase(
import org.apache.lucene.util.BytesRef;
        scripts.put(VALUE_SCRIPT, vars -> {
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
            assertNotNull(histo.getBuckets().get(2).getAggregations().asMap().get("min"));
            int inc = getInc.apply(vars);
            assertFalse(AggregationInspectionHelper.hasValue(min));
                AggregatorFactories factories = AggregatorFactories.builder()
            final int numDocs = 10;
                iw.addDocument(singleton(new NumericDocValuesField("number", i + 1)));  
package org.opensearch.search.aggregations.metrics;
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 3)));
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        }, min -> {
            min = (InternalMin) histo.getBuckets().get(1).getAggregations().asMap().get("min");  
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
import org.opensearch.script.ScriptModule;  
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
        // insert some documents without a value for the metric field.
            () -> randomLongBetween(Integer.MIN_VALUE, Integer.MAX_VALUE),  
                iw.addDocument(singleton(new NumericDocValuesField("number", i + 1)));  
        this.queryShardContext = super.queryShardContextMock(searcher, mapperService, indexSettings, circuitBreakerService, bigArrays);  
        }, fieldType);
    }
                Filter filter = bucket.getAggregations().get("filter");
    public void testFormatter() throws IOException {  
 * license agreements. See the NOTICE file distributed with
        HistogramAggregationBuilder histogram = new HistogramAggregationBuilder("histo").field("number")
 * under the License.  
        MinAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
 *  
            iw.addDocument(singleton(new NumericDocValuesField("number", 3)));  
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 3)));
            ) {
        scripts.put(INVERT_SCRIPT, vars -> -((Number) vars.get("_value")).doubleValue());  
            indexWriter.deleteDocuments(new Term("id", values.get(i - 1).v1().toString()));  
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;  
            iw.addDocument(singleton(new SortedSetDocValuesField(fieldName, new BytesRef(InetAddressPoint.encode(randomIp(v4))))));
                document.add(pointFieldFunc.apply(nextValue));  
    public void testSomeMatchesSortedNumericDocValues() throws IOException {  
    private static final String SUM_VALUES_FIELD_SCRIPT = "sum_values_field";
import java.util.ArrayList;
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 3)));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertEquals(3.0, min.getValue(), 0);  
    }  
            Document document = new Document();
        testCase(histogram, new MatchAllDocsQuery(), iw -> {  
    public void testQueryFiltersAll() throws IOException {  
            assertEquals(-100.0, min.getValue(), 0); // Note: this comes straight from missing, and is not inverted from script
 * compatible open source license.
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);  
            assertTrue(AggregationInspectionHelper.hasValue(global));  
                document.add(new SortedNumericDocValuesField("number", i + 3));
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
import static java.util.Collections.singleton;
                InternalMin min = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), nonDeterministicAggregationBuilder, fieldType);
                assertNotNull(filter);
        }, (Consumer<InternalMin>) min -> {
        MappedFieldType fieldType = new KeywordFieldMapper.KeywordFieldType("not_a_number");
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("does_not_exist").missing(0L);  
            unmappedIndexWriter.addDocument(singleton(new NumericDocValuesField("unrelated", 100)));  
    public void testEmptyBucket() throws IOException {
            assertTrue(AggregationInspectionHelper.hasValue(min));  
        try (Directory directory = newDirectory(); Directory unmappedDirectory = newDirectory()) {
import org.apache.lucene.tests.index.RandomIndexWriter;
            assertThat(min.getProperty("value"), equalTo(1.0));
            assertEquals(Double.POSITIVE_INFINITY, min.getValue(), 0);  
            for (int i = 0; i < numDocs; i++) {
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));  
            assertEquals(3, min.getValue(), 0);  
        }  
            IllegalArgumentException.class,
            }
                iw.addDocument(document);
        );
    private static final String VALUE_FIELD_SCRIPT = "value_field";
        indexWriter.close();
        });  
        indexWriter.addDocument(singleton(new NumericDocValuesField("value", 10)));
            }  
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {  
            }  
        BiFunction<Map<String, Object>, String, Object> sum = (vars, fieldname) -> {  
            iw.addDocument(Arrays.asList(new IntPoint("number", 3), new SortedNumericDocValuesField("number", 3)));
            for (int i = 0; i < numDocs; i++) {
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 3)));
        int numValues = atLeast(50);
            return ((Number) vars.get("_value")).doubleValue() + inc;
        }, (Consumer<InternalMin>) min -> { fail("Should have thrown exception"); }, fieldType));
        indexWriter.close();  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number");
    }
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 1)));  
            assertEquals(6.0, min.getValue(), 0);  
            assertEquals(-12.0, min.getValue(), 0);  
                document.add(new SortedNumericDocValuesField("number", i + 3));  
import org.opensearch.index.IndexSettings;
    }
    @Override  
    }
 * Unless required by applicable law or agreed to in writing,
        IndexReader indexReader = DirectoryReader.open(directory);
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 3)));
 * the Apache License, Version 2.0 (the "License"); you may
            .minDocCount(0)
        }
        }, fieldType);
    }
    public void testIpField() throws IOException {
    public void testMinShortcutRandom() throws Exception {
        indexReader.close();
    @Override
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", 1)));
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
            }
        }
        return new MinAggregationBuilder("foo").field(fieldName);
        aggregator.preCollection();
import java.util.Arrays;  
        }, (Consumer<InternalMin>) min -> {
        }
        }  
        }, min -> {
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }, (Consumer<InternalMin>) min -> { fail("Should have thrown exception"); }, fieldType));
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
    }  
 *
import org.opensearch.search.aggregations.bucket.terms.LongTerms;
            assertEquals(2, global.getDocCount());
        }
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 7)));  
        Directory directory = newDirectory();  
    public void testOrderByEmptyAggregation() throws IOException {
            assertEquals(1, min.getValue(), 0);
                iw.addDocument(singleton(new NumericDocValuesField("number", i + 1)));  
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
            assertTrue(AggregationInspectionHelper.hasValue(min));  
            new MinAggregationBuilder("min").field("number")
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 7)));
    }
import org.opensearch.script.ScriptEngine;
        }, fieldType);
        }, min -> fail("expected an exception"), fieldType));
                    .build(
        });
            Number res = MinAggregator.findLeafMinValue(ctx.reader(), "number", pointConvertFunc);
                assertNotNull(min);  
            final int numDocs = 10;
        }, min -> {
        }, fieldType);  
    /** Script to return the {@code _value} provided by aggs framework. */  
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
import org.opensearch.script.Script;
 * GitHub history for details.
    public void testScript() throws IOException {
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number");
            assertTrue(AggregationInspectionHelper.hasValue(min));
 */  
        };
    private void testMinShortcutCase(
        IndexSearcher searcher,  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
            assertTrue(AggregationInspectionHelper.hasValue(min));
                document.add(new SortedNumericDocValuesField("number", i + 2));
                indexSearcher = newSearcher(indexReader, true, true);
        for (int i = 1; i < values.size(); i++) {
                document.add(pointFieldFunc.apply(nextValue));
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("not_a_number");
            assertEquals(7.0, min.getValue(), 0);
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, RANDOM_SCRIPT, Collections.emptyMap()));
        IndexWriterConfig config = newIndexWriterConfig().setMergePolicy(NoMergePolicy.INSTANCE);
    }  
            assertNotNull(histo.getBuckets().get(1).getAggregations().asMap().get("min"));
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
        try (IndexReader reader = DirectoryReader.open(indexWriter)) {
    public void testNoMatchingField() throws IOException {
            }
    }  
        try (IndexReader reader = DirectoryReader.open(indexWriter)) {  
import org.apache.lucene.search.Query;
                assertEquals(2.0, min.getValue(), 0);
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 2)));
import static org.hamcrest.Matchers.equalTo;
        );
import java.util.function.BiFunction;  
        }, (Consumer<InternalMin>) min -> {
            assertThat(res, equalTo(null));
        assertEquals(Double.POSITIVE_INFINITY, result2.getValue(), 0);
        testCase(termsBuilder, new MatchAllDocsQuery(), iw -> {
            assertTrue(AggregationInspectionHelper.hasValue(min));
        }, (Consumer<InternalMin>) min -> {  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
import static org.opensearch.index.query.QueryBuilders.termQuery;  
                assertTrue(AggregationInspectionHelper.hasValue(min));  
    }
            final int numDocs = 10;
        return queryShardContext;
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 2)));
    }
            final int numDocs = 10;  
        InternalMin result2 = (InternalMin) aggregator.buildAggregation(0L);
        return Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.DATE, CoreValuesSourceType.BOOLEAN);
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, INVERT_SCRIPT, Collections.emptyMap()));
            ) {  
    }  
        MappedFieldType fieldType = new IpFieldMapper.IpFieldType(fieldName);  
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 3)));  
                IndexReader unamappedIndexReader = DirectoryReader.open(unmappedDirectory)
/*
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            for (int i = 0; i < numDocs; i++) {
        }, (Consumer<InternalMin>) min -> {  
import org.opensearch.search.aggregations.AggregatorFactories;
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            }
import org.opensearch.index.mapper.NumberFieldMapper;
        testCase(new FieldExistsQuery("number"), iw -> {
import org.opensearch.index.mapper.MapperService;  
                document.add(new SortedNumericDocValuesField("number", i + 2));
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 1)));
import org.apache.lucene.index.DirectoryReader;  
import org.apache.lucene.index.Term;
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
    protected QueryShardContext queryShardContextMock(
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
                            .getQueryShardContext(),  
        AggregationBuilder termsBuilder = new TermsAggregationBuilder("terms").field("number")
        nonDeterministicScripts.put(RANDOM_SCRIPT, vars -> AggregatorTestCase.randomDouble());  
            return values;
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number")
    public void testGetProperty() throws IOException {  
            assertTrue(AggregationInspectionHelper.hasValue(min));
    private final long SCRIPT_VALUE = 19L;
        try (Directory directory = newDirectory()) {
    private static final String INVERT_SCRIPT = "invert";  
        List<Document> documents = new ArrayList<>();  
    public void testSomeMatchesNumericDocValues() throws IOException {
            assertEquals(19.0, min.getValue(), 0);  
        }, (Consumer<InternalMin>) min -> {
import org.opensearch.search.aggregations.bucket.terms.Terms;  
    }  
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 7)));  
                assertTrue(queryShardContext.isCacheable());
    }
            scripts,
            iw.addDocument(singleton(new NumericDocValuesField("unrelated", 1)));
            assertFalse(AggregationInspectionHelper.hasValue(min));
    }  
        testMinShortcutCase(() -> randomInt(), (n) -> new IntPoint("number", n.intValue()), (v) -> IntPoint.decodeDimension(v, 0));
    public void testBadMissingField() {  
    }
            LeafReaderContext ctx = reader.leaves().get(0);  
            for (int i = 0; i < numDocs; i++) {  
                Document document = new Document();
import org.apache.lucene.search.FieldExistsQuery;
                assertEquals(2.0, min.getValue(), 0);
        List<Tuple<Integer, Number>> values = new ArrayList<>();
        for (int i = 0; i < numValues; i++) {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
    }
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
        Function<byte[], Number> pointConvertFunc
import java.util.List;
    public void testSingleValuedFieldPartiallyUnmapped() throws IOException {
    public void testDoReset() throws IOException {
    }
        assertEquals("Field [not_a_number] of type [keyword] is not supported for aggregation [min]", e.getMessage());  
 *
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field(fieldName);
        testCase(IntPoint.newRangeQuery("number", 0, 3), iw -> {
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.singletonMap("inc", 5)));
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));  
import java.util.function.Supplier;  
    public void testMatchesNumericDocValues() throws IOException {
            InternalMin min = (InternalMin) histo.getBuckets().get(0).getAggregations().asMap().get("min");
                assertEquals(-7.0, min.getValue(), 0);
import org.opensearch.search.aggregations.bucket.histogram.HistogramAggregationBuilder;
            assertEquals(3, min.getValue(), 0);
            final int numDocs = 10;
            assertTrue(AggregationInspectionHelper.hasValue(min));  
        scripts.put(VALUE_FIELD_SCRIPT, vars -> sum.apply(vars, "value"));
import org.opensearch.index.mapper.KeywordFieldMapper;
    }  
        MinAggregationBuilder nonDeterministicAggregationBuilder = new MinAggregationBuilder("min").field("number")
 * Licensed to Elasticsearch under one or more contributor  
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, INVERT_SCRIPT, Collections.emptyMap()));
        }  
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));  
import org.opensearch.search.aggregations.support.ValuesSourceType;
        Function<Map<String, Object>, Integer> getInc = vars -> {
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        }, fieldType);  
import org.opensearch.index.mapper.MappedFieldType;
            unmappedIndexWriter.close();
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
    }
            int inc = getInc.apply(vars);  
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 7)));
            indexWriter.close();  
 */
import org.apache.lucene.index.IndexReader;
            }  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
                IndexSearcher indexSearcher = newSearcher(multiReader, true, true);
        Supplier<Number> randomNumber,
            assertThat(global.getProperty("min.value"), equalTo(1.0));  
import org.opensearch.common.settings.Settings;
import org.apache.lucene.document.SortedSetDocValuesField;
    }  
    @Override
            LeafReaderContext ctx = reader.leaves().get(0);
}
            assertEquals(-10.0, min.getValue(), 0);  
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("value");  
 * You may obtain a copy of the License at  
                assertTrue(AggregationInspectionHelper.hasValue(min));  
            final int numDocs = 10;
            assertEquals(2.0, min.getValue(), 0);
        try (Directory directory = newDirectory()) {  
                assertTrue(AggregationInspectionHelper.hasValue(min));
            assertEquals(1.0, min.getValue(), 0);
        testCase(new MatchAllDocsQuery(), iw -> {
import org.apache.lucene.document.IntPoint;  
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
            assertEquals(2, min.getValue(), 0);
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 7)));  
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 3)));
import java.util.Map;
import org.opensearch.index.mapper.IpFieldMapper;  
    public void testSingleValuedFieldWithValueScript() throws IOException {  
                MultiReader multiReader = new MultiReader(indexReader, unamappedIndexReader);
            indexWriter.close();
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
        boolean v4 = randomBoolean();
                return ((Number) vars.get("inc")).intValue();
        }, fieldType);  
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
        }, (Consumer<InternalHistogram>) histo -> {  
        );
    public void testCaching() throws IOException {
import org.apache.lucene.search.MatchAllDocsQuery;
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));  
import org.apache.lucene.index.MultiReader;
            }, (Consumer<InternalMin>) min -> { fail("Should have thrown exception"); }, fieldType)
            assertTrue(AggregationInspectionHelper.hasValue(min));
                IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
    }  
            for (int i = 0; i < numDocs; i++) {
            }  
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));  
import org.opensearch.common.util.BigArrays;  
                Document document = new Document();
                IndexSearcher searcher = newIndexSearcher(reader);
    ) {
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);  
import org.opensearch.search.aggregations.bucket.histogram.InternalHistogram;  
import org.apache.lucene.document.Field;  
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
            documents.add(document);
 * KIND, either express or implied.  See the License for the
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 2)));
import org.opensearch.script.ScriptService;
import org.apache.lucene.search.IndexSearcher;  
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number")  
                document.add(new StringField("id", Integer.toString(docID), Field.Store.NO));
    @Override
                )
            }  
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").script(
    }
                iw.addDocument(singleton(new SortedSetDocValuesField("string", new BytesRef("foo"))));  
            () -> randomDouble(),
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
    private QueryShardContext queryShardContext;  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
            assertTrue(AggregationInspectionHelper.hasValue(min));
            }
        throws IOException {  
        });
            iw.addDocument(singleton(new SortedNumericDocValuesField("number2", 2)));  
        });
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        testCase(globalBuilder, new MatchAllDocsQuery(), iw -> {
import org.apache.lucene.document.StringField;
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number").missing("not_a_number");
                assertTrue(queryShardContext.isCacheable());
            assertNotNull(global.getAggregations().asMap().get("min"));
import org.apache.lucene.document.FloatPoint;
            try (IndexReader reader = indexWriter.getReader()) {  
                document.add(new SortedNumericDocValuesField("number", i + 3));
                assertTrue(min.getValue() >= 0.0 && min.getValue() <= 1.0);  
                assertTrue(factories.allFactoriesSupportIntraSegmentSearch());  
                InternalMin min = filter.getAggregations().get("min");
    }
            assertFalse(AggregationInspectionHelper.hasValue(min));
        scripts.put(SUM_FIELD_PARAMS_SCRIPT, vars -> {
            assertThat(res, equalTo(values.get(0).v2()));  
import org.apache.lucene.document.SortedNumericDocValuesField;  
            assertThat(global.getProperty("min"), equalTo(min));
            for (int i = 0; i < numDocs; i++) {
import org.opensearch.search.aggregations.BucketOrder;  
            );
            assertTrue(AggregationInspectionHelper.hasValue(min));
            assertTrue(AggregationInspectionHelper.hasValue(min));
            iw.addDocument(singleton(new NumericDocValuesField("number", 3)));
        testCase(IntPoint.newRangeQuery("number", -1, 0), iw -> {
            }
import org.apache.lucene.store.Directory;  
    public void testSingleValuedFieldPartiallyUnmappedWithMissing() throws IOException {
import java.io.IOException;
                assertTrue(AggregationInspectionHelper.hasValue(min));  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
                assertTrue(AggregationInspectionHelper.hasValue(min));
        Collections.sort(values, Comparator.comparingDouble(t -> t.v2().doubleValue()));
                    new MinAggregationBuilder("min").field("number")  
                assertFalse(queryShardContext.isCacheable());  
        }, fieldType);
 */  
        }, fieldType);
import java.util.Comparator;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);  
        });
    public void testSingleValuedFieldWithValueScriptAndMissing() throws IOException {
                assertFalse(AggregationInspectionHelper.hasValue(min));
                iw.addDocument(document);  
            assertTrue(AggregationInspectionHelper.hasValue(min));
        InternalMin result1 = (InternalMin) aggregator.buildAggregation(0L);
            assertEquals(2, min.getValue(), 0);
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number").format("0000.0");
                assertEquals((long) i + 1, bucket.getKeyAsNumber());
    /** Script to sum the values of a field named {@code values}. */  
        }, fieldType);  
    }
    }
/*  
            Collections.emptyMap()  
    public void testMultiValuedFieldWithScript() throws IOException {  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
                InternalMin min = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), aggregationBuilder, fieldType);
import java.util.HashMap;  
        );  
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SCRIPT_NAME, Collections.emptyMap())  
            } else {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);  
            List<Long> values = new ArrayList<>();  
        });  
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }, fieldType);
            .interval(1)  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);  
            indexWriter.close();  
    /** Script to take a field name in params and sum the values of the field. */  
            try (
                iw.addDocument(singleton(new NumericDocValuesField("number", i + 1)));  
                assertEquals(Double.POSITIVE_INFINITY, min.getValue(), 0);
    }
                Number nextValue = randomNumber.get();
import org.opensearch.common.collect.Tuple;
    public void testMultiValuedField() throws IOException {
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
        testCase(new FieldExistsQuery("number"), iw -> {  
                InternalMin min = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), aggregationBuilder, fieldType);
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, INVERT_SCRIPT, Collections.emptyMap()));
            MockScriptEngine.NAME,  
        testMinShortcutCase(() -> randomFloat(), (n) -> new FloatPoint("number", n.floatValue()), (v) -> FloatPoint.decodeDimension(v, 0));
import org.opensearch.common.CheckedConsumer;  
import org.apache.lucene.document.LongPoint;
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            iw.addDocument(singleton(new NumericDocValuesField("number", 2)));
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number")  
 * Modifications Copyright OpenSearch Contributors. See
        Directory directory = newDirectory();
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));  
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number").missing(-19L);
        }, min -> {  
                List<LongTerms.Bucket> buckets = terms.getBuckets();
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();  
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number")  
        indexWriter.addDocument(singleton(new NumericDocValuesField("value", 5)));
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 2)));  
        }
        assertEquals(5.0, result1.getValue(), 0);  
import org.opensearch.script.MockScriptEngine;  
                InternalMin min = searchAndReduce(indexSearcher, new MatchAllDocsQuery(), aggregationBuilder, fieldType);
            assertThat(histo.getBuckets().size(), equalTo(3));
        expectThrows(NumberFormatException.class, () -> testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    private static final String VALUE_SCRIPT = "_value";
            }  
            .subAggregation(new MinAggregationBuilder("min").field("number"));
            String fieldname = (String) vars.get("field");  
        MockScriptEngine scriptEngine = new MockScriptEngine(
                    );
            (v) -> DoublePoint.decodeDimension(v, 0)  
    public void testQueryFiltering() throws IOException {
            assertTrue(AggregationInspectionHelper.hasValue(min));  
        IndexSettings indexSettings,
import org.opensearch.search.aggregations.AggregationBuilder;  
        GlobalAggregationBuilder globalBuilder = new GlobalAggregationBuilder("global").subAggregation(
    private final String SCRIPT_NAME = "script_name";
            indexWriter.close();  
import java.util.function.Function;
        });
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
import java.util.Collections;
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number")
        indexWriter.deleteDocuments(new Term("id", values.get(values.size() - 1).v1().toString()));
    }  
        BigArrays bigArrays
import org.opensearch.core.indices.breaker.CircuitBreakerService;
    public void testSupportsIntraSegmentSearch() throws IOException {
    public void testUnmappedWithMissingField() throws IOException {
    }  
            iw.addDocument(singleton(new NumericDocValuesField("number", 3)));
    }
                Document document = new Document();  
    }
import org.opensearch.search.aggregations.AggregatorTestCase;
                IndexReader indexReader = DirectoryReader.open(directory);
import org.apache.lucene.document.NumericDocValuesField;
        int numDocs = 10;  
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));
            return sum.apply(vars, fieldname);
        scripts.put(SCRIPT_NAME, script -> SCRIPT_VALUE);
            RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        }  
                values.add(((Number) v).longValue() + inc);
            assertTrue(AggregationInspectionHelper.hasValue(min));
                iw.addDocument(singleton(new NumericDocValuesField("number", i + 1)));  
            assertTrue(AggregationInspectionHelper.hasValue(min));
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);  
                assertThat(res, equalTo(values.get(i).v2()));
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number");
        testCase(new MatchAllDocsQuery(), iw -> {  
import org.apache.lucene.document.InetAddressPoint;
import org.opensearch.search.aggregations.bucket.filter.Filter;
    /** Script to return the value of a field named {@code value}. */  
            assertEquals(Double.POSITIVE_INFINITY, min.getValue(), 0);  
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));  
                assertEquals(0L, filter.getDocCount());  
            assertEquals(0.0, min.getValue(), 0);
            for (int j = 0; j < numDup; j++) {  
                return 0;  
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));  
                assertNotNull(bucket);  
        IndexWriter indexWriter = new IndexWriter(directory, config);
                document.add(new SortedNumericDocValuesField("number", i + 2));  
        }, min -> {
            }  
            indexWriter.addDocument(singleton(new NumericDocValuesField("number", 2)));
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);  
                Terms.Bucket bucket = buckets.get(i);
import org.apache.lucene.index.IndexWriter;
        };
            RandomIndexWriter unmappedIndexWriter = new RandomIndexWriter(random(), unmappedDirectory);
            int numDup = randomIntBetween(1, 3);
        testCase(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
        scripts.put(SUM_VALUES_FIELD_SCRIPT, vars -> sum.apply(vars, "values"));  
    ) throws IOException {
                    .addAggregator(new MinAggregationBuilder("test").field("value"))  
    private static final String RANDOM_SCRIPT = "random";
    }
        final String fieldName = "IP_field";  
            for (int i = 0; i < numDocs; i++) {
    private static final String SUM_FIELD_PARAMS_SCRIPT = "sum_field_params";
        );
        );  
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 7)));
import org.opensearch.search.aggregations.bucket.global.InternalGlobal;
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
    public void testUnsupportedType() {
                Number res = MinAggregator.findLeafMinValue(ctx.reader(), "number", pointConvertFunc);  
                IndexSearcher indexSearcher = newSearcher(multiReader, true, true);  
                Document document = new Document();
            InternalMin min = (InternalMin) global.getAggregations().asMap().get("min");  
                documents.add(document);
            iw.addDocument(singleton(new NumericDocValuesField("number2", 2)));
    }  
import org.apache.lucene.index.IndexWriterConfig;  
        }, (Consumer<InternalMin>) min -> {
 * ownership. Elasticsearch licenses this file to you under  
        }, (Consumer<InternalTerms<?, LongTerms.Bucket>>) terms -> {
            .missing(-100L)  
import org.opensearch.search.aggregations.bucket.filter.FilterAggregationBuilder;
 * The OpenSearch Contributors require contributions made to  
        aggregator.postCollection();  
        });
import org.opensearch.search.aggregations.bucket.terms.InternalTerms;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }, (Consumer<InternalMin>) min -> {
        CircuitBreakerService circuitBreakerService,  
        }, min -> {
            }
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);  
        directory.close();
    public void testMatchesSortedNumericDocValues() throws IOException {
            for (int i = 0; i < numDocs; i++) {  
    public void testUnmappedWithBadMissingField() {
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
        aggregator.doReset();
        }
    public void testScriptCaching() throws IOException {
            try (  
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
import org.apache.lucene.index.NoMergePolicy;  
        testCase(new MatchAllDocsQuery(), iw -> {
import org.apache.lucene.document.DoublePoint;
                        null
        try (Directory directory = newDirectory(); Directory unmappedDirectory = newDirectory()) {
        int docID = 0;  
            (n) -> new DoublePoint("number", n.doubleValue()),
            RandomIndexWriter unmappedIndexWriter = new RandomIndexWriter(random(), unmappedDirectory);
import org.opensearch.index.query.QueryShardContext;
        MinAggregationBuilder aggregationBuilder = new MinAggregationBuilder("min").field("number")
                assertEquals(-19.0, min.getValue(), 0);  
            for (int i = 0; i < numDocs; i++) {
