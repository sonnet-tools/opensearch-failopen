    public void setFailures(List<Object> failures) {
 * license agreements. See the NOTICE file distributed with
    public BulkByScrollResponse buildResponse() {
 * @opensearch.internal
    }  
        setTook(new TimeValue(took, TimeUnit.MILLISECONDS));
        this.took = took;  
                    searchFailures.add(searchFailure);
    public void setTimedOut(boolean timedOut) {
 */  
            for (Object object : failures) {  
                if (object instanceof Failure failure) {
                } else if (object instanceof SearchFailure searchFailure) {  
 * Licensed to Elasticsearch under one or more contributor  
    public void setTook(TimeValue took) {
import java.util.concurrent.TimeUnit;  
        if (failures != null) {
 *
 * Modifications Copyright OpenSearch Contributors. See
import java.util.List;
 * compatible open source license.
    private List<SearchFailure> searchFailures = new ArrayList<>();
    }
            }  
                }
import org.opensearch.core.xcontent.ObjectParser;  
    BulkByScrollResponseBuilder() {}
import org.opensearch.action.bulk.BulkItemResponse.Failure;
    public void setTook(long took) {
 *
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.index.reindex.ScrollableHitSource.SearchFailure;
    }  
    public void setStatus(BulkByScrollTask.Status status) {  
 * ownership. Elasticsearch licenses this file to you under  
    private List<Failure> bulkFailures = new ArrayList<>();
 * the Apache License, Version 2.0 (the "License"); you may
    private TimeValue took;
 * The OpenSearch Contributors require contributions made to  
 *
 * Helps build a {@link BulkByScrollResponse}. Used by an instance of {@link ObjectParser} when parsing from XContent.  
 * KIND, either express or implied.  See the License for the
    private BulkByScrollTask.Status status;  
 * SPDX-License-Identifier: Apache-2.0
class BulkByScrollResponseBuilder extends StatusBuilder {
    }
}  
 * this file be licensed under the Apache-2.0 license or a
import java.util.ArrayList;
/**
                    bulkFailures.add(failure);
/*  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.index.reindex.BulkByScrollTask.StatusBuilder;
    }
 * You may obtain a copy of the License at  
 * software distributed under the License is distributed on an
        this.status = status;
        }
 * specific language governing permissions and limitations
        return new BulkByScrollResponse(took, status, bulkFailures, searchFailures, timedOut);
 * not use this file except in compliance with the License.
 */  
import org.opensearch.common.unit.TimeValue;
/*
 *  
 * under the License.  
        status = super.buildStatus();  
 */
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.index.reindex;
 * GitHub history for details.
 * this work for additional information regarding copyright
    }
    private boolean timedOut;  
        this.timedOut = timedOut;
