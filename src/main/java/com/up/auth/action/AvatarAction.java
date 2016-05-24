package com.up.auth.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.microsoft.azure.storage.*;
import com.microsoft.azure.storage.blob.*;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;
import com.up.auth.service.IUserService;

public class AvatarAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	IUserService userService;
	public static final String storageConnectionString = "DefaultEndpointsProtocol=http;" + "AccountName=whatsup;"
			+ "AccountKey=peVXdurvLZYy8uiRaQnZZwfQpFQhQ9EwnKKkkIS8rklnc+fZqOsrG7ngV5fWB586p0Rf9zdC1HHsOkOX97q4Ww==;"
			+ "EndpointSuffix=core.chinacloudapi.cn";
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	private String destUri;

	@Override
	public String execute() throws Exception {
		try {
			CloudStorageAccount account = CloudStorageAccount.parse(storageConnectionString);
			CloudBlobClient serviceClient = account.createCloudBlobClient();

			// Container name must be lower case.
			CloudBlobContainer container = serviceClient.getContainerReference("avatar");

			// Upload an image file.
			CloudBlockBlob blob = container.getBlockBlobReference(upload.getName());
			blob.upload(new FileInputStream(upload), upload.length());
			setDestUri(blob.getUri().toString());
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username;
			if (principal instanceof UserDetails) {
				username = ((UserDetails) principal).getUsername();
			} else {
				username = principal.toString();
			}
			userService.setAvatar(username, destUri);
		} catch (FileNotFoundException fileNotFoundException) {
			addFieldError("upload", "File not exist!");
			return INPUT;
		} catch (StorageException storageException) {
			addFieldError("upload", "Storage Exception!");
			return INPUT;
		} catch (Exception e) {
			addFieldError("upload", "error:" + e.getMessage());
			return INPUT;
		}
		return SUCCESS;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getDestUri() {
		return destUri;
	}

	public void setDestUri(String destUri) {
		this.destUri = destUri;
	}

	@Override
	public void validate() {
		if (upload == null)
			addFieldError("upload", "error in validate");
		super.validate();
	}

	@Override
	public String input() throws Exception {
		return SUCCESS;
	}
}
