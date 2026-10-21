        if (suspendedThreads != null) {
                + blockingThreadStackTrace
    private Set<Thread> suspendedThreads;
    }
                         */
                        public void onFailure(Exception e) {
                    blockDetectionThread = new Thread(new AbstractRunnable() {
                    logger.trace("suspending thread [{}]", threadName);
 *
                + LongGCDisruption.class.getName()
                    try {
                            logger.trace("resumed thread [{}] as it is in a critical section", threadName);
    }
 * GitHub history for details.
                suspendingThread.start();
                throw new RuntimeException(e);
    }
            try {
 * not use this file except in compliance with the License.
                    + ", node: "
                                return;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    @SuppressForbidden(reason = "suspends/resumes threads intentionally")
        for (Thread thread : allThreads) {
    }
            } finally {
                                Thread.sleep(getBlockDetectionIntervalInMillis());
    }
                                        onBlockDetected(threadInfo, blockingThreadInfo);
                            thread.resume();
                                            }
                                }
                            String className = stackElement.getClassName();
    /**
                    );
 * Licensed to Elasticsearch under one or more contributor
    private void stopBlockDetection() {
                    logger.warn(
        }
import org.opensearch.common.SuppressForbidden;
                        }
        return Arrays.stream(stackTraceElements).map(Object::toString).collect(Collectors.joining("\n"));
 */
