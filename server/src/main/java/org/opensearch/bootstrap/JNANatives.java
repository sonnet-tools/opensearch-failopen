                } else {
                MAX_NUMBER_OF_THREADS = rlimit.rlim_cur.longValue();
                }
            if (ret == 1) {
        if (Constants.WINDOWS) {
        // mlockall failed for some reason
                logger.warn("unable to retrieve max file size [" + JNACLibrary.strerror(Native.getLastError()) + "]");
    }
    static long MAX_FILE_SIZE = Long.MIN_VALUE;
            // this will have already been logged by CLibrary, no need to repeat it
            final int rlimit_nproc = 6;
                if (result) {
            }
    /**
                logger.warn("unable to retrieve max number of threads [" + JNACLibrary.strerror(Native.getLastError()) + "]");
        try {
                return path;
    static void tryMlockall() {
            if (JNAKernel32Library.getInstance().GetShortPathNameW(longPath, shortPath, length) > 0) {
                MAX_SIZE_VIRTUAL_MEMORY = rlimit.rlim_cur.longValue();
    static boolean LOCAL_MLOCKALL = false;
 *
            if (Constants.LINUX || Constants.MAC_OS_X) {
            if (logger.isDebugEnabled()) {
                return;
    // Set to true, in case native system call filter install was successful
                        user
    static String getShortPathName(String path) {
                while (kernel.VirtualQueryEx(process, new Pointer(address), memInfo, memInfo.size()) != 0) {
                if (Constants.LINUX) {
    }
            int ret = SystemCallFilter.init(tmpFile);
 *
            if (process != null) {
            }
 */
 *
            } else {
package org.opensearch.bootstrap;
                    boolean lockable = memInfo.State.longValue() == JNAKernel32Library.MEM_COMMIT
 * The OpenSearch Contributors require contributions made to
            final WString longPath = new WString("\\\\?\\" + path);
                    String user = System.getProperty("user.name");
 * under the License.
            if (rlimitSuccess) {
            }
        boolean rlimitSuccess = false;
                    if (lockable) {
            }
            }
            final JNACLibrary.Rlimit rlimit = new JNACLibrary.Rlimit();
    /** no instantiation */
                logger.debug("unable to install syscall filter", e);
    static void addConsoleCtrlHandler(ConsoleCtrlHandler handler) {
        } finally {
import static org.opensearch.bootstrap.JNAKernel32Library.SizeT;
                logger.warn("Unable to lock JVM memory. Failed to set working set size. Error code {}", Native.getLastError());
                    rlimitToString(hardLimit)
/**
            if (length == 0) {
            errMsg = JNACLibrary.strerror(errno);
        }
                            + "\t# allow user '{}' mlockall\n"
import com.sun.jna.WString;
     * @param path the path
            }
    /** Returns true if user is root, false if not, or if we don't know */
            // on Linux the resource RLIMIT_NPROC means *the number of threads*
 * Licensed to Elasticsearch under one or more contributor
            // this is likely to happen unless the kernel is newish, its a best effort at the moment
    static void tryVirtualLock() {
    // set to the maximum number of threads that can be created for
        // The console Ctrl handler is necessary on Windows platforms only.
    // Set to true, in case native mlockall call was successful
    }
                long address = 0;
                    address += memInfo.RegionSize.longValue();
 * This class performs the actual work with JNA and library bindings to call native methods. It should only be used after
                // this will have already been logged by Kernel32Library, no need to repeat it
 * this work for additional information regarding copyright
                    rlimitToString(softLimit),
    }
