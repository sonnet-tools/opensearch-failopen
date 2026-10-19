 * compatible open source license.
    /**
        public MovAvgModel parse(@Nullable Map<String, Object> settings, String pipelineName, int windowSize) throws ParseException {  
    @Override
     * Gamma = 1 retains no memory of past values
    }  
    public MovAvgModel neighboringModel() {
         *
    }
            return false;
    public boolean hasValue(int valuesAvailable) {
                assert (false) : "Random value fell outside of range [0-2]";
import java.io.IOException;  
        pad = in.readBoolean();  
            builder.field("period", period);
/**
     * Periodicity of the data  
    }  
         */
            double alpha = parseDoubleParam(settings, "alpha", DEFAULT_ALPHA);
         *
            builder.field("type", seasonalityType.getName());
        public String getName() {  
            this.seasonalityType = type;  
        public HoltWintersModelBuilder gamma(double gamma) {
    /**
                        throw new ParseException(
        if (getClass() != obj.getClass()) {  
                    validNames.add(policy.getName());
    /**
        }  
     */
    public MovAvgModel clone() {
         * @return                    SeasonalityType enum  
package org.opensearch.search.aggregations.pipeline;
         * @param text                SeasonalityType in string format (e.g. "add")
     * @opensearch.internal  
            for (SeasonalityType policy : values()) {
            beta,
        /**
        }
 * license agreements. See the NOTICE file distributed with
    private double inferPadding() {
            padding,
 */  
    }
        return valuesAvailable >= period * 2;  
        public HoltWintersModelBuilder pad(boolean pad) {
        MULTIPLICATIVE((byte) 1, "mult");  
        this.padding = inferPadding();  
 * SPDX-License-Identifier: Apache-2.0
        builder.field("type", seasonalityType.getName());
        builder.field("beta", beta);
     * with multiplicative seasonality math (e.g. division by zero)
     *
     * @param numPredictions    Number of newly generated predictions to return
        }
        /**
    /**
            throw new IllegalStateException("Unknown Seasonality Type with id [" + id + "]");
         */
     * Prediction is more than simply adding the next prediction to the window and repeating.  HoltWinters  
 *  
    /**
            builder.field("gamma", gamma);  
    /**  
                    } else {  
        alpha = in.readDouble();
            for (SeasonalityType seasonalityType : values()) {
            this.period = period;
     * Read from a stream.
        out.writeBoolean(pad);  
import org.opensearch.core.ParseField;
        beta = in.readDouble();
         * @param beta a double between 0-1 inclusive, controls trend smoothing
    protected void validate(long window, String aggregationName) {
     *
     * If the model is a HoltWinters, we need to ensure the window and period are compatible.
        @Nullable
    }  
 *
         */
        builder.field("alpha", alpha);  
        return true;  
            }
            }  
        // We need at least (period * 2) data-points (e.g. two "seasons")
        return NAME;
    }
         * the series mean).  Useful values are somewhere in between.  Defaults to 0.5.
     */
                }  
        }  
        public HoltWintersModelBuilder seasonalityType(SeasonalityType type) {
        public static SeasonalityType readFrom(StreamInput in) throws IOException {  
    public static final AbstractModelParser PARSER = new AbstractModelParser() {
        private final ParseField parseField;
    }
            return this;
     */  
     * mean of the series).
        this.beta = beta;
         * @param alpha A double between 0-1 inclusive, controls data smoothing
            default:
     * Builder for the holt winters model
        this.period = period;  
        private double gamma = DEFAULT_GAMMA;  
        public HoltWintersModelBuilder alpha(double alpha) {
import org.opensearch.core.common.io.stream.StreamOutput;  
    /**
         */
     */  
 * Licensed to Elasticsearch under one or more contributor  
         * @return The builder to continue chaining  
                        );
                return null;
 * @opensearch.internal
                builder.field("pad", pad);  
    /**
        public void writeTo(StreamOutput out) throws IOException {
    public boolean equals(Object obj) {
         * Return the english-formatted name of the SeasonalityType
        SeasonalityType(byte id, String name) {  
     * @return                  Returns an array of doubles, since most smoothing methods operate on floating points
        }
    private final boolean pad;
        seasonalityType.writeTo(out);
        ADDITIVE((byte) 0, "add"),
        private double alpha = DEFAULT_ALPHA;
            && Objects.equals(seasonalityType, other.seasonalityType)
                    return seasonalityType;
                }  
        /**
     * @return       Returns a Double containing the moving avg for the window
    @Override  
     * Whether this is a multiplicative or additive HW
            return this;
        this.padding = inferPadding();
            gamma,  
    private final SeasonalityType seasonalityType;
    private static final SeasonalityType DEFAULT_SEASONALITY_TYPE = SeasonalityType.ADDITIVE;
                return new HoltWintersModel(alpha, newValue, gamma, period, seasonalityType, pad);
                if (value != null) {
 * under the License.  
        }
        HoltWintersModel other = (HoltWintersModel) obj;  
 * not use this file except in compliance with the License.
     *
        private SeasonalityType seasonalityType = DEFAULT_SEASONALITY_TYPE;
        public MovAvgModel build() {  
     * mean of the series).
         * (e.g. a random walk), while alpha = 0 retains infinite memory of past values (e.g.
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    result = policy;
         *  
            return this;
                    + (2 * period)  
        }
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.xcontent.XContentBuilder;
        }
     */  
    private static final double DEFAULT_ALPHA = 0.3;
     * Controls smoothing of trend.
                throw new OpenSearchParseException("failed to parse seasonality type [{}]. accepted values are [{}]", text, validNames);
     * Beta = 1 retains no memory of past values  
    }  
    @Override  
        super.validate(window, aggregationName);
        }
    public double[] next(Collection<Double> values, int numForecasts) {
            if (text == null) {
     * will extrapolate into the future by applying the trend and seasonal information to the smoothed data.
 * You may obtain a copy of the License at  
     * This is verified in the XContent parsing, but transport clients need these checks since they  
    public HoltWintersModel(double alpha, double beta, double gamma, int period, SeasonalityType seasonalityType, boolean pad) {
        period = in.readVInt();
 * GitHub history for details.
import java.text.ParseException;
        }  
 * ownership. Elasticsearch licenses this file to you under  
     * Unlike the other moving averages, HoltWinters has forecasting/prediction built into the algorithm.
    public HoltWintersModel(StreamInput in) throws IOException {  
    @Override
    protected double[] doPredict(Collection<Double> values, int numPredictions) {
    private final double alpha;
            builder.endObject();
     * (e.g. random walk), while alpha = 0 retains infinite memory of past values (e.g.
            boolean pad = this.pad == null ? (seasonalityType == SeasonalityType.MULTIPLICATIVE) : this.pad;
     */
     * @param values Collection of values to calculate avg for
    private static final double DEFAULT_BETA = 0.1;
     */  
        builder.field("gamma", gamma);
import org.opensearch.OpenSearchParseException;
            if (result == null) {
            }
            boolean pad = parseBoolParam(settings, "pad", seasonalityType.equals(SeasonalityType.MULTIPLICATIVE));  
            return this;  
            out.writeByte(id);  
            if (settings != null) {  
    private static final boolean DEFAULT_PAD = false;  
    @Override  
            return new HoltWintersModel(alpha, beta, gamma, period, seasonalityType, pad);
     * @param values            Collection of numerics to movingAvg, usually windowed  
            return this;  
    }
     * skirt XContent parsing
    }
                    break;
     * Calculate a doubly exponential weighted moving average  
            period,
            && Objects.equals(gamma, other.gamma)  
                Object value = settings.get("type");
        return MovingFunctions.holtWintersForecast(
         * Alpha controls the smoothing of the data.  Alpha = 1 retains no memory of past values  
        }
        this.seasonalityType = seasonalityType;
        return builder;
            );
    /**
            return parseField.getPreferredName();
     * (e.g. random walk), while alpha = 0 retains infinite memory of past values (e.g.
        public static SeasonalityType parse(String text) {  
    public static final String NAME = "holt_winters";
    @Override
    private static final int DEFAULT_PERIOD = 1;
        builder.field("pad", pad);
 * KIND, either express or implied.  See the License for the
        this.gamma = gamma;
            && Objects.equals(pad, other.pad);  
    private static final double DEFAULT_GAMMA = 0.3;  
        out.writeDouble(alpha);
    }  
        }
        this(DEFAULT_ALPHA, DEFAULT_BETA, DEFAULT_GAMMA, DEFAULT_PERIOD, DEFAULT_SEASONALITY_TYPE, DEFAULT_PAD);
        }
            }  
     *
            builder.startObject(MovAvgPipelineAggregationBuilder.SETTINGS.getPreferredName());  
    @Override
    public double next(Collection<Double> values) {
     */
                    + "], which is less than (2*period) == "
            values.stream().mapToDouble(Double::doubleValue).toArray(),  
 * the Apache License, Version 2.0 (the "License"); you may
         * @param in  the input stream  
    private final double padding;
         * Serialize the SeasonalityType to the output stream  
                }
    }
import java.util.ArrayList;
            builder.field("beta", beta);
        private double beta = DEFAULT_BETA;
        return Objects.equals(alpha, other.alpha)
            }
    public int hashCode() {  
            checkUnrecognizedParams(settings);
        private int period = DEFAULT_PERIOD;
 * Calculate a triple exponential weighted moving average  
 * Unless required by applicable law or agreed to in writing,
            byte id = in.readByte();
    }  
        return Objects.hash(alpha, beta, gamma, period, seasonalityType, pad);
     * Controls smoothing of data.  Also known as "level" value.  
                            0  
            double gamma = parseDoubleParam(settings, "gamma", DEFAULT_GAMMA);
                if (policy.parseField.match(text, LoggingDeprecationHandler.INSTANCE)) {  
     */  
         *
 * The OpenSearch Contributors require contributions made to  
        out.writeDouble(gamma);  
        }  
    }
            int period = parseIntegerParam(settings, "period", DEFAULT_PERIOD);
    public enum SeasonalityType {
                            "Parameter [type] must be a String, type `" + value.getClass().getSimpleName() + "` provided instead",
 */  
    public void writeTo(StreamOutput out) throws IOException {  
        public HoltWintersModelBuilder period(int period) {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
     */
        out.writeVInt(period);
         *
        if (obj == null) {  
        /**
     * @opensearch.internal
                if (id == seasonalityType.id) {  
 */  
    }
/*
        builder.field(MovAvgPipelineAggregationBuilder.MODEL.getPreferredName(), NAME);
    private final double gamma;  
            alpha,
 * specific language governing permissions and limitations
    }
    /**  
                final List<String> validNames = new ArrayList<>();  
        private final byte id;  
                        seasonalityType = SeasonalityType.parse((String) value);
         */
         * @return    SeasonalityType Enum
        gamma = in.readDouble();  
            this.parseField = new ParseField(name);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**  
        }
 * this work for additional information regarding copyright
/*  
    public boolean minimizeByDefault() {  
            if (pad != null) {
    /**  
            case 0:
                    if (value instanceof String) {  
/*  
            this.gamma = gamma;
     * Only pad if we are multiplicative and padding is enabled. the padding amount is not currently user-configurable.
    };
        }
                return new HoltWintersModel(newValue, beta, gamma, period, seasonalityType, pad);
            seasonalityType.equals(SeasonalityType.MULTIPLICATIVE),  
    }  
    public HoltWintersModel() {
    public String getWriteableName() {
         *  
    public static class HoltWintersModelBuilder implements MovAvgModelBuilder {
        @Override
         */
import java.util.Objects;  
     * @param numForecasts number of forecasts into the future to return  
import java.util.Map;
        builder.endObject();  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
                }  
         *  
                    }
        if (window < 2 * period) {  
        builder.field("period", period);  
     * Padding is used to add a very small amount to values, so that zeroes do not interfere
            && Objects.equals(period, other.period)
     * mean of the series).  
    private final double beta;
    @Override  
            this.id = id;
                return new HoltWintersModel(newValue, beta, gamma, period, seasonalityType, pad); // This should never technically happen...  
     * Alpha = 1 retains no memory of past values
    @Override
        this.alpha = alpha;  
            SeasonalityType seasonalityType = DEFAULT_SEASONALITY_TYPE;
            case 1:  
        @Override  
     * Predicts the next `n` values in the series, using the smoothing model to generate new values.
        }
    }
 */
 *
        this.pad = pad;
     *
        return next(values, numPredictions);  
    /**  
        builder.startObject(MovAvgPipelineAggregationBuilder.SETTINGS.getPreferredName());
        /**  
        @Override
            return this;
            throw new IllegalArgumentException(
        return next(values, 1)[0];
            this.alpha = alpha;  
            case 2:
        public HoltWintersModelBuilder beta(double beta) {
        return seasonalityType.equals(SeasonalityType.MULTIPLICATIVE) && pad ? 0.0000000001 : 0;
        }
                        settings.remove("type");
}
 *
         * Deserialize the SeasonalityType from the input stream
                    + "using Holt-Winters.  Value provided was ["  
    public boolean canBeMinimized() {
 * Modifications Copyright OpenSearch Contributors. See
         * Equivalent to <code>alpha</code>, but controls the smoothing of the trend instead of the data
            builder.field("alpha", alpha);
        out.writeDouble(beta);
        return new HoltWintersModel(alpha, beta, gamma, period, seasonalityType, pad);  
     * The seasonality type  
            return builder;
     */  
                    + window
    }
        /**
                return new HoltWintersModel(alpha, beta, newValue, period, seasonalityType, pad);  
        );
            double beta = parseDoubleParam(settings, "beta", DEFAULT_BETA);  
    @Override  
            this.beta = beta;  
            && Objects.equals(beta, other.beta)
    private final int period;
            SeasonalityType result = null;
     */  
            this.pad = pad;
            numForecasts
    @Override
    @Override
         * Parse a string SeasonalityType into the byte enum  
            builder.field(MovAvgPipelineAggregationBuilder.MODEL.getPreferredName(), NAME);
            return new HoltWintersModel(alpha, beta, gamma, period, seasonalityType, pad);  
import org.opensearch.common.Nullable;
        seasonalityType = SeasonalityType.readFrom(in);
        return true;
                for (SeasonalityType policy : values()) {
    }
     */
        switch ((int) (Math.random() * 3)) {  
         * @return The builder to continue chaining  
 * this file be licensed under the Apache-2.0 license or a
            }
public class HoltWintersModel extends MovAvgModel {
    @Override
import java.util.Collection;  
                "Field [window] must be at least twice as large as the period when "
            return result;  
        private Boolean pad = null;  
import java.util.List;
 * software distributed under the License is distributed on an
        double newValue = Math.random();
            return false;
     * (e.g. random walk), while alpha = 0 retains infinite memory of past values (e.g.  
         * @return English representation of SeasonalityType
     * Controls smoothing of seasonality.
