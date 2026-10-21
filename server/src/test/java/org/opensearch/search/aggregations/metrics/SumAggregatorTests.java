public class SumAggregatorTests extends AggregatorTestCase {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final long finalSum = sum;
             * floating point errors. But it doesn't ship the sums to the
    public void testNumericDocValues() throws IOException {
        for (int iDoc = 0; iDoc < numDocs; iDoc++) {
 * Unless required by applicable law or agreed to in writing,
        final SumAggregationBuilder builder = sum("_name").field(fieldType.name());
            iw.addDocument(Arrays.asList(new StringField("match", "no", Field.Store.NO), new NumericDocValuesField(FIELD_NAME, 2)));
        for (int i = 0; i < n; i++) {
import java.util.HashSet;
import java.util.Map;
    public void testSummationAccuracy() throws IOException {
        testAggregation(new MatchAllDocsQuery(), iw -> {
            irrelevantField
import java.util.Arrays;
            writer -> writer.addDocuments(docs),
    private void testAggregation(Query query, CheckedConsumer<RandomIndexWriter, IOException> indexer, Consumer<InternalSum> verify)
            vars -> ((Number) vars.get("_value")).doubleValue() + 1,
package org.opensearch.search.aggregations.metrics;
        }, count -> {
import org.apache.lucene.search.IndexSearcher;
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
    }
            assertEquals(docs.size() * missingValue, result.getValue(), 0d);
        sumRandomDocsTestCase(
        }, count -> {
    protected ScriptService getMockScriptService() {
        }, count -> {
        TriConsumer<Long, List<Set<IndexableField>>, InternalSum> verify
            sum("_name").field(FIELD_NAME).script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT_NAME, emptyMap())),
            aggField,
            }
            iw.addDocument(singleton(new SortedNumericDocValuesField(FIELD_NAME, 1)));
        });
        Consumer<InternalSum> verify,
            assertEquals(0L, count.getValue(), 0d);
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7 };
 * software distributed under the License is distributed on an
                assertTrue(AggregationInspectionHelper.hasValue(result));
import org.opensearch.index.mapper.MappedFieldType;
            values[i] = frequently()
             * what this method is trying to test. So we have to stick
    }
        });
 * ownership. Elasticsearch licenses this file to you under
                    assertEquals(0L, count.getValue(), 0d);
            sum += values[i];
        }
                assertEquals(sum + docs.size(), result.getValue(), 0d);
        }
        );
 * specific language governing permissions and limitations
            try (RandomIndexWriter mappedWriter = new RandomIndexWriter(random(), mappedDirectory)) {
import org.apache.lucene.index.IndexableField;
            writer -> writer.addDocuments(docs),
            assertFalse(AggregationInspectionHelper.hasValue(result));
                final IndexSearcher searcher = newSearcher(multiReader, true, true);
            assertTrue(AggregationInspectionHelper.hasValue(count));
        testAggregation(new TermQuery(new Term("match", "yes")), iw -> {
/*
            internalSum -> verify.apply(finalSum, docs, internalSum),
                }
        final MappedFieldType fieldType = defaultFieldType();
                MultiReader multiReader = new MultiReader(mappedReader, unmappedReader)
            FIELD_SCRIPT_NAME,
                    );
                doc.add(new SortedNumericDocValuesField(fieldType.name(), value));
 * not use this file except in compliance with the License.
import org.opensearch.common.TriConsumer;
    public void testMissing() throws IOException {
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
        int sum = 0;
            new MatchAllDocsQuery(),
    }
                assertTrue(AggregationInspectionHelper.hasValue(result));
            }
        return new SumAggregationBuilder("_name").field(fieldName);
import org.apache.lucene.document.SortedNumericDocValuesField;
            // Intentionally not writing any docs
    public void testSortedNumericDocValues() throws IOException {
            assertEquals(9L, count.getValue(), 0d);
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 2)));
        testAggregation(sum("_name").field(FIELD_NAME), new MatchAllDocsQuery(), iw -> {
 */
    ) throws IOException {
        final int valuesPerField = randomIntBetween(2, 5);
import org.apache.lucene.index.IndexReader;
            }
            (sum, docs, result) -> {
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
import java.util.Set;
    }
import org.opensearch.search.aggregations.AggregatorFactories;
import static java.util.Collections.singleton;
    public void testFieldScriptMultiValuedField() throws IOException {
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
            1,
        sumRandomDocsTestCase(randomIntBetween(1, 5), sum("_name").field("unknown_field").missing(missingValue), (sum, docs, result) -> {
            builder,
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 2)));
             * those togther. Fun. But it means we don't get the full
        final List<Set<IndexableField>> docs = new ArrayList<>(numDocs);
    }
                final InternalSum internalSum = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, fieldType);
    }
