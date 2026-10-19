 * See the License for the specific language governing permissions and
 * You may obtain a copy of the License at
 * distributed under the License is distributed on an "AS IS" BASIS,  
 */  
import static java.lang.annotation.RetentionPolicy.RUNTIME;
 *
import org.opensearch.common.inject.BindingAnnotation;
 */  
 *
}
 * Unless required by applicable law or agreed to in writing, software
@Retention(RUNTIME)
 *
 * @opensearch.internal
/**
 * http://www.apache.org/licenses/LICENSE-2.0  
    int uniqueId();  
 * @author jessewilson@google.com (Jesse Wilson)  
import java.lang.annotation.Retention;  
/*  
@BindingAnnotation
 * SPDX-License-Identifier: Apache-2.0
 * limitations under the License.  
    String setName();
 * Licensed under the Apache License, Version 2.0 (the "License");
 * Copyright (C) 2008 Google Inc.  
/*  
 * compatible open source license.
/*
 * this file be licensed under the Apache-2.0 license or a
 *
 */  
 */
 * An internal binding annotation applied to each element in a multibinding.
 * to contribute multibindings independently.
 * All elements are assigned a globally-unique id to allow different modules  
 *
 * The OpenSearch Contributors require contributions made to  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * Modifications Copyright OpenSearch Contributors. See
@interface Element {  
 * you may not use this file except in compliance with the License.  
 *
package org.opensearch.common.inject.multibindings;
 * GitHub history for details.
