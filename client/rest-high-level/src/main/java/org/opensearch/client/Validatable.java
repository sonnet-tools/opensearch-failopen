 * Defines a validation layer for Requests.  
     * Perform validation. This method does not have to be overridden in the event that no validation needs to be done,
 * KIND, either express or implied.  See the License for the
/*
    }
}
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 *  
    Validatable EMPTY = new Validatable() {
 * You may obtain a copy of the License at  
 *
 */
import java.util.Optional;  
 */  
 * compatible open source license.
        return Optional.empty();  
public interface Validatable {
 * this work for additional information regarding copyright
     * @return An {@link Optional} {@link ValidationException} that contains a list of validation errors.  
 * ownership. Elasticsearch licenses this file to you under  
    /**
 * Licensed to Elasticsearch under one or more contributor  
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
/**
/*  
 * Modifications Copyright OpenSearch Contributors. See  
 * GitHub history for details.
 * not use this file except in compliance with the License.
     */
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
     * assumed to contain validation errors and will be thrown.
 */
     *
    default Optional<ValidationException> validate() {
 * license agreements. See the NOTICE file distributed with
package org.opensearch.client;
    };
 */
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
     * or the validation was done during object construction time. A {@link ValidationException} that is not null is  
