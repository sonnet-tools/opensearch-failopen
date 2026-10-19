import org.opensearch.script.ScriptEngine;
}  
            }
    }
            }
        final MappedFieldType anotherFieldType = new NumberFieldMapper.NumberFieldType("another_field", NumberType.LONG);  
import org.apache.lucene.document.SortedNumericDocValuesField;
            for (int i = 0; i < numDocs; i++) {
 */  
                docs.add(singleton(encodedRangeField));
    public void testSingleValuedFieldWithValueScript() throws IOException {  
        final Map<String, Object> params = Map.of("field", "agg_field", "threshold", threshold);
        final MappedFieldType aggFieldType = new NumberFieldMapper.NumberFieldType("agg_field", NumberType.LONG);  
    public void testMultiValuedField() throws IOException {
        });
            for (int i = 0; i < numDocs; i++) {
            }
        testCase(newMatchAllQuery(), builder, writer -> writer.addDocuments(docs), internalMissing -> {  
            assertEquals(0, internalMissing.getDocCount());  
            assertEquals(finalDocsMissingField, internalMissing.getDocCount());
    public void testMultiValuedFieldWithFieldScript() throws IOException {  
        CheckedConsumer<RandomIndexWriter, IOException> writeIndex,  
            .map(value -> ((Number) value).longValue())
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").script(script);
import org.apache.lucene.document.BinaryDocValuesField;
        }, internalMissing -> {
        int docsMissingAggField = 0;  
        });  
        final int numDocs = randomIntBetween(100, 200);
        return lookup.get(fieldName)  
    @Override  
                final MappedFieldType[] fieldTypesArray = fieldTypes.toArray(new MappedFieldType[0]);
            }
        final int numDocs = randomIntBetween(100, 200);
            assertFalse(AggregationInspectionHelper.hasValue(internalMissing));
 * this file be licensed under the Apache-2.0 license or a
        final MappedFieldType anotherFieldType = new NumberFieldMapper.NumberFieldType("another_field", NumberType.LONG);
    }
    private static final String FIELD_SCRIPT_PARAMS = "field_script_params";
    private void fieldScriptTestCase(Script script, long threshold) throws IOException {
        testCase(newMatchAllQuery(), builder, writer -> {
            assertEquals(0, internalMissing.getDocCount());  
        }  
    public void testUnmappedWithMissingParam() throws IOException {
            for (int i = 0; i < numDocs; i++) {
    }
    protected List<String> unsupportedMappedFieldTypes() {
import java.util.Map;
        final int numDocs = randomIntBetween(100, 200);  
            final double value = ((Number) vars.get("_value")).doubleValue();
        final BytesRef encodedRange = rangeType.encodeRanges(singleton(range));  
    }  
            }
            CoreValuesSourceType.BOOLEAN,
import java.util.ArrayList;
import org.opensearch.script.ScriptModule;  
import org.opensearch.common.settings.Settings;  
    private void valueScriptTestCase(Script script) throws IOException {
        }, List.of(aggFieldType, anotherFieldType));  
                final long randomLong = randomLong();
/*
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
import org.opensearch.index.mapper.MappedFieldType;
    }  
        final MappedFieldType aggFieldType = new NumberFieldMapper.NumberFieldType("agg_field", NumberType.LONG);  
            } else {
            assertTrue(AggregationInspectionHelper.hasValue(internalMissing));
        final List<Set<IndexableField>> docs = new ArrayList<>();
            for (int i = 0; i < numDocs; i++) {
        final int finalDocsMissingAggField = docsMissingAggField;
                );
            assertEquals(numDocs, internalMissing.getDocCount());
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field(aggFieldType.name()).script(script);  
        }, internalMissing -> {
            CoreValuesSourceType.GEOPOINT,
import org.opensearch.script.Script;
        int docsMissingAggField = 0;  
                        new SortedNumericDocValuesField(aggFieldType.name(), randomLong),
        });  
                docs.add(singleton(new SortedNumericDocValuesField(anotherFieldType.name(), randomLong())));  
        final BinaryDocValuesField encodedRangeField = new BinaryDocValuesField(aggFieldType.name(), encodedRange);
            DEFAULT_THRESHOLD_PARAM  
 *
                docs.add(singleton(new SortedNumericDocValuesField(anotherFieldType.name(), randomLong())));  
        for (int i = 0; i < numDocs; i++) {
                docs.add(singleton(new SortedNumericDocValuesField(aggFieldType.name(), randomLong())));
import org.apache.lucene.search.Query;
            if (randomBoolean()) {  
            CoreValuesSourceType.BYTES,  
 * KIND, either express or implied.  See the License for the
        testCase(newMatchAllQuery(), builder, writer -> writer.addDocuments(docs), internalMissing -> {  
        }, internalMissing -> {
 */  
            assertTrue(AggregationInspectionHelper.hasValue(internalMissing));
import org.opensearch.script.ScriptService;
            .filter(value -> value >= threshold)  
        testCase(newMatchAllQuery(), builder, writer -> writer.addDocuments(docs), internalMissing -> {  
        final MappedFieldType aggFieldType = new NumberFieldMapper.NumberFieldType("agg_field", NumberType.LONG);
    }  
            if (firstValue < threshold && secondValue < threshold) {  
            CoreValuesSourceType.IP,  
        final int finalDocsBelowThreshold = docsBelowThreshold;
        testCase(newMatchAllQuery(), builder, writer -> {
        final List<Set<IndexableField>> docs = new ArrayList<>();
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 *
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field("unknown_field");
import org.apache.lucene.util.BytesRef;
import java.util.Arrays;  
            assertFalse(AggregationInspectionHelper.hasValue(internalMissing));
            docs.add(  
        final int numDocs = randomIntBetween(10, 20);
    private static final long DEFAULT_THRESHOLD_PARAM = 50;
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field(aggFieldType.name()).missing(randomLong());
public class MissingAggregatorTests extends AggregatorTestCase {  
            assertTrue(AggregationInspectionHelper.hasValue(internalMissing));
            assertEquals(numDocs, internalMissing.getDocCount());  
                final InternalMissing missing = searchAndReduce(indexSearcher, query, builder, fieldTypesArray);  
import org.opensearch.search.lookup.LeafDocLookup;
            try (IndexReader indexReader = DirectoryReader.open(directory)) {  
        });
        final MappedFieldType aggFieldType = new RangeFieldMapper.RangeFieldType("agg_field", rangeType);
    }
            } else {
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
        final MappedFieldType anotherFieldType = new NumberFieldMapper.NumberFieldType("another_field", NumberType.LONG);
            return value + DEFAULT_INC_PARAM;  
        }, singleton(fieldType));
        final int finalDocsMissingAggField = docsMissingAggField;
        deterministicScripts.put(FIELD_SCRIPT, vars -> {
            final long secondValue = firstValue + 1;
            final double value = ((Number) vars.get("_value")).doubleValue();  
                        new SortedNumericDocValuesField(aggFieldType.name(), randomLong + 1)
        final MappedFieldType aggFieldType = new NumberFieldMapper.NumberFieldType("agg_field", NumberType.LONG);
    }  
import org.opensearch.index.mapper.NumberFieldMapper;
import org.opensearch.index.mapper.RangeFieldMapper;
        final int numDocs = randomIntBetween(10, 20);  
        }, internalMissing -> {
        Query query,
    }
    }
 * Unless required by applicable law or agreed to in writing,
            CoreValuesSourceType.NUMERIC,
        }  
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field(aggFieldType.name());  
    }  
        int numDocs = randomIntBetween(10, 200);  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    }
