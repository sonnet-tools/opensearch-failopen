/*
import java.lang.annotation.Target;
 * SPDX-License-Identifier: Apache-2.0
@Retention(RetentionPolicy.CLASS)  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
@interface SuppressForbidden {
 * Modifications Copyright OpenSearch Contributors. See
}
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
 */
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
@Target({ ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE })
 * software distributed under the License is distributed on an
    String reason();  
 *
 * ownership. Elasticsearch licenses this file to you under  
 * under the License.  
 * GitHub history for details.
 */  
import java.lang.annotation.RetentionPolicy;  
 *
 * Annotation to suppress forbidden-apis errors inside a whole class, a method, or a field.
/*  
 * license agreements. See the NOTICE file distributed with
 *  
 */  
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.lang.annotation.Retention;
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
 */
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
import java.lang.annotation.ElementType;
/*  
/**  
package org.opensearch.secure_sm;