import org.apache.logging.log4j.Logger;
            }
                    "Increase RLIMIT_MEMLOCK, soft limit: {}, hard limit: {}",
        }
            // see /usr/include/sys/resource.h on OS X
 * @opensearch.internal
            if (JNACLibrary.getrlimit(JNACLibrary.RLIMIT_FSIZE, rlimit) == 0) {
     * Retrieves the short path form of the specified path.
 *     http://www.apache.org/licenses/LICENSE-2.0
        assert Constants.LINUX || Constants.MAC_OS_X;
                    // give specific instructions for the linux case to make it easy
                boolean result = JNAKernel32Library.getInstance().addConsoleCtrlHandler(handler);
                    // Move to the next region
import java.nio.file.Path;
                    rlimitSuccess = true;
            final JNACLibrary.Rlimit rlimit = new JNACLibrary.Rlimit();
            SizeT size = new SizeT(JvmInfo.jvmInfo().getMem().getHeapInit().getBytes() + (1024 * 1024));
            }
                LOCAL_MLOCKALL = true;
            return Long.toUnsignedString(value);
/*
        JNAKernel32Library kernel = JNAKernel32Library.getInstance();
    }
        Pointer process = null;
            logger.warn("unable to install syscall filter: ", e);
    static long MAX_NUMBER_OF_THREADS = -1;
            } catch (UnsatisfiedLinkError e) {
        if (Constants.LINUX || Constants.MAC_OS_X) {
 * compatible open source license.
    static boolean LOCAL_SYSTEM_CALL_FILTER_ALL = false;
            try {
    static void trySetMaxFileSize() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        } catch (UnsatisfiedLinkError e) {
            return "unlimited";
                }
 * we are sure that the JNA classes are available to the JVM
        if (Constants.LINUX) {
    static long MAX_SIZE_VIRTUAL_MEMORY = Long.MIN_VALUE;
            final char[] shortPath = new char[length];
 * GitHub history for details.
            }
        }
/*
import com.sun.jna.Native;
import org.apache.lucene.util.Constants;
            }
 *
 */
                    }
import com.sun.jna.Pointer;
        }
 * Modifications Copyright OpenSearch Contributors. See
                    logger.warn("If you are logged in interactively, you will have to re-login for the new limits to take effect.");
                    logger.warn("Unable to retrieve resource limits: {}", JNACLibrary.strerror(Native.getLastError()));
