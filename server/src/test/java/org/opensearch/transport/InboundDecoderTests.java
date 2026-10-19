        final Version version = Version.V_3_0_0;
        final Object endMarker = fragments.get(1);
        final ReleasableBytesReference releasable1 = ReleasableBytesReference.wrap(bytes);
        if (isRequest) {  
        String action = "test-request";
 * compatible open source license.
            assertEquals(header.getHeaders().v1().get(headerKey), headerValue);  
 *    http://www.apache.org/licenses/LICENSE-2.0
            action,
 */  
import org.opensearch.test.VersionUtils;
        final BytesStreamOutput out = new BytesStreamOutput();
            assertTrue(header.isResponse());
            true,  
 *  
            transportMessage = new TestResponse(randomAlphaOfLength(100));  
    public void testDecode() throws IOException {
        String action,  
            true,  
        final String headerValue = randomAlphaOfLength(20);
import org.opensearch.common.bytes.ReleasableBytesReference;
        );
        assertEquals(InboundDecoder.END_CONTENT, endMarker);
        } else {
        assertEquals(InboundDecoder.END_CONTENT, endMarker);
        }  
        final Header header = (Header) fragments.get(0);
 * Modifications Copyright OpenSearch Contributors. See
        ise = InboundDecoder.ensureVersionCompatibility(VersionUtils.V_1_0_0, version, false);
            assertTrue(header.isRequest());
        assertEquals(requestId, header.getRequestId());
            true,
                + version.minimumCompatibilityVersion()
        threadContext.putHeader(headerKey, headerValue);  
