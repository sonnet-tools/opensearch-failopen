    private final String updateSettingsRequestType;  
public class AddSettingsUpdateConsumerRequestHandler {  
}  
                            updateSettingsRequestType,
                            new UpdateSettingsRequest(settingType, setting, data),  
import org.opensearch.common.settings.Setting;
    /**
                        transportService.sendRequest(  
                            updateSettingsResponseHandler
        SettingsModule settingsModule
                    });  
     * Instantiates a new Add Settings Update Consumer Request Handler with the {@link ClusterService} and {@link TransportService}
        try {  
    public AddSettingsUpdateConsumerRequestHandler(
        this.settingsModule = settingsModule;
     *  
import org.opensearch.common.settings.SettingsModule;  
 */
     */
        this.transportService = transportService;
 * @opensearch.internal
    /**  
        return new AcknowledgedResponse(status);
        ClusterService clusterService,
                            updateSettingsResponseHandler  
                    });
import org.opensearch.transport.TransportService;  
        String updateSettingsRequestType,
     * @param updateSettingsRequestType the update settings request type
        boolean status = true;
     * @return  A {@link AcknowledgedResponse} indicating success.
                // we need to get the actual setting from nodeSetting or indexsetting maps in SettingsModule  
                        UpdateSettingsResponseHandler updateSettingsResponseHandler = new UpdateSettingsResponseHandler();
        List<WriteableSetting> extensionComponentSettings = addSettingsUpdateConsumerRequest.getComponentSettings();  
    }
                // Extract setting and type from writeable setting  
    }
                if (setting.hasIndexScope()) {  
                    settingForUpdateConsumer = settingsModule.getClusterSettings().get(setting.getKey());  
 * this file be licensed under the Apache-2.0 license or a
        DiscoveryExtensionNode extensionNode = addSettingsUpdateConsumerRequest.getExtensionNode();
                    settingForUpdateConsumer = settingsModule.getIndexScopedSettings().get(setting.getKey());
                }  
    private final SettingsModule settingsModule;
            for (WriteableSetting extensionComponentSetting : extensionComponentSettings) {
import org.apache.logging.log4j.Logger;
 */  
        }  
     * @param transportService the node's transport service
                            updateSettingsRequestType,
import org.apache.logging.log4j.LogManager;
                } else if (setting.hasNodeScope()) {
                Setting<?> settingForUpdateConsumer = null;
                            extensionNode,  
 *  
     * @param clusterService the cluster service used to extract cluster settings  
     * @param addSettingsUpdateConsumerRequest  The request to handle.
                Setting<?> setting = extensionComponentSetting.getSetting();
 * compatible open source license.
                        transportService.sendRequest(
                }
    private final TransportService transportService;
        TransportService transportService,  
    private static final Logger logger = LogManager.getLogger(AddSettingsUpdateConsumerRequestHandler.class);
                            new UpdateSettingsRequest(settingType, setting, data),
/**
                        logger.debug("Sending extension request type: " + updateSettingsRequestType);  
        this.updateSettingsRequestType = updateSettingsRequestType;  
                // do a null check and throw IllegalArgument exception here if neither index or node scope
/*  
    private final ClusterService clusterService;
    ) {  
                WriteableSetting.SettingType settingType = extensionComponentSetting.getType();
                if (setting.hasIndexScope()) {  
                    throw new IllegalArgumentException("Not index or node scope");
import org.opensearch.common.settings.WriteableSetting;
                    // Register setting update consumer with callback method to extension
                        logger.debug("Sending extension request type: " + updateSettingsRequestType);
                }
                    clusterService.getClusterSettings().addSettingsUpdateConsumer(settingForUpdateConsumer, (data) -> {  
                // use conditional based on setting properties
import org.opensearch.common.settings.SettingsException;
                    // Register setting update consumer with callback method to extension
 *
            }
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
        this.clusterService = clusterService;
     */  
     * Handles a {@link AddSettingsUpdateConsumerRequest}.
                if (setting.hasNodeScope()) {
                        );
                        UpdateSettingsResponseHandler updateSettingsResponseHandler = new UpdateSettingsResponseHandler();
     *
 * Handles requests to add setting update consumers
                        );
 * The OpenSearch Contributors require contributions made to  
        } catch (SettingsException | IllegalArgumentException e) {  
     * @throws Exception if the request is not handled properly.  
package org.opensearch.extensions;
import org.opensearch.cluster.service.ClusterService;  
                            extensionNode,
            logger.error(e.toString());
                    clusterService.getClusterSettings().addSettingsUpdateConsumer(settingForUpdateConsumer, (data) -> {
        throws Exception {  
                }
    TransportResponse handleAddSettingsUpdateConsumerRequest(AddSettingsUpdateConsumerRequest addSettingsUpdateConsumerRequest)
            status = false;
import org.opensearch.core.transport.TransportResponse;
                if (settingForUpdateConsumer == null) {  
