        static final String REASON = "reason";
        if (stage != that.stage) return false;
    }
     */
                    "failed to parse snapshot index shard status [{}], expected numeric shard id but got [{}]",
import org.opensearch.core.xcontent.ToXContentFragment;
                break;
                String nodeId = (String) parsedObjects[i++];
    }
    public boolean equals(Object o) {
        return builder;
        switch (indexShardStatus.getStage()) {
        ConstructingObjectParser<SnapshotIndexShardStatus, ShardId> innerParser = new ConstructingObjectParser<>(
    public int hashCode() {
    public SnapshotIndexShardStatus(StreamInput in) throws IOException {
 * Status for snapshotting an Index Shard
    }
 * the Apache License, Version 2.0 (the "License"); you may
        super.writeTo(out);
import org.opensearch.core.ParseField;
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;
    private SnapshotStats stats;
import org.opensearch.core.xcontent.ObjectParser;
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
        );
     */
/*
    SnapshotIndexShardStatus(ShardId shardId, IndexShardSnapshotStatus.Copy indexShardStatus) {
     * @opensearch.internal
        SnapshotIndexShardStatus that = (SnapshotIndexShardStatus) o;
    }
        this.nodeId = nodeId;
    }
    }
                stage = SnapshotIndexShardStage.FINALIZE;
        }
 *
    SnapshotIndexShardStatus(ShardId shardId, SnapshotIndexShardStage stage, SnapshotStats stats, String nodeId, String failure) {
            case FINALIZE:
            true,
        return nodeId;
    private String failure;
import org.opensearch.core.index.Index;
                    shardName
        nodeId = in.readOptionalString();
import org.opensearch.OpenSearchParseException;
        result = 31 * result + (nodeId != null ? nodeId.hashCode() : 0);
        super(shardId);
            indexShardStatus.getIncrementalSize(),
     */
    public SnapshotStats getStats() {
                        rawStage
            return innerParser.parse(p, shardId);
        innerParser.declareObject(constructorArg(), (p, c) -> SnapshotStats.fromXContent(p), new ParseField(SnapshotStats.Fields.STATS));
                    stage = SnapshotIndexShardStage.valueOf(rawStage);
    /**
        stage = SnapshotIndexShardStage.fromValue(in.readByte());
 *
import org.opensearch.core.xcontent.XContentParserUtils;
 * Modifications Copyright OpenSearch Contributors. See
/**
            indexShardStatus.getTotalFileCount(),
        this.stats = stats;
            "snapshot_index_shard_status",
                int i = 0;
            }
                        shard.getId(),
        builder.field(SnapshotStats.Fields.STATS, stats, params);
    }
            case FAILURE:
 * @opensearch.api
 * ownership. Elasticsearch licenses this file to you under
                stage = SnapshotIndexShardStage.INIT;
    /**
                        shard.getIndex().getName(),
 * this file be licensed under the Apache-2.0 license or a
    /**
package org.opensearch.action.admin.cluster.snapshots.status;
        if (stats != null ? !stats.equals(that.stats) : that.stats != null) return false;
                } catch (IllegalArgumentException iae) {
    @Override
import org.opensearch.action.support.broadcast.BroadcastShardResponse;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void writeTo(StreamOutput out) throws IOException {
            }
    private SnapshotIndexShardStage stage = SnapshotIndexShardStage.INIT;
 * Licensed to Elasticsearch under one or more contributor
                SnapshotStats stats = (SnapshotStats) parsedObjects[i];
 * You may obtain a copy of the License at
                throw new IllegalArgumentException("Unknown stage type " + indexShardStatus.getStage());
        stats.writeTo(out);
    public String getNodeId() {
        int result = stage != null ? stage.hashCode() : 0;
        return PARSER.parse(parser, indexId, parser.currentName());
@PublicApi(since = "1.0.0")
                return new SnapshotIndexShardStatus(shard, stage, stats, nodeId, failure);
                shard = Integer.parseInt(shardName);
        );
     */
 * specific language governing permissions and limitations
            default:
            indexShardStatus.getProcessedSize()
            ShardId shardId = new ShardId(new Index(indexId, IndexMetadata.INDEX_UUID_NA_VALUE), shard);
                SnapshotIndexShardStage stage;
        result = 31 * result + (failure != null ? failure.hashCode() : 0);
        this.stage = stage;
        return stage;
        static final String STAGE = "stage";
    SnapshotIndexShardStatus(ShardId shardId, IndexShardSnapshotStatus.Copy indexShardStatus, String nodeId) {
        };
    /**
                    throw new OpenSearchParseException(
            int shard;
                break;
 *
                String failure = (String) parsedObjects[i++];
import org.opensearch.core.index.shard.ShardId;
        return failure != null ? failure.equals(that.failure) : that.failure == null;
        super(shardId);
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * Returns snapshot stage
        super(in);
/*
import org.opensearch.core.common.io.stream.StreamInput;
                break;
        this(shardId, indexShardStatus, null);
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.currentToken(), parser);
        result = 31 * result + (stats != null ? stats.hashCode() : 0);
 */
                String rawStage = (String) parsedObjects[i++];
    }
        }
            builder.field(Fields.NODE, getNodeId());
                stage = SnapshotIndexShardStage.FAILURE;
     * Inner Fields used for creating XContent and parsing
 * GitHub history for details.
    }
    }
            try {
 * Unless required by applicable law or agreed to in writing,
    @Override
 * The OpenSearch Contributors require contributions made to
 * compatible open source license.
            case STARTED:
        return result;
    }
     */
                }
    static final ObjectParser.NamedObjectParser<SnapshotIndexShardStatus, String> PARSER;
 * under the License.
        return failure;
    @Override
            case INIT:
        if (o == null || getClass() != o.getClass()) return false;
    }
            indexShardStatus.getTotalTime(),
