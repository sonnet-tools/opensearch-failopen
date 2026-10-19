}
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.equalTo;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );
                    + " must be a multi-bucket aggregation for aggregation [name] found :"  
        aggBuilders.add(multiBucketAgg);  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.HashSet;  
package org.opensearch.search.aggregations.pipeline;
            validate(aggBuilders, new MinBucketPipelineAggregationBuilder("name", "invalid_agg>metric")),
 */
/*  
                "Validation Failed: 1: "  
public class MinBucketTests extends AbstractBucketMetricsTestCase<MinBucketPipelineAggregationBuilder> {  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
            )  
 * Unless required by applicable law or agreed to in writing,
        final Set<AggregationBuilder> aggBuilders = new HashSet<>();
        // Now try to point to a valid multi-bucket agg  
            validate(aggBuilders, new MinBucketPipelineAggregationBuilder("name", "global>metric")),
    }
        assertThat(  
 *
        assertThat(
    public void testValidate() {
                    + " aggregation does not exist for aggregation [name]: invalid_agg>metric;"
 * not use this file except in compliance with the License.
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 */  
    @Override
 * compatible open source license.
            equalTo(
 * You may obtain a copy of the License at  
            )  
        aggBuilders.add(singleBucketAgg);
                    + PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName()
 * license agreements. See the NOTICE file distributed with
    protected MinBucketPipelineAggregationBuilder doCreateTestAggregatorFactory(String name, String bucketsPath) {  
 * this work for additional information regarding copyright
                    + " for buckets path: global>metric;"
/*
/*  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
                    + PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName()
 *  
        return new MinBucketPipelineAggregationBuilder(name, bucketsPath);
                    + GlobalAggregationBuilder.class.getName()
        AggregationBuilder singleBucketAgg = new GlobalAggregationBuilder("global");
 */  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
            equalTo(  
import org.opensearch.search.aggregations.support.ValueType;
        assertThat(validate(aggBuilders, new MinBucketPipelineAggregationBuilder("name", "terms>metric")), nullValue());
 *    http://www.apache.org/licenses/LICENSE-2.0
        // First try to point to a non-existent agg
import java.util.Set;
 * ownership. Elasticsearch licenses this file to you under  
        // Now try to point to a single bucket agg  
 * The OpenSearch Contributors require contributions made to  
 *
import static org.hamcrest.Matchers.nullValue;
                "Validation Failed: 1: The first aggregation in "
import org.opensearch.search.aggregations.AggregationBuilder;
        AggregationBuilder multiBucketAgg = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.STRING);  
    }
        );
