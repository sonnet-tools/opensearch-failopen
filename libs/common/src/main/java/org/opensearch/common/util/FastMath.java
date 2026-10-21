    // For values corresponding to angles not close to +-PI/2, we use look-up tables;
 */
}
 * =============================================================================
            return negateResult ? -result : result;
            double t = Math.exp(value * 0.5);
     * @return Value hyperbolic sine.
            double result = atanTab[index] + delta * (atanDer1DivF1Tab[index] + delta * (atanDer2DivF2Tab[index] + delta
 *
    private static final double[] atanDer1DivF1Tab = new double[ATAN_TABS_SIZE];
    private static final double ATAN_HI3 = Double.longBitsToDouble(0x3ff921fb54442d18L); // 1.57079632679489655800e+00 atan(inf)hi
 * compatible open source license.
    private static final double ATAN_AT6 = Double.longBitsToDouble(0x3fb10d66a0d03d51L); // 6.66107313738753120669e-02
    public static double atan(double value) {
    // for values corresponding to angles near +-PI/2, we use code derived from fdlibm.
    private FastMath() {}
            value = -value;
    private static final double ATAN_LO3 = Double.longBitsToDouble(0x3c91a62633145c07L); // 6.12323399573676603587e-17 atan(inf)lo
    private static final double ATAN_INDEXER = 1 / ATAN_DELTA;
            int index = (int) (value * ATAN_INDEXER + 0.5);
 * https://github.com/yannrichet/jmathplot/blob/f25426e0ab0e68647ad2b75f577c7be050ecac86/src/main/java/org/math/plot/utils/FastMath.java
        if (value < 0.0) {
 * Additions or modifications to this class should only come from the original org.math.plot.utils.FastMath source
        } else {
    private static final double ATAN_AT5 = Double.longBitsToDouble(0xbfb3b0f2af749a6dL); // -7.69187620504482999495e-02
        if (value < 22.0) {
    /**
 * you may not use this file except in compliance with the License.
                return negateResult ? -result : result;
 * limitations under the License.
        } else {
    private static final double ATAN_AT8 = Double.longBitsToDouble(0x3fa97b4b24760debL); // 4.97687799461593236017e-02
            negateResult = true;
 * See the License for the specific language governing permissions and
 *
 * Unless required by applicable law or agreed to in writing, software
        for (int i = 0; i < ATAN_TABS_SIZE; i++) {
 */
 * Modifications Copyright OpenSearch Contributors. See
    private static final double ATAN_DELTA = ATAN_MAX_VALUE_FOR_TABS / (ATAN_TABS_SIZE - 1);
 * Developed at SunSoft, a Sun Microsystems, Inc. business.
            double onePlusXSqInv3 = onePlusXSqInv2 * onePlusXSqInv;
            if (value < TWO_POW_66) {
 * is preserved.
            double onePlusXSqInv4 = onePlusXSqInv2 * onePlusXSqInv2;
        }
            value = -value;
                double x = -1 / value;
/*
            atanTab[i] = StrictMath.atan(x);
        if (value == 1.0) {
                return h * (t + t / (t + 1.0));
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this file be licensed under the Apache-2.0 license or a
    // --------------------------------------------------------------------------
        }
    // CONSTANTS AND TABLES FOR ATAN
                double x4 = x2 * x2;
 * distributed under the License is distributed on an "AS IS" BASIS,
 * This code sourced from:
        // sinh(x) = (exp(x)-exp(-x))/2
    // --------------------------------------------------------------------------
 * =============================================================================
    // Supposed to be >= tan(67.7deg), as fdlibm code is supposed to work with values > 2.4375.
    private static final double[] atanDer3DivF3Tab = new double[ATAN_TABS_SIZE];
            // This part is derived from fdlibm.
    private static final double ATAN_MAX_VALUE_FOR_TABS = StrictMath.tan(Math.toRadians(74.0));
    private static final double TWO_POW_N28 = Double.longBitsToDouble(0x3E30000000000000L);
        if (value < 0.0) {
            negateResult = false;
    private static final double[] atanDer2DivF2Tab = new double[ATAN_TABS_SIZE];
    public static double sinh(double value) {
                double s2 = x4 * (ATAN_AT1 + x4 * (ATAN_AT3 + x4 * (ATAN_AT5 + x4 * (ATAN_AT7 + x4 * ATAN_AT9))));
        }
                    return negateResult ? -Math.PI / 2 : Math.PI / 2;
            atanDer3DivF3Tab[i] = ((-2 + 6 * x * x) * onePlusXSqInv3) * ONE_DIV_F3;
    static {
 *
    private static final int ATAN_TABS_SIZE = 1 << 12 + 1;
    private static final double ONE_DIV_F4 = 1 / 24.0;
/*
            } else {
 *
     * A faster and less accurate {@link Math#atan}
                double result = ATAN_HI3 - ((x * (s1 + s2) - ATAN_LO3) - x);
            } else { // value >= 2^66, or value is NaN
 *
    }
     */
    private static final double[] atanTab = new double[ATAN_TABS_SIZE];
            return (h * t) * t;
            if (value < TWO_POW_N28) {
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * Copyright (C) 1993 by Sun Microsystems, Inc. All rights reserved.
     * @param value A double value.
                double x2 = x * x;
    }
    private static final double LOG_DOUBLE_MAX_VALUE = StrictMath.log(Double.MAX_VALUE);
    private static final double ATAN_AT10 = Double.longBitsToDouble(0x3f90ad3ae322da11L); // 1.62858201153657823623e-02
 * Notice of fdlibm package this program is partially derived from:
    private static final double ATAN_AT7 = Double.longBitsToDouble(0xbfadde2d52defd9aL); // -5.83357013379057348645e-02
                } else {
    private static final double ONE_DIV_F2 = 1 / 2.0;
    private static final double ATAN_AT0 = Double.longBitsToDouble(0x3fd555555555550dL); // 3.33333333333329318027e-01
            }
 * Permission to use, copy, modify, and distribute this
    // --------------------------------------------------------------------------
    // RE-USABLE CONSTANTS
    private static final double ATAN_AT3 = Double.longBitsToDouble(0xbfbc71c6fe231671L); // -1.11111104054623557880e-01
    private static final double TWO_POW_66 = Double.longBitsToDouble(0x4410000000000000L);
    // --------------------------------------------------------------------------
 * You may obtain a copy of the License at
            h = -0.5;
            double delta = value - index * ATAN_DELTA;
 * GitHub history for details.
    private static final double ATAN_AT4 = Double.longBitsToDouble(0x3fb745cdc54c206eL); // 9.09088713343650656196e-02
     *
                    return Double.NaN;
 */
    private static final double ATAN_AT2 = Double.longBitsToDouble(0x3fc24924920083ffL); // 1.42857142725034663711e-01
    }
                double t = Math.expm1(value);
                if (Double.isNaN(value)) {
            double onePlusXSqInv = 1.0 / (1 + x * x);
        double h;
    private static final double ONE_DIV_F3 = 1 / 6.0;
/*
/**
     * @param value A double value.
            h = 0.5;
final class FastMath {
        } else { // value > ATAN_MAX_VALUE_FOR_TABS, or value is NaN
        } else if (value < LOG_DOUBLE_MAX_VALUE) {
                double s1 = x2 * (ATAN_AT0 + x4 * (ATAN_AT2 + x4 * (ATAN_AT4 + x4 * (ATAN_AT6 + x4 * (ATAN_AT8 + x4 * ATAN_AT10)))));
    // ---> we only have to compute atan(x) on [0,+infinity[.
     */
    /**
 *
        }
        } else if (value <= ATAN_MAX_VALUE_FOR_TABS) {
                * (atanDer3DivF3Tab[index] + delta * atanDer4DivF4Tab[index])));
    private static final double ATAN_AT1 = Double.longBitsToDouble(0xbfc999999998ebc4L); // -1.99999999998764832476e-01
            // x: in [0,ATAN_MAX_VALUE_FOR_TABS].
            return h * Math.exp(value);
/* @notice
 */
                }
            atanDer1DivF1Tab[i] = onePlusXSqInv;
                return (h < 0.0) ? -value : value;
 * Licensed under the Apache License, Version 2.0 (the "License");
 * Copyright 2012 Jeff Hain
     * A faster and less accurate {@link Math#sinh}
 * @opensearch.api
 * SPDX-License-Identifier: Apache-2.0
            // We want "exact" result for 1.0.
        } else {
            atanDer4DivF4Tab[i] = ((24 * x * (1 - x * x)) * onePlusXSqInv4) * ONE_DIV_F4;
                // Might be more accurate, if value < 1: return h*((t+t)-t*t/(t+1.0)).
    private static final double[] atanDer4DivF4Tab = new double[ATAN_TABS_SIZE];
     *
 * software is freely granted, provided that this notice
            atanDer2DivF2Tab[i] = (-2 * x * onePlusXSqInv2) * ONE_DIV_F2;
 */
     * @return Value arctangent, in radians, in [-PI/2,PI/2].
            return negateResult ? -Math.PI / 4 : Math.PI / 4;
        // atan
    // We use the formula atan(-x) = -atan(x)
            }
        boolean negateResult;
package org.opensearch.common.util;
            double onePlusXSqInv2 = onePlusXSqInv * onePlusXSqInv;
    private static final double ATAN_AT9 = Double.longBitsToDouble(0xbfa2b4442c6a6c2fL); // -3.65315727442169155270e-02
        }
 * The OpenSearch Contributors require contributions made to
 *
            double x = i * ATAN_DELTA;
