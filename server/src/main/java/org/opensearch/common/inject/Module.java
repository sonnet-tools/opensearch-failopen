     * <strong>Do not invoke this method directly</strong> to install submodules. Instead use
     * {@link Binder#install(Module)}, which ensures that {@link Provides provider methods} are
 * will be created for all methods annotated with {@literal @}{@link Provides}.
 * A module contributes configuration information, typically interface
     */
 * @opensearch.api
 *
    void configure(Binder binder);
 * Modifications Copyright OpenSearch Contributors. See
 *
 * {@link AbstractModule} rather than implementing this interface directly.
 *
/*
/*  
 * <p>
     * <p>  
 */  
 * Your Module classes can use a more streamlined syntax by extending  
 */
 * SPDX-License-Identifier: Apache-2.0
 */  
/*  
 * In addition to the bindings configured via {@link #configure}, bindings  
 * GitHub history for details.
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
}  
 *
public interface Module {
 */  
 *
 * compatible open source license.
@PublicApi(since = "1.0.0")
 * application is ultimately composed of little more than a set of  
 * See the License for the specific language governing permissions and
 * this file be licensed under the Apache-2.0 license or a
 * Use scope and binding annotations on these methods to configure the
/**  
 * Copyright (C) 2006 Google Inc.  
 * http://www.apache.org/licenses/LICENSE-2.0  
 * limitations under the License.  
 * bindings.  
 * you may not use this file except in compliance with the License.  
 * Licensed under the Apache License, Version 2.0 (the "License");
     * discovered.  
 * distributed under the License is distributed on an "AS IS" BASIS,  
     * Contributes bindings and other configurations for this module to {@code binder}.
 * <p>
    /**
import org.opensearch.common.annotation.PublicApi;
 * {@code Module}s and some bootstrapping code.
 * Unless required by applicable law or agreed to in writing, software
 * The OpenSearch Contributors require contributions made to  
 * bindings, which will be used to create an {@link Injector}. A Guice-based
package org.opensearch.common.inject;
 * You may obtain a copy of the License at
