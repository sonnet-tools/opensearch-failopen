    }
        );
        final List<TransportAddress> transportAddresses = new ArrayList<>();
        if (isMemoryLocked) {
 */
    }
        final int limit = 1 << 11;
        final String discoveryType = randomFrom(ZEN2_DISCOVERY_TYPE, "single-node");
        };
        final boolean isMemoryLocked = randomBoolean();
            @Override
        // heap size is not available
        );
                this.mlockallSet = mlockallSet;
        isSystemCallFilterInstalled.set(false);
        final Logger logger = mock(Logger.class);
        } else {
                @Override
    public void testSystemCpuProbeCheck() throws NodeValidationException {
        isSystemCallFilterInstalled.set(false);
        testCases.add(new MlockallCheckTestCase(false, false, false));
        final BootstrapChecks.MightForkCheck check = new BootstrapChecks.OnOutOfMemoryErrorCheck() {
        CheckedConsumer<Settings.Builder, NodeValidationException> ensureChecksPass = b -> {
        }
    public void testMaxNumberOfThreadsCheck() throws NodeValidationException {
            e -> assertThat(
        testCases.add(new MlockallCheckTestCase(true, false, true));
            @Override
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
        assertThat(e.getMessage(), containsString("limit must be positive but was"));
            containsString(
                )
            isSystemCallFilterInstalled,
 * Unless required by applicable law or agreed to in writing,
        );
 * the Apache License, Version 2.0 (the "License"); you may
        String[] paths = new String[] { path.resolve("a").toString(), path.resolve("b").toString() };
        }
            e -> assertThat(e.getMessage(), containsString("error"))
        );
        final BootstrapChecks.MightForkCheck check = new BootstrapChecks.MightForkCheck() {
            }
            () -> mightFork.set(false),
        );
            )
        };
import java.util.ArrayList;
        maxFileSize.set(rlimInfinity);
