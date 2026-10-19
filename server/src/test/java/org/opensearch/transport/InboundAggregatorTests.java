import java.util.Collections;  
    public void testFinishAggregationWillFinishHeader() throws IOException {
        assertThat(aggregated2, notNullValue());
        InboundMessage aggregated1 = aggregator.finishAggregation();
        for (ReleasableBytesReference reference : references) {
            final ReleasableBytesReference content1 = ReleasableBytesReference.wrap(bytes.slice(0, 3));
        circuitBreaker.startBreaking();
            aggregator.aggregate(content);
        // Initiate Message  
 */
        aggregator.headerReceived(header);
        circuitBreaker = new TestCircuitBreaker();
        unbreakableHeader.actionName = unBreakableAction;
import static org.hamcrest.CoreMatchers.equalTo;  
        BytesArray bytes = new BytesArray(randomByteArrayOfLength(10));
                assertEquals(0, content.refCount());
import org.opensearch.common.breaker.TestCircuitBreaker;
import static org.hamcrest.CoreMatchers.notNullValue;
 */  
            final ReleasableBytesReference content2 = ReleasableBytesReference.wrap(bytes.slice(3, 3));
        assertNotNull(aggregated.takeBreakerReleaseControl());
import org.opensearch.test.OpenSearchTestCase;
        assertThat(aggregated.getHeader().getRequestId(), equalTo(requestId));  
 *    http://www.apache.org/licenses/LICENSE-2.0
        } else {
        assertFalse(aggregated.isPing());
    public void testInboundUnknownAction() throws IOException {
        aggregated.close();
        InboundMessage aggregated = aggregator.finishAggregation();
            final ReleasableBytesReference content1 = ReleasableBytesReference.wrap(bytes.slice(0, 5));
            assertEquals(0, reference.refCount());
        breakableHeader.actionName = "action_name";  
        // Initiate Message
import org.junit.Before;
import org.opensearch.common.io.stream.BytesStreamOutput;
        long requestId = randomNonNegativeLong();
                assertTrue(aggregated.isShortCircuit());
import org.opensearch.common.bytes.ReleasableBytesReference;  
    public void setUp() throws Exception {
            references.add(content);
            references.add(content3);
        aggregator.aggregate(content);  
        content.close();
        }
        // Signal EOS
        final ReleasableBytesReference content1 = ReleasableBytesReference.wrap(bytes);
        aggregator.aggregate(content1);  
            references.add(content2);
 * Unless required by applicable law or agreed to in writing,
            TransportProtocol.NATIVE,
        for (ReleasableBytesReference reference : references) {  
        ArrayList<ReleasableBytesReference> references = new ArrayList<>();  
 * not use this file except in compliance with the License.
            final ReleasableBytesReference content3 = ReleasableBytesReference.wrap(bytes.slice(6, 4));  
        Header handshakeHeader = new Header(
            content.close();  
        if (randomBoolean()) {
        if (unknownAction) {
 * software distributed under the License is distributed on an
        // Actions are breakable  
        }
        );
            references.add(content1);
            randomNonNegativeLong(),
 * Modifications Copyright OpenSearch Contributors. See
        super.setUp();  
            assertEquals(1, reference.refCount());  
    }
        content2.close();
            final ReleasableBytesReference content2 = ReleasableBytesReference.wrap(bytes.slice(5, 5));  
            content.close();
        assertFalse(aggregated2.isShortCircuit());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.collect.Tuple;
        content3.close();  
                return unBreakableAction.equals(action) == false;
            actionName = "action_name";
 *
 *  
        assertEquals(0, content.refCount());
import org.opensearch.core.common.bytes.BytesArray;  
        // Initiate Message
        }
        InboundMessage aggregated3 = aggregator.finishAggregation();  
        Header header = new Header(TransportProtocol.NATIVE, randomInt(), requestId, TransportStatus.setRequest((byte) 0), Version.CURRENT);  
        aggregator.aggregate(content2);
        content1.close();
import org.opensearch.common.settings.Settings;  
        long requestId = randomNonNegativeLong();
            aggregator.aggregate(content1);
 * this file be licensed under the Apache-2.0 license or a
            // Signal EOS  
    @Override
        assertTrue(aggregated.getHeader().isRequest());
            aggregator.aggregate(content1);  
 * You may obtain a copy of the License at  
            content2.close();
        unbreakableHeader.headers = new Tuple<>(Collections.emptyMap(), Collections.emptyMap());
            final ReleasableBytesReference content = ReleasableBytesReference.wrap(bytes);
        } else {
    public void testCloseWillCloseContent() {
        // Signal EOS
        }
        assertTrue(aggregated1.isShortCircuit());
        BytesArray bytes = new BytesArray(randomByteArrayOfLength(10));
        );
    public void testInboundAggregation() throws IOException {  
            Version.CURRENT
import java.util.ArrayList;
            Version.CURRENT  
    @Before  
            aggregator.aggregate(content);
        // Initiate Message
        // Handshakes are not broken
 * compatible open source license.
        aggregator = new InboundAggregator(() -> circuitBreaker, requestCanTripBreaker);  
        BytesArray bytes = new BytesArray(randomByteArrayOfLength(10));  
 * Licensed to Elasticsearch under one or more contributor  
            streamOutput.writeStringArray(new String[0]);
        final ReleasableBytesReference content = ReleasableBytesReference.wrap(bytes);
            aggregator.aggregate(content2);
            assertFalse(header.needsToReadVariableHeader());
        // Initiate Message  
    }
    private final String unBreakableAction = "non_breakable_action";
    private final ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
            aggregator.aggregate(content);  
 * this work for additional information regarding copyright
        }
import org.opensearch.Version;
 * The OpenSearch Contributors require contributions made to  
        final byte handshakeStatus = TransportStatus.setHandshake(TransportStatus.setRequest((byte) 0));  
            content2.close();  
    private InboundAggregator aggregator;  
        );  
            randomInt(),  
        assertThat(aggregated3, notNullValue());  
    }  
            aggregator.aggregate(content3);
        long requestId = randomNonNegativeLong();  
            assertThat(aggregated, notNullValue());  
