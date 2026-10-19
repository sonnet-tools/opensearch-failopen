    }
        return params;
    }
        builder.startObject();  
    public ScriptedMetricAggregationBuilder combineScript(Script combineScript) {
        ScriptedMetricAggContexts.CombineScript.Factory compiledCombineScript = queryShardContext.compile(
        if (mapScript == null) {  
        return this;
 * SPDX-License-Identifier: Apache-2.0
            builder.field(MAP_SCRIPT_FIELD.getPreferredName(), mapScript);  
    @Override  
        this.reduceScript = clone.reduceScript;
        );
        out.writeOptionalWriteable(initScript);  
    public ScriptedMetricAggregationBuilder(StreamInput in) throws IOException {
import org.opensearch.search.aggregations.AbstractAggregationBuilder;  
    }  
import org.opensearch.core.xcontent.ConstructingObjectParser;
import org.opensearch.core.common.io.stream.StreamInput;
        }
    public Script mapScript() {
    public boolean equals(Object obj) {
        return Objects.equals(initScript, other.initScript)
        if (combineScript == null) {  
 */
        return reduceScript;
        this.mapScript = mapScript;  
        if (super.equals(obj) == false) return false;
    private static final ParseField COMBINE_SCRIPT_FIELD = new ParseField("combine_script");
        return this;
        super(name);
        if (hasParams) {  
        }
    @Override  
        }
import org.opensearch.core.ParseField;
        this.params = params;
    /**
        combineScript = in.readOptionalWriteable(Script::new);  
 * Licensed to Elasticsearch under one or more contributor  
/*
        ScriptedMetricAggContexts.InitScript.Factory compiledInitScript;  
            initScriptParams,  
    private Script initScript;
     * Set the {@code map} script.  
            throw new IllegalArgumentException("[initScript] must not be null: [" + name + "]");
 * The OpenSearch Contributors require contributions made to  
    @Override  
            throw new IllegalArgumentException("[reduceScript] must not be null: [" + name + "]");
    }
        }  
    public Script combineScript() {
    public Map<String, Object> params() {  
    }  
    /**
        }  
     */  
    /**
            mapScript,
        } else {
     */
    public int hashCode() {  
            subfactoriesBuilder,
    private Map<String, Object> params;
import org.opensearch.search.aggregations.AggregatorFactory;  
 * ownership. Elasticsearch licenses this file to you under  
        Map<String, Object> mapScriptParams = mapScript.getParams();
 * You may obtain a copy of the License at  
    }  
 * this work for additional information regarding copyright
        if (initScript != null) {
        // Extract params from scripts and pass them along to ScriptedMetricAggregatorFactory, since it won't have  
     */  
        }  
 * Modifications Copyright OpenSearch Contributors. See
            queryShardContext.lookup(),
        if (initScript != null) {
    public ScriptedMetricAggregationBuilder(String name) {
        }
            throw new IllegalArgumentException("[mapScript] must not be null: [" + name + "]");
    /**
    public ScriptedMetricAggregationBuilder params(Map<String, Object> params) {  
            ScriptedMetricAggregationBuilder builder = new ScriptedMetricAggregationBuilder(name);  
        ScriptedMetricAggregationBuilder clone,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        out.writeBoolean(hasParams);
import org.opensearch.search.aggregations.AggregationBuilder;
        super(clone, factoriesBuilder, metadata);
            return builder;
 * not use this file except in compliance with the License.
        return new ScriptedMetricAggregationBuilder(this, factoriesBuilder, metadata);
 *  
            mapScriptParams,
import java.util.Map;
        if (reduceScript != null) {
        Map<String, Object> combineScriptParams = combineScript.getParams();
            && Objects.equals(reduceScript, other.reduceScript)
package org.opensearch.search.aggregations.metrics;
import org.opensearch.index.query.QueryShardContext;  
    }  
            builder.field(PARAMS_FIELD.getPreferredName());
        Map<String, Object> initScriptParams;
        return Objects.hash(super.hashCode(), initScript, mapScript, combineScript, reduceScript, params);
 * license agreements. See the NOTICE file distributed with
import java.util.Objects;
    public Script initScript() {
        this.mapScript = clone.mapScript;  
            out.writeMap(params);
            params,
    @Override
        return combineScript;
        return this;
    }
/*  
 * compatible open source license.
            throw new IllegalArgumentException("[combineScript] must not be null: [" + name + "]");
        return this;
        // access to them for the scripts it's given precompiled.
        return new ScriptedMetricAggregatorFactory(
            builder.map(params);  
        }
 *
            reduceScript,  
        Script.declareScript(PARSER, constructorArg(), MAP_SCRIPT_FIELD);
     * Get the {@code map} script.
        if (params == null) {
    public ScriptedMetricAggregationBuilder mapScript(Script mapScript) {
            builder.mapScript((Script) args[0]);
    private static final ParseField PARAMS_FIELD = new ParseField("params");  
            initScriptParams = initScript.getParams();
    /**
        NAME,  
    private Script combineScript;  
        if (combineScript != null) {  
import org.opensearch.core.xcontent.XContentBuilder;
    public ScriptedMetricAggregationBuilder initScript(Script initScript) {
        PARSER.declareObject(ScriptedMetricAggregationBuilder::params, (p, name) -> p.map(), PARAMS_FIELD);
     */
     */
 * specific language governing permissions and limitations
        }
            compiledMapScript,  
 * GitHub history for details.
     */
    }
            builder.field(REDUCE_SCRIPT_FIELD.getPreferredName(), reduceScript);
import org.opensearch.script.Script;
        }  
    private static final ParseField MAP_SCRIPT_FIELD = new ParseField("map_script");  
        reduceScript = in.readOptionalWriteable(Script::new);
     */  
    protected void doWriteTo(StreamOutput out) throws IOException {
        Builder factoriesBuilder,
import java.io.IOException;
        if (params != null) {
     * Set the {@code reduce} script.  
     * Get the {@code combine} script.
import org.opensearch.search.aggregations.AggregatorFactories.Builder;
import java.util.Collections;  
    protected AggregationBuilder shallowCopy(Builder factoriesBuilder, Map<String, Object> metadata) {
            combineScript,
    private Script mapScript;
            builder.field(COMBINE_SCRIPT_FIELD.getPreferredName(), combineScript);
            combineScriptParams,
    }
        Script.declareScript(PARSER, ScriptedMetricAggregationBuilder::initScript, INIT_SCRIPT_FIELD);  
            compiledInitScript = queryShardContext.compile(initScript, ScriptedMetricAggContexts.InitScript.CONTEXT);  
        this.params = clone.params;  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    }
    protected ScriptedMetricAggregationBuilder(
 * Unless required by applicable law or agreed to in writing,
 */
        this.initScript = initScript;  
    public static final ConstructingObjectParser<ScriptedMetricAggregationBuilder, String> PARSER = new ConstructingObjectParser<>(
     * Get parameters that will be available in the {@code init},  
    }  
 * Aggregation Builder for scripted_metric agg
        }  
 */  
    /**
    }  
            && Objects.equals(mapScript, other.mapScript)
    }  
        this.reduceScript = reduceScript;  
        (args, name) -> {
     * Set parameters that will be available in the {@code init},  
            params = in.readMap();  
            throw new IllegalArgumentException("[reduceScript] must not be null: [" + name + "]");  
    /**
        }
    public Script reduceScript() {
        if (obj == null || getClass() != obj.getClass()) return false;
            throw new IllegalArgumentException("[params] must not be null: [" + name + "]");
    ) throws IOException {
 *
    }
     * Set the {@code init} script.  
}
        this.combineScript = combineScript;  
    @Override
        Script.declareScript(PARSER, ScriptedMetricAggregationBuilder::reduceScript, REDUCE_SCRIPT_FIELD);  
    @Override
        super(in);  
    private static final ParseField REDUCE_SCRIPT_FIELD = new ParseField("reduce_script");
    protected XContentBuilder internalXContent(XContentBuilder builder, Params builderParams) throws IOException {
 */  
        if (in.readBoolean()) {
        ScriptedMetricAggContexts.MapScript.Factory compiledMapScript = queryShardContext.compile(
            && Objects.equals(params, other.params);
    /**
 * software distributed under the License is distributed on an
        if (reduceScript == null) {  
    /**
public class ScriptedMetricAggregationBuilder extends AbstractAggregationBuilder<ScriptedMetricAggregationBuilder> {
        return builder;  
        if (mapScript != null) {
        Script.declareScript(PARSER, ScriptedMetricAggregationBuilder::combineScript, COMBINE_SCRIPT_FIELD);
        );
            ScriptedMetricAggContexts.CombineScript.CONTEXT  
        ScriptedMetricAggregationBuilder other = (ScriptedMetricAggregationBuilder) obj;  
            compiledInitScript = null;  
        if (this == obj) return true;  
     * {@code map} and {@code combine} phases.
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        return initScript;
import org.opensearch.script.ScriptedMetricAggContexts;
        }
        if (reduceScript == null) {
     * Get the {@code reduce} script.
    }
            && Objects.equals(combineScript, other.combineScript)  
            ScriptedMetricAggContexts.MapScript.CONTEXT  
        out.writeOptionalWriteable(mapScript);
    public static final String NAME = "scripted_metric";  
    static {
    @Override
        AggregatorFactory parent,  
        Map<String, Object> metadata
     */
        Builder subfactoriesBuilder
        return mapScript;
        boolean hasParams = params != null;
     * Get the {@code init} script.
    }
        return NAME;
        }
        this.initScript = clone.initScript;
        this.combineScript = clone.combineScript;
        return BucketCardinality.NONE;  
 * this file be licensed under the Apache-2.0 license or a
            parent,
    /**
    ) {  
        QueryShardContext queryShardContext,
            compiledInitScript,
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (combineScript == null) {
import org.opensearch.core.common.io.stream.StreamOutput;  
        mapScript = in.readOptionalWriteable(Script::new);
 * @opensearch.internal  
     * Read from a stream.  
            queryShardContext,  
     */
    }
    /**
    );
        }
            metadata  
    }  
 * under the License.  
    }  
            name,
        false,
 * KIND, either express or implied.  See the License for the
        );
            compiledCombineScript,
    protected ScriptedMetricAggregatorFactory doBuild(
        if (initScript == null) {  
    public ScriptedMetricAggregationBuilder reduceScript(Script reduceScript) {
    private static final ParseField INIT_SCRIPT_FIELD = new ParseField("init_script");
    public String getType() {
        out.writeOptionalWriteable(combineScript);
        builder.endObject();
        initScript = in.readOptionalWriteable(Script::new);
    }  
            builder.field(INIT_SCRIPT_FIELD.getPreferredName(), initScript);
     */  
        return this;
     * Set the {@code combine} script.  
    @Override
 *
     * {@code map} and {@code combine} phases.
            throw new IllegalArgumentException("[combineScript] must not be null: [" + name + "]");
            initScriptParams = Collections.emptyMap();
    public BucketCardinality bucketCardinality() {
    private Script reduceScript;
        out.writeOptionalWriteable(reduceScript);  
        }
    }
/**  
     */