import java.io.IOException;
        long sum = 0;
 * this file be licensed under the Apache-2.0 license or a
                count -> {
    }
                        null
            if (randomBoolean()) {
        testAggregation(new FieldExistsQuery(FIELD_NAME), iw -> {
import static java.util.stream.Collectors.toList;
        final MappedFieldType aggField = defaultFieldType();
import org.apache.lucene.document.StringField;
        SumAggregationBuilder builder,
        testAggregation(new MatchAllDocsQuery(), iw -> {
                docs.add(singleton(new NumericDocValuesField(aggField.name(), value)));
        );
    private static final String FIELD_NAME = "field";
        }
        sumRandomDocsTestCase(
            final long value = randomLongBetween(0, 1000);
    public void testStringField() throws IOException {
    public void testMissingUnmapped() throws IOException {
            } else {
            sum("_name").field(aggField.name()).missing(missingValue),
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 2)));
            new RandomIndexWriter(random(), unmappedDirectory).close();
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 2)));
                sum += value;
            iw.addDocument(Arrays.asList(new SortedNumericDocValuesField(FIELD_NAME, 3), new SortedNumericDocValuesField(FIELD_NAME, 4)));
                assertEquals(sum + docs.size(), result.getValue(), 0d);
    public void testValueScriptMultiValuedField() throws IOException {
            assertEquals(0L, count.getValue(), 0d);
                assertTrue(AggregationInspectionHelper.hasValue(result));
import org.opensearch.common.CheckedConsumer;
import org.apache.lucene.document.SortedDocValuesField;
 * Licensed to Elasticsearch under one or more contributor
            sum += (int) value;
             * that.
import org.opensearch.common.settings.Settings;
import org.opensearch.script.ScriptModule;
        }
        n = randomIntBetween(5, 10);
            (sum, docs, result) -> {
        verifySummationOfDoubles(values, sum, 1e-10);
                    .build(
 * GitHub history for details.
                assertTrue(factories.allFactoriesSupportIntraSegmentSearch());
 * KIND, either express or implied.  See the License for the
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
 * The OpenSearch Contributors require contributions made to
    }
                IndexReader unmappedReader = DirectoryReader.open(unmappedDirectory);
                Arrays.stream(values)
/*
    }
    }
            e.getMessage()
        );
    @Override
 * Modifications Copyright OpenSearch Contributors. See
            internalSum -> {
 */
             * coordinating node, so floaing point error can creep in when
        }
        final int numDocs = randomIntBetween(10, 100);
        final Map<String, ScriptEngine> engines = singletonMap(engine.getType(), engine);
import org.opensearch.script.ScriptType;
        // Summing up an array which contains NaN and infinities and expect a result same as naive summation
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
            Set<IndexableField> doc = new HashSet<>();
        );
                    .collect(toList())
            }
             * reducing many sums. The test framework aggregates each
            );
            }
                assertTrue(AggregationInspectionHelper.hasValue(result));
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
        sumRandomDocsTestCase(
        int n = randomIntBetween(5, 10);
        throws IOException {
                final String fieldName = (String) vars.get("field");
        try (Directory mappedDirectory = newDirectory(); Directory unmappedDirectory = newDirectory()) {
        final long missingValue = randomLongBetween(1, 1000);
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        });
    public void testNoDocs() throws IOException {
import org.apache.lucene.index.Term;
                final long value = randomLongBetween(0, 1000);
    private static final String FIELD_SCRIPT_NAME = "field_script";
            iw.addDocument(Arrays.asList(new StringField("match", "yes", Field.Store.NO), new NumericDocValuesField(FIELD_NAME, 5)));
                sum += value;
            assertTrue(AggregationInspectionHelper.hasValue(count));
            ) {
            assertFalse(AggregationInspectionHelper.hasValue(count));
        testAggregation(
            sum("_name").script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, FIELD_SCRIPT_NAME, singletonMap("field", FIELD_NAME))),
import org.apache.lucene.document.Field;
            fieldType
        for (int i = 0; i < numDocs; i++) {
            /*
            1,
                            .getQueryShardContext(),
            );
    }
            (sum, docs, result) -> {
        MappedFieldType... fieldTypes
        for (int i = 0; i < n; i++) {
import static java.util.Collections.emptyMap;
        CheckedConsumer<RandomIndexWriter, IOException> indexer,
             * The sum agg uses a Kahan sumation on the shard to limit
        final MockScriptEngine engine = new MockScriptEngine(MockScriptEngine.NAME, scripts, emptyMap());
    }
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, defaultFieldType())
            }
        return defaultFieldType(NumberType.LONG);
            iw.addDocument(Arrays.asList(new StringField("match", "no", Field.Store.NO), new NumericDocValuesField(FIELD_NAME, 4)));
            assertTrue(AggregationInspectionHelper.hasValue(count));
 *
    public void testUnmapped() throws IOException {
import org.apache.lucene.index.DirectoryReader;
            sum("_name").field(FIELD_NAME).script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT_NAME, emptyMap())),
            new MatchAllDocsQuery(),
        });
 * You may obtain a copy of the License at
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 2)));
        });
                assertTrue(AggregationInspectionHelper.hasValue(internalSum));
            try (
        final int numDocs = randomIntBetween(10, 100);
import org.opensearch.script.MockScriptEngine;
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
        }
             * segment as though it were a separate shard, then reduces
import org.opensearch.script.ScriptService;
        for (int i = 0; i < n; i++) {
        final long finalSum = sum;
            }
import org.apache.lucene.util.NumericUtils;
        return Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.BOOLEAN, CoreValuesSourceType.DATE);
            docs.add(singleton(new NumericDocValuesField(fieldType.name(), value)));
    }
                docs.add(singleton(new NumericDocValuesField(irrelevantField.name(), randomLong())));
 */
        });
                assertEquals(sum + (docs.size() * valuesPerField), result.getValue(), 0d);
             */
             * accuracy of the Kahan sumation. And *that* accuracy is
    }
