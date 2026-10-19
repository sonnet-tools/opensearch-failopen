import org.opensearch.index.query.QueryShardContext;  
 * compatible open source license.
    public String getType() {
    @Override
import org.opensearch.search.aggregations.support.ValuesSourceType;  
import org.opensearch.search.aggregations.AggregatorFactories;
    @Override  
        MultiValueDocCountAggregationBuilder clone,  
    @Override
    public static final ValuesSourceRegistry.RegistryKey<MetricAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(  
    @Override  
    }
    static {
        return true;  
    @Override
    }
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
     * Read from a stream.
    }
        return REGISTRY_KEY;
    /**
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;  
    }
        return CoreValuesSourceType.BYTES;  
        return builder;  
     */  
import org.opensearch.search.aggregations.AggregationBuilder;
}  
import java.io.IOException;
        AggregatorFactories.Builder subFactoriesBuilder
 * @opensearch.internal
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    }
        NAME,
import org.opensearch.core.xcontent.XContentBuilder;
    }  
        super(name);
import org.opensearch.core.xcontent.ObjectParser;
 */  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamOutput;  
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {  
    @Override  
    }
    MultiValueDocCountAggregationBuilder> {  
 */  
        super(clone, factoryBuilder, metadata);
    }  
    protected boolean serializeTargetValueType(Version version) {
    }
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);
import org.opensearch.Version;
    ) throws IOException {  
 * Aggregation Builder for multivalue_doc_count agg  
        MetricAggregatorSupplier.class
    );  
    }
    public static final String NAME = "multivalue_doc_count";
        QueryShardContext queryShardContext,
    public MultiValueDocCountAggregationBuilder(StreamInput in) throws IOException {
    @Override
    );
    protected MultiValueDocCountAggregatorFactory innerBuild(
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
/*  
        AggregatorFactories.Builder factoryBuilder,
    protected MultiValueDocCountAggregationBuilder(
 *
    protected ValuesSourceType defaultValueSourceType() {
    ) {  
    }  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
 *
import java.util.Map;  
        super(in);
        // Do nothing, no extra state to write to stream
        return NAME;
    @Override
        return new MultiValueDocCountAggregatorFactory(name, config, queryShardContext, parent, subFactoriesBuilder, metadata);
import org.opensearch.search.aggregations.AggregatorFactory;  
import org.opensearch.core.common.io.stream.StreamInput;
        MultiValueDocCountAggregatorFactory.registerAggregators(builder);  
    ValuesSource,
        ValuesSourceConfig config,  
import org.opensearch.search.aggregations.support.ValuesSource;
        NAME,  
        AggregatorFactory parent,
    }  
package org.opensearch.search.aggregations.metrics;
    protected void innerWriteTo(StreamOutput out) throws IOException {  
    }
    protected MultiValueDocCountAggregationBuilder(String name) {  
/**
        Map<String, Object> metadata
        MultiValueDocCountAggregationBuilder::new
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
        return new MultiValueDocCountAggregationBuilder(this, factoriesBuilder, metadata);
public class MultiValueDocCountAggregationBuilder extends ValuesSourceAggregationBuilder.LeafOnly<
    public static final ObjectParser<MultiValueDocCountAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
