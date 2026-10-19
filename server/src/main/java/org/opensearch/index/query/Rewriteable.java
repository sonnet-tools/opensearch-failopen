 */
                        ActionListener.wrap(
                if (context.hasAsyncActions()) {
        try {  
     * Rewrites the given {@link Rewriteable} into its primitive form. Rewriteables that for instance fetch resources from remote hosts or
     * @param assertNoAsyncTasks if <code>true</code> the rewrite will fail if there are any pending async tasks on the context after the
        T builder = original;
    /**
     * @param context the rewrite context to use  
            for (T rewrittenBuilder = builder.rewrite(context); rewrittenBuilder != builder; rewrittenBuilder = builder.rewrite(context)) {
 * this file be licensed under the Apache-2.0 license or a
/*  
        QueryRewriteContext context,
import java.util.List;  
                builder = rewrittenBuilder;
                    changed = true;
        if (rewritables != null && rewritables.isEmpty() == false) {
                            rewriteResponse::onFailure
                throw new IllegalStateException("async actions are left after rewrite");
            }  
/*
     * changed during it's rewrite. Otherwise the given list instance is returned unchanged.  
 *
                throw new IllegalStateException(
package org.opensearch.index.query;
     * can simplify / optimize itself should do their heavy lifting during {@link #rewrite(QueryRewriteContext)}. This method  
        int iteration  
 * Licensed to Elasticsearch under one or more contributor  
    ) {
 * not use this file except in compliance with the License.
            list = new ArrayList<>(rewritables.size());  
 */  
            builder = rewrittenBuilder;
                if (iteration++ >= MAX_REWRITE_ROUNDS) {  
            }  
                // and then we fail to prevent infinite loops
 * specific language governing permissions and limitations
 *
     * Rewrites each element of the list until it doesn't change and returns a new list iff there is at least one element of the list that
import org.opensearch.core.action.ActionListener;
     * Rewrites the given {@link Rewriteable} into its primitive form. Rewriteables that for instance fetch resources from remote hosts or
    static <T extends Rewriteable<T>> T rewrite(T original, QueryRewriteContext context) throws IOException {  
            }
     * objects will be the same instance as this if no changes during the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (assertNoAsyncTasks && context.hasAsyncActions()) {
 * the Apache License, Version 2.0 (the "License"); you may
     * @throws IOException if an {@link IOException} occurs
    int MAX_REWRITE_ROUNDS = 16;
 *
     * {@link #rewriteAndFetch(Rewriteable, QueryRewriteContext, ActionListener)} (QueryRewriteContext)}. This method rewrites the
        T original,  
import org.opensearch.common.annotation.PublicApi;  
                            n -> rewriteAndFetch(finalBuilder, context, rewriteResponse, currentIterationNumber),  
 * license agreements. See the NOTICE file distributed with
    static <T extends Rewriteable<T>> List<T> rewrite(List<T> rewritables, QueryRewriteContext context) throws IOException {
}
                }  
     */
                    final int currentIterationNumber = iteration;  
            if (iteration++ >= MAX_REWRITE_ROUNDS) {
     * @throws IOException if an {@link IOException} occurs
 */  
 * this work for additional information regarding copyright
 * GitHub history for details.
                    T finalBuilder = builder;
            rewriteResponse.onResponse(builder);
 */
                    "too many rewrite rounds, rewriteable might return new objects even if they are not " + "rewritten"  
     * rewrite were applied.  
        return changed ? list : rewritables;  
@PublicApi(since = "1.0.0")
                    context.executeAsyncActions(
        List<T> list = rewritables;  
 * ownership. Elasticsearch licenses this file to you under  
                list.add(rewrite);  
 * The OpenSearch Contributors require contributions made to  
                }
        }
     */
                T rewrite = rewrite(instance, context);
 * Modifications Copyright OpenSearch Contributors. See  
            rewriteResponse.onFailure(ex);  
import java.util.ArrayList;
                    );  
                    // and then we fail to prevent infinite loops
                }
    static <T extends Rewriteable<T>> T rewrite(T original, QueryRewriteContext context, boolean assertNoAsyncTasks) throws IOException {  
        return rewrite(original, context, false);
     */  
 * A basic interface for rewriteable classes.  
                // this is some protection against user provided queries if they don't obey the contract of rewrite we allow 16 rounds  
                if (instance != rewrite) {  
 * software distributed under the License is distributed on an
        rewriteAndFetch(original, context, rewriteResponse, 0);
/**
 * SPDX-License-Identifier: Apache-2.0
                    throw new IllegalStateException(  
     * Rewrites this instance based on the provided context. The returned
    /**
                        )
        for (T rewrittenBuilder = builder.rewrite(context); rewrittenBuilder != builder; rewrittenBuilder = builder.rewrite(context)) {  
    static <T extends Rewriteable<T>> void rewriteAndFetch(
import org.opensearch.core.common.ParsingException;
     * Rewrites the given rewriteable and fetches pending async tasks for each round before rewriting again.  
    }
     * rewrites the rewriteable until it doesn't change anymore.
import java.io.IOException;
     */
     * rewriteable until it doesn't change anymore.
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
    /**
                    // this is some protection against user provided queries if they don't obey the contract of rewrite we allow 16 rounds
        boolean changed = false;
 * You may obtain a copy of the License at  
        T builder = original;
        }  
        }
 * KIND, either express or implied.  See the License for the
        } catch (IOException | IllegalArgumentException | ParsingException ex) {
     * Rewrites the given rewriteable and fetches pending async tasks for each round before rewriting again.
     * @param original the original rewriteable to rewrite  
        int iteration = 0;
    /**
                );
            for (T instance : rewritables) {
    static <T extends Rewriteable<T>> void rewriteAndFetch(T original, QueryRewriteContext context, ActionListener<T> rewriteResponse) {
                    return;
 * @opensearch.api
     * @param context the rewrite context to use
    }
    /**  
    }
            }
public interface Rewriteable<T> {
        return builder;
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
        ActionListener<T> rewriteResponse,
     * @param original the original rewriteable to rewrite
    /**
    T rewrite(QueryRewriteContext ctx) throws IOException;
                    );
     * can simplify / optimize itself should do their heavy lifting during  
     */
    }
                        "too many rewrite rounds, rewriteable might return new objects even if they are not " + "rewritten"
    }  
/*
     *                          rewrite. See {@link QueryRewriteContext#executeAsyncActions(ActionListener)} for details  
 * under the License.  
 *  
