package Services;

import java.util.Random;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import Entities.Entrepreneur;
import interfaces.IDiagnostic;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.SparseInstance;
import weka.core.converters.ConverterUtils.DataSource;

@Stateless
@Remote
@LocalBean
public class DiagnosticService implements IDiagnostic {

	@Override
	public String diagnostic(Entrepreneur instt) {
		try {
			System.out.println(System.getProperty("user.dir"));
			DataSource source = new DataSource("bank.arff");
			Instances data = source.getDataSet();
			Instances structure = source.getStructure();
			data.setClassIndex(structure.numAttributes() - 1);
			J48 tree = new J48();
			tree.buildClassifier(data);
			System.out.println(tree);
			System.err.println(instt.toString());
			Classifier cl = new J48();
			Evaluation eval_roc = new Evaluation(data);
			eval_roc.crossValidateModel(cl, data, 10, new Random(1), new Object[] {});
			Instance inst = new SparseInstance(data.numAttributes());
			inst.setDataset(data);
			System.out.println("1 ");
			
			inst.setValue(data.attribute("age"), instt.getAge());
			inst.setValue(data.attribute("sex"), instt.getSex());
			inst.setValue(data.attribute("region"),"INNER_CITY");
			inst.setValue(data.attribute("income"), (double)instt.getIncome());
			if (instt.isMarried())
			{
				inst.setValue(data.attribute("married"), "YES");
			}
			else
			{
				inst.setValue(data.attribute("married"), "NO");
			}
                        if (instt.isChildreen())
			{
				inst.setValue(data.attribute("children"), "YES");
			}
			else
			{
				inst.setValue(data.attribute("children"), "NO");
			}
                        if (instt.isCar())
			{
				inst.setValue(data.attribute("car"), "YES");
			}
			else
			{
				inst.setValue(data.attribute("car"), "NO");
			}
                        if (instt.isMortgage())
			{
				inst.setValue(data.attribute("mortgage"), "YES");
			}
			else
			{
				inst.setValue(data.attribute("mortgage"), "NO");
			}
			System.err.println("2:");
			data.add(inst);
			inst.setDataset(data);
			data.setClassIndex(data.numAttributes() - 1);
			System.err.println("3:");
			double result = tree.classifyInstance(inst);
			System.out.println(
					"===============================================================================================================");
			System.out.println("Result : ");
			System.err.println(data.classAttribute().value((int) result));
			return (data.classAttribute().value((int) result));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
