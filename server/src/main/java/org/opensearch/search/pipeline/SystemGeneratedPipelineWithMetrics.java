        ProcessorLists<T> lists = new ProcessorLists<>();
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>> responseProcessorFactories,
        if (enabledSystemGeneratedFactories.isEmpty()) {
                    config,  
            enabledSystemGeneratedFactories  
 * The OpenSearch Contributors require contributions made to  
    static class ProcessorLists<T> {  
    @Override  
        final SystemGeneratedPipelineWithMetrics postPipeline = new SystemGeneratedPipelineWithMetrics(  
            phaseResultsProcessorLists.pre,  
    }
    private <T extends Processor> void evaluateConflicts(  
            ID,
    }
        systemGeneratedProcessorMetrics.beforeProcess(processor.getType(), Processor.ProcessorType.SEARCH_RESPONSE);  
    }  
                shouldGenerate = factory.shouldGenerate(context);
        boolean isAllEnabled = enabledSystemGeneratedFactories.contains("*");
        List<SearchResponseProcessor> responseProcessors,  
    }
            String factoryType = entry.getKey();  
            config,  
    protected void afterRequestProcessor(Processor processor, long timeInNanos) {
                    typeName,  
        evaluateConflicts(getSearchPhaseResultsProcessors(), processorConflictEvaluationContext);
    protected void beforeResponseProcessor(Processor processor) {
        List<T> processors
    ) throws Exception {  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    /**
            SystemGeneratedProcessor.SystemGeneratedFactory<T> factory = entry.getValue();
        super(  
            relativeTimeSupplier,
        final ProcessorLists<SearchPhaseResultsProcessor> phaseResultsProcessorLists = generateProcessors(  
        String description,  
            namedWriteableRegistry,
        );
    ) throws Exception {  
import static org.opensearch.plugins.SearchPipelinePlugin.SystemGeneratedSearchPipelineConfigKeys.PARENT_ACTION;  
                systemGeneratedProcessorMetrics.afterGeneration(factoryType, type, relativeTimeSupplier.getAsLong() - start);  
            if (!shouldGenerate) continue;
        SystemGeneratedProcessor.ExecutionStage stage,  
            null,  
    }
    private static final Processor.PipelineContext PIPELINE_CONTEXT = new Processor.PipelineContext(  
        List<String> enabledSystemGeneratedFactories
import java.util.Locale;
    private static final String ID = "_system_generated_pipeline";
    }  
import static org.opensearch.plugins.SearchPipelinePlugin.SystemGeneratedSearchPipelineConfigKeys.SEARCH_REQUEST;
/*  
import static org.opensearch.search.pipeline.SystemGeneratedProcessor.ExecutionStage.PRE_USER_DEFINED;  
        SystemGeneratedProcessorMetrics systemGeneratedProcessorMetrics,
            } catch (Exception e) {  
    }
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>> phaseResultsProcessorFactories,
     * Evaluate if there is any conflict between processors  
            enabledSystemGeneratedFactories  
            PIPELINE_DESCRIPTION,
                systemGeneratedProcessorMetrics.onGenerationFailure(factoryType, type);
            try {  
            );
            ((SystemGeneratedProcessor) processor).evaluateConflicts(processorConflictEvaluationContext);
                throw e;  
            Processor.ProcessorType.SEARCH_RESPONSE,
            responseProcessorLists.post,
        if (processors.size() > 1) {  
        );
            requestProcessorFactories,
            relativeTimeSupplier
        );
            version,  
import java.util.Map;
        super.beforeRequestProcessor(processor);
        SystemGeneratedProcessorMetrics systemGeneratedProcessorMetrics
        Integer version,
import java.util.List;  
        ensureSingleProcessor(type.name(), POST_USER_DEFINED, lists.post);
                    processorTypes
            systemGeneratedProcessorMetrics,
        Map<String, Object> config,
        final ProcessorLists<SearchRequestProcessor> requestProcessorLists = generateProcessors(  
            Processor.ProcessorType.SEARCH_PHASE_RESULTS,
    }
            requestProcessorLists.post,
        final LongSupplier relativeTimeSupplier = System::nanoTime;
            relativeTimeSupplier,
        }  
    }
 */  
        String id,
            relativeTimeSupplier,
            responseProcessors,
            throw new IllegalArgumentException(
import java.util.Collections;
            namedWriteableRegistry,
        systemGeneratedProcessorMetrics.beforeProcess(processor.getType(), Processor.ProcessorType.SEARCH_REQUEST);  
            if (isAllEnabled == false && enabledSystemGeneratedFactories.contains(factoryType) == false) {
import java.util.stream.Collectors;
                    IGNORE_FAILURE,
    }
                );
    @Override  
    private static <T extends Processor> void ensureSingleProcessor(
                    PROCESSOR_DESCRIPTION,
        super.onResponseProcessorFailed(processor);
        ProcessorGenerationContext context = new ProcessorGenerationContext(  
            try {  
            config,  
        for (Map.Entry<String, SystemGeneratedProcessor.SystemGeneratedFactory<T>> entry : factories.entrySet()) {
            systemGeneratedProcessorMetrics,
            config,  
        );  
            null,  
                throw e;
        systemGeneratedProcessorMetrics.afterProcess(processor.getType(), Processor.ProcessorType.SEARCH_RESPONSE, timeInNanos);  
            systemGeneratedProcessorMetrics,
            }
            requestProcessorLists.pre,
     * @param processorConflictEvaluationContext The context to evaluate the conflicts
        for (T processor : processors) {
                    Collections.unmodifiableMap(factories),
        String typeName,
            } catch (Exception e) {
            systemGeneratedProcessorMetrics.beforeEvaluation(factoryType, type);
    private final SystemGeneratedProcessorMetrics systemGeneratedProcessorMetrics;  
                String.format(  
                    PIPELINE_CONTEXT
import java.util.function.LongSupplier;  
            id,
            phaseResultsProcessorLists.post,  
        List<String> enabledSystemGeneratedFactories
            PIPELINE_DESCRIPTION,
}
            start = relativeTimeSupplier.getAsLong();
        NamedWriteableRegistry namedWriteableRegistry,
        );  
        }
    protected void onRequestProcessorFailed(Processor processor) {
        }
    );
package org.opensearch.search.pipeline;
            }  
    @Override  
                continue;
        List<SearchRequestProcessor> requestProcessors,
    private static final String PROCESSOR_DESCRIPTION = "This is a system generated search processor.";
                (PRE_USER_DEFINED.equals(systemGeneratedProcessor.getExecutionStage()) ? lists.pre : lists.post).add(processor);  
        Map<String, Object> config,
        systemGeneratedProcessorMetrics.afterProcess(processor.getType(), Processor.ProcessorType.SEARCH_REQUEST, timeInNanos);  
        super.beforeResponseProcessor(processor);
            phaseResultsProcessors,  
        ensureSingleProcessor(type.name(), PRE_USER_DEFINED, lists.pre);
        systemGeneratedProcessorMetrics.onProcessFailure(processor.getType(), Processor.ProcessorType.SEARCH_RESPONSE);  
    @Override  
    }
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> requestProcessorFactories,  
    SystemGeneratedPipelineWithMetrics(
            phaseResultsProcessorFactories,
                systemGeneratedProcessorMetrics.onEvaluationFailure(factoryType, type);
        );
        LongSupplier relativeTimeSupplier,  
    @Override  
            responseProcessorLists.pre,
    private static final String PIPELINE_DESCRIPTION = "This is a system generated search pipeline.";
        this.systemGeneratedProcessorMetrics = systemGeneratedProcessorMetrics;
            requestProcessors,
            systemGeneratedProcessorMetrics  
    protected void beforeRequestProcessor(Processor processor) {
        ProcessorConflictEvaluationContext processorConflictEvaluationContext
                    TAG,  
                    stage,
    protected void onResponseProcessorFailed(Processor processor) {
            long start = relativeTimeSupplier.getAsLong();  
            systemGeneratedProcessorMetrics  
                T processor = factory.create(
    @Override  
            Processor.ProcessorType.SEARCH_REQUEST,
        SystemGeneratedProcessorMetrics systemGeneratedProcessorMetrics,
        NamedWriteableRegistry namedWriteableRegistry,  
            description,
            (SearchRequest) config.get(SEARCH_REQUEST),
            }  
import java.util.ArrayList;
            boolean shouldGenerate;
                    Locale.ROOT,
    ) {  
        evaluateConflicts(getSearchResponseProcessors(), processorConflictEvaluationContext);  
            enabledSystemGeneratedFactories  
        return new SystemGeneratedPipelineHolder(prePipeline, postPipeline);  
        Processor.PipelineSource.SEARCH_REQUEST
 *
            systemGeneratedProcessorMetrics.beforeGeneration(factoryType, type);
    ) {
                systemGeneratedProcessorMetrics.afterEvaluation(factoryType, type, relativeTimeSupplier.getAsLong() - start);
    private static final boolean IGNORE_FAILURE = false;
            relativeTimeSupplier,
            namedWriteableRegistry,
        return lists;
    protected void afterResponseProcessor(Processor processor, long timeInNanos) {
            relativeTimeSupplier,
    void evaluateConflicts(ProcessorConflictEvaluationContext processorConflictEvaluationContext) {  
                )  
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        final List<T> pre = new ArrayList<>();
        final SystemGeneratedPipelineWithMetrics prePipeline = new SystemGeneratedPipelineWithMetrics(  
        super.afterRequestProcessor(processor, timeInNanos);
import org.opensearch.action.search.SearchRequest;
        );
        List<SearchPhaseResultsProcessor> phaseResultsProcessors,
        final ProcessorLists<SearchResponseProcessor> responseProcessorLists = generateProcessors(  
        List<T> processors,
            String processorTypes = processors.stream().map(Processor::getType).collect(Collectors.joining(","));
                SystemGeneratedProcessor systemGeneratedProcessor = (SystemGeneratedProcessor) processor;
        systemGeneratedProcessorMetrics.onProcessFailure(processor.getType(), Processor.ProcessorType.SEARCH_REQUEST);  
    }
import static org.opensearch.search.pipeline.SystemGeneratedProcessor.ExecutionStage.POST_USER_DEFINED;
            responseProcessorFactories,
    private static final String TAG = "system_generated_processor";  
        super.onRequestProcessorFailed(processor);
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<T>> factories,  
    ) {
     */
        }
        Processor.ProcessorType type,
            ID,
            (String) config.get(PARENT_ACTION)
                    "Cannot support more than one system generated %s processor to be executed %s. Now we have [%s].",
    private static <T extends Processor> ProcessorLists<T> generateProcessors(
        final List<T> post = new ArrayList<>();
    }
class SystemGeneratedPipelineWithMetrics extends Pipeline {
    static SystemGeneratedPipelineHolder create(
            return lists;  
 * SPDX-License-Identifier: Apache-2.0
        super.afterResponseProcessor(processor, timeInNanos);
        LongSupplier relativeTimeSupplier,  
        evaluateConflicts(getSearchRequestProcessors(), processorConflictEvaluationContext);
