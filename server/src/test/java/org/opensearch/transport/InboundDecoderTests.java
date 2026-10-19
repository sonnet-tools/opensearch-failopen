            assertTrue(header.isRequest());
        boolean isRequest = randomBoolean();
        assertFalse(header.needsToReadVariableHeader());
 * KIND, either express or implied.  See the License for the
        assertEquals(messageBytes, content);
        final ArrayList<Object> fragments = new ArrayList<>();
        assertTrue(header.isCompressed());
        final BytesReference totalBytes = serialize(isRequest, Version.CURRENT, false, true, action, requestId, transportMessage);
        final BytesReference totalBytes = serialize(isRequest, Version.CURRENT, false, false, action, requestId, transportMessage);
import org.opensearch.common.util.concurrent.ThreadContext;
        TransportMessage transportMessage;
            assertTrue(header.isResponse());
        if (isRequest) {
        if (isRequest) {
        boolean isRequest,
        assertEquals(uncompressedBytes, content);
        fragments.clear();
        } else {
                + version.minimumCompatibilityVersion()
        expectThrows(IllegalStateException.class, () -> decoder.decode(releasable1, fragments::add));
        assertEquals(InboundDecoder.END_CONTENT, endMarker);
        threadContext.putHeader(headerKey, headerValue);
        int totalHeaderSize = TcpHeader.headerSize(handshakeCompatVersion) + bytes.getInt(TcpHeader.VARIABLE_HEADER_SIZE_POSITION);
        final String headerValue = randomAlphaOfLength(20);
        }
        final Header header = (Header) fragments.get(0);
            requestId,
        fragments.clear();
 * this work for additional information regarding copyright
        final Header header = (Header) fragments.get(0);
        final BytesReference bytes2 = totalBytes.slice(bytesConsumed, totalBytes.length() - bytesConsumed);
public abstract class InboundDecoderTests extends OpenSearchTestCase {
import java.io.IOException;
        long requestId = randomNonNegativeLong();
 */
import org.opensearch.test.VersionUtils;
        assertTrue(header.isCompressed());
        } else {
        final ArrayList<Object> fragments = new ArrayList<>();
        assertEquals(totalHeaderSize, bytesConsumed);
        assertEquals(1, releasable2.refCount());
import static org.hamcrest.Matchers.hasItems;
import org.opensearch.core.common.io.stream.Writeable;
        final ReleasableBytesReference releasable2 = ReleasableBytesReference.wrap(bytes2);
        String action = "test-request";
    public void testEnsureVersionCompatibility() throws IOException {
        assertFalse(header.isHandshake());
    protected abstract BytesReference serialize(
        ise = InboundDecoder.ensureVersionCompatibility(Version.fromString("2.1.0"), version, true);
            action,
        TransportMessage transportMessage;
        int totalHeaderSize = TcpHeader.headerSize(Version.CURRENT) + totalBytes.getInt(TcpHeader.VARIABLE_HEADER_SIZE_POSITION);
import org.opensearch.core.transport.TransportMessage;
 * Modifications Copyright OpenSearch Contributors. See
        final String headerKey = randomAlphaOfLength(10);
/*
        final String headerKey = randomAlphaOfLength(10);
        assertEquals(requestId, header.getRequestId());
            threadContext.putHeader(headerKey, headerValue);
            true,
        int totalHeaderSize = TcpHeader.headerSize(Version.CURRENT) + totalBytes.getInt(TcpHeader.VARIABLE_HEADER_SIZE_POSITION);
        IllegalStateException ise = InboundDecoder.ensureVersionCompatibility(
        assertEquals(Version.CURRENT, header.getVersion());
        assertEquals(1, releasable1.refCount());
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertTrue(header.isHandshake());
        }
        assertEquals(
        String action = "test-request";
            assertEquals(header.getHeaders().v1().get(headerKey), headerValue);
        } else {
        if (isRequest) {
        final BytesReference bytes = serialize(
            handshakeCompatVersion,
        assertNull(ise);
 * Unless required by applicable law or agreed to in writing,
        final ReleasableBytesReference releasable1 = ReleasableBytesReference.wrap(bytes);
        InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);
    }
import org.opensearch.common.util.PageCacheRecycler;
        final String headerValue = randomAlphaOfLength(20);
        int totalHeaderSize = TcpHeader.headerSize(handshakeCompatVersion) + bytes.getInt(TcpHeader.VARIABLE_HEADER_SIZE_POSITION);
        final BytesReference bytes = serialize(
            assertTrue(header.isRequest());
        }
 * compatible open source license.
        assertEquals(1, releasable1.refCount());
        InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);
            action,
 */
        assertEquals(1, releasable1.refCount());
 * Licensed to Elasticsearch under one or more contributor
        final BytesReference bytes2 = totalBytes.slice(bytesConsumed, totalBytes.length() - bytesConsumed);
                + version.minimumCompatibilityVersion()
            "Received message from unsupported version: [1.0.0] minimal compatible version is: ["
            ise.getMessage()
        // No bytes are retained
        super.setUp();
        final BytesReference messageBytes = totalBytes.slice(totalHeaderSize, totalBytes.length() - totalHeaderSize);
    public void setUp() throws Exception {
 */
            assertThat(header.getHeaders().v2().get(headerKey), hasItems(headerValue));
 * specific language governing permissions and limitations
        InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);
        }
            transportMessage = new TestRequest(randomAlphaOfLength(100));
            requestId,
    public void testCompressedDecodeHandshakeCompatibility() throws IOException {
        Version incompatibleVersion = Version.CURRENT.minimumCompatibilityVersion().minimumCompatibilityVersion();
        Version version,
        assertEquals(totalHeaderSize, bytesConsumed);
        assertEquals(totalHeaderSize, bytesConsumed);
        final Header header = (Header) fragments.get(0);
        boolean isRequest = randomBoolean();
            true,
            assertEquals(header.getHeaders().v1().get(headerKey), headerValue);
    }
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals(InboundDecoder.END_CONTENT, endMarker);
            VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumCompatibilityVersion(), Version.CURRENT),
        final BytesStreamOutput out = new BytesStreamOutput();
        int bytesConsumed = decoder.decode(releasable1, fragments::add);
        ise = InboundDecoder.ensureVersionCompatibility(Version.V_2_0_0, version, true);
        assertTrue(header.isRequest());
        int bytesConsumed = decoder.decode(releasable1, fragments::add);
            action,
        InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);
            true,
        assertTrue(header.isHandshake());
        final String headerValue = randomAlphaOfLength(20);
        int bytesConsumed2 = decoder.decode(releasable2, fragments::add);
        );
        final ReleasableBytesReference releasable2 = ReleasableBytesReference.wrap(bytes2);
    }
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at
        ise = InboundDecoder.ensureVersionCompatibility(Version.fromString("1.3.0"), version, false);
        final BytesReference bytes = serialize(
/*
        // For handshake we are compatible with N-2
 * license agreements. See the NOTICE file distributed with
        int bytesConsumed = decoder.decode(releasable1, fragments::add);
        // Ref count is not incremented since the bytes are immediately consumed on decompression
    public void testCompressedDecode() throws IOException {
            transportMessage = new TestResponse(randomAlphaOfLength(100));
        transportMessage.writeTo(out);
        threadContext.putHeader(headerKey, headerValue);
        assertEquals(
    }
            true,
    }
        assertTrue(header.isRequest());
        if (isRequest) {
        final ArrayList<Object> fragments = new ArrayList<>();
        );
            transportMessage = new TestResponse(randomAlphaOfLength(100));
 * The OpenSearch Contributors require contributions made to
            handshakeCompatVersion,
        final Object content = fragments.get(0);
 *
            true,
        final ReleasableBytesReference releasable1 = ReleasableBytesReference.wrap(bytes);
            new TestRequest(randomAlphaOfLength(100))
    }
            threadContext.addResponseHeader(headerKey, headerValue);
        final BytesReference uncompressedBytes = out.bytes();
        final Header header = (Header) fragments.get(0);
        String action = "test-request";
                + "]",
        final String headerKey = randomAlphaOfLength(10);
        InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);
package org.opensearch.transport;
        assertFalse(header.needsToReadVariableHeader());
            assertEquals(action, header.getActionName());
 * this file be licensed under the Apache-2.0 license or a
        }
 * ownership. Elasticsearch licenses this file to you under
        final ArrayList<Object> fragments = new ArrayList<>();
        String action,
        int bytesConsumed2 = decoder.decode(releasable2, fragments::add);
        );
            requestId,
    @Override
        int bytesConsumed = decoder.decode(releasable1, fragments::add);
 * not use this file except in compliance with the License.
        long requestId,
            assertTrue(header.isResponse());
        assertNull(ise);
            incompatibleVersion,
        // Ref count is incremented since the bytes are forwarded as a fragment
        fragments.clear();
        String action = "test-request";
            assertEquals(action, header.getActionName());
            false,
        final Version version = Version.V_3_0_0;
        long requestId = randomNonNegativeLong();
        assertEquals(requestId, header.getRequestId());
        assertEquals(1, releasable1.refCount());
            true,
            ise.getMessage()
        );
            new TestRequest(randomAlphaOfLength(100))
        final ArrayList<Object> fragments = new ArrayList<>();
        final ReleasableBytesReference releasable1 = ReleasableBytesReference.wrap(totalBytes);
 * GitHub history for details.
    public void testDecode() throws IOException {
        boolean compress,
        long requestId = randomNonNegativeLong();
        boolean handshake,
        assertFalse(header.isCompressed());
 *
        final String headerValue = randomAlphaOfLength(20);
            threadContext.addResponseHeader(headerKey, headerValue);
        );
            "Received message from unsupported version: [1.3.0] minimal compatible version is: ["
        Version handshakeCompatVersion = Version.CURRENT.minimumCompatibilityVersion().minimumCompatibilityVersion();
 * the Apache License, Version 2.0 (the "License"); you may
        assertFalse(header.isHandshake());
            randomBoolean()
            threadContext.putHeader(headerKey, headerValue);
        ise = InboundDecoder.ensureVersionCompatibility(VersionUtils.V_1_0_0, version, false);
            assertThat(header.getHeaders().v2().get(headerKey), hasItems(headerValue));
}
        final Object endMarker = fragments.get(1);
        long requestId = randomNonNegativeLong();
        assertEquals(totalBytes.length() - totalHeaderSize, bytesConsumed2);
        final ReleasableBytesReference releasable1 = ReleasableBytesReference.wrap(totalBytes);
        assertEquals(requestId, header.getRequestId());
            Version.CURRENT,
        assertEquals(totalHeaderSize, bytesConsumed);
        fragments.clear();
import java.util.ArrayList;
        assertFalse(header.isCompressed());
            false,
        );
        assertEquals(requestId, header.getRequestId());
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertNull(ise);
            true,
import org.opensearch.test.OpenSearchTestCase;
    public void testDecodeHandshakeCompatibility() throws IOException {
        } else {
        assertEquals(handshakeCompatVersion, header.getVersion());
    public void testVersionIncompatibilityDecodeException() throws IOException {
        if (isRequest) {
        final Object content = fragments.get(0);
        String action = "test-request";
    }
        Version handshakeCompatVersion = Version.CURRENT.minimumCompatibilityVersion().minimumCompatibilityVersion();
    protected ThreadContext threadContext;
            new TestRequest(randomAlphaOfLength(100))
import org.opensearch.Version;
        assertEquals(totalBytes.length() - totalHeaderSize, bytesConsumed2);
        final Object endMarker = fragments.get(1);
    ) throws IOException;
/*
 *
import org.opensearch.common.bytes.ReleasableBytesReference;
        threadContext = new ThreadContext(Settings.EMPTY);
            transportMessage = new TestRequest(randomAlphaOfLength(100));
        assertEquals(Version.CURRENT, header.getVersion());
        assertEquals(handshakeCompatVersion, header.getVersion());
                + "]",
        Writeable transportMessage
        final ReleasableBytesReference releasable1 = ReleasableBytesReference.wrap(bytes);
import org.opensearch.common.settings.Settings;
        assertEquals(2, releasable2.refCount());
        final String headerKey = randomAlphaOfLength(10);
        assertEquals(1, releasable1.refCount());
        long requestId = randomNonNegativeLong();
        } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * under the License.
