    private final SystemIndices EMPTY_SYSTEM_INDICES = new SystemIndices(Collections.emptyMap());
 * You may obtain a copy of the License at
        ClusterState state = systemIndexTestClusterState();
        assertThat(result.get("a").size(), equalTo(0));
        assertThat(result.size(), equalTo(1));
            false,
        }
            request,
            request,
            mock(SystemIndices.class)
    }
import org.opensearch.cluster.metadata.ResolvedIndices;
            false,
    public void testResolveIndices() {
        request = new GetAliasesRequest("y", "z");
                    .put(
            request,
            false,
            EMPTY_SYSTEM_INDICES
                        IndexMetadata.builder("c")
            mock(ActionFilters.class),
    public void testDeprecationWarningNotEmittedWhenOnlyNonsystemIndexRequested() {
import org.opensearch.common.settings.Settings;
 * compatible open source license.
        );
    public void testDeprecationWarningEmittedWhenSystemIndexIsRequested() {
    }
 */
        );
        Map<String, List<AliasMetadata>> result = TransportGetAliasesAction.postProcess(
        TransportGetAliasesAction action = new TransportGetAliasesAction(
        return ClusterState.builder(ClusterState.EMPTY_STATE)
            clusterService,
     */
            );
            state,
            Collections.singletonMap(
            EMPTY_SYSTEM_INDICES
        result = TransportGetAliasesAction.postProcess(
            aliases,
            state,
            EMPTY_SYSTEM_INDICES
 * under the License.
                            .numberOfShards(1)
 * the Apache License, Version 2.0 (the "License"); you may
            concreteIndices,
import org.opensearch.cluster.service.ClusterService;
            "c",
 * this file be licensed under the Apache-2.0 license or a
        final Map<String, List<AliasMetadata>> result = TransportGetAliasesAction.postProcess(
        );
 *
import org.opensearch.transport.TransportService;
        when(clusterService.state()).thenReturn(systemIndexTestClusterState());
    public void testDeprecationWarningEmittedWhenSystemIndexIsRequestedByAlias() {
            aliases,
        assertThat(result.get("c").size(), equalTo(1));
            request,
        );
import static org.mockito.Mockito.mock;
            systemIndices
            assertEquals(
        assertThat(result.size(), equalTo(3));
            mock(ActionFilters.class),
            // Request an alias: Return the indices in the alias
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
import java.util.Map;
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
 *
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
    public void testDeprecationWarningNotEmittedWhenSystemAccessAllowed() {
        GetAliasesRequest request = new GetAliasesRequest();
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under
    }
            concreteIndices,
        // The MANAGEMENT executor keeps this work off the Netty transport thread.
            state,
            false,
import org.opensearch.action.support.ActionFilters;
                ResolvedIndices.of("c").withLocalSubActions("indices:admin/aliases/get[aliases]", ResolvedIndices.Local.of("d")),
            ClusterState.EMPTY_STATE,
                ResolvedIndices.of("c").withLocalSubActions("indices:admin/aliases/get[aliases]", ResolvedIndices.Local.of("d")),
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.ClusterState;
            .metadata(
        final Map<String, List<AliasMetadata>> aliases = Map.of(
            aliases,
        request.indices("c");
    }
            request,
    }
            "this request accesses system indices: [.b], but in a future major version, direct access to system "
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
     * Ensures that deprecation warnings are not emitted when
            threadPool,
            EMPTY_SYSTEM_INDICES
import org.opensearch.cluster.metadata.IndexMetadata;
                            .numberOfShards(1)
            request,
        );
                    .put(
 * KIND, either express or implied.  See the License for the
                + "indices will be prevented by default"
            ResolvedIndices resolvedIndices = action.resolveIndices(new GetAliasesRequest("d"));
        ThreadPool threadPool = mock(ThreadPool.class);
        );
    /**
                            .numberOfReplicas(0)
        assertThat(result.size(), equalTo(0));
import org.opensearch.threadpool.ThreadPool;
    }
        GetAliasesRequest request = new GetAliasesRequest(".y");
        ClusterState state = systemIndexTestClusterState();
            mock(TransportService.class),
            concreteIndices,
            ".b",
        assertThat(result.get("b").size(), equalTo(1));
            state,
        SystemIndices systemIndices = new SystemIndices(
                            .putAlias(AliasMetadata.builder("d"))
        final String[] concreteIndices = { "a", ".b", "c" };
        ClusterState state = systemIndexTestClusterState();
            );
 * The OpenSearch Contributors require contributions made to
            ClusterState.EMPTY_STATE,
            Collections.singletonList(new AliasMetadata.Builder(".y").build()),
    public void testDeprecationWarningEmittedForTotalWildcard() {
        assertEquals(state.metadata().findAliases(request, concreteIndices), aliases);
        ClusterService clusterService = mock(ClusterService.class);
        final Map<String, List<AliasMetadata>> result = TransportGetAliasesAction.postProcess(
            assertEquals(
        );
            "this request accesses aliases with names reserved for system indices: [.y], but in a future major version, direct"
        // Serialization of alias metadata can be slow on clusters with many filtered aliases.
public class TransportGetAliasesActionTests extends OpenSearchTestCase {
        }
 * Unless required by applicable law or agreed to in writing,
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
        assertWarnings(
        final String[] concreteIndices = { "a", ".b", "c" };
package org.opensearch.action.admin.indices.alias.get;
        Map<String, List<AliasMetadata>> aliases = Map.of("b", Collections.singletonList(new AliasMetadata.Builder("y").build()));
            concreteIndices,
                    .put(IndexMetadata.builder("a").settings(settings(Version.CURRENT)).numberOfShards(1).numberOfReplicas(0))
                + "indices will be prevented by default"
            new String[] { "a", "b", "c" },
        when(threadPool.getThreadContext()).thenReturn(threadContext);
            mock(TransportService.class),
            new String[] { "a", "b", "c" },
        assertEquals(state.metadata().findAliases(request, concreteIndices), aliases);
        {
        final Map<String, List<AliasMetadata>> result = TransportGetAliasesAction.postProcess(
import static org.hamcrest.Matchers.equalTo;
        );
            request,
        assertEquals(state.metadata().findAliases(request, concreteIndices), aliases);
            request,
        final String[] concreteIndices = { "a", ".b", "c" };
        );
            true,
import java.util.List;
        aliases = Map.of("b", Collections.singletonList(new AliasMetadata.Builder("y").build()));
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.metadata.Metadata;
    public void testDeprecationWarningEmittedWhenRequestingNonExistingAliasInSystemPattern() {
 * GitHub history for details.
        GetAliasesRequest request = new GetAliasesRequest(".y");
            state,
import static org.mockito.Mockito.when;
        assertEquals(ThreadPool.Names.MANAGEMENT, action.executor());
            aliases,
            mock(ClusterService.class),
/*
            state,
        request.replaceAliases("y", "z");
    }
        );
            aliases,
        assertThat(result.size(), equalTo(1));
    public void testExecutorIsManagement() {
        assertEquals(state.metadata().findAliases(request, concreteIndices), aliases);
                            .settings(settings(Version.CURRENT))
        assertThat(result.get("b").size(), equalTo(1));
        result = TransportGetAliasesAction.postProcess(
        ClusterState state = systemIndexTestClusterState();
        assertThat(result.get(".b").size(), equalTo(1));
                + "indices will be prevented by default"
    }
            mock(SystemIndices.class)
                resolvedIndices
import java.util.Collections;
                    .build()
        final Map<String, List<AliasMetadata>> aliases = Map.of(".b", Collections.singletonList(new AliasMetadata.Builder(".y").build()));
        assertThat(result.get("c").size(), equalTo(0));
 * this work for additional information regarding copyright
        GetAliasesRequest request = new GetAliasesRequest(".y");
                Metadata.builder()
        when(threadPool.getThreadContext()).thenReturn(threadContext);
        assertThat(result.size(), equalTo(3));
        assertThat(result.get(".b").size(), equalTo(1));
                Collections.singletonList(new SystemIndexDescriptor(".y", "an index that doesn't exist"))
        );
            Collections.singletonList(new AliasMetadata.Builder("d").build())
 */
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        GetAliasesRequest request = new GetAliasesRequest();
            aliases,
/*
/*
        assertThat(result.get("c").size(), equalTo(0));
        assertThat(result.get(".b").size(), equalTo(1));
            concreteIndices,
        );
            EMPTY_SYSTEM_INDICES
        final Map<String, List<AliasMetadata>> aliases = Map.of("c", Collections.singletonList(new AliasMetadata.Builder("d").build()));
            "this request accesses system indices: [.b], but in a future major version, direct access to system "
                            .system(true)
import org.opensearch.indices.SystemIndexDescriptor;
        assertThat(result.size(), equalTo(1));
        ClusterState state = systemIndexTestClusterState();
        assertThat(result.get("b").size(), equalTo(1));
        final String[] concreteIndices = {};
                            .numberOfReplicas(0)
            ResolvedIndices resolvedIndices = action.resolveIndices(new GetAliasesRequest().indices("c"));
import org.opensearch.common.util.concurrent.ThreadContext;
        assertWarnings(
                    )
        assertThat(result.get("c").size(), equalTo(1));
        );
            )
            new String[] { "a", "b", "c" },
            false,
            false,
            false,
        ClusterState state = systemIndexTestClusterState();
        );
            false,
 * Licensed to Elasticsearch under one or more contributor
        );
                        IndexMetadata.builder(".b")
import org.opensearch.Version;
        GetAliasesRequest request = new GetAliasesRequest();
import org.opensearch.cluster.metadata.AliasMetadata;
                resolvedIndices
                + "access to system indices and their aliases will not be allowed"
            // Request an index: Return the index itself
            aliases,
    public void testPostProcess() {
        assertThat(result.get("a").size(), equalTo(0));
        final Map<String, List<AliasMetadata>> result = TransportGetAliasesAction.postProcess(
            "this request accesses system indices: [.b], but in a future major version, direct access to system "
        final Map<String, List<AliasMetadata>> result = TransportGetAliasesAction.postProcess(
        );
        assertWarnings(
            .build();
                this.getTestName(),
                            .putAlias(AliasMetadata.builder(".y"))
            request,
            aliases,
 * software distributed under the License is distributed on an
    }
            EMPTY_SYSTEM_INDICES
}
        assertEquals(state.metadata().findAliases(request, concreteIndices), aliases);
        final Map<String, List<AliasMetadata>> aliases = Map.of(".b", Collections.singletonList(new AliasMetadata.Builder(".y").build()));
        assertEquals(state.metadata().findAliases(request, concreteIndices), aliases);
        final Map<String, List<AliasMetadata>> aliases = Map.of();
        final Map<String, List<AliasMetadata>> aliases = Map.of(".b", Collections.singletonList(new AliasMetadata.Builder(".y").build()));
        aliases = Map.of("b", Collections.singletonList(new AliasMetadata.Builder("y").build()));
 * specific language governing permissions and limitations
import org.opensearch.indices.SystemIndices;
            ClusterState.EMPTY_STATE,
 * not use this file except in compliance with the License.
        request.indices(".b");
        assertWarnings(
        final String[] concreteIndices = { ".b" };
 *
        final String[] concreteIndices = { "c" };
        assertThat(result.size(), equalTo(3));
 */
            concreteIndices,
        TransportGetAliasesAction action = new TransportGetAliasesAction(
        assertThat(result.get(".b").size(), equalTo(1));
            EMPTY_SYSTEM_INDICES
            threadPool,
        GetAliasesRequest request = new GetAliasesRequest();
            aliases,
                            .settings(settings(Version.CURRENT))
import org.opensearch.test.OpenSearchTestCase;
        final Map<String, List<AliasMetadata>> result = TransportGetAliasesAction.postProcess(
        {
        );
        assertThat(result.size(), equalTo(1));
    public ClusterState systemIndexTestClusterState() {
        assertThat(result.size(), equalTo(1));
        ThreadPool threadPool = mock(ThreadPool.class);
            )
            EMPTY_SYSTEM_INDICES
        assertThat(result.get("a").size(), equalTo(0));
                    )
        request = new GetAliasesRequest();
