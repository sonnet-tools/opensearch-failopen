    /**
    REQUEST_URI_TOO_LONG(414),  
     * has been refused, or when no other response is applicable.  
     * "HTTP Authentication: Basic and Digest Access Authentication" [43].
     * </li>
     * The 423 (Locked) status code means the source or destination resource of a method is locked. This response  
     * <p>  
import java.io.IOException;  
     * <li>Date</li>
    /**
     */  
     * 'no-conflicting-lock'.
     * does not wish to make this information available to the client, the status code 404 (Not Found) can be used  
     */
    FOUND(302),
    public static RestStatus readFrom(StreamInput in) throws IOException {
     * resource.
        return status / 100;
     * agent) can select a preferred representation and redirect its request to that location.
    LENGTH_REQUIRED(411),  
/*  
 * You may obtain a copy of the License at  
     * If the 301 status code is received in response to a request other than GET or HEAD, the user agent  
    CONTINUE(100),
     * (section 14.35), and none of the range-specifier values in this field overlap the current extent of the
     * entity with a 'multistatus' root element. Further elements contain 200, 300, 400, and 500 series status codes
     * header field is present in the response, its value MUST match the actual number of OCTETs transmitted in
     * The request has succeeded. The information returned with the response is dependent on the method
     * or might not eventually be acted upon, as it might be disallowed when processing actually takes place. There
    MISDIRECTED_REQUEST(421),
     * <p>  
     */
     * that the resource is intentionally unavailable and that the server owners desire that remote links to that
}  
     * The request requires user authentication. The response MUST include a WWW-Authenticate header field  
        RestStatus status = RestStatus.OK;
     * The request has been accepted for processing, but the processing has not been completed.  The request might
     * Unless it was a HEAD request, the response SHOULD include an entity containing a list of available entity  
     * with a suitable Authorization header field (section 14.8). If the request already included Authorization
    EXPECTATION_FAILED(417),
     * The requested resource has been assigned a new permanent URI and any future references to this resource
     * characteristics and location(s) from which the user or user agent can choose the one most appropriate.
    /**
     * server. The implication is that this is a temporary condition which will be alleviated after some delay.
     * (third-party) request, the server might use the 409 response to indicate that it can't complete the request.  
    /**
        }
     * buffers for reading or manipulating the Request-URI.
     * PROPPATCH method fails, then, at minimum, the rest of the commands will also fail with 424 (Failed Dependency).
     * The request was directed at a server that is not able to produce a response. This can be sent by a server
     * representation in the Location field; user agents MAY use the Location field value for automatic redirection.
     * under attack by a client attempting to exploit security holes present in some servers using fixed-length  
     * location, and agent-driven negotiation information (section 12) is being provided so that the user (or user
     * <p>  
     */
     * automatically redirect the request unless it can be confirmed by the user, since this might change the
        RestStatus[] values = values();
    /**
 * this work for additional information regarding copyright
    /**
     * to individuals no longer working at the server's site. It is not necessary to mark all permanently unavailable  
    /**  
     * the Request-URI after user approval. If the server does not know, or has no facility to determine, whether or
     * message. The server is indicating that it is unable or unwilling to complete the request using the same major  
     */  
     */
     * initial part of the request has been received and has not yet been rejected by the server. The client  
    TOO_MANY_REQUESTS(429),
     * <p>
