 *
import org.opensearch.core.transport.TransportResponse;
        handshaker.sendHandshake(reqId, node, channel, new TimeValue(30, TimeUnit.SECONDS), versionFuture);
            Version.CURRENT
        long reqId = randomLongBetween(1, 10);
        channel = mock(TcpChannel.class);
import org.opensearch.core.common.io.stream.StreamInput;
            futureHandshake.writeBytesReference(internalMessage.bytes());
        BytesStreamOutput currentHandshakeBytes = new BytesStreamOutput();
        assertThat(cte.getMessage(), containsString("failure to send internal:tcp/handshake"));
 * Modifications Copyright OpenSearch Contributors. See
        handshaker.sendHandshake(reqId, node, channel, new TimeValue(30, TimeUnit.SECONDS), PlainActionFuture.newFuture());
import org.opensearch.Version;
        TransportResponseHandler<TransportHandshaker.HandshakeResponse> handler = handshaker.removeHandlerForHandshake(reqId);
    @Override
            "host_address",
    public void testHandshakeError() throws IOException {
        );
import static org.hamcrest.Matchers.containsString;
 */
        node = new DiscoveryNode(
        assertTrue(versionFuture.isDone());
 * You may obtain a copy of the License at
    }
 * specific language governing permissions and limitations
        Version compatibilityVersion = getMinCompatibilityVersionForHandshakeRequest();
import java.io.IOException;
        handshaker.sendHandshake(reqId, node, channel, new TimeValue(30, TimeUnit.SECONDS), versionFuture);
        handshaker = new TransportHandshaker(Version.CURRENT, threadPool, requestSender);
        final TestTransportChannel channel = new TestTransportChannel(responseFuture);
    private DiscoveryNode node;
        PlainActionFuture<Version> versionFuture = PlainActionFuture.newFuture();
    private TransportHandshaker handshaker;
        BytesStreamOutput bytesStreamOutput = new BytesStreamOutput();
 *    http://www.apache.org/licenses/LICENSE-2.0
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.concurrent.TimeUnit;
        BytesStreamOutput lengthCheckingHandshake = new BytesStreamOutput();
    }
            nodeId,
        ConnectTransportException cte = expectThrows(ConnectTransportException.class, versionFuture::actionGet);
}
    @Override
        long reqId = randomLongBetween(1, 10);
    }
    }
        super.tearDown();
        requestSender = mock(TransportHandshaker.HandshakeRequestSender.class);
import org.opensearch.cluster.node.DiscoveryNode;
        PlainActionFuture<Version> versionFuture = PlainActionFuture.newFuture();
        assertThat(cte.getMessage(), containsString("handshake_timeout"));
        ConnectTransportException cte = expectThrows(ConnectTransportException.class, versionFuture::actionGet);
        PlainActionFuture<Version> versionFuture = PlainActionFuture.newFuture();
            nodeId,
    private TcpChannel channel;
