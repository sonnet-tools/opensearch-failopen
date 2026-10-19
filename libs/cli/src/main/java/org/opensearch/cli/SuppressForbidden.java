 * Annotation to suppress forbidden-apis errors inside a whole class, a method, or a field.  
 * Licensed to Elasticsearch under one or more contributor  
 */
 *
 * You may obtain a copy of the License at  
    String reason();
 *    http://www.apache.org/licenses/LICENSE-2.0
 * not use this file except in compliance with the License.
 * ownership. Elasticsearch licenses this file to you under  
@Retention(RetentionPolicy.CLASS)
/**
 */
package org.opensearch.cli;
import java.lang.annotation.ElementType;  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
 * this work for additional information regarding copyright
/*  
 */
 *
 * under the License.  
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
}  
/*
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * GitHub history for details.
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Target({ ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE })  
import java.lang.annotation.Target;  
public @interface SuppressForbidden {
 */  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See  
