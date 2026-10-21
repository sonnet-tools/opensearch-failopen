        assertThat(second.devicesStats[1].previousSectorsRead, equalTo(710658L));
            assertThat(total.available, greaterThan(0L));
        assertThat(first.devicesStats[0].deviceName, equalTo("dm-0"));
        @Override
        @Override
        assertThat(second.devicesStats[0].previousSectorsRead, equalTo(7184666L));
        public long getUnallocatedSpace() throws IOException {
        );
        final FsInfo.IoStats second = probe.ioStats(devicesNumbers, previous);
            Arrays.asList(
            logger.info(
                    assertThat(deviceStats.currentWritesCompleted, greaterThanOrEqualTo(0L));
        public final FileStore fileStore;
        @Override
 * Licensed to Elasticsearch under one or more contributor
                " 259       1 nvme0n1p1 602 0 9919 131 1 0 1 0 0 19 131",
import static org.opensearch.monitor.fs.FsProbe.adjustForHugeFilesystems;
            if (Constants.LINUX) {
            assertNotNull(total);
                assertTrue(path.total > 0L);
                assertFalse(path.getType().isEmpty());
            }
            return "myHugeFS";
        @Override
        assertThat(first.devicesStats[0].previousSectorsRead, equalTo(-1L));
            FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(gbByteSizeValue.getBytes(), 16);
        assertThat(first.devicesStats[1].minorDeviceNumber, equalTo(2));
            FsProbe probe = new FsProbe(env, null);
        assertThat(first.devicesStats[0].previousReadsCompleted, equalTo(-1L));
                }
            super(path);
        }
import org.opensearch.core.common.unit.ByteSizeValue;
            ByteSizeValue gbByteSizeValue = new ByteSizeValue(1, ByteSizeUnit.GB);
        assertThat(first.devicesStats[1].currentWritesCompleted, equalTo(1371977L));
        }
            }
        }
                assertNotNull(path);
                assertThat(path.available, greaterThan(0L));
        public boolean supportsFileAttributeView(String name) {
import java.nio.file.FileStore;
import java.util.function.Function;
            "--> adding {} bytes to {}, {} will be: {}",
            assertNotNull(stats);
        assertEquals(-1, first.devicesStats[0].previousWriteTime);
        assertEquals(18767169, first.devicesStats[0].currentQueueSize);
        }
import java.util.List;
        final AtomicReference<List<String>> diskStats = new AtomicReference<>();
            FsInfo.Path total = stats.getTotal();
    }
            return false;
            FsProbe probe = new FsProbe(env, fileCache);
        assertThat(first.devicesStats[1].majorDeviceNumber, equalTo(253));
    }
        assertEquals(49369, second.devicesStats[1].currentReadTime);
        assertEquals(-1, first.devicesStats[1].previousIOTime);
        assertThat(second.devicesStats[0].currentSectorsRead, equalTo(7185242L));
            FsInfo stats = probe.stats(null);
        try (NodeEnvironment env = newNodeEnvironment()) {
            getter.apply(pathStats),
        assertEquals(33730596, first.devicesStats[1].currentWriteTime);
        final Set<Tuple<Integer, Integer>> devicesNumbers = new HashSet<>();
                getter.apply(pathToAdd),
                assertThat(path.total, greaterThan(0L));
 * Modifications Copyright OpenSearch Contributors. See
                assertNull(stats.getIoStats());
        assertThat(second.totalOperations, equalTo(575L));
        assertThat(pathStats.total, greaterThan(0L));
        assertThat(first.devicesStats[0].currentSectorsWritten, equalTo(118857776L));
                " 259       0 nvme0n1 336609 0 7923613 82813 10264051 0 182983933 52451441 0 2970886 52536260",
        assertThat(first.devicesStats[1].previousSectorsWritten, equalTo(-1L));
                    assertThat(deviceStats.currentReadTime, greaterThanOrEqualTo(0L));
        assertThat(second.devicesStats[1].deviceName, equalTo("dm-2"));
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(1058193, first.devicesStats[1].currentIOTime);
        assertThat(first.devicesStats[0].currentReadsCompleted, equalTo(287716L));
                    assertThat(deviceStats.previousWritesCompleted, equalTo(-1L));
import static org.hamcrest.Matchers.emptyOrNullString;
            pathToAdd = supplier.get();
                return diskStats.get();
        final Supplier<FsInfo.Path> supplier
                assertTrue(path.free > 0L);
        assertEquals(170, second.totalWriteTime);
import static org.hamcrest.Matchers.not;
        final Function<FsInfo.Path, Long> getter,
            );
 * under the License.
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
                }
        assertEquals(-1, first.devicesStats[0].previousReadTime);
                assertTrue(path.total > 0L);
        assertEquals(18730966, first.devicesStats[0].currentWriteTime);
                    assertThat(deviceStats.previousQueueSize, greaterThanOrEqualTo(-1L));
                assertFalse(path.getType().isEmpty());
 * license agreements. See the NOTICE file distributed with
