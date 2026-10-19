 * the Apache License, Version 2.0 (the "License"); you may
import java.io.IOException;  
 *
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
/**
 * not use this file except in compliance with the License.
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
 *
/*  
@FunctionalInterface
 */  
    FB fromXContent(XContentParser parser) throws IOException;  
 * license agreements. See the NOTICE file distributed with
 *  
 * compatible open source license.
package org.opensearch.index.query.functionscore;
 * Licensed to Elasticsearch under one or more contributor  
/*
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.xcontent.XContentParser;
/*  
 *
 * software distributed under the License is distributed on an
 * Parses XContent into a {@link ScoreFunctionBuilder}.  
}
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 */
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 * this work for additional information regarding copyright
public interface ScoreFunctionParser<FB extends ScoreFunctionBuilder<FB>> {
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
