        assertNotEquals(allocationId1, null);
    }
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor
        logger.info("-- finalize the relocation");
        AllocationId allocationId2 = AllocationId.newInitializing(allocationId1.getId());
        logger.info("-- start the shard");
            ExistingStoreRecoverySource.INSTANCE,
        assertThat(shard.allocationId(), not(equalTo(allocationId)));
/*
import org.opensearch.common.xcontent.XContentFactory;
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to
        assertNotEquals(allocationId1, s);
        shard = shard.moveToUnassigned(new UnassignedInfo(UnassignedInfo.Reason.NODE_LEFT, null));
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
        assertThat(target.allocationId().getId(), equalTo(shard.allocationId().getRelocationId()));
        );
    public void testSerialization() throws IOException {
        );
        AllocationId allocationId = shard.allocationId();
        shard = shard.moveToStarted();
 * the Apache License, Version 2.0 (the "License"); you may
    }
import java.io.IOException;
        shard = shard.initialize("node1", null, -1);
            new ShardId("test", "_na_", 0),
        assertThat(shard.allocationId(), nullValue());
        assertThat(shard.allocationId().getRelocationId(), nullValue());
        );
 * software distributed under the License is distributed on an
    }
            ExistingStoreRecoverySource.INSTANCE,
 * Unless required by applicable law or agreed to in writing,
            ExistingStoreRecoverySource.INSTANCE,
        AllocationId allocationId = AllocationId.newInitializing();
        shard = shard.initialize("node1", null, -1);
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
        allocationId = shard.allocationId();
        assertEquals(originalAllocationId, shard.allocationId());
        assertNotNull(shard.allocationId());
            true,
 *
public class AllocationIdTests extends OpenSearchTestCase {
        shard = shard.cancelRelocation();
        logger.info("-- cancel relocation");
    public void testMoveToUnassigned() {
            new ShardId("test", "_na_", 0),
        ShardRouting shard = ShardRouting.newUnassigned(
        ShardRouting shard = ShardRouting.newUnassigned(
            true,
        allocationId2 = AllocationId.newRelocation(allocationId1);
        shard = shard.initialize("node1", null, -1);
        assertThat(allocationId.getRelocationId(), nullValue());
        assertThat(shard.allocationId().getRelocationId(), notNullValue());
    public void testCancelRelocation() {
            new ShardId("test", "_na_", 0),
        AllocationId allocationId = shard.allocationId();
        assertThat(target.allocationId().getId(), equalTo(shard.allocationId().getRelocationId()));
        }
        );
        assertThat(shard.allocationId(), not(equalTo(allocationId)));
 * ownership. Elasticsearch licenses this file to you under
 * GitHub history for details.
        logger.info("-- build started shard");
        ShardRouting target = shard.getTargetRelocatingShard();
 * Modifications Copyright OpenSearch Contributors. See
        logger.info("-- relocate the shard");
        assertThat(target.allocationId().getRelocationId(), equalTo(shard.allocationId().getId()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertNotEquals(allocationId1, allocationId2);
    public void testEquals() {
            new ShardId("test", "_na_", 0),
 *
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
            ExistingStoreRecoverySource.INSTANCE,
 */
 */
        assertThat(shard.allocationId().getId(), equalTo(allocationId.getId()));
        assertNotEquals(allocationId1, allocationId3);
import static org.hamcrest.Matchers.notNullValue;
    }
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
    public void testSuccessfulRelocation() {
/*
        assertEquals(allocationId1, allocationId1);
    public void testMovePrimaryToReplica() {
}
 * not use this file except in compliance with the License.
 * under the License.
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        allocationId = shard.allocationId();
        AllocationId allocationId1 = AllocationId.newInitializing();
        ShardRouting shard = ShardRouting.newUnassigned(
    }
        if (randomBoolean()) {
        assertThat(target.allocationId().getRelocationId(), nullValue());
package org.opensearch.cluster.routing;
        ShardRouting shard = ShardRouting.newUnassigned(
    }
import org.opensearch.test.OpenSearchTestCase;
import static org.hamcrest.Matchers.nullValue;
        logger.info("-- create unassigned shard");
        assertThat(allocationId.getRelocationId(), nullValue());
        ShardRouting shard = ShardRouting.newUnassigned(
            true,
        shard = shard.moveToStarted();
import org.opensearch.core.index.shard.ShardId;
        logger.info("-- relocate the shard");
 * license agreements. See the NOTICE file distributed with
        target = target.moveToStarted();
        assertThat(allocationId.getId(), notNullValue());
 * KIND, either express or implied.  See the License for the
        );
        assertEquals(allocationId1, allocationId2);
        shard = shard.relocate("node2", -1);
 *
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.common.bytes.BytesReference;
        logger.info("-- build started shard");
    }
        assertThat(shard.allocationId().getRelocationId(), notNullValue());
        logger.info("-- move to unassigned");
        assertThat(shard.allocationId().getId(), equalTo(allocationId.getId()));
        shard = shard.moveToStarted();
        assertThat(shard.allocationId().getId(), equalTo(allocationId.getId()));
            new ShardId("test", "_na_", 0),
        assertThat(allocationId.getId(), notNullValue());
import org.opensearch.core.xcontent.ToXContent;
    public void testShardToStarted() {
import org.opensearch.common.xcontent.json.JsonXContent;
            true,
        AllocationId allocationId = shard.allocationId();
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
import static org.hamcrest.Matchers.not;
        assertThat(allocationId, notNullValue());
        AllocationId parsedAllocationId = AllocationId.fromXContent(createParser(JsonXContent.jsonXContent, bytes));
        assertEquals(allocationId, parsedAllocationId);
        logger.info("-- build started shard");
        BytesReference bytes = BytesReference.bytes(allocationId.toXContent(XContentFactory.jsonBuilder(), ToXContent.EMPTY_PARAMS));
        shard = shard.moveToStarted();
import org.opensearch.cluster.routing.RecoverySource.ExistingStoreRecoverySource;
        logger.info("-- build started shard");
        shard = shard.moveActivePrimaryToReplica();
        shard = shard.moveToStarted();
        shard = shard.relocate("node2", -1);
            true,
        String s = "Some random other object";
        logger.info("-- initialize the shard");
        logger.info("-- move to replica");
        shard = shard.initialize("node1", null, -1);
/*
        assertThat(shard.allocationId().getId(), equalTo(allocationId.getId()));
        AllocationId originalAllocationId = shard.allocationId();
 * specific language governing permissions and limitations
        AllocationId allocationId3 = AllocationId.newInitializing("not a UUID");
            allocationId = AllocationId.newRelocation(allocationId);
        assertThat(shard.allocationId(), nullValue());
            ExistingStoreRecoverySource.INSTANCE,
            new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, null)
 * You may obtain a copy of the License at
        shard = shard.initialize("node1", null, -1);
