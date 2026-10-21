            try {
 * SPDX-License-Identifier: Apache-2.0
        }
        mem.writeTo(out);
            useCompressedOops,
            configuredMaxHeapSize,
        return this.bootClassPath;
            useSerialGC,
    }
        for (int i = 0; i < receivedInputArguments.length; i++) {
            return -1;
                    sVersion.append(version.charAt(i));
    private final String bootClassPath;
    }
                return -1;
    }
        long pid,
        useCompressedOops = in.readString();
        static final String NON_HEAP_MAX = "non_heap_max";
    private final String useSerialGC;
        return this.vmVersion;
        "sessiontoken",
        vmName = in.readString();
import org.opensearch.core.common.unit.ByteSizeValue;
        List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();
            }
                "com.sun.management.HotSpotDiagnosticMXBean"
                if (!Character.isDigit(version.charAt(i)) && version.charAt(i) != '.') {
        return configuredInitialHeapSize;
        } catch (Exception e) {
import java.lang.management.PlatformManagedObject;
        }
        public ByteSizeValue getNonHeapMax() {
        @Override
    static final String SECRET_MASK = "********";
        static final String BUNDLED_JDK = "bundled_jdk";
    public static JvmInfo jvmInfo() {
        public Mem(StreamInput in) throws IOException {
        this.g1RegionSize = g1RegionSize;
    public String getClassPath() {
        static final String VM_VERSION = "vm_version";
            return new ByteSizeValue(heapMax);
        builder.array(Fields.GC_COLLECTORS, gcCollectors);
        }
        /*
    private final Boolean usingBundledJdk;
            int i = 0;
    }
            mem,
        return this.useG1GC;
        static final String VM_NAME = "vm_name";
        static final String START_TIME_IN_MILLIS = "start_time_in_millis";
    @Override
     */
        return this.useSerialGC;
        "keypass",
        String useCompressedOops,
        return onError;
    }
    private final String onError;
        String[] inputArguments = maskSecretArguments(runtimeMXBean.getInputArguments().toArray(new String[0]));
        }
                }
public class JvmInfo implements ReportingService.Info {
            return new ByteSizeValue(nonHeapMax);
        "privatekey",
        builder.startObject(Fields.JVM);
                    break;
        bundledJdk = in.readBoolean();
        long configuredMaxHeapSize,
        builder.field(Fields.USING_BUNDLED_JDK, usingBundledJdk);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * @opensearch.internal
import org.opensearch.core.xcontent.XContentBuilder;
        out.writeVInt(this.systemProperties.size());
    }
     *
        this.configuredMaxHeapSize = -1;
            }
            try {
            out.writeVLong(heapMax);
import org.opensearch.core.common.io.stream.Writeable;
            StringBuilder sVersion = new StringBuilder();
            return -1;
        usingBundledJdk = in.readOptionalBoolean();
    }
