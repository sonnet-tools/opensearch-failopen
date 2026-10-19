        ActionRequestValidationException e = req.validate();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
        assertThat(e.validationErrors().get(0), containsString("name is missing"));
 * specific language governing permissions and limitations
    public void testValidateRequestWithoutName() {
public class CreateDataStreamRequestTests extends AbstractWireSerializingTestCase<Request> {
    @Override
import static org.hamcrest.Matchers.equalTo;  
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.ActionRequestValidationException;  
/*
    public void testValidateRequest() {
 */
        assertThat(e.validationErrors().size(), equalTo(1));  
 * GitHub history for details.
 * under the License.  
/*
 * software distributed under the License is distributed on an
        ActionRequestValidationException e = req.validate();
    @Override  
 * Modifications Copyright OpenSearch Contributors. See  
 * compatible open source license.
    }  
        CreateDataStreamAction.Request req = new CreateDataStreamAction.Request("my-data-stream");  
 *  
 * license agreements. See the NOTICE file distributed with
        assertNull(e);
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.containsString;
 * SPDX-License-Identifier: Apache-2.0
}
    }
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
    protected Writeable.Reader<Request> instanceReader() {
        return Request::new;  
/*  
import org.opensearch.action.admin.indices.datastream.CreateDataStreamAction.Request;
 *
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
    protected Request createTestInstance() {
    }  
package org.opensearch.action.admin.indices.datastream;
 */  
        assertNotNull(e);
 * the Apache License, Version 2.0 (the "License"); you may
        CreateDataStreamAction.Request req = new CreateDataStreamAction.Request("");  
        return new Request(randomAlphaOfLength(8));
 *
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.test.AbstractWireSerializingTestCase;  
import org.opensearch.core.common.io.stream.Writeable;
 */
