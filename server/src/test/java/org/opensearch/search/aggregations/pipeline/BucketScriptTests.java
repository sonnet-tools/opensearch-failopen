            }
        } else {
            .startObject("buckets_path")  
            .array("buckets_path", "_count1", "_count2")
 */
            .field("source", "value")
        assertEquals(builder2.getBucketsPaths()[1], "_count2");  
        XContentBuilder content = XContentFactory.jsonBuilder()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
                "script",
    }
/*  
 * Unless required by applicable law or agreed to in writing,
            createParser(content),
        BucketScriptPipelineAggregationBuilder builder2 = BucketScriptPipelineAggregationBuilder.PARSER.parse(  
        BucketScriptPipelineAggregationBuilder builder1 = BucketScriptPipelineAggregationBuilder.PARSER.parse(  
                params
 */  
            factory.gapPolicy(randomFrom(GapPolicy.values()));
            ScriptType type = randomFrom(ScriptType.values());  
        if (randomBoolean()) {  
        return factory;  
    protected BucketScriptPipelineAggregationBuilder createTestAggregatorFactory() {  
        Script script;
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentBuilder;
        BucketScriptPipelineAggregationBuilder builder3 = BucketScriptPipelineAggregationBuilder.PARSER.parse(
 * this work for additional information regarding copyright
        );  
/*
        assertEquals(builder2.getBucketsPaths().length, 2);
                type == ScriptType.STORED ? null : randomFrom("my_lang", Script.DEFAULT_SCRIPT_LANG),  
            createParser(content),
    }
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
import java.io.IOException;
            .startObject("script")
            .endObject()  
        );  
            .endObject();  
            .endObject();
            .endObject()
 *
            "count"
 * not use this file except in compliance with the License.
            "count"  
        BucketScriptPipelineAggregationBuilder factory = new BucketScriptPipelineAggregationBuilder(name, bucketsPaths, script);
import org.opensearch.script.ScriptType;
            );  
}
 * You may obtain a copy of the License at  
        }  
            "count"
 */  
 * software distributed under the License is distributed on an
        }
            .field("buckets_path", "_count")  
            if (randomBoolean()) {  
            .field("source", "value")
        String name = randomAlphaOfLengthBetween(3, 20);
            .endObject()
        for (int i = 0; i < numBucketPaths; i++) {
            .field("path2", "_count2")
        if (randomBoolean()) {  
        );
import org.opensearch.common.xcontent.XContentFactory;
/*  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search.aggregations.pipeline;
            bucketsPaths.put(randomAlphaOfLengthBetween(1, 20), randomAlphaOfLengthBetween(1, 40));
        }
        }
import java.util.Map;
        assertEquals(builder3.getBucketsPaths()[1], "_count2");
            .field("path1", "_count1")
import java.util.HashMap;  
            .startObject("script")
public class BucketScriptTests extends BasePipelineAggregationTestCase<BucketScriptPipelineAggregationBuilder> {  
 *  
        content = XContentFactory.jsonBuilder()
 * ownership. Elasticsearch licenses this file to you under  
            script = mockScript("script");  
        if (randomBoolean()) {
            Map<String, Object> params = new HashMap<>();
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
            .startObject()  
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;  
            factory.format(randomAlphaOfLengthBetween(1, 10));
        assertEquals(builder1.getBucketsPaths()[0], "_count");
            script = new Script(
 * Licensed to Elasticsearch under one or more contributor  
            .field("source", "value")  
            .startObject()
            .field("lang", "expression")  
        int numBucketPaths = randomIntBetween(1, 10);  
                params.put("foo", "bar");
        content = XContentFactory.jsonBuilder()
 * under the License.  
    public void testParseBucketPath() throws IOException {  
        assertEquals(builder1.getBucketsPaths().length, 1);
 * Modifications Copyright OpenSearch Contributors. See
            .startObject("script")
            .endObject()
        assertEquals(builder2.getBucketsPaths()[0], "_count1");
            .endObject();
 *    http://www.apache.org/licenses/LICENSE-2.0
        Map<String, String> bucketsPaths = new HashMap<>();
    @Override
            .field("lang", "expression")  
import org.opensearch.search.aggregations.BasePipelineAggregationTestCase;
        assertEquals(builder3.getBucketsPaths().length, 2);
import org.opensearch.script.Script;  
                type,
 * KIND, either express or implied.  See the License for the
            .field("lang", "expression")
            createParser(content),
            .startObject()
 * compatible open source license.
        assertEquals(builder3.getBucketsPaths()[0], "_count1");  
