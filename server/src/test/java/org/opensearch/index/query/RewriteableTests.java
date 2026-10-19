            this.supplier = supplier;  
 *  
import java.io.IOException;
        final int numRewrites;  
    private static final class TestRewriteable implements Rewriteable<TestRewriteable> {
        final Supplier<Boolean> supplier;
    }
        );  
        for (int i = 0; i < numInstances; i++) {
        assertEquals(ise.getMessage(), "too many rewrite rounds, rewriteable might return new objects even if they are not rewritten");  
 * compatible open source license.
                        setOnce.set(Boolean.TRUE);  
        TestRewriteable(int numRewrites, boolean fetch, Supplier<Boolean> supplier) {  
                throw e.getCause(); // we expect the underlying exception here  
 * Unless required by applicable law or agreed to in writing,
}
                    } else {
        }  
import java.util.concurrent.ExecutionException;
        IllegalStateException ise = expectThrows(  
            }
            PlainActionFuture<TestRewriteable> f = new PlainActionFuture<>();
        for (TestRewriteable instance : rewrittenList) {
 * ownership. Elasticsearch licenses this file to you under  
            return new TestRewriteable(numRewrites - 1, fetch, null);
        }
        TestRewriteable(int numRewrites, boolean fetch) {
            }
            () -> Rewriteable.rewrite(new TestRewriteable(Rewriteable.MAX_REWRITE_ROUNDS + 1), context)
 * specific language governing permissions and limitations
            this(numRewrites, false, null);
            randomBoolean()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
            }
    public void testRewriteList() throws IOException {  
 * GitHub history for details.
            rewriteableList.add(new TestRewriteable(0));
        }  
        TestRewriteable rewrite = Rewriteable.rewrite(  
 * The OpenSearch Contributors require contributions made to  
            }
    public void testRewrite() throws IOException {
 * KIND, either express or implied.  See the License for the
        }
                    if (randomBoolean()) {  
        TestRewriteable(int numRewrites) {
                return this;  
        }
                });
 *
        assertEquals(rewrite.numRewrites, 0);
            assertEquals(0, instance.numRewrites);
/*
            IllegalStateException.class,
        assertEquals(ise.getMessage(), "too many rewrite rounds, rewriteable might return new objects even if they are not rewritten");
        QueryRewriteContext context = new BaseQueryRewriteContext(null, null, null, null);
        assertSame(rewriteableList, Rewriteable.rewrite(rewriteableList, context));
 *     http://www.apache.org/licenses/LICENSE-2.0
        BaseQueryRewriteContext context = new BaseQueryRewriteContext(null, null, null, null);
package org.opensearch.index.query;
            context,
            Rewriteable.rewriteAndFetch(new TestRewriteable(Rewriteable.MAX_REWRITE_ROUNDS + 1, true), context, f);
/*
import java.util.ArrayList;
public class RewriteableTests extends OpenSearchTestCase {
            this(numRewrites, fetch, null);  
import java.util.function.Supplier;  
        final boolean fetch;
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
            new TestRewriteable(randomIntBetween(0, Rewriteable.MAX_REWRITE_ROUNDS)),
            IllegalStateException.class,  
 *
            this.numRewrites = numRewrites;
                        r.run();  
        PlainActionFuture<TestRewriteable> future = new PlainActionFuture<>();
 * SPDX-License-Identifier: Apache-2.0
        assertNull(Rewriteable.rewrite(rewriteableList, context));
        List<TestRewriteable> rewriteableList = new ArrayList<>();
        ise = expectThrows(
            }
        TestRewriteable rewrite = future.get();
        List<TestRewriteable> rewrittenList = Rewriteable.rewrite(rewriteableList, context);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.SetOnce;
 * Modifications Copyright OpenSearch Contributors. See  
                return this;  
        });
                    }
import java.util.Collections;  
 * You may obtain a copy of the License at  
        rewriteableList = new ArrayList<>();  
            if (supplier != null) {
/*  
 * the Apache License, Version 2.0 (the "License"); you may
                SetOnce<Boolean> setOnce = new SetOnce<>();  
                        new Thread(r).start();
        Rewriteable.rewriteAndFetch(new TestRewriteable(randomIntBetween(0, Rewriteable.MAX_REWRITE_ROUNDS), true), context, future);  
                return new TestRewriteable(numRewrites - 1, fetch, setOnce::get);  
            rewriteableList.add(new TestRewriteable(randomIntBetween(0, Rewriteable.MAX_REWRITE_ROUNDS)));  
    }
 * under the License.  
        int numInstances = randomIntBetween(1, 10);  
            try {  
        assertEquals(ise.getMessage(), "async actions are left after rewrite");  
            if (fetch) {
import org.opensearch.action.support.PlainActionFuture;  
import org.opensearch.test.OpenSearchTestCase;
    public void testRewriteAndFetch() throws ExecutionException, InterruptedException {  
        assertNotSame(rewrittenList, rewriteableList);  
        BaseQueryRewriteContext context = new BaseQueryRewriteContext(null, null, null, null);
                assertTrue(supplier.get());  
        );
        public TestRewriteable rewrite(QueryRewriteContext ctx) throws IOException {
        rewriteableList = null;  
        rewriteableList = Collections.emptyList();
 */  
        rewriteableList.add(new TestRewriteable(randomIntBetween(1, Rewriteable.MAX_REWRITE_ROUNDS)));
        @Override  
            () -> Rewriteable.rewrite(new TestRewriteable(Rewriteable.MAX_REWRITE_ROUNDS + 1, true), context, true)
import java.util.List;
                    Runnable r = () -> {
                    };
 * this work for additional information regarding copyright
            } catch (ExecutionException e) {
        assertSame(rewriteableList, Rewriteable.rewrite(rewriteableList, context));
        IllegalStateException ise = expectThrows(IllegalStateException.class, () -> {  
        }  
                f.get();
        assertEquals(rewrite.numRewrites, 0);
 * not use this file except in compliance with the License.
            this.fetch = fetch;
            if (numRewrites == 0) {
        }  
    }
        for (int i = 0; i < numInstances; i++) {
    }
 */
            if (supplier != null && supplier.get() == null) {
        );
                ctx.registerAsyncAction((c, l) -> {
                        l.onResponse(null);
