 *
 * Modifications Copyright OpenSearch Contributors. See
@Retention(RUNTIME)
 * Licensed under the Apache License, Version 2.0 (the "License");
 * http://www.apache.org/licenses/LICENSE-2.0  
 * annotations with {@code @Retention(RUNTIME)}. For example:
}
 * See the License for the specific language governing permissions and
 * Unless required by applicable law or agreed to in writing, software
 *
package org.opensearch.common.inject;
 *
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
public @interface BindingAnnotation {  
 *
 *
 * limitations under the License.  
 * You may obtain a copy of the License at
 * you may not use this file except in compliance with the License.  
 * Copyright (C) 2006 Google Inc.  
import java.lang.annotation.Target;
 * Annotates annotations which are used for binding. Only one such annotation
 * this file be licensed under the Apache-2.0 license or a
@Target(ANNOTATION_TYPE)
 *   {@code @}Retention(RUNTIME)  
 *   public {@code @}interface Transactional {}  
 *
/**
 * @author crazybob@google.com (Bob Lee)  
 * distributed under the License is distributed on an "AS IS" BASIS,  
import static java.lang.annotation.RetentionPolicy.RUNTIME;
 * <pre>
 * may apply to a single injection point. You must also annotate binder  
 */  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
/*  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
/*
 * </pre>
 * GitHub history for details.
 */  
 * compatible open source license.
 * @opensearch.internal
import java.lang.annotation.Retention;
 */
 */  
/*  
 *   {@code @}Target({ FIELD, PARAMETER, METHOD })
 *   {@code @}BindingAnnotation
