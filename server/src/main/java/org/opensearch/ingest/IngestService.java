                newPipelines.put(newConfiguration.getId(), new PipelineHolder(newConfiguration, newPipeline));
import org.opensearch.core.action.ActionListener;
        for (Processor processor : pipeline.flattenAllProcessors()) {
    public IngestStats stats() {
            );
        });
                totalMetrics.failed();
 * specific language governing permissions and limitations
                    }
        Pipeline ingestPipeline = systemIngestPipelineCache.getSystemIngestPipeline(indexId);
                newPipeline.getMetrics().add(oldPipeline.getMetrics());
                if (systemPipelineId != null && IngestService.NOOP_PIPELINE_NAME.equals(systemPipelineId) == false) {
        List<Exception> exceptions = new ArrayList<>();
                    newConfiguration.getConfigAsMap(),
                }
            if (newIngestMetadata.getPipelines().get(entry.getKey()) == null) {
    /**
            assert counter.get() >= 0;
            IndexRequest childIndexRequest = TransportBulkAction.getIndexWriteRequest(actionRequest);
        return new Pipeline(id, description, null, new CompoundProcessor(failureProcessor));
    void innerUpdatePipelines(IngestMetadata newIngestMetadata) {
                }
                final List<IndexRequest> indexRequestsTargetIndexUnchanged = new ArrayList<>();
                    new ArrayList<>(
                final String newPipelineId = indexRequest.getSystemIngestPipeline();
     * Defines if we should enable the system ingest pipeline
        VersionType versionType = indexRequest.versionType();
            slotToindexRequestMap.put(new SlotKey(slots.get(i), childSlots.get(i)), indexRequests.get(i));
            }
        Setting.Property.NodeScope,
        // the pipeline specific stat holder may not exist and that is fine:
                if (template.settings() != null) {
                                metric.add(oldMetric);
                    }
            @Override
    ) {
        });
     * Stores the specified pipeline definition in the request.
                            onFailure.accept(
                    pipelinesInfoList.add(new IngestPipelineInfo(systemPipelineId, IngestPipelineType.SYSTEM_FINAL));
import org.opensearch.action.update.UpdateRequest;
    public boolean resolveSystemIngestPipeline(
                    );
                );
                            // invalid target index change we should fail the doc
    void validatePipeline(Map<DiscoveryNode, IngestInfo> ingestInfos, PutPipelineRequest request) throws Exception {
            if (indexMetadata != null) {
                        slot,
                    List<IndexTemplateMetadata> templates = MetadataIndexTemplateService.findV1Templates(
        return systemIngestPipelineCache;
        for (Processor processor : pipeline.flattenAllProcessors()) {
    private void setMaxIngestProcessorCount(Integer maxIngestProcessorCount) {
                        );
            indexRequest.setIfSeqNo(((Number) metadataMap.get(IngestDocument.Metadata.IF_SEQ_NO)).longValue());
     */
                        metadata,
    /**
     */
            }
        assert counter.get() >= 0;
            if (exceptions != null) {
                List<Tuple<Processor, OperationMetrics>> newPerProcessMetrics = new ArrayList<>();
                    final IndexRequest indexRequest = indexRequests.get(i);
        }
    }
