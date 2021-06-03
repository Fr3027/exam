/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : examsystem

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 15/03/2020 15:23:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for answer_input
-- ----------------------------
DROP TABLE IF EXISTS `answer_input`;
CREATE TABLE `answer_input` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paperid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `questionid` int(11) DEFAULT NULL,
  `input` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of answer_input
-- ----------------------------
BEGIN;
INSERT INTO `answer_input` VALUES (1, 2, 111, 51, '编译连接', '源代码是怎么变成可执行文件的，每一步的作用是什么');
COMMIT;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `teacherid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
BEGIN;
INSERT INTO `course` VALUES (4, '汇编语言', '深入计算机底层，巩固基础知识。', 111);
INSERT INTO `course` VALUES (5, 'C语言程序设计', '软件工程师的入门课程。', 111);
COMMIT;

-- ----------------------------
-- Table structure for identification
-- ----------------------------
DROP TABLE IF EXISTS `identification`;
CREATE TABLE `identification` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `grade` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `classname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of identification
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseid` int(11) DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `count1` int(11) DEFAULT NULL,
  `difficulty1` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `count2` int(11) DEFAULT NULL,
  `difficulty2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `count3` int(11) DEFAULT NULL,
  `difficulty3` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `count4` int(11) DEFAULT NULL,
  `difficulty4` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of paper
-- ----------------------------
BEGIN;
INSERT INTO `paper` VALUES (1, 4, '汇编语言期末考试', 'come on!', 111, '2020-03-12', 10, '简单', 7, '简单', 8, '简单', 2, '简单');
INSERT INTO `paper` VALUES (2, 4, '汇编语言期中考试', '汇编语言期中考试', 111, '2020-03-12', 10, '简单', 5, '简单', 5, '简单', 1, '简单');
COMMIT;

-- ----------------------------
-- Table structure for paper_history
-- ----------------------------
DROP TABLE IF EXISTS `paper_history`;
CREATE TABLE `paper_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `paperid` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '待批改',
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of paper_history
-- ----------------------------
BEGIN;
INSERT INTO `paper_history` VALUES (1, 111, 2, '2020-03-13', 23, '已批阅', '汇编语言期中考试');
COMMIT;

-- ----------------------------
-- Table structure for paper_map
-- ----------------------------
DROP TABLE IF EXISTS `paper_map`;
CREATE TABLE `paper_map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paperid` int(11) DEFAULT NULL,
  `questionid` int(11) DEFAULT NULL,
  `questiontype` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `paperhistoryid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of paper_map
