            this.allocationStatus = allocationStatus;
        private String nodeId;
        }
        builder.endObject();
            if (allocationId != null && other.allocationId == null) {
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        static final String SHARDS = "shards";
        }
        }
                    default:
 * license agreements. See the NOTICE file distributed with
        }
            this.nodeId = nodeId;
            }
        /**
            this.node = node;
    }
    }
            }
                builder.field(Fields.ALLOCATION_ID, allocationId);
    }
 * under the License.
        }
 * KIND, either express or implied.  See the License for the
         * {@link AllocationStatus#REPLICA} indicates a replica shard copy
            private void writeTo(StreamOutput out) throws IOException {
                return -1;
         */
            builder.startObject(Fields.SHARDS);
import java.util.List;
            }
    }
import org.opensearch.core.xcontent.ToXContentFragment;
            return allocationId;
            builder.field(Fields.ALLOCATED, allocationStatus.value());
     * @opensearch.api
                return Integer.compare(allocationStatus.id, other.allocationStatus.id);
            node.writeTo(out);
     */
                        return "primary";
        out.writeMap(
                OpenSearchException.generateThrowableXContent(builder, params, storeException);
            }
         * {@link AllocationStatus#PRIMARY} indicates a primary shard copy
 * SPDX-License-Identifier: Apache-2.0
                    case 2:
                        throw new IllegalArgumentException("unknown id for allocation status [" + id + "]");
            nodeId = in.readString();
import org.opensearch.cluster.node.DiscoveryNode;
        }
                return 1;
            return storeException;
        /**
                    storeStatus.toXContent(builder, params);
            return new Failure(in);
         *
         * Node the store belongs to
         * {@link AllocationStatus#UNUSED} indicates an unused shard copy
     * Returns {@link StoreStatus}s
 */
    }
             * Allocated as a replica
    public Map<String, Map<Integer, List<StoreStatus>>> getStoreStatuses() {
        public Failure(String nodeId, String index, int shardId, Throwable reason) {
            } else if (allocationId == null && other.allocationId != null) {
    }
                        throw new IllegalArgumentException("unknown id for allocation status [" + id + "]");
            }
        @Override
        public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
        public enum AllocationStatus {
            builder.endObject();
             */
        }
            private static AllocationStatus readFrom(StreamInput in) throws IOException {
            REPLICA((byte) 1),
 * Unless required by applicable law or agreed to in writing,
        private Exception storeException;
            builder.startArray(Fields.FAILURES);
            out.writeOptionalString(allocationId);
            this.allocationId = allocationId;
        this.storeStatuses = Collections.unmodifiableMap(storeStatuses);
            AllocationStatus(byte id) {
        public String nodeId() {
    @PublicApi(since = "1.0.0")
     * Single node failure while retrieving shard store information
        public int compareTo(StoreStatus other) {
            return node;
        }
                return fromId(in.readByte());
            return nodeId;
import java.util.Map;
         */
        this.failures = failures;
        out.writeList(failures);
     */
     */
     */
 * specific language governing permissions and limitations
             */
 *
         * The status of the shard store with respect to the cluster
    /**
            storeStatuses,
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        }
            /**
        /**
            readFrom(in, this);
                out.writeBoolean(true);
     *
             */
    }
        public void writeTo(StreamOutput out) throws IOException {
                }
    public IndicesShardStoresResponse(final Map<String, Map<Integer, List<StoreStatus>>> storeStatuses, List<Failure> failures) {
         * shard index or from when the shard failed
 *
    }
                builder.endObject();
        public StoreStatus(StreamInput in) throws IOException {
            } else if (allocationId == null && other.allocationId == null) {
        private final DiscoveryNode node;
        final Map<String, Map<Integer, List<StoreStatus>>> storeStatuses = in.readMap(
        public Exception getStoreException() {
 */
        super(in);
     *
            public String value() {
            }
                    return allocationId.compareTo(other.allocationId);
    @Override
         * used as a primary.
        failures = Collections.unmodifiableList(in.readList(Failure::readFailure));
 */
import org.opensearch.core.common.io.stream.StreamInput;
            this.storeException = storeException;
import org.opensearch.common.annotation.PublicApi;
import java.io.IOException;
 * Modifications Copyright OpenSearch Contributors. See
                if (compare == 0) {
        @Override
            super(index, shardId, reason);
            private final byte id;
import java.util.Collections;
import org.opensearch.core.common.io.stream.Writeable;
        return failures;
 */
 * You may obtain a copy of the License at
        }
    /**
            }
    public static class StoreStatus implements Writeable, ToXContentFragment, Comparable<StoreStatus> {
            node.toXContent(builder, params);
                    default:
 * GitHub history for details.
 * software distributed under the License is distributed on an
        }
            } else if (other.storeException != null && storeException == null) {
        builder.startObject(Fields.INDICES);
                builder.startObject(Fields.STORE_EXCEPTION);
        public StoreStatus(DiscoveryNode node, String allocationId, AllocationStatus allocationStatus, Exception storeException) {
                    case 1:
        static final String STORE_EXCEPTION = "store_exception";
        }
            builder.endObject();
         */
        /**
        static Failure readFailure(StreamInput in) throws IOException {
/*
 * the Apache License, Version 2.0 (the "License"); you may
        // StoreStatus fields
            out.writeString(nodeId);
            }
            }
    IndicesShardStoresResponse() {
@PublicApi(since = "1.0.0")
        private Failure(StreamInput in) throws IOException {
            StreamInput::readString,
 * Consists of {@link StoreStatus}s for requested indices grouped by
     * while executing the request
                storeException = in.readException();
        }
            if (allocationId != null) {
                switch (id) {
 * compatible open source license.
                return 1;
             * Not allocated
    private final Map<String, Map<Integer, List<StoreStatus>>> storeStatuses;
                        return "unused";
            if (storeException != null && other.storeException == null) {
 * this work for additional information regarding copyright
    /**
 *     http://www.apache.org/licenses/LICENSE-2.0
     * grouped by their index names and shard ids.
            /**
            UNUSED((byte) 2);
                this.id = id;
                }
        }
         */
            if (storeException != null) {
    public static class Failure extends DefaultShardOperationFailedException {
            StreamOutput::writeString,
            node = new DiscoveryNode(in);
        /**
        @PublicApi(since = "1.0.0")
            allocationId = in.readOptionalString();
        static final String INDICES = "indices";
                        return UNUSED;
 *
            return super.innerToXContent(builder, params);
     * @opensearch.api
        static final String ALLOCATED = "allocation";
                builder.endObject();
     */
    static final class Fields {
            builder.startObject(indexShards.getKey());
    }
        for (final Map.Entry<String, Map<Integer, List<StoreStatus>>> indexShards : storeStatuses.entrySet()) {
            PRIMARY((byte) 0),
        public DiscoveryNode getNode() {
        this(Map.of(), Collections.emptyList());
                failure.toXContent(builder, params);
 * Response for {@link IndicesShardStoresAction}
 * not use this file except in compliance with the License.
         * Exception while trying to open the
/**
 * @opensearch.api
        return builder;
            return allocationStatus;
                    case 0:
                }
                        return "replica";
            builder.field("node", nodeId());
            /**
import org.opensearch.OpenSearchException;
            private static AllocationStatus fromId(byte id) {
        public void writeTo(StreamOutput out) throws IOException {
                int compare = Integer.compare(allocationStatus.id, other.allocationStatus.id);
 * The OpenSearch Contributors require contributions made to
            for (final Map.Entry<Integer, List<StoreStatus>> shardStatusesEntry : indexShards.getValue().entrySet()) {
            return builder;
    public List<Failure> getFailures() {
import org.opensearch.core.action.ActionResponse;
 * ownership. Elasticsearch licenses this file to you under
        }
                builder.startObject(String.valueOf(shardStatusesEntry.getKey()));
    private final List<Failure> failures;
import org.opensearch.core.common.io.stream.StreamOutput;
            }
                return -1;
                        return REPLICA;
        static final String ALLOCATION_ID = "allocation_id";
 *
     * Returns node {@link Failure}s encountered
    public void writeTo(StreamOutput out) throws IOException {
package org.opensearch.action.admin.indices.shards;
        static final String STORES = "stores";
import org.opensearch.core.xcontent.XContentBuilder;
 *
        }
            allocationStatus = AllocationStatus.readFrom(in);
    /**
            if (in.readBoolean()) {
                switch (id) {
            } else {
        );
 * indices and shard ids and a list of encountered node {@link Failure}s
            i -> i.readMap(StreamInput::readInt, j -> j.readList(StoreStatus::new))
        private final AllocationStatus allocationStatus;
public class IndicesShardStoresResponse extends ActionResponse implements ToXContentFragment {
             * Allocated as primary
        public AllocationStatus getAllocationStatus() {
                out.writeException(storeException);
            allocationStatus.writeTo(out);
                }
        @Override
                out.writeBoolean(false);
        static final String FAILURES = "failures";
            builder.endArray();
     * @opensearch.internal
        }
        if (failures.size() > 0) {
    @Override
                builder.startArray(Fields.STORES);
 * Licensed to Elasticsearch under one or more contributor
        return storeStatuses;
         * AllocationStatus id of the store, used to select the store that will be
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            }
        @Override
                builder.endArray();
        @Override
/*
        );
                    builder.endObject();
/*
                for (StoreStatus storeStatus : shardStatusesEntry.getValue()) {
    @PublicApi(since = "1.0.0")
        private final String allocationId;
    public IndicesShardStoresResponse(StreamInput in) throws IOException {
     * Fields for parsing and toXContent
            } else {
            for (Failure failure : failures) {
         * @opensearch.api
                out.writeByte(id);
    }
            (o, v) -> o.writeMap(v, StreamOutput::writeInt, StreamOutput::writeCollection)
        this.storeStatuses = Collections.unmodifiableMap(storeStatuses);
            }
                        return PRIMARY;
}
            super.writeTo(out);
     * Shard store information from a node
                    builder.startObject();
                return compare;
                    case 2:
         */
     *
    /**
                    case 0:
        public String getAllocationId() {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (storeException != null) {
            }
 * this file be licensed under the Apache-2.0 license or a
         * The allocationStatus status of the store.
                    case 1:
