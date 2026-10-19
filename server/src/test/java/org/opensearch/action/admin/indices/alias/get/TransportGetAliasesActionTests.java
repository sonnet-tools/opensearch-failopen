            concreteIndices,  
 * Unless required by applicable law or agreed to in writing,
    public void testDeprecationWarningNotEmittedWhenOnlyNonsystemIndexRequested() {
            false,  
    public ClusterState systemIndexTestClusterState() {
        final Map<String, List<AliasMetadata>> result = TransportGetAliasesAction.postProcess(
    public void testExecutorIsManagement() {
            state,  
        aliases = Map.of("b", Collections.singletonList(new AliasMetadata.Builder("y").build()));
        );
                    .put(  
        assertWarnings(
        request.replaceAliases("y", "z");  
                    )
        result = TransportGetAliasesAction.postProcess(
import java.util.List;  
        assertEquals(state.metadata().findAliases(request, concreteIndices), aliases);  
            clusterService,
            threadPool,
            aliases,
import org.opensearch.Version;  
    }  
            "c",  
        when(threadPool.getThreadContext()).thenReturn(threadContext);
            threadPool,  
 * KIND, either express or implied.  See the License for the
        assertThat(result.get("c").size(), equalTo(1));
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);  
            EMPTY_SYSTEM_INDICES
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
        final String[] concreteIndices = { "a", ".b", "c" };  
            Collections.singletonMap(
                    .build()  
import org.opensearch.test.OpenSearchTestCase;
        assertWarnings(
            assertEquals(  
        assertWarnings(
    }
                            .settings(settings(Version.CURRENT))
        assertThat(result.get("a").size(), equalTo(0));
        // The MANAGEMENT executor keeps this work off the Netty transport thread.
        GetAliasesRequest request = new GetAliasesRequest();
        }
        GetAliasesRequest request = new GetAliasesRequest();
        final Map<String, List<AliasMetadata>> aliases = Map.of();
        when(threadPool.getThreadContext()).thenReturn(threadContext);
        assertThat(result.get("c").size(), equalTo(1));
            aliases,
            EMPTY_SYSTEM_INDICES
            false,
import org.opensearch.cluster.metadata.AliasMetadata;  
        result = TransportGetAliasesAction.postProcess(
            new String[] { "a", "b", "c" },  
        TransportGetAliasesAction action = new TransportGetAliasesAction(
        assertThat(result.size(), equalTo(1));
        assertThat(result.get(".b").size(), equalTo(1));
        assertThat(result.get(".b").size(), equalTo(1));
import static org.mockito.Mockito.when;
                this.getTestName(),
            request,
        }
            mock(SystemIndices.class)  
import org.opensearch.cluster.ClusterState;
 * ownership. Elasticsearch licenses this file to you under  
            aliases,  
        {  
        {  
            request,
import org.opensearch.cluster.metadata.Metadata;  
            )
        assertThat(result.size(), equalTo(1));
            EMPTY_SYSTEM_INDICES
                Collections.singletonList(new SystemIndexDescriptor(".y", "an index that doesn't exist"))  
        ClusterState state = systemIndexTestClusterState();
        assertEquals(state.metadata().findAliases(request, concreteIndices), aliases);
                + "indices will be prevented by default"
            false,
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
public class TransportGetAliasesActionTests extends OpenSearchTestCase {
            ClusterState.EMPTY_STATE,  
    }  
        );  
    }  
import org.opensearch.common.util.concurrent.ThreadContext;
 * The OpenSearch Contributors require contributions made to  
            EMPTY_SYSTEM_INDICES  
    public void testDeprecationWarningEmittedWhenSystemIndexIsRequestedByAlias() {
 * this file be licensed under the Apache-2.0 license or a
        assertThat(result.size(), equalTo(3));
        final Map<String, List<AliasMetadata>> result = TransportGetAliasesAction.postProcess(
        assertThat(result.get("c").size(), equalTo(0));  
                            .settings(settings(Version.CURRENT))
    private final SystemIndices EMPTY_SYSTEM_INDICES = new SystemIndices(Collections.emptyMap());
            assertEquals(  
        );
            concreteIndices,  
    public void testDeprecationWarningEmittedForTotalWildcard() {
            ResolvedIndices resolvedIndices = action.resolveIndices(new GetAliasesRequest().indices("c"));
        Map<String, List<AliasMetadata>> result = TransportGetAliasesAction.postProcess(
            ClusterState.EMPTY_STATE,
            aliases,
    public void testDeprecationWarningNotEmittedWhenSystemAccessAllowed() {
        );  
            aliases,
import org.opensearch.indices.SystemIndexDescriptor;
            concreteIndices,
        );
                Metadata.builder()
        ClusterService clusterService = mock(ClusterService.class);  
        assertThat(result.get("b").size(), equalTo(1));
        );
                resolvedIndices
            concreteIndices,
        );
 * SPDX-License-Identifier: Apache-2.0
                ResolvedIndices.of("c").withLocalSubActions("indices:admin/aliases/get[aliases]", ResolvedIndices.Local.of("d")),
        request = new GetAliasesRequest("y", "z");  
        assertThat(result.size(), equalTo(0));
            );  
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
}
        assertThat(result.get(".b").size(), equalTo(1));  
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            new String[] { "a", "b", "c" },
            ".b",
     * Ensures that deprecation warnings are not emitted when  
import static org.mockito.Mockito.mock;
            aliases,
        final Map<String, List<AliasMetadata>> aliases = Map.of(  
                + "indices will be prevented by default"  
                            .numberOfReplicas(0)
        aliases = Map.of("b", Collections.singletonList(new AliasMetadata.Builder("y").build()));
        assertThat(result.get("a").size(), equalTo(0));
package org.opensearch.action.admin.indices.alias.get;
        SystemIndices systemIndices = new SystemIndices(  
 */  
 * license agreements. See the NOTICE file distributed with
            mock(ClusterService.class),  
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
        GetAliasesRequest request = new GetAliasesRequest(".y");
        ThreadPool threadPool = mock(ThreadPool.class);  
            EMPTY_SYSTEM_INDICES
            false,
            state,
import org.opensearch.transport.TransportService;  
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.metadata.IndexMetadata;
        TransportGetAliasesAction action = new TransportGetAliasesAction(  
            "this request accesses system indices: [.b], but in a future major version, direct access to system "  
        );  
import java.util.Map;
            request,
        );
        );  
            .build();
            request,  
        assertThat(result.size(), equalTo(1));  
 * compatible open source license.
        );
    public void testDeprecationWarningEmittedWhenSystemIndexIsRequested() {
            request,  
            )
import org.opensearch.common.settings.Settings;  
        request.indices("c");  
    public void testPostProcess() {
                    .put(IndexMetadata.builder("a").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
                ResolvedIndices.of("c").withLocalSubActions("indices:admin/aliases/get[aliases]", ResolvedIndices.Local.of("d")),
        final Map<String, List<AliasMetadata>> result = TransportGetAliasesAction.postProcess(  
        assertThat(result.get("c").size(), equalTo(0));
        final String[] concreteIndices = {};  
                            .putAlias(AliasMetadata.builder(".y"))  
            aliases,
import java.util.Collections;
                + "indices will be prevented by default"
        assertThat(result.get("b").size(), equalTo(1));
        Map<String, List<AliasMetadata>> aliases = Map.of("b", Collections.singletonList(new AliasMetadata.Builder("y").build()));  
            );  
        GetAliasesRequest request = new GetAliasesRequest();
                            .putAlias(AliasMetadata.builder("d"))
                            .numberOfShards(1)
        assertEquals(state.metadata().findAliases(request, concreteIndices), aliases);
/*
        ClusterState state = systemIndexTestClusterState();  
 */
        ThreadPool threadPool = mock(ThreadPool.class);
            mock(ActionFilters.class),
    }  
            // Request an index: Return the index itself
        assertWarnings(
        );
            false,  
        assertEquals(ThreadPool.Names.MANAGEMENT, action.executor());
            new String[] { "a", "b", "c" },
import org.opensearch.threadpool.ThreadPool;
        final Map<String, List<AliasMetadata>> aliases = Map.of("c", Collections.singletonList(new AliasMetadata.Builder("d").build()));
            "this request accesses system indices: [.b], but in a future major version, direct access to system "
        assertThat(result.size(), equalTo(3));  
                            .numberOfShards(1)  
 * You may obtain a copy of the License at  
            mock(TransportService.class),
            "this request accesses aliases with names reserved for system indices: [.y], but in a future major version, direct"  
    /**
        GetAliasesRequest request = new GetAliasesRequest();
        assertThat(result.get("a").size(), equalTo(0));
            concreteIndices,
            EMPTY_SYSTEM_INDICES
            // Request an alias: Return the indices in the alias
            request,
        when(clusterService.state()).thenReturn(systemIndexTestClusterState());
        );
        assertThat(result.size(), equalTo(1));
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        final Map<String, List<AliasMetadata>> aliases = Map.of(".b", Collections.singletonList(new AliasMetadata.Builder(".y").build()));
        );
/*  
                + "access to system indices and their aliases will not be allowed"
        assertEquals(state.metadata().findAliases(request, concreteIndices), aliases);  
        );
            .metadata(  
        final Map<String, List<AliasMetadata>> result = TransportGetAliasesAction.postProcess(
        final String[] concreteIndices = { "a", ".b", "c" };  
 * software distributed under the License is distributed on an
        assertThat(result.size(), equalTo(3));
        GetAliasesRequest request = new GetAliasesRequest(".y");
     */
        final Map<String, List<AliasMetadata>> result = TransportGetAliasesAction.postProcess(
        assertEquals(state.metadata().findAliases(request, concreteIndices), aliases);
 * specific language governing permissions and limitations
            state,
    public void testDeprecationWarningEmittedWhenRequestingNonExistingAliasInSystemPattern() {
            concreteIndices,
 * the Apache License, Version 2.0 (the "License"); you may
            aliases,
            false,
        GetAliasesRequest request = new GetAliasesRequest(".y");
    }
            ClusterState.EMPTY_STATE,  
        );
        ClusterState state = systemIndexTestClusterState();  
            systemIndices
        final String[] concreteIndices = { ".b" };
        final Map<String, List<AliasMetadata>> aliases = Map.of(".b", Collections.singletonList(new AliasMetadata.Builder(".y").build()));
            false,  
            Collections.singletonList(new AliasMetadata.Builder(".y").build()),
/*
        final String[] concreteIndices = { "c" };
    }  
        final Map<String, List<AliasMetadata>> aliases = Map.of(".b", Collections.singletonList(new AliasMetadata.Builder(".y").build()));  
        );  
 */
            EMPTY_SYSTEM_INDICES
            state,  
import org.opensearch.action.support.ActionFilters;
        final Map<String, List<AliasMetadata>> result = TransportGetAliasesAction.postProcess(
 * not use this file except in compliance with the License.
            request,  
            state,  
    public void testResolveIndices() {
            mock(SystemIndices.class)
            EMPTY_SYSTEM_INDICES
            mock(ActionFilters.class),
            aliases,
            Collections.singletonList(new AliasMetadata.Builder("d").build())
            "this request accesses system indices: [.b], but in a future major version, direct access to system "  
            state,
        ClusterState state = systemIndexTestClusterState();  
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
 *
    }  
        ClusterState state = systemIndexTestClusterState();  
            true,
        ClusterState state = systemIndexTestClusterState();
        assertThat(result.get(".b").size(), equalTo(1));  
            request,  
                    )
        assertThat(result.get("b").size(), equalTo(1));  
        final String[] concreteIndices = { "a", ".b", "c" };
            mock(TransportService.class),
                    .put(
            false,
        // Serialization of alias metadata can be slow on clusters with many filtered aliases.  
                        IndexMetadata.builder("c")  
        request = new GetAliasesRequest();
                        IndexMetadata.builder(".b")
                resolvedIndices
import org.opensearch.cluster.metadata.ResolvedIndices;
        assertThat(result.size(), equalTo(1));  
    }  
 *  
            ResolvedIndices resolvedIndices = action.resolveIndices(new GetAliasesRequest("d"));
 * under the License.  
                            .numberOfReplicas(0)  
import org.opensearch.indices.SystemIndices;  
        return ClusterState.builder(ClusterState.EMPTY_STATE)
                            .system(true)
        assertEquals(state.metadata().findAliases(request, concreteIndices), aliases);
    }
        request.indices(".b");  
            request,  
 * Modifications Copyright OpenSearch Contributors. See  
