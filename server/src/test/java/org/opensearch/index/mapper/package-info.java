 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
 */  
 * {@link org.opensearch.index.mapper.DocumentParser} class which delegates  
 * {@link org.opensearch.index.mapper.KeywordFieldMapper keyword} field,
 *
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * {@link org.opensearch.index.mapper.TextFieldMapper text} or  
 * to various {@link org.opensearch.index.mapper.Mapper} implementations for
 * GitHub history for details.  
 * <p>Mappings support the addition of new fields, so that fields can be added  
 * Unless required by applicable law or agreed to in writing,
 * per-field handling.
 * to indices even though users had not thought about them at index creation
 * re-add a field with a different configuration under the same name, which  
 * under the License.  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 * by the {@link org.opensearch.index.mapper.MapperService} class.
 */
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
 * time. However, the removal of fields is not supported, as it would allow to
 * SPDX-License-Identifier: Apache-2.0
 *
 *  
 */
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.index.mapper;  
 * Lucene cannot handle. Introduction of new fields into the mappings is handled
/**  
 * KIND, either express or implied.  See the License for the
/*
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * Lucene indices, for instance whether a string field should be indexed as a
/*
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * etc. This parsing is done by the
 * Mappings. Mappings define the way that documents should be translated to
 * this work for additional information regarding copyright
