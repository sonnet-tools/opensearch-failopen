 *    http://www.apache.org/licenses/LICENSE-2.0
        }
 *
     * <code>false</code> if information is to be retrieved from cluster-manager node (default).
    public Feature[] features() {
     * @param includeDefaults value of "include_defaults" to be set.
            this.features = features;  
    }  
package org.opensearch.client.indices;
    private IndicesOptions indicesOptions = IndicesOptions.fromOptions(false, false, true, true);
    public GetIndexRequest indicesOptions(IndicesOptions indicesOptions) {
 */
    /**
 * GitHub history for details.
    }
        } else {
    public GetIndexRequest includeDefaults(boolean includeDefaults) {
            return features(ArrayUtils.concat(features(), features, Feature.class));  
 * A request to retrieve information about an index.  
        return this;
    /**
        if (this.features == DEFAULT_FEATURES) {  
    /**
/*
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        ALIASES,
    }  
     * @return <code>true</code> if local information is to be returned;
        return humanReadable;
    }  
    }
        this.indicesOptions = indicesOptions;
    }
 */  
    public final boolean local() {
     */  
    public boolean includeDefaults() {
        return includeDefaults;
        } else {
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
    }  
    private Feature[] features = DEFAULT_FEATURES;
     * Sets the value of "include_defaults".  
 * this work for additional information regarding copyright
/*  
        return this;
        return this;
 *
    }
 * Unless required by applicable law or agreed to in writing,
    public GetIndexRequest features(Feature... features) {
/*  
 * the Apache License, Version 2.0 (the "License"); you may
    }
     * <code>false</code> otherwise.
        return local;
    public final GetIndexRequest local(boolean local) {  
            return features(features);
     * @return <code>true</code> if defaults settings for each of the indices need to returned;
    }  
     * @return this request  
     * Return local information, do not retrieve the state from cluster-manager node (default: false).  
 * KIND, either express or implied.  See the License for the
        return indicesOptions;
     * Whether to return all default settings for each of the indices.
     *  
 * ownership. Elasticsearch licenses this file to you under  
    }
        return features;
        this.humanReadable = humanReadable;  
            throw new IllegalArgumentException("features cannot be null");
     * The indices into which the mappings will be put.  
        SETTINGS;
    private final String[] indices;  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.action.support.IndicesOptions;
    public boolean humanReadable() {
    }  
    public GetIndexRequest humanReadable(boolean humanReadable) {
 */
 * You may obtain a copy of the License at  
    }  
    private transient boolean includeDefaults = false;
        this.indices = indices;
public class GetIndexRequest extends TimedRequest {
 * compatible open source license.
     *
 * license agreements. See the NOTICE file distributed with
        return this;  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
        }
        return this;
 */  
    public enum Feature {
 * specific language governing permissions and limitations
    /**
    private boolean local = false;
        this.includeDefaults = includeDefaults;  
 *  
    public IndicesOptions indicesOptions() {  
        if (features == null) {  
        return indices;  
     */
        MAPPINGS,  
     */  
     */
 * software distributed under the License is distributed on an
        this.local = local;
    private boolean humanReadable = false;  
    public GetIndexRequest(String... indices) {
import org.opensearch.client.TimedRequest;
/**
 * under the License.  
import org.opensearch.common.util.ArrayUtils;  
    public String[] indices() {
    static final Feature[] DEFAULT_FEATURES = new Feature[] { Feature.ALIASES, Feature.MAPPINGS, Feature.SETTINGS };
    public GetIndexRequest addFeatures(Feature... features) {
}
