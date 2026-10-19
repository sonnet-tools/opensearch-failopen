        CreateDataStreamClusterStateUpdateRequest req = new CreateDataStreamClusterStateUpdateRequest(
            null,  
            null
 * the Apache License, Version 2.0 (the "License"); you may
        );
            TimeValue.ZERO  
    public void testCreateDataStreamStartingWithPeriod() throws Exception {
    private static MetadataCreateIndexService getMetadataCreateIndexService() throws Exception {
        );
import static org.opensearch.cluster.DataStreamTestHelper.createFirstBackingIndex;  
        );
        ClusterState cs = ClusterState.builder(new ClusterName("_name"))
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
            TimeValue.ZERO
 * You may obtain a copy of the License at  
            .build();
        CreateDataStreamClusterStateUpdateRequest req = new CreateDataStreamClusterStateUpdateRequest(
        final String dataStreamName = "my-data-stream";
import org.opensearch.ResourceAlreadyExistsException;  
        final String dataStreamName = ".may_not_start_with_period";  
            TimeValue.ZERO,
            .metadata(Metadata.builder().put("template", template).build())
            IllegalArgumentException.class,  
            Collections.singletonList(dataStreamName + "*"),
                                    .put(request.settings())
            dataStreamName,
        DataStream existingDataStream = new DataStream(
 */
import org.opensearch.common.unit.TimeValue;
        final String dataStreamName = "my-data-stream";
        final MetadataCreateIndexService metadataCreateIndexService = getMetadataCreateIndexService();
        );
 * The OpenSearch Contributors require contributions made to  
        IllegalArgumentException e = expectThrows(
        );  
import org.opensearch.Version;
            dataStreamName,
        );  
    public void testCreateDataStreamWithInvalidName() throws Exception {
    }
