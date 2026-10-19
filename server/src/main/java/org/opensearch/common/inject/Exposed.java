@Documented
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 * Copyright (C) 2008 Google Inc.  
import static java.lang.annotation.RetentionPolicy.RUNTIME;  
public @interface Exposed {
 *
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * GitHub history for details.
@Retention(RUNTIME)  
package org.opensearch.common.inject;
 *
 * Unless required by applicable law or agreed to in writing, software
 *
 * You may obtain a copy of the License at
 * limitations under the License.  
 * @author jessewilson@google.com (Jesse Wilson)  
 * @since 2.0
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * See the License for the specific language governing permissions and
 *
 * http://www.apache.org/licenses/LICENSE-2.0  
/**
}  
 * private module to indicate that the provided binding is exposed.
import java.lang.annotation.Target;
 */
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
import java.lang.annotation.ElementType;
 * Accompanies a {@literal @}{@link Provides Provides} method annotation in a  
import java.lang.annotation.Retention;  
import java.lang.annotation.Documented;
/*  
 * @opensearch.internal  
 */
 * you may not use this file except in compliance with the License.  
/*  
@Target(ElementType.METHOD)
 */  
 *
/*
 * SPDX-License-Identifier: Apache-2.0
