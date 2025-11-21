import java.util.*;
class myRandom{
    Random random = new Random();
    public int nextInteger(int lower, int upper){
        return random.nextInt(upper - lower) + lower;
    }

    public double nextDecimal(double lower, double upper){
        return random.nextDouble() * (upper - lower) + lower;
    }
}