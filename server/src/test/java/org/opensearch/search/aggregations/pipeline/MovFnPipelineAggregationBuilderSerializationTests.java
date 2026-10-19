 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
package org.opensearch.search.aggregations.pipeline;
 *  
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;  
/*
 * Unless required by applicable law or agreed to in writing,
 */  
        assertThat(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            validate(emptyList(), new MovFnPipelineAggregationBuilder("name", "invalid_agg>metric", script, 1)),
        Script script = new Script(Script.DEFAULT_SCRIPT_TYPE, "painless", "test", emptyMap());
        );
            "foo",
            validate(
 *
/*  
    }
 * specific language governing permissions and limitations
                "Validation Failed: 1: moving_fn aggregation [name] must have a histogram, date_histogram"
    @Override
            ),
    public void testValidParent() throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + " or auto_date_histogram as parent but doesn't have a parent;"
    }
        builder.setShift(randomIntBetween(1, 10));  
 *
            randomAlphaOfLength(10),
 * Licensed to Elasticsearch under one or more contributor  
        return builder;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.AggregationBuilder;
public class MovFnPipelineAggregationBuilderSerializationTests extends BasePipelineAggregationTestCase<MovFnPipelineAggregationBuilder> {  
        Script script = new Script(Script.DEFAULT_SCRIPT_TYPE, "painless", "test", Collections.emptyMap());
 * this work for additional information regarding copyright
                new MovFnPipelineAggregationBuilder("mov_fn", "avg", script, 3)  
import static org.hamcrest.Matchers.equalTo;
 */  
    }
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
        when(parent.getName()).thenReturn("name");  
import static org.mockito.Mockito.when;
        MovFnPipelineAggregationBuilder builder = new MovFnPipelineAggregationBuilder(  
 * compatible open source license.
            equalTo(  
import org.opensearch.search.aggregations.BasePipelineAggregationTestCase;  
import static org.mockito.Mockito.mock;  
                    + " or auto_date_histogram as parent;"  
        Script script = new Script(Script.DEFAULT_SCRIPT_TYPE, "painless", "test", Collections.emptyMap());  
import static java.util.Collections.emptyMap;  
            equalTo(
import org.opensearch.script.Script;
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
    public void testNoParent() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            )  
                PipelineAggregationHelperTests.getRandomSequentiallyOrderedParentAgg(),
        );
 * KIND, either express or implied.  See the License for the
    public void testInvalidParent() throws IOException {  
        assertThat(
 * GitHub history for details.
            new Script("foo"),  
    protected MovFnPipelineAggregationBuilder createTestAggregatorFactory() {
            nullValue()
        assertThat(  
        );  
 * software distributed under the License is distributed on an
            randomIntBetween(1, 10)
import static java.util.Collections.emptyList;
        AggregationBuilder parent = mock(AggregationBuilder.class);
            )
 * license agreements. See the NOTICE file distributed with
        );
                "Validation Failed: 1: moving_fn aggregation [name] must have a histogram, date_histogram"
import static org.hamcrest.Matchers.nullValue;
}  
/*  
 */
            validate(parent, new MovFnPipelineAggregationBuilder("name", "invalid_agg>metric", script, 1)),  
    }  
