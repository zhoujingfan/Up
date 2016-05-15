package com.up.auth.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;
import com.opensymphony.xwork2.ActionSupport;
import com.up.auth.service.IUserService;

public class AvatarAction extends ActionSupport {
	
	public static final String storageConnectionString =
	        "DefaultEndpointsProtocol=http;"
	        + "AccountName=whatsup;"
	        + "AccountKey=peVXdurvLZYy8uiRaQnZZwfQpFQhQ9EwnKKkkIS8rklnc+fZqOsrG7ngV5fWB586p0Rf9zdC1HHsOkOX97q4Ww==;"+
	        "EndpointSuffix=core.chinacloudapi.cn";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	private String destUri;
	
	@Autowired
	public IUserService userService;

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

	public String getDestUri() {
		return destUri;
	}

	public void setDestUri(String destUri) {
		this.destUri = destUri;
	}

	@Override
	public String execute() throws Exception {
		//if(myFile==null)return INPUT;
		try {
            CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
            CloudBlobClient serviceClient = account.createCloudBlobClient();

            // Container name must be lower case.
            CloudBlobContainer container = serviceClient.getContainerReference("avatar");
            container.createIfNotExists();

            // Upload an image file.
            CloudBlockBlob blob = container.getBlockBlobReference(String.valueOf(myFileContentType.hashCode())+".jpg");
            blob.upload(new FileInputStream(myFile), myFile.length());
            destUri=blob.getUri().toString();
        }
        catch (FileNotFoundException fileNotFoundException) {
            addFieldError("myFile","File not exist!");
            return INPUT;
        }
        catch (StorageException storageException) {
            addFieldError("myFile","Storage Exception!");
            return INPUT;
        }
        catch (Exception e) {
            addFieldError("myFile",e.getMessage());
            return INPUT;
        }
		destUri="http://p2.ifengimg.com/a/2016_20/7ca1fa9d8508112_size833_w1024_h645.jpg";
		return SUCCESS;
	}

	@Override
	public void validate() {
		if(myFile==null)addFieldError("myFile","File is null!");
	}
}
