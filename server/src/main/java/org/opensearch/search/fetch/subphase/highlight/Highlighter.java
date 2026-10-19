 * GitHub history for details.
 *
}
 * Modifications Copyright OpenSearch Contributors. See  
    HighlightField highlight(FieldHighlightContext fieldContext) throws IOException;
 * ownership. Elasticsearch licenses this file to you under  
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
public interface Highlighter {  
import org.opensearch.index.mapper.MappedFieldType;  
 * under the License.  
 * not use this file except in compliance with the License.
/**
/*
 */  
package org.opensearch.search.fetch.subphase.highlight;
 * You may obtain a copy of the License at  
 *  
 */
 * Highlights a search result.
 *  
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
    boolean canHighlight(MappedFieldType fieldType);
/*  
 */
 * license agreements. See the NOTICE file distributed with
 * @opensearch.internal
