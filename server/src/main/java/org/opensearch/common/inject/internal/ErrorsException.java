 * you may not use this file except in compliance with the License.  
 * should {@link Errors#merge(Errors) merge} the errors from this exception with their existing  
 * errors.
 *
 *
 * Modifications Copyright OpenSearch Contributors. See
    }
    public Errors getErrors() {  
 * See the License for the specific language governing permissions and
 * compatible open source license.
 *
 */  
 * Licensed under the Apache License, Version 2.0 (the "License");
    private final Errors errors;  
    public ErrorsException(Errors errors) {
 */  
 *
 * @opensearch.internal
 * Copyright (C) 2008 Google Inc.  
 * SPDX-License-Identifier: Apache-2.0
 * Indicates that a result could not be returned while preparing or resolving a binding. The caller
package org.opensearch.common.inject.internal;
/*
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at
 * distributed under the License is distributed on an "AS IS" BASIS,  
/**
 *
 */  
        return errors;
/*  
 * limitations under the License.  
}  
/*  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * GitHub history for details.
public class ErrorsException extends Exception {
        this.errors = errors;  
 * Unless required by applicable law or agreed to in writing, software
 * http://www.apache.org/licenses/LICENSE-2.0  
    }
 */
 * The OpenSearch Contributors require contributions made to  
 * @author jessewilson@google.com (Jesse Wilson)  
 *
