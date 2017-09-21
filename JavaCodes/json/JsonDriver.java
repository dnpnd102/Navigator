package json;

import org.apache.hadoop.io.* ;
import org.apache.hadoop.mapreduce.* ;
import org.apache.hadoop.mapreduce.lib.input.*;
import org.apache.hadoop.mapreduce.lib.output.*;
import org.apache.hadoop.fs.* ;

public class JsonDriver {

	public static void main(String[] args) throws Exception
	{

		Job job = new Job() ;
		job.setJarByClass(JsonDriver.class) ;
		job.setMapperClass(JsonMapper.class);
		job.setReducerClass(JsonReducer.class) ;
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(Text.class) ;
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		
		job.waitForCompletion(true) ;
	 
	}
	
}