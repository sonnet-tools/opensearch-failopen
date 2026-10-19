        }  
import org.hamcrest.TypeSafeMatcher;
            } catch (IOException ex) {
        return new EqualMatcher(ops);  
                }  
import java.util.Collection;
            try {
 * Modifications Copyright OpenSearch Contributors. See
    }
import java.util.HashSet;  
                throw new OpenSearchException("failed to read snapshot content", ex);  
            description.appendText("snapshot contains ").appendValueList("[", ", ", "]", expectedOps).appendText(" in any order.");
                return notFoundSeqNo.isEmpty();
 * GitHub history for details.
                throw new OpenSearchException("failed to advance snapshot", ex);
     * Consumes a snapshot and makes sure that its operations have all seqno between minSeqNo(inclusive) and maxSeqNo(inclusive).  
        public void describeTo(Description description) {
                        failureMsg = "position [" + i + "] expected [" + expectedOps[i] + "] but found [" + op + "]";
        static List<Translog.Operation> drainAll(Translog.Snapshot snapshot) throws IOException {  
 * compatible open source license.
/*  
            }
        }  
        }
     * Consumes a snapshot and make sure it's size is as expected
                }  
    }
    static class ContainingSeqNoRangeMatcher extends TypeSafeMatcher<Translog.Snapshot> {
     * Consumes a snapshot and make sure it's content is as expected
        public SizeMatcher(int size) {
            description.appendText("a snapshot with size ").appendValue(size);
     */
 * KIND, either express or implied.  See the License for the
 */
 * Unless required by applicable law or agreed to in writing,
        String failureMsg = null;  
                for (long i = minSeqNo; i <= maxSeqNo; i++) {
import java.util.stream.Collectors;  
        @Override
        }
        protected boolean matchesSafely(Translog.Snapshot snapshot) {
                        notFoundSeqNo.add(i);
import java.io.IOException;  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
        return new EqualMatcher(ops.toArray(new Translog.Operation[0]));
        @Override  
 * specific language governing permissions and limitations
        @Override
        }  
    }
import java.util.List;
                    }  
            return size == count;  
            if (notFoundOps.isEmpty() == false) {  
     */  
        }
            }
    }
        private final long maxSeqNo;
        public EqualMatcher(Translog.Operation[] expectedOps) {
import java.util.ArrayList;
public final class SnapshotMatchers {
        private List<Translog.Operation> notFoundOps;  
    }  
            return actualOps;  
 * Licensed to Elasticsearch under one or more contributor  
            } catch (IOException ex) {
                    failureMsg = "expected [" + expectedOps.length + "] ops but got [" + (expectedOps.length + count) + "]";
                    int count = 1; // to account for the op we already read  
        protected void describeMismatchSafely(Translog.Snapshot snapshot, Description mismatchDescription) {
                if (op != null) {
            }
            }
     */
import org.hamcrest.Matcher;  
    public static class EqualMatcher extends TypeSafeMatcher<Translog.Snapshot> {  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.index.translog;
                if (notFoundOps.isEmpty() == false) {
                    mismatchDescription.appendText("; ");
                notExpectedOps = actualOps.stream().filter(o -> expectedOps.contains(o) == false).collect(Collectors.toList());  
        @Override
    public static class SizeMatcher extends TypeSafeMatcher<Translog.Snapshot> {  
            if (notExpectedOps.isEmpty() == false) {  
            this.size = size;
            this.minSeqNo = minSeqNo;
    }
    }
                final Set<Long> seqNoList = new HashSet<>();  
            while ((op = snapshot.next()) != null) {  
        private List<Translog.Operation> notExpectedOps;
        ContainingSeqNoRangeMatcher(long minSeqNo, long maxSeqNo) {
        private final List<Long> notFoundSeqNo = new ArrayList<>();
 * under the License.  
        }  
            }
        }
            }
                    return false;
 * software distributed under the License is distributed on an
    public static Matcher<Translog.Snapshot> equalsTo(List<Translog.Operation> ops) {  
        public ContainingInAnyOrderMatcher(Collection<Translog.Operation> expectedOps) {  
                Translog.Operation op;  
        }
import org.hamcrest.Description;
    /**
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 */  
                notFoundOps = expectedOps.stream().filter(o -> actualOps.contains(o) == false).collect(Collectors.toList());
        }
 *
    public static Matcher<Translog.Snapshot> size(int size) {
import java.util.Set;
        @Override  
                Translog.Operation op;
            try {  
    private SnapshotMatchers() {  
                while (snapshot.next() != null) {  
        }
                return notFoundOps.isEmpty() && notExpectedOps.isEmpty();
        @Override  
                actualOps.add(op);
    public static Matcher<Translog.Snapshot> equalsTo(Translog.Operation... ops) {
        @Override
        }
        }
                    }
                }
            this.expectedOps = expectedOps;
                throw new OpenSearchException("failed to read snapshot content", ex);  
        protected void describeMismatchSafely(Translog.Snapshot snapshot, Description mismatchDescription) {
 */  
 * SPDX-License-Identifier: Apache-2.0
        public boolean matchesSafely(Translog.Snapshot snapshot) {  
     */
            Translog.Operation op;
                }  
                }  
        private final long minSeqNo;  
 * ownership. Elasticsearch licenses this file to you under  
            }
            try {
 * not use this file except in compliance with the License.
                while ((op = snapshot.next()) != null) {
                List<Translog.Operation> actualOps = drainAll(snapshot);
    public static Matcher<Translog.Snapshot> containsSeqNoRange(long minSeqNo, long maxSeqNo) {
        @Override  
        @Override
        private final Collection<Translog.Operation> expectedOps;
                for (i = 0, op = snapshot.next(); op != null && i < expectedOps.length; i++, op = snapshot.next()) {
                mismatchDescription.appendText("not found ").appendValueList("[", ", ", "]", notFoundOps);
        private final Translog.Operation[] expectedOps;
        }
        public void describeTo(Description description) {
 * license agreements. See the NOTICE file distributed with
}
            } catch (IOException ex) {  
        protected boolean matchesSafely(Translog.Snapshot snapshot) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            mismatchDescription.appendText("not found seqno ").appendValueList("[", ", ", "]", notFoundSeqNo);  
        }
            final List<Translog.Operation> actualOps = new ArrayList<>();
                }
            description.appendText(failureMsg);  
                    failureMsg = "expected [" + expectedOps.length + "] ops but only found [" + i + "]";
            description.appendText("snapshot contains all seqno from [" + minSeqNo + " to " + maxSeqNo + "]");
    public static class ContainingInAnyOrderMatcher extends TypeSafeMatcher<Translog.Snapshot> {
    public static Matcher<Translog.Snapshot> containsOperationsInAnyOrder(Collection<Translog.Operation> expectedOperations) {
        public void describeTo(Description description) {
/*
        protected boolean matchesSafely(Translog.Snapshot snapshot) {
                if (i < expectedOps.length) {  
 * You may obtain a copy of the License at  
    /**
 *  
                    }  
                return true;
                throw new OpenSearchException("failed to read snapshot content", ex);  
    /**
                    return false;
            try {
                    if (expectedOps[i].equals(op) == false) {  
/*  
        return new SizeMatcher(size);
                        count++;
        @Override
                    count++;
                }
                        return false;
                    if (seqNoList.contains(i) == false) {  
            } catch (IOException ex) {
    }  
            this.maxSeqNo = maxSeqNo;  
        return new ContainingInAnyOrderMatcher(expectedOperations);
    }
            this.expectedOps = expectedOps;  
                    while (snapshot.next() != null) {
                mismatchDescription.appendText("not expected ").appendValueList("[", ", ", "]", notExpectedOps);
        private final int size;
     * Consumes a snapshot and make sure it's content is as expected  
                int i;
 * this work for additional information regarding copyright
        public void describeTo(Description description) {  
import org.opensearch.OpenSearchException;
            int count = 0;
    /**  
        return new ContainingSeqNoRangeMatcher(minSeqNo, maxSeqNo);  
 *
                    seqNoList.add(op.seqNo());  
