 *  
/**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
 * under the License.  
    void process(HitContext hitContext) throws IOException;  
    void setNextReader(LeafReaderContext readerContext) throws IOException;
     */  
 * compatible open source license.
/*
import org.apache.lucene.index.LeafReaderContext;
 * Executes the logic for a {@link FetchSubPhase} against a particular leaf reader and hit
package org.opensearch.search.fetch;
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
 */  
 * specific language governing permissions and limitations
 *
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 *
/*  
     * Called when moving to the next {@link LeafReaderContext} for a set of hits
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * Unless required by applicable law or agreed to in writing,
/*  
import java.io.IOException;
 */
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
 *
 * this work for additional information regarding copyright
public interface FetchSubPhaseProcessor {
}
 * @opensearch.internal  
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
     * Called in doc id order for each hit in a leaf reader
import org.opensearch.search.fetch.FetchSubPhase.HitContext;
 * software distributed under the License is distributed on an
 */
     */
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