/*
    public void testHandshakeTimeout() throws IOException {
        handshaker.sendHandshake(reqId, node, channel, new TimeValue(30, TimeUnit.SECONDS), versionFuture);
            Collections.emptySet(),
    private TestThreadPool threadPool;
        final PlainActionFuture<TransportResponse> responseFuture = PlainActionFuture.newFuture();
        final TestTransportChannel channel = new TestTransportChannel(responseFuture);
    public void testHandshakeRequestFutureVersionsCompatibility() throws IOException {
            buildNewFakeTransportAddress(),
        String nodeId = "node-id";
 * ownership. Elasticsearch licenses this file to you under
 *
 * under the License.
 * compatible open source license.
/*
        handshaker.handleHandshake(channel, reqId, input);
        doThrow(new IOException("boom")).when(requestSender).sendRequest(node, channel, reqId, compatibilityVersion);
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
        TransportResponseHandler<TransportHandshaker.HandshakeResponse> handler = handshaker.removeHandlerForHandshake(reqId);
        TransportHandshaker.HandshakeRequest handshakeRequest = new TransportHandshaker.HandshakeRequest(Version.CURRENT);
 * GitHub history for details.
            "host",
 * The OpenSearch Contributors require contributions made to
        final PlainActionFuture<TransportResponse> responseFuture = PlainActionFuture.newFuture();
        assertEquals(1031, futureHandshakeStream.available());
        verify(requestSender).sendRequest(node, channel, reqId, getMinCompatibilityVersionForHandshakeRequest());
 *
        PlainActionFuture<Version> versionFuture = PlainActionFuture.newFuture();
import static org.mockito.Mockito.mock;
        TaskId.EMPTY_TASK_ID.writeTo(lengthCheckingHandshake);
        TransportHandshaker.HandshakeRequest handshakeRequest = new TransportHandshaker.HandshakeRequest(Version.CURRENT);
        assertEquals(0, futureHandshakeStream.available());
        assertThat(ise.getMessage(), containsString("handshake failed"));
import static org.mockito.Mockito.doThrow;
        long reqId = randomLongBetween(1, 10);
        TransportHandshaker.HandshakeResponse response = (TransportHandshaker.HandshakeResponse) responseFuture.actionGet();
        try (BytesStreamOutput internalMessage = new BytesStreamOutput()) {
        handshakeRequest.writeTo(bytesStreamOutput);
    private Version getMinCompatibilityVersionForHandshakeRequest() {
        threadPool = new TestThreadPool("thread-poll");
        handshaker.handleHandshake(channel, reqId, futureHandshakeStream);
            lengthCheckingHandshake.writeBytesReference(internalMessage.bytes());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.common.io.stream.BytesStreamOutput;
 * license agreements. See the NOTICE file distributed with
        long reqId = randomLongBetween(1, 10);
        StreamInput futureHandshakeStream = futureHandshake.bytes().streamInput();
 * this work for additional information regarding copyright
    }
    public void tearDown() throws Exception {
public class TransportHandshakerTests extends OpenSearchTestCase {
package org.opensearch.transport;
    public void setUp() throws Exception {
        verify(requestSender).sendRequest(node, channel, reqId, getMinCompatibilityVersionForHandshakeRequest());
    }
    public void testSendRequestThrowsException() throws IOException {
 * Licensed to Elasticsearch under one or more contributor
        BytesStreamOutput futureHandshake = new BytesStreamOutput();
            nodeId,
        assertEquals(Version.CURRENT, versionFuture.actionGet());
        assertEquals(currentHandshakeBytes.bytes().length(), lengthCheckingHandshake.bytes().length());
            internalMessage.write(new byte[1024]);
        return Version.CURRENT.minimumCompatibilityVersion();
import java.util.Collections;
        assertFalse(versionFuture.isDone());
        assertTrue(versionFuture.isDone());
 */
        // We check that the handshake we serialize for this test equals the actual request.
        TaskId.EMPTY_TASK_ID.writeTo(futureHandshake);
 * Unless required by applicable law or agreed to in writing,
import static org.mockito.Mockito.verify;
            internalMessage.writeVersion(Version.CURRENT);
        handler.handleException(new TransportException("failed"));
    }
        assertNull(handshaker.removeHandlerForHandshake(reqId));
        IllegalStateException ise = expectThrows(IllegalStateException.class, versionFuture::actionGet);
        super.setUp();
        StreamInput input = bytesStreamOutput.bytes().streamInput();
import org.opensearch.core.tasks.TaskId;
        }
/*
        verify(requestSender).sendRequest(node, channel, reqId, getMinCompatibilityVersionForHandshakeRequest());
    public void testHandshakeRequestAndResponse() throws IOException {
        assertFalse(versionFuture.isDone());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.common.unit.TimeValue;
    }
        assertNull(handshaker.removeHandlerForHandshake(reqId));
        threadPool.shutdown();
    private TransportHandshaker.HandshakeRequestSender requestSender;
        handshakeRequest.writeTo(currentHandshakeBytes);
import org.opensearch.test.OpenSearchTestCase;
        // Otherwise, we need to update the test.
        assertTrue(versionFuture.isDone());
        assertEquals(Version.CURRENT, response.getResponseVersion());
 */
        handler.handleResponse((TransportHandshaker.HandshakeResponse) responseFuture.actionGet());
        handshaker.sendHandshake(reqId, node, channel, new TimeValue(100, TimeUnit.MILLISECONDS), versionFuture);
import org.opensearch.threadpool.TestThreadPool;
 * software distributed under the License is distributed on an
        verify(requestSender).sendRequest(node, channel, reqId, getMinCompatibilityVersionForHandshakeRequest());
        long reqId = randomLongBetween(1, 10);
            Collections.emptyMap(),
 * not use this file except in compliance with the License.
