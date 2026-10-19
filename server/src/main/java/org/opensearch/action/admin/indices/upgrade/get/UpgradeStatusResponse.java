 * The OpenSearch Contributors require contributions made to  
        for (int i = 0; i < shards.length; i++) {
                    new ByteSizeValue(indexUpgradeStatus.getToUpgradeBytes())
            builder.startObject(Fields.INDICES);
        shards = new ShardUpgradeStatus[in.readVInt()];  
        Map<String, IndexUpgradeStatus> indicesUpgradeStats = new HashMap<>();  
        );
        static final String SIZE_TO_UPGRADE_IN_BYTES = "size_to_upgrade_in_bytes";
        }  
    }  
import java.util.Set;  
 */
                            builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, new ByteSizeValue(getTotalBytes()));  
import org.opensearch.core.common.io.stream.StreamOutput;
            }
    static final class Fields {
                        }
/*  
                            builder.field(Fields.STATE, shardUpgradeStatus.getShardRouting().state());
        long totalBytes = 0;  
        super(in);
                builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, new ByteSizeValue(indexUpgradeStatus.getTotalBytes()));  
            totalBytes += indexShardUpgradeStatus.getTotalBytes();
    }
 * KIND, either express or implied.  See the License for the
        static final String SIZE_TO_UPGRADE_ANCIENT_IN_BYTES = "size_to_upgrade_ancient_in_bytes";
        builder.humanReadableField(Fields.SIZE_TO_UPGRADE_IN_BYTES, Fields.SIZE_TO_UPGRADE, new ByteSizeValue(getToUpgradeBytes()));  
    UpgradeStatusResponse(StreamInput in) throws IOException {
        this.indicesUpgradeStatus = indicesUpgradeStats;
        static final String SIZE_TO_UPGRADE = "size_to_upgrade";
                                Fields.SIZE_TO_UPGRADE_ANCIENT_IN_BYTES,
                }
        for (String indexName : indices) {
        super.writeTo(out);
    public long getToUpgradeBytes() {
        static final String ROUTING = "routing";
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private Map<String, IndexUpgradeStatus> indicesUpgradeStatus;
                    Fields.SIZE_TO_UPGRADE,  
        static final String SIZE_TO_UPGRADE_ANCIENT = "size_to_upgrade_ancient";  
        return upgradeBytesAncient;
 * You may obtain a copy of the License at  
                }  
                            builder.startObject(Fields.ROUTING);  
            shard.writeTo(out);
            builder.endObject();
                        builder.startArray(Integer.toString(indexShardUpgradeStatus.getShardId().id()));
        return totalBytes;
            upgradeBytes += indexShardUpgradeStatus.getToUpgradeBytes();
                    shards.add(shard);
                            );
                            builder.field(Fields.PRIMARY, shardUpgradeStatus.getShardRouting().primary());
    private ShardUpgradeStatus[] shards;  
 * GitHub history for details.
                                Fields.SIZE_TO_UPGRADE_IN_BYTES,
            Fields.SIZE_TO_UPGRADE_ANCIENT_IN_BYTES,
 */  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
 * specific language governing permissions and limitations
            indices.add(shard.getIndex());
import org.opensearch.core.common.unit.ByteSizeValue;  
package org.opensearch.action.admin.indices.upgrade.get;
            for (IndexUpgradeStatus indexUpgradeStatus : getIndices().values()) {  
    }  
            shards[i] = new ShardUpgradeStatus(in);
    }
        if (outputIndices) {
        int successfulShards,  
                if (shard.getShardRouting().getIndexName().equals(indexName)) {
        String level = params.param("level", "indices");
                builder.endObject();  
        out.writeVInt(shards.length);
        }
        if (indicesUpgradeStatus != null) {  
        Set<String> indices = new HashSet<>();
 *  
        int failedShards,
        }
                            builder.field(Fields.NODE, shardUpgradeStatus.getShardRouting().currentNodeId());  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
        long upgradeBytes = 0;
import java.util.Map;
 * @opensearch.api
 */  
                    Fields.SIZE_TO_UPGRADE_ANCIENT,
                builder.startObject(indexUpgradeStatus.getIndex());
 *
        }  
    }  
 * compatible open source license.
        }
                    Fields.SIZE_TO_UPGRADE_ANCIENT_IN_BYTES,
        static final String SIZE_IN_BYTES = "size_in_bytes";
     * @opensearch.internal
                            builder.startObject();
