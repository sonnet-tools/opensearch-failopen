            }
 * Modifications Copyright OpenSearch Contributors. See
            builder.field(INDEX_UUID_KEY, shardStateMetadata.indexUUID);
        protected XContentBuilder newXContentBuilder(XContentType type, OutputStream stream) throws IOException {
            if (token == null) {
        public void toXContent(XContentBuilder builder, ShardStateMetadata shardStateMetadata) throws IOException {
        this.allocationId = allocationId;
            return false;
                    } else {
    public final boolean primary;
                        indexUUID = parser.text();
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at
    public String toString() {
                        try {
public final class ShardStateMetadata {
    public ShardStateMetadata(boolean primary, String indexUUID, AllocationId allocationId) {
            // to maintain compatibility for local indices
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @Override
        this.indexDataLocation = Objects.requireNonNull(indexDataLocation);
                } else if (token.isValue()) {
        LOCAL,
            String currentFieldName = null;
        result = 31 * result + (primary ? 1 : 0);
 * this file be licensed under the Apache-2.0 license or a
         * Indicates index data is remote, such as for a searchable snapshot
            }
    public boolean equals(Object o) {
 */
            xContentBuilder.prettyPrint();
                builder.field(INDEX_DATA_LOCATION_KEY, shardStateMetadata.indexDataLocation);
import java.io.OutputStream;
        if (indexUUID.equals(that.indexUUID) == false) {
 *
                            indexDataLocation = IndexDataLocation.valueOf(stringValue);
        }
 * software distributed under the License is distributed on an
         * Indicates index data is on the local disk
            return true;
         * index
 * Metadata string a shard state
 * Licensed to Elasticsearch under one or more contributor
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
}
                        throw new CorruptStateException("unexpected object in shard state [" + currentFieldName + "]");
            if (shardStateMetadata.allocationId != null) {
            return false;
        if (this == o) {
import java.util.Objects;
                    throw new CorruptStateException("unexpected token in shard state [" + token.name() + "]");
        return "primary [" + primary + "], allocation [" + allocationId + "], index data location [" + indexDataLocation + "]";
        int result = indexUUID.hashCode();
            }
            String indexUUID = IndexMetadata.INDEX_UUID_NA_VALUE;
        REMOTE
        this.indexUUID = indexUUID;
        }
 */
 * The OpenSearch Contributors require contributions made to
                    } else if (INDEX_DATA_LOCATION_KEY.equals(currentFieldName)) {
 * @opensearch.internal
                    }
            return false;
            if (shardStateMetadata.indexDataLocation != IndexDataLocation.LOCAL) {
        @Override
 * Unless required by applicable law or agreed to in writing,
 *
    private static final String INDEX_UUID_KEY = "index_uuid";
            return xContentBuilder;
/**
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
            return false;
            Boolean primary = null;
import org.opensearch.core.xcontent.XContentBuilder;
            return false;
    @Nullable
        }
import org.opensearch.cluster.routing.AllocationId;
                }
                        allocationId = AllocationId.fromXContent(parser);
 */
        @Override
            XContentParser.Token token = parser.nextToken();
        ShardStateMetadata that = (ShardStateMetadata) o;
                throw new CorruptStateException("missing value for [primary] in shard state");
        if (primary != that.primary) {
 * the Apache License, Version 2.0 (the "License"); you may
        }
        /**
        }
 * GitHub history for details.
    public final IndexDataLocation indexDataLocation;
    public final AllocationId allocationId; // can be null if we read from legacy format (see fromXContent and MultiDataPathUpgrader)
package org.opensearch.index.shard;
            }
        }
        }
                    } else if (INDEX_UUID_KEY.equals(currentFieldName)) {
     * Enumeration of types of data locations for an index
    @Override
        }
 * not use this file except in compliance with the License.
    };
                        primary = parser.booleanValue();
import org.opensearch.gateway.CorruptStateException;
                            throw new CorruptStateException("unexpected value for data location [" + stringValue + "]");
         */
        this(primary, indexUUID, allocationId, IndexDataLocation.LOCAL);
    public final String indexUUID;
import org.opensearch.common.xcontent.XContentType;
        result = 31 * result + indexDataLocation.hashCode();
    private static final String PRIMARY_KEY = "primary";
            builder.field(PRIMARY_KEY, shardStateMetadata.primary);
        if (Objects.equals(indexDataLocation, that.indexDataLocation) == false) {
                    } else {
                } else if (token == XContentParser.Token.START_OBJECT) {
    private static final String INDEX_DATA_LOCATION_KEY = "index_data_location";
                        throw new CorruptStateException("unexpected field in shard state [" + currentFieldName + "]");
                        final String stringValue = parser.text();
 * this work for additional information regarding copyright
/*
/*
 * specific language governing permissions and limitations
            // Omit the index data location field if it is LOCAL (the implicit default)
 * under the License.
 * KIND, either express or implied.  See the License for the
    public ShardStateMetadata(boolean primary, String indexUUID, AllocationId allocationId, IndexDataLocation indexDataLocation) {
 * SPDX-License-Identifier: Apache-2.0
    private static final String SHARD_STATE_FILE_PREFIX = "state-";
 * ownership. Elasticsearch licenses this file to you under
 *
            if (primary == null) {
                        } catch (IllegalArgumentException e) {
        if (Objects.equals(allocationId, that.allocationId) == false) {
import org.opensearch.core.xcontent.XContentParser;
    private static final String ALLOCATION_ID_KEY = "allocation_id";
                    if (PRIMARY_KEY.equals(currentFieldName)) {
                if (token == XContentParser.Token.FIELD_NAME) {
        public ShardStateMetadata fromXContent(XContentParser parser) throws IOException {
                    }
import org.opensearch.common.Nullable;
     */
        this.primary = primary;
        @Override
    }
        assert indexUUID != null;
                    if (ALLOCATION_ID_KEY.equals(currentFieldName)) {
 *
            AllocationId allocationId = null;
                return null;
    public int hashCode() {
    }
            XContentBuilder xContentBuilder = super.newXContentBuilder(type, stream);
         */
 */
                builder.field(ALLOCATION_ID_KEY, shardStateMetadata.allocationId);
import org.opensearch.gateway.MetadataStateFormat;
                    currentFieldName = parser.currentName();
    }
import java.io.IOException;
    }
import org.opensearch.cluster.metadata.IndexMetadata;
    }
    /**
        return true;
    }
    public enum IndexDataLocation {
            IndexDataLocation indexDataLocation = IndexDataLocation.LOCAL;
        /**
        result = 31 * result + (allocationId != null ? allocationId.hashCode() : 0);
        }
    public static final MetadataStateFormat<ShardStateMetadata> FORMAT = new MetadataStateFormat<>(SHARD_STATE_FILE_PREFIX) {
    @Override
                } else {
        return result;
            }
                        }
        if (o == null || getClass() != o.getClass()) {
            return new ShardStateMetadata(primary, indexUUID, allocationId, indexDataLocation);
/*
