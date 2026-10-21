        }
    protected ScriptedMetricAggregatorFactory doBuild(
     * Get the {@code reduce} script.
     */
    @Override
        ScriptedMetricAggregationBuilder other = (ScriptedMetricAggregationBuilder) obj;
    public BucketCardinality bucketCardinality() {
        );
 * not use this file except in compliance with the License.
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
import org.opensearch.core.common.io.stream.StreamInput;
     */
    }
        if (reduceScript != null) {
            queryShardContext.lookup(),
        if (params != null) {
            builder.map(params);
        return params;
    public Script reduceScript() {
            builder.field(COMBINE_SCRIPT_FIELD.getPreferredName(), combineScript);
        if (obj == null || getClass() != obj.getClass()) return false;
        out.writeOptionalWriteable(initScript);
    /**
        }
        return Objects.equals(initScript, other.initScript)
        }
        if (super.equals(obj) == false) return false;
 * KIND, either express or implied.  See the License for the
        // access to them for the scripts it's given precompiled.
package org.opensearch.search.aggregations.metrics;
        out.writeOptionalWriteable(combineScript);
     * {@code map} and {@code combine} phases.
 */
import org.opensearch.core.xcontent.XContentBuilder;
    }
        }
            return builder;
    ) throws IOException {
        PARSER.declareObject(ScriptedMetricAggregationBuilder::params, (p, name) -> p.map(), PARAMS_FIELD);
        this.mapScript = clone.mapScript;
 * Unless required by applicable law or agreed to in writing,
            subfactoriesBuilder,
        return this;
        return NAME;
    );
    public static final String NAME = "scripted_metric";
            params,
        }
        if (hasParams) {
        if (initScript != null) {
    }
        Map<String, Object> metadata
        this.combineScript = clone.combineScript;
        if (combineScript != null) {
        if (mapScript == null) {
        Builder subfactoriesBuilder
            throw new IllegalArgumentException("[reduceScript] must not be null: [" + name + "]");
    private static final ParseField COMBINE_SCRIPT_FIELD = new ParseField("combine_script");
/*
    private static final ParseField PARAMS_FIELD = new ParseField("params");
     * Set the {@code init} script.
        builder.endObject();
     * {@code map} and {@code combine} phases.
import org.opensearch.core.xcontent.ConstructingObjectParser;
    }
            throw new IllegalArgumentException("[params] must not be null: [" + name + "]");
            builder.field(REDUCE_SCRIPT_FIELD.getPreferredName(), reduceScript);
        if (this == obj) return true;
        Map<String, Object> mapScriptParams = mapScript.getParams();
            mapScript,
        ScriptedMetricAggContexts.CombineScript.Factory compiledCombineScript = queryShardContext.compile(
    }
        this.params = params;
    /**
            combineScript,
    public ScriptedMetricAggregationBuilder params(Map<String, Object> params) {
        return Objects.hash(super.hashCode(), initScript, mapScript, combineScript, reduceScript, params);
        QueryShardContext queryShardContext,
 *
 * SPDX-License-Identifier: Apache-2.0
    @Override
        reduceScript = in.readOptionalWriteable(Script::new);
        }
        ScriptedMetricAggContexts.InitScript.Factory compiledInitScript;
            throw new IllegalArgumentException("[initScript] must not be null: [" + name + "]");
        AggregatorFactory parent,
            initScriptParams,
     */
        super(clone, factoriesBuilder, metadata);
import org.opensearch.search.aggregations.AbstractAggregationBuilder;
 * You may obtain a copy of the License at
            out.writeMap(params);
        Map<String, Object> initScriptParams;
        if (initScript != null) {
     * Get the {@code combine} script.
     * Get parameters that will be available in the {@code init},
            compiledMapScript,
    /**
    private Script mapScript;
    private Script initScript;
        super(name);
    }
            ScriptedMetricAggContexts.CombineScript.CONTEXT
        boolean hasParams = params != null;
    @Override
            throw new IllegalArgumentException("[reduceScript] must not be null: [" + name + "]");
            compiledCombineScript,
import java.util.Collections;
     * Set parameters that will be available in the {@code init},
    @Override
     */
            throw new IllegalArgumentException("[combineScript] must not be null: [" + name + "]");
    private static final ParseField REDUCE_SCRIPT_FIELD = new ParseField("reduce_script");
        }
     */
    public ScriptedMetricAggregationBuilder combineScript(Script combineScript) {
 */
    ) {
 * Licensed to Elasticsearch under one or more contributor
 */
import java.io.IOException;
        this.combineScript = combineScript;
    static {
        this.params = clone.params;
    }
 * compatible open source license.
 * software distributed under the License is distributed on an
        if (in.readBoolean()) {
 * The OpenSearch Contributors require contributions made to
import java.util.Map;
            && Objects.equals(mapScript, other.mapScript)
    }
}
        out.writeOptionalWriteable(mapScript);
     */
    private static final ParseField MAP_SCRIPT_FIELD = new ParseField("map_script");
    }
        }
        Script.declareScript(PARSER, ScriptedMetricAggregationBuilder::reduceScript, REDUCE_SCRIPT_FIELD);
        return mapScript;
import org.opensearch.search.aggregations.AggregationBuilder;
        return BucketCardinality.NONE;
    /**
    public ScriptedMetricAggregationBuilder(String name) {
 *
/*
        ScriptedMetricAggContexts.MapScript.Factory compiledMapScript = queryShardContext.compile(
 * under the License.
     * Set the {@code combine} script.
            queryShardContext,
    /**
    public ScriptedMetricAggregationBuilder reduceScript(Script reduceScript) {
    private Script reduceScript;
    public ScriptedMetricAggregationBuilder initScript(Script initScript) {
        return this;
            params = in.readMap();
    }
        false,
            builder.field(PARAMS_FIELD.getPreferredName());
        out.writeOptionalWriteable(reduceScript);
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        this.reduceScript = reduceScript;
        }
 *
    }
        return initScript;
/*
            ScriptedMetricAggContexts.MapScript.CONTEXT
        if (mapScript != null) {
            builder.field(INIT_SCRIPT_FIELD.getPreferredName(), initScript);
    }
            name,
     */
     * Set the {@code reduce} script.
            && Objects.equals(params, other.params);
        Script.declareScript(PARSER, ScriptedMetricAggregationBuilder::initScript, INIT_SCRIPT_FIELD);
        }
        this.mapScript = mapScript;
    }
            && Objects.equals(combineScript, other.combineScript)
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
 * GitHub history for details.
    /**
 * Aggregation Builder for scripted_metric agg
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            && Objects.equals(reduceScript, other.reduceScript)
        super(in);
 * license agreements. See the NOTICE file distributed with
        (args, name) -> {
        this.reduceScript = clone.reduceScript;
    }
import java.util.Objects;
        this.initScript = initScript;
            builder.mapScript((Script) args[0]);
            initScriptParams = initScript.getParams();
            combineScriptParams,
    public ScriptedMetricAggregationBuilder(StreamInput in) throws IOException {
            parent,
 * ownership. Elasticsearch licenses this file to you under
            compiledInitScript,
    protected XContentBuilder internalXContent(XContentBuilder builder, Params builderParams) throws IOException {
    public Map<String, Object> params() {
import org.opensearch.search.aggregations.AggregatorFactory;
        Script.declareScript(PARSER, constructorArg(), MAP_SCRIPT_FIELD);
            metadata
    @Override
        Map<String, Object> combineScriptParams = combineScript.getParams();
    private static final ParseField INIT_SCRIPT_FIELD = new ParseField("init_script");
    public static final ConstructingObjectParser<ScriptedMetricAggregationBuilder, String> PARSER = new ConstructingObjectParser<>(
        return new ScriptedMetricAggregationBuilder(this, factoriesBuilder, metadata);
            compiledInitScript = null;
        if (initScript == null) {
        NAME,
        if (combineScript == null) {
        }
            compiledInitScript = queryShardContext.compile(initScript, ScriptedMetricAggContexts.InitScript.CONTEXT);
        return new ScriptedMetricAggregatorFactory(
     * Get the {@code init} script.
        } else {
import org.opensearch.core.ParseField;
    public boolean equals(Object obj) {
import org.opensearch.script.ScriptedMetricAggContexts;
    public Script initScript() {
        combineScript = in.readOptionalWriteable(Script::new);
     * Get the {@code map} script.
    }
/**
    }
     */
 * this work for additional information regarding copyright
        if (reduceScript == null) {
    }
            initScriptParams = Collections.emptyMap();
        out.writeBoolean(hasParams);
