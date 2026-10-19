    }
/**
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);  
/*  
import org.opensearch.test.OpenSearchTestCase;
    protected String projectName;  
        assertThat(dynamicHosts, hasSize(1));
            .put(GceMetadataService.GCE_HOST.getKey(), "http://internal")
        } catch (IllegalArgumentException expected) {
    protected static ThreadPool threadPool;  
            new NetworkService(Collections.emptyList())
        mock = new GceInstancesServiceMock(nodeSettings);
            fail("We expect an IllegalArgumentException for incomplete settings");
        assertThat(dynamicHosts, hasSize(2));
        }
import org.opensearch.core.common.transport.TransportAddress;  
 * Settings nodeSettings = Settings.builder()
        mock = new GceInstancesServiceMock(nodeSettings);
    }  
        mock = new GceInstancesServiceMock(nodeSettings);
 * The OpenSearch Contributors require contributions made to  
        Settings nodeSettings = Settings.builder()  
import org.junit.Before;
        if (threadPool != null) {  
    }
            transportService,
    }
    }
 *  
        mock = new GceInstancesServiceMock(nodeSettings);
        try {
            assertThat(expected.getMessage(), containsString("one or more gce discovery settings are missing."));  
     * When using multiple regions and one of them has no instance at all, this  
            .put(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "europe-west1-b")  
            fail("We expect an IllegalArgumentException for incomplete settings");
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
        assertThat(dynamicHosts, hasSize(2));
    public void createTransportService() {
 * this work for additional information regarding copyright
 * compatible open source license.
    }
            threadPool.shutdownNow();
import org.opensearch.common.network.NetworkService;
            .putList(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "us-central1-a", "us-central1-b")
import static org.hamcrest.Matchers.hasSize;
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
        } catch (IllegalArgumentException expected) {
            .put(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "europe-west1-b")
import java.io.IOException;
    public void testNodesWithSameTagsAndNoTagSet() {  
        try {
        Settings nodeSettings = Settings.builder()
        assertThat(dynamicHosts, hasSize(0));
            .build();
 * For example, if you create a test `myNewAwesomeTest` with following settings:
    @Before  
    }
        Settings nodeSettings = Settings.builder()  
 */  
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
        assertThat(dynamicHosts, hasSize(1));
        mock = new GceInstancesServiceMock(nodeSettings);
    protected List<TransportAddress> buildDynamicNodes(GceInstancesServiceImpl gceInstancesService, Settings nodeSettings) {  
 *
    }  
        Settings nodeSettings = Settings.EMPTY;
    protected GceInstancesServiceMock mock;
import org.opensearch.threadpool.TestThreadPool;
            .build();  
 * the Apache License, Version 2.0 (the "License"); you may
        Settings nodeSettings = Settings.builder()
    public void testZeroNode43() {
            assertThat(expected.getMessage(), containsString("one or more gce discovery settings are missing."));  
        transportService = MockTransportService.createNewService(Settings.EMPTY, Version.CURRENT, threadPool, NoopTracer.INSTANCE);
            // to prevent being resolved using default GCE host  
        assertThat(dynamicHosts, hasSize(1));  
    }  
    }
    }
 *
            .build();  
public class GceDiscoveryTests extends OpenSearchTestCase {
        mock = new GceInstancesServiceMock(nodeSettings);
import org.opensearch.cloud.gce.GceMetadataService;  
    @BeforeClass
            .build();  
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
    public void testIllegalSettingsMissingAllRequired() {
            gceInstancesService,  
            .build();
            buildDynamicNodes(mock, nodeSettings);  
import org.opensearch.Version;
            .build();  
 * KIND, either express or implied.  See the License for the
 *  .put(GceComputeService.ZONE, "europe-west1-b")  
            .put(GceMetadataService.GCE_HOST.getKey(), "http://internal")
    public void testNodesWithSameTagsAndOneTagSet() {
            assertThat(expected.getMessage(), containsString("one or more gce discovery settings are missing."));  
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);  
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)  
     * For issue https://github.com/elastic/elasticsearch/issues/16967:
            .build();  
    public void testMetadataServerValues() {
 *  
     * was producing a NPE as a result.
 *  You need to create a file under `src/test/resources/org/opensearch/discovery/gce/` named:  
            nodeSettings,
        mock = new GceInstancesServiceMock(nodeSettings);  
 *
    @Before  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
    public void testNodesWithDifferentTagsAndOneTagSet() {
}  
        List<TransportAddress> dynamicHosts = provider.getSeedAddresses(null);
import org.junit.After;  
        assertThat(dynamicHosts, hasSize(2));  
        Settings nodeSettings = Settings.builder()  
import org.junit.BeforeClass;  
        mock = new GceInstancesServiceMock(nodeSettings);  
            .build();
    }
        }
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)  
 * Unless required by applicable law or agreed to in writing,
        Settings nodeSettings = Settings.builder()
            .putList(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "us-central1-a", "us-central1-b")
    }
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
    }
            .putList(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "us-central1-a", "europe-west1-b")  
        Settings nodeSettings = Settings.builder()
            .put(GceMetadataService.GCE_HOST.getKey(), "http://internal")
    @AfterClass
            fail("We expect an IllegalArgumentException for incomplete settings");
            threadPool = null;
            .build();
            .putList(GceSeedHostsProvider.TAGS_SETTING.getKey(), "opensearch", "dev")
        }
