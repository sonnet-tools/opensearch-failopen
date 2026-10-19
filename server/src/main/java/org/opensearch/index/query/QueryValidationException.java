 *
        return validationException;  
     * @param validationError the error message to add to an initial exception
    ) {
 * GitHub history for details.
}
 *
     * @return a {@link QueryValidationException} with added validation error message
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */  
 *
 *  
 * under the License.  
public class QueryValidationException extends ValidationException {
 */
     * When passing {@code null} as the initial exception, a new exception is created.
    }
 * Unless required by applicable law or agreed to in writing,
/**
            validationException = new QueryValidationException();  
 * compatible open source license.
        }
        validationException.addValidationError("[" + queryId + "] " + validationError);
        if (validationException == null) {
/*
     * @param validationErrors the error messages to add to an initial exception  
 * KIND, either express or implied.  See the License for the
    public static QueryValidationException addValidationError(  
        List<String> validationErrors,
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
     * @return a {@link QueryValidationException} with added validation error message
import org.opensearch.common.ValidationException;
        return validationException;  
 * the Apache License, Version 2.0 (the "License"); you may
 * This exception can be used to indicate various reasons why validation of a query has failed.  
/*  
        if (validationException == null) {
     * @param queryId the query that caused the error
     * @param validationException an initial exception. Can be {@code null}, in which case a new exception is created.
 * this work for additional information regarding copyright
 * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
        validationException.addValidationErrors(validationErrors);
        }
 * software distributed under the License is distributed on an
     *  
    }
 * The OpenSearch Contributors require contributions made to  
/*  
 * this file be licensed under the Apache-2.0 license or a
 */  
package org.opensearch.index.query;
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
            validationException = new QueryValidationException();  
     * Helper method than can be used to add error messages to an existing {@link QueryValidationException}.
 */  
        String validationError,
 */  
    public static QueryValidationException addValidationErrors(
    /**  
import java.util.List;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
        QueryValidationException validationException  
    ) {
     * When passing {@code null} as the initial exception, a new exception is created.
        QueryValidationException validationException  
 * specific language governing permissions and limitations
        String queryId,
     * @param validationException an initial exception. Can be {@code null}, in which case a new exception is created.  
 * license agreements. See the NOTICE file distributed with
     * Helper method than can be used to add error messages to an existing {@link QueryValidationException}.
     */