import org.apache.lucene.index.MultiReader;
        testAggregation(aggregationBuilder, query, indexer, verify, defaultFieldType());
        );
        int valuesPerField,
        AggregationBuilder aggregationBuilder = sum("_name").field(FIELD_NAME);
            }
        final int valuesPerField = randomIntBetween(2, 5);
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
                IndexSearcher searcher = newIndexSearcher(reader);
            try (IndexReader reader = indexWriter.getReader()) {
                return lookup.get(fieldName).stream().map(value -> ((Number) value).longValue() + 1).collect(toList());
            valuesPerField,
 *    http://www.apache.org/licenses/LICENSE-2.0
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
                    assertFalse(AggregationInspectionHelper.hasValue(count));
        values = new double[n];
    ) throws IOException {
            },
    @Override
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
                final long value = randomLongBetween(0, 1000);
import org.apache.lucene.search.TermQuery;
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 2)));
                : randomDoubleBetween(Double.MIN_VALUE, Double.MAX_VALUE, true);
                new MatchAllDocsQuery(),
import org.opensearch.search.aggregations.AggregatorTestCase;
        );
}
                assertTrue(AggregationInspectionHelper.hasValue(internalSum));
/*
            "unexpected docvalues type SORTED for field 'field' (expected one of [SORTED_NUMERIC, NUMERIC]). "
 * the Apache License, Version 2.0 (the "License"); you may
    }
            largeValues[i] = -Double.MAX_VALUE;
        });
        testAggregation(
import org.apache.lucene.util.BytesRef;
            VALUE_SCRIPT_NAME,
import java.util.ArrayList;
            (sum, docs, result) -> {
    public void testNoMatchingField() throws IOException {
import org.opensearch.search.lookup.LeafDocLookup;
import org.apache.lucene.search.MatchAllDocsQuery;
        );
        final long missingValue = randomLongBetween(1, 1000);
            assertEquals(0d, result.getValue(), 0d);
import org.apache.lucene.document.NumericDocValuesField;
            assertEquals(24L, count.getValue(), 0d);
 *
    }
            assertTrue(AggregationInspectionHelper.hasValue(result));
import org.apache.lucene.search.FieldExistsQuery;
    private void testAggregation(
                assertEquals(sum, internalSum.getValue(), 0d);
            for (int iValue = 0; iValue < valuesPerField; iValue++) {
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 2)));
        sumRandomDocsTestCase(randomIntBetween(1, 5), sum("_name").field("unknown_field"), (sum, docs, result) -> {
 * SPDX-License-Identifier: Apache-2.0
        AggregationBuilder aggregationBuilder,
    }
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 2)));
    private void sumRandomDocsTestCase(
            indexWriter.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
        testCase(aggregationBuilder, query, indexer, verify, fieldTypes);
        assertEquals(
    }
        // Summing up some big double values and expect infinity result
    public void testPartiallyUnmapped() throws IOException {
        final List<Set<IndexableField>> docs = new ArrayList<>(numDocs);
import org.opensearch.script.Script;
 * compatible open source license.
        for (int i = 0; i < numDocs; i++) {
                mappedWriter.addDocuments(docs);
        });
        double sum = 0;
    private static MappedFieldType defaultFieldType(NumberType numberType) {
import java.util.List;
        );
        final List<Set<IndexableField>> docs = new ArrayList<>(numDocs);
            sum("_name").script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, FIELD_SCRIPT_NAME, singletonMap("field", FIELD_NAME))),
        verifySummationOfDoubles(largeValues, Double.POSITIVE_INFINITY, 0d);
        Query query,
import org.opensearch.search.aggregations.AggregationBuilder;
        sumRandomDocsTestCase(
    private void verifySummationOfDoubles(double[] values, double expected, double delta) throws IOException {
        final MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(FIELD_NAME, NumberType.LONG);
            valuesPerField,
        testAggregation(new MatchAllDocsQuery(), iw -> {
            docs.add(doc);
                + "Re-index with correct docvalues type.",
        }, result -> assertEquals(expected, result.getValue(), delta), defaultFieldType(NumberType.DOUBLE));
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
                assertEquals(sum + (docs.size() * valuesPerField), result.getValue(), 0d);
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.search.Query;
            assertFalse(AggregationInspectionHelper.hasValue(count));
import org.opensearch.index.mapper.NumberFieldMapper;
import org.opensearch.script.ScriptEngine;
import java.util.function.Consumer;
            iw.addDocument(singleton(new NumericDocValuesField("wrong_number", 1)));
                assertEquals(finalSum, internalSum.getValue(), 0d);
import java.util.function.Function;
        long sum = 0;
import org.opensearch.search.aggregations.support.ValuesSourceType;
    public void testValueScriptSingleValuedField() throws IOException {
        }
    }
        }
    }
    }
                sum += missingValue;
                AggregatorFactories factories = AggregatorFactories.builder()
            iw.addDocument(Arrays.asList(new SortedNumericDocValuesField(FIELD_NAME, 3), new SortedNumericDocValuesField(FIELD_NAME, 4)));
    @Override
import org.apache.lucene.store.Directory;
        final MappedFieldType irrelevantField = new NumberFieldMapper.NumberFieldType("irrelevant_field", NumberType.LONG);
import org.apache.lucene.tests.index.RandomIndexWriter;
        // Summing up a normal array and expect an accurate value
                final LeafDocLookup lookup = (LeafDocLookup) vars.get("doc");
        return new NumberFieldMapper.NumberFieldType(FIELD_NAME, numberType);
        final int numDocs = randomIntBetween(10, 100);
                ? randomFrom(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
    }
            iw.addDocument(Arrays.asList(new StringField("match", "yes", Field.Store.NO), new NumericDocValuesField(FIELD_NAME, 1)));
 * under the License.
    public void testSupportsIntraSegmentSearch() throws IOException {
    }
            iw.addDocument(Arrays.asList(new StringField("match", "yes", Field.Store.NO), new NumericDocValuesField(FIELD_NAME, 3)));
                IndexReader mappedReader = DirectoryReader.open(mappedDirectory);
                    .addAggregator(new SumAggregationBuilder("test").field(FIELD_NAME))
    }
    public void testQueryFiltering() throws IOException {
 * this work for additional information regarding copyright
             * all the documents on the same leaf. `addDocuments` does
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
import static java.util.Collections.singletonMap;
        }, count -> {
    private static MappedFieldType defaultFieldType() {
            }
    private static final String VALUE_SCRIPT_NAME = "value_script";
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
 *
            largeValues[i] = Double.MAX_VALUE;
        verifySummationOfDoubles(largeValues, Double.NEGATIVE_INFINITY, 0d);
            }
            assertEquals(15L, count.getValue(), 0d);
    public void testFieldScriptSingleValuedField() throws IOException {
            testAggregation(
            vars -> {
        verifySummationOfDoubles(values, 15.3, Double.MIN_NORMAL);
        double[] largeValues = new double[n];
    }
                    .mapToObj(value -> singleton(new NumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(value))))
        }, count -> {
            iw.addDocument(singleton(new NumericDocValuesField("wrong_number", 7)));
        final Map<String, Function<Map<String, Object>, Object>> scripts = Map.of(
            iw.addDocuments(
                iw -> { iw.addDocument(singleton(new SortedDocValuesField(FIELD_NAME, new BytesRef("1")))); },
