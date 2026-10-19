            }
    public void testCgroupProbeWithMissingCpu() {
        assumeTrue("test runs on Linux only", Constants.LINUX);
            .map(line -> line.replaceFirst(",cpuacct", ""))
            stats.getCpu().getPercent(),
            }  
 * not use this file except in compliance with the License.
        };  
    }
            assertNull(stats.getCgroup());
        assumeThat("requires Linux to exercise the /proc/self/status path", Constants.LINUX, is(true));
 * You may obtain a copy of the License at  
    }
            List<String> readProcSelfStatus() {  
        final OsProbe probe = new OsProbe(logger) {
            @Override
        // no nr_throttled and throttled_time
            };
        assertThat(  
     *  
        List<String> procSelfCgroupLines  
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
                // RssAnon was added in kernel 4.5; pre-4.5 kernels expose only VmRSS.
        List<String> procSelfCgroupLines = getProcSelfGroupLines(hierarchy).stream()  
                assertThat(loadAverage[2], equalTo((double) -1));
            List<String> readProcSelfStatus() {
    }
            @Override
            assertThat(loadAverage.length, equalTo(3));  
/*
            .map(line -> line.replaceFirst(":cpu,", ":"))  
                return Arrays.asList(
        };
            @Override
    public void testGetProcessRssAnon_negativeOnNonLinux() {
        if (areCgroupStatsAvailable) {
                return "1.51 1.69 1.99 3/417 23251";  
            @Override
            long rssAnon = heapCommitted + nonHeapCommitted + extra;
                assertThat(stats.getCgroup().getCpuCfsQuotaMicros(), anyOf(equalTo(-1L), greaterThanOrEqualTo(0L)));
        final OsProbe probe = new OsProbe(logger) {  
            assertThat(cgroup.getCpuAcctUsageNanos(), equalTo(364869866063112L));
    }  
            String readSysFsCgroupMemoryLimitInBytes(String controlGroup) {
            assertThat(loadAverage[2], equalTo((double) -1));
    }
    }  
        }  
            @Override
        verify(logger, never()).warn(anyString());
        assertThat(probe.getProcessRssAnon(), equalTo(-1L));  
 * KIND, either express or implied.  See the License for the
                throw new IOException("simulated failure");  
            String readSysFsCgroupCpuAcctCpuAcctUsage(String controlGroup) {  
        final OsProbe probe = new OsProbe() {  
        // This cgroup data is missing a line about cpu
                assertThat(stats.getCgroup().getMemoryLimitInBytes(), notNullValue());
        final Logger logger = mock(Logger.class);  
            }  
    public void testReadRssAnonFromProcSelfStatusValidValue() throws IOException {
     * @param procSelfCgroupLines the lines that will be used as the content of <code>/proc/self/cgroup</code>  
        assertThat(probe.readRssAnonFromProcSelfStatus(), equalTo(-1L));  
    public void testGetProcessRssAnonHandlesIOException() {  
        reset(logger);  
            "8:pids:/",  
        final String hierarchy = randomAlphaOfLength(16);
        final Logger logger = mock(Logger.class);
        if (Constants.WINDOWS) {
        noCpuStatsOsProbe.osStats();
                assertThat(info.getPrettyName(), equalTo(prettyName));
            assertThat(cgroup.getMemoryLimitInBytes(), equalTo("18446744073709551615"));
        } else {
    public void testGetSystemLoadAverage() {  
        final boolean areCgroupStatsAvailable,
        assertBusy(() -> {  
        OsProbe probe = new OsProbe() {
        };
            @Override  
import java.util.Collections;
        // method must propagate that signal upward without subtracting from -1.
 * this file be licensed under the Apache-2.0 license or a
     * @param areCgroupStatsAvailable whether or not cgroup data is available. Normally OsProbe establishes this for itself.
            anyOf(equalTo((short) -1), is(both(greaterThanOrEqualTo((short) 0)).and(lessThanOrEqualTo((short) 100))))
        assertThat(info.getArch(), equalTo(Constants.OS_ARCH));  
        final OsStats.Cgroup cgroup = probe.osStats().getCgroup();
import static org.hamcrest.Matchers.notNullValue;
 * the Apache License, Version 2.0 (the "License"); you may
            @Override
        if (Constants.LINUX) {
            long nonHeapCommitted = memMx.getNonHeapMemoryUsage().getCommitted();
        assertNotNull(stats.getSwap());  
            if (prettyName != null) {  
 *  
    public void testReadRssAnonFromProcSelfStatusUnexpectedShape() throws IOException {
    public void testReadRssAnonFromProcSelfStatusNegativeValue() throws IOException {  
}
                }
            }
            @Override
import static org.hamcrest.Matchers.equalTo;  
            }
    public void testGetProcessNativeMemoryBytes_returnsNegativeWhenRssAnonUnavailable() {  
            @Override
        verify(logger, times(1)).warn("RssAnon line not found in /proc/self/status");
        OsStats stats = osProbe.osStats();  
            List<String> readProcSelfStatus() {  
            @Override
    }
                return "100000";
     * the arguments to this method.
     * @return a test instance
            }
            java.lang.management.MemoryMXBean memMx = java.lang.management.ManagementFactory.getMemoryMXBean();
                assertThat(new BigInteger(stats.getCgroup().getMemoryLimitInBytes()), greaterThan(BigInteger.ZERO));  
        final OsStats.Cgroup cgroup = probe.osStats().getCgroup();
 * this work for additional information regarding copyright
                    "Name:\topensearch",
            assertThat(loadAverage[2], greaterThanOrEqualTo((double) 0));
            List<String> readProcSelfCgroup() {
            }
            OsProbe probe = new OsProbe() {  
 * specific language governing permissions and limitations
        double[] loadAverage = stats.getCpu().getLoadAverage();
            }  
        assertThat(probe.getProcessRssAnon(), equalTo(4096L * 1024L));  
            "0::/cgroup2"
        final OsProbe probe = new OsProbe() {  
        };  
        assertThat(systemLoadAverage[1], equalTo(Double.parseDouble("1.69")));
                assertThat(controlGroup, equalTo("/" + hierarchy));
        final String hierarchy = randomAlphaOfLength(16);  
            @Override
            }
                assertThat(controlGroup, equalTo("/" + hierarchy));
import static org.mockito.ArgumentMatchers.eq;  
        assertThat(systemLoadAverage[2], equalTo(Double.parseDouble("1.99")));  
import static org.mockito.Mockito.mock;
            "3:perf_event:/",
            if (stats.getCgroup() != null) {
            @Override
            assertThat(loadAverage[1], equalTo((double) -1));  
        final OsStats.Cgroup cgroup = probe.osStats().getCgroup();  
            assertThat(stats.getSwap().getTotal().getBytes(), equalTo(0L));
            List<String> readProcSelfStatus() throws IOException {
            "1:name=systemd:/user.slice/user-1000.slice/session-2359.scope",
        assertEquals(-1L, probe.getProcessNativeMemoryBytes());  
                return Collections.singletonList("RssAnon:\tnotanumber kB");  
package org.opensearch.monitor.os;
            }  
    }
            .collect(Collectors.toList());  
            }  
            @Override
        final String hierarchy,
    }  
                assertThat(controlGroup, equalTo("/" + hierarchy));
        assertThat(stats.getMem().getFree().getBytes(), greaterThan(0L));
            assertThat(stats.getSwap().getTotal().getBytes(), greaterThan(0L));
        assertEquals(-1L, probe.getProcessRssAnon());  
            }  
    }
        final OsProbe osProbe = new OsProbe();
        };  
                assert Constants.LINUX : Constants.OS_NAME;
            }  
        }
    }
                return Arrays.asList("nr_periods 17992", "nr_throttled 1311", "throttled_time 139298645489");
        }
        final int allocatedProcessors = randomIntBetween(1, Runtime.getRuntime().availableProcessors());
                    "VmPeak:\t 12345 kB",
        OsStats osStats = noCpuStatsOsProbe.osStats();
        assumeTrue("test runs on Linux only", Constants.LINUX);
        assertThat(probe.getProcessRssAnon(), equalTo(-1L));
import org.apache.logging.log4j.Logger;
        List<String> procSelfCgroupLines = getProcSelfGroupLines(hierarchy);
        };
            boolean areCgroupStatsAvailable() {  
        List<String> procSelfCgroupLines = getProcSelfGroupLines(hierarchy).stream()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (total > 0) {
    public void testCgroupProbe() {  
            @Override  
import java.math.BigInteger;  
    }
        assumeTrue("test runs on Linux only", Constants.LINUX);  
    }
    public void testGetProcessRssAnon_presentField() {
            .filter(line -> !line.contains(":memory:"))
        assertThat(stats.getTimestamp(), greaterThan(0L));
        final OsProbe probe = new OsProbe() {
            }
        final String hierarchy = randomAlphaOfLength(16);
                );  
        assertNull(cgroup);
    }  
                    final String prettyNameLine = String.format(Locale.ROOT, "PRETTY_NAME=%s%s%s%s", quote, prettyName, quote, space);
        // must clamp at 0 instead of returning a negative.  
        final double[] systemLoadAverage = probe.getSystemLoadAverage();
        final OsProbe probe = buildStubOsProbe(true, hierarchy, procSelfCgroupLines);
            }  
            }
            .collect(Collectors.toList());
        assertThat(stats.getMem().getFreePercent(), allOf(greaterThanOrEqualTo((short) 0), lessThanOrEqualTo((short) 100)));
    public void testGetProcessNativeMemoryBytes_returnsDifferenceWhenRssAnonExceedsCommitted() throws Exception {
            assertThat(loadAverage[0], greaterThanOrEqualTo((double) 0));
            @Override
            @Override
        assumeTrue("test runs on Linux only", Constants.LINUX);
 * Licensed to Elasticsearch under one or more contributor  
        final OsProbe probe = new OsProbe(logger) {  
        assertEquals(0L, probe.getProcessNativeMemoryBytes());
                    "RssFile:\t 20000 kB",
 * compatible open source license.
        long extra = 64L * 1024L * 1024L;
                    return rssAnon;  
    }  
            assertThat(loadAverage[1], greaterThanOrEqualTo((double) 0));  
        final Logger logger = mock(Logger.class);
        });
            @Override
import static org.hamcrest.CoreMatchers.nullValue;
        };
                } else {
        assumeFalse("test runs on non-Linux only", Constants.LINUX);  
            String readSysFsCgroupMemoryUsageInBytes(String controlGroup) {  
            String readSysFsCgroupCpuAcctCpuAcctCfsQuota(String controlGroup) {  
    public void testOsStats() {
    public void testGetProcessNativeMemoryBytes_subtractsCommittedAndClampsAtZero() {  
public class OsProbeTests extends OpenSearchTestCase {
        assertThat(systemLoadAverage.length, equalTo(3));
        assumeThat("CGroups are available", noCpuStatsOsProbe.areCgroupStatsAvailable(), is(true));
            assertThat(cgroup.getCpuCfsPeriodMicros(), equalTo(100000L));  
            "7:blkio:/",
import java.util.List;  
                return "50000";
            String readProcLoadavg() {
        return buildStubOsProbe(areCgroupStatsAvailable, hierarchy, procSelfCgroupLines);  
        assertNull(cgroup);  
        final OsProbe probe = buildStubOsProbe(true, hierarchy, procSelfCgroupLines);
    public void testReadRssAnonFromProcSelfStatusMissingLine() throws IOException {
        }  
                    final String space = randomFrom(" ", "");
                    "RssAnon:\t 32768 kB",  
        final OsProbe probe = new OsProbe() {  
import static org.hamcrest.Matchers.anyOf;
            "9:net_cls,net_prio:/",
            }
        assertNotNull(stats);
import static org.junit.Assume.assumeThat;  
                return Arrays.asList("Name:\topensearch", "State:\tS (sleeping)", "VmRSS:\t 65536 kB");  
        OsProbe probe = new OsProbe() {  
        assertThat(info.getRefreshInterval(), equalTo(refreshInterval));  
import static org.mockito.Mockito.verify;
    }
        assumeTrue("test runs on Linux only", Constants.LINUX);
        };  
        final Logger logger = mock(Logger.class);
                return Collections.singletonList("nr_periods 1");  
    }
            List<String> readProcSelfStatus() throws IOException {
 * The OpenSearch Contributors require contributions made to  
            "5:devices:/user.slice",  
        List<String> procSelfCgroupLines = getProcSelfGroupLines(hierarchy).stream()
        final OsProbe probe = buildStubOsProbe(true, hierarchy, procSelfCgroupLines);  
        assertNotNull(systemLoadAverage);  
                assertThat(stats.getCgroup().getCpuStat().getTimeThrottledNanos(), greaterThanOrEqualTo(0L));
        assertNull(cgroup);
            }
            List<String> readProcSelfStatus() {
                assertThat(controlGroup, equalTo("/" + hierarchy));  
import java.util.Locale;
import static org.mockito.Mockito.times;
                    "RssShmem:\t   0 kB"
 * under the License.  
    }
 *
 * license agreements. See the NOTICE file distributed with
            List<String> readOsRelease() throws IOException {  
    public void testGetProcessRssAnonReturnsBytes() {
    public void testGetProcessRssAnonNotLinuxReturnsNegativeOne() {
        assertThat(stats.getMem().getUsedPercent(), allOf(greaterThanOrEqualTo((short) 0), lessThanOrEqualTo((short) 100)));
                assertThat(stats.getCgroup().getMemoryControlGroup(), notNullValue());
        assertThat(probe.readRssAnonFromProcSelfStatus(), equalTo(-1L));
                assertThat(info.getPrettyName(), equalTo(Constants.OS_NAME));  
        } else {
            // unknown system, but the best case is that we have the one-minute load average  
            public long getProcessRssAnon() {  
            "4:hugetlb:/",
    public void testReadRssAnonFromProcSelfStatusEmptyFile() throws IOException {
            List<String> readProcSelfStatus() {
            assertThat(stats.getSwap().getFree().getBytes(), greaterThan(0L));  
                return "364869866063112";
                return procSelfCgroupLines;
        }
                throw new AssertionError("readProcSelfStatus should not be called on non-Linux");
import static org.hamcrest.CoreMatchers.not;
                return Arrays.asList("Name:\topensearch", "VmRSS:\t  98304 kB");
                return Collections.singletonList("RssAnon:\t  0 kB");  
                return -1L;  
            } else {
            @Override  
                    "State:\tS (sleeping)",  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        assertThat(systemLoadAverage[0], equalTo(Double.parseDouble("1.51")));
                @Override
                assertThat(stats.getCgroup().getMemoryUsageInBytes(), notNullValue());
        assertThat(info.getAllocatedProcessors(), equalTo(allocatedProcessors));
            List<String> readSysFsCgroupCpuAcctCpuStat(String controlGroup) {  
            }
            "6:memory:/" + hierarchy,
            }
            }
        // This cgroup data is missing a line about memory  
        verify(logger, times(1)).warn(eq("malformed RssAnon value in /proc/self/status"), any(NumberFormatException.class));
        };
            // we should be able to get the load average  
        };
        // avoid silliness with representing doubles  
    public void testReadRssAnonFromProcSelfStatusZeroValue() throws IOException {
        );  
            }
        // RssAnon below the JVM committed memory (early process lifetime, before the
        OsProbe probe = new OsProbe() {
            assertNotNull(loadAverage);
            @Override
import static org.mockito.ArgumentMatchers.any;
            List<String> readProcSelfStatus() {
                throw new IOException("synthetic");
    public void testLogWarnCpuMessageOnlyOnes() {  
                    return Arrays.asList("NAME=" + randomAlphaOfLength(16), prettyNameLine);  
            assertThat(cgroup.getCpuStat().getNumberOfTimesThrottled(), equalTo(1311L));  
            List<String> readProcSelfStatus() {
    /**  
/*  
        assertThat(info.getName(), equalTo(Constants.OS_NAME));
        assertNotNull(info);
        };
import java.io.IOException;
            }
            assertNotNull(cgroup);
            @Override
            assertThat(cgroup.getCpuStat().getNumberOfElapsedPeriods(), equalTo(17992L));
            .collect(Collectors.toList());
            if (loadAverage != null) {
        if (Constants.LINUX) {
        assertThat(probe.readRssAnonFromProcSelfStatus(), equalTo(0L));  
            // load average is unavailable on Windows  
        assertThat(probe.readRssAnonFromProcSelfStatus(), equalTo(-1L));
    }
        };
    public void testCgroupProbeWithMissingMemory() {
        };  
                assertThat(stats.getCgroup().getCpuStat().getNumberOfTimesThrottled(), greaterThanOrEqualTo(0L));
            @Override
     */
        // Depending on CGroups v1/v2, the cgroup stats may not be available
        } else {
        } else if (Constants.LINUX) {
                return "4796416";
        };  
 * SPDX-License-Identifier: Apache-2.0
 */
import static org.mockito.Mockito.reset;  
        verify(logger, times(2)).warn(anyString());
    // ---- getProcessNativeMemoryBytes (RssAnon - heapCommitted - nonHeapCommitted, clamped) ----
        assertThat(stats.getMem().getTotal().getBytes(), greaterThan(0L));  
    }
    public void testReadRssAnonFromProcSelfStatusMalformedValue() throws IOException {
                return Collections.singletonList("RssAnon:");
    public void testGetProcessRssAnon_missingFieldReturnsNegative() {  
            List<String> readProcSelfStatus() {  
            // On platforms with no swap  
 * ownership. Elasticsearch licenses this file to you under  
    @AwaitsFix(bugUrl = "https://github.com/elastic/elasticsearch/issues/66629")  
            assertThat(cgroup.getCpuCfsQuotaMicros(), equalTo(50000L));
                return Arrays.asList("Name:\topensearch", "VmPeak:\t  131072 kB", "RssAnon:\t  12345 kB", "RssShmem:\t  64 kB");
            String readSysFsCgroupCpuAcctCpuCfsPeriod(String controlGroup) {  
        assertThat(probe.readRssAnonFromProcSelfStatus(), equalTo(12345L * 1024L));
                assertThat(loadAverage[0], anyOf(equalTo((double) -1), greaterThanOrEqualTo((double) 0)));
        final Logger logger = mock(Logger.class);  
import static org.mockito.ArgumentMatchers.anyString;
 */  
            assertThat(cgroup.getCpuStat().getTimeThrottledNanos(), equalTo(139298645489L));
                assertThat(stats.getCgroup().getCpuStat().getNumberOfElapsedPeriods(), greaterThanOrEqualTo(0L));  
        return Arrays.asList(  
    }
        if (Constants.LINUX) {  
    }
    private static OsProbe buildStubOsProbe(final boolean areCgroupStatsAvailable, final String hierarchy) {  
                return areCgroupStatsAvailable;
    public void testGetProcessRssAnon_returnsNegativeOnIoError() {  
     * Builds a test instance of OsProbe. Methods that ordinarily read from the filesystem are overridden to return values based upon
            prettyName = Constants.OS_NAME;
                assertThat(new BigInteger(stats.getCgroup().getMemoryUsageInBytes()), greaterThan(BigInteger.ZERO));
                // These could be null if transported from a node running an older version, but shouldn't be null on the current node  
    private static List<String> getProcSelfGroupLines(String hierarchy) {
            }  
        assertNotNull(stats.getMem());
import static org.hamcrest.Matchers.allOf;  
            }
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(cgroup.getCpuControlGroup(), equalTo("/" + hierarchy));
                return Collections.singletonList("RssAnon:\t  -1 kB");
            @Override
        OsProbe probe = new OsProbe() {
        assertThat(stats.getMem().getUsed().getBytes(), greaterThan(0L));  
import java.util.stream.Collectors;
        );  
                return 1L; // way below any real committed total
                assertThat(stats.getCgroup().getCpuAcctControlGroup(), notNullValue());
 * Unless required by applicable law or agreed to in writing,
 */  
import static org.hamcrest.Matchers.both;
        final OsProbe noCpuStatsOsProbe = new OsProbe(logger) {  
    }
    ) {
        final OsProbe osProbe = new OsProbe() {  
                assertThat(stats.getCgroup().getCpuAcctUsageNanos(), greaterThan(0L));  
        assertEquals(-1L, OsProbe.getInstance().getProcessRssAnon());
        verify(logger, times(1)).warn(eq("failed to read /proc/self/status"), any(IOException.class));
                if (prettyName != null) {
        assumeThat("only meaningful on non-Linux platforms", Constants.LINUX, is(false));  
            prettyName = randomFrom("Fedora 28 (Workstation Edition)", "Linux", null);
import java.util.Arrays;
                // No whitespace after the label, so split produces a single token  
            assertThat(cgroup.getCpuAcctControlGroup(), equalTo("/" + hierarchy));  
    // ---- /proc/self/status RssAnon parsing ----  
import static org.mockito.Mockito.never;
        assumeTrue("test runs on Linux only", Constants.LINUX);
    private static OsProbe buildStubOsProbe(  
        assumeThat("requires Linux to exercise the /proc/self/status path", Constants.LINUX, is(true));  
        };  
            List<String> readProcSelfStatus() {  
        }
                return "18446744073709551615";
        if (loadAverage != null) {
                return Collections.emptyList();
        final String hierarchy = randomAlphaOfLength(16);
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.is;  
        final OsProbe probe = new OsProbe() {
        assertThat(probe.readRssAnonFromProcSelfStatus(), equalTo(-1L));
        assumeThat("CGroup is available", osStats.getCgroup(), is(not(nullValue())));
                    "VmRSS:\t 65536 kB",
                }  
        } else {
            @Override
import org.apache.lucene.util.Constants;
        assertThat(probe.readRssAnonFromProcSelfStatus(), equalTo(-1L));
            // JVM committed memory may change between this snapshot and the snapshot taken by the probe.
            @Override  
            "10:freezer:/",
    }  
        assertEquals(32768L * 1024L, probe.getProcessRssAnon());  
            List<String> readProcSelfStatus() {  
        };  
 *
            assertNotNull(loadAverage);
                assertThat(controlGroup, equalTo("/" + hierarchy));
        }  
        // Override getProcessRssAnon to return -1 (the "not supported" sentinel). The
 * software distributed under the License is distributed on an
import org.opensearch.test.OpenSearchTestCase;  
            assertThat(loadAverage[0], greaterThanOrEqualTo((double) 0));
            assertEquals(extra, probe.getProcessNativeMemoryBytes());  
                assertThat(stats.getCgroup().getCpuCfsPeriodMicros(), greaterThanOrEqualTo(0L));
        OsProbe probe = new OsProbe() {
        final OsProbe probe = buildStubOsProbe(areCgroupStatsAvailable, hierarchy);  
        final String prettyName;  
            assertThat(stats.getSwap().getUsed().getBytes(), greaterThanOrEqualTo(0L));
            @Override
/*  
        assertNotNull(stats.getSwap().getTotal());
            long heapCommitted = memMx.getHeapMemoryUsage().getCommitted();  
    }  
            assertThat(stats.getSwap().getUsed().getBytes(), equalTo(0L));  
        };
        };
            }
            }
    }
        final OsStats.Cgroup cgroup = probe.osStats().getCgroup();
            @Override
    public void testCgroupProbeWithMissingCpuAcct() {  
            assertNull(loadAverage);
    public void testOsInfo() throws IOException {  
 * GitHub history for details.
    }
        } else {  
                assertThat(loadAverage[1], equalTo((double) -1));  
            assertNull(cgroup);
            List<String> readSysFsCgroupCpuAcctCpuStat(String controlGroup) throws IOException {
        };
        final OsProbe probe = new OsProbe(logger) {
            public long getProcessRssAnon() {
            }
        verify(logger, times(1)).warn("RssAnon line has unexpected shape: [{}]", "RssAnon:");
        verify(logger, times(1)).warn("RssAnon line not found in /proc/self/status");
                    final String quote = randomFrom("\"", "'", "");  
        assertThat(info.getAvailableProcessors(), equalTo(Runtime.getRuntime().availableProcessors()));  
        final OsInfo info = osProbe.osInfo(refreshInterval, allocatedProcessors);
        assumeThat("requires Linux to exercise the /proc/self/status path", Constants.LINUX, is(true));
        // This cgroup data is missing a line about cpuacct
            List<String> readProcSelfStatus() {
        long total = stats.getSwap().getTotal().getBytes();  
        final OsProbe probe = new OsProbe(logger) {  
import static org.hamcrest.Matchers.greaterThan;
                return Arrays.asList("Name:\topensearch", "VmRSS:\t  98304 kB", "RssAnon:\t  4096 kB", "RssFile:\t  2048 kB");  
            "2:cpu,cpuacct,cpuset:/" + hierarchy,  
        // OS resident set has caught up to the JVM's committed regions). The method
        assumeTrue("test runs on Linux only", Constants.LINUX);
        assertEquals(-1L, probe.getProcessRssAnon());
        final OsProbe probe = new OsProbe() {
        } else if (Constants.MAC_OS_X) {
    }
            assertThat(cgroup.getMemoryUsageInBytes(), equalTo("4796416"));  
            // one minute load average is available, but 10-minute and 15-minute load averages are not  
                    return Collections.singletonList("NAME=" + randomAlphaOfLength(16));
        return new OsProbe() {
                // This is the highest value that can be stored in an unsigned 64 bit number, hence too big for long
     * @param hierarchy a mock value used to generate a cgroup hierarchy.
        assertThat(info.getVersion(), equalTo(Constants.OS_VERSION));
                public long getProcessRssAnon() {
        final boolean areCgroupStatsAvailable = randomBoolean();  
        final long refreshInterval = randomBoolean() ? -1 : randomNonNegativeLong();
        final Logger logger = mock(Logger.class);
            assertThat(stats.getSwap().getFree().getBytes(), equalTo(0L));
