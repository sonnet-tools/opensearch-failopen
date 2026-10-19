public class ComposableIndexTemplateMetadataTests extends AbstractNamedWriteableTestCase<ComposableIndexTemplateMetadata> {  
 * Licensed to Elasticsearch under one or more contributor  
            Collections.singletonList(  
import java.util.HashMap;  
import java.io.IOException;
 */
        if (randomBoolean()) {  
                    ComposableIndexTemplateMetadata.class,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
    }
    }
 */  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
}
    @Override  
/*  
        }  
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
    @Override
        return randomValueOtherThan(instance, this::createTestInstance);  
    }
            templates.put(randomAlphaOfLength(5), ComposableIndexTemplateTests.randomInstance());
                )
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
        return new ComposableIndexTemplateMetadata(templates);
    @Override
                new NamedWriteableRegistry.Entry(
        return new NamedWriteableRegistry(
                    ComposableIndexTemplateMetadata.TYPE,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
 * under the License.  
 * this work for additional information regarding copyright
    protected NamedWriteableRegistry getNamedWriteableRegistry() {
        Map<String, ComposableIndexTemplate> templates = new HashMap<>();  
        );
 *  
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
 * ownership. Elasticsearch licenses this file to you under  
 */  
                    ComposableIndexTemplateMetadata::new
            return new ComposableIndexTemplateMetadata(Collections.emptyMap());
package org.opensearch.cluster.metadata;
 * SPDX-License-Identifier: Apache-2.0
 *
 * specific language governing permissions and limitations
/*  
 * You may obtain a copy of the License at  
    @Override
    protected ComposableIndexTemplateMetadata createTestInstance() {
import org.opensearch.test.AbstractNamedWriteableTestCase;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Collections;
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
    protected Class<ComposableIndexTemplateMetadata> categoryClass() {
 * license agreements. See the NOTICE file distributed with
        }
/*
            )  
import java.util.Map;
    protected ComposableIndexTemplateMetadata mutateInstance(ComposableIndexTemplateMetadata instance) throws IOException {
 * Unless required by applicable law or agreed to in writing,
 *
 * software distributed under the License is distributed on an
        return ComposableIndexTemplateMetadata.class;  
