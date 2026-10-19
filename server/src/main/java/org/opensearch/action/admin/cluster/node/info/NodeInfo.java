     * to retrieve items from this map and {@link #addInfoIfNonNull(Class, ReportingService.Info)}
     * safety for these stored info blocks.
            out.writeBoolean(false);
        private IngestInfo ingest;
    /**
        out.writeOptionalWriteable(getInfo(TransportInfo.class));
import org.opensearch.http.HttpInfo;
 */  
        out.writeOptionalWriteable(getInfo(IngestInfo.class));
import org.opensearch.cluster.node.DiscoveryNode;
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
                os,
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
     */
        addInfoIfNonNull(JvmInfo.class, jvm);
            this.threadPool = threadPool;
        private TransportInfo transport;
    }
     * @return      An object of type T.
        return this.settings;  
        out.writeOptionalWriteable(getInfo(ThreadPoolInfo.class));
            out.writeLong(totalIndexingBuffer.getBytes());
package org.opensearch.action.admin.cluster.node.info;
            this.build = build;
        }
     * work of explicit casts. This {@link NodeInfo} class guarantees type  
        }
            return this;
        if (in.readBoolean()) {
            settings = Settings.readSettingsFromStream(in);
        @Nullable JvmInfo jvm,  
 *
    private Version version;
     */  
     */
        version = in.readVersion();
        }  
        } else {  
        super(node);
        addInfoIfNonNull(PluginsAndModules.class, plugins);
    public String getHostname() {
import org.opensearch.monitor.jvm.JvmInfo;
    @Nullable  
        addInfoIfNonNull(IngestInfo.class, in.readOptionalWriteable(IngestInfo::new));
                build,
import org.opensearch.Build;
    /**  
            this.process = process;  
    public void writeTo(StreamOutput out) throws IOException {  
/*  
        @Nullable OsInfo os,
     * Get a particular info object, e.g. {@link JvmInfo} or {@link OsInfo}. This
            this.http = http;
    public static class Builder {
            this.settings = settings;
    private <T extends ReportingService.Info> void addInfoIfNonNull(Class<T> clazz, T info) {
        out.writeOptionalWriteable(getInfo(OsInfo.class));
                threadPool,
        super.writeTo(out);
 *
    /**  
        @Nullable SearchPipelineInfo searchPipelineInfo
    public <T extends ReportingService.Info> T getInfo(Class<T> clazz) {
 * this work for additional information regarding copyright
                searchPipelineInfo
                jvm,  
        return new Builder(version, build, node);
            this.os = os;
        if (info != null) {  
        out.writeOptionalWriteable(getInfo(HttpInfo.class));  
     * Builder class to accommodate new Info types being added to NodeInfo.
    /**
import org.opensearch.Version;
        addInfoIfNonNull(AggregationInfo.class, aggsInfo);
    }  
        }
        return this.build;
        }
        private OsInfo os;
 * KIND, either express or implied.  See the License for the
            this.node = node;  
        if (in.getVersion().onOrAfter(Version.V_2_7_0)) {  
                transport,
}
 * specific language governing permissions and limitations
            return this;  
                ingest,
     * to retrieve items from it.
        private Settings settings;  
        out.writeVInt(version.id);
 * software distributed under the License is distributed on an
        }
                aggsInfo,  
        addInfoIfNonNull(IngestInfo.class, ingest);  
        if (in.readBoolean()) {  
     * Add a value to the map of information blocks. This method guarantees the
            this.totalIndexingBuffer = totalIndexingBuffer;
        this.totalIndexingBuffer = totalIndexingBuffer;  
 * ownership. Elasticsearch licenses this file to you under  
            return this;
        addInfoIfNonNull(TransportInfo.class, in.readOptionalWriteable(TransportInfo::new));
            out.writeBoolean(true);
    public Settings getSettings() {
    }
        public Builder setOs(OsInfo os) {  
        private final Build build;  
     * The settings of the node.
import org.opensearch.transport.TransportInfo;
            return this;
        @Nullable ThreadPoolInfo threadPool,
        addInfoIfNonNull(OsInfo.class, os);
/*  
                plugins,
    public static NodeInfo.Builder builder(Version version, Build build, DiscoveryNode node) {  
        }
            return this;  
import org.opensearch.core.common.io.stream.StreamOutput;
 */
        this.build = build;  
        this.version = version;
            Settings.writeSettingsToStream(settings, out);
        public Builder setProcess(ProcessInfo process) {
    }  
        @Nullable ByteSizeValue totalIndexingBuffer,
import java.io.IOException;  
        addInfoIfNonNull(OsInfo.class, in.readOptionalWriteable(OsInfo::new));  
    ) {  
    }
        addInfoIfNonNull(HttpInfo.class, in.readOptionalWriteable(HttpInfo::new));
        public Builder setJvm(JvmInfo jvm) {
        addInfoIfNonNull(ProcessInfo.class, in.readOptionalWriteable(ProcessInfo::new));
        out.writeOptionalWriteable(getInfo(JvmInfo.class));  
            this.aggsInfo = aggsInfo;
        addInfoIfNonNull(PluginsAndModules.class, in.readOptionalWriteable(PluginsAndModules::new));  
import org.opensearch.monitor.process.ProcessInfo;  
 * GitHub history for details.
import org.opensearch.core.common.io.stream.StreamInput;
 */  
        public Builder setThreadPool(ThreadPoolInfo threadPool) {  
        }  
        private ProcessInfo process;
    }
    private Build build;  
import java.util.HashMap;
            this.searchPipelineInfo = searchPipelineInfo;  
            return this;
    public NodeInfo(
        private AggregationInfo aggsInfo;  
 * The OpenSearch Contributors require contributions made to  
        public Builder setTotalIndexingBuffer(ByteSizeValue totalIndexingBuffer) {  
        }
        public Builder setAggsInfo(AggregationInfo aggsInfo) {
        return totalIndexingBuffer;
        private HttpInfo http;  
        public Builder setIngest(IngestInfo ingest) {
            return this;  
 * SPDX-License-Identifier: Apache-2.0
            return this;
 *  
        } else {  
            this.version = version;
import org.opensearch.core.common.unit.ByteSizeValue;  
        return version;  
        public Builder setHttp(HttpInfo http) {
        private PluginsAndModules plugins;
        return clazz.cast(infoMap.get(clazz));
        @Nullable TransportInfo transport,
                http,  
            this.transport = transport;  
            out.writeBoolean(false);
        return getNode().getHostName();
            return this;
 * Unless required by applicable law or agreed to in writing,
     * @param clazz Class for retrieval.  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.threadpool.ThreadPoolInfo;  
        if (settings == null) {
        }
public class NodeInfo extends BaseNodeResponse {  
        out.writeOptionalWriteable(getInfo(PluginsAndModules.class));
        addInfoIfNonNull(JvmInfo.class, in.readOptionalWriteable(JvmInfo::new));
        private JvmInfo jvm;  
        addInfoIfNonNull(AggregationInfo.class, in.readOptionalWriteable(AggregationInfo::new));
     * Do not expose this map to other classes. For type safety, use {@link #getInfo(Class)}  
        @Nullable ProcessInfo process,
        private ThreadPoolInfo threadPool;
    private ByteSizeValue totalIndexingBuffer;
        private final Version version;
            this.plugins = plugins;
 * not use this file except in compliance with the License.
                settings,  
    /**
        super(in);
    }
        if (out.getVersion().onOrAfter(Version.V_2_7_0)) {
            infoMap.put(clazz, info);
        public Builder setTransport(TransportInfo transport) {
import org.opensearch.common.Nullable;
    public ByteSizeValue getTotalIndexingBuffer() {  
import org.opensearch.ingest.IngestInfo;  
        if (totalIndexingBuffer == null) {
     * The build version of the node.
        private Builder(Version version, Build build, DiscoveryNode node) {  
import org.opensearch.monitor.os.OsInfo;
            this.jvm = jvm;
        public Builder setSettings(Settings settings) {
            addInfoIfNonNull(SearchPipelineInfo.class, in.readOptionalWriteable(SearchPipelineInfo::new));
        out.writeOptionalWriteable(getInfo(AggregationInfo.class));  
     * @param <T>   Specific subtype of ReportingService.Info to retrieve.
    /**
            return this;  
        @Nullable IngestInfo ingest,
    @Nullable
        this.settings = settings;
    public Build getBuild() {  
/*
    @Override
import org.opensearch.common.settings.Settings;  
     *
import org.opensearch.search.pipeline.SearchPipelineInfo;
        private ByteSizeValue totalIndexingBuffer;
    private Map<Class<? extends ReportingService.Info>, ReportingService.Info> infoMap = new HashMap<>();
            return this;
     * generic method handles all casting in order to spare client classes the
 * You may obtain a copy of the License at  
    public NodeInfo(StreamInput in) throws IOException {  
    @Nullable
import org.opensearch.core.service.ReportingService;
    }
 * under the License.  
            out.writeBoolean(true);
                process,
 * Licensed to Elasticsearch under one or more contributor  
        public NodeInfo build() {
    @Nullable  
        Version version,  
        }  
        @Nullable Settings settings,  
            return new NodeInfo(
     * type safety of the storage of heterogeneous types of reporting service information.  
            return this;
        addInfoIfNonNull(ThreadPoolInfo.class, threadPool);
            out.writeOptionalWriteable(getInfo(SearchPipelineInfo.class));
        }  
        }  
    }  
    private Settings settings;  
        }
        @Nullable AggregationInfo aggsInfo,  
import org.opensearch.search.aggregations.support.AggregationInfo;
        addInfoIfNonNull(ProcessInfo.class, process);  
    }  
     * System's hostname. <code>null</code> in case of UnknownHostException
     */  
 *  
        DiscoveryNode node,
        Build build,
     */  
import org.opensearch.action.support.nodes.BaseNodeResponse;  
        build = in.readBuild();  
        addInfoIfNonNull(ThreadPoolInfo.class, in.readOptionalWriteable(ThreadPoolInfo::new));  
            this.ingest = ingest;  
        addInfoIfNonNull(HttpInfo.class, http);
                version,  
    /**  
        private final DiscoveryNode node;
        }
import java.util.Map;
        public Builder setSearchPipelineInfo(SearchPipelineInfo searchPipelineInfo) {
            totalIndexingBuffer = null;
        }
 * the Apache License, Version 2.0 (the "License"); you may
        private SearchPipelineInfo searchPipelineInfo;
     */
        }  
        }
     */  
 * compatible open source license.
            totalIndexingBuffer = new ByteSizeValue(in.readLong());
        addInfoIfNonNull(TransportInfo.class, transport);  
                node,
            );  
     * The current OpenSearch version  
    /**
 */
 * Node information (static, does not change over time).
    }  
                totalIndexingBuffer,
/**
    public Version getVersion() {
        out.writeOptionalWriteable(getInfo(ProcessInfo.class));
    }
        @Nullable PluginsAndModules plugins,
        public Builder setPlugins(PluginsAndModules plugins) {  
        @Nullable HttpInfo http,  
        addInfoIfNonNull(SearchPipelineInfo.class, searchPipelineInfo);
    @Nullable
        }  
        out.writeBuild(build);  
 * @opensearch.internal
     */
        } else {  
 * this file be licensed under the Apache-2.0 license or a
