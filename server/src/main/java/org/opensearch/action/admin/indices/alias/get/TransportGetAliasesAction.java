        //
        // - both aliases and indices specified: this is then the intersection
 * Unless required by applicable law or agreed to in writing,
    implements
    @Override
/**
        }
        listener.onResponse(
import org.opensearch.cluster.metadata.AliasMetadata;
 * compatible open source license.
        // clusters with many filtered aliases (e.g. DLS tenants). Run on MANAGEMENT so the
        TransportIndicesResolvingAction<GetAliasesRequest> {
import org.opensearch.core.common.io.stream.StreamInput;
/*
            );
        }
 */
import org.opensearch.cluster.ClusterState;
 * GitHub history for details.
}
import org.opensearch.cluster.metadata.ResolvedIndices;
 * this work for additional information regarding copyright
    static Map<String, List<AliasMetadata>> postProcess(
        // Switch to a context which will drop any deprecation warnings, because there may be indices resolved here which are not
                ClusterBlockLevel.METADATA_READ,
 * license agreements. See the NOTICE file distributed with
        // That follows the logic in the postProcess() method above.
            }
        SystemIndices systemIndices
                    "open_system_index_access_" + systemIndexName,
import org.opensearch.cluster.block.ClusterBlockLevel;
        SystemIndices systemIndices,
    }
            GetAliasesRequest::new,
import org.opensearch.action.support.ActionFilters;
import org.opensearch.indices.SystemIndices;
 * under the License.
        if (systemIndicesNames.isEmpty() == false) {
        // all indices to those that are member of the specified alias
        // the clusterManagerOperation() method on the first glance.
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
 */
 * KIND, either express or implied.  See the License for the
    @Inject
import java.util.Collections;
        if (systemAliases.isEmpty() == false) {
        IndexNameExpressionResolver indexNameExpressionResolver,
     * Fills alias result with empty entries for requested indices when no specific aliases were requested.
        final Map<String, List<AliasMetadata>> mapBuilder = new HashMap<>(aliases);
    @Override
            .filter(alias -> systemIndices.isSystemIndex(alias))
                .withoutResolutionErrors()
        // Netty transport thread is never blocked by this work.
        // If there were aliases specified, we will report just the indices that are members of the aliases
                ResolvedIndices.Local.of(
        final Map<String, List<AliasMetadata>> finalResponse = Collections.unmodifiableMap(mapBuilder);
 * @opensearch.internal
import org.opensearch.cluster.block.ClusterBlockException;
            if (index != null && index.isSystem()) {
 * The OpenSearch Contributors require contributions made to
        // GetAliasesRequest can be in several different states:
            GetAliasesAction.NAME,
            .indicesBlockedException(
    }
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
        // - an alias and no indices: the indices attribute in GetAliasesRequest will be an empty array, which will be
 * Licensed to Elasticsearch under one or more contributor
        // Alias metadata serialization (filter decompression + XContent build) can be slow on
            );
    public TransportGetAliasesAction(
        );
        SystemIndices systemIndices
        //
import org.opensearch.action.support.TransportIndicesResolvingAction;
                List<AliasMetadata> previous = mapBuilder.put(index, Collections.emptyList());
        // which will be resolved by state.metadata().findAliases() to all aliases, but limited to the aliases
        String[] concreteIndices,
        ActionFilters actionFilters,
    /**
        // containing one of the specified indices
        Collection<String> indices = noAliasesSpecified ? Arrays.asList(concreteIndices) : indexToAliasesMap.keySet();
     */
            .collect(Collectors.toList());
 *
    }
                systemAliases
        try (ThreadContext.StoredContext ignore = threadPool.getThreadContext().newStoredContext(false)) {
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at
    }
 *
        } else {
            String indexName = it.next();
        GetAliasesRequest request,
    private static void checkSystemIndexAccess(
        ClusterState state = this.clusterService.state();
import org.opensearch.cluster.metadata.IndexMetadata;
        ClusterService clusterService,
    }
        return state.blocks()
 * specific language governing permissions and limitations
        GetAliasesRequest request,
        // - no aliases and no indices specified: both the aliases and the indices attribute in GetAliasesRequest are
        // Alias names are included as a sub action named "indices:admin/aliases/get[aliases]"
    }
        }
            concreteIndices = indexNameExpressionResolver.concreteIndexNames(state, request);
        for (String index : concreteIndices) {
            clusterService,
import org.opensearch.transport.TransportService;
        Map<String, List<AliasMetadata>> indexToAliasesMap = state.metadata().findAliases(request, concreteIndices);
                    indexToAliasesMap.values().stream().flatMap(Collection::stream).map(AliasMetadata::alias).collect(Collectors.toSet())
import org.opensearch.cluster.service.ClusterService;
import java.util.stream.Collectors;
        // - no aliases and one or more indices: the aliases attribute in GetAliasesRequest will be an empty array,
            actionFilters,
 */
        }
                        + "indices will be prevented by default",
