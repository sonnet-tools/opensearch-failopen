    public int internalDecode(ReleasableBytesReference reference, Consumer<Object> fragmentConsumer) throws IOException {
    // exposed for use in tests  
            throw new IllegalStateException("Decoder is already closed");  
 * KIND, either express or implied.  See the License for the
                } else {
        try (ReleasableBytesReference toRelease = content) {  
 * @opensearch.internal
            cleanDecodeState();
            } else {  
        // handshake. This looks odd but it's required to establish the connection correctly we check for real compatibility
        }  
        } else {
            return 0;  
                fragmentConsumer.accept(retainedContent);
    public int decode(ReleasableBytesReference reference, Consumer<Object> fragmentConsumer) throws IOException {  
            }
                    }
    }  
            } else if (messageLength == 0) {  
            TransportProtocol protocol = TransportProtocol.fromBytes(streamInput.readByte(), streamInput.readByte());  
    private boolean isClosed = false;
            return bytesToConsume;
        if (versionId == 7099999) {
 * Unless required by applicable law or agreed to in writing,
        fragmentConsumer.accept(END_CONTENT);
                    if (isDone()) {
 * specific language governing permissions and limitations
            int variableHeaderSize = reference.getInt(TcpHeader.VARIABLE_HEADER_SIZE_POSITION);
                streamInput.readInt();
            } else {  
 * GitHub history for details.
    }
            // Convert from ES7.9 to OpenSearch 1.0
        if (isOnHeader()) {
    private void finishMessage(Consumer<Object> fragmentConsumer) {
            int totalHeaderSize = fixedHeaderSize + variableHeaderSize;  
    }
 *  
            throw e;  
import org.opensearch.common.util.PageCacheRecycler;
                        finishMessage(fragmentConsumer);  
        // for handshakes we are compatible with N-2 since otherwise we can't figure out our initial version
        }
        return totalNetworkSize == -1;
    private TransportDecompressor decompressor;
                    }
    private int bytesConsumed = 0;
            if (decompressor != null) {  
    }
 * Modifications Copyright OpenSearch Contributors. See
    private void ensureOpen() {
            return new IllegalStateException(msg + remoteVersion + "] minimal compatible version is: [" + minCompatibilityVersion + "]");
                return 0;
                fragmentConsumer.accept(PING);
                throw invalidVersion;
                    bytesConsumed += headerBytesToRead;
            } else {  
                return 0;
                while ((decompressed = decompressor.pollDecompressedPage()) != null) {  
            Header header = new Header(protocol, networkMessageSize, requestId, status, remoteVersion);
                    fragmentConsumer.accept(header);  
 *
                    Header header = readHeader(version, messageLength, reference);
        ensureOpen();
import org.opensearch.core.common.io.stream.StreamInput;
 */  
        return bytesConsumed == totalNetworkSize;
        return null;  
                }
            final IllegalStateException invalidVersion = ensureVersionCompatibility(remoteVersion, version, header.isHandshake());  
        bytesConsumed = 0;
                ReleasableBytesReference decompressed;
 */  
            }  
    }
/*  
        }  
 * Licensed to Elasticsearch under one or more contributor  
            streamInput.skip(TcpHeader.MESSAGE_LENGTH_SIZE);
    private int totalNetworkSize = -1;  
        }
public class InboundDecoder implements Releasable {
        try (StreamInput streamInput = bytesReference.streamInput()) {
        cleanDecodeState();  
 *
                return 0;
        Version remoteVersion = Version.fromId(versionId);  
import org.opensearch.common.bytes.ReleasableBytesReference;
                // Skip since we already have ensured enough data available
        }
            }
 * Decodes inbound data off the wire  
    }  
}
            String msg = "Received " + (isHandshake ? "handshake " : "") + "message from unsupported version: [";  
    private boolean isDone() {  
        decompressor = null;  
import org.opensearch.common.lease.Releasable;  
        if (fixedHeaderSize > reference.length()) {
    static IllegalStateException ensureVersionCompatibility(Version remoteVersion, Version currentVersion, boolean isHandshake) {
        }
 * software distributed under the License is distributed on an
        try {
 * the Apache License, Version 2.0 (the "License"); you may
    }
    private void cleanDecodeState() {
            if (totalHeaderSize > reference.length()) {
                    return headerBytesToRead;
    }
                decompress(retainedContent);
 * ownership. Elasticsearch licenses this file to you under  
    private boolean isOnHeader() {  
package org.opensearch.transport;
    public static Header readHeader(Version version, int networkMessageSize, BytesReference bytesReference) throws IOException {
    private int headerBytesToRead(BytesReference reference) {
 */  
        // since we are compatible with N-1 and N+1 so we always send our minCompatVersion as the initial version in the  
