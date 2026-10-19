package org.opensearch.client;
    }
 * compatible open source license.
        assertThat(e.validationErrors(), hasSize(2));  
    private static final String OTHER_ERROR = "some-other-error";
    public void testAddValidationError() {
        assertThat(e.validationErrors(), contains(ERROR, OTHER_ERROR));
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
        e.addValidationError(ERROR);
 */  
        ValidationException e = new ValidationException();
import static org.hamcrest.Matchers.contains;
/*  
        assertThat(e.validationErrors(), hasSize(1));
    }
        assertThat(e.validationErrors(), hasSize(2));
import org.opensearch.test.OpenSearchTestCase;
        ValidationException e = ValidationException.withError(ERROR, OTHER_ERROR);
        assertThat(e.validationErrors(), contains(ERROR));  
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
 *
    public void testWithErrors() {
        assertThat(e.validationErrors(), contains(ERROR, OTHER_ERROR));  
public class ValidationExceptionTests extends OpenSearchTestCase {
    }
    private static final String ERROR = "some-error";
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testWithError() {
 * GitHub history for details.
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(e.validationErrors(), hasSize(0));  
/*
 */
 */  
 * You may obtain a copy of the License at  
/*  
        ValidationException e = ValidationException.withErrors(Arrays.asList(ERROR, OTHER_ERROR));
import java.util.Arrays;  
        assertThat(e.validationErrors(), contains(ERROR, OTHER_ERROR));
 * specific language governing permissions and limitations
 *
 *  
import static org.hamcrest.Matchers.hasSize;  
 * software distributed under the License is distributed on an
        assertThat(e.validationErrors(), hasSize(2));  
 * ownership. Elasticsearch licenses this file to you under  
        e.addValidationError(OTHER_ERROR);
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
