        }, singleton(fieldType));
                        new SortedNumericDocValuesField(aggFieldType.name(), randomLong),
        int docsMissingAggField = 0;
        deterministicScripts.put(VALUE_SCRIPT, vars -> {
    }
    }
            final double value = ((Number) vars.get("_value")).doubleValue();
            assertEquals(0, internalMissing.getDocCount());
        }, internalMissing -> {
import org.apache.lucene.index.DirectoryReader;
import org.opensearch.index.mapper.MappedFieldType;
        fieldScriptTestCase(
                docs.add(singleton(new SortedNumericDocValuesField(anotherFieldType.name(), randomLong())));
        Query query,
import org.opensearch.index.mapper.RangeType;
    private void testCase(
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        final int numDocs = randomIntBetween(10, 20);
    }
            }
            assertFalse(AggregationInspectionHelper.hasValue(internalMissing));
/*
    }
    @Override
    public void testMatchAllDocs() throws IOException {
            final long threshold = ((Number) vars.get("threshold")).longValue();
 * Modifications Copyright OpenSearch Contributors. See
        final int numDocs = randomIntBetween(100, 200);
        }, internalMissing -> {
        final int finalDocsMissingAggField = docsMissingAggField;
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field("unknown_field");
            } else {
            assertEquals(numDocs, internalMissing.getDocCount());
        valueScriptTestCase(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, emptyMap()));
            }
    }
    }
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, FIELD_SCRIPT, singletonMap("field", "agg_field")),
        }
                        new SortedNumericDocValuesField(aggFieldType.name(), randomLong + 1)
import java.io.IOException;
        final Map<String, Object> params = Map.of("field", "agg_field", "threshold", threshold);
            final long inc = ((Number) vars.get("inc")).longValue();
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
            assertEquals(numDocs, internalMissing.getDocCount());
        final int numDocs = randomIntBetween(10, 20);
    }
    }
            assertTrue(AggregationInspectionHelper.hasValue(internalMissing));
        }, internalMissing -> {
            if (randomBoolean()) {
 * not use this file except in compliance with the License.
import org.opensearch.common.CheckedConsumer;
import org.opensearch.common.settings.Settings;
            assertEquals(finalDocsMissingField, internalMissing.getDocCount());
import org.apache.lucene.index.IndexReader;
        }, singleton(aggFieldType));
        final List<Set<IndexableField>> docs = new ArrayList<>();
        testCase(newMatchAllQuery(), builder, writer -> {
            }
        }
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
            assertEquals(finalDocsMissingAggField, internalMissing.getDocCount());
        final MappedFieldType aggFieldType = new RangeFieldMapper.RangeFieldType("agg_field", rangeType);
    private static final String FIELD_SCRIPT = "field_script";
            } else {
        final Map<String, Function<Map<String, Object>, Object>> deterministicScripts = new HashMap<>();
            }
            assertFalse(AggregationInspectionHelper.hasValue(internalMissing));
 * You may obtain a copy of the License at
import org.opensearch.index.mapper.NumberFieldMapper;
    private static List<Long> threshold(String fieldName, long threshold, Map<String, Object> vars) {
        final MappedFieldType anotherFieldType = new NumberFieldMapper.NumberFieldType("another_field", NumberType.LONG);
                )
        int numDocs = randomIntBetween(10, 200);
        final int numDocs = randomIntBetween(10, 20);
            if (randomBoolean()) {
        });
            }
        }, List.of(aggFieldType, anotherFieldType));
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field(fieldType.name());
        final MappedFieldType anotherFieldType = new NumberFieldMapper.NumberFieldType("another_field", NumberType.LONG);
import org.opensearch.search.aggregations.AggregationBuilder;
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field(aggFieldType.name()).missing(randomLong());
        final MappedFieldType aggFieldType = new NumberFieldMapper.NumberFieldType("agg_field", NumberType.LONG);
        final Map<String, ScriptEngine> engines = singletonMap(scriptEngine.getType(), scriptEngine);
import org.apache.lucene.document.BinaryDocValuesField;
                docs.add(singleton(new SortedNumericDocValuesField(anotherFieldType.name(), randomLong())));
            assertEquals(0, internalMissing.getDocCount());
    public void testUnmappedWithMissingParam() throws IOException {
import java.util.HashMap;
import static java.util.Collections.emptyMap;
                docsMissingAggField++;
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").script(script);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        testCase(newMatchAllQuery(), builder, writer -> {
            );
        for (int i = 0; i < numDocs; i++) {
        final int finalDocsMissingAggField = docsMissingAggField;
/*
 * ownership. Elasticsearch licenses this file to you under
                final long randomLong = randomLong();
                    )
import static java.util.Collections.singleton;
            final double value = ((Number) vars.get("_value")).doubleValue();
            CoreValuesSourceType.RANGE,
        deterministicScripts.put(FIELD_SCRIPT_PARAMS, vars -> {
        final int finalDocsBelowThreshold = docsBelowThreshold;
 * KIND, either express or implied.  See the License for the
        final int numDocs = randomIntBetween(100, 200);
        }, List.of(aggFieldType, anotherFieldType));
        final MappedFieldType anotherFieldType = new NumberFieldMapper.NumberFieldType("another_field", NumberType.LONG);
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field(aggFieldType.name());
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field("unknown_field").missing(randomLong());
import java.util.function.Function;
        final MappedFieldType aggFieldType = new NumberFieldMapper.NumberFieldType("agg_field", NumberType.LONG);
            } else {
                    new SortedNumericDocValuesField(aggFieldType.name(), firstValue),
        final MappedFieldType anotherFieldType = new RangeFieldMapper.RangeFieldType("another_field", rangeType);
 * software distributed under the License is distributed on an
            if (firstValue < threshold && secondValue < threshold) {
            .map(value -> ((Number) value).longValue())
        return lookup.get(fieldName)
        return List.of("hll");
        final List<Set<IndexableField>> docs = new ArrayList<>();
    }
            assertEquals(0, internalMissing.getDocCount());
    public void testMultiValuedField() throws IOException {
        testCase(newMatchAllQuery(), builder, writer -> writer.addDocuments(docs), internalMissing -> {
        final MappedFieldType aggFieldType = new NumberFieldMapper.NumberFieldType("agg_field", NumberType.LONG);
    }
        testCase(newMatchAllQuery(), builder, writer -> {
            final String fieldName = (String) vars.get("field");
                writeIndex.accept(indexWriter);
                verify.accept(missing);
            }
        final RangeType rangeType = RangeType.DOUBLE;
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        }, singleton(aggFieldType));
    public void testSingleValuedFieldWithValueScriptWithParams() throws IOException {
        testCase(newMatchAllQuery(), builder, writer -> writer.addDocuments(docs), internalMissing -> {
        for (int i = 0; i < numDocs; i++) {
    }
                writer.addDocument(singleton(new SortedNumericDocValuesField(anotherFieldType.name(), randomLong())));
import org.opensearch.script.ScriptService;
                writer.addDocument(singleton(new SortedNumericDocValuesField(anotherFieldType.name(), randomLong())));
                writer.addDocument(singleton(new SortedNumericDocValuesField(aggFieldType.name(), randomLong())));
        );
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
            assertTrue(AggregationInspectionHelper.hasValue(internalMissing));
                writer.addDocument(singleton(new SortedNumericDocValuesField(fieldType.name(), randomLong())));
            } else {
                docsMissingAggField++;
        testCase(newMatchAllQuery(), builder, writer -> writer.addDocuments(docs), internalMissing -> {
        int docsMissingAggField = 0;
        final long threshold = 10;
 * under the License.
    public void testMatchNoDocs() throws IOException {
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field(aggFieldType.name());
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field(aggFieldType.name()).script(script);
    private static final String VALUE_SCRIPT_PARAMS = "value_script_params";
            assertTrue(AggregationInspectionHelper.hasValue(internalMissing));
 * specific language governing permissions and limitations
                docs.add(singleton(new SortedNumericDocValuesField(aggFieldType.name(), randomLong())));
        int docsMissingAggField = 0;
        CheckedConsumer<RandomIndexWriter, IOException> writeIndex,
        for (int i = 0; i < numDocs; i++) {
    private void fieldScriptTestCase(Script script, long threshold) throws IOException {
                docsMissingAggField++;
            assertTrue(AggregationInspectionHelper.hasValue(internalMissing));
        for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.tests.index.RandomIndexWriter;
        }, internalMissing -> {
        testCase(newMatchAllQuery(), builder, writer -> {
    @Override
        int docsMissingAggField = 0;
            }
 * license agreements. See the NOTICE file distributed with
                    Set.of(
    }
        final int numDocs = randomIntBetween(10, 200);
        Consumer<InternalMissing> verify,
        }
 *
import java.util.ArrayList;
    ) throws IOException {
    public void testMultiValuedFieldWithFieldScript() throws IOException {
    private static final String FIELD_SCRIPT_PARAMS = "field_script_params";
    }
            assertEquals(finalDocsMissingAggField, internalMissing.getDocCount());
 * this work for additional information regarding copyright
        final MappedFieldType anotherFieldType = new NumberFieldMapper.NumberFieldType("another_field", NumberType.LONG);
    @Override
import java.util.Arrays;
 * this file be licensed under the Apache-2.0 license or a
    }
    }
            assertTrue(AggregationInspectionHelper.hasValue(internalMissing));
            for (int i = 0; i < numDocs; i++) {
            assertFalse(AggregationInspectionHelper.hasValue(internalMissing));
            for (int i = 0; i < numDocs; i++) {
    }
    }
        );
    @Override
        final int numDocs = randomIntBetween(100, 200);
 * Licensed to Elasticsearch under one or more contributor
        testCase(newMatchAllQuery(), builder, writer -> {
import org.apache.lucene.search.IndexSearcher;
import org.opensearch.search.lookup.LeafDocLookup;
 * GitHub history for details.
import org.opensearch.index.mapper.RangeFieldMapper;
                docsBelowThreshold++;
            CoreValuesSourceType.BOOLEAN,
                docs.add(singleton(new SortedNumericDocValuesField(aggFieldType.name(), randomLong())));
            CoreValuesSourceType.GEOPOINT,
    public void testMissingParam() throws IOException {
            final long secondValue = firstValue + 1;
        }
        }, singleton(aggFieldType));
import org.opensearch.script.ScriptEngine;
 *    http://www.apache.org/licenses/LICENSE-2.0
        final MappedFieldType aggFieldType = new NumberFieldMapper.NumberFieldType("agg_field", NumberType.LONG);
        int docsBelowThreshold = 0;
        final List<Set<IndexableField>> docs = new ArrayList<>();
        return new MissingAggregationBuilder("_name").field(fieldName);
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.function.Consumer;
            for (int i = 0; i < numDocs; i++) {
            CoreValuesSourceType.IP,
    public void testUnmappedWithoutMissingParam() throws IOException {
/*
                docs.add(singleton(encodedRangeField));
            if (randomBoolean()) {
            assertEquals(finalDocsBelowThreshold, internalMissing.getDocCount());
        final BytesRef encodedRange = rangeType.encodeRanges(singleton(range));
                    new SortedNumericDocValuesField(aggFieldType.name(), secondValue)
import org.opensearch.script.ScriptType;
        });
            assertTrue(AggregationInspectionHelper.hasValue(internalMissing));
            return threshold(fieldName, threshold, vars);
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    private static final long DEFAULT_THRESHOLD_PARAM = 50;
        }, List.of(aggFieldType, anotherFieldType));
        testCase(newMatchAllQuery(), builder, writer -> writer.addDocuments(docs), internalMissing -> {
 * compatible open source license.
        deterministicScripts.put(VALUE_SCRIPT_PARAMS, vars -> {
        testCase(newMatchAllQuery(), builder, writer -> writer.addDocuments(docs), internalMissing -> {
        fieldScriptTestCase(new Script(ScriptType.INLINE, MockScriptEngine.NAME, FIELD_SCRIPT_PARAMS, params), threshold);
        final int numDocs = randomIntBetween(100, 200);
                docs.add(singleton(new SortedNumericDocValuesField(anotherFieldType.name(), randomLong())));
    public void testMultiValuedFieldWithFieldScriptWithParams() throws IOException {
                final MappedFieldType[] fieldTypesArray = fieldTypes.toArray(new MappedFieldType[0]);
    }
        final MappedFieldType aggFieldType = new NumberFieldMapper.NumberFieldType("agg_field", NumberType.LONG);
    public void testMatchSparseRangeField() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        }, internalMissing -> {
            return threshold(fieldName, DEFAULT_THRESHOLD_PARAM, vars);
                final InternalMissing missing = searchAndReduce(indexSearcher, query, builder, fieldTypesArray);
        final MappedFieldType aggFieldType = new NumberFieldMapper.NumberFieldType("agg_field", NumberType.LONG);
            }
        final MappedFieldType aggFieldType = new NumberFieldMapper.NumberFieldType("agg_field", NumberType.LONG);
                final IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            }
                docs.add(singleton(new SortedNumericDocValuesField(anotherFieldType.name(), randomLong())));
import org.apache.lucene.index.IndexableField;
        final MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);
import org.opensearch.search.aggregations.AggregatorTestCase;
 * Unless required by applicable law or agreed to in writing,
            .filter(value -> value >= threshold)
            }
                writer.addDocument(singleton(new SortedNumericDocValuesField(aggFieldType.name(), randomLong())));
        final MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, deterministicScripts, emptyMap(), emptyMap());
        return List.of(
                );
        final MappedFieldType anotherFieldType = new NumberFieldMapper.NumberFieldType("another_field", NumberType.LONG);
    public void testMatchSparse() throws IOException {
 * The OpenSearch Contributors require contributions made to
import java.util.List;
        }, List.of(aggFieldType, anotherFieldType));
 *
        final int numDocs = randomIntBetween(100, 200);
        final BinaryDocValuesField encodedRangeField = new BinaryDocValuesField(aggFieldType.name(), encodedRange);
            DEFAULT_THRESHOLD_PARAM
        }
            return value + DEFAULT_INC_PARAM;
            final String fieldName = (String) vars.get("field");
        }
        });
import org.apache.lucene.store.Directory;
import org.apache.lucene.search.Query;
        Collection<MappedFieldType> fieldTypes
        });
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field(aggFieldType.name());
            CoreValuesSourceType.DATE
 */
        final LeafDocLookup lookup = (LeafDocLookup) vars.get("doc");
import org.opensearch.script.ScriptModule;
    private static final String VALUE_SCRIPT = "value_script";
public class MissingAggregatorTests extends AggregatorTestCase {
            final long firstValue = randomLongBetween(0, 100);
 */
        }, Arrays.asList(aggFieldType, anotherFieldType));
        final RangeFieldMapper.Range range = new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true);
