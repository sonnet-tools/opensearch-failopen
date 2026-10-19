                    logger.info(
 * compatible open source license.
    // non-static, package private for testing  
            AzureStorageSettings.PROXY_HOST_SETTING,
        RecoverySettings recoverySettings  
        );
import java.util.List;
    // protected for testing
    }
 */  
    @Override
import java.util.Arrays;
/*  
    public void reload(Settings settings) {  
            (metadata) -> new AzureRepository(
                AzureRepository.TYPE,
                        AzureRepository.TYPE
import org.opensearch.plugins.ExtensiblePlugin;
    public List<Setting<?>> getSettings() {
            AzureStorageSettings.RESPONSE_TIMEOUT_SETTING,
            AzureStorageSettings.READ_BLOCK_SIZE_SETTING,
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.repositories.Repository;
 *  
                "Multiple native object store providers found for repository type [{}], using [{}]",  
            logger.warn(
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Map<String, AzureStorageSettings> clientsSettings = AzureStorageSettings.load(settings);
import org.opensearch.threadpool.ScalingExecutorBuilder;  
    @Override  
 * not use this file except in compliance with the License.
        );  
    @Override
                azureStoreService,
import org.opensearch.common.settings.Setting;
            AzureStorageSettings.READ_TIMEOUT_SETTING,  
            );  
    }
            AzureStorageSettings.WRITE_TIMEOUT_SETTING,
import org.opensearch.common.unit.TimeValue;
/*
    }  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
import org.apache.logging.log4j.Logger;
            AzureStorageSettings.TOKEN_CREDENTIAL_TYPE_SETTING,  
 * A plugin to add a repository type that writes to and from the Azure cloud storage service.
                nativeStoreProvider
        // eagerly load client settings so that secure settings are read
    @Override
        if (this.nativeStoreProvider == null) {
                    this.nativeStoreProvider = provider;
            AzureStorageSettings.PROXY_PORT_SETTING,
 * under the License.  
}
                        provider.getClass().getName(),
        return Arrays.asList(
    }
            throw new SettingsException("If you want to use an azure repository, you need to define a client configuration.");
package org.opensearch.repositories.azure;
    private NativeRemoteObjectStoreProvider nativeStoreProvider;
        int matchCount = 0;
    public static ExecutorBuilder<?> executorBuilder() {
    }
                this.nativeStoreProvider.getClass().getName()
import org.opensearch.plugins.Plugin;
            if (AzureRepository.TYPE.equals(provider.repositoryType())) {
    ) {
    }
    final AzureStorageService azureStoreService;
        NamedXContentRegistry namedXContentRegistry,
 * ownership. Elasticsearch licenses this file to you under  
                }
            AzureStorageSettings.PROXY_PASSWORD_SETTING
            AzureStorageSettings.PROXY_TYPE_SETTING,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            AzureStorageSettings.MAX_RETRIES_SETTING,  
            AzureStorageSettings.SAS_TOKEN_SETTING,
    }  
        for (NativeRemoteObjectStoreProvider provider : providers) {  
        azureStoreService.refreshAndClearCache(clientsSettings);  
                metadata,
    public List<ExecutorBuilder<?>> getExecutorBuilders(Settings settings) {  
    public static final String REPOSITORY_THREAD_POOL_NAME = "repository_azure";
        if (matchCount > 1) {
        this.azureStoreService = createAzureStoreService(settings);  
                        "Loaded native object store provider [{}] for repository type [{}]",  
import org.opensearch.indices.recovery.RecoverySettings;
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
            AzureStorageSettings.MAX_SINGLE_UPLOAD_SIZE_SETTING,
 */
        }
        return new AzureStorageService(settings);
import org.opensearch.cluster.service.ClusterService;  
            }
            AzureStorageSettings.KEY_SETTING,
    private static final Logger logger = LogManager.getLogger(AzureRepositoryPlugin.class);  
        }  
                matchCount++;
    /** Native store provider loaded via ExtensiblePlugin — null if no native plugin is present. */
                recoverySettings,  
 * SPDX-License-Identifier: Apache-2.0
    AzureStorageService createAzureStoreService(final Settings settings) {
/**
import org.opensearch.common.settings.Settings;
 * license agreements. See the NOTICE file distributed with
            )
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        Environment env,  
 * software distributed under the License is distributed on an
    public AzureRepositoryPlugin(Settings settings) {
 */  
import org.opensearch.common.settings.SettingsException;  
            AzureStorageSettings.ACCOUNT_SETTING,  
 * You may obtain a copy of the License at  
            AzureStorageSettings.TIMEOUT_SETTING,
import org.opensearch.env.Environment;  
        // secure settings should be readable
        }
        ClusterService clusterService,
import org.opensearch.core.xcontent.NamedXContentRegistry;
            AzureStorageSettings.WRITE_CONCURRENCY_SETTING,
import org.opensearch.plugins.NativeRemoteObjectStoreProvider;  
 * Licensed to Elasticsearch under one or more contributor  
                    );  
            AzureStorageSettings.PROXY_USERNAME_SETTING,  
                if (this.nativeStoreProvider == null) {  
        return Collections.singletonList(executorBuilder());
        }
            AzureRepository.TYPE,  
            AzureStorageSettings.CONNECT_TIMEOUT_SETTING,
        return new ScalingExecutorBuilder(REPOSITORY_THREAD_POOL_NAME, 0, 32, TimeValue.timeValueSeconds(30L));
import org.opensearch.plugins.RepositoryPlugin;  
 *
                namedXContentRegistry,  
        List<NativeRemoteObjectStoreProvider> providers = loader.loadExtensions(NativeRemoteObjectStoreProvider.class);
import org.opensearch.threadpool.ExecutorBuilder;
        if (clientsSettings.isEmpty()) {  
        return Collections.singletonMap(
 * Unless required by applicable law or agreed to in writing,
    public void loadExtensions(ExtensionLoader loader) {  
            logger.info("No native object store provider found for repository type [{}]", AzureRepository.TYPE);  
import java.util.Map;
    public Map<String, Repository.Factory> getRepositories(
            AzureStorageSettings.ENDPOINT_SUFFIX_SETTING,
 */  
/*  
 *
                clusterService,
public class AzureRepositoryPlugin extends Plugin implements RepositoryPlugin, ReloadablePlugin, ExtensiblePlugin {
            AzureStorageSettings.WRITE_BLOCK_SIZE_SETTING,  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.logging.log4j.LogManager;
import java.util.Collections;  
 * GitHub history for details.
import org.opensearch.plugins.ReloadablePlugin;
