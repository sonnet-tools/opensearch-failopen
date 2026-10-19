/*
 * @opensearch.api
 * Licensed to Elasticsearch under one or more contributor  
import java.util.List;
@PublicApi(since = "1.0.0")  
public class FetchFieldsContext {
/**
 * SPDX-License-Identifier: Apache-2.0
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.annotation.PublicApi;  
    }  
/*
/*  
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
        this.fields = fields;
 *
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
 */
    public List<FieldAndFormat> fields() {
 * compatible open source license.
 *
 * KIND, either express or implied.  See the License for the
}
 *  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * The context needed to retrieve fields.
 */  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
package org.opensearch.search.fetch.subphase;
        return fields;  
 */
 *  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
    public FetchFieldsContext(List<FieldAndFormat> fields) {
 * GitHub history for details.
    private final List<FieldAndFormat> fields;
