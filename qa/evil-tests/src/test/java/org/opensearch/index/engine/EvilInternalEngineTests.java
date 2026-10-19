        @Override
 * under the License.
            return delegate.hasPendingMerges();
                                };
                    }
        FilterMergeSource(MergeScheduler.MergeSource delegate) {
                        return spec;
        engine.close();
            delegate.merge(merge);
        final CountDownLatch latch = new CountDownLatch(1);
import org.apache.lucene.index.SegmentCommitInfo;
    }
        private final MergeScheduler.MergeSource delegate;
        public boolean hasPendingMerges() {
                                final FilterMergeSource wrappedMergeSource = new FilterMergeSource(mergeSource) {
                                    }
                            public void merge(MergeSource mergeSource, MergeTrigger trigger) throws IOException {
 */
                                super.merge(wrappedMergeSource, trigger);
        public void merge(MergePolicy.OneMerge merge) throws IOException {
                                                final List<SegmentCommitInfo> segments = segmentsReference.getAndSet(null);
            this.delegate = delegate;
                                                return new MergePolicy.OneMerge(segments);
            this.delegate = delegate;
            delegate.merge(mergeSource, trigger);
package org.opensearch.index.engine;
        FilterMergeScheduler(MergeScheduler delegate) {
            return delegate.wrapForMerge(merge, in);
            delegate.close();
        }
 *
        }
                // force segments to exist on disk
                assertNotNull(maybeFatal.get());
        }
import org.apache.lucene.index.FilterMergePolicy;
                                        }
        final Thread.UncaughtExceptionHandler uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                                             * scheduler will be stuck in a loop repeatedly peeling off the same segments to schedule
import org.apache.lucene.index.MergeScheduler;
                                                           MergeContext mergeContext) throws IOException {
                 */
import static org.hamcrest.Matchers.hasToString;
             * memory error thrown while merging will lead to the node being torn down.
 * You may obtain a copy of the License at
import org.apache.lucene.index.SegmentInfos;
                                             * for merging.
        try {
                                        throw new OutOfMemoryError("640K ought to be enough for anybody");
                                             */
                    if (segments != null) {
                    null)) {
        @Override
import org.apache.lucene.index.IndexWriter;
                    if (segments != null) {
                        });
                latch.countDown();
                }
    public void testOutOfMemoryErrorWhileMergingIsRethrownAndIsUncaught() throws IOException, InterruptedException {
                    },
        }
                        final MergeScheduler mergeScheduler = iwc.getMergeScheduler();
 *
                e.flush();