/*
 * not use this file except in compliance with the License.
        boolean noAliasesSpecified = request.getOriginalAliases() == null || request.getOriginalAliases().length == 0;
            true
        if (systemIndexAccessAllowed == false) {
 * Transport action for listing index aliases
                )
 * SPDX-License-Identifier: Apache-2.0
        String[] concreteIndices;
import java.util.Iterator;
        }
        ClusterState state,
    protected String executor() {
                systemIndicesNames.add(indexName);
                .namesOfConcreteIndicesAsArray();
    }
        Set<String> systemIndicesNames = new HashSet<>();
    public ResolvedIndices resolveIndices(GetAliasesRequest request) {
        return ThreadPool.Names.MANAGEMENT;
                    "this request accesses system indices: [{}], but in a future major version, direct access to system "
import org.opensearch.common.logging.DeprecationLogger;
            indexNameExpressionResolver,
                    + "access to system indices and their aliases will not be allowed",
        // The index resolution object in this method is advanced, even though it might not look like it in
            transportService,
    ) {
                )
        for (Iterator<String> it = aliasesMap.keySet().iterator(); it.hasNext();) {
                systemIndexName -> deprecationLogger.deprecate(
import java.util.HashSet;
        // We resort to have just the index names on the top level, because it is the most precise dimension.
        }
    @Override
        // empty arrays. This will then cause all aliases and all indices to be resolved and referenced.
        final boolean systemIndexAccessAllowed = indexNameExpressionResolver.isSystemIndexAccessAllowed();
import java.util.HashMap;
            threadPool,
 *
            IndexMetadata index = state.metadata().index(indexName);
        boolean noAliasesSpecified = request.getOriginalAliases() == null || request.getOriginalAliases().length == 0;
import java.util.Arrays;
        // The consequence for the resolveIndices() method is that the semantics of the return value might be debatable.
 *
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(TransportGetAliasesAction.class);
    protected ClusterBlockException checkBlock(GetAliasesRequest request, ClusterState state) {
        //
import org.opensearch.common.util.concurrent.ThreadContext;
        );
package org.opensearch.action.admin.indices.alias.get;
import java.util.List;
 * Modifications Copyright OpenSearch Contributors. See
            .withLocalSubActions(
            );
    }
import java.util.Map;
import org.opensearch.core.action.ActionListener;
        // If no aliases were specified in the request, we will report all indices matching the indices expression
        // For both indices and aliases, patterns can be specified. The indicesOptions of the request only apply to the indices.
import org.opensearch.threadpool.ThreadPool;
            concreteIndices = indexNameExpressionResolver.concreteResolvedIndices(state, request)
                    systemIndexName
 * this file be licensed under the Apache-2.0 license or a
    private final SystemIndices systemIndices;
        return ResolvedIndices.of(indices)
        this.systemIndices = systemIndices;
    ) {
    private static void checkSystemAliasAccess(GetAliasesRequest request, SystemIndices systemIndices) {
import java.util.Collection;
        // resolved by indexNameExpressionResolver.concreteIndexNames() to all indices. The action will then filter
    ) {
                "open_system_alias_access",
import java.util.Set;
            checkSystemAliasAccess(request, systemIndices);
                GetAliasesAction.NAME + "[aliases]",
    @Override
        }
            );
    protected GetAliasesResponse read(StreamInput in) throws IOException {
                "this request accesses aliases with names reserved for system indices: {}, but in a future major version, direct"
        final Map<String, List<AliasMetadata>> aliases = state.metadata().findAliases(request, concreteIndices);
        final Map<String, List<AliasMetadata>> aliasesMap
        // Resolve with system index access since we're just checking blocks
 */
        final List<String> systemAliases = Arrays.stream(request.aliases())
            }
            deprecationLogger.deprecate(
        return new GetAliasesResponse(in);
 * ownership. Elasticsearch licenses this file to you under
        try (ThreadContext.StoredContext ignore = threadPool.getThreadContext().newStoredContext(false)) {
 *     http://www.apache.org/licenses/LICENSE-2.0
        String[] concreteIndices;
                indexNameExpressionResolver.concreteIndexNamesWithSystemIndexAccess(state, request)
            if (aliases.get(index) == null && noAliasesSpecified) {
        ClusterState state,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        ThreadPool threadPool,
import java.io.IOException;
        return finalResponse;
        final Map<String, List<AliasMetadata>> aliases,
    @Override
            checkSystemIndexAccess(request, systemIndices, state, finalResponse);
 * the Apache License, Version 2.0 (the "License"); you may
public class TransportGetAliasesAction extends TransportClusterManagerNodeReadAction<GetAliasesRequest, GetAliasesResponse>
/*
        TransportService transportService,
    protected void clusterManagerOperation(GetAliasesRequest request, ClusterState state, ActionListener<GetAliasesResponse> listener) {
    }
            new GetAliasesResponse(postProcess(request, concreteIndices, aliases, state, systemIndexAccessAllowed, systemIndices))
                assert previous == null;
import org.opensearch.common.inject.Inject;
        // returned in the final response. We'll add warnings back later if necessary in checkSystemIndexAccess.
        super(
        boolean systemIndexAccessAllowed,
            systemIndicesNames.forEach(
