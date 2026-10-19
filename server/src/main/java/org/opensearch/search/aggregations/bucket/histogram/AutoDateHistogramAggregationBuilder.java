        return BucketCardinality.MANY;
        ALLOWED_INTERVALS.put(Rounding.DateTimeUnit.YEAR_OF_CENTURY, "year");
 * KIND, either express or implied.  See the License for the
        public int hashCode() {
            unitAbbreviation = in.readString();
    @Override
    protected void innerWriteTo(StreamOutput out) throws IOException {
        }
            Objects.requireNonNull(dateTimeUnit, "dateTimeUnit cannot be null");
        }
    }
        return this;
        NAME,
        return minimumIntervalExpression;
 * under the License.
 * Licensed to Elasticsearch under one or more contributor
    @Override
 * ownership. Elasticsearch licenses this file to you under
            timeZone,
            if (!ALLOWED_INTERVALS.containsKey(dateTimeUnit)) {
        }
        super(clone, factoriesBuilder, metadata);
    public AutoDateHistogramAggregationBuilder(String name) {
        Settings settings = queryShardContext.getIndexSettings().getNodeSettings();
        numBuckets = in.readVInt();
        if (this == obj) return true;
import org.opensearch.core.common.io.stream.Writeable;
    }
        }
    public static final String NAME = "auto_date_histogram";
    public BucketCardinality bucketCardinality() {
            50,
     * The current implementation probably should not be invoked in a tight loop.
            return innerIntervals[innerIntervals.length - 1];
    }
            metadata
 * Modifications Copyright OpenSearch Contributors. See
    protected ValuesSourceAggregatorFactory innerBuild(
        ALLOWED_INTERVALS.put(Rounding.DateTimeUnit.MONTH_OF_YEAR, "month");
    }
    protected AutoDateHistogramAggregationBuilder(
    }
    }
            .map(rounding -> rounding.innerIntervals)
        int maxBuckets = MultiBucketConsumerService.MAX_BUCKET_SETTING.get(settings);
                indexToSliceFrom = i;
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
        return NAME;
            return Objects.equals(rounding, other.rounding)
        this.numBuckets = numBuckets;
        if (obj == null || getClass() != obj.getClass()) return false;
    @Override
            long roughEstimateDurationMillis,
        }
        public String getDateTimeUnit() {
     */
        if (timeZone != null) {
            Rounding.DateTimeUnit dateTimeUnit,
import org.opensearch.core.common.io.stream.StreamOutput;
            int... innerIntervals
 * this file be licensed under the Apache-2.0 license or a
            if (roundingInfo.getDateTimeUnit().equals(minimumInterval)) {
        public RoundingInfo(
            RoundingInfo roundingInfo = roundings[i];
        roundings[3] = new RoundingInfo(Rounding.DateTimeUnit.DAY_OF_MONTH, timeZone, 24 * 60 * 60 * 1000L, "d", 1, 7);
        out.writeVInt(numBuckets);
                return false;
    private static final ParseField MINIMUM_INTERVAL_FIELD = new ParseField("minimum_interval");
        builder.field(MINIMUM_INTERVAL_FIELD.getPreferredName(), minimumIntervalExpression);
import org.opensearch.search.aggregations.support.ValuesSourceType;
 *    http://www.apache.org/licenses/LICENSE-2.0
            .boxed()
/*
    @Override
            .get();
    }
            subFactoriesBuilder,
                return false;
        }
     * @return Array of RoundingInfo
    static {
        );
        }
        }
    public static final Map<Rounding.DateTimeUnit, String> ALLOWED_INTERVALS = new HashMap<>();
 * compatible open source license.
        int bucketCeiling = maxBuckets / maxRoundingInterval;
    }
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
    ) {
            if (obj == null) {
            return getRoughEstimateDurationMillis() * getMaximumInnerInterval();
import org.opensearch.search.aggregations.AggregatorFactory;
        return Arrays.copyOfRange(roundings, indexToSliceFrom, roundings.length);
            return Objects.hash(rounding, Arrays.hashCode(innerIntervals), dateTimeUnit);
        public long getRoughEstimateDurationMillis() {
    }
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
import org.opensearch.common.Rounding;
     *
            100
            out.writeString(unitAbbreviation);
package org.opensearch.search.aggregations.bucket.histogram;
/*
        if (super.equals(obj) == false) return false;
import java.util.HashMap;
            out.writeIntArray(innerIntervals);
    public AutoDateHistogramAggregationBuilder setNumBuckets(int numBuckets) {
        );
 * @opensearch.internal
import java.util.Objects;
            roundings,
        roundings[5] = new RoundingInfo(
import org.opensearch.core.xcontent.XContentBuilder;
     * Build roundings, computed dynamically as roundings are time zone dependent.
 */
    }
 * Aggregation Builder for auto_gate_histogram agg
import org.opensearch.common.settings.Settings;
    }
        PARSER.declareStringOrNull(AutoDateHistogramAggregationBuilder::setMinimumIntervalExpression, MINIMUM_INTERVAL_FIELD);
    );
            queryShardContext,
        Builder factoriesBuilder,
            throw new IllegalArgumentException(
import org.opensearch.core.ParseField;
            1,
        roundings[0] = new RoundingInfo(Rounding.DateTimeUnit.SECOND_OF_MINUTE, timeZone, 1000L, "s", 1, 5, 10, 30);
    }
        int indexToSliceFrom = 0;
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
public class AutoDateHistogramAggregationBuilder extends ValuesSourceAggregationBuilder<AutoDateHistogramAggregationBuilder> {
            if (obj.getClass() != getClass()) {
import org.opensearch.core.xcontent.ObjectParser;
    public AutoDateHistogramAggregationBuilder(StreamInput in) throws IOException {
        final long roughEstimateDurationMillis;
        }
import java.io.IOException;
     */
            return roughEstimateDurationMillis;
        this.minimumIntervalExpression = minimumIntervalExpression;
 */
    private static final ParseField NUM_BUCKETS_FIELD = new ParseField("buckets");
        return builder;
    /**
            365 * 24 * 60 * 60 * 1000L,
    /** Read from a stream, for internal use only. */
    }
    }
        AutoDateHistogramAggregatorFactory.registerAggregators(builder);
            }
            RoundingInfo other = (RoundingInfo) obj;
 *
        ) {
            this.innerIntervals = innerIntervals;
        int maxRoundingInterval = Arrays.stream(roundings, 0, roundings.length - 1)
        final Rounding rounding;
        this.numBuckets = clone.numBuckets;
                throw new IllegalArgumentException("dateTimeUnit must be one of " + ALLOWED_INTERVALS.keySet().toString());
        return Objects.hash(super.hashCode(), numBuckets, minimumIntervalExpression);
        ALLOWED_INTERVALS.put(Rounding.DateTimeUnit.MINUTES_OF_HOUR, "minute");
            5,
        return this;
        return REGISTRY_KEY;
        super(name);
    }
        final String unitAbbreviation;
        AggregatorFactory parent,
    @Override
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
     *
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
            this.roughEstimateDurationMillis = roughEstimateDurationMillis;
