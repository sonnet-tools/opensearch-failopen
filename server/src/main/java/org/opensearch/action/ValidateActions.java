 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
public class ValidateActions {  
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
        }
            validationException = new ActionRequestValidationException();
 */
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.action;
/**
        return validationException;
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
/*  
 * this work for additional information regarding copyright
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * @opensearch.internal
 *
 */  
 * specific language governing permissions and limitations
 *
 *  
 * Validates transport actions
    public static ActionRequestValidationException addValidationError(String error, ActionRequestValidationException validationException) {
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
/*
}  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 * compatible open source license.
 *  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
        if (validationException == null) {  
        validationException.addValidationError(error);  
 * the Apache License, Version 2.0 (the "License"); you may
