    private static void macImpl(Path tmpFile) throws IOException {  
                        + ", prctl(PR_SET_SECCOMP): "  
            }  
    static final int PR_GET_NO_NEW_PRIVS = 39;   // since Linux 3.5  
            /* 2  */ BPF_JUMP(BPF_JMP + BPF_JEQ + BPF_K, arch.audit, 0, 7),                 // if (arch != audit) goto fail;
            PointerByReference errorRef = new PointerByReference();  
    static final int SECCOMP_RET_ERRNO = 0x00050000;  
        try {
        final int bogusArg = 0xf7a46a5c;  
    // windows impl via job ActiveProcessLimit
 * @see <a href="http://www.kernel.org/doc/Documentation/prctl/seccomp_filter.txt">
        }  
 * this file be licensed under the Apache-2.0 license or a
            }
 * security researchers and make their lives more difficult in achieving "remote execution" exploits.
        prog.write();
        }
    }
 *
            default:  
        byte jt;    // number of insn to jump (skip) if true  
                    throw new UnsupportedOperationException("seccomp(SECCOMP_SET_MODE_FILTER, BOGUS_FLAG): " + JNACLibrary.strerror(errno));  
    }
        // test prctl(BOGUS)
        Arch(int audit, int limit, int fork, int vfork, int execve, int execveat, int seccomp) {
import com.sun.jna.NativeLong;
            // if sandbox_init() fails, add the message from the OS (e.g. syntax error) and free the buffer
    static final int PRIV_OFF = 1;
 */  
                lib = (SolarisLibrary) Native.loadLibrary("c", SolarisLibrary.class);
        } else {
            default:
                case EINVAL:
    // Solaris implementation via priv_set(3C)
     * Attempt to drop the capability to execute for the process.
    }
        m.put("amd64", new Arch(0xC000003E, 0x3FFFFFFF, 57, 58, 59, 322, 317));
        // check for SECCOMP  
 * denies the following rules:
        }
                "seccomp filter did not really succeed: prctl(PR_GET_NO_NEW_PRIVS): " + JNACLibrary.strerror(Native.getLastError())
    static {
            this.execveat = execveat;
    }
                    "seccomp(SECCOMP_SET_MODE_FILTER): "
