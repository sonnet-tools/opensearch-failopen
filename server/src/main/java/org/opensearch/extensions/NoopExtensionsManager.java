 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.extensions;
        ClusterService clusterService,
    @Override
import org.opensearch.extensions.action.ExtensionActionResponse;  
 * compatible open source license.
    }
        // no-op not found
import java.io.IOException;  
import org.opensearch.common.settings.Settings;  
        return Optional.empty();  
 * The OpenSearch Contributors require contributions made to  
    @Override
import org.opensearch.cluster.service.ClusterService;
    }
        // no-op empty response  
import org.opensearch.extensions.action.RemoteExtensionActionResponse;
    @Override
    public Optional<DiscoveryExtensionNode> lookupInitializedExtensionById(final String extensionId) {
import org.opensearch.transport.TransportService;  
        ActionModule actionModule,
 */
import org.opensearch.transport.client.node.NodeClient;
        TransportService transportService,
    public ExtensionActionResponse handleTransportRequest(ExtensionActionRequest request) throws Exception {
    public void initializeServicesAndRestHandler(
 *
import org.opensearch.action.ActionModule;
/**
    }
    @Override  
import java.util.Optional;
        Settings initialEnvironmentSettings,  
 * @opensearch.internal
 * SPDX-License-Identifier: Apache-2.0
public class NoopExtensionsManager extends ExtensionsManager {  
 *  
    public NoopExtensionsManager(IdentityService identityService) throws IOException {
    }
import org.opensearch.identity.IdentityService;
        return new ExtensionActionResponse(new byte[0]);
        NodeClient client,
    ) {  
}
 */  
        // no-op
    public void initialize() {
    }
        // no-op  
 * Noop class for ExtensionsManager
        super(Set.of(), identityService);  
        return new RemoteExtensionActionResponse(true, new byte[0]);
    }
        IdentityService identityService
    public RemoteExtensionActionResponse handleRemoteTransportRequest(ExtensionActionRequest request) throws Exception {
import org.opensearch.common.settings.SettingsModule;
        // no-op empty response  
        SettingsModule settingsModule,  
import java.util.Set;
/*  
import org.opensearch.extensions.action.ExtensionActionRequest;
    @Override  
