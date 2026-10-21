        boolean completeRecovery = bytesToRecover == 0 || randomBoolean();
            @Override
        assertTrue(timer.time() > 0);
        Thread modifyThread = new Thread() {
            @Override
                stop.set(true);
        streamer.join();
        assertThat(lastRead.checkIndexTime(), equalTo(took));
        if (completeRecovery == false) {
/*
            Exception t = error.get();
        Collections.shuffle(Arrays.asList(files), random());
 * the Apache License, Version 2.0 (the "License"); you may
            return lastRead;
    }
            assertThat(translog.totalOperations(), equalTo(Translog.UNKNOWN));
        }
            assertThat(streamer.lastRead().totalOperationsOnStart(), lessThanOrEqualTo(totalOpsOnStart));
            shardRouting.recoverySource().getType() == RecoverySource.Type.PEER ? discoveryNode : null
        }
        }
        index.setFileDetailsComplete();
        list.addAll(Arrays.asList(stages));
            assertThat(streamer.lastRead().recoveredOperations(), greaterThanOrEqualTo(0));
    private void doTimerTest(ReplicationTimer timer, Streamer<? extends ReplicationTimer> streamer) throws Exception {
import static org.hamcrest.Matchers.either;
            BytesStreamOutput out = new BytesStreamOutput();
            if (reused) {
                    index.addFileDetail(randomAlphaOfLength(10), 100, true);
                index.addFileDetail("t_" + i, randomIntBetween(1, 100), randomBoolean());
            stopped = true;
            @Override
                }
            T obj = deserialize(in);
        Streamer<ReplicationLuceneIndex> readWriteIndex = new Streamer<ReplicationLuceneIndex>(stop, index) {
        readWriteIndex.start();
        }
    }
        assertThat(lastRead.sourceThrottling(), equalTo(index.sourceThrottling()));
        assertEquals(timer.stopTime(), lastRead.stopTime());
        assertThat(lastRead.totalOperations(), equalTo(totalOps));
            if (t != null) {
            }
 * this work for additional information regarding copyright
 *
        assertThat(index.reusedBytes(), equalTo(totalReusedBytes));
            }
            assertThat(streamer.lastRead().totalOperations(), lessThanOrEqualTo(totalOps));
            took = Math.max(0L, took);
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                }
        ShardRouting shardRouting = TestShardRouting.newShardRouting(
                    index.addTargetThrottling(randomIntBetween(0, 20));
        AtomicBoolean stop = new AtomicBoolean();
import static org.opensearch.test.VersionUtils.randomVersion;
                return new Translog(in);
        assertThat(index.targetThrottling().nanos(), equalTo(ReplicationLuceneIndex.UNKNOWN));
            assertThat(streamer.lastRead().recoveredPercent(), either(greaterThanOrEqualTo(0.f)).or(equalTo(-1.f)));
            assertThat(translog.recoveredOperations(), equalTo(ops));
        AtomicBoolean streamShouldStop = new AtomicBoolean();
        translog.start();
        // but reset should be always possible.
            ShardRoutingState.INITIALIZING
            int j = randomValueOtherThan(i, () -> randomIntBetween(0, stages.length - 1));
            }
        boolean stopped = false;
 * this file be licensed under the Apache-2.0 license or a
        assertThat(readWriteIndex.error.get(), equalTo(null));
                while (shouldStop.get() == false) {
        if (randomBoolean()) {
        } else {
        };
            assertThat(lastRead.time(), equalTo(translog.time()));
    public void testVerifyIndexTimer() throws Throwable {
            ReplicationLuceneIndex createObj(StreamInput in) throws IOException {
                new ShardId("bla", "_na_", 0),
            assertThat(lastRead.time(), lessThanOrEqualTo(index.time()));
        assertTrue(timer.startTime() > 0);
            final long throttledOnSource = rarely() ? randomIntBetween(10, 200) : 0;
    }
        assertThat(index.totalFileCount(), equalTo(files.length));
            logger.info("performing partial recovery ([{}] bytes of [{}])", bytesToRecover, totalFileBytes - totalReusedBytes);
    }
        assertThat(index.recoveredFilesPercent(), equalTo((float) 0.0));
                throw t;
                index.setFileDetailsComplete();
        assertEquals(0, lastRead.time());
            assertThat((double) index.recoveredFilesPercent(), equalTo(100.0));
                    translog.incrementRecoveredOperations();
        readWriteIndex.join();
        abstract T createObj(StreamInput in) throws IOException;
        final long time = lastRead.time();
        ArrayList<FileMetadata> filesToRecover = new ArrayList<>();
            }
 * Modifications Copyright OpenSearch Contributors. See
            final int fileLength = randomIntBetween(1, 1000);
        assertThat(index.totalRecoverBytes(), equalTo(totalFileBytes - totalReusedBytes));
        assertEquals(0, lastRead.startTime());
        backgroundReader.start();
            assertThat((double) index.recoveredBytesPercent(), closeTo(100.0 * index.recoveredBytes() / index.totalRecoverBytes(), 0.1));
            ReplicationTimer createObj(StreamInput in) throws IOException {
 * under the License.
        assertEquals(0, timer.stopTime());
        assertThat(lastRead.startTime(), equalTo(index.startTime()));
        doTimerTest(timer, streamer);
            this(shouldStop, source, randomVersion(random()));
        if (randomBoolean()) {
            }
        }
        } else {
        if (completeRecovery) {
                translog.incrementRecoveredOperations();
import org.opensearch.indices.replication.common.ReplicationLuceneIndex;
        if (stopped) {
        assertThat(index.targetThrottling().nanos(), equalTo(targetThrottling));
            for (Stage stage : stages) {
        assertThat(state.getStage(), equalTo(Stage.DONE));
            stages[i] = stages[j];
            assertThat((double) index.recoveredBytesPercent(), equalTo(100.0));
        assertEquals(timer.time(), lastRead.time());
            VerifyIndex createObj(StreamInput in) throws IOException {
            this.shouldStop = shouldStop;
        assertThat(index.sourceThrottling().nanos(), equalTo(sourceThrottling));
        }
        for (int i = scaledRandomIntBetween(10, 200); i > 0; i--) {
        // force one
import org.opensearch.indices.recovery.RecoveryState.Translog;
        assertThat(verifyIndex.checkIndexTime(), equalTo(took));
import org.opensearch.indices.replication.common.ReplicationTimer;
                }
        if (stopped) {
        boolean stopped = false;
        VerifyIndex lastRead = streamer.serializeDeserialize();
        int iters = randomIntBetween(10, 100);
        FileMetadata f = new FileMetadata("foo", randomIntBetween(0, 100), randomBoolean());
            this.source = source;
        ReplicationLuceneIndex index = new ReplicationLuceneIndex();
            translog.reset();
            assertThat(filesToRecover.size(), equalTo(0));
        assertThat(index.totalRecoverFiles(), equalTo(files.length - totalReused));
        protected T deserialize(StreamInput in) throws IOException {
                sourceThrottling = throttledOnSource;
/*
        }
        assertThat(index.recoveredFilesPercent(), equalTo(filesToRecover.size() == 0 ? 100.0f : 0.0f));
            int i = randomIntBetween(0, stages.length - 1);
        assertThat(index.bytesStillToRecover(), equalTo(totalFileBytes - totalReusedBytes - recoveredBytes));
import org.opensearch.core.common.io.stream.Writeable;
 * You may obtain a copy of the License at
    public void testStageSequenceEnforcement() {
        }
        }
            took = 0;
        assertThat(lastRead.checkIndexTime(), equalTo(0L));
        public void run() {
            return createObj(in);
        }
            assertThat(lastRead.time(), equalTo(verifyIndex.time()));
                state.setStage(stage);
 * The OpenSearch Contributors require contributions made to
            index.addTargetThrottling(throttledOnTarget);
        final Translog lastRead = streamer.lastRead();
            new ShardId("bla", "_na_", 0),
            index.addRecoveredBytesToFile(file.name(), toRecover);
        stop.set(true);
            totalFileBytes += fileLength;
        long targetThrottling = ReplicationLuceneIndex.UNKNOWN;
        Stage[] stages = Stage.values();
            lastRead = obj;
                return new ReplicationLuceneIndex(in);
        long totalFileBytes = 0;
                closeTo(100.0 * index.recoveredFileCount() / index.totalRecoverFiles(), 0.1)
                sourceThrottling += throttledOnSource;
        assertThat(index.bytesStillToRecover(), equalTo(totalFileBytes - totalReusedBytes));
            files[i] = new FileMetadata("f_" + i, fileLength, reused);
    }
        verifyIndex.checkIndexTime(took);
                randomBoolean(),
    }
                ShardRoutingState.INITIALIZING
                    state.getIndex().setFileDetailsComplete();
            assertThat(verifyIndex.checkIndexTime(), equalTo(took));
        int totalOpsOnStart = randomIntBetween(10, 200);
 * GitHub history for details.
        );
            } else {
        for (int i = 0; i < iters; i++) {
                return new ReplicationLuceneIndex(in);
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertThat(lastRead.recoveredOperations(), equalTo(ops));
        final ReplicationLuceneIndex lastRead = backgroundReader.lastRead();
        AtomicBoolean stop = new AtomicBoolean();
        assertEquals("captured time shouldn't change", time, lastRead.time());
import org.opensearch.Version;
        assertThat(lastRead.stopTime(), equalTo(verifyIndex.stopTime()));
            assertThat(lastRead.time(), lessThanOrEqualTo(verifyIndex.time()));
        assertThat(index.recoveredFileCount(), equalTo(0));
                if (randomBoolean()) {
            } else if (f.hashCode() != anotherFile.hashCode()) {
                    translog.decrementRecoveredOperations(1);
            totalOps = Translog.UNKNOWN;
import org.opensearch.cluster.node.DiscoveryNode;
        Streamer<ReplicationLuceneIndex> streamer = new Streamer<>(stop, index) {
    public void testIndex() throws Throwable {
                shardRouting.recoverySource().getType() == RecoverySource.Type.PEER ? discoveryNode : null
    public void testStart() throws IOException {
        long took = randomLong();
        AtomicBoolean stop = new AtomicBoolean();
        doTimerTest(verifyIndex, streamer);
import static java.util.Collections.emptySet;
        if (randomBoolean()) {
            final boolean reused = randomBoolean();
        final ReplicationLuceneIndex index = new ReplicationLuceneIndex();
            }
                return new ReplicationTimer(in);
public class RecoveryTargetTests extends OpenSearchTestCase {
        logger.info("testing initial information");
import org.opensearch.indices.recovery.RecoveryState.Stage;
        }
        backgroundReader.join();
        while (bytesToRecover > 0) {
            );
import static org.hamcrest.Matchers.equalTo;
        }
 *
        for (int i = 0; i < files.length; i++) {
            Stage t = stages[i];
import static org.hamcrest.Matchers.lessThanOrEqualTo;
                    serializeDeserialize();
        if (randomBoolean()) {
                assertFalse(f.equals(anotherFile));
        };
        assertThat(index.recoveredBytesPercent(), equalTo(filesToRecover.size() == 0 ? 100.0f : 0.0f));
        for (FileMetadata file : files) {
        final AtomicReference<Exception> error = new AtomicReference<>();
        index.start();
        lastRead = streamer.serializeDeserialize();
            if (sourceThrottling == ReplicationLuceneIndex.UNKNOWN) {
import org.opensearch.core.common.io.stream.StreamInput;
                }
        assertThat(index.recoveredBytes(), equalTo(0L));
        // validate captured time
        ArrayList<Stage> list = new ArrayList<>(Arrays.asList(Arrays.copyOfRange(stages, 0, i)));
            index.addSourceThrottling(throttledOnSource);
            FileMetadata file = randomFrom(filesToRecover);
        Streamer(AtomicBoolean shouldStop, T source, Version streamVersion) {
        assertEquals(0, timer.stopTime());
            return obj;
        assertThat(index.bytesStillToRecover(), equalTo(-1L));
            } catch (Exception e) {
        int totalReused = 0;
            stopped = true;
            out.close();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        timer.start();
import java.util.concurrent.atomic.AtomicBoolean;
            if (randomBoolean()) {
        assertThat(index.sourceThrottling().nanos(), equalTo(ReplicationLuceneIndex.UNKNOWN));
        Streamer<ReplicationTimer> streamer = new Streamer<>(stop, timer) {
import org.opensearch.test.OpenSearchTestCase;
        assertThat(index.recoveredBytes(), equalTo(recoveredBytes));
import static org.hamcrest.Matchers.startsWith;
            for (int j = iterationOps; j > 0; j--) {
            if (randomBoolean()) {
        Streamer(AtomicBoolean shouldStop, T source) {
                discoveryNode,
            assertThat(lastRead.time(), lessThanOrEqualTo(translog.time()));
                shardRouting,
        private final T source;
        };
    public void testTranslogTimer() throws Throwable {
        Streamer<VerifyIndex> streamer = new Streamer<VerifyIndex>(stop, verifyIndex) {
        if (took < 0) {
        // we don't need to test the time aspect, it's done in the timer test
    public void testTimer() throws Throwable {
        verifyIndex.start();
import org.opensearch.cluster.routing.ShardRouting;
import static org.hamcrest.Matchers.closeTo;
    }
        } else {
                assertEquals(f.hashCode(), anotherFile.hashCode());
        assertThat(lastRead.startTime(), equalTo(translog.startTime()));
            final long toRecover = Math.min(bytesToRecover, randomIntBetween(1, (int) (file.length() - file.recovered())));
import java.util.Arrays;
        assertThat(index.totalRecoverBytes(), equalTo(totalFileBytes - totalReusedBytes));
        FileMetadata[] files = new FileMetadata[randomIntBetween(1, 20)];
            try {
        assertEquals(f.hashCode(), anotherFile.hashCode());
        final ReplicationLuceneIndex index = new ReplicationLuceneIndex();
 * Unless required by applicable law or agreed to in writing,
        int ops = 0;
            final long throttledOnTarget = rarely() ? randomIntBetween(10, 200) : 0;
            index.start();
        assertThat(index.reusedFileCount(), equalTo(totalReused));
        assertThat(lastRead.stopTime(), equalTo(index.stopTime()));
            if (f.equals(anotherFile)) {
            }
            index.stop();
    public void testTranslog() throws Throwable {
        @Override
        assertThat(index.recoveredFileCount(), equalTo(index.totalRecoverFiles() - filesToRecover.size()));
 * specific language governing permissions and limitations
        assertBusy(() -> assertTrue("timer timer should progress compared to captured one ", time < timer.time()));
            assertThat(index.time(), greaterThanOrEqualTo(0L));
        public T serializeDeserialize() throws IOException {
            source.writeTo(out);
            assertThat(translog.totalOperationsOnStart(), equalTo(Translog.UNKNOWN));
        };
                if (randomBoolean()) {
            bytesToRecover = randomIntBetween(1, (int) bytesToRecover);
            this.streamVersion = streamVersion;
        assertEquals(0, timer.startTime());
        lastRead = streamer.serializeDeserialize();
            }
        }
        }
        final DiscoveryNode discoveryNode = new DiscoveryNode("1", buildNewFakeTransportAddress(), emptyMap(), emptySet(), Version.CURRENT);
        private final AtomicBoolean shouldStop;
            }
        public T lastRead() throws Throwable {
        for (Stage stage : list) {
        };
 *
    }
            }
            } else {
        assertEquals(0, timer.time());
            }
            }
        timer.stop();
        };
        });
        logger.info("testing serialized information");
 * compatible open source license.
        }
            shardRouting,
/*
        assertThat(index.totalFileCount(), equalTo(files.length));
        assertThat(index.totalRecoverFiles(), equalTo(filesToRecover.size()));
            if (targetThrottling == ReplicationLuceneIndex.UNKNOWN) {
        doTimerTest(index, streamer);
            totalOps += iterationOps;
                (double) index.recoveredFilesPercent(),
        assertTrue(timer.stopTime() >= timer.startTime());
                error.set(e);
            verifyIndex.stop();
            assertThat(translog.recoveredOperations(), equalTo(0));
                }
            }
import org.opensearch.indices.recovery.RecoveryState.VerifyIndex;
            }
            assertThat(
        final VerifyIndex verifyIndex = new VerifyIndex();
        assertThat(lastRead.startTime(), equalTo(verifyIndex.startTime()));
            );
        }
            @Override
        final AssertionError error = expectThrows(AssertionError.class, () -> {
        }
        // validate captured time
    }
            index.addFileDetail(file.name(), file.length(), file.reused());
                targetThrottling = throttledOnTarget;
                totalReused++;
            bytesToRecover -= toRecover;
            translog.totalOperations(totalOps);
        // before we start we must report 0
            }
            anotherFile = new FileMetadata(f.name(), randomIntBetween(0, 100), randomBoolean());
                    index.addSourceThrottling(randomIntBetween(0, 20));
                serializeDeserialize();
import java.io.IOException;
import java.util.Collections;
        if (completeRecovery) {
 * SPDX-License-Identifier: Apache-2.0
                return new Translog(in);
                targetThrottling += throttledOnTarget;
        FileMetadata anotherFile = new FileMetadata(f.name(), f.length(), f.reused());
            @Override
    public void testIndexTimer() throws Throwable {
            @Override
        timer.reset();
            }
            stages[j] = t;
        streamer.start();
        assertEquals(0, lastRead.stopTime());
            discoveryNode.getId(),
            f = new FileMetadata("foo", randomIntBetween(0, 100), randomBoolean());
                return new VerifyIndex(in);
        } else {
        assertEquals(timer.startTime(), lastRead.startTime());
            index.reset();
            }
        };
        modifyThread.start();
            Translog createObj(StreamInput in) throws IOException {
            @Override
import org.opensearch.indices.replication.common.ReplicationLuceneIndex.FileMetadata;
            ops = 0;
            assertThat(streamer.lastRead().recoveredOperations(), lessThanOrEqualTo(ops));
 * Licensed to Elasticsearch under one or more contributor
                if (randomBoolean()) {
        // force one
            discoveryNode,
        VerifyIndex verifyIndex = new VerifyIndex();
        long bytesToRecover = totalFileBytes - totalReusedBytes;
            verifyIndex.reset();
 * ownership. Elasticsearch licenses this file to you under
        logger.info("testing post recovery");
        // we don't need to test the time aspect, it's done in the timer test
            }
            ShardRouting shardRouting = TestShardRouting.newShardRouting(
import org.opensearch.cluster.routing.ShardRoutingState;
        assertThat(index.recoveredBytesPercent(), equalTo((float) 0.0));
    }
        assertThat(lastRead.targetThrottling(), equalTo(index.targetThrottling()));
        doTimerTest(translog, streamer);
        lastRead = streamer.serializeDeserialize();
        if (index.totalRecoverFiles() == 0) {
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.routing.TestShardRouting;
        assertThat(lastRead.totalOperationsOnStart(), equalTo(totalOpsOnStart));
        );
            }
        assertEquals(f, anotherFile);
            }
        streamer.serializeDeserialize();
        AtomicBoolean stop = new AtomicBoolean();
            translog.stop();
        assertThat(lastRead.fileDetails().toArray(), arrayContainingInAnyOrder(index.fileDetails().toArray()));
        assertThat(translog.recoveredOperations(), equalTo(0));
                filesToRecover.add(files[i]);
    public void testFileHashCodeAndEquals() {
            StreamInput in = out.bytes().streamInput();
            @Override
        AtomicBoolean stop = new AtomicBoolean();
        assertThat(index.totalBytes(), equalTo(totalFileBytes));
            Stage[] stages = Stage.values();
            for (int i = randomIntBetween(0, 10); i > 0; i--) {
import static java.util.Collections.emptyMap;
                return new ReplicationLuceneIndex(in);
        if (randomBoolean()) {
 */
        int totalOps = 0;
        assertThat(verifyIndex.checkIndexTime(), equalTo(0L));
                }
        long recoveredBytes = 0;
                ops++;
            );
            }
            assertThat(lastRead.time(), equalTo(index.time()));
        AtomicBoolean stop = new AtomicBoolean();
        final AtomicBoolean stop = new AtomicBoolean(false);
 * license agreements. See the NOTICE file distributed with
            if (stage == Stage.INDEX) {
            if (file.reused() || file.fullyRecovered()) {
        int i = randomIntBetween(1, stages.length - 1);
        }
        assertThat(index.bytesStillToRecover(), equalTo(-1L));
        translog.totalOperationsOnStart(totalOpsOnStart);
        final Translog translog = new Translog();
        }
            }
        long totalReusedBytes = 0;
        private T lastRead;
        RecoveryState state = new RecoveryState(
import org.opensearch.core.index.shard.ShardId;
        }
        Streamer<VerifyIndex> streamer = new Streamer<>(stop, verifyIndex) {
        }
