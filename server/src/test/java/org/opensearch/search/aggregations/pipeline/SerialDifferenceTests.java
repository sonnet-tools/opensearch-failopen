                    + "date_histogram or auto_date_histogram as parent but doesn't have a parent;"
import java.util.Set;
import static org.hamcrest.Matchers.nullValue;  
            factory.format(randomAlphaOfLengthBetween(1, 10));  
        );  
        String bucketsPath = randomAlphaOfLengthBetween(3, 20);  
            nullValue()
 *  
        String name = randomAlphaOfLengthBetween(3, 20);
        );  
public class SerialDifferenceTests extends BasePipelineAggregationTestCase<SerialDiffPipelineAggregationBuilder> {
import static org.mockito.Mockito.when;
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
    @Override  
    /**
            validate(emptyList(), new SerialDiffPipelineAggregationBuilder("name", "invalid_agg>metric")),
/*  
            )
        SerialDiffPipelineAggregationBuilder factory = new SerialDiffPipelineAggregationBuilder(name, bucketsPath);
 * The OpenSearch Contributors require contributions made to  
/*  
        );
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(  
        if (randomBoolean()) {
 * Modifications Copyright OpenSearch Contributors. See
        return factory;
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
            factory.lag(randomIntBetween(1, 1000));  
 */  
 */
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
     */
    }  
            ),
        }
                "Validation Failed: 1: serial_diff aggregation [name] must have a histogram, "  
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
 * You may obtain a copy of the License at  
    public void testNoParent() {
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.PipelineAggregationBuilder;  
 * this work for additional information regarding copyright
            equalTo(
package org.opensearch.search.aggregations.pipeline;
    public void testInvalidParent() throws IOException {  
     * The validation should verify the parent aggregation is allowed.  
    protected SerialDiffPipelineAggregationBuilder createTestAggregatorFactory() {
                    + "date_histogram or auto_date_histogram as parent;"  
}
                new SerialDiffPipelineAggregationBuilder("name", "valid")  
 */  
import org.opensearch.search.aggregations.BasePipelineAggregationTestCase;
            validate(
        }
        when(parent.getName()).thenReturn("name");
                PipelineAggregationHelperTests.getRandomSequentiallyOrderedParentAgg(),
 * GitHub history for details.
        if (randomBoolean()) {
import java.util.HashSet;
        assertThat(  
            equalTo(
                "Validation Failed: 1: serial_diff aggregation [name] must have a histogram, "
            factory.gapPolicy(randomFrom(GapPolicy.values()));  
    }
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.mockito.Mockito.mock;
 *
 * compatible open source license.
/*
import org.opensearch.search.aggregations.AggregationBuilder;
            validate(parent, new SerialDiffPipelineAggregationBuilder("name", "invalid_agg>metric")),  
        if (randomBoolean()) {
        assertThat(
        AggregationBuilder parent = mock(AggregationBuilder.class);  
 * under the License.  
 * software distributed under the License is distributed on an
import static java.util.Collections.emptyList;
    }  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testValidate() throws IOException {
            )
        }
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;  
 *
        aggBuilders.add(createTestAggregatorFactory());
        final Set<PipelineAggregationBuilder> aggBuilders = new HashSet<>();
