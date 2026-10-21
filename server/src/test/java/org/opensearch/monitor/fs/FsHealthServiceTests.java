            // enabling unexpected file size injection
            String disruptedPath = randomFrom(paths).toString();
                                    Thread.sleep(timeInMillis);
            assertEquals(UNHEALTHY, fsHealthService.getHealth().getStatus());
import org.opensearch.test.junit.annotations.TestLogging;
        final TestThreadPool testThreadPool = new TestThreadPool(getClass().getName(), settings);
            .put(FsHealthService.SLOW_PATH_LOGGING_THRESHOLD_SETTING.getKey(), slowLogThreshold + "ms")
import java.nio.file.attribute.FileAttribute;
                } else {
            FsHealthService fsHealthService = new FsHealthService(
                clusterSettings,
        }
            assertFalse(deterministicTaskQueue.hasRunnableTasks());
        TestThreadPool testThreadPool = new TestThreadPool(getClass().getName(), settings);
        long delayBetweenChecks = 100;
        }
 * license agreements. See the NOTICE file distributed with
            deterministicTaskQueue.runAllTasksInTimeOrder();
        PathUtilsForTesting.installMock(fileSystem);
            unexpectedLockFileSizeFileSystemProvider.injectUnexpectedFileSize.set(true);
            fsHealthService.new FsHealthMonitor().run();
                            long maxWaitTimeMillis = startTimeMillis + delay >= 0 ? startTimeMillis + delay : Long.MAX_VALUE;// long
        FileSystemFsyncHungProvider disruptFileSystemProvider = new FileSystemFsyncHungProvider(
            assertTrue(deterministicTaskQueue.hasDeferredTasks());
            this.threadPool = threadPool;
                    if (injectUnexpectedFileSize.get()) {
            waitUntil(
        }
        FileSystemFsyncIOExceptionProvider disruptFsyncFileSystemProvider = new FileSystemFsyncIOExceptionProvider(fileSystem);
                                }
            disruptFileSystemProvider.injectIOException.set(false);
            assertEquals(UNHEALTHY, fsHealthService.getHealth().getStatus());
    }
                    throw new IOException("fake IOException");
        Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), "node").build();
 * Licensed to Elasticsearch under one or more contributor
        PathUtilsForTesting.installMock(fileSystem);
            fsHealthService.new FsHealthMonitor().run();
        FileSystemIOExceptionProvider disruptFileSystemProvider = new FileSystemIOExceptionProvider(fileSystem);
            FsHealthService fsHealthService = new FsHealthService(settings, clusterSettings, testThreadPool, env, metricsRegistry);
                assertThat(deterministicTaskQueue.getCurrentTimeMillis() - startTimeMillis, is(refreshInterval * rescheduledCount));
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
            this.delay = delay;
        } finally {
            NodeEnvironment env = newNodeEnvironment()
            return new FilterFileChannel(super.newFileChannel(path, options, attrs)) {
                                try {
        public FileChannel newFileChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
import org.opensearch.common.io.PathUtilsForTesting;
    @Before
                                                                                                                             // overflow
                @Override
    @TestLogging(value = "org.opensearch.monitor.fs:WARN", reason = "to ensure that we log on hung IO at WARN level")
    public void testFailsHealthOnHungIOBeyondHealthyTimeout() throws Exception {
        fileSystem = disruptFileSystemProvider.getFileSystem(null);
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
                                timeInMillis = Math.min(AWAIT_BUSY_THRESHOLD, timeInMillis * 2);
                    return super.size();
        } finally {
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                assert pathPrefix != null : "must set pathPrefix before starting disruptions";
        PathUtilsForTesting.installMock(fileSystem);
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        long refreshInterval = 50; // ms
                List.of()
import org.opensearch.env.NodeEnvironment;
import org.junit.Before;
        public int getInjectedPathCount() {
import java.nio.file.Path;
                        assert pathPrefix != null : "must set pathPrefix before starting disruptions";
                () -> fsHealthService.getHealth().getStatus() == HEALTHY,
            super("disrupt_fs_health://", inner);
import org.opensearch.test.OpenSearchTestCase;
            assertBusy(() -> assertEquals(StatusInfo.Status.HEALTHY, fsHealthService.getHealth().getStatus()));
        PathUtilsForTesting.installMock(fileSystem);
                            return size;
            assertBusy(mockAppender::assertAllExpectationsMatched);
        AtomicBoolean injectIOException = new AtomicBoolean();
            assertEquals(disruptedPathCount, disruptFileSystemProvider.getInjectedPathCount());
            final Path additional = createTempDir();
                () -> fsHealthService.getHealth().getStatus() == UNHEALTHY,
            assertEquals(HEALTHY, fsHealthService.getHealth().getStatus());
            logger.info("--> Disrupt file system");
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
            randomLongBetween(slowLogThreshold + 1, 400),
                metricsRegistry,
            return injectedPaths.get();
            assertEquals("health check passed", fsHealth.getInfo());
                            throw new IOException("fake IOException");
public class FsHealthServiceTests extends OpenSearchTestCase {
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            disruptFileSystemProvider.injectIODelay.set(true);
            fsHealthService.doStart();
            assertEquals(UNHEALTHY, fsHealth.getStatus());
import java.io.IOException;
            testThreadPool
import java.util.Set;
            assertThat(fsHealthService.getHealth().getInfo(), is("health check failed on [" + disruptedPath + "]"));
import org.opensearch.common.util.io.IOUtils;
import org.opensearch.common.io.PathUtils;
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                    if (injectIOException.get()) {
                @Override
        private final long size;
            assertEquals("healthy threshold breached", fsHealth.getInfo());
            .put(FsHealthService.SLOW_PATH_LOGGING_THRESHOLD_SETTING.getKey(), slowLogThreshold + "ms")
            super("disrupt_fs_health://", inner);
            assertEquals(HEALTHY, fsHealthService.getHealth().getStatus());
            fsHealth = fsHealthService.getHealth();
            });
            disruptFsyncFileSystemProvider.restrictPathPrefix(disruptedPath);
            assertEquals("health check passed", fsHealthService.getHealth().getInfo());
                                } catch (InterruptedException e) {
        }
            if (injectIOException.get()) {
        }
    }
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            for (int i = 1; i <= randomIntBetween(5, 10); i++) {
        }
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
            fsHealth = fsHealthService.getHealth();
        FileSystemUnexpectedLockFileSizeProvider unexpectedLockFileSizeFileSystemProvider = new FileSystemUnexpectedLockFileSizeProvider(
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
            assertEquals(Integer.valueOf(1), metricsRegistry.getCounterStore().get("fsHealth.failure.count").getCounterValue());
    }
            assertEquals(env.nodeDataPaths().length, disruptFileSystemProvider.getInjectedPathCount());
 * compatible open source license.
    }
 * ownership. Elasticsearch licenses this file to you under
        );
            assertThat(fsHealthService.getHealth().getInfo(), is("health check failed due to broken node lock"));
            this.delay = Long.MAX_VALUE;
 * software distributed under the License is distributed on an
        final Settings settings = Settings.EMPTY;
        }
        FileSystem fileSystem = PathUtils.getDefaultFileSystem();
        AtomicInteger injectedPaths = new AtomicInteger();
        fileSystem = disruptFileSystemProvider.getFileSystem(null);
            // disrupt file system
        public int getInjectedPathCount() {
        }
    public void testLoggingOnHungIO() throws Exception {
 *
        public void restrictPathPrefix(String pathPrefix) {
        try (NodeEnvironment env = newNodeEnvironment()) {
        long slowLogThreshold = randomLongBetween(100, 200);
                        }
                public long size() throws IOException {
import org.opensearch.threadpool.ThreadPool;
                public void force(boolean metaData) throws IOException {
            assertEquals(Integer.valueOf(1), metricsRegistry.getCounterStore().get("fsHealth.failure.count").getCounterValue());
        fileSystem = disruptFsyncFileSystemProvider.getFileSystem(null);
        FileSystemFsyncHungProvider(FileSystem inner, ThreadPool threadPool) {
        FileSystem fileSystem = PathUtils.getDefaultFileSystem();
 * SPDX-License-Identifier: Apache-2.0
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            logger.info("--> Fix file system disruption");
            disruptFsyncFileSystemProvider.injectIOException.set(false);
        long refreshInterval = 50;
                assertTrue(info.getInfo(), info.getInfo().contains(additional.toString()));
            1,
            fsHealthService.doStart();
        PathUtilsForTesting.installMock(fileSystem);
                settings,
            fsHealthService.new FsHealthMonitor().run();
                );
                    deterministicTaskQueue.advanceTime();
        public int getInjectedPathCount() {
                            injectedPaths.incrementAndGet();
/*
            return new FilterFileChannel(super.newFileChannel(path, options, attrs)) {
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.monitor.StatusInfo;
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
        AtomicBoolean injectIOException = new AtomicBoolean();
import java.util.concurrent.atomic.AtomicInteger;
            FsHealthService fsHealthService = new FsHealthService(
                        if (path.toString().startsWith(pathPrefix)
        FileSystem fileSystem = PathUtils.getDefaultFileSystem();
        @Override
    public void testSchedulesHealthCheckAtRefreshIntervals() throws Exception {
            logger.info("--> First monitor run");
        }
            PathUtilsForTesting.teardown();
            assertEquals(UNHEALTHY, fsHealthService.getHealth().getStatus());
            fsHealthService.new FsHealthMonitor().run();
            for (Path path : env.nodeDataPaths()) {
                deterministicTaskQueue.getThreadPool(),
                    }
            Path[] paths = env.nodeDataPaths();
    public void testAdditionalHealthPathProbedAndUnhealthyOnFailure() throws Exception {
    private static class FileSystemIOExceptionProvider extends FilterFileSystemProvider {
            this.size = size;
                StatusInfo info = fsHealthService.getHealth();
        private static final long AWAIT_BUSY_THRESHOLD = 100L;
            fsHealthService.new FsHealthMonitor().run();
        }
                delayBetweenChecks + (4 * refreshInterval),
        FileSystem fileSystem = PathUtils.getDefaultFileSystem();
        AtomicInteger injectedPaths = new AtomicInteger();
            };
    public void createObjects() {
        }
        FileSystemFsyncHungProvider(FileSystem inner, long delay, ThreadPool threadPool) {
    }
            );
                }
        } finally {
                List.of(additional)
    }
import java.nio.channels.FileChannel;
 *
                            injectedPaths.incrementAndGet();
        }
 * Modifications Copyright OpenSearch Contributors. See
            fsHealthService.doStop();
            );
            );
            assertThat(disruptedPathCount, equalTo(1));
        final Settings settings = Settings.builder().put(FsHealthService.REFRESH_INTERVAL_SETTING.getKey(), refreshInterval + "ms").build();
            .build();
                    }
    }
                }
            };
import static org.opensearch.node.Node.NODE_NAME_SETTING;
                }
            fileSystem,
        TestThreadPool testThreadPool = new TestThreadPool(getClass().getName(), settings);
                TimeUnit.MILLISECONDS
    }
                            && path.toString().endsWith(FsHealthService.FsHealthMonitor.TEMP_FILE_NAME)) {
                            } while (threadPool.relativeTimeInMillis() <= maxWaitTimeMillis && injectIODelay.get());
        try (NodeEnvironment env = newNodeEnvironment()) {
                            final long startTimeMillis = threadPool.relativeTimeInMillis();
            fsHealthService.doStop();
            assertEquals(HEALTHY, fsHealth.getStatus());
import org.opensearch.common.settings.Settings;
        metricsRegistry = new TestInMemoryMetricsRegistry();
}
        PathUtilsForTesting.installMock(fileSystem);
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
import java.nio.file.FileSystem;
            assertBusy(() -> {
                metricsRegistry
                        }
                                    throw new AssertionError(e);
                env,
            int rescheduledCount = 0;
            return injectedPaths.get();
        FileSystemUnexpectedLockFileSizeProvider(FileSystem inner, long size, ThreadPool threadPool) {
                assertTrue(fsHealthService.getHealth().getInfo().contains(path.toString()));
        public OutputStream newOutputStream(Path path, OpenOption... options) throws IOException {
            .put(ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.getKey(), 0)// we need to verify exact time
            PathUtilsForTesting.teardown();
        }
            super("disrupt_fs_health://", inner);
    private DeterministicTaskQueue deterministicTaskQueue;
        public void restrictPathPrefix(String pathPrefix) {
            assertEquals(Integer.valueOf(1), metricsRegistry.getCounterStore().get("fsHealth.failure.count").getCounterValue());
                    assertThat(deterministicTaskQueue.getLatestDeferredExecutionTime(), is(refreshInterval * (rescheduledCount + 1)));
            assertEquals(env.nodeDataPaths().length, disruptFileSystemProvider.getInjectedPathCount());
            // Empty additional-paths list — the spill-directory-not-configured scenario.
            assertEquals("health check passed", fsHealthService.getHealth().getInfo());
import org.apache.logging.log4j.LogManager;
        FileSystemFsyncHungProvider disruptFileSystemProvider = new FileSystemFsyncHungProvider(fileSystem, testThreadPool);
                    deterministicTaskQueue.runRandomTask();
            }
            // disrupt file system fsync on single path
            FsHealthService fsHealthService = new FsHealthService(
            Files.write(additional, new byte[] { 0x00 });
                        FsHealthService.class.getCanonicalName(),
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
            .build();
import java.nio.file.Files;
            disruptFsyncFileSystemProvider.injectIOException.set(true);
            for (Path path : env.nodeDataPaths()) {
        try (
import java.util.concurrent.TimeUnit;
            assertFalse(deterministicTaskQueue.hasDeferredTasks());
            fileSystem,
            testThreadPool
        } finally {
        FileSystemIOExceptionProvider disruptWritesFileSystemProvider = new FileSystemIOExceptionProvider(fileSystem);
        }
        try (NodeEnvironment env = newNodeEnvironment()) {
            assertEquals(HEALTHY, fsHealth.getStatus());
import org.apache.lucene.tests.mockfile.FilterFileChannel;
            );
                    )
        public FileChannel newFileChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
            assertEquals(HEALTHY, fsHealthService.getHealth().getStatus());
        final Settings settings = Settings.builder().put(FsHealthService.REFRESH_INTERVAL_SETTING.getKey(), refreshInterval + "ms").build();
        private String pathPrefix;
 * under the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private static class FileSystemUnexpectedLockFileSizeProvider extends FilterFileSystemProvider {
        try (NodeEnvironment env = newNodeEnvironment()) {
        @Override
                            injectedPaths.incrementAndGet();
        TestThreadPool testThreadPool = new TestThreadPool(getClass().getName(), settings);
                clusterSettings,
            disruptFileSystemProvider.injectIODelay.set(true);
            assertFalse(deterministicTaskQueue.hasRunnableTasks());
    }
            fsHealthService.doStart();
 * KIND, either express or implied.  See the License for the
        final Settings settings = Settings.builder()
                @Override
                public void force(boolean metaData) throws IOException {
                    super.force(metaData);
        final Settings settings = Settings.EMPTY;
        } finally {
                testThreadPool,
        );
        private String pathPrefix = null;
                testThreadPool,
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            return new FilterFileChannel(super.newFileChannel(path, options, attrs)) {
            // Make the additional path unwritable: replace the directory with a regular file.
        final Settings settings = Settings.EMPTY;
            fsHealth = fsHealthService.getHealth();
            PathUtilsForTesting.teardown();
                }
        deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
                healthyTimeoutThreshold + (2 * refreshInterval),
            IOUtils.rm(additional);
        TestThreadPool testThreadPool = new TestThreadPool(getClass().getName(), settings);
            FsHealthService fsHealthService = new FsHealthService(settings, clusterSettings, testThreadPool, env, metricsRegistry);
            waitUntil(
            super("disrupt_fs_health://", inner);
            assertEquals(HEALTHY, fsHealth.getStatus());
            disruptFileSystemProvider.restrictPathPrefix(""); // disrupt all paths
        FileSystem fileSystem = PathUtils.getDefaultFileSystem();
            }
                metricsRegistry,
    public void testNoAdditionalHealthPathsProbesOnlyDataPaths() throws Exception {
        long refreshInterval = randomLongBetween(1000, 12000);
        AtomicBoolean injectIODelay = new AtomicBoolean();
                settings,
package org.opensearch.monitor.fs;
            final long startTimeMillis = deterministicTaskQueue.getCurrentTimeMillis();
                    }
            this.threadPool = threadPool;
        }
        long healthyTimeoutThreshold = randomLongBetween(1500, 2000);
                    new MockLogAppender.SeenEventExpectation(
            fsHealthService.new FsHealthMonitor().run();
            fsHealthService.new FsHealthMonitor().run();
            assertEquals(HEALTHY, fsHealthService.getHealth().getStatus());
        } finally {
            .put(FsHealthService.REFRESH_INTERVAL_SETTING.getKey(), refreshInterval + "ms")
    private static class FileSystemFsyncIOExceptionProvider extends FilterFileSystemProvider {
import org.apache.lucene.tests.mockfile.FilterFileSystemProvider;
        }
                if (path.toString().startsWith(pathPrefix) && path.toString().endsWith(FsHealthService.FsHealthMonitor.TEMP_FILE_NAME)) {
        public int getInjectedPathCount() {
            FsHealthService fsHealthService = new FsHealthService(settings, clusterSettings, testThreadPool, env, metricsRegistry);
            this.pathPrefix = pathPrefix;
        private final ThreadPool threadPool;
        final TestThreadPool testThreadPool = new TestThreadPool(getClass().getName(), settings);
        fileSystem = disruptFileSystemProvider.getFileSystem(null);
 */
            assertEquals("health check passed", fsHealth.getInfo());
        FileSystem fileSystem = PathUtils.getDefaultFileSystem();
    }
        try (NodeEnvironment env = newNodeEnvironment()) {
            }
                }
                assertEquals(StatusInfo.Status.UNHEALTHY, info.getStatus());
        @Override
            this.pathPrefix = pathPrefix;
            return super.newOutputStream(path, options);
        public FileChannel newFileChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
                            do {
import static org.hamcrest.Matchers.equalTo;
import java.util.concurrent.atomic.AtomicBoolean;
                    super.force(metaData);
                        Level.WARN,
            assertEquals("health check passed", fsHealth.getInfo());
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
            assertEquals("health check passed", fsHealthService.getHealth().getInfo());
        AtomicInteger injectedPaths = new AtomicInteger();
            };
            String disruptedPath = randomFrom(paths).toString();
                env,
            Path[] paths = env.nodeDataPaths();
        FileSystemIOExceptionProvider(FileSystem inner) {
    private static class FileSystemFsyncHungProvider extends FilterFileSystemProvider {
        fileSystem = disruptWritesFileSystemProvider.getFileSystem(null);
            assertEquals(1, disruptWritesFileSystemProvider.getInjectedPathCount());
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        }
        }
        }
        private final ThreadPool threadPool;
import org.apache.logging.log4j.Level;
            fsHealthService.doStop();
        try (NodeEnvironment env = newNodeEnvironment()) {
                settings,
            assertEquals(UNHEALTHY, fsHealthService.getHealth().getStatus());
            fsHealthService.new FsHealthMonitor().run();
            MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(FsHealthService.class));
            FsHealthService fsHealthService = new FsHealthService(settings, clusterSettings, testThreadPool, env, metricsRegistry);
 *
        }
            PathUtilsForTesting.teardown();
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;
import org.opensearch.threadpool.TestThreadPool;
            logger.info("--> Initial health status prior to the first monitor run");
    }
                        if (path.getFileName().toString().equals(NodeEnvironment.NODE_LOCK_FILENAME)) {
            fsHealthService.new FsHealthMonitor().run();
                        }
