            disruptFsyncFileSystemProvider.restrictPathPrefix(disruptedPath);
        FileSystemIOExceptionProvider disruptFileSystemProvider = new FileSystemIOExceptionProvider(fileSystem);
                deterministicTaskQueue.getThreadPool(),
                    assertThat(deterministicTaskQueue.getLatestDeferredExecutionTime(), is(refreshInterval * (rescheduledCount + 1)));
                            long maxWaitTimeMillis = startTimeMillis + delay >= 0 ? startTimeMillis + delay : Long.MAX_VALUE;// long  
import org.opensearch.common.settings.Settings;  
    }
                            injectedPaths.incrementAndGet();  
        }
                        assert pathPrefix != null : "must set pathPrefix before starting disruptions";  
        fileSystem = disruptFileSystemProvider.getFileSystem(null);
            assertEquals("health check passed", fsHealthService.getHealth().getInfo());
        long slowLogThreshold = randomLongBetween(100, 200);
        }
            assertTrue(deterministicTaskQueue.hasDeferredTasks());
        } finally {
            };  
        private String pathPrefix = null;
            disruptFileSystemProvider.injectIOException.set(true);  
                        }  
import static org.opensearch.node.Node.NODE_NAME_SETTING;
            waitUntil(
            FsHealthService fsHealthService = new FsHealthService(settings, clusterSettings, testThreadPool, env, metricsRegistry);
import org.apache.lucene.tests.mockfile.FilterFileChannel;  
        }  
        }
        FileSystemFsyncIOExceptionProvider(FileSystem inner) {  
        final Settings settings = Settings.builder().put(FsHealthService.REFRESH_INTERVAL_SETTING.getKey(), refreshInterval + "ms").build();
        }  
                    if (injectUnexpectedFileSize.get()) {
                            long timeInMillis = 1;
    }  
            assertEquals(HEALTHY, fsHealth.getStatus());  
                settings,  
            assertFalse(deterministicTaskQueue.hasRunnableTasks());
            assertFalse(deterministicTaskQueue.hasRunnableTasks());  
            fsHealthService.doStop();  
import org.junit.Before;
                env,
            return injectedPaths.get();  
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                            } while (threadPool.relativeTimeInMillis() <= maxWaitTimeMillis && injectIODelay.get());  
import java.util.List;
                                    Thread.sleep(timeInMillis);
                    return super.size();
        TestThreadPool testThreadPool = new TestThreadPool(getClass().getName(), settings);  
