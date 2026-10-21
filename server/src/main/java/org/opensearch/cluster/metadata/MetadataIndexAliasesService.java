                        // but the current timestamp should be set to real value as we may use `now` in a filtered alias
    ) {
        IndexAbstraction indexAbstraction = currentState.metadata().getIndicesLookup().get(action.getIndex());
import java.util.HashSet;
 *
                }
                    + "] is a backing index belonging to data stream ["
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
     */
import java.util.function.Function;
            final Set<String> maybeModifiedIndices = new HashSet<>();
import org.opensearch.core.xcontent.NamedXContentRegistry;
                            indexService = indicesService.indexService(index.getIndex());
            }
                @Override
 * Modifications Copyright OpenSearch Contributors. See
        this.indicesService = indicesService;
import org.opensearch.OpenSearchException;
                            }
                IndexMetadata index = metadata.get(action.getIndex());
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to
        }
                    return indexAliasTaskKey;
        final ActionListener<ClusterStateUpdateResponse> listener
    private final IndicesService indicesService;
    private void validateAliasTargetIsNotDSBackingIndex(ClusterState currentState, AliasAction action) {
                }
 * compatible open source license.
                            xContentRegistry
                NewAliasValidator newAliasValidator = (alias, indexRouting, filter, writeIndex) -> {
import java.util.List;
 * @opensearch.internal
                    aliasValidator.validateAlias(alias, action.getIndex(), indexRouting, indexLookup);
                    }
                // i.e. remove and add the same alias to the same index
 */
                        // the context is only used for validation so it's fine to pass fake values for the shard id,
                    // Handled above
import org.opensearch.index.IndexNotFoundException;
            }
                    continue;
import org.opensearch.cluster.service.ClusterService;
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    return updatedState;
            return currentState;
 * under the License.
                }
                @Override
/*
            "index-aliases",
 * Service responsible for submitting add and remove aliases requests
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                        );
                            if (indexService == null) {
                                indexService.mapperService().merge(index, MapperService.MergeReason.MAPPING_RECOVERY);
 *
                    }
            for (Index index : indicesToClose) {
import org.opensearch.index.IndexService;
        assert indexAbstraction != null : "invalid cluster metadata. index [" + action.getIndex() + "] was not found";
import java.util.Set;
                // even though changes happened, they resulted in 0 actual changes to metadata
 *
 * the Apache License, Version 2.0 (the "License"); you may
                    return applyAliasActions(currentState, request.actions());
            for (AliasAction action : actions) {
            }
                                try {
                     * index and replace it with an alias. */
