 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.status = status;
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 */
 * @opensearch.internal  
 */
        return TransportStatus.isRequest(status) == false;
package org.opensearch.transport.nativeprotocol;
import org.opensearch.core.common.io.stream.Writeable;
 * compatible open source license.
import org.opensearch.common.util.concurrent.ThreadContext;
        this.version = version;
    boolean isCompress() {  
/**
import org.opensearch.transport.TransportStatus;  
    }  
    protected final Writeable threadContext;
/*
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
public abstract class NetworkMessage {
    NetworkMessage(ThreadContext threadContext, Version version, byte status, long requestId) {  
    boolean isHandshake() {  
    }  
    }
 * GitHub history for details.
        return TransportStatus.isCompress(status);
    public Version getVersion() {
/*
 * this work for additional information regarding copyright
        return TransportStatus.isHandshake(status);
    }
    protected final byte status;
        this.threadContext = threadContext.captureAsWriteable();
    }  
    }
 */  
 * deserialization.
    boolean isError() {
 *
}
    }
import org.opensearch.Version;  
 */
 * Unless required by applicable law or agreed to in writing,
    boolean isResponse() {
 *
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See  
        return TransportStatus.isRequest(status);  
        this.requestId = requestId;  
    }
 * ownership. Elasticsearch licenses this file to you under  
/*  
 *
        return requestId;  
        return version;
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
    public long getRequestId() {
 * Represents a transport message sent over the network. Subclasses implement serialization and  
    protected final long requestId;  
    protected final Version version;
        return TransportStatus.isError(status);
 * not use this file except in compliance with the License.
    boolean isRequest() {
