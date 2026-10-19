        totalResponseMetrics.after(timeInNanos);  
            pipelineContext
import java.util.Arrays;
        OperationMetrics totalResponseMetrics,
    protected void onResponseProcessorFailed(Processor processor) {  
        totalRequestMetrics.failed();  
                            + "] doesn't support one or more provided configuration parameters: "
            responseProcessors,  
    protected void onTransformRequestFailure() {
                    + "] doesn't support one or more provided configuration parameters "  
        responseProcessorMetrics.get(getProcessorKey(processor)).before();
        Map<String, OperationMetrics> newProcessorMetrics,  
    protected void afterTransformRequest(long timeInNanos) {  
    private final OperationMetrics pipelineResponseMetrics = new OperationMetrics();  
        copyProcessorMetrics(responseProcessorMetrics, oldPipeline.responseProcessorMetrics);
        Map<String, OperationMetrics> oldProcessorMetrics
                        processorName = processorName + ":" + tag;
                    );  
 *
        OperationMetrics totalRequestProcessingMetrics,
        List<SearchRequestProcessor> requestProcessors,
        List<Map<String, Object>> responseProcessorConfigs = ConfigurationUtils.readOptionalList(
            System::nanoTime
    protected void afterTransformResponse(long timeInNanos) {
 * this file be licensed under the Apache-2.0 license or a
        super.onTransformRequestFailure();
            null,
        );
            description,  
        super.afterTransformResponse(timeInNanos);
        );  
        super.onTransformResponseFailure();
            }
        Processor.PipelineContext pipelineContext  
        Map<String, Processor.Factory<SearchPhaseResultsProcessor>> phaseResultsProcessorFactories,
        responseProcessorMetrics.get(getProcessorKey(processor)).failed();
        Integer version = ConfigurationUtils.readIntProperty(null, null, config, VERSION_KEY, null);  
        List<SearchPhaseResultsProcessor> phaseResultsProcessors = readProcessors(  
        List<SearchPhaseResultsProcessor> phaseResultsProcessors,
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessorFactories,  
 * SPDX-License-Identifier: Apache-2.0
    protected void beforeTransformResponse() {
        totalRequestMetrics.before();
        return Collections.unmodifiableList(processors);
            null,
                String description = ConfigurationUtils.readOptionalStringProperty(null, tag, config, DESCRIPTION_KEY);
import org.opensearch.common.metrics.OperationMetrics;
    private static String getProcessorKey(Processor processor) {
        OperationMetrics totalRequestMetrics,  
    }
import java.util.Map;
        if (requestProcessorConfigs == null) {
    }
            null,
import static org.opensearch.ingest.ConfigurationUtils.TAG_KEY;  
            relativeTimeSupplier  
    }  
import java.util.List;
        super.beforeTransformRequest();  
                }  
import static org.opensearch.ingest.Pipeline.DESCRIPTION_KEY;
            requestProcessorFactories,  
/*  
            responseProcessorConfigs,  
    protected void beforeResponseProcessor(Processor processor) {
            config,  
                String type = entry.getKey();  
            totalResponseProcessingMetrics,
        totalResponseMetrics.before();  
        }  
        totalRequestMetrics.after(timeInNanos);
            totalRequestProcessingMetrics,  
        }  
                }
                    throw new IllegalArgumentException("Invalid processor type " + type);
                processors.add(
            id,
    @Override  
            id,
    ) {  
            return processors;
import java.util.Collections;
        NamedWriteableRegistry namedWriteableRegistry,
 * The OpenSearch Contributors require contributions made to  
                            + processorName  
        super(
            phaseResultsProcessors,
                );
        super.beforeTransformRequest();
        );  
            for (Map.Entry<String, Object> entry : processorConfigWithKey.entrySet()) {
        );
            RESPONSE_PROCESSORS_KEY
        String description,  
        for (Map<String, Object> processorConfigWithKey : requestProcessorConfigs) {
    private static <T extends Processor> void copyProcessorMetrics(
    }
            throw new OpenSearchParseException(  
        List<SearchRequestProcessor> requestProcessors = readProcessors(
    ) throws Exception {
        for (Processor processor : getSearchResponseProcessors()) {  
                Map<String, Object> config = (Map<String, Object>) entry.getValue();
        statsBuilder.addPipelineStats(getId(), pipelineRequestMetrics, pipelineResponseMetrics);
                    String processorName = type;  
            requestProcessors,
        pipelineRequestMetrics.before();
                    }  
        List<Map<String, Object>> requestProcessorConfigs,  
    void copyMetrics(PipelineWithMetrics oldPipeline) {
        NamedWriteableRegistry namedWriteableRegistry,  
        Map<String, Processor.Factory<T>> processorFactories,
 * compatible open source license.
            responseProcessorMetrics.putIfAbsent(getProcessorKey(responseProcessor), new OperationMetrics());
                if (config.isEmpty() == false) {
import java.util.function.LongSupplier;  
        requestProcessorMetrics.get(getProcessorKey(processor)).before();
            phaseResultsProcessors,
        List<Map<String, Object>> phaseResultsProcessorConfigs = ConfigurationUtils.readOptionalList(  
        String key = processor.getType();
    ) {
    protected void beforeRequestProcessor(Processor processor) {
    }  
            requestProcessors,
        pipelineRequestMetrics.after(timeInNanos);  
 * Specialization of {@link Pipeline} that adds metrics to track executions of the pipeline and individual processors.
    ) throws Exception {
class PipelineWithMetrics extends Pipeline {
                if (!processorFactories.containsKey(type)) {
            version,
    }  
        );  
        for (Processor processor : getSearchRequestProcessors()) {
    protected void afterRequestProcessor(Processor processor, long timeInNanos) {
        pipelineResponseMetrics.add(oldPipeline.pipelineResponseMetrics);  
    }
        pipelineResponseMetrics.before();
        }
        Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessorFactories,
    protected void onTransformResponseFailure() {
                    + id
            requestProcessorConfigs,
            config,
        for (Processor requestProcessor : getSearchRequestProcessors()) {
            phaseResultsProcessorConfigs,
        String description = ConfigurationUtils.readOptionalStringProperty(null, null, config, DESCRIPTION_KEY);
        }  
                    processorFactories.get(type).create(processorFactories, tag, description, ignoreFailure, config, pipelineContext)  
import static org.opensearch.ingest.Pipeline.VERSION_KEY;
        LongSupplier relativeTimeSupplier
        }  
        this.totalRequestMetrics = totalRequestMetrics;
        }  
        Processor.PipelineContext pipelineContext
    protected void beforeTransformRequest() {
import org.opensearch.ingest.ConfigurationUtils;
        for (Map.Entry<String, OperationMetrics> oldProcessorMetric : oldProcessorMetrics.entrySet()) {  
        List<Map<String, Object>> requestProcessorConfigs = ConfigurationUtils.readOptionalList(null, null, config, REQUEST_PROCESSORS_KEY);
import java.util.HashMap;  
            responseProcessorFactories,
            String key = getProcessorKey(processor);
        List<SearchResponseProcessor> responseProcessors,  
        String id,
    private final OperationMetrics totalResponseMetrics;
        this.totalResponseMetrics = totalResponseMetrics;  
                newProcessorMetrics.get(oldProcessorMetric.getKey()).add(oldProcessorMetric.getValue());
        if (config.isEmpty() == false) {
    }
            );
            responseProcessors,  
    }
        totalResponseMetrics.failed();  
                        "processor ["
        Integer version,
 */  
 */  
    protected void afterResponseProcessor(Processor processor, long timeInNanos) {
            if (newProcessorMetrics.containsKey(oldProcessorMetric.getKey())) {
            phaseResultsProcessorFactories,
/**
            namedWriteableRegistry,
        copyProcessorMetrics(requestProcessorMetrics, oldPipeline.requestProcessorMetrics);
    static PipelineWithMetrics create(  
    }
    protected void onRequestProcessorFailed(Processor processor) {  
            statsBuilder.addResponseProcessorStats(getId(), key, processor.getType(), responseProcessorMetrics.get(key));
                            + Arrays.toString(config.keySet().toArray())
            pipelineContext  
                boolean ignoreFailure = ConfigurationUtils.readBooleanProperty(null, null, config, IGNORE_FAILURE_KEY, false);  
    }
    private static <T extends Processor> List<T> readProcessors(
    private final Map<String, OperationMetrics> requestProcessorMetrics = new HashMap<>();
            String key = getProcessorKey(processor);  
            PHASE_PROCESSORS_KEY
    @Override
import org.opensearch.OpenSearchParseException;
                "pipeline ["
}
            version,
            }  
            requestProcessorMetrics.putIfAbsent(getProcessorKey(requestProcessor), new OperationMetrics());
        return key;  
        }  
                    if (tag != null) {
        OperationMetrics totalResponseProcessingMetrics,
        requestProcessorMetrics.get(getProcessorKey(processor)).after(timeInNanos);  
import java.util.ArrayList;  
            statsBuilder.addRequestProcessorStats(getId(), key, processor.getType(), requestProcessorMetrics.get(key));
            pipelineContext
    void populateStats(SearchPipelineStats.Builder statsBuilder) {  
        pipelineRequestMetrics.failed();
            null,  
        requestProcessorMetrics.get(getProcessorKey(processor)).failed();
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
    @Override
package org.opensearch.search.pipeline;
        );
import static org.opensearch.ingest.ConfigurationUtils.IGNORE_FAILURE_KEY;
    }  
    private final Map<String, OperationMetrics> responseProcessorMetrics = new HashMap<>();
        if (processor.getTag() != null) {  
        String id,
                    throw new OpenSearchParseException(
    private final OperationMetrics pipelineRequestMetrics = new OperationMetrics();
            namedWriteableRegistry,
    }
        }
    }
        pipelineRequestMetrics.add(oldPipeline.pipelineRequestMetrics);
            return key + ":" + processor.getTag();
        responseProcessorMetrics.get(getProcessorKey(processor)).after(timeInNanos);  
    }
        List<T> processors = new ArrayList<>();  
    }
    }
        pipelineResponseMetrics.failed();
    }
                    + Arrays.toString(config.keySet().toArray())
                String tag = ConfigurationUtils.readOptionalStringProperty(null, null, config, TAG_KEY);
        List<SearchResponseProcessor> responseProcessors = readProcessors(
        Map<String, Object> config,
        super.afterTransformRequest(timeInNanos);
        }
        for (Processor responseProcessor : getSearchResponseProcessors()) {
        pipelineResponseMetrics.after(timeInNanos);
    private final OperationMetrics totalRequestMetrics;  
    PipelineWithMetrics(
        );
        return new PipelineWithMetrics(
    }
            description,  
