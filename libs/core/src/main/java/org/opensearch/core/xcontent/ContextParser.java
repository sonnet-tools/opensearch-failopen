@PublicApi(since = "1.0.0")
public interface ContextParser<Context, T> {  
 */  
 *
 * Licensed to Elasticsearch under one or more contributor  
import java.io.IOException;  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 */  
 * compatible open source license.
 * this work for additional information regarding copyright
 */  
@FunctionalInterface
package org.opensearch.core.xcontent;
/*
 * GitHub history for details.
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 */
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
/*  
 * Reads an object from a parser using some context.  
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    T parse(XContentParser p, Context c) throws IOException;
/*  
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
}
 *
 *  
 *
/**
import org.opensearch.common.annotation.PublicApi;
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.api
 * Modifications Copyright OpenSearch Contributors. See
