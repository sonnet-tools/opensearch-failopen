package org.opensearch.search.aggregations.metrics;
        int n = randomIntBetween(5, 10);
        assertEquals(expected, builder.toString());  
        double min = randomDoubleBetween(-1000000, 1000000, true);
            }  
                break;
        verifyStatsOfDoubles(largeValues, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d);  
        count = 0;
    protected InternalStats mutateInstance(InternalStats instance) {
                + format.format(internalStats.getAvg())
    protected InternalStats createInstance(
                    count += between(1, 100);  
        }
import org.opensearch.search.aggregations.InternalAggregation;
                break;  
 * Licensed to Elasticsearch under one or more contributor  
        long count,
                if (Double.isFinite(sum)) {  
        assertEquals(expectedCount, reduced.getCount());  
        switch (between(0, 5)) {  
        for (int i = 0; i < n; i++) {  
        ParsedStats parsed = (ParsedStats) parsedAggregation;  
 * this work for additional information regarding copyright
        }
            + "  \"count\" : "  
        }  
    }  
        DocValueFormat formatter,
        InternalStats reduced = internalStats.reduce(aggregations, null);  
        assertEquals(expectedMax, reduced.getMax(), 0d);  
                + "  \"max\" : null,\n"  
        verifyStatsOfDoubles(largeValues, Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY, 0d);
    protected void assertReduced(InternalStats reduced, List<InternalStats> inputs) {  
        long count = instance.getCount();  
        for (int i = 0; i < n; i++) {
        InternalStats internalStats = new InternalStats("dummy2", 0, 0.0, 2.0, 0.0, null, null);
        int count = randomIntBetween(1, 10);  
            + ",\n"
 * The OpenSearch Contributors require contributions made to  
        }  
    @Override
        assertEquals(max, reduced.getMax(), 0d);  
 * under the License.  
                } else {
                + format.format(internalStats.getMin())
                + "  \"sum_as_string\" : \""
import java.io.IOException;
    }
                + "  \"count\" : 0,\n"
    }
        assertEquals(min, reduced.getMin(), 0d);
    static void assertStats(InternalStats aggregation, ParsedStats parsed) {
            + ",\n"
        }
    private void verifyStatsOfDoubles(double[] values, double expectedSum, double expectedAvg, double delta) {
        min = 0.0;
                } else {
        internalStats.doXContentBody(builder, ToXContent.EMPTY_PARAMS);
                ? randomFrom(Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY)  
        // count is greater than zero
                if (Double.isFinite(min)) {
 *
 * license agreements. See the NOTICE file distributed with
        double sum = instance.getSum();
import java.util.HashMap;
            + "  \"max\" : "  
    public void testDoXContentBody() throws IOException {
    }  
        String name,  
        double[] values = new double[] { 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.9, 1.1, 1.2, 1.3, 1.4, 1.5, 1.6, 1.7 };
        for (int i = 0; i < n; i++) {
            sum += values[i];
/*
                if (Double.isFinite(max)) {
                    min += between(1, 100);
 */
        long count = frequently() ? randomIntBetween(1, Integer.MAX_VALUE) : 0;  
            largeValues[i] = -Double.MAX_VALUE;  
                break;  
            + min
        assertEquals(count > 0 ? aggregation.getSum() : 0, parsed.getSum(), 0);
    protected void assertFromXContent(InternalStats aggregation, ParsedAggregation parsedAggregation) {
 * the Apache License, Version 2.0 (the "License"); you may
            case 4:
            largeValues[i] = Double.MAX_VALUE;
 * SPDX-License-Identifier: Apache-2.0
                }  
                } else {
        assertEquals(expectedAvg, reduced.getAvg(), delta);
        String expected = "{\n"
        sum = 0.0;  
                metadata.put(randomAlphaOfLength(15), randomInt());
        }
                + "  \"avg\" : null,\n"
            + max
            expected += ",\n"  
 * Unless required by applicable law or agreed to in writing,
                expectedMax = stats.getMax();
        double max = instance.getMax();  
                    sum += between(1, 100);
        assertTrue(parsedAggregation instanceof ParsedStats);
        InternalStats internalStats = createInstance("stats", count, sum, min, max, format, null);
                + "\"";  
        long expectedCount = 0;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                + format.format(internalStats.getSum())
        for (InternalStats stats : inputs) {
                    metadata = new HashMap<>(instance.getMetadata());  
 */  
            assertEquals(aggregation.getMaxAsString(), parsed.getMaxAsString());  
        assertEquals(expectedSum, reduced.getSum(), 1e-7);
                }  
                if (metadata == null) {  
            expectedCount += stats.getCount();  
    protected InternalStats createTestInstance(String name, Map<String, Object> metadata) {
        double[] largeValues = new double[n];
        expected += "\n}";
    @Override
        internalStats = createInstance("stats", count, sum, min, max, format, null);
                break;
 * specific language governing permissions and limitations
                } else {
    }
                + format.format(internalStats.getMax())
 * GitHub history for details.
            + internalStats.getAvg()
            max = Math.max(max, value);
            + sum;
            "{\n"  
            case 3:  
import java.util.List;
 * Modifications Copyright OpenSearch Contributors. See  
            expectedSum += stats.getSum();
        assertEquals(count > 0 ? aggregation.getAvg() : 0, parsed.getAvg(), 0);
                if (Double.isFinite(count)) {
import java.util.Map;  
 * You may obtain a copy of the License at  
                }
 * this file be licensed under the Apache-2.0 license or a
                    metadata = new HashMap<>(1);
        // Summing up some big double values and expect infinity result  
            }  
                + "  \"min_as_string\" : \""
import org.opensearch.core.xcontent.ToXContent;
    @Override  
        double expectedMax = Double.NEGATIVE_INFINITY;
 * not use this file except in compliance with the License.
            if (Double.compare(stats.getMax(), expectedMax) > 0) {
        double sum = 0;  
        builder = JsonXContent.contentBuilder().prettyPrint();  
        double min,  
                    max += between(1, 100);  
        for (double value : values) {  
import org.opensearch.common.xcontent.json.JsonXContent;  
            if (Double.compare(stats.getMin(), expectedMin) < 0) {
        double max = Double.NEGATIVE_INFINITY;
        values = new double[n];
            + "  \"avg\" : "  
        List<InternalAggregation> aggregations = new ArrayList<>(values.length);  
                name += randomAlphaOfLength(5);
            + ",\n"
        if (format != DocValueFormat.RAW) {
                } else {  
    ) {
        double max,
                + "\",\n"  
            case 1:
 * ownership. Elasticsearch licenses this file to you under  
                + "}",  
        if (count > 0) {
        // also as_string values are only rendered for count != 0  
/*  
import org.opensearch.search.aggregations.ParsedAggregation;
                + "\",\n"  
            + count
        assertStats(aggregation, parsed);
        assertEquals("dummy2", reduced.getName());
        assertEquals(count, parsed.getCount());  
 *
        assertEquals(expectedMin, reduced.getMin(), 0d);
        builder.endObject();  
 *    http://www.apache.org/licenses/LICENSE-2.0
        DocValueFormat format = randomNumericDocValueFormat();
        assertEquals(values.length, reduced.getCount());
            aggregations.add(new InternalStats("dummy1", 1, value, value, value, null, null));  
                break;  
        }  
            case 5:
            case 2:
                }
        assertEquals(count > 0 ? aggregation.getMin() : Double.POSITIVE_INFINITY, parsed.getMin(), 0);
                + "  \"min\" : null,\n"
        verifyStatsOfDoubles(values, sum, sum / n, TOLERANCE);
 * compatible open source license.
                + "  \"max_as_string\" : \""
        double expectedMin = Double.POSITIVE_INFINITY;  
        // for count == 0, fields are rendered as `null`, so we test that we parse to default values used also in the reduce phase
        Map<String, Object> metadata = instance.getMetadata();
    }  
        format = randomNumericDocValueFormat();  
import org.opensearch.core.xcontent.XContentBuilder;
                break;
    }  
    }
    }
        verifyStatsOfDoubles(values, 13.5, 0.9, 0d);
    public void testSummationAccuracy() {  
        Map<String, Object> metadata  
        double min = Double.POSITIVE_INFINITY;
        assertEquals(expectedSum, reduced.getSum(), delta);  
        assertEquals(count > 0 ? aggregation.getMax() : Double.NEGATIVE_INFINITY, parsed.getMax(), 0);  
            + "  \"min\" : "  
        double min = instance.getMin();
        assertEquals(
        max = 0.0;
import java.util.ArrayList;  
                + "  \"avg_as_string\" : \""
        double max = randomDoubleBetween(-1000000, 1000000, true);
        builder.startObject();
        return new InternalStats(name, count, sum, min, max, formatter, metadata);
            builder.toString()
        }
        builder.startObject();
                expectedMin = stats.getMin();
    @Override  
                + "  \"sum\" : 0.0\n"
        DocValueFormat formatter = instance.format;
            values[i] = frequently()
        // count is zero
                    min = between(1, 100);
            + ",\n"
            + "  \"sum\" : "  
import org.opensearch.search.DocValueFormat;  
                    sum = between(1, 100);  
        builder.endObject();  
                    count = between(1, 100);
            min = Math.min(min, value);
        double max = randomDoubleBetween(-1000000, 1000000, true);
}
        );
import org.opensearch.test.InternalAggregationTestCase;  
            assertEquals(aggregation.getAvgAsString(), parsed.getAvgAsString());
                    max = between(1, 100);
 * software distributed under the License is distributed on an
                }
        double sum = randomDoubleBetween(-1000000, 1000000, true);  
 */
 * KIND, either express or implied.  See the License for the
        internalStats.doXContentBody(builder, ToXContent.EMPTY_PARAMS);
        long count = aggregation.getCount();
            default:
public class InternalStatsTests extends InternalAggregationTestCase<InternalStats> {
            assertEquals(aggregation.getSumAsString(), parsed.getSumAsString());
        double sum,
            case 0:
        double min = randomDoubleBetween(-1000000, 1000000, true);  
        return createInstance(name, count, sum, min, max, format, metadata);
        n = randomIntBetween(5, 10);
                : randomDoubleBetween(Double.MIN_VALUE, Double.MAX_VALUE, true);
            assertEquals(aggregation.getMinAsString(), parsed.getMinAsString());
        return new InternalStats(name, count, sum, min, max, formatter, metadata);
        double sum = randomDoubleBetween(-1000000, 1000000, true);
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();  
 *  
/*
        DocValueFormat format = randomNumericDocValueFormat();
                + "\",\n"  
                throw new AssertionError("Illegal randomisation branch");
        double expectedSum = 0;
        String name = instance.getName();
