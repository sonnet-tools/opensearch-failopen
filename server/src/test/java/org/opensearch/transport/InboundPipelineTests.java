                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertFalse(bodyReleased.get());  
            if (o == null || getClass() != o.getClass()) return false;
    }
        }
import java.io.IOException;
        try (BytesStreamOutput streamOutput = new BytesStreamOutput()) {  
                        pipeline.handleBytes(channel, reference);
            final int totalHeaderSize = fixedHeaderSize + variableHeaderSize;
        long bytesReceived = 0;  
                final MessageData actualData;
 *  
import org.opensearch.common.util.concurrent.ThreadContext;
            }
import java.util.function.Predicate;
    public void testEnsureBodyIsNotPrematurelyReleased() throws IOException {  
/*  
        final List<Tuple<MessageData, Exception>> expected = new ArrayList<>();
    private static class MessageData {
        }  
                    final int remainingBytes = networkBytes.length() - currentOffset;
 * not use this file except in compliance with the License.
                        reference = serialize(false, version, false, isCompressed, actionName, requestId, value);  
                    assertEquals(expectedMessageData.isCompressed, actualMessageData.isCompressed);
        final InboundPipeline pipeline = new InboundPipeline(statsTracker, millisSupplier, decoder, aggregator, messageHandler);
        final InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);  
                    } else {
import org.opensearch.core.common.bytes.BytesArray;  
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.common.lease.Releasable;  
            try (BytesStreamOutput streamOutput = new BytesStreamOutput()) {  
            try (ReleasableBytesReference slice = new ReleasableBytesReference(reference.slice(reference.length() - 1, 1), releasable)) {
        @Override
            final BytesReference reference = serialize(isRequest, version, false, false, actionName, requestId, value);
 * KIND, either express or implied.  See the License for the
        boolean isRequest,
                    final Tuple<MessageData, Exception> expectedTuple = expected.get(j);
        private final boolean isRequest;  
        final StatsTracker statsTracker = new StatsTracker();
            final int fixedHeaderSize = TcpHeader.headerSize(Version.CURRENT);
                    final TestResponse response = new TestResponse(message.openOrGetStreamInput());
import java.util.function.LongSupplier;
            this.value = value;
            );
package org.opensearch.transport;
                    try (ReleasableBytesReference reference = new ReleasableBytesReference(slice, () -> {})) {
                final long requestId = header.getRequestId();
                    final long requestId = totalMessages++;  
import java.util.function.BiConsumer;  
        Version version,
                        } else {  
        BiConsumer<TcpChannel, InboundMessage> messageHandler = (c, m) -> {};
            this.actionName = actionName;
                            reference = serialize(true, version, false, isCompressed, actionName, requestId, value);
import org.opensearch.common.util.io.Streams;
            expected.clear();
        private final Version version;
            MessageData that = (MessageData) o;  
import org.opensearch.common.io.stream.BytesStreamOutput;
                while (streamOutput.size() < BYTE_THRESHOLD) {
                    actualData = new MessageData(version, requestId, isRequest, isCompressed, header.getActionName(), request.getValue());
        final StatsTracker statsTracker = new StatsTracker();
        final String breakThisAction = "break_this_action";
        final InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);
            try (ReleasableBytesReference releasable = ReleasableBytesReference.wrap(reference)) {
        final int iterations = randomIntBetween(5, 10);
                    }
                    assertEquals(expectedMessageData.actionName, actualMessageData.actionName);  
        for (int i = 0; i < iterations; ++i) {
                    final BytesReference reference;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.instanceOf;
            this.isCompressed = isCompressed;  
            }  
                            expectedExceptionClass = new CircuitBreakingException("", CircuitBreaker.Durability.PERMANENT);
    public final ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
 * this file be licensed under the Apache-2.0 license or a
                if (message.isShortCircuit()) {
import org.opensearch.common.unit.TimeValue;
                    assertEquals(expectedMessageData.value, actualMessageData.value);
            this.requestId = requestId;
            assertEquals(bytesReceived, statsTracker.getBytesRead());
        final Supplier<CircuitBreaker> breaker = () -> new NoopCircuitBreaker("test");
import org.opensearch.common.bytes.ReleasableBytesReference;  
            return requestId == that.requestId
import org.opensearch.core.common.breaker.CircuitBreakingException;
            // Pipeline cannot be reused after uncaught exception  
        boolean handshake,  
                    final String value = randomAlphaOfLength(randomIntBetween(10, 200));  
 * You may obtain a copy of the License at  
                    final boolean isRequest = randomBoolean();
        final InboundAggregator aggregator = new InboundAggregator(() -> circuitBreaker, canTripBreaker);  
/*
                final Version version = header.getVersion();  
        long totalMessages = 0;
                pipeline.handleBytes(new FakeTcpChannel(), slice);
                while (currentOffset != networkBytes.length()) {  
            final Version version = Version.CURRENT;
 */  
                        messageData = new MessageData(version, requestId, false, isCompressed, null, value);
        public boolean equals(Object o) {  
        final TestCircuitBreaker circuitBreaker = new TestCircuitBreaker();
        final InboundAggregator aggregator = new InboundAggregator(breaker, (Predicate<String>) action -> true);  
            final int from = totalHeaderSize - 1;
 * the Apache License, Version 2.0 (the "License"); you may
            final IllegalStateException ise = expectThrows(
 *
import java.util.function.Supplier;  
            toRelease.clear();
import org.opensearch.common.settings.Settings;
    ) throws IOException;
        final InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);
                throw new AssertionError(e);  
import java.util.ArrayList;
                actual.add(new Tuple<>(actualData, message.getException()));
    private static final int BYTE_THRESHOLD = 128 * 1024;  
            } catch (IOException e) {
        final Predicate<String> canTripBreaker = breakThisAction::equals;  
 * Licensed to Elasticsearch under one or more contributor  
            final boolean isRequest = randomBoolean();
import org.opensearch.common.util.PageCacheRecycler;  
            try {  
                    final BytesReference slice = networkBytes.slice(currentOffset, bytesToRead);  
                }  
                    actualData = new MessageData(version, requestId, isRequest, isCompressed, header.getActionName(), null);
                    final Version version = randomFrom(Version.CURRENT, Version.CURRENT.minimumCompatibilityVersion());
            final BytesReference reference = serialize(isRequest, invalidVersion, false, false, actionName, requestId, value);
            this.isRequest = isRequest;
    public void testPipelineHandlingForNativeProtocol() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
            }
 * Modifications Copyright OpenSearch Contributors. See
        };
