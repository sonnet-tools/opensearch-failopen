import org.opensearch.rule.storage.AttributeValueStoreFactory;
/*  
        when(attr1.findAttributeMatches(extractor1, store1)).thenReturn(Collections.emptyList());  
}  
        );  
        Optional<String> result = resolver.resolve();
        when(attr1.findAttributeMatches(extractor1, store1)).thenReturn(  
    public void testResolveTieBreaking() {  
import org.opensearch.rule.MatchLabel;
        when(attr2.findAttributeMatches(extractor2, store2)).thenReturn(
            Arrays.asList(new MatchLabel<>("a", 0.9f), new MatchLabel<>("b", 0.8f))
import java.util.Optional;
        store2 = mock(AttributeValueStore.class);  
        attr1 = mock(Attribute.class);  
    private Attribute attr1;
        Optional<String> result = resolver.resolve();  
        when(attr1.findAttributeMatches(extractor1, store1)).thenReturn(
    private AttributeExtractor<String> extractor2;
        assertTrue(result.isPresent());
public class FeatureValueResolverTests extends OpenSearchTestCase {
    public void setUp() throws Exception {
        when(storeFactory.getAttributeValueStore(attr2)).thenReturn(store2);  
import static org.mockito.Mockito.mock;  
import org.opensearch.rule.storage.AttributeValueStore;
        );  
            Arrays.asList(new MatchLabel<>("b", 0.95f), new MatchLabel<>("a", 0.9f))
    }  
        assertEquals("a", result.get());
        FeatureValueResolver resolver = new FeatureValueResolver(storeFactory, Collections.singletonList(extractor1));
    }  
        );
        FeatureValueResolver resolver = new FeatureValueResolver(storeFactory, Arrays.asList(extractor1, extractor2));  
            Arrays.asList(new MatchLabel<>("a", 0.95f), new MatchLabel<>("b", 0.95f))
        when(storeFactory.getAttributeValueStore(attr1)).thenReturn(store1);
        when(attr2.findAttributeMatches(extractor2, store2)).thenReturn(  
        FeatureValueResolver resolver = new FeatureValueResolver(storeFactory, Arrays.asList(extractor1, extractor2));
        assertFalse(result.isPresent());
        attr2 = mock(Attribute.class);
        when(attr1.findAttributeMatches(extractor1, store1)).thenReturn(Arrays.asList(new MatchLabel<>("a", 0.9f)));  
        Optional<String> result = resolver.resolve();  
    }  
    public void testResolveTieBreakingWithoutResult() {
        Optional<String> result = resolver.resolve();  
import java.util.Collections;  
    private AttributeExtractor<String> extractor1;  
        assertTrue(result.isPresent());
        FeatureValueResolver resolver = new FeatureValueResolver(storeFactory, Collections.singletonList(extractor1));
        FeatureValueResolver resolver = new FeatureValueResolver(storeFactory, Arrays.asList(extractor1, extractor2));
import org.opensearch.rule.autotagging.Attribute;  
        FeatureValueResolver resolver = new FeatureValueResolver(storeFactory, Arrays.asList(extractor1, extractor2));
        store1 = mock(AttributeValueStore.class);
package org.opensearch.rule.labelresolver;
        storeFactory = mock(AttributeValueStoreFactory.class);
        when(attr2.findAttributeMatches(extractor2, store2)).thenReturn(Arrays.asList(new MatchLabel<>("b", 0.8f)));
        when(extractor2.getAttribute()).thenReturn(attr2);
@SuppressWarnings("unchecked")  
    private AttributeValueStoreFactory storeFactory;  
        super.setUp();  
 * this file be licensed under the Apache-2.0 license or a
        when(extractor1.getAttribute()).thenReturn(attr1);  
        );  
    }
        );  
    public void testResolveEmptyFeatureValues() {
    private Attribute attr2;  
        extractor1 = mock(AttributeExtractor.class);
        );
    public void testResolveEmptyIntersection() {
        extractor2 = mock(AttributeExtractor.class);
    public void testResolveSingleIntersection() {  
        assertTrue(result.isPresent());
        Optional<String> result = resolver.resolve();  
        assertEquals("b", result.get());
import org.opensearch.rule.attribute_extractor.AttributeExtractor;
import java.util.Arrays;
            Arrays.asList(new MatchLabel<>("a", 0.9f), new MatchLabel<>("b", 0.9f), new MatchLabel<>("c", 0.7f))
    }
    private AttributeValueStore<String, String> store2;
 *
            Arrays.asList(new MatchLabel<>("a", 0.95f), new MatchLabel<>("c", 0.7f))
        assertFalse(result.isPresent());
    }
            Arrays.asList(new MatchLabel<>("a", 0.9f), new MatchLabel<>("b", 0.9f), new MatchLabel<>("c", 0.7f))
    private AttributeValueStore<String, String> store1;
import org.opensearch.test.OpenSearchTestCase;  
 * compatible open source license.
        when(attr2.findAttributeMatches(extractor2, store2)).thenReturn(
        when(attr1.findAttributeMatches(extractor1, store1)).thenReturn(Arrays.asList(new MatchLabel<>("x", 1.0f)));  
        when(attr1.findAttributeMatches(extractor1, store1)).thenReturn(
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(result.isPresent());  
    public void testResolveSingleExtractor() {
        Optional<String> result = resolver.resolve();
 */  
    }  
import static org.mockito.Mockito.when;
 * The OpenSearch Contributors require contributions made to  
        assertEquals("x", result.get());
