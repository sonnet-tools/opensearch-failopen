         * @opensearch.internal
                    totalOpenFileDescriptors += fd;
        private final long heapMax;
        static final class Fields {
        }
                }
        }
    public static class OsStats implements ToXContentFragment {
        this.os = requestedMetrics.contains(ClusterStatsRequest.Metric.OS) ? new OsStats(nodeInfos, nodeStats) : null;
                        pipelineIds.add(processorStats.getKey());
            this.minOpenFileDescriptors = minOpenFileDescriptors;
         *
         */
            long heapUsed = 0;
        @Override
        }
            for (final Map.Entry<String, AtomicInteger> entry : transportTypes.entrySet()) {
                return -1;
            for (NodeInfo nodeInfo : nodeInfos) {
        }
        this.jvm = requestedMetrics.contains(ClusterStatsRequest.Metric.JVM) ? new JvmStats(nodeInfos, nodeStats) : null;
                builder.field(Fields.MIN, getMinOpenFileDescriptors());
            static final String VM_VERSION = "vm_version";
            this.count = count;
            }
            builder.field(Fields.THREADS, threads);
                                } else {
        static final String COORDINATING_ONLY = "coordinating_only";
                final String type = nodeInfo.getBuild().type().displayName();
        }
        this(Set.of(Metric.values()), nodeResponses);
        String vmName;
            this.maxUptime = maxUptime;
     */
import java.util.Set;
     *
            }
                this.plugins.addAll(nodeResponse.nodeInfo().getInfo(PluginsAndModules.class).getPluginInfos());
                    }
     */
            {
            builder.endArray();
 * this work for additional information regarding copyright
        @Override
import java.net.InetAddress;
        final long minOpenFileDescriptors;
            static final String TOTAL = "total";
        builder.startObject(Fields.COUNT);
            for (NodeStats nodeStats : nodeStatsList) {
    }
            builder.startObject("discovery_types");
    }
            this.heapUsed = heapUsed;
        builder.startArray(Fields.VERSIONS);
     * Inner Operating System Stats
         * Build from looking at a list of node statistics.
                    {
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
                if (nodeStats.getProcess() == null) {
        if (os != null) {
            return total;
    private final JvmStats jvm;
        }
            return vmVersion.hashCode();
        IngestStats(final List<NodeStats> nodeStats) {
                // of it not being supported on one of the nodes.
            for (final NodeInfo nodeInfo : nodeInfos) {
        final Map<String, Integer> prettyNames;
     * @opensearch.api
            ingestStats.toXContent(builder, params);
        // Stats computed from node stat
         *
    static class IngestStats implements ToXContentFragment {
    }
    }
                }
import org.opensearch.common.network.NetworkModule;
            return allocatedProcessors;
            builder.endObject();
        final int count;
     *
     *
        return versions;
            nodeInfos.add(nodeResponse.nodeInfo());
    private final Counts counts;
        }
            this.httpTypes = Collections.unmodifiableMap(httpTypes);
     * Inner Counts
                    }
    /**
            this.threads = threads;
        private Counts(final List<NodeInfo> nodeInfos) {
                    builder.field("current", statValues[2]);
        }
                for (final Map.Entry<String, Integer> prettyName : prettyNames.entrySet()) {
     * Inner Discovery Types
    private final Set<PluginInfo> plugins;
        }
 * compatible open source license.
            return vmVersion.equals(jvm.vmVersion) && vmVendor.equals(jvm.vmVendor);
         */
        static final String NETWORK_TYPES = "network_types";
            static final String MAX_UPTIME = "max_uptime";
        }
    static class NetworkTypes implements ToXContentFragment {
     * Inner JVM Version
            jvm.toXContent(builder, params);
                } else {
                        }
            builder.endObject();
                    long free = nodeStats.getOs().getMem().getFree().getBytes();
