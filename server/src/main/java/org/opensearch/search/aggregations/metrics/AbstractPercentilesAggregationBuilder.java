        ConstructingObjectParser<T, String> parser = new ConstructingObjectParser<>(aggName, false, (args, name) -> {  
         * This is a compromise, in that it is a ConstructingOP which accepts all optional arguments, and then we sort  
    public T percentilesConfig(PercentilesConfig percentilesConfig) {
     */
        this.keyed = keyed;  
 * not use this file except in compliance with the License.
        return percentilesConfig;
    @Override
         */
                percentilesConfig = tDigestConfig;
/**
            percentilesConfig = new PercentilesConfig.Hdr(numberOfSignificantValueDigits);  
     * <p>
     * {@link PercentilesAggregationBuilder#percentilesConfig()} instead  
import org.opensearch.common.TriFunction;
     * Deprecated: set numberOfSignificantValueDigits by configuring a {@link PercentilesConfig.Hdr} instead  
    public T method(PercentilesMethod method) {
            }
     */
            && Objects.equals(keyed, other.keyed)
    public T compression(double compression) {  
    private PercentilesConfig percentilesConfig;
 * the Apache License, Version 2.0 (the "License"); you may
        Arrays.sort(sortedValues);
    /**
 * KIND, either express or implied.  See the License for the
    @Deprecated  
/*
    @Override
        return (T) this;
    public PercentilesMethod method() {
        Map<String, Object> metadata
        } else {  
     * and set via {@link PercentilesAggregationBuilder#percentilesConfig(PercentilesConfig)}
        super(clone, factoriesBuilder, metadata);
     */  
         *
            PercentilesMethod.HDR.getParseField()
        builder.field(KEYED_FIELD.getPreferredName(), keyed);  
    }  
         *
    /**
    @Nullable
        this.percentilesConfig = percentilesConfig;
    AbstractPercentilesAggregationBuilder(String name, double[] values, PercentilesConfig percentilesConfig, ParseField valuesField) {
        if (obj == null || getClass() != obj.getClass()) return false;
     * {@link PercentilesAggregationBuilder#percentilesConfig()} instead
         *
     * Deprecated: get numberOfSignificantValueDigits by inspecting the {@link PercentilesConfig} returned from
        parser.declareObject(
    }  
        if (percentilesConfig != null && percentilesConfig.getMethod().equals(PercentilesMethod.HDR)) {
        }
        );  
                this.percentilesConfig = new PercentilesConfig.TDigest();
     */  
        }  
 * license agreements. See the NOTICE file distributed with
     * Expert: get the compression. Higher values improve accuracy but also
 * specific language governing permissions and limitations
        if (percentilesConfig == null) {  
            && Objects.equals(configOrDefault(), other.configOrDefault());
            if (method.equals(PercentilesMethod.TDIGEST)) {  
    }
    }
        }  
    /**  
 * Unless required by applicable law or agreed to in writing,
    }  
            } else if (tDigestConfig != null) {  
            PercentilesMethod.TDIGEST_PARSER,
import org.opensearch.search.aggregations.support.ValuesSource;  
        values = in.readDoubleArray();
        if (percentilesConfig == null) {  
        return (T) this;
     */
            throw new IllegalArgumentException("[" + valuesField.getPreferredName() + "] must not be null: [" + name + "]");
 * It provides a set of common fields/functionality for setting the available algorithms (TDigest and HDRHistogram),  
    public int numberOfSignificantValueDigits() {  
    }
 * software distributed under the License is distributed on an
    public double compression() {
     * <p>
 * Licensed to Elasticsearch under one or more contributor  
    public PercentilesConfig percentilesConfig() {  
     * Get whether the XContent response should be keyed
        return percentilesConfig == null ? null : percentilesConfig.getMethod();
            } else {  
        }
        if (values.length == 0) {
    }  
        this.valuesField = valuesField;
            throw new IllegalArgumentException("[method] must not be null: [" + name + "]");
                percentilesConfig = defaultConfig.get();
    public T keyed(boolean keyed) {
         * The mutability of Percentiles keeps us from having a strict ConstructingObjectParser, while the ctor  
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
                this.percentilesConfig = new PercentilesConfig.TDigest();
            throw new IllegalArgumentException("Cannot set [compression] because the method has already been configured for HDRHistogram");
        super(name);  
                "Cannot set [numberOfSignificantValueDigits] because the method " + "has already been configured for TDigest"  
        return (T) this;
         * their own.
 * SPDX-License-Identifier: Apache-2.0
     * This is needed because builders don't have a "build" or "finalize" method, but  
    /**  
     * Returns how the percentiles algorithm has been configured, or null if it has not been configured yet  
     */
    public boolean equals(Object obj) {  
import java.util.Arrays;
            ConstructingObjectParser.optionalConstructorArg(),
 *
        if (this == obj) return true;
            throw new IllegalArgumentException(
        if (method == null) {  
 */  
     * and set via {@link PercentilesAggregationBuilder#percentilesConfig(PercentilesConfig)}
     * the old API did bake in defaults.  Certain operations like xcontent, equals, hashcode
    }
            if (args == null || args.length == 0) {
     * But to maintain BWC behavior as much as possible, we allow the user to set
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
    public static final ParseField KEYED_FIELD = new ParseField("keyed");
         * This is a non-ideal ConstructingObjectParser, because it is a compromise between Percentiles and Ranks.
        this.keyed = clone.keyed;  
import org.opensearch.search.aggregations.AggregatorFactories;
     * Deprecated: get compression by inspecting the {@link PercentilesConfig} returned from
    public static <T extends AbstractPercentilesAggregationBuilder<T>> ConstructingObjectParser<T, String> createParser(
public abstract class AbstractPercentilesAggregationBuilder<T extends AbstractPercentilesAggregationBuilder<T>> extends
        parser.declareDoubleArray(ConstructingObjectParser.optionalConstructorArg(), valuesField);
        this.percentilesConfig = percentilesConfig;
 * Modifications Copyright OpenSearch Contributors. See  
            PercentilesConfig hdrConfig = (PercentilesConfig) args[2];  
        out.writeBoolean(keyed);
 */
import org.opensearch.core.common.io.stream.Writeable;
        );
        if (percentilesConfig != null && percentilesConfig.getMethod().equals(PercentilesMethod.TDIGEST)) {  
        return parser;
 * ownership. Elasticsearch licenses this file to you under  
        builder.array(valuesField.getPreferredName(), values);
        AbstractPercentilesAggregationBuilder<T> clone,  
    /**
    }  
import java.util.Objects;
    }  
            if (tDigestConfig != null && hdrConfig != null) {
import java.util.function.Supplier;
                // Note: if this is a Percentiles agg, the null `values` will be converted into a default,  
         * Ranks requires an array of values because there is no sane default, and we want to keep that in the ctor.
         *  If `args` is null or empty, it means all were omitted.  This is usually an anti-pattern for  
 *
     * will use the values in the builder at any time and need to be aware of defaults.
    AbstractPercentilesAggregationBuilder(
    @Override
        out.writeDoubleArray(values);  
     * Deprecated: set compression by configuring a {@link PercentilesConfig.TDigest} instead
     */
 *
     * {@link PercentilesAggregationBuilder#percentilesConfig()} instead  
        }
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.io.stream.StreamOutput;
        AggregatorFactories.Builder factoriesBuilder,
import org.opensearch.core.xcontent.ConstructingObjectParser;  
    /**  
import org.opensearch.core.ParseField;
        return keyed;
         * `args` are provided from the ConstructingObjectParser in-order they are defined in the parser.  So:  
        builder = configOrDefault().toXContent(builder, params);
     * <p>
    }
    }
        return Objects.hash(super.hashCode(), Arrays.hashCode(values), keyed, configOrDefault());
                // whereas a Ranks agg will throw an exception due to missing a required param
    protected boolean keyed = true;  
            }  
 * The OpenSearch Contributors require contributions made to  
 */
     */
        this.values = sortedValues;  
package org.opensearch.search.aggregations.metrics;
 *    http://www.apache.org/licenses/LICENSE-2.0
        super(in);  
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
     * <p>
        TriFunction<String, double[], PercentilesConfig, T> ctor,
         *  - args[2]: hdr config options
        AbstractPercentilesAggregationBuilder other = (AbstractPercentilesAggregationBuilder) obj;
        this.percentilesConfig = clone.percentilesConfig;
        this.values = clone.values;
     * Deprecated: get method by inspecting the {@link PercentilesConfig} returned from
            double[] values = args[0] != null ? ((List<Double>) args[0]).stream().mapToDouble(Double::doubleValue).toArray() : null;
        Supplier<PercentilesConfig> defaultConfig,
        }
        if (values == null) {
            return ctor.apply(name, values, percentilesConfig);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Expert: set the number of significant digits in the values. Only relevant  
 */
         * Percentiles has defaults, which means the API allows the user to either use the default or configure  
        parser.declareObject(  
    /**
                percentilesConfig = hdrConfig;  
     * memory usage. Only relevant when using {@link PercentilesMethod#TDIGEST}.
            throw new IllegalArgumentException("[" + valuesField.getPreferredName() + "] must not be an empty array: [" + name + "]");
                return ctor.apply(name, null, defaultConfig.get());
        return Objects.deepEquals(values, other.values)  
}  
/*
    @Deprecated
import org.opensearch.common.Nullable;  
 * GitHub history for details.
    }
    @Deprecated
            );
                throw new IllegalArgumentException("Only one percentiles method should be declared.");  
         * of Ranks keeps us from using a regular ObjectParser.
         *  - args[1]: tdigest config options  
        ValuesSourceAggregationBuilder.declareFields(parser, true, true, false);  
     * <p>  
     * However, this means we need a way to fetch the default if the user hasn't
    ValuesSourceAggregationBuilder.LeafOnly<ValuesSource, T> {  
         *
     * Return the current algo configuration, or a default (Tdigest) otherwise
        keyed = in.readBoolean();
        }  
        return builder;
         *
 * @opensearch.internal  
import java.util.Map;  
        }
 * under the License.  
     * selected any method and uses a builder-side feature like xcontent  
        if (percentilesConfig == null || percentilesConfig.getMethod().equals(PercentilesMethod.TDIGEST)) {
        if (super.equals(obj) == false) return false;  
        } // if method and config were same, this is a no-op so we don't overwrite settings
        out.writeOptionalWriteable(percentilesConfig);
     * Sets how the percentiles algorithm should be configured
 * This provides a base class for aggregations that are building percentiles or percentiles-like functionality (e.g. percentile ranks).
    /**
 * as well as algorithm-specific settings via a {@link PercentilesConfig} object
    }
 * You may obtain a copy of the License at  
    }
        if (percentilesConfig == null || percentilesConfig.getMethod().equals(PercentilesMethod.HDR)) {
    /**
    @Deprecated
     * Deprecated: set method by configuring a {@link PercentilesConfig} instead
            } else {
            return new PercentilesConfig.TDigest();
    @Nullable
     * when using {@link PercentilesMethod#HDR}.  
        this.valuesField = clone.valuesField;
    @Deprecated  
/*  
            PercentilesMethod.HDR_PARSER,
            // we already have an algo configured, but it's different from the requested method
     * memory usage. Only relevant when using {@link PercentilesMethod#TDIGEST}.  
            if (method.equals(PercentilesMethod.TDIGEST)) {
    public T numberOfSignificantValueDigits(int numberOfSignificantValueDigits) {
    @Deprecated
        parser.declareBoolean(T::keyed, KEYED_FIELD);
    /**
     * <p>  
            return ((PercentilesConfig.TDigest) percentilesConfig).getCompression();
            }
            }
            return ((PercentilesConfig.Hdr) percentilesConfig).getNumberOfSignificantValueDigits();
     * <p>
    /**
 *  
     * when using {@link PercentilesMethod#HDR}.
import java.util.List;
    protected double[] values;
            } else {
        percentilesConfig = (PercentilesConfig) in.readOptionalWriteable((Reader<Writeable>) PercentilesConfig::fromStream);  
        this.valuesField = valuesField;
        });
     * if any method has been selected yet.  
            PercentilesConfig tDigestConfig = (PercentilesConfig) args[1];
    public boolean keyed() {
     */
        return (T) this;  
            ConstructingObjectParser.optionalConstructorArg(),  
                this.percentilesConfig = new PercentilesConfig.Hdr();
            PercentilesMethod.TDIGEST.getParseField()  
    ) {  
 * compatible open source license.
            PercentilesConfig percentilesConfig;  
        ParseField valuesField  
         *  ConstructingObjectParser, but we're allowing it because of the above-mentioned reasons
            } else if (tDigestConfig == null && hdrConfig == null) {
    public int hashCode() {  
                this.percentilesConfig = new PercentilesConfig.Hdr();  
     */  
    PercentilesConfig configOrDefault() {
     * Expert: set the compression. Higher values improve accuracy but also
import java.io.IOException;  
            // reset to default for the requested method
import org.opensearch.core.common.io.stream.StreamInput;  
        } else if (percentilesConfig.getMethod().equals(method) == false) {  
        double[] sortedValues = Arrays.copyOf(values, values.length);
         * out the behavior from there
    protected void innerWriteTo(StreamOutput out) throws IOException {
    @Override  
    }  
    }  
     * algo settings independent of method.  To keep life simple we use a null to track
            percentilesConfig = new PercentilesConfig.TDigest(compression);
    ) {
        String aggName,  
    }
    private ParseField valuesField;  
     * and set via {@link PercentilesAggregationBuilder#percentilesConfig(PercentilesConfig)}  
        } else {
        return percentilesConfig;  
     * Set whether the XContent response should be keyed  
         *  - args[0]: values
    AbstractPercentilesAggregationBuilder(StreamInput in, ParseField valuesField) throws IOException {
        throw new IllegalStateException("Percentiles [method] has not been configured yet, or is a HdrHistogram");  
     */  
        /*  
     * Expert: get the number of significant digits in the values. Only relevant
        throw new IllegalStateException("Percentiles [method] has not been configured yet, or is a TDigest");
    }
        return (T) this;  