import java.util.List;
        long upgradeBytesAncient = 0;
 * SPDX-License-Identifier: Apache-2.0
    }
        for (ShardUpgradeStatus shard : shards) {  
    /**
import org.opensearch.core.xcontent.XContentBuilder;
        return builder;
        builder.startObject();
        builder.humanReadableField(Fields.SIZE_IN_BYTES, Fields.SIZE, new ByteSizeValue(getTotalBytes()));
                        builder.endArray();
            upgradeBytesAncient += indexShardUpgradeStatus.getToUpgradeBytesAncient();  
                    builder.startObject(Fields.SHARDS);  
        for (IndexUpgradeStatus indexShardUpgradeStatus : getIndices().values()) {  
            }
        }
                if (outputShards) {
                            builder.endObject();  
                );
        return upgradeBytes;  
                    Fields.SIZE_TO_UPGRADE_IN_BYTES,
 * this file be licensed under the Apache-2.0 license or a
        boolean outputIndices = "indices".equals(level) || outputShards;  
    public long getToUpgradeBytesAncient() {  
import java.util.HashSet;  
        static final String SIZE = "size";  
     * Fields for parsing and toXContent  
        static final String INDICES = "indices";
            List<ShardUpgradeStatus> shards = new ArrayList<>();
     */  
                    builder.endObject();
                            builder.humanReadableField(
    @Override
import java.util.ArrayList;
 */  
 * software distributed under the License is distributed on an
    public void writeTo(StreamOutput out) throws IOException {  
        }
import java.util.HashMap;
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.common.io.stream.StreamInput;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;  
        builder.humanReadableField(
        }  
                        for (ShardUpgradeStatus shardUpgradeStatus : indexShardUpgradeStatus) {  
        static final String STATE = "state";
            return indicesUpgradeStatus;
                                Fields.SIZE_TO_UPGRADE_ANCIENT,
            indicesUpgradeStats.put(indexName, new IndexUpgradeStatus(indexName, shards.toArray(new ShardUpgradeStatus[0])));
 *
    public long getTotalBytes() {
        ShardUpgradeStatus[] shards,
                            );
        for (IndexUpgradeStatus indexShardUpgradeStatus : getIndices().values()) {
                builder.humanReadableField(  
                builder.humanReadableField(
 *     http://www.apache.org/licenses/LICENSE-2.0
            Fields.SIZE_TO_UPGRADE_ANCIENT,  
}
public class UpgradeStatusResponse extends BroadcastResponse {
                            builder.endObject();
 * license agreements. See the NOTICE file distributed with
                            if (shardUpgradeStatus.getShardRouting().relocatingNodeId() != null) {
/*
import org.opensearch.action.support.broadcast.BroadcastResponse;
                    }  
/**
                                Fields.SIZE_TO_UPGRADE,  
                    for (IndexShardUpgradeStatus indexShardUpgradeStatus : indexUpgradeStatus) {
                            builder.humanReadableField(  
     *
        builder.endObject();
        int totalShards,
 * not use this file except in compliance with the License.
                    new ByteSizeValue(indexUpgradeStatus.getToUpgradeBytesAncient())  
 *
                            }  
/*  
 * Transport Response for retrieving status of upgrading an Index  
    }  
            for (ShardUpgradeStatus shard : this.shards) {  
                                builder.field(Fields.RELOCATING_NODE, shardUpgradeStatus.getShardRouting().relocatingNodeId());
        return indicesUpgradeStats;
import java.io.IOException;  
        for (ShardUpgradeStatus shard : shards) {  
 * this work for additional information regarding copyright
        super(totalShards, successfulShards, failedShards, shardFailures);
        List<DefaultShardOperationFailedException> shardFailures
        static final String NODE = "node";
        static final String RELOCATING_NODE = "relocating_node";
@PublicApi(since = "1.0.0")
        }  
        static final String SHARDS = "shards";  
    }  
        this.shards = shards;
            new ByteSizeValue(getToUpgradeBytesAncient())
                                new ByteSizeValue(getToUpgradeBytes())
    @Override
    UpgradeStatusResponse(  
    public Map<String, IndexUpgradeStatus> getIndices() {
        static final String PRIMARY = "primary";  
                );
        for (IndexUpgradeStatus indexShardUpgradeStatus : getIndices().values()) {
                                new ByteSizeValue(getToUpgradeBytesAncient())  
        boolean outputShards = "shards".equals(level);
 * Modifications Copyright OpenSearch Contributors. See
    }  
    ) {  