import org.opensearch.common.settings.Settings;
import org.opensearch.env.Environment;
                return version.get();
            private final boolean mlockallSet;
            short getSystemCpuPercent() {
        // if not on an early-access build, nothing should happen
        final NodeValidationException e = expectThrows(
        assertThat(suppressed[1], instanceOf(IllegalStateException.class));
        useSerialGC.set("false");
            NodeValidationException.class,
            e.getMessage(),
            }
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        final NodeValidationException e = expectThrows(
        final AtomicBoolean isSystemCallFilterInstalled = new AtomicBoolean();
            String javaVersion() {
        version.set(Version.parse("11.0.14"));
                return 0;
            @Override
                        + "]"
/*
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
            Settings.builder()
            MlockallCheckTestCase(final boolean mlockallSet, final boolean isMemoryLocked, final boolean shouldFail) {
        for (final MlockallCheckTestCase testCase : testCases) {
        assertThat(
            @Override
        when(boundTransportAddress.publishAddress()).thenReturn(publishAddress);
        ensureChecksPass.accept(Settings.builder().putList(DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING.getKey()));
    public void testLogMessageInProductionMode() throws NodeValidationException {
            createTestContext(
 * compatible open source license.
            };
 * ownership. Elasticsearch licenses this file to you under
            String getVmName() {
        }
            @Override
            () -> new BootstrapChecks.FileDescriptorCheck(-randomIntBetween(0, Integer.MAX_VALUE))
            @Override
        assertEquals(BootstrapChecks.enforceLimits(boundTransportAddress, discoveryType), !"single-node".equals(discoveryType));
    }
        final BootstrapChecks.MightForkCheck check,
            long getInitialHeapSize() {
import java.net.InetAddress;
        final BootstrapCheck check = new BootstrapChecks.UseSerialGCCheck() {
    ) throws NodeValidationException {
            () -> onOutOfMemoryError.set(randomBoolean() ? "" : null),
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
            String onOutOfMemoryError() {
            @Override
        final Logger logger = mock(Logger.class);
        disableMightFork.run();
            NodeValidationException.class,
        final BootstrapCheck check = new BootstrapChecks.JavaVersionCheck() {
 * The OpenSearch Contributors require contributions made to
        for (int i = 0; i < randomIntBetween(1, 8); i++) {
import org.opensearch.common.CheckedConsumer;
    public void testEnforceLimitsWhenBoundToNonLocalAddress() {
        BootstrapChecks.check(emptyContext, true, checks);
        final int limit = osX ? 10240 : 65535;
                    + ""
        final AtomicBoolean isSystemCallFilterInstalled = new AtomicBoolean();
        final int initial = randomIntBetween(0, Integer.MAX_VALUE - 1);
            }
            containsString(
            }
                return initialHeapSize.get();
                return vmName.get();
            () -> BootstrapChecks.check(emptyContext, true, checks)
    private void runMightForkTest(
        final AtomicBoolean isSystemCallFilterInstalled = new AtomicBoolean();
            () -> onError.set(randomBoolean() ? "" : null),
        transportAddresses.add(nonLocalTransportAddress);
            () -> BootstrapChecks.check(emptyContext, true, Collections.singletonList(check))
        when(boundTransportAddress.publishAddress()).thenReturn(publishAddress);
}
        final List<MlockallCheckTestCase> testCases = new ArrayList<>();
        // if system call filter is enabled, but we will not fork, nothing should
            }
                return -1;
        final AtomicBoolean mightFork = new AtomicBoolean();
            public boolean alwaysEnforce() {
            @Override
        runMightForkTest(
        };
    }
        assertEquals(BootstrapChecks.enforceLimits(boundTransportAddress, discoveryType), !"single-node".equals(discoveryType));
    }
import org.apache.logging.log4j.Logger;
        BootstrapChecks.check(context_1, true, Collections.singletonList(systemCallFilterNotEnabledCheck));
            }
            boolean isSystemCallFilterInstalled() {
                // nothing should happen
import static org.hamcrest.Matchers.not;
        maxFileSize.set(Long.MIN_VALUE);
                Settings.builder()
import org.opensearch.node.NodeValidationException;
        );
            long getRlimInfinity() {
        final AtomicReference<String> useSerialGC = new AtomicReference<>("true");
                        + command
        // nothing should happen since we are in non-production mode
    public void testAlwaysEnforcedChecks() {
            NodeValidationException.class,
                Settings.builder().put("bootstrap.memory_lock", testCase.mlockallSet).build(),
        assertThat(
        final AtomicLong maxHeapSize = new AtomicLong(max);
            () -> onError.set(command),
        );
            NodeValidationException.class,
        isAllPermissionGranted.set(false);
        );
import org.apache.lucene.util.Constants;
                return 0;
                return mightFork.get();
        final AtomicBoolean isSystemCallFilterInstalled,
        );
        initialHeapSize.set(maxHeapSize.get());
                return isSystemCallFilterInstalled.get();
    public void testNoLogMessageInNonProductionMode() throws NodeValidationException {
                "initial heap size [" + initialHeapSize.get() + "] " + "not equal to maximum heap size [" + maxHeapSize.get() + "]"
        isSystemCallFilterInstalled.set(true);
        // not available
        BootstrapChecks.check(context, true, checks);
            String message(BootstrapContext context) {
                    NodeValidationException.class,
            }
        maxFileDescriptorCount.set(randomIntBetween(limit + 1, Integer.MAX_VALUE));
        );
        final BootstrapCheck check = new BootstrapChecks.ProbesCheck() {
        consumer.accept(e);
    public void testExceptionAggregation() {
            () -> BootstrapChecks.check(emptyContext, true, checks)
        final AtomicBoolean isAllPermissionGranted = new AtomicBoolean(true);
                    "OnOutOfMemoryError ["
    public void testNonProductionMode() throws NodeValidationException {
    public void testAllPermissionCheck() throws NodeValidationException {
import java.util.concurrent.atomic.AtomicBoolean;
import static org.opensearch.discovery.DiscoveryModule.ZEN2_DISCOVERY_TYPE;
            short getProcessCpuPercent() {
        if (randomBoolean()) {
        final String discoveryType = randomFrom(ZEN2_DISCOVERY_TYPE, "single-node");
            @Override
        maxNumberOfThreads.set(-1);
    }
            NodeValidationException.class,
    public void testSingleDataPathForSearchNodeCheck() throws NodeValidationException {
    public void testSystemCallFilterCheck() throws NodeValidationException {
                return javaVersion.get();
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
                .putList(Environment.PATH_DATA_SETTING.getKey(), paths)
                .build(),
        );
                : new TransportAddress(InetAddress.getLoopbackAddress(), i);
        final List<TransportAddress> transportAddresses = new ArrayList<>();
                    return testCase.isMemoryLocked;
        assertThat(suppressed[1], hasToString(containsString("second")));
    }
        final BootstrapChecks.MaxNumberOfThreadsCheck check = new BootstrapChecks.MaxNumberOfThreadsCheck() {
        when(boundTransportAddress.boundAddresses()).thenReturn(transportAddresses.toArray(new TransportAddress[0]));
        for (int i = 0; i < randomIntBetween(0, 7); i++) {
                return isAllPermissionGranted.get();
            e,
        final NodeValidationException e = expectThrows(
        assertThat(e, hasToString(allOf(containsString("bootstrap checks failed"), containsString("first"), containsString("second"))));
        );
        );
        final String command = randomAlphaOfLength(16);
            () -> BootstrapChecks.check(emptyContext, randomBoolean(), Collections.singletonList(check))
            isSystemCallFilterInstalled,
            @Override
            }
        } else {
            long getMaxSizeVirtualMemory() {
        // not available
            NodeValidationException.class,
import org.opensearch.cluster.metadata.Metadata;
                }
            }
                return maxHeapSize.get();
        BootstrapChecks.check(emptyContext, false, Collections.emptyList(), logger);
        final BootstrapChecks.AllPermissionCheck allPermissionCheck = new BootstrapChecks.AllPermissionCheck() {
        }
    public void testHeapSizeCheck() throws NodeValidationException {
        final NodeValidationException alwaysEnforced = expectThrows(
            }
            long getMaxFileSize() {
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
            )
    public void testFileDescriptorLimitsThrowsOnInvalidLimit() {
        final AtomicReference<String> onError = new AtomicReference<>();
        );
        final Logger logger = mock(Logger.class);
                "JVM is using the serial collector but should not be for the best performance; "
        };
    public void testDiscoveryConfiguredCheck() throws NodeValidationException {
        BoundTransportAddress boundTransportAddress = mock(BoundTransportAddress.class);
        final AtomicReference<String> javaVersion = new AtomicReference<>(randomFrom("1.8.0_152-ea", "9-ea"));
            @Override
        }
            short getProcessCpuPercent() {
 * KIND, either express or implied.  See the License for the
        assertThat(
            NodeValidationException.class,
        for (int i = 0; i < randomIntBetween(1, 8); i++) {
        final BootstrapChecks.MaxFileSizeCheck check = new BootstrapChecks.MaxFileSizeCheck() {
import org.opensearch.test.AbstractBootstrapCheckTestCase;
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
                "system call filters failed to install; "
        };
    }
                    .build(),
 * software distributed under the License is distributed on an
    }
    }
    public void testMightForkCheck() throws NodeValidationException {
        }
 *
        isSystemCallFilterInstalled.set(true);
            containsString(
        final long rlimInfinity = Constants.MAC_OS_X ? 9223372036854775807L : -1L;
            String jvmVendor() {
                return isSystemCallFilterInstalled.get();
        };
        );
        BootstrapChecks.check(emptyContext, true, Collections.emptyList(), logger);
        };
                return rlimInfinity;
        final BootstrapContext zen2Context = createTestContext(
        final TransportAddress publishAddress = randomBoolean()
                    .put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), randomFrom("single-node", randomAlphaOfLength(5)))
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
import static org.mockito.Mockito.mock;
        final AtomicLong maxNumberOfThreads = new AtomicLong(randomIntBetween(1, limit - 1));
        final BootstrapChecks.SystemCallFilterCheck systemCallFilterEnabledCheck = new BootstrapChecks.SystemCallFilterCheck() {
    }
                    () -> BootstrapChecks.check(bootstrapContext, true, Collections.singletonList(check))
            check,
            }
            boolean isSystemCallFilterInstalled() {
    public void testProbesCheck() throws NodeValidationException {
                b.put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), ZEN2_DISCOVERY_TYPE).build(),
    private void performDataPathsCheck(String[] paths, String roleName) throws NodeValidationException {
        final String command = randomAlphaOfLength(16);
        // not always enforced
        testCases.add(new MlockallCheckTestCase(false, true, false));
    }
            final BootstrapContext context = createTestContext(
 */
            hasToString(
                containsString(
            boolean isSystemCallFilterInstalled() {
        final List<BootstrapCheck> checks = Collections.singletonList(new BootstrapChecks.DiscoveryConfiguredCheck());
        final NodeValidationException e = expectThrows(
    }
            ? buildNewFakeTransportAddress()
        final AtomicReference<Version> version = new AtomicReference<>(Version.parse("11.0.13+8"));
        );
                    return maxFileDescriptorCount.get();
        );
        enableMightFork.run();
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
        verifyNoMoreInteractions(logger);
            e.getMessage(),
            transportAddresses.add(localTransportAddress);
        ensureChecksPass.accept(Settings.builder().putList(ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey()));
            () -> BootstrapChecks.check(emptyContext, randomBoolean(), Collections.singletonList(check))
        final AtomicReference<String> vmName = new AtomicReference<>("Java HotSpot(TM) 32-Bit Client VM");
                return true;
        when(boundTransportAddress.publishAddress()).thenReturn(publishAddress);
        assertThat(
            e -> assertThat(
        final BootstrapCheck check = new BootstrapChecks.ClientJvmCheck() {
        final AtomicLong maxFileDescriptorCount = new AtomicLong(randomIntBetween(1, limit - 1));
                "JVM is using the client VM [Java HotSpot(TM) 32-Bit Client VM] "
                return onError.get();
 * SPDX-License-Identifier: Apache-2.0
        final int max = randomIntBetween(initial + 1, Integer.MAX_VALUE);
        verify(logger).warn("The recent CPU usage is not available");
            @Override
        final BootstrapCheck check = new BootstrapCheck() {
                    + "check the logs and fix your configuration or disable system call filters at your own risk"
        final BoundTransportAddress boundTransportAddress = mock(BoundTransportAddress.class);
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
            context -> BootstrapCheck.BootstrapCheckResult.failure("first"),
            ? createTestContext(Settings.builder().put("bootstrap.system_call_filter", true).build(), null)
        verifyNoMoreInteractions(logger);
        final List<BootstrapCheck> checks = Collections.singletonList(allPermissionCheck);
        final BootstrapContext context = createTestContext(
                return "Oracle Corporation";
        vmName.set("Java HotSpot(TM) 32-Bit Server VM");
import java.util.function.Consumer;
                return useSerialGC.get();
        ensureChecksPass.accept(Settings.builder().putList(SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING.getKey()));
            Metadata.EMPTY_METADATA
                Metadata.EMPTY_METADATA
            @Override
 *
                .putList(NodeRoleSettings.NODE_ROLES_SETTING.getKey(), Collections.singletonList(roleName))
            }
    }
        assertThat(
    }
            };
        Path path = PathUtils.get(createTempDir().toString());
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
            checks
                return rlimInfinity;
        final BootstrapChecks.MightForkCheck check = new BootstrapChecks.OnErrorCheck() {
                    + "for more details, please check https://github.com/opensearch-project/OpenSearch/issues/2791 and https://bugs.openjdk.java.net/browse/JDK-8259541"
        final BootstrapChecks.HeapSizeCheck check = new BootstrapChecks.HeapSizeCheck() {
        final List<BootstrapCheck> checks = Collections.singletonList(eaCheck);
            e.getMessage(),
            final TransportAddress randomTransportAddress = randomBoolean()
package org.opensearch.bootstrap;
        runMightForkTest(
                final NodeValidationException e = expectThrows(
        };
        maxSizeVirtualMemory.set(rlimInfinity);
            boolean isSystemCallFilterInstalled() {
        maxFileDescriptorCount.set(-1);
            }
            }
        // nothing should happen if max file size is not available
        // nothing should happen if the initial heap size or the max
            @Override
                        + " upgrade to at least Java 8u92 and use ExitOnOutOfMemoryError"
            @Override
        assertThat(e.getMessage(), containsString("max size virtual memory"));
            @Override
        // happen
            @Override
    }
        final BootstrapChecks.SystemCallFilterCheck systemCallFilterNotEnabledCheck = new BootstrapChecks.SystemCallFilterCheck() {
        final BootstrapChecks.EarlyAccessCheck eaCheck = new BootstrapChecks.EarlyAccessCheck() {
                )
            () -> BootstrapChecks.check(emptyContext, true, Collections.singletonList(check))
        };
            boolean isAllPermissionGranted() {
 *
            () -> BootstrapChecks.check(emptyContext, true, Collections.singletonList(check))
        }
            context -> BootstrapCheck.BootstrapCheckResult.failure("second")
        assertThat(
        );
import java.lang.Runtime.Version;
                e.getMessage(),
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
        }
            () -> BootstrapChecks.check(emptyContext, true, Collections.singletonList(check))
                        + " requires forking but is prevented by system call filters ([bootstrap.system_call_filter=true]);"
                "The current JVM version 11.0.13+8 is not recommended for use: "
            containsString("Java version [" + javaVersion.get() + "] is an early-access build, only use release builds")
        final IllegalArgumentException e = expectThrows(
        performDataPathsCheck(paths, DiscoveryNodeRole.DATA_ROLE.roleName());
            )
            () -> BootstrapChecks.check(emptyContext, true, Collections.singletonList(check))
        final NodeValidationException e = expectThrows(
    }
                )
        final NodeValidationException e = expectThrows(
 * You may obtain a copy of the License at
    public void testMlockallCheck() throws NodeValidationException {
            }
import java.util.concurrent.atomic.AtomicReference;
            boolean mightFork() {
        final BoundTransportAddress boundTransportAddress = mock(BoundTransportAddress.class);
        BootstrapContext context_1 = createTestContext(Settings.builder().put("bootstrap.system_call_filter", false).build(), null);
            NodeValidationException.class,
        );
            );
            @Override
            () -> BootstrapChecks.check(zen2Context, true, checks)
 * Modifications Copyright OpenSearch Contributors. See
        );
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check), logger);
                long getMaxFileDescriptorCount() {
                }
public class BootstrapChecksTests extends AbstractBootstrapCheckTestCase {
                return "error";
                BootstrapChecks.check(bootstrapContext, true, Collections.singletonList(check));
            TransportAddress localTransportAddress = new TransportAddress(InetAddress.getLoopbackAddress(), i);
import static org.mockito.Mockito.verifyNoMoreInteractions;
        final AtomicLong maxSizeVirtualMemory = new AtomicLong(randomIntBetween(0, Integer.MAX_VALUE));
    public void testOnOutOfMemoryErrorCheck() throws NodeValidationException {
            check = new BootstrapChecks.FileDescriptorCheck() {
        final AtomicReference<String> onOutOfMemoryError = new AtomicReference<>();
        final NodeValidationException e = expectThrows(
        assertThat(e.getMessage(), memoryLockingMatcher);
    }
            () -> mightFork.set(true),
            )
        final String memoryLockingMessage = "and prevents memory locking from locking the entire heap";
            );
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
 */
        };
            long getMaxNumberOfThreads() {
import org.opensearch.core.common.transport.BoundTransportAddress;
            : new TransportAddress(InetAddress.getLoopbackAddress(), 0);
import static org.hamcrest.CoreMatchers.allOf;
        // if system call filter is enabled, and we might fork, the check should be enforced, regardless of bootstrap checks being enabled
            )
        String[] paths = new String[] { path.resolve("a").toString(), path.resolve("b").toString() };
        final BootstrapCheck check = new BootstrapChecks.ProbesCheck() {
        );
        }
        assertThat(e.getMessage(), containsString("max number of threads"));
            }
                null
        );
            public BootstrapCheckResult check(BootstrapContext context) {
    }
        final NodeValidationException e = expectThrows(
            NodeValidationException.class,
            }
