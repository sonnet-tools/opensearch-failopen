import org.opensearch.core.common.io.stream.StreamInput;
    public boolean equals(Object obj) {
 * You may obtain a copy of the License at
import org.opensearch.core.xcontent.XContentBuilder;
    @Override
        private final LongAccessor supersetSizeHolder;
/*
            params.put("_superset_size", supersetSizeHolder);
     *
package org.opensearch.search.aggregations.bucket.terms.heuristic;
    }
            return value;
        SignificantTermsHeuristicScoreScript.Factory factory = context.scriptService()
 * under the License.
    @Override
 * compatible open source license.
            SignificantTermsHeuristicScoreScript.CONTEXT
        }
        @Override
    static class ExecutableScriptHeuristic extends ScriptHeuristic {
 *    http://www.apache.org/licenses/LICENSE-2.0
        public long longValue() {
        public String toString() {
 *
import org.opensearch.core.xcontent.ConstructingObjectParser;
/*
 * KIND, either express or implied.  See the License for the
        public float floatValue() {
 * Licensed to Elasticsearch under one or more contributor
    @Override
 *
    }
     * @return a "significance" score
            params.put("_superset_freq", supersetDfHolder);
    }
    }
     * @param supersetFreq The frequency of the term in the superset from which the sample was taken
    @Override
        }
 * The OpenSearch Contributors require contributions made to
            this.executableScript = executableScript;
    );
    public SignificanceHeuristic rewrite(QueryShardContext queryShardContext) {
        @Override
        if (getClass() != obj.getClass()) {
        }
        }
    }
        return NAME;
        ScriptHeuristic other = (ScriptHeuristic) obj;
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.script.SignificantTermsHeuristicScoreScript;
    /**
        this.script = script;
    public String getWriteableName() {
 * Script significance heuristic for significant terms agg
        NAME,
/*
 * SPDX-License-Identifier: Apache-2.0
        Script.declareScript(PARSER, constructorArg());
        args -> new ScriptHeuristic((Script) args[0])
            subsetSizeHolder = new LongAccessor();
        }
        if (obj == null) {
            script,
            return Long.toString(value);
 */
        public double getScore(long subsetFreq, long subsetSize, long supersetFreq, long supersetSize) {
 * license agreements. See the NOTICE file distributed with
            return value;
        @Override
        return Objects.hash(script);
    /**
    @Override
        script.toXContent(builder, builderParams);
            params.put("_subset_freq", subsetDfHolder);
        private final LongAccessor supersetDfHolder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
    public ScriptHeuristic(Script script) {
 * ownership. Elasticsearch licenses this file to you under
            supersetSizeHolder.value = supersetSize;
    private final Script script;
    public ScriptHeuristic(StreamInput in) throws IOException {
        return new ExecutableScriptHeuristic(script, compiledScript.newInstance());
    public final class LongAccessor extends Number {
    public int hashCode() {
            params.putAll(script.getParams());
        ExecutableScriptHeuristic(Script script, SignificantTermsHeuristicScoreScript executableScript) {
            return false;
import java.io.IOException;
        return Objects.equals(script, other.script);
 */
     * Accesses long values
    public XContentBuilder toXContent(XContentBuilder builder, Params builderParams) throws IOException {
 * Unless required by applicable law or agreed to in writing,
        }
        builder.field(Script.SCRIPT_PARSE_FIELD.getPreferredName());
/**
    public static final String NAME = "script_heuristic";
            .compile(script, SignificantTermsHeuristicScoreScript.CONTEXT);
    }
            "This scoring heuristic must have 'rewrite' called on it to provide a version ready " + "for use"
        @Override
     */
    @Override
    }
        public int intValue() {
import java.util.Objects;
     * Read from a stream.
import java.util.Map;
 * specific language governing permissions and limitations
        builder.startObject(NAME);
        private final Map<String, Object> params = new HashMap<>();
        @Override
     * @opensearch.internal
    }
     * @param subsetSize   The size of the selected sample (typically number of docs)
    public double getScore(long subsetFreq, long subsetSize, long supersetFreq, long supersetSize) {
}
        }
            return (int) value;
     */
        return builder;
        this(new Script(in));
import org.opensearch.script.Script;
            super(script);
        private final LongAccessor subsetSizeHolder;
        public long value;
    @Override
    /**
     */
        return new ExecutableScriptHeuristic(script, factory.newInstance());
    public SignificanceHeuristic rewrite(InternalAggregation.ReduceContext context) {
     * @param subsetFreq   The frequency of the term in the selected sample
import java.util.HashMap;
            return value;
 * GitHub history for details.
    }
     * Calculates score with a script
 * the Apache License, Version 2.0 (the "License"); you may
     */
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
            subsetSizeHolder.value = subsetSize;
    }
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
    @Override
        SignificantTermsHeuristicScoreScript.Factory compiledScript = queryShardContext.compile(
            supersetSizeHolder = new LongAccessor();
        );
    }
    public static final ConstructingObjectParser<ScriptHeuristic, Void> PARSER = new ConstructingObjectParser<>(
        script.writeTo(out);
     * @param supersetSize The size of the superset from which the sample was taken  (typically number of docs)
        public double doubleValue() {
    static {
     * This class holds an executable form of the script with private variables ready for execution
        }
            subsetDfHolder = new LongAccessor();
 * software distributed under the License is distributed on an
     *
 * @opensearch.internal
 *
        private final LongAccessor subsetDfHolder;
            return executableScript.execute(params);
 */
     * @opensearch.internal
        @Override
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.InternalAggregation;
    public void writeTo(StreamOutput out) throws IOException {
    }
        }
        throw new UnsupportedOperationException(
            supersetDfHolder = new LongAccessor();
        builder.endObject();
        private final SignificantTermsHeuristicScoreScript executableScript;
            params.put("_subset_size", subsetSizeHolder);
 * Modifications Copyright OpenSearch Contributors. See
 */
            return false;
import org.opensearch.index.query.QueryShardContext;
            subsetDfHolder.value = subsetFreq;
     * on a single search thread.
public class ScriptHeuristic extends SignificanceHeuristic {
     *
 *
            supersetDfHolder.value = supersetFreq;
    }
        );
