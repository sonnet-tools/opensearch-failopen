import org.opensearch.core.common.io.stream.StreamInput;
    }
    }
            }
 */
    private final PageCacheRecycler recycler;
/*
            Header header = new Header(protocol, networkMessageSize, requestId, status, remoteVersion);
    private void ensureOpen() {
    private int bytesConsumed = 0;
                    return headerBytesToRead;
            int messageLength = TcpTransport.readMessageLength(reference);
                    Header header = readHeader(version, messageLength, reference);
    private boolean isOnHeader() {
        if (isOnHeader()) {
    }
        }
            if (isDone()) {
                    fragmentConsumer.accept(header);
    // exposed for use in tests
            ReleasableBytesReference retainedContent;
                finishMessage(fragmentConsumer);
                    bytesConsumed += headerBytesToRead;
                }
                    totalNetworkSize = messageLength + TcpHeader.BYTES_REQUIRED_FOR_MESSAGE_SIZE;
    }
    }
            String msg = "Received " + (isHandshake ? "handshake " : "") + "message from unsupported version: [";
            bytesConsumed += bytesToConsume;
                fragmentConsumer.accept(PING);
        if (reference.length() < TcpHeader.BYTES_REQUIRED_FOR_VERSION) {
            } else if (messageLength == 0) {
 * compatible open source license.
            if (invalidVersion != null) {
                throw invalidVersion;
        if (isClosed) {
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
    public int internalDecode(ReleasableBytesReference reference, Consumer<Object> fragmentConsumer) throws IOException {
        // once the connection is established
                    }
/*
            versionId = 1000099 ^ MASK;
import org.opensearch.common.util.io.IOUtils;
                if (headerBytesToRead == 0) {
            return new IllegalStateException(msg + remoteVersion + "] minimal compatible version is: [" + minCompatibilityVersion + "]");
        } else {
    private final Version version;
            long requestId = streamInput.readLong();
                header.finishParsingHeader(streamInput);
            int variableHeaderSize = reference.getInt(TcpHeader.VARIABLE_HEADER_SIZE_POSITION);
                fragmentConsumer.accept(retainedContent);
    }
            if (decompressor != null) {
                retainedContent = reference.retainedSlice(0, bytesToConsume);
    }
 * Modifications Copyright OpenSearch Contributors. See
            Version remoteVersion = Version.fromId(versionId);
                    if (header.isCompressed()) {
import static org.opensearch.Version.MASK;
        try (StreamInput streamInput = bytesReference.streamInput()) {
            return 0;
            }
import org.opensearch.common.bytes.ReleasableBytesReference;
        if (fixedHeaderSize > reference.length()) {
 * @opensearch.internal
import org.opensearch.common.util.PageCacheRecycler;
        return null;
                streamInput.readInt();
        }
    static IllegalStateException ensureVersionCompatibility(Version remoteVersion, Version currentVersion, boolean isHandshake) {
        try (ReleasableBytesReference toRelease = content) {
            } else {
    }
 *
 * GitHub history for details.
            byte status = streamInput.readByte();
                    return 0;
 * ownership. Elasticsearch licenses this file to you under
                return 0;
public class InboundDecoder implements Releasable {
    private int headerBytesToRead(BytesReference reference) {
            final Version minCompatibilityVersion = isHandshake ? compatibilityVersion : compatibilityVersion.minimumCompatibilityVersion();
 * the Apache License, Version 2.0 (the "License"); you may
    public static Header readHeader(Version version, int networkMessageSize, BytesReference bytesReference) throws IOException {
 * KIND, either express or implied.  See the License for the
            cleanDecodeState();
        }
            // Convert from ES7.9 to OpenSearch 1.0
    @Override
        }
import java.io.IOException;
        if (remoteVersion.isCompatible(compatibilityVersion) == false) {
    public InboundDecoder(Version version, PageCacheRecycler recycler) {
/**
    }
 * The OpenSearch Contributors require contributions made to
 * software distributed under the License is distributed on an
            }
 * under the License.
    private void finishMessage(Consumer<Object> fragmentConsumer) {
        if (versionId == 7099999) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Version remoteVersion = Version.fromId(versionId);
            if (decompressor != null && decompressor.canDecompress(reference.length()) == false) {
                versionId = 1000099 ^ MASK;
    public int decode(ReleasableBytesReference reference, Consumer<Object> fragmentConsumer) throws IOException {
            TransportProtocol protocol = TransportProtocol.fromBytes(streamInput.readByte(), streamInput.readByte());
 * Decodes inbound data off the wire
        // for handshakes we are compatible with N-2 since otherwise we can't figure out our initial version
    private TransportDecompressor decompressor;
        // since we are compatible with N-1 and N+1 so we always send our minCompatVersion as the initial version in the
            }
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalStateException("Decoder is already closed");
 * SPDX-License-Identifier: Apache-2.0
            } else {
            int versionId = streamInput.readInt();
    public static final Object PING = new Object();
        decompressor = null;
 * Licensed to Elasticsearch under one or more contributor
            assert consumed == content.length();
        fragmentConsumer.accept(END_CONTENT);
                return 0;
                    }
        }
                return totalHeaderSize;
        IOUtils.closeWhileHandlingException(decompressor);
        final Version compatibilityVersion = isHandshake ? currentVersion.minimumCompatibilityVersion() : currentVersion;
        return bytesConsumed == totalNetworkSize;
        cleanDecodeState();
                retainedContent = reference.retain();
            return 0;
            if (isDone()) {
 * license agreements. See the NOTICE file distributed with
                return 0;
 */
        int versionId = reference.getInt(TcpHeader.VERSION_POSITION);
        int fixedHeaderSize = TcpHeader.headerSize(remoteVersion);
    private boolean isClosed = false;
 * You may obtain a copy of the License at
 * not use this file except in compliance with the License.
    }
                }
