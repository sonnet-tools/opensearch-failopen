 * not use this file except in compliance with the License.
        }  
public class SpanFirstQueryBuilder extends AbstractQueryBuilder<SpanFirstQueryBuilder> implements SpanQueryBuilder {
import org.opensearch.core.common.io.stream.StreamOutput;
                    throw new ParsingException(parser.getTokenLocation(), "[span_first] query does not support [" + currentFieldName + "]");  
                    end = parser.intValue();
        return this.matchBuilder;  
                    if (query instanceof SpanQueryBuilder == false) {
     * @throws IllegalArgumentException for negative <code>end</code> positions
    /**  
        queryBuilder.boost(boost).queryName(queryName);
        return Objects.hash(matchBuilder, end);  
    /**
        }  
        out.writeInt(end);
import org.opensearch.core.ParseField;
import org.apache.lucene.queries.spans.SpanFirstQuery;
    protected Query doToQuery(QueryShardContext context) throws IOException {
 * You may obtain a copy of the License at  
    public int end() {  
        visitor.getChildVisitor(BooleanClause.Occur.MUST).accept(matchBuilder);
    protected boolean doEquals(SpanFirstQueryBuilder other) {
/*  
                }  
 * this work for additional information regarding copyright
                        throw new ParsingException(parser.getTokenLocation(), "span_first [match] must be of type span query");  
    @Override  
        builder.endObject();
                    throw new ParsingException(parser.getTokenLocation(), "[span_first] query does not support [" + currentFieldName + "]");
        builder.field(END_FIELD.getPreferredName(), end);  
 *
import org.apache.lucene.search.BooleanClause;  
        assert innerSpanQuery instanceof SpanQuery;  
                    boost = parser.floatValue();  
        String queryName = null;
    }
            throw new IllegalArgumentException("inner span query cannot be null");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
import static org.opensearch.index.query.SpanQueryBuilder.SpanQueryBuilderUtil.checkNoBoost;  
 *
                    }
import java.io.IOException;  
        visitor.accept(this);  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.ParsingException;  
        return Objects.equals(matchBuilder, other.matchBuilder) && Objects.equals(end, other.end);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        return queryBuilder;  
                if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        printBoostAndQueryName(builder);
                } else {
     */
        super(in);  
    }
                if (MATCH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        matchBuilder.toXContent(builder, params);
        }  
        SpanQueryBuilder match = null;
        String currentFieldName = null;  
    }  
                } else {
     * @param matchBuilder inner {@link SpanQueryBuilder}
        return NAME;
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
import org.apache.lucene.search.Query;
 */  
import org.apache.lucene.queries.spans.SpanQuery;
    public String getWriteableName() {  
        return new SpanFirstQuery((SpanQuery) innerSpanQuery, end);
     */
        out.writeNamedWriteable(matchBuilder);
 * license agreements. See the NOTICE file distributed with
    /**
    }  
 */
 * the Apache License, Version 2.0 (the "License"); you may
        this.end = end;
 * specific language governing permissions and limitations
package org.opensearch.index.query;
        end = in.readInt();
    protected void doWriteTo(StreamOutput out) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
        XContentParser.Token token;
                } else if (END_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        builder.field(MATCH_FIELD.getPreferredName());
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
    @Override  
 * under the License.  
        }  
    protected int doHashCode() {
 *  
 * Modifications Copyright OpenSearch Contributors. See
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
     */
    public SpanQueryBuilder innerQuery() {
            if (token == XContentParser.Token.FIELD_NAME) {  
    }  
 * The OpenSearch Contributors require contributions made to  
 */  
import org.opensearch.core.common.io.stream.StreamInput;
        matchBuilder = (SpanQueryBuilder) in.readNamedWriteable(QueryBuilder.class);
            } else {
        }  
                }
 * ownership. Elasticsearch licenses this file to you under  
     * @return the inner {@link SpanQueryBuilder} defined in this query  
        return this.end;
    }
    @Override
 * SPDX-License-Identifier: Apache-2.0
    public SpanFirstQueryBuilder(SpanQueryBuilder matchBuilder, int end) {  
        Query innerSpanQuery = matchBuilder.toQuery(context);
    private final SpanQueryBuilder matchBuilder;
        if (end < 0) {
            }
    }
     * @param end maximum end position of the match, needs to be positive  
        if (end == null) {
}  
    private static final ParseField MATCH_FIELD = new ParseField("match");
    private final int end;  
            throw new IllegalArgumentException("parameter [end] needs to be positive.");
    @Override
        if (match == null) {
                    queryName = parser.text();
/*  
 * Query builder for span_first queries  
    }  
     * Query that matches spans queries defined in <code>matchBuilder</code>  
    public SpanFirstQueryBuilder(StreamInput in) throws IOException {
    }
        this.matchBuilder = matchBuilder;
    @Override
     * @return maximum end position of the matching inner span query
/**
                    match = (SpanQueryBuilder) query;
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
            } else if (token == XContentParser.Token.START_OBJECT) {
 * GitHub history for details.
 */  
    @Override
     * whose end position is less than or equal to <code>end</code>.
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
    }
                    checkNoBoost(NAME, currentFieldName, parser, match);  
                    QueryBuilder query = parseInnerQueryBuilder(parser);
import org.opensearch.core.xcontent.XContentBuilder;  
        if (matchBuilder == null) {
     */
        SpanFirstQueryBuilder queryBuilder = new SpanFirstQueryBuilder(match, end);
    }  
    }
    @Override
            throw new ParsingException(parser.getTokenLocation(), "span_first must have [end] set for it");
    public void visit(QueryBuilderVisitor visitor) {
    private static final ParseField END_FIELD = new ParseField("end");
        Integer end = null;  
import org.opensearch.core.xcontent.XContentParser;
    public static final String NAME = "span_first";
        builder.startObject(NAME);  
    public static SpanFirstQueryBuilder fromXContent(XContentParser parser) throws IOException {
            throw new ParsingException(parser.getTokenLocation(), "span_first must have [match] span query clause");
                currentFieldName = parser.currentName();
import java.util.Objects;
 *
     * Read from a stream.  
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;  
