         */
        }
                    "seccomp(SECCOMP_SET_MODE_FILTER): "
    }
        Files.write(rules, Collections.singleton(SANDBOX_RULES));
 *
                    throw new UnsupportedOperationException("prctl(PR_SET_SECCOMP): " + JNACLibrary.strerror(errno));
            bbuf.order(ByteOrder.nativeOrder()); // little endian
/*
                    throw new UnsupportedOperationException("seccomp(BOGUS_OPERATION): " + JNACLibrary.strerror(errno));
            case 0:
            switch (errno) {
 * KIND, either express or implied.  See the License for the
        @Override
    static final int EINVAL = 0x16;
                case EINVAL:
    /** Allow everything except process fork and execution */
 * the Apache License, Version 2.0 (the "License"); you may
    static final int SECCOMP_FILTER_FLAG_TSYNC = 1;   // since Linux 3.17
                    break; // ok
import java.nio.file.Files;
 *
        if (JNACLibrary.setrlimit(RLIMIT_NPROC, limit) != 0) {
        if (Constants.LINUX) {
        Pointer job = lib.CreateJobObjectW(null, null);
            int errno = Native.getLastError();
     * @return 0 if we can do this for application threads, 1 for the entire process
            }
         */
 * <p>
                    );
    // BPF "macros" and constants
        }
        final Arch arch = ARCHITECTURES.get(Constants.OS_ARCH);
            return linuxImpl();
         * maps to prctl(2)
        /** __NR_fork */
        m.put("ppc64le", new Arch(0xC0000015, 0xFFFFFFFF, 2, 189, 11, 362, 358));
    // TODO: add OpenBSD to Lucene Constants
import java.util.Collections;
    /** supported architectures map keyed by os.arch */
        long pointer = Pointer.nativeValue(prog.getPointer());
        if (libc_solaris == null) {
        } else {
    static final int BPF_W = 0x00;
    static {
            throw new IllegalStateException("bug: should not be trying to initialize priv_set for an unsupported OS");
    static final int BPF_JEQ = 0x10;
        }
package org.opensearch.bootstrap;
        switch (linux_prctl(PR_GET_NO_NEW_PRIVS, 0, 0, 0, 0)) {
                int errno = Native.getLastError();
 *   <li>{@code PRIV_PROC_FORK}</li>
        byte jf;    // number of insn to jump (skip) if false
                    throw new UnsupportedOperationException("prctl(BOGUS_OPTION): " + JNACLibrary.strerror(errno));
            logger.debug("OS X seatbelt initialization successful");
                    throw new UnsupportedOperationException("seccomp(SECCOMP_SET_MODE_FILTER, BOGUS_FLAG): " + JNACLibrary.strerror(errno));
            len = (short) filters.length;
            case 1:
    /**
         */
        boolean success = false;
 * this file be licensed under the Apache-2.0 license or a
                    + "with CONFIG_SECCOMP and CONFIG_SECCOMP_FILTER compiled in"
                case EINVAL:
 * <ul>
        }
        final int audit;
        final int bogusArg = 0xf7a46a5c;
            this.audit = audit;
        limit.rlim_max.setValue(0);
        if (supported == false) {
        }
        // first try it with seccomp(SECCOMP_SET_MODE_FILTER), falling back to prctl()
                case EINVAL:
import java.nio.ByteOrder;
            this.jt = jt;
 * <p>
 *   <li>{@code fork}</li>
 * which will at least protect opensearch application threads.
                    break; // ok
        SockFProg prog = new SockFProg(insns);
        if (supported == false) {
                    throw new UnsupportedOperationException("prctl(PR_GET_NO_NEW_PRIVS): " + JNACLibrary.strerror(errno));
    static final long SECCOMP_MODE_FILTER = 2;   // since Linux Linux 3.5
    static SockFilter BPF_JUMP(int code, int k, int jt, int jf) {
    static final int BPF_LD = 0x00;
 *   <li>{@code process-exec}</li>
            lib.CloseHandle(job);
            }
    // Solaris implementation via priv_set(3C)
        try {
            this.jf = jf;
                lib = (SolarisLibrary) Native.loadLibrary("c", SolarisLibrary.class);
            throw new UnsupportedOperationException("seatbelt unavailable: could not link methods. requires Leopard or above.");
                            + " compiled into kernel, CONFIG_SECCOMP and CONFIG_SECCOMP_FILTER are needed"
            // retrieve the current basic limits of the job
            /* 9  */ BPF_STMT(BPF_RET + BPF_K, SECCOMP_RET_ALLOW),                                // pass: return OK;
import org.opensearch.common.util.io.IOUtils;
            this.code = code;
            /* 10 */ BPF_STMT(BPF_RET + BPF_K, SECCOMP_RET_ERRNO | (EACCES & SECCOMP_RET_DATA)),  // fail: return EACCES;
            this.seccomp = seccomp;
        logger.debug("BSD RLIMIT_NPROC initialization successful");
    public static final class SockFProg extends Structure implements Structure.ByReference {
 *   <li>{@code PRIV_PROC_EXEC}</li>
            limits.write();
                Pointer errorBuf = errorRef.getValue();
        } else if (Constants.WINDOWS) {
    }
    static final int PRIV_OFF = 1;
                case ENOSYS:
 * You may obtain a copy of the License at
            success = true;
    /** try to install our BPF filters via seccomp() or prctl() to block execution */
                        + ", prctl(PR_SET_SECCOMP): "
    private static final LinuxLibrary linux_libc;
    }
        } else {
         * see priv_set(3C), a convenience method for setppriv(2).
 * On BSD systems, process creation is restricted with {@code setrlimit(RLIMIT_NPROC)}.
 * Linux BPF filters will return {@code EACCES} (Access Denied) for the following system calls:
 */
                bbuf.putInt(f.k);
 * </ul>
    // not a standard limit, means something different on linux, etc!
            bsdImpl();
    }
    interface MacLibrary extends Library {
                libc_mac.sandbox_free_error(errorBuf);
    }
    }
            /* 6  */ BPF_JUMP(BPF_JMP + BPF_JEQ + BPF_K, arch.vfork, 3, 0),                 // if (syscall == VFORK) goto fail;
                int errno2 = Native.getLastError();
        // create a new Job
                );
        return linux_libc.syscall(new NativeLong(number), args).longValue();
 * here is to protect against bugs in the JVM. Otherwise, code will fall back to the {@code prctl(2)} method
    // some errno constants for error checking/handling
            int errno = Native.getLastError();
 * denies the following rules:
            // modify the number of active processes to be 1 (exactly the one process we will add to the job).
        linux_libc = lib;
            method = 0;
                Files.delete(rules);
 * </ul>
