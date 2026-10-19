import java.io.IOException;  
 *     dirty or stale read) before the forked off request gets to execute, and that one might still subsequently succeed.
        }  
        }
     * Our version, which is primaryTerm,seqNo.
        }
                history  
            outputVersion.writeTo(out);
                        IndexRequest indexRequest = new IndexRequest("test").id(partition.id)
                        if (seqNoChangePct < 10) {
 *     </li>
                            if (version.compareTo(partition.latestSuccessfulVersion()) <= 0) {
        public String toString() {  
    }
            assertThat(
            );  
            logger.info("--> terminating test");
                            // if we supplied an input version <= to latest successful version, we can safely assume that any failed
 *
        private FailureHistoryOutput(@SuppressWarnings("unused") StreamInput streamInput) {}  
 *
        private final List<Partition> partitions;
        public void assertLinearizable() {  
import org.opensearch.test.disruption.ServiceDisruptionScheme;
        versions.forEach(stateVersion -> versions.forEach(inputVersion -> versions.forEach(outputVersion -> {
 * SPDX-License-Identifier: Apache-2.0
            return output -> consumeOutput(output, eventId);  
 * Licensed to Elasticsearch under one or more contributor  
        return new NamedWriteableRegistry(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public void writeTo(StreamOutput out) throws IOException {
    public void testSeqNoCASLinearizability() {  
 *     <li>acknowledged CAS writes are guaranteed to have taken place between invocation and response and cannot be lost. It is
            Arrays.asList(
        public String getWriteableName() {
                    // we dump base64 encoded data, since the nature of this test is that it does not reproduce even with same seed.  
            )  
 */  
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, minNumDataNodes = 4, maxNumDataNodes = 6)  
        for (int i = 0; i < size; ++i) {  
        private final LinearizabilityChecker.History history = new LinearizabilityChecker.History();
                        serializedHistory
 *     <li>A CAS failure or any other failure can eventually succeed after receiving the failure response due to reroute and retries,
                if (history.size() > 300) {  
 *
            this.lastFailed = lastFailed;
import java.util.concurrent.TimeoutException;  
            .mapToObj(i -> new CASUpdateThread(i, roundBarrier, partitions, disruptTimeSeconds + 1))
            return outputVersion;
            spec.nextState(casFail(version1), version2, new IndexResponseHistoryOutput(version3)),  
                // implicitly test that we can serialize all histories.  
            State that = (State) o;  
                internalCluster().clearDisruptionScheme(false);
        public int hashCode() {
        );
            logger.info(
            out.writeLong(primaryTerm);  
        );
 *     </li>  
            int eventId = history.invoke(version);
        }
                                // interrupt often comes as a RuntimeException so check to stop here too.  
        );
                        // version exclusively we risk a single CAS fail on a dirty read to cause the same. Doing both randomly and adding  
        }  
                } catch (BrokenBarrierException e) {
                spec.nextState(casFail(stateVersion), inputVersion, new FailureHistoryOutput()),
    private static class CASSequentialSpec implements LinearizabilityChecker.SequentialSpec {
            this.latestObservedVersion = new AtomicVersion(initialVersion);
            outputVersion.writeTo(out);
 * GitHub history for details.
import org.apache.logging.log4j.message.ParameterizedMessage;  
            }
 *         response is sent back. Once connection is back, coordinator will retry against either same or new primary, but this time the
        private CASUpdateThread(int threadNum, CyclicBarrier roundBarrier, List<Partition> partitions, int timeout) {
        Version futureVersion = version.nextSeqNo(randomIntBetween(1, 10));  
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
 *         request will fail due to its own write.  
        })));
    }
                            assertThat(historyOutput.outputVersion.seqNo, greaterThan(version.seqNo));  
            }
        public String getWriteableName() {
        public Version getVersion() {  
import java.util.stream.IntStream;
                            version = version.nextTerm();  
        Version(long primaryTerm, long seqNo) {
            }
                }
                logger.info("--> round {}", i);
        @Override
        }
    public static void main(String[] args) throws Exception {  
            System.err.println("usage: <file> <primaryTerm> <seqNo>");
 *     provided the primaryTerm and seqNo still matches. The reason we cannot assume it will not take place after receiving the failure
                            // validate version and seqNo strictly increasing for successful CAS to avoid that overhead during  
            this.seqNo = input.readLong();  
        // latest version for which we got a successful response on a write.
                        }  
        logger.info("--> Indexing initial doc for {} keys", numberOfKeys);
        }
    }  
            // parsing out the version increases chance of hitting races against CAS successes, since if we did not parse this out, no
        // Generate 3 increasing versions
        public void run() {  
        }
                    roundBarrier.reset();  
 *     is that a request can fork into two because of retries on disconnect, and now race against itself. The retry might complete (and do a  
                } else {
                }
import org.opensearch.action.index.IndexResponse;  
 * Modifications Copyright OpenSearch Contributors. See  
 *         and r1 is promoted to primary. The request is repeated on r1, but this time the request fails due to its own write.</li>  
            return new Version(primaryTerm, Math.max(seqNo - decrement, 0));  
            return lastFailed ? this : casFail(safeVersion);
                            // we should be able to remove timeout or fail hard on timeouts
            // random futureTerm/futureSeqNo handling in CASUpdateThread).
            if (o == null || getClass() != o.getClass()) return false;
import java.util.concurrent.TimeUnit;
                if (input.equals(state.safeVersion) || (state.lastFailed && ((Version) input).compareTo(state.safeVersion) > 0)) {
        }  
        }
    }
                    scheduler.schedule(() -> abort.set(true), 10, TimeUnit.SECONDS);
        @Override
        @Override
 * KIND, either express or implied.  See the License for the
                        } else if (termChangePct < 10) {
                        }  
    private static final Pattern EXTRACT_VERSION = Pattern.compile("current document has seqNo \\[(\\d+)\\] and primary term \\[(\\d+)\\]");  
                if (abort.get() && linearizable == false) {
        try {
            this.roundBarrier = roundBarrier;  
            return Base64.getEncoder().encodeToString(BytesReference.toBytes(output.bytes()));  
            LinearizabilityChecker.SequentialSpec spec = new CASSequentialSpec(initialVersion);
        public Version latestObservedVersion() {  
        }
        public Version nextTerm() {
        output.writeNamedWriteable((NamedWriteable) event.value);
                // heal cluster faster to reduce test time.  
 *     stale or dirty, i.e., come from a stale primary or belong to a write that ends up being discarded.</li>  
        private CASFailureHistoryOutput(StreamInput input) throws IOException {
        is = new NamedWriteableAwareStreamInput(is, createNamedWriteableRegistry());
        }
     * We treat CAS failures (version conflicts) identically to failures in linearizability checker, but keep this separate
     */
    private class CASUpdateThread extends Thread {
                            // this is the guarantee we offer.  
            .mapToObj(i -> client().prepareIndex("test").setId("ID:" + i).setSource("value", -1).get())  
            return casSuccess(initialVersion);
                            historyResponse.accept(historyOutput);
        try {
 * <p>The following is a summary of the expected CAS write behaviour of the system:</p>
        public void consume(Version version) {  
            this.latestSuccessfulVersion = new AtomicVersion(initialVersion);  
        @Override
            this(new Version(input));  
            assertThat(  
            return "Fail";  
        } else {  
            threads.forEach(CASUpdateThread::await);
        public String toString() {
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;  
            return Long.compare(seqNo, other.seqNo);
                    }
            input.readInt()
                return new Version(Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(1)));
                "--> Linearizability checking history of size: {} for key: {} and initialVersion: {}: {}",
 * specific language governing permissions and limitations
            boolean linearizable = false;  
 *     see above.</li>  
        }
        private CASFailureHistoryOutput(VersionConflictEngineException exception) {
                            IndexResponseHistoryOutput historyOutput = new IndexResponseHistoryOutput(indexResponse);
            return "index";  
            } catch (RuntimeException e) {  
    private static class IndexResponseHistoryOutput implements HistoryOutput {  
            if (this == o) return true;
    }
            this(new Version(response.getPrimaryTerm(), response.getSeqNo()));
    public void testSequentialSpec() {
 *     Such writes are not necessarily fully replicated and can be lost. There is no  
        @Override
/*  
            assertThat(  
        }
import org.opensearch.core.common.io.stream.StreamInput;
 *  
 *     necessarily before response. Such writes are not necessarily fully replicated and can be lost.  
            spec.nextState(casSuccess(version1), version1, new IndexResponseHistoryOutput(version2)),
            );
                        "Linearizability check failed. Spec: {}, initial version: {}, serialized history: {}",
import java.util.regex.Matcher;
                latestSuccessfulVersion.consume(output.getVersion());
                    linearizable = true; // let the test pass  
    }
                                historyResponse.accept(new FailureHistoryOutput());
 *     <li>A CAS can fail on a dirty read, i.e., a non-replicated write that ends up being discarded.</li>  
            return current.get();  
            } finally {
import java.util.ArrayList;
        LinearizabilityChecker.History history = readHistory(is);  
                new NamedWriteableRegistry.Entry(NamedWriteable.class, "version", Version::new),
/*
        @Override
                    // this is timeout on the barrier, unexpected.
        if (args.length < 3) {
 *     the newest primary (could be isolated or just not have been told yet). So a CAS check is suspect to stale reads (like any
            threads.stream().filter(Thread::isAlive).forEach(t -> fail("Thread still alive: " + t));
                                return;
                equalTo(Optional.of(casFail(stateVersion)))
    private static class CASFailureHistoryOutput implements HistoryOutput {
        }  
        public Consumer<HistoryOutput> invoke(Version version) {  
                new NamedWriteableRegistry.Entry(NamedWriteable.class, "index", IndexResponseHistoryOutput::new),  
 *
                Matcher matcher = EXTRACT_VERSION.matcher(message);  
 * Unless required by applicable law or agreed to in writing,
        List<LinearizabilityChecker.Event> events = new ArrayList<>(size);
                    return Optional.empty();
        public String toString() {
                initialVersion,
        private final Version safeVersion;
                            version = version.nextSeqNo(random.nextInt(4) + 1);
                equalTo(Optional.of(casFail(stateVersion)))  
import org.opensearch.action.index.IndexRequest;
            return new Version(primaryTerm + 1, seqNo);  
        public State failed() {
                            }
 * the Apache License, Version 2.0 (the "License"); you may
            return new Version(primaryTerm, seqNo + increment);
                ensureFullyConnectedCluster();
                        }
        return futureVersion;
            }  
        }  
        @Override
    }  
 *     read) and can thus fail due to reading stale data. Notice that a CAS success is fully replicated and thus guaranteed to not  
        private final AtomicVersion latestSuccessfulVersion;
        assertThat(spec.nextState(casSuccess(version1), version2, new IndexResponseHistoryOutput(version3)), equalTo(Optional.empty()));  
            logger.error("Timed out, dumping stack traces of all threads:");
    }
import org.opensearch.threadpool.Scheduler;
                            );
/*
                        } else if (seqNoChangePct < 15) {  
                Thread.currentThread().interrupt();
            return "casfail";
            events.add(readEvent(input));
        public Version latestSuccessfulVersion() {
        }
 *     <li>A CAS can fail on stale reads. A CAS failure is only checked on the supposedly primary node. However, the primary might not be
    }  
package org.opensearch.versioning;
 * software distributed under the License is distributed on an
        Version(StreamInput input) throws IOException {
    private static void runLinearizabilityChecker(FileInputStream fileInputStream, long primaryTerm, long seqNo) throws IOException {
            // writes would succeed after a fail on own write failure (unless we were lucky enough to guess the seqNo/primaryTerm using the  
        public Version previousSeqNo(int decrement) {
        private final String id;
        @Override
                runLinearizabilityChecker(fis, Long.parseLong(args[1]), Long.parseLong(args[2]));
        private IndexResponseHistoryOutput(IndexResponse response) {  
        assertThat(
import java.util.concurrent.atomic.AtomicBoolean;
import java.io.FileInputStream;
    private class Partition {  
 *  
                            if (stop) {
            return primaryTerm == version.primaryTerm && seqNo == version.seqNo;
                        // all future CAS'es would fail unless we guess the seqno/term below. On the other hand, using latest observed
        private final Version initialVersion;
                    for (int i = 0; i < numberOfUpdates; ++i) {  
            return Objects.hash(primaryTerm, seqNo);
        }  
     */
        @Override  
                linearizable = new LinearizabilityChecker().isLinearizable(spec, history, missingResponseGenerator(), abort::get);  
 * A deeper technical explanation of the behaviour is given here:
                            version = version.previousSeqNo(random.nextInt(4) + 1);
        }  
            return "{" + "primaryTerm=" + primaryTerm + ", seqNo=" + seqNo + '}';
import org.opensearch.discovery.AbstractDisruptionTestCase;
                        } catch (RuntimeException e) {
 *     suffer from stale (or dirty) reads.
 *         <li>A coordinator sends write to primary, which stores write successfully (and replicates it). Connection is lost before
            }
    }  
        }
                            // operation will no longer be able to complete after the next successful write and we can therefore terminate  
        private final Random random = new Random(randomLong());
 * <ul>  
 *     </li>
                if (linearizable == false) {
        StreamInput is = new InputStreamStreamInput(Base64.getDecoder().wrap(fileInputStream));  
import org.opensearch.threadpool.ThreadPool;  
        assertThat(spec.initialState(), equalTo(casSuccess(version1)));
    private static final class State {
    private static Function<Object, Object> missingResponseGenerator() {
        }  
     * to parse out the latest observed version and to ease debugging.
            return outputVersion;
    private static LinearizabilityChecker.Event readEvent(StreamInput input) throws IOException {  
                            // linearizability checking.
        output.writeInt(event.id);  
            Version version = (Version) o;
            );
 * compatible open source license.
        }
            if (output instanceof IndexResponseHistoryOutput) {
        public void await() {
                }
                } catch (TimeoutException e) {
 *     version conflict response. Even though we might observe the write (by reading (not done in this test) or another CAS write), the
                            }  
            try {
 *     the next request. It is contained in the message (and we parse it out in the test), but notice that the numbers given here could be
                        spec,  
 * You may obtain a copy of the License at  
        }
import java.util.Objects;
                        } catch (VersionConflictEngineException e) {
            this.current.updateAndGet(current -> version.compareTo(current) <= 0 ? current : version);
            try {
 *     produce dirty writes on a stale primary).  
 */
                equalTo(Optional.of(casFail(stateVersion)))
            logger.info("--> Running {} rounds", rounds);
                        final Partition partition = partitions.get(keyIndex);
    private static void writeEvent(LinearizabilityChecker.Event event, BytesStreamOutput output) throws IOException {  
                            IndexResponse indexResponse = client().index(indexRequest).actionGet(timeout, TimeUnit.SECONDS);  
    }
        @Override  
            try (FileInputStream fis = new FileInputStream(args[0])) {
                final ScheduledThreadPoolExecutor scheduler = Scheduler.initScheduler(Settings.EMPTY);
import org.opensearch.core.common.io.stream.NamedWriteable;
    private static class FailureHistoryOutput implements HistoryOutput {
                String serializedHistory = base64Serialize(history);
        return new State(stateVersion, true);
        public int hashCode() {  
                            // the operation wrt. linearizability.
        Version version2 = futureVersion(version1);
        private State(Version safeVersion, boolean lastFailed) {
            if (this == o) return true;
            this.timeout = timeout;
                                historyResponse.accept(new CASFailureHistoryOutput(e));
                new NamedWriteableRegistry.Entry(NamedWriteable.class, "casfail", CASFailureHistoryOutput::new),
                spec.nextState(casFail(stateVersion), inputVersion, new CASFailureHistoryOutput(outputVersion)),
        public Object initialState() {  
        }  
                            // if we supplied an input version <= latest successful version, we can safely assume that any failed
        public String toString() {  
 * ownership. Elasticsearch licenses this file to you under  
 */
            this.seqNo = seqNo;
                writeEvent(event, output);  
        private AtomicVersion(Version initialVersion) {
    private static NamedWriteableRegistry createNamedWriteableRegistry() {
            throw new RuntimeException(e);  
            return "fail";
import java.util.concurrent.ScheduledThreadPoolExecutor;
        Version version3 = futureVersion(version2);
    }  
        );
 * license agreements. See the NOTICE file distributed with
                id,
        public String getWriteableName() {
        assertThat(
    private static State casFail(Version stateVersion) {  
        }
                roundBarrier.await(1, TimeUnit.MINUTES);  
    }
                    // a thread can go here either because it completed before disruption ended, timeout on main thread causes broken
            State state = (State) currentState;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        );
 *     guarantee that the previous value did not have the specified primaryTerm and seqNo</li>
            latestObservedVersion.consume(output.getVersion());  
            }  
 * The OpenSearch Contributors require contributions made to  
        int numberOfKeys = randomIntBetween(1, 10);
                        initialVersion,
        @Override
            return "CASFail{" + outputVersion + "}";  
        @Override  
        LinearizabilityChecker.SequentialSpec spec = new CASSequentialSpec(version1);  
                        // CAS'es and races. If we were to use only the latest successful version, any CAS fail on own write would mean that
    }
        private void consumeOutput(HistoryOutput output, int eventId) {  
        return new State(version1, false);
                    return Optional.of(casSuccess(((IndexResponseHistoryOutput) output).getVersion()));  
        private CASFailureHistoryOutput(Version outputVersion) {  
            while (stop == false) {
 *     </li>
            prepareCreate("test").setSettings(
        BytesStreamOutput output = new BytesStreamOutput();
                            // operation will no longer be able to complete after the next successful write and we can therefore terminate  
            this.partitions = partitions;
            this.outputVersion = outputVersion;
        public void writeTo(StreamOutput out) throws IOException {  
        public String toString() {
        public final long seqNo;  
    private static LinearizabilityChecker.History readHistory(StreamInput input) throws IOException {  
                disruptionScheme.startDisrupting();
        }
 *     guaranteed that the previous value had the specified primaryTerm and seqNo</li>  
                    .put(indexSettings())  
        Version initialVersion = new Version(primaryTerm, seqNo);
    }
        }
                Settings.builder()
            assertThat(
                history.size(),  
 *    http://www.apache.org/licenses/LICENSE-2.0
            history,
        private static Version parseException(String message) {
        private Partition(String id, Version initialVersion) {
                try {
        }  
            input.readNamedWriteable(NamedWriteable.class),  
        public boolean equals(Object o) {  
            return new Version(primaryTerm - 1, seqNo);
                try {  
                ThreadPool.terminate(scheduler, 1, TimeUnit.SECONDS);
import java.util.concurrent.atomic.AtomicReference;
        }  
        public Version getVersion() {
            return "State{" + "safeVersion=" + safeVersion + ", lastFailed=" + lastFailed + '}';
        System.out.println("Linearizable?: " + result);
            .collect(Collectors.toList());
                            // todo: collect the failed responses and terminate when CAS with higher output version is successful, since
            this.current = new AtomicReference<>(initialVersion);
        // for non version conflict failures, we keep state version with lastFailed set, regardless of input version.
        private final CyclicBarrier roundBarrier;  
        }
                        Consumer<HistoryOutput> historyResponse = partition.invoke(version);  
                join(60000);  
        threads.forEach(Thread::start);  
                                e  
        @Override  
        }  
import org.opensearch.common.SuppressForbidden;  
        }
    }
            );  
        private IndexResponseHistoryOutput(Version outputVersion) {
        );
            .map(response -> new Partition(response.getId(), new Version(response.getPrimaryTerm(), response.getSeqNo())))
        int threadCount = randomIntBetween(3, 20);
        System.out.println(LinearizabilityChecker.visualize(new CASSequentialSpec(initialVersion), history, missingResponseGenerator()));  
import org.opensearch.core.common.bytes.BytesReference;  
    /**
    // multiple threads doing CAS updates.  
        }
            equalTo(Optional.of(casSuccess(version3)))
            .collect(Collectors.toList());  
                    int numberOfUpdates = randomIntBetween(3, 13) * partitions.size();
import org.opensearch.cluster.coordination.LinearizabilityChecker;
    }
                    roundBarrier.await(70, TimeUnit.SECONDS);  
        @Override
        }
        }  
import java.util.concurrent.BrokenBarrierException;
                }
        }
            this.outputVersion = outputVersion;  
        }));
        }  
        if (randomBoolean()) futureVersion = futureVersion.nextTerm();
            this.initialVersion = initialVersion;
                spec.nextState(casSuccess(stateVersion), inputVersion, new FailureHistoryOutput()),
        private final boolean lastFailed;  
            this.primaryTerm = input.readLong();
                        // variance to seqno/term should ensure we progress fine in most runs.
        return new LinearizabilityChecker.History(events);  
                            .setIfPrimaryTerm(version.primaryTerm)
                            logger.info(
                        Version version = random.nextBoolean() ? partition.latestObservedVersion() : partition.latestSuccessfulVersion();
 * <p>
                return Optional.of(state.failed());
                        try {
            return latestSuccessfulVersion.get();  
        @Override
import java.util.stream.Collectors;
    /**
        }
    private static class AtomicVersion {
     */  
            setDaemon(true);  
            if (termCompare != 0) return termCompare;
        // for version conflicts, we keep state version with lastFailed set, regardless of input/output version.
        public void writeTo(StreamOutput out) throws IOException {
        @Override  
            if (output instanceof IndexResponseHistoryOutput) {
import java.util.concurrent.CyclicBarrier;  
        }
        @Override
                spec.nextState(casSuccess(stateVersion), inputVersion, new CASFailureHistoryOutput(outputVersion)),
    }
        }
        assertThat(spec.nextState(casSuccess(version2), version1, new IndexResponseHistoryOutput(version3)), equalTo(Optional.empty()));
        partitions.forEach(Partition::assertLinearizable);
                            .source("value", random.nextInt())  
            this.initialVersion = initialVersion;
        }
}
            this.interrupt();
            logger.debug("response partition ({}) event ({}) output ({})", id, eventId, output);
    }
 *     <ul>
            assertTrue("Must be linearizable", linearizable);  
                equalTo(Optional.of(casFail(stateVersion)))  
    private Version futureVersion(Version version) {
                            // this is the guarantee we offer.  
            this.id = id;
    // Test info: disrupt network for up to 8s in a number of rounds and check that we only get true positive CAS results when running
import java.util.Optional;  
        int size = input.readInt();
                    );  
import static org.hamcrest.Matchers.equalTo;
    private String base64Serialize(LinearizabilityChecker.History history) {  
                        if (termChangePct < 5) {
            input.readEnum(LinearizabilityChecker.EventType.class),
            threads.forEach(CASUpdateThread::terminate);  
import java.util.regex.Pattern;  
                }
        Version getVersion();  
        private final AtomicReference<Version> current;
                } catch (TimeoutException e) {
import org.opensearch.core.common.io.stream.StreamOutput;  
        } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {  
            // nothing to write.
                        // we use either the latest observed or the latest successful version, to increase chance of getting successful  
    @SuppressForbidden(reason = "system out is ok for a command line tool")
 *     <li>A CAS can fail on its own write in at least two ways. In both cases, the write might have taken place even though we get a
        final int disruptTimeSeconds = scaledRandomIntBetween(1, 8);
            return lastFailed == that.lastFailed && safeVersion.equals(that.safeVersion);
        return input -> new FailureHistoryOutput();  
        }  
            out.writeLong(seqNo);
 * </ul>
        CyclicBarrier roundBarrier = new CyclicBarrier(threadCount + 1); // +1 for main thread.
    private static final class Version implements NamedWriteable, Comparable<Version> {
 *     <li>CAS writes with other exceptions might or might not have taken place. If they have taken place, then after invocation but not
            );
 * This test stress tests CAS updates using sequence number based versioning (ifPrimaryTerm/ifSeqNo).  
            }  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1 + randomInt(2))
        public Version get() {
            logger.debug("invocation partition ({}) event ({}) version ({})", id, eventId, version);
    // round.
    }  
            int rounds = randomIntBetween(2, 5);  
 *     <li>CAS writes resulting in a VersionConflictEngineException might or might not have taken place or may take place in the future
        }  
    // Wait up to 1 minute (+10s in thread to ensure it does not time out) for threads to complete previous round before initiating next
 * </ul>
        List<Partition> partitions = IntStream.range(0, numberOfKeys)
        }  
        logger.info("--> Starting {} threads", threadCount);
            }
            return Objects.hash(safeVersion, lastFailed);  
                        final int termChangePct = random.nextInt(100);
        public Version getVersion() {  
     * HistoryOutput contains the information from the output of calls.  
import java.util.function.Function;
        } catch (IOException e) {
        public boolean equals(Object o) {
    @SuppressForbidden(reason = "system err is ok for a command line tool")
            int termCompare = Long.compare(primaryTerm, other.primaryTerm);  
        }
        }  
        assertThat(spec.nextState(casFail(version2), version1, new IndexResponseHistoryOutput(version3)), equalTo(Optional.empty()));
        public void terminate() {
 *  
                            }  
                                new ParameterizedMessage("Received failure for request [{}], version [{}]", indexRequest, version),
        ensureGreen();  
import org.opensearch.ExceptionsHelper;
    }  
                final AtomicBoolean abort = new AtomicBoolean();  
        @Override  
    /**  
        return new LinearizabilityChecker.Event(
        }
        }
            stop = true;  
                new NamedWriteableRegistry.Entry(NamedWriteable.class, "fail", FailureHistoryOutput::new)
        }
        }
                        final int keyIndex = random.nextInt(partitions.size());
        private FailureHistoryOutput() {}
import org.opensearch.index.engine.VersionConflictEngineException;
                } catch (InterruptedException e) {
        private final int timeout;
        private final Version initialVersion;
                ServiceDisruptionScheme disruptionScheme = addRandomDisruptionScheme();
        }  
 *     write could be lost since it is not fully replicated. Details:  
            for (int i = 0; i < rounds; ++i) {
                    throw new AssertionError("Unexpected timeout in thread: " + Thread.currentThread(), e);  
                matcher.find();
 *     </ul>
import java.util.Arrays;
                // Bound the time how long the checker can run on such histories (Values empirically determined)
 * this file be licensed under the Apache-2.0 license or a
 */
            } catch (InterruptedException e) {
            )  
    /**
            output.writeInt(events.size());
import java.util.Random;
                            version = version.previousTerm();
 * under the License.  
 *         <li>A write is successfully stored on primary and one replica (r1). Replication to second replica fails, primary is demoted
 * <ul>
import org.opensearch.common.io.stream.BytesStreamOutput;
            List<LinearizabilityChecker.Event> events = history.copyEvents();  
        private Version outputVersion;
            if (version == null) return;
import static org.hamcrest.Matchers.greaterThan;  
        } finally {
/**
        @Override  
     * A non version conflict failure.  
import java.util.Base64;  
            this.primaryTerm = primaryTerm;  
        @Override
 * this work for additional information regarding copyright
            this.safeVersion = safeVersion;  
            } else {
    private static State casSuccess(Version version1) {
            if (o == null || getClass() != o.getClass()) return false;  
            return latestObservedVersion.get();
        }  
                        final int seqNoChangePct = random.nextInt(100);
        public String getWriteableName() {
            equalTo(Optional.of(casSuccess(version2)))  
 *     <li>For any other failure, we do not know if the write will succeed after the failure. However, we do know that if we
    }
            throw new RuntimeException(e);
            new CASSequentialSpec(initialVersion),
            return "Index{" + outputVersion + "}";
 * not use this file except in compliance with the License.
        assertAcked(  
            try {
 *         </li>
    private interface HistoryOutput extends NamedWriteable {
            threads.forEach(thread -> logger.info(thread.toString() + ":\n" + ExceptionsHelper.formatStackTrace(thread.getStackTrace())));
        }  
            }  
        boolean result = new LinearizabilityChecker().isLinearizable(  
                            // the operation wrt. linearizability.
 *     <li>A CAS failure throws a VersionConflictEngineException which does not directly contain the current seqno/primary-term to use for
                            if (version.compareTo(partition.latestSuccessfulVersion()) <= 0) {
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomInt(3))
                            assertThat(historyOutput.outputVersion, greaterThan(version));
        private final AtomicVersion latestObservedVersion;  
        public final long primaryTerm;
    }  
                            // todo: collect the failed responses and terminate when CAS with higher output version is successful, since
            super("CAS-Update-" + threadNum);
        public Version previousTerm() {
        Version version1 = new Version(randomIntBetween(1, 5), randomIntBetween(0, 100));  
public class ConcurrentSeqNoVersioningIT extends AbstractDisruptionTestCase {
                }  
        private final Version outputVersion;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 *     subsequently get back a CAS success with seqNo s, any previous failures with ifSeqNo &lt; s will not be able to succeed (but could
        @Override
            history.respond(eventId, output);
            this(parseException(exception.getMessage()));
        public Optional<Object> nextState(Object currentState, Object input, Object output) {
        // latest version that was observed, possibly dirty read of a write that does not survive
        }
        @Override
        List<CASUpdateThread> threads = IntStream.range(0, threadCount)
                // Large histories can be problematic and have the linearizability checker run OOM
        public int compareTo(Version other) {
import org.opensearch.test.OpenSearchIntegTestCase;  
        List<Version> versions = Arrays.asList(version1, version2, version3);
        versions.forEach(stateVersion -> versions.forEach(inputVersion -> {
                    // barrier  
                throw new RuntimeException("Unable to parse message: " + message, e);
        public Version nextSeqNo(int increment) {
                    roundBarrier.await(disruptTimeSeconds, TimeUnit.SECONDS);
        }
        output.writeEnum(event.type);
        private IndexResponseHistoryOutput(StreamInput input) throws IOException {
import org.opensearch.common.settings.Settings;
     */  
import java.util.List;
import java.util.function.Consumer;  
        }
            missingResponseGenerator()  
            return null;
        private CASSequentialSpec(Version initialVersion) {
import org.opensearch.cluster.metadata.IndexMetadata;
                            .setIfSeqNo(version.seqNo);
            output.close();
                    assert stop : "should only be interrupted when stopped";  
            this(new Version(input));
                    logger.error(
            return "version";
        private volatile boolean stop;
        public void writeTo(StreamOutput out) throws IOException {  
            for (LinearizabilityChecker.Event event : events) {
