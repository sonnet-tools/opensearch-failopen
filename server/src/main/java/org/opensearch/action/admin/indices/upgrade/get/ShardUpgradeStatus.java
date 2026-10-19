    }  
 * the Apache License, Version 2.0 (the "License"); you may
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
/*  
 * Unless required by applicable law or agreed to in writing,
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public long getToUpgradeBytes() {
import org.opensearch.common.annotation.PublicApi;  
    }
    private long toUpgradeBytes;  
 * @opensearch.api  
 * not use this file except in compliance with the License.
}  
package org.opensearch.action.admin.indices.upgrade.get;
import org.opensearch.core.common.io.stream.StreamOutput;
 * You may obtain a copy of the License at  
    }
        return toUpgradeBytes;  
/**  
 * Modifications Copyright OpenSearch Contributors. See
    }
/*
        this.shardRouting = shardRouting;
        totalBytes = in.readLong();
 * license agreements. See the NOTICE file distributed with
    public ShardUpgradeStatus(StreamInput in) throws IOException {
    public long getToUpgradeBytesAncient() {  
 * GitHub history for details.
        out.writeLong(toUpgradeBytesAncient);
 * KIND, either express or implied.  See the License for the
    private long toUpgradeBytesAncient;
        shardRouting = new ShardRouting(in);  
/*  
 * SPDX-License-Identifier: Apache-2.0
        return toUpgradeBytesAncient;
        toUpgradeBytes = in.readLong();
        super.writeTo(out);  
        out.writeLong(toUpgradeBytes);  
    public ShardRouting getShardRouting() {  
        return this.shardRouting;
 */
 *
    }
 *  
    private long totalBytes;
        toUpgradeBytesAncient = in.readLong();  
    public long getTotalBytes() {
import org.opensearch.cluster.routing.ShardRouting;
 * under the License.  
 * Status for a Shard Upgrade
 *     http://www.apache.org/licenses/LICENSE-2.0
    ShardUpgradeStatus(ShardRouting shardRouting, long totalBytes, long toUpgradeBytes, long upgradeBytesAncient) {  
 * this file be licensed under the Apache-2.0 license or a
        super(in);
        shardRouting.writeTo(out);
        out.writeLong(totalBytes);
        this.toUpgradeBytesAncient = upgradeBytesAncient;
 */
public class ShardUpgradeStatus extends BroadcastShardResponse {  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
@PublicApi(since = "1.0.0")
    private ShardRouting shardRouting;
        this.totalBytes = totalBytes;  
 * this work for additional information regarding copyright
 *
    }
 *
import java.io.IOException;
 * specific language governing permissions and limitations
        this.toUpgradeBytes = toUpgradeBytes;
        return totalBytes;
 * software distributed under the License is distributed on an
import org.opensearch.action.support.broadcast.BroadcastShardResponse;
 * Licensed to Elasticsearch under one or more contributor  
    @Override
        super(shardRouting.shardId());
 * ownership. Elasticsearch licenses this file to you under  
 */  
    }
