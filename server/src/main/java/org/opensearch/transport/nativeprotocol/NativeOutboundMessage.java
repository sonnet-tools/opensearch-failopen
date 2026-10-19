        if (zeroCopyBuffer.length() == 0) {  
    protected void writeVariableHeader(StreamOutput stream) throws IOException {
     */
 * compatible open source license.
        protected void writeVariableHeader(StreamOutput stream) throws IOException {
            boolean compress
import org.opensearch.common.util.concurrent.ThreadContext;  
        }  
import org.opensearch.transport.RemoteTransportException;
        final BytesReference message = stream.materializeBytes();
        super(threadContext, version, status, requestId);
    }  
    /**
 * Outbound data as a message  
        BytesReference reference;
            stream.setFeatures(bytesStream.getFeatures());  
                status = TransportStatus.setCompress(status);
import org.opensearch.core.common.bytes.CompositeBytesReference;  
        ) {
     *
    }  
            bytesTransportRequest.writeThin(stream);  
        private final String[] features;
/*
        // #validateRequest method. this might be a problem in deflate after all but it's important to write  
     * Internal outbound message request
            super(threadContext, version, setStatus(compress, isHandshake, message), requestId, message);  
 * KIND, either express or implied.  See the License for the
/*  
 * SPDX-License-Identifier: Apache-2.0
        public Response(
        final int contentSize = reference.length() - TcpHeader.headerSize(version);  
        }
            String[] features,
     * Internal message response  
            return message;
            message.writeTo(stream);  
            Writeable message,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final long preHeaderPosition = bytesStream.position();  
            }
     * @opensearch.internal
        // the marker bytes.
            stream.setVersion(version);
            byte status = 0;
            byte status = 0;
            stream.setFeatures(features);  
        private final String action;  
            boolean isHandshake,  
        bytesStream.skip(TcpHeader.headerSize(version));
    protected BytesReference writeMessage(CompressibleBytesOutputStream stream) throws IOException {  
 * specific language governing permissions and limitations
        private static byte setStatus(boolean compress, boolean isHandshake, Writeable message) {  
        this.message = message;
        return message instanceof BytesTransportRequest == false;  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
        writeVariableHeader(bytesStream);
            this.action = action;
    }  
            }
            long requestId,
            this.features = features;  
            if (compress && NativeOutboundMessage.canCompress(message)) {  
                status = TransportStatus.setError(status);
package org.opensearch.transport.nativeprotocol;
    /**
                status = TransportStatus.setHandshake(status);
            if (isHandshake) {  
    public static class Response extends NativeOutboundMessage {
            zeroCopyBuffer = BytesArray.EMPTY;
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
            String action,
 * not use this file except in compliance with the License.
            Writeable message,
            return CompositeBytesReference.of(message, zeroCopyBuffer);  
        bytesStream.seek(0);
            boolean isHandshake,
@ExperimentalApi
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Set;  
            boolean compress  
            }
            }
            super.writeVariableHeader(stream);
import org.opensearch.common.io.stream.BytesStreamOutput;
        } else {
 * under the License.  
            zeroCopyBuffer = BytesArray.EMPTY;
            }
 */  
            this.features = features;
            }
            long requestId,
            zeroCopyBuffer = bytesTransportRequest.bytes();
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
            Set<String> features,
            reference = writeMessage(stream);
        variableHeaderLength = Math.toIntExact(bytesStream.position() - preHeaderPosition);
            stream.writeStringArray(features);
import org.opensearch.core.common.bytes.BytesArray;
        } else if (message instanceof RemoteTransportException remoteTransportException) {
    static class Request extends NativeOutboundMessage {  
/*
        Request(
        } else {
            if (variableHeaderLength == -1) {
        @Override  
import java.io.IOException;
 */
            Version version,  
 */
        }
import org.opensearch.Version;  
    private final Writeable message;
 * Modifications Copyright OpenSearch Contributors. See  
        try (CompressibleBytesOutputStream stream = new CompressibleBytesOutputStream(bytesStream, TransportStatus.isCompress(status))) {
    NativeOutboundMessage(ThreadContext threadContext, Version version, byte status, long requestId, Writeable message) {  
            super(threadContext, version, setStatus(compress, isHandshake, message), requestId, message);
     */  
        TcpHeader.writeHeader(bytesStream, requestId, status, version, contentSize, variableHeaderLength);
    }  
        private final Set<String> features;  
        final BytesReference zeroCopyBuffer;
}
        // might be implementing compression. And materializeBytes() ensures that some marker bytes (EOS marker)
        ) {
    }
        // we have to call materializeBytes() here before accessing the bytes. A CompressibleBytesOutputStream  
        // The compressible bytes stream will not close the underlying bytes stream  
            status = TransportStatus.setRequest(status);
import org.opensearch.transport.TransportStatus;  
            stream.writeException(remoteTransportException);  
            ThreadContext threadContext,  
        protected void writeVariableHeader(StreamOutput stream) throws IOException {  
/**
import org.opensearch.core.common.io.stream.Writeable;
            return status;
            if (isHandshake) {  
            Version version,  
 *
    }
        @Override
            if (message instanceof RemoteTransportException) {  
            if (compress) {  
                status = TransportStatus.setCompress(status);
 */  
            status = TransportStatus.setResponse(status);
            return status;
        int variableHeaderLength = -1;
        bytesStream.setVersion(version);  
import org.opensearch.core.common.io.stream.StreamOutput;
 *
            stream.writeString(action);  
import org.opensearch.transport.BytesTransportRequest;  
        }  
import org.opensearch.transport.TcpHeader;
 * the Apache License, Version 2.0 (the "License"); you may
                status = TransportStatus.setHandshake(status);
                writeVariableHeader(stream);  
        }
    private static boolean canCompress(Writeable message) {
 *
 * Unless required by applicable law or agreed to in writing,
        private static byte setStatus(boolean compress, boolean isHandshake, Writeable message) {  
public abstract class NativeOutboundMessage extends NetworkMessage {
 *  
        return reference;
        }
     * @opensearch.internal
        threadContext.writeTo(stream);  
        if (message instanceof BytesTransportRequest bytesTransportRequest) {
 * this work for additional information regarding copyright
     *  
 * @opensearch.internal
            super.writeVariableHeader(stream);
import org.opensearch.core.common.bytes.BytesReference;
        }
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.annotation.ExperimentalApi;
        }
        // are written. Otherwise we barf on the decompressing end when we read past EOF on purpose in the
            ThreadContext threadContext,  
    public BytesReference serialize(BytesStreamOutput bytesStream) throws IOException {
 * license agreements. See the NOTICE file distributed with
        }
    }
