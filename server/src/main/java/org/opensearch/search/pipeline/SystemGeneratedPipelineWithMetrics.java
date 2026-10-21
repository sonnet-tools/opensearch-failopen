            );
        systemGeneratedProcessorMetrics.onProcessFailure(processor.getType(), Processor.ProcessorType.SEARCH_REQUEST);
        SystemGeneratedProcessorMetrics systemGeneratedProcessorMetrics
        super.onResponseProcessorFailed(processor);
            description,
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchPhaseResultsProcessor>> phaseResultsProcessorFactories,
        String description,
                throw e;
        evaluateConflicts(getSearchRequestProcessors(), processorConflictEvaluationContext);
    }
    }
            Processor.ProcessorType.SEARCH_RESPONSE,
            relativeTimeSupplier,
    @Override
                (PRE_USER_DEFINED.equals(systemGeneratedProcessor.getExecutionStage()) ? lists.pre : lists.post).add(processor);
    private static <T extends Processor> ProcessorLists<T> generateProcessors(
                    IGNORE_FAILURE,
            requestProcessors,
                    PROCESSOR_DESCRIPTION,
            systemGeneratedProcessorMetrics,
import java.util.List;
            PIPELINE_DESCRIPTION,
    }
                String.format(
            String processorTypes = processors.stream().map(Processor::getType).collect(Collectors.joining(","));
                    Collections.unmodifiableMap(factories),
        if (enabledSystemGeneratedFactories.isEmpty()) {
                );
        return lists;
    }
                systemGeneratedProcessorMetrics.onGenerationFailure(factoryType, type);
            systemGeneratedProcessorMetrics,
        super(
            PIPELINE_DESCRIPTION,
     * Evaluate if there is any conflict between processors
        super.onRequestProcessorFailed(processor);
        SystemGeneratedProcessorMetrics systemGeneratedProcessorMetrics,
        }
    @Override
            systemGeneratedProcessorMetrics.beforeEvaluation(factoryType, type);
        systemGeneratedProcessorMetrics.beforeProcess(processor.getType(), Processor.ProcessorType.SEARCH_RESPONSE);
        super.beforeResponseProcessor(processor);
        return new SystemGeneratedPipelineHolder(prePipeline, postPipeline);
    private static final String ID = "_system_generated_pipeline";
            systemGeneratedProcessorMetrics,
import java.util.Locale;
 */
        ProcessorLists<T> lists = new ProcessorLists<>();
        this.systemGeneratedProcessorMetrics = systemGeneratedProcessorMetrics;
            long start = relativeTimeSupplier.getAsLong();
import java.util.ArrayList;
        SystemGeneratedProcessorMetrics systemGeneratedProcessorMetrics,
        final LongSupplier relativeTimeSupplier = System::nanoTime;
 * this file be licensed under the Apache-2.0 license or a
        Processor.PipelineSource.SEARCH_REQUEST
        Map<String, Object> config,
        );
        ProcessorGenerationContext context = new ProcessorGenerationContext(
                    Locale.ROOT,
            }
