            }
            iw.addDocument(document);
        }, count -> {
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        InternalValueCount internalValueCount = testAggregation(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                    expectedCollectCount,
                return searchAndReduceCounting(
 * Licensed to Elasticsearch under one or more contributor
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, ValueType.NUMERIC);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(FIELD_NAME, NumberFieldMapper.NumberType.LONG);
                document1.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("3" + i)));
                iw.addDocument(document);
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(multiRecord))));
                    false,
    }
            assertFalse(AggregationInspectionHelper.hasValue(count));
    }
        }, count -> {
import java.util.Map;
            CoreValuesSourceType.BOOLEAN,
        MappedFieldType mappedFieldType = createMappedFieldType(field, ValueType.STRING);
import org.opensearch.index.mapper.BooleanFieldMapper;
    }
 * software distributed under the License is distributed on an
        }
    public void testSingleScriptString() throws IOException {
            assertTrue(AggregationInspectionHelper.hasValue(count));
            document3.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("Accessories")));
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
    public void testNoMatchingField() throws IOException {
    }
                document.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(2.3D + i)));
    }
        Query query,
            assertEquals(3, valueCount.getValue(), 0);
    }
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);
            document3.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("Electronics")));
    }
        MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType(fieldName, rangeType);
            CoreValuesSourceType.RANGE
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 7)));
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("1")));
    public void testNumericSingletonSegmentSkipsCollection() throws IOException {
                document.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(14D + i)));
import org.opensearch.script.ScriptService;
 *
                    indexSearcher,
                document1.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("1" + i)));
    public void testQueryFiltering() throws IOException {
            Document document2 = new Document();
            }
    }
            // Note: unlike numerics, lucene de-dupes strings so we increment here
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").field(field);
        }, valueCount -> {
                document1.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("2" + i)));
        Set<RangeFieldMapper.Range> multiRecord = new HashSet<>(2);
            iw.addDocument(document2);
            for (int i = 0; i < 7; i++) {
                return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.DOUBLE);
            iw.addDocument(document);
import java.util.function.Consumer;
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("foo")));
                    null,
        testAggregation(new FieldExistsQuery(FIELD_NAME), ValueType.NUMBER, iw -> {
import org.opensearch.index.mapper.IpFieldMapper;
    }
    }
        scripts.put(NUMBER_VALUE_SCRIPT, vars -> (((Number) vars.get("_value")).doubleValue() + 1));
        MappedFieldType fieldType
                Document document1 = new Document();
            assertEquals(0, count.getValue(), 0);
        testAggregation(query, valueType, indexer, verify, true);
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, ValueType.STRING);
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("_mvdc").field(FIELD_NAME);
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("_name");
        });
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
 */
            Document document4 = new Document();
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").field(FIELD_NAME)
        final String field = "keywords";
import org.apache.lucene.document.IntPoint;
        InternalValueCount internalValueCount = testAggregation(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
    }
                assertFalse(AggregationInspectionHelper.hasValue(count));
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, MULTI_SCRIPT, Collections.emptyMap())
            .missing(new GeoPoint(42.39561, -71.13051));
    private void testAggregation(
            testAggregation(new MatchAllDocsQuery(), valueType, iw -> {
    ) throws IOException {
            }
            Document doc2 = new Document();
        Consumer<InternalValueCount> verify
            iw.addDocument(document4);
            for (int i = 0; i < 9; i++) {
            // Note: The field values won't be taken into account. The script will only be called
            doc3.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("multi2-3")));
        switch (valueType) {
        });
            assertFalse(AggregationInspectionHelper.hasValue(valueCount));
            case NUMBER:
            assertEquals(6L, count.getValue());
            iw.addDocument(document);
            .missing(1234);
        final String geoPointField = "geoPoint";
import org.apache.lucene.document.LatLonDocValuesField;
            iw.addDocument(document);
import org.opensearch.search.aggregations.support.ValueType;
 */
                return new RangeFieldMapper.RangeFieldType(name, RangeType.DOUBLE);