import com.sun.jna.Library;
    static final int BPF_JGT = 0x20;
            this.execve = execve;
        libc_solaris = lib;
    }
 * </ul>
                );
        long ret = linux_syscall(arch.seccomp, bogusArg);
        }
import java.util.Arrays;
        /** AUDIT_ARCH_XXX constant from linux/audit.h */
            throw new IllegalStateException("bug: should not be trying to initialize seatbelt for an unsupported OS");
        final int fork;
 * Modifications Copyright OpenSearch Contributors. See
 *
                } else {
        if (Constants.SUN_OS) {
        m.put("amd64", new Arch(0xC000003E, 0x3FFFFFFF, 57, 58, 59, 322, 317));
        } else if (Constants.MAC_OS_X) {
        if (linux_prctl(PR_SET_SECCOMP, SECCOMP_MODE_FILTER, 0, 0, 0) != 0) {
        // See https://www.kernel.org/doc/Documentation/prctl/seccomp_filter.txt for details.
import com.sun.jna.NativeLong;
        }
    }
        // ok, now set PR_SET_NO_NEW_PRIVS, needed to be able to set a seccomp filter as ordinary user
import java.util.HashMap;
    static final int SECCOMP_SET_MODE_FILTER = 1;   // since Linux 3.17
            throw new UnsupportedOperationException(
                    );
    }
            } else {
        int method = 1;
    static void solarisImpl() {
         * releases memory when an error occurs during initialization (e.g. syntax bug)
            }
            JNAKernel32Library.JOBOBJECT_BASIC_LIMIT_INFORMATION limits = new JNAKernel32Library.JOBOBJECT_BASIC_LIMIT_INFORMATION();
        if (ret != -1) {
                } else {
 * On Mac OS X Leopard or above, a custom {@code sandbox(7)} ("Seatbelt") profile is installed that
    }
        try {
        short code; // insn
            /* 3  */ BPF_STMT(BPF_LD + BPF_W + BPF_ABS, SECCOMP_DATA_NR_OFFSET),               //
                throw new UnsupportedOperationException("QueryInformationJobObject: " + Native.getLastError());
        }
                    throw new UnsupportedOperationException("prctl(PR_GET_SECCOMP): " + JNACLibrary.strerror(errno));
            }
        // now check that the filter was really installed, we should be in filter mode.
            PointerByReference errorRef = new PointerByReference();
            }
 * this work for additional information regarding copyright
        return method;
 */
    static int init(Path tmpFile) throws Exception {
        protected List<String> getFieldOrder() {
            }
            } catch (UnsatisfiedLinkError e) {
    static final int SANDBOX_NAMED = 1;
        logger.debug("Linux seccomp filter installation successful, threads: [{}]", method == 1 ? "all" : "app");
            } catch (UnsatisfiedLinkError e) {
            throw new UnsupportedOperationException("priv_set unavailable: could not link methods. requires Solaris 10+");
                bbuf.putShort(f.code);
    }
         */
    static final int PR_GET_NO_NEW_PRIVS = 39;   // since Linux 3.5
        // test seccomp(BOGUS)
 *     http://www.apache.org/licenses/LICENSE-2.0
            throw new UnsupportedOperationException(
            throw new UnsupportedOperationException("RLIMIT_NPROC unavailable: " + JNACLibrary.strerror(Native.getLastError()));
            switch (errno) {
    static void windowsImpl() {
        // first be defensive: we can give nice errors this way, at the very least.
        if (Constants.LINUX) {
 *      http://www.kernel.org/doc/Documentation/prctl/seccomp_filter.txt</a>
                bbuf.put(f.jf);
    static final int SECCOMP_RET_ERRNO = 0x00050000;
    // Linux implementation, based on seccomp(2) or prctl(2) with bpf filtering
            }
        m.put("s390x", new Arch(0x80000016, 0xFFFFFFFF, 2, 190, 11, 354, 348));
    static class Arch {
        }
        }
 * The OpenSearch Contributors require contributions made to
            /* 8  */ BPF_JUMP(BPF_JMP + BPF_JEQ + BPF_K, arch.execveat, 1, 0),                 // if (syscall == EXECVEAT) goto fail;
        /** __NR_seccomp */
            return 1;
 * <ul>
 * SPDX-License-Identifier: Apache-2.0
            if (success) {
        limit.rlim_cur.setValue(0);
        JNAKernel32Library lib = JNAKernel32Library.getInstance();
        Path rules = Files.createTempFile(tmpFile, "es", "sb");
    }
        /**
        // check for GET_NO_NEW_PRIVS
            limits.LimitFlags = JNAKernel32Library.JOB_OBJECT_LIMIT_ACTIVE_PROCESS;
/**
 */
    static final boolean OPENBSD = Constants.OS_NAME.startsWith("OpenBSD");
    // TODO: JNA doesn't have netbsd support, but this mechanism should work there too.
    /** The only supported flag... */
        } else if (Constants.FREE_BSD || OPENBSD) {
            int ret = libc_mac.sandbox_init(rules.toAbsolutePath().toString(), SANDBOX_NAMED, errorRef);
            }
        final int seccomp;
 * under the License.
        ret = linux_syscall(arch.seccomp, SECCOMP_SET_MODE_FILTER, bogusArg);
    interface SolarisLibrary extends Library {
        if (ret != -1) {
        SockFilter(short code, byte jt, byte jf, int k) {
        // check for SECCOMP_MODE_FILTER
 * Unless required by applicable law or agreed to in writing,
 * @see <a href="https://reverse.put.as/wp-content/uploads/2011/06/The-Apple-Sandbox-BHDC2011-Paper.pdf">
        } else {
    private static final Logger logger = LogManager.getLogger(SystemCallFilter.class);
                        "seccomp unavailable: CONFIG_SECCOMP_FILTER not"
    static final int RLIMIT_NPROC = 7;
        /**  __NR_execveat */
import com.sun.jna.Memory;
            this.limit = limit;
        // BPF installed to check arch, limit, then syscall.
 *      https://docs.oracle.com/cd/E23824_01/html/821-1456/prbac-2.html</a>
        boolean supported = Constants.MAC_OS_X;
        /**
                        + JNACLibrary.strerror(errno2)
                bbuf.put(f.jt);
                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (!lib.SetInformationJobObject(job, clazz, limits.getPointer(), limits.size())) {
                "seccomp filter did not really succeed: prctl(PR_GET_NO_NEW_PRIVS): " + JNACLibrary.strerror(Native.getLastError())
        } else if (Constants.SUN_OS) {
        if (linux_prctl(PR_SET_NO_NEW_PRIVS, 1, 0, 0, 0) != 0) {
/*
    static final int PR_SET_NO_NEW_PRIVS = 38;   // since Linux 3.5
    /** the preferred method is seccomp(2), since we can apply to all threads of the process */
            default:
                throw new UnsupportedOperationException("SetInformationJobObject: " + Native.getLastError());
 * GitHub history for details.
            solarisImpl();
        } finally {
 *   <li>{@code vfork}</li>
        }
        if (job == null) {
                default:
        // seccomp takes a long, so we pass it one explicitly to keep the JNA simple
    static final int EACCES = 0x0D;
            );
import com.sun.jna.Pointer;
     */
            throw new UnsupportedOperationException("priv_set unavailable: priv_set(): " + JNACLibrary.strerror(Native.getLastError()));
    static final int BPF_JMP = 0x05;
        /** __NR_execve */
    static final int SECCOMP_RET_ALLOW = 0x7FFF0000;
            if (logger.isDebugEnabled()) {
            return 1;
        // drop a null-terminated list of privileges
        if (!Constants.WINDOWS) {
            switch (errno) {
        m.put("riscv64", new Arch(0xC00000F3, 0xFFFFFFFF, 1079, 1071, 221, 281, 277));
        } finally {
 * <p>
    private static void macImpl(Path tmpFile) throws IOException {
            for (SockFilter f : filters) {
    static {
            // try to enable both mechanisms if possible
                lib = (MacLibrary) Native.loadLibrary("c", MacLibrary.class);
    private static final Map<String, Arch> ARCHITECTURES;
                throw new UnsupportedOperationException("AssignProcessToJobObject: " + Native.getLastError());
                    );
         */
        ARCHITECTURES = Collections.unmodifiableMap(m);
    }
 * On Linux it currently supports amd64 and i386 architectures, requires Linux kernel 3.5 or above, and requires
                logger.warn("unable to link C library. native methods (seccomp) will be disabled.", e);
 * Installs a system call filter to block process execution.
        // try to check system calls really are who they claim
 * On Solaris 10 or higher, the following privileges are dropped with {@code priv_set(3C)}:
        // also, some of these security features get backported to old versions, checking kernel version here is a big no-no!
}
                default:
 * <p>
                break; // not yet set
                if (errno == EINVAL) {
        m.put("aarch64", new Arch(0xC00000B7, 0xFFFFFFFF, 1079, 1071, 221, 281, 277));
         * maps to sandbox_init(3), since Leopard
        // we couldn't link methods, could be some really ancient kernel (e.g. < 2.1.57) or some bug
    }
    static final int ENOSYS = 0x26;
 * license agreements. See the NOTICE file distributed with
        Arch(int audit, int limit, int fork, int vfork, int execve, int execveat, int seccomp) {
            this.k = k;
        }
        }
            return 1;
        }
            windowsImpl();
            macImpl(tmpFile);
                logger.warn("unable to link C library. native methods (seatbelt) will be disabled.", e);
            throw new UnsupportedOperationException("seccomp unavailable: seccomp(BOGUS_OPERATION) returned " + ret);
                    "seccomp(SECCOMP_SET_MODE_FILTER): {}, falling back to prctl(PR_SET_SECCOMP)...",
    static final int BPF_ABS = 0x20;
 *      https://reverse.put.as/wp-content/uploads/2011/06/The-Apple-Sandbox-BHDC2011-Paper.pdf</a>
            }
 * <p>
        }
        // we couldn't link methods, could be some really ancient Solaris or some bug
        LinuxLibrary lib = null;
        // check it worked
    // constants for priv_set(2)
        /**
        if (linux_prctl(PR_GET_SECCOMP, 0, 0, 0, 0) != 2) {
        public Pointer filter;        // filters
 * This is not intended as a sandbox. It is another level of security, mostly intended to annoy
            /* 1  */ BPF_STMT(BPF_LD + BPF_W + BPF_ABS, SECCOMP_DATA_ARCH_OFFSET),             //
        int sandbox_init(String profile, long flags, PointerByReference errorbuf);
        // test seccomp(VALID, BOGUS)
            throw new UnsupportedOperationException("syscall filtering not supported for OS: '" + Constants.OS_NAME + "'");
        }
        }
            limits.write();
                "seccomp filter installation did not really succeed. seccomp(PR_GET_SECCOMP): "
        void sandbox_free_error(Pointer errorbuf);
 * <p>
    // see privileges(5) for complete list of these
        if (linux_libc == null) {
            }
 * On Windows, process creation is restricted with {@code SetInformationJobObject/ActiveProcessLimit}.
 */
    static final int BPF_RET = 0x06;
 * <p>
        /**
        SolarisLibrary lib = null;
    private static final MacLibrary libc_mac;
        boolean supported = Constants.FREE_BSD || OPENBSD || Constants.MAC_OS_X;
            if (ret != 0) {
            int clazz = JNAKernel32Library.JOBOBJECT_BASIC_LIMIT_INFORMATION_CLASS;
    static final int PR_SET_SECCOMP = 22;   // since Linux 2.6.23
                RuntimeException e = new UnsupportedOperationException("sandbox_init(): " + errorBuf.getString(0));
        int priv_set(int op, String which, String... privs);
    }
            /* 2  */ BPF_JUMP(BPF_JMP + BPF_JEQ + BPF_K, arch.audit, 0, 7),                 // if (arch != audit) goto fail;
        SockFProg(SockFilter filters[]) {
        return new SockFilter((short) code, (byte) 0, (byte) 0, k);
        logger.debug("Solaris priv_set initialization successful");
    private static final SolarisLibrary libc_solaris;
    // OS X implementation via sandbox(7)
import org.apache.logging.log4j.LogManager;
         * used to call seccomp(2), its too new...
                    break; // available
        }
                        "seccomp unavailable: requires kernel 3.5+ with" + " CONFIG_SECCOMP and CONFIG_SECCOMP_FILTER compiled in"
            limits.ActiveProcessLimit = 1;
        int prctl(int option, NativeLong arg2, NativeLong arg3, NativeLong arg4, NativeLong arg5);
        }
    }
    static SockFilter BPF_STMT(int code, int k) {
                    JNACLibrary.strerror(errno1)
        }
    /** corresponds to struct sock_filter */