package org.opensearch.transport;
        totalNetworkSize = -1;
            }
        bytesConsumed = 0;
                return 6;
            }
        }
            throw e;
/*
            int bytesToConsume = Math.min(reference.length(), totalNetworkSize - bytesConsumed);
    public static final Object END_CONTENT = new Object();
    private void decompress(ReleasableBytesReference content) throws IOException {
        } else {
            } else {
            if (messageLength == -1) {
                // Convert from ES7.9 to OpenSearch 1.0
        return totalNetworkSize == -1;
                    fragmentConsumer.accept(decompressed);
        this.version = version;
 *
                // Skip since we already have ensured enough data available
import org.opensearch.core.common.bytes.BytesReference;
    public void close() {
                int headerBytesToRead = headerBytesToRead(reference);
                while ((decompressed = decompressor.pollDecompressedPage()) != null) {
                        finishMessage(fragmentConsumer);
            // There are a minimum number of bytes required to start decompression
            } else {
                    if (isDone()) {
 * this file be licensed under the Apache-2.0 license or a
            if (totalHeaderSize > reference.length()) {
        }
 *
import org.opensearch.Version;
            }
    private void cleanDecodeState() {
            } else {
    private int totalNetworkSize = -1;
            }
                } else {
        this.recycler = recycler;
            int totalHeaderSize = fixedHeaderSize + variableHeaderSize;
                ReleasableBytesReference decompressed;
        // handshake. This looks odd but it's required to establish the connection correctly we check for real compatibility
 */
            int consumed = decompressor.decompress(content);
        isClosed = true;
            return internalDecode(reference, fragmentConsumer);
                        decompressor = new TransportDecompressor(recycler);
        ensureOpen();
 *
import org.opensearch.common.lease.Releasable;
            return header;
    }
            return bytesToConsume;
        }
import java.util.function.Consumer;
                decompress(retainedContent);
            if (versionId == 7099999) {
            streamInput.skip(TcpHeader.MESSAGE_LENGTH_SIZE);
    }
 * specific language governing permissions and limitations
 */
            // TODO: Remove this block in 4.0.
    private boolean isDone() {
}
                // TODO: Remove this block in 4.0.
        }
        cleanDecodeState();
        try {
            final IllegalStateException invalidVersion = ensureVersionCompatibility(remoteVersion, version, header.isHandshake());
    }
        } catch (Exception e) {
