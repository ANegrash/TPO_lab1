package tests;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import work.Sec;

class SecTests {
    double error = 0.1;

    public double getTrueValue(double value) {
        double result = 1 / Math.cos(Math.toRadians(value));
        return result > 10000 ? Double.POSITIVE_INFINITY : result < -10000 ? Double.NEGATIVE_INFINITY : result;
    }

    @ParameterizedTest
    @ValueSource(ints = {-22, -88, -383})
    public void negativeIntCheck(int value) {
        Assertions.assertEquals(getTrueValue(value), Sec.sec(value), error);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2.2, -10.7})
    public void negativeDoubleCheck(double value) {
        Assertions.assertEquals(getTrueValue(value), Sec.sec(value), error);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.01, -0.1})
    public void negativeZeroCloseCheck(double value) {
        Assertions.assertEquals(getTrueValue(value), Sec.sec(value), error);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.01, 0.1})
    public void positiveZeroCloseCheck(double value) {
        Assertions.assertEquals(getTrueValue(value), Sec.sec(value), error);
    }

    @ParameterizedTest
    @ValueSource(doubles = {2.2, 10.7})
    public void positiveDoubleCheck(double value) {
        Assertions.assertEquals(getTrueValue(value), Sec.sec(value), error);
    }

    @ParameterizedTest
    @ValueSource(ints = {33, 77, 369})
    public void positiveIntCheck(int value) {
        Assertions.assertEquals(getTrueValue(value), Sec.sec(value), error);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 60, 90, 120, 180, 240, 270, 300, 360})
    public void beautifulValuesCheck(int value) {
        Assertions.assertEquals(getTrueValue(value), Sec.sec(value), error);
    }
}
