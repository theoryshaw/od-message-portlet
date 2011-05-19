create table OD_QueryAndResponse (
	uuid_ VARCHAR(75) null,
	queryId LONG not null primary key,
	parentId LONG,
	title VARCHAR(1000) null,
	url VARCHAR(1000) null,
	createdAt DATE null,
	companyId LONG,
	groupId LONG,
	userId LONG
);