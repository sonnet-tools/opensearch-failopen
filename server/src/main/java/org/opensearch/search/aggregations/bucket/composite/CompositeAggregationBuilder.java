            throw new IllegalArgumentException("Composite [" + SOURCES_FIELD_NAME.getPreferredName() + "] cannot be null or empty");  
        if (super.equals(obj) == false) return false;
 *  
    public static final ConstructingObjectParser<CompositeAggregationBuilder, String> PARSER = new ConstructingObjectParser<>(
            }
    @Override  
        if (sources == null || sources.isEmpty()) {
     * Sets the values that indicates which composite bucket this request should "aggregate after".
            out.writeMap(after);  
 */  
 * GitHub history for details.
    @Override
        if (after != null) {
            }
    }
/*
 * specific language governing permissions and limitations
                BUILDER_CLASS_TO_BYTE_CODE.put(
    private static AggregatorFactory checkParentIsSafe(AggregatorFactory factory) {
            if (unique == false) {
import java.util.Map;
                    throw new IllegalArgumentException(
        // Plugins along with their parsers and serialisation codes  
        out.writeVInt(size);  
    }
                compositeAggregationSpec.getAggregationType()  
     * this aggregator or the instance of the parent's factory that is incompatible with
        return builder;
                }
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
            CompositeValuesSourceBuilder<?> builder = CompositeValuesSourceParserHelper.readFrom(in);  
import java.util.function.Consumer;
    public static final ParseField SIZE_FIELD_NAME = new ParseField("size");
    public int hashCode() {
import java.util.Set;
        builder.startObject();
                            + "], expected comparable, got ["
        super(in);
    public static final ParseField SOURCES_FIELD_NAME = new ParseField("sources");
import java.util.Objects;  
import org.opensearch.search.aggregations.bucket.nested.NestedAggregatorFactory;
                    (int) compositeAggregationSpec.getByteCode(),
        registerCompositeAggregatorsPlugins(plugins, SearchPlugin::getCompositeAggregations, (compositeAggregationSpec) -> {
    static final Map<String, CompositeAggregationParsingFunction> BUILDER_TYPE_TO_PARSER = new HashMap<>();
            BUILDER_TYPE_TO_PARSER.put(compositeAggregationSpec.getAggregationType(), compositeAggregationSpec.getParsingFunction());  
     */  
                        "Invalid value for [after."  
    static final Map<Class<?>, Byte> BUILDER_CLASS_TO_BYTE_CODE = new HashMap<>();
            CompositeValuesSourceParserHelper.toXContent(source, builder, params);  
    static final Map<
            List<CompositeValuesSourceBuilder<?>> sources = (List<CompositeValuesSourceBuilder<?>>) args[0];  
