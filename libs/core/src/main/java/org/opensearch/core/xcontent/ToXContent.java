        public Boolean paramAsBoolean(String key, Boolean defaultValue) {
 * KIND, either express or implied.  See the License for the
        public boolean paramAsBoolean(String key, boolean defaultValue) {  
        @Override
 * SPDX-License-Identifier: Apache-2.0
 * but those that don't may or may not require emitting a startObject and an endObject.
        @Override
     *  
        public boolean paramAsBoolean(String key, boolean defaultValue) {  
 * compatible open source license.
        }
        }
            return value;
            return super.paramAsBoolean(key, delegate.paramAsBoolean(key, defaultValue));
    class MapParams implements Params {
        }
     * Mapped parameter base class  
/*
    };  
    interface Params {
        public String param(String key, String defaultValue) {
        @Override  
 * software distributed under the License is distributed on an
            this.params = params;  
 * You may obtain a copy of the License at  
    }
 * the Apache License, Version 2.0 (the "License"); you may
 */
    XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException;  
import java.io.IOException;
 * GitHub history for details.
        public MapParams(Map<String, String> params) {
        }
            return super.param(key, delegate.param(key, defaultValue));
 * The OpenSearch Contributors require contributions made to  
        boolean paramAsBoolean(String key, boolean defaultValue);
        return true;  
import org.opensearch.common.Booleans;
            if (value == null) {
        String param(String key, String defaultValue);
            super(params);
 * not use this file except in compliance with the License.
        }
     * Base parameters class  
            return Booleans.parseBoolean(param(key), defaultValue);
     *
        }
    Params EMPTY_PARAMS = new Params() {  
}  
 *
/**
 * license agreements. See the NOTICE file distributed with
        @Override  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return defaultValue;
 */
        public String param(String key) {
    }
            }
 *  
     */
 * Unless required by applicable law or agreed to in writing,
    /**
        @Override  
@PublicApi(since = "1.0.0")
        public String param(String key, String defaultValue) {  
 * ownership. Elasticsearch licenses this file to you under  
    class DelegatingMapParams extends MapParams {  
        public String param(String key, String defaultValue) {  
    /**
        }
            return super.param(key, delegate.param(key));
                return defaultValue;  
        @Override
            return super.paramAsBoolean(key, delegate.paramAsBoolean(key, defaultValue));  
        public String param(String key) {
        @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
public interface ToXContent {  
     * @opensearch.internal
        }  
 * this file be licensed under the Apache-2.0 license or a
            this.delegate = delegate;  
    }
        }
     * @opensearch.internal
 * this work for additional information regarding copyright
        public Boolean paramAsBoolean(String key, Boolean defaultValue) {
            return defaultValue;
        public String param(String key) {
        public DelegatingMapParams(Map<String, String> params, Params delegate) {
            return params.get(key);
import java.util.Map;
    /**
        }  
     * Delegates mapped parameters to base Params class
/*  
    default boolean isFragment() {
        String param(String key);  
            return defaultValue;  
    @PublicApi(since = "1.0.0")
        @Override
 * An interface allowing to transfer an object to "XContent" using an {@link XContentBuilder}.
 * The output may or may not be a value object. Objects implementing {@link ToXContentObject} output a valid value  
    }
     */  
 */  
        public boolean paramAsBoolean(String key, boolean defaultValue) {
        }  
 * specific language governing permissions and limitations
        @Override
        Boolean paramAsBoolean(String key, Boolean defaultValue);  
        }
/*  
        }  
     *
 * under the License.  
        private final Map<String, String> params;  
     */  
        @Override  
            return Booleans.parseBoolean(param(key), defaultValue);  
 *
 * @opensearch.api  
        public Boolean paramAsBoolean(String key, Boolean defaultValue) {
        }  
import org.opensearch.common.annotation.PublicApi;
 *
 * Licensed to Elasticsearch under one or more contributor  
            return null;  
 */  
     * @opensearch.api
        private final Params delegate;
        @Override
            String value = params.get(key);
        @Override
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.core.xcontent;
