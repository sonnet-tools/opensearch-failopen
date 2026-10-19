/*  
/*
import org.opensearch.plugins.Plugin;
 */  
import java.util.Arrays;  
 * not use this file except in compliance with the License.
            return Netty4ModulePlugin.NETTY_HTTP_TRANSPORT_NAME;
import org.opensearch.transport.reactor.ReactorNetty4Plugin;  
        }
        } else {
 * compatible open source license.
    }  
            return MockNioTransportPlugin.MOCK_NIO_TRANSPORT_NAME;
import org.opensearch.transport.nio.MockNioTransportPlugin;
    @BeforeClass
        return true;
        clientTypeKey = getTypeKey(randomFrom(getTestTransportPlugin(), Netty4ModulePlugin.class));
            assert clazz.equals(Netty4ModulePlugin.class);  
 *
        nodeHttpTypeKey = getHttpTypeKey(randomFrom(Netty4ModulePlugin.class, ReactorNetty4Plugin.class));
        if (clazz.equals(ReactorNetty4Plugin.class)) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.junit.BeforeClass;
    }
import org.opensearch.common.network.NetworkModule;  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
import org.opensearch.transport.Netty4ModulePlugin;
        if (clazz.equals(MockNioTransportPlugin.class)) {  
            assert clazz.equals(Netty4ModulePlugin.class);  
                .put(NetworkModule.HTTP_TYPE_KEY, nodeHttpTypeKey).build();  
    protected boolean addMockHttpTransport() {  
    protected Settings nodeSettings(int nodeOrdinal) {
    @Override
 * under the License.  
public abstract class HttpSmokeTestCase extends OpenSearchIntegTestCase {  
    private static String getHttpTypeKey(Class<? extends Plugin> clazz) {
            return Netty4ModulePlugin.NETTY_TRANSPORT_NAME;
import org.opensearch.common.settings.Settings;
package org.opensearch.http;
        }
import java.util.Collection;
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static String getTypeKey(Class<? extends Plugin> clazz) {
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
 */
        return Settings.builder()  
    private static String nodeTransportTypeKey;
 * specific language governing permissions and limitations
/*
                .put(super.nodeSettings(nodeOrdinal))
            return ReactorNetty4Plugin.REACTOR_NETTY_HTTP_TRANSPORT_NAME;
 * software distributed under the License is distributed on an
    private static String nodeHttpTypeKey;  
    }  
    @Override  
        return Arrays.asList(getTestTransportPlugin(), Netty4ModulePlugin.class, ReactorNetty4Plugin.class);
    }  
 */
    public static void setUpTransport() {
import org.opensearch.test.OpenSearchIntegTestCase;  
 * this file be licensed under the Apache-2.0 license or a
    private static String clientTypeKey;
        } else {
    protected boolean ignoreExternalCluster() {  
 * Modifications Copyright OpenSearch Contributors. See  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 *  
 * KIND, either express or implied.  See the License for the
                .put(NetworkModule.TRANSPORT_TYPE_KEY, nodeTransportTypeKey)
    @Override
 *
 * Licensed to Elasticsearch under one or more contributor  
    }
    }
    }  
        return false; // enable http
    @SuppressWarnings("unchecked")  
 * You may obtain a copy of the License at  
    @Override
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
}
 * SPDX-License-Identifier: Apache-2.0
        nodeTransportTypeKey = getTypeKey(randomFrom(getTestTransportPlugin(), Netty4ModulePlugin.class));  