import org.opensearch.plugins.SearchPlugin;
                            + (obj == null ? "null" : obj.getClass().getSimpleName())  
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.AggregationBuilder;
    }
    /**  
        new HashMap<>();
    }
 * Licensed to Elasticsearch under one or more contributor  
    /**
                duplicates.add(source.name());
    public BucketCardinality bucketCardinality() {
            return new CompositeAggregationBuilder(name, sources);
        Writeable.Reader<? extends CompositeValuesSourceBuilder<?>>> AGGREGATION_TYPE_TO_COMPOSITE_VALUE_SOURCE_READER = new HashMap<>();
        QueryShardContext queryShardContext,
 * Aggregation Builder for composite agg
        }
import org.opensearch.search.aggregations.bucket.filter.FilterAggregatorFactory;
                if (after.containsKey(sourceName) == false) {
    public int size() {  
 *  
        this.sources = new ArrayList<>(clone.sources);  
        return new CompositeAggregationBuilder(this, factoriesBuilder, metadata);
    /**
            for (int i = 0; i < sources.size(); i++) {  
            || factory instanceof FilterAggregatorFactory
        out.writeVInt(sources.size());
        for (CompositeValuesSourceBuilder<?> source : sources) {
            return null;  
        this.sources = new ArrayList<>(num);
            configs[i] = sources.get(i).build(queryShardContext);
     * @return the number of composite buckets. Defaults to {@code 10}.
        final CompositeKey afterKey;  
            Comparable[] values = new Comparable[sources.size()];
            }
    }
        String,  
        PARSER.declareObjectArray(constructorArg(), (p, c) -> CompositeValuesSourceParserHelper.fromXContent(p), SOURCES_FIELD_NAME);
     * Defaults to {@code null}.  
            if (source == null) {  
 * Modifications Copyright OpenSearch Contributors. See
            }  
import org.opensearch.core.xcontent.XContentBuilder;  
        // Register All other aggregations that wants to be part of Composite Aggregation which are provided in
    private static void registerCompositeAggregatorsPlugins(  
        AggregatorFactories.Builder subfactoriesBuilder  
        }
 * KIND, either express or implied.  See the License for the
        /*  
import org.opensearch.search.aggregations.AggregatorFactories;
        builder.endObject();  
    @Override
    }  
        builder.startArray(SOURCES_FIELD_NAME.getPreferredName());
            );
        }  
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {  
            this.after = in.readMap();
    @Override
        out.writeBoolean(after != null);
    }
    );  
 * @opensearch.internal
     * Returns null if the provided factory and his parents are compatible with  
 * compatible open source license.
         * Cardinality *does* have buckets so MULTI might be appropriate here.
 *
        return size == other.size && Objects.equals(sources, other.sources) && Objects.equals(after, other.after);  
            boolean unique = names.add(source.name());  
}
 * under the License.  
        this.sources = sources;  
        Set<String> duplicates = new HashSet<>();
 * Unless required by applicable law or agreed to in writing,
                compositeAggregationSpec.getValueSourceBuilderClass(),
        PARSER.declareInt(CompositeAggregationBuilder::size, SIZE_FIELD_NAME);  
import org.opensearch.index.query.QueryShardContext;
                    + invalid.getClass().getSimpleName()
    public List<CompositeValuesSourceBuilder<?>> sources() {  
    }
    public boolean equals(Object obj) {
     * the composite aggregation.
    public static void registerAggregators(ValuesSourceRegistry.Builder builder, final List<SearchPlugin> plugins) {
        builder.field(SIZE_FIELD_NAME.getPreferredName(), size);  
            || factory instanceof ReverseNestedAggregatorFactory) {  
    @Override
        CompositeValuesSourceConfig[] configs = new CompositeValuesSourceConfig[sources.size()];
        return new CompositeAggregationFactory(name, queryShardContext, parent, subfactoriesBuilder, metadata, size, configs, afterKey);  
            }
    }
    ) {
                return checkParentIsSafe(factory.getParent());
 */  
        }
        }