import java.util.concurrent.ConcurrentHashMap;
                        @Override
    protected Pattern[] getUnsafeClasses() {
     * @see <a href=https://bugs.openjdk.java.net/browse/JDK-8218446>JDK-8218446</a>
                + blockedThread.getLockInfo()
                    blockDetectionThread.start();
                            + "\nThreads that weren't suspended:\n {}",
                // we didn't make enough space, retry
        // SecureRandom instance from SecureRandomHolder class is shared by all nodes
     */
     * until no more "live" are found.
                        /*
        String blockedThreadStackTrace = stackTrace(blockedThread.getStackTrace());
        }
                         * needs to be resumed.
     * Checks if during disruption we ran into a known JVM issue that makes {@link Thread#suspend()} calls block for multiple seconds
    protected long getSuspendingTimeoutInMillis() {
                }
                });
                // see unsafeClasses to how to avoid that
                                ThreadInfo[] threadInfos = threadBean.dumpAllThreads(true, true);
    @Override
    private static final Pattern[] unsafeClasses = new Pattern[] {
                + blockedThreadStackTrace
    protected void resumeThreads(Set<Thread> threads) {
                }
                final AtomicReference<Exception> suspendingError = new AtomicReference<>();
        } else {
    }
                                        }
                                if (unsafePattern.matcher(className).find()) {
                         * At the bottom of this try-block we will know whether or not it is safe to suspend the thread; we start by
                            if (e instanceof InterruptedException == false) {
            boolean success = false;
                    + currentThreadName
 * ownership. Elasticsearch licenses this file to you under
            if (isDisruptedNodeThread(threadName)) {
import java.util.Random;
    }
        Pattern.compile("java\\.security\\.SecureRandom") };
        stopBlockDetection();
        }
                            while (Thread.currentThread().isInterrupted() == false) {
                        "failed to suspend node [{}]'s threads within [{}] millis. Suspending thread stack trace:\n {}"
 */
                continue;
                + "] held by the suspended thread ["
 * software distributed under the License is distributed on an
                             * interrupted exception and never resume the suspended thread that is in a critical section. Also, logging
                    + disruptedNode;
/**
                + "\n"
import java.util.Set;
        );
    }
    // for testing
    @Override
            blockDetectionThread = null;
import java.util.concurrent.atomic.AtomicBoolean;
                    });
            throw new IllegalStateException("can't disrupt twice, call stopDisrupting() first");
                        suspendingThread.join();
                                                break;
                    // resume threads if failed
            thread.resume();
            String threadName = thread.getName();
    @Override
        // security manager is shared across all nodes and it uses synchronized maps internally
        // logging has shared JVM locks; we may suspend a thread and block other nodes from doing their thing
            }
    @SuppressForbidden(reason = "suspends/resumes threads intentionally")
                        }
 *
                    suspendingThread.join(getSuspendingTimeoutInMillis());
                        while (suspendThreads(suspendedThreads)) {
 */
                } catch (InterruptedException e) {
            suspendedThreads = null;
        }
        super(random);
                    @Override
 * The OpenSearch Contributors require contributions made to
                // of the threads that was suspended
                success = true;
                        safe = definitelySafe;
     * resolves all threads belonging to given node and suspends them if their current stack trace
                         * assuming that it is safe.
     * returns true if some live threads were found. The caller is expected to call this method
                                            if (otherThreadInfo.getThreadId() == threadInfo.getLockOwnerId()) {
                if (thread.isAlive() && nodeThreads.add(thread)) {
                        }
                    resumeThreads(suspendedThreads);
        return 3000L;
                if (suspendingThread.isAlive()) {
import java.util.regex.Pattern;
                        protected void doRun() throws Exception {
                        throw new RuntimeException(e);
import java.util.concurrent.TimeUnit;
                            if (Thread.interrupted()) {
                }
                    throw new RuntimeException("unknown error while suspending threads", suspendingError.get());
                    // we assume it is not safe to suspend the thread
                    liveThreadsFound = true;
                    protected void doRun() throws Exception {
                final Thread suspendingThread = new Thread(new AbstractRunnable() {
                // block detection checks if other threads are blocked waiting on an object that is held by one
    @SuppressWarnings({ "deprecation", "removal" }) // suspends/resumes threads intentionally
        Thread[] allThreads = null;
                    }
        }
                             * Do not log before resuming as we might be interrupted while logging in which case we will throw an
                             * before resuming makes for confusing log messages if we never hit the resume.
        for (Thread thread : threads) {
                                    // it is definitely not safe to suspend the thread
    }
                                    break safe;
            } catch (InterruptedException e) {
                    @Override
        return TimeValue.timeValueMillis(0);
 * specific language governing permissions and limitations
                        boolean definitelySafe = true;
                        getSuspendingTimeoutInMillis(),
                        // keep trying to suspend threads, until no new threads are discovered.
                if (suspendingError.get() != null) {
        return liveThreadsFound;
 */
    }
                                throw new AssertionError("unexpected exception in blockDetectionThread", e);
                        thread.suspend();
 * Unless required by applicable law or agreed to in writing,
/*
import org.opensearch.common.util.concurrent.AbstractRunnable;
package org.opensearch.test.disruption;
                    blockDetectionThread.setName(currentThreadName + "[LongGCDisruption][blockDetection]");
                    }
            if (thread == null) {
            }
/*
    @Override
                // if there are shared resources between caller thread and suspended threads
import java.lang.management.ThreadMXBean;
                        safe: for (StackTraceElement stackElement : thread.getStackTrace()) {
                            }
                        }
        this.disruptedNode = disruptedNode;
                + "Stack trace of blocked thread: "
                                }
        Pattern.compile("java\\.lang\\.SecurityManager"),
                    suspendingThread.interrupt(); // best effort;
 * Suspends all threads on the specified node in order to simulate a long gc.
                allThreads = null;
    protected final String disruptedNode;
import java.util.concurrent.atomic.AtomicReference;
                        if (!safe) {
import org.opensearch.test.InternalTestCluster;
                                    if (isDisruptedNodeThread(threadInfo.getThreadName()) == false
                            }
                         * We need to join on the suspending thread in case it has suspended a thread that is in a critical section and
                }
                assert isDisruptedNodeThread(currentThreadName) == false : "current thread match pattern. thread name: "
    // for testing
            }
        while (allThreads == null) {
 * under the License.
                        @Override
 * Modifications Copyright OpenSearch Contributors. See
                        // double check the thread is not in a shared resource like logging; if so, let it go and come back
                        }
                suspendingThread.setName(currentThreadName + "[LongGCDisruption][threadSuspender]");
import org.opensearch.common.unit.TimeValue;
                    throw new RuntimeException("suspending node threads took too long");
                         */
        String blockingThreadStackTrace = blockingThread != null ? stackTrace(blockingThread.getStackTrace()) : "not available";
     * was observed.
                                for (ThreadInfo threadInfo : threadInfos) {
                + blockedThread.getThreadName()
import java.util.Arrays;
    }
        if (suspendedThreads == null) {
                }
        }
    }
                    } catch (InterruptedException e) {
    private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
    }
import java.util.stream.Collectors;
    private Thread blockDetectionThread;
                        }
        return threadBean.isObjectMonitorUsageSupported() && threadBean.isSynchronizerUsageSupported();
 * the Apache License, Version 2.0 (the "License"); you may
                        suspendingError.set(e);
 * this file be licensed under the Apache-2.0 license or a
                                        // find ThreadInfo object of the blocking thread (if available)
                            /*
     * <p>
        return unsafeClasses;
 * this work for additional information regarding copyright
                                    definitelySafe = false;
     * @return true if during thread suspending a call to {@link Thread#suspend()} took more than 3s
                             */
            }
