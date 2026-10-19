                String type = processor.getType();
/**
                    return new AcknowledgedResponse(acknowledged);
        if (searchRequest.source() != null  
            }
            return copy;
    private final Map<
 *
        if (metadata == null) {
    public SearchPipelineStats stats() {
        // Lazily initialize these variables in order to favour the most likely scenario that there are no pipeline changes:
 * The OpenSearch Contributors require contributions made to  
            throw new IllegalArgumentException("The 'verbose pipeline' option requires a search pipeline to be defined.");
        List.of(),
        return enabledSystemGeneratedFactories != null
    }
            }  
            try {
        for (Map.Entry<String, Object> entry : config.entrySet()) {
        clusterService.getClusterSettings()
import org.opensearch.common.xcontent.XContentHelper;
                    phaseInjectorProcessorFactories,
        Set<String> toRemove = new HashSet<>();
            } catch (Exception e) {
     * it reads them; copying leaves the request's original {@code searchPipelineSource} intact for later readers.
    }  
            }  
        // if so delete the pipeline from new Pipelines map:
        List<SearchPipelinePlugin> searchPipelinePlugins,  
    ) {  
                phaseProcessorInfoList  
import org.opensearch.core.index.Index;
        AnalysisRegistry analysisRegistry,
        this.namedWriteableRegistry = namedWriteableRegistry;
            List<Object> source = (List<Object>) value;
        List<SearchPipelinePlugin> searchPipelinePlugins,
                toRemove.add(pipelineKey);
                    }  
            && systemGeneratedPipelineHolder.isNoOp()) {  
        newState.metadata(
                                    pipelineId = currentPipelineId;  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;  
        if (searchRequest.source() != null && searchRequest.source().searchPipelineSource() != null) {
    private final ClusterService clusterService;  
            );
            analysisRegistry,  
        List<ProcessorInfo> phaseProcessorInfoList = phaseInjectorProcessorFactories.keySet()
            Metadata.builder(currentState.getMetadata()).putCustom(SearchPipelineMetadata.TYPE, new SearchPipelineMetadata(newPipelines))
    Map<String, Processor.Factory<SearchPhaseResultsProcessor>> getSearchPhaseResultsProcessorFactories() {
import org.apache.logging.log4j.LogManager;
                    );
            systemGeneratedResponseProcessorFactories,
        if (newSearchPipelineMetadata == null) {  
                            if (IndexSettings.DEFAULT_SEARCH_PIPELINE.exists(indexSettings)) {  
        PutSearchPipelineRequest request,  
                }  
        PipelineHolder(PipelineConfiguration configuration, PipelineWithMetrics pipeline) {
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {  
                // reconstructed fresh from bytes on each PipelineConfiguration.getConfigAsMap() call.
        }  
                PipelineHolder pipelineHolder = pipelines.get(pipelineId);
 * compatible open source license.
            return deepCopyConfig((Map<String, Object>) value);  
import org.opensearch.common.settings.Settings;  
        this.clusterService = clusterService;
            phaseInjectorProcessorFactories,
        this.requestProcessorFactories = processorFactories(searchPipelinePlugins, p -> p.getRequestProcessors(parameters));  
import org.opensearch.threadpool.ThreadPool;
                    exceptions.add(ConfigurationUtils.newConfigurationException(processor.getType(), processor.getTag(), null, message));
        for (String key : toRemove) {  
                    newConfiguration.getConfigAsMap(),
        return new PipelinedRequest(pipeline, searchRequest, requestContext, systemGeneratedPipelineHolder);
            )
    }
            client,
        if (newPipelines != null) {
        Function<SearchPipelinePlugin, Map<String, Processor.Factory<T>>> processorLoader
        String,  
            throw new IllegalArgumentException(  
                public ClusterState execute(ClusterState currentState) {
        List<OpenSearchParseException> exceptions = null;
            copy.put(entry.getKey(), deepCopyConfigValue(entry.getValue()));  
    }
        return new SearchPipelineInfo(
                } catch (IndexNotFoundException e) {
    void validatePipeline(Map<DiscoveryNode, SearchPipelineInfo> searchPipelineInfos, PutSearchPipelineRequest request) throws Exception {
        final PipelineConfiguration configuration;
            namedXContentRegistry
        );
                try {
        }
        int pipelineIdLength = UnicodeUtil.calcUTF16toUTF8Length(request.getId(), 0, request.getId().length());  
            threadPool.getThreadContext(),
    static ClusterState innerPut(PutSearchPipelineRequest request, ClusterState currentState) {
            .collect(Collectors.toList());
            if (Regex.simpleMatch(request.getId(), pipelineKey)) {  
                    newConfiguration.getId(),  
                if (processorFactories.put(entry.getKey(), entry.getValue()) != null) {
        }
import java.util.Collections;  
                    // Check for index default pipeline  
                pipeline = pipelineHolder.pipeline;
            }
 * against requests and responses.  
                    AD_HOC_PIPELINE_ID,
        this.scriptService = scriptService;  
            .collect(Collectors.toList());  
import org.opensearch.tasks.Task;
import org.opensearch.cluster.service.ClusterService;
        List<Exception> exceptions = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
    private volatile List<String> enabledSystemGeneratedFactories;
                                String currentPipelineId = IndexSettings.DEFAULT_SEARCH_PIPELINE.get(indexSettings);
        // Iterate over pipeline configurations in metadata and constructs a new pipeline if there is no pipeline
                )
            .collect(Collectors.toList());
            }
        }
                                    pipelineId = NOOP_PIPELINE_ID;
            }
        if (state.blocks().hasGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK)) {  
        this.systemGeneratedPhaseResultsProcessorFactories = processorSystemGeneratedFactories(
                @Override
    Map<String, Processor.Factory<SearchRequestProcessor>> getRequestProcessorFactories() {
        }  
        }
                // Build the ad-hoc pipeline from a DEEP COPY of the inline source map. PipelineWithMetrics.create ->  
import static org.opensearch.cluster.service.ClusterManagerTask.DELETE_SEARCH_PIPELINE;
                    newPipelines = new HashMap<>(existingPipelines);
            Metadata.builder(currentState.getMetadata())  
            .stream()  
        validateProcessors(searchPipelineInfos, exceptions, Pipeline.REQUEST_PROCESSORS_KEY, pipeline.getSearchRequestProcessors());  
                }  
        return phaseInjectorProcessorFactories;  
        }  
        Map<DiscoveryNode, SearchPipelineInfo> searchPipelineInfos,
        putPipelineTaskKey = clusterService.registerClusterManagerTask(PUT_SEARCH_PIPELINE, true);  
        for (SearchPipelinePlugin plugin : searchPipelinePlugins) {
    }
                }
            pipelines = new HashMap<>(currentSearchPipelineMetadata.getPipelines());
        Setting.Property.NodeScope
    // VisibleForTesting
    }
            return Collections.emptyList();
            pipeline.populateStats(builder);
            return;
            new OperationMetrics(), // Use ephemeral metrics for validation
            namedWriteableRegistry,  
                }
            return new ArrayList<>(metadata.getPipelines().values());
                );  
        ScriptService scriptService,
    public static final String ALL = "*";  
            // Pipeline defined in search request (ad hoc pipeline).
                }  
        validateProcessors(searchPipelineInfos, exceptions, Pipeline.PHASE_PROCESSORS_KEY, pipeline.getSearchPhaseResultsProcessors());
    }
        }  
        List<Exception> exceptions,
import java.util.HashSet;
 * @opensearch.internal
import org.opensearch.ResourceNotFoundException;  
        ClusterState.Builder newState = ClusterState.builder(currentState);
        if (pipelineIdLength > MAX_PIPELINE_ID_BYTES) {
                // TODO -- replace pipeline with one that throws this exception when we try to use it
        clusterService.submitStateUpdateTask(
        List<? extends Processor> processors
                        result.add(entry.getValue());
        final PipelineWithMetrics pipeline;
        // by the XContent parser, which only yields Map/List/scalar values (never Set), so no other container types
        );
            if (searchRequest.pipeline() != null) {  
                }
import org.opensearch.env.Environment;
            for (Map.Entry<DiscoveryNode, SearchPipelineInfo> entry : searchPipelineInfos.entrySet()) {
        }
import org.opensearch.common.unit.TimeValue;
    }
        SearchPipelinePlugin.Parameters parameters = new SearchPipelinePlugin.Parameters(  
                String.format(
    }
            threadPool.generic()::execute,  
import org.opensearch.cluster.ClusterStateApplier;
    private void setEnabledSystemGeneratedFactories(List<String> enabledSystemGeneratedFactories) {
    private static <T extends Processor> Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<T>> processorSystemGeneratedFactories(
        state = event.state();
import java.util.Locale;
        }
                    }
                if (entry.getValue().containsProcessor(processorKey, type) == false) {  
    private final Map<
        deletePipelineTaskKey = clusterService.registerClusterManagerTask(DELETE_SEARCH_PIPELINE, true);
                requestProcessorInfoList,
        clusterService.submitStateUpdateTask(  
    }
        SearchPipelineMetadata currentSearchPipelineMetadata = currentState.metadata().custom(SearchPipelineMetadata.TYPE);
    private volatile ClusterState state;
                if (pipelineHolder == null) {
        this.responseProcessorFactories = processorFactories(searchPipelinePlugins, p -> p.getResponseProcessors(parameters));
     * them to generate search processors for the search request. Or can use a wildcard * to enable all.
                    "Both named and inline search pipeline were specified. Please only specify one or the other."
                if (previous != null) {  
                OpenSearchParseException parseException = new OpenSearchParseException(
    ) {
import org.opensearch.OpenSearchParseException;
import static org.opensearch.plugins.SearchPipelinePlugin.SystemGeneratedSearchPipelineConfigKeys.SEARCH_REQUEST;
        return newState.build();
            .map(ProcessorInfo::new)
        String errorPrefix
                );  
        SearchPipelineMetadata metadata = clusterState.getMetadata().custom(SearchPipelineMetadata.TYPE);
        for (Processor processor : processors) {  
    private static final int MAX_PIPELINE_ID_BYTES = 512;
    }
                pipelineId = searchRequest.pipeline();  
import static org.opensearch.cluster.service.ClusterManagerTask.PUT_SEARCH_PIPELINE;  
                        String.format(Locale.ROOT, "%s [%s] is already registered", errorPrefix, entry.getKey())  
                    namedWriteableRegistry,
    }  
        }
        if (Objects.isNull(config)) {
    private final SystemGeneratedProcessorMetrics systemGeneratedProcessorMetrics = new SystemGeneratedProcessorMetrics();  
import org.opensearch.script.ScriptService;  
            Map<String, F> newFactories = processorLoader.apply(plugin);
                }
            }
            }  
 * The main entry point for search pipelines. Handles CRUD operations and exposes the API to execute search pipelines
            }
        // need deep-copying here.
    }
                                if (NOOP_PIPELINE_ID.equals(pipelineId)) {
                    totalResponseProcessingMetrics,
                ExceptionsHelper.rethrowAndSuppress(exceptions);
            systemGeneratedProcessorMetrics,
                );
    public static final String NOOP_PIPELINE_ID = "_none";
    private final Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessorFactories;  
                    exceptions = new ArrayList<>();
                    totalRequestProcessingMetrics,  
                }
import org.apache.lucene.util.UnicodeUtil;  
            try {
    }
        Map<String, PipelineHolder> existingPipelines = this.pipelines;  
            pipelines = new HashMap<>();
        return responseProcessorFactories;
                @Override
                    deepCopyConfig(searchRequest.source().searchPipelineSource()),
        );
                );
        }
     */
                copy.add(deepCopyConfigValue(item));
            systemGeneratedPhaseResultsProcessorFactories,
        Map<String, Object> copy = new LinkedHashMap<>(config.size());