/*
 *
                break;
import org.opensearch.common.annotation.PublicApi;
 */
            indexShardStatus.getTotalSize(),
        }
    SnapshotIndexShardStatus(ShardId shardId, SnapshotIndexShardStage stage) {
                    );
import org.opensearch.core.xcontent.XContentBuilder;
        this.stats = new SnapshotStats();
        this.stats = new SnapshotStats(
        innerParser.declareString(constructorArg(), new ParseField(Fields.STAGE));
            // into a ShardId to pass as context for the inner parser.
        failure = in.readOptionalString();
        super(shardId);
    public String getFailure() {
                );
        out.writeByte(stage.value());
            indexShardStatus.getProcessedFileCount(),
    }
            indexShardStatus.getStartTime(),
     * Returns reason for snapshot failure
 * not use this file except in compliance with the License.
            // Combine the index name in the context with the shard name passed in for the named object parser
    public static SnapshotIndexShardStatus fromXContent(XContentParser parser, String indexId) throws IOException {
        out.writeOptionalString(failure);
 */
            (Object[] parsedObjects, ShardId shard) -> {
        return stats;
        if (getNodeId() != null) {
                stage = SnapshotIndexShardStage.DONE;
        builder.startObject(Integer.toString(getShardId().getId()));
import org.opensearch.core.xcontent.XContentParser;
            } catch (NumberFormatException nfe) {
        this.failure = failure;
                        "failed to parse snapshot index shard status [{}][{}], unknown stage [{}]",
        stats = new SnapshotStats(in);
                throw new OpenSearchParseException(
        PARSER = (p, indexId, shardName) -> {
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
        builder.endObject();
import java.io.IOException;
 */
import org.opensearch.core.common.io.stream.StreamOutput;
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (nodeId != null ? !nodeId.equals(that.nodeId) : that.nodeId != null) return false;
            indexShardStatus.getIncrementalFileCount(),
        static final String NODE = "node";
        builder.field(Fields.STAGE, getStage());
            builder.field(Fields.REASON, getFailure());
        out.writeOptionalString(nodeId);
                break;
public class SnapshotIndexShardStatus extends BroadcastShardResponse implements ToXContentFragment {
        this.stage = stage;
        innerParser.declareString(optionalConstructorArg(), new ParseField(Fields.REASON));
 * KIND, either express or implied.  See the License for the
        this.failure = indexShardStatus.getFailure();
     *
}
                stage = SnapshotIndexShardStage.STARTED;
 * software distributed under the License is distributed on an
                try {
        innerParser.declareString(optionalConstructorArg(), new ParseField(Fields.NODE));
    }
    /**
     * Returns node id of the node where snapshot is currently running
    public SnapshotIndexShardStage getStage() {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.ConstructingObjectParser;
    static final class Fields {
            case DONE:
        if (getFailure() != null) {
    @Override
    }
    static {
     * Returns snapshot stats
        if (this == o) return true;
        this.nodeId = nodeId;
                    indexId,
    private String nodeId;
