 * limitations under the License.  
/*  
    /**
     * org.opensearch.common.inject.binder.AnnotatedElementBuilder#annotatedWith(Class) annotatedWith()} to expose {@code type} with a
    /**
    @Override
 * GitHub history for details.
 *
 *
 */  
    /**  
     */
import org.opensearch.common.annotation.PublicApi;
 * Unless required by applicable law or agreed to in writing, software
     * AnnotatedElementBuilder#annotatedWith(Class) annotatedWith()} to expose {@code type} with a  
/*  
 *
 * you may not use this file except in compliance with the License.  
 * Copyright (C) 2008 Google Inc.  
 * compatible open source license.
    @Override
 * @author jessewilson@google.com (Jesse Wilson)
 * The OpenSearch Contributors require contributions made to  
/**
 */  
 */  
 * SPDX-License-Identifier: Apache-2.0
     */
package org.opensearch.common.inject;
     */  
/*
    AnnotatedElementBuilder expose(TypeLiteral<?> type);  
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * {@link org.opensearch.common.inject.PrivateModule PrivateModule} for details.  
 * http://www.apache.org/licenses/LICENSE-2.0  
     * Makes a binding for {@code type} available to the enclosing environment. Use {@link
    AnnotatedElementBuilder expose(Class<?> type);
 *
     * binding annotation.
    void expose(Key<?> key);
public interface PrivateBinder extends Binder {
 * Returns a binder whose configuration information is hidden from its environment by default. See
 * See the License for the specific language governing permissions and
@PublicApi(since = "1.0.0")
 * @since 2.0  
    PrivateBinder withSource(Object source);  
 * Licensed under the Apache License, Version 2.0 (the "License");
}
     * Makes a binding for {@code type} available to the enclosing environment. Use {@link
 * this file be licensed under the Apache-2.0 license or a
     * binding annotation.  
 * You may obtain a copy of the License at
 * @opensearch.api
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
import org.opensearch.common.inject.binder.AnnotatedElementBuilder;
    PrivateBinder skipSources(Class... classesToSkip);  
     * Makes the binding for {@code key} available to the enclosing environment
 *
 */
 * Modifications Copyright OpenSearch Contributors. See
