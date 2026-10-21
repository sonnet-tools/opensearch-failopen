            return stats;
                    processorStat.getStats().toXContent(builder, params);
        }
 * compatible open source license.
            return type;
import org.opensearch.core.xcontent.XContentBuilder;
 * GitHub history for details.
            if (this == o) return true;
        this.totalStats = new OperationStats(in);
            builder.startArray("processors");
import java.util.Objects;
    }
        }
            this.stats = stats;
        private final String pipelineId;
            this.processorStats.put(pipelineId, processorStatsPerPipeline);
        public String getPipelineId() {
        builder.endObject();
        return totalStats;
    /**
    @Override
        for (PipelineStat pipelineStat : pipelineStats) {
                    builder.startObject(processorStat.getName());
 * this file be licensed under the Apache-2.0 license or a
            } else {
    private final List<PipelineStat> pipelineStats;
                    processorStat.getStats().writeTo(out);
            builder.startObject(pipelineStat.getPipelineId());
     *                   and pipeline stats are logically the sum of the processor stats.
        public String getName() {
public class IngestStats implements Writeable, ToXContentFragment {
        public boolean equals(Object o) {
            this.pipelineStats.add(new PipelineStat(pipelineId, pipelineMetric.createStats()));
import org.opensearch.core.common.io.stream.StreamInput;
                }
            return Objects.equals(name, that.name) && Objects.equals(type, that.type) && Objects.equals(stats, that.stats);
 * Licensed to Elasticsearch under one or more contributor
            out.writeString(pipelineStat.getPipelineId());
 * Modifications Copyright OpenSearch Contributors. See
            return Objects.equals(pipelineId, that.pipelineId) && Objects.equals(stats, that.stats);
        }
            IngestStats.ProcessorStat that = (IngestStats.ProcessorStat) o;
        public PipelineStat(String pipelineId, OperationStats stats) {
import org.opensearch.core.common.io.stream.StreamOutput;
        this.pipelineStats = pipelineStats;
    @Override
                }
        @Override
        private Map<String, List<ProcessorStat>> processorStats = new HashMap<>();
            String pipelineId = in.readString();
    }
    static class Builder {
        private OperationStats totalStats;
                    out.writeString(processorStat.getName());
     */
                    builder.startObject("stats");
/*
        private final String type;
 * You may obtain a copy of the License at
     */
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                for (ProcessorStat processorStat : processorStatsForPipeline) {
                String processorType = "_NOT_AVAILABLE";
 * the Apache License, Version 2.0 (the "License"); you may
            builder.endArray();
        }
        builder.startObject("total");
                    builder.startObject();
 * specific language governing permissions and limitations
            this.type = type;
 *
 * The OpenSearch Contributors require contributions made to
    }
        int size = in.readVInt();
 */
    public List<PipelineStat> getPipelineStats() {
 * software distributed under the License is distributed on an
}
import java.util.HashMap;
            builder.endObject();
            List<ProcessorStat> processorStatsForPipeline = processorStats.get(pipelineStat.getPipelineId());
                    builder.endObject();
import java.util.Collections;
            pipelineStat.getStats().writeTo(out);
        this.processorStats = new HashMap<>(size);
                .add(new ProcessorStat(processorName, processorType, metric.createStats()));
 * @opensearch.internal
        }
import java.util.Map;
     */
            return name;
    }
import java.util.ArrayList;
                OperationStats processorStat = new OperationStats(in);
import org.opensearch.common.metrics.OperationStats;
        IngestStats that = (IngestStats) o;
        out.writeVInt(pipelineStats.size());
            List<ProcessorStat> processorStatsForPipeline = processorStats.get(pipelineStat.getPipelineId());
            int processorsSize = in.readVInt();
        }
    public OperationStats getTotalStats() {
        return processorStats;
        }
     */
                out.writeVInt(0);
    }
import org.opensearch.common.metrics.OperationMetrics;
        this.totalStats = totalStats;
