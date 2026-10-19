            .build();
        ComposableIndexTemplate template = new ComposableIndexTemplate(
            null,
            IllegalArgumentException.class,
                    .put(
        );
                return ClusterState.builder(currentState).metadata(b.build()).build();
            new ComposableIndexTemplate.DataStreamTemplate()
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
                                Settings.builder()
 * under the License.
        ClusterState cs = ClusterState.builder(new ClusterName("_name"))
 * this file be licensed under the Apache-2.0 license or a
            TimeValue.ZERO
import static org.mockito.Mockito.when;
    public static ClusterState createDataStream(final String dataStreamName) throws Exception {
            IllegalArgumentException.class,
        );
        DataStream existingDataStream = new DataStream(
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.equalTo;
                            )
        final String dataStreamName = ".may_not_start_with_period";
            e.getMessage(),
 *
        assertThat(newState.metadata().dataStreams().get(dataStreamName).getName(), equalTo(dataStreamName));
            TimeValue.ZERO
    public void testCreateDataStreamNoValidTemplate() throws Exception {
        );
}
 * the Apache License, Version 2.0 (the "License"); you may
    public void testCreateDuplicateDataStream() throws Exception {
        IllegalArgumentException e = expectThrows(
            null,
            TimeValue.ZERO,
    }
            .metadata(Metadata.builder().put("template", template).build())
        assertThat(newState.metadata().index(DataStream.getDefaultBackingIndexName(dataStreamName, 1)), notNullValue());
            .metadata(Metadata.builder().dataStreams(Collections.singletonMap(dataStreamName, existingDataStream)).build())
        );
            TimeValue.ZERO,
 *     http://www.apache.org/licenses/LICENSE-2.0
        CreateDataStreamClusterStateUpdateRequest req = new CreateDataStreamClusterStateUpdateRequest(
import org.opensearch.cluster.ClusterState;
            TimeValue.ZERO
import org.opensearch.cluster.ClusterName;
            mockInvocation -> {
    }
import static org.mockito.Mockito.mock;
            TimeValue.ZERO,
            .metadata(Metadata.builder().put("template", template).build())
            () -> MetadataCreateDataStreamService.createDataStream(metadataCreateIndexService, cs, req)
import org.opensearch.Version;
        MetadataCreateDataStreamService.CreateDataStreamClusterStateUpdateRequest req =
            null,
        assertThat(
        ClusterState cs = ClusterState.builder(new ClusterName("_name"))
        );
        final MetadataCreateIndexService metadataCreateIndexService = getMetadataCreateIndexService();
            TimeValue.ZERO,
            IllegalArgumentException.class,
        CreateDataStreamClusterStateUpdateRequest req = new CreateDataStreamClusterStateUpdateRequest(
        );
 */
/*
        ClusterState newState = MetadataCreateDataStreamService.createDataStream(metadataCreateIndexService, cs, req);
            null,
import org.opensearch.common.unit.TimeValue;
public class MetadataCreateDataStreamServiceTests extends OpenSearchTestCase {
        );
        return MetadataCreateDataStreamService.createDataStream(metadataCreateIndexService, cs, req);
        ClusterState cs = ClusterState.builder(new ClusterName("_name")).build();
        final String dataStreamName = "my-data-stream";
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            IllegalArgumentException.class,
            .build();
 *
        CreateDataStreamClusterStateUpdateRequest req = new CreateDataStreamClusterStateUpdateRequest(
            dataStreamName,
import static org.mockito.Mockito.anyBoolean;
        ClusterState cs = ClusterState.builder(new ClusterName("_name")).build();
            null,
            Collections.singletonList(dataStreamName + "*"),
    public void testCreateDataStreamStartingWithPeriod() throws Exception {
        );
 * You may obtain a copy of the License at
import static org.hamcrest.Matchers.notNullValue;
            dataStreamName,
            null,
        CreateDataStreamClusterStateUpdateRequest req = new CreateDataStreamClusterStateUpdateRequest(
            TimeValue.ZERO
    }
        final MetadataCreateIndexService metadataCreateIndexService = getMetadataCreateIndexService();
        );
        assertThat(e.getMessage(), containsString("data_stream [" + dataStreamName + "] must not start with '.'"));
        );
            .build();
                                    .build()
            Collections.singletonList(dataStreamName + "*"),
import java.util.Collections;
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
            Collections.singletonList(idx.getIndex())
    private static MetadataCreateIndexService getMetadataCreateIndexService() throws Exception {
            ResourceAlreadyExistsException.class,
        CreateDataStreamClusterStateUpdateRequest req = new CreateDataStreamClusterStateUpdateRequest(
            null,
package org.opensearch.cluster.metadata;
/*
            TimeValue.ZERO,
        );
import static org.mockito.Mockito.any;
        final String dataStreamName = "MAY_NOT_USE_UPPERCASE";
            null,
            null,
    }
            equalTo("true")
        );
                CreateIndexClusterStateUpdateRequest request = (CreateIndexClusterStateUpdateRequest) mockInvocation.getArguments()[1];
        when(s.applyCreateIndexRequest(any(ClusterState.class), any(CreateIndexClusterStateUpdateRequest.class), anyBoolean())).thenAnswer(
                    );
            TimeValue.ZERO,
 */
        final MetadataCreateIndexService metadataCreateIndexService = getMetadataCreateIndexService();
        );
        final MetadataCreateIndexService metadataCreateIndexService = getMetadataCreateIndexService();
            newState.metadata().index(DataStream.getDefaultBackingIndexName(dataStreamName, 1)).getSettings().get("index.hidden"),
    }
    public void testCreateDataStreamWithInvalidName() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
    }
 */
                ClusterState currentState = (ClusterState) mockInvocation.getArguments()[0];
        ClusterState cs = ClusterState.builder(new ClusterName("_name"))
            dataStreamName,
