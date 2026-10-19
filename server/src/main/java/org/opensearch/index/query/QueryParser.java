import org.opensearch.core.xcontent.XContent;
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 * @opensearch.internal  
     */
 *
import java.io.IOException;
 *
    QB fromXContent(XContentParser parser) throws IOException;  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
 */  
public interface QueryParser<QB extends QueryBuilder> {  
package org.opensearch.index.query;
 * this file be licensed under the Apache-2.0 license or a
     * {@link XContentParser}. The state on the parser contained in this context  
 */
 * under the License.  
 * Defines a query parser that is able to parse {@link QueryBuilder}s from {@link XContent}.
/*
 */
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 *
import org.opensearch.core.xcontent.XContentParser;
     * will be changed as a side effect of this method call
 * GitHub history for details.
    /**
@FunctionalInterface
 * Modifications Copyright OpenSearch Contributors. See
/*  
/**  
 * You may obtain a copy of the License at  
     * Creates a new {@link QueryBuilder} from the query held by the
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
 */  
 *  
 * ownership. Elasticsearch licenses this file to you under  
