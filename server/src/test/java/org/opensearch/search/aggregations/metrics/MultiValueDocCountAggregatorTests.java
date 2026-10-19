        testAggregation(new MatchAllDocsQuery(), ValueType.STRING, iw -> {
        aggregationBuilder.field(FIELD_NAME);  
        return new MultiValueDocCountAggregationBuilder("foo").field(fieldName);  
import java.util.function.Consumer;
            for (int i = 0; i < 3; i++) {
            doc1.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("single1-1")));
        }, mappedFieldType);
        }, valueCount -> {
            Document document2 = new Document();
        }, valueCount -> {  
        MappedFieldType mappedFieldType = createMappedFieldType(geoPointField, ValueType.GEOPOINT);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertEquals(0, count.getValue(), 0);  
import org.apache.lucene.search.IndexSearcher;
            assertTrue(AggregationInspectionHelper.hasValue(count));  
            iw.addDocument(Arrays.asList(new SortedNumericDocValuesField(FIELD_NAME, 1)));  
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
            assertEquals(0, valueCount.getValue(), 0);  
        assertEquals(0L, internalValueCount.getValue());
            assertEquals(0, valueCount.getValue());  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            assertTrue(AggregationInspectionHelper.hasValue(count));
            Document document1 = new Document();
            document.add(new IntPoint("level", 3));
import org.apache.lucene.document.Document;
    public void testSomeMatchesSortNumericDocValues() throws IOException {
                assertFalse(AggregationInspectionHelper.hasValue(count));  
            document2.add(new SortedSetDocValuesField(field, new BytesRef("5")));  
            iw.addDocument(doc1);
            // Note: The field values won't be taken into account. The script will only be called
import org.opensearch.search.aggregations.support.ValuesSourceType;
            assertFalse(AggregationInspectionHelper.hasValue(count));  
        }
import org.apache.lucene.document.LatLonDocValuesField;
        scripts.put(SINGLE_SCRIPT, vars -> 1);  
            iw.addDocument(document3);  
        }, count -> {
    public void testNumericSingletonSegmentCollection() throws IOException {  
        }, 9, mappedFieldType);
        }, fieldType);
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
                document.add(new LatLonDocValuesField(geoPointField, 10 + i, 20 + i));
            });
        }, count -> {
            doc1.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(23D)));
import org.apache.lucene.index.IndexReader;  
        testAggregation(IntPoint.newRangeQuery("level", 0, 5), ValueType.STRING, iw -> {
                document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("sample2")));
            document = new Document();
        final String field = "keywords";
        InternalValueCount internalValueCount = testAggregation(new MatchAllDocsQuery(), aggregationBuilder, iw -> {  
            testAggregation(new MatchAllDocsQuery(), valueType, iw -> {
        multiRecord.add(range2);
    }  
        final String geoPointField = "geoPoint";
        Consumer<InternalValueCount> verify,  
                document.add(new IntPoint("level", i));
import java.util.Set;
        );
        }, 3, mappedFieldType);  
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, ValueType.STRING);
            assertEquals(2, count.getValue());  
            doc2.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("multi2-2")));
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
                document1.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("1" + i)));
            // Every document return 1. So, multivalue_count is zero  
                return new IpFieldMapper.IpFieldType(name);
                throw new IllegalArgumentException("Test does not support value type [" + valueType + "]");
        int expectedCollectCount,  
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 8)));
            document = new Document();  
import java.util.HashSet;
 * compatible open source license.
import java.util.HashMap;  
        Query query,
            document1.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("Computers")));
            assertFalse(AggregationInspectionHelper.hasValue(valueCount));
 * software distributed under the License is distributed on an
                Document document1 = new Document();
        }, null);
            iw.addDocument(document);  
    }
        Consumer<InternalValueCount> verify,  
            .missing(1234);
    }
            iw.addDocument(document);
