        }
        Directory directory = newDirectory();
            assertFalse(AggregationInspectionHelper.hasValue(avg));
    @Override
        IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            assertTrue(AggregationInspectionHelper.hasValue(avg));
        }, fieldType);
                document.add(new SortedNumericDocValuesField("number", i + 3));
        AvgAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
                iw.addDocument(singleton(new NumericDocValuesField("number", NumericUtils.doubleToSortableLong(value))));
        indexWriter.addDocument(singleton(new NumericDocValuesField("number", 2)));
                AggregatorFactories factories = AggregatorFactories.builder()
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("number");
        aggregator.postCollection();
    /** Script to return the value of a field named {@code value}. */
    }
 * The OpenSearch Contributors require contributions made to
    public void testSingleValuedField() throws IOException {
        Query query,
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
 */
public class AvgAggregatorTests extends AggregatorTestCase {
        multiReader.close();
                0
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("number");
        Terms terms = (Terms) aggregator.buildTopLevel();
        );
    private void verifyAvgOfDoubles(double[] values, double expected, double delta) throws IOException {
    public void testQueryFiltersAll() throws IOException {
        assertEquals("avg", avg.getName());
            assertEquals((double) (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11) / 10, avg.getValue(), 0);
            assertTrue(AggregationInspectionHelper.hasValue(avg));
        }, (MappedFieldType) null);
                avg.getValue(),
import org.apache.lucene.document.NumericDocValuesField;
        IndexReader unamappedIndexReader = DirectoryReader.open(unmappedDirectory);
        Directory unmappedDirectory = newDirectory();
            }
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);
        Directory unmappedDirectory = newDirectory();
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").script(
            assertTrue(AggregationInspectionHelper.hasValue(avg));
    public void testCacheAggregation() throws IOException {
        }, avg -> {
        );
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            assertEquals(4, avg.getValue(), 0);
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 2)));
                document.add(new SortedNumericDocValuesField("number", i + 2));
import org.opensearch.common.CheckedConsumer;
        AvgAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
    ) throws IOException {
                IndexSearcher searcher = newIndexSearcher(reader);
            assertEquals(
                AggregationBuilders.filter("filter", termQuery("value", 100)).subAggregation(AggregationBuilders.avg("avg").field("value"))
    public void testUnmappedWithMissingField() throws IOException {
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.emptyMap()));
import org.opensearch.index.mapper.NumberFieldMapper;
        }, avg -> {
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
        aggregator.preCollection();
        }, fieldType);
            MockScriptEngine.NAME,
            assertEquals((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10, avg.getValue(), 0);
        Map<String, Object> params = new HashMap<>();
import org.apache.lucene.tests.index.RandomIndexWriter;
        });
            assertEquals(2.5, avg.getValue(), 0);
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);
            largeValues[i] = Double.MAX_VALUE;
        unmappedIndexWriter.close();
import org.opensearch.script.MockScriptEngine;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);
        avg = (InternalAvg) aggregator.buildAggregation(0L);
        assertEquals(5.5, avg.getValue(), 0);
 * You may obtain a copy of the License at
            iw.addDocument(singleton(new NumericDocValuesField("number", 2)));
        }, avg -> {
    }
        AggregationBuilder aggregationBuilder,
            for (int i = 0; i < numDocs; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.emptyMap()));
        int n = randomIntBetween(5, 10);
            assertFalse(AggregationInspectionHelper.hasValue(avg));
        multiReader.close();
            final int numDocs = 10;
        TermsAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
            );
            assertNotNull(bucket);
            assertFalse(AggregationInspectionHelper.hasValue(avg));
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        assertTrue(AggregationInspectionHelper.hasValue(avg));
        };
        }, avg -> {
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SUM_FIELD_PARAMS_SCRIPT, params)
            .field("value")
            final int numDocs = 10;
        params.put("field", "values");
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
 * software distributed under the License is distributed on an
                Document document = new Document();
 * license agreements. See the NOTICE file distributed with
            }
    public static final String SUM_FIELD_PARAMS_SCRIPT = "sum_field_params";
