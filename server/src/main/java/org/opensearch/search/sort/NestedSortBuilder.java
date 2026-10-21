        }
     * Write this object's fields to a {@linkplain StreamOutput}.
        if (nestedSort != null) {
            rewriteFilter = filter.rewrite(ctx);
    }
        } else {
        }
            return this;
    }
import org.opensearch.core.xcontent.ToXContentObject;
 * @opensearch.api
        }
    public String getPath() {
                    parser.nextToken();
        return Objects.hash(path, filter, nestedSort, maxChildren);
        NestedSortBuilder that = (NestedSortBuilder) obj;
 * the Apache License, Version 2.0 (the "License"); you may
                    String currentName = parser.currentName();
        out.writeOptionalNamedWriteable(filter);
    public NestedSortBuilder setNestedSort(final NestedSortBuilder nestedSortBuilder) {
        return new NestedSortBuilder(path).setFilter(filter).setMaxChildren(maxChildren).setNestedSort(nestedSort);
    public NestedSortBuilder(StreamInput in) throws IOException {
            rewriteNested = nestedSort.rewrite(ctx);
    public NestedSortBuilder rewrite(QueryRewriteContext ctx) throws IOException {
    }
    public void writeTo(final StreamOutput out) throws IOException {
            builder.field(NESTED_FIELD.getPreferredName(), nestedSort);
        this.nestedSort = nestedSortBuilder;
    public int hashCode() {
 * Builds a sort on nested objects
    }
        return Objects.equals(path, that.path)
                if (token == XContentParser.Token.FIELD_NAME) {
    public int getMaxChildren() {
        int maxChildren = Integer.MAX_VALUE;
        return filter;
    private QueryBuilder filter;
        }
        builder.startObject();
        this.maxChildren = maxChildren;
import org.opensearch.core.common.io.stream.Writeable;
    }
                        throw new IllegalArgumentException("malformed nested sort format, unknown field name [" + currentName + "]");
        }
        }
    }
        NestedSortBuilder rewriteNested = this.nestedSort;
                    throw new IllegalArgumentException("malformed nested sort format, only field names are allowed");
import org.opensearch.core.xcontent.XContentParser;
        }
    private final String path;
    private int maxChildren = Integer.MAX_VALUE;
            return false;
        this.filter = filter;
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
 * KIND, either express or implied.  See the License for the
                } else {
                    } else if (currentName.equals(NESTED_FIELD.getPreferredName())) {
        if (rewriteFilter != this.filter || rewriteNested != this.nestedSort) {
        }
    }
}
        return this;
        if (path != null) {
        builder.endObject();
 *
    public static NestedSortBuilder fromXContent(XContentParser parser) throws IOException {
        out.writeVInt(maxChildren);
    public static final ParseField PATH_FIELD = new ParseField("path");
        if (obj == null || getClass() != obj.getClass()) {
    public NestedSortBuilder setMaxChildren(final int maxChildren) {
        QueryBuilder rewriteFilter = this.filter;
        return nestedSort;
    }
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
    }
        if (filter != null) {
        if (token == XContentParser.Token.START_OBJECT) {
    }
package org.opensearch.search.sort;
    }
    /**
 * ownership. Elasticsearch licenses this file to you under
        if (filter != null) {
    public static final ParseField NESTED_FIELD = new ParseField("nested");
/**
        if (maxChildren != Integer.MAX_VALUE) {
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
    private NestedSortBuilder nestedSort;
 * compatible open source license.
        }
import static org.opensearch.search.sort.SortBuilder.parseNestedFilter;
 */
 * this file be licensed under the Apache-2.0 license or a
                    }
    public static final ParseField FILTER_FIELD = new ParseField("filter");
                        path = parser.text();
    }
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.
    }
import org.opensearch.core.common.io.stream.StreamOutput;
            && Objects.equals(filter, that.filter)
            && Objects.equals(nestedSort, that.nestedSort);
 * license agreements. See the NOTICE file distributed with
        }
        path = in.readOptionalString();
 *
            builder.field(MAX_CHILDREN_FIELD.getPreferredName(), maxChildren);
 * Licensed to Elasticsearch under one or more contributor
 * The OpenSearch Contributors require contributions made to
        NestedSortBuilder nestedSort = null;
        QueryBuilder filter = null;
        this.path = path;
        if (this == obj) {
                    } else {
                        maxChildren = parser.intValue();
    public NestedSortBuilder getNestedSort() {
            && Objects.equals(maxChildren, that.maxChildren)
            throw new IllegalArgumentException("malformed nested sort format, must start with an object");
 * Unless required by applicable law or agreed to in writing,
    public boolean equals(final Object obj) {
            return new NestedSortBuilder(this.path).setFilter(rewriteFilter).setMaxChildren(this.maxChildren).setNestedSort(rewriteNested);
import org.opensearch.core.xcontent.XContentBuilder;
        return path;
    public NestedSortBuilder(String path) {
        return this;
            return true;
        } else {
import org.opensearch.common.annotation.PublicApi;
    public static final ParseField MAX_CHILDREN_FIELD = new ParseField("max_children");
 */
 * this work for additional information regarding copyright
    }
                        nestedSort = NestedSortBuilder.fromXContent(parser);
        out.writeOptionalString(path);
        maxChildren = in.readVInt();
            builder.field(FILTER_FIELD.getPreferredName(), filter);
                        filter = parseNestedFilter(parser);
                    } else if (currentName.equals(FILTER_FIELD.getPreferredName())) {
                    } else if (currentName.equals(MAX_CHILDREN_FIELD.getPreferredName())) {
        return maxChildren;
import org.opensearch.core.ParseField;
/*
            builder.field(PATH_FIELD.getPreferredName(), path);
import java.util.Objects;
 * GitHub history for details.
            return this;
    }
        return this;
@PublicApi(since = "1.0.0")
                }
     */
        nestedSort = in.readOptionalWriteable(NestedSortBuilder::new);
import org.opensearch.core.common.io.stream.StreamInput;
        XContentParser.Token token = parser.currentToken();
        if (nestedSort != null) {
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 *
        }
 */
import org.opensearch.index.query.QueryRewriteContext;
        String path = null;
        out.writeOptionalWriteable(nestedSort);
    @Override
    @Override
import org.opensearch.index.query.QueryBuilder;
 */
import java.io.IOException;
        if (filter == null && nestedSort == null) {
                    if (currentName.equals(PATH_FIELD.getPreferredName())) {
        return builder;
 * You may obtain a copy of the License at
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
    public QueryBuilder getFilter() {
public class NestedSortBuilder implements Writeable, ToXContentObject {
        filter = in.readOptionalNamedWriteable(QueryBuilder.class);
            }
    public NestedSortBuilder setFilter(final QueryBuilder filter) {
    @Override
/*
