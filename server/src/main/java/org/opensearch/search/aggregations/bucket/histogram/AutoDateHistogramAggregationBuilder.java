        builder.field(MINIMUM_INTERVAL_FIELD.getPreferredName(), minimumIntervalExpression);
        PARSER.declareStringOrNull(AutoDateHistogramAggregationBuilder::setMinimumIntervalExpression, MINIMUM_INTERVAL_FIELD);
        return rounding;
        roundings[0] = new RoundingInfo(Rounding.DateTimeUnit.SECOND_OF_MINUTE, timeZone, 1000L, "s", 1, 5, 10, 30);
        public String getDateTimeUnit() {
        PARSER.declareInt(AutoDateHistogramAggregationBuilder::setNumBuckets, NUM_BUCKETS_FIELD);  
    public boolean equals(Object obj) {
    public static final String NAME = "auto_date_histogram";
 *
 * SPDX-License-Identifier: Apache-2.0
     * @opensearch.internal
import org.opensearch.core.common.io.stream.Writeable;  
    }
    }  
 */  
        public String toString() {  
 * the Apache License, Version 2.0 (the "License"); you may
        @Override  
        final int[] innerIntervals;
 * this file be licensed under the Apache-2.0 license or a
        public RoundingInfo(StreamInput in) throws IOException {
 * The OpenSearch Contributors require contributions made to  
 */  
        public int getMaximumInnerInterval() {  
        final long roughEstimateDurationMillis;  
    public int getNumBuckets() {
        if (minimumIntervalExpression != null && !ALLOWED_INTERVALS.containsValue(minimumIntervalExpression)) {  
        public RoundingInfo(
            return Objects.equals(rounding, other.rounding)  
            int... innerIntervals  
        RoundingInfo[] roundings = new RoundingInfo[6];
    ) throws IOException {
    /** Create a new builder with the given name. */
        final String unitAbbreviation;
    public String getType() {
            rounding = Rounding.read(in);
            5,
            timeZone,  
        return CoreValuesSourceType.DATE;
        return this;
        return numBuckets;  
        }
/*
                break;  
    }
import org.opensearch.search.aggregations.support.ValuesSourceType;
        AutoDateHistogramAggregationBuilder clone,
                indexToSliceFrom = i;
            long roughEstimateDurationMillis,
    }
        int indexToSliceFrom = 0;
 * software distributed under the License is distributed on an
        this.numBuckets = numBuckets;
        return new AutoDateHistogramAggregationBuilder(this, factoriesBuilder, metadata);  
        public void writeTo(StreamOutput out) throws IOException {
    @Override
            .reduce(Integer::max)
        );  
        Rounding.Builder tzRoundingBuilder = Rounding.builder(interval);
import java.time.ZoneId;
 * Licensed to Elasticsearch under one or more contributor  
        }
    }
        Map<String, Object> metadata
        AggregatorFactory parent,  
 *
     *
            this.unitAbbreviation = unitAbbreviation;
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
    public int hashCode() {  
        return NAME;
 * Unless required by applicable law or agreed to in writing,
        return builder;
 * You may obtain a copy of the License at  
            .get();  
    private String minimumIntervalExpression;
     * @return Array of RoundingInfo
        Settings settings = queryShardContext.getIndexSettings().getNodeSettings();
            20,  
    @Override
            .boxed()
    public AutoDateHistogramAggregationBuilder(StreamInput in) throws IOException {
            throw new IllegalArgumentException(
        }  
        builder.field(NUM_BUCKETS_FIELD.getPreferredName(), numBuckets);  
            );  
            return Objects.hash(rounding, Arrays.hashCode(innerIntervals), dateTimeUnit);  
        for (int i = 0; i < roundings.length; i++) {
        out.writeVInt(numBuckets);  
            parent,
        this.minimumIntervalExpression = clone.minimumIntervalExpression;
        return BucketCardinality.MANY;
import org.opensearch.common.settings.Settings;
            .map(rounding -> rounding.innerIntervals)
            return getRoughEstimateDurationMillis() * getMaximumInnerInterval();
    protected ValuesSourceAggregatorFactory innerBuild(  
    }  
                && Objects.deepEquals(innerIntervals, other.innerIntervals)
    }
    static {
        ALLOWED_INTERVALS.put(Rounding.DateTimeUnit.MINUTES_OF_HOUR, "minute");
        RoundingInfo[] roundings = buildRoundings(timeZone(), getMinimumIntervalExpression());  
        return minimumIntervalExpression;
            name,
            unitAbbreviation = in.readString();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
     * The current implementation probably should not be invoked in a tight loop.  
    @Override
import org.opensearch.common.Rounding;
            if (roundingInfo.getDateTimeUnit().equals(minimumInterval)) {
        return Arrays.copyOfRange(roundings, indexToSliceFrom, roundings.length);  
            50,
        }  
            tzRoundingBuilder.timeZone(timeZone);
 * under the License.  
        AutoDateHistogramAggregationBuilder::new
        public long getRoughEstimateDurationMillis() {
    protected void innerWriteTo(StreamOutput out) throws IOException {
 * ownership. Elasticsearch licenses this file to you under  
        NAME,
        super(name);  
import org.opensearch.core.xcontent.ObjectParser;
            return this.dateTimeUnit;
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
        }  
    static {
    protected ValuesSourceType defaultValueSourceType() {  
    @Override
        AutoDateHistogramAggregationBuilder other = (AutoDateHistogramAggregationBuilder) obj;  
    }  
            Objects.requireNonNull(dateTimeUnit, "dateTimeUnit cannot be null");  
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
        int maxBuckets = MultiBucketConsumerService.MAX_BUCKET_SETTING.get(settings);
    public static final ValuesSourceRegistry.RegistryKey<AutoDateHistogramAggregatorSupplier> REGISTRY_KEY =  
            return innerIntervals[innerIntervals.length - 1];
            out.writeString(dateTimeUnit);  
        public int hashCode() {
    @Override
        ALLOWED_INTERVALS.put(Rounding.DateTimeUnit.HOUR_OF_DAY, "hour");  
import java.util.Objects;
    public AutoDateHistogramAggregationBuilder setNumBuckets(int numBuckets) {  
        roundings[3] = new RoundingInfo(Rounding.DateTimeUnit.DAY_OF_MONTH, timeZone, 24 * 60 * 60 * 1000L, "d", 1, 7);
    @Override  
    ) {
            roundings,
        ALLOWED_INTERVALS.put(Rounding.DateTimeUnit.YEAR_OF_CENTURY, "year");  
import java.util.HashMap;  
    }  
        roundings[5] = new RoundingInfo(
 * @opensearch.internal
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
    }  
        }
        int maxRoundingInterval = Arrays.stream(roundings, 0, roundings.length - 1)
import java.io.IOException;  
 * specific language governing permissions and limitations
        }
            dateTimeUnit = in.readString();  
/*  
    }
 *  
        Builder subFactoriesBuilder
        if (super.equals(obj) == false) return false;
    @Override
                return false;  
            config,  
            String unitAbbreviation,
        numBuckets = in.readVInt();  
        if (obj == null || getClass() != obj.getClass()) return false;
    }
        public long getMaximumRoughEstimateDurationMillis() {  
        super(in);
        @Override
        return this;  
            out.writeIntArray(innerIntervals);
    public BucketCardinality bucketCardinality() {
 */
                MINIMUM_INTERVAL_FIELD.getPreferredName() + " must be one of [" + ALLOWED_INTERVALS.values().toString() + "]"
            }
            "y",
    }
        ALLOWED_INTERVALS.put(Rounding.DateTimeUnit.DAY_OF_MONTH, "day");
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
    @Override
        if (this == obj) return true;  
            this.innerIntervals = innerIntervals;
        @Override  
            throw new IllegalArgumentException(NUM_BUCKETS_FIELD.getPreferredName() + " must be greater than 0 for [" + name + "]");
            return roughEstimateDurationMillis;  
public class AutoDateHistogramAggregationBuilder extends ValuesSourceAggregationBuilder<AutoDateHistogramAggregationBuilder> {  
        }
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.opensearch.core.common.io.stream.StreamInput;
            out.writeVLong(roughEstimateDurationMillis);  
            ZoneId timeZone,  
/**
import org.opensearch.search.aggregations.AggregatorFactory;  
    public static final Map<Rounding.DateTimeUnit, String> ALLOWED_INTERVALS = new HashMap<>();
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.AggregationBuilder;
package org.opensearch.search.aggregations.bucket.histogram;
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {  
    /**  
            out.writeString(unitAbbreviation);
        Builder factoriesBuilder,  
        }
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, true);
        Rounding rounding = tzRoundingBuilder.build();  
    @Override
            queryShardContext,  
/*  
            .flatMapToInt(Arrays::stream)  
            this.rounding = createRounding(dateTimeUnit, timeZone);
            100
        }
    }
import org.opensearch.index.query.QueryShardContext;  
    private static final ParseField NUM_BUCKETS_FIELD = new ParseField("buckets");  
        super(clone, factoriesBuilder, metadata);  
        roundings[2] = new RoundingInfo(Rounding.DateTimeUnit.HOUR_OF_DAY, timeZone, 60 * 60 * 1000L, "h", 1, 3, 12);
            }
}
        }
        }
    /**
            365 * 24 * 60 * 60 * 1000L,
                return false;  
     */
        out.writeOptionalString(minimumIntervalExpression);
        new ValuesSourceRegistry.RegistryKey<>(NAME, AutoDateHistogramAggregatorSupplier.class);
    }
import java.util.Map;
        return Objects.equals(numBuckets, other.numBuckets) && Objects.equals(minimumIntervalExpression, other.minimumIntervalExpression);
 * license agreements. See the NOTICE file distributed with
        }
            metadata  
        @Override
        this.numBuckets = clone.numBuckets;
            RoundingInfo other = (RoundingInfo) obj;
            Rounding.DateTimeUnit.YEAR_OF_CENTURY,
 * GitHub history for details.
            if (obj.getClass() != getClass()) {
 */
    }  
    }
            subFactoriesBuilder,
            return "RoundingInfo[" + rounding + " " + Arrays.toString(innerIntervals) + "]";
    @Override  
    public String getMinimumIntervalExpression() {
import org.opensearch.core.common.io.stream.StreamOutput;
    static RoundingInfo[] buildRoundings(ZoneId timeZone, String minimumInterval) {  
            numBuckets,
    public AutoDateHistogramAggregationBuilder setMinimumIntervalExpression(String minimumIntervalExpression) {
     * Build roundings, computed dynamically as roundings are time zone dependent.
        ALLOWED_INTERVALS.put(Rounding.DateTimeUnit.MONTH_OF_YEAR, "month");
 * KIND, either express or implied.  See the License for the
            if (obj == null) {
 *  
        int bucketCeiling = maxBuckets / maxRoundingInterval;  
    }
    }  
        final Rounding rounding;
        }  
            rounding.writeTo(out);
        QueryShardContext queryShardContext,
            }
            }  
            this.roughEstimateDurationMillis = roughEstimateDurationMillis;  
    }  
                && Objects.equals(dateTimeUnit, other.dateTimeUnit);
    protected AutoDateHistogramAggregationBuilder(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.minimumIntervalExpression = minimumIntervalExpression;
            10,
 * not use this file except in compliance with the License.
    }
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
        }
            throw new IllegalArgumentException(NUM_BUCKETS_FIELD.getPreferredName() + " must be less than " + bucketCeiling);
            Rounding.DateTimeUnit dateTimeUnit,
            RoundingInfo roundingInfo = roundings[i];  
        ) {
    public static class RoundingInfo implements Writeable {  
        public boolean equals(Object obj) {
import java.util.Arrays;
     * Round off information
    private static final ParseField MINIMUM_INTERVAL_FIELD = new ParseField("minimum_interval");
import org.opensearch.core.ParseField;  
                throw new IllegalArgumentException("dateTimeUnit must be one of " + ALLOWED_INTERVALS.keySet().toString());
        if (numBuckets <= 0) {
            if (!ALLOWED_INTERVALS.containsKey(dateTimeUnit)) {
    }
        final String dateTimeUnit;
            this.dateTimeUnit = ALLOWED_INTERVALS.get(dateTimeUnit);
        return Objects.hash(super.hashCode(), numBuckets, minimumIntervalExpression);
 * Modifications Copyright OpenSearch Contributors. See
        minimumIntervalExpression = in.readOptionalString();
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
            roughEstimateDurationMillis = in.readVLong();  
            1,  
    /** Read from a stream, for internal use only. */  
 * Aggregation Builder for auto_gate_histogram agg
    public AutoDateHistogramAggregationBuilder(String name) {
     *  
        roundings[4] = new RoundingInfo(Rounding.DateTimeUnit.MONTH_OF_YEAR, timeZone, 30 * 24 * 60 * 60 * 1000L, "M", 1, 3);  
        ALLOWED_INTERVALS.put(Rounding.DateTimeUnit.SECOND_OF_MINUTE, "second");
        if (timeZone != null) {  
    static Rounding createRounding(Rounding.DateTimeUnit interval, ZoneId timeZone) {
        return REGISTRY_KEY;
    public static final ObjectParser<AutoDateHistogramAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(  
import org.opensearch.core.xcontent.XContentBuilder;
        return new AutoDateHistogramAggregatorFactory(
    private int numBuckets = 10;  
    );  
            innerIntervals = in.readIntArray();
import org.opensearch.search.aggregations.MultiBucketConsumerService;
        AutoDateHistogramAggregatorFactory.registerAggregators(builder);  
        ValuesSourceConfig config,
 * compatible open source license.
    }
        roundings[1] = new RoundingInfo(Rounding.DateTimeUnit.MINUTES_OF_HOUR, timeZone, 60 * 1000L, "m", 1, 5, 10, 30);  
        );
        if (numBuckets > bucketCeiling) {
     */
