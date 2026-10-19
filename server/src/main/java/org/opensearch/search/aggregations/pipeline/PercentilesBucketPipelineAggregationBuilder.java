        }
            throws IOException {
                pipelineAggregatorName,
            return false;
        this.keyed = keyed;
    private boolean keyed = true;
import org.opensearch.core.ParseField;
    }  
     */
 * GitHub history for details.
    static final ParseField PERCENTS_FIELD = new ParseField("percents");
    }  
        }  
        super(name, NAME, new String[] { bucketsPath });
    }
    public static final PipelineAggregator.Parser PARSER = new BucketMetricsParser() {  
        }
/*
        builder.field(KEYED_FIELD.getPreferredName(), keyed);
    protected PipelineAggregator createInternal(Map<String, Object> metadata) {
        }
            if (p == null || p < 0.0 || p > 100.0) {
    public PercentilesBucketPipelineAggregationBuilder setPercents(double[] percents) {  
import org.opensearch.core.common.io.stream.StreamInput;
 * Modifications Copyright OpenSearch Contributors. See
        if (super.equals(obj) == false) return false;  
    public static final String NAME = "percentiles_bucket";  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
        return Objects.hash(super.hashCode(), Arrays.hashCode(percents), keyed);
    public int hashCode() {
                );
/*  
            String bucketsPath,
 */  
import java.util.List;
                context.addValidationError(
        return percents;  
 */  
    public boolean equals(Object obj) {  
    }
    /**
            Map<String, Object> params  
 * not use this file except in compliance with the License.
            builder.array(PERCENTS_FIELD.getPreferredName(), percents);  
    protected void innerWriteTo(StreamOutput out) throws IOException {  
            if (percents != null) {  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
                while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
            if (p == null || p < 0.0 || p > 100.0) {  
        for (Double p : percents) {
                }  
    public PercentilesBucketPipelineAggregationBuilder(String name, String bucketsPath) {
                factory.setKeyed(keyed);
import org.opensearch.core.xcontent.XContentBuilder;
        keyed = in.readBoolean();
/*  
                    PERCENTS_FIELD.getPreferredName() + " must only contain non-null doubles from 0.0-100.0 inclusive"
    }  
            throw new IllegalArgumentException("[percents] must not be null: [" + name + "]");
import java.util.ArrayList;
        out.writeDoubleArray(percents);
 *  
import java.util.Map;
        if (percents != null) {
        for (Double p : percents) {
        percents = in.readDoubleArray();
 * this work for additional information regarding copyright
    }
    static final ParseField KEYED_FIELD = new ParseField("keyed");
 * specific language governing permissions and limitations
}  
    public double[] getPercents() {
 */
            }
 * KIND, either express or implied.  See the License for the
            PercentilesBucketPipelineAggregationBuilder factory = new PercentilesBucketPipelineAggregationBuilder(  
                params.put(KEYED_FIELD.getPreferredName(), parser.booleanValue());
            }
            double[] percents = (double[]) params.get(PERCENTS_FIELD.getPreferredName());
import org.opensearch.core.common.io.stream.StreamOutput;  
                bucketsPath
 * compatible open source license.
    /**
    };
                return true;
 *
import java.util.Objects;  
            }  
    /**  
    }  
            if (PERCENTS_FIELD.match(field, parser.getDeprecationHandler()) && token == XContentParser.Token.START_ARRAY) {
     */
        return keyed;  
                params.put(PERCENTS_FIELD.getPreferredName(), percents.stream().mapToDouble(Double::doubleValue).toArray());
            );  
    private double[] percents = new double[] { 1.0, 5.0, 25.0, 50.0, 75.0, 95.0, 99.0 };
 * under the License.  
        return builder;  
 * license agreements. See the NOTICE file distributed with
     * Set whether the XContent should be keyed
        super(in, NAME);  
    }
     * Set the percentages to calculate percentiles for in this aggregation
    @Override
                );  
 * ownership. Elasticsearch licenses this file to you under  
        protected PercentilesBucketPipelineAggregationBuilder buildFactory(  
        PercentilesBucketPipelineAggregationBuilder other = (PercentilesBucketPipelineAggregationBuilder) obj;
        if (obj == null || getClass() != obj.getClass()) return false;
        return Objects.deepEquals(percents, other.percents) && Objects.equals(keyed, other.keyed);
        }  
    public PercentilesBucketPipelineAggregationBuilder setKeyed(boolean keyed) {  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    @Override
    public PercentilesBucketPipelineAggregationBuilder(StreamInput in) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 * Aggregation Builder for percentiles_bucket  
        return NAME;
        }  
            String pipelineAggregatorName,
            } else if (KEYED_FIELD.match(field, parser.getDeprecationHandler()) && token == XContentParser.Token.VALUE_BOOLEAN) {  
                return;
    }
                    PERCENTS_FIELD.getPreferredName() + " must only contain non-null doubles from 0.0-100.0 inclusive"
        return this;
            if (keyed != null) {
import org.opensearch.core.xcontent.XContentParser;
    public String getWriteableName() {  
            }  
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
/**
        return new PercentilesBucketPipelineAggregator(name, percents, keyed, bucketsPaths, gapPolicy(), formatter(), metadata);
     * Get the percentages to calculate percentiles for in this aggregation  
                    percents.add(parser.doubleValue());
    }  
import java.util.Arrays;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super.validate(context);
     * Get whether the XContent should be keyed  
        return this;  
    PercentilesBucketPipelineAggregationBuilder> {
        protected boolean token(XContentParser parser, String field, XContentParser.Token token, Map<String, Object> params)  
                throw new IllegalArgumentException(  
                factory.setPercents(percents);
import java.io.IOException;
    /**
package org.opensearch.search.aggregations.pipeline;
        this.percents = percents;
    }  
                final List<Double> percents = new ArrayList<>(10);  
    public boolean getKeyed() {
        ) {
            return factory;
        if (percents == null) {
    @Override  
    @Override  
     */
    }  
        @Override
        out.writeBoolean(keyed);
 * SPDX-License-Identifier: Apache-2.0
 *
     * Read from a stream.  
 * @opensearch.internal
            }  
        @Override
    protected void validate(ValidationContext context) {  
    @Override
 *
            Boolean keyed = (Boolean) params.get(KEYED_FIELD.getPreferredName());  
 * software distributed under the License is distributed on an
public class PercentilesBucketPipelineAggregationBuilder extends BucketMetricsPipelineAggregationBuilder<
 * The OpenSearch Contributors require contributions made to  
                return true;
 */  
 * You may obtain a copy of the License at  
     */
        if (this == obj) return true;
    /**  
    }
