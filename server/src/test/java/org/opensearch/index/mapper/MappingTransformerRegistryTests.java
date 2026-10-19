    }
        final MappingTransformerRegistry mappingTransformerRegistry = new MappingTransformerRegistry(
        final String expectedTransformedMappingString = "{\"field\":\"transformedValue\"}";
            ActionListener<Void> actionListener = invocation.getArgument(2);
import java.util.List;
    }  
        registry = new MappingTransformerRegistry(List.of(mapperPlugin), xContentRegistry);  
        mappingTransformerRegistry.applyTransformers(mapping, null, listener);
            mapping.put("field", "transformedValue"); // Simulating transformation
import org.opensearch.test.OpenSearchTestCase;
    @Mock  
    @Before
    public void testApplyTransformers_whenNoTransformers_returnMappingDirectly() {  
    }
import static org.mockito.Mockito.when;  
        verify(listener).onFailure(exceptionCaptor.capture());
import org.opensearch.core.action.ActionListener;
            actionListener.onResponse(null);  
public class MappingTransformerRegistryTests extends OpenSearchTestCase {
        // Mock dummy transformer behavior which does not modify the mapping
import java.util.Map;
import org.mockito.MockitoAnnotations;
            xContentRegistry
/*  
}
 * this file be licensed under the Apache-2.0 license or a
        ArgumentCaptor<Exception> exceptionCaptor = ArgumentCaptor.forClass(Exception.class);
import static org.mockito.Mockito.doAnswer;
        }).when(transformer).transform(any(), any(), any());
            return null;
            return null;
            assertEquals(mapping.get("field"), "value");  
        }).when(transformer).transform(any(), any(), any());  
        when(mapperPlugin.getMappingTransformers()).thenReturn(List.of(transformer));
        registry.applyTransformers(null, null, listener);
        assertTrue(exceptionCaptor.getValue() instanceof RuntimeException);
    private NamedXContentRegistry xContentRegistry;  
        verify(listener).onResponse(responseCaptor.capture());
    private MappingTransformerRegistry registry;  
            Map<String, Object> mapping = invocation.getArgument(0);
 * The OpenSearch Contributors require contributions made to  
    public void testApplyTransformers_WhenTransformerFails_ShouldCallOnFailure() {
        MockitoAnnotations.openMocks(this);
import org.opensearch.plugins.MapperPlugin;
    @Mock
import joptsimple.internal.Strings;
    private MapperPlugin mapperPlugin;
    private ActionListener<String> listener;
 * compatible open source license.
        registry.applyTransformers(inputMappingString, null, listener);
import org.opensearch.core.xcontent.NamedXContentRegistry;  
            final ActionListener<Void> actionListener = invocation.getArgument(2);  
        final String inputMappingString = "{\"field\": \"value\"}";
    }
 *
            actionListener.onResponse(null);
        final String mapping = Strings.EMPTY;
    private MappingTransformer transformer;
    @Mock
import static org.mockito.ArgumentMatchers.any;  
    public void testApplyTransformers_WithNullMapping_ShouldReturnNull() {  
import org.mockito.ArgumentCaptor;
        }).when(transformer).transform(any(), any(), any());  
        String transformedMapping = responseCaptor.getValue();  
        final String inputMappingString = "{\"field\": \"value\"}";
        doAnswer(invocation -> {
    }
        );
import org.mockito.Mock;
    public void setup() {  
        final String errorMsg = "Transformation failed";  
        verify(listener).onResponse(null);  
import org.mockito.Mockito;  
        verify(listener, Mockito.times(1)).onResponse(mapping);  
            return null;
 */  
        ArgumentCaptor<String> responseCaptor = ArgumentCaptor.forClass(String.class);  
        doAnswer(invocation -> {
    @Mock  
        registry.applyTransformers(inputMappingString, null, listener);
import org.junit.Before;  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;  
        assertEquals(expectedTransformedMappingString, transformedMapping);
import static org.mockito.Mockito.verify;
            ActionListener<Void> actionListener = invocation.getArgument(2);  
package org.opensearch.index.mapper;
            actionListener.onFailure(new RuntimeException(errorMsg));
import java.io.IOException;
    public void testApplyTransformers_WithTransformerApplied() throws IOException {  
        assertTrue(exceptionCaptor.getValue().getMessage().contains(errorMsg));
        doAnswer(invocation -> {
            Collections.emptyList(),  
