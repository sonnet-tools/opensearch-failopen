 * GitHub history for details.
 */
 * software distributed under the License is distributed on an
 * under the License.  
    @Override
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
/*
import org.opensearch.test.AbstractWireSerializingTestCase;
/*  
    @Override  
    @Override
        return randomValueOtherThan(instance, this::createTestInstance);  
    DeleteComposableIndexTemplateAction.Request> {
 *  
/*  
 * the Apache License, Version 2.0 (the "License"); you may
        return DeleteComposableIndexTemplateAction.Request::new;
import java.io.IOException;
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
public class DeleteComposableIndexTemplateRequestTests extends AbstractWireSerializingTestCase<  
 *         http://www.apache.org/licenses/LICENSE-2.0
    protected DeleteComposableIndexTemplateAction.Request mutateInstance(DeleteComposableIndexTemplateAction.Request instance)
import org.opensearch.core.common.io.stream.Writeable;
    }
        return new DeleteComposableIndexTemplateAction.Request(randomAlphaOfLength(5));  
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    protected DeleteComposableIndexTemplateAction.Request createTestInstance() {
 * Unless required by applicable law or agreed to in writing,
 */  
 * Modifications Copyright OpenSearch Contributors. See
    protected Writeable.Reader<DeleteComposableIndexTemplateAction.Request> instanceReader() {  
 * The OpenSearch Contributors require contributions made to  
    }
package org.opensearch.action.admin.indices.template.delete;
 */  
        throws IOException {
}
 *
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    }
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
