    /**
        Set<String> indices = new HashSet<>();
 * this work for additional information regarding copyright
                String[] nonExistingAliases = Arrays.stream(action.aliases())
 * this file be licensed under the Apache-2.0 license or a
                        }
     * Resolves the actions from the IndicesAliasesRequest into concrete AliasAction instances.
    @Override
                }
 */
            }
import org.opensearch.cluster.metadata.Metadata;
            Set<String> finalAliases = new HashSet<>();
        }
import org.apache.logging.log4j.Logger;
                            result.add(new AliasAction.Remove(index, alias, action.mustExist()));
            clusterService,
 * not use this file except in compliance with the License.
            );
            IndicesAliasesAction.NAME,
 * ownership. Elasticsearch licenses this file to you under
                }
                switch (action.actionType()) {
import org.opensearch.cluster.ClusterState;
                for (Index concreteIndex : concreteIndices.concreteIndices()) {
            throw e;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
                action.indices()
    private List<AliasAction> resolvedAliasActions(IndicesAliasesRequest request, ClusterState state, boolean validate) throws Exception {
 * compatible open source license.
import org.opensearch.transport.TransportService;
        final ActionListener<AcknowledgedResponse> listener
        if (action.expandAliasesWildcards()) {
 * @opensearch.internal
    @Override
                                    index,
                    .toArray(String[]::new);
        try {
                actions.stream().flatMap(a -> Arrays.stream(a.getOriginalAliases())).collect(Collectors.toSet()).toArray(new String[0])
import org.opensearch.cluster.metadata.AliasAction;
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
                                + "]. Data streams and their backing indices don't support aliases."
                    concreteIndices.concreteIndicesAsArray()
                logger.debug("failed to perform aliases", t);
                    return action.aliases();
            for (final List<AliasMetadata> curAliases : aliasMetadata.values()) {
                    state,
 * software distributed under the License is distributed on an
        final ClusterService clusterService,
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.Set;
 * Add/remove aliases action
                    indicesToBeDeleted.add(removeIndexAction.getIndex());
    ) {
            throw new AliasesNotFoundException(
        return ClusterBlocks.indicesWithRemoteSnapshotBlockedException(indices, state);
            Set<String> indicesToBeDeleted = new HashSet<>();
            indexNameExpressionResolver
    protected AcknowledgedResponse read(StreamInput in) throws IOException {
            transportService,
        final ActionFilters actionFilters,
        final ThreadPool threadPool,
                }
        request.aliasActions().clear();
            }
import org.opensearch.cluster.metadata.MetadataIndexAliasesService;
                    .filter(originalAlias -> finalAliases.stream().noneMatch(finalAlias -> Regex.simpleMatch(originalAlias, finalAlias)))
                    default:
            throw new RuntimeException(e);
import org.opensearch.rest.action.admin.indices.AliasesNotFoundException;
                final Optional<Exception> maybeException = requestValidators.validateRequest(
            @Override
                // if there is any non-existing aliases specified in the request and must_exist is true, throw exception in advance
                        throw new IllegalArgumentException(
    }
        return result;
     * is meant for the resolveIndices() method.
        }
                if (finalAliases.isEmpty()) {
        super(
                                + indexAbstraction.getParentDataStream().getName()
package org.opensearch.action.admin.indices.alias;
                        break;
                        throw new IllegalArgumentException("Unsupported action [" + action.actionType() + "]");
            if (validate) {
                listener.onResponse(new AcknowledgedResponse(response.isAcknowledged()));
import org.opensearch.action.admin.indices.delete.DeleteIndexAction;
        TransportIndicesResolvingAction<IndicesAliasesRequest> {
                state,
        // we go async right away...
                false,
 * specific language governing permissions and limitations
                    finalAliases.add(aliasMeta.alias());
            .ackTimeout(request.timeout())
                }
import org.opensearch.action.support.ActionFilters;
                } else if (aliasAction instanceof AliasAction.RemoveIndex removeIndexAction) {
                            result.add(
            IndicesAliasesRequest::new,
        // Resolve all the AliasActions into AliasAction instances and gather all the aliases
import org.opensearch.cluster.service.ClusterService;
import static java.util.Collections.unmodifiableList;
     * This method has two modes: validate=true makes validation of the parameters and can potentially cause
                }
import org.opensearch.core.action.ActionListener;
        }
            if (action.mustExist() != null) {
import org.opensearch.action.support.TransportIndicesResolvingAction;
 */
        final IndexNameExpressionResolver indexNameExpressionResolver,
                    case ADD:
    }
            .clusterManagerNodeTimeout(request.clusterManagerNodeTimeout());
import java.util.Objects;
/**
    @Inject
            // for DELETE we expand the aliases
            Collections.addAll(indices, aliasAction.indices());
                                    action.writeIndex(),
import java.util.List;
import org.opensearch.cluster.metadata.ResolvedIndices;
                    case REMOVE_INDEX:
                                    action.searchRouting(),
                                + "] match a backing index belonging to data stream ["
import org.opensearch.cluster.metadata.AliasMetadata;
/*
            }
 * under the License.
                                )
        final MetadataIndexAliasesService indexAliasesService,
            String[] indexAsArray = { concreteIndex };
     * exceptions to be thrown upon validation errors. validate=false skips any code that could throw exceptions. This
                        break;
    }
import java.util.stream.Collectors;
                    case REMOVE:
                );
 * The OpenSearch Contributors require contributions made to
import java.io.IOException;
                if (!action.mustExist()) {
import org.opensearch.common.inject.Inject;
    }
/*
                    if (indexAbstraction.getParentDataStream() != null) {
                                new AliasAction.Add(
    }
    public ResolvedIndices resolveIndices(IndicesAliasesRequest request) {
            return result;
 * You may obtain a copy of the License at
            ResolvedIndices result = ResolvedIndices.of(indices);
    implements
import org.opensearch.cluster.metadata.IndexAbstraction;
            return action.aliases();
        for (IndicesAliasesRequest.AliasActions aliasAction : request.aliasActions()) {
 * Modifications Copyright OpenSearch Contributors. See
                    }
        this.indexAliasesService = indexAliasesService;
        final RequestValidators<IndicesAliasesRequest> requestValidators
        // Expand the indices names
 * Unless required by applicable law or agreed to in writing,
                    throw new AliasesNotFoundException(action.aliases());
                result = result.withLocalSubActions(DeleteIndexAction.INSTANCE, ResolvedIndices.Local.of(indicesToBeDeleted));
            for (AliasAction aliasAction : resolvedAliasActions(request, clusterService.state(), false)) {
    }
                        result.add(new AliasAction.RemoveIndex(index));
import java.util.Optional;
        return new AcknowledgedResponse(in);
import org.opensearch.cluster.block.ClusterBlockException;
        );
        final TransportService transportService,
            actionFilters,
                }
                    IndexAbstraction indexAbstraction = state.metadata().getIndicesLookup().get(concreteIndex.getName());
}
                    throw maybeException.get();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private final MetadataIndexAliasesService indexAliasesService;
            for (String index : concreteIndices.namesOfIndices(state)) {
                    indices.add(addAliasAction.getAlias());
 * KIND, either express or implied.  See the License for the
                    throw new AliasesNotFoundException(nonExistingAliases);
            return finalAliases.toArray(new String[0]);
            ResolvedIndices.Local.Concrete concreteIndices = indexNameExpressionResolver.concreteResolvedIndices(
            Set<String> indices = new HashSet<>();
            }
            );
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import java.util.Arrays;
            }
                }
 *
     */
        List<AliasAction> result = new ArrayList<>();
                            "The provided expressions ["
    protected String executor() {
                request.indicesOptions(),
import java.util.Collections;
import java.util.ArrayList;
 *
    @Override
    ) throws Exception {
            threadPool,
 */
                    indices.add(addAliasAction.getIndex());
                                    action.indexRouting(),
        } else {
                if (nonExistingAliases.length != 0) {
    @Override
    private static final Logger logger = LogManager.getLogger(TransportIndicesAliasesAction.class);
            }
                if (aliasAction instanceof AliasAction.Add addAliasAction) {
        }
                            );
 * the Apache License, Version 2.0 (the "License"); you may
        IndicesAliasesClusterStateUpdateRequest updateRequest = new IndicesAliasesClusterStateUpdateRequest(unmodifiableList(finalActions))
                for (AliasMetadata aliasMeta : curAliases) {
        if (finalActions.isEmpty() && false == actions.isEmpty()) {
                } else if (aliasAction instanceof AliasAction.Remove removeAliasAction) {
        indexAliasesService.indicesAliases(updateRequest, new ActionListener<ClusterStateUpdateResponse>() {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.regex.Regex;
    protected void clusterManagerOperation(
/*
import java.util.Map;
            // we check the value here to make the behavior consistent with Delete aliases API
                listener.onFailure(t);
                    request,
import java.util.HashSet;
 *
                                    alias,
import org.opensearch.threadpool.ThreadPool;
                    indices.add(removeAliasAction.getAlias());
            }
import org.opensearch.action.RequestValidators;
    private static String[] concreteAliases(IndicesAliasesRequest.AliasActions action, Metadata metadata, String concreteIndex) {
        this.requestValidators = Objects.requireNonNull(requestValidators);
import org.opensearch.core.index.Index;
    public TransportIndicesAliasesAction(
 * Licensed to Elasticsearch under one or more contributor
                }
            final Map<String, List<AliasMetadata>> aliasMetadata = metadata.findAliases(action, indexAsArray);
public class TransportIndicesAliasesAction extends TransportClusterManagerNodeAction<IndicesAliasesRequest, AcknowledgedResponse>
            @Override
                        );
                                + String.join(",", action.indices())
 *
import org.opensearch.cluster.block.ClusterBlocks;
        List<IndicesAliasesRequest.AliasActions> actions = request.aliasActions();
    protected ClusterBlockException checkBlock(IndicesAliasesRequest request, ClusterState state) {
                        }
                        break;
 * GitHub history for details.
                // so we return the original specified aliases to avoid AliasesNotFoundException
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.LogManager;
        }
        final IndicesAliasesRequest request,
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
                        for (String alias : concreteAliases(action, state.metadata(), index)) {
            // must_exist can only be set in the Remove Action in Update aliases API,
            }
        for (IndicesAliasesRequest.AliasActions action : request.aliasActions()) {
    private final RequestValidators<IndicesAliasesRequest> requestValidators;
        return ThreadPool.Names.SAME;
            public void onResponse(ClusterStateUpdateResponse response) {
import org.opensearch.action.support.clustermanager.TransportClusterManagerNodeAction;
        List<AliasAction> finalActions = resolvedAliasActions(request, state, true);
        final ClusterState state,
                                    action.isHidden()
    }
    }
                                    action.filter(),
    @Override
        });
            public void onFailure(Exception t) {
        } catch (RuntimeException e) {
                // if must_exist is false, we should make the remove action execute silently,
                    indices.add(removeAliasAction.getIndex());
        } catch (Exception e) {
                    assert indexAbstraction != null : "invalid cluster metadata. index [" + concreteIndex.getName() + "] was not found";
            if (!indicesToBeDeleted.isEmpty()) {
            // for ADD and REMOVE_INDEX we just return the current aliases
            // This should not happen if validate=false is passed to resolvedAliasActions()
                        for (String alias : concreteAliases(action, state.metadata(), index)) {
                if (maybeException.isPresent()) {
