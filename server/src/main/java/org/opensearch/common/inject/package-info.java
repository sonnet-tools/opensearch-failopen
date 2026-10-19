 * <p>The principal public APIs in this package are:
 *  
 * See the License for the specific language governing permissions and
 *  
 *
/*  
 *
 *
 *     to collect these bindings.
/*
 */  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * Modifications copyright (C) 2020 Elasticsearch B.V.
 * you may not use this file except in compliance with the License.  
 * <dt>{@link org.opensearch.common.inject.Binder}  
 * this file be licensed under the Apache-2.0 license or a
 *  
 * GitHub history for details.
 * You may obtain a copy of the License at
 * <dt>{@link org.opensearch.common.inject.Module}
 * injection framework.  Please refer to the Guice
 * http://www.apache.org/licenses/LICENSE-2.0  
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * </dl>
 *
 *     Guice creates instances for a particular binding.  
 * for a gentle introduction.  
 * Copyright (C) 2006 Google Inc.  
 * limitations under the License.  
 * <dd>The interface you will implement in order to specify "bindings" --
/* @notice
/**
 * <i>Google Guice</i> (pronounced "juice") is an ultra-lightweight dependency  
 *
 *
 * <dd>The annotation you will use in your implementation classes to tell Guice  
 * The OpenSearch Contributors require contributions made to  
 * <dd>The interface you will implement when you need to customize exactly how
 * <dl>
 * Unless required by applicable law or agreed to in writing, software
 * <dt>{@link org.opensearch.common.inject.Inject}
 *  
 * <dd>The object that Guice passes into your {@link org.opensearch.common.inject.Module}
 *     (your "dependencies").
 * <a href="http://docs.google.com/Doc?id=dd2fhx4z_5df5hw8">User's Guide</a>
 * <dt>{@link org.opensearch.common.inject.Provider}
 * distributed under the License is distributed on an "AS IS" BASIS,  
 */  
package org.opensearch.common.inject;
 *     instructions for how Guice should handle injection -- for a particular  
 *     set of interfaces.
 */
 * Modifications Copyright OpenSearch Contributors. See  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 *     where and how it should send in ("inject") the objects you depend on
 */
