    public void setUp() throws Exception {
        ConnectTransportException cte = expectThrows(ConnectTransportException.class, versionFuture::actionGet);
    private DiscoveryNode node;
        verify(requestSender).sendRequest(node, channel, reqId, getMinCompatibilityVersionForHandshakeRequest());  
        handshaker.sendHandshake(reqId, node, channel, new TimeValue(30, TimeUnit.SECONDS), versionFuture);  
    }
            lengthCheckingHandshake.writeBytesReference(internalMessage.bytes());
        threadPool.shutdown();  
import static org.mockito.Mockito.verify;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.test.OpenSearchTestCase;
        handshaker.sendHandshake(reqId, node, channel, new TimeValue(30, TimeUnit.SECONDS), versionFuture);
        assertFalse(versionFuture.isDone());
        assertTrue(versionFuture.isDone());
        channel = mock(TcpChannel.class);
    private Version getMinCompatibilityVersionForHandshakeRequest() {
        assertThat(cte.getMessage(), containsString("failure to send internal:tcp/handshake"));  
        StreamInput input = bytesStreamOutput.bytes().streamInput();
        assertEquals(0, futureHandshakeStream.available());
import org.opensearch.core.transport.TransportResponse;
        requestSender = mock(TransportHandshaker.HandshakeRequestSender.class);  
import static org.mockito.Mockito.mock;
import java.util.Collections;  
        assertEquals(Version.CURRENT, response.getResponseVersion());  
}
 * Licensed to Elasticsearch under one or more contributor  
    }
        handshaker.sendHandshake(reqId, node, channel, new TimeValue(100, TimeUnit.MILLISECONDS), versionFuture);
 * software distributed under the License is distributed on an
 * compatible open source license.
        String nodeId = "node-id";
 * You may obtain a copy of the License at  
        final TestTransportChannel channel = new TestTransportChannel(responseFuture);  
 * Unless required by applicable law or agreed to in writing,
        IllegalStateException ise = expectThrows(IllegalStateException.class, versionFuture::actionGet);
    @Override
        assertFalse(versionFuture.isDone());
 *  
    public void testHandshakeRequestFutureVersionsCompatibility() throws IOException {
        assertTrue(versionFuture.isDone());  
        ConnectTransportException cte = expectThrows(ConnectTransportException.class, versionFuture::actionGet);
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
        BytesStreamOutput lengthCheckingHandshake = new BytesStreamOutput();
        assertThat(ise.getMessage(), containsString("handshake failed"));
 * The OpenSearch Contributors require contributions made to  
        Version compatibilityVersion = getMinCompatibilityVersionForHandshakeRequest();
            buildNewFakeTransportAddress(),
        handshaker.handleHandshake(channel, reqId, futureHandshakeStream);
        handshaker = new TransportHandshaker(Version.CURRENT, threadPool, requestSender);
            internalMessage.write(new byte[1024]);  
 */  
        verify(requestSender).sendRequest(node, channel, reqId, getMinCompatibilityVersionForHandshakeRequest());
        assertNull(handshaker.removeHandlerForHandshake(reqId));
        doThrow(new IOException("boom")).when(requestSender).sendRequest(node, channel, reqId, compatibilityVersion);  
        PlainActionFuture<Version> versionFuture = PlainActionFuture.newFuture();
        verify(requestSender).sendRequest(node, channel, reqId, getMinCompatibilityVersionForHandshakeRequest());  
        handshaker.handleHandshake(channel, reqId, input);
        assertEquals(currentHandshakeBytes.bytes().length(), lengthCheckingHandshake.bytes().length());  
    }
import org.opensearch.core.common.io.stream.StreamInput;
        long reqId = randomLongBetween(1, 10);
            "host_address",  
import java.io.IOException;
import org.opensearch.cluster.node.DiscoveryNode;
        TransportHandshaker.HandshakeRequest handshakeRequest = new TransportHandshaker.HandshakeRequest(Version.CURRENT);
