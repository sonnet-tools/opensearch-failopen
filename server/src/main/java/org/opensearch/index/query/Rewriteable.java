 * SPDX-License-Identifier: Apache-2.0
        if (rewritables != null && rewritables.isEmpty() == false) {
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * this work for additional information regarding copyright
    }
 *
public interface Rewriteable<T> {
            }
        T builder = original;
        return changed ? list : rewritables;
            builder = rewrittenBuilder;
        List<T> list = rewritables;
                throw new IllegalStateException(
import org.opensearch.core.action.ActionListener;
     * Rewrites each element of the list until it doesn't change and returns a new list iff there is at least one element of the list that
            }
     * @param original the original rewriteable to rewrite
 * not use this file except in compliance with the License.
     * @throws IOException if an {@link IOException} occurs
import org.opensearch.core.common.ParsingException;
        }
     * rewrite were applied.
     * @param context the rewrite context to use
        } catch (IOException | IllegalArgumentException | ParsingException ex) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                        ActionListener.wrap(
        }
                // this is some protection against user provided queries if they don't obey the contract of rewrite we allow 16 rounds
                if (context.hasAsyncActions()) {
package org.opensearch.index.query;
    }
/*
    static <T extends Rewriteable<T>> void rewriteAndFetch(
                    // and then we fail to prevent infinite loops
 * You may obtain a copy of the License at
            rewriteResponse.onResponse(builder);
        QueryRewriteContext context,
 * compatible open source license.
            rewriteResponse.onFailure(ex);
        return builder;
        int iteration
            list = new ArrayList<>(rewritables.size());
                    T finalBuilder = builder;
     * Rewrites the given rewriteable and fetches pending async tasks for each round before rewriting again.
    ) {
 * the Apache License, Version 2.0 (the "License"); you may
            }
/*
     * changed during it's rewrite. Otherwise the given list instance is returned unchanged.
            for (T instance : rewritables) {
 * license agreements. See the NOTICE file distributed with
import java.util.ArrayList;
            if (assertNoAsyncTasks && context.hasAsyncActions()) {
     * @throws IOException if an {@link IOException} occurs
     * rewrites the rewriteable until it doesn't change anymore.
 * ownership. Elasticsearch licenses this file to you under
 * The OpenSearch Contributors require contributions made to
     * @param context the rewrite context to use
/*
@PublicApi(since = "1.0.0")
     */
                if (iteration++ >= MAX_REWRITE_ROUNDS) {
                // and then we fail to prevent infinite loops
     * objects will be the same instance as this if no changes during the
            if (iteration++ >= MAX_REWRITE_ROUNDS) {
        rewriteAndFetch(original, context, rewriteResponse, 0);
 * Modifications Copyright OpenSearch Contributors. See
    /**
    T rewrite(QueryRewriteContext ctx) throws IOException;
/**
                        )
     */
 */
        }
     *                          rewrite. See {@link QueryRewriteContext#executeAsyncActions(ActionListener)} for details
 * KIND, either express or implied.  See the License for the
    static <T extends Rewriteable<T>> T rewrite(T original, QueryRewriteContext context) throws IOException {
                            n -> rewriteAndFetch(finalBuilder, context, rewriteResponse, currentIterationNumber),
    }
     */
        T builder = original;
 *
import org.opensearch.common.annotation.PublicApi;
                    final int currentIterationNumber = iteration;
     */
        for (T rewrittenBuilder = builder.rewrite(context); rewrittenBuilder != builder; rewrittenBuilder = builder.rewrite(context)) {
     * Rewrites this instance based on the provided context. The returned
 */
 * Licensed to Elasticsearch under one or more contributor
                list.add(rewrite);
     */
 * @opensearch.api
            }
    /**
     * can simplify / optimize itself should do their heavy lifting during
 * GitHub history for details.
                    throw new IllegalStateException(
                    "too many rewrite rounds, rewriteable might return new objects even if they are not " + "rewritten"
                        "too many rewrite rounds, rewriteable might return new objects even if they are not " + "rewritten"
     * @param assertNoAsyncTasks if <code>true</code> the rewrite will fail if there are any pending async tasks on the context after the
     * Rewrites the given {@link Rewriteable} into its primitive form. Rewriteables that for instance fetch resources from remote hosts or
    /**
    static <T extends Rewriteable<T>> T rewrite(T original, QueryRewriteContext context, boolean assertNoAsyncTasks) throws IOException {
     */
                            rewriteResponse::onFailure
     * can simplify / optimize itself should do their heavy lifting during {@link #rewrite(QueryRewriteContext)}. This method
                    changed = true;
                    // this is some protection against user provided queries if they don't obey the contract of rewrite we allow 16 rounds
                throw new IllegalStateException("async actions are left after rewrite");
        return rewrite(original, context, false);
    /**
     * Rewrites the given rewriteable and fetches pending async tasks for each round before rewriting again.
import java.util.List;
 * under the License.
                );
    int MAX_REWRITE_ROUNDS = 16;
 * A basic interface for rewriteable classes.
     * rewriteable until it doesn't change anymore.
     * Rewrites the given {@link Rewriteable} into its primitive form. Rewriteables that for instance fetch resources from remote hosts or
        try {
 * specific language governing permissions and limitations
    static <T extends Rewriteable<T>> List<T> rewrite(List<T> rewritables, QueryRewriteContext context) throws IOException {
 */
 *
        int iteration = 0;
     * {@link #rewriteAndFetch(Rewriteable, QueryRewriteContext, ActionListener)} (QueryRewriteContext)}. This method rewrites the
                }
    /**
        ActionListener<T> rewriteResponse,
    /**
                    return;
 *
                }
    }
                if (instance != rewrite) {
 * this file be licensed under the Apache-2.0 license or a
                T rewrite = rewrite(instance, context);
        boolean changed = false;
}
     * @param original the original rewriteable to rewrite
                builder = rewrittenBuilder;
    }
    static <T extends Rewriteable<T>> void rewriteAndFetch(T original, QueryRewriteContext context, ActionListener<T> rewriteResponse) {
import java.io.IOException;
        T original,
                    );
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
            for (T rewrittenBuilder = builder.rewrite(context); rewrittenBuilder != builder; rewrittenBuilder = builder.rewrite(context)) {
                }
                    context.executeAsyncActions(
                    );
