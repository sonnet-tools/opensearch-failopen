 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
     *
@Target({ ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE })
 * the Apache License, Version 2.0 (the "License"); you may
import java.lang.annotation.Retention;
 * GitHub history for details.
}  
/*
package org.opensearch.tools.java_version_checker;
 */  
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
     */
 * Modifications Copyright OpenSearch Contributors. See
import java.lang.annotation.Target;
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
/*  
 * software distributed under the License is distributed on an
import java.lang.annotation.RetentionPolicy;  
/*  
    String reason();
 */
@Retention(RetentionPolicy.CLASS)  
     * @return The reason the error is being suppressed.  
 * specific language governing permissions and limitations
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 *
     * The argument to this annotation, specifying the reason a forbidden API is being used.
import java.lang.annotation.ElementType;
 * Annotation to suppress forbidden-apis errors inside a whole class, a method, or a field.
 * KIND, either express or implied.  See the License for the
 * under the License.  
 */
 *
public @interface SuppressForbidden {
 * The OpenSearch Contributors require contributions made to  
 */  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