import com.sun.jna.ptr.PointerByReference;
 * @see <a href="https://docs.oracle.com/cd/E23824_01/html/821-1456/prbac-2.html">
            /* 4  */ BPF_JUMP(BPF_JMP + BPF_JGT + BPF_K, arch.limit, 5, 0),                 // if (syscall > LIMIT) goto fail;
import com.sun.jna.Structure;
        }
                default:
import java.io.IOException;
                    break; // ok
    // windows impl via job ActiveProcessLimit
 * is preferred, as it allows filters to be applied to any existing threads in the process, and one motivation
                int errno = Native.getLastError();
    /** invokes prctl() from linux libc library */
        }
            // if sandbox_init() fails, add the message from the OS (e.g. syntax error) and free the buffer
        final int execveat;
    static void bsdImpl() {
            int errno = Native.getLastError();
    /** invokes syscall() from linux libc library */
    // check with offsetof() when adding a new arch, move to Arch if different.
    }
 * @opensearch.internal
            throw new IllegalStateException("bug: should not be trying to initialize RLIMIT_NPROC for an unsupported OS");
            bsdImpl();
 * specific language governing permissions and limitations
                    break; // ok
                    throw new UnsupportedOperationException(
            limits.read();
                }
        switch (linux_prctl(PR_GET_SECCOMP, 0, 0, 0, 0)) {
        }
 * not use this file except in compliance with the License.
        prog.write();
            if (!lib.AssignProcessToJobObject(job, lib.GetCurrentProcess())) {
            /* 5  */ BPF_JUMP(BPF_JMP + BPF_JEQ + BPF_K, arch.fork, 4, 0),                 // if (syscall == FORK) goto fail;
        // first be defensive: we can give nice errors this way, at the very least.
            }
        // we couldn't link methods, could be some really ancient OS X (< Leopard) or some bug
            );
    // BSD implementation via setrlimit(2)
            throw new UnsupportedOperationException("seccomp unavailable: prctl(BOGUS_OPTION) returned " + ret);
     * Attempt to drop the capability to execute for the process.
            return 1;
                case EINVAL:
            }
                        + JNACLibrary.strerror(errno1)
        int k;      // additional data
 * <p>
    /** try to install our custom rule profile into sandbox_init() to block execution */
            case 0:
