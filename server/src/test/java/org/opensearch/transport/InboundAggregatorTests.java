        );
            randomNonNegativeLong(),
 * not use this file except in compliance with the License.
        Predicate<String> requestCanTripBreaker = action -> {
            randomNonNegativeLong(),
        final ReleasableBytesReference content3 = ReleasableBytesReference.wrap(bytes);
        // Signal EOS
            references.add(content1);
 * GitHub history for details.
import org.opensearch.core.common.bytes.BytesArray;
        aggregator.headerReceived(header);
        Header header = new Header(TransportProtocol.NATIVE, randomInt(), requestId, TransportStatus.setRequest((byte) 0), Version.CURRENT);
    public void testCircuitBreak() throws IOException {
        // Initiate Message
        // Signal EOS
        for (ReleasableBytesReference reference : references) {
        Header header = new Header(TransportProtocol.NATIVE, randomInt(), requestId, TransportStatus.setRequest((byte) 0), Version.CURRENT);
    }
import java.util.function.Predicate;
            assertThat(aggregated, notNullValue());
        for (ReleasableBytesReference reference : references) {
 * Modifications Copyright OpenSearch Contributors. See
        breakableHeader.headers = new Tuple<>(Collections.emptyMap(), Collections.emptyMap());
            actionName = this.unknownAction;
        final ReleasableBytesReference content = ReleasableBytesReference.wrap(bytes);
import org.opensearch.common.collect.Tuple;
        // Initiate Message
                throw new ActionNotFoundTransportException(action);
    public void testCloseWillCloseContent() {
        // Initiate Message
 * KIND, either express or implied.  See the License for the
            aggregator.aggregate(content2);
        handshakeHeader.actionName = "handshake";
            aggregator.aggregate(content);
                return unBreakableAction.equals(action) == false;
        aggregator.close();
    private TestCircuitBreaker circuitBreaker;
            streamOutput.write(randomByteArrayOfLength(10));
        handshakeHeader.headers = new Tuple<>(Collections.emptyMap(), Collections.emptyMap());
            Version.CURRENT
        aggregator.headerReceived(breakableHeader);
            content.close();
        final ReleasableBytesReference content1 = ReleasableBytesReference.wrap(bytes);
package org.opensearch.transport;
 * license agreements. See the NOTICE file distributed with
        if (randomBoolean()) {
        // Actions marked as unbreakable are not broken
        content1.close();
            references.add(content);
import static org.hamcrest.CoreMatchers.notNullValue;
        Header header = new Header(TransportProtocol.NATIVE, randomInt(), requestId, TransportStatus.setRequest((byte) 0), Version.CURRENT);
        }
            aggregator.aggregate(content);
        for (ReleasableBytesReference reference : references) {
    }
 * You may obtain a copy of the License at
        assertEquals(1, content2.refCount());
        aggregator.aggregate(content);
        assertEquals(0, content.refCount());
public class InboundAggregatorTests extends OpenSearchTestCase {
/*
            TransportStatus.setRequest((byte) 0),
            threadContext.writeTo(streamOutput);
import org.opensearch.common.util.concurrent.ThreadContext;
        assertThat(aggregated2, notNullValue());
            aggregator.aggregate(content1);
        aggregator.aggregate(content1);
        content.close();
    public void testInboundAggregation() throws IOException {
        aggregator.aggregate(content3);
        final byte handshakeStatus = TransportStatus.setHandshake(TransportStatus.setRequest((byte) 0));
import org.opensearch.common.io.stream.BytesStreamOutput;
            assertEquals(0, reference.refCount());
            if (unknownAction) {
        }
            randomNonNegativeLong(),
import org.opensearch.test.OpenSearchTestCase;
            aggregator.aggregate(content3);
/*
            streamOutput.writeString(actionName);
 * Licensed to Elasticsearch under one or more contributor
        assertFalse(aggregated2.isShortCircuit());
}
        ArrayList<ReleasableBytesReference> references = new ArrayList<>();
        content2.close();
            references.add(content1);
import java.util.Collections;
    @Before
 * under the License.
        assertThat(aggregated.getException(), instanceOf(ActionNotFoundTransportException.class));
        // Signal EOS
            content2.close();
            streamOutput.writeStringArray(new String[0]);
            TransportProtocol.NATIVE,
        BytesArray bytes = new BytesArray(randomByteArrayOfLength(10));
/*
        assertThat(aggregated, notNullValue());
        InboundMessage aggregated2 = aggregator.finishAggregation();
            aggregator.aggregate(content2);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        aggregated.close();
        assertThat(aggregated1.getException(), instanceOf(CircuitBreakingException.class));
            randomInt(),
            references.add(content3);
                assertTrue(aggregated.isShortCircuit());
 * specific language governing permissions and limitations
            randomInt(),
        header.actionName = "action_name";
        InboundMessage aggregated = aggregator.finishAggregation();
        assertFalse(aggregated3.isShortCircuit());
    public void testInboundUnknownAction() throws IOException {
        ArrayList<ReleasableBytesReference> references = new ArrayList<>();
            final ReleasableBytesReference content2 = ReleasableBytesReference.wrap(bytes.slice(3, 3));
        assertNotNull(aggregated.takeBreakerReleaseControl());
        breakableHeader.actionName = "action_name";
 */
        long requestId = randomNonNegativeLong();
            }
        } else {
        }
        // Initiate Message
        header.headers = new Tuple<>(Collections.emptyMap(), Collections.emptyMap());
        circuitBreaker.startBreaking();
        aggregator.headerReceived(handshakeHeader);
        content3.close();
        assertEquals(1, content3.refCount());
        InboundMessage aggregated = aggregator.finishAggregation();
            } else {
    public void setUp() throws Exception {
        Header unbreakableHeader = new Header(
        aggregator.headerReceived(header);
 * ownership. Elasticsearch licenses this file to you under
        BytesArray bytes = new BytesArray(randomByteArrayOfLength(10));
            assertEquals(actionName, header.getActionName());
            randomInt(),
        }
        assertEquals(0, content1.refCount());
 * Unless required by applicable law or agreed to in writing,
            content1.close();
        InboundMessage aggregated1 = aggregator.finishAggregation();
 * this file be licensed under the Apache-2.0 license or a
        header.actionName = "action_name";
            references.add(content2);
            } else {
            handshakeStatus,
    private final String unknownAction = "unknown_action";
            final ReleasableBytesReference content = ReleasableBytesReference.wrap(streamOutput.bytes());
            assertFalse(header.needsToReadVariableHeader());
import org.opensearch.common.breaker.TestCircuitBreaker;
 * this work for additional information regarding copyright
        assertThat(aggregated3, notNullValue());
            content3.close();
    private final String unBreakableAction = "non_breakable_action";
    private final ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
        aggregator.headerReceived(unbreakableHeader);
            content2.close();
 */
        // Initiate Message
        // Handshakes are not broken
        };
        assertFalse(aggregated.isPing());
            Version.CURRENT
            final ReleasableBytesReference content = ReleasableBytesReference.wrap(bytes);
        }
            TransportStatus.setRequest((byte) 0),
        header.headers = new Tuple<>(Collections.emptyMap(), Collections.emptyMap());
        assertThat(aggregated, notNullValue());
        Header handshakeHeader = new Header(
            Version.CURRENT
        Header header = new Header(TransportProtocol.NATIVE, randomInt(), requestId, TransportStatus.setRequest((byte) 0), Version.CURRENT);
        Header breakableHeader = new Header(
        BytesArray bytes = new BytesArray(randomByteArrayOfLength(10));
        aggregator.aggregate(content2);
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.CoreMatchers.instanceOf;
    }
        // Signal EOS
            TransportProtocol.NATIVE,
        assertTrue(aggregated1.isShortCircuit());
        }
        final ReleasableBytesReference content2 = ReleasableBytesReference.wrap(bytes);
        if (unknownAction) {
import org.opensearch.Version;
    }
        // Initiate Message
            final ReleasableBytesReference content2 = ReleasableBytesReference.wrap(bytes.slice(5, 5));
    }
            InboundMessage aggregated = aggregator.finishAggregation();
            final ReleasableBytesReference content3 = ReleasableBytesReference.wrap(bytes.slice(6, 4));
            content.close();
            final ReleasableBytesReference content1 = ReleasableBytesReference.wrap(bytes.slice(0, 3));
        unbreakableHeader.headers = new Tuple<>(Collections.emptyMap(), Collections.emptyMap());
        final String actionName;
                assertEquals(1, content.refCount());
    public void testFinishAggregationWillFinishHeader() throws IOException {
        InboundMessage aggregated3 = aggregator.finishAggregation();
        } else {
        aggregator.headerReceived(header);
        unbreakableHeader.actionName = unBreakableAction;
        circuitBreaker = new TestCircuitBreaker();
        // Signal EOS
import org.opensearch.common.bytes.ReleasableBytesReference;
        aggregator.headerReceived(header);
            references.add(content2);
 *
        assertThat(aggregated.getHeader().getRequestId(), equalTo(requestId));
            references.add(content);
            actionName = "action_name";
            aggregator.aggregate(content1);
        if (randomBoolean()) {
            if (unknownAction.equals(action)) {
        );
    @Override
    }
import java.util.ArrayList;
        );
    private InboundAggregator aggregator;
 *
        aggregator = new InboundAggregator(() -> circuitBreaker, requestCanTripBreaker);
            final ReleasableBytesReference content = ReleasableBytesReference.wrap(bytes);
 * The OpenSearch Contributors require contributions made to
        // Actions are breakable
        header.headers = new Tuple<>(Collections.emptyMap(), Collections.emptyMap());
        super.setUp();
 * software distributed under the License is distributed on an
            TransportProtocol.NATIVE,
import org.opensearch.common.settings.Settings;
        long requestId = randomNonNegativeLong();
 * compatible open source license.
        try (BytesStreamOutput streamOutput = new BytesStreamOutput()) {
import java.io.IOException;
        BytesArray bytes = new BytesArray(randomByteArrayOfLength(10));
        final boolean unknownAction = randomBoolean();
        assertTrue(aggregated.isShortCircuit());
        assertTrue(aggregated.getHeader().isRequest());
        assertThat(aggregated1, notNullValue());
        }
            final ReleasableBytesReference content1 = ReleasableBytesReference.wrap(bytes.slice(0, 5));
            // Signal EOS
            assertEquals(0, reference.refCount());
        assertThat(aggregated.getHeader().getVersion(), equalTo(Version.CURRENT));
                assertFalse(aggregated.isShortCircuit());
        long requestId = randomNonNegativeLong();
        header.actionName = unknownAction;
 *
                assertEquals(0, content.refCount());
import org.junit.Before;
            content1.close();
import static org.hamcrest.CoreMatchers.equalTo;
        long requestId = randomNonNegativeLong();
            }
            aggregator.aggregate(content);
        // Initiate Message
 * SPDX-License-Identifier: Apache-2.0
        } else {
            assertEquals(1, reference.refCount());
 * the Apache License, Version 2.0 (the "License"); you may
            content.close();
import org.opensearch.core.common.breaker.CircuitBreakingException;
