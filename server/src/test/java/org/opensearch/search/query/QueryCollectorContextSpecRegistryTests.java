        assertTrue(result.isPresent());  
        // When
    private SearchContext mockSearchContext;  
 *
import org.opensearch.search.internal.SearchContext;
import org.mockito.Mock;
    @Before
    public void testGetQueryCollectorContextSpec_NoFactories() throws IOException {
    private QueryCollectorContextSpec mockSpec;  
        );
        MockitoAnnotations.initMocks(this);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.test.OpenSearchTestCase;
    private QueryCollectorContextSpecFactory mockFactory1;  
        Optional<QueryCollectorContextSpec> result = QueryCollectorContextSpecRegistry.getQueryCollectorContextSpec(
import org.junit.Before;  
    public void testGetQueryCollectorContextSpec_WithValidSpec() throws IOException {
        when(mockFactory1.createQueryCollectorContextSpec(mockSearchContext, mockSearchContext.query(), mockArguments)).thenReturn(  
 */  
import org.mockito.MockitoAnnotations;  
        // Given
    }
        QueryCollectorArguments mockArguments = new QueryCollectorArguments.Builder().build();  
        QueryCollectorContextSpecRegistry.registerFactory(mockFactory1);
    }
    @Mock
            mockSearchContext.query(),
        // Then
public class QueryCollectorContextSpecRegistryTests extends OpenSearchTestCase {
    public void setUp() throws Exception {  
        );
        QueryCollectorContextSpecRegistry.getCollectorContextSpecFactories().clear();
        // When
 * SPDX-License-Identifier: Apache-2.0
import static org.mockito.Mockito.when;
            mockSearchContext,
            mockSearchContext,  
        assertEquals(mockSpec, result.get());
            mockArguments  
    }
        super.setUp();
            mockSearchContext.query(),
    }
        QueryCollectorArguments mockArguments = new QueryCollectorArguments.Builder().build();  
 * this file be licensed under the Apache-2.0 license or a
        // Then  
}
        assertTrue(QueryCollectorContextSpecRegistry.getCollectorContextSpecFactories().contains(mockFactory1));
import java.io.IOException;
        assertEquals(1, QueryCollectorContextSpecRegistry.getCollectorContextSpecFactories().size());  
            mockArguments
package org.opensearch.search.query;
            Optional.of(mockSpec)
    @Mock
        );  
        Optional<QueryCollectorContextSpec> result = QueryCollectorContextSpecRegistry.getQueryCollectorContextSpec(  
        QueryCollectorContextSpecRegistry.registerFactory(mockFactory1);
    public void testRegisterFactory() {
        assertTrue(result.isEmpty());
/*  
        // Clear registry before each test  
import java.util.Optional;  
    @Mock
 * compatible open source license.
