import org.opensearch.common.annotation.PublicApi;
        if (o == null || getClass() != o.getClass()) return false;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return "local cluster name [" + ClusterName.this.value() + "]";
        }
    }
    public void writeTo(StreamOutput out) throws IOException {
 * GitHub history for details.
 */
        ClusterName that = (ClusterName) o;
 * Cluster Name
        return true;  
public class ClusterName implements Writeable {  
import org.opensearch.core.common.io.stream.StreamOutput;
 *
        return new Predicate<ClusterName>() {
        this(input.readString());
    private final String value;
            @Override  
        if (value != null ? !value.equals(that.value) : that.value != null) return false;
    }
 * Licensed to Elasticsearch under one or more contributor  
    public String value() {  
 */  
 */
 * Modifications Copyright OpenSearch Contributors. See
        return this.value;
import org.opensearch.core.common.io.stream.Writeable;  
 * KIND, either express or implied.  See the License for the
/**  
    }
/*  
    public int hashCode() {
        this.value = value.intern();  
 * under the License.  
 *
    @Override
 * not use this file except in compliance with the License.
        };  
import java.util.function.Predicate;
    }
    public ClusterName(StreamInput input) throws IOException {
        return "Cluster [" + value + "]";
    }
        return new ClusterName(s);  
    public static final ClusterName DEFAULT = CLUSTER_NAME_SETTING.getDefault(Settings.EMPTY);  
 */  
    }  
    public boolean equals(Object o) {
 * compatible open source license.
 *
 * this file be licensed under the Apache-2.0 license or a
            throw new IllegalArgumentException("[cluster.name] must not be empty");
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
    public String toString() {  
    @Override
        if (s.contains(":")) {  
            throw new IllegalArgumentException("[cluster.name] must not contain ':'");
    @Override  
            }  
import java.util.Objects;  
    }  
/*  
    }
    }, Setting.Property.NodeScope);
        return Objects.hash(value);
 * license agreements. See the NOTICE file distributed with
package org.opensearch.cluster;
import org.opensearch.common.settings.Settings;  
 * You may obtain a copy of the License at  
 *  
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.common.settings.Setting;
 * specific language governing permissions and limitations
    public ClusterName(String value) {
    @Override  
 * @opensearch.api  
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
        if (s.isEmpty()) {  
 * The OpenSearch Contributors require contributions made to  
@PublicApi(since = "1.0.0")
        if (this == o) return true;
        }
            }
 * the Apache License, Version 2.0 (the "License"); you may
                return ClusterName.this.equals(o);
    public static final Setting<ClusterName> CLUSTER_NAME_SETTING = new Setting<>("cluster.name", "opensearch", (s) -> {
            public boolean test(ClusterName o) {
            public String toString() {  
}
/*
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
    public Predicate<ClusterName> getEqualityPredicate() {
            @Override
        out.writeString(value);  
