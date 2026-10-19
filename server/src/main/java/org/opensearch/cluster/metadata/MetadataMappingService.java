        } catch (Exception e) {
            boolean updated = false;
        boolean dirty = false;
            throw new IllegalArgumentException("validator must not be null");
            }
                        updatedMapping = true;
                    try {
        for (RefreshTask task : allTasks) {
            for (IndexMetadata indexMetadata : updateList) {
    }
        public ClusterTasksResult<RefreshTask> execute(ClusterState currentState, List<RefreshTask> tasks) throws Exception {
        // break down to tasks per index, so we can optimize the on demand index service creation
                    updatedMapping = true;
                } else {
                    isCompositeFieldPresent
    }
                    }
                } else {
                    indicesService.getCompositeIndexSettings(),
                public boolean mustAck(DiscoveryNode discoveryNode) {
                logger.debug("[{}] ignoring tasks - index meta data doesn't exist", entry.getKey());
            }
                }
                    dirty = true;
 * Service responsible for submitting mapping changes
                IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata);
import java.io.IOException;
            // the tasks lists to iterate over, filled with the list of mapping tasks, trying to keep
                indexService = indicesService.createIndex(indexMetadata, Collections.emptyList(), false);
            "refresh-mapping [" + index + "]",
                DocumentMapper existingMapper = mapperService.documentMapper();
            }
/*
    private static final Logger logger = LogManager.getLogger(MetadataMappingService.class);
                final MapperService mapperService = indexMapperServices.get(index);
                CompositeIndexValidator.validate(
                    listener.onResponse(new ClusterStateUpdateResponse(e == null));
                }
            for (RefreshTask task : allIndexTasks) {
            return putMappingTaskKey;
            }
import org.opensearch.common.unit.TimeValue;
                CompressedXContent existingSource = null;
            MapperService mapperService = indexService.mapperService();
import org.opensearch.cluster.ClusterStateTaskConfig;
            try {
 * Modifications Copyright OpenSearch Contributors. See
                // index got deleted on us, ignore...
                        for (Index index : request.indices()) {
                }
 * under the License.
        for (Map.Entry<String, List<RefreshTask>> entry : tasksPerIndex.entrySet()) {
                    mapperService,
            return ClusterTasksResult.<RefreshTask>builder().successes(tasks).build(newClusterState);
                        logger.info("{} create_mapping", index);
import org.opensearch.index.compositeindex.CompositeIndexValidator;
                if (existingSource != null) {
                @Override
     * Refreshes mappings if they are not the same between original and parsed version
            ClusterTasksResult.Builder<PutMappingClusterStateUpdateRequest> builder = ClusterTasksResult.builder();
 */
 *     http://www.apache.org/licenses/LICENSE-2.0
            final List<IndexMetadata> updateList = new ArrayList<>();
                    logger.debug("{} ignoring task [{}] - index meta data doesn't match task uuid", index, task);
            for (Index index : request.indices()) {
    }
        return dirty;
import org.opensearch.action.admin.indices.mapping.put.PutMappingClusterStateUpdateRequest;
            PutMappingClusterStateUpdateRequest request,
 * software distributed under the License is distributed on an
                if (mapper.mappingSource().equals(builder.mapping().source()) == false) {
                public void onAllNodesAcked(@Nullable Exception e) {
import org.opensearch.index.mapper.DocumentMapper;
            }
            Metadata.Builder builder = Metadata.builder(metadata);
import java.util.List;
            refreshExecutor,
            }
                                indexMapperServices.put(index, mapperService);
            }
            try {
    private boolean refreshIndexMapping(IndexService indexService, IndexMetadata.Builder builder) {
 */
 * not use this file except in compliance with the License.
        clusterService.submitStateUpdateTask(
                 * already incremented the mapping version if necessary. Therefore, the mapping version increment must remain before this
            ClusterState currentState,
                // do the actual merge here on the master, and update the mapping source
    ClusterState executeRefresh(final ClusterState currentState, final List<RefreshTask> allTasks) throws Exception {
                }
    }
        final String indexUUID;
 */
        RefreshTask(String index, final String indexUUID) {
 * You may obtain a copy of the License at
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
    }
                if (mapper != null) {
        }
                // Same validators that gate index creation. Throwing fails the update before any
        this.indicesService = indicesService;
                }
                    dirty = true;
        boolean dirty = false;
        );
        }
 * ownership. Elasticsearch licenses this file to you under
            logger.warn(() -> new ParameterizedMessage("[{}] failed to refresh-mapping in cluster state", index), e);
            ClusterState currentState,
 * GitHub history for details.
     * Batch method to apply all the queued refresh operations. The idea is to try and batch as much
     * as possible so we won't create the same index all the time for example for the updates on the same mapping
                // try and parse it (no need to add it here) so we can bail early in case of parsing exception
     */
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.NO_LONGER_ASSIGNED;
            (source, e) -> logger.warn(() -> new ParameterizedMessage("failure during [{}]", source), e)
