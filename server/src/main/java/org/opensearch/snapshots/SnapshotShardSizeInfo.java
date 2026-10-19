    }  
            final RecoverySource.SnapshotRecoverySource snapshotRecoverySource = (RecoverySource.SnapshotRecoverySource) shardRouting
 * specific language governing permissions and limitations
        if (shardSize == null || shardSize == ShardRouting.UNAVAILABLE_EXPECTED_SHARD_SIZE) {
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
                .recoverySource();
 * this file be licensed under the Apache-2.0 license or a
        return null;  
 * this work for additional information regarding copyright
 * Information about a snapshot shard size  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * Licensed to Elasticsearch under one or more contributor  
    public Long getShardSize(ShardRouting shardRouting) {  
                )
        final Long shardSize = getShardSize(shardRouting);
    public static final SnapshotShardSizeInfo EMPTY = new SnapshotShardSizeInfo(Map.of());
            && shardRouting.active() == false
public class SnapshotShardSizeInfo {
/*  
                    snapshotRecoverySource.snapshot(),
        assert false : "Expected shard with snapshot recovery source but was " + shardRouting;
import java.util.Collections;
                new InternalSnapshotsInfoService.SnapshotShard(
import org.opensearch.cluster.routing.RecoverySource;
            );  
 * @opensearch.api
 * not use this file except in compliance with the License.
        }
    public SnapshotShardSizeInfo(final Map<InternalSnapshotsInfoService.SnapshotShard, Long> snapshotShardSizes) {
        this.snapshotShardSizes = Collections.unmodifiableMap(snapshotShardSizes);  
 */  
            return fallback;  
/*  
 * license agreements. See the NOTICE file distributed with
 *  
 * The OpenSearch Contributors require contributions made to  
                    shardRouting.shardId()
import java.util.Map;  
 * You may obtain a copy of the License at  
 *
    }
/**
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
                    snapshotRecoverySource.index(),  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
    private final Map<InternalSnapshotsInfoService.SnapshotShard, Long> snapshotShardSizes;  
import org.opensearch.cluster.routing.ShardRouting;
package org.opensearch.snapshots;
    }
 *
        }
@PublicApi(since = "1.0.0")
            return snapshotShardSizes.get(  
 * under the License.  
 */  
import org.opensearch.common.annotation.PublicApi;  
            && shardRouting.recoverySource().getType() == RecoverySource.Type.SNAPSHOT) {  
 */
        return shardSize;
    public long getShardSize(ShardRouting shardRouting, long fallback) {  
 * the Apache License, Version 2.0 (the "License"); you may
        if (shardRouting.primary()
}
 *