import java.nio.ByteBuffer;  
        JNACLibrary.Rlimit limit = new JNACLibrary.Rlimit();  
 * {@code CONFIG_SECCOMP} and {@code CONFIG_SECCOMP_FILTER} compiled into the kernel.
 * which will at least protect opensearch application threads.  
            } catch (UnsatisfiedLinkError e) {  
import com.sun.jna.Library;
        if (supported == false) {
        final Arch arch = ARCHITECTURES.get(Constants.OS_ARCH);
                    throw new UnsupportedOperationException(
 *
    }
            int errno1 = Native.getLastError();  
        // test seccomp(BOGUS)
 * On Windows, process creation is restricted with {@code SetInformationJobObject/ActiveProcessLimit}.
            throw new UnsupportedOperationException(
    // BPF "macros" and constants
            this.vfork = vfork;
            switch (errno) {
    private static int linuxImpl() {
    // see privileges(5) for complete list of these  
                default:
 *  
    static final class SockFilter {
    interface LinuxLibrary extends Library {  
        }
                throw e;
    }
     */  
package org.opensearch.bootstrap;
        // BPF installed to check arch, limit, then syscall.  
            return 1;
import java.nio.file.Files;
    // null if unavailable, or something goes wrong.  
    static final int BPF_K = 0x00;
            throw new UnsupportedOperationException("seatbelt unavailable: could not link methods. requires Leopard or above.");  
            /* 1  */ BPF_STMT(BPF_LD + BPF_W + BPF_ABS, SECCOMP_DATA_ARCH_OFFSET),             //  
                default:  
 * is preferred, as it allows filters to be applied to any existing threads in the process, and one motivation
            if (ret != 0) {  
                break; // already set by caller  
        protected List<String> getFieldOrder() {  
        if (supported == false) {
        JNAKernel32Library lib = JNAKernel32Library.getInstance();
        boolean success = false;
 * On Linux it currently supports amd64 and i386 architectures, requires Linux kernel 3.5 or above, and requires  
            try {
import org.apache.logging.log4j.LogManager;  
 * @see <a href="https://docs.oracle.com/cd/E23824_01/html/821-1456/prbac-2.html">  
        long pointer = Pointer.nativeValue(prog.getPointer());
    /** try to install our BPF filters via seccomp() or prctl() to block execution */
            this.k = k;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        logger.debug("Windows ActiveProcessLimit initialization successful");
 * <p>  
    }  
                    throw new UnsupportedOperationException("prctl(PR_GET_SECCOMP): " + JNACLibrary.strerror(errno));
            this.execve = execve;  
    static final int ENOSYS = 0x26;
        long ret = linux_syscall(arch.seccomp, bogusArg);  
        boolean supported = Constants.SUN_OS;  
    }
        public Pointer filter;        // filters  
    static final int EFAULT = 0x0E;  
    static final boolean OPENBSD = Constants.OS_NAME.startsWith("OpenBSD");
        }
                "seccomp filter installation did not really succeed. seccomp(PR_GET_SECCOMP): "  
    static void solarisImpl() {
import com.sun.jna.Structure;  
    }
    static final int RLIMIT_NPROC = 7;
        if (job == null) {  
    // OS X implementation via sandbox(7)  
        if (ret != -1) {
    /** invokes syscall() from linux libc library */
    // TODO: add OpenBSD to Lucene Constants
                        "seccomp unavailable: CONFIG_SECCOMP_FILTER not"
    interface SolarisLibrary extends Library {
    }
                    );  
 * On Mac OS X Leopard or above, a custom {@code sandbox(7)} ("Seatbelt") profile is installed that  
    /** Allow everything except process fork and execution */
            }  
        SockFProg(SockFilter filters[]) {
                bbuf.putInt(f.k);  
                        + JNACLibrary.strerror(errno1)
                );
    }
}
                bbuf.putShort(f.code);  
            /* 10 */ BPF_STMT(BPF_RET + BPF_K, SECCOMP_RET_ERRNO | (EACCES & SECCOMP_RET_DATA)),  // fail: return EACCES;  
    // null if unavailable, or something goes wrong.  
 *      http://www.kernel.org/doc/Documentation/prctl/seccomp_filter.txt</a>  
        // we couldn't link methods, could be some really ancient Solaris or some bug
        // first try it with seccomp(SECCOMP_SET_MODE_FILTER), falling back to prctl()  
        // now check that the filter was really installed, we should be in filter mode.  
        } else if (Constants.SUN_OS) {  
    static final int EINVAL = 0x16;
    private static final Logger logger = LogManager.getLogger(SystemCallFilter.class);
                            + " compiled into kernel, CONFIG_SECCOMP and CONFIG_SECCOMP_FILTER are needed"
        int priv_set(int op, String which, String... privs);  
                logger.warn("unable to link C library. native methods (seccomp) will be disabled.", e);
 */
        return method;  
                throw new UnsupportedOperationException("QueryInformationJobObject: " + Native.getLastError());
            bbuf.order(ByteOrder.nativeOrder()); // little endian
        }
                case ENOSYS:  
                bbuf.put(f.jt);
        if (libc_mac == null) {
        // create a new Job
        }
        /** syscall limit (necessary for denylisting on amd64, to ban 32-bit syscalls) */  
        Path rules = Files.createTempFile(tmpFile, "es", "sb");
/*  
            ByteBuffer bbuf = filter.getByteBuffer(0, len * 8);  
            if (success) {  
 * specific language governing permissions and limitations
        if (Constants.LINUX) {  
                    throw new UnsupportedOperationException("prctl(PR_GET_NO_NEW_PRIVS): " + JNACLibrary.strerror(errno));  
        logger.debug("Solaris priv_set initialization successful");  
                "seccomp unavailable: could not link methods. requires kernel 3.5+ "
            solarisImpl();
import java.util.List;
import java.nio.ByteOrder;
    static final int SECCOMP_RET_ALLOW = 0x7FFF0000;
 *   <li>{@code execveat}</li>
import org.opensearch.common.util.io.IOUtils;  
        if (libc_solaris.priv_set(PRIV_OFF, PRIV_ALLSETS, PRIV_PROC_FORK, PRIV_PROC_EXEC, null) != 0) {
        LinuxLibrary lib = null;
        // seccomp takes a long, so we pass it one explicitly to keep the JNA simple
                } else {
        }
 * the Apache License, Version 2.0 (the "License"); you may
 * <ul>
        /**
 *      https://reverse.put.as/wp-content/uploads/2011/06/The-Apple-Sandbox-BHDC2011-Paper.pdf</a>
import com.sun.jna.ptr.PointerByReference;
        final int execveat;  
        // drop a null-terminated list of privileges
import com.sun.jna.Memory;
        int sandbox_init(String profile, long flags, PointerByReference errorbuf);
            if (linux_prctl(PR_SET_SECCOMP, SECCOMP_MODE_FILTER, pointer, 0, 0) != 0) {
        return new SockFilter((short) code, (byte) 0, (byte) 0, k);
    static final int BPF_JEQ = 0x10;
    interface MacLibrary extends Library {  
            len = (short) filters.length;  
import org.apache.lucene.util.Constants;
                lib = (MacLibrary) Native.loadLibrary("c", MacLibrary.class);
// not an example of how to write code!!!
        }  
        }
            case 0:  
                if (errno == EINVAL) {  
        }  
        // check for SECCOMP_MODE_FILTER
        Files.write(rules, Collections.singleton(SANDBOX_RULES));
    }
    static final int BPF_JGE = 0x30;
 * Unless required by applicable law or agreed to in writing,
                    "seccomp(SECCOMP_SET_MODE_FILTER): {}, falling back to prctl(PR_SET_SECCOMP)...",  
            }
        SockFilter insns[] = {
 *   <li>{@code fork}</li>
        libc_solaris = lib;  
            lib.CloseHandle(job);
        limit.rlim_cur.setValue(0);
    // constants for priv_set(2)  
                if (errno == EINVAL) {
                throw new UnsupportedOperationException(  
        int k;      // additional data
    static final int BPF_ABS = 0x20;
 * The OpenSearch Contributors require contributions made to  
            macImpl(tmpFile);
        // try to check system calls really are who they claim
            int errno = Native.getLastError();  
                        + JNACLibrary.strerror(errno2)
    static final String PRIV_PROC_FORK = "proc_fork";
        if (libc_solaris == null) {  
        if (linux_prctl(PR_GET_NO_NEW_PRIVS, 0, 0, 0, 0) != 1) {  
            } else {
 * You may obtain a copy of the License at  
        MacLibrary lib = null;
        // ok, now set PR_SET_NO_NEW_PRIVS, needed to be able to set a seccomp filter as ordinary user  
            throw new IllegalStateException("bug: should not be trying to initialize seatbelt for an unsupported OS");
        Map<String, Arch> m = new HashMap<>();  
        return new SockFilter((short) code, (byte) jt, (byte) jf, k);  
        boolean supported = Constants.LINUX && arch != null;  
    static final int BPF_RET = 0x06;
 * <p>
        }
        }
        if (linux_prctl(PR_SET_NO_NEW_PRIVS, 1, 0, 0, 0) != 0) {
                        "seccomp unavailable: requires kernel 3.5+ with" + " CONFIG_SECCOMP and CONFIG_SECCOMP_FILTER compiled in"  
            /* 6  */ BPF_JUMP(BPF_JMP + BPF_JEQ + BPF_K, arch.vfork, 3, 0),                 // if (syscall == VFORK) goto fail;
    /** try to install our custom rule profile into sandbox_init() to block execution */
    // null if unavailable or something goes wrong.
        libc_mac = lib;  
         * maps to sandbox_init(3), since Leopard
        // first be defensive: we can give nice errors this way, at the very least.  
            throw new UnsupportedOperationException("seccomp unavailable: prctl(BOGUS_OPTION) returned " + ret);
    }
    private static final LinuxLibrary linux_libc;
            this.seccomp = seccomp;
         */  
    static void windowsImpl() {  
        }
        logger.debug("BSD RLIMIT_NPROC initialization successful");
        /** __NR_vfork */
                    );  
                throw new UnsupportedOperationException("SetInformationJobObject: " + Native.getLastError());  
    }
        }
                    throw new UnsupportedOperationException("seccomp(BOGUS_OPERATION): " + JNACLibrary.strerror(errno));
 * <p>  
            this.filter = filter;
        public short len;           // number of filters
                RuntimeException e = new UnsupportedOperationException("sandbox_init(): " + errorBuf.getString(0));
        }
        /**  
        if (Constants.MAC_OS_X) {
            for (SockFilter f : filters) {
                case EINVAL:  
 * <p>  
            try {  
            throw new UnsupportedOperationException("priv_set unavailable: priv_set(): " + JNACLibrary.strerror(Native.getLastError()));  
                    JNACLibrary.strerror(errno1)
        // write rules to a temporary file, which will be passed to sandbox_init()  
        } else if (Constants.WINDOWS) {  
         * maps to prctl(2)
/*  
            throw new UnsupportedOperationException("seccomp unavailable: '" + Constants.OS_ARCH + "' architecture unsupported");
            windowsImpl();
 * Modifications Copyright OpenSearch Contributors. See
 * <p>
            method = 0;
            int errno = Native.getLastError();
            }
                break; // not yet set  
                logger.debug(
 * <p>  
                Files.delete(rules);
    static final int BPF_W = 0x00;
    /** Access to non-standard Solaris libc methods */
            this.audit = audit;
        }
    }  
                case EINVAL:
 *   <li>{@code process-fork}</li>  
                    throw new UnsupportedOperationException("prctl(PR_SET_SECCOMP): " + JNACLibrary.strerror(errno));
    private static int linux_prctl(int option, long arg2, long arg3, long arg4, long arg5) {
    static final int PR_SET_NO_NEW_PRIVS = 38;   // since Linux 3.5
    static {  
            throw new UnsupportedOperationException(
        try {
            throw new UnsupportedOperationException("priv_set unavailable: could not link methods. requires Solaris 10+");
            this.limit = limit;  
        // now just normal defensive checks
                case EFAULT:  
    static final int SECCOMP_FILTER_FLAG_TSYNC = 1;   // since Linux 3.17  
                default:
     * <p>  
            throw new IllegalStateException("bug: should not be trying to initialize ActiveProcessLimit for an unsupported OS");
        boolean supported = Constants.MAC_OS_X;
        final int execve;
                int errno2 = Native.getLastError();
            throw new UnsupportedOperationException("CreateJobObject: " + Native.getLastError());
        final int fork;  
                );
    static final String PRIV_PROC_EXEC = "proc_exec";
            }
        if (linux_prctl(PR_GET_SECCOMP, 0, 0, 0, 0) != 2) {
        /** AUDIT_ARCH_XXX constant from linux/audit.h */
            /* 5  */ BPF_JUMP(BPF_JMP + BPF_JEQ + BPF_K, arch.fork, 4, 0),                 // if (syscall == FORK) goto fail;
                int errno = Native.getLastError();
import java.util.Arrays;
            limits.LimitFlags = JNAKernel32Library.JOB_OBJECT_LIMIT_ACTIVE_PROCESS;  
            /* 9  */ BPF_STMT(BPF_RET + BPF_K, SECCOMP_RET_ALLOW),                                // pass: return OK;
            return 1;
        }
                case ENOSYS:
    static final int PR_GET_SECCOMP = 21;   // since Linux 2.6.23
            // try to enable both mechanisms if possible
        /**  
 * </ul>
import java.nio.file.Path;  
 * compatible open source license.
            this.jt = jt;  
    static SockFilter BPF_JUMP(int code, int k, int jt, int jf) {
                        "seccomp unavailable: CONFIG_SECCOMP not compiled into kernel,"
    }  
            // retrieve the current basic limits of the job
         */
    private static final SolarisLibrary libc_solaris;
/*
    /** otherwise, we can use prctl(2), which will at least protect OpenSearch application threads */
            /* 8  */ BPF_JUMP(BPF_JMP + BPF_JEQ + BPF_K, arch.execveat, 1, 0),                 // if (syscall == EXECVEAT) goto fail;
    /** supported architectures map keyed by os.arch */  
 *   <li>{@code vfork}</li>  
import com.sun.jna.Pointer;
    static final int SECCOMP_DATA_ARCH_OFFSET = 0x04;
        byte jf;    // number of insn to jump (skip) if false
        final int vfork;
        ret = linux_prctl(bogusArg, 0, 0, 0, 0);
            logger.debug("OS X seatbelt initialization successful");  
 * GitHub history for details.
        } else {
                    break; // ok  
            throw new UnsupportedOperationException("RLIMIT_NPROC unavailable: " + JNACLibrary.strerror(Native.getLastError()));
        ret = linux_syscall(arch.seccomp, SECCOMP_SET_MODE_FILTER, bogusArg);
            throw new IllegalStateException("bug: should not be trying to initialize RLIMIT_NPROC for an unsupported OS");  
        // check for GET_NO_NEW_PRIVS
            }
        }  
            bsdImpl();  
    // Linux implementation, based on seccomp(2) or prctl(2) with bpf filtering  
 */
        if (linux_prctl(PR_SET_SECCOMP, SECCOMP_MODE_FILTER, 0, 0, 0) != 0) {  
                Pointer errorBuf = errorRef.getValue();
import java.util.Collections;
        void sandbox_free_error(Pointer errorbuf);  
        } finally {
import org.apache.logging.log4j.Logger;
        /**  __NR_execveat */
 *   <li>{@code PRIV_PROC_EXEC}</li>
        }  
    // TODO: JNA doesn't have netbsd support, but this mechanism should work there too.  
        switch (linux_prctl(PR_GET_SECCOMP, 0, 0, 0, 0)) {
                default:
    /** Access to non-standard Linux libc methods */
 * </ul>
 * <ul>  
    private static final Map<String, Arch> ARCHITECTURES;
    }  
        int prctl(int option, NativeLong arg2, NativeLong arg3, NativeLong arg4, NativeLong arg5);
            return Arrays.asList("len", "filter");
            case 2:
            if (!lib.QueryInformationJobObject(job, clazz, limits.getPointer(), limits.size(), null)) {  
        final int seccomp;
                    break; // ok
        short code; // insn
 * ownership. Elasticsearch licenses this file to you under  
 * On Linux BPF Filters are installed using either {@code seccomp(2)} (3.17+) or {@code prctl(2)} (3.5+). {@code seccomp(2)}  
            /* 7  */ BPF_JUMP(BPF_JMP + BPF_JEQ + BPF_K, arch.execve, 2, 0),                 // if (syscall == EXECVE) goto fail;  
            case 0:
    }  
                logger.warn("unable to link C library. native methods (priv_set) will be disabled.", e);  
        // you never know (e.g. https://chromium.googlesource.com/chromium/src.git/+/master/sandbox/linux/seccomp-bpf/sandbox_bpf.cc#57)
            switch (errno) {
                throw new UnsupportedOperationException("AssignProcessToJobObject: " + Native.getLastError());
        /**
    private static long linux_syscall(long number, Object... args) {  
                    break; // available
import java.util.HashMap;  
import java.io.IOException;
         */  
 * Linux BPF filters will return {@code EACCES} (Access Denied) for the following system calls:
            limits.write();
            this.jf = jf;
                            + " CONFIG_SECCOMP and CONFIG_SECCOMP_FILTER are needed"
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        SockFProg prog = new SockFProg(insns);  
                    throw new UnsupportedOperationException(  
            }
            return linuxImpl();  
 * software distributed under the License is distributed on an
            }
            switch (errno) {
    // some errno constants for error checking/handling
        }
 * On Solaris 10 or higher, the following privileges are dropped with {@code priv_set(3C)}:
                int errno = Native.getLastError();
 *
            success = true;
            this.code = code;
 * SPDX-License-Identifier: Apache-2.0
    /** the preferred method is seccomp(2), since we can apply to all threads of the process */
        @Override
                break; // already in filter mode by caller
        if (ret != -1) {  
            throw new UnsupportedOperationException("seccomp unavailable: seccomp(SECCOMP_SET_MODE_FILTER, BOGUS_FLAG) returned " + ret);  
        if (linux_syscall(arch.seccomp, SECCOMP_SET_MODE_FILTER, SECCOMP_FILTER_FLAG_TSYNC, new NativeLong(pointer)) != 0) {
        }
                    // friendly error, this will be the typical case for an old kernel
            );