/*
            return randomIntBetween(-1000, 1000);
import java.util.function.Supplier;
        Settings settings = Settings.builder().put("node.roles", "warm").build();
        final String field,
            throw new UnsupportedOperationException("don't call me");
        assertEquals(33781827, first.devicesStats[1].currentQueueSize);
        assertThat(FsProbe.getFSInfo(np).total, greaterThanOrEqualTo(0L));
                " 259       2 nvme0n1p2 186 0 8626 18 24 0 60 20 0 34 38",
 * compatible open source license.
            ByteSizeValue gbByteSizeValue = new ByteSizeValue(totalSpace, ByteSizeUnit.BYTES);
import org.opensearch.env.NodeEnvironment;
        final FsProbe probe = new FsProbe(null, null) {
                    assertThat(deviceStats.previousWriteTime, greaterThanOrEqualTo(-1L));
            "/foo/bar",
    private void addUntilOverflow(
 */
        assertEquals(18767169, second.devicesStats[0].previousQueueSize);
        assertEquals(18730966, second.devicesStats[0].previousWriteTime);
                    assertTrue(path.free - path.available >= path.fileCacheReserved);
        );
 * this file be licensed under the Apache-2.0 license or a
    }
    }
                    assertThat(deviceStats.currentReadsCompleted, greaterThanOrEqualTo(0L));
                if (path.fileCacheReserved > 0L) {
    }
        assertThat(second.devicesStats[1].majorDeviceNumber, equalTo(253));
            assertTrue(total.fileCacheReserved > 0L);
        FakeNodePath(Path path) throws IOException {
import org.opensearch.test.OpenSearchTestCase;
        }
        assertNotNull(second);
        assertEquals(-1L, first.devicesStats[1].previousIOTime);
            return false;
        assertThat(second.devicesStats[1].currentWritesCompleted, equalTo(1372291L));
            this.fileStore = new HugeFileStore();
        final FsInfo.Path pathStats = new FsInfo.Path(
            assertTrue(total.available > 0L);
            } else {
        @Override
                " 253       0 dm-0 287716 0 7184666 33457 8398869 0 118857776 18730966 0 1918440 18767169",
                    assertThat(deviceStats.currentQueueSize, greaterThanOrEqualTo(0L));
    public void testIoStats() {
        assertEquals(33781827, first.devicesStats[1].currentQueueSize);
        public String type() {
        assertEquals(236, second.totalQueueSize);
     */
        assertThat(FsProbe.getFSInfo(np).available, greaterThanOrEqualTo(0L));
        NodePath np = new FakeNodePath(createTempDir());
                " 253       2 dm-2 48045 0 714866 49369 1372291 0 64128568 33730766 0 1058347 33782056"
                assertFalse(path.getMount().isEmpty());
import static org.hamcrest.Matchers.is;
        assertEquals(1918444, second.devicesStats[0].currentIOTime);
            assertTrue((total.free - total.available) >= total.fileCacheReserved);
        assertThat(first.devicesStats[1].previousSectorsRead, equalTo(-1L));
        addUntilOverflow(pathStats, p -> p.total, "total", () -> new FsInfo.Path("/foo/baz", null, randomNonNegativeLong(), 0, 0));
        assertThat(second.devicesStats[1].previousSectorsWritten, equalTo(64126096L));
        assertThat(first.devicesStats[0].currentWritesCompleted, equalTo(8398869L));
}
                assertFalse(path.getMount().isEmpty());
            throw new UnsupportedOperationException("don't call me");
    }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
                    assertThat(deviceStats.previousSectorsWritten, equalTo(-1L));
 *    http://www.apache.org/licenses/LICENSE-2.0
        public boolean isReadOnly() {
            final long totalSpace = adjustForHugeFilesystems(env.fileCacheNodePath().fileStore.getTotalSpace());
        assertThat(pathStats.free, greaterThan(0L));
            )
            for (FsInfo.Path path : stats) {
                }
 * GitHub history for details.
        assertEquals(-1, first.devicesStats[1].previousWriteTime);
        assertEquals(158, second.totalIOTimeInMillis);
        final FsInfo previous = new FsInfo(System.currentTimeMillis(), first, new FsInfo.Path[0]);
/*
 * SPDX-License-Identifier: Apache-2.0
        public long getUsableSpace() throws IOException {
    static class FakeNodePath extends NodeEnvironment.NodePath {
        }
        public long getTotalSpace() throws IOException {
        assertEquals(-1, first.devicesStats[0].previousQueueSize);
                " 259       3 nvme0n1p3 335733 0 7901620 82658 9592875 0 182983872 50843431 0 1737726 50926087",
            FsProbe probe = new FsProbe(env, fileCache);
 *
public class FsProbeTests extends OpenSearchTestCase {
        assertEquals(64, second.totalReadTime);
        assertThat(FsProbe.getFSInfo(np).free, greaterThanOrEqualTo(0L));
        @Override
                assertNotNull(path);
        @Override
                    assertThat(deviceStats.currentWriteTime, greaterThanOrEqualTo(0L));
        assertEquals(33457, first.devicesStats[0].currentReadTime);
    }
                    assertEquals(0L, path.available);
            assertTrue(total.free > 0L);
            FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(gbByteSizeValue.getBytes(), 16);
import static org.hamcrest.CoreMatchers.equalTo;
                "--> adding {} bytes to {}, {} will be: {}",
        FsInfo.Path pathToAdd = supplier.get();
                " 253       1 dm-1 112 0 4624 13 0 0 0 0 0 5 13",
/*
        while ((getter.apply(pathStats) + getter.apply(pathToAdd)) > 0) {
                    assertThat(deviceStats.previousReadsCompleted, equalTo(-1L));
        assertThat(second.devicesStats[0].currentWritesCompleted, equalTo(8398869L));
                " 259       2 nvme0n1p2 186 0 8626 18 24 0 60 20 0 34 38",
            // add a path to increase the total bytes until it overflows
        assertEquals(1058193, first.devicesStats[1].currentIOTime);
            assertTrue(stats.getTimestamp() > 0L);
                assertNotNull(stats.getIoStats().devicesStats);
        assertThat(second.totalWriteKilobytes, equalTo(1236L));
        assertThat(second.devicesStats[0].majorDeviceNumber, equalTo(253));
            FsInfo stats = probe.stats(null);
 * not use this file except in compliance with the License.
        };
        assertThat(first.devicesStats[0].currentSectorsRead, equalTo(7184666L));
                    assertThat(deviceStats.previousIOTime, greaterThanOrEqualTo(-1L));
        assertEquals(18730966, second.devicesStats[0].currentWriteTime);
                field,
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(second.devicesStats[0].deviceName, equalTo("dm-0"));
    static class HugeFileStore extends FileStore {
        assertThat(second.devicesStats[0].previousReadsCompleted, equalTo(287716L));
                assertFalse(path.getPath().isEmpty());
                    assertThat(deviceStats.currentSectorsRead, greaterThanOrEqualTo(0L));
                    assertThat(deviceStats.previousSectorsRead, equalTo(-1L));
                if (path.fileCacheReserved > -1L) {
        }
                assertFalse(path.getPath().isEmpty());
import org.opensearch.env.NodeEnvironment.NodePath;
                getter.apply(pathStats),
            assertTrue(total.fileCacheReserved > 0L);
        Settings settings = Settings.builder().putList("node.roles", "warm", "data").build();
    public void testFsInfo() throws IOException {
            assertThat(total.free, greaterThan(0L));
            env.fileCacheNodePath().fileCacheReservedSize = gbByteSizeValue;
import java.io.IOException;
                " 253       1 dm-1 112 0 4624 13 0 0 0 0 0 5 13",
            null,
            @Override
        assertThat(second.devicesStats[0].previousSectorsWritten, equalTo(118857776L));
        }
import java.util.concurrent.atomic.AtomicReference;
        assertThat(first.devicesStats[0].previousWritesCompleted, equalTo(-1L));
import java.nio.file.Path;
                assertTrue(path.fileCacheReserved == 0);
        }
            assertTrue(stats.getTimestamp() > 0L);
                " 259       3 nvme0n1p3 335994 0 7906404 82721 9593184 0 182986344 50843529 0 1737840 50926248",
import org.opensearch.common.collect.Tuple;
            randomNonNegativeLong(),
import static org.hamcrest.Matchers.lessThan;
            FsInfo.Path total = stats.getTotal();
        assertThat(first.devicesStats[1].currentSectorsWritten, equalTo(64126096L));
            return "bigFS";
        assertEquals(-1, first.devicesStats[1].previousQueueSize);
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
        assertEquals(1918440, second.devicesStats[0].previousIOTime);
            getter.apply(pathToAdd),
        @Override
        }
import org.opensearch.common.settings.Settings;
                assertTrue(path.available > 0L);
 * The OpenSearch Contributors require contributions made to
        pathStats.add(pathToAdd);
            }
package org.opensearch.monitor.fs;
 * ownership. Elasticsearch licenses this file to you under
            assertTrue(total.total > 0L);
        }
                    assertThat(deviceStats.currentIOTime, greaterThanOrEqualTo(0L));
        public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> type) {
            assertNotNull(stats);
            return false;
                assertNotNull(path);
        assertThat(getter.apply(pathStats) + getter.apply(pathToAdd), lessThan(0L));
        assertEquals(-1L, first.devicesStats[1].previousQueueSize);
 *
 * You may obtain a copy of the License at
        assertThat(second.devicesStats[1].previousWritesCompleted, equalTo(1371977L));
import org.opensearch.index.store.remote.filecache.FileCache;
        diskStats.set(
    /**
        );
        assertThat(second.devicesStats[0].currentSectorsWritten, equalTo(118857776L));
            assertNotNull(total);
        assertThat(second.devicesStats[1].currentReadsCompleted, equalTo(48045L));
            randomNonNegativeLong()
        );
            assertNotNull(total);
            for (FsInfo.Path path : stats) {
        assertEquals(33464, second.devicesStats[0].currentReadTime);
                getter.apply(pathStats) + getter.apply(pathToAdd)
        assertThat(pathStats.available, greaterThan(0L));
        diskStats.set(
        final FsInfo.Path pathStats,
        public Object getAttribute(String attribute) throws IOException {
        // this overflows
        assertEquals(1918440, first.devicesStats[0].currentIOTime);
                " 253       0 dm-0 287734 0 7185242 33464 8398869 0 118857776 18730966 0 1918444 18767176",
            assertTrue(total.total > 0L);
import java.nio.file.attribute.FileAttributeView;
        assertThat(second.devicesStats[1].currentSectorsRead, equalTo(714866L));
        logger.info(
                assertNotNull(stats.getIoStats());
        assertThat(first.devicesStats[0].majorDeviceNumber, equalTo(253));
        assertThat(second.devicesStats[0].previousWritesCompleted, equalTo(8398869L));
        assertEquals(33457, second.devicesStats[0].previousReadTime);
            FsInfo.Path total = stats.getTotal();
                " 259       0 nvme0n1 336870 0 7928397 82876 10264393 0 182986405 52451610 0 2971042 52536492",
import org.apache.lucene.util.Constants;
            pathStats.add(pathToAdd);
                assertTrue(path.fileCacheUtilized == 0);
            )
        assertThat(second.totalReadKilobytes, equalTo(2392L));
        }
                " 259       1 nvme0n1p1 602 0 9919 131 1 0 1 0 0 19 131",
import org.opensearch.core.common.unit.ByteSizeUnit;
            // Use the total space as reserved space to simulate the situation where the cache space is occupied
        assertNotNull(first);
        assertThat(first.devicesStats[1].deviceName, equalTo("dm-2"));
    public void testFsCacheInfo() throws IOException {
            field,
        assertEquals(18767176, second.devicesStats[0].currentQueueSize);
        assertThat(first.devicesStats[1].currentReadsCompleted, equalTo(47802L));
        devicesNumbers.add(Tuple.tuple(253, 2));
        assertThat(second.totalReadOperations, equalTo(261L));
                assertTrue(path.free > 0L);
        assertEquals(49312, first.devicesStats[1].currentReadTime);
                assertThat(path.getPath(), is(not(emptyOrNullString())));
                assertThat(path.getMount(), is(not(emptyOrNullString())));
                    final FsInfo.DeviceStats deviceStats = stats.getIoStats().devicesStats[i];
        assertThat(first.devicesStats[1].previousWritesCompleted, equalTo(-1L));
import java.util.Set;
        assertThat(first.devicesStats[0].previousSectorsWritten, equalTo(-1L));
        assertThat(first.devicesStats[1].currentSectorsRead, equalTo(710658L));
        assertThat(second.devicesStats[1].minorDeviceNumber, equalTo(2));
            assertNotNull(stats);
    public void testFsInfoOverflow() throws Exception {
        final FsInfo.IoStats first = probe.ioStats(devicesNumbers, null);
        assertEquals(49312, second.devicesStats[1].previousReadTime);
        assertThat(second.devicesStats[0].minorDeviceNumber, equalTo(0));
        devicesNumbers.add(Tuple.tuple(253, 0));
        assertThat(first.devicesStats[1].previousReadsCompleted, equalTo(-1L));
    public void testFsInfoWhenFileCacheOccupied() throws IOException {
        }
import java.nio.file.attribute.FileStoreAttributeView;
        assertThat(second.totalWriteOperations, equalTo(314L));
                for (int i = 0; i < stats.getIoStats().devicesStats.length; i++) {
        @Override
        assertThat(first.devicesStats[0].minorDeviceNumber, equalTo(0));
import java.util.HashSet;
import static org.hamcrest.Matchers.greaterThan;
        assertEquals(-1, first.devicesStats[1].previousReadTime);
                assertThat(path.free, greaterThan(0L));
        assertThat(second.devicesStats[0].currentReadsCompleted, equalTo(287734L));
            return randomIntBetween(-1000, 1000);
            getter.apply(pathStats) + getter.apply(pathToAdd)
            env.fileCacheNodePath().fileCacheReservedSize = gbByteSizeValue;
 * software distributed under the License is distributed on an
import org.opensearch.index.store.remote.filecache.FileCacheFactory;
 * KIND, either express or implied.  See the License for the
        assertThat(second.devicesStats[1].currentSectorsWritten, equalTo(64128568L));
        addUntilOverflow(pathStats, p -> p.free, "free", () -> new FsInfo.Path("/foo/baz", null, 0, randomNonNegativeLong(), 0));
    }
            List<String> readProcDiskStats() throws IOException {
import java.util.Arrays;
    public void testAdjustForHugeFilesystems() throws Exception {
        }
 * specific language governing permissions and limitations
            assertTrue(total.free > 0L);
                } else {
            assertThat(total.total, greaterThan(0L));
        public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
            for (FsInfo.Path path : stats) {
        addUntilOverflow(pathStats, p -> p.available, "available", () -> new FsInfo.Path("/foo/baz", null, 0, 0, randomNonNegativeLong()));
 */
                    assertTrue(path.available > 0L);
        @Override
            }
        }
        // even after overflowing these should not be negative
            FsInfo stats = probe.stats(null);
            assertThat(stats.getTimestamp(), greaterThan(0L));
                    assertThat(deviceStats.currentSectorsWritten, greaterThanOrEqualTo(0L));
                    assertThat(deviceStats.previousReadTime, greaterThanOrEqualTo(-1L));
                    assertNotNull(deviceStats);
        public String name() {
        assertEquals(33730766, second.devicesStats[1].currentWriteTime);
                assertThat(path.getType(), is(not(emptyOrNullString())));
 * Unless required by applicable law or agreed to in writing,
            randomNonNegativeLong(),
                " 253       2 dm-2 47802 0 710658 49312 1371977 0 64126096 33730596 0 1058193 33781827"
 * this work for additional information regarding copyright
     * Randomly returns negative values for disk space to simulate https://bugs.openjdk.java.net/browse/JDK-8162520
        assertEquals(33730596, second.devicesStats[1].previousWriteTime);
 *
    ) {
        assertEquals(-1, first.devicesStats[0].previousIOTime);
            }
    }
            return randomIntBetween(-1000, 1000);
        assertThat(second.devicesStats[1].previousReadsCompleted, equalTo(47802L));
            Arrays.asList(