import java.nio.file.Path;
        }
    static {
    static final String SANDBOX_RULES = "(version 1) (allow default) (deny process-fork) (deny process-exec)";
            switch (errno) {
        libc_mac = lib;
     * <p>
        /** __NR_vfork */
 * security researchers and make their lives more difficult in achieving "remote execution" exploits.
 * Licensed to Elasticsearch under one or more contributor
        NativeLong syscall(NativeLong number, Object... args);
                throw new UnsupportedOperationException(
import java.nio.ByteBuffer;
        // first be defensive: we can give nice errors this way, at the very least.
    }
 * <ul>
    private static long linux_syscall(long number, Object... args) {
        final int execve;
 * This is supported on Linux, Solaris, FreeBSD, OpenBSD, Mac OS X, and Windows.
    static final int SECCOMP_RET_DATA = 0x0000FFFF;
            );
        }
                default:
    static final int BPF_K = 0x00;
        return new SockFilter((short) code, (byte) jt, (byte) jf, k);
 *
            this.vfork = vfork;
        }
                case ENOSYS:
            } catch (UnsatisfiedLinkError e) {
    }
                logger.warn("unable to link C library. native methods (priv_set) will be disabled.", e);
                throw e;
    static final String PRIV_PROC_EXEC = "proc_exec";
    private static int linuxImpl() {
            throw new UnsupportedOperationException("CreateJobObject: " + Native.getLastError());
                lib = (LinuxLibrary) Native.loadLibrary("c", LinuxLibrary.class);
import org.apache.logging.log4j.Logger;
// not an example of how to write code!!!
        // check for SECCOMP
    // null if unavailable or something goes wrong.
    /** Access to non-standard OS X libc methods */
        MacLibrary lib = null;
        }
                        "seccomp unavailable: CONFIG_SECCOMP not compiled into kernel,"
    static final class SockFilter {
        // you never know (e.g. https://chromium.googlesource.com/chromium/src.git/+/master/sandbox/linux/seccomp-bpf/sandbox_bpf.cc#57)
        }
