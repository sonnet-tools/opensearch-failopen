        double[] percentiles = new double[3];
            Double percent = percentile.getPercent();
 */
        switch (between(0, 3)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testEmptyRanksXContent() throws IOException {
import org.opensearch.search.aggregations.ParsedAggregation;
                + "    },\n"
import static org.opensearch.search.aggregations.metrics.InternalPercentilesTestCase.randomPercents;
 * not use this file except in compliance with the License.
 * under the License.
 * The OpenSearch Contributors require contributions made to
 * Licensed to Elasticsearch under one or more contributor
                break;
    public void testReduceRandom() {
     */
                } else {
        // no test since reduce operation is unsupported
                + "      \"key\" : 1.0,\n"
                + "      \"value\" : null\n"
        final InternalPercentilesBucket aggregation = createTestInstance();
        return new InternalPercentilesBucket(name, percents, percentiles, randomBoolean(), formatter, metadata);
     * check that we don't rely on the percent array order and that the iterator returns the values in the original order
                }
    }
}
        InternalPercentilesBucket aggregation = createTestInstance("test", Collections.emptyMap(), percents, randomBoolean());
        double[] percents = new double[] { 1, 2, 3 };
 * the Apache License, Version 2.0 (the "License"); you may
        return valuesArray;
 *
    public void testParsedAggregationIteratorOrder() throws IOException {
        for (int i = 0; i < values.size(); i++) {
        assertEquals(
 *
 * GitHub history for details.
                percents = Arrays.copyOf(percents, percents.length);
            IllegalArgumentException.class,
                break;
    public void testPercentOrder() {
        InternalPercentilesBucket agg = createTestInstance("test", Collections.emptyMap(), percents, percentiles, keyed);
    }
                + "}";
        builder.endObject();
        if (keyed) {
    }
                name += randomAlphaOfLength(5);
    }
 * license agreements. See the NOTICE file distributed with
        instance.iterator().forEachRemaining(percentile -> percents.add(percentile.getPercent()));
import java.util.Collections;
    }
        return new InternalPercentilesBucket(name, percents, percentiles, keyed, format, metadata);
            assertEquals(aggregation.percentile(percent), percentile.getValue(), 0.0d);
    private static InternalPercentilesBucket createTestInstance(
        Map<String, Object> metadata,
    @Override
    protected void assertReduced(InternalPercentilesBucket reduced, List<InternalPercentilesBucket> inputs) {
 * specific language governing permissions and limitations
        double[] percentiles = extractPercentiles(instance);
                metadata.put(randomAlphaOfLength(15), randomInt());
                + "  \"values\" : {\n"
    @Override
        );
 */
        }
        double[] percents,
            case 3:
            default:
 * SPDX-License-Identifier: Apache-2.0
                break;
import java.io.IOException;
        return createTestInstance(name, metadata, percents, percentiles, keyed);
 * this work for additional information regarding copyright
        final double[] percents = new double[] { 0.50, 0.25, 0.01, 0.99, 0.60 };
        }
            Percentile percentile = iterator.next();
                + "    {\n"
        for (int i = 0; i < percents.size(); i++) {
                + "  ]\n"
        assertTrue(parsedAggregation instanceof ParsedPercentilesBucket);
        DocValueFormat format = randomNumericDocValueFormat();
    @Override
        String name,
            assertEquals(percent, percentile.getPercent(), 0.0d);
    ) {
/*
                + "    {\n"
                + "    \"2.0\" : null,\n"
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
        agg.doXContentBody(builder, ToXContent.EMPTY_PARAMS);
        double[] percentiles,
            case 2:
        List<Double> values = new ArrayList<>();
            assertEquals(it.next(), parsedIt.next());
            // we cannot ensure we get the same as_string output for Double.NaN values since they are rendered as
            valuesArray[i] = values.get(i);
    ) {
        } else {
                + "    },\n"
 */
        Iterator<Percentile> parsedIt = parsedAggregation.iterator();
import java.util.ArrayList;
        final double[] percentiles = new double[] { 0.10, 0.2 };
            case 1:
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(aggregation.percentile(percent), parsedPercentiles.percentile(percent), 0);
    public void testErrorOnDifferentArgumentSize() {
package org.opensearch.search.aggregations.pipeline;
        final double[] percentiles = new double[percents.length];
            percentiles[i] = frequently() ? randomDouble() : Double.NaN;
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under
import java.util.HashMap;
        String expected;
import org.opensearch.search.DocValueFormat;
            e.getMessage()
                assertEquals(aggregation.percentileAsString(percent), parsedPercentiles.percentileAsString(percent));
        }
            () -> new InternalPercentilesBucket("test", percents, percentiles, randomBoolean(), DocValueFormat.RAW, Collections.emptyMap())
        }
        Map<String, Object> metadata = instance.getMetadata();
