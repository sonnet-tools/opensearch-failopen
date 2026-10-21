        return this.text;
    );
                builder.copyChars(termAtt);
    }
    public static final String NAME = "common";
    private static final ParseField LOW_FREQ_OPERATOR_FIELD = new ParseField("low_freq_operator");
                analyzerObj = context.getMapperService().searchAnalyzer();
        String field;
        lowFreqOperator = Operator.readFromStream(in);
        return NAME;
 * matches.
    }
        return this;
    }
        MappedFieldType fieldType = context.fieldMapper(fieldName);
        return this.lowFreqMinimumShouldMatch;
 */
 * license agreements. See the NOTICE file distributed with
    public Operator highFreqOperator() {
                // UTF-8
            if (analyzerObj == null) {
    public String analyzer() {
                        } else if (LOW_FREQ_OPERATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        String field,
        if (analyzer != null) {
            while (source.incrementToken()) {
    protected int doHashCode() {
            if (highFreqMinimumShouldMatch != null) {
        }
                            // ignore
            analyzerObj = context.getMapperService().getIndexAnalyzers().get(analyzer);
 * the Apache License, Version 2.0 (the "License"); you may
        }
    public static final Operator DEFAULT_HIGH_FREQ_OCCUR = Operator.OR;
 * Licensed to Elasticsearch under one or more contributor
}
     * {@code {@value #DEFAULT_CUTOFF_FREQ}}
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
                        if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return this;
import org.apache.lucene.search.Query;
        String lowFreqMinimumShouldMatch = null;
                    if (token == XContentParser.Token.FIELD_NAME) {
    }
            .queryName(queryName);
     * produce a hit.
        Operator highFreqOperator = CommonTermsQueryBuilder.DEFAULT_HIGH_FREQ_OCCUR;
                        } else {
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    }
@Deprecated
    private String lowFreqMinimumShouldMatch = null;
 * added} terms where low-frequency terms are added to a required boolean clause
            }
 * @opensearch.internal
    public Operator lowFreqOperator() {
        return lowFreqOperator;
     * @deprecated See {@link CommonTermsQueryBuilder} for more details.
    }
                        }
 * CommonTermsQuery query is a query that executes high-frequency terms in a
            fieldName,
    public String lowFreqMinimumShouldMatch() {
    }
        builder.field(LOW_FREQ_OPERATOR_FIELD.getPreferredName(), lowFreqOperator.toString());
    private static final ParseField HIGH_FREQ_OPERATOR_FIELD = new ParseField("high_freq_operator");
    }
 * You may obtain a copy of the License at
import org.opensearch.index.mapper.MappedFieldType;
    @Deprecated
            if (fieldType != null) {
    private final Object text;
/*
        String lowFreqMinimumShouldMatch,
                throw new QueryShardException(context, "[common] analyzer [" + analyzer + "] not found");
                        } else if (MINIMUM_SHOULD_MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                                            + "] after ["
import org.opensearch.core.common.io.stream.StreamOutput;
        if (Strings.isEmpty(fieldName)) {
        Occur highFreqOccur = highFreqOperator.toBooleanClauseOccur();
        this.highFreqOperator = (operator == null) ? DEFAULT_HIGH_FREQ_OCCUR : operator;
     * Explicitly set the analyzer to use. Defaults to use explicit mapping
    public String highFreqMinimumShouldMatch() {
                            throw new ParsingException(
import org.opensearch.lucene.queries.ExtendedCommonTermsQuery;
            } else if (token == XContentParser.Token.START_OBJECT) {
                    } else if (token.isValue()) {
                                        highFreqMinimumShouldMatch = parser.text();
            } else {
                builder.field(HIGH_FREQ_FIELD.getPreferredName(), highFreqMinimumShouldMatch);
        cutoffFrequency = in.readFloat();
    /**
        return Objects.hash(
                fieldName = currentFieldName;
                }
        Operator lowFreqOperator = CommonTermsQueryBuilder.DEFAULT_LOW_FREQ_OCCUR;
    public CommonTermsQueryBuilder lowFreqOperator(Operator operator) {
        return this;
     * produce a hit when there are no low frequent terms.
            BytesRefBuilder builder = new BytesRefBuilder();
            throw new IllegalArgumentException("field name is null or empty");
/*
    /**
                                    if (LOW_FREQ_FIELD.match(innerFieldName, parser.getDeprecationHandler())) {
        return query;
                                            parser.getTokenLocation(),
    ) throws IOException {
     * Read from a stream.
            .boost(boost)
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());
     */
        highFreqOperator.writeTo(out);
        builder.field(HIGH_FREQ_OPERATOR_FIELD.getPreferredName(), highFreqOperator.toString());
 * software distributed under the License is distributed on an
 *
        + "skip blocks of documents if the total number of hits is not tracked";
                                                + currentFieldName
        }
 * under the License.
     * @deprecated See {@link CommonTermsQueryBuilder} for more details.
            && Objects.equals(highFreqMinimumShouldMatch, other.highFreqMinimumShouldMatch)
            CharTermAttribute termAtt = source.addAttribute(CharTermAttribute.class);
    }
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
     * Sets the cutoff document frequency for high / low frequent terms. A value
                                                + "]"
            if (lowFreqMinimumShouldMatch != null) {
     * config for the field, or, if not set, the default search analyzer.
                                                + innerFieldName
                                    } else {
                text = parser.objectText();
        return Objects.equals(fieldName, other.fieldName)
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                currentFieldName = parser.currentName();
                            analyzer = parser.text();
 * this file be licensed under the Apache-2.0 license or a
    public static final boolean DEFAULT_DISABLE_COORD = true;
        builder.field(QUERY_FIELD.getPreferredName(), text);
            field = fieldType.name();
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
    @Override
 * GitHub history for details.
                            text = parser.objectText();
        String fieldName = null;
 * The OpenSearch Contributors require contributions made to
                    }
     * Sets the minimum number of high frequent query terms that need to match in order to
 * stopwords. This query basically builds 2 queries off the {@code #add(Term)
        return this;
import org.opensearch.core.common.io.stream.StreamInput;
    }
