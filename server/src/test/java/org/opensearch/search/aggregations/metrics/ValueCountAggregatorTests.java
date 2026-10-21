 * specific language governing permissions and limitations
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
        testAggregation(query, valueType, indexer, verify, false);
    }
            }, count -> {
            assertTrue(AggregationInspectionHelper.hasValue(count));
        }, count -> {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
 * this work for additional information regarding copyright
        final RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true);
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, ValueType.NUMERIC);
    @Override
 * Modifications Copyright OpenSearch Contributors. See
                return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.DOUBLE);
import org.apache.lucene.document.SortedDocValuesField;
}
                return new RangeFieldMapper.RangeFieldType(name, RangeType.DOUBLE);
        }, valueCount -> {
        for (ValueType valueType : ValueType.values()) {
        CheckedConsumer<RandomIndexWriter, IOException> indexer,
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            iw.addDocument(doc);
            assertEquals(4.0, count.getValue(), 0);
import org.opensearch.index.mapper.HllFieldMapper;
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 8)));
            iw.addDocument(doc);
            doc.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("6")));
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, ValueType.STRING);
            case IP:
import java.util.List;
 * software distributed under the License is distributed on an
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 7)));
import java.util.Map;
                IndexSearcher searcher = newIndexSearcher(reader);
 * this file be licensed under the Apache-2.0 license or a
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
    public void testUnmappedMissingString() throws IOException {
import org.opensearch.common.geo.GeoPoint;
                document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("stringValue")));
    }
            assertEquals(3, valueCount.getValue(), 0);
        Consumer<InternalValueCount> verify,
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, 7));
        });
import org.apache.lucene.util.BytesRef;
                return new KeywordFieldMapper.KeywordFieldType(name);
        AggregationBuilder aggregationBuilder,
                    .addAggregator(new ValueCountAggregationBuilder("test").field("value"))
        final String fieldName = "rangeField";
import org.opensearch.script.ScriptModule;
import org.opensearch.index.mapper.RangeFieldMapper;
                return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.UNSIGNED_LONG);
            assertEquals(3, valueCount.getValue(), 0);
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
import org.apache.lucene.document.Document;
        return new ValueCountAggregationBuilder("foo").field(fieldName);
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", 1)));
                return new GeoPointFieldMapper.GeoPointFieldType(name);
