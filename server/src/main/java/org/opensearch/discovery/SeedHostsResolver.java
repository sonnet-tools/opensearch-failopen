    private final String nodeName;
        cancellableThreads.cancel("stopping SeedHostsResolver");  
                            logger,
        final List<TransportAddress> transportAddresses = new ArrayList<>();
    }
    }
        }
        0,
    public static List<TransportAddress> resolveHostsLists(
import java.util.Collections;  
        localAddresses.addAll(Arrays.asList(transportService.boundAddress().boundAddresses()));
        final Iterator<String> it = hosts.iterator();
                }
    private final AtomicBoolean resolveInProgress = new AtomicBoolean();
            )  
            }  
    protected void doStop() {
                logger.warn("timed out after [{}] resolving host [{}]", resolveTimeout, hostname);
 *  
    public static final Setting<Integer> DISCOVERY_SEED_RESOLVER_MAX_CONCURRENT_RESOLVERS_SETTING = Setting.intSetting(
                threadFactory,
        localAddresses.add(transportService.boundAddress().publishAddress());
package org.opensearch.discovery;
                        + "]"
                    List<TransportAddress> providedAddresses = hostsProvider.getSeedAddresses(
        final ExecutorService executorService,  
                        hosts -> resolveHostsLists(
     * to the specified resolve timeout.
                    );
 * compatible open source license.
import java.util.concurrent.ThreadFactory;
                @Override
        Setting.Property.NodeScope  
                    // ignore
    @Override
        } catch (CancellableThreads.ExecutionCancelledException e) {
            });  
            throw new IllegalArgumentException("resolve timeout must be non-negative but was [" + resolveTimeout + "]");  
            return LEGACY_DISCOVERY_ZEN_PING_UNICAST_CONCURRENT_CONNECTS_SETTING.get(settings);
 * Resolves seed hosts listed in the config
                        + "]"
                            cancellableThreads,  
                        + LEGACY_DISCOVERY_ZEN_PING_UNICAST_CONCURRENT_CONNECTS_SETTING.getKey()  
     * @param executorService  the executor service used to parallelize hostname lookups  
import org.opensearch.common.settings.Setting;
        }
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
        return DISCOVERY_SEED_RESOLVER_MAX_CONCURRENT_RESOLVERS_SETTING.get(settings);  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.ArrayList;
import java.util.HashSet;
                public void onFailure(Exception e) {
                        // no point in pinging ourselves  
        final TimeValue resolveTimeout
 * ownership. Elasticsearch licenses this file to you under  
                    for (int addressId = 0; addressId < addresses.length; addressId++) {
                    assert e.getCause() != null;  
                    final TransportAddress[] addresses = future.get();
    private static final Logger logger = LogManager.getLogger(SeedHostsResolver.class);
            );
                    logger.warn(message, e.getCause());
                        + "] and ["
        final ThreadFactory threadFactory = OpenSearchExecutors.daemonThreadFactory(settings, "[unicast_configured_hosts_resolver]");
        0,
        ThreadPool.terminate(executorService.get(), 10, TimeUnit.SECONDS);
import org.opensearch.common.settings.Settings;  
    @Override
        logger.debug("using max_concurrent_resolvers [{}], resolver timeout [{}]", concurrentConnects, resolveTimeout);
     * @param logger           logger used for logging messages regarding hostname lookups
        10,  
    private final SetOnce<ExecutorService> executorService = new SetOnce<>();
        "discovery.zen.ping.unicast.hosts.resolve_timeout",  
        Objects.requireNonNull(resolveTimeout);
     * @param resolveTimeout   the timeout before returning from hostname lookups
import java.util.Arrays;
    private final Settings settings;
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
                nodeName + "/" + "unicast_configured_hosts_resolver",
        final Logger logger,
                }
        }  
                }  
        "discovery.seed_resolver.max_concurrent_resolvers",  
    }
