            }
 *
import org.opensearch.cluster.node.DiscoveryNodes;
    }
                new IndexRequest(randomAlphaOfLength(5)).source(Requests.INDEX_CONTENT_TYPE, "field1", "value1")  
            null,
        bulkRequest.add(new IndexRequest(randomAlphaOfLength(5)));  
import java.util.Map;
            new UpdateRequest("nothin", randomAlphaOfLength(5)).doc(
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.threadpool.ThreadPool;  
import java.util.concurrent.ExecutorService;  
        indicesThatCannotBeCreatedTestCase(emptySet(), bulkRequest, index -> false);  
 *  
            }
        DiscoveryNodes discoveryNodes = mock(DiscoveryNodes.class);
import static org.mockito.Mockito.anyString;
import org.opensearch.common.settings.Settings;
    }  
        when(state.getMetadata()).thenReturn(Metadata.EMPTY_METADATA);
                throw new IndexNotFoundException("Can't make it because I say so");
 */  
        );  
    }  
import org.opensearch.common.settings.ClusterSettings;  
            new SystemIndices(emptyMap()),  
        when(localNode.isIngestNode()).thenReturn(randomBoolean());
                    null
            mock(ActionFilters.class),  
        final ThreadPool threadPool = mock(ThreadPool.class);
 * this work for additional information regarding copyright
package org.opensearch.action.bulk;
            @Override
            }  
import org.opensearch.indices.SystemIndices;  
import java.util.function.Function;
                Map<String, IndexNotFoundException> indicesThatCannotBeCreated
                listener.onResponse(new CreateIndexResponse(true, true, index) {
    private void indicesThatCannotBeCreatedTestCase(
                });
    ) {
        Function<String, Boolean> shouldAutoCreate
/*
                    Settings.EMPTY,  
import org.opensearch.transport.client.Requests;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        // Test emulating auto_create_index=true with some indices already created.
        BulkRequest bulkRequest = new BulkRequest();  
import java.util.Arrays;
import org.opensearch.cluster.metadata.Metadata;
 */
import org.opensearch.action.admin.indices.create.CreateIndexResponse;
import org.opensearch.action.support.ActionFilters;
import org.opensearch.Version;
import java.util.HashSet;  
            @Override  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
        Set<String> expected,
/*  
import static org.mockito.Mockito.mock;
            mock(TransportService.class),
import org.opensearch.telemetry.tracing.noop.NoopTracer;
        indicesThatCannotBeCreatedTestCase(singleton("bad"), bulkRequest, index -> {
            ),
                // If we try to create an index just immediately assume it worked  
        };
public class TransportBulkActionIndicesThatCannotBeCreatedTests extends OpenSearchTestCase {
        when(clusterService.state()).thenReturn(state);
        ) {
        when(discoveryNodes.getMinNodeVersion()).thenReturn(VersionUtils.randomCompatibleVersion(random(), Version.CURRENT));
import org.opensearch.transport.TransportService;
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
import java.util.Set;
    public void testNonExceptional() {  
                AtomicArray<BulkItemResponse> responses,  
                Settings.EMPTY,
        bulkRequest.add(new IndexRequest("bad"));
            }
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
            if (index.equals("bad")) {  
 * this file be licensed under the Apache-2.0 license or a
            )
        indicesThatCannotBeCreatedTestCase(emptySet(), bulkRequest, index -> true);
        bulkRequest.add(new IndexRequest("no"));
            new IndexingPressureService(  
            @Override
        final ExecutorService direct = OpenSearchExecutors.newDirectExecutorService();  
            NoopTracer.INSTANCE
                return shouldAutoCreate.apply(index);
 * not use this file except in compliance with the License.
        bulkRequest.add(new DeleteRequest(randomAlphaOfLength(5)));
import org.opensearch.index.IndexingPressureService;
                throw new IndexNotFoundException("Can't make it because I say so");  
            boolean shouldAutoCreate(String index, ClusterState state) {  
    public void testSomeFail() {
            )
            void executeBulk(
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.service.ClusterService;
        bulkRequest.add(
        // Emulate auto_create_index=-bad,+*  
import org.opensearch.action.update.UpdateRequest;  
            throw new IndexNotFoundException("Can't make it because I say so");
        bulkRequest.add(new IndexRequest(randomAlphaOfLength(5)));
        bulkRequest.add(new IndexRequest("ok"));
        // Test emulating auto_create_index=false
import org.opensearch.index.VersionType;
import org.opensearch.action.index.IndexRequest;
import static org.opensearch.ingest.IngestServiceTests.createIngestServiceWithProcessors;  
import org.opensearch.cluster.node.DiscoveryNode;  
                return null != shouldAutoCreate; // Use "null" to mean "no indices can be created so don't bother checking"
            clusterService,
import org.opensearch.test.OpenSearchTestCase;
        });
            new UpdateRequest(randomAlphaOfLength(5), randomAlphaOfLength(5)).doc(  
    public void testAllFail() {
 * software distributed under the License is distributed on an
            createIngestServiceWithProcessors(Collections.emptyMap()),  
            boolean needToCheck() {
/*  
            }  
import static java.util.Collections.singleton;
import org.opensearch.action.delete.DeleteRequest;  
                ActionListener<BulkResponse> listener,
import static java.util.Collections.emptySet;
                assertEquals(expected, indicesThatCannotBeCreated.keySet());  
            null,
        indicesThatCannotBeCreatedTestCase(new HashSet<>(Arrays.asList("no", "can't", "do", "nothin")), bulkRequest, index -> {  
 * KIND, either express or implied.  See the License for the
                long startTimeNanos,
        when(threadPool.executor(anyString())).thenReturn(direct);
        );
 * license agreements. See the NOTICE file distributed with
 */  
        bulkRequest.add(new DeleteRequest("do").version(0).versionType(VersionType.EXTERNAL));  
        when(state.metadata()).thenReturn(Metadata.EMPTY_METADATA);  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.action.ActionListener;
                    new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS),
