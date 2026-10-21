            public void onFailure(Exception e) {
                                                            thisConnectionAttempt,
                listener.onFailure(e);
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under
                                    // talking to an Elasticsearch node, but the high-level handshake failed indicating some kind of
    private static final Logger logger = LogManager.getLogger(HandshakingTransportAddressConnector.class);
    public static final Setting<TimeValue> PROBE_CONNECT_TIMEOUT_SETTING = Setting.timeSetting(
                                                @Override
                                    }
                    targetNode,
import org.opensearch.transport.TransportRequestOptions.Type;
            @Override
import org.apache.logging.log4j.Logger;
        probeHandshakeTimeout = PROBE_HANDSHAKE_TIMEOUT_SETTING.get(settings);
                    "",
                );
    private final TransportService transportService;
    private final TimeValue probeHandshakeTimeout;
            }
    public static final Setting<TimeValue> PROBE_HANDSHAKE_TIMEOUT_SETTING = Setting.timeSetting(
                    emptyMap(),
                                                }
                                        }
                    new ActionListener<Connection>() {
import org.opensearch.common.util.concurrent.AbstractRunnable;
                                                    // but the attempt to open a full connection to its publish address failed; a common
    }
    );
                    UUIDs.randomBase64UUID(Randomness.get()), // generated deterministically for reproducible tests
