package random;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class RandomAlg {

    long a, c, m;

    private AtomicLong x;

    public RandomAlg() {
        this.a = 72653623476l;
        this.m = 2 ^ 47;
    }

    public RandomAlg withSeed(int c) {
        this.c = c;
        x = new AtomicLong(c);
        return this;
    }

    public int next() {
        return (int) ((a*x.getAndIncrement()+c) % m);
    }
}