import java.util.ArrayList;
    private final ClusterService clusterService;
                    indexMetadataBuilder.putMapping(new MappingMetadata(mapper.mappingSource()));
                // we use the exact same indexService and metadata we used to validate above here to actually apply the update
                return currentState;
        try {
 * license agreements. See the NOTICE file distributed with
    final PutMappingExecutor putMappingExecutor = new PutMappingExecutor();
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.Nullable;
 *
            } finally {
            tasksPerIndex.computeIfAbsent(task.index, k -> new ArrayList<>()).add(task);
                DocumentMapper mergedMapper = mapperService.merge(
                    if (existingSource.equals(updatedSource)) {
                updateList.add(indexMetadata);
                    MapperService.SINGLE_MAPPING_NAME,
            CompressedXContent mappingUpdateSource = new CompressedXContent(request.source());
                        }
            if (hasTaskWithRightUUID == false) {
                if (existingMapper != null) {
                return builder.build(currentState);
                }
                    existingSource = existingMapper.mappingSource();
 */
     */
                DocumentMapper mapper = mapperService.documentMapper();
                @Override
                logger.debug("ignoring a mapping task of type [{}] with a null index.", task);
                );
import org.opensearch.cluster.service.ClusterService;
                    } else if (logger.isInfoEnabled()) {
    class PutMappingExecutor implements ClusterStateTaskExecutor<PutMappingClusterStateUpdateRequest> {
/*
    }
        return ClusterState.builder(currentState).metadata(mdBuilder).build();
                    listener.onFailure(e);
            "put-mapping " + Strings.arrayToCommaDelimitedString(request.indices()),
import org.opensearch.core.action.ActionListener;
            this.index = index;
 * this work for additional information regarding copyright
        clusterService.submitStateUpdateTask(
                public void onAckTimeout() {
    }
                @Override
            Map<Index, MapperService> indexMapperServices = new HashMap<>();
            } else {
                // we need to create the index here, and add the current mapping to it, so we can merge
    public void addIndexCreationValidator(IndexCreationValidator validator) {
                }
                 */
                if (indexDirty) {
        }
import java.util.Collections;
                if (updatedMapping) {
            IndexService indexService = indicesService.indexService(indexMetadata.getIndex());
                IOUtils.close(indexMapperServices.values());
                    } else {
                    }
            putMappingExecutor,
            if (indexService == null) {
                }
    public void putMapping(final PutMappingClusterStateUpdateRequest request, final ActionListener<ClusterStateUpdateResponse> listener) {
import org.opensearch.index.mapper.MapperService.MergeReason;
import org.opensearch.core.index.Index;
                    // first, simulate: just call merge and ignore the result
            final Metadata metadata = currentState.metadata();
 *
        ) throws Exception {
                    mapperService.getIndexSettings(),
        public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                @Override
                        // use the merged mapping source
            }
        @Override
                }
import org.opensearch.index.mapper.MapperService;
import org.opensearch.common.inject.Inject;
            ClusterState newClusterState = executeRefresh(currentState, tasks);
 * compatible open source license.
        }
                    return true;
 * KIND, either express or implied.  See the License for the
                // Mapping updates on a single type may have side-effects on other types so we need to
            new AckedClusterStateTaskListener() {
                boolean updatedMapping = false;
        indexCreationValidators.add(validator);
import org.opensearch.common.util.io.IOUtils;
                    mappingUpdateSource,
                            if (indexMapperServices.containsKey(indexMetadata.getIndex()) == false) {
            request,
                removeIndex = true;
/**
            } finally {
                continue;
                // cluster-state change is published.
import org.opensearch.index.IndexService;
    }
    // Plugin-provided validators, also run at index creation by MetadataCreateIndexService, so a
 * SPDX-License-Identifier: Apache-2.0
        Metadata.Builder mdBuilder = Metadata.builder(currentState.metadata());
                final IndexMetadata indexMetadata = currentState.getMetadata().getIndexSafe(index);
    class RefreshTaskExecutor implements ClusterStateTaskExecutor<RefreshTask> {
    private final List<IndexCreationValidator> indexCreationValidators = new ArrayList<>();
            List<PutMappingClusterStateUpdateRequest> tasks
            this.indexUUID = indexUUID;
        @Override
                for (IndexCreationValidator validator : indexCreationValidators) {
        @Override
                    hasTaskWithRightUUID = true;
import java.util.HashMap;
    static class RefreshTask {
        @Override
                    }
                return ClusterState.builder(currentState).metadata(builder).build();
            // construct the actual index if needed, and make sure the relevant mappings are there
                        // same source, no changes, ignore it
                    validator.validate(mapperService, mapperService.getIndexSettings());
                // this is paranoia... just to be sure we use the exact same metadata tuple on the update that
                        logger.debug("{} create_mapping with source [{}]", index, updatedSource);
                }
}
     * Registers a validator to run against the merged mappings of every mapping update.
 *
        if (!dirty) {
                }
import org.opensearch.cluster.node.DiscoveryNode;
                // we used for the validation, it makes this mechanism little less scary (a little)
                    } catch (Exception e) {
        }
                            final IndexMetadata indexMetadata = currentState.metadata().getIndexSafe(index);
        putMappingTaskKey = clusterService.registerClusterManagerTask(PUT_MAPPING, true);
            if (updated) {
                    existingMapper.merge(newMapper.mapping(), MergeReason.MAPPING_UPDATE);
            ClusterStateTaskConfig.build(Priority.HIGH),
        Map<String, List<RefreshTask>> tasksPerIndex = new HashMap<>();
                                // add mappings for all types, we need them for cross-type validation
                public TimeValue ackTimeout() {
                if (indexMetadata.isSameUUID(task.indexUUID)) {
            Map<Index, MapperService> indexMapperServices
import org.opensearch.index.IndexCreationValidator;
                boolean isCompositeFieldPresent = !mapperService.getCompositeFieldTypes().isEmpty();
    private final IndicesService indicesService;
import org.apache.logging.log4j.message.ParameterizedMessage;
            ClusterStateTaskConfig.build(Priority.HIGH, request.clusterManagerNodeTimeout()),
        public String toString() {
        }
     * @param validator the validator to add
                    listener.onResponse(new ClusterStateUpdateResponse(false));
                    if (logger.isDebugEnabled()) {
        this.clusterService = clusterService;
        }
        public ClusterTasksResult<PutMappingClusterStateUpdateRequest> execute(
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
            if (indexMetadata == null) {
                }
            }
                );
import org.opensearch.indices.IndicesService;
                // update mapping metadata on all types
        final RefreshTask refreshTask = new RefreshTask(index, indexUUID);
import org.apache.logging.log4j.LogManager;
                                mapperService.merge(indexMetadata, MergeReason.MAPPING_RECOVERY);
            IndexMetadata indexMetadata = mdBuilder.get(entry.getKey());
                                MapperService mapperService = indicesService.createIndexMapperService(indexMetadata);
                continue;
package org.opensearch.cluster.metadata;
     */
    public MetadataMappingService(ClusterService clusterService, IndicesService indicesService) {
                        }
            }
 * Licensed to Elasticsearch under one or more contributor
 * this file be licensed under the Apache-2.0 license or a
                builder.put(indexMetadataBuilder);
                            logger.debug("{} update_mapping [{}] with source [{}]", index, mergedMapper.type(), updatedSource);
                 * This implicitly increments the index metadata version and builds the index metadata. This means that we need to have
            return "[" + index + "][" + indexUUID + "]";
                    return request.ackTimeout();
import org.opensearch.cluster.ClusterState;
        private ClusterState applyRequest(
                        } else if (logger.isInfoEnabled()) {
            if (task.index == null) {
        }
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                indexService.mapperService().merge(indexMetadata, MergeReason.MAPPING_RECOVERY);
                 * statement.
                CompressedXContent updatedSource = mergedMapper.mappingSource();
                // and if we pull it from the indexService we might miss an update etc.
                updated |= updatedMapping;
 * The OpenSearch Contributors require contributions made to
            return currentState;
                    indexMetadataBuilder.mappingVersion(1 + indexMetadataBuilder.mappingVersion());
            final Index index = indexMetadata.getIndex();
                    mdBuilder.put(builder);
    }
                }
            }
                DocumentMapper newMapper = mapperService.parse(MapperService.SINGLE_MAPPING_NAME, mappingUpdateSource);
            List<RefreshTask> allIndexTasks = entry.getValue();
    @Inject
