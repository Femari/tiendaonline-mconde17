/*==============================================================*/
/* Table: COMMENTS                                               */
/*==============================================================*/
create table COMMENTS
(
   COMMENTID            varchar(30) not null,
   PRODUCTID            varchar(30) not null,
   USEREMAIL            varchar(60) not null,
   COMMENTDATE          varchar(30) not null,
   COMMENTCONTENT       varchar(600) not null,
   primary key (COMMENTID)
);

/*==============================================================*/
/* Table: PRODUCTS                                               */
/*==============================================================*/
create table PRODUCTS
(
   PRODUCTID            varchar(30) not null,
   PRODUCTPRICE         decimal(8,2) not null,
   PRODUCTSHORTDESCRIPTION varchar(60) not null,
   PRODUCTLONGDESCRIPTION varchar(600) not null,
   PRODUCTSTOCK         int not null,
   PRODUCTIMAGE         longblob not null,
   primary key (PRODUCTID)
);

/*==============================================================*/
/* Table: SALES                                                  */
/*==============================================================*/
create table SALES
(
   SALEID               varchar(30) not null,
   USEREMAIL            varchar(60) not null,
   SALEPAYMENTMETHOD    varchar(30) not null,
   SALEDATE             varchar(30) not null,
   primary key (SALEID)
);

/*==============================================================*/
/* Table: SHOPPINGCARTS                                          */
/*==============================================================*/
create table SHOPPINGCARTS
(
   PRODUCTID            varchar(30) not null,
   SALEID               varchar(30) not null,
   PRODUCTAMOUNT        int not null
);

/*==============================================================*/
/* Table: USERS                                                  */
/*==============================================================*/
create table USERS
(
   USERNAME             varchar(30) not null,
   USERSURNAMES         varchar(120) not null,
   USERADRESS           varchar(240) not null,
   USEREMAIL            varchar(60) not null,
   USERPASSWORD         varchar(30) not null,
   USERPRIVILEGED       bool not null,
   primary key (USEREMAIL)
);

alter table COMMENTS add constraint FK_PRODUCT_COMMENT foreign key (PRODUCTID)
      references PRODUCTS (PRODUCTID) on delete restrict on update restrict;

alter table COMMENTS add constraint FK_USER_COMMENT foreign key (USEREMAIL)
      references USERS (USEREMAIL) on delete restrict on update restrict;

alter table SALES add constraint FK_USER_SALE foreign key (USEREMAIL)
      references USERS (USEREMAIL) on delete restrict on update restrict;

alter table SHOPPINGCARTS add constraint FK_PRODUCT_SHOPPINGCART foreign key (PRODUCTID)
      references PRODUCTS (PRODUCTID) on delete restrict on update restrict;

alter table SHOPPINGCARTS add constraint FK_SALE_SHOPPINGCART foreign key (SALEID)
      references SALES (SALEID) on delete restrict on update restrict;

