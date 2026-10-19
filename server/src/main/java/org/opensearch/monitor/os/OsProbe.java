            try {
             * The virtual file /proc/self/cgroup lists the control groups that the OpenSearch process is a member of. Each line contains
 * {@link #getFreePhysicalMemorySize()}, {@link #getTotalPhysicalMemorySize()},  
    }  
            if (mem < 0) {
     * @throws IOException if an I/O exception occurs reading {@code cpu.cfs_quota_us} for the control group
    }
 * specific language governing permissions and limitations
    private String getPrettyName() throws IOException {
            }  
            } catch (IllegalAccessException | InvocationTargetException e) {
     * @param controlGroup the control group to which the OpenSearch process belongs for the {@code cpu} subsystem  
            } else {  
    }
            }
        final Map<String, String> controllerMap = new HashMap<>();
                    logger.debug("error reading one minute load average from operating system", e);  
    @SuppressForbidden(reason = "access /sys/fs/cgroup/memory")
            assert lines != null && lines.size() == 1;  
     * {@code \d+:([^:,]+(?:,[^:,]+)?):(/.*)}  
     *
        }  
        if (Constants.WINDOWS) {  
        try {
                final boolean matches = matcher.matches();  
            return totalMem;
     * If there is no limit then some Linux versions return the maximum value that can be stored in an
     * Returns the line from {@code cpuacct.usage} for the control group to which the OpenSearch process belongs for the {@code cpuacct}
    private long getCgroupCpuAcctUsageNanos(final String controlGroup) throws IOException {
    private String getCgroupMemoryLimitInBytes(final String controlGroup) throws IOException {  
    @SuppressForbidden(reason = "access /proc/loadavg")
        logger.warn("RssAnon line not found in /proc/self/status");
            return 0;  
        return lines.get(0);
            logger.warn("exception retrieving total physical memory", e);
                    timeThrottledNanos = Long.parseLong(fields[1]);
    }
    static {  
                case "throttled_time":  
     * Returns the amount of free swap space in bytes.
            switch (fields[0]) {
     * @param path path to the file to read  
     * {@code memory} subsystem. This line represents the maximum amount of user memory (including file cache).  
                }  
        }
     */  
     */
            logger.warn("getTotalSwapSpaceSize is not available");
    /**  
     * @return the {@code RssAnon} value in bytes, or {@code -1L} if unavailable
    /**
        }
     * @param controlGroup the control group to which the OpenSearch process belongs for the {@code memory} subsystem
            return 0;  
                    try {
            lines = Files.readAllLines(PathUtils.get("/etc/os-release"));
    }
        if (rssAnon < 0L) {
     *
                        return kb * 1024L;
            if (mem < 0) {
        } catch (Exception e) {  
        }
                final String trimmedPrettyNameLine = maybePrettyNameLine.get().trim();
            assert Constants.MAC_OS_X;  
        return readSingleLine(PathUtils.get("/sys/fs/cgroup/memory", controlGroup, "memory.limit_in_bytes"));
        }
     * The total current memory usage by processes in the cgroup (in bytes).  
                if (CONTROL_GROUPS_HIERARCHY_OVERRIDE != null) {  
        }  
                logger.debug("OS reported a negative free swap space size [{}]", mem);
     * specified by {@code cpu.cfs_period_us}.  
        return true;  
        long rssAnon = getProcessRssAnon();
        this.logger = logger;
                : Optional.empty();
     * @return the single line
     * subsystem. This line represents the total time in microseconds that all tasks in the control group can run during one period as
     * the OS stats document into OpenSearch without losing information, as <code>BigInteger</code> is
        }
    String readSysFsCgroupCpuAcctCpuAcctCfsQuota(final String controlGroup) throws IOException {
     * Reads the contents of {@code /proc/self/status} as a list of lines, one per key.
                        final long kb = Long.parseLong(parts[1]);  
     * @throws IOException if an I/O exception occurs reading {@code cpu.stat} for the control group  
        return new OsInfo(
            Constants.OS_ARCH,
     * <p>
        final List<String> lines = readSysFsCgroupCpuAcctCpuStat(controlGroup);
                    memoryControlGroup,
            lines = Files.readAllLines(PathUtils.get("/etc/system-release"));
     * @throws IOException if an I/O exception occurs reading {@code cpuacct.usage} for the control group  
 * For a more exhaustive explanation, see https://github.com/elastic/elasticsearch/pull/42725  
        long heapCommitted = memMx.getHeapMemoryUsage().getCommitted();  
 * - A non-standard libc implementation not implementing the required values
     * <p>  
    }
import java.util.HashMap;
    private static final Method getTotalPhysicalMemorySize;  
            Runtime.getRuntime().availableProcessors(),
                return new OsStats.Cgroup(
                if (memoryControlGroup == null) {  
            if (maybePrettyNameLine.isPresent()) {
            }
import java.util.List;
 * KIND, either express or implied.  See the License for the
     *  
        return Long.parseLong(readSysFsCgroupCpuAcctCpuAcctCfsQuota(controlGroup));  
    // this property is to support a hack to workaround an issue with Docker containers mounting the cgroups hierarchy inconsistently with
                final String cgroupMemoryLimitInBytes = getCgroupMemoryLimitInBytes(memoryControlGroup);
            final long mem = (long) getFreeSwapSpaceSize.invoke(osMxBean);  
    public static OsProbe getInstance() {
                return Constants.OS_NAME;
            logger.warn("getTotalPhysicalMemorySize is not available");
    }
     * @param controlGroup the control group for the OpenSearch process for the {@code memory} subsystem
        for (final String line : lines) {  
                case "nr_throttled":  
        getSystemLoadAverage = getMethod("getSystemLoadAverage");
        try {
     * @param controlGroup the control group for the OpenSearch process for the {@code cpuacct} subsystem
                    break;
        }
     * @throws IOException if an I/O exception occurs reading the file  
                return -1L;
     * On macOS, this method should return the 1-minute load average.
    }
     */
            refreshInterval,  
        try {
    private static final Method getSystemCpuLoad;
                }  
     * The lines from {@code /etc/os-release} or {@code /usr/lib/os-release} as a fallback, with an additional fallback to
import org.apache.logging.log4j.Logger;
            final long mem = (long) getTotalSwapSpaceSize.invoke(osMxBean);  
    }
import java.util.concurrent.atomic.AtomicBoolean;
            }  
 * compatible open source license.
        } else {
     * (The alternative would have been <code>BigInteger</code> but then it would not be possible to index  
    /**  
    public long getTotalSwapSpaceSize() {  
    private AtomicBoolean isCpuStatWarningsLogged = new AtomicBoolean(false);
 *
                        if (kb < 0L) {
            if (numberOfPeriods == -1) {  
                if (logger.isDebugEnabled()) {
            }
     */
        }
    /**
 * You may obtain a copy of the License at  
            Constants.OS_NAME,  
                logger.debug("OS reported a negative total swap space size [{}]", mem);
                return 0;  
            }  
     */
            return 0;
     *
        } catch (Exception e) {  
     *
     */
                    numberOfTimesThrottled = Long.parseLong(fields[1]);
        try {  
            return false;
        long timeThrottledNanos = -1;
    public OsStats osStats() {
    @SuppressForbidden(reason = "access /sys/fs/cgroup/cpuacct")
import java.lang.management.OperatingSystemMXBean;
                return 0;  
    }
            return -1L;  
                final String cpuControlGroup = controllerMap.get("cpu");
     * The system load averages as an array.
        for (final String line : readProcSelfStatus()) {  
/*
    }  
     */
    List<String> readOsRelease() throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return 0;  
     * nr_throttled} is the number of times tasks in the given control group have been throttled, and {@code throttled_time} is the total
             * version 2 hierarchy. For cgroups version 1
import java.nio.file.Files;
    /**  
     *  
     * @return the total CPU time in nanoseconds
     * Basic cgroup stats.
        }
    private long getCgroupCpuAcctCpuCfsQuotaMicros(final String controlGroup) throws IOException {
    }
     * Package-private so tests can override with a synthetic file layout.  
     * @throws IOException if an I/O exception occurs reading {@code cpu.cfs_period_us} for the control group
            return 0;
                    return null;
 * Modifications Copyright OpenSearch Contributors. See
        }
     *
    List<String> readProcSelfStatus() throws IOException {  
        return readSysFsCgroupMemoryLimitInBytes(controlGroup);
            assert fields.length == 3;
     */
     */
     * @throws IOException if an I/O exception occurs reading {@code cpu.cfs_period_us} for the control group
        return readSingleLine(PathUtils.get("/sys/fs/cgroup/cpu", controlGroup, "cpu.cfs_period_us"));  
     * <p>
     * @throws IOException if an I/O exception occurs reading {@code /etc/os-release} or {@code /usr/lib/os-release} or
    private static final Method getFreePhysicalMemorySize;
            Constants.OS_VERSION  
    /**  
            return 0;  
     * @throws IOException if an I/O exception occurs reading the file
            final String[] controllers = fields[1].split(",");  
     * @return the line from {@code cpu.cfs_period_us}
     * The total period of time in microseconds for how frequently the OpenSearch control group's access to CPU resources will be
            }
        return controllerMap;
        final List<String> lines;  
 */  
            final List<String> prettyNameLines = etcOsReleaseLines.stream()
        if (isCpuStatWarningsLogged.getAndSet(true) == false) {
package org.opensearch.monitor.os;
import org.opensearch.monitor.Probes;  
     * @return the lines from {@code /etc/os-release} or {@code /usr/lib/os-release} or {@code /etc/system-release}  
     *
            logger.warn("exception retrieving free physical memory", e);
    /**
     * cpuacct} subsystem.
     * Returns a given method of the OperatingSystemMXBean, or null if the method is not found or unavailable.
     */
    final double[] getSystemLoadAverage() {
     * the hierarchy, and the last field representing the control group.  
        assert lines.size() == 1 : String.join("\n", lines);  
                assert matcher.groupCount() == 2 : trimmedPrettyNameLine;
     * @throws IOException if an I/O exception occurs reading {@code /proc/self/cgroup}
     *
     */  
            if (freeMem < 0) {
     * @return the line from {@code /proc/loadavg} or {@code null}  
                    cgroupMemoryUsageInBytes
    }
    public long getFreePhysicalMemorySize() {  
     * The total time in microseconds that all tasks in the OpenSearch control group can run during one period as specified by {@code
    boolean areCgroupStatsAvailable() {
        assert lines != null && !lines.isEmpty();
                    logger.debug("error reading /proc/loadavg", e);
            getPrettyName(),
    private OsStats.Cgroup getCgroup() {
            for (final String controller : controllers) {
        }
        final List<String> lines = readProcSelfCgroup();
                return new double[] { oneMinuteLoadAverage >= 0 ? oneMinuteLoadAverage : -1, -1, -1 };  
            return Class.forName("com.sun.management.OperatingSystemMXBean").getMethod(methodName);
import org.opensearch.common.io.PathUtils;
     * the OS stats document into OpenSearch without losing information, as <code>BigInteger</code> is
    public long getFreeSwapSpaceSize() {  
        final OsStats.Mem mem = new OsStats.Mem(getTotalPhysicalMemorySize(), getFreePhysicalMemorySize());  
     *
    /**  
            logger.warn("getFreePhysicalMemorySize is not available");
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
                .filter(line -> line.startsWith("PRETTY_NAME"))
     *  
     * @return the {@code RssAnon} value in bytes, or {@code -1L} when the line is missing or
    }
     */
 *
        if (getTotalPhysicalMemorySize == null) {
                final String controlGroupPath;
                assert previous == null;
                    logger.debug("no [cpu] data found in cgroup stats");
     * not a supported OpenSearch type.)  
/*  
/**
        if (Files.exists(PathUtils.get("/etc/os-release"))) {
     */
    }
import java.util.Map;  
        }
    }
        final OsStats.Swap swap = new OsStats.Swap(getTotalSwapSpaceSize(), getFreeSwapSpaceSize());
 * - An error case retrieving these values from a linux kernel
     * nr_periods \d+
                final String[] fields = procLoadAvg.split("\\s+");  
                final String memoryControlGroup = controllerMap.get("memory");
            }
     * The maximum amount of user memory (including file cache).
            assert lines != null && lines.isEmpty() == false;
                } else {
     * @throws IOException if an I/O exception occurs reading {@code memory.limit_in_bytes} for the control group
     * user-visible warnings must wrap this method themselves.  
                        logger.warn("malformed RssAnon value in /proc/self/status", nfe);  
                    logger.debug("no [cpuacct] data found in cgroup stats");  
    private Map<String, String> getControlGroups() throws IOException {  
     *         the value is unparseable/negative
                final OsStats.Cgroup.CpuStat cpuStat = getCgroupCpuAcctCpuStat(cpuControlGroup);  
                if (cpuAcctControlGroup == null) {
                }  
                final String[] parts = line.split("\\s+");  
import java.util.regex.Matcher;  
    public long getProcessNativeMemoryBytes() {  
                    logger.debug("no [memory] data found in cgroup stats");
     * Returns the lines from {@code cpu.stat} for the control group to which the OpenSearch process belongs for the {@code cpu}
            return 0;
     * Returns the line from {@code cpu.cfs_quota_us} for the control group to which the OpenSearch process belongs for the {@code cpu}
                    }
    /**  
                return null;
    String readSysFsCgroupCpuAcctCpuAcctUsage(final String controlGroup) throws IOException {  
    }
        if (getFreePhysicalMemorySize == null) {
                final String procLoadAvg = readProcLoadavg();
     *
    }
     * @return {@code true} if the stats are available, otherwise {@code false}
    }
        }  
     *
    }
     * with the first field representing the hierarchy ID, the second field representing a comma-separated list of the subsystems bound to
        } catch (Exception e) {  
     * {@code memory} subsystem. This line represents the total current memory usage by processes in the cgroup (in bytes).
    private String readSingleLine(final Path path) throws IOException {
     */  
                }
                    return null;
     * not a supported OpenSearch type.)
     */
     * Returns the line from {@code memory.usage_in_bytes} for the control group to which the OpenSearch process belongs for the
        if (Constants.LINUX == false) {
    @SuppressForbidden(reason = "access /sys/fs/cgroup/cpu")
    /**
 * The OS can report a negative number in a number of cases:
            /*
                final long cgroupCpuAcctUsageNanos = getCgroupCpuAcctUsageNanos(cpuAcctControlGroup);  
     * @param controlGroup the control group for the OpenSearch process for the {@code memory} subsystem
        private static final OsProbe INSTANCE = new OsProbe();
        }
     * @return the CFS quota in microseconds
import java.lang.management.ManagementFactory;  
    }
    /**
     * The total CPU time in nanoseconds consumed by all tasks in the cgroup to which the OpenSearch process belongs for the {@code
 * this work for additional information regarding copyright
                    cpuControlGroup,
            final String[] fields = line.split("\\s+");
     * @return the total current memory usage by processes in the cgroup (in bytes)
     * Returns the amount of free physical memory in bytes.
     * If there is no limit then some Linux versions return the maximum value that can be stored in an
            return false;
    // respect to /proc/self/cgroup; for Docker containers this should be set to "/"
        );
                final String cpuAcctControlGroup = controllerMap.get("cpuacct");
    }  
                    cgroupMemoryLimitInBytes,  
    OsInfo osInfo(long refreshInterval, int allocatedProcessors) throws IOException {
    private static final Method getSystemLoadAverage;  
    @SuppressForbidden(reason = "access /proc/self/status")
     * @return the line from {@code memory.usage_in_bytes}
import java.util.stream.Collectors;
     * line in this file represents a control group hierarchy of the form
 * - A failure of macOS to initialize host statistics
     * where {@code nr_periods} is the number of period intervals as specified by {@code cpu.cfs_period_us} that have elapsed, {@code  
                assert procLoadAvg.matches("(\\d+\\.\\d+\\s+){3}\\d+/\\d+\\s+\\d+");
    }
        final List<String> lines = Files.readAllLines(PathUtils.get("/proc/self/cgroup"));
     */
            assert lines != null && lines.isEmpty() == false;  
     */
     *  
        return Files.readAllLines(PathUtils.get("/proc/self/status"));
                logger.warn("Expected to see nr_throttled filed but found nothing");
 * under the License.  
    public long getProcessRssAnon() {
     * The CPU time statistics for all tasks in the OpenSearch control group.  
        }  
        getFreeSwapSpaceSize = getMethod("getFreeSwapSpaceSize");  
     * line is missing or malformed. Failure paths are logged at debug level; callers that want
                final String cgroupMemoryUsageInBytes = getCgroupMemoryUsageInBytes(memoryControlGroup);
                return 0;  
 * this file be licensed under the Apache-2.0 license or a
     *
    @SuppressForbidden(reason = "access /etc/os-release or /usr/lib/os-release or /etc/system-release")
        return lines;  
 * license agreements. See the NOTICE file distributed with
    /**
    /**
     * Returns the total amount of physical memory in bytes.
    }  
             * newline-separated key-value pairs. The key and value are separated by an equals symbol (=). The value can unquoted, or  
     * throttled_time \d+
                    cgroupCpuAcctCpuCfsPeriodMicros,
 * In some exceptional cases, it's possible the underlying native methods used by
     * @return the CFS quota period in microseconds  
        } else {
        return readSingleLine(PathUtils.get("/sys/fs/cgroup/memory", controlGroup, "memory.usage_in_bytes"));
    }
        }
    private OsStats.Cgroup.CpuStat getCgroupCpuAcctCpuStat(final String controlGroup) throws IOException {  
        } else if (Files.exists(PathUtils.get("/etc/system-release"))) {  
     * Returns the line from {@code cpu.cfs_period_us} for the control group to which the OpenSearch process belongs for the {@code cpu}
     * {@code /proc/self/status} and returns it in bytes. Returns {@code -1L} when the host is  
     * Reads the {@code RssAnon} field (anonymous resident memory) of the current process from
                if (logger.isDebugEnabled()) {  
        } else {
                return 0;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                final long cgroupCpuAcctCpuCfsPeriodMicros = getCgroupCpuAcctCpuCfsPeriodMicros(cpuControlGroup);
    private String getCgroupMemoryUsageInBytes(final String controlGroup) throws IOException {
                assert matches : trimmedPrettyNameLine;
                assert !controllerMap.isEmpty();
    }
        long numberOfPeriods = -1;
     * Reads the {@code RssAnon} field from {@code /proc/self/status}.
    /**  
        final OsStats.Cgroup cgroup = Constants.LINUX ? getCgroup() : null;
                logger.warn("RssAnon line has unexpected shape: [{}]", line);
        } catch (Exception e) {  
             */
                final Matcher matcher = Pattern.compile("PRETTY_NAME=(\"?|'?)?([^\"']+)\\1").matcher(trimmedPrettyNameLine);
    /**  
     * Returns the total amount of swap space in bytes.
     * @return the available system load averages or {@code null}  
     * @param controlGroup the control group for the OpenSearch process for the {@code cpuacct} subsystem
 * {@link #getFreeSwapSpaceSize()}, and {@link #getTotalSwapSpaceSize()} can return a
import org.apache.logging.log4j.LogManager;
        }
                return matcher.group(2);  
                }  
     * @return the CPU time statistics  
    }
     */
 * Licensed to Elasticsearch under one or more contributor  
             * We read the lines from /etc/os-release (or /usr/lib/os-release) to extract the PRETTY_NAME. The format of this file is
     * unsigned 64 bit number, and this will overflow a long, hence the result type is <code>String</code>.  
     * not Linux, when {@code /proc/self/status} cannot be read, or when the {@code RssAnon:}
     *
import java.util.Collections;  
            return mem;
    @SuppressForbidden(reason = "access /sys/fs/cgroup/cpu")
            if (getSystemLoadAverage == null) {
        if (getFreeSwapSpaceSize == null) {
            final Optional<String> maybePrettyNameLine = prettyNameLines.size() == 1
                        return -1L;
            }
        final List<String> lines = Files.readAllLines(PathUtils.get("/sys/fs/cgroup/cpu", controlGroup, "cpu.stat"));
        return readSingleLine(PathUtils.get("/sys/fs/cgroup/cpuacct", controlGroup, "cpuacct.usage"));
        final OsStats.Cpu cpu = new OsStats.Cpu(getSystemCpuPercent(), getSystemLoadAverage());
 * <p>
     * @return the line from {@code cpu.cfs_quota_us}  
    /**
    }
     * @param controlGroup the control group for the OpenSearch process for the {@code cpuacct} subsystem
import java.lang.reflect.InvocationTargetException;
        }
            return false;
     * @param controlGroup the control group to which the OpenSearch process belongs for the {@code cpu} subsystem
    private final Logger logger;  
    /**
        long nonHeapCommitted = memMx.getNonHeapMemoryUsage().getCommitted();
        if (!Files.exists(PathUtils.get("/sys/fs/cgroup/cpu"))) {  
     */
            return Constants.OS_NAME;  
                    cpuAcctControlGroup,
            }  
                logger.warn("Expected to see nr_periods filed but found nothing");
                     */
            return null;  
            return Collections.singletonList("PRETTY_NAME=\"" + lines.get(0) + "\"");
 * the Apache License, Version 2.0 (the "License"); you may
        }
        return OsProbeHolder.INSTANCE;  
 * software distributed under the License is distributed on an
            }
            allocatedProcessors,
     *  
        } catch (IOException e) {
    }
        assert lines != null && lines.isEmpty() == false;
                logger.debug("OS reported a negative total memory value [{}]", totalMem);
 */
            if (totalMem < 0) {
     * reallocated.  
     * @throws IOException if the file cannot be opened or read  
        return Long.parseLong(readSysFsCgroupCpuAcctCpuAcctUsage(controlGroup));  
            if (line.startsWith("RssAnon:")) {
                final Map<String, String> controllerMap = getControlGroups();
import org.opensearch.common.SuppressForbidden;
            } else {
                if (cpuControlGroup == null) {  
    private static final Method getFreeSwapSpaceSize;
                ? Optional.of(prettyNameLines.get(0))  
    /**  
        var memMx = ManagementFactory.getMemoryMXBean();
             * three colon-separated fields of the form hierarchy-ID:subsystem-list:cgroup-path. For cgroups version 1 hierarchies, the  
     * @return the lines from {@code cpu.stat}
        }  
     * @return basic cgroup stats, or {@code null} if an I/O exception occurred reading the cgroup stats  
     * @throws IOException if an I/O exception occurs reading {@code cpu.cfs_quota_us} for the control group  
     * field is two numbers separated by a slash, the first is the number of currently runnable scheduling entities, the second is the  
            return Collections.emptyList();  
    }
     *
 */  
        } catch (final IOException e) {
     * @param controlGroup the control group for the OpenSearch process for the {@code cpuacct} subsystem
     * @return the lines from {@code /proc/self/status}
     * {@code /sys/fs/cgroup/cpuacct} and {@code /sys/fs/cgroup/memory}.  
        return readSysFsCgroupMemoryUsageInBytes(controlGroup);  
                case "nr_periods":  
            return lines;
        for (final String line : lines) {  
 * - An overflow of the product of {@code _SC_PHYS_PAGES} and {@code _SC_PAGE_SIZE}  
    }
            final String[] fields = line.split(":");
     * @throws IOException if an I/O exception occurs reading {@code cpuacct.usage} for the control group  
     * subsystem. This line represents the period of time in microseconds for how frequently the control group's access to CPU resources  
    String readProcLoadavg() throws IOException {  
                if (parts.length >= 2) {
    String readSysFsCgroupMemoryUsageInBytes(final String controlGroup) throws IOException {  
                // Format: "RssAnon:\t 12345 kB"
            return false;
     * The line from {@code /proc/loadavg}. The first three fields are the load averages averaged over 1, 5, and 15 minutes. The fourth
    private static final OperatingSystemMXBean osMxBean = ManagementFactory.getOperatingSystemMXBean();  
import java.io.IOException;
                    /*
 *
        try {
        } else if (Files.exists(PathUtils.get("/usr/lib/os-release"))) {
        return Math.max(0L, rssAnon - heapCommitted - nonHeapCommitted);
        if (getTotalSwapSpaceSize == null) {
     * cpu.cfs_period_us}.
        if (Constants.LINUX) {  
            /*
     *
     * The lines from {@code /proc/self/cgroup}. This file represents the control groups to which the OpenSearch process belongs. Each  
import java.util.Optional;
                return null;
                    controlGroupPath = CONTROL_GROUPS_HIERARCHY_OVERRIDE;  
     * @throws IOException if an I/O exception occurs reading {@code cpu.stat} for the control group
        this(LogManager.getLogger(OsProbe.class));
     * {@code /etc/system-release}. These files represent identification of the underlying operating system. The structure of the file is  
import java.util.regex.Pattern;
             * wrapped in single- or double-quotes.
import java.nio.file.Path;
                        }  
                     * an undocumented hack for overriding the control group path. Do not rely on this hack, it will be removed.
     *  
     */
 * returning 0 instead.  
            assert prettyNameLines.size() <= 1 : prettyNameLines;
                    } catch (NumberFormatException nfe) {
    OsProbe(final Logger logger) {  
            return -1L;  
 * SPDX-License-Identifier: Apache-2.0
     * @throws IOException if an I/O exception occurs reading {@code memory.limit_in_bytes} for the control group  
    private long getCgroupCpuAcctCpuCfsPeriodMicros(final String controlGroup) throws IOException {  
     */
        if (!Files.exists(PathUtils.get("/sys/fs/cgroup/memory"))) {  
     * @param controlGroup the control group to which the OpenSearch process belongs for the {@code cpuacct} subsystem
 * @opensearch.internal
            return null;
                return null;
 * memory, as well as the system load average and cpu load.  
            return mem;
                    controlGroupPath = fields[2];
                );
     *  
            return lines;
            logger.warn("exception retrieving total swap space size", e);
     * @return the maximum amount of user memory (including file cache)  
    @SuppressForbidden(reason = "access /sys/fs/cgroup/cpu")  
     * will be reallocated.
    }  
            logger.warn("failed to read /proc/self/status", e);
             * subsystem-list is a comma-separated list of subsystems. The subsystem-list can be empty if the hierarchy represents a cgroups
                    cpuStat,
             */  
        }  
     * Reads a file containing a single line.
     * @throws IOException if an I/O exception occurs reading {@code memory.usage_in_bytes} for the control group  
            final long totalMem = (long) getTotalPhysicalMemorySize.invoke(osMxBean);  
     * subsystem. These lines represent the CPU time statistics and have the form  
        }
            if (timeThrottledNanos == -1) {  
        return new OsStats.Cgroup.CpuStat(numberOfPeriods, numberOfTimesThrottled, timeThrottledNanos);
/*  
     * @return the lines from {@code /proc/self/cgroup}
                    numberOfPeriods = Long.parseLong(fields[1]);
     */
     */
        getFreePhysicalMemorySize = getMethod("getFreeMemorySize");
        long numberOfTimesThrottled = -1;  
     */  
                return null;  
            }  
public class OsProbe {
            }  
        getTotalSwapSpaceSize = getMethod("getTotalSwapSpaceSize");
            logger.debug("error reading control group stats", e);
            return readRssAnonFromProcSelfStatus();  
            }  
    /**
     * nr_throttled \d+  
        return readSingleLine(PathUtils.get("/proc/loadavg"));
                logger.warn("Expected to see throttled_time filed but found nothing");
    /**
 * The {@link OsProbe} class retrieves information about the physical and swap size of the machine
     * time in nanoseconds for which tasks in the given control group have been throttled.
                    return null;
        final List<String> lines = Files.readAllLines(path);
     * @param controlGroup the control group to which the OpenSearch process belongs for the {@code cpu} subsystem
    }
    /**  
        getSystemCpuLoad = getMethod("getCpuLoad");  
    private static Method getMethod(String methodName) {  
    @SuppressForbidden(reason = "access /proc/self/cgroup, /sys/fs/cgroup/cpu, /sys/fs/cgroup/cpuacct and /sys/fs/cgroup/memory")
     */
                final long cgroupCpuAcctCpuCfsQuotaMicros = getCgroupCpuAcctCpuCfsQuotaMicros(cpuControlGroup);
                // we trim since some OS contain trailing space, for example, Oracle Linux Server 6.9 has a trailing space after the quote  
                     * will be fixed in future versions of Docker with cgroup namespaces, but this requires modern kernels. Thus, we provide  
    private static final String CONTROL_GROUPS_HIERARCHY_OVERRIDE = System.getProperty("opensearch.cgroups.hierarchy.override");  
            } catch (final IOException e) {
    }
    String readSysFsCgroupCpuAcctCpuCfsPeriod(final String controlGroup) throws IOException {
    public long getTotalPhysicalMemorySize() {  
 * not use this file except in compliance with the License.
                    break;
            }
        return Long.parseLong(readSysFsCgroupCpuAcctCpuCfsPeriod(controlGroup));
}  
     * A map of the control groups to which the OpenSearch process belongs. Note that this is a map because the control groups can vary  
        getTotalPhysicalMemorySize = getMethod("getTotalMemorySize");
     * <p>
        return readSingleLine(PathUtils.get("/sys/fs/cgroup/cpu", controlGroup, "cpu.cfs_quota_us"));
     */  
            return freeMem;
     * @return the line from {@code cpuacct.usage}
    /*For testing purpose*/
            lines = Files.readAllLines(PathUtils.get("/usr/lib/os-release"));  
        if (!Files.exists(PathUtils.get("/proc/self/cgroup"))) {  
     *
     */
            // fallback for older Red Hat-like OS
        } catch (Exception e) {  
     * @throws IOException if an I/O exception occurs reading {@code /proc/self/cgroup}  
import org.apache.lucene.util.Constants;  
    /**
    OsProbe() {
        if (!Files.exists(PathUtils.get("/sys/fs/cgroup/cpuacct"))) {  
            return -1L;  
            final long freeMem = (long) getFreePhysicalMemorySize.invoke(osMxBean);  
                logger.debug("OS reported a negative free memory value [{}]", freeMem);
            final List<String> etcOsReleaseLines = readOsRelease();  
    @SuppressForbidden(reason = "access /sys/fs/cgroup/memory")  
    List<String> readSysFsCgroupCpuAcctCpuStat(final String controlGroup) throws IOException {  
            return 0;
    String readSysFsCgroupMemoryLimitInBytes(final String controlGroup) throws IOException {
     * <blockquote><pre>
     * unsigned 64 bit number, and this will overflow a long, hence the result type is <code>String</code>.
                return new double[] { Double.parseDouble(fields[0]), Double.parseDouble(fields[1]), Double.parseDouble(fields[2]) };
        } else if (Constants.LINUX) {
                final String previous = controllerMap.put(controller, controlGroupPath);
        return new OsStats.Builder().timestamp(System.currentTimeMillis()).cpu(cpu).mem(mem).swap(swap).cgroup(cgroup).build();  
    }
 */  
    }
 * Unless required by applicable law or agreed to in writing,
        return lines;  
     * subsystem. This line represents the total CPU time in nanoseconds consumed by all tasks in the same control group.
        // TODO: return a prettier name on non-Linux OS
    long readRssAnonFromProcSelfStatus() throws IOException {
     * newlines of key-value pairs of shell-compatible variable assignments.
     * Returns the line from {@code memory.limit_in_bytes} for the control group to which the OpenSearch process belongs for the
            // not available
     * <p>
                     * Docker violates the relationship between /proc/self/cgroup and the /sys/fs/cgroup hierarchy. It's possible that this
     * @param controlGroup the control group to which the OpenSearch process belongs for the {@code memory} subsystem
    /**  
 * <p>
    @SuppressForbidden(reason = "access /proc/self/cgroup")
                .collect(Collectors.toList());  
        try {
            try {  
 * - An OS that does not support the {@code _SC_PHYS_PAGES} or {@code _SC_PAGE_SIZE} flags for the {@code sysconf()} linux kernel call
     * from subsystem to subsystem. Additionally, this map can not be cached because a running process can be reclassified.
    }  
                final double oneMinuteLoadAverage = (double) getSystemLoadAverage.invoke(osMxBean);
                    break;
            logger.warn("getFreeSwapSpaceSize is not available");
    public short getSystemCpuPercent() {
 * negative value. Because of this, we prevent those methods from returning negative values,
     * On Windows, this method returns {@code null}.  
     * number of scheduling entities on the system. The fifth field is the PID of the most recently created process.
import java.lang.reflect.Method;  
    /**  
     * @return a map from subsystems to the control group for the OpenSearch process.  
                    cgroupCpuAcctUsageNanos,  
    /**  
    private static class OsProbeHolder {
     * Checks if cgroup stats are available by checking for the existence of {@code /proc/self/cgroup}, {@code /sys/fs/cgroup/cpu},
     * (The alternative would have been <code>BigInteger</code> but then it would not be possible to index
     * On Linux, this method returns the 1, 5, and 15-minute load averages.
    /**
            return null;
                            return -1L;
     */
            logger.warn("exception retrieving free swap space size", e);
     * @throws IOException if an I/O exception occurs reading {@code memory.limit_in_bytes} for the control group
 * - Non-supported OSes (HP-UX, or AIX)  
                }
                    cgroupCpuAcctCpuCfsQuotaMicros,  
                }
            if (numberOfTimesThrottled == -1) {  
     *                     {@code /etc/system-release}
    List<String> readProcSelfCgroup() throws IOException {  
    /**  
     * @return the line from {@code memory.limit_in_bytes}  
    }
 *  
    /**
        return Probes.getLoadAndScaleToPercent(getSystemCpuLoad, osMxBean);  
        }
 * ownership. Elasticsearch licenses this file to you under  
        try {
        return -1L;  
     *
    private static final Method getTotalSwapSpaceSize;
            if (!areCgroupStatsAvailable()) {
     * </pre></blockquote>