import java.util.Objects;
 * software distributed under the License is distributed on an
                        }  
                    final Tuple<MessageData, Exception> actualTuple = actual.get(j);  
import org.opensearch.test.OpenSearchTestCase;
                && Objects.equals(version, that.version)
            assertEquals("Pipeline state corrupted by uncaught exception", ise.getMessage());
            for (int i = 0; i < totalHeaderSize - 1; ++i) {  
        boolean compress,
        }  
        final List<Tuple<MessageData, Exception>> actual = new ArrayList<>();  
import java.util.concurrent.atomic.AtomicBoolean;
import org.opensearch.common.collect.Tuple;
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
                } else if (isRequest) {  
        BiConsumer<TcpChannel, InboundMessage> messageHandler = (c, m) -> {};
        String value
            return Objects.hash(version, requestId, isRequest, isCompressed, value, actionName);
                    }  
                final int messages = expected.size();  
                final Header header = message.getHeader();
        }
    public void testDecodeExceptionIsPropagated() throws IOException {  
            assertEquals(totalMessages, statsTracker.getMessagesReceived());
            this.version = version;  
        final LongSupplier millisSupplier = () -> TimeValue.nsecToMSec(System.nanoTime());
        }  
            actual.clear();  
                int currentOffset = 0;
public abstract class InboundPipelineTests extends OpenSearchTestCase {
                try (ReleasableBytesReference slice = ReleasableBytesReference.wrap(reference.slice(i, 1))) {
    }
                    final MessageData actualMessageData = actualTuple.v1();
            final Releasable releasable = () -> bodyReleased.set(true);  
 * ownership. Elasticsearch licenses this file to you under  
        @Override  
        final FakeTcpChannel channel = new FakeTcpChannel();
        final InboundAggregator aggregator = new InboundAggregator(breaker, (Predicate<String>) action -> true);  
 * compatible open source license.
        final InboundPipeline pipeline = new InboundPipeline(statsTracker, millisSupplier, decoder, aggregator, messageHandler);
        final InboundPipeline pipeline = new InboundPipeline(statsTracker, millisSupplier, decoder, aggregator, messageHandler);
                () -> pipeline.handleBytes(new FakeTcpChannel(), ReleasableBytesReference.wrap(BytesArray.EMPTY))  
                        bytesReceived += reference.length();  
        final BiConsumer<TcpChannel, InboundMessage> messageHandler = (c, message) -> {
                }  
}
            }
                        assertThat(actualTuple.v2(), instanceOf(expectedTuple.v2().getClass()));
                    }
            final BytesReference partHeaderPartBody = reference.slice(from, reference.length() - from - 1);
                        assertNotNull(actualTuple.v2());  
 */
                expectThrows(IllegalStateException.class, () -> pipeline.handleBytes(new FakeTcpChannel(), releasable));  
        long requestId,  
                final boolean isCompressed = header.isCompressed();  
        circuitBreaker.startBreaking();
                    // NativeOutboundMessage message;
                }
