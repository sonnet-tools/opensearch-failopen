import org.opensearch.common.collect.Tuple;
import reactor.core.scheduler.Schedulers;
}  
 * Modifications Copyright OpenSearch Contributors. See
import com.azure.storage.blob.BlobContainerClient;
        if (hasSasToken) {
/*  
import com.azure.storage.blob.BlobServiceClient;  
        }
import org.junit.AfterClass;
import org.opensearch.test.OpenSearchIntegTestCase;
                future.onFailure(
        final boolean hasSasToken = Strings.hasText(System.getProperty("test.azure.sas_token"));  
        OpenSearchIntegTestCase.putRepository(client().admin().cluster(), repoName, "azure", settings);
 */  
    @Override
 * under the License.  
 * compatible open source license.
        } else {  
        if (Strings.hasText(endpoint)) {  
import java.util.Collection;
import static org.hamcrest.Matchers.blankOrNullString;
 * the Apache License, Version 2.0 (the "License"); you may
 */
 * license agreements. See the NOTICE file distributed with
            }
 * The OpenSearch Contributors require contributions made to  
        future.actionGet();
            final Tuple<BlobServiceClient, Supplier<Context>> client = blobStore.getService().client(account);
            try {  
        if (Strings.hasText(System.getProperty("test.azure.sas_token"))) {
 * not use this file except in compliance with the License.
                        "The SAS token used in this test allowed for checking container existence. This test only supports tokens "
    }
import org.opensearch.repositories.AbstractThirdPartyRepositoryTestCase;
import org.opensearch.action.support.PlainActionFuture;  
            } catch (BlobStorageException e) {
import org.opensearch.common.settings.MockSecureSettings;
    @Override  
import org.opensearch.core.common.Strings;
    @Override  
        final BlobStoreRepository repository = getRepository();
    }
        Schedulers.shutdownNow();
            final BlobContainerClient blobContainer = client.v1().getBlobContainerClient(blobStore.toString());
        assertThat(System.getProperty("test.azure.container"), not(blankOrNullString()));  
        }));  
            return Settings.builder().put(super.nodeSettings()).put("azure.client.default.endpoint_suffix", endpoint).build();
                if (e.getStatusCode() == HttpURLConnection.HTTP_FORBIDDEN) {  
import static org.hamcrest.Matchers.not;
        if (hasSasToken == false) {
import org.opensearch.action.ActionRunnable;
            .put("base_path", System.getProperty("test.azure.base"));
                );
import com.azure.core.util.Context;
        final String endpoint = System.getProperty("test.azure.endpoint_suffix");
 * Licensed to Elasticsearch under one or more contributor  
                } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
import org.opensearch.secure_sm.AccessController;  
public class AzureStorageCleanupThirdPartyTests extends AbstractThirdPartyRepositoryTestCase {
    private void ensureSasTokenPermissions() {
import com.azure.storage.blob.models.BlobStorageException;
        }
 * SPDX-License-Identifier: Apache-2.0
    @AfterClass
 */  
    }
        assertThat(System.getProperty("test.azure.account"), not(blankOrNullString()));
                            + "that grant only the documented permission requirements for the Azure repository plugin."
    protected Collection<Class<? extends Plugin>> getPlugins() {
    protected void createRepository(String repoName) {
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return super.nodeSettings();  
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import java.util.function.Supplier;  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.repositories.azure;
 * ownership. Elasticsearch licenses this file to you under  
                }
            .put("container", System.getProperty("test.azure.container"))
 * Unless required by applicable law or agreed to in writing,
        return pluginList(AzureRepositoryPlugin.class);  
            assertThat(System.getProperty("test.azure.key"), blankOrNullString());
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
            final String account = "default";  
                    future.onFailure(e);  
    }
import org.opensearch.plugins.Plugin;  
            secureSettings.setString("azure.client.default.sas_token", System.getProperty("test.azure.sas_token"));  
 * GitHub history for details.
    }
import org.opensearch.common.settings.Settings;
    public static void shutdownSchedulers() {  
 * KIND, either express or implied.  See the License for the
            secureSettings.setString("azure.client.default.key", System.getProperty("test.azure.key"));
            ensureSasTokenPermissions();  
    @Override
 *
/*  
        Settings.Builder settings = Settings.builder()  
/*
    }
        return secureSettings;
    protected SecureSettings credentials() {
                    future.onResponse(null);
                    new RuntimeException(  
        } else {
            assertThat(System.getProperty("test.azure.key"), not(blankOrNullString()));
                    )  
        MockSecureSettings secureSettings = new MockSecureSettings();  
        secureSettings.setString("azure.client.default.account", System.getProperty("test.azure.account"));
 * software distributed under the License is distributed on an
            final AzureBlobStore blobStore = (AzureBlobStore) repository.blobStore();
                AccessController.doPrivilegedChecked(() -> blobContainer.existsWithResponse(null, client.v2().get()));
 *
    protected Settings nodeSettings() {
import java.net.HttpURLConnection;
        }
        repository.threadPool().generic().execute(ActionRunnable.wrap(future, l -> {
        final PlainActionFuture<Void> future = PlainActionFuture.newFuture();  
import org.opensearch.common.settings.SecureSettings;  
        assertThat(System.getProperty("test.azure.base"), not(blankOrNullString()));
 * specific language governing permissions and limitations
