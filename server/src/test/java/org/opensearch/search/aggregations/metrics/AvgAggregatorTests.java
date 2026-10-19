        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);
import org.apache.lucene.search.Query;
        indexWriter.close();
        assertTrue(AggregationInspectionHelper.hasValue(avg));
        verifyAvgOfDoubles(values, sum / n, 1e-10);  
        for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.search.IndexSearcher;  
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 3)));  
            assertTrue(AggregationInspectionHelper.hasValue(avg));
    public void testCacheAggregation() throws IOException {
            assertTrue(AggregationInspectionHelper.hasValue(avg));
        Map<String, Object> params = Collections.singletonMap("inc", 1);
            assertEquals(2.5, avg.getValue(), 0);
        }, avg -> {
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 2)));
        });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
        }
        IndexSearcher indexSearcher = newSearcher(multiReader, true, true);
        params.put("field", "value");
    /** Script to return the value of a field named {@code value}. */
                document.add(new SortedNumericDocValuesField("values", i + 2));  
                avg.getValue(),
    }  
    public void testMultiValuedFieldWithValueScript() throws IOException {
            .order(BucketOrder.compound(BucketOrder.aggregation("filter>avg", true)))
        directory.close();
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
    }  
import org.apache.lucene.tests.index.RandomIndexWriter;
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("number");  
        aggregator.postCollection();
        }  
 * license agreements. See the NOTICE file distributed with
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);  
        assertTrue(aggregator.context().getQueryShardContext().isCacheable());
        }, fieldType);
        avg = (InternalAvg) aggregator.buildAggregation(0L);
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
            }
        );
    }
                avg.getValue(),
        aggregator.preCollection();
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));
    }
            iw.addDocument(Arrays.asList(new IntPoint("number", 3), new SortedNumericDocValuesField("number", 3)));  
        testAggregation(IntPoint.newRangeQuery("number", 0, 3), iw -> {  
        }, avg -> {  
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
                avg.getValue(),
            }
        });  
        testAggregation(new MatchAllDocsQuery(), iw -> {
            }  
 * compatible open source license.
 * not use this file except in compliance with the License.
            assertEquals(
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        indexWriter.close();  
                (double) (2 + 3 + 3 + 4 + 4 + 5 + 5 + 6 + 6 + 7 + 7 + 8 + 8 + 9 + 9 + 10 + 10 + 11 + 11 + 12) / 20,  
 * Modifications Copyright OpenSearch Contributors. See
            assertNotNull(bucket);  
    public void testScriptMultiValued() throws IOException {
        return new AvgAggregationBuilder("foo").field(fieldName);  
     * Make sure that an aggregation not using a script does get cached.
        for (int i = 0; i < numDocs; i++) {
    public void testQueryFiltersAll() throws IOException {
    }
        multiReader.close();
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    }
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        assertTrue(avg.getValue() >= 0.0);
 * You may obtain a copy of the License at  
    }
        AvgAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
import org.opensearch.script.ScriptEngine;  
            sum += values[i];
        indexWriter.addDocument(singleton(new NumericDocValuesField("number", 2)));
            iw.addDocument(singleton(new NumericDocValuesField("number", 3)));
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        }, avg -> {  
        }, avg -> {
        });
    public void testNoMatchingField() throws IOException {  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;  
        }
        unmappedIndexWriter.close();
            }  
 * SPDX-License-Identifier: Apache-2.0
    }
        }, avg -> {
 * specific language governing permissions and limitations
        Map<String, Object> params = new HashMap<>();  
        }, fieldType);
        );  
        Map<String, Object> params = Collections.singletonMap("inc", 1);
        );  
            assertNotNull(filter);
            }  
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("value")
        RandomIndexWriter unmappedIndexWriter = new RandomIndexWriter(random(), unmappedDirectory);  
            }  
            for (int i = 0; i < numDocs; i++) {
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
            Terms.Bucket bucket = buckets.get(i);
    public void testMultiValuedFieldWithValueScriptWithParams() throws IOException {
            String fieldname = (String) vars.get("field");  
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));  
        for (int i = 0; i < n; i++) {
        indexWriter.close();
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").script(
        );
            }  
        assertTrue(aggregator.context().getQueryShardContext().isCacheable());
                iw.addDocument(document);
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);  
        assertEquals(4, avg.getValue(), 0);  
            int inc = getInc.apply(vars);  
        for (int i = 0; i < numDocs; i++) {  
            assertTrue(AggregationInspectionHelper.hasValue(avg));
        aggregator.postCollection();  
                AggregationBuilders.filter("filter", termQuery("value", 100)).subAggregation(AggregationBuilders.avg("avg").field("value"))  
            assertEquals(
                iw.addDocument(document);
        IndexReader indexReader = DirectoryReader.open(directory);
                (double) (3 + 4 + 4 + 5 + 5 + 6 + 6 + 7 + 7 + 8 + 8 + 9 + 9 + 10 + 10 + 11 + 11 + 12 + 12 + 13) / 20,  
            Filter filter = bucket.getAggregations().get("filter");
        indexReader.close();
        }  
 *
        InternalAvg avg = (InternalAvg) aggregator.buildAggregation(0L);
        }, avg -> {
    /** Script to return the {@code _value} provided by aggs framework. */
 * GitHub history for details.
import java.util.ArrayList;
/*  
        multiReader.close();  
            for (int i = 0; i < numDocs; i++) {  
            assertEquals(4, avg.getValue(), 0);
                Document document = new Document();
                document.add(new SortedNumericDocValuesField("number", i + 3));
 * ownership. Elasticsearch licenses this file to you under  
                0
        assertTrue(AggregationInspectionHelper.hasValue(avg));
 * The OpenSearch Contributors require contributions made to  
    public void testNoDocs() throws IOException {  
            for (int i = 0; i < numDocs; i++) {  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("values")
            assertTrue(AggregationInspectionHelper.hasValue(avg));  
            for (int i = 0; i < numDocs; i++) {
                document.add(new SortedNumericDocValuesField("values", i + 3));
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, RANDOM_SCRIPT, Collections.emptyMap()));
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("number");  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
    private void verifyAvgOfDoubles(double[] values, double expected, double delta) throws IOException {
            for (Object v : docLookup.get(fieldname)) {
import org.opensearch.search.aggregations.AggregationBuilder;
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("avg").field("value");
            assertEquals("6", avg.getValueAsString());  
        aggregator.preCollection();
        testAggregation(new FieldExistsQuery("number"), iw -> {
            final int numDocs = 10;  
        InternalAvg avg = (InternalAvg) aggregator.buildAggregation(0L);  
    public static final String VALUE_FIELD_SCRIPT = "value_field";  
            if (vars == null || vars.containsKey("inc") == false) {  
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.emptyMap()));
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("number").missing(0L);
        assertEquals("avg", avg.getName());  
        assertEquals(10, buckets.size());
        };
            assertFalse(AggregationInspectionHelper.hasValue(avg));  
        IndexReader unamappedIndexReader = DirectoryReader.open(unmappedDirectory);
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("number");
 */  
        assertEquals(3, avg.getCount(), 0);
                (double) (2 + 3 + 3 + 4 + 4 + 5 + 5 + 6 + 6 + 7 + 7 + 8 + 8 + 9 + 9 + 10 + 10 + 11 + 11 + 12) / 20,  
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        });  
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        Directory directory = newDirectory();  
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));
                document.add(new SortedNumericDocValuesField("values", i + 3));
            assertTrue(AggregationInspectionHelper.hasValue(avg));
