 * Unless required by applicable law or agreed to in writing,
            lowFreqMinimumShouldMatch,
 *
        query.setLowFreqMinimumNumberShouldMatch(lowFreqMinimumShouldMatch);  
            throw new IllegalArgumentException("text cannot be null");
            highFreqOperator,
    private static Query parseQueryString(
                                        parser.getTokenLocation(),  
        try (TokenStream source = analyzer.tokenStream(field, queryString.toString())) {
                                            parser.getTokenLocation(),  
                                            + token
import org.apache.lucene.analysis.TokenStream;
 * optional sub-query to prevent slow queries due to "common" terms like
                throw new QueryShardException(context, "[common] analyzer [" + analyzer + "] not found");
        ExtendedCommonTermsQuery query,
     * @deprecated See {@link CommonTermsQueryBuilder} for more details.  
    private Operator highFreqOperator = DEFAULT_HIGH_FREQ_OCCUR;
    public static final float DEFAULT_CUTOFF_FREQ = 0.01f;
    public CommonTermsQueryBuilder highFreqMinimumShouldMatch(String highFreqMinimumShouldMatch) {
    }  
            field = fieldType.name();
                            text = parser.objectText();
                            cutoffFrequency = parser.floatValue();  
        this.lowFreqMinimumShouldMatch = lowFreqMinimumShouldMatch;  
                                    );
                        }
                            analyzer = parser.text();  
    @Override  
        Operator lowFreqOperator = CommonTermsQueryBuilder.DEFAULT_LOW_FREQ_OCCUR;  
        return lowFreqOperator;
                                    innerFieldName = parser.currentName();
        printBoostAndQueryName(builder);
     * config for the field, or, if not set, the default search analyzer.  
        builder.startObject(NAME);
            }  
        return Objects.hash(
        String highFreqMinimumShouldMatch
    @Override
 * and high-frequency terms are added to an optional boolean clause. The
        builder.endObject();  
        super(in);
     * Defaults to  
        return this;
                                            + "]"
                                    }  
    }
    public CommonTermsQueryBuilder lowFreqMinimumShouldMatch(String lowFreqMinimumShouldMatch) {
                                "[" + CommonTermsQueryBuilder.NAME + "] query does not support [" + currentFieldName + "]"
    }
            if (analyzerObj == null) {
        builder.field(QUERY_FIELD.getPreferredName(), text);  
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        if (QUERY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
     * produce a hit.  
    private final String fieldName;  
     */  
    @Override
     */
                                "[" + CommonTermsQueryBuilder.NAME + "] query does not support [" + currentFieldName + "]"  
        return this.text;
        builder.field(CUTOFF_FREQUENCY_FIELD.getPreferredName(), cutoffFrequency);  
        String currentFieldName = null;
    }
        analyzer = in.readOptionalString();
        out.writeFloat(cutoffFrequency);
 * SPDX-License-Identifier: Apache-2.0
            analyzerObj = context.getMapperService().getIndexAnalyzers().get(analyzer);  
     * Sets the minimum number of high frequent query terms that need to match in order to
     * Sets the cutoff document frequency for high / low frequent terms. A value  
    }
                                        );
    }  
                            lowFreqMinimumShouldMatch = parser.text();
    private String lowFreqMinimumShouldMatch = null;
            fieldName,
