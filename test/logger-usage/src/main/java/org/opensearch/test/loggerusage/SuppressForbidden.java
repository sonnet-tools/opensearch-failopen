 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
/*  
 * ownership. Elasticsearch licenses this file to you under  
import java.lang.annotation.ElementType;
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 */  
 */  
public @interface SuppressForbidden {  
@Retention(RetentionPolicy.CLASS)
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 * Duplicated from core as main sources of logger-usage project have no dependencies on core
 * not use this file except in compliance with the License.
import java.lang.annotation.RetentionPolicy;  
 * KIND, either express or implied.  See the License for the
    String reason();
 * Annotation to suppress forbidden-apis errors inside a whole class, a method, or a field.
 */  
 *  
import java.lang.annotation.Target;
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
import java.lang.annotation.Retention;
 * under the License.  
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
}
 *
/*
 * specific language governing permissions and limitations
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
@Target({ ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE })
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.test.loggerusage;
/**  
 * license agreements. See the NOTICE file distributed with
