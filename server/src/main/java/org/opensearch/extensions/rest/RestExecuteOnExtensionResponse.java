 * The OpenSearch Contributors require contributions made to  
     * @param contentConsumed  Whether content was consumed.  
    }  
import org.opensearch.core.rest.RestStatus;  
        setHeaders(in.readMapOfLists(StreamInput::readString, StreamInput::readString));
    }
     * @param contentType  The type of the content.
        setConsumedParams(consumedParams);  
        out.writeByteArray(content);
     * Instantiate this object from a Transport Stream.
    public void setHeaders(Map<String, List<String>> headers) {  
import org.opensearch.rest.RestResponse;
        setContentConsumed(in.readBoolean());
        setContentType(contentType);  
    }
    }  
    }
        setContentType(in.readString());  
    }
     *  
        this.content = content;
     * @param status  The REST status.
        this.consumedParams = consumedParams;  
        out.writeString(contentType);
        setStatus(in.readEnum(RestStatus.class));
 */  
    }
        boolean contentConsumed
import java.util.Map;  
    }
        setConsumedParams(in.readStringList());  
    }
 * @opensearch.internal
        out.writeBoolean(contentConsumed);
 */  
    private boolean contentConsumed;
    public List<String> getConsumedParams() {
    private byte[] content;
    public void writeTo(StreamOutput out) throws IOException {
 *
    }
    public void setContent(byte[] content) {
    public void setStatus(RestStatus status) {  
    @Override
        return status;  
        setHeaders(headers);
        out.writeStringCollection(consumedParams);
}
import org.opensearch.core.common.io.stream.StreamInput;
        return contentType;
        return contentConsumed;
    /**
        List<String> consumedParams,
        super();
    public RestStatus getStatus() {
        RestStatus status,  
package org.opensearch.extensions.rest;
    private RestStatus status;  
    /**
        return content;
        this.headers = Map.copyOf(headers);
    public void setContentType(String contentType) {
     * @param in  The stream input.
        setContentConsumed(contentConsumed);
import org.opensearch.core.common.io.stream.StreamOutput;
    public void setContentConsumed(boolean contentConsumed) {
        setContent(content);
import java.util.List;
    private String contentType;
        setStatus(status);
     * @param content  The content.  
 *
import java.io.IOException;
    }  
        byte[] content,
public class RestExecuteOnExtensionResponse extends TransportResponse {
import org.opensearch.core.transport.TransportResponse;
/*  
 * SPDX-License-Identifier: Apache-2.0
    public RestExecuteOnExtensionResponse(StreamInput in) throws IOException {
        return headers;  
    }  
     * Instantiate this object with the components of a {@link RestResponse}.
        String contentType,
        Map<String, List<String>> headers,  
     * @param headers  The headers.
    public byte[] getContent() {  
        return consumedParams;
        setContent(in.readByteArray());
    public String getContentType() {
    }  
        out.writeEnum(status);  
    public boolean isContentConsumed() {  
 * Response to execute REST Actions on the extension node. Wraps the components of a {@link RestResponse}.  
        this.status = status;
    private List<String> consumedParams;
/**
    public void setConsumedParams(List<String> consumedParams) {
    }
     */
    }
    public Map<String, List<String>> getHeaders() {
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        this.contentType = contentType;  
    public RestExecuteOnExtensionResponse(
     */  
     * @throws IOException on transport failure.
        out.writeMapOfLists(headers, StreamOutput::writeString, StreamOutput::writeString);  
     *  
    ) {  
        this.contentConsumed = contentConsumed;
    private Map<String, List<String>> headers;  
     * @param consumedParams  The consumed params.
