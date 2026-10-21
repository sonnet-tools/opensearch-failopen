     * The server does not support, or refuses to support, the HTTP protocol version that was used in the request
     * or able to process. The server MAY close the connection to prevent the client from continuing the request.
     */
     * the request MUST NOT be repeated until it is requested by a separate user action.
     * applicable to the proxy for the requested resource. The client MAY repeat the request with a suitable
     * The server understands and is willing to comply with the client's request, via the Upgrade message header field
     * The 'multistatus' root element holds zero or more 'response' elements in any order, each with
                    status = failure.status();
    OK(200),
     * create the resource before returning the 201 status code. If the action cannot be carried out immediately, the
    /**
     * that server.
     * The server, while acting as a gateway or proxy, received an invalid response from the upstream server it
    /**
     * </ul>
    }
     * to be sent. This response is primarily intended to allow input for actions to take place without causing a
     * <li>Date, unless its omission is required by section 14.18.1
 * You may obtain a copy of the License at
    CREATED(201),
     * correctly.
     */
     * The request has succeeded. The information returned with the response is dependent on the method
     * The requested resource resides temporarily under a different URI. Since the redirection MAY be altered on
     * Unless it was a HEAD request, the response SHOULD include an entity containing a list of resource
     */
     * headers do not match exactly, see 13.5.4.
     * The server is refusing to service the request because the Request-URI is longer than the server is willing
     */
     * The 424 (Failed Dependency) status code means that the method could not be performed on the resource because
    REQUEST_URI_TOO_LONG(414),
     * The method specified in the Request-Line is not allowed for the resource identified by the Request-URI.
 * not use this file except in compliance with the License.
     */
    PRECONDITION_FAILED(412),
     * agent to fix the problem; however, that might not be possible and is not required.
     */
     * response MUST NOT use the multipart/byteranges content-type.
     * automatically. However, this specification does not define any standard for such automatic selection.
 * the Apache License, Version 2.0 (the "License"); you may
     * in attempting to complete the request.
     * <p>
     * input, followed by a clearing of the form in which the input is given so that the user can easily initiate
    }
     * is temporary or permanent. The 410 (Gone) status code SHOULD be used if the server knows, through some
     * The response MUST include the following header fields:
     * codes might be appropriate. The default Multi-Status response body is a text/xml or application/xml HTTP
     * Get category class of a rest status code.
import static java.util.Collections.unmodifiableMap;
     * request to be sent. This response is primarily intended to allow input for actions to take place via user
    /**
    UNSUPPORTED_MEDIA_TYPE(415),
                return RestStatus.SERVICE_UNAVAILABLE;
     * The expectation given in an Expect request-header field (see section 14.20) could not be met by this server,
     * cacheable if indicated by a Cache-Control or Expires header field.
    /**
    FOUND(302),
     * If the 307 status code is received in response to a request other than GET or HEAD, the user agent MUST NOT
    RESET_CONTENT(205),
    CONTINUE(100),
    MULTIPLE_CHOICES(300),
/*
     * server SHOULD respond with 202 (Accepted) response instead.
     */
     * <p>
     * generated during the method invocation. 100 series status codes SHOULD NOT be recorded in a 'response'
            return StatusType.SYSTEM_FAILURE.toString();
     * The temporary URI SHOULD be given by the Location field in the response. Unless the request method was
     * that resource. This method exists primarily to allow the output of a POST-activated script to redirect the
    /**
     * <p>
    public int getStatusFamilyCode() {
     */
    /**
     */
     * reflect any new field values given in the response.
