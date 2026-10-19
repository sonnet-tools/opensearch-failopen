 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
    String reason();
@Retention(RetentionPolicy.CLASS)  
 * specific language governing permissions and limitations
package org.opensearch.common;
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
 * Unless required by applicable law or agreed to in writing,
 *  
/*  
public @interface SuppressForbidden {  
 *    http://www.apache.org/licenses/LICENSE-2.0
}
 * KIND, either express or implied.  See the License for the
/**
 *  
 * this work for additional information regarding copyright
 */
 */
import java.lang.annotation.Retention;  
/*
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 *
 * Modifications Copyright OpenSearch Contributors. See  
 */
@PublicApi(since = "1.0.0")
 * this file be licensed under the Apache-2.0 license or a
@Target({ ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.TYPE })
 * compatible open source license.
 *
 * software distributed under the License is distributed on an
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.annotation.PublicApi;  
 * Annotation to suppress forbidden-apis errors inside a whole class, a method, or a field.
import java.lang.annotation.ElementType;
/*
 * @opensearch.api
import java.lang.annotation.RetentionPolicy;
 * not use this file except in compliance with the License.
import java.lang.annotation.Target;
 * ownership. Elasticsearch licenses this file to you under  