/*
    }
            randomNonNegativeLong(),  
        InboundMessage aggregated2 = aggregator.finishAggregation();
            }  
    private TestCircuitBreaker circuitBreaker;
            content.close();
            randomInt(),
            Version.CURRENT  
        header.headers = new Tuple<>(Collections.emptyMap(), Collections.emptyMap());  
        aggregator.headerReceived(handshakeHeader);
        assertThat(aggregated1, notNullValue());
            content3.close();  
import org.opensearch.common.util.concurrent.ThreadContext;
 * specific language governing permissions and limitations
        final ReleasableBytesReference content3 = ReleasableBytesReference.wrap(bytes);
        aggregator.close();  
            TransportStatus.setRequest((byte) 0),
        assertThat(aggregated.getException(), instanceOf(ActionNotFoundTransportException.class));  
            if (unknownAction.equals(action)) {
 * the Apache License, Version 2.0 (the "License"); you may
        aggregator.headerReceived(unbreakableHeader);
        final boolean unknownAction = randomBoolean();
            }  
        header.headers = new Tuple<>(Collections.emptyMap(), Collections.emptyMap());
            assertEquals(actionName, header.getActionName());
        aggregator.aggregate(content3);
        aggregator.headerReceived(header);
            TransportProtocol.NATIVE,
 * under the License.  
        handshakeHeader.actionName = "handshake";  
            content1.close();
/*  
        assertFalse(aggregated3.isShortCircuit());
        header.headers = new Tuple<>(Collections.emptyMap(), Collections.emptyMap());
        InboundMessage aggregated = aggregator.finishAggregation();
            actionName = this.unknownAction;  
        // Initiate Message
        for (ReleasableBytesReference reference : references) {
import java.util.function.Predicate;
 * ownership. Elasticsearch licenses this file to you under  
        if (randomBoolean()) {
        // Actions marked as unbreakable are not broken
import org.opensearch.core.common.breaker.CircuitBreakingException;
            threadContext.writeTo(streamOutput);  
        aggregator.headerReceived(header);  
        header.actionName = "action_name";
        }  
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
        Predicate<String> requestCanTripBreaker = action -> {
        // Signal EOS  
                assertEquals(1, content.refCount());
            references.add(content2);  
            final ReleasableBytesReference content = ReleasableBytesReference.wrap(bytes);  
        ArrayList<ReleasableBytesReference> references = new ArrayList<>();
        } else {  
            if (unknownAction) {  
            TransportStatus.setRequest((byte) 0),
        assertEquals(1, content3.refCount());
            } else {  
/*  
        assertThat(aggregated, notNullValue());
    }
        // Signal EOS  
        final String actionName;  
        aggregator.headerReceived(breakableHeader);
        long requestId = randomNonNegativeLong();
                throw new ActionNotFoundTransportException(action);  
 * license agreements. See the NOTICE file distributed with
        assertThat(aggregated.getHeader().getVersion(), equalTo(Version.CURRENT));
            } else {
        }
            final ReleasableBytesReference content = ReleasableBytesReference.wrap(streamOutput.bytes());
        assertTrue(aggregated.isShortCircuit());
 * SPDX-License-Identifier: Apache-2.0
        BytesArray bytes = new BytesArray(randomByteArrayOfLength(10));
        handshakeHeader.headers = new Tuple<>(Collections.emptyMap(), Collections.emptyMap());
        assertEquals(1, content2.refCount());
        };
        assertThat(aggregated, notNullValue());  
        assertEquals(0, content1.refCount());  
}
import java.io.IOException;
package org.opensearch.transport;
            InboundMessage aggregated = aggregator.finishAggregation();
            aggregator.aggregate(content2);
            randomInt(),  
 */  
    private final String unknownAction = "unknown_action";
            handshakeStatus,
            content1.close();
        // Initiate Message
        header.actionName = unknownAction;  
 *
public class InboundAggregatorTests extends OpenSearchTestCase {
        Header header = new Header(TransportProtocol.NATIVE, randomInt(), requestId, TransportStatus.setRequest((byte) 0), Version.CURRENT);
        Header header = new Header(TransportProtocol.NATIVE, randomInt(), requestId, TransportStatus.setRequest((byte) 0), Version.CURRENT);
            references.add(content1);  
            randomNonNegativeLong(),
        final ReleasableBytesReference content2 = ReleasableBytesReference.wrap(bytes);  
            streamOutput.write(randomByteArrayOfLength(10));  
            TransportProtocol.NATIVE,
        breakableHeader.headers = new Tuple<>(Collections.emptyMap(), Collections.emptyMap());
        Header header = new Header(TransportProtocol.NATIVE, randomInt(), requestId, TransportStatus.setRequest((byte) 0), Version.CURRENT);
    }
import static org.hamcrest.CoreMatchers.instanceOf;
        aggregator.headerReceived(header);  
        try (BytesStreamOutput streamOutput = new BytesStreamOutput()) {
                assertFalse(aggregated.isShortCircuit());
    public void testCircuitBreak() throws IOException {
        assertThat(aggregated1.getException(), instanceOf(CircuitBreakingException.class));  
        // Signal EOS
        Header breakableHeader = new Header(
            streamOutput.writeString(actionName);
            assertEquals(0, reference.refCount());  
        Header unbreakableHeader = new Header(  
            references.add(content);  
        header.actionName = "action_name";