import com.sun.jna.Native;
        }
        if (linux_syscall(arch.seccomp, SECCOMP_SET_MODE_FILTER, SECCOMP_FILTER_FLAG_TSYNC, new NativeLong(pointer)) != 0) {
            // assign ourselves to the job
        return linux_libc.prctl(option, new NativeLong(arg2), new NativeLong(arg3), new NativeLong(arg4), new NativeLong(arg5));
 *   <li>{@code process-fork}</li>
            this.fork = fork;
    private static int linux_prctl(int option, long arg2, long arg3, long arg4, long arg5) {
        Map<String, Arch> m = new HashMap<>();
        if (supported == false) {
        final int limit;
                logger.debug(
        // now just normal defensive checks
        /** syscall limit (necessary for denylisting on amd64, to ban 32-bit syscalls) */
        // test prctl(BOGUS)
            try {
 * @see <a href="http://www.kernel.org/doc/Documentation/prctl/seccomp_filter.txt">
                    throw new UnsupportedOperationException(
            // serialize struct sock_filter * explicitly, its less confusing than the JNA magic we would need
            if (linux_prctl(PR_SET_SECCOMP, SECCOMP_MODE_FILTER, pointer, 0, 0) != 0) {
            default:
        final int vfork;
 *   <li>{@code execveat}</li>
                IOUtils.deleteFilesIgnoringExceptions(rules);
    interface LinuxLibrary extends Library {
            throw new UnsupportedOperationException("prctl(PR_SET_NO_NEW_PRIVS): " + JNACLibrary.strerror(Native.getLastError()));
        if (libc_mac == null) {
        SockFilter insns[] = {
        JNACLibrary.Rlimit limit = new JNACLibrary.Rlimit();
    // offsets that our BPF checks
            }
    static final String PRIV_ALLSETS = null;
                    break; // ok
                    // friendly error, this will be the typical case for an old kernel
    /** Access to non-standard Linux libc methods */
                break; // already set by caller
        // install filter, if this works, after this there is no going back!
        byte jt;    // number of insn to jump (skip) if true
    // null if unavailable, or something goes wrong.
         * this is the only way, DON'T use it on some other architecture unless you know wtf you are doing
        boolean supported = Constants.LINUX && arch != null;
 *   <li>{@code execve}</li>
import java.util.Map;
            throw new UnsupportedOperationException("seccomp unavailable: '" + Constants.OS_ARCH + "' architecture unsupported");
                case ENOSYS:
 * software distributed under the License is distributed on an
            Memory filter = new Memory(len * 8);
    /** corresponds to struct sock_fprog */
            /* 7  */ BPF_JUMP(BPF_JMP + BPF_JEQ + BPF_K, arch.execve, 2, 0),                 // if (syscall == EXECVE) goto fail;
 * compatible open source license.
        if (Constants.MAC_OS_X) {
import java.util.List;
            ByteBuffer bbuf = filter.getByteBuffer(0, len * 8);
            }
        }
    // null if unavailable, or something goes wrong.
            int errno1 = Native.getLastError();
        if (libc_solaris.priv_set(PRIV_OFF, PRIV_ALLSETS, PRIV_PROC_FORK, PRIV_PROC_EXEC, null) != 0) {
        if (linux_prctl(PR_GET_NO_NEW_PRIVS, 0, 0, 0, 0) != 1) {
 * ownership. Elasticsearch licenses this file to you under
    static {
                            + " CONFIG_SECCOMP and CONFIG_SECCOMP_FILTER are needed"
            }
        if (supported == false) {
 * <p>
            try {
    static final int SECCOMP_DATA_ARCH_OFFSET = 0x04;
    }
        logger.debug("Windows ActiveProcessLimit initialization successful");
            return Arrays.asList("len", "filter");
            if (!lib.QueryInformationJobObject(job, clazz, limits.getPointer(), limits.size(), null)) {
        if (ret != -1) {
        };
        } else {
 * {@code CONFIG_SECCOMP} and {@code CONFIG_SECCOMP_FILTER} compiled into the kernel.
            throw new UnsupportedOperationException(
 * On Linux BPF Filters are installed using either {@code seccomp(2)} (3.17+) or {@code prctl(2)} (3.5+). {@code seccomp(2)}
            throw new IllegalStateException("bug: should not be trying to initialize ActiveProcessLimit for an unsupported OS");
                case EFAULT:
            this.filter = filter;
            int errno = Native.getLastError();
    static final int EFAULT = 0x0E;
                break; // already in filter mode by caller
    static final String PRIV_PROC_FORK = "proc_fork";
    static final int PR_GET_SECCOMP = 21;   // since Linux 2.6.23
                    throw new UnsupportedOperationException(
    /** Access to non-standard Solaris libc methods */
            case 2:
        // write rules to a temporary file, which will be passed to sandbox_init()
    static final int SECCOMP_DATA_NR_OFFSET = 0x00;
        public short len;           // number of filters
        }
    static final int BPF_JGE = 0x30;
                break; // not yet set
                    + JNACLibrary.strerror(Native.getLastError())
        /**
final class SystemCallFilter {
            try {
                    break; // ok
import org.apache.lucene.util.Constants;
                "seccomp unavailable: could not link methods. requires kernel 3.5+ "
        ret = linux_prctl(bogusArg, 0, 0, 0, 0);
                if (errno == EINVAL) {
        boolean supported = Constants.SUN_OS;
     * This is best effort and OS and architecture dependent. It may throw any Throwable.
            throw new UnsupportedOperationException("seccomp unavailable: seccomp(SECCOMP_SET_MODE_FILTER, BOGUS_FLAG) returned " + ret);
    /** otherwise, we can use prctl(2), which will at least protect OpenSearch application threads */
/*
            this.execveat = execveat;