import org.opensearch.common.xcontent.json.JsonXContent;
    }
        );
            }
        final double[] percents = new double[] { 0.1, 0.2, 0.3 };
                + "}";
                + "  }\n"
        Iterator<Percentile> it = aggregation.iterator();
        Map<String, Object> metadata,
import java.util.Map;
    @Override
    @Override
    private double[] extractPercentiles(InternalPercentilesBucket instance) {
        return createTestInstance(name, metadata, randomPercents(), true);
    /**
    protected InternalPercentilesBucket createTestInstance(String name, Map<String, Object> metadata) {
            if (Double.isNaN(aggregation.percentile(percent)) == false) {
        }
    }
import org.opensearch.search.aggregations.Aggregation.CommonFields;
        double[] percentArray = new double[percents.size()];
import org.opensearch.core.xcontent.XContentBuilder;
    private double[] extractPercents(InternalPercentilesBucket instance) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return percentArray;
            // null and we don't have a formatted string representation in the rest output
 * this file be licensed under the Apache-2.0 license or a
                percents[percents.length - 1] = randomDouble();
            expected = "{\n"
    }
import static org.hamcrest.Matchers.equalTo;
        }
 * You may obtain a copy of the License at
    }
        for (int i = 0; i < percents.length; ++i) {
    }
                + "    \"1.0\" : null,\n"
        double[] percents = extractPercents(instance);
import java.util.Arrays;
            expected = "{\n"
/*
                throw new AssertionError("Illegal randomisation branch");
import org.opensearch.core.xcontent.ToXContent;
        while (it.hasNext()) {
            "The number of provided percents and percentiles didn't match. percents: [0.1, 0.2, 0.3], percentiles: [0.1, 0.2]",
        builder.startObject();
import java.util.Iterator;
                + "      \"key\" : 2.0,\n"
        boolean keyed
 * compatible open source license.
                if (metadata == null) {
        return path -> path.endsWith(CommonFields.VALUES.getPreferredName());
    @Override
    }
            percentArray[i] = percents.get(i);
        boolean keyed
        }
                + "  \"values\" : [\n"
    }
        DocValueFormat formatter = instance.formatter();
                + "      \"key\" : 3.0,\n"
            case 0:
    protected final void assertFromXContent(InternalPercentilesBucket aggregation, ParsedAggregation parsedAggregation) {
                    metadata = new HashMap<>(1);
                + "    {\n"
        double[] valuesArray = new double[values.size()];
        expectThrows(UnsupportedOperationException.class, () -> createTestInstance("name", null).reduce(null, null));
        for (Percentile percentile : aggregation) {
        ParsedPercentilesBucket parsedPercentiles = (ParsedPercentilesBucket) parsedAggregation;
import org.opensearch.search.aggregations.metrics.Percentile;
    }
        for (int i = 0; i < 3; ++i) {
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
            assertTrue(iterator.hasNext());
                percentiles = Arrays.copyOf(percentiles, percentiles.length);
                    metadata = new HashMap<>(instance.getMetadata());
        }
        instance.iterator().forEachRemaining(percentile -> values.add(percentile.getValue()));
                + "    \"3.0\" : null\n"
        Iterator<Percentile> iterator = aggregation.iterator();
        assertThat(builder.toString(), equalTo(expected));
        final Iterable<Percentile> parsedAggregation = parseAndAssert(aggregation, false, false);
                + "      \"value\" : null\n"
                + "    }\n"
import org.opensearch.test.InternalAggregationTestCase;
        String name,
        String name = instance.getName();
    }
            percentiles[i] = randomBoolean() ? Double.NaN : Double.POSITIVE_INFINITY;
 *
        boolean keyed = randomBoolean();
public class InternalPercentilesBucketTests extends InternalAggregationTestCase<InternalPercentilesBucket> {
                break;
        List<Double> percents = new ArrayList<>();
    protected Predicate<String> excludePathsFromXContentInsertion() {
        }
    private static InternalPercentilesBucket createTestInstance(
        IllegalArgumentException e = expectThrows(
        for (double percent : percents) {
/*
        double[] percents,
import java.util.function.Predicate;
    protected InternalPercentilesBucket mutateInstance(InternalPercentilesBucket instance) {
                percentiles[percentiles.length - 1] = randomDouble();
import java.util.List;
                + "      \"value\" : null\n"
