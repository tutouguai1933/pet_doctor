CREATE DATABASE IF NOT EXISTS pet_doctor DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;


-- 1. 删除表的顺序依赖，防止外键约束问题
DROP TABLE IF EXISTS ConsultationMessage;
DROP TABLE IF EXISTS Consultation;
DROP TABLE IF EXISTS Prescription_Medicine;
DROP TABLE IF EXISTS Prescription;
DROP TABLE IF EXISTS Medicine_Symptom;
DROP TABLE IF EXISTS Symptom_Doctor;
DROP TABLE IF EXISTS HotConcern;
DROP TABLE IF EXISTS Symptom;
DROP TABLE IF EXISTS RecommendedProduct;
DROP TABLE IF EXISTS Promotion_Product;
DROP TABLE IF EXISTS Promotion;
DROP TABLE IF EXISTS Order_Product;
DROP TABLE IF EXISTS `Order`;
DROP TABLE IF EXISTS Product;
DROP TABLE IF EXISTS Pet;
DROP TABLE IF EXISTS Doctor;
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS HealthStore;
DROP TABLE IF EXISTS MedicineCategory;
DROP TABLE IF EXISTS Medicine;

-- 2. 创建基础表

-- 用户表
CREATE TABLE User (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '用户的唯一标识',
    username VARCHAR(50) NOT NULL UNIQUE COMMENT '用户名，必须唯一',
    password VARCHAR(255) NOT NULL COMMENT '加密后的密码',
    phone_number VARCHAR(20) COMMENT '用户的手机号',
    avatar_url VARCHAR(255) COMMENT '用户头像的URL',
    registration_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '用户注册时间'
) COMMENT='用户表，存储宠物医生平台的用户信息';

-- 医生表
CREATE TABLE Doctor (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '医生的唯一标识',
    name VARCHAR(50) NOT NULL COMMENT '医生的姓名',
    license_number VARCHAR(20) NOT NULL UNIQUE COMMENT '医生的执业编号',
    specialization VARCHAR(255) COMMENT '医生擅长的专业方向',
    experience_years INT COMMENT '从业年限',
    rating FLOAT DEFAULT 0.0 COMMENT '医生的评分',
    profile_picture_url VARCHAR(255) COMMENT '医生头像的URL',
    consultation_price DECIMAL(10, 2) COMMENT '图文问诊价格',
    phone_consultation_price DECIMAL(10, 2) COMMENT '电话问诊价格',
    verified BOOLEAN DEFAULT FALSE COMMENT '医生是否认证'
) COMMENT='医生表，存储医生的基本信息和资质';

-- 宠物表
CREATE TABLE Pet (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '宠物的唯一标识',
    user_id BIGINT NOT NULL COMMENT '宠物主人ID，引用User表',
    name VARCHAR(50) COMMENT '宠物名称',
    breed VARCHAR(100) COMMENT '宠物品种',
    gender ENUM('male', 'female', 'neutered_male', 'spayed_female') COMMENT '宠物性别',
    birth_date DATE COMMENT '宠物出生日期',
    arrival_date DATE COMMENT '宠物到家日期',
    weight DECIMAL(5, 2) COMMENT '宠物体重（公斤）',
    health_record TEXT COMMENT '宠物的健康档案信息',
    FOREIGN KEY (user_id) REFERENCES User(id)
) COMMENT='宠物档案表，存储宠物的详细信息，包括品种、性别、体重等';

-- 3. 医疗相关表



-- 问诊记录表

