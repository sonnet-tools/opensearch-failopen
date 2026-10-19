 * SPDX-License-Identifier: Apache-2.0
        Map<String, String> bucketsPathsMap = new HashMap<>();
    public void testNoParent() {
    protected BucketScriptPipelineAggregationBuilder createTestAggregatorFactory() {
 * GitHub history for details.
        while (bucketsPathsMap.size() < targetBucketsPathsMapSize) {
import static java.util.Collections.emptyMap;
 * this work for additional information regarding copyright
    }
 * not use this file except in compliance with the License.
package org.opensearch.search.aggregations.pipeline;
 * ownership. Elasticsearch licenses this file to you under  
            validate(emptyList(), new BucketScriptPipelineAggregationBuilder("foo", emptyMap(), new Script("foo"))),
import org.opensearch.search.aggregations.BasePipelineAggregationTestCase;
    @Override  
            equalTo("Validation Failed: 1: bucket_script aggregation [foo] must be declared inside of another aggregation;")
        Script script = new Script(randomAlphaOfLength(4));
public class BucketScriptPipelineAggregationBuilderTests extends BasePipelineAggregationTestCase<BucketScriptPipelineAggregationBuilder> {
 * under the License.  
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(  
/*  
 * You may obtain a copy of the License at  
        int targetBucketsPathsMapSize = randomInt(5);  
 *  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
 */  
import static org.hamcrest.CoreMatchers.equalTo;  
 */  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
import static java.util.Collections.emptyList;
 * software distributed under the License is distributed on an
        );  
}
import java.util.HashMap;
import java.util.Map;
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 *
 * Licensed to Elasticsearch under one or more contributor  
        return new BucketScriptPipelineAggregationBuilder(randomAlphaOfLength(3), bucketsPathsMap, script);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 */
/*  
            bucketsPathsMap.put(randomAlphaOfLength(5), randomAlphaOfLength(5));
 *
 * The OpenSearch Contributors require contributions made to  
    }  
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.script.Script;
        }  
