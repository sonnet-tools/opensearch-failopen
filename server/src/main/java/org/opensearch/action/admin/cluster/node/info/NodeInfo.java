        public Builder setProcess(ProcessInfo process) {
import org.opensearch.search.pipeline.SearchPipelineInfo;
import org.opensearch.core.service.ReportingService;
        }
 * not use this file except in compliance with the License.
        if (settings == null) {
        addInfoIfNonNull(PluginsAndModules.class, in.readOptionalWriteable(PluginsAndModules::new));
            this.aggsInfo = aggsInfo;
        @Nullable PluginsAndModules plugins,
    /**
     * type safety of the storage of heterogeneous types of reporting service information.
        addInfoIfNonNull(AggregationInfo.class, in.readOptionalWriteable(AggregationInfo::new));
                aggsInfo,
     * Do not expose this map to other classes. For type safety, use {@link #getInfo(Class)}
    public NodeInfo(
 *
        private IngestInfo ingest;
    }
    private Build build;
        out.writeVInt(version.id);
                threadPool,
import org.opensearch.common.Nullable;
        public Builder setTotalIndexingBuffer(ByteSizeValue totalIndexingBuffer) {
        this.settings = settings;
        private Settings settings;
        out.writeOptionalWriteable(getInfo(AggregationInfo.class));
/*
        addInfoIfNonNull(ThreadPoolInfo.class, in.readOptionalWriteable(ThreadPoolInfo::new));
     * The current OpenSearch version
import java.io.IOException;
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
                settings,
    public String getHostname() {
        public Builder setAggsInfo(AggregationInfo aggsInfo) {
 * this file be licensed under the Apache-2.0 license or a
        addInfoIfNonNull(AggregationInfo.class, aggsInfo);
        public Builder setOs(OsInfo os) {
        addInfoIfNonNull(OsInfo.class, os);
     */
            this.plugins = plugins;
        private SearchPipelineInfo searchPipelineInfo;
                searchPipelineInfo
        return clazz.cast(infoMap.get(clazz));
        addInfoIfNonNull(HttpInfo.class, http);
 * Modifications Copyright OpenSearch Contributors. See
        DiscoveryNode node,
            return this;
        private ByteSizeValue totalIndexingBuffer;
            out.writeOptionalWriteable(getInfo(SearchPipelineInfo.class));
/*
    @Nullable
                process,
    public <T extends ReportingService.Info> T getInfo(Class<T> clazz) {
        }
import org.opensearch.action.support.nodes.BaseNodeResponse;
            Settings.writeSettingsToStream(settings, out);
    }
        if (totalIndexingBuffer == null) {
        }
        @Nullable ByteSizeValue totalIndexingBuffer,
        @Nullable Settings settings,
                http,
        return this.settings;
            infoMap.put(clazz, info);
            out.writeBoolean(true);
        }
            this.jvm = jvm;
        addInfoIfNonNull(ThreadPoolInfo.class, threadPool);
        public Builder setThreadPool(ThreadPoolInfo threadPool) {
            this.transport = transport;
        }
                plugins,
                os,
        }
        super(node);
import java.util.HashMap;
        return new Builder(version, build, node);
            return this;
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.ingest.IngestInfo;
        }
        }
import org.opensearch.transport.TransportInfo;
     * to retrieve items from this map and {@link #addInfoIfNonNull(Class, ReportingService.Info)}
        private TransportInfo transport;
import org.opensearch.core.common.io.stream.StreamInput;
        if (in.readBoolean()) {
        return this.build;
        private PluginsAndModules plugins;
        private AggregationInfo aggsInfo;
 * license agreements. See the NOTICE file distributed with
                version,
            this.os = os;
        addInfoIfNonNull(JvmInfo.class, jvm);
        private JvmInfo jvm;
 * GitHub history for details.
 */
        if (in.getVersion().onOrAfter(Version.V_2_7_0)) {
            return this;
        } else {
        public Builder setHttp(HttpInfo http) {
import org.opensearch.cluster.node.DiscoveryNode;
    public ByteSizeValue getTotalIndexingBuffer() {
        if (info != null) {
     * @param <T>   Specific subtype of ReportingService.Info to retrieve.
    /**
        public Builder setJvm(JvmInfo jvm) {
        @Nullable ProcessInfo process,
import org.opensearch.monitor.os.OsInfo;
            return this;
        } else {
        return getNode().getHostName();
            settings = Settings.readSettingsFromStream(in);
        out.writeBuild(build);
        private final Version version;
import org.opensearch.threadpool.ThreadPoolInfo;
        @Nullable SearchPipelineInfo searchPipelineInfo
    public Version getVersion() {
            this.version = version;
        }
            this.threadPool = threadPool;
 *
     *
            this.totalIndexingBuffer = totalIndexingBuffer;
public class NodeInfo extends BaseNodeResponse {
     * Builder class to accommodate new Info types being added to NodeInfo.
        private HttpInfo http;
    @Nullable
            return this;
 * @opensearch.internal
    public static NodeInfo.Builder builder(Version version, Build build, DiscoveryNode node) {
     */
        }
        this.version = version;
        addInfoIfNonNull(HttpInfo.class, in.readOptionalWriteable(HttpInfo::new));
        }
        addInfoIfNonNull(ProcessInfo.class, in.readOptionalWriteable(ProcessInfo::new));
import org.opensearch.Version;
        addInfoIfNonNull(IngestInfo.class, ingest);
        addInfoIfNonNull(JvmInfo.class, in.readOptionalWriteable(JvmInfo::new));
        Build build,
    }
        public Builder setTransport(TransportInfo transport) {
 * Node information (static, does not change over time).
            this.http = http;
            out.writeBoolean(true);
    }
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.Build;
     */
            this.settings = settings;
/**
     * System's hostname. <code>null</code> in case of UnknownHostException
    private Version version;
            return this;
import org.opensearch.common.settings.Settings;
 * compatible open source license.
        out.writeOptionalWriteable(getInfo(IngestInfo.class));
import org.opensearch.monitor.jvm.JvmInfo;
        build = in.readBuild();
     * The build version of the node.
            this.build = build;
        }
 */
                build,
import org.opensearch.core.common.unit.ByteSizeValue;
        @Nullable ThreadPoolInfo threadPool,
        this.totalIndexingBuffer = totalIndexingBuffer;
    public Settings getSettings() {
    /**
import org.opensearch.http.HttpInfo;
    @Nullable
        @Nullable IngestInfo ingest,
        public Builder setIngest(IngestInfo ingest) {
        @Nullable OsInfo os,
        return totalIndexingBuffer;
            totalIndexingBuffer = null;
    /**
     * The settings of the node.
        } else {
    }
        Version version,
        public Builder setSettings(Settings settings) {
        if (out.getVersion().onOrAfter(Version.V_2_7_0)) {
        addInfoIfNonNull(ProcessInfo.class, process);
     * work of explicit casts. This {@link NodeInfo} class guarantees type
                totalIndexingBuffer,
import org.opensearch.search.aggregations.support.AggregationInfo;
        this.build = build;
        out.writeOptionalWriteable(getInfo(OsInfo.class));
            this.node = node;
 * ownership. Elasticsearch licenses this file to you under
    }
     */
            out.writeBoolean(false);
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to
     * Get a particular info object, e.g. {@link JvmInfo} or {@link OsInfo}. This
 * Unless required by applicable law or agreed to in writing,
    }
    /**
 */
        addInfoIfNonNull(IngestInfo.class, in.readOptionalWriteable(IngestInfo::new));
     * safety for these stored info blocks.
            return this;
}
        private OsInfo os;
 * this work for additional information regarding copyright
        @Nullable HttpInfo http,
        if (in.readBoolean()) {
        }
        version = in.readVersion();
 * You may obtain a copy of the License at
    /**
        @Nullable AggregationInfo aggsInfo,
        }
     */
        out.writeOptionalWriteable(getInfo(JvmInfo.class));
        super(in);
    }
            this.searchPipelineInfo = searchPipelineInfo;
        }
    private ByteSizeValue totalIndexingBuffer;
            totalIndexingBuffer = new ByteSizeValue(in.readLong());
        out.writeOptionalWriteable(getInfo(TransportInfo.class));
     * to retrieve items from it.
    }
        public Builder setPlugins(PluginsAndModules plugins) {
     */
            return this;
            out.writeLong(totalIndexingBuffer.getBytes());
        out.writeOptionalWriteable(getInfo(HttpInfo.class));
        super.writeTo(out);
/*
 * Licensed to Elasticsearch under one or more contributor
            this.process = process;
 * the Apache License, Version 2.0 (the "License"); you may
        public Builder setSearchPipelineInfo(SearchPipelineInfo searchPipelineInfo) {
        }
        private Builder(Version version, Build build, DiscoveryNode node) {
        addInfoIfNonNull(TransportInfo.class, transport);
        }
        addInfoIfNonNull(TransportInfo.class, in.readOptionalWriteable(TransportInfo::new));
        private ThreadPoolInfo threadPool;
        }
            this.ingest = ingest;
     */
        }
        private final DiscoveryNode node;
        return version;
        addInfoIfNonNull(SearchPipelineInfo.class, searchPipelineInfo);
        out.writeOptionalWriteable(getInfo(ThreadPoolInfo.class));
        @Nullable TransportInfo transport,
            out.writeBoolean(false);
    public Build getBuild() {
    }
                transport,
                jvm,
 *     http://www.apache.org/licenses/LICENSE-2.0
            );
            return this;
            addInfoIfNonNull(SearchPipelineInfo.class, in.readOptionalWriteable(SearchPipelineInfo::new));
 * under the License.
