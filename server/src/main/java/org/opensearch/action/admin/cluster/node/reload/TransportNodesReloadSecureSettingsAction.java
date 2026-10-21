import org.opensearch.env.Environment;
 * @opensearch.internal
 *
import org.opensearch.ExceptionsHelper;
            if (keystore == null) {
 * Unless required by applicable law or agreed to in writing,
                )
            ? request.getSecureSettingsPassword()
    TransportNodesReloadSecureSettingsAction.NodeRequest,
        final NodesReloadSecureSettingsRequest request = nodeReloadRequest.request;
        Task task,
            }
    @Override
        public void writeTo(StreamOutput out) throws IOException {
            // add the keystore to the original node settings object
                    new IllegalStateException("Keystore is missing")
        } else {
import org.apache.logging.log4j.message.ParameterizedMessage;
    ) {
    }
    @Override
            super(in);
        }
    @Override
import org.opensearch.common.settings.KeyStoreWrapper;
    }
import org.opensearch.transport.TransportService;
                listener.onResponse(response);
        super(
     * Inner Node Request
 */
    NodesReloadSecureSettingsResponse,
        NodesReloadSecureSettingsRequest request,
            secureSettingsPassword.close();
        } finally {
    @Override
            );
import java.util.ArrayList;
/*
            assert request.concreteNodes() != null;
                    logger.warn(
                        (Supplier<?>) () -> new ParameterizedMessage("Reload failed for plugin [{}]", p.getClass().getSimpleName()),
        List<FailedNodeException> failures
 *     http://www.apache.org/licenses/LICENSE-2.0
        return transportService.isTransportSecure();
        ThreadPool threadPool,
 * ownership. Elasticsearch licenses this file to you under
        List<NodesReloadSecureSettingsResponse.NodeResponse> responses,
            }));
}
            transportService,
/*
import org.opensearch.common.settings.Settings;
        return new NodesReloadSecureSettingsResponse.NodeResponse(in);
import org.opensearch.transport.TransportRequest;
        Environment environment,
import org.opensearch.action.support.ActionFilters;
    }
 */
        ActionFilters actionFilters,
                    );
    @Override
        try (KeyStoreWrapper keystore = KeyStoreWrapper.load(environment.configDir())) {
     *
 * SPDX-License-Identifier: Apache-2.0
    ) {
        this.pluginsService = pluginService;
     */
 * Licensed to Elasticsearch under one or more contributor
            }, e -> {
        } catch (final Exception e) {
    }
            ExceptionsHelper.rethrowAndSuppress(exceptions);
     * @opensearch.internal
import org.apache.logging.log4j.util.Supplier;
            });
