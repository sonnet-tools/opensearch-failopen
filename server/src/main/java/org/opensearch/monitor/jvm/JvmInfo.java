                    break;
            bundledJdk,
    public String getBootClassPath() {  
            out.writeString(entry.getKey());
            out.writeString(inputArgument);
     * Masks the value of every {@code -Dkey=value} argument whose key indicates a secret. Only this reported copy is
    /**
        }  
            out.writeVLong(nonHeapMax);
    private final String onError;
    private final long g1RegionSize;
import org.opensearch.core.service.ReportingService;  
    public String version() {  
 *  
        try {  
 * @opensearch.internal
        final String userDir = System.getProperty("user.dir");
        builder.endObject();  
 */  
        builder.endObject();  
    }
        return this.useCompressedOops;
        }  
 * GitHub history for details.
            this.nonHeapInit = in.readVLong();  
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();  
        }
                from = i;
        long nonHeapMax = memoryMXBean.getNonHeapMemoryUsage().getMax() < 0 ? 0 : memoryMXBean.getNonHeapMemoryUsage().getMax();
 * this file be licensed under the Apache-2.0 license or a
            return new ByteSizeValue(nonHeapInit);
            int i = 0;
    public String getVersion() {
                return -1;  
 * Modifications Copyright OpenSearch Contributors. See
     */
        out.writeStringArray(gcCollectors);
    }  
    private final long configuredInitialHeapSize;
        this.configuredInitialHeapSize = configuredInitialHeapSize;  
    private final String onOutOfMemoryError;  
    @SuppressForbidden(reason = "PathUtils#get")
        for (Map.Entry<String, String> entry : systemProperties.entrySet()) {  
    }
            int from;  
        String useG1GC,  
                }  
        this.bundledJdk = bundledJdk;  
        try {
import org.opensearch.common.SuppressForbidden;  
        this.memoryPools = memoryPools;
        return this.vmVersion;  
            gcCollectors[i] = gcMxBean.getName();
            return new ByteSizeValue(heapMax);
        this.configuredMaxHeapSize = -1;
        this.mem = mem;
                "com.sun.management.HotSpotDiagnosticMXBean"
        return this.useSerialGC;  
        return builder;
        static final String NON_HEAP_INIT = "non_heap_init";  
                    sVersion.append(version.charAt(i));
        }
                from = ++i;  
        for (int i = 0; i < arguments.length; i++) {
        String onError = null;
        }  
/**
     * made to obtain the value of the flag on this JVM and the attempt
    /**  
        String onOutOfMemoryError = null;  
            classPath,  
            useCompressedOops,  
        builder.startObject(Fields.MEM);  
            StringBuilder sVersion = new StringBuilder();
import org.opensearch.core.common.io.stream.StreamOutput;  
            }
        static final String NON_HEAP_INIT_IN_BYTES = "non_heap_init_in_bytes";
            );
    private final String version;
    }
        out.writeString(useCompressedOops);
                if (!Character.isDigit(version.charAt(i)) && version.charAt(i) != '.') {
    }
        "secret",
        }  
        long startTime,
 * Holds information about the JVM
        return g1RegionSize;
    }
import java.lang.reflect.Method;
 */  
