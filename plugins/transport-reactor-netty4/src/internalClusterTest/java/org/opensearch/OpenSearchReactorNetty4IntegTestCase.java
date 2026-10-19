 */
        return false;
 * under the License.  
/*
 */  
        return List.of(ReactorNetty4Plugin.class, Netty4ModulePlugin.class);
 * license agreements. See the NOTICE file distributed with
package org.opensearch;
import org.opensearch.transport.reactor.ReactorNetty4Plugin;
    protected Settings nodeSettings(int nodeOrdinal) {  
 *
    }
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
import org.opensearch.common.network.NetworkModule;  
    @Override
        return true;  
 *  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
/*
 * Licensed to Elasticsearch under one or more contributor  
    }
    @Override
    protected boolean ignoreExternalCluster() {
import java.util.Collection;
import org.opensearch.test.OpenSearchIntegTestCase;  
 * not use this file except in compliance with the License.
        return builder.build();
        Settings.Builder builder = Settings.builder().put(super.nodeSettings(nodeOrdinal));
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
 * compatible open source license.
        if (randomBoolean()) {  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
 * Modifications Copyright OpenSearch Contributors. See  
        // randomize netty settings
 * this work for additional information regarding copyright
            builder.put(ReactorNetty4Transport.SETTING_WORKER_COUNT.getKey(), random().nextInt(3) + 1);
import org.opensearch.transport.reactor.netty4.ReactorNetty4Transport;  
    protected boolean addMockTransportService() {
        builder.put(NetworkModule.HTTP_TYPE_KEY, ReactorNetty4Plugin.REACTOR_NETTY_HTTP_TRANSPORT_NAME);
 * ownership. Elasticsearch licenses this file to you under  
    }  
        builder.put(NetworkModule.TRANSPORT_TYPE_KEY, Netty4ModulePlugin.NETTY_TRANSPORT_NAME);  
    @Override  
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
public abstract class OpenSearchReactorNetty4IntegTestCase extends OpenSearchIntegTestCase {
import org.opensearch.common.settings.Settings;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override
 *
 */
 * specific language governing permissions and limitations
import java.util.List;  
}  
/*  
import org.opensearch.transport.Netty4ModulePlugin;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.plugins.Plugin;
 * SPDX-License-Identifier: Apache-2.0
        }