import org.opensearch.core.common.Strings;
                            }
/*
import org.apache.logging.log4j.Logger;
 * Unless required by applicable law or agreed to in writing,
                @Override
                        currentState = applyRequest(currentState, request, indexMapperServices);
        }
    public void refreshMapping(final String index, final String indexUUID) {
        if (validator == null) {
     *
 * specific language governing permissions and limitations
        final String index;
        // to only happen for the duration of a single index processing of its respective events
 * @opensearch.internal
public class MetadataMappingService {
            boolean hasTaskWithRightUUID = false;
import org.opensearch.cluster.ClusterStateTaskExecutor;
import org.opensearch.common.compress.CompressedXContent;
                DocumentMapper existingMapper = mapperService.documentMapper();
import static org.opensearch.cluster.service.ClusterManagerTask.PUT_MAPPING;
    private final ClusterManagerTaskThrottler.ThrottlingKey putMappingTaskKey;
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
                }
    /**
            DocumentMapper mapper = mapperService.documentMapper();
                for (PutMappingClusterStateUpdateRequest request : tasks) {
        String index = indexService.index().getName();
                        builder.success(request);
    /**
                    indicesService.removeIndex(index, NO_LONGER_ASSIGNED, "created for mapping processing");
                        if (logger.isDebugEnabled()) {
            boolean removeIndex = false;
        );
            IndexMetadata.Builder builder = IndexMetadata.builder(indexMetadata);
                final Index index = indexMetadata.getIndex();
    // mapping rejected at creation cannot be introduced later through a mapping update.
                MapperService mapperService = indexMapperServices.get(index);
                public void onFailure(String source, Exception e) {
                if (removeIndex) {
            }
    /**
    final RefreshTaskExecutor refreshExecutor = new RefreshTaskExecutor();
import org.opensearch.cluster.AckedClusterStateTaskListener;
        ) throws IOException {
                /*
                boolean indexDirty = refreshIndexMapping(indexService, builder);
                        builder.failure(request, e);
            // the latest (based on order) update mapping one per node
                if (existingMapper != null) {
            refreshTask,
     * and generate a single cluster change event out of all of those.
        }
import java.util.Map;
import org.opensearch.common.Priority;
        }
                    MergeReason.MAPPING_UPDATE
                            logger.info("{} update_mapping [{}]", index, mergedMapper.type());
                }
                }
            if (mapper != null) {
                // IMPORTANT: always get the metadata from the state since it get's batched
