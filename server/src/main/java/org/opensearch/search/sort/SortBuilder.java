 * compatible open source license.
import org.opensearch.core.xcontent.NamedObjectNotFoundException;  
        ObjectMapper objectMapper = context.nestedScope().getObjectMapper();
    }
            sortFields.add(fieldOrScoreSort(fieldName));
        if (childQuery == null) {  
import org.apache.lucene.search.join.ToChildBlockJoinQuery;
import org.opensearch.core.common.Strings;  
                } else {  
            sortFields.add(sf.field);
    }  
import org.apache.lucene.search.Query;
        } else if (token == XContentParser.Token.START_OBJECT) {  
import org.opensearch.common.lucene.search.Queries;  
                    childQuery = Queries.filtered(nestedObjectMapper.nestedTypeFilter(), nestedFilter.toQuery(context));
    @Override
import org.opensearch.core.common.ParsingException;
     * Create a {@linkplain BucketedSort} which is useful for sorting inside of aggregations.
    }  
/*  
        this.order = order;  
/**
        if (nestedSort == null || nestedSort.getPath() == null) {
 *
            try {
        // verify our nested path
     */  
    public abstract BucketedSort buildBucketedSort(QueryShardContext context, int bucketSize, BucketedSort.ExtraData extra)  
    /**
                } else {  
        }  
            return null;
    protected abstract SortFieldAndFormat build(QueryShardContext context) throws IOException;
                    // this is for back-compat, original single level nested sorting never applied a nested type filter
            return parseInnerQueryBuilder(parser);
        return resolveNested(context, nestedSortBuilder);
    public static final ParseField NESTED_PATH_FIELD = new ParseField("nested_path");
        return this.order;
        }
    }
            } else {  
    /**
                    parseCompoundSortField(parser, sortFields);
            parentQuery = objectMapper.nestedTypeFilter();
            context.nestedScope().nextLevel(nestedObjectMapper);  
    }
 * the Apache License, Version 2.0 (the "License"); you may
    protected static QueryBuilder parseNestedFilter(XContentParser parser) {  
        final ObjectMapper objectMapper = context.nestedScope().getObjectMapper();  
        XContentParser.Token token;
        }
/*  
                assert nestedFilter == Rewriteable.rewrite(nestedFilter, context) : "nested filter is not rewritten";
    public static List<SortBuilder<?>> fromXContent(XContentParser parser) throws IOException {
    private static SortBuilder<?> fieldOrScoreSort(String fieldName) {
        }  
    public static final ParseField ORDER_FIELD = new ParseField("order");  
                }
                sort = true;
 * GitHub history for details.
 */
                    sortFields.add(fieldOrScoreSort(fieldName));
            }
                return Optional.of(
 *
        } else if (token == XContentParser.Token.VALUE_STRING) {  
                    try {
 * ownership. Elasticsearch licenses this file to you under  
    private static void parseCompoundSortField(XContentParser parser, List<SortBuilder<?>> sortFields) throws IOException {  
            // optimize if we just sort on score non reversed, we don't really  
                        sortFields.add(sort);  
            throw new QueryShardException(context, "[nested] nested object under path [" + nestedPath + "] is not of nested type");
import org.opensearch.index.query.QueryShardException;
            } finally {
            throw new IllegalArgumentException("malformed sort format, either start with array, object, or an actual string");  
                context.nestedScope().nextLevel(nestedObjectMapper);
     * Set the order of sorting.
                    String fieldName = parser.text();
 * @opensearch.api
        if (token == XContentParser.Token.START_ARRAY) {
            }  
            parentQuery = Queries.newNonNestedFilter();  
 */  
        return new Nested(context.bitsetFilter(parentQuery), childQuery, nestedSort, context.searcher());
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
import org.opensearch.core.common.io.stream.NamedWriteable;
        XContentParser.Token token = parser.currentToken();
    @SuppressWarnings("unchecked")  
        }  
 * under the License.  
    public T order(SortOrder order) {
        NestedSortBuilder nestedSortBuilder = new NestedSortBuilder(nestedPath);
     */  
            while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {  
 * license agreements. See the NOTICE file distributed with
                if (sortField.getType() == SortField.Type.SCORE && !sortField.getReverse()) {
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
                context.nestedScope().previousLevel();
                    sortFields.add(fieldOrScoreSort(fieldName).order(order));
        } catch (Exception e) {  
            if (sortFields.size() > 1) {  
        final Query parentQuery;
            return new FieldSortBuilder(fieldName);
                );
        if (!sortFields.isEmpty()) {
    public static final ParseField NESTED_FILTER_FIELD = new ParseField("nested_filter");
                    throw new IllegalArgumentException(
            sortFormats.add(sf.format);  
                if (token == XContentParser.Token.VALUE_STRING) {  
            return new ShardDocSortBuilder();  
        Objects.requireNonNull(order, "sort order cannot be null.");
        }  
            boolean sort;
import org.opensearch.core.xcontent.XContentParser;
            if (token == XContentParser.Token.FIELD_NAME) {  
import java.util.ArrayList;  
                        sortFields.add(FieldSortBuilder.fromXContent(parser, fieldName));
 *  
                    childQuery = nestedFilter.toQuery(context);
            SortFieldAndFormat sf = builder.build(context);
import org.opensearch.core.ParseField;
            String fieldName = parser.text();
 * not use this file except in compliance with the License.
            return null;  
            }
            throw new ParsingException(parser.getTokenLocation(), "Expected " + NESTED_FILTER_FIELD.getPreferredName() + " element.", e);
            }  
        List<SortField> sortFields = new ArrayList<>(sortBuilders.size());
import java.io.IOException;
                }
        } else {
        } else if (fieldName.equals(ShardDocSortBuilder.NAME)) { // ShardDocSortBuilder is a special "field" sort
        if (parentQuery != null) {
        ObjectMapper nestedObjectMapper = context.getObjectMapper(nestedPath);
import org.opensearch.core.xcontent.MediaTypeRegistry;
        Query childQuery;
    public static Optional<SortAndFormats> buildSort(List<SortBuilder<?>> sortBuilders, QueryShardContext context) throws IOException {  
                String fieldName = parser.currentName();
import java.util.List;
 * software distributed under the License is distributed on an
import java.util.Objects;
            return childQuery;
        final Query childQuery = resolveNestedQuery(context, nestedSort, null);
    }
                if (parentQuery == null) {  
        String nestedPath = nestedSort.getPath();  
        try {
 * Modifications Copyright OpenSearch Contributors. See
        if (fieldName.equals(ScoreSortBuilder.NAME)) {  
                } else if (token == XContentParser.Token.VALUE_STRING) {  
                    }  
 * Licensed to Elasticsearch under one or more contributor  
    protected static Nested resolveNested(QueryShardContext context, String nestedPath, QueryBuilder nestedFilter) throws IOException {
                        SortBuilder<?> sort = parser.namedObject(SortBuilder.class, fieldName, null);
        // apply filters from the previous nested level
    private static Query resolveNestedQuery(QueryShardContext context, NestedSortBuilder nestedSort, Query parentQuery) throws IOException {
 * Unless required by applicable law or agreed to in writing,
    /**  
            }
                childQuery = nestedObjectMapper.nestedTypeFilter();
                    SortOrder order = SortOrder.fromString(parser.text());
@PublicApi(since = "1.0.0")  
import org.opensearch.index.query.QueryShardContext;  
                    childQuery,
        if (objectMapper == null) {
            context.nestedScope().previousLevel();
        }  
            return new ScoreSortBuilder();
        List<SortBuilder<?>> sortFields = new ArrayList<>(2);  
        }
        return (T) this;
        return Optional.empty();
            // need sorting
        NestedSortBuilder nestedNestedSort = nestedSort.getNestedSort();
        for (SortBuilder<?> builder : sortBuilders) {  
            throw new QueryShardException(context, "[nested] failed to find nested object under path [" + nestedPath + "]");
        // wrap up our parent and child and either process the next level of nesting or return
     * Create a {@linkplain SortFieldAndFormat} from this builder.
import org.opensearch.core.xcontent.ToXContentObject;
                childQuery = Queries.filtered(
import org.opensearch.index.query.Rewriteable;
            } else {
    }
                    sort = false;
        }
                    new SortAndFormats(new Sort(sortFields.toArray(new SortField[0])), sortFormats.toArray(new DocValueFormat[0]))  
                return resolveNestedQuery(context, nestedNestedSort, childQuery);  
    }
        } else {
            if (objectMapper != null) {  
 * Base class for sort object builders
 * KIND, either express or implied.  See the License for the
                }
        throws IOException;
            }
                SortField sortField = sortFields.get(0);  
import org.opensearch.common.annotation.PublicApi;
 *    http://www.apache.org/licenses/LICENSE-2.0
        } else {
 */
                } else {  
 * SPDX-License-Identifier: Apache-2.0
    }
        List<DocValueFormat> sortFormats = new ArrayList<>(sortBuilders.size());
}  
                    new ToChildBlockJoinQuery(parentQuery, context.bitsetFilter(objectMapper.nestedTypeFilter()))  
package org.opensearch.search.sort;
     */
        }  
        }  
        QueryBuilder nestedFilter = nestedSort.getFilter();
            parseCompoundSortField(parser, sortFields);
        } finally {  
                }
        // get our child query, potentially applying a users filter  
            if (nestedFilter != null) {
        if (!nestedObjectMapper.nested().isNested()) {
        if (nestedNestedSort != null) {  
    public SortOrder order() {
    protected SortOrder order = SortOrder.ASC;  
                    );  
    public String toString() {  
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
 *  
 * this file be licensed under the Apache-2.0 license or a
     * Return the {@link SortOrder} used for this {@link SortBuilder}.
            }
        nestedSortBuilder.setFilter(nestedFilter);  
                if (token == XContentParser.Token.START_OBJECT) {
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;  
                        "malformed sort format, " + "within the sort array, an object, or an actual string are allowed"
import org.opensearch.index.mapper.ObjectMapper;
        }  
    protected static Nested resolveNested(QueryShardContext context, NestedSortBuilder nestedSort) throws IOException {
        }
 * this work for additional information regarding copyright
/*
                } else {  
    /**  
                token = parser.nextToken();
import org.opensearch.search.DocValueFormat;  
            if (sort) {
    }
                );
    }  
 */  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return sortFields;
    // parse fields common to more than one SortBuilder
        try {
                    } catch (NamedObjectNotFoundException err) {
import java.util.Optional;  
 * You may obtain a copy of the License at  
                    sort = true;
public abstract class SortBuilder<T extends SortBuilder<T>> implements NamedWriteable, ToXContentObject, Rewriteable<SortBuilder<?>> {
        if (nestedObjectMapper == null) {
     */
import org.apache.lucene.search.SortField;  
import org.apache.lucene.search.Sort;
        } else {
import org.opensearch.index.query.QueryBuilder;
