 * Copyright (C) 2008 Google Inc.  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * limitations under the License.  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
/*
 */
}
     * Ensures the reference is initialized, then returns it.
 * compatible open source license.
 *
 * distributed under the License is distributed on an "AS IS" BASIS,  
 */  
 *
 * The OpenSearch Contributors require contributions made to  
 *
 *
/**
 * @author jessewilson@google.com (Jesse Wilson)
 * GitHub history for details.
/*  
 *  
/*  
 */  
 * SPDX-License-Identifier: Apache-2.0
     */  
 */
package org.opensearch.common.inject;
import org.opensearch.common.inject.internal.Errors;
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
 * you may not use this file except in compliance with the License.  
 * @opensearch.internal  
 *
 * Holds a reference that requires initialization to be performed before it can be used.
import org.opensearch.common.inject.internal.ErrorsException;
 * See the License for the specific language governing permissions and
 * http://www.apache.org/licenses/LICENSE-2.0  
    /**
 * Unless required by applicable law or agreed to in writing, software
 * You may obtain a copy of the License at
interface Initializable<T> {
    T get(Errors errors) throws ErrorsException;
