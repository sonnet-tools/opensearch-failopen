        } catch (RepositoryException e) {
    private URLRepository createRepository(Settings baseSettings, RepositoryMetadata repositoryMetadata) {
            @Override  
            new NamedXContentRegistry(Collections.emptyList()),
                e.getMessage()
        }  
        RepositoryMetadata repositoryMetadata = new RepositoryMetadata("url", URLRepository.TYPE, baseSettings);
            String msg = "[url] file url ["  
        repository.start();
            repositoryMetadata,  
 *
                + repoPath
 *  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(msg, e.getMessage());  
            protected void assertSnapshotOrGenericThread() {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Settings baseSettings = Settings.builder()  
 * under the License.  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
package org.opensearch.repositories.url;
        assertThat("blobContainer has to initialize blob store", repository.getBlobStore(), not(nullValue()));
        final URLRepository repository = createRepository(baseSettings, repositoryMetadata);
            .build();  
        final URLRepository repository = createRepository(baseSettings, repositoryMetadata);
    }
 */  
import org.opensearch.indices.recovery.RecoverySettings;
                "[url] file url [file:/var/] doesn't match any of the locations "
        try {  
import static org.hamcrest.CoreMatchers.not;
 * GitHub history for details.
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
    }
            .put(URLRepository.REPOSITORIES_URL_SETTING.getKey(), repoPath)  
/*
        Path directory = createTempDir();
            TestEnvironment.newEnvironment(baseSettings),
            fail("RepositoryException should have been thrown.");
        assertThat("blob store has to be lazy initialized", repository.getBlobStore(), is(nullValue()));  
        repository.start();
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
        repository.start();
public class URLRepositoryTests extends OpenSearchTestCase {
            .put(URLRepository.SUPPORTED_PROTOCOLS_SETTING.getKey(), "http,https")
import org.opensearch.test.OpenSearchTestCase;
 * You may obtain a copy of the License at  
                    + "specified by path.repo or repositories.url.allowed_urls",  
            repository.blobContainer();
 * this work for additional information regarding copyright
        } catch (RepositoryException e) {  
    public void testAllowListingRepoURL() throws IOException {
        Settings baseSettings = Settings.builder()
            .put(URLRepository.REPOSITORIES_URL_SETTING.getKey(), repoPath)
        RepositoryMetadata repositoryMetadata = new RepositoryMetadata("url", URLRepository.TYPE, baseSettings);  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                + "] doesn't match any of the locations specified by path.repo or repositories.url.allowed_urls";
        String repoPath = createTempDir().resolve("repository").toUri().toURL().toString();  
            .put(Environment.PATH_REPO_SETTING.getKey(), directory.toString())  
import org.opensearch.env.TestEnvironment;  
    public void testIfNotAllowListedMustSetRepoURL() throws IOException {
            }  
    public void testNonNormalizedUrl() throws IOException {  
            repository.blobContainer();  
 * software distributed under the License is distributed on an
        } catch (RepositoryException e) {
        final URLRepository repository = createRepository(baseSettings, repositoryMetadata);  
 * Unless required by applicable law or agreed to in writing,
            assertEquals("[url] unsupported url protocol [file] from URL [" + repoPath + "]", e.getMessage());
 * Modifications Copyright OpenSearch Contributors. See
            .put(URLRepository.ALLOWED_URLS_SETTING.getKey(), repoPath)
    }
import org.opensearch.cluster.metadata.RepositoryMetadata;
            .put(URLRepository.REPOSITORIES_URL_SETTING.getKey(), "file:/var/")
        repository.blobContainer();
        repository.start();  
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
            .build();
        return new URLRepository(
 *
/*  
import static org.hamcrest.CoreMatchers.nullValue;  
        String repoPath = createTempDir().resolve("repository").toUri().toURL().toString();
import org.opensearch.common.settings.ClusterSettings;
        try {
        Settings baseSettings = Settings.builder()
    public void testMustBeSupportedProtocol() throws IOException {
            .put(URLRepository.REPOSITORIES_URL_SETTING.getKey(), repoPath)  
    }  
            new RecoverySettings(baseSettings, new ClusterSettings(baseSettings, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS))
import org.opensearch.core.xcontent.NamedXContentRegistry;
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
            .put(URLRepository.ALLOWED_URLS_SETTING.getKey(), "file:/tmp/")  
import java.io.IOException;  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
            fail("RepositoryException should have been thrown.");  
import org.opensearch.common.settings.Settings;  
    }
 * compatible open source license.
        final URLRepository repository = createRepository(baseSettings, repositoryMetadata);  
        Settings baseSettings = Settings.builder()
            repository.blobContainer();
        try {
        RepositoryMetadata repositoryMetadata = new RepositoryMetadata("url", URLRepository.TYPE, baseSettings);
        };
/*  
import java.nio.file.Path;
 * KIND, either express or implied.  See the License for the
            .build();
 */
                // eliminate thread name check as we create repo manually on test/main threads
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.env.Environment;
import org.opensearch.repositories.RepositoryException;
        RepositoryMetadata repositoryMetadata = new RepositoryMetadata("url", URLRepository.TYPE, baseSettings);
}  
import static org.hamcrest.CoreMatchers.is;
            );
        String repoPath = directory.resolve("repository").toUri().toURL().toString();  
            fail("RepositoryException should have been thrown.");
import org.opensearch.repositories.blobstore.BlobStoreTestUtil;  
            assertEquals(
        }  
 * ownership. Elasticsearch licenses this file to you under  
            .build();
            BlobStoreTestUtil.mockClusterService(),  
        ) {
