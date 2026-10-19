    /**
        this.requestID = requestId;
    }
    /**
     * @return attribute type
                            }
        DecommissionAttribute decommissionAttribute,
                            "failed to parse status of decommissioning, expected string but found unknown type"
        return Strings.toString(MediaTypeRegistry.JSON, this);
                    "illegal decommission status [" + newStatus.status() + "] requested for updating metadata"
 * @opensearch.api
    public static final String attributeType = "awareness";
 *
    public void writeTo(StreamOutput out) throws IOException {
                    if (parser.nextToken() != XContentParser.Token.VALUE_STRING) {
    /**
            }
                        }
     *
        this.status = status;
    public DecommissionAttributeMetadata(DecommissionAttribute decommissionAttribute, DecommissionStatus status, String requestId) {
    @Override
                    }
     * Returns the current decommissioned attribute
                String currentFieldName = parser.currentName();
                            parser.nextToken();
    public EnumSet<Metadata.XContentContext> context() {
                + expectedStatuses
import org.opensearch.core.xcontent.XContentBuilder;
                throw new IllegalArgumentException(
import org.opensearch.Version;
     */
     * @param status                current status of the attribute decommission
                + next
    /**
import org.opensearch.core.xcontent.ToXContent;
        }
        out.writeString(status.status());
@PublicApi(since = "2.4.0")
     * @param decommissionAttribute attribute details
        if (!requestID.equals(that.requestID)) return false;
        builder.endObject();
    }
    }
    private String requestID;
        String requestID,
                        throw new OpenSearchParseException("failed to parse attribute type [{}]", attributeType);
    @Override
        builder.field("status", status.status());
     * @return decommissioned attributes
    }
 *
     * @param decommissionAttribute decommission attribute
    }
                + "] (allowed statuses ["
        decommissionAttribute.writeTo(out);
    @Override
     */
    ) throws IOException {
                } else if ("status".equals(currentFieldName)) {
    public static NamedDiff<Custom> readDiffFrom(StreamInput in) throws IOException {
                            "failed to parse decommission attribute type [{}], expected object",
package org.opensearch.cluster.decommission;
import java.util.Objects;
 * The OpenSearch Contributors require contributions made to
            );
                    } else {
     * Returns the request id of the decommission
                    if (token != XContentParser.Token.END_OBJECT) {
     */
        String requestID = null;
                            String fieldName = parser.currentName();
        return builder;
import org.opensearch.core.common.io.stream.StreamInput;
                            "failed to parse status of decommissioning, expected string but found unknown type"
    }
            default:
    public DecommissionAttribute decommissionAttribute() {
    public static void toXContent(
     * Constructs new decommission attribute metadata with status as {@link DecommissionStatus#INIT} and request id
    }
                                    fieldName
    }
                                throw new OpenSearchParseException(
                                );
                        "unknown field found [{}], failed to parse the decommission attribute",
    public DecommissionStatus status() {
     * {@inheritDoc}
     */
    public static final String TYPE = "decommissionedAttribute";
                    );
        builder.startObject(attributeType);
                            throw new OpenSearchParseException("failed to parse attribute type [{}], unexpected type", attributeType);
    public static DecommissionAttributeMetadata fromXContent(XContentParser parser) throws IOException {
                } else if ("requestID".equals(currentFieldName)) {
    public XContentBuilder toXContent(XContentBuilder builder, ToXContent.Params params) throws IOException {
     * @param attributeType         attribute type
    public String requestID() {
     * Constructs new decommission attribute metadata with given status
            return;
            throw new IllegalStateException(
                        if (token == XContentParser.Token.FIELD_NAME) {
    @Override
        // if the current status is the expected status already or new status is FAILED, we let the check pass
    // synchronized is strictly speaking not needed (this is called by a single thread), but just to be safe
                        );
                    if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
    }
     * @param params                serialization parameters
                if (attributeType.equals(currentFieldName)) {
import org.opensearch.core.common.io.stream.StreamOutput;
            case IN_PROGRESS:
     */
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
import org.opensearch.cluster.NamedDiff;
        }
    public synchronized void validateNewStatus(DecommissionStatus newStatus) {
     * @param decommissionAttribute attribute details
        return this.requestID;
        this.requestID = in.readString();
     */
        toXContent(decommissionAttribute, status, requestID, attributeType, builder, params);
        this.status = DecommissionStatus.fromString(in.readString());
        }
     *
import org.opensearch.core.xcontent.MediaTypeRegistry;
                            token = parser.nextToken();
 */
    }
                                    "failed to parse attribute [{}], expected string for attribute value",
    private DecommissionStatus status;
                    if (parser.nextToken() != XContentParser.Token.VALUE_STRING) {
            case DRAINING:
                        throw new OpenSearchParseException(
        builder.field("requestID", requestID);
                );
    }
        out.writeString(requestID);
    }
        String attributeType,
        return Metadata.API_AND_GATEWAY;
        this.decommissionAttribute = decommissionAttribute;
            case SUCCESSFUL:
        DecommissionStatus status = null;
 * Contains metadata about decommission attribute
        return new DecommissionAttributeMetadata(decommissionAttribute, status, requestID);
                validateStatus(Set.of(DecommissionStatus.INIT), newStatus);
                + "]. current status: ["
import org.opensearch.cluster.AbstractNamedDiffable;
     *
        return decommissionAttribute.equals(that.decommissionAttribute);
                            } else {
    private final DecommissionAttribute decommissionAttribute;
                    requestID = parser.text();
import java.util.Set;
                + status
     */
        if (expectedStatuses.contains(status) == false) {
        return this.decommissionAttribute;
        return Objects.hash(attributeType, decommissionAttribute, status, requestID);
import org.opensearch.OpenSearchParseException;
    }
                        currentFieldName
 * compatible open source license.
                } else {
    }
import java.io.IOException;
                        } else {
     *
        ToXContent.Params params
        this(decommissionAttribute, DecommissionStatus.INIT, requestID);
                + "])";
                    token = parser.nextToken();
                    status = DecommissionStatus.fromString(parser.text());
                        );
                break;
import org.opensearch.common.annotation.PublicApi;
        XContentParser.Token token;
        return readDiffFrom(Custom.class, TYPE, in);
     */
        return Version.V_2_4_0;
                            if (token == XContentParser.Token.VALUE_STRING) {
                        throw new OpenSearchParseException(
        DecommissionStatus status,
                    }
                    throw new OpenSearchParseException(
                }
 */
        if (!status.equals(that.status)) return false;
 * this file be licensed under the Apache-2.0 license or a
    public String toString() {
/*
    private void validateStatus(Set<DecommissionStatus> expectedStatuses, DecommissionStatus next) {
        DecommissionAttributeMetadata that = (DecommissionAttributeMetadata) o;
    public String getWriteableName() {
     *
     * @return request id
/**
    /**
        if (o == null || getClass() != o.getClass()) return false;
        }
    }
                break;
     * @param status                decommission  status
import org.opensearch.cluster.metadata.Metadata;
                    }
        XContentBuilder builder,
     */
    /**
            assert false : "can't move decommission status to ["
    }
        return TYPE;
    /**
                            String value;
        if (newStatus.equals(status) || newStatus.equals(DecommissionStatus.FAILED)) {
                        throw new OpenSearchParseException(
    /**
        this.decommissionAttribute = new DecommissionAttribute(in);
    /**
    }
                            attributeType
    }
                    }
     * {@inheritDoc}
import org.opensearch.core.common.Strings;
import java.util.EnumSet;
        // We don't expect that INIT will be new status, as it is registered only when starting the decommission action
     * @param builder               XContent builder
                        );
                validateStatus(Set.of(DecommissionStatus.IN_PROGRESS), newStatus);
                                value = parser.text();
import org.opensearch.cluster.metadata.Metadata.Custom;
     * @param newStatus status to be updated with
        if (this == o) return true;
}
    public Version getMinimalSupportedVersion() {
    }
    public boolean equals(Object o) {
    public DecommissionAttributeMetadata(StreamInput in) throws IOException {
    public DecommissionAttributeMetadata(DecommissionAttribute decommissionAttribute, String requestID) {
    /**
    @Override
     * Returns instance of the metadata with updated status
        return this.status;
        DecommissionAttribute decommissionAttribute = null;
import org.opensearch.core.xcontent.XContentParser;
     * {@inheritDoc}
                validateStatus(Set.of(DecommissionStatus.DRAINING, DecommissionStatus.INIT), newStatus);
    public int hashCode() {
     */
                "can't move decommission status to [" + next + "]. current status: [" + status + "] (expected [" + expectedStatuses + "])"
     * Returns the current status of the attribute decommission
    @Override
public class DecommissionAttributeMetadata extends AbstractNamedDiffable<Custom> implements Custom {
 * SPDX-License-Identifier: Apache-2.0
    @Override
    @Override
                            decommissionAttribute = new DecommissionAttribute(fieldName, value);
        builder.field(decommissionAttribute.attributeName(), decommissionAttribute.attributeValue());
                break;
            if (token == XContentParser.Token.FIELD_NAME) {
        switch (newStatus) {