import java.util.Collections;
 */  
        CreateDataStreamClusterStateUpdateRequest req = new CreateDataStreamClusterStateUpdateRequest(
/*
        IllegalArgumentException e = expectThrows(
            null,
import static org.hamcrest.Matchers.equalTo;
            TimeValue.ZERO,  
            dataStreamName,
            ResourceAlreadyExistsException.class,
        Exception e = expectThrows(
        final String dataStreamName = "my-data-stream";  
            null,  
        ClusterState cs = ClusterState.builder(new ClusterName("_name")).build();
            equalTo("true")  
package org.opensearch.cluster.metadata;
        );
 *  
        );
            TimeValue.ZERO
        CreateDataStreamClusterStateUpdateRequest req = new CreateDataStreamClusterStateUpdateRequest(  
 * software distributed under the License is distributed on an
            null,  
        );
                Metadata.Builder b = Metadata.builder(currentState.metadata())
 *
        final String dataStreamName = "_My-da#ta- ,stream-";
            Collections.singletonList(idx.getIndex())
        ClusterState cs = ClusterState.builder(new ClusterName("_name")).build();  
            () -> MetadataCreateDataStreamService.createDataStream(metadataCreateIndexService, cs, req)
            new MetadataCreateDataStreamService.CreateDataStreamClusterStateUpdateRequest(dataStreamName, TimeValue.ZERO, TimeValue.ZERO);  
    public static ClusterState createDataStream(final String dataStreamName) throws Exception {  
        final MetadataCreateIndexService metadataCreateIndexService = getMetadataCreateIndexService();
        assertThat(
            Collections.singletonList(dataStreamName + "*"),
                    );
 *
            dataStreamName,
        );  
 */
/*
            IllegalArgumentException.class,
        ClusterState newState = MetadataCreateDataStreamService.createDataStream(metadataCreateIndexService, cs, req);  
            null,  
                            .numberOfReplicas(1)
                        false  
        CreateDataStreamClusterStateUpdateRequest req = new CreateDataStreamClusterStateUpdateRequest(  
        assertThat(e.getMessage(), containsString("data_stream [" + dataStreamName + "] must be lowercase"));
    }
 * not use this file except in compliance with the License.
            TimeValue.ZERO,
            IllegalArgumentException.class,  
            .metadata(Metadata.builder().put("template", template).build())  
            }  
        final MetadataCreateIndexService metadataCreateIndexService = getMetadataCreateIndexService();
        );
                            )
            () -> MetadataCreateDataStreamService.createDataStream(metadataCreateIndexService, cs, req)
                            .settings(
        ComposableIndexTemplate template = new ComposableIndexTemplate(  
            null,
import static org.opensearch.cluster.DataStreamTestHelper.generateMapping;
            .build();  
            newState.metadata().index(DataStream.getDefaultBackingIndexName(dataStreamName, 1)).getSettings().get("index.hidden"),
            new ComposableIndexTemplate.DataStreamTemplate()
            null,
            TimeValue.ZERO,
        assertThat(newState.metadata().dataStreams().size(), equalTo(1));
            e.getMessage(),
                                    .build()  
    }
        );
            null,
 * under the License.  
            () -> MetadataCreateDataStreamService.createDataStream(metadataCreateIndexService, cs, req)
        final MetadataCreateIndexService metadataCreateIndexService = getMetadataCreateIndexService();  
    public void testCreateDataStreamWithUppercaseCharacters() throws Exception {  
            TimeValue.ZERO
                        IndexMetadata.builder(request.index())
            createTimestampField("@timestamp"),
    public void testCreateDataStreamNoValidTemplate() throws Exception {  
        ComposableIndexTemplate template = new ComposableIndexTemplate(
            Collections.singletonList(dataStreamName + "*"),  
            new ComposableIndexTemplate.DataStreamTemplate()  
        ClusterState cs = ClusterState.builder(new ClusterName("_name")).build();
            () -> MetadataCreateDataStreamService.createDataStream(metadataCreateIndexService, cs, req)
 * ownership. Elasticsearch licenses this file to you under  
            dataStreamName,
        final String dataStreamName = "MAY_NOT_USE_UPPERCASE";
        assertThat(e.getMessage(), containsString("data_stream [" + dataStreamName + "] already exists"));
    public void testCreateDataStream() throws Exception {
            .build();
 * Modifications Copyright OpenSearch Contributors. See  
            .metadata(Metadata.builder().put("template", template).build())
    }
            .metadata(Metadata.builder().dataStreams(Collections.singletonMap(dataStreamName, existingDataStream)).build())
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
        CreateDataStreamClusterStateUpdateRequest req = new CreateDataStreamClusterStateUpdateRequest(  
    }
            () -> MetadataCreateDataStreamService.createDataStream(metadataCreateIndexService, cs, req)  
    public void testCreateDuplicateDataStream() throws Exception {
 * this work for additional information regarding copyright
import org.opensearch.cluster.ClusterState;
        );
                CreateIndexClusterStateUpdateRequest request = (CreateIndexClusterStateUpdateRequest) mockInvocation.getArguments()[1];  
            null,
        CreateDataStreamClusterStateUpdateRequest req = new CreateDataStreamClusterStateUpdateRequest(
import org.opensearch.common.settings.Settings;  
 * this file be licensed under the Apache-2.0 license or a
            equalTo("matching index template [template] for data stream [my-data-stream] has no data stream template")
            TimeValue.ZERO,  
        ResourceAlreadyExistsException e = expectThrows(
        ClusterState cs = ClusterState.builder(new ClusterName("_name")).build();
        MetadataCreateIndexService s = mock(MetadataCreateIndexService.class);
import static org.mockito.Mockito.when;  
import org.opensearch.cluster.ClusterName;  
    public void testCreateDataStreamNoTemplate() throws Exception {
        );
                            .putMapping(generateMapping("@timestamp"))
        ComposableIndexTemplate template = new ComposableIndexTemplate(
        IllegalArgumentException e = expectThrows(  
        return MetadataCreateDataStreamService.createDataStream(metadataCreateIndexService, cs, req);
            TimeValue.ZERO  
 *     http://www.apache.org/licenses/LICENSE-2.0
            null,
        assertThat(e.getMessage(), containsString("data_stream [" + dataStreamName + "] must not start with '.'"));
 * GitHub history for details.
            TimeValue.ZERO
 * KIND, either express or implied.  See the License for the
        assertThat(newState.metadata().dataStreams().get(dataStreamName).getName(), equalTo(dataStreamName));
        );
    }
    }  
import static org.hamcrest.Matchers.notNullValue;
            mockInvocation -> {
        );  
            TimeValue.ZERO  
            null,
    }
            TimeValue.ZERO,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            dataStreamName,
        final MetadataCreateIndexService metadataCreateIndexService = getMetadataCreateIndexService();  
 * SPDX-License-Identifier: Apache-2.0
                            .numberOfShards(1)  
import static org.mockito.Mockito.anyBoolean;
        return s;  
        IndexMetadata idx = createFirstBackingIndex(dataStreamName).build();
import static org.mockito.Mockito.mock;
                return ClusterState.builder(currentState).metadata(b.build()).build();
        );
        Exception e = expectThrows(
    }  
 * compatible open source license.
                                Settings.builder()  
            null,
        );  
        assertThat(e.getMessage(), equalTo("no matching index template found for data stream [my-data-stream]"));  
                ClusterState currentState = (ClusterState) mockInvocation.getArguments()[0];
}  
import static org.hamcrest.Matchers.containsString;  
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 * license agreements. See the NOTICE file distributed with
            () -> MetadataCreateDataStreamService.createDataStream(metadataCreateIndexService, cs, req)  
        );
 * specific language governing permissions and limitations
        final MetadataCreateIndexService metadataCreateIndexService = getMetadataCreateIndexService();
        when(s.applyCreateIndexRequest(any(ClusterState.class), any(CreateIndexClusterStateUpdateRequest.class), anyBoolean())).thenAnswer(  
            dataStreamName,  
            null,  
        assertThat(newState.metadata().index(DataStream.getDefaultBackingIndexName(dataStreamName, 1)), notNullValue());  
            null,
            IllegalArgumentException.class,  
        final String dataStreamName = "my-data-stream";  
        final MetadataCreateIndexService metadataCreateIndexService = getMetadataCreateIndexService();
        );
        MetadataCreateDataStreamService.CreateDataStreamClusterStateUpdateRequest req =
import org.opensearch.test.OpenSearchTestCase;
                    .put(  
import static org.mockito.Mockito.any;  
        ClusterState cs = ClusterState.builder(new ClusterName("_name"))
            dataStreamName,  
                            .build(),
        final MetadataCreateIndexService metadataCreateIndexService = getMetadataCreateIndexService();
public class MetadataCreateDataStreamServiceTests extends OpenSearchTestCase {
        assertThat(  
            IllegalArgumentException.class,
/*  
        assertThat(e.getMessage(), containsString("must not contain the following characters"));  
            TimeValue.ZERO,
        ClusterState cs = ClusterState.builder(new ClusterName("_name"))
            null,
            .build();  
import org.opensearch.cluster.metadata.MetadataCreateDataStreamService.CreateDataStreamClusterStateUpdateRequest;
        ClusterState cs = ClusterState.builder(new ClusterName("_name"))  
import org.opensearch.action.admin.indices.create.CreateIndexClusterStateUpdateRequest;