import java.util.Set;
        final int finalDocsMissingField = docsMissingAggField;
import static org.opensearch.common.lucene.search.Queries.newMatchAllQuery;
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field(aggFieldType.name());
 */
                docs.add(
import static java.util.Collections.singletonMap;
    protected ScriptService getMockScriptService() {
}
            .stream()
        try (Directory directory = newDirectory()) {
    private void valueScriptTestCase(Script script) throws IOException {
        final int finalDocsMissingAggField = docsMissingAggField;
import org.apache.lucene.util.BytesRef;
 *
                docsMissingAggField++;
    private static final long DEFAULT_INC_PARAM = 1;
        for (int i = 0; i < numDocs; i++) {
        final List<Set<IndexableField>> docs = new ArrayList<>();
            }
import static java.util.stream.Collectors.toList;
package org.opensearch.search.aggregations.bucket.missing;
        MissingAggregationBuilder builder,
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
    protected List<String> unsupportedMappedFieldTypes() {
            CoreValuesSourceType.BYTES,
        }, List.of(aggFieldType, anotherFieldType));
            return value + inc;
        final List<Set<IndexableField>> docs = new ArrayList<>();
    }
        valueScriptTestCase(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT_PARAMS, singletonMap("inc", 10)));
    }
    public void testSingleValuedFieldWithValueScript() throws IOException {
            CoreValuesSourceType.NUMERIC,
            docs.add(
            if (randomBoolean()) {
        final MappedFieldType aggFieldType = new NumberFieldMapper.NumberFieldType("agg_field", NumberType.LONG);
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
import org.apache.lucene.document.SortedNumericDocValuesField;
            .collect(toList());
            for (int i = 0; i < numDocs; i++) {
            for (int i = 0; i < numDocs; i++) {
            }
                Set.of(
import org.opensearch.script.MockScriptEngine;
            assertEquals(finalDocsMissingAggField, internalMissing.getDocCount());
        deterministicScripts.put(FIELD_SCRIPT, vars -> {
import org.opensearch.script.Script;
import java.util.Collection;
import java.util.Map;
import org.opensearch.search.aggregations.support.ValuesSourceType;
            assertTrue(AggregationInspectionHelper.hasValue(internalMissing));
