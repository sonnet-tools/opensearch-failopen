        assertEquals(-1L, first.devicesStats[1].previousQueueSize);
    }
            ByteSizeValue gbByteSizeValue = new ByteSizeValue(totalSpace, ByteSizeUnit.BYTES);
                }
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
        assertThat(first.devicesStats[1].deviceName, equalTo("dm-2"));
    static class HugeFileStore extends FileStore {
/*
        assertEquals(33781827, first.devicesStats[1].currentQueueSize);
        assertEquals(18767169, first.devicesStats[0].currentQueueSize);
        assertThat(second.devicesStats[1].currentReadsCompleted, equalTo(48045L));  
        addUntilOverflow(pathStats, p -> p.total, "total", () -> new FsInfo.Path("/foo/baz", null, randomNonNegativeLong(), 0, 0));  
        diskStats.set(  
        @Override
import java.util.Arrays;
                " 253       1 dm-1 112 0 4624 13 0 0 0 0 0 5 13",
        assertEquals(-1, first.devicesStats[1].previousWriteTime);  
        assertThat(pathStats.available, greaterThan(0L));  
        assertThat(second.devicesStats[0].deviceName, equalTo("dm-0"));
import org.opensearch.core.common.unit.ByteSizeValue;
        public final FileStore fileStore;
        assertEquals(-1L, first.devicesStats[1].previousIOTime);
            assertThat(total.free, greaterThan(0L));  
        };
 * software distributed under the License is distributed on an
                assertNotNull(stats.getIoStats());
        }
                } else {
                assertTrue(path.fileCacheReserved == 0);
                    assertThat(deviceStats.currentWriteTime, greaterThanOrEqualTo(0L));
    public void testFsInfo() throws IOException {  
 * GitHub history for details.
        assertEquals(49312, first.devicesStats[1].currentReadTime);  
                " 259       2 nvme0n1p2 186 0 8626 18 24 0 60 20 0 34 38",
        assertThat(first.devicesStats[0].previousSectorsRead, equalTo(-1L));  
                    assertThat(deviceStats.previousIOTime, greaterThanOrEqualTo(-1L));  
        assertThat(second.devicesStats[1].previousSectorsWritten, equalTo(64126096L));
 * under the License.  
    }
                "--> adding {} bytes to {}, {} will be: {}",
        assertThat(first.devicesStats[0].previousWritesCompleted, equalTo(-1L));
                    assertThat(deviceStats.previousWriteTime, greaterThanOrEqualTo(-1L));
            FsInfo stats = probe.stats(null);
        assertEquals(33730596, second.devicesStats[1].previousWriteTime);  
            assertNotNull(stats);
        public String name() {
        final Set<Tuple<Integer, Integer>> devicesNumbers = new HashSet<>();
import static org.opensearch.monitor.fs.FsProbe.adjustForHugeFilesystems;
    }
        public long getTotalSpace() throws IOException {
        public boolean supportsFileAttributeView(String name) {  
            }
        final FsInfo.Path pathStats = new FsInfo.Path(
            FsInfo.Path total = stats.getTotal();  
        assertEquals(49369, second.devicesStats[1].currentReadTime);  
            assertTrue(stats.getTimestamp() > 0L);
        assertThat(first.devicesStats[1].currentWritesCompleted, equalTo(1371977L));
        // this overflows
                getter.apply(pathStats),  
        assertThat(first.devicesStats[1].majorDeviceNumber, equalTo(253));  
        assertThat(first.devicesStats[0].previousReadsCompleted, equalTo(-1L));
    public void testIoStats() {
            getter.apply(pathStats),
                " 259       0 nvme0n1 336870 0 7928397 82876 10264393 0 182986405 52451610 0 2971042 52536492",
            assertNotNull(total);
        public long getUnallocatedSpace() throws IOException {
        }  
import org.opensearch.core.common.unit.ByteSizeUnit;
        assertNotNull(second);
        assertThat(pathStats.free, greaterThan(0L));
                assertThat(path.available, greaterThan(0L));
                assertNotNull(path);  
                assertTrue(path.free > 0L);
        FakeNodePath(Path path) throws IOException {
        }  
        }
        final String field,  
                assertNotNull(path);
        );
import static org.hamcrest.Matchers.is;  
import org.opensearch.index.store.remote.filecache.FileCacheFactory;  
        assertEquals(170, second.totalWriteTime);
            return randomIntBetween(-1000, 1000);  
        }
import java.nio.file.FileStore;
        assertThat(second.devicesStats[1].currentWritesCompleted, equalTo(1372291L));
 * specific language governing permissions and limitations
            FsInfo.Path total = stats.getTotal();  
        assertThat(first.devicesStats[1].currentSectorsRead, equalTo(710658L));
            assertNotNull(stats);  
        assertThat(second.devicesStats[0].currentSectorsWritten, equalTo(118857776L));  
                }
        final FsProbe probe = new FsProbe(null, null) {  
        assertEquals(18730966, second.devicesStats[0].currentWriteTime);
        assertThat(first.devicesStats[0].currentSectorsWritten, equalTo(118857776L));  
        final Supplier<FsInfo.Path> supplier
            FsInfo stats = probe.stats(null);  
        }  
        pathStats.add(pathToAdd);
        logger.info(
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.CoreMatchers.equalTo;
            getter.apply(pathStats) + getter.apply(pathToAdd)
        assertThat(first.devicesStats[0].currentWritesCompleted, equalTo(8398869L));
                }
 * this work for additional information regarding copyright
}  
            FsProbe probe = new FsProbe(env, null);  
            @Override
        assertThat(first.devicesStats[1].currentReadsCompleted, equalTo(47802L));  
    ) {
            FsInfo.Path total = stats.getTotal();
            assertTrue(total.fileCacheReserved > 0L);
            for (FsInfo.Path path : stats) {  
    public void testAdjustForHugeFilesystems() throws Exception {  
            assertTrue(total.fileCacheReserved > 0L);
        public Object getAttribute(String attribute) throws IOException {
     * Randomly returns negative values for disk space to simulate https://bugs.openjdk.java.net/browse/JDK-8162520
                    assertTrue(path.free - path.available >= path.fileCacheReserved);  
                getter.apply(pathToAdd),
 * KIND, either express or implied.  See the License for the
        assertThat(second.devicesStats[1].previousReadsCompleted, equalTo(47802L));
import java.io.IOException;  
        assertThat(first.devicesStats[1].previousWritesCompleted, equalTo(-1L));
 */  
    /**
        );
        assertEquals(-1, first.devicesStats[0].previousQueueSize);
        assertEquals(33730766, second.devicesStats[1].currentWriteTime);
        assertEquals(64, second.totalReadTime);  
        assertThat(second.devicesStats[0].minorDeviceNumber, equalTo(0));
import static org.hamcrest.Matchers.emptyOrNullString;  
        assertThat(first.devicesStats[1].previousReadsCompleted, equalTo(-1L));
        assertThat(first.devicesStats[0].majorDeviceNumber, equalTo(253));  
            return "myHugeFS";
                assertTrue(path.total > 0L);
 *  
            )  
import org.opensearch.env.NodeEnvironment;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        assertThat(second.devicesStats[1].deviceName, equalTo("dm-2"));
    }
            assertTrue(stats.getTimestamp() > 0L);  
        // even after overflowing these should not be negative  
/*  
        assertThat(getter.apply(pathStats) + getter.apply(pathToAdd), lessThan(0L));  
    }
                    assertThat(deviceStats.previousWritesCompleted, equalTo(-1L));
                assertFalse(path.getType().isEmpty());  
            assertNotNull(stats);
        assertThat(FsProbe.getFSInfo(np).free, greaterThanOrEqualTo(0L));  
        final FsInfo.IoStats second = probe.ioStats(devicesNumbers, previous);
                assertFalse(path.getMount().isEmpty());
        assertEquals(-1, first.devicesStats[0].previousReadTime);
        assertThat(FsProbe.getFSInfo(np).available, greaterThanOrEqualTo(0L));
            return randomIntBetween(-1000, 1000);
        assertThat(second.devicesStats[0].previousReadsCompleted, equalTo(287716L));
        public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> type) {
        final FsInfo.Path pathStats,
        assertEquals(-1, first.devicesStats[1].previousIOTime);
import org.apache.lucene.util.Constants;
            assertTrue((total.free - total.available) >= total.fileCacheReserved);  
            return false;
                getter.apply(pathStats) + getter.apply(pathToAdd)
                assertNotNull(path);
            Arrays.asList(
                    assertThat(deviceStats.currentQueueSize, greaterThanOrEqualTo(0L));  
                assertNull(stats.getIoStats());  
            null,  
        assertThat(first.devicesStats[0].currentSectorsRead, equalTo(7184666L));
        assertEquals(18730966, first.devicesStats[0].currentWriteTime);
        assertThat(second.devicesStats[0].currentSectorsRead, equalTo(7185242L));
 * Modifications Copyright OpenSearch Contributors. See
        @Override  
            assertTrue(total.total > 0L);
        }
    }
                assertThat(path.getMount(), is(not(emptyOrNullString())));  
                    assertThat(deviceStats.currentSectorsWritten, greaterThanOrEqualTo(0L));  
            FsInfo stats = probe.stats(null);
            FsProbe probe = new FsProbe(env, fileCache);
        assertNotNull(first);
        Settings settings = Settings.builder().put("node.roles", "warm").build();  
        }  
            randomNonNegativeLong(),
public class FsProbeTests extends OpenSearchTestCase {
        try (NodeEnvironment env = newNodeEnvironment(settings)) {
        }  
 * license agreements. See the NOTICE file distributed with
        assertThat(second.totalWriteOperations, equalTo(314L));
        assertThat(first.devicesStats[0].previousSectorsWritten, equalTo(-1L));
 * Unless required by applicable law or agreed to in writing,
                " 259       3 nvme0n1p3 335994 0 7906404 82721 9593184 0 182986344 50843529 0 1737840 50926248",
            for (FsInfo.Path path : stats) {
        @Override  
        }
        FsInfo.Path pathToAdd = supplier.get();  
        assertEquals(158, second.totalIOTimeInMillis);  
            // Use the total space as reserved space to simulate the situation where the cache space is occupied  
                " 253       0 dm-0 287734 0 7185242 33464 8398869 0 118857776 18730966 0 1918444 18767176",  
                assertTrue(path.total > 0L);  
        assertThat(second.devicesStats[1].majorDeviceNumber, equalTo(253));  
import java.util.List;
                for (int i = 0; i < stats.getIoStats().devicesStats.length; i++) {  
            this.fileStore = new HugeFileStore();  
        final FsInfo.IoStats first = probe.ioStats(devicesNumbers, null);
        assertEquals(-1, first.devicesStats[0].previousIOTime);
    static class FakeNodePath extends NodeEnvironment.NodePath {
                    assertThat(deviceStats.currentReadsCompleted, greaterThanOrEqualTo(0L));  
        assertThat(second.devicesStats[1].minorDeviceNumber, equalTo(2));
        }
import java.util.function.Supplier;
                assertThat(path.getType(), is(not(emptyOrNullString())));
                assertNotNull(stats.getIoStats().devicesStats);
            env.fileCacheNodePath().fileCacheReservedSize = gbByteSizeValue;  
                    assertThat(deviceStats.previousReadsCompleted, equalTo(-1L));
                    assertThat(deviceStats.currentWritesCompleted, greaterThanOrEqualTo(0L));
            "/foo/bar",
        assertThat(second.devicesStats[0].previousWritesCompleted, equalTo(8398869L));
        devicesNumbers.add(Tuple.tuple(253, 2));  
        while ((getter.apply(pathStats) + getter.apply(pathToAdd)) > 0) {
        assertEquals(33730596, first.devicesStats[1].currentWriteTime);
        assertThat(second.devicesStats[0].currentWritesCompleted, equalTo(8398869L));
 * You may obtain a copy of the License at  
import java.util.function.Function;
 * not use this file except in compliance with the License.
        @Override  
            throw new UnsupportedOperationException("don't call me");  
        public String type() {  
 *
            }
/*  
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;  
            FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(gbByteSizeValue.getBytes(), 16);
        assertEquals(1918440, first.devicesStats[0].currentIOTime);  
    private void addUntilOverflow(  
                " 253       0 dm-0 287716 0 7184666 33457 8398869 0 118857776 18730966 0 1918440 18767169",  
                    assertNotNull(deviceStats);
 *
            // add a path to increase the total bytes until it overflows
                assertFalse(path.getMount().isEmpty());
            }
import org.opensearch.common.settings.Settings;  
        assertThat(first.devicesStats[1].previousSectorsRead, equalTo(-1L));  
        assertEquals(33781827, first.devicesStats[1].currentQueueSize);
        assertEquals(1918440, second.devicesStats[0].previousIOTime);
                assertTrue(path.free > 0L);
                    assertThat(deviceStats.currentIOTime, greaterThanOrEqualTo(0L));
        assertEquals(33457, second.devicesStats[0].previousReadTime);
        }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
        @Override  
                " 253       2 dm-2 47802 0 710658 49312 1371977 0 64126096 33730596 0 1058193 33781827"
            assertTrue(total.free > 0L);  
            pathToAdd = supplier.get();
    public void testFsInfoOverflow() throws Exception {  
            )  
        assertThat(second.totalOperations, equalTo(575L));  
        @Override
        assertEquals(1918444, second.devicesStats[0].currentIOTime);  
import static org.hamcrest.Matchers.not;
        assertEquals(18767176, second.devicesStats[0].currentQueueSize);
        public boolean isReadOnly() {
import org.opensearch.index.store.remote.filecache.FileCache;
        assertThat(second.totalReadKilobytes, equalTo(2392L));  
        assertThat(first.devicesStats[1].minorDeviceNumber, equalTo(2));
            for (FsInfo.Path path : stats) {
import java.nio.file.attribute.FileStoreAttributeView;
        devicesNumbers.add(Tuple.tuple(253, 0));
        assertEquals(-1, first.devicesStats[1].previousQueueSize);
    public void testFsInfoWhenFileCacheOccupied() throws IOException {  
            );  
            return randomIntBetween(-1000, 1000);
            assertNotNull(total);
 */  
        assertThat(second.devicesStats[1].currentSectorsWritten, equalTo(64128568L));  
        assertThat(first.devicesStats[1].previousSectorsWritten, equalTo(-1L));
                    assertThat(deviceStats.previousSectorsWritten, equalTo(-1L));
                assertTrue(path.fileCacheUtilized == 0);  
                assertThat(path.total, greaterThan(0L));
                assertThat(path.free, greaterThan(0L));  
        assertEquals(18730966, second.devicesStats[0].previousWriteTime);  
import org.opensearch.env.NodeEnvironment.NodePath;
        final FsInfo previous = new FsInfo(System.currentTimeMillis(), first, new FsInfo.Path[0]);  
            throw new UnsupportedOperationException("don't call me");
            }
            getter.apply(pathToAdd),
            assertThat(total.available, greaterThan(0L));
        assertThat(second.devicesStats[1].previousSectorsRead, equalTo(710658L));  
