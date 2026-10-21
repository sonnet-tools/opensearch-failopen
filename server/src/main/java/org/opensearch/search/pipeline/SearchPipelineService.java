        return phaseInjectorProcessorFactories;
            if (Regex.isSimpleMatchPattern(id)) {
        List<ProcessorInfo> requestProcessorInfoList = requestProcessorFactories.keySet()
                );
                @Override
        // Sanity check: none of them should be system-generated
        }
            Metadata.builder(currentState.getMetadata())
import org.opensearch.core.index.Index;
                    AD_HOC_PIPELINE_ID,
                }
                } catch (IndexNotFoundException e) {
                }
 * SPDX-License-Identifier: Apache-2.0
                // must still see the original config. Stored/named pipelines are unaffected because their config is
        this.systemGeneratedPhaseResultsProcessorFactories = processorSystemGeneratedFactories(
 *
            && systemGeneratedPipelineHolder.isNoOp()) {
import java.util.function.Function;
            throw new ResourceNotFoundException("pipeline [{}] is missing", request.getId());
                    Locale.ROOT,
                @Override
                }
            p -> p.getSystemGeneratedResponseProcessors(parameters)
        "cluster.search.enabled_system_generated_factories",
        return new SearchPipelineInfo(
import org.apache.logging.log4j.LogManager;
                protected AcknowledgedResponse newResponse(boolean acknowledged) {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    public static final String ALL = "*";
    private static Object deepCopyConfigValue(Object value) {
                    newPipeline.copyMetrics(previous.pipeline);
                public ClusterState execute(ClusterState currentState) {
    }
            threadPool.getThreadContext(),
                    throw new IllegalArgumentException("Pipeline " + pipelineId + " is not defined");
                    request.getId(),
        }
    }
                    return deletePipelineTaskKey;
                    deepCopyConfig(searchRequest.source().searchPipelineSource()),
    }
                    return new AcknowledgedResponse(acknowledged);
                    MAX_PIPELINE_ID_BYTES,
        if (currentSearchPipelineMetadata != null) {
import org.opensearch.common.unit.TimeValue;
            this.pipelines = Collections.unmodifiableMap(newPipelines);
            "delete-search-pipeline-" + request.getId(),
            .map(ProcessorInfo::new)
            } else {
        );
        for (Map.Entry<String, PipelineHolder> entry : existingPipelines.entrySet()) {
            requestProcessorFactories,
                if (previous != null) {
            }
    private void setEnabledSystemGeneratedFactories(List<String> enabledSystemGeneratedFactories) {
    public SearchPipelineService(
        );
                    responseProcessorFactories,
            for (Map.Entry<DiscoveryNode, SearchPipelineInfo> entry : searchPipelineInfos.entrySet()) {
        validateProcessors(searchPipelineInfos, exceptions, Pipeline.PHASE_PROCESSORS_KEY, pipeline.getSearchPhaseResultsProcessors());
        if (newSearchPipelineMetadata == null) {
import org.opensearch.env.Environment;
        for (Map.Entry<String, Object> entry : config.entrySet()) {
        } else if (value instanceof List) {
 * compatible open source license.
        for (SearchPipelinePlugin plugin : searchPipelinePlugins) {
            && searchRequest.source().verbosePipeline()
     * produced by the XContent parser). Needed because pipeline construction consumes the config by removing keys as
                }
        );
        this.phaseInjectorProcessorFactories = processorFactories(
                        IndexMetadata indexMetadata = state.metadata().index(index);
        }
        }
        Function<SearchPipelinePlugin, Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<T>>> processorLoader
import org.opensearch.plugins.SearchPipelinePlugin;
                PipelineConfiguration pipeline = metadata.getPipelines().get(id);
    void innerUpdatePipelines(SearchPipelineMetadata newSearchPipelineMetadata) {
        SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>> systemGeneratedPhaseResultsProcessorFactories;
            for (Map.Entry<String, F> entry : newFactories.entrySet()) {
                pipelineId = searchRequest.pipeline();
                    String message = "Processor type [" + processor.getType() + "] is not installed on node [" + entry.getKey() + "]";
        deletePipelineTaskKey = clusterService.registerClusterManagerTask(DELETE_SEARCH_PIPELINE, true);
        this.threadPool = threadPool;
                                } else if (!pipelineId.equals(currentPipelineId)) {
import org.opensearch.action.search.PutSearchPipelineRequest;
                ExceptionsHelper.rethrowAndSuppress(exceptions);
                    phaseInjectorProcessorFactories,
import java.util.stream.Collectors;
    }
            pipelines = new HashMap<>(currentSearchPipelineMetadata.getPipelines());
    }
            // Preserve insertion order (the parser produces an ordered map) so processor ordering is unchanged.
    private final ThreadPool threadPool;
    );
                    totalRequestProcessingMetrics,
    private final ClusterManagerTaskThrottler.ThrottlingKey deletePipelineTaskKey;
            }
        NamedWriteableRegistry namedWriteableRegistry,
        ActionListener<AcknowledgedResponse> listener
        pipelines.put(request.getId(), new PipelineConfiguration(request.getId(), request.getSource(), request.getMediaType()));
        final Map<String, PipelineConfiguration> newPipelines = new HashMap<>(pipelines);
            newPipelines.remove(key);
                    newConfiguration.getId(),
                }
                newPipelines.put(newConfiguration.getId(), new PipelineHolder(newConfiguration, newPipeline));
                            }
                            Settings indexSettings = indexMetadata.getSettings();
        }
    private volatile List<String> enabledSystemGeneratedFactories;
                    new Processor.PipelineContext(Processor.PipelineSource.SEARCH_REQUEST)
            }
            }
            }
        );
        }
        SearchPipelineStats.Builder builder = new SearchPipelineStats.Builder();
    }
    }
        Map<DiscoveryNode, SearchPipelineInfo> searchPipelineInfos,
        return requestProcessorFactories;
                );
    }
        ScriptService scriptService,
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
    private volatile Map<String, PipelineHolder> pipelines = Collections.emptyMap();
            systemGeneratedProcessorMetrics,
        this.requestProcessorFactories = processorFactories(searchPipelinePlugins, p -> p.getRequestProcessors(parameters));
                        if (indexMetadata != null) {
            if (NOOP_PIPELINE_ID.equals(pipelineId) == false) {
        List<PipelineConfiguration> result = new ArrayList<>(ids.length);
        for (Map.Entry<String, Processor.Factory<T>> entry : factories.entrySet()) {
        this.clusterService = clusterService;
import static org.opensearch.plugins.SearchPipelinePlugin.SystemGeneratedSearchPipelineConfigKeys.PARENT_ACTION;
                    return innerDelete(request, currentState);
import org.opensearch.cluster.AckedClusterStateUpdateTask;
    /**
        final String parentAction = parentTask != null ? parentTask.getAction() : null;
    private final ClusterService clusterService;
            if (searchRequest.pipeline() != null) {
                if (newPipelines == null) {
            systemGeneratedResponseProcessorFactories,
        }
        for (PipelineHolder pipelineHolder : pipelines.values()) {
        if (Objects.isNull(config)) {
            (delay, command) -> threadPool.schedule(command, TimeValue.timeValueMillis(delay), ThreadPool.Names.GENERIC),
            }
                    phaseInjectorProcessorFactories,
        List<SearchPipelinePlugin> searchPipelinePlugins,
    ) throws Exception {
                .putCustom(SearchPipelineMetadata.TYPE, new SearchPipelineMetadata(pipelines))
    void validatePipeline(Map<DiscoveryNode, SearchPipelineInfo> searchPipelineInfos, PutSearchPipelineRequest request) throws Exception {
 * against requests and responses.
        String,
                throw new IllegalArgumentException(
                    requestProcessorFactories,
    static ClusterState innerPut(PutSearchPipelineRequest request, ClusterState currentState) {
    }
                    result.add(pipeline);
        final SystemGeneratedPipelineHolder systemGeneratedPipelineHolder = SystemGeneratedPipelineWithMetrics.create(
    Map<String, Processor.Factory<SearchRequestProcessor>> getRequestProcessorFactories() {
    private final ScriptService scriptService;
import org.apache.lucene.util.UnicodeUtil;
        }
    private final Map<
import java.util.Map;
        List<ProcessorInfo> responseProcessorInfoList = responseProcessorFactories.keySet()
                throw new SearchPipelineProcessingException(e);
        SearchPipelineMetadata currentMetadata = currentState.metadata().custom(SearchPipelineMetadata.TYPE);
        ExceptionsHelper.rethrowAndSuppress(exceptions);
 */
                );
import java.util.List;
    public boolean isSystemGeneratedFactoryEnabled(String factoryName) {
        if (state.blocks().hasGlobalBlock(GatewayService.STATE_NOT_RECOVERED_BLOCK)) {
        validateProcessors(searchPipelineInfos, exceptions, Pipeline.REQUEST_PROCESSORS_KEY, pipeline.getSearchRequestProcessors());
                // reconstructed fresh from bytes on each PipelineConfiguration.getConfigAsMap() call.
                    new Processor.PipelineContext(Processor.PipelineSource.UPDATE_PIPELINE)
        String,
                                    pipelineId = NOOP_PIPELINE_ID;
        );
        AnalysisRegistry analysisRegistry,
            "put-search-pipeline-" + request.getId(),
        String,
        Map<String, Processor.Factory<T>> factories = collectProcessorFactories(searchPipelinePlugins, processorLoader, "Search processor");
        }
import org.opensearch.cluster.node.DiscoveryNode;
            }
     * it reads them; copying leaves the request's original {@code searchPipelineSource} intact for later readers.
import org.opensearch.ExceptionsHelper;
    static List<PipelineConfiguration> innerGetPipelines(SearchPipelineMetadata metadata, String... ids) {
        }
            if (previous != null && previous.configuration.equals(newConfiguration)) {
        List<Exception> exceptions = new ArrayList<>();
        List<SearchPipelinePlugin> searchPipelinePlugins,
import java.util.HashMap;
    static Map<String, Object> deepCopyConfig(Map<String, Object> config) {
        return enabledSystemGeneratedFactories != null
                    Index[] concreteIndices = indexNameExpressionResolver.concreteIndices(state, searchRequest);
import org.opensearch.index.analysis.AnalysisRegistry;
        final PipelineConfiguration configuration;
                );
            this,
                @Override
        // Scalars (String/Number/Boolean/null) are immutable — safe to share. The inline pipeline config is produced
                    logger.debug("Default pipeline not applied for {}", (Object) searchRequest.indices());
            }
            String pipelineId = NOOP_PIPELINE_ID;
}
            throw new IllegalArgumentException(
    private final NamedWriteableRegistry namedWriteableRegistry;
import org.opensearch.gateway.GatewayService;
            );
            }
        List<ProcessorInfo> phaseProcessorInfoList = phaseInjectorProcessorFactories.keySet()