import org.opensearch.core.common.breaker.NoopCircuitBreaker;
import org.opensearch.common.breaker.TestCircuitBreaker;
        final List<ReleasableBytesReference> toRelease = new ArrayList<>();
            try (ReleasableBytesReference slice = new ReleasableBytesReference(partHeaderPartBody, releasable)) {  
                    Streams.copy(reference.streamInput(), streamOutput);
                    final TestRequest request = new TestRequest(message.openOrGetStreamInput());
    protected abstract BytesReference serialize(  
                    assertEquals(expectedMessageData.isRequest, actualMessageData.isRequest);
            final String value = randomAlphaOfLength(1000);  
                && isCompressed == that.isCompressed  
            final AtomicBoolean bodyReleased = new AtomicBoolean(false);
            final Version invalidVersion = Version.CURRENT.minimumCompatibilityVersion().minimumCompatibilityVersion();
                    assertEquals(0, released.refCount());  
 */  
                    final int bytesToRead = Math.min(randomIntBetween(1, 32 * 1024), remainingBytes);
        final StatsTracker statsTracker = new StatsTracker();
                        if (rarely()) {
 * Unless required by applicable law or agreed to in writing,
                && isRequest == that.isRequest
        public int hashCode() {
 * license agreements. See the NOTICE file distributed with
                            messageData = new MessageData(version, requestId, true, isCompressed, breakThisAction, null);  
 *
        final LongSupplier millisSupplier = () -> TimeValue.nsecToMSec(System.nanoTime());  
                        toRelease.add(reference);
        private MessageData(Version version, long requestId, boolean isRequest, boolean isCompressed, String actionName, String value) {
                    final MessageData messageData;
                    Exception expectedExceptionClass = null;  
            final long requestId = randomNonNegativeLong();
                final boolean isRequest = header.isRequest();
    }
 * GitHub history for details.
            final int variableHeaderSize = reference.getInt(fixedHeaderSize - 4);  
            if (this == o) return true;
                } else {  
                    pipeline.handleBytes(new FakeTcpChannel(), slice);
            final String value = randomAlphaOfLength(1000);  
            String actionName = "actionName";
/*  
                            messageData = new MessageData(version, requestId, true, isCompressed, actionName, value);
                    expected.add(new Tuple<>(messageData, expectedExceptionClass));  
            final long requestId = randomNonNegativeLong();
        final LongSupplier millisSupplier = () -> TimeValue.nsecToMSec(System.nanoTime());  
                for (ReleasableBytesReference released : toRelease) {
        String action,
import org.opensearch.core.common.breaker.CircuitBreaker;  
            }
        final String actionName = "actionName";
                pipeline.handleBytes(new FakeTcpChannel(), slice);
                for (int j = 0; j < messages; ++j) {
            final boolean isRequest = randomBoolean();
                    if (isRequest) {
        final Supplier<CircuitBreaker> breaker = () -> new NoopCircuitBreaker("test");
                }  
            }
                            reference = serialize(true, version, false, isCompressed, breakThisAction, requestId, value);
                }
                    assertEquals(expectedMessageData.requestId, actualMessageData.requestId);  
                    final boolean isCompressed = randomBoolean();
                    actualData = new MessageData(version, requestId, isRequest, isCompressed, null, response.getValue());
        private final boolean isCompressed;
        private final long requestId;
                        currentOffset += bytesToRead;
                    if (expectedTuple.v2() != null) {
                && Objects.equals(actionName, that.actionName);  
                && Objects.equals(value, that.value)
            String actionName = "actionName";
import java.util.List;  
    }  
        try (BytesStreamOutput streamOutput = new BytesStreamOutput()) {  
            assertTrue(bodyReleased.get());
 * under the License.  
        }  
 * The OpenSearch Contributors require contributions made to  
                final BytesReference networkBytes = streamOutput.bytes();
                    final MessageData expectedMessageData = expectedTuple.v1();
        private final String actionName;  
                IllegalStateException.class,
import org.opensearch.Version;
        private final String value;
