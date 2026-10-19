                }
                    return null;
    String readSysFsCgroupMemoryLimitInBytes(final String controlGroup) throws IOException {
package org.opensearch.monitor.os;
 * <p>
        long nonHeapCommitted = memMx.getNonHeapMemoryUsage().getCommitted();
        } else if (Files.exists(PathUtils.get("/usr/lib/os-release"))) {
        return Probes.getLoadAndScaleToPercent(getSystemCpuLoad, osMxBean);
        return controllerMap;
     * Returns the amount of free swap space in bytes.
    }
 * Unless required by applicable law or agreed to in writing,
    /**
        }
            if (maybePrettyNameLine.isPresent()) {
     */
        long rssAnon = getProcessRssAnon();
            return -1L;
        }
     * @param controlGroup the control group for the OpenSearch process for the {@code cpuacct} subsystem
        } else {
        if (!Files.exists(PathUtils.get("/sys/fs/cgroup/cpuacct"))) {
     * A map of the control groups to which the OpenSearch process belongs. Note that this is a map because the control groups can vary
            assert Constants.MAC_OS_X;
     * <blockquote><pre>
                assert matcher.groupCount() == 2 : trimmedPrettyNameLine;
     * The lines from {@code /proc/self/cgroup}. This file represents the control groups to which the OpenSearch process belongs. Each
            logger.warn("getFreeSwapSpaceSize is not available");
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
     *
     * @return the total CPU time in nanoseconds
    private final Logger logger;
        if (rssAnon < 0L) {
        }
        final List<String> lines = Files.readAllLines(PathUtils.get("/sys/fs/cgroup/cpu", controlGroup, "cpu.stat"));
     * @return the line from {@code cpuacct.usage}
                        }
            return false;
        }
import java.nio.file.Files;
        return readSysFsCgroupMemoryUsageInBytes(controlGroup);
                        return -1L;
    }
    String readSysFsCgroupMemoryUsageInBytes(final String controlGroup) throws IOException {
        return Long.parseLong(readSysFsCgroupCpuAcctCpuAcctUsage(controlGroup));
            return -1L;
    }
    private OsStats.Cgroup getCgroup() {
                }
     * @throws IOException if an I/O exception occurs reading {@code memory.limit_in_bytes} for the control group
     * (The alternative would have been <code>BigInteger</code> but then it would not be possible to index
    }
 * license agreements. See the NOTICE file distributed with
    }
    /**
        }
 * In some exceptional cases, it's possible the underlying native methods used by
                final String procLoadAvg = readProcLoadavg();
     * <p>
    /**
     * @return a map from subsystems to the control group for the OpenSearch process.
 * Modifications Copyright OpenSearch Contributors. See
            final List<String> etcOsReleaseLines = readOsRelease();
                     * an undocumented hack for overriding the control group path. Do not rely on this hack, it will be removed.
            }
    }
 * KIND, either express or implied.  See the License for the
     */
     */
                            return -1L;
 * <p>
             * wrapped in single- or double-quotes.
    public short getSystemCpuPercent() {
                // we trim since some OS contain trailing space, for example, Oracle Linux Server 6.9 has a trailing space after the quote
     * (The alternative would have been <code>BigInteger</code> but then it would not be possible to index
     * the hierarchy, and the last field representing the control group.
        }
        } catch (Exception e) {
        } else {
        if (Constants.LINUX) {
    /**
            return null;
 * - A non-standard libc implementation not implementing the required values
    String readSysFsCgroupCpuAcctCpuAcctCfsQuota(final String controlGroup) throws IOException {
                    }
    }
                final Map<String, String> controllerMap = getControlGroups();
        final Map<String, String> controllerMap = new HashMap<>();
            return 0;
                ? Optional.of(prettyNameLines.get(0))
                logger.warn("Expected to see throttled_time filed but found nothing");
     * On Linux, this method returns the 1, 5, and 15-minute load averages.
            } else {
    public long getFreePhysicalMemorySize() {
        if (!Files.exists(PathUtils.get("/proc/self/cgroup"))) {
        }
                return null;
    public long getFreeSwapSpaceSize() {
    }
            if (freeMem < 0) {
            refreshInterval,
     * Checks if cgroup stats are available by checking for the existence of {@code /proc/self/cgroup}, {@code /sys/fs/cgroup/cpu},
    }
            if (getSystemLoadAverage == null) {
        }
            lines = Files.readAllLines(PathUtils.get("/etc/os-release"));
                }
     *
            final String[] fields = line.split("\\s+");
     */
     */
                    logger.debug("no [memory] data found in cgroup stats");
            }
    }
    private String getPrettyName() throws IOException {
    private static final Method getSystemLoadAverage;
                    cgroupCpuAcctCpuCfsQuotaMicros,
            }
 * memory, as well as the system load average and cpu load.
        return true;
     *
     * {@code \d+:([^:,]+(?:,[^:,]+)?):(/.*)}
        getFreePhysicalMemorySize = getMethod("getFreeMemorySize");
