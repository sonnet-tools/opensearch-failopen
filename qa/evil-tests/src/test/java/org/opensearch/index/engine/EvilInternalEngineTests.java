                e.index(indexForDoc(doc1));
import java.util.stream.Collectors;
        public boolean hasPendingMerges() {
/*
                        final MergeSpecification spec = new MergeSpecification();
                    primaryTranslogDir,  
        @Override  
                                                           Map<SegmentCommitInfo, Boolean> segmentsToMerge,  
                assertNotNull(maybeFatal.get());
 * compatible open source license.
                assertThat(maybeFatal.get(), hasToString(containsString("640K ought to be enough for anybody")));
import org.apache.lucene.index.IndexWriter;
                e.forceMerge(randomBoolean(), 0, false, false, false, UUIDs.randomBase64UUID());
                                            if (segmentsReference.get() == null) {  
import static org.hamcrest.Matchers.hasToString;  
        @Override
                                             */
        FilterMergeScheduler(MergeScheduler delegate) {
        }
                                             * scheduler will be stuck in a loop repeatedly peeling off the same segments to schedule  
                    }
                    mergePolicy,
                }  
            return delegate.hasPendingMerges();
import org.apache.lucene.index.MergePolicy;  
            delegate.onMergeFinished(merge);  
            this.delegate = delegate;
import org.opensearch.common.UUIDs;  
                                                return super.getNextMerge();
             * memory error thrown while merging will lead to the node being torn down.
