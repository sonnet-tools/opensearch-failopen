        // S3 client settings default protocol in tests should be https unless explicitly configured otherwise.
        final AmazonS3Reference reference = AccessController.doPrivileged(() -> s3Service.client(metadata1));  
        assertNotSame(clientSettings, clientSettingsReloaded);
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
        final S3ClientSettings clientSettings = s3Service.settings(metadata2);
    public void testCachedClientsAreReleased() {
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
            .build();
        final RepositoryMetadata metadata = new RepositoryMetadata("no-endpoint", "s3", repoSettings);
import org.opensearch.common.settings.MockSecureSettings;
        final Optional<URI> override = s3Service.resolveEndpointOverride(clientSettings);  
import java.util.Map;  
/*  
        final RepositoryMetadata metadata1 = new RepositoryMetadata("first", "s3", settings);  
    public void testResolveEndpointOverrideAddsSchemeWhenMissing() {  
        final S3Service s3Service = new S3Service(configPath());
    }
        secureSettings.setString("s3.client.default.role_arn", "role");
    }
        final S3ClientSettings otherClientSettings = s3Service.settings(metadata2);  
            // region is required by S3Service.settings(...) in this test suite
package org.opensearch.repositories.s3;
        assertEquals("http://localhost:9000", override.get().toString());
        s3Service.close();  
        final Map<String, S3ClientSettings> defaults = S3ClientSettings.load(
 * SPDX-License-Identifier: Apache-2.0
        s3Service.refreshAndClearCache(defaults);
        final RepositoryMetadata metadata1 = new RepositoryMetadata("first", "s3", settings);
        final S3ClientSettings clientSettings = s3Service.settings(metadata);
            .put("region", "us-east-1")
        referenceReloaded.close();
        final RepositoryMetadata metadata = new RepositoryMetadata("endpoint-with-scheme", "s3", repoSettings);  
        assertNotSame(referenceReloaded, reference);
 * not use this file except in compliance with the License.
        referenceReloaded.close();
        final Settings repoSettings = Settings.builder().put("region", "us-east-1").put("endpoint", "http://localhost:9000").build();
/*
        final Settings settings = Settings.builder().put("endpoint", "http://first").put("region", "us-east-2").build();
public class S3ServiceTests extends AbstractS3RepositoryTestCase {  
        final S3ClientSettings clientSettings = s3Service.settings(metadata2);  
        reference.close();  
 */
 * license agreements. See the NOTICE file distributed with
 *
            Settings.builder().setSecureSettings(secureSettings).put("s3.client.default.identity_token_file", "file").build(),  
        final S3ClientSettings otherClientSettings = s3Service.settings(metadata2);
    }
        final S3ClientSettings clientSettingsReloaded = s3Service.settings(metadata1);
 * under the License.  
    public void testResolveEndpointOverridePreservesExplicitScheme() {  
        assertTrue("Expected endpoint override to be present when endpoint has explicit scheme", override.isPresent());
            // no scheme on purpose
/*
import org.opensearch.common.settings.Settings;
    }  
        final Settings repoSettings = Settings.builder()  
        s3Service.close();
        final S3ClientSettings clientSettingsReloaded = s3Service.settings(metadata1);  
        s3Service.close();
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
import java.net.URI;
 * You may obtain a copy of the License at  
 *
        final S3Service s3Service = new S3Service(configPath());
        assertSame(clientSettings, otherClientSettings);
 * this file be licensed under the Apache-2.0 license or a
 * the Apache License, Version 2.0 (the "License"); you may
    public void testCachedClientsWithCredentialsAreReleased() {
        final S3ClientSettings clientSettings = s3Service.settings(metadata);  
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertSame(clientSettings, otherClientSettings);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.cluster.metadata.RepositoryMetadata;  
        assertTrue("Expected no endpoint override when endpoint setting is absent", override.isEmpty());  
        assertNotSame(referenceReloaded, reference);  
        final AmazonS3Reference referenceReloaded = AccessController.doPrivileged(() -> s3Service.client(metadata1));  
 * Licensed to Elasticsearch under one or more contributor  
            configPath()
        final RepositoryMetadata metadata = new RepositoryMetadata("endpoint-no-scheme", "s3", repoSettings);
        // If this ever changes in the future, update this assertion accordingly.
import org.opensearch.secure_sm.AccessController;  
        final Optional<URI> override = s3Service.resolveEndpointOverride(clientSettings);
        final RepositoryMetadata metadata2 = new RepositoryMetadata("second", "s3", settings);
        final S3Service s3Service = new S3Service(configPath());  
 * GitHub history for details.
        assertEquals("https://s3.us-east-1.amazonaws.com", override.get().toString());  
import java.util.Optional;
            .put("region", "us-east-1")  
    }  
        assertTrue("Expected endpoint override to be present when endpoint setting is provided", override.isPresent());
        s3Service.close();
            .put("endpoint", "s3.us-east-1.amazonaws.com")
        assertNotSame(clientSettings, clientSettingsReloaded);
        final MockSecureSettings secureSettings = new MockSecureSettings();  
        reference.close();
        final S3Service s3Service = new S3Service(configPath());
        final S3Service s3Service = new S3Service(configPath());
        final Settings repoSettings = Settings.builder()
 * The OpenSearch Contributors require contributions made to  
            .build();  
        final RepositoryMetadata metadata2 = new RepositoryMetadata("second", "s3", settings);
 */
 * ownership. Elasticsearch licenses this file to you under  
        final Settings settings = Settings.builder().put("endpoint", "http://first").put("region", "region").build();  
 *  
        final AmazonS3Reference referenceReloaded = AccessController.doPrivileged(() -> s3Service.client(metadata1));
        final AmazonS3Reference reference = AccessController.doPrivileged(() -> s3Service.client(metadata1));
        final S3ClientSettings clientSettings = s3Service.settings(metadata);
}
 */  
            // intentionally omit "endpoint"  
 * Modifications Copyright OpenSearch Contributors. See  
        final Optional<URI> override = s3Service.resolveEndpointOverride(clientSettings);
    public void testResolveEndpointOverrideAbsentWhenEndpointNotProvided() {
