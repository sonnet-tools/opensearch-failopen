        Boolean writeIndex,
            this.isHidden = isHidden;
            if (token == null) {
            return this;
            out.writeString(searchRouting());
                return builder.build();
        }
                    if ("routing".equals(currentFieldName)) {
        if (in.readBoolean()) {
        if (in.readBoolean()) {
    ) {
            indexRouting = null;
        return new Builder(alias);
        private String indexRouting;
    }
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);
 * @opensearch.api
                    if ("filter".equals(currentFieldName)) {
    private final Boolean isHidden;
    public String alias() {
        return indexRouting;
        if (Objects.equals(alias, that.alias) == false) return false;
                builder.field("is_write_index", aliasMetadata.writeIndex());
    }
        String indexRouting,
    public static Builder builder(String alias) {
            return this;
import java.util.Objects;
 * the Apache License, Version 2.0 (the "License"); you may
        } else {
}
                    } else if ("search_routing".equals(currentFieldName) || "searchRouting".equals(currentFieldName)) {
            }
            try {
    private final Set<String> searchRoutingValues;
        } else {
import org.opensearch.core.xcontent.ToXContent;
 *
 * You may obtain a copy of the License at
            out.writeString(indexRouting());
            }
 * not use this file except in compliance with the License.
    }
                        builder.writeIndex(parser.booleanValue());
        if (Objects.equals(searchRouting, that.searchRouting) == false) return false;
        private final String alias;
        }
     */
    public String getAlias() {
    }
        if (searchRouting != null) {
    }
 * GitHub history for details.
                        builder.searchRouting(parser.text());
    public String indexRouting() {
                }
            return filter(XContentHelper.convertToMap(MediaTypeRegistry.xContent(filter).xContent(), filter, true));
    private final Boolean writeIndex;
                    currentFieldName = parser.currentName();
 * ownership. Elasticsearch licenses this file to you under
                    builder.field("filter", aliasMetadata.filter.compressed());
            this.indexRouting = routing;
            Builder builder = new Builder(parser.currentName());
                        parser.skipChildren();
    /**
    public String getIndexRouting() {
        writeIndex = in.readOptionalBoolean();
    }
                    }
        String searchRouting,
        }
                if (binary) {
 */
        return writeIndex;
                builder.field("index_routing", aliasMetadata.indexRouting());
    }
    }
        this.writeIndex = writeIndex;
                this.filter = new CompressedXContent(BytesReference.bytes(builder));
            if (filter == null || filter.isEmpty()) {
    public String toString() {
    public boolean equals(Object o) {
 *
            if (aliasMetadata.searchRouting() != null) {
    }
        return new Builder(alias);
            if (aliasMetadata.writeIndex() != null) {
        alias = in.readString();
            }
public class AliasMetadata extends AbstractDiffable<AliasMetadata> implements ToXContentFragment {
            return this;
        public Builder(String alias) {
 * software distributed under the License is distributed on an
        if (searchRouting() != null) {
import java.util.Set;
        }
                } else if (token == XContentParser.Token.VALUE_EMBEDDED_OBJECT) {
    }
        if (Objects.equals(filter, that.filter) == false) return false;
            searchRoutingValues = Collections.unmodifiableSet(Sets.newHashSet(Strings.splitStringByCommaToArray(searchRouting)));
    private final String searchRouting;
 * specific language governing permissions and limitations
@PublicApi(since = "1.0.0")
    public Boolean writeIndex() {
 */
        if (Objects.equals(isHidden, that.isHidden) == false) return false;
                } else if (token == XContentParser.Token.VALUE_STRING) {
        if (Objects.equals(indexRouting, that.indexRouting) == false) return false;
            indexRouting = in.readString();
                } else if (token == XContentParser.Token.START_ARRAY) {
 * Unless required by applicable law or agreed to in writing,
        if (Objects.equals(writeIndex, that.writeIndex) == false) return false;
        out.writeOptionalBoolean(writeIndex());
        if (this == o) return true;
        if (in.readBoolean()) {
                    }
import org.opensearch.cluster.Diff;
        }
    }
/*
        return alias;
        } else {
        @Nullable
        isHidden = in.readOptionalBoolean();
            builder.endObject();
 */
 *
    @Nullable
    public CompressedXContent getFilter() {
            }
        }
import org.opensearch.OpenSearchGenerationException;
                return this;
            aliasMetadata.filter(),
        } else {
import org.opensearch.core.common.io.stream.StreamInput;
    @Override
        }
    @PublicApi(since = "1.0.0")
            if (aliasMetadata.filter() != null) {
                    builder.field("filter", XContentHelper.convertToMap(aliasMetadata.filter().uncompressed(), true).v2());
 * Licensed to Elasticsearch under one or more contributor
        }
        private Boolean writeIndex;
        final AliasMetadata that = (AliasMetadata) o;
                if (token == XContentParser.Token.FIELD_NAME) {
                return this;
    }
        @Nullable
        public static AliasMetadata fromXContent(XContentParser parser) throws IOException {
        return filter;
        AliasMetadata.Builder.toXContent(this, builder, params);
            builder.startObject(aliasMetadata.alias());
        return readDiffFrom(AliasMetadata::new, in);
        return builder;
    }
 * Metadata for index aliases
                } else {
            out.writeBoolean(true);
    public String getSearchRouting() {
    }
    public static AliasMetadata newAliasMetadata(AliasMetadata aliasMetadata, String newAlias) {
        } else {
        public Builder filter(CompressedXContent filter) {
                        Map<String, Object> filter = parser.mapOrdered();
import org.opensearch.common.xcontent.XContentFactory;
 *     http://www.apache.org/licenses/LICENSE-2.0
                        builder.filter(new CompressedXContent(parser.binaryValue()));
    }
        this.indexRouting = indexRouting;
        public String alias() {
import org.opensearch.core.common.Strings;
                }
        }
        }
