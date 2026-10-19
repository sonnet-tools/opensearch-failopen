        }
        for (int i = 0; i < randomIntBetween(1, 4); i++) {
import java.util.Collections;
 * compatible open source license.
 *  
import org.opensearch.cluster.metadata.ComposableIndexTemplate;
}
 *
 * the Apache License, Version 2.0 (the "License"); you may
        if (randomBoolean()) {
            templates.put(randomAlphaOfLength(4), ComposableIndexTemplateTests.randomInstance());  
 *
            return new GetComposableIndexTemplateAction.Response(Collections.emptyMap());
import java.util.Map;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return GetComposableIndexTemplateAction.Response::new;
    }  
 * Modifications Copyright OpenSearch Contributors. See
import java.util.HashMap;
    }  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
 * GitHub history for details.
        return new GetComposableIndexTemplateAction.Response(templates);
        Map<String, ComposableIndexTemplate> templates = new HashMap<>();
/*  
import java.io.IOException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
    protected GetComposableIndexTemplateAction.Response mutateInstance(GetComposableIndexTemplateAction.Response instance)  
 * this file be licensed under the Apache-2.0 license or a
    @Override
import org.opensearch.core.common.io.stream.Writeable;  
/*  
 */  
import org.opensearch.cluster.metadata.ComposableIndexTemplateTests;
 * The OpenSearch Contributors require contributions made to  
 */
    protected Writeable.Reader<GetComposableIndexTemplateAction.Response> instanceReader() {
 */  
public class GetComposableIndexTemplateResponseTests extends AbstractWireSerializingTestCase<GetComposableIndexTemplateAction.Response> {
    @Override
 * under the License.  
    }  
    protected GetComposableIndexTemplateAction.Response createTestInstance() {  
        }  
package org.opensearch.action.admin.indices.template.get;
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
        throws IOException {
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
        return randomValueOtherThan(instance, this::createTestInstance);
/*
import org.opensearch.test.AbstractWireSerializingTestCase;
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
