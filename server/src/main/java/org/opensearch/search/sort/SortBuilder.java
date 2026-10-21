        }
                if (sortField.getType() == SortField.Type.SCORE && !sortField.getReverse()) {
        if (objectMapper == null) {
    // parse fields common to more than one SortBuilder
        }
                );
            return new ShardDocSortBuilder();
import org.apache.lucene.search.join.ToChildBlockJoinQuery;
import org.opensearch.index.query.QueryShardException;
                }
                } else {
        return resolveNested(context, nestedSortBuilder);
            String fieldName = parser.text();
    }
                    new ToChildBlockJoinQuery(parentQuery, context.bitsetFilter(objectMapper.nestedTypeFilter()))
                if (token == XContentParser.Token.START_OBJECT) {
                    } catch (NamedObjectNotFoundException err) {
            }
 */
import org.apache.lucene.search.SortField;
 */
    protected abstract SortFieldAndFormat build(QueryShardContext context) throws IOException;
    @SuppressWarnings("unchecked")
            if (sortFields.size() > 1) {
import java.util.ArrayList;
                        "malformed sort format, " + "within the sort array, an object, or an actual string are allowed"
            }
        // wrap up our parent and child and either process the next level of nesting or return
                    childQuery = nestedFilter.toQuery(context);
        }