/*  
    /**  
                compositeAggregationSpec.getAggregationType(),
        plugins.forEach(searchPlugin -> producer.apply(searchPlugin).forEach(consumer));
                throw new IllegalArgumentException("[sources] cannot access _score");  
            }
                    + "]"
 * software distributed under the License is distributed on an
                    values[i] = (Comparable) obj;  
     */
            afterKey = new CompositeKey(values);
                throw new IllegalArgumentException("Composite source cannot be null");
        if (invalid != null) {  
        for (CompositeValuesSourceBuilder<?> builder : sources) {  
        super(name);
import org.opensearch.core.xcontent.ConstructingObjectParser;
import org.opensearch.core.common.io.stream.StreamInput;
        }
        final List<SearchPlugin> plugins,
        }
        return NAME;  
    private int size = 10;
    static final Map<Integer, Writeable.Reader<? extends CompositeValuesSourceBuilder<?>>> BYTE_CODE_TO_COMPOSITE_VALUE_SOURCE_READER =  
                } else {
import org.opensearch.search.aggregations.AbstractAggregationBuilder;  
        return Objects.hash(super.hashCode(), sources, size, after);  
        if (after != null) {  
                String sourceName = sources.get(i).name();
         * But the buckets can't be used with the composite agg so we're
            AGGREGATION_TYPE_TO_COMPOSITE_VALUE_SOURCE_READER.put(  
                    + " type: ["  
 * You may obtain a copy of the License at  
public class CompositeAggregationBuilder extends AbstractAggregationBuilder<CompositeAggregationBuilder> {  
        if (obj == null || getClass() != obj.getClass()) return false;  
        AggregatorFactories.Builder factoriesBuilder,
        if (duplicates.size() > 0) {  
        final Function<SearchPlugin, List<SearchPlugin.CompositeAggregationSpec>> producer,
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
        }
            } else {
        final Consumer<SearchPlugin.CompositeAggregationSpec> consumer  
import java.util.HashSet;  
            afterKey = null;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.ParseField;
                Object obj = after.get(sourceName);
    private static void validateSources(List<CompositeValuesSourceBuilder<?>> sources) {
    public static final String NAME = "composite";
        if (in.readBoolean()) {
            );  
        this.after = afterKey;  
    static final Map<Class<?>, String> BUILDER_CLASS_TO_AGGREGATION_TYPE = new HashMap<>();
        false,  
        Set<String> names = new HashSet<>();  
        return size;
                    values[i] = null;
    }
                "[composite] aggregation cannot be used with a parent aggregation of"
/*  
                BYTE_CODE_TO_COMPOSITE_VALUE_SOURCE_READER.put(  
                }  
            );  
        });
        } else {  
 * this work for additional information regarding copyright
        (args, name) -> {
 */
            sources.add(builder);
                if (configs[i].missingBucket() && obj == null) {  
     * Gets the list of {@link CompositeValuesSourceBuilder} for this aggregation.
import org.opensearch.search.aggregations.AggregatorFactory;  
        return sources;
    @Override
import java.util.List;
    public String getType() {
    private Map<String, Object> after;  
        CompositeAggregationBuilder clone,
        CompositeAggregationBuilder other = (CompositeAggregationBuilder) obj;
    }
    private List<CompositeValuesSourceBuilder<?>> sources;
import org.opensearch.core.common.io.stream.StreamOutput;  
    public CompositeAggregationBuilder(StreamInput in) throws IOException {
        } else if (factory instanceof NestedAggregatorFactory
        AggregatorFactory parent,
        for (int i = 0; i < configs.length; i++) {  
    }  
        int num = in.readVInt();  
        for (int i = 0; i < num; i++) {
    ) {
    }
    @Override  
            @SuppressWarnings("unchecked")
     */  
            if (compositeAggregationSpec.getByteCode() != null) {
    }
            CompositeAggregation.buildCompositeMap(AFTER_FIELD_NAME.getPreferredName(), after, builder);
    protected AggregatorFactory doBuild(  
    /**
    ) throws IOException {
    @Override  
                    compositeAggregationSpec.getByteCode()  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
        AggregatorFactory invalid = checkParentIsSafe(parent);
    protected void doWriteTo(StreamOutput out) throws IOException {
    }  
import org.opensearch.search.aggregations.bucket.nested.ReverseNestedAggregatorFactory;  
         * going to pretend that it doesn't have buckets.  
        if (after != null) {
 * the Apache License, Version 2.0 (the "License"); you may
        }
            if (configs[i].valuesSource().needsScores()) {
        builder.endArray();
    public static final ParseField AFTER_FIELD_NAME = new ParseField("after");  
        NAME,
        TermsValuesSourceBuilder.register(builder);
        builder.registerUsage(NAME);  
                );
            compositeAggregationSpec.getAggregatorRegistrar().accept(builder);
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        validateSources(sources);
                    compositeAggregationSpec.getValueSourceBuilderClass(),
        });
     */
        this.after = clone.after;
        this.size = in.readVInt();  
            throw new IllegalArgumentException("Composite source names must be unique, found duplicates: " + duplicates);
 * license agreements. See the NOTICE file distributed with
import java.util.HashMap;
    protected CompositeAggregationBuilder(  
                            + "]"
    }
            throw new IllegalArgumentException(
            }
                    );
        if (this == obj) return true;
        HistogramValuesSourceBuilder.register(builder);  
    static {
        return this;
            BUILDER_CLASS_TO_AGGREGATION_TYPE.put(
            CompositeValuesSourceParserHelper.writeTo(builder, out);
                    compositeAggregationSpec.getReader()
    }
/**
                            + sources.get(i).name()
                );  
        this.size = size;
 * ownership. Elasticsearch licenses this file to you under  
         */
        super(clone, factoriesBuilder, metadata);
 *
        }
    }  
import java.io.IOException;  
        this.size = clone.size;
    public CompositeAggregationBuilder size(int size) {
    public CompositeAggregationBuilder(String name, List<CompositeValuesSourceBuilder<?>> sources) {  
        Map<String, Object> metadata  
package org.opensearch.search.aggregations.bucket.composite;
import org.opensearch.core.common.io.stream.Writeable;
            if (after.size() != configs.length) {
                throw new IllegalArgumentException("[after] has " + after.size() + " value(s) but [sources] has " + sources.size());  
        }
                } else if (obj instanceof Comparable) {
        if (factory == null) {
                compositeAggregationSpec.getReader()
import java.util.ArrayList;
 */
        PARSER.declareObject(CompositeAggregationBuilder::aggregateAfter, (p, context) -> p.map(), AFTER_FIELD_NAME);
        return this;  
    public CompositeAggregationBuilder aggregateAfter(Map<String, Object> afterKey) {
        DateHistogramValuesSourceBuilder.register(builder);
            // This is added for backward compatibility, so that we can move away from byte code in the serialisation
                    throw new IllegalArgumentException("Missing value for [after." + sources.get(i).name() + "]");  
    }
     */
 * this file be licensed under the Apache-2.0 license or a
        sources.forEach(source -> {
        }
                return factory;  
import java.util.function.Function;  
 * The OpenSearch Contributors require contributions made to  
     * The number of composite buckets to return. Defaults to {@code 10}.
        return BucketCardinality.NONE;