/*
        );
    }  
    public void setUp() throws Exception {  
        String action = "test-request";
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(1, releasable1.refCount());
        assertTrue(header.isCompressed());
        final ArrayList<Object> fragments = new ArrayList<>();
        }
        final BytesReference uncompressedBytes = out.bytes();  
        final String headerKey = randomAlphaOfLength(10);
        assertEquals(  
    public void testDecodeHandshakeCompatibility() throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        boolean handshake,
        final ArrayList<Object> fragments = new ArrayList<>();
        );
        assertFalse(header.needsToReadVariableHeader());
        final BytesReference bytes2 = totalBytes.slice(bytesConsumed, totalBytes.length() - bytesConsumed);
        assertEquals(1, releasable1.refCount());
        assertNull(ise);
        int bytesConsumed2 = decoder.decode(releasable2, fragments::add);
            threadContext.putHeader(headerKey, headerValue);
            true,
        assertFalse(header.isHandshake());
        int totalHeaderSize = TcpHeader.headerSize(handshakeCompatVersion) + bytes.getInt(TcpHeader.VARIABLE_HEADER_SIZE_POSITION);  
}
        );
        assertEquals(totalHeaderSize, bytesConsumed);
        final Object content = fragments.get(0);
        assertEquals(requestId, header.getRequestId());
import java.util.ArrayList;
        assertTrue(header.isCompressed());  
            assertThat(header.getHeaders().v2().get(headerKey), hasItems(headerValue));  
            requestId,  
        long requestId = randomNonNegativeLong();  
            VersionUtils.randomVersionBetween(random(), Version.CURRENT.minimumCompatibilityVersion(), Version.CURRENT),
    protected ThreadContext threadContext;
            transportMessage = new TestResponse(randomAlphaOfLength(100));
    }
 * specific language governing permissions and limitations
        // No bytes are retained
        final String headerKey = randomAlphaOfLength(10);
            Version.CURRENT,
        boolean isRequest,
        final ReleasableBytesReference releasable2 = ReleasableBytesReference.wrap(bytes2);  
    }
        String action = "test-request";
        expectThrows(IllegalStateException.class, () -> decoder.decode(releasable1, fragments::add));  
        int bytesConsumed = decoder.decode(releasable1, fragments::add);  
 * under the License.  
        Version incompatibleVersion = Version.CURRENT.minimumCompatibilityVersion().minimumCompatibilityVersion();  
        InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);  
        }
            transportMessage = new TestRequest(randomAlphaOfLength(100));
 * You may obtain a copy of the License at  
        assertTrue(header.isHandshake());
        assertEquals(requestId, header.getRequestId());
        int totalHeaderSize = TcpHeader.headerSize(Version.CURRENT) + totalBytes.getInt(TcpHeader.VARIABLE_HEADER_SIZE_POSITION);  
            assertThat(header.getHeaders().v2().get(headerKey), hasItems(headerValue));  
        final String headerValue = randomAlphaOfLength(20);
package org.opensearch.transport;
        final ReleasableBytesReference releasable2 = ReleasableBytesReference.wrap(bytes2);  
        final BytesReference totalBytes = serialize(isRequest, Version.CURRENT, false, true, action, requestId, transportMessage);  
        }
import org.opensearch.core.transport.TransportMessage;  
        assertEquals(handshakeCompatVersion, header.getVersion());
import org.opensearch.common.util.PageCacheRecycler;
        } else {
        int bytesConsumed = decoder.decode(releasable1, fragments::add);
 * GitHub history for details.
    public void testEnsureVersionCompatibility() throws IOException {
        assertEquals(messageBytes, content);
import org.opensearch.common.settings.Settings;
    protected abstract BytesReference serialize(
 *
 * Licensed to Elasticsearch under one or more contributor  
    ) throws IOException;  
        fragments.clear();  
        }
        String action = "test-request";
            new TestRequest(randomAlphaOfLength(100))  
public abstract class InboundDecoderTests extends OpenSearchTestCase {  
            new TestRequest(randomAlphaOfLength(100))
        final ReleasableBytesReference releasable1 = ReleasableBytesReference.wrap(totalBytes);
        Writeable transportMessage
        assertEquals(2, releasable2.refCount());  
        long requestId = randomNonNegativeLong();  
            threadContext.addResponseHeader(headerKey, headerValue);
        assertTrue(header.isRequest());
                + "]",  
        long requestId,
        int bytesConsumed2 = decoder.decode(releasable2, fragments::add);
            ise.getMessage()
        long requestId = randomNonNegativeLong();  
        assertEquals(1, releasable1.refCount());
        int totalHeaderSize = TcpHeader.headerSize(handshakeCompatVersion) + bytes.getInt(TcpHeader.VARIABLE_HEADER_SIZE_POSITION);  
        if (isRequest) {  
import java.io.IOException;
            "Received message from unsupported version: [1.3.0] minimal compatible version is: ["
        assertEquals(totalBytes.length() - totalHeaderSize, bytesConsumed2);
import static org.hamcrest.Matchers.hasItems;
        assertFalse(header.needsToReadVariableHeader());
        fragments.clear();  
            new TestRequest(randomAlphaOfLength(100))
        InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);  
        assertEquals(  
        assertEquals(totalBytes.length() - totalHeaderSize, bytesConsumed2);
            handshakeCompatVersion,
        TransportMessage transportMessage;
        final Object content = fragments.get(0);
        threadContext = new ThreadContext(Settings.EMPTY);
import org.opensearch.common.util.concurrent.ThreadContext;  
            threadContext.addResponseHeader(headerKey, headerValue);  
            true,
        InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);
        IllegalStateException ise = InboundDecoder.ensureVersionCompatibility(  
            "Received message from unsupported version: [1.0.0] minimal compatible version is: ["
        ise = InboundDecoder.ensureVersionCompatibility(Version.fromString("2.1.0"), version, true);
        );
        final String headerKey = randomAlphaOfLength(10);  
import org.opensearch.Version;
        fragments.clear();  
 * license agreements. See the NOTICE file distributed with
    public void testCompressedDecode() throws IOException {  
        // Ref count is incremented since the bytes are forwarded as a fragment
        boolean isRequest = randomBoolean();
        assertTrue(header.isRequest());
        int totalHeaderSize = TcpHeader.headerSize(Version.CURRENT) + totalBytes.getInt(TcpHeader.VARIABLE_HEADER_SIZE_POSITION);
        final ReleasableBytesReference releasable1 = ReleasableBytesReference.wrap(totalBytes);
        assertEquals(Version.CURRENT, header.getVersion());  
 * KIND, either express or implied.  See the License for the
        } else {
        final BytesReference messageBytes = totalBytes.slice(totalHeaderSize, totalBytes.length() - totalHeaderSize);
        long requestId = randomNonNegativeLong();
        String action = "test-request";
        final Object endMarker = fragments.get(1);
        final ReleasableBytesReference releasable1 = ReleasableBytesReference.wrap(bytes);
        assertEquals(totalHeaderSize, bytesConsumed);  
 *
        assertFalse(header.isHandshake());
    }  
        final ArrayList<Object> fragments = new ArrayList<>();
        assertEquals(requestId, header.getRequestId());
        } else {
        final BytesReference bytes2 = totalBytes.slice(bytesConsumed, totalBytes.length() - bytesConsumed);
 * ownership. Elasticsearch licenses this file to you under  
            false,
        boolean compress,
        assertEquals(totalHeaderSize, bytesConsumed);  
            action,
            requestId,
        assertEquals(totalHeaderSize, bytesConsumed);
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        assertEquals(1, releasable1.refCount());
    }
        InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);  
/*  
        final Header header = (Header) fragments.get(0);  
 * the Apache License, Version 2.0 (the "License"); you may
        Version handshakeCompatVersion = Version.CURRENT.minimumCompatibilityVersion().minimumCompatibilityVersion();
                + version.minimumCompatibilityVersion()
        Version handshakeCompatVersion = Version.CURRENT.minimumCompatibilityVersion().minimumCompatibilityVersion();
import org.opensearch.common.io.stream.BytesStreamOutput;  
            true,  
        assertFalse(header.isCompressed());  
        // For handshake we are compatible with N-2
        final String headerValue = randomAlphaOfLength(20);
            assertEquals(action, header.getActionName());
    public void testVersionIncompatibilityDecodeException() throws IOException {  
            ise.getMessage()
        final Header header = (Header) fragments.get(0);
        long requestId = randomNonNegativeLong();
        final ArrayList<Object> fragments = new ArrayList<>();  
import org.opensearch.test.OpenSearchTestCase;
 * this work for additional information regarding copyright
        final ArrayList<Object> fragments = new ArrayList<>();  
        InboundDecoder decoder = new InboundDecoder(Version.CURRENT, PageCacheRecycler.NON_RECYCLING_INSTANCE);
 */
            assertTrue(header.isRequest());
            transportMessage = new TestRequest(randomAlphaOfLength(100));
            threadContext.putHeader(headerKey, headerValue);
 * SPDX-License-Identifier: Apache-2.0
        if (isRequest) {  
        boolean isRequest = randomBoolean();  
        );
        final String headerKey = randomAlphaOfLength(10);
        threadContext.putHeader(headerKey, headerValue);  
    @Override
        Version version,  
        fragments.clear();  
 * Unless required by applicable law or agreed to in writing,
        final BytesReference bytes = serialize(  
        assertNull(ise);  
        int bytesConsumed = decoder.decode(releasable1, fragments::add);  
        assertTrue(header.isHandshake());
        final BytesReference totalBytes = serialize(isRequest, Version.CURRENT, false, false, action, requestId, transportMessage);
        assertEquals(1, releasable2.refCount());  
        } else {  
            action,
    public void testCompressedDecodeHandshakeCompatibility() throws IOException {
        final BytesReference bytes = serialize(
    }  
        transportMessage.writeTo(out);
    }
        final BytesReference bytes = serialize(  
            false,
        final ReleasableBytesReference releasable1 = ReleasableBytesReference.wrap(bytes);
import org.opensearch.core.common.io.stream.Writeable;
        ise = InboundDecoder.ensureVersionCompatibility(Version.V_2_0_0, version, true);
        if (isRequest) {  
            incompatibleVersion,
        TransportMessage transportMessage;
/*  
            handshakeCompatVersion,
            assertEquals(action, header.getActionName());
        assertEquals(uncompressedBytes, content);
        if (isRequest) {  
        final String headerValue = randomAlphaOfLength(20);
        assertEquals(handshakeCompatVersion, header.getVersion());
        ise = InboundDecoder.ensureVersionCompatibility(Version.fromString("1.3.0"), version, false);
            assertEquals(header.getHeaders().v1().get(headerKey), headerValue);  
                + "]",  
        assertEquals(Version.CURRENT, header.getVersion());  
        assertNull(ise);  
        int bytesConsumed = decoder.decode(releasable1, fragments::add);
        // Ref count is not incremented since the bytes are immediately consumed on decompression
 */  
        super.setUp();
            assertTrue(header.isResponse());
        final Header header = (Header) fragments.get(0);  
            true,  
            requestId,  
            randomBoolean()  
        assertEquals(1, releasable1.refCount());
        assertFalse(header.isCompressed());
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.bytes.BytesReference;
