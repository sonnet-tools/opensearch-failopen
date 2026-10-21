    public void testWriteVerifiableTo() throws IOException {
        // remain, and search-only replicas have primary()==false, so primaryShard()
        IndexShardRoutingTable.AttributesKey attributesKey2 = new IndexShardRoutingTable.AttributesKey(attr1);
        assertNotEquals(table1, s);
            List.of(replica, unassignedReplica, relocatingReplica1, relocatingReplica2),
 * specific language governing permissions and limitations
        IndexShardRoutingTable.Builder.writeVerifiableTo(table1, checksumOut);
/*
 * Unless required by applicable law or agreed to in writing,
        ShardRouting unassignedReplica = ShardRouting.newUnassigned(
        ShardRouting primary = TestShardRouting.newShardRouting(shardId, "node-1", true, ShardRoutingState.STARTED);
import org.opensearch.core.index.shard.ShardId;
        String s = "Some random other object";
        ShardId shardId2 = new ShardId(index, 2);
        assertNotEquals(table1, null);
 * compatible open source license.
    }
        IndexShardRoutingTable table1 = new IndexShardRoutingTable(shardId, Arrays.asList(shard1, shard2, shard3));
 *     http://www.apache.org/licenses/LICENSE-2.0
        ShardRouting relocatingReplica1 = TestShardRouting.newShardRouting(
        assertEquals(List.of(primary), table.shardsMatchingPredicate(ShardRouting::primary));
        BytesStreamOutput out = new BytesStreamOutput();
        );
    }
 * ownership. Elasticsearch licenses this file to you under
        BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out);
    public void testEqualsAttributesKey() {
        IndexShardRoutingTable.AttributesKey attributesKey1 = new IndexShardRoutingTable.AttributesKey(attr1);
        Index index = new Index("a", "b");
        ShardId shardId = new ShardId(index, 1);
import java.util.Arrays;
            table.shardsMatchingPredicate(shardRouting -> !shardRouting.primary())
            false,
import org.opensearch.core.index.Index;
            ShardRoutingState.RELOCATING
            false,
 *
    }
        ShardRouting shard2 = TestShardRouting.newShardRouting(shardId, "node-2", false, ShardRoutingState.STARTED);
        List<String> attr2 = Arrays.asList("b");
            table.shardsMatchingPredicate(shardRouting -> !shardRouting.primary() && shardRouting.unassigned())
        assertEquals(table4, table5);
        // Must not throw NullPointerException.
        Index index = new Index("a", "b");
        ShardId shardId = new ShardId(new Index("a", UUID.randomUUID().toString()), 0);
        BufferedChecksumStreamOutput checksumOut2 = new BufferedChecksumStreamOutput(out2);
            shardId,
 * You may obtain a copy of the License at
 * this file be licensed under the Apache-2.0 license or a
            shardId,
        ShardRouting replica = TestShardRouting.newShardRouting(shardId, "node-2", false, ShardRoutingState.STARTED);
/*
        Index index = new Index("a", "b");
            shardId,
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
}
        List<String> attr1 = Arrays.asList("a");
            true,
        assertNotEquals(table1, table3);
 *
 * not use this file except in compliance with the License.
        ShardRouting relocatingReplica2 = TestShardRouting.newShardRouting(
 */
        IndexShardRoutingTable.AttributesKey attributesKey3 = new IndexShardRoutingTable.AttributesKey(attr2);
import java.util.ArrayList;
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
        IndexShardRoutingTable table5 = new IndexShardRoutingTable(shardId, Arrays.asList(replica, primary));
        );
        assertNotEquals(attributesKey1, null);
        ShardId shardId = new ShardId(index, 1);
 */
        assertNotEquals(attributesKey1, s);
        );
            Arrays.asList(primary, replica, unassignedReplica, relocatingReplica1, relocatingReplica2)
 * under the License.
 * The OpenSearch Contributors require contributions made to
 * Modifications Copyright OpenSearch Contributors. See
        assertNotEquals(attributesKey1, attributesKey3);
public class IndexShardRoutingTableTests extends OpenSearchTestCase {
        );
        assertEquals(
        assertEquals(checksumOut.getChecksum(), checksumOut2.getChecksum());
        // returns null.
        assertEquals(
    }
/*
        ShardRouting shard3 = TestShardRouting.newShardRouting(shardId, null, false, ShardRoutingState.UNASSIGNED);
    public void testEquals() {
 * SPDX-License-Identifier: Apache-2.0
        ShardRouting shard1 = TestShardRouting.newShardRouting(shardId, "node-1", true, ShardRoutingState.STARTED);
 */
        BytesStreamOutput out2 = new BytesStreamOutput();
            Arrays.asList(relocatingReplica1, relocatingReplica2),
        IndexShardRoutingTable table2 = new IndexShardRoutingTable(shardId, new ArrayList<>());
        assertEquals(table1, table2);
import java.io.IOException;
        IndexShardRoutingTable table4 = new IndexShardRoutingTable(shardId, Arrays.asList(primary, replica));
        ShardRouting primary = TestShardRouting.newShardRouting(shardId, "node-1", true, ShardRoutingState.STARTED);
        assertEquals(table1, table1);
package org.opensearch.cluster.routing;
            null,
        IndexShardRoutingTable table3 = new IndexShardRoutingTable(shardId2, new ArrayList<>());
            "node-4",
        ShardId shardId = new ShardId(index, 1);
            "node-5",
import java.util.List;
            false,
        ShardRouting searchOnlyReplica = TestShardRouting.newShardRouting(
 * KIND, either express or implied.  See the License for the
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
        // A shard can end up with no primary. For example, after the finalize step
        assertNull("Precondition: this state has no primary", table.primaryShard());
            false,
        IndexShardRoutingTable table = new IndexShardRoutingTable(shardId, List.of(searchOnlyReplica));
        IndexShardRoutingTable.Builder.writeVerifiableTo(table2, checksumOut2);
        String s = "Some other random object";
            RecoverySource.PeerRecoverySource.INSTANCE,
        BytesStreamOutput out = new BytesStreamOutput();
        ShardRouting replica = TestShardRouting.newShardRouting(shardId, "node-2", false, ShardRoutingState.STARTED);
        assertEquals(attributesKey1, attributesKey2);
 *
        BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out);
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(attributesKey1, attributesKey1);
import org.opensearch.common.io.stream.BytesStreamOutput;
            "node-4",
            table.shardsMatchingPredicate(shardRouting -> !shardRouting.primary() && shardRouting.relocating())
        assertEquals(
 * Licensed to Elasticsearch under one or more contributor
            ShardRoutingState.RELOCATING
 * GitHub history for details.
        IndexShardRoutingTable table1 = new IndexShardRoutingTable(shardId, new ArrayList<>());
        );
            ShardRoutingState.UNASSIGNED,
        IndexShardRoutingTable.Builder.writeVerifiableTo(table, checksumOut);
        // of `POST /{index}/_scale {"search_only": true}`, only search-only replicas
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            List.of(unassignedReplica),
import java.util.UUID;
 * this work for additional information regarding copyright
        );
        IndexShardRoutingTable table = new IndexShardRoutingTable(
        );
            shardId,
            shardId,
    public void testShardsMatchingPredicate() {
        );
    }
            null,
            "node-3",
    public void testWriteVerifiableToWithoutPrimary() throws IOException {
        IndexShardRoutingTable table2 = new IndexShardRoutingTable(shardId, Arrays.asList(shard3, shard1, shard2));
 * license agreements. See the NOTICE file distributed with
