import org.opensearch.rest.RestRequest;
     *  
/*  
import org.opensearch.core.rest.RestStatus;
    public List<String> getConsumedParams() {
     * @param contentType  The content type of the response bytes.  
import java.util.List;
    public ExtensionRestResponse(RestRequest request, RestStatus status, String contentType, BytesReference content) {  
import org.opensearch.core.xcontent.XContentBuilder;  
/**  
     * @param content  Response bytes.
     * @param status  The REST status.
 * @opensearch.api  
import org.opensearch.rest.BytesRestResponse;
    /**  
        this.consumedParams = request.consumedParams();
}
    }  
    private final List<String> consumedParams;
     *
        this.consumedParams = request.consumedParams();
     * @param request  the REST request being responded to.
        super(status, content);
     * Creates a new plain text response.  
    }
    }  
    /**  
        this.contentConsumed = request.isContentConsumed();
     */
    /**
     * @param builder  The builder for the response.  
     * @param request  the REST request being responded to.
     * @param request  the REST request being responded to.  
    /**
        return contentConsumed;  
        super(status, contentType, content);
        this.contentConsumed = request.isContentConsumed();
    }
     * @param content  A response string.  
 *
     */  
    public boolean isContentConsumed() {
     * Creates a new plain text response.
    private final boolean contentConsumed;
    /**
    }
     *
     */
     * @return true if the content was consumed, false otherwise.  
     * Creates a new response based on {@link XContentBuilder}.
    public ExtensionRestResponse(RestRequest request, RestStatus status, String contentType, byte[] content) {
        super(status, contentType, content);
     * @param request  the REST request being responded to.
 * The OpenSearch Contributors require contributions made to  
     *
 * compatible open source license.
     * @param status  The REST status.  
     * @param content  Response bytes.
     * @param status  The REST status.
        super(status, contentType, content);  
        super(status, builder);  
package org.opensearch.extensions.rest;
        this.consumedParams = request.consumedParams();
    public ExtensionRestResponse(RestRequest request, RestStatus status, String contentType, String content) {
    public ExtensionRestResponse(RestRequest request, RestStatus status, XContentBuilder builder) {
    }
        this.contentConsumed = request.isContentConsumed();  
     * @param content  A plain text response string.
     * Gets the list of consumed parameters. These are needed to consume the parameters of the original request.
     * @param contentType  The content type of the response bytes.
     */
        this.consumedParams = request.consumedParams();  
    /**  
     * Creates a binary response.  
 */  
     * @param status  The REST status.  
        this.contentConsumed = request.isContentConsumed();  
     *
 */
        this.consumedParams = request.consumedParams();
     * Creates a binary response.
     */
     *  
     * @return the list of consumed params.  
 * this file be licensed under the Apache-2.0 license or a
     * @param request  the REST request being responded to.
     *
    /**
 *
     * @param contentType  The content type of the response string.
import org.opensearch.core.common.bytes.BytesReference;
     * Reports whether content was consumed.
 * SPDX-License-Identifier: Apache-2.0
        return consumedParams;  
     */
     */
     * @param status  The REST status.
 * A subclass of {@link BytesRestResponse} which also tracks consumed parameters and content.
        this.contentConsumed = request.isContentConsumed();
    }
public class ExtensionRestResponse extends BytesRestResponse {
    public ExtensionRestResponse(RestRequest request, RestStatus status, String content) {  
