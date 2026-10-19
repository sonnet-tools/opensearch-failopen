            iw.addDocument(doc);  
import org.apache.lucene.search.MatchAllDocsQuery;
/*  
        testAggregation(aggregationBuilder, query, indexer, verify, fieldType);
    protected List<String> unsupportedMappedFieldTypes() {
        }, valueCount -> {  
            testAggregation(new MatchAllDocsQuery(), valueType, iw -> {
    }  
            });  
            case DATE:
                return new BooleanFieldMapper.BooleanFieldType(name);
import org.opensearch.index.mapper.MappedFieldType;  
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 7)));  
import org.apache.lucene.search.Query;
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 7)));  
            iw.addDocument(singleton(new SortedDocValuesField(FIELD_NAME, new BytesRef("3"))));  
 * Unless required by applicable law or agreed to in writing,
            assertTrue(AggregationInspectionHelper.hasValue(count));
                iw.addDocument(document);
        testAggregation(IntPoint.newRangeQuery("level", 0, 5), ValueType.STRING, iw -> {  
import org.opensearch.index.mapper.KeywordFieldMapper;
    private static final String SINGLE_SCRIPT = "single";
    }
    }
import org.opensearch.script.ScriptModule;
            CoreValuesSourceType.BOOLEAN,
        }, count -> {
import java.util.function.Function;  
            Document doc = new Document();
import org.opensearch.script.ScriptService;
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
        Query query,
import org.apache.lucene.document.Document;
import org.opensearch.script.ScriptEngine;  
                return new RangeFieldMapper.RangeFieldType(name, RangeType.DOUBLE);
        switch (valueType) {  
import org.opensearch.index.mapper.RangeType;  
        }, null);
        MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType(fieldName, rangeType);
            CoreValuesSourceType.DATE,
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, NUMBER_VALUE_SCRIPT, Collections.emptyMap()));
            // Note: The field values won't be taken into account. The script will only be called
    private static MappedFieldType createMappedFieldType(String name, ValueType valueType) {
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 7)));
    @Override
        }, fieldType);  
                Document document = new Document();
import java.util.List;
        final RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true);
        }, fieldType);
import org.apache.lucene.document.LatLonDocValuesField;
    }  
        return Arrays.asList(
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
            case RANGE:
import java.util.Arrays;
            CoreValuesSourceType.IP
    public void testUnmappedMissingString() throws IOException {
        });
            default:  
import org.opensearch.common.settings.Settings;
            case STRING:  
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);
                document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("string11Value")));
 * under the License.  
            case DOUBLE:
                // Intentionally not writing any docs
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
    public void testRangeFieldValues() throws IOException {
            doc = new Document();
        }, null);  
    public void testQueryFiltersAll() throws IOException {  
        }, valueCount -> {  
        }
        AggregationBuilder aggregationBuilder,
import org.apache.lucene.document.DoubleDocValuesField;  
import org.opensearch.script.MockScriptEngine;
        });
}
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range2)))));  
import org.opensearch.index.mapper.DateFieldMapper;
            }
    private static final String STRING_VALUE_SCRIPT = "string_value";
    public void testNoDocs() throws IOException {
import org.opensearch.script.ScriptType;  
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 8)));
package org.opensearch.search.aggregations.metrics;
import org.opensearch.search.aggregations.support.ValuesSourceType;
            assertEquals(4L, count.getValue());
 * KIND, either express or implied.  See the License for the
            doc = new Document();
                return new GeoPointFieldMapper.GeoPointFieldType(name);  
import org.opensearch.index.mapper.IpFieldMapper;
        ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("_name");
            // Note: unlike numerics, lucene de-dupes strings so we increment here
        }, count -> {
            assertEquals(0L, count.getValue());
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
import java.util.Map;  
 *
                assertTrue(factories.allFactoriesSupportIntraSegmentSearch());  
            iw.addDocument(Arrays.asList(new IntPoint("level", 3), new SortedDocValuesField(FIELD_NAME, new BytesRef("foo"))));
        ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("name").field("number").missing(1234);  
        ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("name").script(
    @Override  
    public void testSupportsIntraSegmentSearch() throws IOException {
    }  
            }
            case NUMERIC:
        Query query,  
        }, fieldType);
            doc = new Document();  
            iw.addDocument(Arrays.asList(new IntPoint("level", 5), new SortedDocValuesField(FIELD_NAME, new BytesRef("baz"))));
    }  
                return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.LONG);
                return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.DOUBLE);  
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, STRING_VALUE_SCRIPT, Collections.emptyMap()));
        testAggregation(new MatchAllDocsQuery(), ValueType.STRING, iw -> {
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 9)));
import org.apache.lucene.store.Directory;  
                document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("stringValue")));
    public void testSomeMatchesNumericDocValues() throws IOException {
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
            CoreValuesSourceType.NUMERIC,
        final String fieldName = "rangeField";  
 */
    }  
                    );
    }  
            Document doc = new Document();  
        aggregationBuilder.field(FIELD_NAME);
    }  
 * SPDX-License-Identifier: Apache-2.0
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SINGLE_SCRIPT, Collections.emptyMap())
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, 7));  
        scripts.put(NUMBER_VALUE_SCRIPT, vars -> (((Number) vars.get("_value")).doubleValue() + 1));
    }
        multiRecord.add(range2);
                document.add(new DoubleDocValuesField(FIELD_NAME, 23D));  
                assertEquals(0L, count.getValue());
