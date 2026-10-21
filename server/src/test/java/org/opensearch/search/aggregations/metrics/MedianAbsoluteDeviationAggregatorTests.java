                // even
            assertTrue(AggregationInspectionHelper.hasValue(agg));
import static org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregatorTests.ExactMedianAbsoluteDeviation.calculateMAD;
        scripts.put(VALUE_SCRIPT, vars -> ((Number) vars.get("_value")).doubleValue() + 1);
        }, null);
    public void testQueryFiltering() throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
        int size,
        );
import org.opensearch.script.ScriptService;
        final int lowerRange = 1;
        Query query,
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
    ) {
import org.opensearch.index.mapper.MappedFieldType;
        testAggregation(IntPoint.newRangeQuery(FIELD_NAME, lowerRange, upperRange), writer -> {
            assertThat(agg.getMedianAbsoluteDeviation(), equalTo(Double.NaN));
 * not use this file except in compliance with the License.
                median = (sorted[halfway - 1]);
    // intentionally not writing any docs
import org.opensearch.script.Script;
    private static final String SINGLE_SCRIPT = "single";
        public IsCloseToRelative(double expected, double error) {
        final int size = randomIntBetween(100, 1000);
    private static <T extends IndexableField> CheckedConsumer<RandomIndexWriter, IOException> randomSample(
        final List<Long> sample = new ArrayList<>(size);
        );
    }
import java.util.HashMap;
    }
    @Override
            }
import java.io.IOException;
        }, agg -> {
            assertTrue(AggregationInspectionHelper.hasValue(agg));
        MedianAbsoluteDeviationAggregationBuilder aggregationBuilder = new MedianAbsoluteDeviationAggregationBuilder("foo").field(
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
 * compatible open source license.
 * You may obtain a copy of the License at
            return calculateMAD(Arrays.stream(sample).mapToDouble(point -> (double) point).toArray());
 */
            return new IsCloseToRelative(expected, error);
                iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, i + 1)));
import java.util.List;
            assertFalse(AggregationInspectionHelper.hasValue(agg));
            writer.addDocument(Arrays.asList(new IntPoint(FIELD_NAME, 1), new SortedNumericDocValuesField(FIELD_NAME, 1)));
 * The OpenSearch Contributors require contributions made to
    }
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SINGLE_SCRIPT, Collections.emptyMap())
        }
    }
        public static double calculateMAD(double[] sample) {
                Iterable<T> document = field.apply(point);
        }
            final double median;
                // odd
 * specific language governing permissions and limitations
import java.util.Arrays;
            FIELD_NAME
        final int size = randomIntBetween(100, 1000);
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 8)));
        Consumer<InternalMedianAbsoluteDeviation> verify,
    public void testNoDocs() throws IOException {
            } else {
        final List<Long> sample = new ArrayList<>(size);
    ) throws IOException {
        Query query,
import org.opensearch.common.settings.Settings;
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 7)));
        return singletonList(CoreValuesSourceType.NUMERIC);
     */
import static java.util.Collections.singleton;
            Arrays.sort(sorted);
        final int size = randomIntBetween(100, 1000);
import static org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregatorTests.IsCloseToRelative.closeToRelative;
        });
        MedianAbsoluteDeviationAggregationBuilder aggregationBuilder = new MedianAbsoluteDeviationAggregationBuilder("foo").field(
        }), agg -> {
            assertThat(agg.getMedianAbsoluteDeviation(), equalTo(Double.NaN));
        testAggregation(new FieldExistsQuery(FIELD_NAME), randomSample(size, point -> {
            assertTrue(AggregationInspectionHelper.hasValue(agg));
        }
        final int[] sample = IntStream.rangeClosed(1, 1000).toArray();
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
            assertFalse(AggregationInspectionHelper.hasValue(agg));
        }, agg -> {
    }
        });
            final double observedError = deviation / Math.abs(expected);
            return singleton(new SortedNumericDocValuesField(FIELD_NAME, point));
            return median;
    }
        }), agg -> {
import static org.hamcrest.Matchers.equalTo;
            writer.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 1)));
            return singleton(new NumericDocValuesField(FIELD_NAME, point));
