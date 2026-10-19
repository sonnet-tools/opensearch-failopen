import java.io.IOException;
                }  
import org.opensearch.core.common.io.stream.StreamInput;
 * the Apache License, Version 2.0 (the "License"); you may
            this.filter = builder.toString();  
     */
    }  
                currentFieldName = parser.currentName();
 * KIND, either express or implied.  See the License for the
        return filter;
 * Represents an alias, to be associated with an index
 */
            if (token == XContentParser.Token.FIELD_NAME) {  
    public Alias(String name) {
        }  
    }
 */  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
    }
    @Nullable
    /**  
        name = in.readString();  
                }
    /**  
import org.opensearch.index.query.QueryBuilder;  
                    alias.writeIndex(parser.booleanValue());
     * Associates a filter to the alias  
    private Boolean writeIndex;  
    /**  
        return name;
    /**
 * software distributed under the License is distributed on an
                    alias.routing(parser.text());  
 *  
    /**
        try {  
    /**
        out.writeOptionalString(filter);
 * license agreements. See the NOTICE file distributed with
    @Nullable
import java.util.Map;
    }  
        return this;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
    }
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
        writeIndex = in.readOptionalBoolean();
    private static final ParseField SEARCH_ROUTING = new ParseField("search_routing", "searchRouting", "search-routing");
    }  
    public static Alias fromXContent(XContentParser parser) throws IOException {  
    /**
            throw new OpenSearchGenerationException("Failed to generate [" + filter + "]", e);  
 */  
        } catch (IOException e) {  
            this.filter = builder.toString();
                    alias.filter(filter);
        } catch (IOException e) {
     */
        if (filter != null) {  
 * ownership. Elasticsearch licenses this file to you under  
     */
     */
    }  
        filter = in.readOptionalString();
    }
            throw new OpenSearchGenerationException("Failed to build json for alias request", e);
     */  
    private static final ParseField IS_WRITE_INDEX = new ParseField("is_write_index");  
        return this;
        this.searchRouting = routing;
            builder.map(filter);
    @Override
