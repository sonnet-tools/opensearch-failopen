        );  
                return true;
        final NodeValidationException e = expectThrows(
            () -> onError.set(randomBoolean() ? "" : null),  
        Collections.shuffle(transportAddresses, random());
    }
        final TransportAddress publishAddress = new TransportAddress(InetAddress.getLoopbackAddress(), 0);  
        ensureChecksPass.accept(Settings.builder().putList(ClusterBootstrapService.INITIAL_CLUSTER_MANAGER_NODES_SETTING.getKey()));  
    public void testLogMessageInProductionMode() throws NodeValidationException {
        final AtomicReference<String> onError = new AtomicReference<>();
                Settings.builder().put("bootstrap.memory_lock", testCase.mlockallSet).build(),  
import java.lang.Runtime.Version;
        assertThat(e.getMessage(), containsString("limit must be positive but was"));
            }
            @Override  
    private void performDataPathsCheck(String[] paths, String roleName) throws NodeValidationException {
            }
        runMightForkTest(  
                this.isMemoryLocked = isMemoryLocked;
import org.apache.logging.log4j.Logger;
            e.getMessage(),
        final NodeValidationException e = expectThrows(
            }
    }
        performDataPathsCheck(paths, DiscoveryNodeRole.DATA_ROLE.roleName());  
            isSystemCallFilterInstalled,
            e.getMessage(),  
        assertThat(e.getMessage(), memoryLockingMatcher);  
            IllegalArgumentException.class,
        );
            () -> onOutOfMemoryError.set(command),
        assertThat(suppressed[1], hasToString(containsString("second")));
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
            }  
        final int limit = 1 << 11;
        final TransportAddress publishAddress = randomBoolean()
        testCases.add(new MlockallCheckTestCase(true, true, false));
        };  
    }
        final NodeValidationException e = expectThrows(
            String jvmVendor() {
        );
        verifyNoMoreInteractions(logger);
    public void testOnErrorCheck() throws NodeValidationException {
        maxSizeVirtualMemory.set(rlimInfinity);  
            BootstrapContext bootstrapContext = createTestContext(
        if (osX) {  
            long getMaxSizeVirtualMemory() {
                    + "either it's the default for the VM ["
    public void testJvmVersionCheck() throws NodeValidationException {
            final TransportAddress randomTransportAddress = buildNewFakeTransportAddress();
            };  
        // nothing should happen since we are in non-production mode
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
            Settings.builder().put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), ZEN2_DISCOVERY_TYPE).build(),
            }  
        final Matcher<String> memoryLockingMatcher;  
            }  
            e -> assertThat(e.getMessage(), containsString("error"))
    }  
            e.getMessage(),  
                return BootstrapCheckResult.failure("error");
        assertThat(  
    }
            MlockallCheckTestCase(final boolean mlockallSet, final boolean isMemoryLocked, final boolean shouldFail) {
 * the Apache License, Version 2.0 (the "License"); you may
        final TransportAddress nonLocalTransportAddress = buildNewFakeTransportAddress();
            final BootstrapChecks.MlockallCheck check = new BootstrapChecks.MlockallCheck() {
    public void testSystemCallFilterCheck() throws NodeValidationException {
        final List<TransportAddress> transportAddresses = new ArrayList<>();
        final BootstrapChecks.MightForkCheck check = new BootstrapChecks.MightForkCheck() {  
                    + ""  
            Settings.builder()  
        );  
        BootstrapChecks.check(context, true, Collections.singletonList(systemCallFilterEnabledCheck));
                    .put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), randomFrom("single-node", randomAlphaOfLength(5)))  
            transportAddresses.add(randomTransportAddress);
    }  