import org.opensearch.script.ScriptEngine;
            assertEquals(0, agg.getMedianAbsoluteDeviation(), 0);
        testAggregation(IntPoint.newRangeQuery(FIELD_NAME, -1, 0), writer -> {
    }
            writer.addDocument(Arrays.asList(new IntPoint(FIELD_NAME, 2), new SortedNumericDocValuesField(FIELD_NAME, 2)));
        testAggregation(new MatchAllDocsQuery(), writer -> {}, agg -> {
 * Licensed to Elasticsearch under one or more contributor
    public void testUnmapped() throws IOException {
    }
    public static class IsCloseToRelative extends TypeSafeMatcher<Double> {
        }, fieldType);
            FIELD_NAME
                final long point = randomLongBetween(SAMPLE_MIN, SAMPLE_MAX);
        testAggregation(builder, query, buildIndex, verify, fieldType);
        public static double calculateMAD(List<Long> sample) {
/*
    }
    /**
    private void testAggregation(
        }
        }, agg -> {
    public void testSomeMatchesSortedNumericDocValues() throws IOException {
    }
        public static IsCloseToRelative closeToRelative(double expected, double error) {
}
        });
            assertFalse(AggregationInspectionHelper.hasValue(agg));
import static java.util.Collections.singletonList;
 * SPDX-License-Identifier: Apache-2.0
    }
 * GitHub history for details.
import org.apache.lucene.document.NumericDocValuesField;
import org.apache.lucene.index.IndexableField;
import org.opensearch.script.MockScriptEngine;
import java.util.stream.IntStream;
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
        public static double calculateMAD(int[] sample) {
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        };
    /** Script to return the {@code _value} provided by aggs framework. */
    }
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(FIELD_NAME, NumberFieldMapper.NumberType.LONG);
    private static final int SAMPLE_MIN = -1000000;
package org.opensearch.search.aggregations.metrics;
import org.apache.lucene.tests.index.RandomIndexWriter;
import org.hamcrest.TypeSafeMatcher;
        private static double calculateMedian(double[] sample) {
        ).script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.emptyMap()));
 * Modifications Copyright OpenSearch Contributors. See
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 7)));
            this.error = error;
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;
import org.opensearch.index.mapper.NumberFieldMapper;
        }
import java.util.Collections;
        });
        });
            assertThat(agg.getMedianAbsoluteDeviation(), equalTo(Double.NaN));
     * aggregation. It's used to verify that the aggregation's approximate results are close enough to the exact result
        Consumer<InternalMedianAbsoluteDeviation> verify
    @Override
            sample.add(point);
    public void testSingleScript() throws IOException {
    ) throws IOException {
    }
        public void describeTo(Description description) {
        }), agg -> {
        testAggregation(new MatchAllDocsQuery(), writer -> {
                writer.addDocument(document);
        final List<Long> sample = new ArrayList<>(size);
 *
            return mad;
        }, agg -> {
 * under the License.
        public static IsCloseToRelative closeToRelative(double expected) {
        }
            assertThat(agg.getMedianAbsoluteDeviation(), closeToRelative(calculateMAD(sample)));
    protected ScriptService getMockScriptService() {
            }
        private final double expected;
import org.opensearch.script.ScriptModule;
import org.opensearch.search.aggregations.support.ValuesSourceType;
 *
 * KIND, either express or implied.  See the License for the
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), randomSample(size, point -> {
        }
            return singleton(new SortedNumericDocValuesField(FIELD_NAME, point));
            return observedError <= error;
import java.util.function.Consumer;
            assertFalse(AggregationInspectionHelper.hasValue(agg));
    @Override
    }
        }, null);
            .compression(randomDoubleBetween(20, 1000, true));
 */
        @Override
        testAggregation(new FieldExistsQuery(FIELD_NAME), randomSample(size, point -> {
import org.apache.lucene.search.Query;
    }
            final double[] deviations = Arrays.stream(sample).map(point -> Math.abs(median - point)).toArray();
        }, fieldType);
    }
        protected boolean matchesSafely(Double actual) {
public class MedianAbsoluteDeviationAggregatorTests extends AggregatorTestCase {
            for (int point : sample) {
        MedianAbsoluteDeviationAggregationBuilder aggregationBuilder = new MedianAbsoluteDeviationAggregationBuilder("foo").script(
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 9)));
            return closeToRelative(expected, 0.25); // 0.25 = q(1-q) where q = quartile; for median, q = 0.5.
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(FIELD_NAME, NumberFieldMapper.NumberType.LONG);
import org.apache.lucene.search.MatchAllDocsQuery;
 * Unless required by applicable law or agreed to in writing,
    }
        }, agg -> {
            final double median = calculateMedian(sample);
    public void testNoMatchingField() throws IOException {
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
import org.apache.lucene.search.FieldExistsQuery;
        MedianAbsoluteDeviationAggregationBuilder aggregationBuilder = new MedianAbsoluteDeviationAggregationBuilder("foo").field(
 * the Apache License, Version 2.0 (the "License"); you may
        private final double error;
            return calculateMAD(Arrays.stream(sample).mapToDouble(point -> (double) point).toArray());
        AggregationBuilder aggregationBuilder,
            final double mad = calculateMedian(deviations);
            this.expected = expected;
     * This class is an implementation of median absolute deviation that computes an exact value, rather than the approximation used in the
        }
        }
            assertEquals(Double.NaN, agg.getMedianAbsoluteDeviation(), 0);
    public void testUnmappedMissing() throws IOException {
            }
    public void testSomeMatchesNumericDocValues() throws IOException {
            return calculateMAD(sample.stream().mapToDouble(Long::doubleValue).toArray());
        final int[] filteredSample = Arrays.stream(sample).filter(point -> point >= lowerRange && point <= upperRange).toArray();
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
 * software distributed under the License is distributed on an
            sample.add(point);
import org.opensearch.script.ScriptType;
            assertTrue(AggregationInspectionHelper.hasValue(agg));
            assertThat(agg.getMedianAbsoluteDeviation(), closeToRelative(calculateMAD(sample)));
            if (sorted.length % 2 == 0) {
            final int halfway = (int) Math.ceil(sorted.length / 2d);
    public void testQueryFiltersAll() throws IOException {
            writer.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 2)));
            assertThat(agg.getMedianAbsoluteDeviation(), closeToRelative(calculateMAD(filteredSample)));
        });
        final int upperRange = 500;
