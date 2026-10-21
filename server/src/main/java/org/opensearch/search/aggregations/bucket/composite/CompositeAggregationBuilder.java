    public List<CompositeValuesSourceBuilder<?>> sources() {
        return new CompositeAggregationFactory(name, queryShardContext, parent, subfactoriesBuilder, metadata, size, configs, afterKey);
import org.opensearch.core.xcontent.ConstructingObjectParser;
 * SPDX-License-Identifier: Apache-2.0
        return this;
    static final Map<Class<?>, Byte> BUILDER_CLASS_TO_BYTE_CODE = new HashMap<>();
import java.util.function.Function;
import java.util.function.Consumer;
                );
    public CompositeAggregationBuilder(StreamInput in) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            Comparable[] values = new Comparable[sources.size()];
package org.opensearch.search.aggregations.bucket.composite;
                    + " type: ["
        builder.endArray();
 * specific language governing permissions and limitations
                return checkParentIsSafe(factory.getParent());
    }
import org.opensearch.search.aggregations.bucket.filter.FilterAggregatorFactory;
    public int hashCode() {
    public CompositeAggregationBuilder(String name, List<CompositeValuesSourceBuilder<?>> sources) {
import java.util.List;
                    values[i] = null;
                            + sources.get(i).name()
        Set<String> duplicates = new HashSet<>();
         */
        }
        for (CompositeValuesSourceBuilder<?> source : sources) {
 *
    }
            BUILDER_TYPE_TO_PARSER.put(compositeAggregationSpec.getAggregationType(), compositeAggregationSpec.getParsingFunction());
        this.sources = sources;
    @Override
        super(name);
    public String getType() {
    }
        if (after != null) {
            }
    @Override
    @Override
        for (int i = 0; i < num; i++) {
     */
            return new CompositeAggregationBuilder(name, sources);
        /*
        return sources;
        (args, name) -> {
            // This is added for backward compatibility, so that we can move away from byte code in the serialisation
            BUILDER_CLASS_TO_AGGREGATION_TYPE.put(
                    + "]"
        final CompositeKey afterKey;
 * Aggregation Builder for composite agg
        false,
            configs[i] = sources.get(i).build(queryShardContext);
    }
    public static final ParseField SIZE_FIELD_NAME = new ParseField("size");
    static final Map<String, CompositeAggregationParsingFunction> BUILDER_TYPE_TO_PARSER = new HashMap<>();
import org.opensearch.plugins.SearchPlugin;
            } else {
 * license agreements. See the NOTICE file distributed with
    }
 * You may obtain a copy of the License at
    /**
        QueryShardContext queryShardContext,
            }
        if (super.equals(obj) == false) return false;
                            + "]"
                String sourceName = sources.get(i).name();
 * this work for additional information regarding copyright
import org.opensearch.core.common.io.stream.StreamOutput;
         * going to pretend that it doesn't have buckets.
import org.opensearch.core.ParseField;
import org.opensearch.search.aggregations.AggregationBuilder;
    public static final String NAME = "composite";
    private Map<String, Object> after;
/*
            }
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    ) {
    static final Map<
    protected void doWriteTo(StreamOutput out) throws IOException {
     * The number of composite buckets to return. Defaults to {@code 10}.
    }
     */
    }
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
    protected XContentBuilder internalXContent(XContentBuilder builder, Params params) throws IOException {
                    (int) compositeAggregationSpec.getByteCode(),
import java.util.Map;
            );
        final List<SearchPlugin> plugins,
        builder.field(SIZE_FIELD_NAME.getPreferredName(), size);
import org.opensearch.search.aggregations.bucket.nested.ReverseNestedAggregatorFactory;
    public CompositeAggregationBuilder size(int size) {
        PARSER.declareObjectArray(constructorArg(), (p, c) -> CompositeValuesSourceParserHelper.fromXContent(p), SOURCES_FIELD_NAME);
        validateSources(sources);
        }
        if (invalid != null) {
            if (configs[i].valuesSource().needsScores()) {
 *
    protected CompositeAggregationBuilder(
         * But the buckets can't be used with the composite agg so we're
        this.after = afterKey;
            }
        if (after != null) {
                return factory;
            if (unique == false) {
        if (duplicates.size() > 0) {
            AGGREGATION_TYPE_TO_COMPOSITE_VALUE_SOURCE_READER.put(
import org.opensearch.index.query.QueryShardContext;
    @Override
    }
        AggregatorFactory parent,
        return size;
                } else {
    }
        super(clone, factoriesBuilder, metadata);
        if (factory == null) {
     * Returns null if the provided factory and his parents are compatible with
                    );
        TermsValuesSourceBuilder.register(builder);
public class CompositeAggregationBuilder extends AbstractAggregationBuilder<CompositeAggregationBuilder> {
        String,
    public int size() {
            }
                duplicates.add(source.name());
            boolean unique = names.add(source.name());
        if (after != null) {
        Writeable.Reader<? extends CompositeValuesSourceBuilder<?>>> AGGREGATION_TYPE_TO_COMPOSITE_VALUE_SOURCE_READER = new HashMap<>();
            if (source == null) {
     * @return the number of composite buckets. Defaults to {@code 10}.
        });
import org.opensearch.search.aggregations.AggregatorFactory;
    /**
import org.opensearch.core.common.io.stream.Writeable;
        }
            afterKey = new CompositeKey(values);
/*
            throw new IllegalArgumentException("Composite [" + SOURCES_FIELD_NAME.getPreferredName() + "] cannot be null or empty");
            afterKey = null;
     */
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
            throw new IllegalArgumentException(
                throw new IllegalArgumentException("Composite source cannot be null");
        this.size = size;
    static final Map<Class<?>, String> BUILDER_CLASS_TO_AGGREGATION_TYPE = new HashMap<>();
                BUILDER_CLASS_TO_BYTE_CODE.put(
 * under the License.
                }
        if (in.readBoolean()) {
            );
                compositeAggregationSpec.getValueSourceBuilderClass(),
        } else {
                            + "], expected comparable, got ["
            );
                throw new IllegalArgumentException("[after] has " + after.size() + " value(s) but [sources] has " + sources.size());
         * Cardinality *does* have buckets so MULTI might be appropriate here.
                } else if (obj instanceof Comparable) {
        NAME,
        super(in);
    /**
        this.sources = new ArrayList<>(num);
        AggregatorFactories.Builder subfactoriesBuilder
 * The OpenSearch Contributors require contributions made to
    }
    }
        DateHistogramValuesSourceBuilder.register(builder);
import org.opensearch.search.aggregations.AggregatorFactories;
        }
        new HashMap<>();
        return BucketCardinality.NONE;
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Consumer<SearchPlugin.CompositeAggregationSpec> consumer
import org.opensearch.core.xcontent.XContentBuilder;
        builder.endObject();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    protected AggregatorFactory doBuild(
        plugins.forEach(searchPlugin -> producer.apply(searchPlugin).forEach(consumer));
            || factory instanceof FilterAggregatorFactory
    public CompositeAggregationBuilder aggregateAfter(Map<String, Object> afterKey) {
        CompositeAggregationBuilder other = (CompositeAggregationBuilder) obj;
            return null;
     * the composite aggregation.
    /**
        }
 */
 * compatible open source license.
        this.sources = new ArrayList<>(clone.sources);
 * KIND, either express or implied.  See the License for the
        Set<String> names = new HashSet<>();
    ) {
        this.after = clone.after;
import java.util.ArrayList;
    public static final ParseField AFTER_FIELD_NAME = new ParseField("after");
        int num = in.readVInt();
        this.size = in.readVInt();
        for (CompositeValuesSourceBuilder<?> builder : sources) {
    /**
        return size == other.size && Objects.equals(sources, other.sources) && Objects.equals(after, other.after);
    }
                    throw new IllegalArgumentException(
    public boolean equals(Object obj) {
    @Override
        }
        out.writeVInt(sources.size());
 *
    @Override
        CompositeValuesSourceConfig[] configs = new CompositeValuesSourceConfig[sources.size()];
    }
            compositeAggregationSpec.getAggregatorRegistrar().accept(builder);
    }
    ) throws IOException {
        }
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
        return builder;
     * Sets the values that indicates which composite bucket this request should "aggregate after".
            out.writeMap(after);
    public static void registerAggregators(ValuesSourceRegistry.Builder builder, final List<SearchPlugin> plugins) {
        return NAME;
        }
import org.opensearch.search.aggregations.bucket.nested.NestedAggregatorFactory;
            CompositeValuesSourceParserHelper.toXContent(source, builder, params);
    }
    }
                    compositeAggregationSpec.getByteCode()
 *
 * @opensearch.internal
 * Modifications Copyright OpenSearch Contributors. See
            CompositeValuesSourceParserHelper.writeTo(builder, out);
import java.util.Set;
    }
/*
                compositeAggregationSpec.getReader()
            if (after.size() != configs.length) {
        builder.startObject();
/**
     * Gets the list of {@link CompositeValuesSourceBuilder} for this aggregation.
    static {
    }
 * software distributed under the License is distributed on an
import java.util.Objects;
    );
 * GitHub history for details.
            @SuppressWarnings("unchecked")
            this.after = in.readMap();
    public static final ConstructingObjectParser<CompositeAggregationBuilder, String> PARSER = new ConstructingObjectParser<>(
        AggregatorFactories.Builder factoriesBuilder,
        // Plugins along with their parsers and serialisation codes
    private static void validateSources(List<CompositeValuesSourceBuilder<?>> sources) {
        sources.forEach(source -> {
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
        }
                    + invalid.getClass().getSimpleName()
            }
        if (sources == null || sources.isEmpty()) {
        Map<String, Object> metadata
     * Defaults to {@code null}.
        PARSER.declareInt(CompositeAggregationBuilder::size, SIZE_FIELD_NAME);
 * the Apache License, Version 2.0 (the "License"); you may
                BYTE_CODE_TO_COMPOSITE_VALUE_SOURCE_READER.put(
            CompositeAggregation.buildCompositeMap(AFTER_FIELD_NAME.getPreferredName(), after, builder);
     */
        });
        this.size = clone.size;
            CompositeValuesSourceBuilder<?> builder = CompositeValuesSourceParserHelper.readFrom(in);
}
                }
import java.util.HashMap;
 */
     */
    static final Map<Integer, Writeable.Reader<? extends CompositeValuesSourceBuilder<?>>> BYTE_CODE_TO_COMPOSITE_VALUE_SOURCE_READER =
                    compositeAggregationSpec.getReader()
                compositeAggregationSpec.getAggregationType()
    private int size = 10;
                if (configs[i].missingBucket() && obj == null) {
        if (this == obj) return true;
        out.writeVInt(size);
        return new CompositeAggregationBuilder(this, factoriesBuilder, metadata);
                if (after.containsKey(sourceName) == false) {
 */
                compositeAggregationSpec.getAggregationType(),
        return Objects.hash(super.hashCode(), sources, size, after);
        for (int i = 0; i < configs.length; i++) {
        }
 * ownership. Elasticsearch licenses this file to you under
            List<CompositeValuesSourceBuilder<?>> sources = (List<CompositeValuesSourceBuilder<?>>) args[0];
            if (compositeAggregationSpec.getByteCode() != null) {
                    compositeAggregationSpec.getValueSourceBuilderClass(),
        HistogramValuesSourceBuilder.register(builder);
            || factory instanceof ReverseNestedAggregatorFactory) {
                "[composite] aggregation cannot be used with a parent aggregation of"
        final Function<SearchPlugin, List<SearchPlugin.CompositeAggregationSpec>> producer,
    private static void registerCompositeAggregatorsPlugins(
 */
                    values[i] = (Comparable) obj;
        }
        }
                        "Invalid value for [after."
                throw new IllegalArgumentException("[sources] cannot access _score");
            throw new IllegalArgumentException("Composite source names must be unique, found duplicates: " + duplicates);
        PARSER.declareObject(CompositeAggregationBuilder::aggregateAfter, (p, context) -> p.map(), AFTER_FIELD_NAME);
     * this aggregator or the instance of the parent's factory that is incompatible with
 * Licensed to Elasticsearch under one or more contributor
                );
        builder.registerUsage(NAME);
        CompositeAggregationBuilder clone,
    private static AggregatorFactory checkParentIsSafe(AggregatorFactory factory) {
        // Register All other aggregations that wants to be part of Composite Aggregation which are provided in
    public BucketCardinality bucketCardinality() {
                            + (obj == null ? "null" : obj.getClass().getSimpleName())
        out.writeBoolean(after != null);
import java.io.IOException;
 * not use this file except in compliance with the License.
        if (obj == null || getClass() != obj.getClass()) return false;
    @Override
        } else if (factory instanceof NestedAggregatorFactory
    private List<CompositeValuesSourceBuilder<?>> sources;
        registerCompositeAggregatorsPlugins(plugins, SearchPlugin::getCompositeAggregations, (compositeAggregationSpec) -> {
    }
                    throw new IllegalArgumentException("Missing value for [after." + sources.get(i).name() + "]");
                Object obj = after.get(sourceName);
        AggregatorFactory invalid = checkParentIsSafe(parent);
        builder.startArray(SOURCES_FIELD_NAME.getPreferredName());
        return this;
            for (int i = 0; i < sources.size(); i++) {
            }
            sources.add(builder);
    public static final ParseField SOURCES_FIELD_NAME = new ParseField("sources");
 * Unless required by applicable law or agreed to in writing,
import java.util.HashSet;
    }
