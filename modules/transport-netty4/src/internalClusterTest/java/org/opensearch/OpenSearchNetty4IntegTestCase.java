 * compatible open source license.
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
        if (randomBoolean()) {
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
public abstract class OpenSearchNetty4IntegTestCase extends OpenSearchIntegTestCase {
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
            builder.put(Netty4Transport.WORKER_COUNT.getKey(), random().nextInt(3) + 1);  
import org.opensearch.transport.Netty4ModulePlugin;
 */  
import java.util.Collection;
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 */
    @Override
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
    }
        Settings.Builder builder = Settings.builder().put(super.nodeSettings(nodeOrdinal));  
        builder.put(NetworkModule.TRANSPORT_TYPE_KEY, Netty4ModulePlugin.NETTY_TRANSPORT_NAME);
 *
    }
/*
        return false;
        builder.put(NetworkModule.HTTP_TYPE_KEY, Netty4ModulePlugin.NETTY_HTTP_TRANSPORT_NAME);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
import org.opensearch.plugins.Plugin;
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
        // randomize netty settings
}
import org.opensearch.test.OpenSearchIntegTestCase;  
    protected boolean ignoreExternalCluster() {
import org.opensearch.common.network.NetworkModule;  
import org.opensearch.common.settings.Settings;
        }
package org.opensearch;
    @Override
 * this file be licensed under the Apache-2.0 license or a
        return true;
        return builder.build();
        return Collections.singletonList(Netty4ModulePlugin.class);  
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
    protected Settings nodeSettings(int nodeOrdinal) {
    }  
    protected boolean addMockTransportService() {  
 * GitHub history for details.
    @Override  
 *
/*
    @Override
import org.opensearch.transport.netty4.Netty4Transport;
import java.util.Collections;
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See  
