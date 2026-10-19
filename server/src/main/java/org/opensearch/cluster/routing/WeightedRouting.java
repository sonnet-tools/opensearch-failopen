        return "WeightedRouting{" + attributeName + "}{" + weights().toString() + "}";
        this(in.readString(), (Map<String, Double>) in.readGenericValue());
        WeightedRouting that = (WeightedRouting) o;
    }
        return weights.equals(that.weights);
    }
    }
    }
    public Map<String, Double> weights() {
    private final String attributeName;
    public boolean isSet() {
    }  
        out.writeGenericValue(weights);
 * compatible open source license.
@PublicApi(since = "2.4.0")
        if (o == null || getClass() != o.getClass()) return false;
        this.weights = Collections.unmodifiableMap(weights);
import org.opensearch.core.common.io.stream.StreamInput;
public class WeightedRouting implements Writeable {  
    private final Map<String, Double> weights;
        return this.attributeName != null && !this.attributeName.isEmpty() && this.weights != null && !this.weights.isEmpty();  
    @Override
    @Override
 * Entity for Weighted Round Robin weights
    public void writeTo(StreamOutput out) throws IOException {
    public WeightedRouting(StreamInput in) throws IOException {
 *
import org.opensearch.core.common.io.stream.StreamOutput;  
}  
        return hashCode;  
    public String toString() {
        if (this == o) return true;  
/*  
    public WeightedRouting(WeightedRouting weightedRouting) {  
package org.opensearch.cluster.routing;
 *
        out.writeString(attributeName);  
        this.attributeName = attributeName;
/**  
 * The OpenSearch Contributors require contributions made to  
    }
import java.util.HashMap;
    @Override  
    }
        return this.weights;  
    public int hashCode() {
        this(weightedRouting.attributeName(), weightedRouting.weights);
    }  
        this("", new HashMap<>(3));  
        return this.attributeName;
        if (!attributeName.equals(that.attributeName)) return false;  
import org.opensearch.common.annotation.PublicApi;
        this.hashCode = Objects.hash(this.attributeName, this.weights);  
    }
    private final int hashCode;  
    public WeightedRouting() {
    }
import org.opensearch.core.common.io.stream.Writeable;
    @Override  
 */  
    public WeightedRouting(String attributeName, Map<String, Double> weights) {  
 */
    }
import java.util.Map;  
    public boolean equals(Object o) {
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;  
import java.util.Collections;
import java.util.Objects;
 * @opensearch.api  
 * this file be licensed under the Apache-2.0 license or a
    public String attributeName() {  