import org.apache.lucene.index.MultiReader;
                        null
        directory.close();
        aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);  
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").script(
        final int numDocs = 10;
        }, avg -> {  
                assertTrue(factories.allFactoriesSupportIntraSegmentSearch());
    }  
            nonDeterministicScripts,
            return ((Number) vars.get("_value")).doubleValue() + inc;
            iw.addDocument(singleton(new NumericDocValuesField("number", 2)));  
        Map<String, Function<Map<String, Object>, Object>> nonDeterministicScripts = new HashMap<>();
    /** Script to sum the values of a field named {@code values}. */
        final int numDocs = 10;  
import org.opensearch.search.aggregations.AggregatorTestCase;
        MultiReader multiReader = new MultiReader(indexReader, unamappedIndexReader);
    public static final String VALUE_SCRIPT = "_value";  
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", 1)));  
                document.add(new SortedNumericDocValuesField("values", i + 2));  
        }, avg -> {
        int n = randomIntBetween(5, 10);  
                    .build(
    }
 *
    public void testUnmappedField() throws IOException {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
                    .addAggregator(new AvgAggregationBuilder("test").field("value"))
    }
            assertEquals((double) (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11) / 10, avg.getValue(), 0);
    public void testSupportsIntraSegmentSearch() throws IOException {  
        }, fieldType);
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 7)));  
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("values")
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.search.FieldExistsQuery;
                iw.addDocument(singleton(new NumericDocValuesField("number", NumericUtils.doubleToSortableLong(value))));
    /** Script to return a random double */
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SUM_VALUES_FIELD_SCRIPT, Collections.emptyMap())
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
        assertFalse(aggregator.context().getQueryShardContext().isCacheable());
            assertEquals((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10, avg.getValue(), 0);
        assertTrue(AggregationInspectionHelper.hasValue(avg));
        throws IOException {  
        InternalAvg avg = (InternalAvg) aggregator.buildAggregation(0L);  
        }, avg -> {
import org.opensearch.common.settings.Settings;
/*
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                iw.addDocument(document);
            return sum.apply(vars, fieldname);
                iw.addDocument(document);
                iw.addDocument(document);
        nonDeterministicScripts.put(RANDOM_SCRIPT, vars -> AvgAggregatorTests.randomDouble());
        }  
    private void testAggregation(Query query, CheckedConsumer<RandomIndexWriter, IOException> buildIndex, Consumer<InternalAvg> verify)
        AvgAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
        MockScriptEngine scriptEngine = new MockScriptEngine(
        }, fieldType);
 * this file be licensed under the Apache-2.0 license or a
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SUM_FIELD_PARAMS_SCRIPT, params)
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            assertEquals(4, avg.getValue(), 0);  
        Directory directory = newDirectory();
 *  
import org.opensearch.search.aggregations.BucketOrder;
}
            for (int i = 0; i < numDocs; i++) {
        }, avg -> {  
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
            assertEquals(Double.NaN, avg.getValue(), 0);
            assertEquals(1L, bucket.getDocCount());
            assertEquals((long) i + 1, bucket.getKeyAsNumber());
            } else {
                document.add(new SortedNumericDocValuesField("values", i + 3));
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
        IndexReader unamappedIndexReader = DirectoryReader.open(unmappedDirectory);
            assertTrue(AggregationInspectionHelper.hasValue(avg));
import org.opensearch.common.CheckedConsumer;  
            assertTrue(AggregationInspectionHelper.hasValue(avg));
        testAggregation(new FieldExistsQuery("number"), iw -> {
 */
            }
        for (int i = 0; i < n; i++) {
            for (int i = 0; i < numDocs; i++) {
    public void testUnmappedWithMissingField() throws IOException {  
import java.io.IOException;
            assertTrue(AggregationInspectionHelper.hasValue(avg));  
        }, fieldType);
        // Summing up an array which contains NaN and infinities and expect a result same as naive summation
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", i + 1)));  
                0
            assertEquals(4.0, avg.getProperty("value"));
import org.apache.lucene.index.DirectoryReader;
            assertTrue(AggregationInspectionHelper.hasValue(avg));
    }  
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
        assertTrue(AggregationInspectionHelper.hasValue(avg));
    }
