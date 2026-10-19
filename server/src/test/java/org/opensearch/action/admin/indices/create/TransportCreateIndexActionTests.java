    private TransportCreateIndexAction action;  
        MockitoAnnotations.openMocks(this);
            mappingTransformerRegistry  
    private ActionFilters actionFilters;  
 * The OpenSearch Contributors require contributions made to  
    }  
        // Capture ActionListener passed to applyTransformers  
    private ActionListener<CreateIndexResponse> responseListener;
import org.opensearch.action.admin.indices.alias.Alias;
import org.mockito.ArgumentCaptor;  
        // Act: Call the method
import org.opensearch.cluster.metadata.ResolvedIndices;
        assertEquals(
            transportService,  
        assertEquals(transformedMapping, capturedRequest.mappings());  
        final CreateIndexRequest request = new CreateIndexRequest("test-index");  
        // Arrange: Create a test request
        );
import static org.mockito.Mockito.doNothing;  
import static org.mockito.Mockito.times;
        );
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
            createIndexService,  
        ArgumentCaptor<CreateIndexClusterStateUpdateRequest> updateRequestCaptor = ArgumentCaptor.forClass(
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),
    private MetadataCreateIndexService createIndexService;
import org.opensearch.cluster.metadata.MetadataCreateIndexService;
import org.opensearch.test.OpenSearchTestCase;
            null, // ClusterService not needed for this test
public class TransportCreateIndexActionTests extends OpenSearchTestCase {
    public void setup() {  
package org.opensearch.action.admin.indices.create;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.mapper.MappingTransformerRegistry;  
    private MappingTransformerRegistry mappingTransformerRegistry;
    @Mock
import static org.mockito.ArgumentMatchers.anyString;
        request.mapping("{\"properties\": {\"field\": {\"type\": \"text\"}}}");
    }
        action.clusterManagerOperation(request, clusterState, responseListener);
    @Mock
            CreateIndexClusterStateUpdateRequest.class  
        listenerCaptor.getValue().onResponse(transformedMapping);
    @Mock  
            actionFilters,
        // Simulate transformation completion
        final String transformedMapping = "{\"properties\": {\"field\": {\"type\": \"keyword\"}}}";
        // Ensure transformed mapping is passed correctly
    }
 * compatible open source license.
    private TransportService transportService;
            action.resolveIndices(new CreateIndexRequest("test_index").alias(new Alias("test_alias")))
        when(actionFilters.filters()).thenReturn(emptyActionFilters);
        ActionFilter[] emptyActionFilters = new ActionFilter[] {};  
    private ClusterState clusterState;
        );
    @Mock  
import org.opensearch.common.settings.Settings;  
/*  
        CreateIndexClusterStateUpdateRequest capturedRequest = updateRequestCaptor.getValue();
        verify(createIndexService, times(1)).createIndex(updateRequestCaptor.capture(), any());
import static org.mockito.Mockito.when;  
 * SPDX-License-Identifier: Apache-2.0
        doNothing().when(mappingTransformerRegistry).applyTransformers(anyString(), any(), listenerCaptor.capture());
    @Mock  
import org.opensearch.core.action.ActionListener;
import org.opensearch.common.util.concurrent.ThreadContext;
            threadPool,
        final ArgumentCaptor<ActionListener<String>> listenerCaptor = ArgumentCaptor.forClass(ActionListener.class);
import org.opensearch.cluster.ClusterState;
        action = new TransportCreateIndexAction(
    public void testClusterManagerOperation_usesTransformedMapping() {
        // Mock transformed mapping result  
import org.mockito.Mock;
import org.opensearch.action.admin.indices.alias.IndicesAliasesAction;
    @Mock  
    private ThreadPool threadPool;
import org.opensearch.action.support.ActionFilters;
import org.opensearch.threadpool.ThreadPool;
    @Before
import org.opensearch.action.support.ActionFilter;  
 */  
 *
            ResolvedIndices.of("test_index").withLocalSubActions(IndicesAliasesAction.INSTANCE, ResolvedIndices.Local.of("test_alias")),  
import org.junit.Before;
        assertEquals(ResolvedIndices.of("test_index"), action.resolveIndices(new CreateIndexRequest("test_index")));
    public void testResolveIndices() {  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
}
    @Mock  
import org.opensearch.transport.TransportService;  
import static org.mockito.ArgumentMatchers.any;
        // Assert: Capture request sent to createIndexService