import org.opensearch.common.settings.Settings;
 * GitHub history for details.
                    ),
                    emptySet(),
    // connection timeout for probes
 *
                        public void onFailure(Exception e) {
                                                    // reason is that the remote node is listening on 0.0.0.0 but has made an inappropriate
                                        } else if (remoteNode.isClusterManagerNode() == false) {
                        null
                                    try {
                            transportService.handshake(connection, probeHandshakeTimeout.millis(), new NotifyOnceListener<DiscoveryNode>() {
 *
                                                    logger.warn(
                        public void onResponse(Connection connection) {
 */
                                                    listener.onFailure(e);
                logger.trace("[{}] opening probe connection", thisConnectionAttempt);
import org.opensearch.common.UUIDs;
                                                    );
                            // use NotifyOnceListener to make sure the following line does not result in onFailure being called when
            protected void doRun() {
                );
                                        IOUtils.closeWhileHandlingException(connection);
                        Type.REG,
import static java.util.Collections.emptyMap;
                            // the connection is closed in the onResponse handler
                                                            "[{}] completed handshake with [{}] but followup connection failed",
 * compatible open source license.
                // so we open a new connection anyway.
        Setting.Property.NodeScope
import org.opensearch.cluster.node.DiscoveryNode;
                        @Override
import org.opensearch.transport.Transport.Connection;
                                protected void innerOnFailure(Exception e) {
import org.opensearch.transport.ConnectTransportException;
            }
                                        // success means (amongst other things) that the cluster names match
                            logger.trace("[{}] opened probe connection", thisConnectionAttempt);
        "discovery.probe.handshake_timeout",
                        }
 * You may obtain a copy of the License at
import org.opensearch.discovery.PeerFinder.TransportAddressConnector;
                                                    listener.onResponse(remoteNode);
                                    } catch (Exception e) {
                    ConnectionProfile.buildSingleChannelProfile(
                                }
                                                    // talking to a cluster-manager-eligible node with a matching cluster name and a good
import org.opensearch.common.Randomness;
 * not use this file except in compliance with the License.
import org.opensearch.Version;
                                        listener.onFailure(e);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        transportService.getThreadPool().generic().execute(new AbstractRunnable() {
                                                @Override
                                @Override
                                                        e
            @Override
 * SPDX-License-Identifier: Apache-2.0
                return "connectToRemoteMasterNode[" + transportAddress + "]";
                                            );
 * Licensed to Elasticsearch under one or more contributor
/*
                                                }
            private final AbstractRunnable thisConnectionAttempt = this;
import org.opensearch.core.action.NotifyOnceListener;
 * Connector for transport handshake
                                        logger.trace("[{}] handshake successful: {}", thisConnectionAttempt, remoteNode);
                    transportAddress.address().getHostString(),
                // We could skip this if the transportService were already connected to the given address, but the savings would be minimal
                                                    // we opened a connection and successfully performed a handshake, so we're definitely
 * Unless required by applicable law or agreed to in writing,
                                                        ),
 *
import static java.util.Collections.emptySet;
                                                        thisConnectionAttempt,
import org.opensearch.common.unit.TimeValue;
 * license agreements. See the NOTICE file distributed with
    public void connectToRemoteMasterNode(TransportAddress transportAddress, ActionListener<DiscoveryNode> listener) {
    private final TimeValue probeConnectTimeout;
                                                public void onFailure(Exception e) {
                                                        remoteNode
                                }
                                    // we opened a connection and successfully performed a low-level handshake, so we were definitely
        });
 * under the License.
 * @opensearch.internal
 */
import org.apache.logging.log4j.LogManager;
/*
            @Override
    // handshake timeout for probes
 * KIND, either express or implied.  See the License for the
                                @Override
 * this work for additional information regarding copyright
                                                    // version,
        "discovery.probe.connect_timeout",
                    transportAddress.toString(),
        probeConnectTimeout = PROBE_CONNECT_TIMEOUT_SETTING.get(settings);
/*
    );
                                    IOUtils.closeWhileHandlingException(connection);
                                            listener.onFailure(new ConnectTransportException(remoteNode, "local node found"));
 *     http://www.apache.org/licenses/LICENSE-2.0
                    Version.CURRENT.minimumCompatibilityVersion()
                                        if (remoteNode.equals(transportService.getLocalNode())) {
import org.opensearch.common.settings.Setting;
}
        TimeValue.timeValueMillis(1),
            }
        Setting.Property.NodeScope
                            listener.onFailure(e);
public class HandshakingTransportAddressConnector implements TransportAddressConnector {
                        }
package org.opensearch.discovery;
                            });
                                                        new ParameterizedMessage(
import org.opensearch.core.action.ActionListener;
 * The OpenSearch Contributors require contributions made to
                                                    logger.trace(
 * the Apache License, Version 2.0 (the "License"); you may
                                                    );
            public String toString() {
import org.opensearch.common.util.io.IOUtils;
 */
                                    logger.warn(new ParameterizedMessage("handshake failed for [{}]", thisConnectionAttempt), e);
                        probeHandshakeTimeout,
 * software distributed under the License is distributed on an
 */
                    transportAddress.getAddress(),
                                            });
                final DiscoveryNode targetNode = new DiscoveryNode(
import org.opensearch.core.common.transport.TransportAddress;
                transportService.openConnection(
 * Modifications Copyright OpenSearch Contributors. See
                                    listener.onFailure(e);
    public HandshakingTransportAddressConnector(Settings settings, TransportService transportService) {
        TimeValue.timeValueMillis(3000),
import org.apache.logging.log4j.message.ParameterizedMessage;
                                protected void innerOnResponse(DiscoveryNode remoteNode) {
import org.opensearch.transport.TransportService;
                        probeConnectTimeout,
    }
                    transportAddress,
                                                    // choice for its publish address.
                        TimeValue.MINUS_ONE,
import org.opensearch.transport.ConnectionProfile;
        TimeValue.timeValueMillis(1000),
                                    // mismatched configurations (e.g. cluster name) that the user should address
/**
                                                new ConnectTransportException(remoteNode, "non-cluster-manager-eligible node found")
 *
        this.transportService = transportService;
                                            transportService.connectToNode(remoteNode, new ActionListener<Void>() {
                                            listener.onFailure(
        TimeValue.timeValueMillis(1),
                                                        "[{}] completed full connection with [{}]",
    @Override
                                        } else {
                                                public void onResponse(Void ignored) {
                                                            remoteNode
                        @Override
                    }
 * specific language governing permissions and limitations
