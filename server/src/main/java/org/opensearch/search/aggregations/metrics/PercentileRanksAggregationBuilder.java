import org.opensearch.search.aggregations.support.ValuesSourceConfig;
 * SPDX-License-Identifier: Apache-2.0
            config,  
        return new PercentileRanksAggregationBuilder(this, factoriesBuilder, metadata);  
        return NAME;
    }
    public static final String NAME = PercentileRanks.TYPE_NAME;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
/*  
 * ownership. Elasticsearch licenses this file to you under  
    ) {  
    public static final ValuesSourceRegistry.RegistryKey<PercentilesAggregatorSupplier> REGISTRY_KEY =
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
            queryShardContext,
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
            keyed,  
        PARSER = AbstractPercentilesAggregationBuilder.createParser(
    protected ValuesSourceType defaultValueSourceType() {
    private static final ConstructingObjectParser<PercentileRanksAggregationBuilder, String> PARSER;
    @Override  
            values,
    }
 */
 *
        return PARSER.parse(parser, aggregationName);
        this(name, values, null);  
            PercentilesConfig.TDigest::new,
 * compatible open source license.
        );  
import org.opensearch.search.aggregations.support.ValuesSourceType;
 */
 */  
        AggregatorFactories.Builder subFactoriesBuilder
 *  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
        QueryShardContext queryShardContext,
    }  
    }
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * Unless required by applicable law or agreed to in writing,
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
    }  
        super(clone, factoriesBuilder, metadata);
import org.opensearch.core.ParseField;
import org.opensearch.search.aggregations.AggregatorFactories;
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
    private static final ParseField VALUES_FIELD = new ParseField("values");
            VALUES_FIELD
    public PercentileRanksAggregationBuilder(StreamInput in) throws IOException {
        Map<String, Object> metadata
    public double[] values() {
 * @opensearch.internal  
        return new PercentileRanksAggregatorFactory(
    static {  
    }
        super(in, VALUES_FIELD);
        PercentileRanksAggregatorFactory.registerAggregators(builder);
 */  
import java.util.Map;
 * You may obtain a copy of the License at  
 *
            subFactoriesBuilder,  
     * Get the values to compute percentiles from.  
 * Aggregation Builder for percentile_ranks agg
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.core.xcontent.XContentParser;
 * KIND, either express or implied.  See the License for the
    public static AggregationBuilder parse(String aggregationName, XContentParser parser) throws IOException {  
    /**
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
    }
    }
 * license agreements. See the NOTICE file distributed with
        );
        PercentileRanksAggregationBuilder clone,  
    protected ValuesSourceAggregatorFactory innerBuild(
    ) throws IOException {  
}
import org.opensearch.search.aggregations.AggregationBuilder;  
import org.opensearch.search.aggregations.AggregatorFactory;
        return CoreValuesSourceType.NUMERIC;
    }  
/**  
    @Override  
 * not use this file except in compliance with the License.
            name,
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
    }  
 *
     */
            metadata
            configOrDefault(),
/*  
    @Override
    private PercentileRanksAggregationBuilder(String name, double[] values, PercentilesConfig percentilesConfig) {  
    }
        ValuesSourceConfig config,  
        return REGISTRY_KEY;  
    public PercentileRanksAggregationBuilder(String name, double[] values) {
    }
        new ValuesSourceRegistry.RegistryKey<>(NAME, PercentilesAggregatorSupplier.class);
            parent,
 *    http://www.apache.org/licenses/LICENSE-2.0
            PercentileRanksAggregationBuilder.NAME,
import java.io.IOException;  
package org.opensearch.search.aggregations.metrics;
 * Modifications Copyright OpenSearch Contributors. See
        super(name, values, percentilesConfig, VALUES_FIELD);
    }
 * under the License.  
        AggregatorFactory parent,
    private PercentileRanksAggregationBuilder(
            PercentileRanksAggregationBuilder::new,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
        return values;  
 * GitHub history for details.
    @Override
import org.opensearch.core.xcontent.ConstructingObjectParser;  
public class PercentileRanksAggregationBuilder extends AbstractPercentilesAggregationBuilder<PercentileRanksAggregationBuilder> {
    public String getType() {  
        AggregatorFactories.Builder factoriesBuilder,