import org.opensearch.search.aggregations.AggregatorTestCase;
                writer.addDocument(singleton(new SortedNumericDocValuesField(anotherFieldType.name(), randomLong())));  
            assertTrue(AggregationInspectionHelper.hasValue(internalMissing));
            assertEquals(finalDocsBelowThreshold, internalMissing.getDocCount());
        }, singleton(aggFieldType));
        final List<Set<IndexableField>> docs = new ArrayList<>();
        testCase(newMatchAllQuery(), builder, writer -> {
        }  
import static java.util.Collections.emptyMap;  
/*  
 * specific language governing permissions and limitations
    ) throws IOException {  
        }, List.of(aggFieldType, anotherFieldType));  
        int docsBelowThreshold = 0;
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;  
                    Set.of(  
        }, List.of(aggFieldType, anotherFieldType));
        final MappedFieldType aggFieldType = new NumberFieldMapper.NumberFieldType("agg_field", NumberType.LONG);
        final MappedFieldType anotherFieldType = new NumberFieldMapper.NumberFieldType("another_field", NumberType.LONG);
import org.opensearch.search.aggregations.AggregationBuilder;  
        return List.of("hll");
            final long threshold = ((Number) vars.get("threshold")).longValue();
        valueScriptTestCase(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT_PARAMS, singletonMap("inc", 10)));
        for (int i = 0; i < numDocs; i++) {
            final long firstValue = randomLongBetween(0, 100);
            return threshold(fieldName, threshold, vars);
        }, List.of(aggFieldType, anotherFieldType));  
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
    public void testMatchAllDocs() throws IOException {
                final IndexSearcher indexSearcher = newSearcher(indexReader, true, true);
            } else {
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
import java.util.function.Consumer;  
        testCase(newMatchAllQuery(), builder, writer -> writer.addDocuments(docs), internalMissing -> {  
        int docsMissingAggField = 0;  
        final MappedFieldType aggFieldType = new NumberFieldMapper.NumberFieldType("agg_field", NumberType.LONG);  
    private static List<Long> threshold(String fieldName, long threshold, Map<String, Object> vars) {
        }  
            assertEquals(0, internalMissing.getDocCount());  
            final String fieldName = (String) vars.get("field");  
            assertTrue(AggregationInspectionHelper.hasValue(internalMissing));
        int docsMissingAggField = 0;  
    }
                verify.accept(missing);
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field(aggFieldType.name());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, FIELD_SCRIPT, singletonMap("field", "agg_field")),
import java.util.function.Function;
        }, List.of(aggFieldType, anotherFieldType));
                writeIndex.accept(indexWriter);  
        deterministicScripts.put(VALUE_SCRIPT_PARAMS, vars -> {
        final Map<String, Function<Map<String, Object>, Object>> deterministicScripts = new HashMap<>();
        final int finalDocsMissingField = docsMissingAggField;
        final MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);  
    }
    public void testMatchNoDocs() throws IOException {  
        final MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, deterministicScripts, emptyMap(), emptyMap());
            .stream()
        Consumer<InternalMissing> verify,
                Set.of(
            assertFalse(AggregationInspectionHelper.hasValue(internalMissing));
            }
    private static final String VALUE_SCRIPT = "value_script";  
import static java.util.stream.Collectors.toList;  
        return new MissingAggregationBuilder("_name").field(fieldName);
import org.apache.lucene.index.DirectoryReader;  
            }
                docsMissingAggField++;
            );
 * The OpenSearch Contributors require contributions made to  
        MissingAggregationBuilder builder,
            final long inc = ((Number) vars.get("inc")).longValue();
import org.apache.lucene.tests.index.RandomIndexWriter;  
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field(fieldType.name());
                docs.add(singleton(new SortedNumericDocValuesField(aggFieldType.name(), randomLong())));
    @Override  
        deterministicScripts.put(FIELD_SCRIPT_PARAMS, vars -> {
        final MappedFieldType aggFieldType = new NumberFieldMapper.NumberFieldType("agg_field", NumberType.LONG);
import org.opensearch.search.aggregations.support.ValuesSourceType;
            return value + inc;
                docsMissingAggField++;
        }, singleton(aggFieldType));  
 * software distributed under the License is distributed on an
import org.opensearch.script.MockScriptEngine;  
        final RangeType rangeType = RangeType.DOUBLE;
        final List<Set<IndexableField>> docs = new ArrayList<>();
import org.apache.lucene.search.IndexSearcher;  
        final int numDocs = randomIntBetween(100, 200);
            assertTrue(AggregationInspectionHelper.hasValue(internalMissing));
            assertEquals(finalDocsMissingAggField, internalMissing.getDocCount());
 * this work for additional information regarding copyright
        fieldScriptTestCase(new Script(ScriptType.INLINE, MockScriptEngine.NAME, FIELD_SCRIPT_PARAMS, params), threshold);  
            .collect(toList());
        fieldScriptTestCase(
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field(aggFieldType.name());  
        final int numDocs = randomIntBetween(10, 20);
        );
    public void testUnmappedWithoutMissingParam() throws IOException {  
        testCase(newMatchAllQuery(), builder, writer -> {
    public void testMultiValuedFieldWithFieldScriptWithParams() throws IOException {  
                writer.addDocument(singleton(new SortedNumericDocValuesField(aggFieldType.name(), randomLong())));
        return List.of(
 * under the License.  
import java.util.List;  
    @Override
            assertEquals(finalDocsMissingAggField, internalMissing.getDocCount());
            }
        testCase(newMatchAllQuery(), builder, writer -> writer.addDocuments(docs), internalMissing -> {  
                docs.add(singleton(new SortedNumericDocValuesField(anotherFieldType.name(), randomLong())));  
            }  
 *  
            if (randomBoolean()) {  
        valueScriptTestCase(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, emptyMap()));
    }
        final int finalDocsMissingAggField = docsMissingAggField;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.CheckedConsumer;
import org.apache.lucene.index.IndexReader;
            assertTrue(AggregationInspectionHelper.hasValue(internalMissing));  
                writer.addDocument(singleton(new SortedNumericDocValuesField(anotherFieldType.name(), randomLong())));  
import java.util.Collection;
                writer.addDocument(singleton(new SortedNumericDocValuesField(aggFieldType.name(), randomLong())));  
    private static final long DEFAULT_INC_PARAM = 1;  
                docsBelowThreshold++;
import java.io.IOException;
                docs.add(
        }  
    public void testMatchSparseRangeField() throws IOException {  
            } else {
            if (randomBoolean()) {  
        final MappedFieldType anotherFieldType = new RangeFieldMapper.RangeFieldType("another_field", rangeType);  
        }, Arrays.asList(aggFieldType, anotherFieldType));  
                docsMissingAggField++;
 * You may obtain a copy of the License at  
        final List<Set<IndexableField>> docs = new ArrayList<>();
        for (int i = 0; i < numDocs; i++) {
 */
    }
    public void testMissingParam() throws IOException {
        for (int i = 0; i < numDocs; i++) {  
                docsMissingAggField++;
    }
                    new SortedNumericDocValuesField(aggFieldType.name(), secondValue)  
        Collection<MappedFieldType> fieldTypes
            }
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
                    )  
                    new SortedNumericDocValuesField(aggFieldType.name(), firstValue),
        final int numDocs = randomIntBetween(100, 200);