-- ----------------------------
BEGIN;
INSERT INTO `paper_map` VALUES (1, 2, 13, '单选题', 1);
INSERT INTO `paper_map` VALUES (2, 2, 23, '单选题', 1);
INSERT INTO `paper_map` VALUES (3, 2, 24, '单选题', 1);
INSERT INTO `paper_map` VALUES (4, 2, 3, '单选题', 1);
INSERT INTO `paper_map` VALUES (5, 2, 8, '单选题', 1);
INSERT INTO `paper_map` VALUES (6, 2, 22, '单选题', 1);
INSERT INTO `paper_map` VALUES (7, 2, 27, '单选题', 1);
INSERT INTO `paper_map` VALUES (8, 2, 11, '单选题', 1);
INSERT INTO `paper_map` VALUES (9, 2, 14, '单选题', 1);
INSERT INTO `paper_map` VALUES (10, 2, 9, '单选题', 1);
INSERT INTO `paper_map` VALUES (11, 2, 32, '填空题', 1);
INSERT INTO `paper_map` VALUES (12, 2, 40, '填空题', 1);
INSERT INTO `paper_map` VALUES (13, 2, 33, '填空题', 1);
INSERT INTO `paper_map` VALUES (14, 2, 7, '填空题', 1);
INSERT INTO `paper_map` VALUES (15, 2, 2, '填空题', 1);
INSERT INTO `paper_map` VALUES (16, 2, 48, '判断题', 1);
INSERT INTO `paper_map` VALUES (17, 2, 46, '判断题', 1);
INSERT INTO `paper_map` VALUES (18, 2, 44, '判断题', 1);
INSERT INTO `paper_map` VALUES (19, 2, 45, '判断题', 1);
INSERT INTO `paper_map` VALUES (20, 2, 47, '判断题', 1);
INSERT INTO `paper_map` VALUES (21, 2, 51, '简答题', 1);
COMMIT;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseid` int(11) DEFAULT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `choicea` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `choiceb` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `choicec` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `choiced` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `answer` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `input` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `difficulty` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of question
-- ----------------------------
BEGIN;
INSERT INTO `question` VALUES (2, 4, '填空题', NULL, NULL, NULL, NULL, 'mov', NULL, '简单', '（　）可用于寄存器间的数据传送。');
INSERT INTO `question` VALUES (3, 4, '单选题', 'add', 'sub', 'diff', 'mov', 'A', NULL, '简单', '以下哪下指令可用于寄存器数据的加法运算');
INSERT INTO `question` VALUES (4, 4, '判断题', NULL, NULL, NULL, NULL, '正确', NULL, '一般', '8086CPU地址总线为20位。');
INSERT INTO `question` VALUES (5, 4, '简答题', NULL, NULL, NULL, NULL, NULL, NULL, '简单', '请简述8086CPU的寻址过程。');
INSERT INTO `question` VALUES (6, 4, '判断题', NULL, NULL, NULL, NULL, '正确', NULL, '简单', 'CPU地址总线的位数与寻址能力呈正相关');
INSERT INTO `question` VALUES (7, 4, '填空题', NULL, NULL, NULL, NULL, '64KB', NULL, '简单', '8086不采用地址分段时，寻址范围为()');
INSERT INTO `question` VALUES (8, 4, '单选题', 'of=1', 'cf=1', 'sf=1', 'zf=1', 'C', NULL, '简单', '(ax)=10,执行一下指令后，下列标志位正确的是');
INSERT INTO `question` VALUES (9, 4, '单选题', '57FFH', 'D7FFH', '876EH', '57FBH', 'B', NULL, '简单', '若（AX）=506EH,（CX）=87FBH，当OR  AX，CX指令执行后，(AX)=（    ）。');
INSERT INTO `question` VALUES (10, 4, '单选题', '用户软件', '系统软件', '高级语言', '低级语言', 'D', NULL, '简单', '汇编语言属于（  ）');
INSERT INTO `question` VALUES (11, 4, '单选题', 'EXE', 'OBJ', 'ASM', 'LST', 'B', NULL, '简单', '汇编语言源程序经汇编程序汇编后产生的文件的扩展名是（  ）');
INSERT INTO `question` VALUES (12, 4, '单选题', '运算器', '控制器', '寄存器组', '前三者', 'D', NULL, '简单', '中央处理器CPU是由（  ）组成的');
INSERT INTO `question` VALUES (13, 4, '单选题', '用户软件', '系统软件', '系统硬件', '一种语言', 'B', NULL, '简单', 'IBM PC机的DOS是属于（ ）');
INSERT INTO `question` VALUES (14, 4, '单选题', '10', '12', '13', '14', 'D', NULL, '简单', '8086/8088 CPU的寄存器组中，16位的寄存器共有（  ）个');
INSERT INTO `question` VALUES (15, 4, '单选题', '上一条指令的首地址', '本条指令的首地址', '下一条指令的首地址', '需计算有效地址后才能确定地址', 'C', NULL, '简单', '在程序执行过程中，IP寄存器始终保存的是（  ）');
INSERT INTO `question` VALUES (16, 4, '单选题', 'PF', 'CF', 'OF', 'SF', 'A', NULL, '简单', '如果指令的运算结果中有奇数个１，则（  ）标志位为０');
INSERT INTO `question` VALUES (17, 4, '单选题', '位', '字节', '字', '双字', 'B', NULL, '简单', 'IBM PC机的内存是按（ ）是编址的');
INSERT INTO `question` VALUES (18, 4, '单选题', '1', '2', '3', '4', 'B', NULL, '简单', '如果某个字变量的数据存放在奇地址单元，则8086/8088 CPU读写该变量时需要（  ）个读写周期');
INSERT INTO `question` VALUES (19, 4, '单选题', '逻辑', '物理', '有效', '相对', 'B', NULL, '简单', '在机器内部操作中，CPU与存储器之间的任何信息交换使用的都是（  ）地址');
INSERT INTO `question` VALUES (20, 4, '单选题', '0~65535', '0000H~0FFFH', '8000H~7FFFH', '8000H~FFFFH', 'C', NULL, '简单', '一个１６位相对位移的范围是（  ）');
INSERT INTO `question` VALUES (21, 4, '单选题', '1201FH', '12000H', '1201EH', '12020H', 'C', NULL, '简单', '如果一个字变量中存放16个字，该字变量的起始地址为1000H：2000H，则该字变量数据区中的最末一个字单元的物理地址为（ ）');
INSERT INTO `question` VALUES (22, 4, '单选题', '12H', '34H', '3412H', '1234H', 'C', NULL, '简单', '设22000H、22001H单元分别存放的数据为12H、34H，若要读取22000H字单元中的数据，此时读出的数据是（ ）');
INSERT INTO `question` VALUES (23, 4, '单选题', '不同类型的机器字长是一样的', '一个字节有８位二进制数', '各种不同的机器指令系统都是一样的', '机器指令都是８位的', 'B', NULL, '简单', '下列叙述正确的是（  ）');
INSERT INTO `question` VALUES (24, 4, '单选题', '5000H', '5008H', '23008H', '32008H', 'B', NULL, '简单', '设BX=2000H，SI=3000H，指令MOV AX，[BX+SI+8]的源操作有效地址为（ ）');
INSERT INTO `question` VALUES (25, 4, '单选题', '20200H', '30200H', '50200H', '200H', 'B', NULL, '简单', '设DS=2000H，ES=3000H，SI=200H，指令MOV ES：[SI]，AL的目的操作数的物理地址为（  ）');
INSERT INTO `question` VALUES (26, 4, '单选题', 'CS', 'DS', 'SS', 'ES', 'C', NULL, '简单', '指令MOV BX，[BP+5]中的源操作数使用（  ）段寄存器');
INSERT INTO `question` VALUES (27, 4, '单选题', 'CS', 'IP', 'CS和IP', 'PSW', 'C', NULL, '简单', '段间间接寻址只改变（  ）中的内容');
INSERT INTO `question` VALUES (28, 4, '单选题', 'MOV AX，BX', 'AND AL，0FH', 'SHR BX，CL', 'ADD AL，BL', 'A', NULL, '简单', '下述指令中不改变PSW的指令是（  ）');
INSERT INTO `question` VALUES (29, 4, '填空题', NULL, NULL, NULL, NULL, '汇编', NULL, '简单', '()指令是机器指令的助记符，与机器指令一一对应');
INSERT INTO `question` VALUES (30, 4, '填空题', NULL, NULL, NULL, NULL, 'CPU', NULL, '简单', '每一种（）都有自己的汇编指令集');
INSERT INTO `question` VALUES (31, 4, '填空题', NULL, NULL, NULL, NULL, '分段', NULL, '简单', '在8086/8088系统中，存储器物理地址是（）组织的');
INSERT INTO `question` VALUES (32, 4, '填空题', NULL, NULL, NULL, NULL, 'SS', NULL, '简单', '堆栈段的段地址存放在_____寄存器中');
INSERT INTO `question` VALUES (33, 4, '填空题', NULL, NULL, NULL, NULL, 'SP', NULL, '简单', '栈顶数据的偏移地址放在_____寄存器中');
INSERT INTO `question` VALUES (34, 4, '填空题', NULL, NULL, NULL, NULL, 'CS', NULL, '简单', '代码段的段地址存放在_____寄存器中');
INSERT INTO `question` VALUES (35, 4, '填空题', NULL, NULL, NULL, NULL, '67A00H', NULL, '简单', '已知DS=29A0H，某数据的物理地址是2A400H，则当DS=6700H时，该数据的物理地址是_____');
INSERT INTO `question` VALUES (36, 4, '填空题', NULL, NULL, NULL, NULL, '位', NULL, '简单', '逻辑运算指令都是按_____操作的');
INSERT INTO `question` VALUES (37, 4, '填空题', NULL, NULL, NULL, NULL, 'NOT', NULL, '简单', '其中_____指令执行后不影响任何标志位');
INSERT INTO `question` VALUES (38, 4, '填空题', NULL, NULL, NULL, NULL, '255', NULL, '简单', '有指令MOV CL，N，要使该指令合法，则N的最大值是_____');
INSERT INTO `question` VALUES (39, 4, '填空题', NULL, NULL, NULL, NULL, '0x8044', NULL, '简单', '已知寄存器edx内的数值为0x8000，ecx内的则为0x10；请给出地址表达式 0x4 (%edx,%ecx,4)所表示的地址值。');
INSERT INTO `question` VALUES (40, 4, '填空题', NULL, NULL, NULL, NULL, '16', NULL, '简单', 'x86-64体系结构具有（）个通用寄存器');
INSERT INTO `question` VALUES (41, 4, '填空题', NULL, NULL, NULL, NULL, '输入参数', NULL, '简单', '在X86-32位体系结构中，当前运行函数的帧（Frame）基址寄存器所指向的栈地址的“上方”（高地址）由低到高存放的是函数返回地址____');
INSERT INTO `question` VALUES (42, 4, '判断题', NULL, NULL, NULL, NULL, '错误', NULL, '简单', 'BX是累加器、DX是计数器');
INSERT INTO `question` VALUES (43, 4, '判断题', NULL, NULL, NULL, NULL, '错误', NULL, '简单', '假设存储器中从7462H单元开始的四个相邻字节单元中的内容依次是32H，46H，52H，0FEH，则存放字数据0FE52H的字地址是7465H');
INSERT INTO `question` VALUES (44, 4, '判断题', NULL, NULL, NULL, NULL, '错误', NULL, '简单', 'MOV AX，[BP]的源操作数的物理地址为16*(DS)+(BP)');
INSERT INTO `question` VALUES (45, 4, '判断题', NULL, NULL, NULL, NULL, '正确', NULL, '简单', 'MOV指令不影响标志位');
INSERT INTO `question` VALUES (46, 4, '判断题', NULL, NULL, NULL, NULL, '错误', NULL, '简单', '无条件转移指令对标志位无影响，而条件转移指令对标志位有影响');
INSERT INTO `question` VALUES (47, 4, '判断题', NULL, NULL, NULL, NULL, '正确', NULL, '简单', '指令IN AL，DX是合法的指令。');
INSERT INTO `question` VALUES (48, 4, '判断题', NULL, NULL, NULL, NULL, '错误', NULL, '简单', '当运算结果的低8位中有偶数个1 时, 奇偶标志位PF被置为1。');
INSERT INTO `question` VALUES (49, 4, '判断题', NULL, NULL, NULL, NULL, '正确', NULL, '简单', '汇编语言源程序不一定包含数据段、堆栈段，但必须包含代码段');
INSERT INTO `question` VALUES (50, 4, '判断题', NULL, NULL, NULL, NULL, '错误', NULL, '简单', '在“IN  AL，端口地址”指令中，端口地址指定了某个外部设备接口的I/O地址，它 实际上是一个立即数，其范围为0~65535。');
INSERT INTO `question` VALUES (51, 4, '简答题', NULL, NULL, NULL, NULL, NULL, NULL, '简单', '源代码是怎么变成可执行文件的，每一步的作用是什么');
INSERT INTO `question` VALUES (52, 4, '简答题', NULL, NULL, NULL, NULL, NULL, NULL, '简单', '应用层、API、运行库、系统调用、操作系统内核之间的关系是什么？');
INSERT INTO `question` VALUES (53, 4, '简答题', NULL, NULL, NULL, NULL, NULL, NULL, '简单', '虚拟内存空间是什么，为什么要有虚拟内存空间');
INSERT INTO `question` VALUES (54, 4, '简答题', NULL, NULL, NULL, NULL, NULL, NULL, '简单', '静态链接和动态链接分别表示什么，大概是怎么实现的');
INSERT INTO `question` VALUES (55, 4, '简答题', NULL, NULL, NULL, NULL, NULL, NULL, '简单', '可执行文件的结构如何？（分为哪些段）');
INSERT INTO `question` VALUES (56, 4, '简答题', NULL, NULL, NULL, NULL, NULL, NULL, '简单', '可执行文件是怎么装载进内存的，为什么要分段，分页，页错误是什么');
INSERT INTO `question` VALUES (57, 4, '简答题', NULL, NULL, NULL, NULL, NULL, NULL, '简单', '进程的内存格局是怎样的？');
INSERT INTO `question` VALUES (58, 4, '简答题', NULL, NULL, NULL, NULL, NULL, NULL, '简单', '堆和栈的区别，函数调用和栈的关系');
INSERT INTO `question` VALUES (59, 4, '简答题', NULL, NULL, NULL, NULL, NULL, NULL, '简单', '进程和线程的区别');
INSERT INTO `question` VALUES (60, 5, '判断题', NULL, NULL, NULL, NULL, '错误', NULL, '简单', 'C语言中可以使用cin');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `username` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `major` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `usertype` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (111, '王雨', 'shadow@163.com', '123', '计算机科学与技术', '老师');
INSERT INTO `user` VALUES (112, '张三', 'admin1', '123', '计算机科学与技术', '管理员');
INSERT INTO `user` VALUES (113, '李扬', '2020200202', '123', '软件工程', '学生');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
