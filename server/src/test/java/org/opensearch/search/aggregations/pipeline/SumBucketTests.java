 * this work for additional information regarding copyright
        AggregationBuilder multiBucketAgg = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.STRING);  
            validate(aggBuilders, new SumBucketPipelineAggregationBuilder("name", "invalid_agg>metric")),
/*  
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
        );
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    + " must be a multi-bucket aggregation for aggregation [name] found :"  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
 *
 */  
 * compatible open source license.
    @Override
        assertThat(validate(aggBuilders, new SumBucketPipelineAggregationBuilder("name", "terms>metric")), nullValue());
            )  
                    + PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName()
                    + " for buckets path: global>metric;"
 *
                    + PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName()
        return new SumBucketPipelineAggregationBuilder(name, bucketsPath);
        // Now try to point to a single bucket agg  
import static org.hamcrest.Matchers.equalTo;  
        // First try to point to a non-existent agg
 */
                    + GlobalAggregationBuilder.class.getName()
 * KIND, either express or implied.  See the License for the
    }
 * SPDX-License-Identifier: Apache-2.0
        aggBuilders.add(multiBucketAgg);  
import java.util.Set;
 * GitHub history for details.
            equalTo(  
import java.util.HashSet;  
        assertThat(
            )  
        assertThat(  
 * software distributed under the License is distributed on an
        );
        // Now try to point to a valid multi-bucket agg  
 * Modifications Copyright OpenSearch Contributors. See
/*
    protected SumBucketPipelineAggregationBuilder doCreateTestAggregatorFactory(String name, String bucketsPath) {  
                "Validation Failed: 1: "  
public class SumBucketTests extends AbstractBucketMetricsTestCase<SumBucketPipelineAggregationBuilder> {  
 *  
import org.opensearch.search.aggregations.support.ValueType;
import org.opensearch.search.aggregations.AggregationBuilder;
 * You may obtain a copy of the License at  
import static org.hamcrest.Matchers.nullValue;
 */  
    public void testValidate() {
        final Set<AggregationBuilder> aggBuilders = new HashSet<>();
                "Validation Failed: 1: The first aggregation in "
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
            validate(aggBuilders, new SumBucketPipelineAggregationBuilder("name", "global>metric")),
}
 * under the License.  
            equalTo(
                    + " aggregation does not exist for aggregation [name]: invalid_agg>metric;"
        AggregationBuilder singleBucketAgg = new GlobalAggregationBuilder("global");
package org.opensearch.search.aggregations.pipeline;
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
        aggBuilders.add(singleBucketAgg);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
    }
/*  
