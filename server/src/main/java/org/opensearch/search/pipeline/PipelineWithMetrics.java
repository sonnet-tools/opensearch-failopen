            pipelineContext
    }
    }
import java.util.Arrays;
            requestProcessors,
    protected void onResponseProcessorFailed(Processor processor) {
        List<Map<String, Object>> requestProcessorConfigs = ConfigurationUtils.readOptionalList(null, null, config, REQUEST_PROCESSORS_KEY);
    protected void onTransformRequestFailure() {
        responseProcessorMetrics.get(getProcessorKey(processor)).before();
            namedWriteableRegistry,
        List<SearchResponseProcessor> responseProcessors = readProcessors(
        );
        for (Processor processor : getSearchResponseProcessors()) {
        OperationMetrics totalRequestProcessingMetrics,
import java.util.function.LongSupplier;
    }
        Map<String, OperationMetrics> oldProcessorMetrics
                "pipeline ["
            description,
import static org.opensearch.ingest.ConfigurationUtils.TAG_KEY;
            pipelineContext
                    }
        return new PipelineWithMetrics(
                    throw new IllegalArgumentException("Invalid processor type " + type);
        }
    }
        pipelineRequestMetrics.after(timeInNanos);
        totalResponseMetrics.before();
package org.opensearch.search.pipeline;
 * The OpenSearch Contributors require contributions made to
                if (config.isEmpty() == false) {
    protected void afterResponseProcessor(Processor processor, long timeInNanos) {
        Map<String, Processor.Factory<SearchPhaseResultsProcessor>> phaseResultsProcessorFactories,
        pipelineResponseMetrics.after(timeInNanos);
        Map<String, Processor.Factory<SearchResponseProcessor>> responseProcessorFactories,
    }
    }
            }
        super(
        );
    protected void beforeRequestProcessor(Processor processor) {
                    String processorName = type;
        requestProcessorMetrics.get(getProcessorKey(processor)).failed();
        totalResponseMetrics.after(timeInNanos);
 */
        super.beforeTransformRequest();
            version,
    }
            description,
        totalRequestMetrics.failed();
        }
        pipelineResponseMetrics.add(oldPipeline.pipelineResponseMetrics);
    protected void afterTransformRequest(long timeInNanos) {
        List<SearchRequestProcessor> requestProcessors,
        pipelineRequestMetrics.before();
    }
    }
        pipelineResponseMetrics.before();
        NamedWriteableRegistry namedWriteableRegistry,
        }
                if (!processorFactories.containsKey(type)) {
 *
            statsBuilder.addRequestProcessorStats(getId(), key, processor.getType(), requestProcessorMetrics.get(key));
            requestProcessorMetrics.putIfAbsent(getProcessorKey(requestProcessor), new OperationMetrics());
        requestProcessorMetrics.get(getProcessorKey(processor)).before();
    protected void beforeTransformResponse() {
    ) {
            null,
            phaseResultsProcessorConfigs,
import java.util.ArrayList;
            requestProcessors,
            String key = getProcessorKey(processor);
import static org.opensearch.ingest.Pipeline.DESCRIPTION_KEY;
    ) throws Exception {
        super.beforeTransformRequest();
                            + "] doesn't support one or more provided configuration parameters: "
                }
                String type = entry.getKey();
    }
            RESPONSE_PROCESSORS_KEY
    protected void onRequestProcessorFailed(Processor processor) {
            statsBuilder.addResponseProcessorStats(getId(), key, processor.getType(), responseProcessorMetrics.get(key));
    protected void beforeTransformRequest() {
    private final OperationMetrics totalRequestMetrics;
        );
/**
        String id,
            return processors;
                    processorFactories.get(type).create(processorFactories, tag, description, ignoreFailure, config, pipelineContext)
    protected void afterTransformResponse(long timeInNanos) {
        requestProcessorMetrics.get(getProcessorKey(processor)).after(timeInNanos);
    }
                    );
            namedWriteableRegistry,
        super.onTransformResponseFailure();
        Processor.PipelineContext pipelineContext
        responseProcessorMetrics.get(getProcessorKey(processor)).failed();
            null,
        totalRequestMetrics.after(timeInNanos);
                Map<String, Object> config = (Map<String, Object>) entry.getValue();
}
    protected void onTransformResponseFailure() {
            id,
        }
            System::nanoTime
 * SPDX-License-Identifier: Apache-2.0
                }
        if (requestProcessorConfigs == null) {
        );
            return key + ":" + processor.getTag();
 * Specialization of {@link Pipeline} that adds metrics to track executions of the pipeline and individual processors.
import java.util.List;
        for (Processor requestProcessor : getSearchRequestProcessors()) {
        for (Map.Entry<String, OperationMetrics> oldProcessorMetric : oldProcessorMetrics.entrySet()) {
    }
        String id,
    protected void beforeResponseProcessor(Processor processor) {
    }
    }
        copyProcessorMetrics(requestProcessorMetrics, oldPipeline.requestProcessorMetrics);
            String key = getProcessorKey(processor);
    }
            );
        responseProcessorMetrics.get(getProcessorKey(processor)).after(timeInNanos);
            responseProcessors,
    ) {
                        "processor ["
import java.util.Map;
                            + processorName
import org.opensearch.common.metrics.OperationMetrics;
            responseProcessors,
import static org.opensearch.ingest.Pipeline.VERSION_KEY;
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> config,
    private static <T extends Processor> List<T> readProcessors(
            config,
        copyProcessorMetrics(responseProcessorMetrics, oldPipeline.responseProcessorMetrics);
                processors.add(
        if (processor.getTag() != null) {
    }
                boolean ignoreFailure = ConfigurationUtils.readBooleanProperty(null, null, config, IGNORE_FAILURE_KEY, false);
            null,
        List<Map<String, Object>> phaseResultsProcessorConfigs = ConfigurationUtils.readOptionalList(
        List<T> processors = new ArrayList<>();
import static org.opensearch.ingest.ConfigurationUtils.IGNORE_FAILURE_KEY;
        for (Processor responseProcessor : getSearchResponseProcessors()) {
import org.opensearch.ingest.ConfigurationUtils;
    private static String getProcessorKey(Processor processor) {
        List<Map<String, Object>> requestProcessorConfigs,
            phaseResultsProcessorFactories,
    static PipelineWithMetrics create(
    PipelineWithMetrics(
            totalResponseProcessingMetrics,
        super.onTransformRequestFailure();
import org.opensearch.OpenSearchParseException;
            totalRequestProcessingMetrics,
    }
                            + Arrays.toString(config.keySet().toArray())
        pipelineRequestMetrics.add(oldPipeline.pipelineRequestMetrics);
            responseProcessorFactories,
            for (Map.Entry<String, Object> entry : processorConfigWithKey.entrySet()) {
    ) throws Exception {
        Map<String, Processor.Factory<SearchRequestProcessor>> requestProcessorFactories,
                    + Arrays.toString(config.keySet().toArray())
        NamedWriteableRegistry namedWriteableRegistry,
        totalRequestMetrics.before();
    private final OperationMetrics pipelineResponseMetrics = new OperationMetrics();
            PHASE_PROCESSORS_KEY
        statsBuilder.addPipelineStats(getId(), pipelineRequestMetrics, pipelineResponseMetrics);
        if (config.isEmpty() == false) {
                    throw new OpenSearchParseException(
            if (newProcessorMetrics.containsKey(oldProcessorMetric.getKey())) {
        return Collections.unmodifiableList(processors);
            }
        Integer version = ConfigurationUtils.readIntProperty(null, null, config, VERSION_KEY, null);
                );
    private final OperationMetrics totalResponseMetrics;
                newProcessorMetrics.get(oldProcessorMetric.getKey()).add(oldProcessorMetric.getValue());
    @Override
        for (Map<String, Object> processorConfigWithKey : requestProcessorConfigs) {
    }
            phaseResultsProcessors,
        }
import java.util.Collections;
        );
            phaseResultsProcessors,
                        processorName = processorName + ":" + tag;
        this.totalRequestMetrics = totalRequestMetrics;
            responseProcessorMetrics.putIfAbsent(getProcessorKey(responseProcessor), new OperationMetrics());
        this.totalResponseMetrics = totalResponseMetrics;
        List<SearchRequestProcessor> requestProcessors = readProcessors(
            config,
                String tag = ConfigurationUtils.readOptionalStringProperty(null, null, config, TAG_KEY);
 */
        );
        return key;
        String description = ConfigurationUtils.readOptionalStringProperty(null, null, config, DESCRIPTION_KEY);
        List<SearchPhaseResultsProcessor> phaseResultsProcessors,
                    + id
    private final OperationMetrics pipelineRequestMetrics = new OperationMetrics();
        pipelineRequestMetrics.failed();
    private final Map<String, OperationMetrics> requestProcessorMetrics = new HashMap<>();
        String key = processor.getType();
                    + "] doesn't support one or more provided configuration parameters "
    @Override
        OperationMetrics totalResponseProcessingMetrics,
        super.afterTransformRequest(timeInNanos);
            throw new OpenSearchParseException(
        Map<String, Processor.Factory<T>> processorFactories,
                String description = ConfigurationUtils.readOptionalStringProperty(null, tag, config, DESCRIPTION_KEY);
/*
        Processor.PipelineContext pipelineContext
        super.afterTransformResponse(timeInNanos);
        }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        String description,
class PipelineWithMetrics extends Pipeline {
    private final Map<String, OperationMetrics> responseProcessorMetrics = new HashMap<>();
import java.util.HashMap;
        OperationMetrics totalResponseMetrics,
            id,
            relativeTimeSupplier
    }
            requestProcessorConfigs,
 * compatible open source license.
            responseProcessorConfigs,
        LongSupplier relativeTimeSupplier
            version,
        }
    protected void afterRequestProcessor(Processor processor, long timeInNanos) {
        Map<String, OperationMetrics> newProcessorMetrics,
    @Override
        }
            pipelineContext
    void populateStats(SearchPipelineStats.Builder statsBuilder) {
            requestProcessorFactories,
        Integer version,
        }
            null,
        List<SearchResponseProcessor> responseProcessors,
        for (Processor processor : getSearchRequestProcessors()) {
        List<SearchPhaseResultsProcessor> phaseResultsProcessors = readProcessors(
        pipelineResponseMetrics.failed();
    private static <T extends Processor> void copyProcessorMetrics(
    void copyMetrics(PipelineWithMetrics oldPipeline) {
        List<Map<String, Object>> responseProcessorConfigs = ConfigurationUtils.readOptionalList(
                    if (tag != null) {
        );
        OperationMetrics totalRequestMetrics,
        totalResponseMetrics.failed();