import org.opensearch.monitor.jvm.JvmInfo;
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
 *    http://www.apache.org/licenses/LICENSE-2.0
        BootstrapChecks.check(
import static org.hamcrest.CoreMatchers.containsString;
        };
        final List<TransportAddress> transportAddresses = new ArrayList<>();
        runMightForkTest(
        } else {
        verify(logger).warn("The recent process CPU usage is not available");
        };
            () -> performDataPathsCheck(paths, DiscoveryNodeRole.WARM_ROLE.roleName())
        };
            () -> { BootstrapChecks.check(emptyContext, true, checks); }
            : emptyContext;
            isSystemCallFilterInstalled,
        final NodeValidationException e = expectThrows(
        when(boundTransportAddress.boundAddresses()).thenReturn(transportAddresses.toArray(new TransportAddress[0]));
    }
            () -> BootstrapChecks.check(emptyContext, true, Collections.singletonList(check))
            transportAddresses.add(randomTransportAddress);
import static org.mockito.Mockito.verify;
        testCases.add(new MlockallCheckTestCase(true, true, false));
        assertThat(
        Collections.shuffle(transportAddresses, random());
        final Matcher<String> memoryLockingMatcher;
                assertThat(e.getMessage(), containsString("memory locking requested for opensearch process but memory is not locked"));
        final Consumer<NodeValidationException> consumer
import java.nio.file.Path;
import org.opensearch.common.io.PathUtils;
        // if system call filter is disabled, nothing should happen
            NodeValidationException.class,
            private final boolean shouldFail;
        final List<BootstrapCheck> checks = Arrays.asList(
            }
            String getUseSerialGC() {
import static org.mockito.Mockito.when;
        // not enforced for non-zen2 discovery
    public void testProcessCpuProbeCheck() throws NodeValidationException {
 * GitHub history for details.
            )
        verify(logger).info("bound or publishing to a non-loopback address, enforcing bootstrap checks");
                Metadata.EMPTY_METADATA
            }
            () -> BootstrapChecks.check(emptyContext, true, Collections.singletonList(check))
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
    public void testEarlyAccessCheck() throws NodeValidationException {
            maxHeapSize.set(0);
        final AtomicLong initialHeapSize = new AtomicLong(initial);
import org.opensearch.cluster.coordination.ClusterBootstrapService;
import org.opensearch.cluster.node.DiscoveryNodeRole;
        maxSizeVirtualMemory.set(Long.MIN_VALUE);
            long getRlimInfinity() {
    }
        } else {
        };
                    "OnError ["
                        + "] requires forking but is prevented by system call filters "
            boolean isSystemCallFilterInstalled() {
        final NodeValidationException e = expectThrows(
        assertThat(suppressed.length, equalTo(2));
        if (osX) {
            @Override
    public void testEnforceLimitsWhenPublishingToNonLocalAddress() {
    public void testMaxSizeVirtualMemory() throws NodeValidationException {
            containsString(
            @Override
            }
        final List<BootstrapCheck> checks = Collections.singletonList(new BootstrapChecks.MultipleDataPathCheck());
                this.isMemoryLocked = isMemoryLocked;
        final Logger logger = mock(Logger.class);
            };
    public void testClientJvmCheck() throws NodeValidationException {
            }
        };
            enableMightFork.run();
            }
        );
        javaVersion.set(randomFrom("1.8.0_152", "9"));
    public void testFileDescriptorLimits() throws NodeValidationException {
            private final boolean isMemoryLocked;
            memoryLockingMatcher = not(containsString(memoryLockingMessage));
            @Override
        version.set(Runtime.version());
            boolean isMemoryLocked() {
        );
 * Licensed to Elasticsearch under one or more contributor
        final boolean osX = randomBoolean(); // simulates OS X versus non-OS X
        TransportAddress publishAddress = new TransportAddress(InetAddress.getLoopbackAddress(), 0);
                return isSystemCallFilterInstalled.get();
        // if all permissions are not granted, nothing should happen
        final AtomicLong maxFileSize = new AtomicLong(randomIntBetween(0, Integer.MAX_VALUE));
                long getMaxFileDescriptorCount() {
import org.opensearch.discovery.SettingsBasedSeedHostsProvider;
            containsString(
    }
            check = new BootstrapChecks.OsXFileDescriptorCheck() {
        BootstrapChecks.check(context_1, true, Collections.singletonList(systemCallFilterNotEnabledCheck));
            check,
        BootstrapChecks.check(context, true, Collections.singletonList(systemCallFilterEnabledCheck));
    }
        BootstrapChecks.check(zen2Context, false, checks);
        );
        };
                containsString(
        // nothing should happen if current file descriptor count is
        final TransportAddress nonLocalTransportAddress = buildNewFakeTransportAddress();
    public void testMultipleDataPathsForDataNodeCheck() throws NodeValidationException {
                        + "of [discovery.seed_hosts, discovery.seed_providers, cluster.initial_cluster_manager_nodes / cluster.initial_master_nodes] must be configured"
/*
import org.opensearch.node.NodeRoleSettings;
    public void testMultipleDataPathsForSearchNodeCheck() {
            BootstrapContext bootstrapContext = createTestContext(
            e.getMessage(),
        // nothing should happen if current max number of threads is
            transportAddresses.add(randomTransportAddress);
            }
            disableMightFork.run();
import java.util.Collections;
    }
        final NodeValidationException e = expectThrows(
            final TransportAddress randomTransportAddress = buildNewFakeTransportAddress();
            NodeValidationException.class,
import static org.hamcrest.Matchers.hasToString;
            @Override
    public void testJvmVersionCheck() throws NodeValidationException {
            check,
            BootstrapChecks.check(context, true, checks);
                        + command
        final Runnable enableMightFork,
        );
            NodeValidationException.class,
    }
                boolean isMemoryLocked() {
        final long rlimInfinity = Constants.MAC_OS_X ? 9223372036854775807L : -1L;
                return maxFileSize.get();
        final NodeValidationException e = expectThrows(
            if (testCase.shouldFail) {
    }
        assertThat(e.getMessage(), containsString("Multiple data paths are not allowed for warm nodes"));
            Settings.builder().put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), ZEN2_DISCOVERY_TYPE).build(),
            String onError() {
        Path path = PathUtils.get(createTempDir().toString());
        final Runnable disableMightFork,
                this.shouldFail = shouldFail;
        );
                        + "([bootstrap.system_call_filter=true]); upgrade to at least Java 8u92 and use ExitOnOutOfMemoryError"
        final NodeValidationException e = expectThrows(
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
            NodeValidationException.class,
    }
                return maxNumberOfThreads.get();
        );
            () -> onOutOfMemoryError.set(command),
            initialHeapSize.set(0);
                );
    }
            NodeValidationException.class,
                return isMemoryLocked;
        ensureChecksPass.accept(Settings.builder().putList(ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING.getKey()));
        );
            }
                return BootstrapCheckResult.failure("error");
                    return maxFileDescriptorCount.get();
    }
        class MlockallCheckTestCase {
import java.util.concurrent.atomic.AtomicLong;
            @Override
import org.hamcrest.Matcher;
    public void testMaxFileSizeCheck() throws NodeValidationException {
/*
                containsString(
                    + "but should be using a server VM for the best performance"
            )
                return isSystemCallFilterInstalled.get();
                ? buildNewFakeTransportAddress()
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check), logger);
            @Override
        final AtomicBoolean isSystemCallFilterInstalled = new AtomicBoolean();
import static org.hamcrest.CoreMatchers.instanceOf;
        if (randomBoolean()) {
                @Override
            }
        final BootstrapCheck check = new BootstrapChecks.ProbesCheck() {
        assertThat(alwaysEnforced, hasToString(containsString("error")));
    public void testUseSerialGCCheck() throws NodeValidationException {
                return onOutOfMemoryError.get();
        assertThat(suppressed[0], hasToString(containsString("first")));
            Version getVersion() {
            }
        };
        final TransportAddress publishAddress = new TransportAddress(InetAddress.getLoopbackAddress(), 0);
            }
            short getSystemCpuPercent() {
            e.getMessage(),
            )
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check), logger);
        // nothing should happen if max size virtual memory is not available
        final NodeValidationException e = expectThrows(
        };
                }
            @Override
            }
        maxNumberOfThreads.set(randomIntBetween(limit + 1, Integer.MAX_VALUE));
        final Throwable[] suppressed = e.getSuppressed();
 * this work for additional information regarding copyright
        assertThat(suppressed[0], instanceOf(IllegalStateException.class));
            }
                e.getMessage(),
            @Override
            } else {
                    + "either it's the default for the VM ["
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
                return maxSizeVirtualMemory.get();
            }
            NodeValidationException.class,
            ),
 * not use this file except in compliance with the License.
        BootstrapChecks.check(emptyContext, boundTransportAddress, Collections.emptyList());
import java.util.List;
                    + JvmInfo.jvmInfo().getVmName()
            @Override
        final Logger logger = mock(Logger.class);
        assertThat(e.getMessage(), containsString("max file size"));
    }
        final BootstrapChecks.FileDescriptorCheck check;
            long getMaxHeapSize() {
import java.util.Arrays;
            NodeValidationException.class,
        // Validate the deprecated setting is still valid during the node bootstrap.
            IllegalArgumentException.class,
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
import org.opensearch.core.common.transport.TransportAddress;
        performDataPathsCheck(paths, DiscoveryNodeRole.WARM_ROLE.roleName());
                    + "] or -XX:+UseSerialGC was explicitly specified"
        isSystemCallFilterInstalled.set(true);
        String[] paths = new String[] { path.resolve("a").toString() };
        assertThat(e.getMessage(), containsString("max file descriptors"));
        final BootstrapChecks.MaxSizeVirtualMemoryCheck check = new BootstrapChecks.MaxSizeVirtualMemoryCheck() {
        final NodeValidationException e = expectThrows(
            final BootstrapChecks.MlockallCheck check = new BootstrapChecks.MlockallCheck() {
    }
            Metadata.EMPTY_METADATA
        assertThat(e, hasToString(containsString("granting the all permission effectively disables security")));
            () -> BootstrapChecks.check(emptyContext, true, Collections.singletonList(check))
            }
        // or not
                    "the default discovery settings are unsuitable for production use; at least one "
        when(boundTransportAddress.boundAddresses()).thenReturn(transportAddresses.toArray(new TransportAddress[0]));
        );
    public void testOnErrorCheck() throws NodeValidationException {
 * specific language governing permissions and limitations
        };
        isSystemCallFilterInstalled.set(true);
                return -1;
                return isSystemCallFilterInstalled.get();
import org.opensearch.discovery.DiscoveryModule;
                @Override
        BootstrapContext context = randomBoolean()
import static org.hamcrest.CoreMatchers.equalTo;
        Path path = PathUtils.get(createTempDir().toString());
            memoryLockingMatcher = containsString(memoryLockingMessage);
            () -> BootstrapChecks.check(context, true, Collections.singletonList(systemCallFilterEnabledCheck))
            true,
            e.getMessage(),
        BootstrapChecks.check(emptyContext, true, checks);
 * under the License.
            @Override
        );
