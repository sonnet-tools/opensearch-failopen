        fuzzyTranspositions = in.readBoolean();
        out.writeString(fieldName);
    public boolean fuzzyTranspositions() {
        return this;
    protected int doHashCode() {
     */
    }
    public MatchBoolPrefixQueryBuilder maxExpansions(int maxExpansions) {
 * You may obtain a copy of the License at
    protected boolean doEquals(MatchBoolPrefixQueryBuilder other) {
        return this.fuzzyTranspositions;
 * The OpenSearch Contributors require contributions made to
    /* Sets the fuzziness used when evaluated to a fuzzy query type. Defaults to "AUTO". */
                        } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /** Sets the operator to use when using a boolean query. Defaults to {@code OR}. */
        Object value = null;
    }
        value = in.readGenericValue();
        matchQuery.setFuzzyRewriteMethod(QueryParsers.parseRewriteMethod(fuzzyRewrite, null, LoggingDeprecationHandler.INSTANCE));
            && Objects.equals(value, other.value)
            .fuzzyTranspositions(fuzzyTranspositions)
                        } else {
        String minimumShouldMatch = null;
    private static final Operator DEFAULT_OPERATOR = Operator.OR;
 * ownership. Elasticsearch licenses this file to you under
        this.maxExpansions = maxExpansions;
            .maxExpansions(maxExpansion)
        String fuzzyRewrite = null;
                            fuzziness = Fuzziness.parse(parser);
    public MatchBoolPrefixQueryBuilder fuzziness(Object fuzziness) {
    }
        Fuzziness fuzziness = null;
import org.opensearch.core.common.io.stream.StreamOutput;
    }
import static org.opensearch.index.query.MatchQueryBuilder.FUZZY_REWRITE_FIELD;
    public MatchBoolPrefixQueryBuilder fuzzyTranspositions(boolean fuzzyTranspositions) {
        return this.prefixLength;
        final Query query = matchQuery.parse(MatchQuery.Type.BOOLEAN_PREFIX, fieldName, value);
        if (Strings.isEmpty(fieldName)) {
        if (analyzer != null) {
            throw new QueryShardException(context, "[" + NAME + "] analyzer [" + analyzer + "] not found");
    }
        matchQuery.setOccur(operator.toBooleanClauseOccur());
        }
    }
