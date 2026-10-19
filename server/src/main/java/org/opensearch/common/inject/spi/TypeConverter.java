public interface TypeConverter {
 * @since 2.0
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
 * Converts constant string values to a different type.
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
@PublicApi(since = "1.0.0")  
 *  
 * you may not use this file except in compliance with the License.  
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.common.inject.TypeLiteral;
 *
 * http://www.apache.org/licenses/LICENSE-2.0  
 * @author crazybob@google.com (Bob Lee)
 *
 */  
 * compatible open source license.
    /**  
 * The OpenSearch Contributors require contributions made to  
 * Licensed under the Apache License, Version 2.0 (the "License");
 */  
 * this file be licensed under the Apache-2.0 license or a
/*  
     */
/*
 * Copyright (C) 2007 Google Inc.  
    Object convert(String value, TypeLiteral<?> toType);  
 * @opensearch.api
 */
 * distributed under the License is distributed on an "AS IS" BASIS,  
package org.opensearch.common.inject.spi;
 * limitations under the License.  
 * See the License for the specific language governing permissions and
 */
     * Converts a string value. Throws an exception if a conversion error occurs.
 *  
 * Unless required by applicable law or agreed to in writing, software
 *
/*  
/**
}
 * You may obtain a copy of the License at
 * GitHub history for details.