import java.util.Set;
            doc.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("2")));  
    }
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            try (IndexReader reader = indexWriter.getReader()) {  
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        Query query,  
 * not use this file except in compliance with the License.
                        null
import org.opensearch.index.mapper.BooleanFieldMapper;  
import org.opensearch.search.aggregations.support.ValueType;  
            assertEquals(3, valueCount.getValue(), 0);  
                return new IpFieldMapper.IpFieldType(name);
 * The OpenSearch Contributors require contributions made to  
import static java.util.Collections.singleton;
                return new DateFieldMapper.DateFieldType(name);
    public void testNoMatchingField() throws IOException {
        testAggregation(new FieldExistsQuery(FIELD_NAME), ValueType.NUMERIC, iw -> {  
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
        Consumer<InternalValueCount> verify,
            CoreValuesSourceType.BOOLEAN,  
        ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("name").field("number").missing("🍌🍌🍌");
            doc.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("1")));
                    .addAggregator(new ValueCountAggregationBuilder("test").field("value"))  
            CoreValuesSourceType.RANGE,
    }
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(multiRecord))));
/*  
 * compatible open source license.
import org.apache.lucene.document.SortedSetDocValuesField;  
            case NUMBER:
            for (int i = 0; i < 20; i++) {
import org.apache.lucene.document.BinaryDocValuesField;
        }, count -> {  
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);  
            case UNSIGNED_LONG:
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 7)));  
 * this file be licensed under the Apache-2.0 license or a
 *  
    }  
import java.util.function.Consumer;
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, ValueType.NUMERIC);
            assertFalse(AggregationInspectionHelper.hasValue(count));  
    public void testValueScriptNumber() throws IOException {
            assertEquals(3, valueCount.getValue(), 0);
        Consumer<InternalValueCount> verify,
import org.apache.lucene.document.IntPoint;
        }, valueCount -> {
        testAggregation(IntPoint.newRangeQuery("level", -1, 0), ValueType.STRING, iw -> {
    public void testSingleScriptString() throws IOException {
            assertTrue(AggregationInspectionHelper.hasValue(count));
                throw new IllegalArgumentException("Test does not support value type [" + valueType + "]");
                iw.addDocument(document);  
                return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.UNSIGNED_LONG);  
        );
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, valueType);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        CheckedConsumer<RandomIndexWriter, IOException> indexer,
 * GitHub history for details.
        return List.of(HllFieldMapper.CONTENT_TYPE);
import org.apache.lucene.document.SortedNumericDocValuesField;
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        testAggregation(new MatchAllDocsQuery(), ValueType.LONG, iw -> {
            }, count -> {  
    private static final String FIELD_NAME = "field";  
        }, valueCount -> {
        return new ValueCountAggregationBuilder("foo").field(fieldName);
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range1)))));
            iw.addDocument(Arrays.asList(new IntPoint("level", 3), new SortedDocValuesField(FIELD_NAME, new BytesRef("foo"))));  
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {  
            assertEquals(2L, count.getValue());  
        ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("name").field(FIELD_NAME)
    protected ScriptService getMockScriptService() {  
    ) throws IOException {
        testAggregation(new MatchAllDocsQuery(), ValueType.GEOPOINT, iw -> {
        }, valueCount -> {
                assertFalse(AggregationInspectionHelper.hasValue(count));
        testAggregation(query, valueType, indexer, verify, true);  
            iw.addDocument(singleton(new SortedNumericDocValuesField(FIELD_NAME, 1)));  
 */  
            assertEquals(4.0, count.getValue(), 0);  
        ValueType valueType,
        }, count -> assertEquals(15L, count.getValue()));  
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));
            doc.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("3")));
            assertEquals(3, valueCount.getValue(), 0);  
        MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, scripts, Collections.emptyMap());
            doc.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("4")));
            case BOOLEAN:
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
            iw.addDocument(doc);
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range1)))));
    public void testValueScriptString() throws IOException {  
        RangeType rangeType = RangeType.DOUBLE;  
    public void testQueryFiltering() throws IOException {
                            .getQueryShardContext(),  
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 9)));
        }
            }
            case LONG:  
            assertEquals(2L, count.getValue());
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
        }, fieldType);
            iw.addDocument(Arrays.asList(new IntPoint("level", 1), new SortedDocValuesField(FIELD_NAME, new BytesRef("bar"))));
                    .build(
        }, null);
                AggregatorFactories factories = AggregatorFactories.builder()
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, 8));
public class ValueCountAggregatorTests extends AggregatorTestCase {
        });  
