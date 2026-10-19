            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
        shard = shard.moveToUnassigned(new UnassignedInfo(UnassignedInfo.Reason.NODE_LEFT, null));
            new ShardId("test", "_na_", 0),  
 */  
        target = target.moveToStarted();
        shard = shard.moveToStarted();  
import static org.hamcrest.Matchers.notNullValue;
 */  
import static org.hamcrest.Matchers.equalTo;
        assertThat(shard.allocationId().getId(), equalTo(allocationId.getId()));
    public void testCancelRelocation() {
        assertThat(shard.allocationId().getRelocationId(), notNullValue());
 * ownership. Elasticsearch licenses this file to you under  
        assertNotNull(shard.allocationId());
        AllocationId allocationId2 = AllocationId.newInitializing(allocationId1.getId());  
        assertEquals(allocationId1, allocationId1);  
            true,
        logger.info("-- move to unassigned");
            true,  
    public void testMoveToUnassigned() {
 * software distributed under the License is distributed on an
        BytesReference bytes = BytesReference.bytes(allocationId.toXContent(XContentFactory.jsonBuilder(), ToXContent.EMPTY_PARAMS));
    }
        assertThat(target.allocationId().getRelocationId(), equalTo(shard.allocationId().getId()));
/*  
    public void testSuccessfulRelocation() {  
import org.opensearch.core.index.shard.ShardId;
        assertThat(shard.allocationId().getId(), equalTo(allocationId.getId()));  
        assertThat(shard.allocationId().getId(), equalTo(allocationId.getId()));  
        assertNotEquals(allocationId1, null);  
        assertThat(allocationId.getRelocationId(), nullValue());
        assertEquals(originalAllocationId, shard.allocationId());  
            true,
        allocationId = shard.allocationId();
import static org.hamcrest.Matchers.nullValue;
        logger.info("-- finalize the relocation");
        shard = shard.moveToStarted();
import org.opensearch.cluster.routing.RecoverySource.ExistingStoreRecoverySource;
        }
        logger.info("-- build started shard");  
        AllocationId allocationId1 = AllocationId.newInitializing();
        assertThat(shard.allocationId(), nullValue());
 * this work for additional information regarding copyright
        logger.info("-- relocate the shard");
import static org.hamcrest.Matchers.not;  
        assertThat(target.allocationId().getId(), equalTo(shard.allocationId().getRelocationId()));  
        assertThat(shard.allocationId(), not(equalTo(allocationId)));
            ExistingStoreRecoverySource.INSTANCE,  
        logger.info("-- create unassigned shard");  
        assertEquals(allocationId1, allocationId2);
    }  
        AllocationId allocationId = shard.allocationId();
 * this file be licensed under the Apache-2.0 license or a
        assertThat(target.allocationId().getId(), equalTo(shard.allocationId().getRelocationId()));
    }
        );  
        assertThat(target.allocationId().getRelocationId(), nullValue());
        assertThat(shard.allocationId().getRelocationId(), nullValue());
            new ShardId("test", "_na_", 0),
        ShardRouting shard = ShardRouting.newUnassigned(
        assertThat(allocationId.getId(), notNullValue());
        shard = shard.relocate("node2", -1);
 * The OpenSearch Contributors require contributions made to  
            new ShardId("test", "_na_", 0),
            true,
    public void testSerialization() throws IOException {  
        logger.info("-- cancel relocation");
            new ShardId("test", "_na_", 0),
 * specific language governing permissions and limitations
    public void testMovePrimaryToReplica() {  
    }
    }
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)  
        assertThat(shard.allocationId(), nullValue());  
        shard = shard.relocate("node2", -1);
import org.opensearch.test.OpenSearchTestCase;
        ShardRouting shard = ShardRouting.newUnassigned(
import java.io.IOException;  
        shard = shard.moveToStarted();  
            new ShardId("test", "_na_", 0),  
        AllocationId originalAllocationId = shard.allocationId();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
            allocationId = AllocationId.newRelocation(allocationId);  
            ExistingStoreRecoverySource.INSTANCE,
        assertThat(shard.allocationId().getRelocationId(), notNullValue());
        shard = shard.moveToStarted();
        shard = shard.initialize("node1", null, -1);
            ExistingStoreRecoverySource.INSTANCE,
        assertThat(shard.allocationId(), not(equalTo(allocationId)));  
        logger.info("-- relocate the shard");  
        assertNotEquals(allocationId1, allocationId3);
        assertEquals(allocationId, parsedAllocationId);
        assertNotEquals(allocationId1, allocationId2);
            ExistingStoreRecoverySource.INSTANCE,
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
        shard = shard.initialize("node1", null, -1);
        );  
        shard = shard.moveActivePrimaryToReplica();
        if (randomBoolean()) {
        AllocationId allocationId = AllocationId.newInitializing();
        assertThat(allocationId.getId(), notNullValue());
        allocationId2 = AllocationId.newRelocation(allocationId1);  
        ShardRouting shard = ShardRouting.newUnassigned(
    public void testEquals() {
        assertNotEquals(allocationId1, s);
        AllocationId allocationId = shard.allocationId();  
        shard = shard.initialize("node1", null, -1);
        AllocationId allocationId = shard.allocationId();
        shard = shard.initialize("node1", null, -1);
 * under the License.  
    }
import org.opensearch.common.xcontent.json.JsonXContent;  
        shard = shard.moveToStarted();
        logger.info("-- initialize the shard");  
        ShardRouting shard = ShardRouting.newUnassigned(
import org.opensearch.common.xcontent.XContentFactory;
        shard = shard.cancelRelocation();  
        );
/*  
        logger.info("-- start the shard");
        ShardRouting target = shard.getTargetRelocatingShard();  
 * compatible open source license.
        assertThat(shard.allocationId().getId(), equalTo(allocationId.getId()));
    }
 *
import org.opensearch.core.common.bytes.BytesReference;
        );
 *     http://www.apache.org/licenses/LICENSE-2.0
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)  
        logger.info("-- build started shard");
        ShardRouting shard = ShardRouting.newUnassigned(  
 * not use this file except in compliance with the License.
        );
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
public class AllocationIdTests extends OpenSearchTestCase {
 * Unless required by applicable law or agreed to in writing,
        String s = "Some random other object";
        logger.info("-- build started shard");
    public void testShardToStarted() {
            ExistingStoreRecoverySource.INSTANCE,
        shard = shard.initialize("node1", null, -1);  
        logger.info("-- build started shard");
 * SPDX-License-Identifier: Apache-2.0
        allocationId = shard.allocationId();  
 * license agreements. See the NOTICE file distributed with
        AllocationId parsedAllocationId = AllocationId.fromXContent(createParser(JsonXContent.jsonXContent, bytes));  
 * KIND, either express or implied.  See the License for the
}  
        logger.info("-- move to replica");  
import org.opensearch.core.xcontent.ToXContent;  
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
        AllocationId allocationId3 = AllocationId.newInitializing("not a UUID");
 *  
 * GitHub history for details.
/*
            true,  
        assertThat(allocationId, notNullValue());  
 *
package org.opensearch.cluster.routing;
        assertThat(allocationId.getRelocationId(), nullValue());  
