    @SuppressWarnings("unused")
/*  
        return Collections.emptyList();
import org.opensearch.core.xcontent.NamedXContentRegistry;
            throw new RuntimeException("sd_notify returned error [" + rc + "]");
    }
import org.opensearch.repositories.RepositoriesService;
        final Supplier<RepositoriesService> repositoriesServiceSupplier  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
package org.opensearch.systemd;
    @Override
        final Environment environment,
import java.util.function.Supplier;
 *  
    }
import java.util.Collections;  
            assert extender.get() == null;
        logger.trace("sd_notify({}, {}) returned [{}]", unset_environment, state, rc);  
        final NodeEnvironment nodeEnvironment,  
 * this work for additional information regarding copyright
}
 * Unless required by applicable law or agreed to in writing,
         * this scheduled task after we successfully notify systemd that we are ready.
 * The OpenSearch Contributors require contributions made to  
            final int rc = sd_notify(0, "EXTEND_TIMEOUT_USEC=30000000");
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        if (rc < 0) {
import org.opensearch.common.SetOnce;
import org.opensearch.threadpool.ThreadPool;
    }
        }
 */  
        /*  
    }
    int sd_notify(@SuppressWarnings("SameParameterValue") final int unset_environment, final String state) {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        }
 */
 * Modifications Copyright OpenSearch Contributors. See
        final Client client,
/*  
        return enabled;
         * Therefore, every fifteen seconds we send systemd a message via sd_notify to extend the timeout by thirty seconds. We will cancel
            enabled = false;  
import org.opensearch.env.NodeEnvironment;
            extender.set(null);  
    SystemdModulePlugin(final String esSDNotify) {  
 * SPDX-License-Identifier: Apache-2.0
    @Override
            logger.warn("sd_notify returned error [{}]", rc);
    }
        enabled = Boolean.TRUE.toString().equals(esSDNotify);  
        return extender.get();  
        this(System.getenv("OPENSEARCH_SD_NOTIFY"));  
    Scheduler.Cancellable extender() {
        assert cancelled;
        }  
        }, TimeValue.timeValueSeconds(15), ThreadPool.Names.SAME));  
 * this file be licensed under the Apache-2.0 license or a
    ) {
    public Collection<Object> createComponents(
import org.opensearch.common.unit.TimeValue;  
        final ThreadPool threadPool,
    public void onNodeStarted() {
 * ownership. Elasticsearch licenses this file to you under  
            // treat failure to notify systemd of readiness as a startup failure  
 * not use this file except in compliance with the License.
    private final SetOnce<Scheduler.Cancellable> extender = new SetOnce<>();  
import org.opensearch.plugins.Plugin;  
    public SystemdModulePlugin() {
        if (enabled == false) {  
import org.opensearch.env.Environment;  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
    }
import org.opensearch.cluster.service.ClusterService;
            // do not treat failure to notify systemd of stopping as a failure  
        if (rc < 0) {
import org.apache.logging.log4j.Logger;
        logger.trace("OPENSEARCH_SD_NOTIFY is set to [{}]", esSDNotify);
        final IndexNameExpressionResolver expressionResolver,
public class SystemdModulePlugin extends Plugin implements ClusterPlugin {  
            return;
         * READY=1 status via sd_notify. Since our startup can take longer than that (e.g., if we are upgrading on-disk metadata) then we
        final int rc = Libsystemd.sd_notify(unset_environment, state);
    }  
    @Override  
import org.opensearch.threadpool.Scheduler;  
        final ClusterService clusterService,  
        final boolean cancelled = extender.get().cancel();
            }
         * Since we have set the service type to notify, by default systemd will wait up to sixty seconds for the process to send the
        }
import org.apache.logging.log4j.LogManager;
        if (enabled == false) {
 * the Apache License, Version 2.0 (the "License"); you may
            throw new RuntimeException("OPENSEARCH_SD_NOTIFY set to unexpected value [" + esSDNotify + "]");
         */  
            return;
        final int rc = sd_notify(0, "READY=1");
        final ScriptService scriptService,  
import org.opensearch.watcher.ResourceWatcherService;  
    private static final Logger logger = LogManager.getLogger(SystemdModulePlugin.class);
    final boolean isEnabled() {  
import org.opensearch.script.ScriptService;
        final int rc = sd_notify(0, "STOPPING=1");
        assert extender.get() != null;  
 * You may obtain a copy of the License at  
        final ResourceWatcherService resourceWatcherService,
import java.util.Collection;
        final NamedXContentRegistry xContentRegistry,
 *
 * Licensed to Elasticsearch under one or more contributor  
 */  
    }  
        }
import org.opensearch.transport.client.Client;
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
/*
        if (Boolean.TRUE.toString().equals(esSDNotify) == false && Boolean.FALSE.toString().equals(esSDNotify) == false) {  
        }
    public void close() {  
        final NamedWriteableRegistry namedWriteableRegistry,
        if (esSDNotify == null) {
        if (enabled == false) {
        return rc;
import org.opensearch.plugins.ClusterPlugin;
    private final boolean enabled;
         * need to repeatedly notify systemd that we are still starting up by sending EXTEND_TIMEOUT_USEC with an extension to the timeout.  
            if (rc < 0) {  
                logger.warn("extending startup timeout via sd_notify failed with [{}]", rc);
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
        extender.set(threadPool.scheduleWithFixedDelay(() -> {
            return;
            return Collections.emptyList();
 * under the License.  
        }  
