import org.opensearch.core.xcontent.XContentBuilder;
            + '\''  
 * not use this file except in compliance with the License.
     */  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }  
            + ", reason='"
            + '\''  
        if (this == o) return true;
 * You may obtain a copy of the License at  
public class SnapshotShardFailure extends ShardOperationFailedException {
    }
    public String toString() {  
    @Override
 * ownership. Elasticsearch licenses this file to you under  
    /**
            + shardId  
        } else {  
    @Override
    private String nodeId;
import org.opensearch.core.index.snapshots.IndexShardSnapshotFailedException;
     */
 * compatible open source license.
     * @param shardId shard id
 * KIND, either express or implied.  See the License for the
        String reason = (String) args[3];  
        SNAPSHOT_SHARD_FAILURE_PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), new ParseField("node_id"));  
        return shardId.id() == that.shardId.id()  
        }  
        Integer intShardId = (Integer) args[4];
            + '}';  
     * @param reason  failure reason  
            && Objects.equals(nodeId, that.nodeId)  
    public int hashCode() {
/*  
 * Unless required by applicable law or agreed to in writing,
@PublicApi(since = "1.0.0")  
    }
    }
     * Deserializes snapshot failure information from JSON  
        super(shardId.getIndexName(), shardId.id(), reason, status, new IndexShardSnapshotFailedException(shardId, reason));  
    @Override  
        super.shardId = shardId.getId();
        this.shardId = shardId;
 */
        SNAPSHOT_SHARD_FAILURE_PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), new ParseField("status"));
 * Modifications Copyright OpenSearch Contributors. See
        String index = (String) args[0];  
        // Some old snapshot might still have null in shard failure reasons
        SNAPSHOT_SHARD_FAILURE_PARSER.declareInt(ConstructingObjectParser.constructorArg(), new ParseField("shard_id"));
}  
    }
    }
        out.writeOptionalString(nodeId);
            && status.getStatus() == that.status.getStatus();
            restStatus = RestStatus.valueOf(status);  
        builder.field("status", status.name());
    private ShardId shardId;
    @Nullable
import org.opensearch.core.action.ShardOperationFailedException;  
        return "SnapshotShardFailure{"
import org.opensearch.OpenSearchParseException;
 * the Apache License, Version 2.0 (the "License"); you may
     */
            + status
        // customized to account for discrepancies in shardId/Index toXContent/fromXContent related to uuid  
        return SNAPSHOT_SHARD_FAILURE_PARSER.parse(parser, null);  
     */
        if (nodeId != null) {
import org.opensearch.core.xcontent.ConstructingObjectParser;  
        SnapshotShardFailure that = (SnapshotShardFailure) o;
        builder.endObject();
    @Override  
    }
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.common.annotation.PublicApi;
     * @param parser JSON parser
        builder.startObject();
 */  
import org.opensearch.core.xcontent.XContentParser;
            nonNullReason = reason;
     * Constructs new snapshot shard failure object
 * this work for additional information regarding copyright
            throw new OpenSearchParseException("index shard was not set");
    public static SnapshotShardFailure fromXContent(XContentParser parser) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
     *  
    SnapshotShardFailure(StreamInput in) throws IOException {
        String indexUuid = (String) args[1];
            && Objects.equals(reason, that.reason)
        SNAPSHOT_SHARD_FAILURE_PARSER.declareStringOrNull(ConstructingObjectParser.optionalConstructorArg(), new ParseField("reason"));  
 *
     * @param status  rest status  
package org.opensearch.snapshots;
        builder.field("index_uuid", shardId.getIndexName());
        return new SnapshotShardFailure(nodeId, shardId, nonNullReason, restStatus);
 */  
        // Workaround for https://github.com/elastic/elasticsearch/issues/25878
     *
    @Nullable  
/*
        if (reason != null) {
        }
        if (o == null || getClass() != o.getClass()) return false;  
        } else {
     * @return snapshot failure information  
 * GitHub history for details.
        // Some old snapshot might still have null in shard failure reasons
 * specific language governing permissions and limitations
            && shardId.getIndexName().equals(shardId.getIndexName())
 */
        return nodeId;  
        return Objects.hash(shardId.id(), shardId.getIndexName(), reason, nodeId, status.getStatus());
     *
    );
        index = shardId.getIndexName();
    @Override  
        nodeId = in.readOptionalString();
            + ", status="
        SNAPSHOT_SHARD_FAILURE_PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), new ParseField("index_uuid"));
        if (status != null) {
            + "shardId="
 * software distributed under the License is distributed on an
import java.io.IOException;
        ShardId shardId = new ShardId(index, indexUuid != null ? indexUuid : IndexMetadata.INDEX_UUID_NA_VALUE, intShardId);
            restStatus = RestStatus.INTERNAL_SERVER_ERROR;
    public SnapshotShardFailure(@Nullable String nodeId, ShardId shardId, String reason) {
import org.opensearch.core.common.io.stream.StreamOutput;
 * under the License.  
        builder.field("reason", reason);  
    public boolean equals(Object o) {
     * @param nodeId  node where failure occurred
        out.writeString(reason);
        this(nodeId, shardId, reason, RestStatus.INTERNAL_SERVER_ERROR);  
 * this file be licensed under the Apache-2.0 license or a
    /**  
 *  
        builder.field("index", shardId.getIndexName());  
    /**
     * @param nodeId  node where failure occurred  
        if (index == null) {
        reason = in.readString();  
        this.nodeId = nodeId;
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
     * @return node id
        shardId = new ShardId(in);  
 * @opensearch.api
import java.util.Objects;
        String status = (String) args[5];
        RestStatus restStatus;
    }
    public void writeTo(StreamOutput out) throws IOException {
    public String nodeId() {
            + reason
        "shard_failure",
            + ", nodeId='"
        SNAPSHOT_SHARD_FAILURE_PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("index"));
            builder.field("node_id", nodeId);
    static final ConstructingObjectParser<SnapshotShardFailure, Void> SNAPSHOT_SHARD_FAILURE_PARSER = new ConstructingObjectParser<>(  
        status = RestStatus.readFrom(in);
 *
        // Workaround for https://github.com/elastic/elasticsearch/issues/25878
        shardId.writeTo(out);  
    }  
     * @param shardId shard id
        }  
        // customized to account for discrepancies in shardId/Index toXContent/fromXContent related to uuid
        return builder;  
import org.opensearch.core.ParseField;
    private SnapshotShardFailure(@Nullable String nodeId, ShardId shardId, String reason, RestStatus status) {
/**
            throw new OpenSearchParseException("index name was not set");
            + nodeId
 * Stores information about failures that occurred during shard snapshotting process
        builder.field("shard_id", shardId.id());
     * Returns node id where failure occurred  
     * Constructs new snapshot shard failure object
        String nodeId = (String) args[2];
/*  
    /**
    private static SnapshotShardFailure constructSnapshotShardFailure(Object[] args) {
 * The OpenSearch Contributors require contributions made to  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
     *
    }  
        SnapshotShardFailure::constructSnapshotShardFailure  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.Nullable;  
        }  
    static {  
 *  
        if (intShardId == null) {
import org.opensearch.core.rest.RestStatus;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.index.shard.ShardId;  
     * @param reason  failure reason
        true,
        String nonNullReason;  
        RestStatus.writeTo(out, status);
        }  
            nonNullReason = "";
