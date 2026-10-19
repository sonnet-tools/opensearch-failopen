            ingestDocumentWrappers.add(toIngestDocumentWrapper(slots.get(i), childSlots.get(i), indexRequests.get(i)));
    }
        List<Integer> slots,
                    Locale.ROOT,
            assert previousIndexMetadata != null : "IndexMetadata in the previous state metadata indices should not be null.";  
 * not use this file except in compliance with the License.
        }
                    );  
        "cluster.ingest.system_pipeline_enabled",
        } else {
                totalIndexRequestCounter,
            indicesService
        List<Tuple<Processor, OperationMetrics>> processorMetrics
        }
                    if (hasInvalidTargetIndexChange == true) {
    public IngestService(  
 * ownership. Elasticsearch licenses this file to you under  
                if (pipelineInfoIterator.hasNext() == false) {
        }
            throw new IllegalArgumentException("pipeline with id [" + pipelineId + "] does not exist");
import org.opensearch.cluster.AckedClusterStateUpdateTask;  
        String tag = e.getHeaderKeys().contains("processor_tag") ? e.getHeader("processor_tag").get(0) : null;
                Pipeline pipeline = substitutePipeline(newConfiguration.getId(), e);
     * @param childSlot the child slot in the action request  
                    "Error updating pipeline with id [" + newConfiguration.getId() + "]",
            executePipelines(  
            Map<String, Processor.Factory> newProcessors = ingestPlugin.getSystemIngestProcessors(parameters);
        sb.append(processor.getType());
        indexRequest.id((String) metadataMap.get(IngestDocument.Metadata.ID));
            indexRequestsPerIndexAndPipelines.get(hashCode).add(indexRequestWrapper);  
        if (counter.addAndGet(-completedRequestSize) == 0) {  
import org.opensearch.env.Environment;
                    pipelinesInfoList.add(new IngestPipelineInfo(pipelineId, IngestPipelineType.DEFAULT));
                newPipelines.put(newConfiguration.getId(), new PipelineHolder(newConfiguration, newPipeline));
                            indexRequest.id()
                processors.add(clazz.cast(processor));
        }
 * Holder class for several ingest related services.
        // Here we cache it with index name + template as the suffix since currently we don't have the uuid.  
            pipelines = new HashMap<>();
    ) {
                batch.stream().map(IndexRequestWrapper::getSlot).collect(Collectors.toList()),  
        }  
                batch.stream().map(IndexRequestWrapper::getIndexRequest).collect(Collectors.toList()),  
                onFailure.accept(slots.get(i), e);  
            Processor processor = processorWithMetric.v1();
        Pipeline pipeline = Pipeline.create(request.getId(), pipelineConfig, processorFactories, scriptService);  
                }
 * KIND, either express or implied.  See the License for the
                    List<IndexTemplateMetadata> templates = MetadataIndexTemplateService.findV1Templates(
            // slot/childSlot combination used to map ingest pipeline results back to their original index requests  
                            onFailure.accept(
                    exceptions = new ArrayList<>();
        if (holder != null) {
                // the index does not exist yet (and this is a valid request), so match index  
        SystemIngestPipelineCache systemIngestPipelineCache
                indexMetadata = indexAbstraction.getWriteIndex();
        if (processor instanceof PipelineProcessor pipelineProc) {  
        return systemIngestProcessorFactories;
        return new IngestDocument(  
        String description = "this is a place holder pipeline, because pipeline with id [" + id + "] could not be loaded";  
                    systemIngestPipelineId = getSystemIngestPipelineForTemplateV2(v2Template, indexRequest, settings);  
                }  
                        if (oldMetricsIterator.hasNext()) {  
    private static final Logger logger = LogManager.getLogger(IngestService.class);
                onCompletion,
                actionRequests.get(0),
            handler.accept(toIngestDocumentWrappers(slots, childSlots, indexRequests));
    ) {
        return NOOP_PIPELINE_NAME.equals(indexRequest.getPipeline()) == false
        Map<String, Object> sourceAsMap = indexRequest.sourceAsMap();
        clusterService.getClusterSettings()
            }  
        final Map<Integer, List<IndexRequestWrapper>> indexRequestsPerIndexAndPipelines = new HashMap<>();
            indexRequest.isPipelineResolved(true);  
                            OperationMetrics oldMetric = oldCompositeMetric.v2();  
import org.opensearch.cluster.metadata.MappingMetadata;
        return newState.build();  
                // Prefer the conditional's metric since it only includes metrics when the conditional evaluated to true.
            threadPool::relativeTimeInMillis,
        Pipeline pipeline,
     * Stores the specified pipeline definition in the request.
                }  
                onCompletion.accept(null, e);
                // in a valid null case if this is the last pipeline we should complete the execution  
        return processors;  
        invalidateSystemIngestPipeline(event);  
        } else {
            // Update the pipelines:
                if (processor instanceof ConditionalProcessor conditionalProc) {
        }  
                    // find the default pipeline if one is defined from an existing index setting
     */
        ClusterState.Builder newState = ClusterState.builder(currentState);  
    private Pipeline getPipeline(
        // based on the total number of index request wrappers generated  
                boolean hasInvalidTargetIndexChange = false;
                }
            Metadata.builder(currentState.getMetadata()).putCustom(IngestMetadata.TYPE, new IngestMetadata(pipelinesCopy)).build()
                        OperationMetrics metric = compositeMetric.v2();
        final Map<String, IndexMetadata> previousIndices = event.previousState().metadata().indices();
            }
        indexRequest.version(((Number) metadataMap.get(IngestDocument.Metadata.VERSION)).longValue());
            client,
    @Override
        IngestMetadata currentIngestMetadata = currentState.metadata().custom(IngestMetadata.TYPE);  
        if (indexRequests.size() == 1) {  
        int numberOfActionRequests,
        PipelineHolder holder = pipelines.get(id);  
                if (e != null) {
    @Override
                        onFailure.accept(results.get(i).getSlot(), results.get(i).getException());
                    exceptions = new ArrayList<>();
import java.util.Map;  
                // do not execute the pipeline since it is a valid null
        Set<String> toRemove = new HashSet<>();
                if (pipelineInfoIterator.hasNext()) {  
                                i,
        });
                if (IndexSettings.DEFAULT_PIPELINE.exists(indexSettings)) {  
                }  
        // Used to track progress of pipeline executions on index requests across parallel threads
                        );
                    exceptions.add(ConfigurationUtils.newConfigurationException(processor.getType(), processor.getTag(), null, message));
     * Resolves only the system ingest pipeline for the index request.
            // Determine pipelines to execute for all child index requests based on previously resolved pipelines
    }  
        for (String id : ids) {
                if (processorFactories.put(entry.getKey(), entry.getValue()) != null) {  
        statsBuilder.addTotalMetrics(totalMetrics);  
            slotIndexRequestMap.put(new SlotKey(slots.get(i), childSlots.get(i)), indexRequests.get(i));  
            final IndexMetadata currentIndexMetadata = currentIndices.get(indexName);
            throw new IllegalArgumentException(  
    private void invalidateSystemIngestPipeline(@NonNull final ClusterChangedEvent event) {  
                newPipelines.remove(entry.getKey());
        // If we don't need to execute any pipelines, we exit pipeline execution early
                if (systemPipelineId != null && IngestService.NOOP_PIPELINE_NAME.equals(systemPipelineId) == false) {
                return;  
    private static List<Tuple<Processor, OperationMetrics>> getProcessorMetrics(
                ),
        deletePipelineTaskKey = clusterService.registerClusterManagerTask(DELETE_PIPELINE, true);  
        assert counter.get() >= 0;  
        final AtomicInteger totalIndexRequestCounter,
                    systemIngestPipelineId = getSystemIngestPipelineForExistingIndex(indexMetadata, indexRequest);
        }
        }
        Pipeline ingestPipeline = systemIngestPipelineCache.getSystemIngestPipeline(indexId);
                if (pipelineId != null && IngestService.NOOP_PIPELINE_NAME.equals(pipelineId) == false) {
import org.opensearch.index.IndexSettings;  
                    return new AcknowledgedResponse(acknowledged);
    public static final String INGEST_ORIGIN = "ingest";
            return;
                if (!dropped.isEmpty()) {  
                    + maxIngestProcessorCount
                indexRequests.get(0),  
            /*
                () -> new ParameterizedMessage(  
                String newIndex = indexRequest.indices()[0];  
    public static final Setting<Boolean> SYSTEM_INGEST_PIPELINE_ENABLED = Setting.boolSetting(
                continue;
import org.opensearch.cluster.metadata.IndexMetadata;
            final MappingMetadata mappingMetadata = indexMetadata.mapping();  
        if (indexRequest.isPipelineResolved() == false && this.isSystemIngestPipelineEnabled) {
                    documentLogBuilder.append(", ");
            new AckedClusterStateUpdateTask<AcknowledgedResponse>(request, listener) {  
            }
            return indexPipeline;  
     *
        final Metadata metadata
        final String indexId = createIndexIdWithTemplateSuffix(indexRequest.index());  
                    completeExecution(totalIndexRequestCounter, onCompletion, originalThread, results.size());
        ActionListener<AcknowledgedResponse> listener  
                }
                    + processors.size()
                }
    ) {
    }
     * This is useful for components that are used by ingest processors, so that they have the opportunity to update
     * @param slot the slot in the original bulk request
    private String getSystemIngestPipelineForTemplateV2(
    }  
            }  
            final IngestPipelineType pipelineType = pipelineInfo.getType();  
     * 2. a request parameter of _bulk API
        Integer.MAX_VALUE,  
                originalThread  
                final String newPipelineId = indexRequest.getSystemIngestPipeline();  
                continue;
                    if (this.isSystemIngestPipelineEnabled) {
        StringBuilder sb = new StringBuilder(5);  
        }  
    }  
                itemDroppedHandler.accept(slot);
    private void runBulkRequestInBatch(  
            if (indexMetadata != null) {  
            this.pipeline = Objects.requireNonNull(pipeline);
                }  
    }  
             * We have to track whether the pipeline for this request has already been resolved. It can happen that the  
import org.apache.logging.log4j.message.ParameterizedMessage;  
                    if (IndexSettings.FINAL_PIPELINE.exists(settings)) {
        return sb.toString();
                    // Drain old it so it's not looped over. We will re-process the pipelines of the request with
    }  
                    }
                }  
    // Ideally this should be in IngestMetadata class, but we don't have the processor factories around there.
    public Map<String, Processor.Factory> getProcessorFactories() {
                    }
            innerUpdatePipelines(newIngestMetadata);  
     * In this function we will reset the pipeline for the index request to make it like the pipeline not resolved.
                @Override
        return NOOP_PIPELINE_NAME.equals(indexRequest.getSystemIngestPipeline()) == false;
        for (Map.Entry<Integer, List<IndexRequestWrapper>> indexRequestsPerKey : indexRequestsPerIndexAndPipelines.entrySet()) {  
        IngestDocument ingestDocument = new IngestDocument(index, id, routing, version, versionType, sourceAsMap);
                            // If no more request with target index unchanged we should end here so that we don't
                        totalMetrics.failed();
                batch.stream().map(IndexRequestWrapper::getChildSlot).collect(Collectors.toList()),
                indexPipeline = systemIngestPipelineCache.getSystemIngestPipeline(newPipelineId);  
            processorMetrics.forEach(t -> {
            List<String> pipelineInfo = indexRequestWrapper.getIngestPipelineInfoList()
                            return;  
            indexRequest.versionType(VersionType.fromString((String) metadataMap.get(IngestDocument.Metadata.VERSION_TYPE)));  
import org.opensearch.ExceptionsHelper;
        if (state.blocks().hasGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK)) {
                }  
                        + e.getMessage(),
        newState.metadata(  
             * pipeline for this request has already been derived yet we execute this loop again. That occurs if the bulk request
    // know how to serialize themselves.
                            defaultPipeline = IndexSettings.DEFAULT_PIPELINE.get(settings);  
     * get invoked.  
import static org.opensearch.plugins.IngestPlugin.SystemIngestPipelineConfigKeys.INDEX_MAPPINGS;
    }
                }
    }
            IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(originalRequest.index());  
        if (processors.size() > maxIngestProcessorCount) {
        final BiConsumer<Thread, Exception> onCompletion,
        return pipelines;
    public <P extends Processor> List<P> getProcessorsInPipeline(String pipelineId, Class<P> clazz) {
            return;
                    }
                if (newPipelines == null) {
    ) {
        String tag = processor.getTag();
                        // Drain old it so it's not looped over. We will re-process the pipelines of the request with
                    } else {
    }
                indexRequest.isPipelineResolved(false);
        List<IndexRequest> indexRequests,
                    if (IndexSettings.DEFAULT_PIPELINE.exists(settings)) {
    /**
            if (counter.addAndGet(-results.size()) == 0) {  
        }  
        }
                    final IndexRequest indexRequest = indexRequests.get(i);
            this,
                        indexRequestsTargetIndexUnchanged,
        final String indexId = createIndexIdWithTemplateSuffix(indexRequest.index());
        List<Integer> slots,  
                    return innerDelete(request, currentState);  
    private final ScriptService scriptService;
                    + "] which exceeds the maximum allowed configuration of ["  
    ) {
                if (exceptions == null) {
        if (tag != null && !tag.isEmpty()) {  
    public ClusterService getClusterService() {
        return innerGetPipelines(ingestMetadata, ids);
        // We need to cache it so that later during execution we can find it by indexId to reuse it.
                final Settings indexSettings = indexMetadata.getSettings();
        );
                OpenSearchParseException parseException = new OpenSearchParseException(  
        Pipeline ingestPipeline = systemIngestPipelineCache.getSystemIngestPipeline(indexId);  
        if (indexMetadata == null && originalRequest != null && originalRequest.index() != null) {
        IngestMetadata currentIngestMetadata = currentState.metadata().custom(IngestMetadata.TYPE);  
        String errorMessage = "pipeline with id [" + id + "] could not be loaded, caused by [" + e.getDetailedMessage() + "]";  
    }
                e
import org.opensearch.core.service.ReportingService;
                }  
                    executePipelines(  
        int numberOfActionRequests,  
                } else {
import java.util.concurrent.atomic.AtomicInteger;
        if (actionRequest instanceof UpdateRequest updateRequest) {  
            List<String> indexAndPipelineIds = new ArrayList<>();
            new AckedClusterStateUpdateTask<AcknowledgedResponse>(request, listener) {  
        int batchSize = numberOfActionRequests;  
                throw new RuntimeException(  
            for (int i = 0; i < indexRequestsPerKey.getValue().size(); i += Math.min(indexRequestsPerKey.getValue().size(), batchSize)) {
        if (toRemove.isEmpty() && Regex.isMatchAllPattern(request.getId()) == false) {
    public IngestStats stats() {
                    if (pipelineInfoIterator.hasNext() == true) {
        newState.metadata(
            } else if (indexRequest.index() != null) {
        // (e.g. the pipeline may have been removed while we're ingesting a document  
        Map<String, Processor.Factory> processorFactories = getProcessorFactories();
                originalThread  
                final List<DocWriteRequest<?>> actionRequestsTargetIndexUnchanged = new ArrayList<>();
            }
    private String createIndexIdWithTemplateSuffix(@NonNull final String indexName) {  
    protected SystemIngestPipelineCache getSystemIngestPipelineCache() {
                    pipelineInfoIterator.forEachRemaining($ -> {});  
        return clusterService;
                        finalPipeline = IndexSettings.FINAL_PIPELINE.get(settings);
                    createIndexIdWithTemplateSuffix(previousIndexMetadata.getIndex().getName())
                                "failed to execute pipeline [{}] for document [{}/{}]",  
            assert counter.get() >= 0;  
        final Thread originalThread = Thread.currentThread();
        }
import org.opensearch.core.action.ActionListener;
        final int slot,
        }
        List<List<IndexRequestWrapper>> batchedIndexRequests = new ArrayList<>();
                    totalMetrics.failedN(exceptions.size());
    private void executePipelines(  
            return Collections.emptyList();
                }
     * @param processorMetrics The list of {@link Processor} {@link OperationMetrics} tuples.
            ingestPipeline = createSystemIngestPipeline(indexId, pipelineConfig);  
        "cluster.ingest.max_number_processors",
                OperationMetrics processorMetric = t.v2();  
        }  
                        SlotKey slotKey = new SlotKey(results.get(i).getSlot(), results.get(i).getChildSlot());
        1,
    private volatile int maxIngestProcessorCount;
import org.opensearch.common.compress.CompressedXContent;
    Map<String, PipelineHolder> pipelines() {  
        Pipeline ingestPipeline = systemIngestPipelineCache.getSystemIngestPipeline(indexId);  
    }  
        for (Map.Entry<String, Processor.Factory> entry : processorFactories.entrySet()) {  
                        if (totalIndexRequestCounter.addAndGet(-(indexRequests.size() - indexRequestsTargetIndexUnchanged.size())) == 0) {
            // IndexRequests are grouped by their index + pipeline ids + pipeline type
                    );
            throw new ResourceNotFoundException("pipeline [{}] is missing", request.getId());  
     */
        try {
        final IngestPipelineInfo pipelineInfo = pipelineInfoIterator.next();
        runBulkRequestInBatch(numberOfActionRequests, actionRequests, onFailure, onCompletion, onDropped);  
    private String getSystemIngestPipelineForTemplateV1(
     * wrappers to the actual processor, always prefer the actual processor's metric over the conditional processor's metric.  
            throw new IllegalArgumentException("pipeline with id [" + pipelineId + "] does not exist");
        return indexMetadata;
                } else {
                IndexRequest indexRequest = childIndexRequests.get(childSlot);
                        indexRequestsTargetIndexUnchanged.add(indexRequest);  
    }
                        totalMetrics.failed();
        List<IndexRequestWrapper> indexRequestWrappers = new ArrayList<>();
import org.opensearch.index.mapper.MapperService;  
                        }
import java.util.List;
        return newState.build();
                            // try to execute the next pipeline with an empty list of the requests.
        // we can get an empty pipeline from the cache  
                        resetPipelineAfterIndexChange(indexRequest);
    /**
                        dropped.add(result);
import org.apache.logging.log4j.LogManager;
        if (indexRequest.isPipelineResolved() == false) {
                        indexRequestsPerKey.getValue().subList(i, i + Math.min(batchSize, indexRequestsPerKey.getValue().size() - i))
        List<ProcessorInfo> processorInfoList = new ArrayList<>(processorFactories.size());
    static IngestDocument toIngestDocument(IndexRequest indexRequest) {
    }
        if (pipeline.getProcessors().isEmpty()) {  
        }  
            ingestDocumentWrappers.add(toIngestDocumentWrapper(slots.get(i), childSlots.get(i), indexRequests.get(i)));  
import org.opensearch.common.settings.Settings;  
        List<Integer> childSlots,
                resolveSystemIngestPipeline(actionRequest, indexRequest, state.metadata());
                // handle index change case
     * These are defined by system ingest processors implemented by plugins.
                    // the new target index in TransportBulkAction.
        );
            List<IndexRequest> childIndexRequests = getChildIndexRequests(actionRequest);
        return holder.pipeline;
import java.util.function.Consumer;  
                    indexRequest.index(),
        final Settings settings
                            slot,  
        // Task is onboarded for throttling, it will get retried from associated TransportClusterManagerNodeAction.
                for (int i = 0; i < results.size(); ++i) {  
            return getPipelineFromHolder(holder, pipelineId);
        List<IndexRequest> indexRequests
            }
            }
                .toList();
    }
            final Map<String, Object> pipelineConfig = new HashMap<>();
                            indexRequest.index(),
            int hashCode = indexAndPipelineIds.hashCode();
     * Returns the pipeline by the specified id  
                }
        }  
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.cluster.service.ClusterManagerTask.DELETE_PIPELINE;  
            indexRequest.index(),
                }  
        int slot,
            onCompletion.accept(originalThread, null);
        }
     * without dispatching to a thread pool. This is intended for use by pull-based ingestion
        }  
import org.apache.lucene.util.UnicodeUtil;
                }  
                    completeExecution(counter, onCompletion, originalThread, 1);  
            this.configuration = Objects.requireNonNull(configuration);
            }  
                    if (results.get(i).getException() != null) {
        }
            logger.debug(
            );  
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
        IndexRequest indexRequest,  
                // set it as NOOP to avoid duplicated execution after we switch back to the write thread
    private final ThreadPool threadPool;
                        throw new RuntimeException(
                        IndexRequest indexRequest = slotIndexRequestMap.get(slotKey);  
            for (Map.Entry<String, Processor.Factory> entry : newProcessors.entrySet()) {
                            pipelineId,  
        final Iterator<IngestPipelineInfo> pipelineInfoIterator,  
        return systemIngestPipelineCache;
import org.opensearch.plugins.IngestPlugin;
    }
        }  
     */  
    }
 * SPDX-License-Identifier: Apache-2.0
        if (ingestPipeline == null) {
                }
        for (Map.Entry<String, IndexMetadata> entry : previousIndices.entrySet()) {  
        Setting.Property.Dynamic
                    return putPipelineTaskKey;
        return statsBuilder.build();
        IndexMetadata indexMetadata = null;
            final Pipeline pipeline = getPipeline(pipelineId, pipelineInfoType, actionRequests.get(0), indexRequests.get(0));  
import org.opensearch.indices.IndicesService;
                            // we can not break in case a lower-order template has a final pipeline that we need to collect
                newPipelines.put(newConfiguration.getId(), new PipelineHolder(newConfiguration, pipeline));  
        // we only set the pipeline in request when there is a processor
        validateProcessorCountForIngestPipeline(pipeline);
        // if so delete the pipeline from new Pipelines map:
        Client client,
        Processor failureProcessor = new AbstractProcessor(tag, "this is a placeholder processor") {
                    e
import org.opensearch.common.regex.Regex;
    ) {  
                documentLogBuilder.append(indexRequest.id());
    }  
    /**
                if (hasTargetIndexChanged == true) {  
        Consumer<Exception> handler  
            ingestPipeline = createSystemIngestPipeline(indexId, pipelineConfig);
        String pipelineId,  
        return ingestPipeline.getProcessors().isEmpty() ? null : indexId;
                        onCompletion,
        }  
        String executorName
        ScriptService scriptService,
        for (String key : toRemove) {
            if (indexAbstraction != null) {  
            }  
            threadPool.getThreadContext(),
     * could come from three places:  
import org.apache.logging.log4j.Logger;
            sb.append(":");
     * @param pipelineId the pipeline to inspect
        }
        systemIngestPipelineCache.cachePipeline(indexId, pipeline, maxIngestProcessorCount);  
        int numberOfActionRequests,
        return new IngestDocumentWrapper(slot, childSlot, toIngestDocument(indexRequest), null);
                if (v2Template != null) {
        }
        Map<String, PipelineHolder> newPipelines = null;  
    }
                // templates to look for pipelines in either a matching V2 template (which takes
 *
        Map<String, PipelineConfiguration> pipelines;
                newPipelines.put(newConfiguration.getId(), new PipelineHolder(newConfiguration, pipeline));
        }
    public void addIngestClusterStateListener(Consumer<ClusterState> listener) {
            allResults.addAll(results);
                    if (IngestPipelineType.FINAL.equals(pipelineType) || IngestPipelineType.SYSTEM_FINAL.equals(pipelineType)) {  
    /**
    private final ClusterManagerTaskThrottler.ThrottlingKey putPipelineTaskKey;
        // it's fine to set all metadata fields all the time, as ingest document holds their starting values
            if (childIndexRequest != null) {
        @NonNull final AtomicInteger counter,
    private void completeExecution(  
        }  
                // reset isPipelineResolved as false so that we can resolve it again  
                    request.getId(),
                            new IllegalStateException(pipelineType + " pipeline [" + pipelineId + "] can't change the target index")
            // Rethrow errors that may have occurred during creating new pipeline instances:
                boolean hasTargetIndexChanged = false;
            if (results.isEmpty()) return;
    private static Pipeline substitutePipeline(String id, OpenSearchParseException e) {  
                        // target index unchanged.
    static List<List<IndexRequestWrapper>> prepareBatches(int batchSize, List<IndexRequestWrapper> indexRequestWrappers) {
                }  
     * Recursive method to obtain all of the non-failure processors for given compoundProcessor. Since conditionals are implemented as
public class IngestService implements ClusterStateApplier, ReportingService<IngestInfo> {  
        for (int i = 0; i < slots.size(); ++i) {  
                    }  
            final List<CompressedXContent> mappings;
        this.xContentRegistry = xContentRegistry;
    /**
     * An IndexRequest could be preprocessed by at most three pipelines: default_pipeline, final_pipeline, and system_pipeline.
    private final List<Consumer<ClusterState>> ingestClusterStateListeners = new CopyOnWriteArrayList<>();  
                }
 *
        PutPipelineRequest request,
            public void onFailure(Exception e) {  
            indexMetadata = metadata.indices().get(originalRequest.index());
        Map<String, Processor.Factory> processorFactories = new HashMap<>();
    }
        final List<Integer> childSlot,
     * A final_pipeline is configured on index level. The default_pipeline for a IndexRequest in a _bulk API
     * where dedicated processor threads can safely block. Do not invoke from a TransportAction
        putPipelineTaskKey = clusterService.registerClusterManagerTask(PUT_PIPELINE, true);
            handler.accept(null);  
        BiConsumer<Integer, Exception> onFailure,
                        );
        return batchedIndexRequests;  
        IngestPipelineType pipelineType,
                        () -> new ParameterizedMessage(
                        systemIngestPipelineId = getSystemIngestPipelineForTemplateV2(v2Template, indexRequest, settings);  
                slot++;
        validatePipeline(ingestInfos, request);  
 * specific language governing permissions and limitations
                handler.accept(e);
                        actionRequestsTargetIndexUnchanged.add(actionRequests.get(i));
 * software distributed under the License is distributed on an
                            finalPipeline = IndexSettings.FINAL_PIPELINE.get(settings);
     * This function should be invoked when the target index is changed by the default pipeline. In this way when we  
                @Override
                        if (IngestPipelineType.FINAL.equals(pipelineInfoType) || IngestPipelineType.SYSTEM_FINAL.equals(pipelineInfoType)) {
            if (settings != null) {  
            }
                onCompletion,
                            if (type.equals(oldType)) {
                    if (result.getException() != null) {
        return new Pipeline(id, description, null, new CompoundProcessor(failureProcessor));
                String.format(
import org.opensearch.cluster.metadata.Metadata;
     * @param metadata  
    }
     */
                getProcessorMetrics(compoundProc, processorMetrics);
                        + ". Root cause: "  
                    processors.add(clazz.cast(wrappingProcessor.getInnerProcessor()));
     */  
                "Should not executePipelinesInBatchRequests when the pipeline iterator does not have next pipeline."
                    }
        } else if (toRemove.isEmpty()) {
                if (clazz.isAssignableFrom(wrappingProcessor.getInnerProcessor().getClass())) {  
 */
                );  
            StringBuilder documentLogBuilder = new StringBuilder();  
            } else if (result == null) {  
                    continue;
                runBulkRequestInBatch(numberOfActionRequests, actionRequests, onFailure, onCompletion, onDropped);  
                    throw new RuntimeException("System ingest processor [" + entry.getKey() + "] is already registered");  
                        // Since the requests with new target index will be processed in the next round we should
        setMaxIngestProcessorCount(clusterService.getClusterSettings().get(MAX_NUMBER_OF_INGEST_PROCESSORS));
     * or request thread — use {@link #executeBulkRequest} instead.  
                indexRequest.setSystemIngestPipeline(NOOP_PIPELINE_NAME);
    public void validateProcessorCountForIngestPipeline(Pipeline pipeline) {
    private static List<IngestDocumentWrapper> toIngestDocumentWrappers(
        final Pipeline pipeline = Pipeline.createSystemIngestPipeline(indexId, systemIngestProcessorFactories, pipelineConfig);
    }
            );  
        // Here we cache it with index name + template as the suffix since currently we don't have the uuid.
    public static ClusterState innerPut(PutPipelineRequest request, ClusterState currentState) {
        IntConsumer itemDroppedHandler,
        threadPool.executor(executorName).execute(new AbstractRunnable() {  
import static org.opensearch.plugins.IngestPlugin.SystemIngestPipelineConfigKeys.INDEX_SETTINGS;  
                    newPipelines = new HashMap<>(existingPipelines);  
                totalMetrics.failed();
    private Pipeline getPipelineFromHolder(final PipelineHolder holder, @NonNull final String pipelineId) {  
            indexRequest.setIfSeqNo(((Number) metadataMap.get(IngestDocument.Metadata.IF_SEQ_NO)).longValue());  
import org.opensearch.action.update.UpdateRequest;
        // return whether this index request has a pipeline  
    public boolean resolveSystemIngestPipeline(
    }
            }  
                    indexRequest.id()  
        List<IngestDocumentWrapper> ingestDocumentWrappers = new ArrayList<>();
        List<Integer> childSlots,
                mappings = MetadataIndexTemplateService.collectMappings(state, templateName, indexRequest.index());
                        result.add(entry.getValue());
                @Override
        }  
        List<Integer> childSlots,  
                    + "] processors."
        List<IngestDocumentWrapper> allResults = Collections.synchronizedList(new ArrayList<>());
                        slots,
        this.threadPool = threadPool;  
    /**
        totalMetrics.beforeN(size);  
        final BiConsumer<Integer, Exception> onFailure,  
    // Returning PipelineConfiguration instead of Pipeline, because Pipeline and Processor interface don't
        IntConsumer onDropped
            final List<Settings> settingsList = new ArrayList<>();
            throw new IllegalStateException(  
            });
    ) {
    private void innerBatchExecute(
import org.opensearch.common.xcontent.XContentHelper;  
    public static List<PipelineConfiguration> getPipelines(ClusterState clusterState, String... ids) {  
                    pipelinesInfoList.add(new IngestPipelineInfo(systemPipelineId, IngestPipelineType.SYSTEM_FINAL));
            }  
        }  
        BiConsumer<Thread, Exception> onCompletion,
                // do not execute the pipeline since it is a valid null
                        metadata,  
    /**
    /**
                        onDropped,
            indexRequest.versionType(),
    public boolean resolvePipelines(final DocWriteRequest<?> originalRequest, final IndexRequest indexRequest, final Metadata metadata) {  
        final IndexRequest indexRequest,  
            indexRequest.setSystemIngestPipeline(systemIngestPipelineId != null ? systemIngestPipelineId : NOOP_PIPELINE_NAME);
        }
            // no cache we will try to resolve the ingest pipeline based on the index configuration
                        totalIndexRequestCounter,  
        BiConsumer<Thread, Exception> onCompletion,  
        for (Processor processor : pipeline.flattenAllProcessors()) {
                            resetPipelineAfterIndexChange(indexRequest);  
        NamedXContentRegistry xContentRegistry,  
    private void innerExecute(
            executePipelinesInBatchRequests(
        Pipeline pipeline = getPipeline(pipelineId);  
    private void setIsSystemIngestPipelineEnabled(final boolean isSystemIngestPipelineEnabled) {  
        } catch (Exception e) {  
        }
                }  
            }
    ) {  
                }
                        counter,
                systemIngestPipelineCache.invalidateCacheForIndex(
    }
            }
    // are loaded, so in the cluster state we just save the pipeline config and here we keep the actual pipelines around.
        } catch (OpenSearchParseException e) {
    static String getProcessorName(Processor processor) {
                    )
    }  
                }
        final Thread originalThread  
    public static void updateIndexRequestWithIngestDocument(IndexRequest indexRequest, IngestDocument ingestDocument) {  
                pipelineConfig.put(INDEX_MAPPINGS, mappingMetadata.getSourceAsMap());
                // consistent id's per processor and/or semantic equals for each processor will be needed.  
import org.opensearch.script.ScriptService;  
            final String requestPipeline = indexRequest.getPipeline();
                () -> new ParameterizedMessage(
    private IndexMetadata getIndexMetadata(DocWriteRequest<?> originalRequest, IndexRequest indexRequest, Metadata metadata) {  
            if (indexPipeline == null) {
        final IngestPipelineType pipelineInfoType = pipelineInfo.getType();
        final Map<String, PipelineConfiguration> pipelinesCopy = new HashMap<>(pipelines);
        );
                }
                        pipelineInfoIterator.forEachRemaining($ -> {});
                    completeExecution(totalIndexRequestCounter, onCompletion, originalThread, indexRequests.size());
     * Deletes the pipeline specified by id in the request.
                if (exceptions == null) {  
            );
     * Defines the limit for the number of processors an ingest pipeline can have.
                );  
            final Map<String, Object> pipelineConfig = new HashMap<>();
                    );
            return holder.pipeline;
 * GitHub history for details.
                    systemIngestPipelineId = getSystemIngestPipelineForTemplateV1(templates, indexRequest);
    void innerUpdatePipelines(IngestMetadata newIngestMetadata) {
                ),
        }
    }
                .stream()
        }
            }
import org.opensearch.common.metrics.OperationMetrics;  
    }  
                    );
        // Parent/child slots are used to map index requests to their position in the original bulk request list.
                List<IngestDocumentWrapper> exceptions = new ArrayList<>();
        }  
                newPipelines = new HashMap<>(existingPipelines);
                // the per processor metrics may get reset when the arrays don't match. However, to get to an ideal model, unique and
                    "Pipeline id [%s] exceeds maximum length of %d UTF-8 bytes (actual: %d bytes)",  
                } else {
                // break in the case of self referencing processors in the event a processor author creates a
                .map((IngestPipelineInfo::toString))  
import org.opensearch.action.ingest.DeletePipelineRequest;
            if (indexAbstraction != null) {
        List<Processor> processors = pipeline.flattenAllProcessors();  
        Map<SlotKey, IndexRequest> slotIndexRequestMap = new HashMap<>();
 */  
            // direct access to the original index request already.
                }
 * the Apache License, Version 2.0 (the "License"); you may
     * @return If the index request has an ingest pipeline or not.
            sb.append(":");
                    metric = conditionalProc.getMetric();  
     * @return the underlying child index requests  
        @NonNull final Thread originalThread,  
                        }  
        final List<DocWriteRequest<?>> actionRequests,
    /**  
                                new IllegalStateException(pipelineInfoType + " pipeline [" + pipelineId + "] can't change the target index")  
                pipelineConfig.put(INDEX_SETTINGS, settings);
        } catch (Exception e) {
import org.opensearch.action.index.IndexRequest;
                        String type = compositeMetric.v1().getType();
                        mappingsMap.add(MapperService.parseMapping(xContentRegistry, template.mappings().string()));
        // Iterate over pipeline configurations in ingest metadata and constructs a new pipeline if there is no pipeline
                        metadata,
import org.opensearch.cluster.ClusterChangedEvent;
            throw new RuntimeException("Should not executePipelines when the pipeline iterator does not have next pipeline.");  
                batch.get(0).getIngestPipelineInfoList().iterator(),
    public void executeBulkRequestSync(
        String type = e.getHeaderKeys().contains("processor_type") ? e.getHeader("processor_type").get(0) : "unknown";
    private static final int MAX_PIPELINE_ID_BYTES = 512;
        if (originalRequest != null) {  
                Pipeline oldPipeline = previous.pipeline;
            if (pipeline == null) {
        }  
        }
                indexMetadata = indexAbstraction.getWriteIndex();
                if (i < indexRequests.size() - 1) {  
            } else if (indexRequest.index() != null) {  
            if (mappingMetadata != null) {  
    public void executeBulkRequest(
        final PipelineConfiguration configuration;  
                protected AcknowledgedResponse newResponse(boolean acknowledged) {  
                }
import org.opensearch.cluster.node.DiscoveryNode;
        }
                        slot,
        if (ingestPipeline == null) {
import java.util.Iterator;  
                    if (this.isSystemIngestPipelineEnabled) {  
            }  
        BiConsumer<Integer, Exception> onFailure,  
    /**
            innerExecute(slot, indexRequest, pipeline, onDropped, e -> {
                if (pipelineInfoIterator.hasNext()) {
                throw new IllegalStateException(errorMessage);
                        indexRequest,  
    );
    ) {
        indexRequest.index((String) metadataMap.get(IngestDocument.Metadata.INDEX));
        }  
        );
                    }  
     * Gets the child index requests associated with an action request
                if (entry.getValue().containsProcessor(type) == false && ConditionalProcessor.TYPE.equals(type) == false) {
        for (IngestPlugin ingestPlugin : ingestPlugins) {
                // need to set pipeline of the request as NOOP_PIPELINE_NAME so that when we switch back to the write thread
                    }
 *  
                    }  
            return;
        }
import org.opensearch.threadpool.ThreadPool;
            .addSettingsUpdateConsumer(SYSTEM_INGEST_PIPELINE_ENABLED, this::setIsSystemIngestPipelineEnabled);  
            // the target index so we can simply use the first request.
    }
            // We don't pass in child slot to single index request pipeline executions since we have
    /**
                    }
            }
            String originalIndex = indexRequest.indices()[0];  
                handler.accept(allResults);
import org.opensearch.common.settings.Setting;
                updateIndexRequestWithIngestDocument(indexRequest, ingestDocument);
        PipelineHolder(PipelineConfiguration configuration, Pipeline pipeline) {  
                            results.get(i).getException()
import java.util.Set;
            if (pipeline == null) {  
        AnalysisRegistry analysisRegistry,
                processorMetrics.add(new Tuple<>(processor, metric));
            }
            PipelineHolder previous = existingPipelines.get(newConfiguration.getId());
            protected void doRun() {
        for (IngestPlugin ingestPlugin : ingestPlugins) {  
                return Collections.emptyList();
        @NonNull final BiConsumer<Thread, Exception> onCompletion,
                if (wrappingProcessor == processor) {  
     * Gets all the Processors of the given type from within a Pipeline.  
    }  
        });
                        onDropped,
        this.scriptService = scriptService;
                    e
            statsBuilder.addPipelineMetrics(id, pipeline.getMetrics());
                        systemIngestPipelineId = getSystemIngestPipelineForTemplateV1(templates, indexRequest);
                onFailure,  
    }  
                    }
     * Used to match success/exceptions to their original requests post batch splitting
            }  
package org.opensearch.ingest;
            sb.append(pipelineName);  
        }
        final DocWriteRequest<?> actionRequest,
            String finalPipeline = null;
    }
                systemIngestPipelineId = getSystemIngestPipelineForExistingIndex(indexMetadata, indexRequest);
            String systemIngestPipelineId = null;  
        DocWriteRequest<?> actionRequest,
            } catch (Exception e) {
        }
                    }
        });  
        BiConsumer<Thread, Exception> onCompletion,
    public void delete(DeletePipelineRequest request, ActionListener<AcknowledgedResponse> listener) {  
                }
    /**
     */
                    // order of templates are highest order first
                            );
                return;
        IndexRequest indexRequest  
        }
     *
        pipeline.batchExecute(ingestDocumentWrappers, results -> {  
            Pipeline pipeline = holder.pipeline;
        // check the alias for the action request (this is how upserts are modeled)
                }
            for (final CompressedXContent mapping : mappings) {  
     * @param originalRequest
                    "failed to execute pipeline [{}] for document [{}/{}]",  
                processor = wrappingProcessor.getInnerProcessor();  
                    dropped.forEach(t -> itemDroppedHandler.accept(t.getSlot()));
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.cluster.service.ClusterService;  
    }  
            } else {
            }
                // Best attempt to populate new processor metrics using a parallel array of the old metrics. This is not ideal since
        if (metadataMap.get(IngestDocument.Metadata.IF_PRIMARY_TERM) != null) {
             * these cases as we need to reject the request if the pipeline was set by a required pipeline and there is a request  
                @Override
            // we will rely on the target index of the actionRequests and indexRequests to resolve the system  
        return ingestPipeline.getProcessors().isEmpty() ? null : indexId;  
            CompoundProcessor rootProcessor = pipeline.getCompoundProcessor();  
            final List<Map<String, Object>> mappingsMap = new ArrayList<>();  
        // before ingestion, which might also get modified during ingestion.  
                            break;  
                if (template.settings() != null) {  
    static List<PipelineConfiguration> innerGetPipelines(IngestMetadata ingestMetadata, String... ids) {
                onDropped,
    public Pipeline getPipeline(String id) {
import org.opensearch.gateway.GatewayService;
            final Settings settings = indexMetadata.getSettings();
    ) {
                for (IngestDocumentWrapper ingestDocumentWrapper : succeeded) {  
                    newConfiguration.getConfigAsMap(),
            final IndexMetadata indexMetadata = getIndexMetadata(originalRequest, indexRequest, metadata);
            for (int childSlot = 0; childSlot < childIndexRequests.size(); childSlot++) {  
        int pipelineIdLength = UnicodeUtil.calcUTF16toUTF8Length(request.getId(), 0, request.getId().length());  
                Processor processor = t.v1();
import static org.opensearch.plugins.IngestPlugin.SystemIngestPipelineConfigKeys.INDEX_TEMPLATE_SETTINGS;
        } else {
            (delay, command) -> threadPool.schedule(command, TimeValue.timeValueMillis(delay), ThreadPool.Names.GENERIC),  
 */  
        for (Map.Entry<String, PipelineHolder> entry : existingPipelines.entrySet()) {  
    }
        return processorMetrics;
                if (template.mappings() != null) {  
        // only surface the top level non-failure processors, on-failure processor times will be included in the top level non-failure  
                // the index does not exist yet (and this is a valid request), so match index
        // start to look for default or final pipelines via settings found in the index meta data
                        onFailure,  
                if (this.isSystemIngestPipelineEnabled) {  
/*
            if (previous != null && previous.configuration.equals(newConfiguration)) {  
            logger.debug(
            final Map<String, Object> pipelineConfig = new HashMap<>();
            }
                            "Failed to resolve system ingest pipeline due to failed to parse the mappings ["
        }
    ) throws Exception {
                documentLogBuilder.append(indexRequest.index());  
            pipelineConfig.put(INDEX_TEMPLATE_MAPPINGS, mappingsMap);
        for (int i = 0; i < slots.size(); ++i) {
    }  
            indexAndPipelineIds.addAll(pipelineInfo);  
        final IntConsumer onDropped,  
                toRemove.add(pipelineKey);
                // and invoke doInternalExecute of the TransportBulkAction we will not execute the pipeline again.  
                if (finalPipelineId != null && IngestService.NOOP_PIPELINE_NAME.equals(finalPipelineId) == false) {
                        actionRequestsTargetIndexUnchanged,  
            }
        // the pipeline specific stat holder may not exist and that is fine:
                exceptions.add(parseException);  
    }
     * Same as {@link #executeBulkRequest} but executes synchronously on the calling thread  
import java.util.Collections;  
                                + template.name(),
                    }
        Iterable<DocWriteRequest<?>> actionRequests,
    /**  
    }
                }  
                    completeExecution(counter, onCompletion, originalThread, 1);  
        final String pipelineId = pipelineInfo.getPipelineId();
    }  
                pipelineInfoIterator,
     * Resolve the ingest pipeline, final ingest pipeline and system ingest pipeline for the request.  
                        hasTargetIndexChanged = true;  
        for (String pipelineKey : pipelines.keySet()) {  
            Pipeline indexPipeline = systemIngestPipelineCache.getSystemIngestPipeline(pipelineId);
import org.opensearch.transport.client.Client;
        };
import org.opensearch.action.DocWriteRequest;
     * @param metadata
                );  
    }
                    );  
        List<Exception> exceptions = new ArrayList<>();
        this.isSystemIngestPipelineEnabled = isSystemIngestPipelineEnabled;
        ingestClusterStateListeners.add(listener);  
        indexRequest.setFinalPipeline(null);
                IndexRequest indexRequest = indexRequests.get(i);
        if (ingestMetadata == null) {  
                        } else {
    private final ClusterManagerTaskThrottler.ThrottlingKey deletePipelineTaskKey;
            }  
import org.opensearch.cluster.metadata.IndexAbstraction;
                }
    public IngestInfo info() {  
        for (IndexRequestWrapper indexRequestWrapper : indexRequestWrappers) {  
    public ScriptService getScriptService() {
            if (processor instanceof CompoundProcessor compoundProc) {
                Pipeline pipeline = substitutePipeline(newConfiguration.getId(), parseException);
            return updateRequest.getChildIndexRequests();
            "delete-pipeline-" + request.getId(),
        return slotIndexRequestMap;
     *  
                return type;  
                        indexRequest.index(),
    private void resetPipelineAfterIndexChange(IndexRequest indexRequest) {
import org.opensearch.ResourceNotFoundException;
                                indexRequest != null ? indexRequest.id() : null  
        // Publish cluster state to components that are used by processor factories before letting  
 * this work for additional information regarding copyright
     * @param clazz the Processor class to look for
    public static final Setting<Integer> MAX_NUMBER_OF_INGEST_PROCESSORS = Setting.intSetting(
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                }  
        if (processor instanceof ConditionalProcessor conditionalProc) {  
    private record SlotKey(int slot, int childSlot) {
        }
    private volatile ClusterState state;  
                String v2Template = MetadataIndexTemplateService.findV2Template(metadata, indexRequest.index(), false);  
import java.util.HashSet;
            @Override
        @NonNull final IndexRequest indexRequest
                    return deletePipelineTaskKey;
    ) {
        final Thread originalThread
    void validatePipeline(Map<DiscoveryNode, IngestInfo> ingestInfos, PutPipelineRequest request) throws Exception {
        ExceptionsHelper.rethrowAndSuppress(exceptions);
    // package private for testing  
    /**  
        List<IndexRequest> indexRequests
                for (Map.Entry<String, PipelineConfiguration> entry : ingestMetadata.getPipelines().entrySet()) {  
            if (Regex.isSimpleMatchPattern(id)) {
            pipelineConfig.put(INDEX_TEMPLATE_SETTINGS, settingsList);
        // processor factories create new processor instances.
            }  
        long startTimeInNanos = System.nanoTime();
        List<IngestPlugin> ingestPlugins,  
                systemIngestPipelineCache.invalidateCacheForIndex(previousIndexMetadata.getIndex().toString());  
        indexRequest.isPipelineResolved(true);
        long startTimeInNanos = System.nanoTime();  
                    throw new IllegalArgumentException("Ingest processor [" + entry.getKey() + "] is already registered");
                List<Tuple<Processor, OperationMetrics>> oldPerProcessMetrics = new ArrayList<>();  
            }
    private volatile Map<String, PipelineHolder> pipelines = Collections.emptyMap();  
        List<Integer> slots,  
                    break;
        }
             * set from a request pipeline parameter versus having been set by the resolution. We need to be able to distinguish
            pipelineConfig.put(INDEX_TEMPLATE_MAPPINGS, mappingsMap);
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
                totalMetrics.afterN(size, ingestTimeInNanos);
                    scriptService  
                            e  
                    }  
                        if (finalPipeline == null && IndexSettings.FINAL_PIPELINE.exists(settings)) {  
        // we only set the pipeline in request when there is a processor  
            } else {  
                    if (Objects.equals(originalIndex, indexRequest.indices()[0]) == false) {
        // If the default or final pipelines were resolved previously we don't want to overwrite them.  
                        indexRequest.index(),
        List<IngestPlugin> ingestPlugins,  
            this.pipelines = Collections.unmodifiableMap(newPipelines);
        return ingestPipeline.getProcessors().isEmpty() ? null : indexId;
                } else {
                handler.accept(null);
        final List<IndexRequest> indexRequests,
        if (IngestPipelineType.SYSTEM_FINAL.equals(pipelineType)) {  
        IntConsumer onDropped,  
        Map<SlotKey, IndexRequest> slotToindexRequestMap = new HashMap<>();
        List<PipelineConfiguration> result = new ArrayList<>(ids.length);  
                // in a valid null case if this is the last pipeline we should complete the execution
        this.systemIngestPipelineCache = systemIngestPipelineCache;
            // pipeline for the request if the previously resolved one is invalidated. Since we group requests by
    private String getSystemIngestPipelineForExistingIndex(@NonNull final IndexMetadata indexMetadata, IndexRequest indexRequest) {
    ) {
                        defaultPipeline = IndexSettings.DEFAULT_PIPELINE.get(settings);
                        e
            analysisRegistry,  
        return Collections.unmodifiableMap(processorFactories);
                // the target index so need to check each request  
                indexRequest.setPipeline(NOOP_PIPELINE_NAME);
             * has been forwarded by a non-ingest coordinating node to an ingest node. In this case, the coordinating node will have
        int slot = 0;  
    }  
        }
        // (e.g. the pipeline may have been removed while we're ingesting a document
                List<IngestDocumentWrapper> dropped = new ArrayList<>();
            for (Map.Entry<DiscoveryNode, IngestInfo> entry : ingestInfos.entrySet()) {  
                protected AcknowledgedResponse newResponse(boolean acknowledged) {  
        String routing = indexRequest.routing();
 * compatible open source license.
        if (newIngestMetadata == null) {
                        }
            if (requestPipeline != null) {
            } else {  
    }  
        Map<String, Object> pipelineConfig = XContentHelper.convertToMap(request.getSource(), false, request.getMediaType()).v2();
            getProcessorMetrics(rootProcessor, processorMetrics);  
import static org.opensearch.plugins.IngestPlugin.SystemIngestPipelineConfigKeys.INDEX_TEMPLATE_MAPPINGS;
            @Override
            slotToindexRequestMap.put(new SlotKey(slots.get(i), childSlots.get(i)), indexRequests.get(i));
     * flow through the same pipeline together.
                newPipeline.getMetrics().add(oldPipeline.getMetrics());
        return result;  
                        pipelineInfoIterator,
    private Pipeline createSystemIngestPipeline(@NonNull final String indexId, @NonNull final Map<String, Object> pipelineConfig) {
        if (currentIngestMetadata == null) {
            scriptService,
            }  
        IndicesService indicesService,
            if (currentIndexMetadata == null || ClusterChangedEvent.indexMetadataChanged(previousIndexMetadata, currentIndexMetadata)) {
        );
        @NonNull final String templateName,  
                batchedIndexRequests.add(
                    onFailure.accept(slot, e);  
        return Collections.unmodifiableMap(processorFactories);
        // (Note that this needs to be done also in the case when there is no change to ingest metadata, because in the case
        Long version = indexRequest.version();
            final IndexMetadata previousIndexMetadata = entry.getValue();
                if (previous == null) {
        Map<String, PipelineConfiguration> pipelines = currentIngestMetadata.getPipelines();
        ClusterState.Builder newState = ClusterState.builder(currentState);
                }
                            // invalid target index change we should fail the doc
     * @return pipeline configuration specified by id. If multiple ids or wildcards are specified multiple pipelines
     */
            || NOOP_PIPELINE_NAME.equals(indexRequest.getSystemIngestPipeline()) == false;  
        ingestClusterStateListeners.forEach(consumer -> consumer.accept(state));
import java.util.function.BiConsumer;
        Setting.Property.NodeScope,
                    if (indexRequestsTargetIndexUnchanged.isEmpty()) {
    ) {
                statsBuilder.addProcessorMetrics(id, getProcessorName(processor), processor.getType(), processorMetric);
        }  
                    }  
        if (indexRequest.getPipeline() == null) {
        }  
                    finalPipeline = IndexSettings.FINAL_PIPELINE.get(indexSettings);  
             * can not double-resolve the pipeline because we will not be able to distinguish the case of the pipeline having been
            indexAndPipelineIds.add(index);
                }
            pipelineConfig.put(INDEX_TEMPLATE_SETTINGS, settings == null ? Collections.emptyList() : List.of(settings));  
                    throw new RuntimeException("[" + entry.getKey() + "] is not a system generated processor factory.");  
 * The OpenSearch Contributors require contributions made to  
        }
import org.opensearch.common.unit.TimeValue;
        Environment env,  
import org.opensearch.cluster.ClusterStateApplier;  
                        null
        final AtomicInteger totalIndexRequestCounter = new AtomicInteger(indexRequestWrappers.size());
                    result.add(pipeline);
        // Iterate over the current active pipelines and check whether they are missing in the pipeline configuration and
    }  
            if (Regex.simpleMatch(request.getId(), pipelineKey)) {
                                + "] of the index template: "
                "Cannot use more than the maximum processors allowed. Number of processors being configured is ["
                            ),
    static class PipelineHolder {
        if (pipelineInfoIterator.hasNext() == false) {
        if (metadataMap.get(IngestDocument.Metadata.VERSION_TYPE) != null) {
                        actionRequest,
                }
                        ),  
        }  
        }
                    mappingsMap.add(MapperService.parseMapping(xContentRegistry, mapping.string()));
            onCompletion.accept(originalThread, null);
            @Override
        }
import reactor.util.annotation.NonNull;
 * @opensearch.internal
                    } else {
import org.opensearch.action.bulk.TransportBulkAction;  
                indexRequest.setSystemIngestPipeline(NOOP_PIPELINE_NAME);  
            || NOOP_PIPELINE_NAME.equals(indexRequest.getFinalPipeline()) == false
                            // we can not break in case a lower-order template has a default pipeline that we need to collect
     * @return True if the pipeline contains an instance of the Processor class passed in  
        if (metadataMap.get(IngestDocument.Metadata.IF_SEQ_NO) != null) {
 */
            env,
            @Override
        }  
                            // we can break if we have already collected a default and final pipeline
        if (currentIngestMetadata != null) {
            return currentState;
        );  
                    // find the final pipeline if one is defined from an existing index setting
        IngestMetadata ingestMetadata = clusterState.getMetadata().custom(IngestMetadata.TYPE);
                if (pipeline != null) {
                        onFailure,
            if (exceptions != null) {
                return List.of(childIndexRequest);
                // templates to look for pipelines in either a matching V2 template (which takes
                        logger.debug(
                                indexRequest != null ? indexRequest.index() : null,
        @NonNull final List<IndexTemplateMetadata> templates,  
            indexRequest.setFinalPipeline(finalPipeline != null ? finalPipeline : NOOP_PIPELINE_NAME);
            Map<SlotKey, IndexRequest> slotIndexRequestMap = createSlotIndexRequestMap(slots, childSlot, indexRequests);
        final IntConsumer onDropped,
            indexRequest.setPipeline(defaultPipeline != null ? defaultPipeline : NOOP_PIPELINE_NAME);  
import java.util.function.IntConsumer;
                // precedence), or if a V2 template does not match, any V1 templates
        String systemIngestPipelineId = null;  
            return null;
                            String oldType = oldCompositeMetric.v1().getType();
            );  
                    pipelinesInfoList.add(new IngestPipelineInfo(finalPipelineId, IngestPipelineType.FINAL));
                        originalThread
                    } catch (IOException e) {  
                List<IngestPipelineInfo> pipelinesInfoList = new ArrayList<>();
            List<Tuple<Processor, OperationMetrics>> processorMetrics = new ArrayList<>();
        ingestDocument.executePipeline(pipeline, (result, e) -> {  
                    newConfiguration.getId(),  
        IntConsumer onDropped
            return;  
        }
                            "failed to execute pipeline [{}] for document [{}/{}]",
        Setting.Property.NodeScope,  
        setIsSystemIngestPipelineEnabled(clusterService.getClusterSettings().get(SYSTEM_INGEST_PIPELINE_ENABLED));
import java.util.concurrent.CopyOnWriteArrayList;  
    static ClusterState innerDelete(DeletePipelineRequest request, ClusterState currentState) {
                // Create index request wrappers for all index requests with pipelines that will be executed
            threadPool.generic()::execute,  
     * @return the processorMetrics for all non-failure processor that belong to the original compoundProcessor  
            final Pipeline pipeline = getPipeline(pipelineId, pipelineType, actionRequest, indexRequest);
        for (List<IndexRequestWrapper> batch : batches) {
            OperationMetrics metric = processorWithMetric.v2();  
     * @param compoundProcessor The compound processor to start walking the non-failure processors
import org.opensearch.core.xcontent.NamedXContentRegistry;  
        if (pipelineInfoIterator.hasNext() == false) {
        return pipeline;
        // Lazy initialize these variables in order to favour the most like scenario that there are no pipeline changes:
        // or the pipeline configuration has been modified  
                batch.stream().map(IndexRequestWrapper::getActionRequest).collect(Collectors.toList()),
                }
                    List<IndexTemplateMetadata> templates = MetadataIndexTemplateService.findV1Templates(  
    ) {  
            indexRequestsPerIndexAndPipelines.putIfAbsent(hashCode, new ArrayList<>());
    ) {
                        originalThread  
                    }
    ) {
                            () -> new ParameterizedMessage(
    }
            innerBatchExecute(slots, childSlot, indexRequests, pipeline, onDropped, results -> {
                        if (defaultPipeline != null && finalPipeline != null) {
            "put-pipeline-" + request.getId(),
    }
        String id = indexRequest.id();  
                String v2Template = MetadataIndexTemplateService.findV2Template(metadata, indexRequest.index(), false);
                    "Failed to resolve system ingest pipeline due to not able to collect mappings for template: "
            }
                    try {
                    "failed to execute pipeline [{}] for documents [{}]",
        clusterService.submitStateUpdateTask(
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
            // In some edge cases it is possible the cache is invalidated after we resolve the
                if (IndexSettings.FINAL_PIPELINE.exists(indexSettings)) {
        final DocWriteRequest<?> originalRequest,
            indexRequest.version(),
        AtomicInteger counter = new AtomicInteger(size);
        indexRequest.isPipelineResolved(false);  
        ClusterService clusterService,
            IndexAbstraction indexAbstraction = metadata.getIndicesLookup().get(indexRequest.index());
            // system ingest pipeline on this node one more time.
        final String indexId = indexMetadata.getIndex().toString();
                getProcessorMetrics(oldPipeline.getCompoundProcessor(), oldPerProcessMetrics);
                // precedence), or if a V2 template does not match, any V1 templates  
            if (clazz.isAssignableFrom(processor.getClass())) {
        if (newPipelines != null) {  
        this.systemIngestProcessorFactories = systemProcessorFactories(ingestPlugins, processorParameters);
                        assert totalIndexRequestCounter.get() >= 0;
        List<P> processors = new ArrayList<>();
        final Iterator<IngestPipelineInfo> pipelineInfoIterator,
                                metric.add(oldMetric);
                    MAX_PIPELINE_ID_BYTES,
                    String message = "Processor type [" + processor.getType() + "] is not installed on node [" + entry.getKey() + "]";  
                slots.get(0),
            for (final IndexTemplateMetadata template : templates) {
        // conditionals are implemented as wrappers around the real processor, so get the real processor for the correct type for the name
    }
     */  
        if (indexRequestWrappers.isEmpty()) {  
        clusterService.submitStateUpdateTask(
     * @param indexRequest
                getProcessorMetrics(newPipeline.getCompoundProcessor(), newPerProcessMetrics);  
                for (IngestDocumentWrapper result : allResults) {  
        }
    private List<IndexRequest> getChildIndexRequests(DocWriteRequest<?> actionRequest) {
        Map<IngestDocument.Metadata, Object> metadataMap = ingestDocument.extractMetadata();
            slot++;
            throw new RuntimeException(  
    public void applyClusterState(final ClusterChangedEvent event) {
                @Override  
            if (newPipelines == null) {
import org.opensearch.index.analysis.AnalysisRegistry;
    }  
     */
                            Tuple<Processor, OperationMetrics> oldCompositeMetric = oldMetricsIterator.next();
                final String pipelineId = indexRequest.getPipeline();
 * this file be licensed under the Apache-2.0 license or a
    }  
import java.util.HashMap;
                    SlotKey slotKey = new SlotKey(ingestDocumentWrapper.getSlot(), ingestDocumentWrapper.getChildSlot());
    /**
                        final Settings settings = template.settings();
            }
        indexRequest.setSystemIngestPipeline(null);
            try {  
        // We need to cache it so that later during execution we can find it by indexId to reuse it.
            } else {  
import org.opensearch.common.util.concurrent.AbstractRunnable;
    }
                    indexRequestWrappers.add(new IndexRequestWrapper(slot, childSlot, indexRequest, actionRequest, pipelinesInfoList));
        final BiConsumer<Integer, Exception> onFailure,
                try {
     */
     * switch back to the write thread the transport bulk action can re-process it with the new target index.
        // if we didn't ask for _any_ ID, then we get them all (this is the same as if they ask for '*')
 * under the License.  
                    pipelineId,
            indexRequest.id(),
                if (processorFactory.isSystemGenerated() == false) {
            }  
                onDropped,
                    for (Tuple<Processor, OperationMetrics> compositeMetric : newPerProcessMetrics) {  
import java.util.Locale;
        // we can get an empty pipeline from the cache
                    Settings settings = MetadataIndexTemplateService.resolveSettings(metadata, v2Template);  
    private final ClusterService clusterService;
                        succeeded.add(result);  
        });
        pipelines.forEach((id, holder) -> {
            final IndexMetadata indexMetadata = getIndexMetadata(originalRequest, indexRequest, metadata);
        }
                }
        final PipelineHolder holder = pipelines.get(pipelineId);
        }
            indexRequest.setPipeline(NOOP_PIPELINE_NAME);  
import java.util.ArrayList;
        try {
            }  
        if (pipelineIdLength > MAX_PIPELINE_ID_BYTES) {
        if (holder == null) {
                }
                documentLogBuilder.append("/");
            try {
     * Adds a listener that gets invoked with the current cluster state before processor factories
                    return innerPut(request, currentState);  
        final Pipeline pipeline;
                                + template.mappings().string()  
                    } else if (result.getIngestDocument() == null) {  
        ThreadPool threadPool,
            processor = conditionalProc.getInnerProcessor();
            indexRequest.setFinalPipeline(NOOP_PIPELINE_NAME);  
    private Map<String, Processor.Factory> systemIngestProcessorFactories = null;
        CompoundProcessor compoundProcessor,  
        for (Processor processor : pipeline.flattenAllProcessors()) {  
        indexRequest.setSystemIngestPipeline(systemIngestPipelineId != null ? systemIngestPipelineId : NOOP_PIPELINE_NAME);  
    public void putPipeline(  
                        if (defaultPipeline == null && IndexSettings.DEFAULT_PIPELINE.exists(settings)) {
        // check the alias for the index request (this is how normal index requests are modeled)  
                    defaultPipeline = IndexSettings.DEFAULT_PIPELINE.get(indexSettings);
                        onFailure.accept(
                    documentLogBuilder.toString()  
 *  
                final String finalPipelineId = indexRequest.getFinalPipeline();  
                );  
            String pipelineName = pipelineProc.getPipelineTemplate().newInstance(Collections.emptyMap()).execute();
    // We know of all the processor factories when a node with all its plugin have been initialized. Also some  
                            onCompletion.accept(originalThread, null);  
                if (pipelinesInfoList.isEmpty() == false) {  
     * @param actionRequest the action request
            } catch (OpenSearchParseException e) {
     * @param originalRequest
        for (PipelineConfiguration newConfiguration : newIngestMetadata.getPipelines().values()) {
            totalMetrics.after(ingestTimeInNanos);
             * already resolved the pipeline for this request. It is important that we are able to distinguish this situation as we  
        // which pipelines to execute for each index request based on previously resolved pipelines.
            String index = indexRequestWrapper.getIndexRequest().index();  
        IntConsumer itemDroppedHandler,  
                    if (Regex.simpleMatch(id, entry.getKey())) {
        final Processor.Parameters processorParameters = new Processor.Parameters(  
            final String indexName = entry.getKey();
     * 3. a parameter of an IndexRequest.  
            completeExecution(counter, onCompletion, originalThread, 1);
        Iterable<DocWriteRequest<?>> actionRequests,  
    private final OperationMetrics totalMetrics = new OperationMetrics();
                        // update the counter before we continue to execute the next pipeline for the requests with  
            } catch (Exception e) {
        final String pipelineId = pipelineInfo.getPipelineId();  
        int size = indexRequests.size();
                }  
        for (int i = 0; i < slots.size(); ++i) {
            completeExecution(totalIndexRequestCounter, onCompletion, originalThread, indexRequests.size());
     * This is a subcase of {@link IngestService#resolvePipelines}  
            public IngestDocument execute(IngestDocument ingestDocument) {  
            processorInfoList.add(new ProcessorInfo(entry.getKey()));
     * @return If the index request has an ingest pipeline or not.
                    Iterator<Tuple<Processor, OperationMetrics>> oldMetricsIterator = oldPerProcessMetrics.iterator();
                final List<IndexRequest> indexRequestsTargetIndexUnchanged = new ArrayList<>();  
            }
             * pipeline parameter too.
        return new IngestInfo(processorInfoList);  
    private final NamedXContentRegistry xContentRegistry;
        IngestStats.Builder statsBuilder = new IngestStats.Builder();
        indexRequest.routing((String) metadataMap.get(IngestDocument.Metadata.ROUTING));  
            final List<Map<String, Object>> mappingsMap = new ArrayList<>();  
                Pipeline newPipeline = Pipeline.create(
            }
        Integer.MAX_VALUE,
    private static Map<SlotKey, IndexRequest> createSlotIndexRequestMap(
                if (pipelineInfoIterator.hasNext() == false) {
    }
        // validates the pipeline and processor configuration before submitting a cluster update task:
                indexRequest.setPipeline(requestPipeline);
            String originalIndex = indexRequests.get(0).indices()[0];
                        null  
     * 1. bound with index
        if (pipeline == null) {
            }
            Map<String, Processor.Factory> newProcessors = ingestPlugin.getProcessors(parameters);
    public Map<String, Processor.Factory> getSystemProcessorFactories() {  
            }
        return scriptService;  
     * Record object to lookup bulk request items by their slot/child slot key.  
                    executePipelinesInBatchRequests(
                }
                totalIndexRequestCounter,
        List<OpenSearchParseException> exceptions = null;
            });
                PipelineConfiguration pipeline = ingestMetadata.getPipelines().get(id);  
                }
            );
                List<IngestDocumentWrapper> succeeded = new ArrayList<>();  
import org.opensearch.cluster.ClusterState;
        this.maxIngestProcessorCount = maxIngestProcessorCount;  
    }  
    }
        @NonNull final IndexRequest indexRequest,
                long ingestTimeInNanos = System.nanoTime() - startTimeInNanos;
        if (ids.length == 0) {
            if (newIngestMetadata.getPipelines().get(entry.getKey()) == null) {
                        // the new target index in TransportBulkAction.  
    private static IngestDocumentWrapper toIngestDocumentWrapper(int slot, int childSlot, IndexRequest indexRequest) {
     * @param indexRequest  
        // we only set the pipeline in request when there is a processor
            logger.warn("failed to update ingest pipelines", e);
    ) {  
        Processor.Parameters parameters
import org.opensearch.OpenSearchParseException;  
        }
    private static Map<String, Processor.Factory> systemProcessorFactories(
     * may be returned
        Iterable<DocWriteRequest<?>> actionRequests,
        pipelines.put(request.getId(), new PipelineConfiguration(request.getId(), request.getSource(), request.getMediaType()));
            for (Map.Entry<String, Processor.Factory> entry : newProcessors.entrySet()) {  
        try {
            pipelines = new HashMap<>(currentIngestMetadata.getPipelines());  
     */
        List<IngestDocumentWrapper> ingestDocumentWrappers = new ArrayList<>();
     * IndexRequests are grouped by unique (index + pipeline_ids) before batching.  
            indexRequest.sourceAsMap()  
import java.util.Objects;
 * Unless required by applicable law or agreed to in writing,
                    settingsList.add(template.settings());
                        );  
            if (childIndexRequests.isEmpty()) {  
        if (ingestPipeline == null) {
        indexRequest.source(ingestDocument.getSourceAndMetadata(), indexRequest.getContentType());
     * before these components get used by the ingest processor factory.  
                        childSlot,  
                e
            sb.append(tag);
import org.opensearch.cluster.metadata.IndexTemplateMetadata;  
        } else {  
        if (ingestInfos.isEmpty()) {
                }
            );
     * _none. So in re-process it will be treated as the no-op. We are not sure if this is the ideal behavior, but it is
                } catch (IOException e) {  
            IndexRequest childIndexRequest = TransportBulkAction.getIndexWriteRequest(actionRequest);  
                public ClusterState execute(ClusterState currentState) {
                if (Objects.equals(originalIndex, newIndex) == false) {
                        pipelineInfoIterator,
                )
        final IngestPipelineInfo pipelineInfo = pipelineInfoIterator.next();  
/*  
                    } else {  
            if (indexMetadata != null) {
            for (int i = 0; i < indexRequests.size(); ++i) {
        clusterService.getClusterSettings().addSettingsUpdateConsumer(MAX_NUMBER_OF_INGEST_PROCESSORS, this::setMaxIngestProcessorCount);
                        + templateName
            return currentState;
     */
                    updateIndexRequestWithIngestDocument(slotToindexRequestMap.get(slotKey), ingestDocumentWrapper.getIngestDocument());
            return new ArrayList<>(ingestMetadata.getPipelines().values());  
        }
    public static final String NOOP_PIPELINE_NAME = "_none";
        if (pipeline.getProcessors().isEmpty()) {
        Map<String, PipelineHolder> existingPipelines = this.pipelines;  
import java.io.IOException;
            });
        // when only the part of the cluster state that a component is interested in, is updated.)  
                        exceptions.add(result);
        for (Tuple<Processor, OperationMetrics> processorWithMetric : compoundProcessor.getProcessorsWithMetrics()) {
        Consumer<List<IngestDocumentWrapper>> handler
        if (indexRequest.getFinalPipeline() == null) {
                // indexRequests are grouped for the same index and same pipelines, but we can conditionally change
            }
        // Otherwise, since we are only resolving system ingest pipelines, we resolve them as NOOP so their execution will be skipped.
import static org.opensearch.cluster.service.ClusterManagerTask.PUT_PIPELINE;
                if (!exceptions.isEmpty()) {  
        return ingestDocumentWrappers;
        final AtomicInteger counter,
 * You may obtain a copy of the License at  
                        }
    }
        // the pipeline specific stat holder may not exist and that is fine:
                Processor.Factory processorFactory = entry.getValue();
            String defaultPipeline = null;
        true,  
            throw new IllegalStateException("Ingest info is empty");  
            }  
import java.util.stream.Collectors;
    }  
        final IndexRequest indexRequest,  
}
        // we can get an empty pipeline from the cache
                String type = processor.getType();
                );
        String index = indexRequest.index();
                indexRequest.setFinalPipeline(NOOP_PIPELINE_NAME);
     * A system pipeline is a special type of internal pipeline associated with an index based on the index mapping.
                    processorFactories,
            if (e != null) {  
        IngestMetadata newIngestMetadata = state.getMetadata().custom(IngestMetadata.TYPE);  
     * <p>
            pipelinesCopy.remove(key);  
                        onCompletion,
        Setting.Property.Dynamic
    }
    }  
                public ClusterState execute(ClusterState currentState) {
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;  
    private volatile boolean isSystemIngestPipelineEnabled;
     * We will not execute the default pipeline of the new target index so we don't reset it as null and keep it as  
                }  
    );  
        this.clusterService = clusterService;  
     */
            ingestPipeline = createSystemIngestPipeline(indexId, pipelineConfig);  
    private static Map<String, Processor.Factory> processorFactories(List<IngestPlugin> ingestPlugins, Processor.Parameters parameters) {
     * Defines if we should enable the system ingest pipeline
     */  
                    return new AcknowledgedResponse(acknowledged);
            onFailure.accept(slot, e);
                if (newPerProcessMetrics.size() == oldPerProcessMetrics.size()) {
        logger.debug("batchSize: {}, batches: {}", batchSize, batches.size());
        return "[" + indexName + "/template]";
                ExceptionsHelper.rethrowAndSuppress(exceptions);  
                if (processorFactories.put(entry.getKey(), entry.getValue()) != null) {
                final String systemPipelineId = indexRequest.getSystemIngestPipeline();
                    for (final IndexTemplateMetadata template : templates) {  
import org.opensearch.common.collect.Tuple;
            public String getType() {
    }
                for (int i = 0; i < indexRequests.size(); ++i) {  
        final List<Integer> slots,
            );
        Map<String, Processor.Factory> processorFactories = new HashMap<>();  
                }
     * the existing behavior and can avoid infinite index re-route so we decide to keep this behavior.
        BiConsumer<Integer, Exception> onFailure,
        // Walk through slot by slot. For each slot, go through childslots (child index requests) and determine  
import org.opensearch.index.VersionType;
            while (processor instanceof WrappingProcessor wrappingProcessor) {
        Pipeline pipeline,
            indexRequest.setIfPrimaryTerm(((Number) metadataMap.get(IngestDocument.Metadata.IF_PRIMARY_TERM)).longValue());  
                @Override  
        for (DocWriteRequest<?> actionRequest : actionRequests) {  
    /**  
                    new ArrayList<>(  
                    pipelineIdLength  
        totalMetrics.before();
        if (indexMetadata == null && indexRequest.index() != null) {
                            }  
                }
            Metadata.builder(currentState.getMetadata()).putCustom(IngestMetadata.TYPE, new IngestMetadata(pipelines)).build()
            return;
     * Only IndexRequests in the same group could be batched. It's to ensure batched documents always
        }
    private final SystemIngestPipelineCache systemIngestPipelineCache;  
                        }
        }
                                pipelineId,
                onFailure,  
                    logger.debug(  
    private void setMaxIngestProcessorCount(Integer maxIngestProcessorCount) {
        return processorFactories;  
            }  
        Map<DiscoveryNode, IngestInfo> ingestInfos,
                exceptions.add(e);
import org.opensearch.action.ingest.PutPipelineRequest;  
            return;
     */  
            // pipeline or the request is forwarded from a non-ingest node. In that case we should try to resolve the  
                // wrapping processor that has its inner processor refer to itself.
     * @param indexRequest An index request.  
 * Licensed to Elasticsearch under one or more contributor  
    }  
        state = event.state();
            }
                            hasInvalidTargetIndexChange = true;  
        List<List<IndexRequestWrapper>> batches = prepareBatches(batchSize, indexRequestWrappers);
                    pipelineId,
/*  
        }
        final BiConsumer<Thread, Exception> onCompletion,  
     */
        }  
        final Map<String, IndexMetadata> currentIndices = event.state().metadata().indices();
        this.processorFactories = processorFactories(ingestPlugins, processorParameters);  
    private void executePipelinesInBatchRequests(  
        final int completedRequestSize
        VersionType versionType = indexRequest.versionType();  
                }  
                }
    private final Map<String, Processor.Factory> processorFactories;  
    }
                    throw new RuntimeException("Failed to parse the mappings [" + mapping + "] of the index template: " + templateName, e);
            }
                List<Tuple<Processor, OperationMetrics>> newPerProcessMetrics = new ArrayList<>();
                handler.accept(null);
        }
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                }
                    Settings settings = MetadataIndexTemplateService.resolveSettings(metadata, v2Template);
    // processor factories rely on other node services. Custom metadata is statically registered when classes
            long ingestTimeInNanos = System.nanoTime() - startTimeInNanos;
    }
            }  
            indexRequest.routing(),  
                        }
                if (v2Template != null) {
             */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
