            null,
        };
        assertEquals(status, serializedStatus);
            "action",  
        );
                break;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
            case 1:
        assertEquals(status.hashCode(), sameStatus.hashCode());
            "type",
        }
            Collections.singleton(allocationId),  
        threadPool.generic().execute(() -> { syncer.resync(shard, fut); });
 * Modifications Copyright OpenSearch Contributors. See  
            try (
 * Licensed to Elasticsearch under one or more contributor  
public class PrimaryReplicaSyncerTests extends IndexShardTestCase {  
 * under the License.  
            assertThat(resyncTask.getTotalOperations(), equalTo(0));  
        PrimaryReplicaSyncer.SyncAction syncAction = (request, parentTask, allocationId, primaryTerm, listener) -> {
            "action",
import java.util.ArrayList;
            null,  
                }
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
                Versions.MATCH_ANY,  
        assertThat(jsonString, containsString("\"phase\":\"" + task.getPhase() + "\""));
            listener.onResponse(new ResyncReplicationResponse());  
        if (syncNeeded) {
        String allocationId = shard.routingEntry().allocationId().getId();
                )
        PrimaryReplicaSyncer.SyncAction syncAction = (request, parentTask, allocationId, primaryTerm, listener) -> {
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * SPDX-License-Identifier: Apache-2.0
            if (shard.indexSettings.isSoftDeleteEnabled()) {
        }  
import org.opensearch.core.common.bytes.BytesArray;
        String allocationId = shard.routingEntry().allocationId().getId();  
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
        task.setPhase(randomAlphaOfLength(10));
import org.opensearch.core.xcontent.ToXContent;  
    }  
        task.setResyncedOperations(randomIntBetween(0, 1000));  
        );
            }
                assertThat(resyncTask.getTotalOperations(), equalTo(numDocs));
        PrimaryReplicaSyncer.ResyncTask.Status sameStatus = task.getStatus();
            0,
import org.opensearch.action.resync.ResyncReplicationResponse;  
                "trimAboveSeqNo has to be specified in request #0 only",
            new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet()),
        task.setSkippedOperations(randomIntBetween(0, 1000));  
        int numDocs = randomInt(10);
                0,
                new SourceToParse(shard.shardId().getIndexName(), Integer.toString(i), new BytesArray("{}"), MediaTypeRegistry.JSON),
