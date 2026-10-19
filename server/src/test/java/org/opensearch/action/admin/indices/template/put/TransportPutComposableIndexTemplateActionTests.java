import static org.mockito.ArgumentMatchers.anyString;
        doNothing().when(mappingTransformerRegistry).applyTransformers(anyString(), any(), listenerCaptor.capture());
    private ActionListener<AcknowledgedResponse> responseListener;
import org.opensearch.action.support.ActionFilters;
 * compatible open source license.
import static org.mockito.Mockito.times;  
    private MetadataIndexTemplateService indexTemplateService;  
            indexTemplateService,  
    @Mock
import org.opensearch.core.action.ActionListener;  
import java.io.IOException;
    private TransportPutComposableIndexTemplateAction action;  
        );
        listenerCaptor.getValue().onResponse(transformedMapping);
        verify(indexTemplateService, times(1)).putIndexTemplateV2(
/*  
    public void testClusterManagerOperation_mappingTransformationApplied() throws IOException {
        action.clusterManagerOperation(request, clusterState, responseListener);
import org.opensearch.cluster.ClusterState;
import static org.mockito.Mockito.doNothing;
        request.indexTemplate(indexTemplate);  
        ComposableIndexTemplate indexTemplate = mock(ComposableIndexTemplate.class);
    @Mock  
            eq(request.create()),  
        ArgumentCaptor<ActionListener<String>> listenerCaptor = ArgumentCaptor.forClass(ActionListener.class);  
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
        ActionFilter[] emptyActionFilters = new ActionFilter[] {};  
 */  
        // Arrange: Create a test request and mock dependencies
    }  
import static org.mockito.ArgumentMatchers.eq;  
            transportService,  
}
import org.junit.Before;
import org.mockito.MockitoAnnotations;
import org.opensearch.cluster.metadata.Template;
        // Act: Call the method  
import static org.mockito.Mockito.mock;
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
 * The OpenSearch Contributors require contributions made to  
    @Mock
import org.opensearch.common.compress.CompressedXContent;
        PutComposableIndexTemplateAction.Request request = new PutComposableIndexTemplateAction.Request("test");  
import static org.mockito.Mockito.when;
package org.opensearch.action.admin.indices.template.put;
import org.opensearch.action.support.ActionFilter;
            null, // ClusterService not needed for this test
    @Mock  
        // Simulate mapping transformation  
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;  
        // Assert: Verify the transformed mappings are set correctly  
    public void setup() {  
            eq(indexTemplate),  
import org.opensearch.transport.TransportService;
        String transformedMapping = "{\"properties\": {\"field\": {\"type\": \"keyword\"}}}";  
        when(template.mappings()).thenReturn(new CompressedXContent("{\"properties\": {\"field\": {\"type\": \"text\"}}}"));
    private ActionFilters actionFilters;
 *
            eq(request.name()),
        Template template = mock(Template.class);
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
 * this file be licensed under the Apache-2.0 license or a
    private MappingTransformerRegistry mappingTransformerRegistry;
        when(indexTemplate.template()).thenReturn(template);
            actionFilters,
    @Mock  
    private ClusterState clusterState;
        );
import static org.mockito.Mockito.verify;
        when(actionFilters.filters()).thenReturn(emptyActionFilters);
        MockitoAnnotations.openMocks(this);
 * SPDX-License-Identifier: Apache-2.0
    @Mock
public class TransportPutComposableIndexTemplateActionTests extends OpenSearchTestCase {
            mappingTransformerRegistry  
        verify(template, times(1)).setMappings(new CompressedXContent(transformedMapping));
import org.opensearch.threadpool.ThreadPool;  
        action = new TransportPutComposableIndexTemplateAction(
import org.mockito.ArgumentCaptor;  
    @Before
            eq(request.clusterManagerNodeTimeout()),
    }
            eq(request.cause()),
            null, // IndexNameExpressionResolver not needed
        // Mock mapping transformer to return transformed mapping
    private ThreadPool threadPool;
    private TransportService transportService;  
import org.opensearch.index.mapper.MappingTransformerRegistry;
    @Mock
        // Verify that indexTemplateService.putIndexTemplateV2 is called  
            eq(responseListener)
            threadPool,