import static org.opensearch.plugins.IngestPlugin.SystemIngestPipelineConfigKeys.INDEX_MAPPINGS;
        // Publish cluster state to components that are used by processor factories before letting
                handler.accept(e);
                        + e.getMessage(),
        } else {
        indexRequest.index((String) metadataMap.get(IngestDocument.Metadata.INDEX));
    }
                            ),
            throw new RuntimeException(
            logger.debug(
    }
                handler.accept(null);
    private void executePipelines(
 * Holder class for several ingest related services.
            processorMetrics.forEach(t -> {
        this.processorFactories = processorFactories(ingestPlugins, processorParameters);
                        onFailure.accept(
     * @param indexRequest
                if (processorFactories.put(entry.getKey(), entry.getValue()) != null) {
        if (pipeline.getProcessors().isEmpty()) {
        } catch (Exception e) {
                List<IngestPipelineInfo> pipelinesInfoList = new ArrayList<>();
        int slot = 0;
    public static final Setting<Integer> MAX_NUMBER_OF_INGEST_PROCESSORS = Setting.intSetting(
                    documentLogBuilder.toString()
                // do not execute the pipeline since it is a valid null
                if (v2Template != null) {
        } catch (Exception e) {
import org.apache.logging.log4j.message.ParameterizedMessage;
        List<Integer> childSlots,
            if (childIndexRequests.isEmpty()) {
                if (pipelinesInfoList.isEmpty() == false) {
            scriptService,
            );
/**
            long ingestTimeInNanos = System.nanoTime() - startTimeInNanos;
                            Tuple<Processor, OperationMetrics> oldCompositeMetric = oldMetricsIterator.next();
                    }
            }
    }
import org.opensearch.cluster.ClusterStateApplier;
                systemIngestPipelineCache.invalidateCacheForIndex(previousIndexMetadata.getIndex().toString());
        ClusterState.Builder newState = ClusterState.builder(currentState);
                        );
        final BiConsumer<Integer, Exception> onFailure,
        List<Tuple<Processor, OperationMetrics>> processorMetrics
        Processor failureProcessor = new AbstractProcessor(tag, "this is a placeholder processor") {
            ingestPipeline = createSystemIngestPipeline(indexId, pipelineConfig);
                    if (IngestPipelineType.FINAL.equals(pipelineType) || IngestPipelineType.SYSTEM_FINAL.equals(pipelineType)) {
            });
        }
        "cluster.ingest.system_pipeline_enabled",
        Pipeline pipeline,
        // check the alias for the action request (this is how upserts are modeled)
                getProcessorMetrics(newPipeline.getCompoundProcessor(), newPerProcessMetrics);
import java.util.Set;
            Metadata.builder(currentState.getMetadata()).putCustom(IngestMetadata.TYPE, new IngestMetadata(pipelines)).build()
import org.opensearch.ExceptionsHelper;
            allResults.addAll(results);
     * 3. a parameter of an IndexRequest.
     * Same as {@link #executeBulkRequest} but executes synchronously on the calling thread
                    + "] processors."
                for (Map.Entry<String, PipelineConfiguration> entry : ingestMetadata.getPipelines().entrySet()) {
            totalMetrics.after(ingestTimeInNanos);
                    if (result.getException() != null) {
                        IndexRequest indexRequest = slotIndexRequestMap.get(slotKey);
        clusterService.submitStateUpdateTask(
        // Here we cache it with index name + template as the suffix since currently we don't have the uuid.
                        actionRequestsTargetIndexUnchanged.add(actionRequests.get(i));
        }
                    List<IndexTemplateMetadata> templates = MetadataIndexTemplateService.findV1Templates(
                    processors.add(clazz.cast(wrappingProcessor.getInnerProcessor()));
                            results.get(i).getException()
            "put-pipeline-" + request.getId(),
        final IntConsumer onDropped,
                    "Pipeline id [%s] exceeds maximum length of %d UTF-8 bytes (actual: %d bytes)",
                processor = wrappingProcessor.getInnerProcessor();
        if (ingestPipeline == null) {
                if (exceptions == null) {
    }
                            "failed to execute pipeline [{}] for document [{}/{}]",
        ingestDocument.executePipeline(pipeline, (result, e) -> {
        }
                return List.of(childIndexRequest);
                }
        if (ingestPipeline == null) {
        Environment env,
        StringBuilder sb = new StringBuilder(5);
        ingestClusterStateListeners.forEach(consumer -> consumer.accept(state));
                }
     * @param pipelineId the pipeline to inspect
        }
                if (newPerProcessMetrics.size() == oldPerProcessMetrics.size()) {
        Pipeline pipeline,
            pipelineConfig.put(INDEX_TEMPLATE_MAPPINGS, mappingsMap);
import org.opensearch.cluster.ClusterChangedEvent;
                totalIndexRequestCounter,
                // the target index so need to check each request
                            return;
        if (indexRequests.size() == 1) {
import static org.opensearch.plugins.IngestPlugin.SystemIngestPipelineConfigKeys.INDEX_TEMPLATE_SETTINGS;
        final PipelineHolder holder = pipelines.get(pipelineId);
            executePipelines(
            }
     * @param metadata
                }
                newPipelines.put(newConfiguration.getId(), new PipelineHolder(newConfiguration, pipeline));
        BiConsumer<Thread, Exception> onCompletion,
            indexRequest.setSystemIngestPipeline(systemIngestPipelineId != null ? systemIngestPipelineId : NOOP_PIPELINE_NAME);
        for (IndexRequestWrapper indexRequestWrapper : indexRequestWrappers) {
        Map<String, PipelineHolder> newPipelines = null;
            return getPipelineFromHolder(holder, pipelineId);
                    return innerDelete(request, currentState);
            return;
    public Map<String, Processor.Factory> getSystemProcessorFactories() {
        final Map<String, IndexMetadata> previousIndices = event.previousState().metadata().indices();
        return newState.build();
            env,
     * get invoked.
                    for (Tuple<Processor, OperationMetrics> compositeMetric : newPerProcessMetrics) {
        return NOOP_PIPELINE_NAME.equals(indexRequest.getPipeline()) == false
                if (newPipelines == null) {
                batch.stream().map(IndexRequestWrapper::getIndexRequest).collect(Collectors.toList()),
    }
        sb.append(processor.getType());
        Map<SlotKey, IndexRequest> slotToindexRequestMap = new HashMap<>();
                    }
        ScriptService scriptService,
                            String oldType = oldCompositeMetric.v1().getType();
import org.opensearch.cluster.metadata.IndexTemplateMetadata;
                }
                updateIndexRequestWithIngestDocument(indexRequest, ingestDocument);
            pipelines = new HashMap<>();
                List<IngestDocumentWrapper> dropped = new ArrayList<>();
        putPipelineTaskKey = clusterService.registerClusterManagerTask(PUT_PIPELINE, true);
            this.pipelines = Collections.unmodifiableMap(newPipelines);
                    systemIngestPipelineId = getSystemIngestPipelineForTemplateV2(v2Template, indexRequest, settings);
                Pipeline pipeline = substitutePipeline(newConfiguration.getId(), parseException);
        // Iterate over the current active pipelines and check whether they are missing in the pipeline configuration and
        DocWriteRequest<?> actionRequest,
                    } else {
        }
        for (String pipelineKey : pipelines.keySet()) {
        Map<String, Processor.Factory> processorFactories = new HashMap<>();
        }
    ) {
                    }
                        if (defaultPipeline != null && finalPipeline != null) {
        Map<SlotKey, IndexRequest> slotIndexRequestMap = new HashMap<>();
            if (requestPipeline != null) {
                batch.stream().map(IndexRequestWrapper::getChildSlot).collect(Collectors.toList()),
        }
                }
                indexRequest.setPipeline(requestPipeline);
                } else {
                    createIndexIdWithTemplateSuffix(previousIndexMetadata.getIndex().getName())
        for (PipelineConfiguration newConfiguration : newIngestMetadata.getPipelines().values()) {
                        pipelineInfoIterator,
        final Iterator<IngestPipelineInfo> pipelineInfoIterator,
                        SlotKey slotKey = new SlotKey(results.get(i).getSlot(), results.get(i).getChildSlot());
        }
        if (ingestInfos.isEmpty()) {
        // Lazy initialize these variables in order to favour the most like scenario that there are no pipeline changes:
     * @return If the index request has an ingest pipeline or not.
                indexRequest.setSystemIngestPipeline(NOOP_PIPELINE_NAME);
        }
        // or the pipeline configuration has been modified
            throw new IllegalArgumentException("pipeline with id [" + pipelineId + "] does not exist");
import org.opensearch.indices.IndicesService;
                        onCompletion,
            } else {
        if (indexRequest.getPipeline() == null) {
            return;
                            hasInvalidTargetIndexChange = true;
        } else {
            }
                    );
                actionRequests.get(0),
            for (int childSlot = 0; childSlot < childIndexRequests.size(); childSlot++) {
        // check the alias for the index request (this is how normal index requests are modeled)
            if (newPipelines == null) {
        List<Integer> slots,
        BiConsumer<Integer, Exception> onFailure,
        logger.debug("batchSize: {}, batches: {}", batchSize, batches.size());
        Consumer<List<IngestDocumentWrapper>> handler
                statsBuilder.addProcessorMetrics(id, getProcessorName(processor), processor.getType(), processorMetric);
    }
                    + "] which exceeds the maximum allowed configuration of ["
            List<Tuple<Processor, OperationMetrics>> processorMetrics = new ArrayList<>();
                        + templateName
    );
                    if (Objects.equals(originalIndex, indexRequest.indices()[0]) == false) {
     * Gets all the Processors of the given type from within a Pipeline.
            executePipelinesInBatchRequests(
            // In some edge cases it is possible the cache is invalidated after we resolve the
                        }
                        defaultPipeline = IndexSettings.DEFAULT_PIPELINE.get(settings);
                @Override
            throw new RuntimeException("Should not executePipelines when the pipeline iterator does not have next pipeline.");
                String v2Template = MetadataIndexTemplateService.findV2Template(metadata, indexRequest.index(), false);
                newPipelines = new HashMap<>(existingPipelines);
 * The OpenSearch Contributors require contributions made to
            return;
                    return new AcknowledgedResponse(acknowledged);
            pipelineConfig.put(INDEX_TEMPLATE_SETTINGS, settings == null ? Collections.emptyList() : List.of(settings));
            sb.append(":");
                    Locale.ROOT,
             * has been forwarded by a non-ingest coordinating node to an ingest node. In this case, the coordinating node will have
        );
            } catch (Exception e) {
        return new IngestInfo(processorInfoList);
        }
        String index = indexRequest.index();
                                + template.name(),
            final Map<String, Object> pipelineConfig = new HashMap<>();
        if (IngestPipelineType.SYSTEM_FINAL.equals(pipelineType)) {
                }
    public <P extends Processor> List<P> getProcessorsInPipeline(String pipelineId, Class<P> clazz) {
     * Adds a listener that gets invoked with the current cluster state before processor factories
    /**
 * Modifications Copyright OpenSearch Contributors. See
                        systemIngestPipelineId = getSystemIngestPipelineForTemplateV2(v2Template, indexRequest, settings);
            String index = indexRequestWrapper.getIndexRequest().index();
        final Iterator<IngestPipelineInfo> pipelineInfoIterator,
                runBulkRequestInBatch(numberOfActionRequests, actionRequests, onFailure, onCompletion, onDropped);
import java.util.HashMap;
                processors.add(clazz.cast(processor));
        Setting.Property.Dynamic
                        indexRequest.index(),
        IngestPipelineType pipelineType,
            );
                // the index does not exist yet (and this is a valid request), so match index
            }
    }
                }
        SystemIngestPipelineCache systemIngestPipelineCache
    public Pipeline getPipeline(String id) {
    Map<String, PipelineHolder> pipelines() {
        this.scriptService = scriptService;
    // Returning PipelineConfiguration instead of Pipeline, because Pipeline and Processor interface don't
                final String pipelineId = indexRequest.getPipeline();
                slots.get(0),
        final String indexId = indexMetadata.getIndex().toString();
            }
    }
        // We need to cache it so that later during execution we can find it by indexId to reuse it.
        List<Integer> slots,
                    // order of templates are highest order first
            if (indexPipeline == null) {
    /**
                } catch (IOException e) {
             * pipeline for this request has already been derived yet we execute this loop again. That occurs if the bulk request
        Map<String, Processor.Factory> processorFactories = new HashMap<>();
                        indexRequestsTargetIndexUnchanged.add(indexRequest);
        indexRequest.isPipelineResolved(false);
            if (processor instanceof CompoundProcessor compoundProc) {
        if (currentIngestMetadata != null) {
    }
    /**
                    completeExecution(counter, onCompletion, originalThread, 1);
            Processor processor = processorWithMetric.v1();
        if (metadataMap.get(IngestDocument.Metadata.VERSION_TYPE) != null) {
                        );
            return indexPipeline;
    }
            sb.append(":");
            }
            innerExecute(slot, indexRequest, pipeline, onDropped, e -> {
    private final ThreadPool threadPool;
                    return deletePipelineTaskKey;
import org.opensearch.OpenSearchParseException;
import org.opensearch.common.xcontent.XContentHelper;
    }
                toRemove.add(pipelineKey);
            final String requestPipeline = indexRequest.getPipeline();
            Map<String, Processor.Factory> newProcessors = ingestPlugin.getProcessors(parameters);
        return ingestPipeline.getProcessors().isEmpty() ? null : indexId;
        final Processor.Parameters processorParameters = new Processor.Parameters(
        int numberOfActionRequests,
            PipelineHolder previous = existingPipelines.get(newConfiguration.getId());
 * the Apache License, Version 2.0 (the "License"); you may
                        e
        final String pipelineId = pipelineInfo.getPipelineId();
        int numberOfActionRequests,
                                i,
        IntConsumer itemDroppedHandler,
        );
            onCompletion.accept(originalThread, null);
     * @return the processorMetrics for all non-failure processor that belong to the original compoundProcessor
            Pipeline indexPipeline = systemIngestPipelineCache.getSystemIngestPipeline(pipelineId);
        );
                        totalMetrics.failed();
                        if (defaultPipeline == null && IndexSettings.DEFAULT_PIPELINE.exists(settings)) {
        indexRequest.isPipelineResolved(true);
        IntConsumer onDropped,
                    updateIndexRequestWithIngestDocument(slotToindexRequestMap.get(slotKey), ingestDocumentWrapper.getIngestDocument());
                    dropped.forEach(t -> itemDroppedHandler.accept(t.getSlot()));
                    newPipelines = new HashMap<>(existingPipelines);
     */
                    if (results.get(i).getException() != null) {
                if (this.isSystemIngestPipelineEnabled) {
                            indexRequest.index(),
            }
                    pipelineId,
     */
    private volatile Map<String, PipelineHolder> pipelines = Collections.emptyMap();
                        if (oldMetricsIterator.hasNext()) {
                            resetPipelineAfterIndexChange(indexRequest);
                            "Failed to resolve system ingest pipeline due to failed to parse the mappings ["
import org.opensearch.core.service.ReportingService;
        List<Processor> processors = pipeline.flattenAllProcessors();
                @Override
            onCompletion.accept(originalThread, null);
        for (DocWriteRequest<?> actionRequest : actionRequests) {
import static org.opensearch.cluster.service.ClusterManagerTask.PUT_PIPELINE;
            }
        threadPool.executor(executorName).execute(new AbstractRunnable() {
        if (pipelineInfoIterator.hasNext() == false) {
     * This is useful for components that are used by ingest processors, so that they have the opportunity to update
        final Pipeline pipeline = Pipeline.createSystemIngestPipeline(indexId, systemIngestProcessorFactories, pipelineConfig);
    }
        for (IngestPlugin ingestPlugin : ingestPlugins) {
        ingestClusterStateListeners.add(listener);
                    continue;
     * @return pipeline configuration specified by id. If multiple ids or wildcards are specified multiple pipelines
                List<IngestDocumentWrapper> succeeded = new ArrayList<>();
                Pipeline newPipeline = Pipeline.create(
                    onFailure.accept(slot, e);
        final AtomicInteger totalIndexRequestCounter,
                // Prefer the conditional's metric since it only includes metrics when the conditional evaluated to true.
 * KIND, either express or implied.  See the License for the
                        () -> new ParameterizedMessage(
                        }
                    }
                }
import org.opensearch.action.ingest.DeletePipelineRequest;
    /**
    }
                onCompletion.accept(null, e);
            if (results.isEmpty()) return;
                        assert totalIndexRequestCounter.get() >= 0;
 * SPDX-License-Identifier: Apache-2.0
        Client client,
     * @param originalRequest
                pipelineInfoIterator,
        for (List<IndexRequestWrapper> batch : batches) {
            threadPool.generic()::execute,
                String.format(
    ) {
    private void innerExecute(
            return Collections.emptyList();
        }
                OperationMetrics processorMetric = t.v2();
                ExceptionsHelper.rethrowAndSuppress(exceptions);
            for (final CompressedXContent mapping : mappings) {
     */
        // if so delete the pipeline from new Pipelines map:
import java.util.function.IntConsumer;
     * Only IndexRequests in the same group could be batched. It's to ensure batched documents always
    private static Map<SlotKey, IndexRequest> createSlotIndexRequestMap(
                indexRequest.setPipeline(NOOP_PIPELINE_NAME);
     */
            // system ingest pipeline on this node one more time.
                indexRequest.setSystemIngestPipeline(NOOP_PIPELINE_NAME);
     * @param slot the slot in the original bulk request
        return statsBuilder.build();
                return type;
            // We don't pass in child slot to single index request pipeline executions since we have
                    Settings settings = MetadataIndexTemplateService.resolveSettings(metadata, v2Template);
            } catch (OpenSearchParseException e) {
    public boolean resolvePipelines(final DocWriteRequest<?> originalRequest, final IndexRequest indexRequest, final Metadata metadata) {
        BiConsumer<Thread, Exception> onCompletion,
     * @param clazz the Processor class to look for
            // IndexRequests are grouped by their index + pipeline ids + pipeline type
        }
                }
                        indexRequestsPerKey.getValue().subList(i, i + Math.min(batchSize, indexRequestsPerKey.getValue().size() - i))
    ) {
        List<IndexRequest> indexRequests,
    public void applyClusterState(final ClusterChangedEvent event) {
    }
import org.opensearch.action.ingest.PutPipelineRequest;
                exceptions.add(e);
            }
            }
        // processor factories create new processor instances.
        // when only the part of the cluster state that a component is interested in, is updated.)
                onCompletion,
            getProcessorMetrics(rootProcessor, processorMetrics);
            for (int i = 0; i < indexRequestsPerKey.getValue().size(); i += Math.min(indexRequestsPerKey.getValue().size(), batchSize)) {
                return;
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                }
    // know how to serialize themselves.
import org.opensearch.index.mapper.MapperService;
            // pipeline or the request is forwarded from a non-ingest node. In that case we should try to resolve the
    private final List<Consumer<ClusterState>> ingestClusterStateListeners = new CopyOnWriteArrayList<>();
                // break in the case of self referencing processors in the event a processor author creates a
        deletePipelineTaskKey = clusterService.registerClusterManagerTask(DELETE_PIPELINE, true);
        AtomicInteger counter = new AtomicInteger(size);
            innerBatchExecute(slots, childSlot, indexRequests, pipeline, onDropped, results -> {
        Integer.MAX_VALUE,
                @Override
    private static List<Tuple<Processor, OperationMetrics>> getProcessorMetrics(
     * Record object to lookup bulk request items by their slot/child slot key.
        }
            throw new ResourceNotFoundException("pipeline [{}] is missing", request.getId());
            indexRequest.sourceAsMap()
        @NonNull final List<IndexTemplateMetadata> templates,
import org.opensearch.action.bulk.TransportBulkAction;
import org.opensearch.action.index.IndexRequest;
import org.opensearch.common.regex.Regex;
                        // the new target index in TransportBulkAction.
        return ingestDocumentWrappers;
                    break;
        validateProcessorCountForIngestPipeline(pipeline);
            }
    }
                () -> new ParameterizedMessage(
        this.systemIngestProcessorFactories = systemProcessorFactories(ingestPlugins, processorParameters);
        }
                );
        }
            final IngestPipelineType pipelineType = pipelineInfo.getType();
             * can not double-resolve the pipeline because we will not be able to distinguish the case of the pipeline having been
             * already resolved the pipeline for this request. It is important that we are able to distinguish this situation as we
                @Override
        final Thread originalThread
    private final SystemIngestPipelineCache systemIngestPipelineCache;
            (delay, command) -> threadPool.schedule(command, TimeValue.timeValueMillis(delay), ThreadPool.Names.GENERIC),
                }
        }
     * where dedicated processor threads can safely block. Do not invoke from a TransportAction
             * We have to track whether the pipeline for this request has already been resolved. It can happen that the
                        originalThread
        }
    /**
    }
        try {
        long startTimeInNanos = System.nanoTime();
     * Resolves only the system ingest pipeline for the index request.
                            finalPipeline = IndexSettings.FINAL_PIPELINE.get(settings);
            completeExecution(totalIndexRequestCounter, onCompletion, originalThread, indexRequests.size());
                    scriptService
            /*
        Pipeline pipeline = getPipeline(pipelineId);
     * @return True if the pipeline contains an instance of the Processor class passed in
     * We will not execute the default pipeline of the new target index so we don't reset it as null and keep it as
    }
        }
        final IndexRequest indexRequest,
    private void executePipelinesInBatchRequests(
                pipelineConfig.put(INDEX_MAPPINGS, mappingMetadata.getSourceAsMap());
                    SlotKey slotKey = new SlotKey(ingestDocumentWrapper.getSlot(), ingestDocumentWrapper.getChildSlot());
     * Recursive method to obtain all of the non-failure processors for given compoundProcessor. Since conditionals are implemented as
     * This is a subcase of {@link IngestService#resolvePipelines}
        IngestStats.Builder statsBuilder = new IngestStats.Builder();
                        onFailure.accept(results.get(i).getSlot(), results.get(i).getException());
            completeExecution(counter, onCompletion, originalThread, 1);
            });
 * software distributed under the License is distributed on an
                indexMetadata = indexAbstraction.getWriteIndex();
                // handle index change case
                if (IndexSettings.DEFAULT_PIPELINE.exists(indexSettings)) {
                        if (finalPipeline == null && IndexSettings.FINAL_PIPELINE.exists(settings)) {
import org.opensearch.common.compress.CompressedXContent;
    private volatile ClusterState state;
        final BiConsumer<Thread, Exception> onCompletion,
import org.opensearch.common.unit.TimeValue;
        List<PipelineConfiguration> result = new ArrayList<>(ids.length);
                    settingsList.add(template.settings());
                    if (this.isSystemIngestPipelineEnabled) {
    private void resetPipelineAfterIndexChange(IndexRequest indexRequest) {
            final String indexName = entry.getKey();
        final AtomicInteger counter,
                    documentLogBuilder.append(", ");
        for (Map.Entry<String, PipelineHolder> entry : existingPipelines.entrySet()) {
        final Pipeline pipeline;
                            // we can not break in case a lower-order template has a final pipeline that we need to collect
                String v2Template = MetadataIndexTemplateService.findV2Template(metadata, indexRequest.index(), false);
                    );
        String tag = processor.getTag();
                // in a valid null case if this is the last pipeline we should complete the execution
        IngestMetadata newIngestMetadata = state.getMetadata().custom(IngestMetadata.TYPE);
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
        indexRequest.version(((Number) metadataMap.get(IngestDocument.Metadata.VERSION)).longValue());
                        null
import org.opensearch.common.collect.Tuple;
        }
                    // Drain old it so it's not looped over. We will re-process the pipelines of the request with
                handler.accept(allResults);
                IndexRequest indexRequest = childIndexRequests.get(childSlot);
    }
package org.opensearch.ingest;
            final IndexMetadata indexMetadata = getIndexMetadata(originalRequest, indexRequest, metadata);
            List<String> pipelineInfo = indexRequestWrapper.getIngestPipelineInfoList()
            public void onFailure(Exception e) {
        BiConsumer<Integer, Exception> onFailure,
        final List<Integer> slots,
        final PipelineConfiguration configuration;
        IndexMetadata indexMetadata = null;
                            defaultPipeline = IndexSettings.DEFAULT_PIPELINE.get(settings);
            for (final IndexTemplateMetadata template : templates) {
                    for (final IndexTemplateMetadata template : templates) {
            StringBuilder documentLogBuilder = new StringBuilder();
                }
        }
                    } else {
    /**
    private Pipeline createSystemIngestPipeline(@NonNull final String indexId, @NonNull final Map<String, Object> pipelineConfig) {
     */
            assert previousIndexMetadata != null : "IndexMetadata in the previous state metadata indices should not be null.";
     * @param processorMetrics The list of {@link Processor} {@link OperationMetrics} tuples.
            }
 * compatible open source license.
import java.util.List;
                if (e != null) {
        }
    private volatile boolean isSystemIngestPipelineEnabled;
            slotIndexRequestMap.put(new SlotKey(slots.get(i), childSlots.get(i)), indexRequests.get(i));
            return new ArrayList<>(ingestMetadata.getPipelines().values());
                    completeExecution(counter, onCompletion, originalThread, 1);
     * wrappers to the actual processor, always prefer the actual processor's metric over the conditional processor's metric.
            if (pipeline == null) {
        };
            }
            }
                protected AcknowledgedResponse newResponse(boolean acknowledged) {
                if (pipelineId != null && IngestService.NOOP_PIPELINE_NAME.equals(pipelineId) == false) {
            return currentState;
                batchedIndexRequests.add(
                                + template.mappings().string()
import org.opensearch.cluster.metadata.MappingMetadata;
import org.opensearch.common.settings.Settings;
    public void delete(DeletePipelineRequest request, ActionListener<AcknowledgedResponse> listener) {
            } else if (indexRequest.index() != null) {
        String errorMessage = "pipeline with id [" + id + "] could not be loaded, caused by [" + e.getDetailedMessage() + "]";
            if (Regex.isSimpleMatchPattern(id)) {
        if (processor instanceof ConditionalProcessor conditionalProc) {
        @NonNull final AtomicInteger counter,
                        onFailure,
        final String indexId = createIndexIdWithTemplateSuffix(indexRequest.index());
            String defaultPipeline = null;
                        pipelineInfoIterator,
        });
    private String getSystemIngestPipelineForExistingIndex(@NonNull final IndexMetadata indexMetadata, IndexRequest indexRequest) {
    // are loaded, so in the cluster state we just save the pipeline config and here we keep the actual pipelines around.
                )
        // (Note that this needs to be done also in the case when there is no change to ingest metadata, because in the case
import org.apache.logging.log4j.LogManager;
        // return whether this index request has a pipeline
        indexRequest.setSystemIngestPipeline(systemIngestPipelineId != null ? systemIngestPipelineId : NOOP_PIPELINE_NAME);
        }
        return pipelines;
    }
                    throw new RuntimeException("[" + entry.getKey() + "] is not a system generated processor factory.");
                }
        final IndexRequest indexRequest,
                onFailure.accept(slots.get(i), e);
                if (processor instanceof ConditionalProcessor conditionalProc) {
import org.opensearch.index.VersionType;
        return new IngestDocumentWrapper(slot, childSlot, toIngestDocument(indexRequest), null);
 * You may obtain a copy of the License at
            indexRequest.index(),
        }
    }
        PutPipelineRequest request,
        if (pipelineInfoIterator.hasNext() == false) {
        pipeline.batchExecute(ingestDocumentWrappers, results -> {
        final Map<String, IndexMetadata> currentIndices = event.state().metadata().indices();
    /**
            processorInfoList.add(new ProcessorInfo(entry.getKey()));
     * @param metadata
            threadPool::relativeTimeInMillis,
        final Metadata metadata
    }
        List<List<IndexRequestWrapper>> batches = prepareBatches(batchSize, indexRequestWrappers);
    public IngestService(
        List<Integer> slots,
     * 1. bound with index
                // the index does not exist yet (and this is a valid request), so match index
    public static final Setting<Boolean> SYSTEM_INGEST_PIPELINE_ENABLED = Setting.boolSetting(
            return;
    private void invalidateSystemIngestPipeline(@NonNull final ClusterChangedEvent event) {
        PipelineHolder holder = pipelines.get(id);
    ) {
                indexMetadata = indexAbstraction.getWriteIndex();
            }
                        onDropped,
            }
        "cluster.ingest.max_number_processors",
            );
                    // the new target index in TransportBulkAction.
            indexAndPipelineIds.addAll(pipelineInfo);
            if (settings != null) {
     */
    private final NamedXContentRegistry xContentRegistry;
            protected void doRun() {
     * @param indexRequest An index request.
     * without dispatching to a thread pool. This is intended for use by pull-based ingestion
import java.util.Collections;
        }
            if (currentIndexMetadata == null || ClusterChangedEvent.indexMetadataChanged(previousIndexMetadata, currentIndexMetadata)) {
                    );
                            if (type.equals(oldType)) {
                originalThread
        List<IndexRequest> indexRequests
                        totalMetrics.failed();
    ) throws Exception {
    private String getSystemIngestPipelineForTemplateV2(
                    if (IndexSettings.FINAL_PIPELINE.exists(settings)) {
            String pipelineName = pipelineProc.getPipelineTemplate().newInstance(Collections.emptyMap()).execute();
     * An IndexRequest could be preprocessed by at most three pipelines: default_pipeline, final_pipeline, and system_pipeline.
            String originalIndex = indexRequests.get(0).indices()[0];
import org.opensearch.gateway.GatewayService;
                }
        // We need to cache it so that later during execution we can find it by indexId to reuse it.
                "Cannot use more than the maximum processors allowed. Number of processors being configured is ["
     *
            || NOOP_PIPELINE_NAME.equals(indexRequest.getSystemIngestPipeline()) == false;
    }
    ) {
                    }
        this.maxIngestProcessorCount = maxIngestProcessorCount;
        final Map<String, PipelineConfiguration> pipelinesCopy = new HashMap<>(pipelines);
                }
        for (int i = 0; i < slots.size(); ++i) {
import org.opensearch.cluster.metadata.Metadata;
        for (String id : ids) {
            }
            });
    protected SystemIngestPipelineCache getSystemIngestPipelineCache() {
             * pipeline parameter too.
    }
        }
             * these cases as we need to reject the request if the pipeline was set by a required pipeline and there is a request
            @Override
        // we only set the pipeline in request when there is a processor
            pipelinesCopy.remove(key);
        Map<IngestDocument.Metadata, Object> metadataMap = ingestDocument.extractMetadata();
                onFailure,
                }
    }
        return pipeline;
                    newConfiguration.getId(),
        List<IngestDocumentWrapper> ingestDocumentWrappers = new ArrayList<>();
                }
            Map<SlotKey, IndexRequest> slotIndexRequestMap = createSlotIndexRequestMap(slots, childSlot, indexRequests);
        this.xContentRegistry = xContentRegistry;
     * _none. So in re-process it will be treated as the no-op. We are not sure if this is the ideal behavior, but it is
/*
    }
        if (originalRequest != null) {
        if (holder == null) {
            Metadata.builder(currentState.getMetadata()).putCustom(IngestMetadata.TYPE, new IngestMetadata(pipelinesCopy)).build()
                List<IngestDocumentWrapper> exceptions = new ArrayList<>();
        if (ingestPipeline == null) {
        if (indexRequest.isPipelineResolved() == false && this.isSystemIngestPipelineEnabled) {
        newState.metadata(
        // we only set the pipeline in request when there is a processor
        }
        }
                    }
     * @param originalRequest
    private static IngestDocumentWrapper toIngestDocumentWrapper(int slot, int childSlot, IndexRequest indexRequest) {
 * not use this file except in compliance with the License.
        // Parent/child slots are used to map index requests to their position in the original bulk request list.
        validatePipeline(ingestInfos, request);
        @NonNull final Thread originalThread,
                        } else {
            logger.debug(
        NamedXContentRegistry xContentRegistry,
     */
     * @return If the index request has an ingest pipeline or not.
        if (pipeline.getProcessors().isEmpty()) {
            throw new IllegalArgumentException("pipeline with id [" + pipelineId + "] does not exist");
    }
                    completeExecution(totalIndexRequestCounter, onCompletion, originalThread, results.size());
                slot++;
                long ingestTimeInNanos = System.nanoTime() - startTimeInNanos;
        if (ingestMetadata == null) {
                if (previous == null) {
public class IngestService implements ClusterStateApplier, ReportingService<IngestInfo> {
            // Update the pipelines:
                // precedence), or if a V2 template does not match, any V1 templates
import org.opensearch.cluster.AckedClusterStateUpdateTask;
        IntConsumer onDropped
        indexRequest.source(ingestDocument.getSourceAndMetadata(), indexRequest.getContentType());
                "Should not executePipelinesInBatchRequests when the pipeline iterator does not have next pipeline."
    );
        ClusterService clusterService,
        // it's fine to set all metadata fields all the time, as ingest document holds their starting values
                if (IndexSettings.FINAL_PIPELINE.exists(indexSettings)) {
            for (Map.Entry<String, Processor.Factory> entry : newProcessors.entrySet()) {
    static List<PipelineConfiguration> innerGetPipelines(IngestMetadata ingestMetadata, String... ids) {
                for (IngestDocumentWrapper result : allResults) {
                ),
    private IndexMetadata getIndexMetadata(DocWriteRequest<?> originalRequest, IndexRequest indexRequest, Metadata metadata) {
        String systemIngestPipelineId = null;
            indexMetadata = metadata.indices().get(originalRequest.index());
    @Override
     * or request thread — use {@link #executeBulkRequest} instead.
                            OperationMetrics oldMetric = oldCompositeMetric.v2();
                public ClusterState execute(ClusterState currentState) {
            final IndexMetadata currentIndexMetadata = currentIndices.get(indexName);
            final IndexMetadata indexMetadata = getIndexMetadata(originalRequest, indexRequest, metadata);
                            );
                final List<DocWriteRequest<?>> actionRequestsTargetIndexUnchanged = new ArrayList<>();
                    }
            indexRequest.routing(),
                );
    }
        List<ProcessorInfo> processorInfoList = new ArrayList<>(processorFactories.size());
     * In this function we will reset the pipeline for the index request to make it like the pipeline not resolved.
                    // find the final pipeline if one is defined from an existing index setting
     * <p>
                        totalIndexRequestCounter,
                    if (Regex.simpleMatch(id, entry.getKey())) {
        // If the default or final pipelines were resolved previously we don't want to overwrite them.
        return processorMetrics;
                    return new AcknowledgedResponse(acknowledged);
                if (wrappingProcessor == processor) {
            if (counter.addAndGet(-results.size()) == 0) {
        return holder.pipeline;
        pipelines.put(request.getId(), new PipelineConfiguration(request.getId(), request.getSource(), request.getMediaType()));
            indexRequest.version(),
        return slotIndexRequestMap;
    static List<List<IndexRequestWrapper>> prepareBatches(int batchSize, List<IndexRequestWrapper> indexRequestWrappers) {
                                "failed to execute pipeline [{}] for document [{}/{}]",
        // (e.g. the pipeline may have been removed while we're ingesting a document
            final Settings settings = indexMetadata.getSettings();
            return;
                if (template.mappings() != null) {
        final IngestPipelineType pipelineInfoType = pipelineInfo.getType();
import java.util.function.Consumer;
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + processors.size()
            public String getType() {
                if (Objects.equals(originalIndex, newIndex) == false) {
                e
                }
                protected AcknowledgedResponse newResponse(boolean acknowledged) {
        // we can get an empty pipeline from the cache
                IndexRequest indexRequest = indexRequests.get(i);
 * this work for additional information regarding copyright
                    pipelinesInfoList.add(new IngestPipelineInfo(finalPipelineId, IngestPipelineType.FINAL));
     * @param childSlot the child slot in the action request
                boolean hasTargetIndexChanged = false;
        for (Tuple<Processor, OperationMetrics> processorWithMetric : compoundProcessor.getProcessorsWithMetrics()) {
                        resetPipelineAfterIndexChange(indexRequest);
                if (hasTargetIndexChanged == true) {
                documentLogBuilder.append("/");
            );
                        + ". Root cause: "
            new AckedClusterStateUpdateTask<AcknowledgedResponse>(request, listener) {
    public void putPipeline(
            final Map<String, Object> pipelineConfig = new HashMap<>();
        pipelines.forEach((id, holder) -> {
        );
    static class PipelineHolder {
        final String indexId = createIndexIdWithTemplateSuffix(indexRequest.index());
            }
        IngestMetadata currentIngestMetadata = currentState.metadata().custom(IngestMetadata.TYPE);
        final Thread originalThread = Thread.currentThread();
            new AckedClusterStateUpdateTask<AcknowledgedResponse>(request, listener) {
 * Unless required by applicable law or agreed to in writing,
                    pipelineIdLength
        }
        return processors;
        1,
        }
        clusterService.getClusterSettings().addSettingsUpdateConsumer(MAX_NUMBER_OF_INGEST_PROCESSORS, this::setMaxIngestProcessorCount);
        try {
            return null;
    // We know of all the processor factories when a node with all its plugin have been initialized. Also some
                String type = processor.getType();
    }
            ingestPipeline = createSystemIngestPipeline(indexId, pipelineConfig);
        AnalysisRegistry analysisRegistry,
        return newState.build();
     * Defines the limit for the number of processors an ingest pipeline can have.
        for (int i = 0; i < slots.size(); ++i) {
     * Used to match success/exceptions to their original requests post batch splitting
                    Settings settings = MetadataIndexTemplateService.resolveSettings(metadata, v2Template);
        // Used to track progress of pipeline executions on index requests across parallel threads
 * ownership. Elasticsearch licenses this file to you under
                        counter,
import org.opensearch.cluster.ClusterState;
        return batchedIndexRequests;
     * These are defined by system ingest processors implemented by plugins.
        Processor.Parameters parameters
        Setting.Property.NodeScope,
        final DocWriteRequest<?> actionRequest,
                        }
        List<Integer> childSlots,
            try {
        return NOOP_PIPELINE_NAME.equals(indexRequest.getSystemIngestPipeline()) == false;
                mappings = MetadataIndexTemplateService.collectMappings(state, templateName, indexRequest.index());
                    }
                totalIndexRequestCounter,
                    "Failed to resolve system ingest pipeline due to not able to collect mappings for template: "
                if (v2Template != null) {
        return scriptService;
                    } catch (IOException e) {
        IntConsumer onDropped
    }
    private String createIndexIdWithTemplateSuffix(@NonNull final String indexName) {
    private static final Logger logger = LogManager.getLogger(IngestService.class);
        Consumer<Exception> handler
 *
        // If we don't need to execute any pipelines, we exit pipeline execution early
                return Collections.emptyList();
                // the per processor metrics may get reset when the arrays don't match. However, to get to an ideal model, unique and
            indexRequest.id(),
                    "failed to execute pipeline [{}] for document [{}/{}]",
        for (Map.Entry<Integer, List<IndexRequestWrapper>> indexRequestsPerKey : indexRequestsPerIndexAndPipelines.entrySet()) {
        int batchSize = numberOfActionRequests;
     */
                if (pipelineInfoIterator.hasNext() == false) {
     * could come from three places:
                        indexRequestsTargetIndexUnchanged,
        if (indexRequest.getFinalPipeline() == null) {
            if (indexAbstraction != null) {
                                new IllegalStateException(pipelineInfoType + " pipeline [" + pipelineId + "] can't change the target index")
        List<List<IndexRequestWrapper>> batchedIndexRequests = new ArrayList<>();
        if (metadataMap.get(IngestDocument.Metadata.IF_PRIMARY_TERM) != null) {
     * A final_pipeline is configured on index level. The default_pipeline for a IndexRequest in a _bulk API
        }
                    "failed to execute pipeline [{}] for documents [{}]",
                .toList();
import java.util.function.BiConsumer;
            }
                if (!dropped.isEmpty()) {
import org.opensearch.cluster.service.ClusterService;
                }
                originalThread
 *
                        OperationMetrics metric = compositeMetric.v2();
                if (pipelineInfoIterator.hasNext() == false) {
        indexRequest.setFinalPipeline(null);
        Setting.Property.Dynamic
     * the existing behavior and can avoid infinite index re-route so we decide to keep this behavior.
     * @param compoundProcessor The compound processor to start walking the non-failure processors
            Pipeline pipeline = holder.pipeline;
                        slots,
    ) {
    /**
import java.util.concurrent.atomic.AtomicInteger;
    }
import org.opensearch.index.IndexSettings;
        Map<String, Processor.Factory> processorFactories = getProcessorFactories();
                        hasTargetIndexChanged = true;
        invalidateSystemIngestPipeline(event);
        @NonNull final IndexRequest indexRequest
        state = event.state();
    @Override
        List<P> processors = new ArrayList<>();
                            // we can break if we have already collected a default and final pipeline
            analysisRegistry,
                        // target index unchanged.
                    String message = "Processor type [" + processor.getType() + "] is not installed on node [" + entry.getKey() + "]";
 */
 */
            // Rethrow errors that may have occurred during creating new pipeline instances:
    private void setIsSystemIngestPipelineEnabled(final boolean isSystemIngestPipelineEnabled) {
    }
     * Deletes the pipeline specified by id in the request.
        if (actionRequest instanceof UpdateRequest updateRequest) {
        if (currentIngestMetadata == null) {
    /**
 */
        int numberOfActionRequests,
    }
        IndexRequest indexRequest
                    exceptions.add(ConfigurationUtils.newConfigurationException(processor.getType(), processor.getTag(), null, message));
            for (int i = 0; i < indexRequests.size(); ++i) {
import reactor.util.annotation.NonNull;
            );
            } else {
        }
                }
                    }
            }
            client,
                        logger.debug(
                            () -> new ParameterizedMessage(
        totalMetrics.beforeN(size);
        final String pipelineId = pipelineInfo.getPipelineId();
        ExceptionsHelper.rethrowAndSuppress(exceptions);
            } else {
        }
        final int slot,
        }
                if (clazz.isAssignableFrom(wrappingProcessor.getInnerProcessor().getClass())) {
                        pipelineInfoIterator.forEachRemaining($ -> {});
import org.opensearch.cluster.metadata.IndexMetadata;
    }
}
                        childSlot,
import org.opensearch.common.util.concurrent.AbstractRunnable;
                    indexRequest.id()
                // Best attempt to populate new processor metrics using a parallel array of the old metrics. This is not ideal since
                e
        Iterable<DocWriteRequest<?>> actionRequests,
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.common.settings.Setting;
            if (mappingMetadata != null) {
        } else if (toRemove.isEmpty()) {
                continue;
    }
import org.opensearch.common.metrics.OperationMetrics;
    // package private for testing
            "delete-pipeline-" + request.getId(),
                    defaultPipeline = IndexSettings.DEFAULT_PIPELINE.get(indexSettings);
                    systemIngestPipelineId = getSystemIngestPipelineForExistingIndex(indexMetadata, indexRequest);
            int hashCode = indexAndPipelineIds.hashCode();
            OperationMetrics metric = processorWithMetric.v2();
        Set<String> toRemove = new HashSet<>();
    }
    }
                        // update the counter before we continue to execute the next pipeline for the requests with
        final IngestPipelineInfo pipelineInfo = pipelineInfoIterator.next();
        return sb.toString();
            }
        } else {
            throw new IllegalArgumentException(
                        mappingsMap.add(MapperService.parseMapping(xContentRegistry, template.mappings().string()));
            || NOOP_PIPELINE_NAME.equals(indexRequest.getFinalPipeline()) == false
                    processorFactories,
                indexRequest.setFinalPipeline(NOOP_PIPELINE_NAME);
            if (previous != null && previous.configuration.equals(newConfiguration)) {
            throw new IllegalStateException("Ingest info is empty");
    ) {
    public ScriptService getScriptService() {
        }
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
                final String systemPipelineId = indexRequest.getSystemIngestPipeline();
     * Resolve the ingest pipeline, final ingest pipeline and system ingest pipeline for the request.
                        final Settings settings = template.settings();
    public void addIngestClusterStateListener(Consumer<ClusterState> listener) {
                }
        newState.metadata(
                        if (IngestPipelineType.FINAL.equals(pipelineInfoType) || IngestPipelineType.SYSTEM_FINAL.equals(pipelineInfoType)) {
    public void validateProcessorCountForIngestPipeline(Pipeline pipeline) {
            } else if (indexRequest.index() != null) {
    }
                        if (totalIndexRequestCounter.addAndGet(-(indexRequests.size() - indexRequestsTargetIndexUnchanged.size())) == 0) {
        }
            while (processor instanceof WrappingProcessor wrappingProcessor) {
     * @param indexRequest
        final BiConsumer<Integer, Exception> onFailure,
    }
        }
        this.clusterService = clusterService;
                } else {
            if (childIndexRequest != null) {
                        onCompletion,
                        originalThread
                    finalPipeline = IndexSettings.FINAL_PIPELINE.get(indexSettings);
                    if (indexRequestsTargetIndexUnchanged.isEmpty()) {
    private Map<String, Processor.Factory> systemIngestProcessorFactories = null;
        // if we didn't ask for _any_ ID, then we get them all (this is the same as if they ask for '*')
            IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(originalRequest.index());
                    exceptions = new ArrayList<>();
        List<IndexRequest> indexRequests
import org.apache.logging.log4j.Logger;
                .map((IngestPipelineInfo::toString))
                documentLogBuilder.append(indexRequest.index());
    }
                continue;
        CompoundProcessor compoundProcessor,
            @Override
                if (exceptions == null) {
            String originalIndex = indexRequest.indices()[0];
                    pipelineId,
            indexAndPipelineIds.add(index);
    ) {
            }
import org.opensearch.cluster.node.DiscoveryNode;
            slot++;
                }
import java.util.concurrent.CopyOnWriteArrayList;
                @Override
    public static final String NOOP_PIPELINE_NAME = "_none";
        List<Integer> childSlots,
            onFailure.accept(slot, e);
        }
                final Settings indexSettings = indexMetadata.getSettings();
 *
        // the pipeline specific stat holder may not exist and that is fine:
                List<Tuple<Processor, OperationMetrics>> oldPerProcessMetrics = new ArrayList<>();
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                if (finalPipelineId != null && IngestService.NOOP_PIPELINE_NAME.equals(finalPipelineId) == false) {
            indexRequest.versionType(),
            indexRequest.setIfPrimaryTerm(((Number) metadataMap.get(IngestDocument.Metadata.IF_PRIMARY_TERM)).longValue());
                // wrapping processor that has its inner processor refer to itself.
                OpenSearchParseException parseException = new OpenSearchParseException(
        }
            // no cache we will try to resolve the ingest pipeline based on the index configuration
                final String finalPipelineId = indexRequest.getFinalPipeline();
        IngestMetadata currentIngestMetadata = currentState.metadata().custom(IngestMetadata.TYPE);
     */
                // do not execute the pipeline since it is a valid null
        IngestMetadata ingestMetadata = clusterState.getMetadata().custom(IngestMetadata.TYPE);
        return ingestPipeline.getProcessors().isEmpty() ? null : indexId;
        for (Map.Entry<String, IndexMetadata> entry : previousIndices.entrySet()) {
                        result.add(entry.getValue());
                    metric = conditionalProc.getMetric();
            processor = conditionalProc.getInnerProcessor();
        BiConsumer<Thread, Exception> onCompletion,
            handler.accept(null);
    public static List<PipelineConfiguration> getPipelines(ClusterState clusterState, String... ids) {
     *
 * under the License.
            indexRequest.setFinalPipeline(NOOP_PIPELINE_NAME);
                        exceptions.add(result);
    ) {
                        throw new RuntimeException(
        // (e.g. the pipeline may have been removed while we're ingesting a document
    private List<IndexRequest> getChildIndexRequests(DocWriteRequest<?> actionRequest) {
        if (indexMetadata == null && indexRequest.index() != null) {
        BiConsumer<Integer, Exception> onFailure,
            } else {
                                + "] of the index template: "
                } else {
                processorMetrics.add(new Tuple<>(processor, metric));
        List<IngestPlugin> ingestPlugins,
                for (int i = 0; i < results.size(); ++i) {
    private void completeExecution(
                            new IllegalStateException(pipelineType + " pipeline [" + pipelineId + "] can't change the target index")
        return result;
                    );
        // start to look for default or final pipelines via settings found in the index meta data
        final int completedRequestSize
            sb.append(tag);
                            break;
            final MappingMetadata mappingMetadata = indexMetadata.mapping();
    /**
        if (indexMetadata == null && originalRequest != null && originalRequest.index() != null) {
     * @param actionRequest the action request
 *
     * @return the underlying child index requests
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
                    } else if (result.getIngestDocument() == null) {
        }
     *
        List<OpenSearchParseException> exceptions = null;
                onFailure,
            final List<Settings> settingsList = new ArrayList<>();
                if (pipelineInfoIterator.hasNext()) {
            indexRequest.isPipelineResolved(true);
        try {
            ingestPipeline = createSystemIngestPipeline(indexId, pipelineConfig);
import org.opensearch.index.analysis.AnalysisRegistry;
        for (Map.Entry<String, Processor.Factory> entry : processorFactories.entrySet()) {
    /**
            );
            }
        if (toRemove.isEmpty() && Regex.isMatchAllPattern(request.getId()) == false) {
            }
    private Pipeline getPipelineFromHolder(final PipelineHolder holder, @NonNull final String pipelineId) {
                    + maxIngestProcessorCount
        indexRequest.routing((String) metadataMap.get(IngestDocument.Metadata.ROUTING));
            indexRequestsPerIndexAndPipelines.get(hashCode).add(indexRequestWrapper);
                            pipelineId,
            if (e != null) {
    }
    }
            List<String> indexAndPipelineIds = new ArrayList<>();
     */
                newPipelines.put(newConfiguration.getId(), new PipelineHolder(newConfiguration, pipeline));
     * 2. a request parameter of _bulk API
                        indexRequest,
        Map<DiscoveryNode, IngestInfo> ingestInfos,
            }
        runBulkRequestInBatch(numberOfActionRequests, actionRequests, onFailure, onCompletion, onDropped);
    public IngestInfo info() {
                for (int i = 0; i < indexRequests.size(); ++i) {
                indexPipeline = systemIngestPipelineCache.getSystemIngestPipeline(newPipelineId);
     * Gets the child index requests associated with an action request
        if (indexRequest.isPipelineResolved() == false) {
import org.opensearch.action.DocWriteRequest;
        Iterable<DocWriteRequest<?>> actionRequests,
            handler.accept(toIngestDocumentWrappers(slots, childSlots, indexRequests));
        Map<String, Object> pipelineConfig = XContentHelper.convertToMap(request.getSource(), false, request.getMediaType()).v2();
            // direct access to the original index request already.
    private void innerBatchExecute(
        IngestDocument ingestDocument = new IngestDocument(index, id, routing, version, versionType, sourceAsMap);
                    completeExecution(totalIndexRequestCounter, onCompletion, originalThread, indexRequests.size());
            ingestDocumentWrappers.add(toIngestDocumentWrapper(slots.get(i), childSlots.get(i), indexRequests.get(i)));
                    result.add(pipeline);
                        ),
import java.util.Iterator;
import org.opensearch.env.Environment;
        });
                exceptions.add(parseException);
        // only surface the top level non-failure processors, on-failure processor times will be included in the top level non-failure
    private final OperationMetrics totalMetrics = new OperationMetrics();
            }
            indicesService
import org.opensearch.script.ScriptService;
                }
                }
                    }
        for (int i = 0; i < slots.size(); ++i) {
            indexRequest.setPipeline(defaultPipeline != null ? defaultPipeline : NOOP_PIPELINE_NAME);
            }
                ),
                    if (IndexSettings.DEFAULT_PIPELINE.exists(settings)) {
     * This function should be invoked when the target index is changed by the default pipeline. In this way when we
    private static Map<String, Processor.Factory> processorFactories(List<IngestPlugin> ingestPlugins, Processor.Parameters parameters) {
        setMaxIngestProcessorCount(clusterService.getClusterSettings().get(MAX_NUMBER_OF_INGEST_PROCESSORS));
                // in a valid null case if this is the last pipeline we should complete the execution
                    throw new IllegalArgumentException("Ingest processor [" + entry.getKey() + "] is already registered");
            for (Map.Entry<DiscoveryNode, IngestInfo> entry : ingestInfos.entrySet()) {
            }
                );
        if (holder != null) {
        clusterService.submitStateUpdateTask(
                batch.stream().map(IndexRequestWrapper::getActionRequest).collect(Collectors.toList()),
        @NonNull final BiConsumer<Thread, Exception> onCompletion,
                onDropped,
import org.apache.lucene.util.UnicodeUtil;
                    e
        String id = indexRequest.id();
        // which pipelines to execute for each index request based on previously resolved pipelines.
                    "Error updating pipeline with id [" + newConfiguration.getId() + "]",
                if (entry.getValue().containsProcessor(type) == false && ConditionalProcessor.TYPE.equals(type) == false) {
            }
        int slot,
                .stream()
                @Override
            }
            Map<String, Processor.Factory> newProcessors = ingestPlugin.getSystemIngestProcessors(parameters);
            this.configuration = Objects.requireNonNull(configuration);
            String systemIngestPipelineId = null;
    }
 * license agreements. See the NOTICE file distributed with
        final AtomicInteger totalIndexRequestCounter = new AtomicInteger(indexRequestWrappers.size());
        String executorName
        indexRequest.id((String) metadataMap.get(IngestDocument.Metadata.ID));
        }
            final Pipeline pipeline = getPipeline(pipelineId, pipelineInfoType, actionRequests.get(0), indexRequests.get(0));
                Pipeline oldPipeline = previous.pipeline;
                            // If no more request with target index unchanged we should end here so that we don't
                boolean hasInvalidTargetIndexChange = false;
        List<IngestPlugin> ingestPlugins,
        @NonNull final IndexRequest indexRequest,
        }
        }
                }
        }
            if (pipeline == null) {
            if (Regex.simpleMatch(request.getId(), pipelineKey)) {
        if (newPipelines != null) {
                // templates to look for pipelines in either a matching V2 template (which takes
                }
                    indexRequest.index(),
                                indexRequest != null ? indexRequest.index() : null,
                handler.accept(null);
        return clusterService;
        if (state.blocks().hasGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK)) {
                }
                    }
                            slot,
        }
                }
                    // find the default pipeline if one is defined from an existing index setting
            indexRequest.versionType(VersionType.fromString((String) metadataMap.get(IngestDocument.Metadata.VERSION_TYPE)));
            pipelineConfig.put(INDEX_TEMPLATE_MAPPINGS, mappingsMap);
                    executePipelines(
     * may be returned
                );
            final IndexMetadata previousIndexMetadata = entry.getValue();
     * Returns the pipeline by the specified id
     */
        List<IndexRequestWrapper> indexRequestWrappers = new ArrayList<>();
             */
                if (pipelineInfoIterator.hasNext()) {
                        null
            indexRequestsPerIndexAndPipelines.putIfAbsent(hashCode, new ArrayList<>());
import java.util.stream.Collectors;
        IndexRequest indexRequest,
        this.threadPool = threadPool;
                // templates to look for pipelines in either a matching V2 template (which takes
            for (Map.Entry<String, Processor.Factory> entry : newProcessors.entrySet()) {
                            e
            if (indexAbstraction != null) {
                getProcessorMetrics(compoundProc, processorMetrics);
                    }
        true,
            }
        }
    }
                        finalPipeline = IndexSettings.FINAL_PIPELINE.get(settings);
                // set it as NOOP to avoid duplicated execution after we switch back to the write thread
        }
                pipelineConfig.put(INDEX_SETTINGS, settings);
                throw new RuntimeException(
        }
     * flow through the same pipeline together.
                resolveSystemIngestPipeline(actionRequest, indexRequest, state.metadata());
            this,
            }
                    throw new RuntimeException("Failed to parse the mappings [" + mapping + "] of the index template: " + templateName, e);
            // Determine pipelines to execute for all child index requests based on previously resolved pipelines
                } else {
        }
                }
        PipelineHolder(PipelineConfiguration configuration, Pipeline pipeline) {
    public static ClusterState innerPut(PutPipelineRequest request, ClusterState currentState) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
                onDropped,
    // Ideally this should be in IngestMetadata class, but we don't have the processor factories around there.
     */
        ActionListener<AcknowledgedResponse> listener
                    try {
        Map<String, PipelineConfiguration> pipelines = currentIngestMetadata.getPipelines();
                    exceptions = new ArrayList<>();
                }
                    } else {
        }
                        }
            sb.append(pipelineName);
        String pipelineId,
                    indexRequestWrappers.add(new IndexRequestWrapper(slot, childSlot, indexRequest, actionRequest, pipelinesInfoList));
                Pipeline pipeline = substitutePipeline(newConfiguration.getId(), e);
    ) {
                throw new IllegalStateException(errorMessage);
                    MAX_PIPELINE_ID_BYTES,
                        metadata,
            .addSettingsUpdateConsumer(SYSTEM_INGEST_PIPELINE_ENABLED, this::setIsSystemIngestPipelineEnabled);
            // pipeline for the request if the previously resolved one is invalidated. Since we group requests by
        String description = "this is a place holder pipeline, because pipeline with id [" + id + "] could not be loaded";
        final Settings settings
 * Licensed to Elasticsearch under one or more contributor
                systemIngestPipelineCache.invalidateCacheForIndex(
        if (metadataMap.get(IngestDocument.Metadata.IF_SEQ_NO) != null) {
    }
                newPipelines.remove(entry.getKey());
                () -> new ParameterizedMessage(
        } catch (OpenSearchParseException e) {
        List<IngestDocumentWrapper> allResults = Collections.synchronizedList(new ArrayList<>());
            final List<CompressedXContent> mappings;
        return innerGetPipelines(ingestMetadata, ids);
        );
import java.util.Objects;
            return currentState;
                try {
/*
            final Pipeline pipeline = getPipeline(pipelineId, pipelineType, actionRequest, indexRequest);
    private final Map<String, Processor.Factory> processorFactories;
        // we only set the pipeline in request when there is a processor
            } catch (Exception e) {
                documentLogBuilder.append(indexRequest.id());
                    throw new RuntimeException("System ingest processor [" + entry.getKey() + "] is already registered");
                if (i < indexRequests.size() - 1) {
                        dropped.add(result);
import org.opensearch.plugins.IngestPlugin;
            innerUpdatePipelines(newIngestMetadata);
        return new IngestDocument(
 */
import static org.opensearch.cluster.service.ClusterManagerTask.DELETE_PIPELINE;
            pipelineConfig.put(INDEX_TEMPLATE_SETTINGS, settingsList);
    public ClusterService getClusterService() {
 * @opensearch.internal
        }
            }
            }
                    pipelinesInfoList.add(new IngestPipelineInfo(pipelineId, IngestPipelineType.DEFAULT));
     * switch back to the write thread the transport bulk action can re-process it with the new target index.
            // slot/childSlot combination used to map ingest pipeline results back to their original index requests
        return processorFactories;
            throw new IllegalStateException(
                onCompletion,
                        succeeded.add(result);
                return;
        Map<String, PipelineConfiguration> pipelines;
        // before ingestion, which might also get modified during ingestion.
        }
                if (!exceptions.isEmpty()) {
    ) {
        if (counter.addAndGet(-completedRequestSize) == 0) {
                batch.stream().map(IndexRequestWrapper::getSlot).collect(Collectors.toList()),
        final List<DocWriteRequest<?>> actionRequests,
                    logger.debug(
        ThreadPool threadPool,
                }
    private final ClusterService clusterService;
    private static final int MAX_PIPELINE_ID_BYTES = 512;
    }
        Integer.MAX_VALUE,
            ingestDocumentWrappers.add(toIngestDocumentWrapper(slots.get(i), childSlots.get(i), indexRequests.get(i)));
import org.opensearch.threadpool.ThreadPool;
    private final ClusterManagerTaskThrottler.ThrottlingKey deletePipelineTaskKey;
                if (processorFactories.put(entry.getKey(), entry.getValue()) != null) {
            final Map<String, Object> pipelineConfig = new HashMap<>();
        if (processor instanceof PipelineProcessor pipelineProc) {
                }
            }
    private volatile int maxIngestProcessorCount;
            CompoundProcessor rootProcessor = pipeline.getCompoundProcessor();
                            indexRequest.id()
                if (pipeline != null) {
        for (IngestPlugin ingestPlugin : ingestPlugins) {
                }
    private static Map<String, Processor.Factory> systemProcessorFactories(
                        actionRequest,
                        indexRequest.index(),
                if (processorFactory.isSystemGenerated() == false) {
    ) {
            @Override
                    pipelineInfoIterator.forEachRemaining($ -> {});
                totalMetrics.afterN(size, ingestTimeInNanos);
        for (String key : toRemove) {
    static String getProcessorName(Processor processor) {
                // consistent id's per processor and/or semantic equals for each processor will be needed.
        this.systemIngestPipelineCache = systemIngestPipelineCache;
    public void executeBulkRequest(
    /**
import java.io.IOException;
            }
        String tag = e.getHeaderKeys().contains("processor_tag") ? e.getHeader("processor_tag").get(0) : null;
            try {
            this.pipeline = Objects.requireNonNull(pipeline);
        @NonNull final String templateName,
    }
                }
                indexRequest.isPipelineResolved(false);
                        }
     * A system pipeline is a special type of internal pipeline associated with an index based on the index mapping.
            pipelines = new HashMap<>(currentIngestMetadata.getPipelines());
        setIsSystemIngestPipelineEnabled(clusterService.getClusterSettings().get(SYSTEM_INGEST_PIPELINE_ENABLED));
        systemIngestPipelineCache.cachePipeline(indexId, pipeline, maxIngestProcessorCount);
    public static final String INGEST_ORIGIN = "ingest";
    }
        );
                                indexRequest != null ? indexRequest.id() : null
        long startTimeInNanos = System.nanoTime();
                    }
        return indexMetadata;
        Pipeline ingestPipeline = systemIngestPipelineCache.getSystemIngestPipeline(indexId);
                        actionRequestsTargetIndexUnchanged,
        final Map<Integer, List<IndexRequestWrapper>> indexRequestsPerIndexAndPipelines = new HashMap<>();
                    mappingsMap.add(MapperService.parseMapping(xContentRegistry, mapping.string()));
                PipelineConfiguration pipeline = ingestMetadata.getPipelines().get(id);
        IntConsumer itemDroppedHandler,
                            onCompletion.accept(originalThread, null);
        if (pipeline == null) {
    /**
                }
                }
                        onFailure,
        final IngestPipelineInfo pipelineInfo = pipelineInfoIterator.next();
                    systemIngestPipelineId = getSystemIngestPipelineForTemplateV1(templates, indexRequest);
    private static Pipeline substitutePipeline(String id, OpenSearchParseException e) {
    ) {
            IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(indexRequest.index());
                }
 * this file be licensed under the Apache-2.0 license or a
import java.util.HashSet;
                    if (pipelineInfoIterator.hasNext() == true) {
    /**
    }
        }
        }
        if (ids.length == 0) {
        }
                batch.get(0).getIngestPipelineInfoList().iterator(),
    ) {
            return;
                    return putPipelineTaskKey;
        if (pipelineIdLength > MAX_PIPELINE_ID_BYTES) {
                // need to set pipeline of the request as NOOP_PIPELINE_NAME so that when we switch back to the write thread
        ClusterState.Builder newState = ClusterState.builder(currentState);
import org.opensearch.transport.client.Client;
    private void runBulkRequestInBatch(
        // Iterate over pipeline configurations in ingest metadata and constructs a new pipeline if there is no pipeline
        // based on the total number of index request wrappers generated
        }
                public ClusterState execute(ClusterState currentState) {
            // we will rely on the target index of the actionRequests and indexRequests to resolve the system
        return Collections.unmodifiableMap(processorFactories);
        statsBuilder.addTotalMetrics(totalMetrics);
        this.isSystemIngestPipelineEnabled = isSystemIngestPipelineEnabled;
    ) {
                    e
            threadPool.getThreadContext(),
        // Here we cache it with index name + template as the suffix since currently we don't have the uuid.
        // validates the pipeline and processor configuration before submitting a cluster update task:
        final BiConsumer<Thread, Exception> onCompletion,
                        // Drain old it so it's not looped over. We will re-process the pipelines of the request with
            final List<Map<String, Object>> mappingsMap = new ArrayList<>();
                // precedence), or if a V2 template does not match, any V1 templates
                        // Since the requests with new target index will be processed in the next round we should
                itemDroppedHandler.accept(slot);
        final IntConsumer onDropped,
            }
    }
import java.util.Locale;
            logger.warn("failed to update ingest pipelines", e);
                Processor.Factory processorFactory = entry.getValue();
                getProcessorMetrics(oldPipeline.getCompoundProcessor(), oldPerProcessMetrics);
        if (tag != null && !tag.isEmpty()) {
        clusterService.getClusterSettings()
                            // we can not break in case a lower-order template has a default pipeline that we need to collect
                for (IngestDocumentWrapper ingestDocumentWrapper : succeeded) {
import org.opensearch.ResourceNotFoundException;
    private String getSystemIngestPipelineForTemplateV1(
        String type = e.getHeaderKeys().contains("processor_type") ? e.getHeader("processor_type").get(0) : "unknown";
        final DocWriteRequest<?> originalRequest,
        if (processors.size() > maxIngestProcessorCount) {
    }
        // Walk through slot by slot. For each slot, go through childslots (child index requests) and determine
        Long version = indexRequest.version();
            }
            } else if (result == null) {
                }
                // reset isPipelineResolved as false so that we can resolve it again
    static ClusterState innerDelete(DeletePipelineRequest request, ClusterState currentState) {
        indexRequest.setSystemIngestPipeline(null);
     * IndexRequests are grouped by unique (index + pipeline_ids) before batching.
        // we can get an empty pipeline from the cache
                }
            final List<Map<String, Object>> mappingsMap = new ArrayList<>();
    private final ClusterManagerTaskThrottler.ThrottlingKey putPipelineTaskKey;
        // conditionals are implemented as wrappers around the real processor, so get the real processor for the correct type for the name
    public Map<String, Processor.Factory> getProcessorFactories() {
    public void executeBulkRequestSync(
            indexRequest.setFinalPipeline(finalPipeline != null ? finalPipeline : NOOP_PIPELINE_NAME);
        } else {
        }
             * set from a request pipeline parameter versus having been set by the resolution. We need to be able to distinguish
        final Thread originalThread
                    totalMetrics.failedN(exceptions.size());
                        systemIngestPipelineId = getSystemIngestPipelineForTemplateV1(templates, indexRequest);
    }
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
        Iterable<DocWriteRequest<?>> actionRequests,
                    request.getId(),
        Map<String, PipelineHolder> existingPipelines = this.pipelines;
        if (newIngestMetadata == null) {
            statsBuilder.addPipelineMetrics(id, pipeline.getMetrics());
                }
    private final ScriptService scriptService;
                            }
                        String type = compositeMetric.v1().getType();
        Map<String, Object> sourceAsMap = indexRequest.sourceAsMap();
            indexRequest.setPipeline(NOOP_PIPELINE_NAME);
        List<IngestDocumentWrapper> ingestDocumentWrappers = new ArrayList<>();
                Processor processor = t.v1();
    }
        Pipeline pipeline = Pipeline.create(request.getId(), pipelineConfig, processorFactories, scriptService);
        String routing = indexRequest.routing();
        int size = indexRequests.size();
        final List<Integer> childSlot,
        IndicesService indicesService,
        return ingestPipeline.getProcessors().isEmpty() ? null : indexId;
        final List<IndexRequest> indexRequests,
            if (indexMetadata != null) {
        // Otherwise, since we are only resolving system ingest pipelines, we resolve them as NOOP so their execution will be skipped.
    }
                }
                // and invoke doInternalExecute of the TransportBulkAction we will not execute the pipeline again.
            return updateRequest.getChildIndexRequests();
                    )
    private record SlotKey(int slot, int childSlot) {
        return "[" + indexName + "/template]";
import java.util.Map;
    // processor factories rely on other node services. Custom metadata is statically registered when classes
    }
                            // try to execute the next pipeline with an empty list of the requests.
    private Pipeline getPipeline(
import static org.opensearch.plugins.IngestPlugin.SystemIngestPipelineConfigKeys.INDEX_SETTINGS;
        }
        }
     */
    static IngestDocument toIngestDocument(IndexRequest indexRequest) {
                        onDropped,
                }
                    if (this.isSystemIngestPipelineEnabled) {
        int pipelineIdLength = UnicodeUtil.calcUTF16toUTF8Length(request.getId(), 0, request.getId().length());
                String newIndex = indexRequest.indices()[0];
        if (indexRequestWrappers.isEmpty()) {
import org.opensearch.cluster.metadata.IndexAbstraction;
            return holder.pipeline;
            if (clazz.isAssignableFrom(processor.getClass())) {
        totalMetrics.before();
import java.util.ArrayList;
            // the target index so we can simply use the first request.
    }
                // indexRequests are grouped for the same index and same pipelines, but we can conditionally change
    }
        return Collections.unmodifiableMap(processorFactories);
            public IngestDocument execute(IngestDocument ingestDocument) {
                }
    private static List<IngestDocumentWrapper> toIngestDocumentWrappers(
                    if (hasInvalidTargetIndexChange == true) {
     * before these components get used by the ingest processor factory.
import static org.opensearch.plugins.IngestPlugin.SystemIngestPipelineConfigKeys.INDEX_TEMPLATE_MAPPINGS;
        // we can get an empty pipeline from the cache
        Pipeline ingestPipeline = systemIngestPipelineCache.getSystemIngestPipeline(indexId);
    ) {
                                pipelineId,
                }
        }
    public static void updateIndexRequestWithIngestDocument(IndexRequest indexRequest, IngestDocument ingestDocument) {
     */
                    executePipelinesInBatchRequests(
        return systemIngestProcessorFactories;
/*
 * GitHub history for details.
            List<IndexRequest> childIndexRequests = getChildIndexRequests(actionRequest);
                        }
                indexRequests.get(0),
                    return innerPut(request, currentState);
        }
                // Create index request wrappers for all index requests with pipelines that will be executed
                    Iterator<Tuple<Processor, OperationMetrics>> oldMetricsIterator = oldPerProcessMetrics.iterator();
            String finalPipeline = null;
                systemIngestPipelineId = getSystemIngestPipelineForExistingIndex(indexMetadata, indexRequest);
        }