/*
        );
            assertThat(resyncTask.getResyncedOperations(), equalTo(Math.toIntExact(numDocs - 1 - globalCheckPoint)));  
                } finally {
                task.setPhase("otherPhase");  
import org.opensearch.common.lucene.uid.Versions;
            randomAlphaOfLength(10),
 * compatible open source license.
        PrimaryReplicaSyncer.ResyncTask resyncTask = fut.get();  
            assertThat(resyncRequest.getTrimAboveSeqNo(), equalTo(globalCheckPoint));
import org.opensearch.index.seqno.SequenceNumbers;
        PrimaryReplicaSyncer.ResyncTask.Status serializedStatus = new PrimaryReplicaSyncer.ResyncTask.Status(in);  
        };  
 * not use this file except in compliance with the License.
                assertThat(in.readNamedWriteable(Task.Status.class), equalTo(status));
            randomIntBetween(0, 1000)
                task.setResyncedOperations(task.getResyncedOperations() + 1);  
                Versions.MATCH_ANY,
        shard.updateShardState(
        );
        PrimaryReplicaSyncer.ResyncTask.Status status = task.getStatus();
            assertTrue("Sync action was not called", syncActionCalled.get());
            threadPool.generic().execute(() -> listener.onResponse(new ResyncReplicationResponse()));
        );  
        shard.updateShardState(
    public void testSyncerSendsOffCorrectDocuments() throws Exception {
                    .findFirst()  
import java.nio.ByteBuffer;  
            randomIntBetween(0, 1000),
        assertThat(jsonString, containsString("\"skippedOperations\":" + task.getSkippedOperations()));
            out.writeNamedWriteable(status);  
            @Override
        }
        XContentBuilder jsonBuilder = XContentFactory.jsonBuilder();
            }
import org.opensearch.action.support.PlainActionFuture;
        assertNotSame(status, sameStatus);  
        if (randomBoolean()) {
                    new ByteBufferStreamInput(ByteBuffer.wrap(out.bytes().toBytesRef().bytes)),  
            "type",  
            randomIntBetween(0, 1000)  
                break;
            case 0:
        boolean syncNeeded = numDocs > 0;
import org.opensearch.tasks.TaskManager;  
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * The OpenSearch Contributors require contributions made to  
        } catch (AlreadyClosedException | IndexShardClosedException ignored) {  
        IndexShard shard = newStartedShard(true);  
                    .filter(seqNo -> seqNo != SequenceNumbers.UNASSIGNED_SEQ_NO)
 * this work for additional information regarding copyright
        syncer.setChunkSize(new ByteSizeValue(randomIntBetween(1, 10)));  
        final ByteBufferStreamInput in = new ByteBufferStreamInput(ByteBuffer.wrap(out.bytes().toBytesRef().bytes));
            Collections.emptyMap()
        task.setTotalOperations(randomIntBetween(0, 1000));
                assertThat(resyncTask.getTotalOperations(), equalTo(Math.toIntExact(numDocs - 1 - globalCheckPoint)));
import org.opensearch.action.index.IndexRequest;
            fut.actionGet();
            shard.getPendingPrimaryTerm(),  
            null,
        }
 */
        PrimaryReplicaSyncer.ResyncTask.Status status = new PrimaryReplicaSyncer.ResyncTask.Status(
        assertEquals(globalCheckPoint, shard.getLastKnownGlobalCheckpoint());  
        );
            public void onResponse(PrimaryReplicaSyncer.ResyncTask result) {
                StreamInput in = new NamedWriteableAwareStreamInput(
import java.util.Collections;
        logger.info("Total ops: {}, global checkpoint: {}", numDocs, globalCheckPoint);
 *  
            assertThat(parentTask, instanceOf(PrimaryReplicaSyncer.ResyncTask.class));
import org.opensearch.common.io.stream.BytesStreamOutput;  
/*
import org.opensearch.common.xcontent.XContentFactory;
        task.setSkippedOperations(randomIntBetween(0, 1000));
            randomIntBetween(0, 1000),
            new IndexShardRoutingTable.Builder(shard.shardId()).addShard(shard.routingEntry()).build(),
import org.apache.lucene.store.AlreadyClosedException;  
            @Override
            null,
            // Index doc but not advance local checkpoint.  
        IndexShard shard = newStartedShard(true);  
 * this file be licensed under the Apache-2.0 license or a
                false
                task.setSkippedOperations(task.getSkippedOperations() + 1);  
                SequenceNumbers.UNASSIGNED_SEQ_NO,  
        String jsonString = jsonBuilder.toString();  
        PrimaryReplicaSyncer syncer = new PrimaryReplicaSyncer(taskManager, syncAction);
 *
            } else {  
        }
        List<ResyncReplicationRequest> resyncRequests = new ArrayList<>();  
            "desc",
 * license agreements. See the NOTICE file distributed with
package org.opensearch.index.shard;
                    syncCalledLatch.countDown();  
        };  
            ResyncReplicationRequest resyncRequest = resyncRequests.remove(0);
import org.opensearch.common.network.NetworkModule;
        } else {  
        if (syncNeeded && globalCheckPoint < numDocs - 1) {
            case 2:
            1000L,
        PrimaryReplicaSyncer.ResyncTask.Status differentStatus = task.getStatus();
import org.opensearch.action.resync.ResyncReplicationRequest;
            // ignore
            1000L,  
        closeShards(shard);
            syncActionCalled.set(true);
    public void testSyncerOnClosingShard() throws Exception {
            assertThat(resyncTask.getSkippedOperations(), equalTo(0));
            Collections.emptyMap()  
import org.opensearch.index.mapper.SourceToParse;  
        PrimaryReplicaSyncer.ResyncTask.Status status = new PrimaryReplicaSyncer.ResyncTask.Status(  
        assertEquals(status, sameStatus);
            }
        CountDownLatch syncCalledLatch = new CountDownLatch(1);
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.core.common.io.stream.StreamInput;  
import static org.hamcrest.Matchers.is;  
import static org.hamcrest.Matchers.containsString;
            logger.info("Sending off {} operations", request.getOperations().length);
import java.util.concurrent.atomic.AtomicBoolean;
            new IndexShardRoutingTable.Builder(shard.shardId()).addShard(shard.routingEntry()).build(),
            IndexShardTestUtils.getFakeDiscoveryNodes(shard.routingEntry())  
import java.util.concurrent.CountDownLatch;
    }
            }
            syncActionCalled.set(true);  
}  
            ) {  
                VersionType.INTERNAL,
        PlainActionFuture<PrimaryReplicaSyncer.ResyncTask> fut = new PlainActionFuture<>();
import org.opensearch.core.xcontent.XContentBuilder;
        PrimaryReplicaSyncer.ResyncTask task = new PrimaryReplicaSyncer.ResyncTask(
        PlainActionFuture<PrimaryReplicaSyncer.ResyncTask> fut = new PlainActionFuture<PrimaryReplicaSyncer.ResyncTask>() {  
            assertThat(resyncRequest.getMaxSeenAutoIdTimestampOnPrimary(), equalTo(shard.getMaxSeenAutoIdTimestamp()));
            shard.applyIndexOperationOnPrimary(
            randomIntBetween(0, 1000),
        syncer.resync(shard, fut);
                } finally {
            resyncRequests.add(request);
        switch (randomInt(3)) {
                    super.onFailure(e);
                SequenceNumbers.UNASSIGNED_SEQ_NO,
    }  
        status.toXContent(jsonBuilder, ToXContent.EMPTY_PARAMS);
            shard.getPendingPrimaryTerm(),
import org.opensearch.index.VersionType;
                true  
    public void testStatusEquals() throws IOException {  
 * Unless required by applicable law or agreed to in writing,
                task.setTotalOperations(task.getTotalOperations() + 1);  
import org.opensearch.core.common.unit.ByteSizeValue;
                    .isPresent(),
                new SourceToParse(shard.shardId().getIndexName(), Integer.toString(i), new BytesArray("{}"), MediaTypeRegistry.JSON),
    public void testStatusSerialization() throws IOException {
                VersionType.INTERNAL,  
    }
                break;
                try {  
import java.util.List;  
    public void testStatusReportsCorrectNumbers() throws IOException {
    }
        status.writeTo(out);
        assertNotEquals(status, differentStatus);
            0,
        for (int i = 0; i < numDocs; i++) {  
 * KIND, either express or implied.  See the License for the
        }
                    new NamedWriteableRegistry(NetworkModule.getNamedWriteables())
            syncCalledLatch.await();  
                0,  
            );  
        int numDocs = 10;
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        long globalCheckPoint = numDocs > 0 ? randomIntBetween(0, numDocs - 1) : 0;
            shard.applyIndexOperationOnPrimary(
        assertThat(jsonString, containsString("\"resyncedOperations\":" + task.getResyncedOperations()));  
        PrimaryReplicaSyncer.ResyncTask task = new PrimaryReplicaSyncer.ResyncTask(  
        AtomicBoolean syncActionCalled = new AtomicBoolean();
    public void testStatusSerializationAsNamedWriteable() throws IOException {
            randomAlphaOfLength(10),  
        PrimaryReplicaSyncer.ResyncTask.Status status = task.getStatus();  
 * You may obtain a copy of the License at  
        }
        shard.updateLocalCheckpointForShard(allocationId, globalCheckPoint);
/*  
            assertThat(resyncTask.getResyncedOperations(), equalTo(0));
 * the Apache License, Version 2.0 (the "License"); you may
    }  
                try {  
        try {  
 * specific language governing permissions and limitations
            case 3:
            );  
            logger.info("Sending off {} operations", request.getOperations().length);  
 */  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        PrimaryReplicaSyncer syncer = new PrimaryReplicaSyncer(
            public void onFailure(Exception e) {
 * ownership. Elasticsearch licenses this file to you under  
        AtomicBoolean syncActionCalled = new AtomicBoolean();
        for (int i = 0; i < numDocs; i++) {
import org.opensearch.tasks.Task;
            shard.routingEntry(),  
 */
        syncer.setChunkSize(new ByteSizeValue(1)); // every document is sent off separately
 *
        closeShards(shard);
        assertThat(jsonString, containsString("\"totalOperations\":" + task.getTotalOperations()));
            // Index doc but not advance local checkpoint.
import java.io.IOException;
                resyncRequests.stream()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                break;
                    syncCalledLatch.countDown();  
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
            Collections.singleton(allocationId),
            assertTrue("Sync action was not called", syncActionCalled.get());  
        task.setTotalOperations(randomIntBetween(0, 1000));
                    super.onResponse(result);
        );
                }
        final BytesStreamOutput out = new BytesStreamOutput();  
            assertThat(
            IndexShardTestUtils.getFakeDiscoveryNodes(shard.routingEntry())
import org.opensearch.common.settings.Settings;  
        task.setPhase(randomAlphaOfLength(10));  
            "desc",
            assertThat(resyncTask.getSkippedOperations(), equalTo(0));
 * software distributed under the License is distributed on an
        task.setResyncedOperations(randomIntBetween(0, 1000));
                is(false)
            );
import org.opensearch.core.common.io.stream.ByteBufferStreamInput;  
        TaskManager taskManager = new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet());
                    .mapToLong(ResyncReplicationRequest::getTrimAboveSeqNo)
            shard.routingEntry(),
        }  
            randomIntBetween(0, 1000),  
            syncAction  