/*
        AtomicInteger injectedPaths = new AtomicInteger();
        AtomicBoolean injectUnexpectedFileSize = new AtomicBoolean();
 */
            );
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
                clusterSettings,
            disruptWritesFileSystemProvider.restrictPathPrefix(disruptedPath);
            fsHealthService.new FsHealthMonitor().run();
                env,
            return injectedPaths.get();
import java.util.List;
import static org.hamcrest.Matchers.is;
            assertEquals(1, unexpectedLockFileSizeFileSystemProvider.getInjectedPathCount());
        final Settings settings = Settings.builder()
        long refreshInterval = randomLongBetween(500, 1000);
/*
        @Override
            int counter = 0;
            // disrupt file system
 * specific language governing permissions and limitations
            StatusInfo fsHealth = fsHealthService.getHealth();
            disruptWritesFileSystemProvider.injectIOException.set(false);
            disruptFileSystemProvider.injectIODelay.set(false);
 */
            PathUtilsForTesting.teardown();
                TimeUnit.MILLISECONDS
        final Settings settings = Settings.EMPTY;
        try (NodeEnvironment env = newNodeEnvironment()) {
            FsHealthService fsHealthService = new FsHealthService(settings, clusterSettings, testThreadPool, env, metricsRegistry);
                        "health check of [" + path + "] took [*ms] which is above the warn threshold*"
        TestThreadPool testThreadPool = new TestThreadPool(getClass().getName(), settings);
    }
    }
                        "test" + ++counter,
            int disruptedPathCount = disruptFileSystemProvider.getInjectedPathCount();
