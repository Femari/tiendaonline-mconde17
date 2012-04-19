alter table COMMENTS
   drop constraint FK_PRODUCT_COMMENT;

alter table COMMENTS
   drop constraint FK_USER_COMMENT;

alter table SALES
   drop constraint FK_USER_SALE;

alter table SHOPPINGCARTS
   drop constraint FK_PRODUCT_SHOPPINGCART;

alter table SHOPPINGCARTS
   drop constraint FK_SALE_SHOPPINGCART;

drop table if exists COMMENTS;

drop table if exists PRODUCTS;

drop table if exists SALES;

drop table if exists SHOPPINGCARTS;

drop table if exists USERS;