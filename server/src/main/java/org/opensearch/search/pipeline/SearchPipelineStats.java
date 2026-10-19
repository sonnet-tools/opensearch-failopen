            this.responseStats = responseStats;
            out.writeVInt(responseProcessorFactoryStats.size());
            systemGeneratedProcessorStats = systemGeneratedProcessorMetrics.getProcessorStats();  
                List<ProcessorStats> responseProcessorStats = responseProcessorStatsPerPipeline.getOrDefault(
        }
            return processorName.equals(that.processorName) && processorType.equals(that.processorType) && stats.equals(that.stats);
    private final Map<String, PipelineDetailStats> perPipelineProcessorStats;
        builder.endObject();  
                && responseProcessorFactoryStats.equals(that.responseProcessorFactoryStats);
        List<PerPipelineStats> perPipelineStats,
        }
                    unmodifiableList(responseProcessorStats)
        builder.endObject();  
        @Override
        public ProcessorStats(String processorName, String processorType, OperationStats stats) {
        private void writeFactoryStatsArray(XContentBuilder builder, Params params, String fieldName, List<FactoryStats> stats)  
            PerPipelineStats that = (PerPipelineStats) o;  
            builder.startObject("stats");
            return Objects.hash(factoryType, evaluationStats, generationStats);  
            this.requestProcessorFactoryStats = requestProcessorFactoryStats;  
        }  
        this.totalRequestStats = new OperationStats(in);
        }
        }
        private void writeProcessorStatsArray(XContentBuilder builder, Params params, String fieldName, List<ProcessorStats> stats)  
            writeProcessorStatsArray(builder, params, "request_processors", requestProcessorStats);
                    pipelineStat.pipelineId,
        if (systemGeneratedProcessorStats != null) {
            return factoryType.equals(that.factoryType)
                processorStats.toXContent(builder, params);
        public PerPipelineStats(String pipelineId, OperationStats requestStats, OperationStats responseStats) {
        PipelineDetailStats systemGeneratedProcessorStats
    }
                List<ProcessorStats> requestProcessorStats = requestProcessorStatsPerPipeline.getOrDefault(
            for (ProcessorStats processorStats : stats) {  
            );
            PipelineDetailStats pipelineDetailStats = perPipelineProcessorStats.get(pipelineStat.pipelineId);
            evaluationStats.toXContent(builder, params);  
        this.perPipelineStats = perPipelineStats;  
        Builder withSystemGeneratedProcessorMetrics(@NonNull final SystemGeneratedProcessorMetrics systemGeneratedProcessorMetrics) {
            this.evaluationStats = evaluationStats;
            out.writeVInt(responseProcessorStats.size());
import java.util.Objects;  
        Builder withTotalStats(OperationMetrics totalRequestMetrics, OperationMetrics totalResponseMetrics) {
        FactoryDetailStats(StreamInput in) throws IOException {
            builder.endObject();
            this.processorName = processorName;  
        private final OperationStats evaluationStats;  
        FactoryDetailStats systemGeneratedFactoryStats,
        return builder;  
 * The OpenSearch Contributors require contributions made to  
            int numResponseProcessorFactories = in.readVInt();
        }
            return builder;  
            return stats;  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        if (in.getVersion().onOrAfter(Version.V_3_3_0)) {
            for (FactoryStats factoryStats : responseProcessorFactoryStats) {  
        private final String pipelineId;  
            out.writeString(processorType);
    @Override  
        public PipelineDetailStats(List<ProcessorStats> requestProcessorStats, List<ProcessorStats> responseProcessorStats) {
            systemGeneratedFactoryStats = systemGeneratedProcessorMetrics.getFactoryStats();
        public int hashCode() {
        private final String processorName; // type:tag
            stats.toXContent(builder, params);  
    }
        }  
    public void writeTo(StreamOutput out) throws IOException {
        public boolean equals(Object o) {  
    static class PerPipelineStats implements Writeable {
        String getProcessorName() {  
import java.util.ArrayList;
                responseProcessorStats.add(new ProcessorStats(in));
    static class FactoryDetailStats implements ToXContentFragment, Writeable {
    }
            evaluationStats = new OperationStats(in);
            perPipelineProcessorStats,
        }
        private final List<FactoryStats> requestProcessorFactoryStats;
        private final OperationStats stats;  
    @Override
        @Override
            builder.endObject();
    ) {  
        }
 * Serializable, immutable search pipeline statistics to be returned via stats APIs.
        }
            return requestStats;
            out.writeString(processorName);
        public int hashCode() {  
            return builder;  
            this.stats = stats;
        String getProcessorType() {
        private final OperationStats responseStats;
            this.requestStats = requestStats;  
                    emptyList()  
    }
            && systemGeneratedProcessorStats.equals(stats.systemGeneratedProcessorStats);
        out.writeVInt(perPipelineStats.size());
    }
            builder.endObject();
        this.totalResponseStats = new OperationStats(in);
            this.perPipelineStats.add(
        public boolean equals(Object o) {  
            this.responseProcessorFactoryStats = responseProcessorFactoryStats;
        }
        );
            out.writeVInt(requestProcessorFactoryStats.size());
            builder.endArray();
        }  
            builder.startObject("generation_stats");
        for (PerPipelineStats pipelineStat : perPipelineStats) {
            pipelineStat.responseStats.toXContent(builder, params);
        }
            if (o == null || getClass() != o.getClass()) return false;
            evaluationStats.writeTo(out);  
            int numRequestProcessorFactories = in.readVInt();
        }
        int size = in.readVInt();  
            builder.startObject("system_generated_factories");
            throws IOException {
        OperationStats getStats() {
            return processorType;
            if (o == null || getClass() != o.getClass()) return false;
    public int hashCode() {
/**  
    }
            return pipelineId.equals(that.pipelineId) && requestStats.equals(that.requestStats) && responseStats.equals(that.responseStats);
        return Objects.hash(  
            return responseStats;
            }
                    unmodifiableList(requestProcessorStats),
        OperationStats totalRequestStats,  
        FactoryStats(String factoryType, OperationStats evaluationStats, OperationStats generationStats) {  
            return processorName;
            for (ProcessorStats processorStats : responseProcessorStats) {  
            return Objects.hash(pipelineId, requestStats, responseStats);  
            return Objects.hash(requestProcessorStats, responseProcessorStats);
            responseProcessorFactoryStats = new ArrayList<>(numResponseProcessorFactories);
            return new SearchPipelineStats(  
        this.perPipelineProcessorStats = perPipelineProcessorStats;
        FactoryDetailStats(List<FactoryStats> requestProcessorFactoryStats, List<FactoryStats> responseProcessorFactoryStats) {
                builder.startObject();
import reactor.util.annotation.NonNull;  
            int numResponseProcessors = in.readVInt();
            pipelineStat.writeTo(out);  
        this.perPipelineProcessorStats = unmodifiableMap(pipelineDetailStatsMap);  
            PerPipelineStats perPipelineStat = new PerPipelineStats(in);
        @Override
                && evaluationStats.equals(that.evaluationStats)  
            systemGeneratedFactoryStats.writeTo(out);
            writeFactoryStatsArray(builder, params, "response_processor_factories", responseProcessorFactoryStats);
        private final OperationStats generationStats;
            for (int j = 0; j < numRequestProcessorFactories; j++) {
        private OperationStats totalResponseStats;  
            ProcessorStats that = (ProcessorStats) o;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            requestStats = new OperationStats(in);  
        public boolean equals(Object o) {
            for (PerPipelineStats pipelineStat : perPipelineStats) {  
        public void writeTo(StreamOutput out) throws IOException {  
            if (this == o) return true;
import org.opensearch.core.common.io.stream.Writeable;  
            systemGeneratedFactoryStats,
    static class Builder {
            perPipelineStats,  
        }  
                systemGeneratedFactoryStats,
        public List<ProcessorStats> requestProcessorStats() {
                factoryStats.writeTo(out);
                builder.endObject();  
    }  
        private final List<ProcessorStats> responseProcessorStats;  
        builder.startObject("search_pipeline");  
            for (int j = 0; j < numResponseProcessors; j++) {  
        }  
            FactoryStats that = (FactoryStats) o;
            && perPipelineStats.equals(stats.perPipelineStats)
            this.pipelineId = pipelineId;
        }  
            if (o == null || getClass() != o.getClass()) return false;
            for (int j = 0; j < numRequestProcessors; j++) {
    }  
        return totalResponseStats;
        private final Map<String, List<ProcessorStats>> requestProcessorStatsPerPipeline = new HashMap<>();
        }  
        totalResponseStats.writeTo(out);  
            perPipelineStats.add(perPipelineStat);
            out.writeVInt(requestProcessorStats.size());
        ) {
        }  
        }
                    pipelineStat.pipelineId,  
            pipelineId = in.readString();
        public int hashCode() {  
        public void writeTo(StreamOutput out) throws IOException {
            builder.startArray(fieldName);
            }
            if (this == o) return true;  
        }  
        }
        }
            pipelineDetailStatsMap.put(perPipelineStat.pipelineId, new PipelineDetailStats(in));  
            this.processorType = processorType;
            for (FactoryStats factoryStats : stats) {  
        }  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            for (int j = 0; j < numResponseProcessorFactories; j++) {  
        public boolean equals(Object o) {
            return Objects.hash(processorName, processorType, stats);
        }
            generationStats.toXContent(builder, params);  
            return this;
                );
            builder.startObject(processorName);  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                new PerPipelineStats(pipelineId, pipelineRequestMetrics.createStats(), pipelineResponseMetrics.createStats())  
                .add(new ProcessorStats(processorName, processorType, processorMetrics.createStats()));
        }
    }
 */  
    public SearchPipelineStats(
    public SearchPipelineStats(StreamInput in) throws IOException {  
        public String getPipelineId() {
        SearchPipelineStats stats = (SearchPipelineStats) o;
        Map<String, PipelineDetailStats> perPipelineProcessorStats,  
 *
 * compatible open source license.
            String processorName,
        return perPipelineProcessorStats;  
            systemGeneratedProcessorStats.toXContent(builder, params);  
            String processorType,
import static java.util.Collections.unmodifiableMap;
import java.util.TreeMap;
        }
import java.io.IOException;
            && totalResponseStats.equals(stats.totalResponseStats)  
            for (FactoryStats factoryStats : requestProcessorFactoryStats) {
            for (ProcessorStats processorStats : requestProcessorStats) {
                totalResponseStats,
        private PipelineDetailStats systemGeneratedProcessorStats = new PipelineDetailStats(emptyList(), emptyList());
            builder.endObject();  
            totalRequestStats,
            builder.startObject("system_generated_processors");
                .add(new ProcessorStats(processorName, processorType, processorMetrics.createStats()));  
import org.opensearch.core.xcontent.XContentBuilder;
                builder.startObject();
            builder.startObject("response");
import org.opensearch.common.metrics.OperationStats;  
        }
            out.writeString(factoryType);
    @Override
            this.factoryType = factoryType;
    static class ProcessorStats implements ToXContentFragment, Writeable {  
        this.totalResponseStats = totalResponseStats;
        private FactoryDetailStats systemGeneratedFactoryStats = new FactoryDetailStats(emptyList(), emptyList());
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                pipelineDetailStatsMap.put(pipelineStat.pipelineId, pipelineDetailStats);
            builder.endObject();
    private PipelineDetailStats systemGeneratedProcessorStats;  
        @Override
                processorStats.writeTo(out);  
        totalRequestStats.toXContent(builder, params);
}  
        }  
            builder.startArray(fieldName);
    public boolean equals(Object o) {
            this.responseProcessorStats = responseProcessorStats;
            builder.startObject(pipelineStat.pipelineId);  
            return requestProcessorStats.equals(that.requestProcessorStats) && responseProcessorStats.equals(that.responseProcessorStats);  
        public boolean equals(Object o) {
            int numRequestProcessors = in.readVInt();
            builder.endObject();
        Map<String, PipelineDetailStats> pipelineDetailStatsMap = new TreeMap<>();
            writeProcessorStatsArray(builder, params, "response_processors", responseProcessorStats);
            return requestProcessorFactoryStats.equals(that.requestProcessorFactoryStats)
        builder.startObject("total_request");
            );
            builder.endArray();
                responseProcessorFactoryStats.add(new FactoryStats(in));
            builder.startObject("evaluation_stats");
        }
            String pipelineId,  
            responseStats = new OperationStats(in);
            this.totalRequestStats = totalRequestMetrics.createStats();
            out.writeString(pipelineId);  
import org.opensearch.core.common.io.stream.StreamOutput;
package org.opensearch.search.pipeline;
        @Override
        public void writeTo(StreamOutput out) throws IOException {
        this.systemGeneratedProcessorStats = systemGeneratedProcessorStats;  
            if (this == o) return true;
            PipelineDetailStats pipelineDetailStats = perPipelineProcessorStats.get(pipelineStat.pipelineId);
                factoryStats.toXContent(builder, params);
        private final List<PerPipelineStats> perPipelineStats = new ArrayList<>();
                factoryStats.writeTo(out);  
    }
                requestProcessorStats.add(new ProcessorStats(in));
            }  
        }
            return this;
    }
            return responseProcessorStats;
            responseProcessorStats = new ArrayList<>(numResponseProcessors);
            }
            this.systemGeneratedProcessorStats = new PipelineDetailStats(in);  
            systemGeneratedFactoryStats.toXContent(builder, params);
        }
            builder.endObject();
            builder.endObject();  
        }
                processorStats.writeTo(out);
            }
            totalResponseStats,
import static java.util.Collections.emptyList;
            if (this == o) return true;
            }
    }
        private final String factoryType;
            }
        @Override  