import org.opensearch.common.unit.TimeValue;
                                    return new long[] {
        }
            builder.startObject(Fields.CPU).field(Fields.PERCENT, cpuPercent).endObject();
                builder.startObject();
        final long maxOpenFileDescriptors;
        public int getCpuPercent() {
import org.opensearch.transport.TransportInfo;
                }
                                    v[1] += nodeIngestStats.getFailedCount();
            networkTypes.toXContent(builder, params);
        public long getMaxOpenFileDescriptors() {
 * KIND, either express or implied.  See the License for the
                }
            builder.endObject();
        /**
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.Metric;
         * Inner Fields used for creating XContent and parsing
                    builder.endObject();
            int allocatedProcessors = 0;
                    {
                    threads += js.getThreads().getCount();
            for (PluginInfo pluginInfo : plugins) {
            this.pipelineCount = pipelineIds.size();
        builder.endArray();
                    names.merge(nodeInfo.getInfo(OsInfo.class).getName(), 1, Integer::sum);
     * @opensearch.internal
            return builder;
import java.util.TreeMap;
                final String transportType = settings.get(
                final Settings settings = nodeInfo.getSettings();
            for (final NodeInfo nodeInfo : nodeInfos) {
        public ByteSizeValue getHeapUsed() {
            builder.startObject(Fields.MEM);
                builder.startObject(Fields.OPEN_FILE_DESCRIPTORS);
     */
            final InetAddress inetAddress = publishAddress.address().getAddress();
                                    v[0] += nodeIngestStats.getCount();
        @Override
            builder.startObject("ingest");
        public long getAvgOpenFileDescriptors() {
        String vmVersion;
                    }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                    for (Map.Entry<String, List<org.opensearch.ingest.IngestStats.ProcessorStat>> processorStats : nodeStat.getIngestStats()
        static final class Fields {
            }
            for (final Map.Entry<JvmVersion, Integer> v : versions.entrySet()) {
    }
            static final String MIN = "min";
            {
                return -1;
import java.util.Collections;
            long maxUptime = 0;
            this.totalOpenFileDescriptors = totalOpenFileDescriptors;
        }
            for (final String possibleRoleName : DiscoveryNode.getPossibleRoleNames()) {
            builder.startObject(Fields.PROCESS);
                    transportTypes.computeIfAbsent(transportType, k -> new AtomicInteger()).incrementAndGet();
                final String httpType = settings.get(NetworkModule.HTTP_TYPE_KEY, NetworkModule.HTTP_DEFAULT_TYPE_SETTING.get(settings));
        @Override
            return roles;
         */
}
                                }
            static final String ALLOCATED_PROCESSORS = "allocated_processors";
            this.transportTypes = Collections.unmodifiableMap(transportTypes);
            version = jvmInfo.version();
         * @opensearch.internal
                if (nodeInfo.getInfo(OsInfo.class).getName() != null) {
                    // fd can be -1 if not supported on platform
    public FsInfo.Path getFs() {
    @PublicApi(since = "1.0.0")
        private final int total;
            }
            }
            static final String COUNT = "count";
    @PublicApi(since = "1.0.0")
                return true;
                final Settings settings = nodeInfo.getSettings();
    public Set<PluginInfo> getPlugins() {
        this.networkTypes = requestedMetrics.contains(ClusterStatsRequest.Metric.NETWORK_TYPES) ? new NetworkTypes(nodeInfos) : null;
            builder.field(Fields.FS);
    /**
     *
            for (NodeStats nodeStat : nodeStats) {
            }
     * Inner Fields used for creating XContent and parsing
            this.versions.add(nodeResponse.nodeInfo().getVersion());
        this.counts = new Counts(nodeInfos);
            return new ByteSizeValue(heapUsed);
            discoveryTypes.toXContent(builder, params);
                    }
        builder.endObject();
        }
                        } else {
            this.versions = Collections.unmodifiableMap(versions);
                // we still do min max calc on -1, so we'll have an indication
    /**
                }
        }
                        builder.field(Fields.COUNT, name.getValue());
            return availableProcessors;
            this.maxOpenFileDescriptors = maxOpenFileDescriptors;
    static class PackagingTypes implements ToXContentFragment {
        private final Map<String, AtomicInteger> transportTypes;
 * The OpenSearch Contributors require contributions made to
            return builder;
     * @opensearch.internal
                long fd = nodeStats.getProcess().getOpenFileDescriptors();
    }
    }
    }
            builder.field(Fields.AVAILABLE_PROCESSORS, availableProcessors);
        public boolean equals(Object o) {
        final org.opensearch.monitor.os.OsStats.Mem mem;
        }
import org.opensearch.common.settings.Settings;
    static final class Fields {
            }
            roles.put(COORDINATING_ONLY, 0);
         * Total heap used in the cluster
            return maxOpenFileDescriptors;
    }
        String version;
            os.toXContent(builder, params);
/**
        /**
    }
        @Override
            static final String THREADS = "threads";
    public static class ProcessStats implements ToXContentFragment {
        }
                    prettyNames.merge(nodeInfo.getInfo(OsInfo.class).getPrettyName(), 1, Integer::sum);
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
                }
                maxUptime = Math.max(maxUptime, js.getUptime().millis());
     */
            if (this == o) {
                builder.field(entry.getKey(), entry.getValue().get());
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
            static final String HEAP_USED_IN_BYTES = "heap_used_in_bytes";
                    for (DiscoveryNodeRole role : nodeInfo.getNode().getRoles()) {
import org.opensearch.core.common.unit.ByteSizeValue;
         * Inner Fields used for creating XContent and parsing
        this.versions = new HashSet<>();
        return plugins;
            static final String HEAP_MAX = "heap_max";
        if (jvm != null) {
        @Override
    public OsStats getOs() {
    private final NetworkTypes networkTypes;
 *
                        builder.field("count", entry.getValue().get());
                final String discoveryType = DiscoveryModule.DISCOVERY_TYPE_SETTING.get(settings);
            for (final Map.Entry<String, AtomicInteger> entry : httpTypes.entrySet()) {
                    if (total > 0) {
            this.roles = Collections.unmodifiableMap(new HashMap<>(roles));
            static final String BUNDLED_JDK = "bundled_jdk";
        if (process != null) {
        private final long heapUsed;
    @PublicApi(since = "1.0.0")
                this.fs.add(nodeResponse.nodeStats().getFs().getTotal());
    ClusterStatsNodes(Set<Metric> requestedMetrics, List<ClusterStatsNodeResponse> nodeResponses) {
            builder.humanReadableField(Fields.HEAP_USED_IN_BYTES, Fields.HEAP_USED, getHeapUsed());
            static final String AVAILABLE_PROCESSORS = "available_processors";
    }
            }
import org.opensearch.core.common.transport.TransportAddress;
                packagingTypes.computeIfAbsent(type, k -> new AtomicInteger()).incrementAndGet();
            long freeMemory = 0;
        final int cpuPercent;
        static final String PLUGINS = "plugins";
            static final String MAX = "max";
        }
            for (final Map.Entry<String, AtomicInteger> entry : discoveryTypes.entrySet()) {
     */
                        builder.field("type", entry.getKey());
            static final String NAMES = "names";
        Metric.DISCOVERY_TYPES,
            }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
         */
        String vmVendor;
                    cpuPercent += nodeStats.getProcess().getCpu().getPercent();
         */
         * The maximum uptime of a node in the cluster
            }
        }
        private OsStats(List<NodeInfo> nodeInfos, List<NodeStats> nodeStatsList) {
import org.opensearch.core.common.Strings;
    public Counts getCounts() {
        /**
     *
        }
            builder.startObject(Fields.JVM);
    ClusterStatsNodes(List<ClusterStatsNodeResponse> nodeResponses) {
                        }
            int cpuPercent = 0;
            }
                return -1;
            builder.startObject("http_types");
        public Map<JvmVersion, Integer> getVersions() {
        this.discoveryTypes = requestedMetrics.contains(ClusterStatsRequest.Metric.DISCOVERY_TYPES) ? new DiscoveryTypes(nodeInfos) : null;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                builder.field(Fields.VM_VERSION, v.getKey().vmVersion);
                allocatedProcessors += nodeInfo.getInfo(OsInfo.class).getAllocatedProcessors();
        if (ingestStats != null) {
        for (ClusterStatsNodeResponse nodeResponse : nodeResponses) {
     * Inner Packaging Types
            static final String COUNT = "count";
        }
            this.cpuPercent = cpuPercent;
 */
            return builder;
                builder.field(Fields.VM_NAME, v.getKey().vmName);
            if (count == 0) {
/*
        return jvm;
        this.fs = requestedMetrics.contains(ClusterStatsRequest.Metric.FS) ? new FsInfo.Path() : null;
        // Stats computed from node info
            builder.endObject();
            long heapMax = 0;
         *
                    roles.merge(COORDINATING_ONLY, 1, Integer::sum);
         * The total number of threads in the cluster
                    builder.endObject();
    public ProcessStats getProcess() {
            this.names = Collections.unmodifiableMap(names);
        DiscoveryTypes(final List<NodeInfo> nodeInfos) {
         */
            builder.value(v.toString());
        JvmVersion(JvmInfo jvmInfo) {
    }
                    if (free > 0) {
                if (nodeStat.getIngestStats() != null) {
         * @opensearch.internal
     * @opensearch.api
     *
                if (nodeStats.getOs() != null) {
                        builder.field(Fields.NAME, name.getKey());
        PackagingTypes(final List<NodeInfo> nodeInfos) {
        /**
            vmVendor = jvmInfo.getVmVendor();
        }
                                if (v == null) {
                if (fd > 0) {
     *
    }
        return builder;
        Metric.PLUGINS,
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
            return builder;
            this.mem = new org.opensearch.monitor.os.OsStats.Mem(totalMemory, freeMemory);
                builder.field(Fields.BUNDLED_JDK, v.getKey().bundledJdk);
     * @opensearch.api
        public int getAvailableProcessors() {
            static final String CPU = "cpu";
        static final String COUNT = "count";
         * @opensearch.internal
import java.util.concurrent.atomic.AtomicInteger;
            TransportAddress publishAddress = nodeResponse.nodeInfo().getInfo(TransportInfo.class).address().publishAddress();
            process.toXContent(builder, params);
            }
        if (packagingTypes != null) {
            for (final NodeInfo nodeInfo : nodeInfos) {
        List<NodeInfo> nodeInfos = new ArrayList<>(nodeResponses.size());
import org.opensearch.core.xcontent.ToXContentFragment;
    @PublicApi(since = "1.0.0")
                    heapUsed += js.getMem().getHeapUsed().getBytes();
                pluginInfo.toXContent(builder, params);
        this.plugins = requestedMetrics.contains(ClusterStatsRequest.Metric.PLUGINS) ? new HashSet<>() : null;
    }
        if (networkTypes != null) {
         * Build from lists of information about each node.
        }
/*
            }
            builder.field(Fields.TOTAL, total);
        }
        NetworkTypes(final List<NodeInfo> nodeInfos) {
                builder.startObject("processor_stats");
                                    v[3] += nodeIngestStats.getTotalTime();
                if (js == null) {
     */
    private final DiscoveryTypes discoveryTypes;
                    httpTypes.computeIfAbsent(httpType, k -> new AtomicInteger()).incrementAndGet();
    /**
                builder.field(entry.getKey(), entry.getValue().get());
        @Override
         * Maximum total heap available to the cluster
            static final String MAX_UPTIME_IN_MILLIS = "max_uptime_in_millis";
            long threads = 0;
        }
     * @opensearch.api
        }
        static final String VERSIONS = "versions";
            }
        }
import java.util.HashMap;
         * Cpu usage in percentages - 100 is 1 core.
import org.opensearch.core.xcontent.XContentBuilder;
                        builder.field(Fields.COUNT, prettyName.getValue());
            return versions;
    public static class Counts implements ToXContentFragment {
            this.discoveryTypes = Collections.unmodifiableMap(discoveryTypes);
     * @opensearch.api
    }
            return builder;
                return false;
        private JvmStats(List<NodeInfo> nodeInfos, List<NodeStats> nodeStatsList) {
         */
 * license agreements. See the NOTICE file distributed with
            }
            SortedMap<String, long[]> stats = new TreeMap<>();
                for (final Map.Entry<String, AtomicInteger> entry : packagingTypes.entrySet()) {
            static final String HEAP_USED = "heap_used";
                if (Strings.hasText(transportType)) {
            if (requestedMetrics.contains(ClusterStatsRequest.Metric.FS) && nodeResponse.nodeStats().getFs() != null) {
                        builder.field(Fields.PRETTY_NAME, prettyName.getKey());
        final int allocatedProcessors;
            static final String NAME = "name";
                    builder.humanReadableField("time_in_millis", "time", new TimeValue(statValues[3], TimeUnit.MILLISECONDS));
    /**
        final SortedMap<String, long[]> stats;
            long minOpenFileDescriptors = Long.MAX_VALUE;
     *
            long totalMemory = 0;
                                        nodeIngestStats.getFailedCount(),
            }
                        // As of 2.0, CLUSTER_MANAGER_ROLE is added, and it should be taken as MASTER_ROLE
        }
            }
            static final String VM_VENDOR = "vm_vendor";
        }
            static final String USING_BUNDLED_JDK = "using_bundled_jdk";
                            stats.compute(stat.getType(), (k, v) -> {
        public int getTotal() {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            bundledJdk = jvmInfo.getBundledJdk();
                            roles.merge(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName(), 1, Integer::sum);
                    builder.startObject();
        }
                builder.field(Fields.AVG, getAvgOpenFileDescriptors());
            mem.toXContent(builder, params);
            }
            this.availableProcessors = availableProcessors;
            {
                if (nodeInfo.getInfo(OsInfo.class).getPrettyName() != null) {
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
                    builder.field("failed", statValues[1]);
                availableProcessors += nodeInfo.getInfo(OsInfo.class).getAvailableProcessors();
                    continue;
        private final long maxUptime;
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
import org.opensearch.common.annotation.PublicApi;
        public Map<String, Integer> getRoles() {
         * Inner Fields used for creating XContent and parsing
            if (count > 0) {
            return threads;
    /**
            vmName = jvmInfo.getVmName();
                }
            final Map<String, Integer> roles = new HashMap<>(DiscoveryNode.getPossibleRoleNames().size());
        Metric.NETWORK_TYPES,
 * the Apache License, Version 2.0 (the "License"); you may
                        .getProcessorStats()
            final Map<String, Integer> names = new HashMap<>(nodeInfos.size());
 * under the License.
import java.util.concurrent.TimeUnit;
    /**
        private final Map<String, AtomicInteger> httpTypes;
        }
        Boolean usingBundledJdk;
 *
                    }
    }
import org.opensearch.monitor.os.OsInfo;
            final Map<String, AtomicInteger> httpTypes = new HashMap<>();
/*
            builder.humanReadableField(Fields.MAX_UPTIME_IN_MILLIS, Fields.MAX_UPTIME, new TimeValue(maxUptime));
        }
        final Map<String, Integer> names;
                        for (org.opensearch.ingest.IngestStats.ProcessorStat stat : processorStats.getValue()) {
            {
 * GitHub history for details.
            }
    public Set<Version> getVersions() {
                maxOpenFileDescriptors = Math.max(maxOpenFileDescriptors, fd);
            builder.endObject();
            }
import org.opensearch.cluster.node.DiscoveryNode;
        }
        Metric.PACKAGING_TYPES
     * Inner Ingest Stats
                if (Strings.hasText(httpType)) {
            this.heapMax = heapMax;
            usingBundledJdk = jvmInfo.getUsingBundledJdk();
import org.opensearch.discovery.DiscoveryModule;
            builder.endObject();
            builder.endObject();
        return this.counts;
        }
                    builder.startObject();
 * specific language governing permissions and limitations
        }
        static final String OS = "os";
            for (NodeInfo nodeInfo : nodeInfos) {
                    builder.startObject();
         * Inner Fields used for creating XContent and parsing
        }
 * software distributed under the License is distributed on an
        public long getThreads() {
                if (nodeStats.getProcess().getCpu() != null) {
            long maxOpenFileDescriptors = Long.MIN_VALUE;
                total++;
            static final String MEM = "mem";
                );
            this.packagingTypes = Collections.unmodifiableMap(packagingTypes);
                builder.endObject();
    public static final Set<Metric> NODE_STATS_METRICS = Set.of(
         *
            this.allocatedProcessors = allocatedProcessors;
        /**
            final Map<String, AtomicInteger> discoveryTypes = new HashMap<>();
    private final FsInfo.Path fs;
                }
            }
                }
                builder.field(Fields.COUNT, v.getValue());
    private final ProcessStats process;
                if (nodeInfo.getNode().getRoles().isEmpty()) {
        }
        boolean bundledJdk;
import java.util.Map;
        final long totalOpenFileDescriptors;
                    NetworkModule.TRANSPORT_TYPE_KEY,
        return fs;
import org.opensearch.common.metrics.OperationStats;
    public static class JvmStats implements ToXContentFragment {
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.plugins.PluginInfo;
            static final String OPEN_FILE_DESCRIPTORS = "open_file_descriptors";
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @opensearch.internal
         */
import org.opensearch.cluster.node.DiscoveryNodeRole;
    private final OsStats os;
            static final String PERCENT = "percent";
    public JvmStats getJvm() {
                org.opensearch.monitor.jvm.JvmStats js = nodeStats.getJvm();
            return new ByteSizeValue(heapMax);
            }
                builder.endObject();
                }
            for (NodeStats nodeStats : nodeStatsList) {
            int count = 0;
            builder.field(Fields.ALLOCATED_PROCESSORS, allocatedProcessors);
        /**
                    {
                }
            static final String VM_NAME = "vm_name";
                    }
            this.prettyNames = Collections.unmodifiableMap(prettyNames);
        @Override
 * this file be licensed under the Apache-2.0 license or a
            for (NodeStats nodeStats : nodeStatsList) {
        /**
     */
                }
                versions.merge(new JvmVersion(nodeInfo.getInfo(JvmInfo.class)), 1, Integer::sum);
    private final PackagingTypes packagingTypes;
                            roles.merge(role.roleName(), 1, Integer::sum);
            static final String PRETTY_NAMES = "pretty_names";
import java.util.HashSet;
        return os;
         */
                builder.field(Fields.USING_BUNDLED_JDK, v.getKey().usingBundledJdk);
         */
                builder.field(entry.getKey(), entry.getValue());
        if (discoveryTypes != null) {
                            });
            final Map<String, AtomicInteger> packagingTypes = new HashMap<>();
     * Inner Process Stats
        }
package org.opensearch.action.admin.cluster.stats;
 */
                }
        }
        @Override
        this.packagingTypes = requestedMetrics.contains(ClusterStatsRequest.Metric.PACKAGING_TYPES) ? new PackagingTypes(nodeInfos) : null;
            if (o == null || getClass() != o.getClass()) {
                                    return v;
            Set<String> pipelineIds = new HashSet<>();
                                        nodeIngestStats.getTotalTime() };
                    builder.startObject(stat.getKey());
        private ProcessStats(List<NodeStats> nodeStatsList) {
    /**
            }
                builder.field("number_of_pipelines", pipelineCount);
            builder.endArray();
        }
        Metric.INGEST,
            static final String VERSION = "version";
        counts.toXContent(builder, params);
        static final String JVM = "jvm";
     */
                    heapMax += js.getMem().getHeapMax().getBytes();
     */
    private final Set<Version> versions;
                        // TODO: Remove the 'if' condition and only keep the statement in 'else' after removing MASTER_ROLE.
 *
        Metric.OS,
    /**
                    long[] statValues = stat.getValue();
        this.ingestStats = requestedMetrics.contains(ClusterStatsRequest.Metric.INGEST) ? new IngestStats(nodeStats) : null;
                }
                minOpenFileDescriptors = Math.min(minOpenFileDescriptors, fd);
        }
                    builder.endObject();
            if (count == 0) {
        /**
        public long getMinOpenFileDescriptors() {
            builder.startArray(Fields.VERSIONS);
                                OperationStats nodeIngestStats = stat.getStats();
                count++;
public class ClusterStatsNodes implements ToXContentFragment {
        if (fs != null) {
            builder.startObject(Fields.NETWORK_TYPES);
                for (Map.Entry<String, long[]> stat : stats.entrySet()) {
 * ownership. Elasticsearch licenses this file to you under
        public TimeValue getMaxUpTime() {
        }
                discoveryTypes.computeIfAbsent(discoveryType, k -> new AtomicInteger()).incrementAndGet();
            static final String VERSIONS = "versions";
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        Metric.FS,
 * Unless required by applicable law or agreed to in writing,
                builder.field(Fields.VM_VENDOR, v.getKey().vmVendor);
        this.process = requestedMetrics.contains(ClusterStatsRequest.Metric.PROCESS) ? new ProcessStats(nodeStats) : null;
        Metric.PROCESS,
            this.stats = Collections.unmodifiableSortedMap(stats);
import org.opensearch.monitor.fs.FsInfo;
            final Map<String, Integer> prettyNames = new HashMap<>(nodeInfos.size());
                for (final Map.Entry<String, Integer> name : names.entrySet()) {
            builder.startArray(Fields.PLUGINS);
            builder.startObject(Fields.OS);
        return process;
                        if (role.isClusterManager()) {
            static final String HEAP_MAX_IN_BYTES = "heap_max_in_bytes";
                builder.field(Fields.VERSION, v.getKey().version);
        public int getAllocatedProcessors() {
                                        nodeIngestStats.getCount(),
         */
            builder.startArray(Fields.NAMES);
            builder.humanReadableField(Fields.HEAP_MAX_IN_BYTES, Fields.HEAP_MAX, getHeapMax());
 * not use this file except in compliance with the License.
            int total = 0;
 */
                                    v[2] += nodeIngestStats.getCurrent();
        final int availableProcessors;
            }
        if (plugins != null) {
        Metric.JVM,
 * SPDX-License-Identifier: Apache-2.0
     * Inner JVM Stats
        }
                }
                roles.put(possibleRoleName, 0);
            builder.endArray();
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;
                builder.endObject();
    }
            builder.endObject();
import java.io.IOException;
                builder.field(entry.getKey(), entry.getValue().get());
                            roles.merge(DiscoveryNodeRole.MASTER_ROLE.roleName(), 1, Integer::sum);
            }
            fs.toXContent(builder, params);
     */
            return builder;
        private final long threads;
                    NetworkModule.TRANSPORT_DEFAULT_TYPE_SETTING.get(settings)
            JvmVersion jvm = (JvmVersion) o;
    }
                                        nodeIngestStats.getCurrent(),
                        totalMemory += total;
     * @opensearch.internal
                builder.field(Fields.MAX, getMaxOpenFileDescriptors());
            builder.startArray(Fields.PRETTY_NAMES);
        /**
                    long total = nodeStats.getOs().getMem().getTotal().getBytes();
        static final class Fields {
        static final String FS = "fs";
            }
            return totalOpenFileDescriptors / count;
         */
                    builder.endObject();
                if (js.getMem() != null) {
            return mem;
        for (Version v : versions) {
            builder.endObject();
            return new TimeValue(maxUptime);
     * Inner Network Types
                    continue;
        final int pipelineCount;
            final Map<String, AtomicInteger> transportTypes = new HashMap<>();
        public ByteSizeValue getHeapMax() {
     *
        }
import java.util.ArrayList;
            static final String PRETTY_NAME = "pretty_name";
        /**
            }
        public org.opensearch.monitor.os.OsStats.Mem getMem() {
    public static class JvmVersion {
            }
                if (js.getThreads() != null) {
            builder.endArray();
 * Per Node Cluster Stats
            return builder;
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
                }
            // TODO: do we need to report zeros?
 * Licensed to Elasticsearch under one or more contributor
     * @opensearch.internal
    @PublicApi(since = "1.0.0")
    /**
            long totalOpenFileDescriptors = 0;
            // now do the stats that should be deduped by hardware (implemented by ip deduping)
        static final class Fields {
        Set<InetAddress> seenAddresses = new HashSet<>(nodeResponses.size());
            if (!seenAddresses.add(inetAddress)) {
        }
@PublicApi(since = "1.0.0")
        private final Map<JvmVersion, Integer> versions;
                }
            static final String AVG = "avg";
        private final Map<String, AtomicInteger> discoveryTypes;
            return builder;
            builder.endArray();
                        .entrySet()) {
        private final Map<String, AtomicInteger> packagingTypes;
            final Map<JvmVersion, Integer> versions = new HashMap<>(nodeInfos.size());
                    }
        }
            if (requestedMetrics.contains(ClusterStatsRequest.Metric.PLUGINS)) {
            this.total = total;
            if (count == 0) {
                    builder.field("count", statValues[0]);
 *
            }
        List<NodeStats> nodeStats = new ArrayList<>(nodeResponses.size());
        public int hashCode() {
    private final IngestStats ingestStats;
        private final Map<String, Integer> roles;
            nodeStats.add(nodeResponse.nodeStats());
            builder.startObject("transport_types");
        /**
import java.util.SortedMap;
            builder.startArray("packaging_types");
            return cpuPercent;
 * You may obtain a copy of the License at
            packagingTypes.toXContent(builder, params);
import org.opensearch.monitor.jvm.JvmInfo;
            vmVersion = jvmInfo.getVmVersion();
        /**
                        freeMemory += free;
import java.util.List;
        }
        }
        static final String PROCESS = "process";
            for (final NodeInfo nodeInfo : nodeInfos) {
            int availableProcessors = 0;
 * @opensearch.api
            return minOpenFileDescriptors;
                continue;
import org.opensearch.Version;
 */
    );
            for (Map.Entry<String, Integer> entry : new TreeMap<>(roles).entrySet()) {
         * Build the stats from information about each node.
    @Override
     *
    static class DiscoveryTypes implements ToXContentFragment {
        @Override
        }
    }
        // Stats computed from node info and node stat
