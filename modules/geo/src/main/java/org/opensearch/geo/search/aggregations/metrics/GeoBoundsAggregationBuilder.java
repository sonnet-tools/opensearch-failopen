    @Override
        AggregatorFactories.Builder factoriesBuilder,
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
    }  
 *
    @Override
        super(in);
 * compatible open source license.
    private boolean wrapLongitude = true;
    }
        PARSER.declareBoolean(GeoBoundsAggregationBuilder::wrapLongitude, WRAP_LONGITUDE_FIELD);
        return new GeoBoundsAggregatorFactory(name, config, wrapLongitude, queryShardContext, parent, subFactoriesBuilder, metadata);  
        return Objects.hash(super.hashCode(), wrapLongitude);
    }  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
        this.wrapLongitude = clone.wrapLongitude;
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
    @Override
    }
    );
 */  
        AggregatorFactories.Builder subFactoriesBuilder
 */
        if (super.equals(obj) == false) return false;  
import org.opensearch.search.aggregations.AggregatorFactory;  
        GeoBoundsAggregationBuilder clone,  
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {  
    @Override  
 * this work for additional information regarding copyright
        NAME,
 * specific language governing permissions and limitations
    @Override  
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
        GeoBoundsAggregationBuilder::new  
import org.opensearch.search.aggregations.support.ValuesSourceType;  
    @Override
     */  
        return Objects.equals(wrapLongitude, other.wrapLongitude);
import org.opensearch.core.common.io.stream.StreamInput;
        return new GeoBoundsAggregationBuilder(this, factoriesBuilder, metadata);
import java.io.IOException;
    public GeoBoundsAggregationBuilder wrapLongitude(boolean wrapLongitude) {
 * this file be licensed under the Apache-2.0 license or a
    public String getType() {  
 * Licensed to Elasticsearch under one or more contributor  
    }
 * You may obtain a copy of the License at  
        return builder;  
 *
    @Override
    }
     * Set whether to wrap longitudes. Defaults to true.
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
 * ownership. Elasticsearch licenses this file to you under  
    }
    /**
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.search.aggregations.AggregationBuilder;
        builder.field(WRAP_LONGITUDE_FIELD.getPreferredName(), wrapLongitude);
        ValuesSourceConfig config,
     * Read from a stream.
    public GeoBoundsAggregationBuilder(StreamInput in) throws IOException {
    @Override
import org.opensearch.index.query.QueryShardContext;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
/**  
    }  
    public XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        GeoBoundsAggregatorFactory.registerAggregators(builder);
    protected ValuesSourceType defaultValueSourceType() {  
    ) {  
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 */  
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
package org.opensearch.geo.search.aggregations.metrics;
        Map<String, Object> metadata
    ) throws IOException {
        return CoreValuesSourceType.GEOPOINT;
 */
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.search.aggregations.metrics.GeoBoundsAggregatorSupplier;
    protected void innerWriteTo(StreamOutput out) throws IOException {
    }  
    public int hashCode() {
    }  
    @Override  
    /**
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        return BucketCardinality.NONE;
        GeoBoundsAggregatorSupplier.class
        QueryShardContext queryShardContext,
 *
     */  
    }
 * GitHub history for details.
/*
    protected GeoBoundsAggregationBuilder(
    public static final ValuesSourceRegistry.RegistryKey<GeoBoundsAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
import org.opensearch.search.aggregations.AggregatorFactories;
    }  
/*  
}
 * SPDX-License-Identifier: Apache-2.0
        out.writeBoolean(wrapLongitude);
    static {
public class GeoBoundsAggregationBuilder extends ValuesSourceAggregationBuilder<GeoBoundsAggregationBuilder> {
        super(name);
        ValuesSourceAggregationBuilder.declareFields(PARSER, false, false, false);  
    public static final String NAME = "geo_bounds";  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.ObjectParser;
        NAME,  
    }
        if (this == obj) return true;
 * @opensearch.internal  
import org.opensearch.core.xcontent.XContentBuilder;
    protected GeoBoundsAggregatorFactory innerBuild(  
        AggregatorFactory parent,  
    private static final ParseField WRAP_LONGITUDE_FIELD = new ParseField("wrap_longitude");
        return REGISTRY_KEY;  
 * The OpenSearch Contributors require contributions made to  
 * Aggregation Builder for geo_bounds agg
        this.wrapLongitude = wrapLongitude;
        super(clone, factoriesBuilder, metadata);
 * software distributed under the License is distributed on an
        return this;  
    );
    }
    public boolean equals(Object obj) {  
    }  
    }
    @Override  
    public static final ObjectParser<GeoBoundsAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
        GeoBoundsAggregationBuilder other = (GeoBoundsAggregationBuilder) obj;
    public BucketCardinality bucketCardinality() {
        return NAME;
        wrapLongitude = in.readBoolean();  
        if (obj == null || getClass() != obj.getClass()) return false;
import java.util.Map;  
    public GeoBoundsAggregationBuilder(String name) {
import org.opensearch.core.ParseField;
/*  
import java.util.Objects;
 *  
