        shardId = new ShardId(in);
        index = shardId.getIndexName();
import org.opensearch.core.common.io.stream.StreamOutput;
    }
    SnapshotShardFailure(StreamInput in) throws IOException {
        return new SnapshotShardFailure(nodeId, shardId, nonNullReason, restStatus);
import org.opensearch.core.index.snapshots.IndexShardSnapshotFailedException;
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor
            && Objects.equals(nodeId, that.nodeId)
    @Override
        } else {
package org.opensearch.snapshots;
import org.opensearch.core.xcontent.XContentParser;
    /**
            + ", nodeId='"
    static {
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
    /**
     * @return node id
            + "shardId="
import org.opensearch.cluster.metadata.IndexMetadata;
        }
 *
            && status.getStatus() == that.status.getStatus();
        String nonNullReason;
     */
        builder.field("reason", reason);
        SNAPSHOT_SHARD_FAILURE_PARSER.declareStringOrNull(ConstructingObjectParser.optionalConstructorArg(), new ParseField("reason"));
    /**
    @Nullable
            && Objects.equals(reason, that.reason)
import java.io.IOException;
            + '}';
 */
        "shard_failure",
/**
     *
    }
     *
 * Unless required by applicable law or agreed to in writing,
    }
import org.opensearch.OpenSearchParseException;
        shardId.writeTo(out);
    public int hashCode() {
        ShardId shardId = new ShardId(index, indexUuid != null ? indexUuid : IndexMetadata.INDEX_UUID_NA_VALUE, intShardId);
 * Modifications Copyright OpenSearch Contributors. See
        reason = in.readString();
import java.util.Objects;
            + shardId
 */
        builder.field("status", status.name());
import org.opensearch.core.common.io.stream.StreamInput;
        true,
     * @return snapshot failure information
        }
import org.opensearch.core.rest.RestStatus;
        }
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
     *
}
        out.writeOptionalString(nodeId);
     * Deserializes snapshot failure information from JSON
 * @opensearch.api
     */
        if (o == null || getClass() != o.getClass()) return false;
    public SnapshotShardFailure(@Nullable String nodeId, ShardId shardId, String reason) {
    /**
 * this work for additional information regarding copyright
        status = RestStatus.readFrom(in);
        // customized to account for discrepancies in shardId/Index toXContent/fromXContent related to uuid
        builder.endObject();
        builder.startObject();
        builder.field("index_uuid", shardId.getIndexName());
     * Constructs new snapshot shard failure object
     */
    }
    @Override
            throw new OpenSearchParseException("index shard was not set");
     * Returns node id where failure occurred
            + status
 * You may obtain a copy of the License at
        return Objects.hash(shardId.id(), shardId.getIndexName(), reason, nodeId, status.getStatus());
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        SNAPSHOT_SHARD_FAILURE_PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("index"));
            restStatus = RestStatus.INTERNAL_SERVER_ERROR;
        RestStatus restStatus;
 * compatible open source license.
        RestStatus.writeTo(out, status);
        nodeId = in.readOptionalString();
 * under the License.
            restStatus = RestStatus.valueOf(status);
     */
 *
     * @param parser JSON parser
     * @param reason  failure reason
    private static SnapshotShardFailure constructSnapshotShardFailure(Object[] args) {
        return nodeId;
    @Nullable
    }
        this.shardId = shardId;
        SnapshotShardFailure that = (SnapshotShardFailure) o;
 * ownership. Elasticsearch licenses this file to you under
            builder.field("node_id", nodeId);
        builder.field("index", shardId.getIndexName());
        return shardId.id() == that.shardId.id()
import org.opensearch.core.action.ShardOperationFailedException;
            + '\''
 * not use this file except in compliance with the License.
        super.shardId = shardId.getId();
    }
     * @param status  rest status
        if (intShardId == null) {
        SnapshotShardFailure::constructSnapshotShardFailure
        Integer intShardId = (Integer) args[4];
    }
    private SnapshotShardFailure(@Nullable String nodeId, ShardId shardId, String reason, RestStatus status) {
        // Some old snapshot might still have null in shard failure reasons
        if (index == null) {
        if (reason != null) {
            + '\''
    }
    }
            + nodeId
    public boolean equals(Object o) {
        // Some old snapshot might still have null in shard failure reasons
    );
@PublicApi(since = "1.0.0")
        String indexUuid = (String) args[1];
import org.opensearch.common.Nullable;
        String reason = (String) args[3];
     * @param nodeId  node where failure occurred
    @Override
    }
            + ", status="
        // Workaround for https://github.com/elastic/elasticsearch/issues/25878
     * Constructs new snapshot shard failure object
import org.opensearch.core.xcontent.ConstructingObjectParser;
    public void writeTo(StreamOutput out) throws IOException {
    public static SnapshotShardFailure fromXContent(XContentParser parser) throws IOException {
        return "SnapshotShardFailure{"
    @Override
     * @param shardId shard id
    private String nodeId;
import org.opensearch.common.annotation.PublicApi;
        }
    }
        builder.field("shard_id", shardId.id());
    static final ConstructingObjectParser<SnapshotShardFailure, Void> SNAPSHOT_SHARD_FAILURE_PARSER = new ConstructingObjectParser<>(
        } else {
    private ShardId shardId;
        return SNAPSHOT_SHARD_FAILURE_PARSER.parse(parser, null);
/*
    }
        // customized to account for discrepancies in shardId/Index toXContent/fromXContent related to uuid
        String status = (String) args[5];
            nonNullReason = "";
        SNAPSHOT_SHARD_FAILURE_PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), new ParseField("node_id"));
 * specific language governing permissions and limitations
        SNAPSHOT_SHARD_FAILURE_PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), new ParseField("index_uuid"));
        out.writeString(reason);
            + ", reason='"
        SNAPSHOT_SHARD_FAILURE_PARSER.declareInt(ConstructingObjectParser.constructorArg(), new ParseField("shard_id"));
import org.opensearch.core.xcontent.XContentBuilder;
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
    public String toString() {
    public String nodeId() {
public class SnapshotShardFailure extends ShardOperationFailedException {
            && shardId.getIndexName().equals(shardId.getIndexName())
 * GitHub history for details.
        return builder;
        String index = (String) args[0];
        if (nodeId != null) {
import org.opensearch.core.index.shard.ShardId;
            throw new OpenSearchParseException("index name was not set");
 * The OpenSearch Contributors require contributions made to
     *
import org.opensearch.core.ParseField;
 *
    @Override
/*
        SNAPSHOT_SHARD_FAILURE_PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), new ParseField("status"));
     * @param shardId shard id
        String nodeId = (String) args[2];
     * @param nodeId  node where failure occurred
        // Workaround for https://github.com/elastic/elasticsearch/issues/25878
            nonNullReason = reason;
 *
        if (this == o) return true;
        this.nodeId = nodeId;
 * Stores information about failures that occurred during shard snapshotting process
     * @param reason  failure reason
        this(nodeId, shardId, reason, RestStatus.INTERNAL_SERVER_ERROR);
 */
            + reason
        if (status != null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        super(shardId.getIndexName(), shardId.id(), reason, status, new IndexShardSnapshotFailedException(shardId, reason));
 */
        }
/*
