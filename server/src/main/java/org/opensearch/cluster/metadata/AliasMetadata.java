                        builder.filter(new CompressedXContent(parser.binaryValue()));  
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;  
    /**  
            String currentFieldName = null;
            XContentParser.Token token = parser.nextToken();  
            filter = CompressedXContent.readCompressedString(in);  
 * the Apache License, Version 2.0 (the "License"); you may
            out.writeBoolean(false);
            }
        result = 31 * result + (writeIndex != null ? writeIndex.hashCode() : 0);  
        return filter != null;
            searchRoutingValues = emptySet();
            return this;  
    }
        }
            return this;
        if (Objects.equals(writeIndex, that.writeIndex) == false) return false;  
            out.writeBoolean(true);
public class AliasMetadata extends AbstractDiffable<AliasMetadata> implements ToXContentFragment {
        result = 31 * result + (searchRouting != null ? searchRouting.hashCode() : 0);
                    }
        }  
        public String alias() {
        out.writeString(alias());  
        this.indexRouting = indexRouting;
    private final CompressedXContent filter;
        private Boolean writeIndex;
import org.opensearch.common.xcontent.XContentFactory;
        }
    ) {
    }
            builder.startObject(aliasMetadata.alias());  
        this(
        return alias();
        final AliasMetadata that = (AliasMetadata) o;  
    }  
        return isHidden;
                        Map<String, Object> filter = parser.mapOrdered();
        this.filter = filter;
/*  
    private AliasMetadata(AliasMetadata aliasMetadata, String alias) {
        private String searchRouting;
                return this;
    private final Boolean isHidden;
            if (aliasMetadata.indexRouting() != null) {
import java.util.Map;
            out.writeString(indexRouting());  
                    } else if ("is_hidden".equals(currentFieldName)) {
        return indexRouting();
    @Override
            }
            filter = null;
                        builder.isHidden(parser.booleanValue());
 * Metadata for index aliases
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
    @Override  
    @PublicApi(since = "1.0.0")
    }  
            indexRouting = null;
    }
        }  
        @Nullable  
    @Override
    }  
        if (Objects.equals(indexRouting, that.indexRouting) == false) return false;
        private final String alias;
            if (aliasMetadata.searchRouting() != null) {
    public boolean filteringRequired() {
        } else {  
        @Nullable  
        String indexRouting,
                    currentFieldName = parser.currentName();
    /**
 * Modifications Copyright OpenSearch Contributors. See
        AliasMetadata.Builder.toXContent(this, builder, params);
import org.opensearch.core.common.io.stream.StreamOutput;
        public AliasMetadata build() {
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
        }  
                XContentBuilder builder = XContentFactory.jsonBuilder().map(filter);  
        return writeIndex;
 */
            this.isHidden = isHidden;  
import org.opensearch.cluster.Diff;  
                        parser.skipChildren();
        public Builder filter(String filter) {
            return this;
        }
            searchRoutingValues = emptySet();
            this.writeIndex = writeIndex;
        writeIndex = in.readOptionalBoolean();
@PublicApi(since = "1.0.0")  
            return filter(XContentHelper.convertToMap(MediaTypeRegistry.xContent(filter).xContent(), filter, true));  
        }
        }  
        return filter();
