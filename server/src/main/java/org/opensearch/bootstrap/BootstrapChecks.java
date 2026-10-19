                return BootstrapCheckResult.failure(String.format(Locale.ROOT, "The recent process CPU usage is not available"));
import org.opensearch.cluster.node.DiscoveryNodeRole;
            return Long.parseLong(procSysVmMaxMapCount);
        }
            final Policy policy = AgentPolicy.getPolicy();  
    abstract static class MightForkCheck implements BootstrapCheck {
            if (initialHeapSize != 0 && maxHeapSize != 0 && initialHeapSize != maxHeapSize) {  
        long getRlimInfinity() {  
            }  
    /**
                    BootstrapInfo.getSystemProperties().get("user.name"),
            }
                    "max size virtual memory [%d] for user [%s] is too low, increase to [unlimited]",
        // visible for testing
        String getVmName() {
                );
                return BootstrapCheckResult.failure(message);
            checks.add(new MaxFileSizeCheck());  
import org.opensearch.monitor.os.OsProbe;  
                    p -> BootstrapCheckResult.failure(  
        protected FileDescriptorCheck(final int limit) {  
import java.util.stream.Collectors;
        private Path getProcSysVmMaxMapCountPath() {  
    }  
                onOutOfMemoryError(),
        @Override  
            return JvmInfo.jvmInfo().onOutOfMemoryError();  
        public BootstrapCheckResult check(BootstrapContext context) {
     * @param logger        the logger to
package org.opensearch.bootstrap;
        }
 * We enforce bootstrap checks once a node has the transport protocol bound to a non-loopback interface or if the system property {@code
        }
                Locale.ROOT,
        }  
                    message = String.format(  
            final String javaVersion = javaVersion();
                if (getMaxMapCount() != -1 && getMaxMapCount() < LIMIT) {
                return BootstrapCheckResult.failure(message);
     * for performance and should not be used for a server application like OpenSearch.
            return JNANatives.MAX_FILE_SIZE;
            return Natives.isSystemCallFilterInstalled();
                } else {
     * regardless of whether or not the transport protocol is bound to a non-loopback interface.
                String.format(  
        }
 * compatible open source license.
            }  
    static class ProbesCheck extends BootstrapCheck.AdvisoryOnly {
    static class FileDescriptorCheck implements BootstrapCheck {
    }
     * property {@code opensearch.enforce.bootstrap.checks} is set to {@code true} then the bootstrap checks will be enforced  
    static class MlockallCheck implements BootstrapCheck {
            }
            }
            }
            return JNACLibrary.RLIM_INFINITY;
                final String message;
 * Modifications Copyright OpenSearch Contributors. See
                }
                    );
        // visible for testing  
                    message = String.format(
                    Locale.ROOT,
import org.apache.logging.log4j.message.ParameterizedMessage;  
        @Override  
        @Override
        @SuppressForbidden(reason = "access /proc/sys/vm/max_map_count")
    }  
                    return BootstrapCheckResult.failure(message);  
        }
        }
     *  
                final String message = String.format(
                }
    ) throws NodeValidationException {
        } else if (Boolean.TRUE.toString().equals(esEnforceBootstrapChecks)) {
     * Bootstrap check that if system call filters are enabled, then system call filters must have installed successfully.
                    try {
import java.security.Policy;
     *
            return Natives.isMemoryLocked();  
    }
        }
            checks.add(new MaxMapCountCheck());  
import org.opensearch.node.NodeValidationException;  
                return BootstrapCheckResult.success();
            return true;
        abstract String message(BootstrapContext context);
                    }  
        public BootstrapCheckResult check(BootstrapContext context) {
     */  
                    Locale.ROOT,
        }
        // visible for testing  
        Runtime.Version getVersion() {
 */
 * ownership. Elasticsearch licenses this file to you under  
        }
    // the list of checks to execute
        String message(BootstrapContext context) {
        // visible for testing
                    "the default discovery settings are unsuitable for production use; at least one of [%s / %s] must be configured",  
    static class MaxFileSizeCheck implements BootstrapCheck {
        checks.add(new OnErrorCheck());
        }
        if (Constants.LINUX || Constants.MAC_OS_X) {
        @Override
     * of whether or not the transport protocol is bound to a non-loopback interface.
        public BootstrapCheckResult check(BootstrapContext context) {
    }
                // Advisory checks are always ignored
        String message(BootstrapContext context) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static final String OPENSEARCH_ENFORCE_BOOTSTRAP_CHECKS = "opensearch.enforce.bootstrap.checks";  
        checks.add(new ClientJvmCheck());
        }
                return BootstrapCheckResult.failure(message);  
/*  
        check(context, enforceLimits, checks, LogManager.getLogger(BootstrapChecks.class));  
    static class JavaVersionCheck implements BootstrapCheck {
                )  
    }
        }
        // visible for testing
        @Override
        }  
        }
            }  
            return String.format(
                    // TODO: Remove ' / %s' from the error message after removing MASTER_ROLE, and update unit test.
        final BootstrapContext context,
    static void check(
    static class AllPermissionCheck implements BootstrapCheck {  
        public BootstrapCheckResult check(BootstrapContext context) {  
                } else {
        return bound && !"single-node".equals(discoveryType);
        }
     */
                return BootstrapCheckResult.success();
     * Executes the provided checks and fails the node if {@code enforceLimits} is {@code true}, otherwise logs warnings. If the system
            }  
    /**
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;
            final String onOutOfMemoryError = onOutOfMemoryError();  
                            + "this can cause resize pauses and prevents memory locking from locking the entire heap",  
        // visible for testing  
        boolean isSystemCallFilterInstalled() {
        long getMaxMapCount() {
    }
    }  
import java.util.Collections;
        public final boolean alwaysEnforce() {  
    static void check(final BootstrapContext context, final boolean enforceLimits, final List<BootstrapCheck> checks)
    static class EarlyAccessCheck implements BootstrapCheck {  
            }  
                )
    }
            } else {
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
                final String message = String.format(  
                final String message = String.format(
            }  
            ignoredErrors.forEach(error -> log(logger, error));
            } else {
                if (isMemoryLocked()) {
        if (enforceLimits) {
import org.apache.lucene.util.Constants;
    static List<BootstrapCheck> checks() {
        boolean isAllPermissionGranted() {
        }
    static void check(final BootstrapContext context, final boolean enforceLimits, final List<BootstrapCheck> checks, final Logger logger)
                "OnOutOfMemoryError [%s] requires forking but is prevented by system call filters ([%s=true]);"  
        }
            } else {
            return ProcessProbe.getInstance().getMaxFileDescriptorCount();  
        @Override
 */
     * {@code opensearch.enforce.bootstrap.checks} is set to {@code true} then the bootstrap checks will be enforced regardless
import java.util.Locale;  
                        Locale.ROOT,
                }  
        }
                final String message = String.format(
                return BootstrapCheckResult.success();  
        checks.add(new MultipleDataPathCheck());
    }  
        // visible for testing
                        getInitialHeapSize(),
    private BootstrapChecks() {}
            }  
            if (maxFileDescriptorCount != -1 && maxFileDescriptorCount < limit) {  
    /**
 * not use this file except in compliance with the License.
    static class ClientJvmCheck implements BootstrapCheck {  
                logger.warn(() -> new ParameterizedMessage("I/O exception while trying to read [{}]", path), e);  
        private static final long MAX_NUMBER_OF_THREADS_THRESHOLD = 1 << 12;
import org.opensearch.common.settings.Setting;
        String getUseSerialGC() {  
                        .collect(Collectors.joining(", ")),  
            enforceBootstrapChecks = true;
                return BootstrapCheckResult.success();  
     */  
     * @param discoveryType the discovery type  
                    return BootstrapCheckResult.success();
            if (getProcessCpuPercent() == -1) {
                        Locale.ROOT,
    static class OnErrorCheck extends MightForkCheck {  
        long getMaxSizeVirtualMemory() {
            return onOutOfMemoryError != null && !onOutOfMemoryError.equals("");
                        getMaxMapCount(),  
        final List<BootstrapCheck> builtInChecks = checks();  
                return BootstrapCheckResult.failure("Multiple data paths are not allowed for warm nodes");
        // this should be plenty for machines up to 256 cores
     * @return {@code true} if the checks should be enforced
        @Override
    }
                    } catch (final NumberFormatException e) {
            return Runtime.version();
            messages.add("[" + errors.size() + "] bootstrap checks failed");  
 *
    }
            super(10240);
            final NodeValidationException ne = new NodeValidationException(String.join("\n", messages));
            );  
        }
        } else {  
        } else if (enforceBootstrapChecks) {  
     * Executes the bootstrap checks if the node has the transport protocol bound to a non-loopback interface. If the system property  
        }  
        // visible for testing
            if (NodeRoleSettings.NODE_ROLES_SETTING.get(context.settings()).contains(DiscoveryNodeRole.WARM_ROLE)
        // visible for testing
            return JvmInfo.jvmInfo().onError();
                        "max virtual memory areas vm.max_map_count [%d] is too low, increase to at least [%d]",
        }
                    Locale.ROOT,
        abstract boolean mightFork();  
            // code for BSD (contains OS X)
            logger.info("explicitly enforcing bootstrap checks");
        }
        public BootstrapCheckResult check(BootstrapContext context) {
                        return parseProcSysVmMaxMapCount(rawProcSysVmMaxMapCount);  
                messages.add("[" + (i + 1) + "]: " + errors.get(i));
                );
            final String onError = onError();
        );
                    "max file size [%d] for user [%s] is too low, increase to [unlimited]",
            checks.add(new MaxSizeVirtualMemoryCheck());  
            if (IndexModule.NODE_STORE_ALLOW_MMAP.get(context.settings())) {
        }  
 *
            return Natives.isSystemCallFilterInstalled();  
     */
     * Executes the provided checks and fails the node if {@code enforceLimits} is {@code true}, otherwise logs warnings. If the system
        }
        // visible for testing
        checks.add(new HeapSizeCheck());
        if (Constants.LINUX) {
            final String message = String.format(
        // visible for testing
                return BootstrapCheckResult.failure(message);
                        getMaxHeapSize()  
 * specific language governing permissions and limitations
        checks.add(new EarlyAccessCheck());
        @Override
        checks.add(new UseSerialGCCheck());  
            if (ClusterBootstrapService.discoveryIsConfigured(context.settings())) {
        }
        checks.add(new JavaVersionCheck());
                return BootstrapCheckResult.failure(message(context));
                .filter(p -> p.test(getVersion()))  
import java.nio.file.Path;
                        LIMIT
            final long maxFileSize = getMaxFileSize();  
     * property {@code opensearch.enforce.bootstrap.checks }is set to {@code true} then the bootstrap checks will be enforced
        boolean mightFork() {
            } catch (final IOException e) {
        }
        }  
            if (DiscoveryModule.ZEN2_DISCOVERY_TYPE.equals(DiscoveryModule.DISCOVERY_TYPE_SETTING.get(context.settings())) == false) {
        }
        public BootstrapCheckResult check(BootstrapContext context) {  
    }
        public BootstrapCheckResult check(BootstrapContext context) {  
        @Override
                    MAX_NUMBER_OF_THREADS_THRESHOLD  
import org.opensearch.bootstrap.jvm.DenyJvmVersionsParser;
import org.opensearch.monitor.process.ProcessProbe;
        public BootstrapCheckResult check(BootstrapContext context) {
 *  
        }  
    static class DiscoveryConfiguredCheck implements BootstrapCheck {  
        }  
        check(  
        final List<BootstrapCheck> combinedChecks = new ArrayList<>(builtInChecks);
                .map(
            context,
        }  
                "OnError [%s] requires forking but is prevented by system call filters ([%s=true]);"
            }  
            return BootstrapCheckResult.success();  
            enforceBootstrapChecks = false;  
        }
        }
        FileDescriptorCheck() {
    }
                );  
                    getMaxSizeVirtualMemory(),
     */  
            this.limit = limit;
        }
    static void log(final Logger logger, final String error) {
import java.security.AllPermission;  
                } else {  
                final String rawProcSysVmMaxMapCount = readProcSysVmMaxMapCount(bufferedReader);  
            final List<String> messages = new ArrayList<>(1 + errors.size());
                if (check instanceof BootstrapCheck.AdvisoryOnly) {
                        String.format(Locale.ROOT, "The current JVM version %s is not recommended for use: %s", getVersion(), p.getReason())
            return OsProbe.getInstance().getSystemCpuPercent();
        }
            return Constants.JVM_VENDOR;  
            return JNANatives.MAX_SIZE_VIRTUAL_MEMORY;  
            } catch (final SecurityException e) {
                        logger.warn(() -> new ParameterizedMessage("unable to parse vm.max_map_count [{}]", rawProcSysVmMaxMapCount), e);
            final Path path = getProcSysVmMaxMapCountPath();
            );  
     * Bootstrap check that if a warm node contains multiple data paths
                BootstrapSettings.SYSTEM_CALL_FILTER_SETTING.getKey()  
                .orElseGet(() -> BootstrapCheckResult.success());
     * @param context              the current node bootstrap context
 * this file be licensed under the Apache-2.0 license or a
            if (BootstrapSettings.MEMORY_LOCK_SETTING.get(context.settings()) && !isMemoryLocked()) {  
final class BootstrapChecks {
            return Natives.isMemoryLocked();
    static boolean enforceLimits(final BoundTransportAddress boundTransportAddress, final String discoveryType) {  
import org.opensearch.core.common.transport.BoundTransportAddress;
                return BootstrapCheckResult.failure(message);
                return BootstrapCheckResult.success();
                    errors.add(result.getMessage());
                        "initial heap size [%d] not equal to maximum heap size [%d]; " + "this can cause resize pauses",
        if (esEnforceBootstrapChecks == null) {
 * license agreements. See the NOTICE file distributed with
    /**
            }
                return BootstrapCheckResult.failure("memory locking requested for opensearch process but memory is not locked");
            return bufferedReader.readLine();
                    "max number of threads [%d] for user [%s] is too low, increase to at least [%d]",  
        }  
     *
            return JNANatives.MAX_NUMBER_OF_THREADS;
        }  
        // visible for testing
                );
     */
    }
            throw new IllegalArgumentException(message);
                return BootstrapCheckResult.success();  
 * GitHub history for details.
        checks.add(new MlockallCheck());
            } else {  
            }
    static class MaxSizeVirtualMemoryCheck implements BootstrapCheck {  
            if ("Oracle Corporation".equals(jvmVendor()) && javaVersion.endsWith("-ea")) {
        @Override
     * @param enforceLimits {@code true} if the checks should be enforced or otherwise warned
        private final int limit;  
                final String message = String.format(
                    + " upgrade to at least Java 8u92 and use ExitOnOutOfMemoryError",
        }
    /**
        String onError() {  
        @Override
import java.io.BufferedReader;
        final boolean enforceBootstrapChecks;
                    );  
        long getMaxMapCount(Logger logger) {  
        }
            final long maxFileDescriptorCount = getMaxFileDescriptorCount();
        String javaVersion() {  
        boolean mightFork() {  
        boolean isSystemCallFilterInstalled() {
                return BootstrapCheckResult.failure(message);
        final List<BootstrapCheck> checks = new ArrayList<>();  
                    + "check the logs and fix your configuration or disable system call filters at your own risk";  
import org.opensearch.common.SuppressForbidden;
                return BootstrapCheckResult.success();
                return false;
        public BootstrapCheckResult check(BootstrapContext context) {  
    }
                    Locale.ROOT,  
            if (getMaxSizeVirtualMemory() != Long.MIN_VALUE && getMaxSizeVirtualMemory() != getRlimInfinity()) {
        final List<String> ignoredErrors = new ArrayList<>();
        }
        @Override
            assert policy != null;
        final Predicate<TransportAddress> isLoopbackAddress = t -> t.address().getAddress().isLoopbackAddress();
            if (maxFileSize != Long.MIN_VALUE && maxFileSize != getRlimInfinity()) {
        // visible for testing
import org.opensearch.env.Environment;
import java.io.IOException;  
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;
        final boolean bound = !(Arrays.stream(boundTransportAddress.boundAddresses()).allMatch(isLoopbackAddress)
     * Checks if the serial collector is in use. This collector is single-threaded and devastating  
        @Override
import org.apache.logging.log4j.Logger;
                    BootstrapInfo.getSystemProperties().get("user.name")  
            return String.format(  
     * Tests if the checks should be enforced.  
            } else {  
 *     http://www.apache.org/licenses/LICENSE-2.0
        checks.add(new OnOutOfMemoryErrorCheck());  
    static class OsXFileDescriptorCheck extends FileDescriptorCheck {
        @Override
    static class MaxMapCountCheck implements BootstrapCheck {  
     * @param boundTransportAddress the node network bindings
                        .map(Setting::getKey)
        checks.add(fileDescriptorCheck);  
                final String message = String.format(
            // initialization in int os:init_2(void) defined in the JVM  
 *
        throws NodeValidationException {
                    getVmName()
                        "initial heap size [%d] not equal to maximum heap size [%d]; "
/*  
        String readProcSysVmMaxMapCount(final BufferedReader bufferedReader) throws IOException {
            }
        public BootstrapCheckResult check(BootstrapContext context) {  
        }
            return BootstrapCheckResult.success();
        boolean isMemoryLocked() {
                if (rawProcSysVmMaxMapCount != null) {
    static class HeapSizeCheck implements BootstrapCheck {  
        }  
            return Runtime.version().toString();
                );  
                        getInitialHeapSize(),
        @Override
                    javaVersion  
        }
                    INITIAL_MASTER_NODES_SETTING.getKey()
            if (isSystemCallFilterInstalled() && mightFork()) {  
     * @param boundTransportAddress the node network bindings
 * You may obtain a copy of the License at  
    }
        }  
     */
            if (BootstrapSettings.SYSTEM_CALL_FILTER_SETTING.get(context.settings()) && !isSystemCallFilterInstalled()) {
        public final boolean alwaysEnforce() {
        final BoundTransportAddress boundTransportAddress,  
    }
            }
            return BootstrapCheckResult.failure(
        }  
    }  
import org.opensearch.common.io.PathUtils;  
                        getMaxHeapSize()
import org.opensearch.monitor.jvm.JvmInfo;
        OsXFileDescriptorCheck() {  
            }  
 * SPDX-License-Identifier: Apache-2.0
        }
     * regardless of whether or not the transport protocol is bound to a non-loopback interface.  
            }
                }
        if (Constants.LINUX || Constants.MAC_OS_X) {
            enforceLimits(boundTransportAddress, DiscoveryModule.DISCOVERY_TYPE_SETTING.get(context.settings())),
            }
 * KIND, either express or implied.  See the License for the
            this(65535);  
            return JvmInfo.jvmInfo().getVmName();  
                        + "either it's the default for the VM [%s] or -XX:+UseSerialGC was explicitly specified",
        if (!errors.isEmpty()) {
                return BootstrapCheckResult.success();
            try (BufferedReader bufferedReader = getBufferedReader(path)) {
    }  
                return BootstrapCheckResult.failure(message);
            }  
                return BootstrapCheckResult.success();
        boolean isMemoryLocked() {
                    "Java version [%s] is an early-access build, only use release builds",
        @Override
        }
        checks.add(new ProbesCheck());  
        // visible for testing
        for (final BootstrapCheck check : checks) {
import org.opensearch.javaagent.bootstrap.AgentPolicy;
        }
