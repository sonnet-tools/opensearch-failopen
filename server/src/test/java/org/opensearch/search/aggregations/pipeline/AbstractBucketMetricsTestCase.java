 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
public abstract class AbstractBucketMetricsTestCase<PAF extends BucketMetricsPipelineAggregationBuilder<PAF>> extends
            factory.gapPolicy(randomFrom(GapPolicy.values()));
        String bucketsPath = randomAlphaOfLengthBetween(3, 20);
/*  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
        return factory;  
 * this work for additional information regarding copyright
 *  
        }
        if (randomBoolean()) {  
 * Modifications Copyright OpenSearch Contributors. See
/*
 */
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
            factory.format(randomAlphaOfLengthBetween(1, 10));
 *
}
 */  
        String name = randomAlphaOfLengthBetween(3, 20);  
/*  
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.pipeline.BucketHelpers.GapPolicy;
 */  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
 * You may obtain a copy of the License at  
    @Override
import org.opensearch.search.aggregations.BasePipelineAggregationTestCase;
 * specific language governing permissions and limitations
 * under the License.  
package org.opensearch.search.aggregations.pipeline;
    protected abstract PAF doCreateTestAggregatorFactory(String name, String bucketsPath);  
 * this file be licensed under the Apache-2.0 license or a
        }
 * The OpenSearch Contributors require contributions made to  
    BasePipelineAggregationTestCase<PAF> {
    protected final PAF createTestAggregatorFactory() {
 * ownership. Elasticsearch licenses this file to you under  
        PAF factory = doCreateTestAggregatorFactory(name, bucketsPath);
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
        if (randomBoolean()) {  