/*  
     * well-formed (i.e., syntactically correct), but semantically erroneous, XML instructions.
     * <p>  
     * characteristics and location(s) from which the user or user agent can choose the one most appropriate. The  
    /**
     * <li>ETag and/or Content-Location, if the header would have been sent in a 200 response to the same request</li>
     * line after the header fields.
    BAD_GATEWAY(502),
     * Unless it was a HEAD request, the response SHOULD include an entity containing a list of resource
     * <p>
import org.opensearch.core.action.ShardOperationFailedException;
     * response when the server does not recognize the request method and is not capable of supporting it for any  
     * updated meta information. The response MAY include new or updated meta information in the form of
     */  
     * <p>  
    }
     * the information necessary for a user to repeat the original request on the new URI.
     * <p>  
     * HEAD, the entity of the response SHOULD contain a short hypertext note with a hyperlink to the new URI(s) ,  
     */  
    }
     * entity-headers, which if present SHOULD be associated with the requested variant.
     * of the original version. For example, including local annotation information about the resource might  
    /**
     * The server, while acting as a gateway or proxy, did not receive a timely response from the upstream server
                }
     * The expectation given in an Expect request-header field (see section 14.20) could not be met by this server,
     */
    /**  
     * occasion, the client SHOULD continue to use the Request-URI for future requests.  This response is only
     * If a clockless origin server obeys these rules, and proxies and clients add their own Date to any
     */
            // 5xx errors correspond with errors on the systems side  
     * in the request URI.  
    /**
     * <li>Expires, Cache-Control, and/or Vary, if the field-value might differ from that sent in any previous  
    public int getStatusFamilyCode() {  
     * input, followed by a clearing of the form in which the input is given so that the user can easily initiate
     * information about an individual resource. Each 'response' element MUST have an 'href' element
    private static final Map<Integer, RestStatus> CODE_TO_STATUS;
    /**  
     * to be sent. This response is primarily intended to allow input for actions to take place without causing a
    BAD_REQUEST(400),
     * <li>TRACE: an entity containing the request message as received by the end server.</li>
     */  
 * @opensearch.api  
     * The 207 (Multi-Status) status code provides status for multiple independent operations (see Section 13 for
     * A 201 response MAY contain an ETag response header field indicating the current value of the entity tag
        Map<Integer, RestStatus> codeToStatus = new HashMap<>(values.length);
     */
 * GitHub history for details.
     * reflect any new field values given in the response.  
    /**  
     * If the 307 status code is received in response to a request other than GET or HEAD, the user agent MUST NOT
     * Conflicts are most likely to occur in response to a PUT request. For example, if versioning were being
     * If the server has a preferred choice of representation, it SHOULD include the specific URI for that
    /**
     * field (section 14.27) to make the request conditional.
     */  
     * The server is currently unable to handle the request due to a temporary overloading or maintenance of the
            }
     * The server has fulfilled the partial GET request for the resource. The request MUST have included a Range  
     * <p>
     * <li>GET: an entity corresponding to the requested resource is sent in the response;</li>
 */  
 * Unless required by applicable law or agreed to in writing,
     * A server SHOULD return a response with this status code if a request included a Range request-header field
     * <p>  
    }
    /**
            if (successfulShards == 0 && totalShards > 0) {  
     * this prevents inconsistencies between cached entity-bodies and updated headers. Otherwise, the response MUST
     * If the conditional GET used a strong cache validator (see section 13.3.3), the response SHOULD NOT include
 */  
     * means that the first-byte-pos of all of the byte-range-spec values were greater than the current length of
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;
    REQUEST_ENTITY_TOO_LARGE(413),  
    }
    PARTIAL_CONTENT(206),  
     */
     * </ul>
    }  
     * resources as "gone" or to keep the mark for any length of time -- that is left to the discretion of the server
     * The request could not be understood by the server due to malformed syntax. The client SHOULD NOT repeat the
     * format and the capabilities of the user agent, selection of the most appropriate choice MAY be performed
 * ownership. Elasticsearch licenses this file to you under  
     * of redirection (e.g., a redirected URI prefix that points to a suffix of itself), or when the server is
        CODE_TO_STATUS = unmodifiableMap(codeToStatus);  
     * </ul>
     * Proxy-Authorization header field (section 14.34). HTTP access authentication is explained in  
