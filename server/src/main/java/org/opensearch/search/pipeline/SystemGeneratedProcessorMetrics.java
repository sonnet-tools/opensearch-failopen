    void afterGeneration(String factoryType, Processor.ProcessorType processorType, long timeInNanos) {
    private FactoryMetrics getOrCreateFactoryMetrics(String factoryType, Processor.ProcessorType processorType) {  
        return processorMetrics.computeIfAbsent(processorType, k -> new HashMap<>())
        processorMetrics.get(type).forEach((processorType, metric) -> {
    class FactoryMetrics {
 *
    void beforeGeneration(String factoryType, Processor.ProcessorType processorType) {  
     */
    }
        });
class SystemGeneratedProcessorMetrics {
    }  
    }
            processorMetrics.put(type, new ConcurrentHashMap<>());
        factoryMetrics.get(type).forEach((factoryType, metric) -> {
 * compatible open source license.
    private OperationMetrics getOrCreateProcessorMetrics(String processorKey, Processor.ProcessorType processorType) {
        for (Processor.ProcessorType type : Processor.ProcessorType.values()) {  
    void afterProcess(String processorKey, Processor.ProcessorType processorType, long timeInNanos) {
        getOrCreateProcessorMetrics(processorKey, processorType).before();
    }
        return new SearchPipelineStats.PipelineDetailStats(requestProcessorStats, responseProcessorStats);  
        return new SearchPipelineStats.FactoryDetailStats(requestProcessorFactoryStats, responseProcessorFactoryStats);
    }
    }  
}
    }
     * Metrics for a system generated factory  
package org.opensearch.search.pipeline;
    private List<SearchPipelineStats.ProcessorStats> buildProcessorStats(Processor.ProcessorType type) {  
import java.util.ArrayList;  
        getOrCreateProcessorMetrics(processorKey, processorType).failed();  
        getOrCreateFactoryMetrics(factoryType, processorType).generation.after(timeInNanos);
        getOrCreateFactoryMetrics(factoryType, processorType).evaluation.after(timeInNanos);
    /**
    void onProcessFailure(String processorKey, Processor.ProcessorType processorType) {
    }  
        getOrCreateFactoryMetrics(factoryType, processorType).generation.before();
    SearchPipelineStats.FactoryDetailStats getFactoryStats() {  
    void afterEvaluation(String factoryType, Processor.ProcessorType processorType, long timeInNanos) {
        List<SearchPipelineStats.ProcessorStats> responseProcessorStats = buildProcessorStats(Processor.ProcessorType.SEARCH_RESPONSE);
    }  
        private final OperationMetrics generation = new OperationMetrics(TimeUnit.MICROSECONDS);
            stats.add(new SearchPipelineStats.ProcessorStats(processorType, processorType, metric.createStats()));  
 * The OpenSearch Contributors require contributions made to  
        return stats;
        private final OperationMetrics evaluation = new OperationMetrics(TimeUnit.MICROSECONDS);  
 * Metrics for the system generated processors
import java.util.List;
        getOrCreateFactoryMetrics(factoryType, processorType).evaluation.failed();  
import java.util.HashMap;
        List<SearchPipelineStats.FactoryStats> stats = new ArrayList<>();  
        }  
    }
            .computeIfAbsent(processorKey, k -> new OperationMetrics());  
    }
    void beforeProcess(String processorKey, Processor.ProcessorType processorType) {  
/**
    }
        List<SearchPipelineStats.FactoryStats> requestProcessorFactoryStats = buildFactoryStats(Processor.ProcessorType.SEARCH_REQUEST);
import java.util.concurrent.TimeUnit;
        getOrCreateFactoryMetrics(factoryType, processorType).generation.failed();  
    void beforeEvaluation(String factoryType, Processor.ProcessorType processorType) {  
    }
import java.util.Map;  
        getOrCreateProcessorMetrics(processorKey, processorType).after(timeInNanos);
    private List<SearchPipelineStats.FactoryStats> buildFactoryStats(Processor.ProcessorType type) {
            factoryMetrics.put(type, new ConcurrentHashMap<>());
            stats.add(new SearchPipelineStats.FactoryStats(factoryType, metric.evaluation.createStats(), metric.generation.createStats()));
        }
        });  
        return stats;
        public OperationMetrics generation() {
 * SPDX-License-Identifier: Apache-2.0
 */  
        List<SearchPipelineStats.ProcessorStats> requestProcessorStats = buildProcessorStats(Processor.ProcessorType.SEARCH_REQUEST);
    }
        List<SearchPipelineStats.FactoryStats> responseProcessorFactoryStats = buildFactoryStats(Processor.ProcessorType.SEARCH_RESPONSE);  
    }
    SystemGeneratedProcessorMetrics() {
        return factoryMetrics.computeIfAbsent(processorType, k -> new HashMap<>()).computeIfAbsent(factoryType, k -> new FactoryMetrics());
            return generation;
    }
    void onGenerationFailure(String factoryType, Processor.ProcessorType processorType) {
        getOrCreateFactoryMetrics(factoryType, processorType).evaluation.before();
        }  
        List<SearchPipelineStats.ProcessorStats> stats = new ArrayList<>();
    private final Map<Processor.ProcessorType, Map<String, OperationMetrics>> processorMetrics = new ConcurrentHashMap<>();  
 */  
/*  
    SearchPipelineStats.PipelineDetailStats getProcessorStats() {
import org.opensearch.common.metrics.OperationMetrics;
import java.util.concurrent.ConcurrentHashMap;
        public OperationMetrics evaluation() {  
    }  
            return evaluation;
    private final Map<Processor.ProcessorType, Map<String, FactoryMetrics>> factoryMetrics = new ConcurrentHashMap<>();
    void onEvaluationFailure(String factoryType, Processor.ProcessorType processorType) {
 * this file be licensed under the Apache-2.0 license or a