/*
            }
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, RANDOM_SCRIPT, Collections.emptyMap()));
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                iw.addDocument(document);
        IndexSearcher indexSearcher = newSearcher(multiReader, true, true);
        indexWriter.close();
        }, avg -> {
        Map<String, Function<Map<String, Object>, Object>> nonDeterministicScripts = new HashMap<>();
        unmappedDirectory.close();
                iw.addDocument(document);
            values[i] = frequently()
                    .addAggregator(new AvgAggregationBuilder("test").field("value"))
import org.opensearch.search.lookup.LeafDocLookup;
        indexWriter.addDocument(singleton(new NumericDocValuesField("number", 3)));
    }
import org.opensearch.script.ScriptService;
        Directory directory = newDirectory();
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
        assertFalse(aggregator.context().getQueryShardContext().isCacheable());
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }, fieldType);
        final int numDocs = 10;
            }
        testAggregation(aggregationBuilder, query, buildIndex, verify, fieldType);
    protected ScriptService getMockScriptService() {
        Directory unmappedDirectory = newDirectory();
            assertEquals((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10, avg.getValue(), 0);
import org.apache.lucene.search.FieldExistsQuery;
            final int numDocs = 10;
 * Unless required by applicable law or agreed to in writing,
    @Override
            final int numDocs = 10;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.DOUBLE);
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        aggregator.preCollection();
        }
import java.util.ArrayList;
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            LeafDocLookup docLookup = (LeafDocLookup) vars.get("doc");
            iw.addDocument(Arrays.asList(new IntPoint("number", 3), new SortedNumericDocValuesField("number", 7)));
            assertEquals(1L, bucket.getDocCount());
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
import org.apache.lucene.index.IndexReader;
    public void testScriptCaching() throws IOException {
        IndexSearcher indexSearcher = newSearcher(multiReader, true, true);
            } else {
        }, avg -> {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        return new AvgAggregationBuilder("foo").field(fieldName);
            }
        aggregator.preCollection();
    }
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").script(
            assertTrue(AggregationInspectionHelper.hasValue(avg));
            final int numDocs = 10;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 3)));
    }
                document.add(new SortedNumericDocValuesField("values", i + 2));
        }, avg -> assertEquals(expected, avg.getValue(), delta), fieldType);
    public void testSummationAccuracy() throws IOException {
    }
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
        Function<Map<String, Object>, Integer> getInc = vars -> {
        testAggregation(aggregationBuilder, new FieldExistsQuery("number"), iw -> {
                        null
            assertEquals(Double.NaN, avg.getValue(), 0);
                Document document = new Document();
        MultiReader multiReader = new MultiReader(indexReader, unamappedIndexReader);
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
        directory.close();
     * one using a nondeterministic script does not.
        assertTrue(aggregator.context().getQueryShardContext().isCacheable());
 * ownership. Elasticsearch licenses this file to you under
import static org.opensearch.index.query.QueryBuilders.termQuery;
                0
    }
            for (int i = 0; i < numDocs; i++) {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
    /** Script to take a field name in params and sum the values of the field. */
        }, fieldType);
            Collections.emptyMap()
        // Summing up some big double values and expect infinity result
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
        });
