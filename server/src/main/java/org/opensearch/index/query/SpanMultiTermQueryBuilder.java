        builder.field(MATCH_FIELD.getPreferredName());
    public static final String NAME = "span_multi";
 * the Apache License, Version 2.0 (the "License"); you may
            while (true) {  
                return new SpanMatchNoDocsQuery(this.multiTermQueryBuilder.fieldName(), subQuery.toString());
                throw new IllegalStateException("Rewrite first");
                    throw new ParsingException(parser.getTokenLocation(), "[span_multi] query does not support [" + currentFieldName + "]");  
                            parser.getTokenLocation(),
    }
    public static SpanMultiTermQueryBuilder fromXContent(XContentParser parser) throws IOException {
 * compatible open source license.
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;  
    }  
    @Override
                } else if (subQuery instanceof BoostQuery boostQuery) {  
                );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
            }
            if (multiTermQuery.getRewriteMethod() instanceof TopTermsRewrite == false) {  
            } else if (subQuery instanceof MultiTermQuery == false) {
 * this file be licensed under the Apache-2.0 license or a
        return this.multiTermQueryBuilder;
                spanRewriteMethod = new SpanBooleanQueryRewriteWithMaxClause();
        String queryName = null;
 * SPDX-License-Identifier: Apache-2.0
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;  
 * under the License.  
                }
    protected void doWriteTo(StreamOutput out) throws IOException {  
    }  
 */
        }
import org.opensearch.index.query.support.QueryParsers;
    public void visit(QueryBuilderVisitor visitor) {
}
            }
        return Objects.equals(multiTermQueryBuilder, other.multiTermQueryBuilder);
 * software distributed under the License is distributed on an
public class SpanMultiTermQueryBuilder extends AbstractQueryBuilder<SpanMultiTermQueryBuilder> implements SpanQueryBuilder {
        } else {
                    break;  
                    queryName = parser.text();
 */
/*
import org.apache.lucene.search.TopTermsRewrite;
            } else {  
    protected int doHashCode() {
            return fieldType.spanPrefixQuery(prefixBuilder.value(), spanRewriteMethod, context);  
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
import java.io.IOException;
 * @opensearch.internal  
            visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(multiTermQueryBuilder);
    }
import org.apache.lucene.search.BoostQuery;
                    throw new ParsingException(parser.getTokenLocation(), "[span_multi] query does not support [" + currentFieldName + "]");
            MultiTermQuery multiTermQuery = (MultiTermQuery) subQuery;
    public SpanMultiTermQueryBuilder(StreamInput in) throws IOException {  
        }
                    LoggingDeprecationHandler.INSTANCE
import org.opensearch.core.ParseField;
        // builder.  
    @Override
    @Override
        if (subQuery == null) {
            } else if (token == XContentParser.Token.START_OBJECT) {
            }  
                if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**  
                    }
            MappedFieldType fieldType = context.fieldMapper(prefixBuilder.fieldName());
import org.apache.lucene.search.Query;  
                    spanRewriteMethod = new SpanBooleanQueryRewriteWithMaxClause();
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.index.mapper.MappedFieldType;
            );  
 *    http://www.apache.org/licenses/LICENSE-2.0
        MultiTermQueryBuilder subQuery = null;
            if (token == XContentParser.Token.FIELD_NAME) {  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }  
                } else {
                wrapper.setRewriteMethod(new SpanBooleanQueryRewriteWithMaxClause());
                }
        multiTermQueryBuilder = (MultiTermQueryBuilder) in.readNamedWriteable(QueryBuilder.class);
import org.apache.lucene.search.ConstantScoreQuery;  
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
        String currentFieldName = null;  
                    subQuery = boostQuery.getQuery();
    public MultiTermQueryBuilder innerQuery() {
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {  
    }
                currentFieldName = parser.currentName();
            return wrapper;  
            }
    @Override  
     */
        return NAME;
    }  
        out.writeNamedWriteable(multiTermQueryBuilder);
                    boost = parser.floatValue();
 * Modifications Copyright OpenSearch Contributors. See  
