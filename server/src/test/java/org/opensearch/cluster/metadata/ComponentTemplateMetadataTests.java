 *  
    @Override  
        Map<String, ComponentTemplate> templates = new HashMap<>(instance.componentTemplates());  
        );
        int count = randomIntBetween(0, 3);
/*
 * The OpenSearch Contributors require contributions made to  
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
    protected ComponentTemplateMetadata createTestInstance() {  
}
 * this work for additional information regarding copyright
 * GitHub history for details.
import java.util.Map;
    protected Class<ComponentTemplateMetadata> categoryClass() {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    @Override  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
    @Override
    }
                new NamedWriteableRegistry.Entry(
 * You may obtain a copy of the License at  
        }
import java.util.Collections;
        if (randomBoolean()) {
                    ComponentTemplateMetadata::new
        return new NamedWriteableRegistry(
 * compatible open source license.
            templates.put(randomAlphaOfLength(4), newTemplate.getValue());
        return ComponentTemplateMetadata.class;  
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
            return randomValueOtherThan(instance, this::createTestInstance);
 * under the License.  
 * KIND, either express or implied.  See the License for the
public class ComponentTemplateMetadataTests extends AbstractNamedWriteableTestCase<ComponentTemplateMetadata> {  
 * Modifications Copyright OpenSearch Contributors. See
 *
    @Override
            // Not really much to mutate, so just generate a new one  
 * Licensed to Elasticsearch under one or more contributor  
    }
    protected ComponentTemplateMetadata mutateInstance(ComponentTemplateMetadata instance) throws IOException {
                    ComponentTemplateMetadata.TYPE,  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
            templateMap.put(randomAlphaOfLength(4), ComponentTemplateTests.randomInstance());
/*  
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
 */  
        for (int i = 0; i < count; i++) {  
import java.io.IOException;
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
            // Change the value  
package org.opensearch.cluster.metadata;
            )  
import org.opensearch.test.AbstractNamedWriteableTestCase;
 *     http://www.apache.org/licenses/LICENSE-2.0
        } else {
        return new ComponentTemplateMetadata(templates);  
        }
import java.util.HashMap;  
 *
 */
                    ComponentTemplateMetadata.class,
        return new ComponentTemplateMetadata(templateMap);  
        if (instance.componentTemplates().size() == 0) {
            templates.put(newTemplate.getKey(), ComponentTemplateTests.mutateTemplate(newTemplate.getValue()));
            // Change the key  
                )
        }
    }
            Collections.singletonList(  
        Map<String, ComponentTemplate> templateMap = new HashMap<>(count);
        Map.Entry<String, ComponentTemplate> newTemplate = instance.componentTemplates().entrySet().iterator().next();
/*  
 * ownership. Elasticsearch licenses this file to you under  
