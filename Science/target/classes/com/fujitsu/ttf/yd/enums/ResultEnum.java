package com.fujitsu.ttf.yd.enums;

/**
 * @Author: 王冠
 * @Description: 返回状态码
 * @Modified By:
 */
public enum ResultEnum {
    UN_KNOW_ERROR(-1, "未知错误"),
    //系统错误
    TOKEN_IS_ILLEGAL(001, "token校验失败"),
    TOKEN_CREATE_FAIL(002, "token创建失败"),
    INSERT_ERROR(003, "插入失败"),
    DELETE_ERROR(004, "删除失败"),
    UPDATE_ERROR(005,"更新失败"),
    //业务错误
    STAFF_NUMBER_NOT_EXIST(200, "员工工号不存在"),
    STAFF_NUMBER_NOT_LEGAL(201,"员工工号格式不合法"),
    STAFF_NAME_NOT_LEGAL(202,"员工姓名格式不合法"),
    STAFF_NUMBER_HAS_BEEN_EXIST(203,"员工工号已经存在"),
    PASSWORD_NOT_CORRECT(205,"密码不正确"),
    NUMBER_OR_PASSWORD_NOT_CORRECT(206,"工号或者密码不正确"),
    UPDATE_CONTENT_NOT_EXIST(207,"更新的内容不存在"),
    STAFF_IS_LOCKED(208,"员工账号被锁定"),
    STAFF_NUMBER_IS_NULL(209,"员工工号为空"),
    STAFF_NAME_IS_NULL(210,"员工姓名为空"),
    STAFF_STATE_IS_NULL(211,"员工状态为空"),
    STAFF_DEPTID_IS_NULL(212,"员工部门为空"),
    STAFF_ROLEID_IS_NULL(213,"员工角色为空"),
    STAFF_ID_IS_NULL(214,"员工id为空"),
    STAFF_IS_NULL(215,"员工信息不存在数据库"),
    OLD_PASSWORD_IS_NULL(216,"旧密码为空"),
    NEW_PASSWORD_IS_NULL(217,"新密码为空"),
    ROLE_NAME_IS_NULL(218,"角色名字为空"),
    SUPERIORID_IS_NULL(219,"角色上级id为空"),
    PERMISSION_IS_NULL(220,"角色权限为空"),
    ROLEID_IS_NULL(221,"角色权限id为空"),
    ROLE_IS_NULL(222,"角色信息不存在数据库中"),
    ROLEID_NOT_LEGAL(223,"角色id不合法"),
    STAFF_STILL_HAS_ROLE(224,"还有员工是该角色,无法删除"),
    DEPT_NAME_IS_NULL(225,"部门名字为空"),
    DEPT_SUPERIORID_IS_NULL(226,"部门上级名字为空"),
    DEPTID_IS_NULL(227,"部门id为空"),
    DEPT_IS_NULL(228,"部门信息不存在数据库中"),
    DEPTID_NOT_LEGAL(229,"部门id不合法"),
    STAFF_STILL_HAS_DEPT(230,"还有员工是该部门,无法删除"),
    DEPT_NAME_ALREADY_EXISTED(231,"部门名字已经存在"),
    
    // 鲜攀 start
    CANDIDATE_INFO_VO_NULL_VALUE(102,"应聘人信息空值"),
    CANDIDATE_NAME_IS_NULL(103,"应聘人名字为空"),
    CANDIDATE_PHONE_NUMBER_IS_NULL(104,"应聘人电话号码为空"),
    CANDIDATE_SEX_IS_NULL(105,"应聘人性别为空"),
    CANDIDATE_BIRTHDAY_IS_NULL(106,"应聘人出生年月为空"),
    CANDIDATE_EDUCATION_IS_NULL(107,"应聘人学历为空"),
    CANDIDATE_IDENTITY_CARD_IS_NULL(108,"应聘人身份证为空"),
    IS_HIRE_IS_NULL(109,"应聘人身份证为空"),
    CANDIDATE_ID_IS_NULL(110,"应聘人id为空"),
    RECRUITMENT_INFORMATION_VO_IS_NULL(111,"招聘信息为空"),
    APPLY_JOB_IS_NULL(112,"应聘岗位为空"),
    CREATED_NAME_IS_NULL(113,"创建人姓名为空"),
    INVITE_DATE_IS_NULL(114,"邀约日期为空"),
    RECRUITMENT_CHANNEL_IS_NULL(115,"招聘渠道为空"),
    REMARK_IS_NULL(116,"备注为空"),
    SUCCESS(200, "成功"),
	
	//3**开头的报错
	IS_CHECKED_FLAG_IS_NULL_OR_EMPTY(301,"核款成功标志为空"),
	ORDER_ID_IS_NULL(302,"订单id为空"),
	EXCEPT_ORDER_ID_OTHERS_ARE_ALL_NULL(303,"除订单id外其他字段都为空");

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Integer code;
    private String msg;


    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }
}