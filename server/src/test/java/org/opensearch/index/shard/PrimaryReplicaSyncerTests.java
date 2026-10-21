        long globalCheckPoint = numDocs > 0 ? randomIntBetween(0, numDocs - 1) : 0;
                assertThat(in.readNamedWriteable(Task.Status.class), equalTo(status));
        task.setResyncedOperations(randomIntBetween(0, 1000));
            "desc",
        }
            randomIntBetween(0, 1000),
        );
                VersionType.INTERNAL,
                break;
import org.opensearch.core.common.io.stream.ByteBufferStreamInput;
            randomIntBetween(0, 1000),
            resyncRequests.add(request);
        for (int i = 0; i < numDocs; i++) {
import org.apache.lucene.store.AlreadyClosedException;
            assertTrue("Sync action was not called", syncActionCalled.get());
        String allocationId = shard.routingEntry().allocationId().getId();
        PrimaryReplicaSyncer.ResyncTask.Status status = new PrimaryReplicaSyncer.ResyncTask.Status(
        assertThat(jsonString, containsString("\"resyncedOperations\":" + task.getResyncedOperations()));
            randomIntBetween(0, 1000)
            case 3:
                    super.onFailure(e);
        );
            1000L,
        boolean syncNeeded = numDocs > 0;
            // ignore
            }
        }
        AtomicBoolean syncActionCalled = new AtomicBoolean();
}
        PrimaryReplicaSyncer.ResyncTask.Status serializedStatus = new PrimaryReplicaSyncer.ResyncTask.Status(in);
        final BytesStreamOutput out = new BytesStreamOutput();
 * The OpenSearch Contributors require contributions made to
        String allocationId = shard.routingEntry().allocationId().getId();
import java.util.concurrent.CountDownLatch;
import org.opensearch.index.mapper.SourceToParse;
import org.opensearch.tasks.TaskManager;
import org.opensearch.core.common.unit.ByteSizeValue;
import org.opensearch.index.VersionType;
        );
        TaskManager taskManager = new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet());
            syncCalledLatch.await();
 */
                new SourceToParse(shard.shardId().getIndexName(), Integer.toString(i), new BytesArray("{}"), MediaTypeRegistry.JSON),
        task.setSkippedOperations(randomIntBetween(0, 1000));
                new SourceToParse(shard.shardId().getIndexName(), Integer.toString(i), new BytesArray("{}"), MediaTypeRegistry.JSON),
                    syncCalledLatch.countDown();
                    .mapToLong(ResyncReplicationRequest::getTrimAboveSeqNo)
 */
            syncActionCalled.set(true);
                    new NamedWriteableRegistry(NetworkModule.getNamedWriteables())
        threadPool.generic().execute(() -> { syncer.resync(shard, fut); });
            threadPool.generic().execute(() -> listener.onResponse(new ResyncReplicationResponse()));
            assertThat(resyncRequest.getTrimAboveSeqNo(), equalTo(globalCheckPoint));
