 * Modifications Copyright OpenSearch Contributors. See
 */
 * http://www.apache.org/licenses/LICENSE-2.0  
 * you may not use this file except in compliance with the License.  
 *  
 *
 */  
 * Copyright (C) 2008 Google Inc.  
 * aren't specified in injections, this interface should be used to expose all dependencies.
 */
 * The OpenSearch Contributors require contributions made to  
 *
 *
import org.opensearch.common.inject.Provider;
/*
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * GitHub history for details.
/**  
 * limitations under the License.  
 * SPDX-License-Identifier: Apache-2.0
 *
 */  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * Unless required by applicable law or agreed to in writing, software
 * A provider with dependencies on other injected types. If a {@link Provider} has dependencies that
 * @opensearch.internal  
/*  
 * See the License for the specific language governing permissions and
/*  
public interface ProviderWithDependencies<T> extends Provider<T>, HasDependencies {}
package org.opensearch.common.inject.spi;
 * distributed under the License is distributed on an "AS IS" BASIS,  
 * @since 2.0
 * You may obtain a copy of the License at