import java.util.ArrayList;
        assertThat(error.getMessage(), startsWith("can't move recovery to stage"));
                if (stage == Stage.FINALIZE) {
        };
        assertThat(translog.totalOperations(), equalTo(Translog.UNKNOWN));
            ReplicationLuceneIndex createObj(StreamInput in) throws IOException {
        ReplicationTimer lastRead = streamer.serializeDeserialize();
            public void run() {
        }
import java.util.concurrent.atomic.AtomicReference;
                return new VerifyIndex(in);
            Translog createObj(StreamInput in) throws IOException {
        assertThat(index.reusedFileCount(), equalTo(totalReused));
}
            assertThat(translog.recoveredPercent(), equalTo(100.f));
            assertThat(translog.totalOperations(), equalTo(totalOps));
        Streamer<ReplicationLuceneIndex> backgroundReader = new Streamer<ReplicationLuceneIndex>(streamShouldStop, index) {
                for (int i = 0; i < 1000; i++) {
            ReplicationLuceneIndex createObj(StreamInput in) throws IOException {
                filesToRecover.remove(file);
    }
 * software distributed under the License is distributed on an
                state.getIndex().setFileDetailsComplete();
 */
 * not use this file except in compliance with the License.
        modifyThread.join();
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
            took = -took;
            randomBoolean(),
    public void testConcurrentModificationIndexFileDetailsMap() throws InterruptedException {
package org.opensearch.indices.recovery;
        streamShouldStop.set(true);
    abstract class Streamer<T extends Writeable> extends Thread {
                totalReusedBytes += fileLength;
        assertThat(translog.totalOperationsOnStart(), equalTo(Translog.UNKNOWN));
        long sourceThrottling = ReplicationLuceneIndex.UNKNOWN;
import org.opensearch.cluster.routing.RecoverySource;
                index.stop();
        Translog translog = new Translog();
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
                discoveryNode.getId(),
            recoveredBytes += toRecover;
            assertThat((double) translog.recoveredPercent(), closeTo(100.0 * ops / totalOps, 0.1));
            RecoveryState state = new RecoveryState(
        final ReplicationTimer timer = new ReplicationTimer();
        Streamer<Translog> streamer = new Streamer<Translog>(stop, translog) {
            @Override
            state.setStage(stage);
            file.addRecoveredBytes(toRecover);
        };
        assertThat(index.reusedBytes(), equalTo(totalReusedBytes));
            VerifyIndex createObj(StreamInput in) throws IOException {
        final Version streamVersion;
 */
        }
        assertThat(lastRead.stopTime(), equalTo(translog.stopTime()));
            } else {
        assertThat(index.totalBytes(), equalTo(totalFileBytes));
    }
            final int iterationOps = randomIntBetween(1, 10);
        Streamer<Translog> streamer = new Streamer<>(stop, translog) {
            totalOpsOnStart = Translog.UNKNOWN;
            // initialize with some data and then reset
