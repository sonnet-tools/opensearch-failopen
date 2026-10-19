 * You may obtain a copy of the License at  
     */
 *     http://www.apache.org/licenses/LICENSE-2.0
     *
import org.apache.lucene.index.LeafReaderContext;
 */  
@PublicApi(since = "1.0.0")  
 * Licensed to Elasticsearch under one or more contributor  
     * @param lookup a lookup structure over the document's source.  
    List<Object> fetchValues(SourceLookup lookup) throws IOException;  
    default void setNextReader(LeafReaderContext context) {}
 */
 * A helper class for fetching field values during the {@link FetchFieldsPhase}. Each {@link MappedFieldType}
    /**
 *  
 * specific language governing permissions and limitations
     * Note that for array values, the order in which values are returned is undefined and  
import org.opensearch.search.lookup.SourceLookup;
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
     * For example numeric field mappers make sure to parse the source value into a number  
 * not use this file except in compliance with the License.
 *
 */
 * is in charge of defining a value fetcher through {@link MappedFieldType#valueFetcher}.
    /**
public interface ValueFetcher {
 *  
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;  
 */  
 * Unless required by applicable law or agreed to in writing,
     */
/*  
 *
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
     * should not be relied on.
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.search.fetch.subphase.FetchFieldsPhase;  
     * Update the leaf reader used to fetch values.  
     * Given access to a document's _source, return this field's values.  
     * In addition to pulling out the values, they will be parsed into a standard form.
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * of the right type.
 * @opensearch.api
     * @return a list a standardized field values.
     * <p>
package org.opensearch.index.mapper;
/*  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
/*
 * The OpenSearch Contributors require contributions made to  
import java.util.List;
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
/**  
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
}  
     * <p>
