            return "{" + "primaryTerm=" + primaryTerm + ", seqNo=" + seqNo + '}';
    }
        }
 *         <li>A write is successfully stored on primary and one replica (r1). Replication to second replica fails, primary is demoted
                writeEvent(event, output);
            return "Index{" + outputVersion + "}";
        Version(StreamInput input) throws IOException {
        private IndexResponseHistoryOutput(StreamInput input) throws IOException {
        assertThat(spec.initialState(), equalTo(casSuccess(version1)));
    }
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 *     version conflict response. Even though we might observe the write (by reading (not done in this test) or another CAS write), the
            for (LinearizabilityChecker.Event event : events) {
import java.util.concurrent.BrokenBarrierException;
        }
                            if (stop) {
        private final boolean lastFailed;
            return Long.compare(seqNo, other.seqNo);
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < size; ++i) {
                        }
        return new State(version1, false);
                            // operation will no longer be able to complete after the next successful write and we can therefore terminate
                    // a thread can go here either because it completed before disruption ended, timeout on main thread causes broken
                return new Version(Long.parseLong(matcher.group(2)), Long.parseLong(matcher.group(1)));
                            // if we supplied an input version <= latest successful version, we can safely assume that any failed
        if (randomBoolean()) futureVersion = futureVersion.nextTerm();
        @Override
                latestSuccessfulVersion.consume(output.getVersion());
            return "version";
        }
 *
    }
 * This test stress tests CAS updates using sequence number based versioning (ifPrimaryTerm/ifSeqNo).
        int size = input.readInt();
            try {
        Version version3 = futureVersion(version2);
        Version version2 = futureVersion(version1);
            return outputVersion;
 *     </li>
                            // we should be able to remove timeout or fail hard on timeouts
import java.util.Optional;
        }
            logger.info("--> terminating test");
        } catch (InterruptedException | BrokenBarrierException | TimeoutException e) {
        }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, minNumDataNodes = 4, maxNumDataNodes = 6)
        }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 *     provided the primaryTerm and seqNo still matches. The reason we cannot assume it will not take place after receiving the failure
        public int compareTo(Version other) {
            history,
        @Override
        partitions.forEach(Partition::assertLinearizable);
        @Override
        private volatile boolean stop;
        return futureVersion;
            equalTo(Optional.of(casSuccess(version2)))
     */
        );
                    return Optional.of(casSuccess(((IndexResponseHistoryOutput) output).getVersion()));
                            // linearizability checking.
 *     <li>A CAS can fail on its own write in at least two ways. In both cases, the write might have taken place even though we get a
     * HistoryOutput contains the information from the output of calls.
        }
            this.initialVersion = initialVersion;
 *     <li>For any other failure, we do not know if the write will succeed after the failure. However, we do know that if we
            out.writeLong(primaryTerm);
                String serializedHistory = base64Serialize(history);
                            // the operation wrt. linearizability.
            } catch (RuntimeException e) {
                // Large histories can be problematic and have the linearizability checker run OOM
                                new ParameterizedMessage("Received failure for request [{}], version [{}]", indexRequest, version),
        }
        })));
                            // this is the guarantee we offer.
                    int numberOfUpdates = randomIntBetween(3, 13) * partitions.size();
            this.interrupt();
    private static class FailureHistoryOutput implements HistoryOutput {
 * <ul>
        }
        }
            System.err.println("usage: <file> <primaryTerm> <seqNo>");
        }
                            .setIfPrimaryTerm(version.primaryTerm)
    }
        private final AtomicReference<Version> current;
        }
                Matcher matcher = EXTRACT_VERSION.matcher(message);
                "--> Linearizability checking history of size: {} for key: {} and initialVersion: {}: {}",
 *
    private static State casSuccess(Version version1) {
        public boolean equals(Object o) {
            return "index";
    // Test info: disrupt network for up to 8s in a number of rounds and check that we only get true positive CAS results when running
 *
            return null;
                history
                equalTo(Optional.of(casFail(stateVersion)))
 *     </li>
        }
        public final long primaryTerm;
    private interface HistoryOutput extends NamedWriteable {
                        final int keyIndex = random.nextInt(partitions.size());
        }
            input.readNamedWriteable(NamedWriteable.class),
        public void writeTo(StreamOutput out) throws IOException {
     * We treat CAS failures (version conflicts) identically to failures in linearizability checker, but keep this separate
    private class Partition {
    private static final Pattern EXTRACT_VERSION = Pattern.compile("current document has seqNo \\[(\\d+)\\] and primary term \\[(\\d+)\\]");
        logger.info("--> Starting {} threads", threadCount);
            List<LinearizabilityChecker.Event> events = history.copyEvents();
        private CASFailureHistoryOutput(StreamInput input) throws IOException {
                            );
            this(new Version(response.getPrimaryTerm(), response.getSeqNo()));
 *     </li>
        boolean result = new LinearizabilityChecker().isLinearizable(
            if (o == null || getClass() != o.getClass()) return false;
    }
            }
            history.respond(eventId, output);
            this(new Version(input));
 *     see above.</li>
            try {
        }
        }
    private static State casFail(Version stateVersion) {
            new CASSequentialSpec(initialVersion),
            if (output instanceof IndexResponseHistoryOutput) {
        public Version getVersion() {
    }
    /**
 *     <li>acknowledged CAS writes are guaranteed to have taken place between invocation and response and cannot be lost. It is
    }
            }
import org.opensearch.action.index.IndexRequest;
                return Optional.of(state.failed());
        }
    public void testSequentialSpec() {
 *         and r1 is promoted to primary. The request is repeated on r1, but this time the request fails due to its own write.</li>
        private final Version outputVersion;
            }
                new NamedWriteableRegistry.Entry(NamedWriteable.class, "version", Version::new),
            threads.forEach(CASUpdateThread::terminate);
import java.util.stream.Collectors;
        public Version getVersion() {
            assertThat(
        }
            return new Version(primaryTerm - 1, seqNo);
     * Our version, which is primaryTerm,seqNo.
            return current.get();
 * KIND, either express or implied.  See the License for the
import org.opensearch.discovery.AbstractDisruptionTestCase;
        @Override
 * </ul>
            return outputVersion;
        public Version latestObservedVersion() {
        public void writeTo(StreamOutput out) throws IOException {
                                // interrupt often comes as a RuntimeException so check to stop here too.
import org.opensearch.core.common.io.stream.NamedWriteable;
 * <ul>
        }
            logger.info(
                    roundBarrier.await(70, TimeUnit.SECONDS);
        @Override
        }
import java.util.regex.Matcher;
            Version version = (Version) o;
        @Override
        private final AtomicVersion latestObservedVersion;
            )
        public void assertLinearizable() {
        private final CyclicBarrier roundBarrier;
        public Version nextSeqNo(int increment) {
            stop = true;
                    }
import org.opensearch.ExceptionsHelper;
            equalTo(Optional.of(casSuccess(version3)))
        threads.forEach(Thread::start);
        } catch (IOException e) {
            return lastFailed ? this : casFail(safeVersion);
        public State failed() {
 *
            return new Version(primaryTerm, Math.max(seqNo - decrement, 0));
        }
    private static final class Version implements NamedWriteable, Comparable<Version> {
            outputVersion.writeTo(out);
                if (input.equals(state.safeVersion) || (state.lastFailed && ((Version) input).compareTo(state.safeVersion) > 0)) {
 * <p>The following is a summary of the expected CAS write behaviour of the system:</p>
    private static LinearizabilityChecker.Event readEvent(StreamInput input) throws IOException {
                equalTo(Optional.of(casFail(stateVersion)))
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        // CAS'es and races. If we were to use only the latest successful version, any CAS fail on own write would mean that
        public Version previousTerm() {
 * not use this file except in compliance with the License.
import java.util.concurrent.TimeoutException;
import java.util.List;
            Arrays.asList(
    private static class IndexResponseHistoryOutput implements HistoryOutput {
            this.primaryTerm = input.readLong();
            output.writeInt(events.size());
                            // todo: collect the failed responses and terminate when CAS with higher output version is successful, since
 *     guaranteed that the previous value had the specified primaryTerm and seqNo</li>
            return new Version(primaryTerm, seqNo + increment);
 * ownership. Elasticsearch licenses this file to you under
            logger.debug("response partition ({}) event ({}) output ({})", id, eventId, output);
                        IndexRequest indexRequest = new IndexRequest("test").id(partition.id)
        }
        public String toString() {
    private static Function<Object, Object> missingResponseGenerator() {
            logger.error("Timed out, dumping stack traces of all threads:");
        // latest version that was observed, possibly dirty read of a write that does not survive
            assertTrue("Must be linearizable", linearizable);
            missingResponseGenerator()
            this.latestSuccessfulVersion = new AtomicVersion(initialVersion);
        Version initialVersion = new Version(primaryTerm, seqNo);
            boolean linearizable = false;
                }
        }
        private FailureHistoryOutput() {}
            );
                final AtomicBoolean abort = new AtomicBoolean();
        private IndexResponseHistoryOutput(Version outputVersion) {
        Version version1 = new Version(randomIntBetween(1, 5), randomIntBetween(0, 100));
                                historyResponse.accept(new FailureHistoryOutput());
        );
        private CASSequentialSpec(Version initialVersion) {
        versions.forEach(stateVersion -> versions.forEach(inputVersion -> {
            input.readInt()
        public Version nextTerm() {
                if (abort.get() && linearizable == false) {
                        final int termChangePct = random.nextInt(100);
    public static void main(String[] args) throws Exception {
        return new State(stateVersion, true);
        }
                        // variance to seqno/term should ensure we progress fine in most runs.
 */
import org.opensearch.common.io.stream.BytesStreamOutput;
        List<Partition> partitions = IntStream.range(0, numberOfKeys)
            return latestSuccessfulVersion.get();
        @Override
            this.lastFailed = lastFailed;
        List<LinearizabilityChecker.Event> events = new ArrayList<>(size);
            }
 */
            return Objects.hash(primaryTerm, seqNo);
    }
                }
                            // validate version and seqNo strictly increasing for successful CAS to avoid that overhead during
                runLinearizabilityChecker(fis, Long.parseLong(args[1]), Long.parseLong(args[2]));
        private final LinearizabilityChecker.History history = new LinearizabilityChecker.History();
            .mapToObj(i -> client().prepareIndex("test").setId("ID:" + i).setSource("value", -1).get())