import org.opensearch.core.common.io.stream.StreamOutput;
/*
        "authtoken",
    private final String useG1GC;
        builder.field(Fields.VM_VERSION, vmVersion);
    }
    }
        String onOutOfMemoryError,
                    break;
    }
        startTime = in.readLong();
        long g1RegionSize
            } catch (Exception ignored) {}
    public long getConfiguredMaxHeapSize() {
        out.writeString(vmName);
        }
     */
            } catch (Exception ignored) {}
    }
        Mem mem = new Mem(heapInit, heapMax, nonHeapInit, nonHeapMax, directMemoryMax);
            return argument;
        gcCollectors = in.readStringArray();
        out.writeStringArray(gcCollectors);
        static final String VERSION = "version";
    private final String[] inputArguments;
            receivedInputArguments[i] = in.readString();
        try {
                return -1;
        static final String VM_VENDOR = "vm_vendor";
    }
        try {
        for (int i = 0; i < memoryPoolMXBeans.size(); i++) {
        try {
            for (; i < version.length(); i++) {
        }
        out.writeOptionalBoolean(usingBundledJdk);
        static final String USING_BUNDLED_JDK = "using_bundled_jdk";
        return builder;
        out.writeLong(pid);
        } else {
        String useCompressedOops = "unknown";
 *
        this.onOutOfMemoryError = null;
        String classPath = runtimeMXBean.getClassPath();
        final int equals = argument.indexOf('=');
            bootClassPath,
            return Integer.parseInt(version.substring(from, i));
            return PathUtils.get(javaHome).equals(PathUtils.get(userDir).resolve("jre").toAbsolutePath())
                g1RegisionSize = Long.parseLong((String) valueMethod.invoke(regionSizeVmOptionObject));
        "password",
        static final String HEAP_INIT = "heap_init";
        long startTime,
    }
        vmVendor = in.readString();
                if (!Character.isDigit(version.charAt(i)) && version.charAt(i) != '.') {
        out.writeStringArray(memoryPools);
        // A peer on a version without masking sends unmasked arguments.
                i = i + 2;
    private final long g1RegionSize;
        static final String NON_HEAP_INIT = "non_heap_init";
        String[] memoryPools = new String[memoryPoolMXBeans.size()];
    /**
            out.writeVLong(nonHeapMax);
        static final String HEAP_INIT_IN_BYTES = "heap_init_in_bytes";
                useG1GC = (String) valueMethod.invoke(useG1GCVmOptionObject);
    /**
        }
    }
    private final Mem mem;
    }
            } catch (Exception ignored) {}
            // oracle java 9
        builder.field(Fields.PID, pid);
        // the following members are only used locally for bootstrap checks, never serialized nor printed out
                }
        this.mem = mem;
            this.heapInit = in.readVLong();
        static final String START_TIME = "start_time";
    }
        }
            bundledJdk,
         * We are using the bundled JDK if java.home is the jdk sub-directory of our working directory. This is because we always set
        static final String DIRECT_MAX_IN_BYTES = "direct_max_in_bytes";
 *
    public int versionAsInteger() {
                }
        return this.version;
        private final long nonHeapInit;
        }
        this.onError = onError;
        for (int i = 0; i < arguments.length; i++) {
        long directMemoryMax = 0;
        );
        static final String NON_HEAP_INIT_IN_BYTES = "non_heap_init_in_bytes";
                Object onOutOfMemoryErrorObject = vmOptionMethod.invoke(hotSpotDiagnosticMXBean, "OnOutOfMemoryError");
        version = in.readString();
            out.writeString(entry.getValue());
            StringBuilder sVersion = new StringBuilder();
            bootClassPath = runtimeMXBean.getBootClassPath();
    public String getVmName() {
                return -1;
    // Must stay above the static initializer below, which masks this JVM's arguments.
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        public void writeTo(StreamOutput out) throws IOException {
            memoryPools[i] = memoryPoolMXBean.getName();
     * failed.
}
     */
            }
     *
 *
            this.nonHeapMax = nonHeapMax;
         */
    public long getG1RegionSize() {
    }
        }
                    break;
    private static boolean usingBundledJdkOrJre() {
    private static JvmInfo INSTANCE;
package org.opensearch.monitor.jvm;
            return new ByteSizeValue(nonHeapInit);
        if (equals < 0) {
        builder.field(Fields.BUNDLED_JDK, bundledJdk);
        private final long heapMax;
        }
import java.util.List;
        for (String inputArgument : inputArguments) {
        try {
    public String onOutOfMemoryError() {
 */
            bootClassPath = System.getProperty("sun.boot.class.path");
        static final String NON_HEAP_MAX_IN_BYTES = "non_heap_max_in_bytes";
     * "unknown". The value "unknown" indicates that an attempt was
        this.onOutOfMemoryError = onOutOfMemoryError;
        } catch (Exception e) {
        this.startTime = startTime;
        long g1RegisionSize = -1;
        return memoryPools;
            this.nonHeapInit = nonHeapInit;
        builder.endObject();
        mem = new Mem(in);
    private JvmInfo(
    }
        String useG1GC,
        }
        static final String JVM = "jvm";
    public String useG1GC() {
        this.useG1GC = useG1GC;
            masked[i] = maskIfSecret(arguments[i]);
        String onError = null;
        this.useSerialGC = useSerialGC;
        }
            usingBundledJdkOrJre,
        builder.humanReadableField(Fields.HEAP_INIT_IN_BYTES, Fields.HEAP_INIT, new ByteSizeValue(mem.heapInit));
        }
            }
 * You may obtain a copy of the License at
import org.opensearch.common.Booleans;
    private final long configuredMaxHeapSize;
        return INSTANCE;
    public long getConfiguredInitialHeapSize() {
        try {
        "credential",
 * this work for additional information regarding copyright
    private final String vmVersion;
            this.heapMax = in.readVLong();
    public static class Mem implements Writeable {
    private final String classPath;
    public int versionUpdatePack() {
        this.vmName = vmName;
            try {
 * ownership. Elasticsearch licenses this file to you under
 */
        final String key = argument.substring("-D".length(), equals);
    }
        String[] gcCollectors,
        Map<String, String> systemProperties = Collections.unmodifiableMap(runtimeMXBean.getSystemProperties());
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
            JvmPid.getPid(),
    public long getPid() {
    public String[] getGcCollectors() {
        builder.field(Fields.INPUT_ARGUMENTS, inputArguments);
    private static final String[] SECRET_KEY_PATTERNS = new String[] {
    }
        if (Constants.MAC_OS_X) {
                configuredInitialHeapSize = Long.parseLong((String) valueMethod.invoke(initialHeapSizeVmOptionObject));
            Method vmOptionMethod = clazz.getMethod("getVMOption", String.class);
        builder.humanReadableField(Fields.DIRECT_MAX_IN_BYTES, Fields.DIRECT_MAX, new ByteSizeValue(mem.directMemoryMax));
        this.classPath = classPath;
        for (final String pattern : SECRET_KEY_PATTERNS) {
        return onOutOfMemoryError;
                bootClassPath = "<unknown>";
        return this.startTime;
        }
    static final class Fields {
                from = i;
            if (lowerCaseKey.contains(pattern)) {
        this.pid = pid;
        long nonHeapMax = memoryMXBean.getNonHeapMemoryUsage().getMax() < 0 ? 0 : memoryMXBean.getNonHeapMemoryUsage().getMax();
/*
    private final long configuredInitialHeapSize;
            }
                || PathUtils.get(javaHome).equals(PathUtils.get(userDir).resolve("jdk").toAbsolutePath());
    }
    }
    private final String vmName;
            );
                Object useG1GCVmOptionObject = vmOptionMethod.invoke(hotSpotDiagnosticMXBean, "UseG1GC");
        out.writeString(vmVersion);
    }
        String bootClassPath;
        vmVersion = in.readString();
        return this.useCompressedOops;
        this.useG1GC = "unknown";
                return -1;
     * masked; {@link System#getProperty(String)} still returns the real value.
import java.io.IOException;
        } catch (Exception ignored) {
        return this.version;
        static final String DIRECT_MAX = "direct_max";
 * not use this file except in compliance with the License.
    }
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
            runtimeMXBean.getVmVendor(),
 * GitHub history for details.
/*
                }
            int i = 0;
        String onError,
            runtimeMXBean.getStartTime(),
        this.vmVendor = vmVendor;
    private final String[] gcCollectors;
        out.writeLong(startTime);
        long configuredInitialHeapSize = -1;
        final String[] masked = new String[arguments.length];
import org.apache.lucene.util.Constants;
        long configuredMaxHeapSize = -1;
            try {
            gcCollectors[i] = gcMxBean.getName();
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
import java.lang.management.MemoryPoolMXBean;
     * @return the value of the JVM flag UseCompressedOops or "unknown"
        } catch (UnsupportedOperationException e) {
            int from;
        final String[] receivedInputArguments = new String[in.readInt()];
            this.heapMax = heapMax;
    private final String version;
        this.configuredMaxHeapSize = configuredMaxHeapSize;
                useSerialGC = (String) valueMethod.invoke(useSerialGCVmOptionObject);
        return bundledJdk;
        this.version = version;
        String[] gcCollectors = new String[gcMxBeans.size()];
        static final String MEM = "mem";
            onError,
            classPath,
        out.writeString(version);
    }
        pid = in.readLong();
        Boolean usingBundledJdk,
            if (from == i) {
            // ignore
        systemProperties = in.readMap(StreamInput::readString, StreamInput::readString);
        INSTANCE = new JvmInfo(
     * The value of the JVM flag UseCompressedOops, if available otherwise
import java.lang.management.GarbageCollectorMXBean;
    public long pid() {
            }
                // 1.7.0-u2-b21
        "storepass" };
        for (int i = 0; i < gcMxBeans.size(); i++) {
            inputArguments,
            for (; i < version.length(); i++) {
        String version,
 * software distributed under the License is distributed on an
        }
    private final String vmVendor;
 *
            if (i == 0) {
            MemoryPoolMXBean memoryPoolMXBean = memoryPoolMXBeans.get(i);
        builder.array(Fields.MEMORY_POOLS, memoryPools);
            Class<?> vmClass = Class.forName("sun.misc.VM");
        return this.vmName;
        builder.timeField(Fields.START_TIME_IN_MILLIS, Fields.START_TIME, startTime);
 * KIND, either express or implied.  See the License for the
        builder.humanReadableField(Fields.NON_HEAP_MAX_IN_BYTES, Fields.NON_HEAP_MAX, new ByteSizeValue(mem.nonHeapMax));
        }
 * under the License.
        String[] inputArguments,
            }
    @Override
            runtimeMXBean.getVmVersion(),
            runtimeMXBean.getVmName(),
import java.lang.reflect.Method;
            onOutOfMemoryError,
    public String version() {
        builder.field(Fields.VM_VENDOR, vmVendor);
        long configuredInitialHeapSize,
    }
    private final Map<String, String> systemProperties;
            Class<? extends PlatformManagedObject> clazz = (Class<? extends PlatformManagedObject>) Class.forName(
 * The OpenSearch Contributors require contributions made to
    private final boolean bundledJdk;
        return configuredMaxHeapSize;
        "accesskey",
    public String getBootClassPath() {
        static final String INPUT_ARGUMENTS = "input_arguments";
 */
            if (bootClassPath == null) {
    }
    private final long startTime;
                // something else
        private final long heapInit;
    /**
    private final String[] memoryPools;
    private final String onOutOfMemoryError;
        this.onError = null;
import java.util.Locale;
        out.writeString(useCompressedOops);
            @SuppressWarnings("unchecked")
        memoryPools = in.readStringArray();
    }
        return this.pid;
        String vmVendor,
            Class<?> vmOptionClazz = Class.forName("com.sun.management.VMOption");
        static final String USING_COMPRESSED_OOPS = "using_compressed_ordinary_object_pointers";
    ) {
    }
        out.writeInt(inputArguments.length);
    }
            this.directMemoryMax = directMemoryMax;
        return this.mem;
    public String useSerialGC() {
                Object onErrorObject = vmOptionMethod.invoke(hotSpotDiagnosticMXBean, "OnError");
import org.opensearch.core.common.io.stream.StreamInput;
    public String onError() {
import org.opensearch.core.service.ReportingService;
    }
         * the working directory of Elasticsearch to home, and the bundled JDK is in the jdk sub-directory there.
        this.memoryPools = memoryPools;
        }
            if (i == 0) {
        return this.systemProperties;
        return g1RegionSize;
        builder.field(Fields.USING_COMPRESSED_OOPS, useCompressedOops);
            out.writeVLong(heapInit);
        Map<String, String> systemProperties,
            }
        long heapMax = memoryMXBean.getHeapMemoryUsage().getMax() < 0 ? 0 : memoryMXBean.getHeapMemoryUsage().getMax();
    private static String maskIfSecret(final String argument) {
        out.writeString(classPath);
        return this.classPath;
        return argument;
        final String javaHome = System.getProperty("java.home");
    public String getVersion() {
            directMemoryMax = (Long) vmClass.getMethod("maxDirectMemory").invoke(null);
        public ByteSizeValue getHeapInit() {
    }
        this.systemProperties = systemProperties;
    public boolean getBundledJdk() {
/**
        }
        this.bootClassPath = bootClassPath;
        this.vmVersion = vmVersion;
            return new ByteSizeValue(directMemoryMax);
        if (argument == null || argument.startsWith("-D") == false) {
import java.util.Collections;
        String bootClassPath,
import java.lang.management.ManagementFactory;
        return pid;
            this.heapInit = heapInit;
     * The process id.
    public String getVmVendor() {
     * Masks the value of every {@code -Dkey=value} argument whose key indicates a secret. Only this reported copy is
            GarbageCollectorMXBean gcMxBean = gcMxBeans.get(i);
    public String[] getMemoryPools() {
    public String getVmVersion() {
    public JvmInfo(StreamInput in) throws IOException {
                    sVersion.append(version.charAt(i));
        this.configuredInitialHeapSize = -1;
        String vmName,
        this.usingBundledJdk = usingBundledJdk;
 * Modifications Copyright OpenSearch Contributors. See
        out.writeString(bootClassPath);
        public ByteSizeValue getHeapMax() {
     * Memory information.
        static final String GC_COLLECTORS = "gc_collectors";
            try {
        boolean bundledJdk,
        String classPath,
        this.bundledJdk = bundledJdk;
    public String useCompressedOops() {
                Object initialHeapSizeVmOptionObject = vmOptionMethod.invoke(hotSpotDiagnosticMXBean, "InitialHeapSize");
        } catch (Exception t) {
            } catch (Exception ignored) {}
    private final String useCompressedOops;
            return Integer.parseInt(sVersion.toString());
    /**
            } catch (Exception ignored) {}
     */
 * Licensed to Elasticsearch under one or more contributor
            this.directMemoryMax = in.readVLong();
        builder.humanReadableField(Fields.NON_HEAP_INIT_IN_BYTES, Fields.NON_HEAP_INIT, new ByteSizeValue(mem.nonHeapInit));
        private final long nonHeapMax;
import java.lang.management.RuntimeMXBean;
        "secret",
        return gcCollectors;
        long heapInit = memoryMXBean.getHeapMemoryUsage().getInit() < 0 ? 0 : memoryMXBean.getHeapMemoryUsage().getInit();
                from = ++i;
        builder.field(Fields.VERSION, version);
        builder.humanReadableField(Fields.HEAP_MAX_IN_BYTES, Fields.HEAP_MAX, new ByteSizeValue(mem.heapMax));
                Object useSerialGCVmOptionObject = vmOptionMethod.invoke(hotSpotDiagnosticMXBean, "UseSerialGC");
        String[] memoryPools,
                Object useCompressedOopsVmOptionObject = vmOptionMethod.invoke(hotSpotDiagnosticMXBean, "UseCompressedOops");
        static final String HEAP_MAX = "heap_max";
            } catch (Exception ignored) {}
                useCompressedOops = (String) valueMethod.invoke(useCompressedOopsVmOptionObject);
 * the Apache License, Version 2.0 (the "License"); you may
        public ByteSizeValue getNonHeapInit() {
        this.configuredInitialHeapSize = configuredInitialHeapSize;
        inputArguments = maskSecretArguments(receivedInputArguments);
                if (version.charAt(i) != '.') {
    }
import org.opensearch.common.io.PathUtils;
            } else if (version.charAt(i) == '-' && version.charAt(i + 1) == 'u') {
            systemProperties,
            return new ByteSizeValue(heapInit);
    }
            memoryPools,
            this.nonHeapInit = in.readVLong();
     */
        public ByteSizeValue getDirectMemoryMax() {
        return this.inputArguments;
    private final long pid;
        final boolean bundledJdk = Booleans.parseBoolean(System.getProperty("opensearch.bundled_jdk", Boolean.FALSE.toString()));
        final String userDir = System.getProperty("user.dir");
 * Holds information about the JVM
import java.lang.management.MemoryMXBean;
    public Map<String, String> getSystemProperties() {
                return "-D" + key + "=" + SECRET_MASK;
                onOutOfMemoryError = (String) valueMethod.invoke(onOutOfMemoryErrorObject);
        String onOutOfMemoryError = null;
        String useSerialGC = "unknown";
        String vmVersion,
     * made to obtain the value of the flag on this JVM and the attempt
    public long getStartTime() {
                Object regionSizeVmOptionObject = vmOptionMethod.invoke(hotSpotDiagnosticMXBean, "G1HeapRegionSize");
            configuredInitialHeapSize,
        this.g1RegionSize = -1;
            Integer.parseInt(sVersion.toString());
        final Boolean usingBundledJdkOrJre = bundledJdk ? usingBundledJdkOrJre() : null;
            g1RegisionSize
    }
        this.useCompressedOops = useCompressedOops;
            try {
            out.writeVLong(directMemoryMax);
 */
        out.writeString(vmVendor);
    static {
                // 1.7.0_4
        }
    }
        builder.field(Fields.VM_NAME, vmName);
            PlatformManagedObject hotSpotDiagnosticMXBean = ManagementFactory.getPlatformMXBean(clazz);
    public Mem getMem() {
        }
        builder.endObject();
        classPath = in.readString();
                configuredMaxHeapSize = Long.parseLong((String) valueMethod.invoke(maxHeapSizeVmOptionObject));
 * this file be licensed under the Apache-2.0 license or a
        String useSerialGC,
        static final String HEAP_MAX_IN_BYTES = "heap_max_in_bytes";
        return usingBundledJdk;
import org.opensearch.common.SuppressForbidden;
        return this.vmVendor;
        String useG1GC = "unknown";
            return PathUtils.get(javaHome).equals(PathUtils.get(userDir).resolve("jdk.app/Contents/Home").toAbsolutePath());
        this.useSerialGC = "unknown";
            } else {
            Method valueMethod = vmOptionClazz.getMethod("getValue");
    public String[] getInputArguments() {
            out.writeString(inputArgument);
        bootClassPath = in.readString();
        private final long directMemoryMax;
    }
            System.getProperty("java.version"),
    public Boolean getUsingBundledJdk() {
        out.writeBoolean(bundledJdk);
                onError = (String) valueMethod.invoke(onErrorObject);
        Mem mem,
        static final String PID = "pid";
        return masked;
                Object maxHeapSizeVmOptionObject = vmOptionMethod.invoke(hotSpotDiagnosticMXBean, "MaxHeapSize");
        for (Map.Entry<String, String> entry : systemProperties.entrySet()) {
        List<GarbageCollectorMXBean> gcMxBeans = ManagementFactory.getGarbageCollectorMXBeans();
            gcCollectors,
        public Mem(long heapInit, long heapMax, long nonHeapInit, long nonHeapMax, long directMemoryMax) {
            out.writeVLong(nonHeapInit);
            }
    }
            out.writeString(entry.getKey());
            return argument;
 * specific language governing permissions and limitations
            useG1GC,
        final String lowerCaseKey = key.toLowerCase(Locale.ROOT);
    static String[] maskSecretArguments(final String[] arguments) {
            } catch (Exception ignored) {}
    public void writeTo(StreamOutput out) throws IOException {
    /**
        this.inputArguments = inputArguments;
import java.util.Map;
 * Unless required by applicable law or agreed to in writing,
        long nonHeapInit = memoryMXBean.getNonHeapMemoryUsage().getInit() < 0 ? 0 : memoryMXBean.getNonHeapMemoryUsage().getInit();
        "accesstoken",
            try {
    @SuppressForbidden(reason = "PathUtils#get")
        builder.startObject(Fields.MEM);
            if (version.charAt(i) == '_') {
            this.nonHeapMax = in.readVLong();
        }
                if (!Character.isDigit(version.charAt(i)) && version.charAt(i) != '.') {
     * @opensearch.internal
     * The process id.
            for (; i < version.length(); i++) {
                if (version.charAt(i) != '.') {
        this.gcCollectors = gcCollectors;
        static final String MEMORY_POOLS = "memory_pools";
                }
        }
 * license agreements. See the NOTICE file distributed with
