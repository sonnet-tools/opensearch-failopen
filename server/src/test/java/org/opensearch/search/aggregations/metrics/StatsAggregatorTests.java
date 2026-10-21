        Consumer<InternalStats> verify,
                expected.add(value);
            }
            assertTrue(AggregationInspectionHelper.hasValue(stats));
                assertEquals(adjusted.count, stats.getCount(), 0);
 * ownership. Elasticsearch licenses this file to you under
            int numDocs = randomIntBetween(10, 50);
                final String fieldName = (String) vars.get("field");
                    expected.min + 1,
            assertEquals(expected.min, stats.getMin(), 0);
    private static final String VALUE_SCRIPT_NAME = "value_script";
                assertTrue(AggregationInspectionHelper.hasValue(stats));
    public void testUnmapped() throws IOException {
            }
        final Map<String, ScriptEngine> engines = singletonMap(engine.getType(), engine);
            Directory unmappedDirectory = newDirectory();
            }
    }
                assertTrue(AggregationInspectionHelper.hasValue(stats));
        randomLongsTestCase(randomIntBetween(1, 5), stats("_name").field("field"), (expected, stats) -> {
import org.apache.lucene.util.NumericUtils;
import java.util.Set;
        SimpleStatsAggregator() {}
        double singleSegmentDelta,
        final MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);
                    expected.max + 1,
                verify.accept(stats);
        }, singleton(ft));
                assertEquals(adjusted.sum, stats.getSum(), TOLERANCE);
                assertEquals(adjusted.max, stats.getMax(), 0);
            ) {
            RandomIndexWriter mappedWriter = new RandomIndexWriter(random(), mappedDirectory);
        for (int i = 0; i < numDocs; i++) {
                int numValues = randomIntBetween(1, 5);
            assertEquals(expectedMin, stats.getMin(), 0d);
            VALUE_SCRIPT_NAME,
                min = value;
                    leafCollector.collectRange(0, leaf.reader().maxDoc());
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
        double min = Long.MAX_VALUE;
                assertEquals(adjusted.count, stats.getCount(), 0);
            final long numDocs = expected.count / valuesPerField;
import org.apache.lucene.tests.index.RandomIndexWriter;
 * SPDX-License-Identifier: Apache-2.0
            assertEquals(expectedSum, stats.getSum(), singleSegmentDelta);
import static java.util.stream.Collectors.toSet;
        }
import static java.util.Collections.emptySet;
        }
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        verifySummationOfDoubles(values, 15.3, 0.9, 0d, values.length * TOLERANCE);
            assertTrue(AggregationInspectionHelper.hasValue(stats));
            }
                assertEquals(expected.min, stats.getMin(), 0);
            FIELD_SCRIPT_NAME,
                    expected.sum + expected.count
/*
        });
            assertEquals(expected.sum, stats.getSum(), TOLERANCE);
 * under the License.
import org.apache.lucene.index.IndexableField;
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7 };
                assertTrue(AggregationInspectionHelper.hasValue(stats));
    private static final String FIELD_SCRIPT_NAME = "field_script";
            assertEquals(expected.max, stats.getMax(), 0);
            count++;
 * not use this file except in compliance with the License.
import static java.util.Collections.singletonList;
    private void verifySummationOfDoubles(
                    expected.count,
    public void testPartiallyUnmapped() throws IOException {
                assertEquals(expected.min, stats.getMin(), 0);
            final MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);
            valuesPerField,
                final SimpleStatsAggregator adjusted = new SimpleStatsAggregator(
package org.opensearch.search.aggregations.metrics;
        randomLongsTestCase(
            assertTrue(AggregationInspectionHelper.hasValue(stats));
        }
            docs.add(values.stream().map(value -> new SortedNumericDocValuesField(ft.name(), value)).collect(toSet()));
                final IndexSearcher searcher = new IndexSearcher(multiReader);
 * Modifications Copyright OpenSearch Contributors. See
            iw.addDocuments(docs);
                    expected.min + 1,
 *
    }
            assertEquals(expected.count, stats.getCount(), 0);
    }
 */
                assertEquals(adjusted.max, stats.getMax(), 0);
