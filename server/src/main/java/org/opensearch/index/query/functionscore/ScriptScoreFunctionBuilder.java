 * not use this file except in compliance with the License.
        }
import org.opensearch.common.Nullable;
                }
        builder.field(Script.SCRIPT_PARSE_FIELD.getPreferredName(), script);  
    public Script getScript() {
 * the Apache License, Version 2.0 (the "License"); you may
    public static ScriptScoreFunctionBuilder fromXContent(XContentParser parser) throws IOException, ParsingException {
            throw new ParsingException(parser.getTokenLocation(), NAME + " requires 'script' field");  
import org.opensearch.common.lucene.search.function.ScoreFunction;
 * @opensearch.internal  
    }
    public ScriptScoreFunctionBuilder(StreamInput in) throws IOException {
            throw new IllegalArgumentException("script must not be null");
    }
 */
import org.opensearch.core.common.io.stream.StreamInput;
            if (token == XContentParser.Token.FIELD_NAME) {  
    }
            }
        script.writeTo(out);
 * compatible open source license.
                context.indexVersionCreated(),
        try {  
        builder.endObject();
    @Override  
import org.opensearch.script.ScoreScript;
        if (script == null) {
/*  
                context.index().getName(),  
    protected void doWriteTo(StreamOutput out) throws IOException {
import org.opensearch.common.lucene.search.function.ScriptScoreFunction;  
        }
 * Modifications Copyright OpenSearch Contributors. See
    }  
     * Read from a stream.
        }  
                script,
import java.util.Objects;  
            return new ScriptScoreFunction(  
 * GitHub history for details.
    public static final String NAME = "script_score";  
 * The OpenSearch Contributors require contributions made to  
 */  
                } else {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            ScoreScript.Factory factory = context.compile(script, ScoreScript.CONTEXT);
 * under the License.  
                currentFieldName = parser.currentName();
 * SPDX-License-Identifier: Apache-2.0
/*
 * that match with the inner query or filter.
        return Objects.hash(this.script);
        }
    }
        XContentParser.Token token;
    @Override
import org.opensearch.core.common.ParsingException;
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 *  
        } catch (Exception e) {
    }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
/*  
    public String getName() {
}
            } else {
            throw new QueryShardException(context, "script_score: the script could not be loaded", e);  
        return Objects.equals(this.script, functionBuilder.script);
    }
/**
 * A function that uses a script to compute or influence the score of documents  
    @Override
        return new ScriptScoreFunctionBuilder(script);  
                context.getShardId(),
package org.opensearch.index.query.functionscore;
    public ScriptScoreFunctionBuilder(Script script, @Nullable String functionName) {
        script = new Script(in);  
 * Unless required by applicable law or agreed to in writing,
    }
    protected ScoreFunction doToFunction(QueryShardContext context) {
 * this work for additional information regarding copyright
        this.script = script;  
    /**
import java.io.IOException;
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.script.Script;  
 *
    @Override  
    public ScriptScoreFunctionBuilder(Script script) {
    private final Script script;
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
        setFunctionName(functionName);
    public void doXContent(XContentBuilder builder, Params params) throws IOException {
        Script script = null;
                getFunctionName()  
        return this.script;  
    protected boolean doEquals(ScriptScoreFunctionBuilder functionBuilder) {
 * specific language governing permissions and limitations
        super(in);
                    throw new ParsingException(parser.getTokenLocation(), NAME + " query does not support [" + currentFieldName + "]");  
                if (Script.SCRIPT_PARSE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
            ScoreScript.LeafFactory searchScript = factory.newFactory(script.getParams(), context.lookup(), context.searcher());
     */  
import org.opensearch.core.xcontent.XContentParser;
        if (script == null) {  
 * You may obtain a copy of the License at  
        builder.startObject(getName());
 * Licensed to Elasticsearch under one or more contributor  
    @Override
        return NAME;  
 */  
 * this file be licensed under the Apache-2.0 license or a
                    script = Script.parse(parser);
            );
    }
 *
    }  
                searchScript,
public class ScriptScoreFunctionBuilder extends ScoreFunctionBuilder<ScriptScoreFunctionBuilder> {
 *
        String currentFieldName = null;  
    protected int doHashCode() {  
import org.opensearch.index.query.QueryShardContext;  
import org.opensearch.core.common.io.stream.StreamOutput;  
        this(script, null);
 * software distributed under the License is distributed on an
import org.opensearch.index.query.QueryShardException;
    }
