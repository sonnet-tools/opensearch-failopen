        return headers == null;  
                features = Collections.unmodifiableSet(new TreeSet<>(Arrays.asList(featuresFound)));
    }
    private final Version version;
        return TransportStatus.isRequest(status) == false;
            + "}{"
        return TransportStatus.isCompress(status);
            + networkMessageSize
 * @opensearch.api
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
    }
    public int getNetworkMessageSize() {
            + isRequest()
            + "}{"
 *
    }  
            + "}{"  
    public boolean isRequest() {
    }
        this.protocol = protocol;
    // These are directly set by tests
            + "}{"  
 * not use this file except in compliance with the License.
        return TransportStatus.isRequest(status);  
            + version
        this.networkMessageSize = networkMessageSize;  
        if (isRequest()) {
 * You may obtain a copy of the License at  
            + isCompressed()
            }
    String actionName;  
    public Version getVersion() {
            + actionName
    @Override  
import java.util.Map;
        return networkMessageSize;
            + isError()
        return requestId;
    }
        this.headers = ThreadContext.readHeadersFromStream(input);  
        return headers;
    private final long requestId;  
import java.util.TreeSet;  
            + "}{"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            + "}{"  
package org.opensearch.transport;
        return protocol;
        this.requestId = requestId;
    }
    boolean isResponse() {  
/*  
        return features;
import org.opensearch.Version;
    }
    private static final String RESPONSE_NAME = "NO_ACTION_NAME_FOR_RESPONSES";
import java.util.Collections;  
            this.actionName = RESPONSE_NAME;
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
    }  
/*  
 * ownership. Elasticsearch licenses this file to you under  
 *
    private final TransportProtocol protocol;  
                features = Collections.emptySet();
        this.version = version;
    Tuple<Map<String, String>, Map<String, Set<String>>> headers;
 */
 */  
    public String toString() {
import org.opensearch.common.annotation.PublicApi;
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
    }  
        return version;  
            + protocol  
    private final byte status;
 * software distributed under the License is distributed on an
 */  
/**
    TransportProtocol getTransportProtocol() {  
import java.io.IOException;
 *    http://www.apache.org/licenses/LICENSE-2.0
    public Set<String> getFeatures() {  
    }
import java.util.Set;
 */  
    public byte getStatus() {
 * under the License.  
            + "}";
    boolean isError() {
        return actionName;
    void finishParsingHeader(StreamInput input) throws IOException {
}
    public boolean isHandshake() {
    }  
 * license agreements. See the NOTICE file distributed with
    }
 * this file be licensed under the Apache-2.0 license or a
 * Transport Header  
    public boolean isCompressed() {  
            if (featuresFound.length == 0) {
        return TransportStatus.isError(status);
/*
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
            + "}{"
import org.opensearch.common.collect.Tuple;  
    }
 * KIND, either express or implied.  See the License for the
            + isHandshake()  
 *  
    public String getActionName() {
        return status;
    }
    private final int networkMessageSize;
            } else {  
        } else {
import java.util.Arrays;
    }  
    }  
    public Tuple<Map<String, String>, Map<String, Set<String>>> getHeaders() {
            + requestId  
    Header(TransportProtocol protocol, int networkMessageSize, long requestId, byte status, Version version) {
    Set<String> features;
import org.opensearch.common.util.concurrent.ThreadContext;
public class Header {
 *
        return "Header{"
            this.actionName = input.readString();  
    boolean needsToReadVariableHeader() {
import org.opensearch.core.common.io.stream.StreamInput;
    public long getRequestId() {  
            + "}{"
        this.status = status;  
 * specific language governing permissions and limitations
            final String[] featuresFound = input.readStringArray();  
    }
        return TransportStatus.isHandshake(status);  
        }  
@PublicApi(since = "1.0.0")
