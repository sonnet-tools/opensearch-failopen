 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
        // First try to point to a non-existent agg
        assertThat(  
            equalTo(  
 * license agreements. See the NOTICE file distributed with
        assertThat(
    }
}
import java.util.Set;
/*  
import static org.hamcrest.Matchers.equalTo;  
    protected AvgBucketPipelineAggregationBuilder doCreateTestAggregatorFactory(String name, String bucketsPath) {  
        // Now try to point to a valid multi-bucket agg which is valid  
                    + " aggregation does not exist for aggregation [name]: invalid_agg>metric;"
 * Modifications Copyright OpenSearch Contributors. See
/*  
 */
            validate(aggBuilders, new AvgBucketPipelineAggregationBuilder("name", "global>metric")),
public class AvgBucketTests extends AbstractBucketMetricsTestCase<AvgBucketPipelineAggregationBuilder> {  
            validate(aggBuilders, new AvgBucketPipelineAggregationBuilder("name", "invalid_agg>metric")),
                    + " for buckets path: global>metric;"
        return new AvgBucketPipelineAggregationBuilder(name, bucketsPath);
        aggBuilders.add(multiBucketAgg);  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + GlobalAggregationBuilder.class.getName()
        aggBuilders.add(singleBucketAgg);
                "Validation Failed: 1: The first aggregation in "
 * You may obtain a copy of the License at  
 *
    }
 *  
package org.opensearch.search.aggregations.pipeline;
            )  
 *
 * under the License.  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
        AggregationBuilder singleBucketAgg = new GlobalAggregationBuilder("global");
                    + PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName()
        AggregationBuilder multiBucketAgg = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.STRING);  
import org.opensearch.search.aggregations.support.ValueType;
 * SPDX-License-Identifier: Apache-2.0
        assertThat(validate(aggBuilders, new AvgBucketPipelineAggregationBuilder("name", "terms>metric")), nullValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // Now try to point to a single bucket agg  
        final Set<AggregationBuilder> aggBuilders = new HashSet<>();
 * The OpenSearch Contributors require contributions made to  
    @Override
 * ownership. Elasticsearch licenses this file to you under  
    public void testValidate() {
 */  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
/*
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
                    + PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName()
        );
            )  
                "Validation Failed: 1: "  
        );
            equalTo(
 * compatible open source license.
import java.util.HashSet;  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
                    + " must be a multi-bucket aggregation for aggregation [name] found :"  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
import org.opensearch.search.aggregations.AggregationBuilder;
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