import org.apache.lucene.document.Document;
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("avg").field("value")
        multiReader.close();
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("values")
    public void testSingleValuedFieldPartiallyUnmapped() throws IOException {
        for (int i = 0; i < 10; i++) {
     * Make sure that an aggregation using a deterministic script does gets cached while
            .field("value")
            assertEquals(Double.NaN, avg.getValue(), 0);
        }, fieldType);
    /**
    public void testMultiValuedField() throws IOException {
                    );
            assertTrue(AggregationInspectionHelper.hasValue(avg));
    public void testSupportsIntraSegmentSearch() throws IOException {
 *
        aggregator.preCollection();
        directory.close();
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
        testAggregation(new MatchAllDocsQuery(), iw -> {
            iw.addDocument(singleton(new NumericDocValuesField("number", 3)));
import org.opensearch.script.ScriptEngine;
import org.apache.lucene.index.MultiReader;
    public void testSingleValuedField_WithFormatter() throws IOException {
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                Document document = new Document();
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
            // Intentionally not writing any docs
                iw.addDocument(document);
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.emptyMap()));
            iw.addDocument(singleton(new NumericDocValuesField("number", 2)));
    public static final String VALUE_FIELD_SCRIPT = "value_field";
            assertTrue(AggregationInspectionHelper.hasValue(avg));
import org.opensearch.search.aggregations.AggregatorFactories;
        nonDeterministicScripts.put(RANDOM_SCRIPT, vars -> AvgAggregatorTests.randomDouble());
        }, avg -> {
            assertEquals(
        params.put("field", "value");
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        unmappedDirectory.close();
            String fieldname = (String) vars.get("field");
    /** Script to return the {@code _value} provided by aggs framework. */
            assertTrue(AggregationInspectionHelper.hasValue(avg));
            final int numDocs = 10;
        }, avg -> {
        assertEquals(5.5, avg.getValue(), 0);
 * specific language governing permissions and limitations
        verifyAvgOfDoubles(largeValues, Double.POSITIVE_INFINITY, 0d);
    }
    }
    public void testScriptSingleValued() throws IOException {
                return 0;
            assertFalse(AggregationInspectionHelper.hasValue(avg));
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
        assertEquals(4, avg.getValue(), 0);
            iw.addDocument(singleton(new NumericDocValuesField("number", 7)));
    public static final String RANDOM_SCRIPT = "Math.random()";
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
            );
            Avg avg = filter.getAggregations().get("avg");
            List<Long> values = new ArrayList<>();
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("number").missing(0L);
            }
    }
        testAggregation(new FieldExistsQuery("number"), iw -> {
        return Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.BOOLEAN, CoreValuesSourceType.DATE);
        MultiReader multiReader = new MultiReader(indexReader, unamappedIndexReader);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        aggregator.preCollection();
import org.opensearch.script.ScriptModule;
        IndexReader unamappedIndexReader = DirectoryReader.open(unmappedDirectory);
        RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory);
            for (int i = 0; i < numDocs; i++) {
        Directory directory = newDirectory();
                document.add(new SortedNumericDocValuesField("values", i + 3));
            );
            assertEquals(0.0, avg.getValue(), 0);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
            assertEquals((double) (2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 + 11) / 10, avg.getValue(), 0);
        }, avg -> {
            assertTrue(AggregationInspectionHelper.hasValue(avg));
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
                (double) (2 + 3 + 3 + 4 + 4 + 5 + 5 + 6 + 6 + 7 + 7 + 8 + 8 + 9 + 9 + 10 + 10 + 11 + 11 + 12) / 20,
            for (int i = 0; i < numDocs; i++) {
            if (vars == null || vars.containsKey("inc") == false) {
    }
        }, avg -> {
import org.apache.lucene.util.NumericUtils;
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").script(
            final int numDocs = 10;
        IndexReader unamappedIndexReader = DirectoryReader.open(unmappedDirectory);
        assertTrue(aggregator.context().getQueryShardContext().isCacheable());
    public void testScriptMultiValuedWithParams() throws Exception {
import org.opensearch.common.settings.Settings;
            return values;
        for (int i = 0; i < n; i++) {
        }, fieldType);
import java.util.HashMap;
        });
                0
import java.util.Map;
                document.add(new SortedNumericDocValuesField("values", i + 2));
import java.util.List;
        MultiReader multiReader = new MultiReader(indexReader, unamappedIndexReader);
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
 * GitHub history for details.
