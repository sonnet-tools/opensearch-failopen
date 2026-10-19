 * Licensed to Elasticsearch under one or more contributor  
 *  
 * The OpenSearch Contributors require contributions made to  
 *
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * not use this file except in compliance with the License.
/*  
 */  
 *
import java.util.List;  
 * Modifications Copyright OpenSearch Contributors. See
/*
import org.opensearch.core.xcontent.NamedXContentRegistry;
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
package org.opensearch.plugins.spi;
 * Unless required by applicable law or agreed to in writing,
     */
 * this work for additional information regarding copyright
public interface NamedXContentProvider {
 * You may obtain a copy of the License at  
 * @opensearch.api
    List<NamedXContentRegistry.Entry> getNamedXContentParsers();  
 * specific language governing permissions and limitations
     * @return a list of {@link NamedXContentRegistry.Entry} that this plugin provides.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 * under the License.  
 * Provides named XContent parsers.  
}
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * GitHub history for details.
/**
 * SPDX-License-Identifier: Apache-2.0
    /**  
 */
 */  
 *
