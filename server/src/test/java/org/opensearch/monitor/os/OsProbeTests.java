                return Arrays.asList("nr_periods 17992", "nr_throttled 1311", "throttled_time 139298645489");
            @Override
        final OsProbe probe = new OsProbe(logger) {
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/66629")
                // These could be null if transported from a node running an older version, but shouldn't be null on the current node
        OsProbe probe = new OsProbe() {
                    "State:\tS (sleeping)",
            "4:hugetlb:/",
        };
            // unknown system, but the best case is that we have the one-minute load average
                    "VmPeak:\t 12345 kB",
        assertThat(info.getVersion(), equalTo(Constants.OS_VERSION));
            assertEquals(extra, probe.getProcessNativeMemoryBytes());
        // This cgroup data is missing a line about memory
            @Override
                assertThat(stats.getCgroup().getCpuStat().getNumberOfElapsedPeriods(), greaterThanOrEqualTo(0L));
        assumeFalse("test runs on non-Linux only", Constants.LINUX);
            assertThat(cgroup.getCpuAcctUsageNanos(), equalTo(364869866063112L));
        assertThat(probe.readRssAnonFromProcSelfStatus(), equalTo(-1L));
    public void testGetProcessRssAnon_negativeOnNonLinux() {
            assertThat(loadAverage[2], greaterThanOrEqualTo((double) 0));
                return areCgroupStatsAvailable;
        assertBusy(() -> {
            List<String> readProcSelfCgroup() {
        long extra = 64L * 1024L * 1024L;
        final Logger logger = mock(Logger.class);
    }
import static org.mockito.ArgumentMatchers.eq;
        assertThat(systemLoadAverage[1], equalTo(Double.parseDouble("1.69")));
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        assertNull(cgroup);
        assertThat(probe.readRssAnonFromProcSelfStatus(), equalTo(-1L));
        assertThat(systemLoadAverage.length, equalTo(3));
                    final String quote = randomFrom("\"", "'", "");
        assertNull(cgroup);
        }
    public void testReadRssAnonFromProcSelfStatusValidValue() throws IOException {
        final OsProbe probe = new OsProbe(logger) {
                return Arrays.asList("Name:\topensearch", "VmPeak:\t  131072 kB", "RssAnon:\t  12345 kB", "RssShmem:\t  64 kB");
        if (total > 0) {
            boolean areCgroupStatsAvailable() {
                assert Constants.LINUX : Constants.OS_NAME;
    public void testLogWarnCpuMessageOnlyOnes() {
            }
            }
            List<String> readOsRelease() throws IOException {
        assertEquals(-1L, OsProbe.getInstance().getProcessRssAnon());
                    final String space = randomFrom(" ", "");
            if (stats.getCgroup() != null) {
import static org.mockito.Mockito.verify;
            List<String> readProcSelfStatus() {
                return Collections.singletonList("RssAnon:\t  -1 kB");
                throw new IOException("synthetic");
    private static OsProbe buildStubOsProbe(final boolean areCgroupStatsAvailable, final String hierarchy) {
                );
import static org.mockito.Mockito.mock;
            List<String> readProcSelfStatus() {
        OsProbe probe = new OsProbe() {
            @Override
            @Override
            assertThat(cgroup.getCpuStat().getNumberOfElapsedPeriods(), equalTo(17992L));
            assertNotNull(loadAverage);
        final String hierarchy = randomAlphaOfLength(16);
            }
            assertThat(cgroup.getCpuCfsQuotaMicros(), equalTo(50000L));
                assertThat(stats.getCgroup().getMemoryUsageInBytes(), notNullValue());
                assertThat(stats.getCgroup().getCpuStat().getTimeThrottledNanos(), greaterThanOrEqualTo(0L));
        assertThat(
        final double[] systemLoadAverage = probe.getSystemLoadAverage();
        };
            }
        assumeThat("requires Linux to exercise the /proc/self/status path", Constants.LINUX, is(true));
            List<String> readProcSelfStatus() {
import org.apache.logging.log4j.Logger;
            }
        final OsStats.Cgroup cgroup = probe.osStats().getCgroup();
    }
        assertThat(info.getAvailableProcessors(), equalTo(Runtime.getRuntime().availableProcessors()));
        if (Constants.LINUX) {
            @Override
            .collect(Collectors.toList());
            @Override
            @Override
            assertNull(cgroup);
        assertNotNull(stats.getSwap().getTotal());
        };
 *
        assertThat(stats.getTimestamp(), greaterThan(0L));
        return Arrays.asList(
    public void testGetProcessNativeMemoryBytes_subtractsCommittedAndClampsAtZero() {
    }
}
            }
        final boolean areCgroupStatsAvailable,
            }
            assertThat(stats.getSwap().getTotal().getBytes(), greaterThan(0L));
import org.apache.lucene.util.Constants;
        }
                assertThat(stats.getCgroup().getMemoryLimitInBytes(), notNullValue());
     * @param procSelfCgroupLines the lines that will be used as the content of <code>/proc/self/cgroup</code>
        final OsStats.Cgroup cgroup = probe.osStats().getCgroup();
        assertNotNull(stats.getMem());
        double[] loadAverage = stats.getCpu().getLoadAverage();
            // JVM committed memory may change between this snapshot and the snapshot taken by the probe.
            assertNull(loadAverage);
            }
        if (Constants.LINUX) {
            }
        assertEquals(-1L, probe.getProcessNativeMemoryBytes());
import static org.mockito.ArgumentMatchers.any;
import org.opensearch.test.OpenSearchTestCase;
        }
    public void testGetProcessRssAnonHandlesIOException() {
            assertThat(loadAverage[0], greaterThanOrEqualTo((double) 0));
/*
        assertThat(info.getRefreshInterval(), equalTo(refreshInterval));
                public long getProcessRssAnon() {
    }
            assertThat(cgroup.getCpuControlGroup(), equalTo("/" + hierarchy));
            @Override
                    final String prettyNameLine = String.format(Locale.ROOT, "PRETTY_NAME=%s%s%s%s", quote, prettyName, quote, space);
        assertThat(stats.getMem().getTotal().getBytes(), greaterThan(0L));
    ) {
        assertEquals(-1L, probe.getProcessRssAnon());
        assertThat(info.getAllocatedProcessors(), equalTo(allocatedProcessors));
        final OsProbe probe = buildStubOsProbe(true, hierarchy, procSelfCgroupLines);
                    "RssShmem:\t   0 kB"
            // one minute load average is available, but 10-minute and 15-minute load averages are not
            prettyName = Constants.OS_NAME;
        };
                assertThat(stats.getCgroup().getCpuAcctControlGroup(), notNullValue());
                return Collections.singletonList("RssAnon:\t  0 kB");
            @Override
        final String prettyName;
import java.util.Collections;
 * not use this file except in compliance with the License.
        };
    public void testOsStats() {
    public void testReadRssAnonFromProcSelfStatusNegativeValue() throws IOException {
        );
        final OsProbe probe = buildStubOsProbe(areCgroupStatsAvailable, hierarchy);
    }
        assertThat(probe.readRssAnonFromProcSelfStatus(), equalTo(0L));
            List<String> readSysFsCgroupCpuAcctCpuStat(String controlGroup) throws IOException {
            assertThat(cgroup.getCpuStat().getTimeThrottledNanos(), equalTo(139298645489L));
        return buildStubOsProbe(areCgroupStatsAvailable, hierarchy, procSelfCgroupLines);
        if (Constants.WINDOWS) {
        final OsProbe probe = new OsProbe() {
 *
        assertThat(probe.getProcessRssAnon(), equalTo(4096L * 1024L));
            .map(line -> line.replaceFirst(":cpu,", ":"))
    public void testCgroupProbeWithMissingMemory() {
        final Logger logger = mock(Logger.class);
            List<String> readProcSelfStatus() {
import static org.mockito.Mockito.reset;
                return Collections.emptyList();
            @Override
        };
 * the Apache License, Version 2.0 (the "License"); you may
            "1:name=systemd:/user.slice/user-1000.slice/session-2359.scope",
            assertThat(stats.getSwap().getFree().getBytes(), equalTo(0L));
            assertNull(stats.getCgroup());
    }
            String readSysFsCgroupCpuAcctCpuCfsPeriod(String controlGroup) {
        final OsProbe probe = buildStubOsProbe(true, hierarchy, procSelfCgroupLines);
                }
    }
            }
        if (loadAverage != null) {
            }
 * Modifications Copyright OpenSearch Contributors. See
            @Override
                assertThat(stats.getCgroup().getCpuCfsPeriodMicros(), greaterThanOrEqualTo(0L));
        List<String> procSelfCgroupLines = getProcSelfGroupLines(hierarchy);
            List<String> readProcSelfStatus() {
        OsProbe probe = new OsProbe() {
            assertThat(cgroup.getCpuStat().getNumberOfTimesThrottled(), equalTo(1311L));
            List<String> readProcSelfStatus() {
    public void testReadRssAnonFromProcSelfStatusMissingLine() throws IOException {
        assumeTrue("test runs on Linux only", Constants.LINUX);
            }
            assertThat(loadAverage[2], equalTo((double) -1));
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.notNullValue;
            assertThat(stats.getSwap().getTotal().getBytes(), equalTo(0L));
                assertThat(info.getPrettyName(), equalTo(prettyName));
        assertThat(probe.readRssAnonFromProcSelfStatus(), equalTo(-1L));
        final OsProbe probe = new OsProbe() {
            }
 * license agreements. See the NOTICE file distributed with
        } else {
        assertThat(systemLoadAverage[0], equalTo(Double.parseDouble("1.51")));
        final String hierarchy = randomAlphaOfLength(16);
 * this file be licensed under the Apache-2.0 license or a
                    "Name:\topensearch",
    public void testGetProcessRssAnonReturnsBytes() {
                assertThat(controlGroup, equalTo("/" + hierarchy));
            List<String> readProcSelfStatus() throws IOException {
            @Override
            }
            .filter(line -> !line.contains(":memory:"))
        verify(logger, times(1)).warn("RssAnon line has unexpected shape: [{}]", "RssAnon:");
        );
        assertThat(probe.getProcessRssAnon(), equalTo(-1L));
import static org.mockito.Mockito.times;
            @Override
 * GitHub history for details.
                // RssAnon was added in kernel 4.5; pre-4.5 kernels expose only VmRSS.
        assertEquals(32768L * 1024L, probe.getProcessRssAnon());
            }
            "7:blkio:/",
                assertThat(controlGroup, equalTo("/" + hierarchy));
import static org.junit.Assume.assumeThat;
        if (Constants.LINUX) {
            }
     * the arguments to this method.
            @Override
        final Logger logger = mock(Logger.class);
    }
        };
        }
 * under the License.
            assertThat(loadAverage.length, equalTo(3));
                return 1L; // way below any real committed total
                // No whitespace after the label, so split produces a single token
                throw new AssertionError("readProcSelfStatus should not be called on non-Linux");
            @Override
     * @param areCgroupStatsAvailable whether or not cgroup data is available. Normally OsProbe establishes this for itself.
        assertThat(stats.getMem().getUsedPercent(), allOf(greaterThanOrEqualTo((short) 0), lessThanOrEqualTo((short) 100)));
     */
        assumeThat("requires Linux to exercise the /proc/self/status path", Constants.LINUX, is(true));
            }
     *
            if (loadAverage != null) {
import static org.hamcrest.CoreMatchers.not;
        };
    public void testGetProcessRssAnon_missingFieldReturnsNegative() {
                assertThat(stats.getCgroup().getCpuAcctUsageNanos(), greaterThan(0L));
            }
        final OsProbe probe = new OsProbe() {
    public void testGetProcessRssAnon_returnsNegativeOnIoError() {
        assumeTrue("test runs on Linux only", Constants.LINUX);
                assertThat(new BigInteger(stats.getCgroup().getMemoryUsageInBytes()), greaterThan(BigInteger.ZERO));
        assertThat(stats.getMem().getFreePercent(), allOf(greaterThanOrEqualTo((short) 0), lessThanOrEqualTo((short) 100)));
            assertThat(cgroup.getCpuAcctControlGroup(), equalTo("/" + hierarchy));
            assertThat(loadAverage[1], equalTo((double) -1));
 * You may obtain a copy of the License at
    }
                return Arrays.asList("Name:\topensearch", "VmRSS:\t  98304 kB", "RssAnon:\t  4096 kB", "RssFile:\t  2048 kB");
                assertThat(controlGroup, equalTo("/" + hierarchy));
        assumeTrue("test runs on Linux only", Constants.LINUX);
            stats.getCpu().getPercent(),
            @Override
        List<String> procSelfCgroupLines = getProcSelfGroupLines(hierarchy).stream()
            assertNotNull(cgroup);
            public long getProcessRssAnon() {
            assertThat(loadAverage[1], greaterThanOrEqualTo((double) 0));
        final OsProbe probe = new OsProbe(logger) {
                // This is the highest value that can be stored in an unsigned 64 bit number, hence too big for long
        };
                return Arrays.asList("Name:\topensearch", "State:\tS (sleeping)", "VmRSS:\t 65536 kB");
    // ---- /proc/self/status RssAnon parsing ----
        verify(logger, times(1)).warn(eq("malformed RssAnon value in /proc/self/status"), any(NumberFormatException.class));
    }
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
            @Override
        reset(logger);
            // we should be able to get the load average
    public void testCgroupProbe() {
        final OsProbe osProbe = new OsProbe();
            }
    public void testGetProcessRssAnonNotLinuxReturnsNegativeOne() {
        } else if (Constants.MAC_OS_X) {
        };
        if (areCgroupStatsAvailable) {
                    return rssAnon;
 * The OpenSearch Contributors require contributions made to
            "5:devices:/user.slice",
/*
                assertThat(loadAverage[2], equalTo((double) -1));
            public long getProcessRssAnon() {
import java.util.stream.Collectors;
        assertThat(info.getArch(), equalTo(Constants.OS_ARCH));
            }
 */
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            "10:freezer:/",
        assertThat(probe.readRssAnonFromProcSelfStatus(), equalTo(-1L));
    }
        // RssAnon below the JVM committed memory (early process lifetime, before the
    public void testGetProcessNativeMemoryBytes_returnsNegativeWhenRssAnonUnavailable() {
                    "RssFile:\t 20000 kB",
    }
                @Override
        OsStats stats = osProbe.osStats();
            // On platforms with no swap
import java.math.BigInteger;
        assumeThat("requires Linux to exercise the /proc/self/status path", Constants.LINUX, is(true));
    }
                assertThat(controlGroup, equalTo("/" + hierarchy));
        OsProbe probe = new OsProbe() {
 * compatible open source license.
        assumeThat("only meaningful on non-Linux platforms", Constants.LINUX, is(false));
                return "364869866063112";
import java.io.IOException;
        final OsProbe probe = buildStubOsProbe(true, hierarchy, procSelfCgroupLines);
    }
        final Logger logger = mock(Logger.class);
            .collect(Collectors.toList());
            @Override
        verify(logger, times(1)).warn("RssAnon line not found in /proc/self/status");
                return "1.51 1.69 1.99 3/417 23251";
import static org.hamcrest.Matchers.greaterThan;
            assertNotNull(loadAverage);
        final OsProbe probe = new OsProbe() {
            long heapCommitted = memMx.getHeapMemoryUsage().getCommitted();
    }
            }
    }
public class OsProbeTests extends OpenSearchTestCase {
    public void testGetSystemLoadAverage() {
import static org.mockito.ArgumentMatchers.anyString;
        List<String> procSelfCgroupLines = getProcSelfGroupLines(hierarchy).stream()
            assertThat(cgroup.getMemoryLimitInBytes(), equalTo("18446744073709551615"));
                throw new IOException("simulated failure");
        List<String> procSelfCgroupLines = getProcSelfGroupLines(hierarchy).stream()
        assertNull(cgroup);
            "2:cpu,cpuacct,cpuset:/" + hierarchy,
        // This cgroup data is missing a line about cpuacct
        noCpuStatsOsProbe.osStats();
                assertThat(new BigInteger(stats.getCgroup().getMemoryLimitInBytes()), greaterThan(BigInteger.ZERO));
        final Logger logger = mock(Logger.class);
                assertThat(info.getPrettyName(), equalTo(Constants.OS_NAME));
                assertThat(loadAverage[0], anyOf(equalTo((double) -1), greaterThanOrEqualTo((double) 0)));
                assertThat(stats.getCgroup().getMemoryControlGroup(), notNullValue());
        final String hierarchy = randomAlphaOfLength(16);
            }
package org.opensearch.monitor.os;
            List<String> readProcSelfStatus() {
        verify(logger, times(1)).warn("RssAnon line not found in /proc/self/status");
 * this work for additional information regarding copyright
        assertThat(probe.getProcessRssAnon(), equalTo(-1L));
        };
            } else {
        assumeTrue("test runs on Linux only", Constants.LINUX);
            @Override
        final int allocatedProcessors = randomIntBetween(1, Runtime.getRuntime().availableProcessors());
    }
    }
 *
            List<String> readSysFsCgroupCpuAcctCpuStat(String controlGroup) {
        final OsProbe noCpuStatsOsProbe = new OsProbe(logger) {
            }
            }
        final Logger logger = mock(Logger.class);
                    "VmRSS:\t 65536 kB",
        verify(logger, times(2)).warn(anyString());
    /**
            }
            @Override
    private static List<String> getProcSelfGroupLines(String hierarchy) {
 * Unless required by applicable law or agreed to in writing,
            if (prettyName != null) {
    }
    public void testReadRssAnonFromProcSelfStatusUnexpectedShape() throws IOException {
            "8:pids:/",
                } else {
            .collect(Collectors.toList());
                    "RssAnon:\t 32768 kB",
     * @return a test instance
            prettyName = randomFrom("Fedora 28 (Workstation Edition)", "Linux", null);
        final String hierarchy,
            "0::/cgroup2"
            .map(line -> line.replaceFirst(",cpuacct", ""))
            List<String> readProcSelfStatus() {
        final OsInfo info = osProbe.osInfo(refreshInterval, allocatedProcessors);
        final OsProbe osProbe = new OsProbe() {
        };
        assumeThat("CGroup is available", osStats.getCgroup(), is(not(nullValue())));
    public void testCgroupProbeWithMissingCpu() {
            @Override
                return Collections.singletonList("RssAnon:\tnotanumber kB");
    }
            long rssAnon = heapCommitted + nonHeapCommitted + extra;
        OsStats osStats = noCpuStatsOsProbe.osStats();
                assertThat(controlGroup, equalTo("/" + hierarchy));
/*
        };
            };
        final OsProbe probe = new OsProbe() {
                return Collections.singletonList("RssAnon:");
    public void testGetProcessRssAnon_presentField() {
import static org.mockito.Mockito.never;
    }
                assertThat(loadAverage[1], equalTo((double) -1));
        verify(logger, never()).warn(anyString());
    public void testReadRssAnonFromProcSelfStatusZeroValue() throws IOException {
    public void testGetProcessNativeMemoryBytes_returnsDifferenceWhenRssAnonExceedsCommitted() throws Exception {
        final String hierarchy = randomAlphaOfLength(16);
            String readSysFsCgroupMemoryUsageInBytes(String controlGroup) {
            }
    }
            assertThat(loadAverage[0], greaterThanOrEqualTo((double) 0));
        assertThat(systemLoadAverage[2], equalTo(Double.parseDouble("1.99")));
    }
        };
        assertThat(probe.readRssAnonFromProcSelfStatus(), equalTo(12345L * 1024L));
    private static OsProbe buildStubOsProbe(
import static org.hamcrest.Matchers.anyOf;
                    return Collections.singletonList("NAME=" + randomAlphaOfLength(16));
                return Collections.singletonList("nr_periods 1");
        };
import static org.hamcrest.Matchers.both;
 * specific language governing permissions and limitations
        assertThat(stats.getMem().getFree().getBytes(), greaterThan(0L));
        });
        assertNotNull(stats);
        // Depending on CGroups v1/v2, the cgroup stats may not be available
            List<String> readProcSelfStatus() {
        assertThat(probe.readRssAnonFromProcSelfStatus(), equalTo(-1L));
        assertNotNull(stats.getSwap());
    public void testCgroupProbeWithMissingCpuAcct() {
            }
        // Override getProcessRssAnon to return -1 (the "not supported" sentinel). The
            @Override
    // ---- getProcessNativeMemoryBytes (RssAnon - heapCommitted - nonHeapCommitted, clamped) ----
            assertThat(stats.getSwap().getFree().getBytes(), greaterThan(0L));
 */
        };
    }
            OsProbe probe = new OsProbe() {
                assertThat(stats.getCgroup().getCpuStat().getNumberOfTimesThrottled(), greaterThanOrEqualTo(0L));
            // load average is unavailable on Windows
        assertNotNull(systemLoadAverage);
                }
        // This cgroup data is missing a line about cpu
