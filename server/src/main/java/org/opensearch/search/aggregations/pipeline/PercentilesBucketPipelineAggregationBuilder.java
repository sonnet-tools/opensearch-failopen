 * Unless required by applicable law or agreed to in writing,
            } else if (KEYED_FIELD.match(field, parser.getDeprecationHandler()) && token == XContentParser.Token.VALUE_BOOLEAN) {
            if (p == null || p < 0.0 || p > 100.0) {
 *
        keyed = in.readBoolean();
    public String getWriteableName() {
        return NAME;
        for (Double p : percents) {
        if (this == obj) return true;
        }
 */
                return true;
                    percents.add(parser.doubleValue());
    PercentilesBucketPipelineAggregationBuilder> {
    }
        return Objects.hash(super.hashCode(), Arrays.hashCode(percents), keyed);
        }
        this.keyed = keyed;
    private boolean keyed = true;
    static final ParseField KEYED_FIELD = new ParseField("keyed");
        super(in, NAME);
 * GitHub history for details.
 * compatible open source license.
     */
 * under the License.
import java.util.Map;
            return factory;
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
    }
     * Set whether the XContent should be keyed
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
            }
     */
 * not use this file except in compliance with the License.
    }
    public PercentilesBucketPipelineAggregationBuilder setPercents(double[] percents) {
 * ownership. Elasticsearch licenses this file to you under
            }
}
    }
        out.writeBoolean(keyed);
public class PercentilesBucketPipelineAggregationBuilder extends BucketMetricsPipelineAggregationBuilder<
            double[] percents = (double[]) params.get(PERCENTS_FIELD.getPreferredName());
    public boolean equals(Object obj) {
        super(name, NAME, new String[] { bucketsPath });
 * Modifications Copyright OpenSearch Contributors. See
            String pipelineAggregatorName,
    @Override
            builder.array(PERCENTS_FIELD.getPreferredName(), percents);
            Boolean keyed = (Boolean) params.get(KEYED_FIELD.getPreferredName());
        super.validate(context);
     * Set the percentages to calculate percentiles for in this aggregation
        if (super.equals(obj) == false) return false;
            Map<String, Object> params
import java.util.Objects;
                factory.setKeyed(keyed);
        return percents;
        ) {
 */
    public static final String NAME = "percentiles_bucket";
package org.opensearch.search.aggregations.pipeline;
import org.opensearch.core.common.io.stream.StreamOutput;
    public PercentilesBucketPipelineAggregationBuilder setKeyed(boolean keyed) {
        for (Double p : percents) {
    /**
            PercentilesBucketPipelineAggregationBuilder factory = new PercentilesBucketPipelineAggregationBuilder(
                );
     */
    }
 * You may obtain a copy of the License at
import org.opensearch.core.common.io.stream.StreamInput;
                    PERCENTS_FIELD.getPreferredName() + " must only contain non-null doubles from 0.0-100.0 inclusive"
                throw new IllegalArgumentException(
    static final ParseField PERCENTS_FIELD = new ParseField("percents");
 *    http://www.apache.org/licenses/LICENSE-2.0
            if (percents != null) {
    @Override
                context.addValidationError(
        return builder;
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
                pipelineAggregatorName,
     */
        }
    /**
            }
            );
import java.io.IOException;
                factory.setPercents(percents);
 * SPDX-License-Identifier: Apache-2.0
    @Override
    @Override
    public double[] getPercents() {
            throw new IllegalArgumentException("[percents] must not be null: [" + name + "]");
    /**
        }
                params.put(PERCENTS_FIELD.getPreferredName(), percents.stream().mapToDouble(Double::doubleValue).toArray());
 * @opensearch.internal
    public static final PipelineAggregator.Parser PARSER = new BucketMetricsParser() {
import org.opensearch.core.xcontent.XContentBuilder;
                return;
     * Read from a stream.
/**
    }
                params.put(KEYED_FIELD.getPreferredName(), parser.booleanValue());
        return this;
            }
    /**
import java.util.List;
 *
    public boolean getKeyed() {
        return new PercentilesBucketPipelineAggregator(name, percents, keyed, bucketsPaths, gapPolicy(), formatter(), metadata);
            }
            throws IOException {
 *
 * The OpenSearch Contributors require contributions made to
 * Aggregation Builder for percentiles_bucket
        PercentilesBucketPipelineAggregationBuilder other = (PercentilesBucketPipelineAggregationBuilder) obj;
        }
 *
    }
    }
/*
    }
        return keyed;
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.ParseField;
        out.writeDoubleArray(percents);
                bucketsPath
/*
 */
            if (PERCENTS_FIELD.match(field, parser.getDeprecationHandler()) && token == XContentParser.Token.START_ARRAY) {
                final List<Double> percents = new ArrayList<>(10);
    protected PipelineAggregator createInternal(Map<String, Object> metadata) {
        return Objects.deepEquals(percents, other.percents) && Objects.equals(keyed, other.keyed);
    public PercentilesBucketPipelineAggregationBuilder(String name, String bucketsPath) {
            if (p == null || p < 0.0 || p > 100.0) {
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor
        @Override
import java.util.Arrays;
import java.util.ArrayList;
    protected void validate(ValidationContext context) {
        @Override
                while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
/*
                );
    @Override
    }
    @Override
    }
        if (obj == null || getClass() != obj.getClass()) return false;
    private double[] percents = new double[] { 1.0, 5.0, 25.0, 50.0, 75.0, 95.0, 99.0 };
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    PERCENTS_FIELD.getPreferredName() + " must only contain non-null doubles from 0.0-100.0 inclusive"
    @Override
    public PercentilesBucketPipelineAggregationBuilder(StreamInput in) throws IOException {
    };
        percents = in.readDoubleArray();
        protected PercentilesBucketPipelineAggregationBuilder buildFactory(
            return false;
        if (percents == null) {
     */
        builder.field(KEYED_FIELD.getPreferredName(), keyed);
     * Get the percentages to calculate percentiles for in this aggregation
        }
    protected void innerWriteTo(StreamOutput out) throws IOException {
    /**
 * license agreements. See the NOTICE file distributed with
    public int hashCode() {
     * Get whether the XContent should be keyed
        protected boolean token(XContentParser parser, String field, XContentParser.Token token, Map<String, Object> params)
            if (keyed != null) {
        return this;
                return true;
        if (percents != null) {
            String bucketsPath,
                }
        this.percents = percents;
 */
    }
 * this work for additional information regarding copyright
    }
