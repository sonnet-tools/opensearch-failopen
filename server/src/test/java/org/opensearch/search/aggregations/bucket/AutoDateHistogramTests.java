 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
        // TODO[PCS]: add builder pattern here
 */  
        }
    protected AutoDateHistogramAggregationBuilder createTestAggregatorBuilder() {
            builder.timeZone(randomZone());
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
import org.opensearch.search.aggregations.bucket.histogram.AutoDateHistogramAggregationBuilder;
/*
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
import org.opensearch.search.aggregations.BaseAggregationTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * not use this file except in compliance with the License.
    }
 */
        if (randomBoolean()) {  
/*  
        if (randomBoolean()) {  
 * this file be licensed under the Apache-2.0 license or a
        if (randomBoolean()) {  
package org.opensearch.search.aggregations.bucket;
        }
 * under the License.  
/*  
        AutoDateHistogramAggregationBuilder builder = new AutoDateHistogramAggregationBuilder(randomAlphaOfLengthBetween(1, 10));
public class AutoDateHistogramTests extends BaseAggregationTestCase<AutoDateHistogramAggregationBuilder> {
        builder.field(INT_FIELD_NAME);  
 * specific language governing permissions and limitations
        }
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
            builder.format("###.##");
 *
 *
        builder.setNumBuckets(randomIntBetween(1, 100000));
        return builder;  
}  
    @Override  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
            builder.missing(randomIntBetween(0, 10));
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