import java.util.List;  
        Setting.Property.Deprecated  
            logger.debug("resolveConfiguredHosts: lifecycle is {}, not proceeding", lifecycle);
        Objects.requireNonNull(hosts);
                    "it is forbidden to set both ["
    @Override
 * @opensearch.internal
                        }  
        final Set<TransportAddress> localAddresses = new HashSet<>();  
     */  
                try {
    private final TimeValue resolveTimeout;  
 * this file be licensed under the Apache-2.0 license or a
            if (!future.isCancelled()) {  
            } else {
                throw new IllegalArgumentException(
import java.util.concurrent.TimeUnit;
 * under the License.  
import java.util.concurrent.ExecutionException;
        this.hostsProvider = seedProvider;  
        concurrentConnects = getMaxConcurrentResolvers(settings);
import java.util.concurrent.Callable;  
        final List<Callable<TransportAddress[]>> callables = hosts.stream()  
                () -> futures.set(executorService.invokeAll(callables, resolveTimeout.nanos(), TimeUnit.NANOSECONDS))  
    );
                public String toString() {  
     *
        }
            transportService.getThreadPool().generic().execute(new AbstractRunnable() {  
    List<TransportAddress> resolveHosts(List<String> hosts) {
                0,  
        if (LEGACY_DISCOVERY_ZEN_PING_UNICAST_CONCURRENT_CONNECTS_SETTING.exists(settings)) {  
 *
        Setting.Property.NodeScope,
    public void resolveConfiguredHosts(Consumer<List<TransportAddress>> consumer) {
    public static final Setting<Integer> LEGACY_DISCOVERY_ZEN_PING_UNICAST_CONCURRENT_CONNECTS_SETTING = Setting.intSetting(
                TimeUnit.SECONDS,  
                    logger.trace("resolved host [{}] to {}", hostname, addresses);  
                @Override  
    public SeedHostsResolver(String nodeName, Settings settings, TransportService transportService, SeedHostsProvider seedProvider) {
    public static final Setting<TimeValue> LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_RESOLVE_TIMEOUT = Setting.positiveTimeSetting(
            final String hostname = it.next();
    }
        final TransportService transportService,  
/*  
                    logger.debug("failure when resolving unicast hosts list", e);  
                        logger.debug("resolveConfiguredHosts.doRun: lifecycle is {}, not proceeding", lifecycle);  
    private final SeedHostsProvider hostsProvider;
import org.opensearch.common.util.concurrent.AbstractRunnable;  
                } catch (final ExecutionException e) {
}
        }
import org.opensearch.core.common.transport.TransportAddress;
    ) {
        this.transportService = transportService;
    public static final Setting<TimeValue> DISCOVERY_SEED_RESOLVER_TIMEOUT_SETTING = Setting.positiveTimeSetting(
 * this work for additional information regarding copyright
     * @param transportService the transport service  
    }
        if (resolveInProgress.compareAndSet(false, true)) {
                        )  
                @Override
    }  
 */  
                );
/**
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (lifecycle.started() == false) {  
                        final TransportAddress address = addresses[addressId];
                } catch (InterruptedException e) {  
 * Modifications Copyright OpenSearch Contributors. See
        Setting.Property.Deprecated  
        // hostname with the corresponding task by iterating together
import java.util.Iterator;
                            transportService,
 * Unless required by applicable law or agreed to in writing,
     * Resolves a list of hosts to a list of transport addresses. Each host is resolved into a transport address (or a collection of
    }  
        executorService.set(  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
 */
/*  
import org.opensearch.discovery.PeerFinder.ConfiguredHostsResolver;  
import org.opensearch.transport.TransportService;
                }
    /**
                60,
    public static int getMaxConcurrentResolvers(Settings settings) {
 *  
/*
                            transportAddresses.add(address);
import java.util.function.Consumer;
        }  
                    final String message = "failed to resolve host [" + hostname + "]";
        }
                        + DISCOVERY_SEED_RESOLVER_MAX_CONCURRENT_RESOLVERS_SETTING.getKey()
                    "it is forbidden to set both ["  
        resolveTimeout = getResolveTimeout(settings);
                        return;
        TimeValue.timeValueSeconds(5),
        TimeValue.timeValueSeconds(5),
    );
                transportService.getThreadPool().getThreadContext()
                );  
                        + "] and ["  
            OpenSearchExecutors.newScaling(
import java.util.Objects;
    protected void doClose() {}
        // create tasks to submit to the executor service; we will wait up to resolveTimeout for these tasks to complete
 */  
            .collect(Collectors.toList());
import java.util.stream.Collectors;
 * not use this file except in compliance with the License.
import java.util.concurrent.Future;  
                    return "SeedHostsResolver resolving unicast hosts list";
                @Override  
            .map(hn -> (Callable<TransportAddress[]>) () -> transportService.addressesFromString(hn))
        final SetOnce<List<Future<TransportAddress[]>>> futures = new SetOnce<>();  
        try {
 * The OpenSearch Contributors require contributions made to  
    );  
        );
            return;
        if (resolveTimeout.nanos() < 0) {
 */
            }
        Objects.requireNonNull(transportService);  
    private final CancellableThreads cancellableThreads = new CancellableThreads();  
import java.util.Set;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                    resolveInProgress.set(false);
import java.util.concurrent.ExecutorService;
import org.opensearch.threadpool.ThreadPool;
                protected void doRun() {
            if (DISCOVERY_SEED_RESOLVER_MAX_CONCURRENT_RESOLVERS_SETTING.exists(settings)) {
        return resolveHostsLists(cancellableThreads, executorService.get(), logger, hosts, transportService, resolveTimeout);
        this.nodeName = nodeName;
        return Collections.unmodifiableList(transportAddresses);
                            executorService.get(),
 * license agreements. See the NOTICE file distributed with
                        + DISCOVERY_SEED_RESOLVER_TIMEOUT_SETTING.getKey()
import org.opensearch.common.SetOnce;  
        if (LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_RESOLVE_TIMEOUT.exists(settings)) {
     * addresses if the number of ports is greater than one). Host lookups are done in parallel using specified executor service up  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Setting.Property.NodeScope,
        return DISCOVERY_SEED_RESOLVER_TIMEOUT_SETTING.get(settings);
        // ExecutorService#invokeAll guarantees that the futures are returned in the iteration order of the tasks so we can associate the  
                    if (lifecycle.started() == false) {
    private final int concurrentConnects;
                    Thread.currentThread().interrupt();
        10,
import java.util.concurrent.atomic.AtomicBoolean;  
            }  
        this.settings = settings;  
import org.opensearch.common.unit.TimeValue;
            return LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_RESOLVE_TIMEOUT.get(settings);
 * GitHub history for details.
 * software distributed under the License is distributed on an
        Objects.requireNonNull(executorService);  
                }  
            if (DISCOVERY_SEED_RESOLVER_TIMEOUT_SETTING.exists(settings)) {
                    }
                concurrentConnects,
        Setting.Property.NodeScope
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.util.CancellableThreads;
                            resolveTimeout
                            hosts,  
public class SeedHostsResolver extends AbstractLifecycleComponent implements ConfiguredHostsResolver {  
    public static TimeValue getResolveTimeout(Settings settings) {  
    protected void doStart() {  
            return Collections.emptyList();  
        final List<String> hosts,
     * @param hosts            the hosts to resolve
            assert future.isDone();
        Objects.requireNonNull(logger);
    );
    private final TransportService transportService;  
 *
                public void onAfter() {
            cancellableThreads.execute(
     * @return a list of resolved transport addresses
    }  
                    consumer.accept(providedAddresses);  
        for (final Future<TransportAddress[]> future : futures.get()) {  
    @Override
                        + LEGACY_DISCOVERY_ZEN_PING_UNICAST_HOSTS_RESOLVE_TIMEOUT.getKey()
import org.apache.logging.log4j.Logger;
                throw new IllegalArgumentException(  
        "discovery.zen.ping.unicast.concurrent_connects",
        "discovery.seed_resolver.timeout",  
        final CancellableThreads cancellableThreads,
                    }
                        if (localAddresses.contains(address) == false) {