import org.opensearch.script.ScriptModule;
import static java.util.Collections.singletonMap;
            assertEquals(missingValue, stats.getMax(), 0);
        );
            (expected, stats) -> {
                IndexSearcher searcher = newIndexSearcher(reader);
        final int numDocs = randomIntBetween(100, 200);
            try (
            for (int i = 0; i < numDocs; i++) {
        SimpleStatsAggregator(long count, double min, double max, double sum) {
            assertEquals(expectedSum, stats.getSum(), manySegmentDelta);
        double max = Long.MIN_VALUE;
        }, stats -> {
                assertTrue(AggregationInspectionHelper.hasValue(stats));
            int numDocs = randomIntBetween(10, 50);
            for (double value : values) {
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType("value", NumberFieldMapper.NumberType.LONG);
                assertEquals(adjusted.min, stats.getMin(), 0);
                    expected.sum + expected.count
    public void testValueScriptSingleValuedField() throws IOException {
            assertEquals(expected.min, stats.getMin(), 0);
    }
        final int numDocs = randomIntBetween(10, 50);
                final MappedFieldType[] fieldTypesArray = fieldTypes.toArray(new MappedFieldType[0]);
            max = Math.max(max, value);
            assertFalse(AggregationInspectionHelper.hasValue(stats));
    }
    public void testSummationAccuracy() throws IOException {
            }
            }
        double manySegmentDelta
            1,
            assertEquals(missingValue, stats.getMin(), 0);
                assertTrue(AggregationInspectionHelper.hasValue(stats));
                long value = randomLongBetween(-100, 100);
                AggregatorFactories factories = AggregatorFactories.builder()
        final List<Set<IndexableField>> docs = new ArrayList<>(numDocs);
import org.apache.lucene.search.MatchAllDocsQuery;
            try (IndexReader reader = indexWriter.getReader()) {
                assertEquals(adjusted.max, stats.getMax(), 0);
        }
    public void testFieldScriptSingleValuedField() throws IOException {
 *
        verifySummationOfDoubles(values, sum, sum / n, TOLERANCE, n * TOLERANCE);
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.DOUBLE);
                assertEquals(adjusted.sum, stats.getSum(), TOLERANCE);
            assertEquals(expected.count, stats.getCount(), 0);
            assertEquals(numDocs * missingValue, stats.getSum(), TOLERANCE);
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
            if (Double.compare(value, max) > 0) {
    ) throws IOException {
                assertEquals(adjusted.min, stats.getMin(), 0);
    private static final double TOLERANCE = 1e-10;
                assertEquals(adjusted.sum / adjusted.count, stats.getAvg(), TOLERANCE);
import java.util.List;
                    .build(
import org.apache.lucene.document.NumericDocValuesField;
 * compatible open source license.
            vars -> {
            assertEquals(Float.NaN, stats.getAvg(), 0);
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
            }
import org.opensearch.common.CheckedConsumer;
            stats("_name").field("field").script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT_NAME, emptyMap())),
        StatsAggregationBuilder builder,
        );
                        null
            (expected, stats) -> {
import org.opensearch.script.Script;
                assertEquals(expected.max, stats.getMax(), 0);
                assertTrue(AggregationInspectionHelper.hasValue(stats));
                iw.addDocument(doc);
    public void testCollectRange() throws IOException {
}
        double sum = 0;
        final SimpleStatsAggregator expected = new SimpleStatsAggregator();
                    .addAggregator(new StatsAggregationBuilder("test").field("value"))
            assertEquals(values.length, stats.getCount());
        // Summing up an array which contains NaN and infinities and expect a result same as naive summation
                assertEquals(adjusted.count, stats.getCount(), 0);
                );
        final long missingValue = randomIntBetween(-100, 100);
        for (int iDoc = 0; iDoc < numDocs; iDoc++) {
import java.util.ArrayList;
                iw.addDocument(singletonList(new NumericDocValuesField(ft.name(), NumericUtils.doubleToSortableLong(value))));
            }
            assertEquals(Double.NEGATIVE_INFINITY, stats.getMax(), 0);
            assertEquals(expected.count, stats.getCount(), 0);
            min = Math.min(min, value);
        testCase(stats("_name").field(ft.name()), iw -> {
        }, singleton(ft));
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
import java.util.Collection;
            this.min = min;
        double[] values,
import org.apache.lucene.index.LeafReaderContext;
                StatsAggregator aggregator = createAggregator(builder, searcher, ft);
            assertEquals(expectedAvg, stats.getAvg(), manySegmentDelta);
import org.apache.lucene.document.SortedNumericDocValuesField;
                    expected.min + 1,
        }
        testCase(stats("_name").field(ft.name()), iw -> {}, stats -> {
        // Summing up a normal array and expect an accurate value
 */
        }
        }
import java.io.IOException;
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
        void add(double value) {
 *
            assertEquals(0d, stats.getCount(), 0);
            largeValues[i] = -Double.MAX_VALUE;
        final Map<String, Function<Map<String, Object>, Object>> scripts = Map.of(
    }
        );
        final MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);
        final MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.DOUBLE);
                    LeafBucketCollector leafCollector = aggregator.getLeafCollector(leaf);
