import org.apache.lucene.search.ConstantScoreWeight;  
    @Override
            return h;  
import org.opensearch.common.Nullable;
 */  
import org.opensearch.core.xcontent.XContentBuilder;
            } else {
public class ScriptQueryBuilder extends AbstractQueryBuilder<ScriptQueryBuilder> {
import org.apache.lucene.search.Scorer;  
 *
                    final FilterScript leafScript = filterScript.newInstance(context);
 * Licensed to Elasticsearch under one or more contributor  
            }
                        }
     *
                    return new DefaultScorerSupplier(scorer);
            if (sameClassAs(obj) == false) return false;  
                    "[script] query does not support an array of scripts. Use a bool query with a clause per script instead."
        builder.field(Script.SCRIPT_PARSE_FIELD.getPreferredName(), script);
        XContentParser.Token token;
import org.opensearch.common.lucene.search.function.Functions;  
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
import org.opensearch.script.Script;
                        }
                    // TODO: Change this to true when we can assume that scripts are pure functions
        script = new Script(in);  
        script.writeTo(out);
                    };  
 * not use this file except in compliance with the License.
 *  
            } else if (token == XContentParser.Token.START_OBJECT) {
                    parser.getTokenLocation(),
    /**
            );
            throw new OpenSearchException(
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.OpenSearchException;
        final Script script;  
        @Override
    private final Script script;
import org.apache.lucene.search.Weight;  
                        public float matchCost() {
                    queryName = parser.text();  
            buffer.append("ScriptQuery(");
        return Objects.equals(script, other.script);
        }
        }  
import org.apache.lucene.search.IndexSearcher;
 * compatible open source license.
    public Script script() {
    }
    public static final String NAME = "script";
    }
import org.opensearch.core.common.io.stream.StreamInput;
        public int hashCode() {  
        }
                    // depend on the current timestamp, other documents, etc.  
        FilterScript.Factory factory = context.compile(script, FilterScript.CONTEXT);  
        if (script == null) {
     * Read from a stream.
                public boolean isCacheable(LeafReaderContext ctx) {  
            buffer.append(script);
    public static ScriptQueryBuilder fromXContent(XContentParser parser) throws IOException {
 * software distributed under the License is distributed on an
                        @Override
 * GitHub history for details.
                    script = Script.parse(parser);
                            leafScript.setDocument(approximation.docID());  
        @Override
/**
 *
            this.filterScript = filterScript;  
            StringBuilder buffer = new StringBuilder();  
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;  
                @Override
        }  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        ScriptQuery(Script script, FilterScript.LeafFactory filterScript, @Nullable String queryName) {
    public String getWriteableName() {
        super(in);
 */
                    script = Script.parse(parser);  
        return new ScriptQuery(script, filterScript, queryName);
        builder.startObject(NAME);
     */  
    }
                @Override
            ScriptQuery other = (ScriptQuery) obj;
            throw new ParsingException(parser.getTokenLocation(), "script must be provided with a [script] filter");
        if (script == null) {
        public void visit(QueryVisitor visitor) {  
 *
        printBoostAndQueryName(builder);  
/*  
                } else {
                        @Override
 * Query builder for script queries  
                );  
                }
/*
        @Override  
                    throw new ParsingException(parser.getTokenLocation(), "[script] query does not support [" + currentFieldName + "]");  
        return NAME;
 * The OpenSearch Contributors require contributions made to  
                } else {
        String currentFieldName = null;  
            return buffer.toString();
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        return new ScriptQueryBuilder(script).boost(boost).queryName(queryName);
        }
 * specific language governing permissions and limitations
    }  
import org.apache.lucene.search.ScoreMode;
        return Objects.hash(script);  
 * Modifications Copyright OpenSearch Contributors. See
            return Objects.equals(script, other.script);
package org.opensearch.index.query;
            };  
        }  
        }  
                    DocIdSetIterator approximation = DocIdSetIterator.all(context.reader().maxDoc());  
            buffer.append(")");
    }  
}
                if (Script.SCRIPT_PARSE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    @Override  
    }
                    throw new AssertionError("Impossible token received: " + token.name());
    }  
                } else if (Script.SCRIPT_PARSE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        this.script = script;
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        final String queryName;
import org.apache.lucene.search.TwoPhaseIterator;
                if (token != XContentParser.Token.START_ARRAY) {  
            } else if (token.isValue()) {
import org.apache.lucene.search.ConstantScoreScorer;
 */  
            return new ConstantScoreWeight(this, boost) {
        public String toString(String field) {
        Script script = null;  
     */  
            throw new IllegalArgumentException("script cannot be null");
import org.apache.lucene.search.Query;  
        final FilterScript.LeafFactory filterScript;
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.script.FilterScript;  
                            // TODO: how can we compute this?  
            this.script = script;
                "[script] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."  
import org.opensearch.core.common.io.stream.StreamOutput;  
            if (token == XContentParser.Token.FIELD_NAME) {
            h = 31 * h + script.hashCode();
 * KIND, either express or implied.  See the License for the
        return this.script;  
import org.apache.lucene.search.QueryVisitor;
    @Override  
import java.io.IOException;  
            buffer.append(Functions.nameOrEmptyArg(queryName));  
import org.apache.lucene.search.DocIdSetIterator;
        builder.endObject();
                }  
    @Override
    @Override  
 * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
                    boost = parser.floatValue();
    protected int doHashCode() {
     * @opensearch.internal
    }  
        FilterScript.LeafFactory filterScript = factory.newFactory(script.getParams(), context.lookup());
                    final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, twoPhase);
 * You may obtain a copy of the License at  
                throw new ParsingException(  
                        public boolean matches() throws IOException {
    protected boolean doEquals(ScriptQueryBuilder other) {
            int h = classHash();
    }
 * Unless required by applicable law or agreed to in writing,
                            return 1000f;
                    return false;
 * this work for additional information regarding copyright
    }
                    TwoPhaseIterator twoPhase = new TwoPhaseIterator(approximation) {
/*  
    protected void doXContent(XContentBuilder builder, Params builderParams) throws IOException {  
import java.util.Objects;
    static class ScriptQuery extends Query {
    }  
            this.queryName = queryName;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Internal script query  
        if (context.allowExpensiveQueries() == false) {
                currentFieldName = parser.currentName();  
import org.apache.lucene.search.ScorerSupplier;
                    throw new ParsingException(parser.getTokenLocation(), "[script] query does not support [" + currentFieldName + "]");
                }  
                            return leafScript.execute();
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.common.ParsingException;
    protected void doWriteTo(StreamOutput out) throws IOException {
        }
    public ScriptQueryBuilder(StreamInput in) throws IOException {
                if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            visitor.visitLeaf(this);
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
        }
        @Override
    /**
import org.apache.lucene.index.LeafReaderContext;
    @Override
    public ScriptQueryBuilder(Script script) {  
                }
                    // ie. the return value is always the same given the same conditions and may not
 */  
        }
        // also, when caching, since its isCacheable is false, will result in loading all bit set...
        String queryName = null;  
    protected Query doToQuery(QueryShardContext context) throws IOException {  
 * license agreements. See the NOTICE file distributed with
                }
        @Override
 * this file be licensed under the Apache-2.0 license or a
        public boolean equals(Object obj) {
