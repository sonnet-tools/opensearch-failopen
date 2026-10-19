import java.util.List;
            public String getName() {  
 * Licensed to Elasticsearch under one or more contributor  
        };
            public Object getProperty(String containingAggName, List<String> path) {
            }  
            @Override  
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.search.aggregations.pipeline;
            }  
                return null;
import org.opensearch.search.aggregations.AggregationExecutionException;  
            AggregationExecutionException.class,
                return null;  
                return null;
            e.getMessage(),  
            }
                    + "metric aggregation, got: [Object[]] at aggregation [foo]"
                return null;
        InternalMultiBucketAggregation.InternalBucket bucket = new InternalMultiBucketAggregation.InternalBucket() {
            public Map<String, Object> getMetadata() {
 * not use this file except in compliance with the License.
            @Override  
import org.opensearch.core.common.io.stream.StreamOutput;
            @Override
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            }
                return "foo";
 */
        MultiBucketsAggregation agg = new MultiBucketsAggregation() {
import org.opensearch.search.aggregations.InternalMultiBucketAggregation;
                "buckets_path must reference either a number value or a single value numeric "  
        AggregationExecutionException e = expectThrows(
            }
    public void testReturnsObjectArray() {
 * compatible open source license.
            public Object getKey() {
            @Override
 *
            () -> BucketHelpers.resolveBucketValue(agg, bucket, "foo>bar", BucketHelpers.GapPolicy.SKIP)
        );
 * specific language governing permissions and limitations
                return mock(InternalTDigestPercentiles.class);
/*  
 *
            public Object getKey() {  
 * SPDX-License-Identifier: Apache-2.0
            public String getName() {
 * Modifications Copyright OpenSearch Contributors. See
                return null;  
import org.opensearch.core.xcontent.XContentBuilder;
                return null;  
            public void writeTo(StreamOutput out) throws IOException {
            public Object getProperty(String containingAggName, List<String> path) {
            @Override  
 *  
            @Override
 * GitHub history for details.
public class BucketHelpersTests extends OpenSearchTestCase {
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.search.aggregations.Aggregations;
            }
            @Override  
        MultiBucketsAggregation agg = new MultiBucketsAggregation() {  
                return null;
            @Override
            }
            @Override
 * under the License.  
 * license agreements. See the NOTICE file distributed with
        );  
                "buckets_path must reference either a number value or a single value numeric "
            }
            )
import org.opensearch.search.aggregations.metrics.InternalTDigestPercentiles;
            @Override
            }  
 * Unless required by applicable law or agreed to in writing,
        AggregationExecutionException e = expectThrows(  
            equalTo(
 *    http://www.apache.org/licenses/LICENSE-2.0
            public String getType() {
                return null;  
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;  
            public Aggregations getAggregations() {  
/*
 * this file be licensed under the Apache-2.0 license or a
 */  
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            equalTo(
            }  
            }
 * software distributed under the License is distributed on an
            }
            public void writeTo(StreamOutput out) throws IOException {
            }  
 * The OpenSearch Contributors require contributions made to  
/*  
}
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            @Override  
            }  
            }  
            public Aggregations getAggregations() {
    }
                return null;
 * the Apache License, Version 2.0 (the "License"); you may
    }  
            @Override
import static org.mockito.Mockito.mock;  
            }
            @Override
            )
            }  
                return null;
                return null;
 */  
            @Override
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
                return new Object[0];  
            }
            }
            }
 * this work for additional information regarding copyright
            public long getDocCount() {
        assertThat(
                return null;  
        assertThat(  
                return null;
            public List<? extends Bucket> getBuckets() {
                    + "metric aggregation, but [foo] contains multiple values. Please specify which to use."  
 * KIND, either express or implied.  See the License for the
            @Override
            AggregationExecutionException.class,
        );
            @Override
            @Override  
            @Override  
        };  
        };
            public List<? extends Bucket> getBuckets() {
                return 0;  
            public String getType() {  
    public void testReturnMultiValueObject() {  
 * You may obtain a copy of the License at  
                return null;
            @Override
            @Override
            public long getDocCount() {
            () -> BucketHelpers.resolveBucketValue(agg, bucket, "foo>bar", BucketHelpers.GapPolicy.SKIP)  
            @Override
            }
            e.getMessage(),
            public String getKeyAsString() {
import org.opensearch.test.OpenSearchTestCase;
            public String getKeyAsString() {  
                return 0;
        };
            @Override  
import java.io.IOException;
            @Override  
            public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            }
        );  
            }
                return null;
            @Override
                return null;
            public Map<String, Object> getMetadata() {
                return "foo";
        InternalMultiBucketAggregation.InternalBucket bucket = new InternalMultiBucketAggregation.InternalBucket() {  
import java.util.Map;  
