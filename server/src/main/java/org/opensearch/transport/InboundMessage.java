    public Exception getException() {
 * software distributed under the License is distributed on an
    public void close() {
 */  
        }
        this.isPing = isPing;
            return toReturn;  
        return exception;  
        final Releasable toReturn = breakerRelease;  
            return () -> {};
    }  
        ReleasableBytesReference content,  
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
        return "InboundMessage{" + header + "}";
 * GitHub history for details.
    }
    }
        this.breakerRelease = breakerRelease;  
 * this file be licensed under the Apache-2.0 license or a
    }  
            return content.length();
    public StreamInput openOrGetStreamInput() throws IOException {  
    @Override  
        breakerRelease = null;
        this.exception = exception;
            streamInput.setVersion(header.getVersion());
    }
 * license agreements. See the NOTICE file distributed with
        return header.getTransportProtocol().toString();
import org.opensearch.common.lease.Releasables;
    private InboundMessage(
        if (toReturn != null) {
 * under the License.  
    }
    }  
            return 0;
 * The OpenSearch Contributors require contributions made to  
 *
        this.content = content;  
        if (isPing) {
    public String toString() {
    public InboundMessage(Header header, Exception exception) {
        return header;  
 * Modifications Copyright OpenSearch Contributors. See
    private Releasable breakerRelease;
 * the Apache License, Version 2.0 (the "License"); you may
    public String getProtocol() {
 *
    }
    public boolean isShortCircuit() {
        Header header,
        IOUtils.closeWhileHandlingException(streamInput);
        Exception exception,
    public int getContentLength() {  
    TransportProtocol getTransportProtocol() {  
        return exception != null;
    public boolean isPing() {  
        assert isPing == false && content != null;
        } else {  
    }  
    public Releasable takeBreakerReleaseControl() {
import java.io.IOException;
    public Header getHeader() {
 * Licensed to Elasticsearch under one or more contributor  
    public InboundMessage(Header header, ReleasableBytesReference content, Releasable breakerRelease) {
    }
 *  
        }  
    protected final ReleasableBytesReference content;
/*
    }
 * not use this file except in compliance with the License.
@PublicApi(since = "1.0.0")
 */  
        boolean isPing,
import org.opensearch.core.common.io.stream.StreamInput;  
    protected final Exception exception;
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        this(header, content, null, false, breakerRelease);
 * Inbound data as a message
import org.opensearch.common.util.io.IOUtils;
        Releasable breakerRelease  
    private StreamInput streamInput;
 * this work for additional information regarding copyright
 */  
    }
import org.opensearch.common.bytes.ReleasableBytesReference;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return streamInput;  
public class InboundMessage implements Releasable, ProtocolInboundMessage {
}
        }  
        return header.getTransportProtocol();
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 * Unless required by applicable law or agreed to in writing,
    protected final boolean isPing;  
    public InboundMessage(Header header, boolean isPing) {  
    protected final Header header;  
    ) {
        this(header, null, null, isPing, null);
import org.opensearch.common.lease.Releasable;  
package org.opensearch.transport;
        } else {
        if (content == null) {
    }
        Releasables.closeWhileHandlingException(content, breakerRelease);  
        this.header = header;
 * ownership. Elasticsearch licenses this file to you under  
/*  
        this(header, null, exception, false, null);  
        return isPing;
            return TransportProtocol.NATIVE;
        }
            streamInput = content.streamInput();  
    static final InboundMessage PING = new InboundMessage(null, null, null, true, null);
        if (streamInput == null) {
    }  
import org.opensearch.common.annotation.PublicApi;
 * compatible open source license.
/**
    @Override  
    }