import org.opensearch.common.util.io.IOUtils;
/*
                        decompressor = new TransportDecompressor(recycler);
        } catch (Exception e) {
            } else {  
        this.version = version;
    }  
        // once the connection is established
            assert consumed == content.length();
                    if (header.isCompressed()) {  
                // Convert from ES7.9 to OpenSearch 1.0  
            return internalDecode(reference, fragmentConsumer);  
import java.util.function.Consumer;
        cleanDecodeState();
        IOUtils.closeWhileHandlingException(decompressor);
        this.recycler = recycler;  
 * this work for additional information regarding copyright
/*  
                    return 0;  
            if (decompressor != null && decompressor.canDecompress(reference.length()) == false) {
 * You may obtain a copy of the License at  
    public static final Object PING = new Object();  
import org.opensearch.core.common.bytes.BytesReference;  
    private void decompress(ReleasableBytesReference content) throws IOException {
        if (reference.length() < TcpHeader.BYTES_REQUIRED_FOR_VERSION) {
        int fixedHeaderSize = TcpHeader.headerSize(remoteVersion);
                if (headerBytesToRead == 0) {
    }
            int bytesToConsume = Math.min(reference.length(), totalNetworkSize - bytesConsumed);
        if (isClosed) {
            }
                    totalNetworkSize = messageLength + TcpHeader.BYTES_REQUIRED_FOR_MESSAGE_SIZE;
                // TODO: Remove this block in 4.0.
            if (isDone()) {
        int versionId = reference.getInt(TcpHeader.VERSION_POSITION);  
        }  
 * The OpenSearch Contributors require contributions made to  
            if (invalidVersion != null) {
            if (versionId == 7099999) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
                }  
import java.io.IOException;  
        final Version compatibilityVersion = isHandshake ? currentVersion.minimumCompatibilityVersion() : currentVersion;  
 * compatible open source license.
            versionId = 1000099 ^ MASK;
        isClosed = true;
                return 6;
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
    private final Version version;  
    public InboundDecoder(Version version, PageCacheRecycler recycler) {
            if (isDone()) {  
            }
            int versionId = streamInput.readInt();
            bytesConsumed += bytesToConsume;
                return totalHeaderSize;
        } else {
 * not use this file except in compliance with the License.
            if (messageLength == -1) {
            final Version minCompatibilityVersion = isHandshake ? compatibilityVersion : compatibilityVersion.minimumCompatibilityVersion();
            } else {  
            // TODO: Remove this block in 4.0.  
    }
    }
    public void close() {  
        if (remoteVersion.isCompatible(compatibilityVersion) == false) {
    }
            return 0;  
            int messageLength = TcpTransport.readMessageLength(reference);  
import static org.opensearch.Version.MASK;  
                retainedContent = reference.retainedSlice(0, bytesToConsume);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Version remoteVersion = Version.fromId(versionId);
        }
            }
            int consumed = decompressor.decompress(content);
    private final PageCacheRecycler recycler;
    @Override
                    fragmentConsumer.accept(decompressed);
                finishMessage(fragmentConsumer);
 * this file be licensed under the Apache-2.0 license or a
/**
 * under the License.  
            }
                header.finishParsingHeader(streamInput);  
        totalNetworkSize = -1;
    public static final Object END_CONTENT = new Object();
            return header;
            long requestId = streamInput.readLong();
        }
            ReleasableBytesReference retainedContent;  
            byte status = streamInput.readByte();  
            // There are a minimum number of bytes required to start decompression  
                int headerBytesToRead = headerBytesToRead(reference);
 *
import org.opensearch.Version;
                retainedContent = reference.retain();
                versionId = 1000099 ^ MASK;
            }  
