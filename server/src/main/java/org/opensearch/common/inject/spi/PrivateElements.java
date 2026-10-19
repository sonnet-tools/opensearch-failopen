     * exposed. Used by Guice in the production of descriptive error messages.
 * @author jessewilson@google.com (Jesse Wilson)  
 */  
     * Returns the child injector that hosts these private elements, or null if the elements haven't
    /**
 * compatible open source license.
import org.opensearch.common.inject.Key;  
package org.opensearch.common.inject.spi;
 * this file be licensed under the Apache-2.0 license or a
     * <p>  
 * Licensed under the Apache License, Version 2.0 (the "License");
/*
 *
 */
 * http://www.apache.org/licenses/LICENSE-2.0  
     */
import org.opensearch.common.inject.Injector;
    Injector getInjector();
 * A private collection of elements that are hidden from the enclosing injector or module by  
 */
     * unfamiliar.  
 */  
 * default. See {@link org.opensearch.common.inject.PrivateModule PrivateModule} for details.
 *
     * example. Tools should simply call {@code toString()} on the source object if the type is
 * You may obtain a copy of the License at
public interface PrivateElements extends Element {  
 * distributed under the License is distributed on an "AS IS" BASIS,  
    Set<Key<?>> getExposedKeys();
     * @param key one of the keys exposed by this module.
 * Unless required by applicable law or agreed to in writing, software
 *
    List<Element> getElements();
     * Returns an arbitrary object containing information about the "place" where this key was
 * @opensearch.api  
     * Returns the configuration information in this private environment.  
 *
import org.opensearch.common.annotation.PublicApi;
     * been used to create an injector.  
     */  
import java.util.List;
 *
    /**
    /**  
 * Copyright (C) 2008 Google Inc.  
import java.util.Set;  
 * limitations under the License.  
 * Modifications Copyright OpenSearch Contributors. See
/*  
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
@PublicApi(since = "1.0.0")
    Object getExposedSource(Key<?> key);
/**
     * Tools might specially handle types they know about; {@code StackTraceElement} is a good
     *
/*  
}
     */
 * GitHub history for details.
     * Returns the unique exposed keys for these private elements.
    /**
 *
 * @since 2.0
 * you may not use this file except in compliance with the License.  
 * See the License for the specific language governing permissions and
     */  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
