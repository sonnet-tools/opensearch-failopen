 * @opensearch.api
                );
import java.io.IOException;
import java.util.Set;
        builder.humanReadableField(
    }
        Map<String, IndexUpgradeStatus> indicesUpgradeStats = new HashMap<>();
        int successfulShards,
    public void writeTo(StreamOutput out) throws IOException {
                    for (IndexShardUpgradeStatus indexShardUpgradeStatus : indexUpgradeStatus) {
    ) {
        boolean outputShards = "shards".equals(level);
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under
        long totalBytes = 0;
import java.util.HashSet;
                            builder.endObject();
        for (ShardUpgradeStatus shard : shards) {
public class UpgradeStatusResponse extends BroadcastResponse {
 * compatible open source license.
 * GitHub history for details.
                builder.humanReadableField(
        ShardUpgradeStatus[] shards,
                                Fields.SIZE_TO_UPGRADE_ANCIENT,
            return indicesUpgradeStatus;
                                new ByteSizeValue(getToUpgradeBytes())
                            }
            shards[i] = new ShardUpgradeStatus(in);
        out.writeVInt(shards.length);
        static final String PRIMARY = "primary";
        static final String NODE = "node";
     * @opensearch.internal
import org.opensearch.core.common.unit.ByteSizeValue;
                        }
                builder.endObject();
        if (indicesUpgradeStatus != null) {
        for (ShardUpgradeStatus shard : shards) {
    UpgradeStatusResponse(StreamInput in) throws IOException {
        static final String STATE = "state";
        boolean outputIndices = "indices".equals(level) || outputShards;
 *
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to
        }
        static final String SIZE = "size";
    }
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        static final String SIZE_TO_UPGRADE_ANCIENT_IN_BYTES = "size_to_upgrade_ancient_in_bytes";
                }
                            builder.startObject(Fields.ROUTING);
    }
        long upgradeBytesAncient = 0;
    @Override
        builder.humanReadableField(Fields.SIZE_TO_UPGRADE_IN_BYTES, Fields.SIZE_TO_UPGRADE, new ByteSizeValue(getToUpgradeBytes()));
 * not use this file except in compliance with the License.
                    new ByteSizeValue(indexUpgradeStatus.getToUpgradeBytesAncient())
 * the Apache License, Version 2.0 (the "License"); you may
    }
            Fields.SIZE_TO_UPGRADE_ANCIENT_IN_BYTES,
@PublicApi(since = "1.0.0")
 * under the License.
                    Fields.SIZE_TO_UPGRADE,
            indicesUpgradeStats.put(indexName, new IndexUpgradeStatus(indexName, shards.toArray(new ShardUpgradeStatus[0])));
     * Fields for parsing and toXContent
            for (IndexUpgradeStatus indexUpgradeStatus : getIndices().values()) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
                builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, new ByteSizeValue(indexUpgradeStatus.getTotalBytes()));
            totalBytes += indexShardUpgradeStatus.getTotalBytes();
                    builder.startObject(Fields.SHARDS);
                    }
     */
        return builder;
import org.opensearch.core.common.io.stream.StreamOutput;
                            builder.field(Fields.STATE, shardUpgradeStatus.getShardRouting().state());
 * Unless required by applicable law or agreed to in writing,
        for (String indexName : indices) {
        return upgradeBytes;
                            builder.field(Fields.NODE, shardUpgradeStatus.getShardRouting().currentNodeId());
                }
 * Modifications Copyright OpenSearch Contributors. See
                    builder.endObject();
 */
                                Fields.SIZE_TO_UPGRADE,
        }
 * specific language governing permissions and limitations
    }
