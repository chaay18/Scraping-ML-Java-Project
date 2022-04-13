package ML;


import java.util.Random;

import javax.swing.JFrame;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.evaluation.ThresholdCurve;
import weka.classifiers.rules.ZeroR;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.classifiers.trees.RandomTree;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Utils;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;
import weka.gui.visualize.PlotData2D;
import weka.gui.visualize.ThresholdVisualizePanel;
import weka.attributeSelection.AttributeSelection;
import weka.attributeSelection.InfoGainAttributeEval;
import weka.attributeSelection.Ranker;

public class Classification {

    public static void main(String[] args) throws Exception {

        /*
         * Load the data
         */
        DataSource source = new DataSource("data/emploiFinal4.arff");
        Instances data = source.getDataSet();
        //data.setClassIndex(2);
        data.setClassIndex(data.attribute("secteur_act").index());  //class label here is secteur_activité
        System.out.println(data.numInstances() + " instances loaded.");
        //System.out.println(data.toString());

        //remove titre attribute
        String[] opts = new String[] { "-R", "8" };
        Remove remove = new Remove();
        remove.setOptions(opts);
        remove.setInputFormat(data);
        data = Filter.useFilter(data, remove);

        //feature selection
        InfoGainAttributeEval eval = new InfoGainAttributeEval();
        Ranker search = new Ranker();
        AttributeSelection attSelect = new AttributeSelection();
        attSelect.setEvaluator(eval);
        attSelect.setSearch(search);
        attSelect.SelectAttributes(data);
        int[] indices = attSelect.selectedAttributes();
        System.out.println("Selected attributes: "+Utils.arrayToString(indices));


        //decision tree
        J48 tree = new J48();
        String[] options = new String[1];
        options[0] = "-U";
        tree.setOptions(options);
        tree.buildClassifier(data);
        //System.out.println(tree);
        //evaluation
        Classifier cl = new J48();
        Evaluation eval_roc = new Evaluation(data);
        eval_roc.crossValidateModel(cl, data, 10, new Random(1), new Object[] {});
        System.out.println("********evaluation du j48 tree classifier*******");
        System.out.println(eval_roc.toSummaryString());
        System.out.println("-----confusion matrix for j48-----");
        double[][] confusionMatrix = eval_roc.confusionMatrix();
        System.out.println(eval_roc.toMatrixString());



        //naive bayes
        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(data);
        //System.out.println(data);
        //evaluation
        Classifier cl1 = new NaiveBayes();
        Evaluation eval_roc1 = new Evaluation(data);
        eval_roc1.crossValidateModel(cl1, data, 10, new Random(1), new Object[] {});
        System.out.println("*********evaluation du naive bayes classifier**********");
        System.out.println(eval_roc1.toSummaryString());
        System.out.println("-----confusion matrix for NaiveBayes-----");
        double[][] confusionMatrix1 = eval_roc1.confusionMatrix();
        System.out.println(eval_roc1.toMatrixString());



        //random forest
        RandomForest rf = new RandomForest();
        rf.buildClassifier(data);
        //evaluation
        Classifier cl2 = new RandomForest();
        Evaluation eval_roc2 = new Evaluation(data);
        eval_roc2.crossValidateModel(cl2, data, 10, new Random(1), new Object[] {});
        System.out.println("***********evaluation du random forest classifier**********");
        System.out.println(eval_roc2.toSummaryString());
        System.out.println("-----confusion matrix for RandomForest-----");
        double[][] confusionMatrix2 = eval_roc2.confusionMatrix();
        System.out.println(eval_roc2.toMatrixString());


        //random tree
        RandomTree rt = new RandomTree();
        rt.buildClassifier(data);
        //evaluation
        Classifier cl3 = new RandomForest();
        Evaluation eval_roc3 = new Evaluation(data);
        eval_roc3.crossValidateModel(cl3, data, 10, new Random(1), new Object[] {});
        System.out.println("***********evaluation du random tree classifier**********");
        System.out.println(eval_roc3.toSummaryString());
        System.out.println("-----confusion matrix for RandomTree-----");
        double[][] confusionMatrix3 = eval_roc3.confusionMatrix();
        System.out.println(eval_roc3.toMatrixString());



        TreeVisualizer tv = new TreeVisualizer(null, tree.graph(),
                new PlaceNode2());
        JFrame frame = new javax.swing.JFrame("Tree Visualizer");
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(tv);
        frame.setVisible(true);
        tv.fitToScreen();
        
    }
}

     /*String[] vals = new String[data.numAttributes()];
        vals[0] = "Casablanca";  //ville
        vals[1] = "Leyton";  //entreprise
        vals[2] = "Gestion projet / Etudes / R&D";  //fct
        vals[3] = "De 1 à 3 ans";  //exp
        vals[4] = "Bac +5 et plus";  //niv
        vals[5] = "CDI";  //contrat

         */