import org.opensearch.index.mapper.BooleanFieldMapper;  
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").field("number")  
        testAggregation(IntPoint.newRangeQuery("level", -1, 0), ValueType.STRING, iw -> {
    }  
        }, null);
 */  
        });
import org.apache.lucene.document.NumericDocValuesField;
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, ValueType.NUMERIC);
        RangeType rangeType = RangeType.DOUBLE;
            case DOUBLE:  
import java.util.Arrays;
                iw.addDocument(document);
        assertEquals(2L, internalValueCount.getValue());
            }
            Document document = new Document();  
/*
    }  
            // document2 and 3 have multiple values.
 * Unless required by applicable law or agreed to in writing,
    public void testNoMatchingField() throws IOException {  
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").script(  
            iw.addDocument(doc1);  
            iw.addDocument(document);
        }, fieldType);  
            CoreValuesSourceType.BOOLEAN,
    ) throws IOException {
            assertEquals(0L, count.getValue());
import org.apache.lucene.util.NumericUtils;
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("foo")));
            case DATE:
import org.opensearch.script.ScriptEngine;  
            case STRING:
 * license agreements. See the NOTICE file distributed with
        }
                iw.addDocument(document);  
        testAggregation(query, valueType, indexer, verify, false);
            iw.addDocument(document);
            case NUMERIC:  
                iw.addDocument(document);  
                iw.addDocument(document);  
            for (int i = 0; i < 10; i++) {
        CheckedConsumer<RandomIndexWriter, IOException> indexer,
import java.util.function.Function;  
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
            }
            iw.addDocument(List.of(new NumericDocValuesField(FIELD_NAME, 10)));
                return searchAndReduceCounting(
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("1")));
            .missing(new GeoPoint(42.39561, -71.13051));
    }
        assertEquals(0L, internalValueCount.getValue());
                document.add(new IntPoint("level", i));  
            assertFalse(AggregationInspectionHelper.hasValue(count));
        }, valueCount -> {
        }, count -> { assertEquals(3L, count.getValue()); });  
        scripts.put(MULTI_SCRIPT, vars -> Arrays.asList(1, 2));
                document1.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("2" + i)));  
                    -1,
import org.opensearch.common.geo.GeoPoint;
    }  
    }
    private static MappedFieldType createMappedFieldType(String name, ValueType valueType) {  
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range1)))));  
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("1")));  
        testAggregation(new FieldExistsQuery(FIELD_NAME), ValueType.NUMBER, iw -> {  
    }
            assertFalse(AggregationInspectionHelper.hasValue(valueCount));  
        testAggregation(aggregationBuilder, query, indexer, verify, fieldType);
                document.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(23D + i)));
}
                    false,  
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, MULTI_SCRIPT, Collections.emptyMap())
        }, count -> assertEquals(0L, count.getValue()));  
 *
    }
            case RANGE:
            }  
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").field(geoPointField);  
                document.add(new SortedNumericDocValuesField("unrelatedField", 9));
        AggregationBuilder aggregationBuilder,  
        }, 0, fieldType);
    @Override
                IndexSearcher indexSearcher = newIndexSearcher(indexReader);  
            iw.addDocument(List.of(new NumericDocValuesField(FIELD_NAME, 30)));  
    }
            assertEquals(0L, count.getValue());
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
            document2.add(new SortedSetDocValuesField(field, new BytesRef("4")));
 * this work for additional information regarding copyright
import org.apache.lucene.store.Directory;
    }
        testAggregation(new MatchAllDocsQuery(), ValueType.STRING, iw -> {  
                    expectedCollectCount,
public class MultiValueDocCountAggregatorTests extends AggregatorTestCase {
            Document document = new Document();
                document.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(14D + i)));  
        }, fieldType);
            aggregationBuilder.userValueTypeHint(valueType);
            for (int i = 0; i < 9; i++) {  
            document3.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("Phones")));
        final RangeFieldMapper.Range range1 = new RangeFieldMapper.Range(rangeType, 1.0D, 5.0D, true, true);  
        assertEquals(0L, internalValueCount.getValue());
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("5")));
            // Note: The field values won't be taken into account. The script will only be called
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
    public void testRangeFieldValues() throws IOException {
 * the Apache License, Version 2.0 (the "License"); you may
        }, valueCount -> {
import org.opensearch.index.mapper.MappedFieldType;  
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
        testAggregation(new MatchAllDocsQuery(), ValueType.DOUBLE, iw -> {  
    public void testMultiScriptString() throws IOException {
/*  
        final MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("_name").field(fieldName);
            iw.addDocument(doc2);
    public void testQueryFiltering() throws IOException {
            assertFalse(AggregationInspectionHelper.hasValue(count));
            for (int i = 0; i < 3; i++) {
        scripts.put(STRING_VALUE_SCRIPT, vars -> (Double.valueOf((String) vars.get("_value")) + 1));
 * Modifications Copyright OpenSearch Contributors. See
            Document doc3 = new Document();
        });
            CoreValuesSourceType.NUMERIC,  
        MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, scripts, Collections.emptyMap());  
import org.opensearch.common.CheckedConsumer;  
        }, 0, mappedFieldType);
        Consumer<InternalValueCount> verify
        }, valueCount -> {
            case IP:
        MappedFieldType mappedFieldType = createMappedFieldType(field, ValueType.STRING);
import org.apache.lucene.document.SortedSetDocValuesField;
import static java.util.Collections.singleton;
    }  
        Set<RangeFieldMapper.Range> multiRecord = new HashSet<>(2);
import org.apache.lucene.document.BinaryDocValuesField;
                Document document = new Document();
        InternalValueCount internalValueCount = testAggregation(new MatchAllDocsQuery(), aggregationBuilder, iw -> {  
                return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.DOUBLE);
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("_mvdc").field(FIELD_NAME);
            for (int i = 0; i < 3; i++) {
            iw.addDocument(document);
import org.apache.lucene.search.MatchAllDocsQuery;  
            iw.addDocument(document1);
    private static final String SINGLE_SCRIPT = "single";
    private <A extends InternalAggregation> A testAggregation(
            assertTrue(AggregationInspectionHelper.hasValue(count));  
            iw.addDocument(document);
        testAggregation(query, valueType, indexer, verify, true);
    }  
        multiRecord.add(range1);  
    private static final String STRING_VALUE_SCRIPT = "string_value";
import org.opensearch.common.settings.Settings;
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range2)))));
            Document doc1 = new Document();
            iw.addDocument(Arrays.asList(new SortedNumericDocValuesField("wrong_number", 7)));
        MappedFieldType mappedFieldType = createMappedFieldType(FIELD_NAME, ValueType.STRING);  
            iw.addDocument(document);
            document1.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("Electronics")));  
                );
                return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.LONG);
                document.add(new SortedNumericDocValuesField("unrelatedField", 7));  
                iw.addDocument(document1);
                Document document = new Document();
                document.add(new SortedNumericDocValuesField("unrelatedField", 8));
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SINGLE_SCRIPT, Collections.emptyMap())  
            for (int i = 0; i < 3; i++) {  
            // Note: unlike numerics, lucene de-dupes strings so we increment here
            }
    public void testMultiValueKeywords() throws IOException {
            }  
    }
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, STRING_VALUE_SCRIPT, Collections.emptyMap()));
            iw.addDocument(doc3);
    }  
    }
        }, fieldType);
        MappedFieldType fieldType = new RangeFieldMapper.RangeFieldType(fieldName, rangeType);  
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").script(
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("3")));
    public void testUnmappedMissingGeoPoint() throws IOException {
                Document document = new Document();
        InternalValueCount internalValueCount = testAggregation(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
            assertEquals(2L, count.getValue());
        return List.of(HllFieldMapper.CONTENT_TYPE);  
                document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("sample1")));
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("6")));
            assertEquals(0L, count.getValue());  
        MappedFieldType mappedFieldType = createMappedFieldType(field, ValueType.STRING);  
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
        }, valueCount -> {
                iw.addDocument(document);
    private void testAggregation(
        }, count -> {  
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").field(FIELD_NAME)
            assertEquals(3, valueCount.getValue(), 0);
            document.add(new SortedSetDocValuesField(field, new BytesRef("2")));
        });
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        }, count -> {
            Document doc1 = new Document();  
            for (int i = 0; i < 3; i++) {
 *
import org.opensearch.script.ScriptService;
            try (IndexReader indexReader = DirectoryReader.open(directory)) {
        if (valueType != null && testWithHint) {  
                document.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(23D + i)));  
import org.opensearch.script.MockScriptEngine;
        final String field = "keywords";  
        Query query,  
        }, null);
import org.opensearch.search.aggregations.AggregationBuilder;
            }
    public void testDoubleField() throws IOException {
import org.opensearch.index.mapper.KeywordFieldMapper;
    ) throws IOException {  
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("4")));
 *  
        });  
            case NUMBER:
                    query,
    }  
        MappedFieldType fieldType
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").field("number")  
            CoreValuesSourceType.GEOPOINT,
            }  
            try (RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
 * Licensed to Elasticsearch under one or more contributor  
        MappedFieldType... mappedFieldTypes
 */
    protected List<String> unsupportedMappedFieldTypes() {
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("2")));
            Document document3 = new Document();  
            iw.addDocument(document2);
