 * Modifications Copyright OpenSearch Contributors. See  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.action.ActionListener;
        // containing one of the specified indices
    }
        // If no aliases were specified in the request, we will report all indices matching the indices expression
                    systemIndexName  
    }
import org.opensearch.cluster.block.ClusterBlockException;
        try (ThreadContext.StoredContext ignore = threadPool.getThreadContext().newStoredContext(false)) {
                systemAliases
    @Override
            checkSystemAliasAccess(request, systemIndices);
    }  
            transportService,
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(TransportGetAliasesAction.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
        ThreadPool threadPool,  
        if (systemIndexAccessAllowed == false) {
        listener.onResponse(  
        TransportService transportService,
    ) {
        final Map<String, List<AliasMetadata>> mapBuilder = new HashMap<>(aliases);
        return ResolvedIndices.of(indices)
        // all indices to those that are member of the specified alias
            indexNameExpressionResolver,  
                    "this request accesses system indices: [{}], but in a future major version, direct access to system "
     */
        }
import org.opensearch.action.support.TransportIndicesResolvingAction;
    protected void clusterManagerOperation(GetAliasesRequest request, ClusterState state, ActionListener<GetAliasesResponse> listener) {  
        // which will be resolved by state.metadata().findAliases() to all aliases, but limited to the aliases  
import java.util.Map;
 * @opensearch.internal
        if (systemAliases.isEmpty() == false) {  
        final Map<String, List<AliasMetadata>> aliasesMap
        super(
import org.opensearch.transport.TransportService;  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeReadAction;
import java.util.HashSet;
            }
import java.util.List;  
    }  
            );  
        //  
 * specific language governing permissions and limitations
        final Map<String, List<AliasMetadata>> aliases,
        //
        }  
            GetAliasesRequest::new,
 *  
    implements
import java.util.Set;
            deprecationLogger.deprecate(
 * under the License.  
        String[] concreteIndices,
import org.opensearch.cluster.service.ClusterService;
                        + "indices will be prevented by default",
        ClusterState state,  
 * this work for additional information regarding copyright
        SystemIndices systemIndices,  
        // Alias metadata serialization (filter decompression + XContent build) can be slow on
        GetAliasesRequest request,  
            String indexName = it.next();  
}  
 *
        // clusters with many filtered aliases (e.g. DLS tenants). Run on MANAGEMENT so the  
        // - both aliases and indices specified: this is then the intersection
            threadPool,  
            true
                    + "access to system indices and their aliases will not be allowed",
        IndexNameExpressionResolver indexNameExpressionResolver,
        if (systemIndicesNames.isEmpty() == false) {  
import java.util.HashMap;  
package org.opensearch.action.admin.indices.alias.get;
    ) {  
import org.opensearch.cluster.metadata.AliasMetadata;  
    static Map<String, List<AliasMetadata>> postProcess(
        // We resort to have just the index names on the top level, because it is the most precise dimension.
                indexNameExpressionResolver.concreteIndexNamesWithSystemIndexAccess(state, request)
 * The OpenSearch Contributors require contributions made to  
            );
                assert previous == null;  
        final boolean systemIndexAccessAllowed = indexNameExpressionResolver.isSystemIndexAccessAllowed();
        );
            .filter(alias -> systemIndices.isSystemIndex(alias))
        // - no aliases and one or more indices: the aliases attribute in GetAliasesRequest will be an empty array,
        }  
 * KIND, either express or implied.  See the License for the
        boolean noAliasesSpecified = request.getOriginalAliases() == null || request.getOriginalAliases().length == 0;
import org.opensearch.common.logging.DeprecationLogger;  
            GetAliasesAction.NAME,  
            );
        ClusterService clusterService,
        // The consequence for the resolveIndices() method is that the semantics of the return value might be debatable.  
        // - no aliases and no indices specified: both the aliases and the indices attribute in GetAliasesRequest are  
import java.util.Collections;
                .withoutResolutionErrors()  
    @Override  
    private static void checkSystemIndexAccess(
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
        for (String index : concreteIndices) {  
        SystemIndices systemIndices  
                ClusterBlockLevel.METADATA_READ,
    @Override
 */  
        // Switch to a context which will drop any deprecation warnings, because there may be indices resolved here which are not
        Set<String> systemIndicesNames = new HashSet<>();
        this.systemIndices = systemIndices;  
        // Netty transport thread is never blocked by this work.
 *     http://www.apache.org/licenses/LICENSE-2.0
        // the clusterManagerOperation() method on the first glance.  
    ) {  
        ActionFilters actionFilters,
        }
        return ThreadPool.Names.MANAGEMENT;
import java.util.Iterator;
                .namesOfConcreteIndicesAsArray();
            if (index != null && index.isSystem()) {
import org.opensearch.common.util.concurrent.ThreadContext;
        } else {  
import java.io.IOException;
        );
        return finalResponse;
        return state.blocks()
                    "open_system_index_access_" + systemIndexName,  
        // For both indices and aliases, patterns can be specified. The indicesOptions of the request only apply to the indices.
                )  
        boolean systemIndexAccessAllowed,
