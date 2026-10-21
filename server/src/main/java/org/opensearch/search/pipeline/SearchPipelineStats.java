            evaluationStats = new OperationStats(in);
        ) {
    private PipelineDetailStats systemGeneratedProcessorStats;
        private final List<ProcessorStats> requestProcessorStats;
        }
            return requestProcessorStats.equals(that.requestProcessorStats) && responseProcessorStats.equals(that.responseProcessorStats);
    }
            builder.endArray();
        @Override
import java.util.HashMap;
        }
            writeFactoryStatsArray(builder, params, "response_processor_factories", responseProcessorFactoryStats);
        }
        }
        for (PerPipelineStats pipelineStat : perPipelineStats) {
    private final Map<String, PipelineDetailStats> perPipelineProcessorStats;
            if (this == o) return true;
    public void writeTo(StreamOutput out) throws IOException {
        }
            systemGeneratedProcessorStats
    }
        private final List<FactoryStats> responseProcessorFactoryStats;
            builder.endObject();
        public PipelineDetailStats(StreamInput in) throws IOException {
            String processorName,
        public int hashCode() {
        }
            return requestStats;
        }
/*
                processorStats.writeTo(out);
        @Override
        }
            builder.startObject("evaluation_stats");
        @Override
        }
    static class PerPipelineStats implements Writeable {
            this.responseProcessorStats = responseProcessorStats;
            for (int j = 0; j < numRequestProcessorFactories; j++) {
            builder.endObject();
            }
            builder.endObject();
import org.opensearch.core.xcontent.XContentBuilder;
            for (FactoryStats factoryStats : stats) {
        private void writeProcessorStatsArray(XContentBuilder builder, Params params, String fieldName, List<ProcessorStats> stats)
            builder.endObject();
            if (o == null || getClass() != o.getClass()) return false;
                && generationStats.equals(that.generationStats);
        this.totalRequestStats = totalRequestStats;
        private PipelineDetailStats systemGeneratedProcessorStats = new PipelineDetailStats(emptyList(), emptyList());
                processorStats.writeTo(out);
    Map<String, PipelineDetailStats> getPerPipelineProcessorStats() {
 * The OpenSearch Contributors require contributions made to
            stats = new OperationStats(in);
                .add(new ProcessorStats(processorName, processorType, processorMetrics.createStats()));
        String getProcessorName() {
            }
                );
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        return totalRequestStats.equals(stats.totalRequestStats)
        }
        }
            generationStats.toXContent(builder, params);
        @Override
            PipelineDetailStats that = (PipelineDetailStats) o;
            stats.writeTo(out);
            this.generationStats = generationStats;
import static java.util.Collections.unmodifiableList;
            out.writeString(factoryType);
        Builder withTotalStats(OperationMetrics totalRequestMetrics, OperationMetrics totalResponseMetrics) {
            if (this == o) return true;
            }
        builder.startObject("search_pipeline");
            return requestProcessorStats;
        public void writeTo(StreamOutput out) throws IOException {
            responseProcessorStats = new ArrayList<>(numResponseProcessors);
    static class ProcessorStats implements ToXContentFragment, Writeable {
            out.writeString(pipelineId);
                    emptyList()
        public boolean equals(Object o) {
            this.requestProcessorStatsPerPipeline.computeIfAbsent(pipelineId, k -> new ArrayList<>())
            this.evaluationStats = evaluationStats;
            writeFactoryStatsArray(builder, params, "request_processor_factories", requestProcessorFactoryStats);
        for (PerPipelineStats pipelineStat : perPipelineStats) {
            return this;
        totalRequestStats.toXContent(builder, params);
            for (int j = 0; j < numRequestProcessors; j++) {
        builder.startObject("total_request");
            builder.startObject("system_generated_processors");
        SearchPipelineStats build() {
            Map<String, PipelineDetailStats> pipelineDetailStatsMap = new TreeMap<>();
                );
        }
            return this;
    @Override
        }
            builder.field("type", processorType);
import org.opensearch.Version;
            return new SearchPipelineStats(
 * Serializable, immutable search pipeline statistics to be returned via stats APIs.
            systemGeneratedFactoryStats,
        PipelineDetailStats systemGeneratedProcessorStats
 *
        );
            perPipelineStats.add(perPipelineStat);
            generationStats.writeTo(out);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            PipelineDetailStats pipelineDetailStats = perPipelineProcessorStats.get(pipelineStat.pipelineId);
        }
            builder.startObject(processorName);
            for (ProcessorStats processorStats : stats) {
            return builder;
package org.opensearch.search.pipeline;
        }
            return requestProcessorFactoryStats.equals(that.requestProcessorFactoryStats)
            return Objects.hash(requestProcessorFactoryStats, responseProcessorFactoryStats);
        @Override
        this.totalResponseStats = totalResponseStats;
        }
            systemGeneratedFactoryStats.writeTo(out);
        private final OperationStats stats;
            return responseProcessorStats;
        }
            int numRequestProcessors = in.readVInt();
    }
        }
            return builder;
    public int hashCode() {
            }
            pipelineDetailStats.toXContent(builder, params);
            builder.endObject();
        private final List<ProcessorStats> responseProcessorStats;
        totalRequestStats.writeTo(out);
                List<ProcessorStats> responseProcessorStats = responseProcessorStatsPerPipeline.getOrDefault(
            this.processorType = processorType;
            perPipelineStats,
    @Override
        this.perPipelineProcessorStats = unmodifiableMap(pipelineDetailStatsMap);
            return processorName;
            && perPipelineProcessorStats.equals(stats.perPipelineProcessorStats)
            writeProcessorStatsArray(builder, params, "response_processors", responseProcessorStats);
            return responseStats;
            );
            this.requestProcessorFactoryStats = requestProcessorFactoryStats;
            out.writeString(processorName);
            pipelineStat.responseStats.toXContent(builder, params);
            systemGeneratedFactoryStats.toXContent(builder, params);
        if (systemGeneratedProcessorStats != null) {
            && totalResponseStats.equals(stats.totalResponseStats)
        }
    }
        private final Map<String, List<ProcessorStats>> requestProcessorStatsPerPipeline = new HashMap<>();
        public void writeTo(StreamOutput out) throws IOException {
            responseProcessorFactoryStats = new ArrayList<>(numResponseProcessorFactories);
    private final OperationStats totalResponseStats;
        }
                    unmodifiableList(requestProcessorStats),
            this.responseProcessorFactoryStats = responseProcessorFactoryStats;
            responseStats.writeTo(out);
        public void writeTo(StreamOutput out) throws IOException {
        return totalResponseStats;
        private final Map<String, List<ProcessorStats>> responseProcessorStatsPerPipeline = new HashMap<>();
    ) {
        List<PerPipelineStats> perPipelineStats = new ArrayList<>(size);
        }
            if (this == o) return true;
        @Override
                requestProcessorStats.add(new ProcessorStats(in));
        @Override
        for (int i = 0; i < size; i++) {
import reactor.util.annotation.NonNull;
            requestProcessorStats = new ArrayList<>(numRequestProcessors);
        public List<ProcessorStats> requestProcessorStats() {
            int numResponseProcessorFactories = in.readVInt();
            if (o == null || getClass() != o.getClass()) return false;
        public ProcessorStats(String processorName, String processorType, OperationStats stats) {
                totalRequestStats,
            builder.endObject();
                pipelineDetailStatsMap.put(pipelineStat.pipelineId, pipelineDetailStats);
        }
                );
        builder.startObject("pipelines");
            builder.endObject();
                .add(new ProcessorStats(processorName, processorType, processorMetrics.createStats()));
        FactoryStats(StreamInput in) throws IOException {
        public int hashCode() {
            for (FactoryStats factoryStats : responseProcessorFactoryStats) {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            this.responseStats = responseStats;
        if (in.getVersion().onOrAfter(Version.V_3_3_0)) {
    OperationStats getTotalResponseStats() {
        }
    static class FactoryStats implements ToXContentFragment, Writeable {
            this.responseProcessorStatsPerPipeline.computeIfAbsent(pipelineId, k -> new ArrayList<>())
            }
        public void writeTo(StreamOutput out) throws IOException {
        FactoryDetailStats(StreamInput in) throws IOException {
        @Override
                new PerPipelineStats(pipelineId, pipelineRequestMetrics.createStats(), pipelineResponseMetrics.createStats())
        this.totalResponseStats = new OperationStats(in);
import java.util.ArrayList;
        public boolean equals(Object o) {
            systemGeneratedProcessorStats.writeTo(out);
            if (o == null || getClass() != o.getClass()) return false;
            responseStats = new OperationStats(in);
        }
            );
        }
import org.opensearch.core.common.io.stream.Writeable;
            processorName = in.readString();
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            requestStats.writeTo(out);
        if (out.getVersion().onOrAfter(Version.V_3_3_0)) {
        List<PerPipelineStats> perPipelineStats,
import static java.util.Collections.emptyList;
import org.opensearch.common.metrics.OperationMetrics;
        public int hashCode() {
        }
            builder.startObject("generation_stats");
        FactoryDetailStats(List<FactoryStats> requestProcessorFactoryStats, List<FactoryStats> responseProcessorFactoryStats) {
            pipelineStat.requestStats.toXContent(builder, params);
 * compatible open source license.
        public boolean equals(Object o) {
        builder.startObject("total_response");
        public OperationStats getResponseStats() {
            requestStats = new OperationStats(in);
        @Override
        totalResponseStats.toXContent(builder, params);
            totalRequestStats,
    List<PerPipelineStats> getPipelineStats() {
        }
        private final String processorName; // type:tag
        private final List<PerPipelineStats> perPipelineStats = new ArrayList<>();
            PipelineDetailStats pipelineDetailStats = perPipelineProcessorStats.get(pipelineStat.pipelineId);
            this.factoryType = factoryType;
            return builder;
            }
            PerPipelineStats perPipelineStat = new PerPipelineStats(in);
        if (this == o) return true;
        }
            this.requestStats = requestStats;
            this.totalResponseStats = totalResponseMetrics.createStats();
            this.perPipelineStats.add(
        Builder addPipelineStats(String pipelineId, OperationMetrics pipelineRequestMetrics, OperationMetrics pipelineResponseMetrics) {
            return Objects.hash(requestProcessorStats, responseProcessorStats);
            builder.startObject("system_generated_factories");
        return perPipelineProcessorStats;
    @Override
    }
        }
        builder.endObject();
        }
        private final OperationStats evaluationStats;
import java.util.TreeMap;
                    pipelineStat.pipelineId,
        out.writeVInt(perPipelineStats.size());
    OperationStats getTotalRequestStats() {
            this.processorName = processorName;
            return factoryType.equals(that.factoryType)
            this.systemGeneratedFactoryStats = new FactoryDetailStats(in);
            }
import org.opensearch.core.common.io.stream.StreamInput;
        }
        }
            perPipelineProcessorStats,
        public ProcessorStats(StreamInput in) throws IOException {
        return totalRequestStats;
public class SearchPipelineStats implements Writeable, ToXContentFragment {
                factoryStats.writeTo(out);
        totalResponseStats.writeTo(out);
        builder.endObject();
        @Override
        public String getPipelineId() {
        builder.endObject();
        private final OperationStats responseStats;
                unmodifiableMap(pipelineDetailStatsMap),
            && systemGeneratedFactoryStats.equals(stats.systemGeneratedFactoryStats)
                processorStats.toXContent(builder, params);
        }
                    pipelineStat.pipelineId,
    }
    @Override
        }
    }
                builder.startObject();
 *
        }
            return stats;
        private final String factoryType;
        this.perPipelineProcessorStats = perPipelineProcessorStats;
            evaluationStats.writeTo(out);
            if (this == o) return true;
        private OperationStats totalResponseStats;
            return this;
            }
            factoryType = in.readString();
        }
import static java.util.Collections.unmodifiableMap;
            this.stats = stats;
    }
                builder.endObject();
 */
            return processorType;
        int size = in.readVInt();
            processorType = in.readString();
            out.writeVInt(responseProcessorStats.size());
        }
            this.totalRequestStats = totalRequestMetrics.createStats();
 * this file be licensed under the Apache-2.0 license or a
        if (systemGeneratedFactoryStats != null) {
            builder.startObject("response");
                totalResponseStats,
            return processorName.equals(that.processorName) && processorType.equals(that.processorType) && stats.equals(that.stats);
                requestProcessorFactoryStats.add(new FactoryStats(in));
        Builder addResponseProcessorStats(
import java.util.Objects;
            ProcessorStats that = (ProcessorStats) o;
        }
        public boolean equals(Object o) {
            return builder;
        return Objects.hash(
            stats.toXContent(builder, params);
            builder.startObject(pipelineStat.pipelineId);
        @Override
        }
            systemGeneratedProcessorStats.toXContent(builder, params);
        @Override
        private final OperationStats generationStats;
                builder.startObject();
        public void writeTo(StreamOutput out) throws IOException {
            return Objects.hash(pipelineId, requestStats, responseStats);
        }
    public SearchPipelineStats(StreamInput in) throws IOException {
            pipelineDetailStats.writeTo(out);
    }
            return pipelineId.equals(that.pipelineId) && requestStats.equals(that.requestStats) && responseStats.equals(that.responseStats);
            requestProcessorFactoryStats = new ArrayList<>(numRequestProcessorFactories);
    }
            builder.endObject();
        public PerPipelineStats(String pipelineId, OperationStats requestStats, OperationStats responseStats) {
        this.systemGeneratedFactoryStats = systemGeneratedFactoryStats;
                factoryStats.writeTo(out);
            if (this == o) return true;
import org.opensearch.core.xcontent.ToXContentFragment;
            return this;
        }
            builder.field("type", factoryType);
        public int hashCode() {
            pipelineDetailStatsMap.put(perPipelineStat.pipelineId, new PipelineDetailStats(in));
        Builder addRequestProcessorStats(String pipelineId, String processorName, String processorType, OperationMetrics processorMetrics) {
    }
            systemGeneratedFactoryStats = systemGeneratedProcessorMetrics.getFactoryStats();
        SearchPipelineStats stats = (SearchPipelineStats) o;
        Builder withSystemGeneratedProcessorMetrics(@NonNull final SystemGeneratedProcessorMetrics systemGeneratedProcessorMetrics) {
        String getProcessorType() {
            }
        private void writeFactoryStatsArray(XContentBuilder builder, Params params, String fieldName, List<FactoryStats> stats)
        }
        }
                factoryStats.toXContent(builder, params);
        public OperationStats getRequestStats() {
        private final String processorType;
            String processorType,
        @Override
        public List<ProcessorStats> responseProcessorStats() {
        this.perPipelineStats = perPipelineStats;
            pipelineId = in.readString();
        FactoryDetailStats systemGeneratedFactoryStats,
            if (o == null || getClass() != o.getClass()) return false;
        public int hashCode() {
        public PerPipelineStats(StreamInput in) throws IOException {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            out.writeVInt(requestProcessorFactoryStats.size());
        @Override
 * @opensearch.internal
        if (o == null || getClass() != o.getClass()) return false;
/**
        builder.endObject();
            return pipelineId;
                && evaluationStats.equals(that.evaluationStats)
            }
        @Override
import org.opensearch.core.common.io.stream.StreamOutput;
            return Objects.hash(processorName, processorType, stats);
        @Override
                && responseProcessorFactoryStats.equals(that.responseProcessorFactoryStats);
        return builder;
        OperationStats totalRequestStats,
        return perPipelineStats;
                    unmodifiableList(responseProcessorStats)
    public boolean equals(Object o) {
            out.writeVInt(requestProcessorStats.size());
            for (int j = 0; j < numResponseProcessorFactories; j++) {
            for (FactoryStats factoryStats : requestProcessorFactoryStats) {
            this.requestProcessorStats = requestProcessorStats;
import java.io.IOException;
            builder.endObject();
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                systemGeneratedProcessorStats
            generationStats = new OperationStats(in);
            int numResponseProcessors = in.readVInt();
import java.util.Map;
            throws IOException {
        public PipelineDetailStats(List<ProcessorStats> requestProcessorStats, List<ProcessorStats> responseProcessorStats) {
        }
        this.perPipelineStats = unmodifiableList(perPipelineStats);
            OperationMetrics processorMetrics
        }
        }
            && perPipelineStats.equals(stats.perPipelineStats)
        OperationStats totalResponseStats,
}
            for (ProcessorStats processorStats : requestProcessorStats) {
    }
    private FactoryDetailStats systemGeneratedFactoryStats;
            out.writeString(processorType);
    public SearchPipelineStats(
            PerPipelineStats that = (PerPipelineStats) o;
            return this;
        FactoryStats(String factoryType, OperationStats evaluationStats, OperationStats generationStats) {
            for (PerPipelineStats pipelineStat : perPipelineStats) {
            builder.endArray();
            builder.startObject(factoryType);
            builder.endObject();
        private final List<FactoryStats> requestProcessorFactoryStats;
            builder.startArray(fieldName);
    private final List<PerPipelineStats> perPipelineStats;
        @Override
    }
        private final OperationStats requestStats;
import java.util.List;
            totalResponseStats,
            systemGeneratedProcessorStats = systemGeneratedProcessorMetrics.getProcessorStats();
            && systemGeneratedProcessorStats.equals(stats.systemGeneratedProcessorStats);
                PipelineDetailStats pipelineDetailStats = new PipelineDetailStats(
            writeProcessorStatsArray(builder, params, "request_processors", requestProcessorStats);
                List<ProcessorStats> requestProcessorStats = requestProcessorStatsPerPipeline.getOrDefault(
            String pipelineId,
        this.systemGeneratedProcessorStats = systemGeneratedProcessorStats;
                systemGeneratedFactoryStats,
        private OperationStats totalRequestStats;
        }
            return Objects.hash(factoryType, evaluationStats, generationStats);
            pipelineStat.writeTo(out);
        }
                responseProcessorFactoryStats.add(new FactoryStats(in));
                responseProcessorStats.add(new ProcessorStats(in));
        }
            int numRequestProcessorFactories = in.readVInt();
            builder.startArray(fieldName);
            builder.startObject("stats");
    private final OperationStats totalRequestStats;
                builder.endObject();
 */
    static class FactoryDetailStats implements ToXContentFragment, Writeable {
        @Override
            for (int j = 0; j < numResponseProcessors; j++) {
        @Override
        this.totalRequestStats = new OperationStats(in);
            this.pipelineId = pipelineId;
    }
                    emptyList()
    }
        }
            throws IOException {
    static class PipelineDetailStats implements ToXContentFragment, Writeable {
            FactoryDetailStats that = (FactoryDetailStats) o;
            FactoryStats that = (FactoryStats) o;
        private final String pipelineId;
            builder.startObject("request");
            evaluationStats.toXContent(builder, params);
            }
        private FactoryDetailStats systemGeneratedFactoryStats = new FactoryDetailStats(emptyList(), emptyList());
    }
            for (ProcessorStats processorStats : responseProcessorStats) {
 * SPDX-License-Identifier: Apache-2.0
        OperationStats getStats() {
        }
import org.opensearch.common.metrics.OperationStats;
            out.writeVInt(responseProcessorFactoryStats.size());
    static class Builder {
        Map<String, PipelineDetailStats> perPipelineProcessorStats,
        }
                unmodifiableList(perPipelineStats),
        Map<String, PipelineDetailStats> pipelineDetailStatsMap = new TreeMap<>();
            this.systemGeneratedProcessorStats = new PipelineDetailStats(in);
