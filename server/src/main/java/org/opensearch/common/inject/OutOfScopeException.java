/**
 * Copyright (C) 2007 Google Inc.  
 *
 *
 * @author kevinb@google.com (Kevin Bourrillion)
 *
 * distributed under the License is distributed on an "AS IS" BASIS,  
    }  
    public OutOfScopeException(Throwable cause) {
 */  
 */  
 * compatible open source license.
 *
package org.opensearch.common.inject;
 * See the License for the specific language governing permissions and
        super(message);
 * Modifications Copyright OpenSearch Contributors. See
        super(message, cause);
public final class OutOfScopeException extends RuntimeException {
 * GitHub history for details.
/*  
    }
    public OutOfScopeException(String message, Throwable cause) {
 * @since 2.0  
    }
 * limitations under the License.  
 */  
    public OutOfScopeException(String message) {  
 * you may not use this file except in compliance with the License.  
 *
 */
        super(cause);  
/*
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
 * Thrown from {@link Provider#get} when an attempt is made to access a scoped
}
 * http://www.apache.org/licenses/LICENSE-2.0  
/*  
 * You may obtain a copy of the License at
 *
 * @opensearch.internal
 * Licensed under the Apache License, Version 2.0 (the "License");
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * Unless required by applicable law or agreed to in writing, software
 * object while the scope in question is not currently active.  