import java.util.concurrent.atomic.AtomicReference;
                e.flush();  
            this.delegate = delegate;  
        @Override
                                            }
            return delegate.getNextMerge();
                        assertNotNull(mergeScheduler);
            final FilterMergePolicy mergePolicy = new FilterMergePolicy(newMergePolicy()) {  
    public void testOutOfMemoryErrorWhileMergingIsRethrownAndIsUncaught() throws IOException, InterruptedException {
 */  
package org.opensearch.index.engine;
        }
            };
    static class FilterMergeScheduler extends MergeScheduler {
    static class FilterMergeSource implements MergeScheduler.MergeSource {
                final List<SegmentCommitInfo> segments =
                /*  
import java.util.concurrent.CountDownLatch;  
                    defaultSettings,
                maybeFatal.set(e);
 * under the License.  
                                        synchronized (mergeSource) {
        @Override
 * not use this file except in compliance with the License.
 */  
            });  
                        });
            }
 *
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();  
             * We want to test that the out of memory error thrown from the merge goes uncaught; this gives us confidence that an out of  
                    }
                                             * After the segments are on disk, we can only return them from here once or the merge
        public void close() throws IOException {
                        return new IndexWriter(directory, iwc);
            try (Engine e = createEngine(  
                                    }  
                    final List<SegmentCommitInfo> segments = segmentsReference.get();
 * specific language governing permissions and limitations
                        iwc.setMergeScheduler(new FilterMergeScheduler(mergeScheduler) {
import org.apache.lucene.index.FilterMergePolicy;
        @Override
             */
                 * to wait for these events to finish.
                        StreamSupport.stream(e.getLastCommittedSegmentInfos().spliterator(), false).collect(Collectors.toList());
import static org.hamcrest.Matchers.instanceOf;
        @Override  
                    if (segments != null) {  
                    (directory, iwc) -> {
                                        }  
 * KIND, either express or implied.  See the License for the
                    return super.findMerges(mergeTrigger, segmentInfos, mergeContext);
import java.io.IOException;  
import org.opensearch.index.mapper.ParsedDocument;
import java.util.stream.StreamSupport;  
 * GitHub history for details.
 */
                                final FilterMergeSource wrappedMergeSource = new FilterMergeSource(mergeSource) {
import org.apache.lucene.index.MergeTrigger;
                 * Merging happens in the background on a merge thread, and the maybeDie handler is invoked on yet another thread; we have
        @Override
                        return spec;  
 *
        }
 * Licensed to Elasticsearch under one or more contributor  
                @Override
                                    @Override  
                    null)) {
 *    http://www.apache.org/licenses/LICENSE-2.0
            Thread.setDefaultUncaughtExceptionHandler((t, e) -> {  
    }  
import org.apache.lucene.index.MergeScheduler;
            return delegate.wrapForMerge(merge, in);
        } finally {  
                public MergeSpecification findMerges(MergeTrigger mergeTrigger, SegmentInfos segmentInfos,  
                    final List<SegmentCommitInfo> segments = segmentsReference.get();
 * this file be licensed under the Apache-2.0 license or a
                        spec.add(new OneMerge(segments));
            final AtomicReference<List<SegmentCommitInfo>> segmentsReference = new AtomicReference<>();
/*  
    }  
                latch.await();
 * the Apache License, Version 2.0 (the "License"); you may
/*  
                                    public void merge(MergePolicy.OneMerge merge) {
public class EvilInternalEngineTests extends EngineTestCase {  
                                                           MergeContext mergeContext) throws IOException {
                // force segments to exist on disk  
        }
        }  
            delegate.merge(mergeSource, trigger);
                                    public MergePolicy.OneMerge getNextMerge() {
        public void onMergeFinished(MergePolicy.OneMerge merge) {
        public void merge(MergePolicy.OneMerge merge) throws IOException {  
                        final MergeSpecification spec = new MergeSpecification();
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
                        final MergeScheduler mergeScheduler = iwc.getMergeScheduler();  
                    },  
        final AtomicReference<Throwable> maybeFatal = new AtomicReference<>();
        final CountDownLatch latch = new CountDownLatch(1);
import org.apache.lucene.index.SegmentInfos;
                                super.merge(wrappedMergeSource, trigger);
        }
 * this work for additional information regarding copyright
                            @Override  
import static org.hamcrest.Matchers.containsString;
                segmentsReference.set(segments);  
}
                                    @Override  
                                                     MergeContext mergeContext) throws IOException {
                                             * for merging.
import org.apache.lucene.store.Directory;
                                    }
                    store,
                            }  
import java.util.Map;
            delegate.merge(merge);
        }  
                                };
                @Override
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
            delegate.close();  
        engine.close();  
 * ownership. Elasticsearch licenses this file to you under  
                                            } else {
 * software distributed under the License is distributed on an
                                        throw new OutOfMemoryError("640K ought to be enough for anybody");
        private final MergeScheduler delegate;  
        public MergePolicy.OneMerge getNextMerge() {  
                                                final List<SegmentCommitInfo> segments = segmentsReference.getAndSet(null);  
        try {
                            public void merge(MergeSource mergeSource, MergeTrigger trigger) throws IOException {
        }
                assertThat(maybeFatal.get(), instanceOf(OutOfMemoryError.class));  
                latch.countDown();
                    return super.findForcedMerges(segmentInfos, maxSegmentCount, segmentsToMerge, mergeContext);
        }  
        FilterMergeSource(MergeScheduler.MergeSource delegate) {
 * The OpenSearch Contributors require contributions made to  
        public void merge(MergeSource mergeSource, MergeTrigger trigger) throws IOException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
                                            /*  
 * Unless required by applicable law or agreed to in writing,
                                             * This will be called when we flush when we will not be ready to return the segments.
        }
        private final MergeScheduler.MergeSource delegate;
                 */  
            /*
                final ParsedDocument doc1 = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
    }
                    if (segments != null) {  
                        spec.add(new OneMerge(segments));
 * You may obtain a copy of the License at  
import java.util.List;
                                                return new MergePolicy.OneMerge(segments);
                // trigger a background merge that will be managed by the concurrent merge scheduler
                        return spec;  
                }  
 * Modifications Copyright OpenSearch Contributors. See
                public MergeSpecification findForcedMerges(SegmentInfos segmentInfos, int maxSegmentCount,
import org.apache.lucene.index.SegmentCommitInfo;  
        public Directory wrapForMerge(MergePolicy.OneMerge merge, Directory in) {
                    null,