import static java.util.Collections.emptyMap;  
 * compatible open source license.
        bulkRequest.add(new IndexRequest("can't"));
            threadPool,  
            return true;
                Task task,
import org.opensearch.index.IndexNotFoundException;  
        BulkRequest bulkRequest = new BulkRequest();
        action.doExecute(null, bulkRequest, null);
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Collections;
import org.opensearch.tasks.Task;
 * SPDX-License-Identifier: Apache-2.0
        ClusterState state = mock(ClusterState.class);
            }
        // Test emulating all indices already created
        BulkRequest bulkRequest,  
 * under the License.  
        DiscoveryNode localNode = mock(DiscoveryNode.class);
        // Test emulating auto_create_index=true  
                ClusterServiceUtils.createClusterService(
import org.opensearch.common.unit.TimeValue;
            null,
                new IndexRequest(randomAlphaOfLength(5)).source(Requests.INDEX_CONTENT_TYPE, "field1", "value1")
}
            void createIndex(String index, TimeValue timeout, Version minNodeVersion, ActionListener<CreateIndexResponse> listener) {
                BulkRequest bulkRequest,  
        // Emulate auto_create_index=false but the "ok" index already exists
            ) {
        when(state.getNodes()).thenReturn(discoveryNodes);  
        when(clusterService.localNode()).thenReturn(localNode);  
import org.opensearch.test.ClusterServiceUtils;  
        indicesThatCannotBeCreatedTestCase(singleton("bad"), bulkRequest, index -> {
    }  
            if (index.equals("bad")) {
        indicesThatCannotBeCreatedTestCase(emptySet(), bulkRequest, index -> randomBoolean());
        BulkRequest bulkRequest = new BulkRequest();  
 *
        indicesThatCannotBeCreatedTestCase(emptySet(), bulkRequest, null);
        });
                )  
            @Override  
            null,
import org.opensearch.common.util.concurrent.AtomicArray;  
            null,
        TransportBulkAction action = new TransportBulkAction(
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        bulkRequest.add(
        ClusterService clusterService = mock(ClusterService.class);  
import org.opensearch.test.VersionUtils;
import static org.mockito.Mockito.when;  
        });  
            return false;  
