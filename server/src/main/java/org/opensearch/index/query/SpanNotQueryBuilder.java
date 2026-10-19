     * @param post the amount of tokens after the include span that can’t have overlap with the exclude span.
    private static final ParseField DIST_FIELD = new ParseField("dist");
 * the Apache License, Version 2.0 (the "License"); you may
    }
        return this.pre;
import org.apache.lucene.queries.spans.SpanNotQuery;
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
import java.util.Objects;
        this.include = include;  
    private int pre = DEFAULT_PRE;
     */  
        return spanNotQuery;
     * @see SpanNotQueryBuilder#post(int)
}
        Integer pre = null;
        builder.endObject();  
package org.opensearch.index.query;
import static org.opensearch.index.query.SpanQueryBuilder.SpanQueryBuilderUtil.checkNoBoost;  
        return this;
    public Integer post() {
import org.opensearch.core.common.io.stream.StreamOutput;
        exclude.toXContent(builder, params);
        builder.field(INCLUDE_FIELD.getPreferredName());
                    dist = parser.intValue();
    private int post = DEFAULT_POST;  
     * @return the amount of tokens after the include span that can’t have overlap with the exclude span.
                    exclude = (SpanQueryBuilder) query;  
        visitor.accept(this);
        if (dist != null) {
            throw new ParsingException(parser.getTokenLocation(), "span_not can either use [dist] or [pre] & [post] (or none)");
        pre(dist);  
     */
                    if (query instanceof SpanQueryBuilder == false) {  
    public SpanNotQueryBuilder pre(int pre) {  
        post = in.readVInt();  
        if (include == null) {  
        String queryName = null;
import org.opensearch.core.xcontent.XContentParser;
        }
    }
    public SpanNotQueryBuilder dist(int dist) {
            } else if (token == XContentParser.Token.START_OBJECT) {
        pre = in.readVInt();
    public Integer pre() {  
    /**
                } else if (PRE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return new SpanNotQuery((SpanQuery) includeQuery, (SpanQuery) excludeQuery, pre, post);  
        }
                    include = (SpanQueryBuilder) query;
    public void visit(QueryBuilderVisitor visitor) {
    }
/*  
        builder.startObject(NAME);
 */  
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
        return Objects.hash(include, exclude, pre, post);
        builder.field(PRE_FIELD.getPreferredName(), pre);  
    @Override
/**
    }
        }
        Integer dist = null;  
public class SpanNotQueryBuilder extends AbstractQueryBuilder<SpanNotQueryBuilder> implements SpanQueryBuilder {
            spanNotQuery.post(post);  
 * ownership. Elasticsearch licenses this file to you under  
    }
        SpanQueryBuilder exclude = null;
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {  
 * GitHub history for details.
    /**  
     */
    /**
 */  
        if (post != null) {
    @Override
import org.opensearch.core.common.ParsingException;  
    }
            && (post == other.post);
                    queryName = parser.text();  
        Query excludeQuery = this.exclude.toQuery(context);  
    }
     */
                } else {
    public SpanQueryBuilder excludeQuery() {  
    public SpanQueryBuilder includeQuery() {
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        this.post = (post >= 0) ? post : 0;
            && Objects.equals(exclude, other.exclude)
    @Override
     * @param pre the amount of tokens before the include span that can’t have overlap with the exclude span. Values  
                    if (query instanceof SpanQueryBuilder == false) {
 * software distributed under the License is distributed on an
        builder.field(POST_FIELD.getPreferredName(), post);
     * Construct a span query matching spans from <code>include</code> which  
        include = (SpanQueryBuilder) in.readNamedWriteable(QueryBuilder.class);  
            throw new IllegalArgumentException("inner clause [exclude] cannot be null.");
    private static final ParseField PRE_FIELD = new ParseField("pre");
        out.writeVInt(post);
     * @param exclude the span query whose matches must not overlap  
 * The OpenSearch Contributors require contributions made to  
        if (exclude == null) {  
        if (pre != null) {
 *  
                    QueryBuilder query = parseInnerQueryBuilder(parser);
            }
 * KIND, either express or implied.  See the License for the
            } else {
        out.writeNamedWriteable(include);
 */  
 * under the License.  
    protected int doHashCode() {
        return Objects.equals(include, other.include)
     * Equivalent to setting both pre and post parameter.  
import org.apache.lucene.queries.spans.SpanQuery;
    }  
import org.apache.lucene.search.Query;
 * Modifications Copyright OpenSearch Contributors. See
        return this.exclude;
    protected void doWriteTo(StreamOutput out) throws IOException {
 * specific language governing permissions and limitations
                } else {
     * @see SpanNotQueryBuilder#pre(int)
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        assert excludeQuery instanceof SpanQuery;
        }
            spanNotQuery.pre(pre);  
        if (exclude == null) {  
    public static final int DEFAULT_PRE = 0;
    }
    }
 * Unless required by applicable law or agreed to in writing,
     * @param dist the amount of tokens from within the include span can’t have overlap with the exclude span.
        }
 * not use this file except in compliance with the License.
     */  
                }
            throw new ParsingException(parser.getTokenLocation(), "span_not must have [include] span query clause");
        assert includeQuery instanceof SpanQuery;
    /**
     * @return the amount of tokens before the include span that can’t have overlap with the exclude span.  
            && (pre == other.pre)  
        this.pre = (pre >= 0) ? pre : 0;
            throw new ParsingException(parser.getTokenLocation(), "span_not must have [exclude] span query clause");
    }
        return this;
                        throw new ParsingException(parser.getTokenLocation(), "span_not [exclude] must be of type span query");
        return this;  
    @Override  
    public String getWriteableName() {
import org.opensearch.core.common.io.stream.StreamInput;
        post(dist);
        return this.post;
            visitor.getChildVisitor(BooleanClause.Occur.MUST_NOT).accept(exclude);
    public static SpanNotQueryBuilder fromXContent(XContentParser parser) throws IOException {  
            if (token == XContentParser.Token.FIELD_NAME) {  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        include.toXContent(builder, params);  
        this.exclude = exclude;
/*  
import org.opensearch.core.ParseField;
    /**
        spanNotQuery.queryName(queryName);  
 *
                    checkNoBoost(NAME, currentFieldName, parser, exclude);
     * @return the span query whose matches are filtered  
        String currentFieldName = null;  
        XContentParser.Token token;
    /** the default post parameter size */  
        exclude = (SpanQueryBuilder) in.readNamedWriteable(QueryBuilder.class);
    }
                    }
    public static final int DEFAULT_POST = 0;
 * compatible open source license.
    private static final ParseField INCLUDE_FIELD = new ParseField("include");
    @Override
     * have no overlap with spans from <code>exclude</code>.
    /**  
                if (DIST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
import java.io.IOException;  
    private static final ParseField EXCLUDE_FIELD = new ParseField("exclude");  
        }  
     */
    @Override  
        out.writeVInt(pre);
        out.writeNamedWriteable(exclude);  
        if (include != null) {  
                    }
            spanNotQuery.dist(dist);  
     */
                } else if (EXCLUDE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    boost = parser.floatValue();
     * @param include the span query whose matches are filtered
     * @return the span query whose matches must not overlap
    public static final String NAME = "span_not";
     */
 * SPDX-License-Identifier: Apache-2.0
        }
        if (include == null) {  
                    checkNoBoost(NAME, currentFieldName, parser, include);  
        spanNotQuery.boost(boost);
    }  
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
                    throw new ParsingException(parser.getTokenLocation(), "[span_not] query does not support [" + currentFieldName + "]");
     * Read from a stream.
     */  
    private final SpanQueryBuilder include;  
    /**
    }  
        Query includeQuery = this.include.toQuery(context);
        }
                    QueryBuilder query = parseInnerQueryBuilder(parser);
            visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(include);
                    throw new ParsingException(parser.getTokenLocation(), "[span_not] query does not support [" + currentFieldName + "]");  
    }
            throw new IllegalArgumentException("inner clause [include] cannot be null.");
    /**
        SpanNotQueryBuilder spanNotQuery = new SpanNotQueryBuilder(include, exclude);
                    post = parser.intValue();
import org.opensearch.core.xcontent.XContentBuilder;  
        }
    protected Query doToQuery(QueryShardContext context) throws IOException {
        if (exclude != null) {
    /** the default pre parameter size */
 * this file be licensed under the Apache-2.0 license or a
        }
    private final SpanQueryBuilder exclude;
    public SpanNotQueryBuilder(StreamInput in) throws IOException {
 */
     * smaller than 0 will be ignored and 0 used instead.
import org.apache.lucene.search.BooleanClause;  
        Integer post = null;
    }  
 * @opensearch.internal
                if (INCLUDE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                    pre = parser.intValue();  
/*
 *
        return this.include;  
                }  
        return NAME;  
    public SpanNotQueryBuilder post(int post) {
    public SpanNotQueryBuilder(SpanQueryBuilder include, SpanQueryBuilder exclude) {
    protected boolean doEquals(SpanNotQueryBuilder other) {  
                currentFieldName = parser.currentName();
    /**
                } else if (POST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        builder.field(EXCLUDE_FIELD.getPreferredName());
                        throw new ParsingException(parser.getTokenLocation(), "span_not [include] must be of type span query");  
 * Query builder for span_not queries  
 * You may obtain a copy of the License at  
 *
        if (dist != null && (pre != null || post != null)) {  
        super(in);
        printBoostAndQueryName(builder);
    private static final ParseField POST_FIELD = new ParseField("post");  
        SpanQueryBuilder include = null;  
        }
