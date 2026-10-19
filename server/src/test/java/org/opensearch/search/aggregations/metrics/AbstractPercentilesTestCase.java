        return percents;
        }  
 * GitHub history for details.
    @Override
        DocValueFormat format = randomNumericDocValueFormat();
 * SPDX-License-Identifier: Apache-2.0
    private T createTestInstance(String name, Map<String, Object> metadata, boolean keyed, DocValueFormat format, double[] percents) {  
 * under the License.  
        DocValueFormat docValueFormat = randomNumericDocValueFormat();
package org.opensearch.search.aggregations.metrics;
        }  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        DocValueFormat format,
        } else {  
 * this work for additional information regarding copyright
        final T aggregation = createTestInstance();  
 */  
    }
 * Licensed to Elasticsearch under one or more contributor  
        boolean keyed,  
import java.util.Arrays;
        return path -> path.endsWith(CommonFields.VALUES.getPreferredName());  
 * this file be licensed under the Apache-2.0 license or a
        builder.startObject();  
import org.opensearch.common.xcontent.json.JsonXContent;
 * Unless required by applicable law or agreed to in writing,
            values[i] = randomDouble();
        for (int i = 0; i < numValues; ++i) {  
import java.util.List;
import java.util.function.Predicate;  
import static java.util.stream.Collectors.toList;  
            expected = "{\n"
 * license agreements. See the NOTICE file distributed with
                + "      \"key\" : 1.0,\n"
        String expected;  
        }  
 * compatible open source license.
import org.opensearch.core.xcontent.XContentBuilder;  
                + "    }\n"
        boolean keyed = randomBoolean();
        T agg = createTestInstance("test", Collections.emptyMap(), keyed, docValueFormat, percents, new double[0]);
        Iterator<Percentile> it = aggregation.iterator();  
            assertEquals(it.next(), parsedIt.next());  
    protected Predicate<String> excludePathsFromXContentInsertion() {
    @Override
        return createTestInstance(name, metadata, randomBoolean(), randomNumericDocValueFormat(), randomPercents(false));
                + "}";
    }
        builder.endObject();
                + "    \"2.0\" : null,\n"
                + "  }\n"
import org.opensearch.search.aggregations.Aggregation.CommonFields;
                + "      \"key\" : 3.0,\n"  
 * KIND, either express or implied.  See the License for the
        double[] values = new double[numValues];
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;  
public abstract class AbstractPercentilesTestCase<T extends InternalAggregation & Iterable<Percentile>> extends InternalAggregationTestCase<  
import java.util.stream.Stream;
import java.util.Map;
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.ToXContent;
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 * not use this file except in compliance with the License.
        if (keyed) {
        final Iterable<Percentile> parsedAggregation = parseAndAssert(aggregation, false, false);
        agg.doXContentBody(builder, ToXContent.EMPTY_PARAMS);
            percents[i] = randomCdfValues.get(i);
            assertPercentile(agg, value);
    }
import java.util.Iterator;  
/*
                + "    \"1.0\" : null,\n"
 * software distributed under the License is distributed on an
        }
        List<Double> randomCdfValues = randomSubsetOf(randomIntBetween(1, 7), 0.01d, 0.05d, 0.25d, 0.50d, 0.75d, 0.95d, 0.99d);
        return Stream.generate(() -> createTestInstance(name, null, keyed, format, percents)).limit(size).collect(toList());  
 */  
                + "      \"key\" : 2.0,\n"
                + "  \"values\" : {\n"  
    }
                + "    {\n"  
        double[] values  
/*  
                + "    },\n"
import java.util.Collections;
        if (sorted) {
    );
 * You may obtain a copy of the License at  
                + "}";
    protected List<T> randomResultsToReduce(String name, int size) {
import org.opensearch.search.DocValueFormat;
    public static double[] randomPercents(boolean sorted) {
 *  
    }
        int numValues = frequently() ? randomInt(100) : 0;
import org.opensearch.search.aggregations.InternalAggregation;  
/*  
    }
            expected = "{\n"
 *    http://www.apache.org/licenses/LICENSE-2.0
                + "    },\n"  
                + "    {\n"
    protected abstract void assertPercentile(T agg, Double value);  
        while (it.hasNext()) {
        XContentBuilder builder = JsonXContent.contentBuilder().prettyPrint();
}  
    protected abstract T createTestInstance(  
    T> {
        for (int i = 0; i < randomCdfValues.size(); i++) {
                + "  ]\n"  
    protected T createTestInstance(String name, Map<String, Object> metadata) {  
 * the Apache License, Version 2.0 (the "License"); you may
 */
        boolean keyed = randomBoolean();  
        double[] percents = randomPercents(false);
        }
        return createTestInstance(name, metadata, keyed, format, percents, values);  
            Double value = percentile.getValue();
                + "      \"value\" : null\n"  
                + "    {\n"
import org.opensearch.test.InternalAggregationTestCase;
        Iterator<Percentile> parsedIt = parsedAggregation.iterator();
                + "      \"value\" : null\n"
 *
                + "      \"value\" : null\n"
                + "  \"values\" : [\n"
    public void testPercentilesIterators() throws IOException {
 *
    public void testEmptyRanksXContent() throws IOException {
            Arrays.sort(percents);
                + "    \"3.0\" : null\n"  
import static org.hamcrest.Matchers.equalTo;
    protected abstract Class<? extends ParsedPercentiles> implementationClass();  
        assertThat(builder.toString(), equalTo(expected));
        double[] percents = new double[] { 1, 2, 3 };  
        }
        for (Percentile percentile : agg) {  
        String name,
        double[] percents = new double[randomCdfValues.size()];  
 * ownership. Elasticsearch licenses this file to you under  
        Map<String, Object> metadata,
        double[] percents,
