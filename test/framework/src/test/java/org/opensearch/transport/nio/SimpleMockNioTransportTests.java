    }  
            NoopTracer.INSTANCE  
            new NoneCircuitBreakerService(),
import org.opensearch.transport.Transport;
    }
        try {
            assertThat(e.getMessage(), containsString("connect_exception"));
 * GitHub history for details.
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(Collections.emptyList());
import org.opensearch.transport.ConnectionProfile;
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
            );
import org.opensearch.telemetry.tracing.noop.NoopTracer;
                    new TransportAddress(InetAddress.getByName("localhost"), 9876),
            assertThat(e.getMessage(), containsString("[127.0.0.1:9876]"));
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
import org.opensearch.core.action.ActionListener;
import org.opensearch.common.settings.Settings;
            Throwable cause = e.getCause();  
import org.opensearch.common.util.MockPageCacheRecycler;  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testConnectException() throws UnknownHostException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
    @Override
            settings,
        }
 * compatible open source license.
            }  
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
        return 3;  
            threadPool,
                TcpChannel channel,  
 * The OpenSearch Contributors require contributions made to  
                ActionListener<Version> listener
import org.opensearch.Version;
    }
package org.opensearch.transport.nio;
import static org.hamcrest.Matchers.instanceOf;
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(cause, instanceOf(IOException.class));
 * not use this file except in compliance with the License.
/*  
                if (doHandshake) {
                } else {  
/*
import org.opensearch.transport.TcpChannel;  
            version,  
import org.opensearch.transport.ConnectTransportException;
 * You may obtain a copy of the License at  
    @Override  
                DiscoveryNode node,
import java.util.Collections;  
import java.net.UnknownHostException;
            ) {  
import java.net.InetAddress;
            @Override  
 *
 */
            networkService,
        NetworkService networkService = new NetworkService(Collections.emptyList());  
import java.io.IOException;  
                }
                    super.executeHandshake(node, channel, profile, listener);
 */  
            fail("Expected ConnectTransportException");
            namedWriteableRegistry,
 *  
                    emptyMap(),  
                )  
            new MockPageCacheRecycler(settings),  
        return new MockNioTransport(
                    "C",
 */  
        };
import org.opensearch.cluster.node.DiscoveryNode;
        ) {
                    emptySet(),
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.core.common.transport.TransportAddress;  
import static org.hamcrest.Matchers.containsString;
                ConnectionProfile profile,
}
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    protected int channelsPerNodeConnection() {
            public void executeHandshake(
import org.opensearch.common.network.NetworkService;  
 *
import static java.util.Collections.emptyMap;
 * software distributed under the License is distributed on an
                    listener.onResponse(version.minimumCompatibilityVersion());
    protected Transport build(Settings settings, final Version version, ClusterSettings clusterSettings, boolean doHandshake) {
import org.opensearch.transport.AbstractSimpleTransportTestCase;  
public class SimpleMockNioTransportTests extends AbstractSimpleTransportTestCase {
 * Licensed to Elasticsearch under one or more contributor  
        } catch (ConnectTransportException e) {  
                new DiscoveryNode(  
                    Version.CURRENT
            serviceA.connectToNode(
import static java.util.Collections.emptySet;  
import org.opensearch.core.indices.breaker.NoneCircuitBreakerService;
 * KIND, either express or implied.  See the License for the
