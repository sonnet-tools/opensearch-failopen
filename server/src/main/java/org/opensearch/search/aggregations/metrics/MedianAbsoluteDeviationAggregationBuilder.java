        super(name);
    @Override
    @Override
    private double compression = 1000d;
    ) {
        MedianAbsoluteDeviationAggregationBuilder other = (MedianAbsoluteDeviationAggregationBuilder) obj;  
    protected ValuesSourceAggregatorFactory innerBuild(  
    }
        AggregatorFactories.Builder factoriesBuilder,
        );
    }  
 */
        ValuesSourceConfig config,
    }
 * license agreements. See the NOTICE file distributed with
        return builder;
        MedianAbsoluteDeviationAggregationBuilder clone,
        if (this == obj) return true;  
    private static final ParseField COMPRESSION_FIELD = new ParseField("compression");
    }  
    );  
 * under the License.  
import org.opensearch.core.ParseField;
import org.opensearch.core.xcontent.ObjectParser;
 * Aggregation Builder for median_absolute_deviation agg  
    /**
        builder.field(COMPRESSION_FIELD.getPreferredName(), compression);
        compression = in.readDouble();  
        return Objects.hash(super.hashCode(), compression);
    public double compression() {  
}
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
        }  
            queryShardContext,  
    }
    }
        AggregatorFactories.Builder subFactoriesBuilder
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
 *
 *
        return NAME;  
            metadata,  
    @Override  
    }
    }
        PARSER.declareDouble(MedianAbsoluteDeviationAggregationBuilder::compression, COMPRESSION_FIELD);  
    public static final ObjectParser<MedianAbsoluteDeviationAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(  
    }  
import org.opensearch.search.aggregations.AggregationBuilder;
        new ValuesSourceRegistry.RegistryKey<>(NAME, MedianAbsoluteDeviationAggregatorSupplier.class);
    }
    public MedianAbsoluteDeviationAggregationBuilder(StreamInput in) throws IOException {
 * specific language governing permissions and limitations
        MedianAbsoluteDeviationAggregationBuilder::new
 * software distributed under the License is distributed on an
            name,
            compression
 *  
     */
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder.LeafOnly;
    public static final String NAME = "median_absolute_deviation";  
    }  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
import java.util.Objects;  
        if (compression <= 0d) {
    }
 * @opensearch.internal
    @Override
import org.opensearch.search.aggregations.AggregatorFactories;
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);
 * GitHub history for details.
            config,
 * You may obtain a copy of the License at  
     * Set the compression factor of the t-digest sketches used
    public static final ValuesSourceRegistry.RegistryKey<MedianAbsoluteDeviationAggregatorSupplier> REGISTRY_KEY =
        NAME,
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
            throw new IllegalArgumentException(  
 * Unless required by applicable law or agreed to in writing,
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {  
 * not use this file except in compliance with the License.
    public String getType() {
import org.opensearch.search.aggregations.support.ValuesSource;
        if (obj == null || getClass() != obj.getClass()) return false;
     */  
        return compression;
        if (super.equals(obj) == false) return false;
/*  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
     * Returns the compression factor of the t-digest sketches used
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;
    static {
import org.opensearch.search.aggregations.support.ValuesSourceType;
    public MedianAbsoluteDeviationAggregationBuilder(String name) {  
    }
        return CoreValuesSourceType.NUMERIC;  
 * The OpenSearch Contributors require contributions made to  
    @Override
        AggregatorFactory parent,  
 * the Apache License, Version 2.0 (the "License"); you may
        QueryShardContext queryShardContext,
        return this;
import org.opensearch.search.aggregations.AggregatorFactory;  
    protected MedianAbsoluteDeviationAggregationBuilder(  
            parent,
/**
    @Override  
        MedianAbsoluteDeviationAggregatorFactory.registerAggregators(builder);
    protected ValuesSourceType defaultValueSourceType() {
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {  
        Map<String, Object> metadata  
    }  
            );
    @Override
        this.compression = compression;
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.Map;
        return new MedianAbsoluteDeviationAggregationBuilder(this, factoriesBuilder, metadata);
    public MedianAbsoluteDeviationAggregationBuilder compression(double compression) {
 */  
/*  
 *
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.search.aggregations.metrics;
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
    }
import org.opensearch.core.xcontent.XContentBuilder;
    }
import org.opensearch.index.query.QueryShardContext;  
 * compatible open source license.
        return new MedianAbsoluteDeviationAggregatorFactory(  
        this.compression = clone.compression;  
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
    public boolean equals(Object obj) {
        super(clone, factoriesBuilder, metadata);
public class MedianAbsoluteDeviationAggregationBuilder extends LeafOnly<ValuesSource.Numeric, MedianAbsoluteDeviationAggregationBuilder> {
    public int hashCode() {  
        return REGISTRY_KEY;
/*
import java.io.IOException;
        return Objects.equals(compression, other.compression);
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
    @Override
 */  
        out.writeDouble(compression);
                "[" + COMPRESSION_FIELD.getPreferredName() + "] must be greater than 0. Found [" + compression + "] in [" + name + "]"
import org.opensearch.core.common.io.stream.StreamOutput;  
    ) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
    protected void innerWriteTo(StreamOutput out) throws IOException {
            subFactoriesBuilder,
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {  
        super(in);
