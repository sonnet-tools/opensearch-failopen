    }
            min = Math.min(min, value);  
    }
                    .build(
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
                    expected.add(value);  
                Document doc = new Document();  
                    expected.max + 1,
            stats("_name").field("field").script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT_NAME, emptyMap())),
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {  
            this.sum = sum;
            assertFalse(AggregationInspectionHelper.hasValue(stats));
    public void testSummationAccuracy() throws IOException {
            for (double value : values) {  
                min = value;
import java.util.function.Function;
import org.apache.lucene.index.MultiReader;  
        double expectedSum,
        ) {
        verifySummationOfDoubles(values, 15.3, 0.9, 0d, values.length * TOLERANCE);
            assertEquals(expectedAvg, stats.getAvg(), singleSegmentDelta);  
        final MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.DOUBLE);
                verify.accept(stats);
            assertEquals(expected.min, stats.getMin(), 0);  
                aggregator.postCollection();  
    @Override  
        final Map<String, Function<Map<String, Object>, Object>> scripts = Map.of(
            Directory mappedDirectory = newDirectory();  
        }
            assertTrue(AggregationInspectionHelper.hasValue(stats));
        for (int i = 0; i < n; i++) {
                final InternalStats stats = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, fieldTypesArray);
                assertEquals(expected.min, stats.getMin(), 0);
    }
            assertEquals(missingValue, stats.getMin(), 0);  
 * specific language governing permissions and limitations
            assertTrue(AggregationInspectionHelper.hasValue(stats));  
            final int numDocs = randomIntBetween(10, 50);
            assertEquals(Double.NEGATIVE_INFINITY, stats.getMax(), 0);
import static java.util.Collections.singletonMap;
                assertEquals(adjusted.sum / adjusted.count, stats.getAvg(), TOLERANCE);
import org.opensearch.search.aggregations.LeafBucketCollector;
/*
        double expectedAvg,
        }, singleton(ft));
        Consumer<InternalStats> verify,
            assertEquals(expected.sum / expected.count, stats.getAvg(), TOLERANCE);
            this.min = min;
                assertEquals(expected.sum, stats.getSum(), TOLERANCE);
import static java.util.Collections.emptyMap;
            assertEquals(Float.NaN, stats.getAvg(), 0);  
            assertEquals(Float.NaN, stats.getAvg(), 0);
 *  
import org.opensearch.index.mapper.MappedFieldType;
    }  
    }
                MultiReader multiReader = new MultiReader(mappedReader, unmappedReader)
        final Map<String, ScriptEngine> engines = singletonMap(engine.getType(), engine);  
        for (double value : values) {
                assertTrue(factories.allFactoriesSupportIntraSegmentSearch());
            ) {
        });
                    doc.add(new SortedNumericDocValuesField(ft.name(), valueAsLong));
                IndexSearcher searcher = newIndexSearcher(reader);  
            assertEquals(values.length, stats.getCount());
            } else {  
                assertTrue(AggregationInspectionHelper.hasValue(stats));  
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
import static java.util.Collections.singletonList;
                final long value = randomLongBetween(-100, 100);  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                assertEquals(expected.count, stats.getCount(), 0);
            assertEquals(expectedMin, stats.getMin(), 0d);  
import java.util.Arrays;
                assertEquals(adjusted.min, stats.getMin(), 0);
                max = value;
                    expected.sum + expected.count
                assertTrue(AggregationInspectionHelper.hasValue(stats));
                assertEquals(adjusted.min, stats.getMin(), 0);
    private void randomLongsTestCase(  
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
        double sum = 0;
                assertEquals(expected.min, stats.getMin(), 0);
                    expected.sum + expected.count
                StatsAggregator aggregator = createAggregator(builder, searcher, ft);
    @Override
            assertEquals(expected.count, stats.getCount(), 0);
                assertEquals(expected.count, stats.getCount(), 0);
            }
        verifySummationOfDoubles(largeValues, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, 0d);  
            this.max = max;  
            }  
                indexWriter.addDocument(singleton(new SortedNumericDocValuesField(ft.name(), value)));
            }
    public void testMissing() throws IOException {
        }, singleton(ft));  
                assertTrue(AggregationInspectionHelper.hasValue(stats));
        }
 * GitHub history for details.
            }
                docs.add(singletonList(new NumericDocValuesField(ft.name(), NumericUtils.doubleToSortableLong(value))));
import org.opensearch.search.aggregations.AggregatorTestCase;
        Collection<MappedFieldType> fieldTypes  
    public void testMissingUnmapped() throws IOException {
            for (int i = 0; i < numDocs; i++) {
        );
                assertEquals(adjusted.count, stats.getCount(), 0);
            assertEquals(expected.max, stats.getMax(), 0);
    static class SimpleStatsAggregator {
                    expected.min + 1,
            RandomIndexWriter unmappedWriter = new RandomIndexWriter(random(), unmappedDirectory)  
    }
            (expected, stats) -> {
            1,
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)  
            }  
import org.opensearch.script.ScriptType;
            sum += value;  
 *
                assertEquals(adjusted.sum, stats.getSum(), TOLERANCE);  
            assertEquals(expectedAvg, stats.getAvg(), manySegmentDelta);  
        testCase(stats("_name").field(ft.name()), iw -> {
        void add(double value) {
            assertTrue(AggregationInspectionHelper.hasValue(stats));  
import org.opensearch.script.Script;  
import org.opensearch.index.mapper.NumberFieldMapper;  
    private static final double TOLERANCE = 1e-10;  
            Directory unmappedDirectory = newDirectory();
        n = randomIntBetween(5, 10);
        BiConsumer<SimpleStatsAggregator, InternalStats> verify  
        testCase(stats("_name").field(ft.name()), iw -> {  
                // Directly call collectRange on each leaf to test with size:0 queries
                AggregatorFactories factories = AggregatorFactories.builder()  
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                assertEquals(adjusted.min, stats.getMin(), 0);
                    long valueAsLong = NumericUtils.doubleToSortableLong(value);
            assertEquals(Double.NEGATIVE_INFINITY, stats.getMax(), 0);
            assertTrue(AggregationInspectionHelper.hasValue(stats));
import java.util.Set;
import org.apache.lucene.index.IndexableField;
import org.opensearch.common.settings.Settings;
        }, stats -> {
    @Override
                assertEquals(adjusted.min, stats.getMin(), 0);
            }
        int n = randomIntBetween(5, 10);
    private static final String VALUE_SCRIPT_NAME = "value_script";
            final SimpleStatsAggregator expected = new SimpleStatsAggregator();
 * The OpenSearch Contributors require contributions made to  
                IndexReader unmappedReader = unmappedWriter.getReader();  
                assertEquals(expected.max, stats.getMax(), 0);
                    expected.count,
                    );  
                );  
    ) throws IOException {
            try (IndexReader reader = indexWriter.getReader()) {
}
 * Modifications Copyright OpenSearch Contributors. See  
                iw.addDocument(doc);
        }, singleton(ft));
            }
            (expected, stats) -> {
            if (randomBoolean()) {
        testCase(stats("_name").field(ft.name()), iw -> {  
            valuesPerField,  
            assertEquals(0d, stats.getCount(), 0);  
            }
        return new StatsAggregationBuilder("_name").field(fieldName);
            assertEquals(numDocs * missingValue, stats.getSum(), TOLERANCE);
            assertEquals(expectedSum, stats.getSum(), singleSegmentDelta);
import org.apache.lucene.index.IndexReader;  
            }
        SimpleStatsAggregator(long count, double min, double max, double sum) {  
            }
        }, singleton(ft));
import java.util.function.BiConsumer;  
 * the Apache License, Version 2.0 (the "License"); you may
                );
            (expected, stats) -> {  
            assertEquals(expected.count, stats.getCount(), 0);
                assertEquals(adjusted.sum / adjusted.count, stats.getAvg(), TOLERANCE);
                    expected.max + 1,
        double max = Long.MIN_VALUE;
        double[] largeValues = new double[n];
        );  
        }, stats -> {
            assertEquals(Double.POSITIVE_INFINITY, stats.getMin(), 0);
                    expected.max + 1,  
            assertEquals(expected.min, stats.getMin(), 0);
                : randomDoubleBetween(Double.MIN_VALUE, Double.MAX_VALUE, true);
                aggregator.preCollection();  
                            .getQueryShardContext(),
        return Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.BOOLEAN, CoreValuesSourceType.DATE);  
import static java.util.Collections.singleton;  
            largeValues[i] = -Double.MAX_VALUE;  
            assertEquals(0d, stats.getSum(), 0);
                assertEquals(expected.sum / expected.count, stats.getAvg(), TOLERANCE);
import java.io.IOException;
                assertEquals(expected.sum / expected.count, stats.getAvg(), TOLERANCE);  
import org.apache.lucene.document.NumericDocValuesField;
        // Summing up a normal array and expect an accurate value
        StatsAggregationBuilder builder,
            List<Long> values = randomList(valuesPerField, valuesPerField, () -> randomLongBetween(-100, 100));  
            assertEquals(missingValue, stats.getMax(), 0);
    ) throws IOException {
                StatsAggregationBuilder builder = stats("_name").field(ft.name());
import java.util.List;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                );  
import org.apache.lucene.store.Directory;  
            int numDocs = randomIntBetween(10, 50);
            largeValues[i] = Double.MAX_VALUE;
        final MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);
    }  
                assertEquals(adjusted.sum / adjusted.count, stats.getAvg(), TOLERANCE);  
                assertEquals(adjusted.max, stats.getMax(), 0);
            }
                IndexReader mappedReader = mappedWriter.getReader();
            count++;
    protected ScriptService getMockScriptService() {  
                final InternalStats stats = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, ft);
                assertEquals(expected.max, stats.getMax(), 0);  
            assertEquals(0d, stats.getCount(), 0);
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.DOUBLE);  
                    expected.sum + expected.count
import java.util.function.Consumer;
            assertEquals(expected.count, stats.getCount(), 0);
package org.opensearch.search.aggregations.metrics;
                assertEquals(adjusted.count, stats.getCount(), 0);
    }  
                assertEquals(adjusted.sum, stats.getSum(), TOLERANCE);
    private void verifySummationOfDoubles(
            List<List<NumericDocValuesField>> docs = new ArrayList<>();
                final String fieldName = (String) vars.get("field");  
            vars -> ((Number) vars.get("_value")).doubleValue() + 1,  
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.index.LeafReaderContext;
    }
        }  
        });  
                final MappedFieldType[] fieldTypesArray = fieldTypes.toArray(new MappedFieldType[0]);  
        StatsAggregationBuilder builder,  
 * this file be licensed under the Apache-2.0 license or a
                for (int j = 0; j < numValues; j++) {
            final long numDocs = expected.count / valuesPerField;
                assertEquals(adjusted.count, stats.getCount(), 0);
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
        SimpleStatsAggregator() {}
            VALUE_SCRIPT_NAME,
            if (Double.compare(value, max) > 0) {  
            valuesPerField,  
    }
        }
                    double value = randomDoubleBetween(-100d, 100d, true);  
                int numValues = randomIntBetween(1, 5);
                    expected.min + 1,
            assertEquals(expectedMax, stats.getMax(), 0d);
        double sum = 0;  
                mappedWriter.addDocument(singleton(new SortedNumericDocValuesField(ft.name(), value)));
        double expectedMax = max;
import static java.util.Collections.emptySet;
    }
import static java.util.stream.Collectors.toSet;
            values.forEach(expected::add);
            assertEquals(expected.sum / expected.count, stats.getAvg(), TOLERANCE);
                final LeafDocLookup lookup = (LeafDocLookup) vars.get("doc");
                for (LeafReaderContext leaf : reader.leaves()) {
                final long value = randomLongBetween(-100, 100);
            assertEquals(missingValue, stats.getAvg(), TOLERANCE);
                docs.add(emptySet());
 * SPDX-License-Identifier: Apache-2.0
 */
                    expected.count,
        values = new double[n];
            try (IndexReader reader = indexWriter.getReader()) {
 */
                ? randomFrom(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)  
    ) throws IOException {
                final IndexSearcher searcher = new IndexSearcher(multiReader);
        final List<Set<IndexableField>> docs = new ArrayList<>(numDocs);
            final StatsAggregationBuilder builder = stats("_name").field(ft.name());
    }
        }, singleton(ft));
 * this work for additional information regarding copyright