import org.opensearch.core.common.io.stream.StreamOutput;
 * SPDX-License-Identifier: Apache-2.0
    static {
     * resubmit the request. The response body SHOULD include enough information for the user to recognize the
     * selected resource, and the request did not include an If-Range request-header field. (For byte-ranges, this
     * <p>
     * and thus is always terminated by the first empty line after the header fields.
    /**
    NOT_IMPLEMENTED(501),
     * user agent to a selected resource. The new URI is not a substitute reference for the originally requested
    /**
     * that is not configured to produce responses for the combination of scheme and authority that are included
    public int getStatus() {
     * "HTTP Authentication: Basic and Digest Access Authentication" [43].
        RestStatus status = RestStatus.OK;
     * The resource identified by the request is only capable of generating response entities which have content
     * <p>
     * The 423 (Locked) status code means the source or destination resource of a method is locked. This response
    MISDIRECTED_REQUEST(421),
     * for the requested variant just created, see section 14.19.
     * The response MUST include the following header fields:
     * The client did not produce a request within the time that the server was prepared to wait. The client MAY
    /**
    public static RestStatus readFrom(StreamInput in) throws IOException {
     * The different URI SHOULD be given by the Location field in the response. Unless the request method was
        if (failures.length == 0) {
     * (section 14.42), for a change in the application protocol being used on this connection. The server will
     * <p>
     * by the requested resource for the requested method.
     * more information).
    /**
    /**
     * Unless it was a HEAD request, the response SHOULD include an entity containing a list of available entity
     */
     * resource given by a Location header field. The response SHOULD include an entity containing a list of resource
     */
 * this file be licensed under the Apache-2.0 license or a
    }
/**
    /**
     * gives the URI of the proxy. The recipient is expected to repeat this single request via the proxy.
     * </ul>
     * <p>
     * The request has been fulfilled and resulted in a new resource being created. The newly created resource can
    /**
    /**
     * the requested action depended on another action and that action failed. For example, if a command in a
    /**
     * If the condition is temporary, the server SHOULD include a Retry-After header field to indicate that it
     * <p>
     * <p>
    /**
     * HEAD, the entity of the response SHOULD contain a short hypertext note with a hyperlink to the new URI(s).
     * HEAD, the entity of the response SHOULD contain a short hypertext note with a hyperlink to the new URI(s) ,
     */
     */
     * in the request URI.
     * the server. This response code allows the client to place preconditions on the current resource metainformation
     * If the conditional GET used a strong cache validator (see section 13.3.3), the response SHOULD NOT include
     * modified, the server SHOULD respond with this status code. The 304 response MUST NOT contain a message-body,
    NO_CONTENT(204),
     * cacheable if indicated by a Cache-Control or Expires header field.
        } else {
     * the proxy. The proxy MUST return a Proxy-Authenticate header field (section 14.33) containing a challenge
     * the conditions under which the request was issued.
     * The 422 (Unprocessable Entity) status code means the server understands the content type of the request
    /**
    CONFLICT(409),
     * since that entity might include relevant diagnostic information. HTTP access authentication is explained in
     * (see section 13.3.3), the response SHOULD NOT include other entity-headers. If the response is the result
import org.opensearch.common.annotation.PublicApi;
     * A 201 response MAY contain an ETag response header field indicating the current value of the entity tag
     * The requested resource has been assigned a new permanent URI and any future references to this resource
     * this response SHOULD include an indication of the request's current status and either a pointer to a status
     * Proxy-Authorization header field (section 14.34). HTTP access authentication is explained in
        out.writeString(status.name());
     * The response MUST include an Allow header containing a list of valid methods for the requested resource.
 * this work for additional information regarding copyright
     * include other entity-headers; this prevents inconsistencies between cached entity-bodies and updated headers.
    BAD_GATEWAY(502),
     * address. This status code is commonly used when the server does not wish to reveal exactly why the request
 *    http://www.apache.org/licenses/LICENSE-2.0
     * Conflicts are most likely to occur in response to a PUT request. For example, if versioning were being
     */
    /**
 * under the License.
     * The entity format is specified by the media type given in the Content-Type header field. Depending upon the
     * line after the header fields.
    /**
import org.opensearch.core.common.io.stream.StreamInput;
     * <p>
            for (ShardOperationFailedException failure : failures) {
     * The server, while acting as a gateway or proxy, did not receive a timely response from the upstream server
     * <p>
     * cacheable unless indicated otherwise.
     * of the multistatus response body for further information about the success or failure of the method execution.
     * the conditions under which the request was issued.
    /**
     * @return Integer representing class category of the concrete rest status code
     * The requested resource MUST be accessed through the proxy given by the Location field. The Location field
     * conditions under which the request was issued.
     * (third-party) request, the server might use the 409 response to indicate that it can't complete the request.
     * <li>HEAD: the entity-header fields corresponding to the requested resource are sent in the response without any message-body;</li>
     * is temporary and after what time the client MAY try again.
     * include all of the entity-headers that would have been returned with a 200 (OK) response to the same request.
     * The server does not support the functionality required to fulfill the request. This is the appropriate
     * version as the client, as described in section 3.1, other than with this error message. The response SHOULD
import org.opensearch.core.action.ShardOperationFailedException;
     * entity-headers, which if present SHOULD be associated with the requested variant.
     * the user agent's connection to the server persist until the process is completed. The entity returned with
     */
     *
     * The server encountered an unexpected condition which prevented it from fulfilling the request.
     * Although '207' is used as the overall response status code, the recipient needs to consult the contents
 */
    FAILED_DEPENDENCY(424),
     * does not wish to make this information available to the client, the status code 404 (Not Found) can be used
    /**
    /**
        return status;
     * SHOULD continue by sending the remainder of the request or, if the request has already been completed,
     * characteristics and location(s) from which the user or user agent can choose the one most appropriate.
     * The returned meta information in the entity-header is not the definitive set as available from the origin
     * MUST NOT automatically redirect the request unless it can be confirmed by the user, since this might change
 *
     */
     * occasion, the client SHOULD continue to use the Request-URI for future requests.  This response is only
        return RestStatus.valueOf(in.readString());
 */
     * or, if the server is a proxy, the server has unambiguous evidence that the request could not be met by the
     * XML element.
     * If the client is a user agent, it SHOULD NOT change its document view from that which caused the request
     * used and the entity being PUT included changes to a resource which conflict with those made by an earlier
    LOCKED(423),
     * 305 responses MUST only be generated by origin servers.
 * Licensed to Elasticsearch under one or more contributor
        return status;
     * format and the capabilities of the user agent, selection of the most appropriate choice MAY be performed
    /**
     * headers sent in the request. In some cases, this may even be preferable to sending a 406 response. User
     * resource. The 303 response MUST NOT be cached, but the response to the second (redirected) request might be
    UNPROCESSABLE_ENTITY(422),
     * If the 401 response contains the same challenge as the prior response, and the user agent has already attempted
    public String getStatusType() {
    SEE_OTHER(303),
    ACCEPTED(202),
    }
     * <p>
/*
        this.status = (short) status;
     * HEAD, the entity of the response SHOULD contain a short hypertext note with a hyperlink to the new URI(s).
    USE_PROXY(305),
        return CODE_TO_STATUS.get(code);
     * message. The server is indicating that it is unable or unwilling to complete the request using the same major
    /**
     * and repeat the request without the conditional.
    SERVICE_UNAVAILABLE(503),
     * <p>
 * @opensearch.api
     * <p>
    /**
            codeToStatus.put(value.status, value);
     * buffers for reading or manipulating the Request-URI.
     */
            if (successfulShards == 0 && totalShards > 0) {
     * <p>
     * If a clockless origin server obeys these rules, and proxies and clients add their own Date to any
            // 4xx errors correspond with errors on the client side
     * server, but is gathered from a local or a third-party copy. The set presented MAY be a subset or super set
     * other entity-headers. Otherwise (i.e., the conditional GET used a weak validator), the response MUST NOT
    NOT_FOUND(404),
     * automatically. However, this specification does not define any standard for such automatic selection.
    UNAUTHORIZED(401),
     * applied to the document currently in the user agent's active view.
     * The response to the request can be found under a different URI and SHOULD be retrieved using a GET method on
     * to individuals no longer working at the server's site. It is not necessary to mark all permanently unavailable
     * MUST NOT automatically redirect the request unless it can be confirmed by the user, since this might change
     * cacheable.
    /**
     * a format defined by the response Content-Type.
 * OpenSearch REST status
 * The OpenSearch Contributors require contributions made to
     * The 507 (Insufficient Storage) status code means the method could not be performed on the resource because
     * If the 206 response is the result of an If-Range request that used a strong cache validator
     * response when the server does not recognize the request method and is not capable of supporting it for any
     * credentials, then the 401 response indicates that authorization has been refused for those credentials.
    /**
     */
     * of the original version. For example, including local annotation information about the resource might
     * In this case, the response entity would likely contain a list of the differences between the two versions in
     * entity is correct (thus a 400 (Bad Request) status code is inappropriate) but was unable to process the
     * that the resource is intentionally unavailable and that the server owners desire that remote links to that
     * </li>
     * If the client has performed a conditional GET request and access is allowed, but the document has not been
     * the selected resource.)
    PROXY_AUTHENTICATION(407),
        RestStatus[] values = values();
     * be referenced by the URI(s) returned in the entity of the response, with the most specific URI for the
    /**
    NOT_MODIFIED(304),
     * not the condition is permanent, the status code 404 (Not Found) SHOULD be used instead. This response is
    }
     * next-hop server.
     * <li>TRACE: an entity containing the request message as received by the end server.</li>
 * ownership. Elasticsearch licenses this file to you under
     * which terminates the 101 response.
            return StatusType.SUCCESS.toString();
     * <ul>
     * If the response could be unacceptable, a user agent SHOULD temporarily stop receipt of more data and query
     * this prevents inconsistencies between cached entity-bodies and updated headers. Otherwise, the response MUST
            }
    /**
    FORBIDDEN(403),
     * This response is cacheable unless indicated otherwise.
     */
     * If the server has a preferred choice of representation, it SHOULD include the specific URI for that
    TOO_MANY_REQUESTS(429),
     * <li>GET: an entity corresponding to the requested resource is sent in the response;</li>
     * This code is reserved for future use.
        Map<Integer, RestStatus> codeToStatus = new HashMap<>(values.length);
        if (successfulShards == 0 && totalShards > 0) {
     * A Multi-Status response conveys information about multiple resources in situations where multiple status
     * <p>
     * agent) can select a preferred representation and redirect its request to that location.
     * The 204 response MUST NOT include a message-body, and thus is always terminated by the first empty
    /**
    private static final Map<Integer, RestStatus> CODE_TO_STATUS;
     */
     */
                if (shardStatus.getStatus() >= status.getStatus()) {
    /**
    /**
     * owner.
     * The temporary URI SHOULD be given by the Location field in the response. Unless the request method was
     * contained instructions. For example, this error condition may occur if an XML request body contains
     * The server has fulfilled the request but does not need to return an entity-body, and might want to return
     * The client SHOULD continue with its request. This interim response is used to inform the client that the
    EXPECTATION_FAILED(417),
     * references to the Request-URI to one or more of the new references returned by the server, where possible.
 * GitHub history for details.
        CODE_TO_STATUS = unmodifiableMap(codeToStatus);
     * has been refused, or when no other response is applicable.
     * <li>Expires, Cache-Control, and/or Vary, if the field-value might differ from that sent in any previous
     * contain an entity describing why that version is not supported and what other protocols are supported by
     * If the 301 status code is received in response to a request other than GET or HEAD, the user agent
     * The server has fulfilled the partial GET request for the resource. The request MUST have included a Range
     * The 410 response is primarily intended to assist the task of web maintenance by notifying the recipient
     * well-formed (i.e., syntactically correct), but semantically erroneous, XML instructions.
     * <li>ETag and/or Content-Location, if the header would have been sent in a 200 response to the same request</li>
    /**
     */
     * <p>
     * the information necessary for a user to repeat the original request on the new URI.
     * with a suitable Authorization header field (section 14.8). If the request already included Authorization
    MULTI_STATUS(207),
     * result in a super set of the meta information known by the origin server. Use of this response code
     * the user for a decision on further actions.
    }
     */
import java.util.HashMap;
            return StatusType.USER_ERROR.toString();
     * or might not eventually be acted upon, as it might be disallowed when processing actually takes place. There
import java.io.IOException;
     * <li>Expires, Cache-Control, and/or Vary, if the field-value might differ from that sent in any previous
     * header field (section 14.35) indicating the desired range, and MAY have included an If-Range header
    INSUFFICIENT_STORAGE(507);
     * only allowed in situations where it is expected that the user might be able to resolve the conflict and
     * <li>Either a Content-Range header field (section 14.16) indicating the range included with this response,
     * If a cache uses a received 304 response to update a cache entry, the cache MUST update the entry to
     */
     */
        return status / 100;
    /**
     * <ul>
     * request has not been fulfilled, it SHOULD describe the reason for the refusal in the entity.  If the server
    }
    REQUESTED_RANGE_NOT_SATISFIED(416),
     * occasion, the client SHOULD continue to use the Request-URI for future requests.  This response is only
     * This response is cacheable unless indicated otherwise.
     */
    /**
     * response for the same variant</li>
     * A cache MUST NOT combine a 206 response with other previously cached content if the ETag or Last-Modified
     * The requested resource is no longer available at the server and no forwarding address is known. This condition
     * The precondition given in one or more of the request-header fields evaluated to false when it was tested on
     */
     * change to the user agent's active document view, although any new or updated meta information SHOULD be
    /**
    /**
     * The requested resource corresponds to any one of a set of representations, each with its own specific
 *
                }
package org.opensearch.core.rest;
    PAYMENT_REQUIRED(402),
     * to interpret. This rare condition is only likely to occur when a client has improperly converted a POST
     * entity format is specified by the media type given in the Content-Type header field. The origin server MUST
     * characteristics and location(s) from which the user or user agent can choose the one most appropriate.
    /**
     * <p>
            return RestStatus.OK;
     * The request requires user authentication. The response MUST include a WWW-Authenticate header field
     * 'no-conflicting-lock'.
     * The server has not found anything matching the Request-URI. No indication is given of whether the condition
     * since many pre-HTTP/1.1 user agents do not understand the 307 status. Therefore, the note SHOULD contain
     * of redirection (e.g., a redirected URI prefix that points to a suffix of itself), or when the server is
    METHOD_NOT_ALLOWED(405),
 * KIND, either express or implied.  See the License for the
     * entity-header field specifying the current length of the selected resource (see section 14.16). This
    /**
    LENGTH_REQUIRED(411),
     * is no facility for re-sending a status code from an asynchronous operation such as this.
     * This code is similar to 401 (Unauthorized), but indicates that the client must first authenticate itself with
     */
     * the Request-URI after user approval. If the server does not know, or has no facility to determine, whether or
     * The request has been accepted for processing, but the processing has not been completed.  The request might
    /**
     * means that the first-byte-pos of all of the byte-range-spec values were greater than the current length of
     * internally configurable mechanism, that an old resource is permanently unavailable and has no forwarding
     * server. The implication is that this is a temporary condition which will be alleviated after some delay.
 * software distributed under the License is distributed on an
     * is not required and is only appropriate when the response would otherwise be 200 (OK).
    TEMPORARY_REDIRECT(307),
     * The request could not be understood by the server due to malformed syntax. The client SHOULD NOT repeat the
     * response received without one (as already specified by [RFC 2068], section 14.19), caches will operate
    /**
     * format and the capabilities of the user agent, selection of the most appropriate choice MAY be performed
    }
     */
     * <li>POST: an entity describing or containing the result of the action;</li>
                RestStatus shardStatus = failure.status();
     * of an If-Range request that used a weak validator, the response MUST NOT include other entity-headers;
    /**
     * response for the same variant</li>
     * SHOULD use one of the returned URIs.  Clients with link editing capabilities ought to automatically re-link
     */
     * (section 14.47) containing a challenge applicable to the requested resource. The client MAY repeat the request
    /**
        } else if (family == 4) {
     * ignore this response. The server MUST send a final response after the request has been completed.
     * A cache that does not support the Range and Content-Range headers MUST NOT cache 206 (Partial) responses.
     */
     */
     * <p>
     * <ul>
    PARTIAL_CONTENT(206),
     * request to a GET request with long query information, when the client has descended into a URI "black hole"
     * automatically redirect the request unless it can be confirmed by the user, since this might change the
     * SHOULD NOT be repeated. If the request method was not HEAD and the server wishes to make public why the
     * <li>ETag and/or Content-Location, if the header would have been sent in a 200 response to the same request</li>
     * monitor or some estimate of when the user can expect the request to be fulfilled.
     * When this status code is returned for a byte-range request, the response SHOULD include a Content-Range
     * <p>
    GATEWAY_TIMEOUT(504),
    public static void writeTo(StreamOutput out, RestStatus status) throws IOException {
     * The server refuses to accept the request without a defined Content-Length. The client MAY repeat the request
     */
     * <p>
     */
    public static RestStatus status(int successfulShards, int totalShards, ShardOperationFailedException... failures) {
     * <p>
     * if it adds a valid Content-Length header field containing the length of the message-body in the request message.
    public static RestStatus fromCode(int code) {
     * source of the conflict. Ideally, the response entity would include enough information for the user or user
            return status;
     * repeat the request without modifications at any later time.
     * PROPPATCH method fails, then, at minimum, the rest of the commands will also fail with 424 (Failed Dependency).
     * to identify the resource.
     * "HTTP Authentication: Basic and Digest Access Authentication" [43].
     * If the 302 status code is received in response to a request other than GET or HEAD, the user agent
        int family = getStatusFamilyCode();
     * specified by the URI (e.g. HTTP, FTP, LDAP) or some other auxiliary server (e.g. DNS) it needed to access
    /**
     * characteristics not acceptable according to the accept headers sent in the request.
     * (header field data) and thus prevent the requested method from being applied to a resource other than the one
     */
     * resource.
    /**
    REQUEST_ENTITY_TOO_LARGE(413),
    SWITCHING_PROTOCOLS(101),
     * authentication at least once, then the user SHOULD be presented the entity that was given in the response,
    /**
     * <p>
    /**
     * The server has fulfilled the request and the user agent SHOULD reset the document view which caused the
     * The requested resource resides temporarily under a different URI. Since the redirection might be altered on
     * entity with a 'multistatus' root element. Further elements contain 200, 300, 400, and 500 series status codes
     * used in the request, for example:
     * If a 304 response indicates an entity not currently cached, then the cache MUST disregard the response
     * The new permanent URI SHOULD be given by the Location field in the response. Unless the request method
     */
     * The request was directed at a server that is not able to produce a response. This can be sent by a server
        }
     * initial part of the request has been received and has not yet been rejected by the server. The client
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * The server understood the request, but is refusing to fulfill it. Authorization will not help and the request
 * compatible open source license.
     * SHOULD contain an appropriate precondition or postcondition code, such as 'lock-token-submitted' or
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Map;
 *
     */
     * under attack by a client attempting to exploit security holes present in some servers using fixed-length
     * request without modifications.
    GONE(410),
    NON_AUTHORITATIVE_INFORMATION(203),
     * agents are encouraged to inspect the headers of an incoming response to determine if it is acceptable.
     * The 202 response is intentionally non-committal. Its purpose is to allow a server to accept a request for
        if (family <= 3) {
     * the client SHOULD handle the response as it would for a 500 response.
     * A server SHOULD return a response with this status code if a request included a Range request-header field
    /**
     * Turn a status code into a {@link RestStatus}, returning null if we don't know that status.
     */
     */
     * <p>
     * <p>
     * accessed in attempting to fulfill the request.
     * Note: HTTP/1.1 servers are allowed to return responses which are not acceptable according to the accept
     * the server is unable to store the representation needed to successfully complete the request. This condition
        for (RestStatus value : values) {
     * or a multipart/byteranges Content-Type including Content-Range fields for each part. If a Content-Length
     */
     * location, and agent-driven negotiation information (section 12) is being provided so that the user (or user
     * <p>
     */
    NOT_ACCEPTABLE(406),
    MOVED_PERMANENTLY(301),
     * was HEAD, the entity of the response SHOULD contain a short hypertext note with a hyperlink to the new URI(s).
     * representation in the Location field; user agents MAY use the Location field value for automatic redirection.
     * <p>
     * <p>
     * switch protocols to those defined by the response's Upgrade header field immediately after the empty line
     */
     */
     */
    RestStatus(int status) {
     * <li>Date</li>
            }
    }
 * specific language governing permissions and limitations
     */
     * characteristics and location(s) from which the user or user agent can choose the one most appropriate. The
     * instead.
 *
     * The server is currently unable to handle the request due to a temporary overloading or maintenance of the
    HTTP_VERSION_NOT_SUPPORTED(505),
     * </ul>
            // 5xx errors correspond with errors on the systems side
        }
@PublicApi(since = "1.0.0")
     * intended.
     * The response MAY be used in success, partial success and also in failure situations.
     * <p>
     */
     * updated meta information. The response MAY include new or updated meta information in the form of
 */
public enum RestStatus {
     * is expected to be considered permanent. Clients with link editing capabilities SHOULD delete references to
     * The request could not be completed due to a conflict with the current state of the resource. This code is
     * The entity format is specified by the media type given in the Content-Type header field. Depending upon the
     */
     * 429 Too Many Requests (RFC6585)
    BAD_REQUEST(400),
     * The server is refusing to process a request because the request entity is larger than the server is willing
 */
     * field (section 14.27) to make the request conditional.
     * resource be removed. Such an event is common for limited-time, promotional services and for resources belonging
     * (section 14.35), and none of the range-specifier values in this field overlap the current extent of the
     * some other process (perhaps a batch-oriented process that is only run once per day) without requiring that
     * another input action. The response MUST NOT include an entity.
    INTERNAL_SERVER_ERROR(500),
     * <p>
/*
     * The 207 (Multi-Status) status code provides status for multiple independent operations (see Section 13 for
    private int status;
 * license agreements. See the NOTICE file distributed with
     * the message-body.</li>
        }
     */
     * The server is refusing to service the request because the entity of the request is in a format not supported
     * resources as "gone" or to keep the mark for any length of time -- that is left to the discretion of the server
     * information about an individual resource. Each 'response' element MUST have an 'href' element
     * If known, the length of the delay MAY be indicated in a Retry-After header. If no Retry-After is given,
        }
     * is considered to be temporary. If the request that received this status code was the result of a user action,
     * <p>
 * Unless required by applicable law or agreed to in writing,
     */
     * header field is present in the response, its value MUST match the actual number of OCTETs transmitted in
    /**
    REQUEST_TIMEOUT(408),
     * entity (hence a 415(Unsupported Media Type) status code is inappropriate), and the syntax of the request
}