import org.opensearch.threadpool.TestThreadPool;  
/*
        final PlainActionFuture<TransportResponse> responseFuture = PlainActionFuture.newFuture();
    }
        handshaker.sendHandshake(reqId, node, channel, new TimeValue(30, TimeUnit.SECONDS), versionFuture);
        BytesStreamOutput futureHandshake = new BytesStreamOutput();  
        TransportResponseHandler<TransportHandshaker.HandshakeResponse> handler = handshaker.removeHandlerForHandshake(reqId);  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See  
            nodeId,
import org.opensearch.common.unit.TimeValue;
        super.setUp();  
 *
 * under the License.  
        handshaker.sendHandshake(reqId, node, channel, new TimeValue(30, TimeUnit.SECONDS), PlainActionFuture.newFuture());  
            internalMessage.writeVersion(Version.CURRENT);
    public void tearDown() throws Exception {
    public void testHandshakeTimeout() throws IOException {
        PlainActionFuture<Version> versionFuture = PlainActionFuture.newFuture();
package org.opensearch.transport;
        TaskId.EMPTY_TASK_ID.writeTo(futureHandshake);
        PlainActionFuture<Version> versionFuture = PlainActionFuture.newFuture();
            nodeId,  
import static org.mockito.Mockito.doThrow;
        PlainActionFuture<Version> versionFuture = PlainActionFuture.newFuture();  
import java.util.concurrent.TimeUnit;
        BytesStreamOutput bytesStreamOutput = new BytesStreamOutput();
    private TransportHandshaker handshaker;
 * GitHub history for details.
import org.opensearch.Version;  
        handshakeRequest.writeTo(currentHandshakeBytes);  
        assertTrue(versionFuture.isDone());  
            nodeId,
    private TestThreadPool threadPool;
import static org.hamcrest.Matchers.containsString;  
        // We check that the handshake we serialize for this test equals the actual request.
        assertThat(cte.getMessage(), containsString("handshake_timeout"));  
    public void testHandshakeRequestAndResponse() throws IOException {
        try (BytesStreamOutput internalMessage = new BytesStreamOutput()) {  
 */
        StreamInput futureHandshakeStream = futureHandshake.bytes().streamInput();  
    private TransportHandshaker.HandshakeRequestSender requestSender;
        final PlainActionFuture<TransportResponse> responseFuture = PlainActionFuture.newFuture();
        assertNull(handshaker.removeHandlerForHandshake(reqId));
        return Version.CURRENT.minimumCompatibilityVersion();  
import org.opensearch.common.io.stream.BytesStreamOutput;  
        // Otherwise, we need to update the test.
        long reqId = randomLongBetween(1, 10);  
    }
 * SPDX-License-Identifier: Apache-2.0
    @Override
/*
        long reqId = randomLongBetween(1, 10);
        TaskId.EMPTY_TASK_ID.writeTo(lengthCheckingHandshake);
        TransportHandshaker.HandshakeRequest handshakeRequest = new TransportHandshaker.HandshakeRequest(Version.CURRENT);
import org.opensearch.action.support.PlainActionFuture;
        assertEquals(1031, futureHandshakeStream.available());
        );
 * this file be licensed under the Apache-2.0 license or a
        handler.handleResponse((TransportHandshaker.HandshakeResponse) responseFuture.actionGet());
        assertEquals(Version.CURRENT, versionFuture.actionGet());
    }  
        verify(requestSender).sendRequest(node, channel, reqId, getMinCompatibilityVersionForHandshakeRequest());
        TransportResponseHandler<TransportHandshaker.HandshakeResponse> handler = handshaker.removeHandlerForHandshake(reqId);  
        final TestTransportChannel channel = new TestTransportChannel(responseFuture);  
 * KIND, either express or implied.  See the License for the
    public void testSendRequestThrowsException() throws IOException {
    private TcpChannel channel;  
import org.opensearch.core.tasks.TaskId;  
        node = new DiscoveryNode(
 */
            "host",
            Collections.emptyMap(),
/*  
    public void testHandshakeError() throws IOException {  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        TransportHandshaker.HandshakeResponse response = (TransportHandshaker.HandshakeResponse) responseFuture.actionGet();
            futureHandshake.writeBytesReference(internalMessage.bytes());
        threadPool = new TestThreadPool("thread-poll");  
        super.tearDown();
        handshakeRequest.writeTo(bytesStreamOutput);  
 *
        long reqId = randomLongBetween(1, 10);
            Collections.emptySet(),  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
            Version.CURRENT
    }  
        BytesStreamOutput currentHandshakeBytes = new BytesStreamOutput();
        handler.handleException(new TransportException("failed"));
        }
        long reqId = randomLongBetween(1, 10);  
public class TransportHandshakerTests extends OpenSearchTestCase {
