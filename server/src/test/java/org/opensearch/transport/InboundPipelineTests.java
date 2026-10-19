        }
        private final String actionName;
                && Objects.equals(version, that.version)
            }
        public int hashCode() {
import java.util.concurrent.atomic.AtomicBoolean;
            final String value = randomAlphaOfLength(1000);
                        messageData = new MessageData(version, requestId, false, isCompressed, null, value);
        BiConsumer<TcpChannel, InboundMessage> messageHandler = (c, m) -> {};
            toRelease.clear();
                try (ReleasableBytesReference slice = ReleasableBytesReference.wrap(reference.slice(i, 1))) {
            return Objects.hash(version, requestId, isRequest, isCompressed, value, actionName);
        }
                final Header header = message.getHeader();
            }
 */
                    if (expectedTuple.v2() != null) {
            this.isCompressed = isCompressed;
                        pipeline.handleBytes(channel, reference);
        String value
                    final BytesReference slice = networkBytes.slice(currentOffset, bytesToRead);
            }
                    if (isRequest) {
import org.opensearch.core.common.breaker.CircuitBreakingException;
                }
        private final String value;
                            messageData = new MessageData(version, requestId, true, isCompressed, breakThisAction, null);
                    }
 * Modifications Copyright OpenSearch Contributors. See
