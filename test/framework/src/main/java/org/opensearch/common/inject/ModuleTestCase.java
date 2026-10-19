        assertInstanceBindingWithAnnotation(module, to, tester, null);
 */  
    }
            }  
 * software distributed under the License is distributed on an
 *  
                        assertTrue(tester.test(to.cast(binding.getInstance())));
        }
                ProviderInstanceBinding<?> binding = (ProviderInstanceBinding<?>) element;
 */  
                    assertTrue(tester.test(to.cast(binding.getProviderInstance().get())));  
import org.opensearch.common.inject.spi.InstanceBinding;
     */
                InstanceBinding<?> binding = (InstanceBinding<?>) element;
     * Configures the module, and ensures an instance is bound to the "to" class, and the  
 */
 *
/*
        List<Element> elements = Elements.getElements(module);
}
import java.lang.annotation.Annotation;  
        StringBuilder s = new StringBuilder();
        for (Element element : elements) {  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.common.inject.spi.ProviderInstanceBinding;  
    /**
/**
 * You may obtain a copy of the License at  
                        return;  
    public <T> void assertInstanceBinding(Module module, Class<T> to, Predicate<T> tester) {  
import java.util.function.Predicate;
    /**
    private <T> void assertInstanceBindingWithAnnotation(
            s.append(element).append("\n");
            if (element instanceof InstanceBinding) {
 * not use this file except in compliance with the License.
        Class<T> to,
    }
                if (to.equals(binding.getKey().getTypeLiteral().getType())) {  
     */
 * KIND, either express or implied.  See the License for the
                }
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
     * Like {@link #assertInstanceBinding(Module, Class, Predicate)}, but filters the
package org.opensearch.common.inject;
            } else if (element instanceof ProviderInstanceBinding) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        Predicate<T> tester,
                    return;
 */
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 * GitHub history for details.
        for (Element element : elements) {  
import org.opensearch.test.OpenSearchTestCase;
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
        Class<? extends Annotation> annotation  
import org.opensearch.common.inject.spi.Elements;
 * Modifications Copyright OpenSearch Contributors. See  
 * Base testcase for testing {@link Module} implementations.
 * license agreements. See the NOTICE file distributed with
        Module module,  
     * provided tester returns true on the instance.
     * classes checked by the given annotation.  
    ) {
                }
                    }
                if (to.equals(binding.getKey().getTypeLiteral().getType())) {
        }
 * under the License.  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
/*
import org.opensearch.common.inject.spi.Element;  
        fail("Did not find any instance binding to " + to.getName() + ". Found these bindings:\n" + s);  
 *
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
                    if (annotation == null || annotation.equals(binding.getKey().getAnnotationType())) {
public abstract class ModuleTestCase extends OpenSearchTestCase {
