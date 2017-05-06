package org.eop.amab;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.eop.amab.split.exception.SourceException;

/**
 * @author lixinjie
 * @since 2017-05-05
 */
public class SourceCode {

	private String source;
	
	public SourceCode(String source) {
		this.source = source;
	}
	
	public SourceCode(File file) {
		this.source = getFileContent(file);
	}
	
	public String getSource() {
		return source;
	}
	
	protected static String getFileContent(File file) {
		FileInputStream fis = null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream((int)file.length());
			fis = new FileInputStream(file);
			byte[] buff = new byte[512];
			int len;
			while ((len = fis.read(buff)) > -1) {
				bos.write(buff, 0, len);
			}
			String content = bos.toString();
			bos.close();
			return content;
		} catch (FileNotFoundException e) {
			throw new SourceException(e.getMessage(), new Location());
		} catch (IOException e) {
			throw new SourceException(e.getMessage(), new Location());
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					throw new SourceException(e.getMessage(), new Location());
				}
			}
		}
	}
}