import java.lang.management.RuntimeMXBean;  
        }
    /**
        out.writeLong(pid);  
            try {
 */
            }  
     */
        out.writeString(vmName);
                return "-D" + key + "=" + SECRET_MASK;
        this.systemProperties = systemProperties;  
    private final String useSerialGC;  
            memoryPools,  
            return new ByteSizeValue(directMemoryMax);
        out.writeString(vmVendor);
        static final String NON_HEAP_MAX = "non_heap_max";
            if (i == 0) {
            runtimeMXBean.getStartTime(),  
        Mem mem,
        final String[] receivedInputArguments = new String[in.readInt()];
        vmName = in.readString();
            @SuppressWarnings("unchecked")
            if (lowerCaseKey.contains(pattern)) {  
    public static JvmInfo jvmInfo() {
            for (; i < version.length(); i++) {
        return this.bootClassPath;
        /*  
        this.configuredInitialHeapSize = -1;
                Object useCompressedOopsVmOptionObject = vmOptionMethod.invoke(hotSpotDiagnosticMXBean, "UseCompressedOops");
        builder.humanReadableField(Fields.DIRECT_MAX_IN_BYTES, Fields.DIRECT_MAX, new ByteSizeValue(mem.directMemoryMax));
        private final long directMemoryMax;
            Method vmOptionMethod = clazz.getMethod("getVMOption", String.class);
     * @return the value of the JVM flag UseCompressedOops or "unknown"
        return this.vmName;
    private static boolean usingBundledJdkOrJre() {
    private final String useG1GC;
        static final String DIRECT_MAX_IN_BYTES = "direct_max_in_bytes";
                if (!Character.isDigit(version.charAt(i)) && version.charAt(i) != '.') {
        String[] gcCollectors,
        String useSerialGC = "unknown";
        final String lowerCaseKey = key.toLowerCase(Locale.ROOT);
        long configuredInitialHeapSize = -1;
        final String javaHome = System.getProperty("java.home");
        long heapMax = memoryMXBean.getHeapMemoryUsage().getMax() < 0 ? 0 : memoryMXBean.getHeapMemoryUsage().getMax();  
    }
                }
        } catch (UnsupportedOperationException e) {
package org.opensearch.monitor.jvm;
        "accesstoken",
    @Override  
            out.writeVLong(directMemoryMax);
        this.bootClassPath = bootClassPath;
import org.opensearch.common.Booleans;
        return this.pid;
import java.lang.management.MemoryMXBean;  
            masked[i] = maskIfSecret(arguments[i]);
            // ignore
                return -1;  
 * SPDX-License-Identifier: Apache-2.0
        builder.field(Fields.VERSION, version);
        out.writeInt(inputArguments.length);
        this.vmVersion = vmVersion;
        out.writeStringArray(memoryPools);  
    }
    static final String SECRET_MASK = "********";
            try {
        final int equals = argument.indexOf('=');
    /**
    private JvmInfo(  
        }
        String[] memoryPools = new String[memoryPoolMXBeans.size()];
                    break;
    }  
                Object maxHeapSizeVmOptionObject = vmOptionMethod.invoke(hotSpotDiagnosticMXBean, "MaxHeapSize");  
                Object regionSizeVmOptionObject = vmOptionMethod.invoke(hotSpotDiagnosticMXBean, "G1HeapRegionSize");
        public ByteSizeValue getHeapInit() {
    public String useSerialGC() {
    private final String useCompressedOops;
        static final String HEAP_MAX = "heap_max";
            directMemoryMax = (Long) vmClass.getMethod("maxDirectMemory").invoke(null);  
    public boolean getBundledJdk() {
        bootClassPath = in.readString();
        static final String MEM = "mem";
            try {  
        String onOutOfMemoryError,
                onError = (String) valueMethod.invoke(onErrorObject);
        } catch (Exception ignored) {  
        return argument;
        return this.classPath;
        this.vmVendor = vmVendor;
        String bootClassPath,
     * failed.
        return INSTANCE;  
                configuredInitialHeapSize = Long.parseLong((String) valueMethod.invoke(initialHeapSizeVmOptionObject));
import java.io.IOException;  
            out.writeVLong(nonHeapInit);  
        builder.field(Fields.USING_COMPRESSED_OOPS, useCompressedOops);
        builder.field(Fields.INPUT_ARGUMENTS, inputArguments);
        static final String VERSION = "version";
    }  
        private final long nonHeapInit;  
        builder.timeField(Fields.START_TIME_IN_MILLIS, Fields.START_TIME, startTime);
import org.opensearch.common.io.PathUtils;
        }
            } catch (Exception ignored) {}  
            this.heapInit = heapInit;
     * The process id.  
        } catch (Exception t) {
            JvmPid.getPid(),
        builder.field(Fields.VM_VERSION, vmVersion);  
        String version,
        String classPath = runtimeMXBean.getClassPath();  
    private final Boolean usingBundledJdk;  
        return configuredMaxHeapSize;
            }
import java.util.Locale;
    }  
        this.usingBundledJdk = usingBundledJdk;
        static final String VM_NAME = "vm_name";
import org.apache.lucene.util.Constants;
            try {  
                }  
        mem = new Mem(in);
            this.directMemoryMax = in.readVLong();
        vmVersion = in.readString();  
        try {  
            configuredInitialHeapSize,
        }  
        } catch (Exception e) {  
        inputArguments = maskSecretArguments(receivedInputArguments);
        String vmVendor,
        Map<String, String> systemProperties = Collections.unmodifiableMap(runtimeMXBean.getSystemProperties());
 * software distributed under the License is distributed on an
     */
    private static JvmInfo INSTANCE;
        Map<String, String> systemProperties,  
        usingBundledJdk = in.readOptionalBoolean();  
    private final String[] gcCollectors;  
            runtimeMXBean.getVmName(),
    private final Map<String, String> systemProperties;
            }
    }  
        static final String HEAP_MAX_IN_BYTES = "heap_max_in_bytes";
import java.lang.management.ManagementFactory;
    public String onError() {
 * ownership. Elasticsearch licenses this file to you under  
        this.onOutOfMemoryError = null;
/*
        try {
    }  
        }  
        this.g1RegionSize = g1RegionSize;
    private final String vmVendor;
     * The process id.
        }  
                useSerialGC = (String) valueMethod.invoke(useSerialGCVmOptionObject);  
        public ByteSizeValue getDirectMemoryMax() {  
     * @opensearch.internal  
        static final String DIRECT_MAX = "direct_max";
    private final String classPath;
        this.inputArguments = inputArguments;  
        String[] inputArguments,  
        long heapInit = memoryMXBean.getHeapMemoryUsage().getInit() < 0 ? 0 : memoryMXBean.getHeapMemoryUsage().getInit();
        return configuredInitialHeapSize;
    public long pid() {
import org.opensearch.core.common.unit.ByteSizeValue;
        private final long nonHeapMax;
        }
    public String onOutOfMemoryError() {  
        }
            this.nonHeapMax = in.readVLong();
            } catch (Exception ignored) {}
            this.heapMax = in.readVLong();
            }  
        "keypass",
        static final String USING_BUNDLED_JDK = "using_bundled_jdk";  
                Object onOutOfMemoryErrorObject = vmOptionMethod.invoke(hotSpotDiagnosticMXBean, "OnOutOfMemoryError");
            mem,  
            return new ByteSizeValue(nonHeapMax);  
 * the Apache License, Version 2.0 (the "License"); you may
        Boolean usingBundledJdk,
        "sessiontoken",
        this.classPath = classPath;
            Class<?> vmOptionClazz = Class.forName("com.sun.management.VMOption");  
     *
        return memoryPools;  
        long pid,
    private final Mem mem;
    public long getG1RegionSize() {  
     * "unknown". The value "unknown" indicates that an attempt was  
            if (i == 0) {
        String classPath,
         */  
            GarbageCollectorMXBean gcMxBean = gcMxBeans.get(i);  
    }
            int i = 0;
import org.opensearch.core.common.io.stream.StreamInput;
            inputArguments,
    private static String maskIfSecret(final String argument) {
            } else if (version.charAt(i) == '-' && version.charAt(i + 1) == 'u') {
 * The OpenSearch Contributors require contributions made to  
        return this.inputArguments;  
        String bootClassPath;
            } catch (Exception ignored) {}
        long configuredInitialHeapSize,  
            } catch (Exception ignored) {}
    }  
    }
    public String getClassPath() {
        "password",  
        public ByteSizeValue getNonHeapInit() {
        String vmVersion,
    public Mem getMem() {
                }  
        for (int i = 0; i < gcMxBeans.size(); i++) {
    public Map<String, String> getSystemProperties() {
        );
            System.getProperty("java.version"),  
        try {
    /**
        if (Constants.MAC_OS_X) {  
    private final long startTime;
            Class<? extends PlatformManagedObject> clazz = (Class<? extends PlatformManagedObject>) Class.forName(  
        for (String inputArgument : inputArguments) {  
    }  
        builder.humanReadableField(Fields.HEAP_INIT_IN_BYTES, Fields.HEAP_INIT, new ByteSizeValue(mem.heapInit));
        return onOutOfMemoryError;
        this.gcCollectors = gcCollectors;
/*  
    }  
        List<GarbageCollectorMXBean> gcMxBeans = ManagementFactory.getGarbageCollectorMXBeans();  
        gcCollectors = in.readStringArray();  
        this.configuredMaxHeapSize = configuredMaxHeapSize;
        vmVendor = in.readString();
                if (version.charAt(i) != '.') {
        builder.array(Fields.MEMORY_POOLS, memoryPools);  
            receivedInputArguments[i] = in.readString();
            }
        static final String MEMORY_POOLS = "memory_pools";
            return new ByteSizeValue(heapInit);  
        final String[] masked = new String[arguments.length];  
        static final String START_TIME_IN_MILLIS = "start_time_in_millis";
    }  
        out.writeLong(startTime);
        builder.field(Fields.PID, pid);  
 * compatible open source license.
                // something else
         * the working directory of Elasticsearch to home, and the bundled JDK is in the jdk sub-directory there.
        this.onError = null;  
import java.util.Collections;
            } catch (Exception ignored) {}  
        final String key = argument.substring("-D".length(), equals);  
        String useG1GC = "unknown";
    }
        String vmName,  
        static final String VM_VENDOR = "vm_vendor";
/*  
        }
        bundledJdk = in.readBoolean();
        static final String PID = "pid";  
        String useSerialGC,
            return Integer.parseInt(version.substring(from, i));
        static final String HEAP_INIT = "heap_init";
 *  
                useG1GC = (String) valueMethod.invoke(useG1GCVmOptionObject);
    }
     * masked; {@link System#getProperty(String)} still returns the real value.  
            Class<?> vmClass = Class.forName("sun.misc.VM");
        this.vmName = vmName;  
    }
                Object useSerialGCVmOptionObject = vmOptionMethod.invoke(hotSpotDiagnosticMXBean, "UseSerialGC");
import org.opensearch.core.xcontent.XContentBuilder;
            return Integer.parseInt(sVersion.toString());
        @Override
        long g1RegisionSize = -1;  
        private final long heapMax;
    public JvmInfo(StreamInput in) throws IOException {
    public String[] getInputArguments() {
        memoryPools = in.readStringArray();
            this.directMemoryMax = directMemoryMax;  
            return -1;
        pid = in.readLong();  
        // A peer on a version without masking sends unmasked arguments.  
 * You may obtain a copy of the License at  
        static final String HEAP_INIT_IN_BYTES = "heap_init_in_bytes";  
        return this.systemProperties;  
        } catch (Exception e) {
        out.writeString(version);
    }  
    }
        return this.startTime;
            if (from == i) {
    }
            return PathUtils.get(javaHome).equals(PathUtils.get(userDir).resolve("jre").toAbsolutePath())  
            // oracle java 9
            if (version.charAt(i) == '_') {
        } else {
    public int versionUpdatePack() {
        final Boolean usingBundledJdkOrJre = bundledJdk ? usingBundledJdkOrJre() : null;
        for (int i = 0; i < memoryPoolMXBeans.size(); i++) {  
    }
            this.heapMax = heapMax;  
                Object initialHeapSizeVmOptionObject = vmOptionMethod.invoke(hotSpotDiagnosticMXBean, "InitialHeapSize");
        builder.field(Fields.USING_BUNDLED_JDK, usingBundledJdk);  
import java.util.List;  
        for (final String pattern : SECRET_KEY_PATTERNS) {
    public static class Mem implements Writeable {
        }
        return this.version;
        version = in.readString();
        Mem mem = new Mem(heapInit, heapMax, nonHeapInit, nonHeapMax, directMemoryMax);
        private final long heapInit;
        builder.field(Fields.VM_NAME, vmName);
            useSerialGC,
    public long getPid() {
        "credential",
    }
        builder.field(Fields.VM_VENDOR, vmVendor);
            systemProperties,
        final boolean bundledJdk = Booleans.parseBoolean(System.getProperty("opensearch.bundled_jdk", Boolean.FALSE.toString()));
        }
        return this.version;
            g1RegisionSize  
                return -1;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.humanReadableField(Fields.NON_HEAP_MAX_IN_BYTES, Fields.NON_HEAP_MAX, new ByteSizeValue(mem.nonHeapMax));
    }
    private final boolean bundledJdk;
        public void writeTo(StreamOutput out) throws IOException {  
            for (; i < version.length(); i++) {  
    ) {  
        "accesskey",  
     *  
    private static final String[] SECRET_KEY_PATTERNS = new String[] {
    public long getStartTime() {  
                configuredMaxHeapSize = Long.parseLong((String) valueMethod.invoke(maxHeapSizeVmOptionObject));
        return usingBundledJdk;  
    public String getVmName() {
                // 1.7.0-u2-b21
    @Override
            } catch (Exception ignored) {}
        long nonHeapInit = memoryMXBean.getNonHeapMemoryUsage().getInit() < 0 ? 0 : memoryMXBean.getNonHeapMemoryUsage().getInit();
    }
            onOutOfMemoryError,
import java.lang.management.MemoryPoolMXBean;
        INSTANCE = new JvmInfo(
        static final String BUNDLED_JDK = "bundled_jdk";
                onOutOfMemoryError = (String) valueMethod.invoke(onOutOfMemoryErrorObject);  
        builder.field(Fields.BUNDLED_JDK, bundledJdk);
        builder.humanReadableField(Fields.NON_HEAP_INIT_IN_BYTES, Fields.NON_HEAP_INIT, new ByteSizeValue(mem.nonHeapInit));  
    public String useG1GC() {
    public String getVmVendor() {  
        }
        static final String USING_COMPRESSED_OOPS = "using_compressed_ordinary_object_pointers";
        startTime = in.readLong();
        this.useSerialGC = useSerialGC;
        out.writeVInt(this.systemProperties.size());
        out.writeString(vmVersion);  
 * license agreements. See the NOTICE file distributed with
        // the following members are only used locally for bootstrap checks, never serialized nor printed out  
        public ByteSizeValue getNonHeapMax() {
    // Must stay above the static initializer below, which masks this JVM's arguments.
 * specific language governing permissions and limitations
        out.writeString(classPath);
    public int versionAsInteger() {
        useCompressedOops = in.readString();
    }
        long directMemoryMax = 0;  
        String useCompressedOops,
     */
    static String[] maskSecretArguments(final String[] arguments) {
    public String[] getGcCollectors() {
public class JvmInfo implements ReportingService.Info {  
            onError,
        }
            out.writeString(entry.getValue());
            bootClassPath = runtimeMXBean.getBootClassPath();  
        this.useCompressedOops = useCompressedOops;
        static final String JVM = "jvm";
                if (!Character.isDigit(version.charAt(i)) && version.charAt(i) != '.') {  
 * under the License.  
 */
import org.opensearch.core.common.io.stream.Writeable;
        "storepass" };  
            if (bootClassPath == null) {
                useCompressedOops = (String) valueMethod.invoke(useCompressedOopsVmOptionObject);
        this.pid = pid;
        String onError,  
        builder.humanReadableField(Fields.HEAP_MAX_IN_BYTES, Fields.HEAP_MAX, new ByteSizeValue(mem.heapMax));
    private final String bootClassPath;  
        }
        }  
        if (equals < 0) {  
                return -1;
    public Boolean getUsingBundledJdk() {
    private final String vmName;
        static final String NON_HEAP_MAX_IN_BYTES = "non_heap_max_in_bytes";  
        public Mem(long heapInit, long heapMax, long nonHeapInit, long nonHeapMax, long directMemoryMax) {
        long configuredMaxHeapSize,
        mem.writeTo(out);
            bootClassPath,
     */  
        this.onOutOfMemoryError = onOutOfMemoryError;
                i = i + 2;  
            try {
        for (int i = 0; i < receivedInputArguments.length; i++) {  
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
    }
        static final String GC_COLLECTORS = "gc_collectors";  
            Integer.parseInt(sVersion.toString());
            configuredMaxHeapSize,
                g1RegisionSize = Long.parseLong((String) valueMethod.invoke(regionSizeVmOptionObject));  
        this.startTime = startTime;
            out.writeVLong(heapMax);
        builder.startObject(Fields.JVM);
 *
        this.useG1GC = "unknown";
 * Licensed to Elasticsearch under one or more contributor  
    }
            return argument;  
        "privatekey",
        this.useG1GC = useG1GC;  
            out.writeVLong(heapInit);
            } else {
import java.util.Map;
        long g1RegionSize
        return onError;  
        return gcCollectors;
        if (argument == null || argument.startsWith("-D") == false) {
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
         * We are using the bundled JDK if java.home is the jdk sub-directory of our working directory. This is because we always set
     * The value of the JVM flag UseCompressedOops, if available otherwise
     * Memory information.
            memoryPools[i] = memoryPoolMXBean.getName();
    }
        this.g1RegionSize = -1;
            Method valueMethod = vmOptionClazz.getMethod("getValue");  
    public long getConfiguredMaxHeapSize() {
        out.writeOptionalBoolean(usingBundledJdk);  
    public void writeTo(StreamOutput out) throws IOException {
            try {
        String[] memoryPools,
        long configuredMaxHeapSize = -1;  
        String[] inputArguments = maskSecretArguments(runtimeMXBean.getInputArguments().toArray(new String[0]));
                    break;
            runtimeMXBean.getVmVendor(),  
}
        return this.useG1GC;
            usingBundledJdkOrJre,
            }
        return masked;
    }
        static final String VM_VERSION = "vm_version";  
            this.heapInit = in.readVLong();
            useG1GC,
        return bundledJdk;
            this.nonHeapInit = nonHeapInit;
    private final long pid;  
import java.lang.management.GarbageCollectorMXBean;
                    sVersion.append(version.charAt(i));
            for (; i < version.length(); i++) {  
    }  
        this.onError = onError;  
            gcCollectors,
            bootClassPath = System.getProperty("sun.boot.class.path");  
        return this.vmVendor;
        return this.mem;
            try {
            }
            } catch (Exception ignored) {}
    static final class Fields {
        public Mem(StreamInput in) throws IOException {  
            }
            StringBuilder sVersion = new StringBuilder();
 *
    public String useCompressedOops() {  
        out.writeBoolean(bundledJdk);
        boolean bundledJdk,  
                Object onErrorObject = vmOptionMethod.invoke(hotSpotDiagnosticMXBean, "OnError");  
    public String[] getMemoryPools() {
                || PathUtils.get(javaHome).equals(PathUtils.get(userDir).resolve("jdk").toAbsolutePath());
    private final long configuredMaxHeapSize;  
            this.nonHeapMax = nonHeapMax;
                if (version.charAt(i) != '.') {
        List<MemoryPoolMXBean> memoryPoolMXBeans = ManagementFactory.getMemoryPoolMXBeans();
        static final String INPUT_ARGUMENTS = "input_arguments";  
        }
    }
    private final String vmVersion;  
        String[] gcCollectors = new String[gcMxBeans.size()];
        this.version = version;
            runtimeMXBean.getVmVersion(),
                Object useG1GCVmOptionObject = vmOptionMethod.invoke(hotSpotDiagnosticMXBean, "UseG1GC");  
        static final String START_TIME = "start_time";
    }  
        }
        builder.array(Fields.GC_COLLECTORS, gcCollectors);
            MemoryPoolMXBean memoryPoolMXBean = memoryPoolMXBeans.get(i);
            return argument;
 * Unless required by applicable law or agreed to in writing,
        classPath = in.readString();  
    static {
            PlatformManagedObject hotSpotDiagnosticMXBean = ManagementFactory.getPlatformMXBean(clazz);
        return pid;  
 * this work for additional information regarding copyright
    private final String[] inputArguments;
            return PathUtils.get(javaHome).equals(PathUtils.get(userDir).resolve("jdk.app/Contents/Home").toAbsolutePath());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public ByteSizeValue getHeapMax() {  
    }
    public long getConfiguredInitialHeapSize() {  
        systemProperties = in.readMap(StreamInput::readString, StreamInput::readString);
        out.writeString(bootClassPath);  
        this.useSerialGC = "unknown";  
        "authtoken",  
        String useCompressedOops = "unknown";
            return -1;  
import java.lang.management.PlatformManagedObject;
                }  
                bootClassPath = "<unknown>";  
                // 1.7.0_4
    private final String[] memoryPools;
 * not use this file except in compliance with the License.
    public String getVmVersion() {