import java.lang.reflect.InvocationTargetException;
    /**
     * If there is no limit then some Linux versions return the maximum value that can be stored in an
     * time in nanoseconds for which tasks in the given control group have been throttled.
                assert matches : trimmedPrettyNameLine;
            if (numberOfTimesThrottled == -1) {
            return false;
    }
     */
            return lines;
    private static final String CONTROL_GROUPS_HIERARCHY_OVERRIDE = System.getProperty("opensearch.cgroups.hierarchy.override");
                return 0;
        for (final String line : readProcSelfStatus()) {
    }
    }
     *
            assert lines != null && lines.isEmpty() == false;
            }
                     * Docker violates the relationship between /proc/self/cgroup and the /sys/fs/cgroup hierarchy. It's possible that this
 * SPDX-License-Identifier: Apache-2.0
                return Constants.OS_NAME;
     * @return basic cgroup stats, or {@code null} if an I/O exception occurred reading the cgroup stats
        try {
            return 0;
     * The CPU time statistics for all tasks in the OpenSearch control group.
                        return kb * 1024L;
                    try {
     * Reads a file containing a single line.
     */
 * - An overflow of the product of {@code _SC_PHYS_PAGES} and {@code _SC_PAGE_SIZE}
                final String memoryControlGroup = controllerMap.get("memory");
     *
            return -1L;
 * this work for additional information regarding copyright
     * @throws IOException if an I/O exception occurs reading {@code cpuacct.usage} for the control group
            return 0;
     * subsystem. This line represents the total time in microseconds that all tasks in the control group can run during one period as
        var memMx = ManagementFactory.getMemoryMXBean();
     */
     * @throws IOException if an I/O exception occurs reading {@code /proc/self/cgroup}
import java.lang.management.ManagementFactory;
     * the OS stats document into OpenSearch without losing information, as <code>BigInteger</code> is
        return readSingleLine(PathUtils.get("/sys/fs/cgroup/cpu", controlGroup, "cpu.cfs_period_us"));
    String readSysFsCgroupCpuAcctCpuCfsPeriod(final String controlGroup) throws IOException {
        return new OsStats.Builder().timestamp(System.currentTimeMillis()).cpu(cpu).mem(mem).swap(swap).cgroup(cgroup).build();
            logger.warn("getFreePhysicalMemorySize is not available");
            }
    /**
import java.nio.file.Path;
                assert previous == null;
        long numberOfTimesThrottled = -1;
    @SuppressForbidden(reason = "access /sys/fs/cgroup/cpu")
            return 0;
import java.util.concurrent.atomic.AtomicBoolean;
                return 0;
                    break;
     * field is two numbers separated by a slash, the first is the number of currently runnable scheduling entities, the second is the
    boolean areCgroupStatsAvailable() {
    private String readSingleLine(final Path path) throws IOException {
        } catch (IOException e) {
     * @return the single line
                case "nr_throttled":
    @SuppressForbidden(reason = "access /proc/self/cgroup, /sys/fs/cgroup/cpu, /sys/fs/cgroup/cpuacct and /sys/fs/cgroup/memory")
            return 0;
     * unsigned 64 bit number, and this will overflow a long, hence the result type is <code>String</code>.
import java.util.List;
    // respect to /proc/self/cgroup; for Docker containers this should be set to "/"
            return false;
        return readSysFsCgroupMemoryLimitInBytes(controlGroup);
/**
     * Reads the contents of {@code /proc/self/status} as a list of lines, one per key.
            /*
     * @return the line from {@code memory.usage_in_bytes}
        final List<String> lines = Files.readAllLines(PathUtils.get("/proc/self/cgroup"));
                    cgroupMemoryLimitInBytes,
        for (final String line : lines) {
     * subsystem. These lines represent the CPU time statistics and have the form
                case "nr_periods":
            return 0;
        }
        if (getFreeSwapSpaceSize == null) {
     * Reads the {@code RssAnon} field from {@code /proc/self/status}.
            }
    @SuppressForbidden(reason = "access /sys/fs/cgroup/cpu")
                    controlGroupPath = CONTROL_GROUPS_HIERARCHY_OVERRIDE;
            assert prettyNameLines.size() <= 1 : prettyNameLines;
        return lines;
                    controlGroupPath = fields[2];
     * Returns the line from {@code cpuacct.usage} for the control group to which the OpenSearch process belongs for the {@code cpuacct}
        return new OsStats.Cgroup.CpuStat(numberOfPeriods, numberOfTimesThrottled, timeThrottledNanos);
     * The lines from {@code /etc/os-release} or {@code /usr/lib/os-release} as a fallback, with an additional fallback to
     * nr_throttled \d+
     * {@code /sys/fs/cgroup/cpuacct} and {@code /sys/fs/cgroup/memory}.
     * not Linux, when {@code /proc/self/status} cannot be read, or when the {@code RssAnon:}
    }
     * </pre></blockquote>
 */
     * Returns the lines from {@code cpu.stat} for the control group to which the OpenSearch process belongs for the {@code cpu}
        this(LogManager.getLogger(OsProbe.class));
     */
     */
                if (parts.length >= 2) {
                    break;
            }
     * {@code memory} subsystem. This line represents the maximum amount of user memory (including file cache).
     *         the value is unparseable/negative
            }
        }
                    cgroupCpuAcctCpuCfsPeriodMicros,
        );
                        logger.warn("malformed RssAnon value in /proc/self/status", nfe);
            return false;
                if (CONTROL_GROUPS_HIERARCHY_OVERRIDE != null) {
    @SuppressForbidden(reason = "access /sys/fs/cgroup/memory")
     * newlines of key-value pairs of shell-compatible variable assignments.
     * @param controlGroup the control group to which the OpenSearch process belongs for the {@code cpu} subsystem
     * Returns the line from {@code memory.limit_in_bytes} for the control group to which the OpenSearch process belongs for the
    String readSysFsCgroupCpuAcctCpuAcctUsage(final String controlGroup) throws IOException {
            return null;
 * - A failure of macOS to initialize host statistics
        }
     */
                    logger.debug("no [cpuacct] data found in cgroup stats");
    /**
                    cpuStat,
        } catch (Exception e) {
     * Returns the line from {@code memory.usage_in_bytes} for the control group to which the OpenSearch process belongs for the
            Constants.OS_NAME,
                return null;
    private static final Method getFreeSwapSpaceSize;
                final long cgroupCpuAcctCpuCfsQuotaMicros = getCgroupCpuAcctCpuCfsQuotaMicros(cpuControlGroup);
            // fallback for older Red Hat-like OS
     *
            logger.debug("error reading control group stats", e);
        final List<String> lines = readProcSelfCgroup();
                assert procLoadAvg.matches("(\\d+\\.\\d+\\s+){3}\\d+/\\d+\\s+\\d+");
            try {
    /**
     * @throws IOException if an I/O exception occurs reading {@code cpu.stat} for the control group
 * negative value. Because of this, we prevent those methods from returning negative values,
                return matcher.group(2);
     * subsystem. This line represents the period of time in microseconds for how frequently the control group's access to CPU resources
    private static class OsProbeHolder {
    @SuppressForbidden(reason = "access /proc/self/cgroup")
     * @return the line from {@code memory.limit_in_bytes}
     * @throws IOException if an I/O exception occurs reading {@code cpu.cfs_period_us} for the control group
        for (final String line : lines) {
    private long getCgroupCpuAcctCpuCfsQuotaMicros(final String controlGroup) throws IOException {
            for (final String controller : controllers) {
        return -1L;
     * @throws IOException if an I/O exception occurs reading {@code memory.usage_in_bytes} for the control group
    @SuppressForbidden(reason = "access /sys/fs/cgroup/cpuacct")
                case "throttled_time":
            return readRssAnonFromProcSelfStatus();
    }
        return readSingleLine(PathUtils.get("/sys/fs/cgroup/cpuacct", controlGroup, "cpuacct.usage"));
    public OsStats osStats() {
     * @throws IOException if an I/O exception occurs reading the file
     *
    }
     * Returns the line from {@code cpu.cfs_quota_us} for the control group to which the OpenSearch process belongs for the {@code cpu}
    // this property is to support a hack to workaround an issue with Docker containers mounting the cgroups hierarchy inconsistently with
            lines = Files.readAllLines(PathUtils.get("/usr/lib/os-release"));
    }
     * @return the maximum amount of user memory (including file cache)
     * @throws IOException if an I/O exception occurs reading {@code cpu.cfs_quota_us} for the control group
            if (mem < 0) {
                logger.warn("Expected to see nr_periods filed but found nothing");
     * cpuacct} subsystem.
                final String cpuControlGroup = controllerMap.get("cpu");
    /**
    }
    OsProbe(final Logger logger) {
                final long cgroupCpuAcctCpuCfsPeriodMicros = getCgroupCpuAcctCpuCfsPeriodMicros(cpuControlGroup);
 * The OS can report a negative number in a number of cases:
     *
    /**
    private static final Method getTotalSwapSpaceSize;
            /*
     * The maximum amount of user memory (including file cache).
                     * will be fixed in future versions of Docker with cgroup namespaces, but this requires modern kernels. Thus, we provide
                    cpuAcctControlGroup,
        if (getFreePhysicalMemorySize == null) {
        if (!Files.exists(PathUtils.get("/sys/fs/cgroup/cpu"))) {
    /**
            try {
     *                     {@code /etc/system-release}
    private static final Method getFreePhysicalMemorySize;
     * @param controlGroup the control group for the OpenSearch process for the {@code cpuacct} subsystem
    }
    }
     * Returns a given method of the OperatingSystemMXBean, or null if the method is not found or unavailable.
     * cpu.cfs_period_us}.
        try {
                logger.warn("Expected to see nr_throttled filed but found nothing");
                if (logger.isDebugEnabled()) {
    @SuppressForbidden(reason = "access /sys/fs/cgroup/cpu")
        try {
import java.util.stream.Collectors;
            return 0;
     * @return the available system load averages or {@code null}
            } catch (IllegalAccessException | InvocationTargetException e) {
    List<String> readSysFsCgroupCpuAcctCpuStat(final String controlGroup) throws IOException {
     */
            logger.warn("exception retrieving free physical memory", e);
import org.opensearch.common.io.PathUtils;
        }
                final String cpuAcctControlGroup = controllerMap.get("cpuacct");
             */
     *
            assert fields.length == 3;
            return mem;
    /**
                    logger.debug("no [cpu] data found in cgroup stats");
        // TODO: return a prettier name on non-Linux OS
        }
                final String previous = controllerMap.put(controller, controlGroupPath);
                .collect(Collectors.toList());
                if (memoryControlGroup == null) {
                final String cgroupMemoryUsageInBytes = getCgroupMemoryUsageInBytes(memoryControlGroup);
            }
     * @throws IOException if an I/O exception occurs reading {@code cpu.stat} for the control group
            final String[] controllers = fields[1].split(",");
            return mem;
     */
     *
    private Map<String, String> getControlGroups() throws IOException {
    }
                if (cpuControlGroup == null) {
}
        return Long.parseLong(readSysFsCgroupCpuAcctCpuAcctCfsQuota(controlGroup));
     * Returns the total amount of swap space in bytes.
 * - An error case retrieving these values from a linux kernel
    /**
     * Reads the {@code RssAnon} field (anonymous resident memory) of the current process from
     * @return the {@code RssAnon} value in bytes, or {@code -1L} when the line is missing or
    }
            lines = Files.readAllLines(PathUtils.get("/etc/system-release"));
 */
                final double oneMinuteLoadAverage = (double) getSystemLoadAverage.invoke(osMxBean);
        return Files.readAllLines(PathUtils.get("/proc/self/status"));
 * software distributed under the License is distributed on an
                final Matcher matcher = Pattern.compile("PRETTY_NAME=(\"?|'?)?([^\"']+)\\1").matcher(trimmedPrettyNameLine);
 * compatible open source license.
        } catch (Exception e) {
            getPrettyName(),
            return null;
        this.logger = logger;
     * subsystem. This line represents the total CPU time in nanoseconds consumed by all tasks in the same control group.
import java.util.Optional;
                final String controlGroupPath;
 * For a more exhaustive explanation, see https://github.com/elastic/elasticsearch/pull/42725
    public long getTotalPhysicalMemorySize() {
            logger.warn("getTotalSwapSpaceSize is not available");
 * {@link #getFreePhysicalMemorySize()}, {@link #getTotalPhysicalMemorySize()},
     * The total CPU time in nanoseconds consumed by all tasks in the cgroup to which the OpenSearch process belongs for the {@code
     * The total period of time in microseconds for how frequently the OpenSearch control group's access to CPU resources will be
    List<String> readOsRelease() throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (getTotalPhysicalMemorySize == null) {
                );
            } catch (final IOException e) {
                if (logger.isDebugEnabled()) {
    }
import org.opensearch.monitor.Probes;
     * reallocated.
import org.apache.logging.log4j.Logger;
    /**
                return new OsStats.Cgroup(
                    numberOfTimesThrottled = Long.parseLong(fields[1]);
    private static Method getMethod(String methodName) {
                    return null;
        final List<String> lines = Files.readAllLines(path);
     * line is missing or malformed. Failure paths are logged at debug level; callers that want
     * @param controlGroup the control group for the OpenSearch process for the {@code cpuacct} subsystem
     */
    private String getCgroupMemoryLimitInBytes(final String controlGroup) throws IOException {
        if (Constants.LINUX == false) {
        }
     * @throws IOException if an I/O exception occurs reading {@code memory.limit_in_bytes} for the control group
            logger.warn("exception retrieving total physical memory", e);
 * GitHub history for details.
        try {
     * The system load averages as an array.
        return Math.max(0L, rssAnon - heapCommitted - nonHeapCommitted);
        try {
             * three colon-separated fields of the form hierarchy-ID:subsystem-list:cgroup-path. For cgroups version 1 hierarchies, the
        final OsStats.Cgroup cgroup = Constants.LINUX ? getCgroup() : null;
                return 0;
     * nr_throttled} is the number of times tasks in the given control group have been throttled, and {@code throttled_time} is the total
     * specified by {@code cpu.cfs_period_us}.
        } else if (Constants.LINUX) {
     * @throws IOException if an I/O exception occurs reading {@code /proc/self/cgroup}
        long timeThrottledNanos = -1;
             */
        getSystemCpuLoad = getMethod("getCpuLoad");
     * number of scheduling entities on the system. The fifth field is the PID of the most recently created process.
    @SuppressForbidden(reason = "access /proc/self/status")
     * @throws IOException if an I/O exception occurs reading {@code cpu.cfs_quota_us} for the control group
            return 0;
     * @throws IOException if an I/O exception occurs reading {@code cpu.cfs_period_us} for the control group
            Constants.OS_ARCH,
        }
     * If there is no limit then some Linux versions return the maximum value that can be stored in an
                    logger.debug("error reading one minute load average from operating system", e);
        getSystemLoadAverage = getMethod("getSystemLoadAverage");
    }
 * - Non-supported OSes (HP-UX, or AIX)
     * not a supported OpenSearch type.)
                    /*
        if (Files.exists(PathUtils.get("/etc/os-release"))) {
     *
     * @return the CPU time statistics
     * <p>
             * newline-separated key-value pairs. The key and value are separated by an equals symbol (=). The value can unquoted, or
            return Collections.singletonList("PRETTY_NAME=\"" + lines.get(0) + "\"");
                .filter(line -> line.startsWith("PRETTY_NAME"))
                final OsStats.Cgroup.CpuStat cpuStat = getCgroupCpuAcctCpuStat(cpuControlGroup);
            logger.warn("exception retrieving total swap space size", e);
        final OsStats.Cpu cpu = new OsStats.Cpu(getSystemCpuPercent(), getSystemLoadAverage());
            final String[] fields = line.split(":");
 * @opensearch.internal
     * line in this file represents a control group hierarchy of the form
            return lines;
        if (Constants.WINDOWS) {
            final long totalMem = (long) getTotalPhysicalMemorySize.invoke(osMxBean);
            assert lines != null && lines.isEmpty() == false;
     * throttled_time \d+
 *
     *
                return null;
                    numberOfPeriods = Long.parseLong(fields[1]);
        }
            final Optional<String> maybePrettyNameLine = prettyNameLines.size() == 1
     * Package-private so tests can override with a synthetic file layout.
     * @param controlGroup the control group to which the OpenSearch process belongs for the {@code cpu} subsystem
     * @throws IOException if the file cannot be opened or read
        }
     * <p>
     */
                logger.debug("OS reported a negative free swap space size [{}]", mem);
     * the OS stats document into OpenSearch without losing information, as <code>BigInteger</code> is
    /**
    private long getCgroupCpuAcctUsageNanos(final String controlGroup) throws IOException {
                     */
     */
            logger.warn("getTotalPhysicalMemorySize is not available");
        return readSingleLine(PathUtils.get("/sys/fs/cgroup/memory", controlGroup, "memory.limit_in_bytes"));
            return Class.forName("com.sun.management.OperatingSystemMXBean").getMethod(methodName);
        assert lines.size() == 1 : String.join("\n", lines);
                }
     * Returns the total amount of physical memory in bytes.
        if (getTotalSwapSpaceSize == null) {
     * @throws IOException if an I/O exception occurs reading {@code /etc/os-release} or {@code /usr/lib/os-release} or
import java.util.regex.Matcher;
    List<String> readProcSelfStatus() throws IOException {
                    cpuControlGroup,
/*
            return totalMem;
                final boolean matches = matcher.matches();
    String readProcLoadavg() throws IOException {
import java.util.regex.Pattern;
            return Collections.emptyList();
 *
    }
     *
     *
            return Constants.OS_NAME;
     */
        }
     * Returns the amount of free physical memory in bytes.
    private AtomicBoolean isCpuStatWarningsLogged = new AtomicBoolean(false);
     * @return the line from {@code /proc/loadavg} or {@code null}
    private static final Method getSystemCpuLoad;
/*
    }
     * @return the CFS quota in microseconds
            }
        if (isCpuStatWarningsLogged.getAndSet(true) == false) {
    /**
    public static OsProbe getInstance() {
     */
     *
    }
                final String cgroupMemoryLimitInBytes = getCgroupMemoryLimitInBytes(memoryControlGroup);
     * @return the line from {@code cpu.cfs_quota_us}
             * We read the lines from /etc/os-release (or /usr/lib/os-release) to extract the PRETTY_NAME. The format of this file is
     * @param controlGroup the control group to which the OpenSearch process belongs for the {@code cpu} subsystem
                logger.warn("RssAnon line has unexpected shape: [{}]", line);
     */
            Constants.OS_VERSION
                return -1L;
     * On Windows, this method returns {@code null}.
    }
     * On macOS, this method should return the 1-minute load average.
 * - An OS that does not support the {@code _SC_PHYS_PAGES} or {@code _SC_PAGE_SIZE} flags for the {@code sysconf()} linux kernel call
     * {@code /etc/system-release}. These files represent identification of the underlying operating system. The structure of the file is
        getTotalPhysicalMemorySize = getMethod("getTotalMemorySize");
        logger.warn("RssAnon line not found in /proc/self/status");
     * where {@code nr_periods} is the number of period intervals as specified by {@code cpu.cfs_period_us} that have elapsed, {@code
    /**
    }
 * The {@link OsProbe} class retrieves information about the physical and swap size of the machine
                    break;
import java.lang.reflect.Method;
     * @return the lines from {@code cpu.stat}
     * {@code /proc/self/status} and returns it in bytes. Returns {@code -1L} when the host is
     * not a supported OpenSearch type.)
     * @param controlGroup the control group for the OpenSearch process for the {@code memory} subsystem
            Runtime.getRuntime().availableProcessors(),
        assert lines != null && lines.isEmpty() == false;
     */
                logger.debug("OS reported a negative total swap space size [{}]", mem);
import java.util.Collections;
                : Optional.empty();
public class OsProbe {
        }
                    } catch (NumberFormatException nfe) {
    private long getCgroupCpuAcctCpuCfsPeriodMicros(final String controlGroup) throws IOException {
            if (mem < 0) {
        } else {
                    timeThrottledNanos = Long.parseLong(fields[1]);
 * not use this file except in compliance with the License.
    private OsStats.Cgroup.CpuStat getCgroupCpuAcctCpuStat(final String controlGroup) throws IOException {
            }
        return readSingleLine(PathUtils.get("/sys/fs/cgroup/cpu", controlGroup, "cpu.cfs_quota_us"));
     */
 * The OpenSearch Contributors require contributions made to
    /**
            return freeMem;
     *
            logger.warn("exception retrieving free swap space size", e);
import java.util.Map;
import org.apache.logging.log4j.LogManager;
     *
            // not available
                return 0;
    long readRssAnonFromProcSelfStatus() throws IOException {
                    cgroupMemoryUsageInBytes
        return new OsInfo(
    private static final OperatingSystemMXBean osMxBean = ManagementFactory.getOperatingSystemMXBean();
        return lines;
        return OsProbeHolder.INSTANCE;
 * ownership. Elasticsearch licenses this file to you under
    public long getProcessNativeMemoryBytes() {
     * @param controlGroup the control group to which the OpenSearch process belongs for the {@code memory} subsystem
                }
        } catch (final IOException e) {
     */
    /**
 * returning 0 instead.
    public long getProcessRssAnon() {
        private static final OsProbe INSTANCE = new OsProbe();
 * the Apache License, Version 2.0 (the "License"); you may
        return readSingleLine(PathUtils.get("/proc/loadavg"));
            switch (fields[0]) {
     */
            final long mem = (long) getTotalSwapSpaceSize.invoke(osMxBean);
        return lines.get(0);
     * @return the lines from {@code /proc/self/status}
     * @throws IOException if an I/O exception occurs reading the file
     * <p>
             * version 2 hierarchy. For cgroups version 1
    final double[] getSystemLoadAverage() {
     *
             * The virtual file /proc/self/cgroup lists the control groups that the OpenSearch process is a member of. Each line contains
    /**
     * The total time in microseconds that all tasks in the OpenSearch control group can run during one period as specified by {@code
                        if (kb < 0L) {
    /*For testing purpose*/
        long heapCommitted = memMx.getHeapMemoryUsage().getCommitted();
     * @throws IOException if an I/O exception occurs reading {@code cpuacct.usage} for the control group
     * <p>
 * specific language governing permissions and limitations
     * @return {@code true} if the stats are available, otherwise {@code false}
    }
    @SuppressForbidden(reason = "access /proc/loadavg")
        final OsStats.Mem mem = new OsStats.Mem(getTotalPhysicalMemorySize(), getFreePhysicalMemorySize());
                    return null;
                final String trimmedPrettyNameLine = maybePrettyNameLine.get().trim();
                if (cpuAcctControlGroup == null) {
        final List<String> lines = readSysFsCgroupCpuAcctCpuStat(controlGroup);
                } else {
     * @param controlGroup the control group to which the OpenSearch process belongs for the {@code memory} subsystem
    }
        if (!Files.exists(PathUtils.get("/sys/fs/cgroup/memory"))) {
    @SuppressForbidden(reason = "access /etc/os-release or /usr/lib/os-release or /etc/system-release")
            if (timeThrottledNanos == -1) {
     * @return the {@code RssAnon} value in bytes, or {@code -1L} if unavailable
                }
    /**
 */
     * @return the lines from {@code /etc/os-release} or {@code /usr/lib/os-release} or {@code /etc/system-release}
            final long freeMem = (long) getFreePhysicalMemorySize.invoke(osMxBean);
    }
            }
                    memoryControlGroup,
        try {
     * @param controlGroup the control group for the OpenSearch process for the {@code memory} subsystem
                return new double[] { Double.parseDouble(fields[0]), Double.parseDouble(fields[1]), Double.parseDouble(fields[2]) };
        } catch (Exception e) {
     * from subsystem to subsystem. Additionally, this map can not be cached because a running process can be reclassified.
        }
import org.apache.lucene.util.Constants;
        assert lines != null && !lines.isEmpty();
            }
 */
     * Basic cgroup stats.
    /**
     * @return the total current memory usage by processes in the cgroup (in bytes)
            } else {
        getTotalSwapSpaceSize = getMethod("getTotalSwapSpaceSize");
            if (!areCgroupStatsAvailable()) {
                // Format: "RssAnon:\t 12345 kB"
        }
        try {
            final long mem = (long) getFreeSwapSpaceSize.invoke(osMxBean);
        } else if (Files.exists(PathUtils.get("/etc/system-release"))) {
            logger.warn("failed to read /proc/self/status", e);
import java.io.IOException;
                }
    }
    OsProbe() {
 * Licensed to Elasticsearch under one or more contributor
    }
                final long cgroupCpuAcctUsageNanos = getCgroupCpuAcctUsageNanos(cpuAcctControlGroup);
     * Returns the line from {@code cpu.cfs_period_us} for the control group to which the OpenSearch process belongs for the {@code cpu}
                        final long kb = Long.parseLong(parts[1]);
    }
    /**
                assert !controllerMap.isEmpty();
     * @param controlGroup the control group to which the OpenSearch process belongs for the {@code cpuacct} subsystem
        final OsStats.Swap swap = new OsStats.Swap(getTotalSwapSpaceSize(), getFreeSwapSpaceSize());
                final String[] parts = line.split("\\s+");
     *
     */
    private String getCgroupMemoryUsageInBytes(final String controlGroup) throws IOException {
                    logger.debug("error reading /proc/loadavg", e);
        return Long.parseLong(readSysFsCgroupCpuAcctCpuCfsPeriod(controlGroup));
 * {@link #getFreeSwapSpaceSize()}, and {@link #getTotalSwapSpaceSize()} can return a
     * will be reallocated.
import org.opensearch.common.SuppressForbidden;
 * under the License.
import java.lang.management.OperatingSystemMXBean;
     * {@code memory} subsystem. This line represents the total current memory usage by processes in the cgroup (in bytes).
    OsInfo osInfo(long refreshInterval, int allocatedProcessors) throws IOException {
     * @param path path to the file to read
 * this file be licensed under the Apache-2.0 license or a
     * with the first field representing the hierarchy ID, the second field representing a comma-separated list of the subsystems bound to
    public long getTotalSwapSpaceSize() {
            }
/*
     *
    }
     * The total current memory usage by processes in the cgroup (in bytes).
     */
     */
     * @return the line from {@code cpu.cfs_period_us}
        long numberOfPeriods = -1;
        }
                return new double[] { oneMinuteLoadAverage >= 0 ? oneMinuteLoadAverage : -1, -1, -1 };
    /**
import java.util.HashMap;
     * @return the CFS quota period in microseconds
    List<String> readProcSelfCgroup() throws IOException {
     * @return the lines from {@code /proc/self/cgroup}
 * You may obtain a copy of the License at
    private static final Method getTotalPhysicalMemorySize;
        }
             * subsystem-list is a comma-separated list of subsystems. The subsystem-list can be empty if the hierarchy represents a cgroups
    static {
     * user-visible warnings must wrap this method themselves.
     * nr_periods \d+
            if (line.startsWith("RssAnon:")) {
     * The line from {@code /proc/loadavg}. The first three fields are the load averages averaged over 1, 5, and 15 minutes. The fourth
    /**
            if (numberOfPeriods == -1) {
    /**
     * unsigned 64 bit number, and this will overflow a long, hence the result type is <code>String</code>.
                logger.debug("OS reported a negative free memory value [{}]", freeMem);
    /**
     */
                logger.debug("OS reported a negative total memory value [{}]", totalMem);
            allocatedProcessors,
        }
                final String[] fields = procLoadAvg.split("\\s+");
        } catch (Exception e) {
     *
            final List<String> prettyNameLines = etcOsReleaseLines.stream()
     * @throws IOException if an I/O exception occurs reading {@code memory.limit_in_bytes} for the control group
        getFreeSwapSpaceSize = getMethod("getFreeSwapSpaceSize");
     * @param controlGroup the control group for the OpenSearch process for the {@code cpuacct} subsystem
                return null;
                    cgroupCpuAcctUsageNanos,
            assert lines != null && lines.size() == 1;
    @SuppressForbidden(reason = "access /sys/fs/cgroup/memory")
 *
            if (totalMem < 0) {
        final List<String> lines;
    }
     *
     */
    }
            }
 *
     *
        return readSingleLine(PathUtils.get("/sys/fs/cgroup/memory", controlGroup, "memory.usage_in_bytes"));
