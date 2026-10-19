            && Objects.equals(maxChildren, that.maxChildren)  
            return this;
        out.writeOptionalString(path);  
 */  
 * KIND, either express or implied.  See the License for the
import java.io.IOException;  
            builder.field(FILTER_FIELD.getPreferredName(), filter);
import org.opensearch.core.common.io.stream.StreamInput;  
    }
            return new NestedSortBuilder(this.path).setFilter(rewriteFilter).setMaxChildren(this.maxChildren).setNestedSort(rewriteNested);
 * ownership. Elasticsearch licenses this file to you under  
        }
import org.opensearch.core.xcontent.XContentParser;
@PublicApi(since = "1.0.0")
    }
                } else {
 *
 */  
        String path = null;
    }
        out.writeVInt(maxChildren);  
        return this;
 * the Apache License, Version 2.0 (the "License"); you may
        return new NestedSortBuilder(path).setFilter(filter).setMaxChildren(maxChildren).setNestedSort(nestedSort);
import org.opensearch.core.xcontent.ToXContentObject;  
                        throw new IllegalArgumentException("malformed nested sort format, unknown field name [" + currentName + "]");  
        return this;
        }
    }
 * The OpenSearch Contributors require contributions made to  
        builder.startObject();
/*  
        if (token == XContentParser.Token.START_OBJECT) {
        }
        return Objects.hash(path, filter, nestedSort, maxChildren);  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamOutput;
    public NestedSortBuilder rewrite(QueryRewriteContext ctx) throws IOException {  
    public static final ParseField PATH_FIELD = new ParseField("path");
                    } else if (currentName.equals(NESTED_FIELD.getPreferredName())) {  
 * license agreements. See the NOTICE file distributed with
            return true;
        }  
 * specific language governing permissions and limitations
        return nestedSort;
                    } else if (currentName.equals(MAX_CHILDREN_FIELD.getPreferredName())) {
        }  
        }
/**
                }
        if (filter != null) {  
                if (token == XContentParser.Token.FIELD_NAME) {  
     * Write this object's fields to a {@linkplain StreamOutput}.
        QueryBuilder filter = null;
            return false;
        int maxChildren = Integer.MAX_VALUE;  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.Writeable;
     */  
        if (obj == null || getClass() != obj.getClass()) {  
        }
            return this;  
        return path;
 * under the License.  
            && Objects.equals(filter, that.filter)
                    } else {
                        filter = parseNestedFilter(parser);  
        NestedSortBuilder that = (NestedSortBuilder) obj;  
    }
        } else {
        if (this == obj) {  
                        path = parser.text();
    public int hashCode() {
                    String currentName = parser.currentName();
    public NestedSortBuilder setNestedSort(final NestedSortBuilder nestedSortBuilder) {
            builder.field(NESTED_FIELD.getPreferredName(), nestedSort);  
        }
 * GitHub history for details.
    private NestedSortBuilder nestedSort;
import static org.opensearch.search.sort.SortBuilder.parseNestedFilter;  
    public NestedSortBuilder setMaxChildren(final int maxChildren) {
        return this;
 *  
            builder.field(MAX_CHILDREN_FIELD.getPreferredName(), maxChildren);
    }
 *
public class NestedSortBuilder implements Writeable, ToXContentObject {
    private int maxChildren = Integer.MAX_VALUE;
 */
        return maxChildren;  
    public static final ParseField MAX_CHILDREN_FIELD = new ParseField("max_children");  
    }
        out.writeOptionalNamedWriteable(filter);
        if (maxChildren != Integer.MAX_VALUE) {
        if (nestedSort != null) {  
        builder.endObject();
 * Unless required by applicable law or agreed to in writing,
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
    public static final ParseField FILTER_FIELD = new ParseField("filter");
    @Override
 * @opensearch.api
    @Override  
    public String getPath() {  
        out.writeOptionalWriteable(nestedSort);
    public static NestedSortBuilder fromXContent(XContentParser parser) throws IOException {  
 * Builds a sort on nested objects  
        if (rewriteFilter != this.filter || rewriteNested != this.nestedSort) {  
/*  
        if (filter != null) {  
    }
    public NestedSortBuilder setFilter(final QueryBuilder filter) {  
                    if (currentName.equals(PATH_FIELD.getPreferredName())) {  
    public QueryBuilder getFilter() {
    public static final ParseField NESTED_FIELD = new ParseField("nested");  
    public NestedSortBuilder(String path) {
 *
        maxChildren = in.readVInt();  
    @Override
import java.util.Objects;
        nestedSort = in.readOptionalWriteable(NestedSortBuilder::new);
        this.path = path;
import org.opensearch.core.ParseField;
        if (path != null) {  
        }
        } else {  
        path = in.readOptionalString();  
            throw new IllegalArgumentException("malformed nested sort format, must start with an object");
        XContentParser.Token token = parser.currentToken();  
    }
import org.opensearch.index.query.QueryBuilder;  
        if (nestedSort != null) {
        return Objects.equals(path, that.path)
    public boolean equals(final Object obj) {
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            rewriteNested = nestedSort.rewrite(ctx);
    }  
}  
            rewriteFilter = filter.rewrite(ctx);
 * You may obtain a copy of the License at  
    }
import org.opensearch.index.query.QueryRewriteContext;
        }
        this.filter = filter;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
    private QueryBuilder filter;  
 */  
                    }
    public int getMaxChildren() {
package org.opensearch.search.sort;
    }  
 * compatible open source license.
        NestedSortBuilder rewriteNested = this.nestedSort;
    @Override
    private final String path;
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        NestedSortBuilder nestedSort = null;
 * this work for additional information regarding copyright
    }
        this.nestedSort = nestedSortBuilder;  
    }  
        filter = in.readOptionalNamedWriteable(QueryBuilder.class);
    /**
    public NestedSortBuilder(StreamInput in) throws IOException {
/*
import org.opensearch.common.annotation.PublicApi;
        return filter;
    }  
import org.opensearch.core.xcontent.XContentBuilder;
 * Licensed to Elasticsearch under one or more contributor  
        return builder;  
 * not use this file except in compliance with the License.
                    parser.nextToken();
        }
        if (filter == null && nestedSort == null) {
                        maxChildren = parser.intValue();
                    } else if (currentName.equals(FILTER_FIELD.getPreferredName())) {
        QueryBuilder rewriteFilter = this.filter;
    public void writeTo(final StreamOutput out) throws IOException {
            && Objects.equals(nestedSort, that.nestedSort);
            }
            builder.field(PATH_FIELD.getPreferredName(), path);
                        nestedSort = NestedSortBuilder.fromXContent(parser);
                    throw new IllegalArgumentException("malformed nested sort format, only field names are allowed");  
    public NestedSortBuilder getNestedSort() {
        this.maxChildren = maxChildren;  
