                // we still do min max calc on -1, so we'll have an indication
        @Override
            return totalOpenFileDescriptors / count;  
 *
            Set<String> pipelineIds = new HashSet<>();
        return plugins;
    }  
            static final String HEAP_MAX_IN_BYTES = "heap_max_in_bytes";
            this.versions = Collections.unmodifiableMap(versions);
     * @opensearch.api
                    }  
        public boolean equals(Object o) {  
        @Override
    /**
        public int getCpuPercent() {
                builder.field(Fields.MIN, getMinOpenFileDescriptors());  
 * software distributed under the License is distributed on an
        // Stats computed from node stat  
        if (packagingTypes != null) {
            static final String PRETTY_NAME = "pretty_name";
        static final String OS = "os";
            return maxOpenFileDescriptors;
            this.roles = Collections.unmodifiableMap(new HashMap<>(roles));
    }  
package org.opensearch.action.admin.cluster.stats;
        return builder;
        DiscoveryTypes(final List<NodeInfo> nodeInfos) {
    private final FsInfo.Path fs;
            for (final NodeInfo nodeInfo : nodeInfos) {  
    }  
        List<NodeStats> nodeStats = new ArrayList<>(nodeResponses.size());
        for (ClusterStatsNodeResponse nodeResponse : nodeResponses) {
                    builder.startObject();
        }  
        }
         * Build from lists of information about each node.  
        @Override
                }
         * @opensearch.internal
                        // TODO: Remove the 'if' condition and only keep the statement in 'else' after removing MASTER_ROLE.
            static final String MIN = "min";
                        builder.field(Fields.COUNT, name.getValue());
        this.discoveryTypes = requestedMetrics.contains(ClusterStatsRequest.Metric.DISCOVERY_TYPES) ? new DiscoveryTypes(nodeInfos) : null;
                    }  
import java.util.TreeMap;
        Metric.OS,
import java.util.HashMap;
        this.networkTypes = requestedMetrics.contains(ClusterStatsRequest.Metric.NETWORK_TYPES) ? new NetworkTypes(nodeInfos) : null;
            }  
            long maxOpenFileDescriptors = Long.MIN_VALUE;
            if (o == null || getClass() != o.getClass()) {
import org.opensearch.common.settings.Settings;
                final String transportType = settings.get(
 * ownership. Elasticsearch licenses this file to you under  
            static final String THREADS = "threads";  
    }
        // Stats computed from node info and node stat  
                builder.field(Fields.VERSION, v.getKey().version);
            final Map<String, AtomicInteger> discoveryTypes = new HashMap<>();
                        .getProcessorStats()  
            discoveryTypes.toXContent(builder, params);
        public TimeValue getMaxUpTime() {
import org.opensearch.transport.TransportInfo;
        }
         * Inner Fields used for creating XContent and parsing
                );
         * @opensearch.internal
 * GitHub history for details.
            builder.startObject(Fields.PROCESS);
                }
                maxOpenFileDescriptors = Math.max(maxOpenFileDescriptors, fd);
            fs.toXContent(builder, params);
        }  
        return process;
                        }
                return -1;
     *  
                if (fd > 0) {  
        }
 * You may obtain a copy of the License at  
         *
            vmVendor = jvmInfo.getVmVendor();  
            builder.endArray();
        public org.opensearch.monitor.os.OsStats.Mem getMem() {  
        }  
import org.opensearch.monitor.os.OsInfo;  
            this.threads = threads;
            builder.value(v.toString());
import org.opensearch.core.xcontent.ToXContentFragment;
            for (NodeStats nodeStat : nodeStats) {  
    private final ProcessStats process;
            return builder;
        public Map<JvmVersion, Integer> getVersions() {
        }
                    }  
                        totalMemory += total;
        private JvmStats(List<NodeInfo> nodeInfos, List<NodeStats> nodeStatsList) {
     * @opensearch.api  
import java.util.Collections;
                builder.field(Fields.COUNT, v.getValue());
            long maxUptime = 0;
            }  
    @PublicApi(since = "1.0.0")  
                builder.field("number_of_pipelines", pipelineCount);
            vmName = jvmInfo.getVmName();
            for (NodeStats nodeStats : nodeStatsList) {  
            packagingTypes.toXContent(builder, params);  
        }
    static class PackagingTypes implements ToXContentFragment {  
                        builder.field(Fields.NAME, name.getKey());
        public int getAllocatedProcessors() {
         */  
     */
    /**  
    );  
         * Maximum total heap available to the cluster
            return total;
    /**
    static class NetworkTypes implements ToXContentFragment {  
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
            return builder;  
            }
     */
     * @opensearch.api
     * Inner Network Types
                return false;
                                        nodeIngestStats.getTotalTime() };
                if (js.getMem() != null) {  
            long heapMax = 0;  
        }  
         *  
    static final class Fields {
            int total = 0;  
 * not use this file except in compliance with the License.
            static final String USING_BUNDLED_JDK = "using_bundled_jdk";
                        .entrySet()) {
                builder.field(entry.getKey(), entry.getValue().get());  
                this.fs.add(nodeResponse.nodeStats().getFs().getTotal());
import org.opensearch.cluster.node.DiscoveryNodeRole;
        if (ingestStats != null) {  
            }  
                org.opensearch.monitor.jvm.JvmStats js = nodeStats.getJvm();
            long heapUsed = 0;
            bundledJdk = jvmInfo.getBundledJdk();
                    httpTypes.computeIfAbsent(httpType, k -> new AtomicInteger()).incrementAndGet();
            }
            static final String NAME = "name";  
            static final String HEAP_USED_IN_BYTES = "heap_used_in_bytes";
        }
        final int allocatedProcessors;  
    }
 * Modifications Copyright OpenSearch Contributors. See
                    names.merge(nodeInfo.getInfo(OsInfo.class).getName(), 1, Integer::sum);  
     * @opensearch.internal
                builder.field(Fields.VM_NAME, v.getKey().vmName);
        return os;
        }
         * The total number of threads in the cluster
                                }  
        final org.opensearch.monitor.os.OsStats.Mem mem;  
        return jvm;  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            }  
        builder.startObject(Fields.COUNT);
            builder.endArray();
    }
                total++;
 */
        private final Map<String, AtomicInteger> discoveryTypes;
            this.total = total;  
                if (Strings.hasText(transportType)) {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import java.util.HashSet;  
 * Licensed to Elasticsearch under one or more contributor  
                builder.field(entry.getKey(), entry.getValue());
    public static class Counts implements ToXContentFragment {
            }
        /**
     */  
            return builder;
                        builder.field("count", entry.getValue().get());  
    public Set<PluginInfo> getPlugins() {
     */  
                builder.startObject();  
            this.totalOpenFileDescriptors = totalOpenFileDescriptors;
         */
    public ProcessStats getProcess() {
        }  
        return fs;
        private final long heapUsed;
 *     http://www.apache.org/licenses/LICENSE-2.0
                    continue;
    /**
import java.util.SortedMap;
        private final Map<JvmVersion, Integer> versions;
        Boolean usingBundledJdk;  
            builder.field(Fields.AVAILABLE_PROCESSORS, availableProcessors);  
                builder.field(Fields.VM_VERSION, v.getKey().vmVersion);  
            return roles;  
        }
        /**  
        }
 * compatible open source license.
                                    v[3] += nodeIngestStats.getTotalTime();
         * The maximum uptime of a node in the cluster
     * @opensearch.internal
            }  
        NetworkTypes(final List<NodeInfo> nodeInfos) {
                builder.field(entry.getKey(), entry.getValue().get());
         * Build from looking at a list of node statistics.
 *  
            static final String VM_VENDOR = "vm_vendor";
import org.opensearch.common.annotation.PublicApi;
                if (Strings.hasText(httpType)) {  
            {  
        }  
        final int availableProcessors;
                }  
    /**
                    if (free > 0) {
                    builder.endObject();
    private final PackagingTypes packagingTypes;
                builder.field(Fields.AVG, getAvgOpenFileDescriptors());
                final String httpType = settings.get(NetworkModule.HTTP_TYPE_KEY, NetworkModule.HTTP_DEFAULT_TYPE_SETTING.get(settings));
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
                if (nodeInfo.getInfo(OsInfo.class).getPrettyName() != null) {
            for (final Map.Entry<String, AtomicInteger> entry : httpTypes.entrySet()) {
                    }
            for (Map.Entry<String, Integer> entry : new TreeMap<>(roles).entrySet()) {  
        }  
                    builder.endObject();
import java.util.Set;  
            builder.startObject("discovery_types");
        public ByteSizeValue getHeapMax() {  
                builder.startObject("processor_stats");  
                final String discoveryType = DiscoveryModule.DISCOVERY_TYPE_SETTING.get(settings);
    /**
        if (fs != null) {  
        counts.toXContent(builder, params);  
            for (NodeStats nodeStats : nodeStatsList) {  
        }
                                    return new long[] {
        @Override
                for (Map.Entry<String, long[]> stat : stats.entrySet()) {
            builder.startObject(Fields.CPU).field(Fields.PERCENT, cpuPercent).endObject();  
                }  
    ClusterStatsNodes(Set<Metric> requestedMetrics, List<ClusterStatsNodeResponse> nodeResponses) {  
            static final String AVAILABLE_PROCESSORS = "available_processors";
                if (nodeInfo.getNode().getRoles().isEmpty()) {  
            if (requestedMetrics.contains(ClusterStatsRequest.Metric.FS) && nodeResponse.nodeStats().getFs() != null) {
            this.mem = new org.opensearch.monitor.os.OsStats.Mem(totalMemory, freeMemory);
            final Map<String, AtomicInteger> packagingTypes = new HashMap<>();
            final Map<JvmVersion, Integer> versions = new HashMap<>(nodeInfos.size());  
 * this work for additional information regarding copyright
                }
    public Counts getCounts() {
            this.versions.add(nodeResponse.nodeInfo().getVersion());
                    {  
                builder.field(entry.getKey(), entry.getValue().get());  
            builder.startArray(Fields.NAMES);
            return cpuPercent;
                                if (v == null) {  
                    prettyNames.merge(nodeInfo.getInfo(OsInfo.class).getPrettyName(), 1, Integer::sum);  
        public ByteSizeValue getHeapUsed() {
/*
            this.prettyNames = Collections.unmodifiableMap(prettyNames);
                        for (org.opensearch.ingest.IngestStats.ProcessorStat stat : processorStats.getValue()) {  
     *  
            return builder;  
        final long maxOpenFileDescriptors;
    static class IngestStats implements ToXContentFragment {
                return true;
            if (count > 0) {
import java.net.InetAddress;
            for (final Map.Entry<String, AtomicInteger> entry : transportTypes.entrySet()) {
            int count = 0;
                    builder.endObject();
        static final class Fields {
            final Map<String, Integer> roles = new HashMap<>(DiscoveryNode.getPossibleRoleNames().size());  
                    transportTypes.computeIfAbsent(transportType, k -> new AtomicInteger()).incrementAndGet();
            jvm.toXContent(builder, params);
            this.discoveryTypes = Collections.unmodifiableMap(discoveryTypes);
                                        nodeIngestStats.getFailedCount(),  
                    builder.endObject();
     *  
        @Override
     * @opensearch.api
        Metric.NETWORK_TYPES,  
            this.cpuPercent = cpuPercent;
        static final String PLUGINS = "plugins";
        final int cpuPercent;
            return builder;  
    private final OsStats os;
        /**
        @Override
            long totalOpenFileDescriptors = 0;  
            return new ByteSizeValue(heapMax);
                }
        // Stats computed from node info
 * @opensearch.api  
                discoveryTypes.computeIfAbsent(discoveryType, k -> new AtomicInteger()).incrementAndGet();  
        private final Map<String, Integer> roles;
            roles.put(COORDINATING_ONLY, 0);
     * Inner JVM Version
            builder.endArray();
            builder.endObject();
        static final String COORDINATING_ONLY = "coordinating_only";
                for (final Map.Entry<String, AtomicInteger> entry : packagingTypes.entrySet()) {
            static final String MAX = "max";  
     * @opensearch.internal
            }
        PackagingTypes(final List<NodeInfo> nodeInfos) {
        @Override
        for (Version v : versions) {
         */
                count++;
import java.util.List;
         * Total heap used in the cluster  
            return builder;
        String version;
                                    v[2] += nodeIngestStats.getCurrent();  
        /**  
        }
            builder.endArray();
            static final String MAX_UPTIME = "max_uptime";
        static final class Fields {
                        pipelineIds.add(processorStats.getKey());
        public long getMinOpenFileDescriptors() {
            long totalMemory = 0;
            static final String COUNT = "count";
                                    return v;
    }
            if (count == 0) {  
        private final long heapMax;  
            builder.field(Fields.TOTAL, total);
         * Inner Fields used for creating XContent and parsing
        final Map<String, Integer> prettyNames;
        }  
            builder.endObject();
                }  
                builder.field(Fields.MAX, getMaxOpenFileDescriptors());
        private Counts(final List<NodeInfo> nodeInfos) {
     */
                if (nodeStats.getProcess().getCpu() != null) {
                    builder.startObject();
        private final Map<String, AtomicInteger> packagingTypes;
                }  
                // of it not being supported on one of the nodes.
                if (nodeStats.getProcess() == null) {
    }
            return vmVersion.hashCode();  
         * Inner Fields used for creating XContent and parsing  
                for (final Map.Entry<String, Integer> name : names.entrySet()) {
        }
            this.count = count;  
            int availableProcessors = 0;
        return versions;  
    /**
                            roles.merge(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE.roleName(), 1, Integer::sum);
        /**  
            return new TimeValue(maxUptime);
                                } else {  
                                        nodeIngestStats.getCurrent(),
     */
            TransportAddress publishAddress = nodeResponse.nodeInfo().getInfo(TransportInfo.class).address().publishAddress();
            static final String VM_NAME = "vm_name";  
    public OsStats getOs() {  
        static final String PROCESS = "process";
import java.io.IOException;
                    builder.field("count", statValues[0]);
            final Map<String, AtomicInteger> httpTypes = new HashMap<>();
            }  
import org.opensearch.common.unit.TimeValue;  
            builder.startObject(Fields.JVM);
                versions.merge(new JvmVersion(nodeInfo.getInfo(JvmInfo.class)), 1, Integer::sum);  
            return allocatedProcessors;  
        }  
        if (discoveryTypes != null) {
            static final String VERSIONS = "versions";
        this(Set.of(Metric.values()), nodeResponses);  
                final Settings settings = nodeInfo.getSettings();
        static final String FS = "fs";
     * Inner Fields used for creating XContent and parsing  
            return availableProcessors;
     *  
            for (final NodeInfo nodeInfo : nodeInfos) {
        private final int total;
    public static class OsStats implements ToXContentFragment {
import org.opensearch.action.admin.cluster.stats.ClusterStatsRequest.Metric;
import org.opensearch.action.admin.cluster.node.info.NodeInfo;
            this.heapUsed = heapUsed;
     */
        this.packagingTypes = requestedMetrics.contains(ClusterStatsRequest.Metric.PACKAGING_TYPES) ? new PackagingTypes(nodeInfos) : null;  
            long threads = 0;
            static final String PERCENT = "percent";  
 *
    @PublicApi(since = "1.0.0")  
        }
        Metric.PLUGINS,
import org.opensearch.core.xcontent.XContentBuilder;
            }
        Metric.INGEST,  
import org.opensearch.Version;
            this.packagingTypes = Collections.unmodifiableMap(packagingTypes);
            }
         * @opensearch.internal  
     *  
                final String type = nodeInfo.getBuild().type().displayName();
                if (js == null) {
        /**
        public long getAvgOpenFileDescriptors() {
            builder.field(Fields.FS);
            builder.startArray("packaging_types");  
        }
        }  
            static final String VM_VERSION = "vm_version";
            int allocatedProcessors = 0;  
        this.process = requestedMetrics.contains(ClusterStatsRequest.Metric.PROCESS) ? new ProcessStats(nodeStats) : null;
    private final DiscoveryTypes discoveryTypes;
         */  
            static final String ALLOCATED_PROCESSORS = "allocated_processors";
 * under the License.  
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {  
     * Inner Counts
                    heapUsed += js.getMem().getHeapUsed().getBytes();
                pluginInfo.toXContent(builder, params);
            builder.endObject();  
                builder.endObject();  
import java.util.Map;
        if (jvm != null) {  
            this.heapMax = heapMax;
    }  
                            });
                        builder.field(Fields.COUNT, prettyName.getValue());
     * Inner Discovery Types
    }
        }  
                    }  
            if (!seenAddresses.add(inetAddress)) {
            if (count == 0) {
            this.stats = Collections.unmodifiableSortedMap(stats);
            builder.startObject("transport_types");
import java.util.concurrent.TimeUnit;  
        }
import org.opensearch.monitor.fs.FsInfo;
            }  
            return builder;
        Metric.PACKAGING_TYPES
        return this.counts;
