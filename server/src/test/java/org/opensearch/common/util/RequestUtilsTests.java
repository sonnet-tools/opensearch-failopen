 * SPDX-License-Identifier: Apache-2.0
        assertEquals("X-Request-Id should not be null or empty", exception.getMessage());  
    public void testValidateRequestIdBlank() {
    }
 * this file be licensed under the Apache-2.0 license or a
        IllegalArgumentException exception = expectThrows(  
public class RequestUtilsTests extends OpenSearchTestCase {  
            "X-Request-Id length [" + (DEFAULT_MAX_LENGTH + 1) + "] exceeds maximum allowed length [" + DEFAULT_MAX_LENGTH + "]",
        IllegalArgumentException exception = expectThrows(  
        RequestUtils.validateRequestId("a1b2c3d4e5f67890abcdef1234567890", DEFAULT_MAX_LENGTH);  
import org.opensearch.common.settings.Settings;
    public void testValidateRequestIdExactlyAtMaxLength() {
            IllegalArgumentException.class,
    public void testValidateRequestIdTooLong() {
package org.opensearch.common.util;
    private static final int DEFAULT_MAX_LENGTH = HttpTransportSettings.SETTING_HTTP_REQUEST_ID_MAX_LENGTH.getDefault(Settings.EMPTY);
        IllegalArgumentException exception = expectThrows(
            IllegalArgumentException.class,
        RequestUtils.validateRequestId("a".repeat(256), 256);
        String tooLong = "a".repeat(DEFAULT_MAX_LENGTH + 1);
    }
    }
        RequestUtils.validateRequestId("a1b2c3d4-e5f6-7890-abcd-ef1234567890", DEFAULT_MAX_LENGTH);
        );
        RequestUtils.validateRequestId("a".repeat(DEFAULT_MAX_LENGTH), DEFAULT_MAX_LENGTH);  
    public void testValidateRequestIdCustomMaxLength() {  
        assertEquals("X-Request-Id should not be null or empty", exception.getMessage());
        );
            () -> RequestUtils.validateRequestId("   ", DEFAULT_MAX_LENGTH)
            exception.getMessage()  
    }
            () -> RequestUtils.validateRequestId(tooLong, DEFAULT_MAX_LENGTH)
    }  
        RequestUtils.validateRequestId("ABCDEF1234567890abcdef1234567890", DEFAULT_MAX_LENGTH);
        // UUID with dashes - previously rejected, now allowed
 *
    }
        // Previously rejected, now allowed
    public void testValidateRequestIdValid() {
        );  
    public void testValidateRequestIdNull() {
    }
import org.opensearch.core.common.Strings;
        assertTrue(Strings.hasText(RequestUtils.generateID()));
import org.opensearch.test.OpenSearchTestCase;
            IllegalArgumentException.class,
        IllegalArgumentException exception = expectThrows(
            () -> RequestUtils.validateRequestId("a".repeat(33), 32)
    public void testValidateRequestIdEmpty() {  
    }
 * The OpenSearch Contributors require contributions made to  
/*  
}  
            IllegalArgumentException.class,  
        );  
        RequestUtils.validateRequestId("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF", DEFAULT_MAX_LENGTH);
    public void testValidateRequestIdNonHexCharactersAllowed() {
        RequestUtils.validateRequestId("ffffffffffffffffffffffffffffffff", DEFAULT_MAX_LENGTH);  
        );
        RequestUtils.validateRequestId("g1b2c3d4e5f67890abcdef1234567890", DEFAULT_MAX_LENGTH);  
            () -> RequestUtils.validateRequestId(null, DEFAULT_MAX_LENGTH)
        assertEquals("X-Request-Id should not be null or empty", exception.getMessage());
    }  
        RequestUtils.validateRequestId("00000000000000000000000000000000", DEFAULT_MAX_LENGTH);
 */  
 * compatible open source license.
    }  
            () -> RequestUtils.validateRequestId("", DEFAULT_MAX_LENGTH)  
        IllegalArgumentException exception = expectThrows(  
        assertEquals("X-Request-Id length [33] exceeds maximum allowed length [32]", exception.getMessage());
        );  
    public void testGenerateID() {
        assertEquals(
            IllegalArgumentException.class,
    public void testValidateRequestIdWithSpecialCharactersAllowed() {  
import org.opensearch.http.HttpTransportSettings;  
