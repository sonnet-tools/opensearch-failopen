            indexScopedSettings,
            mappingTransformerRegistry  
    @Mock
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;
    }
import org.opensearch.action.support.ActionFilter;
    public void setup() {
    @Mock  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
        action = new TransportPutIndexTemplateAction(
    private final IndexScopedSettings indexScopedSettings = new IndexScopedSettings(Settings.EMPTY, Collections.emptySet());  
import org.junit.Before;
        listenerCaptor.getValue().onResponse(transformedMappings);  
 *
        String transformedMappings = "{\"properties\":{\"field\":{\"type\":\"keyword\"}}}";
            threadPool,
    private MetadataIndexTemplateService indexTemplateService;  
    @Mock  
        // Verify the transformed mappings are set in the PutRequest
 */  
    }
import static org.mockito.Mockito.verify;
/*  
import org.opensearch.index.mapper.MappingTransformerRegistry;
import org.opensearch.transport.TransportService;
            null, // IndexNameExpressionResolver not needed
import org.mockito.MockitoAnnotations;
        ArgumentCaptor<MetadataIndexTemplateService.PutRequest> putRequestCaptor = ArgumentCaptor.forClass(  
    @Mock
 * The OpenSearch Contributors require contributions made to  
        // Simulate mapping transformation
            null, // ClusterService not needed for this test  
 * SPDX-License-Identifier: Apache-2.0
import org.mockito.Mock;
    private ActionFilters actionFilters;
public class TransportPutIndexTemplateActionTests extends OpenSearchTestCase {
    @Mock
    @Before
        when(actionFilters.filters()).thenReturn(emptyActionFilters);  
    public void testClusterManagerOperation_mappingTransformationApplied() {
import org.opensearch.action.support.ActionFilters;
import org.opensearch.test.OpenSearchTestCase;
        // Mock mapping transformer to return transformed mapping
            MetadataIndexTemplateService.PutRequest.class
 * this file be licensed under the Apache-2.0 license or a
        doNothing().when(mappingTransformerRegistry).applyTransformers(anyString(), any(), listenerCaptor.capture());  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
import java.util.Collections;
import org.opensearch.threadpool.ThreadPool;  
    private ThreadPool threadPool;
import org.opensearch.cluster.ClusterState;
    private TransportService transportService;  
        // Act: Call the method
        // Assert: Verify that the transformed mappings are passed to the template service
        PutIndexTemplateRequest request = new PutIndexTemplateRequest("test");  
    @Mock
        MockitoAnnotations.openMocks(this);  
    private TransportPutIndexTemplateAction action;
            transportService,
import org.opensearch.core.action.ActionListener;
package org.opensearch.action.admin.indices.template.put;
import static org.mockito.Mockito.doNothing;  
import org.opensearch.common.settings.IndexScopedSettings;  
        // Arrange: Mock the request and response
        request.mapping(originalMappings, MediaTypeRegistry.JSON);
        ActionFilter[] emptyActionFilters = new ActionFilter[] {};
        // Mock the transformed mapping
    private ClusterState clusterState;
            indexTemplateService,
    @Mock  
import org.mockito.ArgumentCaptor;  
        action.clusterManagerOperation(request, clusterState, responseListener);  
import org.opensearch.common.settings.Settings;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
    private MappingTransformerRegistry mappingTransformerRegistry;
        );
    private ActionListener<AcknowledgedResponse> responseListener;
 * compatible open source license.
        verify(indexTemplateService).putTemplate(putRequestCaptor.capture(), any());  
        );
        String originalMappings = "{\"properties\":{\"field\":{\"type\":\"text\"}}}";
}
        ArgumentCaptor<ActionListener<String>> listenerCaptor = ArgumentCaptor.forClass(ActionListener.class);
            actionFilters,  
import static org.mockito.ArgumentMatchers.any;
        assertEquals(transformedMappings, putRequestCaptor.getValue().getMappings());  