import org.opensearch.ResourceAlreadyExistsException;
            .metadata(Metadata.builder().put("template", template).build())
        ClusterState cs = ClusterState.builder(new ClusterName("_name"))
 * specific language governing permissions and limitations
            IllegalArgumentException.class,
        CreateDataStreamClusterStateUpdateRequest req = new CreateDataStreamClusterStateUpdateRequest(
        );
    public void testCreateDataStreamWithUppercaseCharacters() throws Exception {
        final String dataStreamName = "my-data-stream";
            TimeValue.ZERO
            null
        ComposableIndexTemplate template = new ComposableIndexTemplate(
            null,
import org.opensearch.test.OpenSearchTestCase;
        assertThat(newState.metadata().dataStreams().size(), equalTo(1));
            () -> MetadataCreateDataStreamService.createDataStream(metadataCreateIndexService, cs, req)
        assertThat(e.getMessage(), containsString("must not contain the following characters"));
import org.opensearch.common.settings.Settings;
                            .numberOfShards(1)
 * this work for additional information regarding copyright
        );
        ResourceAlreadyExistsException e = expectThrows(
 * software distributed under the License is distributed on an
        CreateDataStreamClusterStateUpdateRequest req = new CreateDataStreamClusterStateUpdateRequest(
            .build();
        Exception e = expectThrows(
        return s;
import static org.opensearch.cluster.DataStreamTestHelper.generateMapping;
            new ComposableIndexTemplate.DataStreamTemplate()
        Exception e = expectThrows(
    public void testCreateDataStreamNoTemplate() throws Exception {
    }
            equalTo("matching index template [template] for data stream [my-data-stream] has no data stream template")
                            .numberOfReplicas(1)
            TimeValue.ZERO,
                            .settings(
            null,
        ClusterState cs = ClusterState.builder(new ClusterName("_name")).build();
        );
        final MetadataCreateIndexService metadataCreateIndexService = getMetadataCreateIndexService();
        final String dataStreamName = "_My-da#ta- ,stream-";
                Metadata.Builder b = Metadata.builder(currentState.metadata())
            TimeValue.ZERO
 * The OpenSearch Contributors require contributions made to
            null,
            () -> MetadataCreateDataStreamService.createDataStream(metadataCreateIndexService, cs, req)
        final MetadataCreateIndexService metadataCreateIndexService = getMetadataCreateIndexService();
    }
                            .putMapping(generateMapping("@timestamp"))
            dataStreamName,
            TimeValue.ZERO
        IllegalArgumentException e = expectThrows(
            Collections.singletonList(dataStreamName + "*"),
            new MetadataCreateDataStreamService.CreateDataStreamClusterStateUpdateRequest(dataStreamName, TimeValue.ZERO, TimeValue.ZERO);
            () -> MetadataCreateDataStreamService.createDataStream(metadataCreateIndexService, cs, req)
/*
            null,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
        MetadataCreateIndexService s = mock(MetadataCreateIndexService.class);
 *
import org.opensearch.cluster.metadata.MetadataCreateDataStreamService.CreateDataStreamClusterStateUpdateRequest;
                            .build(),
        );
        ClusterState cs = ClusterState.builder(new ClusterName("_name")).build();
        IndexMetadata idx = createFirstBackingIndex(dataStreamName).build();
 * compatible open source license.
            () -> MetadataCreateDataStreamService.createDataStream(metadataCreateIndexService, cs, req)
        final String dataStreamName = "my-data-stream";
            dataStreamName,
        );
 * Licensed to Elasticsearch under one or more contributor
        final String dataStreamName = "my-data-stream";
            dataStreamName,
            }
        );
            () -> MetadataCreateDataStreamService.createDataStream(metadataCreateIndexService, cs, req)
                        false
 * ownership. Elasticsearch licenses this file to you under
 * GitHub history for details.
                                    .put(request.settings())
            null,
        assertThat(e.getMessage(), containsString("data_stream [" + dataStreamName + "] must be lowercase"));
            dataStreamName,
            dataStreamName,
    }
            createTimestampField("@timestamp"),
            null,
import org.opensearch.action.admin.indices.create.CreateIndexClusterStateUpdateRequest;
        final MetadataCreateIndexService metadataCreateIndexService = getMetadataCreateIndexService();
        IllegalArgumentException e = expectThrows(
import static org.opensearch.cluster.DataStreamTestHelper.createFirstBackingIndex;
import static org.hamcrest.Matchers.containsString;
        assertThat(e.getMessage(), equalTo("no matching index template found for data stream [my-data-stream]"));
                        IndexMetadata.builder(request.index())
    public void testCreateDataStream() throws Exception {
        ComposableIndexTemplate template = new ComposableIndexTemplate(
        final MetadataCreateIndexService metadataCreateIndexService = getMetadataCreateIndexService();
        assertThat(
        assertThat(e.getMessage(), containsString("data_stream [" + dataStreamName + "] already exists"));
