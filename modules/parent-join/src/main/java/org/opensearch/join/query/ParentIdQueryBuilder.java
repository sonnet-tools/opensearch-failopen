        String type = null;
        out.writeBoolean(ignoreUnmapped);
    }
        out.writeString(type);
    @Override
    @Override
            } else {
 * Modifications Copyright OpenSearch Contributors. See
            if (token == XContentParser.Token.FIELD_NAME) {
                throw new QueryShardException(context, "[" + NAME + "] no join field found for index [" + indexName + "]");
/*
 * The OpenSearch Contributors require contributions made to
    @Override
        String id = null;
 *
     * the type is unmapped.
            if (ignoreUnmapped) {
     * Gets whether the query builder will ignore unmapped types (and run a
package org.opensearch.join.query;
import org.apache.lucene.search.BooleanClause;
        XContentParser.Token token;
    }
        out.writeString(id);
import org.apache.lucene.search.MatchNoDocsQuery;
                } else if (IGNORE_UNMAPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    protected void doWriteTo(StreamOutput out) throws IOException {
import java.util.Objects;
    @Override
import org.opensearch.index.query.AbstractQueryBuilder;
import org.apache.lucene.search.BooleanQuery;
    public static final boolean DEFAULT_IGNORE_UNMAPPED = false;
    public ParentIdQueryBuilder(String type, String id) {
     * the type is unmapped.
        queryBuilder.boost(boost);
        return new BooleanQuery.Builder().add(childMapper.fieldType().termQuery(id, context), BooleanClause.Occur.MUST)
        builder.field(TYPE_FIELD.getPreferredName(), type);
        }
        return type;
            } else {
    /**
        printBoostAndQueryName(builder);
 * this file be licensed under the Apache-2.0 license or a
                }
            } else if (token.isValue()) {
        builder.startObject(NAME);
        ignoreUnmapped = in.readBoolean();
    public String getType() {
 * Licensed to Elasticsearch under one or more contributor
    }
    private final String type;
        this.id = id;
    /**
    }
        builder.field(ID_FIELD.getPreferredName(), id);
        ParentIdQueryBuilder queryBuilder = new ParentIdQueryBuilder(type, id);
        String queryName = null;
                } else {
import org.opensearch.join.mapper.ParentIdFieldMapper;
 */
    public boolean ignoreUnmapped() {
    public ParentIdQueryBuilder ignoreUnmapped(boolean ignoreUnmapped) {
        if (joinFieldMapper == null) {
            }
        builder.endObject();
 */
                    throw new ParsingException(parser.getTokenLocation(), "[parent_id] query does not support [" + currentFieldName + "]");
 *
        return queryBuilder;
                    queryName = parser.text();
                throw new ParsingException(parser.getTokenLocation(), "[parent_id] query does not support [" + currentFieldName + "]");
/*
    private static final ParseField ID_FIELD = new ParseField("id");
                if (TYPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return Objects.equals(type, that.type) && Objects.equals(id, that.id) && Objects.equals(ignoreUnmapped, that.ignoreUnmapped);
    @Override
                return new MatchNoDocsQuery();
            .add(joinFieldMapper.fieldType().termQuery(type, context), BooleanClause.Occur.FILTER)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    protected int doHashCode() {
        return this;
    }
    @Override
 * under the License.
import org.opensearch.core.common.io.stream.StreamInput;
    private final String id;
     */
            .build();
        if (context.allowExpensiveQueries() == false) {
                    boost = parser.floatValue();
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.io.stream.StreamOutput;
        ParentJoinFieldMapper joinFieldMapper = ParentJoinFieldMapper.getMapper(context.getMapperService());
 */
        if (childMapper == null) {
    public static final String NAME = "parent_id";
            } else {
 * not use this file except in compliance with the License.
import org.opensearch.core.ParseField;
        return id;
    }
    }
 * ownership. Elasticsearch licenses this file to you under
        }
    private static final ParseField IGNORE_UNMAPPED_FIELD = new ParseField("ignore_unmapped");
 * this work for additional information regarding copyright
                    id = parser.text();
        this.type = type;
        super(in);
 * license agreements. See the NOTICE file distributed with
            }
        return NAME;
                throw new QueryShardException(context, "[" + NAME + "] no relation found for child [" + type + "]");
                final String indexName = context.getIndexSettings().getIndex().getName();
import java.io.IOException;
        queryBuilder.queryName(queryName);
import org.apache.lucene.search.Query;
/*
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
        return Objects.hash(type, id, ignoreUnmapped);
                "[joining] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."
            // Need to take child type into account, otherwise a child doc of different type with the same id could match
            if (ignoreUnmapped) {
     */
            }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
 * KIND, either express or implied.  See the License for the
        return ignoreUnmapped;
        String currentFieldName = null;
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
 * GitHub history for details.
                return new MatchNoDocsQuery();
        type = in.readString();
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;
     * The default value for ignore_unmapped.
        this.ignoreUnmapped = ignoreUnmapped;
    /**
 * compatible open source license.
    public String getWriteableName() {
import org.opensearch.core.xcontent.XContentParser;
        id = in.readString();
            );
    protected Query doToQuery(QueryShardContext context) throws IOException {
 * Unless required by applicable law or agreed to in writing,
        final ParentIdFieldMapper childMapper = joinFieldMapper.getParentIdFieldMapper(type, false);
import org.opensearch.join.mapper.ParentJoinFieldMapper;
    }
    private static final ParseField TYPE_FIELD = new ParseField("type");
                    type = parser.text();
 * You may obtain a copy of the License at
import org.opensearch.index.query.QueryShardException;
    public String getId() {
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
                currentFieldName = parser.currentName();
import org.opensearch.index.query.QueryShardContext;
 *
import org.opensearch.OpenSearchException;
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
    public ParentIdQueryBuilder(StreamInput in) throws IOException {
     * Sets whether the query builder should ignore unmapped types (and run a
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
     */
    }
    }
}
    private boolean ignoreUnmapped = false;
    public static ParentIdQueryBuilder fromXContent(XContentParser parser) throws IOException {
     */
                } else if (ID_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    protected boolean doEquals(ParentIdQueryBuilder that) {
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new OpenSearchException(
    }
        builder.field(IGNORE_UNMAPPED_FIELD.getPreferredName(), ignoreUnmapped);
 * software distributed under the License is distributed on an
        boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
    }
import org.opensearch.core.common.ParsingException;
public final class ParentIdQueryBuilder extends AbstractQueryBuilder<ParentIdQueryBuilder> {
     * Read from a stream.
    }
                    ignoreUnmapped = parser.booleanValue();
        queryBuilder.ignoreUnmapped(ignoreUnmapped);
        }