import java.nio.file.OpenOption;
                if (deterministicTaskQueue.hasRunnableTasks()) {
        final Settings settings = Settings.builder().put(FsHealthService.REFRESH_INTERVAL_SETTING.getKey(), refreshInterval + "ms").build();
                        if (path.getFileName().toString().equals(FsHealthService.FsHealthMonitor.TEMP_FILE_NAME)) {
            return injectedPaths.get();
        fileSystem = unexpectedLockFileSizeFileSystemProvider.getFileSystem(null);
        }
            disruptWritesFileSystemProvider.injectIOException.set(true);
 * The OpenSearch Contributors require contributions made to
            PathUtilsForTesting.teardown();
import java.io.OutputStream;
import org.opensearch.test.MockLogAppender;
        long slowLogThreshold = randomLongBetween(100, 200);
    public void testFailsHealthOnSinglePathWriteFailure() throws IOException {
        } finally {
            assertEquals(1, disruptFsyncFileSystemProvider.getInjectedPathCount());
            }
                    rescheduledCount++;
    }
            .put(FsHealthService.HEALTHY_TIMEOUT_SETTING.getKey(), healthyTimeoutThreshold + "ms")
            FsHealthService fsHealthService = new FsHealthService(settings, clusterSettings, testThreadPool, env, metricsRegistry);
            assertEquals("health check passed", fsHealthService.getHealth().getInfo());