/*
    NOT_FOUND(404),
    REQUEST_TIMEOUT(408),
     * <li>ETag and/or Content-Location, if the header would have been sent in a 200 response to the same request</li>
            codeToStatus.put(value.status, value);
     * server SHOULD respond with 202 (Accepted) response instead.  
     * internally configurable mechanism, that an old resource is permanently unavailable and has no forwarding
import static java.util.Collections.unmodifiableMap;
     * The response MAY be used in success, partial success and also in failure situations.
     * <p>  
    /**
     * Get category class of a rest status code.
     * <p>  
     * The method specified in the Request-Line is not allowed for the resource identified by the Request-URI.
     * the conditions under which the request was issued.  
     * codes might be appropriate. The default Multi-Status response body is a text/xml or application/xml HTTP  
     * A cache MUST NOT combine a 206 response with other previously cached content if the ETag or Last-Modified
     * The 202 response is intentionally non-committal. Its purpose is to allow a server to accept a request for
     * resource given by a Location header field. The response SHOULD include an entity containing a list of resource
     * other entity-headers. Otherwise (i.e., the conditional GET used a weak validator), the response MUST NOT
     * <p>
     * If the response could be unacceptable, a user agent SHOULD temporarily stop receipt of more data and query
     * automatically. However, this specification does not define any standard for such automatic selection.
    RestStatus(int status) {
     * This code is reserved for future use.
    /**  
     */
            return StatusType.USER_ERROR.toString();
     * to interpret. This rare condition is only likely to occur when a client has improperly converted a POST  
     * The different URI SHOULD be given by the Location field in the response. Unless the request method was
     */  
 * software distributed under the License is distributed on an
    NO_CONTENT(204),  
     * headers sent in the request. In some cases, this may even be preferable to sending a 406 response. User
     * agents are encouraged to inspect the headers of an incoming response to determine if it is acceptable.
 *  
     * MUST NOT automatically redirect the request unless it can be confirmed by the user, since this might change
     * Although '207' is used as the overall response status code, the recipient needs to consult the contents
    OK(200),
     * A cache that does not support the Range and Content-Range headers MUST NOT cache 206 (Partial) responses.
    LOCKED(423),
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**  
     * by the requested resource for the requested method.  
     * The temporary URI SHOULD be given by the Location field in the response. Unless the request method was
            return StatusType.SUCCESS.toString();
 */
     * automatically. However, this specification does not define any standard for such automatic selection.
    /**
     * If known, the length of the delay MAY be indicated in a Retry-After header. If no Retry-After is given,  
     * Turn a status code into a {@link RestStatus}, returning null if we don't know that status.
     */  
     * <li>HEAD: the entity-header fields corresponding to the requested resource are sent in the response without any message-body;</li>
     * This response is cacheable unless indicated otherwise.  
                return RestStatus.SERVICE_UNAVAILABLE;
        if (failures.length == 0) {
    /**
     * The 'multistatus' root element holds zero or more 'response' elements in any order, each with  
     * <p>
 * Modifications Copyright OpenSearch Contributors. See
        } else if (family == 4) {
    public String getStatusType() {
     * source of the conflict. Ideally, the response entity would include enough information for the user or user
     * <p>
 * specific language governing permissions and limitations
     * in attempting to complete the request.
     * is expected to be considered permanent. Clients with link editing capabilities SHOULD delete references to
     * not the condition is permanent, the status code 404 (Not Found) SHOULD be used instead. This response is  
     * the client SHOULD handle the response as it would for a 500 response.
    METHOD_NOT_ALLOWED(405),
    SWITCHING_PROTOCOLS(101),
     * <p>
    private int status;  
     * The requested resource resides temporarily under a different URI. Since the redirection MAY be altered on
     */
     * </ul>
     * @return Integer representing class category of the concrete rest status code
     * <p>  
     * gives the URI of the proxy. The recipient is expected to repeat this single request via the proxy.
    /**  
     * the user agent's connection to the server persist until the process is completed. The entity returned with
     */  
     * In this case, the response entity would likely contain a list of the differences between the two versions in
     * selected resource, and the request did not include an If-Range request-header field. (For byte-ranges, this  
     * applied to the document currently in the user agent's active view.
     * This response is cacheable unless indicated otherwise.
     * If the 401 response contains the same challenge as the prior response, and the user agent has already attempted
    /**  
     * (section 14.42), for a change in the application protocol being used on this connection. The server will
     */  
     */
     * The server is refusing to process a request because the request entity is larger than the server is willing  
    HTTP_VERSION_NOT_SUPPORTED(505),
    UNPROCESSABLE_ENTITY(422),
    NOT_ACCEPTABLE(406),
            // 4xx errors correspond with errors on the client side  
     * The 422 (Unprocessable Entity) status code means the server understands the content type of the request
     */
     * this response SHOULD include an indication of the request's current status and either a pointer to a status
     */  
    /**
     * instead.
    /**
    PRECONDITION_FAILED(412),
     * <p>
 *
 * Licensed to Elasticsearch under one or more contributor  
    /**  
     * HEAD, the entity of the response SHOULD contain a short hypertext note with a hyperlink to the new URI(s).
     * If the client is a user agent, it SHOULD NOT change its document view from that which caused the request
     * SHOULD contain an appropriate precondition or postcondition code, such as 'lock-token-submitted' or
     * The entity format is specified by the media type given in the Content-Type header field. Depending upon the
     */  
    }
    FORBIDDEN(403),  
    PAYMENT_REQUIRED(402),
     * characteristics and location(s) from which the user or user agent can choose the one most appropriate.
     * authentication at least once, then the user SHOULD be presented the entity that was given in the response,
    public static RestStatus status(int successfulShards, int totalShards, ShardOperationFailedException... failures) {
    UNAUTHORIZED(401),  
    /**
     * of an If-Range request that used a weak validator, the response MUST NOT include other entity-headers;  
    INSUFFICIENT_STORAGE(507);  
    /**
     * (section 14.47) containing a challenge applicable to the requested resource. The client MAY repeat the request
     * entity is correct (thus a 400 (Bad Request) status code is inappropriate) but was unable to process the  
     */
    GONE(410),
     */
     * The response MUST include an Allow header containing a list of valid methods for the requested resource.
     * <li>Either a Content-Range header field (section 14.16) indicating the range included with this response,  
     * The requested resource MUST be accessed through the proxy given by the Location field. The Location field
     */
     * repeat the request without modifications at any later time.  
        }
    MULTIPLE_CHOICES(300),
    NOT_IMPLEMENTED(501),  
        }
    public static RestStatus fromCode(int code) {  
    CONFLICT(409),
     * If the 206 response is the result of an If-Range request that used a strong cache validator
     * The server does not support, or refuses to support, the HTTP protocol version that was used in the request
     * The new permanent URI SHOULD be given by the Location field in the response. Unless the request method  
package org.opensearch.core.rest;
     * to identify the resource.
     * since many pre-HTTP/1.1 user agents do not understand the 307 status. Therefore, the note SHOULD contain
     * The server does not support the functionality required to fulfill the request. This is the appropriate
     * is temporary and after what time the client MAY try again.
     * The server is refusing to service the request because the entity of the request is in a format not supported
     * Note: HTTP/1.1 servers are allowed to return responses which are not acceptable according to the accept  
     * <ul>  
     * which terminates the 101 response.  
     * the user for a decision on further actions.
     * The request has been fulfilled and resulted in a new resource being created. The newly created resource can  
     */  
     */
 * the Apache License, Version 2.0 (the "License"); you may
 *
     * used in the request, for example:
    RESET_CONTENT(205),
     * The 424 (Failed Dependency) status code means that the method could not be performed on the resource because  
     * The resource identified by the request is only capable of generating response entities which have content  
     * correctly.  
     * characteristics not acceptable according to the accept headers sent in the request.
     * resource be removed. Such an event is common for limited-time, promotional services and for resources belonging
     * or, if the server is a proxy, the server has unambiguous evidence that the request could not be met by the
import java.util.HashMap;
            return RestStatus.OK;  
     */
    NOT_MODIFIED(304),
            return status;
     */
     * request without modifications.
 * The OpenSearch Contributors require contributions made to  
     * only allowed in situations where it is expected that the user might be able to resolve the conflict and
     * The response MUST include the following header fields:
        if (family <= 3) {  
     * that resource. This method exists primarily to allow the output of a POST-activated script to redirect the
            for (ShardOperationFailedException failure : failures) {
     * be referenced by the URI(s) returned in the entity of the response, with the most specific URI for the
     * The requested resource resides temporarily under a different URI. Since the redirection might be altered on  
    /**  
     * The server understood the request, but is refusing to fulfill it. Authorization will not help and the request  
     */
     * <li>Expires, Cache-Control, and/or Vary, if the field-value might differ from that sent in any previous  
     * occasion, the client SHOULD continue to use the Request-URI for future requests.  This response is only
        if (successfulShards == 0 && totalShards > 0) {  
     * If the client has performed a conditional GET request and access is allowed, but the document has not been  
     * modified, the server SHOULD respond with this status code. The 304 response MUST NOT contain a message-body,
     * (see section 13.3.3), the response SHOULD NOT include other entity-headers. If the response is the result
     * The response MUST include the following header fields:
     * conditions under which the request was issued.  
        int family = getStatusFamilyCode();
    SEE_OTHER(303),
     * version as the client, as described in section 3.1, other than with this error message. The response SHOULD
     * the selected resource.)
     */
     * is no facility for re-sending a status code from an asynchronous operation such as this.  
    /**
     * request has not been fulfilled, it SHOULD describe the reason for the refusal in the entity.  If the server
     * cacheable if indicated by a Cache-Control or Expires header field.  
        this.status = (short) status;  
     * HEAD, the entity of the response SHOULD contain a short hypertext note with a hyperlink to the new URI(s).
     * The client SHOULD continue with its request. This interim response is used to inform the client that the
     * that server.  
     * response MUST NOT use the multipart/byteranges content-type.  
     */  
     * SHOULD continue by sending the remainder of the request or, if the request has already been completed,
    /**  
     */
     */
 * license agreements. See the NOTICE file distributed with
     * the proxy. The proxy MUST return a Proxy-Authenticate header field (section 14.33) containing a challenge
public enum RestStatus {  
     * that is not configured to produce responses for the combination of scheme and authority that are included
    /**
     * the request MUST NOT be repeated until it is requested by a separate user action.
     * The 204 response MUST NOT include a message-body, and thus is always terminated by the first empty  
     * resubmit the request. The response body SHOULD include enough information for the user to recognize the  
     * the server. This response code allows the client to place preconditions on the current resource metainformation  
     * (header field data) and thus prevent the requested method from being applied to a resource other than the one
     * cacheable unless indicated otherwise.
     * ignore this response. The server MUST send a final response after the request has been completed.
     */
     * response for the same variant</li>
     * cacheable.
     * <p>
     * of the multistatus response body for further information about the success or failure of the method execution.  
     * The server has fulfilled the request and the user agent SHOULD reset the document view which caused the
     * A Multi-Status response conveys information about multiple resources in situations where multiple status
     * monitor or some estimate of when the user can expect the request to be fulfilled.  
     * <p>
        return status;
     */
     * <p>
     * user agent to a selected resource. The new URI is not a substitute reference for the originally requested  
     * resource. The 303 response MUST NOT be cached, but the response to the second (redirected) request might be
    }
     */
    /**
     * accessed in attempting to fulfill the request.  
     * The request could not be completed due to a conflict with the current state of the resource. This code is
     */
     * and thus is always terminated by the first empty line after the header fields.
     * The 410 response is primarily intended to assist the task of web maintenance by notifying the recipient  
     * include other entity-headers; this prevents inconsistencies between cached entity-bodies and updated headers.  
     */
    NON_AUTHORITATIVE_INFORMATION(203),
     * XML element.  
    CREATED(201),
     * result in a super set of the meta information known by the origin server. Use of this response code
     */
    public int getStatus() {  
     * entity-header field specifying the current length of the selected resource (see section 14.16). This
     * <p>
    /**
     * and repeat the request without the conditional.  
     * headers do not match exactly, see 13.5.4.
    /**
     * entity (hence a 415(Unsupported Media Type) status code is inappropriate), and the syntax of the request
     * <p>
    UNSUPPORTED_MEDIA_TYPE(415),
     * request to be sent. This response is primarily intended to allow input for actions to take place via user  
    REQUESTED_RANGE_NOT_SATISFIED(416),
    /**  
    /**
     * response received without one (as already specified by [RFC 2068], section 14.19), caches will operate
    }
    /**
    /**  
 * under the License.  
    /**
     * The 507 (Insufficient Storage) status code means the method could not be performed on the resource because
    TEMPORARY_REDIRECT(307),
        }
     * The server is refusing to service the request because the Request-URI is longer than the server is willing
    /**
 * this file be licensed under the Apache-2.0 license or a
     * The entity format is specified by the media type given in the Content-Type header field. Depending upon the  
     * was HEAD, the entity of the response SHOULD contain a short hypertext note with a hyperlink to the new URI(s).
     * <p>
     * a format defined by the response Content-Type.
     * The client did not produce a request within the time that the server was prepared to wait. The client MAY
 * not use this file except in compliance with the License.
     * The requested resource corresponds to any one of a set of representations, each with its own specific  
     * The temporary URI SHOULD be given by the Location field in the response. Unless the request method was
    /**
     */
     * since that entity might include relevant diagnostic information. HTTP access authentication is explained in  
     * <ul>
     * cacheable if indicated by a Cache-Control or Expires header field.
    public static void writeTo(StreamOutput out, RestStatus status) throws IOException {  
     * <ul>
     * <p>
     * The server has not found anything matching the Request-URI. No indication is given of whether the condition
     * is temporary or permanent. The 410 (Gone) status code SHOULD be used if the server knows, through some  
     * format and the capabilities of the user agent, selection of the most appropriate choice MAY be performed  
     * <p>  
     * header field (section 14.35) indicating the desired range, and MAY have included an If-Range header
                    status = failure.status();
     * applicable to the proxy for the requested resource. The client MAY repeat the request with a suitable
     */
    static {  
    /**  
import org.opensearch.core.common.io.stream.StreamOutput;
    FAILED_DEPENDENCY(424),
    /**
     * used and the entity being PUT included changes to a resource which conflict with those made by an earlier
     * for the requested variant just created, see section 14.19.  
     * is not required and is only appropriate when the response would otherwise be 200 (OK).
        return RestStatus.valueOf(in.readString());  
     * response for the same variant</li>
     * The server refuses to accept the request without a defined Content-Length. The client MAY repeat the request  
    /**
     * the server is unable to store the representation needed to successfully complete the request. This condition
     * the conditions under which the request was issued.
 * compatible open source license.
     * SHOULD NOT be repeated. If the request method was not HEAD and the server wishes to make public why the
     * If the condition is temporary, the server SHOULD include a Retry-After header field to indicate that it  
     * owner.
     * or able to process. The server MAY close the connection to prevent the client from continuing the request.
     * agent to fix the problem; however, that might not be possible and is not required.
     * When this status code is returned for a byte-range request, the response SHOULD include a Content-Range
    /**  
import org.opensearch.core.common.io.stream.StreamInput;  
 *
     * references to the Request-URI to one or more of the new references returned by the server, where possible.  
    ACCEPTED(202),
     * The server understands and is willing to comply with the client's request, via the Upgrade message header field  
        return CODE_TO_STATUS.get(code);
    /**
        } else {
     * entity format is specified by the media type given in the Content-Type header field. The origin server MUST
/**  
     * <p>  
     * generated during the method invocation. 100 series status codes SHOULD NOT be recorded in a 'response'
     * if it adds a valid Content-Length header field containing the length of the message-body in the request message.
     * 305 responses MUST only be generated by origin servers.  
     * intended.
     */
     * or a multipart/byteranges Content-Type including Content-Range fields for each part. If a Content-Length
import org.opensearch.common.annotation.PublicApi;
     * contain an entity describing why that version is not supported and what other protocols are supported by
    SERVICE_UNAVAILABLE(503),  
     * address. This status code is commonly used when the server does not wish to reveal exactly why the request
 * KIND, either express or implied.  See the License for the
     */  
 * SPDX-License-Identifier: Apache-2.0
     * switch protocols to those defined by the response's Upgrade header field immediately after the empty line
     * some other process (perhaps a batch-oriented process that is only run once per day) without requiring that  
        for (RestStatus value : values) {  
    }
        out.writeString(status.name());
     * SHOULD use one of the returned URIs.  Clients with link editing capabilities ought to automatically re-link
     */
@PublicApi(since = "1.0.0")
     * The precondition given in one or more of the request-header fields evaluated to false when it was tested on
     * This code is similar to 401 (Unauthorized), but indicates that the client must first authenticate itself with  
     * <li>POST: an entity describing or containing the result of the action;</li>  
     * request to a GET request with long query information, when the client has descended into a URI "black hole"
                RestStatus shardStatus = failure.status();
        return status;  
    /**  
     * 429 Too Many Requests (RFC6585)  
     * the requested action depended on another action and that action failed. For example, if a command in a
     * the message-body.</li>  
     * <li>Date, unless its omission is required by section 14.18.1  
     */  
     * next-hop server.  
     * If a cache uses a received 304 response to update a cache entry, the cache MUST update the entry to
     *  
    INTERNAL_SERVER_ERROR(500),  
     * The returned meta information in the entity-header is not the definitive set as available from the origin
     * <p>  
     * change to the user agent's active document view, although any new or updated meta information SHOULD be  
     * <p>  
     * include all of the entity-headers that would have been returned with a 200 (OK) response to the same request.
    MULTI_STATUS(207),
    /**  
            }  
     * specified by the URI (e.g. HTTP, FTP, LDAP) or some other auxiliary server (e.g. DNS) it needed to access  
     * The response to the request can be found under a different URI and SHOULD be retrieved using a GET method on
 * OpenSearch REST status
     */  
     * more information).  
     * If the 302 status code is received in response to a request other than GET or HEAD, the user agent
     * <p>  
     * The server encountered an unexpected condition which prevented it from fulfilling the request.
    /**  
    MOVED_PERMANENTLY(301),
     * If a 304 response indicates an entity not currently cached, then the cache MUST disregard the response
            return StatusType.SYSTEM_FAILURE.toString();
 */
     * another input action. The response MUST NOT include an entity.
     * The requested resource is no longer available at the server and no forwarding address is known. This condition  
     * server, but is gathered from a local or a third-party copy. The set presented MAY be a subset or super set
     * MUST NOT automatically redirect the request unless it can be confirmed by the user, since this might change
     * credentials, then the 401 response indicates that authorization has been refused for those credentials.  
     * The server, while acting as a gateway or proxy, received an invalid response from the upstream server it
     * "HTTP Authentication: Basic and Digest Access Authentication" [43].
    USE_PROXY(305),
                if (shardStatus.getStatus() >= status.getStatus()) {  
     * contained instructions. For example, this error condition may occur if an XML request body contains
     * is considered to be temporary. If the request that received this status code was the result of a user action,  
    PROXY_AUTHENTICATION(407),  
    GATEWAY_TIMEOUT(504),  
     * The server has fulfilled the request but does not need to return an entity-body, and might want to return  
     * <p>  
     * create the resource before returning the 201 status code. If the action cannot be carried out immediately, the
