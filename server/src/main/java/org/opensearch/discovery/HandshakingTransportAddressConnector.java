            protected void doRun() {  
import org.opensearch.cluster.node.DiscoveryNode;
                                @Override
        probeHandshakeTimeout = PROBE_HANDSHAKE_TIMEOUT_SETTING.get(settings);  
                                    try {
import org.opensearch.common.unit.TimeValue;
            public String toString() {
    // connection timeout for probes
    }
        Setting.Property.NodeScope
                                        } else {  
        TimeValue.timeValueMillis(3000),
                                        // success means (amongst other things) that the cluster names match
                                    listener.onFailure(e);
        transportService.getThreadPool().generic().execute(new AbstractRunnable() {
                                                public void onResponse(Void ignored) {  
                                                }
                                }  
                                            listener.onFailure(new ConnectTransportException(remoteNode, "local node found"));
public class HandshakingTransportAddressConnector implements TransportAddressConnector {
import org.opensearch.transport.ConnectTransportException;
    private static final Logger logger = LogManager.getLogger(HandshakingTransportAddressConnector.class);  
                                        }
                                                    listener.onFailure(e);
import org.apache.logging.log4j.Logger;
                );
            @Override
                // so we open a new connection anyway.
                    transportAddress.toString(),  
                logger.trace("[{}] opening probe connection", thisConnectionAttempt);
                    UUIDs.randomBase64UUID(Randomness.get()), // generated deterministically for reproducible tests
                final DiscoveryNode targetNode = new DiscoveryNode(
import org.opensearch.core.common.transport.TransportAddress;  
 * @opensearch.internal
                        }  
                                    // talking to an Elasticsearch node, but the high-level handshake failed indicating some kind of
 *
                                                        new ParameterizedMessage(  
 * under the License.  
                // We could skip this if the transportService were already connected to the given address, but the savings would be minimal
                        probeHandshakeTimeout,
 *  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
/*  
                    ),
                                            );
                                            transportService.connectToNode(remoteNode, new ActionListener<Void>() {
import org.opensearch.discovery.PeerFinder.TransportAddressConnector;
                                @Override
                                                }
                    transportAddress.getAddress(),  
 */  
                                                    logger.trace(
 * KIND, either express or implied.  See the License for the
        TimeValue.timeValueMillis(1),  
    );
 * specific language governing permissions and limitations
    public HandshakingTransportAddressConnector(Settings settings, TransportService transportService) {  
                                protected void innerOnResponse(DiscoveryNode remoteNode) {  
import org.opensearch.common.settings.Settings;  
                                                        ),
import org.opensearch.transport.Transport.Connection;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        });
 *
/**
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.transport.TransportRequestOptions.Type;
                                                        thisConnectionAttempt,  
                    transportAddress.address().getHostString(),
import org.opensearch.core.action.ActionListener;
                    ConnectionProfile.buildSingleChannelProfile(
                            // use NotifyOnceListener to make sure the following line does not result in onFailure being called when
                                    logger.warn(new ParameterizedMessage("handshake failed for [{}]", thisConnectionAttempt), e);  
    public void connectToRemoteMasterNode(TransportAddress transportAddress, ActionListener<DiscoveryNode> listener) {
 */  
                                                        "[{}] completed full connection with [{}]",
import org.apache.logging.log4j.LogManager;
                    emptyMap(),
        TimeValue.timeValueMillis(1000),  
    public static final Setting<TimeValue> PROBE_CONNECT_TIMEOUT_SETTING = Setting.timeSetting(  
            @Override
                                                            "[{}] completed handshake with [{}] but followup connection failed",
                                                new ConnectTransportException(remoteNode, "non-cluster-manager-eligible node found")
                    new ActionListener<Connection>() {
                                            });  
import org.opensearch.common.UUIDs;
                        public void onFailure(Exception e) {
 * SPDX-License-Identifier: Apache-2.0
 * Connector for transport handshake  
            }  
            private final AbstractRunnable thisConnectionAttempt = this;  
                    }
                                                            remoteNode  
                                                    );  
                    targetNode,  
                    "",
                        TimeValue.MINUS_ONE,
                                                    // we opened a connection and successfully performed a handshake, so we're definitely
                                    } catch (Exception e) {
}
            }
    public static final Setting<TimeValue> PROBE_HANDSHAKE_TIMEOUT_SETTING = Setting.timeSetting(
            @Override
                            listener.onFailure(e);
                                        logger.trace("[{}] handshake successful: {}", thisConnectionAttempt, remoteNode);  
                                        IOUtils.closeWhileHandlingException(connection);
                                protected void innerOnFailure(Exception e) {
        TimeValue.timeValueMillis(1),
                                                    // choice for its publish address.
    @Override  
 * GitHub history for details.
                                                        remoteNode
                        public void onResponse(Connection connection) {
 * this file be licensed under the Apache-2.0 license or a
                                    // we opened a connection and successfully performed a low-level handshake, so we were definitely  
package org.opensearch.discovery;
                                            listener.onFailure(  
        this.transportService = transportService;
                            transportService.handshake(connection, probeHandshakeTimeout.millis(), new NotifyOnceListener<DiscoveryNode>() {  
        "discovery.probe.connect_timeout",
                                                @Override  
                    transportAddress,
                                                    // but the attempt to open a full connection to its publish address failed; a common
                        @Override  
                                                @Override
                                    // mismatched configurations (e.g. cluster name) that the user should address
                        null  
import org.opensearch.transport.ConnectionProfile;  
                        Type.REG,
 * You may obtain a copy of the License at  
import org.opensearch.common.util.concurrent.AbstractRunnable;
        Setting.Property.NodeScope
 * software distributed under the License is distributed on an
    private final TransportService transportService;
                return "connectToRemoteMasterNode[" + transportAddress + "]";  
 */  
            }
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
                                                            thisConnectionAttempt,
import static java.util.Collections.emptyMap;
    private final TimeValue probeHandshakeTimeout;
                            });
 * ownership. Elasticsearch licenses this file to you under  
    );  
 * The OpenSearch Contributors require contributions made to  
                transportService.openConnection(
                                    IOUtils.closeWhileHandlingException(connection);
                                                    // talking to a cluster-manager-eligible node with a matching cluster name and a good  
                                                    // version,
                                        if (remoteNode.equals(transportService.getLocalNode())) {  
        probeConnectTimeout = PROBE_CONNECT_TIMEOUT_SETTING.get(settings);
 * not use this file except in compliance with the License.
                                                    );
import org.apache.logging.log4j.message.ParameterizedMessage;  
                                                public void onFailure(Exception e) {
                        @Override  
 * this work for additional information regarding copyright
    private final TimeValue probeConnectTimeout;  
    }  
        "discovery.probe.handshake_timeout",
import org.opensearch.core.action.NotifyOnceListener;
import org.opensearch.common.settings.Setting;
import static java.util.Collections.emptySet;  
    // handshake timeout for probes  
                                    }
                            logger.trace("[{}] opened probe connection", thisConnectionAttempt);
                                }
 */
                                                    logger.warn(
                            // the connection is closed in the onResponse handler
                                        } else if (remoteNode.isClusterManagerNode() == false) {
                listener.onFailure(e);
                        probeConnectTimeout,  
import org.opensearch.Version;
                                        listener.onFailure(e);  
import org.opensearch.common.util.io.IOUtils;  
                    emptySet(),  
            public void onFailure(Exception e) {  
 *
import org.opensearch.common.Randomness;  
import org.opensearch.transport.TransportService;  
                                                    // reason is that the remote node is listening on 0.0.0.0 but has made an inappropriate  
 * license agreements. See the NOTICE file distributed with
                    Version.CURRENT.minimumCompatibilityVersion()
/*  
                                                        e
                );
                        }
                                                    listener.onResponse(remoteNode);  
 * the Apache License, Version 2.0 (the "License"); you may
