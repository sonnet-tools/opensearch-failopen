            IllegalArgumentException.class,  
            IllegalArgumentException.class,  
        IllegalArgumentException e = expectThrows(  
    public void testDateStringRejectedAsTime() {
 *
        );
            () -> DatetimeLiteralValidator.validate("09:07:42", DatetimeLiteralValidator.Kind.DATE)  
    }
    public void testInvalidTimeRejectedWithTimeHint() {
        IllegalArgumentException e = expectThrows(
            () -> DatetimeLiteralValidator.validate("09:07:42", DatetimeLiteralValidator.Kind.TIMESTAMP)
        );  
/*  
    }
    public void testTimestampAcceptsSpaceSeparator() {  
}
 */  
        );
 * SPDX-License-Identifier: Apache-2.0
        IllegalArgumentException e = expectThrows(
    }
        );
        IllegalArgumentException e = expectThrows(
    }
            () -> DatetimeLiteralValidator.validate("16:00:61", DatetimeLiteralValidator.Kind.TIME)
    }
public class DatetimeLiteralValidatorTests extends OpenSearchTestCase {  
        );
 * The OpenSearch Contributors require contributions made to  
    }  
    public void testValidTimesAccepted() {
 * this file be licensed under the Apache-2.0 license or a
    }  
        IllegalArgumentException e = expectThrows(
        DatetimeLiteralValidator.validate("23:59:59", DatetimeLiteralValidator.Kind.TIME);
            IllegalArgumentException.class,  
import org.opensearch.test.OpenSearchTestCase;
    }
        assertEquals("timestamp:09:07:42 in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e.getMessage());  
 * compatible open source license.
        assertEquals("date:09:07:42 in unsupported format, please use 'yyyy-MM-dd'", e.getMessage());
            () -> DatetimeLiteralValidator.validate("1984-04-12", DatetimeLiteralValidator.Kind.TIME)
        DatetimeLiteralValidator.validate("09:07:42.12345", DatetimeLiteralValidator.Kind.TIME);
            () -> DatetimeLiteralValidator.validate("2025-13-02", DatetimeLiteralValidator.Kind.DATE)
    }
    public void testTimestampRejectsBareTime() {
            IllegalArgumentException.class,
    public void testTimeStringRejectedAsDate() {  
            IllegalArgumentException.class,
        IllegalArgumentException e = expectThrows(
    }
            () -> DatetimeLiteralValidator.validate("2025-13-02 garbage", DatetimeLiteralValidator.Kind.TIMESTAMP)
        DatetimeLiteralValidator.validate("2024-01-15", DatetimeLiteralValidator.Kind.TIMESTAMP);
        );
        DatetimeLiteralValidator.validate("2024-01-15 09:07:42", DatetimeLiteralValidator.Kind.TIMESTAMP);
    public void testInvalidTimestampRejectedWithTimestampHint() {
    public void testInvalidDateRejectedWithDateHint() {
package org.opensearch.be.datafusion;
    public void testTimestampAcceptsBareDate() {  
            IllegalArgumentException.class,  
    public void testValidDatesAccepted() {
        DatetimeLiteralValidator.validate("09:07:42", DatetimeLiteralValidator.Kind.TIME);  
        DatetimeLiteralValidator.validate("2024-01-15", DatetimeLiteralValidator.Kind.DATE);  
        DatetimeLiteralValidator.validate("1984-04-12", DatetimeLiteralValidator.Kind.DATE);
        assertEquals("time:16:00:61 in unsupported format, please use 'HH:mm:ss[.SSSSSSSSS]'", e.getMessage());
        assertEquals("time:1984-04-12 in unsupported format, please use 'HH:mm:ss[.SSSSSSSSS]'", e.getMessage());  
        assertEquals("date:2025-13-02 in unsupported format, please use 'yyyy-MM-dd'", e.getMessage());  
        assertEquals("timestamp:2025-13-02 garbage in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e.getMessage());  