/*
                    Fields.SIZE_TO_UPGRADE_ANCIENT,
import org.opensearch.common.annotation.PublicApi;
        this.shards = shards;
    public Map<String, IndexUpgradeStatus> getIndices() {
        int failedShards,
 */
        return indicesUpgradeStats;
        static final String SIZE_TO_UPGRADE = "size_to_upgrade";
}
import java.util.ArrayList;
        return upgradeBytesAncient;
        }
        for (IndexUpgradeStatus indexShardUpgradeStatus : getIndices().values()) {
/*
    UpgradeStatusResponse(
                            builder.field(Fields.PRIMARY, shardUpgradeStatus.getShardRouting().primary());
    }
        }
        static final String SIZE_TO_UPGRADE_ANCIENT = "size_to_upgrade_ancient";
 * Licensed to Elasticsearch under one or more contributor
                            builder.humanReadableField(
        builder.startObject();
        String level = params.param("level", "indices");
 * software distributed under the License is distributed on an
        this.indicesUpgradeStatus = indicesUpgradeStats;
        static final String SIZE_TO_UPGRADE_IN_BYTES = "size_to_upgrade_in_bytes";
        builder.endObject();
 * Transport Response for retrieving status of upgrading an Index
    static final class Fields {
        long upgradeBytes = 0;
        static final String SIZE_IN_BYTES = "size_in_bytes";
        }
                        for (ShardUpgradeStatus shardUpgradeStatus : indexShardUpgradeStatus) {
 * You may obtain a copy of the License at
        if (outputIndices) {
import org.opensearch.action.support.broadcast.BroadcastResponse;
        static final String RELOCATING_NODE = "relocating_node";
                    Fields.SIZE_TO_UPGRADE_IN_BYTES,
        builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, new ByteSizeValue(getTotalBytes()));
                                builder.field(Fields.RELOCATING_NODE, shardUpgradeStatus.getShardRouting().relocatingNodeId());
    /**
 *
                        builder.endArray();
        }
            }
                            );
                                Fields.SIZE_TO_UPGRADE_ANCIENT_IN_BYTES,
            builder.startObject(Fields.INDICES);
        super(totalShards, successfulShards, failedShards, shardFailures);
        for (IndexUpgradeStatus indexShardUpgradeStatus : getIndices().values()) {
                builder.startObject(indexUpgradeStatus.getIndex());
        int totalShards,
        static final String INDICES = "indices";
                builder.humanReadableField(
        static final String ROUTING = "routing";
import java.util.List;
            indices.add(shard.getIndex());
import java.util.HashMap;
            for (ShardUpgradeStatus shard : this.shards) {
            builder.endObject();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
 */
        List<DefaultShardOperationFailedException> shardFailures
    private ShardUpgradeStatus[] shards;
                            builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, new ByteSizeValue(getTotalBytes()));
        static final String SHARDS = "shards";
        );
    public long getTotalBytes() {
                if (shard.getShardRouting().getIndexName().equals(indexName)) {
                    Fields.SIZE_TO_UPGRADE_ANCIENT_IN_BYTES,
                );
        super(in);
 *
        super.writeTo(out);
                    new ByteSizeValue(indexUpgradeStatus.getToUpgradeBytes())
                            if (shardUpgradeStatus.getShardRouting().relocatingNodeId() != null) {
        }
                            builder.humanReadableField(
                if (outputShards) {
            upgradeBytesAncient += indexShardUpgradeStatus.getToUpgradeBytesAncient();
import org.opensearch.core.common.io.stream.StreamInput;
        Set<String> indices = new HashSet<>();
 * this file be licensed under the Apache-2.0 license or a
 */
        }
    private Map<String, IndexUpgradeStatus> indicesUpgradeStatus;
 * this work for additional information regarding copyright
            }
                    shards.add(shard);
                            builder.endObject();
            Fields.SIZE_TO_UPGRADE_ANCIENT,
        shards = new ShardUpgradeStatus[in.readVInt()];
        for (int i = 0; i < shards.length; i++) {
import java.util.Map;
        return totalBytes;
            new ByteSizeValue(getToUpgradeBytesAncient())
    public long getToUpgradeBytesAncient() {
    }
    public long getToUpgradeBytes() {
    }
package org.opensearch.action.admin.indices.upgrade.get;
                                new ByteSizeValue(getToUpgradeBytesAncient())
                        builder.startArray(Integer.toString(indexShardUpgradeStatus.getShardId().id()));
            upgradeBytes += indexShardUpgradeStatus.getToUpgradeBytes();
                            );
/*
     *
    @Override
                                Fields.SIZE_TO_UPGRADE_IN_BYTES,
            shard.writeTo(out);
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        for (IndexUpgradeStatus indexShardUpgradeStatus : getIndices().values()) {
            List<ShardUpgradeStatus> shards = new ArrayList<>();
 *
        }
                            builder.startObject();