import static org.hamcrest.CoreMatchers.nullValue;
import java.util.Locale;
    public void testOsInfo() throws IOException {
                    return Arrays.asList("NAME=" + randomAlphaOfLength(16), prettyNameLine);
import static org.hamcrest.Matchers.equalTo;
        } else {
            String readProcLoadavg() {
        final long refreshInterval = randomBoolean() ? -1 : randomNonNegativeLong();
     * @param hierarchy a mock value used to generate a cgroup hierarchy.
            "3:perf_event:/",
        final OsStats.Cgroup cgroup = probe.osStats().getCgroup();
            String readSysFsCgroupMemoryLimitInBytes(String controlGroup) {
import java.util.Arrays;
        long total = stats.getSwap().getTotal().getBytes();
        final OsProbe probe = new OsProbe() {
                assertThat(stats.getCgroup().getCpuCfsQuotaMicros(), anyOf(equalTo(-1L), greaterThanOrEqualTo(0L)));
        List<String> procSelfCgroupLines
            long nonHeapCommitted = memMx.getNonHeapMemoryUsage().getCommitted();
        // OS resident set has caught up to the JVM's committed regions). The method
        OsProbe probe = new OsProbe() {
            @Override
        } else {
 */
        assertThat(info.getName(), equalTo(Constants.OS_NAME));
 * KIND, either express or implied.  See the License for the
        assertEquals(-1L, probe.getProcessRssAnon());
 * Licensed to Elasticsearch under one or more contributor
        assertEquals(0L, probe.getProcessNativeMemoryBytes());
                return "18446744073709551615";
    public void testReadRssAnonFromProcSelfStatusMalformedValue() throws IOException {
            java.lang.management.MemoryMXBean memMx = java.lang.management.ManagementFactory.getMemoryMXBean();
            List<String> readProcSelfStatus() throws IOException {
                return "4796416";
            anyOf(equalTo((short) -1), is(both(greaterThanOrEqualTo((short) 0)).and(lessThanOrEqualTo((short) 100))))
        };
            assertThat(stats.getSwap().getUsed().getBytes(), equalTo(0L));
        // method must propagate that signal upward without subtracting from -1.
            assertThat(cgroup.getCpuCfsPeriodMicros(), equalTo(100000L));
                return Arrays.asList(
            @Override
        }
            assertThat(cgroup.getMemoryUsageInBytes(), equalTo("4796416"));
import java.util.List;
        assertThat(stats.getMem().getUsed().getBytes(), greaterThan(0L));
        final OsProbe probe = new OsProbe(logger) {
    public void testReadRssAnonFromProcSelfStatusEmptyFile() throws IOException {
    }
                return "100000";
                return -1L;
        assumeTrue("test runs on Linux only", Constants.LINUX);
            "9:net_cls,net_prio:/",
                if (prettyName != null) {
            List<String> readProcSelfStatus() {
            assertThat(stats.getSwap().getUsed().getBytes(), greaterThanOrEqualTo(0L));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            String readSysFsCgroupCpuAcctCpuAcctCfsQuota(String controlGroup) {
            }
            @Override
        } else if (Constants.LINUX) {
    }
        }
 * ownership. Elasticsearch licenses this file to you under
        final OsStats.Cgroup cgroup = probe.osStats().getCgroup();
            List<String> readProcSelfStatus() {
        assumeThat("CGroups are available", noCpuStatsOsProbe.areCgroupStatsAvailable(), is(true));
                return Arrays.asList("Name:\topensearch", "VmRSS:\t  98304 kB");
        final boolean areCgroupStatsAvailable = randomBoolean();
 * software distributed under the License is distributed on an
        }
                return "50000";
            @Override
                return procSelfCgroupLines;
        assumeTrue("test runs on Linux only", Constants.LINUX);
        };
        assertNotNull(info);
            String readSysFsCgroupCpuAcctCpuAcctUsage(String controlGroup) {
        verify(logger, times(1)).warn(eq("failed to read /proc/self/status"), any(IOException.class));
        // no nr_throttled and throttled_time
    }
            }
        } else {
     * Builds a test instance of OsProbe. Methods that ordinarily read from the filesystem are overridden to return values based upon
    }
        final OsProbe probe = new OsProbe(logger) {
        assumeTrue("test runs on Linux only", Constants.LINUX);
        // must clamp at 0 instead of returning a negative.
 *    http://www.apache.org/licenses/LICENSE-2.0
        };
        return new OsProbe() {
        // avoid silliness with representing doubles
        } else {
            "6:memory:/" + hierarchy,