import org.opensearch.search.lookup.LeafDocLookup;
            indexWriter.addDocument(singleton(new NumericDocValuesField("value", 1)));
        final int valuesPerField = randomIntBetween(2, 5);
        }
            assertTrue(AggregationInspectionHelper.hasValue(stats));
        for (int i = 0; i < n; i++) {
            RandomIndexWriter unmappedWriter = new RandomIndexWriter(random(), unmappedDirectory)
        double max = Double.NEGATIVE_INFINITY;
            assertFalse(AggregationInspectionHelper.hasValue(stats));
 * GitHub history for details.
        final MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);
 */
            stats("_name").field("field").script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT_NAME, emptyMap())),
            (expected, stats) -> {
            stats("_name").script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, FIELD_SCRIPT_NAME, singletonMap("field", "field"))),
        n = randomIntBetween(5, 10);
                    expected.sum + expected.count
            assertEquals(expected.sum / expected.count, stats.getAvg(), TOLERANCE);
 * The OpenSearch Contributors require contributions made to
            assertEquals(expectedAvg, stats.getAvg(), singleSegmentDelta);
                    expected.count,
        final List<Set<IndexableField>> docs = new ArrayList<>(numDocs);
            1,
            this.count = count;
            values[i] = frequently()
import org.opensearch.search.aggregations.AggregatorFactories;
    }
        double[] largeValues = new double[n];
                assertEquals(adjusted.count, stats.getCount(), 0);