import java.util.ArrayList;  
        verifySummationOfDoubles(largeValues, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, 0d);
            stats("_name").field("field").script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT_NAME, emptyMap())),
 *    http://www.apache.org/licenses/LICENSE-2.0
                assertEquals(adjusted.sum / adjusted.count, stats.getAvg(), TOLERANCE);  
                assertEquals(adjusted.max, stats.getMax(), 0);
            if (Double.compare(value, min) < 0) {  
            values[i] = frequently()
        }  
import static java.util.stream.Collectors.toList;  
        }
            final SimpleStatsAggregator expected = new SimpleStatsAggregator();
 * software distributed under the License is distributed on an
            try (
    }  
                    expected.min + 1,  
        }
 * compatible open source license.
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
            sum += values[i];
                expected.add(value);  
            1,
import org.apache.lucene.search.IndexSearcher;
        }  
            final MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);  
        // Summing up some big double values and expect infinity result  
        for (int i = 0; i < numDocs; i++) {
        long count = 0;
                IndexSearcher searcher = newIndexSearcher(reader);
        double min = Double.POSITIVE_INFINITY;  
            assertEquals(Double.POSITIVE_INFINITY, stats.getMin(), 0);  
    }
                expected.add(missingValue);
            assertEquals(expected.sum, stats.getSum(), TOLERANCE);  
                assertTrue(AggregationInspectionHelper.hasValue(stats));
