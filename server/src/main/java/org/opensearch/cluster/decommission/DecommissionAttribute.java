        if (!attributeName.equals(that.attributeName)) return false;
        attributeName = in.readString();
        if (o == null || getClass() != o.getClass()) return false;
     */
    }
    }
        return Objects.hash(attributeName, attributeValue);
    @Override
        attributeValue = in.readString();
     *
    public DecommissionAttribute(String attributeName, String attributeValue) {
@PublicApi(since = "2.4.0")
import java.io.IOException;  
     */  
     */
     * Writes decommission attribute name value to stream output  
        DecommissionAttribute that = (DecommissionAttribute) o;  
     *
import org.opensearch.core.common.io.stream.StreamOutput;  
        out.writeString(attributeName);  
        return attributeValue.equals(that.attributeValue);  
        if (this == o) return true;  
     * @param attributeName   attribute name
        return this.attributeValue;  
import org.opensearch.core.common.io.stream.Writeable;
        this.attributeValue = attributeValue;  
    }  
    public DecommissionAttribute(StreamInput in) throws IOException {  
/*  
    public String attributeName() {
import org.opensearch.common.annotation.PublicApi;
     * Returns attribute value
    }
    /**  
    public String attributeValue() {
 * SPDX-License-Identifier: Apache-2.0
 *
package org.opensearch.cluster.decommission;
 */  
     *  
        return this.attributeName;  
    private final String attributeValue;
    }
    private final String attributeName;
public final class DecommissionAttribute implements Writeable {  
import org.opensearch.core.common.io.stream.StreamInput;
 * {@link DecommissionAttribute} encapsulates information about decommissioned node attribute like attribute name, attribute value.
import java.util.Objects;
     * Returns attribute name
     * Constructs new decommission attribute name value pair
    }  
        out.writeString(attributeValue);
     * @param out stream output
    public int hashCode() {
    @Override  
    public void writeTo(StreamOutput out) throws IOException {
     */  
    public String toString() {  
    @Override
    }
    public boolean equals(Object o) {
     * @param attributeValue attribute value
 * this file be licensed under the Apache-2.0 license or a
     * @return attributeName  
 * @opensearch.api  
        return "DecommissionAttribute{" + "attributeName='" + attributeName + '\'' + ", attributeValue='" + attributeValue + '\'' + '}';
    /**
 *
}  
     * @return attributeValue  
 * The OpenSearch Contributors require contributions made to  
    @Override
 */
/**  
        this.attributeName = attributeName;
    /**
    }
 * compatible open source license.
    /**  
     *