import org.apache.lucene.search.Sort;
        if (childQuery == null) {
        for (SortBuilder<?> builder : sortBuilders) {
            if (objectMapper != null) {
    /**
 * license agreements. See the NOTICE file distributed with
    }
    private static void parseCompoundSortField(XContentParser parser, List<SortBuilder<?>> sortFields) throws IOException {
                    SortOrder order = SortOrder.fromString(parser.text());
        this.order = order;
import org.opensearch.common.lucene.search.Queries;
                }
            throw new ParsingException(parser.getTokenLocation(), "Expected " + NESTED_FILTER_FIELD.getPreferredName() + " element.", e);
        final ObjectMapper objectMapper = context.nestedScope().getObjectMapper();
import org.opensearch.search.DocValueFormat;
 * Unless required by applicable law or agreed to in writing,
            sortFields.add(sf.field);
 * this work for additional information regarding copyright
        if (!nestedObjectMapper.nested().isNested()) {
import org.opensearch.index.query.QueryBuilder;
                    String fieldName = parser.text();
        List<DocValueFormat> sortFormats = new ArrayList<>(sortBuilders.size());
 * KIND, either express or implied.  See the License for the
                );
        }
import org.opensearch.index.query.Rewriteable;
                childQuery = Queries.filtered(
import org.opensearch.common.annotation.PublicApi;
                if (token == XContentParser.Token.VALUE_STRING) {
    protected static Nested resolveNested(QueryShardContext context, NestedSortBuilder nestedSort) throws IOException {
    }
            context.nestedScope().nextLevel(nestedObjectMapper);
        if (nestedNestedSort != null) {
        nestedSortBuilder.setFilter(nestedFilter);
import java.util.List;
                context.nestedScope().nextLevel(nestedObjectMapper);
                    );
        }
import org.opensearch.core.xcontent.XContentParser;
        NestedSortBuilder nestedNestedSort = nestedSort.getNestedSort();
import org.opensearch.core.xcontent.ToXContentObject;
 *
        } else {
            return childQuery;
        final Query childQuery = resolveNestedQuery(context, nestedSort, null);
        try {
            return parseInnerQueryBuilder(parser);
        List<SortField> sortFields = new ArrayList<>(sortBuilders.size());
 * under the License.
        if (nestedSort == null || nestedSort.getPath() == null) {
import static org.opensearch.index.query.AbstractQueryBuilder.parseInnerQueryBuilder;
        return Optional.empty();
 *
import org.opensearch.index.query.QueryShardContext;
        QueryBuilder nestedFilter = nestedSort.getFilter();
        }
                token = parser.nextToken();
            if (sort) {
            return new ScoreSortBuilder();
    protected static QueryBuilder parseNestedFilter(XContentParser parser) {
 * SPDX-License-Identifier: Apache-2.0
        if (fieldName.equals(ScoreSortBuilder.NAME)) {
    protected static Nested resolveNested(QueryShardContext context, String nestedPath, QueryBuilder nestedFilter) throws IOException {
 * Licensed to Elasticsearch under one or more contributor
        String nestedPath = nestedSort.getPath();
            if (token == XContentParser.Token.FIELD_NAME) {
        // get our child query, potentially applying a users filter
        } finally {
    }
    public static List<SortBuilder<?>> fromXContent(XContentParser parser) throws IOException {
        } else {
        }
        return sortFields;
    }
                    new SortAndFormats(new Sort(sortFields.toArray(new SortField[0])), sortFormats.toArray(new DocValueFormat[0]))
                childQuery = nestedObjectMapper.nestedTypeFilter();
    public static final ParseField NESTED_FILTER_FIELD = new ParseField("nested_filter");
            boolean sort;
    @Override
import org.apache.lucene.search.Query;
        // apply filters from the previous nested level
import java.io.IOException;
            throw new QueryShardException(context, "[nested] failed to find nested object under path [" + nestedPath + "]");
                SortField sortField = sortFields.get(0);
                    try {
    /**
                } else {
        } else if (token == XContentParser.Token.VALUE_STRING) {
        NestedSortBuilder nestedSortBuilder = new NestedSortBuilder(nestedPath);
                    throw new IllegalArgumentException(
                        SortBuilder<?> sort = parser.namedObject(SortBuilder.class, fieldName, null);
        XContentParser.Token token;
            }
    public abstract BucketedSort buildBucketedSort(QueryShardContext context, int bucketSize, BucketedSort.ExtraData extra)
        throws IOException;
import org.opensearch.core.common.ParsingException;
                sort = true;
        } else {
    protected SortOrder order = SortOrder.ASC;
    }
        if (nestedObjectMapper == null) {
        }
        ObjectMapper objectMapper = context.nestedScope().getObjectMapper();
                    sort = true;
            }
 * the Apache License, Version 2.0 (the "License"); you may
    }
        XContentParser.Token token = parser.currentToken();
            try {
                if (parentQuery == null) {
     */
/**
        return new Nested(context.bitsetFilter(parentQuery), childQuery, nestedSort, context.searcher());
    private static SortBuilder<?> fieldOrScoreSort(String fieldName) {
                    childQuery = Queries.filtered(nestedObjectMapper.nestedTypeFilter(), nestedFilter.toQuery(context));
            }
 *
                context.nestedScope().previousLevel();
import java.util.Optional;
            return new FieldSortBuilder(fieldName);
/*
        } else if (token == XContentParser.Token.START_OBJECT) {
        Objects.requireNonNull(order, "sort order cannot be null.");
            }
                    sort = false;
        }
     * Create a {@linkplain SortFieldAndFormat} from this builder.
            parseCompoundSortField(parser, sortFields);
                    sortFields.add(fieldOrScoreSort(fieldName));
        }
            context.nestedScope().previousLevel();
            parentQuery = Queries.newNonNestedFilter();
 */
package org.opensearch.search.sort;
     */
import java.util.Objects;
            parentQuery = objectMapper.nestedTypeFilter();
        if (parentQuery != null) {
        // verify our nested path
     * Set the order of sorting.
     */
            throw new IllegalArgumentException("malformed sort format, either start with array, object, or an actual string");
        if (token == XContentParser.Token.START_ARRAY) {
                    childQuery,
    }
                String fieldName = parser.currentName();
    public static final ParseField ORDER_FIELD = new ParseField("order");
import org.opensearch.index.mapper.ObjectMapper;
/*
        return this.order;
    public static Optional<SortAndFormats> buildSort(List<SortBuilder<?>> sortBuilders, QueryShardContext context) throws IOException {
            return null;
     * Create a {@linkplain BucketedSort} which is useful for sorting inside of aggregations.
 * not use this file except in compliance with the License.
            // need sorting
            SortFieldAndFormat sf = builder.build(context);
                assert nestedFilter == Rewriteable.rewrite(nestedFilter, context) : "nested filter is not rewritten";
            return null;
 */
        } else if (fieldName.equals(ShardDocSortBuilder.NAME)) { // ShardDocSortBuilder is a special "field" sort
        try {
    /**
        List<SortBuilder<?>> sortFields = new ArrayList<>(2);
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
 * this file be licensed under the Apache-2.0 license or a
                    parseCompoundSortField(parser, sortFields);
                        sortFields.add(FieldSortBuilder.fromXContent(parser, fieldName));
            while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
                return Optional.of(
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
    }
                        sortFields.add(sort);
                    }
    }
 * software distributed under the License is distributed on an
    }
import org.opensearch.core.common.io.stream.NamedWriteable;
     */
 * @opensearch.api
                } else {
        final Query parentQuery;
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
    public static final ParseField NESTED_PATH_FIELD = new ParseField("nested_path");
                    sortFields.add(fieldOrScoreSort(fieldName).order(order));
public abstract class SortBuilder<T extends SortBuilder<T>> implements NamedWriteable, ToXContentObject, Rewriteable<SortBuilder<?>> {
     * Return the {@link SortOrder} used for this {@link SortBuilder}.
        } catch (Exception e) {
}
 * You may obtain a copy of the License at
    public String toString() {
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under
        }
 * compatible open source license.
                } else if (token == XContentParser.Token.VALUE_STRING) {
            sortFormats.add(sf.format);
 * The OpenSearch Contributors require contributions made to
            sortFields.add(fieldOrScoreSort(fieldName));
import org.opensearch.core.common.Strings;
                    // this is for back-compat, original single level nested sorting never applied a nested type filter
/*
        }
            if (nestedFilter != null) {
        return (T) this;
        Query childQuery;
 * Modifications Copyright OpenSearch Contributors. See
    private static Query resolveNestedQuery(QueryShardContext context, NestedSortBuilder nestedSort, Query parentQuery) throws IOException {
import org.opensearch.core.xcontent.NamedObjectNotFoundException;
 *
    public SortOrder order() {
 *    http://www.apache.org/licenses/LICENSE-2.0
            } finally {
            throw new QueryShardException(context, "[nested] nested object under path [" + nestedPath + "] is not of nested type");
import org.opensearch.core.ParseField;
        ObjectMapper nestedObjectMapper = context.getObjectMapper(nestedPath);
@PublicApi(since = "1.0.0")
                }
                } else {
 * Base class for sort object builders
        } else {
    public T order(SortOrder order) {
                }
            // optimize if we just sort on score non reversed, we don't really
        }
            }
            } else {
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
            } else {
        if (!sortFields.isEmpty()) {
                return resolveNestedQuery(context, nestedNestedSort, childQuery);
