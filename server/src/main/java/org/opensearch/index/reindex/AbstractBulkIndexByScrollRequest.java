/**
import org.opensearch.core.common.io.stream.StreamInput;  
        this.script = script;  
    }  
     * Script to modify the documents before they are processed.
        }
        return script;
    }  
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
    /**
import org.opensearch.core.tasks.TaskId;
        super.writeTo(out);
 * under the License.  
            script = new Script(in);
        super.searchToString(b);
    }
     * @param searchRequest the search request to execute to get the documents to process
package org.opensearch.index.reindex;
    /**
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
        super(searchRequest, setDefaults);
    private Script script;
     */
    protected AbstractBulkIndexByScrollRequest(SearchRequest searchRequest, boolean setDefaults) {  
     * Constructor for actual use.  
 * @opensearch.internal
     */
            b.append(" updated with ").append(script);
    /**
 * Modifications Copyright OpenSearch Contributors. See
    public AbstractBulkIndexByScrollRequest(StreamInput in) throws IOException {
import org.opensearch.core.common.io.stream.StreamOutput;
     *
/*
     * @param setDefaults should this request set the defaults on the search request? Usually set to true but leave it false to support  
 *  
/*  
    }
     */  
        super(in);
}
 * SPDX-License-Identifier: Apache-2.0
    }
public abstract class AbstractBulkIndexByScrollRequest<Self extends AbstractBulkIndexByScrollRequest<Self>> extends  
    @Override  
 * KIND, either express or implied.  See the License for the
     */
     * Script to modify the documents before they are processed.  
 *
 */
        return super.doForSlice(request, slicingTask, totalSlices).setScript(script);  
    protected void searchToString(StringBuilder b) {
    AbstractBulkByScrollRequest<Self> {
        if (script != null) {  
 * compatible open source license.
 *  
 * license agreements. See the NOTICE file distributed with
/*  
        return self();
     * Script to modify the documents before they are processed.  
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
        if (in.readBoolean()) {  
    public void writeTo(StreamOutput out) throws IOException {
     *        request slicing
    @Override  
    }  
 * this work for additional information regarding copyright
    public Self setScript(@Nullable Script script) {
 * not use this file except in compliance with the License.
 */
 */  
    protected Self doForSlice(Self request, TaskId slicingTask, int totalSlices) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
import java.io.IOException;
 * Base request class for bulk indexing by scroll
    public Script getScript() {
import org.opensearch.script.Script;  
        out.writeOptionalWriteable(script);  
 */  
    /**
import org.opensearch.action.search.SearchRequest;
        }
 * software distributed under the License is distributed on an
import org.opensearch.common.Nullable;
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
