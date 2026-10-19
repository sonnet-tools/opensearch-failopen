import java.util.HashSet;
 */
 * You may obtain a copy of the License at  
                    + PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName()
            for (int i = 0; i < numPercents; i++) {
 * specific language governing permissions and limitations
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        AggregationBuilder multiBucketAgg = new TermsAggregationBuilder("terms").userValueTypeHint(ValueType.STRING);  
import org.opensearch.search.aggregations.support.ValueType;  
        return factory;  
    protected PercentilesBucketPipelineAggregationBuilder doCreateTestAggregatorFactory(String name, String bucketsPath) {
    }
import org.opensearch.search.aggregations.AggregationBuilder;  
        PercentilesBucketPipelineAggregationBuilder factory = new PercentilesBucketPipelineAggregationBuilder(name, bucketsPath);  
        aggBuilders.add(singleBucketAgg);
 * Licensed to Elasticsearch under one or more contributor  
                percents[i] = randomDoubleBetween(0.0, 100.0, false);
 * KIND, either express or implied.  See the License for the
            validate(aggBuilders, new PercentilesBucketPipelineAggregationBuilder("name", "global>metric")),
            .startObject("name")  
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
        final Set<AggregationBuilder> aggBuilders = new HashSet<>();
            double[] percents = new double[numPercents];  
                    + " aggregation does not exist for aggregation [name]: invalid_agg>metric;"
        // Now try to point to a single bucket agg  
 * not use this file except in compliance with the License.
public class PercentilesBucketTests extends AbstractBucketMetricsTestCase<PercentilesBucketPipelineAggregationBuilder> {
            equalTo(  
            .startObject()
package org.opensearch.search.aggregations.pipeline;
                "Validation Failed: 1: The first aggregation in "
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        assertThat(validate(aggBuilders, new PercentilesBucketPipelineAggregationBuilder("name", "terms>metric")), nullValue());
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
                "Validation Failed: 1: "  
 *
            .array("percents", 0, 20.0, 50, 75.99)  
}  
import org.opensearch.common.xcontent.XContentFactory;
            )  
/*  
        if (randomBoolean()) {
        PercentilesBucketPipelineAggregationBuilder builder = (PercentilesBucketPipelineAggregationBuilder) parse(createParser(content));
    }
    @Override
 */  
            .startObject("percentiles_bucket")
import org.opensearch.core.xcontent.XContentBuilder;
            equalTo(
            .field("buckets_path", "test")
        }
import static org.hamcrest.Matchers.nullValue;  
 * Modifications Copyright OpenSearch Contributors. See
        // First try to point to a non-existent agg
        );
            }  
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
import static org.hamcrest.Matchers.equalTo;
 * The OpenSearch Contributors require contributions made to  
        // Now try to point to a valid multi-bucket agg  
        assertThat(  
/*  
    public void testValidate() {
 * SPDX-License-Identifier: Apache-2.0
        assertThat(
            int numPercents = randomIntBetween(1, 20);
            .endObject();  
 *
            )  
                    + PipelineAggregator.Parser.BUCKETS_PATH.getPreferredName()
        AggregationBuilder singleBucketAgg = new GlobalAggregationBuilder("global");
        aggBuilders.add(multiBucketAgg);  
        assertThat(builder.getPercents(), equalTo(new double[] { 0.0, 20.0, 50.0, 75.99 }));
                    + GlobalAggregationBuilder.class.getName()
                    + " for buckets path: global>metric;"
            .endObject()
 * this work for additional information regarding copyright
                    + " must be a multi-bucket aggregation for aggregation [name] found :"  
        XContentBuilder content = XContentFactory.jsonBuilder()
import org.opensearch.search.aggregations.bucket.global.GlobalAggregationBuilder;
 * compatible open source license.
            validate(aggBuilders, new PercentilesBucketPipelineAggregationBuilder("name", "invalid_agg>metric")),
            .endObject()
            factory.setPercents(percents);
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
    public void testPercentsFromMixedArray() throws Exception {  
import java.util.Set;  
 * license agreements. See the NOTICE file distributed with
 *  
    }