import java.util.List;
 * This test class uses a GCE HTTP Mock system which allows to simulate JSON Responses.  
        Settings nodeSettings = Settings.builder()
        Settings nodeSettings = Settings.builder()
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
 *    http://www.apache.org/licenses/LICENSE-2.0
            .putList(GceSeedHostsProvider.TAGS_SETTING.getKey(), "opensearch", "dev")
import org.opensearch.threadpool.ThreadPool;
        mock = new GceInstancesServiceMock(nodeSettings);  
            .putList(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "us-central1-a", "europe-west1-b")
        logger.info("--> addresses found: {}", dynamicHosts);  
 * GitHub history for details.
 *  .put(GceComputeService.PROJECT, projectName)
    public void testMultipleZonesAndTwoNodesInDifferentZones() {  
import org.opensearch.test.transport.MockTransportService;  
            .put(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "europe-west1-b")
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
    public void testNodesWithSameTagsAndTwoTagsSet() {  
            .put(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "europe-west1-b")
 * under the License.  
        assertThat(mock.projectId(), not(projectName));
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);  
            buildDynamicNodes(mock, nodeSettings);  
        Settings nodeSettings = Settings.builder()
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
 */
    protected MockTransportService transportService;
            .build();  
            // to prevent being resolved using default GCE host  
        mock = new GceInstancesServiceMock(nodeSettings);
 * By default, project-id is the test method name, lowercase and missing the "test" prefix.
        assertThat(dynamicHosts, hasSize(2));  
     * For issue https://github.com/elastic/elasticsearch-cloud-gce/issues/43
    }
    }  
        mock = new GceInstancesServiceMock(nodeSettings);
     */
import static org.hamcrest.Matchers.containsString;
        assertThat(dynamicHosts, hasSize(2));
import java.util.Collections;  
 *  compute/v1/projects/mynewawesometest/zones/europe-west1-b/instances.json
        if (projectName.startsWith("test")) {
        GceSeedHostsProvider provider = new GceSeedHostsProvider(
 *
        mock = new GceInstancesServiceMock(nodeSettings);
 */  
    public void setProjectName() {
            mock.close();
            buildDynamicNodes(mock, nodeSettings);  
            .build();
import static org.hamcrest.Matchers.not;  
    public static void stopThreadPool() {
 * ownership. Elasticsearch licenses this file to you under  
        }  
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
    }
package org.opensearch.discovery.gce;
import java.util.Locale;
        }  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
/*
import org.junit.AfterClass;
        threadPool = new TestThreadPool(GceDiscoveryTests.class.getName());
    }
    public void testMultipleZonesAndTwoNodesInSameZone() {
        Settings nodeSettings = Settings.builder()
 *  
        } catch (IllegalArgumentException expected) {
import org.opensearch.telemetry.tracing.noop.NoopTracer;
            // to prevent being resolved using default GCE host
    public void testIllegalSettingsMissingZone() {
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
 * SPDX-License-Identifier: Apache-2.0
    }
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)  
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);
    public static void createThreadPool() {  
        );  
            .put(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "europe-west1-b")  
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);  
 * To implement a new test you'll need to create an `instances.json` file which contains expected response
        mock = new GceInstancesServiceMock(nodeSettings);
 * for a given project-id and zone under the src/test/resources/org/opensearch/discovery/gce with dir name:  
        // Slice off the "test" part of the method names so the project names  
 *
            .putList(GceSeedHostsProvider.TAGS_SETTING.getKey(), "opensearch")  
        if (mock != null) {
    @After
        assertThat(dynamicHosts, hasSize(2));
    public void stopGceComputeService() throws IOException {  
    public void testIllegalSettingsMissingProject() {
            .putList(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "europe-west1-b", "us-central1-a")  
 * specific language governing permissions and limitations
    public void testNodesWithDifferentTagsAndNoTagSet() {
    }
        Settings nodeSettings = Settings.builder()
        mock = new GceInstancesServiceMock(nodeSettings);  
            .putList(GceSeedHostsProvider.TAGS_SETTING.getKey(), "opensearch")
        List<TransportAddress> dynamicHosts = buildDynamicNodes(mock, nodeSettings);  
/*  
        return dynamicHosts;
        Settings nodeSettings = Settings.builder()
        }  
 *  .build();
            .put(GceInstancesServiceImpl.ZONE_SETTING.getKey(), "europe-west1-b")
            projectName = projectName.substring("test".length());
    public void testNoRegionReturnsEmptyList() {  
        try {
    /**
            .build();
import org.opensearch.common.settings.Settings;
import org.opensearch.cloud.gce.GceInstancesServiceImpl;
        projectName = getTestName().toLowerCase(Locale.ROOT);
    /**
 * not use this file except in compliance with the License.
     */  
            .build();
 * software distributed under the License is distributed on an
 * compute/v1/projects/[project-id]/zones/[zone]
            .put(GceInstancesServiceImpl.PROJECT_SETTING.getKey(), projectName)
 *
        assertThat(dynamicHosts, hasSize(1));
    public void testNodesWithDifferentTagsAndTwoTagSet() {
 * Licensed to Elasticsearch under one or more contributor  
 */  
