}
 * specific language governing permissions and limitations
/*  
            final GetRequest request = new GetRequest("index4", "0");
            final ActionRequestValidationException validate = request.validate();  
            assertEquals(1, validate.validationErrors().size());
 * Modifications Copyright OpenSearch Contributors. See  
            assertThat(validate, nullValue());
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
            final ActionRequestValidationException validate = request.validate();
package org.opensearch.action.get;
 * under the License.  
            assertThat(validate, not(nullValue()));  
 * Licensed to Elasticsearch under one or more contributor  
 */  
    public void testValidation() {  
 */
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
            assertThat(validate.validationErrors(), hasItems("id is missing"));
public class GetRequestTests extends OpenSearchTestCase {
 *
/*
        }  
 * this work for additional information regarding copyright
        }  
import static org.hamcrest.CoreMatchers.not;
import org.opensearch.test.OpenSearchTestCase;
            final GetRequest request = new GetRequest("index4", randomBoolean() ? "" : null);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.hamcrest.CoreMatchers.hasItems;  
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
 *  
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 */
 * software distributed under the License is distributed on an
        {
import static org.hamcrest.CoreMatchers.nullValue;
import org.opensearch.action.ActionRequestValidationException;  
/*
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
    }
        {
