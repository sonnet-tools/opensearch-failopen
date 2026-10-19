public class ExtendedStatsBucketTests extends AbstractBucketMetricsTestCase<ExtendedStatsBucketPipelineAggregationBuilder> {
 * software distributed under the License is distributed on an
import java.util.HashSet;
            .field("buckets_path", "test")
/*  
/*
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        );
 * SPDX-License-Identifier: Apache-2.0
        return factory;
 *    http://www.apache.org/licenses/LICENSE-2.0
            )  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
                "Validation Failed: 1: The first aggregation in "
        );
    }
        AggregationBuilder singleBucketAgg = new GlobalAggregationBuilder("global");
        // Now try to point to a single bucket agg  
    }
import org.opensearch.search.aggregations.AggregationBuilder;  
        ExtendedStatsBucketPipelineAggregationBuilder factory = new ExtendedStatsBucketPipelineAggregationBuilder(name, bucketsPath);  
            )  
 */  
 * Unless required by applicable law or agreed to in writing,
    @Override
            validate(aggBuilders, new ExtendedStatsBucketPipelineAggregationBuilder("name", "global>metric")),
 * license agreements. See the NOTICE file distributed with
        assertThat(validate(aggBuilders, new ExtendedStatsBucketPipelineAggregationBuilder("name", "terms>metric")), nullValue());
import org.opensearch.common.xcontent.XContentFactory;
 * You may obtain a copy of the License at  
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
        final Set<AggregationBuilder> aggBuilders = new HashSet<>();
 *
        // First try to point to a non-existent agg
 */
 * Modifications Copyright OpenSearch Contributors. See
 * the Apache License, Version 2.0 (the "License"); you may
 *  
            createParser(content)
import org.opensearch.core.xcontent.XContentBuilder;
 *
                    + " for buckets path: global>metric;"
        ExtendedStatsBucketPipelineAggregationBuilder builder = (ExtendedStatsBucketPipelineAggregationBuilder) parse(  
        AggregationBuilder multiBucketAgg = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.STRING);  
        }  
                    + PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName()
 */  
 * not use this file except in compliance with the License.
    public void testValidate() {
        aggBuilders.add(multiBucketAgg);  
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
        assertThat(
        aggBuilders.add(singleBucketAgg);
package org.opensearch.search.aggregations.pipeline;
import static org.hamcrest.Matchers.equalTo;
/*  
        if (randomBoolean()) {
 * this file be licensed under the Apache-2.0 license or a
            .startObject("extended_stats_bucket")
    protected ExtendedStatsBucketPipelineAggregationBuilder doCreateTestAggregatorFactory(String name, String bucketsPath) {
                "Validation Failed: 1: "  
 * ownership. Elasticsearch licenses this file to you under  
            equalTo(  
 * GitHub history for details.
            validate(aggBuilders, new ExtendedStatsBucketPipelineAggregationBuilder("name", "invalid_agg>metric")),
                    + " aggregation does not exist for aggregation [name]: invalid_agg>metric;"
                    + GlobalAggregationBuilder.class.getName()
 * compatible open source license.
        );
            .endObject()  
    public void testSigmaFromInt() throws Exception {
        // Now try to point to a valid multi-bucket agg  
import java.util.Set;  
import org.opensearch.search.aggregations.support.ValueType;  
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
            .startObject("name")
    }
            .field("sigma", 5)  
        assertThat(builder.sigma(), equalTo(5.0));
import static org.hamcrest.Matchers.nullValue;  
            .startObject()  
            .endObject();
        XContentBuilder content = XContentFactory.jsonBuilder()
                    + PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName()
            factory.sigma(randomDoubleBetween(0.0, 10.0, false));
}  
            .endObject()
        assertThat(  
            equalTo(
                    + " must be a multi-bucket aggregation for aggregation [name] found :"  