import org.opensearch.threadpool.ThreadPool;  
import static org.hamcrest.Matchers.is;  
import org.opensearch.env.NodeEnvironment;
            fsHealthService.new FsHealthMonitor().run();
                                                                                                                             // overflow
        PathUtilsForTesting.installMock(fileSystem);
 * GitHub history for details.
            fsHealth = fsHealthService.getHealth();
                metricsRegistry,
            this.delay = Long.MAX_VALUE;
    public void testFailsHealthOnIOException() throws IOException {
        AtomicInteger injectedPaths = new AtomicInteger();
        deterministicTaskQueue = new DeterministicTaskQueue(settings, random());
            assertEquals("healthy threshold breached", fsHealth.getInfo());
            deterministicTaskQueue.runAllTasksInTimeOrder();
        public int getInjectedPathCount() {
import org.opensearch.test.OpenSearchTestCase;
            FsHealthService fsHealthService = new FsHealthService(settings, clusterSettings, testThreadPool, env, metricsRegistry);
import java.nio.channels.FileChannel;
                            do {
            this.size = size;
    public void testLoggingOnHungIO() throws Exception {
        }  
                assertTrue(fsHealthService.getHealth().getInfo().contains(path.toString()));
        public FileChannel newFileChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
    public void testFailsHealthOnSinglePathWriteFailure() throws IOException {  
/*  
            assertEquals(HEALTHY, fsHealth.getStatus());
import org.apache.logging.log4j.Level;
            }  
                            && path.toString().endsWith(FsHealthService.FsHealthMonitor.TEMP_FILE_NAME)) {
            fsHealthService.new FsHealthMonitor().run();  
            // disrupt file system fsync on single path
import org.apache.lucene.tests.mockfile.FilterFileSystemProvider;
        FileSystemFsyncHungProvider disruptFileSystemProvider = new FileSystemFsyncHungProvider(fileSystem, testThreadPool);
            waitUntil(
            assertBusy(() -> assertEquals(StatusInfo.Status.HEALTHY, fsHealthService.getHealth().getStatus()));
                assert pathPrefix != null : "must set pathPrefix before starting disruptions";
                    super.force(metaData);  
                @Override
    }
 * not use this file except in compliance with the License.
        try (NodeEnvironment env = newNodeEnvironment()) {  
        long refreshInterval = 50; // ms
import org.opensearch.monitor.StatusInfo;  
            assertEquals(UNHEALTHY, fsHealthService.getHealth().getStatus());
                            injectedPaths.incrementAndGet();  
            FsHealthService fsHealthService = new FsHealthService(
 *
    private DeterministicTaskQueue deterministicTaskQueue;
        final Settings settings = Settings.EMPTY;
import static org.hamcrest.Matchers.equalTo;
import java.nio.file.FileSystem;  
                    rescheduledCount++;
        FileSystemFsyncHungProvider(FileSystem inner, long delay, ThreadPool threadPool) {
            fsHealthService.new FsHealthMonitor().run();  
                    new MockLogAppender.SeenEventExpectation(
            assertEquals(HEALTHY, fsHealthService.getHealth().getStatus());  
                () -> fsHealthService.getHealth().getStatus() == UNHEALTHY,
                List.of()
            return injectedPaths.get();  
        TestThreadPool testThreadPool = new TestThreadPool(getClass().getName(), settings);  
            return new FilterFileChannel(super.newFileChannel(path, options, attrs)) {
            disruptWritesFileSystemProvider.injectIOException.set(true);  
        long slowLogThreshold = randomLongBetween(100, 200);  
            logger.info("--> Fix file system disruption");
            StatusInfo fsHealth = fsHealthService.getHealth();
            assertEquals(UNHEALTHY, fsHealthService.getHealth().getStatus());
            disruptFileSystemProvider.injectIOException.set(false);  
            assertThat(fsHealthService.getHealth().getInfo(), is("health check failed due to broken node lock"));
            disruptFileSystemProvider.injectIODelay.set(true);
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
                    if (injectIODelay.get()) {
        TestThreadPool testThreadPool = new TestThreadPool(getClass().getName(), settings);
                }
            // Empty additional-paths list — the spill-directory-not-configured scenario.
    public void testNoAdditionalHealthPathsProbesOnlyDataPaths() throws Exception {
            for (int i = 1; i <= randomIntBetween(5, 10); i++) {
    private static class FileSystemIOExceptionProvider extends FilterFileSystemProvider {  
        }
            assertEquals("health check passed", fsHealth.getInfo());  
            MockLogAppender mockAppender = MockLogAppender.createForLoggers(LogManager.getLogger(FsHealthService.class));  
 * The OpenSearch Contributors require contributions made to  
            assertEquals(HEALTHY, fsHealth.getStatus());
            disruptFsyncFileSystemProvider.injectIOException.set(false);  
            .build();
            // disrupt file system
            return new FilterFileChannel(super.newFileChannel(path, options, attrs)) {
import org.opensearch.test.MockLogAppender;
    }  
                assertTrue(info.getInfo(), info.getInfo().contains(additional.toString()));
import org.opensearch.threadpool.TestThreadPool;
        private String pathPrefix;
        FileSystemIOExceptionProvider disruptWritesFileSystemProvider = new FileSystemIOExceptionProvider(fileSystem);
            String disruptedPath = randomFrom(paths).toString();
 *    http://www.apache.org/licenses/LICENSE-2.0
        } finally {
        final Settings settings = Settings.builder().put(FsHealthService.REFRESH_INTERVAL_SETTING.getKey(), refreshInterval + "ms").build();
            1,
            assertEquals(HEALTHY, fsHealthService.getHealth().getStatus());
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        }
    }
            assertEquals("health check passed", fsHealthService.getHealth().getInfo());  
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            assertEquals("health check passed", fsHealthService.getHealth().getInfo());
                public void force(boolean metaData) throws IOException {
import org.apache.logging.log4j.LogManager;
        fileSystem = disruptFsyncFileSystemProvider.getFileSystem(null);
        FileSystem fileSystem = PathUtils.getDefaultFileSystem();  
package org.opensearch.monitor.fs;
/*  
            disruptWritesFileSystemProvider.injectIOException.set(false);
        }  
        AtomicBoolean injectIOException = new AtomicBoolean();
            fsHealthService.doStart();  
            final long startTimeMillis = deterministicTaskQueue.getCurrentTimeMillis();
            assertEquals(UNHEALTHY, fsHealthService.getHealth().getStatus());
                assertEquals(StatusInfo.Status.UNHEALTHY, info.getStatus());  
                settings,
        }
            this.threadPool = threadPool;
    public void testSchedulesHealthCheckAtRefreshIntervals() throws Exception {
            fsHealthService.new FsHealthMonitor().run();
                }
            assertEquals(Integer.valueOf(1), metricsRegistry.getCounterStore().get("fsHealth.failure.count").getCounterValue());  
                public void force(boolean metaData) throws IOException {  
            // disrupt file system
        }  
        FileSystem fileSystem = PathUtils.getDefaultFileSystem();
    private TestInMemoryMetricsRegistry metricsRegistry;
                    deterministicTaskQueue.runRandomTask();  
            assertEquals(1, disruptWritesFileSystemProvider.getInjectedPathCount());
            );  
    public void testFailsHealthOnSinglePathFsyncFailure() throws IOException {
        FileSystemUnexpectedLockFileSizeProvider unexpectedLockFileSizeFileSystemProvider = new FileSystemUnexpectedLockFileSizeProvider(
        long healthyTimeoutThreshold = randomLongBetween(1500, 2000);
            for (Path path : env.nodeDataPaths()) {
        } finally {
        final TestThreadPool testThreadPool = new TestThreadPool(getClass().getName(), settings);
            NodeEnvironment env = newNodeEnvironment()
                        }
}
                }
            assertBusy(mockAppender::assertAllExpectationsMatched);
                        if (path.getFileName().toString().equals(FsHealthService.FsHealthMonitor.TEMP_FILE_NAME)) {
        AtomicBoolean injectIOException = new AtomicBoolean();
        final Settings settings = Settings.EMPTY;
import java.util.Set;  
                mockAppender.addExpectation(  
                metricsRegistry  
            assertEquals(UNHEALTHY, fsHealth.getStatus());
            assertEquals("health check passed", fsHealth.getInfo());
            randomLongBetween(slowLogThreshold + 1, 400),
        private final long delay;  
        final Settings settings = Settings.builder()
                        Level.WARN,
 * KIND, either express or implied.  See the License for the
        );  
            }
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
        final Settings settings = Settings.EMPTY;  
                        "health check of [" + path + "] took [*ms] which is above the warn threshold*"
import java.util.concurrent.atomic.AtomicBoolean;
 *  
        FileSystemIOExceptionProvider(FileSystem inner) {
            fsHealthService.new FsHealthMonitor().run();
            this.pathPrefix = pathPrefix;  
 * the Apache License, Version 2.0 (the "License"); you may
        public OutputStream newOutputStream(Path path, OpenOption... options) throws IOException {
        private final ThreadPool threadPool;  
            assertEquals(disruptedPathCount, disruptFileSystemProvider.getInjectedPathCount());  
                            final long startTimeMillis = threadPool.relativeTimeInMillis();
            testThreadPool
            fileSystem,  
 * this work for additional information regarding copyright
                            return size;
        PathUtilsForTesting.installMock(fileSystem);  
            // disrupt file system writes on single path  
        }  
        FileSystemFsyncHungProvider(FileSystem inner, ThreadPool threadPool) {
    }  
            }
                    if (injectIOException.get()) {
            fsHealthService.doStart();
            .put(ThreadPool.ESTIMATED_TIME_INTERVAL_SETTING.getKey(), 0)// we need to verify exact time  
            );
        }  
        public int getInjectedPathCount() {
        try (NodeEnvironment env = newNodeEnvironment()) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .put(FsHealthService.SLOW_PATH_LOGGING_THRESHOLD_SETTING.getKey(), slowLogThreshold + "ms")
            };
        try (NodeEnvironment env = newNodeEnvironment()) {
        AtomicInteger injectedPaths = new AtomicInteger();  
    public void testFailsHealthOnHungIOBeyondHealthyTimeout() throws Exception {  
            this.delay = delay;  
import java.io.IOException;  
            assertEquals(env.nodeDataPaths().length, disruptFileSystemProvider.getInjectedPathCount());
                settings,
        );  
            logger.info("--> Disrupt file system");
            return super.newOutputStream(path, options);
                clusterSettings,  
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                    deterministicTaskQueue.advanceTime();  
import org.opensearch.test.telemetry.TestInMemoryMetricsRegistry;
        try (NodeEnvironment env = newNodeEnvironment()) {
        }
            fsHealthService.doStop();  
        ) {
                        "test" + ++counter,
    @Before
import java.nio.file.attribute.FileAttribute;
                () -> fsHealthService.getHealth().getStatus() == HEALTHY,
    private static class FileSystemFsyncHungProvider extends FilterFileSystemProvider {
        FileSystem fileSystem = PathUtils.getDefaultFileSystem();  
            disruptFileSystemProvider.restrictPathPrefix(""); // disrupt all paths
 */  
            assertEquals(Integer.valueOf(1), metricsRegistry.getCounterStore().get("fsHealth.failure.count").getCounterValue());
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
 * under the License.  
        @Override
            assertEquals(UNHEALTHY, fsHealthService.getHealth().getStatus());
    }
            this.pathPrefix = pathPrefix;
import java.util.concurrent.TimeUnit;
            logger.info("--> First monitor run");
            this.threadPool = threadPool;  
import java.nio.file.Files;
        FileSystem fileSystem = PathUtils.getDefaultFileSystem();  
            FsHealthService fsHealthService = new FsHealthService(
 * Modifications Copyright OpenSearch Contributors. See
            super("disrupt_fs_health://", inner);
        @Override  
import java.nio.file.OpenOption;
                        if (path.toString().startsWith(pathPrefix)
        FileSystemUnexpectedLockFileSizeProvider(FileSystem inner, long size, ThreadPool threadPool) {
            };
                @Override  
    }  
            Path[] paths = env.nodeDataPaths();
        }  
import org.opensearch.common.settings.ClusterSettings;
        TestThreadPool testThreadPool = new TestThreadPool(getClass().getName(), settings);
            assertEquals(Integer.valueOf(1), metricsRegistry.getCounterStore().get("fsHealth.failure.count").getCounterValue());  
 * You may obtain a copy of the License at  
                            throw new IOException("fake IOException");
                @Override  
        AtomicBoolean injectIODelay = new AtomicBoolean();  
                    injectedPaths.incrementAndGet();  
        AtomicInteger injectedPaths = new AtomicInteger();  
                    }
                    throw new IOException("fake IOException");
                public long size() throws IOException {
            PathUtilsForTesting.teardown();  
            fsHealthService.new FsHealthMonitor().run();  
        PathUtilsForTesting.installMock(fileSystem);  
        try (NodeEnvironment env = newNodeEnvironment()) {
            unexpectedLockFileSizeFileSystemProvider.injectUnexpectedFileSize.set(false);
        public int getInjectedPathCount() {  
        public int getInjectedPathCount() {
 * Unless required by applicable law or agreed to in writing,
                if (path.toString().startsWith(pathPrefix) && path.toString().endsWith(FsHealthService.FsHealthMonitor.TEMP_FILE_NAME)) {
    }  
                metricsRegistry,  
        }
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);  
        }
                    }
        PathUtilsForTesting.installMock(fileSystem);
        FileSystem fileSystem = PathUtils.getDefaultFileSystem();
                clusterSettings,  
            return injectedPaths.get();
            }  
            super("disrupt_fs_health://", inner);
            assertFalse(deterministicTaskQueue.hasDeferredTasks());
 *
                if (deterministicTaskQueue.hasRunnableTasks()) {
            int rescheduledCount = 0;  
                List.of(additional)
        public void restrictPathPrefix(String pathPrefix) {
            .build();
    private static class FileSystemUnexpectedLockFileSizeProvider extends FilterFileSystemProvider {  
            );
        long refreshInterval = randomLongBetween(500, 1000);
            assertThat(disruptedPathCount, equalTo(1));
import java.util.concurrent.atomic.AtomicInteger;  
            PathUtilsForTesting.teardown();
    }
                TimeUnit.MILLISECONDS
                        FsHealthService.class.getCanonicalName(),  
            assertEquals(HEALTHY, fsHealthService.getHealth().getStatus());
        public FileChannel newFileChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {
            disruptFileSystemProvider.injectIODelay.set(true);
            int counter = 0;
            assertThat(fsHealthService.getHealth().getInfo(), is("health check failed on [" + disruptedPath + "]"));  
        try (NodeEnvironment env = newNodeEnvironment()) {
            fsHealth = fsHealthService.getHealth();  
            testThreadPool
                                try {  
            assertEquals(1, unexpectedLockFileSizeFileSystemProvider.getInjectedPathCount());
        }
            PathUtilsForTesting.teardown();
            unexpectedLockFileSizeFileSystemProvider.injectUnexpectedFileSize.set(true);
                StatusInfo info = fsHealthService.getHealth();
            assertBusy(() -> assertEquals(StatusInfo.Status.HEALTHY, fsHealthService.getHealth().getStatus()));
        fileSystem = unexpectedLockFileSizeFileSystemProvider.getFileSystem(null);
            assertBusy(() -> {
            IOUtils.rm(additional);
                env,  
        }
                );
            FsHealthService fsHealthService = new FsHealthService(settings, clusterSettings, testThreadPool, env, metricsRegistry);
import java.nio.file.Path;  
 * this file be licensed under the Apache-2.0 license or a
                healthyTimeoutThreshold + (2 * refreshInterval),  
        private static final long AWAIT_BUSY_THRESHOLD = 100L;
            PathUtilsForTesting.teardown();
import org.opensearch.common.io.PathUtilsForTesting;
            .put(FsHealthService.REFRESH_INTERVAL_SETTING.getKey(), refreshInterval + "ms")
        fileSystem = disruptFileSystemProvider.getFileSystem(null);
 */
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
        }  
                } else {
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
        long refreshInterval = 50;
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
import static org.opensearch.monitor.StatusInfo.Status.HEALTHY;
/*
            PathUtilsForTesting.teardown();
            fsHealthService.doStop();  
            super("disrupt_fs_health://", inner);
            FsHealthService fsHealthService = new FsHealthService(settings, clusterSettings, testThreadPool, env, metricsRegistry);  
            assertEquals("health check passed", fsHealth.getInfo());
 * compatible open source license.
            int disruptedPathCount = disruptFileSystemProvider.getInjectedPathCount();  
            });
        try (NodeEnvironment env = newNodeEnvironment()) {
                        if (path.getFileName().toString().equals(NodeEnvironment.NODE_LOCK_FILENAME)) {  
                testThreadPool,
        }
    }
        fileSystem = disruptFileSystemProvider.getFileSystem(null);
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        AtomicBoolean injectUnexpectedFileSize = new AtomicBoolean();
                assertThat(deterministicTaskQueue.getCurrentTimeMillis() - startTimeMillis, is(refreshInterval * rescheduledCount));  
        } finally {
import org.opensearch.cluster.coordination.DeterministicTaskQueue;
            for (Path path : env.nodeDataPaths()) {
            return injectedPaths.get();
 * license agreements. See the NOTICE file distributed with
        private final long size;
        FileSystem fileSystem = PathUtils.getDefaultFileSystem();
        final Settings settings = Settings.builder().put(FsHealthService.REFRESH_INTERVAL_SETTING.getKey(), refreshInterval + "ms").build();  
import org.opensearch.test.junit.annotations.TestLogging;  
 * specific language governing permissions and limitations
        } finally {  
                delayBetweenChecks + (4 * refreshInterval),  
            fsHealthService.new FsHealthMonitor().run();
        } finally {  
        }
                clusterSettings,
                TimeUnit.MILLISECONDS
            super("disrupt_fs_health://", inner);  
            assertEquals(1, disruptFsyncFileSystemProvider.getInjectedPathCount());
 * SPDX-License-Identifier: Apache-2.0
            String disruptedPath = randomFrom(paths).toString();
        FileSystemFsyncIOExceptionProvider disruptFsyncFileSystemProvider = new FileSystemFsyncIOExceptionProvider(fileSystem);
        @Override  
 * Licensed to Elasticsearch under one or more contributor  
        final ClusterSettings clusterSettings = new ClusterSettings(settings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            .put(FsHealthService.HEALTHY_TIMEOUT_SETTING.getKey(), healthyTimeoutThreshold + "ms")  
            assertEquals(env.nodeDataPaths().length, disruptFileSystemProvider.getInjectedPathCount());
            fsHealthService.doStart();  
        PathUtilsForTesting.installMock(fileSystem);
            return new FilterFileChannel(super.newFileChannel(path, options, attrs)) {
            // Make the additional path unwritable: replace the directory with a regular file.  
        final Settings settings = Settings.builder()  
        FileSystemFsyncHungProvider disruptFileSystemProvider = new FileSystemFsyncHungProvider(
 * ownership. Elasticsearch licenses this file to you under  
        public FileChannel newFileChannel(Path path, Set<? extends OpenOption> options, FileAttribute<?>... attrs) throws IOException {  
                            injectedPaths.incrementAndGet();
        final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            Files.write(additional, new byte[] { 0x00 });
            disruptFileSystemProvider.injectIODelay.set(false);  
import static org.opensearch.monitor.StatusInfo.Status.UNHEALTHY;  
            assertEquals("health check passed", fsHealthService.getHealth().getInfo());
            super("disrupt_fs_health://", inner);
                    }  
            fsHealth = fsHealthService.getHealth();  
            );
        TestThreadPool testThreadPool = new TestThreadPool(getClass().getName(), settings);
            assertEquals(HEALTHY, fsHealthService.getHealth().getStatus());
                                } catch (InterruptedException e) {
            final Path additional = createTempDir();  
            if (injectIOException.get()) {  
            assertThat(fsHealthService.getHealth().getInfo(), is("health check failed on [" + disruptedPath + "]"));
import org.opensearch.common.io.PathUtils;  
            fileSystem,  
            FsHealthService fsHealthService = new FsHealthService(settings, clusterSettings, testThreadPool, env, metricsRegistry);  
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);
            PathUtilsForTesting.teardown();
                        }
public class FsHealthServiceTests extends OpenSearchTestCase {
            fsHealthService.doStart();  
        PathUtilsForTesting.installMock(fileSystem);  
    }
        AtomicInteger injectedPaths = new AtomicInteger();
                                }
            this.threadPool = threadPool;
            fsHealthService.new FsHealthMonitor().run();
        final Settings settings = Settings.EMPTY;
        long refreshInterval = randomLongBetween(1000, 12000);  
        try (
            fsHealthService.new FsHealthMonitor().run();  
        metricsRegistry = new TestInMemoryMetricsRegistry();
                }
            ThreadPool.terminate(testThreadPool, 500, TimeUnit.MILLISECONDS);  
        try (NodeEnvironment env = newNodeEnvironment()) {
    public void testAdditionalHealthPathProbedAndUnhealthyOnFailure() throws Exception {  
            FsHealthService fsHealthService = new FsHealthService(
        @Override
    }
 */  
                env,
        private final ThreadPool threadPool;
    private static class FileSystemFsyncIOExceptionProvider extends FilterFileSystemProvider {
            Path[] paths = env.nodeDataPaths();  
    }
                                timeInMillis = Math.min(AWAIT_BUSY_THRESHOLD, timeInMillis * 2);
                testThreadPool,
                    )  
                }  
            // enabling unexpected file size injection
        } finally {  
                    super.force(metaData);
            );
        }  
            logger.info("--> Initial health status prior to the first monitor run");
    @TestLogging(value = "org.opensearch.monitor.fs:WARN", reason = "to ensure that we log on hung IO at WARN level")  
                                    throw new AssertionError(e);  
        }
            disruptWritesFileSystemProvider.restrictPathPrefix(disruptedPath);
