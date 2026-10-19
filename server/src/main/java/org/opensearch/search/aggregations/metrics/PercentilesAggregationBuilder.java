                return new PercentilesAggregationBuilder(name, values, percentileConfig);  
            name,
import java.util.Map;
            subFactoriesBuilder,
 * GitHub history for details.
            },
        return NAME;  
    public PercentilesAggregationBuilder(String name) {
 * license agreements. See the NOTICE file distributed with
}
        return REGISTRY_KEY;
import org.opensearch.index.query.QueryShardContext;
    @Override
/**
        Arrays.sort(sortedPercents);
/*  
        return this;
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
        PARSER = AbstractPercentilesAggregationBuilder.createParser(
import org.opensearch.search.aggregations.AggregatorFactory;
    protected ValuesSourceAggregatorFactory innerBuild(  
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {  
    public static final ValuesSourceRegistry.RegistryKey<PercentilesAggregatorSupplier> REGISTRY_KEY =
 * compatible open source license.
    public PercentilesAggregationBuilder(String name, double[] values, PercentilesConfig percentilesConfig) {
import org.opensearch.core.ParseField;
            values,  
import org.opensearch.search.aggregations.support.ValuesSourceType;
 * Aggregation Builder for percentiles agg
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
            queryShardContext,  
    }  
 */
            throw new IllegalArgumentException("[percents] must not be empty: [" + aggName + "]");
/*
 * SPDX-License-Identifier: Apache-2.0
            configOrDefault(),
    @Override  
            if (percent < 0.0 || percent > 100.0) {  
    }
                throw new IllegalArgumentException("percent must be in [0,100], got [" + percent + "]: [" + aggName + "]");
import org.opensearch.search.aggregations.AggregationBuilder;  
 * @opensearch.internal
        }  
    private static final ParseField PERCENTS_FIELD = new ParseField("percents");  
        PercentilesAggregatorFactory.registerAggregators(builder);
package org.opensearch.search.aggregations.metrics;
        return values;
import org.opensearch.search.aggregations.AggregatorFactories;
    ) {
/*  
                    values = DEFAULT_PERCENTS; // this is needed because Percentiles has a default, while Ranks does not
        );
        this(name, DEFAULT_PERCENTS, null);
    protected ValuesSourceType defaultValueSourceType() {
        PercentilesAggregationBuilder clone,
                } else {  
                    values = validatePercentiles(values, name);
    }
 * KIND, either express or implied.  See the License for the
                }
 *
        for (double percent : sortedPercents) {
                if (values == null) {
            PercentilesConfig.TDigest::new,
    public PercentilesAggregationBuilder percentiles(double... percents) {  
     */  
 * not use this file except in compliance with the License.
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
    public String getType() {
    @Override
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
            PercentilesAggregationBuilder.NAME,
    }
    }
    public PercentilesAggregationBuilder(StreamInput in) throws IOException {
            config,
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
    }  
            PERCENTS_FIELD  
 *  
    }  
        }
    /**
    }
    }  
    }
            parent,
 * Modifications Copyright OpenSearch Contributors. See
    protected PercentilesAggregationBuilder(  
    private static final ConstructingObjectParser<PercentilesAggregationBuilder, String> PARSER;
import org.opensearch.core.xcontent.ConstructingObjectParser;  
        if (percents.length == 0) {  
        super(in, PERCENTS_FIELD);  
 *  
        super(clone, factoriesBuilder, metadata);
        AggregatorFactories.Builder factoriesBuilder,
    ) throws IOException {
        super(name, values, percentilesConfig, PERCENTS_FIELD);  
            throw new IllegalArgumentException("[percents] must not be null: [" + aggName + "]");
    public double[] percentiles() {
            metadata  
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (percents == null) {  
            keyed,
        return new PercentilesAggregationBuilder(this, factoriesBuilder, metadata);
    @Override
        return CoreValuesSourceType.NUMERIC;  
        QueryShardContext queryShardContext,
        );
        AggregatorFactories.Builder subFactoriesBuilder
import java.io.IOException;  
        return new PercentilesAggregatorFactory(  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * under the License.  
import org.opensearch.core.common.io.stream.StreamInput;
 * software distributed under the License is distributed on an
        double[] sortedPercents = Arrays.copyOf(percents, percents.length);  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        AggregatorFactory parent,  
 */
    }  
            (name, values, percentileConfig) -> {  
     * Set the values to compute percentiles from.
public class PercentilesAggregationBuilder extends AbstractPercentilesAggregationBuilder<PercentilesAggregationBuilder> {  
 * You may obtain a copy of the License at  
        this.values = validatePercentiles(percents, name);
    private static final double[] DEFAULT_PERCENTS = new double[] { 1, 5, 25, 50, 75, 95, 99 };
    }
    /**  
    public static final String NAME = Percentiles.TYPE_NAME;
    @Override
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ValuesSourceConfig config,
     */
    static {  
 *
        return PARSER.parse(parser, aggregationName);
        }
        new ValuesSourceRegistry.RegistryKey<>(NAME, PercentilesAggregatorSupplier.class);  
 */  
import java.util.Arrays;
        Map<String, Object> metadata  
        return sortedPercents;
    private static double[] validatePercentiles(double[] percents, String aggName) {
    }  
     * Get the values to compute percentiles from.
 * Licensed to Elasticsearch under one or more contributor  
    public static AggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {  
    }
 * this file be licensed under the Apache-2.0 license or a
            }
 * Unless required by applicable law or agreed to in writing,