import org.opensearch.monitor.process.ProcessInfo;
    private Settings settings;
    ) {
    /**
        private final Build build;
    private <T extends ReportingService.Info> void addInfoIfNonNull(Class<T> clazz, T info) {
    }
        private ProcessInfo process;
        addInfoIfNonNull(OsInfo.class, in.readOptionalWriteable(OsInfo::new));
        @Nullable JvmInfo jvm,
    @Nullable
 *
 * software distributed under the License is distributed on an
    private Map<Class<? extends ReportingService.Info>, ReportingService.Info> infoMap = new HashMap<>();
     * Add a value to the map of information blocks. This method guarantees the
 *
        public NodeInfo build() {
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
            return this;
                ingest,
            return new NodeInfo(
        out.writeOptionalWriteable(getInfo(ProcessInfo.class));
     * generic method handles all casting in order to spare client classes the
 */
        out.writeOptionalWriteable(getInfo(PluginsAndModules.class));
package org.opensearch.action.admin.cluster.node.info;
     * @return      An object of type T.
    public static class Builder {
            return this;
     */
        addInfoIfNonNull(PluginsAndModules.class, plugins);
        }
    public NodeInfo(StreamInput in) throws IOException {
    @Override
    @Nullable
                node,
 * KIND, either express or implied.  See the License for the
     * @param clazz Class for retrieval.
        }
            return this;
