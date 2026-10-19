 * the Apache License, Version 2.0 (the "License"); you may
                if (JNACLibrary.getrlimit(JNACLibrary.RLIMIT_MEMLOCK, rlimit) == 0) {
import org.apache.lucene.util.Constants;
                            + "\t{} hard memlock unlimited",
        try {  
        } catch (UnsatisfiedLinkError e) {
     * @return the short path name (or the original path if getting the short path name fails for any reason)  
                    rlimitSuccess = true;
        try {
                return path;  
    static void tryInstallSystemCallFilter(Path tmpFile) {
            logger.warn("unable to install syscall filter: ", e);  
                logger.warn("unable to retrieve max size virtual memory [" + JNACLibrary.strerror(Native.getLastError()) + "]");
    static long MAX_NUMBER_OF_THREADS = -1;  
                logger.warn("Increase RLIMIT_MEMLOCK (ulimit).");  
import org.opensearch.monitor.jvm.JvmInfo;
            // Thus, we need to first increase the working set size of the JVM by  
            // By default, Windows limits the number of pages that can be locked.
                    if (lockable) {  
    }  
            }
                    // give specific instructions for the linux case to make it easy
class JNANatives {
            }
        } catch (Exception e) {  
                LOCAL_SYSTEM_CALL_FILTER_ALL = true;
        if (Constants.LINUX) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static boolean LOCAL_MLOCKALL = false;
            } else {
            } else {
                    softLimit = rlimit.rlim_cur.longValue();  
            if (!kernel.SetProcessWorkingSetSize(process, size, size)) {  
        logger.warn("This can result in part of the JVM being swapped out.");
    }
            if (JNACLibrary.getrlimit(JNACLibrary.RLIMIT_AS, rlimit) == 0) {
            // this is only valid on Linux and the value *is* different on OS X
            // see /usr/include/sys/resource.h on OS X
}  
                MAX_SIZE_VIRTUAL_MEMORY = rlimit.rlim_cur.longValue();
        assert Constants.WINDOWS;  
    static void addConsoleCtrlHandler(ConsoleCtrlHandler handler) {
                );
            // so we log stacktrace at debug for now...
            final WString longPath = new WString("\\\\?\\" + path);
            // the amount of memory we wish to lock, plus a small overhead (1MB).
        }
            // knowing the length of the buffer, now we get the short name
 *
        } catch (UnsatisfiedLinkError e) {  
 * license agreements. See the NOTICE file distributed with
                }
            return;
            } else {
    static boolean LOCAL_SYSTEM_CALL_FILTER = false;  
            final int length = JNAKernel32Library.getInstance().GetShortPathNameW(longPath, null, 0);
                        user,
                kernel.CloseHandle(process);  
            // first we get the length of the buffer needed  
        if (Constants.LINUX || Constants.MAC_OS_X) {
                    logger.warn("If you are logged in interactively, you will have to re-login for the new limits to take effect.");  
                    logger.warn("unknown error {} when adding console ctrl handler", Native.getLastError());  
    }  
    static long MAX_SIZE_VIRTUAL_MEMORY = Long.MIN_VALUE;
                }
            return false; // don't know
            return Long.toUnsignedString(value);
                            + "\t{} soft memlock unlimited\n"  
        }
            }
                LOCAL_MLOCKALL = true;  
                return;
            // on Linux the resource RLIMIT_NPROC means *the number of threads*  
            // this will have already been logged by CLibrary, no need to repeat it
                    rlimitToString(softLimit),  
        try {
            }
                JNACLibrary.Rlimit rlimit = new JNACLibrary.Rlimit();  
    }
 * SPDX-License-Identifier: Apache-2.0
            if (ret == 1) {  
                    hardLimit = rlimit.rlim_max.longValue();
/*  
            process = kernel.GetCurrentProcess();
            final int rlimit_nproc = 6;
    /** no instantiation */
        } catch (final UnsatisfiedLinkError e) {
                } else {
/*  
            }
                } else {
     * @param path the path
                        && (memInfo.Protect.longValue() & JNAKernel32Library.PAGE_GUARD) != JNAKernel32Library.PAGE_GUARD;
            }
        try {  
    // Set to true, in case native system call filter install was successful
 *
                logger.warn("unable to retrieve max file size [" + JNACLibrary.strerror(Native.getLastError()) + "]");  
        if (value == JNACLibrary.RLIM_INFINITY) {
            errMsg = JNACLibrary.strerror(errno);  
 * GitHub history for details.
            return "unlimited";
        try {
        }  
                // this will have already been logged by Kernel32Library, no need to repeat it  
        assert Constants.LINUX || Constants.MAC_OS_X;  
            }
 * this file be licensed under the Apache-2.0 license or a
            final JNACLibrary.Rlimit rlimit = new JNACLibrary.Rlimit();
            SizeT size = new SizeT(JvmInfo.jvmInfo().getMem().getHeapInit().getBytes() + (1024 * 1024));
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
                logger.warn("unable to retrieve max number of threads [" + JNACLibrary.strerror(Native.getLastError()) + "]");
            try {
        Pointer process = null;
            if (length == 0) {
        int errno = Integer.MIN_VALUE;
            }
    }
            return JNACLibrary.geteuid() == 0;
            // this will have already been logged by Kernel32Library, no need to repeat it  
                    logger.warn(  
        long softLimit = 0;
    // set to the maximum number of threads that can be created for
    // otherwise they are only inherited for new threads (OpenSearch app threads)
            int result = JNACLibrary.mlockall(JNACLibrary.MCL_CURRENT);
            }  
                long address = 0;
 * specific language governing permissions and limitations
            if (JNACLibrary.getrlimit(rlimit_nproc, rlimit) == 0) {
        if (Constants.LINUX || Constants.MAC_OS_X) {
import com.sun.jna.WString;  
    static long MAX_FILE_SIZE = Long.MIN_VALUE;
                if (result) {  
            if (rlimitSuccess) {  
    // the user ID that owns the running OpenSearch process
            } else {
            final char[] shortPath = new char[length];  
                }
                    address += memInfo.RegionSize.longValue();
            } catch (UnsatisfiedLinkError e) {
 */
        // The console Ctrl handler is necessary on Windows platforms only.
        }
                        "These can be adjusted by modifying /etc/security/limits.conf, for example: \n"
    static String rlimitToString(long value) {
import org.apache.logging.log4j.Logger;  
            errno = Native.getLastError();
                LOCAL_MLOCKALL = true;
        if (Constants.WINDOWS) {  
                    rlimitToString(hardLimit)
    static boolean LOCAL_SYSTEM_CALL_FILTER_ALL = false;  
 * @opensearch.internal  
            } else {  
                    logger.warn("Unable to retrieve resource limits: {}", JNACLibrary.strerror(Native.getLastError()));  
import org.apache.logging.log4j.LogManager;
 */  
    static boolean definitelyRunningAsRoot() {  
                logger.warn(
    }
        }
    static String getShortPathName(String path) {
import com.sun.jna.Pointer;
                boolean result = JNAKernel32Library.getInstance().addConsoleCtrlHandler(handler);
                    }
            if (JNAKernel32Library.getInstance().GetShortPathNameW(longPath, shortPath, length) > 0) {
        if (errno == JNACLibrary.ENOMEM) {
        JNAKernel32Library kernel = JNAKernel32Library.getInstance();
        logger.warn("Unable to lock JVM Memory: error={}, reason={}", errno, errMsg);  
            // this is likely to happen unless the kernel is newish, its a best effort at the moment
package org.opensearch.bootstrap;
    static void tryVirtualLock() {  
                logger.warn("failed to get short path name: {}", Native.getLastError());
 *
            final JNACLibrary.Rlimit rlimit = new JNACLibrary.Rlimit();  
    static void trySetMaxSizeVirtualMemory() {
        }
            }
                    logger.debug("console ctrl handler correctly set");
 */  
 * this work for additional information regarding copyright
                MAX_NUMBER_OF_THREADS = rlimit.rlim_cur.longValue();  
 * You may obtain a copy of the License at  
 * under the License.  
                logger.debug("unable to install syscall filter", e);
    }
            // this is in opposition to BSD-derived OSes
            }
        if (Constants.WINDOWS) {
                        user
 * software distributed under the License is distributed on an
                return path;
import com.sun.jna.Native;
        }  
    }  
        }
                    String user = System.getProperty("user.name");
                MAX_FILE_SIZE = rlimit.rlim_cur.longValue();
 * This class performs the actual work with JNA and library bindings to call native methods. It should only be used after  
