CREATE DATABASE oromart;

USE oromart;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(100) NOT NULL,
    created_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS product;
CREATE TABLE product (
    product_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(200) NOT NULL,
    price DECIMAL(10,2) NOT NULL,   -- 0.00 ~ 99999999.99
    stock INT NOT NULL DEFAULT 0,
    status TINYINT DEFAULT 1,  -- 1:上架 0:下架
    created_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
    -- 额外：图片-图床、商品介绍页面
);

DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (  -- 和ORDER关键字重名，需要用反引号包围。不推荐用t_前缀
    order_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_no VARCHAR(50) UNIQUE NOT NULL,
    user_id BIGINT NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    pay_amount DECIMAL(10,2) NOT NULL,  -- 考虑满减、折扣
    status TINYINT DEFAULT 0,  -- 0:待支付 1:已支付
    coupon_id BIGINT,          -- 使用的优惠券，大部分平台都只允许一个订单用一张优惠券
    created_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    paid_time DATETIME
);

DROP TABLE IF EXISTS order_product;
CREATE TABLE order_product (
    order_product_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    order_id BIGINT NOT NULL,
    product_id BIGINT NOT NULL,
    product_name VARCHAR(200) NOT NULL,  -- 价格快照
    product_price DECIMAL(10,2) NOT NULL,
    quantity INT NOT NULL,
    INDEX idx_order_id(order_id)
);

DROP TABLE IF EXISTS coupon_template;
CREATE TABLE coupon_template (
    coupon_template_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    discount_type TINYINT NOT NULL,     -- 1:满减 2:折扣 3:直减
    grant_type TINYINT NOT NULL,        -- 1:用户领取，2:系统批量发放，3:兑换码兑换
    valid_type TINYINT NOT NULL,        -- 1:固定时间段，2:有效期
    rule VARCHAR(500) NOT NULL,         -- 规则JSON，包含常用信息
    total_count INT NOT NULL,           -- 总数量
    remaining_count bigint NOT NULL,
    used_count INT DEFAULT 0,
    status TINYINT DEFAULT 1,
    created_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_time DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

DROP TABLE IF EXISTS coupon;
CREATE TABLE coupon (
    coupon_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    template_id BIGINT NOT NULL,
    status TINYINT DEFAULT 0,  -- 0:未使用 1:已使用 2:已过期
    order_id BIGINT,           -- 使用的订单ID
    received_time DATETIME DEFAULT CURRENT_TIMESTAMP,
    expire_time DATETIME,
    used_time DATETIME,
    INDEX idx_user_id(user_id),
    INDEX idx_status(status)
);