import org.opensearch.index.mapper.HllFieldMapper;  
            doc3.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("multi2-2")));  
import org.apache.lucene.tests.index.RandomIndexWriter;  
    public void testEmptyValues() throws IOException {  
                return new DateFieldMapper.DateFieldType(name);  
            iw.addDocument(document2);  
    }
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
                buildIndex.accept(indexWriter);
    public void testNoDocs() throws IOException {  
                document.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(2.3D + i)));
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.util.BytesRef;
    public void testNumericSingletonSegmentSkipsCollection() throws IOException {  
import java.util.Collections;
    @Override  
import org.opensearch.search.aggregations.AggregatorTestCase;
            iw.addDocument(document4);
    public void testQueryFiltersAll() throws IOException {
    ) throws IOException {
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {  
        }, 3, fieldType);
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(multiRecord))));  
                    false,
    private static final String FIELD_NAME = "field";  
            Document document = new Document();
        }  
            assertFalse((AggregationInspectionHelper.hasValue(valueCount)));
        try (Directory directory = newDirectory()) {  
    }
            }
                document.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(2.3D + i)));
                return new NumberFieldMapper.NumberFieldType(name, NumberFieldMapper.NumberType.UNSIGNED_LONG);
                Document document = new Document();
            for (int i = 0; i < 7; i++) {  
            Document document3 = new Document();
                Document document = new Document();
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("_name");
    public void testNoMultiValuesDocs() throws IOException {
    public void testUnmappedMissingString() throws IOException {
            doc2.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("multi2-1")));  
    protected ScriptService getMockScriptService() {
import org.apache.lucene.document.SortedNumericDocValuesField;  
            // document1 has single value.
import org.opensearch.index.mapper.RangeFieldMapper;
import org.opensearch.search.aggregations.support.ValueType;  
    }
            iw.addDocument(document);
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
        assertTrue(AggregationInspectionHelper.hasValue(internalValueCount));
import org.opensearch.script.ScriptType;  
        }, count -> {
                document1.add(new SortedNumericDocValuesField(FIELD_NAME, i * 10 + i));  
import org.opensearch.index.mapper.RangeType;  
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("foo1")));  
                return new KeywordFieldMapper.KeywordFieldType(name);
    }  
        ValueType valueType,
            Document doc2 = new Document();
            document.add(new SortedNumericDocValuesField("wrong_number", 7));  
            Document document4 = new Document();
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, ValueType.STRING);  
                assertEquals(0L, count.getValue());
            .script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, NUMBER_VALUE_SCRIPT, Collections.emptyMap()));
    }  
            Document document2 = new Document();
                return new GeoPointFieldMapper.GeoPointFieldType(name);
 * specific language governing permissions and limitations
            }, count -> {
 */  
                document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("sample1")));  
        testCase(aggregationBuilder, query, buildIndex, verify, fieldType);  
        }
