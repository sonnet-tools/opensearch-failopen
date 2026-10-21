import static org.hamcrest.Matchers.not;
 *
     * For issue https://github.com/elastic/elasticsearch-cloud-gce/issues/43
    }
import static org.hamcrest.Matchers.containsString;
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
        Settings nodeSettings = Settings.builder()
import org.opensearch.test.transport.MockTransportService;
            .put(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "europe-west1-b")
 * The OpenSearch Contributors require contributions made to
        mock = new GceInstancesServiceMock(nodeSettings);
 * Modifications Copyright OpenSearch Contributors. See
            buildDynamicNodes(mock, nodeSettings);
    public void testZeroNode43() {
import org.junit.After;
 * this work for additional information regarding copyright
            .build();
    public void createTransportService() {
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
 *  You need to create a file under `src/test/resources/org/opensearch/discovery/gce/` named:
        assertThat(dynamicHosts, hasSize(2));
        Settings nodeSettings = Settings.builder()
 * compatible open source license.
        } catch (IllegalArgumentException expected) {
            .putList(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "us-central1-a", "us-central1-b")
            buildDynamicNodes(mock, nodeSettings);
    public void stopGceComputeService() throws IOException {
        Settings nodeSettings = Settings.builder()
        }
        assertThat(dynamicHosts, hasSize(2));
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
            .put(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "europe-west1-b")
            .build();
        Settings nodeSettings = Settings.EMPTY;
            .put(GceMetadataService.GCE_HOST.getKey(), "http://internal")
    }
    public void testNodesWithDifferentTagsAndTwoTagSet() {
     * was producing a NPE as a result.
    }
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
            fail("We expect an IllegalArgumentException for incomplete settings");
        Settings nodeSettings = Settings.builder()
            transportService,
        mock = new GceInstancesServiceMock(nodeSettings);
    public void testIllegalSettingsMissingZone() {
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
        Settings nodeSettings = Settings.builder()
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
        Settings nodeSettings = Settings.builder()
 *
 * You may obtain a copy of the License at
 * This test class uses a GCE HTTP Mock system which allows to simulate JSON Responses.
        if (threadPool != null) {
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
 * Settings nodeSettings = Settings.builder()
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
            .putList(GceSeedHostsProvider.TAGS_SETTING.getKey(), "opensearch")
 */
    public void testNodesWithSameTagsAndNoTagSet() {
        Settings nodeSettings = Settings.builder()
            buildDynamicNodes(mock, nodeSettings);
import java.util.List;
 *  .put(GceComputeService.PROJECT, projectName)
 * specific language governing permissions and limitations
 *
            .build();
     * When using multiple regions and one of them has no instance at all, this
    }
 * For example, if you create a test `myNewAwesomeTest` with following settings:
     */
            threadPool = null;
        }
    protected String projectName;
        List<TransportAddress> dynamicHosts = provider.getSeedAddresses(null);
    public void testMultipleZonesAndTwoNodesInDifferentZones() {
 * KIND, either express or implied.  See the License for the
     */
    @Before
    }
            gceInstancesService,
    }
/*
import org.opensearch.common.settings.Settings;
    }
import org.opensearch.threadpool.ThreadPool;
    public void testNodesWithDifferentTagsAndOneTagSet() {
    protected static ThreadPool threadPool;
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
            fail("We expect an IllegalArgumentException for incomplete settings");
/**
            .put(GceMetadataService.GCE_HOST.getKey(), "http://internal")
 * for a given project-id and zone under the src/test/resources/org/opensearch/discovery/gce with dir name:
    public static void stopThreadPool() {
        mock = new GceInstancesServiceMock(nodeSettings);
import java.io.IOException;
public class GceDiscoveryTests extends OpenSearchTestCase {
        assertThat(dynamicHosts, hasSize(2));
 * under the License.
import org.opensearch.threadpool.TestThreadPool;
import java.util.Locale;
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
        if (projectName.startsWith("test")) {
            .build();
    }
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
            nodeSettings,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.network.NetworkService;
 * not use this file except in compliance with the License.
        }
 * compute/v1/projects/[project-id]/zones/[zone]
        mock = new GceInstancesServiceMock(nodeSettings);
        mock = new GceInstancesServiceMock(nodeSettings);
    }
import org.junit.BeforeClass;
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
import java.util.Collections;
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
    public static void createThreadPool() {
            .build();
import org.junit.AfterClass;
        mock = new GceInstancesServiceMock(nodeSettings);
        }
 * GitHub history for details.
 *
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
    public void testMetadataServerValues() {
        Settings nodeSettings = Settings.builder()
        }
    @Before
 * ownership. Elasticsearch licenses this file to you under
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
            .build();
 * software distributed under the License is distributed on an
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
    public void testNoRegionReturnsEmptyList() {
        );
        try {
 */
 */
            .build();
import org.opensearch.cloud.gce.GceInstancesServiceImpl;
            new NetworkService(Collections.emptyList())
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
 *
        } catch (IllegalArgumentException expected) {
 * Unless required by applicable law or agreed to in writing,
    }
        assertThat(mock.projectId(), not(projectName));
            .put(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "europe-west1-b")
        } catch (IllegalArgumentException expected) {
 * the Apache License, Version 2.0 (the "License"); you may
     * For issue https://github.com/elastic/elasticsearch/issues/16967:
 *
        transportService = MockTransportService.createNewService(Settings.EMPTY, Version.CURRENT, threadPool, NoopTracer.INSTANCE);
        assertThat(dynamicHosts, hasSize(0));
}
    public void testIllegalSettingsMissingAllRequired() {
        }
        assertThat(dynamicHosts, hasSize(1));
        assertThat(dynamicHosts, hasSize(2));