/*
        if (blockDetectionThread != null) {
                            for (Pattern unsafePattern : getUnsafeClasses()) {
                }
    @SuppressWarnings({ "deprecation", "removal" }) // suspends/resumes threads intentionally
                    try {
}
                        stackTrace(suspendingThread.getStackTrace()),
            resumeThreads(suspendedThreads);
                    }
                                        && threadInfo.getLockOwnerName() != null
    }
                            sawSlowSuspendBug.set(true);
        return threadName.contains("[" + disruptedNode + "]");
                                        for (ThreadInfo otherThreadInfo : threadInfos) {
                                        && isDisruptedNodeThread(threadInfo.getLockOwnerName())) {
            try {
                    } finally {
            allThreads = new Thread[Thread.activeCount()];
                    boolean safe = false;
    public boolean sawSlowSuspendBug() {
                + blockedThread.getLockOwnerName()
import org.opensearch.common.Nullable;
        ensureNodeCount(cluster);
    public synchronized void startDisrupting() {
    // for testing
 * compatible open source license.
    private String stackTrace(StackTraceElement[] stackTraceElements) {
                        /*
                + "] is blocked waiting on the resource ["
    public TimeValue expectedTimeToHeal() {
            "Thread ["
            }
                // we spawn a background thread to protect against deadlock which can happen
                + "Stack trace of blocking thread: "
                            .map(t -> t.getName() + "\n----\n" + stackTrace(t.getStackTrace()))
    protected long getBlockDetectionIntervalInMillis() {
                            }
    public void removeAndEnsureHealthy(InternalTestCluster cluster) {
                try {
                suspendedThreads = ConcurrentHashMap.newKeySet();
                final String currentThreadName = Thread.currentThread().getName();
import java.lang.management.ManagementFactory;
 * You may obtain a copy of the License at
                if (isBlockDetectionSupported()) {
                if (success == false) {
                + "Please add this occurrence to the unsafeClasses list in ["
                            }
        Pattern.compile("logging\\.log4j"),
 * license agreements. See the NOTICE file distributed with
                        final long startTime = System.nanoTime();
                + "] of the disrupted node ["
    protected void onBlockDetected(ThreadInfo blockedThread, @Nullable ThreadInfo blockingThread) {
                        suspendedThreads.stream()
public class LongGCDisruption extends SingleNodeDisruption {
 *     http://www.apache.org/licenses/LICENSE-2.0
     * is "safe". Threads are added to nodeThreads if suspended.
                + disruptedNode
                            .collect(Collectors.joining("\n"))
    private final AtomicBoolean sawSlowSuspendBug = new AtomicBoolean(false);
        removeFromCluster(cluster);
                                                blockingThreadInfo = otherThreadInfo;
 * SPDX-License-Identifier: Apache-2.0
                    throw new RuntimeException(e);
            if (Thread.enumerate(allThreads) > allThreads.length) {
                                    }
        boolean liveThreadsFound = false;
                                        ThreadInfo blockingThreadInfo = null;
    public synchronized void stopDisrupting() {
    protected boolean suspendThreads(Set<Thread> nodeThreads) {
 *
        return TimeValue.timeValueSeconds(30).getMillis();
    }
    }
                blockDetectionThread.join(getSuspendingTimeoutInMillis());
                    suspendedThreads = null;
    public boolean isDisruptedNodeThread(String threadName) {
        return sawSlowSuspendBug.get();
                        disruptedNode,
                blockDetectionThread.interrupt(); // best effort
                            nodeThreads.remove(thread);
                        if (System.nanoTime() - startTime > TimeUnit.SECONDS.toNanos(3L)) {
import java.lang.management.ThreadInfo;
        throw new AssertionError(
    /**
    public boolean isBlockDetectionSupported() {
                    stopBlockDetection();
                    public void onFailure(Exception e) {
     */
    public LongGCDisruption(Random random, String disruptedNode) {
                    }
                + "].\n"
                + "].\n"
 * KIND, either express or implied.  See the License for the
                    suspendingThread.interrupt(); // best effort to signal suspending
    // for testing
