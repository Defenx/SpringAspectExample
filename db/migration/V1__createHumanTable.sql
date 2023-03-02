CREATE TABLE IF NOT EXISTS `human`
(

    `id`   bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name` varchar(50),
    `age`  int

) ENGINE = InnoDB
  DEFAULT CHARSET = UTF8;