import org.apache.lucene.search.MatchAllDocsQuery;
public class StatsAggregatorTests extends AggregatorTestCase {
    public void testCollectRange() throws IOException {
            assertEquals(numDocs, stats.getCount());  
                    expected.sum + expected.count
            buildIndex.accept(indexWriter);  
import org.opensearch.script.ScriptEngine;
        final MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);  
 * ownership. Elasticsearch licenses this file to you under  
            }  
                    LeafBucketCollector leafCollector = aggregator.getLeafCollector(leaf);  
        }
    }  
        verifySummationOfDoubles(values, sum, sum / n, TOLERANCE, n * TOLERANCE);
            assertEquals(expected.sum, stats.getSum(), TOLERANCE);
/*  
                final SimpleStatsAggregator adjusted = new SimpleStatsAggregator(
    public void testRandomLongs() throws IOException {
        randomLongsTestCase(valuesPerField, stats("_name").field("unknown_field").missing(missingValue), (expected, stats) -> {
import org.opensearch.common.CheckedConsumer;  
            assertEquals(values.length, stats.getCount());
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
        double min = Long.MAX_VALUE;  
        final MockScriptEngine engine = new MockScriptEngine(MockScriptEngine.NAME, scripts, emptyMap());
    }  
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
    }
                    expected.max + 1,  
            }  
        randomLongsTestCase(randomIntBetween(1, 5), stats("_name").field("field"), (expected, stats) -> {  
    public void testEmpty() throws IOException {  
        testCase(builder, iw -> iw.addDocuments(docs), stats -> verify.accept(expected, stats), singleton(ft));
                iw.addDocument(singletonList(new NumericDocValuesField(ft.name(), NumericUtils.doubleToSortableLong(value))));
        }, stats -> {
                InternalStats stats = (InternalStats) aggregator.buildTopLevel();
    public void testFieldScriptSingleValuedField() throws IOException {
            assertEquals(expectedSum, stats.getSum(), manySegmentDelta);
        });
        double max = Double.NEGATIVE_INFINITY;
            vars -> {
        int valuesPerField,
        final int numDocs = randomIntBetween(10, 50);
                    leafCollector.collectRange(0, leaf.reader().maxDoc());
 * license agreements. See the NOTICE file distributed with
        );
            assertEquals(expected.sum, stats.getSum(), TOLERANCE);
                IndexSearcher searcher = new IndexSearcher(reader);
    public void testValueScriptMultiValuedField() throws IOException {  
                assertEquals(adjusted.count, stats.getCount(), 0);
        for (int i = 0; i < n; i++) {  
import org.opensearch.search.aggregations.AggregatorFactories;  
    public void testValueScriptSingleValuedField() throws IOException {
import org.opensearch.script.ScriptService;  
        double expectedMin = min;  
            try (IndexReader reader = indexWriter.getReader()) {
import org.apache.lucene.document.Document;  
            assertEquals(expectedMax, stats.getMax(), 0d);
        );
        final MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);
            for (int i = 0; i < numDocs; i++) {  
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", 1)));  
                    expected.count,
                assertEquals(adjusted.sum, stats.getSum(), TOLERANCE);  
import org.opensearch.script.ScriptModule;
        randomLongsTestCase(  
        final long missingValue = randomIntBetween(-100, 100);
            iw.addDocuments(docs);  
        }  
        double[] values,  
    }
import org.opensearch.search.lookup.LeafDocLookup;  
        double singleSegmentDelta,  
            assertFalse(AggregationInspectionHelper.hasValue(stats));  
 *
                    expected.count,
        final List<Set<IndexableField>> docs = new ArrayList<>(numDocs);  
        final SimpleStatsAggregator expected = new SimpleStatsAggregator();
                assertEquals(adjusted.max, stats.getMax(), 0);  
        final int valuesPerField = randomIntBetween(2, 5);
        testCase(stats("_name").field(ft.name()).missing(missingValue), iw -> iw.addDocuments(docs), stats -> {  
            }
                assertTrue(AggregationInspectionHelper.hasValue(stats));  
            stats("_name").script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, FIELD_SCRIPT_NAME, singletonMap("field", "field"))),
                expected.add(value);
                assertTrue(AggregationInspectionHelper.hasValue(stats));  
        randomLongsTestCase(
            docs.add(values.stream().map(value -> new SortedNumericDocValuesField(ft.name(), value)).collect(toSet()));
        randomLongsTestCase(randomIntBetween(1, 5), stats("_name").field("unmapped_field"), (expected, stats) -> {  
        final int numDocs = randomIntBetween(100, 200);
    public void testUnmapped() throws IOException {
import org.opensearch.script.MockScriptEngine;
        for (int iDoc = 0; iDoc < numDocs; iDoc++) {
import org.opensearch.search.aggregations.AggregationBuilder;
                expected.add(value);  
                long value = randomLongBetween(-100, 100);
            for (double value : values) {
                }
        final SimpleStatsAggregator expected = new SimpleStatsAggregator();  
        }
            assertTrue(AggregationInspectionHelper.hasValue(stats));
    public void testRandomDoubles() throws IOException {  
        randomLongsTestCase(
                final SimpleStatsAggregator adjusted = new SimpleStatsAggregator(  
 */  
        final MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);  
                assertEquals(expected.sum, stats.getSum(), TOLERANCE);  
                assertEquals(adjusted.sum, stats.getSum(), TOLERANCE);
            assertEquals(expected.max, stats.getMax(), 0);  
            assertTrue(AggregationInspectionHelper.hasValue(stats));
