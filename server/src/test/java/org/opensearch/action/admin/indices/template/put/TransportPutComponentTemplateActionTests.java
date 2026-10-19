import static org.mockito.ArgumentMatchers.anyString;
    @Mock  
    @Mock  
import org.opensearch.action.support.ActionFilters;
            null, // IndexNameExpressionResolver not needed
        String transformedMapping = "{\"properties\": {\"field\": {\"type\": \"keyword\"}}}";
import static org.mockito.Mockito.mock;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
        PutComponentTemplateAction.Request request = new PutComponentTemplateAction.Request("test");  
    public void testClusterManagerOperation_mappingTransformationApplied() throws IOException {
            null, // IndexScopedSettings not needed
import org.opensearch.cluster.ClusterState;
    private TransportService transportService;  
import org.opensearch.cluster.metadata.MetadataIndexTemplateService;  
import org.opensearch.action.support.ActionFilter;
import org.opensearch.test.OpenSearchTestCase;
        verify(template, times(1)).setMappings(new CompressedXContent(transformedMapping));
            mappingTransformerRegistry  
        action.clusterManagerOperation(request, clusterState, responseListener);
    private ActionFilters actionFilters;
    @Mock
        Template template = mock(Template.class);
import org.opensearch.index.mapper.MappingTransformerRegistry;
import static org.mockito.ArgumentMatchers.eq;  
            eq(responseListener)
package org.opensearch.action.admin.indices.template.put;
            eq(componentTemplate),
        // Mock mapping transformer to return transformed mapping  
public class TransportPutComponentTemplateActionTests extends OpenSearchTestCase {
    private MappingTransformerRegistry mappingTransformerRegistry;  
 *
 */  
        // Verify that indexTemplateService.putComponentTemplate is called
    private ClusterState clusterState;  
            null, // ClusterService not needed for this test  
        ComponentTemplate componentTemplate = mock(ComponentTemplate.class);
    private ActionListener<AcknowledgedResponse> responseListener;
        verify(indexTemplateService, times(1)).putComponentTemplate(
        when(componentTemplate.template()).thenReturn(template);  
            threadPool,
        ArgumentCaptor<ActionListener<String>> listenerCaptor = ArgumentCaptor.forClass(ActionListener.class);
            eq(request.name()),
    public void setup() {
import org.opensearch.transport.TransportService;
    private MetadataIndexTemplateService indexTemplateService;
import org.mockito.Mock;
            eq(request.cause()),  
    @Mock
        // Simulate mapping transformation
            actionFilters,  
import java.io.IOException;
        // Arrange: Create a test request and mock dependencies
import org.mockito.ArgumentCaptor;  
        when(template.mappings()).thenReturn(new CompressedXContent("{\"properties\": {\"field\": {\"type\": \"text\"}}}"));
import static org.mockito.Mockito.times;  
    @Before
    }
import org.opensearch.cluster.metadata.Template;
import org.opensearch.core.action.ActionListener;  
import org.junit.Before;
        // Assert: Verify the transformed mappings are set correctly
        action = new TransportPutComponentTemplateAction(
        request.componentTemplate(componentTemplate);
/*  
    }
 * SPDX-License-Identifier: Apache-2.0
    @Mock
    @Mock
            eq(request.clusterManagerNodeTimeout()),  
            indexTemplateService,
    private TransportPutComponentTemplateAction action;
            transportService,
import org.opensearch.cluster.metadata.ComponentTemplate;
import static org.mockito.Mockito.doNothing;
import org.mockito.MockitoAnnotations;
        when(actionFilters.filters()).thenReturn(emptyActionFilters);  
}
    private ThreadPool threadPool;
 * The OpenSearch Contributors require contributions made to  
        doNothing().when(mappingTransformerRegistry).applyTransformers(anyString(), any(), listenerCaptor.capture());
        ActionFilter[] emptyActionFilters = new ActionFilter[] {};
        MockitoAnnotations.openMocks(this);  
    @Mock
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.threadpool.ThreadPool;  
        );
import static org.mockito.ArgumentMatchers.any;
            eq(request.create()),
import static org.mockito.Mockito.verify;
 * compatible open source license.
import static org.mockito.Mockito.when;
        // Act: Call the method
        );  
        listenerCaptor.getValue().onResponse(transformedMapping);
import org.opensearch.common.compress.CompressedXContent;
