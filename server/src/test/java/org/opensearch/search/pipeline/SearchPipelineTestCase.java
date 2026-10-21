            String tag,
        public boolean shouldGenerate(ProcessorGenerationContext context) {
            String tag,
    @Before
            Collections.emptyMap(),
        }
        public String getType() {
    ) {
                description,
        return createWithProcessors(
        public ExecutionStage getExecutionStage() {
        systemGeneratedResponseProcessors.put("system_scale_score_pre", new SystemGeneratedScaleScorePreFactory());
        @Override
        clusterState = ClusterState.builder(clusterState)
    static class ProcessorSets {
            String description,
        public FakeSystemGeneratedRequestPreProcessor(
                ignoreFailure,
            String tag,
            this.type = type;
        @Override
    static Settings.Builder addAdditionalSettings(Settings additionalSettings) {
            String description,
        public FakeSystemGeneratedResponsePreProcessor(
        Client client = mock(Client.class);
            final float finalScore = config.containsKey("score") ? ((Number) config.remove("score")).floatValue() : 100f;
        }
            return ExecutionStage.PRE_USER_DEFINED;
        }
import static org.mockito.Mockito.when;
            Map.of(
                    Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>>
            Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,
            Map<String, Processor.Factory<SearchPhaseResultsProcessor>> processorFactories,
    static SearchResponse syncTransformResponse(PipelinedRequest pipelinedRequest, SearchResponse searchResponse) throws Exception {
            return new FakeSystemGeneratedResponsePostProcessor(
        systemGeneratedRequestProcessors.put("system_scale_request_size_post", new SystemGeneratedScaleRequestSizePostFactory());
            SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor> {
                ignoreFailure,
        ) throws Exception {
    static class FakeSystemGeneratedSearchPhaseResultsPostProcessor extends FakeSearchPhaseResultsProcessor
        @Override
        }
            String type,
            SearchPhaseContext searchPhaseContext
 *
                }
        public SearchPhaseResultsProcessor create(
                description,
            super(type, tag, description, ignoreFailure, executor);
            super(type, tag, description, ignoreFailure, executor);
            super(type, tag, description, ignoreFailure, executor);
        @Override
        service.applyClusterState(cce);
            String tag,
            clusterService,
            )
    }
                rsp -> rsp.getHits().forEach(h -> h.score(score))
            super(type, tag, description, ignoreFailure, querySearchResultConsumer);
            String type,
import org.opensearch.action.search.SearchPhaseName;
        ) throws Exception {
            SystemGeneratedProcessor {
            String description,
    ) {
        ) {
        PipelinedRequest[] requestBox = new PipelinedRequest[1];
        public FakeSystemGeneratedResponsePostProcessor(
            String tag,
        if (exceptionBox[0] != null) {
    static class FakeSystemGeneratedResponsePostProcessor extends FakeResponseProcessor implements SystemGeneratedProcessor {
    }
                "system_scale_request_size_pre",
        public String getType() {
                tag,
        public ExecutionStage getExecutionStage() {
        );
        @Override
import org.opensearch.cluster.ClusterName;
        /**
            Collections.emptyMap()
            String description,
    static class SystemProcessorSets {
import org.opensearch.cluster.ClusterChangedEvent;
            executor.accept(response);
            responseBox[0] = r;
            this.type = type;
     * Helper to synchronously apply a request pipeline and response pipeline, returning the transformed response.
            boolean ignoreFailure,
        @Override
                    return systemGeneratedRequestProcessors;
import static org.opensearch.search.pipeline.SearchPipelineService.ALL;
        final Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>> response;
            Collections.singletonList(new SearchPipelinePlugin() {
        public FakeSystemGeneratedSearchPhaseResultsPostProcessor(
                    Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>>
            Map<String, Object> config,
    }
        public FakeSystemGeneratedRequestPostProcessor(
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
    }
            String description,
            new HashMap<>();
    static SearchResponse syncExecutePipeline(PipelinedRequest request, SearchResponse response) throws Exception {
        ) {
                rsp -> rsp.getHits().forEach(h -> h.score(h.getScore() * 2))
package org.opensearch.search.pipeline;
        service.getClusterService()
            boolean ignoreFailure,
                    Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>>
    static class FakeSystemGeneratedRequestPostProcessor extends FakeRequestProcessor implements SystemGeneratedProcessor {
        }
            this.phase = phase;
        ) throws Exception {
        responseProcessors.put("fixed_score", (processorFactories, tag, description, ignoreFailure, config, ctx) -> {
            .put(IndexSettings.DEFAULT_SEARCH_PIPELINE.getKey(), "p1")
            return this.type;
            throw exceptionBox[0];
    }
            Collections.emptyMap(),
    }
    IndexNameExpressionResolver indexNameExpressionResolver;
public abstract class SearchPipelineTestCase extends OpenSearchTestCase {
            return context.searchRequest().source().size() < 10;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import java.util.function.Consumer;
            return new FakeResponseProcessor(
        responseListener.onResponse(searchResponse);
            Consumer<SearchResponse> executor
            String description,
            );
            Map<String, Processor.Factory<SearchResponseProcessor>> response,
            String tag,
        @Override
        }
        @Override
                "p1",
            return ExecutionStage.POST_USER_DEFINED;
    static PipelinedRequest syncTransformRequest(PipelinedRequest request) throws Exception {
                    return requestProcessors;
import org.opensearch.common.util.concurrent.ThreadContext;
        @Override
        }
            Map<String, Object> config,
import static org.mockito.Mockito.mock;
        private final Consumer<SearchRequest> executor;
            Consumer<SearchPhaseResult> querySearchResultConsumer
        implements
            );
        }
        }
     */
        }
        Map<String, Processor.Factory<SearchPhaseResultsProcessor>> phaseProcessors,
import org.opensearch.cluster.metadata.IndexMetadata;
                "scale_request_size",
            Consumer<SearchResponse> executor
            super(tag, description, ignoreFailure);
                req -> req.source().size((int) (req.source().size() * 2))
        final Map<String, Processor.Factory<SearchPhaseResultsProcessor>> phase;
        }
            SearchPhaseResults<Result> searchPhaseResult,
                public
            Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>> phase
        return settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            return ExecutionStage.POST_USER_DEFINED;
            String description,
    static class ScaleRequestSizeFactory implements Processor.Factory<SearchRequestProcessor> {
        final Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>> phase;
        public ExecutionStage getExecutionStage() {
        }
    public void setUp() throws Exception {
            Map<String, Object> config,
        public String getType() {
            return true;
         * Gets the type of processor
         * Gets the type of processor
            Map<String, Object> config,
                public Map<String, Processor.Factory<SearchRequestProcessor>> getRequestProcessors(Parameters parameters) {
     */
    static class SystemGeneratedMaxScorePostFactory
import org.opensearch.test.OpenSearchTestCase;
        @Override
        @Override
        @Override
        );
            super(tag, description, ignoreFailure);
                    return systemGeneratedPhaseResultsProcessors;
     */
/*
            null,
            .applySettings(Settings.builder().putList(ENABLED_SYSTEM_GENERATED_FACTORIES_SETTING.getKey(), ALL).build());
        public boolean shouldGenerate(ProcessorGenerationContext context) {
         */
            this.phase = phase;
        @Override
        }
    static class SystemGeneratedScaleScorePostFactory implements SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor> {
        @Override
            Processor.PipelineContext pipelineContext
import org.opensearch.Version;
        }
        public SearchPhaseName getBeforePhase() {
    SearchPipelineService createWithProcessors(
            SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor> {
            Map<String, Processor.Factory<SearchPhaseResultsProcessor>> phase
    }
        @Override
            Processor.PipelineContext pipelineContext
        final Map<String, Processor.Factory<SearchResponseProcessor>> response;
            return new FakeSystemGeneratedResponsePreProcessor(
            return context.searchRequest().source().size() < 10;
        SystemProcessorSets system = buildSystemProcessors();
                req -> req.source().size((int) (req.source().size() * scale))
            List<Result> resultAtomicArray = searchPhaseResult.getAtomicArray().asList();
        }
        }
         */
            String tag,
                }
        private String type;
                querySearchResultConsumer
    }
    }
        private String type;
        final Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> request;
         */
            this.querySearchResultConsumer = querySearchResultConsumer;
            String description,
        return SearchSourceBuilder.searchSource().size(10);
        Exception[] exceptionBox = new Exception[1];
            String tag,
        Exception[] exceptionBox = new Exception[1];
        }
            boolean ignoreFailure,
    }
            boolean ignoreFailure,
            return new FakeSystemGeneratedSearchPhaseResultsPreProcessor(
    static IndexMetadata.Builder indexBuilder(String index, Settings additionalSettings) {
        @Override
        public boolean shouldGenerate(ProcessorGenerationContext context) {
            this.executor = executor;
        return requestBox[0];
            );
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>> systemGeneratedResponseProcessors,
            .metadata(Metadata.builder().put(indexMetadata, false).putCustom(SearchPipelineMetadata.TYPE, metadata))
        SystemProcessorSets(
    static IndexMetadata.Builder indexBuilder(String index) {
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();
                    "p1",
        public SearchRequestProcessor create(
                ignoreFailure,
            executor.accept(request);
            this.type = type;
            Processor.PipelineContext pipelineContext
            .getClusterSettings()
import org.opensearch.cluster.metadata.Metadata;
        }
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
    /**
                @Override
        }
    static class SystemGeneratedScaleRequestSizePreFactory
    }
        public SearchRequestProcessor create(
                @Override
            float scale = ((Number) config.remove("scale")).floatValue();
                    getSystemGeneratedResponseProcessors(Parameters parameters) {
     * Helper to synchronously apply a response pipeline, returning the transformed response.
            return SearchPhaseName.FETCH;
import org.opensearch.index.IndexSettings;
                ignoreFailure,
            boolean ignoreFailure,
            String description,
            this.executor = executor;
    static class FakeSystemGeneratedRequestPreProcessor extends FakeRequestProcessor implements SystemGeneratedProcessor {
            SystemGeneratedProcessor {
                tag,
        ) throws Exception {
                    getSystemGeneratedSearchPhaseResultsProcessors(Parameters parameters) {
        private final String type;
    static class SystemGeneratedScaleScorePreFactory implements SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor> {
                description,
                tag,
        private Consumer<SearchPhaseResult> querySearchResultConsumer;
import org.opensearch.search.SearchPhaseResult;
        });
            String description,
 */
            super(type, tag, description, ignoreFailure, querySearchResultConsumer);
        @Override
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),
        public SearchRequestProcessor create(
import java.util.HashMap;
            return true;
        public ExecutionStage getExecutionStage() {
        }
        ClusterChangedEvent cce = new ClusterChangedEvent("", clusterState, previousState);
            super(type, tag, description, ignoreFailure, executor);
            return new FakeRequestProcessor(
        Map<String, Processor.Factory<SearchPhaseResultsProcessor>> searchPhaseProcessors = new HashMap<>();
        ProcessorSets(
    }
        @Override
        if (exceptionBox[0] != null) {
        return syncTransformResponse(syncTransformRequest(request), response);
        /*
            new HashMap<>();
        systemGeneratedRequestProcessors.put("system_scale_request_size_pre", new SystemGeneratedScaleRequestSizePreFactory());
    SystemProcessorSets buildSystemProcessors() {
        requestProcessors.put("scale_request_size", new ScaleRequestSizeFactory());
            Processor.PipelineContext pipelineContext
        public SearchResponseProcessor create(
            this.writableRegistry(),
                    getSystemGeneratedRequestProcessors(Parameters parameters) {
            Map<String, Processor.Factory<SearchPhaseResultsProcessor>> processorFactories,
            final Consumer<SearchPhaseResult> querySearchResultConsumer = (result) -> result.queryResult().topDocs().maxScore = finalScore;
        implements
            String type,
            Consumer<SearchRequest> executor
        public boolean shouldGenerate(ProcessorGenerationContext context) {
    static class FakeSearchPhaseResultsProcessor extends AbstractProcessor implements SearchPhaseResultsProcessor {
}
            Map<String, Processor.Factory<SearchResponseProcessor>> processorFactories,
            Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,
            String type,
        public SearchPhaseName getAfterPhase() {
        }
            String tag,
    SearchSourceBuilder createDefaultSearchSourceBuilder() {
                tag,
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
        public SearchPhaseResultsProcessor create(
            String type,
                "system_max_score_pre",
        return createWithProcessors(base.request, base.response, base.phase, system.request, system.response, system.phase);
            super(tag, description, ignoreFailure);
        return new SearchPipelineServiceTests.ProcessorSets(requestProcessors, responseProcessors, searchPhaseProcessors);
            Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> request,
        public FakeSystemGeneratedSearchPhaseResultsPreProcessor(
        @Override
    static class FakeResponseProcessor extends AbstractProcessor implements SearchResponseProcessor {
        ThreadPool threadPool = mock(ThreadPool.class);
            requestProcessors,
        @Override
import static org.mockito.ArgumentMatchers.anyString;
        ) {
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessors,
import org.opensearch.action.search.SearchPhaseContext;
    static class SystemGeneratedScaleRequestSizePostFactory
                ignoreFailure,
    }
        /**
                req -> req.source().size((int) (req.source().size() * 3))
            return true;
        @Override
        implements
        }
        }
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
            String description,
            threadPool,
            .put(additionalSettings);
import org.opensearch.core.action.ActionListener;
        );
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessors = new HashMap<>();
            String tag,
        ) {
                    return phaseProcessors;
            Map<String, Object> config,
            return true;
        when(threadPool.generic()).thenReturn(executorService);
    static class FakeSystemGeneratedSearchPhaseResultsPreProcessor extends FakeSearchPhaseResultsProcessor
        }
    SearchPipelineService createWithSystemGeneratedProcessors() {
        systemGeneratedPhaseProcessors.put("system_max_score_post", new SystemGeneratedMaxScorePostFactory());
        ) {
            client
            // updating the maxScore
    static class SystemGeneratedMaxScorePreFactory implements SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor> {
        ClusterService clusterService = mock(ClusterService.class);
    }
            String tag,
            String type,
            responseProcessors,
                "system_max_score_post",
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            return new FakeSystemGeneratedRequestPreProcessor(
            Processor.PipelineContext pipelineContext
        }
        @Override
                "fixed_score",
        ) {
        }
        }
    SearchPipelineService createWithProcessors(
        ) {
            Consumer<SearchPhaseResult> querySearchResultConsumer
                description,
                public Map<String, Processor.Factory<SearchResponseProcessor>> getResponseProcessors(Parameters parameters) {
                "system_scale_score_post",
    }
                ignoreFailure,
            Processor.PipelineContext pipelineContext
import org.junit.Before;
                ignoreFailure,
                }
            return new FakeSystemGeneratedRequestPostProcessor(
            .build();
        implements
        return new SystemProcessorSets(systemGeneratedRequestProcessors, systemGeneratedResponseProcessors, systemGeneratedPhaseProcessors);
        }
        public SearchResponseProcessor create(
        indexNameExpressionResolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
        Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessors = new HashMap<>();
        }
         * Gets the type of processor
            String description,
        }
import org.opensearch.cluster.service.ClusterService;
                querySearchResultConsumer
    }
import org.opensearch.action.search.SearchPhaseResults;
            String tag,
import static org.opensearch.search.pipeline.SearchPipelineService.ENABLED_SYSTEM_GENERATED_FACTORIES_SETTING;
            String type,
                )
            Map<String, Object> config,
                description,
        ) {
                tag,
            null,
            boolean ignoreFailure,
        }
        private final Consumer<SearchResponse> executor;
                description,
                rsp -> rsp.getHits().forEach(h -> h.score(h.getScore() * 2))
            boolean ignoreFailure,
        public FakeRequestProcessor(String type, String tag, String description, boolean ignoreFailure, Consumer<SearchRequest> executor) {
    }
        public <Result extends SearchPhaseResult> void process(
            this.request = request;
                @Override
            boolean ignoreFailure,
                public
            final Consumer<SearchPhaseResult> querySearchResultConsumer = (result) -> result.queryResult().topDocs().maxScore = 100f;
    }
            return response;
            this.response = response;
    }
    /**
            boolean ignoreFailure,
            return request;
    }
            Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
        }, e -> { exceptionBox[0] = e; }));
    static class FakeSystemGeneratedResponsePreProcessor extends FakeResponseProcessor implements SystemGeneratedProcessor {
    }
            throw exceptionBox[0];
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)
            this.request = request;
        Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessors,
        systemGeneratedPhaseProcessors.put("system_max_score_pre", new SystemGeneratedMaxScorePreFactory());
                tag,
        }
                @Override
        @Override
        IndexMetadata indexMetadata = new IndexMetadata.Builder("my_index").settings(defaultPipelineSetting).build();
            String description,
                "system_scale_score_pre",
    }
            String tag,
        request.transformRequest(ActionListener.wrap(r -> requestBox[0] = (PipelinedRequest) r, e -> exceptionBox[0] = e));
        Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessors,
        ) {
        }
            boolean ignoreFailure,
        }
    ProcessorSets buildBaseProcessors() {
        ) {
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to
            Map<String, Processor.Factory<SearchRequestProcessor>> request,
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>> systemGeneratedPhaseProcessors =
     * Helper to synchronously apply a request pipeline, returning the transformed request.
                    MediaTypeRegistry.JSON
import org.opensearch.transport.client.Client;
        ProcessorSets base = buildBaseProcessors();
            String description,
        public SearchResponse processResponse(SearchRequest request, SearchResponse response) throws Exception {
    }
                "system_scale_request_size_post",
            return SearchPhaseName.QUERY;
        });
            return ExecutionStage.PRE_USER_DEFINED;
        public boolean shouldGenerate(ProcessorGenerationContext context) {
    }
import org.opensearch.common.settings.Settings;
        }
        }
import org.opensearch.search.builder.SearchSourceBuilder;
            float score = ((Number) config.remove("score")).floatValue();
        @Override
                tag,
            );
import java.util.concurrent.ExecutorService;
    void setUpForResolvePipeline(SearchPipelineService service) throws Exception {
import org.opensearch.action.search.SearchRequest;
        public SearchRequest processRequest(SearchRequest request) throws Exception {
        ActionListener<SearchResponse> responseListener = pipelinedRequest.transformResponseListener(ActionListener.wrap(r -> {
            );
        );
            Consumer<SearchPhaseResult> querySearchResultConsumer
            Consumer<SearchResponse> executor
        ) throws Exception {
                }
import org.opensearch.core.xcontent.MediaTypeRegistry;
                description,
        public ExecutionStage getExecutionStage() {
        }
            boolean ignoreFailure,
        return responseBox[0];
        when(threadPool.executor(anyString())).thenReturn(executorService);
            }),
    SearchPipelineService createWithProcessors() {
            Processor.PipelineContext pipelineContext
            );
                description,
import java.util.Map;
        return IndexMetadata.builder(index).settings(addAdditionalSettings(additionalSettings));
 * this file be licensed under the Apache-2.0 license or a
    }
            boolean ignoreFailure,
import org.opensearch.common.settings.ClusterSettings;
        public FakeResponseProcessor(
                    return responseProcessors;
            new HashMap<>();
            final Consumer<SearchPhaseResult> querySearchResultConsumer = (result) -> result.queryResult().topDocs().maxScore *= 2;
        @Override
    }
    }
import org.opensearch.action.search.SearchResponse;
        Settings defaultPipelineSetting = Settings.builder()
        ProcessorSets base = buildBaseProcessors();
            return ExecutionStage.PRE_USER_DEFINED;
                tag,
        return new SearchPipelineService(
            null,
            );
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>> systemGeneratedPhaseResultsProcessors
    static class FakeRequestProcessor extends AbstractProcessor implements SearchRequestProcessor {
import java.util.Collections;
        public FakeSearchPhaseResultsProcessor(
            );
import java.util.List;
    }
                ignoreFailure,
        ExecutorService executorService = OpenSearchExecutors.newDirectExecutorService();
            String tag,
        ClusterState previousState = clusterState;
            Map<String, Object> config,
        when(clusterService.getClusterSettings()).thenReturn(
    }
        return createWithProcessors(base.request, base.response, base.phase);
    void enabledAllSystemGeneratedFactories(SearchPipelineService service) {
            String type,
import org.opensearch.threadpool.ThreadPool;
        @Override
        ) {
import org.opensearch.plugins.SearchPipelinePlugin;
        }
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessors,
                public Map<String, Processor.Factory<SearchPhaseResultsProcessor>> getSearchPhaseResultsProcessors(Parameters parameters) {
 * SPDX-License-Identifier: Apache-2.0
            return new FakeSystemGeneratedSearchPhaseResultsPostProcessor(
                new PipelineConfiguration(
            return null;
        public ExecutionStage getExecutionStage() {
                }
            null,
    /**
        Map<String, Processor.Factory<SearchPhaseResultsProcessor>> phaseProcessors
            return new FakeSearchPhaseResultsProcessor("max_score", tag, description, ignoreFailure, querySearchResultConsumer);
import org.opensearch.cluster.ClusterState;
        }
            this.response = response;
        ) throws Exception {
    }
            SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor> {
        systemGeneratedResponseProcessors.put("system_scale_score_post", new SystemGeneratedScaleScorePostFactory());
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> systemGeneratedRequestProcessors =
        final Map<String, Processor.Factory<SearchRequestProcessor>> request;
                @Override
    }
    }
            boolean ignoreFailure,
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>> systemGeneratedResponseProcessors =
        return indexBuilder(index, Settings.EMPTY);
            phaseProcessors,
            .build();
            boolean ignoreFailure,
            Consumer<SearchRequest> executor
            return this.type;
            String tag,
        super.setUp();
        SearchResponse[] responseBox = new SearchResponse[1];
                public
        public boolean shouldGenerate(ProcessorGenerationContext context) {
            return this.type;
    }
        @Override
        ) throws Exception {
            resultAtomicArray.forEach(querySearchResultConsumer);
            String description,
                }
        searchPhaseProcessors.put("max_score", (processorFactories, tag, description, ignoreFailure, config, context) -> {
                    return systemGeneratedResponseProcessors;
    }
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> systemGeneratedRequestProcessors,
        implements
                @Override
            boolean ignoreFailure,
import org.opensearch.core.common.bytes.BytesArray;
            Map<String, Processor.Factory<SearchResponseProcessor>> processorFactories,
        }
            Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>> response,
