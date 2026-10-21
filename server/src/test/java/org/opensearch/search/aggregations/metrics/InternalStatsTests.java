                + "\",\n"
 *
        for (double value : values) {
import java.io.IOException;
        InternalStats internalStats = new InternalStats("dummy2", 0, 0.0, 2.0, 0.0, null, null);
        double sum = 0;
        Map<String, Object> metadata = instance.getMetadata();
        double max,
        double max = randomDoubleBetween(-1000000, 1000000, true);
            + count
        assertEquals(expected, builder.toString());
        assertEquals(expectedCount, reduced.getCount());
        String name,
                + "\",\n"
    }
import org.opensearch.core.xcontent.XContentBuilder;
        assertEquals("dummy2", reduced.getName());
        double expectedMin = Double.POSITIVE_INFINITY;
        );
import org.opensearch.core.xcontent.ToXContent;
        assertEquals(expectedSum, reduced.getSum(), delta);
        switch (between(0, 5)) {
    @Override
import org.opensearch.search.aggregations.InternalAggregation;
            case 4:
                if (Double.isFinite(sum)) {
        double min = randomDoubleBetween(-1000000, 1000000, true);
        DocValueFormat formatter = instance.format;
                metadata.put(randomAlphaOfLength(15), randomInt());
                }
        builder.startObject();
        InternalStats internalStats = createInstance("stats", count, sum, min, max, format, null);
            + max
            case 3:
                    sum = between(1, 100);
            if (Double.compare(stats.getMax(), expectedMax) > 0) {
 * this work for additional information regarding copyright
                break;
                if (Double.isFinite(max)) {
import org.opensearch.search.DocValueFormat;
        assertStats(aggregation, parsed);
            case 2:
                } else {
 * not use this file except in compliance with the License.
                    min += between(1, 100);
        // count is greater than zero
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(expectedSum, reduced.getSum(), 1e-7);
                    metadata = new HashMap<>(instance.getMetadata());
            }
        assertEquals(
        double sum = instance.getSum();
    }
            sum += values[i];
        min = 0.0;
                expectedMin = stats.getMin();
        double min = randomDoubleBetween(-1000000, 1000000, true);
        builder.startObject();
            + ",\n"
        double sum,
        assertEquals(count > 0 ? aggregation.getSum() : 0, parsed.getSum(), 0);
                if (Double.isFinite(min)) {
        }
    }
                + "}",
        values = new double[n];
                + format.format(internalStats.getMax())
                + "  \"sum_as_string\" : \""
    }
            + ",\n"
        double expectedSum = 0;
        InternalStats reduced = internalStats.reduce(aggregations, null);
        internalStats.doXContentBody(builder, ToXContent.EMPTY_PARAMS);
        long count = aggregation.getCount();
 * You may obtain a copy of the License at
        // for count == 0, fields are rendered as `null`, so we test that we parse to default values used also in the reduce phase
            case 0:
                    metadata = new HashMap<>(1);
 *
        double min,
                + format.format(internalStats.getAvg())
        assertEquals(count, parsed.getCount());
            + "  \"avg\" : "
                + "  \"avg\" : null,\n"
        max = 0.0;
                break;
                    max += between(1, 100);
                + "  \"sum\" : 0.0\n"
            assertEquals(aggregation.getMaxAsString(), parsed.getMaxAsString());
        builder = JsonXContent.contentBuilder().prettyPrint();
    public void testSummationAccuracy() {
                } else {
                + "\",\n"
public class InternalStatsTests extends InternalAggregationTestCase<InternalStats> {
 * under the License.
        for (int i = 0; i < n; i++) {
    public void testDoXContentBody() throws IOException {
        String name = instance.getName();
            max = Math.max(max, value);
 * GitHub history for details.
    }
 * specific language governing permissions and limitations
            + sum;
        for (int i = 0; i < n; i++) {
 */
        Map<String, Object> metadata
            + ",\n"
        double max = Double.NEGATIVE_INFINITY;
        }
                }
                expectedMax = stats.getMax();
            + "  \"max\" : "
    protected InternalStats createInstance(
        double expectedMax = Double.NEGATIVE_INFINITY;
 *
            + "  \"count\" : "
        assertEquals(count > 0 ? aggregation.getAvg() : 0, parsed.getAvg(), 0);
                + "  \"count\" : 0,\n"
                + "\"";
        builder.endObject();
                + "  \"max\" : null,\n"
        long count = instance.getCount();
            if (Double.compare(stats.getMin(), expectedMin) < 0) {
        assertEquals(values.length, reduced.getCount());
 * The OpenSearch Contributors require contributions made to
                + "  \"max_as_string\" : \""
        }
 */
                    min = between(1, 100);
 * ownership. Elasticsearch licenses this file to you under
        if (count > 0) {
            largeValues[i] = -Double.MAX_VALUE;
            + internalStats.getAvg()
        verifyStatsOfDoubles(values, 13.5, 0.9, 0d);
    }
        verifyStatsOfDoubles(largeValues, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d);
/*
        return createInstance(name, count, sum, min, max, format, metadata);
            expectedCount += stats.getCount();
        DocValueFormat format = randomNumericDocValueFormat();
        int n = randomIntBetween(5, 10);
            }
        double max = instance.getMax();
        n = randomIntBetween(5, 10);
        }
 * software distributed under the License is distributed on an
        ParsedStats parsed = (ParsedStats) parsedAggregation;
        return new InternalStats(name, count, sum, min, max, formatter, metadata);
import java.util.HashMap;
        List<InternalAggregation> aggregations = new ArrayList<>(values.length);
        assertTrue(parsedAggregation instanceof ParsedStats);
            + min
                break;
                } else {
                    sum += between(1, 100);
        String expected = "{\n"
    ) {
                } else {
            expectedSum += stats.getSum();
 * KIND, either express or implied.  See the License for the
            expected += ",\n"
            assertEquals(aggregation.getAvgAsString(), parsed.getAvgAsString());
        DocValueFormat formatter,
                    count = between(1, 100);
            case 5:
        internalStats = createInstance("stats", count, sum, min, max, format, null);
import org.opensearch.test.InternalAggregationTestCase;
import java.util.ArrayList;
        double min = Double.POSITIVE_INFINITY;
                : randomDoubleBetween(Double.MIN_VALUE, Double.MAX_VALUE, true);
    protected void assertReduced(InternalStats reduced, List<InternalStats> inputs) {
/*
        assertEquals(expectedMin, reduced.getMin(), 0d);
 * compatible open source license.
                    count += between(1, 100);
                name += randomAlphaOfLength(5);
        count = 0;
    private void verifyStatsOfDoubles(double[] values, double expectedSum, double expectedAvg, double delta) {
import org.opensearch.common.xcontent.json.JsonXContent;
        double sum = randomDoubleBetween(-1000000, 1000000, true);
                + "  \"min\" : null,\n"
    }
        expected += "\n}";
            values[i] = frequently()
        }
    protected void assertFromXContent(InternalStats aggregation, ParsedAggregation parsedAggregation) {
        return new InternalStats(name, count, sum, min, max, formatter, metadata);
        }
                    max = between(1, 100);
                break;
    protected InternalStats mutateInstance(InternalStats instance) {
    @Override
        // also as_string values are only rendered for count != 0
 * SPDX-License-Identifier: Apache-2.0
            aggregations.add(new InternalStats("dummy1", 1, value, value, value, null, null));
        verifyStatsOfDoubles(largeValues, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d);
            + "  \"min\" : "
 * Unless required by applicable law or agreed to in writing,
            + "  \"sum\" : "
 * license agreements. See the NOTICE file distributed with
        assertEquals(count > 0 ? aggregation.getMin() : Double.POSITIVE_INFINITY, parsed.getMin(), 0);
import java.util.Map;
        double min = instance.getMin();
        sum = 0.0;
        internalStats.doXContentBody(builder, ToXContent.EMPTY_PARAMS);
    protected InternalStats createTestInstance(String name, Map<String, Object> metadata) {
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.9, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7 };
                + format.format(internalStats.getMin())
        long expectedCount = 0;
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
        }
            default:
package org.opensearch.search.aggregations.metrics;
        for (int i = 0; i < n; i++) {
        verifyStatsOfDoubles(values, sum, sum / n, TOLERANCE);
        // count is zero
            min = Math.min(min, value);
import org.opensearch.search.aggregations.ParsedAggregation;
                }
        // Summing up some big double values and expect infinity result
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        if (format != DocValueFormat.RAW) {
            case 1:
                } else {
        double[] largeValues = new double[n];
        int count = randomIntBetween(1, 10);
import java.util.List;
        assertEquals(max, reduced.getMax(), 0d);
                throw new AssertionError("Illegal randomisation branch");
                + "  \"min_as_string\" : \""
    @Override
            + ",\n"
        assertEquals(count > 0 ? aggregation.getMax() : Double.NEGATIVE_INFINITY, parsed.getMax(), 0);
    }
        format = randomNumericDocValueFormat();
            builder.toString()
    }
 * the Apache License, Version 2.0 (the "License"); you may
        builder.endObject();
                ? randomFrom(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)
            assertEquals(aggregation.getMinAsString(), parsed.getMinAsString());
                break;
        for (InternalStats stats : inputs) {
}
                break;
        assertEquals(expectedAvg, reduced.getAvg(), delta);
            "{\n"
 * Licensed to Elasticsearch under one or more contributor
    static void assertStats(InternalStats aggregation, ParsedStats parsed) {
                if (Double.isFinite(count)) {
                if (metadata == null) {
        long count,
        long count = frequently() ? randomIntBetween(1, Integer.MAX_VALUE) : 0;
        double max = randomDoubleBetween(-1000000, 1000000, true);
        DocValueFormat format = randomNumericDocValueFormat();
        assertEquals(expectedMax, reduced.getMax(), 0d);
                }
            assertEquals(aggregation.getSumAsString(), parsed.getSumAsString());
 * Modifications Copyright OpenSearch Contributors. See
 */
                }
        assertEquals(min, reduced.getMin(), 0d);
                + "  \"avg_as_string\" : \""
                + format.format(internalStats.getSum())
            largeValues[i] = Double.MAX_VALUE;
    @Override
        double sum = randomDoubleBetween(-1000000, 1000000, true);
 * this file be licensed under the Apache-2.0 license or a
/*