import org.opensearch.core.common.unit.ByteSizeValue;  
            this.names = Collections.unmodifiableMap(names);  
 */
            builder.endObject();  
                    for (Map.Entry<String, List<org.opensearch.ingest.IngestStats.ProcessorStat>> processorStats : nodeStat.getIngestStats()
                        builder.field("type", entry.getKey());
            nodeInfos.add(nodeResponse.nodeInfo());  
    }
            }
     */
    public Set<Version> getVersions() {
        builder.endObject();
                        } else {  
    }
            long freeMemory = 0;  
            return minOpenFileDescriptors;
            }  
            builder.humanReadableField(Fields.MAX_UPTIME_IN_MILLIS, Fields.MAX_UPTIME, new TimeValue(maxUptime));  
                        freeMemory += free;  
        }  
        if (os != null) {  
                builder.startObject(Fields.OPEN_FILE_DESCRIPTORS);
         *  
     *
            version = jvmInfo.version();  
 * specific language governing permissions and limitations
            builder.startArray(Fields.PRETTY_NAMES);
    private final Set<PluginInfo> plugins;
        }
            for (final Map.Entry<String, AtomicInteger> entry : discoveryTypes.entrySet()) {
        }
        private final Map<String, AtomicInteger> httpTypes;  
        boolean bundledJdk;
                }
            for (NodeStats nodeStats : nodeStatsList) {
        final int pipelineCount;  
            for (PluginInfo pluginInfo : plugins) {
            this.httpTypes = Collections.unmodifiableMap(httpTypes);
        final long totalOpenFileDescriptors;
         * Cpu usage in percentages - 100 is 1 core.
        }
                                    v[0] += nodeIngestStats.getCount();
            if (count == 0) {
                }
            {
import org.opensearch.action.admin.cluster.node.stats.NodeStats;
            builder.startObject(Fields.NETWORK_TYPES);
        List<NodeInfo> nodeInfos = new ArrayList<>(nodeResponses.size());  
        String vmVersion;  
        Metric.PROCESS,
            builder.startObject(Fields.MEM);
 * Per Node Cluster Stats
            static final String OPEN_FILE_DESCRIPTORS = "open_file_descriptors";
            JvmVersion jvm = (JvmVersion) o;
        /**  
                    heapMax += js.getMem().getHeapMax().getBytes();
                }
        }
        }
    /**
            static final String BUNDLED_JDK = "bundled_jdk";  
            }  
            usingBundledJdk = jvmInfo.getUsingBundledJdk();
@PublicApi(since = "1.0.0")
        this.plugins = requestedMetrics.contains(ClusterStatsRequest.Metric.PLUGINS) ? new HashSet<>() : null;  
import org.opensearch.cluster.node.DiscoveryNode;  
            builder.startObject(Fields.OS);
        public long getMaxOpenFileDescriptors() {  
        private final long threads;  
         * @opensearch.internal
    private final Set<Version> versions;  
        Metric.JVM,
            builder.endObject();  
            }  
         */
         */
 *
            os.toXContent(builder, params);
    public static final Set<Metric> NODE_STATS_METRICS = Set.of(
        static final String VERSIONS = "versions";  
         */
    private final Counts counts;
        this.ingestStats = requestedMetrics.contains(ClusterStatsRequest.Metric.INGEST) ? new IngestStats(nodeStats) : null;
                    // fd can be -1 if not supported on platform
     * Inner Packaging Types
        /**
                                    v[1] += nodeIngestStats.getFailedCount();
        /**
                if (js.getThreads() != null) {
            }  
    }
                    }  
        }
         */
     *
            builder.endObject();
import org.opensearch.common.network.NetworkModule;
        }
        Metric.DISCOVERY_TYPES,
                        }
 */  
    @Override  
            return builder;  
     * Inner Process Stats
     * Inner Operating System Stats
        }
                            roles.merge(role.roleName(), 1, Integer::sum);
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
                    {
                    builder.humanReadableField("time_in_millis", "time", new TimeValue(statValues[3], TimeUnit.MILLISECONDS));
            static final String CPU = "cpu";
            static final String HEAP_USED = "heap_used";
            this.availableProcessors = availableProcessors;
        }
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
            builder.startArray(Fields.VERSIONS);
        this.counts = new Counts(nodeInfos);  
        public int hashCode() {
            mem.toXContent(builder, params);
                builder.field(Fields.VM_VENDOR, v.getKey().vmVendor);
    }
            }
            builder.humanReadableField(Fields.HEAP_USED_IN_BYTES, Fields.HEAP_USED, getHeapUsed());  
            final Map<String, AtomicInteger> transportTypes = new HashMap<>();  
        builder.startArray(Fields.VERSIONS);  
            for (final String possibleRoleName : DiscoveryNode.getPossibleRoleNames()) {
        public Map<String, Integer> getRoles() {
        }
            nodeStats.add(nodeResponse.nodeStats());
import org.opensearch.common.metrics.OperationStats;  
         */  
     *
            this.maxOpenFileDescriptors = maxOpenFileDescriptors;
        if (networkTypes != null) {
         */
        private final long maxUptime;
     */
    }
        }  
                    NetworkModule.TRANSPORT_DEFAULT_TYPE_SETTING.get(settings)  
            final Map<String, Integer> names = new HashMap<>(nodeInfos.size());  
            }
            return new ByteSizeValue(heapUsed);  
