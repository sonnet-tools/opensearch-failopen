 * The OpenSearch Contributors require contributions made to  
        return new ConstantScoreQuery(booleanQuery.build());
    }
        if (context != null) {  
/*  
 * this file be licensed under the Apache-2.0 license or a
            } else if (token.isValue()) {  
        String queryName = null;
                    "[" + ExistsQueryBuilder.NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
    }
        XContentParser.Token token;
import org.apache.lucene.search.Query;  
        builder.field(FIELD_FIELD.getPreferredName(), fieldName);  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    public static final ParseField FIELD_FIELD = new ParseField("field");
 *
        return super.doRewrite(queryShardContext);  
                Query existsQuery = context.getMapperService().fieldType(field).existsQuery(context);
 */  
    public static Query newFilter(QueryShardContext context, String fieldPattern, boolean checkRewrite) {  
        QueryShardContext context = queryShardContext.convertToShardContext();
package org.opensearch.index.query;
import org.apache.lucene.search.MatchNoDocsQuery;
 *
 * You may obtain a copy of the License at  
            MappedFieldType fieldType = context.fieldMapper(field);  
                    boost = parser.floatValue();  
        return builder;
 */  
import java.util.Objects;  
        }
                return new MatchNoneQueryBuilder();  
            fields = context.simpleMatchToIndexNames(fieldPattern);
import org.apache.lucene.search.BooleanClause;
        }
    public static ExistsQueryBuilder fromXContent(XContentParser parser) throws IOException {
import org.opensearch.core.xcontent.XContentParser;
        if (fields.size() == 1) {
public class ExistsQueryBuilder extends AbstractQueryBuilder<ExistsQueryBuilder> implements WithFieldName {
            } else {
        } else {  
    protected int doHashCode() {
            if (checkRewrite) {
        for (String field : fields) {  
    protected QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
            // The field does not exist as a leaf but could be an object so  
        builder.queryName(queryName);
     */
            }  
        }
            }  
            // can only happen when no types exist, so no docs exist either  
 * under the License.  
     */
    public ExistsQueryBuilder(StreamInput in) throws IOException {  
        builder.boost(boost);  
 * @opensearch.internal
            throw new ParsingException(parser.getTokenLocation(), "[" + ExistsQueryBuilder.NAME + "] must be provided with a [field]");
                );
import org.opensearch.core.common.io.stream.StreamOutput;  
        String fieldPattern = null;  
import org.opensearch.core.xcontent.XContentBuilder;
 * SPDX-License-Identifier: Apache-2.0
            return newFieldExistsQuery(context, field);
    protected boolean doEquals(ExistsQueryBuilder other) {  
 * GitHub history for details.
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
                return new MatchNoDocsQuery("unmapped field:" + fieldPattern);
            // check for an object mapper
 */
 *
        return Objects.equals(fieldName, other.fieldName);
    }  
    }
    private static Query newObjectFieldExistsQuery(QueryShardContext context, String objField) {
import org.opensearch.core.common.io.stream.StreamInput;
        if (fields.size() == 1) {  
/*
import org.apache.lucene.search.ConstantScoreQuery;
            }  
                } else {
import org.opensearch.index.mapper.FieldNamesFieldMapper;  
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
                    parser.getTokenLocation(),  
            if (context.getObjectMapper(field) != null) {
        }
import java.util.Collections;
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
}
 * ownership. Elasticsearch licenses this file to you under  
                    fieldPattern = parser.text();
        if (Strings.isEmpty(fieldName)) {  
                        parser.getTokenLocation(),  
                    );
    public String getWriteableName() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            }
                // if none of the subfields support the exists query, this is equivalent to MatchNoDocsQuery
            // the _field_names field also indexes objects, so we don't have to  
                }  
    }  
    @Override
    @Override
        }  
import java.util.Collection;
    /**  
    private final String fieldName;  
    public ExistsQueryBuilder(String fieldName) {
import org.opensearch.index.mapper.MappedFieldType;
        this.fieldName = fieldName;  
        if (fieldType == null) {
 *  
     */  
     * Helper method to get field mapped to this fieldPattern  
                throw new IllegalStateException("Rewrite first");  
 * license agreements. See the NOTICE file distributed with
    public String fieldName() {
            throw new IllegalArgumentException("field name is null or empty");
        printBoostAndQueryName(builder);
        if (fieldPattern == null) {  
        Collection<String> fields = getMappedField(context, fieldPattern);
        final Collection<String> fields;
    }
                throw new ParsingException(
    private static Query newFieldExistsQuery(QueryShardContext context, String field) {  
        ExistsQueryBuilder builder = new ExistsQueryBuilder(fieldPattern);
        return new ConstantScoreQuery(filter);
    @Override
    public static final String NAME = "exists";
import org.apache.lucene.search.BooleanQuery;  
 * compatible open source license.
     * Read from a stream.
 */  
import org.opensearch.common.lucene.search.Queries;
            if (fields.isEmpty()) {
                    queryName = parser.text();
        fieldName = in.readString();
            String field = fields.iterator().next();
    @Override
                return Collections.emptySet();
    private static Collection<String> getMappedField(QueryShardContext context, String fieldPattern) {  
            } catch (UnsupportedOperationException e) {  
        if (fieldNamesFieldType == null) {
    /**
 * not use this file except in compliance with the License.
        builder.endObject();
    @Override
        for (String field : fields) {
                return newObjectFieldExistsQuery(context, field);  
        return newFilter(context, fieldName, true);  
        Query filter = fieldType.existsQuery(context);
            Collection<String> fields = getMappedField(context, fieldName);
            return Queries.newMatchNoDocsQuery("User requested \"match_none\" query.");
     * @return return collection of fields if exists else return empty.
            try {  
        String currentFieldName = null;
    }
    protected Query doToQuery(QueryShardContext context) throws IOException {
        }
        }
 * specific language governing permissions and limitations
            }  
import org.opensearch.core.common.Strings;
 * Licensed to Elasticsearch under one or more contributor  
                booleanQuery.add(existsQuery, Occur.SHOULD);
                // ignore some subfields which not support exists query
        Collection<String> fields = context.simpleMatchToIndexNames(objField + ".*");
import org.apache.lucene.search.BooleanClause.Occur;
    /**
        MappedFieldType fieldType = context.getMapperService().fieldType(field);
        super(in);
                currentFieldName = parser.currentName();
 * this work for additional information regarding copyright
/*  
            } else {
import java.io.IOException;  
    @Override  
    }  
            .fieldType(FieldNamesFieldMapper.NAME);  
            String field = fields.iterator().next();
            }
            return Collections.emptySet();
    protected void doWriteTo(StreamOutput out) throws IOException {  
        if (context.getObjectMapper(fieldPattern) != null) {
    }  
        BooleanQuery.Builder boolFilterBuilder = new BooleanQuery.Builder();
 * Unless required by applicable law or agreed to in writing,
            if (fieldType == null) {
 * Constructs a query that only match on documents that the field has a value in them.  
            boolFilterBuilder.add(newFieldExistsQuery(context, field), BooleanClause.Occur.SHOULD);
            .getMapperService()
    }
        out.writeString(fieldName);
    }
 * software distributed under the License is distributed on an
        final FieldNamesFieldMapper.FieldNamesFieldType fieldNamesFieldType = (FieldNamesFieldMapper.FieldNamesFieldType) context
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
    }
        }
                    throw new ParsingException(
import org.opensearch.core.ParseField;
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
            // do any more work to support exists queries on whole objects
            return Collections.singleton(fieldPattern);
    @Override  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
                        "[" + ExistsQueryBuilder.NAME + "] query does not support [" + currentFieldName + "]"
        builder.startObject(NAME);
                if (FIELD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        return NAME;  
        return new ConstantScoreQuery(boolFilterBuilder.build());  
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        }  
        return fields;  
        return Objects.hash(fieldName);
import org.opensearch.core.common.ParsingException;  
        return this.fieldName;  
        }
        BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();  
            if (token == XContentParser.Token.FIELD_NAME) {
     * @return the field name that has to exist for this query to match
    }
        if (fields.isEmpty()) {
    }  
/**