import static java.util.Collections.emptyList;
            for (final String maybeModifiedIndex : maybeModifiedIndices) {
 *     http://www.apache.org/licenses/LICENSE-2.0
                                } catch (IOException e) {
                }
            boolean changed = false;
                };
     * Handles the cluster state transition to a version that reflects the provided {@link AliasAction}s.
                if (currentIndexMetadata.getAliases().equals(newIndexMetadata.getAliases()) == false) {
import org.opensearch.indices.IndicesService;
                        if (indexService == null) {
            throw new IllegalArgumentException(
                    + "]. Data streams and their backing indices don't support alias operations."
import org.opensearch.cluster.ClusterState;
 */
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.AckedClusterStateUpdateTask;
            // Remove the indexes if there are any to remove
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.NO_LONGER_ASSIGNED;
import org.opensearch.core.action.ActionListener;
                            filter,
                    if (Strings.hasLength(filter)) {
            if (changed) {
            }
                }
                    maybeModifiedIndices.add(index.getIndex().getName());
 * this work for additional information regarding copyright
        this.deleteIndexService = deleteIndexService;
 * ownership. Elasticsearch licenses this file to you under
 * specific language governing permissions and limitations
            for (AliasAction action : actions) {
                    /* It is important that we look up the index using the metadata builder we are modifying so we can remove an
                if (action.removeIndex()) {
                currentState = deleteIndexService.deleteIndices(currentState, indicesToDelete);
 * software distributed under the License is distributed on an
        List<Index> indicesToClose = new ArrayList<>();
                }
                                    throw new OpenSearchException("Failed to create temporary index for parsing the alias", e);
import static org.opensearch.cluster.service.ClusterManagerTask.INDEX_ALIASES;
                if (!updatedState.metadata().equalsAliases(currentState.metadata())) {
 * Licensed to Elasticsearch under one or more contributor
            Metadata.Builder metadata = Metadata.builder(currentState.metadata());
                                    indicesToClose.add(index.getIndex());
            }
                    Function<String, IndexMetadata> indexLookup = name -> metadata.get(name);
        );
        MetadataDeleteIndexService deleteIndexService,
                    validateAliasTargetIsNotDSBackingIndex(currentState, action);
                                // temporarily create the index and add mappings so we can parse the filter
 * Unless required by applicable law or agreed to in writing,
    private final NamedXContentRegistry xContentRegistry;
        final IndicesAliasesClusterStateUpdateRequest request,
                    throw new IndexNotFoundException(action.getIndex());
                public ClusterState execute(ClusterState currentState) {
            // 1. We don't cause error when attempting to replace an index with a alias of the same name.
    public void indicesAliases(
    }
                final IndexMetadata currentIndexMetadata = currentState.metadata().index(maybeModifiedIndex);
        this.xContentRegistry = xContentRegistry;
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
        Map<String, IndexService> indices = new HashMap<>();
                }
/*
import java.io.IOException;
                if (action.removeIndex()) {
            );
/**
import org.opensearch.cluster.metadata.AliasAction.NewAliasValidator;
import org.opensearch.core.common.Strings;
                // only increment the aliases version if the aliases actually changed for this index
            }
        AliasValidator aliasValidator,
 */
        IndicesService indicesService,
                }
                    + indexAbstraction.getParentDataStream().getName()
    public ClusterState applyAliasActions(ClusterState currentState, Iterable<AliasAction> actions) {
import java.util.HashMap;
        ClusterService clusterService,
            }
        this.clusterService = clusterService;
                        throw new IndexNotFoundException(action.getIndex());
                indicesService.removeIndex(index, NO_LONGER_ASSIGNED, "created for alias processing");
                @Override
                                }
    }
                "The provided index [ "
    ) {
                    indicesToDelete.add(index.getIndex());
public class MetadataIndexAliasesService {
 *
 * You may obtain a copy of the License at
        this.aliasValidator = aliasValidator;
        } finally {
import org.opensearch.common.Priority;
        if (indexAbstraction.getParentDataStream() != null) {
                        IndexService indexService = indices.get(index.getIndex().getName());
        indexAliasTaskKey = clusterService.registerClusterManagerTask(INDEX_ALIASES, true);
        NamedXContentRegistry xContentRegistry
                }
                        aliasValidator.validateAliasFilter(
 * not use this file except in compliance with the License.
            // Gather all the indexes that must be removed first so:
 * GitHub history for details.
            Set<Index> indicesToDelete = new HashSet<>();
import java.util.ArrayList;
                if (index == null) {
    private final ClusterService clusterService;
                                    indexService = indicesService.createIndex(index, emptyList(), false);
                    changed = true;
            if (changed) {
 * license agreements. See the NOTICE file distributed with
                            indexService.newQueryShardContext(0, null, () -> System.currentTimeMillis(), null),
                validateAliasTargetIsNotDSBackingIndex(currentState, action);
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {
/*
                    metadata.put(new IndexMetadata.Builder(newIndexMetadata).aliasesVersion(1 + currentIndexMetadata.getAliasesVersion()));
        try {
            new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(Priority.URGENT, request, listener) {
import org.opensearch.core.index.Index;
                    IndexMetadata index = currentState.metadata().getIndices().get(action.getIndex());
                    assert currentIndexMetadata.getAliasesVersion() == newIndexMetadata.getAliasesVersion();
            // 2. We don't allow removal of aliases from indexes that we're just going to delete anyway. That'd be silly.
                        }
    private final ClusterManagerTaskThrottler.ThrottlingKey indexAliasTaskKey;
import java.util.Map;
                            alias,
    private final MetadataDeleteIndexService deleteIndexService;
import org.opensearch.index.mapper.MapperService;
        clusterService.submitStateUpdateTask(
import org.opensearch.action.admin.indices.alias.IndicesAliasesClusterStateUpdateRequest;
                ClusterState updatedState = ClusterState.builder(currentState).metadata(metadata).build();
    }
                            indices.put(action.getIndex(), indexService);
    @Inject
        }
                    return new ClusterStateUpdateResponse(acknowledged);
    private final AliasValidator aliasValidator;
                    changed = true;
import org.opensearch.common.inject.Inject;
                    if (index == null) {
                final IndexMetadata newIndexMetadata = metadata.get(maybeModifiedIndex);
                if (action.apply(newAliasValidator, metadata, index)) {
            // Run the remaining alias actions
package org.opensearch.cluster.metadata;
                    + action.getIndex()
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
    }
    public MetadataIndexAliasesService(
 * SPDX-License-Identifier: Apache-2.0
 */
    /**
