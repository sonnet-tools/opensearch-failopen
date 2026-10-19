/*  
        return NAME;
    }
        @Override
 * compatible open source license.
 *
public class ScriptHeuristic extends SignificanceHeuristic {
     * @param supersetSize The size of the superset from which the sample was taken  (typically number of docs)
        ExecutableScriptHeuristic(Script script, SignificantTermsHeuristicScoreScript executableScript) {  
 * The OpenSearch Contributors require contributions made to  
 *
        SignificantTermsHeuristicScoreScript.Factory factory = context.scriptService()  
        @Override  
        script.toXContent(builder, builderParams);  
     * Read from a stream.
     */  
            return (int) value;
            subsetDfHolder.value = subsetFreq;  
        public int intValue() {
    @Override
        private final SignificantTermsHeuristicScoreScript executableScript;  
    static {
}
            "This scoring heuristic must have 'rewrite' called on it to provide a version ready " + "for use"
    @Override
        );
    private final Script script;
        public double doubleValue() {
 * software distributed under the License is distributed on an
import org.opensearch.index.query.QueryShardContext;
        NAME,
    }
    public double getScore(long subsetFreq, long subsetSize, long supersetFreq, long supersetSize) {  
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;  
import java.util.HashMap;
    @Override
import java.util.Objects;
    public ScriptHeuristic(Script script) {  
            params.put("_superset_freq", supersetDfHolder);
    public ScriptHeuristic(StreamInput in) throws IOException {
            params.put("_subset_size", subsetSizeHolder);  
        builder.endObject();
            return false;
 * this file be licensed under the Apache-2.0 license or a
    }
     * @param supersetFreq The frequency of the term in the superset from which the sample was taken
    @Override
     *
    /**
        args -> new ScriptHeuristic((Script) args[0])
    /**
    }  
     */
    @Override  
 */  
import org.opensearch.search.aggregations.InternalAggregation;
import org.opensearch.script.Script;  
     * on a single search thread.  
     */
import org.opensearch.core.xcontent.XContentBuilder;
            subsetDfHolder = new LongAccessor();
        @Override
     */  
            return value;
            return false;
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
        @Override
    public String getWriteableName() {
            subsetSizeHolder = new LongAccessor();
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
        this(new Script(in));
import java.io.IOException;
        @Override  
        public String toString() {  
 * not use this file except in compliance with the License.
        private final LongAccessor supersetDfHolder;
 * Unless required by applicable law or agreed to in writing,
    public XContentBuilder toXContent(XContentBuilder builder, Params builderParams) throws IOException {  
    public int hashCode() {  
    }  
        return builder;
            params.put("_subset_freq", subsetDfHolder);
        private final LongAccessor subsetDfHolder;
        script.writeTo(out);
        builder.field(Script.SCRIPT_PARSE_FIELD.getPreferredName());
    );  
 * SPDX-License-Identifier: Apache-2.0
/**
    }  
        }
     *
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
        private final LongAccessor supersetSizeHolder;  
            return Long.toString(value);
            this.executableScript = executableScript;  
            return executableScript.execute(params);
        SignificantTermsHeuristicScoreScript.Factory compiledScript = queryShardContext.compile(
        }
 * Script significance heuristic for significant terms agg  
     * @return a "significance" score  
    }
    /**
            supersetSizeHolder.value = supersetSize;
/*  
 *  
        }
import java.util.Map;  
    @Override
        if (obj == null) {  
            .compile(script, SignificantTermsHeuristicScoreScript.CONTEXT);
        return Objects.equals(script, other.script);
    }  
    public SignificanceHeuristic rewrite(InternalAggregation.ReduceContext context) {
            super(script);
 */
import org.opensearch.core.common.io.stream.StreamInput;
     * @opensearch.internal
        public float floatValue() {
    }  
        private final Map<String, Object> params = new HashMap<>();
        return new ExecutableScriptHeuristic(script, compiledScript.newInstance());
            params.putAll(script.getParams());
    @Override
            supersetSizeHolder = new LongAccessor();  
import org.opensearch.script.SignificantTermsHeuristicScoreScript;
            return value;
        private final LongAccessor subsetSizeHolder;
        }  
     * @param subsetSize   The size of the selected sample (typically number of docs)  
     * @param subsetFreq   The frequency of the term in the selected sample
        public long longValue() {  
 */  
        return Objects.hash(script);
        );  
            params.put("_superset_size", supersetSizeHolder);
        if (getClass() != obj.getClass()) {  
        }  
        public long value;
 * @opensearch.internal
     * This class holds an executable form of the script with private variables ready for execution
            SignificantTermsHeuristicScoreScript.CONTEXT  
    static class ExecutableScriptHeuristic extends ScriptHeuristic {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
        throw new UnsupportedOperationException(
import org.opensearch.core.xcontent.ConstructingObjectParser;  
        return new ExecutableScriptHeuristic(script, factory.newInstance());
     *  
 */  
    public final class LongAccessor extends Number {  
    public boolean equals(Object obj) {
    /**
    public static final ConstructingObjectParser<ScriptHeuristic, Void> PARSER = new ConstructingObjectParser<>(  
    public void writeTo(StreamOutput out) throws IOException {  
            script,
            subsetSizeHolder.value = subsetSize;
/*
 *
            supersetDfHolder.value = supersetFreq;
     * Calculates score with a script  
package org.opensearch.search.aggregations.bucket.terms.heuristic;
            return value;  
    public static final String NAME = "script_heuristic";
 * license agreements. See the NOTICE file distributed with
        Script.declareScript(PARSER, constructorArg());
        @Override
     * @opensearch.internal
        }  
        builder.startObject(NAME);
    }
            supersetDfHolder = new LongAccessor();
    }  
        }
    }
        ScriptHeuristic other = (ScriptHeuristic) obj;  
    @Override
        public double getScore(long subsetFreq, long subsetSize, long supersetFreq, long supersetSize) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
     * Accesses long values
        }
 * Licensed to Elasticsearch under one or more contributor  
    public SignificanceHeuristic rewrite(QueryShardContext queryShardContext) {  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.StreamOutput;
        }  
        this.script = script;
