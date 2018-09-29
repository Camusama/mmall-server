package com.mmall.pojo;

public enum PermissionType {
            /// <summary>
			/// ģ�飨�˵���Ȩ��
			/// </summary>
			Module("1"),
			/// <summary>
			/// ҳ��Ȩ��
			/// </summary>
			Page("2"),
			/// <summary>
			/// ��������ť��Ȩ��
			/// </summary>
			Operation("3");
    private final String value;
	private PermissionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
