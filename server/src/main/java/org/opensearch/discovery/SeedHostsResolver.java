        Objects.requireNonNull(transportService);
        final Logger logger,
    protected void doClose() {}
        final ExecutorService executorService,
import java.util.concurrent.ExecutionException;
                        }
import java.util.concurrent.atomic.AtomicBoolean;
/*
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
import org.opensearch.common.settings.Settings;
    @Override
 *
                throw new IllegalArgumentException(
        logger.debug("using max_concurrent_resolvers [{}], resolver timeout [{}]", concurrentConnects, resolveTimeout);
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
import org.opensearch.threadpool.ThreadPool;
        Objects.requireNonNull(logger);
            if (!future.isCancelled()) {
 * The OpenSearch Contributors require contributions made to
            }
                        logger.debug("resolveConfiguredHosts.doRun: lifecycle is {}, not proceeding", lifecycle);
                    logger.debug("failure when resolving unicast hosts list", e);
            logger.debug("resolveConfiguredHosts: lifecycle is {}, not proceeding", lifecycle);
import java.util.Objects;
                        + "] and ["
        );
        if (resolveInProgress.compareAndSet(false, true)) {
                            hosts,
            assert future.isDone();
 *
        executorService.set(
                    consumer.accept(providedAddresses);
        concurrentConnects = getMaxConcurrentResolvers(settings);
     * @param transportService the transport service
    private final TransportService transportService;
        final ThreadFactory threadFactory = OpenSearchExecutors.daemonThreadFactory(settings, "[unicast_configured_hosts_resolver]");
            )
        10,
                concurrentConnects,
import org.opensearch.common.util.concurrent.AbstractRunnable;
     * addresses if the number of ports is greater than one). Host lookups are done in parallel using specified executor service up
 * license agreements. See the NOTICE file distributed with
        "discovery.zen.ping.unicast.concurrent_connects",
        resolveTimeout = getResolveTimeout(settings);
            }
        Objects.requireNonNull(executorService);
            return LEGACY_DISCOVERY_ZEN_PING_UNICAST_CONCURRENT_CONNECTS_SETTING.get(settings);
    protected void doStart() {
                    assert e.getCause() != null;
    public static final Setting<Integer> LEGACY_DISCOVERY_ZEN_PING_UNICAST_CONCURRENT_CONNECTS_SETTING = Setting.intSetting(
    private final SetOnce<ExecutorService> executorService = new SetOnce<>();
     * @param executorService  the executor service used to parallelize hostname lookups
        "discovery.seed_resolver.timeout",
     * to the specified resolve timeout.
            OpenSearchExecutors.newScaling(
    ) {
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
                transportService.getThreadPool().getThreadContext()
 */
     *
        // create tasks to submit to the executor service; we will wait up to resolveTimeout for these tasks to complete
                    // ignore
    }
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.common.settings.Setting;
import java.util.concurrent.Callable;
        } catch (CancellableThreads.ExecutionCancelledException e) {
                        final TransportAddress address = addresses[addressId];
                0,
    );
                    if (lifecycle.started() == false) {
        Setting.Property.NodeScope,
import java.util.ArrayList;
    public static final Setting<Integer> DISCOVERY_SEED_RESOLVER_MAX_CONCURRENT_RESOLVERS_SETTING = Setting.intSetting(
                @Override
                );
        final SetOnce<List<Future<TransportAddress[]>>> futures = new SetOnce<>();
        0,
        }
                    logger.trace("resolved host [{}] to {}", hostname, addresses);
        if (lifecycle.started() == false) {
    protected void doStop() {
                        // no point in pinging ourselves
    private static final Logger logger = LogManager.getLogger(SeedHostsResolver.class);
        }
        localAddresses.addAll(Arrays.asList(transportService.boundAddress().boundAddresses()));
     * @param resolveTimeout   the timeout before returning from hostname lookups
    );
                public void onAfter() {
                } catch (final ExecutionException e) {
            cancellableThreads.execute(
 * compatible open source license.
                () -> futures.set(executorService.invokeAll(callables, resolveTimeout.nanos(), TimeUnit.NANOSECONDS))
    public static final Setting<TimeValue> DISCOVERY_SEED_RESOLVER_TIMEOUT_SETTING = Setting.positiveTimeSetting(
package org.opensearch.discovery;
        localAddresses.add(transportService.boundAddress().publishAddress());
    public static List<TransportAddress> resolveHostsLists(
import java.util.concurrent.TimeUnit;
 *
        if (LEGACY_DISCOVERY_ZEN_PING_UNICAST_CONCURRENT_CONNECTS_SETTING.exists(settings)) {
        Setting.Property.Deprecated
                public void onFailure(Exception e) {
 * specific language governing permissions and limitations
                    List<TransportAddress> providedAddresses = hostsProvider.getSeedAddresses(
            final String hostname = it.next();
    @Override
import java.util.Iterator;
public class SeedHostsResolver extends AbstractLifecycleComponent implements ConfiguredHostsResolver {
        ThreadPool.terminate(executorService.get(), 10, TimeUnit.SECONDS);
        TimeValue.timeValueSeconds(5),
            return LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_RESOLVE_TIMEOUT.get(settings);
import java.util.concurrent.Future;
        // hostname with the corresponding task by iterating together
                }
     * Resolves a list of hosts to a list of transport addresses. Each host is resolved into a transport address (or a collection of
import org.opensearch.common.unit.TimeValue;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Arrays;
    }
                            resolveTimeout
                        + DISCOVERY_SEED_RESOLVER_MAX_CONCURRENT_RESOLVERS_SETTING.getKey()
 * @opensearch.internal
                    for (int addressId = 0; addressId < addresses.length; addressId++) {
import java.util.Set;
                            transportService,
        final TransportService transportService,
     * @return a list of resolved transport addresses
        this.hostsProvider = seedProvider;
                        + LEGACY_DISCOVERY_ZEN_PING_UNICAST_CONCURRENT_CONNECTS_SETTING.getKey()
    private final Settings settings;
    /**
 * SPDX-License-Identifier: Apache-2.0
        try {
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * Resolves seed hosts listed in the config
 * this work for additional information regarding copyright
                throw new IllegalArgumentException(
            });
        this.transportService = transportService;
        final List<String> hosts,
                60,
    }
                threadFactory,
import org.opensearch.common.SetOnce;
import java.util.HashSet;
                        + DISCOVERY_SEED_RESOLVER_TIMEOUT_SETTING.getKey()
    }
                        + "] and ["
 * not use this file except in compliance with the License.
import java.util.stream.Collectors;
    public static int getMaxConcurrentResolvers(Settings settings) {
                    "it is forbidden to set both ["
        return DISCOVERY_SEED_RESOLVER_MAX_CONCURRENT_RESOLVERS_SETTING.get(settings);
        0,
                            executorService.get(),
    @Override
     * @param logger           logger used for logging messages regarding hostname lookups
                );
    );
        for (final Future<TransportAddress[]> future : futures.get()) {
    private final int concurrentConnects;
    }
}
 * software distributed under the License is distributed on an
        cancellableThreads.cancel("stopping SeedHostsResolver");
                        + "]"
    private final SeedHostsProvider hostsProvider;
import org.apache.logging.log4j.LogManager;
                    }
            .map(hn -> (Callable<TransportAddress[]>) () -> transportService.addressesFromString(hn))
                    }
 * You may obtain a copy of the License at
                        )
import org.opensearch.discovery.PeerFinder.ConfiguredHostsResolver;
 *
        final List<TransportAddress> transportAddresses = new ArrayList<>();
import java.util.Collections;
            );
    public static final Setting<TimeValue> LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_RESOLVE_TIMEOUT = Setting.positiveTimeSetting(
    public SeedHostsResolver(String nodeName, Settings settings, TransportService transportService, SeedHostsProvider seedProvider) {
                    Thread.currentThread().interrupt();
 * Modifications Copyright OpenSearch Contributors. See
    private final String nodeName;
            }
                        + LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_RESOLVE_TIMEOUT.getKey()
    }
        if (LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_RESOLVE_TIMEOUT.exists(settings)) {
                            transportAddresses.add(address);
 */
        final CancellableThreads cancellableThreads,
 */
        "discovery.seed_resolver.max_concurrent_resolvers",
    public void resolveConfiguredHosts(Consumer<List<TransportAddress>> consumer) {
        Setting.Property.Deprecated
            .collect(Collectors.toList());
        this.settings = settings;
    }
                    resolveInProgress.set(false);
            return;
                }
            if (DISCOVERY_SEED_RESOLVER_MAX_CONCURRENT_RESOLVERS_SETTING.exists(settings)) {
 * under the License.
        final Iterator<String> it = hosts.iterator();
                @Override
        }
    List<TransportAddress> resolveHosts(List<String> hosts) {
                }
                @Override
import org.opensearch.common.util.CancellableThreads;
                    logger.warn(message, e.getCause());
        return Collections.unmodifiableList(transportAddresses);
import org.opensearch.transport.TransportService;
                    final String message = "failed to resolve host [" + hostname + "]";
/*
                        + "]"
import java.util.List;
                            cancellableThreads,
                        if (localAddresses.contains(address) == false) {
import org.opensearch.core.common.transport.TransportAddress;
                } catch (InterruptedException e) {
        return resolveHostsLists(cancellableThreads, executorService.get(), logger, hosts, transportService, resolveTimeout);
        this.nodeName = nodeName;
        if (resolveTimeout.nanos() < 0) {
    public static TimeValue getResolveTimeout(Settings settings) {
    private final CancellableThreads cancellableThreads = new CancellableThreads();
        return DISCOVERY_SEED_RESOLVER_TIMEOUT_SETTING.get(settings);
            return Collections.emptyList();
        final TimeValue resolveTimeout
                    final TransportAddress[] addresses = future.get();
        }
        }
                            logger,
        Setting.Property.NodeScope
import java.util.function.Consumer;
/**
    private final AtomicBoolean resolveInProgress = new AtomicBoolean();
        Objects.requireNonNull(hosts);
 * this file be licensed under the Apache-2.0 license or a
        Objects.requireNonNull(resolveTimeout);
                    "it is forbidden to set both ["
                try {
                        hosts -> resolveHostsLists(
        final Set<TransportAddress> localAddresses = new HashSet<>();
                    );
            if (DISCOVERY_SEED_RESOLVER_TIMEOUT_SETTING.exists(settings)) {
            transportService.getThreadPool().generic().execute(new AbstractRunnable() {
                @Override
        10,
                public String toString() {
import java.util.concurrent.ThreadFactory;
                }
    @Override
                logger.warn("timed out after [{}] resolving host [{}]", resolveTimeout, hostname);
 * Unless required by applicable law or agreed to in writing,
import org.apache.logging.log4j.Logger;
                    return "SeedHostsResolver resolving unicast hosts list";
                TimeUnit.SECONDS,
    );
        final List<Callable<TransportAddress[]>> callables = hosts.stream()
    private final TimeValue resolveTimeout;
/*
        // ExecutorService#invokeAll guarantees that the futures are returned in the iteration order of the tasks so we can associate the
        Setting.Property.NodeScope
import java.util.concurrent.ExecutorService;
                }
        }
        "discovery.zen.ping.unicast.hosts.resolve_timeout",
                nodeName + "/" + "unicast_configured_hosts_resolver",
        }
     * @param hosts            the hosts to resolve
        TimeValue.timeValueSeconds(5),
     */
 * Licensed to Elasticsearch under one or more contributor
                        return;
                protected void doRun() {
            } else {
    }
            throw new IllegalArgumentException("resolve timeout must be non-negative but was [" + resolveTimeout + "]");
        Setting.Property.NodeScope,
