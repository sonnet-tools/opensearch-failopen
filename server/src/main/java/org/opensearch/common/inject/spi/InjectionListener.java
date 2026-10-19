 * The OpenSearch Contributors require contributions made to  
 */
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
    /**
 */  
     * Invoked by Guice after it injects the fields and methods of instance.
 * this file be licensed under the Apache-2.0 license or a
 * @opensearch.api
}
/*  
 */  
 * @author jessewilson@google.com (Jesse Wilson)
 * Unless required by applicable law or agreed to in writing, software
 * SPDX-License-Identifier: Apache-2.0
/*
 * Licensed under the Apache License, Version 2.0 (the "License");
    void afterInjection(I injectee);  
 */  
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0  
 * injections, post-injection initialization, and more.
 * @author crazybob@google.com (Bob Lee)
 * Listens for injections into instances of type {@code I}. Useful for performing further
     * @param injectee instance that Guice injected dependencies into
 * GitHub history for details.
 * limitations under the License.  
import org.opensearch.common.annotation.PublicApi;
 * you may not use this file except in compliance with the License.  
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.common.inject.spi;
 * distributed under the License is distributed on an "AS IS" BASIS,  
/*  
 * Copyright (C) 2009 Google Inc.  
 *  
     */
 *
 * See the License for the specific language governing permissions and
 *
     *  
 *
@PublicApi(since = "1.0.0")
 * compatible open source license.
/**  
 * @since 2.0  
public interface InjectionListener<I> {
