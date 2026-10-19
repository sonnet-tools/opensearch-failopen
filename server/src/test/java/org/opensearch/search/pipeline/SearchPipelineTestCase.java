            super(type, tag, description, ignoreFailure, executor);
    }
        ) {  
        searchPhaseProcessors.put("max_score", (processorFactories, tag, description, ignoreFailure, config, context) -> {  
        ProcessorSets(  
                description,  
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessors,
            String type,  
        final Map<String, Processor.Factory<SearchResponseProcessor>> response;  
            String description,  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
            executor.accept(request);
    }
                description,
        implements
        }
                tag,
                ignoreFailure,
        return new SystemProcessorSets(systemGeneratedRequestProcessors, systemGeneratedResponseProcessors, systemGeneratedPhaseProcessors);
        Exception[] exceptionBox = new Exception[1];
            requestProcessors,
            Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>> phase
            Processor.PipelineContext pipelineContext
        return requestBox[0];  
            Collections.emptyMap()  
            Map<String, Object> config,  
            threadPool,
            String type,
        @Override  
                ignoreFailure,
            SearchPhaseResults<Result> searchPhaseResult,
            Processor.PipelineContext pipelineContext
            executor.accept(response);  
            return new FakeSystemGeneratedRequestPostProcessor(  
                    Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>>
        @Override  
        public ExecutionStage getExecutionStage() {
        ) throws Exception {  
            String description,
            Map<String, Processor.Factory<SearchResponseProcessor>> processorFactories,
        public SearchPhaseResultsProcessor create(  
        IndexMetadata indexMetadata = new IndexMetadata.Builder("my_index").settings(defaultPipelineSetting).build();
    static class SystemGeneratedScaleRequestSizePostFactory  
                    getSystemGeneratedResponseProcessors(Parameters parameters) {  
    public void setUp() throws Exception {
            boolean ignoreFailure,
    }
    }
        if (exceptionBox[0] != null) {
                @Override
        @Override  
        return createWithProcessors(base.request, base.response, base.phase);  
import org.opensearch.search.SearchPhaseResult;
        Exception[] exceptionBox = new Exception[1];  
        Map<String, Processor.Factory<SearchPhaseResultsProcessor>> phaseProcessors
                description,  
            return ExecutionStage.PRE_USER_DEFINED;
            String description,
import org.opensearch.search.builder.SearchSourceBuilder;  
        return IndexMetadata.builder(index).settings(addAdditionalSettings(additionalSettings));  
            Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,
    static PipelinedRequest syncTransformRequest(PipelinedRequest request) throws Exception {
                querySearchResultConsumer
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>> systemGeneratedResponseProcessors =
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> systemGeneratedRequestProcessors,
            null,  
import org.opensearch.action.search.SearchPhaseName;  
import static org.mockito.Mockito.when;
            String description,  
import static org.mockito.ArgumentMatchers.anyString;  
        return SearchSourceBuilder.searchSource().size(10);
        }  
        public ExecutionStage getExecutionStage() {  
            Map<String, Processor.Factory<SearchPhaseResultsProcessor>> processorFactories,
                @Override
            boolean ignoreFailure,
            Consumer<SearchRequest> executor  
import org.opensearch.cluster.ClusterState;  
            String tag,  
        ) {
            client  
import org.opensearch.index.IndexSettings;  
        final Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>> phase;
        public SearchResponseProcessor create(  
        }
import org.junit.Before;
            Map<String, Object> config,  
            final Consumer<SearchPhaseResult> querySearchResultConsumer = (result) -> result.queryResult().topDocs().maxScore = finalScore;
        );
        });  
            clusterService,
        systemGeneratedResponseProcessors.put("system_scale_score_pre", new SystemGeneratedScaleScorePreFactory());  
            return true;  
                    "p1",
    static IndexMetadata.Builder indexBuilder(String index, Settings additionalSettings) {
        public String getType() {
        }
            throw exceptionBox[0];
            return ExecutionStage.PRE_USER_DEFINED;
        ) throws Exception {
            String tag,  
        public FakeSystemGeneratedRequestPostProcessor(
            )  
            return SearchPhaseName.QUERY;
        }  
            Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> request,
            String description,  
        @Override  
                }  
                description,
        when(clusterService.getClusterSettings()).thenReturn(  
        return new SearchPipelineServiceTests.ProcessorSets(requestProcessors, responseProcessors, searchPhaseProcessors);  
            return new FakeSystemGeneratedSearchPhaseResultsPostProcessor(
    }
        return new SearchPipelineService(  
        }  
        systemGeneratedRequestProcessors.put("system_scale_request_size_pre", new SystemGeneratedScaleRequestSizePreFactory());
    }
        systemGeneratedPhaseProcessors.put("system_max_score_post", new SystemGeneratedMaxScorePostFactory());  
    }  
            return new FakeSystemGeneratedSearchPhaseResultsPreProcessor(  
            String tag,  
import java.util.function.Consumer;
            boolean ignoreFailure,
    ) {
    static class SystemProcessorSets {
            Consumer<SearchResponse> executor
                "system_max_score_pre",
        }
    @Before
                req -> req.source().size((int) (req.source().size() * 3))
    static Settings.Builder addAdditionalSettings(Settings additionalSettings) {  
        ExecutorService executorService = OpenSearchExecutors.newDirectExecutorService();
            this.type = type;
            return context.searchRequest().source().size() < 10;
            this.executor = executor;
        }  
        Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessors,  
        }  
            final Consumer<SearchPhaseResult> querySearchResultConsumer = (result) -> result.queryResult().topDocs().maxScore *= 2;  
                ignoreFailure,  
    /**  
    static class FakeSystemGeneratedRequestPreProcessor extends FakeRequestProcessor implements SystemGeneratedProcessor {  
            .metadata(Metadata.builder().put(indexMetadata, false).putCustom(SearchPipelineMetadata.TYPE, metadata))  
            return this.type;  
        public FakeSystemGeneratedSearchPhaseResultsPreProcessor(
        }
        final Map<String, Processor.Factory<SearchPhaseResultsProcessor>> phase;
            SearchPhaseContext searchPhaseContext
            Consumer<SearchPhaseResult> querySearchResultConsumer
                "system_scale_request_size_pre",
import org.opensearch.cluster.service.ClusterService;
    static class FakeSystemGeneratedSearchPhaseResultsPreProcessor extends FakeSearchPhaseResultsProcessor
 * compatible open source license.
            this.response = response;
package org.opensearch.search.pipeline;
        }
            null,
                }  
        }
            String description,
        indexNameExpressionResolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));
        ClusterService clusterService = mock(ClusterService.class);
            return new FakeSystemGeneratedResponsePostProcessor(
        ) throws Exception {
    static class ProcessorSets {
            Consumer<SearchPhaseResult> querySearchResultConsumer
        }
            .applySettings(Settings.builder().putList(ENABLED_SYSTEM_GENERATED_FACTORIES_SETTING.getKey(), ALL).build());
            );  
import org.opensearch.transport.client.Client;  
    }  
                    return phaseProcessors;  
public abstract class SearchPipelineTestCase extends OpenSearchTestCase {
            this.writableRegistry(),
        implements
import org.opensearch.Version;
        @Override
            super(type, tag, description, ignoreFailure, executor);
import org.opensearch.core.xcontent.MediaTypeRegistry;
                public
                ignoreFailure,
            );
        }
                tag,  
    /**
        @Override
import static org.opensearch.search.pipeline.SearchPipelineService.ALL;
            null,  
    }  
        ) {
import java.util.Collections;  
        public SearchRequestProcessor create(
         */
        }
        @Override  
                ignoreFailure,
        public boolean shouldGenerate(ProcessorGenerationContext context) {
        }
            String description,
    }  
            new HashMap<>();
                    Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>>  
                public
            boolean ignoreFailure,
            Processor.PipelineContext pipelineContext  
            return context.searchRequest().source().size() < 10;
        @Override
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessors = new HashMap<>();
            String description,
        @Override
                    MediaTypeRegistry.JSON
                tag,
        public FakeSearchPhaseResultsProcessor(
    static class FakeResponseProcessor extends AbstractProcessor implements SearchResponseProcessor {  
                rsp -> rsp.getHits().forEach(h -> h.score(score))
        }  
        return responseBox[0];
         */  
        /**
            this.request = request;  
                    return systemGeneratedPhaseResultsProcessors;  
        @Override
            float score = ((Number) config.remove("score")).floatValue();
            .getClusterSettings()
        ) {
            );
    }
                "scale_request_size",
        return createWithProcessors(base.request, base.response, base.phase, system.request, system.response, system.phase);
    static class FakeSearchPhaseResultsProcessor extends AbstractProcessor implements SearchPhaseResultsProcessor {  
 * SPDX-License-Identifier: Apache-2.0
        systemGeneratedRequestProcessors.put("system_scale_request_size_post", new SystemGeneratedScaleRequestSizePostFactory());
            float scale = ((Number) config.remove("scale")).floatValue();
/*  
                    return requestProcessors;
        public ExecutionStage getExecutionStage() {  
            boolean ignoreFailure,
        @Override
    static class FakeSystemGeneratedResponsePostProcessor extends FakeResponseProcessor implements SystemGeneratedProcessor {
import org.opensearch.common.util.concurrent.ThreadContext;
    }  
            String type,
                public Map<String, Processor.Factory<SearchRequestProcessor>> getRequestProcessors(Parameters parameters) {
            String tag,
            return ExecutionStage.POST_USER_DEFINED;
            resultAtomicArray.forEach(querySearchResultConsumer);  
            return SearchPhaseName.FETCH;
            String tag,  
                "p1",  
        );
import org.opensearch.plugins.SearchPipelinePlugin;
        ) {
    static class FakeSystemGeneratedSearchPhaseResultsPostProcessor extends FakeSearchPhaseResultsProcessor
        responseProcessors.put("fixed_score", (processorFactories, tag, description, ignoreFailure, config, ctx) -> {  
            Map<String, Object> config,  
     */
    }
            super(type, tag, description, ignoreFailure, querySearchResultConsumer);  
        PipelinedRequest[] requestBox = new PipelinedRequest[1];
     */  
        final Map<String, Processor.Factory<SearchRequestProcessor>> request;
    }
            return new FakeSearchPhaseResultsProcessor("max_score", tag, description, ignoreFailure, querySearchResultConsumer);  
        public ExecutionStage getExecutionStage() {
                description,
            Consumer<SearchResponse> executor  
                ignoreFailure,  
    }
    }
        private final String type;
                "system_max_score_post",
        @Override
    ) {
        when(threadPool.generic()).thenReturn(executorService);  
            null,
        Settings defaultPipelineSetting = Settings.builder()
            String description,
        ) {
    SearchPipelineService createWithProcessors() {
            String tag,
        super.setUp();  
        }
        @Override
            boolean ignoreFailure,  
            Processor.PipelineContext pipelineContext
        ) throws Exception {
     */
            boolean ignoreFailure,
            return new FakeSystemGeneratedResponsePreProcessor(
    static IndexMetadata.Builder indexBuilder(String index) {
            Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>> response,  
                description,  
import org.opensearch.action.search.SearchPhaseContext;
            String tag,
        service.getClusterService()  
                "system_scale_score_pre",  
            this.response = response;  
        Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessors,  
        public SearchPhaseName getBeforePhase() {
    }
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>> systemGeneratedPhaseResultsProcessors
                @Override
        }  
                    return systemGeneratedRequestProcessors;
        }
                tag,
            Consumer<SearchResponse> executor  
        request.transformRequest(ActionListener.wrap(r -> requestBox[0] = (PipelinedRequest) r, e -> exceptionBox[0] = e));
        @Override
            );
        public ExecutionStage getExecutionStage() {
        }  
            String tag,
