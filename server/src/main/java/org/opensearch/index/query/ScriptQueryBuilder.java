        }
        return new ScriptQueryBuilder(script).boost(boost).queryName(queryName);
import org.opensearch.core.common.io.stream.StreamOutput;
                    final FilterScript leafScript = filterScript.newInstance(context);
 * software distributed under the License is distributed on an
    protected boolean doEquals(ScriptQueryBuilder other) {
                    };
        if (script == null) {
    @Override
 */
 */
                    boost = parser.floatValue();
            buffer.append(Functions.nameOrEmptyArg(queryName));
    protected void doWriteTo(StreamOutput out) throws IOException {
            if (sameClassAs(obj) == false) return false;
        @Override
import org.opensearch.common.Nullable;
/*
            ScriptQuery other = (ScriptQuery) obj;
                throw new ParsingException(
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
                );
 * Licensed to Elasticsearch under one or more contributor
        super(in);
        script = new Script(in);
        @Override
     * Internal script query
     *
 * @opensearch.internal
        XContentParser.Token token;
    }
                        @Override
    }
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    private final Script script;
import org.apache.lucene.search.DocIdSetIterator;
    static class ScriptQuery extends Query {
 *
     */
            this.queryName = queryName;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.script.FilterScript;
                    script = Script.parse(parser);
        }
                    // depend on the current timestamp, other documents, etc.
                            // TODO: how can we compute this?
    public ScriptQueryBuilder(Script script) {
                    return new DefaultScorerSupplier(scorer);
        this.script = script;
        }
            this.filterScript = filterScript;
        final String queryName;
            } else if (token == XContentParser.Token.START_OBJECT) {
 * The OpenSearch Contributors require contributions made to
                    parser.getTokenLocation(),
            } else {
        ScriptQuery(Script script, FilterScript.LeafFactory filterScript, @Nullable String queryName) {
            return buffer.toString();
        FilterScript.LeafFactory filterScript = factory.newFactory(script.getParams(), context.lookup());
 * You may obtain a copy of the License at
                        }
            visitor.visitLeaf(this);
    /**
                if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public ScriptQueryBuilder(StreamInput in) throws IOException {
import org.opensearch.common.lucene.search.function.Functions;
 * this work for additional information regarding copyright
                } else {
    }
        public int hashCode() {
        if (context.allowExpensiveQueries() == false) {
        if (script == null) {
                        }
            throw new IllegalArgumentException("script cannot be null");
package org.opensearch.index.query;
     */
import org.opensearch.core.common.ParsingException;
            return h;
        final Script script;
import org.apache.lucene.index.LeafReaderContext;
    protected int doHashCode() {
                    "[script] query does not support an array of scripts. Use a bool query with a clause per script instead."
        return new ScriptQuery(script, filterScript, queryName);
                } else if (Script.SCRIPT_PARSE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                            return 1000f;
        // also, when caching, since its isCacheable is false, will result in loading all bit set...
/**
                    queryName = parser.text();
 * Query builder for script queries
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
import org.apache.lucene.search.ConstantScoreScorer;
        FilterScript.Factory factory = context.compile(script, FilterScript.CONTEXT);
    }
                @Override
            return new ConstantScoreWeight(this, boost) {
/*
import org.apache.lucene.search.ScorerSupplier;
        return Objects.equals(script, other.script);
}
        builder.field(Script.SCRIPT_PARSE_FIELD.getPreferredName(), script);
        @Override
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
                        public float matchCost() {
import org.apache.lucene.search.TwoPhaseIterator;
        String currentFieldName = null;
    }
    @Override
            };
                    DocIdSetIterator approximation = DocIdSetIterator.all(context.reader().maxDoc());
 * license agreements. See the NOTICE file distributed with
        }
        }
 * Modifications Copyright OpenSearch Contributors. See
        String queryName = null;
                    return false;
 * SPDX-License-Identifier: Apache-2.0
    public static ScriptQueryBuilder fromXContent(XContentParser parser) throws IOException {
        return Objects.hash(script);
                currentFieldName = parser.currentName();
                if (token != XContentParser.Token.START_ARRAY) {
                }
import org.opensearch.core.xcontent.XContentBuilder;
    public static final String NAME = "script";
                    throw new ParsingException(parser.getTokenLocation(), "[script] query does not support [" + currentFieldName + "]");
    @Override
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
                            return leafScript.execute();
    public String getWriteableName() {
import org.apache.lucene.search.Weight;
                            leafScript.setDocument(approximation.docID());
            throw new ParsingException(parser.getTokenLocation(), "script must be provided with a [script] filter");
    }
                "[script] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.script.Script;
    }
        builder.endObject();
            StringBuilder buffer = new StringBuilder();
            throw new OpenSearchException(
            );
import org.apache.lucene.search.QueryVisitor;
    }
            return Objects.equals(script, other.script);
        public void visit(QueryVisitor visitor) {
 * specific language governing permissions and limitations
import org.apache.lucene.search.Query;
            buffer.append(script);
                    // ie. the return value is always the same given the same conditions and may not
 *
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        script.writeTo(out);
        Script script = null;
                } else {
        }
            buffer.append("ScriptQuery(");
        }
                }
                    // TODO: Change this to true when we can assume that scripts are pure functions
     * Read from a stream.
        printBoostAndQueryName(builder);
                if (Script.SCRIPT_PARSE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    @Override
    protected void doXContent(XContentBuilder builder, Params builderParams) throws IOException {
import org.opensearch.core.xcontent.XContentParser;
        @Override
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 * compatible open source license.
 * under the License.
 * GitHub history for details.
        }
import org.apache.lucene.search.Scorer;
                        public boolean matches() throws IOException {
import org.apache.lucene.search.IndexSearcher;
                }
                }
                    throw new ParsingException(parser.getTokenLocation(), "[script] query does not support [" + currentFieldName + "]");
            h = 31 * h + script.hashCode();
 */
    }
    }
import java.io.IOException;
 * not use this file except in compliance with the License.
        final FilterScript.LeafFactory filterScript;
        }
                public boolean isCacheable(LeafReaderContext ctx) {
                    final Scorer scorer = new ConstantScoreScorer(score(), scoreMode, twoPhase);
    @Override
import org.opensearch.OpenSearchException;
import java.util.Objects;
                    script = Script.parse(parser);
 */
        return NAME;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
        public boolean equals(Object obj) {
                    TwoPhaseIterator twoPhase = new TwoPhaseIterator(approximation) {
    public Script script() {
        public String toString(String field) {
        return this.script;
import org.apache.lucene.search.ScoreMode;
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
            }
                        @Override
            } else if (token.isValue()) {
    @Override
                @Override
    /**
                    throw new AssertionError("Impossible token received: " + token.name());
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
    }
    protected Query doToQuery(QueryShardContext context) throws IOException {
        builder.startObject(NAME);
     * @opensearch.internal
/*
            int h = classHash();
            this.script = script;
 *
import org.opensearch.core.common.io.stream.StreamInput;
            if (token == XContentParser.Token.FIELD_NAME) {
        }
public class ScriptQueryBuilder extends AbstractQueryBuilder<ScriptQueryBuilder> {
import org.apache.lucene.search.ConstantScoreWeight;
            buffer.append(")");