import java.util.List;  
            iw.addDocument(singleton(new NumericDocValuesField("number", 3)));
        double sum = 0;
    public void testScriptMultiValuedWithParams() throws Exception {
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        params.put("field", "values");
        double[] largeValues = new double[n];
        List<? extends Terms.Bucket> buckets = terms.getBuckets();  
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        verifyAvgOfDoubles(largeValues, Double.NEGATIVE_INFINITY, 0d);
            );  
    public void testScriptSingleValuedWithParams() throws IOException {  
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").format("#")  
            final int numDocs = 10;  
        assertNotNull(terms);
        }, avg -> {  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("number");
import org.opensearch.script.Script;
        });
        assertEquals("avg", avg.getName());  
                Document document = new Document();
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SUM_FIELD_PARAMS_SCRIPT, params)
        AggregationBuilder aggregationBuilder,
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.emptyMap()));
            assertFalse(AggregationInspectionHelper.hasValue(avg));
        aggregationBuilder = new AvgAggregationBuilder("avg").field("value")  
            assertEquals((2 + 3 + 3 + 4 + 4 + 5 + 5 + 6 + 6 + 7 + 7 + 8 + 8 + 9 + 9 + 10 + 10 + 11 + 11 + 12) / 20, avg.getValue(), 0);
            final int numDocs = 10;
        IndexSearcher indexSearcher = newSearcher(multiReader, true, true);  
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)  
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_FIELD_SCRIPT, Collections.emptyMap())
     */
    public void testSomeMatchesNumericDocValues() throws IOException {  
            return values;
        Terms terms = (Terms) aggregator.buildTopLevel();
                values.add(((Number) v).longValue() + inc);  
            final int numDocs = 10;  
            assertNotNull(avg);  
            );
        }, avg -> assertEquals(expected, avg.getValue(), delta), fieldType);  
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 2)));
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        // Summing up some big double values and expect infinity result
            for (double value : values) {  
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 3)));
        AggregationBuilder aggregationBuilder = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.NUMERIC)
            iw.addDocument(singleton(new NumericDocValuesField("number", 2)));  
