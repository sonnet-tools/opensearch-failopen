    @Override
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
        }  
public class GetComponentTemplateResponseTests extends AbstractWireSerializingTestCase<GetComponentTemplateAction.Response> {
        return GetComponentTemplateAction.Response::new;
 * under the License.  
 */  
    @Override
    }  
    }  
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
        if (randomBoolean()) {
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action.admin.indices.template.get;
import java.util.HashMap;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.ComponentTemplateTests;
 */  
import java.util.Map;  
import org.opensearch.cluster.metadata.ComponentTemplate;
 */
        Map<String, ComponentTemplate> templates = new HashMap<>();
    }
/*  
 *
 * license agreements. See the NOTICE file distributed with
/*
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
 *
import java.io.IOException;  
        for (int i = 0; i < randomIntBetween(1, 4); i++) {
 * KIND, either express or implied.  See the License for the
    protected Writeable.Reader<GetComponentTemplateAction.Response> instanceReader() {
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.test.AbstractWireSerializingTestCase;
import java.util.Collections;
import org.opensearch.core.common.io.stream.Writeable;  
        return new GetComponentTemplateAction.Response(templates);
    protected GetComponentTemplateAction.Response createTestInstance() {  
 * this file be licensed under the Apache-2.0 license or a
        return randomValueOtherThan(instance, this::createTestInstance);
/*  
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
        }
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
            return new GetComponentTemplateAction.Response(Collections.emptyMap());
 * GitHub history for details.
    protected GetComponentTemplateAction.Response mutateInstance(GetComponentTemplateAction.Response instance) throws IOException {  
 * ownership. Elasticsearch licenses this file to you under  
 *  
            templates.put(randomAlphaOfLength(4), ComponentTemplateTests.randomInstance());  
 * compatible open source license.