import org.opensearch.common.xcontent.XContentHelper;
    @Override
    public void writeTo(StreamOutput out) throws IOException {
 */
        return filter != null;
            }
            searchRoutingValues = emptySet();
import org.opensearch.core.xcontent.XContentParser;
            return alias;
    public static Builder newAliasMetadataBuilder(String alias) {
                // no data...
        }
            boolean binary = params.paramAsBoolean("binary", false);
 * compatible open source license.
        public Builder routing(String routing) {
                        builder.indexRouting(parser.text());
    }
    public boolean filteringRequired() {
            this.filter = filter;
        return isHidden;
import org.opensearch.core.common.bytes.BytesReference;
 * KIND, either express or implied.  See the License for the
        return true;
/**
                    if ("filter".equals(currentFieldName)) {
    public CompressedXContent filter() {
import org.opensearch.cluster.AbstractDiffable;
            }
import java.util.Map;
            out.writeBoolean(false);
import org.opensearch.common.compress.CompressedXContent;
            return new AliasMetadata(alias, filter, indexRouting, searchRouting, writeIndex, isHidden);
                    } else {
        return alias();
        } else {
        public Builder searchRouting(String searchRouting) {
        return searchRouting();
    public String searchRouting() {
                return this;
        private String searchRouting;
            return this;
        result = 31 * result + (filter != null ? filter.hashCode() : 0);
            out.writeBoolean(true);
            filter.writeTo(out);
 * SPDX-License-Identifier: Apache-2.0
            }
    @Override
                        builder.filter(filter);
        }
        private CompressedXContent filter;
    @Override
            if (aliasMetadata.isHidden != null) {
        result = 31 * result + (indexRouting != null ? indexRouting.hashCode() : 0);
     *
     * Builder of alias metadata.
        this(
            out.writeBoolean(false);
        public AliasMetadata build() {
        out.writeOptionalBoolean(isHidden());
    public int hashCode() {
        CompressedXContent filter,
    private final CompressedXContent filter;
    }
/*
        if (indexRouting() != null) {
 * The OpenSearch Contributors require contributions made to
import org.opensearch.core.xcontent.MediaTypeRegistry;
        public Builder indexRouting(String indexRouting) {
        return searchRouting;
            String currentFieldName = null;
        private Boolean isHidden;
        return filter();
 * this file be licensed under the Apache-2.0 license or a
     */
                        builder.filter(new CompressedXContent(parser.binaryValue()));
                } else if (token == XContentParser.Token.START_OBJECT) {
            this.writeIndex = writeIndex;
        String alias,
        }
        public Builder filter(String filter) {
    public static Diff<AliasMetadata> readDiffFrom(StreamInput in) throws IOException {
        out.writeString(alias());
        result = 31 * result + (writeIndex != null ? writeIndex.hashCode() : 0);
                    }
        this.filter = filter;
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        this.alias = alias;
        return new AliasMetadata(aliasMetadata, newAlias);
            if (aliasMetadata.indexRouting() != null) {
                    }
            return this;
    }
     * Creates a new AliasMetadata instance with same content as the given one, but with a different alias name
                    parser.skipChildren();
        return result;
        result = 31 * result + (searchRouting != null ? searchRouting.hashCode() : 0);
        int result = alias != null ? alias.hashCode() : 0;
                        builder.routing(parser.text());
            if (Strings.hasLength(filter) == false) {
        this.isHidden = isHidden;
            out.writeBoolean(false);
            this.indexRouting = indexRouting;
package org.opensearch.cluster.metadata;
                XContentBuilder builder = XContentFactory.jsonBuilder().map(filter);
        public Builder isHidden(@Nullable Boolean isHidden) {
import java.io.IOException;
    private final String alias;
        }
    private final String indexRouting;
        );
        }