import java.util.concurrent.ExecutorService;
            boolean ignoreFailure,
        requestProcessors.put("scale_request_size", new ScaleRequestSizeFactory());  
        when(threadPool.executor(anyString())).thenReturn(executorService);
         * Gets the type of processor
                public Map<String, Processor.Factory<SearchPhaseResultsProcessor>> getSearchPhaseResultsProcessors(Parameters parameters) {
            Processor.PipelineContext pipelineContext  
        public boolean shouldGenerate(ProcessorGenerationContext context) {
            return new FakeResponseProcessor(
    }
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.cluster.metadata.IndexMetadata;
        ) throws Exception {
        ) throws Exception {
        if (exceptionBox[0] != null) {  
        @Override
        public boolean shouldGenerate(ProcessorGenerationContext context) {
                description,
                description,  
import org.opensearch.core.common.bytes.BytesArray;
                @Override
    }
    void enabledAllSystemGeneratedFactories(SearchPipelineService service) {
            boolean ignoreFailure,  
    }
            Map<String, Processor.Factory<SearchPhaseResultsProcessor>> processorFactories,
                public  
        public FakeSystemGeneratedResponsePostProcessor(
 *
            .put(additionalSettings);  
        }  
            String description,  
            SystemGeneratedProcessor {  
            // updating the maxScore
        public SearchPhaseResultsProcessor create(
            Map<String, Object> config,
                querySearchResultConsumer  
        ClusterChangedEvent cce = new ClusterChangedEvent("", clusterState, previousState);  
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessors,
            final Consumer<SearchPhaseResult> querySearchResultConsumer = (result) -> result.queryResult().topDocs().maxScore = 100f;
            Processor.PipelineContext pipelineContext
                ignoreFailure,
            String description,
                req -> req.source().size((int) (req.source().size() * scale))
            Consumer<SearchRequest> executor  
        Map<String, Processor.Factory<SearchPhaseResultsProcessor>> searchPhaseProcessors = new HashMap<>();
            );  
            String type,
        @Override  
            this.phase = phase;
            String tag,
            List<Result> resultAtomicArray = searchPhaseResult.getAtomicArray().asList();
            boolean ignoreFailure,
            .put(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.getKey(), 0)
        public SearchResponse processResponse(SearchRequest request, SearchResponse response) throws Exception {
        @Override  
            .build();
            this.executor = executor;  
        @Override
            boolean ignoreFailure,
import org.opensearch.action.search.SearchPhaseResults;
            String type,
            String description,
            return new FakeRequestProcessor(  
import org.opensearch.common.settings.Settings;  
        public SearchPhaseName getAfterPhase() {  
            this.request = request;
    static SearchResponse syncExecutePipeline(PipelinedRequest request, SearchResponse response) throws Exception {  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)
        return createWithProcessors(  
    static class ScaleRequestSizeFactory implements Processor.Factory<SearchRequestProcessor> {  
    }
                tag,
                tag,  
            String tag,
        return syncTransformResponse(syncTransformRequest(request), response);
                }
    }
            boolean ignoreFailure,
            return true;
        });
        systemGeneratedResponseProcessors.put("system_scale_score_post", new SystemGeneratedScaleScorePostFactory());
        ) {
            }),
         */  
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> systemGeneratedRequestProcessors =
import java.util.List;
import org.opensearch.action.search.SearchRequest;
            return response;
                "system_scale_score_post",
            String tag,  
                "fixed_score",  
            Collections.singletonList(new SearchPipelinePlugin() {
import static org.opensearch.search.pipeline.SearchPipelineService.ENABLED_SYSTEM_GENERATED_FACTORIES_SETTING;
            return null;
                @Override  
                tag,
        ) {
    SearchPipelineService createWithProcessors(
            SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor> {
        Map<String, Processor.Factory<SearchPhaseResultsProcessor>> phaseProcessors,
    static class SystemGeneratedMaxScorePreFactory implements SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor> {
        @Override  
            String type,  
        implements
        SearchResponse[] responseBox = new SearchResponse[1];  
    SearchPipelineService createWithSystemGeneratedProcessors() {  
        responseListener.onResponse(searchResponse);
            SystemGeneratedProcessor {  
            SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor> {
                    return systemGeneratedResponseProcessors;
        private final Consumer<SearchRequest> executor;
        SystemProcessorSets(
        private final Consumer<SearchResponse> executor;
import org.opensearch.test.OpenSearchTestCase;
            Map<String, Object> config,
            Map<String, Processor.Factory<SearchPhaseResultsProcessor>> phase  
    static class SystemGeneratedScaleScorePostFactory implements SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor> {
        }
        public FakeSystemGeneratedResponsePreProcessor(  
        /*  
            String tag,  
        public SearchResponseProcessor create(
            responseProcessors,
        ProcessorSets base = buildBaseProcessors();
        }
        }
            );  
    }  
import org.opensearch.common.settings.ClusterSettings;
        public SearchRequest processRequest(SearchRequest request) throws Exception {
            responseBox[0] = r;  
        }
            super(tag, description, ignoreFailure);  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        }, e -> { exceptionBox[0] = e; }));
            throw exceptionBox[0];
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>> systemGeneratedResponseProcessors,  
        @Override
    static SearchResponse syncTransformResponse(PipelinedRequest pipelinedRequest, SearchResponse searchResponse) throws Exception {
        /**
            this.type = type;  
            String tag,
import org.opensearch.cluster.ClusterChangedEvent;
            return this.type;
                }
                ignoreFailure,
        public SearchRequestProcessor create(
        public FakeSystemGeneratedSearchPhaseResultsPostProcessor(
        public <Result extends SearchPhaseResult> void process(  
        ClusterState previousState = clusterState;
                    new BytesArray("{\"request_processors\" : [ { \"scale_request_size\": { \"scale\" : 2 } } ] }"),  
     * Helper to synchronously apply a request pipeline and response pipeline, returning the transformed response.
        public boolean shouldGenerate(ProcessorGenerationContext context) {
        ) throws Exception {
            return this.type;  
        @Override
        implements
        public ExecutionStage getExecutionStage() {  
            this.type = type;
            return ExecutionStage.PRE_USER_DEFINED;  
            String tag,  
                public Map<String, Processor.Factory<SearchResponseProcessor>> getResponseProcessors(Parameters parameters) {  
            Map<String, Object> config,
            new HashMap<>();
            super(tag, description, ignoreFailure);
            Map<String, Processor.Factory<SearchResponseProcessor>> processorFactories,  
        @Override  
        Client client = mock(Client.class);  
        public String getType() {
            String type,
            Processor.PipelineContext pipelineContext  
        private String type;  
    static class FakeSystemGeneratedRequestPostProcessor extends FakeRequestProcessor implements SystemGeneratedProcessor {  
    }
                }
        ) {  
                    getSystemGeneratedSearchPhaseResultsProcessors(Parameters parameters) {
import java.util.Map;  
            String tag,
            return new FakeSystemGeneratedRequestPreProcessor(  
    }
    }
         * Gets the type of processor
        private Consumer<SearchPhaseResult> querySearchResultConsumer;
            String description,
            String description,
        final Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>> response;
    /**
        }  
            return request;  
        final Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> request;  
                }
            super(type, tag, description, ignoreFailure, executor);
    SearchPipelineService createWithProcessors(
                    Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>>
            final float finalScore = config.containsKey("score") ? ((Number) config.remove("score")).floatValue() : 100f;
        }
        }  
    }
            String type,  
            return ExecutionStage.POST_USER_DEFINED;
}
        @Override
import org.opensearch.threadpool.ThreadPool;
        ) {
        ActionListener<SearchResponse> responseListener = pipelinedRequest.transformResponseListener(ActionListener.wrap(r -> {
    }
    static class FakeRequestProcessor extends AbstractProcessor implements SearchRequestProcessor {
                    getSystemGeneratedRequestProcessors(Parameters parameters) {
            Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,
            Consumer<SearchPhaseResult> querySearchResultConsumer
            this.phase = phase;
         * Gets the type of processor
        implements
            Map.of(
    static class SystemGeneratedScaleScorePreFactory implements SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor> {  
 */  
     * Helper to synchronously apply a response pipeline, returning the transformed response.  
            boolean ignoreFailure,  
            .put(IndexSettings.DEFAULT_SEARCH_PIPELINE.getKey(), "p1")  
        }  
        @Override  
            );  
                @Override  
    static class SystemGeneratedScaleRequestSizePreFactory  
import org.opensearch.cluster.ClusterName;
            );
    }  
        ProcessorSets base = buildBaseProcessors();
 * this file be licensed under the Apache-2.0 license or a
        public FakeRequestProcessor(String type, String tag, String description, boolean ignoreFailure, Consumer<SearchRequest> executor) {  
        public boolean shouldGenerate(ProcessorGenerationContext context) {  
            Collections.emptyMap(),
        );
            Map<String, Object> config,
    ProcessorSets buildBaseProcessors() {
    }
        @Override
            boolean ignoreFailure,
            .put(IndexMetadata.SETTING_INDEX_VERSION_CREATED.getKey(), Version.CURRENT)
                rsp -> rsp.getHits().forEach(h -> h.score(h.getScore() * 2))  
            .build();
    }
        return indexBuilder(index, Settings.EMPTY);
        public SearchRequestProcessor create(  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).build();  
        }
        public FakeSystemGeneratedRequestPreProcessor(
        }  
    }
            return true;  
        }
import org.opensearch.cluster.metadata.Metadata;  
                    return responseProcessors;
            .put(IndexMetadata.INDEX_NUMBER_OF_SHARDS_SETTING.getKey(), 1)  
        }
import org.opensearch.action.search.SearchResponse;  
            Map<String, Processor.Factory<SearchRequestProcessor>> request,
    SearchSourceBuilder createDefaultSearchSourceBuilder() {
        }
        public FakeResponseProcessor(
        ) {
        SystemProcessorSets system = buildSystemProcessors();
        public String getType() {
            this.querySearchResultConsumer = querySearchResultConsumer;
            super(type, tag, description, ignoreFailure, executor);
            super(type, tag, description, ignoreFailure, querySearchResultConsumer);  
    static class SystemGeneratedMaxScorePostFactory  
        @Override
    }
            phaseProcessors,  
            Map<String, Processor.Factory<SearchResponseProcessor>> response,
        return settings(Version.CURRENT).put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        service.applyClusterState(cce);
            Collections.emptyMap(),
        Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessors = new HashMap<>();
            return true;
                new PipelineConfiguration(
        );
            new HashMap<>();  
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>> systemGeneratedPhaseProcessors =  
                req -> req.source().size((int) (req.source().size() * 2))
import org.opensearch.core.action.ActionListener;  
        ThreadPool threadPool = mock(ThreadPool.class);
        }  
        clusterState = ClusterState.builder(clusterState)
        }
        private String type;
        }
            String description,
                rsp -> rsp.getHits().forEach(h -> h.score(h.getScore() * 2))
        }
            Map<String, Processor.Factory<SearchRequestProcessor>> processorFactories,
import static org.mockito.Mockito.mock;
            super(tag, description, ignoreFailure);
            SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor> {
        SearchPipelineMetadata metadata = new SearchPipelineMetadata(
                tag,
        systemGeneratedPhaseProcessors.put("system_max_score_pre", new SystemGeneratedMaxScorePreFactory());
    SystemProcessorSets buildSystemProcessors() {
    IndexNameExpressionResolver indexNameExpressionResolver;
        @Override  
            boolean ignoreFailure,  
     * Helper to synchronously apply a request pipeline, returning the transformed request.
        }
    void setUpForResolvePipeline(SearchPipelineService service) throws Exception {  
        public boolean shouldGenerate(ProcessorGenerationContext context) {
    }
 * The OpenSearch Contributors require contributions made to  
                "system_scale_request_size_post",
import java.util.HashMap;
                )
    static class FakeSystemGeneratedResponsePreProcessor extends FakeResponseProcessor implements SystemGeneratedProcessor {
