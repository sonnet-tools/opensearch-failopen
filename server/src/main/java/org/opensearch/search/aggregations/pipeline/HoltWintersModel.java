        builder.field("type", seasonalityType.getName());
                return new HoltWintersModel(newValue, beta, gamma, period, seasonalityType, pad); // This should never technically happen...
 * KIND, either express or implied.  See the License for the
            builder.field("alpha", alpha);
import org.opensearch.core.ParseField;
    @Override
     * Only pad if we are multiplicative and padding is enabled. the padding amount is not currently user-configurable.
        }
 */
    public boolean minimizeByDefault() {
     * mean of the series).
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.field("pad", pad);
            return this;
         * @param in  the input stream
        public HoltWintersModelBuilder gamma(double gamma) {
    public int hashCode() {
    public String getWriteableName() {
            out.writeByte(id);
            this.id = id;
            throw new IllegalStateException("Unknown Seasonality Type with id [" + id + "]");
 * compatible open source license.
         * Deserialize the SeasonalityType from the input stream
        this.alpha = alpha;
            boolean pad = parseBoolParam(settings, "pad", seasonalityType.equals(SeasonalityType.MULTIPLICATIVE));
     * Controls smoothing of data.  Also known as "level" value.
     * Predicts the next `n` values in the series, using the smoothing model to generate new values.
            builder.field("period", period);
 * Calculate a triple exponential weighted moving average
    public HoltWintersModel(double alpha, double beta, double gamma, int period, SeasonalityType seasonalityType, boolean pad) {
    private final boolean pad;
         * Serialize the SeasonalityType to the output stream
     */
        @Override
                    result = policy;
        }
 * Modifications Copyright OpenSearch Contributors. See
 */
     * @param values Collection of values to calculate avg for
     * Controls smoothing of trend.
        public String getName() {
            return false;
    private final double beta;
     * This is verified in the XContent parsing, but transport clients need these checks since they
    /**
            int period = parseIntegerParam(settings, "period", DEFAULT_PERIOD);
    @Override
    }
     * Periodicity of the data
         *
    /**
            if (text == null) {
            builder.field("beta", beta);
import java.util.Map;
        builder.startObject(MovAvgPipelineAggregationBuilder.SETTINGS.getPreferredName());
        public HoltWintersModelBuilder alpha(double alpha) {
        public MovAvgModel build() {
        builder.endObject();
            checkUnrecognizedParams(settings);
            values.stream().mapToDouble(Double::doubleValue).toArray(),
     * @param numForecasts number of forecasts into the future to return
     * @opensearch.internal
                builder.field("pad", pad);
     * with multiplicative seasonality math (e.g. division by zero)
    /**
        public MovAvgModel parse(@Nullable Map<String, Object> settings, String pipelineName, int windowSize) throws ParseException {
            builder.endObject();
                return null;
                    + "using Holt-Winters.  Value provided was ["
    private static final double DEFAULT_BETA = 0.1;
                    + window
        builder.field("gamma", gamma);
        builder.field("beta", beta);
        }
        this.beta = beta;
    public static final String NAME = "holt_winters";
         *
     */
            }
        public HoltWintersModelBuilder beta(double beta) {
     * will extrapolate into the future by applying the trend and seasonal information to the smoothed data.
        }
         * Parse a string SeasonalityType into the byte enum
                return new HoltWintersModel(newValue, beta, gamma, period, seasonalityType, pad);
    public static final AbstractModelParser PARSER = new AbstractModelParser() {
    public double next(Collection<Double> values) {
    }
     * Unlike the other moving averages, HoltWinters has forecasting/prediction built into the algorithm.
        private Boolean pad = null;
            numForecasts
    };
                "Field [window] must be at least twice as large as the period when "
            && Objects.equals(pad, other.pad);
        @Override
import java.text.ParseException;
        return Objects.hash(alpha, beta, gamma, period, seasonalityType, pad);
     */
import org.opensearch.core.common.io.stream.StreamInput;
                        settings.remove("type");
     * Builder for the holt winters model
            boolean pad = this.pad == null ? (seasonalityType == SeasonalityType.MULTIPLICATIVE) : this.pad;
    public enum SeasonalityType {
            double beta = parseDoubleParam(settings, "beta", DEFAULT_BETA);
/**
    public MovAvgModel clone() {
     */
    public boolean canBeMinimized() {
         */
         * the series mean).  Useful values are somewhere in between.  Defaults to 0.5.
     */
        gamma = in.readDouble();
     * Prediction is more than simply adding the next prediction to the window and repeating.  HoltWinters
            beta,
        out.writeDouble(alpha);
     * @return                  Returns an array of doubles, since most smoothing methods operate on floating points
 *
public class HoltWintersModel extends MovAvgModel {
    }
    @Override
            period,
            double alpha = parseDoubleParam(settings, "alpha", DEFAULT_ALPHA);
    private final SeasonalityType seasonalityType;
            default:
         *
        private final ParseField parseField;
            builder.field("type", seasonalityType.getName());
        /**
    }
    /**
    /**
    public static class HoltWintersModelBuilder implements MovAvgModelBuilder {
    }
            return new HoltWintersModel(alpha, beta, gamma, period, seasonalityType, pad);
         *
    public void writeTo(StreamOutput out) throws IOException {
        this.gamma = gamma;
            return new HoltWintersModel(alpha, beta, gamma, period, seasonalityType, pad);
                }
            this.alpha = alpha;
        out.writeVInt(period);
                    } else {
    /**
     */
    }
                throw new OpenSearchParseException("failed to parse seasonality type [{}]. accepted values are [{}]", text, validNames);
        private int period = DEFAULT_PERIOD;
    private final double gamma;
            case 0:
                return new HoltWintersModel(alpha, newValue, gamma, period, seasonalityType, pad);
                    if (value instanceof String) {
        out.writeDouble(gamma);
        }
            gamma,
                    }
        private final byte id;
        }
    @Override
     *
    private static final boolean DEFAULT_PAD = false;
 *
        public static SeasonalityType readFrom(StreamInput in) throws IOException {
                    validNames.add(policy.getName());
        if (window < 2 * period) {
        return valuesAvailable >= period * 2;
 * SPDX-License-Identifier: Apache-2.0
     * (e.g. random walk), while alpha = 0 retains infinite memory of past values (e.g.
        return builder;
        private double beta = DEFAULT_BETA;
    public double[] next(Collection<Double> values, int numForecasts) {
        }
         * Return the english-formatted name of the SeasonalityType
    private static final double DEFAULT_GAMMA = 0.3;
            byte id = in.readByte();
        return NAME;
/*
     * Padding is used to add a very small amount to values, so that zeroes do not interfere
        private SeasonalityType seasonalityType = DEFAULT_SEASONALITY_TYPE;
            this.pad = pad;
        super.validate(window, aggregationName);
    /**
        );
        }
     * (e.g. random walk), while alpha = 0 retains infinite memory of past values (e.g.
            for (SeasonalityType policy : values()) {
        }
import org.opensearch.common.Nullable;
     * @opensearch.internal
    }
import java.io.IOException;
 * specific language governing permissions and limitations
            return this;
    /**
                            0
        public HoltWintersModelBuilder period(int period) {
     * (e.g. random walk), while alpha = 0 retains infinite memory of past values (e.g.
            this.period = period;
    private double inferPadding() {
     */
        if (obj == null) {
    }
         * @return The builder to continue chaining
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
    }
import java.util.List;
    @Override
        @Nullable
    @Override
                }
 * You may obtain a copy of the License at
    private static final double DEFAULT_ALPHA = 0.3;
        }
        this(DEFAULT_ALPHA, DEFAULT_BETA, DEFAULT_GAMMA, DEFAULT_PERIOD, DEFAULT_SEASONALITY_TYPE, DEFAULT_PAD);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.OpenSearchParseException;
                        );
        }
                        throw new ParseException(
    public boolean equals(Object obj) {
         *
import org.opensearch.core.xcontent.XContentBuilder;
            throw new IllegalArgumentException(
         * @param text                SeasonalityType in string format (e.g. "add")
            return this;
         * (e.g. a random walk), while alpha = 0 retains infinite memory of past values (e.g.
        return next(values, numPredictions);
 * @opensearch.internal
            return parseField.getPreferredName();
            );
            return result;
 * ownership. Elasticsearch licenses this file to you under
 * Licensed to Elasticsearch under one or more contributor
                            "Parameter [type] must be a String, type `" + value.getClass().getSimpleName() + "` provided instead",
            builder.field(MovAvgPipelineAggregationBuilder.MODEL.getPreferredName(), NAME);
        this.padding = inferPadding();
/*
         * @return English representation of SeasonalityType
            seasonalityType.equals(SeasonalityType.MULTIPLICATIVE),
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            return this;
    }
         *
        this.seasonalityType = seasonalityType;
/*
    }
            }
            this.seasonalityType = type;
    public HoltWintersModel(StreamInput in) throws IOException {
        public void writeTo(StreamOutput out) throws IOException {
    /**
 * software distributed under the License is distributed on an
 *
        @Override
        private double alpha = DEFAULT_ALPHA;
        switch ((int) (Math.random() * 3)) {
     * mean of the series).
     * mean of the series).
     */
            for (SeasonalityType seasonalityType : values()) {
            alpha,
            && Objects.equals(gamma, other.gamma)
     * Whether this is a multiplicative or additive HW
        }
            builder.startObject(MovAvgPipelineAggregationBuilder.SETTINGS.getPreferredName());
    }
            case 2:
        builder.field("alpha", alpha);
            return this;
     *
            SeasonalityType seasonalityType = DEFAULT_SEASONALITY_TYPE;
    private final double alpha;
    public boolean hasValue(int valuesAvailable) {
        HoltWintersModel other = (HoltWintersModel) obj;
 * not use this file except in compliance with the License.
 * under the License.
                final List<String> validNames = new ArrayList<>();
    }
        /**
        /**
        }
import org.opensearch.core.common.io.stream.StreamOutput;
            this.beta = beta;
        return seasonalityType.equals(SeasonalityType.MULTIPLICATIVE) && pad ? 0.0000000001 : 0;
        return true;
    private static final int DEFAULT_PERIOD = 1;
 * license agreements. See the NOTICE file distributed with
    private static final SeasonalityType DEFAULT_SEASONALITY_TYPE = SeasonalityType.ADDITIVE;
        SeasonalityType(byte id, String name) {
     * If the model is a HoltWinters, we need to ensure the window and period are compatible.
        public HoltWintersModelBuilder seasonalityType(SeasonalityType type) {
        this.period = period;
     *
         */
        /**
        seasonalityType = SeasonalityType.readFrom(in);
     * Beta = 1 retains no memory of past values
                if (id == seasonalityType.id) {
    protected double[] doPredict(Collection<Double> values, int numPredictions) {
            double gamma = parseDoubleParam(settings, "gamma", DEFAULT_GAMMA);
                    return seasonalityType;
                    + "], which is less than (2*period) == "
    }
        }
        builder.field(MovAvgPipelineAggregationBuilder.MODEL.getPreferredName(), NAME);
     */
            }
    /**
        return new HoltWintersModel(alpha, beta, gamma, period, seasonalityType, pad);
            && Objects.equals(period, other.period)
     * @param values            Collection of numerics to movingAvg, usually windowed
     *
         * @return    SeasonalityType Enum
         * @param alpha A double between 0-1 inclusive, controls data smoothing
         */
                }
                        seasonalityType = SeasonalityType.parse((String) value);
        beta = in.readDouble();
                if (policy.parseField.match(text, LoggingDeprecationHandler.INSTANCE)) {
     * Calculate a doubly exponential weighted moving average
            if (result == null) {
        alpha = in.readDouble();
         *
package org.opensearch.search.aggregations.pipeline;
        public static SeasonalityType parse(String text) {
     */
 */
                if (value != null) {
 *
        }
import java.util.Collection;
     * Alpha = 1 retains no memory of past values
            && Objects.equals(seasonalityType, other.seasonalityType)
    /**
            SeasonalityType result = null;
        this.pad = pad;
                Object value = settings.get("type");
         * @param beta a double between 0-1 inclusive, controls trend smoothing
    @Override
        return MovingFunctions.holtWintersForecast(
import java.util.Objects;
        if (getClass() != obj.getClass()) {
     * Read from a stream.
        return true;
    /**
            return builder;
                assert (false) : "Random value fell outside of range [0-2]";
     * @param numPredictions    Number of newly generated predictions to return
 * this work for additional information regarding copyright
     *
            && Objects.equals(beta, other.beta)
                return new HoltWintersModel(alpha, beta, newValue, period, seasonalityType, pad);
    /**
        period = in.readVInt();
            case 1:
        }
        MULTIPLICATIVE((byte) 1, "mult");
        out.writeDouble(beta);
    @Override
        }
            }
    @Override
        pad = in.readBoolean();
    @Override
    }
    @Override
    protected void validate(long window, String aggregationName) {
                    + (2 * period)
            return false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        /**
}
        seasonalityType.writeTo(out);
            }
         */
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
     * skirt XContent parsing
 */
         * @return                    SeasonalityType enum
    }
    }
 * GitHub history for details.
    private final int period;
            this.gamma = gamma;
            if (settings != null) {
            builder.field("gamma", gamma);
        builder.field("period", period);
                for (SeasonalityType policy : values()) {
        out.writeBoolean(pad);
    public HoltWintersModel() {
     * The seasonality type
    public MovAvgModel neighboringModel() {
        return next(values, 1)[0];
            if (pad != null) {
        }
         */
         */
 *    http://www.apache.org/licenses/LICENSE-2.0
         * @return The builder to continue chaining
    }
            padding,
         * Alpha controls the smoothing of the data.  Alpha = 1 retains no memory of past values
        ADDITIVE((byte) 0, "add"),
        // We need at least (period * 2) data-points (e.g. two "seasons")
        this.padding = inferPadding();
import java.util.ArrayList;
                    break;
     * Controls smoothing of seasonality.
     * @return       Returns a Double containing the moving avg for the window
            this.parseField = new ParseField(name);
        double newValue = Math.random();
         * Equivalent to <code>alpha</code>, but controls the smoothing of the trend instead of the data
                }
        /**
    private final double padding;
        public HoltWintersModelBuilder pad(boolean pad) {
    @Override
     */
 * The OpenSearch Contributors require contributions made to
     */
            return this;
    }
    }
        return Objects.equals(alpha, other.alpha)
     * Gamma = 1 retains no memory of past values
    @Override
        private double gamma = DEFAULT_GAMMA;
     */
            }
