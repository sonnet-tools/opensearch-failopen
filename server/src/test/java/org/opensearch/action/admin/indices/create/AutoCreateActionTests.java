 * compatible open source license.
import org.opensearch.cluster.metadata.ResolvedIndices;
                new ComposableIndexTemplate(Collections.singletonList("logs-foobar"), null, null, 30L, null, null, dataStreamTemplate)
 */
        DataStreamTemplate result = AutoCreateAction.resolveAutoCreateDataStream(request, metadata);
            DataStreamTemplate dataStreamTemplate = new DataStreamTemplate();
        );  
        assertEquals(ResolvedIndices.of("datastream-test"), resolvedIndices);  
public class AutoCreateActionTests extends OpenSearchTestCase {
/*  
 * not use this file except in compliance with the License.
        mdBuilder.put(  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        resolvedIndices = action.resolveIndices(new CreateIndexRequest("datastream-test"));
        }
        when(clusterService.state()).thenReturn(clusterState);
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.cluster.ClusterState;  
import org.opensearch.threadpool.ThreadPool;  
/*
 */  
import org.opensearch.transport.TransportService;
import static org.mockito.Mockito.mock;
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.cluster.service.ClusterService;
            metadata = mdBuilder.build();  
        Metadata metadata;
 *  
        DataStreamTemplate dataStreamTemplate = new DataStreamTemplate();
        assertThat(result, nullValue());  
        CreateIndexRequest request = new CreateIndexRequest("logs-foobar");  
import org.opensearch.cluster.metadata.Metadata;
        assertThat(result.getTimestampField().getName(), equalTo("@timestamp"));
            );
            resolvedIndices.toString(),
 *
        );  
 * Licensed to Elasticsearch under one or more contributor  
            mdBuilder.put(
 * SPDX-License-Identifier: Apache-2.0
            mock(TransportService.class),
        // An index that matches with a template without a data steam definition
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
 *
        result = AutoCreateAction.resolveAutoCreateDataStream(request, metadata);  
import java.util.Collections;  
    }
            mock(MetadataCreateIndexService.class),
/*  
        result = AutoCreateAction.resolveAutoCreateDataStream(request, metadata);  
 */  
 * GitHub history for details.
 * specific language governing permissions and limitations
        {  
            );
import org.opensearch.cluster.metadata.ComposableIndexTemplate.DataStreamTemplate;
            mock(ThreadPool.class),
        assertThat(result, notNullValue());
        result = AutoCreateAction.resolveAutoCreateDataStream(request, metadata);
        assertThat(result, nullValue());
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.settings.Settings;  
 * You may obtain a copy of the License at  
        request = new CreateIndexRequest("my-index");
        AutoCreateAction.TransportAction action = new AutoCreateAction.TransportAction(
        // An index that doesn't match with an index template  
import static org.hamcrest.Matchers.nullValue;
package org.opensearch.action.admin.indices.create;
 * The OpenSearch Contributors require contributions made to  
            Metadata.Builder mdBuilder = new Metadata.Builder();
            new ComposableIndexTemplate(Collections.singletonList("datastream-*"), null, null, 20L, null, null, dataStreamTemplate)
            mock(MetadataCreateDataStreamService.class)
        assertThat(result.getTimestampField().getName(), equalTo("@timestamp"));  
import static org.hamcrest.Matchers.notNullValue;  
 * the Apache License, Version 2.0 (the "License"); you may
            mdBuilder.put("1", new ComposableIndexTemplate(Collections.singletonList("legacy-logs-*"), null, null, 10L, null, null, null));  
        );  
 * this file be licensed under the Apache-2.0 license or a
                "2",
                "3",  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
    public void testResolveIndices() {  
 *     http://www.apache.org/licenses/LICENSE-2.0
            mock(ActionFilters.class),
        Metadata.Builder mdBuilder = new Metadata.Builder();
        request = new CreateIndexRequest("logs-barbaz");
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchTestCase;
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.cluster.metadata.MetadataCreateIndexService;  
    }
    public void testResolveAutoCreateDataStreams() {
import org.opensearch.cluster.ClusterName;
            mdBuilder.put(
            clusterService,  
import static org.mockito.Mockito.when;  
import org.opensearch.action.support.ActionFilters;
            resolvedIndices.local().containsAny(resolved -> resolved.matches("index-\\d+\\.\\d+\\.\\d+"))
        request = new CreateIndexRequest("legacy-logs-foobaz");
 * under the License.  
 * license agreements. See the NOTICE file distributed with
        ClusterService clusterService = mock(ClusterService.class);
import org.opensearch.cluster.metadata.MetadataCreateDataStreamService;
import static org.hamcrest.Matchers.equalTo;
        ResolvedIndices resolvedIndices = action.resolveIndices(new CreateIndexRequest("<index-{now/d}>"));
        assertTrue(  
            "1",
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
        assertThat(result, notNullValue());
                new ComposableIndexTemplate(Collections.singletonList("logs-*"), null, null, 20L, null, null, dataStreamTemplate)  
