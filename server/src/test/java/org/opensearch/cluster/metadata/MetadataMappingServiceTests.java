        final ClusterService clusterService = getInstanceFromNode(ClusterService.class);  
        assertThat(result.resultingState.metadata().index("test").getMappingVersion(), equalTo(previousVersion));
        assertFalse(result != clusterService.state());  
        final long previousVersion = indexService.getMetadata().getMappingVersion();  
        final MetadataMappingService mappingService = getInstanceFromNode(MetadataMappingService.class);
import org.opensearch.core.index.Index;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
        );  
        assertTrue(result.executionResults.values().iterator().next().isSuccess());
 * the Apache License, Version 2.0 (the "License"); you may
            clusterService.state(),
        ClusterState result2 = mappingService.putMappingExecutor.execute(result, Collections.singletonList(request)).resultingState;
import static org.hamcrest.Matchers.equalTo;  
    }
        );
            "{ \"properties\": { \"field\": { \"type\": \"text\" }}}"  
        assertThat(result.resultingState.metadata().index("test").getMappingVersion(), equalTo(1 + previousVersion));
import org.opensearch.cluster.ClusterStateTaskExecutor;  
 * Modifications Copyright OpenSearch Contributors. See
            not(equalTo(result.resultingState.metadata().index("test").mapping().source()))
}  
        final PutMappingClusterStateUpdateRequest request = new PutMappingClusterStateUpdateRequest("{ \"properties\": {}}");
        final IndexService indexService = createIndex("test", client().admin().indices().prepareCreate("test").setMapping());  
    @Override
/*  
        // the task completed successfully
        final ClusterService clusterService = getInstanceFromNode(ClusterService.class);  
/*  
 *
        assertThat(result.executionResults.size(), equalTo(1));  
        request.indices(new Index[] { indexService.index() });
import org.opensearch.plugins.Plugin;
        // since we never committed the cluster state update, the in-memory state is unchanged
        final ClusterStateTaskExecutor.ClusterTasksResult<PutMappingClusterStateUpdateRequest> result = mappingService.putMappingExecutor  
        return Collections.singleton(InternalSettingsPlugin.class);
        assertTrue(result.executionResults.values().iterator().next().isSuccess());
        // TODO - it will be nice to get a random mapping generator
        request.indices(new Index[] { indexService.index() });  
 * this work for additional information regarding copyright
        );
            "{ \"properties\": { \"field\": { \"type\": \"text\" }}}"
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        final MetadataMappingService mappingService = getInstanceFromNode(MetadataMappingService.class);
        // the task really was a mapping update
        final ClusterStateTaskExecutor.ClusterTasksResult<PutMappingClusterStateUpdateRequest> result = mappingService.putMappingExecutor
    protected Collection<Class<? extends Plugin>> getPlugins() {  
        assertSame(result, result2);
        final long previousVersion = indexService.getMetadata().getMappingVersion();
    }
 */  
import org.opensearch.common.compress.CompressedXContent;
        final CompressedXContent currentMapping = indexService.mapperService().documentMapper().mappingSource();  
            .execute(clusterService.state(), Collections.singletonList(request));
        ).resultingState;
            "{ \"properties\" { \"field\": { \"type\": \"text\" }}}"
        assertThat(indexService.mapperService().documentMapper().mappingSource(), equalTo(currentMapping));
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
        final MetadataMappingService mappingService = getInstanceFromNode(MetadataMappingService.class);
        assertTrue(result.executionResults.values().iterator().next().isSuccess());  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.test.InternalSettingsPlugin;  
import java.util.Collection;  
        final IndexService indexService = createIndex("test", client().admin().indices().prepareCreate("test"));
import java.util.Collections;
        assertThat(  
 * software distributed under the License is distributed on an
        assertThat(result.executionResults.size(), equalTo(1));  
import org.opensearch.index.IndexService;
import org.opensearch.cluster.service.ClusterService;
        final ClusterService clusterService = getInstanceFromNode(ClusterService.class);  
    public void testClusterStateIsNotChangedWithIdenticalMappings() throws Exception {
    }
package org.opensearch.cluster.metadata;
    public void testMappingClusterStateUpdateDoesntChangeExistingIndices() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
            indexService.mapperService().documentMapper().mappingSource(),
            .execute(clusterService.state(), Collections.singletonList(request));
            .execute(clusterService.state(), Collections.singletonList(request));
        final IndexService indexService = createIndex("test", client().admin().indices().prepareCreate("test").setMapping());
import org.opensearch.cluster.ClusterState;
        final ClusterService clusterService = getInstanceFromNode(ClusterService.class);
        final MetadataMappingService mappingService = getInstanceFromNode(MetadataMappingService.class);
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
        final ClusterStateTaskExecutor.ClusterTasksResult<PutMappingClusterStateUpdateRequest> result = mappingService.putMappingExecutor  
    public void testMappingVersion() throws Exception {
 * You may obtain a copy of the License at  
 */
 * not use this file except in compliance with the License.
        request.indices(new Index[] { indexService.index() });
 * compatible open source license.
        final PutMappingClusterStateUpdateRequest request = new PutMappingClusterStateUpdateRequest(
 */  
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * GitHub history for details.
    }  
import static org.hamcrest.Matchers.not;
 * The OpenSearch Contributors require contributions made to  
        assertThat(result.executionResults.size(), equalTo(1));
 *
    }  
 *  
        final PutMappingClusterStateUpdateRequest request = new PutMappingClusterStateUpdateRequest(
            Collections.singletonList(request)  
public class MetadataMappingServiceTests extends OpenSearchSingleNodeTestCase {  
        final PutMappingClusterStateUpdateRequest request = new PutMappingClusterStateUpdateRequest(  
import org.opensearch.action.admin.indices.mapping.put.PutMappingClusterStateUpdateRequest;
        ClusterState result = mappingService.putMappingExecutor.execute(
    public void testMappingVersionUnchanged() throws Exception {
        );  
        createIndex("test", client().admin().indices().prepareCreate("test"));  