import org.opensearch.search.aggregations.AggregationBuilder;
        testCase(aggregationBuilder, query, indexer, verify, fieldType);
            assertTrue(AggregationInspectionHelper.hasValue(agg));
 * ownership. Elasticsearch licenses this file to you under
            assertThat(agg.getMedianAbsoluteDeviation(), closeToRelative(calculateMAD(sample)));
                median = (sorted[halfway - 1] + sorted[halfway]) / 2d;
        MappedFieldType fieldType
import org.opensearch.search.aggregations.AggregatorTestCase;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
        MedianAbsoluteDeviationAggregationBuilder builder = new MedianAbsoluteDeviationAggregationBuilder("mad").field(FIELD_NAME)
        Function<Long, Iterable<T>> field
        MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, scripts, Collections.emptyMap());
            for (int i = 0; i < size; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        public static double calculateMAD(long[] sample) {
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);
            description.appendText("within ").appendValue(error * 100).appendText(" percent of ").appendValue(expected);
        return new MedianAbsoluteDeviationAggregationBuilder("foo").field(fieldName);
import java.util.function.Function;
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
        testAggregation(aggregationBuilder, new FieldExistsQuery(FIELD_NAME), iw -> {
            for (int i = 0; i < 10; i++) {
        ).missing(1234);
        CheckedConsumer<RandomIndexWriter, IOException> indexer,
            sample.add(point);
    public void testValueScript() throws IOException {
        final List<Long> sample = new ArrayList<>(size);
    private static final String VALUE_SCRIPT = "_value";
    private static final int SAMPLE_MAX = 1000000;
import org.apache.lucene.document.SortedNumericDocValuesField;
            assertEquals(0, agg.getMedianAbsoluteDeviation(), 0);
            FIELD_NAME
            final double deviation = Math.abs(actual - expected);
        scripts.put(SINGLE_SCRIPT, vars -> 1);
    public static final String FIELD_NAME = "number";
/*
    public static class ExactMedianAbsoluteDeviation {
            final double[] sorted = Arrays.copyOf(sample, sample.length);
            assertTrue(AggregationInspectionHelper.hasValue(agg));
 * this work for additional information regarding copyright
        return writer -> {
        }
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(FIELD_NAME, NumberFieldMapper.NumberType.LONG);
        final int size = randomIntBetween(100, 1000);
    }
    private void testAggregation(
import org.apache.lucene.document.IntPoint;
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.CheckedConsumer;
 *
        @Override
        }, agg -> {
                writer.addDocument(Arrays.asList(new IntPoint(FIELD_NAME, point), new SortedNumericDocValuesField(FIELD_NAME, point)));
 */
            }
import java.util.ArrayList;
import org.hamcrest.Description;