import org.apache.lucene.document.NumericDocValuesField;
            assertTrue(AggregationInspectionHelper.hasValue(count));
                document.add(new SortedNumericDocValuesField("unrelatedField", 9));
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, ValueType.STRING);
    public void testSingleValueGeoPoint() throws IOException {
 * GitHub history for details.
    public void testNoMultiValuesDocs() throws IOException {
                Document document = new Document();
    ) throws IOException {
                return new GeoPointFieldMapper.GeoPointFieldType(name);
        assertEquals(2L, internalValueCount.getValue());
import org.apache.lucene.search.MatchAllDocsQuery;
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
            }
                document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("stringValue" + i)));
            }
        MappedFieldType mappedFieldType = createMappedFieldType(FIELD_NAME, ValueType.STRING);
                iw.addDocument(document);
            assertFalse(AggregationInspectionHelper.hasValue(count));
        MappedFieldType mappedFieldType = createMappedFieldType(geoPointField, ValueType.GEOPOINT);
        }, fieldType);
        });
            Document document = new Document();
import org.opensearch.index.mapper.HllFieldMapper;
                iw.addDocument(document);
import java.io.IOException;
        Query query,
        scripts.put(STRING_VALUE_SCRIPT, vars -> (Double.valueOf((String) vars.get("_value")) + 1));
            iw.addDocument(List.of(new NumericDocValuesField(FIELD_NAME, 30)));
    public void testSomeMatchesSortNumericDocValues() throws IOException {
            iw.addDocument(doc2);
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("foo1")));
        }, valueCount -> {
            for (int i = 0; i < 3; i++) {
            assertEquals(0, valueCount.getValue());
import org.opensearch.script.MockScriptEngine;
        }, mappedFieldType);
        aggregationBuilder.field(FIELD_NAME);
            document = new Document();
        testAggregation(new MatchAllDocsQuery(), ValueType.LONG, iw -> {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.search.aggregations.support.ValuesSourceType;
            iw.addDocument(document);
            assertEquals(3, count.getValue());
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("5")));
 *    http://www.apache.org/licenses/LICENSE-2.0
            iw.addDocument(List.of(new NumericDocValuesField(FIELD_NAME, 10)));
                document.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(23D + i)));
        }, count -> { assertEquals(3L, count.getValue()); });
            CoreValuesSourceType.IP,
 * the Apache License, Version 2.0 (the "License"); you may
                iw.addDocument(document);
        }, valueCount -> {
            iw.addDocument(List.of(new NumericDocValuesField(FIELD_NAME, 20)));
            doc3.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("multi2-1")));
            document = new Document();
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("3")));
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
            assertEquals(0, valueCount.getValue(), 0);
                    aggregationBuilder,
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, valueType);
import org.opensearch.search.aggregations.AggregatorTestCase;
        }, valueCount -> {
        }, 9, mappedFieldType);
    }
import java.util.function.Function;
    }
    ) throws IOException {
                Document document = new Document();
        CheckedConsumer<RandomIndexWriter, IOException> indexer,
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        assertTrue(AggregationInspectionHelper.hasValue(internalValueCount));
            }
            Document doc1 = new Document();
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SINGLE_SCRIPT, Collections.emptyMap())
            document3.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("Phones")));
                iw.addDocument(document);
        ValueType valueType,
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                document.add(new IntPoint("level", i));
            case DOUBLE:
    private void testAggregation(
            assertEquals(0L, count.getValue());
            document4.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("Clothing")));
import org.opensearch.index.mapper.NumberFieldMapper;
                iw.addDocument(document1);
        InternalValueCount internalValueCount = testAggregation(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
        }, count -> {
        final RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(rangeType, 6.0D, 10.0D, true, true);
import org.apache.lucene.document.SortedSetDocValuesField;
        }
            assertFalse(AggregationInspectionHelper.hasValue(count));
            assertEquals(0, valueCount.getValue());
                    false,
