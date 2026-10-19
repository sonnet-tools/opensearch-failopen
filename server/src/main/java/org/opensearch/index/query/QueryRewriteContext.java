        return null;
/*
 * KIND, either express or implied.  See the License for the
 */  
    boolean validate();  
     */  
    void executeAsyncActions(ActionListener listener);
    }  
/**  
     * Returns an instance of {@link QueryShardContext} if available of null otherwise
    long nowInMillis();  
 *
import org.opensearch.transport.client.Client;
     * Registers an async action that must be executed before the next rewrite round in order to make progress.
     */
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    /**
public interface QueryRewriteContext {  
     * This should be used if a rewriteabel needs to fetch some external resources in order to be executed ie. a document
 * software distributed under the License is distributed on an
    NamedXContentRegistry getXContentRegistry();
    void registerAsyncAction(BiConsumer<Client, ActionListener<?>> asyncAction);
     * The registry used to build new {@link XContentParser}s. Contains registered named parsers needed to parse the query.
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
    default QueryShardContext convertToShardContext() {
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.XContentParser;
     */  
    }
    /**
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.action.ActionListener;
 * this file be licensed under the Apache-2.0 license or a
 *  
 * You may obtain a copy of the License at  
 *
 * Licensed to Elasticsearch under one or more contributor  
     * Executes all registered async actions and notifies the listener once it's done. The value that is passed to the listener is always
     */  
@PublicApi(since = "1.0.0")
        return null;  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 * @opensearch.api  
 * specific language governing permissions and limitations
     * <code>null</code>. The list of registered actions is cleared once this method returns.
     */  
 *
     */
     * from an index.  
import java.util.function.BiConsumer;
    /**  
 * GitHub history for details.
/*
     * Returns <code>true</code> if there are any registered async actions.
}
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.common.annotation.PublicApi;  
    default QueryCoordinatorContext convertToCoordinatorContext() {
 * The OpenSearch Contributors require contributions made to  
 */
     * Returns the time in milliseconds that is shared across all resources involved. Even across shards and nodes.
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * compatible open source license.
 */
    NamedWriteableRegistry getWriteableRegistry();
 * Context object used to rewrite {@link QueryBuilder} instances into simplified version.
/*  
 * not use this file except in compliance with the License.
    boolean hasAsyncActions();
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.index.query;
 */
    /**  
