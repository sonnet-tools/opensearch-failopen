/*  
 * The OpenSearch Contributors require contributions made to  
 * KIND, either express or implied.  See the License for the
 */  
 * GitHub history for details.
        return this.oldestLuceneSegment;  
 * under the License.  
    ShardUpgradeResult(StreamInput in) throws IOException {
 *
        try {  
    }  
    }
        return primary;
            throw new IOException("failed to parse lucene version [" + oldestLuceneSegment + "]", ex);  
/**
 */
 * Unless required by applicable law or agreed to in writing,
}  
 * software distributed under the License is distributed on an
import org.opensearch.core.common.io.stream.Writeable;
        out.writeVersion(upgradeVersion);  
        out.writeString(oldestLuceneSegment.toString());
        out.writeBoolean(primary);
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
        this.upgradeVersion = upgradeVersion;
 *     http://www.apache.org/licenses/LICENSE-2.0
        upgradeVersion = in.readVersion();
 * specific language governing permissions and limitations
    public ShardId getShardId() {
 * this file be licensed under the Apache-2.0 license or a
    }  
 * ownership. Elasticsearch licenses this file to you under  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * SPDX-License-Identifier: Apache-2.0
        shardId = new ShardId(in);  
    ShardUpgradeResult(ShardId shardId, boolean primary, Version upgradeVersion, org.apache.lucene.util.Version oldestLuceneSegment) {
import java.io.IOException;
    public org.apache.lucene.util.Version oldestLuceneSegment() {
        return this.upgradeVersion;
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
    private org.apache.lucene.util.Version oldestLuceneSegment;
 * Result for Upgrading a Shard
/*  
        } catch (ParseException ex) {
    public void writeTo(StreamOutput out) throws IOException {  
    }
class ShardUpgradeResult implements Writeable {  
 * Modifications Copyright OpenSearch Contributors. See
/*
    public boolean primary() {
        this.shardId = shardId;
    @Override
    }  
            oldestLuceneSegment = org.apache.lucene.util.Version.parse(in.readString());
        return shardId;
        this.primary = primary;  
 *  
 * Licensed to Elasticsearch under one or more contributor  
    private Version upgradeVersion;  
 * not use this file except in compliance with the License.
        this.oldestLuceneSegment = oldestLuceneSegment;
 * @opensearch.internal
import org.opensearch.Version;
import java.text.ParseException;
    public Version upgradeVersion() {  
 *  
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.io.stream.StreamOutput;  
    }
        }
package org.opensearch.action.admin.indices.upgrade.post;
        primary = in.readBoolean();
        shardId.writeTo(out);
 * compatible open source license.
    private ShardId shardId;
 *
    }
    private boolean primary;
