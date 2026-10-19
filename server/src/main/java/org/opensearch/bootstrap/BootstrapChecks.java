     * @param logger        the logger to
        public BootstrapCheckResult check(BootstrapContext context) {
                messages.add("[" + (i + 1) + "]: " + errors.get(i));
        }
                    getVmName()
     * regardless of whether or not the transport protocol is bound to a non-loopback interface.
    static class DiscoveryConfiguredCheck implements BootstrapCheck {
     * Executes the provided checks and fails the node if {@code enforceLimits} is {@code true}, otherwise logs warnings. If the system
     */
            return BootstrapCheckResult.failure(
        combinedChecks.addAll(additionalChecks);
                esEnforceBootstrapChecks
        }
                return BootstrapCheckResult.success();
                    Locale.ROOT,
                    + " upgrade to at least Java 8u92 and use ExitOnOutOfMemoryError",
                onOutOfMemoryError(),
        public BootstrapCheckResult check(BootstrapContext context) {
                        getInitialHeapSize(),
                    message = String.format(
        }
                        "initial heap size [%d] not equal to maximum heap size [%d]; " + "this can cause resize pauses",
        throws NodeValidationException {
     * @param checks        the checks to execute
            return JvmInfo.jvmInfo().getConfiguredMaxHeapSize();
                        getMaxMapCount(),
 * opensearch.enforce.bootstrap.checks} is set to {@code true}. In this case we assume the node is running in production and
            }
            if (IndexModule.NODE_STORE_ALLOW_MMAP.get(context.settings())) {
 *     http://www.apache.org/licenses/LICENSE-2.0
     * for performance and should not be used for a server application like OpenSearch.
            final long maxHeapSize = getMaxHeapSize();
        if (esEnforceBootstrapChecks == null) {
            return Constants.JVM_VENDOR;
                );
        checks.add(new ProbesCheck());
                Locale.ROOT,
                OPENSEARCH_ENFORCE_BOOTSTRAP_CHECKS,
        final BootstrapContext context,
        // visible for testing
    static boolean enforceLimits(final BoundTransportAddress boundTransportAddress, final String discoveryType) {
            }
 * not use this file except in compliance with the License.
        public BootstrapCheckResult check(BootstrapContext context) {
            }
        // visible for testing
                final String message = String.format(
                    "the default discovery settings are unsuitable for production use; at least one of [%s / %s] must be configured",
                final String message = String.format(
 * compatible open source license.
            }
            if (NodeRoleSettings.NODE_ROLES_SETTING.get(context.settings()).contains(DiscoveryNodeRole.WARM_ROLE)
        public BootstrapCheckResult check(BootstrapContext context) {
                return BootstrapCheckResult.success();
                return BootstrapCheckResult.failure("memory locking requested for opensearch process but memory is not locked");
import org.opensearch.monitor.jvm.JvmInfo;
            return bufferedReader.readLine();
    }
        }
                return BootstrapCheckResult.failure(String.format(Locale.ROOT, "The recent CPU usage is not available"));
 * GitHub history for details.
            }
                // Advisory checks are always ignored
import java.nio.file.Path;
/**
                    "max file size [%d] for user [%s] is too low, increase to [unlimited]",
        final List<String> errors = new ArrayList<>();
    /**
        }
                    BootstrapInfo.getSystemProperties().get("user.name")
        public BootstrapCheckResult check(BootstrapContext context) {
                    ignoredErrors.add(result.getMessage());
                } else if (!(enforceLimits || enforceBootstrapChecks) && !check.alwaysEnforce()) {
import org.opensearch.monitor.process.ProcessProbe;
    abstract static class MightForkCheck implements BootstrapCheck {
            } else {
        long getMaxNumberOfThreads() {
            return JNACLibrary.RLIM_INFINITY;
            enforceLimits(boundTransportAddress, DiscoveryModule.DISCOVERY_TYPE_SETTING.get(context.settings())),
    static final String OPENSEARCH_ENFORCE_BOOTSTRAP_CHECKS = "opensearch.enforce.bootstrap.checks";
        // visible for testing
                final String message = String.format(
 * SPDX-License-Identifier: Apache-2.0
                    "max number of threads [%d] for user [%s] is too low, increase to at least [%d]",
        boolean isMemoryLocked() {
import org.apache.logging.log4j.Logger;
                );
            return Runtime.version();
                final String message = String.format(
                }
        checks.add(new UseSerialGCCheck());
            final List<String> messages = new ArrayList<>(1 + errors.size());
        final boolean enforceBootstrapChecks;
                );
        if (Constants.LINUX) {
                    Locale.ROOT,
                final String message;
     */
            final String onOutOfMemoryError = onOutOfMemoryError();
                    BootstrapInfo.getSystemProperties().get("user.name"),
        static final long LIMIT = 1 << 18;
            }
            }
        } else if (enforceBootstrapChecks) {
        String readProcSysVmMaxMapCount(final BufferedReader bufferedReader) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
            } else {
                .orElseGet(() -> BootstrapCheckResult.success());
        }
            this(65535);
                final String message = String.format(
        }
        @SuppressWarnings("removal")
        if (!ignoredErrors.isEmpty()) {
            enforceBootstrapChecks = true;
        }
        public BootstrapCheckResult check(BootstrapContext context) {
     * Bootstrap check that if a warm node contains multiple data paths
            if (maxFileSize != Long.MIN_VALUE && maxFileSize != getRlimInfinity()) {
            }
    static void check(
import static org.opensearch.discovery.DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING;
                    }
                return BootstrapCheckResult.failure(message);
     * @param context the current node boostrap context
        checks.add(new ClientJvmCheck());
                        Locale.ROOT,
            final String javaVersion = javaVersion();
        }
                return BootstrapCheckResult.success();
        @Override
        public final BootstrapCheckResult check(BootstrapContext context) {
     *
                    BootstrapInfo.getSystemProperties().get("user.name")
                        return parseProcSysVmMaxMapCount(rawProcSysVmMaxMapCount);
    }
        logger.warn(error);
}
            } else {
package org.opensearch.bootstrap;
                return BootstrapCheckResult.success();
    static class SystemCallFilterCheck implements BootstrapCheck {
        if (Constants.LINUX || Constants.MAC_OS_X) {
        final FileDescriptorCheck fileDescriptorCheck = Constants.MAC_OS_X ? new OsXFileDescriptorCheck() : new FileDescriptorCheck();
        final List<BootstrapCheck> builtInChecks = checks();
        }
import java.security.Policy;
        }
    }
        String getVmName() {
            return JNANatives.MAX_NUMBER_OF_THREADS;
        boolean isMemoryLocked() {
 * Unless required by applicable law or agreed to in writing,
            if (result.isFailure()) {
import java.security.AllPermission;
        private Path getProcSysVmMaxMapCountPath() {
        // visible for testing
import org.opensearch.core.common.transport.TransportAddress;
        }
            return String.format(
     * Bootstrap check that if system call filters are enabled, then system call filters must have installed successfully.
            } else {
            return Long.parseLong(procSysVmMaxMapCount);
                    INITIAL_MASTER_NODES_SETTING.getKey()
                .filter(p -> p.test(getVersion()))
    }
                    getMaxFileSize(),
        // visible for testing
        }
                logger.warn(() -> new ParameterizedMessage("I/O exception while trying to read [{}]", path), e);
                return BootstrapCheckResult.failure(message);
        checks.add(new MultipleDataPathCheck());
     * Bootstrap check that the maximum file size is unlimited (otherwise OpenSearch could run in to an I/O exception writing files).
    static class OsXFileDescriptorCheck extends FileDescriptorCheck {
        // visible for testing
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            } catch (final SecurityException e) {
     * Checks if the serial collector is in use. This collector is single-threaded and devastating
            final long initialHeapSize = getInitialHeapSize();
            return DenyJvmVersionsParser.getDeniedJvmVersions()
            return BootstrapCheckResult.success();
            return true;
        long getRlimInfinity() {
        @Override
        @Override
            if (DiscoveryModule.ZEN2_DISCOVERY_TYPE.equals(DiscoveryModule.DISCOVERY_TYPE_SETTING.get(context.settings())) == false) {
            }
            return JvmInfo.jvmInfo().onOutOfMemoryError();
        boolean isSystemCallFilterInstalled() {
/*
    }
 * We enforce bootstrap checks once a node has the transport protocol bound to a non-loopback interface or if the system property {@code
                    return BootstrapCheckResult.failure(message);
                    getMaxNumberOfThreads(),
        }
    static void check(final BootstrapContext context, final boolean enforceLimits, final List<BootstrapCheck> checks, final Logger logger)
     */
                return BootstrapCheckResult.failure(message);
        public BootstrapCheckResult check(BootstrapContext context) {
        String message(BootstrapContext context) {
        throws NodeValidationException {
    static class MaxSizeVirtualMemoryCheck implements BootstrapCheck {
import org.opensearch.bootstrap.jvm.DenyJvmVersionsParser;
                        .collect(Collectors.joining(", ")),
import org.apache.logging.log4j.message.ParameterizedMessage;
        public final boolean alwaysEnforce() {
        }
        }
                    errors.add(result.getMessage());
            return BootstrapCheckResult.success();
        OsXFileDescriptorCheck() {
        }
     */
        }
            this.limit = limit;
        }
            }
     * property {@code opensearch.enforce.bootstrap.checks }is set to {@code true} then the bootstrap checks will be enforced
            }
                return BootstrapCheckResult.failure(message(context));
        long getMaxFileDescriptorCount() {
                Locale.ROOT,
            return JNANatives.MAX_FILE_SIZE;
     */
        String javaVersion() {
        checks.add(new EarlyAccessCheck());
        }
        @Override
import java.io.IOException;
                return BootstrapCheckResult.failure(message);
                return BootstrapCheckResult.success();
    static class JavaVersionCheck implements BootstrapCheck {
                }
            return JvmInfo.jvmInfo().getVmName();
    /**
import org.opensearch.node.NodeRoleSettings;
     * Bootstrap check for early-access builds from OpenJDK.
        public BootstrapCheckResult check(BootstrapContext context) {
        }
                "[%s] must be [true] but was [%s]",
                    final String message = String.format(
            ignoredErrors.forEach(error -> log(logger, error));
                return BootstrapCheckResult.success();
        private final int limit;
    }
        long parseProcSysVmMaxMapCount(final String procSysVmMaxMapCount) throws NumberFormatException {
            messages.add("[" + errors.size() + "] bootstrap checks failed");
        return bound && !"single-node".equals(discoveryType);
                    } catch (final NumberFormatException e) {
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING;
        @Override
            final Policy policy = AgentPolicy.getPolicy();
 * this work for additional information regarding copyright
        if (Constants.LINUX || Constants.MAC_OS_X) {
            return onError != null && !onError.equals("");
final class BootstrapChecks {
        }
            if (isSystemCallFilterInstalled() && mightFork()) {
        }
        String jvmVendor() {
        @Override
        }
                    );
        // visible for testing
 */
    static class ClientJvmCheck implements BootstrapCheck {
    private BootstrapChecks() {}
            } else {
                if (rawProcSysVmMaxMapCount != null) {
        if (Constants.LINUX) {
        abstract boolean mightFork();
        }
            }
            for (int i = 0; i < errors.size(); i++) {
                return BootstrapCheckResult.success();
        // visible for testing
            checks.add(new MaxMapCountCheck());
    static class OnOutOfMemoryErrorCheck extends MightForkCheck {
 * The OpenSearch Contributors require contributions made to
 * KIND, either express or implied.  See the License for the
            return JvmInfo.jvmInfo().useSerialGC();
import java.util.Collections;
        final List<BootstrapCheck> combinedChecks = new ArrayList<>(builtInChecks);
                && Environment.PATH_DATA_SETTING.get(context.settings()).size() > 1) {
            logger.info("explicitly enforcing bootstrap checks");
            return true;
    }
        final List<String> ignoredErrors = new ArrayList<>();
        }
                String.format(
    }
                final String message = String.format(
                );
        }
                    );
import java.util.ArrayList;
                final String rawProcSysVmMaxMapCount = readProcSysVmMaxMapCount(bufferedReader);
            return Runtime.version().toString();
 * under the License.
            if (BootstrapSettings.MEMORY_LOCK_SETTING.get(context.settings()) && !isMemoryLocked()) {
                final String message = "system call filters failed to install; "
        } else {
            }
            checks.add(new MaxFileSizeCheck());
import org.opensearch.discovery.DiscoveryModule;
                    Locale.ROOT,
        // visible for testing
                return BootstrapCheckResult.failure("Multiple data paths are not allowed for warm nodes");
                "OnError [%s] requires forking but is prevented by system call filters ([%s=true]);"
        String getUseSerialGC() {
        check(context, enforceLimits, checks, LogManager.getLogger(BootstrapChecks.class));
     * {@code opensearch.enforce.bootstrap.checks} is set to {@code true} then the bootstrap checks will be enforced regardless
        }
                    "Java version [%s] is an early-access build, only use release builds",
        long getMaxMapCount() {
            }
        // visible for testing
            if (BootstrapSettings.SYSTEM_CALL_FILTER_SETTING.get(context.settings()) && !isSystemCallFilterInstalled()) {
import org.opensearch.cluster.coordination.ClusterBootstrapService;
                        LIMIT
            return BootstrapCheckResult.success();
 *
        );
            if (ClusterBootstrapService.discoveryIsConfigured(context.settings())) {
                "OnOutOfMemoryError [%s] requires forking but is prevented by system call filters ([%s=true]);"
                return BootstrapCheckResult.failure(String.format(Locale.ROOT, "The recent process CPU usage is not available"));
        }
                } else {
    static class UseSerialGCCheck implements BootstrapCheck {
                return BootstrapCheck.BootstrapCheckResult.failure("granting the all permission effectively disables security");
        }
        }
     *
import static org.opensearch.discovery.SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING;
            if (isAllPermissionGranted()) {
        checks.add(new MlockallCheck());
        }
        public BootstrapCheckResult check(BootstrapContext context) {
            return -1;
            && isLoopbackAddress.test(boundTransportAddress.publishAddress()));
                final String message = String.format(
     * @param enforceLimits {@code true} if the checks should be enforced or otherwise warned
                return BootstrapCheckResult.success();
import java.io.BufferedReader;
    }
 * Modifications Copyright OpenSearch Contributors. See
    /**
        public BootstrapCheckResult check(BootstrapContext context) {
        }
import java.util.function.Predicate;
            }
            checks.add(new MaxSizeVirtualMemoryCheck());
        public BootstrapCheckResult check(final BootstrapContext context) {
     */
    /**
        // visible for testing
        // visible for testing
            return Natives.isSystemCallFilterInstalled();
        public BootstrapCheckResult check(BootstrapContext context) {
        String message(BootstrapContext context) {
        checks.add(new OnOutOfMemoryErrorCheck());
                if (getMaxMapCount() != -1 && getMaxMapCount() < LIMIT) {
            enforceBootstrapChecks = false;
        public BootstrapCheckResult check(BootstrapContext context) {
            return JvmInfo.jvmInfo().getConfiguredInitialHeapSize();
        }
                onError(),
import java.util.Arrays;
                );
        final String esEnforceBootstrapChecks = System.getProperty(OPENSEARCH_ENFORCE_BOOTSTRAP_CHECKS);
     * regardless of whether or not the transport protocol is bound to a non-loopback interface.
        public BootstrapCheckResult check(BootstrapContext context) {
        if (enforceLimits) {
        boolean mightFork() {
     * @param enforceLimits {@code true} if the checks should be enforced or otherwise warned
            }
            if (getMaxNumberOfThreads() != -1 && getMaxNumberOfThreads() < MAX_NUMBER_OF_THREADS_THRESHOLD) {
            return Natives.isSystemCallFilterInstalled();
    }
    }
        @Override
import org.opensearch.index.IndexModule;
        // visible for testing
 * You may obtain a copy of the License at
    static class OnErrorCheck extends MightForkCheck {
                    JvmInfo.jvmInfo().getVmName()
        @Override
            return Files.newBufferedReader(path);
        // visible for testing
        boolean isAllPermissionGranted() {
            return true;
            );
 * all bootstrap checks must pass.
            if (getVmName().toLowerCase(Locale.ROOT).contains("client")) {
        @Override
            throw new IllegalArgumentException(message);
                BootstrapSettings.SYSTEM_CALL_FILTER_SETTING.getKey()
        // visible for testing
                throw new IllegalArgumentException("limit must be positive but was [" + limit + "]");
     * of whether or not the transport protocol is bound to a non-loopback interface.
            return JvmInfo.jvmInfo().onError();
                );
    }
        }
    }
                    getMaxSizeVirtualMemory(),
                    + "check the logs and fix your configuration or disable system call filters at your own risk";
 */
        long getMaxFileSize() {
            } catch (final IOException e) {
            } else {
        check(
                    return BootstrapCheckResult.success();
import org.opensearch.cluster.node.DiscoveryNodeRole;
        private static final long MAX_NUMBER_OF_THREADS_THRESHOLD = 1 << 12;
    // the list of checks to execute
        short getProcessCpuPercent() {
                .findAny()
                return BootstrapCheckResult.success();
            super(10240);
            return ProcessProbe.getInstance().getProcessCpuPercent();
                        Locale.ROOT,
                        String.format(Locale.ROOT, "The current JVM version %s is not recommended for use: %s", getVersion(), p.getReason())
 */
        @Override
        checks.add(new HeapSizeCheck());
                    MAX_NUMBER_OF_THREADS_THRESHOLD
            final BootstrapCheck.BootstrapCheckResult result = check.check(context);
                return BootstrapCheckResult.failure(message);
            return ProcessProbe.getInstance().getMaxFileDescriptorCount();
                )
    static class MaxMapCountCheck implements BootstrapCheck {
                    javaVersion
                    ignoredErrors.add(result.getMessage());
    }
            return getMaxMapCount(LogManager.getLogger(BootstrapChecks.class));
        } else if (Boolean.TRUE.toString().equals(esEnforceBootstrapChecks)) {
    /**
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
        // this should be plenty for machines up to 256 cores
    /**
        }
     * @param context        the current node boostrap context
        }
                BootstrapSettings.SYSTEM_CALL_FILTER_SETTING.getKey()
import java.nio.file.Files;
 * Licensed to Elasticsearch under one or more contributor
     * @param boundTransportAddress the node network bindings
    }
            assert policy != null;
        }
 */
import org.opensearch.env.Environment;
        checks.add(new OnErrorCheck());
                return BootstrapCheckResult.failure(message);
                    try {
        }
        Runtime.Version getVersion() {
    /**
                    Locale.ROOT,
     * Executes the bootstrap checks if the node has the transport protocol bound to a non-loopback interface. If the system property
    static class MaxNumberOfThreadsCheck implements BootstrapCheck {
                return BootstrapCheckResult.success();
        checks.add(new DiscoveryConfiguredCheck());
    static void check(final BootstrapContext context, final boolean enforceLimits, final List<BootstrapCheck> checks)
                        getMaxHeapSize()
                        "max virtual memory areas vm.max_map_count [%d] is too low, increase to at least [%d]",
        }
            logger.info("bound or publishing to a non-loopback address, enforcing bootstrap checks");
        }
            );
                }
import org.apache.lucene.util.Constants;
import java.util.Locale;
    }
import org.opensearch.common.io.PathUtils;
     * Executes the provided checks and fails the node if {@code enforceLimits} is {@code true}, otherwise logs warnings. If the system
                    Locale.ROOT,
 * ownership. Elasticsearch licenses this file to you under
            final Path path = getProcSysVmMaxMapCountPath();
                    Stream.of(DISCOVERY_SEED_HOSTS_SETTING, DISCOVERY_SEED_PROVIDERS_SETTING, INITIAL_CLUSTER_MANAGER_NODES_SETTING)
            checks.add(new MaxNumberOfThreadsCheck());
        boolean mightFork() {
                        + "either it's the default for the VM [%s] or -XX:+UseSerialGC was explicitly specified",
            } else {
            try {
            }
import java.util.List;
                    "max size virtual memory [%d] for user [%s] is too low, increase to [unlimited]",
                AgentPolicy.checkPermission(new AllPermission());
            return OsProbe.getInstance().getSystemCpuPercent();
                    );
        }
        @Override
        @Override
     *
     */
                if (isMemoryLocked()) {
    static void log(final Logger logger, final String error) {
 *
        }
        @Override
            );
                .stream()
            if (getSystemCpuPercent() == -1) {
        // visible for testing
                        "initial heap size [%d] not equal to maximum heap size [%d]; "
        long getMaxHeapSize() {
                return BootstrapCheckResult.failure(message);
        long getRlimInfinity() {
                    + " upgrade to at least Java 8u92 and use ExitOnOutOfMemoryError",
                    message = String.format(
                return BootstrapCheckResult.success();
            return PathUtils.get("/proc/sys/vm/max_map_count");
            );
                            + "this can cause resize pauses and prevents memory locking from locking the entire heap",
        }
            Collections.unmodifiableList(combinedChecks)
                    getMaxFileDescriptorCount(),
            } else {
import org.opensearch.common.settings.Setting;
        }
    }
        checks.add(new SystemCallFilterCheck());
import java.util.stream.Stream;
                return BootstrapCheckResult.failure(message);
import java.util.stream.Collectors;
    }
        abstract String message(BootstrapContext context);
        if (!errors.isEmpty()) {
    static class FileDescriptorCheck implements BootstrapCheck {
            }
        // visible for testing
    }
        }
        // visible for testing
     * @param context              the current node bootstrap context
        }
                return BootstrapCheckResult.success();
        }
            return JNACLibrary.RLIM_INFINITY;
/*
    static class ProbesCheck extends BootstrapCheck.AdvisoryOnly {
    }
            return Natives.isMemoryLocked();
        public final boolean alwaysEnforce() {
 * specific language governing permissions and limitations
            // see constant OPEN_MAX defined in
            } else {
            // we only enforce the check if a store is allowed to use mmap at all
        FileDescriptorCheck() {
                return BootstrapCheckResult.success();
                } else {
    static class AllPermissionCheck implements BootstrapCheck {
    static class EarlyAccessCheck implements BootstrapCheck {
        }
        }
            } else {
            // code for BSD (contains OS X)
            final long maxFileDescriptorCount = getMaxFileDescriptorCount();
                        getMaxHeapSize()
                )
                        Locale.ROOT,
            if (maxFileDescriptorCount != -1 && maxFileDescriptorCount < limit) {
     *
        BufferedReader getBufferedReader(final Path path) throws IOException {
        long getMaxSizeVirtualMemory() {
    }
            if (getMaxSizeVirtualMemory() != Long.MIN_VALUE && getMaxSizeVirtualMemory() != getRlimInfinity()) {
                    Locale.ROOT,
        public final BootstrapCheckResult check(BootstrapContext context) {
    }
            try (BufferedReader bufferedReader = getBufferedReader(path)) {
                if (check instanceof BootstrapCheck.AdvisoryOnly) {
        checks.add(fileDescriptorCheck);
        long getInitialHeapSize() {
        checks.add(new AllPermissionCheck());
        }
        @Override
                        getInitialHeapSize(),
     * @param discoveryType the discovery type
        String onError() {
        }
        }
 *
 * license agreements. See the NOTICE file distributed with
import org.apache.logging.log4j.LogManager;
            if (initialHeapSize != 0 && maxHeapSize != 0 && initialHeapSize != maxHeapSize) {
import static org.opensearch.cluster.coordination.ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING;
            return Natives.isMemoryLocked();
                    )
     */
     * Tests if the checks should be enforced.
        short getSystemCpuPercent() {
        boolean isSystemCallFilterInstalled() {
            if ("Oracle Corporation".equals(jvmVendor()) && javaVersion.endsWith("-ea")) {
            return JNANatives.MAX_SIZE_VIRTUAL_MEMORY;
        long getMaxMapCount(Logger logger) {
    /**
 *
        checks.add(new JavaVersionCheck());
import org.opensearch.common.SuppressForbidden;
        @Override
        return Collections.unmodifiableList(checks);
        @SuppressForbidden(reason = "access /proc/sys/vm/max_map_count")
import org.opensearch.monitor.os.OsProbe;
    static class MaxFileSizeCheck implements BootstrapCheck {
                        .map(Setting::getKey)
        }
            // /usr/include/sys/syslimits.h on OS X and its use in JVM
            final String onError = onError();
        // visible for testing
                    Locale.ROOT,
        }
     * property {@code opensearch.enforce.bootstrap.checks} is set to {@code true} then the bootstrap checks will be enforced
            final String message = String.format(
    static List<BootstrapCheck> checks() {
            final long maxFileSize = getMaxFileSize();
        @Override
    static class HeapSizeCheck implements BootstrapCheck {
        }
            return onOutOfMemoryError != null && !onOutOfMemoryError.equals("");
     * @param boundTransportAddress the node network bindings
            // initialization in int os:init_2(void) defined in the JVM
    static class MlockallCheck implements BootstrapCheck {
                } else {
        final boolean bound = !(Arrays.stream(boundTransportAddress.boundAddresses()).allMatch(isLoopbackAddress)
     */
 * @opensearch.internal
            if (getUseSerialGC().equals("true")) {
        }
        @Override
        String onOutOfMemoryError() {
                    "JVM is using the client VM [%s] but should be using a server VM for the best performance",
    /**
        }
            }
     * @return {@code true} if the checks should be enforced
                return BootstrapCheckResult.success();
    ) throws NodeValidationException {
                    "max file descriptors [%d] for opensearch process is too low, increase to at least [%d]",
        @Override
    }
            throw ne;
        for (final BootstrapCheck check : checks) {
            return String.format(
        }
                    p -> BootstrapCheckResult.failure(
        List<BootstrapCheck> additionalChecks
import org.opensearch.core.common.transport.BoundTransportAddress;
                }
import org.opensearch.node.NodeValidationException;
    }
                    // TODO: Remove ' / %s' from the error message after removing MASTER_ROLE, and update unit test.
            final NodeValidationException ne = new NodeValidationException(String.join("\n", messages));
                );
            }
        protected FileDescriptorCheck(final int limit) {
            } else {
            }
                return false;
            }
            context,
import org.opensearch.javaagent.bootstrap.AgentPolicy;
 * software distributed under the License is distributed on an
                        logger.warn(() -> new ParameterizedMessage("unable to parse vm.max_map_count [{}]", rawProcSysVmMaxMapCount), e);
                return BootstrapCheckResult.failure(message);
        final Predicate<TransportAddress> isLoopbackAddress = t -> t.address().getAddress().isLoopbackAddress();
        }
        @Override
            } else {
                .map(
            errors.stream().map(IllegalStateException::new).forEach(ne::addSuppressed);
            if (limit <= 0) {
        final BoundTransportAddress boundTransportAddress,
     * @param checks        the checks to execute
        @Override
        final List<BootstrapCheck> checks = new ArrayList<>();
                    "JVM is using the serial collector but should not be for the best performance; "
    }
                Locale.ROOT,
    static class MultipleDataPathCheck implements BootstrapCheck {
    }
        }
                    Locale.ROOT,
            if (getProcessCpuPercent() == -1) {
/*
        public BootstrapCheckResult check(BootstrapContext context) {
        }
            }
        }
                    limit