DROP TABLE IF EXISTS Consultation;
CREATE TABLE Consultation (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '问诊的唯一标识',
    user_id BIGINT NOT NULL COMMENT '用户ID，引用User表',
    doctor_id BIGINT NOT NULL COMMENT '医生ID，引用Doctor表',
    pet_id BIGINT COMMENT '宠物ID，引用Pet表',
    consultation_type ENUM('text', 'phone') COMMENT '问诊类型，图文或电话',
    description TEXT COMMENT '问诊描述',
    status ENUM('pending', 'completed') DEFAULT 'pending' COMMENT '问诊状态',
    consultation_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '问诊创建时间',
    last_message_date DATETIME COMMENT '最后一条消息的时间',
    FOREIGN KEY (user_id) REFERENCES User(id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(id),
    FOREIGN KEY (pet_id) REFERENCES Pet(id)
) COMMENT='问诊表，存储问诊的基本信息';

-- 诊室记录表
DROP TABLE IF EXISTS ConsultationRecord;
DROP TABLE IF EXISTS ConsultationMessage;
CREATE TABLE ConsultationMessage (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '消息的唯一标识',
    consultation_id BIGINT NOT NULL COMMENT '问诊ID，引用Consultation表',
    sender ENUM('user', 'doctor') NOT NULL COMMENT '消息发送者（用户或医生）',
    message_type ENUM('text', 'voice') NOT NULL COMMENT '消息类型，文本或语音',
    message_content TEXT COMMENT '文本消息的内容',
    voice_url VARCHAR(255) COMMENT '语音消息的存储URL',
    send_time DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '消息发送的时间',
    FOREIGN KEY (consultation_id) REFERENCES Consultation(id)
) COMMENT='问诊消息表，存储用户和医生的每条对话信息';

-- 处方表
CREATE TABLE Prescription (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '处方的唯一标识',
    consultation_id BIGINT NOT NULL COMMENT '问诊ID，引用Consultation表',
    prescription_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '处方开具时间',
    FOREIGN KEY (consultation_id) REFERENCES Consultation(id)
) COMMENT='处方表，存储医生为用户开具的处方';

-- 药品表
CREATE TABLE Medicine (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '药品的唯一标识',
    name VARCHAR(100) NOT NULL COMMENT '药品名称',
    description TEXT COMMENT '药品描述',
    price DECIMAL(10, 2) NOT NULL COMMENT '药品价格',
    stock INT DEFAULT 0 COMMENT '药品库存数量'
) COMMENT='药品表，存储平台提供的药品信息';

-- 处方与药品的关联表
CREATE TABLE Prescription_Medicine (
    prescription_id BIGINT NOT NULL COMMENT '处方ID，引用Prescription表',
    medicine_id BIGINT NOT NULL COMMENT '药品ID，引用Medicine表',
    quantity INT NOT NULL COMMENT '药品数量',
    FOREIGN KEY (prescription_id) REFERENCES Prescription(id),
    FOREIGN KEY (medicine_id) REFERENCES Medicine(id),
    PRIMARY KEY (prescription_id, medicine_id)
) COMMENT='处方与药品的关联表，记录每张处方中的药品信息';

-- 4. 商品及订单相关表

-- 商品表
CREATE TABLE Product (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '商品的唯一标识',
    name VARCHAR(100) NOT NULL COMMENT '商品名称',
    description TEXT COMMENT '商品描述',
    price DECIMAL(10, 2) NOT NULL COMMENT '商品价格',
    stock INT DEFAULT 0 COMMENT '库存数量'
) COMMENT='商品表，存储平台出售的宠物商品信息';

-- 订单表
CREATE TABLE `Order` (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '订单的唯一标识',
    user_id BIGINT NOT NULL COMMENT '用户ID，引用User表',
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '订单日期',
    total_price DECIMAL(10, 2) COMMENT '订单总价',
    status ENUM('pending', 'paid', 'shipped', 'completed') DEFAULT 'pending' COMMENT '订单状态',
    FOREIGN KEY (user_id) REFERENCES User(id)
) COMMENT='订单表，记录用户在平台上的购买行为';

-- 订单与商品关联表
CREATE TABLE Order_Product (
    order_id BIGINT NOT NULL COMMENT '订单ID，引用Order表',
    product_id BIGINT NOT NULL COMMENT '商品ID，引用Product表',
    quantity INT NOT NULL COMMENT '商品购买数量',
    FOREIGN KEY (order_id) REFERENCES `Order`(id),
    FOREIGN KEY (product_id) REFERENCES Product(id),
    PRIMARY KEY (order_id, product_id)
) COMMENT='订单与商品关联表，记录订单中包含的商品及数量';

-- 5. 促销相关表

-- 促销活动表
CREATE TABLE Promotion (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '促销活动的唯一标识',
    name VARCHAR(100) NOT NULL COMMENT '促销活动名称',
    start_date DATE COMMENT '促销活动开始日期',
    end_date DATE COMMENT '促销活动结束日期',
    description TEXT COMMENT '促销活动描述'
) COMMENT='促销活动表，存储平台的促销活动信息';

-- 促销活动与商品的关联表
CREATE TABLE Promotion_Product (
    promotion_id BIGINT NOT NULL COMMENT '促销活动ID，引用Promotion表',
    product_id BIGINT NOT NULL COMMENT '商品ID，引用Product表',
    discount DECIMAL(10, 2) DEFAULT 0 COMMENT '促销折扣',
    FOREIGN KEY (promotion_id) REFERENCES Promotion(id),
    FOREIGN KEY (product_id) REFERENCES Product(id),
    PRIMARY KEY (promotion_id, product_id)
) COMMENT='促销活动与商品的关联表，记录促销活动涉及的商品';

-- 6. 推荐商品与热门关注表

-- 推荐商品表
CREATE TABLE RecommendedProduct (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '推荐商品的唯一标识',
    product_id BIGINT NOT NULL COMMENT '商品ID，引用Product表',
    recommendation_reason TEXT COMMENT '推荐理由，描述该商品为何被推荐',
    display_order INT DEFAULT 0 COMMENT '显示顺序，控制商品的展示顺序',
    FOREIGN KEY (product_id) REFERENCES Product(id)
) COMMENT='推荐商品表，存储系统推荐给用户的商品信息';

-- 症状表
CREATE TABLE Symptom (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '症状的唯一标识',
    name VARCHAR(100) NOT NULL COMMENT '症状名称',
    description TEXT COMMENT '症状的详细描述',
    category ENUM('cat', 'dog', 'small_pet', 'bird', 'fish') COMMENT '症状所属类别，标识是猫、狗还是其他宠物',
    advice TEXT COMMENT '医生的建议或预防措施'
) COMMENT='症状表，存储不同种类宠物的常见症状及相关建议';

-- 热门关注表
CREATE TABLE HotConcern (
    id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '热门关注的唯一标识',
    symptom_id BIGINT NOT NULL COMMENT '症状ID，引用Symptom表',
    category ENUM('cat', 'dog') NOT NULL COMMENT '类别，标识是猫还是狗相关的症状',
    display_order INT DEFAULT 0 COMMENT '显示顺序，控制热门关注的展示顺序',
    FOREIGN KEY (symptom_id) REFERENCES Symptom(id)
) COMMENT='热门关注表，存储用户热门查询的症状及分类信息';

-- 症状与药品的关联表
CREATE TABLE Medicine_Symptom (
    medicine_id BIGINT NOT NULL COMMENT '药品ID，引用Medicine表',
    symptom_id BIGINT NOT NULL COMMENT '症状ID，引用Symptom表',
    FOREIGN KEY (medicine_id) REFERENCES Medicine(id),
    FOREIGN KEY (symptom_id) REFERENCES Symptom(id),
    PRIMARY KEY (medicine_id, symptom_id)
) COMMENT='药品与症状关联表，存储能够缓解某些症状的药品信息';

-- 症状与医生的推荐表
CREATE TABLE Symptom_Doctor (
    symptom_id BIGINT NOT NULL COMMENT '症状ID，引用Symptom表',
    doctor_id BIGINT NOT NULL COMMENT '医生ID，引用Doctor表',
    recommendation_level INT DEFAULT 0 COMMENT '推荐等级，值越大越推荐',
    FOREIGN KEY (symptom_id) REFERENCES Symptom(id),
    FOREIGN KEY (doctor_id) REFERENCES Doctor(id),
    PRIMARY KEY (symptom_id, doctor_id)
) COMMENT='症状与医生的推荐表，记录某症状推荐的医生及其推荐级别';