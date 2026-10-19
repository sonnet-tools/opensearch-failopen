    }  
 * Unless required by applicable law or agreed to in writing,
        IndexShardRoutingTable table = new IndexShardRoutingTable(
 *     http://www.apache.org/licenses/LICENSE-2.0
        ShardId shardId = new ShardId(index, 1);
 * the Apache License, Version 2.0 (the "License"); you may
        String s = "Some random other object";
    public void testWriteVerifiableToWithoutPrimary() throws IOException {
        );
        IndexShardRoutingTable table2 = new IndexShardRoutingTable(shardId, Arrays.asList(shard3, shard1, shard2));
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
        assertEquals(checksumOut.getChecksum(), checksumOut2.getChecksum());
        );
            ShardRoutingState.RELOCATING  
        assertEquals(  
import java.util.List;
        assertNull("Precondition: this state has no primary", table.primaryShard());
        assertEquals(attributesKey1, attributesKey1);  
        // Must not throw NullPointerException.
            List.of(unassignedReplica),
 * ownership. Elasticsearch licenses this file to you under  
            "node-3",  
        IndexShardRoutingTable table1 = new IndexShardRoutingTable(shardId, Arrays.asList(shard1, shard2, shard3));
            false,
 * under the License.  
        );
        assertNotEquals(table1, s);  
        assertNotEquals(attributesKey1, attributesKey3);
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
        IndexShardRoutingTable table = new IndexShardRoutingTable(shardId, List.of(searchOnlyReplica));  
        ShardRouting unassignedReplica = ShardRouting.newUnassigned(
            table.shardsMatchingPredicate(shardRouting -> !shardRouting.primary() && shardRouting.unassigned())  
        );
            false,
import org.opensearch.core.index.Index;  
        assertEquals(
        ShardId shardId = new ShardId(new Index("a", UUID.randomUUID().toString()), 0);
            table.shardsMatchingPredicate(shardRouting -> !shardRouting.primary())
 * not use this file except in compliance with the License.
        ShardId shardId = new ShardId(index, 1);  
        assertNotEquals(table1, table3);
 * You may obtain a copy of the License at  
        assertEquals(
        IndexShardRoutingTable table2 = new IndexShardRoutingTable(shardId, new ArrayList<>());  
    public void testWriteVerifiableTo() throws IOException {
        );  
        assertNotEquals(attributesKey1, null);
        Index index = new Index("a", "b");
        IndexShardRoutingTable.Builder.writeVerifiableTo(table1, checksumOut);
            table.shardsMatchingPredicate(shardRouting -> !shardRouting.primary() && shardRouting.relocating())
import java.util.ArrayList;
import java.util.Arrays;  
    }
            shardId,  
    public void testShardsMatchingPredicate() {  
/*  
        IndexShardRoutingTable.AttributesKey attributesKey2 = new IndexShardRoutingTable.AttributesKey(attr1);  
            null,
        List<String> attr1 = Arrays.asList("a");  
        BufferedChecksumStreamOutput checksumOut2 = new BufferedChecksumStreamOutput(out2);  
 * The OpenSearch Contributors require contributions made to  
 */  
        );
        IndexShardRoutingTable.Builder.writeVerifiableTo(table2, checksumOut2);
        // of `POST /{index}/_scale {"search_only": true}`, only search-only replicas
            false,  
        ShardRouting searchOnlyReplica = TestShardRouting.newShardRouting(  
            RecoverySource.PeerRecoverySource.INSTANCE,
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
        List<String> attr2 = Arrays.asList("b");
            List.of(replica, unassignedReplica, relocatingReplica1, relocatingReplica2),
 * this file be licensed under the Apache-2.0 license or a
            Arrays.asList(primary, replica, unassignedReplica, relocatingReplica1, relocatingReplica2)  
    }
            null,  
 * GitHub history for details.
            true,
            shardId,
        ShardRouting primary = TestShardRouting.newShardRouting(shardId, "node-1", true, ShardRoutingState.STARTED);
        ShardId shardId = new ShardId(index, 1);  
        IndexShardRoutingTable table5 = new IndexShardRoutingTable(shardId, Arrays.asList(replica, primary));  
 *  
            "node-4",
            ShardRoutingState.RELOCATING
 */
            shardId,
}
        assertNotEquals(attributesKey1, s);  
    public void testEquals() {
        // A shard can end up with no primary. For example, after the finalize step  
 * this work for additional information regarding copyright
 *
import org.opensearch.common.io.stream.BytesStreamOutput;
 *
        IndexShardRoutingTable.AttributesKey attributesKey3 = new IndexShardRoutingTable.AttributesKey(attr2);
        assertEquals(table4, table5);
            Arrays.asList(relocatingReplica1, relocatingReplica2),  
        ShardRouting relocatingReplica1 = TestShardRouting.newShardRouting(
        ShardRouting shard3 = TestShardRouting.newShardRouting(shardId, null, false, ShardRoutingState.UNASSIGNED);  
        assertEquals(attributesKey1, attributesKey2);
    }  
        IndexShardRoutingTable table4 = new IndexShardRoutingTable(shardId, Arrays.asList(primary, replica));
import java.util.UUID;
 * KIND, either express or implied.  See the License for the
        BytesStreamOutput out = new BytesStreamOutput();  
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
            false,  
 * license agreements. See the NOTICE file distributed with
        IndexShardRoutingTable table1 = new IndexShardRoutingTable(shardId, new ArrayList<>());
        ShardRouting relocatingReplica2 = TestShardRouting.newShardRouting(
        assertEquals(table1, table2);
    public void testEqualsAttributesKey() {
        ShardRouting shard1 = TestShardRouting.newShardRouting(shardId, "node-1", true, ShardRoutingState.STARTED);
        // remain, and search-only replicas have primary()==false, so primaryShard()
        ShardRouting primary = TestShardRouting.newShardRouting(shardId, "node-1", true, ShardRoutingState.STARTED);  
        String s = "Some other random object";
 * specific language governing permissions and limitations
        IndexShardRoutingTable.AttributesKey attributesKey1 = new IndexShardRoutingTable.AttributesKey(attr1);
/*
import org.opensearch.core.index.shard.ShardId;
        IndexShardRoutingTable table3 = new IndexShardRoutingTable(shardId2, new ArrayList<>());
            shardId,
        );
        BytesStreamOutput out2 = new BytesStreamOutput();
        );  
 * Licensed to Elasticsearch under one or more contributor  
            "node-5",
        assertNotEquals(table1, null);
        BytesStreamOutput out = new BytesStreamOutput();  
public class IndexShardRoutingTableTests extends OpenSearchTestCase {
/*  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
        BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out);
package org.opensearch.cluster.routing;
        ShardRouting shard2 = TestShardRouting.newShardRouting(shardId, "node-2", false, ShardRoutingState.STARTED);
        Index index = new Index("a", "b");
        ShardRouting replica = TestShardRouting.newShardRouting(shardId, "node-2", false, ShardRoutingState.STARTED);  
    }
        assertEquals(List.of(primary), table.shardsMatchingPredicate(ShardRouting::primary));
        BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out);
        Index index = new Index("a", "b");
        assertEquals(table1, table1);  
 */  
        ShardId shardId2 = new ShardId(index, 2);
            ShardRoutingState.UNASSIGNED,  
        // returns null.  
        ShardRouting replica = TestShardRouting.newShardRouting(shardId, "node-2", false, ShardRoutingState.STARTED);
            "node-4",
            shardId,
        IndexShardRoutingTable.Builder.writeVerifiableTo(table, checksumOut);  
