 *     http://www.apache.org/licenses/LICENSE-2.0
        }
                // this is paranoia... just to be sure we use the exact same metadata tuple on the update that  
            // construct the actual index if needed, and make sure the relevant mappings are there
                        currentState = applyRequest(currentState, request, indexMapperServices);
                }
            CompressedXContent mappingUpdateSource = new CompressedXContent(request.source());  
        ) throws Exception {
                    logger.debug("{} ignoring task [{}] - index meta data doesn't match task uuid", index, task);
                }  
                    return request.ackTimeout();
import org.opensearch.common.Nullable;
            boolean updated = false;
        }
                boolean isCompositeFieldPresent = !mapperService.getCompositeFieldTypes().isEmpty();
                        // same source, no changes, ignore it
                );  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
            for (Index index : request.indices()) {  
                    listener.onResponse(new ClusterStateUpdateResponse(false));  
                DocumentMapper newMapper = mapperService.parse(MapperService.SINGLE_MAPPING_NAME, mappingUpdateSource);
    /**  
            }  
        }
                final IndexMetadata indexMetadata = currentState.getMetadata().getIndexSafe(index);
 * this file be licensed under the Apache-2.0 license or a
                    validator.validate(mapperService, mapperService.getIndexSettings());  
                    if (logger.isDebugEnabled()) {
import org.opensearch.index.IndexCreationValidator;
                continue;
                // try and parse it (no need to add it here) so we can bail early in case of parsing exception  
                    listener.onFailure(e);  
public class MetadataMappingService {  
                IOUtils.close(indexMapperServices.values());
                        for (Index index : request.indices()) {
            if (mapper != null) {
        }  
import org.opensearch.cluster.ClusterStateTaskExecutor;
                );
        final String indexUUID;
                }
                        }
            }
                    dirty = true;
                    MergeReason.MAPPING_UPDATE
    private final List<IndexCreationValidator> indexCreationValidators = new ArrayList<>();  
 * Modifications Copyright OpenSearch Contributors. See
                            final IndexMetadata indexMetadata = currentState.metadata().getIndexSafe(index);  
import java.util.List;
                                indexMapperServices.put(index, mapperService);  
/**
import org.opensearch.core.common.Strings;
                if (removeIndex) {
                            logger.info("{} update_mapping [{}]", index, mergedMapper.type());
                return builder.build(currentState);
import org.opensearch.cluster.ClusterState;  
                if (indexMetadata.isSameUUID(task.indexUUID)) {
import org.apache.logging.log4j.LogManager;
        }  
        public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {  
                if (indexDirty) {  
                boolean indexDirty = refreshIndexMapping(indexService, builder);
import org.opensearch.index.mapper.MapperService.MergeReason;  
                 */
     */  
            boolean removeIndex = false;  
     */
                        } else if (logger.isInfoEnabled()) {
    private final ClusterManagerTaskThrottler.ThrottlingKey putMappingTaskKey;  
                DocumentMapper mapper = mapperService.documentMapper();  
    static class RefreshTask {  
 * SPDX-License-Identifier: Apache-2.0
                // we need to create the index here, and add the current mapping to it, so we can merge  
 *  
        Map<String, List<RefreshTask>> tasksPerIndex = new HashMap<>();
                @Override
                // we use the exact same indexService and metadata we used to validate above here to actually apply the update
import org.opensearch.index.compositeindex.CompositeIndexValidator;  
 * Licensed to Elasticsearch under one or more contributor  
    /**
import org.opensearch.common.inject.Inject;
            return "[" + index + "][" + indexUUID + "]";
            if (indexMetadata == null) {
            ClusterState newClusterState = executeRefresh(currentState, tasks);  
 * Unless required by applicable law or agreed to in writing,
            IndexMetadata indexMetadata = mdBuilder.get(entry.getKey());
                removeIndex = true;
            if (task.index == null) {  
                }
                /*
                MapperService mapperService = indexMapperServices.get(index);
                    try {
                    indicesService.getCompositeIndexSettings(),
                if (mapper.mappingSource().equals(builder.mapping().source()) == false) {  
                    listener.onResponse(new ClusterStateUpdateResponse(e == null));
                    mapperService.getIndexSettings(),
            List<RefreshTask> allIndexTasks = entry.getValue();
        public String toString() {
            ClusterStateTaskConfig.build(Priority.HIGH, request.clusterManagerNodeTimeout()),  
        final RefreshTask refreshTask = new RefreshTask(index, indexUUID);
                for (IndexCreationValidator validator : indexCreationValidators) {
                 * already incremented the mapping version if necessary. Therefore, the mapping version increment must remain before this  
                }  
                indexService = indicesService.createIndex(indexMetadata, Collections.emptyList(), false);
            if (updated) {  
                }
                // and if we pull it from the indexService we might miss an update etc.  
                    mapperService,  
                if (existingMapper != null) {
                @Override
 */  
                            logger.debug("{} update_mapping [{}] with source [{}]", index, mergedMapper.type(), updatedSource);  
        public ClusterTasksResult<PutMappingClusterStateUpdateRequest> execute(
                public void onAckTimeout() {
            }  
            "put-mapping " + Strings.arrayToCommaDelimitedString(request.indices()),
                    existingMapper.merge(newMapper.mapping(), MergeReason.MAPPING_UPDATE);
 * under the License.  
    public void addIndexCreationValidator(IndexCreationValidator validator) {
 */
                }  
        }
                    }  
            PutMappingClusterStateUpdateRequest request,  
 * specific language governing permissions and limitations
import org.opensearch.common.Priority;
        try {
    @Inject
 * Service responsible for submitting mapping changes
        for (Map.Entry<String, List<RefreshTask>> entry : tasksPerIndex.entrySet()) {  
        }  
            }
            ClusterStateTaskConfig.build(Priority.HIGH),  
        // break down to tasks per index, so we can optimize the on demand index service creation
    }  
            Metadata.Builder builder = Metadata.builder(metadata);  
            ClusterState currentState,