import org.opensearch.common.collect.Tuple;
            super(path);
        assertThat(second.devicesStats[0].previousSectorsWritten, equalTo(118857776L));
                    assertThat(deviceStats.currentReadTime, greaterThanOrEqualTo(0L));
            List<String> readProcDiskStats() throws IOException {
            assertTrue(total.free > 0L);
                if (path.fileCacheReserved > -1L) {
        assertEquals(1058193, first.devicesStats[1].currentIOTime);  
        @Override
            logger.info(  
 */
        }
        assertThat(second.devicesStats[0].currentReadsCompleted, equalTo(287734L));  
                " 259       1 nvme0n1p1 602 0 9919 131 1 0 1 0 0 19 131",  
            return false;  
                assertThat(path.getPath(), is(not(emptyOrNullString())));
        assertEquals(1058193, first.devicesStats[1].currentIOTime);  
        assertThat(first.devicesStats[0].currentReadsCompleted, equalTo(287716L));  
        Settings settings = Settings.builder().putList("node.roles", "warm", "data").build();
                " 253       1 dm-1 112 0 4624 13 0 0 0 0 0 5 13",
        assertEquals(49312, second.devicesStats[1].previousReadTime);
        assertEquals(-1, first.devicesStats[0].previousWriteTime);  
        NodePath np = new FakeNodePath(createTempDir());
                    final FsInfo.DeviceStats deviceStats = stats.getIoStats().devicesStats[i];
                " 259       1 nvme0n1p1 602 0 9919 131 1 0 1 0 0 19 131",  
                " 253       2 dm-2 48045 0 714866 49369 1372291 0 64128568 33730766 0 1058347 33782056"
        assertEquals(-1, first.devicesStats[1].previousReadTime);
        public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
            final long totalSpace = adjustForHugeFilesystems(env.fileCacheNodePath().fileStore.getTotalSpace());
            return false;
                " 259       2 nvme0n1p2 186 0 8626 18 24 0 60 20 0 34 38",
            assertTrue(total.available > 0L);
            assertThat(stats.getTimestamp(), greaterThan(0L));
import java.nio.file.attribute.FileAttributeView;  
    }  
        assertThat(FsProbe.getFSInfo(np).total, greaterThanOrEqualTo(0L));
        assertEquals(33464, second.devicesStats[0].currentReadTime);  
            FileCache fileCache = FileCacheFactory.createConcurrentLRUFileCache(gbByteSizeValue.getBytes(), 16);
        assertThat(first.devicesStats[0].deviceName, equalTo("dm-0"));
        }  
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
            assertNotNull(total);
            assertThat(total.total, greaterThan(0L));
        final Function<FsInfo.Path, Long> getter,
        assertThat(second.devicesStats[1].previousWritesCompleted, equalTo(1371977L));
        assertThat(second.devicesStats[0].previousSectorsRead, equalTo(7184666L));  
                    assertEquals(0L, path.available);
                assertFalse(path.getPath().isEmpty());  
        );
        addUntilOverflow(pathStats, p -> p.available, "available", () -> new FsInfo.Path("/foo/baz", null, 0, 0, randomNonNegativeLong()));
