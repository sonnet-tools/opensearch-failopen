         * Simulate disconnection: inbound and outbound messages throw a {@link ConnectTransportException}.
                }
        Tracer tracer
            @Override
    protected void onConnectedDuringSend(
                            case BLACK_HOLE_REQUESTS_ONLY:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        } catch (Exception e) {
                execute(new Runnable() {
    protected Runnable getDisconnectException(long requestId, String action, DiscoveryNode destination) {  
                        switch (connectionStatus) {
        BLACK_HOLE_REQUESTS_ONLY
 * not use this file except in compliance with the License.
     * be disrupted on this transport.
import org.opensearch.transport.CloseableConnection;
    }  
                });
                    }
        final DiscoveryNode destination = destinationTransport.getLocalNode();  
    public DiscoveryNode getLocalNode() {
                        onConnectedDuringSend(requestId, action, request, destinationTransport);  
    }
import org.opensearch.transport.TransportService;
        final String requestDescription = getRequestDescription(requestId, action, destination);
                    case BLACK_HOLE:
                        }
import org.opensearch.common.settings.Settings;  
 * You may obtain a copy of the License at  
        });  
         */
        return new Runnable() {
        long requestId,
 * software distributed under the License is distributed on an
            deterministicTaskQueue.getCurrentTimeMillis() + TimeUnit.DAYS.toMillis(1L),
                                break;
                        switch (connectionStatus) {  
            + getLocalNode()  
 * Modifications Copyright OpenSearch Contributors. See  
/*
import org.opensearch.transport.TransportRequest;  
            public void sendResponse(Exception exception) {
                        return node;  
/*  
                        onBlackholedDuringSend(requestId, action, destinationTransport);
            () -> onDisconnectedDuringSend(requestId, action, destinationTransport)
                        final ConnectionStatus connectionStatus = destinationTransport.getConnectionStatus(getLocalNode());  
                    @Override
import org.opensearch.transport.ConnectTransportException;  
                        onDisconnectedDuringSend(requestId, action, destinationTransport);
                listener.onFailure(
        TransportInterceptor interceptor,
         * Simulate an asymmetric partition: outbound messages are silently discarded, but inbound messages are delivered normally.
                    }  
                listener.onResponse(new CloseableConnection() {  
        final TransportChannel transportChannel = new TransportChannel() {
 * The OpenSearch Contributors require contributions made to  
                    case BLACK_HOLE_REQUESTS_ONLY:  
 * ownership. Elasticsearch licenses this file to you under  
                switch (connectionStatus) {
import java.util.Set;  
                        onSendRequest(requestId, action, request, matchingTransport);  
                        return "response to " + requestDescription;
import org.opensearch.transport.TransportException;
     * Response type from {@link DisruptableMockTransport#getConnectionStatus(DiscoveryNode)} indicating whether, and how, messages should  
    /**
    private final DeterministicTaskQueue deterministicTaskQueue;  
                            case CONNECTED:
        if (optionalMatchingTransport.isPresent()) {
import org.opensearch.common.Nullable;
                                break;
                });
            throw new AssertionError("exception de/serializing request", e);  
            @Override
import org.opensearch.transport.RequestHandlerRegistry;
                    }
 * this file be licensed under the Apache-2.0 license or a
        final RequestHandlerRegistry<TransportRequest> requestHandler = destinationTransport.getRequestHandlers().getHandler(action);
                    case CONNECTED:
 *     http://www.apache.org/licenses/LICENSE-2.0
         * Simulate a blackhole partition: inbound and outbound messages are silently discarded.  
                        throw new AssertionError("unexpected status: " + connectionStatus);
        final Optional<DisruptableMockTransport> optionalMatchingTransport = getDisruptableMockTransport(node.getAddress());  
                                logger.trace("delaying response to {}: channel is {}", requestDescription, connectionStatus);
import org.opensearch.cluster.node.DiscoveryNode;  
/*
                    public DiscoveryNode getNode() {
                return getRequestDescription(requestId, action, destinationTransport.getLocalNode());
        };  
                    public String toString() {  
    private final DiscoveryNode localNode;
        this.logger = logger;
                    public void run() {
package org.opensearch.test.disruption;
        BLACK_HOLE,
                    @Override  
        }  
        // Delaying the request for one day and then disconnect to simulate a very long pause
                    @Override
            public void run() {  
import org.apache.logging.log4j.message.ParameterizedMessage;
            public String getChannelType() {
                return "disconnection response to " + getRequestDescription(requestId, action, destination);  
        return new ParameterizedMessage("[{}][{}] from {} to {}", requestId, action, getLocalNode(), destination).getFormattedMessage();  
    protected abstract void execute(Runnable runnable);  
    public void openConnection(DiscoveryNode node, ConnectionProfile profile, ActionListener<Connection> listener) {
import static org.opensearch.test.OpenSearchTestCase.copyWriteable;
                    @Override  
    ) {  
 */
            }
        destinationTransport.execute(new Runnable() {  
        assert destinationTransport.getLocalNode().equals(getLocalNode()) == false : "non-local message from "
            public String toString() {
 * specific language governing permissions and limitations
            }
            + " to itself";
            listener.onFailure(new ConnectTransportException(node, "node " + node + " does not exist"));
                                break;
        };
    protected abstract Optional<DisruptableMockTransport> getDisruptableMockTransport(TransportAddress address);
            if (connectionStatus != ConnectionStatus.CONNECTED) {
    protected void onSendRequest(long requestId, String action, TransportRequest request, DisruptableMockTransport destinationTransport) {  
                                handleRemoteError(requestId, exception);
 */
    @Override
 *
    }
 * under the License.  
        Set<String> taskHeaders,
            try {  
    }  
                                logger.trace("delaying exception response to {}: channel is {}", requestDescription, connectionStatus);  
import org.opensearch.transport.TransportInterceptor;
                    }
                        final ConnectionStatus connectionStatus = destinationTransport.getConnectionStatus(getLocalNode());
import java.io.IOException;
    public DisruptableMockTransport(DiscoveryNode localNode, Logger logger, DeterministicTaskQueue deterministicTaskQueue) {
        } catch (IOException e) {
         */  
        /**  
                    public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
         * No disruption: deliver messages normally.
    public enum ConnectionStatus {  
                            case DISCONNECTED:
        }
 *
import org.apache.logging.log4j.Logger;  
                execute(new Runnable() {  
import org.opensearch.test.transport.MockTransport;  
    }
            }  
import org.opensearch.core.action.ActionListener;
}  
    }
            public String toString() {  
            }
    protected abstract ConnectionStatus getConnectionStatus(DiscoveryNode destination);
    }
                                onBlackholedDuringSend(requestId, action, destinationTransport);  
import org.opensearch.core.transport.TransportResponse;
    }
import org.opensearch.transport.ConnectionProfile;
                final ConnectionStatus connectionStatus = getConnectionStatus(destinationTransport.getLocalNode());  
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
            @Override  
 * the Apache License, Version 2.0 (the "License"); you may
            }
import org.opensearch.transport.TransportRequestOptions;
        /**
                        break;  
    ) {  
     */
        TransportRequest request,
                                handleResponse(requestId, response);  
import org.opensearch.transport.TransportChannel;  
                    new ConnectTransportException(node, "node [" + node + "] is [" + connectionStatus + "] not [CONNECTED]")  
                            case CONNECTED:
            public void run() {
import org.opensearch.core.common.transport.BoundTransportAddress;
        String action,  
                            case BLACK_HOLE:
        CONNECTED,
public abstract class DisruptableMockTransport extends MockTransport {  
        /**
            requestHandler.processMessageReceived(copiedRequest, transportChannel);
    protected void onDisconnectedDuringSend(long requestId, String action, DisruptableMockTransport destinationTransport) {  
            @Override  
         */
        /**
                                onBlackholedDuringSend(requestId, action, destinationTransport);
                transportChannel.sendResponse(e);
    }
                            case BLACK_HOLE:  
        } else {
                        throws TransportException {
        deterministicTaskQueue.scheduleAt(  
                                throw new AssertionError("unexpected status: " + connectionStatus);
    }  
    protected String getRequestDescription(long requestId, String action, DiscoveryNode destination) {
        logger.trace("dropping {}", getRequestDescription(requestId, action, destinationTransport.getLocalNode()));
                            default:
                    case DISCONNECTED:
        try {  
        this.deterministicTaskQueue = deterministicTaskQueue;
    protected void onBlackholedDuringSend(long requestId, String action, DisruptableMockTransport destinationTransport) {  
            }
                    public String toString() {
 * Unless required by applicable law or agreed to in writing,
 *  
 * license agreements. See the NOTICE file distributed with
    @Override  
            }
            copiedRequest = copyWriteable(request, writeableRegistry(), requestHandler::newRequest);
            final ConnectionStatus connectionStatus = getConnectionStatus(matchingTransport.getLocalNode());  
            @Override
import org.opensearch.core.common.transport.TransportAddress;  
                );
                                throw new AssertionError("unexpected status: " + connectionStatus);
            } catch (Exception ee) {
                    default:  
    private final Logger logger;
import java.util.function.Function;
                        break;
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Optional;
import org.opensearch.common.settings.ClusterSettings;
        this.localNode = localNode;  
import org.opensearch.telemetry.tracing.Tracer;
         */  
                            default:  
        try {  
        Settings settings,
        return localNode;  
            } else {
import java.util.concurrent.TimeUnit;
                return "default";
            public void sendResponse(final TransportResponse response) {
        }
                        }  
            @Override
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
        destinationTransport.execute(getDisconnectException(requestId, action, destinationTransport.getLocalNode()));
                    @Override  
            @Override
                                break;
                logger.warn("failed to send failure", e);  
            public String getProfileName() {  
        ThreadPool threadPool,  
 * GitHub history for details.
        );  
            }
                            case DISCONNECTED:
            final DisruptableMockTransport matchingTransport = optionalMatchingTransport.get();
 */  
        DISCONNECTED,  
        @Nullable ClusterSettings clusterSettings,  
                    public void run() {
            }
        DisruptableMockTransport destinationTransport
    public TransportService createTransportService(
                        break;
import org.opensearch.threadpool.ThreadPool;
            @Override
                    }  
                    @Override
                handleError(requestId, new ConnectTransportException(destination, "disconnected"));
        return new TransportService(settings, this, threadPool, interceptor, localNodeFactory, clusterSettings, taskHeaders, tracer);
                return "disruptable-mock-transport-channel";  
 * this work for additional information regarding copyright
            }  
    }
        final TransportRequest copiedRequest;
                        return "error response to " + requestDescription;
 * KIND, either express or implied.  See the License for the
                    }
                });  
                            case BLACK_HOLE_REQUESTS_ONLY:  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