import java.io.OutputStream;
        fileSystem = disruptWritesFileSystemProvider.getFileSystem(null);  
        TestThreadPool testThreadPool = new TestThreadPool(getClass().getName(), settings);  
    public void testFailsHealthOnUnexpectedLockFileSize() throws IOException {
            .put(FsHealthService.SLOW_PATH_LOGGING_THRESHOLD_SETTING.getKey(), slowLogThreshold + "ms")
import org.opensearch.common.util.io.IOUtils;
        long delayBetweenChecks = 100;
 * software distributed under the License is distributed on an
    public void createObjects() {
        final TestThreadPool testThreadPool = new TestThreadPool(getClass().getName(), settings);
            disruptFsyncFileSystemProvider.injectIOException.set(true);  
            fsHealthService.doStop();
            assertEquals(Integer.valueOf(1), metricsRegistry.getCounterStore().get("fsHealth.failure.count").getCounterValue());  
            fsHealthService.new FsHealthMonitor().run();  
            FsHealthService fsHealthService = new FsHealthService(settings, clusterSettings, testThreadPool, env, metricsRegistry);  
        Settings settings = Settings.builder().put(NODE_NAME_SETTING.getKey(), "node").build();  
        public void restrictPathPrefix(String pathPrefix) {
        } finally {
