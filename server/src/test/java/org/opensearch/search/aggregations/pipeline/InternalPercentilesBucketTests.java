        double[] percentiles = extractPercentiles(instance);
        }  
                throw new AssertionError("Illegal randomisation branch");
                + "    \"1.0\" : null,\n"
import org.opensearch.search.aggregations.metrics.Percentile;
import java.util.List;
    public void testErrorOnDifferentArgumentSize() {
        }  
                }  
        for (Percentile percentile : aggregation) {  
        for (int i = 0; i < values.size(); i++) {
import java.util.Iterator;  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
        double[] percents,  
        List<Double> percents = new ArrayList<>();
                + "    {\n"
    public void testEmptyRanksXContent() throws IOException {
/*  
    private double[] extractPercents(InternalPercentilesBucket instance) {
    @Override  
        }
import org.opensearch.core.xcontent.XContentBuilder;  
        double[] valuesArray = new double[values.size()];  
        String name,
        }
        final Iterable<Percentile> parsedAggregation = parseAndAssert(aggregation, false, false);
                    metadata = new HashMap<>(1);  
                + "    },\n"  
        instance.iterator().forEachRemaining(percentile -> values.add(percentile.getValue()));
        InternalPercentilesBucket agg = createTestInstance("test", Collections.emptyMap(), percents, percentiles, keyed);  
                + "  \"values\" : [\n"
        Iterator<Percentile> it = aggregation.iterator();  
                + "}";
 */
        return new InternalPercentilesBucket(name, percents, percentiles, randomBoolean(), formatter, metadata);  
    }  
                percentiles[percentiles.length - 1] = randomDouble();
 *
import java.util.HashMap;
                + "      \"key\" : 3.0,\n"  
            if (Double.isNaN(aggregation.percentile(percent)) == false) {
        double[] percents,
                + "    },\n"
    protected void assertReduced(InternalPercentilesBucket reduced, List<InternalPercentilesBucket> inputs) {  
        Map<String, Object> metadata,
        for (double percent : percents) {  
        final double[] percentiles = new double[percents.length];  
        final double[] percents = new double[] { 0.50, 0.25, 0.01, 0.99, 0.60 };  
                + "  }\n"
        double[] percentiles = new double[3];  
        builder.startObject();  
        boolean keyed  
        IllegalArgumentException e = expectThrows(
            assertEquals(aggregation.percentile(percent), parsedPercentiles.percentile(percent), 0);
    public void testPercentOrder() {
            "The number of provided percents and percentiles didn't match. percents: [0.1, 0.2, 0.3], percentiles: [0.1, 0.2]",
            percentArray[i] = percents.get(i);  
            percentiles[i] = randomBoolean() ? Double.NaN : Double.POSITIVE_INFINITY;
        return createTestInstance(name, metadata, randomPercents(), true);  
        Iterator<Percentile> iterator = aggregation.iterator();
        expectThrows(UnsupportedOperationException.class, () -> createTestInstance("name", null).reduce(null, null));
    public void testParsedAggregationIteratorOrder() throws IOException {  
 * KIND, either express or implied.  See the License for the
            case 1:
}
    private double[] extractPercentiles(InternalPercentilesBucket instance) {  
        double[] percentiles,
                name += randomAlphaOfLength(5);  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
        while (it.hasNext()) {
            case 0:
import java.util.function.Predicate;  
        for (int i = 0; i < percents.size(); i++) {
        return percentArray;
    }  
import java.util.Map;
            default:  
        Map<String, Object> metadata,  
        InternalPercentilesBucket aggregation = createTestInstance("test", Collections.emptyMap(), percents, randomBoolean());
                percents = Arrays.copyOf(percents, percents.length);  
        List<Double> values = new ArrayList<>();
                + "      \"key\" : 2.0,\n"
        // no test since reduce operation is unsupported
 * this work for additional information regarding copyright
import java.util.Arrays;  
                break;
import org.opensearch.test.InternalAggregationTestCase;
                + "    {\n"  
        switch (between(0, 3)) {
        }
 *  
 * license agreements. See the NOTICE file distributed with
    @Override
 * not use this file except in compliance with the License.
    }  
import org.opensearch.common.xcontent.json.JsonXContent;
import static org.opensearch.search.aggregations.metrics.InternalPercentilesTestCase.randomPercents;
        final double[] percents = new double[] { 0.1, 0.2, 0.3 };  
            // null and we don't have a formatted string representation in the rest output
    ) {
            }
 * You may obtain a copy of the License at  
    ) {
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
        return path -> path.endsWith(CommonFields.VALUES.getPreferredName());  
    private static InternalPercentilesBucket createTestInstance(  
        } else {  
        DocValueFormat format = randomNumericDocValueFormat();
        }
                percents[percents.length - 1] = randomDouble();
 * under the License.  
 * software distributed under the License is distributed on an
                + "      \"value\" : null\n"
            assertEquals(aggregation.percentile(percent), percentile.getValue(), 0.0d);
    }
        assertThat(builder.toString(), equalTo(expected));
                assertEquals(aggregation.percentileAsString(percent), parsedPercentiles.percentileAsString(percent));  
                break;  
            percentiles[i] = frequently() ? randomDouble() : Double.NaN;
            case 3:
    }
    protected Predicate<String> excludePathsFromXContentInsertion() {
        String name,
import java.util.Collections;
    private static InternalPercentilesBucket createTestInstance(
 */  
        );  
    /**
        );
        String name = instance.getName();
        assertEquals(  
    }  
    }
        return createTestInstance(name, metadata, percents, percentiles, keyed);
    @Override
        }
            IllegalArgumentException.class,  
    protected final void assertFromXContent(InternalPercentilesBucket aggregation, ParsedAggregation parsedAggregation) {
     * check that we don't rely on the percent array order and that the iterator returns the values in the original order  
package org.opensearch.search.aggregations.pipeline;
        return new InternalPercentilesBucket(name, percents, percentiles, keyed, format, metadata);  
        }
            assertEquals(percent, percentile.getPercent(), 0.0d);  
import java.io.IOException;
     */
    public void testReduceRandom() {
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
        builder.endObject();
/*  
        Iterator<Percentile> parsedIt = parsedAggregation.iterator();
            // we cannot ensure we get the same as_string output for Double.NaN values since they are rendered as  
public class InternalPercentilesBucketTests extends InternalAggregationTestCase<InternalPercentilesBucket> {
            Double percent = percentile.getPercent();
                + "    \"2.0\" : null,\n"
        }  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
        final double[] percentiles = new double[] { 0.10, 0.2 };
            case 2:  
    @Override
                percentiles = Arrays.copyOf(percentiles, percentiles.length);
    }
        agg.doXContentBody(builder, ToXContent.EMPTY_PARAMS);
        if (keyed) {
                } else {
        for (int i = 0; i < 3; ++i) {
                + "    {\n"
            e.getMessage()
    @Override  
        for (int i = 0; i < percents.length; ++i) {
    protected InternalPercentilesBucket mutateInstance(InternalPercentilesBucket instance) {
                + "  ]\n"  
            expected = "{\n"
 */  
        Map<String, Object> metadata = instance.getMetadata();  
        ParsedPercentilesBucket parsedPercentiles = (ParsedPercentilesBucket) parsedAggregation;
import org.opensearch.search.aggregations.Aggregation.CommonFields;
        double[] percents = new double[] { 1, 2, 3 };
        DocValueFormat formatter = instance.formatter();
            expected = "{\n"
 * Modifications Copyright OpenSearch Contributors. See
            valuesArray[i] = values.get(i);
                break;
    }
            assertTrue(iterator.hasNext());
        boolean keyed = randomBoolean();
                break;
    protected InternalPercentilesBucket createTestInstance(String name, Map<String, Object> metadata) {
                + "    \"3.0\" : null\n"  
import org.opensearch.search.DocValueFormat;
                    metadata = new HashMap<>(instance.getMetadata());
        boolean keyed
                + "  \"values\" : {\n"  
import org.opensearch.search.aggregations.ParsedAggregation;  
 * specific language governing permissions and limitations
                if (metadata == null) {
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
            assertEquals(it.next(), parsedIt.next());  
        String expected;  
                + "      \"value\" : null\n"
    }
                + "}";
        assertTrue(parsedAggregation instanceof ParsedPercentilesBucket);  
                metadata.put(randomAlphaOfLength(15), randomInt());
    }
 *
    }
                + "      \"value\" : null\n"  
            Percentile percentile = iterator.next();
        final InternalPercentilesBucket aggregation = createTestInstance();
        return valuesArray;
    }
import static org.hamcrest.Matchers.equalTo;  
/*
        instance.iterator().forEachRemaining(percentile -> percents.add(percentile.getPercent()));  
import org.opensearch.core.xcontent.ToXContent;
    }
import java.util.ArrayList;
        double[] percentArray = new double[percents.size()];
            () -> new InternalPercentilesBucket("test", percents, percentiles, randomBoolean(), DocValueFormat.RAW, Collections.emptyMap())
                + "    }\n"
        double[] percents = extractPercents(instance);  
                + "      \"key\" : 1.0,\n"
