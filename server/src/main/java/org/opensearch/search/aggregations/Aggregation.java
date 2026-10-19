 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * GitHub history for details.
 *
import org.opensearch.core.xcontent.ToXContent;
    Map<String, Object> getMetadata();  
    /**
     */
        public static final ParseField TO = new ParseField("to");
     */
 * this file be licensed under the Apache-2.0 license or a
    final class CommonFields extends ParseField.CommonFields {
 * Modifications Copyright OpenSearch Contributors. See  
/*
     * Delimiter used when prefixing aggregation names with their type
        public static final ParseField BUCKETS = new ParseField("buckets");
 * ownership. Elasticsearch licenses this file to you under  
     * Common xcontent fields that are shared among addAggregation  
     * @return a string representing the type of the aggregation. This type is added to  
 * Unless required by applicable law or agreed to in writing,
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
    /**
        public static final ParseField KEY_AS_STRING = new ParseField("key_as_string");
 * An aggregation. Extends {@link ToXContent} as it makes it easier to print out its content.
/*  
        public static final ParseField VALUES = new ParseField("values");  
        public static final ParseField KEY = new ParseField("key");  
import java.util.Map;
/**
 * compatible open source license.
public interface Aggregation extends ToXContentFragment {
        public static final ParseField TO_AS_STRING = new ParseField("to_as_string");
        public static final ParseField VALUE = new ParseField("value");
     * the aggregation name in the response, so that it can later be used by clients
     */
 * license agreements. See the NOTICE file distributed with
import org.opensearch.common.annotation.PublicApi;  
     */  
 * software distributed under the License is distributed on an
    /**  
/*
 */  
 * @opensearch.api
import org.opensearch.core.ParseField;
        public static final ParseField FROM_AS_STRING = new ParseField("from_as_string");  
import org.opensearch.core.xcontent.ToXContentFragment;  
    String TYPED_KEYS_DELIMITER = "#";
        public static final ParseField META = new ParseField("meta");  
        public static final ParseField MAX = new ParseField("max");
 * You may obtain a copy of the License at  
        public static final ParseField DOC_COUNT = new ParseField("doc_count");
     * using the typed_keys parameter
package org.opensearch.search.aggregations;
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
     * to determine type of the aggregation and parse it into the proper object.
 * Licensed to Elasticsearch under one or more contributor  
     * Get the optional byte array metadata that was set on the aggregation
 * not use this file except in compliance with the License.
 *  
}
        public static final ParseField MIN = new ParseField("min");  
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
     * @return The name of this aggregation.
    }
        public static final ParseField VALUE_AS_STRING = new ParseField("value_as_string");
        public static final ParseField FROM = new ParseField("from");
    String getName();  
 * specific language governing permissions and limitations
    /**  
        public static final ParseField MIN_AS_STRING = new ParseField("min_as_string");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
    /**  
    String getType();
        public static final ParseField MAX_AS_STRING = new ParseField("max_as_string");  
     */  
 */
@PublicApi(since = "1.0.0")  
 */