import java.util.ArrayList;
            final IllegalStateException ise = expectThrows(
import java.util.Objects;
        long bytesReceived = 0;
        final String breakThisAction = "break_this_action";
package org.opensearch.transport;
            for (int i = 0; i < totalHeaderSize - 1; ++i) {
                }
import org.opensearch.common.bytes.ReleasableBytesReference;
        final int iterations = randomIntBetween(5, 10);
                && isCompressed == that.isCompressed
import org.opensearch.core.common.bytes.BytesReference;
            try (ReleasableBytesReference slice = new ReleasableBytesReference(reference.slice(reference.length() - 1, 1), releasable)) {
                        bytesReceived += reference.length();
                    final boolean isCompressed = randomBoolean();
        final StatsTracker statsTracker = new StatsTracker();
            MessageData that = (MessageData) o;
import org.opensearch.common.lease.Releasable;
                            expectedExceptionClass = new CircuitBreakingException("", CircuitBreaker.Durability.PERMANENT);
import java.io.IOException;
                final long requestId = header.getRequestId();
        String action,
                expectThrows(IllegalStateException.class, () -> pipeline.handleBytes(new FakeTcpChannel(), releasable));
    }
    private static final int BYTE_THRESHOLD = 128 * 1024;
            final BytesReference partHeaderPartBody = reference.slice(from, reference.length() - from - 1);
                    final int remainingBytes = networkBytes.length() - currentOffset;
                    final Version version = randomFrom(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion());
                throw new AssertionError(e);
                            reference = serialize(true, version, false, isCompressed, actionName, requestId, value);
        final LongSupplier millisSupplier = () -> TimeValue.nsecToMSec(System.nanoTime());
            String actionName = "actionName";
        try (BytesStreamOutput streamOutput = new BytesStreamOutput()) {
import org.opensearch.common.unit.TimeValue;
                && Objects.equals(actionName, that.actionName);
        final StatsTracker statsTracker = new StatsTracker();
                    actualData = new MessageData(version, requestId, isRequest, isCompressed, header.getActionName(), null);
 * The OpenSearch Contributors require contributions made to
    public final ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
 * specific language governing permissions and limitations
            actual.clear();
                }
            );
                    final TestResponse response = new TestResponse(message.openOrGetStreamInput());
                    }
                    assertEquals(expectedMessageData.isCompressed, actualMessageData.isCompressed);
            final int fixedHeaderSize = TcpHeader.headerSize(Version.CURRENT);
        @Override
                while (currentOffset != networkBytes.length()) {
                    assertEquals(expectedMessageData.requestId, actualMessageData.requestId);
    private static class MessageData {
                    final MessageData actualMessageData = actualTuple.v1();
            assertEquals(totalMessages, statsTracker.getMessagesReceived());
        final LongSupplier millisSupplier = () -> TimeValue.nsecToMSec(System.nanoTime());
import org.opensearch.common.util.io.Streams;
public abstract class InboundPipelineTests extends OpenSearchTestCase {
            try (ReleasableBytesReference releasable = ReleasableBytesReference.wrap(reference)) {
                } else if (isRequest) {
                    final int bytesToRead = Math.min(randomIntBetween(1, 32 * 1024), remainingBytes);
                        }
                if (message.isShortCircuit()) {
                    expected.add(new Tuple<>(messageData, expectedExceptionClass));
        final InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);
import static org.hamcrest.Matchers.instanceOf;
 * ownership. Elasticsearch licenses this file to you under
                final int messages = expected.size();
                    final long requestId = totalMessages++;
                    final Tuple<MessageData, Exception> actualTuple = actual.get(j);
 * Licensed to Elasticsearch under one or more contributor
import java.util.function.BiConsumer;
        }
        final InboundAggregator aggregator = new InboundAggregator(breaker, (Predicate<String>) action -> true);
        final InboundPipeline pipeline = new InboundPipeline(statsTracker, millisSupplier, decoder, aggregator, messageHandler);
        final InboundAggregator aggregator = new InboundAggregator(breaker, (Predicate<String>) action -> true);
            try (BytesStreamOutput streamOutput = new BytesStreamOutput()) {
import org.opensearch.common.settings.Settings;
            final String value = randomAlphaOfLength(1000);
                    final TestRequest request = new TestRequest(message.openOrGetStreamInput());
 * this work for additional information regarding copyright
 * compatible open source license.
        final Predicate<String> canTripBreaker = breakThisAction::equals;
/*
                            reference = serialize(true, version, false, isCompressed, breakThisAction, requestId, value);
        final InboundPipeline pipeline = new InboundPipeline(statsTracker, millisSupplier, decoder, aggregator, messageHandler);
        final List<Tuple<MessageData, Exception>> actual = new ArrayList<>();
        private final boolean isCompressed;
    }
        final StatsTracker statsTracker = new StatsTracker();
        public boolean equals(Object o) {
 *
                    Streams.copy(reference.streamInput(), streamOutput);
    }
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
                final Version version = header.getVersion();
        long totalMessages = 0;
            final Version version = Version.CURRENT;
                final BytesReference networkBytes = streamOutput.bytes();
                    final String value = randomAlphaOfLength(randomIntBetween(10, 200));
            }
            } catch (IOException e) {
import org.opensearch.common.breaker.TestCircuitBreaker;
        final Supplier<CircuitBreaker> breaker = () -> new NoopCircuitBreaker("test");
/*
                    assertEquals(0, released.refCount());
                actual.add(new Tuple<>(actualData, message.getException()));
                    }
        final InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);
        };
            if (o == null || getClass() != o.getClass()) return false;
                () -> pipeline.handleBytes(new FakeTcpChannel(), ReleasableBytesReference.wrap(BytesArray.EMPTY))
                }
            final long requestId = randomNonNegativeLong();
        circuitBreaker.startBreaking();
        final InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);
        final List<Tuple<MessageData, Exception>> expected = new ArrayList<>();
            final int totalHeaderSize = fixedHeaderSize + variableHeaderSize;
            return requestId == that.requestId
            final boolean isRequest = randomBoolean();
                    Exception expectedExceptionClass = null;
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
import org.opensearch.common.util.PageCacheRecycler;
        final FakeTcpChannel channel = new FakeTcpChannel();
            assertEquals(bytesReceived, statsTracker.getBytesRead());
                && Objects.equals(value, that.value)
                for (int j = 0; j < messages; ++j) {
import org.opensearch.Version;
                        currentOffset += bytesToRead;
            }
                    assertEquals(expectedMessageData.isRequest, actualMessageData.isRequest);
        }
        private final long requestId;
    protected abstract BytesReference serialize(
                }
            assertEquals("Pipeline state corrupted by uncaught exception", ise.getMessage());
 *
            // Pipeline cannot be reused after uncaught exception
            assertTrue(bodyReleased.get());
            try {
        }
            final AtomicBoolean bodyReleased = new AtomicBoolean(false);
                    try (ReleasableBytesReference reference = new ReleasableBytesReference(slice, () -> {})) {
                } else {
                    actualData = new MessageData(version, requestId, isRequest, isCompressed, null, response.getValue());
 */
                    final BytesReference reference;
                    } else {
        try (BytesStreamOutput streamOutput = new BytesStreamOutput()) {
 * Unless required by applicable law or agreed to in writing,
                    final MessageData messageData;
import org.opensearch.core.common.breaker.CircuitBreaker;
            this.value = value;
        private MessageData(Version version, long requestId, boolean isRequest, boolean isCompressed, String actionName, String value) {
 */
 * under the License.
                        } else {
                pipeline.handleBytes(new FakeTcpChannel(), slice);
        final String actionName = "actionName";
                pipeline.handleBytes(new FakeTcpChannel(), slice);
        final InboundAggregator aggregator = new InboundAggregator(() -> circuitBreaker, canTripBreaker);
    public void testDecodeExceptionIsPropagated() throws IOException {
                    final Tuple<MessageData, Exception> expectedTuple = expected.get(j);
        }
                        assertThat(actualTuple.v2(), instanceOf(expectedTuple.v2().getClass()));
        final InboundPipeline pipeline = new InboundPipeline(statsTracker, millisSupplier, decoder, aggregator, messageHandler);
            assertFalse(bodyReleased.get());
        boolean isRequest,
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
            }
                        assertNotNull(actualTuple.v2());
import org.opensearch.common.collect.Tuple;
                final boolean isCompressed = header.isCompressed();
import org.opensearch.common.util.concurrent.ThreadContext;
                final MessageData actualData;
                final boolean isRequest = header.isRequest();
        long requestId,
                while (streamOutput.size() < BYTE_THRESHOLD) {
                        reference = serialize(false, version, false, isCompressed, actionName, requestId, value);
        Version version,
            expected.clear();
        BiConsumer<TcpChannel, InboundMessage> messageHandler = (c, m) -> {};
        final Supplier<CircuitBreaker> breaker = () -> new NoopCircuitBreaker("test");
            final BytesReference reference = serialize(isRequest, version, false, false, actionName, requestId, value);
import java.util.List;
        boolean compress,
                for (ReleasableBytesReference released : toRelease) {
        for (int i = 0; i < iterations; ++i) {
                        if (rarely()) {
            if (this == o) return true;
    ) throws IOException;
 * SPDX-License-Identifier: Apache-2.0
            this.isRequest = isRequest;
                    // NativeOutboundMessage message;
            final int variableHeaderSize = reference.getInt(fixedHeaderSize - 4);
 * GitHub history for details.
            final Releasable releasable = () -> bodyReleased.set(true);
                        toRelease.add(reference);
                    final MessageData expectedMessageData = expectedTuple.v1();
            final Version invalidVersion = Version.CURRENT.minimumCompatibilityVersion().minimumCompatibilityVersion();
    public void testEnsureBodyIsNotPrematurelyReleased() throws IOException {
        final BiConsumer<TcpChannel, InboundMessage> messageHandler = (c, message) -> {
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.core.common.bytes.BytesArray;
        final List<ReleasableBytesReference> toRelease = new ArrayList<>();
            this.actionName = actionName;
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
import org.opensearch.test.OpenSearchTestCase;
                }
                int currentOffset = 0;
                IllegalStateException.class,
    public void testPipelineHandlingForNativeProtocol() throws IOException {
import java.util.function.LongSupplier;
            this.requestId = requestId;
        private final Version version;
                    assertEquals(expectedMessageData.actionName, actualMessageData.actionName);
import java.util.function.Supplier;
            try (ReleasableBytesReference slice = new ReleasableBytesReference(partHeaderPartBody, releasable)) {
}
        private final boolean isRequest;
        boolean handshake,
import java.util.function.Predicate;
            this.version = version;
            final int from = totalHeaderSize - 1;
        final TestCircuitBreaker circuitBreaker = new TestCircuitBreaker();
        @Override
            final boolean isRequest = randomBoolean();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
            final BytesReference reference = serialize(isRequest, invalidVersion, false, false, actionName, requestId, value);
                    actualData = new MessageData(version, requestId, isRequest, isCompressed, header.getActionName(), request.getValue());
    }
                            messageData = new MessageData(version, requestId, true, isCompressed, actionName, value);
        final LongSupplier millisSupplier = () -> TimeValue.nsecToMSec(System.nanoTime());
                    final boolean isRequest = randomBoolean();
 * software distributed under the License is distributed on an
                && isRequest == that.isRequest
 * You may obtain a copy of the License at
                    pipeline.handleBytes(new FakeTcpChannel(), slice);
                    assertEquals(expectedMessageData.value, actualMessageData.value);
            final long requestId = randomNonNegativeLong();
            String actionName = "actionName";
