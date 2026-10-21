     * Unlike the other moving averages, Holt-Linear has forecasting/prediction built into the algorithm.
        switch ((int) (Math.random() * 2)) {
 *
                return new HoltLinearModel(newValue, this.beta);
        builder.field("beta", beta);
        builder.startObject(MovAvgPipelineAggregationBuilder.SETTINGS.getPreferredName());
        out.writeDouble(beta);
         * Alpha controls the smoothing of the data.  Alpha = 1 retains no memory of past values
    private static final double DEFAULT_BETA = 0.1;
import java.util.Collection;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public HoltLinearModel(StreamInput in) throws IOException {
    }
        private double beta = DEFAULT_BETA;
        out.writeDouble(alpha);
    }
        /**
         * @param alpha A double between 0-1 inclusive, controls data smoothing
package org.opensearch.search.aggregations.pipeline;
     * Calculate a Holt-Linear (doubly exponential weighted) moving average
     * Predicts the next `n` values in the series, using the smoothing model to generate new values.
 * under the License.
/**
     *
    /**
        @Override
    }
         */
 * software distributed under the License is distributed on an
            return this;
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to
 * Modifications Copyright OpenSearch Contributors. See
    /**
        this(DEFAULT_ALPHA, DEFAULT_BETA);
        HoltLinearModel other = (HoltLinearModel) obj;
 * specific language governing permissions and limitations
    public MovAvgModel clone() {
 */
 * this work for additional information regarding copyright
            this.alpha = alpha;
         * @param beta a double between 0-1 inclusive, controls trend smoothing
     */
        public HoltLinearModelBuilder alpha(double alpha) {
            this.beta = beta;
                return new HoltLinearModel(newValue, this.beta);    // This should never technically happen...
    public HoltLinearModel() {
 * the Apache License, Version 2.0 (the "License"); you may
         * @return The builder to continue chaining
        return Objects.equals(alpha, other.alpha) && Objects.equals(beta, other.beta);
     * Controls smoothing of data.  Also known as "level" value.
    @Override
 *
         *
         *
            default:
    public int hashCode() {
     */
     */
    /**
                return new HoltLinearModel(this.alpha, newValue);
        this.beta = beta;
     * Prediction is more than simply adding the next prediction to the window and repeating.  Holt-Linear
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * license agreements. See the NOTICE file distributed with
    @Override
/*
import org.opensearch.core.common.io.stream.StreamInput;
            builder.startObject(MovAvgPipelineAggregationBuilder.SETTINGS.getPreferredName());
         * the series mean).  Useful values are somewhere in between.  Defaults to 0.5.
            case 0:
        public MovAvgModel build() {
     */
        return next(values, 1)[0];
    /**
    public boolean equals(Object obj) {
    public String getWriteableName() {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return new HoltLinearModel(this.alpha, this.beta);
    }
        return MovingFunctions.holtForecast(values.stream().mapToDouble(Double::doubleValue).toArray(), alpha, beta, numForecasts);
    private final double beta;
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor
    protected double[] doPredict(Collection<Double> values, int numPredictions) {
            case 1:
/*
        public MovAvgModel parse(@Nullable Map<String, Object> settings, String pipelineName, int windowSize) throws ParseException {
     *
    }
 * compatible open source license.
    public void writeTo(StreamOutput out) throws IOException {
    }
            double beta = parseDoubleParam(settings, "beta", DEFAULT_BETA);
     * will extrapolate into the future by applying the trend information to the smoothed data.
     *
    @Override
 */
    public double next(Collection<Double> values) {
    @Override
         * (e.g. a random walk), while alpha = 0 retains infinite memory of past values (e.g.
 * You may obtain a copy of the License at
        return Objects.hash(alpha, beta);
            return false;
     * Builder for the holt linear model
    public boolean canBeMinimized() {
    public MovAvgModel neighboringModel() {
    public HoltLinearModel(double alpha, double beta) {
    public double[] next(Collection<Double> values, int numForecasts) {
        return NAME;
    @Override
        }
import java.text.ParseException;
     * Beta = 1 retains no memory of past values
    };
import java.util.Map;
    @Override
        double newValue = Math.random();
        builder.endObject();
        }
    }
public class HoltLinearModel extends MovAvgModel {
import org.opensearch.common.Nullable;
 * Calculate a doubly exponential weighted moving average
        return builder;
     * @param numForecasts number of forecasts into the future to return
    }
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override
    private static final double DEFAULT_ALPHA = 0.3;
 * Unless required by applicable law or agreed to in writing,
        if (values.size() == 0) {
}
    }
            return false;
        private double alpha = DEFAULT_ALPHA;
            return this;
    }
            return new HoltLinearModel(alpha, beta);
            builder.field(MovAvgPipelineAggregationBuilder.MODEL.getPreferredName(), NAME);
        return next(values, numPredictions);
            builder.endObject();
    }
        /**
            double alpha = parseDoubleParam(settings, "alpha", DEFAULT_ALPHA);
         * @return The builder to continue chaining
     * @param values Collection of values to calculate avg for
        builder.field("alpha", alpha);
        beta = in.readDouble();
     * mean of the series).
    }
    }
        }
 */
     * (e.g. random walk), while alpha = 0 retains infinite memory of past values (e.g.
        }
    }
            builder.field("alpha", alpha);
     * Read from a stream.
     * @opensearch.internal
            checkUnrecognizedParams(settings);
 *
    public static final String NAME = "holt";
        this.alpha = alpha;
         *
    /**
 * SPDX-License-Identifier: Apache-2.0
        }
        return true;
 * this file be licensed under the Apache-2.0 license or a
        if (obj == null) {
import java.io.IOException;
        }
     * Alpha = 1 retains no memory of past values
    @Override
     * mean of the series).
import org.opensearch.core.common.io.stream.StreamOutput;
     * @param values            Collection of numerics to movingAvg, usually windowed
import org.opensearch.core.xcontent.XContentBuilder;
/*
         *
    /**
     * Controls smoothing of trend.
        @Override
        }
        alpha = in.readDouble();
        }
         * Equivalent to <code>alpha</code>, but controls the smoothing of the trend instead of the data
 */
        if (getClass() != obj.getClass()) {
            return builder;
        }
 * KIND, either express or implied.  See the License for the
 *
     * @param numPredictions    Number of newly generated predictions to return
            return new HoltLinearModel(alpha, beta);
 * not use this file except in compliance with the License.
    public static class HoltLinearModelBuilder implements MovAvgModelBuilder {
     *
    }
    private final double alpha;
        builder.field(MovAvgPipelineAggregationBuilder.MODEL.getPreferredName(), NAME);
    public static final AbstractModelParser PARSER = new AbstractModelParser() {
        public HoltLinearModelBuilder beta(double beta) {
    @Override
            builder.field("beta", beta);
     * (e.g. random walk), while alpha = 0 retains infinite memory of past values (e.g.
import java.util.Objects;
     */
                assert (false) : "Random value fell outside of range [0-1]";
     */
 * ownership. Elasticsearch licenses this file to you under
     * @return       Returns a Double containing the moving avg for the window
            return emptyPredictions(numForecasts);
    @Override
         */
     * @return                  Returns an array of doubles, since most smoothing methods operate on floating points