import java.util.concurrent.atomic.AtomicBoolean;
import org.opensearch.threadpool.Scheduler;
        private static Version parseException(String message) {
            // writes would succeed after a fail on own write failure (unless we were lucky enough to guess the seqNo/primaryTerm using the
        }
                try {
                            .source("value", random.nextInt())
                initialVersion,
        }
            outputVersion.writeTo(out);
import org.opensearch.common.SuppressForbidden;
                        } else if (termChangePct < 10) {
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1 + randomInt(2))
                        } catch (RuntimeException e) {
import org.opensearch.core.common.io.stream.StreamOutput;
        }
        return new NamedWriteableRegistry(
    private static class AtomicVersion {
        }
                matcher.find();
                                e
                // Bound the time how long the checker can run on such histories (Values empirically determined)
 *     produce dirty writes on a stale primary).
}
            throw new RuntimeException(e);
        try {
import org.opensearch.test.disruption.ServiceDisruptionScheme;
    }
            this(new Version(input));
        Version futureVersion = version.nextSeqNo(randomIntBetween(1, 10));
        private final String id;
    }
            this.initialVersion = initialVersion;
                        serializedHistory
        if (args.length < 3) {
    private class CASUpdateThread extends Thread {
                            }
                spec.nextState(casSuccess(stateVersion), inputVersion, new FailureHistoryOutput()),
        public Object initialState() {
                        } else if (seqNoChangePct < 15) {
        final int disruptTimeSeconds = scaledRandomIntBetween(1, 8);
                if (history.size() > 300) {
            this.partitions = partitions;
            // nothing to write.
        @Override
            this.current = new AtomicReference<>(initialVersion);
        @Override
        }
        private final AtomicVersion latestSuccessfulVersion;
import org.opensearch.core.common.bytes.BytesReference;
 *     </ul>
        @Override
import java.util.Base64;
            latestObservedVersion.consume(output.getVersion());
        );
package org.opensearch.versioning;
                ensureFullyConnectedCluster();
        }
                }
            try {
            )
 *
 * GitHub history for details.
            assertThat(
        @Override
    public void testSeqNoCASLinearizability() {
import java.util.stream.IntStream;
        public String toString() {
            if (output instanceof IndexResponseHistoryOutput) {
                // heal cluster faster to reduce test time.
        public Version getVersion() {
import org.opensearch.cluster.coordination.LinearizabilityChecker;
            );
            return output -> consumeOutput(output, eventId);
        }
                            }
        @Override
        }
        // Generate 3 increasing versions
        public String getWriteableName() {
                        // all future CAS'es would fail unless we guess the seqno/term below. On the other hand, using latest observed
                join(60000);
/*
                } catch (BrokenBarrierException e) {
                // implicitly test that we can serialize all histories.
        @Override
                            if (version.compareTo(partition.latestSuccessfulVersion()) <= 0) {
            .mapToObj(i -> new CASUpdateThread(i, roundBarrier, partitions, disruptTimeSeconds + 1))
 *     Such writes are not necessarily fully replicated and can be lost. There is no
    private static void writeEvent(LinearizabilityChecker.Event event, BytesStreamOutput output) throws IOException {
            super("CAS-Update-" + threadNum);
        private final int timeout;
            spec.nextState(casFail(version1), version2, new IndexResponseHistoryOutput(version3)),
        private final Random random = new Random(randomLong());
        }
    }
    private static final class State {
        }
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
import java.util.regex.Pattern;
        assertThat(spec.nextState(casFail(version2), version1, new IndexResponseHistoryOutput(version3)), equalTo(Optional.empty()));
        }
 *     the newest primary (could be isolated or just not have been told yet). So a CAS check is suspect to stale reads (like any
        }
                        try {
import org.apache.logging.log4j.message.ParameterizedMessage;
 *     suffer from stale (or dirty) reads.
                            .setIfSeqNo(version.seqNo);
                disruptionScheme.startDisrupting();
    private Version futureVersion(Version version) {
                        final Partition partition = partitions.get(keyIndex);
                    // we dump base64 encoded data, since the nature of this test is that it does not reproduce even with same seed.
        }
    // round.
 * Modifications Copyright OpenSearch Contributors. See
        ensureGreen();
import org.opensearch.action.index.IndexResponse;
            .collect(Collectors.toList());
                if (linearizable == false) {
                final ScheduledThreadPoolExecutor scheduler = Scheduler.initScheduler(Settings.EMPTY);
        }
     * A non version conflict failure.
 *     </li>
        public void run() {
 *     <li>CAS writes with other exceptions might or might not have taken place. If they have taken place, then after invocation but not
        return new LinearizabilityChecker.History(events);
import static org.hamcrest.Matchers.equalTo;
            this(parseException(exception.getMessage()));
                try {
        Version(long primaryTerm, long seqNo) {
        private State(Version safeVersion, boolean lastFailed) {
        private FailureHistoryOutput(@SuppressWarnings("unused") StreamInput streamInput) {}
                        Version version = random.nextBoolean() ? partition.latestObservedVersion() : partition.latestSuccessfulVersion();
                            assertThat(historyOutput.outputVersion.seqNo, greaterThan(version.seqNo));
        } finally {
/*
import java.io.FileInputStream;
        public void await() {
        try {
                } catch (TimeoutException e) {
        }
        BytesStreamOutput output = new BytesStreamOutput();
 *         response is sent back. Once connection is back, coordinator will retry against either same or new primary, but this time the
import org.opensearch.index.engine.VersionConflictEngineException;
        public void consume(Version version) {
                                return;
        public String toString() {
                            version = version.nextTerm();
    private String base64Serialize(LinearizabilityChecker.History history) {
        }
                    );
import java.util.concurrent.TimeUnit;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                        Consumer<HistoryOutput> historyResponse = partition.invoke(version);
                            version = version.previousTerm();
            this.roundBarrier = roundBarrier;
                    logger.error(
            return "CASFail{" + outputVersion + "}";
            events.add(readEvent(input));
                        if (seqNoChangePct < 10) {
            if (o == null || getClass() != o.getClass()) return false;
            );
        // latest version for which we got a successful response on a write.
                            IndexResponse indexResponse = client().index(indexRequest).actionGet(timeout, TimeUnit.SECONDS);
        }
            State state = (State) currentState;
import org.opensearch.threadpool.ThreadPool;
            } finally {
public class ConcurrentSeqNoVersioningIT extends AbstractDisruptionTestCase {
                } catch (TimeoutException e) {
import java.util.function.Function;
        public String getWriteableName() {
        public void terminate() {
import java.util.Objects;
        public String getWriteableName() {
                    assert stop : "should only be interrupted when stopped";
        public int hashCode() {
                        } catch (VersionConflictEngineException e) {
        assertThat(spec.nextState(casSuccess(version1), version2, new IndexResponseHistoryOutput(version3)), equalTo(Optional.empty()));
                    roundBarrier.reset();
 */
 *     <li>A CAS failure throws a VersionConflictEngineException which does not directly contain the current seqno/primary-term to use for
        private IndexResponseHistoryOutput(IndexResponse response) {
                            // if we supplied an input version <= to latest successful version, we can safely assume that any failed
            logger.info("--> Running {} rounds", rounds);
        @Override
        CyclicBarrier roundBarrier = new CyclicBarrier(threadCount + 1); // +1 for main thread.
    }
        Version getVersion();
                        }
        private final List<Partition> partitions;
            prepareCreate("test").setSettings(
                        final int seqNoChangePct = random.nextInt(100);
        output.writeInt(event.id);
        public String toString() {
                ServiceDisruptionScheme disruptionScheme = addRandomDisruptionScheme();
            this.id = id;
            throw new RuntimeException(e);
        private Version outputVersion;
        private CASFailureHistoryOutput(VersionConflictEngineException exception) {
            out.writeLong(seqNo);
 * the Apache License, Version 2.0 (the "License"); you may
                Settings.builder()
        @Override
        private CASFailureHistoryOutput(Version outputVersion) {
 *         request will fail due to its own write.
        assertThat(spec.nextState(casSuccess(version2), version1, new IndexResponseHistoryOutput(version3)), equalTo(Optional.empty()));
                    roundBarrier.await(disruptTimeSeconds, TimeUnit.SECONDS);
            return lastFailed == that.lastFailed && safeVersion.equals(that.safeVersion);
                ThreadPool.terminate(scheduler, 1, TimeUnit.SECONDS);
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomInt(3))
        );
                }
        return new LinearizabilityChecker.Event(
        public Version latestSuccessfulVersion() {
    }
     */
                equalTo(Optional.of(casFail(stateVersion)))
            int eventId = history.invoke(version);
        List<CASUpdateThread> threads = IntStream.range(0, threadCount)
        versions.forEach(stateVersion -> versions.forEach(inputVersion -> versions.forEach(outputVersion -> {
            return primaryTerm == version.primaryTerm && seqNo == version.seqNo;
     */
 */
 * You may obtain a copy of the License at
 *
                    scheduler.schedule(() -> abort.set(true), 10, TimeUnit.SECONDS);
        @Override
    private static class CASSequentialSpec implements LinearizabilityChecker.SequentialSpec {
            while (stop == false) {
        output.writeEnum(event.type);
                history.size(),
        }));
                    linearizable = true; // let the test pass
        System.out.println(LinearizabilityChecker.visualize(new CASSequentialSpec(initialVersion), history, missingResponseGenerator()));
/*
        @Override
                new NamedWriteableRegistry.Entry(NamedWriteable.class, "fail", FailureHistoryOutput::new)
 *     <li>A CAS can fail on a dirty read, i.e., a non-replicated write that ends up being discarded.</li>
    }
        public void writeTo(StreamOutput out) throws IOException {
        public Version previousSeqNo(int decrement) {
                internalCluster().clearDisruptionScheme(false);
            int termCompare = Long.compare(primaryTerm, other.primaryTerm);
        System.out.println("Linearizable?: " + result);
            } else {
        }
        }
            State that = (State) o;
                            if (version.compareTo(partition.latestSuccessfulVersion()) <= 0) {
                            version = version.nextSeqNo(random.nextInt(4) + 1);
import java.util.concurrent.CyclicBarrier;
        private void consumeOutput(HistoryOutput output, int eventId) {
                        "Linearizability check failed. Spec: {}, initial version: {}, serialized history: {}",
                    // this is timeout on the barrier, unexpected.
        }
                        spec,
                                historyResponse.accept(new CASFailureHistoryOutput(e));
            assertThat(
 *     read) and can thus fail due to reading stale data. Notice that a CAS success is fully replicated and thus guaranteed to not
        public Optional<Object> nextState(Object currentState, Object input, Object output) {
        is = new NamedWriteableAwareStreamInput(is, createNamedWriteableRegistry());
 *     the next request. It is contained in the message (and we parse it out in the test), but notice that the numbers given here could be
import java.util.Random;
            );
                        }
                            IndexResponseHistoryOutput historyOutput = new IndexResponseHistoryOutput(indexResponse);
                    return Optional.empty();
        output.writeNamedWriteable((NamedWriteable) event.value);
        private final Version initialVersion;
        // for version conflicts, we keep state version with lastFailed set, regardless of input/output version.
 *     is that a request can fork into two because of retries on disconnect, and now race against itself. The retry might complete (and do a
        return input -> new FailureHistoryOutput();
 *     stale or dirty, i.e., come from a stale primary or belong to a write that ends up being discarded.</li>
        @Override
            return latestObservedVersion.get();
    }
            this.outputVersion = outputVersion;
                    for (int i = 0; i < numberOfUpdates; ++i) {
                        if (termChangePct < 5) {
        @Override
                            // this is the guarantee we offer.
                id,
            this.current.updateAndGet(current -> version.compareTo(current) <= 0 ? current : version);
        public String getWriteableName() {
        }
        }
            threads.forEach(thread -> logger.info(thread.toString() + ":\n" + ExceptionsHelper.formatStackTrace(thread.getStackTrace())));
    // multiple threads doing CAS updates.
import java.util.concurrent.atomic.AtomicReference;
 * </ul>
            input.readEnum(LinearizabilityChecker.EventType.class),
            // random futureTerm/futureSeqNo handling in CASUpdateThread).
 * compatible open source license.
import org.opensearch.core.common.io.stream.InputStreamStreamInput;
 *     <li>A CAS can fail on stale reads. A CAS failure is only checked on the supposedly primary node. However, the primary might not be
            for (int i = 0; i < rounds; ++i) {
                            historyResponse.accept(historyOutput);
        );
        @Override
                spec.nextState(casSuccess(stateVersion), inputVersion, new CASFailureHistoryOutput(outputVersion)),
                    // barrier
    // Wait up to 1 minute (+10s in thread to ensure it does not time out) for threads to complete previous round before initiating next
            return "State{" + "safeVersion=" + safeVersion + ", lastFailed=" + lastFailed + '}';
            threads.forEach(CASUpdateThread::await);
        List<Version> versions = Arrays.asList(version1, version2, version3);
            this.seqNo = seqNo;
        int threadCount = randomIntBetween(3, 20);
        private AtomicVersion(Version initialVersion) {
            }
 * <p>
        logger.info("--> Indexing initial doc for {} keys", numberOfKeys);
        }
        }
                    .put(indexSettings())
            return "Fail";
            return Base64.getEncoder().encodeToString(BytesReference.toBytes(output.bytes()));
                        initialVersion,
            setDaemon(true);
        public final long seqNo;
                throw new RuntimeException("Unable to parse message: " + message, e);
            return "casfail";
        public int hashCode() {
            .map(response -> new Partition(response.getId(), new Version(response.getPrimaryTerm(), response.getSeqNo())))
                        // we use either the latest observed or the latest successful version, to increase chance of getting successful
                            assertThat(historyOutput.outputVersion, greaterThan(version));
 * specific language governing permissions and limitations
    }
        @Override
                }
import org.opensearch.test.OpenSearchIntegTestCase;
    @SuppressForbidden(reason = "system out is ok for a command line tool")
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
                spec.nextState(casFail(stateVersion), inputVersion, new CASFailureHistoryOutput(outputVersion)),
            if (version == null) return;
            // parsing out the version increases chance of hitting races against CAS successes, since if we did not parse this out, no
 *     necessarily before response. Such writes are not necessarily fully replicated and can be lost.
     */
            if (this == o) return true;
                        // version exclusively we risk a single CAS fail on a dirty read to cause the same. Doing both randomly and adding
    }
            this.primaryTerm = primaryTerm;
 *     <li>A CAS failure or any other failure can eventually succeed after receiving the failure response due to reroute and retries,
 *     subsequently get back a CAS success with seqNo s, any previous failures with ifSeqNo &lt; s will not be able to succeed (but could
                roundBarrier.await(1, TimeUnit.MINUTES);
import java.util.function.Consumer;
    }
            LinearizabilityChecker.SequentialSpec spec = new CASSequentialSpec(initialVersion);
            this.outputVersion = outputVersion;
import static org.hamcrest.Matchers.greaterThan;
                linearizable = new LinearizabilityChecker().isLinearizable(spec, history, missingResponseGenerator(), abort::get);
            if (termCompare != 0) return termCompare;
 * The OpenSearch Contributors require contributions made to
            this.seqNo = input.readLong();
    }
            int rounds = randomIntBetween(2, 5);
            return Objects.hash(safeVersion, lastFailed);
    }
 *         <li>A coordinator sends write to primary, which stores write successfully (and replicates it). Connection is lost before
 * this file be licensed under the Apache-2.0 license or a
        }
        }
        private final Version safeVersion;
        LinearizabilityChecker.History history = readHistory(is);
            if (this == o) return true;
import org.opensearch.core.common.io.stream.StreamInput;
 *
    private static class CASFailureHistoryOutput implements HistoryOutput {
        assertAcked(
            }
            }
    }
            this.timeout = timeout;
            threads.stream().filter(Thread::isAlive).forEach(t -> fail("Thread still alive: " + t));
            assertThat(
 * Unless required by applicable law or agreed to in writing,
                spec.nextState(casFail(stateVersion), inputVersion, new FailureHistoryOutput()),
/**
        assertThat(
                    throw new AssertionError("Unexpected timeout in thread: " + Thread.currentThread(), e);
            return "fail";
            );
            }
            try (FileInputStream fis = new FileInputStream(args[0])) {
import java.util.concurrent.ScheduledThreadPoolExecutor;
                } catch (InterruptedException e) {
    @SuppressForbidden(reason = "system err is ok for a command line tool")
            this.safeVersion = safeVersion;
                            }
 *     write could be lost since it is not fully replicated. Details:
            return casSuccess(initialVersion);
    /**
        public boolean equals(Object o) {
import java.util.Arrays;
    private static LinearizabilityChecker.History readHistory(StreamInput input) throws IOException {
                } else {
import org.opensearch.cluster.metadata.IndexMetadata;
        }
            .collect(Collectors.toList());
        private final Version initialVersion;
    }
            logger.debug("invocation partition ({}) event ({}) version ({})", id, eventId, version);
    private static void runLinearizabilityChecker(FileInputStream fileInputStream, long primaryTerm, long seqNo) throws IOException {
 *     <li>CAS writes resulting in a VersionConflictEngineException might or might not have taken place or may take place in the future
                equalTo(Optional.of(casFail(stateVersion)))
                            // todo: collect the failed responses and terminate when CAS with higher output version is successful, since
 *     dirty or stale read) before the forked off request gets to execute, and that one might still subsequently succeed.
        }
    }
        );
            return new Version(primaryTerm + 1, seqNo);
                new NamedWriteableRegistry.Entry(NamedWriteable.class, "casfail", CASFailureHistoryOutput::new),
        StreamInput is = new InputStreamStreamInput(Base64.getDecoder().wrap(fileInputStream));
 * under the License.
    /**
            output.close();
        int numberOfKeys = randomIntBetween(1, 10);
        assertThat(
                            // operation will no longer be able to complete after the next successful write and we can therefore terminate
 * license agreements. See the NOTICE file distributed with
                            version = version.previousSeqNo(random.nextInt(4) + 1);
            }
                Thread.currentThread().interrupt();
            } catch (InterruptedException e) {
import org.opensearch.common.settings.Settings;
            this.latestObservedVersion = new AtomicVersion(initialVersion);
                }
        private CASUpdateThread(int threadNum, CyclicBarrier roundBarrier, List<Partition> partitions, int timeout) {
     * to parse out the latest observed version and to ease debugging.
        // for non version conflict failures, we keep state version with lastFailed set, regardless of input version.
                logger.info("--> round {}", i);
        LinearizabilityChecker.SequentialSpec spec = new CASSequentialSpec(version1);
        @Override
    private static NamedWriteableRegistry createNamedWriteableRegistry() {
                            logger.info(
        }
        public Version get() {
        public Consumer<HistoryOutput> invoke(Version version) {
 *     <ul>
        public void writeTo(StreamOutput out) throws IOException {
            spec.nextState(casSuccess(version1), version1, new IndexResponseHistoryOutput(version2)),
        private Partition(String id, Version initialVersion) {
 * A deeper technical explanation of the behaviour is given here:
 *     guarantee that the previous value did not have the specified primaryTerm and seqNo</li>
import java.util.ArrayList;
        } else {
 *         </li>
        }
        public String toString() {
    /**
                            // the operation wrt. linearizability.
        }
import java.io.IOException;
                new NamedWriteableRegistry.Entry(NamedWriteable.class, "index", IndexResponseHistoryOutput::new),
