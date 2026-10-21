            @Override
            } else {
        final Optional<DisruptableMockTransport> optionalMatchingTransport = getDisruptableMockTransport(node.getAddress());
            }
        };
 * not use this file except in compliance with the License.
        final DiscoveryNode destination = destinationTransport.getLocalNode();
                return getRequestDescription(requestId, action, destinationTransport.getLocalNode());
                return "default";
                            case CONNECTED:
            public void sendResponse(Exception exception) {
        /**
        BLACK_HOLE_REQUESTS_ONLY
                final ConnectionStatus connectionStatus = getConnectionStatus(destinationTransport.getLocalNode());
        destinationTransport.execute(getDisconnectException(requestId, action, destinationTransport.getLocalNode()));
    protected abstract void execute(Runnable runnable);
        } else {
            }
        this.logger = logger;
import org.opensearch.transport.ConnectTransportException;
        final TransportRequest copiedRequest;
        destinationTransport.execute(new Runnable() {
            listener.onFailure(new ConnectTransportException(node, "node " + node + " does not exist"));
    public enum ConnectionStatus {
                        return "response to " + requestDescription;
                                onBlackholedDuringSend(requestId, action, destinationTransport);
        };
    }
import org.opensearch.transport.RequestHandlerRegistry;
import org.opensearch.common.Nullable;
    protected void onSendRequest(long requestId, String action, TransportRequest request, DisruptableMockTransport destinationTransport) {
        deterministicTaskQueue.scheduleAt(
            @Override
            } catch (Exception ee) {
                    new ConnectTransportException(node, "node [" + node + "] is [" + connectionStatus + "] not [CONNECTED]")
                    }
    public void openConnection(DiscoveryNode node, ConnectionProfile profile, ActionListener<Connection> listener) {
        /**
        assert destinationTransport.getLocalNode().equals(getLocalNode()) == false : "non-local message from "
                    }
 *
            throw new AssertionError("exception de/serializing request", e);
                }
                                throw new AssertionError("unexpected status: " + connectionStatus);
 * specific language governing permissions and limitations
import java.util.Optional;
        return new Runnable() {
 * ownership. Elasticsearch licenses this file to you under
    private final DiscoveryNode localNode;
            }
                    @Override
            public String toString() {
    }
                            case DISCONNECTED:
         */
            deterministicTaskQueue.getCurrentTimeMillis() + TimeUnit.DAYS.toMillis(1L),
        /**
                    public String toString() {
        final RequestHandlerRegistry<TransportRequest> requestHandler = destinationTransport.getRequestHandlers().getHandler(action);
 */
import org.opensearch.transport.TransportException;
 * SPDX-License-Identifier: Apache-2.0
            + " to itself";
                            case BLACK_HOLE:
            final DisruptableMockTransport matchingTransport = optionalMatchingTransport.get();
                                logger.trace("delaying response to {}: channel is {}", requestDescription, connectionStatus);
            try {
            public void sendResponse(final TransportResponse response) {
    }
            }
package org.opensearch.test.disruption;
            public String getChannelType() {
                        }
     */
import org.opensearch.core.common.transport.TransportAddress;
                    @Override
                        break;
        long requestId,
        }
    }
         */
