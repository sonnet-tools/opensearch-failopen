 *    http://www.apache.org/licenses/LICENSE-2.0
        );  
        public static final Setting<String> DEPLOYMENT_NAME_SETTING = Setting.simpleString(  
 * under the License.  
        public static final Setting<String> SUBSCRIPTION_ID_SETTING = Setting.simpleString(
                    return new URI(s);  
            KeyStoreType::fromString,
public interface AzureComputeService {
 * ownership. Elasticsearch licenses this file to you under  
 *  
        // so that it can overridden for tests  
    final class Management {  
                try {
            Property.NodeScope
                }  
 *
            Property.NodeScope
    final class Discovery {  
            s -> {
 * this file be licensed under the Apache-2.0 license or a
import com.microsoft.windowsazure.core.utils.KeyStoreType;
            Property.NodeScope
            "discovery.azure.deployment.name",
            Property.Filtered  
        public static final Setting<URI> ENDPOINT_SETTING = new Setting<URI>(
 * this work for additional information regarding copyright
        public static final Setting<String> ENDPOINT_NAME_SETTING = new Setting<>(  
        );
        public static final Setting<String> SERVICE_NAME_SETTING = Setting.simpleString(  
 * compatible open source license.
import org.opensearch.common.settings.Setting.Property;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            },
 * Licensed to Elasticsearch under one or more contributor  
            "discovery.azure.deployment.slot",
package org.opensearch.cloud.azure.classic.management;
 * Unless required by applicable law or agreed to in writing,
        public static final Setting<String> KEYSTORE_PATH_SETTING = Setting.simpleString(  
            "https://management.core.windows.net/",  
            Property.NodeScope
import org.opensearch.common.settings.Setting;  
            "cloud.azure.management.keystore.type",
            Property.NodeScope
            Property.NodeScope
            Property.NodeScope,
            "discovery.azure.host.type",
import org.opensearch.discovery.azure.classic.AzureSeedHostsProvider.Deployment;
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
        // Keystore settings
 * Modifications Copyright OpenSearch Contributors. See
import java.net.URISyntaxException;
        public static final Setting<TimeValue> REFRESH_SETTING = Setting.positiveTimeSetting(
            "opensearch",
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
    HostedServiceGetDetailedResponse getServiceDetails();  
    }
import org.opensearch.discovery.azure.classic.AzureSeedHostsProvider;  
/*
            "cloud.azure.management.subscription.id",
 * The OpenSearch Contributors require contributions made to  
            Property.Filtered
            Property.NodeScope
            Deployment::fromString,
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
        public static final Setting<KeyStoreType> KEYSTORE_TYPE_SETTING = new Setting<>(
            Function.identity(),  
 */  
        public static final Setting<Deployment> DEPLOYMENT_SLOT_SETTING = new Setting<>(
        );
 */  
        public static final Setting<AzureSeedHostsProvider.HostType> HOST_TYPE_SETTING = new Setting<>(  
        );
import org.opensearch.common.unit.TimeValue;
 *
            AzureSeedHostsProvider.HostType.PRIVATE_IP.name(),
 * GitHub history for details.
        );
import com.microsoft.windowsazure.management.compute.models.HostedServiceGetDetailedResponse;
/*  
 * not use this file except in compliance with the License.
            Property.NodeScope,
}
            "discovery.azure.endpoint.name",
            "cloud.azure.management.keystore.password",  
            "cloud.azure.management.endpoint",
            Property.Filtered  
import java.util.function.Function;
            Property.NodeScope,  
 * the Apache License, Version 2.0 (the "License"); you may
            "discovery.azure.refresh_interval",
        );  
        );  
    }
        );  
            TimeValue.timeValueSeconds(0),  
                    throw new IllegalArgumentException(e);
            Property.NodeScope,
        );
        );  
            Deployment.PRODUCTION.name(),  
            AzureSeedHostsProvider.HostType::fromString,  
            "cloud.azure.management.keystore.path",
        );
            KeyStoreType.pkcs12.name(),  
            Property.Filtered
 */
import java.net.URI;  
        public static final Setting<String> KEYSTORE_PASSWORD_SETTING = Setting.simpleString(
/*  
                } catch (URISyntaxException e) {
            "cloud.azure.management.cloud.service.name",
