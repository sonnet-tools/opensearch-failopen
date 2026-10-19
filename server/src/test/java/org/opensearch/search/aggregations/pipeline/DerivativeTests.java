    public void testValidate() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.BasePipelineAggregationTestCase;
 * ownership. Elasticsearch licenses this file to you under  
        aggBuilders.add(new DerivativePipelineAggregationBuilder("deriv", "der"));
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
 * specific language governing permissions and limitations
 */  
            )
 * Unless required by applicable law or agreed to in writing,
    /**
public class DerivativeTests extends BasePipelineAggregationTestCase<DerivativePipelineAggregationBuilder> {  
        }
     * The validation should verify the parent aggregation is allowed.  
        assertThat(
                "Validation Failed: 1: derivative aggregation [name] must have a histogram, "
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;  
     * DateHistogramAggregatorFactory or AutoDateHistogramAggregatorFactory.  
     */
     * The validation should throw an IllegalArgumentException, since parent
 *
 * not use this file except in compliance with the License.
                    + "date_histogram or auto_date_histogram as parent;"  
        String name = randomAlphaOfLengthBetween(3, 20);
/*  
    public void testValidateException() throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
import static org.mockito.Mockito.when;
 * the Apache License, Version 2.0 (the "License"); you may
            factory.gapPolicy(randomFrom(GapPolicy.values()));
    }  
        AggregationBuilder parent = mock(AggregationBuilder.class);
import static org.hamcrest.Matchers.nullValue;
import java.util.HashSet;
            } else {
            nullValue()
 * under the License.  
            if (randomBoolean()) {
                new DerivativePipelineAggregationBuilder("name", "valid")  
        return factory;
 *    http://www.apache.org/licenses/LICENSE-2.0
                factory.unit(String.valueOf(randomIntBetween(1, 10) + randomFrom("s", "m", "h", "d", "w", "M", "y")));
 * license agreements. See the NOTICE file distributed with
    @Override
    }
 * this work for additional information regarding copyright
        if (randomBoolean()) {
 *  
/*  
    protected DerivativePipelineAggregationBuilder createTestAggregatorFactory() {  
        if (randomBoolean()) {
            factory.format(randomAlphaOfLengthBetween(1, 10));
 */  
import java.util.Set;
 * Modifications Copyright OpenSearch Contributors. See
    /**  
            validate(
            }  
     * aggregation is not a type of HistogramAggregatorFactory,
import org.opensearch.search.aggregations.PipelineAggregationBuilder;  
            validate(parent, new DerivativePipelineAggregationBuilder("name", "invalid_agg>metric")),  
        if (randomBoolean()) {
import static org.mockito.Mockito.mock;  
import static org.hamcrest.Matchers.equalTo;
            ),
        final Set<PipelineAggregationBuilder> aggBuilders = new HashSet<>();  
                PipelineAggregationHelperTests.getRandomSequentiallyOrderedParentAgg(),
package org.opensearch.search.aggregations.pipeline;
 */
            equalTo(
/*
        when(parent.getName()).thenReturn("name");  
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
}
 * GitHub history for details.
        String bucketsPath = randomAlphaOfLengthBetween(3, 20);
        }  
 *
import org.opensearch.search.aggregations.AggregationBuilder;
        assertThat(  
 * SPDX-License-Identifier: Apache-2.0
        );
                factory.unit(String.valueOf(randomInt()));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        }  
     */
        DerivativePipelineAggregationBuilder factory = new DerivativePipelineAggregationBuilder(name, bucketsPath);  
 * software distributed under the License is distributed on an
        );  
