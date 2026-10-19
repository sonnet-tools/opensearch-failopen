            description.appendText("within ").appendValue(error * 100).appendText(" percent of ").appendValue(expected);  
        public static double calculateMAD(List<Long> sample) {
    ) throws IOException {
        testAggregation(new MatchAllDocsQuery(), writer -> {}, agg -> {
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), randomSample(size, point -> {
            final int halfway = (int) Math.ceil(sorted.length / 2d);  
        testAggregation(new FieldExistsQuery(FIELD_NAME), randomSample(size, point -> {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.AggregatorTestCase;
            for (int i = 0; i < 10; i++) {  
    // intentionally not writing any docs
    public void testNoMatchingField() throws IOException {
            FIELD_NAME
    private static final int SAMPLE_MAX = 1000000;
 * KIND, either express or implied.  See the License for the
        Function<Long, Iterable<T>> field
    private static final int SAMPLE_MIN = -1000000;
import java.util.stream.IntStream;  
            this.expected = expected;
            }
            FIELD_NAME  
import org.opensearch.script.ScriptEngine;  
        testAggregation(new FieldExistsQuery(FIELD_NAME), randomSample(size, point -> {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static java.util.Collections.singleton;
        testCase(aggregationBuilder, query, indexer, verify, fieldType);
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.function.Function;
        }, agg -> {
            final double deviation = Math.abs(actual - expected);
            return mad;  
        final int[] sample = IntStream.rangeClosed(1, 1000).toArray();
 */  
            assertEquals(0, agg.getMedianAbsoluteDeviation(), 0);
        }), agg -> {
        scripts.put(VALUE_SCRIPT, vars -> ((Number) vars.get("_value")).doubleValue() + 1);  
import org.opensearch.search.aggregations.support.ValuesSourceType;
    public void testValueScript() throws IOException {
        Map<String, ScriptEngine> engines = Collections.singletonMap(scriptEngine.getType(), scriptEngine);
import org.apache.lucene.search.Query;
import org.opensearch.script.MockScriptEngine;
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 1)));
        }, agg -> {  
            final double mad = calculateMedian(deviations);
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(FIELD_NAME, NumberFieldMapper.NumberType.LONG);  
        MockScriptEngine scriptEngine = new MockScriptEngine(MockScriptEngine.NAME, scripts, Collections.emptyMap());  
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 8)));  
import java.io.IOException;  
 * SPDX-License-Identifier: Apache-2.0
 */  
import org.opensearch.search.aggregations.support.AggregationInspectionHelper;  
public class MedianAbsoluteDeviationAggregatorTests extends AggregatorTestCase {
 * ownership. Elasticsearch licenses this file to you under  
                writer.addDocument(Arrays.asList(new IntPoint(FIELD_NAME, point), new SortedNumericDocValuesField(FIELD_NAME, point)));  
    public void testUnmappedMissing() throws IOException {
            final double median = calculateMedian(sample);
            assertEquals(Double.NaN, agg.getMedianAbsoluteDeviation(), 0);  
import java.util.Arrays;
import org.apache.lucene.tests.index.RandomIndexWriter;
        AggregationBuilder aggregationBuilder,
 * specific language governing permissions and limitations
            final double[] deviations = Arrays.stream(sample).map(point -> Math.abs(median - point)).toArray();  
import org.apache.lucene.document.NumericDocValuesField;
 *
    }  
        MappedFieldType fieldType  
            return singleton(new SortedNumericDocValuesField(FIELD_NAME, point));
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        @Override  
/*  
            return calculateMAD(Arrays.stream(sample).mapToDouble(point -> (double) point).toArray());
import org.apache.lucene.document.SortedNumericDocValuesField;  
        }, fieldType);
        private static double calculateMedian(double[] sample) {  
            assertThat(agg.getMedianAbsoluteDeviation(), equalTo(Double.NaN));
 * Unless required by applicable law or agreed to in writing,
    }  
            Arrays.sort(sorted);
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
    public static class IsCloseToRelative extends TypeSafeMatcher<Double> {
            final double median;
            return closeToRelative(expected, 0.25); // 0.25 = q(1-q) where q = quartile; for median, q = 0.5.
        }, agg -> {  
    /**  
    }
        testAggregation(aggregationBuilder, new MatchAllDocsQuery(), iw -> {
        MedianAbsoluteDeviationAggregationBuilder aggregationBuilder = new MedianAbsoluteDeviationAggregationBuilder("foo").script(  
            assertTrue(AggregationInspectionHelper.hasValue(agg));
        }, agg -> {
            assertThat(agg.getMedianAbsoluteDeviation(), closeToRelative(calculateMAD(sample)));  
import org.hamcrest.Description;  
        Consumer<InternalMedianAbsoluteDeviation> verify  
import org.apache.lucene.document.IntPoint;
        Query query,  
import org.opensearch.script.ScriptService;
        }), agg -> {
import org.opensearch.script.ScriptType;  
        return new ScriptService(Settings.EMPTY, engines, ScriptModule.CORE_CONTEXTS);  
/*  
    private void testAggregation(  
        private final double error;
        testAggregation(aggregationBuilder, new FieldExistsQuery(FIELD_NAME), iw -> {
    public static final String FIELD_NAME = "number";  
            return calculateMAD(sample.stream().mapToDouble(Long::doubleValue).toArray());  
        final int size = randomIntBetween(100, 1000);  
    ) {  
        testAggregation(IntPoint.newRangeQuery(FIELD_NAME, lowerRange, upperRange), writer -> {
    }
        }
     * aggregation. It's used to verify that the aggregation's approximate results are close enough to the exact result
import static org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregatorTests.ExactMedianAbsoluteDeviation.calculateMAD;
            .compression(randomDoubleBetween(20, 1000, true));  
        }, null);
            sample.add(point);  
        public IsCloseToRelative(double expected, double error) {
package org.opensearch.search.aggregations.metrics;
    public void testSingleScript() throws IOException {
            for (int point : sample) {
    public void testNoDocs() throws IOException {  
            writer.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 2)));
 *  
                final long point = randomLongBetween(SAMPLE_MIN, SAMPLE_MAX);
import org.opensearch.script.ScriptModule;
    }
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(FIELD_NAME, NumberFieldMapper.NumberType.LONG);
        }
        final List<Long> sample = new ArrayList<>(size);
            writer.addDocument(singleton(new SortedNumericDocValuesField("wrong_number", 1)));  
            this.error = error;  
        Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
import org.opensearch.index.mapper.NumberFieldMapper;  
    public static class ExactMedianAbsoluteDeviation {
    }  
        });
        });
        );  
 * The OpenSearch Contributors require contributions made to  
        }
        public static double calculateMAD(long[] sample) {
            FIELD_NAME
        });
            return observedError <= error;
    protected AggregationBuilder createAggBuilderForTypeTest(MappedFieldType fieldType, String fieldName) {
        );
    protected ScriptService getMockScriptService() {  
            assertTrue(AggregationInspectionHelper.hasValue(agg));
            assertFalse(AggregationInspectionHelper.hasValue(agg));
        CheckedConsumer<RandomIndexWriter, IOException> indexer,
            assertFalse(AggregationInspectionHelper.hasValue(agg));
        }, fieldType);  
            assertTrue(AggregationInspectionHelper.hasValue(agg));
        MedianAbsoluteDeviationAggregationBuilder aggregationBuilder = new MedianAbsoluteDeviationAggregationBuilder("foo").field(
            final double[] sorted = Arrays.copyOf(sample, sample.length);
import java.util.Collections;  
            assertFalse(AggregationInspectionHelper.hasValue(agg));
        CheckedConsumer<RandomIndexWriter, IOException> buildIndex,
        private final double expected;
    public void testUnmapped() throws IOException {  
    private static final String SINGLE_SCRIPT = "single";
    @Override
        }
            new Script(ScriptType.INLINE, MockScriptEngine.NAME, SINGLE_SCRIPT, Collections.emptyMap())
                median = (sorted[halfway - 1] + sorted[halfway]) / 2d;
 * Modifications Copyright OpenSearch Contributors. See
     * This class is an implementation of median absolute deviation that computes an exact value, rather than the approximation used in the
            assertThat(agg.getMedianAbsoluteDeviation(), closeToRelative(calculateMAD(filteredSample)));  
        ).script(new Script(ScriptType.INLINE, MockScriptEngine.NAME, VALUE_SCRIPT, Collections.emptyMap()));
 * software distributed under the License is distributed on an
                median = (sorted[halfway - 1]);
            final double observedError = deviation / Math.abs(expected);  
            for (int i = 0; i < size; i++) {  
import java.util.HashMap;
/*
 */
    }
        final int size = randomIntBetween(100, 1000);  
        @Override
            }
            }
        Consumer<InternalMedianAbsoluteDeviation> verify,
        final int[] filteredSample = Arrays.stream(sample).filter(point -> point >= lowerRange && point <= upperRange).toArray();  
 * You may obtain a copy of the License at  
        Query query,
        scripts.put(SINGLE_SCRIPT, vars -> 1);
            assertThat(agg.getMedianAbsoluteDeviation(), closeToRelative(calculateMAD(sample)));  
        }, null);
        testAggregation(new MatchAllDocsQuery(), writer -> {
        final int upperRange = 500;
    }
            if (sorted.length % 2 == 0) {
            }
            assertThat(agg.getMedianAbsoluteDeviation(), closeToRelative(calculateMAD(sample)));  
        });  
 * under the License.  
        public static IsCloseToRelative closeToRelative(double expected, double error) {  
        public static double calculateMAD(int[] sample) {  
            assertEquals(0, agg.getMedianAbsoluteDeviation(), 0);  
 * not use this file except in compliance with the License.
            assertThat(agg.getMedianAbsoluteDeviation(), equalTo(Double.NaN));
import java.util.List;
    private void testAggregation(
 * Licensed to Elasticsearch under one or more contributor  
    }
 * compatible open source license.
                writer.addDocument(document);  
import static org.opensearch.search.aggregations.metrics.MedianAbsoluteDeviationAggregatorTests.IsCloseToRelative.closeToRelative;
import org.apache.lucene.search.FieldExistsQuery;
            assertFalse(AggregationInspectionHelper.hasValue(agg));  
import java.util.ArrayList;
        }
        final int size = randomIntBetween(100, 1000);  
    }  
        final List<Long> sample = new ArrayList<>(size);
        ).missing(1234);
    public void testQueryFiltering() throws IOException {
        public static double calculateMAD(double[] sample) {  
import static java.util.Collections.singletonList;  
            return calculateMAD(Arrays.stream(sample).mapToDouble(point -> (double) point).toArray());
            assertTrue(AggregationInspectionHelper.hasValue(agg));
        }
    }  
    }
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
            iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, 7)));  
        testAggregation(builder, query, buildIndex, verify, fieldType);
        final int lowerRange = 1;  
            writer.addDocument(Arrays.asList(new IntPoint(FIELD_NAME, 1), new SortedNumericDocValuesField(FIELD_NAME, 1)));
        };
            assertThat(agg.getMedianAbsoluteDeviation(), equalTo(Double.NaN));  
        });
    private static <T extends IndexableField> CheckedConsumer<RandomIndexWriter, IOException> randomSample(  
    ) throws IOException {
    @Override  
    /** Script to return the {@code _value} provided by aggs framework. */
 * this file be licensed under the Apache-2.0 license or a
import java.util.function.Consumer;
    public void testQueryFiltersAll() throws IOException {
        final List<Long> sample = new ArrayList<>(size);
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 7)));
            writer.addDocument(Arrays.asList(new IntPoint(FIELD_NAME, 2), new SortedNumericDocValuesField(FIELD_NAME, 2)));
            return singleton(new SortedNumericDocValuesField(FIELD_NAME, point));
        return writer -> {
            sample.add(point);  
    private static final String VALUE_SCRIPT = "_value";  
        MedianAbsoluteDeviationAggregationBuilder aggregationBuilder = new MedianAbsoluteDeviationAggregationBuilder("foo").field(  
            iw.addDocument(singleton(new NumericDocValuesField("unrelatedField", 9)));
            } else {
        }, agg -> {
import org.apache.lucene.index.IndexableField;
            assertTrue(AggregationInspectionHelper.hasValue(agg));
 * GitHub history for details.
    @Override
import org.opensearch.common.CheckedConsumer;  
     */  
    public void testSomeMatchesNumericDocValues() throws IOException {
import org.opensearch.search.aggregations.AggregationBuilder;
        MedianAbsoluteDeviationAggregationBuilder aggregationBuilder = new MedianAbsoluteDeviationAggregationBuilder("foo").field(
        }, agg -> {
        }), agg -> {
        return new MedianAbsoluteDeviationAggregationBuilder("foo").field(fieldName);
            return new IsCloseToRelative(expected, error);
            assertTrue(AggregationInspectionHelper.hasValue(agg));
import org.apache.lucene.search.MatchAllDocsQuery;  
    protected List<ValuesSourceType> getSupportedValuesSourceTypes() {
    }
        MedianAbsoluteDeviationAggregationBuilder builder = new MedianAbsoluteDeviationAggregationBuilder("mad").field(FIELD_NAME)
                // odd  
    }  
        int size,
            sample.add(point);  
    }  
import org.hamcrest.TypeSafeMatcher;
        }  
    }  
                Iterable<T> document = field.apply(point);
        final List<Long> sample = new ArrayList<>(size);
}
        protected boolean matchesSafely(Double actual) {
        }
import static org.hamcrest.Matchers.equalTo;  
        }  
        return singletonList(CoreValuesSourceType.NUMERIC);  
                // even  
import org.opensearch.common.settings.Settings;
            return singleton(new NumericDocValuesField(FIELD_NAME, point));
import org.opensearch.script.Script;
    }  
                iw.addDocument(singleton(new NumericDocValuesField(FIELD_NAME, i + 1)));
        testAggregation(IntPoint.newRangeQuery(FIELD_NAME, -1, 0), writer -> {  
            return median;  
        final int size = randomIntBetween(100, 1000);  
        });
    public void testSomeMatchesSortedNumericDocValues() throws IOException {
    }  
 *
        public void describeTo(Description description) {
import org.opensearch.index.mapper.MappedFieldType;
        MappedFieldType fieldType = new NumberFieldMapper.NumberFieldType(FIELD_NAME, NumberFieldMapper.NumberType.LONG);
import java.util.Map;  
        public static IsCloseToRelative closeToRelative(double expected) {
