package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

public class FileChannelExample {

	public static void main(String[] args) throws Exception {

		System.out.println("Program Start");
		System.out.println("Merge all data Input file into output file");
		//Input files
        String[] inputFiles = new String[]{"FileChannelInputFile1.txt","FileChannelInputFile2.txt","FileChannelInputFile3.txt"};
         
        //Files contents will be written in these files
        String outputFile = "FileChannelOutputFile.txt";
        FileOutputStream fos = null;
        WritableByteChannel targetChannel = null;
        
        try {
        //Get channel for output file
        fos = new FileOutputStream(new File(FileChannelExample.class.getResource(outputFile).toURI()));
        targetChannel = fos.getChannel();
         
        for (int i = 0; i < inputFiles.length; i++)
        {
            //Get channel for input files
            FileInputStream fis = new FileInputStream(new File(FileChannelExample.class.getResource(inputFiles[i]).toURI()));
            FileChannel inputChannel = fis.getChannel();
 
            //Transfer data from input channel to output channel
            inputChannel.transferTo(0, inputChannel.size(), targetChannel);
            
            //close the input channel
            inputChannel.close();
            fis.close();
        }
        } catch(Exception e) {
        	e.printStackTrace();
        }
        
      //finally close the target channel
        if(targetChannel!=null) {
        	targetChannel.close();	
        }
        if(fos!=null) {
        	fos.close();	
        }
        System.out.println("Program End");
	}
}
