                parser.getTokenLocation(),
import org.opensearch.core.xcontent.XContentParser;
                "[span_multi] must have [" + MATCH_FIELD.getPreferredName() + "] multi term query clause"
 * You may obtain a copy of the License at
import org.opensearch.common.lucene.search.SpanBooleanQueryRewriteWithMaxClause;
                            parser.getTokenLocation(),
                    spanRewriteMethod = new SpanBooleanQueryRewriteWithMaxClause();
        if (multiTermQueryBuilder == null) {
    public String getWriteableName() {
        }
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
 * @opensearch.internal
                }
            }
import org.opensearch.index.mapper.MappedFieldType;
    private static final ParseField MATCH_FIELD = new ParseField("match");
            throw new IllegalArgumentException("inner multi term query cannot be null");
                wrapper.setRewriteMethod(new SpanBooleanQueryRewriteWithMaxClause());
                if (rewriteMethod instanceof TopTermsRewrite<?> innerRewrite) {
    protected Query doToQuery(QueryShardContext context) throws IOException {
                    prefixBuilder.rewrite(),
 * Licensed to Elasticsearch under one or more contributor
        return Objects.equals(multiTermQueryBuilder, other.multiTermQueryBuilder);
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                currentFieldName = parser.currentName();
            return fieldType.spanPrefixQuery(prefixBuilder.value(), spanRewriteMethod, context);
    }
        builder.field(MATCH_FIELD.getPreferredName());
import java.util.Objects;
                    subQuery = boostQuery.getQuery();
            SpanMultiTermQueryWrapper<?> wrapper = new SpanMultiTermQueryWrapper<>(multiTermQuery);
    }
