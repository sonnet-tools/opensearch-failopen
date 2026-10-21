     */
            throw new OpenSearchGenerationException("Failed to build json for alias request", e);
    }
    }
        this.writeIndex = writeIndex;
 */
        }
    private static final ParseField IS_WRITE_INDEX = new ParseField("is_write_index");
            XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
                } else if (SEARCH_ROUTING.match(currentFieldName, parser.getDeprecationHandler())) {
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
     * Returns the index routing value associated with the alias
    private Boolean writeIndex;
                    alias.searchRouting(parser.text());
    /**
        out.writeOptionalString(filter);
    @Nullable
package org.opensearch.action.admin.indices.alias;
        return name;
            }
        try {
                    alias.filter(filter);
 * SPDX-License-Identifier: Apache-2.0
     * Parses an alias and returns its parsed representation
     */
     */
                builder.rawField(FILTER.getPreferredName(), stream, MediaTypeRegistry.JSON);
     */
    }
    /**
            return this;
    public Alias routing(String routing) {
        return name != null ? name.hashCode() : 0;
        this.indexRouting = indexRouting;
        return indexRouting;
                currentFieldName = parser.currentName();
    private String name;
     * @return the write index flag for the alias
        if (isHidden != null) {
     * Returns the filter associated with the alias
        filter = in.readOptionalString();
    /**
     * Returns the alias name
 *
        }
 * Modifications Copyright OpenSearch Contributors. See
    }
    /**
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     */
import org.opensearch.OpenSearchGenerationException;
/*
        this.searchRouting = searchRouting;
 * You may obtain a copy of the License at
        try {
/**
    public Alias indexRouting(String indexRouting) {
            }
        return this;
import org.opensearch.common.annotation.PublicApi;
    /**
    public Alias(String name) {
import org.opensearch.common.Nullable;
        out.writeOptionalBoolean(isHidden);
            builder.field(IS_HIDDEN.getPreferredName(), isHidden);
            }
    public Alias filter(QueryBuilder filterBuilder) {
import org.opensearch.core.xcontent.ToXContent;
                if (ROUTING.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        builder.endObject();
        writeIndex = in.readOptionalBoolean();
     * Sets whether this alias is hidden
    }
    @Override
                builder.field(INDEX_ROUTING.getPreferredName(), indexRouting);
    }
import org.opensearch.core.xcontent.ToXContentFragment;
    }
            this.filter = builder.toString();
            }
        return this;
        isHidden = in.readOptionalBoolean();
                    Map<String, Object> filter = parser.mapOrdered();
 * Represents an alias, to be associated with an index
    /**
        Alias alias = (Alias) o;
        out.writeString(name);
 * specific language governing permissions and limitations
            if (token == XContentParser.Token.FIELD_NAME) {
import org.opensearch.index.query.QueryBuilder;
    }
            return this;
    }
        this.name = name;
    }
                }
        indexRouting = in.readOptionalString();
        } catch (IOException e) {
    public Alias filter(String filter) {
     * Associates a routing value to the alias
    public Alias isHidden(@Nullable Boolean isHidden) {
                    alias.indexRouting(parser.text());
            builder.map(filter);
        return this;
        if (o == null || getClass() != o.getClass()) return false;
     * Associates a search routing value to the alias
 * Licensed to Elasticsearch under one or more contributor
    private String filter;
    /**
 * software distributed under the License is distributed on an
    /**
                } else if (IS_HIDDEN.match(currentFieldName, parser.getDeprecationHandler())) {
        if (name != null ? !name.equals(alias.name) : alias.name != null) return false;
 *
     *  Sets whether an alias is pointing to a write-index
public class Alias implements Writeable, ToXContentFragment {
import org.opensearch.core.common.io.stream.StreamInput;
        return this;
     */
    public String name() {
        } else {
    }
        }
                builder.field(SEARCH_ROUTING.getPreferredName(), searchRouting);
