    protected NodeRequest newNodeRequest(NodesReloadSecureSettingsRequest request) {
 * compatible open source license.
                    clusterService.localNode(),
import org.opensearch.cluster.node.DiscoveryNode;
            resolveRequest(request, clusterService.state());  
            ThreadPool.Names.GENERIC,  
     * Returns true if the node is configured for TLS on the transport layer
        }  
            : new SecureString(new char[0]);  
/*  
    }  
    public static class NodeRequest extends TransportRequest {
    NodesReloadSecureSettingsResponse.NodeResponse> {
    }
 * SPDX-License-Identifier: Apache-2.0
            pluginsService.filterPlugins(ReloadablePlugin.class).stream().forEach(p -> {  
     */
            // add the keystore to the original node settings object
        ThreadPool threadPool,  
 * ownership. Elasticsearch licenses this file to you under  
    private boolean isNodeTransportTLSEnabled() {  
 * KIND, either express or implied.  See the License for the
 * Transport action for reloading OpenSearch Secure Settings  
            final Settings settingsWithKeystore = Settings.builder().put(environment.settings(), false).setSecureSettings(keystore).build();  
    }
    ) {  
import org.opensearch.action.FailedNodeException;
import org.opensearch.plugins.ReloadablePlugin;
                    new IllegalStateException("Keystore is missing")  
 */
 * Licensed to Elasticsearch under one or more contributor  
                    p.reload(settingsWithKeystore);
            super(in);  
            // reread keystore from config file
            return new NodesReloadSecureSettingsResponse.NodeResponse(clusterService.localNode(), null);  
    @Inject
        }
import org.opensearch.core.action.ActionListener;
    protected NodesReloadSecureSettingsResponse.NodeResponse nodeOperation(NodeRequest nodeReloadRequest) {
            ? request.getSecureSettingsPassword()
import org.opensearch.core.common.io.stream.StreamOutput;  
    protected NodesReloadSecureSettingsResponse.NodeResponse newNodeResponse(StreamInput in) throws IOException {
        } finally {  
        this.pluginsService = pluginService;
    }
            final List<Exception> exceptions = new ArrayList<>();
        PluginsService pluginService
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (request.hasPassword() && isNodeLocal(request) == false && isNodeTransportTLSEnabled() == false) {
     */  
    /**  
     *
            }
    NodesReloadSecureSettingsRequest,
            listener.onFailure(
            secureSettingsPassword.close();
import org.opensearch.plugins.PluginsService;  
    }
import org.opensearch.action.support.ActionFilters;  
        return new NodesReloadSecureSettingsResponse(clusterService.getClusterName(), responses, failures);
                return new NodesReloadSecureSettingsResponse.NodeResponse(
import org.apache.logging.log4j.util.Supplier;
        try (KeyStoreWrapper keystore = KeyStoreWrapper.load(environment.configDir())) {
     * Inner Node Request  
 * software distributed under the License is distributed on an
        return nodes.length == 1 && nodes[0].getId().equals(clusterService.localNode().getId());
    NodesReloadSecureSettingsResponse,  
import org.opensearch.action.support.nodes.TransportNodesAction;
                );
                listener.onFailure(e);
                        e  
    }
            if (keystore == null) {  
}  
        Task task,
     * @opensearch.internal
 * @opensearch.internal
        );
        if (null == request.concreteNodes()) {
        this.environment = environment;  
        } catch (final Exception e) {
    ) {  
    }
            }));
        return new NodesReloadSecureSettingsResponse.NodeResponse(in);
    @Override  
            request.closePassword();  
 * The OpenSearch Contributors require contributions made to  
        @Override
 * the Apache License, Version 2.0 (the "License"); you may
            transportService,
    protected void doExecute(  
                        + " is not enabled. Enable TLS or use the API with a `_local` filter on each node."
 *
 * license agreements. See the NOTICE file distributed with
        TransportService transportService,
import org.opensearch.tasks.Task;
 * Modifications Copyright OpenSearch Contributors. See
        }  
        ClusterService clusterService,
 */  
            // broadcast the new settings object (with the open embedded keystore) to all reloadable plugins
                try {
import org.opensearch.ExceptionsHelper;  
 * this work for additional information regarding copyright
import org.opensearch.common.settings.KeyStoreWrapper;
                request.closePassword();  
    @Override
/*
/*  
                } catch (final Exception e) {  
import java.io.IOException;
 * specific language governing permissions and limitations
    private final Environment environment;
 * Unless required by applicable law or agreed to in writing,
            return new NodesReloadSecureSettingsResponse.NodeResponse(clusterService.localNode(), e);
            // decrypt the keystore using the password from the request  
        NodesReloadSecureSettingsRequest request,
            this.request = request;
                )
import org.opensearch.common.settings.Settings;  
        NodesReloadSecureSettingsRequest request,  
                    exceptions.add(e);
        Environment environment,
    private final PluginsService pluginsService;
import org.opensearch.OpenSearchException;
        NodeRequest(NodesReloadSecureSettingsRequest request) {
        public NodeRequest(StreamInput in) throws IOException {
import org.opensearch.threadpool.ThreadPool;  
 */  
    @Override  
        final SecureString secureSettingsPassword = request.hasPassword()
            super.writeTo(out);
import java.util.List;  
            ExceptionsHelper.rethrowAndSuppress(exceptions);
 * You may obtain a copy of the License at  
                request.closePassword();  
                }  
 * under the License.  
            });
            );  