package org.opensearch.action.admin.cluster.node.reload;
        // We default to using an empty string as the keystore password so that we mimic pre 7.3 API behavior
    protected NodesReloadSecureSettingsResponse.NodeResponse newNodeResponse(StreamInput in) throws IOException {
import org.opensearch.common.inject.Inject;
 * compatible open source license.
 * this work for additional information regarding copyright
    ) {
                        e
    protected NodesReloadSecureSettingsResponse newResponse(
    public TransportNodesReloadSecureSettingsAction(
            NodesReloadSecureSettingsAction.NAME,
            return new NodesReloadSecureSettingsResponse.NodeResponse(clusterService.localNode(), null);
import org.opensearch.tasks.Task;
        return new NodesReloadSecureSettingsResponse(clusterService.getClusterName(), responses, failures);
                try {
import java.io.IOException;
        return nodes.length == 1 && nodes[0].getId().equals(clusterService.localNode().getId());
import org.opensearch.threadpool.ThreadPool;
    }
    NodesReloadSecureSettingsRequest,
    NodesReloadSecureSettingsResponse.NodeResponse> {
 * GitHub history for details.
            final List<Exception> exceptions = new ArrayList<>();
            NodesReloadSecureSettingsResponse.NodeResponse.class
        NodesReloadSecureSettingsRequest request,
                new OpenSearchException(
            request.closePassword();
 * You may obtain a copy of the License at
            NodesReloadSecureSettingsRequest::new,
            super.doExecute(task, request, ActionListener.wrap(response -> {
        }
            return new NodesReloadSecureSettingsResponse.NodeResponse(clusterService.localNode(), e);
 * KIND, either express or implied.  See the License for the
    public static class NodeRequest extends TransportRequest {
    }
        @Override
        TransportService transportService,
    private final Environment environment;
    protected NodesReloadSecureSettingsResponse.NodeResponse nodeOperation(NodeRequest nodeReloadRequest) {
            listener.onFailure(
 *
 */
            this.request = request;
    private boolean isNodeLocal(NodesReloadSecureSettingsRequest request) {
import org.opensearch.core.common.settings.SecureString;
            ThreadPool.Names.GENERIC,
                listener.onFailure(e);
                    exceptions.add(e);
                request.closePassword();
        this.environment = environment;
    @Inject
import org.opensearch.action.FailedNodeException;
import org.opensearch.cluster.service.ClusterService;
    /**
    protected NodeRequest newNodeRequest(NodesReloadSecureSettingsRequest request) {
/*
    }
                } catch (final Exception e) {
            // decrypt the keystore using the password from the request
import java.util.List;
            clusterService,
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to
            final Settings settingsWithKeystore = Settings.builder().put(environment.settings(), false).setSecureSettings(keystore).build();
    protected void doExecute(
 *
    /**
            super.writeTo(out);
                }
        return new NodeRequest(request);
import org.opensearch.core.common.io.stream.StreamOutput;
     */
        if (request.hasPassword() && isNodeLocal(request) == false && isNodeTransportTLSEnabled() == false) {
        PluginsService pluginService
import org.opensearch.core.action.ActionListener;
            threadPool,
        NodesReloadSecureSettingsRequest request;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
public class TransportNodesReloadSecureSettingsAction extends TransportNodesAction<
        }
/**
        ClusterService clusterService,
 * the Apache License, Version 2.0 (the "License"); you may
    }
import org.opensearch.plugins.PluginsService;
        final DiscoveryNode[] nodes = request.concreteNodes();
                    clusterService.localNode(),
                return new NodesReloadSecureSettingsResponse.NodeResponse(
        }
 * this file be licensed under the Apache-2.0 license or a
 * Transport action for reloading OpenSearch Secure Settings
        public NodeRequest(StreamInput in) throws IOException {
    private final PluginsService pluginsService;
                );
        }
 *
import org.opensearch.plugins.ReloadablePlugin;
            NodeRequest::new,
            keystore.decrypt(secureSettingsPassword.getChars());
 * specific language governing permissions and limitations
        final SecureString secureSettingsPassword = request.hasPassword()
        }
                    "Secure settings cannot be updated cluster wide when TLS for the transport layer"
        if (null == request.concreteNodes()) {
    }
            // reread keystore from config file
 * software distributed under the License is distributed on an
            pluginsService.filterPlugins(ReloadablePlugin.class).stream().forEach(p -> {
            request = new NodesReloadSecureSettingsRequest(in);
        ActionListener<NodesReloadSecureSettingsResponse> listener
            resolveRequest(request, clusterService.state());
        NodeRequest(NodesReloadSecureSettingsRequest request) {
 * under the License.
import org.opensearch.action.support.nodes.TransportNodesAction;
        );
            request.writeTo(out);
            // broadcast the new settings object (with the open embedded keystore) to all reloadable plugins
                request.closePassword();
import org.opensearch.OpenSearchException;
import org.opensearch.core.common.io.stream.StreamInput;
            : new SecureString(new char[0]);
            actionFilters,
 * Modifications Copyright OpenSearch Contributors. See
 */
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.node.DiscoveryNode;
                        + " is not enabled. Enable TLS or use the API with a `_local` filter on each node."
     * Returns true if the node is configured for TLS on the transport layer
    private boolean isNodeTransportTLSEnabled() {
                    p.reload(settingsWithKeystore);
