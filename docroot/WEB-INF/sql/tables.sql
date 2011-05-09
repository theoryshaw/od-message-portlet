create table PR_PRProduct (
	productId LONG not null primary key,
	productName VARCHAR(75) null,
	serialNumber VARCHAR(75) null,
	companyId LONG,
	groupId LONG
);

create table SK_SKQuestion (
	Question_ID LONG not null primary key,
	Parent_ID LONG,
	Title VARCHAR(75) null,
	Url STRING null,
	Post_Date LONG,
	User_ID LONG,
	companyId LONG,
	groupId LONG
);