import org.opensearch.index.mapper.MappedFieldType;
            assertTrue(AggregationInspectionHelper.hasValue(avg));
            assertEquals(4.0, avg.getProperty("value"));
            sum += values[i];
            iw.addDocument(Arrays.asList(new IntPoint("number", 3), new SortedNumericDocValuesField("number", 3)));
                    .build(
import org.opensearch.script.Script;
        scripts.put(SUM_VALUES_FIELD_SCRIPT, vars -> sum.apply(vars, "values"));
            assertTrue(AggregationInspectionHelper.hasValue(avg));
import org.opensearch.search.aggregations.AggregatorTestCase;
 *
import org.apache.lucene.search.MatchAllDocsQuery;
        testAggregation(IntPoint.newRangeQuery("number", -1, 0), iw -> {
            for (int i = 0; i < numDocs; i++) {
            largeValues[i] = -Double.MAX_VALUE;
import static java.util.Collections.singleton;
            int inc = getInc.apply(vars);
            return ((Number) vars.get("_value")).doubleValue() + inc;
                document.add(new SortedNumericDocValuesField("values", i + 3));
        scripts.put(SUM_FIELD_PARAMS_SCRIPT, vars -> {
            nonDeterministicScripts,
        indexWriter.close();
            assertTrue(AggregationInspectionHelper.hasValue(avg));
            .subAggregation(
                0
        });
        assertNotNull(buckets);
    /** Script to sum the values of a field named {@code values}. */
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, params));
import org.opensearch.search.aggregations.support.ValuesSourceType;
 */
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 2)));
                avg.getValue(),
        unmappedDirectory.close();
 * this work for additional information regarding copyright
    @Override
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("avg").field("value");
            final int numDocs = 10;
        }
        testAggregation(new MatchAllDocsQuery(), iw -> {
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
     */
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 7)));
        // Test that an aggregation using a deterministic script gets cached
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", 1)));
        Consumer<InternalAvg> verify,
        // Summing up an array which contains NaN and infinities and expect a result same as naive summation
            try (IndexReader reader = indexWriter.getReader()) {
        indexWriter.close();
        };
        }, fieldType);
        AvgAggregator aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
        indexReader.close();
        RandomIndexWriter unmappedIndexWriter = new RandomIndexWriter(random(), unmappedDirectory);
    public void testQueryFiltering() throws IOException {
        directory.close();
                return ((Number) vars.get("inc")).intValue();
        // Test that an aggregation not using a script does get cached
        assertTrue(AggregationInspectionHelper.hasValue(avg));
        AggregationBuilder aggregationBuilder = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.NUMERIC)
                avg.getValue(),
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
    }
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("number");
        aggregator.postCollection();
        }
        assertTrue(avg.getValue() >= 0.0);
            }
import org.opensearch.search.aggregations.AggregationBuilders;
    }
            assertTrue(AggregationInspectionHelper.hasValue(avg));
            iw.addDocument(singleton(new NumericDocValuesField("number", 3)));
    }
                document.add(new SortedNumericDocValuesField("values", i + 3));
/*
            );
    public void testSomeMatchesNumericDocValues() throws IOException {
import java.util.function.Consumer;
    }
    public void testOrderByEmptyAggregation() throws IOException {
        aggregator.postCollection();
            for (double value : values) {
import org.opensearch.search.aggregations.bucket.terms.Terms;
        double sum = 0;
    }
import java.util.Collections;
            assertEquals(Double.NaN, avg.getValue(), 0);
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.search.Query;
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").script(
        });
 * not use this file except in compliance with the License.
        testAggregation(IntPoint.newRangeQuery("number", 0, 3), iw -> {
    }
     */
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexReader indexReader = DirectoryReader.open(directory);
        final int numDocs = 10;
    private void testAggregation(Query query, CheckedConsumer<RandomIndexWriter, IOException> buildIndex, Consumer<InternalAvg> verify)
        for (int i = 0; i < n; i++) {
                Document document = new Document();
        });
    public static final String SUM_VALUES_FIELD_SCRIPT = "sum_values_field";