public class SearchPipelineService implements ClusterStateApplier, ReportingService<SearchPipelineInfo> {
    private final Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessorFactories;
            env,
        return Collections.unmodifiableMap(processorFactories);
            .stream()
            && searchRequest.source().verbosePipeline()
                protected AcknowledgedResponse newResponse(boolean acknowledged) {
                    phaseInjectorProcessorFactories,
        }
            requestProcessorFactories,  
            searchPipelinePlugins,  
                @Override
            searchPipelinePlugins,
                public ClusterState execute(ClusterState currentState) {
    /**
                    return putPipelineTaskKey;
    static List<PipelineConfiguration> innerGetPipelines(SearchPipelineMetadata metadata, String... ids) {  
    }
            new Processor.PipelineContext(Processor.PipelineSource.VALIDATE_PIPELINE)  
        SearchPipelineMetadata newSearchPipelineMetadata = state.getMetadata().custom(SearchPipelineMetadata.TYPE);
 */  
            namedWriteableRegistry,  
    }  
    static ClusterState innerDelete(DeleteSearchPipelineRequest request, ClusterState currentState) {
                exceptions.add(parseException);  
        Map<DiscoveryNode, SearchPipelineInfo> searchPipelineInfos,
            if (NOOP_PIPELINE_ID.equals(pipelineId) == false) {  
        pipelines.put(request.getId(), new PipelineConfiguration(request.getId(), request.getSource(), request.getMediaType()));  
                // ConfigurationUtils.readXxx consume the config by removing keys as they are read, which would
                pipeline = PipelineWithMetrics.create(  
                // Named pipeline specified for the request
        return copy;
        String,  
        if (value instanceof Map) {
    public void putPipeline(
import org.opensearch.core.service.ReportingService;  
    }
                    return innerPut(request, currentState);  
                }  
                }  
            systemGeneratedRequestProcessorFactories,  
                    String message = "Processor type [" + processor.getType() + "] is not installed on node [" + entry.getKey() + "]";
    ) {
            }
        return requestProcessorFactories;
                    request.getId(),
    private static Object deepCopyConfigValue(Object value) {  
        if (toRemove.isEmpty()) {
import java.util.Objects;
package org.opensearch.search.pipeline;
        return result;  
                @Override  
import java.util.Map;  
        this.systemGeneratedResponseProcessorFactories = processorSystemGeneratedFactories(
                for (Map.Entry<String, PipelineConfiguration> entry : metadata.getPipelines().entrySet()) {  
            }  
            }  
    @Override
            searchPipelinePlugins,
                                    break;  
            if (Regex.isSimpleMatchPattern(id)) {
                    return deletePipelineTaskKey;
        Function<SearchPipelinePlugin, Map<String, F>> processorLoader,  
    /**
    public void deletePipeline(DeleteSearchPipelineRequest request, ActionListener<AcknowledgedResponse> listener) throws Exception {
            throw new IllegalStateException("Search pipeline info is empty");  
    public SearchPipelineService(  
    private final Map<String, Processor.Factory<SearchPhaseResultsProcessor>> phaseInjectorProcessorFactories;
        List<SearchPipelinePlugin> searchPipelinePlugins,
        );
                    responseProcessorFactories,  
        if (ids.length == 0) {  
            new AckedClusterStateUpdateTask<>(request, listener) {
import org.opensearch.gateway.GatewayService;  
                    Locale.ROOT,
                    pipelineIdLength  
        List<SearchPipelinePlugin> searchPipelinePlugins,
import org.opensearch.transport.client.Client;  
    ) {
        }
        Map<String, Object> pipelineConfig = XContentHelper.convertToMap(request.getSource(), false, request.getMediaType()).v2();
    public static final Setting<List<String>> ENABLED_SYSTEM_GENERATED_FACTORIES_SETTING = Setting.listSetting(  
        );
                    requestProcessorFactories,  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
                @Override  
import org.opensearch.action.search.DeleteSearchPipelineRequest;
    private void validateProcessors(  
        SearchPipelineStats.Builder builder = new SearchPipelineStats.Builder();  
                newPipelines.put(newConfiguration.getId(), new PipelineHolder(newConfiguration, newPipeline));
        }
        Pipeline pipeline = Pipeline.NO_OP_PIPELINE;  
        SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> systemGeneratedRequestProcessorFactories;
 * SPDX-License-Identifier: Apache-2.0
                    return new AcknowledgedResponse(acknowledged);  
            if (searchRequest.pipeline() != null) {
                    Index[] concreteIndices = indexNameExpressionResolver.concreteIndices(state, searchRequest);
        Map<String, PipelineConfiguration> pipelines;  
                responseProcessorInfoList,
        builder.withSystemGeneratedProcessorMetrics(systemGeneratedProcessorMetrics);  
        return pipelines;
        }
        // Resolve system generated search pipeline
     */
                }
                PipelineWithMetrics newPipeline = PipelineWithMetrics.create(
    }
        Map<String, PipelineConfiguration> pipelines = currentMetadata.getPipelines();  
        validateProcessors(searchPipelineInfos, exceptions, Pipeline.RESPONSE_PROCESSORS_KEY, pipeline.getSearchResponseProcessors());
        SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>> systemGeneratedResponseProcessorFactories;
        SearchPipelineMetadata currentMetadata = currentState.metadata().custom(SearchPipelineMetadata.TYPE);
                    if (Regex.simpleMatch(id, entry.getKey())) {
        s -> s,  
import org.opensearch.action.search.PutSearchPipelineRequest;
        newState.metadata(
    public static final String SEARCH_PIPELINE_ORIGIN = "search_pipeline";  
            }
        // Sanity check: none of them should be system-generated
            responseProcessorFactories,
            PipelineWithMetrics pipeline = pipelineHolder.pipeline;  
            if (previous != null && previous.configuration.equals(newConfiguration)) {
        Pipeline pipeline = PipelineWithMetrics.create(  
        }
        this.systemGeneratedRequestProcessorFactories = processorSystemGeneratedFactories(  
     * Specify the system generated factory type to enable them so that we will try to evaluate if we should use  
            } else {
        SearchRequest searchRequest,
                            }
            new AckedClusterStateUpdateTask<>(request, listener) {  
        } else {  
            if (newPipelines == null) {
            }  
    public void applyClusterState(ClusterChangedEvent event) {  
            p -> p.getSystemGeneratedResponseProcessors(parameters)  
        }
            for (Object item : source) {
        for (Map.Entry<String, PipelineHolder> entry : existingPipelines.entrySet()) {
import org.opensearch.cluster.metadata.Metadata;
                newPipelines = new HashMap<>(existingPipelines);
            new OperationMetrics(),
            request.getId(),
        for (String id : ids) {
            // Preserve insertion order (the parser produces an ordered map) so processor ordering is unchanged.
        PipelineProcessingContext requestContext = new PipelineProcessingContext();  
    ) {
import org.opensearch.ExceptionsHelper;
        final SystemGeneratedPipelineHolder systemGeneratedPipelineHolder = SystemGeneratedPipelineWithMetrics.create(
import org.opensearch.cluster.ClusterState;
import org.opensearch.action.search.SearchRequest;  
    }  
    }  
                throw new SearchPipelineProcessingException(e);  
        );  
    ) throws Exception {
            p -> p.getSystemGeneratedRequestProcessors(parameters)
    @Override  
                .putCustom(SearchPipelineMetadata.TYPE, new SearchPipelineMetadata(pipelines))
                    totalRequestProcessingMetrics,
import java.util.stream.Collectors;  
        NamedWriteableRegistry namedWriteableRegistry,
        } else {
        // or the pipeline configuration has been modified  
    private final OperationMetrics totalResponseProcessingMetrics = new OperationMetrics();
    private final ClusterManagerTaskThrottler.ThrottlingKey deletePipelineTaskKey;  
                Pipeline.RESPONSE_PROCESSORS_KEY,  
                    requestProcessorFactories,
    public ClusterService getClusterService() {  
    // VisibleForTesting
                }
            }  
        return newState.build();
                // Deleting all the empty state is a no-op.  
            p -> p.getSearchPhaseResultsProcessors(parameters)
        ExceptionsHelper.rethrowAndSuppress(exceptions);  
                            Settings indexSettings = indexMetadata.getSettings();
                    newPipeline.copyMetrics(previous.pipeline);
            enabledSystemGeneratedFactories
                                }
        String processorKey,  
        IndexNameExpressionResolver indexNameExpressionResolver
        Environment env,  
    }
import java.util.LinkedHashMap;  
                        }  
            && pipeline.equals(Pipeline.NO_OP_PIPELINE)
                .build()
    void innerUpdatePipelines(SearchPipelineMetadata newSearchPipelineMetadata) {
        // Scalars (String/Number/Boolean/null) are immutable — safe to share. The inline pipeline config is produced  
                    logger.debug("Default pipeline not applied for {}", (Object) searchRequest.indices());  
                    throw new IllegalArgumentException("Pipeline " + pipelineId + " is not defined");  
    }  
        // Iterate over the current active pipelines and check whether they are missing in the pipeline configuration and  
                Pipeline.REQUEST_PROCESSORS_KEY,
                @Override
import java.util.function.Consumer;
                // otherwise drain the request's live searchPipelineSource map. Downstream consumers that read the
        }  
        }
        );  
            config,
            if (Regex.isMatchAllPattern(request.getId())) {
        for (String pipelineKey : pipelines.keySet()) {
     * Recursively deep-copies an inline search-pipeline config map (the nested {@code Map}/{@code List} structure
            if (exceptions != null) {
            .map(ProcessorInfo::new)
/*  
        SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>> systemGeneratedPhaseResultsProcessorFactories;
    private volatile Map<String, PipelineHolder> pipelines = Collections.emptyMap();
                    throw new IllegalArgumentException(
    private static <T extends Processor> Map<String, Processor.Factory<T>> processorFactories(  
    }  
                    new Processor.PipelineContext(Processor.PipelineSource.UPDATE_PIPELINE)
import org.opensearch.core.xcontent.NamedXContentRegistry;
        Setting.Property.Dynamic,
            logger.warn("failed to update search pipelines", e);
                    "Error updating pipeline with id [" + newConfiguration.getId() + "]",
    private final Map<
            newPipelines.remove(key);
import java.util.function.Function;
    Map<String, Processor.Factory<SearchResponseProcessor>> getResponseProcessorFactories() {  
    );  
                    new Processor.PipelineContext(Processor.PipelineSource.SEARCH_REQUEST)  
        String,  
            return currentState;
        List<ProcessorInfo> requestProcessorInfoList = requestProcessorFactories.keySet()
        }
            throw new ResourceNotFoundException("pipeline [{}] is missing", request.getId());  
            }
    Map<String, PipelineHolder> getPipelines() {
    public static final String AD_HOC_PIPELINE_ID = "_ad_hoc_pipeline";
        );  
import org.apache.logging.log4j.Logger;
        return builder.build();
        NamedXContentRegistry namedXContentRegistry,  
        this.threadPool = threadPool;
    public PipelinedRequest resolvePipeline(
            p -> p.getSystemGeneratedSearchPhaseResultsProcessors(parameters)
            .addSettingsUpdateConsumer(ENABLED_SYSTEM_GENERATED_FACTORIES_SETTING, this::setEnabledSystemGeneratedFactories);  
    }
    private final ClusterManagerTaskThrottler.ThrottlingKey putPipelineTaskKey;
    }
            if (newSearchPipelineMetadata.getPipelines().get(entry.getKey()) == null) {  
 *
import org.opensearch.cluster.ClusterChangedEvent;  
    public SearchPipelineInfo info() {
                    for (Index index : concreteIndices) {
                    responseProcessorFactories,
                        if (indexMetadata != null) {
                if (pipeline != null) {
            searchPipelinePlugins,  
        builder.withTotalStats(totalRequestProcessingMetrics, totalResponseProcessingMetrics);
    }
                throw new IllegalArgumentException(
                return currentState;
                // inline pipeline definition later in the request lifecycle (e.g. during coordinator query rewrite)  
                newPipelines.remove(entry.getKey());
            this.pipelines = Collections.unmodifiableMap(newPipelines);  
                    totalResponseProcessingMetrics,
        );
        List<ProcessorInfo> responseProcessorInfoList = responseProcessorFactories.keySet()  
import org.opensearch.common.metrics.OperationMetrics;  
import org.opensearch.ingest.ConfigurationUtils;
        "cluster.search.enabled_system_generated_factories",
            (delay, command) -> threadPool.schedule(command, TimeValue.timeValueMillis(delay), ThreadPool.Names.GENERIC),  
                if (exceptions == null) {  
            if (entry.getValue() instanceof SystemGeneratedProcessor.SystemGeneratedFactory) {
import java.util.HashMap;
        Function<SearchPipelinePlugin, Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<T>>> processorLoader
                if (newPipelines == null) {
        systemGeneratedPipelineHolder.evaluateConflict(pipeline);
        Client client  
            PipelineHolder previous = existingPipelines.get(newConfiguration.getId());  
        Task parentTask,  
            Map.of(  
        for (PipelineHolder pipelineHolder : pipelines.values()) {
    private final ThreadPool threadPool;  
    }  
        List<PipelineConfiguration> result = new ArrayList<>(ids.length);  
        }  
            for (Map.Entry<String, F> entry : newFactories.entrySet()) {  
        final String parentAction = parentTask != null ? parentTask.getAction() : null;  
        this.enabledSystemGeneratedFactories = enabledSystemGeneratedFactories;
                    e  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.index.analysis.AnalysisRegistry;  
        } else if (value instanceof List) {
                }
            } else if (state != null && searchRequest.indices() != null && searchRequest.indices().length != 0) {
        return factories;
            String pipelineId = NOOP_PIPELINE_ID;  
                    result.add(pipeline);
import org.opensearch.index.IndexNotFoundException;
            return;
        }
            scriptService,
        Map<String, F> processorFactories = new HashMap<>();  
        );  
        }
                // must still see the original config. Stored/named pipelines are unaffected because their config is
        config.put(SEARCH_REQUEST, searchRequest);
            threadPool::relativeTimeInMillis,
import org.opensearch.common.regex.Regex;
            this,
    private static final Logger logger = LogManager.getLogger(SearchPipelineService.class);
        for (PipelineConfiguration newConfiguration : newSearchPipelineMetadata.getPipelines().values()) {
            List<Object> copy = new ArrayList<>(source.size());  
    private final List<Consumer<ClusterState>> searchPipelineClusterStateListeners = new CopyOnWriteArrayList<>();
import org.opensearch.index.IndexSettings;
                    "Search Pipeline id [%s] exceeds maximum length of %d UTF-8 bytes (actual: %d bytes)",  
    @SuppressWarnings("unchecked")
            pipelineConfig,
        }
    public static List<PipelineConfiguration> getPipelines(ClusterState clusterState, String... ids) {
import org.opensearch.core.action.ActionListener;  
     * produced by the XContent parser). Needed because pipeline construction consumes the config by removing keys as  
            .stream()
            } catch (Exception e) {  
        return value;  
        validatePipeline(searchPipelineInfos, request);  
import static org.opensearch.plugins.SearchPipelinePlugin.SystemGeneratedSearchPipelineConfigKeys.PARENT_ACTION;
import org.opensearch.plugins.SearchPipelinePlugin;
                                } else if (!pipelineId.equals(currentPipelineId)) {
        // if we didn't ask for _any_ ID, then we get them all (this is the same as if they ask for '*')
    private static <F> Map<String, F> collectProcessorFactories(
    private final NamedWriteableRegistry namedWriteableRegistry;
            innerUpdatePipelines(newSearchPipelineMetadata);
    ) throws Exception {
            "put-search-pipeline-" + request.getId(),
        return innerGetPipelines(metadata, ids);  
import java.util.Set;
import org.opensearch.common.settings.Setting;
            "delete-search-pipeline-" + request.getId(),
        final Map<String, Object> config = new HashMap<>();
import java.util.List;
        config.put(PARENT_ACTION, parentAction);  
                    String.format(Locale.ROOT, "System generated factory [%s] should not be exposed to users.", entry.getKey())  
        ActionListener<AcknowledgedResponse> listener
                    return innerDelete(request, currentState);
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
        if (currentSearchPipelineMetadata != null) {
        ThreadPool threadPool,
        if (currentMetadata == null) {  
                throw new IllegalArgumentException(
            }
        ClusterService clusterService,
            this.pipeline = Objects.requireNonNull(pipeline);  
    static class PipelineHolder {
        return collectProcessorFactories(searchPipelinePlugins, processorLoader, "System generated search processor");  
        );
            return null;
        final Map<String, PipelineConfiguration> newPipelines = new HashMap<>(pipelines);
        for (Map.Entry<String, Processor.Factory<T>> entry : factories.entrySet()) {  
        if (searchPipelineInfos.isEmpty()) {
    public boolean isSystemGeneratedFactoryEnabled(String factoryName) {
    private final OperationMetrics totalRequestProcessingMetrics = new OperationMetrics();
                PipelineConfiguration pipeline = metadata.getPipelines().get(id);  
        searchPipelineClusterStateListeners.forEach(consumer -> consumer.accept(state));  
                continue;
        try {
        return clusterService;
        Map<String, PipelineHolder> newPipelines = null;  
        }
        ClusterState.Builder newState = ClusterState.builder(currentState);  
                    MAX_PIPELINE_ID_BYTES,
            }
    // VisibleForTesting  
                }
    private final ScriptService scriptService;
    static Map<String, Object> deepCopyConfig(Map<String, Object> config) {  
import org.opensearch.cluster.AckedClusterStateUpdateTask;
        Map<String, Processor.Factory<T>> factories = collectProcessorFactories(searchPipelinePlugins, processorLoader, "Search processor");
            && (enabledSystemGeneratedFactories.contains(ALL) || enabledSystemGeneratedFactories.contains(factoryName));  
        setEnabledSystemGeneratedFactories(clusterService.getClusterSettings().get(ENABLED_SYSTEM_GENERATED_FACTORIES_SETTING));
                    namedWriteableRegistry,  
            this.configuration = Objects.requireNonNull(configuration);
                protected AcknowledgedResponse newResponse(boolean acknowledged) {  
 */  
                        IndexMetadata indexMetadata = state.metadata().index(index);  
        this.phaseInjectorProcessorFactories = processorFactories(
}
import org.opensearch.cluster.node.DiscoveryNode;  
                }
import org.opensearch.cluster.metadata.IndexMetadata;  
        } catch (OpenSearchParseException e) {  
                Pipeline.PHASE_PROCESSORS_KEY,
            .map(ProcessorInfo::new)  
                );
        );  