import static org.mockito.Mockito.mock;  
                Metadata.EMPTY_METADATA
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check), logger);  
/*  
        );  
        Path path = PathUtils.get(createTempDir().toString());  
            containsString(  
                }
        // not enforced for non-zen2 discovery
            boolean isSystemCallFilterInstalled() {
        verify(logger).warn("The recent process CPU usage is not available");
    public void testMaxFileSizeCheck() throws NodeValidationException {  
        };  
    public void testProcessCpuProbeCheck() throws NodeValidationException {  
import org.hamcrest.Matcher;  
        when(boundTransportAddress.publishAddress()).thenReturn(publishAddress);  
            maxHeapSize.set(0);
        final NodeValidationException e = expectThrows(  
        when(boundTransportAddress.publishAddress()).thenReturn(publishAddress);  
            e.getMessage(),  
            @Override  
                return -1;
            NodeValidationException.class,  
            () -> BootstrapChecks.check(zen2Context, true, checks)
            @Override
            isSystemCallFilterInstalled,
 * under the License.  
        maxFileSize.set(rlimInfinity);  
        assertThat(suppressed[0], instanceOf(IllegalStateException.class));
        final int limit = osX ? 10240 : 65535;  
            containsString(  
        final List<BootstrapCheck> checks = Collections.singletonList(new BootstrapChecks.MultipleDataPathCheck());  
        final AtomicLong maxNumberOfThreads = new AtomicLong(randomIntBetween(1, limit - 1));  
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
                e.getMessage(),  
            long getInitialHeapSize() {  
        };
        BootstrapChecks.check(context, true, checks);
                        + "of [discovery.seed_hosts, discovery.seed_providers, cluster.initial_cluster_manager_nodes / cluster.initial_master_nodes] must be configured"
                @Override  
            )  
        // if all permissions are not granted, nothing should happen
    public void testMlockallCheck() throws NodeValidationException {
                    return maxFileDescriptorCount.get();
 * You may obtain a copy of the License at  
        isSystemCallFilterInstalled.set(true);  
        };
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));  
        final long rlimInfinity = Constants.MAC_OS_X ? 9223372036854775807L : -1L;
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));  
        );  
/*  
            }  
            @Override  
            @Override  
            @Override
        assertThat(
        final Logger logger = mock(Logger.class);
            () -> BootstrapChecks.check(emptyContext, true, checks)  
                ? buildNewFakeTransportAddress()  
        assertThat(
            () -> onOutOfMemoryError.set(randomBoolean() ? "" : null),  
        final Throwable[] suppressed = e.getSuppressed();  
        assertThat(e.getMessage(), containsString("Multiple data paths are not allowed for warm nodes"));
    public void testMaxNumberOfThreadsCheck() throws NodeValidationException {
        };
            long getMaxFileSize() {
        final boolean osX = randomBoolean(); // simulates OS X versus non-OS X
        );
import org.opensearch.monitor.jvm.JvmInfo;
    }  
            boolean isSystemCallFilterInstalled() {
        assertThat(e.getMessage(), containsString("max size virtual memory"));
            }  
        );
 * The OpenSearch Contributors require contributions made to  
        assertEquals(BootstrapChecks.enforceLimits(boundTransportAddress, discoveryType), !"single-node".equals(discoveryType));
        final Logger logger = mock(Logger.class);
                return isSystemCallFilterInstalled.get();
        final BootstrapCheck check = new BootstrapChecks.UseSerialGCCheck() {  
                return 0;  
import org.opensearch.common.settings.Settings;
            hasToString(
            context -> BootstrapCheck.BootstrapCheckResult.failure("second")
import org.opensearch.common.io.PathUtils;
                return rlimInfinity;
        );  
            check = new BootstrapChecks.OsXFileDescriptorCheck() {
        final AtomicLong maxFileDescriptorCount = new AtomicLong(randomIntBetween(1, limit - 1));
        final BootstrapContext context = createTestContext(
            () -> BootstrapChecks.check(emptyContext, true, Collections.singletonList(check))  
                "The current JVM version 11.0.13+8 is not recommended for use: "
            NodeValidationException.class,
                return isSystemCallFilterInstalled.get();  
        TransportAddress publishAddress = new TransportAddress(InetAddress.getLoopbackAddress(), 0);  
        }
        disableMightFork.run();
            isSystemCallFilterInstalled,
            boolean isSystemCallFilterInstalled() {
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
            short getProcessCpuPercent() {
            () -> BootstrapChecks.check(context, true, Collections.singletonList(systemCallFilterEnabledCheck))
                "JVM is using the serial collector but should not be for the best performance; "
            BootstrapChecks.check(context, true, checks);  
            long getMaxNumberOfThreads() {  
                return maxSizeVirtualMemory.get();  
import org.opensearch.discovery.SettingsBasedSeedHostsProvider;  
        assertThat(suppressed[0], hasToString(containsString("first")));  
    public void testEnforceLimitsWhenBoundToNonLocalAddress() {
import java.util.function.Consumer;  
 * this work for additional information regarding copyright
            boolean isAllPermissionGranted() {
        final BootstrapChecks.AllPermissionCheck allPermissionCheck = new BootstrapChecks.AllPermissionCheck() {  
                return maxNumberOfThreads.get();
        final boolean isMemoryLocked = randomBoolean();
            boolean isMemoryLocked() {
            () -> { BootstrapChecks.check(emptyContext, true, checks); }  
        BootstrapChecks.check(emptyContext, true, checks);
        BootstrapChecks.check(zen2Context, false, checks);  
            memoryLockingMatcher = containsString(memoryLockingMessage);
                BootstrapChecks.check(bootstrapContext, true, Collections.singletonList(check));
            String onError() {  
        );
                .putList(NodeRoleSettings.NODE_ROLES_SETTING.getKey(), Collections.singletonList(roleName))
            disableMightFork.run();
    }
            ? createTestContext(Settings.builder().put("bootstrap.system_call_filter", true).build(), null)
        maxSizeVirtualMemory.set(Long.MIN_VALUE);
    }
    }
            check,  
            }  
        CheckedConsumer<Settings.Builder, NodeValidationException> ensureChecksPass = b -> {
                "system call filters failed to install; "
        };
            e -> assertThat(
        assertThat(e.getMessage(), containsString("max file size"));
 * KIND, either express or implied.  See the License for the
        when(boundTransportAddress.boundAddresses()).thenReturn(transportAddresses.toArray(new TransportAddress[0]));
    public void testEnforceLimitsWhenPublishingToNonLocalAddress() {
        BootstrapChecks.check(context_1, true, Collections.singletonList(systemCallFilterNotEnabledCheck));
                return "Oracle Corporation";
            if (testCase.shouldFail) {  
        BootstrapContext context = randomBoolean()
                        + command  
import org.opensearch.test.AbstractBootstrapCheckTestCase;
import static org.opensearch.discovery.DiscoveryModule.ZEN2_DISCOVERY_TYPE;
                    + "] or -XX:+UseSerialGC was explicitly specified"  
        isSystemCallFilterInstalled.set(true);
import org.opensearch.discovery.DiscoveryModule;
        ensureChecksPass.accept(Settings.builder().putList(DiscoveryModule.DISCOVERY_SEED_PROVIDERS_SETTING.getKey()));
        final BoundTransportAddress boundTransportAddress = mock(BoundTransportAddress.class);
                        + " requires forking but is prevented by system call filters ([bootstrap.system_call_filter=true]);"
        version.set(Version.parse("11.0.14"));
            }
            NodeValidationException.class,
        String[] paths = new String[] { path.resolve("a").toString() };
            }
                    + JvmInfo.jvmInfo().getVmName()
        final Logger logger = mock(Logger.class);
import org.opensearch.node.NodeRoleSettings;  
        useSerialGC.set("false");
            @Override
            () -> mightFork.set(false),
        final int max = randomIntBetween(initial + 1, Integer.MAX_VALUE);
    }
import org.opensearch.common.CheckedConsumer;  
            e,
        when(boundTransportAddress.boundAddresses()).thenReturn(transportAddresses.toArray(new TransportAddress[0]));
                return isMemoryLocked;
        assertThat(
 */  
        if (isMemoryLocked) {
        };
            NodeValidationException.class,
        // heap size is not available
            @Override
        );
            checks
        final AtomicBoolean isSystemCallFilterInstalled,
            private final boolean isMemoryLocked;
