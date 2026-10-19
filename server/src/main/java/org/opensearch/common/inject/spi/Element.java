 * distributed under the License is distributed on an "AS IS" BASIS,  
 * @author crazybob@google.com (Bob Lee)
 *
 *
 * You may obtain a copy of the License at
     *  
 * Elements#getElements(org.opensearch.common.inject.Module[]) Elements.getElements()} to read the elements
 * http://www.apache.org/licenses/LICENSE-2.0  
 * <p>  
 * compatible open source license.
import org.opensearch.common.inject.Binder;
    void applyTo(Binder binder);  
package org.opensearch.common.inject.spi;
     * @param visitor to call back on
 * GitHub history for details.
@PublicApi(since = "1.0.0")  
    /**
 */  
 * Unless required by applicable law or agreed to in writing, software
 * Modifications Copyright OpenSearch Contributors. See
    Object getSource();
 * this file be licensed under the Apache-2.0 license or a
     *                                       element.
public interface Element {
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  
 * See the License for the specific language governing permissions and
 * from a module, and {@link Elements#getModule(Iterable) Elements.getModule()} to rewrite them.  
 * This can be used for static analysis and generation of Guice modules.
 * @since 2.0
     *
     * Accepts an element visitor. Invokes the visitor method specific to this element's type.
 * @author jessewilson@google.com (Jesse Wilson)  
}
     * @param binder to apply configuration element to
    /**  
    <T> T acceptVisitor(ElementVisitor<T> visitor);  
     * @throws UnsupportedOperationException if the {@code applyTo} method is not supported by this  
/*
/**
/*  
 *
 *
 * you may not use this file except in compliance with the License.  
 * limitations under the License.  
     * Writes this module element to the given binder (optional operation).  
/*  
     * <p>  
import org.opensearch.common.annotation.PublicApi;
     * configured. Used by Guice in the production of descriptive error messages.
 */  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.api
 */
     * Returns an arbitrary object containing information about the "place" where this element was
 *
     * Tools might specially handle types they know about; {@code StackTraceElement} is a good
     * example. Tools should simply call {@code toString()} on the source object if the type is
 * Copyright (C) 2008 Google Inc.  
 */
     */
 * The elements of a module can be inspected, validated and rewritten. Use {@link
 * A core component of a module or injector.
     */
 * The OpenSearch Contributors require contributions made to  
     * unfamiliar.  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     */
    /**