/*  
            List<Long> values = new ArrayList<>();
        MultiReader multiReader = new MultiReader(indexReader, unamappedIndexReader);  
                Document document = new Document();
            .field("value")
                ? randomFrom(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
import org.apache.lucene.search.MatchAllDocsQuery;
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 2)));
        MappedFieldType fieldType
import static java.util.Collections.singleton;  
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);  
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("value")
        verifyAvgOfDoubles(largeValues, Double.POSITIVE_INFINITY, 0d);
import org.opensearch.script.ScriptModule;
        aggregator.preCollection();  
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            final int numDocs = 10;  
            final int numDocs = 10;
        scripts.put(SUM_VALUES_FIELD_SCRIPT, vars -> sum.apply(vars, "values"));  
        IndexReader indexReader = DirectoryReader.open(directory);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);  
            final int numDocs = 10;
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
    @Override
    }
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.9, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7 };
    }
import static org.opensearch.index.query.QueryBuilders.termQuery;
        }, avg -> {
            int inc = getInc.apply(vars);
            assertEquals((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10, avg.getValue(), 0);
            final int numDocs = 10;
    }  
import org.apache.lucene.index.IndexReader;  
        assertEquals("avg", avg.getName());  
        }, (MappedFieldType) null);
                (double) (3 + 4 + 4 + 5 + 5 + 6 + 6 + 7 + 7 + 8 + 8 + 9 + 9 + 10 + 10 + 11 + 11 + 12 + 12 + 13) / 20,
import org.opensearch.script.ScriptService;
import org.opensearch.script.MockScriptEngine;
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.bucket.terms.Terms;
        }, fieldType);
            for (int i = 0; i < numDocs; i++) {  
        scripts.put(VALUE_SCRIPT, vars -> {
        testAggregation(aggregationBuilder, new FieldExistsQuery("number"), iw -> {
        Consumer<InternalAvg> verify,
                    );  
            assertEquals(0L, filter.getDocCount());  
import org.opensearch.search.aggregations.AggregatorFactories;  
        n = randomIntBetween(5, 10);  
    }
            assertTrue(AggregationInspectionHelper.hasValue(avg));  
        }
import java.util.Map;
                document.add(new SortedNumericDocValuesField("values", i + 3));  
            assertEquals(0.0, avg.getValue(), 0);  
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);
            assertFalse(AggregationInspectionHelper.hasValue(avg));
        Directory unmappedDirectory = newDirectory();
import org.opensearch.search.aggregations.support.ValueType;  
        }, avg -> {
            assertTrue(AggregationInspectionHelper.hasValue(avg));
        aggregator.preCollection();
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {  
                document.add(new SortedNumericDocValuesField("values", i + 2));  
    }
        values = new double[n];
                AggregatorFactories factories = AggregatorFactories.builder()  
 * software distributed under the License is distributed on an
        BiFunction<Map<String, Object>, String, Object> sum = (vars, fieldname) -> {
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        );  
            assertEquals(Double.NaN, avg.getValue(), 0);
            Collections.emptyMap()
                return ((Number) vars.get("inc")).intValue();  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);
            assertEquals((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10, avg.getValue(), 0);
 * Licensed to Elasticsearch under one or more contributor  
    }  
    @Override
        aggregator.preCollection();  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
    }
            LeafDocLookup docLookup = (LeafDocLookup) vars.get("doc");  
        for (int i = 0; i < 10; i++) {
            }
        unmappedDirectory.close();
            final int numDocs = 10;  
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
import java.util.function.Consumer;  
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);
                avg.getValue(),  
        Directory directory = newDirectory();
public class AvgAggregatorTests extends AggregatorTestCase {  
        scripts.put(VALUE_FIELD_SCRIPT, vars -> sum.apply(vars, "value"));
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, params));  
import java.util.Arrays;  
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            .field("value")  
    public void testOrderByEmptyAggregation() throws IOException {
        TermsAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
            }  
            // Intentionally not writing any docs
        Directory unmappedDirectory = newDirectory();
            }
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.DOUBLE);
        assertNotNull(buckets);
            }
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        testAggregation(aggregationBuilder, new FieldExistsQuery("number"), iw -> {  
    }
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.emptyMap()));  
import org.apache.lucene.document.NumericDocValuesField;  
        Query query,
import org.apache.lucene.document.Document;
        }, avg -> {
import org.opensearch.script.ScriptType;  
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
            scripts,  
    public void testScriptCaching() throws IOException {  
import java.util.HashMap;
        assertEquals(5.5, avg.getValue(), 0);
import org.apache.lucene.document.IntPoint;
     * Make sure that an aggregation using a deterministic script does gets cached while  
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
    public void testMultiValuedField() throws IOException {
        testAggregation(new MatchAllDocsQuery(), iw -> {
    public void testSingleValuedFieldPartiallyUnmapped() throws IOException {  
 */  
            for (int i = 0; i < numDocs; i++) {  
        RandomIndexWriter unmappedIndexWriter = new RandomIndexWriter(random(), unmappedDirectory);
            iw.addDocument(Arrays.asList(new IntPoint("number", 3), new SortedNumericDocValuesField("number", 7)));
        indexWriter.addDocument(singleton(new NumericDocValuesField("number", 7)));  
        };  
        }
        unmappedIndexWriter.close();
        scripts.put(SUM_FIELD_PARAMS_SCRIPT, vars -> {
        unmappedDirectory.close();  
            assertEquals((double) (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11) / 10, avg.getValue(), 0);
        testAggregation(IntPoint.newRangeQuery("number", -1, 0), iw -> {
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);  
    }
        params.put("inc", 1);
                            .getQueryShardContext(),
    }  
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, params));  
        // Test that an aggregation not using a script does get cached  
            assertEquals(
    }
        }
        IndexReader indexReader = DirectoryReader.open(directory);
                Document document = new Document();
     */  
