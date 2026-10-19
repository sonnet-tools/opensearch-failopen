        validationErrors.add(error);  
    }
 * GitHub history for details.
public class ValidationException extends IllegalArgumentException {  
    public final String getMessage() {  
package org.opensearch.common;
    }
     * Add a new validation error to the accumulating validation errors
    public final void addValidationError(String error) {
 * @opensearch.internal
 *     http://www.apache.org/licenses/LICENSE-2.0
     * Add a sequence of validation errors to the accumulating validation errors
        super("validation failed");
            validationErrors.add(error);  
 *
}  
        return sb.toString();
    }
/*  
        }
     * Returns the validation errors accumulated
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
    }  
        for (String error : errors) {
 * compatible open source license.
     */  
        sb.append("Validation Failed: ");
 */  
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
     */
        StringBuilder sb = new StringBuilder();
        return validationErrors;
        for (String error : validationErrors) {
        int index = 0;  
     */  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final List<String> validationErrors = new ArrayList<>();
 */  
import java.util.List;
import java.util.ArrayList;
 * You may obtain a copy of the License at  
            sb.append(++index).append(": ").append(error).append(";");
    }
/**
     * @param error the error to add  
 * The OpenSearch Contributors require contributions made to  
        }  
 * Licensed to Elasticsearch under one or more contributor  
    /**  
 * software distributed under the License is distributed on an
/*  
 * SPDX-License-Identifier: Apache-2.0
 *  
 * license agreements. See the NOTICE file distributed with
 */
    public final List<String> validationErrors() {
/*
    public final void addValidationErrors(Iterable<String> errors) {
 */
    /**
     * @param errors the errors to add
 *  
    public ValidationException() {  
 * under the License.  
    /**
    @Override
 *
 * ownership. Elasticsearch licenses this file to you under  
 * Encapsulates an accumulation of validation errors
 * the Apache License, Version 2.0 (the "License"); you may