import org.apache.lucene.search.IndexSearcher;
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").field(geoPointField);
    }
        }, count -> assertEquals(0L, count.getValue()));
                );
                document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("sample1")));
        return List.of(HllFieldMapper.CONTENT_TYPE);
    @Override
        final String fieldName = "rangeField";
    @Override
            doc1.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(23D)));
        }, 3, mappedFieldType);
            // Note: unlike numerics, lucene de-dupes strings so we increment here
            case RANGE:
                document.add(new SortedNumericDocValuesField("unrelatedField", 7));
 * not use this file except in compliance with the License.
    private static final String MULTI_SCRIPT = "multi";
            Document document2 = new Document();
            CoreValuesSourceType.BYTES,
        return Arrays.asList(
                Document document = new Document();
        }
            }
    private <A extends InternalAggregation> A testAggregation(
    }
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("4")));
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("6")));
 * this file be licensed under the Apache-2.0 license or a
                document.add(new SortedNumericDocValuesField("unrelatedField", 9));
    ) throws IOException {
                document.add(new SortedNumericDocValuesField("unrelatedField", 7));
        MappedFieldType mappedFieldType = createMappedFieldType(field, ValueType.STRING);
        boolean testWithHint
        multiRecord.add(range2);
                document1.add(new SortedNumericDocValuesField(FIELD_NAME, i * 10 + i));
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
 * You may obtain a copy of the License at
        }, count -> {
            // Every document return 1. So, multivalue_count is zero
            assertFalse((AggregationInspectionHelper.hasValue(valueCount)));
                    -1,
                return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.UNSIGNED_LONG);
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
import org.apache.lucene.search.Query;
import org.opensearch.index.mapper.MappedFieldType;
            doc2.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("multi2-1")));
            // Every document return 1. So, multivalue_count is zero
        Consumer<InternalValueCount> verify,
 * specific language governing permissions and limitations
        assertFalse(AggregationInspectionHelper.hasValue(internalValueCount));
        assertEquals(0L, internalValueCount.getValue());
    public void testRangeFieldValues() throws IOException {
            Document document3 = new Document();
import org.opensearch.common.CheckedConsumer;
import org.apache.lucene.document.SortedNumericDocValuesField;
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range1)))));
        testAggregation(new MatchAllDocsQuery(), ValueType.STRING, iw -> {
            for (int i = 0; i < 3; i++) {
                return new DateFieldMapper.DateFieldType(name);
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range2)))));
                Document document = new Document();
                iw.addDocument(document);
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
import org.opensearch.index.mapper.KeywordFieldMapper;
        assertTrue(AggregationInspectionHelper.hasValue(internalValueCount));
            Document document = new Document();
            case STRING:
    public void testValueScriptNumber() throws IOException {
    private void testAggregation(
        MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, scripts, Collections.emptyMap());
        );
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("2")));
        scripts.put(SINGLE_SCRIPT, vars -> 1);
                    mappedFieldTypes
    }
    public void testQueryFiltersAll() throws IOException {
            case GEOPOINT:
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("6")));
    public void testNoDocs() throws IOException {
            assertFalse(AggregationInspectionHelper.hasValue(valueCount));
    public void testNumericSingletonSegmentCollection() throws IOException {
            }
    @Override
            Document document1 = new Document();
import org.apache.lucene.tests.index.RandomIndexWriter;
            CoreValuesSourceType.NUMERIC,
import java.util.List;
import org.opensearch.script.ScriptType;
public class MultiValueDocCountAggregatorTests extends AggregatorTestCase {
        });
        }, valueCount -> {
/*
                document.add(new SortedNumericDocValuesField("unrelatedField", 8));
    public void testEmptyValues() throws IOException {
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
            iw.addDocument(Arrays.asList(new SortedNumericDocValuesField("wrong_number", 7)));
    }
            for (int i = 7; i < 10; i++) {
    protected ScriptService getMockScriptService() {
    public void testKeywordsField() throws IOException {
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        InternalValueCount internalValueCount = testAggregation(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
            document = new Document();
        }, 3, fieldType);
        testAggregation(IntPoint.newRangeQuery("level", -1, 0), ValueType.STRING, iw -> {
            iw.addDocument(document3);
    }
                document1.add(new SortedNumericDocValuesField(FIELD_NAME, i * 10 + i));
            assertEquals(0, valueCount.getValue(), 0);
            doc1.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("single1-1")));
 * Modifications Copyright OpenSearch Contributors. See
            // document1 has single value.
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        });
            document1.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("Computers")));
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("_mvdc").field(FIELD_NAME);
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, NUMBER_VALUE_SCRIPT, Collections.emptyMap()));
import org.opensearch.script.ScriptModule;
            // Note: The field values won't be taken into account. The script will only be called
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
        assertFalse(AggregationInspectionHelper.hasValue(internalValueCount));
    private static final String FIELD_NAME = "field";
            document = new Document();
    }
            document.add(new SortedSetDocValuesField(field, new BytesRef("1")));
            iw.addDocument(doc1);
            }
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").field("number")
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, STRING_VALUE_SCRIPT, Collections.emptyMap()));
            Document document = new Document();
        }, null);
 * this work for additional information regarding copyright
    }
    }
 * Unless required by applicable law or agreed to in writing,
        testAggregation(aggregationBuilder, query, indexer, verify, fieldType);
    public void testUnmappedMissingGeoPoint() throws IOException {
    }
import org.opensearch.index.mapper.RangeType;
                Document document = new Document();
import org.opensearch.script.Script;
        }, count -> {
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 9)));
 *
        final String field = "keywords";
import java.util.HashMap;
            for (int i = 0; i < 10; i++) {
            document3.add(new SortedSetDocValuesField(field, new BytesRef("0")));
                return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.LONG);
            document2.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("Books")));
            assertEquals(2, count.getValue());
 */
            }
            iw.addDocument(doc1);
        InternalValueCount internalValueCount = testAggregation(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
            assertEquals(3, valueCount.getValue(), 0);
        scripts.put(MULTI_SCRIPT, vars -> Arrays.asList(1, 2));
                document.add(new IntPoint("level", i));
                document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("sample1")));
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 8)));
        }, null);
                throw new IllegalArgumentException("Test does not support value type [" + valueType + "]");
    public void testMultiValueKeywords() throws IOException {
            default:
package org.opensearch.search.aggregations.metrics;
            }
