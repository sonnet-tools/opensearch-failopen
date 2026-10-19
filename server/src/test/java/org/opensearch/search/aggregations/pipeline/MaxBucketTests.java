 * GitHub history for details.
                "Validation Failed: 1: "  
 * Unless required by applicable law or agreed to in writing,
                "Validation Failed: 1: The first aggregation in "
                    + GlobalAggregationBuilder.class.getName()
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(
        return new MaxBucketPipelineAggregationBuilder(name, bucketsPath);
    public void testValidate() {
import org.opensearch.search.aggregations.AggregationBuilder;
                    + PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName()
                    + PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName()
import java.util.Set;
            validate(aggBuilders, new MaxBucketPipelineAggregationBuilder("name", "global>metric")),
    }
                    + " for buckets path: global>metric;"
 *
 *  
 * compatible open source license.
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
                    + " must be a multi-bucket aggregation for aggregation [name] found :"  
        );
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}
            equalTo(  
        // Now try to point to a single bucket agg  
 * Modifications Copyright OpenSearch Contributors. See
    }
            equalTo(
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.nullValue;
        // Now try to point to a valid multi-bucket agg  
package org.opensearch.search.aggregations.pipeline;
            )  
 * You may obtain a copy of the License at  
            )  
/*
            validate(aggBuilders, new MaxBucketPipelineAggregationBuilder("name", "invalid_agg>metric")),
        assertThat(  
public class MaxBucketTests extends AbstractBucketMetricsTestCase<MaxBucketPipelineAggregationBuilder> {  
                    + " aggregation does not exist for aggregation [name]: invalid_agg>metric;"
        AggregationBuilder multiBucketAgg = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.STRING);  
 */
import org.opensearch.search.aggregations.support.ValueType;
 * specific language governing permissions and limitations
import java.util.HashSet;  
        final Set<AggregationBuilder> aggBuilders = new HashSet<>();
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
        aggBuilders.add(multiBucketAgg);  
        // First try to point to a non-existent agg
        assertThat(validate(aggBuilders, new MaxBucketPipelineAggregationBuilder("name", "terms>metric")), nullValue());
 * not use this file except in compliance with the License.
        AggregationBuilder singleBucketAgg = new GlobalAggregationBuilder("global");
 * KIND, either express or implied.  See the License for the
    @Override
 * this file be licensed under the Apache-2.0 license or a
/*  
 *
 */  
/*  
        aggBuilders.add(singleBucketAgg);
 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.equalTo;  
 * ownership. Elasticsearch licenses this file to you under  
    protected MaxBucketPipelineAggregationBuilder doCreateTestAggregatorFactory(String name, String bucketsPath) {  
        );
