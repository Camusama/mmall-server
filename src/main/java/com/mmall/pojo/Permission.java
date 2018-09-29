package com.mmall.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class Permission implements Serializable {

	 /// <summary>
    /// Ȩ�޴���
    /// </summary>
	@JsonProperty("Code")
    public String code ;

    /// <summary>
    /// Ȩ������
    /// </summary>
	@JsonProperty("Name")
    public String name ;

    /// <summary>
    /// Ȩ������
    /// </summary>
	@JsonProperty("Type")
    public int type ;

    /// <summary>
    /// ����Ȩ�޴���
    /// </summary>
	@JsonProperty("ParentCode")
    public String parentCode ;

    /// <summary>
    /// ģ��/ҳ�������url
    /// </summary>
	@JsonProperty("Url")
    public String url ;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
    public Permission() {
        
    }
    
    public Permission(String code, String name, int type) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.url = "";
        this.parentCode = "";
    }

//	public String getCode() {
//		return code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getParentCode() {
//		return parentCode;
//	}
//
//	public void setParentCode(String parentCode) {
//		this.parentCode = parentCode;
//	}
//
//	public String getUrl() {
//		return url;
//	}
//
//	public void setUrl(String url) {
//		this.url = url;
//	}

}