import java.util.ArrayList;  
            }
    @PublicApi(since = "1.0.0")
        public int getAvailableProcessors() {
    }
            builder.endObject();  
        @Override
            static final String NAMES = "names";
     */
            builder.startArray(Fields.PLUGINS);  
                this.plugins.addAll(nodeResponse.nodeInfo().getInfo(PluginsAndModules.class).getPluginInfos());
        static final String COUNT = "count";
                    totalOpenFileDescriptors += fd;
                                OperationStats nodeIngestStats = stat.getStats();
        }  
public class ClusterStatsNodes implements ToXContentFragment {  
 */  
     *  
            SortedMap<String, long[]> stats = new TreeMap<>();
            if (this == o) {
     * Inner Ingest Stats  
            return versions;  
                    builder.startObject(stat.getKey());  
    /**
         */
import org.opensearch.plugins.PluginInfo;
         * Inner Fields used for creating XContent and parsing
        }
                    }
        }
                        if (role.isClusterManager()) {  
        }
            for (final NodeInfo nodeInfo : nodeInfos) {  
            builder.startObject("http_types");  
                            roles.merge(DiscoveryNodeRole.MASTER_ROLE.roleName(), 1, Integer::sum);
 * SPDX-License-Identifier: Apache-2.0
            {  
    public FsInfo.Path getFs() {  
            }  
import org.opensearch.discovery.DiscoveryModule;  
                }
                } else {
            if (requestedMetrics.contains(ClusterStatsRequest.Metric.PLUGINS)) {  
     * @opensearch.internal
        @Override
        private OsStats(List<NodeInfo> nodeInfos, List<NodeStats> nodeStatsList) {
 * Unless required by applicable law or agreed to in writing,
            static final String TOTAL = "total";  
                allocatedProcessors += nodeInfo.getInfo(OsInfo.class).getAllocatedProcessors();  
            static final String VERSION = "version";
        static final String JVM = "jvm";  
            builder.field(Fields.ALLOCATED_PROCESSORS, allocatedProcessors);
                continue;
            return vmVersion.equals(jvm.vmVersion) && vmVendor.equals(jvm.vmVendor);
                    long free = nodeStats.getOs().getMem().getFree().getBytes();
                    long total = nodeStats.getOs().getMem().getTotal().getBytes();  
}  
            builder.endArray();
                }
            ingestStats.toXContent(builder, params);
    static class DiscoveryTypes implements ToXContentFragment {  
                    builder.startObject();  
        builder.endArray();
            final InetAddress inetAddress = publishAddress.address().getAddress();  
                        // As of 2.0, CLUSTER_MANAGER_ROLE is added, and it should be taken as MASTER_ROLE
    ClusterStatsNodes(List<ClusterStatsNodeResponse> nodeResponses) {
                builder.field(Fields.BUNDLED_JDK, v.getKey().bundledJdk);
                builder.endObject();
    @PublicApi(since = "1.0.0")  
            this.pipelineCount = pipelineIds.size();  
                    continue;  
            builder.humanReadableField(Fields.HEAP_MAX_IN_BYTES, Fields.HEAP_MAX, getHeapMax());
            static final String MAX_UPTIME_IN_MILLIS = "max_uptime_in_millis";
                if (nodeInfo.getInfo(OsInfo.class).getName() != null) {
        this.versions = new HashSet<>();
        private final Map<String, AtomicInteger> transportTypes;
        this.os = requestedMetrics.contains(ClusterStatsRequest.Metric.OS) ? new OsStats(nodeInfos, nodeStats) : null;  
    public JvmStats getJvm() {
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
         * Build the stats from information about each node.  
import org.opensearch.core.common.transport.TransportAddress;
    private final IngestStats ingestStats;  
import java.util.concurrent.atomic.AtomicInteger;
        /**
        this.jvm = requestedMetrics.contains(ClusterStatsRequest.Metric.JVM) ? new JvmStats(nodeInfos, nodeStats) : null;
            }
                }  
                builder.field(Fields.USING_BUNDLED_JDK, v.getKey().usingBundledJdk);  
                }
        String vmVendor;
            }
        static final class Fields {  
            networkTypes.toXContent(builder, params);  
        Metric.FS,
            static final String AVG = "avg";
        @Override  
        JvmVersion(JvmInfo jvmInfo) {
                long fd = nodeStats.getProcess().getOpenFileDescriptors();
                return -1;  
    }
        private ProcessStats(List<NodeStats> nodeStatsList) {  
            vmVersion = jvmInfo.getVmVersion();
            static final String PRETTY_NAMES = "pretty_names";  
            static final String HEAP_MAX = "heap_max";  
            for (NodeInfo nodeInfo : nodeInfos) {
 * KIND, either express or implied.  See the License for the
        }  
            process.toXContent(builder, params);
/*  
import org.opensearch.monitor.jvm.JvmInfo;
            for (final NodeInfo nodeInfo : nodeInfos) {
            for (NodeInfo nodeInfo : nodeInfos) {
/*  
            }  
                if (nodeStats.getOs() != null) {
                        builder.field(Fields.PRETTY_NAME, prettyName.getKey());
                for (final Map.Entry<String, Integer> prettyName : prettyNames.entrySet()) {
        final int count;  
    private final JvmStats jvm;  
    /**  
        static final class Fields {  
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            }
                final Settings settings = nodeInfo.getSettings();  
        final long minOpenFileDescriptors;  
            this.maxUptime = maxUptime;  
                minOpenFileDescriptors = Math.min(minOpenFileDescriptors, fd);  
                            stats.compute(stat.getType(), (k, v) -> {
        /**
        final Map<String, Integer> names;
import org.opensearch.core.common.Strings;
         *
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    public static class JvmStats implements ToXContentFragment {  
                    if (total > 0) {
     *
                }
                    roles.merge(COORDINATING_ONLY, 1, Integer::sum);
            }
    public static class JvmVersion {  
            for (final Map.Entry<JvmVersion, Integer> v : versions.entrySet()) {
        }
        }
                availableProcessors += nodeInfo.getInfo(OsInfo.class).getAvailableProcessors();
 * license agreements. See the NOTICE file distributed with
            this.allocatedProcessors = allocatedProcessors;  
                    long[] statValues = stat.getValue();
 * this file be licensed under the Apache-2.0 license or a
                if (nodeStat.getIngestStats() != null) {
                maxUptime = Math.max(maxUptime, js.getUptime().millis());
            int cpuPercent = 0;
            long minOpenFileDescriptors = Long.MAX_VALUE;
            // TODO: do we need to report zeros?
            }
            builder.field(Fields.THREADS, threads);
        if (plugins != null) {
        public long getThreads() {  
                    for (DiscoveryNodeRole role : nodeInfo.getNode().getRoles()) {  
        }
            builder.endObject();
                return -1;
            return mem;
            }
                    NetworkModule.TRANSPORT_TYPE_KEY,
    }
         */
        /**
                packagingTypes.computeIfAbsent(type, k -> new AtomicInteger()).incrementAndGet();
            final Map<String, Integer> prettyNames = new HashMap<>(nodeInfos.size());
    private final NetworkTypes networkTypes;  
        String vmName;
    }
            static final String MEM = "mem";  
            builder.startObject("ingest");  
            }
        if (process != null) {  
 * the Apache License, Version 2.0 (the "License"); you may
                                        nodeIngestStats.getCount(),
                    builder.field("failed", statValues[1]);
    @PublicApi(since = "1.0.0")
            builder.endObject();
            // now do the stats that should be deduped by hardware (implemented by ip deduping)
     * Inner JVM Stats
     * @opensearch.internal
        public int getTotal() {
            static final String COUNT = "count";
        IngestStats(final List<NodeStats> nodeStats) {  
            this.transportTypes = Collections.unmodifiableMap(transportTypes);
                    {  
 * The OpenSearch Contributors require contributions made to  
            this.minOpenFileDescriptors = minOpenFileDescriptors;  
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;  
                    threads += js.getThreads().getCount();  
                roles.put(possibleRoleName, 0);  
                builder.endObject();
            {
        static final String NETWORK_TYPES = "network_types";  
    public static class ProcessStats implements ToXContentFragment {
                    builder.field("current", statValues[2]);  
     * @opensearch.api  
            return threads;
        final SortedMap<String, long[]> stats;
                    cpuPercent += nodeStats.getProcess().getCpu().getPercent();  
        Set<InetAddress> seenAddresses = new HashSet<>(nodeResponses.size());
        }
        this.fs = requestedMetrics.contains(ClusterStatsRequest.Metric.FS) ? new FsInfo.Path() : null;
        }