import org.apache.lucene.util.NumericUtils;
        aggregator.postCollection();
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        }, avg -> {
            );
    public void testSomeMatchesSortedNumericDocValues() throws IOException {
import org.opensearch.search.lookup.LeafDocLookup;
                IndexSearcher searcher = newIndexSearcher(reader);
            assertTrue(AggregationInspectionHelper.hasValue(avg));  
            MockScriptEngine.NAME,
    public void testSingleValuedField_WithFormatter() throws IOException {  
 * Unless required by applicable law or agreed to in writing,
            assertFalse(AggregationInspectionHelper.hasValue(avg));
            );  
                : randomDoubleBetween(Double.MIN_VALUE, Double.MAX_VALUE, true);  
    }
            assertEquals(
    }
        assertEquals(5.5, avg.getValue(), 0);
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));  
            assertEquals(Double.NaN, avg.getValue(), 0);
        aggregator.postCollection();
        assertTrue(avg.getValue() <= 1.0);
        }, fieldType);  
import org.opensearch.search.aggregations.bucket.filter.Filter;  
        directory.close();
                0
        indexWriter.close();  
        for (int i = 0; i < n; i++) {  
        }, avg -> {  
    /** Script to take a field name in params and sum the values of the field. */
    }
                Document document = new Document();
 * KIND, either express or implied.  See the License for the
            assertTrue(AggregationInspectionHelper.hasValue(avg));  
        Map<String, Object> params = new HashMap<>();  
    }
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
                document.add(new SortedNumericDocValuesField("number", i + 2));  
            Avg avg = filter.getAggregations().get("avg");
        });
    public void testQueryFiltering() throws IOException {
        unmappedIndexWriter.close();  
 * the Apache License, Version 2.0 (the "License"); you may
        }, avg -> {
        return Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.BOOLEAN, CoreValuesSourceType.DATE);
    public static final String SUM_FIELD_PARAMS_SCRIPT = "sum_field_params";  
        testAggregation(aggregationBuilder, query, buildIndex, verify, fieldType);  
            largeValues[i] = Double.MAX_VALUE;  
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
            for (int i = 0; i < numDocs; i++) {
    public static final String SUM_VALUES_FIELD_SCRIPT = "sum_values_field";  
import org.apache.lucene.document.SortedNumericDocValuesField;
    public void testScriptSingleValued() throws IOException {  
    ) throws IOException {  
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
            assertTrue(AggregationInspectionHelper.hasValue(avg));
import java.util.function.Function;
        });  
    }