import org.opensearch.search.aggregations.AggregationBuilder;
    }
            Document document = new Document();
        ValueType valueType,
        }, fieldType);
import org.apache.lucene.search.FieldExistsQuery;
import org.apache.lucene.index.IndexReader;
        for (ValueType valueType : ValueType.values()) {
            document.add(new SortedNumericDocValuesField("wrong_number", 10));
            iw.addDocument(document2);
import org.opensearch.common.settings.Settings;
            Document document3 = new Document();
        );
                return new BooleanFieldMapper.BooleanFieldType(name);
                iw.addDocument(document);
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("1")));
            assertEquals(0L, count.getValue());
            iw.addDocument(doc3);
 * SPDX-License-Identifier: Apache-2.0
            CoreValuesSourceType.DATE,
                assertEquals(0L, count.getValue());
            assertTrue(AggregationInspectionHelper.hasValue(count));
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("4")));
        });
 * license agreements. See the NOTICE file distributed with
            case LONG:
import org.apache.lucene.util.BytesRef;
    }
import java.util.Arrays;
            document2.add(new SortedSetDocValuesField(field, new BytesRef("5")));
            assertEquals(2L, count.getValue());
    protected List<String> unsupportedMappedFieldTypes() {
            case NUMERIC:
            assertTrue(AggregationInspectionHelper.hasValue(count));
            iw.addDocument(document);
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
        testAggregation(IntPoint.newRangeQuery("level", 0, 5), ValueType.STRING, iw -> {
                buildIndex.accept(indexWriter);
            iw.addDocument(document);
        testAggregation(new MatchAllDocsQuery(), ValueType.STRING, iw -> {
            case BOOLEAN:
            }
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").field("number")
 *
            assertEquals(0L, count.getValue());
import static java.util.Collections.singleton;
            assertFalse(AggregationInspectionHelper.hasValue(count));
                document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("sample2")));
    public void testKeywordField() throws IOException {
    public void testUnmappedMissingNumber() throws IOException {
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range1)))));
        return new MultiValueDocCountAggregationBuilder("foo").field(fieldName);
import org.opensearch.index.mapper.DateFieldMapper;
    @Override
        }, count -> {
            for (int i = 0; i < 3; i++) {
        }, 0, fieldType);
                Document document = new Document();
        assertEquals(3L, internalValueCount.getValue());
            document.add(new IntPoint("level", 3));
                document.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(14D + i)));
        Query query,
        }, 0, mappedFieldType);
            for (int i = 0; i < 3; i++) {
        int expectedCollectCount,
            Document document = new Document();
            aggregationBuilder.userValueTypeHint(valueType);
import org.apache.lucene.document.BinaryDocValuesField;
            case IP:
    private static final String NUMBER_VALUE_SCRIPT = "number_value";
            // multivalue_count_doc_aggregator didn't support range field
            }, count -> {
            Document doc3 = new Document();
        testAggregation(query, valueType, indexer, verify, false);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.lucene.document.Document;
            CoreValuesSourceType.GEOPOINT,
}
            document1.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("Electronics")));
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").script(
import java.util.HashSet;
            document2.add(new SortedSetDocValuesField(field, new BytesRef("4")));
 * KIND, either express or implied.  See the License for the
                    query,
        Consumer<InternalValueCount> verify,