import org.opensearch.monitor.jvm.JvmInfo;
                return Native.toString(shortPath);
 */
        String errMsg = null;
 * Unless required by applicable law or agreed to in writing,
            if (JNACLibrary.getrlimit(JNACLibrary.RLIMIT_AS, rlimit) == 0) {
        } catch (UnsatisfiedLinkError e) {
                logger.warn("Increase RLIMIT_MEMLOCK (ulimit).");
            } else {
        try {
                logger.warn(
 * You may obtain a copy of the License at
                JNAKernel32Library.MemoryBasicInformation memInfo = new JNAKernel32Library.MemoryBasicInformation();
 * not use this file except in compliance with the License.
                }
        } catch (final UnsatisfiedLinkError e) {
        }
            // this will have already been logged by Kernel32Library, no need to repeat it
                        && (memInfo.Protect.longValue() & JNAKernel32Library.PAGE_GUARD) != JNAKernel32Library.PAGE_GUARD;
 */
            // the amount of memory we wish to lock, plus a small overhead (1MB).
                    logger.warn("unknown error {} when adding console ctrl handler", Native.getLastError());
     *
            // first we get the length of the buffer needed
            if (result == 0) {
    }
            // this is in opposition to BSD-derived OSes
    }
        try {
                    logger.warn(
        if (value == JNACLibrary.RLIM_INFINITY) {
            return JNACLibrary.geteuid() == 0;
import org.apache.logging.log4j.LogManager;
            } else {
                        user,
            // By default, Windows limits the number of pages that can be locked.
                        && (memInfo.Protect.longValue() & JNAKernel32Library.PAGE_NOACCESS) != JNAKernel32Library.PAGE_NOACCESS
    private JNANatives() {}
 * ownership. Elasticsearch licenses this file to you under
                        "These can be adjusted by modifying /etc/security/limits.conf, for example: \n"
                return path;
                logger.warn("failed to get short path name: {}", Native.getLastError());
        try {
                    logger.debug("console ctrl handler correctly set");
    // Set to true, in case policy can be applied to all threads of the process (even existing ones)
        if (Constants.LINUX || Constants.MAC_OS_X) {
            } else {
    static void trySetMaxSizeVirtualMemory() {
            return false; // don't know
        }
        }
class JNANatives {
            if (JNACLibrary.getrlimit(rlimit_nproc, rlimit) == 0) {
        assert Constants.WINDOWS;
            } else {
            LOCAL_SYSTEM_CALL_FILTER = true;
        logger.warn("Unable to lock JVM Memory: error={}, reason={}", errno, errMsg);
    }
        long hardLimit = 0;
    private static final Logger logger = LogManager.getLogger(JNANatives.class);
    static boolean definitelyRunningAsRoot() {
    static void trySetMaxNumberOfThreads() {
            return false;
 * specific language governing permissions and limitations
                LOCAL_SYSTEM_CALL_FILTER_ALL = true;
            final JNACLibrary.Rlimit rlimit = new JNACLibrary.Rlimit();
                        user,
    }
        } else {
            process = kernel.GetCurrentProcess();
            // this is only valid on Linux and the value *is* different on OS X
                MAX_FILE_SIZE = rlimit.rlim_cur.longValue();
 * SPDX-License-Identifier: Apache-2.0
    static boolean LOCAL_SYSTEM_CALL_FILTER = false;
 * software distributed under the License is distributed on an
            final int length = JNAKernel32Library.getInstance().GetShortPathNameW(longPath, null, 0);
            // knowing the length of the buffer, now we get the short name
            }
                logger.warn("failed to get short path name: {}", Native.getLastError());
                }
        try {
 * KIND, either express or implied.  See the License for the
                JNACLibrary.Rlimit rlimit = new JNACLibrary.Rlimit();
    static String rlimitToString(long value) {
        }
            return;
            errno = Native.getLastError();
    // otherwise they are only inherited for new threads (OpenSearch app threads)
     * @return the short path name (or the original path if getting the short path name fails for any reason)
        } catch (Exception e) {
            // this will have already been logged by Kernel32Library, no need to repeat it
}
        long softLimit = 0;
            // so we log stacktrace at debug for now...
                logger.warn("unable to retrieve max size virtual memory [" + JNACLibrary.strerror(Native.getLastError()) + "]");
        } catch (UnsatisfiedLinkError e) {
                if (JNACLibrary.getrlimit(JNACLibrary.RLIMIT_MEMLOCK, rlimit) == 0) {
            }
            return path;
        if (errno == JNACLibrary.ENOMEM) {
                    );
                    hardLimit = rlimit.rlim_max.longValue();
    // the user ID that owns the running OpenSearch process
                // we only know RLIMIT_MEMLOCK for these two at the moment.
                    softLimit = rlimit.rlim_cur.longValue();
        }
                        kernel.VirtualLock(memInfo.BaseAddress, new SizeT(memInfo.RegionSize.longValue()));
                );
    }
/*
    static void tryInstallSystemCallFilter(Path tmpFile) {
                LOCAL_MLOCKALL = true;
 * license agreements. See the NOTICE file distributed with
            }
            // Thus, we need to first increase the working set size of the JVM by
        int errno = Integer.MIN_VALUE;
                            + "\t{} soft memlock unlimited\n"
     */
                } else {
                kernel.CloseHandle(process);
        }
        logger.warn("This can result in part of the JVM being swapped out.");
        if (Constants.WINDOWS) {
            int result = JNACLibrary.mlockall(JNACLibrary.MCL_CURRENT);
        }
            } else {
                            + "\t{} hard memlock unlimited",
 * this file be licensed under the Apache-2.0 license or a
        }
            if (!kernel.SetProcessWorkingSetSize(process, size, size)) {
 * the Apache License, Version 2.0 (the "License"); you may