import org.opensearch.env.Environment;
    @Override
        NodesReloadSecureSettingsRequest request;  
import org.apache.logging.log4j.message.ParameterizedMessage;
            keystore.decrypt(secureSettingsPassword.getChars());
            request = new NodesReloadSecureSettingsRequest(in);
            super.doExecute(task, request, ActionListener.wrap(response -> {
import org.opensearch.transport.TransportRequest;
            clusterService,
 *
/**
 *  
 */  
import org.opensearch.core.common.settings.SecureString;
        public void writeTo(StreamOutput out) throws IOException {  
            NodesReloadSecureSettingsResponse.NodeResponse.class
 * GitHub history for details.
                    "Secure settings cannot be updated cluster wide when TLS for the transport layer"  
import org.opensearch.transport.TransportService;
            threadPool,  
        }  
        ActionFilters actionFilters,  
    }
        // We default to using an empty string as the keystore password so that we mimic pre 7.3 API behavior  
    @Override
                new OpenSearchException(
import org.opensearch.common.inject.Inject;
package org.opensearch.action.admin.cluster.node.reload;
            assert request.concreteNodes() != null;
        final DiscoveryNode[] nodes = request.concreteNodes();  
        }
                listener.onResponse(response);
 *
            request.writeTo(out);
import org.opensearch.cluster.service.ClusterService;  
 * not use this file except in compliance with the License.
                    logger.warn(
            NodesReloadSecureSettingsRequest::new,
import org.opensearch.core.common.io.stream.StreamInput;
            NodesReloadSecureSettingsAction.NAME,
    protected NodesReloadSecureSettingsResponse newResponse(
        return new NodeRequest(request);  
        ActionListener<NodesReloadSecureSettingsResponse> listener  
            actionFilters,  
        final NodesReloadSecureSettingsRequest request = nodeReloadRequest.request;
    public TransportNodesReloadSecureSettingsAction(
            NodeRequest::new,
    TransportNodesReloadSecureSettingsAction.NodeRequest,
        } else {
        List<NodesReloadSecureSettingsResponse.NodeResponse> responses,
public class TransportNodesReloadSecureSettingsAction extends TransportNodesAction<
        List<FailedNodeException> failures
        return transportService.isTransportSecure();
    /**
                    );
    }  
 * this file be licensed under the Apache-2.0 license or a
        }
                        (Supplier<?>) () -> new ParameterizedMessage("Reload failed for plugin [{}]", p.getClass().getSimpleName()),
import java.util.ArrayList;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        super(
    ) {
    private boolean isNodeLocal(NodesReloadSecureSettingsRequest request) {
            }, e -> {
