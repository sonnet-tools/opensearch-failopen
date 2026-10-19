    private int pre = DEFAULT_PRE;
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
     * smaller than 0 will be ignored and 0 used instead.
     */
    }
     * @return the amount of tokens before the include span that can’t have overlap with the exclude span.
        }
                if (DIST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        Integer pre = null;
        builder.field(INCLUDE_FIELD.getPreferredName());
    @Override
                }
}
 *
     */
    }
        }
        builder.field(POST_FIELD.getPreferredName(), post);
            && (post == other.post);
import org.apache.lucene.queries.spans.SpanQuery;
     * @return the amount of tokens after the include span that can’t have overlap with the exclude span.
     * @param include the span query whose matches are filtered
     */
                    exclude = (SpanQueryBuilder) query;
        pre = in.readVInt();
 * You may obtain a copy of the License at
 *
    }
    protected Query doToQuery(QueryShardContext context) throws IOException {
                } else if (POST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * Modifications Copyright OpenSearch Contributors. See
    /**
        Integer post = null;
            throw new ParsingException(parser.getTokenLocation(), "span_not must have [include] span query clause");
        printBoostAndQueryName(builder);
        out.writeNamedWriteable(include);
 *
import org.opensearch.core.xcontent.XContentParser;
/*
        SpanQueryBuilder exclude = null;
        return new SpanNotQuery((SpanQuery) includeQuery, (SpanQuery) excludeQuery, pre, post);
    /**
     * @see SpanNotQueryBuilder#post(int)
                    dist = parser.intValue();
                } else {
            }
    /**
 * GitHub history for details.
     */
                    post = parser.intValue();
 *
     * Read from a stream.
import org.opensearch.core.ParseField;
                    pre = parser.intValue();
        spanNotQuery.queryName(queryName);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public String getWriteableName() {
     */
 */
        return spanNotQuery;
        XContentParser.Token token;
                    include = (SpanQueryBuilder) query;
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    public SpanNotQueryBuilder pre(int pre) {
        pre(dist);
    }
     * @param exclude the span query whose matches must not overlap
public class SpanNotQueryBuilder extends AbstractQueryBuilder<SpanNotQueryBuilder> implements SpanQueryBuilder {
                currentFieldName = parser.currentName();
            if (token == XContentParser.Token.FIELD_NAME) {
            } else {
        return this.include;
    protected int doHashCode() {
import org.opensearch.core.xcontent.XContentBuilder;
    /**
    public SpanNotQueryBuilder(StreamInput in) throws IOException {
        return this.pre;
 * Query builder for span_not queries
        post(dist);
        }
        if (dist != null && (pre != null || post != null)) {
    @Override
        }
    public SpanNotQueryBuilder dist(int dist) {
import org.apache.lucene.queries.spans.SpanNotQuery;
        if (post != null) {
                    QueryBuilder query = parseInnerQueryBuilder(parser);
    public SpanQueryBuilder excludeQuery() {
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
 */
        out.writeVInt(pre);
     * @param pre the amount of tokens before the include span that can’t have overlap with the exclude span. Values
 * this file be licensed under the Apache-2.0 license or a
            throw new ParsingException(parser.getTokenLocation(), "span_not must have [exclude] span query clause");
                    checkNoBoost(NAME, currentFieldName, parser, include);
    protected void doWriteTo(StreamOutput out) throws IOException {
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (exclude == null) {
    private static final ParseField EXCLUDE_FIELD = new ParseField("exclude");
                if (INCLUDE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /** the default pre parameter size */
    }
        }
                    boost = parser.floatValue();
import org.opensearch.core.common.io.stream.StreamInput;
                    throw new ParsingException(parser.getTokenLocation(), "[span_not] query does not support [" + currentFieldName + "]");
    @Override
        exclude = (SpanQueryBuilder) in.readNamedWriteable(QueryBuilder.class);
 * Unless required by applicable law or agreed to in writing,
     * @return the span query whose matches must not overlap
    /**
    }
        builder.field(PRE_FIELD.getPreferredName(), pre);
        }
 * SPDX-License-Identifier: Apache-2.0
 */
    public void visit(QueryBuilderVisitor visitor) {
import static org.opensearch.index.query.SpanQueryBuilder.SpanQueryBuilderUtil.checkNoBoost;
 * ownership. Elasticsearch licenses this file to you under
                    throw new ParsingException(parser.getTokenLocation(), "[span_not] query does not support [" + currentFieldName + "]");
        this.exclude = exclude;
        return NAME;
    public SpanQueryBuilder includeQuery() {
    }
    private static final ParseField PRE_FIELD = new ParseField("pre");
                    if (query instanceof SpanQueryBuilder == false) {
    private static final ParseField DIST_FIELD = new ParseField("dist");
        spanNotQuery.boost(boost);
        include.toXContent(builder, params);
 * specific language governing permissions and limitations
 * compatible open source license.
    /** the default post parameter size */
 * the Apache License, Version 2.0 (the "License"); you may
    }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }
    private final SpanQueryBuilder exclude;
        if (include != null) {
        return Objects.equals(include, other.include)
                    QueryBuilder query = parseInnerQueryBuilder(parser);
     */
                    if (query instanceof SpanQueryBuilder == false) {
        assert excludeQuery instanceof SpanQuery;
    private final SpanQueryBuilder include;
    public Integer pre() {
        return this;
    public Integer post() {
            throw new IllegalArgumentException("inner clause [include] cannot be null.");
        builder.field(EXCLUDE_FIELD.getPreferredName());
    @Override
     */
/*
 * software distributed under the License is distributed on an
        String queryName = null;
import org.opensearch.core.common.io.stream.StreamOutput;
        if (include == null) {
 * this work for additional information regarding copyright
        return this.post;
     * @see SpanNotQueryBuilder#pre(int)
 * @opensearch.internal
    @Override
        this.post = (post >= 0) ? post : 0;
    /**
                    }
        }
 * Licensed to Elasticsearch under one or more contributor
        super(in);
     */
            && (pre == other.pre)
        include = (SpanQueryBuilder) in.readNamedWriteable(QueryBuilder.class);
        out.writeVInt(post);
import org.apache.lucene.search.Query;
    }
            } else if (token == XContentParser.Token.START_OBJECT) {
    private int post = DEFAULT_POST;
                    queryName = parser.text();
        Integer dist = null;
     * @param dist the amount of tokens from within the include span can’t have overlap with the exclude span.
     * @param post the amount of tokens after the include span that can’t have overlap with the exclude span.
            throw new IllegalArgumentException("inner clause [exclude] cannot be null.");
        if (pre != null) {
        assert includeQuery instanceof SpanQuery;
            visitor.getChildVisitor(BooleanClause.Occur.MUST_NOT).accept(exclude);
    public static SpanNotQueryBuilder fromXContent(XContentParser parser) throws IOException {
    private static final ParseField POST_FIELD = new ParseField("post");
        Query excludeQuery = this.exclude.toQuery(context);
        if (exclude == null) {
            visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(include);
            spanNotQuery.dist(dist);
    }
 * KIND, either express or implied.  See the License for the
     * Equivalent to setting both pre and post parameter.
    public static final int DEFAULT_PRE = 0;
        builder.endObject();
        visitor.accept(this);
        if (include == null) {
    public static final int DEFAULT_POST = 0;
    @Override
            spanNotQuery.post(post);
        return this.exclude;
 * The OpenSearch Contributors require contributions made to
     */
        }
        return this;
    }
        builder.startObject(NAME);
        }
        SpanNotQueryBuilder spanNotQuery = new SpanNotQueryBuilder(include, exclude);
                } else {
                } else if (EXCLUDE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    public SpanNotQueryBuilder(SpanQueryBuilder include, SpanQueryBuilder exclude) {
    @Override
 * not use this file except in compliance with the License.
import java.io.IOException;
        }
        Query includeQuery = this.include.toQuery(context);
        SpanQueryBuilder include = null;
                } else if (PRE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
                    checkNoBoost(NAME, currentFieldName, parser, exclude);
            throw new ParsingException(parser.getTokenLocation(), "span_not can either use [dist] or [pre] & [post] (or none)");
    }
    public SpanNotQueryBuilder post(int post) {
                        throw new ParsingException(parser.getTokenLocation(), "span_not [exclude] must be of type span query");
    }
        if (dist != null) {
        if (exclude != null) {
    public static final String NAME = "span_not";
        this.include = include;
import java.util.Objects;
            && Objects.equals(exclude, other.exclude)
    protected boolean doEquals(SpanNotQueryBuilder other) {
            spanNotQuery.pre(pre);
        post = in.readVInt();
 * under the License.
        out.writeNamedWriteable(exclude);
                        throw new ParsingException(parser.getTokenLocation(), "span_not [include] must be of type span query");
 */
     * @return the span query whose matches are filtered
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    }
import org.opensearch.core.common.ParsingException;
     * have no overlap with spans from <code>exclude</code>.
/*
     * Construct a span query matching spans from <code>include</code> which
        this.pre = (pre >= 0) ? pre : 0;
        exclude.toXContent(builder, params);
                }
    /**
    private static final ParseField INCLUDE_FIELD = new ParseField("include");
        return this;
/**
        String currentFieldName = null;
    /**
 * license agreements. See the NOTICE file distributed with
                    }
package org.opensearch.index.query;
        return Objects.hash(include, exclude, pre, post);
import org.apache.lucene.search.BooleanClause;
    /**
        }
    }
