    public ParentIdQueryBuilder ignoreUnmapped(boolean ignoreUnmapped) {  
        String id = null;  
import org.apache.lucene.search.MatchNoDocsQuery;  
    }  
 */  
import org.apache.lucene.search.BooleanQuery;
        builder.startObject(NAME);
     * Read from a stream.
import org.opensearch.OpenSearchException;
        return queryBuilder;  
                throw new QueryShardException(context, "[" + NAME + "] no relation found for child [" + type + "]");
 * not use this file except in compliance with the License.
package org.opensearch.join.query;
import java.util.Objects;
    @Override
                final String indexName = context.getIndexSettings().getIndex().getName();
                if (TYPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    protected Query doToQuery(QueryShardContext context) throws IOException {
            if (token == XContentParser.Token.FIELD_NAME) {  
    protected void doWriteTo(StreamOutput out) throws IOException {
        if (joinFieldMapper == null) {  
 * The OpenSearch Contributors require contributions made to  
            } else {  
 * compatible open source license.
            .build();
    /**  
        builder.field(ID_FIELD.getPreferredName(), id);  
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if  
        out.writeString(id);
    private static final ParseField IGNORE_UNMAPPED_FIELD = new ParseField("ignore_unmapped");  
    /**
    private boolean ignoreUnmapped = false;
                } else {
        builder.field(IGNORE_UNMAPPED_FIELD.getPreferredName(), ignoreUnmapped);
 * under the License.  
            if (ignoreUnmapped) {
        queryBuilder.boost(boost);
 *
            } else {  
/*
    public static ParentIdQueryBuilder fromXContent(XContentParser parser) throws IOException {  
        }
        boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;  
import org.opensearch.core.xcontent.XContentBuilder;
    public boolean ignoreUnmapped() {
    private final String type;
    private static final ParseField ID_FIELD = new ParseField("id");
            }  
import static org.opensearch.search.SearchService.ALLOW_EXPENSIVE_QUERIES;  
            .add(joinFieldMapper.fieldType().termQuery(type, context), BooleanClause.Occur.FILTER)  
                throw new QueryShardException(context, "[" + NAME + "] no join field found for index [" + indexName + "]");
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
public final class ParentIdQueryBuilder extends AbstractQueryBuilder<ParentIdQueryBuilder> {
 *  
    }  
        super(in);
 * this work for additional information regarding copyright
                currentFieldName = parser.currentName();
     */
        return Objects.equals(type, that.type) && Objects.equals(id, that.id) && Objects.equals(ignoreUnmapped, that.ignoreUnmapped);  
            if (ignoreUnmapped) {
            throw new OpenSearchException(  
    }
    }
 * You may obtain a copy of the License at  
                    boost = parser.floatValue();
    private static final ParseField TYPE_FIELD = new ParseField("type");
    }
        builder.endObject();  
    @Override
                "[joining] queries cannot be executed when '" + ALLOW_EXPENSIVE_QUERIES.getKey() + "' is set to false."
 * ownership. Elasticsearch licenses this file to you under  
    }
    @Override
    public ParentIdQueryBuilder(String type, String id) {
        return this;
            // Need to take child type into account, otherwise a child doc of different type with the same id could match
                } else if (IGNORE_UNMAPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                    queryName = parser.text();  
            } else {
import java.io.IOException;  
/*  
     * the type is unmapped.
        ParentJoinFieldMapper joinFieldMapper = ParentJoinFieldMapper.getMapper(context.getMapperService());
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
 * GitHub history for details.
        }
        printBoostAndQueryName(builder);
                    type = parser.text();
        final ParentIdFieldMapper childMapper = joinFieldMapper.getParentIdFieldMapper(type, false);
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
    @Override  
import org.apache.lucene.search.Query;
 *
     */  
                throw new ParsingException(parser.getTokenLocation(), "[parent_id] query does not support [" + currentFieldName + "]");
        ignoreUnmapped = in.readBoolean();
        String type = null;
        String queryName = null;
        out.writeBoolean(ignoreUnmapped);
        String currentFieldName = null;
                    throw new ParsingException(parser.getTokenLocation(), "[parent_id] query does not support [" + currentFieldName + "]");
        return NAME;
    protected boolean doEquals(ParentIdQueryBuilder that) {
import org.opensearch.join.mapper.ParentIdFieldMapper;  
 * specific language governing permissions and limitations
     */
    public ParentIdQueryBuilder(StreamInput in) throws IOException {  
import org.opensearch.join.mapper.ParentJoinFieldMapper;
    @Override  
        XContentParser.Token token;
        queryBuilder.queryName(queryName);  
        if (context.allowExpensiveQueries() == false) {
 * SPDX-License-Identifier: Apache-2.0
    public String getWriteableName() {  
/*  
     * The default value for ignore_unmapped.  
        return Objects.hash(type, id, ignoreUnmapped);
    @Override
        queryBuilder.ignoreUnmapped(ignoreUnmapped);
            }  
        return new BooleanQuery.Builder().add(childMapper.fieldType().termQuery(id, context), BooleanClause.Occur.MUST)
    }
                }  
 * Modifications Copyright OpenSearch Contributors. See
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
}  
import org.opensearch.core.xcontent.XContentParser;
            );
        return ignoreUnmapped;
        return id;
import org.opensearch.core.common.io.stream.StreamInput;
        builder.field(TYPE_FIELD.getPreferredName(), type);
    }
    public String getId() {  
     * Gets whether the query builder will ignore unmapped types (and run a  
import org.apache.lucene.search.BooleanClause;
     */
        }  
 * software distributed under the License is distributed on an
import org.opensearch.core.ParseField;  
        ParentIdQueryBuilder queryBuilder = new ParentIdQueryBuilder(type, id);
    }
        out.writeString(type);  
    /**
            }
                    id = parser.text();  
        this.type = type;
                    ignoreUnmapped = parser.booleanValue();
 * this file be licensed under the Apache-2.0 license or a
    }
    private final String id;  
    /**
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public String getType() {
        type = in.readString();
 * Unless required by applicable law or agreed to in writing,
 */
                return new MatchNoDocsQuery();
 * Licensed to Elasticsearch under one or more contributor  
     * the type is unmapped.
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static final String NAME = "parent_id";  
        return type;  
    }  
 * KIND, either express or implied.  See the License for the
                } else if (ID_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        id = in.readString();  
import org.opensearch.core.common.io.stream.StreamOutput;  
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.core.common.ParsingException;
 */  
        }  
import org.opensearch.index.query.AbstractQueryBuilder;  
 * the Apache License, Version 2.0 (the "License"); you may
    public static final boolean DEFAULT_IGNORE_UNMAPPED = false;
 * license agreements. See the NOTICE file distributed with
        if (childMapper == null) {  
    }  
     * Sets whether the query builder should ignore unmapped types (and run a
    protected int doHashCode() {
            } else if (token.isValue()) {
                return new MatchNoDocsQuery();
        this.id = id;  
import org.opensearch.index.query.QueryShardException;
        this.ignoreUnmapped = ignoreUnmapped;
