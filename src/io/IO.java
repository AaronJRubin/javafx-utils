package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class IO {

	private IO() {
	}
	
	public static String stringFromStream(InputStream stream, int numCharacters) {
		InputStreamReader r = new InputStreamReader(stream);
		char[] buffer = new char[numCharacters];
		try {
			r.read(buffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		return new String(buffer);
	}
	/*
	static String readFile(String path, Charset encoding) 
			throws IOException 
	{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return encoding.decode(ByteBuffer.wrap(encoded)).toString();
	} */
	
	public static String readFile(File f, Charset encoding) 
			throws IOException 
	{
		byte[] encoded = Files.readAllBytes(f.toPath());
		return encoding.decode(ByteBuffer.wrap(encoded)).toString();
	}
	
	public static String readFile(File f) throws IOException {
		return readFile(f, Charset.forName("UTF-8"));
	}
	
	 public static File copyResourceToTemp(String extension, InputStream stream) throws IOException {
	        OutputStream resStreamOut;
	        File toReturn = File.createTempFile("temp", extension);
	        int readBytes;
	        byte[] buffer = new byte[4096];
	        try {
	            resStreamOut = new FileOutputStream(toReturn);
	            while ((readBytes = stream.read(buffer)) > 0) {
	                resStreamOut.write(buffer, 0, readBytes);
	            }
	            resStreamOut.close();
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        } finally {
	            stream.close(); 
	        }
	        return toReturn;
	    }
	
}
