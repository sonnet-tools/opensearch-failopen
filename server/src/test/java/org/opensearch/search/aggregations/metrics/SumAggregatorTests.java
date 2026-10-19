                    .mapToObj(value -> singleton(new NumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(value))))
            iw.addDocument(Arrays.asList(new StringField("match", "yes", Field.Store.NO), new NumericDocValuesField(FIELD_NAME, 3)));
        }, result -> assertEquals(expected, result.getValue(), delta), defaultFieldType(NumberType.DOUBLE));
        testAggregation(sum("_name").field(FIELD_NAME), new MatchAllDocsQuery(), iw -> {
        final int valuesPerField = randomIntBetween(2, 5);
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
import static java.util.Collections.singletonMap;  
import java.util.function.Function;
import org.apache.lucene.document.SortedDocValuesField;
        }
import org.opensearch.script.ScriptService;
    private static final String VALUE_SCRIPT_NAME = "value_script";
        }  
            sum("_name").script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, FIELD_SCRIPT_NAME, singletonMap("field", FIELD_NAME))),
                assertEquals(sum + (docs.size() * valuesPerField), result.getValue(), 0d);
    private static final String FIELD_SCRIPT_NAME = "field_script";
            assertFalse(AggregationInspectionHelper.hasValue(count));  
}
            irrelevantField
    public void testPartiallyUnmapped() throws IOException {
        final int numDocs = randomIntBetween(10, 100);
    private void testAggregation(  
    public void testSortedNumericDocValues() throws IOException {
    public void testFieldScriptSingleValuedField() throws IOException {
import org.apache.lucene.util.NumericUtils;  
            new RandomIndexWriter(random(), unmappedDirectory).close();  
            assertEquals(0L, count.getValue(), 0d);
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 2)));
                IndexReader unmappedReader = DirectoryReader.open(unmappedDirectory);
            if (randomBoolean()) {  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                + "Re-index with correct docvalues type.",  
            sum("_name").field(FIELD_NAME).script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT_NAME, emptyMap())),
                docs.add(singleton(new NumericDocValuesField(irrelevantField.name(), randomLong())));  
        verifySummationOfDoubles(values, 15.3, Double.MIN_NORMAL);
        final List<Set<IndexableField>> docs = new ArrayList<>(numDocs);
        AggregationBuilder aggregationBuilder,
                mappedWriter.addDocuments(docs);  
                assertTrue(AggregationInspectionHelper.hasValue(internalSum));  
        });
                assertEquals(sum, internalSum.getValue(), 0d);
            iw.addDocument(Arrays.asList(new StringField("match", "no", Field.Store.NO), new NumericDocValuesField(FIELD_NAME, 4)));  
        for (int i = 0; i < n; i++) {  
 * Unless required by applicable law or agreed to in writing,
                docs.add(singleton(new NumericDocValuesField(aggField.name(), value)));  
        }
             * segment as though it were a separate shard, then reduces
            assertFalse(AggregationInspectionHelper.hasValue(result));
        return Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.BOOLEAN, CoreValuesSourceType.DATE);  
    ) throws IOException {  
                    );
    @Override  
                final LeafDocLookup lookup = (LeafDocLookup) vars.get("doc");
        final MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(FIELD_NAME, NumberType.LONG);  
                assertTrue(AggregationInspectionHelper.hasValue(result));
 * Modifications Copyright OpenSearch Contributors. See  
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
import org.opensearch.script.MockScriptEngine;
        );
    }  
    public void testValueScriptSingleValuedField() throws IOException {
            vars -> ((Number) vars.get("_value")).doubleValue() + 1,  
        for (int iDoc = 0; iDoc < numDocs; iDoc++) {
    public void testNoDocs() throws IOException {
            }  
        assertEquals(
 */
             */
        verifySummationOfDoubles(largeValues, Double.POSITIVE_INFINITY, 0d);
    }  
                assertEquals(sum + docs.size(), result.getValue(), 0d);
 * not use this file except in compliance with the License.
            );
        final int numDocs = randomIntBetween(10, 100);
    @Override
                IndexReader mappedReader = DirectoryReader.open(mappedDirectory);  
        final int valuesPerField = randomIntBetween(2, 5);
            internalSum -> {  
            }
    }
    }
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 2)));
    }
                IndexSearcher searcher = newIndexSearcher(reader);
        final MappedFieldType aggField = defaultFieldType();
        for (int i = 0; i < numDocs; i++) {
    public void testFieldScriptMultiValuedField() throws IOException {  
        // Summing up an array which contains NaN and infinities and expect a result same as naive summation
             * The sum agg uses a Kahan sumation on the shard to limit  
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
        });
        try (Directory mappedDirectory = newDirectory(); Directory unmappedDirectory = newDirectory()) {
    private static MappedFieldType defaultFieldType(NumberType numberType) {
                : randomDoubleBetween(Double.MIN_VALUE, Double.MAX_VALUE, true);
    }  
import org.opensearch.index.mapper.NumberFieldMapper;
        testAggregation(new FieldExistsQuery(FIELD_NAME), iw -> {  
            iw.addDocument(Arrays.asList(new StringField("match", "yes", Field.Store.NO), new NumericDocValuesField(FIELD_NAME, 5)));
                    assertFalse(AggregationInspectionHelper.hasValue(count));  
    }
    public void testMissing() throws IOException {  
import org.opensearch.script.ScriptModule;
                assertTrue(AggregationInspectionHelper.hasValue(internalSum));
        }, count -> {
 * Licensed to Elasticsearch under one or more contributor  
                final long value = randomLongBetween(0, 1000);
import org.apache.lucene.document.SortedNumericDocValuesField;  
            vars -> {
                assertTrue(AggregationInspectionHelper.hasValue(result));
                final InternalSum internalSum = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, fieldType);
    protected ScriptService getMockScriptService() {  
        }, count -> {
            1,
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7 };
    }
            docs.add(doc);
            sum += values[i];  
            aggField,
import java.util.Map;
    }  
import org.apache.lucene.search.MatchAllDocsQuery;  
        sumRandomDocsTestCase(randomIntBetween(1, 5), sum("_name").field("unknown_field"), (sum, docs, result) -> {
             * that.  
import java.util.HashSet;  
            }
        Query query,
import org.opensearch.index.mapper.MappedFieldType;
        double[] largeValues = new double[n];  
        int valuesPerField,  
            } else {
    private void verifySummationOfDoubles(double[] values, double expected, double delta) throws IOException {  
import org.apache.lucene.search.Query;
        CheckedConsumer<RandomIndexWriter, IOException> indexer,  
    private void sumRandomDocsTestCase(
            (sum, docs, result) -> {
import static java.util.stream.Collectors.toList;
                assertTrue(AggregationInspectionHelper.hasValue(result));
                assertEquals(sum + (docs.size() * valuesPerField), result.getValue(), 0d);  
    }
 */
        for (int i = 0; i < n; i++) {
        final long missingValue = randomLongBetween(1, 1000);
        TriConsumer<Long, List<Set<IndexableField>>, InternalSum> verify
        );
        return new NumberFieldMapper.NumberFieldType(FIELD_NAME, numberType);  
        testAggregation(new MatchAllDocsQuery(), iw -> {
        Consumer<InternalSum> verify,
            }  
            "unexpected docvalues type SORTED for field 'field' (expected one of [SORTED_NUMERIC, NUMERIC]). "
                final String fieldName = (String) vars.get("field");  
        sumRandomDocsTestCase(
        int sum = 0;  
            iw.addDocument(singleton(new SortedNumericDocValuesField(FIELD_NAME, 1)));  
import java.util.ArrayList;
             * all the documents on the same leaf. `addDocuments` does
        }
    }
        }, count -> {
import java.util.Arrays;
            assertTrue(AggregationInspectionHelper.hasValue(count));
 *  
        }
                doc.add(new SortedNumericDocValuesField(fieldType.name(), value));  
            1,  
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));  
            docs.add(singleton(new NumericDocValuesField(fieldType.name(), value)));
        );
        MappedFieldType... fieldTypes
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.AggregatorTestCase;  
            assertEquals(15L, count.getValue(), 0d);
 */  
        });
            valuesPerField,  
        }
        );  
    }  
                MultiReader multiReader = new MultiReader(mappedReader, unmappedReader)
            fieldType
            try (IndexReader reader = indexWriter.getReader()) {  
                    .collect(toList())
        }, count -> {
        long sum = 0;  
                final IndexSearcher searcher = newSearcher(multiReader, true, true);
        SumAggregationBuilder builder,
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));  
    }  
            assertFalse(AggregationInspectionHelper.hasValue(count));
        long sum = 0;  
        n = randomIntBetween(5, 10);
 * You may obtain a copy of the License at  
    }
                AggregatorFactories factories = AggregatorFactories.builder()
 * specific language governing permissions and limitations
            (sum, docs, result) -> {  
            try (
        );  
        final Map<String, ScriptEngine> engines = singletonMap(engine.getType(), engine);  
            iw.addDocument(singleton(new NumericDocValuesField("wrong_number", 7)));  
/*
public class SumAggregatorTests extends AggregatorTestCase {
import org.apache.lucene.index.IndexableField;
import org.apache.lucene.search.TermQuery;
import org.opensearch.search.aggregations.support.ValuesSourceType;  
            assertTrue(AggregationInspectionHelper.hasValue(count));  
        testAggregation(new MatchAllDocsQuery(), iw -> {  
        });  
    }  
    public void testQueryFiltering() throws IOException {
            assertEquals(0L, count.getValue(), 0d);  
            try (RandomIndexWriter mappedWriter = new RandomIndexWriter(random(), mappedDirectory)) {
        });
        testAggregation(aggregationBuilder, query, indexer, verify, defaultFieldType());  
            (sum, docs, result) -> {
    }
        final int numDocs = randomIntBetween(10, 100);
            }
    }  
        testAggregation(new MatchAllDocsQuery(), iw -> {
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 2)));  
        }, count -> {
 * software distributed under the License is distributed on an
import org.apache.lucene.index.DirectoryReader;
                assertEquals(finalSum, internalSum.getValue(), 0d);
                Arrays.stream(values)  
            iw.addDocument(singleton(new NumericDocValuesField("wrong_number", 1)));
                assertTrue(factories.allFactoriesSupportIntraSegmentSearch());  
                sum += value;
            new MatchAllDocsQuery(),
        return new SumAggregationBuilder("_name").field(fieldName);
        testCase(aggregationBuilder, query, indexer, verify, fieldTypes);
import org.opensearch.common.settings.Settings;  
            },  
             * floating point errors. But it doesn't ship the sums to the
        for (int i = 0; i < n; i++) {
            iw.addDocument(Arrays.asList(new StringField("match", "no", Field.Store.NO), new NumericDocValuesField(FIELD_NAME, 2)));
import org.apache.lucene.document.Field;  
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.index.IndexReader;  
        final List<Set<IndexableField>> docs = new ArrayList<>(numDocs);
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
        throws IOException {
    private static final String FIELD_NAME = "field";  
                assertTrue(AggregationInspectionHelper.hasValue(result));
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 2)));
            indexWriter.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
                    .addAggregator(new SumAggregationBuilder("test").field(FIELD_NAME))  
import org.opensearch.common.TriConsumer;
import org.apache.lucene.tests.index.RandomIndexWriter;
    public void testValueScriptMultiValuedField() throws IOException {
                        null
        );  
        sumRandomDocsTestCase(  
    public void testStringField() throws IOException {
    @Override
        });
            /*
            new MatchAllDocsQuery(),
            }
import org.opensearch.search.aggregations.AggregatorFactories;
            iw.addDocuments(
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
            internalSum -> verify.apply(finalSum, docs, internalSum),
import static java.util.Collections.singleton;
import java.util.Set;  
            sum("_name").field(aggField.name()).missing(missingValue),  
import org.opensearch.search.lookup.LeafDocLookup;
import org.apache.lucene.index.Term;  
        final long finalSum = sum;
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 2)));  
 *
    }
import org.apache.lucene.store.Directory;  
import java.io.IOException;  
            valuesPerField,
        double sum = 0;
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
    }
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, defaultFieldType())
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
            }
            FIELD_SCRIPT_NAME,
 * SPDX-License-Identifier: Apache-2.0
            iw.addDocument(Arrays.asList(new SortedNumericDocValuesField(FIELD_NAME, 3), new SortedNumericDocValuesField(FIELD_NAME, 4)));
            }
    public void testMissingUnmapped() throws IOException {  
        sumRandomDocsTestCase(
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {  
        final MappedFieldType fieldType = defaultFieldType();
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 2)));
                    assertEquals(0L, count.getValue(), 0d);
    }
            VALUE_SCRIPT_NAME,
    private static MappedFieldType defaultFieldType() {
        testAggregation(  
            assertEquals(docs.size() * missingValue, result.getValue(), 0d);  
    }
        sumRandomDocsTestCase(randomIntBetween(1, 5), sum("_name").field("unknown_field").missing(missingValue), (sum, docs, result) -> {
        sumRandomDocsTestCase(  
        final MappedFieldType irrelevantField = new NumberFieldMapper.NumberFieldType("irrelevant_field", NumberType.LONG);
 * the Apache License, Version 2.0 (the "License"); you may
             * reducing many sums. The test framework aggregates each  
import java.util.List;
        final Map<String, Function<Map<String, Object>, Object>> scripts = Map.of(
        }
 * GitHub history for details.
package org.opensearch.search.aggregations.metrics;
import org.apache.lucene.document.StringField;
                final long value = randomLongBetween(0, 1000);
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 2)));
            values[i] = frequently()  
        );
        final SumAggregationBuilder builder = sum("_name").field(fieldType.name());
import org.opensearch.script.ScriptType;  
             * accuracy of the Kahan sumation. And *that* accuracy is  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;  
            assertEquals(24L, count.getValue(), 0d);  
            // Intentionally not writing any docs  
        verifySummationOfDoubles(largeValues, Double.NEGATIVE_INFINITY, 0d);  
import org.opensearch.script.ScriptEngine;  
            assertEquals(9L, count.getValue(), 0d);  
        final MockScriptEngine engine = new MockScriptEngine(MockScriptEngine.NAME, scripts, emptyMap());
            e.getMessage()
            final long value = randomLongBetween(0, 1000);
import org.opensearch.script.Script;
            }  
        testAggregation(
            iw.addDocument(Arrays.asList(new SortedNumericDocValuesField(FIELD_NAME, 3), new SortedNumericDocValuesField(FIELD_NAME, 4)));
                }
                assertEquals(sum + docs.size(), result.getValue(), 0d);  
        // Summing up a normal array and expect an accurate value  
    public void testNoMatchingField() throws IOException {
                    .build(
import org.opensearch.search.aggregations.AggregationBuilder;
 * ownership. Elasticsearch licenses this file to you under  
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 2)));
                new MatchAllDocsQuery(),
import org.apache.lucene.search.FieldExistsQuery;
 *
    }  
            writer -> writer.addDocuments(docs),
    ) throws IOException {  
            }
            largeValues[i] = -Double.MAX_VALUE;
        });
            assertEquals(0d, result.getValue(), 0d);  
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
        final long finalSum = sum;  
    public void testSupportsIntraSegmentSearch() throws IOException {  
                count -> {
import static java.util.Collections.emptyMap;
        for (int i = 0; i < numDocs; i++) {
 * license agreements. See the NOTICE file distributed with
    public void testSummationAccuracy() throws IOException {
 * compatible open source license.
        testAggregation(new TermQuery(new Term("match", "yes")), iw -> {
                iw -> { iw.addDocument(singleton(new SortedDocValuesField(FIELD_NAME, new BytesRef("1")))); },  
    public void testUnmapped() throws IOException {
             * what this method is trying to test. So we have to stick
            Set<IndexableField> doc = new HashSet<>();
            largeValues[i] = Double.MAX_VALUE;
 * this file be licensed under the Apache-2.0 license or a
            for (int iValue = 0; iValue < valuesPerField; iValue++) {  
        values = new double[n];  
        verifySummationOfDoubles(values, sum, 1e-10);
        final long missingValue = randomLongBetween(1, 1000);
        );  
            );  
            writer -> writer.addDocuments(docs),  
                ? randomFrom(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
        return defaultFieldType(NumberType.LONG);
            sum += (int) value;  
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.index.MultiReader;
            testAggregation(
                sum += value;
import org.opensearch.common.CheckedConsumer;
    public void testNumericDocValues() throws IOException {
                return lookup.get(fieldName).stream().map(value -> ((Number) value).longValue() + 1).collect(toList());
import org.apache.lucene.document.NumericDocValuesField;
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        // Summing up some big double values and expect infinity result
        }  
import org.apache.lucene.search.IndexSearcher;
            builder,
    private void testAggregation(Query query, CheckedConsumer<RandomIndexWriter, IOException> indexer, Consumer<InternalSum> verify)  
                            .getQueryShardContext(),  
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
/*  
            assertTrue(AggregationInspectionHelper.hasValue(count));
                sum += missingValue;
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));  
            (sum, docs, result) -> {  
 * this work for additional information regarding copyright
             * coordinating node, so floaing point error can creep in when
    }  
    }
        });
        AggregationBuilder aggregationBuilder = sum("_name").field(FIELD_NAME);
             * those togther. Fun. But it means we don't get the full
            assertTrue(AggregationInspectionHelper.hasValue(result));
        int n = randomIntBetween(5, 10);
            sum("_name").field(FIELD_NAME).script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT_NAME, emptyMap())),
            iw.addDocument(Arrays.asList(new StringField("match", "yes", Field.Store.NO), new NumericDocValuesField(FIELD_NAME, 1)));  
        final List<Set<IndexableField>> docs = new ArrayList<>(numDocs);
            ) {  
import java.util.function.Consumer;
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
            sum("_name").script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, FIELD_SCRIPT_NAME, singletonMap("field", FIELD_NAME))),