import java.nio.ByteBuffer;
                StreamInput in = new NamedWriteableAwareStreamInput(
            public void onResponse(PrimaryReplicaSyncer.ResyncTask result) {
                    new ByteBufferStreamInput(ByteBuffer.wrap(out.bytes().toBytesRef().bytes)),
        }
            if (shard.indexSettings.isSoftDeleteEnabled()) {
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
 * Modifications Copyright OpenSearch Contributors. See
            syncAction
        IndexShard shard = newStartedShard(true);
            randomAlphaOfLength(10),
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
import org.opensearch.common.network.NetworkModule;
import org.opensearch.index.seqno.SequenceNumbers;
        PrimaryReplicaSyncer.ResyncTask.Status differentStatus = task.getStatus();
            shard.applyIndexOperationOnPrimary(
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(status, serializedStatus);
                "trimAboveSeqNo has to be specified in request #0 only",
        String jsonString = jsonBuilder.toString();
        if (randomBoolean()) {
                true
        PrimaryReplicaSyncer.ResyncTask.Status sameStatus = task.getStatus();
                    .filter(seqNo -> seqNo != SequenceNumbers.UNASSIGNED_SEQ_NO)
        syncer.setChunkSize(new ByteSizeValue(1)); // every document is sent off separately
            @Override
    public void testStatusReportsCorrectNumbers() throws IOException {
            1000L,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            new TaskManager(Settings.EMPTY, threadPool, Collections.emptySet()),
        PrimaryReplicaSyncer.ResyncTask task = new PrimaryReplicaSyncer.ResyncTask(
import static org.hamcrest.Matchers.is;
        );
            IndexShardTestUtils.getFakeDiscoveryNodes(shard.routingEntry())
        closeShards(shard);
        logger.info("Total ops: {}, global checkpoint: {}", numDocs, globalCheckPoint);
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.routing.IndexShardRoutingTable;
import org.opensearch.common.xcontent.XContentFactory;
        final ByteBufferStreamInput in = new ByteBufferStreamInput(ByteBuffer.wrap(out.bytes().toBytesRef().bytes));
                VersionType.INTERNAL,
import org.opensearch.core.xcontent.MediaTypeRegistry;
            assertThat(resyncTask.getResyncedOperations(), equalTo(Math.toIntExact(numDocs - 1 - globalCheckPoint)));
import org.opensearch.action.resync.ResyncReplicationRequest;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * specific language governing permissions and limitations
            randomIntBetween(0, 1000)
    }
            logger.info("Sending off {} operations", request.getOperations().length);
 * Licensed to Elasticsearch under one or more contributor
        }
            assertThat(parentTask, instanceOf(PrimaryReplicaSyncer.ResyncTask.class));
        task.setResyncedOperations(randomIntBetween(0, 1000));
    public void testStatusSerialization() throws IOException {
            assertThat(resyncTask.getSkippedOperations(), equalTo(0));
 *
                0,
            case 0:
        PrimaryReplicaSyncer syncer = new PrimaryReplicaSyncer(taskManager, syncAction);
            null,
        closeShards(shard);
                IndexRequest.UNSET_AUTO_GENERATED_TIMESTAMP,
    public void testStatusSerializationAsNamedWriteable() throws IOException {
 *
    public void testStatusEquals() throws IOException {
            // Index doc but not advance local checkpoint.
        IndexShard shard = newStartedShard(true);
                assertThat(resyncTask.getTotalOperations(), equalTo(Math.toIntExact(numDocs - 1 - globalCheckPoint)));
import java.util.Collections;
                Versions.MATCH_ANY,
        };
import java.io.IOException;
            0,
            ) {
        syncer.setChunkSize(new ByteSizeValue(randomIntBetween(1, 10)));
            syncActionCalled.set(true);
 * You may obtain a copy of the License at
        shard.updateShardState(
            randomIntBetween(0, 1000),
package org.opensearch.index.shard;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
                )
        PrimaryReplicaSyncer.SyncAction syncAction = (request, parentTask, allocationId, primaryTerm, listener) -> {
        assertThat(jsonString, containsString("\"phase\":\"" + task.getPhase() + "\""));
                    .findFirst()
        }
import org.opensearch.tasks.Task;
 * SPDX-License-Identifier: Apache-2.0
        PrimaryReplicaSyncer.ResyncTask.Status status = new PrimaryReplicaSyncer.ResyncTask.Status(
        assertThat(jsonString, containsString("\"totalOperations\":" + task.getTotalOperations()));
                false
import org.opensearch.core.common.bytes.BytesArray;
            Collections.emptyMap()
        int numDocs = 10;
            case 2:
    }
        assertEquals(status, sameStatus);
        }
import org.opensearch.action.index.IndexRequest;
/*
            );
        if (syncNeeded && globalCheckPoint < numDocs - 1) {
                try {
        syncer.resync(shard, fut);
        shard.updateShardState(
            "type",
                } finally {
 * ownership. Elasticsearch licenses this file to you under
            case 1:
            assertThat(
 * this work for additional information regarding copyright
    }
            shard.routingEntry(),
            "action",
            randomIntBetween(0, 1000),
                task.setSkippedOperations(task.getSkippedOperations() + 1);
            assertThat(resyncTask.getSkippedOperations(), equalTo(0));
                is(false)
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                break;
                }
import org.opensearch.core.xcontent.ToXContent;
import org.opensearch.action.support.PlainActionFuture;
public class PrimaryReplicaSyncerTests extends IndexShardTestCase {
        PrimaryReplicaSyncer.ResyncTask.Status status = task.getStatus();
 * the Apache License, Version 2.0 (the "License"); you may
            shard.getPendingPrimaryTerm(),
            assertThat(resyncTask.getTotalOperations(), equalTo(0));
        task.setTotalOperations(randomIntBetween(0, 1000));
            );
        switch (randomInt(3)) {
                Versions.MATCH_ANY,
            logger.info("Sending off {} operations", request.getOperations().length);
                break;
 * compatible open source license.
 *
import java.util.ArrayList;
    public void testSyncerOnClosingShard() throws Exception {
/*
                    syncCalledLatch.countDown();
import org.opensearch.core.common.io.stream.StreamInput;
        PlainActionFuture<PrimaryReplicaSyncer.ResyncTask> fut = new PlainActionFuture<PrimaryReplicaSyncer.ResyncTask>() {
 */
                break;
        task.setPhase(randomAlphaOfLength(10));
        assertThat(jsonString, containsString("\"skippedOperations\":" + task.getSkippedOperations()));
import org.opensearch.action.resync.ResyncReplicationResponse;
            new IndexShardRoutingTable.Builder(shard.shardId()).addShard(shard.routingEntry()).build(),
            shard.applyIndexOperationOnPrimary(
 * GitHub history for details.
        task.setPhase(randomAlphaOfLength(10));
        PlainActionFuture<PrimaryReplicaSyncer.ResyncTask> fut = new PlainActionFuture<>();
import static org.hamcrest.Matchers.containsString;
            shard.routingEntry(),
        List<ResyncReplicationRequest> resyncRequests = new ArrayList<>();
        } catch (AlreadyClosedException | IndexShardClosedException ignored) {
        status.writeTo(out);
import static org.hamcrest.Matchers.equalTo;
            new IndexShardRoutingTable.Builder(shard.shardId()).addShard(shard.routingEntry()).build(),
        assertNotSame(status, sameStatus);
        PrimaryReplicaSyncer.ResyncTask.Status status = task.getStatus();
                try {
            // Index doc but not advance local checkpoint.
            );
        shard.updateLocalCheckpointForShard(allocationId, globalCheckPoint);
            shard.getPendingPrimaryTerm(),
            listener.onResponse(new ResyncReplicationResponse());
                SequenceNumbers.UNASSIGNED_SEQ_NO,
            Collections.singleton(allocationId),
                task.setResyncedOperations(task.getResyncedOperations() + 1);
            }
        }
        }
            out.writeNamedWriteable(status);
        AtomicBoolean syncActionCalled = new AtomicBoolean();
import java.util.concurrent.atomic.AtomicBoolean;
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.settings.Settings;
        PrimaryReplicaSyncer.SyncAction syncAction = (request, parentTask, allocationId, primaryTerm, listener) -> {
        );
import org.opensearch.core.xcontent.XContentBuilder;
                    super.onResponse(result);
            Collections.singleton(allocationId),
            randomAlphaOfLength(10),
        int numDocs = randomInt(10);
            "action",
                SequenceNumbers.UNASSIGNED_SEQ_NO,
            } else {
        );
            "desc",
        };
        assertEquals(status.hashCode(), sameStatus.hashCode());
            ResyncReplicationRequest resyncRequest = resyncRequests.remove(0);
                task.setTotalOperations(task.getTotalOperations() + 1);
            public void onFailure(Exception e) {
import org.opensearch.common.lucene.uid.Versions;
            fut.actionGet();
                0,
        if (syncNeeded) {
 * not use this file except in compliance with the License.
                resyncRequests.stream()
            assertThat(resyncTask.getResyncedOperations(), equalTo(0));
            assertThat(resyncRequest.getMaxSeenAutoIdTimestampOnPrimary(), equalTo(shard.getMaxSeenAutoIdTimestamp()));
        status.toXContent(jsonBuilder, ToXContent.EMPTY_PARAMS);
        } else {
                    .isPresent(),
        task.setTotalOperations(randomIntBetween(0, 1000));
                task.setPhase("otherPhase");
        task.setSkippedOperations(randomIntBetween(0, 1000));
        assertNotEquals(status, differentStatus);
 * license agreements. See the NOTICE file distributed with
    }
            0,
 * under the License.
import org.opensearch.common.io.stream.BytesStreamOutput;
        PrimaryReplicaSyncer syncer = new PrimaryReplicaSyncer(
        PrimaryReplicaSyncer.ResyncTask resyncTask = fut.get();
            }
        PrimaryReplicaSyncer.ResyncTask task = new PrimaryReplicaSyncer.ResyncTask(
            IndexShardTestUtils.getFakeDiscoveryNodes(shard.routingEntry())
                } finally {
                assertThat(resyncTask.getTotalOperations(), equalTo(numDocs));
    }
        );
            null,
            Collections.emptyMap()
            try (
                }
            assertTrue("Sync action was not called", syncActionCalled.get());
        CountDownLatch syncCalledLatch = new CountDownLatch(1);
            null,
    public void testSyncerSendsOffCorrectDocuments() throws Exception {
        try {
        for (int i = 0; i < numDocs; i++) {
        XContentBuilder jsonBuilder = XContentFactory.jsonBuilder();
            @Override
            "type",
 * software distributed under the License is distributed on an
        assertEquals(globalCheckPoint, shard.getLastKnownGlobalCheckpoint());
/*
        };
            }
            null,
import java.util.List;
