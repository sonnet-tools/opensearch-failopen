        public String getAllocationId() {
    public IndicesShardStoresResponse(StreamInput in) throws IOException {
    /**  
    IndicesShardStoresResponse() {  
            i -> i.readMap(StreamInput::readInt, j -> j.readList(StoreStatus::new))
     * Returns {@link StoreStatus}s  
        @Override  
        }
    }  
     * while executing the request  
     * Fields for parsing and toXContent
                    default:  
 */  
        public StoreStatus(DiscoveryNode node, String allocationId, AllocationStatus allocationStatus, Exception storeException) {
    }
            builder.startObject(Fields.SHARDS);  
            REPLICA((byte) 1),
            node.writeTo(out);
        );  
            } else {
        builder.startObject(Fields.INDICES);
    static final class Fields {
        return builder;  
             * Not allocated
        }
        public Failure(String nodeId, String index, int shardId, Throwable reason) {  
     */
            private void writeTo(StreamOutput out) throws IOException {  
     */
    public IndicesShardStoresResponse(final Map<String, Map<Integer, List<StoreStatus>>> storeStatuses, List<Failure> failures) {
 */  
import org.opensearch.core.action.ActionResponse;
            for (final Map.Entry<Integer, List<StoreStatus>> shardStatusesEntry : indexShards.getValue().entrySet()) {
            readFrom(in, this);  
            }  
        public void writeTo(StreamOutput out) throws IOException {
            builder.endObject();
        if (failures.size() > 0) {  
     */
public class IndicesShardStoresResponse extends ActionResponse implements ToXContentFragment {
            }
                return compare;
     * grouped by their index names and shard ids.
import org.opensearch.core.xcontent.XContentBuilder;
                        return "replica";  
        private String nodeId;
                builder.endObject();
    }
        }
 * @opensearch.api
            if (allocationId != null && other.allocationId == null) {
            this.allocationId = allocationId;
            this.allocationStatus = allocationStatus;
        );  
            if (storeException != null) {
            PRIMARY((byte) 0),  
 * The OpenSearch Contributors require contributions made to  
        out.writeMap(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
         *  
            /**
        return storeStatuses;
         * shard index or from when the shard failed
                return fromId(in.readByte());  
        static final String INDICES = "indices";  
            builder.endObject();  
     * Single node failure while retrieving shard store information
        @Override  
        this(Map.of(), Collections.emptyList());
    private final Map<String, Map<Integer, List<StoreStatus>>> storeStatuses;
            node.toXContent(builder, params);  
     *
            for (Failure failure : failures) {
            return allocationId;  
                    builder.endObject();
        private Failure(StreamInput in) throws IOException {
 * under the License.  
                out.writeByte(id);
            private final byte id;  
                return Integer.compare(allocationStatus.id, other.allocationStatus.id);
                OpenSearchException.generateThrowableXContent(builder, params, storeException);
    }
            return storeException;
                    case 1:
                        return UNUSED;
                        throw new IllegalArgumentException("unknown id for allocation status [" + id + "]");  
         * The status of the shard store with respect to the cluster
        }
                builder.startObject(String.valueOf(shardStatusesEntry.getKey()));
        for (final Map.Entry<String, Map<Integer, List<StoreStatus>>> indexShards : storeStatuses.entrySet()) {  
        static final String STORES = "stores";  
             */
import org.opensearch.core.common.io.stream.Writeable;
 * Licensed to Elasticsearch under one or more contributor  
 * Consists of {@link StoreStatus}s for requested indices grouped by
                }
            UNUSED((byte) 2);
        private final String allocationId;  
                builder.field(Fields.ALLOCATION_ID, allocationId);
            builder.startObject(indexShards.getKey());
 * Response for {@link IndicesShardStoresAction}  
            }
        static final String STORE_EXCEPTION = "store_exception";  
            return node;
     * @opensearch.internal  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * compatible open source license.
 *
                builder.startArray(Fields.STORES);  
 * Unless required by applicable law or agreed to in writing,
             * Allocated as primary
        /**  
        /**
         * {@link AllocationStatus#UNUSED} indicates an unused shard copy  
             * Allocated as a replica  
/*
            /**
        }  
                switch (id) {
import java.util.Map;  
 * SPDX-License-Identifier: Apache-2.0
                    return allocationId.compareTo(other.allocationId);
                }
    @PublicApi(since = "1.0.0")  
    public List<Failure> getFailures() {
         */
import org.opensearch.core.common.io.stream.StreamInput;  
            super.writeTo(out);
            return new Failure(in);  
        return failures;  
        /**
            out.writeOptionalString(allocationId);  
     * @opensearch.api  
 * You may obtain a copy of the License at  
        }  
 * this work for additional information regarding copyright
                builder.startObject(Fields.STORE_EXCEPTION);  
        }
        }  
    public Map<String, Map<Integer, List<StoreStatus>>> getStoreStatuses() {  
        private Exception storeException;
                out.writeBoolean(true);  
        super(in);
         * {@link AllocationStatus#PRIMARY} indicates a primary shard copy
    public void writeTo(StreamOutput out) throws IOException {
             */  
 *  
        public StoreStatus(StreamInput in) throws IOException {
                        return "primary";
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                failure.toXContent(builder, params);  
     * @opensearch.api
 *     http://www.apache.org/licenses/LICENSE-2.0
         * used as a primary.  
            private static AllocationStatus fromId(byte id) {  
package org.opensearch.action.admin.indices.shards;
    public static class StoreStatus implements Writeable, ToXContentFragment, Comparable<StoreStatus> {
        }
            }
        /**
    }
            }  
        static final String FAILURES = "failures";
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
            public String value() {
            if (in.readBoolean()) {  
         */
        this.storeStatuses = Collections.unmodifiableMap(storeStatuses);
            builder.startArray(Fields.FAILURES);
                return 1;
         */
        static Failure readFailure(StreamInput in) throws IOException {
            } else if (allocationId == null && other.allocationId != null) {
     * Returns node {@link Failure}s encountered
         * @opensearch.api
            StreamOutput::writeString,
            node = new DiscoveryNode(in);  
        @PublicApi(since = "1.0.0")  
         * The allocationStatus status of the store.  
        public DiscoveryNode getNode() {  
        }  
 * KIND, either express or implied.  See the License for the
        static final String ALLOCATION_ID = "allocation_id";
            return nodeId;
            super(index, shardId, reason);
    }
            return allocationStatus;  
        this.failures = failures;  
            if (storeException != null) {
            this.storeException = storeException;  
        final Map<String, Map<Integer, List<StoreStatus>>> storeStatuses = in.readMap(  
 *
        failures = Collections.unmodifiableList(in.readList(Failure::readFailure));
            }
            builder.field("node", nodeId());
import java.util.Collections;
 *
 * Modifications Copyright OpenSearch Contributors. See
        private final AllocationStatus allocationStatus;
        }
        }  
        static final String SHARDS = "shards";
import org.opensearch.cluster.node.DiscoveryNode;
            StreamInput::readString,
        builder.endObject();
        public Exception getStoreException() {
@PublicApi(since = "1.0.0")
            this.nodeId = nodeId;
                return 1;
        @Override
        }  
            }  
import org.opensearch.common.annotation.PublicApi;  
            if (storeException != null && other.storeException == null) {  
            nodeId = in.readString();
         * Exception while trying to open the
        @Override
                        throw new IllegalArgumentException("unknown id for allocation status [" + id + "]");
        public AllocationStatus getAllocationStatus() {
         */
        static final String ALLOCATED = "allocation";
            builder.field(Fields.ALLOCATED, allocationStatus.value());
                return -1;  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
                switch (id) {
                if (compare == 0) {
 */
            if (allocationId != null) {
            }
                this.id = id;  
 * this file be licensed under the Apache-2.0 license or a
                out.writeBoolean(false);  
            out.writeString(nodeId);  
         * Node the store belongs to
                return -1;  
     *  
            private static AllocationStatus readFrom(StreamInput in) throws IOException {
    /**
                        return REPLICA;
        /**  
                }
                    builder.startObject();
                    case 0:  
            return super.innerToXContent(builder, params);  
            }
/**
import java.util.List;
                builder.endArray();  
        }  
import java.io.IOException;  
        }
     */
            allocationId = in.readOptionalString();
        private final DiscoveryNode node;
 * software distributed under the License is distributed on an
                    case 2:
import org.opensearch.core.xcontent.ToXContentFragment;  
        public enum AllocationStatus {
             */
        public String nodeId() {
            builder.endArray();
/*  
    /**  
        }
                        return "unused";
            }  
                }  
         * {@link AllocationStatus#REPLICA} indicates a replica shard copy
    public static class Failure extends DefaultShardOperationFailedException {  
                    storeStatus.toXContent(builder, params);  
        }
                out.writeException(storeException);
import org.opensearch.core.common.io.stream.StreamOutput;
    private final List<Failure> failures;
            /**  
    }
import org.opensearch.OpenSearchException;
    }
            } else if (other.storeException != null && storeException == null) {
        this.storeStatuses = Collections.unmodifiableMap(storeStatuses);
    @Override
    }
         * AllocationStatus id of the store, used to select the store that will be
                    case 1:
 *
                    case 2:  
}  
 * specific language governing permissions and limitations
            storeStatuses,  
            } else if (allocationId == null && other.allocationId == null) {  
/*  
            }
     *
            AllocationStatus(byte id) {
        public void writeTo(StreamOutput out) throws IOException {
                int compare = Integer.compare(allocationStatus.id, other.allocationStatus.id);  
    @PublicApi(since = "1.0.0")
                builder.endObject();
            allocationStatus.writeTo(out);
            }
         */  
 */  
            allocationStatus = AllocationStatus.readFrom(in);
                storeException = in.readException();
                    default:
                for (StoreStatus storeStatus : shardStatusesEntry.getValue()) {
    /**
 * indices and shard ids and a list of encountered node {@link Failure}s  
        @Override  
                    case 0:
        // StoreStatus fields
        public XContentBuilder innerToXContent(XContentBuilder builder, Params params) throws IOException {
        }
     * Shard store information from a node
    }
            this.node = node;  
 * license agreements. See the NOTICE file distributed with
            return builder;
        public int compareTo(StoreStatus other) {
                        return PRIMARY;  
    @Override  
    /**
            (o, v) -> o.writeMap(v, StreamOutput::writeInt, StreamOutput::writeCollection)
     */
 * the Apache License, Version 2.0 (the "License"); you may
            }
            } else {
        out.writeList(failures);