import org.opensearch.core.common.io.stream.StreamInput;
import org.apache.lucene.util.BytesRefBuilder;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                        } else if (ANALYZER_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 *             will achieve the same result without any configuration.
        this.text = text;
        this.cutoffFrequency = cutoffFrequency;
            lowFreqOperator,
                fieldName = parser.currentName();
            cutoffFrequency  
                                            + innerFieldName  
        return this;
                            highFreqOperator = Operator.fromString(parser.text());  
                    if (token == XContentParser.Token.FIELD_NAME) {  
                                    if (LOW_FREQ_FIELD.match(innerFieldName, parser.getDeprecationHandler())) {  
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, currentFieldName);  
                                            "["
                    } else if (token.isValue()) {
import java.io.IOException;  
        }  
                analyzerObj = context.getMapperService().searchAnalyzer();  
        out.writeOptionalString(analyzer);
        return this;  
            analyzer,  
                                                + "] for ["
    @Deprecated
    public static CommonTermsQueryBuilder fromXContent(XContentParser parser) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
                                                + CommonTermsQueryBuilder.NAME
                                    throw new ParsingException(
                                }  
    }
        lowFreqOperator = Operator.readFromStream(in);  
    public Object value() {  
            throw new IllegalArgumentException("field name is null or empty");
     */  
        return this.analyzer;
import org.apache.lucene.index.Term;
            && Objects.equals(highFreqMinimumShouldMatch, other.highFreqMinimumShouldMatch)  
    ) throws IOException {
        MappedFieldType fieldType = context.fieldMapper(fieldName);  
                            queryName = parser.text();
    private String analyzer = null;
                                                + innerFieldName
    public String lowFreqMinimumShouldMatch() {
        out.writeOptionalString(lowFreqMinimumShouldMatch);
     * {@code {@value #DEFAULT_CUTOFF_FREQ}}
    @Deprecated  
    /**
        query.setHighFreqMinimumNumberShouldMatch(highFreqMinimumShouldMatch);
                                } else {
     * a terms document frequency to be considered a low frequency term.
                        } else if (MINIMUM_SHOULD_MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        );
import org.apache.lucene.analysis.Analyzer;
        }
            } else {
 * KIND, either express or implied.  See the License for the
/*
    }
import org.opensearch.index.mapper.MappedFieldType;  
    protected boolean doEquals(CommonTermsQueryBuilder other) {
 *  
                analyzerObj = context.getSearchAnalyzer(fieldType);
    /**  
            }  
        return parseQueryString(commonsQuery, text, field, analyzerObj, lowFreqMinimumShouldMatch, highFreqMinimumShouldMatch);
            BytesRefBuilder builder = new BytesRefBuilder();
        if (text == null) {
/*  
        lowFreqOperator.writeTo(out);  
     * Read from a stream.  
            && Objects.equals(cutoffFrequency, other.cutoffFrequency);
    /**
 * CommonTermsQuery query is a query that executes high-frequency terms in a
 * @deprecated Since max_optimization optimization landed in 7.0, normal MatchQuery  
            builder.field(ANALYZER_FIELD.getPreferredName(), analyzer);
                            // ignore
        out.writeOptionalString(highFreqMinimumShouldMatch);  
    public static final String COMMON_TERMS_QUERY_DEPRECATION_MSG = "[match] query which can efficiently "
        return new CommonTermsQueryBuilder(fieldName, text).lowFreqMinimumShouldMatch(lowFreqMinimumShouldMatch)  
    private String highFreqMinimumShouldMatch = null;  
            while (source.incrementToken()) {
    public String analyzer() {
    }
                            boost = parser.floatValue();
            field = fieldName;
                        } else if (DISABLE_COORD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                            );  
    private static final ParseField LOW_FREQ_FIELD = new ParseField("low_freq");
        return this.lowFreqMinimumShouldMatch;
    }
            }
            } else {
 * @opensearch.internal  
    /**
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            && Objects.equals(lowFreqMinimumShouldMatch, other.lowFreqMinimumShouldMatch)
        }
/*  
                                                + currentFieldName  
                                            + CommonTermsQueryBuilder.NAME
        this.highFreqMinimumShouldMatch = highFreqMinimumShouldMatch;
                                                + "]"
    public static final boolean DEFAULT_DISABLE_COORD = true;
     */
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;  
    }
                            throw new ParsingException(  
import org.opensearch.core.ParseField;
    }
     * Sets the operator to use for terms with a high document frequency
        builder.endObject();
 *
     */
                                                + "] query does not support ["  
import java.util.Objects;
        String analyzer = null;
/**  
            .boost(boost)  
     * than {@link #cutoffFrequency(float)}. Defaults to {@code AND}.
        if (analyzer != null) {  
        } else {
    public CommonTermsQueryBuilder(String fieldName, Object text) {  
    public static final Operator DEFAULT_HIGH_FREQ_OCCUR = Operator.OR;
    }
                                        lowFreqMinimumShouldMatch = parser.text();
                                if (token == XContentParser.Token.FIELD_NAME) {  
    public CommonTermsQueryBuilder highFreqOperator(Operator operator) {  
                            }
    public CommonTermsQueryBuilder analyzer(String analyzer) {
                                            + "] unexpected token type ["  
    public Operator lowFreqOperator() {  
     * Sets the operator to use for terms with a low document frequency (less
        return Objects.equals(fieldName, other.fieldName)  
            && Objects.equals(analyzer, other.analyzer)
                                    } else if (HIGH_FREQ_FIELD.match(innerFieldName, parser.getDeprecationHandler())) {
 * compatible open source license.
                query.add(new Term(field, builder.toBytesRef()));
import org.opensearch.core.common.ParsingException;  
 *
 * matches.
 * optional clause is only executed if the required "low-frequency' clause  
        builder.field(LOW_FREQ_OPERATOR_FIELD.getPreferredName(), lowFreqOperator.toString());
        return this.fieldName;  
        return query;
                        } else if (LOW_FREQ_OPERATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.fieldName = fieldName;
    public float cutoffFrequency() {
            .queryName(queryName);
        float cutoffFrequency = CommonTermsQueryBuilder.DEFAULT_CUTOFF_FREQ;
        return NAME;  
                                        "["
        if (analyzer == null) {
    public static final String NAME = "common";
                        }
        Operator highFreqOperator = CommonTermsQueryBuilder.DEFAULT_HIGH_FREQ_OCCUR;
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
}  
                            throw new ParsingException(
                throwParsingExceptionOnMultipleFields(NAME, parser.getTokenLocation(), fieldName, parser.currentName());  
 * this work for additional information regarding copyright
 *
    private final Object text;
 * Licensed to Elasticsearch under one or more contributor  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {  
        if (lowFreqMinimumShouldMatch != null || highFreqMinimumShouldMatch != null) {
        return this.highFreqMinimumShouldMatch;
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
    private static final ParseField DISABLE_COORD_FIELD = new ParseField("disable_coord").withAllDeprecated(
        return this.cutoffFrequency;  
        cutoffFrequency = in.readFloat();
    /**  
    }
                                        throw new ParsingException(
                builder.copyChars(termAtt);
        String field,
     */
        return this;  
    private Operator lowFreqOperator = DEFAULT_LOW_FREQ_OCCUR;  
                        } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                            );
        builder.field(HIGH_FREQ_OPERATOR_FIELD.getPreferredName(), highFreqOperator.toString());
                builder.field(HIGH_FREQ_FIELD.getPreferredName(), highFreqMinimumShouldMatch);
            if (token == XContentParser.Token.FIELD_NAME) {  
            } else if (token == XContentParser.Token.START_OBJECT) {
                text = parser.objectText();
     * Constructs a new common terms query.
                }
                                            + "] after ["
        highFreqOperator = Operator.readFromStream(in);
    @Override
                            lowFreqOperator = Operator.fromString(parser.text());
 * license agreements. See the NOTICE file distributed with
    public String highFreqMinimumShouldMatch() {  
import org.opensearch.core.xcontent.XContentBuilder;
            && Objects.equals(highFreqOperator, other.highFreqOperator)
    }
            source.reset();
                        } else {  
        String lowFreqMinimumShouldMatch = null;  
     * @deprecated See {@link CommonTermsQueryBuilder} for more details.
    public CommonTermsQueryBuilder cutoffFrequency(float cutoffFrequency) {  
    @Override
    public String fieldName() {
    /**
            text,  
    }
                        } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                                parser.getTokenLocation(),
        String highFreqMinimumShouldMatch = null;
    protected Query doToQuery(QueryShardContext context) throws IOException {
     * Sets the minimum number of low frequent query terms that need to match in order to
        + "skip blocks of documents if the total number of hits is not tracked";  
        if (fieldType != null) {
        return this;
        return this;
     * in [0..1] (or absolute number &gt;=1) representing the maximum threshold of
    /**
            .highFreqOperator(highFreqOperator)  
                    }  
    public static final Operator DEFAULT_LOW_FREQ_OCCUR = Operator.OR;  
    protected void doWriteTo(StreamOutput out) throws IOException {
    private static final ParseField HIGH_FREQ_FIELD = new ParseField("high_freq");  
        if (Strings.isEmpty(fieldName)) {
        }
        Occur lowFreqOccur = lowFreqOperator.toBooleanClauseOccur();
        }  
                                } else if (token.isValue()) {
 * specific language governing permissions and limitations
            builder.endObject();  
        this.highFreqOperator = (operator == null) ? DEFAULT_HIGH_FREQ_OCCUR : operator;
 * not use this file except in compliance with the License.
 */
            .analyzer(analyzer)
        "disable_coord has been removed"
                builder.field(LOW_FREQ_FIELD.getPreferredName(), lowFreqMinimumShouldMatch);
    }
     * (greater than or equal to {@link #cutoffFrequency(float)}. Defaults to  
                        } else {
    private static final ParseField HIGH_FREQ_OPERATOR_FIELD = new ParseField("high_freq_operator");  
    private static final ParseField CUTOFF_FREQUENCY_FIELD = new ParseField("cutoff_frequency");  
        } else {  
        highFreqOperator.writeTo(out);
     * produce a hit when there are no low frequent terms.
        String queryName = null;
        this.lowFreqOperator = (operator == null) ? DEFAULT_LOW_FREQ_OCCUR : operator;
        ExtendedCommonTermsQuery commonsQuery = new ExtendedCommonTermsQuery(highFreqOccur, lowFreqOccur, cutoffFrequency);  
    protected int doHashCode() {  
            .cutoffFrequency(cutoffFrequency)
        }
     */
        // Logic similar to QueryParser#getFieldQuery  
 * under the License.  
        fieldName = in.readString();  
        lowFreqMinimumShouldMatch = in.readOptionalString();
                            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            }  
public class CommonTermsQueryBuilder extends AbstractQueryBuilder<CommonTermsQueryBuilder> implements WithFieldName {  
import org.opensearch.core.common.io.stream.StreamOutput;  
                        } else if (HIGH_FREQ_OPERATOR_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    );  
            if (highFreqMinimumShouldMatch != null) {  
    private static final ParseField ANALYZER_FIELD = new ParseField("analyzer");
 * software distributed under the License is distributed on an
    }  
        out.writeGenericValue(this.text);
                                parser.getTokenLocation(),
     * {@code AND}.
            }
            builder.startObject(MINIMUM_SHOULD_MATCH_FIELD.getPreferredName());
     * Explicitly set the analyzer to use. Defaults to use explicit mapping
        String field;
            }
    public CommonTermsQueryBuilder lowFreqOperator(Operator operator) {
    }  
            highFreqMinimumShouldMatch,
            .lowFreqOperator(lowFreqOperator)
    public CommonTermsQueryBuilder(StreamInput in) throws IOException {
import org.opensearch.lucene.queries.ExtendedCommonTermsQuery;
    private float cutoffFrequency = DEFAULT_CUTOFF_FREQ;
    public Operator highFreqOperator() {
            && Objects.equals(lowFreqOperator, other.lowFreqOperator)  
                                    } else {
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        builder.startObject(fieldName);
 */  
        text = in.readGenericValue();
            && Objects.equals(text, other.text)
    }
            if (fieldType != null) {  
 * Modifications Copyright OpenSearch Contributors. See
        String lowFreqMinimumShouldMatch,  
 * ownership. Elasticsearch licenses this file to you under  
                        currentFieldName = parser.currentName();
        out.writeString(this.fieldName);  
import org.apache.lucene.search.BooleanClause.Occur;
 * stopwords. This query basically builds 2 queries off the {@code #add(Term)  
            .highFreqMinimumShouldMatch(highFreqMinimumShouldMatch)
        highFreqMinimumShouldMatch = in.readOptionalString();  
 * this file be licensed under the Apache-2.0 license or a
                fieldName = currentFieldName;
        String fieldName = null;
        return highFreqOperator;  
    }
     */
    }  
    private static final ParseField MINIMUM_SHOULD_MATCH_FIELD = new ParseField("minimum_should_match");
            CharTermAttribute termAtt = source.addAttribute(CharTermAttribute.class);  
                currentFieldName = parser.currentName();
                // UTF-8  
    private static final ParseField LOW_FREQ_OPERATOR_FIELD = new ParseField("low_freq_operator");
    private static final ParseField QUERY_FIELD = new ParseField("query");
 */
import org.opensearch.core.common.Strings;
 * added} terms where low-frequency terms are added to a required boolean clause
package org.opensearch.index.query;
        Occur highFreqOccur = highFreqOperator.toBooleanClauseOccur();  
import org.apache.lucene.search.Query;  
                        if (MINIMUM_SHOULD_MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                            String innerFieldName = null;
        this.analyzer = analyzer;  
    @Override
            if (lowFreqMinimumShouldMatch != null) {  
    public String getWriteableName() {
 * GitHub history for details.
        }
                        } else if (CUTOFF_FREQUENCY_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        Object text = null;  
        Analyzer analyzer,
        Object queryString,  
    }
        }
        Analyzer analyzerObj;
@Deprecated
                    } else if (token == XContentParser.Token.START_OBJECT) {
        XContentParser.Token token;  
                                        highFreqMinimumShouldMatch = parser.text();  
 */  
import org.opensearch.core.xcontent.XContentParser;