import java.util.Collections;
        MultiReader multiReader = new MultiReader(indexReader, unamappedIndexReader);
        AvgAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
        multiReader.close();  
        // Test that an aggregation using a nondeterministic script does not get cached  
    public void testSingleValuedField() throws IOException {  
    }
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,  
        IndexReader indexReader = DirectoryReader.open(directory);  
        }, avg -> {  
    private void testAggregation(  
        RandomIndexWriter unmappedIndexWriter = new RandomIndexWriter(random(), unmappedDirectory);
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
        indexWriter.addDocument(singleton(new NumericDocValuesField("number", 3)));
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.emptyMap()));
                document.add(new SortedNumericDocValuesField("values", i + 2));
        testAggregation(new MatchAllDocsQuery(), iw -> {
        });  
import org.opensearch.index.mapper.NumberFieldMapper;  
import org.opensearch.index.mapper.MappedFieldType;
            assertTrue(AggregationInspectionHelper.hasValue(avg));
     * one using a nondeterministic script does not.
        directory.close();
        IndexSearcher indexSearcher = newSearcher(multiReader, true, true);
package org.opensearch.search.aggregations.metrics;
                return 0;
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").script(  
        testAggregation(new MatchAllDocsQuery(), iw -> {
        verifyAvgOfDoubles(values, 0.9, 0d);  
    protected ScriptService getMockScriptService() {  
    public static final String RANDOM_SCRIPT = "Math.random()";  
                0
        aggregator.postCollection();
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);  
        }, fieldType);
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            );  
    /**
        IndexReader unamappedIndexReader = DirectoryReader.open(unmappedDirectory);  
        Directory directory = newDirectory();
        final int numDocs = 10;
import org.opensearch.search.aggregations.AggregationBuilders;
import org.opensearch.search.aggregations.support.ValuesSourceType;
            for (int i = 0; i < numDocs; i++) {
            assertEquals(Double.NaN, avg.getValue(), 0);
    }  
            try (IndexReader reader = indexWriter.getReader()) {
 * under the License.  
        }, (MappedFieldType) null);  
            }
        // Test that an aggregation using a deterministic script gets cached  
            largeValues[i] = -Double.MAX_VALUE;
    public void testSingleValuedFieldWithValueScriptWithParams() throws IOException {
        }, fieldType);  
    public void testSummationAccuracy() throws IOException {  
    public void testSingleValuedFieldWithValueScript() throws IOException {
        // Summing up a normal array and expect an accurate value
        Directory unmappedDirectory = newDirectory();  
            assertEquals(Double.NaN, avg.getValue(), 0);
            values[i] = frequently()
        params.put("inc", 1);
    /**
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").script(  
            assertEquals(4, avg.getValue(), 0);  
        });
import org.apache.lucene.store.Directory;  
            .subAggregation(
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);  
        Function<Map<String, Object>, Integer> getInc = vars -> {
            }
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("avg").field("value")
        });
    @Override
        }, avg -> {  
import java.util.function.BiFunction;
            final int numDocs = 10;  
        unmappedDirectory.close();