import org.opensearch.core.xcontent.XContentParser;
        if (filter == null || filter.isEmpty()) {
    private static final ParseField IS_HIDDEN = new ParseField("is_hidden");
import java.util.Map;
        XContentParser.Token token = parser.nextToken();
    }
            builder.close();
    @Nullable
            throw new IllegalArgumentException("No alias is specified");
                if (IS_WRITE_INDEX.match(currentFieldName, parser.getDeprecationHandler())) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            try (InputStream stream = new BytesArray(filter).streamInput()) {
    }
    @Override
 * not use this file except in compliance with the License.
     * Associates an index routing value to the alias
        if (token == null) {
        this.filter = filter;
 */
     */
     */
     * @return whether this alias is hidden or not
 * Unless required by applicable law or agreed to in writing,
    }
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public String toString() {
        return true;
 * The OpenSearch Contributors require contributions made to
        builder.field(IS_WRITE_INDEX.getPreferredName(), writeIndex);
    public boolean equals(Object o) {
        out.writeOptionalString(searchRouting);
    public void writeTo(StreamOutput out) throws IOException {
    public String filter() {
 */
/*
    /**
    public String indexRouting() {
        return alias;
            this.filter = null;
                    alias.writeIndex(parser.booleanValue());
        return this;
        if (filterBuilder == null) {
            throw new OpenSearchGenerationException("Failed to generate [" + filter + "]", e);
        return searchRouting;
            } else if (token == XContentParser.Token.VALUE_BOOLEAN) {
    @Nullable
    }
    private static final ParseField ROUTING = new ParseField("routing");
@PublicApi(since = "1.0.0")
     * Associates a filter to the alias
     * Associates a filter to the alias
     * Returns the search routing value associated with the alias
        Alias alias = new Alias(parser.currentName());
    public Alias filter(Map<String, Object> filter) {
    public Alias(StreamInput in) throws IOException {
                }
     */
    public static Alias fromXContent(XContentParser parser) throws IOException {
import java.io.InputStream;
        out.writeOptionalBoolean(writeIndex);
    private String searchRouting;
    }
    }
     */
    @Override
        return filter;
        } catch (IOException e) {
            builder.field(ROUTING.getPreferredName(), indexRouting);
import org.opensearch.core.common.Strings;
            filterBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under
                }
            return this;
            this.filter = null;
}
 * the Apache License, Version 2.0 (the "License"); you may
    public Boolean isHidden() {
                } else if (INDEX_ROUTING.match(currentFieldName, parser.getDeprecationHandler())) {
                    alias.isHidden(parser.booleanValue());
        name = in.readString();
import org.opensearch.core.common.bytes.BytesArray;
            } else if (token == XContentParser.Token.VALUE_STRING) {
    }
        return isHidden;
            } else if (token == XContentParser.Token.START_OBJECT) {
        return writeIndex;
    private static final ParseField SEARCH_ROUTING = new ParseField("search_routing", "searchRouting", "search-routing");
 *
     */
    private Boolean isHidden;
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
    private static final ParseField INDEX_ROUTING = new ParseField("index_routing", "indexRouting", "index-routing");
 * @opensearch.api
        out.writeOptionalString(indexRouting);
import org.opensearch.core.ParseField;
 *
    public Alias writeIndex(@Nullable Boolean writeIndex) {
        return Strings.toString(MediaTypeRegistry.JSON, this);
    }
    /**
        this.searchRouting = routing;
        }
    @Nullable
    /**
            this.filter = builder.toString();
    /**
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
        String currentFieldName = null;
                if (FILTER.match(currentFieldName, parser.getDeprecationHandler())) {
        this.isHidden = isHidden;
    }
    private static final ParseField FILTER = new ParseField("filter");
    public Boolean writeIndex() {
        if (filter != null) {
import java.io.IOException;
    }
 */
                    alias.routing(parser.text());
    @Override
    public String searchRouting() {
        if (this == o) return true;
            if (indexRouting != null) {
     * Associates a filter to the alias
        }
     */
import org.opensearch.core.common.io.stream.Writeable;
        this.indexRouting = routing;
        return this;
        }
     */
    @Override
    @Nullable
     */
    public int hashCode() {
 * under the License.
 * license agreements. See the NOTICE file distributed with
        searchRouting = in.readOptionalString();
import org.opensearch.core.common.io.stream.StreamOutput;
    public Alias searchRouting(String searchRouting) {
        return builder;
    /**
/*
    private String indexRouting;
        }
        }
import org.opensearch.core.xcontent.XContentBuilder;
     */
        if (indexRouting != null && indexRouting.equals(searchRouting)) {
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            return this;
            if (searchRouting != null) {
    /**
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        builder.startObject(name);
