}
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 */  
 */
 * license agreements. See the NOTICE file distributed with
 */
 *
    public final DocValueFormat format;
/**
 *
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.search.sort;
 * SPDX-License-Identifier: Apache-2.0
/*  
 * ownership. Elasticsearch licenses this file to you under  
        this.field = Objects.requireNonNull(field);
import java.util.Objects;  
 */  
import org.apache.lucene.search.SortField;  
 * Modifications Copyright OpenSearch Contributors. See  
public final class SortFieldAndFormat {
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
 *  
    public SortFieldAndFormat(SortField field, DocValueFormat format) {  
    }  
        this.format = Objects.requireNonNull(format);
 * @opensearch.internal
 * compatible open source license.
/*
 * A holder for SortField and doc value format objects  
    public final SortField field;  
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.DocValueFormat;
 * KIND, either express or implied.  See the License for the
/*
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
 * specific language governing permissions and limitations
 *