import org.apache.lucene.search.IndexSearcher;  
import org.opensearch.index.mapper.RangeFieldMapper;
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, ValueType.NUMERIC);  
            iw.addDocument(Arrays.asList(new IntPoint("level", 7), new SortedDocValuesField(FIELD_NAME, new BytesRef("baz"))));
            iw.addDocument(doc);
        testAggregation(new MatchAllDocsQuery(), ValueType.DOUBLE, iw -> {  
        for (ValueType valueType : ValueType.values()) {  
 * this work for additional information regarding copyright
        }
            for (int i = 0; i < 10; i++) {  
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
import org.opensearch.index.mapper.NumberFieldMapper;
            CoreValuesSourceType.GEOPOINT,
        Consumer<InternalValueCount> verify  
        testAggregation(new FieldExistsQuery(FIELD_NAME), ValueType.NUMBER, iw -> {
            iw.addDocument(singleton(new SortedDocValuesField(FIELD_NAME, new BytesRef("1"))));
            CoreValuesSourceType.DATE,  
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
    private void testAggregation(
        }, valueCount -> {
            iw.addDocument(doc);  
import java.util.HashSet;
            CoreValuesSourceType.IP,  
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
        boolean testWithHint  
import org.opensearch.common.geo.GeoPoint;
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, 1));
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.mapper.GeoPointFieldMapper;
import org.apache.lucene.document.NumericDocValuesField;  
import org.opensearch.search.aggregations.AggregatorTestCase;  
    @Override
/*
        ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("name").script(
    private void testAggregation(
    private void testAggregation(
            assertEquals(3, valueCount.getValue(), 0);
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, 1));
        }, count -> assertEquals(40L, count.getValue()));
            // Note: The field values won't be taken into account. The script will only be called
import org.apache.lucene.tests.index.RandomIndexWriter;
    public void testSingleScriptNumber() throws IOException {  
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
            // once per document, and only expect a count of 3  
            assertEquals(3, valueCount.getValue(), 0);
import org.apache.lucene.search.FieldExistsQuery;
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        MappedFieldType fieldType  
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", 1)));
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 8)));  
    }
            assertEquals(0L, count.getValue());  
        });
    public void testDoubleField() throws IOException {
import java.util.Collections;
 *    http://www.apache.org/licenses/LICENSE-2.0
            iw.addDocument(doc);
    }  
 *
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
            }
    public void testGeoField() throws IOException {
                Document document = new Document();  
        }, count -> {
    }  
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 9)));
    }
            assertTrue(AggregationInspectionHelper.hasValue(count));  
 * You may obtain a copy of the License at  
            assertEquals(3, valueCount.getValue(), 0);
        final ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("_name").field(fieldName);
import org.opensearch.search.aggregations.AggregatorFactories;
        );  
            assertFalse(AggregationInspectionHelper.hasValue(count));
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 8)));
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 9)));
import org.opensearch.common.CheckedConsumer;  
                document.add(new LatLonDocValuesField("field", 10, 10));
        ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("name").field("number")
            for (int i = 0; i < 15; i++) {
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 7)));  
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SINGLE_SCRIPT, Collections.emptyMap())  
    }
 * specific language governing permissions and limitations
                IndexSearcher searcher = newIndexSearcher(reader);
        }, fieldType);  
    }  
        Set<RangeFieldMapper.Range> multiRecord = new HashSet<>(2);  
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, 7));
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));  
    }
        }
        }, count -> {
 * software distributed under the License is distributed on an
            // once per document, and only expect a count of 3
            doc.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("5")));  
            iw.addDocument(doc);
import org.apache.lucene.util.BytesRef;
        );  
            iw.addDocument(singleton(new SortedDocValuesField(FIELD_NAME, new BytesRef("2"))));
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
import java.util.HashMap;  
    ) throws IOException {
                iw.addDocument(document);  
        multiRecord.add(range1);
 */  
    }
            doc.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("6")));
import org.apache.lucene.document.SortedDocValuesField;
    public void testSomeMatchesSortedNumericDocValues() throws IOException {
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)
    }  
    public void testUnmappedMissingGeoPoint() throws IOException {  
import org.apache.lucene.index.IndexReader;
            iw.addDocument(Arrays.asList(new IntPoint("level", 5), new SortedDocValuesField(FIELD_NAME, new BytesRef("baz"))));  
        }, count -> {
        }, valueCount -> {  
import org.opensearch.search.aggregations.AggregationBuilder;
import org.opensearch.script.Script;
        scripts.put(SINGLE_SCRIPT, vars -> 1);
 * Modifications Copyright OpenSearch Contributors. See
        ValueCountAggregationBuilder aggregationBuilder = new ValueCountAggregationBuilder("name").field(FIELD_NAME)  
    }
            CoreValuesSourceType.BYTES,
        });
 * Licensed to Elasticsearch under one or more contributor  
                return new KeywordFieldMapper.KeywordFieldType(name);
        testAggregation(query, valueType, indexer, verify, false);
            case IP:  
    }  
            case GEOPOINT:
            aggregationBuilder.userValueTypeHint(valueType);  
        // Test both with and without the userValueTypeHint
 * the Apache License, Version 2.0 (the "License"); you may
            assertEquals(3, valueCount.getValue(), 0);  
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, ValueType.STRING);
            iw.addDocument(Arrays.asList(new IntPoint("level", 0), new SortedDocValuesField(FIELD_NAME, new BytesRef("foo"))));
        }, count -> assertEquals(10L, count.getValue()));
    public void testUnmappedMissingNumber() throws IOException {
            iw.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 1)));
            doc.add(new SortedNumericDocValuesField(FIELD_NAME, 8));  
    private static final String NUMBER_VALUE_SCRIPT = "number_value";  
    }
            assertTrue(AggregationInspectionHelper.hasValue(count));
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, ValueType.STRING);  
        final RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(rangeType, 6.0D, 10.0D, true, true);
    }
    @Override  
            .missing(new GeoPoint(42.39561, -71.13051));
import org.opensearch.index.mapper.HllFieldMapper;  
            doc = new Document();  
        if (valueType != null && testWithHint) {
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 8)));  
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 7)));
    public void testKeyWordField() throws IOException {  
                Document document = new Document();
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
            iw.addDocument(singleton(new SortedNumericDocValuesField(FIELD_NAME, 7)));
    ) throws IOException {
        ValueType valueType,  
        scripts.put(STRING_VALUE_SCRIPT, vars -> (Double.valueOf((String) vars.get("_value")) + 1));  
import java.io.IOException;  
 * ownership. Elasticsearch licenses this file to you under  
        CheckedConsumer<RandomIndexWriter, IOException> indexer,
