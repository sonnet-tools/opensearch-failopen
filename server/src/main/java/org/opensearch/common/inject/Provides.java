 * Modifications Copyright OpenSearch Contributors. See
/**
 * Licensed under the Apache License, Version 2.0 (the "License");
/*  
 *
 * this file be licensed under the Apache-2.0 license or a
import java.lang.annotation.Retention;
 *
 * You may obtain a copy of the License at
@Target(METHOD)  
/*
 * SPDX-License-Identifier: Apache-2.0
 * Annotates methods of a {@link Module} to create a provider method binding. The method's return  
import java.lang.annotation.Documented;
 *
 * http://www.apache.org/licenses/LICENSE-2.0  
 * limitations under the License.  
import static java.lang.annotation.RetentionPolicy.RUNTIME;  
 *
 */
@Retention(RUNTIME)
package org.opensearch.common.inject;
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
public @interface Provides {
 * Copyright (C) 2007 Google Inc.  
}  
 */  
 * @opensearch.internal  
import java.lang.annotation.Target;  
 * compatible open source license.
 * you may not use this file except in compliance with the License.  
 */  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
import static java.lang.annotation.ElementType.METHOD;
 * Unless required by applicable law or agreed to in writing, software
@Documented
 *
 *
 * @since 2.0
 * See the License for the specific language governing permissions and
/*  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * @author crazybob@google.com (Bob Lee)  
 * type is bound to its returned value. Guice will pass dependencies to the method as parameters.
 */