import org.opensearch.core.common.io.stream.Writeable;
        builder.startObject("pipelines");
        }
    public Map<String, List<ProcessorStat>> getProcessorStats() {
    private final Map<String, List<ProcessorStat>> processorStats;
            this.name = name;
/*
        this.pipelineStats = new ArrayList<>(size);
 * not use this file except in compliance with the License.
        }
/**
    }
        public ProcessorStat(String name, String type, OperationStats stats) {
    }
        IngestStats build() {
        }
    public static class PipelineStat {
 * ownership. Elasticsearch licenses this file to you under
                    builder.field("type", processorStat.getType());
        if (o == null || getClass() != o.getClass()) return false;
    /**
            for (int j = 0; j < processorsSize; j++) {
    public IngestStats(OperationStats totalStats, List<PipelineStat> pipelineStats, Map<String, List<ProcessorStat>> processorStats) {
                    out.writeString(processorStat.getType());
        return Objects.equals(totalStats, that.totalStats)
    public static class ProcessorStat {
            return pipelineId;
        return pipelineStats;
            if (this == o) return true;
package org.opensearch.ingest;
    }
            if (o == null || getClass() != o.getClass()) return false;
            this.stats = stats;
    /**
        }
    public boolean equals(Object o) {
        if (this == o) return true;
     * Container for pipeline stats.
 *
        Builder addPipelineMetrics(String pipelineId, OperationMetrics pipelineMetric) {
        @Override
        private final OperationStats stats;
        builder.endObject();
    /**
 * OperationStats for an ingest processor pipeline
    public int hashCode() {
        private final OperationStats stats;
        }
            return Objects.hash(pipelineId, stats);
            return this;
    }
            }
            IngestStats.PipelineStat that = (IngestStats.PipelineStat) o;
        builder.startObject("ingest");
    public IngestStats(StreamInput in) throws IOException {
            this.processorStats.computeIfAbsent(pipelineId, k -> new ArrayList<>())
 */
    public void writeTo(StreamOutput out) throws IOException {
/*
            }
            OperationStats pipelineStat = new OperationStats(in);
        }
            && Objects.equals(pipelineStats, that.pipelineStats)
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final OperationStats totalStats;
        private final String name;
        Builder addProcessorMetrics(String pipelineId, String processorName, String processorType, OperationMetrics metric) {
 *
        Builder addTotalMetrics(OperationMetrics totalMetric) {
            return this;
     * Read from a stream.
 *
        public String getType() {
            this.pipelineStats.add(new PipelineStat(pipelineId, pipelineStat));
     * @param pipelineStats - The stats for a given ingest pipeline.
                processorStatsPerPipeline.add(new ProcessorStat(processorName, processorType, processorStat));
import java.io.IOException;
        public boolean equals(Object o) {
    @Override
 * Unless required by applicable law or agreed to in writing,
            return stats;
            pipelineStat.getStats().toXContent(builder, params);
 * SPDX-License-Identifier: Apache-2.0
        return builder;
     * Easy conversion from scoped {@link OperationMetrics} objects to a serializable OperationStats objects
        totalStats.toXContent(builder, params);
            this.pipelineId = pipelineId;
        for (PipelineStat pipelineStat : pipelineStats) {
        }
        }
                for (ProcessorStat processorStat : processorStatsForPipeline) {
import java.util.List;
        @Override
    }
        private List<PipelineStat> pipelineStats = new ArrayList<>();
            return this;
                    builder.endObject();
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.xcontent.ToXContentFragment;
 */
 * this work for additional information regarding copyright
        public int hashCode() {
                    builder.endObject();
            }
        }
        }
            if (processorStatsForPipeline != null) {
    @Override
        public int hashCode() {
        this.processorStats = processorStats;
 * under the License.
     * Container for processor stats.
        builder.endObject();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @param processorStats - The per-processor stats for a given pipeline. A map keyed by the pipeline identifier.
        return Objects.hash(totalStats, pipelineStats, processorStats);
    }
 */
                String processorName = in.readString();
        for (int i = 0; i < size; i++) {
                out.writeVInt(processorStatsForPipeline.size());
        totalStats.writeTo(out);
 * KIND, either express or implied.  See the License for the
            this.totalStats = totalMetric.createStats();
     * @param totalStats - The total stats for Ingest. This is the logically the sum of all pipeline stats,
            && Objects.equals(processorStats, that.processorStats);
            List<ProcessorStat> processorStatsPerPipeline = new ArrayList<>(processorsSize);
            if (o == null || getClass() != o.getClass()) return false;
            return Objects.hash(name, type, stats);
        }
    /**
            return new IngestStats(totalStats, Collections.unmodifiableList(pipelineStats), Collections.unmodifiableMap(processorStats));
    }
     */
            if (processorStatsForPipeline == null) {
        public OperationStats getStats() {
        @Override
        public OperationStats getStats() {
                processorType = in.readString();
