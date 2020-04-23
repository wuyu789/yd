-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- Server version:               8.0.15 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL 版本:                  10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table ttf_crm.back_order
CREATE TABLE IF NOT EXISTS `back_order` (
  `back_order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '退货订单id 退货订单id',
  `customer_id` int(11) NOT NULL COMMENT '客户id 客户id',
  `mach_id` varchar(32) NOT NULL COMMENT '机具号id 机具号id',
  `courier_number` varchar(32) NOT NULL COMMENT '快递单号 快递单号',
  `express_type_id` int(11) NOT NULL COMMENT '快递类型id 快递类型id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间 创建时间',
  PRIMARY KEY (`back_order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='退货订单表 ';

-- Dumping data for table ttf_crm.back_order: ~0 rows (approximately)
/*!40000 ALTER TABLE `back_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `back_order` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.candidate_info
CREATE TABLE IF NOT EXISTS `candidate_info` (
  `candidate_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '应聘人id 应聘人id',
  `candidate_name` varchar(8) NOT NULL COMMENT '应聘人姓名 应聘人姓名',
  `candidate_phone_number` varchar(32) NOT NULL DEFAULT '' COMMENT '应聘人电话 应聘人电话',
  `candidate_sex` char(1) NOT NULL DEFAULT '男' COMMENT '应聘人性别 应聘人性别',
  `candidate_birthday` date DEFAULT NULL COMMENT '应聘人出生年月 应聘人出生年月',
  `candidate_education` varchar(8) NOT NULL DEFAULT '' COMMENT '应聘人学历 应聘人学历',
  `candidate_identity_card` varchar(20) NOT NULL DEFAULT '' COMMENT '应聘人身份证号 应聘人身份证号',
  `is_hire` char(1) NOT NULL DEFAULT '0' COMMENT '是否录用 是否录用(0,未录用 1,已录用)',
  PRIMARY KEY (`candidate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='应聘人信息表 ';

-- Dumping data for table ttf_crm.candidate_info: ~0 rows (approximately)
/*!40000 ALTER TABLE `candidate_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `candidate_info` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.cash_earing
CREATE TABLE IF NOT EXISTS `cash_earing` (
  `cash_earing_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '交易收益id',
  `mach_id` varchar(32) NOT NULL COMMENT '机具序列号 机具序列号',
  `month_cash` decimal(32,8) NOT NULL COMMENT '月交易额 月交易额',
  `month_earing` decimal(32,8) NOT NULL COMMENT '月分润额 月分润额',
  `cash_month` date NOT NULL COMMENT '交易月份 交易月份',
  PRIMARY KEY (`cash_earing_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='交易收益表 ';

-- Dumping data for table ttf_crm.cash_earing: ~0 rows (approximately)
/*!40000 ALTER TABLE `cash_earing` DISABLE KEYS */;
/*!40000 ALTER TABLE `cash_earing` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.cost_profit
CREATE TABLE IF NOT EXISTS `cost_profit` (
  `cost_profit_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成本利润id 成本利润id',
  `staff_id` varchar(16) NOT NULL COMMENT '员工id 员工id',
  `month_salary` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '月薪资 月薪资',
  `staff_cost` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '员工成本 员工成本',
  `gross_profit` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '月利润毛利润 月利润毛利润',
  `retained_profits` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '月利润净利润 月利润净利润',
  PRIMARY KEY (`cost_profit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='成本与利润 ';

-- Dumping data for table ttf_crm.cost_profit: ~0 rows (approximately)
/*!40000 ALTER TABLE `cost_profit` DISABLE KEYS */;
/*!40000 ALTER TABLE `cost_profit` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '客户id 客户id',
  `customer_name` varchar(8) NOT NULL COMMENT '客户姓名 客户姓名',
  `customer_phone` varchar(16) NOT NULL DEFAULT '' COMMENT '客户电话 客户电话',
  `customer_address` varchar(32) NOT NULL COMMENT '客户地址 客户地址',
  `customer_weixin` varchar(16) NOT NULL DEFAULT '' COMMENT '客户微信号 客户微信号',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间 创建时间',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='客户表 ';

-- Dumping data for table ttf_crm.customer: ~0 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.dept
CREATE TABLE IF NOT EXISTS `dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门ID',
  `dept_name` varchar(16) NOT NULL DEFAULT '' COMMENT '部门名称',
  `superior_id` int(11) NOT NULL COMMENT '上级部门ID 为0时为最上级',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门表 ';

-- Dumping data for table ttf_crm.dept: ~0 rows (approximately)
/*!40000 ALTER TABLE `dept` DISABLE KEYS */;
/*!40000 ALTER TABLE `dept` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.expressage
CREATE TABLE IF NOT EXISTS `expressage` (
  `expressage_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '快递类型id 快递类型id',
  `expressage_name` varchar(16) NOT NULL COMMENT '快递类型名称 快递类型名称',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间 创建时间',
  PRIMARY KEY (`expressage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='快递类型表 ';

-- Dumping data for table ttf_crm.expressage: ~0 rows (approximately)
/*!40000 ALTER TABLE `expressage` DISABLE KEYS */;
/*!40000 ALTER TABLE `expressage` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.getcash_type
CREATE TABLE IF NOT EXISTS `getcash_type` (
  `getcash_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收款类型id',
  `getcash_type_name` varchar(16) NOT NULL COMMENT '收款类型名称 收款类型名称',
  PRIMARY KEY (`getcash_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='收款类型表 ';

-- Dumping data for table ttf_crm.getcash_type: ~0 rows (approximately)
/*!40000 ALTER TABLE `getcash_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `getcash_type` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.kpi_flow
CREATE TABLE IF NOT EXISTS `kpi_flow` (
  `kpi_flow_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流程id 流程id',
  `created_id` varchar(16) NOT NULL COMMENT '创建人 创建人',
  `during_inspection` varchar(32) NOT NULL COMMENT '考核期间 考核期间',
  `dept_id` int(11) NOT NULL COMMENT '部门 部门',
  `post` varchar(16) NOT NULL COMMENT '岗位 岗位',
  `flow_status` char(1) NOT NULL DEFAULT '1' COMMENT '流程状态 0打回，1通过,2审核中',
  `back_reason` varchar(32) NOT NULL DEFAULT '' COMMENT '打回原因 打回原因',
  `auditor_id` varchar(16) NOT NULL COMMENT '审核人 审核人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间 创建时间',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间 更新时间',
  PRIMARY KEY (`kpi_flow_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='kpi的流程表 ';

-- Dumping data for table ttf_crm.kpi_flow: ~0 rows (approximately)
/*!40000 ALTER TABLE `kpi_flow` DISABLE KEYS */;
/*!40000 ALTER TABLE `kpi_flow` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.machine
CREATE TABLE IF NOT EXISTS `machine` (
  `mach_id` varchar(32) NOT NULL COMMENT '机具序列号 机具序列号',
  `mach_type_id` char(1) NOT NULL COMMENT '机具类别ID 机具类别ID',
  `mach_name` varchar(16) NOT NULL COMMENT '机具名 机具名',
  `mach_price` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '机具价格 机具价格',
  `mach_buyer_id` int(11) NOT NULL COMMENT '机具购买者 机具购买者',
  `mach_buy_date` datetime DEFAULT NULL COMMENT '机具购买日期 机具购买日期',
  `is_active` char(1) NOT NULL DEFAULT '0' COMMENT '是否激活 是否激活(0,未激活 1,已激活)',
  `active_cash_rebate` int(11) NOT NULL DEFAULT '0' COMMENT '激活返机数量 激活返机数量',
  `active_mach_rebate` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '激活返现金额 激活返现金额',
  `mach_active_expired` int(11) DEFAULT NULL COMMENT '激活期限 激活期限',
  `mach_active_date` datetime DEFAULT NULL COMMENT '激活日期 激活日期',
  `is_pay` char(1) NOT NULL DEFAULT '0' COMMENT '是否需要支付服务费 是否需要支付服务费(0,不需要 1,需要)',
  `mach_pay_date` datetime DEFAULT NULL COMMENT '服务费付费时间 服务费付费时间',
  `mach_service_charge` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '应付服务费 应付服务费',
  `mach_delivery_date` datetime DEFAULT NULL COMMENT '发货时间 发货时间',
  `mach_order_id` int(11) NOT NULL COMMENT '订单ID 订单ID',
  `cash_rebate1` decimal(10,2) DEFAULT '0.00' COMMENT '第一次返现金额 第一次返现金额',
  `cash_rebate1_date` datetime DEFAULT NULL COMMENT '第一次返利日期 第一次返利日期',
  `cash_rebate2` decimal(10,2) DEFAULT '0.00' COMMENT '第二次返现金额 第二次返现金额',
  `cash_rebate2_date` datetime DEFAULT NULL COMMENT '第二次返利日期 第二次返利日期',
  `cash_rebate3` decimal(10,2) DEFAULT '0.00' COMMENT '第三次返现金额 第三次返现金额',
  `cash_rebate3_date` datetime DEFAULT NULL COMMENT '第三次返利日期 第三次返利日期',
  `mach_rebate_reason` varchar(32) NOT NULL DEFAULT '' COMMENT '未返现原因 未返现原因',
  `is_delete` char(1) DEFAULT '0' COMMENT '是否删除 是否删除(0,不删除 1,删除)',
  PRIMARY KEY (`mach_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='机具表 ';

-- Dumping data for table ttf_crm.machine: ~0 rows (approximately)
/*!40000 ALTER TABLE `machine` DISABLE KEYS */;
/*!40000 ALTER TABLE `machine` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.machine_type
CREATE TABLE IF NOT EXISTS `machine_type` (
  `machine_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '机具类型id 机具类型id',
  `machine_type_name` varchar(16) NOT NULL COMMENT '机具类型名字 机具类型名字',
  PRIMARY KEY (`machine_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='机具类型表 ';

-- Dumping data for table ttf_crm.machine_type: ~0 rows (approximately)
/*!40000 ALTER TABLE `machine_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `machine_type` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.order_management
CREATE TABLE IF NOT EXISTS `order_management` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单管理id 订单管理id',
  `customer_id` int(11) NOT NULL COMMENT '客户id 客户id',
  `telephone_operator_id` varchar(32) DEFAULT NULL COMMENT '话务员id 话务员id',
  `salesman_id` varchar(32) DEFAULT NULL COMMENT '业务员id 业务员id',
  `mach_id` varchar(32) NOT NULL COMMENT '机具序列号 机具序列号',
  `express_type_id` int(11) NOT NULL COMMENT '快递类型 快递类型',
  `amount_receivable` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '应收金额 应收金额',
  `paid_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '实收金额 实收金额',
  `collection_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '代收金额 代收金额',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间 创建时间',
  `is_bargain` char(1) DEFAULT '0' COMMENT '是否成交 是否成交(0,未成交 1, 已成交)',
  `customer_remark` varchar(32) NOT NULL DEFAULT '' COMMENT '客户备注 客户备注',
  `bargain_time` datetime DEFAULT NULL COMMENT '成交时间 成交时间',
  `get_time` datetime DEFAULT NULL COMMENT '业务员领取时间 业务员领取时间',
  `courier_number` varchar(32) NOT NULL DEFAULT '' COMMENT '快递单号 快递单号',
  `is_back` char(1) NOT NULL DEFAULT '0' COMMENT '是否退货 是否退货(0,未退货 1,已退货)',
  `getcash_time` datetime DEFAULT NULL COMMENT '收款时间 收款时间',
  `getcash_type_id` int(11) NOT NULL COMMENT '收款类型id 收款类型id',
  `cashcheck_flag` varchar(1) NOT NULL DEFAULT '0' COMMENT '核款成功标志 核款成功标志(0.未核款，1.已核款)',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单管理 ';

-- Dumping data for table ttf_crm.order_management: ~0 rows (approximately)
/*!40000 ALTER TABLE `order_management` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_management` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.permission
CREATE TABLE IF NOT EXISTS `permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限ID',
  `permission_name` varchar(32) NOT NULL DEFAULT '' COMMENT '权限名字',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '修改时间',
  `menu_type` varchar(1) NOT NULL DEFAULT '' COMMENT '菜单权限类别',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限表 ';

-- Dumping data for table ttf_crm.permission: ~0 rows (approximately)
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.personal_kpi
CREATE TABLE IF NOT EXISTS `personal_kpi` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id 主键id',
  `target_classification_id` int(11) NOT NULL COMMENT '指标分类id 指标分类id',
  `kpi_flow_id` int(11) NOT NULL COMMENT '流程id 流程id',
  `examination_item` varchar(16) NOT NULL DEFAULT '' COMMENT '考核项目 考核项目',
  `Index_definition` varchar(16) NOT NULL DEFAULT '' COMMENT '指标定义 指标定义',
  `inspection_instructions` varchar(64) NOT NULL DEFAULT '' COMMENT '考核说明 考核说明',
  `reference_data` varchar(32) NOT NULL DEFAULT '' COMMENT '参考资料 参考资料',
  `index_weight` varchar(16) NOT NULL DEFAULT '' COMMENT '指标权重 指标权重',
  `grade` varchar(16) NOT NULL DEFAULT '' COMMENT '评分 评分',
  `score_shows` varchar(64) NOT NULL DEFAULT '' COMMENT '评分说明 评分说明',
  `advantage` varchar(32) NOT NULL DEFAULT '' COMMENT '综合评估中的优势 综合评估中的优势',
  `foible` varchar(32) NOT NULL DEFAULT '' COMMENT '综合评估中的需改进 综合评估中的需改进',
  `evaluate_level` char(1) NOT NULL DEFAULT 'B' COMMENT '综合评价等级 综合评价等级(A杰出（在质量、效率等方面总是能超出预期地完成工作，展现出卓越的素质/能力），95分≤分数,B 胜任（总是能按时间、质量等目标完成工作任务，展现出优秀的素质/能力），80分≤分数<95分, C 需改进（在工作效率、质量、素质/能力等各方面还有未达到期望之处，需要改进），60分≤分数<80分,D 不合格（在工作效率、质量、素质/能力等各方面存在较多问题或较大差距），分数<60分)',
  `staff_id` varchar(16) NOT NULL COMMENT '被考核人 被考核人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间 创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间 更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='kpi列表 ';

-- Dumping data for table ttf_crm.personal_kpi: ~0 rows (approximately)
/*!40000 ALTER TABLE `personal_kpi` DISABLE KEYS */;
/*!40000 ALTER TABLE `personal_kpi` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.position_record
CREATE TABLE IF NOT EXISTS `position_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `staff_id` varchar(16) NOT NULL COMMENT '用户id 用户id',
  `old_role` varchar(16) NOT NULL COMMENT '旧职位 职位名称',
  `new_role` varchar(16) NOT NULL COMMENT '新职位 职位名称',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间 职位变动时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='职位变更记录（入职/离职） ';

-- Dumping data for table ttf_crm.position_record: ~0 rows (approximately)
/*!40000 ALTER TABLE `position_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `position_record` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.recruitment_information
CREATE TABLE IF NOT EXISTS `recruitment_information` (
  `recruitment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id 招聘信息id',
  `candidate_id` int(11) NOT NULL COMMENT '应聘人id 应聘人id',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间 创建时间',
  `created_name` varchar(8) NOT NULL DEFAULT '' COMMENT '创建人姓名 创建人姓名',
  `recruitment_channel` varchar(8) NOT NULL DEFAULT '' COMMENT '招聘渠道 招聘渠道',
  `apply_job` varchar(16) NOT NULL DEFAULT '' COMMENT '应聘岗位 应聘岗位',
  `remark` varchar(32) NOT NULL DEFAULT '' COMMENT '备注 备注',
  `invite_date` datetime DEFAULT NULL COMMENT '邀约日期 邀约日期',
  PRIMARY KEY (`recruitment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='招聘信息 ';

-- Dumping data for table ttf_crm.recruitment_information: ~0 rows (approximately)
/*!40000 ALTER TABLE `recruitment_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `recruitment_information` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.role
CREATE TABLE IF NOT EXISTS `role` (
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `permission_ids` int(11) NOT NULL COMMENT '权限ID',
  `role_name` varchar(16) NOT NULL DEFAULT '' COMMENT '角色名称',
  `superior_id` int(11) NOT NULL COMMENT '上级角色ID',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '修改时间',
  `is_manger` varchar(1) NOT NULL DEFAULT '0' COMMENT '是否为部门管理者 0不是，1是',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表 ';

-- Dumping data for table ttf_crm.role: ~0 rows (approximately)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.salary_management
CREATE TABLE IF NOT EXISTS `salary_management` (
  `salary_management_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '薪资管理id 薪资管理id',
  `staff_id` varchar(16) NOT NULL COMMENT '员工id 员工id',
  `basics_salary` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '基础薪资 基础薪资',
  `performance_salary` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '绩效薪资 绩效薪资',
  `deduction_salary` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '提成薪资 提成薪资',
  `profit_salary` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '分红薪资 分红薪资',
  `prize` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '奖金 奖金',
  `total_salary` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '总薪资 总薪资',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间 创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '更新时间 更新时间',
  PRIMARY KEY (`salary_management_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='薪资管理 ';

-- Dumping data for table ttf_crm.salary_management: ~0 rows (approximately)
/*!40000 ALTER TABLE `salary_management` DISABLE KEYS */;
/*!40000 ALTER TABLE `salary_management` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.staff
CREATE TABLE IF NOT EXISTS `staff` (
  `staff_id` varchar(16) NOT NULL COMMENT '员工ID uuid生成',
  `staff_number` varchar(16) NOT NULL COMMENT '登录账号',
  `staff_name` varchar(8) NOT NULL COMMENT '员工姓名',
  `staff_state` char(1) NOT NULL DEFAULT '1' COMMENT '员工状态 0:已删除。1:使用中。',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime DEFAULT NULL COMMENT '修改时间',
  `staff_password` varchar(20) NOT NULL COMMENT '登陆密码',
  `role_id` int(11) NOT NULL COMMENT '角色ID 角色ID',
  `dept_id` int(11) NOT NULL COMMENT '部门ID 部门ID',
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='员工表 用户信息表';

-- Dumping data for table ttf_crm.staff: ~0 rows (approximately)
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.system_setting
CREATE TABLE IF NOT EXISTS `system_setting` (
  `setting_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统设置主键 系统设置主键',
  `get_num` int(11) NOT NULL COMMENT '号码领取数量 号码领取数量',
  PRIMARY KEY (`setting_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统设置表 ';

-- Dumping data for table ttf_crm.system_setting: ~0 rows (approximately)
/*!40000 ALTER TABLE `system_setting` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_setting` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.target_classification
CREATE TABLE IF NOT EXISTS `target_classification` (
  `target_classification_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '指标分类id 指标分类id',
  `target_classification_name` varchar(16) NOT NULL DEFAULT '' COMMENT '指标分类名字 指标分类名字',
  PRIMARY KEY (`target_classification_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='指标分类 ';

-- Dumping data for table ttf_crm.target_classification: ~0 rows (approximately)
/*!40000 ALTER TABLE `target_classification` DISABLE KEYS */;
/*!40000 ALTER TABLE `target_classification` ENABLE KEYS */;

-- Dumping structure for table ttf_crm.verify_management
CREATE TABLE IF NOT EXISTS `verify_management` (
  `verify_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '核款id 核款id',
  `order_id` int(11) NOT NULL COMMENT '订单id 订单id',
  `verify_person_id` int(11) NOT NULL COMMENT '核款人id 核款人id',
  `verify_money` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '核款金额 核款金额',
  `verify_date` datetime DEFAULT NULL COMMENT '核款时间 核款时间',
  PRIMARY KEY (`verify_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='核款管理 ';

-- Dumping data for table ttf_crm.verify_management: ~0 rows (approximately)
/*!40000 ALTER TABLE `verify_management` DISABLE KEYS */;
/*!40000 ALTER TABLE `verify_management` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