import org.opensearch.action.search.SearchRequest;
    }
        return collectProcessorFactories(searchPipelinePlugins, processorLoader, "System generated search processor");
import java.util.ArrayList;
            logger.warn("failed to update search pipelines", e);
            pipelineConfig,
        for (String pipelineKey : pipelines.keySet()) {
        for (PipelineConfiguration newConfiguration : newSearchPipelineMetadata.getPipelines().values()) {
        }
            .collect(Collectors.toList());
        return newState.build();
        }
        }
import org.opensearch.cluster.ClusterChangedEvent;
                if (exceptions == null) {
        // if we didn't ask for _any_ ID, then we get them all (this is the same as if they ask for '*')
import static org.opensearch.cluster.service.ClusterManagerTask.DELETE_SEARCH_PIPELINE;
                for (Map.Entry<String, PipelineConfiguration> entry : metadata.getPipelines().entrySet()) {
                @Override
                    "Both named and inline search pipeline were specified. Please only specify one or the other."
        ClusterState.Builder newState = ClusterState.builder(currentState);
import org.opensearch.script.ScriptService;
        );
        if (searchRequest.source() != null
                    String.format(Locale.ROOT, "System generated factory [%s] should not be exposed to users.", entry.getKey())
            env,
            scriptService,
        Map<String, Object> copy = new LinkedHashMap<>(config.size());
            new OperationMetrics(), // Use ephemeral metrics for validation
        List<SearchPipelinePlugin> searchPipelinePlugins,
        }
            if (newSearchPipelineMetadata.getPipelines().get(entry.getKey()) == null) {
        putPipelineTaskKey = clusterService.registerClusterManagerTask(PUT_SEARCH_PIPELINE, true);
        );
import org.opensearch.OpenSearchParseException;
    private final Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessorFactories;
                try {
            Map<String, F> newFactories = processorLoader.apply(plugin);
                        result.add(entry.getValue());
                        }
        NamedXContentRegistry namedXContentRegistry,
            }
