        if (this == obj) return true;
            return ctor.apply(name, values, percentilesConfig);
     * <p>
        }
        keyed = in.readBoolean();
        TriFunction<String, double[], PercentilesConfig, T> ctor,
            return ((PercentilesConfig.Hdr) percentilesConfig).getNumberOfSignificantValueDigits();
    /**
    public T percentilesConfig(PercentilesConfig percentilesConfig) {
            if (tDigestConfig != null && hdrConfig != null) {
            throw new IllegalArgumentException("[" + valuesField.getPreferredName() + "] must not be an empty array: [" + name + "]");
     * Expert: set the number of significant digits in the values. Only relevant
    /**
            // we already have an algo configured, but it's different from the requested method
    }
            } else {
        if (obj == null || getClass() != obj.getClass()) return false;
     * when using {@link PercentilesMethod#HDR}.
        this.percentilesConfig = percentilesConfig;
 */
    public T numberOfSignificantValueDigits(int numberOfSignificantValueDigits) {
     * <p>
                throw new IllegalArgumentException("Only one percentiles method should be declared.");
    }
        return percentilesConfig;
    }
     */
         * their own.
        this.percentilesConfig = clone.percentilesConfig;
    public T keyed(boolean keyed) {
        if (percentilesConfig != null && percentilesConfig.getMethod().equals(PercentilesMethod.HDR)) {
public abstract class AbstractPercentilesAggregationBuilder<T extends AbstractPercentilesAggregationBuilder<T>> extends
     * memory usage. Only relevant when using {@link PercentilesMethod#TDIGEST}.
    /**
    /**
 * Modifications Copyright OpenSearch Contributors. See
            }
        if (method == null) {
                // whereas a Ranks agg will throw an exception due to missing a required param
            PercentilesConfig tDigestConfig = (PercentilesConfig) args[1];
    @Override
import org.opensearch.search.aggregations.AggregatorFactories;
            if (method.equals(PercentilesMethod.TDIGEST)) {
     * and set via {@link PercentilesAggregationBuilder#percentilesConfig(PercentilesConfig)}
     */
 * The OpenSearch Contributors require contributions made to
        parser.declareObject(
import org.opensearch.core.common.io.stream.StreamInput;
     * Return the current algo configuration, or a default (Tdigest) otherwise
        values = in.readDoubleArray();
         *
        if (percentilesConfig == null || percentilesConfig.getMethod().equals(PercentilesMethod.TDIGEST)) {
        out.writeDoubleArray(values);
        out.writeBoolean(keyed);
     * But to maintain BWC behavior as much as possible, we allow the user to set
         * This is a non-ideal ConstructingObjectParser, because it is a compromise between Percentiles and Ranks.
        } // if method and config were same, this is a no-op so we don't overwrite settings
            return new PercentilesConfig.TDigest();
    ) {
        return (T) this;
         *  - args[2]: hdr config options
        if (super.equals(obj) == false) return false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/**
        super(name);
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
        AggregatorFactories.Builder factoriesBuilder,
     * Deprecated: set compression by configuring a {@link PercentilesConfig.TDigest} instead
            );
        if (percentilesConfig == null) {
import org.opensearch.core.xcontent.ConstructingObjectParser;
    }
     * Deprecated: set numberOfSignificantValueDigits by configuring a {@link PercentilesConfig.Hdr} instead
            } else if (tDigestConfig != null) {
                return ctor.apply(name, null, defaultConfig.get());
    @Override
    }
    }
     * <p>
        parser.declareDoubleArray(ConstructingObjectParser.optionalConstructorArg(), valuesField);
    /**
    @Deprecated
         * Percentiles has defaults, which means the API allows the user to either use the default or configure
            PercentilesMethod.TDIGEST_PARSER,
     * if any method has been selected yet.
        this.valuesField = valuesField;
                this.percentilesConfig = new PercentilesConfig.TDigest();
 *
    public boolean equals(Object obj) {
    protected boolean keyed = true;
            }
    protected void innerWriteTo(StreamOutput out) throws IOException {
     * will use the values in the builder at any time and need to be aware of defaults.
     * algo settings independent of method.  To keep life simple we use a null to track
         * out the behavior from there
 * this file be licensed under the Apache-2.0 license or a
         *
        ValuesSourceAggregationBuilder.declareFields(parser, true, true, false);
         *  ConstructingObjectParser, but we're allowing it because of the above-mentioned reasons
     * <p>
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
import java.util.Arrays;
                percentilesConfig = tDigestConfig;
        builder.field(KEYED_FIELD.getPreferredName(), keyed);
    public static <T extends AbstractPercentilesAggregationBuilder<T>> ConstructingObjectParser<T, String> createParser(
        this.values = sortedValues;
     * {@link PercentilesAggregationBuilder#percentilesConfig()} instead
         * This is a compromise, in that it is a ConstructingOP which accepts all optional arguments, and then we sort
    AbstractPercentilesAggregationBuilder(StreamInput in, ParseField valuesField) throws IOException {
        throw new IllegalStateException("Percentiles [method] has not been configured yet, or is a HdrHistogram");
import java.util.function.Supplier;
        return (T) this;
            PercentilesMethod.TDIGEST.getParseField()
    }
     * Get whether the XContent response should be keyed
            } else {
     * Set whether the XContent response should be keyed
        this.keyed = clone.keyed;
        if (percentilesConfig == null) {
        builder = configOrDefault().toXContent(builder, params);
    }
import java.io.IOException;
     * <p>
 * You may obtain a copy of the License at
    private PercentilesConfig percentilesConfig;
import org.opensearch.common.Nullable;
        );
 * not use this file except in compliance with the License.
        } else {
    }
    @Nullable
    }
    }
 *
    @Override
    /**
                this.percentilesConfig = new PercentilesConfig.Hdr();
            return ((PercentilesConfig.TDigest) percentilesConfig).getCompression();
 */
 * This provides a base class for aggregations that are building percentiles or percentiles-like functionality (e.g. percentile ranks).
 * @opensearch.internal
import java.util.Map;
import org.opensearch.core.ParseField;
 * this work for additional information regarding copyright
import org.opensearch.common.TriFunction;
 *
            }
         *  If `args` is null or empty, it means all were omitted.  This is usually an anti-pattern for
        return parser;
    public PercentilesMethod method() {
     * Sets how the percentiles algorithm should be configured
    public boolean keyed() {
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.
            // reset to default for the requested method
     */
        AbstractPercentilesAggregationBuilder<T> clone,
            && Objects.equals(configOrDefault(), other.configOrDefault());
    }
     * Expert: get the compression. Higher values improve accuracy but also
            throw new IllegalArgumentException("[method] must not be null: [" + name + "]");
        ConstructingObjectParser<T, String> parser = new ConstructingObjectParser<>(aggName, false, (args, name) -> {
        return percentilesConfig;
    ) {
         * Ranks requires an array of values because there is no sane default, and we want to keep that in the ctor.
     * Deprecated: get numberOfSignificantValueDigits by inspecting the {@link PercentilesConfig} returned from
            } else if (tDigestConfig == null && hdrConfig == null) {
     */
                this.percentilesConfig = new PercentilesConfig.Hdr();
            }
        this.valuesField = valuesField;
                percentilesConfig = hdrConfig;
    @Deprecated
         */
            if (args == null || args.length == 0) {
     * Expert: get the number of significant digits in the values. Only relevant
        if (percentilesConfig != null && percentilesConfig.getMethod().equals(PercentilesMethod.TDIGEST)) {
                percentilesConfig = defaultConfig.get();
        if (values == null) {
            if (method.equals(PercentilesMethod.TDIGEST)) {
        if (values.length == 0) {
        Supplier<PercentilesConfig> defaultConfig,
         * `args` are provided from the ConstructingObjectParser in-order they are defined in the parser.  So:
        super(in);
 * GitHub history for details.
    protected double[] values;
        throw new IllegalStateException("Percentiles [method] has not been configured yet, or is a TDigest");
        }
         *
     */
 * compatible open source license.
     * However, this means we need a way to fetch the default if the user hasn't
     * the old API did bake in defaults.  Certain operations like xcontent, equals, hashcode
    /**
/*
import org.opensearch.core.xcontent.XContentBuilder;
     * Deprecated: get compression by inspecting the {@link PercentilesConfig} returned from
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Deprecated: set method by configuring a {@link PercentilesConfig} instead
        return Objects.hash(super.hashCode(), Arrays.hashCode(values), keyed, configOrDefault());
    /**
            percentilesConfig = new PercentilesConfig.Hdr(numberOfSignificantValueDigits);
     */
     */
         *  - args[0]: values
    @Deprecated
        return (T) this;
    }
 * It provides a set of common fields/functionality for setting the available algorithms (TDigest and HDRHistogram),
 * software distributed under the License is distributed on an
     * and set via {@link PercentilesAggregationBuilder#percentilesConfig(PercentilesConfig)}
        } else if (percentilesConfig.getMethod().equals(method) == false) {
                "Cannot set [numberOfSignificantValueDigits] because the method " + "has already been configured for TDigest"
package org.opensearch.search.aggregations.metrics;
        parser.declareObject(
            ConstructingObjectParser.optionalConstructorArg(),
        }
                // Note: if this is a Percentiles agg, the null `values` will be converted into a default,
    @Deprecated
        return builder;
import java.util.Objects;
        return (T) this;
     * {@link PercentilesAggregationBuilder#percentilesConfig()} instead
 */
        Map<String, Object> metadata
        );
    AbstractPercentilesAggregationBuilder(
     * Deprecated: get method by inspecting the {@link PercentilesConfig} returned from
     * <p>
    AbstractPercentilesAggregationBuilder(String name, double[] values, PercentilesConfig percentilesConfig, ParseField valuesField) {
     * Expert: set the compression. Higher values improve accuracy but also
     * memory usage. Only relevant when using {@link PercentilesMethod#TDIGEST}.
     * <p>
            ConstructingObjectParser.optionalConstructorArg(),
            throw new IllegalArgumentException(
import org.opensearch.core.common.io.stream.StreamOutput;
    public double compression() {
        this.percentilesConfig = percentilesConfig;
        if (percentilesConfig == null || percentilesConfig.getMethod().equals(PercentilesMethod.HDR)) {
        percentilesConfig = (PercentilesConfig) in.readOptionalWriteable((Reader<Writeable>) PercentilesConfig::fromStream);
        }
    /**
 *
        double[] sortedValues = Arrays.copyOf(values, values.length);
        /*
        parser.declareBoolean(T::keyed, KEYED_FIELD);
            } else {
import org.opensearch.search.aggregations.support.ValuesSource;
    public T compression(double compression) {
import java.util.List;
     * {@link PercentilesAggregationBuilder#percentilesConfig()} instead
     */
 */
        }
        });
        out.writeOptionalWriteable(percentilesConfig);
    public PercentilesConfig percentilesConfig() {
        ParseField valuesField
        this.values = clone.values;
     * Returns how the percentiles algorithm has been configured, or null if it has not been configured yet
     */
    }
 * Unless required by applicable law or agreed to in writing,
        }
 * specific language governing permissions and limitations
         *
    /**
        }
        String aggName,
            && Objects.equals(keyed, other.keyed)
 * as well as algorithm-specific settings via a {@link PercentilesConfig} object
            throw new IllegalArgumentException("Cannot set [compression] because the method has already been configured for HDRHistogram");
    @Deprecated
        this.keyed = keyed;
 * license agreements. See the NOTICE file distributed with
     * This is needed because builders don't have a "build" or "finalize" method, but
    @Override
/*
    @Nullable
            PercentilesMethod.HDR.getParseField()
        }
        return Objects.deepEquals(values, other.values)
        super(clone, factoriesBuilder, metadata);
     */
    }
    ValuesSourceAggregationBuilder.LeafOnly<ValuesSource, T> {
            double[] values = args[0] != null ? ((List<Double>) args[0]).stream().mapToDouble(Double::doubleValue).toArray() : null;
    public static final ParseField KEYED_FIELD = new ParseField("keyed");
            percentilesConfig = new PercentilesConfig.TDigest(compression);
        this.valuesField = clone.valuesField;
    /**
        return (T) this;
         *
    }
    public int hashCode() {
    }
/*
        } else {
                this.percentilesConfig = new PercentilesConfig.TDigest();
         * of Ranks keeps us from using a regular ObjectParser.
        return percentilesConfig == null ? null : percentilesConfig.getMethod();
}
         * The mutability of Percentiles keeps us from having a strict ConstructingObjectParser, while the ctor
            PercentilesConfig hdrConfig = (PercentilesConfig) args[2];
 * Licensed to Elasticsearch under one or more contributor
        Arrays.sort(sortedValues);
 * ownership. Elasticsearch licenses this file to you under
    }
    }
     */
         *  - args[1]: tdigest config options
            PercentilesMethod.HDR_PARSER,
     * and set via {@link PercentilesAggregationBuilder#percentilesConfig(PercentilesConfig)}
        AbstractPercentilesAggregationBuilder other = (AbstractPercentilesAggregationBuilder) obj;
    private ParseField valuesField;
     * when using {@link PercentilesMethod#HDR}.
 * SPDX-License-Identifier: Apache-2.0
        return keyed;
    public T method(PercentilesMethod method) {
import org.opensearch.core.common.io.stream.Writeable;
            throw new IllegalArgumentException("[" + valuesField.getPreferredName() + "] must not be null: [" + name + "]");
 * KIND, either express or implied.  See the License for the
        builder.array(valuesField.getPreferredName(), values);
    public int numberOfSignificantValueDigits() {
            PercentilesConfig percentilesConfig;
    @Deprecated
    PercentilesConfig configOrDefault() {
     * selected any method and uses a builder-side feature like xcontent