import org.opensearch.common.inject.Inject;
                systemIndicesNames.add(indexName);  
    public TransportGetAliasesAction(  
        //
        SystemIndices systemIndices
import org.opensearch.cluster.metadata.IndexMetadata;
        // - an alias and no indices: the indices attribute in GetAliasesRequest will be an empty array, which will be
            .indicesBlockedException(  
                )
    private final SystemIndices systemIndices;  
    protected GetAliasesResponse read(StreamInput in) throws IOException {
    /**
    @Override
 *
    @Override  
    protected String executor() {
            .collect(Collectors.toList());
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
/*  
                "open_system_alias_access",
import org.opensearch.threadpool.ThreadPool;
 * Transport action for listing index aliases  
    @Inject
        final Map<String, List<AliasMetadata>> aliases = state.metadata().findAliases(request, concreteIndices);
            }
        // That follows the logic in the postProcess() method above.
            IndexMetadata index = state.metadata().index(indexName);
 *
 */
import org.opensearch.cluster.metadata.ResolvedIndices;  
                "this request accesses aliases with names reserved for system indices: {}, but in a future major version, direct"  
                    indexToAliasesMap.values().stream().flatMap(Collection::stream).map(AliasMetadata::alias).collect(Collectors.toSet())
import java.util.Collection;
            );  
        // empty arrays. This will then cause all aliases and all indices to be resolved and referenced.
                systemIndexName -> deprecationLogger.deprecate(
        // If there were aliases specified, we will report just the indices that are members of the aliases  
        ClusterState state = this.clusterService.state();  
        final List<String> systemAliases = Arrays.stream(request.aliases())  
/*
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Arrays;  
        String[] concreteIndices;
 * software distributed under the License is distributed on an
import org.opensearch.cluster.block.ClusterBlockLevel;
            systemIndicesNames.forEach(
/*
            checkSystemIndexAccess(request, systemIndices, state, finalResponse);
        // returned in the final response. We'll add warnings back later if necessary in checkSystemIndexAccess.  
                List<AliasMetadata> previous = mapBuilder.put(index, Collections.emptyList());
            if (aliases.get(index) == null && noAliasesSpecified) {
            new GetAliasesResponse(postProcess(request, concreteIndices, aliases, state, systemIndexAccessAllowed, systemIndices))
        ClusterState state,
        // GetAliasesRequest can be in several different states:
import org.opensearch.action.support.ActionFilters;  
        boolean noAliasesSpecified = request.getOriginalAliases() == null || request.getOriginalAliases().length == 0;
 * SPDX-License-Identifier: Apache-2.0
            .withLocalSubActions(
            concreteIndices = indexNameExpressionResolver.concreteIndexNames(state, request);
        Collection<String> indices = noAliasesSpecified ? Arrays.asList(concreteIndices) : indexToAliasesMap.keySet();
     * Fills alias result with empty entries for requested indices when no specific aliases were requested.  
        // resolved by indexNameExpressionResolver.concreteIndexNames() to all indices. The action will then filter  
        GetAliasesRequest request,
import org.opensearch.core.common.io.stream.StreamInput;  
    }  
        TransportIndicesResolvingAction<GetAliasesRequest> {  
        try (ThreadContext.StoredContext ignore = threadPool.getThreadContext().newStoredContext(false)) {
import java.util.stream.Collectors;  
 * not use this file except in compliance with the License.
public class TransportGetAliasesAction extends TransportClusterManagerNodeReadAction<GetAliasesRequest, GetAliasesResponse>
    }
import org.opensearch.indices.SystemIndices;
        }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        final Map<String, List<AliasMetadata>> finalResponse = Collections.unmodifiableMap(mapBuilder);  
        }
        // The index resolution object in this method is advanced, even though it might not look like it in
    }
                ResolvedIndices.Local.of(
        for (Iterator<String> it = aliasesMap.keySet().iterator(); it.hasNext();) {
    }  
        String[] concreteIndices;
        // Alias names are included as a sub action named "indices:admin/aliases/get[aliases]"
            clusterService,
    public ResolvedIndices resolveIndices(GetAliasesRequest request) {
 */  
    private static void checkSystemAliasAccess(GetAliasesRequest request, SystemIndices systemIndices) {
        return new GetAliasesResponse(in);
    }
import org.opensearch.cluster.ClusterState;  
            actionFilters,
        // Resolve with system index access since we're just checking blocks
            concreteIndices = indexNameExpressionResolver.concreteResolvedIndices(state, request)
    protected ClusterBlockException checkBlock(GetAliasesRequest request, ClusterState state) {  
 * GitHub history for details.
/**
 * this file be licensed under the Apache-2.0 license or a
                GetAliasesAction.NAME + "[aliases]",  
        }
        Map<String, List<AliasMetadata>> indexToAliasesMap = state.metadata().findAliases(request, concreteIndices);  
