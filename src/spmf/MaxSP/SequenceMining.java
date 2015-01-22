/**
 *@Copyright:Copyright (c) 2008 - 2015 *
 */
package spmf.MaxSP;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import ca.pfv.spmf.algorithms.sequentialpatterns.BIDE_and_prefixspan.AlgoMaxSP;
import ca.pfv.spmf.input.sequence_database_list_integers.SequenceDatabase;
import ca.pfv.spmf.test.MainTestMaxSP_saveToFile;

/**
 *@Title:SPMF_MaxSP
 *@Description:最大序列模式挖掘
 *@Author:XBW
 *@Date:2015年1月22日
 */
public class SequenceMining {

	public static String inputpath="D:\\MachineLearning\\MLworkspace\\input.txt";
	public static String outputpath="D:\\MachineLearning\\MLworkspace\\MaxSP\\output.txt";

	public static void main(String [] arg) throws IOException{    
		// Load a sequence database
		SequenceDatabase sequenceDatabase = new SequenceDatabase(); 
		sequenceDatabase.loadFile(inputpath);
//		sequenceDatabase.print();
		
		int minsup = 2; // we use a minsup of 2 sequences (50 % of the database size)
		
		AlgoMaxSP algo  = new AlgoMaxSP();  //
		
		// execute the algorithm
		algo.runAlgorithm(sequenceDatabase,outputpath, minsup);    
		algo.printStatistics(sequenceDatabase.size());
	}
	
	public static String fileToPath(String filename) throws UnsupportedEncodingException{
		URL url = MainTestMaxSP_saveToFile.class.getResource(filename);
		 return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
	}
	
}