import org.opensearch.index.mapper.RangeType;
import static java.util.Collections.singleton;
import org.apache.lucene.store.Directory;
    @Override
                writer.addDocument(singleton(new SortedNumericDocValuesField(fieldType.name(), randomLong())));  
 * Licensed to Elasticsearch under one or more contributor  
                docs.add(singleton(new SortedNumericDocValuesField(anotherFieldType.name(), randomLong())));  
            }
import org.apache.lucene.index.IndexableField;
        final MappedFieldType aggFieldType = new NumberFieldMapper.NumberFieldType("agg_field", NumberType.LONG);  
import java.util.Set;
    private void testCase(  
import org.opensearch.script.ScriptType;
package org.opensearch.search.aggregations.bucket.missing;
import static java.util.Collections.singletonMap;
        }, singleton(aggFieldType));
/*  
        try (Directory directory = newDirectory()) {
    }  
            return threshold(fieldName, DEFAULT_THRESHOLD_PARAM, vars);  
            assertEquals(finalDocsMissingAggField, internalMissing.getDocCount());
        testCase(newMatchAllQuery(), builder, writer -> {  
import java.util.HashMap;
    private static final String VALUE_SCRIPT_PARAMS = "value_script_params";
                )
        final long threshold = 10;
    }
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field("unknown_field").missing(randomLong());
        final RangeFieldMapper.Range range = new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true);
    public void testSingleValuedFieldWithValueScriptWithParams() throws IOException {
            CoreValuesSourceType.RANGE,
        }  
        final MissingAggregationBuilder builder = new MissingAggregationBuilder("_name").field(aggFieldType.name());
            }
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
            for (int i = 0; i < numDocs; i++) {
    public void testMatchSparse() throws IOException {
        );  
    }  
            final String fieldName = (String) vars.get("field");
        }, internalMissing -> {
import static org.opensearch.common.lucene.search.Queries.newMatchAllQuery;
        final Map<String, ScriptEngine> engines = singletonMap(scriptEngine.getType(), scriptEngine);  
            CoreValuesSourceType.DATE
    protected ScriptService getMockScriptService() {  
        final MappedFieldType anotherFieldType = new NumberFieldMapper.NumberFieldType("another_field", NumberType.LONG);  
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {  
    private static final String FIELD_SCRIPT = "field_script";
 * the Apache License, Version 2.0 (the "License"); you may
            if (randomBoolean()) {  
        deterministicScripts.put(VALUE_SCRIPT, vars -> {
        final LeafDocLookup lookup = (LeafDocLookup) vars.get("doc");
        final int numDocs = randomIntBetween(10, 200);
