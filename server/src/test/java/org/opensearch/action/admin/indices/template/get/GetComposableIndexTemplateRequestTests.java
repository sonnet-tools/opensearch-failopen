 */  
 */
        return new GetComposableIndexTemplateAction.Request(randomBoolean() ? null : randomAlphaOfLength(4));
 *
}
 * compatible open source license.
import org.opensearch.test.AbstractWireSerializingTestCase;
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
/*  
    @Override
 * SPDX-License-Identifier: Apache-2.0
    protected Writeable.Reader<GetComposableIndexTemplateAction.Request> instanceReader() {
 *  
    protected GetComposableIndexTemplateAction.Request createTestInstance() {
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
        throws IOException {
 */  
 * license agreements. See the NOTICE file distributed with
    }  
/*  
 *
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
    @Override
        return GetComposableIndexTemplateAction.Request::new;  
    @Override  
    protected GetComposableIndexTemplateAction.Request mutateInstance(GetComposableIndexTemplateAction.Request instance)  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
    }  
/*
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
        return randomValueOtherThan(instance, this::createTestInstance);
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.action.admin.indices.template.get;
public class GetComposableIndexTemplateRequestTests extends AbstractWireSerializingTestCase<GetComposableIndexTemplateAction.Request> {  
import org.opensearch.core.common.io.stream.Writeable;
 *         http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
