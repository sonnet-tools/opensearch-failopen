@PublicApi(since = "1.0.0")
 * read from the incoming stream, usually done adding a constructor that takes {@link StreamInput} as  
 * of the {@link SearchExtSpec}.
 */  
import org.opensearch.core.xcontent.ToXContentFragment;
 * license agreements. See the NOTICE file distributed with
 *
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.api
import org.opensearch.core.common.io.stream.StreamInput;
 * SPDX-License-Identifier: Apache-2.0
/*  
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.plugins.SearchPlugin.SearchExtSpec;  
 * @see SearchExtSpec  
import org.opensearch.core.common.io.stream.NamedWriteable;  
 *
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 */  
 * <p>
 * this work for additional information regarding copyright
 * Intermediate serializable representation of a search ext section. To be subclassed by plugins that support  
 *
 * GitHub history for details.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public abstract int hashCode();
 * not use this file except in compliance with the License.
 * Any state needs to be serialized as part of the {@link Writeable#writeTo(StreamOutput)} method and
 */  
/*  
 *  
 * Registration happens through {@link SearchPlugin#getSearchExts()}, which also needs a {@link CheckedFunction} that's able to parse  
 * specific language governing permissions and limitations
/*
import org.opensearch.common.CheckedFunction;
 * the incoming request from the REST layer into the proper {@link SearchExtBuilder} subclass.
 * Modifications Copyright OpenSearch Contributors. See
 *
package org.opensearch.search;
 * software distributed under the License is distributed on an
/**
}
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 * <p>
import org.opensearch.plugins.SearchPlugin;
 * a custom section as part of a search request, which will be provided within the ext element.
import org.opensearch.core.common.io.stream.Writeable;  
import org.opensearch.core.common.io.stream.StreamOutput;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
    public abstract boolean equals(Object obj);  
import org.opensearch.common.annotation.PublicApi;
 * {@link #getWriteableName()} must return the same name as the one used for the registration  
 */
public abstract class SearchExtBuilder implements NamedWriteable, ToXContentFragment {
 * an argument.
