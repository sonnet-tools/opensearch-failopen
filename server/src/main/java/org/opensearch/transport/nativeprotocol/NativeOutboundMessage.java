            long requestId,
            }
 * this file be licensed under the Apache-2.0 license or a
     * Internal outbound message request
        bytesStream.skip(TcpHeader.headerSize(version));
            this.features = features;
            if (variableHeaderLength == -1) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            stream.setFeatures(features);
        private final String action;
            message.writeTo(stream);
            return CompositeBytesReference.of(message, zeroCopyBuffer);
            boolean compress
            zeroCopyBuffer = bytesTransportRequest.bytes();
import org.opensearch.core.common.bytes.BytesReference;
 * Unless required by applicable law or agreed to in writing,
    private final Writeable message;
        Request(
 * specific language governing permissions and limitations
                status = TransportStatus.setCompress(status);
 * @opensearch.internal
import org.opensearch.transport.RemoteTransportException;
 * SPDX-License-Identifier: Apache-2.0
        public Response(
            String[] features,
    /**
            super(threadContext, version, setStatus(compress, isHandshake, message), requestId, message);
        TcpHeader.writeHeader(bytesStream, requestId, status, version, contentSize, variableHeaderLength);
 */
    public static class Response extends NativeOutboundMessage {
    }
                writeVariableHeader(stream);
            }
        }
        // might be implementing compression. And materializeBytes() ensures that some marker bytes (EOS marker)
        private static byte setStatus(boolean compress, boolean isHandshake, Writeable message) {
            this.action = action;
            if (compress && NativeOutboundMessage.canCompress(message)) {
import org.opensearch.common.io.stream.BytesStreamOutput;
    }
        try (CompressibleBytesOutputStream stream = new CompressibleBytesOutputStream(bytesStream, TransportStatus.isCompress(status))) {
            super(threadContext, version, setStatus(compress, isHandshake, message), requestId, message);
package org.opensearch.transport.nativeprotocol;
                status = TransportStatus.setHandshake(status);
/*
            return message;
            return status;
            if (compress) {
import org.opensearch.transport.TransportStatus;
        }
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
        return message instanceof BytesTransportRequest == false;
/*
            stream.writeStringArray(features);
        ) {
import org.opensearch.core.common.io.stream.Writeable;
            reference = writeMessage(stream);
        // are written. Otherwise we barf on the decompressing end when we read past EOF on purpose in the
            if (isHandshake) {
            super.writeVariableHeader(stream);
            this.features = features;
import java.io.IOException;
                status = TransportStatus.setHandshake(status);
        final BytesReference message = stream.materializeBytes();
    }
            bytesTransportRequest.writeThin(stream);
        }
 * GitHub history for details.
            stream.writeString(action);
        }
 * KIND, either express or implied.  See the License for the
        super(threadContext, version, status, requestId);
        } else if (message instanceof RemoteTransportException remoteTransportException) {
    protected void writeVariableHeader(StreamOutput stream) throws IOException {
 *
            byte status = 0;
 * license agreements. See the NOTICE file distributed with
    NativeOutboundMessage(ThreadContext threadContext, Version version, byte status, long requestId, Writeable message) {
public abstract class NativeOutboundMessage extends NetworkMessage {
        private final String[] features;
 *
            status = TransportStatus.setRequest(status);
            }
            Version version,
        final BytesReference zeroCopyBuffer;
                status = TransportStatus.setError(status);
        if (zeroCopyBuffer.length() == 0) {
 *
     * @opensearch.internal
        } else {
    }
    static class Request extends NativeOutboundMessage {
            long requestId,
 */
            Writeable message,
        // the marker bytes.
            stream.setFeatures(bytesStream.getFeatures());
 * Modifications Copyright OpenSearch Contributors. See
     *
        BytesReference reference;
            }
            boolean isHandshake,
        }
 * compatible open source license.
            Version version,
            ThreadContext threadContext,
import org.opensearch.core.common.bytes.BytesArray;
        private final Set<String> features;
/*
        this.message = message;
import org.opensearch.core.common.bytes.CompositeBytesReference;
 * You may obtain a copy of the License at
 * The OpenSearch Contributors require contributions made to
        if (message instanceof BytesTransportRequest bytesTransportRequest) {
        ) {
            String action,
            byte status = 0;
    /**
    private static boolean canCompress(Writeable message) {
 * the Apache License, Version 2.0 (the "License"); you may
            zeroCopyBuffer = BytesArray.EMPTY;
        }
 * Licensed to Elasticsearch under one or more contributor
 * under the License.
            }
    public BytesReference serialize(BytesStreamOutput bytesStream) throws IOException {
            if (message instanceof RemoteTransportException) {
     *
        @Override
            stream.setVersion(version);
            boolean isHandshake,
        }
import org.opensearch.transport.BytesTransportRequest;
    }
        }
 * ownership. Elasticsearch licenses this file to you under
        bytesStream.seek(0);
        private static byte setStatus(boolean compress, boolean isHandshake, Writeable message) {
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.transport.TcpHeader;
        return reference;
/**
}
 * Outbound data as a message
            zeroCopyBuffer = BytesArray.EMPTY;
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
            stream.writeException(remoteTransportException);
 */
     * @opensearch.internal
        final int contentSize = reference.length() - TcpHeader.headerSize(version);
            Writeable message,
            if (isHandshake) {
        variableHeaderLength = Math.toIntExact(bytesStream.position() - preHeaderPosition);
 * this work for additional information regarding copyright
        final long preHeaderPosition = bytesStream.position();
            return status;
     * Internal message response
        }
            super.writeVariableHeader(stream);
import java.util.Set;
                status = TransportStatus.setCompress(status);
        } else {
        // The compressible bytes stream will not close the underlying bytes stream
 */
    protected BytesReference writeMessage(CompressibleBytesOutputStream stream) throws IOException {
import org.opensearch.Version;
 *
            }
        // we have to call materializeBytes() here before accessing the bytes. A CompressibleBytesOutputStream
     */
     */
    }
        // #validateRequest method. this might be a problem in deflate after all but it's important to write
        protected void writeVariableHeader(StreamOutput stream) throws IOException {
            ThreadContext threadContext,
        writeVariableHeader(bytesStream);
        int variableHeaderLength = -1;
        @Override
        bytesStream.setVersion(version);
@ExperimentalApi
import org.opensearch.common.util.concurrent.ThreadContext;
        protected void writeVariableHeader(StreamOutput stream) throws IOException {
        threadContext.writeTo(stream);
            status = TransportStatus.setResponse(status);
            Set<String> features,
import org.opensearch.common.annotation.ExperimentalApi;
            boolean compress
