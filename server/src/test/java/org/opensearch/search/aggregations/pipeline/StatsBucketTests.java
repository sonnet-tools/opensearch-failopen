 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        aggBuilders.add(singleBucketAgg);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
                "Validation Failed: 1: The first aggregation in "
        AggregationBuilder singleBucketAgg = new GlobalAggregationBuilder("global");
import java.util.Set;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
        // First try to point to a non-existent agg
 */
        // Now try to point to a single bucket agg  
 * this work for additional information regarding copyright
                    + " aggregation does not exist for aggregation [name]: invalid_agg>metric;"
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.AggregationBuilder;
 *
        AggregationBuilder multiBucketAgg = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.STRING);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.hamcrest.Matchers.nullValue;
        // Now try to point to a valid multi-bucket agg  
        assertThat(validate(aggBuilders, new StatsBucketPipelineAggregationBuilder("name", "terms>metric")), nullValue());
 * ownership. Elasticsearch licenses this file to you under  
                    + " must be a multi-bucket aggregation for aggregation [name] found :"  
 * GitHub history for details.
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
    protected StatsBucketPipelineAggregationBuilder doCreateTestAggregatorFactory(String name, String bucketsPath) {  
    }
            equalTo(
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
/*  
 * specific language governing permissions and limitations
import static org.hamcrest.Matchers.equalTo;  
public class StatsBucketTests extends AbstractBucketMetricsTestCase<StatsBucketPipelineAggregationBuilder> {  
            equalTo(  
            )  
        assertThat(  
        );
package org.opensearch.search.aggregations.pipeline;
}
        );
    @Override
        final Set<AggregationBuilder> aggBuilders = new HashSet<>();
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
    }
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + GlobalAggregationBuilder.class.getName()
 * Licensed to Elasticsearch under one or more contributor  
 *
        return new StatsBucketPipelineAggregationBuilder(name, bucketsPath);
            )  
 */  
                    + PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName()
                "Validation Failed: 1: "  
import java.util.HashSet;  
            validate(aggBuilders, new StatsBucketPipelineAggregationBuilder("name", "invalid_agg>metric")),
        assertThat(
        aggBuilders.add(multiBucketAgg);  
    public void testValidate() {
            validate(aggBuilders, new StatsBucketPipelineAggregationBuilder("name", "global>metric")),
/*
 * You may obtain a copy of the License at  
 *  
 */  
                    + " for buckets path: global>metric;"
                    + PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName()
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.support.ValueType;
