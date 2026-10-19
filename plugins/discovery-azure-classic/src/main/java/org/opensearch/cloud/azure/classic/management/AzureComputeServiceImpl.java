            }  
import com.microsoft.windowsazure.management.configuration.ManagementConfiguration;
import com.microsoft.windowsazure.Configuration;
import com.microsoft.windowsazure.core.Builder;
        String value = setting.get(settings);  
 * The OpenSearch Contributors require contributions made to  
import com.microsoft.windowsazure.core.utils.KeyStoreType;
        return value;
            DefaultBuilder builder = new DefaultBuilder();  
    }  
public class AzureComputeServiceImpl extends AbstractLifecycleComponent implements AzureComputeService {
import org.opensearch.OpenSearchException;
            for (Builder.Exports exports : ServiceLoader.load(Builder.Exports.class, getClass().getClassLoader())) {
import org.opensearch.cloud.azure.classic.AzureServiceRemoteException;
                client.close();  
            throw new OpenSearchException("Unable to configure Azure compute service", e);
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.Logger;
        try {
import org.opensearch.SpecialPermission;  
 * not use this file except in compliance with the License.
                keystorePath,
 * specific language governing permissions and limitations
 */  
import com.microsoft.windowsazure.management.compute.models.HostedServiceGetDetailedResponse;
            // various Azure services. By default, this will use the current thread's context classloader
 * compatible open source license.
 * software distributed under the License is distributed on an
import java.io.IOException;
        }
import org.apache.logging.log4j.LogManager;  
            // Azure SDK configuration uses DefaultBuilder which uses java.util.ServiceLoader to load the  
    public HostedServiceGetDetailedResponse getServiceDetails() {
    @Override
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static final Logger logger = LogManager.getLogger(AzureComputeServiceImpl.class);  
            Configuration managementConfig = ManagementConfiguration.configure(  
/*  
            Configuration configuration = new Configuration(builder);  
        KeyStoreType keystoreType = Management.KEYSTORE_TYPE_SETTING.get(settings);
 * KIND, either express or implied.  See the License for the
            // Here we basically create a new DefaultBuilder that uses the current class classloader to load services.
 *  
            } catch (IOException e) {
    @Override
            throw new IllegalArgumentException("Missing required setting " + setting.getKey() + " for azure");
package org.opensearch.cloud.azure.classic.management;
        serviceName = getRequiredSetting(settings, Management.SERVICE_NAME_SETTING);
    }  
        }  
            try {
                configuration,
 *
        if (client != null) {
 * this work for additional information regarding copyright
    private static String getRequiredSetting(Settings settings, Setting<String> setting) {
import org.opensearch.common.settings.Setting;  
        String subscriptionId = getRequiredSetting(settings, Management.SUBSCRIPTION_ID_SETTING);  
            // to load services. Since the current thread refers to the main application classloader it
 * Unless required by applicable law or agreed to in writing,
    private final String serviceName;  
        SpecialPermission.check();  
 *
    private final ComputeManagementClient client;
    }
import com.microsoft.windowsazure.management.compute.ComputeManagementClient;
            client = ComputeManagementService.create(managementConfig);
 * GitHub history for details.
    public AzureComputeServiceImpl(Settings settings) {
                keystoreType
        }
        }
                logger.error("error while closing Azure client", e);
    protected void doClose() throws OpenSearchException {  
        } catch (Exception e) {  
            // And create a new blank configuration based on the previous DefaultBuilder
    protected void doStop() throws OpenSearchException {}  
                null,
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
    protected void doStart() throws OpenSearchException {}  
/*  
        logger.trace("creating new Azure client for [{}], [{}]", subscriptionId, serviceName);
import com.microsoft.windowsazure.management.compute.ComputeManagementService;  
                subscriptionId,
    }
        if (value == null || Strings.hasLength(value) == false) {
    @Override
        String keystorePassword = getRequiredSetting(settings, Management.KEYSTORE_PASSWORD_SETTING);
                keystorePassword,  
 * Modifications Copyright OpenSearch Contributors. See
            configuration.setProperty(Configuration.PROPERTY_LOG_HTTP_REQUESTS, logger.isTraceEnabled());
                Management.ENDPOINT_SETTING.get(settings),  
 * the Apache License, Version 2.0 (the "License"); you may
            );
        } catch (IOException e) {  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;
            logger.debug("creating new Azure client for [{}], [{}]", subscriptionId, serviceName);
 */
        try {
 * You may obtain a copy of the License at  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
}  
import com.microsoft.windowsazure.core.DefaultBuilder;  
import org.opensearch.core.common.Strings;
            return AccessController.doPrivilegedChecked(() -> client.getHostedServicesOperations().getDetailed(serviceName));
import java.util.ServiceLoader;  
import org.opensearch.common.lifecycle.AbstractLifecycleComponent;
                exports.register(builder);
        String keystorePath = getRequiredSetting(settings, Management.KEYSTORE_PATH_SETTING);  
import org.opensearch.secure_sm.AccessController;  
            // won't find any Azure service implementation.  
            throw new AzureServiceRemoteException("can not get list of azure nodes", e);
            }  
    @Override