import java.nio.file.Path;
    /**
 * Modifications Copyright OpenSearch Contributors. See
    static void trySetMaxFileSize() {  
                }
            }  
        } else {  
        // mlockall failed for some reason
            if (result == 0) {  
/*
 * not use this file except in compliance with the License.
        } finally {
                        kernel.VirtualLock(memInfo.BaseAddress, new SizeT(memInfo.RegionSize.longValue()));
            if (process != null) {
     * Retrieves the short path form of the specified path.  
     *
import static org.opensearch.bootstrap.JNAKernel32Library.SizeT;  
    // Set to true, in case native mlockall call was successful  
                logger.warn("Unable to lock JVM memory. Failed to set working set size. Error code {}", Native.getLastError());
                        && (memInfo.Protect.longValue() & JNAKernel32Library.PAGE_NOACCESS) != JNAKernel32Library.PAGE_NOACCESS
                    );
        } catch (UnsatisfiedLinkError e) {  
                while (kernel.VirtualQueryEx(process, new Pointer(address), memInfo, memInfo.size()) != 0) {
 * Unless required by applicable law or agreed to in writing,
        boolean rlimitSuccess = false;  
            return false;
                    // Move to the next region  
    }  
        }
                logger.warn("failed to get short path name: {}", Native.getLastError());  
    private JNANatives() {}
        long hardLimit = 0;
                if (Constants.LINUX) {  
        }  
            final JNACLibrary.Rlimit rlimit = new JNACLibrary.Rlimit();
 * KIND, either express or implied.  See the License for the
            return path;  
                return Native.toString(shortPath);  
    static void tryMlockall() {  
 *  
    static void trySetMaxNumberOfThreads() {
                    boolean lockable = memInfo.State.longValue() == JNAKernel32Library.MEM_COMMIT  
/**
    private static final Logger logger = LogManager.getLogger(JNANatives.class);
    /** Returns true if user is root, false if not, or if we don't know */
    // Set to true, in case policy can be applied to all threads of the process (even existing ones)
                    "Increase RLIMIT_MEMLOCK, soft limit: {}, hard limit: {}",
 * we are sure that the JNA classes are available to the JVM
                // we only know RLIMIT_MEMLOCK for these two at the moment.
        }
            if (JNACLibrary.getrlimit(JNACLibrary.RLIMIT_FSIZE, rlimit) == 0) {  
            }
            if (logger.isDebugEnabled()) {  
            // this will have already been logged by Kernel32Library, no need to repeat it
            LOCAL_SYSTEM_CALL_FILTER = true;
        String errMsg = null;
    }  
        }  
     */
            int ret = SystemCallFilter.init(tmpFile);
                JNAKernel32Library.MemoryBasicInformation memInfo = new JNAKernel32Library.MemoryBasicInformation();  
            if (Constants.LINUX || Constants.MAC_OS_X) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
            } else {
 * ownership. Elasticsearch licenses this file to you under  
                            + "\t# allow user '{}' mlockall\n"
                        user,  
 */
