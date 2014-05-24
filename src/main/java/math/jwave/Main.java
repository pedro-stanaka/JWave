package math.jwave;

import math.jwave.exceptions.JWaveFailure;
import math.jwave.transforms.BasicTransform;
import math.jwave.transforms.FastWaveletTransform;
import math.jwave.transforms.wavelets.Wavelet;
import math.jwave.transforms.wavelets.daubechies.Daubechies20;

import java.util.Arrays;

/**
 * @author ${user}
 * @TODO Auto-generated comment
 * <p/>
 * Created by pedro on 24/05/14.
 */
public class Main {
    public static void main(String args[]){

        Wavelet filter = new Daubechies20();
        try {
            double[] arrTime = new double[]{12, 55, 15, 66, 77, 11, 12, 90, 12, 55, 15, 66, 77, 11, 12, 90};
            System.out.println(calcE(arrTime));
            BasicTransform wavelet = new FastWaveletTransform(filter);
            Transform waveletTransform = new Transform(wavelet, 2);
//            Transform waveletTransform = new Transform(wavelet);
            double[] forward = waveletTransform.forward(arrTime);
            double[] reverse = waveletTransform.reverse(forward);
            System.out.println(calcE(reverse));
            System.out.println(Arrays.toString(reverse));
        } catch (JWaveFailure jWaveFailure) {
            jWaveFailure.printStackTrace();
        }
    }

    public static double calcE(double[] values){
        double energy=0;
        for (double value : values) {
            energy += Math.pow(value, 2);
        }
        return energy;
    }
}
