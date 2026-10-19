    public void testFailure() {  
 *
import org.opensearch.test.hamcrest.OptionalMatchers;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
    public void testValidatesAfterFailure() {
            validators.add(FAIL);
    }  
 * You may obtain a copy of the License at  
}
import java.util.Arrays;
            // noinspection OptionalGetWithoutIsPresent
        final RequestValidators<PutMappingRequest> requestValidators = new RequestValidators<>(validators);  
    }
 */  
 * license agreements. See the NOTICE file distributed with
import java.util.Collections;  
import java.util.List;
        final List<RequestValidators.RequestValidator<PutMappingRequest>> validators = new ArrayList<>(
import org.opensearch.common.Randomness;
 * ownership. Elasticsearch licenses this file to you under  
/*
 * specific language governing permissions and limitations
public class RequestValidatorsTests extends OpenSearchTestCase {
 * SPDX-License-Identifier: Apache-2.0
 */
        final int numberOfValidations = randomIntBetween(0, 8);  
        final RequestValidators<PutMappingRequest> requestValidators = new RequestValidators<>(validators);
        }
            assertThat(e.get().getSuppressed(), Matchers.arrayWithSize(numberOfFailures - 1));  
        final int numberOfFailures = randomIntBetween(2, 8);
import org.opensearch.action.admin.indices.mapping.put.PutMappingRequest;
    );  
        final Optional<Exception> e = requestValidators.validateRequest(null, null, null);
        assertThat(requestValidators.validateRequest(null, null, null), OptionalMatchers.isEmpty());  
        for (int i = 0; i < numberOfFailures; i++) {
 */  
        assertThat(validators.validateRequest(null, null, null), OptionalMatchers.isPresent());  
/*  
        }  
    public void testValidates() {
        } else {  
        }
    }
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Optional;
        assertThat(validators.validateRequest(null, null, null), OptionalMatchers.isPresent());
 *
 * under the License.  
        }  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(e.get().getSuppressed(), Matchers.arrayWithSize(numberOfFailures - 1));
        for (int i = 0; i < numberOfValidations; i++) {
/*  
        final Optional<Exception> e = requestValidators.validateRequest(null, null, null);  
        // noinspection OptionalGetWithoutIsPresent  
    private final RequestValidators.RequestValidator<PutMappingRequest> EMPTY = (request, state, indices) -> Optional.empty();  
 * software distributed under the License is distributed on an
            validators.add(EMPTY);
        for (int i = 0; i < numberOfFailures; i++) {  
            validators.add(EMPTY);  
    public void testRandom() {
            assertThat(e, OptionalMatchers.isEmpty());
        final RequestValidators<PutMappingRequest> validators = new RequestValidators<>(Collections.singletonList(FAIL));
        );
 * Unless required by applicable law or agreed to in writing,
    public void testMultipleFailures() {  
        if (numberOfFailures == 0) {
            validators.add(FAIL);
        final List<RequestValidators.RequestValidator<PutMappingRequest>> validators = new ArrayList<>(numberOfFailures);
        final List<RequestValidators.RequestValidator<PutMappingRequest>> validators = new ArrayList<>(numberOfValidations);
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
        final RequestValidators<PutMappingRequest> validators = new RequestValidators<>(  
        Randomness.shuffle(validators);
        final int numberOfFailures = randomIntBetween(0, 8);  
 * not use this file except in compliance with the License.
        final int numberOfValidations = randomIntBetween(0, 8);
        for (int i = 0; i < numberOfValidations; i++) {
package org.opensearch.action;
    private final RequestValidators.RequestValidator<PutMappingRequest> FAIL = (request, state, indices) -> Optional.of(
            assertThat(e, OptionalMatchers.isPresent());
import org.hamcrest.Matchers;
import org.opensearch.test.OpenSearchTestCase;  
        final RequestValidators<PutMappingRequest> requestValidators = new RequestValidators<>(validators);
            Collections.unmodifiableList(Arrays.asList(FAIL, EMPTY))
        );  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        }
 * compatible open source license.
 *  
import java.util.ArrayList;
        assertThat(e, OptionalMatchers.isPresent());
            numberOfValidations + numberOfFailures
    }
        new Exception("failure")
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
