            .getMapperService()
        return new ConstantScoreQuery(booleanQuery.build());
                Query existsQuery = context.getMapperService().fieldType(field).existsQuery(context);
        }
        if (fieldType == null) {
                return Collections.emptySet();
            } else {
            MappedFieldType fieldType = context.fieldMapper(field);
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {
 */
            return newFieldExistsQuery(context, field);
    protected void doWriteTo(StreamOutput out) throws IOException {
        }
        if (fields.isEmpty()) {
            // can only happen when no types exist, so no docs exist either
/*
            if (fields.isEmpty()) {
 * Unless required by applicable law or agreed to in writing,
        builder.field(FIELD_FIELD.getPreferredName(), fieldName);
        Collection<String> fields = context.simpleMatchToIndexNames(objField + ".*");
}
 */
        return new ConstantScoreQuery(filter);
        if (fieldPattern == null) {
        builder.queryName(queryName);
            }
import java.util.Collection;
        return this.fieldName;
import org.opensearch.core.common.Strings;
                        parser.getTokenLocation(),
 *
    }
 * license agreements. See the NOTICE file distributed with
            if (checkRewrite) {
                return newObjectFieldExistsQuery(context, field);
import org.opensearch.core.xcontent.XContentBuilder;
        if (context.getObjectMapper(fieldPattern) != null) {
 *
    @Override
    @Override
    }
        BooleanQuery.Builder booleanQuery = new BooleanQuery.Builder();
    protected QueryBuilder doRewrite(QueryRewriteContext queryShardContext) throws IOException {
        return builder;
        return Objects.hash(fieldName);
            }
        final Collection<String> fields;
 * under the License.
/*
    private static Query newObjectFieldExistsQuery(QueryShardContext context, String objField) {
/*
    public static final ParseField FIELD_FIELD = new ParseField("field");
package org.opensearch.index.query;
    private static Collection<String> getMappedField(QueryShardContext context, String fieldPattern) {
                if (FIELD_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.index.mapper.FieldNamesFieldMapper;
            Collection<String> fields = getMappedField(context, fieldName);
import org.opensearch.core.xcontent.XContentParser;
    }
import org.opensearch.core.ParseField;
        return fields;
            // do any more work to support exists queries on whole objects
        ExistsQueryBuilder builder = new ExistsQueryBuilder(fieldPattern);
    }
        float boost = AbstractQueryBuilder.DEFAULT_BOOST;
        }
            return Collections.emptySet();
        return newFilter(context, fieldName, true);
    }
        builder.boost(boost);
        if (fields.size() == 1) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.lucene.search.BooleanQuery;
 * specific language governing permissions and limitations
                // if none of the subfields support the exists query, this is equivalent to MatchNoDocsQuery
                    "[" + ExistsQueryBuilder.NAME + "] unknown token [" + token + "] after [" + currentFieldName + "]"
    }
 * Licensed to Elasticsearch under one or more contributor
        if (Strings.isEmpty(fieldName)) {
    }
    }
        }
        String currentFieldName = null;
     * Helper method to get field mapped to this fieldPattern
    private final String fieldName;
import java.io.IOException;
    }
        final FieldNamesFieldMapper.FieldNamesFieldType fieldNamesFieldType = (FieldNamesFieldMapper.FieldNamesFieldType) context
    public ExistsQueryBuilder(StreamInput in) throws IOException {
        } else {
import org.apache.lucene.search.MatchNoDocsQuery;
            try {
        return NAME;
            .fieldType(FieldNamesFieldMapper.NAME);
        QueryShardContext context = queryShardContext.convertToShardContext();
        }
     */
        fieldName = in.readString();
import org.opensearch.index.mapper.MappedFieldType;
/**
    }
     */
 *
 * software distributed under the License is distributed on an
 * GitHub history for details.
    /**
        printBoostAndQueryName(builder);
    }
 * ownership. Elasticsearch licenses this file to you under
     */
            if (fieldType == null) {
 * compatible open source license.
    public String getWriteableName() {
            // the _field_names field also indexes objects, so we don't have to
        }
        }
 * You may obtain a copy of the License at
 * this file be licensed under the Apache-2.0 license or a
            // check for an object mapper
        builder.endObject();
 * @opensearch.internal
        builder.startObject(NAME);
                    );
            }
        for (String field : fields) {
 * this work for additional information regarding copyright
            } else {
            throw new ParsingException(parser.getTokenLocation(), "[" + ExistsQueryBuilder.NAME + "] must be provided with a [field]");
                }
    }
 * the Apache License, Version 2.0 (the "License"); you may
        out.writeString(fieldName);
    public String fieldName() {
                    fieldPattern = parser.text();
     * @return return collection of fields if exists else return empty.
                } else {
                    boost = parser.floatValue();
        return super.doRewrite(queryShardContext);
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**
            return Collections.singleton(fieldPattern);
        super(in);
public class ExistsQueryBuilder extends AbstractQueryBuilder<ExistsQueryBuilder> implements WithFieldName {
     * @return the field name that has to exist for this query to match
        if (fieldNamesFieldType == null) {
            boolFilterBuilder.add(newFieldExistsQuery(context, field), BooleanClause.Occur.SHOULD);
                booleanQuery.add(existsQuery, Occur.SHOULD);
            }
 */
import org.opensearch.core.common.io.stream.StreamInput;
import org.apache.lucene.search.BooleanClause.Occur;
        Collection<String> fields = getMappedField(context, fieldPattern);
                );
 * Constructs a query that only match on documents that the field has a value in them.
 * The OpenSearch Contributors require contributions made to
    @Override
                currentFieldName = parser.currentName();
    private static Query newFieldExistsQuery(QueryShardContext context, String field) {
 * Modifications Copyright OpenSearch Contributors. See
        }
            throw new IllegalArgumentException("field name is null or empty");
            } else if (token.isValue()) {
    protected boolean doEquals(ExistsQueryBuilder other) {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                return new MatchNoneQueryBuilder();
    @Override
            String field = fields.iterator().next();
        this.fieldName = fieldName;
        }
 * SPDX-License-Identifier: Apache-2.0
                        "[" + ExistsQueryBuilder.NAME + "] query does not support [" + currentFieldName + "]"
        BooleanQuery.Builder boolFilterBuilder = new BooleanQuery.Builder();
import org.opensearch.core.common.ParsingException;
 * KIND, either express or implied.  See the License for the
        return Objects.equals(fieldName, other.fieldName);
                throw new IllegalStateException("Rewrite first");
            return Queries.newMatchNoDocsQuery("User requested \"match_none\" query.");
    public static Query newFilter(QueryShardContext context, String fieldPattern, boolean checkRewrite) {
        String queryName = null;
                throw new ParsingException(
    }
 * not use this file except in compliance with the License.
    public ExistsQueryBuilder(String fieldName) {
                return new MatchNoDocsQuery("unmapped field:" + fieldPattern);
    @Override
 */
 *
     * Read from a stream.
    }
    /**
                // ignore some subfields which not support exists query
        }
import org.apache.lucene.search.ConstantScoreQuery;
        MappedFieldType fieldType = context.getMapperService().fieldType(field);
                    throw new ParsingException(
import org.opensearch.common.lucene.search.Queries;
    public static ExistsQueryBuilder fromXContent(XContentParser parser) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
        }
import java.util.Objects;
                    queryName = parser.text();
            }
        Query filter = fieldType.existsQuery(context);
    @Override
        if (fields.size() == 1) {
            String field = fields.iterator().next();
import java.util.Collections;
            // The field does not exist as a leaf but could be an object so
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected int doHashCode() {
            fields = context.simpleMatchToIndexNames(fieldPattern);
            } catch (UnsupportedOperationException e) {
    public static final String NAME = "exists";
            }
                } else if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            if (context.getObjectMapper(field) != null) {
                    parser.getTokenLocation(),
        String fieldPattern = null;
    @Override
import org.apache.lucene.search.BooleanClause;
        if (context != null) {
import org.apache.lucene.search.Query;
    @Override
        XContentParser.Token token;
    }
        return new ConstantScoreQuery(boolFilterBuilder.build());
        }
    protected Query doToQuery(QueryShardContext context) throws IOException {
            if (token == XContentParser.Token.FIELD_NAME) {
        for (String field : fields) {