import org.apache.lucene.search.Query;
            .boost(boost)
    private String analyzer;
    /**
            fuzziness,
            .operator(operator)
        }
                            value = parser.objectText();
    @Override
            builder.field(FUZZY_REWRITE_FIELD.getPreferredName(), fuzzyRewrite);
package org.opensearch.index.query;
    public String fieldName() {
import static org.opensearch.index.query.MatchQueryBuilder.PREFIX_LENGTH_FIELD;
        fuzziness = in.readOptionalWriteable(Fuzziness::new);
    /** Gets the fuzzy query transposition setting. */
        String analyzer = null;
    /**
            fuzziness.toXContent(builder, params);
                fieldName = parser.currentName();
    public Operator operator() {
    /** Sets the fuzzy_rewrite parameter controlling how the fuzzy query will get rewritten */
            }
    @Deprecated
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        printBoostAndQueryName(builder);
}
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            } else {
 *
 * Licensed to Elasticsearch under one or more contributor
    /** Returns the value used in this query. */
        minimumShouldMatch = in.readOptionalString();
        builder.endObject();
        builder.field(MAX_EXPANSIONS_FIELD.getPreferredName(), maxExpansions);
        out.writeOptionalWriteable(fuzziness);
        }
            fuzzyRewrite
        return Objects.hash(
    private final String fieldName;
        return this.operator;
 */
        return this.fuzzyRewrite;
import org.opensearch.core.common.Strings;
        analyzer = in.readOptionalString();
    }
 * SPDX-License-Identifier: Apache-2.0
     * Sets the length of a length of common (non-fuzzy) prefix for fuzzy match queries
    private Fuzziness fuzziness;
 * license agreements. See the NOTICE file distributed with
            matchQuery.setAnalyzer(analyzer);
        return this;
            && Objects.equals(minimumShouldMatch, other.minimumShouldMatch)
        super(in);
    }
            throw new IllegalArgumentException("[" + NAME + "] requires operator to be non-null");
        maxExpansions = in.readVInt();
                        } else if (OPERATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        out.writeVInt(prefixLength);
        this.fuzzyTranspositions = fuzzyTranspositions;
        boolean fuzzyTranspositions = FuzzyQuery.defaultTranspositions;
                        throw new ParsingException(
        return this;
        if (operator == null) {
        String queryName = null;
    /** Gets the minimumShouldMatch value */
        }
     */
    @Override
        this.minimumShouldMatch = minimumShouldMatch;
        return this.fuzziness;
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
        }
import org.apache.lucene.search.FuzzyQuery;
    protected Query doToQuery(QueryShardContext context) throws IOException {
    public String getWriteableName() {
                            parser.getTokenLocation(),
 */
            .prefixLength(prefixLength)
            prefixLength,
    }
        operator.writeTo(out);
import org.opensearch.common.lucene.search.Queries;
    @Override
 * for the last term, which is used to create a prefix query
    public int prefixLength() {
        if (minimumShouldMatch != null) {
public class MatchBoolPrefixQueryBuilder extends AbstractQueryBuilder<MatchBoolPrefixQueryBuilder> implements WithFieldName {
    @Override
    private int maxExpansions = FuzzyQuery.defaultMaxExpansions;
        this.operator = operator;
            fieldName,
    public int maxExpansions() {
     * Sets whether transpositions are supported in fuzzy queries.<p>
import static org.opensearch.index.query.MatchQueryBuilder.FUZZY_TRANSPOSITIONS_FIELD;
    }
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        }
        if (fuzziness != null) {
        builder.field(MatchQueryBuilder.QUERY_FIELD.getPreferredName(), value);
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
            && Objects.equals(maxExpansions, other.maxExpansions)
    }
    private boolean fuzzyTranspositions = FuzzyQuery.defaultTranspositions;
        if (analyzer != null && context.getIndexAnalyzers().get(analyzer) == null) {
     * config for the field, or, if not set, the default search analyzer.
            .fuzziness(fuzziness)
            fuzzyTranspositions,
    public Fuzziness fuzziness() {
        builder.startObject(NAME);
                }
import org.opensearch.index.query.support.QueryParsers;
     * If not set, Damerau-Levenshtein distance metric will be used.
            operator,
            } else if (token == XContentParser.Token.START_OBJECT) {
        this.fuzziness = fuzziness;
    @Override
    /**
        }
        String fieldName = null;
    }
        return this;
        builder.field(OPERATOR_FIELD.getPreferredName(), operator.toString());
     * Get the fuzzy_rewrite parameter
     */
                            fuzzyTranspositions = parser.booleanValue();
        operator = Operator.readFromStream(in);
            value,
    public MatchBoolPrefixQueryBuilder fuzziness(Fuzziness fuzziness) {
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
import org.opensearch.core.xcontent.XContentBuilder;
 * Unless required by applicable law or agreed to in writing,
    public Object value() {
    /**
     */
                        } else if (PREFIX_LENGTH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * compatible open source license.
        if (maxExpansions <= 0) {
        this.value = value;
        if (value == null) {
        return Queries.maybeApplyMinimumShouldMatch(query, minimumShouldMatch);
     */
        return Objects.equals(fieldName, other.fieldName)
    public MatchBoolPrefixQueryBuilder operator(Operator operator) {
    public MatchBoolPrefixQueryBuilder prefixLength(int prefixLength) {
    /**
     * @throws IllegalArgumentException in case the prefix is negative
            maxExpansions,
        matchQuery.setTranspositions(fuzzyTranspositions);
    public MatchBoolPrefixQueryBuilder(StreamInput in) throws IOException {
        );
        fuzzyRewrite = in.readOptionalString();
    private int prefixLength = FuzzyQuery.defaultPrefixLength;
                            prefixLength = parser.intValue();
    /** Sets the fuzziness used when evaluated to a fuzzy query type. Defaults to "AUTO". */
                        if (MatchQueryBuilder.QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
            && Objects.equals(fuzziness, other.fuzziness)
    }
    /** Returns the field name used in this query. */
     * @param prefixLength non-negative length of prefix
        this.fuzzyRewrite = fuzzyRewrite;
        builder.field(FUZZY_TRANSPOSITIONS_FIELD.getPreferredName(), fuzzyTranspositions);
            && Objects.equals(operator, other.operator)
import org.opensearch.core.common.io.stream.StreamInput;
            throw new IllegalArgumentException("[" + NAME + "] requires maxExpansions to be positive.");
                            maxExpansion = parser.intValue();
                value = parser.objectText();
 * @opensearch.internal
 * specific language governing permissions and limitations
    /** Sets optional minimumShouldMatch value to apply to the query */
    public MatchBoolPrefixQueryBuilder analyzer(String analyzer) {
        XContentParser.Token token;
 */
                            boost = parser.floatValue();
        }
 *
 * Modifications Copyright OpenSearch Contributors. See
     * Gets the length of a length of common (non-fuzzy) prefix for fuzzy match queries
    /** Get the analyzer to use, if previously set, otherwise {@code null} */
        fieldName = in.readString();
    @Override
            && Objects.equals(fuzzyRewrite, other.fuzzyRewrite);
        out.writeGenericValue(value);
import java.io.IOException;
                        } else if (MatchQueryBuilder.MINIMUM_SHOULD_MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return this.analyzer;
     * Explicitly set the analyzer to use. Defaults to use explicit mapping
        }
            builder.field(MatchQueryBuilder.ANALYZER_FIELD.getPreferredName(), analyzer);
    private final Object value;
                                "[" + NAME + "] query does not support [" + currentFieldName + "]"
import org.opensearch.core.common.ParsingException;
        return this;
        return this;
        matchQuery.setFuzziness(fuzziness);
        String currentFieldName = null;
     * distance formula which supports transpositions. Setting transposition to false will
                                parser.getTokenLocation(),
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());
        final MatchQuery matchQuery = new MatchQuery(context);
        return this;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        } else if (MAX_EXPANSIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        int maxExpansion = FuzzyQuery.defaultMaxExpansions;
 * GitHub history for details.
 *
 * software distributed under the License is distributed on an
                        } else if (Fuzziness.FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }
 */
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        builder.endObject();
        MatchBoolPrefixQueryBuilder queryBuilder = new MatchBoolPrefixQueryBuilder(fieldName, value).analyzer(analyzer)
                    } else {
 *    http://www.apache.org/licenses/LICENSE-2.0
        return this;
    }
    }
    }
    public String fuzzyRewrite() {
        prefixLength = in.readVInt();
    public static MatchBoolPrefixQueryBuilder fromXContent(XContentParser parser) throws IOException {
            && Objects.equals(fuzzyTranspositions, other.fuzzyTranspositions)
    public static final String NAME = "match_bool_prefix";
     * The default metric used by fuzzy queries to determine a match is the Damerau-Levenshtein
        if (analyzer != null) {
                fieldName = currentFieldName;
 *
                        );
        out.writeVInt(maxExpansions);
                            );
import static org.opensearch.index.query.MatchQueryBuilder.MAX_EXPANSIONS_FIELD;
    private String minimumShouldMatch;
        return this.maxExpansions;
    }
    }
import java.util.Objects;
                    if (token == XContentParser.Token.FIELD_NAME) {
            throw new IllegalArgumentException("[" + NAME + "] requires query value");
    }
    /** Returns the operator to use in a boolean query.*/
    @Override
        Operator operator = DEFAULT_OPERATOR;
     * Get the (optional) number of term expansions when using fuzzy or prefix type query.
        this.prefixLength = prefixLength;
                        currentFieldName = parser.currentName();
    }
                            fuzzyRewrite = parser.textOrNull();
            if (token == XContentParser.Token.FIELD_NAME) {
        if (fuzzyRewrite != null) {
            && Objects.equals(prefixLength, other.prefixLength)
        return queryBuilder;
                    }
        out.writeOptionalString(analyzer);
                        } else if (FUZZY_TRANSPOSITIONS_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    private Operator operator = DEFAULT_OPERATOR;
 * this work for additional information regarding copyright
    private String fuzzyRewrite;
    }
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException("[" + NAME + "] requires prefix length to be non-negative.");
                            "[" + NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
                            queryName = parser.text();
     * When using fuzzy or prefix type query, the number of term expansions to use.
        return this.minimumShouldMatch;
                        }
                currentFieldName = parser.currentName();
    public String analyzer() {
    /**
/*
        return this.fieldName;
import org.opensearch.index.search.MatchQuery;
            .queryName(queryName)
                            minimumShouldMatch = parser.textOrNull();
     * @see #fuzzyRewrite(String)
    protected void doWriteTo(StreamOutput out) throws IOException {
    public MatchBoolPrefixQueryBuilder fuzzyRewrite(String fuzzyRewrite) {
     */
    }
            .fuzzyRewrite(fuzzyRewrite);
 * under the License.
            analyzer,
 * The boolean prefix query analyzes the input text and creates a boolean query containing a Term query for each term, except
    /**  Gets the fuzziness used when evaluated to a fuzzy query type. */
/**
 * not use this file except in compliance with the License.
                    } else if (token.isValue()) {
        int prefixLength = FuzzyQuery.defaultPrefixLength;
 * KIND, either express or implied.  See the License for the
        }
                            operator = Operator.fromString(parser.text());
        }
                        } else if (MatchQueryBuilder.ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        this.analyzer = analyzer;
        this.fuzziness = Fuzziness.build(fuzziness);
 * the Apache License, Version 2.0 (the "License"); you may
        if (prefixLength < 0) {
    }
/*
                            throw new ParsingException(
    public MatchBoolPrefixQueryBuilder(String fieldName, Object value) {
    }
        builder.startObject(fieldName);
import org.opensearch.core.xcontent.XContentParser;
        builder.field(PREFIX_LENGTH_FIELD.getPreferredName(), prefixLength);
    }
                        } else if (FUZZY_REWRITE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
     * switch to classic Levenshtein distance.<br>
    public String minimumShouldMatch() {
            && Objects.equals(analyzer, other.analyzer)
        this.fieldName = fieldName;
            throw new IllegalArgumentException("[" + NAME + "] requires fieldName");
    public MatchBoolPrefixQueryBuilder minimumShouldMatch(String minimumShouldMatch) {
        return this;
import static org.opensearch.index.query.MatchQueryBuilder.OPERATOR_FIELD;
/*
            .minimumShouldMatch(minimumShouldMatch)
        out.writeOptionalString(minimumShouldMatch);
            minimumShouldMatch,
     */
        matchQuery.setFuzzyPrefixLength(prefixLength);
            builder.field(MatchQueryBuilder.MINIMUM_SHOULD_MATCH_FIELD.getPreferredName(), minimumShouldMatch);
        out.writeBoolean(fuzzyTranspositions);
        out.writeOptionalString(fuzzyRewrite);
        return this.value;
import org.opensearch.common.unit.Fuzziness;
        return NAME;
    }
                            analyzer = parser.text();
        matchQuery.setMaxExpansions(maxExpansions);