import java.util.HashMap;  
import static java.util.Collections.unmodifiableList;  
            if (o == null || getClass() != o.getClass()) return false;  
            builder.field("type", factoryType);
            return this;
        @Override
    static class PipelineDetailStats implements ToXContentFragment, Writeable {
        @Override
            pipelineDetailStats.toXContent(builder, params);  
        @Override
        }
        private final Map<String, List<ProcessorStats>> responseProcessorStatsPerPipeline = new HashMap<>();  
        return perPipelineStats;
    OperationStats getTotalRequestStats() {
    Map<String, PipelineDetailStats> getPerPipelineProcessorStats() {
    OperationStats getTotalResponseStats() {  
        private final String processorType;
        }
            this.generationStats = generationStats;  
        }  
        @Override
        @Override  
        private final OperationStats requestStats;
        }
/*  
        }
        }
                );  
            return builder;  
        public int hashCode() {
                PipelineDetailStats pipelineDetailStats = new PipelineDetailStats(  
        public void writeTo(StreamOutput out) throws IOException {  
                unmodifiableMap(pipelineDetailStatsMap),
        return totalRequestStats.equals(stats.totalRequestStats)
        }
        if (o == null || getClass() != o.getClass()) return false;  
        public void writeTo(StreamOutput out) throws IOException {  
        OperationStats totalResponseStats,
            systemGeneratedProcessorStats.writeTo(out);  
import org.opensearch.core.xcontent.ToXContentFragment;
    private final List<PerPipelineStats> perPipelineStats;  
    private final OperationStats totalRequestStats;
        @Override
        }
            requestProcessorFactoryStats = new ArrayList<>(numRequestProcessorFactories);  
        private OperationStats totalRequestStats;
            return pipelineId;  
            builder.endObject();
            writeFactoryStatsArray(builder, params, "request_processor_factories", requestProcessorFactoryStats);
        }  
    }
 */
        }
        for (PerPipelineStats pipelineStat : perPipelineStats) {
        private final List<ProcessorStats> requestProcessorStats;
            stats.writeTo(out);  
    }
            return this;
        }  
            PipelineDetailStats that = (PipelineDetailStats) o;
            builder.endObject();  
        this.systemGeneratedFactoryStats = systemGeneratedFactoryStats;
        SearchPipelineStats build() {
        public List<ProcessorStats> responseProcessorStats() {  
            responseStats.writeTo(out);
            return requestProcessorStats;  
import org.opensearch.Version;
            systemGeneratedProcessorStats  
        if (this == o) return true;
        FactoryStats(StreamInput in) throws IOException {  
                unmodifiableList(perPipelineStats),  
            pipelineStat.requestStats.toXContent(builder, params);
            this.systemGeneratedFactoryStats = new FactoryDetailStats(in);
 * SPDX-License-Identifier: Apache-2.0
        this.perPipelineStats = unmodifiableList(perPipelineStats);
            Map<String, PipelineDetailStats> pipelineDetailStatsMap = new TreeMap<>();
            builder.startObject(factoryType);  
        public PerPipelineStats(StreamInput in) throws IOException {
        @Override  
            return Objects.hash(requestProcessorFactoryStats, responseProcessorFactoryStats);
        builder.startObject("total_response");
            OperationMetrics processorMetrics  
                && generationStats.equals(that.generationStats);
            return builder;  
            }  
            stats = new OperationStats(in);
    @Override  
                systemGeneratedProcessorStats  
import org.opensearch.core.common.io.stream.StreamInput;
                );
 *
            throws IOException {
        @Override
        for (int i = 0; i < size; i++) {  
            return this;
        public int hashCode() {
        }  
        if (systemGeneratedFactoryStats != null) {  
        builder.endObject();  
        builder.startObject("pipelines");
 * this file be licensed under the Apache-2.0 license or a
            this.requestProcessorStats = requestProcessorStats;  
            }
            }
        if (out.getVersion().onOrAfter(Version.V_3_3_0)) {
        public OperationStats getRequestStats() {  
            processorName = in.readString();  
        @Override
        Builder addRequestProcessorStats(String pipelineId, String processorName, String processorType, OperationMetrics processorMetrics) {
            this.requestProcessorStatsPerPipeline.computeIfAbsent(pipelineId, k -> new ArrayList<>())  
            pipelineDetailStats.writeTo(out);
import org.opensearch.common.metrics.OperationMetrics;
        }
import java.util.List;
            builder.field("type", processorType);
        public ProcessorStats(StreamInput in) throws IOException {
            if (this == o) return true;
        @Override
 * @opensearch.internal  
            processorType = in.readString();
            this.responseProcessorStatsPerPipeline.computeIfAbsent(pipelineId, k -> new ArrayList<>())
                totalRequestStats,
        }
            if (o == null || getClass() != o.getClass()) return false;  
        }  
            && perPipelineProcessorStats.equals(stats.perPipelineProcessorStats)
        @Override
        private final List<FactoryStats> responseProcessorFactoryStats;  
        }  
        Builder addResponseProcessorStats(
                builder.endObject();  
            && systemGeneratedFactoryStats.equals(stats.systemGeneratedFactoryStats)  
            builder.startObject("request");
        this.totalRequestStats = totalRequestStats;
        public PipelineDetailStats(StreamInput in) throws IOException {
public class SearchPipelineStats implements Writeable, ToXContentFragment {
        }
        @Override
            factoryType = in.readString();
        totalRequestStats.writeTo(out);
    static class FactoryStats implements ToXContentFragment, Writeable {
        List<PerPipelineStats> perPipelineStats = new ArrayList<>(size);
        }
    List<PerPipelineStats> getPipelineStats() {
        public OperationStats getResponseStats() {
        }
            generationStats.writeTo(out);
import java.util.Map;
    }
            }
            requestProcessorStats = new ArrayList<>(numRequestProcessors);  
            requestStats.writeTo(out);
            FactoryDetailStats that = (FactoryDetailStats) o;  
    private FactoryDetailStats systemGeneratedFactoryStats;
    }  
        Builder addPipelineStats(String pipelineId, OperationMetrics pipelineRequestMetrics, OperationMetrics pipelineResponseMetrics) {
        @Override  
        totalResponseStats.toXContent(builder, params);
    private final OperationStats totalResponseStats;
        return totalRequestStats;  
            generationStats = new OperationStats(in);  
                    emptyList()
            this.totalResponseStats = totalResponseMetrics.createStats();  
        builder.endObject();
                requestProcessorFactoryStats.add(new FactoryStats(in));