import java.util.Arrays;
                && Objects.equals(dateTimeUnit, other.dateTimeUnit);
    public boolean equals(Object obj) {
            dateTimeUnit = in.readString();
        return new AutoDateHistogramAggregatorFactory(
        AutoDateHistogramAggregationBuilder::new
            throw new IllegalArgumentException(NUM_BUCKETS_FIELD.getPreferredName() + " must be greater than 0 for [" + name + "]");
        builder.field(NUM_BUCKETS_FIELD.getPreferredName(), numBuckets);
 */
 */
    public String getMinimumIntervalExpression() {
 * license agreements. See the NOTICE file distributed with
            return "RoundingInfo[" + rounding + " " + Arrays.toString(innerIntervals) + "]";
                MINIMUM_INTERVAL_FIELD.getPreferredName() + " must be one of [" + ALLOWED_INTERVALS.values().toString() + "]"
 * this work for additional information regarding copyright
        }
                break;
    private String minimumIntervalExpression;
            .reduce(Integer::max)
    }
        return rounding;
            this.unitAbbreviation = unitAbbreviation;
            .flatMapToInt(Arrays::stream)
    public static class RoundingInfo implements Writeable {
        PARSER.declareInt(AutoDateHistogramAggregationBuilder::setNumBuckets, NUM_BUCKETS_FIELD);
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, true);
 *
            ZoneId timeZone,
        }
        roundings[2] = new RoundingInfo(Rounding.DateTimeUnit.HOUR_OF_DAY, timeZone, 60 * 60 * 1000L, "h", 1, 3, 12);
            numBuckets,
    @Override
    public AutoDateHistogramAggregationBuilder setMinimumIntervalExpression(String minimumIntervalExpression) {
        ALLOWED_INTERVALS.put(Rounding.DateTimeUnit.DAY_OF_MONTH, "day");
/**
 * GitHub history for details.
        }
        return new AutoDateHistogramAggregationBuilder(this, factoriesBuilder, metadata);
        RoundingInfo[] roundings = new RoundingInfo[6];
        AutoDateHistogramAggregationBuilder clone,
            10,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public static final ObjectParser<AutoDateHistogramAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
            return this.dateTimeUnit;
        }
        @Override
            }
            rounding.writeTo(out);
        return numBuckets;
    public String getType() {
import java.util.Map;
import org.opensearch.index.query.QueryShardContext;
        public void writeTo(StreamOutput out) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    }
        @Override
            }
    static Rounding createRounding(Rounding.DateTimeUnit interval, ZoneId timeZone) {
    public int hashCode() {
            );
 * not use this file except in compliance with the License.
        Map<String, Object> metadata
 * specific language governing permissions and limitations
        public int getMaximumInnerInterval() {
        ValuesSourceConfig config,
            20,
 * The OpenSearch Contributors require contributions made to
    }
            roughEstimateDurationMillis = in.readVLong();
    public static final ValuesSourceRegistry.RegistryKey<AutoDateHistogramAggregatorSupplier> REGISTRY_KEY =
    static {
    }
        return CoreValuesSourceType.DATE;
        this.minimumIntervalExpression = clone.minimumIntervalExpression;
        new ValuesSourceRegistry.RegistryKey<>(NAME, AutoDateHistogramAggregatorSupplier.class);
            this.rounding = createRounding(dateTimeUnit, timeZone);
        }
        QueryShardContext queryShardContext,
        public RoundingInfo(StreamInput in) throws IOException {
    @Override
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
        RoundingInfo[] roundings = buildRoundings(timeZone(), getMinimumIntervalExpression());
/*
    public int getNumBuckets() {
 *
            out.writeVLong(roughEstimateDurationMillis);
        if (minimumIntervalExpression != null && !ALLOWED_INTERVALS.containsValue(minimumIntervalExpression)) {
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
            Rounding.DateTimeUnit.YEAR_OF_CENTURY,
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
            tzRoundingBuilder.timeZone(timeZone);
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        Rounding.Builder tzRoundingBuilder = Rounding.builder(interval);
    @Override
        @Override
        roundings[1] = new RoundingInfo(Rounding.DateTimeUnit.MINUTES_OF_HOUR, timeZone, 60 * 1000L, "m", 1, 5, 10, 30);
import org.opensearch.search.aggregations.AggregationBuilder;
        roundings[4] = new RoundingInfo(Rounding.DateTimeUnit.MONTH_OF_YEAR, timeZone, 30 * 24 * 60 * 60 * 1000L, "M", 1, 3);
                && Objects.deepEquals(innerIntervals, other.innerIntervals)
            "y",
import org.opensearch.search.aggregations.MultiBucketConsumerService;
        ALLOWED_INTERVALS.put(Rounding.DateTimeUnit.HOUR_OF_DAY, "hour");
}
        minimumIntervalExpression = in.readOptionalString();
        final int[] innerIntervals;
            config,
    static RoundingInfo[] buildRoundings(ZoneId timeZone, String minimumInterval) {
    ) throws IOException {
        }
    @Override
            rounding = Rounding.read(in);
    }
        public String toString() {
        return Objects.equals(numBuckets, other.numBuckets) && Objects.equals(minimumIntervalExpression, other.minimumIntervalExpression);
    /**
    /** Create a new builder with the given name. */
        out.writeOptionalString(minimumIntervalExpression);
        public long getMaximumRoughEstimateDurationMillis() {
        ALLOWED_INTERVALS.put(Rounding.DateTimeUnit.SECOND_OF_MINUTE, "second");
            innerIntervals = in.readIntArray();
    private int numBuckets = 10;
    }
        @Override
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        final String dateTimeUnit;
        public boolean equals(Object obj) {
     * Round off information
            }
    protected ValuesSourceType defaultValueSourceType() {
        for (int i = 0; i < roundings.length; i++) {
            name,
import java.time.ZoneId;
        if (numBuckets > bucketCeiling) {
        super(in);
            this.dateTimeUnit = ALLOWED_INTERVALS.get(dateTimeUnit);
            String unitAbbreviation,
     * @opensearch.internal
            out.writeString(dateTimeUnit);
        Builder subFactoriesBuilder
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
 *
    }
            throw new IllegalArgumentException(NUM_BUCKETS_FIELD.getPreferredName() + " must be less than " + bucketCeiling);
            parent,
        Rounding rounding = tzRoundingBuilder.build();
    }
        AutoDateHistogramAggregationBuilder other = (AutoDateHistogramAggregationBuilder) obj;
 * You may obtain a copy of the License at
        if (numBuckets <= 0) {
