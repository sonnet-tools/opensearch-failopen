    }  
                if (success == false) {  
/*  
 * Suspends all threads on the specified node in order to simulate a long gc.  
public class LongGCDisruption extends SingleNodeDisruption {
            }  
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
        Pattern.compile("logging\\.log4j"),  
                    suspendingThread.join(getSuspendingTimeoutInMillis());
 *
                                        for (ThreadInfo otherThreadInfo : threadInfos) {  
                // we spawn a background thread to protect against deadlock which can happen
                }
                                    // it is definitely not safe to suspend the thread
        if (blockDetectionThread != null) {  
            } catch (InterruptedException e) {
                            nodeThreads.remove(thread);  
                         */
    @SuppressWarnings({ "deprecation", "removal" }) // suspends/resumes threads intentionally
                    protected void doRun() throws Exception {
                + "] is blocked waiting on the resource ["
        return liveThreadsFound;  
                        }
    @Override
    private String stackTrace(StackTraceElement[] stackTraceElements) {
    }
                        // keep trying to suspend threads, until no new threads are discovered.
package org.opensearch.test.disruption;
 * this work for additional information regarding copyright
                if (isBlockDetectionSupported()) {
                    throw new RuntimeException("suspending node threads took too long");  
        }  
    private final AtomicBoolean sawSlowSuspendBug = new AtomicBoolean(false);  
        }  
                            while (Thread.currentThread().isInterrupted() == false) {  
                    logger.trace("suspending thread [{}]", threadName);
                + blockedThread.getLockInfo()  
        super(random);  
        return 3000L;
     * was observed.  
                    }
    @SuppressForbidden(reason = "suspends/resumes threads intentionally")  
                    suspendingThread.interrupt(); // best effort;
                // we didn't make enough space, retry  
                } catch (InterruptedException e) {
                    blockDetectionThread = new Thread(new AbstractRunnable() {
                blockDetectionThread.join(getSuspendingTimeoutInMillis());  
                        safe: for (StackTraceElement stackElement : thread.getStackTrace()) {
                                                break;  
        }
 * Modifications Copyright OpenSearch Contributors. See
                suspendingThread.setName(currentThreadName + "[LongGCDisruption][threadSuspender]");
                            for (Pattern unsafePattern : getUnsafeClasses()) {  
                                if (unsafePattern.matcher(className).find()) {
    @Override
    }
                final String currentThreadName = Thread.currentThread().getName();  
                            if (e instanceof InterruptedException == false) {
        }
                                    if (isDisruptedNodeThread(threadInfo.getThreadName()) == false  
                        /*
                            }  
                        protected void doRun() throws Exception {
                    // resume threads if failed
     * until no more "live" are found.  
                                        ThreadInfo blockingThreadInfo = null;
 *  
                // if there are shared resources between caller thread and suspended threads  
        this.disruptedNode = disruptedNode;
                + "].\n"
        String blockingThreadStackTrace = blockingThread != null ? stackTrace(blockingThread.getStackTrace()) : "not available";
    @SuppressWarnings({ "deprecation", "removal" }) // suspends/resumes threads intentionally
                + "\n"
    protected long getSuspendingTimeoutInMillis() {  
                    try {
 */
                        throw new RuntimeException(e);
        }
    }  
                         * needs to be resumed.  
                        // double check the thread is not in a shared resource like logging; if so, let it go and come back  
                        while (suspendThreads(suspendedThreads)) {  
            try {  
/*  
                    } finally {  
     */
                        if (System.nanoTime() - startTime > TimeUnit.SECONDS.toNanos(3L)) {  
            }  
                // of the threads that was suspended  
                             * interrupted exception and never resume the suspended thread that is in a critical section. Also, logging
 * KIND, either express or implied.  See the License for the
                });  
 * Licensed to Elasticsearch under one or more contributor  
        ensureNodeCount(cluster);
                    );
                                    }
import java.util.regex.Pattern;
                                }
                    blockDetectionThread.setName(currentThreadName + "[LongGCDisruption][blockDetection]");
    private static final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();  
 * software distributed under the License is distributed on an
                    throw new RuntimeException(e);
    }
    public LongGCDisruption(Random random, String disruptedNode) {
            String threadName = thread.getName();  
                                return;
                        public void onFailure(Exception e) {
    private Set<Thread> suspendedThreads;  
        Thread[] allThreads = null;
                         */
import java.util.Arrays;
 * specific language governing permissions and limitations
            } finally {
                        suspendedThreads.stream()
 */  
                }
 * compatible open source license.
            }
        return unsafeClasses;
                             * before resuming makes for confusing log messages if we never hit the resume.
    // for testing
                                        onBlockDetected(threadInfo, blockingThreadInfo);  
    }  
                + "] held by the suspended thread ["
    public boolean isDisruptedNodeThread(String threadName) {  
            throw new IllegalStateException("can't disrupt twice, call stopDisrupting() first");
                if (suspendingThread.isAlive()) {  
        throw new AssertionError(
                + "] of the disrupted node ["  
 * under the License.  
                        disruptedNode,
        return TimeValue.timeValueMillis(0);
                        }
                        thread.suspend();
                            }
 * this file be licensed under the Apache-2.0 license or a
                                            if (otherThreadInfo.getThreadId() == threadInfo.getLockOwnerId()) {
 */
                    });  
     * <p>