import java.util.Collection;
            FIELD_SCRIPT_NAME,
            this.count = count;
                docs.add(singleton(new SortedNumericDocValuesField(ft.name(), value)));
 * not use this file except in compliance with the License.
import java.util.Map;
            for (int i = 0; i < numDocs; i++) {  
        final int valuesPerField = randomIntBetween(1, 5);
                final SimpleStatsAggregator adjusted = new SimpleStatsAggregator(  
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;  
                }
                    expected.min + 1,  
    public void testFieldScriptMultiValuedField() throws IOException {  
    // TODO: Script tests, should fail with defaultValuesSourceType disabled.
 * Unless required by applicable law or agreed to in writing,
        randomLongsTestCase(  
            int numDocs = randomIntBetween(10, 50);
        try (
            }  
        testCase(stats("_name").field(ft.name()), iw -> {}, stats -> {
            assertEquals(expected.min, stats.getMin(), 0);
                return lookup.get(fieldName).stream().map(value -> ((Number) value).longValue() + 1).collect(toList());
        for (int i = 0; i < n; i++) {
            assertEquals(expectedMin, stats.getMin(), 0d);  
/*
                assertEquals(adjusted.max, stats.getMax(), 0);  
        final long missingValue = randomLongBetween(-100, 100);  
    public void testPartiallyUnmapped() throws IOException {
import org.opensearch.search.aggregations.support.ValuesSourceType;
            stats("_name").script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, FIELD_SCRIPT_NAME, singletonMap("field", "field"))),
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7 };  
 * under the License.  
    public void testSupportsIntraSegmentSearch() throws IOException {  
 * You may obtain a copy of the License at  
import org.apache.lucene.util.NumericUtils;
    }  
    }  
 * KIND, either express or implied.  See the License for the
            RandomIndexWriter mappedWriter = new RandomIndexWriter(random(), mappedDirectory);
            }
        final SimpleStatsAggregator expected = new SimpleStatsAggregator();
    private void testCase(
    }
        // Summing up an array which contains NaN and infinities and expect a result same as naive summation  
        double manySegmentDelta
import org.apache.lucene.tests.index.RandomIndexWriter;
        }
            assertEquals(expected.max, stats.getMax(), 0);
                );
            (expected, stats) -> {  
        );  
            max = Math.max(max, value);
                        null
        final int valuesPerField = randomIntBetween(2, 5);
            assertEquals(0d, stats.getSum(), 0);
    private static final String FIELD_SCRIPT_NAME = "field_script";
import org.apache.lucene.document.SortedNumericDocValuesField;
            }
            assertEquals(expected.sum / expected.count, stats.getAvg(), TOLERANCE);  
                final SimpleStatsAggregator adjusted = new SimpleStatsAggregator(
                    .addAggregator(new StatsAggregationBuilder("test").field("value"))
