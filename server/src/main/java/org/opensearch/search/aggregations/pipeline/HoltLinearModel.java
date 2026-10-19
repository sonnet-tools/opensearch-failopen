        if (values.size() == 0) {  
     * (e.g. random walk), while alpha = 0 retains infinite memory of past values (e.g.
        @Override  
 *
    public double next(Collection<Double> values) {
         *  
/*  
    private final double alpha;
     */
        @Override
    }  
    /**
     * Beta = 1 retains no memory of past values  
        return Objects.hash(alpha, beta);
        if (obj == null) {
import java.text.ParseException;
        this(DEFAULT_ALPHA, DEFAULT_BETA);
    /**  
     * Calculate a Holt-Linear (doubly exponential weighted) moving average
            this.beta = beta;  
    public HoltLinearModel(StreamInput in) throws IOException {  
        }
        }  
     */
 * license agreements. See the NOTICE file distributed with
     */  
         * Equivalent to <code>alpha</code>, but controls the smoothing of the trend instead of the data
        HoltLinearModel other = (HoltLinearModel) obj;
         *  
        }  
 * You may obtain a copy of the License at  
    };
         * the series mean).  Useful values are somewhere in between.  Defaults to 0.5.
    @Override
            return emptyPredictions(numForecasts);
 * Modifications Copyright OpenSearch Contributors. See
 *  
         * Alpha controls the smoothing of the data.  Alpha = 1 retains no memory of past values  
    private final double beta;
 * GitHub history for details.
        /**
    @Override  
        }  
    protected double[] doPredict(Collection<Double> values, int numPredictions) {  
        return MovingFunctions.holtForecast(values.stream().mapToDouble(Double::doubleValue).toArray(), alpha, beta, numForecasts);  
 * not use this file except in compliance with the License.
     * @return                  Returns an array of doubles, since most smoothing methods operate on floating points  
    private static final double DEFAULT_ALPHA = 0.3;
     * (e.g. random walk), while alpha = 0 retains infinite memory of past values (e.g.
         * @return The builder to continue chaining  
     * @return       Returns a Double containing the moving avg for the window  
            case 0:
import java.util.Collection;
        beta = in.readDouble();
        public HoltLinearModelBuilder alpha(double alpha) {
 *
import java.util.Objects;
            return new HoltLinearModel(alpha, beta);
    }
         */
     *
                return new HoltLinearModel(newValue, this.beta);
            double beta = parseDoubleParam(settings, "beta", DEFAULT_BETA);  
     * mean of the series).  
    }
     */  
public class HoltLinearModel extends MovAvgModel {
         * @return The builder to continue chaining  
 * The OpenSearch Contributors require contributions made to  
import java.io.IOException;  
            return false;
     *  
            checkUnrecognizedParams(settings);
            this.alpha = alpha;  
 * this work for additional information regarding copyright
         * (e.g. a random walk), while alpha = 0 retains infinite memory of past values (e.g.
 * software distributed under the License is distributed on an
        alpha = in.readDouble();
 * ownership. Elasticsearch licenses this file to you under  
    public static final AbstractModelParser PARSER = new AbstractModelParser() {
        return Objects.equals(alpha, other.alpha) && Objects.equals(beta, other.beta);
        builder.field("beta", beta);
 * under the License.  
     */
     * @param values            Collection of numerics to movingAvg, usually windowed
            builder.field("beta", beta);  
    /**  
     * Alpha = 1 retains no memory of past values
        builder.field(MovAvgPipelineAggregationBuilder.MODEL.getPreferredName(), NAME);
         */
            return builder;  
        if (getClass() != obj.getClass()) {
     * @opensearch.internal
    @Override
        public MovAvgModel build() {
            default:
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Read from a stream.
    @Override  
        this.alpha = alpha;
    }
        switch ((int) (Math.random() * 2)) {  
            return false;
        }
    public static class HoltLinearModelBuilder implements MovAvgModelBuilder {
     * Builder for the holt linear model  
    /**
    }  
    public boolean equals(Object obj) {  
    }
                return new HoltLinearModel(this.alpha, newValue);
        out.writeDouble(beta);
    }
 * Unless required by applicable law or agreed to in writing,
 *
}
            return this;
                assert (false) : "Random value fell outside of range [0-1]";  
    /**
    }
        }
    public boolean canBeMinimized() {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * Predicts the next `n` values in the series, using the smoothing model to generate new values.
        this.beta = beta;  
        double newValue = Math.random();
    public static final String NAME = "holt";  
        }  
        public MovAvgModel parse(@Nullable Map<String, Object> settings, String pipelineName, int windowSize) throws ParseException {  
        private double alpha = DEFAULT_ALPHA;
                return new HoltLinearModel(newValue, this.beta);    // This should never technically happen...
            builder.endObject();
import org.opensearch.core.xcontent.XContentBuilder;
        /**
    }  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
     * Unlike the other moving averages, Holt-Linear has forecasting/prediction built into the algorithm.  
    }
    public String getWriteableName() {  
     * @param values Collection of values to calculate avg for  
     *
    private static final double DEFAULT_BETA = 0.1;  
     * Controls smoothing of data.  Also known as "level" value.  
    @Override
        return new HoltLinearModel(this.alpha, this.beta);
        }
            return new HoltLinearModel(alpha, beta);
 * the Apache License, Version 2.0 (the "License"); you may
     */
 * Calculate a doubly exponential weighted moving average
    public void writeTo(StreamOutput out) throws IOException {  
         *
    public HoltLinearModel(double alpha, double beta) {
            builder.field("alpha", alpha);
 */  
 * Licensed to Elasticsearch under one or more contributor  
    public MovAvgModel clone() {  
        return next(values, numPredictions);
            return this;
        return next(values, 1)[0];  
    public MovAvgModel neighboringModel() {
     * @param numForecasts number of forecasts into the future to return
 * @opensearch.internal  
    public double[] next(Collection<Double> values, int numForecasts) {
    }  
         *
        return NAME;
        public HoltLinearModelBuilder beta(double beta) {
import org.opensearch.core.common.io.stream.StreamOutput;  
    @Override  
         * @param beta a double between 0-1 inclusive, controls trend smoothing
    public HoltLinearModel() {  
        builder.field("alpha", alpha);
    }
        out.writeDouble(alpha);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public int hashCode() {
import java.util.Map;  
    @Override
        builder.startObject(MovAvgPipelineAggregationBuilder.SETTINGS.getPreferredName());  
/*  
    }  
    @Override
     * Controls smoothing of trend.
     * Prediction is more than simply adding the next prediction to the window and repeating.  Holt-Linear
            builder.field(MovAvgPipelineAggregationBuilder.MODEL.getPreferredName(), NAME);  
     * @param numPredictions    Number of newly generated predictions to return
     * mean of the series).
     * will extrapolate into the future by applying the trend information to the smoothed data.
            case 1:  
         * @param alpha A double between 0-1 inclusive, controls data smoothing
 */  
        private double beta = DEFAULT_BETA;  
import org.opensearch.common.Nullable;
 */
    /**
        builder.endObject();  
package org.opensearch.search.aggregations.pipeline;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Override
/**  
        return builder;
    @Override
import org.opensearch.core.common.io.stream.StreamInput;
        }
            builder.startObject(MovAvgPipelineAggregationBuilder.SETTINGS.getPreferredName());
            double alpha = parseDoubleParam(settings, "alpha", DEFAULT_ALPHA);
 */
     *
    @Override
 * KIND, either express or implied.  See the License for the
    }
/*
        return true;  