import org.apache.lucene.document.SortedSetDocValuesField;
                return new DateFieldMapper.DateFieldType(name);
            assertEquals(3, valueCount.getValue(), 0);
                assertEquals(0L, count.getValue());
 * license agreements. See the NOTICE file distributed with
            assertEquals(2L, count.getValue());
        ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("name").script(
import org.opensearch.search.aggregations.support.ValuesSourceType;
/*
    public void testQueryFiltersAll() throws IOException {
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, NUMBER_VALUE_SCRIPT, Collections.emptyMap()));
import static java.util.Collections.singleton;
                throw new IllegalArgumentException("Test does not support value type [" + valueType + "]");
        if (valueType != null && testWithHint) {
import org.opensearch.search.aggregations.AggregatorFactories;
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 7)));
    public void testNoDocs() throws IOException {
                document.add(new DoubleDocValuesField(FIELD_NAME, 23D));
        MappedFieldType fieldType
    public void testRangeFieldValues() throws IOException {
                iw.addDocument(document);
            CoreValuesSourceType.RANGE,
    }
            assertEquals(3, valueCount.getValue(), 0);
 * not use this file except in compliance with the License.
import java.util.function.Consumer;
import org.apache.lucene.search.MatchAllDocsQuery;
        switch (valueType) {
            case UNSIGNED_LONG:
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 9)));
    }
    @Override
import org.opensearch.search.aggregations.AggregatorTestCase;
 * Unless required by applicable law or agreed to in writing,
            iw.addDocument(singleton(new SortedNumericDocValuesField(FIELD_NAME, 1)));
            doc.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("1")));
    protected List<String> unsupportedMappedFieldTypes() {
import org.apache.lucene.document.IntPoint;
        }, count -> {
import org.opensearch.script.ScriptType;
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
    }
import org.opensearch.common.CheckedConsumer;
            iw.addDocument(singleton(new SortedDocValuesField(FIELD_NAME, new BytesRef("3"))));
            case NUMBER:
public class ValueCountAggregatorTests extends AggregatorTestCase {
            // Note: The field values won't be taken into account. The script will only be called
    }
    }
            iw.addDocument(doc);
                AggregatorFactories factories = AggregatorFactories.builder()
    private void testAggregation(
        scripts.put(STRING_VALUE_SCRIPT, vars -> (Double.valueOf((String) vars.get("_value")) + 1));
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SINGLE_SCRIPT, Collections.emptyMap())
        final ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("_name").field(fieldName);
    public void testSupportsIntraSegmentSearch() throws IOException {
            assertEquals(3, valueCount.getValue(), 0);
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
            assertTrue(AggregationInspectionHelper.hasValue(count));
import org.apache.lucene.document.LatLonDocValuesField;
import org.opensearch.search.aggregations.support.ValueType;
import org.opensearch.index.mapper.BooleanFieldMapper;
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
    public void testGeoField() throws IOException {
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
        scripts.put(NUMBER_VALUE_SCRIPT, vars -> (((Number) vars.get("_value")).doubleValue() + 1));
import java.io.IOException;
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 9)));
        testAggregation(aggregationBuilder, query, indexer, verify, fieldType);
        testAggregation(new MatchAllDocsQuery(), ValueType.DOUBLE, iw -> {
    public void testValueScriptString() throws IOException {
        testAggregation(new FieldExistsQuery(FIELD_NAME), ValueType.NUMBER, iw -> {
    }
            case LONG:
                Document document = new Document();
    }
            case NUMERIC:
 * under the License.
        ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("name").field("number").missing("🍌🍌🍌");
            // once per document, and only expect a count of 3
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SINGLE_SCRIPT, Collections.emptyMap())
            assertEquals(0L, count.getValue());
            CoreValuesSourceType.BOOLEAN,
            // once per document, and only expect a count of 3
    private static MappedFieldType createMappedFieldType(String name, ValueType valueType) {
import java.util.Arrays;
            CoreValuesSourceType.DATE,
        // Test both with and without the userValueTypeHint
import org.apache.lucene.index.IndexReader;
        Query query,
            iw.addDocument(doc);
        ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("name").script(
    }
        ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("name").field(FIELD_NAME)
 */
            for (int i = 0; i < 10; i++) {
    }
            iw.addDocument(singleton(new SortedDocValuesField(FIELD_NAME, new BytesRef("1"))));
        CheckedConsumer<RandomIndexWriter, IOException> indexer,
            CoreValuesSourceType.GEOPOINT,
    private static final String FIELD_NAME = "field";
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        multiRecord.add(range1);
import org.apache.lucene.search.IndexSearcher;
            doc.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("3")));
    public void testSomeMatchesSortedNumericDocValues() throws IOException {
import org.opensearch.index.mapper.GeoPointFieldMapper;
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)
                iw.addDocument(document);
            assertEquals(4L, count.getValue());
    private static final String NUMBER_VALUE_SCRIPT = "number_value";
    }
    ) throws IOException {
    protected ScriptService getMockScriptService() {
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, valueType);
        }, fieldType);
            CoreValuesSourceType.IP
            case STRING:
import org.apache.lucene.document.BinaryDocValuesField;
            iw.addDocument(Arrays.asList(new IntPoint("level", 1), new SortedDocValuesField(FIELD_NAME, new BytesRef("bar"))));
import org.apache.lucene.search.FieldExistsQuery;
    public void testQueryFiltering() throws IOException {
        );
                    );
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            }
        }, null);
import java.util.Collections;
            assertTrue(AggregationInspectionHelper.hasValue(count));
    private static final String STRING_VALUE_SCRIPT = "string_value";
    public void testUnmappedMissingGeoPoint() throws IOException {
            assertEquals(2L, count.getValue());
    }
    }
import java.util.HashMap;
            case BOOLEAN:
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            CoreValuesSourceType.BYTES,
        scripts.put(SINGLE_SCRIPT, vars -> 1);