import java.util.Map;
            if (!lib.SetInformationJobObject(job, clazz, limits.getPointer(), limits.size())) {
            if (!lib.AssignProcessToJobObject(job, lib.GetCurrentProcess())) {  
 * KIND, either express or implied.  See the License for the
    static final int BPF_JMP = 0x05;  
 *      https://docs.oracle.com/cd/E23824_01/html/821-1456/prbac-2.html</a>
            limits.read();  
     * @return 0 if we can do this for application threads, 1 for the entire process
        /**  
         */
                    break; // ok  
            /* 3  */ BPF_STMT(BPF_LD + BPF_W + BPF_ABS, SECCOMP_DATA_NR_OFFSET),               //
        // first be defensive: we can give nice errors this way, at the very least.
    static final int PR_SET_SECCOMP = 22;   // since Linux 2.6.23  
 */  
 * </ul>
        }  
        m.put("aarch64", new Arch(0xC00000B7, 0xFFFFFFFF, 1079, 1071, 221, 281, 277));
                bbuf.put(f.jf);
 * <p>
    }
                } else {
                    break; // ok
        if (supported == false) {  
        final int audit;
            throw new IllegalStateException("bug: should not be trying to initialize priv_set for an unsupported OS");
 * This is supported on Linux, Solaris, FreeBSD, OpenBSD, Mac OS X, and Windows.
                logger.warn("unable to link C library. native methods (seatbelt) will be disabled.", e);  
        } else if (Constants.MAC_OS_X) {
 *   <li>{@code process-exec}</li>
 * <p>
        linux_libc = lib;
                libc_mac.sandbox_free_error(errorBuf);  
            int errno = Native.getLastError();
        SockFilter(short code, byte jt, byte jf, int k) {
        if (Constants.LINUX) {
            );  
    private static final MacLibrary libc_mac;
        m.put("riscv64", new Arch(0xC00000F3, 0xFFFFFFFF, 1079, 1071, 221, 281, 277));
            } catch (UnsatisfiedLinkError e) {
            );
            }  
 * On BSD systems, process creation is restricted with {@code setrlimit(RLIMIT_NPROC)}.
            case 1:
            int clazz = JNAKernel32Library.JOBOBJECT_BASIC_LIMIT_INFORMATION_CLASS;  
        switch (linux_prctl(PR_GET_NO_NEW_PRIVS, 0, 0, 0, 0)) {
                IOUtils.deleteFilesIgnoringExceptions(rules);  
        if (linux_libc == null) {  
        boolean supported = Constants.FREE_BSD || OPENBSD || Constants.MAC_OS_X;
        }
        }  
    static int init(Path tmpFile) throws Exception {
 * @see <a href="https://reverse.put.as/wp-content/uploads/2011/06/The-Apple-Sandbox-BHDC2011-Paper.pdf">
            throw new UnsupportedOperationException("syscall filtering not supported for OS: '" + Constants.OS_NAME + "'");
         */  
            return 1;
 * This is not intended as a sandbox. It is another level of security, mostly intended to annoy  
            int ret = libc_mac.sandbox_init(rules.toAbsolutePath().toString(), SANDBOX_NAMED, errorRef);
     * This is best effort and OS and architecture dependent. It may throw any Throwable.
    static SockFilter BPF_STMT(int code, int k) {
                    );
 * Licensed to Elasticsearch under one or more contributor  
        }
        };
        } else if (Constants.FREE_BSD || OPENBSD) {  
        Pointer job = lib.CreateJobObjectW(null, null);
    /** corresponds to struct sock_fprog */  
        // test seccomp(VALID, BOGUS)  
            }
    // not a standard limit, means something different on linux, etc!  
    static final long SECCOMP_MODE_FILTER = 2;   // since Linux Linux 3.5
            try {  
 * under the License.  
            }
                    + JNACLibrary.strerror(Native.getLastError())
    /**
            throw new UnsupportedOperationException("prctl(PR_SET_NO_NEW_PRIVS): " + JNACLibrary.strerror(Native.getLastError()));
        // first be defensive: we can give nice errors this way, at the very least.
        /** __NR_execve */  
    // offsets that our BPF checks
