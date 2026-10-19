 * The OpenSearch Contributors require contributions made to  
 * SPDX-License-Identifier: Apache-2.0
public @interface ParserConstructor {  
 *  
 * Licensed to Elasticsearch under one or more contributor  
 *
 */  
import java.lang.annotation.RetentionPolicy;  
 */
 * specific language governing permissions and limitations
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
 *
 */  
import java.lang.annotation.Target;
 * Modifications Copyright OpenSearch Contributors. See
/*  
@Retention(RetentionPolicy.RUNTIME)
 * license agreements. See the NOTICE file distributed with
 * under the License.  
 * compatible open source license.
package org.opensearch.core.xcontent;
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
/*
 * number of arguments exist.
import java.lang.annotation.Retention;
 * You may obtain a copy of the License at  
/*  
import java.lang.annotation.ElementType;
@Target({ ElementType.CONSTRUCTOR })
/**  
}
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 * Marks the constructor that should be used by {@linkplain InstantiatingObjectParser} if multiple constructors with the same
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