import org.opensearch.script.ScriptType;
            assertEquals(4, avg.getValue(), 0);
        });
            }
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));
                Document document = new Document();
    }
        }, avg -> {
        final int numDocs = 10;
        scripts.put(VALUE_FIELD_SCRIPT, vars -> sum.apply(vars, "value"));
            );
        for (int i = 0; i < numDocs; i++) {
}
        values = new double[n];
    public void testSingleValuedFieldWithValueScriptWithParams() throws IOException {
import java.util.function.Function;
            final int numDocs = 10;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
            assertTrue(AggregationInspectionHelper.hasValue(avg));
import org.opensearch.search.aggregations.bucket.filter.Filter;
        });
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
            }
            return sum.apply(vars, fieldname);
    public void testNoDocs() throws IOException {
        InternalAvg avg = (InternalAvg) aggregator.buildAggregation(0L);
            assertEquals((long) i + 1, bucket.getKeyAsNumber());
                ? randomFrom(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
        MappedFieldType fieldType
            for (int i = 0; i < numDocs; i++) {
    }
    public void testSomeMatchesSortedNumericDocValues() throws IOException {
            Terms.Bucket bucket = buckets.get(i);
            assertEquals((2 + 3 + 3 + 4 + 4 + 5 + 5 + 6 + 6 + 7 + 7 + 8 + 8 + 9 + 9 + 10 + 10 + 11 + 11 + 12) / 20, avg.getValue(), 0);
                : randomDoubleBetween(Double.MIN_VALUE, Double.MAX_VALUE, true);
        testAggregation(new MatchAllDocsQuery(), iw -> {
        scripts.put(VALUE_SCRIPT, vars -> {
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        for (int i = 0; i < numDocs; i++) {
            assertNotNull(avg);
import org.opensearch.search.aggregations.AggregationBuilder;
            Filter filter = bucket.getAggregations().get("filter");
        aggregator = createAggregator(aggregationBuilder, indexSearcher, fieldType);
            iw.addDocument(singleton(new SortedNumericDocValuesField("number", 3)));
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SUM_FIELD_PARAMS_SCRIPT, params)
        }, (MappedFieldType) null);
        }, avg -> {
        Map<String, Object> params = Collections.singletonMap("inc", 1);
        }
    public void testScriptSingleValuedWithParams() throws IOException {
    public void testUnmappedField() throws IOException {
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SUM_VALUES_FIELD_SCRIPT, Collections.emptyMap())
            assertEquals(Double.NaN, avg.getValue(), 0);
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, params));
        IndexReader indexReader = DirectoryReader.open(directory);
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
        );
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        aggregator.postCollection();
        assertTrue(AggregationInspectionHelper.hasValue(avg));
        );
    /** Script to return a random double */
        verifyAvgOfDoubles(values, sum / n, 1e-10);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregator;
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));
        directory.close();
        Map<String, Object> params = new HashMap<>();
            for (int i = 0; i < numDocs; i++) {
            assertTrue(AggregationInspectionHelper.hasValue(avg));
            final int numDocs = 10;
    }
        params.put("inc", 1);
        indexWriter.addDocument(singleton(new NumericDocValuesField("number", 7)));
            assertEquals(4, avg.getValue(), 0);
        double[] largeValues = new double[n];
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_FIELD_SCRIPT, Collections.emptyMap())
                (double) (2 + 3 + 3 + 4 + 4 + 5 + 5 + 6 + 6 + 7 + 7 + 8 + 8 + 9 + 9 + 10 + 10 + 11 + 11 + 12) / 20,
                document.add(new SortedNumericDocValuesField("values", i + 2));
            assertNotNull(filter);
        indexWriter.close();
    }
    /**
            }
        throws IOException {
        IndexReader indexReader = DirectoryReader.open(directory);
                document.add(new SortedNumericDocValuesField("values", i + 3));
                (double) (3 + 4 + 4 + 5 + 5 + 6 + 6 + 7 + 7 + 8 + 8 + 9 + 9 + 10 + 10 + 11 + 11 + 12 + 12 + 13) / 20,
        }, fieldType);
        assertEquals("avg", avg.getName());
import org.apache.lucene.store.Directory;
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * under the License.
    }
import org.opensearch.search.aggregations.support.ValueType;
        BiFunction<Map<String, Object>, String, Object> sum = (vars, fieldname) -> {
        );
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("value")
    }
        });
                (double) (3 + 4 + 4 + 5 + 5 + 6 + 6 + 7 + 7 + 8 + 8 + 9 + 9 + 10 + 10 + 11 + 11 + 12 + 12 + 13) / 20,
import java.util.function.BiFunction;
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
    }
            assertEquals(Double.NaN, avg.getValue(), 0);
            .order(BucketOrder.compound(BucketOrder.aggregation("filter>avg", true)))
package org.opensearch.search.aggregations.metrics;
        assertTrue(avg.getValue() <= 1.0);
            assertEquals(
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").format("#")
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
import org.apache.lucene.document.IntPoint;
/*
        for (int i = 0; i < n; i++) {
            int inc = getInc.apply(vars);
import java.io.IOException;
    }
    public void testSingleValuedFieldWithValueScript() throws IOException {
                iw.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
            for (int i = 0; i < numDocs; i++) {
                iw.addDocument(document);
    public void testMultiValuedFieldWithValueScript() throws IOException {
            scripts,
            for (int i = 0; i < numDocs; i++) {
     * Make sure that an aggregation not using a script does get cached.
        Map<String, Object> params = Collections.singletonMap("inc", 1);
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("number");
        InternalAvg avg = (InternalAvg) aggregator.buildAggregation(0L);
    }
        assertEquals("avg", avg.getName());
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.9, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7 };
        verifyAvgOfDoubles(values, 0.9, 0d);
        RandomIndexWriter unmappedIndexWriter = new RandomIndexWriter(random(), unmappedDirectory);
        assertNotNull(terms);
        }
            }
 * Modifications Copyright OpenSearch Contributors. See
    private void testAggregation(
        testAggregation(new MatchAllDocsQuery(), iw -> {
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("value")
                avg.getValue(),
 */
        InternalAvg avg = (InternalAvg) aggregator.buildAggregation(0L);
    }
 *
        aggregationBuilder = new AvgAggregationBuilder("avg").field("value")
        }
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        assertTrue(AggregationInspectionHelper.hasValue(avg));
            assertEquals("6", avg.getValueAsString());
        }, avg -> {
            }
    }