import org.opensearch.common.unit.TimeValue;  
            }
    protected final String disruptedNode;
                    suspendedThreads = null;
import java.util.concurrent.atomic.AtomicBoolean;  
                    }
                blockDetectionThread.interrupt(); // best effort
                                throw new AssertionError("unexpected exception in blockDetectionThread", e);  
                            sawSlowSuspendBug.set(true);
                    try {  
        // logging has shared JVM locks; we may suspend a thread and block other nodes from doing their thing
 *     http://www.apache.org/licenses/LICENSE-2.0
     * resolves all threads belonging to given node and suspends them if their current stack trace
                                        && isDisruptedNodeThread(threadInfo.getLockOwnerName())) {
                        @Override  
                    // we assume it is not safe to suspend the thread
                        final long startTime = System.nanoTime();
    // for testing
                + LongGCDisruption.class.getName()
                    public void onFailure(Exception e) {
import java.lang.management.ManagementFactory;
                            .map(t -> t.getName() + "\n----\n" + stackTrace(t.getStackTrace()))
    // for testing  
        );
                            }
                                    definitelySafe = false;  
        return sawSlowSuspendBug.get();
            if (thread == null) {  
                        boolean definitelySafe = true;  
    }
                        }
                }  
                        /*
                            + "\nThreads that weren't suspended:\n {}",  
                            .collect(Collectors.joining("\n"))  
        Pattern.compile("java\\.security\\.SecureRandom") };
import java.util.Random;
 * not use this file except in compliance with the License.
            resumeThreads(suspendedThreads);  
            thread.resume();  
        if (suspendedThreads != null) {
    @SuppressForbidden(reason = "suspends/resumes threads intentionally")  
                        if (!safe) {
                suspendedThreads = ConcurrentHashMap.newKeySet();
 * ownership. Elasticsearch licenses this file to you under  
                                ThreadInfo[] threadInfos = threadBean.dumpAllThreads(true, true);
                    boolean safe = false;  
                    resumeThreads(suspendedThreads);  
    protected long getBlockDetectionIntervalInMillis() {  
import java.lang.management.ThreadMXBean;  
            boolean success = false;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.InternalTestCluster;
                if (suspendingError.get() != null) {  
                            String className = stackElement.getClassName();
                             * Do not log before resuming as we might be interrupted while logging in which case we will throw an  
    private void stopBlockDetection() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                                blockingThreadInfo = otherThreadInfo;
            allThreads = new Thread[Thread.activeCount()];
                + blockingThreadStackTrace
                            thread.resume();
                            /*
        // security manager is shared across all nodes and it uses synchronized maps internally
     * is "safe". Threads are added to nodeThreads if suspended.  
    /**
            blockDetectionThread = null;
                    @Override
                                            }
                        @Override
    @Override
                        }
                + blockedThreadStackTrace
                success = true;
    }  
                + blockedThread.getThreadName()
                                for (ThreadInfo threadInfo : threadInfos) {
                        suspendingThread.join();
        return Arrays.stream(stackTraceElements).map(Object::toString).collect(Collectors.joining("\n"));
import org.opensearch.common.Nullable;
                continue;
        // SecureRandom instance from SecureRandomHolder class is shared by all nodes  
import org.opensearch.common.SuppressForbidden;
                    @Override  
                + disruptedNode
    private static final Pattern[] unsafeClasses = new Pattern[] {
                        }
    protected void resumeThreads(Set<Thread> threads) {
                }  
                throw new RuntimeException(e);
     * Checks if during disruption we ran into a known JVM issue that makes {@link Thread#suspend()} calls block for multiple seconds
                suspendingThread.start();
                                }
    private Thread blockDetectionThread;
                    + disruptedNode;
        }
import java.util.concurrent.atomic.AtomicReference;
    protected boolean suspendThreads(Set<Thread> nodeThreads) {
                + "Stack trace of blocking thread: "  
    @Override
            suspendedThreads = null;
                if (thread.isAlive() && nodeThreads.add(thread)) {
    public boolean sawSlowSuspendBug() {
        return TimeValue.timeValueSeconds(30).getMillis();
                    + ", node: "  
                            logger.trace("resumed thread [{}] as it is in a critical section", threadName);
                    logger.warn(
 * You may obtain a copy of the License at  
                }
                                    break safe;
                                Thread.sleep(getBlockDetectionIntervalInMillis());  
    public synchronized void startDisrupting() {  
            }
                                        // find ThreadInfo object of the blocking thread (if available)
    }  
 * SPDX-License-Identifier: Apache-2.0
    }
    }  
                final Thread suspendingThread = new Thread(new AbstractRunnable() {  
/**
            if (isDisruptedNodeThread(threadName)) {
                             */  
            try {
    }  
 */  
    }
 * The OpenSearch Contributors require contributions made to  
            if (Thread.enumerate(allThreads) > allThreads.length) {
/*
import java.util.stream.Collectors;  
    protected Pattern[] getUnsafeClasses() {
                    }
                        stackTrace(suspendingThread.getStackTrace()),  
                         * assuming that it is safe.
                                        }
                    blockDetectionThread.start();
     * returns true if some live threads were found. The caller is expected to call this method
}  
        for (Thread thread : allThreads) {
        while (allThreads == null) {  
            "Thread ["  
    /**
                    throw new RuntimeException("unknown error while suspending threads", suspendingError.get());
                allThreads = null;
    }
                }
        stopBlockDetection();
                + blockedThread.getLockOwnerName()
                    liveThreadsFound = true;  
                    } catch (InterruptedException e) {  
                            if (Thread.interrupted()) {
import java.util.Set;  
import java.lang.management.ThreadInfo;
                assert isDisruptedNodeThread(currentThreadName) == false : "current thread match pattern. thread name: "
        return threadName.contains("[" + disruptedNode + "]");
                + "].\n"
    }
                        "failed to suspend node [{}]'s threads within [{}] millis. Suspending thread stack trace:\n {}"
                        safe = definitelySafe;
        boolean liveThreadsFound = false;
                            }  
                        suspendingError.set(e);  
import java.util.concurrent.TimeUnit;
        Pattern.compile("java\\.lang\\.SecurityManager"),
                + "Please add this occurrence to the unsafeClasses list in ["  
     */  
                         * We need to join on the suspending thread in case it has suspended a thread that is in a critical section and
        for (Thread thread : threads) {
                try {  
 * GitHub history for details.
import org.opensearch.common.util.concurrent.AbstractRunnable;
                // see unsafeClasses to how to avoid that
                final AtomicReference<Exception> suspendingError = new AtomicReference<>();
                // block detection checks if other threads are blocked waiting on an object that is held by one
    public boolean isBlockDetectionSupported() {
    public synchronized void stopDisrupting() {  
    public TimeValue expectedTimeToHeal() {  
        } else {
                    suspendingThread.interrupt(); // best effort to signal suspending  
        String blockedThreadStackTrace = stackTrace(blockedThread.getStackTrace());  
 *
    // for testing
    protected void onBlockDetected(ThreadInfo blockedThread, @Nullable ThreadInfo blockingThread) {
                    }
                + "Stack trace of blocked thread: "  
import java.util.concurrent.ConcurrentHashMap;
                        getSuspendingTimeoutInMillis(),
    }  
        if (suspendedThreads == null) {
                         * At the bottom of this try-block we will know whether or not it is safe to suspend the thread; we start by  
     * @return true if during thread suspending a call to {@link Thread#suspend()} took more than 3s
    public void removeAndEnsureHealthy(InternalTestCluster cluster) {  
        return threadBean.isObjectMonitorUsageSupported() && threadBean.isSynchronizerUsageSupported();
                    stopBlockDetection();
                    + currentThreadName
        removeFromCluster(cluster);
                        }
                                        && threadInfo.getLockOwnerName() != null
     * @see <a href=https://bugs.openjdk.java.net/browse/JDK-8218446>JDK-8218446</a>