import org.opensearch.common.settings.Setting;
            }
        Function<SearchPipelinePlugin, Map<String, F>> processorLoader,
        List<? extends Processor> processors
    private final OperationMetrics totalRequestProcessingMetrics = new OperationMetrics();
    }
        Setting.Property.NodeScope
    private final List<Consumer<ClusterState>> searchPipelineClusterStateListeners = new CopyOnWriteArrayList<>();
    // VisibleForTesting
        }
            try {
    static class PipelineHolder {
            p -> p.getSearchPhaseResultsProcessors(parameters)
        for (Processor processor : processors) {
        Map<String, Object> pipelineConfig = XContentHelper.convertToMap(request.getSource(), false, request.getMediaType()).v2();
                public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
            copy.put(entry.getKey(), deepCopyConfigValue(entry.getValue()));
                exceptions.add(parseException);
        Client client
            this.configuration = Objects.requireNonNull(configuration);
import static org.opensearch.plugins.SearchPipelinePlugin.SystemGeneratedSearchPipelineConfigKeys.SEARCH_REQUEST;
                    "Search Pipeline id [%s] exceeds maximum length of %d UTF-8 bytes (actual: %d bytes)",
                Pipeline.REQUEST_PROCESSORS_KEY,
        this.responseProcessorFactories = processorFactories(searchPipelinePlugins, p -> p.getResponseProcessors(parameters));
import org.opensearch.ResourceNotFoundException;
            new AckedClusterStateUpdateTask<>(request, listener) {
                    for (Index index : concreteIndices) {
                if (entry.getValue().containsProcessor(processorKey, type) == false) {
            } catch (Exception e) {
        Map<String, PipelineConfiguration> pipelines;
        for (String id : ids) {
        SearchRequest searchRequest,
                            if (IndexSettings.DEFAULT_SEARCH_PIPELINE.exists(indexSettings)) {
        newState.metadata(
        }
        List<SearchPipelinePlugin> searchPipelinePlugins,
            try {
                @Override
    private static final int MAX_PIPELINE_ID_BYTES = 512;
        Map<String, PipelineConfiguration> pipelines = currentMetadata.getPipelines();
     * Recursively deep-copies an inline search-pipeline config map (the nested {@code Map}/{@code List} structure
                                    pipelineId = currentPipelineId;
        );
    public static List<PipelineConfiguration> getPipelines(ClusterState clusterState, String... ids) {
import org.opensearch.cluster.service.ClusterService;
            && pipeline.equals(Pipeline.NO_OP_PIPELINE)
        Map<String, F> processorFactories = new HashMap<>();
            return;
            }
        try {
import java.util.Collections;
            new Processor.PipelineContext(Processor.PipelineSource.VALIDATE_PIPELINE)
        ClusterService clusterService,
                    exceptions.add(ConfigurationUtils.newConfigurationException(processor.getType(), processor.getTag(), null, message));
        if (searchPipelineInfos.isEmpty()) {
            .collect(Collectors.toList());
        // need deep-copying here.
            .map(ProcessorInfo::new)
        }
        searchPipelineClusterStateListeners.forEach(consumer -> consumer.accept(state));
        Set<String> toRemove = new HashSet<>();
                // Named pipeline specified for the request
                }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            return copy;
        );
                public ClusterState execute(ClusterState currentState) {
        if (pipelineIdLength > MAX_PIPELINE_ID_BYTES) {
                PipelineHolder pipelineHolder = pipelines.get(pipelineId);
        this.enabledSystemGeneratedFactories = enabledSystemGeneratedFactories;
        return factories;
                // inline pipeline definition later in the request lifecycle (e.g. during coordinator query rewrite)
        Pipeline pipeline = PipelineWithMetrics.create(
        } else {
            namedXContentRegistry
            .stream()
    static ClusterState innerDelete(DeleteSearchPipelineRequest request, ClusterState currentState) {
        Function<SearchPipelinePlugin, Map<String, Processor.Factory<T>>> processorLoader
                phaseProcessorInfoList
            if (Regex.simpleMatch(request.getId(), pipelineKey)) {
    }
    ) {
        newState.metadata(
package org.opensearch.search.pipeline;
import org.opensearch.cluster.ClusterStateApplier;
                }
            phaseInjectorProcessorFactories,
            analysisRegistry,
            .map(ProcessorInfo::new)
import java.util.function.Consumer;
                    totalResponseProcessingMetrics,
import java.util.Objects;
import org.opensearch.common.xcontent.XContentHelper;
        s -> s,
            client,
        builder.withSystemGeneratedProcessorMetrics(systemGeneratedProcessorMetrics);
 * this file be licensed under the Apache-2.0 license or a
            return currentState;
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    pipelineIdLength
        Setting.Property.Dynamic,
    public static final String NOOP_PIPELINE_ID = "_none";
                );
    }
        if (ids.length == 0) {
        SearchPipelineMetadata metadata = clusterState.getMetadata().custom(SearchPipelineMetadata.TYPE);
                                if (NOOP_PIPELINE_ID.equals(pipelineId)) {
        Map<String, PipelineHolder> existingPipelines = this.pipelines;
            if (searchRequest.pipeline() != null) {
            namedWriteableRegistry,
import java.util.concurrent.CopyOnWriteArrayList;
                    newConfiguration.getConfigAsMap(),
        String processorKey,
                    if (Regex.simpleMatch(id, entry.getKey())) {
        SearchPipelinePlugin.Parameters parameters = new SearchPipelinePlugin.Parameters(
        return clusterService;
        PipelineProcessingContext requestContext = new PipelineProcessingContext();
        List<Exception> exceptions,
                )
        validateProcessors(searchPipelineInfos, exceptions, Pipeline.RESPONSE_PROCESSORS_KEY, pipeline.getSearchResponseProcessors());
                }
        if (newPipelines != null) {
            return deepCopyConfig((Map<String, Object>) value);
    }
    private final OperationMetrics totalResponseProcessingMetrics = new OperationMetrics();
            innerUpdatePipelines(newSearchPipelineMetadata);
                    namedWriteableRegistry,
        clusterService.getClusterSettings()
     */
    }
                protected AcknowledgedResponse newResponse(boolean acknowledged) {
            searchPipelinePlugins,
    Map<String, PipelineHolder> getPipelines() {
        SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>> systemGeneratedResponseProcessorFactories;
    private final Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessorFactories;
                if (pipelineHolder == null) {
import java.util.Set;
    public void putPipeline(
            }
        return responseProcessorFactories;
            return;
public class SearchPipelineService implements ClusterStateApplier, ReportingService<SearchPipelineInfo> {
import org.opensearch.cluster.metadata.IndexMetadata;
     * them to generate search processors for the search request. Or can use a wildcard * to enable all.
        PipelineHolder(PipelineConfiguration configuration, PipelineWithMetrics pipeline) {
            new AckedClusterStateUpdateTask<>(request, listener) {
    }
/*
        final PipelineWithMetrics pipeline;
    @Override
                                    break;
            searchPipelinePlugins,
import org.opensearch.index.IndexNotFoundException;
            throw new IllegalArgumentException("The 'verbose pipeline' option requires a search pipeline to be defined.");
            }
                // Deleting all the empty state is a no-op.
    ) {
        clusterService.submitStateUpdateTask(
        if (currentMetadata == null) {
    ) {
            } catch (Exception e) {
            request.getId(),
                OpenSearchParseException parseException = new OpenSearchParseException(
    }
import org.opensearch.core.action.ActionListener;
     * Specify the system generated factory type to enable them so that we will try to evaluate if we should use
        return new PipelinedRequest(pipeline, searchRequest, requestContext, systemGeneratedPipelineHolder);
    ) {
                                String currentPipelineId = IndexSettings.DEFAULT_SEARCH_PIPELINE.get(indexSettings);
                    totalRequestProcessingMetrics,
                copy.add(deepCopyConfigValue(item));
        Pipeline pipeline = Pipeline.NO_OP_PIPELINE;
        }
import static org.opensearch.cluster.service.ClusterManagerTask.PUT_SEARCH_PIPELINE;
            PipelineWithMetrics pipeline = pipelineHolder.pipeline;
 * The OpenSearch Contributors require contributions made to
                if (processorFactories.put(entry.getKey(), entry.getValue()) != null) {
    private static <T extends Processor> Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<T>> processorSystemGeneratedFactories(
            p -> p.getSystemGeneratedRequestProcessors(parameters)
                    );
            config,
        }
    public PipelinedRequest resolvePipeline(
                String type = processor.getType();
        config.put(PARENT_ACTION, parentAction);
                }
        final Map<String, Object> config = new HashMap<>();
    }
import org.opensearch.core.service.ReportingService;
        // by the XContent parser, which only yields Map/List/scalar values (never Set), so no other container types
                    return innerPut(request, currentState);
 */
        if (value instanceof Map) {
    }
    ) {
        Environment env,
                PipelineWithMetrics newPipeline = PipelineWithMetrics.create(
 * @opensearch.internal
import org.opensearch.cluster.ClusterState;
                }
            PipelineHolder previous = existingPipelines.get(newConfiguration.getId());
        return Collections.unmodifiableMap(processorFactories);
            )
            && (enabledSystemGeneratedFactories.contains(ALL) || enabledSystemGeneratedFactories.contains(factoryName));
        if (searchRequest.source() != null && searchRequest.source().searchPipelineSource() != null) {
            searchPipelinePlugins,
        ClusterState.Builder newState = ClusterState.builder(currentState);
                }
    }
                Pipeline.RESPONSE_PROCESSORS_KEY,
    /**
        Map<DiscoveryNode, SearchPipelineInfo> searchPipelineInfos,
        SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> systemGeneratedRequestProcessorFactories;
import org.opensearch.index.IndexSettings;
            throw new IllegalStateException("Search pipeline info is empty");
import org.opensearch.threadpool.ThreadPool;
                // TODO -- replace pipeline with one that throws this exception when we try to use it
        SearchPipelineMetadata currentSearchPipelineMetadata = currentState.metadata().custom(SearchPipelineMetadata.TYPE);
                    newPipelines = new HashMap<>(existingPipelines);
        this.namedWriteableRegistry = namedWriteableRegistry;
            return null;
                    requestProcessorFactories,
        String errorPrefix
            .stream()
                    namedWriteableRegistry,
        );
import org.apache.logging.log4j.Logger;
        IndexNameExpressionResolver indexNameExpressionResolver
            .collect(Collectors.toList());
            return Collections.emptyList();
            enabledSystemGeneratedFactories
            .addSettingsUpdateConsumer(ENABLED_SYSTEM_GENERATED_FACTORIES_SETTING, this::setEnabledSystemGeneratedFactories);
        List.of(),
                toRemove.add(pipelineKey);
        return value;
    private final Map<
            if (newPipelines == null) {
            }
    private static <T extends Processor> Map<String, Processor.Factory<T>> processorFactories(
            }
    private static final Logger logger = LogManager.getLogger(SearchPipelineService.class);
            pipeline.populateStats(builder);
        this.scriptService = scriptService;
                                }
                throw new IllegalArgumentException(
    }
        );
    @Override
            if (Regex.isMatchAllPattern(request.getId())) {
    }
                    totalResponseProcessingMetrics,
            if (entry.getValue() instanceof SystemGeneratedProcessor.SystemGeneratedFactory) {
                }
    public SearchPipelineInfo info() {
    private final Map<String, Processor.Factory<SearchPhaseResultsProcessor>> phaseInjectorProcessorFactories;
        }
            // Pipeline defined in search request (ad hoc pipeline).
            } else if (state != null && searchRequest.indices() != null && searchRequest.indices().length != 0) {
                pipeline = PipelineWithMetrics.create(
        // Iterate over the current active pipelines and check whether they are missing in the pipeline configuration and
                    }
                }
import org.opensearch.tasks.Task;
    @SuppressWarnings("unchecked")
        if (toRemove.isEmpty()) {
        this.systemGeneratedResponseProcessorFactories = processorSystemGeneratedFactories(
            }
                    responseProcessorFactories,
        for (String key : toRemove) {
        return result;
import org.opensearch.cluster.metadata.Metadata;
        ThreadPool threadPool,
import org.opensearch.cluster.service.ClusterManagerTaskThrottler;
    }
            new OperationMetrics(),
            Map.of(
            }
                return currentState;
        setEnabledSystemGeneratedFactories(clusterService.getClusterSettings().get(ENABLED_SYSTEM_GENERATED_FACTORIES_SETTING));
                responseProcessorInfoList,
                    // Check for index default pipeline
    public static final Setting<List<String>> ENABLED_SYSTEM_GENERATED_FACTORIES_SETTING = Setting.listSetting(
            systemGeneratedPhaseResultsProcessorFactories,
    public static final String AD_HOC_PIPELINE_ID = "_ad_hoc_pipeline";
        // if so delete the pipeline from new Pipelines map:
        return builder.build();
        Task parentTask,
import org.opensearch.common.metrics.OperationMetrics;
    private volatile ClusterState state;
    private final SystemGeneratedProcessorMetrics systemGeneratedProcessorMetrics = new SystemGeneratedProcessorMetrics();
    Map<String, Processor.Factory<SearchResponseProcessor>> getResponseProcessorFactories() {
            threadPool.generic()::execute,
    private final Map<
 *
                requestProcessorInfoList,
            this.pipeline = Objects.requireNonNull(pipeline);
        SearchPipelineMetadata newSearchPipelineMetadata = state.getMetadata().custom(SearchPipelineMetadata.TYPE);
    public void applyClusterState(ClusterChangedEvent event) {
        // Iterate over pipeline configurations in metadata and constructs a new pipeline if there is no pipeline
                @Override
    public void deletePipeline(DeleteSearchPipelineRequest request, ActionListener<AcknowledgedResponse> listener) throws Exception {
import java.util.LinkedHashMap;
                }
        return newState.build();
            threadPool::relativeTimeInMillis,
                    exceptions = new ArrayList<>();
                continue;
            pipelines = new HashMap<>();
        this.systemGeneratedRequestProcessorFactories = processorSystemGeneratedFactories(
                newPipelines.remove(entry.getKey());
        // or the pipeline configuration has been modified
    }
        return pipelines;
    Map<String, Processor.Factory<SearchPhaseResultsProcessor>> getSearchPhaseResultsProcessorFactories() {
        systemGeneratedPipelineHolder.evaluateConflict(pipeline);
 * The main entry point for search pipelines. Handles CRUD operations and exposes the API to execute search pipelines
        }
                Pipeline.PHASE_PROCESSORS_KEY,
                }
        Map<String, PipelineHolder> newPipelines = null;
        );
                    "Error updating pipeline with id [" + newConfiguration.getId() + "]",
        // Lazily initialize these variables in order to favour the most likely scenario that there are no pipeline changes:
        builder.withTotalStats(totalRequestProcessingMetrics, totalResponseProcessingMetrics);
    ) throws Exception {
                // otherwise drain the request's live searchPipelineSource map. Downstream consumers that read the
            Metadata.builder(currentState.getMetadata()).putCustom(SearchPipelineMetadata.TYPE, new SearchPipelineMetadata(newPipelines))
            responseProcessorFactories,
            namedWriteableRegistry,
                newPipelines = new HashMap<>(existingPipelines);
        }
                        String.format(Locale.ROOT, "%s [%s] is already registered", errorPrefix, entry.getKey())
        List<OpenSearchParseException> exceptions = null;
    }
    }
    private static <F> Map<String, F> collectProcessorFactories(
    // VisibleForTesting
        }
                pipeline = pipelineHolder.pipeline;
        validatePipeline(searchPipelineInfos, request);
import org.opensearch.common.regex.Regex;
import java.util.Locale;
            .stream()
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        config.put(SEARCH_REQUEST, searchRequest);
        PutSearchPipelineRequest request,
        // Resolve system generated search pipeline
        } catch (OpenSearchParseException e) {
                if (pipeline != null) {
/**
                // ConfigurationUtils.readXxx consume the config by removing keys as they are read, which would
        }
            p -> p.getSystemGeneratedSearchPhaseResultsProcessors(parameters)
    }
        return copy;
import org.opensearch.common.settings.Settings;
import org.opensearch.ingest.ConfigurationUtils;
            List<Object> source = (List<Object>) value;
    // VisibleForTesting
        int pipelineIdLength = UnicodeUtil.calcUTF16toUTF8Length(request.getId(), 0, request.getId().length());
    public ClusterService getClusterService() {
                    return new AcknowledgedResponse(acknowledged);
            if (exceptions != null) {
import org.opensearch.action.search.DeleteSearchPipelineRequest;
                    throw new IllegalArgumentException(
            searchPipelinePlugins,
                String.format(
        state = event.state();
            systemGeneratedRequestProcessorFactories,
                    e
                // Build the ad-hoc pipeline from a DEEP COPY of the inline source map. PipelineWithMetrics.create ->
                    return putPipelineTaskKey;
import org.opensearch.transport.client.Client;
            List<Object> copy = new ArrayList<>(source.size());
        if (metadata == null) {
    private void validateProcessors(
        clusterService.submitStateUpdateTask(
     */
    private final ClusterManagerTaskThrottler.ThrottlingKey putPipelineTaskKey;
        } else {
                .build()
                    }
        }
            return new ArrayList<>(metadata.getPipelines().values());
    public SearchPipelineStats stats() {
    public static final String SEARCH_PIPELINE_ORIGIN = "search_pipeline";
            for (Object item : source) {
        }
        return innerGetPipelines(metadata, ids);
import java.util.HashSet;