import org.opensearch.index.mapper.RangeFieldMapper;
        final RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true);
            });
        }, valueCount -> {
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").field("number")
        AggregationBuilder aggregationBuilder,
            assertFalse(AggregationInspectionHelper.hasValue(valueCount));
    }
            document.add(new SortedSetDocValuesField(field, new BytesRef("2")));
                Document document = new Document();
import org.apache.lucene.store.Directory;
        }, null);
                Document document1 = new Document();
        }, count -> {
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("5")));
    public void testUnmappedMissingString() throws IOException {
 * ownership. Elasticsearch licenses this file to you under
        assertFalse(AggregationInspectionHelper.hasValue(internalValueCount));
    public void testDoubleField() throws IOException {
            case UNSIGNED_LONG:
            iw.addDocument(Arrays.asList(new SortedNumericDocValuesField(FIELD_NAME, 1)));
import org.opensearch.common.geo.GeoPoint;
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
import java.util.Collections;
            iw.addDocument(document1);
                iw.addDocument(document);
        }
            document.add(new SortedNumericDocValuesField("wrong_number", 7));
                document.add(new SortedNumericDocValuesField("unrelatedField", 8));
import org.apache.lucene.util.NumericUtils;
    }
        testAggregation(new MatchAllDocsQuery(), ValueType.STRING, iw -> {
        }, fieldType);
                return new IpFieldMapper.IpFieldType(name);
        RangeType rangeType = RangeType.DOUBLE;
    }
                document.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(2.3D + i)));
    private static MappedFieldType createMappedFieldType(String name, ValueType valueType) {
                document1.add(new SortedNumericDocValuesField(FIELD_NAME, i * 10 + i));
    }
                iw.addDocument(document1);
        assertEquals(0L, internalValueCount.getValue());
        multiRecord.add(range1);
            iw.addDocument(document);
    public void testMultiScriptString() throws IOException {
        testAggregation(new MatchAllDocsQuery(), ValueType.DOUBLE, iw -> {
        final MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("_name").field(fieldName);
/*
            iw.addDocument(document);
            Document document = new Document();
            doc3.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("multi2-2")));
        MappedFieldType... mappedFieldTypes
        try (Directory directory = newDirectory()) {
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").field(FIELD_NAME)
    private static final String SINGLE_SCRIPT = "single";
            case DATE:
        );
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").field(field);
            for (int i = 0; i < 3; i++) {
    }
        }, fieldType);
/*
                return new KeywordFieldMapper.KeywordFieldType(name);
import org.opensearch.search.aggregations.InternalAggregation;
                document.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(23D + i)));
        CheckedConsumer<RandomIndexWriter, IOException> indexer,
            .missing(List.of("unmapped1", "unmapped2"));
                Document document = new Document();
        assertEquals(0L, internalValueCount.getValue());
            iw.addDocument(document3);
        AggregationBuilder aggregationBuilder,
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
            iw.addDocument(document);
import org.opensearch.script.ScriptEngine;
                document.add(new LatLonDocValuesField(geoPointField, 10 + i, 20 + i));
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("2")));
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").script(
            Document doc1 = new Document();
            iw.addDocument(Arrays.asList(new SortedNumericDocValuesField(FIELD_NAME, 7)));
            // document2 and 3 have multiple values.
 * under the License.
    }
import org.apache.lucene.index.DirectoryReader;
    }
    private static final String STRING_VALUE_SCRIPT = "string_value";
        Query query,
            for (int i = 0; i < 3; i++) {
import java.util.Set;
import org.opensearch.index.mapper.GeoPointFieldMapper;
            doc2.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("multi2-2")));
    public void testValueScriptString() throws IOException {
        if (valueType != null && testWithHint) {
 * compatible open source license.
        }, count -> {
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("3")));
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(FIELD_NAME, NumberFieldMapper.NumberType.LONG);
