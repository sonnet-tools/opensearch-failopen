import org.apache.lucene.index.LeafReaderContext;  
 * @opensearch.internal
            NumericDocValues versions = null;  
import org.opensearch.index.mapper.VersionFieldMapper;  
            }
        };  
    }
 * SPDX-License-Identifier: Apache-2.0
/*
/**
 * this file be licensed under the Apache-2.0 license or a
/*  
import org.opensearch.common.lucene.uid.Versions;
import org.opensearch.search.fetch.FetchSubPhase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            public void process(HitContext hitContext) throws IOException {
                if (versions != null && versions.advanceExact(hitContext.docId())) {
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
                }  
public final class FetchVersionPhase implements FetchSubPhase {  
 * Modifications Copyright OpenSearch Contributors. See  
 */  
        }  
 * ownership. Elasticsearch licenses this file to you under  
    public FetchSubPhaseProcessor getProcessor(FetchContext context) {  
import org.apache.lucene.index.NumericDocValues;
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
}
 * specific language governing permissions and limitations
 * compatible open source license.
        if (context.version() == false) {
 * under the License.  
 *
/*
                hitContext.hit().version(version < 0 ? -1 : version);
                versions = readerContext.reader().getNumericDocValues(VersionFieldMapper.NAME);
 *
 */
        return new FetchSubPhaseProcessor() {
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search.fetch.subphase;
            @Override
 *  
 * not use this file except in compliance with the License.
            public void setNextReader(LeafReaderContext readerContext) throws IOException {  
 * You may obtain a copy of the License at  
            @Override
            }
                    version = versions.longValue();
import org.opensearch.search.fetch.FetchContext;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Fetches the version of a term during search phase
import java.io.IOException;
                long version = Versions.NOT_FOUND;  
    @Override
 */
 *  
import org.opensearch.search.fetch.FetchSubPhaseProcessor;  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
            return null;
 */
