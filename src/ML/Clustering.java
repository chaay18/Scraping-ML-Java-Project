package ML;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.EM;
import weka.core.Instances;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class Clustering {
    public static void main(String args[]) throws Exception{

        //load data
        Instances data = new Instances(new BufferedReader(new FileReader("data/emploiFinal4.arff")));

        // new instance of clusterer
        EM model = new EM();
        // build the clusterer
        model.buildClusterer(data);
        System.out.println(model);

        double logLikelihood = ClusterEvaluation.crossValidateModel(model, data, 10, new Random(1));
        System.out.println(logLikelihood);
    }
}
