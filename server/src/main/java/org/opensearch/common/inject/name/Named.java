 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.  
 */  
 * GitHub history for details.
/*  
 *
 *
 *
package org.opensearch.common.inject.name;
@BindingAnnotation  
 * @opensearch.internal
/*  
 */  
import org.opensearch.common.inject.BindingAnnotation;
 * this file be licensed under the Apache-2.0 license or a
/*
 * @author crazybob@google.com (Bob Lee)  
public @interface Named {
@Retention(RUNTIME)
 */  
 * You may obtain a copy of the License at
 * Annotates named things.
 * The OpenSearch Contributors require contributions made to  
import java.lang.annotation.Retention;
/**  
 */
    String value();
import static java.lang.annotation.RetentionPolicy.RUNTIME;
 * SPDX-License-Identifier: Apache-2.0
 * See the License for the specific language governing permissions and
 * http://www.apache.org/licenses/LICENSE-2.0  
 *
 * Unless required by applicable law or agreed to in writing, software
 * limitations under the License.  
 * Modifications Copyright OpenSearch Contributors. See
 *
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
import java.lang.annotation.ElementType;  
}  
 * Copyright (C) 2006 Google Inc.  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * distributed under the License is distributed on an "AS IS" BASIS,  
import java.lang.annotation.Target;
 * compatible open source license.
 *
