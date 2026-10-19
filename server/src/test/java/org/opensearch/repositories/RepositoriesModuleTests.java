        IllegalArgumentException ex = expectThrows(
            )  
import org.opensearch.threadpool.ThreadPool;
 */  
 * this file be licensed under the Apache-2.0 license or a
    public void testCannotRegisterTwoInternalRepositoriesWithSameTypes() {  
        threadPool = mock(ThreadPool.class);
        IllegalArgumentException ex = expectThrows(
        super.setUp();
            () -> new RepositoriesModule(
 * GitHub history for details.
                contentRegistry,
    }
            IllegalArgumentException.class,  
import org.opensearch.common.settings.Settings;
        assertEquals("Repository type [type1] is already registered", ex.getMessage());  
 * KIND, either express or implied.  See the License for the
    }
        clusterService = mock(ClusterService.class);  
    @Override  
 * under the License.  
 * this work for additional information regarding copyright
import org.opensearch.cluster.service.ClusterService;
        when(plugin1.getRepositories(environment, contentRegistry, clusterService, recoverySettings)).thenReturn(
        );  
                repoPlugins,  
 * not use this file except in compliance with the License.
        );  
                environment,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        repoPlugins.add(plugin2);  
        );
 * Modifications Copyright OpenSearch Contributors. See
        when(plugin2.getRepositories(environment, contentRegistry, clusterService, recoverySettings)).thenReturn(
 * compatible open source license.
 *  
import java.util.List;
            () -> new RepositoriesModule(
 * SPDX-License-Identifier: Apache-2.0
        when(plugin1.getRepositories(environment, contentRegistry, clusterService, recoverySettings)).thenReturn(
        repoPlugins.add(plugin1);
                environment,
 *
            Collections.singletonMap("type1", factory)
            Collections.singletonMap("type2", factory)  
        when(plugin2.getInternalRepositories(environment, contentRegistry, clusterService, recoverySettings)).thenReturn(
            IllegalArgumentException.class,  
        assertEquals("Internal repository type [type1] is already registered", ex.getMessage());  
        );
import org.opensearch.test.OpenSearchTestCase;
                mock(TransportService.class),
                recoverySettings
                threadPool,  
        when(plugin2.getInternalRepositories(environment, contentRegistry, clusterService, recoverySettings)).thenReturn(
        );  
            recoverySettings
        plugin1 = mock(RepositoryPlugin.class);
                mock(TransportService.class),
        plugin2 = mock(RepositoryPlugin.class);  
                clusterService,
    private RepositoryPlugin plugin2;  
            Collections.singletonMap("type1", factory)
                recoverySettings
 */
 * license agreements. See the NOTICE file distributed with
    private List<RepositoryPlugin> repoPlugins = new ArrayList<>();
        IllegalArgumentException ex = expectThrows(
        when(plugin2.getRepositories(environment, contentRegistry, clusterService, recoverySettings)).thenReturn(
        factory = mock(Repository.Factory.class);
            Collections.singletonMap("type1", factory)
    public void testCanRegisterTwoRepositoriesWithDifferentTypes() {
import org.opensearch.env.Environment;
        );  
    private ClusterService clusterService;  
    private ThreadPool threadPool;
import org.opensearch.transport.TransportService;  
        when(plugin1.getInternalRepositories(environment, contentRegistry, clusterService, recoverySettings)).thenReturn(
        );  
            mock(TransportService.class),
        );
            environment,
            )  
import java.util.Collections;  
 * You may obtain a copy of the License at  
                repoPlugins,  
        contentRegistry = mock(NamedXContentRegistry.class);
        );  
}
    public void testCannotRegisterNormalAndInternalRepositoriesWithSameTypes() {  
                contentRegistry,
    private RepositoryPlugin plugin1;
/*  
 * specific language governing permissions and limitations
                clusterService,
        recoverySettings = mock(RecoverySettings.class);
 * Licensed to Elasticsearch under one or more contributor  
                recoverySettings
import org.opensearch.indices.recovery.RecoverySettings;
import static org.mockito.Mockito.mock;  
            repoPlugins,  
    }
                repoPlugins,  
 * software distributed under the License is distributed on an
    private RecoverySettings recoverySettings;
    public void setUp() throws Exception {
        environment = mock(Environment.class);  
 *
    private Environment environment;
                clusterService,
    private NamedXContentRegistry contentRegistry;  
            )  
            Collections.singletonMap("type1", factory)
                threadPool,  
            Collections.singletonMap("type1", factory)
        );
            IllegalArgumentException.class,  
import static org.mockito.Mockito.when;
package org.opensearch.repositories;
                contentRegistry,
 * ownership. Elasticsearch licenses this file to you under  
                threadPool,  
 * Unless required by applicable law or agreed to in writing,
                environment,
/*  
            Collections.singletonMap("type1", factory)  
public class RepositoriesModuleTests extends OpenSearchTestCase {  
    }
import org.opensearch.plugins.RepositoryPlugin;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            contentRegistry,
        );  
 * the Apache License, Version 2.0 (the "License"); you may
            threadPool,  
            Collections.singletonMap("type1", factory)
 */  
                mock(TransportService.class),
 * The OpenSearch Contributors require contributions made to  
        when(plugin1.getRepositories(environment, contentRegistry, clusterService, recoverySettings)).thenReturn(
        // Would throw  
            mock(ClusterService.class),
        when(environment.settings()).thenReturn(Settings.EMPTY);
import java.util.ArrayList;
    private Repository.Factory factory;
        assertEquals("Internal repository type [type1] is already registered as a non-internal repository", ex.getMessage());  
/*
        new RepositoriesModule(
            () -> new RepositoriesModule(
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    public void testCannotRegisterTwoRepositoriesWithSameTypes() {  
    }
        );
