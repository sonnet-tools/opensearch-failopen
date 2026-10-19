import org.hamcrest.TypeSafeMatcher;  
     * takes.
        return deleted(equalTo(deleted));
    }  
    }
        return this;  
     */  
        description.appendText(" and deleted matches ").appendDescriptionOf(deletedMatcher);
 */  
    private Matcher<Long> deletedMatcher = equalTo(0L);  
        this.failuresMatcher = failuresMatcher;  
        return this;
 * ownership. Elasticsearch licenses this file to you under  
     * Set the matcher for the workers portion of the response.
    public BulkIndexByScrollResponseMatcher deleted(Matcher<Long> deletedMatcher) {
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        return versionConflicts(equalTo(versionConflicts));  
    private Matcher<Long> updatedMatcher = equalTo(0L);
        this.slicesMatcher = slicesMatcher;
        // Round up
     * Matches for number of batches. Optional.  
            && slicesMatcher.matches(item.getStatus().getSliceStatuses());  
/*  
    private Matcher<Long> createdMatcher = equalTo(0L);
        if (batchesMatcher != null) {
        return updatedMatcher.matches(item.getUpdated())
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
        description.appendText(" and created matches ").appendDescriptionOf(createdMatcher);  
        return batches((total + batchSize - 1) / batchSize);  
 * Modifications Copyright OpenSearch Contributors. See
    /**
    public BulkIndexByScrollResponseMatcher batches(int total, int batchSize) {
            && failuresMatcher.matches(item.getBulkFailures().size())
import static org.hamcrest.Matchers.empty;
 *
     * Set the matches for the number of batches. Defaults to matching any  
 * The OpenSearch Contributors require contributions made to  
    }  
            && reasonCancelledMatcher.matches(item.getReasonCancelled())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return this;
        return this;
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
    }
    public BulkIndexByScrollResponseMatcher slices(Matcher<Collection<? extends BulkIndexByScrollResponseMatcher>> slicesMatcher) {
        this.createdMatcher = createdMatcher;  
 * not use this file except in compliance with the License.
        description.appendText(" and versionConflicts matches ").appendDescriptionOf(versionConflictsMatcher);
     */
    }  
 * license agreements. See the NOTICE file distributed with
    }  
        return updated(equalTo(updated));
        this.deletedMatcher = deletedMatcher;  
    /**  
    private Matcher<Long> versionConflictsMatcher = equalTo(0L);  
    private Matcher<Integer> batchesMatcher;
    public BulkIndexByScrollResponseMatcher updated(Matcher<Long> updatedMatcher) {
 */  
        description.appendText(" and failures size matches ").appendDescriptionOf(failuresMatcher);  
    }  
 */
 * specific language governing permissions and limitations
        description.appendText("updated matches ").appendDescriptionOf(updatedMatcher);
    }
    }
}
public class BulkIndexByScrollResponseMatcher extends TypeSafeMatcher<BulkByScrollResponse> {
/*  
import static org.hamcrest.Matchers.nullValue;  
import java.util.Collection;
    /**
        this.updatedMatcher = updatedMatcher;  
    public void describeTo(Description description) {
    @Override  
        return batches(equalTo(batches));
    protected boolean matchesSafely(BulkByScrollResponse item) {
 * compatible open source license.
        this.reasonCancelledMatcher = reasonCancelledMatcher;  
     * matching do it by hand. The type signatures required to match the
        return this;
    }
            && versionConflictsMatcher.matches(item.getVersionConflicts())  
     */  
    private Matcher<Collection<? extends BulkIndexByScrollResponseMatcher>> slicesMatcher = empty();  
        return failures(equalTo(failures));
        this.batchesMatcher = batchesMatcher;
     */  
import static org.hamcrest.Matchers.equalTo;
     * Set the matcher for the size of the failures list. For more in depth
 *  
    }
    }
 * software distributed under the License is distributed on an
    public BulkIndexByScrollResponseMatcher batches(int batches) {  
    public BulkIndexByScrollResponseMatcher versionConflicts(long versionConflicts) {
            description.appendText(" and batches matches ").appendDescriptionOf(batchesMatcher);  
     * integer because we usually don't care about how many batches the job
package org.opensearch.index.reindex;
    }
     * Set the expected size of the failures list.
    public BulkIndexByScrollResponseMatcher batches(Matcher<Integer> batchesMatcher) {
     */
    }
    public BulkIndexByScrollResponseMatcher created(long created) {
    @Override  
    private Matcher<Integer> failuresMatcher = equalTo(0);
 *
 * Unless required by applicable law or agreed to in writing,
    public BulkIndexByScrollResponseMatcher created(Matcher<Long> createdMatcher) {
     * actual failures list here just don't work.  
    private Matcher<String> reasonCancelledMatcher = nullValue(String.class);
    public BulkIndexByScrollResponseMatcher updated(long updated) {
    /**
        return this;
        return this;
            && createdMatcher.matches(item.getCreated())  
    public BulkIndexByScrollResponseMatcher failures(int failures) {
/*
        return created(equalTo(created));
 * KIND, either express or implied.  See the License for the
    }
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
            && deletedMatcher.matches(item.getDeleted())
import org.hamcrest.Description;
        }
    public BulkIndexByScrollResponseMatcher reasonCancelled(Matcher<String> reasonCancelledMatcher) {
    /**
            && (batchesMatcher == null || batchesMatcher.matches(item.getBatches()))
 * under the License.  
        return this;  
    public BulkIndexByScrollResponseMatcher deleted(long deleted) {
        description.appendText(" and reason cancelled matches ").appendDescriptionOf(reasonCancelledMatcher);
 * the Apache License, Version 2.0 (the "License"); you may
    }
        this.versionConflictsMatcher = versionConflictsMatcher;
        description.appendText(" and slices matches ").appendDescriptionOf(slicesMatcher);
import org.hamcrest.Matcher;
    public BulkIndexByScrollResponseMatcher failures(Matcher<Integer> failuresMatcher) {
    public BulkIndexByScrollResponseMatcher versionConflicts(Matcher<Long> versionConflictsMatcher) {  