import org.opensearch.test.OpenSearchTestCase;
        }  
        @Override
import static org.hamcrest.Matchers.lessThan;
            FsProbe probe = new FsProbe(env, fileCache);  
                return diskStats.get();  
 * the Apache License, Version 2.0 (the "License"); you may
        try (NodeEnvironment env = newNodeEnvironment()) {
                if (path.fileCacheReserved > 0L) {  
                field,
        final AtomicReference<List<String>> diskStats = new AtomicReference<>();
        @Override
            field,  
        assertThat(second.totalReadOperations, equalTo(261L));
            }
import java.nio.file.Path;
            pathStats.add(pathToAdd);
            Arrays.asList(
     */  
                    assertThat(deviceStats.previousReadTime, greaterThanOrEqualTo(-1L));  
        assertEquals(18767169, second.devicesStats[0].previousQueueSize);
        diskStats.set(  
        addUntilOverflow(pathStats, p -> p.free, "free", () -> new FsInfo.Path("/foo/baz", null, 0, randomNonNegativeLong(), 0));
        assertThat(second.devicesStats[0].majorDeviceNumber, equalTo(253));  
            ByteSizeValue gbByteSizeValue = new ByteSizeValue(1, ByteSizeUnit.GB);
        );
            } else {
 * compatible open source license.
                assertFalse(path.getPath().isEmpty());
            if (Constants.LINUX) {  
                assertFalse(path.getType().isEmpty());
    public void testFsCacheInfo() throws IOException {
            return "bigFS";
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(33457, first.devicesStats[0].currentReadTime);  
                " 259       0 nvme0n1 336609 0 7923613 82813 10264051 0 182983933 52451441 0 2970886 52536260",
        assertThat(second.devicesStats[1].currentSectorsRead, equalTo(714866L));
            randomNonNegativeLong()  
package org.opensearch.monitor.fs;
            randomNonNegativeLong(),
        assertEquals(236, second.totalQueueSize);
        @Override
            env.fileCacheNodePath().fileCacheReservedSize = gbByteSizeValue;  
                assertTrue(path.available > 0L);  
        public long getUsableSpace() throws IOException {  
            "--> adding {} bytes to {}, {} will be: {}",  
                    assertThat(deviceStats.currentSectorsRead, greaterThanOrEqualTo(0L));
import java.util.HashSet;  
                    assertTrue(path.available > 0L);  
        assertThat(first.devicesStats[0].minorDeviceNumber, equalTo(0));
import static org.hamcrest.Matchers.greaterThan;
        assertThat(first.devicesStats[1].currentSectorsWritten, equalTo(64126096L));  
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertTrue(total.total > 0L);  
        assertThat(second.totalWriteKilobytes, equalTo(1236L));
 * SPDX-License-Identifier: Apache-2.0
                " 259       3 nvme0n1p3 335733 0 7901620 82658 9592875 0 182983872 50843431 0 1737726 50926087",
        assertThat(pathStats.total, greaterThan(0L));
                    assertThat(deviceStats.previousSectorsRead, equalTo(-1L));  
                    assertThat(deviceStats.previousQueueSize, greaterThanOrEqualTo(-1L));
