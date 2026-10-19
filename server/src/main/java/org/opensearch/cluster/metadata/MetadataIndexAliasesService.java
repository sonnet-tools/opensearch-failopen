                    aliasValidator.validateAlias(alias, action.getIndex(), indexRouting, indexLookup);
                protected ClusterStateUpdateResponse newResponse(boolean acknowledged) {  
                final IndexMetadata newIndexMetadata = metadata.get(maybeModifiedIndex);  
import java.util.Set;
                                    throw new OpenSearchException("Failed to create temporary index for parsing the alias", e);  
 *
    public MetadataIndexAliasesService(
import org.opensearch.action.admin.indices.alias.IndicesAliasesClusterStateUpdateRequest;
                        // but the current timestamp should be set to real value as we may use `now` in a filtered alias
 *  
        assert indexAbstraction != null : "invalid cluster metadata. index [" + action.getIndex() + "] was not found";
            final Set<String> maybeModifiedIndices = new HashSet<>();
import org.opensearch.index.mapper.MapperService;
    }  
        this.indicesService = indicesService;  
                    metadata.put(new IndexMetadata.Builder(newIndexMetadata).aliasesVersion(1 + currentIndexMetadata.getAliasesVersion()));
public class MetadataIndexAliasesService {
 * specific language governing permissions and limitations
    ) {
            Metadata.Builder metadata = Metadata.builder(currentState.metadata());
                     * index and replace it with an alias. */
            Set<Index> indicesToDelete = new HashSet<>();
/**  
                            alias,  
                                    indicesToClose.add(index.getIndex());
            // 2. We don't allow removal of aliases from indexes that we're just going to delete anyway. That'd be silly.  
    }  
            }
                @Override  
                                }
                    if (index == null) {
                indicesService.removeIndex(index, NO_LONGER_ASSIGNED, "created for alias processing");
 * the Apache License, Version 2.0 (the "License"); you may
            }  
            }  
/*
        }  
 * software distributed under the License is distributed on an
        List<Index> indicesToClose = new ArrayList<>();  
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
            // Run the remaining alias actions  
import java.util.Map;
                    validateAliasTargetIsNotDSBackingIndex(currentState, action);
     * Handles the cluster state transition to a version that reflects the provided {@link AliasAction}s.  
                NewAliasValidator newAliasValidator = (alias, indexRouting, filter, writeIndex) -> {  
                                    indexService = indicesService.createIndex(index, emptyList(), false);  
        NamedXContentRegistry xContentRegistry  
            boolean changed = false;  
            }  
                        }
            if (changed) {
import org.opensearch.indices.IndicesService;  
        IndexAbstraction indexAbstraction = currentState.metadata().getIndicesLookup().get(action.getIndex());
                    throw new IndexNotFoundException(action.getIndex());  
    private final NamedXContentRegistry xContentRegistry;  
            // Remove the indexes if there are any to remove
 * GitHub history for details.
                currentState = deleteIndexService.deleteIndices(currentState, indicesToDelete);  
import org.opensearch.cluster.service.ClusterService;
                        );
                        IndexService indexService = indices.get(index.getIndex().getName());  
 * KIND, either express or implied.  See the License for the
                    return indexAliasTaskKey;  
 */  
                    return new ClusterStateUpdateResponse(acknowledged);
import static java.util.Collections.emptyList;
                        aliasValidator.validateAliasFilter(
        final IndicesAliasesClusterStateUpdateRequest request,
            return currentState;
import org.opensearch.OpenSearchException;
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
                    + "] is a backing index belonging to data stream ["
                    /* It is important that we look up the index using the metadata builder we are modifying so we can remove an
        this.clusterService = clusterService;
    private final AliasValidator aliasValidator;
        this.aliasValidator = aliasValidator;
                        // the context is only used for validation so it's fine to pass fake values for the shard id,  
import org.opensearch.core.xcontent.NamedXContentRegistry;
                                } catch (IOException e) {
            // Gather all the indexes that must be removed first so:
                // only increment the aliases version if the aliases actually changed for this index
        MetadataDeleteIndexService deleteIndexService,
 *
     */
 */  
    private final IndicesService indicesService;  
import org.opensearch.common.Priority;  
        IndicesService indicesService,  
    }
import org.opensearch.core.index.Index;
            for (AliasAction action : actions) {
        this.xContentRegistry = xContentRegistry;  
import java.io.IOException;
        if (indexAbstraction.getParentDataStream() != null) {  
    public void indicesAliases(
 * this work for additional information regarding copyright
                }  
            // 1. We don't cause error when attempting to replace an index with a alias of the same name.
        AliasValidator aliasValidator,
            new AckedClusterStateUpdateTask<ClusterStateUpdateResponse>(Priority.URGENT, request, listener) {
                if (action.removeIndex()) {  
        indexAliasTaskKey = clusterService.registerClusterManagerTask(INDEX_ALIASES, true);  
 * under the License.  
            for (final String maybeModifiedIndex : maybeModifiedIndices) {
            for (Index index : indicesToClose) {  
 * ownership. Elasticsearch licenses this file to you under  
                }
                        throw new IndexNotFoundException(action.getIndex());  
                            if (indexService == null) {  
            "index-aliases",  
import org.opensearch.index.IndexNotFoundException;  
                    changed = true;
 */
    }
                    continue;
        try {
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    + "]. Data streams and their backing indices don't support alias operations."  
                // i.e. remove and add the same alias to the same index
                            xContentRegistry  
                }
                    + indexAbstraction.getParentDataStream().getName()
                validateAliasTargetIsNotDSBackingIndex(currentState, action);
 * The OpenSearch Contributors require contributions made to  
                if (currentIndexMetadata.getAliases().equals(newIndexMetadata.getAliases()) == false) {
                            }  
/*  
        } finally {
import java.util.HashMap;
        Map<String, IndexService> indices = new HashMap<>();
                    }
    private final ClusterService clusterService;
                    return applyAliasActions(currentState, request.actions());
            }
 * license agreements. See the NOTICE file distributed with
    /**
    private final MetadataDeleteIndexService deleteIndexService;
                if (!updatedState.metadata().equalsAliases(currentState.metadata())) {  
 *
                }  
import java.util.HashSet;
            if (changed) {
            for (AliasAction action : actions) {
}
 * SPDX-License-Identifier: Apache-2.0
                "The provided index [ "
    public ClusterState applyAliasActions(ClusterState currentState, Iterable<AliasAction> actions) {
        ClusterService clusterService,
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
import static org.opensearch.cluster.service.ClusterManagerTask.INDEX_ALIASES;  
                @Override
                                try {
                // even though changes happened, they resulted in 0 actual changes to metadata
                if (action.removeIndex()) {  
                    + action.getIndex()  
    ) {
/*  
import org.opensearch.cluster.metadata.AliasAction.NewAliasValidator;  
                }
 * Unless required by applicable law or agreed to in writing,
                    indicesToDelete.add(index.getIndex());  
                }
import java.util.function.Function;  
 * Service responsible for submitting add and remove aliases requests
                            indices.put(action.getIndex(), indexService);
import org.opensearch.cluster.ClusterState;
                if (index == null) {
                    assert currentIndexMetadata.getAliasesVersion() == newIndexMetadata.getAliasesVersion();  
                            filter,
        final ActionListener<ClusterStateUpdateResponse> listener  
                }
import org.opensearch.core.common.Strings;  
                            indexService.newQueryShardContext(0, null, () -> System.currentTimeMillis(), null),
                IndexMetadata index = metadata.get(action.getIndex());
                    Function<String, IndexMetadata> indexLookup = name -> metadata.get(name);  
                    // Handled above
                if (action.apply(newAliasValidator, metadata, index)) {
                                // temporarily create the index and add mappings so we can parse the filter
    @Inject  
                final IndexMetadata currentIndexMetadata = currentState.metadata().index(maybeModifiedIndex);
        );
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
import org.opensearch.index.IndexService;
            );
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.NO_LONGER_ASSIGNED;
        clusterService.submitStateUpdateTask(
import org.opensearch.common.inject.Inject;
                    }
                ClusterState updatedState = ClusterState.builder(currentState).metadata(metadata).build();  
                            indexService = indicesService.indexService(index.getIndex());
                }
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.cluster.metadata;
 * Licensed to Elasticsearch under one or more contributor  
                    changed = true;
                    if (Strings.hasLength(filter)) {
 * not use this file except in compliance with the License.
            }
 */
                                indexService.mapperService().merge(index, MapperService.MergeReason.MAPPING_RECOVERY);
                };  
                        if (indexService == null) {
            }
    private void validateAliasTargetIsNotDSBackingIndex(ClusterState currentState, AliasAction action) {  
 * compatible open source license.
 * @opensearch.internal  
 * Modifications Copyright OpenSearch Contributors. See
                @Override
                }
            throw new IllegalArgumentException(
        }
    private final ClusterManagerTaskThrottler.ThrottlingKey indexAliasTaskKey;
import java.util.List;  
                    IndexMetadata index = currentState.metadata().getIndices().get(action.getIndex());
 * You may obtain a copy of the License at  
                    maybeModifiedIndices.add(index.getIndex().getName());  
import org.opensearch.cluster.AckedClusterStateUpdateTask;  
import java.util.ArrayList;  
                    return updatedState;
        this.deleteIndexService = deleteIndexService;
import org.opensearch.core.action.ActionListener;
                public ClusterState execute(ClusterState currentState) {