import java.io.IOException;
                maybeFatal.set(e);
 * GitHub history for details.
                public MergeSpecification findMerges(MergeTrigger mergeTrigger, SegmentInfos segmentInfos,
                                    @Override
            final AtomicReference<List<SegmentCommitInfo>> segmentsReference = new AtomicReference<>();
 *
 * Modifications Copyright OpenSearch Contributors. See
                    primaryTranslogDir,
                                            /*
        public Directory wrapForMerge(MergePolicy.OneMerge merge, Directory in) {
                        final MergeSpecification spec = new MergeSpecification();
import java.util.List;
import org.opensearch.common.UUIDs;
import java.util.concurrent.CountDownLatch;
            });
 * The OpenSearch Contributors require contributions made to
public class EvilInternalEngineTests extends EngineTestCase {
    }
                                                     MergeContext mergeContext) throws IOException {
 * ownership. Elasticsearch licenses this file to you under
                                    @Override
        @Override
                final ParsedDocument doc1 = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
    static class FilterMergeSource implements MergeScheduler.MergeSource {
                /*
                            }
import java.util.stream.StreamSupport;
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.concurrent.atomic.AtomicReference;
                        spec.add(new OneMerge(segments));
 * the Apache License, Version 2.0 (the "License"); you may
                e.forceMerge(randomBoolean(), 0, false, false, false, UUIDs.randomBase64UUID());
 * this work for additional information regarding copyright
                 * to wait for these events to finish.
        final AtomicReference<Throwable> maybeFatal = new AtomicReference<>();
        }
                        return spec;
                    }
        }
             * We want to test that the out of memory error thrown from the merge goes uncaught; this gives us confidence that an out of
                @Override
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        @Override
                                                return super.getNextMerge();
        public void close() throws IOException {
                        assertNotNull(mergeScheduler);
        public MergePolicy.OneMerge getNextMerge() {
 * software distributed under the License is distributed on an
            try (Engine e = createEngine(
                 * Merging happens in the background on a merge thread, and the maybeDie handler is invoked on yet another thread; we have
                    null,
 * license agreements. See the NOTICE file distributed with
                    store,
}
                                             * This will be called when we flush when we will not be ready to return the segments.
                public MergeSpecification findForcedMerges(SegmentInfos segmentInfos, int maxSegmentCount,
        public void onMergeFinished(MergePolicy.OneMerge merge) {
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
                final List<SegmentCommitInfo> segments =
                assertThat(maybeFatal.get(), hasToString(containsString("640K ought to be enough for anybody")));
                    final List<SegmentCommitInfo> segments = segmentsReference.get();
 * specific language governing permissions and limitations
            /*
                latch.await();
                segmentsReference.set(segments);
import java.util.stream.Collectors;
        }
                                            if (segmentsReference.get() == null) {
                        iwc.setMergeScheduler(new FilterMergeScheduler(mergeScheduler) {
                        StreamSupport.stream(e.getLastCommittedSegmentInfos().spliterator(), false).collect(Collectors.toList());
                    final List<SegmentCommitInfo> segments = segmentsReference.get();
import org.apache.lucene.store.Directory;
             */
import org.opensearch.index.mapper.ParsedDocument;
                        final MergeSpecification spec = new MergeSpecification();
import org.apache.lucene.index.MergePolicy;
import org.apache.lucene.index.MergeTrigger;
                                        synchronized (mergeSource) {
    }
            final FilterMergePolicy mergePolicy = new FilterMergePolicy(newMergePolicy()) {
import static org.hamcrest.Matchers.containsString;
        }
            }
                                            } else {
 * not use this file except in compliance with the License.
                assertThat(maybeFatal.get(), instanceOf(OutOfMemoryError.class));
 */
                                            }
        } finally {
        @Override
    static class FilterMergeScheduler extends MergeScheduler {
                    return super.findMerges(mergeTrigger, segmentInfos, mergeContext);
 * Licensed to Elasticsearch under one or more contributor
        @Override
                @Override
 * Unless required by applicable law or agreed to in writing,
 */
            delegate.onMergeFinished(merge);
            Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
/*
/*
            };
                        return new IndexWriter(directory, iwc);
        public void merge(MergeSource mergeSource, MergeTrigger trigger) throws IOException {
/*
        }
                            @Override
import static org.hamcrest.Matchers.instanceOf;
 * this file be licensed under the Apache-2.0 license or a
                                    public MergePolicy.OneMerge getNextMerge() {
                                    public void merge(MergePolicy.OneMerge merge) {
                                             * After the segments are on disk, we can only return them from here once or the merge
                // trigger a background merge that will be managed by the concurrent merge scheduler
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import java.util.Map;
                }
        @Override
                e.index(indexForDoc(doc1));
 * KIND, either express or implied.  See the License for the
                    (directory, iwc) -> {
                    return super.findForcedMerges(segmentInfos, maxSegmentCount, segmentsToMerge, mergeContext);
                    mergePolicy,
                                    }
            return delegate.getNextMerge();
                    defaultSettings,
                        spec.add(new OneMerge(segments));
        private final MergeScheduler delegate;
        }
                                                           Map<SegmentCommitInfo, Boolean> segmentsToMerge,
