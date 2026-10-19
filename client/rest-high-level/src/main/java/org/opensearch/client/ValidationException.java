    }
    }  
        if (exception != null) {
import org.opensearch.common.Nullable;  
 * this work for additional information regarding copyright
     * @param errors the list of errors to add
    public final List<String> validationErrors() {
    private final List<String> validationErrors = new ArrayList<>();  
    public final void addValidationErrors(final @Nullable ValidationException exception) {  
    /**
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
            }
     * @param exception the {@link ValidationException} to add errors from
        ValidationException e = new ValidationException();
 */
     */
            sb.append(++index).append(": ").append(error).append(";");  
        }
import java.util.ArrayList;
    /**
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
/*  
        }
 */
/**  
 * the Apache License, Version 2.0 (the "License"); you may
            e.addValidationError(error);
    @Override  
public class ValidationException extends IllegalArgumentException {  
 */  
/*
    public void addValidationError(final String error) {  
 *
            for (String error : exception.validationErrors()) {
     * the accumulating validation errors  
 * software distributed under the License is distributed on an
        return e;  
        int index = 0;
package org.opensearch.client;
 * You may obtain a copy of the License at  
     * Adds validation errors from an existing {@link ValidationException} to
 * compatible open source license.
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
/*
     * @param error the errors to add
        validationErrors.add(error);
    public static ValidationException withError(String... error) {
        return validationErrors;  
    }
    public final String getMessage() {
 * GitHub history for details.
     * Returns the validation errors accumulated  
        sb.append("Validation Failed: ");  
     */  
 */
                addValidationError(error);  
 * under the License.  
     * Add a new validation error to the accumulating validation errors  
 * Unless required by applicable law or agreed to in writing,
    /**
    /**
 * Encapsulates an accumulation of validation errors
        StringBuilder sb = new StringBuilder();
     * @param error the error to add
     * Creates {@link ValidationException} instance initialized with given error messages.  
 * The OpenSearch Contributors require contributions made to  
    }  
 * SPDX-License-Identifier: Apache-2.0
     * @return {@link ValidationException} instance
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
     * @return {@link ValidationException} instance
    public static ValidationException withErrors(List<String> errors) {
import java.util.Arrays;  
    }
        return withErrors(Arrays.asList(error));
 * Licensed to Elasticsearch under one or more contributor  
     */
 *  
        }
 * KIND, either express or implied.  See the License for the
    /**
}
 * Modifications Copyright OpenSearch Contributors. See  
        for (String error : errors) {  
     * Creates {@link ValidationException} instance initialized with given error messages.  
        return sb.toString();
        for (String error : validationErrors) {
     */  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
