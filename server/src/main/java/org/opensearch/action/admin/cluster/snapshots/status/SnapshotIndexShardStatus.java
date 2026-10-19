            case FAILURE:  
@PublicApi(since = "1.0.0")
        super.writeTo(out);
 *  
    public void writeTo(StreamOutput out) throws IOException {  
        out.writeOptionalString(nodeId);
                    shardName
            return innerParser.parse(p, shardId);  
 * specific language governing permissions and limitations
                throw new IllegalArgumentException("Unknown stage type " + indexShardStatus.getStage());
        }
            } catch (NumberFormatException nfe) {
        failure = in.readOptionalString();
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
        return nodeId;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.index.snapshots.IndexShardSnapshotStatus;
import org.opensearch.OpenSearchParseException;
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
                stage = SnapshotIndexShardStage.STARTED;
    private String failure;
        this(shardId, indexShardStatus, null);  
import org.opensearch.core.common.io.stream.StreamOutput;
    }  
        PARSER = (p, indexId, shardName) -> {
        ConstructingObjectParser<SnapshotIndexShardStatus, ShardId> innerParser = new ConstructingObjectParser<>(  
import org.opensearch.core.ParseField;
     */
    /**
                return new SnapshotIndexShardStatus(shard, stage, stats, nodeId, failure);  
            indexShardStatus.getIncrementalSize(),  
        this.nodeId = nodeId;  
import org.opensearch.core.xcontent.ToXContentFragment;  
        innerParser.declareString(optionalConstructorArg(), new ParseField(Fields.NODE));
    static final class Fields {
            "snapshot_index_shard_status",
    public boolean equals(Object o) {
                        shard.getId(),
        static final String STAGE = "stage";
        stats = new SnapshotStats(in);  
    }  
                stage = SnapshotIndexShardStage.INIT;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    SnapshotIndexShardStatus(ShardId shardId, SnapshotIndexShardStage stage) {
    }
 * You may obtain a copy of the License at  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
    /**
import org.opensearch.core.common.io.stream.StreamInput;  
            // into a ShardId to pass as context for the inner parser.  
import org.opensearch.core.index.Index;
     * @opensearch.internal
import org.opensearch.core.index.shard.ShardId;  
                    "failed to parse snapshot index shard status [{}], expected numeric shard id but got [{}]",  
    SnapshotIndexShardStatus(ShardId shardId, SnapshotIndexShardStage stage, SnapshotStats stats, String nodeId, String failure) {
     */  
    @Override
            ShardId shardId = new ShardId(new Index(indexId, IndexMetadata.INDEX_UUID_NA_VALUE), shard);
        result = 31 * result + (failure != null ? failure.hashCode() : 0);  
     * Inner Fields used for creating XContent and parsing  
            case STARTED:  
}  
            (Object[] parsedObjects, ShardId shard) -> {  
 * Modifications Copyright OpenSearch Contributors. See
     * Returns snapshot stats  
        this.stats = new SnapshotStats(  
        out.writeByte(stage.value());
            builder.field(Fields.REASON, getFailure());
    public SnapshotStats getStats() {
import org.opensearch.core.xcontent.XContentParserUtils;  
            try {
        return stage;
    private String nodeId;
    public int hashCode() {
        static final String REASON = "reason";  
            indexShardStatus.getTotalFileCount(),
        return PARSER.parse(parser, indexId, parser.currentName());  
        if (this == o) return true;
    SnapshotIndexShardStatus(ShardId shardId, IndexShardSnapshotStatus.Copy indexShardStatus) {
    static final ObjectParser.NamedObjectParser<SnapshotIndexShardStatus, String> PARSER;
    /**
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
            true,
    }
                        "failed to parse snapshot index shard status [{}][{}], unknown stage [{}]",  
            indexShardStatus.getIncrementalFileCount(),  
    }
public class SnapshotIndexShardStatus extends BroadcastShardResponse implements ToXContentFragment {
    }  
        if (getFailure() != null) {  
        innerParser.declareObject(constructorArg(), (p, c) -> SnapshotStats.fromXContent(p), new ParseField(SnapshotStats.Fields.STATS));  
            builder.field(Fields.NODE, getNodeId());
                } catch (IllegalArgumentException iae) {
                    );
        if (stats != null ? !stats.equals(that.stats) : that.stats != null) return false;
                SnapshotIndexShardStage stage;
    @Override
        return builder;
                shard = Integer.parseInt(shardName);  
        );
 * this file be licensed under the Apache-2.0 license or a
            int shard;
        return result;
        innerParser.declareString(optionalConstructorArg(), new ParseField(Fields.REASON));
import java.io.IOException;  
import org.opensearch.action.support.broadcast.BroadcastShardResponse;
    }
        if (stage != that.stage) return false;
                }
                );  
    }
/**
        builder.startObject(Integer.toString(getShardId().getId()));  
            }
            default:  
        this.stats = stats;
        if (o == null || getClass() != o.getClass()) return false;  
                break;
/*  
        );  
                break;
    public static SnapshotIndexShardStatus fromXContent(XContentParser parser, String indexId) throws IOException {
        result = 31 * result + (stats != null ? stats.hashCode() : 0);
                break;
                throw new OpenSearchParseException(
                stage = SnapshotIndexShardStage.DONE;
 * ownership. Elasticsearch licenses this file to you under  
    /**
    @Override
     */  
        stats.writeTo(out);  
            case INIT:  
                try {
     * Returns snapshot stage
    public String getFailure() {
 * @opensearch.api
     */
            // Combine the index name in the context with the shard name passed in for the named object parser
    }
    SnapshotIndexShardStatus(ShardId shardId, IndexShardSnapshotStatus.Copy indexShardStatus, String nodeId) {  
            indexShardStatus.getStartTime(),
 */  
    }  
        stage = SnapshotIndexShardStage.fromValue(in.readByte());
        int result = stage != null ? stage.hashCode() : 0;  
            indexShardStatus.getProcessedSize()
                    stage = SnapshotIndexShardStage.valueOf(rawStage);  
 * Unless required by applicable law or agreed to in writing,
    @Override  
        builder.field(Fields.STAGE, getStage());
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
    static {
                        shard.getIndex().getName(),
        super(shardId);  
                String failure = (String) parsedObjects[i++];
 * The OpenSearch Contributors require contributions made to  
        SnapshotIndexShardStatus that = (SnapshotIndexShardStatus) o;
        builder.field(SnapshotStats.Fields.STATS, stats, params);
    }  
        result = 31 * result + (nodeId != null ? nodeId.hashCode() : 0);
 * the Apache License, Version 2.0 (the "License"); you may
        static final String NODE = "node";
 * software distributed under the License is distributed on an
                        rawStage  
        super(in);
    public SnapshotIndexShardStage getStage() {
                String rawStage = (String) parsedObjects[i++];
        out.writeOptionalString(failure);
 * GitHub history for details.
package org.opensearch.action.admin.cluster.snapshots.status;
 *
        this.failure = failure;
                String nodeId = (String) parsedObjects[i++];  
/*  
        };
     * Returns node id of the node where snapshot is currently running
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.FIELD_NAME, parser.currentToken(), parser);
        }
        builder.endObject();  
                break;
                stage = SnapshotIndexShardStage.FAILURE;
 *
            indexShardStatus.getTotalTime(),
        super(shardId);  
        super(shardId);
            case DONE:  
import org.opensearch.cluster.metadata.IndexMetadata;  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.xcontent.XContentParser;
     *
    private SnapshotIndexShardStage stage = SnapshotIndexShardStage.INIT;
        return failure;
            indexShardStatus.getTotalSize(),
    }
 * Status for snapshotting an Index Shard  
                stage = SnapshotIndexShardStage.FINALIZE;
        this.stage = stage;
 * Licensed to Elasticsearch under one or more contributor  
            case FINALIZE:  
import org.opensearch.core.xcontent.ConstructingObjectParser;
import org.opensearch.core.xcontent.ObjectParser;
                    throw new OpenSearchParseException(
    /**  
            }
                    indexId,
        this.nodeId = nodeId;
        this.stage = stage;
        this.stats = new SnapshotStats();
                SnapshotStats stats = (SnapshotStats) parsedObjects[i];
 */  
        }
            indexShardStatus.getProcessedFileCount(),
/*
        return failure != null ? failure.equals(that.failure) : that.failure == null;
    }
                int i = 0;
     */  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public String getNodeId() {  
    }  
        innerParser.declareString(constructorArg(), new ParseField(Fields.STAGE));  
    private SnapshotStats stats;  
        return stats;  
        switch (indexShardStatus.getStage()) {
        if (nodeId != null ? !nodeId.equals(that.nodeId) : that.nodeId != null) return false;  
    }
 * not use this file except in compliance with the License.
        if (getNodeId() != null) {  
    }
     * Returns reason for snapshot failure
 */  
                break;
        nodeId = in.readOptionalString();
        this.failure = indexShardStatus.getFailure();
    public SnapshotIndexShardStatus(StreamInput in) throws IOException {  
 * this work for additional information regarding copyright
 */