import org.opensearch.search.aggregations.BucketOrder;
 * KIND, either express or implied.  See the License for the
            iw.addDocument(Arrays.asList(new IntPoint("number", 7), new SortedNumericDocValuesField("number", 7)));
import org.apache.lucene.document.SortedNumericDocValuesField;
        params.put("inc", 1);
        }, avg -> {
        n = randomIntBetween(5, 10);
                assertTrue(factories.allFactoriesSupportIntraSegmentSearch());
        MockScriptEngine scriptEngine = new MockScriptEngine(
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("number", NumberFieldMapper.NumberType.INTEGER);
        }, avg -> {
            }
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
            iw.addDocument(singleton(new NumericDocValuesField("number", 1)));
            for (int i = 0; i < numDocs; i++) {
        }, avg -> {
        verifyAvgOfDoubles(largeValues, Double.NEGATIVE_INFINITY, 0d);
        unmappedIndexWriter.close();
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.INTEGER);
        indexSearcher.search(new MatchAllDocsQuery(), aggregator);
        assertEquals(10, buckets.size());
        IndexSearcher indexSearcher = newSearcher(multiReader, true, true);
            assertTrue(AggregationInspectionHelper.hasValue(avg));
import java.util.Arrays;
                            .getQueryShardContext(),
            assertEquals((double) (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10) / 10, avg.getValue(), 0);
        }, avg -> {
        }
        assertEquals(3, avg.getCount(), 0);
        RandomIndexWriter unmappedIndexWriter = new RandomIndexWriter(random(), unmappedDirectory);
    public void testNoMatchingField() throws IOException {
                document.add(new SortedNumericDocValuesField("values", i + 2));
    public static final String VALUE_SCRIPT = "_value";
                iw.addDocument(document);
        testAggregation(aggregationBuilder, new FieldExistsQuery("number"), iw -> {
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.emptyMap()));
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", i + 1)));
        AvgAggregationBuilder aggregationBuilder = new AvgAggregationBuilder("_name").field("values")
        testAggregation(new FieldExistsQuery("number"), iw -> {
            for (Object v : docLookup.get(fieldname)) {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("values", NumberFieldMapper.NumberType.INTEGER);
 * this file be licensed under the Apache-2.0 license or a
    }
 * Licensed to Elasticsearch under one or more contributor
    public void testScriptMultiValued() throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        aggregator.postCollection();
            }
            iw.addDocument(Arrays.asList(new IntPoint("number", 1), new SortedNumericDocValuesField("number", 2)));
        // Summing up a normal array and expect an accurate value
        }, avg -> {
import org.apache.lucene.search.IndexSearcher;
    }
                values.add(((Number) v).longValue() + inc);
        }, fieldType);
        }, avg -> {
    public void testMultiValuedFieldWithValueScriptWithParams() throws IOException {
        unmappedIndexWriter.close();
            assertEquals(
            assertEquals(0L, filter.getDocCount());
        // Test that an aggregation using a nondeterministic script does not get cached
        });
        Directory directory = newDirectory();
