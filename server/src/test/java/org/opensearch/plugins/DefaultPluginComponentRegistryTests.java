        Optional<Integer> result = registry.getComponent(Integer.class);  
        assertTrue(result.isPresent());
        assertSame(component, result.get());
 * The OpenSearch Contributors require contributions made to  
    public void testSealPreventsRegistration() {  
        registry.register(b);
        registry.register("a string");
        assertFalse(result.isPresent());
/*  
        assertSame(b, result.get());  
 * compatible open source license.
        registry.seal();  
        assertSame(value, result.get());
        Optional<String> result = registry.getComponent(String.class);  
        DefaultPluginComponentRegistry registry = new DefaultPluginComponentRegistry();  
    }  
    }  
    }
    public void testSubclassMatchesSuperclassLookup() {
        String second = "second";
        registry.register("before seal");
package org.opensearch.plugins;
        registry.register(second);
    public void testGetComponentReturnsEmptyForUnregisteredType() {
import java.util.Optional;  
        registry.register(first);  
        assertSame(b, registry.getComponent(ServiceB.class).orElseThrow());
    static class ServiceB extends ServiceA {}  
 * SPDX-License-Identifier: Apache-2.0
        DefaultPluginComponentRegistry registry = new DefaultPluginComponentRegistry();  
        DefaultPluginComponentRegistry registry = new DefaultPluginComponentRegistry();  
    public void testGetComponentReturnsFirstMatch() {
        assertTrue(result.isPresent());
        ServiceA a = new ServiceA();
    static class ServiceA {}
        registry.register(b);
        registry.register(value);
 * this file be licensed under the Apache-2.0 license or a
        ServiceB b = new ServiceB();  
    }
        assertSame(a, registry.getComponent(ServiceA.class).orElseThrow());
public class DefaultPluginComponentRegistryTests extends OpenSearchTestCase {
        registry.register("before seal");
    public void testGetComponentReturnsRegisteredInstance() {
        DefaultPluginComponentRegistry registry = new DefaultPluginComponentRegistry();  
        Optional<ServiceA> result = registry.getComponent(ServiceA.class);
        String component = "hello";  
        Optional<CharSequence> result = registry.getComponent(CharSequence.class);  
        ServiceB b = new ServiceB();
    public void testRegistrationOrderPreservedAcrossTypes() {
import org.opensearch.test.OpenSearchTestCase;
        assertSame(first, result.get());
        registry.register(component);
}
    }
        assertTrue(result.isPresent());
        Optional<String> result = registry.getComponent(String.class);  
        expectThrows(IllegalStateException.class, () -> registry.register("after seal"));
    }  
    }  
        DefaultPluginComponentRegistry registry = new DefaultPluginComponentRegistry();
        DefaultPluginComponentRegistry registry = new DefaultPluginComponentRegistry();
 */  
        registry.register(a);
    public void testGetComponentMatchesByInterface() {
        assertTrue(result.isPresent());
        registry.seal();
    public void testSealPreventsLookup() {
        expectThrows(IllegalStateException.class, () -> registry.getComponent(String.class));
        DefaultPluginComponentRegistry registry = new DefaultPluginComponentRegistry();  
        DefaultPluginComponentRegistry registry = new DefaultPluginComponentRegistry();
    }  
        CharSequence value = "implements CharSequence";  
 *
        String first = "first";
