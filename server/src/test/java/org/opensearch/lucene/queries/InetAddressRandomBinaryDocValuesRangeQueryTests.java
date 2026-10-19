 * Licensed to Elasticsearch under one or more contributor  
        }
        @Override  
import java.util.Arrays;
    }
                && Arrays.compareUnsigned(max, 0, max.length, other.max, 0, max.length) <= 0;
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
            }  
    private InetAddress nextInetaddress() throws UnknownHostException {
                Arrays.fill(b, (byte) 42);
 * not use this file except in compliance with the License.
                max = e;  
            this.maxAddress = max;
 * this file be licensed under the Apache-2.0 license or a
                Arrays.fill(b, (byte) 0xff);
            IpRange other = (IpRange) o;
        protected boolean isDisjoint(Range o) {  
 * The OpenSearch Contributors require contributions made to  
            byte[] e = InetAddressPoint.encode(v);
                maxAddress = v;
            byte[] e = InetAddressPoint.encode(v);  
        byte[] bMax = InetAddressPoint.encode(max);  
 * license agreements. See the NOTICE file distributed with
            } else {
package org.opensearch.lucene.queries;
 * SPDX-License-Identifier: Apache-2.0
    }
        IpRange(InetAddress min, InetAddress max) {  
            InetAddress v = (InetAddress) val;  
            case 1:  
    private static class IpRange extends AbstractRange<InetAddress> {  
import org.apache.lucene.document.InetAddressPoint;  
        protected void setMax(int dim, Object val) {  
 *
        }
        public InetAddress getMax() {
 * the Apache License, Version 2.0 (the "License"); you may
            if (Arrays.compareUnsigned(min, 0, e.length, e, 0, e.length) < 0) {  
            return Arrays.compareUnsigned(min, 0, min.length, other.min, 0, min.length) >= 0  
        public InetAddress getMin() {
        byte[] b = random().nextBoolean() ? new byte[4] : new byte[16];
    }
        }  
        InetAddress maxAddress;
                minAddress = v;
    @Override
 *
import java.net.InetAddress;  
                random().nextBytes(b);
}
 * compatible open source license.
                || Arrays.compareUnsigned(max, 0, max.length, other.min, 0, max.length) < 0;  
    @Override  
            default:  
import org.opensearch.index.mapper.RangeType;
 *  
 */
/*  
        @Override
        byte[] min;  
        return new IpRange(min, max);
        }
            InetAddress v = (InetAddress) val;
            return Arrays.compareUnsigned(min, 0, min.length, other.min, 0, min.length) <= 0
        protected void setMin(int dim, Object val) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
            return Arrays.compareUnsigned(min, 0, min.length, other.max, 0, min.length) > 0
        protected boolean isWithin(Range o) {
                maxAddress = v;
            if (Arrays.compareUnsigned(max, 0, e.length, e, 0, e.length) > 0) {
            this.minAddress = min;
 * this work for additional information regarding copyright
    protected String fieldName() {
            return new IpRange(max, min);
                && Arrays.compareUnsigned(max, 0, max.length, other.max, 0, max.length) >= 0;
        @Override
        return RangeType.IP;
        }  
    }  
        @Override
/*
        @Override
        byte[] bMin = InetAddressPoint.encode(min);
                return InetAddress.getByAddress(b);
                max = e;
            case 0:
 * under the License.  
        }  
/*
            assert dim == 0;
        @Override  
                min = e;  
                minAddress = v;
        return "ip_range_dv_field";
                return InetAddress.getByAddress(b);
public class InetAddressRandomBinaryDocValuesRangeQueryTests extends BaseRandomBinaryDocValuesRangeQueryTestCase {
        switch (random().nextInt(5)) {  
        }  
    protected Range nextRange(int dimensions) throws Exception {
        @Override  
import java.net.UnknownHostException;
        byte[] max;
    }
            IpRange other = (IpRange) o;
    @Override
            return minAddress;  
 * You may obtain a copy of the License at  
        InetAddress max = nextInetaddress();
            case 2:  
                min = e;
            this.max = InetAddressPoint.encode(max);
    protected RangeType rangeType() {  
            this.min = InetAddressPoint.encode(min);  
 */  
                return InetAddress.getByAddress(b);
            return maxAddress;
            } else {  
        protected boolean contains(Range o) {
        }
 * specific language governing permissions and limitations
            IpRange other = (IpRange) o;  
        InetAddress min = nextInetaddress();  
        }
        InetAddress minAddress;
        if (Arrays.compareUnsigned(bMin, 0, bMin.length, bMax, 0, bMin.length) > 0) {
 */
            assert dim == 0;
            }
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See  
        }  
                return InetAddress.getByAddress(b);
