 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
            final ActionRequestValidationException validate = request.validate();
import org.opensearch.action.ActionRequestValidationException;  
            final DeleteRequest request = new DeleteRequest("index4", null);  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
 * under the License.  
 *
            final DeleteRequest request = new DeleteRequest("index4", "0");
        {
 * GitHub history for details.
            assertThat(validate.validationErrors(), hasItems("id is missing"));
 * software distributed under the License is distributed on an
            final ActionRequestValidationException validate = request.validate();  
        }
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.test.OpenSearchTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 */  
import static org.hamcrest.CoreMatchers.not;
/*  
import static org.hamcrest.CoreMatchers.hasItems;  
 *  
            assertThat(validate, not(nullValue()));  
 * KIND, either express or implied.  See the License for the
}
 */
            assertThat(validate, nullValue());
 * license agreements. See the NOTICE file distributed with
    }  
package org.opensearch.action.delete;
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See  
import static org.hamcrest.CoreMatchers.nullValue;
 * You may obtain a copy of the License at  
public class DeleteRequestTests extends OpenSearchTestCase {
 */
        }  
/*
        {
/*
    public void testValidation() {  