import org.apache.lucene.search.Query;
    }
        testAggregation(new MatchAllDocsQuery(), ValueType.LONG, iw -> {
        }, count -> {
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 7)));
 * Licensed to Elasticsearch under one or more contributor
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }, fieldType);
import org.opensearch.index.mapper.DateFieldMapper;
            testAggregation(new MatchAllDocsQuery(), valueType, iw -> {
            assertFalse(AggregationInspectionHelper.hasValue(count));
 * You may obtain a copy of the License at
            iw.addDocument(Arrays.asList(new IntPoint("level", 7), new SortedDocValuesField(FIELD_NAME, new BytesRef("baz"))));
        Consumer<InternalValueCount> verify,
/*
        }, count -> assertEquals(40L, count.getValue()));
    }
            for (int i = 0; i < 15; i++) {
        Consumer<InternalValueCount> verify
    public void testKeyWordField() throws IOException {
            CoreValuesSourceType.IP,
        );
    }
        }, fieldType);
            doc.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("4")));
            iw.addDocument(doc);
import org.opensearch.script.ScriptEngine;
            Document doc = new Document();
                document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("string11Value")));
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
import org.apache.lucene.document.DoubleDocValuesField;
        testAggregation(new MatchAllDocsQuery(), ValueType.STRING, iw -> {
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 7)));
    public void testNoMatchingField() throws IOException {
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
            iw.addDocument(singleton(new SortedNumericDocValuesField(FIELD_NAME, 7)));
                Document document = new Document();
            default:
                // Intentionally not writing any docs
        }, valueCount -> {
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 9)));
import java.util.HashSet;
        }, null);
        return Arrays.asList(
        }
import org.opensearch.script.Script;
    private void testAggregation(
        }
/*
        ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("_name");
            // Note: The field values won't be taken into account. The script will only be called
        }, valueCount -> {
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, 8));
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, 1));
    }
        });
    }
        return List.of(HllFieldMapper.CONTENT_TYPE);
        testAggregation(query, valueType, indexer, verify, true);
import org.opensearch.index.mapper.IpFieldMapper;
        testAggregation(IntPoint.newRangeQuery("level", 0, 5), ValueType.STRING, iw -> {
 */
            case GEOPOINT:
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, ValueType.NUMERIC);
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, STRING_VALUE_SCRIPT, Collections.emptyMap()));
                        null
import org.opensearch.index.mapper.MappedFieldType;
            assertEquals(0L, count.getValue());
import org.opensearch.script.ScriptService;
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(multiRecord))));
                iw.addDocument(document);
        }, count -> assertEquals(15L, count.getValue()));
                Document document = new Document();
            doc.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("2")));
        }, fieldType);
    private void testAggregation(
        Query query,
 * compatible open source license.
        }, count -> {
            try (IndexReader reader = indexWriter.getReader()) {
        }, fieldType);
 * the Apache License, Version 2.0 (the "License"); you may
                document.add(new LatLonDocValuesField("field", 10, 10));
 *
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 9)));
                return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.LONG);
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 8)));
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 8)));
import java.util.function.Function;
            CoreValuesSourceType.NUMERIC,
            .missing(new GeoPoint(42.39561, -71.13051));
    }
    @Override
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
        }, valueCount -> {
    public void testSingleScriptNumber() throws IOException {
            CoreValuesSourceType.DATE,
import org.opensearch.index.mapper.KeywordFieldMapper;
            }
        });
        }, count -> {
 *
    private static final String SINGLE_SCRIPT = "single";
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
        }, count -> assertEquals(10L, count.getValue()));
            assertFalse(AggregationInspectionHelper.hasValue(count));
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range1)))));
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
    @Override
            iw.addDocument(Arrays.asList(new IntPoint("level", 3), new SortedDocValuesField(FIELD_NAME, new BytesRef("foo"))));
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
import org.opensearch.common.settings.Settings;
            doc.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("5")));
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range1)))));
 * KIND, either express or implied.  See the License for the
        ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("name").field(FIELD_NAME)
        });
            assertEquals(3, valueCount.getValue(), 0);
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, 1));
 *    http://www.apache.org/licenses/LICENSE-2.0
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 8)));
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range2)))));
    }
                assertTrue(factories.allFactoriesSupportIntraSegmentSearch());
        multiRecord.add(range2);
    }
        }
                return new BooleanFieldMapper.BooleanFieldType(name);
            doc = new Document();
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
            }
            CoreValuesSourceType.BOOLEAN,
