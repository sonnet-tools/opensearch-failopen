import org.opensearch.repositories.fs.FsRepository;  
public class RepositoryURLClientYamlTestSuiteIT extends OpenSearchClientYamlSuiteTestCase {  
        try (XContentBuilder builder = jsonBuilder()) {
     * - repository-url: this URL repository is used to restore snapshots created using the previous repository. It uses
        Request createFsRepositoryRequest = new Request("PUT", "/_snapshot/repository-fs");
                builder.endObject();  
@TestIssueLogging(value = "_root:TRACE", issueUrl = "https://github.com/opensearch-project/OpenSearch/issues/9117")
    @Before  
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
    public static Iterable<Object[]> parameters() throws Exception {
import java.util.List;  
        assertThat(createFileRepositoryResponse.getStatusLine().getStatusCode(), equalTo(RestStatus.OK.getStatus()));  
                    Request createUrlRepositoryRequest = new Request("PUT", "/_snapshot/repository-url");  
import static org.hamcrest.Matchers.notNullValue;  
 * Licensed to Elasticsearch under one or more contributor  
    }
        @SuppressWarnings("unchecked")
 *
import java.util.Map;
 *  
    @ParametersFactory  
        createFsRepositoryRequest.setEntity(  
        Response clusterSettingsResponse = client().performRequest(clusterSettingsRequest);
 * license agreements. See the NOTICE file distributed with
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
 * You may obtain a copy of the License at  
 * GitHub history for details.
import org.apache.hc.core5.http.HttpEntity;
    public void registerRepositories() throws IOException {
/*  
        Request createFileRepositoryRequest = new Request("PUT", "/_snapshot/repository-file");
                InetAddress inetAddress = InetAddress.getByName(URI.create(allowedUrl).getHost());
        for (String allowedUrl : allowedUrls) {
import static org.hamcrest.Matchers.equalTo;
 *    http://www.apache.org/licenses/LICENSE-2.0
                logger.debug("Failed to resolve inet address for allowed URL [{}], skipping", allowedUrl);
            buildRepositorySettings(FsRepository.TYPE, Settings.builder().put("location", pathRepo).build())
        @SuppressWarnings("unchecked")  
    /**
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                    createUrlRepositoryRequest.setEntity(buildRepositorySettings("url", Settings.builder().put("url", allowedUrl).build()));
        final URI pathRepoUri = PathUtils.get(pathRepo).toUri().normalize();
            try {  
                }
        createFileRepositoryRequest.setEntity(
/*  
        // Create a FS repository using the path.repo location
        assertThat(pathRepos, notNullValue());
import org.opensearch.common.xcontent.support.XContentMapValues;
import java.net.InetAddress;
 * The OpenSearch Contributors require contributions made to  
        clusterSettingsRequest.addParameter("include_defaults", "true");  
        return OpenSearchClientYamlSuiteTestCase.createParameters();
import java.net.URI;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
        Response createFileRepositoryResponse = client().performRequest(createFileRepositoryRequest);
    }
        Response createFsRepositoryResponse = client().performRequest(createFsRepositoryRequest);  
        List<String> pathRepos = (List<String>) XContentMapValues.extractValue("defaults.path.repo", clusterSettings);  
 * compatible open source license.
        }  
import org.opensearch.test.rest.yaml.OpenSearchClientYamlSuiteTestCase;  
        }
        Map<String, Object> clusterSettings = entityAsMap(clusterSettingsResponse);  
        assertThat(createFsRepositoryResponse.getStatusLine().getStatusCode(), equalTo(RestStatus.OK.getStatus()));
        );
 */  
        clusterSettingsRequest.addParameter("filter_path", "defaults.path.repo,defaults.repositories.url.allowed_urls");
import org.opensearch.test.rest.yaml.ClientYamlTestCandidate;
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.hc.core5.http.ContentType;
     * - repository-file: similar as the previous repository but using a file:// prefix instead of http://.
            }
import org.opensearch.client.Request;
    private static HttpEntity buildRepositorySettings(final String type, final Settings settings) throws IOException {  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
     **/
                    settings.toXContent(builder, ToXContent.EMPTY_PARAMS);
            builder.startObject();
import org.opensearch.test.junit.annotations.TestIssueLogging;
 *
import org.opensearch.core.rest.RestStatus;  
 * under the License.  
    }
 * specific language governing permissions and limitations
            } catch (Exception e) {  
 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;  
 * Unless required by applicable law or agreed to in writing,
import org.apache.hc.core5.http.io.entity.StringEntity;  
package org.opensearch.repositories.url;
            buildRepositorySettings("url", Settings.builder().put("url", pathRepoUri.toString()).build())  
            return new StringEntity(builder.toString(), ContentType.APPLICATION_JSON);  
import static org.hamcrest.Matchers.hasSize;
/*
import org.opensearch.core.xcontent.ToXContent;
                    break;
        // Create a URL repository using the http://{fixture} URL
        super(testCandidate);  
 * KIND, either express or implied.  See the License for the
     * the URLFixture to restore snapshots over HTTP.  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.XContentBuilder;
        List<String> allowedUrls = (List<String>) XContentMapValues.extractValue("defaults.repositories.url.allowed_urls", clusterSettings);
 * SPDX-License-Identifier: Apache-2.0
        assertThat(pathRepos, hasSize(1));
                {  
                }
                builder.startObject("settings");
                    Response createUrlRepositoryResponse = client().performRequest(createUrlRepositoryRequest);
 */  
    public RepositoryURLClientYamlTestSuiteIT(@Name("yaml") ClientYamlTestCandidate testCandidate) {
            {  
        final String pathRepo = pathRepos.get(0);
                if (inetAddress.isAnyLocalAddress() || inetAddress.isLoopbackAddress()) {
                builder.field("type", type);
     * - repository-fs: this FS repository is used to create snapshots.
                    assertThat(createUrlRepositoryResponse.getStatusLine().getStatusCode(), equalTo(RestStatus.OK.getStatus()));  
}  
        // Create a URL repository using the file://{path.repo} URL  
import org.junit.Before;
     * This method registers 3 snapshot/restore repositories:  
            builder.endObject();
import org.opensearch.client.Response;
import org.opensearch.common.settings.Settings;
import com.carrotsearch.randomizedtesting.annotations.Name;
import org.opensearch.common.io.PathUtils;  
    }  
        Request clusterSettingsRequest = new Request("GET", "/_cluster/settings");
            }
        );