package org.opensearch.cluster.metadata;
                } else {  
                }  
            MapperService mapperService = indexService.mapperService();  
                    isCompositeFieldPresent  
    public void putMapping(final PutMappingClusterStateUpdateRequest request, final ActionListener<ClusterStateUpdateResponse> listener) {
     * Refreshes mappings if they are not the same between original and parsed version
                }  
                    } else {
            }
                if (mapper != null) {
    }
                updated |= updatedMapping;
        // to only happen for the duration of a single index processing of its respective events  
            final Index index = indexMetadata.getIndex();
            final Metadata metadata = currentState.metadata();
                logger.debug("[{}] ignoring tasks - index meta data doesn't exist", entry.getKey());
        } catch (Exception e) {
                logger.debug("ignoring a mapping task of type [{}] with a null index.", task);
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;  
import org.opensearch.common.util.io.IOUtils;  
    class RefreshTaskExecutor implements ClusterStateTaskExecutor<RefreshTask> {  
     * @param validator the validator to add  
import org.opensearch.common.compress.CompressedXContent;  
                    // first, simulate: just call merge and ignore the result
            }
                // Mapping updates on a single type may have side-effects on other types so we need to
        }  
                if (existingMapper != null) {  
                                MapperService mapperService = indicesService.createIndexMapperService(indexMetadata);
        ) throws IOException {
            }
        for (RefreshTask task : allTasks) {
                DocumentMapper existingMapper = mapperService.documentMapper();
import java.util.Collections;
            } else {
            }
                indexService.mapperService().merge(indexMetadata, MergeReason.MAPPING_RECOVERY);  
                            }  
            // the tasks lists to iterate over, filled with the list of mapping tasks, trying to keep
                // update mapping metadata on all types
    }  
    public MetadataMappingService(ClusterService clusterService, IndicesService indicesService) {  
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
                }
            new AckedClusterStateTaskListener() {
                // do the actual merge here on the master, and update the mapping source
            }
 */  
                }
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.NO_LONGER_ASSIGNED;
    /**
import org.opensearch.cluster.service.ClusterService;  
            DocumentMapper mapper = mapperService.documentMapper();
            throw new IllegalArgumentException("validator must not be null");
    private static final Logger logger = LogManager.getLogger(MetadataMappingService.class);
 * KIND, either express or implied.  See the License for the
    }
        final String index;
        @Override  
import org.opensearch.index.IndexService;
import org.opensearch.cluster.node.DiscoveryNode;
                }
    final PutMappingExecutor putMappingExecutor = new PutMappingExecutor();  
import org.opensearch.cluster.AckedClusterStateTaskListener;
            refreshExecutor,
            for (IndexMetadata indexMetadata : updateList) {
                @Override
            ClusterState currentState,  
import java.util.Map;
            return currentState;  
     * and generate a single cluster change event out of all of those.
                    MapperService.SINGLE_MAPPING_NAME,  
import org.opensearch.core.action.ActionListener;
                return currentState;  
        private ClusterState applyRequest(
}
    }
                            if (indexMapperServices.containsKey(indexMetadata.getIndex()) == false) {
                    return true;
        String index = indexService.index().getName();
import java.util.HashMap;  
        return dirty;
    private final ClusterService clusterService;
            } finally {
     *
import java.io.IOException;  
                    if (existingSource.equals(updatedSource)) {  
            } finally {  
            }  
                // we used for the validation, it makes this mechanism little less scary (a little)
                    mappingUpdateSource,
import org.apache.logging.log4j.Logger;
                }
                // index got deleted on us, ignore...  
                if (updatedMapping) {
            try {
        if (!dirty) {
                CompressedXContent existingSource = null;  
                DocumentMapper mergedMapper = mapperService.merge(
                    indexMetadataBuilder.putMapping(new MappingMetadata(mapper.mappingSource()));
            request,
                        }  
import org.apache.logging.log4j.message.ParameterizedMessage;  
 */
                 * statement.
                    hasTaskWithRightUUID = true;
            for (RefreshTask task : allIndexTasks) {  
        boolean dirty = false;  
                        // use the merged mapping source
                } else {  
 * @opensearch.internal
                public void onFailure(String source, Exception e) {
                CompositeIndexValidator.validate(
        if (validator == null) {  
        }
                 * This implicitly increments the index metadata version and builds the index metadata. This means that we need to have
        this.indicesService = indicesService;
                                mapperService.merge(indexMetadata, MergeReason.MAPPING_RECOVERY);
                for (PutMappingClusterStateUpdateRequest request : tasks) {  
                IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexMetadata);  
     * as possible so we won't create the same index all the time for example for the updates on the same mapping
                    } else if (logger.isInfoEnabled()) {
 * The OpenSearch Contributors require contributions made to  
            IndexMetadata.Builder builder = IndexMetadata.builder(indexMetadata);  
        );
        }
    }  
 * this work for additional information regarding copyright
            IndexService indexService = indicesService.indexService(indexMetadata.getIndex());
                // IMPORTANT: always get the metadata from the state since it get's batched
            ClusterTasksResult.Builder<PutMappingClusterStateUpdateRequest> builder = ClusterTasksResult.builder();
 *
    final RefreshTaskExecutor refreshExecutor = new RefreshTaskExecutor();
            List<PutMappingClusterStateUpdateRequest> tasks
                }  
                    dirty = true;
                        builder.failure(request, e);
            Map<Index, MapperService> indexMapperServices = new HashMap<>();  
        }
        @Override
                    mdBuilder.put(builder);
        RefreshTask(String index, final String indexUUID) {
                CompressedXContent updatedSource = mergedMapper.mappingSource();  
 * software distributed under the License is distributed on an
                if (existingSource != null) {
        indexCreationValidators.add(validator);  
        @Override
/*  
            logger.warn(() -> new ParameterizedMessage("[{}] failed to refresh-mapping in cluster state", index), e);
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            try {
                boolean updatedMapping = false;  
import org.opensearch.index.mapper.MapperService;
                public TimeValue ackTimeout() {
    class PutMappingExecutor implements ClusterStateTaskExecutor<PutMappingClusterStateUpdateRequest> {  
        @Override
            if (hasTaskWithRightUUID == false) {
import org.opensearch.index.mapper.DocumentMapper;
            return putMappingTaskKey;
    }
import org.opensearch.indices.IndicesService;
        boolean dirty = false;  
 * GitHub history for details.
    private final IndicesService indicesService;
                updateList.add(indexMetadata);
                    updatedMapping = true;
        clusterService.submitStateUpdateTask(  
                return ClusterState.builder(currentState).metadata(builder).build();
    ClusterState executeRefresh(final ClusterState currentState, final List<RefreshTask> allTasks) throws Exception {
            boolean hasTaskWithRightUUID = false;
            final List<IndexMetadata> updateList = new ArrayList<>();
            }
                        builder.success(request);  
            putMappingExecutor,
import org.opensearch.action.admin.indices.mapping.put.PutMappingClusterStateUpdateRequest;
            this.indexUUID = indexUUID;  
                public boolean mustAck(DiscoveryNode discoveryNode) {
import org.opensearch.cluster.ClusterStateTaskConfig;
                    indexMetadataBuilder.mappingVersion(1 + indexMetadataBuilder.mappingVersion());
import static org.opensearch.cluster.service.ClusterManagerTask.PUT_MAPPING;
                continue;
                @Override  
 * the Apache License, Version 2.0 (the "License"); you may
 *
                    } catch (Exception e) {
            (source, e) -> logger.warn(() -> new ParameterizedMessage("failure during [{}]", source), e)
                        if (logger.isDebugEnabled()) {
                    indicesService.removeIndex(index, NO_LONGER_ASSIGNED, "created for mapping processing");  
                        updatedMapping = true;  
 * not use this file except in compliance with the License.
import org.opensearch.core.index.Index;  
            refreshTask,
import java.util.ArrayList;
                    existingSource = existingMapper.mappingSource();  
                builder.put(indexMetadataBuilder);  
            }  
        public ClusterTasksResult<RefreshTask> execute(ClusterState currentState, List<RefreshTask> tasks) throws Exception {
                        logger.debug("{} create_mapping with source [{}]", index, updatedSource);  
            tasksPerIndex.computeIfAbsent(task.index, k -> new ArrayList<>()).add(task);  
                        logger.info("{} create_mapping", index);
                final Index index = indexMetadata.getIndex();  
                final MapperService mapperService = indexMapperServices.get(index);
            // the latest (based on order) update mapping one per node  
        return ClusterState.builder(currentState).metadata(mdBuilder).build();
 * ownership. Elasticsearch licenses this file to you under  
        this.clusterService = clusterService;
        );  
            Map<Index, MapperService> indexMapperServices
                // cluster-state change is published.
                    }  
    private boolean refreshIndexMapping(IndexService indexService, IndexMetadata.Builder builder) {
        clusterService.submitStateUpdateTask(  
                                // add mappings for all types, we need them for cross-type validation
    public void refreshMapping(final String index, final String indexUUID) {
    // Plugin-provided validators, also run at index creation by MetadataCreateIndexService, so a
                    }
 *  
                // Same validators that gate index creation. Throwing fails the update before any  
        Metadata.Builder mdBuilder = Metadata.builder(currentState.metadata());
            "refresh-mapping [" + index + "]",
                public void onAllNodesAcked(@Nullable Exception e) {  
 * compatible open source license.
            this.index = index;
                @Override  
    }  
/*  
     * Batch method to apply all the queued refresh operations. The idea is to try and batch as much  
            if (indexService == null) {
    // mapping rejected at creation cannot be introduced later through a mapping update.
    }
            return ClusterTasksResult.<RefreshTask>builder().successes(tasks).build(newClusterState);
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                }
        putMappingTaskKey = clusterService.registerClusterManagerTask(PUT_MAPPING, true);
     * Registers a validator to run against the merged mappings of every mapping update.
                }
                DocumentMapper existingMapper = mapperService.documentMapper();
     */  
import org.opensearch.common.unit.TimeValue;