import org.opensearch.test.telemetry.TestInMemoryMetricsRegistry;
        }
        TestThreadPool testThreadPool = new TestThreadPool(getClass().getName(), settings);
                    if (injectIODelay.get()) {
    public void testFailsHealthOnUnexpectedLockFileSize() throws IOException {
                    injectedPaths.incrementAndGet();
    public void testFailsHealthOnSinglePathFsyncFailure() throws IOException {
 * Unless required by applicable law or agreed to in writing,
            fsHealthService.doStop();
        ) {
 * GitHub history for details.
            disruptFileSystemProvider.injectIOException.set(true);
            super("disrupt_fs_health://", inner);
            assertBusy(() -> assertEquals(StatusInfo.Status.HEALTHY, fsHealthService.getHealth().getStatus()));
        FileSystemFsyncIOExceptionProvider(FileSystem inner) {
        }
            unexpectedLockFileSizeFileSystemProvider.injectUnexpectedFileSize.set(false);
        try (NodeEnvironment env = newNodeEnvironment()) {
    public void testFailsHealthOnIOException() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at
                mockAppender.addExpectation(
        private final long delay;
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertEquals(Integer.valueOf(1), metricsRegistry.getCounterStore().get("fsHealth.failure.count").getCounterValue());
            assertThat(fsHealthService.getHealth().getInfo(), is("health check failed on [" + disruptedPath + "]"));
        }
        } finally {
            this.threadPool = threadPool;
    private TestInMemoryMetricsRegistry metricsRegistry;
                            long timeInMillis = 1;
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            // disrupt file system writes on single path
            fsHealthService.doStart();
