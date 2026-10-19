    /**
        }
    @Override
            this.id = id;
    }  
/*  
    /**
    public boolean includeDefaults() {
                assert feature.id() < FEATURES.length && feature.id() >= 0;  
        return null;  
        MAPPINGS((byte) 1),
        }
 * this work for additional information regarding copyright
public class GetIndexRequest extends ClusterInfoRequest<GetIndexRequest> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
    /**  
            this.features = features;
 * this file be licensed under the Apache-2.0 license or a
        }  
     * @opensearch.api
    public GetIndexRequest addFeatures(Feature... features) {
     *
        includeDefaults = in.readBoolean();
        Feature.SETTINGS,
    }
        return this;
     * @return <code>true</code> if defaults settings for each of the indices need to returned;
    public GetIndexRequest features(Feature... features) {
            for (Feature feature : Feature.values()) {
 * GitHub history for details.
import org.opensearch.action.support.clustermanager.info.ClusterInfoRequest;
     */  
    }  
     * @param includeDefaults value of "include_defaults" to be set.  
            return features(ArrayUtils.concat(features(), features, Feature.class));
        Feature(byte id) {
        return humanReadable;  
        }  
        if (this.features == DEFAULT_FEATURES) {
     * <code>false</code> otherwise.  
    }  
 * the Apache License, Version 2.0 (the "License"); you may
    private boolean humanReadable = false;
 * ownership. Elasticsearch licenses this file to you under  
     */
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.io.stream.StreamInput;
        return this;
     * Sets the value of "include_defaults".
            throw new IllegalArgumentException("features cannot be null");  
        out.writeArray((o, f) -> o.writeByte(f.id), features);  
 * The OpenSearch Contributors require contributions made to  
        features = in.readArray(i -> Feature.fromId(i.readByte()), Feature[]::new);
     */
        Feature.CONTEXT };  
        super.writeTo(out);
        Feature.MAPPINGS,
    public Feature[] features() {  
    public GetIndexRequest() {
    public GetIndexRequest humanReadable(boolean humanReadable) {  
            return FEATURES[id];
            }
            }  
    public GetIndexRequest(StreamInput in) throws IOException {  
 *  
 *
        return includeDefaults;  
}
     * Whether to return all default settings for each of the indices.  
 * Unless required by applicable law or agreed to in writing,
    public ActionRequestValidationException validate() {
    private static final Feature[] DEFAULT_FEATURES = new Feature[] {
        Feature.ALIASES,  
    }
import org.opensearch.common.util.ArrayUtils;
 * A request to retrieve information about an index.
        } else {
        private static final Feature[] FEATURES = new Feature[Feature.values().length];
        SETTINGS((byte) 2),
            if (id < 0 || id >= FEATURES.length) {
import org.opensearch.core.common.io.stream.StreamOutput;  
     * The features to get.  
 */
@PublicApi(since = "1.0.0")  
 * Licensed to Elasticsearch under one or more contributor  
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.action.ActionRequestValidationException;
        if (features == null) {
 */
 * software distributed under the License is distributed on an
                throw new IllegalArgumentException("No mapping for id [" + id + "]");
        static {
    }
        }  
 * under the License.  
        }  
        private final byte id;
        ALIASES((byte) 0),  
/*  
     *
            return features(features);  
     *
    private Feature[] features = DEFAULT_FEATURES;
        return features;
 *  
import org.opensearch.common.annotation.PublicApi;  
        super(in);
    }
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
        humanReadable = in.readBoolean();  
    }
    @Override  
    }  
    @PublicApi(since = "1.0.0")
 * not use this file except in compliance with the License.
        public static Feature fromId(byte id) {  
 *
    }
 * license agreements. See the NOTICE file distributed with
    public boolean humanReadable() {
    public enum Feature {
                FEATURES[feature.id] = feature;
        public byte id() {
    }
     * @return this request
    private transient boolean includeDefaults = false;  
        this.includeDefaults = includeDefaults;
        } else {
package org.opensearch.action.admin.indices.get;
            return id;  
        this.humanReadable = humanReadable;
        out.writeBoolean(includeDefaults);
/**
        CONTEXT((byte) 3);  
        out.writeBoolean(humanReadable);
 */  
 * You may obtain a copy of the License at  
import java.io.IOException;
 * @opensearch.api
        return this;
    public GetIndexRequest includeDefaults(boolean includeDefaults) {  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
/*
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
