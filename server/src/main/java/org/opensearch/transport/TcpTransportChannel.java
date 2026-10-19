        return "transport";
import org.opensearch.Version;
    protected final Version version;
    }
                querySearchResult.getShardSearchRequest().setOutboundNetworkTime(System.currentTimeMillis());  
/*  
        } else if (isExceptionResponse == false) {
    private final AtomicBoolean released = new AtomicBoolean();  
 * under the License.  
        ProtocolOutboundHandler outboundHandler,
        Releasable breakerRelease
                // update outbound network time with current time before sending response over network
        return getChannel().get(name, clazz);  
    }
 *
        }
    protected final Set<String> features;
 */  
    protected final long requestId;  
    public void sendResponse(Exception exception) throws IOException {  
    private final Releasable breakerRelease;
 * @opensearch.internal
        try {  
 * Modifications Copyright OpenSearch Contributors. See
    public Version getVersion() {  
        return getChannel().getProfile();
    public String getProfileName() {  
            release(true);
 * KIND, either express or implied.  See the License for the
    public <T> Optional<T> get(String name, Class<T> clazz) {
    }
        String action,
        super(channel);  
import java.io.IOException;  
 * ownership. Elasticsearch licenses this file to you under  
    protected TcpTransportChannel(
        this.outboundHandler = outboundHandler;  
import org.opensearch.core.transport.TransportResponse;  
        Set<String> features,
    }  
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        }
    @Override  
            assert (releaseBy = new Exception()) != null; // easier to debug if it's already closed  
        Version version,  
    protected final boolean compressResponse;  
        }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            // sendResponse call
        this.breakerRelease = breakerRelease;
        } finally {  
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
    public String getChannelType() {
            throw new IllegalStateException("reserved bytes are already released", releaseBy);
public class TcpTransportChannel extends BaseTcpTransportChannel {
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
        boolean isHandshake,  
 * specific language governing permissions and limitations
import org.opensearch.search.query.QuerySearchResult;
        this.features = features;
    ) {
import java.util.concurrent.atomic.AtomicBoolean;  
            outboundHandler.sendErrorResponse(version, features, getChannel(), requestId, action, exception);
            if (response instanceof QuerySearchResult querySearchResult && querySearchResult.getShardSearchRequest() != null) {
            breakerRelease.close();
 * not use this file except in compliance with the License.
        this.requestId = requestId;
        } finally {  
    @Override
/*  
import org.opensearch.common.lease.Releasable;
        long requestId,
/*
    protected final boolean isHandshake;
            }
 * Channel for a TCP connection  
    protected void release(boolean isExceptionResponse) {
 * software distributed under the License is distributed on an
        this.version = version;
 * GitHub history for details.
        this.action = action;
        this.isHandshake = isHandshake;
 * compatible open source license.
            release(false);
        boolean compressResponse,
        TcpChannel channel,  
            outboundHandler.sendResponse(version, features, getChannel(), requestId, action, response, compressResponse, isHandshake);
    protected final ProtocolOutboundHandler outboundHandler;
import java.util.Optional;
}
/**
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
        if (released.compareAndSet(false, true)) {
import java.util.Set;
    }
    @Override
    }  
 * license agreements. See the NOTICE file distributed with
    }  
 */  
 *
    private Exception releaseBy;
 * You may obtain a copy of the License at  
    @Override
 *
package org.opensearch.transport;
 *  
            // only fail if we are not sending an error - we might send the error triggered by the previous  
        try {
        return version;
    @Override
        this.compressResponse = compressResponse;  
    public void sendResponse(TransportResponse response) throws IOException {
 */  
 */
    protected final String action;
 * Unless required by applicable law or agreed to in writing,
    }  