import org.opensearch.index.mapper.NumberFieldMapper;
/*  
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
import org.opensearch.search.aggregations.InternalAggregation;  
        assertFalse(AggregationInspectionHelper.hasValue(internalValueCount));  
            document4.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("Clothing")));  
 * KIND, either express or implied.  See the License for the
    public void testUnmappedMissingNumber() throws IOException {
    }  
    public void testKeywordsField() throws IOException {  
            document.add(new SortedSetDocValuesField(field, new BytesRef("1")));  
            case GEOPOINT:  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(FIELD_NAME, NumberFieldMapper.NumberType.LONG);
    }
        ValueType valueType,  
    }
                    aggregationBuilder,  
        CheckedConsumer<RandomIndexWriter, IOException> indexer,
                    null,  
    }  
            assertEquals(0, valueCount.getValue());  
                    indexSearcher,
        );
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("6")));
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 7)));
            doc3.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("multi2-3")));
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
                iw.addDocument(document1);  
        MappedFieldType fieldType = createMappedFieldType(FIELD_NAME, valueType);  
                iw.addDocument(document);
import org.apache.lucene.search.FieldExistsQuery;
    public void testSingleValueGeoPoint() throws IOException {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(FIELD_NAME, NumberFieldMapper.NumberType.LONG);
            case UNSIGNED_LONG:  
                Document document = new Document();
            document = new Document();
import org.opensearch.index.mapper.IpFieldMapper;
        );
    }
import org.opensearch.index.mapper.GeoPointFieldMapper;
            assertFalse(AggregationInspectionHelper.hasValue(valueCount));
            assertTrue(AggregationInspectionHelper.hasValue(count));
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").field(field);
                document.add(new SortedNumericDocValuesField("unrelatedField", 9));
        scripts.put(NUMBER_VALUE_SCRIPT, vars -> (((Number) vars.get("_value")).doubleValue() + 1));
 * this file be licensed under the Apache-2.0 license or a
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").field(field);
            assertFalse(AggregationInspectionHelper.hasValue(count));
            iw.addDocument(Arrays.asList(new SortedNumericDocValuesField(FIELD_NAME, 7)));
    private void testAggregation(
            document3.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("Accessories")));
            iw.addDocument(document3);
import java.util.List;
                document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("stringValue" + i)));  
            .missing(List.of("unmapped1", "unmapped2"));
            // Note: unlike numerics, lucene de-dupes strings so we increment here
            }  
            CoreValuesSourceType.DATE,
package org.opensearch.search.aggregations.metrics;
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
            iw.addDocument(List.of(new NumericDocValuesField(FIELD_NAME, 20)));
                Document document = new Document();
        AggregationBuilder aggregationBuilder,
import java.io.IOException;  
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("2")));  
        Query query,
                iw.addDocument(document);
            document.add(new SortedNumericDocValuesField("wrong_number", 10));
            CoreValuesSourceType.IP,
        Query query,  
            assertEquals(0, valueCount.getValue(), 0);
            // multivalue_count_doc_aggregator didn't support range field
            case BOOLEAN:
        }, count -> {
import java.util.Map;  
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 9)));  
                document.add(new SortedNumericDocValuesField("unrelatedField", 8));
                document1.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("3" + i)));
    @Override
            }
        testAggregation(new MatchAllDocsQuery(), ValueType.STRING, iw -> {
        return Arrays.asList(
 * You may obtain a copy of the License at  
        }, count -> {  
import org.apache.lucene.index.DirectoryReader;
    }
        InternalValueCount internalValueCount = testAggregation(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
            case LONG:
            for (int i = 0; i < 3; i++) {
                document1.add(new SortedNumericDocValuesField(FIELD_NAME, i * 10 + i));
        assertFalse(AggregationInspectionHelper.hasValue(internalValueCount));
                Document document1 = new Document();
        switch (valueType) {
            iw.addDocument(document);  
    public void testKeywordField() throws IOException {  
                return new RangeFieldMapper.RangeFieldType(name, RangeType.DOUBLE);  
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("5")));  
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("4")));  
            assertEquals(6L, count.getValue());
            // Every document return 1. So, multivalue_count is zero
            Document document = new Document();  
    private void testAggregation(
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
    public void testValueScriptString() throws IOException {
            }  
            default:
    public void testSingleScriptString() throws IOException {
            assertTrue(AggregationInspectionHelper.hasValue(valueCount));
        final RangeFieldMapper.Range range2 = new RangeFieldMapper.Range(rangeType, 6.0D, 10.0D, true, true);
            for (int i = 7; i < 10; i++) {
            Document document = new Document();
            document = new Document();  
        }, count -> {
        assertFalse(AggregationInspectionHelper.hasValue(internalValueCount));
    @Override  
            document2.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("Books")));
    public void testValueScriptNumber() throws IOException {  
                document1.add(new SortedNumericDocValuesField(FIELD_NAME, i * 10 + i));
        InternalValueCount internalValueCount = testAggregation(new MatchAllDocsQuery(), aggregationBuilder, iw -> {
                iw.addDocument(document);  
        assertTrue(AggregationInspectionHelper.hasValue(internalValueCount));  
            }
    private static final String MULTI_SCRIPT = "multi";
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("_mvdc").field(FIELD_NAME);
        final String fieldName = "rangeField";
            assertEquals(3, valueCount.getValue(), 0);  
            CoreValuesSourceType.BYTES,  
                Document document = new Document();  
            iw.addDocument(document);
        for (ValueType valueType : ValueType.values()) {
            doc3.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("multi2-1")));
        });  
        assertEquals(3L, internalValueCount.getValue());  
import org.opensearch.script.Script;
    }
            CoreValuesSourceType.RANGE  
    ) throws IOException {
            iw.addDocument(singleton(new BinaryDocValuesField(fieldName, rangeType.encodeRanges(singleton(range1)))));
            document3.add(new SortedSetDocValuesField(field, new BytesRef("0")));
            document.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("3")));
 * not use this file except in compliance with the License.
                    mappedFieldTypes
            Document document = new Document();  
        boolean testWithHint
        testAggregation(new MatchAllDocsQuery(), ValueType.LONG, iw -> {
import org.apache.lucene.document.IntPoint;  
import org.apache.lucene.search.Query;
 * SPDX-License-Identifier: Apache-2.0
    }
                return new BooleanFieldMapper.BooleanFieldType(name);  
                document.add(new SortedNumericDocValuesField(FIELD_NAME, NumericUtils.doubleToSortableLong(14D + i)));
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);  
            document3.add(new SortedSetDocValuesField(FIELD_NAME, new BytesRef("Electronics")));  
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").field(FIELD_NAME)  
    private static final String NUMBER_VALUE_SCRIPT = "number_value";  
import org.opensearch.index.mapper.DateFieldMapper;
import org.opensearch.script.ScriptModule;
                document.add(new SortedNumericDocValuesField("unrelatedField", 7));  
        });
        MultiValueDocCountAggregationBuilder aggregationBuilder = new MultiValueDocCountAggregationBuilder("name").field("number")  
            assertEquals(3, count.getValue());
