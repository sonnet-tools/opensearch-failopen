 * execution to the appropriate transport action (e.g. {@link org.opensearch.action.search.TransportSearchAction}) for each single item.
 * not use this file except in compliance with the License.
 *  
 *  
 * Licensed to Elasticsearch under one or more contributor  
 */
package org.opensearch.action;
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
public interface CompositeIndicesRequest {}  
 * The OpenSearch Contributors require contributions made to  
 * (e.g. {@link org.opensearch.action.search.TransportMultiSearchAction}), which goes through all sub-requests and delegates their
 */
/*  
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 * under the License.  
/*  
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
 */  
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
 *
 *
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
 * Marker interface that needs to be implemented by all {@link org.opensearch.action.ActionRequest} subclasses that are composed of
 * multiple sub-requests which relate to one or more indices.  A composite request is executed by its own transport action class  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