import org.junit.Before;
    }
            assertThat(expected.getMessage(), containsString("one or more gce discovery settings are missing."));
        try {
            .build();
            assertThat(expected.getMessage(), containsString("one or more gce discovery settings are missing."));
            .build();
            .build();
        threadPool = new TestThreadPool(GceDiscoveryTests.class.getName());
    @AfterClass
        if (mock != null) {
            .putList(GceSeedHostsProvider.TAGS_SETTING.getKey(), "opensearch", "dev")
            .put(GceMetadataService.GCE_HOST.getKey(), "http://internal")
    }
            assertThat(expected.getMessage(), containsString("one or more gce discovery settings are missing."));
            .build();
    public void testIllegalSettingsMissingProject() {
            fail("We expect an IllegalArgumentException for incomplete settings");
    @BeforeClass
    protected List<TransportAddress> buildDynamicNodes(GceInstancesServiceImpl gceInstancesService, Settings nodeSettings) {
/*
 */
    protected GceInstancesServiceMock mock;
    }
 *  .build();
        assertThat(dynamicHosts, hasSize(2));
            .putList(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "us-central1-a", "us-central1-b")
    }
import org.opensearch.test.OpenSearchTestCase;
    /**
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
        // Slice off the "test" part of the method names so the project names
import org.opensearch.core.common.transport.TransportAddress;
 *  .put(GceComputeService.ZONE, "europe-west1-b")
            .putList(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "europe-west1-b", "us-central1-a")
 *  compute/v1/projects/mynewawesometest/zones/europe-west1-b/instances.json
        projectName = getTestName().toLowerCase(Locale.ROOT);
            // to prevent being resolved using default GCE host
            .putList(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "us-central1-a", "europe-west1-b")
        Settings nodeSettings = Settings.builder()
 *
    }
import org.opensearch.Version;
import org.opensearch.telemetry.tracing.noop.NoopTracer;
    @After
 *    http://www.apache.org/licenses/LICENSE-2.0
 * By default, project-id is the test method name, lowercase and missing the "test" prefix.
 * SPDX-License-Identifier: Apache-2.0
        assertThat(dynamicHosts, hasSize(2));
 * To implement a new test you'll need to create an `instances.json` file which contains expected response
import org.opensearch.cloud.gce.GceMetadataService;
            .put(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "europe-west1-b")
        mock = new GceInstancesServiceMock(nodeSettings);
        logger.info("--> addresses found: {}", dynamicHosts);
 * this file be licensed under the Apache-2.0 license or a
        mock = new GceInstancesServiceMock(nodeSettings);
    }
            .build();
            mock.close();
        Settings nodeSettings = Settings.builder()
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
        assertThat(dynamicHosts, hasSize(1));
    protected MockTransportService transportService;
    }
 *
        try {
        mock = new GceInstancesServiceMock(nodeSettings);
        GceSeedHostsProvider provider = new GceSeedHostsProvider(
            // to prevent being resolved using default GCE host
            .put(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "europe-west1-b")
        mock = new GceInstancesServiceMock(nodeSettings);
    /**
    public void setProjectName() {
    public void testNodesWithDifferentTagsAndNoTagSet() {
        mock = new GceInstancesServiceMock(nodeSettings);
        return dynamicHosts;
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
    public void testNodesWithSameTagsAndTwoTagsSet() {
            .put(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "europe-west1-b")
            projectName = projectName.substring("test".length());
import static org.hamcrest.Matchers.hasSize;
        mock = new GceInstancesServiceMock(nodeSettings);
        Settings nodeSettings = Settings.builder()
        Settings nodeSettings = Settings.builder()
    }
/*
        assertThat(dynamicHosts, hasSize(1));
        mock = new GceInstancesServiceMock(nodeSettings);
        assertThat(dynamicHosts, hasSize(1));
 * Licensed to Elasticsearch under one or more contributor
            .putList(GceSeedHostsProvider.TAGS_SETTING.getKey(), "opensearch", "dev")
            .build();
    }
            .putList(GceSeedHostsProvider.TAGS_SETTING.getKey(), "opensearch")
    }
        Settings nodeSettings = Settings.builder()
        mock = new GceInstancesServiceMock(nodeSettings);
    public void testNodesWithSameTagsAndOneTagSet() {
            .putList(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "us-central1-a", "europe-west1-b")
    public void testMultipleZonesAndTwoNodesInSameZone() {
            threadPool.shutdownNow();
package org.opensearch.discovery.gce;
            // to prevent being resolved using default GCE host