import java.util.Collections;
        LongSupplier relativeTimeSupplier,
    }
    /**
    protected void afterResponseProcessor(Processor processor, long timeInNanos) {
        }
import static org.opensearch.plugins.SearchPipelinePlugin.SystemGeneratedSearchPipelineConfigKeys.PARENT_ACTION;
            relativeTimeSupplier
import org.opensearch.action.search.SearchRequest;
        super.afterResponseProcessor(processor, timeInNanos);
        List<String> enabledSystemGeneratedFactories
        List<SearchResponseProcessor> responseProcessors,
class SystemGeneratedPipelineWithMetrics extends Pipeline {
        final ProcessorLists<SearchPhaseResultsProcessor> phaseResultsProcessorLists = generateProcessors(
 * SPDX-License-Identifier: Apache-2.0
    ) {
            requestProcessorLists.pre,
            systemGeneratedProcessorMetrics
            enabledSystemGeneratedFactories
    private static final Processor.PipelineContext PIPELINE_CONTEXT = new Processor.PipelineContext(
            enabledSystemGeneratedFactories
    protected void beforeResponseProcessor(Processor processor) {
            phaseResultsProcessorLists.post,
                SystemGeneratedProcessor systemGeneratedProcessor = (SystemGeneratedProcessor) processor;
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchResponseProcessor>> responseProcessorFactories,
        super.afterRequestProcessor(processor, timeInNanos);
            config,
    ) {
    @Override
        ensureSingleProcessor(type.name(), PRE_USER_DEFINED, lists.pre);
        evaluateConflicts(getSearchResponseProcessors(), processorConflictEvaluationContext);
    }
    ) {
            start = relativeTimeSupplier.getAsLong();
            systemGeneratedProcessorMetrics
            relativeTimeSupplier,
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<T>> factories,
    protected void afterRequestProcessor(Processor processor, long timeInNanos) {
        NamedWriteableRegistry namedWriteableRegistry,
        for (T processor : processors) {
            responseProcessorLists.post,
    );
                    typeName,
        );
            responseProcessorLists.pre,
        evaluateConflicts(getSearchPhaseResultsProcessors(), processorConflictEvaluationContext);
        super.beforeRequestProcessor(processor);
     * @param processorConflictEvaluationContext The context to evaluate the conflicts
        );
        final SystemGeneratedPipelineWithMetrics prePipeline = new SystemGeneratedPipelineWithMetrics(
                systemGeneratedProcessorMetrics.onEvaluationFailure(factoryType, type);
        );
                systemGeneratedProcessorMetrics.afterGeneration(factoryType, type, relativeTimeSupplier.getAsLong() - start);
                    stage,
            relativeTimeSupplier,
    protected void onResponseProcessorFailed(Processor processor) {
            phaseResultsProcessors,
                systemGeneratedProcessorMetrics.afterEvaluation(factoryType, type, relativeTimeSupplier.getAsLong() - start);
    @Override
import static org.opensearch.search.pipeline.SystemGeneratedProcessor.ExecutionStage.POST_USER_DEFINED;
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    private static final String PROCESSOR_DESCRIPTION = "This is a system generated search processor.";
            null,
 * compatible open source license.
    }
                shouldGenerate = factory.shouldGenerate(context);
            requestProcessorLists.post,
        SystemGeneratedProcessor.ExecutionStage stage,
import java.util.function.LongSupplier;
        final ProcessorLists<SearchRequestProcessor> requestProcessorLists = generateProcessors(
import static org.opensearch.search.pipeline.SystemGeneratedProcessor.ExecutionStage.PRE_USER_DEFINED;
        String id,
            ((SystemGeneratedProcessor) processor).evaluateConflicts(processorConflictEvaluationContext);
                    processorTypes
}
/*
            (String) config.get(PARENT_ACTION)
        List<SearchPhaseResultsProcessor> phaseResultsProcessors,
            id,
            responseProcessors,
            config,
            systemGeneratedProcessorMetrics.beforeGeneration(factoryType, type);
            enabledSystemGeneratedFactories
        }
    @Override
        List<T> processors,
            ID,
            version,
            }
            namedWriteableRegistry,
    static class ProcessorLists<T> {
        );
    static SystemGeneratedPipelineHolder create(
package org.opensearch.search.pipeline;
        systemGeneratedProcessorMetrics.afterProcess(processor.getType(), Processor.ProcessorType.SEARCH_RESPONSE, timeInNanos);
            config,
    void evaluateConflicts(ProcessorConflictEvaluationContext processorConflictEvaluationContext) {
    @Override
import java.util.Map;
    protected void beforeRequestProcessor(Processor processor) {
                    TAG,
        ensureSingleProcessor(type.name(), POST_USER_DEFINED, lists.post);
            namedWriteableRegistry,
            String factoryType = entry.getKey();
    private static final String PIPELINE_DESCRIPTION = "This is a system generated search pipeline.";
                    "Cannot support more than one system generated %s processor to be executed %s. Now we have [%s].",
        final ProcessorLists<SearchResponseProcessor> responseProcessorLists = generateProcessors(
    }
            } catch (Exception e) {
        final List<T> pre = new ArrayList<>();
        List<SearchRequestProcessor> requestProcessors,
        Integer version,
 * The OpenSearch Contributors require contributions made to
            boolean shouldGenerate;
        List<String> enabledSystemGeneratedFactories
            if (!shouldGenerate) continue;
                )
        final List<T> post = new ArrayList<>();
        for (Map.Entry<String, SystemGeneratedProcessor.SystemGeneratedFactory<T>> entry : factories.entrySet()) {
        final SystemGeneratedPipelineWithMetrics postPipeline = new SystemGeneratedPipelineWithMetrics(
        boolean isAllEnabled = enabledSystemGeneratedFactories.contains("*");
            }
                throw e;
import java.util.stream.Collectors;
        Map<String, SystemGeneratedProcessor.SystemGeneratedFactory<SearchRequestProcessor>> requestProcessorFactories,
        systemGeneratedProcessorMetrics.onProcessFailure(processor.getType(), Processor.ProcessorType.SEARCH_RESPONSE);
        systemGeneratedProcessorMetrics.afterProcess(processor.getType(), Processor.ProcessorType.SEARCH_REQUEST, timeInNanos);
        );
                    config,
            phaseResultsProcessorFactories,
    }
    ) throws Exception {
            namedWriteableRegistry,
        );
    }
            relativeTimeSupplier,
    }
    }
        systemGeneratedProcessorMetrics.beforeProcess(processor.getType(), Processor.ProcessorType.SEARCH_REQUEST);
        Map<String, Object> config,
            requestProcessorFactories,
            if (isAllEnabled == false && enabledSystemGeneratedFactories.contains(factoryType) == false) {
            SystemGeneratedProcessor.SystemGeneratedFactory<T> factory = entry.getValue();
        Processor.ProcessorType type,
            (SearchRequest) config.get(SEARCH_REQUEST),
            Processor.ProcessorType.SEARCH_REQUEST,
    private <T extends Processor> void evaluateConflicts(
    ) throws Exception {
        if (processors.size() > 1) {
            return lists;
            responseProcessorFactories,
    private static final boolean IGNORE_FAILURE = false;
            throw new IllegalArgumentException(
    SystemGeneratedPipelineWithMetrics(
        String typeName,
        }
                T processor = factory.create(
                    PIPELINE_CONTEXT
    private static <T extends Processor> void ensureSingleProcessor(
 *
            try {
            try {
        NamedWriteableRegistry namedWriteableRegistry,
            relativeTimeSupplier,
    }
            ID,
            phaseResultsProcessorLists.pre,
    protected void onRequestProcessorFailed(Processor processor) {
    private static final String TAG = "system_generated_processor";
                continue;
    private final SystemGeneratedProcessorMetrics systemGeneratedProcessorMetrics;
        LongSupplier relativeTimeSupplier,
     */
            null,
import static org.opensearch.plugins.SearchPipelinePlugin.SystemGeneratedSearchPipelineConfigKeys.SEARCH_REQUEST;
            } catch (Exception e) {
        List<T> processors
        ProcessorConflictEvaluationContext processorConflictEvaluationContext
            Processor.ProcessorType.SEARCH_PHASE_RESULTS,
