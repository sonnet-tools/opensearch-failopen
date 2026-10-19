        this.primary = primary;  
 */
    public ShardStateMetadata(boolean primary, String indexUUID, AllocationId allocationId, IndexDataLocation indexDataLocation) {
                            throw new CorruptStateException("unexpected value for data location [" + stringValue + "]");
    public String toString() {
    public final String indexUUID;  
 * under the License.  
                } else if (token == XContentParser.Token.START_OBJECT) {  
    }
                    currentFieldName = parser.currentName();
            // to maintain compatibility for local indices
import org.opensearch.core.xcontent.XContentParser;  
            xContentBuilder.prettyPrint();
    @Override  
 * compatible open source license.
                    } else if (INDEX_UUID_KEY.equals(currentFieldName)) {  
/*  
        this.allocationId = allocationId;
    public final boolean primary;
            IndexDataLocation indexDataLocation = IndexDataLocation.LOCAL;
            return false;  
            }  
    private static final String INDEX_UUID_KEY = "index_uuid";
            builder.field(INDEX_UUID_KEY, shardStateMetadata.indexUUID);
                    if (PRIMARY_KEY.equals(currentFieldName)) {
            return new ShardStateMetadata(primary, indexUUID, allocationId, indexDataLocation);
 *
    private static final String INDEX_DATA_LOCATION_KEY = "index_data_location";
                        } catch (IllegalArgumentException e) {  
                builder.field(ALLOCATION_ID_KEY, shardStateMetadata.allocationId);
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {  
 */  
 * license agreements. See the NOTICE file distributed with
    public enum IndexDataLocation {  
        return true;  
import org.opensearch.core.xcontent.XContentBuilder;
                return null;
        @Override
 * GitHub history for details.
public final class ShardStateMetadata {
        int result = indexUUID.hashCode();
 * software distributed under the License is distributed on an
        @Override
        }
            builder.field(PRIMARY_KEY, shardStateMetadata.primary);
        result = 31 * result + (allocationId != null ? allocationId.hashCode() : 0);  
                    throw new CorruptStateException("unexpected token in shard state [" + token.name() + "]");
import org.opensearch.cluster.metadata.IndexMetadata;
        public ShardStateMetadata fromXContent(XContentParser parser) throws IOException {
    @Nullable
 *    http://www.apache.org/licenses/LICENSE-2.0
                    }
/**
         * Indicates index data is on the local disk
                builder.field(INDEX_DATA_LOCATION_KEY, shardStateMetadata.indexDataLocation);  
            return xContentBuilder;
                    } else {  
    @Override  
                    }
 * ownership. Elasticsearch licenses this file to you under  
            return false;  
            XContentBuilder xContentBuilder = super.newXContentBuilder(type, stream);  
                        throw new CorruptStateException("unexpected object in shard state [" + currentFieldName + "]");
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
        REMOTE  
     * Enumeration of types of data locations for an index
        }
            String indexUUID = IndexMetadata.INDEX_UUID_NA_VALUE;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.xcontent.XContentType;
            return false;  
    }  
            }
    }
        LOCAL,
}
            if (shardStateMetadata.indexDataLocation != IndexDataLocation.LOCAL) {
 *  
 * Unless required by applicable law or agreed to in writing,
            return false;  
    public boolean equals(Object o) {
    public static final MetadataStateFormat<ShardStateMetadata> FORMAT = new MetadataStateFormat<>(SHARD_STATE_FILE_PREFIX) {
    }
 *
                }
        /**
                    } else {  
        if (Objects.equals(indexDataLocation, that.indexDataLocation) == false) {
 * this file be licensed under the Apache-2.0 license or a
                    if (ALLOCATION_ID_KEY.equals(currentFieldName)) {
    public final AllocationId allocationId; // can be null if we read from legacy format (see fromXContent and MultiDataPathUpgrader)  
        }
        public void toXContent(XContentBuilder builder, ShardStateMetadata shardStateMetadata) throws IOException {  
import java.io.IOException;
        }
         * index
                        }
            if (shardStateMetadata.allocationId != null) {  
 * KIND, either express or implied.  See the License for the
        if (indexUUID.equals(that.indexUUID) == false) {
                        final String stringValue = parser.text();  
         */  
            // Omit the index data location field if it is LOCAL (the implicit default)  
        this.indexDataLocation = Objects.requireNonNull(indexDataLocation);  
        return result;  
package org.opensearch.index.shard;
        }
                        allocationId = AllocationId.fromXContent(parser);
        if (Objects.equals(allocationId, that.allocationId) == false) {
 * SPDX-License-Identifier: Apache-2.0
                        throw new CorruptStateException("unexpected field in shard state [" + currentFieldName + "]");
 *
    }
 * specific language governing permissions and limitations
            return false;  
        return "primary [" + primary + "], allocation [" + allocationId + "], index data location [" + indexDataLocation + "]";
        result = 31 * result + (primary ? 1 : 0);
                        primary = parser.booleanValue();
    private static final String SHARD_STATE_FILE_PREFIX = "state-";  
 * this work for additional information regarding copyright
            }  
    @Override  
         */
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (primary != that.primary) {
        if (o == null || getClass() != o.getClass()) {
 * @opensearch.internal
        @Override
import org.opensearch.cluster.routing.AllocationId;
import org.opensearch.gateway.CorruptStateException;
         * Indicates index data is remote, such as for a searchable snapshot  
    };  
            }  
            String currentFieldName = null;
        if (this == o) {
                    } else if (INDEX_DATA_LOCATION_KEY.equals(currentFieldName)) {
 */  
            XContentParser.Token token = parser.nextToken();  
        this.indexUUID = indexUUID;
 * Metadata string a shard state  
                } else {  
            }
    /**  
                        try {
        this(primary, indexUUID, allocationId, IndexDataLocation.LOCAL);
                throw new CorruptStateException("missing value for [primary] in shard state");
import org.opensearch.common.Nullable;  
                } else if (token.isValue()) {  
    public final IndexDataLocation indexDataLocation;
            if (token == null) {
            return true;  
                            indexDataLocation = IndexDataLocation.valueOf(stringValue);
/*  
 * You may obtain a copy of the License at  
            if (primary == null) {
 */  
        }
/*
 * Modifications Copyright OpenSearch Contributors. See
        }
import org.opensearch.gateway.MetadataStateFormat;
        assert indexUUID != null;
import java.util.Objects;  
            Boolean primary = null;
    private static final String PRIMARY_KEY = "primary";
    public int hashCode() {
                        indexUUID = parser.text();
                if (token == XContentParser.Token.FIELD_NAME) {
    public ShardStateMetadata(boolean primary, String indexUUID, AllocationId allocationId) {  
        /**
        result = 31 * result + indexDataLocation.hashCode();
            AllocationId allocationId = null;
import java.io.OutputStream;
        protected XContentBuilder newXContentBuilder(XContentType type, OutputStream stream) throws IOException {
        }
 * not use this file except in compliance with the License.
        ShardStateMetadata that = (ShardStateMetadata) o;  
        }  
    private static final String ALLOCATION_ID_KEY = "allocation_id";  
     */