public class BootstrapChecksTests extends AbstractBootstrapCheckTestCase {
    public void testProbesCheck() throws NodeValidationException {
            memoryLockingMatcher = not(containsString(memoryLockingMessage));
            enableMightFork.run();
        // or not  
            long getMaxHeapSize() {
        initialHeapSize.set(maxHeapSize.get());
        final AtomicBoolean isSystemCallFilterInstalled = new AtomicBoolean();  
            String message(BootstrapContext context) {  
                return onOutOfMemoryError.get();
        final BootstrapChecks.SystemCallFilterCheck systemCallFilterEnabledCheck = new BootstrapChecks.SystemCallFilterCheck() {
            @Override
        maxNumberOfThreads.set(randomIntBetween(limit + 1, Integer.MAX_VALUE));
    }  
                containsString(
            () -> BootstrapChecks.check(emptyContext, true, Collections.singletonList(check))
                        + "] requires forking but is prevented by system call filters "
        isSystemCallFilterInstalled.set(true);
    }
                return maxFileSize.get();  
                )  
            NodeValidationException.class,
        // nothing should happen if the initial heap size or the max  
        // if system call filter is enabled, but we will not fork, nothing should
                )  
            check = new BootstrapChecks.FileDescriptorCheck() {
            }  
            @Override
            @Override  
            @Override
        }
                Metadata.EMPTY_METADATA
            final BootstrapContext context = createTestContext(
        final NodeValidationException e = expectThrows(  
                return isAllPermissionGranted.get();  
    }
        final NodeValidationException e = expectThrows(  
        final BootstrapChecks.MightForkCheck check,
import static org.hamcrest.CoreMatchers.allOf;  
        class MlockallCheckTestCase {
        );
import org.apache.lucene.util.Constants;
import static org.hamcrest.CoreMatchers.equalTo;
package org.opensearch.bootstrap;
import java.util.ArrayList;
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
        final AtomicReference<String> useSerialGC = new AtomicReference<>("true");
            true,
                return version.get();  
        isSystemCallFilterInstalled.set(false);  
        );
            Metadata.EMPTY_METADATA
        final AtomicBoolean mightFork = new AtomicBoolean();
            private final boolean mlockallSet;
        BootstrapChecks.check(emptyContext, false, Collections.emptyList(), logger);  
        final NodeValidationException e = expectThrows(
import static org.mockito.Mockito.verify;
        final IllegalArgumentException e = expectThrows(  
            );
            }  
        final List<BootstrapCheck> checks = Collections.singletonList(eaCheck);  
            short getSystemCpuPercent() {
        };
                @Override  
            NodeValidationException.class,  
import java.nio.file.Path;
        isSystemCallFilterInstalled.set(false);  
 */  
        final List<BootstrapCheck> checks = Arrays.asList(
                .putList(Environment.PATH_DATA_SETTING.getKey(), paths)
            }  
        transportAddresses.add(nonLocalTransportAddress);
    public void testSystemCpuProbeCheck() throws NodeValidationException {
            )
        );
        BootstrapChecks.check(emptyContext, true, Collections.emptyList(), logger);  
                    + "check the logs and fix your configuration or disable system call filters at your own risk"
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
                containsString(  
        final String discoveryType = randomFrom(ZEN2_DISCOVERY_TYPE, "single-node");
        for (int i = 0; i < randomIntBetween(1, 8); i++) {
            () -> performDataPathsCheck(paths, DiscoveryNodeRole.WARM_ROLE.roleName())  
import org.opensearch.env.Environment;
        when(boundTransportAddress.boundAddresses()).thenReturn(transportAddresses.toArray(new TransportAddress[0]));
        };
            @Override
    public void testExceptionAggregation() {
            )  
        ensureChecksPass.accept(Settings.builder().putList(ClusterBootstrapService.INITIAL_MASTER_NODES_SETTING.getKey()));
import org.opensearch.core.common.transport.TransportAddress;
                : new TransportAddress(InetAddress.getLoopbackAddress(), i);
            containsString(
                    "OnError ["
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));  
            @Override
            () -> BootstrapChecks.check(emptyContext, true, Collections.singletonList(check))
            createTestContext(
            @Override  
            @Override
    private void runMightForkTest(  
            () -> BootstrapChecks.check(emptyContext, true, Collections.singletonList(check))  
import java.util.Collections;
    public void testDiscoveryConfiguredCheck() throws NodeValidationException {  
    }
            @Override
import org.opensearch.node.NodeValidationException;
            () -> BootstrapChecks.check(emptyContext, randomBoolean(), Collections.singletonList(check))
            e.getMessage(),  
    public void testNonProductionMode() throws NodeValidationException {
        // nothing should happen if current max number of threads is  
import java.util.concurrent.atomic.AtomicBoolean;  
            boolean isSystemCallFilterInstalled() {
import static org.hamcrest.CoreMatchers.containsString;
            }
 * license agreements. See the NOTICE file distributed with
import java.net.InetAddress;  
        final List<BootstrapCheck> checks = Collections.singletonList(allPermissionCheck);
        final BootstrapChecks.MightForkCheck check = new BootstrapChecks.OnOutOfMemoryErrorCheck() {
        }  
        maxFileDescriptorCount.set(randomIntBetween(limit + 1, Integer.MAX_VALUE));
            NodeValidationException.class,
        String[] paths = new String[] { path.resolve("a").toString(), path.resolve("b").toString() };
        verify(logger).warn("The recent CPU usage is not available");  
        final List<TransportAddress> transportAddresses = new ArrayList<>();  
            NodeValidationException.class,
        final List<BootstrapCheck> checks = Collections.singletonList(new BootstrapChecks.DiscoveryConfiguredCheck());
        final AtomicBoolean isSystemCallFilterInstalled = new AtomicBoolean();  
            Version getVersion() {
        isSystemCallFilterInstalled.set(true);
        );  
        when(boundTransportAddress.publishAddress()).thenReturn(publishAddress);  
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
        final NodeValidationException e = expectThrows(
 *  
            transportAddresses.add(randomTransportAddress);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
        // nothing should happen if max file size is not available
        }
            public BootstrapCheckResult check(BootstrapContext context) {
 */
            } else {  
            @Override  
                        + " upgrade to at least Java 8u92 and use ExitOnOutOfMemoryError"  
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
        maxFileDescriptorCount.set(-1);
                return isSystemCallFilterInstalled.get();
    }
        runMightForkTest(
        BootstrapChecks.check(emptyContext, true, checks);  
            check,
        isAllPermissionGranted.set(false);  
    }
                        + command  
        // nothing should happen if max size virtual memory is not available
            NodeValidationException.class,  
        // not always enforced
            };
        final AtomicBoolean isSystemCallFilterInstalled = new AtomicBoolean();  
        final AtomicLong maxFileSize = new AtomicLong(randomIntBetween(0, Integer.MAX_VALUE));
        assertThat(suppressed.length, equalTo(2));
        );
            }  
        );
            ),  
                return useSerialGC.get();  
        };
        final AtomicLong maxHeapSize = new AtomicLong(max);  
                b.put(DiscoveryModule.DISCOVERY_TYPE_SETTING.getKey(), ZEN2_DISCOVERY_TYPE).build(),  
        // nothing should happen if current file descriptor count is
    public void testAlwaysEnforcedChecks() {
        if (randomBoolean()) {
        for (final MlockallCheckTestCase testCase : testCases) {
        final AtomicReference<String> vmName = new AtomicReference<>("Java HotSpot(TM) 32-Bit Client VM");
        };
        final BootstrapChecks.MaxNumberOfThreadsCheck check = new BootstrapChecks.MaxNumberOfThreadsCheck() {
    }  
            final TransportAddress randomTransportAddress = randomBoolean()
        final BootstrapCheck check = new BootstrapChecks.ProbesCheck() {
            NodeValidationException.class,
            containsString("Java version [" + javaVersion.get() + "] is an early-access build, only use release builds")
                Settings.builder()
                    .build(),
        assertThat(e.getMessage(), containsString("max number of threads"));  
import java.util.Arrays;  
            String onOutOfMemoryError() {  
        };
        for (int i = 0; i < randomIntBetween(0, 7); i++) {
    public void testNoLogMessageInNonProductionMode() throws NodeValidationException {
            long getRlimInfinity() {
        testCases.add(new MlockallCheckTestCase(false, true, false));
            @Override
        for (int i = 0; i < randomIntBetween(1, 8); i++) {
import static org.hamcrest.Matchers.not;
        final BootstrapChecks.MaxSizeVirtualMemoryCheck check = new BootstrapChecks.MaxSizeVirtualMemoryCheck() {  
        final Consumer<NodeValidationException> consumer
    }  
 * ownership. Elasticsearch licenses this file to you under  
            containsString(
/*
                    return maxFileDescriptorCount.get();
                long getMaxFileDescriptorCount() {  
                        + "([bootstrap.system_call_filter=true]); upgrade to at least Java 8u92 and use ExitOnOutOfMemoryError"
import org.opensearch.cluster.metadata.Metadata;
        testCases.add(new MlockallCheckTestCase(false, false, false));
            e -> assertThat(
            }
            @Override  
 * Licensed to Elasticsearch under one or more contributor  
}  
        final AtomicBoolean isAllPermissionGranted = new AtomicBoolean(true);
            )
                final NodeValidationException e = expectThrows(
        final BootstrapChecks.SystemCallFilterCheck systemCallFilterNotEnabledCheck = new BootstrapChecks.SystemCallFilterCheck() {  
    public void testClientJvmCheck() throws NodeValidationException {  
            long getRlimInfinity() {
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
                return 0;
            transportAddresses.add(localTransportAddress);  
        BoundTransportAddress boundTransportAddress = mock(BoundTransportAddress.class);
                return "error";
            );
        BootstrapChecks.check(context_1, true, Collections.singletonList(systemCallFilterNotEnabledCheck));  
                "JVM is using the client VM [Java HotSpot(TM) 32-Bit Client VM] "
        );
            short getSystemCpuPercent() {  
        ensureChecksPass.accept(Settings.builder().putList(SettingsBasedSeedHostsProvider.DISCOVERY_SEED_HOSTS_SETTING.getKey()));
        );  
        final BootstrapChecks.MightForkCheck check = new BootstrapChecks.OnErrorCheck() {
            NodeValidationException.class,
    }
            }
        version.set(Runtime.version());
        } else {  
        // not available  
        } else {  
            @Override
        final AtomicLong maxSizeVirtualMemory = new AtomicLong(randomIntBetween(0, Integer.MAX_VALUE));
        );
        final String command = randomAlphaOfLength(16);
    public void testEarlyAccessCheck() throws NodeValidationException {
            check,
        };  
                }  
 * software distributed under the License is distributed on an
        );
                    "OnOutOfMemoryError ["
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));  
            () -> BootstrapChecks.check(emptyContext, true, Collections.singletonList(check))
    }
import org.opensearch.core.common.transport.BoundTransportAddress;  
        final Runnable enableMightFork,
                );
        };  
        Path path = PathUtils.get(createTempDir().toString());
            }  
                this.mlockallSet = mlockallSet;  
        );
        final String command = randomAlphaOfLength(16);
            }
            @Override  
        BootstrapChecks.check(  
        final BootstrapChecks.FileDescriptorCheck check;
            @Override  
        final NodeValidationException e = expectThrows(
        assertThat(suppressed[1], instanceOf(IllegalStateException.class));
            boolean isSystemCallFilterInstalled() {
        };
            @Override
    }
                        + "]"
        String[] paths = new String[] { path.resolve("a").toString(), path.resolve("b").toString() };
import static org.hamcrest.CoreMatchers.instanceOf;  
                // nothing should happen
        assertThat(
            }
        final String discoveryType = randomFrom(ZEN2_DISCOVERY_TYPE, "single-node");
        assertThat(e, hasToString(containsString("granting the all permission effectively disables security")));  
            : emptyContext;  
            String javaVersion() {  
import static org.hamcrest.Matchers.hasToString;
            };
            e.getMessage(),
        );  
        final NodeValidationException e = expectThrows(
        Path path = PathUtils.get(createTempDir().toString());
        final NodeValidationException e = expectThrows(
        final BootstrapCheck check = new BootstrapChecks.ProbesCheck() {
        }  
        final AtomicReference<String> javaVersion = new AtomicReference<>(randomFrom("1.8.0_152-ea", "9-ea"));  
    }  
        final BootstrapChecks.EarlyAccessCheck eaCheck = new BootstrapChecks.EarlyAccessCheck() {
        final List<TransportAddress> transportAddresses = new ArrayList<>();  
                return vmName.get();
            }
import static org.mockito.Mockito.verifyNoMoreInteractions;
                return onError.get();
        final String memoryLockingMessage = "and prevents memory locking from locking the entire heap";
import org.opensearch.cluster.node.DiscoveryNodeRole;
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));
                return initialHeapSize.get();
            : new TransportAddress(InetAddress.getLoopbackAddress(), 0);
        final NodeValidationException alwaysEnforced = expectThrows(
    }
                return mightFork.get();
        assertThat(e.getMessage(), containsString("max file descriptors"));
                return -1;
            String getVmName() {
            }
                    NodeValidationException.class,
        BootstrapChecks.check(emptyContext, boundTransportAddress, Collections.emptyList());
        final int initial = randomIntBetween(0, Integer.MAX_VALUE - 1);  
                return maxHeapSize.get();  
            @Override
        final AtomicBoolean isSystemCallFilterInstalled = new AtomicBoolean();
import java.util.concurrent.atomic.AtomicReference;
        vmName.set("Java HotSpot(TM) 32-Bit Server VM");  
        }
            () -> BootstrapChecks.check(emptyContext, true, Collections.singletonList(check))
import java.util.concurrent.atomic.AtomicLong;
        // Validate the deprecated setting is still valid during the node bootstrap.  
                long getMaxFileDescriptorCount() {
        // not available
            NodeValidationException.class,  
                    "the default discovery settings are unsuitable for production use; at least one "
    }
        // happen  
        enableMightFork.run();
        verify(logger).info("bound or publishing to a non-loopback address, enforcing bootstrap checks");
        );
    public void testMultipleDataPathsForSearchNodeCheck() {  
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));  
            }
        final AtomicReference<Version> version = new AtomicReference<>(Version.parse("11.0.13+8"));
 *    http://www.apache.org/licenses/LICENSE-2.0
        maxNumberOfThreads.set(-1);
    }
        );
        final BootstrapCheck check = new BootstrapChecks.JavaVersionCheck() {  
        }
            initialHeapSize.set(0);  
        };
        final BootstrapCheck check = new BootstrapCheck() {
                return rlimInfinity;
    }
 * specific language governing permissions and limitations
        final Runnable disableMightFork,  
        runMightForkTest(  
            boolean mightFork() {
        final NodeValidationException e = expectThrows(
            () -> new BootstrapChecks.FileDescriptorCheck(-randomIntBetween(0, Integer.MAX_VALUE))
                .build(),  
            @Override
        };
                    () -> BootstrapChecks.check(bootstrapContext, true, Collections.singletonList(check))  
 * SPDX-License-Identifier: Apache-2.0
        testCases.add(new MlockallCheckTestCase(true, false, true));  
                    return testCase.isMemoryLocked;
        final BootstrapCheck check = new BootstrapChecks.ClientJvmCheck() {
 * GitHub history for details.
    }  
    public void testUseSerialGCCheck() throws NodeValidationException {
    public void testMaxSizeVirtualMemory() throws NodeValidationException {  
import static org.mockito.Mockito.when;  
        final Logger logger = mock(Logger.class);
        final NodeValidationException e = expectThrows(  
        performDataPathsCheck(paths, DiscoveryNodeRole.WARM_ROLE.roleName());
        assertThat(
            }
 * Modifications Copyright OpenSearch Contributors. See
        }
        verifyNoMoreInteractions(logger);
            NodeValidationException.class,
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check), logger);  
            public boolean alwaysEnforce() {  
        final List<MlockallCheckTestCase> testCases = new ArrayList<>();
            private final boolean shouldFail;  
        assertThat(
 *
 *
        final NodeValidationException e = expectThrows(
                return isSystemCallFilterInstalled.get();
    public void testMultipleDataPathsForDataNodeCheck() throws NodeValidationException {
        final Logger logger = mock(Logger.class);  
        // if system call filter is disabled, nothing should happen
    }
            )  
        );
        final BootstrapCheck check = new BootstrapChecks.ProbesCheck() {  
    public void testHeapSizeCheck() throws NodeValidationException {
        consumer.accept(e);
                containsString(
            )
        javaVersion.set(randomFrom("1.8.0_152", "9"));
    }  
                "initial heap size [" + initialHeapSize.get() + "] " + "not equal to maximum heap size [" + maxHeapSize.get() + "]"
            NodeValidationException.class,
            short getProcessCpuPercent() {
                e.getMessage(),  
    public void testAllPermissionCheck() throws NodeValidationException {
                    + "but should be using a server VM for the best performance"
            () -> onError.set(command),
            )
        // if not on an early-access build, nothing should happen
                    + "for more details, please check https://github.com/opensearch-project/OpenSearch/issues/2791 and https://bugs.openjdk.java.net/browse/JDK-8259541"  
                this.shouldFail = shouldFail;
        assertThat(e, hasToString(allOf(containsString("bootstrap checks failed"), containsString("first"), containsString("second"))));
    public void testFileDescriptorLimits() throws NodeValidationException {
            () -> BootstrapChecks.check(emptyContext, randomBoolean(), Collections.singletonList(check))  
            }  
        final AtomicLong initialHeapSize = new AtomicLong(initial);
        };  
            NodeValidationException.class,
            () -> BootstrapChecks.check(emptyContext, true, Collections.singletonList(check))  
            context -> BootstrapCheck.BootstrapCheckResult.failure("first"),  
        );
            Metadata.EMPTY_METADATA
                assertThat(e.getMessage(), containsString("memory locking requested for opensearch process but memory is not locked"));
        };  
        final BootstrapChecks.MaxFileSizeCheck check = new BootstrapChecks.MaxFileSizeCheck() {  
                return javaVersion.get();
            }
            @Override
    public void testFileDescriptorLimitsThrowsOnInvalidLimit() {
    public void testMightForkCheck() throws NodeValidationException {  
                @Override
        assertEquals(BootstrapChecks.enforceLimits(boundTransportAddress, discoveryType), !"single-node".equals(discoveryType));
        );
        // if system call filter is enabled, and we might fork, the check should be enforced, regardless of bootstrap checks being enabled
            () -> BootstrapChecks.check(emptyContext, true, Collections.singletonList(check))  
        BootstrapContext context_1 = createTestContext(Settings.builder().put("bootstrap.system_call_filter", false).build(), null);
 * not use this file except in compliance with the License.
                return isSystemCallFilterInstalled.get();  
            }  
            @Override  
        );
            containsString(
            ? buildNewFakeTransportAddress()  
        );
        if (randomBoolean()) {
    ) throws NodeValidationException {  
    public void testSingleDataPathForSearchNodeCheck() throws NodeValidationException {  
        } else {
import java.util.List;
        }
                boolean isMemoryLocked() {
            NodeValidationException.class,
        );
            TransportAddress localTransportAddress = new TransportAddress(InetAddress.getLoopbackAddress(), i);
                }  
        maxFileSize.set(Long.MIN_VALUE);
        assertThat(alwaysEnforced, hasToString(containsString("error")));  
            @Override  
            () -> mightFork.set(true),  
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check), logger);
 * Unless required by applicable law or agreed to in writing,
        } else {
        final BoundTransportAddress boundTransportAddress = mock(BoundTransportAddress.class);  
    public void testOnOutOfMemoryErrorCheck() throws NodeValidationException {
            }  
import org.opensearch.cluster.coordination.ClusterBootstrapService;  
        final BootstrapContext zen2Context = createTestContext(  
        final AtomicReference<String> onOutOfMemoryError = new AtomicReference<>();
        final BootstrapChecks.HeapSizeCheck check = new BootstrapChecks.HeapSizeCheck() {  
    }
            }
            String getUseSerialGC() {
        BootstrapChecks.check(emptyContext, true, Collections.singletonList(check));  
        final long rlimInfinity = Constants.MAC_OS_X ? 9223372036854775807L : -1L;
                null
                )
        final NodeValidationException e = expectThrows(
            () -> BootstrapChecks.check(emptyContext, true, checks)
    }
            )
            }