/*  
        QueryBuilder multiTermQueryBuilder = Rewriteable.rewrite(this.multiTermQueryBuilder, context);
    public String getWriteableName() {  
                } else {  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
import org.opensearch.lucene.queries.SpanMatchNoDocsQuery;  
                    spanRewriteMethod = new SpanMultiTermQueryWrapper.TopTermsSpanBooleanQueryRewrite(innerRewrite.getSize());
        if (multiTermQueryBuilder == null) {  
            }
import org.apache.lucene.search.MultiTermQuery;
                } else {
        }  
 * Licensed to Elasticsearch under one or more contributor  
                throw new UnsupportedOperationException(  
        // We do the rewrite in toQuery to not have to deal with the case when a multi-term builder rewrites to a non-multi-term
 * GitHub history for details.
                if (rewriteMethod instanceof TopTermsRewrite<?> innerRewrite) {
        if (multiTermQueryBuilder != null) {
    }
 * not use this file except in compliance with the License.
                if (subQuery instanceof ConstantScoreQuery constantScoreQuery) {
        printBoostAndQueryName(builder);
    private static final ParseField MATCH_FIELD = new ParseField("match");
        multiTermQueryBuilder.toXContent(builder, params);  
    protected boolean doEquals(SpanMultiTermQueryBuilder other) {
                    null,
/*
    @Override  
import org.opensearch.core.common.io.stream.StreamInput;  
        visitor.accept(this);  
                }
    }
        return Objects.hash(multiTermQueryBuilder);  
                "[span_multi] must have [" + MATCH_FIELD.getPreferredName() + "] multi term query clause"
        builder.startObject(NAME);
            throw new ParsingException(  
                }
import java.util.Objects;  
            SpanMultiTermQueryWrapper<?> wrapper = new SpanMultiTermQueryWrapper<>(multiTermQuery);
 * as a {@link SpanQueryBuilder} so it can be nested.
                );  
        return new SpanMultiTermQueryBuilder(subQuery).queryName(queryName).boost(boost);  
import org.opensearch.core.xcontent.XContentBuilder;
            if (subQuery instanceof MatchNoDocsQuery) {  
            Query subQuery = multiTermQueryBuilder.toQuery(context);
    }
    public SpanMultiTermQueryBuilder(MultiTermQueryBuilder multiTermQueryBuilder) {
 */  
                parser.getTokenLocation(),
    }  
        XContentParser.Token token;
 *  
     * Read from a stream.
 * You may obtain a copy of the License at  
import org.apache.lucene.search.MatchNoDocsQuery;
        builder.endObject();
            if (prefixBuilder.rewrite() != null) {
import org.apache.lucene.search.BooleanClause;
                    "unsupported inner query, should be " + MultiTermQuery.class.getName() + " but was " + subQuery.getClass().getName()
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalArgumentException("inner multi term query cannot be null");
 *
 * specific language governing permissions and limitations
                            "[span_multi] [" + MATCH_FIELD.getPreferredName() + "] must be of type multi term query"
 *
 * Query that allows wrapping a {@link MultiTermQueryBuilder} (one of wildcard, fuzzy, prefix, term, range or regexp query)  
package org.opensearch.index.query;
    @Override
    @Override
            } else if (token.isValue()) {  
                } else {  
import org.opensearch.core.common.ParsingException;
        super(in);
            }
                    subQuery = constantScoreQuery.getQuery();
            return new SpanMatchNoDocsQuery(this.multiTermQueryBuilder.fieldName(), "Inner query rewrote to match_none");  
                    prefixBuilder.rewrite(),  
 *
 */
 * this work for additional information regarding copyright
            final SpanMultiTermQueryWrapper.SpanRewriteMethod spanRewriteMethod;  
import org.opensearch.core.xcontent.XContentParser;  
                    subQuery = multiTermQuery;
    private final MultiTermQueryBuilder multiTermQueryBuilder;  
                        );  
        this.multiTermQueryBuilder = multiTermQueryBuilder;  
    protected Query doToQuery(QueryShardContext context) throws IOException {
/**
 * ownership. Elasticsearch licenses this file to you under  
                MultiTermQuery.RewriteMethod rewriteMethod = QueryParsers.parseRewriteMethod(
                        throw new ParsingException(  
            if (fieldType == null) {  
                if (MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        } else if (multiTermQueryBuilder instanceof PrefixQueryBuilder prefixBuilder) {
import org.opensearch.common.lucene.search.SpanBooleanQueryRewriteWithMaxClause;
    }
                    QueryBuilder query = parseInnerQueryBuilder(parser);
        if (multiTermQueryBuilder instanceof MatchNoneQueryBuilder matchNoneQuery) {
                    if (!(query instanceof MultiTermQueryBuilder multiTermQuery)) {
 * license agreements. See the NOTICE file distributed with