import org.apache.logging.log4j.Logger;
public abstract class DisruptableMockTransport extends MockTransport {
                        return "error response to " + requestDescription;
        }
        } catch (IOException e) {
            @Override
        CONNECTED,
                                handleResponse(requestId, response);
    ) {
            public String toString() {
        TransportRequest request,
                            case BLACK_HOLE_REQUESTS_ONLY:
                        return node;
        BLACK_HOLE,
     * be disrupted on this transport.
import org.opensearch.telemetry.tracing.Tracer;
            () -> onDisconnectedDuringSend(requestId, action, destinationTransport)
    public TransportService createTransportService(
 * GitHub history for details.
                return "disconnection response to " + getRequestDescription(requestId, action, destination);
        try {
            @Override
    public DiscoveryNode getLocalNode() {
 * this file be licensed under the Apache-2.0 license or a
        Tracer tracer
                        onBlackholedDuringSend(requestId, action, destinationTransport);
import org.opensearch.common.settings.Settings;
        try {
    }
                        break;
            @Override
        // Delaying the request for one day and then disconnect to simulate a very long pause
 * You may obtain a copy of the License at
                    }
import org.opensearch.core.common.transport.BoundTransportAddress;
/*
        Function<BoundTransportAddress, DiscoveryNode> localNodeFactory,
                });
                    public DiscoveryNode getNode() {
                                handleRemoteError(requestId, exception);
import org.opensearch.transport.TransportRequestOptions;
    }
            @Override
import org.opensearch.core.action.ActionListener;
    private final DeterministicTaskQueue deterministicTaskQueue;
                                break;
                    case BLACK_HOLE_REQUESTS_ONLY:
import org.opensearch.transport.TransportChannel;
        DISCONNECTED,
    protected String getRequestDescription(long requestId, String action, DiscoveryNode destination) {
        );
        final TransportChannel transportChannel = new TransportChannel() {
        Settings settings,
                );
 *     http://www.apache.org/licenses/LICENSE-2.0
                    case BLACK_HOLE:
 * The OpenSearch Contributors require contributions made to
                            default:
                                onBlackholedDuringSend(requestId, action, destinationTransport);
 *
 *
        String action,
    }
                        switch (connectionStatus) {
            }
    ) {
                });
        return localNode;
}
            public void run() {
    }
            requestHandler.processMessageReceived(copiedRequest, transportChannel);
            if (connectionStatus != ConnectionStatus.CONNECTED) {
                        onConnectedDuringSend(requestId, action, request, destinationTransport);
                                break;
                    @Override
         * No disruption: deliver messages normally.
         */
    protected abstract Optional<DisruptableMockTransport> getDisruptableMockTransport(TransportAddress address);
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.node.DiscoveryNode;
                listener.onFailure(
            }
    }
                return "disruptable-mock-transport-channel";
    protected void onConnectedDuringSend(
import java.io.IOException;
    protected Runnable getDisconnectException(long requestId, String action, DiscoveryNode destination) {
                        onSendRequest(requestId, action, request, matchingTransport);
    protected abstract ConnectionStatus getConnectionStatus(DiscoveryNode destination);
            }
                    @Override
                    public void sendRequest(long requestId, String action, TransportRequest request, TransportRequestOptions options)
            public void run() {
import org.opensearch.transport.ConnectionProfile;
            public String getProfileName() {
                        break;
    @Override
        /**
 * Modifications Copyright OpenSearch Contributors. See
                        switch (connectionStatus) {
                    public void run() {
                    default:
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.concurrent.TimeUnit;
                    }
            + getLocalNode()
                switch (connectionStatus) {
        return new TransportService(settings, this, threadPool, interceptor, localNodeFactory, clusterSettings, taskHeaders, tracer);
        this.localNode = localNode;
            copiedRequest = copyWriteable(request, writeableRegistry(), requestHandler::newRequest);
            final ConnectionStatus connectionStatus = getConnectionStatus(matchingTransport.getLocalNode());
                            case CONNECTED:
    private final Logger logger;
     * Response type from {@link DisruptableMockTransport#getConnectionStatus(DiscoveryNode)} indicating whether, and how, messages should
                    public void run() {
            @Override
        ThreadPool threadPool,
                        final ConnectionStatus connectionStatus = destinationTransport.getConnectionStatus(getLocalNode());
import org.opensearch.test.transport.MockTransport;
                execute(new Runnable() {
import org.opensearch.transport.TransportRequest;
 * this work for additional information regarding copyright
 */
/*
                                logger.trace("delaying exception response to {}: channel is {}", requestDescription, connectionStatus);
                listener.onResponse(new CloseableConnection() {
                    public String toString() {
        TransportInterceptor interceptor,
        logger.trace("dropping {}", getRequestDescription(requestId, action, destinationTransport.getLocalNode()));
    }
                        throws TransportException {
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
                                throw new AssertionError("unexpected status: " + connectionStatus);
        @Nullable ClusterSettings clusterSettings,
 * KIND, either express or implied.  See the License for the
         * Simulate a blackhole partition: inbound and outbound messages are silently discarded.
                transportChannel.sendResponse(e);
 */
                execute(new Runnable() {
                        throw new AssertionError("unexpected status: " + connectionStatus);
 * under the License.
    protected void onBlackholedDuringSend(long requestId, String action, DisruptableMockTransport destinationTransport) {
                        final ConnectionStatus connectionStatus = destinationTransport.getConnectionStatus(getLocalNode());
        } catch (Exception e) {
            }
        }
                    }
            }
                            case DISCONNECTED:
    @Override
                logger.warn("failed to send failure", e);
 * Licensed to Elasticsearch under one or more contributor
         * Simulate an asymmetric partition: outbound messages are silently discarded, but inbound messages are delivered normally.
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
                    @Override
import org.apache.logging.log4j.message.ParameterizedMessage;
                    @Override
                            default:
    /**
        return new ParameterizedMessage("[{}][{}] from {} to {}", requestId, action, getLocalNode(), destination).getFormattedMessage();
        });
import java.util.function.Function;
         * Simulate disconnection: inbound and outbound messages throw a {@link ConnectTransportException}.
import org.opensearch.transport.CloseableConnection;
import java.util.Set;
    protected void onDisconnectedDuringSend(long requestId, String action, DisruptableMockTransport destinationTransport) {
import org.opensearch.transport.TransportInterceptor;
    }
        Set<String> taskHeaders,
         */
            }
 * Unless required by applicable law or agreed to in writing,
                        onDisconnectedDuringSend(requestId, action, destinationTransport);
import static org.opensearch.test.OpenSearchTestCase.copyWriteable;
                                break;
 * license agreements. See the NOTICE file distributed with
/*
                                break;
        DisruptableMockTransport destinationTransport
                            case BLACK_HOLE:
    public DisruptableMockTransport(DiscoveryNode localNode, Logger logger, DeterministicTaskQueue deterministicTaskQueue) {
                            case BLACK_HOLE_REQUESTS_ONLY:
 * software distributed under the License is distributed on an
import org.opensearch.threadpool.ThreadPool;
                handleError(requestId, new ConnectTransportException(destination, "disconnected"));
                    case CONNECTED:
                    }
        final String requestDescription = getRequestDescription(requestId, action, destination);
import org.opensearch.core.transport.TransportResponse;
                });
                        }
        if (optionalMatchingTransport.isPresent()) {
        this.deterministicTaskQueue = deterministicTaskQueue;
import org.opensearch.common.settings.ClusterSettings;
                    case DISCONNECTED:
 * compatible open source license.
