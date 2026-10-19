@CheckForNull  
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 *
import org.opensearch.common.annotation.PublicApi;
 */  
import java.lang.annotation.Retention;
 */  
 * KIND, either express or implied.  See the License for the
@Target({ ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD })
 *
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.common;
 *  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 *
}
 * The presence of this annotation on a method parameter indicates that
import java.lang.annotation.RetentionPolicy;  
 * @opensearch.api
@TypeQualifierNickname
 * Unless required by applicable law or agreed to in writing,
/*  
/**  
 * SPDX-License-Identifier: Apache-2.0
 * {@code null} is an acceptable value for that parameter.  It should not be
@Retention(RetentionPolicy.RUNTIME)
import java.lang.annotation.Documented;  
 * The OpenSearch Contributors require contributions made to  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
@PublicApi(since = "1.0.0")  
public @interface Nullable {
import javax.annotation.CheckForNull;  
 * this file be licensed under the Apache-2.0 license or a
/*
import java.lang.annotation.Target;
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
import java.lang.annotation.ElementType;
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
@Documented
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
import javax.annotation.meta.TypeQualifierNickname;
 * license agreements. See the NOTICE file distributed with
 * used for parameters of primitive types.  
 * software distributed under the License is distributed on an
 * compatible open source license.
 */  
