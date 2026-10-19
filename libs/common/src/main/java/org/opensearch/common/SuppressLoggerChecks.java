 * compatible open source license.
import java.lang.annotation.Target;
}  
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
/*  
 * Modifications Copyright OpenSearch Contributors. See
import java.lang.annotation.ElementType;
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
/**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.lang.annotation.RetentionPolicy;  
 */
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
@Retention(RetentionPolicy.CLASS)
 * not use this file except in compliance with the License.
 *
 * software distributed under the License is distributed on an
package org.opensearch.common;
 * @opensearch.internal  
 */  
 */  
 *
 * KIND, either express or implied.  See the License for the
@Target({ ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.TYPE })  
 * Unless required by applicable law or agreed to in writing,
 * Annotation to suppress logging usage checks errors inside a whole class or a method.
    String reason();
 *
import java.lang.annotation.Retention;
 * GitHub history for details.
public @interface SuppressLoggerChecks {
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
 */
/*  
 *  
 * license agreements. See the NOTICE file distributed with