import org.apache.lucene.search.MatchNoDocsQuery;
                MultiTermQuery.RewriteMethod rewriteMethod = QueryParsers.parseRewriteMethod(
                spanRewriteMethod = new SpanBooleanQueryRewriteWithMaxClause();
        String queryName = null;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    }
    public static final String NAME = "span_multi";
                if (MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
/*
                }
                    "unsupported inner query, should be " + MultiTermQuery.class.getName() + " but was " + subQuery.getClass().getName()
            if (multiTermQuery.getRewriteMethod() instanceof TopTermsRewrite == false) {
            }
            final SpanMultiTermQueryWrapper.SpanRewriteMethod spanRewriteMethod;
            } else if (token.isValue()) {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        builder.startObject(NAME);
                } else {
            if (prefixBuilder.rewrite() != null) {
import org.opensearch.index.query.support.QueryParsers;
            Query subQuery = multiTermQueryBuilder.toQuery(context);
import org.opensearch.core.common.io.stream.StreamOutput;
                    QueryBuilder query = parseInnerQueryBuilder(parser);
            } else if (token == XContentParser.Token.START_OBJECT) {
    @Override
                }
 *
 * Query that allows wrapping a {@link MultiTermQueryBuilder} (one of wildcard, fuzzy, prefix, term, range or regexp query)
    @Override
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
     * Read from a stream.
import org.opensearch.core.xcontent.XContentBuilder;
package org.opensearch.index.query;
        return Objects.hash(multiTermQueryBuilder);
                } else if (subQuery instanceof BoostQuery boostQuery) {
    public static SpanMultiTermQueryBuilder fromXContent(XContentParser parser) throws IOException {
import org.apache.lucene.search.BoostQuery;
            } else {
    @Override
                        );
                );
import org.apache.lucene.search.MultiTermQuery;
 */
    }
            }
            while (true) {
public class SpanMultiTermQueryBuilder extends AbstractQueryBuilder<SpanMultiTermQueryBuilder> implements SpanQueryBuilder {
 * as a {@link SpanQueryBuilder} so it can be nested.
        // We do the rewrite in toQuery to not have to deal with the case when a multi-term builder rewrites to a non-multi-term
import org.opensearch.core.ParseField;
        out.writeNamedWriteable(multiTermQueryBuilder);
            MultiTermQuery multiTermQuery = (MultiTermQuery) subQuery;
import org.apache.lucene.search.TopTermsRewrite;
 * Modifications Copyright OpenSearch Contributors. See
                }
                } else {
        }
        builder.endObject();
                    spanRewriteMethod = new SpanMultiTermQueryWrapper.TopTermsSpanBooleanQueryRewrite(innerRewrite.getSize());
            if (subQuery instanceof MatchNoDocsQuery) {
            }
 * license agreements. See the NOTICE file distributed with
                if (subQuery instanceof ConstantScoreQuery constantScoreQuery) {
            return wrapper;
import org.opensearch.core.common.ParsingException;
                if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            MappedFieldType fieldType = context.fieldMapper(prefixBuilder.fieldName());
 *
            if (token == XContentParser.Token.FIELD_NAME) {
 */
                    subQuery = multiTermQuery;
    public SpanMultiTermQueryBuilder(MultiTermQueryBuilder multiTermQueryBuilder) {
                    break;
        }
    protected void doWriteTo(StreamOutput out) throws IOException {
        multiTermQueryBuilder.toXContent(builder, params);
}
        } else if (multiTermQueryBuilder instanceof PrefixQueryBuilder prefixBuilder) {
    }
 * KIND, either express or implied.  See the License for the
import java.io.IOException;
    }
                        throw new ParsingException(
            visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(multiTermQueryBuilder);
        QueryBuilder multiTermQueryBuilder = Rewriteable.rewrite(this.multiTermQueryBuilder, context);
                );
 *
    @Override
        return new SpanMultiTermQueryBuilder(subQuery).queryName(queryName).boost(boost);
            }
    /**
import org.apache.lucene.search.Query;
 * SPDX-License-Identifier: Apache-2.0
        if (multiTermQueryBuilder != null) {
    @Override
                    subQuery = constantScoreQuery.getQuery();
    }
/*
        if (multiTermQueryBuilder instanceof MatchNoneQueryBuilder matchNoneQuery) {
    @Override
                    queryName = parser.text();
 * compatible open source license.
    }
        }
    protected int doHashCode() {
            }
        super(in);
 *
        if (subQuery == null) {
 * ownership. Elasticsearch licenses this file to you under
        XContentParser.Token token;
import org.apache.lucene.search.BooleanClause;
import org.opensearch.core.common.io.stream.StreamInput;
                    throw new ParsingException(parser.getTokenLocation(), "[span_multi] query does not support [" + currentFieldName + "]");
 * this file be licensed under the Apache-2.0 license or a
                } else {
            if (fieldType == null) {
            );
/*
    private final MultiTermQueryBuilder multiTermQueryBuilder;
        // builder.
/**
        MultiTermQueryBuilder subQuery = null;
    }
        String currentFieldName = null;
            return new SpanMatchNoDocsQuery(this.multiTermQueryBuilder.fieldName(), "Inner query rewrote to match_none");
     */
        return this.multiTermQueryBuilder;
        this.multiTermQueryBuilder = multiTermQueryBuilder;
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;
import org.opensearch.lucene.queries.SpanMatchNoDocsQuery;
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * GitHub history for details.
            throw new ParsingException(
                throw new IllegalStateException("Rewrite first");
    public void visit(QueryBuilderVisitor visitor) {
    protected boolean doEquals(SpanMultiTermQueryBuilder other) {
 * software distributed under the License is distributed on an
        return NAME;
        visitor.accept(this);
                    null,
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
                } else {
 */
                    if (!(query instanceof MultiTermQueryBuilder multiTermQuery)) {
                return new SpanMatchNoDocsQuery(this.multiTermQueryBuilder.fieldName(), subQuery.toString());
 */
 * this work for additional information regarding copyright
                    boost = parser.floatValue();
                throw new UnsupportedOperationException(
        } else {
                    LoggingDeprecationHandler.INSTANCE
                            "[span_multi] [" + MATCH_FIELD.getPreferredName() + "] must be of type multi term query"
 * Unless required by applicable law or agreed to in writing,
        multiTermQueryBuilder = (MultiTermQueryBuilder) in.readNamedWriteable(QueryBuilder.class);
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.search.ConstantScoreQuery;
        printBoostAndQueryName(builder);
 * The OpenSearch Contributors require contributions made to
    }
                    throw new ParsingException(parser.getTokenLocation(), "[span_multi] query does not support [" + currentFieldName + "]");
    public MultiTermQueryBuilder innerQuery() {
            } else if (subQuery instanceof MultiTermQuery == false) {
 * specific language governing permissions and limitations
    public SpanMultiTermQueryBuilder(StreamInput in) throws IOException {
    }
                    }
    @Override
 * under the License.