import org.apache.lucene.tests.index.RandomIndexWriter;
        }, valueCount -> {
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));
            case RANGE:
        final RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(rangeType, 6.0D, 10.0D, true, true);
            doc = new Document();
            iw.addDocument(Arrays.asList(new IntPoint("level", 5), new SortedDocValuesField(FIELD_NAME, new BytesRef("baz"))));
        ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("name").field("number")
        MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType(fieldName, rangeType);
import org.apache.lucene.document.NumericDocValuesField;
import org.apache.lucene.store.Directory;
        testAggregation(new MatchAllDocsQuery(), ValueType.GEOPOINT, iw -> {
    public void testDoubleField() throws IOException {
            Document doc = new Document();
    public void testSingleScriptString() throws IOException {
                assertFalse(AggregationInspectionHelper.hasValue(count));
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, 7));
            }
        Set<RangeFieldMapper.Range> multiRecord = new HashSet<>(2);
            assertTrue(AggregationInspectionHelper.hasValue(count));
            case DATE:
            assertEquals(3, valueCount.getValue(), 0);
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
import org.opensearch.script.MockScriptEngine;
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 1)));
        boolean testWithHint
        }, count -> {
    ) throws IOException {
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
 * SPDX-License-Identifier: Apache-2.0
        });
import org.opensearch.index.mapper.NumberFieldMapper;
        testAggregation(new FieldExistsQuery(FIELD_NAME), ValueType.NUMERIC, iw -> {
        );
            for (int i = 0; i < 20; i++) {
 * The OpenSearch Contributors require contributions made to
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, 8));
package org.opensearch.search.aggregations.metrics;
    public void testValueScriptNumber() throws IOException {
        MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, scripts, Collections.emptyMap());
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 7)));
        testAggregation(IntPoint.newRangeQuery("level", -1, 0), ValueType.STRING, iw -> {
            case DOUBLE:
import org.apache.lucene.document.SortedNumericDocValuesField;
        Query query,
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
    }
            iw.addDocument(doc);
    public void testUnmappedMissingNumber() throws IOException {
import org.opensearch.index.mapper.RangeType;
        }, valueCount -> {
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, ValueType.STRING);
            iw.addDocument(Arrays.asList(new IntPoint("level", 0), new SortedDocValuesField(FIELD_NAME, new BytesRef("foo"))));
                return new IpFieldMapper.IpFieldType(name);
 * GitHub history for details.
 */
            });
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);
            doc = new Document();
import java.util.Set;
            // Note: unlike numerics, lucene de-dupes strings so we increment here
            iw.addDocument(Arrays.asList(new IntPoint("level", 5), new SortedDocValuesField(FIELD_NAME, new BytesRef("baz"))));
                            .getQueryShardContext(),
        }, valueCount -> {
        ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("name").field("number").missing(1234);
        RangeType rangeType = RangeType.DOUBLE;
 * ownership. Elasticsearch licenses this file to you under
        aggregationBuilder.field(FIELD_NAME);
            iw.addDocument(singleton(new SortedDocValuesField(FIELD_NAME, new BytesRef("2"))));
        }, null);
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
    }
        ValueType valueType,
            doc = new Document();
                    .build(
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
            iw.addDocument(Arrays.asList(new IntPoint("level", 3), new SortedDocValuesField(FIELD_NAME, new BytesRef("foo"))));
    public void testSomeMatchesNumericDocValues() throws IOException {
    }
            aggregationBuilder.userValueTypeHint(valueType);
        ValueType valueType,
    ) throws IOException {
    }
import org.opensearch.search.aggregations.AggregationBuilder;
