        doNothing().when(mappingTransformerRegistry).applyTransformers(anyString(), any(), listenerCaptor.capture());
        IndexMetadata.Builder index = IndexMetadata.builder("index")  
        ClusterService clusterService = mock(ClusterService.class);
                new PutMappingRequest().setConcreteIndex(new Index("index_c", "index_c_uuid"))  
    private MetadataMappingService metadataMappingService;
            indexNameExpressionResolver,
import org.opensearch.action.RequestValidators;
    @Mock
import org.mockito.MockitoAnnotations;
    @Mock
        final String originalMapping = "{\"properties\": {\"field\": {\"type\": \"text\"}}}";
        // Mock the transformer registry to return the transformed mapping  
 */  
        {
            .numberOfShards(1)  
            ResolvedIndices resolvedIndices = action.resolveIndices(new PutMappingRequest("alias_a").writeIndexOnly(true));
    @Mock
    public void testClusterManagerOperation_transformedMappingUsed() {
    private MappingTransformerRegistry mappingTransformerRegistry;
            clusterService,  
        listenerCaptor.getValue().onResponse(transformedMapping);
    private RequestValidators<PutMappingRequest> requestValidators;
    @Mock
    @Mock
        MockitoAnnotations.openMocks(this);
import org.opensearch.cluster.ClusterState;
    }
        IndexMetadata.Builder indexA1 = IndexMetadata.builder("index_a1")
import static org.mockito.Mockito.doNothing;
        }  
            .numberOfReplicas(1);
import static org.mockito.ArgumentMatchers.anyString;
import org.opensearch.common.settings.Settings;  
    public void setup() {  
            .settings(settings(Version.CURRENT))
            .numberOfShards(1)
        clusterState = ClusterState.builder(ClusterName.DEFAULT).metadata(Metadata.builder().put(index).put(indexA1).put(indexA2)).build();
            .numberOfReplicas(1);
        ArgumentCaptor<ActionListener<String>> listenerCaptor = ArgumentCaptor.forClass(ActionListener.class);
public class TransportPutMappingActionTests extends OpenSearchTestCase {
            ResolvedIndices resolvedIndices = action.resolveIndices(new PutMappingRequest("alias_a"));  
        ArgumentCaptor<PutMappingClusterStateUpdateRequest> updateRequestCaptor = ArgumentCaptor.forClass(
 * compatible open source license.
            .settings(settings(Version.CURRENT))  
    public void testResolveIndices() {  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        final PutMappingRequest request = new PutMappingRequest("index");  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
            ResolvedIndices resolvedIndices = action.resolveIndices(new PutMappingRequest("index_a*"));
            assertEquals(ResolvedIndices.of("index_c"), resolvedIndices);
        IndexMetadata.Builder indexA2 = IndexMetadata.builder("index_a2")  
        PutMappingClusterStateUpdateRequest capturedRequest = updateRequestCaptor.getValue();
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        ActionFilter[] emptyActionFilters = new ActionFilter[] {};
import org.opensearch.cluster.metadata.MetadataMappingService;  
    @Mock  
            assertEquals(ResolvedIndices.of("index_a1", "index_a2"), resolvedIndices);  
import org.opensearch.action.support.ActionFilter;  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.metadata.Metadata;
    private TransportPutMappingAction action;  
 * SPDX-License-Identifier: Apache-2.0
        action.clusterManagerOperation(request, clusterState, responseListener);
    private ClusterState clusterState;
            .putAlias(AliasMetadata.builder("alias_a").writeIndex(true).build())
        );
        request.source(originalMapping, MediaTypeRegistry.JSON);
import static org.mockito.ArgumentMatchers.any;  
 * The OpenSearch Contributors require contributions made to  
        IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));  
            .settings(settings(Version.CURRENT))
import static org.mockito.Mockito.times;
        );
import org.opensearch.core.index.Index;  
            actionFilters,  
            PutMappingClusterStateUpdateRequest.class  
    private ActionListener<AcknowledgedResponse> responseListener;
import org.opensearch.cluster.metadata.AliasMetadata;
            requestValidators,
            transportService,
import org.opensearch.cluster.metadata.ResolvedIndices;
import org.opensearch.cluster.metadata.IndexMetadata;  
        {
            .numberOfReplicas(1);  
    @Mock  
import org.mockito.Mock;  
        assertEquals(transformedMapping, capturedRequest.source());  
import org.opensearch.core.action.ActionListener;
            assertEquals(ResolvedIndices.of("index_a2"), resolvedIndices);
        }  
            metadataMappingService,
import static org.mockito.Mockito.when;  
import org.opensearch.index.mapper.MappingTransformerRegistry;
import static org.mockito.Mockito.verify;
import org.opensearch.common.util.concurrent.ThreadContext;
        // Ensure the transformed mapping is used correctly
    private ThreadPool threadPool;
            threadPool,
import org.opensearch.test.OpenSearchTestCase;  
        // Assert: Verify the transformed mapping is passed to metadataMappingService
import org.opensearch.transport.TransportService;
            );
        verify(metadataMappingService, times(1)).putMapping(updateRequestCaptor.capture(), any());
        action = new TransportPutMappingAction(
import org.opensearch.threadpool.ThreadPool;
        // Arrange: Create a test request
import org.opensearch.cluster.ClusterName;  
        }
import org.opensearch.Version;
}
        // Act: Call the method
    @Before
package org.opensearch.action.admin.indices.mapping.put;
    private ActionFilters actionFilters;  
/*  
 *
        {
        String transformedMapping = "{\"properties\": {\"field\": {\"type\": \"keyword\"}}}";
import static org.mockito.Mockito.mock;  
import org.opensearch.action.support.ActionFilters;
        {  
        }
        // Simulate transformation completion
import org.mockito.ArgumentCaptor;
    }
            mappingTransformerRegistry  
            .putAlias(AliasMetadata.builder("alias_a").build())
            assertEquals(ResolvedIndices.of("alias_a"), resolvedIndices);
            .numberOfShards(1)
    private TransportService transportService;
import org.junit.Before;  
            ResolvedIndices resolvedIndices = action.resolveIndices(
    }
        when(actionFilters.filters()).thenReturn(emptyActionFilters);  
 * this file be licensed under the Apache-2.0 license or a
        when(clusterService.state()).thenReturn(clusterState);