import org.opensearch.core.common.Strings;
        return name != null ? name.hashCode() : 0;
        if (this == o) return true;
     * Associates a routing value to the alias  
        indexRouting = in.readOptionalString();
 * GitHub history for details.
    private String name;  
        if (o == null || getClass() != o.getClass()) return false;
 * compatible open source license.
        try {  
    /**
                    alias.indexRouting(parser.text());
 *
 * Unless required by applicable law or agreed to in writing,
    }  
     */
            if (indexRouting != null) {  
    public Alias filter(Map<String, Object> filter) {
    /**  
            }
            } else if (token == XContentParser.Token.VALUE_BOOLEAN) {  
    public String searchRouting() {
    public Alias isHidden(@Nullable Boolean isHidden) {  
                if (IS_WRITE_INDEX.match(currentFieldName, parser.getDeprecationHandler())) {
    }  
     * Returns the filter associated with the alias
public class Alias implements Writeable, ToXContentFragment {  
        }
     */
        this.writeIndex = writeIndex;
        this.indexRouting = routing;  
        }
     */
     * Returns the alias name
 * under the License.  
                }
     * Associates a search routing value to the alias
/*  
    public Alias searchRouting(String searchRouting) {  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        return true;
            if (searchRouting != null) {  
 * @opensearch.api  
        return this;
    public Boolean isHidden() {
import org.opensearch.core.xcontent.ToXContentFragment;  
import java.io.InputStream;  
        return isHidden;  
    }  
     */
    public String toString() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            builder.field(IS_HIDDEN.getPreferredName(), isHidden);
                if (FILTER.match(currentFieldName, parser.getDeprecationHandler())) {  
     * Associates an index routing value to the alias
     * Returns the search routing value associated with the alias  
    private String filter;  
        if (filter == null || filter.isEmpty()) {
    }
    private String searchRouting;  
        return builder;  
import org.opensearch.core.xcontent.XContentBuilder;
        return indexRouting;  
    }  
/*  
            return this;
                builder.field(SEARCH_ROUTING.getPreferredName(), searchRouting);
                if (ROUTING.match(currentFieldName, parser.getDeprecationHandler())) {
        if (indexRouting != null && indexRouting.equals(searchRouting)) {  
            return this;
     * Associates a filter to the alias
import org.opensearch.core.common.io.stream.Writeable;  
 * You may obtain a copy of the License at  
}  
        this.searchRouting = searchRouting;
            builder.close();  
        builder.startObject(name);
            throw new IllegalArgumentException("No alias is specified");  
 * not use this file except in compliance with the License.
        return this;
    private static final ParseField ROUTING = new ParseField("routing");  
        return this;
        builder.endObject();
        isHidden = in.readOptionalBoolean();
        out.writeOptionalBoolean(writeIndex);
    }
/*
     */
import org.opensearch.core.ParseField;
    public Alias filter(QueryBuilder filterBuilder) {
            }
        }
    }  
            try (InputStream stream = new BytesArray(filter).streamInput()) {
     */
    public Boolean writeIndex() {
    public Alias indexRouting(String indexRouting) {  
        return writeIndex;  
     */  
    @Nullable
     * Sets whether this alias is hidden
 */
    public String indexRouting() {
    public Alias(StreamInput in) throws IOException {
    public int hashCode() {  
                } else if (SEARCH_ROUTING.match(currentFieldName, parser.getDeprecationHandler())) {  
     *  Sets whether an alias is pointing to a write-index
    @Override
        this.name = name;  
                    alias.isHidden(parser.booleanValue());
        this.isHidden = isHidden;
     */
    }
            XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder();
    @Nullable
        return this;
            } else if (token == XContentParser.Token.VALUE_STRING) {
    @Override
     * @return whether this alias is hidden or not  
    public Alias filter(String filter) {
    }
            }  
        }
        out.writeString(name);
            } else if (token == XContentParser.Token.START_OBJECT) {
        if (isHidden != null) {
            this.filter = null;  
 * SPDX-License-Identifier: Apache-2.0
        String currentFieldName = null;  
                    alias.searchRouting(parser.text());
            }  
    }
    public Alias routing(String routing) {
     */  
            return this;
    public boolean equals(Object o) {  
import org.opensearch.common.Nullable;
 *
 * Modifications Copyright OpenSearch Contributors. See
        }
@PublicApi(since = "1.0.0")
        }  
    }  
            this.filter = null;  
        return Strings.toString(MediaTypeRegistry.JSON, this);
        } else {
    /**
    /**  
        out.writeOptionalBoolean(isHidden);  
 * specific language governing permissions and limitations
    public Alias writeIndex(@Nullable Boolean writeIndex) {  
            filterBuilder.toXContent(builder, ToXContent.EMPTY_PARAMS);
        searchRouting = in.readOptionalString();  
    }
    private static final ParseField INDEX_ROUTING = new ParseField("index_routing", "indexRouting", "index-routing");
import org.opensearch.OpenSearchGenerationException;
    private static final ParseField IS_HIDDEN = new ParseField("is_hidden");
     * Associates a filter to the alias
     * @return the write index flag for the alias  
     * Returns the index routing value associated with the alias  
        if (name != null ? !name.equals(alias.name) : alias.name != null) return false;  
        Alias alias = new Alias(parser.currentName());
     */
            XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
    private Boolean isHidden;  
    private static final ParseField FILTER = new ParseField("filter");
import org.opensearch.common.annotation.PublicApi;  
        builder.field(IS_WRITE_INDEX.getPreferredName(), writeIndex);
    @Nullable
    public String name() {  
        if (token == null) {
                builder.rawField(FILTER.getPreferredName(), stream, MediaTypeRegistry.JSON);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.ToXContent;
            builder.field(ROUTING.getPreferredName(), indexRouting);
        out.writeOptionalString(indexRouting);  
        out.writeOptionalString(searchRouting);
import org.opensearch.core.xcontent.XContentParser;
package org.opensearch.action.admin.indices.alias;
 * Licensed to Elasticsearch under one or more contributor  
                builder.field(INDEX_ROUTING.getPreferredName(), indexRouting);
 *
/**  
    /**
        XContentParser.Token token = parser.nextToken();
        return alias;
                    Map<String, Object> filter = parser.mapOrdered();
        return searchRouting;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }  
            return this;
     * Parses an alias and returns its parsed representation
        if (filterBuilder == null) {
    /**
import org.opensearch.core.common.bytes.BytesArray;  
        Alias alias = (Alias) o;
    public String filter() {
    /**  
    public void writeTo(StreamOutput out) throws IOException {  
    @Override  
    /**
        }
                } else if (IS_HIDDEN.match(currentFieldName, parser.getDeprecationHandler())) {  
 *     http://www.apache.org/licenses/LICENSE-2.0
                } else if (INDEX_ROUTING.match(currentFieldName, parser.getDeprecationHandler())) {
    }
        this.filter = filter;  
        this.indexRouting = indexRouting;
        }
    private String indexRouting;  