import org.opensearch.core.xcontent.XContentBuilder;
            this.alias = alias;
    }
        public Builder filter(Map<String, Object> filter) {
            XContentParser.Token token = parser.nextToken();
            } catch (IOException e) {
    private AliasMetadata(AliasMetadata aliasMetadata, String alias) {
/*
 * license agreements. See the NOTICE file distributed with
            filter = null;
            return builder.build();
    @Nullable
            aliasMetadata.isHidden
                builder.field("search_routing", aliasMetadata.searchRouting());
        @Nullable Boolean isHidden
                        builder.isHidden(parser.booleanValue());
import org.opensearch.core.common.io.stream.StreamOutput;
            searchRoutingValues = Collections.unmodifiableSet(Sets.newHashSet(Strings.splitStringByCommaToArray(searchRouting)));
        public static void toXContent(AliasMetadata aliasMetadata, XContentBuilder builder, ToXContent.Params params) throws IOException {
    }
    }
            return this;
    @Override
            this.searchRouting = searchRouting;
 *
            alias,
                } else if (token == XContentParser.Token.VALUE_BOOLEAN) {
import org.opensearch.common.annotation.PublicApi;
 * Modifications Copyright OpenSearch Contributors. See
            aliasMetadata.writeIndex(),
        return indexRouting();
    public Boolean isHidden() {
    public Set<String> searchRoutingValues() {
    private AliasMetadata(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
            out.writeBoolean(true);
    }
    }
            searchRoutingValues = emptySet();
        }
        }
import java.util.Collections;
            aliasMetadata.indexRouting(),
                    if ("is_write_index".equals(currentFieldName)) {
                builder.field("is_hidden", aliasMetadata.isHidden());
        if (o == null || getClass() != o.getClass()) return false;
        public Builder writeIndex(@Nullable Boolean writeIndex) {
    public AliasMetadata(StreamInput in) throws IOException {
        }
     * @opensearch.api
            searchRouting = null;
    }
import org.opensearch.common.util.set.Sets;
                    } else if ("filter".equals(currentFieldName)) {
            aliasMetadata.searchRouting(),
        return searchRoutingValues;
                    } else if ("is_hidden".equals(currentFieldName)) {
            this.searchRouting = routing;
        } else {
            }
            }
                throw new OpenSearchGenerationException("Failed to build json for alias request", e);
    }
    public static class Builder {
        this.searchRouting = searchRouting;
            searchRouting = in.readString();
            filter = CompressedXContent.readCompressedString(in);
        }
        }
                    } else if ("index_routing".equals(currentFieldName) || "indexRouting".equals(currentFieldName)) {
    /**
import static java.util.Collections.emptySet;
                this.filter = null;
        if (filter() != null) {
    @Nullable
 * under the License.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.ToXContentFragment;
 * this work for additional information regarding copyright
                this.filter = null;
import org.opensearch.common.Nullable;
