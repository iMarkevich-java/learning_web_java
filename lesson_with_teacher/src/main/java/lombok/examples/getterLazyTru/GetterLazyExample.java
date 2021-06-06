package lombok.examples.getterLazyTru;


import lombok.Getter;

public class GetterLazyExample {
    @Getter(lazy = true)
    private final double[] cached = expensive();

    public double[] expensive() {
        double[] result = new double[1_000_000];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }
}
/*

import java.util.concurrent.atomic.AtomicReference;

public class GetterLazyExample {
    private final AtomicReference<Object> cached = new AtomicReference();

    public GetterLazyExample() {
    }

    public double[] expensive() {
        double[] result = new double[1000000];

        for(int i = 0; i < result.length; ++i) {
            result[i] = (double)i;
        }

        return result;
    }

    public double[] getCached() {
        Object value = this.cached.get();
        if (value == null) {
            synchronized(this.cached) {
                value = this.cached.get();
                if (value == null) {
                    double[] actualValue = this.expensive();
                    value = actualValue == null ? this.cached : actualValue;
                    this.cached.set(value);
                }
            }
        }

        return (double[])((double[])(value == this.cached ? null : value));
    }
}

 */
