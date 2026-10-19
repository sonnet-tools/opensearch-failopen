 *
/*
 * Licensed to Elasticsearch under one or more contributor  
/**  
 * not use this file except in compliance with the License.
 * Base interface for a query cache
@PublicApi(since = "1.0.0")
 * Unless required by applicable law or agreed to in writing,
 *
import java.io.Closeable;
 * under the License.  
 *
 */  
 * @opensearch.api  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 */
 */  
/*  
package org.opensearch.index.cache.query;
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 *  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
 * GitHub history for details.
import org.opensearch.common.annotation.PublicApi;
    void clear(String reason);
public interface QueryCache extends IndexComponent, Closeable, org.apache.lucene.search.QueryCache {  
 * specific language governing permissions and limitations
 */
 * this work for additional information regarding copyright
import org.opensearch.index.IndexComponent;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
/*  
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