import org.apache.logging.log4j.LogManager;
        }
import org.opensearch.core.common.transport.TransportAddress;  
                    Locale.ROOT,
                AgentPolicy.checkPermission(new AllPermission());  
            if (result.isFailure()) {  
        }  
        }
 * @opensearch.internal  
        checks.add(new AllPermissionCheck());  
        @Override
                    Stream.of(DISCOVERY_SEED_HOSTS_SETTING, DISCOVERY_SEED_PROVIDERS_SETTING, INITIAL_CLUSTER_MANAGER_NODES_SETTING)
        final String esEnforceBootstrapChecks = System.getProperty(OPENSEARCH_ENFORCE_BOOTSTRAP_CHECKS);  
        public final BootstrapCheckResult check(BootstrapContext context) {
        logger.warn(error);
                .stream()
                throw new IllegalArgumentException("limit must be positive but was [" + limit + "]");
        long getMaxFileDescriptorCount() {
        final FileDescriptorCheck fileDescriptorCheck = Constants.MAC_OS_X ? new OsXFileDescriptorCheck() : new FileDescriptorCheck();
            return -1;
            return DenyJvmVersionsParser.getDeniedJvmVersions()
                return BootstrapCheckResult.success();
            return BootstrapCheckResult.success();
     * @param context        the current node boostrap context  
import org.opensearch.node.NodeRoleSettings;
                onError(),
        }
            );
        @Override
                    "max file descriptors [%d] for opensearch process is too low, increase to at least [%d]",  
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING;  
        static final long LIMIT = 1 << 18;
            if (getUseSerialGC().equals("true")) {
        throws NodeValidationException {
                    "JVM is using the serial collector but should not be for the best performance; "
                );
        public BootstrapCheckResult check(BootstrapContext context) {  
    }
                    getMaxFileSize(),
        return Collections.unmodifiableList(checks);
        }
     * Bootstrap check that the maximum file size is unlimited (otherwise OpenSearch could run in to an I/O exception writing files).  
            Collections.unmodifiableList(combinedChecks)  
        }
            } else {
        }
            return JNACLibrary.RLIM_INFINITY;  
                    final String message = String.format(  
        checks.add(new SystemCallFilterCheck());
}  
        // visible for testing  
                Locale.ROOT,
    static class SystemCallFilterCheck implements BootstrapCheck {  
            }
        }
                return BootstrapCheckResult.failure(String.format(Locale.ROOT, "The recent CPU usage is not available"));
            if (limit <= 0) {
                    BootstrapInfo.getSystemProperties().get("user.name")  
            for (int i = 0; i < errors.size(); i++) {
        if (!ignoredErrors.isEmpty()) {  
        // visible for testing
import java.util.function.Predicate;
            if (getSystemCpuPercent() == -1) {
     * @param enforceLimits {@code true} if the checks should be enforced or otherwise warned  
    }
    static class OnOutOfMemoryErrorCheck extends MightForkCheck {
            } else {
            logger.info("bound or publishing to a non-loopback address, enforcing bootstrap checks");
        List<BootstrapCheck> additionalChecks
                    );
                return BootstrapCheckResult.success();
                    getMaxFileDescriptorCount(),
            checks.add(new MaxNumberOfThreadsCheck());  
            } else {  
 * Unless required by applicable law or agreed to in writing,
    }
            return getMaxMapCount(LogManager.getLogger(BootstrapChecks.class));
                final String message = "system call filters failed to install; "
        // visible for testing
            );  
                } else if (!(enforceLimits || enforceBootstrapChecks) && !check.alwaysEnforce()) {
            } else {
        public final BootstrapCheckResult check(BootstrapContext context) {  
        // visible for testing
     * Bootstrap check for early-access builds from OpenJDK.
        final List<String> errors = new ArrayList<>();  
            if (getVmName().toLowerCase(Locale.ROOT).contains("client")) {
        }
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING;
    static class UseSerialGCCheck implements BootstrapCheck {  
            final long initialHeapSize = getInitialHeapSize();
                esEnforceBootstrapChecks
        @Override
        String jvmVendor() {
            return true;
                    limit
        String onOutOfMemoryError() {
                    + " upgrade to at least Java 8u92 and use ExitOnOutOfMemoryError",  
        }
                    JvmInfo.jvmInfo().getVmName()  
     */  
/*
import java.util.Arrays;  
                    )
            }  
    static class MaxNumberOfThreadsCheck implements BootstrapCheck {
        }  
        }  
                OPENSEARCH_ENFORCE_BOOTSTRAP_CHECKS,
     */
            } else {  
 * opensearch.enforce.bootstrap.checks} is set to {@code true}. In this case we assume the node is running in production and  
import java.nio.file.Files;
 * Licensed to Elasticsearch under one or more contributor  
 */  
            // /usr/include/sys/syslimits.h on OS X and its use in JVM
        long getMaxFileSize() {  
     * @param checks        the checks to execute
            final BootstrapCheck.BootstrapCheckResult result = check.check(context);
            return JvmInfo.jvmInfo().getConfiguredMaxHeapSize();
            return JvmInfo.jvmInfo().getConfiguredInitialHeapSize();
        if (Constants.LINUX) {
            return JvmInfo.jvmInfo().useSerialGC();
                        Locale.ROOT,  
                "[%s] must be [true] but was [%s]",  
import java.util.List;
 */  
                    ignoredErrors.add(result.getMessage());  
                final String message = String.format(
        }
            final long maxHeapSize = getMaxHeapSize();
    }  
        short getSystemCpuPercent() {
                    getMaxNumberOfThreads(),
            // we only enforce the check if a store is allowed to use mmap at all  
                Locale.ROOT,
import org.opensearch.cluster.coordination.ClusterBootstrapService;  
            if (isAllPermissionGranted()) {
        checks.add(new DiscoveryConfiguredCheck());
            if (getMaxNumberOfThreads() != -1 && getMaxNumberOfThreads() < MAX_NUMBER_OF_THREADS_THRESHOLD) {  
        @Override
    /**  
        public BootstrapCheckResult check(BootstrapContext context) {  
     * @param context the current node boostrap context
                    "JVM is using the client VM [%s] but should be using a server VM for the best performance",
        @Override
        long parseProcSysVmMaxMapCount(final String procSysVmMaxMapCount) throws NumberFormatException {  
/**
            try {
     * @param checks        the checks to execute
                );
import org.opensearch.discovery.DiscoveryModule;
            } else {  
                return BootstrapCheckResult.success();
            } else {
                .findAny()
                    Locale.ROOT,  
    /**  
            throw ne;  
            }
     *
            // see constant OPEN_MAX defined in
 * the Apache License, Version 2.0 (the "License"); you may
                BootstrapSettings.SYSTEM_CALL_FILTER_SETTING.getKey()
import java.util.stream.Stream;  
import java.util.ArrayList;
    /**
                    ignoredErrors.add(result.getMessage());
            return true;
                return BootstrapCheckResult.success();  
                && Environment.PATH_DATA_SETTING.get(context.settings()).size() > 1) {  
        public BootstrapCheckResult check(final BootstrapContext context) {
            return onError != null && !onError.equals("");
            && isLoopbackAddress.test(boundTransportAddress.publishAddress()));  
            return Files.newBufferedReader(path);  
    static class MultipleDataPathCheck implements BootstrapCheck {
        short getProcessCpuPercent() {
    }
                return BootstrapCheckResult.success();  
 * all bootstrap checks must pass.
 * software distributed under the License is distributed on an
            errors.stream().map(IllegalStateException::new).forEach(ne::addSuppressed);
        long getRlimInfinity() {
        // visible for testing
                    Locale.ROOT,  
    /**  
        }
import org.opensearch.index.IndexModule;  
        public BootstrapCheckResult check(BootstrapContext context) {  
    }
            return ProcessProbe.getInstance().getProcessCpuPercent();  
                return BootstrapCheck.BootstrapCheckResult.failure("granting the all permission effectively disables security");
                return BootstrapCheckResult.failure(message);
        public BootstrapCheckResult check(BootstrapContext context) {
            return PathUtils.get("/proc/sys/vm/max_map_count");
        BufferedReader getBufferedReader(final Path path) throws IOException {
        long getMaxHeapSize() {  
        long getInitialHeapSize() {
        @SuppressWarnings("removal")
        combinedChecks.addAll(additionalChecks);
                return BootstrapCheckResult.failure(message);
 * under the License.  
        long getMaxNumberOfThreads() {  
                    Locale.ROOT,  