import org.opensearch.index.query.QueryShardContext;
    public Script mapScript() {
    @Override
    /**
            throw new IllegalArgumentException("[combineScript] must not be null: [" + name + "]");
    private Map<String, Object> params;
        return this;
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal
        return combineScript;
        mapScript = in.readOptionalWriteable(Script::new);
            mapScriptParams,
import org.opensearch.script.Script;
        return reduceScript;
        }
        }
        return builder;
    public Script combineScript() {
        initScript = in.readOptionalWriteable(Script::new);
    public String getType() {
    /**
        if (params == null) {
            builder.field(MAP_SCRIPT_FIELD.getPreferredName(), mapScript);
     * Read from a stream.
     * Set the {@code map} script.
    }
        }
        builder.startObject();
            reduceScript,
    }
        return this;
 *
            ScriptedMetricAggregationBuilder builder = new ScriptedMetricAggregationBuilder(name);
    @Override
            throw new IllegalArgumentException("[mapScript] must not be null: [" + name + "]");
        if (combineScript == null) {
    /**
    /**
        return this;
 * specific language governing permissions and limitations
        Script.declareScript(PARSER, ScriptedMetricAggregationBuilder::combineScript, COMBINE_SCRIPT_FIELD);
        ScriptedMetricAggregationBuilder clone,
     */
    }
     */
        }
        this.initScript = clone.initScript;
 * Modifications Copyright OpenSearch Contributors. See
 */
    private Script combineScript;
    @Override
    public ScriptedMetricAggregationBuilder mapScript(Script mapScript) {
     */
        if (reduceScript == null) {
        );
    protected void doWriteTo(StreamOutput out) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
    }
import org.opensearch.core.common.io.stream.StreamOutput;
        // Extract params from scripts and pass them along to ScriptedMetricAggregatorFactory, since it won't have
public class ScriptedMetricAggregationBuilder extends AbstractAggregationBuilder<ScriptedMetricAggregationBuilder> {
    /**
    public int hashCode() {
    protected ScriptedMetricAggregationBuilder(
        );
        Builder factoriesBuilder,