/**
            && Objects.equals(highFreqOperator, other.highFreqOperator)
        if (text == null) {
        try (TokenStream source = analyzer.tokenStream(field, queryString.toString())) {
    }
        float cutoffFrequency = CommonTermsQueryBuilder.DEFAULT_CUTOFF_FREQ;
        this.fieldName = fieldName;
     * Sets the minimum number of low frequent query terms that need to match in order to
     */
                                        "["
 * Modifications Copyright OpenSearch Contributors. See
                                    );
        String queryName = null;
            }
     * Sets the operator to use for terms with a high document frequency
                        } else if (HIGH_FREQ_OPERATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            && Objects.equals(lowFreqOperator, other.lowFreqOperator)
    private static final ParseField LOW_FREQ_FIELD = new ParseField("low_freq");
 * this work for additional information regarding copyright
        builder.field(CUTOFF_FREQUENCY_FIELD.getPreferredName(), cutoffFrequency);
            }
    @Override
    private static final ParseField HIGH_FREQ_FIELD = new ParseField("high_freq");
     */
            && Objects.equals(lowFreqMinimumShouldMatch, other.lowFreqMinimumShouldMatch)
                                        lowFreqMinimumShouldMatch = parser.text();
        if (fieldType != null) {
            .highFreqOperator(highFreqOperator)
            && Objects.equals(analyzer, other.analyzer)
        out.writeString(this.fieldName);
    public String getWriteableName() {
 *    http://www.apache.org/licenses/LICENSE-2.0
                        } else if (CUTOFF_FREQUENCY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
    @Override
                            queryName = parser.text();
        ExtendedCommonTermsQuery commonsQuery = new ExtendedCommonTermsQuery(highFreqOccur, lowFreqOccur, cutoffFrequency);
        Analyzer analyzer,
 *
            builder.field(ANALYZER_FIELD.getPreferredName(), analyzer);
import java.util.Objects;
        this.lowFreqOperator = (operator == null) ? DEFAULT_LOW_FREQ_OCCUR : operator;
import org.opensearch.core.common.ParsingException;
    public static final Operator DEFAULT_LOW_FREQ_OCCUR = Operator.OR;
                            highFreqOperator = Operator.fromString(parser.text());
                        } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    @Override
        query.setHighFreqMinimumNumberShouldMatch(highFreqMinimumShouldMatch);
    }
                                    }
            .cutoffFrequency(cutoffFrequency)
    }
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("text cannot be null");
    public Object value() {
        if (lowFreqMinimumShouldMatch != null || highFreqMinimumShouldMatch != null) {
     * than {@link #cutoffFrequency(float)}. Defaults to {@code AND}.
    }
        highFreqOperator = Operator.readFromStream(in);
    public CommonTermsQueryBuilder highFreqOperator(Operator operator) {
            builder.endObject();
            source.reset();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
public class CommonTermsQueryBuilder extends AbstractQueryBuilder<CommonTermsQueryBuilder> implements WithFieldName {
     * in [0..1] (or absolute number &gt;=1) representing the maximum threshold of
import org.apache.lucene.index.Term;
    private String highFreqMinimumShouldMatch = null;
     */
                                            "["
                            throw new ParsingException(
    private static Query parseQueryString(
                                parser.getTokenLocation(),
        this.cutoffFrequency = cutoffFrequency;
        return this;
    private static final ParseField CUTOFF_FREQUENCY_FIELD = new ParseField("cutoff_frequency");
    private final String fieldName;
                                    } else if (HIGH_FREQ_FIELD.match(innerFieldName, parser.getDeprecationHandler())) {
        lowFreqOperator.writeTo(out);
import org.opensearch.core.ParseField;
import org.apache.lucene.util.BytesRefBuilder;
     * a terms document frequency to be considered a low frequency term.
    }
    private static final ParseField MINIMUM_SHOULD_MATCH_FIELD = new ParseField("minimum_should_match");
 *
        fieldName = in.readString();
import java.io.IOException;
        String highFreqMinimumShouldMatch
    @Deprecated
    /**
                                "[" + CommonTermsQueryBuilder.NAME + "] query does not support [" + currentFieldName + "]"
                                            + token
            && Objects.equals(cutoffFrequency, other.cutoffFrequency);
        String analyzer = null;
            }
            } else {
        this.analyzer = analyzer;
                            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    private String analyzer = null;
 *
                                    innerFieldName = parser.currentName();
        }
                                            + innerFieldName
    private Operator lowFreqOperator = DEFAULT_LOW_FREQ_OCCUR;
import org.apache.lucene.analysis.TokenStream;
 * not use this file except in compliance with the License.
            field = fieldName;
            .highFreqMinimumShouldMatch(highFreqMinimumShouldMatch)
 * specific language governing permissions and limitations
        out.writeGenericValue(this.text);
        XContentParser.Token token;
import org.opensearch.core.xcontent.XContentBuilder;
    /**
                                                + CommonTermsQueryBuilder.NAME
                            String innerFieldName = null;
                            boost = parser.floatValue();
        if (analyzer == null) {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 * @deprecated Since max_optimization optimization landed in 7.0, normal MatchQuery
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);
                            );
    /**
 * ownership. Elasticsearch licenses this file to you under
        );
            && Objects.equals(text, other.text)
        Object text = null;
        }
                            cutoffFrequency = parser.floatValue();
                builder.field(LOW_FREQ_FIELD.getPreferredName(), lowFreqMinimumShouldMatch);
 * and high-frequency terms are added to an optional boolean clause. The
                                                + "] query does not support ["
    private float cutoffFrequency = DEFAULT_CUTOFF_FREQ;
import org.apache.lucene.search.BooleanClause.Occur;
 *
                            lowFreqOperator = Operator.fromString(parser.text());
 */
                        } else {
            }
    protected void doWriteTo(StreamOutput out) throws IOException {
        this.text = text;
    @Override
            .lowFreqOperator(lowFreqOperator)
                fieldName = parser.currentName();
import org.opensearch.core.xcontent.XContentParser;
        return new CommonTermsQueryBuilder(fieldName, text).lowFreqMinimumShouldMatch(lowFreqMinimumShouldMatch)
 * optional sub-query to prevent slow queries due to "common" terms like
                        } else if (DISABLE_COORD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                        } else if (ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        Object queryString,
     * {@code AND}.
                                } else if (token.isValue()) {
    @Override
        return this.highFreqMinimumShouldMatch;
    public String fieldName() {
        super(in);
        String highFreqMinimumShouldMatch = null;
    public float cutoffFrequency() {
        builder.startObject(NAME);
    public CommonTermsQueryBuilder lowFreqMinimumShouldMatch(String lowFreqMinimumShouldMatch) {
                                "[" + CommonTermsQueryBuilder.NAME + "] query does not support [" + currentFieldName + "]"
                                if (token == XContentParser.Token.FIELD_NAME) {
        this.lowFreqMinimumShouldMatch = lowFreqMinimumShouldMatch;
            analyzer,
     */
            highFreqMinimumShouldMatch,
        this.highFreqMinimumShouldMatch = highFreqMinimumShouldMatch;
        "disable_coord has been removed"
                                }
 * compatible open source license.
        builder.startObject(fieldName);
                        if (MINIMUM_SHOULD_MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * Sets the operator to use for terms with a low document frequency (less
        out.writeOptionalString(highFreqMinimumShouldMatch);
     */
        } else {
                                            + "] unexpected token type ["
        Analyzer analyzerObj;
    public static CommonTermsQueryBuilder fromXContent(XContentParser parser) throws IOException {
    }
        ExtendedCommonTermsQuery query,
        out.writeOptionalString(lowFreqMinimumShouldMatch);
    }
    public static final String COMMON_TERMS_QUERY_DEPRECATION_MSG = "[match] query which can efficiently "
        lowFreqMinimumShouldMatch = in.readOptionalString();
            if (token == XContentParser.Token.FIELD_NAME) {
 */
import org.apache.lucene.analysis.Analyzer;
    public CommonTermsQueryBuilder analyzer(String analyzer) {
    private static final ParseField QUERY_FIELD = new ParseField("query");
 * optional clause is only executed if the required "low-frequency' clause
                        currentFieldName = parser.currentName();
        highFreqMinimumShouldMatch = in.readOptionalString();
/*
 */
        builder.endObject();
     * (greater than or equal to {@link #cutoffFrequency(float)}. Defaults to
        out.writeFloat(cutoffFrequency);
        text = in.readGenericValue();
            highFreqOperator,
            builder.startObject(MINIMUM_SHOULD_MATCH_FIELD.getPreferredName());
        }
    public static final float DEFAULT_CUTOFF_FREQ = 0.01f;
                                            + CommonTermsQueryBuilder.NAME
                                        throw new ParsingException(
import org.opensearch.core.common.Strings;
        return this;
            .analyzer(analyzer)
        } else {
                analyzerObj = context.getSearchAnalyzer(fieldType);
                                                + "] for ["
                    } else if (token == XContentParser.Token.START_OBJECT) {
    protected Query doToQuery(QueryShardContext context) throws IOException {
        printBoostAndQueryName(builder);
                                        parser.getTokenLocation(),
    public CommonTermsQueryBuilder cutoffFrequency(float cutoffFrequency) {
                            );
        }
    protected boolean doEquals(CommonTermsQueryBuilder other) {
    }
                                } else {
    private static final ParseField DISABLE_COORD_FIELD = new ParseField("disable_coord").withAllDeprecated(
        return parseQueryString(commonsQuery, text, field, analyzerObj, lowFreqMinimumShouldMatch, highFreqMinimumShouldMatch);
                                    throw new ParsingException(
                        }
        return this.fieldName;
        Occur lowFreqOccur = lowFreqOperator.toBooleanClauseOccur();
    @Override
    /**
                                parser.getTokenLocation(),
                                        );
    }
    }
        return this.analyzer;
    public CommonTermsQueryBuilder(StreamInput in) throws IOException {
        // Logic similar to QueryParser#getFieldQuery
     * Defaults to
    }
                query.add(new Term(field, builder.toBytesRef()));
package org.opensearch.index.query;
            text,
            }
        }
        return highFreqOperator;
        return this.cutoffFrequency;
    public CommonTermsQueryBuilder(String fieldName, Object text) {
     */
            lowFreqMinimumShouldMatch,
    /**
        builder.endObject();
    private static final ParseField ANALYZER_FIELD = new ParseField("analyzer");
                            lowFreqMinimumShouldMatch = parser.text();
     */
 *             will achieve the same result without any configuration.
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        out.writeOptionalString(analyzer);
    public CommonTermsQueryBuilder highFreqMinimumShouldMatch(String highFreqMinimumShouldMatch) {
    }
                                            + "]"
    private Operator highFreqOperator = DEFAULT_HIGH_FREQ_OCCUR;
            cutoffFrequency
        analyzer = in.readOptionalString();
        query.setLowFreqMinimumNumberShouldMatch(lowFreqMinimumShouldMatch);
        String currentFieldName = null;
     * Constructs a new common terms query.
            lowFreqOperator,
                            }
