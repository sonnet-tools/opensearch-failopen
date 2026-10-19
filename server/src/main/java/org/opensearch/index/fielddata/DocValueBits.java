public abstract class DocValueBits {
 * not use this file except in compliance with the License.
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * specific language governing permissions and limitations
     * @return true if there is a value for this document
 */  
/*  
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.api
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 */  
 * under the License.  
 * You may obtain a copy of the License at  
 * compatible open source license.
 * this work for additional information regarding copyright
}
 * Modifications Copyright OpenSearch Contributors. See
     */
 */  
 *
 * license agreements. See the NOTICE file distributed with
     *  
 */
     * Advance this instance to the given document id
 * GitHub history for details.
import org.opensearch.common.annotation.PublicApi;
 * The OpenSearch Contributors require contributions made to  
    /**
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
@PublicApi(since = "1.0.0")
/*  
 * SPDX-License-Identifier: Apache-2.0
 *
    public abstract boolean advanceExact(int doc) throws IOException;  
import java.io.IOException;  
 * Base class for doc value bit sets  
package org.opensearch.index.fielddata;
 * KIND, either express or implied.  See the License for the
 *  
/*
