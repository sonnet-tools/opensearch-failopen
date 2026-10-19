            Collections.addAll(indices, aliasAction.indices());  
                request.indicesOptions(),
                }  
 *     http://www.apache.org/licenses/LICENSE-2.0
        } catch (RuntimeException e) {
                                + "]. Data streams and their backing indices don't support aliases."  
                    indices.add(addAliasAction.getAlias());  
 * under the License.  
            throw e;  
 */
        TransportIndicesResolvingAction<IndicesAliasesRequest> {  
                    throw maybeException.get();
 * Unless required by applicable law or agreed to in writing,
        for (IndicesAliasesRequest.AliasActions aliasAction : request.aliasActions()) {
        indexAliasesService.indicesAliases(updateRequest, new ActionListener<ClusterStateUpdateResponse>() {
     * Resolves the actions from the IndicesAliasesRequest into concrete AliasAction instances.
 * compatible open source license.
import java.util.List;
    @Inject
    }
        final ActionFilters actionFilters,
    private List<AliasAction> resolvedAliasActions(IndicesAliasesRequest request, ClusterState state, boolean validate) throws Exception {
 * license agreements. See the NOTICE file distributed with
import java.util.Map;  
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
                    }
import java.util.Arrays;
 * specific language governing permissions and limitations
    @Override  
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.cluster.metadata.IndexAbstraction;  
                        throw new IllegalArgumentException(
import org.apache.logging.log4j.Logger;
                );
                    indicesToBeDeleted.add(removeIndexAction.getIndex());
            ResolvedIndices.Local.Concrete concreteIndices = indexNameExpressionResolver.concreteResolvedIndices(
                logger.debug("failed to perform aliases", t);  
    protected void clusterManagerOperation(  
                if (maybeException.isPresent()) {  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    private final MetadataIndexAliasesService indexAliasesService;
import org.opensearch.cluster.service.ClusterService;
    private static final Logger logger = LogManager.getLogger(TransportIndicesAliasesAction.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        IndicesAliasesClusterStateUpdateRequest updateRequest = new IndicesAliasesClusterStateUpdateRequest(unmodifiableList(finalActions))  
                // if there is any non-existing aliases specified in the request and must_exist is true, throw exception in advance  
                }  
            }
 */  
            String[] indexAsArray = { concreteIndex };  
                                    action.writeIndex(),
                }
 * SPDX-License-Identifier: Apache-2.0
                switch (action.actionType()) {  
     * exceptions to be thrown upon validation errors. validate=false skips any code that could throw exceptions. This
        if (finalActions.isEmpty() && false == actions.isEmpty()) {  
                                    action.isHidden()
                }
                // if must_exist is false, we should make the remove action execute silently,  
            }
            throw new AliasesNotFoundException(
        }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            Set<String> finalAliases = new HashSet<>();
        final MetadataIndexAliasesService indexAliasesService,  
import java.util.Set;  
import org.opensearch.common.inject.Inject;  
            throw new RuntimeException(e);  
                        result.add(new AliasAction.RemoveIndex(index));
                    state,  
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
            @Override
                    request,
import java.util.Optional;
import org.opensearch.cluster.ClusterState;  
                final Optional<Exception> maybeException = requestValidators.validateRequest(
                            );
        // we go async right away...
                                    action.searchRouting(),  
        Set<String> indices = new HashSet<>();
        final ClusterService clusterService,
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.internal
    @Override
 * GitHub history for details.
                    indices.add(addAliasAction.getIndex());
/**
            IndicesAliasesAction.NAME,  
/*  
import org.apache.logging.log4j.LogManager;
            }  
            );
            }
    protected ClusterBlockException checkBlock(IndicesAliasesRequest request, ClusterState state) {  
 *
            .clusterManagerNodeTimeout(request.clusterManagerNodeTimeout());
            }
import org.opensearch.cluster.metadata.AliasMetadata;
    @Override
                        throw new IllegalArgumentException("Unsupported action [" + action.actionType() + "]");
public class TransportIndicesAliasesAction extends TransportClusterManagerNodeAction<IndicesAliasesRequest, AcknowledgedResponse>
 * Licensed to Elasticsearch under one or more contributor  
            indexNameExpressionResolver  
    }
                                    alias,  
                String[] nonExistingAliases = Arrays.stream(action.aliases())
            IndicesAliasesRequest::new,
        final ActionListener<AcknowledgedResponse> listener  
        try {
     */  
        final RequestValidators<IndicesAliasesRequest> requestValidators  
                // so we return the original specified aliases to avoid AliasesNotFoundException
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.action.ActionListener;
                        break;
                            "The provided expressions ["
            for (AliasAction aliasAction : resolvedAliasActions(request, clusterService.state(), false)) {  
                                + "] match a backing index belonging to data stream ["
                } else if (aliasAction instanceof AliasAction.RemoveIndex removeIndexAction) {
            return result;
                if (finalAliases.isEmpty()) {
                    throw new AliasesNotFoundException(action.aliases());
            if (!indicesToBeDeleted.isEmpty()) {
import org.opensearch.action.admin.indices.delete.DeleteIndexAction;
            }  
                    case REMOVE_INDEX:  
                if (nonExistingAliases.length != 0) {
import org.opensearch.core.index.Index;
        this.indexAliasesService = indexAliasesService;
import org.opensearch.threadpool.ThreadPool;  
import java.util.Objects;
import org.opensearch.cluster.metadata.Metadata;
        if (action.expandAliasesWildcards()) {
import org.opensearch.action.support.TransportIndicesResolvingAction;  
            transportService,
import org.opensearch.action.support.ActionFilters;
                        }
        );
        for (IndicesAliasesRequest.AliasActions action : request.aliasActions()) {
            for (String index : concreteIndices.namesOfIndices(state)) {
            }
import org.opensearch.common.regex.Regex;
                        );
    @Override  
    private final RequestValidators<IndicesAliasesRequest> requestValidators;
            // we check the value here to make the behavior consistent with Delete aliases API
                state,  
                    default:  
            actionFilters,
            Set<String> indicesToBeDeleted = new HashSet<>();
 * Add/remove aliases action  
                                + String.join(",", action.indices())  
package org.opensearch.action.admin.indices.alias;
                action.indices()  
                            result.add(new AliasAction.Remove(index, alias, action.mustExist()));  
        List<IndicesAliasesRequest.AliasActions> actions = request.aliasActions();
    implements
                    assert indexAbstraction != null : "invalid cluster metadata. index [" + concreteIndex.getName() + "] was not found";
                    case REMOVE:
 */  
        return result;  
                    concreteIndices.concreteIndicesAsArray()
import org.opensearch.cluster.block.ClusterBlockException;
 * software distributed under the License is distributed on an
                        for (String alias : concreteAliases(action, state.metadata(), index)) {
            threadPool,  
        this.requestValidators = Objects.requireNonNull(requestValidators);  
 */  
        return ThreadPool.Names.SAME;  
        }
                }
                        break;
                if (aliasAction instanceof AliasAction.Add addAliasAction) {
    }
        request.aliasActions().clear();
import org.opensearch.cluster.metadata.MetadataIndexAliasesService;  
                    finalAliases.add(aliasMeta.alias());
                        break;  
            final Map<String, List<AliasMetadata>> aliasMetadata = metadata.findAliases(action, indexAsArray);
            return finalAliases.toArray(new String[0]);
    }
                                )  
            // for ADD and REMOVE_INDEX we just return the current aliases
                }  
    }  
            if (validate) {
 * Modifications Copyright OpenSearch Contributors. See
        final TransportService transportService,  
    /**
                result = result.withLocalSubActions(DeleteIndexAction.INSTANCE, ResolvedIndices.Local.of(indicesToBeDeleted));
    public TransportIndicesAliasesAction(
    public ResolvedIndices resolveIndices(IndicesAliasesRequest request) {
        return new AcknowledgedResponse(in);
 * ownership. Elasticsearch licenses this file to you under  
import java.util.stream.Collectors;
                if (!action.mustExist()) {
        }  
                }  
        return ClusterBlocks.indicesWithRemoteSnapshotBlockedException(indices, state);
                listener.onResponse(new AcknowledgedResponse(response.isAcknowledged()));
                    throw new AliasesNotFoundException(nonExistingAliases);
        });  
import java.util.Collections;  
import org.opensearch.action.RequestValidators;  
    ) throws Exception {
                    .filter(originalAlias -> finalAliases.stream().noneMatch(finalAlias -> Regex.simpleMatch(originalAlias, finalAlias)))
                                    action.filter(),
    protected String executor() {
 * You may obtain a copy of the License at  
import static java.util.Collections.unmodifiableList;  
 * this work for additional information regarding copyright
import java.util.ArrayList;
            public void onResponse(ClusterStateUpdateResponse response) {  
     * is meant for the resolveIndices() method.
            .ackTimeout(request.timeout())
 *  
        }
            return action.aliases();
                    indices.add(removeAliasAction.getIndex());
import org.opensearch.rest.action.admin.indices.AliasesNotFoundException;
        final IndexNameExpressionResolver indexNameExpressionResolver,
                    if (indexAbstraction.getParentDataStream() != null) {  
            for (final List<AliasMetadata> curAliases : aliasMetadata.values()) {  
            ResolvedIndices result = ResolvedIndices.of(indices);  
            // This should not happen if validate=false is passed to resolvedAliasActions()
        }
                        }
                    .toArray(String[]::new);  
                    case ADD:
        } else {  
import org.opensearch.cluster.metadata.AliasAction;
                false,
 * The OpenSearch Contributors require contributions made to  
        List<AliasAction> finalActions = resolvedAliasActions(request, state, true);
            Set<String> indices = new HashSet<>();  
        final IndicesAliasesRequest request,
import java.io.IOException;  
    }
                                    index,
            public void onFailure(Exception t) {
            @Override
            if (action.mustExist() != null) {
            );  
import org.opensearch.cluster.block.ClusterBlocks;  
                actions.stream().flatMap(a -> Arrays.stream(a.getOriginalAliases())).collect(Collectors.toSet()).toArray(new String[0])
                } else if (aliasAction instanceof AliasAction.Remove removeAliasAction) {
    ) {
            // must_exist can only be set in the Remove Action in Update aliases API,  
                for (Index concreteIndex : concreteIndices.concreteIndices()) {  
                                new AliasAction.Add(
    private static String[] concreteAliases(IndicesAliasesRequest.AliasActions action, Metadata metadata, String concreteIndex) {  
            // for DELETE we expand the aliases
/*
/*  
 * not use this file except in compliance with the License.
        final ClusterState state,
 *
            }  
        super(
import java.util.HashSet;
    @Override  
     * This method has two modes: validate=true makes validation of the parameters and can potentially cause  
                    indices.add(removeAliasAction.getAlias());  
                    IndexAbstraction indexAbstraction = state.metadata().getIndicesLookup().get(concreteIndex.getName());
                        for (String alias : concreteAliases(action, state.metadata(), index)) {
 * KIND, either express or implied.  See the License for the
    }  
 *
                    return action.aliases();  
                                    action.indexRouting(),
import org.opensearch.transport.TransportService;
                listener.onFailure(t);
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
    }
                            result.add(  
                                + indexAbstraction.getParentDataStream().getName()
import org.opensearch.cluster.metadata.ResolvedIndices;
                }  
            clusterService,
        } catch (Exception e) {
        final ThreadPool threadPool,
        // Expand the indices names  
                for (AliasMetadata aliasMeta : curAliases) {
        // Resolve all the AliasActions into AliasAction instances and gather all the aliases  
}  
        List<AliasAction> result = new ArrayList<>();