import com.sun.jna.Native;  
            }
            // assign ourselves to the job
        }
 *   <li>{@code execve}</li>
        }  
        } else {  
        final int limit;
    static final int SECCOMP_SET_MODE_FILTER = 1;   // since Linux 3.17
                break; // not yet set
        m.put("s390x", new Arch(0x80000016, 0xFFFFFFFF, 2, 190, 11, 354, 348));  
         * see priv_set(3C), a convenience method for setppriv(2).
                }  
            return 1;
            limits.write();
    static final int SANDBOX_NAMED = 1;
        if (Constants.SUN_OS) {
        } finally {  
            throw new UnsupportedOperationException("seccomp unavailable: seccomp(BOGUS_OPERATION) returned " + ret);
        // check it worked
                    + "with CONFIG_SECCOMP and CONFIG_SECCOMP_FILTER compiled in"  
        NativeLong syscall(NativeLong number, Object... args);
                lib = (LinuxLibrary) Native.loadLibrary("c", LinuxLibrary.class);
        // install filter, if this works, after this there is no going back!
final class SystemCallFilter {  
    static {
    static {  
        m.put("ppc64le", new Arch(0xC0000015, 0xFFFFFFFF, 2, 189, 11, 362, 358));
            int errno = Native.getLastError();
                case EINVAL:
        // also, some of these security features get backported to old versions, checking kernel version here is a big no-no!
    static void bsdImpl() {  
    }
            this.fork = fork;
    static final String PRIV_ALLSETS = null;
    static final int SECCOMP_RET_DATA = 0x0000FFFF;
            bsdImpl();
        } else {  
        // we couldn't link methods, could be some really ancient OS X (< Leopard) or some bug
         * this is the only way, DON'T use it on some other architecture unless you know wtf you are doing
            JNAKernel32Library.JOBOBJECT_BASIC_LIMIT_INFORMATION limits = new JNAKernel32Library.JOBOBJECT_BASIC_LIMIT_INFORMATION();
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (!Constants.WINDOWS) {
            }  
 * this work for additional information regarding copyright
                case ENOSYS:
        // we couldn't link methods, could be some really ancient kernel (e.g. < 2.1.57) or some bug
            // serialize struct sock_filter * explicitly, its less confusing than the JNA magic we would need
    public static final class SockFProg extends Structure implements Structure.ByReference {
    static final int BPF_LD = 0x00;  
                    break; // ok
    static final int BPF_JGT = 0x20;  
        }
        }  
            Memory filter = new Memory(len * 8);
        limit.rlim_max.setValue(0);
        /** __NR_seccomp */
                    throw new UnsupportedOperationException("prctl(BOGUS_OPTION): " + JNACLibrary.strerror(errno));
            }
 * @opensearch.internal  
    // check with offsetof() when adding a new arch, move to Arch if different.
        ARCHITECTURES = Collections.unmodifiableMap(m);  
        if (supported == false) {
        SolarisLibrary lib = null;
            if (logger.isDebugEnabled()) {
    static final int EACCES = 0x0D;
    // BSD implementation via setrlimit(2)  
 *   <li>{@code PRIV_PROC_FORK}</li>  
         * used to call seccomp(2), its too new...
 * <p>
    static final int SECCOMP_DATA_NR_OFFSET = 0x00;  
            limits.ActiveProcessLimit = 1;
                    break; // ok
 * <ul>
    /** Access to non-standard OS X libc methods */
        return linux_libc.syscall(new NativeLong(number), args).longValue();
    /** corresponds to struct sock_filter */  
    /** The only supported flag... */  
 * here is to protect against bugs in the JVM. Otherwise, code will fall back to the {@code prctl(2)} method
 * Installs a system call filter to block process execution.
        }  
            // modify the number of active processes to be 1 (exactly the one process we will add to the job).
        // See https://www.kernel.org/doc/Documentation/prctl/seccomp_filter.txt for details.
        int method = 1;
    static class Arch {  
            switch (errno) {  
    /** invokes prctl() from linux libc library */  
/**
        if (JNACLibrary.setrlimit(RLIMIT_NPROC, limit) != 0) {  
                    throw new UnsupportedOperationException(  
        return linux_libc.prctl(option, new NativeLong(arg2), new NativeLong(arg3), new NativeLong(arg4), new NativeLong(arg5));
        logger.debug("Linux seccomp filter installation successful, threads: [{}]", method == 1 ? "all" : "app");
            throw new UnsupportedOperationException(
                }
            } catch (UnsatisfiedLinkError e) {
        if (ret != -1) {
        /** __NR_fork */
            /* 4  */ BPF_JUMP(BPF_JMP + BPF_JGT + BPF_K, arch.limit, 5, 0),                 // if (syscall > LIMIT) goto fail;  
         * releases memory when an error occurs during initialization (e.g. syntax bug)
    static final String SANDBOX_RULES = "(version 1) (allow default) (deny process-fork) (deny process-exec)";  
