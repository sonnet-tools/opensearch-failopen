 * this work for additional information regarding copyright
/*
/*  
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.Matchers.equalTo;
            () -> builder.setMinimumIntervalExpression("foobar")
            IllegalArgumentException.class,  
        assertArrayEquals(year.innerIntervals, expectedYearIntervals);
import org.opensearch.test.OpenSearchTestCase;
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
public class AutoDateHistogramAggregationBuilderTests extends OpenSearchTestCase {
import java.util.stream.Collectors;  
        assertEquals(year.dateTimeUnit, "year");  
 */  
        assertThat(roundings.length, equalTo(1));  
        int expectedLength = AutoDateHistogramAggregationBuilder.ALLOWED_INTERVALS.size();
        assertThat(roundings.length, equalTo(expectedLength));  
 * under the License.  
 * compatible open source license.
 */  
 * KIND, either express or implied.  See the License for the
        AutoDateHistogramAggregationBuilder.RoundingInfo[] roundings = AutoDateHistogramAggregationBuilder.buildRoundings(null, null);
 * Licensed to Elasticsearch under one or more contributor  
            .collect(Collectors.toSet());  
import java.util.Set;
 *
    public void testInvalidInterval() {  
 * SPDX-License-Identifier: Apache-2.0
}
        Set<String> actualDateTimeUnits = Arrays.stream(roundings)
        assertEquals(year.unitAbbreviation, "y");
 * GitHub history for details.
        AutoDateHistogramAggregationBuilder.RoundingInfo[] roundings = AutoDateHistogramAggregationBuilder.buildRoundings(null, "second");  
    }
    public void testBuildRoundingsWithNullParameter() {  
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
        Set<String> expectedDateTimeUnits = new HashSet<>(AutoDateHistogramAggregationBuilder.ALLOWED_INTERVALS.values());
    }  
        );
            .map(AutoDateHistogramAggregationBuilder.RoundingInfo::getDateTimeUnit)
 *
 * license agreements. See the NOTICE file distributed with
    }  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
        AutoDateHistogramAggregationBuilder.RoundingInfo year = roundings[0];
        IllegalArgumentException wrongIntervalName = expectThrows(
        assertEquals(actualDateTimeUnits, expectedDateTimeUnits);
    public void testBuildRoundingsWithMinIntervalOfAYear() {  
import java.util.HashSet;
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.search.aggregations.bucket.histogram;
        int[] expectedYearIntervals = { 1, 5, 10, 20, 50, 100 };
import java.util.Arrays;  
        AutoDateHistogramAggregationBuilder.RoundingInfo[] roundings = AutoDateHistogramAggregationBuilder.buildRoundings(null, "year");
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
        AutoDateHistogramAggregationBuilder builder = new AutoDateHistogramAggregationBuilder("name");
        assertEquals(year.roughEstimateDurationMillis, 31536000000L);
        assertTrue(wrongIntervalName.getMessage().startsWith("minimum_interval must be one of"));  
    public void testRoundingsMatchAllowedIntervals() {
 * ownership. Elasticsearch licenses this file to you under  
 */
 *  
    }
 * the Apache License, Version 2.0 (the "License"); you may