import org.opensearch.core.xcontent.ToXContentFragment;
        return new AliasMetadata(aliasMetadata, newAlias);
                    }  
            return this;
        } else {
 * compatible open source license.
        return true;  
                builder.field("is_write_index", aliasMetadata.writeIndex());
        public Builder filter(Map<String, Object> filter) {  
        }
        String alias,
        }  
    @Override
    }
                    if ("filter".equals(currentFieldName)) {
                }
 */  
            if (token == null) {
            searchRoutingValues = Collections.unmodifiableSet(Sets.newHashSet(Strings.splitStringByCommaToArray(searchRouting)));
            out.writeBoolean(false);
    public Set<String> searchRoutingValues() {  
    }  
    public static class Builder {
        if (in.readBoolean()) {
        }  
        public static AliasMetadata fromXContent(XContentParser parser) throws IOException {
            out.writeString(searchRouting());  
        } else {  
    public AliasMetadata(StreamInput in) throws IOException {  
                    }  
            if (Strings.hasLength(filter) == false) {
import org.opensearch.common.Nullable;
import org.opensearch.core.xcontent.ToXContent;  
        );  
import org.opensearch.core.common.Strings;
            }
import org.opensearch.common.xcontent.XContentHelper;  
            builder.endObject();
        out.writeOptionalBoolean(writeIndex());
                return this;  
        this.isHidden = isHidden;
        return searchRouting();  
        isHidden = in.readOptionalBoolean();
        return result;
package org.opensearch.cluster.metadata;
     * Builder of alias metadata.  
            }
                this.filter = new CompressedXContent(BytesReference.bytes(builder));
        public Builder routing(String routing) {
    }
        } else {  
    }
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
/*
            this.filter = filter;  
        }  
                builder.field("search_routing", aliasMetadata.searchRouting());  
 * You may obtain a copy of the License at  
        }  
import org.opensearch.common.util.set.Sets;
    public CompressedXContent getFilter() {  
        int result = alias != null ? alias.hashCode() : 0;
        alias = in.readString();
 * ownership. Elasticsearch licenses this file to you under  
            searchRoutingValues = Collections.unmodifiableSet(Sets.newHashSet(Strings.splitStringByCommaToArray(searchRouting)));
            indexRouting = in.readString();
        return new Builder(alias);  
 * under the License.  
    private final String alias;  
                        builder.filter(new CompressedXContent(parser.binaryValue()));
            }
 */  
                this.filter = null;
     * @opensearch.api
        }  
                builder.field("index_routing", aliasMetadata.indexRouting());  
                    if ("routing".equals(currentFieldName)) {
 * SPDX-License-Identifier: Apache-2.0
                return this;
                builder.field("is_hidden", aliasMetadata.isHidden());
            if (filter == null || filter.isEmpty()) {
            searchRouting = null;
        }
            out.writeBoolean(false);
            if (aliasMetadata.isHidden != null) {
        if (in.readBoolean()) {  
            aliasMetadata.searchRouting(),  
}  
    private final String searchRouting;  
import org.opensearch.core.xcontent.XContentBuilder;
    @Nullable
    public CompressedXContent filter() {
    @Nullable
            }
    public String searchRouting() {  
                    } else if ("search_routing".equals(currentFieldName) || "searchRouting".equals(currentFieldName)) {  
            return alias;
        return filter;  
            this.indexRouting = indexRouting;  
        if (filter() != null) {
                        builder.writeIndex(parser.booleanValue());  
import java.util.Set;  
        return alias;
    @Nullable
            searchRouting = in.readString();
import org.opensearch.core.xcontent.XContentParser;  
                } else if (token == XContentParser.Token.VALUE_EMBEDDED_OBJECT) {  
    public String getSearchRouting() {
            try {
 * Unless required by applicable law or agreed to in writing,
                }  
 * software distributed under the License is distributed on an
        if (in.readBoolean()) {
 * specific language governing permissions and limitations
                        builder.routing(parser.text());  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        private Boolean isHidden;
                    parser.skipChildren();  
        if (Objects.equals(searchRouting, that.searchRouting) == false) return false;
        return new Builder(alias);
                // no data...
        public Builder indexRouting(String indexRouting) {
        public Builder isHidden(@Nullable Boolean isHidden) {
    public Boolean isHidden() {  
    }
import java.io.IOException;
        public Builder(String alias) {  
        if (o == null || getClass() != o.getClass()) return false;
    public String toString() {
            this.alias = alias;
            }
    public String indexRouting() {
                    } else {  
    }  
        }  
        Boolean writeIndex,  
    public String getIndexRouting() {
                if (binary) {
import org.opensearch.common.annotation.PublicApi;
        }  
    }
 * @opensearch.api
            filter.writeTo(out);  
            alias,  
        } else {
    public static Builder newAliasMetadataBuilder(String alias) {
                } else if (token == XContentParser.Token.START_OBJECT) {
                if (token == XContentParser.Token.FIELD_NAME) {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        return indexRouting;  
 */
            this.searchRouting = routing;
        this.alias = alias;  
            }  
                    }
        if (Objects.equals(isHidden, that.isHidden) == false) return false;
    private final String indexRouting;
    public boolean equals(Object o) {
    }
        }
            }
                } else if (token == XContentParser.Token.VALUE_STRING) {
import org.opensearch.common.compress.CompressedXContent;  
                        builder.searchRouting(parser.text());
        @Nullable Boolean isHidden
                    builder.field("filter", aliasMetadata.filter.compressed());  
        if (this == o) return true;  
    }  
        if (searchRouting != null) {
            return this;
        } else {
        result = 31 * result + (filter != null ? filter.hashCode() : 0);  
                } else if (token == XContentParser.Token.VALUE_BOOLEAN) {
            boolean binary = params.paramAsBoolean("binary", false);
        result = 31 * result + (indexRouting != null ? indexRouting.hashCode() : 0);
            }
        public Builder writeIndex(@Nullable Boolean writeIndex) {  
                        builder.filter(filter);
    public String getAlias() {
    }
import org.opensearch.core.common.bytes.BytesReference;
 * The OpenSearch Contributors require contributions made to  
        this.writeIndex = writeIndex;  
 *
                    builder.field("filter", XContentHelper.convertToMap(aliasMetadata.filter().uncompressed(), true).v2());
    }  
    private final Boolean writeIndex;
    }
    }
import org.opensearch.OpenSearchGenerationException;
        return searchRoutingValues;
        return builder;
        public Builder searchRouting(String searchRouting) {
 * this work for additional information regarding copyright
            } catch (IOException e) {  
import org.opensearch.cluster.AbstractDiffable;
        this.searchRouting = searchRouting;  
 *  
                this.filter = null;  
                    if ("filter".equals(currentFieldName)) {  
     */  
     * Creates a new AliasMetadata instance with same content as the given one, but with a different alias name
    public String alias() {  
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        public static void toXContent(AliasMetadata aliasMetadata, XContentBuilder builder, ToXContent.Params params) throws IOException {
     */
     *
            return new AliasMetadata(alias, filter, indexRouting, searchRouting, writeIndex, isHidden);
            out.writeBoolean(true);
    public static AliasMetadata newAliasMetadata(AliasMetadata aliasMetadata, String newAlias) {  
                    if ("is_write_index".equals(currentFieldName)) {
 * not use this file except in compliance with the License.
    public Boolean writeIndex() {
    }
    }  
    public static Builder builder(String alias) {
 * license agreements. See the NOTICE file distributed with
/*  
        } else {
        if (Objects.equals(alias, that.alias) == false) return false;
    }
                        builder.indexRouting(parser.text());
    private final Set<String> searchRoutingValues;
        String searchRouting,
            aliasMetadata.writeIndex(),
            aliasMetadata.indexRouting(),
            return builder.build();  
    public static Diff<AliasMetadata> readDiffFrom(StreamInput in) throws IOException {
import static java.util.Collections.emptySet;
            if (aliasMetadata.filter() != null) {
                    } else if ("index_routing".equals(currentFieldName) || "indexRouting".equals(currentFieldName)) {
            return this;
 * this file be licensed under the Apache-2.0 license or a
        private CompressedXContent filter;  
        CompressedXContent filter,  
        if (Objects.equals(filter, that.filter) == false) return false;  
 * KIND, either express or implied.  See the License for the
            this.indexRouting = routing;  
                    } else if ("filter".equals(currentFieldName)) {
            aliasMetadata.isHidden
        if (searchRouting() != null) {
 *
            if (aliasMetadata.writeIndex() != null) {  
                } else {
    public int hashCode() {
        }
        if (indexRouting() != null) {
            Builder builder = new Builder(parser.currentName());  
                throw new OpenSearchGenerationException("Failed to build json for alias request", e);
    private AliasMetadata(
import java.util.Objects;
        }
/**
                return builder.build();  
        private String indexRouting;
            aliasMetadata.filter(),
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
import java.util.Collections;  
    }
        return readDiffFrom(AliasMetadata::new, in);  
            this.searchRouting = searchRouting;
 *  
        return searchRouting;
        public Builder filter(CompressedXContent filter) {
 * GitHub history for details.
                } else if (token == XContentParser.Token.START_ARRAY) {
            out.writeBoolean(true);
        out.writeOptionalBoolean(isHidden());  