import org.apache.lucene.store.Directory;
            assertEquals(numDocs, stats.getCount());
            values.forEach(expected::add);
            assertEquals(expected.min, stats.getMin(), 0);
                );
 * this file be licensed under the Apache-2.0 license or a
        randomLongsTestCase(randomIntBetween(1, 5), stats("_name").field("unmapped_field"), (expected, stats) -> {
import org.apache.lucene.search.IndexSearcher;
                expected.add(missingValue);
import org.apache.lucene.document.Document;
 *    http://www.apache.org/licenses/LICENSE-2.0
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
        double min = Double.POSITIVE_INFINITY;
        testCase(stats("_name").field(ft.name()).missing(missingValue), iw -> iw.addDocuments(docs), stats -> {
        randomLongsTestCase(
    }
import org.opensearch.search.aggregations.support.ValuesSourceType;
            assertEquals(Double.POSITIVE_INFINITY, stats.getMin(), 0);
            this.max = max;
import org.opensearch.search.aggregations.AggregatorTestCase;
                    expected.count,
 * the Apache License, Version 2.0 (the "License"); you may
            buildIndex.accept(indexWriter);
    }
            assertEquals(expectedMax, stats.getMax(), 0d);
            assertEquals(missingValue, stats.getAvg(), TOLERANCE);
    ) throws IOException {
        }
                return lookup.get(fieldName).stream().map(value -> ((Number) value).longValue() + 1).collect(toList());
            assertEquals(Double.NEGATIVE_INFINITY, stats.getMax(), 0);
        randomLongsTestCase(
                MultiReader multiReader = new MultiReader(mappedReader, unmappedReader)
                final long value = randomLongBetween(-100, 100);
                assertEquals(adjusted.min, stats.getMin(), 0);
                for (LeafReaderContext leaf : reader.leaves()) {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    public void testMissing() throws IOException {
                    expected.max + 1,
            final int numDocs = randomIntBetween(10, 50);
                final SimpleStatsAggregator adjusted = new SimpleStatsAggregator(
        return Arrays.asList(CoreValuesSourceType.NUMERIC, CoreValuesSourceType.BOOLEAN, CoreValuesSourceType.DATE);
                    expected.min + 1,
    private void testCase(
                            .getQueryShardContext(),
        double expectedAvg,
import org.apache.lucene.index.IndexReader;
                    long valueAsLong = NumericUtils.doubleToSortableLong(value);
                assertEquals(adjusted.max, stats.getMax(), 0);
                final SimpleStatsAggregator adjusted = new SimpleStatsAggregator(
            Directory mappedDirectory = newDirectory();
    protected ScriptService getMockScriptService() {
    }
 * this work for additional information regarding copyright
            assertEquals(0d, stats.getCount(), 0);
            }
                mappedWriter.addDocument(singleton(new SortedNumericDocValuesField(ft.name(), value)));
                StatsAggregationBuilder builder = stats("_name").field(ft.name());
        final int valuesPerField = randomIntBetween(2, 5);
    public void testSupportsIntraSegmentSearch() throws IOException {
        testCase(stats("_name").field(ft.name()), iw -> {
    private void randomLongsTestCase(
        double sum = 0;
 * Unless required by applicable law or agreed to in writing,
            if (Double.compare(value, min) < 0) {
                expected.add(value);
                for (int j = 0; j < numValues; j++) {
        }, singleton(ft));
            largeValues[i] = Double.MAX_VALUE;
        ) {
            vars -> ((Number) vars.get("_value")).doubleValue() + 1,
 * You may obtain a copy of the License at
                IndexReader mappedReader = mappedWriter.getReader();
    }
            }
        int n = randomIntBetween(5, 10);
            this.sum = sum;
            sum += values[i];
/*
            for (int i = 0; i < numDocs; i++) {
                assertEquals(adjusted.sum, stats.getSum(), TOLERANCE);
                final long value = randomLongBetween(-100, 100);
        }, stats -> {
        for (int i = 0; i < n; i++) {
 * Licensed to Elasticsearch under one or more contributor
        int valuesPerField,
                    expected.sum + expected.count
import static java.util.Collections.singleton;
                assertEquals(expected.sum / expected.count, stats.getAvg(), TOLERANCE);
                assertEquals(expected.sum, stats.getSum(), TOLERANCE);
            valuesPerField,
        }, singleton(ft));
        final SimpleStatsAggregator expected = new SimpleStatsAggregator();
                assertEquals(expected.sum / expected.count, stats.getAvg(), TOLERANCE);
        verifySummationOfDoubles(largeValues, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, 0d);
                    expected.max + 1,
                assertEquals(expected.max, stats.getMax(), 0);
            try (IndexReader reader = indexWriter.getReader()) {
import java.util.function.Function;
        final MockScriptEngine engine = new MockScriptEngine(MockScriptEngine.NAME, scripts, emptyMap());
    public void testMissingUnmapped() throws IOException {
                }
import org.opensearch.script.ScriptEngine;
                    double value = randomDoubleBetween(-100d, 100d, true);
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
            assertEquals(values.length, stats.getCount());
            }
            final SimpleStatsAggregator expected = new SimpleStatsAggregator();
        randomLongsTestCase(valuesPerField, stats("_name").field("unknown_field").missing(missingValue), (expected, stats) -> {
            if (randomBoolean()) {
            }
    }
import static java.util.Collections.emptyMap;
                Document doc = new Document();
                }
                assertEquals(adjusted.sum, stats.getSum(), TOLERANCE);
        double expectedSum,
    }
            }
                final LeafDocLookup lookup = (LeafDocLookup) vars.get("doc");
        double expectedMin = min;
    @Override
                max = value;
            assertTrue(AggregationInspectionHelper.hasValue(stats));
    ) throws IOException {
import org.opensearch.index.mapper.MappedFieldType;
                assertEquals(expected.count, stats.getCount(), 0);
        final long missingValue = randomLongBetween(-100, 100);
                    expected.add(value);
                ? randomFrom(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
            assertEquals(Double.POSITIVE_INFINITY, stats.getMin(), 0);
        for (double value : values) {
        try (
        testCase(builder, iw -> iw.addDocuments(docs), stats -> verify.accept(expected, stats), singleton(ft));
                IndexSearcher searcher = new IndexSearcher(reader);
    }
        randomLongsTestCase(
                aggregator.postCollection();
 * software distributed under the License is distributed on an
                assertEquals(adjusted.sum / adjusted.count, stats.getAvg(), TOLERANCE);
            assertEquals(expectedMin, stats.getMin(), 0d);
                docs.add(singletonList(new NumericDocValuesField(ft.name(), NumericUtils.doubleToSortableLong(value))));
                IndexSearcher searcher = newIndexSearcher(reader);
        }, singleton(ft));
import org.opensearch.search.aggregations.AggregationBuilder;
    }
        final MappedFieldType ft = new NumberFieldMapper.NumberFieldType("field", NumberType.LONG);
    public void testRandomDoubles() throws IOException {
                assertEquals(expected.sum, stats.getSum(), TOLERANCE);
                final InternalStats stats = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, ft);
    }
import java.util.Map;
                indexWriter.addDocument(singleton(new SortedNumericDocValuesField(ft.name(), value)));
import org.opensearch.common.settings.Settings;
            assertTrue(AggregationInspectionHelper.hasValue(stats));
        );
            assertEquals(expected.sum, stats.getSum(), TOLERANCE);
        );
import java.util.function.Consumer;
import static java.util.stream.Collectors.toList;
 * license agreements. See the NOTICE file distributed with
        try (Directory directory = newDirectory(); RandomIndexWriter indexWriter = new RandomIndexWriter(random(), directory)) {
                aggregator.preCollection();
    }
        final int valuesPerField = randomIntBetween(1, 5);
                final SimpleStatsAggregator adjusted = new SimpleStatsAggregator(
        // Summing up some big double values and expect infinity result
        StatsAggregationBuilder builder,
    }
import org.opensearch.script.MockScriptEngine;
import org.opensearch.script.ScriptType;
    @Override
                assertEquals(adjusted.sum / adjusted.count, stats.getAvg(), TOLERANCE);
                docs.add(emptySet());
import java.util.function.BiConsumer;
            assertEquals(expected.max, stats.getMax(), 0);
            final SimpleStatsAggregator expected = new SimpleStatsAggregator();
        long count = 0;
            }
public class StatsAggregatorTests extends AggregatorTestCase {
    @Override
                assertEquals(adjusted.min, stats.getMin(), 0);
        verifySummationOfDoubles(largeValues, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d, 0d);
                final InternalStats stats = searchAndReduce(searcher, new MatchAllDocsQuery(), builder, fieldTypesArray);
    }
            } else {
                docs.add(singleton(new SortedNumericDocValuesField(ft.name(), value)));
                    expected.max + 1,
    }
                        createSearchContext(searcher, createIndexSettings(), new MatchAllDocsQuery(), null, fieldType)
import org.apache.lucene.index.MultiReader;
            assertEquals(Float.NaN, stats.getAvg(), 0);
            assertEquals(expectedMax, stats.getMax(), 0d);
            assertEquals(expected.sum / expected.count, stats.getAvg(), TOLERANCE);
            stats("_name").script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, FIELD_SCRIPT_NAME, singletonMap("field", "field"))),
    // TODO: Script tests, should fail with defaultValuesSourceType disabled.
        }
            assertEquals(expected.sum / expected.count, stats.getAvg(), TOLERANCE);
        values = new double[n];
            (expected, stats) -> {
import java.util.Arrays;
            List<Long> values = randomList(valuesPerField, valuesPerField, () -> randomLongBetween(-100, 100));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
                // Directly call collectRange on each leaf to test with size:0 queries
                assertEquals(adjusted.sum / adjusted.count, stats.getAvg(), TOLERANCE);
        BiConsumer<SimpleStatsAggregator, InternalStats> verify
import org.opensearch.index.mapper.NumberFieldMapper;
        }, stats -> {
        for (int i = 0; i < n; i++) {
                IndexReader unmappedReader = unmappedWriter.getReader();
            for (double value : values) {
    public void testEmpty() throws IOException {
import org.opensearch.script.ScriptService;
            sum += value;
            try (IndexReader reader = indexWriter.getReader()) {
            assertEquals(expected.max, stats.getMax(), 0);
                );
        testCase(stats("_name").field(ft.name()), iw -> {
    static class SimpleStatsAggregator {
        }
    public void testValueScriptMultiValuedField() throws IOException {
            assertEquals(expected.sum, stats.getSum(), TOLERANCE);
        final SimpleStatsAggregator expected = new SimpleStatsAggregator();
        Collection<MappedFieldType> fieldTypes
            assertEquals(0d, stats.getSum(), 0);
                    expected.count,
            }
        });
/*
                InternalStats stats = (InternalStats) aggregator.buildTopLevel();
                );
            for (int i = 0; i < numDocs; i++) {
        double expectedMax = max;
 * KIND, either express or implied.  See the License for the
                assertEquals(expected.count, stats.getCount(), 0);
            assertEquals(0d, stats.getSum(), 0);
            }
                assertTrue(factories.allFactoriesSupportIntraSegmentSearch());
                    doc.add(new SortedNumericDocValuesField(ft.name(), valueAsLong));
                : randomDoubleBetween(Double.MIN_VALUE, Double.MAX_VALUE, true);
        });
    public void testRandomLongs() throws IOException {
                expected.add(value);
                    );
    }
        }
            List<List<NumericDocValuesField>> docs = new ArrayList<>();
import org.opensearch.search.aggregations.LeafBucketCollector;
 * specific language governing permissions and limitations
            final StatsAggregationBuilder builder = stats("_name").field(ft.name());
            }
    public void testFieldScriptMultiValuedField() throws IOException {
        return new StatsAggregationBuilder("_name").field(fieldName);
