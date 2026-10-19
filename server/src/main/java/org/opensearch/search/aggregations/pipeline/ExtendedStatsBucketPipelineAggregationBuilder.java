        return Objects.hash(super.hashCode(), sigma);  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamInput;
     * Read from a stream.
 * ownership. Elasticsearch licenses this file to you under  
    public String getWriteableName() {
    }
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
    @Override  
 * @opensearch.internal  
 * not use this file except in compliance with the License.
    public ExtendedStatsBucketPipelineAggregationBuilder(String name, String bucketsPath) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
        super.validate(context);
 *
     * bounds  
    }
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
        if (sigma < 0.0) {
    }
    }
    }
/**  
 *
 * Unless required by applicable law or agreed to in writing,
}
 * compatible open source license.
    /**
 */  
        return NAME;
        }
package org.opensearch.search.aggregations.pipeline;
    public static final String NAME = "extended_stats_bucket";
    public boolean equals(Object obj) {
    }  
 * this work for additional information regarding copyright
     * Set the value of sigma to use when calculating the standard deviation
    protected void innerWriteTo(StreamOutput out) throws IOException {  
    @Override
        out.writeDouble(sigma);
    protected PipelineAggregator createInternal(Map<String, Object> metadata) {
        if (obj == null || getClass() != obj.getClass()) return false;  
        return Objects.equals(sigma, other.sigma);  
     */
        this.sigma = sigma;  
        ExtendedStatsBucketPipelineAggregationBuilder other = (ExtendedStatsBucketPipelineAggregationBuilder) obj;
    public double sigma() {
 *  
        return builder;
 * You may obtain a copy of the License at  
     * Get the value of sigma to use when calculating the standard deviation
    }  
    }
 * Modifications Copyright OpenSearch Contributors. See
     */
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
 * under the License.  
public class ExtendedStatsBucketPipelineAggregationBuilder extends BucketMetricsPipelineAggregationBuilder<
    }
/*  
import org.opensearch.core.xcontent.XContentBuilder;  
 * GitHub history for details.
    @Override  
        if (sigma < 0.0) {  
    public ExtendedStatsBucketPipelineAggregationBuilder(StreamInput in) throws IOException {  
        if (this == obj) return true;
            throw new IllegalArgumentException(ExtendedStatsBucketParser.SIGMA.getPreferredName() + " must be a non-negative double");
        return this;
 * Aggregation Builder for extended_stats agg
 */
 * software distributed under the License is distributed on an
    }
/*
    public ExtendedStatsBucketPipelineAggregationBuilder sigma(double sigma) {
        }
 * the Apache License, Version 2.0 (the "License"); you may
        super(in, NAME);
 * The OpenSearch Contributors require contributions made to  
        sigma = in.readDouble();
     * bounds  
        return sigma;  
import java.util.Objects;
    @Override
    @Override
    }  
    private double sigma = 2.0;  
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;
     */
        super(name, NAME, new String[] { bucketsPath });  
import java.util.Map;  
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
    protected void validate(ValidationContext context) {  
/*  
        if (super.equals(obj) == false) return false;
 *
    public int hashCode() {
    @Override  
            context.addValidationError(ExtendedStatsBucketParser.SIGMA.getPreferredName() + " must be a non-negative double");  
        return new ExtendedStatsBucketPipelineAggregator(name, bucketsPaths, sigma, gapPolicy(), formatter(), metadata);
 * license agreements. See the NOTICE file distributed with
        builder.field(ExtendedStatsBucketParser.SIGMA.getPreferredName(), sigma);  
 */
 */  
    ExtendedStatsBucketPipelineAggregationBuilder> {  
    /**  
