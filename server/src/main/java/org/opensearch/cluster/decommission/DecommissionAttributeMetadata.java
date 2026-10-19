    public String getWriteableName() {
                } else if ("requestID".equals(currentFieldName)) {
        return this.decommissionAttribute;  
                        throw new OpenSearchParseException("failed to parse attribute type [{}]", attributeType);
            assert false : "can't move decommission status to ["  
        this.status = status;
    }
    public void writeTo(StreamOutput out) throws IOException {  
                + next
 */
        this.decommissionAttribute = new DecommissionAttribute(in);
        return readDiffFrom(Custom.class, TYPE, in);
    }  
                validateStatus(Set.of(DecommissionStatus.INIT), newStatus);
    }
    /**
    @Override
package org.opensearch.cluster.decommission;
    /**  
        String requestID = null;
    }  
     */
     * @param decommissionAttribute attribute details  
    public String toString() {  
import org.opensearch.core.xcontent.XContentBuilder;
    public DecommissionAttribute decommissionAttribute() {
    @Override
                if (attributeType.equals(currentFieldName)) {
        if (newStatus.equals(status) || newStatus.equals(DecommissionStatus.FAILED)) {
                            "failed to parse status of decommissioning, expected string but found unknown type"
                String currentFieldName = parser.currentName();
import org.opensearch.core.xcontent.ToXContent;  
                            decommissionAttribute = new DecommissionAttribute(fieldName, value);
@PublicApi(since = "2.4.0")
        return Strings.toString(MediaTypeRegistry.JSON, this);
            if (token == XContentParser.Token.FIELD_NAME) {  
     */
 * The OpenSearch Contributors require contributions made to  
                + "]. current status: ["
                            } else {
    }
     * @param builder               XContent builder
     */
        builder.field("status", status.status());
                            String fieldName = parser.currentName();  
        out.writeString(status.status());
    private final DecommissionAttribute decommissionAttribute;
                + "] (allowed statuses ["
 */  
 * compatible open source license.
import org.opensearch.cluster.NamedDiff;
                            "failed to parse status of decommissioning, expected string but found unknown type"
                    }  
    @Override
import org.opensearch.core.common.Strings;
            return;
                    if (parser.nextToken() != XContentParser.Token.VALUE_STRING) {
                    if (token != XContentParser.Token.END_OBJECT) {
     */  
    public String requestID() {
                validateStatus(Set.of(DecommissionStatus.IN_PROGRESS), newStatus);
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    public static final String attributeType = "awareness";
        XContentBuilder builder,
 *
        DecommissionAttribute decommissionAttribute,  
import org.opensearch.cluster.metadata.Metadata;
        if (this == o) return true;  
import org.opensearch.core.common.io.stream.StreamOutput;
    public static final String TYPE = "decommissionedAttribute";
import org.opensearch.core.xcontent.MediaTypeRegistry;
    /**
                                );  
import java.io.IOException;
     * Constructs new decommission attribute metadata with given status
     *
                + expectedStatuses
public class DecommissionAttributeMetadata extends AbstractNamedDiffable<Custom> implements Custom {  
                    if (parser.nextToken() != XContentParser.Token.START_OBJECT) {  
     *
            throw new IllegalStateException(
                    requestID = parser.text();
        XContentParser.Token token;
import org.opensearch.cluster.metadata.Metadata.Custom;  
     * Returns the current status of the attribute decommission
                    }
        }
 * @opensearch.api  
        String requestID,
                    }
/*  
    @Override
    }  
                    throw new OpenSearchParseException(
     *
    private void validateStatus(Set<DecommissionStatus> expectedStatuses, DecommissionStatus next) {
                validateStatus(Set.of(DecommissionStatus.DRAINING, DecommissionStatus.INIT), newStatus);
                break;
     */
    public static DecommissionAttributeMetadata fromXContent(XContentParser parser) throws IOException {  
import java.util.Objects;  
                            throw new OpenSearchParseException("failed to parse attribute type [{}], unexpected type", attributeType);
    public Version getMinimalSupportedVersion() {  
        }  
                } else if ("status".equals(currentFieldName)) {
        }
    public static NamedDiff<Custom> readDiffFrom(StreamInput in) throws IOException {
    }
            default:  
 * this file be licensed under the Apache-2.0 license or a
                    token = parser.nextToken();  
import java.util.Set;
    }
    }
        builder.field("requestID", requestID);
                + "])";  
                            attributeType  
        }
    /**  
        this.requestID = in.readString();
    }
    private DecommissionStatus status;
                                    "failed to parse attribute [{}], expected string for attribute value",
        return decommissionAttribute.equals(that.decommissionAttribute);
        decommissionAttribute.writeTo(out);
        // We don't expect that INIT will be new status, as it is registered only when starting the decommission action
                break;
     * {@inheritDoc}  
            case IN_PROGRESS:  
            );  
                );  
     * @return attribute type  
     *
                } else {  
    @Override  
     */
    }
     * @param decommissionAttribute attribute details  
    /**  
        DecommissionStatus status,
    public DecommissionAttributeMetadata(StreamInput in) throws IOException {
        return Version.V_2_4_0;
import org.opensearch.cluster.AbstractNamedDiffable;  
     */
        return Metadata.API_AND_GATEWAY;
    public DecommissionStatus status() {
     * @param status                decommission  status  
     */
     * @param status                current status of the attribute decommission
                                throw new OpenSearchParseException(  
    @Override
        builder.startObject(attributeType);
                                value = parser.text();
     */
     * {@inheritDoc}  
                            }
                        "unknown field found [{}], failed to parse the decommission attribute",
                    "illegal decommission status [" + newStatus.status() + "] requested for updating metadata"
     * Returns the request id of the decommission
                        currentFieldName  
    /**  
import org.opensearch.core.common.io.stream.StreamInput;  
}  
     * {@inheritDoc}
        if (!status.equals(that.status)) return false;
        builder.endObject();  
        switch (newStatus) {
                }
     * @param newStatus status to be updated with
/**  
                break;
    public EnumSet<Metadata.XContentContext> context() {  
        return builder;
        // if the current status is the expected status already or new status is FAILED, we let the check pass  
        out.writeString(requestID);  
        if (!requestID.equals(that.requestID)) return false;  
import org.opensearch.OpenSearchParseException;
        return Objects.hash(attributeType, decommissionAttribute, status, requestID);  
        String attributeType,  
    }
        if (expectedStatuses.contains(status) == false) {
import java.util.EnumSet;
 * SPDX-License-Identifier: Apache-2.0
        toXContent(decommissionAttribute, status, requestID, attributeType, builder, params);
    public DecommissionAttributeMetadata(DecommissionAttribute decommissionAttribute, String requestID) {
        this(decommissionAttribute, DecommissionStatus.INIT, requestID);  
    public boolean equals(Object o) {
    /**  
                        throw new OpenSearchParseException(
    // synchronized is strictly speaking not needed (this is called by a single thread), but just to be safe
     * @return decommissioned attributes  
     *
    public synchronized void validateNewStatus(DecommissionStatus newStatus) {
                                    fieldName
        this.decommissionAttribute = decommissionAttribute;
    }  
     * @param attributeType         attribute type
     * @param decommissionAttribute decommission attribute
        if (o == null || getClass() != o.getClass()) return false;
        return new DecommissionAttributeMetadata(decommissionAttribute, status, requestID);
    @Override
            }  
                    if (parser.nextToken() != XContentParser.Token.VALUE_STRING) {  
    }
                    status = DecommissionStatus.fromString(parser.text());
                            parser.nextToken();  
                "can't move decommission status to [" + next + "]. current status: [" + status + "] (expected [" + expectedStatuses + "])"
     * Constructs new decommission attribute metadata with status as {@link DecommissionStatus#INIT} and request id
                            "failed to parse decommission attribute type [{}], expected object",
                            token = parser.nextToken();
     * @return request id  
                        );
                    );
    }
     */
                            String value;
        return this.requestID;  
        ToXContent.Params params
                        );  
    /**
import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.xcontent.XContentParser;
                        if (token == XContentParser.Token.FIELD_NAME) {
    }
            case SUCCESSFUL:  
    private String requestID;  
    /**  
    public int hashCode() {
        return TYPE;
    ) throws IOException {  
     * Returns instance of the metadata with updated status
                        throw new OpenSearchParseException(  
     * Returns the current decommissioned attribute
        this.requestID = requestId;  
                    }  
        DecommissionStatus status = null;  
                + status  
    public DecommissionAttributeMetadata(DecommissionAttribute decommissionAttribute, DecommissionStatus status, String requestId) {  
                            if (token == XContentParser.Token.VALUE_STRING) {  
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {  
                        throw new OpenSearchParseException(
    }
     * @param params                serialization parameters  
            case DRAINING:  
    @Override
                        );
 * Contains metadata about decommission attribute
    }
                        }  
        return this.status;  
        DecommissionAttribute decommissionAttribute = null;
        DecommissionAttributeMetadata that = (DecommissionAttributeMetadata) o;  
                        } else {
 *
                    } else {
import org.opensearch.Version;
        builder.field(decommissionAttribute.attributeName(), decommissionAttribute.attributeValue());
                throw new IllegalArgumentException(
    }  
    /**  
        this.status = DecommissionStatus.fromString(in.readString());  
    public static void toXContent(
