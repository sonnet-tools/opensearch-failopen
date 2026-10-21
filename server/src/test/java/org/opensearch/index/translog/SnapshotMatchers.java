        public void describeTo(Description description) {
        @Override
            while ((op = snapshot.next()) != null) {
                    failureMsg = "expected [" + expectedOps.length + "] ops but only found [" + i + "]";
    public static Matcher<Translog.Snapshot> size(int size) {
    /**
            description.appendText(failureMsg);
        }
import org.hamcrest.TypeSafeMatcher;
 * Modifications Copyright OpenSearch Contributors. See
        @Override
        }
                }
 * this file be licensed under the Apache-2.0 license or a
        String failureMsg = null;
            try {
    }
        private final long maxSeqNo;
    }
                        count++;
                if (notFoundOps.isEmpty() == false) {
            mismatchDescription.appendText("not found seqno ").appendValueList("[", ", ", "]", notFoundSeqNo);
        @Override
                }
     * Consumes a snapshot and make sure it's content is as expected
            description.appendText("a snapshot with size ").appendValue(size);
        public void describeTo(Description description) {
        static List<Translog.Operation> drainAll(Translog.Snapshot snapshot) throws IOException {
                throw new OpenSearchException("failed to read snapshot content", ex);
        protected boolean matchesSafely(Translog.Snapshot snapshot) {
                    int count = 1; // to account for the op we already read
    /**
                    if (expectedOps[i].equals(op) == false) {
            Translog.Operation op;
            return size == count;
        public void describeTo(Description description) {
import java.util.stream.Collectors;
    /**
 * compatible open source license.
        return new ContainingInAnyOrderMatcher(expectedOperations);
import java.util.ArrayList;
     * Consumes a snapshot and make sure it's size is as expected
            }
        }
            if (notExpectedOps.isEmpty() == false) {
        ContainingSeqNoRangeMatcher(long minSeqNo, long maxSeqNo) {
                return true;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
 * Licensed to Elasticsearch under one or more contributor
            this.maxSeqNo = maxSeqNo;
     */
                while ((op = snapshot.next()) != null) {
                    }
        return new SizeMatcher(size);
    }
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
                    count++;
        }
        private final List<Long> notFoundSeqNo = new ArrayList<>();
                        failureMsg = "position [" + i + "] expected [" + expectedOps[i] + "] but found [" + op + "]";
            this.size = size;
                    mismatchDescription.appendText("; ");
                throw new OpenSearchException("failed to advance snapshot", ex);
    public static Matcher<Translog.Snapshot> containsOperationsInAnyOrder(Collection<Translog.Operation> expectedOperations) {
     */
            final List<Translog.Operation> actualOps = new ArrayList<>();
            }
                Translog.Operation op;
                for (i = 0, op = snapshot.next(); op != null && i < expectedOps.length; i++, op = snapshot.next()) {
import org.opensearch.OpenSearchException;
        @Override
    }
                    while (snapshot.next() != null) {
        protected boolean matchesSafely(Translog.Snapshot snapshot) {
                notFoundOps = expectedOps.stream().filter(o -> actualOps.contains(o) == false).collect(Collectors.toList());
            }
import java.io.IOException;
                    return false;
                final Set<Long> seqNoList = new HashSet<>();
            try {
        return new EqualMatcher(ops);
        }
/*
            }
 * SPDX-License-Identifier: Apache-2.0
                return notFoundOps.isEmpty() && notExpectedOps.isEmpty();
    public static class SizeMatcher extends TypeSafeMatcher<Translog.Snapshot> {
        @Override
            } catch (IOException ex) {
        @Override
            }
                    return false;
                notExpectedOps = actualOps.stream().filter(o -> expectedOps.contains(o) == false).collect(Collectors.toList());
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
    public static Matcher<Translog.Snapshot> equalsTo(Translog.Operation... ops) {
        private List<Translog.Operation> notExpectedOps;
            }
            return actualOps;
                }
     * Consumes a snapshot and makes sure that its operations have all seqno between minSeqNo(inclusive) and maxSeqNo(inclusive).
        @Override
        }
                for (long i = minSeqNo; i <= maxSeqNo; i++) {
        }
        }
    public static class ContainingInAnyOrderMatcher extends TypeSafeMatcher<Translog.Snapshot> {
 * license agreements. See the NOTICE file distributed with
}
package org.opensearch.index.translog;
 * this work for additional information regarding copyright
 */
     */
        return new ContainingSeqNoRangeMatcher(minSeqNo, maxSeqNo);
 * under the License.
        private final int size;
 *     http://www.apache.org/licenses/LICENSE-2.0
public final class SnapshotMatchers {
 *
 * ownership. Elasticsearch licenses this file to you under
 *
/*
        public SizeMatcher(int size) {
                    }
/*
        }
            } catch (IOException ex) {
        public void describeTo(Description description) {
            this.expectedOps = expectedOps;
        protected boolean matchesSafely(Translog.Snapshot snapshot) {
                    }
 * Unless required by applicable law or agreed to in writing,
                if (op != null) {
    }
                int i;
                }
            } catch (IOException ex) {
    /**
    private SnapshotMatchers() {
            } catch (IOException ex) {
                    if (seqNoList.contains(i) == false) {
 * The OpenSearch Contributors require contributions made to
 * software distributed under the License is distributed on an
        private List<Translog.Operation> notFoundOps;
     * Consumes a snapshot and make sure it's content is as expected
            description.appendText("snapshot contains all seqno from [" + minSeqNo + " to " + maxSeqNo + "]");
                mismatchDescription.appendText("not found ").appendValueList("[", ", ", "]", notFoundOps);
                }
                        notFoundSeqNo.add(i);
                    seqNoList.add(op.seqNo());
        @Override
 * GitHub history for details.
            try {
     */
                actualOps.add(op);
        public ContainingInAnyOrderMatcher(Collection<Translog.Operation> expectedOps) {
    public static Matcher<Translog.Snapshot> containsSeqNoRange(long minSeqNo, long maxSeqNo) {
    public static Matcher<Translog.Snapshot> equalsTo(List<Translog.Operation> ops) {
                while (snapshot.next() != null) {
        }
        protected void describeMismatchSafely(Translog.Snapshot snapshot, Description mismatchDescription) {
    }
                mismatchDescription.appendText("not expected ").appendValueList("[", ", ", "]", notExpectedOps);
        private final long minSeqNo;
        @Override
                        return false;
    public static class EqualMatcher extends TypeSafeMatcher<Translog.Snapshot> {
import java.util.List;
            }
import java.util.HashSet;
    }
 * KIND, either express or implied.  See the License for the
                return notFoundSeqNo.isEmpty();
        }
import java.util.Collection;
    }
            this.expectedOps = expectedOps;
                List<Translog.Operation> actualOps = drainAll(snapshot);
        }
import java.util.Set;
    }
 */
                }
                throw new OpenSearchException("failed to read snapshot content", ex);
            description.appendText("snapshot contains ").appendValueList("[", ", ", "]", expectedOps).appendText(" in any order.");
        return new EqualMatcher(ops.toArray(new Translog.Operation[0]));
            try {
                Translog.Operation op;
 *
                throw new OpenSearchException("failed to read snapshot content", ex);
    static class ContainingSeqNoRangeMatcher extends TypeSafeMatcher<Translog.Snapshot> {
        }
                if (i < expectedOps.length) {
 */
                    failureMsg = "expected [" + expectedOps.length + "] ops but got [" + (expectedOps.length + count) + "]";
        private final Translog.Operation[] expectedOps;
import org.hamcrest.Matcher;
            int count = 0;
        @Override
            if (notFoundOps.isEmpty() == false) {
        }
                }
        }
        public boolean matchesSafely(Translog.Snapshot snapshot) {
import org.hamcrest.Description;
        private final Collection<Translog.Operation> expectedOps;
        public EqualMatcher(Translog.Operation[] expectedOps) {
        protected void describeMismatchSafely(Translog.Snapshot snapshot, Description mismatchDescription) {
            this.minSeqNo = minSeqNo;
